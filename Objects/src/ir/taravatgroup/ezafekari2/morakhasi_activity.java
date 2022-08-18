package ir.taravatgroup.ezafekari2;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class morakhasi_activity extends Activity implements B4AActivity{
	public static morakhasi_activity mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.morakhasi_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (morakhasi_activity).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.morakhasi_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.morakhasi_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (morakhasi_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (morakhasi_activity) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return morakhasi_activity.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (morakhasi_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (morakhasi_activity) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            morakhasi_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (morakhasi_activity) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_morakhasi = null;
public static int _mande_d = 0;
public static int _mande_h = 0;
public static int _mande_m = 0;
public static int _morkasidarmah_d = 0;
public static int _morkasidarmah_h = 0;
public static int _morkasidarmah_m = 0;
public static int _morakhasi_estefade_esteh = 0;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_mande_show = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mande_d = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mande_h = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mande_m = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_mande_ta_emroz = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_morakhasi_bihogog = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_morakhasi_bahogog = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_morakhasi_estelaj = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_morakhasi_estehgag = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_mande_ta_inendmah = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_mah = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_estehgag_darmah = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_box_edit = null;
public static int _index_box_edit = 0;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk_manfi = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_mandemorakh = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_help_mandeh = null;
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=29949952;
 //BA.debugLineNum = 29949952;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=29949954;
 //BA.debugLineNum = 29949954;BA.debugLine="Activity.LoadLayout(\"morakhasi_layout\")";
mostCurrent._activity.LoadLayout("morakhasi_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=29949956;
 //BA.debugLineNum = 29949956;BA.debugLine="ScrollView1.Panel.LoadLayout(\"morakhasi_item\")";
mostCurrent._scrollview1.getPanel().LoadLayout("morakhasi_item",mostCurrent.activityBA);
RDebugUtils.currentLine=29949957;
 //BA.debugLineNum = 29949957;BA.debugLine="get_mande_db";
_get_mande_db();
RDebugUtils.currentLine=29949959;
 //BA.debugLineNum = 29949959;BA.debugLine="lbl_mah.Text=Main.persianDate.PersianMonthName";
mostCurrent._lbl_mah.setText(BA.ObjectToCharSequence(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonthName()));
RDebugUtils.currentLine=29949962;
 //BA.debugLineNum = 29949962;BA.debugLine="pan_hed_mandeMorakh.Color=Main.color4";
mostCurrent._pan_hed_mandemorakh.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=29949963;
 //BA.debugLineNum = 29949963;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=29949965;
 //BA.debugLineNum = 29949965;BA.debugLine="End Sub";
return "";
}
public static String  _get_mande_db() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_mande_db", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_mande_db", null));}
RDebugUtils.currentLine=30015488;
 //BA.debugLineNum = 30015488;BA.debugLine="Sub get_mande_db";
RDebugUtils.currentLine=30015490;
 //BA.debugLineNum = 30015490;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=30015491;
 //BA.debugLineNum = 30015491;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=30015493;
 //BA.debugLineNum = 30015493;BA.debugLine="dbCode.res.Position=20 ''--------day------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (20));
RDebugUtils.currentLine=30015494;
 //BA.debugLineNum = 30015494;BA.debugLine="mande_d=dbCode.res.GetString(\"value\")";
_mande_d = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=30015496;
 //BA.debugLineNum = 30015496;BA.debugLine="dbCode.res.Position=21 ''--------hour------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (21));
RDebugUtils.currentLine=30015497;
 //BA.debugLineNum = 30015497;BA.debugLine="mande_h=dbCode.res.GetString(\"value\")";
_mande_h = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=30015499;
 //BA.debugLineNum = 30015499;BA.debugLine="dbCode.res.Position=22 ''--------min------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (22));
RDebugUtils.currentLine=30015500;
 //BA.debugLineNum = 30015500;BA.debugLine="mande_m=dbCode.res.GetString(\"value\")";
_mande_m = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=30015503;
 //BA.debugLineNum = 30015503;BA.debugLine="dbCode.res.Position=23";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (23));
RDebugUtils.currentLine=30015504;
 //BA.debugLineNum = 30015504;BA.debugLine="morkasiDarMah_d=dbCode.res.GetString(\"value\")";
_morkasidarmah_d = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=30015505;
 //BA.debugLineNum = 30015505;BA.debugLine="dbCode.res.Position=24";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (24));
RDebugUtils.currentLine=30015506;
 //BA.debugLineNum = 30015506;BA.debugLine="morkasiDarMah_h=dbCode.res.GetString(\"value\")";
_morkasidarmah_h = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=30015507;
 //BA.debugLineNum = 30015507;BA.debugLine="dbCode.res.Position=25";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (25));
RDebugUtils.currentLine=30015508;
 //BA.debugLineNum = 30015508;BA.debugLine="morkasiDarMah_m=dbCode.res.GetString(\"value\")";
_morkasidarmah_m = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=30015516;
 //BA.debugLineNum = 30015516;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=30015522;
 //BA.debugLineNum = 30015522;BA.debugLine="lbl_mande_show.Text=modify_str_showTime(mande_d,m";
mostCurrent._lbl_mande_show.setText(BA.ObjectToCharSequence(_modify_str_showtime(_mande_d,_mande_h,_mande_m)));
RDebugUtils.currentLine=30015523;
 //BA.debugLineNum = 30015523;BA.debugLine="lbl_estehgag_darMah.Text=modify_str_showTime(mork";
mostCurrent._lbl_estehgag_darmah.setText(BA.ObjectToCharSequence(_modify_str_showtime(_morkasidarmah_d,_morkasidarmah_h,_morkasidarmah_m)));
RDebugUtils.currentLine=30015525;
 //BA.debugLineNum = 30015525;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=30343168;
 //BA.debugLineNum = 30343168;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=30343169;
 //BA.debugLineNum = 30343169;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=30343170;
 //BA.debugLineNum = 30343170;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=30343171;
 //BA.debugLineNum = 30343171;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=30343173;
 //BA.debugLineNum = 30343173;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=30343175;
 //BA.debugLineNum = 30343175;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=30277632;
 //BA.debugLineNum = 30277632;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=30277634;
 //BA.debugLineNum = 30277634;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=30277635;
 //BA.debugLineNum = 30277635;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
RDebugUtils.currentLine=30212096;
 //BA.debugLineNum = 30212096;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=30212098;
 //BA.debugLineNum = 30212098;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=30146560;
 //BA.debugLineNum = 30146560;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=30146562;
 //BA.debugLineNum = 30146562;BA.debugLine="End Sub";
return "";
}
public static String  _all_morakhasiha_mah(String _year,String _moon,int _state) throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "all_morakhasiha_mah", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "all_morakhasiha_mah", new Object[] {_year,_moon,_state}));}
String _str = "";
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div1 = 0;
int _div2 = 0;
int _all_min = 0;
RDebugUtils.currentLine=30539776;
 //BA.debugLineNum = 30539776;BA.debugLine="Sub all_morakhasiha_mah(year As String, moon As St";
RDebugUtils.currentLine=30539777;
 //BA.debugLineNum = 30539777;BA.debugLine="Dim str As String";
_str = "";
RDebugUtils.currentLine=30539780;
 //BA.debugLineNum = 30539780;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=30539781;
 //BA.debugLineNum = 30539781;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=30539782;
 //BA.debugLineNum = 30539782;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=30539783;
 //BA.debugLineNum = 30539783;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
RDebugUtils.currentLine=30539784;
 //BA.debugLineNum = 30539784;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
RDebugUtils.currentLine=30539785;
 //BA.debugLineNum = 30539785;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=30539786;
 //BA.debugLineNum = 30539786;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state="+BA.NumberToString(_state))));
RDebugUtils.currentLine=30539787;
 //BA.debugLineNum = 30539787;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=30539789;
 //BA.debugLineNum = 30539789;BA.debugLine="v_day=v_day+dbCode.res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d"))));
RDebugUtils.currentLine=30539790;
 //BA.debugLineNum = 30539790;BA.debugLine="v_hour=v_hour+dbCode.res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h"))));
RDebugUtils.currentLine=30539791;
 //BA.debugLineNum = 30539791;BA.debugLine="v_min=v_min+dbCode.res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=30539795;
 //BA.debugLineNum = 30539795;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=30539796;
 //BA.debugLineNum = 30539796;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=30539799;
 //BA.debugLineNum = 30539799;BA.debugLine="Dim all_min As Int";
_all_min = 0;
RDebugUtils.currentLine=30539800;
 //BA.debugLineNum = 30539800;BA.debugLine="all_min=(v_day*Main.saat_kar_min)+(v_hour*60)+v_m";
_all_min = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
RDebugUtils.currentLine=30539801;
 //BA.debugLineNum = 30539801;BA.debugLine="v_hour=	myfunc.Min_to_saatMinRoz(all_min).Get(0)";
_v_hour = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_all_min).Get((int) (0))));
RDebugUtils.currentLine=30539802;
 //BA.debugLineNum = 30539802;BA.debugLine="v_min=	myfunc.Min_to_saatMinRoz(all_min).Get(1)";
_v_min = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_all_min).Get((int) (1))));
RDebugUtils.currentLine=30539803;
 //BA.debugLineNum = 30539803;BA.debugLine="v_day=	myfunc.Min_to_saatMinRoz(all_min).Get(2)";
_v_day = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_all_min).Get((int) (2))));
RDebugUtils.currentLine=30539823;
 //BA.debugLineNum = 30539823;BA.debugLine="If(state=0)Then";
if ((_state==0)) { 
RDebugUtils.currentLine=30539824;
 //BA.debugLineNum = 30539824;BA.debugLine="morakhasi_estefade_esteh=all_min";
_morakhasi_estefade_esteh = _all_min;
 };
RDebugUtils.currentLine=30539828;
 //BA.debugLineNum = 30539828;BA.debugLine="str=modify_str_showTime(v_day,v_hour,v_min)";
_str = _modify_str_showtime(_v_day,_v_hour,_v_min);
RDebugUtils.currentLine=30539829;
 //BA.debugLineNum = 30539829;BA.debugLine="Return str";
if (true) return _str;
RDebugUtils.currentLine=30539830;
 //BA.debugLineNum = 30539830;BA.debugLine="End Sub";
return "";
}
public static String  _modify_str_showtime(int _tim_d,int _tim_h,int _tim_m) throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "modify_str_showtime", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "modify_str_showtime", new Object[] {_tim_d,_tim_h,_tim_m}));}
String _str_modify1 = "";
RDebugUtils.currentLine=30081024;
 //BA.debugLineNum = 30081024;BA.debugLine="Sub modify_str_showTime (tim_d As Int, tim_h As In";
RDebugUtils.currentLine=30081025;
 //BA.debugLineNum = 30081025;BA.debugLine="Dim str_modify1 As String=\"\"";
_str_modify1 = "";
RDebugUtils.currentLine=30081026;
 //BA.debugLineNum = 30081026;BA.debugLine="If(tim_d<>0)Then";
if ((_tim_d!=0)) { 
RDebugUtils.currentLine=30081027;
 //BA.debugLineNum = 30081027;BA.debugLine="str_modify1=tim_d&\" روز \"";
_str_modify1 = BA.NumberToString(_tim_d)+" روز ";
 };
RDebugUtils.currentLine=30081029;
 //BA.debugLineNum = 30081029;BA.debugLine="If(tim_h<>0)Then";
if ((_tim_h!=0)) { 
RDebugUtils.currentLine=30081030;
 //BA.debugLineNum = 30081030;BA.debugLine="str_modify1=str_modify1&tim_h&\" ساعت \"";
_str_modify1 = _str_modify1+BA.NumberToString(_tim_h)+" ساعت ";
 };
RDebugUtils.currentLine=30081032;
 //BA.debugLineNum = 30081032;BA.debugLine="If(tim_m<>0)Then";
if ((_tim_m!=0)) { 
RDebugUtils.currentLine=30081033;
 //BA.debugLineNum = 30081033;BA.debugLine="str_modify1=str_modify1&tim_m&\" دقیقه \"";
_str_modify1 = _str_modify1+BA.NumberToString(_tim_m)+" دقیقه ";
 };
RDebugUtils.currentLine=30081036;
 //BA.debugLineNum = 30081036;BA.debugLine="If(str_modify1=\"\")Then";
if (((_str_modify1).equals(""))) { 
RDebugUtils.currentLine=30081037;
 //BA.debugLineNum = 30081037;BA.debugLine="str_modify1=\"-\"";
_str_modify1 = "-";
 };
RDebugUtils.currentLine=30081040;
 //BA.debugLineNum = 30081040;BA.debugLine="Return str_modify1";
if (true) return _str_modify1;
RDebugUtils.currentLine=30081042;
 //BA.debugLineNum = 30081042;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_estehgag_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_estehgag_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_estehgag_click", null));}
RDebugUtils.currentLine=30801920;
 //BA.debugLineNum = 30801920;BA.debugLine="Private Sub lbl_edit_estehgag_Click";
RDebugUtils.currentLine=30801921;
 //BA.debugLineNum = 30801921;BA.debugLine="et_mande_d.Text=morkasiDarMah_d";
mostCurrent._et_mande_d.setText(BA.ObjectToCharSequence(_morkasidarmah_d));
RDebugUtils.currentLine=30801922;
 //BA.debugLineNum = 30801922;BA.debugLine="et_mande_h.Text=morkasiDarMah_h";
mostCurrent._et_mande_h.setText(BA.ObjectToCharSequence(_morkasidarmah_h));
RDebugUtils.currentLine=30801923;
 //BA.debugLineNum = 30801923;BA.debugLine="et_mande_m.Text=morkasiDarMah_m";
mostCurrent._et_mande_m.setText(BA.ObjectToCharSequence(_morkasidarmah_m));
RDebugUtils.currentLine=30801925;
 //BA.debugLineNum = 30801925;BA.debugLine="index_box_edit=2";
_index_box_edit = (int) (2);
RDebugUtils.currentLine=30801926;
 //BA.debugLineNum = 30801926;BA.debugLine="lbl_box_edit.Text=\"تنظیم میزان مرخصی در ماه\"";
mostCurrent._lbl_box_edit.setText(BA.ObjectToCharSequence("تنظیم میزان مرخصی در ماه"));
RDebugUtils.currentLine=30801927;
 //BA.debugLineNum = 30801927;BA.debugLine="chk_manfi.Visible=False";
mostCurrent._chk_manfi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=30801928;
 //BA.debugLineNum = 30801928;BA.debugLine="lbl_help_mandeh.Visible=True";
mostCurrent._lbl_help_mandeh.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=30801930;
 //BA.debugLineNum = 30801930;BA.debugLine="pan_all_morakhasi.Visible=True";
mostCurrent._pan_all_morakhasi.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=30801932;
 //BA.debugLineNum = 30801932;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_mande_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_mande_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_mande_click", null));}
RDebugUtils.currentLine=30867456;
 //BA.debugLineNum = 30867456;BA.debugLine="Private Sub lbl_edit_mande_Click";
RDebugUtils.currentLine=30867457;
 //BA.debugLineNum = 30867457;BA.debugLine="et_mande_d.Text=mande_d";
mostCurrent._et_mande_d.setText(BA.ObjectToCharSequence(_mande_d));
RDebugUtils.currentLine=30867458;
 //BA.debugLineNum = 30867458;BA.debugLine="et_mande_h.Text=mande_h";
mostCurrent._et_mande_h.setText(BA.ObjectToCharSequence(_mande_h));
RDebugUtils.currentLine=30867459;
 //BA.debugLineNum = 30867459;BA.debugLine="et_mande_m.Text=mande_m";
mostCurrent._et_mande_m.setText(BA.ObjectToCharSequence(_mande_m));
RDebugUtils.currentLine=30867461;
 //BA.debugLineNum = 30867461;BA.debugLine="index_box_edit=1";
_index_box_edit = (int) (1);
RDebugUtils.currentLine=30867462;
 //BA.debugLineNum = 30867462;BA.debugLine="lbl_box_edit.Text=\"تنظیم مانده مرخصی\"";
mostCurrent._lbl_box_edit.setText(BA.ObjectToCharSequence("تنظیم مانده مرخصی"));
RDebugUtils.currentLine=30867463;
 //BA.debugLineNum = 30867463;BA.debugLine="chk_manfi.Visible=False";
mostCurrent._chk_manfi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=30867464;
 //BA.debugLineNum = 30867464;BA.debugLine="lbl_help_mandeh.Visible=False";
mostCurrent._lbl_help_mandeh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=30867465;
 //BA.debugLineNum = 30867465;BA.debugLine="pan_all_morakhasi.Visible=True";
mostCurrent._pan_all_morakhasi.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=30867466;
 //BA.debugLineNum = 30867466;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_mandeh_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_mandeh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_mandeh_click", null));}
RDebugUtils.currentLine=30932992;
 //BA.debugLineNum = 30932992;BA.debugLine="Private Sub lbl_help_mandeh_Click";
RDebugUtils.currentLine=30932993;
 //BA.debugLineNum = 30932993;BA.debugLine="If(index_box_edit=2)Then";
if ((_index_box_edit==2)) { 
RDebugUtils.currentLine=30932994;
 //BA.debugLineNum = 30932994;BA.debugLine="myfunc.help_man(\"راهنما\",\"در قانون کار مرخصی است";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","در قانون کار مرخصی استحقاقی در ماه 2 روز و 4 ساعت برای مشاغل عادی و 3 روز برای مشاغل سخت میباشد");
 };
RDebugUtils.currentLine=30932996;
 //BA.debugLineNum = 30932996;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run_mohasebe_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", null));}
double _mor_dar_roz = 0;
int _mande_ta_emroz = 0;
int _mande_ta_endmah = 0;
RDebugUtils.currentLine=30408704;
 //BA.debugLineNum = 30408704;BA.debugLine="Private Sub lbl_run_mohasebe_Click";
RDebugUtils.currentLine=30408705;
 //BA.debugLineNum = 30408705;BA.debugLine="Dim mor_dar_roz As Double=0  '' ============= min";
_mor_dar_roz = 0;
RDebugUtils.currentLine=30408706;
 //BA.debugLineNum = 30408706;BA.debugLine="mor_dar_roz=((morkasiDarMah_d*Main.saat_kar_min)+";
_mor_dar_roz = ((_morkasidarmah_d*mostCurrent._main._saat_kar_min /*int*/ )+(_morkasidarmah_h*60)+_morkasidarmah_m)/(double)30;
RDebugUtils.currentLine=30408709;
 //BA.debugLineNum = 30408709;BA.debugLine="lbl_morakhasi_estehgag.Text=all_morakhasiha_mah(M";
mostCurrent._lbl_morakhasi_estehgag.setText(BA.ObjectToCharSequence(_all_morakhasiha_mah(mostCurrent._main._year_num /*String*/ ,mostCurrent._main._moon_num /*String*/ ,(int) (0))));
RDebugUtils.currentLine=30408710;
 //BA.debugLineNum = 30408710;BA.debugLine="lbl_morakhasi_estelaj.Text=all_morakhasiha_mah(Ma";
mostCurrent._lbl_morakhasi_estelaj.setText(BA.ObjectToCharSequence(_all_morakhasiha_mah(mostCurrent._main._year_num /*String*/ ,mostCurrent._main._moon_num /*String*/ ,(int) (1))));
RDebugUtils.currentLine=30408711;
 //BA.debugLineNum = 30408711;BA.debugLine="lbl_morakhasi_baHogog.Text=all_morakhasiha_mah(Ma";
mostCurrent._lbl_morakhasi_bahogog.setText(BA.ObjectToCharSequence(_all_morakhasiha_mah(mostCurrent._main._year_num /*String*/ ,mostCurrent._main._moon_num /*String*/ ,(int) (2))));
RDebugUtils.currentLine=30408712;
 //BA.debugLineNum = 30408712;BA.debugLine="lbl_morakhasi_BiHogog.Text=all_morakhasiha_mah(Ma";
mostCurrent._lbl_morakhasi_bihogog.setText(BA.ObjectToCharSequence(_all_morakhasiha_mah(mostCurrent._main._year_num /*String*/ ,mostCurrent._main._moon_num /*String*/ ,(int) (3))));
RDebugUtils.currentLine=30408718;
 //BA.debugLineNum = 30408718;BA.debugLine="Dim mande_ta_emroz As Int   ''---------- min";
_mande_ta_emroz = 0;
RDebugUtils.currentLine=30408719;
 //BA.debugLineNum = 30408719;BA.debugLine="Dim mande_ta_endMah As Int   ''---------- min";
_mande_ta_endmah = 0;
RDebugUtils.currentLine=30408721;
 //BA.debugLineNum = 30408721;BA.debugLine="mande_ta_endMah=((mande_d*Main.saat_kar_min)+(man";
_mande_ta_endmah = (int) (((_mande_d*mostCurrent._main._saat_kar_min /*int*/ )+(_mande_h*60)+_mande_m)+(_mor_dar_roz*30)-_morakhasi_estefade_esteh);
RDebugUtils.currentLine=30408722;
 //BA.debugLineNum = 30408722;BA.debugLine="mande_ta_emroz=((mande_d*Main.saat_kar_min)+(mand";
_mande_ta_emroz = (int) (((_mande_d*mostCurrent._main._saat_kar_min /*int*/ )+(_mande_h*60)+_mande_m)+(_mor_dar_roz*mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianDay())-_morakhasi_estefade_esteh);
RDebugUtils.currentLine=30408725;
 //BA.debugLineNum = 30408725;BA.debugLine="Log(morakhasi_estefade_esteh)";
anywheresoftware.b4a.keywords.Common.LogImpl("630408725",BA.NumberToString(_morakhasi_estefade_esteh),0);
RDebugUtils.currentLine=30408730;
 //BA.debugLineNum = 30408730;BA.debugLine="lbl_mande_ta_inEndMah.Text=min_to_str(mande_ta_en";
mostCurrent._lbl_mande_ta_inendmah.setText(BA.ObjectToCharSequence(_min_to_str(_mande_ta_endmah)));
RDebugUtils.currentLine=30408732;
 //BA.debugLineNum = 30408732;BA.debugLine="lbl_mande_ta_emroz.Text=min_to_str(mande_ta_emroz";
mostCurrent._lbl_mande_ta_emroz.setText(BA.ObjectToCharSequence(_min_to_str(_mande_ta_emroz)));
RDebugUtils.currentLine=30408738;
 //BA.debugLineNum = 30408738;BA.debugLine="End Sub";
return "";
}
public static String  _min_to_str(int _min1) throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "min_to_str", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "min_to_str", new Object[] {_min1}));}
String _str_result = "";
String _str_state = "";
int _m_day = 0;
int _m_hour = 0;
int _m_min = 0;
int _div1 = 0;
int _min_new = 0;
RDebugUtils.currentLine=30474240;
 //BA.debugLineNum = 30474240;BA.debugLine="Sub min_to_str (min1 As Int ) As String";
RDebugUtils.currentLine=30474241;
 //BA.debugLineNum = 30474241;BA.debugLine="Dim str_result As String";
_str_result = "";
RDebugUtils.currentLine=30474242;
 //BA.debugLineNum = 30474242;BA.debugLine="Dim str_state As String=\"\"";
_str_state = "";
RDebugUtils.currentLine=30474246;
 //BA.debugLineNum = 30474246;BA.debugLine="Dim m_day As Int=0";
_m_day = (int) (0);
RDebugUtils.currentLine=30474247;
 //BA.debugLineNum = 30474247;BA.debugLine="Dim m_hour As Int=0";
_m_hour = (int) (0);
RDebugUtils.currentLine=30474248;
 //BA.debugLineNum = 30474248;BA.debugLine="Dim m_min As Int=min1";
_m_min = _min1;
RDebugUtils.currentLine=30474250;
 //BA.debugLineNum = 30474250;BA.debugLine="Dim div1 As Int=0  '' hour";
_div1 = (int) (0);
RDebugUtils.currentLine=30474252;
 //BA.debugLineNum = 30474252;BA.debugLine="If(min1>0)Then";
if ((_min1>0)) { 
RDebugUtils.currentLine=30474253;
 //BA.debugLineNum = 30474253;BA.debugLine="m_hour=	myfunc.Min_to_saatMinRoz(min1).Get(0)";
_m_hour = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min1).Get((int) (0))));
RDebugUtils.currentLine=30474254;
 //BA.debugLineNum = 30474254;BA.debugLine="m_min=myfunc.Min_to_saatMinRoz(min1).Get(1)";
_m_min = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min1).Get((int) (1))));
RDebugUtils.currentLine=30474255;
 //BA.debugLineNum = 30474255;BA.debugLine="m_day=myfunc.Min_to_saatMinRoz(min1).Get(2)";
_m_day = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min1).Get((int) (2))));
 }else {
RDebugUtils.currentLine=30474258;
 //BA.debugLineNum = 30474258;BA.debugLine="Dim min_new As Int = min1*(-1)";
_min_new = (int) (_min1*(-1));
RDebugUtils.currentLine=30474260;
 //BA.debugLineNum = 30474260;BA.debugLine="m_hour=	myfunc.Min_to_saatMinRoz(min_new).Get(0)";
_m_hour = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min_new).Get((int) (0))));
RDebugUtils.currentLine=30474261;
 //BA.debugLineNum = 30474261;BA.debugLine="m_min=myfunc.Min_to_saatMinRoz(min_new).Get(1)";
_m_min = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min_new).Get((int) (1))));
RDebugUtils.currentLine=30474262;
 //BA.debugLineNum = 30474262;BA.debugLine="m_day=myfunc.Min_to_saatMinRoz(min_new).Get(2)";
_m_day = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min_new).Get((int) (2))));
RDebugUtils.currentLine=30474264;
 //BA.debugLineNum = 30474264;BA.debugLine="str_state=\"-منفی-\"&CRLF";
_str_state = "-منفی-"+anywheresoftware.b4a.keywords.Common.CRLF;
 };
RDebugUtils.currentLine=30474305;
 //BA.debugLineNum = 30474305;BA.debugLine="str_result=str_state&modify_str_showTime(m_day,m_";
_str_result = _str_state+_modify_str_showtime(_m_day,_m_hour,_m_min);
RDebugUtils.currentLine=30474307;
 //BA.debugLineNum = 30474307;BA.debugLine="Return str_result";
if (true) return _str_result;
RDebugUtils.currentLine=30474309;
 //BA.debugLineNum = 30474309;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_mande_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_mande_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_mande_click", null));}
RDebugUtils.currentLine=30736384;
 //BA.debugLineNum = 30736384;BA.debugLine="Private Sub lbl_save_mande_Click";
RDebugUtils.currentLine=30736385;
 //BA.debugLineNum = 30736385;BA.debugLine="If(et_mande_d.Text=\"\")Then";
if (((mostCurrent._et_mande_d.getText()).equals(""))) { 
RDebugUtils.currentLine=30736386;
 //BA.debugLineNum = 30736386;BA.debugLine="et_mande_d.Text=0";
mostCurrent._et_mande_d.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=30736388;
 //BA.debugLineNum = 30736388;BA.debugLine="If(et_mande_h.Text=\"\")Then";
if (((mostCurrent._et_mande_h.getText()).equals(""))) { 
RDebugUtils.currentLine=30736389;
 //BA.debugLineNum = 30736389;BA.debugLine="et_mande_h.Text=0";
mostCurrent._et_mande_h.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=30736391;
 //BA.debugLineNum = 30736391;BA.debugLine="If(et_mande_m.Text=\"\")Then";
if (((mostCurrent._et_mande_m.getText()).equals(""))) { 
RDebugUtils.currentLine=30736392;
 //BA.debugLineNum = 30736392;BA.debugLine="et_mande_m.Text=0";
mostCurrent._et_mande_m.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=30736400;
 //BA.debugLineNum = 30736400;BA.debugLine="If (et_mande_m.Text > 59)Then";
if (((double)(Double.parseDouble(mostCurrent._et_mande_m.getText()))>59)) { 
RDebugUtils.currentLine=30736401;
 //BA.debugLineNum = 30736401;BA.debugLine="ToastMessageShow(\"دقیقه باید بین 0 تا 59 باشد\",F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("دقیقه باید بین 0 تا 59 باشد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=30736402;
 //BA.debugLineNum = 30736402;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=30736408;
 //BA.debugLineNum = 30736408;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=30736410;
 //BA.debugLineNum = 30736410;BA.debugLine="If(index_box_edit=1)Then";
if ((_index_box_edit==1)) { 
RDebugUtils.currentLine=30736411;
 //BA.debugLineNum = 30736411;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_d.getText()+" WHERE name='morakhasi_mande_d'");
RDebugUtils.currentLine=30736412;
 //BA.debugLineNum = 30736412;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_h.getText()+" WHERE name='morakhasi_mande_h'");
RDebugUtils.currentLine=30736413;
 //BA.debugLineNum = 30736413;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_m.getText()+" WHERE name='morakhasi_mande_m'");
 }else 
{RDebugUtils.currentLine=30736414;
 //BA.debugLineNum = 30736414;BA.debugLine="Else If (index_box_edit=2)Then";
if ((_index_box_edit==2)) { 
RDebugUtils.currentLine=30736415;
 //BA.debugLineNum = 30736415;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_d.getText()+" WHERE name='morakhasi_darMah_d'");
RDebugUtils.currentLine=30736416;
 //BA.debugLineNum = 30736416;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_h.getText()+" WHERE name='morakhasi_darMah_h'");
RDebugUtils.currentLine=30736417;
 //BA.debugLineNum = 30736417;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_m.getText()+" WHERE name='morakhasi_darMah_m'");
 }}
;
RDebugUtils.currentLine=30736424;
 //BA.debugLineNum = 30736424;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=30736426;
 //BA.debugLineNum = 30736426;BA.debugLine="get_mande_db";
_get_mande_db();
RDebugUtils.currentLine=30736428;
 //BA.debugLineNum = 30736428;BA.debugLine="pan_all_morakhasi_Click";
_pan_all_morakhasi_click();
RDebugUtils.currentLine=30736429;
 //BA.debugLineNum = 30736429;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_morakhasi_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_morakhasi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_morakhasi_click", null));}
RDebugUtils.currentLine=30605312;
 //BA.debugLineNum = 30605312;BA.debugLine="Private Sub pan_all_morakhasi_Click";
RDebugUtils.currentLine=30605313;
 //BA.debugLineNum = 30605313;BA.debugLine="pan_all_morakhasi.Visible=False";
mostCurrent._pan_all_morakhasi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=30605314;
 //BA.debugLineNum = 30605314;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel4_click", null));}
RDebugUtils.currentLine=30670848;
 //BA.debugLineNum = 30670848;BA.debugLine="Private Sub Panel4_Click";
RDebugUtils.currentLine=30670850;
 //BA.debugLineNum = 30670850;BA.debugLine="End Sub";
return "";
}
}