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

public class eidi_activity extends Activity implements B4AActivity{
	public static eidi_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.eidi_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (eidi_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.eidi_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.eidi_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (eidi_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (eidi_activity) Resume **");
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
		return eidi_activity.class;
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
            BA.LogInfo("** Activity (eidi_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (eidi_activity) Pause event (activity is not paused). **");
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
            eidi_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (eidi_activity) Resume **");
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
public anywheresoftware.b4a.objects.LabelWrapper _lbl_eidi = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_date1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_date2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_eydi = null;
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
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=23527424;
 //BA.debugLineNum = 23527424;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=23527426;
 //BA.debugLineNum = 23527426;BA.debugLine="Activity.LoadLayout(\"eidi_layout\")";
mostCurrent._activity.LoadLayout("eidi_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=23527429;
 //BA.debugLineNum = 23527429;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=23527430;
 //BA.debugLineNum = 23527430;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=23527432;
 //BA.debugLineNum = 23527432;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=23527433;
 //BA.debugLineNum = 23527433;BA.debugLine="et_payeh.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_payeh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=23527434;
 //BA.debugLineNum = 23527434;BA.debugLine="et_payeh.Text=show_num_pool(dbCode.res.GetString(";
mostCurrent._et_payeh.setText(BA.ObjectToCharSequence(_show_num_pool((int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=23527436;
 //BA.debugLineNum = 23527436;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=23527437;
 //BA.debugLineNum = 23527437;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=23527440;
 //BA.debugLineNum = 23527440;BA.debugLine="et_date1.Text=myfunc.fa2en(Main.persianDate.Persi";
mostCurrent._et_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())+"/01/01")));
RDebugUtils.currentLine=23527441;
 //BA.debugLineNum = 23527441;BA.debugLine="et_date2.Text=myfunc.fa2en(Main.persianDate.Persi";
mostCurrent._et_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate())));
RDebugUtils.currentLine=23527444;
 //BA.debugLineNum = 23527444;BA.debugLine="et_payeh.Color=Colors.White";
mostCurrent._et_payeh.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=23527445;
 //BA.debugLineNum = 23527445;BA.debugLine="et_date1.Color=Colors.White";
mostCurrent._et_date1.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=23527446;
 //BA.debugLineNum = 23527446;BA.debugLine="et_date2.Color=Colors.White";
mostCurrent._et_date2.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=23527450;
 //BA.debugLineNum = 23527450;BA.debugLine="pan_hed_eydi.Color=Main.color4";
mostCurrent._pan_hed_eydi.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=23527451;
 //BA.debugLineNum = 23527451;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=23527452;
 //BA.debugLineNum = 23527452;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(int _num) throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_num_pool", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_num_pool", new Object[] {_num}));}
RDebugUtils.currentLine=23986176;
 //BA.debugLineNum = 23986176;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=23986177;
 //BA.debugLineNum = 23986177;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
RDebugUtils.currentLine=23986178;
 //BA.debugLineNum = 23986178;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=23789568;
 //BA.debugLineNum = 23789568;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=23789569;
 //BA.debugLineNum = 23789569;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=23789570;
 //BA.debugLineNum = 23789570;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=23789571;
 //BA.debugLineNum = 23789571;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=23789573;
 //BA.debugLineNum = 23789573;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=23789575;
 //BA.debugLineNum = 23789575;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=23724032;
 //BA.debugLineNum = 23724032;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=23724034;
 //BA.debugLineNum = 23724034;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=23724035;
 //BA.debugLineNum = 23724035;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="eidi_activity";
RDebugUtils.currentLine=23658496;
 //BA.debugLineNum = 23658496;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=23658498;
 //BA.debugLineNum = 23658498;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=23592960;
 //BA.debugLineNum = 23592960;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=23592962;
 //BA.debugLineNum = 23592962;BA.debugLine="End Sub";
return "";
}
public static String  _btn_mohasebe_eidi_click() throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_mohasebe_eidi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_mohasebe_eidi_click", null));}
int _eidi_roz = 0;
int _rozha = 0;
int _eidi_nakhales = 0;
int _eidi_khales = 0;
int _eidi_maliat = 0;
RDebugUtils.currentLine=23855104;
 //BA.debugLineNum = 23855104;BA.debugLine="Private Sub btn_mohasebe_eidi_Click";
RDebugUtils.currentLine=23855105;
 //BA.debugLineNum = 23855105;BA.debugLine="Dim eidi_roz As Int";
_eidi_roz = 0;
RDebugUtils.currentLine=23855106;
 //BA.debugLineNum = 23855106;BA.debugLine="Dim rozha As Int";
_rozha = 0;
RDebugUtils.currentLine=23855107;
 //BA.debugLineNum = 23855107;BA.debugLine="Dim eidi_nakhales As Int";
_eidi_nakhales = 0;
RDebugUtils.currentLine=23855108;
 //BA.debugLineNum = 23855108;BA.debugLine="Dim eidi_khales As Int";
_eidi_khales = 0;
RDebugUtils.currentLine=23855109;
 //BA.debugLineNum = 23855109;BA.debugLine="Dim eidi_maliat As Int";
_eidi_maliat = 0;
RDebugUtils.currentLine=23855111;
 //BA.debugLineNum = 23855111;BA.debugLine="If(et_payeh.Text=\"\")Then";
if (((mostCurrent._et_payeh.getText()).equals(""))) { 
RDebugUtils.currentLine=23855112;
 //BA.debugLineNum = 23855112;BA.debugLine="et_payeh.Text=0";
mostCurrent._et_payeh.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=23855113;
 //BA.debugLineNum = 23855113;BA.debugLine="et_payeh.Tag=0";
mostCurrent._et_payeh.setTag((Object)(0));
 };
RDebugUtils.currentLine=23855117;
 //BA.debugLineNum = 23855117;BA.debugLine="eidi_roz=(et_payeh.Tag*2)/365";
_eidi_roz = (int) (((double)(BA.ObjectToNumber(mostCurrent._et_payeh.getTag()))*2)/(double)365);
RDebugUtils.currentLine=23855118;
 //BA.debugLineNum = 23855118;BA.debugLine="rozha=time_mohasebe(et_date1.Text,et_date2.Text)";
_rozha = _time_mohasebe(mostCurrent._et_date1.getText(),mostCurrent._et_date2.getText());
RDebugUtils.currentLine=23855120;
 //BA.debugLineNum = 23855120;BA.debugLine="eidi_nakhales=eidi_roz*rozha";
_eidi_nakhales = (int) (_eidi_roz*_rozha);
RDebugUtils.currentLine=23855121;
 //BA.debugLineNum = 23855121;BA.debugLine="If(rozha=365)Then";
if ((_rozha==365)) { 
RDebugUtils.currentLine=23855122;
 //BA.debugLineNum = 23855122;BA.debugLine="eidi_nakhales=et_payeh.Tag*2";
_eidi_nakhales = (int) ((double)(BA.ObjectToNumber(mostCurrent._et_payeh.getTag()))*2);
 };
RDebugUtils.currentLine=23855124;
 //BA.debugLineNum = 23855124;BA.debugLine="eidi_maliat=mohasebe_maliat(eidi_nakhales , myfun";
_eidi_maliat = _mohasebe_maliat(_eidi_nakhales,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())))));
RDebugUtils.currentLine=23855125;
 //BA.debugLineNum = 23855125;BA.debugLine="eidi_khales=eidi_nakhales-eidi_maliat";
_eidi_khales = (int) (_eidi_nakhales-_eidi_maliat);
RDebugUtils.currentLine=23855127;
 //BA.debugLineNum = 23855127;BA.debugLine="lbl_eidi.Text=\"تعداد روزها : \"&rozha&CRLF&\"ناخالص";
mostCurrent._lbl_eidi.setText(BA.ObjectToCharSequence("تعداد روزها : "+BA.NumberToString(_rozha)+anywheresoftware.b4a.keywords.Common.CRLF+"ناخالص :"+_show_num_pool(_eidi_nakhales)+anywheresoftware.b4a.keywords.Common.CRLF+" مالیات : "+_show_num_pool(_eidi_maliat)+anywheresoftware.b4a.keywords.Common.CRLF+"خالص عیدی دریافتی :"+_show_num_pool(_eidi_khales)));
RDebugUtils.currentLine=23855129;
 //BA.debugLineNum = 23855129;BA.debugLine="End Sub";
return "";
}
public static int  _time_mohasebe(String _date1,String _date2) throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time_mohasebe", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "time_mohasebe", new Object[] {_date1,_date2}));}
adr.stringfunctions.stringfunctions _strfun = null;
anywheresoftware.b4a.objects.collections.List _list_date_per1 = null;
anywheresoftware.b4a.objects.collections.List _list_date_per2 = null;
anywheresoftware.b4a.objects.collections.List _list_date_miladi1 = null;
anywheresoftware.b4a.objects.collections.List _list_date_miladi2 = null;
String _dat_mil_2 = "";
String _dat_mil_1 = "";
String _date_end1 = "";
String _date_end2 = "";
long _tim1_long = 0L;
long _tim2_long = 0L;
int _rozha = 0;
RDebugUtils.currentLine=23920640;
 //BA.debugLineNum = 23920640;BA.debugLine="Sub time_mohasebe(date1 As String, date2 As String";
RDebugUtils.currentLine=23920642;
 //BA.debugLineNum = 23920642;BA.debugLine="Try";
try {RDebugUtils.currentLine=23920644;
 //BA.debugLineNum = 23920644;BA.debugLine="Dim strfun As StringFunctions";
_strfun = new adr.stringfunctions.stringfunctions();
RDebugUtils.currentLine=23920645;
 //BA.debugLineNum = 23920645;BA.debugLine="strfun.Initialize";
_strfun._initialize(processBA);
RDebugUtils.currentLine=23920646;
 //BA.debugLineNum = 23920646;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=23920647;
 //BA.debugLineNum = 23920647;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=23920648;
 //BA.debugLineNum = 23920648;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
RDebugUtils.currentLine=23920649;
 //BA.debugLineNum = 23920649;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
RDebugUtils.currentLine=23920651;
 //BA.debugLineNum = 23920651;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=23920652;
 //BA.debugLineNum = 23920652;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=23920653;
 //BA.debugLineNum = 23920653;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=23920654;
 //BA.debugLineNum = 23920654;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=23920658;
 //BA.debugLineNum = 23920658;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = _strfun._vvvvvv5(_date1,"/");
RDebugUtils.currentLine=23920659;
 //BA.debugLineNum = 23920659;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = _strfun._vvvvvv5(_date2,"/");
RDebugUtils.currentLine=23920663;
 //BA.debugLineNum = 23920663;BA.debugLine="dat_mil_2=Main.persianDate.PersianToGregorian(li";
_dat_mil_2 = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=23920664;
 //BA.debugLineNum = 23920664;BA.debugLine="dat_mil_1=Main.persianDate.PersianToGregorian(li";
_dat_mil_1 = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=23920667;
 //BA.debugLineNum = 23920667;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = _strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=23920668;
 //BA.debugLineNum = 23920668;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = _strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=23920671;
 //BA.debugLineNum = 23920671;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
RDebugUtils.currentLine=23920674;
 //BA.debugLineNum = 23920674;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=23920675;
 //BA.debugLineNum = 23920675;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=23920680;
 //BA.debugLineNum = 23920680;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
RDebugUtils.currentLine=23920681;
 //BA.debugLineNum = 23920681;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
RDebugUtils.currentLine=23920682;
 //BA.debugLineNum = 23920682;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),"00:00:00");
RDebugUtils.currentLine=23920683;
 //BA.debugLineNum = 23920683;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),"00:00:00");
RDebugUtils.currentLine=23920684;
 //BA.debugLineNum = 23920684;BA.debugLine="Dim rozha As Int";
_rozha = 0;
RDebugUtils.currentLine=23920685;
 //BA.debugLineNum = 23920685;BA.debugLine="rozha=Main.persianDate.CalculateDaysBetween(myfu";
_rozha = (int) (mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .CalculateDaysBetween(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2)));
RDebugUtils.currentLine=23920687;
 //BA.debugLineNum = 23920687;BA.debugLine="Return rozha+1";
if (true) return (int) (_rozha+1);
 } 
       catch (Exception e29) {
			processBA.setLastException(e29);RDebugUtils.currentLine=23920690;
 //BA.debugLineNum = 23920690;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=23920692;
 //BA.debugLineNum = 23920692;BA.debugLine="End Sub";
return 0;
}
public static int  _mohasebe_maliat(int _hogog,int _year) throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mohasebe_maliat", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "mohasebe_maliat", new Object[] {_hogog,_year}));}
int _all_maliat = 0;
int _state1 = 0;
int _state2 = 0;
int _state3 = 0;
int _state4 = 0;
int _state5 = 0;
int _state6 = 0;
RDebugUtils.currentLine=24182784;
 //BA.debugLineNum = 24182784;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
RDebugUtils.currentLine=24182785;
 //BA.debugLineNum = 24182785;BA.debugLine="Dim all_maliat As Int=0";
_all_maliat = (int) (0);
RDebugUtils.currentLine=24182786;
 //BA.debugLineNum = 24182786;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
RDebugUtils.currentLine=24182787;
 //BA.debugLineNum = 24182787;BA.debugLine="Dim state2 As Int=0";
_state2 = (int) (0);
RDebugUtils.currentLine=24182788;
 //BA.debugLineNum = 24182788;BA.debugLine="Dim state3 As Int=0";
_state3 = (int) (0);
RDebugUtils.currentLine=24182789;
 //BA.debugLineNum = 24182789;BA.debugLine="Dim state4 As Int=0";
_state4 = (int) (0);
RDebugUtils.currentLine=24182790;
 //BA.debugLineNum = 24182790;BA.debugLine="Dim state5 As Int=0";
_state5 = (int) (0);
RDebugUtils.currentLine=24182791;
 //BA.debugLineNum = 24182791;BA.debugLine="Dim state6 As Int=0";
_state6 = (int) (0);
RDebugUtils.currentLine=24182793;
 //BA.debugLineNum = 24182793;BA.debugLine="If (year=1399)Then";
if ((_year==1399)) { 
RDebugUtils.currentLine=24182794;
 //BA.debugLineNum = 24182794;BA.debugLine="If(hogog>3000001 And hogog<7500001)Then	  ''----";
if ((_hogog>3000001 && _hogog<7500001)) { 
RDebugUtils.currentLine=24182795;
 //BA.debugLineNum = 24182795;BA.debugLine="state1=(hogog-3000000)*0.1";
_state1 = (int) ((_hogog-3000000)*0.1);
 };
RDebugUtils.currentLine=24182797;
 //BA.debugLineNum = 24182797;BA.debugLine="If(hogog>7500001 And hogog<10500001)Then	  ''---";
if ((_hogog>7500001 && _hogog<10500001)) { 
RDebugUtils.currentLine=24182798;
 //BA.debugLineNum = 24182798;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=24182799;
 //BA.debugLineNum = 24182799;BA.debugLine="state2=(hogog-7500000)*0.15";
_state2 = (int) ((_hogog-7500000)*0.15);
 };
RDebugUtils.currentLine=24182801;
 //BA.debugLineNum = 24182801;BA.debugLine="If(hogog>10500001 And hogog<15000001)Then	  ''--";
if ((_hogog>10500001 && _hogog<15000001)) { 
RDebugUtils.currentLine=24182802;
 //BA.debugLineNum = 24182802;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=24182803;
 //BA.debugLineNum = 24182803;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=24182804;
 //BA.debugLineNum = 24182804;BA.debugLine="state3=(hogog-10500000)*0.2";
_state3 = (int) ((_hogog-10500000)*0.2);
 };
RDebugUtils.currentLine=24182806;
 //BA.debugLineNum = 24182806;BA.debugLine="If(hogog>15000001)Then	  ''-----stat4";
if ((_hogog>15000001)) { 
RDebugUtils.currentLine=24182807;
 //BA.debugLineNum = 24182807;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=24182808;
 //BA.debugLineNum = 24182808;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=24182809;
 //BA.debugLineNum = 24182809;BA.debugLine="state3=(4500000)*0.2";
_state3 = (int) ((4500000)*0.2);
RDebugUtils.currentLine=24182810;
 //BA.debugLineNum = 24182810;BA.debugLine="state4=(hogog-15000001)*0.25";
_state4 = (int) ((_hogog-15000001)*0.25);
 };
 };
RDebugUtils.currentLine=24182814;
 //BA.debugLineNum = 24182814;BA.debugLine="If (year=1400)Then";
if ((_year==1400)) { 
RDebugUtils.currentLine=24182815;
 //BA.debugLineNum = 24182815;BA.debugLine="If(hogog>4000001 And hogog<8000001)Then	  ''----";
if ((_hogog>4000001 && _hogog<8000001)) { 
RDebugUtils.currentLine=24182816;
 //BA.debugLineNum = 24182816;BA.debugLine="state1=(hogog-4000000)*0.1";
_state1 = (int) ((_hogog-4000000)*0.1);
 };
RDebugUtils.currentLine=24182818;
 //BA.debugLineNum = 24182818;BA.debugLine="If(hogog>8000001 And hogog<12000001)Then	  ''---";
if ((_hogog>8000001 && _hogog<12000001)) { 
RDebugUtils.currentLine=24182819;
 //BA.debugLineNum = 24182819;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=24182820;
 //BA.debugLineNum = 24182820;BA.debugLine="state2=(hogog-8000000)*0.15";
_state2 = (int) ((_hogog-8000000)*0.15);
 };
RDebugUtils.currentLine=24182822;
 //BA.debugLineNum = 24182822;BA.debugLine="If(hogog>12000001 And hogog<18000001)Then	  ''--";
if ((_hogog>12000001 && _hogog<18000001)) { 
RDebugUtils.currentLine=24182823;
 //BA.debugLineNum = 24182823;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=24182824;
 //BA.debugLineNum = 24182824;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=24182825;
 //BA.debugLineNum = 24182825;BA.debugLine="state3=(hogog-12000000)*0.2";
_state3 = (int) ((_hogog-12000000)*0.2);
 };
RDebugUtils.currentLine=24182827;
 //BA.debugLineNum = 24182827;BA.debugLine="If(hogog>18000001 And hogog<24000001)Then	  ''--";
if ((_hogog>18000001 && _hogog<24000001)) { 
RDebugUtils.currentLine=24182828;
 //BA.debugLineNum = 24182828;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=24182829;
 //BA.debugLineNum = 24182829;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=24182830;
 //BA.debugLineNum = 24182830;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=24182831;
 //BA.debugLineNum = 24182831;BA.debugLine="state4=(hogog-18000000)*0.25";
_state4 = (int) ((_hogog-18000000)*0.25);
 };
RDebugUtils.currentLine=24182833;
 //BA.debugLineNum = 24182833;BA.debugLine="If(hogog>24000001 And hogog<32000001)Then	  ''--";
if ((_hogog>24000001 && _hogog<32000001)) { 
RDebugUtils.currentLine=24182834;
 //BA.debugLineNum = 24182834;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=24182835;
 //BA.debugLineNum = 24182835;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=24182836;
 //BA.debugLineNum = 24182836;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=24182837;
 //BA.debugLineNum = 24182837;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=24182838;
 //BA.debugLineNum = 24182838;BA.debugLine="state5=(hogog-24000000)*0.3";
_state5 = (int) ((_hogog-24000000)*0.3);
 };
RDebugUtils.currentLine=24182840;
 //BA.debugLineNum = 24182840;BA.debugLine="If(hogog>32000001)Then	  ''-----stat4";
if ((_hogog>32000001)) { 
RDebugUtils.currentLine=24182841;
 //BA.debugLineNum = 24182841;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=24182842;
 //BA.debugLineNum = 24182842;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=24182843;
 //BA.debugLineNum = 24182843;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=24182844;
 //BA.debugLineNum = 24182844;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=24182845;
 //BA.debugLineNum = 24182845;BA.debugLine="state5=(6000000)*0.3";
_state5 = (int) ((6000000)*0.3);
RDebugUtils.currentLine=24182846;
 //BA.debugLineNum = 24182846;BA.debugLine="state6=(hogog-32000000)*0.35";
_state6 = (int) ((_hogog-32000000)*0.35);
 };
 };
RDebugUtils.currentLine=24182850;
 //BA.debugLineNum = 24182850;BA.debugLine="If (year=1401)Then";
if ((_year==1401)) { 
RDebugUtils.currentLine=24182851;
 //BA.debugLineNum = 24182851;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
if ((_hogog>5600001 && _hogog<12500001)) { 
RDebugUtils.currentLine=24182852;
 //BA.debugLineNum = 24182852;BA.debugLine="state1=(hogog-5600000)*0.1";
_state1 = (int) ((_hogog-5600000)*0.1);
 };
RDebugUtils.currentLine=24182854;
 //BA.debugLineNum = 24182854;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
if ((_hogog>12500001 && _hogog<20830001)) { 
RDebugUtils.currentLine=24182855;
 //BA.debugLineNum = 24182855;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=24182856;
 //BA.debugLineNum = 24182856;BA.debugLine="state2=(hogog-12500000)*0.15";
_state2 = (int) ((_hogog-12500000)*0.15);
 };
RDebugUtils.currentLine=24182858;
 //BA.debugLineNum = 24182858;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
if ((_hogog>20830001 && _hogog<29160001)) { 
RDebugUtils.currentLine=24182859;
 //BA.debugLineNum = 24182859;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=24182860;
 //BA.debugLineNum = 24182860;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=24182861;
 //BA.debugLineNum = 24182861;BA.debugLine="state3=(hogog-20830000)*0.2";
_state3 = (int) ((_hogog-20830000)*0.2);
 };
RDebugUtils.currentLine=24182864;
 //BA.debugLineNum = 24182864;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
if ((_hogog>29160001)) { 
RDebugUtils.currentLine=24182865;
 //BA.debugLineNum = 24182865;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=24182866;
 //BA.debugLineNum = 24182866;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=24182867;
 //BA.debugLineNum = 24182867;BA.debugLine="state3=(8330000)*0.2";
_state3 = (int) ((8330000)*0.2);
RDebugUtils.currentLine=24182869;
 //BA.debugLineNum = 24182869;BA.debugLine="state4=(hogog-29160000)*0.3";
_state4 = (int) ((_hogog-29160000)*0.3);
 };
 };
RDebugUtils.currentLine=24182874;
 //BA.debugLineNum = 24182874;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
_all_maliat = (int) (_state1+_state2+_state3+_state4+_state5+_state6);
RDebugUtils.currentLine=24182875;
 //BA.debugLineNum = 24182875;BA.debugLine="Return all_maliat";
if (true) return _all_maliat;
RDebugUtils.currentLine=24182877;
 //BA.debugLineNum = 24182877;BA.debugLine="End Sub";
return 0;
}
public static String  _change_formater(String _old,String _new,anywheresoftware.b4a.objects.EditTextWrapper _et_name) throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "change_formater", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "change_formater", new Object[] {_old,_new,_et_name}));}
double _d = 0;
String _s = "";
String _n = "";
String _o = "";
RDebugUtils.currentLine=24051712;
 //BA.debugLineNum = 24051712;BA.debugLine="Sub change_formater (Old As String, New As String,";
RDebugUtils.currentLine=24051713;
 //BA.debugLineNum = 24051713;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
_d = 0;
RDebugUtils.currentLine=24051714;
 //BA.debugLineNum = 24051714;BA.debugLine="Dim S,N,O As String";
_s = "";
_n = "";
_o = "";
RDebugUtils.currentLine=24051715;
 //BA.debugLineNum = 24051715;BA.debugLine="n=New.Replace(\",\",\"\")";
_n = _new.replace(",","");
RDebugUtils.currentLine=24051716;
 //BA.debugLineNum = 24051716;BA.debugLine="O=Old.Replace(\",\",\"\")";
_o = _old.replace(",","");
RDebugUtils.currentLine=24051717;
 //BA.debugLineNum = 24051717;BA.debugLine="If O<>N Then";
if ((_o).equals(_n) == false) { 
RDebugUtils.currentLine=24051718;
 //BA.debugLineNum = 24051718;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
_et_name.setText(BA.ObjectToCharSequence(_et_name.getText().replace(",","")));
RDebugUtils.currentLine=24051719;
 //BA.debugLineNum = 24051719;BA.debugLine="S=et_name.Text";
_s = _et_name.getText();
RDebugUtils.currentLine=24051720;
 //BA.debugLineNum = 24051720;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_s)==anywheresoftware.b4a.keywords.Common.True && (_s).equals("0") == false) { 
RDebugUtils.currentLine=24051721;
 //BA.debugLineNum = 24051721;BA.debugLine="D=s";
_d = (double)(Double.parseDouble(_s));
RDebugUtils.currentLine=24051722;
 //BA.debugLineNum = 24051722;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
_et_name.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_d,(int) (0),(int) (0))));
 };
 };
RDebugUtils.currentLine=24051725;
 //BA.debugLineNum = 24051725;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
_et_name.setSelectionStart(_et_name.getText().length());
RDebugUtils.currentLine=24051726;
 //BA.debugLineNum = 24051726;BA.debugLine="End Sub";
return "";
}
public static String  _et_payeh_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_payeh_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_payeh_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=24117248;
 //BA.debugLineNum = 24117248;BA.debugLine="Private Sub et_payeh_TextChanged (Old As String, N";
RDebugUtils.currentLine=24117249;
 //BA.debugLineNum = 24117249;BA.debugLine="et_payeh.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_payeh.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=24117250;
 //BA.debugLineNum = 24117250;BA.debugLine="change_formater(Old,New,et_payeh)";
_change_formater(_old,_new,mostCurrent._et_payeh);
RDebugUtils.currentLine=24117251;
 //BA.debugLineNum = 24117251;BA.debugLine="End Sub";
return "";
}
}