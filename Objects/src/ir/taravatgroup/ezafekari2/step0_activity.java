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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.step0_activity");
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
public ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
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
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
public ir.taravatgroup.ezafekari2.savabeg_activity _savabeg_activity = null;
public ir.taravatgroup.ezafekari2.sayer_activity _sayer_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"step0\")";
mostCurrent._activity.LoadLayout("step0",mostCurrent.activityBA);
 //BA.debugLineNum = 34;BA.debugLine="time_remind.Initialize(\"time_remind\",1000)";
_time_remind.Initialize(processBA,"time_remind",(long) (1000));
 //BA.debugLineNum = 36;BA.debugLine="et_phonNum.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._et_phonnum.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 37;BA.debugLine="et_code_num.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._et_code_num.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 39;BA.debugLine="If (File.Exists(File.DirInternal,\"phonNum_step0\")";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum_step0"))) { 
 //BA.debugLineNum = 40;BA.debugLine="Main.phon_num=File.ReadString(File.DirInternal,\"";
mostCurrent._main._phon_num /*String*/  = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum_step0");
 };
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 262;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 263;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 264;BA.debugLine="If(pan_all_send.Visible=True)Then";
if ((mostCurrent._pan_all_send.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 265;BA.debugLine="lbl_back_run1_Click";
_lbl_back_run1_click();
 }else {
 //BA.debugLineNum = 267;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 //BA.debugLineNum = 270;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 272;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 274;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 51;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public static String  _et_code_num_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 171;BA.debugLine="Private Sub et_code_num_TextChanged (Old As String";
 //BA.debugLineNum = 172;BA.debugLine="If(et_code_num.Text=\"\")Then";
if (((mostCurrent._et_code_num.getText()).equals(""))) { 
 //BA.debugLineNum = 173;BA.debugLine="lbl_run2_step0.Enabled=False";
mostCurrent._lbl_run2_step0.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 175;BA.debugLine="lbl_run2_step0.Enabled=True";
mostCurrent._lbl_run2_step0.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 178;BA.debugLine="End Sub";
return "";
}
public static String  _et_phonnum_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 254;BA.debugLine="Private Sub et_phonNum_TextChanged (Old As String,";
 //BA.debugLineNum = 255;BA.debugLine="If(et_phonNum.Text=\"\")Then";
if (((mostCurrent._et_phonnum.getText()).equals(""))) { 
 //BA.debugLineNum = 256;BA.debugLine="lbl_run1_step0.Enabled=False";
mostCurrent._lbl_run1_step0.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 258;BA.debugLine="lbl_run1_step0.Enabled=True";
mostCurrent._lbl_run1_step0.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 260;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private et_phonNum As EditText";
mostCurrent._et_phonnum = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private et_code_num As EditText";
mostCurrent._et_code_num = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private pan_all_send As Panel";
mostCurrent._pan_all_send = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private lbl_run2_step0 As Label";
mostCurrent._lbl_run2_step0 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Dim http1 As HttpJob";
mostCurrent._http1 = new ir.taravatgroup.ezafekari2.httpjob();
 //BA.debugLineNum = 23;BA.debugLine="Private lbl_time_remind As Label";
mostCurrent._lbl_time_remind = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Dim min1 As Int=14";
_min1 = (int) (14);
 //BA.debugLineNum = 25;BA.debugLine="Dim sec1 As Int=59";
_sec1 = (int) (59);
 //BA.debugLineNum = 27;BA.debugLine="Dim pp1 As Phone";
mostCurrent._pp1 = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 28;BA.debugLine="Private lbl_run1_step0 As Label";
mostCurrent._lbl_run1_step0 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
String _send = "";
 //BA.debugLineNum = 182;BA.debugLine="Sub http_initial_1(type1 As Int)";
 //BA.debugLineNum = 184;BA.debugLine="If(type1=1)Then";
if ((_type1==1)) { 
 //BA.debugLineNum = 185;BA.debugLine="http1.Initialize(\"ht1\",Me)";
mostCurrent._http1._initialize /*String*/ (processBA,"ht1",step0_activity.getObject());
 //BA.debugLineNum = 186;BA.debugLine="Dim send As String";
_send = "";
 //BA.debugLineNum = 187;BA.debugLine="send = \"id=1&num=\"&Main.phon_num&\"&code=0\"";
_send = "id=1&num="+mostCurrent._main._phon_num /*String*/ +"&code=0";
 //BA.debugLineNum = 188;BA.debugLine="http1.PostString(\"https://taravatgroup.ir/sms_re";
mostCurrent._http1._poststring /*String*/ ("https://taravatgroup.ir/sms_req.php",_send);
 //BA.debugLineNum = 190;BA.debugLine="File.WriteString(File.DirInternal,\"phonNum_step0";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum_step0",mostCurrent._main._phon_num /*String*/ );
 //BA.debugLineNum = 192;BA.debugLine="lbl_run2_step0.Enabled=False";
mostCurrent._lbl_run2_step0.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 193;BA.debugLine="pan_all_send.Visible=True";
mostCurrent._pan_all_send.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 194;BA.debugLine="time_remind.Enabled=True";
_time_remind.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else if((_type1==2)) { 
 //BA.debugLineNum = 198;BA.debugLine="http1.Initialize(\"ht2\",Me)";
mostCurrent._http1._initialize /*String*/ (processBA,"ht2",step0_activity.getObject());
 //BA.debugLineNum = 199;BA.debugLine="Dim send As String";
_send = "";
 //BA.debugLineNum = 200;BA.debugLine="send = \"id=2&num=\"&Main.phon_num&\"&code=\"&et_cod";
_send = "id=2&num="+mostCurrent._main._phon_num /*String*/ +"&code="+mostCurrent._et_code_num.getText()+"&div_id="+mostCurrent._pp1.GetSettings("android_id")+"&div_model="+mostCurrent._pp1.getModel();
 //BA.debugLineNum = 201;BA.debugLine="http1.PostString(\"https://taravatgroup.ir/sms_re";
mostCurrent._http1._poststring /*String*/ ("https://taravatgroup.ir/sms_req.php",_send);
 };
 //BA.debugLineNum = 206;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(ir.taravatgroup.ezafekari2.httpjob _job) throws Exception{
 //BA.debugLineNum = 210;BA.debugLine="Sub Jobdone (job As HttpJob)";
 //BA.debugLineNum = 211;BA.debugLine="Try";
try { //BA.debugLineNum = 212;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 213;BA.debugLine="Log(job.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("759441155",_job._getstring /*String*/ (),0);
 //BA.debugLineNum = 214;BA.debugLine="If job.JobName=\"ht1\" Then";
if ((_job._jobname /*String*/ ).equals("ht1")) { 
 }else if((_job._jobname /*String*/ ).equals("ht2")) { 
 //BA.debugLineNum = 218;BA.debugLine="If(job.GetString.Contains(\"okuser\")=True) Then";
if ((_job._getstring /*String*/ ().contains("okuser")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 219;BA.debugLine="File.WriteString(File.DirInternal,\"phonNum\",M";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum",mostCurrent._main._phon_num /*String*/ );
 //BA.debugLineNum = 220;BA.debugLine="job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 222;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 223;BA.debugLine="StartActivity(step2_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step2_activity.getObject()));
 }else if((_job._getstring /*String*/ ().contains("nouser")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 229;BA.debugLine="File.WriteString(File.DirInternal,\"phonNum_st";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum_step1",mostCurrent._main._phon_num /*String*/ );
 //BA.debugLineNum = 230;BA.debugLine="job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 231;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 232;BA.debugLine="StartActivity(step1_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step1_activity.getObject()));
 }else {
 //BA.debugLineNum = 235;BA.debugLine="ToastMessageShow(\"کد تائید اشتباه است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("کد تائید اشتباه است"),anywheresoftware.b4a.keywords.Common.False);
 };
 };
 //BA.debugLineNum = 240;BA.debugLine="job.Release";
_job._release /*String*/ ();
 }else {
 };
 } 
       catch (Exception e24) {
			processBA.setLastException(e24); //BA.debugLineNum = 245;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("759441187",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 246;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 249;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 276;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 278;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 279;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_run1_click() throws Exception{
 //BA.debugLineNum = 166;BA.debugLine="Private Sub lbl_back_run1_Click";
 //BA.debugLineNum = 168;BA.debugLine="pan_all_send.Visible=False";
mostCurrent._pan_all_send.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_code_recived_click() throws Exception{
 //BA.debugLineNum = 281;BA.debugLine="Private Sub lbl_code_recived_Click";
 //BA.debugLineNum = 282;BA.debugLine="lbl_time_remind.Text=\"00:00\"";
mostCurrent._lbl_time_remind.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 283;BA.debugLine="pan_all_send.Visible=True";
mostCurrent._pan_all_send.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 284;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run1_step0_click() throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Private Sub lbl_run1_step0_Click";
 //BA.debugLineNum = 126;BA.debugLine="If(et_phonNum.Text=\"\")Then";
if (((mostCurrent._et_phonnum.getText()).equals(""))) { 
 //BA.debugLineNum = 127;BA.debugLine="ToastMessageShow(\"شماره موبایل معتبر وارد کنید\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("شماره موبایل معتبر وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 130;BA.debugLine="If(et_phonNum.Text.Length=11)Then";
if ((mostCurrent._et_phonnum.getText().length()==11)) { 
 //BA.debugLineNum = 132;BA.debugLine="If(et_phonNum.Text.StartsWith(\"09\"))Then";
if ((mostCurrent._et_phonnum.getText().startsWith("09"))) { 
 //BA.debugLineNum = 133;BA.debugLine="Main.phon_num=et_phonNum.Text";
mostCurrent._main._phon_num /*String*/  = mostCurrent._et_phonnum.getText();
 //BA.debugLineNum = 134;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
 }else {
 //BA.debugLineNum = 136;BA.debugLine="ToastMessageShow(\"شماره موبایل معتبر وارد کنید";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("شماره موبایل معتبر وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 };
 }else {
 //BA.debugLineNum = 140;BA.debugLine="ToastMessageShow(\"شماره موبایل معتبر وارد کنید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("شماره موبایل معتبر وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 };
 };
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run2_step0_click() throws Exception{
 //BA.debugLineNum = 149;BA.debugLine="Private Sub lbl_run2_step0_Click";
 //BA.debugLineNum = 151;BA.debugLine="If(et_code_num.Text=\"\")Then";
if (((mostCurrent._et_code_num.getText()).equals(""))) { 
 //BA.debugLineNum = 152;BA.debugLine="ToastMessageShow(\"کد تائید را وارد کنید\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("کد تائید را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 154;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
 };
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_send_click() throws Exception{
 //BA.debugLineNum = 162;BA.debugLine="Private Sub pan_all_send_Click";
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim time_remind As Timer";
_time_remind = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public static String  _time_remind_tick() throws Exception{
String _sec2 = "";
String _min2 = "";
 //BA.debugLineNum = 55;BA.debugLine="Sub time_remind_Tick";
 //BA.debugLineNum = 57;BA.debugLine="If(min1<1 And sec1<1)Then";
if ((_min1<1 && _sec1<1)) { 
 //BA.debugLineNum = 58;BA.debugLine="time_remind.Enabled=False";
_time_remind.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 59;BA.debugLine="lbl_time_remind.Text=\"0:0\"";
mostCurrent._lbl_time_remind.setText(BA.ObjectToCharSequence("0:0"));
 //BA.debugLineNum = 60;BA.debugLine="lbl_run2_step0.Enabled=True";
mostCurrent._lbl_run2_step0.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 61;BA.debugLine="pan_all_send.Visible=False";
mostCurrent._pan_all_send.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 64;BA.debugLine="Dim sec2 As String=sec1";
_sec2 = BA.NumberToString(_sec1);
 //BA.debugLineNum = 65;BA.debugLine="Dim min2 As String=min1";
_min2 = BA.NumberToString(_min1);
 //BA.debugLineNum = 66;BA.debugLine="Select sec2";
switch (BA.switchObjectToInt(_sec2,BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9))) {
case 0: {
 //BA.debugLineNum = 68;BA.debugLine="sec2=\"00\"";
_sec2 = "00";
 break; }
case 1: {
 //BA.debugLineNum = 70;BA.debugLine="sec2=\"01\"";
_sec2 = "01";
 break; }
case 2: {
 //BA.debugLineNum = 72;BA.debugLine="sec2=\"02\"";
_sec2 = "02";
 break; }
case 3: {
 //BA.debugLineNum = 74;BA.debugLine="sec2=\"03\"";
_sec2 = "03";
 break; }
case 4: {
 //BA.debugLineNum = 76;BA.debugLine="sec2=\"04\"";
_sec2 = "04";
 break; }
case 5: {
 //BA.debugLineNum = 78;BA.debugLine="sec2=\"05\"";
_sec2 = "05";
 break; }
case 6: {
 //BA.debugLineNum = 80;BA.debugLine="sec2=\"06\"";
_sec2 = "06";
 break; }
case 7: {
 //BA.debugLineNum = 82;BA.debugLine="sec2=\"07\"";
_sec2 = "07";
 break; }
case 8: {
 //BA.debugLineNum = 84;BA.debugLine="sec2=\"08\"";
_sec2 = "08";
 break; }
case 9: {
 //BA.debugLineNum = 86;BA.debugLine="sec2=\"09\"";
_sec2 = "09";
 break; }
}
;
 //BA.debugLineNum = 88;BA.debugLine="Select min2";
switch (BA.switchObjectToInt(_min2,BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9))) {
case 0: {
 //BA.debugLineNum = 90;BA.debugLine="min2=\"00\"";
_min2 = "00";
 break; }
case 1: {
 //BA.debugLineNum = 92;BA.debugLine="min2=\"01\"";
_min2 = "01";
 break; }
case 2: {
 //BA.debugLineNum = 94;BA.debugLine="min2=\"02\"";
_min2 = "02";
 break; }
case 3: {
 //BA.debugLineNum = 96;BA.debugLine="min2=\"03\"";
_min2 = "03";
 break; }
case 4: {
 //BA.debugLineNum = 98;BA.debugLine="min2=\"04\"";
_min2 = "04";
 break; }
case 5: {
 //BA.debugLineNum = 100;BA.debugLine="min2=\"05\"";
_min2 = "05";
 break; }
case 6: {
 //BA.debugLineNum = 102;BA.debugLine="min2=\"06\"";
_min2 = "06";
 break; }
case 7: {
 //BA.debugLineNum = 104;BA.debugLine="min2=\"07\"";
_min2 = "07";
 break; }
case 8: {
 //BA.debugLineNum = 106;BA.debugLine="min2=\"08\"";
_min2 = "08";
 break; }
case 9: {
 //BA.debugLineNum = 108;BA.debugLine="min2=\"09\"";
_min2 = "09";
 break; }
}
;
 //BA.debugLineNum = 111;BA.debugLine="lbl_time_remind.Text=min2&\":\"&sec2";
mostCurrent._lbl_time_remind.setText(BA.ObjectToCharSequence(_min2+":"+_sec2));
 //BA.debugLineNum = 113;BA.debugLine="If(sec1<1)Then";
if ((_sec1<1)) { 
 //BA.debugLineNum = 114;BA.debugLine="min1=min1-1";
_min1 = (int) (_min1-1);
 //BA.debugLineNum = 115;BA.debugLine="sec1=60";
_sec1 = (int) (60);
 };
 //BA.debugLineNum = 118;BA.debugLine="sec1=sec1-1";
_sec1 = (int) (_sec1-1);
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
return "";
}
}
