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

public class step0_activity extends Activity implements B4AActivity{
	public static step0_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.step0_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (step0_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.step0_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.step0_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (step0_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (step0_activity) Resume **");
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
		return step0_activity.class;
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
            BA.LogInfo("** Activity (step0_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (step0_activity) Pause event (activity is not paused). **");
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
            step0_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (step0_activity) Resume **");
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
public static anywheresoftware.b4a.objects.Timer _time_remind = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_phonnum = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_code_num = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_send = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_run2_step0 = null;
public ir.taravatgroup.ezafekari2.httpjob _http1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_time_remind = null;
public static int _min1 = 0;
public static int _sec1 = 0;
public anywheresoftware.b4a.phone.Phone _pp1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_run1_step0 = null;
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
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
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
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="step0_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=55902208;
 //BA.debugLineNum = 55902208;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=55902210;
 //BA.debugLineNum = 55902210;BA.debugLine="Activity.LoadLayout(\"step0\")";
mostCurrent._activity.LoadLayout("step0",mostCurrent.activityBA);
RDebugUtils.currentLine=55902211;
 //BA.debugLineNum = 55902211;BA.debugLine="time_remind.Initialize(\"time_remind\",1000)";
_time_remind.Initialize(processBA,"time_remind",(long) (1000));
RDebugUtils.currentLine=55902213;
 //BA.debugLineNum = 55902213;BA.debugLine="et_phonNum.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._et_phonnum.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=55902214;
 //BA.debugLineNum = 55902214;BA.debugLine="et_code_num.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._et_code_num.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=55902216;
 //BA.debugLineNum = 55902216;BA.debugLine="If (File.Exists(File.DirInternal,\"phonNum\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum"))) { 
RDebugUtils.currentLine=55902217;
 //BA.debugLineNum = 55902217;BA.debugLine="Main.phon_num=File.ReadString(File.DirInternal,\"";
mostCurrent._main._phon_num /*String*/  = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum");
 };
RDebugUtils.currentLine=55902222;
 //BA.debugLineNum = 55902222;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="step0_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=56688640;
 //BA.debugLineNum = 56688640;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=56688641;
 //BA.debugLineNum = 56688641;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=56688642;
 //BA.debugLineNum = 56688642;BA.debugLine="If(pan_all_send.Visible=True)Then";
if ((mostCurrent._pan_all_send.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=56688643;
 //BA.debugLineNum = 56688643;BA.debugLine="lbl_back_run1_Click";
_lbl_back_run1_click();
 }else {
RDebugUtils.currentLine=56688645;
 //BA.debugLineNum = 56688645;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
RDebugUtils.currentLine=56688648;
 //BA.debugLineNum = 56688648;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=56688650;
 //BA.debugLineNum = 56688650;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=56688652;
 //BA.debugLineNum = 56688652;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_run1_click() throws Exception{
RDebugUtils.currentModule="step0_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_run1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_run1_click", null));}
RDebugUtils.currentLine=56360960;
 //BA.debugLineNum = 56360960;BA.debugLine="Private Sub lbl_back_run1_Click";
RDebugUtils.currentLine=56360962;
 //BA.debugLineNum = 56360962;BA.debugLine="pan_all_send.Visible=False";
mostCurrent._pan_all_send.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=56360963;
 //BA.debugLineNum = 56360963;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="step0_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=56754176;
 //BA.debugLineNum = 56754176;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=56754178;
 //BA.debugLineNum = 56754178;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=56754179;
 //BA.debugLineNum = 56754179;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="step0_activity";
RDebugUtils.currentLine=56033280;
 //BA.debugLineNum = 56033280;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=56033282;
 //BA.debugLineNum = 56033282;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="step0_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=55967744;
 //BA.debugLineNum = 55967744;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=55967746;
 //BA.debugLineNum = 55967746;BA.debugLine="End Sub";
return "";
}
public static String  _et_code_num_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="step0_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_code_num_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_code_num_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=56426496;
 //BA.debugLineNum = 56426496;BA.debugLine="Private Sub et_code_num_TextChanged (Old As String";
RDebugUtils.currentLine=56426497;
 //BA.debugLineNum = 56426497;BA.debugLine="If(et_code_num.Text=\"\")Then";
if (((mostCurrent._et_code_num.getText()).equals(""))) { 
RDebugUtils.currentLine=56426498;
 //BA.debugLineNum = 56426498;BA.debugLine="lbl_run2_step0.Enabled=False";
mostCurrent._lbl_run2_step0.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=56426500;
 //BA.debugLineNum = 56426500;BA.debugLine="lbl_run2_step0.Enabled=True";
mostCurrent._lbl_run2_step0.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=56426503;
 //BA.debugLineNum = 56426503;BA.debugLine="End Sub";
return "";
}
public static String  _et_phonnum_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="step0_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_phonnum_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_phonnum_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=56623104;
 //BA.debugLineNum = 56623104;BA.debugLine="Private Sub et_phonNum_TextChanged (Old As String,";
RDebugUtils.currentLine=56623105;
 //BA.debugLineNum = 56623105;BA.debugLine="If(et_phonNum.Text=\"\")Then";
if (((mostCurrent._et_phonnum.getText()).equals(""))) { 
RDebugUtils.currentLine=56623106;
 //BA.debugLineNum = 56623106;BA.debugLine="lbl_run1_step0.Enabled=False";
mostCurrent._lbl_run1_step0.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=56623108;
 //BA.debugLineNum = 56623108;BA.debugLine="lbl_run1_step0.Enabled=True";
mostCurrent._lbl_run1_step0.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=56623110;
 //BA.debugLineNum = 56623110;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
RDebugUtils.currentModule="step0_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "http_initial_1", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "http_initial_1", new Object[] {_type1}));}
String _send = "";
RDebugUtils.currentLine=56492032;
 //BA.debugLineNum = 56492032;BA.debugLine="Sub http_initial_1(type1 As Int)";
RDebugUtils.currentLine=56492034;
 //BA.debugLineNum = 56492034;BA.debugLine="If(type1=1)Then";
if ((_type1==1)) { 
RDebugUtils.currentLine=56492035;
 //BA.debugLineNum = 56492035;BA.debugLine="http1.Initialize(\"ht1\",Me)";
mostCurrent._http1._initialize /*String*/ (null,processBA,"ht1",step0_activity.getObject());
RDebugUtils.currentLine=56492036;
 //BA.debugLineNum = 56492036;BA.debugLine="Dim send As String";
_send = "";
RDebugUtils.currentLine=56492037;
 //BA.debugLineNum = 56492037;BA.debugLine="send = \"id=1&num=\"&Main.phon_num&\"&code=0\"";
_send = "id=1&num="+mostCurrent._main._phon_num /*String*/ +"&code=0";
RDebugUtils.currentLine=56492038;
 //BA.debugLineNum = 56492038;BA.debugLine="http1.PostString(\"https://taravatgroup.ir/sms_re";
mostCurrent._http1._poststring /*String*/ (null,"https://taravatgroup.ir/sms_req.php",_send);
RDebugUtils.currentLine=56492040;
 //BA.debugLineNum = 56492040;BA.debugLine="File.WriteString(File.DirInternal,\"phonNum\",Main";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum",mostCurrent._main._phon_num /*String*/ );
RDebugUtils.currentLine=56492042;
 //BA.debugLineNum = 56492042;BA.debugLine="lbl_run2_step0.Enabled=False";
mostCurrent._lbl_run2_step0.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=56492043;
 //BA.debugLineNum = 56492043;BA.debugLine="pan_all_send.Visible=True";
mostCurrent._pan_all_send.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=56492044;
 //BA.debugLineNum = 56492044;BA.debugLine="time_remind.Enabled=True";
_time_remind.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=56492046;
 //BA.debugLineNum = 56492046;BA.debugLine="Else if (type1=2)Then";
if ((_type1==2)) { 
RDebugUtils.currentLine=56492048;
 //BA.debugLineNum = 56492048;BA.debugLine="http1.Initialize(\"ht2\",Me)";
mostCurrent._http1._initialize /*String*/ (null,processBA,"ht2",step0_activity.getObject());
RDebugUtils.currentLine=56492049;
 //BA.debugLineNum = 56492049;BA.debugLine="Dim send As String";
_send = "";
RDebugUtils.currentLine=56492050;
 //BA.debugLineNum = 56492050;BA.debugLine="send = \"id=2&num=\"&Main.phon_num&\"&code=\"&et_cod";
_send = "id=2&num="+mostCurrent._main._phon_num /*String*/ +"&code="+mostCurrent._et_code_num.getText()+"&div_id="+mostCurrent._pp1.GetSettings("android_id")+"&div_model="+mostCurrent._pp1.getModel();
RDebugUtils.currentLine=56492051;
 //BA.debugLineNum = 56492051;BA.debugLine="http1.PostString(\"https://taravatgroup.ir/sms_re";
mostCurrent._http1._poststring /*String*/ (null,"https://taravatgroup.ir/sms_req.php",_send);
 }}
;
RDebugUtils.currentLine=56492056;
 //BA.debugLineNum = 56492056;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(ir.taravatgroup.ezafekari2.httpjob _job) throws Exception{
RDebugUtils.currentModule="step0_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=56557568;
 //BA.debugLineNum = 56557568;BA.debugLine="Sub Jobdone (job As HttpJob)";
RDebugUtils.currentLine=56557569;
 //BA.debugLineNum = 56557569;BA.debugLine="Try";
try {RDebugUtils.currentLine=56557570;
 //BA.debugLineNum = 56557570;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=56557571;
 //BA.debugLineNum = 56557571;BA.debugLine="Log(job.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("256557571",_job._getstring /*String*/ (null),0);
RDebugUtils.currentLine=56557572;
 //BA.debugLineNum = 56557572;BA.debugLine="If job.JobName=\"ht1\" Then";
if ((_job._jobname /*String*/ ).equals("ht1")) { 
 }else 
{RDebugUtils.currentLine=56557575;
 //BA.debugLineNum = 56557575;BA.debugLine="else if job.JobName=\"ht2\" Then";
if ((_job._jobname /*String*/ ).equals("ht2")) { 
RDebugUtils.currentLine=56557576;
 //BA.debugLineNum = 56557576;BA.debugLine="If(job.GetString.Contains(\"okuser\")=True) Then";
if ((_job._getstring /*String*/ (null).contains("okuser")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=56557577;
 //BA.debugLineNum = 56557577;BA.debugLine="File.WriteString(File.DirInternal,\"phonNum\",M";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum",mostCurrent._main._phon_num /*String*/ );
RDebugUtils.currentLine=56557578;
 //BA.debugLineNum = 56557578;BA.debugLine="StartActivity(step2_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step2_activity.getObject()));
RDebugUtils.currentLine=56557579;
 //BA.debugLineNum = 56557579;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 }else 
{RDebugUtils.currentLine=56557582;
 //BA.debugLineNum = 56557582;BA.debugLine="Else if (job.GetString.Contains(\"nouser\")=True";
if ((_job._getstring /*String*/ (null).contains("nouser")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=56557584;
 //BA.debugLineNum = 56557584;BA.debugLine="File.WriteString(File.DirInternal,\"phonNum\",M";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum",mostCurrent._main._phon_num /*String*/ );
RDebugUtils.currentLine=56557586;
 //BA.debugLineNum = 56557586;BA.debugLine="StartActivity(step1_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step1_activity.getObject()));
RDebugUtils.currentLine=56557587;
 //BA.debugLineNum = 56557587;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 }else {
RDebugUtils.currentLine=56557589;
 //BA.debugLineNum = 56557589;BA.debugLine="ToastMessageShow(\"کد تائید اشتباه است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("کد تائید اشتباه است"),anywheresoftware.b4a.keywords.Common.False);
 }}
;
 }}
;
RDebugUtils.currentLine=56557594;
 //BA.debugLineNum = 56557594;BA.debugLine="job.Release";
_job._release /*String*/ (null);
 }else {
 };
 } 
       catch (Exception e22) {
			processBA.setLastException(e22);RDebugUtils.currentLine=56557599;
 //BA.debugLineNum = 56557599;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("256557599",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=56557600;
 //BA.debugLineNum = 56557600;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=56557603;
 //BA.debugLineNum = 56557603;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_code_recived_click() throws Exception{
RDebugUtils.currentModule="step0_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_code_recived_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_code_recived_click", null));}
RDebugUtils.currentLine=56819712;
 //BA.debugLineNum = 56819712;BA.debugLine="Private Sub lbl_code_recived_Click";
RDebugUtils.currentLine=56819713;
 //BA.debugLineNum = 56819713;BA.debugLine="lbl_time_remind.Text=\"00:00\"";
mostCurrent._lbl_time_remind.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=56819714;
 //BA.debugLineNum = 56819714;BA.debugLine="pan_all_send.Visible=True";
mostCurrent._pan_all_send.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=56819715;
 //BA.debugLineNum = 56819715;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run1_step0_click() throws Exception{
RDebugUtils.currentModule="step0_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_run1_step0_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_run1_step0_click", null));}
RDebugUtils.currentLine=56164352;
 //BA.debugLineNum = 56164352;BA.debugLine="Private Sub lbl_run1_step0_Click";
RDebugUtils.currentLine=56164356;
 //BA.debugLineNum = 56164356;BA.debugLine="If(et_phonNum.Text=\"\")Then";
if (((mostCurrent._et_phonnum.getText()).equals(""))) { 
RDebugUtils.currentLine=56164357;
 //BA.debugLineNum = 56164357;BA.debugLine="ToastMessageShow(\"شماره موبایل معتبر وارد کنید\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("شماره موبایل معتبر وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=56164360;
 //BA.debugLineNum = 56164360;BA.debugLine="If(et_phonNum.Text.Length=11)Then";
if ((mostCurrent._et_phonnum.getText().length()==11)) { 
RDebugUtils.currentLine=56164362;
 //BA.debugLineNum = 56164362;BA.debugLine="If(et_phonNum.Text.StartsWith(\"09\"))Then";
if ((mostCurrent._et_phonnum.getText().startsWith("09"))) { 
RDebugUtils.currentLine=56164363;
 //BA.debugLineNum = 56164363;BA.debugLine="Main.phon_num=et_phonNum.Text";
mostCurrent._main._phon_num /*String*/  = mostCurrent._et_phonnum.getText();
RDebugUtils.currentLine=56164364;
 //BA.debugLineNum = 56164364;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
 }else {
RDebugUtils.currentLine=56164366;
 //BA.debugLineNum = 56164366;BA.debugLine="ToastMessageShow(\"شماره موبایل معتبر وارد کنید";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("شماره موبایل معتبر وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 };
 }else {
RDebugUtils.currentLine=56164370;
 //BA.debugLineNum = 56164370;BA.debugLine="ToastMessageShow(\"شماره موبایل معتبر وارد کنید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("شماره موبایل معتبر وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 };
 };
RDebugUtils.currentLine=56164377;
 //BA.debugLineNum = 56164377;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run2_step0_click() throws Exception{
RDebugUtils.currentModule="step0_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_run2_step0_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_run2_step0_click", null));}
RDebugUtils.currentLine=56229888;
 //BA.debugLineNum = 56229888;BA.debugLine="Private Sub lbl_run2_step0_Click";
RDebugUtils.currentLine=56229890;
 //BA.debugLineNum = 56229890;BA.debugLine="If(et_code_num.Text=\"\")Then";
if (((mostCurrent._et_code_num.getText()).equals(""))) { 
RDebugUtils.currentLine=56229891;
 //BA.debugLineNum = 56229891;BA.debugLine="ToastMessageShow(\"کد تائید را وارد کنید\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("کد تائید را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=56229893;
 //BA.debugLineNum = 56229893;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
 };
RDebugUtils.currentLine=56229898;
 //BA.debugLineNum = 56229898;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_send_click() throws Exception{
RDebugUtils.currentModule="step0_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_send_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_send_click", null));}
RDebugUtils.currentLine=56295424;
 //BA.debugLineNum = 56295424;BA.debugLine="Private Sub pan_all_send_Click";
RDebugUtils.currentLine=56295426;
 //BA.debugLineNum = 56295426;BA.debugLine="End Sub";
return "";
}
public static String  _time_remind_tick() throws Exception{
RDebugUtils.currentModule="step0_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time_remind_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "time_remind_tick", null));}
String _sec2 = "";
String _min2 = "";
RDebugUtils.currentLine=56098816;
 //BA.debugLineNum = 56098816;BA.debugLine="Sub time_remind_Tick";
RDebugUtils.currentLine=56098818;
 //BA.debugLineNum = 56098818;BA.debugLine="If(min1<1 And sec1<1)Then";
if ((_min1<1 && _sec1<1)) { 
RDebugUtils.currentLine=56098819;
 //BA.debugLineNum = 56098819;BA.debugLine="time_remind.Enabled=False";
_time_remind.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=56098820;
 //BA.debugLineNum = 56098820;BA.debugLine="lbl_time_remind.Text=\"0:0\"";
mostCurrent._lbl_time_remind.setText(BA.ObjectToCharSequence("0:0"));
RDebugUtils.currentLine=56098821;
 //BA.debugLineNum = 56098821;BA.debugLine="lbl_run2_step0.Enabled=True";
mostCurrent._lbl_run2_step0.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=56098822;
 //BA.debugLineNum = 56098822;BA.debugLine="pan_all_send.Visible=False";
mostCurrent._pan_all_send.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=56098825;
 //BA.debugLineNum = 56098825;BA.debugLine="Dim sec2 As String=sec1";
_sec2 = BA.NumberToString(_sec1);
RDebugUtils.currentLine=56098826;
 //BA.debugLineNum = 56098826;BA.debugLine="Dim min2 As String=min1";
_min2 = BA.NumberToString(_min1);
RDebugUtils.currentLine=56098827;
 //BA.debugLineNum = 56098827;BA.debugLine="Select sec2";
switch (BA.switchObjectToInt(_sec2,BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9))) {
case 0: {
RDebugUtils.currentLine=56098829;
 //BA.debugLineNum = 56098829;BA.debugLine="sec2=\"00\"";
_sec2 = "00";
 break; }
case 1: {
RDebugUtils.currentLine=56098831;
 //BA.debugLineNum = 56098831;BA.debugLine="sec2=\"01\"";
_sec2 = "01";
 break; }
case 2: {
RDebugUtils.currentLine=56098833;
 //BA.debugLineNum = 56098833;BA.debugLine="sec2=\"02\"";
_sec2 = "02";
 break; }
case 3: {
RDebugUtils.currentLine=56098835;
 //BA.debugLineNum = 56098835;BA.debugLine="sec2=\"03\"";
_sec2 = "03";
 break; }
case 4: {
RDebugUtils.currentLine=56098837;
 //BA.debugLineNum = 56098837;BA.debugLine="sec2=\"04\"";
_sec2 = "04";
 break; }
case 5: {
RDebugUtils.currentLine=56098839;
 //BA.debugLineNum = 56098839;BA.debugLine="sec2=\"05\"";
_sec2 = "05";
 break; }
case 6: {
RDebugUtils.currentLine=56098841;
 //BA.debugLineNum = 56098841;BA.debugLine="sec2=\"06\"";
_sec2 = "06";
 break; }
case 7: {
RDebugUtils.currentLine=56098843;
 //BA.debugLineNum = 56098843;BA.debugLine="sec2=\"07\"";
_sec2 = "07";
 break; }
case 8: {
RDebugUtils.currentLine=56098845;
 //BA.debugLineNum = 56098845;BA.debugLine="sec2=\"08\"";
_sec2 = "08";
 break; }
case 9: {
RDebugUtils.currentLine=56098847;
 //BA.debugLineNum = 56098847;BA.debugLine="sec2=\"09\"";
_sec2 = "09";
 break; }
}
;
RDebugUtils.currentLine=56098849;
 //BA.debugLineNum = 56098849;BA.debugLine="Select min2";
switch (BA.switchObjectToInt(_min2,BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9))) {
case 0: {
RDebugUtils.currentLine=56098851;
 //BA.debugLineNum = 56098851;BA.debugLine="min2=\"00\"";
_min2 = "00";
 break; }
case 1: {
RDebugUtils.currentLine=56098853;
 //BA.debugLineNum = 56098853;BA.debugLine="min2=\"01\"";
_min2 = "01";
 break; }
case 2: {
RDebugUtils.currentLine=56098855;
 //BA.debugLineNum = 56098855;BA.debugLine="min2=\"02\"";
_min2 = "02";
 break; }
case 3: {
RDebugUtils.currentLine=56098857;
 //BA.debugLineNum = 56098857;BA.debugLine="min2=\"03\"";
_min2 = "03";
 break; }
case 4: {
RDebugUtils.currentLine=56098859;
 //BA.debugLineNum = 56098859;BA.debugLine="min2=\"04\"";
_min2 = "04";
 break; }
case 5: {
RDebugUtils.currentLine=56098861;
 //BA.debugLineNum = 56098861;BA.debugLine="min2=\"05\"";
_min2 = "05";
 break; }
case 6: {
RDebugUtils.currentLine=56098863;
 //BA.debugLineNum = 56098863;BA.debugLine="min2=\"06\"";
_min2 = "06";
 break; }
case 7: {
RDebugUtils.currentLine=56098865;
 //BA.debugLineNum = 56098865;BA.debugLine="min2=\"07\"";
_min2 = "07";
 break; }
case 8: {
RDebugUtils.currentLine=56098867;
 //BA.debugLineNum = 56098867;BA.debugLine="min2=\"08\"";
_min2 = "08";
 break; }
case 9: {
RDebugUtils.currentLine=56098869;
 //BA.debugLineNum = 56098869;BA.debugLine="min2=\"09\"";
_min2 = "09";
 break; }
}
;
RDebugUtils.currentLine=56098872;
 //BA.debugLineNum = 56098872;BA.debugLine="lbl_time_remind.Text=min2&\":\"&sec2";
mostCurrent._lbl_time_remind.setText(BA.ObjectToCharSequence(_min2+":"+_sec2));
RDebugUtils.currentLine=56098874;
 //BA.debugLineNum = 56098874;BA.debugLine="If(sec1<1)Then";
if ((_sec1<1)) { 
RDebugUtils.currentLine=56098875;
 //BA.debugLineNum = 56098875;BA.debugLine="min1=min1-1";
_min1 = (int) (_min1-1);
RDebugUtils.currentLine=56098876;
 //BA.debugLineNum = 56098876;BA.debugLine="sec1=60";
_sec1 = (int) (60);
 };
RDebugUtils.currentLine=56098879;
 //BA.debugLineNum = 56098879;BA.debugLine="sec1=sec1-1";
_sec1 = (int) (_sec1-1);
RDebugUtils.currentLine=56098880;
 //BA.debugLineNum = 56098880;BA.debugLine="End Sub";
return "";
}
}