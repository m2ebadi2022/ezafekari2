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
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=15990784;
 //BA.debugLineNum = 15990784;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=15990786;
 //BA.debugLineNum = 15990786;BA.debugLine="Activity.LoadLayout(\"eidi_layout\")";
mostCurrent._activity.LoadLayout("eidi_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=15990789;
 //BA.debugLineNum = 15990789;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=15990790;
 //BA.debugLineNum = 15990790;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=15990792;
 //BA.debugLineNum = 15990792;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=15990793;
 //BA.debugLineNum = 15990793;BA.debugLine="et_payeh.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_payeh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=15990794;
 //BA.debugLineNum = 15990794;BA.debugLine="et_payeh.Text=show_num_pool(dbCode.res.GetString(";
mostCurrent._et_payeh.setText(BA.ObjectToCharSequence(_show_num_pool((int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=15990796;
 //BA.debugLineNum = 15990796;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=15990797;
 //BA.debugLineNum = 15990797;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=15990800;
 //BA.debugLineNum = 15990800;BA.debugLine="et_date1.Text=myfunc.fa2en(Main.persianDate.Persi";
mostCurrent._et_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())+"/01/01")));
RDebugUtils.currentLine=15990801;
 //BA.debugLineNum = 15990801;BA.debugLine="et_date2.Text=myfunc.fa2en(Main.persianDate.Persi";
mostCurrent._et_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate())));
RDebugUtils.currentLine=15990804;
 //BA.debugLineNum = 15990804;BA.debugLine="et_payeh.Color=Colors.White";
mostCurrent._et_payeh.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=15990805;
 //BA.debugLineNum = 15990805;BA.debugLine="et_date1.Color=Colors.White";
mostCurrent._et_date1.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=15990806;
 //BA.debugLineNum = 15990806;BA.debugLine="et_date2.Color=Colors.White";
mostCurrent._et_date2.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=15990810;
 //BA.debugLineNum = 15990810;BA.debugLine="pan_hed_eydi.Color=Main.color4";
mostCurrent._pan_hed_eydi.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=15990811;
 //BA.debugLineNum = 15990811;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=15990812;
 //BA.debugLineNum = 15990812;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(int _num) throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_num_pool", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_num_pool", new Object[] {_num}));}
RDebugUtils.currentLine=16449536;
 //BA.debugLineNum = 16449536;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=16449537;
 //BA.debugLineNum = 16449537;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
RDebugUtils.currentLine=16449538;
 //BA.debugLineNum = 16449538;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=16252928;
 //BA.debugLineNum = 16252928;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=16252929;
 //BA.debugLineNum = 16252929;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=16252930;
 //BA.debugLineNum = 16252930;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=16252931;
 //BA.debugLineNum = 16252931;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=16252933;
 //BA.debugLineNum = 16252933;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=16252935;
 //BA.debugLineNum = 16252935;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=16187392;
 //BA.debugLineNum = 16187392;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=16187394;
 //BA.debugLineNum = 16187394;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=16187395;
 //BA.debugLineNum = 16187395;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="eidi_activity";
RDebugUtils.currentLine=16121856;
 //BA.debugLineNum = 16121856;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=16121858;
 //BA.debugLineNum = 16121858;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=16056320;
 //BA.debugLineNum = 16056320;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=16056322;
 //BA.debugLineNum = 16056322;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=16318464;
 //BA.debugLineNum = 16318464;BA.debugLine="Private Sub btn_mohasebe_eidi_Click";
RDebugUtils.currentLine=16318465;
 //BA.debugLineNum = 16318465;BA.debugLine="Dim eidi_roz As Int";
_eidi_roz = 0;
RDebugUtils.currentLine=16318466;
 //BA.debugLineNum = 16318466;BA.debugLine="Dim rozha As Int";
_rozha = 0;
RDebugUtils.currentLine=16318467;
 //BA.debugLineNum = 16318467;BA.debugLine="Dim eidi_nakhales As Int";
_eidi_nakhales = 0;
RDebugUtils.currentLine=16318468;
 //BA.debugLineNum = 16318468;BA.debugLine="Dim eidi_khales As Int";
_eidi_khales = 0;
RDebugUtils.currentLine=16318469;
 //BA.debugLineNum = 16318469;BA.debugLine="Dim eidi_maliat As Int";
_eidi_maliat = 0;
RDebugUtils.currentLine=16318471;
 //BA.debugLineNum = 16318471;BA.debugLine="If(et_payeh.Text=\"\")Then";
if (((mostCurrent._et_payeh.getText()).equals(""))) { 
RDebugUtils.currentLine=16318472;
 //BA.debugLineNum = 16318472;BA.debugLine="et_payeh.Text=0";
mostCurrent._et_payeh.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=16318473;
 //BA.debugLineNum = 16318473;BA.debugLine="et_payeh.Tag=0";
mostCurrent._et_payeh.setTag((Object)(0));
 };
RDebugUtils.currentLine=16318477;
 //BA.debugLineNum = 16318477;BA.debugLine="eidi_roz=(et_payeh.Tag*2)/365";
_eidi_roz = (int) (((double)(BA.ObjectToNumber(mostCurrent._et_payeh.getTag()))*2)/(double)365);
RDebugUtils.currentLine=16318478;
 //BA.debugLineNum = 16318478;BA.debugLine="rozha=time_mohasebe(et_date1.Text,et_date2.Text)";
_rozha = _time_mohasebe(mostCurrent._et_date1.getText(),mostCurrent._et_date2.getText());
RDebugUtils.currentLine=16318480;
 //BA.debugLineNum = 16318480;BA.debugLine="eidi_nakhales=eidi_roz*rozha";
_eidi_nakhales = (int) (_eidi_roz*_rozha);
RDebugUtils.currentLine=16318481;
 //BA.debugLineNum = 16318481;BA.debugLine="If(rozha=365)Then";
if ((_rozha==365)) { 
RDebugUtils.currentLine=16318482;
 //BA.debugLineNum = 16318482;BA.debugLine="eidi_nakhales=et_payeh.Tag*2";
_eidi_nakhales = (int) ((double)(BA.ObjectToNumber(mostCurrent._et_payeh.getTag()))*2);
 };
RDebugUtils.currentLine=16318484;
 //BA.debugLineNum = 16318484;BA.debugLine="eidi_maliat=mohasebe_maliat(eidi_nakhales , myfun";
_eidi_maliat = _mohasebe_maliat(_eidi_nakhales,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())))));
RDebugUtils.currentLine=16318485;
 //BA.debugLineNum = 16318485;BA.debugLine="eidi_khales=eidi_nakhales-eidi_maliat";
_eidi_khales = (int) (_eidi_nakhales-_eidi_maliat);
RDebugUtils.currentLine=16318487;
 //BA.debugLineNum = 16318487;BA.debugLine="lbl_eidi.Text=\"تعداد روزها : \"&rozha&CRLF&\"ناخالص";
mostCurrent._lbl_eidi.setText(BA.ObjectToCharSequence("تعداد روزها : "+BA.NumberToString(_rozha)+anywheresoftware.b4a.keywords.Common.CRLF+"ناخالص :"+_show_num_pool(_eidi_nakhales)+anywheresoftware.b4a.keywords.Common.CRLF+" مالیات : "+_show_num_pool(_eidi_maliat)+anywheresoftware.b4a.keywords.Common.CRLF+"خالص عیدی دریافتی :"+_show_num_pool(_eidi_khales)));
RDebugUtils.currentLine=16318489;
 //BA.debugLineNum = 16318489;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=16384000;
 //BA.debugLineNum = 16384000;BA.debugLine="Sub time_mohasebe(date1 As String, date2 As String";
RDebugUtils.currentLine=16384002;
 //BA.debugLineNum = 16384002;BA.debugLine="Try";
try {RDebugUtils.currentLine=16384004;
 //BA.debugLineNum = 16384004;BA.debugLine="Dim strfun As StringFunctions";
_strfun = new adr.stringfunctions.stringfunctions();
RDebugUtils.currentLine=16384005;
 //BA.debugLineNum = 16384005;BA.debugLine="strfun.Initialize";
_strfun._initialize(processBA);
RDebugUtils.currentLine=16384006;
 //BA.debugLineNum = 16384006;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=16384007;
 //BA.debugLineNum = 16384007;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=16384008;
 //BA.debugLineNum = 16384008;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
RDebugUtils.currentLine=16384009;
 //BA.debugLineNum = 16384009;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
RDebugUtils.currentLine=16384011;
 //BA.debugLineNum = 16384011;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=16384012;
 //BA.debugLineNum = 16384012;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=16384013;
 //BA.debugLineNum = 16384013;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=16384014;
 //BA.debugLineNum = 16384014;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=16384018;
 //BA.debugLineNum = 16384018;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = _strfun._vvvvvv5(_date1,"/");
RDebugUtils.currentLine=16384019;
 //BA.debugLineNum = 16384019;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = _strfun._vvvvvv5(_date2,"/");
RDebugUtils.currentLine=16384023;
 //BA.debugLineNum = 16384023;BA.debugLine="dat_mil_2=Main.persianDate.PersianToGregorian(li";
_dat_mil_2 = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=16384024;
 //BA.debugLineNum = 16384024;BA.debugLine="dat_mil_1=Main.persianDate.PersianToGregorian(li";
_dat_mil_1 = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=16384027;
 //BA.debugLineNum = 16384027;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = _strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=16384028;
 //BA.debugLineNum = 16384028;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = _strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=16384031;
 //BA.debugLineNum = 16384031;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
RDebugUtils.currentLine=16384034;
 //BA.debugLineNum = 16384034;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=16384035;
 //BA.debugLineNum = 16384035;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=16384040;
 //BA.debugLineNum = 16384040;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
RDebugUtils.currentLine=16384041;
 //BA.debugLineNum = 16384041;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
RDebugUtils.currentLine=16384042;
 //BA.debugLineNum = 16384042;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),"00:00:00");
RDebugUtils.currentLine=16384043;
 //BA.debugLineNum = 16384043;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),"00:00:00");
RDebugUtils.currentLine=16384044;
 //BA.debugLineNum = 16384044;BA.debugLine="Dim rozha As Int";
_rozha = 0;
RDebugUtils.currentLine=16384045;
 //BA.debugLineNum = 16384045;BA.debugLine="rozha=Main.persianDate.CalculateDaysBetween(myfu";
_rozha = (int) (mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .CalculateDaysBetween(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2)));
RDebugUtils.currentLine=16384047;
 //BA.debugLineNum = 16384047;BA.debugLine="Return rozha+1";
if (true) return (int) (_rozha+1);
 } 
       catch (Exception e29) {
			processBA.setLastException(e29);RDebugUtils.currentLine=16384050;
 //BA.debugLineNum = 16384050;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=16384052;
 //BA.debugLineNum = 16384052;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=16646144;
 //BA.debugLineNum = 16646144;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
RDebugUtils.currentLine=16646145;
 //BA.debugLineNum = 16646145;BA.debugLine="Dim all_maliat As Int=0";
_all_maliat = (int) (0);
RDebugUtils.currentLine=16646146;
 //BA.debugLineNum = 16646146;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
RDebugUtils.currentLine=16646147;
 //BA.debugLineNum = 16646147;BA.debugLine="Dim state2 As Int=0";
_state2 = (int) (0);
RDebugUtils.currentLine=16646148;
 //BA.debugLineNum = 16646148;BA.debugLine="Dim state3 As Int=0";
_state3 = (int) (0);
RDebugUtils.currentLine=16646149;
 //BA.debugLineNum = 16646149;BA.debugLine="Dim state4 As Int=0";
_state4 = (int) (0);
RDebugUtils.currentLine=16646150;
 //BA.debugLineNum = 16646150;BA.debugLine="Dim state5 As Int=0";
_state5 = (int) (0);
RDebugUtils.currentLine=16646151;
 //BA.debugLineNum = 16646151;BA.debugLine="Dim state6 As Int=0";
_state6 = (int) (0);
RDebugUtils.currentLine=16646153;
 //BA.debugLineNum = 16646153;BA.debugLine="If (year=1399)Then";
if ((_year==1399)) { 
RDebugUtils.currentLine=16646154;
 //BA.debugLineNum = 16646154;BA.debugLine="If(hogog>3000001 And hogog<7500001)Then	  ''----";
if ((_hogog>3000001 && _hogog<7500001)) { 
RDebugUtils.currentLine=16646155;
 //BA.debugLineNum = 16646155;BA.debugLine="state1=(hogog-3000000)*0.1";
_state1 = (int) ((_hogog-3000000)*0.1);
 };
RDebugUtils.currentLine=16646157;
 //BA.debugLineNum = 16646157;BA.debugLine="If(hogog>7500001 And hogog<10500001)Then	  ''---";
if ((_hogog>7500001 && _hogog<10500001)) { 
RDebugUtils.currentLine=16646158;
 //BA.debugLineNum = 16646158;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=16646159;
 //BA.debugLineNum = 16646159;BA.debugLine="state2=(hogog-7500000)*0.15";
_state2 = (int) ((_hogog-7500000)*0.15);
 };
RDebugUtils.currentLine=16646161;
 //BA.debugLineNum = 16646161;BA.debugLine="If(hogog>10500001 And hogog<15000001)Then	  ''--";
if ((_hogog>10500001 && _hogog<15000001)) { 
RDebugUtils.currentLine=16646162;
 //BA.debugLineNum = 16646162;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=16646163;
 //BA.debugLineNum = 16646163;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=16646164;
 //BA.debugLineNum = 16646164;BA.debugLine="state3=(hogog-10500000)*0.2";
_state3 = (int) ((_hogog-10500000)*0.2);
 };
RDebugUtils.currentLine=16646166;
 //BA.debugLineNum = 16646166;BA.debugLine="If(hogog>15000001)Then	  ''-----stat4";
if ((_hogog>15000001)) { 
RDebugUtils.currentLine=16646167;
 //BA.debugLineNum = 16646167;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=16646168;
 //BA.debugLineNum = 16646168;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=16646169;
 //BA.debugLineNum = 16646169;BA.debugLine="state3=(4500000)*0.2";
_state3 = (int) ((4500000)*0.2);
RDebugUtils.currentLine=16646170;
 //BA.debugLineNum = 16646170;BA.debugLine="state4=(hogog-15000001)*0.25";
_state4 = (int) ((_hogog-15000001)*0.25);
 };
 };
RDebugUtils.currentLine=16646174;
 //BA.debugLineNum = 16646174;BA.debugLine="If (year=1400)Then";
if ((_year==1400)) { 
RDebugUtils.currentLine=16646175;
 //BA.debugLineNum = 16646175;BA.debugLine="If(hogog>4000001 And hogog<8000001)Then	  ''----";
if ((_hogog>4000001 && _hogog<8000001)) { 
RDebugUtils.currentLine=16646176;
 //BA.debugLineNum = 16646176;BA.debugLine="state1=(hogog-4000000)*0.1";
_state1 = (int) ((_hogog-4000000)*0.1);
 };
RDebugUtils.currentLine=16646178;
 //BA.debugLineNum = 16646178;BA.debugLine="If(hogog>8000001 And hogog<12000001)Then	  ''---";
if ((_hogog>8000001 && _hogog<12000001)) { 
RDebugUtils.currentLine=16646179;
 //BA.debugLineNum = 16646179;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=16646180;
 //BA.debugLineNum = 16646180;BA.debugLine="state2=(hogog-8000000)*0.15";
_state2 = (int) ((_hogog-8000000)*0.15);
 };
RDebugUtils.currentLine=16646182;
 //BA.debugLineNum = 16646182;BA.debugLine="If(hogog>12000001 And hogog<18000001)Then	  ''--";
if ((_hogog>12000001 && _hogog<18000001)) { 
RDebugUtils.currentLine=16646183;
 //BA.debugLineNum = 16646183;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=16646184;
 //BA.debugLineNum = 16646184;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=16646185;
 //BA.debugLineNum = 16646185;BA.debugLine="state3=(hogog-12000000)*0.2";
_state3 = (int) ((_hogog-12000000)*0.2);
 };
RDebugUtils.currentLine=16646187;
 //BA.debugLineNum = 16646187;BA.debugLine="If(hogog>18000001 And hogog<24000001)Then	  ''--";
if ((_hogog>18000001 && _hogog<24000001)) { 
RDebugUtils.currentLine=16646188;
 //BA.debugLineNum = 16646188;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=16646189;
 //BA.debugLineNum = 16646189;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=16646190;
 //BA.debugLineNum = 16646190;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=16646191;
 //BA.debugLineNum = 16646191;BA.debugLine="state4=(hogog-18000000)*0.25";
_state4 = (int) ((_hogog-18000000)*0.25);
 };
RDebugUtils.currentLine=16646193;
 //BA.debugLineNum = 16646193;BA.debugLine="If(hogog>24000001 And hogog<32000001)Then	  ''--";
if ((_hogog>24000001 && _hogog<32000001)) { 
RDebugUtils.currentLine=16646194;
 //BA.debugLineNum = 16646194;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=16646195;
 //BA.debugLineNum = 16646195;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=16646196;
 //BA.debugLineNum = 16646196;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=16646197;
 //BA.debugLineNum = 16646197;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=16646198;
 //BA.debugLineNum = 16646198;BA.debugLine="state5=(hogog-24000000)*0.3";
_state5 = (int) ((_hogog-24000000)*0.3);
 };
RDebugUtils.currentLine=16646200;
 //BA.debugLineNum = 16646200;BA.debugLine="If(hogog>32000001)Then	  ''-----stat4";
if ((_hogog>32000001)) { 
RDebugUtils.currentLine=16646201;
 //BA.debugLineNum = 16646201;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=16646202;
 //BA.debugLineNum = 16646202;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=16646203;
 //BA.debugLineNum = 16646203;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=16646204;
 //BA.debugLineNum = 16646204;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=16646205;
 //BA.debugLineNum = 16646205;BA.debugLine="state5=(6000000)*0.3";
_state5 = (int) ((6000000)*0.3);
RDebugUtils.currentLine=16646206;
 //BA.debugLineNum = 16646206;BA.debugLine="state6=(hogog-32000000)*0.35";
_state6 = (int) ((_hogog-32000000)*0.35);
 };
 };
RDebugUtils.currentLine=16646210;
 //BA.debugLineNum = 16646210;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
_all_maliat = (int) (_state1+_state2+_state3+_state4+_state5+_state6);
RDebugUtils.currentLine=16646211;
 //BA.debugLineNum = 16646211;BA.debugLine="Return all_maliat";
if (true) return _all_maliat;
RDebugUtils.currentLine=16646213;
 //BA.debugLineNum = 16646213;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=16515072;
 //BA.debugLineNum = 16515072;BA.debugLine="Sub change_formater (Old As String, New As String,";
RDebugUtils.currentLine=16515073;
 //BA.debugLineNum = 16515073;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
_d = 0;
RDebugUtils.currentLine=16515074;
 //BA.debugLineNum = 16515074;BA.debugLine="Dim S,N,O As String";
_s = "";
_n = "";
_o = "";
RDebugUtils.currentLine=16515075;
 //BA.debugLineNum = 16515075;BA.debugLine="n=New.Replace(\",\",\"\")";
_n = _new.replace(",","");
RDebugUtils.currentLine=16515076;
 //BA.debugLineNum = 16515076;BA.debugLine="O=Old.Replace(\",\",\"\")";
_o = _old.replace(",","");
RDebugUtils.currentLine=16515077;
 //BA.debugLineNum = 16515077;BA.debugLine="If O<>N Then";
if ((_o).equals(_n) == false) { 
RDebugUtils.currentLine=16515078;
 //BA.debugLineNum = 16515078;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
_et_name.setText(BA.ObjectToCharSequence(_et_name.getText().replace(",","")));
RDebugUtils.currentLine=16515079;
 //BA.debugLineNum = 16515079;BA.debugLine="S=et_name.Text";
_s = _et_name.getText();
RDebugUtils.currentLine=16515080;
 //BA.debugLineNum = 16515080;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_s)==anywheresoftware.b4a.keywords.Common.True && (_s).equals("0") == false) { 
RDebugUtils.currentLine=16515081;
 //BA.debugLineNum = 16515081;BA.debugLine="D=s";
_d = (double)(Double.parseDouble(_s));
RDebugUtils.currentLine=16515082;
 //BA.debugLineNum = 16515082;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
_et_name.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_d,(int) (0),(int) (0))));
 };
 };
RDebugUtils.currentLine=16515085;
 //BA.debugLineNum = 16515085;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
_et_name.setSelectionStart(_et_name.getText().length());
RDebugUtils.currentLine=16515086;
 //BA.debugLineNum = 16515086;BA.debugLine="End Sub";
return "";
}
public static String  _et_payeh_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="eidi_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_payeh_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_payeh_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=16580608;
 //BA.debugLineNum = 16580608;BA.debugLine="Private Sub et_payeh_TextChanged (Old As String, N";
RDebugUtils.currentLine=16580609;
 //BA.debugLineNum = 16580609;BA.debugLine="et_payeh.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_payeh.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=16580610;
 //BA.debugLineNum = 16580610;BA.debugLine="change_formater(Old,New,et_payeh)";
_change_formater(_old,_new,mostCurrent._et_payeh);
RDebugUtils.currentLine=16580611;
 //BA.debugLineNum = 16580611;BA.debugLine="End Sub";
return "";
}
}