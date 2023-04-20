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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.step2_activity");
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
        
        BA.LogInfo("** Activity (step2_activity) Create " + (isFirst ? "(first time)" : "") + " **");
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



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
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
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=57606144;
 //BA.debugLineNum = 57606144;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=57606152;
 //BA.debugLineNum = 57606152;BA.debugLine="If(File.Exists(File.DirInternal,\"phonNum\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum"))) { 
RDebugUtils.currentLine=57606153;
 //BA.debugLineNum = 57606153;BA.debugLine="Activity.LoadLayout(\"step2\")";
mostCurrent._activity.LoadLayout("step2",mostCurrent.activityBA);
RDebugUtils.currentLine=57606155;
 //BA.debugLineNum = 57606155;BA.debugLine="Main.phon_num=File.ReadString(File.DirInternal,\"";
mostCurrent._main._phon_num /*String*/  = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum");
RDebugUtils.currentLine=57606158;
 //BA.debugLineNum = 57606158;BA.debugLine="If(myfunc.check_karid=False)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=57606159;
 //BA.debugLineNum = 57606159;BA.debugLine="lbl_noske.Text=\"نسخه هدیه\"";
mostCurrent._lbl_noske.setText(BA.ObjectToCharSequence("نسخه هدیه"));
RDebugUtils.currentLine=57606160;
 //BA.debugLineNum = 57606160;BA.debugLine="type_app=0";
_type_app = (int) (0);
 }else {
RDebugUtils.currentLine=57606162;
 //BA.debugLineNum = 57606162;BA.debugLine="lbl_noske.Text=\"نسخه طلایی\"";
mostCurrent._lbl_noske.setText(BA.ObjectToCharSequence("نسخه طلایی"));
RDebugUtils.currentLine=57606163;
 //BA.debugLineNum = 57606163;BA.debugLine="type_app=1";
_type_app = (int) (1);
 };
RDebugUtils.currentLine=57606170;
 //BA.debugLineNum = 57606170;BA.debugLine="CC.Initialize(\"CC\")";
_cc.Initialize("CC");
RDebugUtils.currentLine=57606171;
 //BA.debugLineNum = 57606171;BA.debugLine="Url_Php_Page=\"https://taravatgroup.ir/avatar_up1";
mostCurrent._url_php_page = "https://taravatgroup.ir/avatar_up1.php";
RDebugUtils.currentLine=57606173;
 //BA.debugLineNum = 57606173;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=57606174;
 //BA.debugLineNum = 57606174;BA.debugLine="Up.B4A_log=True";
mostCurrent._up.B4A_log = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=57606175;
 //BA.debugLineNum = 57606175;BA.debugLine="Up.Initialize(\"Up\")";
mostCurrent._up.Initialize(processBA,"Up");
 };
RDebugUtils.currentLine=57606178;
 //BA.debugLineNum = 57606178;BA.debugLine="ProgressDialogShow(\"بارگذاری ...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("بارگذاری ..."));
RDebugUtils.currentLine=57606179;
 //BA.debugLineNum = 57606179;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
RDebugUtils.currentLine=57606190;
 //BA.debugLineNum = 57606190;BA.debugLine="Label12.Color=Main.color4";
mostCurrent._label12.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=57606191;
 //BA.debugLineNum = 57606191;BA.debugLine="Panel12.Color=Main.color4";
mostCurrent._panel12.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=57606192;
 //BA.debugLineNum = 57606192;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 }else {
RDebugUtils.currentLine=57606196;
 //BA.debugLineNum = 57606196;BA.debugLine="StartActivity(step0_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step0_activity.getObject()));
RDebugUtils.currentLine=57606197;
 //BA.debugLineNum = 57606197;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
RDebugUtils.currentLine=57606206;
 //BA.debugLineNum = 57606206;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "http_initial_1", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "http_initial_1", new Object[] {_type1}));}
String _send = "";
int _exist_pic = 0;
RDebugUtils.currentLine=58064896;
 //BA.debugLineNum = 58064896;BA.debugLine="Sub http_initial_1(type1 As Int)";
RDebugUtils.currentLine=58064897;
 //BA.debugLineNum = 58064897;BA.debugLine="If (myfunc.check_internet=False)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=58064898;
 //BA.debugLineNum = 58064898;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 }else {
RDebugUtils.currentLine=58064903;
 //BA.debugLineNum = 58064903;BA.debugLine="If(type1=1)Then";
if ((_type1==1)) { 
RDebugUtils.currentLine=58064905;
 //BA.debugLineNum = 58064905;BA.debugLine="http3.Initialize(\"ht1\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht1",step2_activity.getObject());
RDebugUtils.currentLine=58064906;
 //BA.debugLineNum = 58064906;BA.debugLine="Dim send As String= \"var=3&phone=\"&Main.phon_nu";
_send = "var=3&phone="+mostCurrent._main._phon_num /*String*/ +"&type_app="+BA.NumberToString(_type_app)+"&div_id="+mostCurrent._pp.GetSettings("android_id")+"&div_model="+mostCurrent._pp.getModel();
RDebugUtils.currentLine=58064907;
 //BA.debugLineNum = 58064907;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }else 
{RDebugUtils.currentLine=58064910;
 //BA.debugLineNum = 58064910;BA.debugLine="Else If(type1=2)Then ' to edit";
if ((_type1==2)) { 
RDebugUtils.currentLine=58064911;
 //BA.debugLineNum = 58064911;BA.debugLine="Dim exist_pic As Int=0";
_exist_pic = (int) (0);
RDebugUtils.currentLine=58064912;
 //BA.debugLineNum = 58064912;BA.debugLine="If(File.Exists(Starter.Provider.SharedFolder,pi";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._picname))) { 
RDebugUtils.currentLine=58064913;
 //BA.debugLineNum = 58064913;BA.debugLine="upload_img(Starter.Provider.SharedFolder&\"/\"&p";
_upload_img(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ +"/"+mostCurrent._picname);
RDebugUtils.currentLine=58064914;
 //BA.debugLineNum = 58064914;BA.debugLine="exist_pic=1";
_exist_pic = (int) (1);
 };
RDebugUtils.currentLine=58064917;
 //BA.debugLineNum = 58064917;BA.debugLine="http3.Initialize(\"ht2\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht2",step2_activity.getObject());
RDebugUtils.currentLine=58064918;
 //BA.debugLineNum = 58064918;BA.debugLine="Dim send As String=\"var=2&name=\"&et_nameFamili.";
_send = "var=2&name="+mostCurrent._et_namefamili.getText()+"&email="+mostCurrent._et_email.getText()+"&phone="+mostCurrent._main._phon_num /*String*/ +"&exist_pic="+BA.NumberToString(_exist_pic)+"&pic_name="+mostCurrent._picname;
RDebugUtils.currentLine=58064919;
 //BA.debugLineNum = 58064919;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }else 
{RDebugUtils.currentLine=58064923;
 //BA.debugLineNum = 58064923;BA.debugLine="Else If(type1=3)Then '  req transfer noskhe";
if ((_type1==3)) { 
RDebugUtils.currentLine=58064924;
 //BA.debugLineNum = 58064924;BA.debugLine="http3.Initialize(\"ht3\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht3",step2_activity.getObject());
RDebugUtils.currentLine=58064925;
 //BA.debugLineNum = 58064925;BA.debugLine="Dim send As String= \"var=4&phone=\"&Main.phon_nu";
_send = "var=4&phone="+mostCurrent._main._phon_num /*String*/ +"&name="+mostCurrent._lbl_namefamili.getText();
RDebugUtils.currentLine=58064926;
 //BA.debugLineNum = 58064926;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }else 
{RDebugUtils.currentLine=58064928;
 //BA.debugLineNum = 58064928;BA.debugLine="Else If(type1=4)Then '  req chek noskhe";
if ((_type1==4)) { 
RDebugUtils.currentLine=58064929;
 //BA.debugLineNum = 58064929;BA.debugLine="http3.Initialize(\"ht4\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht4",step2_activity.getObject());
RDebugUtils.currentLine=58064930;
 //BA.debugLineNum = 58064930;BA.debugLine="Dim send As String= \"var=5&phone=\"&Main.phon_nu";
_send = "var=5&phone="+mostCurrent._main._phon_num /*String*/ +"&name="+mostCurrent._lbl_namefamili.getText();
RDebugUtils.currentLine=58064931;
 //BA.debugLineNum = 58064931;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }else 
{RDebugUtils.currentLine=58064933;
 //BA.debugLineNum = 58064933;BA.debugLine="Else If(type1=5)Then '  send msg";
if ((_type1==5)) { 
RDebugUtils.currentLine=58064934;
 //BA.debugLineNum = 58064934;BA.debugLine="If(File.Exists(Starter.Provider.SharedFolder,te";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._tempfile))) { 
RDebugUtils.currentLine=58064935;
 //BA.debugLineNum = 58064935;BA.debugLine="upload_file(Starter.Provider.SharedFolder&\"/\"&";
_upload_file(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ +"/"+mostCurrent._tempfile);
 }else {
RDebugUtils.currentLine=58064937;
 //BA.debugLineNum = 58064937;BA.debugLine="tempFile=\"\"";
mostCurrent._tempfile = "";
 };
RDebugUtils.currentLine=58064940;
 //BA.debugLineNum = 58064940;BA.debugLine="If(et_msg.Text.Trim=\"\")Then";
if (((mostCurrent._et_msg.getText().trim()).equals(""))) { 
RDebugUtils.currentLine=58064941;
 //BA.debugLineNum = 58064941;BA.debugLine="ToastMessageShow(\"کادر پیام خالی است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("کادر پیام خالی است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=58064944;
 //BA.debugLineNum = 58064944;BA.debugLine="http3.Initialize(\"ht5\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht5",step2_activity.getObject());
RDebugUtils.currentLine=58064945;
 //BA.debugLineNum = 58064945;BA.debugLine="Dim send As String= \"var=6&phone=\"&Main.phon_n";
_send = "var=6&phone="+mostCurrent._main._phon_num /*String*/ +"&msg="+mostCurrent._et_msg.getText()+"&file_name="+mostCurrent._tempfile+"&name="+mostCurrent._lbl_namefamili.getText();
RDebugUtils.currentLine=58064946;
 //BA.debugLineNum = 58064946;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
RDebugUtils.currentLine=58064947;
 //BA.debugLineNum = 58064947;BA.debugLine="pan_all_msg.Visible=False";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }else 
{RDebugUtils.currentLine=58064953;
 //BA.debugLineNum = 58064953;BA.debugLine="Else If (type1=6) Then  ' recive pic";
if ((_type1==6)) { 
RDebugUtils.currentLine=58064954;
 //BA.debugLineNum = 58064954;BA.debugLine="http3.Initialize(\"ht7\", Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht7",step2_activity.getObject());
RDebugUtils.currentLine=58064955;
 //BA.debugLineNum = 58064955;BA.debugLine="http3.Download(\"https://taravatgroup.ir/avatar_";
mostCurrent._http3._download /*String*/ (null,"https://taravatgroup.ir/avatar_ezaf_users/"+mostCurrent._picname);
 }else 
{RDebugUtils.currentLine=58064956;
 //BA.debugLineNum = 58064956;BA.debugLine="Else If(type1=7)Then";
if ((_type1==7)) { 
RDebugUtils.currentLine=58064958;
 //BA.debugLineNum = 58064958;BA.debugLine="http3.Initialize(\"ht8\", Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht8",step2_activity.getObject());
RDebugUtils.currentLine=58064960;
 //BA.debugLineNum = 58064960;BA.debugLine="Dim send As String= \"var=1&phone=\"&Main.phon_nu";
_send = "var=1&phone="+mostCurrent._main._phon_num /*String*/ +"&key=mME22eBbA20aDd1401";
RDebugUtils.currentLine=58064961;
 //BA.debugLineNum = 58064961;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/user_";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/user_msg.php",_send);
 }else 
{RDebugUtils.currentLine=58064964;
 //BA.debugLineNum = 58064964;BA.debugLine="Else If(type1=8)Then";
if ((_type1==8)) { 
RDebugUtils.currentLine=58064966;
 //BA.debugLineNum = 58064966;BA.debugLine="http3.Initialize(\"ht9\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht9",step2_activity.getObject());
RDebugUtils.currentLine=58064967;
 //BA.debugLineNum = 58064967;BA.debugLine="Dim send As String= \"var=7&phone=\"&Main.phon_nu";
_send = "var=7&phone="+mostCurrent._main._phon_num /*String*/ +"&div_id="+mostCurrent._pp.GetSettings("android_id");
RDebugUtils.currentLine=58064968;
 //BA.debugLineNum = 58064968;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }}}}}}}}
;
 };
RDebugUtils.currentLine=58064975;
 //BA.debugLineNum = 58064975;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=58261504;
 //BA.debugLineNum = 58261504;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=58261505;
 //BA.debugLineNum = 58261505;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=58261506;
 //BA.debugLineNum = 58261506;BA.debugLine="If(pan_all_edit.Visible=True)Then";
if ((mostCurrent._pan_all_edit.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=58261507;
 //BA.debugLineNum = 58261507;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 }else 
{RDebugUtils.currentLine=58261508;
 //BA.debugLineNum = 58261508;BA.debugLine="Else If(pan_all_msg.Visible=True)Then";
if ((mostCurrent._pan_all_msg.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=58261509;
 //BA.debugLineNum = 58261509;BA.debugLine="pan_all_msg.Visible=False";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=58261510;
 //BA.debugLineNum = 58261510;BA.debugLine="Else If(pan_all_show_myMsg.Visible=True)Then";
if ((mostCurrent._pan_all_show_mymsg.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=58261511;
 //BA.debugLineNum = 58261511;BA.debugLine="lbl_back_Shmsg_Click";
_lbl_back_shmsg_click();
 }else {
RDebugUtils.currentLine=58261513;
 //BA.debugLineNum = 58261513;BA.debugLine="lbl_back_home_Click";
_lbl_back_home_click();
 }}}
;
RDebugUtils.currentLine=58261516;
 //BA.debugLineNum = 58261516;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=58261518;
 //BA.debugLineNum = 58261518;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=58261520;
 //BA.debugLineNum = 58261520;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=57933824;
 //BA.debugLineNum = 57933824;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=57933825;
 //BA.debugLineNum = 57933825;BA.debugLine="pan_all_edit.Visible=False";
mostCurrent._pan_all_edit.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=57933826;
 //BA.debugLineNum = 57933826;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_shmsg_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_shmsg_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_shmsg_click", null));}
RDebugUtils.currentLine=59441152;
 //BA.debugLineNum = 59441152;BA.debugLine="Private Sub lbl_back_Shmsg_Click";
RDebugUtils.currentLine=59441153;
 //BA.debugLineNum = 59441153;BA.debugLine="pan_all_show_myMsg.Visible=False";
mostCurrent._pan_all_show_mymsg.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=59441154;
 //BA.debugLineNum = 59441154;BA.debugLine="Main.msg_page_show=0";
mostCurrent._main._msg_page_show /*int*/  = (int) (0);
RDebugUtils.currentLine=59441155;
 //BA.debugLineNum = 59441155;BA.debugLine="http_initial_1(8)";
_http_initial_1((int) (8));
RDebugUtils.currentLine=59441156;
 //BA.debugLineNum = 59441156;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_home_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_home_click", null));}
RDebugUtils.currentLine=58327040;
 //BA.debugLineNum = 58327040;BA.debugLine="Private Sub lbl_back_home_Click";
RDebugUtils.currentLine=58327041;
 //BA.debugLineNum = 58327041;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=58327042;
 //BA.debugLineNum = 58327042;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=58327043;
 //BA.debugLineNum = 58327043;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="step2_activity";
RDebugUtils.currentLine=57737216;
 //BA.debugLineNum = 57737216;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=57737218;
 //BA.debugLineNum = 57737218;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=57671680;
 //BA.debugLineNum = 57671680;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=57671682;
 //BA.debugLineNum = 57671682;BA.debugLine="End Sub";
return "";
}
public static String  _upload_img(String _path) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "upload_img", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "upload_img", new Object[] {_path}));}
RDebugUtils.currentLine=58458112;
 //BA.debugLineNum = 58458112;BA.debugLine="Sub upload_img(path As String)";
RDebugUtils.currentLine=58458114;
 //BA.debugLineNum = 58458114;BA.debugLine="File.Copy(Starter.Provider.SharedFolder,picName,F";
anywheresoftware.b4a.keywords.Common.File.Copy(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._picname,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname);
RDebugUtils.currentLine=58458115;
 //BA.debugLineNum = 58458115;BA.debugLine="Path_Phone_Image = path";
mostCurrent._path_phone_image = _path;
RDebugUtils.currentLine=58458116;
 //BA.debugLineNum = 58458116;BA.debugLine="Up.doFileUpload( Null,Null,Path_Phone_Image,Url_P";
mostCurrent._up.doFileUpload(processBA,(android.widget.ProgressBar)(anywheresoftware.b4a.keywords.Common.Null),(android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent._path_phone_image,mostCurrent._url_php_page);
RDebugUtils.currentLine=58458118;
 //BA.debugLineNum = 58458118;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitmap(F";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
RDebugUtils.currentLine=58458119;
 //BA.debugLineNum = 58458119;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitmap(";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
RDebugUtils.currentLine=58458121;
 //BA.debugLineNum = 58458121;BA.debugLine="End Sub";
return "";
}
public static String  _upload_file(String _path) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "upload_file", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "upload_file", new Object[] {_path}));}
RDebugUtils.currentLine=58523648;
 //BA.debugLineNum = 58523648;BA.debugLine="Sub upload_file(path As String)";
RDebugUtils.currentLine=58523649;
 //BA.debugLineNum = 58523649;BA.debugLine="ProgressDialogShow(\"بارگیری...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("بارگیری..."));
RDebugUtils.currentLine=58523650;
 //BA.debugLineNum = 58523650;BA.debugLine="Up.doFileUpload( Null,Null,path,\"https://taravatg";
mostCurrent._up.doFileUpload(processBA,(android.widget.ProgressBar)(anywheresoftware.b4a.keywords.Common.Null),(android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Null),_path,"https://taravatgroup.ir/file_up.php");
RDebugUtils.currentLine=58523651;
 //BA.debugLineNum = 58523651;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(ir.taravatgroup.ezafekari2.httpjob _job) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
String[] _a = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
anywheresoftware.b4a.objects.collections.List _ls_user = null;
RDebugUtils.currentLine=58130432;
 //BA.debugLineNum = 58130432;BA.debugLine="Sub Jobdone (job As HttpJob)";
RDebugUtils.currentLine=58130433;
 //BA.debugLineNum = 58130433;BA.debugLine="Try";
try {RDebugUtils.currentLine=58130435;
 //BA.debugLineNum = 58130435;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=58130437;
 //BA.debugLineNum = 58130437;BA.debugLine="If job.JobName=\"ht1\" Then";
if ((_job._jobname /*String*/ ).equals("ht1")) { 
RDebugUtils.currentLine=58130438;
 //BA.debugLineNum = 58130438;BA.debugLine="If(job.GetString.Contains(\"nouser\"))Then";
if ((_job._getstring /*String*/ (null).contains("nouser"))) { 
RDebugUtils.currentLine=58130440;
 //BA.debugLineNum = 58130440;BA.debugLine="File.Delete(File.DirInternal,\"userAcc\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
RDebugUtils.currentLine=58130441;
 //BA.debugLineNum = 58130441;BA.debugLine="StartActivity(step0_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step0_activity.getObject()));
RDebugUtils.currentLine=58130442;
 //BA.debugLineNum = 58130442;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 }else {
RDebugUtils.currentLine=58130445;
 //BA.debugLineNum = 58130445;BA.debugLine="Dim a() As String";
_a = new String[(int) (0)];
java.util.Arrays.fill(_a,"");
RDebugUtils.currentLine=58130446;
 //BA.debugLineNum = 58130446;BA.debugLine="a=Regex.Split(\"&\",job.GetString)";
_a = anywheresoftware.b4a.keywords.Common.Regex.Split("&",_job._getstring /*String*/ (null));
RDebugUtils.currentLine=58130448;
 //BA.debugLineNum = 58130448;BA.debugLine="lbl_nameFamili.Text=a(0)";
mostCurrent._lbl_namefamili.setText(BA.ObjectToCharSequence(_a[(int) (0)]));
RDebugUtils.currentLine=58130449;
 //BA.debugLineNum = 58130449;BA.debugLine="lbl_email.Text=a(1)";
mostCurrent._lbl_email.setText(BA.ObjectToCharSequence(_a[(int) (1)]));
RDebugUtils.currentLine=58130457;
 //BA.debugLineNum = 58130457;BA.debugLine="lbl_phoneNum.Text=a(2)";
mostCurrent._lbl_phonenum.setText(BA.ObjectToCharSequence(_a[(int) (2)]));
RDebugUtils.currentLine=58130459;
 //BA.debugLineNum = 58130459;BA.debugLine="user_key=a(4)";
mostCurrent._user_key = _a[(int) (4)];
RDebugUtils.currentLine=58130461;
 //BA.debugLineNum = 58130461;BA.debugLine="picName=\"user-\"&Main.phon_num&\"-\"&a(4)&\".jpg\"";
mostCurrent._picname = "user-"+mostCurrent._main._phon_num /*String*/ +"-"+_a[(int) (4)]+".jpg";
RDebugUtils.currentLine=58130462;
 //BA.debugLineNum = 58130462;BA.debugLine="If(File.Exists(File.DirInternal,picName)=Fals";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=58130463;
 //BA.debugLineNum = 58130463;BA.debugLine="If(a(3)=\"1\")Then";
if (((_a[(int) (3)]).equals("1"))) { 
RDebugUtils.currentLine=58130464;
 //BA.debugLineNum = 58130464;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=58130465;
 //BA.debugLineNum = 58130465;BA.debugLine="http_initial_1(6)";
_http_initial_1((int) (6));
 };
 }else {
RDebugUtils.currentLine=58130468;
 //BA.debugLineNum = 58130468;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBit";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
RDebugUtils.currentLine=58130469;
 //BA.debugLineNum = 58130469;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBi";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 };
RDebugUtils.currentLine=58130473;
 //BA.debugLineNum = 58130473;BA.debugLine="File.WriteList(File.DirInternal,\"userAcc\",a)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc",anywheresoftware.b4a.keywords.Common.ArrayToList(_a));
RDebugUtils.currentLine=58130475;
 //BA.debugLineNum = 58130475;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=58130477;
 //BA.debugLineNum = 58130477;BA.debugLine="If(Main.msg_page_show=1)Then";
if ((mostCurrent._main._msg_page_show /*int*/ ==1)) { 
RDebugUtils.currentLine=58130478;
 //BA.debugLineNum = 58130478;BA.debugLine="lbl_all_msg_Click";
_lbl_all_msg_click();
 };
 };
 }else 
{RDebugUtils.currentLine=58130484;
 //BA.debugLineNum = 58130484;BA.debugLine="else If job.JobName=\"ht2\" Then";
if ((_job._jobname /*String*/ ).equals("ht2")) { 
RDebugUtils.currentLine=58130485;
 //BA.debugLineNum = 58130485;BA.debugLine="If(job.GetString.Contains(\"true\"))Then";
if ((_job._getstring /*String*/ (null).contains("true"))) { 
RDebugUtils.currentLine=58130486;
 //BA.debugLineNum = 58130486;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=58130487;
 //BA.debugLineNum = 58130487;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
RDebugUtils.currentLine=58130488;
 //BA.debugLineNum = 58130488;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 }else 
{RDebugUtils.currentLine=58130491;
 //BA.debugLineNum = 58130491;BA.debugLine="else If job.JobName=\"ht3\" Then  '  req transfer";
if ((_job._jobname /*String*/ ).equals("ht3")) { 
RDebugUtils.currentLine=58130493;
 //BA.debugLineNum = 58130493;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
if ((_job._getstring /*String*/ (null).contains("ok_add"))) { 
RDebugUtils.currentLine=58130494;
 //BA.debugLineNum = 58130494;BA.debugLine="MsgboxAsync(\"درخواست شما با موفقیت ثبت گردید";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("درخواست شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر "),BA.ObjectToCharSequence("پیام"),processBA);
 }else {
RDebugUtils.currentLine=58130496;
 //BA.debugLineNum = 58130496;BA.debugLine="MsgboxAsync(\"خطا در ارسال درخواست، دوباره امت";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("خطا در ارسال درخواست، دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 };
 }else 
{RDebugUtils.currentLine=58130499;
 //BA.debugLineNum = 58130499;BA.debugLine="else If job.JobName=\"ht4\" Then '  req chek nosk";
if ((_job._jobname /*String*/ ).equals("ht4")) { 
RDebugUtils.currentLine=58130501;
 //BA.debugLineNum = 58130501;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
if ((_job._getstring /*String*/ (null).contains("ok_add"))) { 
RDebugUtils.currentLine=58130502;
 //BA.debugLineNum = 58130502;BA.debugLine="MsgboxAsync(\"درخواست شما با موفقیت ثبت گردید";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("درخواست شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر "),BA.ObjectToCharSequence("پیام"),processBA);
 }else {
RDebugUtils.currentLine=58130504;
 //BA.debugLineNum = 58130504;BA.debugLine="MsgboxAsync(\"خطا در ارسال درخواست، دوباره امت";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("خطا در ارسال درخواست، دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 };
 }else 
{RDebugUtils.currentLine=58130507;
 //BA.debugLineNum = 58130507;BA.debugLine="else If job.JobName=\"ht5\" Then  '  send msg";
if ((_job._jobname /*String*/ ).equals("ht5")) { 
RDebugUtils.currentLine=58130509;
 //BA.debugLineNum = 58130509;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
if ((_job._getstring /*String*/ (null).contains("ok_add"))) { 
RDebugUtils.currentLine=58130510;
 //BA.debugLineNum = 58130510;BA.debugLine="MsgboxAsync(\"پیغام شما با موفقیت ثبت گردید ون";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("پیغام شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر "),BA.ObjectToCharSequence("پیام"),processBA);
 }else {
RDebugUtils.currentLine=58130513;
 //BA.debugLineNum = 58130513;BA.debugLine="MsgboxAsync(\"خطا در ارسال پیغام، دوباره امتحا";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("خطا در ارسال پیغام، دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 };
 }else 
{RDebugUtils.currentLine=58130516;
 //BA.debugLineNum = 58130516;BA.debugLine="else If job.JobName=\"ht6\" Then  '  recive db";
if ((_job._jobname /*String*/ ).equals("ht6")) { 
RDebugUtils.currentLine=58130519;
 //BA.debugLineNum = 58130519;BA.debugLine="Dim out As OutputStream = File.OpenOutput(File";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=58130520;
 //BA.debugLineNum = 58130520;BA.debugLine="File.Copy2(http3.GetInputStream, out)";
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(mostCurrent._http3._getinputstream /*anywheresoftware.b4a.objects.streams.File.InputStreamWrapper*/ (null).getObject()),(java.io.OutputStream)(_out.getObject()));
RDebugUtils.currentLine=58130521;
 //BA.debugLineNum = 58130521;BA.debugLine="out.Close";
_out.Close();
RDebugUtils.currentLine=58130522;
 //BA.debugLineNum = 58130522;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=58130523;
 //BA.debugLineNum = 58130523;BA.debugLine="myfunc.help_man(\"تبریک\",\"اطلاعات بازگردانده شد";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"تبریک","اطلاعات بازگردانده شد ، برای اعمال تغییرات یک بار از برنامه خارج و دوباره وارد شوید.");
RDebugUtils.currentLine=58130524;
 //BA.debugLineNum = 58130524;BA.debugLine="ToastMessageShow(\"اطلاعات بازگردانده شد\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اطلاعات بازگردانده شد"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=58130529;
 //BA.debugLineNum = 58130529;BA.debugLine="else If job.JobName=\"ht7\" Then  '  recive pic";
if ((_job._jobname /*String*/ ).equals("ht7")) { 
RDebugUtils.currentLine=58130533;
 //BA.debugLineNum = 58130533;BA.debugLine="Dim bmp As Bitmap = job.GetBitmap";
mostCurrent._bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
mostCurrent._bmp = _job._getbitmap /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (null);
RDebugUtils.currentLine=58130534;
 //BA.debugLineNum = 58130534;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=58130535;
 //BA.debugLineNum = 58130535;BA.debugLine="out = File.OpenOutput(File.DirInternal,picName";
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=58130536;
 //BA.debugLineNum = 58130536;BA.debugLine="bmp.WriteToStream(out, 100, \"JPEG\")";
mostCurrent._bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (100),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"JPEG"));
RDebugUtils.currentLine=58130537;
 //BA.debugLineNum = 58130537;BA.debugLine="out.Close";
_out.Close();
RDebugUtils.currentLine=58130541;
 //BA.debugLineNum = 58130541;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitma";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
RDebugUtils.currentLine=58130542;
 //BA.debugLineNum = 58130542;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitm";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 }else 
{RDebugUtils.currentLine=58130544;
 //BA.debugLineNum = 58130544;BA.debugLine="else If job.JobName=\"ht8\" Then  '  recive my ms";
if ((_job._jobname /*String*/ ).equals("ht8")) { 
RDebugUtils.currentLine=58130546;
 //BA.debugLineNum = 58130546;BA.debugLine="wb_show_myMsg.LoadHtml(job.GetString)";
mostCurrent._wb_show_mymsg.LoadHtml(_job._getstring /*String*/ (null));
 }else 
{RDebugUtils.currentLine=58130550;
 //BA.debugLineNum = 58130550;BA.debugLine="else If job.JobName=\"ht9\" Then  '  i see";
if ((_job._jobname /*String*/ ).equals("ht9")) { 
RDebugUtils.currentLine=58130551;
 //BA.debugLineNum = 58130551;BA.debugLine="Log(job.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("258130551",_job._getstring /*String*/ (null),0);
 }}}}}}}}}
;
RDebugUtils.currentLine=58130553;
 //BA.debugLineNum = 58130553;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=58130554;
 //BA.debugLineNum = 58130554;BA.debugLine="job.Release";
_job._release /*String*/ (null);
 }else {
RDebugUtils.currentLine=58130558;
 //BA.debugLineNum = 58130558;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\")=True";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=58130560;
 //BA.debugLineNum = 58130560;BA.debugLine="Dim ls_user As List";
_ls_user = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=58130561;
 //BA.debugLineNum = 58130561;BA.debugLine="ls_user.Initialize";
_ls_user.Initialize();
RDebugUtils.currentLine=58130562;
 //BA.debugLineNum = 58130562;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAc";
_ls_user = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
RDebugUtils.currentLine=58130564;
 //BA.debugLineNum = 58130564;BA.debugLine="lbl_nameFamili.Text=ls_user.Get(0)";
mostCurrent._lbl_namefamili.setText(BA.ObjectToCharSequence(_ls_user.Get((int) (0))));
RDebugUtils.currentLine=58130565;
 //BA.debugLineNum = 58130565;BA.debugLine="lbl_email.Text=ls_user.Get(1)";
mostCurrent._lbl_email.setText(BA.ObjectToCharSequence(_ls_user.Get((int) (1))));
RDebugUtils.currentLine=58130572;
 //BA.debugLineNum = 58130572;BA.debugLine="Main.phon_num=ls_user.Get(2)";
mostCurrent._main._phon_num /*String*/  = BA.ObjectToString(_ls_user.Get((int) (2)));
RDebugUtils.currentLine=58130573;
 //BA.debugLineNum = 58130573;BA.debugLine="lbl_phoneNum.Text=Main.phon_num";
mostCurrent._lbl_phonenum.setText(BA.ObjectToCharSequence(mostCurrent._main._phon_num /*String*/ ));
RDebugUtils.currentLine=58130575;
 //BA.debugLineNum = 58130575;BA.debugLine="picName=\"user-\"&Main.phon_num&\"-\"&ls_user.Get(";
mostCurrent._picname = "user-"+mostCurrent._main._phon_num /*String*/ +"-"+BA.ObjectToString(_ls_user.Get((int) (4)))+".jpg";
RDebugUtils.currentLine=58130577;
 //BA.debugLineNum = 58130577;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitma";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
RDebugUtils.currentLine=58130578;
 //BA.debugLineNum = 58130578;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitm";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 };
 };
 } 
       catch (Exception e92) {
			processBA.setLastException(e92);RDebugUtils.currentLine=58130586;
 //BA.debugLineNum = 58130586;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("258130586",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=58130587;
 //BA.debugLineNum = 58130587;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=58130590;
 //BA.debugLineNum = 58130590;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_all_msg_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_all_msg_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_all_msg_click", null));}
RDebugUtils.currentLine=59375616;
 //BA.debugLineNum = 59375616;BA.debugLine="Private Sub lbl_all_msg_Click";
RDebugUtils.currentLine=59375617;
 //BA.debugLineNum = 59375617;BA.debugLine="ProgressDialogShow(\"بارگذاری ...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("بارگذاری ..."));
RDebugUtils.currentLine=59375618;
 //BA.debugLineNum = 59375618;BA.debugLine="http_initial_1(7)";
_http_initial_1((int) (7));
RDebugUtils.currentLine=59375619;
 //BA.debugLineNum = 59375619;BA.debugLine="pan_all_show_myMsg.Visible=True";
mostCurrent._pan_all_show_mymsg.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=59375622;
 //BA.debugLineNum = 59375622;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chek_noskhe_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_chek_noskhe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_chek_noskhe_click", null));}
int _result = 0;
RDebugUtils.currentLine=58851328;
 //BA.debugLineNum = 58851328;BA.debugLine="Private Sub lbl_chek_noskhe_Click";
RDebugUtils.currentLine=58851329;
 //BA.debugLineNum = 58851329;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=58851330;
 //BA.debugLineNum = 58851330;BA.debugLine="result = Msgbox2(\"قبلا خرید کرده ام بررسی کنید\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("قبلا خرید کرده ام بررسی کنید"),BA.ObjectToCharSequence("درخواست بررسی"),"ثبت درخواست ","","لغو",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=58851331;
 //BA.debugLineNum = 58851331;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=58851332;
 //BA.debugLineNum = 58851332;BA.debugLine="http_initial_1(4)";
_http_initial_1((int) (4));
 };
RDebugUtils.currentLine=58851334;
 //BA.debugLineNum = 58851334;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_click", null));}
RDebugUtils.currentLine=58195968;
 //BA.debugLineNum = 58195968;BA.debugLine="Private Sub lbl_edit_Click";
RDebugUtils.currentLine=58195971;
 //BA.debugLineNum = 58195971;BA.debugLine="et_nameFamili.Text=	lbl_nameFamili.Text";
mostCurrent._et_namefamili.setText(BA.ObjectToCharSequence(mostCurrent._lbl_namefamili.getText()));
RDebugUtils.currentLine=58195972;
 //BA.debugLineNum = 58195972;BA.debugLine="et_email.Text=lbl_email.Text";
mostCurrent._et_email.setText(BA.ObjectToCharSequence(mostCurrent._lbl_email.getText()));
RDebugUtils.currentLine=58195973;
 //BA.debugLineNum = 58195973;BA.debugLine="comp.Initialize(\"Compressor\")";
_comp.Initialize(processBA,"Compressor");
RDebugUtils.currentLine=58195974;
 //BA.debugLineNum = 58195974;BA.debugLine="comp.Quality=30";
_comp.setQuality((int) (30));
RDebugUtils.currentLine=58195975;
 //BA.debugLineNum = 58195975;BA.debugLine="lbl_image_up.Text=Chr(0xF0EE)";
mostCurrent._lbl_image_up.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf0ee))));
RDebugUtils.currentLine=58195976;
 //BA.debugLineNum = 58195976;BA.debugLine="pan_all_edit.Visible=True";
mostCurrent._pan_all_edit.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=58195981;
 //BA.debugLineNum = 58195981;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_icon_noup_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_icon_noup_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_icon_noup_click", null));}
RDebugUtils.currentLine=59572224;
 //BA.debugLineNum = 59572224;BA.debugLine="Private Sub lbl_icon_noUp_Click";
RDebugUtils.currentLine=59572226;
 //BA.debugLineNum = 59572226;BA.debugLine="File.Delete(Starter.Provider.SharedFolder, tempFil";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._tempfile);
RDebugUtils.currentLine=59572228;
 //BA.debugLineNum = 59572228;BA.debugLine="lbl_icon_up.Text=\"\"";
mostCurrent._lbl_icon_up.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=59572229;
 //BA.debugLineNum = 59572229;BA.debugLine="lbl_icon_noUp.Visible=False";
mostCurrent._lbl_icon_noup.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=59572230;
 //BA.debugLineNum = 59572230;BA.debugLine="End Sub";
return "";
}
public static void  _lbl_image_up_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_image_up_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "lbl_image_up_click", null); return;}
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
RDebugUtils.currentModule="step2_activity";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=58392577;
 //BA.debugLineNum = 58392577;BA.debugLine="Try";
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
RDebugUtils.currentLine=58392578;
 //BA.debugLineNum = 58392578;BA.debugLine="CC.Show(\"image/*\", \"Choose image\")";
parent._cc.Show(processBA,"image/*","Choose image");
RDebugUtils.currentLine=58392580;
 //BA.debugLineNum = 58392580;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As S";
anywheresoftware.b4a.keywords.Common.WaitFor("cc_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "step2_activity", "lbl_image_up_click"), null);
this.state = 19;
return;
case 19:
//C
this.state = 4;
_success = (Boolean) result[0];
_dir = (String) result[1];
_filename = (String) result[2];
;
RDebugUtils.currentLine=58392581;
 //BA.debugLineNum = 58392581;BA.debugLine="If Success = True Then";
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
RDebugUtils.currentLine=58392583;
 //BA.debugLineNum = 58392583;BA.debugLine="Try";
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
RDebugUtils.currentLine=58392584;
 //BA.debugLineNum = 58392584;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"temp_pic.jpg");
RDebugUtils.currentLine=58392585;
 //BA.debugLineNum = 58392585;BA.debugLine="bmp = comp.compressToBitmap(Starter.Provider.S";
parent.mostCurrent._bmp = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent._comp.compressToBitmap(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"temp_pic.jpg")));
RDebugUtils.currentLine=58392586;
 //BA.debugLineNum = 58392586;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Star";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._picname,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=58392587;
 //BA.debugLineNum = 58392587;BA.debugLine="bmp.WriteToStream(out, 20, \"JPEG\")";
parent.mostCurrent._bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (20),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"JPEG"));
RDebugUtils.currentLine=58392588;
 //BA.debugLineNum = 58392588;BA.debugLine="out.Close";
_out.Close();
 if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 17;
RDebugUtils.currentLine=58392591;
 //BA.debugLineNum = 58392591;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._picname);
RDebugUtils.currentLine=58392592;
 //BA.debugLineNum = 58392592;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("258392592",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 12:
//C
this.state = 15;
this.catchState = 17;
;
RDebugUtils.currentLine=58392595;
 //BA.debugLineNum = 58392595;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitma";
parent.mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(parent.mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._picname)).getObject()));
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=58392598;
 //BA.debugLineNum = 58392598;BA.debugLine="ToastMessageShow(\"انجام نشد :(\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("انجام نشد :("),anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=58392602;
 //BA.debugLineNum = 58392602;BA.debugLine="ToastMessageShow(\"خطا در بارگزاری\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در بارگزاری"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=58392603;
 //BA.debugLineNum = 58392603;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("258392603",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=58392606;
 //BA.debugLineNum = 58392606;BA.debugLine="End Sub";
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
public static String  _lbl_logoff_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_logoff_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_logoff_click", null));}
int _result = 0;
RDebugUtils.currentLine=57999360;
 //BA.debugLineNum = 57999360;BA.debugLine="Private Sub lbl_logOff_Click";
RDebugUtils.currentLine=57999361;
 //BA.debugLineNum = 57999361;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=57999362;
 //BA.debugLineNum = 57999362;BA.debugLine="result = Msgbox2(\"آیا از حساب خود خارج می شوید؟\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا از حساب خود خارج می شوید؟"),BA.ObjectToCharSequence("توجه"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=57999363;
 //BA.debugLineNum = 57999363;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=57999364;
 //BA.debugLineNum = 57999364;BA.debugLine="File.Delete(File.DirInternal,\"userAcc\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
RDebugUtils.currentLine=57999366;
 //BA.debugLineNum = 57999366;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=57999367;
 //BA.debugLineNum = 57999367;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
RDebugUtils.currentLine=57999373;
 //BA.debugLineNum = 57999373;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_reseve_db_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_reseve_db_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_reseve_db_click", null));}
int _result = 0;
RDebugUtils.currentLine=58916864;
 //BA.debugLineNum = 58916864;BA.debugLine="Private Sub lbl_reseve_db_Click";
RDebugUtils.currentLine=58916865;
 //BA.debugLineNum = 58916865;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=58916866;
 //BA.debugLineNum = 58916866;BA.debugLine="result = Msgbox2(\"اطلاعات من از سرور بازیابی شوند";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("اطلاعات من از سرور بازیابی شوند.توجه داشته باشید اطلاعات قبلی حذف می شوند"),BA.ObjectToCharSequence("بازگرداندن اطلاعات "),"مطمئن هستم","","لغو",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=58916867;
 //BA.debugLineNum = 58916867;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=58916868;
 //BA.debugLineNum = 58916868;BA.debugLine="ProgressDialogShow(\"در حال دریافت ...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("در حال دریافت ..."));
RDebugUtils.currentLine=58916869;
 //BA.debugLineNum = 58916869;BA.debugLine="http3.Initialize(\"ht6\", Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht6",step2_activity.getObject());
RDebugUtils.currentLine=58916870;
 //BA.debugLineNum = 58916870;BA.debugLine="http3.Download(\"https://taravatgroup.ir/uploads_";
mostCurrent._http3._download /*String*/ (null,"https://taravatgroup.ir/uploads_ezaf/"+mostCurrent._main._phon_num /*String*/ +"-db-"+mostCurrent._user_key+".db");
 };
RDebugUtils.currentLine=58916873;
 //BA.debugLineNum = 58916873;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_edit_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_edit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_edit_click", null));}
RDebugUtils.currentLine=57868288;
 //BA.debugLineNum = 57868288;BA.debugLine="Private Sub lbl_save_edit_Click";
RDebugUtils.currentLine=57868289;
 //BA.debugLineNum = 57868289;BA.debugLine="If (myfunc.check_internet=False)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=57868290;
 //BA.debugLineNum = 57868290;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 }else 
{RDebugUtils.currentLine=57868291;
 //BA.debugLineNum = 57868291;BA.debugLine="else If(et_nameFamili.Text=\"\")Then";
if (((mostCurrent._et_namefamili.getText()).equals(""))) { 
RDebugUtils.currentLine=57868292;
 //BA.debugLineNum = 57868292;BA.debugLine="ToastMessageShow(\"قسمت نام خالی است \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("قسمت نام خالی است "),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=57868293;
 //BA.debugLineNum = 57868293;BA.debugLine="Else If(et_email.Text=\"\")Then";
if (((mostCurrent._et_email.getText()).equals(""))) { 
RDebugUtils.currentLine=57868295;
 //BA.debugLineNum = 57868295;BA.debugLine="ToastMessageShow(\"قسمت ایمیل خالی است \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("قسمت ایمیل خالی است "),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=57868296;
 //BA.debugLineNum = 57868296;BA.debugLine="Else If(myfunc.Validate_Email(et_email.Text)=Fals";
if ((mostCurrent._myfunc._validate_email /*boolean*/ (mostCurrent.activityBA,mostCurrent._et_email.getText())==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=57868298;
 //BA.debugLineNum = 57868298;BA.debugLine="ToastMessageShow(\" ایمیل نامعتبر است \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" ایمیل نامعتبر است "),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=57868300;
 //BA.debugLineNum = 57868300;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
 }}}}
;
RDebugUtils.currentLine=57868304;
 //BA.debugLineNum = 57868304;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_db_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_send_db_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_send_db_click", null));}
int _result = 0;
RDebugUtils.currentLine=58982400;
 //BA.debugLineNum = 58982400;BA.debugLine="Private Sub lbl_send_db_Click";
RDebugUtils.currentLine=58982402;
 //BA.debugLineNum = 58982402;BA.debugLine="File.Copy(File.DirInternal,\"db.db\",Starter.Provid";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._main._phon_num /*String*/ +"-db-"+mostCurrent._user_key+".db");
RDebugUtils.currentLine=58982404;
 //BA.debugLineNum = 58982404;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=58982405;
 //BA.debugLineNum = 58982405;BA.debugLine="result = Msgbox2(\"اطلاعات در سرور آنلاین ذخیره شو";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("اطلاعات در سرور آنلاین ذخیره شود؟"),BA.ObjectToCharSequence("بک آپ گیری "),"باشه","","لغو",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=58982406;
 //BA.debugLineNum = 58982406;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=58982408;
 //BA.debugLineNum = 58982408;BA.debugLine="upload_file(Starter.Provider.SharedFolder&\"/\"&Ma";
_upload_file(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ +"/"+mostCurrent._main._phon_num /*String*/ +"-db-"+mostCurrent._user_key+".db");
 };
RDebugUtils.currentLine=58982411;
 //BA.debugLineNum = 58982411;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_msg_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_send_msg_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_send_msg_click", null));}
RDebugUtils.currentLine=58785792;
 //BA.debugLineNum = 58785792;BA.debugLine="Private Sub lbl_send_msg_Click";
RDebugUtils.currentLine=58785793;
 //BA.debugLineNum = 58785793;BA.debugLine="pan_all_msg.Visible=True";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=58785796;
 //BA.debugLineNum = 58785796;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_msg_end_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_send_msg_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_send_msg_end_click", null));}
RDebugUtils.currentLine=59179008;
 //BA.debugLineNum = 59179008;BA.debugLine="Private Sub lbl_send_msg_end_Click";
RDebugUtils.currentLine=59179010;
 //BA.debugLineNum = 59179010;BA.debugLine="http_initial_1(5)";
_http_initial_1((int) (5));
RDebugUtils.currentLine=59179012;
 //BA.debugLineNum = 59179012;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_msg2_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_send_msg2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_send_msg2_click", null));}
RDebugUtils.currentLine=59506688;
 //BA.debugLineNum = 59506688;BA.debugLine="Private Sub lbl_send_msg2_Click";
RDebugUtils.currentLine=59506689;
 //BA.debugLineNum = 59506689;BA.debugLine="lbl_send_msg_Click";
_lbl_send_msg_click();
RDebugUtils.currentLine=59506690;
 //BA.debugLineNum = 59506690;BA.debugLine="lbl_back_Shmsg_Click";
_lbl_back_shmsg_click();
RDebugUtils.currentLine=59506691;
 //BA.debugLineNum = 59506691;BA.debugLine="End Sub";
return "";
}
public static void  _lbl_send_up_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_send_up_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "lbl_send_up_click", null); return;}
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
RDebugUtils.currentModule="step2_activity";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=59113473;
 //BA.debugLineNum = 59113473;BA.debugLine="Try";
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
RDebugUtils.currentLine=59113474;
 //BA.debugLineNum = 59113474;BA.debugLine="CC.Show(\"image/*\", \"Choose image\")";
parent._cc.Show(processBA,"image/*","Choose image");
RDebugUtils.currentLine=59113476;
 //BA.debugLineNum = 59113476;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As S";
anywheresoftware.b4a.keywords.Common.WaitFor("cc_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "step2_activity", "lbl_send_up_click"), null);
this.state = 19;
return;
case 19:
//C
this.state = 4;
_success = (Boolean) result[0];
_dir = (String) result[1];
_filename = (String) result[2];
;
RDebugUtils.currentLine=59113477;
 //BA.debugLineNum = 59113477;BA.debugLine="If Success = True Then";
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
RDebugUtils.currentLine=59113481;
 //BA.debugLineNum = 59113481;BA.debugLine="tempFile=Main.phon_num&\"-\"&myfunc.random_id(10)";
parent.mostCurrent._tempfile = parent.mostCurrent._main._phon_num /*String*/ +"-"+parent.mostCurrent._myfunc._random_id /*String*/ (mostCurrent.activityBA,(int) (10))+".jpg";
RDebugUtils.currentLine=59113483;
 //BA.debugLineNum = 59113483;BA.debugLine="Try";
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
RDebugUtils.currentLine=59113486;
 //BA.debugLineNum = 59113486;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"tempimg.jpg");
RDebugUtils.currentLine=59113487;
 //BA.debugLineNum = 59113487;BA.debugLine="bmp = comp.compressToBitmap(Starter.Provider.S";
parent.mostCurrent._bmp = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent._comp.compressToBitmap(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"tempimg.jpg")));
RDebugUtils.currentLine=59113488;
 //BA.debugLineNum = 59113488;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Star";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._tempfile,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=59113489;
 //BA.debugLineNum = 59113489;BA.debugLine="bmp.WriteToStream(out, 50, \"JPEG\")";
parent.mostCurrent._bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (50),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"JPEG"));
RDebugUtils.currentLine=59113490;
 //BA.debugLineNum = 59113490;BA.debugLine="out.Close";
_out.Close();
 if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 17;
RDebugUtils.currentLine=59113495;
 //BA.debugLineNum = 59113495;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._tempfile);
RDebugUtils.currentLine=59113498;
 //BA.debugLineNum = 59113498;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("259113498",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 12:
//C
this.state = 15;
this.catchState = 17;
;
RDebugUtils.currentLine=59113503;
 //BA.debugLineNum = 59113503;BA.debugLine="lbl_icon_up.Text=Chr(0xF00C)";
parent.mostCurrent._lbl_icon_up.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf00c))));
RDebugUtils.currentLine=59113504;
 //BA.debugLineNum = 59113504;BA.debugLine="lbl_icon_noUp.Visible=True";
parent.mostCurrent._lbl_icon_noup.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=59113506;
 //BA.debugLineNum = 59113506;BA.debugLine="ToastMessageShow(\"انجام نشد :(\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("انجام نشد :("),anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=59113509;
 //BA.debugLineNum = 59113509;BA.debugLine="ToastMessageShow(\"خطا در بارگزاری\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در بارگزاری"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=59113510;
 //BA.debugLineNum = 59113510;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("259113510",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=59113514;
 //BA.debugLineNum = 59113514;BA.debugLine="End Sub";
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
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_send_up_icon_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_send_up_icon_click", null));}
RDebugUtils.currentLine=59310080;
 //BA.debugLineNum = 59310080;BA.debugLine="Private Sub lbl_send_up_icon_Click";
RDebugUtils.currentLine=59310081;
 //BA.debugLineNum = 59310081;BA.debugLine="lbl_send_up_Click";
_lbl_send_up_click();
RDebugUtils.currentLine=59310082;
 //BA.debugLineNum = 59310082;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_transfer_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_transfer_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_transfer_click", null));}
int _result = 0;
RDebugUtils.currentLine=58720256;
 //BA.debugLineNum = 58720256;BA.debugLine="Private Sub lbl_transfer_Click";
RDebugUtils.currentLine=58720257;
 //BA.debugLineNum = 58720257;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=58720258;
 //BA.debugLineNum = 58720258;BA.debugLine="result = Msgbox2(\"درخواست انتقال نسخه طلایی به گو";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("درخواست انتقال نسخه طلایی به گوشی جدید"),BA.ObjectToCharSequence("درخواست انتقال"),"ثبت درخواست ","","لغو",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=58720259;
 //BA.debugLineNum = 58720259;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=58720260;
 //BA.debugLineNum = 58720260;BA.debugLine="http_initial_1(3)";
_http_initial_1((int) (3));
 };
RDebugUtils.currentLine=58720262;
 //BA.debugLineNum = 58720262;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_edit_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_edit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_edit_click", null));}
RDebugUtils.currentLine=57802752;
 //BA.debugLineNum = 57802752;BA.debugLine="Private Sub pan_all_edit_Click";
RDebugUtils.currentLine=57802754;
 //BA.debugLineNum = 57802754;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_msg_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_msg_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_msg_click", null));}
RDebugUtils.currentLine=59047936;
 //BA.debugLineNum = 59047936;BA.debugLine="Private Sub pan_all_msg_Click";
RDebugUtils.currentLine=59047937;
 //BA.debugLineNum = 59047937;BA.debugLine="pan_all_msg.Visible=False";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=59047938;
 //BA.debugLineNum = 59047938;BA.debugLine="End Sub";
return "";
}
public static String  _panel9_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel9_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel9_click", null));}
RDebugUtils.currentLine=59244544;
 //BA.debugLineNum = 59244544;BA.debugLine="Private Sub Panel9_Click";
RDebugUtils.currentLine=59244546;
 //BA.debugLineNum = 59244546;BA.debugLine="End Sub";
return "";
}
public static String  _up_sendfile(String _value) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "up_sendfile", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "up_sendfile", new Object[] {_value}));}
RDebugUtils.currentLine=58589184;
 //BA.debugLineNum = 58589184;BA.debugLine="Sub Up_sendFile (value As String)";
RDebugUtils.currentLine=58589185;
 //BA.debugLineNum = 58589185;BA.debugLine="Log( value)";
anywheresoftware.b4a.keywords.Common.LogImpl("258589185",_value,0);
RDebugUtils.currentLine=58589186;
 //BA.debugLineNum = 58589186;BA.debugLine="End Sub";
return "";
}
public static String  _up_statusupload(String _value) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "up_statusupload", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "up_statusupload", new Object[] {_value}));}
RDebugUtils.currentLine=58654720;
 //BA.debugLineNum = 58654720;BA.debugLine="Sub Up_statusUpload (value As String)";
RDebugUtils.currentLine=58654721;
 //BA.debugLineNum = 58654721;BA.debugLine="lbl_image_up.Text=value&\" %\"";
mostCurrent._lbl_image_up.setText(BA.ObjectToCharSequence(_value+" %"));
RDebugUtils.currentLine=58654724;
 //BA.debugLineNum = 58654724;BA.debugLine="If(value>=100)Then";
if (((double)(Double.parseDouble(_value))>=100)) { 
RDebugUtils.currentLine=58654725;
 //BA.debugLineNum = 58654725;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=58654726;
 //BA.debugLineNum = 58654726;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=58654727;
 //BA.debugLineNum = 58654727;BA.debugLine="ToastMessageShow(\" ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=58654730;
 //BA.debugLineNum = 58654730;BA.debugLine="End Sub";
return "";
}
}