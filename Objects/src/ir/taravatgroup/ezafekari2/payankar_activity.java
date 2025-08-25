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

public class payankar_activity extends Activity implements B4AActivity{
	public static payankar_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.payankar_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (payankar_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.payankar_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.payankar_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (payankar_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (payankar_activity) Resume **");
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
		return payankar_activity.class;
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
            BA.LogInfo("** Activity (payankar_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (payankar_activity) Pause event (activity is not paused). **");
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
            payankar_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (payankar_activity) Resume **");
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
public anywheresoftware.b4a.objects.EditTextWrapper _et_payeh = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_payankar = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_payankar = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_set_date = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_day1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_moon1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_year1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date2 = null;
public static int _num_datapik = 0;
public anywheresoftware.b4a.objects.collections.List _moon_datapik = null;
public static int _index_datepik = 0;
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
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
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.mosaedeh_activity _mosaedeh_activity = null;
public ir.taravatgroup.ezafekari2.padash_activity _padash_activity = null;
public ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
public ir.taravatgroup.ezafekari2.savabeg_activity _savabeg_activity = null;
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
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=31195136;
 //BA.debugLineNum = 31195136;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=31195138;
 //BA.debugLineNum = 31195138;BA.debugLine="Activity.LoadLayout(\"payankar_layout\")";
mostCurrent._activity.LoadLayout("payankar_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=31195140;
 //BA.debugLineNum = 31195140;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=31195141;
 //BA.debugLineNum = 31195141;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=31195143;
 //BA.debugLineNum = 31195143;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=31195144;
 //BA.debugLineNum = 31195144;BA.debugLine="et_payeh.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_payeh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=31195145;
 //BA.debugLineNum = 31195145;BA.debugLine="et_payeh.Text=show_num_pool(dbCode.res.GetString(";
mostCurrent._et_payeh.setText(BA.ObjectToCharSequence(_show_num_pool((int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=31195147;
 //BA.debugLineNum = 31195147;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=31195148;
 //BA.debugLineNum = 31195148;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=31195151;
 //BA.debugLineNum = 31195151;BA.debugLine="lbl_date1.Text=myfunc.fa2en(Main.persianDate.Pers";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())+"/01/01")));
RDebugUtils.currentLine=31195152;
 //BA.debugLineNum = 31195152;BA.debugLine="lbl_date2.Text=myfunc.fa2en(Main.persianDate.Pers";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate())));
RDebugUtils.currentLine=31195154;
 //BA.debugLineNum = 31195154;BA.debugLine="et_payeh.Color=Colors.White";
mostCurrent._et_payeh.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31195158;
 //BA.debugLineNum = 31195158;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
RDebugUtils.currentLine=31195159;
 //BA.debugLineNum = 31195159;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=31195165;
 //BA.debugLineNum = 31195165;BA.debugLine="pan_hed_payankar.Color=Main.color4";
mostCurrent._pan_hed_payankar.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=31195166;
 //BA.debugLineNum = 31195166;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=31195167;
 //BA.debugLineNum = 31195167;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(int _num) throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_num_pool", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_num_pool", new Object[] {_num}));}
RDebugUtils.currentLine=31588352;
 //BA.debugLineNum = 31588352;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=31588353;
 //BA.debugLineNum = 31588353;BA.debugLine="Return NumberFormat(num,0,0)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (0));
RDebugUtils.currentLine=31588354;
 //BA.debugLineNum = 31588354;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=31457280;
 //BA.debugLineNum = 31457280;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=31457281;
 //BA.debugLineNum = 31457281;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=31457282;
 //BA.debugLineNum = 31457282;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=31457283;
 //BA.debugLineNum = 31457283;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=31457285;
 //BA.debugLineNum = 31457285;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=31457287;
 //BA.debugLineNum = 31457287;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=31391744;
 //BA.debugLineNum = 31391744;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=31391746;
 //BA.debugLineNum = 31391746;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=31391747;
 //BA.debugLineNum = 31391747;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="payankar_activity";
RDebugUtils.currentLine=31326208;
 //BA.debugLineNum = 31326208;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=31326210;
 //BA.debugLineNum = 31326210;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=31260672;
 //BA.debugLineNum = 31260672;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=31260674;
 //BA.debugLineNum = 31260674;BA.debugLine="End Sub";
return "";
}
public static String  _btn_mohasebe_payankar_click() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_mohasebe_payankar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_mohasebe_payankar_click", null));}
int _payankar_roz = 0;
int _rozha = 0;
int _payankar = 0;
RDebugUtils.currentLine=31522816;
 //BA.debugLineNum = 31522816;BA.debugLine="Private Sub btn_mohasebe_payankar_Click";
RDebugUtils.currentLine=31522817;
 //BA.debugLineNum = 31522817;BA.debugLine="Dim payankar_roz As Int";
_payankar_roz = 0;
RDebugUtils.currentLine=31522818;
 //BA.debugLineNum = 31522818;BA.debugLine="Dim rozha As Int";
_rozha = 0;
RDebugUtils.currentLine=31522819;
 //BA.debugLineNum = 31522819;BA.debugLine="Dim payankar As Int";
_payankar = 0;
RDebugUtils.currentLine=31522821;
 //BA.debugLineNum = 31522821;BA.debugLine="If(et_payeh.Text=\"\")Then";
if (((mostCurrent._et_payeh.getText()).equals(""))) { 
RDebugUtils.currentLine=31522822;
 //BA.debugLineNum = 31522822;BA.debugLine="et_payeh.Text=0";
mostCurrent._et_payeh.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31522823;
 //BA.debugLineNum = 31522823;BA.debugLine="et_payeh.Tag=0";
mostCurrent._et_payeh.setTag((Object)(0));
 };
RDebugUtils.currentLine=31522827;
 //BA.debugLineNum = 31522827;BA.debugLine="payankar_roz=et_payeh.Tag/365";
_payankar_roz = (int) ((double)(BA.ObjectToNumber(mostCurrent._et_payeh.getTag()))/(double)365);
RDebugUtils.currentLine=31522828;
 //BA.debugLineNum = 31522828;BA.debugLine="rozha=myfunc.time_mohasebe(lbl_date1.Text,lbl_dat";
_rozha = mostCurrent._myfunc._time_mohasebe /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date1.getText(),mostCurrent._lbl_date2.getText());
RDebugUtils.currentLine=31522830;
 //BA.debugLineNum = 31522830;BA.debugLine="payankar=payankar_roz*rozha";
_payankar = (int) (_payankar_roz*_rozha);
RDebugUtils.currentLine=31522831;
 //BA.debugLineNum = 31522831;BA.debugLine="If(rozha=365)Then";
if ((_rozha==365)) { 
RDebugUtils.currentLine=31522832;
 //BA.debugLineNum = 31522832;BA.debugLine="payankar=et_payeh.Tag";
_payankar = (int)(BA.ObjectToNumber(mostCurrent._et_payeh.getTag()));
 };
RDebugUtils.currentLine=31522837;
 //BA.debugLineNum = 31522837;BA.debugLine="lbl_payankar.Text=\"تعداد روزها : \"&rozha&CRLF&\"پا";
mostCurrent._lbl_payankar.setText(BA.ObjectToCharSequence("تعداد روزها : "+BA.NumberToString(_rozha)+anywheresoftware.b4a.keywords.Common.CRLF+"پایان کار دریافتی :"+_show_num_pool(_payankar)));
RDebugUtils.currentLine=31522839;
 //BA.debugLineNum = 31522839;BA.debugLine="End Sub";
return "";
}
public static String  _change_formater(String _old,String _new,anywheresoftware.b4a.objects.EditTextWrapper _et_name) throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "change_formater", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "change_formater", new Object[] {_old,_new,_et_name}));}
double _d = 0;
String _s = "";
String _n = "";
String _o = "";
RDebugUtils.currentLine=31653888;
 //BA.debugLineNum = 31653888;BA.debugLine="Sub change_formater (Old As String, New As String,";
RDebugUtils.currentLine=31653889;
 //BA.debugLineNum = 31653889;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
_d = 0;
RDebugUtils.currentLine=31653890;
 //BA.debugLineNum = 31653890;BA.debugLine="Dim S,N,O As String";
_s = "";
_n = "";
_o = "";
RDebugUtils.currentLine=31653891;
 //BA.debugLineNum = 31653891;BA.debugLine="n=New.Replace(\",\",\"\")";
_n = _new.replace(",","");
RDebugUtils.currentLine=31653892;
 //BA.debugLineNum = 31653892;BA.debugLine="O=Old.Replace(\",\",\"\")";
_o = _old.replace(",","");
RDebugUtils.currentLine=31653893;
 //BA.debugLineNum = 31653893;BA.debugLine="If O<>N Then";
if ((_o).equals(_n) == false) { 
RDebugUtils.currentLine=31653894;
 //BA.debugLineNum = 31653894;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
_et_name.setText(BA.ObjectToCharSequence(_et_name.getText().replace(",","")));
RDebugUtils.currentLine=31653895;
 //BA.debugLineNum = 31653895;BA.debugLine="S=et_name.Text";
_s = _et_name.getText();
RDebugUtils.currentLine=31653896;
 //BA.debugLineNum = 31653896;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_s)==anywheresoftware.b4a.keywords.Common.True && (_s).equals("0") == false) { 
RDebugUtils.currentLine=31653897;
 //BA.debugLineNum = 31653897;BA.debugLine="D=s";
_d = (double)(Double.parseDouble(_s));
RDebugUtils.currentLine=31653898;
 //BA.debugLineNum = 31653898;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
_et_name.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_d,(int) (0),(int) (0))));
 };
 };
RDebugUtils.currentLine=31653901;
 //BA.debugLineNum = 31653901;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
_et_name.setSelectionStart(_et_name.getText().length());
RDebugUtils.currentLine=31653902;
 //BA.debugLineNum = 31653902;BA.debugLine="End Sub";
return "";
}
public static String  _et_payeh_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_payeh_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_payeh_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=31719424;
 //BA.debugLineNum = 31719424;BA.debugLine="Private Sub et_payeh_TextChanged (Old As String, N";
RDebugUtils.currentLine=31719425;
 //BA.debugLineNum = 31719425;BA.debugLine="et_payeh.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_payeh.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=31719426;
 //BA.debugLineNum = 31719426;BA.debugLine="change_formater(Old,New,et_payeh)";
_change_formater(_old,_new,mostCurrent._et_payeh);
RDebugUtils.currentLine=31719427;
 //BA.debugLineNum = 31719427;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date1_click() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date1_click", null));}
RDebugUtils.currentLine=31784960;
 //BA.debugLineNum = 31784960;BA.debugLine="Private Sub lbl_date1_Click";
RDebugUtils.currentLine=31784961;
 //BA.debugLineNum = 31784961;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=31784962;
 //BA.debugLineNum = 31784962;BA.debugLine="index_datePik=1";
_index_datepik = (int) (1);
RDebugUtils.currentLine=31784964;
 //BA.debugLineNum = 31784964;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date1.Text.SubStr";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date1.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=31784965;
 //BA.debugLineNum = 31784965;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date1.Text.SubStri";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date1.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=31784966;
 //BA.debugLineNum = 31784966;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=31784967;
 //BA.debugLineNum = 31784967;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date1.Text.SubStri";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date1.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=31784968;
 //BA.debugLineNum = 31784968;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date2_click() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date2_click", null));}
RDebugUtils.currentLine=31850496;
 //BA.debugLineNum = 31850496;BA.debugLine="Private Sub lbl_date2_Click";
RDebugUtils.currentLine=31850497;
 //BA.debugLineNum = 31850497;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=31850498;
 //BA.debugLineNum = 31850498;BA.debugLine="index_datePik=2";
_index_datepik = (int) (2);
RDebugUtils.currentLine=31850500;
 //BA.debugLineNum = 31850500;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date2.Text.SubStr";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date2.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=31850501;
 //BA.debugLineNum = 31850501;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date2.Text.SubStri";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date2.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=31850502;
 //BA.debugLineNum = 31850502;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=31850503;
 //BA.debugLineNum = 31850503;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date2.Text.SubStri";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date2.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=31850504;
 //BA.debugLineNum = 31850504;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_picker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_picker_click", null));}
RDebugUtils.currentLine=31916032;
 //BA.debugLineNum = 31916032;BA.debugLine="Private Sub lbl_save_picker_Click";
RDebugUtils.currentLine=31916033;
 //BA.debugLineNum = 31916033;BA.debugLine="If(index_datePik=1) Then";
if ((_index_datepik==1)) { 
RDebugUtils.currentLine=31916034;
 //BA.debugLineNum = 31916034;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&myfunc.convert";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 }else 
{RDebugUtils.currentLine=31916036;
 //BA.debugLineNum = 31916036;BA.debugLine="Else If(index_datePik=2) Then";
if ((_index_datepik==2)) { 
RDebugUtils.currentLine=31916037;
 //BA.debugLineNum = 31916037;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&myfunc.convert";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 }}
;
RDebugUtils.currentLine=31916039;
 //BA.debugLineNum = 31916039;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=31916040;
 //BA.debugLineNum = 31916040;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_set_date_click() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_set_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_set_date_click", null));}
RDebugUtils.currentLine=32571392;
 //BA.debugLineNum = 32571392;BA.debugLine="Private Sub pan_all_set_date_Click";
RDebugUtils.currentLine=32571393;
 //BA.debugLineNum = 32571393;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=32571394;
 //BA.debugLineNum = 32571394;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=32440320;
 //BA.debugLineNum = 32440320;BA.debugLine="Private Sub pik_day_bala1_Click";
RDebugUtils.currentLine=32440321;
 //BA.debugLineNum = 32440321;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=32440322;
 //BA.debugLineNum = 32440322;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=32440325;
 //BA.debugLineNum = 32440325;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=32440326;
 //BA.debugLineNum = 32440326;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=32440327;
 //BA.debugLineNum = 32440327;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=32440329;
 //BA.debugLineNum = 32440329;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=32440330;
 //BA.debugLineNum = 32440330;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=32440333;
 //BA.debugLineNum = 32440333;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=32440334;
 //BA.debugLineNum = 32440334;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=32440336;
 //BA.debugLineNum = 32440336;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=32440337;
 //BA.debugLineNum = 32440337;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=32440340;
 //BA.debugLineNum = 32440340;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=32440341;
 //BA.debugLineNum = 32440341;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=32505856;
 //BA.debugLineNum = 32505856;BA.debugLine="Private Sub pik_day_paeen1_Click";
RDebugUtils.currentLine=32505857;
 //BA.debugLineNum = 32505857;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=32505858;
 //BA.debugLineNum = 32505858;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=32505859;
 //BA.debugLineNum = 32505859;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=32505860;
 //BA.debugLineNum = 32505860;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=32505861;
 //BA.debugLineNum = 32505861;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=32505863;
 //BA.debugLineNum = 32505863;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=32505864;
 //BA.debugLineNum = 32505864;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=32505867;
 //BA.debugLineNum = 32505867;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=32505868;
 //BA.debugLineNum = 32505868;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=32505870;
 //BA.debugLineNum = 32505870;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=32505871;
 //BA.debugLineNum = 32505871;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=32505874;
 //BA.debugLineNum = 32505874;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=32505875;
 //BA.debugLineNum = 32505875;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=32178176;
 //BA.debugLineNum = 32178176;BA.debugLine="Private Sub pik_moon_bala1_Click";
RDebugUtils.currentLine=32178177;
 //BA.debugLineNum = 32178177;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=32178178;
 //BA.debugLineNum = 32178178;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
RDebugUtils.currentLine=32178180;
 //BA.debugLineNum = 32178180;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=32178181;
 //BA.debugLineNum = 32178181;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=32178183;
 //BA.debugLineNum = 32178183;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=32178184;
 //BA.debugLineNum = 32178184;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=32178186;
 //BA.debugLineNum = 32178186;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=32178188;
 //BA.debugLineNum = 32178188;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=32243712;
 //BA.debugLineNum = 32243712;BA.debugLine="Private Sub pik_moon_paeen1_Click";
RDebugUtils.currentLine=32243713;
 //BA.debugLineNum = 32243713;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=32243714;
 //BA.debugLineNum = 32243714;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
RDebugUtils.currentLine=32243716;
 //BA.debugLineNum = 32243716;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=32243717;
 //BA.debugLineNum = 32243717;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=32243719;
 //BA.debugLineNum = 32243719;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=32243720;
 //BA.debugLineNum = 32243720;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=32243722;
 //BA.debugLineNum = 32243722;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
RDebugUtils.currentLine=32243724;
 //BA.debugLineNum = 32243724;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_day1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_day1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=32112640;
 //BA.debugLineNum = 32112640;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
RDebugUtils.currentLine=32112641;
 //BA.debugLineNum = 32112641;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=32112642;
 //BA.debugLineNum = 32112642;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=32112643;
 //BA.debugLineNum = 32112643;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=32112646;
 //BA.debugLineNum = 32112646;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=32112648;
 //BA.debugLineNum = 32112648;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=32112649;
 //BA.debugLineNum = 32112649;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
RDebugUtils.currentLine=32112650;
 //BA.debugLineNum = 32112650;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=32112651;
 //BA.debugLineNum = 32112651;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=32112653;
 //BA.debugLineNum = 32112653;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=32112654;
 //BA.debugLineNum = 32112654;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
RDebugUtils.currentLine=32112655;
 //BA.debugLineNum = 32112655;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=32112656;
 //BA.debugLineNum = 32112656;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=32112659;
 //BA.debugLineNum = 32112659;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=32112660;
 //BA.debugLineNum = 32112660;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=32112661;
 //BA.debugLineNum = 32112661;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=32112663;
 //BA.debugLineNum = 32112663;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=32112664;
 //BA.debugLineNum = 32112664;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=32112667;
 //BA.debugLineNum = 32112667;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=32112668;
 //BA.debugLineNum = 32112668;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=32112670;
 //BA.debugLineNum = 32112670;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=32112671;
 //BA.debugLineNum = 32112671;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=32112674;
 //BA.debugLineNum = 32112674;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 };
RDebugUtils.currentLine=32112678;
 //BA.debugLineNum = 32112678;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_moon1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_moon1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=31981568;
 //BA.debugLineNum = 31981568;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
RDebugUtils.currentLine=31981569;
 //BA.debugLineNum = 31981569;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=31981570;
 //BA.debugLineNum = 31981570;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=31981571;
 //BA.debugLineNum = 31981571;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=31981574;
 //BA.debugLineNum = 31981574;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=31981576;
 //BA.debugLineNum = 31981576;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=31981577;
 //BA.debugLineNum = 31981577;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
RDebugUtils.currentLine=31981578;
 //BA.debugLineNum = 31981578;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=31981579;
 //BA.debugLineNum = 31981579;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=31981581;
 //BA.debugLineNum = 31981581;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=31981582;
 //BA.debugLineNum = 31981582;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
RDebugUtils.currentLine=31981583;
 //BA.debugLineNum = 31981583;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=31981584;
 //BA.debugLineNum = 31981584;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=31981587;
 //BA.debugLineNum = 31981587;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=31981588;
 //BA.debugLineNum = 31981588;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=31981590;
 //BA.debugLineNum = 31981590;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=31981591;
 //BA.debugLineNum = 31981591;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=31981593;
 //BA.debugLineNum = 31981593;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
RDebugUtils.currentLine=31981596;
 //BA.debugLineNum = 31981596;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_year1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_year1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=32047104;
 //BA.debugLineNum = 32047104;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
RDebugUtils.currentLine=32047105;
 //BA.debugLineNum = 32047105;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=32047106;
 //BA.debugLineNum = 32047106;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=32047107;
 //BA.debugLineNum = 32047107;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=32047110;
 //BA.debugLineNum = 32047110;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=32047112;
 //BA.debugLineNum = 32047112;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=32047113;
 //BA.debugLineNum = 32047113;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
RDebugUtils.currentLine=32047114;
 //BA.debugLineNum = 32047114;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=32047115;
 //BA.debugLineNum = 32047115;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=32047117;
 //BA.debugLineNum = 32047117;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=32047118;
 //BA.debugLineNum = 32047118;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
RDebugUtils.currentLine=32047119;
 //BA.debugLineNum = 32047119;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=32047120;
 //BA.debugLineNum = 32047120;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=32047123;
 //BA.debugLineNum = 32047123;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=32047124;
 //BA.debugLineNum = 32047124;BA.debugLine="pik_year1.Text=1380";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1380));
 };
RDebugUtils.currentLine=32047126;
 //BA.debugLineNum = 32047126;BA.debugLine="If(pik_year1.Text<1380)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1380)) { 
RDebugUtils.currentLine=32047127;
 //BA.debugLineNum = 32047127;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
RDebugUtils.currentLine=32047132;
 //BA.debugLineNum = 32047132;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=32309248;
 //BA.debugLineNum = 32309248;BA.debugLine="Private Sub pik_year_bala1_Click";
RDebugUtils.currentLine=32309249;
 //BA.debugLineNum = 32309249;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=32309250;
 //BA.debugLineNum = 32309250;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=32309252;
 //BA.debugLineNum = 32309252;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=32309253;
 //BA.debugLineNum = 32309253;BA.debugLine="pik_year1.Text=1380";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1380));
 };
RDebugUtils.currentLine=32309255;
 //BA.debugLineNum = 32309255;BA.debugLine="If(pik_year1.Text<1380)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1380)) { 
RDebugUtils.currentLine=32309256;
 //BA.debugLineNum = 32309256;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=32309259;
 //BA.debugLineNum = 32309259;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=32374784;
 //BA.debugLineNum = 32374784;BA.debugLine="Private Sub pik_year_paeen1_Click";
RDebugUtils.currentLine=32374785;
 //BA.debugLineNum = 32374785;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=32374786;
 //BA.debugLineNum = 32374786;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=32374788;
 //BA.debugLineNum = 32374788;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=32374789;
 //BA.debugLineNum = 32374789;BA.debugLine="pik_year1.Text=1380";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1380));
 };
RDebugUtils.currentLine=32374791;
 //BA.debugLineNum = 32374791;BA.debugLine="If(pik_year1.Text<1380)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1380)) { 
RDebugUtils.currentLine=32374792;
 //BA.debugLineNum = 32374792;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=32374795;
 //BA.debugLineNum = 32374795;BA.debugLine="End Sub";
return "";
}
}