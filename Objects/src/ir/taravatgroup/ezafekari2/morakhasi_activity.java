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
        
        BA.LogInfo("** Activity (morakhasi_activity) Create " + (isFirst ? "(first time)" : "") + " **");
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
public anywheresoftware.b4a.objects.LabelWrapper _lbl_estehgag_darmah = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_box_edit = null;
public static int _index_box_edit = 0;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk_manfi = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_mandemorakh = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_help_mandeh = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_rozha = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_day1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_moon1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_year1 = null;
public static int _num_datapik = 0;
public anywheresoftware.b4a.objects.collections.List _moon_datapik = null;
public static int _index_datepik = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_set_date = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_all_estehgag = null;
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.ayabzahab_activity _ayabzahab_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.food_activity _food_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.gestha_activity _gestha_activity = null;
public ir.taravatgroup.ezafekari2.help_kharid_activity _help_kharid_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.mosaedeh_activity _mosaedeh_activity = null;
public ir.taravatgroup.ezafekari2.padash_activity _padash_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
public ir.taravatgroup.ezafekari2.sayer_activity _sayer_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=23986176;
 //BA.debugLineNum = 23986176;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=23986178;
 //BA.debugLineNum = 23986178;BA.debugLine="Activity.LoadLayout(\"morakhasi_layout\")";
mostCurrent._activity.LoadLayout("morakhasi_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=23986180;
 //BA.debugLineNum = 23986180;BA.debugLine="ScrollView1.Panel.LoadLayout(\"morakhasi_item2\")";
mostCurrent._scrollview1.getPanel().LoadLayout("morakhasi_item2",mostCurrent.activityBA);
RDebugUtils.currentLine=23986181;
 //BA.debugLineNum = 23986181;BA.debugLine="get_mande_db";
_get_mande_db();
RDebugUtils.currentLine=23986184;
 //BA.debugLineNum = 23986184;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
RDebugUtils.currentLine=23986185;
 //BA.debugLineNum = 23986185;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=23986190;
 //BA.debugLineNum = 23986190;BA.debugLine="pan_hed_mandeMorakh.Color=Main.color4";
mostCurrent._pan_hed_mandemorakh.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=23986191;
 //BA.debugLineNum = 23986191;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=23986193;
 //BA.debugLineNum = 23986193;BA.debugLine="End Sub";
return "";
}
public static String  _get_mande_db() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_mande_db", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_mande_db", null));}
RDebugUtils.currentLine=24051712;
 //BA.debugLineNum = 24051712;BA.debugLine="Sub get_mande_db";
RDebugUtils.currentLine=24051714;
 //BA.debugLineNum = 24051714;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=24051715;
 //BA.debugLineNum = 24051715;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=24051717;
 //BA.debugLineNum = 24051717;BA.debugLine="dbCode.res.Position=20 ''--------day------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (20));
RDebugUtils.currentLine=24051718;
 //BA.debugLineNum = 24051718;BA.debugLine="mande_d=dbCode.res.GetString(\"value\")";
_mande_d = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24051720;
 //BA.debugLineNum = 24051720;BA.debugLine="dbCode.res.Position=21 ''--------hour------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (21));
RDebugUtils.currentLine=24051721;
 //BA.debugLineNum = 24051721;BA.debugLine="mande_h=dbCode.res.GetString(\"value\")";
_mande_h = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24051723;
 //BA.debugLineNum = 24051723;BA.debugLine="dbCode.res.Position=22 ''--------min------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (22));
RDebugUtils.currentLine=24051724;
 //BA.debugLineNum = 24051724;BA.debugLine="mande_m=dbCode.res.GetString(\"value\")";
_mande_m = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24051727;
 //BA.debugLineNum = 24051727;BA.debugLine="dbCode.res.Position=23";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (23));
RDebugUtils.currentLine=24051728;
 //BA.debugLineNum = 24051728;BA.debugLine="morkasiDarMah_d=dbCode.res.GetString(\"value\")";
_morkasidarmah_d = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24051729;
 //BA.debugLineNum = 24051729;BA.debugLine="dbCode.res.Position=24";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (24));
RDebugUtils.currentLine=24051730;
 //BA.debugLineNum = 24051730;BA.debugLine="morkasiDarMah_h=dbCode.res.GetString(\"value\")";
_morkasidarmah_h = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24051731;
 //BA.debugLineNum = 24051731;BA.debugLine="dbCode.res.Position=25";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (25));
RDebugUtils.currentLine=24051732;
 //BA.debugLineNum = 24051732;BA.debugLine="morkasiDarMah_m=dbCode.res.GetString(\"value\")";
_morkasidarmah_m = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24051740;
 //BA.debugLineNum = 24051740;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=24051746;
 //BA.debugLineNum = 24051746;BA.debugLine="lbl_mande_show.Text=modify_str_showTime(mande_d,m";
mostCurrent._lbl_mande_show.setText(BA.ObjectToCharSequence(_modify_str_showtime(_mande_d,_mande_h,_mande_m)));
RDebugUtils.currentLine=24051747;
 //BA.debugLineNum = 24051747;BA.debugLine="lbl_estehgag_darMah.Text=modify_str_showTime(mork";
mostCurrent._lbl_estehgag_darmah.setText(BA.ObjectToCharSequence(_modify_str_showtime(_morkasidarmah_d,_morkasidarmah_h,_morkasidarmah_m)));
RDebugUtils.currentLine=24051749;
 //BA.debugLineNum = 24051749;BA.debugLine="lbl_date2.Text=myfunc.fa2en(Main.persianDate.Pers";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate())));
RDebugUtils.currentLine=24051751;
 //BA.debugLineNum = 24051751;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=24379392;
 //BA.debugLineNum = 24379392;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=24379393;
 //BA.debugLineNum = 24379393;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=24379394;
 //BA.debugLineNum = 24379394;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=24379395;
 //BA.debugLineNum = 24379395;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=24379397;
 //BA.debugLineNum = 24379397;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=24379399;
 //BA.debugLineNum = 24379399;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=24313856;
 //BA.debugLineNum = 24313856;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=24313858;
 //BA.debugLineNum = 24313858;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=24313859;
 //BA.debugLineNum = 24313859;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
RDebugUtils.currentLine=24248320;
 //BA.debugLineNum = 24248320;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=24248322;
 //BA.debugLineNum = 24248322;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=24182784;
 //BA.debugLineNum = 24182784;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=24182786;
 //BA.debugLineNum = 24182786;BA.debugLine="End Sub";
return "";
}
public static String  _all_morakhasiha_bydate(String _date1,String _date2,String _state) throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "all_morakhasiha_bydate", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "all_morakhasiha_bydate", new Object[] {_date1,_date2,_state}));}
String _str = "";
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div1 = 0;
int _div2 = 0;
int _all_min = 0;
RDebugUtils.currentLine=24576000;
 //BA.debugLineNum = 24576000;BA.debugLine="Sub all_morakhasiha_byDate(date1 As String , date2";
RDebugUtils.currentLine=24576002;
 //BA.debugLineNum = 24576002;BA.debugLine="Dim str As String";
_str = "";
RDebugUtils.currentLine=24576006;
 //BA.debugLineNum = 24576006;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=24576007;
 //BA.debugLineNum = 24576007;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=24576008;
 //BA.debugLineNum = 24576008;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=24576009;
 //BA.debugLineNum = 24576009;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
RDebugUtils.currentLine=24576010;
 //BA.debugLineNum = 24576010;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
RDebugUtils.currentLine=24576011;
 //BA.debugLineNum = 24576011;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=24576012;
 //BA.debugLineNum = 24576012;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from  BETWEEN '"+_date1+"' AND '"+_date2+"' AND state="+_state)));
RDebugUtils.currentLine=24576013;
 //BA.debugLineNum = 24576013;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=24576015;
 //BA.debugLineNum = 24576015;BA.debugLine="v_day=v_day+dbCode.res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d"))));
RDebugUtils.currentLine=24576016;
 //BA.debugLineNum = 24576016;BA.debugLine="v_hour=v_hour+dbCode.res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h"))));
RDebugUtils.currentLine=24576017;
 //BA.debugLineNum = 24576017;BA.debugLine="v_min=v_min+dbCode.res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=24576021;
 //BA.debugLineNum = 24576021;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=24576022;
 //BA.debugLineNum = 24576022;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=24576025;
 //BA.debugLineNum = 24576025;BA.debugLine="Dim all_min As Int";
_all_min = 0;
RDebugUtils.currentLine=24576026;
 //BA.debugLineNum = 24576026;BA.debugLine="all_min=(v_day*Main.saat_kar_min)+(v_hour*60)+v_m";
_all_min = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
RDebugUtils.currentLine=24576027;
 //BA.debugLineNum = 24576027;BA.debugLine="v_hour=	myfunc.Min_to_saatMinRoz(all_min).Get(0)";
_v_hour = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_all_min).Get((int) (0))));
RDebugUtils.currentLine=24576028;
 //BA.debugLineNum = 24576028;BA.debugLine="v_min=	myfunc.Min_to_saatMinRoz(all_min).Get(1)";
_v_min = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_all_min).Get((int) (1))));
RDebugUtils.currentLine=24576029;
 //BA.debugLineNum = 24576029;BA.debugLine="v_day=	myfunc.Min_to_saatMinRoz(all_min).Get(2)";
_v_day = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_all_min).Get((int) (2))));
RDebugUtils.currentLine=24576033;
 //BA.debugLineNum = 24576033;BA.debugLine="If(state=0)Then";
if (((_state).equals(BA.NumberToString(0)))) { 
RDebugUtils.currentLine=24576034;
 //BA.debugLineNum = 24576034;BA.debugLine="morakhasi_estefade_esteh=all_min";
_morakhasi_estefade_esteh = _all_min;
 };
RDebugUtils.currentLine=24576038;
 //BA.debugLineNum = 24576038;BA.debugLine="str=modify_str_showTime(v_day,v_hour,v_min)";
_str = _modify_str_showtime(_v_day,_v_hour,_v_min);
RDebugUtils.currentLine=24576039;
 //BA.debugLineNum = 24576039;BA.debugLine="Return str";
if (true) return _str;
RDebugUtils.currentLine=24576041;
 //BA.debugLineNum = 24576041;BA.debugLine="End Sub";
return "";
}
public static String  _modify_str_showtime(int _tim_d,int _tim_h,int _tim_m) throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "modify_str_showtime", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "modify_str_showtime", new Object[] {_tim_d,_tim_h,_tim_m}));}
String _str_modify1 = "";
RDebugUtils.currentLine=24117248;
 //BA.debugLineNum = 24117248;BA.debugLine="Sub modify_str_showTime (tim_d As Int, tim_h As In";
RDebugUtils.currentLine=24117249;
 //BA.debugLineNum = 24117249;BA.debugLine="Dim str_modify1 As String=\"\"";
_str_modify1 = "";
RDebugUtils.currentLine=24117250;
 //BA.debugLineNum = 24117250;BA.debugLine="If(tim_d<>0)Then";
if ((_tim_d!=0)) { 
RDebugUtils.currentLine=24117251;
 //BA.debugLineNum = 24117251;BA.debugLine="str_modify1=tim_d&\" روز \"";
_str_modify1 = BA.NumberToString(_tim_d)+" روز ";
 };
RDebugUtils.currentLine=24117253;
 //BA.debugLineNum = 24117253;BA.debugLine="If(tim_h<>0)Then";
if ((_tim_h!=0)) { 
RDebugUtils.currentLine=24117254;
 //BA.debugLineNum = 24117254;BA.debugLine="str_modify1=str_modify1&tim_h&\" ساعت \"";
_str_modify1 = _str_modify1+BA.NumberToString(_tim_h)+" ساعت ";
 };
RDebugUtils.currentLine=24117256;
 //BA.debugLineNum = 24117256;BA.debugLine="If(tim_m<>0)Then";
if ((_tim_m!=0)) { 
RDebugUtils.currentLine=24117257;
 //BA.debugLineNum = 24117257;BA.debugLine="str_modify1=str_modify1&tim_m&\" دقیقه \"";
_str_modify1 = _str_modify1+BA.NumberToString(_tim_m)+" دقیقه ";
 };
RDebugUtils.currentLine=24117260;
 //BA.debugLineNum = 24117260;BA.debugLine="If(str_modify1=\"\")Then";
if (((_str_modify1).equals(""))) { 
RDebugUtils.currentLine=24117261;
 //BA.debugLineNum = 24117261;BA.debugLine="str_modify1=\"-\"";
_str_modify1 = "-";
 };
RDebugUtils.currentLine=24117264;
 //BA.debugLineNum = 24117264;BA.debugLine="Return str_modify1";
if (true) return _str_modify1;
RDebugUtils.currentLine=24117266;
 //BA.debugLineNum = 24117266;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date1_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date1_click", null));}
RDebugUtils.currentLine=25100288;
 //BA.debugLineNum = 25100288;BA.debugLine="Private Sub lbl_date1_Click";
RDebugUtils.currentLine=25100289;
 //BA.debugLineNum = 25100289;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25100290;
 //BA.debugLineNum = 25100290;BA.debugLine="index_datePik=1";
_index_datepik = (int) (1);
RDebugUtils.currentLine=25100292;
 //BA.debugLineNum = 25100292;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date1.Text.SubStr";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date1.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=25100293;
 //BA.debugLineNum = 25100293;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date1.Text.SubStri";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date1.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=25100294;
 //BA.debugLineNum = 25100294;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=25100295;
 //BA.debugLineNum = 25100295;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date1.Text.SubStri";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date1.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=25100296;
 //BA.debugLineNum = 25100296;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date2_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date2_click", null));}
RDebugUtils.currentLine=25034752;
 //BA.debugLineNum = 25034752;BA.debugLine="Private Sub lbl_date2_Click";
RDebugUtils.currentLine=25034753;
 //BA.debugLineNum = 25034753;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25034754;
 //BA.debugLineNum = 25034754;BA.debugLine="index_datePik=2";
_index_datepik = (int) (2);
RDebugUtils.currentLine=25034756;
 //BA.debugLineNum = 25034756;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date2.Text.SubStr";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date2.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=25034757;
 //BA.debugLineNum = 25034757;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date2.Text.SubStri";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date2.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=25034758;
 //BA.debugLineNum = 25034758;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=25034759;
 //BA.debugLineNum = 25034759;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date2.Text.SubStri";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date2.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=25034760;
 //BA.debugLineNum = 25034760;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_estehgag_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_estehgag_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_estehgag_click", null));}
RDebugUtils.currentLine=24838144;
 //BA.debugLineNum = 24838144;BA.debugLine="Private Sub lbl_edit_estehgag_Click";
RDebugUtils.currentLine=24838145;
 //BA.debugLineNum = 24838145;BA.debugLine="et_mande_d.Text=morkasiDarMah_d";
mostCurrent._et_mande_d.setText(BA.ObjectToCharSequence(_morkasidarmah_d));
RDebugUtils.currentLine=24838146;
 //BA.debugLineNum = 24838146;BA.debugLine="et_mande_h.Text=morkasiDarMah_h";
mostCurrent._et_mande_h.setText(BA.ObjectToCharSequence(_morkasidarmah_h));
RDebugUtils.currentLine=24838147;
 //BA.debugLineNum = 24838147;BA.debugLine="et_mande_m.Text=morkasiDarMah_m";
mostCurrent._et_mande_m.setText(BA.ObjectToCharSequence(_morkasidarmah_m));
RDebugUtils.currentLine=24838149;
 //BA.debugLineNum = 24838149;BA.debugLine="index_box_edit=2";
_index_box_edit = (int) (2);
RDebugUtils.currentLine=24838150;
 //BA.debugLineNum = 24838150;BA.debugLine="lbl_box_edit.Text=\"تنظیم میزان مرخصی در ماه\"";
mostCurrent._lbl_box_edit.setText(BA.ObjectToCharSequence("تنظیم میزان مرخصی در ماه"));
RDebugUtils.currentLine=24838151;
 //BA.debugLineNum = 24838151;BA.debugLine="chk_manfi.Visible=False";
mostCurrent._chk_manfi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24838152;
 //BA.debugLineNum = 24838152;BA.debugLine="lbl_help_mandeh.Visible=True";
mostCurrent._lbl_help_mandeh.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=24838154;
 //BA.debugLineNum = 24838154;BA.debugLine="pan_all_morakhasi.Visible=True";
mostCurrent._pan_all_morakhasi.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=24838156;
 //BA.debugLineNum = 24838156;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_mande_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_mande_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_mande_click", null));}
RDebugUtils.currentLine=24903680;
 //BA.debugLineNum = 24903680;BA.debugLine="Private Sub lbl_edit_mande_Click";
RDebugUtils.currentLine=24903681;
 //BA.debugLineNum = 24903681;BA.debugLine="et_mande_d.Text=mande_d";
mostCurrent._et_mande_d.setText(BA.ObjectToCharSequence(_mande_d));
RDebugUtils.currentLine=24903682;
 //BA.debugLineNum = 24903682;BA.debugLine="et_mande_h.Text=mande_h";
mostCurrent._et_mande_h.setText(BA.ObjectToCharSequence(_mande_h));
RDebugUtils.currentLine=24903683;
 //BA.debugLineNum = 24903683;BA.debugLine="et_mande_m.Text=mande_m";
mostCurrent._et_mande_m.setText(BA.ObjectToCharSequence(_mande_m));
RDebugUtils.currentLine=24903685;
 //BA.debugLineNum = 24903685;BA.debugLine="index_box_edit=1";
_index_box_edit = (int) (1);
RDebugUtils.currentLine=24903686;
 //BA.debugLineNum = 24903686;BA.debugLine="lbl_box_edit.Text=\"تنظیم مانده مرخصی\"";
mostCurrent._lbl_box_edit.setText(BA.ObjectToCharSequence("تنظیم مانده مرخصی"));
RDebugUtils.currentLine=24903687;
 //BA.debugLineNum = 24903687;BA.debugLine="chk_manfi.Visible=False";
mostCurrent._chk_manfi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24903688;
 //BA.debugLineNum = 24903688;BA.debugLine="lbl_help_mandeh.Visible=False";
mostCurrent._lbl_help_mandeh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24903689;
 //BA.debugLineNum = 24903689;BA.debugLine="pan_all_morakhasi.Visible=True";
mostCurrent._pan_all_morakhasi.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=24903690;
 //BA.debugLineNum = 24903690;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_mandeh_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_mandeh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_mandeh_click", null));}
RDebugUtils.currentLine=24969216;
 //BA.debugLineNum = 24969216;BA.debugLine="Private Sub lbl_help_mandeh_Click";
RDebugUtils.currentLine=24969217;
 //BA.debugLineNum = 24969217;BA.debugLine="If(index_box_edit=2)Then";
if ((_index_box_edit==2)) { 
RDebugUtils.currentLine=24969218;
 //BA.debugLineNum = 24969218;BA.debugLine="myfunc.help_man(\"راهنما\",\"در قانون کار مرخصی است";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","در قانون کار مرخصی استحقاقی در ماه 2 روز و 4 ساعت برای مشاغل عادی و 3 روز برای مشاغل سخت میباشد");
 };
RDebugUtils.currentLine=24969220;
 //BA.debugLineNum = 24969220;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run_mohasebe_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", null));}
int _rozha = 0;
double _zarib = 0;
int _all_mor1 = 0;
RDebugUtils.currentLine=24444928;
 //BA.debugLineNum = 24444928;BA.debugLine="Private Sub lbl_run_mohasebe_Click";
RDebugUtils.currentLine=24444930;
 //BA.debugLineNum = 24444930;BA.debugLine="lbl_morakhasi_estehgag.Text=all_morakhasiha_byDat";
mostCurrent._lbl_morakhasi_estehgag.setText(BA.ObjectToCharSequence(_all_morakhasiha_bydate(mostCurrent._lbl_date1.getText(),mostCurrent._lbl_date2.getText(),BA.NumberToString(0))));
RDebugUtils.currentLine=24444931;
 //BA.debugLineNum = 24444931;BA.debugLine="lbl_morakhasi_estelaj.Text=all_morakhasiha_byDate";
mostCurrent._lbl_morakhasi_estelaj.setText(BA.ObjectToCharSequence(_all_morakhasiha_bydate(mostCurrent._lbl_date1.getText(),mostCurrent._lbl_date2.getText(),BA.NumberToString(1))));
RDebugUtils.currentLine=24444932;
 //BA.debugLineNum = 24444932;BA.debugLine="lbl_morakhasi_baHogog.Text=all_morakhasiha_byDate";
mostCurrent._lbl_morakhasi_bahogog.setText(BA.ObjectToCharSequence(_all_morakhasiha_bydate(mostCurrent._lbl_date1.getText(),mostCurrent._lbl_date2.getText(),BA.NumberToString(2))));
RDebugUtils.currentLine=24444933;
 //BA.debugLineNum = 24444933;BA.debugLine="lbl_morakhasi_BiHogog.Text=all_morakhasiha_byDate";
mostCurrent._lbl_morakhasi_bihogog.setText(BA.ObjectToCharSequence(_all_morakhasiha_bydate(mostCurrent._lbl_date1.getText(),mostCurrent._lbl_date2.getText(),BA.NumberToString(3))));
RDebugUtils.currentLine=24444936;
 //BA.debugLineNum = 24444936;BA.debugLine="Dim rozha As Int";
_rozha = 0;
RDebugUtils.currentLine=24444937;
 //BA.debugLineNum = 24444937;BA.debugLine="rozha=myfunc.time_mohasebe(lbl_date1.Text,lbl_dat";
_rozha = mostCurrent._myfunc._time_mohasebe /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date1.getText(),mostCurrent._lbl_date2.getText());
RDebugUtils.currentLine=24444938;
 //BA.debugLineNum = 24444938;BA.debugLine="lbl_rozha.Text=rozha";
mostCurrent._lbl_rozha.setText(BA.ObjectToCharSequence(_rozha));
RDebugUtils.currentLine=24444941;
 //BA.debugLineNum = 24444941;BA.debugLine="Dim zarib As Double=(((morkasiDarMah_d*(Main.saat";
_zarib = (((_morkasidarmah_d*(mostCurrent._main._saat_kar_min /*int*/ /(double)60))+_morkasidarmah_h)*60)/(double)30.5;
RDebugUtils.currentLine=24444944;
 //BA.debugLineNum = 24444944;BA.debugLine="Dim all_mor1 As Int= (Round(zarib*rozha))+1+(((ma";
_all_mor1 = (int) ((anywheresoftware.b4a.keywords.Common.Round(_zarib*_rozha))+1+(((_mande_d*(mostCurrent._main._saat_kar_min /*int*/ /(double)60))+_mande_h)*60));
RDebugUtils.currentLine=24444951;
 //BA.debugLineNum = 24444951;BA.debugLine="lbl_all_estehgag.Text= myfunc.Min_to_saatMinRoz(a";
mostCurrent._lbl_all_estehgag.setText(BA.ObjectToCharSequence(BA.ObjectToString(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_all_mor1).Get((int) (2)))+" روز و "+BA.ObjectToString(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_all_mor1).Get((int) (0)))+" ساعت و "+BA.ObjectToString(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_all_mor1).Get((int) (2)))+" دقیقه "));
RDebugUtils.currentLine=24444953;
 //BA.debugLineNum = 24444953;BA.debugLine="lbl_mande_ta_emroz.Text=myfunc.Min_to_saatMinRoz(";
mostCurrent._lbl_mande_ta_emroz.setText(BA.ObjectToCharSequence(BA.ObjectToString(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_all_mor1-(_morakhasi_estefade_esteh))).Get((int) (2)))+" روز و "+BA.ObjectToString(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_all_mor1-(_morakhasi_estefade_esteh))).Get((int) (0)))+" ساعت و  "+BA.ObjectToString(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_all_mor1-(_morakhasi_estefade_esteh))).Get((int) (2)))+" دقیقه "));
RDebugUtils.currentLine=24444955;
 //BA.debugLineNum = 24444955;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_mande_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_mande_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_mande_click", null));}
RDebugUtils.currentLine=24772608;
 //BA.debugLineNum = 24772608;BA.debugLine="Private Sub lbl_save_mande_Click";
RDebugUtils.currentLine=24772609;
 //BA.debugLineNum = 24772609;BA.debugLine="If(et_mande_d.Text=\"\")Then";
if (((mostCurrent._et_mande_d.getText()).equals(""))) { 
RDebugUtils.currentLine=24772610;
 //BA.debugLineNum = 24772610;BA.debugLine="et_mande_d.Text=0";
mostCurrent._et_mande_d.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=24772612;
 //BA.debugLineNum = 24772612;BA.debugLine="If(et_mande_h.Text=\"\")Then";
if (((mostCurrent._et_mande_h.getText()).equals(""))) { 
RDebugUtils.currentLine=24772613;
 //BA.debugLineNum = 24772613;BA.debugLine="et_mande_h.Text=0";
mostCurrent._et_mande_h.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=24772615;
 //BA.debugLineNum = 24772615;BA.debugLine="If(et_mande_m.Text=\"\")Then";
if (((mostCurrent._et_mande_m.getText()).equals(""))) { 
RDebugUtils.currentLine=24772616;
 //BA.debugLineNum = 24772616;BA.debugLine="et_mande_m.Text=0";
mostCurrent._et_mande_m.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=24772624;
 //BA.debugLineNum = 24772624;BA.debugLine="If (et_mande_m.Text > 59)Then";
if (((double)(Double.parseDouble(mostCurrent._et_mande_m.getText()))>59)) { 
RDebugUtils.currentLine=24772625;
 //BA.debugLineNum = 24772625;BA.debugLine="ToastMessageShow(\"دقیقه باید بین 0 تا 59 باشد\",F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("دقیقه باید بین 0 تا 59 باشد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24772626;
 //BA.debugLineNum = 24772626;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=24772632;
 //BA.debugLineNum = 24772632;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=24772634;
 //BA.debugLineNum = 24772634;BA.debugLine="If(index_box_edit=1)Then";
if ((_index_box_edit==1)) { 
RDebugUtils.currentLine=24772635;
 //BA.debugLineNum = 24772635;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_d.getText()+" WHERE name='morakhasi_mande_d'");
RDebugUtils.currentLine=24772636;
 //BA.debugLineNum = 24772636;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_h.getText()+" WHERE name='morakhasi_mande_h'");
RDebugUtils.currentLine=24772637;
 //BA.debugLineNum = 24772637;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_m.getText()+" WHERE name='morakhasi_mande_m'");
 }else 
{RDebugUtils.currentLine=24772638;
 //BA.debugLineNum = 24772638;BA.debugLine="Else If (index_box_edit=2)Then";
if ((_index_box_edit==2)) { 
RDebugUtils.currentLine=24772639;
 //BA.debugLineNum = 24772639;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_d.getText()+" WHERE name='morakhasi_darMah_d'");
RDebugUtils.currentLine=24772640;
 //BA.debugLineNum = 24772640;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_h.getText()+" WHERE name='morakhasi_darMah_h'");
RDebugUtils.currentLine=24772641;
 //BA.debugLineNum = 24772641;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_m.getText()+" WHERE name='morakhasi_darMah_m'");
 }}
;
RDebugUtils.currentLine=24772648;
 //BA.debugLineNum = 24772648;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=24772650;
 //BA.debugLineNum = 24772650;BA.debugLine="get_mande_db";
_get_mande_db();
RDebugUtils.currentLine=24772652;
 //BA.debugLineNum = 24772652;BA.debugLine="pan_all_morakhasi_Click";
_pan_all_morakhasi_click();
RDebugUtils.currentLine=24772653;
 //BA.debugLineNum = 24772653;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_morakhasi_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_morakhasi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_morakhasi_click", null));}
RDebugUtils.currentLine=24641536;
 //BA.debugLineNum = 24641536;BA.debugLine="Private Sub pan_all_morakhasi_Click";
RDebugUtils.currentLine=24641537;
 //BA.debugLineNum = 24641537;BA.debugLine="pan_all_morakhasi.Visible=False";
mostCurrent._pan_all_morakhasi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24641538;
 //BA.debugLineNum = 24641538;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_picker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_picker_click", null));}
RDebugUtils.currentLine=25165824;
 //BA.debugLineNum = 25165824;BA.debugLine="Private Sub lbl_save_picker_Click";
RDebugUtils.currentLine=25165825;
 //BA.debugLineNum = 25165825;BA.debugLine="If(index_datePik=1) Then";
if ((_index_datepik==1)) { 
RDebugUtils.currentLine=25165826;
 //BA.debugLineNum = 25165826;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&myfunc.convert";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 }else 
{RDebugUtils.currentLine=25165828;
 //BA.debugLineNum = 25165828;BA.debugLine="Else If(index_datePik=2) Then";
if ((_index_datepik==2)) { 
RDebugUtils.currentLine=25165829;
 //BA.debugLineNum = 25165829;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&myfunc.convert";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 }}
;
RDebugUtils.currentLine=25165831;
 //BA.debugLineNum = 25165831;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25165832;
 //BA.debugLineNum = 25165832;BA.debugLine="End Sub";
return "";
}
public static String  _min_to_str1(int _min1) throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "min_to_str1", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "min_to_str1", new Object[] {_min1}));}
String _str_result = "";
String _str_state = "";
int _m_day = 0;
int _m_hour = 0;
int _m_min = 0;
int _div1 = 0;
int _min_new = 0;
RDebugUtils.currentLine=24510464;
 //BA.debugLineNum = 24510464;BA.debugLine="Sub min_to_str1 (min1 As Int ) As String";
RDebugUtils.currentLine=24510465;
 //BA.debugLineNum = 24510465;BA.debugLine="Dim str_result As String";
_str_result = "";
RDebugUtils.currentLine=24510466;
 //BA.debugLineNum = 24510466;BA.debugLine="Dim str_state As String=\"\"";
_str_state = "";
RDebugUtils.currentLine=24510470;
 //BA.debugLineNum = 24510470;BA.debugLine="Dim m_day As Int=0";
_m_day = (int) (0);
RDebugUtils.currentLine=24510471;
 //BA.debugLineNum = 24510471;BA.debugLine="Dim m_hour As Int=0";
_m_hour = (int) (0);
RDebugUtils.currentLine=24510472;
 //BA.debugLineNum = 24510472;BA.debugLine="Dim m_min As Int=min1";
_m_min = _min1;
RDebugUtils.currentLine=24510474;
 //BA.debugLineNum = 24510474;BA.debugLine="Dim div1 As Int=0  '' hour";
_div1 = (int) (0);
RDebugUtils.currentLine=24510476;
 //BA.debugLineNum = 24510476;BA.debugLine="If(min1>0)Then";
if ((_min1>0)) { 
RDebugUtils.currentLine=24510477;
 //BA.debugLineNum = 24510477;BA.debugLine="m_hour=	myfunc.Min_to_saatMinRoz(min1).Get(0)";
_m_hour = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min1).Get((int) (0))));
RDebugUtils.currentLine=24510478;
 //BA.debugLineNum = 24510478;BA.debugLine="m_min=myfunc.Min_to_saatMinRoz(min1).Get(1)";
_m_min = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min1).Get((int) (1))));
RDebugUtils.currentLine=24510479;
 //BA.debugLineNum = 24510479;BA.debugLine="m_day=myfunc.Min_to_saatMinRoz(min1).Get(2)";
_m_day = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min1).Get((int) (2))));
 }else {
RDebugUtils.currentLine=24510482;
 //BA.debugLineNum = 24510482;BA.debugLine="Dim min_new As Int = min1*(-1)";
_min_new = (int) (_min1*(-1));
RDebugUtils.currentLine=24510484;
 //BA.debugLineNum = 24510484;BA.debugLine="m_hour=	myfunc.Min_to_saatMinRoz(min_new).Get(0)";
_m_hour = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min_new).Get((int) (0))));
RDebugUtils.currentLine=24510485;
 //BA.debugLineNum = 24510485;BA.debugLine="m_min=myfunc.Min_to_saatMinRoz(min_new).Get(1)";
_m_min = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min_new).Get((int) (1))));
RDebugUtils.currentLine=24510486;
 //BA.debugLineNum = 24510486;BA.debugLine="m_day=myfunc.Min_to_saatMinRoz(min_new).Get(2)";
_m_day = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min_new).Get((int) (2))));
RDebugUtils.currentLine=24510488;
 //BA.debugLineNum = 24510488;BA.debugLine="str_state=\"-منفی-\"&CRLF";
_str_state = "-منفی-"+anywheresoftware.b4a.keywords.Common.CRLF;
 };
RDebugUtils.currentLine=24510492;
 //BA.debugLineNum = 24510492;BA.debugLine="str_result=str_state&modify_str_showTime(m_day,m_";
_str_result = _str_state+_modify_str_showtime(_m_day,_m_hour,_m_min);
RDebugUtils.currentLine=24510494;
 //BA.debugLineNum = 24510494;BA.debugLine="Return str_result";
if (true) return _str_result;
RDebugUtils.currentLine=24510496;
 //BA.debugLineNum = 24510496;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_set_date_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_set_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_set_date_click", null));}
RDebugUtils.currentLine=25821184;
 //BA.debugLineNum = 25821184;BA.debugLine="Private Sub pan_all_set_date_Click";
RDebugUtils.currentLine=25821185;
 //BA.debugLineNum = 25821185;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25821186;
 //BA.debugLineNum = 25821186;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel4_click", null));}
RDebugUtils.currentLine=24707072;
 //BA.debugLineNum = 24707072;BA.debugLine="Private Sub Panel4_Click";
RDebugUtils.currentLine=24707074;
 //BA.debugLineNum = 24707074;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=25690112;
 //BA.debugLineNum = 25690112;BA.debugLine="Private Sub pik_day_bala1_Click";
RDebugUtils.currentLine=25690113;
 //BA.debugLineNum = 25690113;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=25690114;
 //BA.debugLineNum = 25690114;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=25690117;
 //BA.debugLineNum = 25690117;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=25690118;
 //BA.debugLineNum = 25690118;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=25690119;
 //BA.debugLineNum = 25690119;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=25690121;
 //BA.debugLineNum = 25690121;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=25690122;
 //BA.debugLineNum = 25690122;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=25690125;
 //BA.debugLineNum = 25690125;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=25690126;
 //BA.debugLineNum = 25690126;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=25690128;
 //BA.debugLineNum = 25690128;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=25690129;
 //BA.debugLineNum = 25690129;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=25690133;
 //BA.debugLineNum = 25690133;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=25755648;
 //BA.debugLineNum = 25755648;BA.debugLine="Private Sub pik_day_paeen1_Click";
RDebugUtils.currentLine=25755649;
 //BA.debugLineNum = 25755649;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=25755650;
 //BA.debugLineNum = 25755650;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=25755651;
 //BA.debugLineNum = 25755651;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=25755652;
 //BA.debugLineNum = 25755652;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=25755653;
 //BA.debugLineNum = 25755653;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=25755655;
 //BA.debugLineNum = 25755655;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=25755656;
 //BA.debugLineNum = 25755656;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=25755659;
 //BA.debugLineNum = 25755659;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=25755660;
 //BA.debugLineNum = 25755660;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=25755662;
 //BA.debugLineNum = 25755662;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=25755663;
 //BA.debugLineNum = 25755663;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=25755667;
 //BA.debugLineNum = 25755667;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=25427968;
 //BA.debugLineNum = 25427968;BA.debugLine="Private Sub pik_moon_bala1_Click";
RDebugUtils.currentLine=25427969;
 //BA.debugLineNum = 25427969;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=25427970;
 //BA.debugLineNum = 25427970;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
RDebugUtils.currentLine=25427972;
 //BA.debugLineNum = 25427972;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=25427973;
 //BA.debugLineNum = 25427973;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=25427975;
 //BA.debugLineNum = 25427975;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=25427976;
 //BA.debugLineNum = 25427976;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=25427978;
 //BA.debugLineNum = 25427978;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=25427980;
 //BA.debugLineNum = 25427980;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=25493504;
 //BA.debugLineNum = 25493504;BA.debugLine="Private Sub pik_moon_paeen1_Click";
RDebugUtils.currentLine=25493505;
 //BA.debugLineNum = 25493505;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=25493506;
 //BA.debugLineNum = 25493506;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
RDebugUtils.currentLine=25493508;
 //BA.debugLineNum = 25493508;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=25493509;
 //BA.debugLineNum = 25493509;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=25493511;
 //BA.debugLineNum = 25493511;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=25493512;
 //BA.debugLineNum = 25493512;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=25493514;
 //BA.debugLineNum = 25493514;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
RDebugUtils.currentLine=25493516;
 //BA.debugLineNum = 25493516;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_day1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_day1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=25362432;
 //BA.debugLineNum = 25362432;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
RDebugUtils.currentLine=25362433;
 //BA.debugLineNum = 25362433;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=25362434;
 //BA.debugLineNum = 25362434;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=25362435;
 //BA.debugLineNum = 25362435;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=25362438;
 //BA.debugLineNum = 25362438;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=25362440;
 //BA.debugLineNum = 25362440;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=25362441;
 //BA.debugLineNum = 25362441;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
RDebugUtils.currentLine=25362442;
 //BA.debugLineNum = 25362442;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=25362443;
 //BA.debugLineNum = 25362443;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=25362445;
 //BA.debugLineNum = 25362445;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=25362446;
 //BA.debugLineNum = 25362446;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
RDebugUtils.currentLine=25362447;
 //BA.debugLineNum = 25362447;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=25362448;
 //BA.debugLineNum = 25362448;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=25362451;
 //BA.debugLineNum = 25362451;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=25362452;
 //BA.debugLineNum = 25362452;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=25362453;
 //BA.debugLineNum = 25362453;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=25362455;
 //BA.debugLineNum = 25362455;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=25362456;
 //BA.debugLineNum = 25362456;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=25362459;
 //BA.debugLineNum = 25362459;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=25362460;
 //BA.debugLineNum = 25362460;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=25362462;
 //BA.debugLineNum = 25362462;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=25362463;
 //BA.debugLineNum = 25362463;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 };
RDebugUtils.currentLine=25362470;
 //BA.debugLineNum = 25362470;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_moon1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_moon1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=25231360;
 //BA.debugLineNum = 25231360;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
RDebugUtils.currentLine=25231361;
 //BA.debugLineNum = 25231361;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=25231362;
 //BA.debugLineNum = 25231362;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=25231363;
 //BA.debugLineNum = 25231363;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=25231366;
 //BA.debugLineNum = 25231366;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=25231368;
 //BA.debugLineNum = 25231368;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=25231369;
 //BA.debugLineNum = 25231369;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
RDebugUtils.currentLine=25231370;
 //BA.debugLineNum = 25231370;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=25231371;
 //BA.debugLineNum = 25231371;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=25231373;
 //BA.debugLineNum = 25231373;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=25231374;
 //BA.debugLineNum = 25231374;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
RDebugUtils.currentLine=25231375;
 //BA.debugLineNum = 25231375;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=25231376;
 //BA.debugLineNum = 25231376;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=25231379;
 //BA.debugLineNum = 25231379;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=25231380;
 //BA.debugLineNum = 25231380;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=25231382;
 //BA.debugLineNum = 25231382;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=25231383;
 //BA.debugLineNum = 25231383;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=25231385;
 //BA.debugLineNum = 25231385;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
RDebugUtils.currentLine=25231388;
 //BA.debugLineNum = 25231388;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_year1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_year1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=25296896;
 //BA.debugLineNum = 25296896;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
RDebugUtils.currentLine=25296897;
 //BA.debugLineNum = 25296897;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=25296898;
 //BA.debugLineNum = 25296898;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=25296899;
 //BA.debugLineNum = 25296899;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=25296902;
 //BA.debugLineNum = 25296902;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=25296904;
 //BA.debugLineNum = 25296904;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=25296905;
 //BA.debugLineNum = 25296905;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
RDebugUtils.currentLine=25296906;
 //BA.debugLineNum = 25296906;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=25296907;
 //BA.debugLineNum = 25296907;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=25296909;
 //BA.debugLineNum = 25296909;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=25296910;
 //BA.debugLineNum = 25296910;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
RDebugUtils.currentLine=25296911;
 //BA.debugLineNum = 25296911;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=25296912;
 //BA.debugLineNum = 25296912;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=25296915;
 //BA.debugLineNum = 25296915;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=25296916;
 //BA.debugLineNum = 25296916;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=25296918;
 //BA.debugLineNum = 25296918;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=25296919;
 //BA.debugLineNum = 25296919;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
RDebugUtils.currentLine=25296924;
 //BA.debugLineNum = 25296924;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=25559040;
 //BA.debugLineNum = 25559040;BA.debugLine="Private Sub pik_year_bala1_Click";
RDebugUtils.currentLine=25559041;
 //BA.debugLineNum = 25559041;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=25559042;
 //BA.debugLineNum = 25559042;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=25559044;
 //BA.debugLineNum = 25559044;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=25559045;
 //BA.debugLineNum = 25559045;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=25559047;
 //BA.debugLineNum = 25559047;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=25559048;
 //BA.debugLineNum = 25559048;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=25559051;
 //BA.debugLineNum = 25559051;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
RDebugUtils.currentModule="morakhasi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=25624576;
 //BA.debugLineNum = 25624576;BA.debugLine="Private Sub pik_year_paeen1_Click";
RDebugUtils.currentLine=25624577;
 //BA.debugLineNum = 25624577;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=25624578;
 //BA.debugLineNum = 25624578;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=25624580;
 //BA.debugLineNum = 25624580;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=25624581;
 //BA.debugLineNum = 25624581;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=25624583;
 //BA.debugLineNum = 25624583;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=25624584;
 //BA.debugLineNum = 25624584;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=25624587;
 //BA.debugLineNum = 25624587;BA.debugLine="End Sub";
return "";
}
}