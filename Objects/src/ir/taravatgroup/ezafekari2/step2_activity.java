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

public class step2_activity extends Activity implements B4AActivity{
	public static step2_activity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.step2_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (step2_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.step2_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.step2_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (step2_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (step2_activity) Resume **");
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
		return step2_activity.class;
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
            BA.LogInfo("** Activity (step2_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (step2_activity) Pause event (activity is not paused). **");
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
            step2_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (step2_activity) Resume **");
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
public static de.donmanfred.Compressorwrapper _comp = null;
public static anywheresoftware.b4a.phone.Phone.ContentChooser _cc = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_edit = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_email = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_namefamili = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_noske = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_namefamili = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_email = null;
public ir.taravatgroup.ezafekari2.httpjob _http3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_phonenum = null;
public com.spinter.uploadfilephp.UploadFilePhp _up = null;
public static String _url_php_page = "";
public anywheresoftware.b4a.objects.ImageViewWrapper _img_p_edit = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _img_pofil = null;
public static String _path_phone_image = "";
public static String _picname = "";
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_image_up = null;
public anywheresoftware.b4a.phone.Phone _pp = null;
public static int _type_app = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_msg = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_msg = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_icon_up = null;
public static String _tempfile = "";
public static String _user_key = "";
public anywheresoftware.b4a.objects.WebViewWrapper _wb_show_mymsg = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_show_mymsg = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_icon_noup = null;
public anywheresoftware.b4a.objects.LabelWrapper _label12 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel12 = null;
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
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
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 58;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 60;BA.debugLine="Activity.LoadLayout(\"step2\")";
mostCurrent._activity.LoadLayout("step2",mostCurrent.activityBA);
 //BA.debugLineNum = 66;BA.debugLine="If(File.Exists(File.DirInternal,\"phonNum\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum"))) { 
 //BA.debugLineNum = 67;BA.debugLine="Main.phon_num=File.ReadString(File.DirInternal,\"";
mostCurrent._main._phon_num /*String*/  = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum");
 //BA.debugLineNum = 70;BA.debugLine="If(myfunc.check_karid=False)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 71;BA.debugLine="lbl_noske.Text=\"???????? ????????\"";
mostCurrent._lbl_noske.setText(BA.ObjectToCharSequence("???????? ????????"));
 //BA.debugLineNum = 72;BA.debugLine="type_app=0";
_type_app = (int) (0);
 }else {
 //BA.debugLineNum = 74;BA.debugLine="lbl_noske.Text=\"???????? ??????????\"";
mostCurrent._lbl_noske.setText(BA.ObjectToCharSequence("???????? ??????????"));
 //BA.debugLineNum = 75;BA.debugLine="type_app=1";
_type_app = (int) (1);
 };
 //BA.debugLineNum = 82;BA.debugLine="CC.Initialize(\"CC\")";
_cc.Initialize("CC");
 //BA.debugLineNum = 83;BA.debugLine="Url_Php_Page=\"https://taravatgroup.ir/avatar_up1";
mostCurrent._url_php_page = "https://taravatgroup.ir/avatar_up1.php";
 //BA.debugLineNum = 85;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 86;BA.debugLine="Up.B4A_log=True";
mostCurrent._up.B4A_log = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 87;BA.debugLine="Up.Initialize(\"Up\")";
mostCurrent._up.Initialize(processBA,"Up");
 };
 //BA.debugLineNum = 91;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
 }else {
 //BA.debugLineNum = 106;BA.debugLine="StartActivity(step0_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step0_activity.getObject()));
 //BA.debugLineNum = 107;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 112;BA.debugLine="Label12.Color=Main.color4";
mostCurrent._label12.setColor(mostCurrent._main._color4 /*int*/ );
 //BA.debugLineNum = 113;BA.debugLine="Panel12.Color=Main.color4";
mostCurrent._panel12.setColor(mostCurrent._main._color4 /*int*/ );
 //BA.debugLineNum = 114;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 407;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 408;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 409;BA.debugLine="If(pan_all_edit.Visible=True)Then";
if ((mostCurrent._pan_all_edit.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 410;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 }else if((mostCurrent._pan_all_msg.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 412;BA.debugLine="pan_all_msg.Visible=False";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_all_show_mymsg.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 414;BA.debugLine="pan_all_show_myMsg.Visible=False";
mostCurrent._pan_all_show_mymsg.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 416;BA.debugLine="lbl_back_home_Click";
_lbl_back_home_click();
 };
 //BA.debugLineNum = 419;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 421;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 423;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 123;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 119;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private pan_all_edit As Panel";
mostCurrent._pan_all_edit = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private et_email As EditText";
mostCurrent._et_email = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private et_nameFamili As EditText";
mostCurrent._et_namefamili = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private lbl_noske As Label";
mostCurrent._lbl_noske = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private lbl_nameFamili As Label";
mostCurrent._lbl_namefamili = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_email As Label";
mostCurrent._lbl_email = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Dim http3 As HttpJob";
mostCurrent._http3 = new ir.taravatgroup.ezafekari2.httpjob();
 //BA.debugLineNum = 25;BA.debugLine="Private lbl_phoneNum As Label";
mostCurrent._lbl_phonenum = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Dim Up As UploadFilePhp";
mostCurrent._up = new com.spinter.uploadfilephp.UploadFilePhp();
 //BA.debugLineNum = 29;BA.debugLine="Dim Url_Php_Page As String";
mostCurrent._url_php_page = "";
 //BA.debugLineNum = 30;BA.debugLine="Private img_p_edit As ImageView";
mostCurrent._img_p_edit = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private img_pofil As ImageView";
mostCurrent._img_pofil = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Dim Path_Phone_Image As String";
mostCurrent._path_phone_image = "";
 //BA.debugLineNum = 37;BA.debugLine="Dim picName As String=\"\"";
mostCurrent._picname = "";
 //BA.debugLineNum = 38;BA.debugLine="Dim bmp As Bitmap";
mostCurrent._bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private lbl_image_up As Label";
mostCurrent._lbl_image_up = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Dim pp As Phone";
mostCurrent._pp = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 43;BA.debugLine="Dim type_app As Int=1";
_type_app = (int) (1);
 //BA.debugLineNum = 45;BA.debugLine="Private pan_all_msg As Panel";
mostCurrent._pan_all_msg = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private et_msg As EditText";
mostCurrent._et_msg = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private lbl_icon_up As Label";
mostCurrent._lbl_icon_up = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Dim tempFile As String=\"\"";
mostCurrent._tempfile = "";
 //BA.debugLineNum = 49;BA.debugLine="Dim user_key As String=\"\"";
mostCurrent._user_key = "";
 //BA.debugLineNum = 51;BA.debugLine="Private wb_show_myMsg As WebView";
mostCurrent._wb_show_mymsg = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private pan_all_show_myMsg As Panel";
mostCurrent._pan_all_show_mymsg = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private lbl_icon_noUp As Label";
mostCurrent._lbl_icon_noup = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private Label12 As Label";
mostCurrent._label12 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Private Panel12 As Panel";
mostCurrent._panel12 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
String _send = "";
int _exist_pic = 0;
 //BA.debugLineNum = 170;BA.debugLine="Sub http_initial_1(type1 As Int)";
 //BA.debugLineNum = 171;BA.debugLine="If (myfunc.check_internet=False)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 172;BA.debugLine="myfunc.help_man(\"????????\",\"?????????? ?????????????? ???? ?????????? ??";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"????????","?????????? ?????????????? ???? ?????????? ???????? !");
 }else {
 //BA.debugLineNum = 177;BA.debugLine="If(type1=1)Then";
if ((_type1==1)) { 
 //BA.debugLineNum = 179;BA.debugLine="http3.Initialize(\"ht1\",Me)";
mostCurrent._http3._initialize /*String*/ (processBA,"ht1",step2_activity.getObject());
 //BA.debugLineNum = 180;BA.debugLine="Dim send As String= \"var=3&phone=\"&Main.phon_nu";
_send = "var=3&phone="+mostCurrent._main._phon_num /*String*/ +"&type_app="+BA.NumberToString(_type_app)+"&div_id="+mostCurrent._pp.GetSettings("android_id")+"&div_model="+mostCurrent._pp.getModel();
 //BA.debugLineNum = 181;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
mostCurrent._http3._poststring /*String*/ ("https://taravatgroup.ir/save_acc.php",_send);
 }else if((_type1==2)) { 
 //BA.debugLineNum = 183;BA.debugLine="Dim exist_pic As Int=0";
_exist_pic = (int) (0);
 //BA.debugLineNum = 184;BA.debugLine="If(File.Exists(Starter.Provider.SharedFolder,pi";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._picname))) { 
 //BA.debugLineNum = 185;BA.debugLine="upload_img(Starter.Provider.SharedFolder&\"/\"&p";
_upload_img(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ +"/"+mostCurrent._picname);
 //BA.debugLineNum = 186;BA.debugLine="exist_pic=1";
_exist_pic = (int) (1);
 };
 //BA.debugLineNum = 189;BA.debugLine="http3.Initialize(\"ht2\",Me)";
mostCurrent._http3._initialize /*String*/ (processBA,"ht2",step2_activity.getObject());
 //BA.debugLineNum = 190;BA.debugLine="Dim send As String=\"var=2&name=\"&et_nameFamili.";
_send = "var=2&name="+mostCurrent._et_namefamili.getText()+"&email="+mostCurrent._et_email.getText()+"&phone="+mostCurrent._main._phon_num /*String*/ +"&exist_pic="+BA.NumberToString(_exist_pic)+"&pic_name="+mostCurrent._picname;
 //BA.debugLineNum = 191;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
mostCurrent._http3._poststring /*String*/ ("https://taravatgroup.ir/save_acc.php",_send);
 }else if((_type1==3)) { 
 //BA.debugLineNum = 196;BA.debugLine="http3.Initialize(\"ht3\",Me)";
mostCurrent._http3._initialize /*String*/ (processBA,"ht3",step2_activity.getObject());
 //BA.debugLineNum = 197;BA.debugLine="Dim send As String= \"var=4&phone=\"&Main.phon_nu";
_send = "var=4&phone="+mostCurrent._main._phon_num /*String*/ +"&name="+mostCurrent._lbl_namefamili.getText();
 //BA.debugLineNum = 198;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
mostCurrent._http3._poststring /*String*/ ("https://taravatgroup.ir/save_acc.php",_send);
 }else if((_type1==4)) { 
 //BA.debugLineNum = 201;BA.debugLine="http3.Initialize(\"ht4\",Me)";
mostCurrent._http3._initialize /*String*/ (processBA,"ht4",step2_activity.getObject());
 //BA.debugLineNum = 202;BA.debugLine="Dim send As String= \"var=5&phone=\"&Main.phon_nu";
_send = "var=5&phone="+mostCurrent._main._phon_num /*String*/ +"&name="+mostCurrent._lbl_namefamili.getText();
 //BA.debugLineNum = 203;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
mostCurrent._http3._poststring /*String*/ ("https://taravatgroup.ir/save_acc.php",_send);
 }else if((_type1==5)) { 
 //BA.debugLineNum = 206;BA.debugLine="If(File.Exists(Starter.Provider.SharedFolder,te";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._tempfile))) { 
 //BA.debugLineNum = 207;BA.debugLine="upload_file(Starter.Provider.SharedFolder&\"/\"&";
_upload_file(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ +"/"+mostCurrent._tempfile);
 }else {
 //BA.debugLineNum = 209;BA.debugLine="tempFile=\"\"";
mostCurrent._tempfile = "";
 };
 //BA.debugLineNum = 212;BA.debugLine="If(et_msg.Text.Trim=\"\")Then";
if (((mostCurrent._et_msg.getText().trim()).equals(""))) { 
 //BA.debugLineNum = 213;BA.debugLine="ToastMessageShow(\"???????? ???????? ???????? ??????\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("???????? ???????? ???????? ??????"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 216;BA.debugLine="http3.Initialize(\"ht5\",Me)";
mostCurrent._http3._initialize /*String*/ (processBA,"ht5",step2_activity.getObject());
 //BA.debugLineNum = 217;BA.debugLine="Dim send As String= \"var=6&phone=\"&Main.phon_n";
_send = "var=6&phone="+mostCurrent._main._phon_num /*String*/ +"&msg="+mostCurrent._et_msg.getText()+"&file_name="+mostCurrent._tempfile+"&name="+mostCurrent._lbl_namefamili.getText();
 //BA.debugLineNum = 218;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save";
mostCurrent._http3._poststring /*String*/ ("https://taravatgroup.ir/save_acc.php",_send);
 //BA.debugLineNum = 219;BA.debugLine="pan_all_msg.Visible=False";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }else if((_type1==6)) { 
 //BA.debugLineNum = 226;BA.debugLine="http3.Initialize(\"ht7\", Me)";
mostCurrent._http3._initialize /*String*/ (processBA,"ht7",step2_activity.getObject());
 //BA.debugLineNum = 227;BA.debugLine="http3.Download(\"https://taravatgroup.ir/avatar_";
mostCurrent._http3._download /*String*/ ("https://taravatgroup.ir/avatar_ezaf_users/"+mostCurrent._picname);
 }else if((_type1==7)) { 
 //BA.debugLineNum = 230;BA.debugLine="http3.Initialize(\"ht8\", Me)";
mostCurrent._http3._initialize /*String*/ (processBA,"ht8",step2_activity.getObject());
 //BA.debugLineNum = 232;BA.debugLine="Dim send As String= \"var=1&phone=\"&Main.phon_nu";
_send = "var=1&phone="+mostCurrent._main._phon_num /*String*/ +"&key=mME22eBbA20aDd1401";
 //BA.debugLineNum = 233;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/user_";
mostCurrent._http3._poststring /*String*/ ("https://taravatgroup.ir/user_msg.php",_send);
 };
 };
 //BA.debugLineNum = 238;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(ir.taravatgroup.ezafekari2.httpjob _job) throws Exception{
String[] _a = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
anywheresoftware.b4a.objects.collections.List _ls_user = null;
 //BA.debugLineNum = 242;BA.debugLine="Sub Jobdone (job As HttpJob)";
 //BA.debugLineNum = 243;BA.debugLine="Try";
try { //BA.debugLineNum = 245;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 247;BA.debugLine="If job.JobName=\"ht1\" Then";
if ((_job._jobname /*String*/ ).equals("ht1")) { 
 //BA.debugLineNum = 248;BA.debugLine="If(job.GetString.Contains(\"nouser\"))Then";
if ((_job._getstring /*String*/ ().contains("nouser"))) { 
 //BA.debugLineNum = 250;BA.debugLine="File.Delete(File.DirInternal,\"userAcc\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
 //BA.debugLineNum = 251;BA.debugLine="StartActivity(step0_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step0_activity.getObject()));
 //BA.debugLineNum = 252;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 }else {
 //BA.debugLineNum = 255;BA.debugLine="Dim a() As String";
_a = new String[(int) (0)];
java.util.Arrays.fill(_a,"");
 //BA.debugLineNum = 256;BA.debugLine="a=Regex.Split(\"&\",job.GetString)";
_a = anywheresoftware.b4a.keywords.Common.Regex.Split("&",_job._getstring /*String*/ ());
 //BA.debugLineNum = 258;BA.debugLine="lbl_nameFamili.Text=a(0)";
mostCurrent._lbl_namefamili.setText(BA.ObjectToCharSequence(_a[(int) (0)]));
 //BA.debugLineNum = 259;BA.debugLine="lbl_email.Text=a(1)";
mostCurrent._lbl_email.setText(BA.ObjectToCharSequence(_a[(int) (1)]));
 //BA.debugLineNum = 267;BA.debugLine="lbl_phoneNum.Text=a(2)";
mostCurrent._lbl_phonenum.setText(BA.ObjectToCharSequence(_a[(int) (2)]));
 //BA.debugLineNum = 269;BA.debugLine="user_key=a(4)";
mostCurrent._user_key = _a[(int) (4)];
 //BA.debugLineNum = 271;BA.debugLine="picName=\"user-\"&Main.phon_num&\"-\"&a(4)&\".jpg\"";
mostCurrent._picname = "user-"+mostCurrent._main._phon_num /*String*/ +"-"+_a[(int) (4)]+".jpg";
 //BA.debugLineNum = 272;BA.debugLine="If(File.Exists(File.DirInternal,picName)=Fals";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 273;BA.debugLine="If(a(3)=\"1\")Then";
if (((_a[(int) (3)]).equals("1"))) { 
 //BA.debugLineNum = 274;BA.debugLine="http_initial_1(6)";
_http_initial_1((int) (6));
 };
 }else {
 //BA.debugLineNum = 277;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBit";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 //BA.debugLineNum = 278;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBi";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 };
 //BA.debugLineNum = 282;BA.debugLine="File.WriteList(File.DirInternal,\"userAcc\",a)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc",anywheresoftware.b4a.keywords.Common.ArrayToList(_a));
 };
 }else if((_job._jobname /*String*/ ).equals("ht2")) { 
 //BA.debugLineNum = 288;BA.debugLine="If(job.GetString.Contains(\"true\"))Then";
if ((_job._getstring /*String*/ ().contains("true"))) { 
 //BA.debugLineNum = 289;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
 };
 }else if((_job._jobname /*String*/ ).equals("ht3")) { 
 //BA.debugLineNum = 294;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
if ((_job._getstring /*String*/ ().contains("ok_add"))) { 
 //BA.debugLineNum = 295;BA.debugLine="MsgboxAsync(\"?????????????? ?????? ???? ???????????? ?????? ??????????";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("?????????????? ?????? ???? ???????????? ?????? ?????????? ???????????? ???? ???? ???????? ?????? ???? ?????????? ?????? ?????????? ????????. ???? ???????? "),BA.ObjectToCharSequence("????????"),processBA);
 }else {
 //BA.debugLineNum = 297;BA.debugLine="MsgboxAsync(\"?????? ???? ?????????? ???????????????? ???????????? ??????";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("?????? ???? ?????????? ???????????????? ???????????? ???????????? ????????."),BA.ObjectToCharSequence("??????"),processBA);
 };
 }else if((_job._jobname /*String*/ ).equals("ht4")) { 
 //BA.debugLineNum = 302;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
if ((_job._getstring /*String*/ ().contains("ok_add"))) { 
 //BA.debugLineNum = 303;BA.debugLine="MsgboxAsync(\"?????????????? ?????? ???? ???????????? ?????? ??????????";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("?????????????? ?????? ???? ???????????? ?????? ?????????? ???????????? ???? ???? ???????? ?????? ???? ?????????? ?????? ?????????? ????????. ???? ???????? "),BA.ObjectToCharSequence("????????"),processBA);
 }else {
 //BA.debugLineNum = 305;BA.debugLine="MsgboxAsync(\"?????? ???? ?????????? ???????????????? ???????????? ??????";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("?????? ???? ?????????? ???????????????? ???????????? ???????????? ????????."),BA.ObjectToCharSequence("??????"),processBA);
 };
 }else if((_job._jobname /*String*/ ).equals("ht5")) { 
 //BA.debugLineNum = 310;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
if ((_job._getstring /*String*/ ().contains("ok_add"))) { 
 //BA.debugLineNum = 311;BA.debugLine="MsgboxAsync(\"?????????? ?????? ???? ???????????? ?????? ?????????? ????";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("?????????? ?????? ???? ???????????? ?????? ?????????? ???????????? ???? ???? ???????? ?????? ???? ?????????? ?????? ?????????? ????????. ???? ???????? "),BA.ObjectToCharSequence("????????"),processBA);
 }else {
 //BA.debugLineNum = 314;BA.debugLine="MsgboxAsync(\"?????? ???? ?????????? ???????????? ???????????? ??????????";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("?????? ???? ?????????? ???????????? ???????????? ???????????? ????????."),BA.ObjectToCharSequence("??????"),processBA);
 };
 }else if((_job._jobname /*String*/ ).equals("ht6")) { 
 //BA.debugLineNum = 320;BA.debugLine="Dim out As OutputStream = File.OpenOutput(File";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 321;BA.debugLine="File.Copy2(http3.GetInputStream, out)";
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(mostCurrent._http3._getinputstream /*anywheresoftware.b4a.objects.streams.File.InputStreamWrapper*/ ().getObject()),(java.io.OutputStream)(_out.getObject()));
 //BA.debugLineNum = 322;BA.debugLine="out.Close";
_out.Close();
 //BA.debugLineNum = 323;BA.debugLine="ToastMessageShow(\"?????????????? ???????????????????? ????\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("?????????????? ???????????????????? ????"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 325;BA.debugLine="lbl_back_home_Click";
_lbl_back_home_click();
 }else if((_job._jobname /*String*/ ).equals("ht7")) { 
 //BA.debugLineNum = 332;BA.debugLine="Dim bmp As Bitmap = job.GetBitmap";
mostCurrent._bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
mostCurrent._bmp = _job._getbitmap /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ ();
 //BA.debugLineNum = 333;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
 //BA.debugLineNum = 334;BA.debugLine="out = File.OpenOutput(File.DirInternal,picName";
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 335;BA.debugLine="bmp.WriteToStream(out, 100, \"JPEG\")";
mostCurrent._bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (100),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"JPEG"));
 //BA.debugLineNum = 336;BA.debugLine="out.Close";
_out.Close();
 //BA.debugLineNum = 340;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitma";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 //BA.debugLineNum = 341;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitm";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 }else if((_job._jobname /*String*/ ).equals("ht8")) { 
 //BA.debugLineNum = 345;BA.debugLine="wb_show_myMsg.LoadHtml(job.GetString)";
mostCurrent._wb_show_mymsg.LoadHtml(_job._getstring /*String*/ ());
 };
 //BA.debugLineNum = 350;BA.debugLine="job.Release";
_job._release /*String*/ ();
 }else {
 //BA.debugLineNum = 354;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\")=True";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 356;BA.debugLine="Dim ls_user As List";
_ls_user = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 357;BA.debugLine="ls_user.Initialize";
_ls_user.Initialize();
 //BA.debugLineNum = 358;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAc";
_ls_user = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
 //BA.debugLineNum = 360;BA.debugLine="lbl_nameFamili.Text=ls_user.Get(0)";
mostCurrent._lbl_namefamili.setText(BA.ObjectToCharSequence(_ls_user.Get((int) (0))));
 //BA.debugLineNum = 361;BA.debugLine="lbl_email.Text=ls_user.Get(1)";
mostCurrent._lbl_email.setText(BA.ObjectToCharSequence(_ls_user.Get((int) (1))));
 //BA.debugLineNum = 368;BA.debugLine="Main.phon_num=ls_user.Get(2)";
mostCurrent._main._phon_num /*String*/  = BA.ObjectToString(_ls_user.Get((int) (2)));
 //BA.debugLineNum = 369;BA.debugLine="lbl_phoneNum.Text=Main.phon_num";
mostCurrent._lbl_phonenum.setText(BA.ObjectToCharSequence(mostCurrent._main._phon_num /*String*/ ));
 //BA.debugLineNum = 371;BA.debugLine="picName=\"user-\"&Main.phon_num&\"-\"&ls_user.Get(";
mostCurrent._picname = "user-"+mostCurrent._main._phon_num /*String*/ +"-"+BA.ObjectToString(_ls_user.Get((int) (4)))+".jpg";
 //BA.debugLineNum = 373;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitma";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 //BA.debugLineNum = 374;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitm";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 };
 };
 } 
       catch (Exception e81) {
			processBA.setLastException(e81); //BA.debugLineNum = 382;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("414418060",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 383;BA.debugLine="ToastMessageShow(\"?????? ???? ??????????\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("?????? ???? ??????????"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 386;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_all_msg_click() throws Exception{
 //BA.debugLineNum = 605;BA.debugLine="Private Sub lbl_all_msg_Click";
 //BA.debugLineNum = 606;BA.debugLine="http_initial_1(7)";
_http_initial_1((int) (7));
 //BA.debugLineNum = 607;BA.debugLine="pan_all_show_myMsg.Visible=True";
mostCurrent._pan_all_show_mymsg.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 610;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 149;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 150;BA.debugLine="pan_all_edit.Visible=False";
mostCurrent._pan_all_edit.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 151;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_home_click() throws Exception{
 //BA.debugLineNum = 426;BA.debugLine="Private Sub lbl_back_home_Click";
 //BA.debugLineNum = 427;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 428;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 429;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_shmsg_click() throws Exception{
 //BA.debugLineNum = 612;BA.debugLine="Private Sub lbl_back_Shmsg_Click";
 //BA.debugLineNum = 613;BA.debugLine="pan_all_show_myMsg.Visible=False";
mostCurrent._pan_all_show_mymsg.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 614;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chek_noskhe_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 509;BA.debugLine="Private Sub lbl_chek_noskhe_Click";
 //BA.debugLineNum = 510;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 511;BA.debugLine="result = Msgbox2(\"???????? ???????? ???????? ???? ?????????? ????????\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("???????? ???????? ???????? ???? ?????????? ????????"),BA.ObjectToCharSequence("?????????????? ??????????"),"?????? ?????????????? ","","??????",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 512;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 513;BA.debugLine="http_initial_1(4)";
_http_initial_1((int) (4));
 };
 //BA.debugLineNum = 515;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_click() throws Exception{
 //BA.debugLineNum = 390;BA.debugLine="Private Sub lbl_edit_Click";
 //BA.debugLineNum = 393;BA.debugLine="et_nameFamili.Text=	lbl_nameFamili.Text";
mostCurrent._et_namefamili.setText(BA.ObjectToCharSequence(mostCurrent._lbl_namefamili.getText()));
 //BA.debugLineNum = 394;BA.debugLine="et_email.Text=lbl_email.Text";
mostCurrent._et_email.setText(BA.ObjectToCharSequence(mostCurrent._lbl_email.getText()));
 //BA.debugLineNum = 395;BA.debugLine="comp.Initialize(\"Compressor\")";
_comp.Initialize(processBA,"Compressor");
 //BA.debugLineNum = 396;BA.debugLine="comp.Quality=30";
_comp.setQuality((int) (30));
 //BA.debugLineNum = 397;BA.debugLine="lbl_image_up.Text=Chr(0xF0EE)";
mostCurrent._lbl_image_up.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf0ee))));
 //BA.debugLineNum = 398;BA.debugLine="pan_all_edit.Visible=True";
mostCurrent._pan_all_edit.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 403;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_icon_noup_click() throws Exception{
 //BA.debugLineNum = 621;BA.debugLine="Private Sub lbl_icon_noUp_Click";
 //BA.debugLineNum = 623;BA.debugLine="File.Delete(Starter.Provider.SharedFolder, tempFil";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._tempfile);
 //BA.debugLineNum = 625;BA.debugLine="lbl_icon_up.Text=\"\"";
mostCurrent._lbl_icon_up.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 626;BA.debugLine="lbl_icon_noUp.Visible=False";
mostCurrent._lbl_icon_noup.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 627;BA.debugLine="End Sub";
return "";
}
public static void  _lbl_image_up_click() throws Exception{
ResumableSub_lbl_image_up_Click rsub = new ResumableSub_lbl_image_up_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_lbl_image_up_Click extends BA.ResumableSub {
public ResumableSub_lbl_image_up_Click(ir.taravatgroup.ezafekari2.step2_activity parent) {
this.parent = parent;
}
ir.taravatgroup.ezafekari2.step2_activity parent;
boolean _success = false;
String _dir = "";
String _filename = "";
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 432;BA.debugLine="Try";
if (true) break;

case 1:
//try
this.state = 18;
this.catchState = 17;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 17;
 //BA.debugLineNum = 433;BA.debugLine="CC.Show(\"image/*\", \"Choose image\")";
parent._cc.Show(processBA,"image/*","Choose image");
 //BA.debugLineNum = 435;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As S";
anywheresoftware.b4a.keywords.Common.WaitFor("cc_result", processBA, this, null);
this.state = 19;
return;
case 19:
//C
this.state = 4;
_success = (Boolean) result[0];
_dir = (String) result[1];
_filename = (String) result[2];
;
 //BA.debugLineNum = 436;BA.debugLine="If Success = True Then";
if (true) break;

case 4:
//if
this.state = 15;
if (_success==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 6;
}else {
this.state = 14;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 438;BA.debugLine="Try";
if (true) break;

case 7:
//try
this.state = 12;
this.catchState = 11;
this.state = 9;
if (true) break;

case 9:
//C
this.state = 12;
this.catchState = 11;
 //BA.debugLineNum = 439;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"temp_pic.jpg");
 //BA.debugLineNum = 440;BA.debugLine="bmp = comp.compressToBitmap(Starter.Provider.S";
parent.mostCurrent._bmp = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent._comp.compressToBitmap(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"temp_pic.jpg")));
 //BA.debugLineNum = 441;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Star";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._picname,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 442;BA.debugLine="bmp.WriteToStream(out, 20, \"JPEG\")";
parent.mostCurrent._bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (20),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"JPEG"));
 //BA.debugLineNum = 443;BA.debugLine="out.Close";
_out.Close();
 if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 17;
 //BA.debugLineNum = 446;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._picname);
 //BA.debugLineNum = 447;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("414680080",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 12:
//C
this.state = 15;
this.catchState = 17;
;
 //BA.debugLineNum = 450;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitma";
parent.mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(parent.mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._picname)).getObject()));
 if (true) break;

case 14:
//C
this.state = 15;
 //BA.debugLineNum = 453;BA.debugLine="ToastMessageShow(\"?????????? ?????? :(\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("?????????? ?????? :("),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 15:
//C
this.state = 18;
;
 if (true) break;

case 17:
//C
this.state = 18;
this.catchState = 0;
 //BA.debugLineNum = 457;BA.debugLine="ToastMessageShow(\"?????? ???? ????????????????\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("?????? ???? ????????????????"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 458;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("414680091",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 461;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static void  _cc_result(boolean _success,String _dir,String _filename) throws Exception{
}
public static String  _lbl_logoff_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 153;BA.debugLine="Private Sub lbl_logOff_Click";
 //BA.debugLineNum = 154;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 155;BA.debugLine="result = Msgbox2(\"?????? ???? ???????? ?????? ???????? ???? ??????????\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("?????? ???? ???????? ?????? ???????? ???? ??????????"),BA.ObjectToCharSequence("????????"),"??????","","??????",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 156;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 157;BA.debugLine="File.Delete(File.DirInternal,\"userAcc\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
 //BA.debugLineNum = 159;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 160;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_reseve_db_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 517;BA.debugLine="Private Sub lbl_reseve_db_Click";
 //BA.debugLineNum = 518;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 519;BA.debugLine="result = Msgbox2(\"?????????????? ???? ???? ???????? ?????????????? ????????";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("?????????????? ???? ???? ???????? ?????????????? ????????.???????? ?????????? ?????????? ?????????????? ???????? ?????? ???? ????????"),BA.ObjectToCharSequence("???????????????????? ?????????????? "),"?????????? ????????","","??????",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 520;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 522;BA.debugLine="http3.Initialize(\"ht6\", Me)";
mostCurrent._http3._initialize /*String*/ (processBA,"ht6",step2_activity.getObject());
 //BA.debugLineNum = 523;BA.debugLine="http3.Download(\"https://taravatgroup.ir/uploads_";
mostCurrent._http3._download /*String*/ ("https://taravatgroup.ir/uploads_ezaf/"+mostCurrent._main._phon_num /*String*/ +"-db-"+mostCurrent._user_key+".db");
 };
 //BA.debugLineNum = 526;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_edit_click() throws Exception{
 //BA.debugLineNum = 131;BA.debugLine="Private Sub lbl_save_edit_Click";
 //BA.debugLineNum = 132;BA.debugLine="If (myfunc.check_internet=False)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 133;BA.debugLine="myfunc.help_man(\"????????\",\"?????????? ?????????????? ???? ?????????? ??";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"????????","?????????? ?????????????? ???? ?????????? ???????? !");
 }else if(((mostCurrent._et_namefamili.getText()).equals(""))) { 
 //BA.debugLineNum = 135;BA.debugLine="ToastMessageShow(\"???????? ?????? ???????? ?????? \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("???????? ?????? ???????? ?????? "),anywheresoftware.b4a.keywords.Common.False);
 }else if(((mostCurrent._et_email.getText()).equals(""))) { 
 //BA.debugLineNum = 138;BA.debugLine="ToastMessageShow(\"???????? ?????????? ???????? ?????? \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("???????? ?????????? ???????? ?????? "),anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._myfunc._validate_email /*boolean*/ (mostCurrent.activityBA,mostCurrent._et_email.getText())==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 141;BA.debugLine="ToastMessageShow(\" ?????????? ?????????????? ?????? \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" ?????????? ?????????????? ?????? "),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 143;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
 };
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_db_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 528;BA.debugLine="Private Sub lbl_send_db_Click";
 //BA.debugLineNum = 530;BA.debugLine="File.Copy(File.DirInternal,\"db.db\",Starter.Provid";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._main._phon_num /*String*/ +"-db-"+mostCurrent._user_key+".db");
 //BA.debugLineNum = 532;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 533;BA.debugLine="result = Msgbox2(\"?????????????? ???? ???????? ???????????? ?????????? ????";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("?????????????? ???? ???????? ???????????? ?????????? ????????"),BA.ObjectToCharSequence("???? ???? ???????? "),"????????","","??????",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 534;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 536;BA.debugLine="upload_file(Starter.Provider.SharedFolder&\"/\"&Ma";
_upload_file(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ +"/"+mostCurrent._main._phon_num /*String*/ +"-db-"+mostCurrent._user_key+".db");
 };
 //BA.debugLineNum = 539;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_msg_click() throws Exception{
 //BA.debugLineNum = 503;BA.debugLine="Private Sub lbl_send_msg_Click";
 //BA.debugLineNum = 504;BA.debugLine="pan_all_msg.Visible=True";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 507;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_msg_end_click() throws Exception{
 //BA.debugLineNum = 590;BA.debugLine="Private Sub lbl_send_msg_end_Click";
 //BA.debugLineNum = 592;BA.debugLine="http_initial_1(5)";
_http_initial_1((int) (5));
 //BA.debugLineNum = 594;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_msg2_click() throws Exception{
 //BA.debugLineNum = 616;BA.debugLine="Private Sub lbl_send_msg2_Click";
 //BA.debugLineNum = 617;BA.debugLine="lbl_send_msg_Click";
_lbl_send_msg_click();
 //BA.debugLineNum = 618;BA.debugLine="pan_all_show_myMsg.Visible=False";
mostCurrent._pan_all_show_mymsg.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 619;BA.debugLine="End Sub";
return "";
}
public static void  _lbl_send_up_click() throws Exception{
ResumableSub_lbl_send_up_Click rsub = new ResumableSub_lbl_send_up_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_lbl_send_up_Click extends BA.ResumableSub {
public ResumableSub_lbl_send_up_Click(ir.taravatgroup.ezafekari2.step2_activity parent) {
this.parent = parent;
}
ir.taravatgroup.ezafekari2.step2_activity parent;
boolean _success = false;
String _dir = "";
String _filename = "";
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 546;BA.debugLine="Try";
if (true) break;

case 1:
//try
this.state = 18;
this.catchState = 17;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 17;
 //BA.debugLineNum = 547;BA.debugLine="CC.Show(\"image/*\", \"Choose image\")";
parent._cc.Show(processBA,"image/*","Choose image");
 //BA.debugLineNum = 549;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As S";
anywheresoftware.b4a.keywords.Common.WaitFor("cc_result", processBA, this, null);
this.state = 19;
return;
case 19:
//C
this.state = 4;
_success = (Boolean) result[0];
_dir = (String) result[1];
_filename = (String) result[2];
;
 //BA.debugLineNum = 550;BA.debugLine="If Success = True Then";
if (true) break;

case 4:
//if
this.state = 15;
if (_success==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 6;
}else {
this.state = 14;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 554;BA.debugLine="tempFile=Main.phon_num&\"-\"&myfunc.random_id(10)";
parent.mostCurrent._tempfile = parent.mostCurrent._main._phon_num /*String*/ +"-"+parent.mostCurrent._myfunc._random_id /*String*/ (mostCurrent.activityBA,(int) (10))+".jpg";
 //BA.debugLineNum = 556;BA.debugLine="Try";
if (true) break;

case 7:
//try
this.state = 12;
this.catchState = 11;
this.state = 9;
if (true) break;

case 9:
//C
this.state = 12;
this.catchState = 11;
 //BA.debugLineNum = 559;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"tempimg.jpg");
 //BA.debugLineNum = 560;BA.debugLine="bmp = comp.compressToBitmap(Starter.Provider.S";
parent.mostCurrent._bmp = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent._comp.compressToBitmap(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"tempimg.jpg")));
 //BA.debugLineNum = 561;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Star";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._tempfile,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 562;BA.debugLine="bmp.WriteToStream(out, 50, \"JPEG\")";
parent.mostCurrent._bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (50),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"JPEG"));
 //BA.debugLineNum = 563;BA.debugLine="out.Close";
_out.Close();
 if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 17;
 //BA.debugLineNum = 568;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._tempfile);
 //BA.debugLineNum = 571;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("415400986",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 12:
//C
this.state = 15;
this.catchState = 17;
;
 //BA.debugLineNum = 576;BA.debugLine="lbl_icon_up.Text=Chr(0xF00C)";
parent.mostCurrent._lbl_icon_up.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf00c))));
 //BA.debugLineNum = 577;BA.debugLine="lbl_icon_noUp.Visible=True";
parent.mostCurrent._lbl_icon_noup.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 14:
//C
this.state = 15;
 //BA.debugLineNum = 579;BA.debugLine="ToastMessageShow(\"?????????? ?????? :(\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("?????????? ?????? :("),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 15:
//C
this.state = 18;
;
 if (true) break;

case 17:
//C
this.state = 18;
this.catchState = 0;
 //BA.debugLineNum = 582;BA.debugLine="ToastMessageShow(\"?????? ???? ????????????????\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("?????? ???? ????????????????"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 583;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("415400998",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 587;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static String  _lbl_send_up_icon_click() throws Exception{
 //BA.debugLineNum = 601;BA.debugLine="Private Sub lbl_send_up_icon_Click";
 //BA.debugLineNum = 602;BA.debugLine="lbl_send_up_Click";
_lbl_send_up_click();
 //BA.debugLineNum = 603;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_transfer_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 495;BA.debugLine="Private Sub lbl_transfer_Click";
 //BA.debugLineNum = 496;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 497;BA.debugLine="result = Msgbox2(\"?????????????? ???????????? ???????? ?????????? ???? ????";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("?????????????? ???????????? ???????? ?????????? ???? ???????? ????????"),BA.ObjectToCharSequence("?????????????? ????????????"),"?????? ?????????????? ","","??????",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 498;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 499;BA.debugLine="http_initial_1(3)";
_http_initial_1((int) (3));
 };
 //BA.debugLineNum = 501;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_edit_click() throws Exception{
 //BA.debugLineNum = 127;BA.debugLine="Private Sub pan_all_edit_Click";
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_msg_click() throws Exception{
 //BA.debugLineNum = 541;BA.debugLine="Private Sub pan_all_msg_Click";
 //BA.debugLineNum = 542;BA.debugLine="pan_all_msg.Visible=False";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 543;BA.debugLine="End Sub";
return "";
}
public static String  _panel9_click() throws Exception{
 //BA.debugLineNum = 597;BA.debugLine="Private Sub Panel9_Click";
 //BA.debugLineNum = 599;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim comp As Compressor";
_comp = new de.donmanfred.Compressorwrapper();
 //BA.debugLineNum = 10;BA.debugLine="Dim CC As ContentChooser 'Phone Library";
_cc = new anywheresoftware.b4a.phone.Phone.ContentChooser();
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public static String  _up_sendfile(String _value) throws Exception{
 //BA.debugLineNum = 480;BA.debugLine="Sub Up_sendFile (value As String)";
 //BA.debugLineNum = 481;BA.debugLine="Log( value)";
anywheresoftware.b4a.keywords.Common.LogImpl("414876673",_value,0);
 //BA.debugLineNum = 482;BA.debugLine="End Sub";
return "";
}
public static String  _up_statusupload(String _value) throws Exception{
 //BA.debugLineNum = 484;BA.debugLine="Sub Up_statusUpload (value As String)";
 //BA.debugLineNum = 485;BA.debugLine="lbl_image_up.Text=value&\" %\"";
mostCurrent._lbl_image_up.setText(BA.ObjectToCharSequence(_value+" %"));
 //BA.debugLineNum = 488;BA.debugLine="If(value>=100)Then";
if (((double)(Double.parseDouble(_value))>=100)) { 
 //BA.debugLineNum = 489;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 //BA.debugLineNum = 490;BA.debugLine="ToastMessageShow(\" ?????????? ????\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" ?????????? ????"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 493;BA.debugLine="End Sub";
return "";
}
public static String  _upload_file(String _path) throws Exception{
 //BA.debugLineNum = 476;BA.debugLine="Sub upload_file(path As String)";
 //BA.debugLineNum = 477;BA.debugLine="Up.doFileUpload( Null,Null,path,\"https://taravatg";
mostCurrent._up.doFileUpload(processBA,(android.widget.ProgressBar)(anywheresoftware.b4a.keywords.Common.Null),(android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Null),_path,"https://taravatgroup.ir/file_up.php");
 //BA.debugLineNum = 478;BA.debugLine="End Sub";
return "";
}
public static String  _upload_img(String _path) throws Exception{
 //BA.debugLineNum = 465;BA.debugLine="Sub upload_img(path As String)";
 //BA.debugLineNum = 467;BA.debugLine="File.Copy(Starter.Provider.SharedFolder,picName,F";
anywheresoftware.b4a.keywords.Common.File.Copy(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._picname,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname);
 //BA.debugLineNum = 468;BA.debugLine="Path_Phone_Image = path";
mostCurrent._path_phone_image = _path;
 //BA.debugLineNum = 469;BA.debugLine="Up.doFileUpload( Null,Null,Path_Phone_Image,Url_P";
mostCurrent._up.doFileUpload(processBA,(android.widget.ProgressBar)(anywheresoftware.b4a.keywords.Common.Null),(android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent._path_phone_image,mostCurrent._url_php_page);
 //BA.debugLineNum = 471;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitmap(F";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 //BA.debugLineNum = 472;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitmap(";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 //BA.debugLineNum = 474;BA.debugLine="End Sub";
return "";
}
}
