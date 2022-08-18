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
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
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
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=13959168;
 //BA.debugLineNum = 13959168;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=13959170;
 //BA.debugLineNum = 13959170;BA.debugLine="Activity.LoadLayout(\"step2\")";
mostCurrent._activity.LoadLayout("step2",mostCurrent.activityBA);
RDebugUtils.currentLine=13959176;
 //BA.debugLineNum = 13959176;BA.debugLine="If(File.Exists(File.DirInternal,\"phonNum\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum"))) { 
RDebugUtils.currentLine=13959177;
 //BA.debugLineNum = 13959177;BA.debugLine="Main.phon_num=File.ReadString(File.DirInternal,\"";
mostCurrent._main._phon_num /*String*/  = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum");
RDebugUtils.currentLine=13959180;
 //BA.debugLineNum = 13959180;BA.debugLine="If(myfunc.check_karid=False)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=13959181;
 //BA.debugLineNum = 13959181;BA.debugLine="lbl_noske.Text=\"نسخه هدیه\"";
mostCurrent._lbl_noske.setText(BA.ObjectToCharSequence("نسخه هدیه"));
RDebugUtils.currentLine=13959182;
 //BA.debugLineNum = 13959182;BA.debugLine="type_app=0";
_type_app = (int) (0);
 }else {
RDebugUtils.currentLine=13959184;
 //BA.debugLineNum = 13959184;BA.debugLine="lbl_noske.Text=\"نسخه طلایی\"";
mostCurrent._lbl_noske.setText(BA.ObjectToCharSequence("نسخه طلایی"));
RDebugUtils.currentLine=13959185;
 //BA.debugLineNum = 13959185;BA.debugLine="type_app=1";
_type_app = (int) (1);
 };
RDebugUtils.currentLine=13959192;
 //BA.debugLineNum = 13959192;BA.debugLine="CC.Initialize(\"CC\")";
_cc.Initialize("CC");
RDebugUtils.currentLine=13959193;
 //BA.debugLineNum = 13959193;BA.debugLine="Url_Php_Page=\"https://taravatgroup.ir/avatar_up1";
mostCurrent._url_php_page = "https://taravatgroup.ir/avatar_up1.php";
RDebugUtils.currentLine=13959195;
 //BA.debugLineNum = 13959195;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=13959196;
 //BA.debugLineNum = 13959196;BA.debugLine="Up.B4A_log=True";
mostCurrent._up.B4A_log = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=13959197;
 //BA.debugLineNum = 13959197;BA.debugLine="Up.Initialize(\"Up\")";
mostCurrent._up.Initialize(processBA,"Up");
 };
RDebugUtils.currentLine=13959201;
 //BA.debugLineNum = 13959201;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
 }else {
RDebugUtils.currentLine=13959216;
 //BA.debugLineNum = 13959216;BA.debugLine="StartActivity(step0_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step0_activity.getObject()));
RDebugUtils.currentLine=13959217;
 //BA.debugLineNum = 13959217;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
RDebugUtils.currentLine=13959222;
 //BA.debugLineNum = 13959222;BA.debugLine="Label12.Color=Main.color4";
mostCurrent._label12.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=13959223;
 //BA.debugLineNum = 13959223;BA.debugLine="Panel12.Color=Main.color4";
mostCurrent._panel12.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=13959224;
 //BA.debugLineNum = 13959224;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=13959227;
 //BA.debugLineNum = 13959227;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "http_initial_1", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "http_initial_1", new Object[] {_type1}));}
String _send = "";
int _exist_pic = 0;
RDebugUtils.currentLine=14417920;
 //BA.debugLineNum = 14417920;BA.debugLine="Sub http_initial_1(type1 As Int)";
RDebugUtils.currentLine=14417921;
 //BA.debugLineNum = 14417921;BA.debugLine="If (myfunc.check_internet=False)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=14417922;
 //BA.debugLineNum = 14417922;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 }else {
RDebugUtils.currentLine=14417927;
 //BA.debugLineNum = 14417927;BA.debugLine="If(type1=1)Then";
if ((_type1==1)) { 
RDebugUtils.currentLine=14417929;
 //BA.debugLineNum = 14417929;BA.debugLine="http3.Initialize(\"ht1\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht1",step2_activity.getObject());
RDebugUtils.currentLine=14417930;
 //BA.debugLineNum = 14417930;BA.debugLine="Dim send As String= \"var=3&phone=\"&Main.phon_nu";
_send = "var=3&phone="+mostCurrent._main._phon_num /*String*/ +"&type_app="+BA.NumberToString(_type_app)+"&div_id="+mostCurrent._pp.GetSettings("android_id")+"&div_model="+mostCurrent._pp.getModel();
RDebugUtils.currentLine=14417931;
 //BA.debugLineNum = 14417931;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }else 
{RDebugUtils.currentLine=14417932;
 //BA.debugLineNum = 14417932;BA.debugLine="Else If(type1=2)Then ' to edit";
if ((_type1==2)) { 
RDebugUtils.currentLine=14417933;
 //BA.debugLineNum = 14417933;BA.debugLine="Dim exist_pic As Int=0";
_exist_pic = (int) (0);
RDebugUtils.currentLine=14417934;
 //BA.debugLineNum = 14417934;BA.debugLine="If(File.Exists(Starter.Provider.SharedFolder,pi";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._picname))) { 
RDebugUtils.currentLine=14417935;
 //BA.debugLineNum = 14417935;BA.debugLine="upload_img(Starter.Provider.SharedFolder&\"/\"&p";
_upload_img(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ +"/"+mostCurrent._picname);
RDebugUtils.currentLine=14417936;
 //BA.debugLineNum = 14417936;BA.debugLine="exist_pic=1";
_exist_pic = (int) (1);
 };
RDebugUtils.currentLine=14417939;
 //BA.debugLineNum = 14417939;BA.debugLine="http3.Initialize(\"ht2\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht2",step2_activity.getObject());
RDebugUtils.currentLine=14417940;
 //BA.debugLineNum = 14417940;BA.debugLine="Dim send As String=\"var=2&name=\"&et_nameFamili.";
_send = "var=2&name="+mostCurrent._et_namefamili.getText()+"&email="+mostCurrent._et_email.getText()+"&phone="+mostCurrent._main._phon_num /*String*/ +"&exist_pic="+BA.NumberToString(_exist_pic)+"&pic_name="+mostCurrent._picname;
RDebugUtils.currentLine=14417941;
 //BA.debugLineNum = 14417941;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }else 
{RDebugUtils.currentLine=14417945;
 //BA.debugLineNum = 14417945;BA.debugLine="Else If(type1=3)Then '  req transfer noskhe";
if ((_type1==3)) { 
RDebugUtils.currentLine=14417946;
 //BA.debugLineNum = 14417946;BA.debugLine="http3.Initialize(\"ht3\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht3",step2_activity.getObject());
RDebugUtils.currentLine=14417947;
 //BA.debugLineNum = 14417947;BA.debugLine="Dim send As String= \"var=4&phone=\"&Main.phon_nu";
_send = "var=4&phone="+mostCurrent._main._phon_num /*String*/ +"&name="+mostCurrent._lbl_namefamili.getText();
RDebugUtils.currentLine=14417948;
 //BA.debugLineNum = 14417948;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }else 
{RDebugUtils.currentLine=14417950;
 //BA.debugLineNum = 14417950;BA.debugLine="Else If(type1=4)Then '  req chek noskhe";
if ((_type1==4)) { 
RDebugUtils.currentLine=14417951;
 //BA.debugLineNum = 14417951;BA.debugLine="http3.Initialize(\"ht4\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht4",step2_activity.getObject());
RDebugUtils.currentLine=14417952;
 //BA.debugLineNum = 14417952;BA.debugLine="Dim send As String= \"var=5&phone=\"&Main.phon_nu";
_send = "var=5&phone="+mostCurrent._main._phon_num /*String*/ +"&name="+mostCurrent._lbl_namefamili.getText();
RDebugUtils.currentLine=14417953;
 //BA.debugLineNum = 14417953;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }else 
{RDebugUtils.currentLine=14417955;
 //BA.debugLineNum = 14417955;BA.debugLine="Else If(type1=5)Then '  send msg";
if ((_type1==5)) { 
RDebugUtils.currentLine=14417956;
 //BA.debugLineNum = 14417956;BA.debugLine="If(File.Exists(Starter.Provider.SharedFolder,te";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._tempfile))) { 
RDebugUtils.currentLine=14417957;
 //BA.debugLineNum = 14417957;BA.debugLine="upload_file(Starter.Provider.SharedFolder&\"/\"&";
_upload_file(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ +"/"+mostCurrent._tempfile);
 }else {
RDebugUtils.currentLine=14417959;
 //BA.debugLineNum = 14417959;BA.debugLine="tempFile=\"\"";
mostCurrent._tempfile = "";
 };
RDebugUtils.currentLine=14417962;
 //BA.debugLineNum = 14417962;BA.debugLine="If(et_msg.Text.Trim=\"\")Then";
if (((mostCurrent._et_msg.getText().trim()).equals(""))) { 
RDebugUtils.currentLine=14417963;
 //BA.debugLineNum = 14417963;BA.debugLine="ToastMessageShow(\"کادر پیام خالی است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("کادر پیام خالی است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=14417966;
 //BA.debugLineNum = 14417966;BA.debugLine="http3.Initialize(\"ht5\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht5",step2_activity.getObject());
RDebugUtils.currentLine=14417967;
 //BA.debugLineNum = 14417967;BA.debugLine="Dim send As String= \"var=6&phone=\"&Main.phon_n";
_send = "var=6&phone="+mostCurrent._main._phon_num /*String*/ +"&msg="+mostCurrent._et_msg.getText()+"&file_name="+mostCurrent._tempfile+"&name="+mostCurrent._lbl_namefamili.getText();
RDebugUtils.currentLine=14417968;
 //BA.debugLineNum = 14417968;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
RDebugUtils.currentLine=14417969;
 //BA.debugLineNum = 14417969;BA.debugLine="pan_all_msg.Visible=False";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }else 
{RDebugUtils.currentLine=14417975;
 //BA.debugLineNum = 14417975;BA.debugLine="Else If (type1=6) Then  ' recive pic";
if ((_type1==6)) { 
RDebugUtils.currentLine=14417976;
 //BA.debugLineNum = 14417976;BA.debugLine="http3.Initialize(\"ht7\", Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht7",step2_activity.getObject());
RDebugUtils.currentLine=14417977;
 //BA.debugLineNum = 14417977;BA.debugLine="http3.Download(\"https://taravatgroup.ir/avatar_";
mostCurrent._http3._download /*String*/ (null,"https://taravatgroup.ir/avatar_ezaf_users/"+mostCurrent._picname);
 }else 
{RDebugUtils.currentLine=14417978;
 //BA.debugLineNum = 14417978;BA.debugLine="Else If(type1=7)Then";
if ((_type1==7)) { 
RDebugUtils.currentLine=14417980;
 //BA.debugLineNum = 14417980;BA.debugLine="http3.Initialize(\"ht8\", Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht8",step2_activity.getObject());
RDebugUtils.currentLine=14417982;
 //BA.debugLineNum = 14417982;BA.debugLine="Dim send As String= \"var=1&phone=\"&Main.phon_nu";
_send = "var=1&phone="+mostCurrent._main._phon_num /*String*/ +"&key=mME22eBbA20aDd1401";
RDebugUtils.currentLine=14417983;
 //BA.debugLineNum = 14417983;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/user_";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/user_msg.php",_send);
 }}}}}}}
;
 };
RDebugUtils.currentLine=14417988;
 //BA.debugLineNum = 14417988;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=14614528;
 //BA.debugLineNum = 14614528;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=14614529;
 //BA.debugLineNum = 14614529;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=14614530;
 //BA.debugLineNum = 14614530;BA.debugLine="If(pan_all_edit.Visible=True)Then";
if ((mostCurrent._pan_all_edit.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=14614531;
 //BA.debugLineNum = 14614531;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 }else 
{RDebugUtils.currentLine=14614532;
 //BA.debugLineNum = 14614532;BA.debugLine="Else If(pan_all_msg.Visible=True)Then";
if ((mostCurrent._pan_all_msg.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=14614533;
 //BA.debugLineNum = 14614533;BA.debugLine="pan_all_msg.Visible=False";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=14614534;
 //BA.debugLineNum = 14614534;BA.debugLine="Else If(pan_all_show_myMsg.Visible=True)Then";
if ((mostCurrent._pan_all_show_mymsg.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=14614535;
 //BA.debugLineNum = 14614535;BA.debugLine="pan_all_show_myMsg.Visible=False";
mostCurrent._pan_all_show_mymsg.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=14614537;
 //BA.debugLineNum = 14614537;BA.debugLine="lbl_back_home_Click";
_lbl_back_home_click();
 }}}
;
RDebugUtils.currentLine=14614540;
 //BA.debugLineNum = 14614540;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=14614542;
 //BA.debugLineNum = 14614542;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=14614544;
 //BA.debugLineNum = 14614544;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=14286848;
 //BA.debugLineNum = 14286848;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=14286849;
 //BA.debugLineNum = 14286849;BA.debugLine="pan_all_edit.Visible=False";
mostCurrent._pan_all_edit.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=14286850;
 //BA.debugLineNum = 14286850;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_home_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_home_click", null));}
RDebugUtils.currentLine=14680064;
 //BA.debugLineNum = 14680064;BA.debugLine="Private Sub lbl_back_home_Click";
RDebugUtils.currentLine=14680065;
 //BA.debugLineNum = 14680065;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=14680066;
 //BA.debugLineNum = 14680066;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=14680067;
 //BA.debugLineNum = 14680067;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="step2_activity";
RDebugUtils.currentLine=14090240;
 //BA.debugLineNum = 14090240;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=14090242;
 //BA.debugLineNum = 14090242;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=14024704;
 //BA.debugLineNum = 14024704;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=14024706;
 //BA.debugLineNum = 14024706;BA.debugLine="End Sub";
return "";
}
public static String  _upload_img(String _path) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "upload_img", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "upload_img", new Object[] {_path}));}
RDebugUtils.currentLine=14811136;
 //BA.debugLineNum = 14811136;BA.debugLine="Sub upload_img(path As String)";
RDebugUtils.currentLine=14811138;
 //BA.debugLineNum = 14811138;BA.debugLine="File.Copy(Starter.Provider.SharedFolder,picName,F";
anywheresoftware.b4a.keywords.Common.File.Copy(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._picname,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname);
RDebugUtils.currentLine=14811139;
 //BA.debugLineNum = 14811139;BA.debugLine="Path_Phone_Image = path";
mostCurrent._path_phone_image = _path;
RDebugUtils.currentLine=14811140;
 //BA.debugLineNum = 14811140;BA.debugLine="Up.doFileUpload( Null,Null,Path_Phone_Image,Url_P";
mostCurrent._up.doFileUpload(processBA,(android.widget.ProgressBar)(anywheresoftware.b4a.keywords.Common.Null),(android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent._path_phone_image,mostCurrent._url_php_page);
RDebugUtils.currentLine=14811142;
 //BA.debugLineNum = 14811142;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitmap(F";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
RDebugUtils.currentLine=14811143;
 //BA.debugLineNum = 14811143;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitmap(";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
RDebugUtils.currentLine=14811145;
 //BA.debugLineNum = 14811145;BA.debugLine="End Sub";
return "";
}
public static String  _upload_file(String _path) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "upload_file", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "upload_file", new Object[] {_path}));}
RDebugUtils.currentLine=14876672;
 //BA.debugLineNum = 14876672;BA.debugLine="Sub upload_file(path As String)";
RDebugUtils.currentLine=14876673;
 //BA.debugLineNum = 14876673;BA.debugLine="Up.doFileUpload( Null,Null,path,\"https://taravatg";
mostCurrent._up.doFileUpload(processBA,(android.widget.ProgressBar)(anywheresoftware.b4a.keywords.Common.Null),(android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Null),_path,"https://taravatgroup.ir/file_up.php");
RDebugUtils.currentLine=14876674;
 //BA.debugLineNum = 14876674;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(ir.taravatgroup.ezafekari2.httpjob _job) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
String[] _a = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
anywheresoftware.b4a.objects.collections.List _ls_user = null;
RDebugUtils.currentLine=14483456;
 //BA.debugLineNum = 14483456;BA.debugLine="Sub Jobdone (job As HttpJob)";
RDebugUtils.currentLine=14483457;
 //BA.debugLineNum = 14483457;BA.debugLine="Try";
try {RDebugUtils.currentLine=14483459;
 //BA.debugLineNum = 14483459;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=14483461;
 //BA.debugLineNum = 14483461;BA.debugLine="If job.JobName=\"ht1\" Then";
if ((_job._jobname /*String*/ ).equals("ht1")) { 
RDebugUtils.currentLine=14483462;
 //BA.debugLineNum = 14483462;BA.debugLine="If(job.GetString.Contains(\"nouser\"))Then";
if ((_job._getstring /*String*/ (null).contains("nouser"))) { 
RDebugUtils.currentLine=14483464;
 //BA.debugLineNum = 14483464;BA.debugLine="File.Delete(File.DirInternal,\"userAcc\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
RDebugUtils.currentLine=14483465;
 //BA.debugLineNum = 14483465;BA.debugLine="StartActivity(step0_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step0_activity.getObject()));
RDebugUtils.currentLine=14483466;
 //BA.debugLineNum = 14483466;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 }else {
RDebugUtils.currentLine=14483469;
 //BA.debugLineNum = 14483469;BA.debugLine="Dim a() As String";
_a = new String[(int) (0)];
java.util.Arrays.fill(_a,"");
RDebugUtils.currentLine=14483470;
 //BA.debugLineNum = 14483470;BA.debugLine="a=Regex.Split(\"&\",job.GetString)";
_a = anywheresoftware.b4a.keywords.Common.Regex.Split("&",_job._getstring /*String*/ (null));
RDebugUtils.currentLine=14483472;
 //BA.debugLineNum = 14483472;BA.debugLine="lbl_nameFamili.Text=a(0)";
mostCurrent._lbl_namefamili.setText(BA.ObjectToCharSequence(_a[(int) (0)]));
RDebugUtils.currentLine=14483473;
 //BA.debugLineNum = 14483473;BA.debugLine="lbl_email.Text=a(1)";
mostCurrent._lbl_email.setText(BA.ObjectToCharSequence(_a[(int) (1)]));
RDebugUtils.currentLine=14483481;
 //BA.debugLineNum = 14483481;BA.debugLine="lbl_phoneNum.Text=a(2)";
mostCurrent._lbl_phonenum.setText(BA.ObjectToCharSequence(_a[(int) (2)]));
RDebugUtils.currentLine=14483483;
 //BA.debugLineNum = 14483483;BA.debugLine="user_key=a(4)";
mostCurrent._user_key = _a[(int) (4)];
RDebugUtils.currentLine=14483485;
 //BA.debugLineNum = 14483485;BA.debugLine="picName=\"user-\"&Main.phon_num&\"-\"&a(4)&\".jpg\"";
mostCurrent._picname = "user-"+mostCurrent._main._phon_num /*String*/ +"-"+_a[(int) (4)]+".jpg";
RDebugUtils.currentLine=14483486;
 //BA.debugLineNum = 14483486;BA.debugLine="If(File.Exists(File.DirInternal,picName)=Fals";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=14483487;
 //BA.debugLineNum = 14483487;BA.debugLine="If(a(3)=\"1\")Then";
if (((_a[(int) (3)]).equals("1"))) { 
RDebugUtils.currentLine=14483488;
 //BA.debugLineNum = 14483488;BA.debugLine="http_initial_1(6)";
_http_initial_1((int) (6));
 };
 }else {
RDebugUtils.currentLine=14483491;
 //BA.debugLineNum = 14483491;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBit";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
RDebugUtils.currentLine=14483492;
 //BA.debugLineNum = 14483492;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBi";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 };
RDebugUtils.currentLine=14483496;
 //BA.debugLineNum = 14483496;BA.debugLine="File.WriteList(File.DirInternal,\"userAcc\",a)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc",anywheresoftware.b4a.keywords.Common.ArrayToList(_a));
 };
 }else 
{RDebugUtils.currentLine=14483501;
 //BA.debugLineNum = 14483501;BA.debugLine="else If job.JobName=\"ht2\" Then";
if ((_job._jobname /*String*/ ).equals("ht2")) { 
RDebugUtils.currentLine=14483502;
 //BA.debugLineNum = 14483502;BA.debugLine="If(job.GetString.Contains(\"true\"))Then";
if ((_job._getstring /*String*/ (null).contains("true"))) { 
RDebugUtils.currentLine=14483503;
 //BA.debugLineNum = 14483503;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
 };
 }else 
{RDebugUtils.currentLine=14483506;
 //BA.debugLineNum = 14483506;BA.debugLine="else If job.JobName=\"ht3\" Then  '  req transfer";
if ((_job._jobname /*String*/ ).equals("ht3")) { 
RDebugUtils.currentLine=14483508;
 //BA.debugLineNum = 14483508;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
if ((_job._getstring /*String*/ (null).contains("ok_add"))) { 
RDebugUtils.currentLine=14483509;
 //BA.debugLineNum = 14483509;BA.debugLine="MsgboxAsync(\"درخواست شما با موفقیت ثبت گردید";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("درخواست شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر "),BA.ObjectToCharSequence("پیام"),processBA);
 }else {
RDebugUtils.currentLine=14483511;
 //BA.debugLineNum = 14483511;BA.debugLine="MsgboxAsync(\"خطا در ارسال درخواست، دوباره امت";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("خطا در ارسال درخواست، دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 };
 }else 
{RDebugUtils.currentLine=14483514;
 //BA.debugLineNum = 14483514;BA.debugLine="else If job.JobName=\"ht4\" Then '  req chek nosk";
if ((_job._jobname /*String*/ ).equals("ht4")) { 
RDebugUtils.currentLine=14483516;
 //BA.debugLineNum = 14483516;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
if ((_job._getstring /*String*/ (null).contains("ok_add"))) { 
RDebugUtils.currentLine=14483517;
 //BA.debugLineNum = 14483517;BA.debugLine="MsgboxAsync(\"درخواست شما با موفقیت ثبت گردید";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("درخواست شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر "),BA.ObjectToCharSequence("پیام"),processBA);
 }else {
RDebugUtils.currentLine=14483519;
 //BA.debugLineNum = 14483519;BA.debugLine="MsgboxAsync(\"خطا در ارسال درخواست، دوباره امت";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("خطا در ارسال درخواست، دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 };
 }else 
{RDebugUtils.currentLine=14483522;
 //BA.debugLineNum = 14483522;BA.debugLine="else If job.JobName=\"ht5\" Then  '  send msg";
if ((_job._jobname /*String*/ ).equals("ht5")) { 
RDebugUtils.currentLine=14483524;
 //BA.debugLineNum = 14483524;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
if ((_job._getstring /*String*/ (null).contains("ok_add"))) { 
RDebugUtils.currentLine=14483525;
 //BA.debugLineNum = 14483525;BA.debugLine="MsgboxAsync(\"پیغام شما با موفقیت ثبت گردید ون";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("پیغام شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر "),BA.ObjectToCharSequence("پیام"),processBA);
 }else {
RDebugUtils.currentLine=14483528;
 //BA.debugLineNum = 14483528;BA.debugLine="MsgboxAsync(\"خطا در ارسال پیغام، دوباره امتحا";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("خطا در ارسال پیغام، دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 };
 }else 
{RDebugUtils.currentLine=14483531;
 //BA.debugLineNum = 14483531;BA.debugLine="else If job.JobName=\"ht6\" Then  '  recive db";
if ((_job._jobname /*String*/ ).equals("ht6")) { 
RDebugUtils.currentLine=14483534;
 //BA.debugLineNum = 14483534;BA.debugLine="Dim out As OutputStream = File.OpenOutput(File";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=14483535;
 //BA.debugLineNum = 14483535;BA.debugLine="File.Copy2(http3.GetInputStream, out)";
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(mostCurrent._http3._getinputstream /*anywheresoftware.b4a.objects.streams.File.InputStreamWrapper*/ (null).getObject()),(java.io.OutputStream)(_out.getObject()));
RDebugUtils.currentLine=14483536;
 //BA.debugLineNum = 14483536;BA.debugLine="out.Close";
_out.Close();
RDebugUtils.currentLine=14483537;
 //BA.debugLineNum = 14483537;BA.debugLine="ToastMessageShow(\"اطلاعات بازگردانده شد\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اطلاعات بازگردانده شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=14483539;
 //BA.debugLineNum = 14483539;BA.debugLine="lbl_back_home_Click";
_lbl_back_home_click();
 }else 
{RDebugUtils.currentLine=14483542;
 //BA.debugLineNum = 14483542;BA.debugLine="else If job.JobName=\"ht7\" Then  '  recive pic";
if ((_job._jobname /*String*/ ).equals("ht7")) { 
RDebugUtils.currentLine=14483546;
 //BA.debugLineNum = 14483546;BA.debugLine="Dim bmp As Bitmap = job.GetBitmap";
mostCurrent._bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
mostCurrent._bmp = _job._getbitmap /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (null);
RDebugUtils.currentLine=14483547;
 //BA.debugLineNum = 14483547;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=14483548;
 //BA.debugLineNum = 14483548;BA.debugLine="out = File.OpenOutput(File.DirInternal,picName";
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=14483549;
 //BA.debugLineNum = 14483549;BA.debugLine="bmp.WriteToStream(out, 100, \"JPEG\")";
mostCurrent._bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (100),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"JPEG"));
RDebugUtils.currentLine=14483550;
 //BA.debugLineNum = 14483550;BA.debugLine="out.Close";
_out.Close();
RDebugUtils.currentLine=14483554;
 //BA.debugLineNum = 14483554;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitma";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
RDebugUtils.currentLine=14483555;
 //BA.debugLineNum = 14483555;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitm";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 }else 
{RDebugUtils.currentLine=14483557;
 //BA.debugLineNum = 14483557;BA.debugLine="else If job.JobName=\"ht8\" Then  '  recive my ms";
if ((_job._jobname /*String*/ ).equals("ht8")) { 
RDebugUtils.currentLine=14483559;
 //BA.debugLineNum = 14483559;BA.debugLine="wb_show_myMsg.LoadHtml(job.GetString)";
mostCurrent._wb_show_mymsg.LoadHtml(_job._getstring /*String*/ (null));
 }}}}}}}}
;
RDebugUtils.currentLine=14483564;
 //BA.debugLineNum = 14483564;BA.debugLine="job.Release";
_job._release /*String*/ (null);
 }else {
RDebugUtils.currentLine=14483568;
 //BA.debugLineNum = 14483568;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\")=True";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=14483570;
 //BA.debugLineNum = 14483570;BA.debugLine="Dim ls_user As List";
_ls_user = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=14483571;
 //BA.debugLineNum = 14483571;BA.debugLine="ls_user.Initialize";
_ls_user.Initialize();
RDebugUtils.currentLine=14483572;
 //BA.debugLineNum = 14483572;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAc";
_ls_user = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
RDebugUtils.currentLine=14483574;
 //BA.debugLineNum = 14483574;BA.debugLine="lbl_nameFamili.Text=ls_user.Get(0)";
mostCurrent._lbl_namefamili.setText(BA.ObjectToCharSequence(_ls_user.Get((int) (0))));
RDebugUtils.currentLine=14483575;
 //BA.debugLineNum = 14483575;BA.debugLine="lbl_email.Text=ls_user.Get(1)";
mostCurrent._lbl_email.setText(BA.ObjectToCharSequence(_ls_user.Get((int) (1))));
RDebugUtils.currentLine=14483582;
 //BA.debugLineNum = 14483582;BA.debugLine="Main.phon_num=ls_user.Get(2)";
mostCurrent._main._phon_num /*String*/  = BA.ObjectToString(_ls_user.Get((int) (2)));
RDebugUtils.currentLine=14483583;
 //BA.debugLineNum = 14483583;BA.debugLine="lbl_phoneNum.Text=Main.phon_num";
mostCurrent._lbl_phonenum.setText(BA.ObjectToCharSequence(mostCurrent._main._phon_num /*String*/ ));
RDebugUtils.currentLine=14483585;
 //BA.debugLineNum = 14483585;BA.debugLine="picName=\"user-\"&Main.phon_num&\"-\"&ls_user.Get(";
mostCurrent._picname = "user-"+mostCurrent._main._phon_num /*String*/ +"-"+BA.ObjectToString(_ls_user.Get((int) (4)))+".jpg";
RDebugUtils.currentLine=14483587;
 //BA.debugLineNum = 14483587;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitma";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
RDebugUtils.currentLine=14483588;
 //BA.debugLineNum = 14483588;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitm";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 };
 };
 } 
       catch (Exception e81) {
			processBA.setLastException(e81);RDebugUtils.currentLine=14483596;
 //BA.debugLineNum = 14483596;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("614483596",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=14483597;
 //BA.debugLineNum = 14483597;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=14483600;
 //BA.debugLineNum = 14483600;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_all_msg_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_all_msg_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_all_msg_click", null));}
RDebugUtils.currentLine=15728640;
 //BA.debugLineNum = 15728640;BA.debugLine="Private Sub lbl_all_msg_Click";
RDebugUtils.currentLine=15728641;
 //BA.debugLineNum = 15728641;BA.debugLine="http_initial_1(7)";
_http_initial_1((int) (7));
RDebugUtils.currentLine=15728642;
 //BA.debugLineNum = 15728642;BA.debugLine="pan_all_show_myMsg.Visible=True";
mostCurrent._pan_all_show_mymsg.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=15728645;
 //BA.debugLineNum = 15728645;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_shmsg_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_shmsg_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_shmsg_click", null));}
RDebugUtils.currentLine=15794176;
 //BA.debugLineNum = 15794176;BA.debugLine="Private Sub lbl_back_Shmsg_Click";
RDebugUtils.currentLine=15794177;
 //BA.debugLineNum = 15794177;BA.debugLine="pan_all_show_myMsg.Visible=False";
mostCurrent._pan_all_show_mymsg.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=15794178;
 //BA.debugLineNum = 15794178;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chek_noskhe_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_chek_noskhe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_chek_noskhe_click", null));}
int _result = 0;
RDebugUtils.currentLine=15204352;
 //BA.debugLineNum = 15204352;BA.debugLine="Private Sub lbl_chek_noskhe_Click";
RDebugUtils.currentLine=15204353;
 //BA.debugLineNum = 15204353;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=15204354;
 //BA.debugLineNum = 15204354;BA.debugLine="result = Msgbox2(\"قبلا خرید کرده ام بررسی کنید\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("قبلا خرید کرده ام بررسی کنید"),BA.ObjectToCharSequence("درخواست بررسی"),"ثبت درخواست ","","لغو",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=15204355;
 //BA.debugLineNum = 15204355;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=15204356;
 //BA.debugLineNum = 15204356;BA.debugLine="http_initial_1(4)";
_http_initial_1((int) (4));
 };
RDebugUtils.currentLine=15204358;
 //BA.debugLineNum = 15204358;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_click", null));}
RDebugUtils.currentLine=14548992;
 //BA.debugLineNum = 14548992;BA.debugLine="Private Sub lbl_edit_Click";
RDebugUtils.currentLine=14548995;
 //BA.debugLineNum = 14548995;BA.debugLine="et_nameFamili.Text=	lbl_nameFamili.Text";
mostCurrent._et_namefamili.setText(BA.ObjectToCharSequence(mostCurrent._lbl_namefamili.getText()));
RDebugUtils.currentLine=14548996;
 //BA.debugLineNum = 14548996;BA.debugLine="et_email.Text=lbl_email.Text";
mostCurrent._et_email.setText(BA.ObjectToCharSequence(mostCurrent._lbl_email.getText()));
RDebugUtils.currentLine=14548997;
 //BA.debugLineNum = 14548997;BA.debugLine="comp.Initialize(\"Compressor\")";
_comp.Initialize(processBA,"Compressor");
RDebugUtils.currentLine=14548998;
 //BA.debugLineNum = 14548998;BA.debugLine="comp.Quality=30";
_comp.setQuality((int) (30));
RDebugUtils.currentLine=14548999;
 //BA.debugLineNum = 14548999;BA.debugLine="lbl_image_up.Text=Chr(0xF0EE)";
mostCurrent._lbl_image_up.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf0ee))));
RDebugUtils.currentLine=14549000;
 //BA.debugLineNum = 14549000;BA.debugLine="pan_all_edit.Visible=True";
mostCurrent._pan_all_edit.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=14549005;
 //BA.debugLineNum = 14549005;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_icon_noup_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_icon_noup_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_icon_noup_click", null));}
RDebugUtils.currentLine=15925248;
 //BA.debugLineNum = 15925248;BA.debugLine="Private Sub lbl_icon_noUp_Click";
RDebugUtils.currentLine=15925250;
 //BA.debugLineNum = 15925250;BA.debugLine="File.Delete(Starter.Provider.SharedFolder, tempFil";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._tempfile);
RDebugUtils.currentLine=15925252;
 //BA.debugLineNum = 15925252;BA.debugLine="lbl_icon_up.Text=\"\"";
mostCurrent._lbl_icon_up.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=15925253;
 //BA.debugLineNum = 15925253;BA.debugLine="lbl_icon_noUp.Visible=False";
mostCurrent._lbl_icon_noup.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=15925254;
 //BA.debugLineNum = 15925254;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=14745601;
 //BA.debugLineNum = 14745601;BA.debugLine="Try";
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
RDebugUtils.currentLine=14745602;
 //BA.debugLineNum = 14745602;BA.debugLine="CC.Show(\"image/*\", \"Choose image\")";
parent._cc.Show(processBA,"image/*","Choose image");
RDebugUtils.currentLine=14745604;
 //BA.debugLineNum = 14745604;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As S";
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
RDebugUtils.currentLine=14745605;
 //BA.debugLineNum = 14745605;BA.debugLine="If Success = True Then";
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
RDebugUtils.currentLine=14745607;
 //BA.debugLineNum = 14745607;BA.debugLine="Try";
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
RDebugUtils.currentLine=14745608;
 //BA.debugLineNum = 14745608;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"temp_pic.jpg");
RDebugUtils.currentLine=14745609;
 //BA.debugLineNum = 14745609;BA.debugLine="bmp = comp.compressToBitmap(Starter.Provider.S";
parent.mostCurrent._bmp = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent._comp.compressToBitmap(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"temp_pic.jpg")));
RDebugUtils.currentLine=14745610;
 //BA.debugLineNum = 14745610;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Star";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._picname,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=14745611;
 //BA.debugLineNum = 14745611;BA.debugLine="bmp.WriteToStream(out, 20, \"JPEG\")";
parent.mostCurrent._bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (20),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"JPEG"));
RDebugUtils.currentLine=14745612;
 //BA.debugLineNum = 14745612;BA.debugLine="out.Close";
_out.Close();
 if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 17;
RDebugUtils.currentLine=14745615;
 //BA.debugLineNum = 14745615;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._picname);
RDebugUtils.currentLine=14745616;
 //BA.debugLineNum = 14745616;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("614745616",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 12:
//C
this.state = 15;
this.catchState = 17;
;
RDebugUtils.currentLine=14745619;
 //BA.debugLineNum = 14745619;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitma";
parent.mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(parent.mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._picname)).getObject()));
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=14745622;
 //BA.debugLineNum = 14745622;BA.debugLine="ToastMessageShow(\"انجام نشد :(\",True)";
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
RDebugUtils.currentLine=14745626;
 //BA.debugLineNum = 14745626;BA.debugLine="ToastMessageShow(\"خطا در بارگزاری\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در بارگزاری"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=14745627;
 //BA.debugLineNum = 14745627;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("614745627",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=14745630;
 //BA.debugLineNum = 14745630;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=14352384;
 //BA.debugLineNum = 14352384;BA.debugLine="Private Sub lbl_logOff_Click";
RDebugUtils.currentLine=14352385;
 //BA.debugLineNum = 14352385;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=14352386;
 //BA.debugLineNum = 14352386;BA.debugLine="result = Msgbox2(\"آیا از حساب خود خارج می شوید؟\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا از حساب خود خارج می شوید؟"),BA.ObjectToCharSequence("توجه"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=14352387;
 //BA.debugLineNum = 14352387;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=14352388;
 //BA.debugLineNum = 14352388;BA.debugLine="File.Delete(File.DirInternal,\"userAcc\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
RDebugUtils.currentLine=14352390;
 //BA.debugLineNum = 14352390;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=14352391;
 //BA.debugLineNum = 14352391;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
RDebugUtils.currentLine=14352397;
 //BA.debugLineNum = 14352397;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_reseve_db_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_reseve_db_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_reseve_db_click", null));}
int _result = 0;
RDebugUtils.currentLine=15269888;
 //BA.debugLineNum = 15269888;BA.debugLine="Private Sub lbl_reseve_db_Click";
RDebugUtils.currentLine=15269889;
 //BA.debugLineNum = 15269889;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=15269890;
 //BA.debugLineNum = 15269890;BA.debugLine="result = Msgbox2(\"اطلاعات من از سرور بازیابی شوند";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("اطلاعات من از سرور بازیابی شوند.توجه داشته باشید اطلاعات قبلی حذف می شوند"),BA.ObjectToCharSequence("بازگرداندن اطلاعات "),"مطمئن هستم","","لغو",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=15269891;
 //BA.debugLineNum = 15269891;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=15269893;
 //BA.debugLineNum = 15269893;BA.debugLine="http3.Initialize(\"ht6\", Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht6",step2_activity.getObject());
RDebugUtils.currentLine=15269894;
 //BA.debugLineNum = 15269894;BA.debugLine="http3.Download(\"https://taravatgroup.ir/uploads_";
mostCurrent._http3._download /*String*/ (null,"https://taravatgroup.ir/uploads_ezaf/"+mostCurrent._main._phon_num /*String*/ +"-db-"+mostCurrent._user_key+".db");
 };
RDebugUtils.currentLine=15269897;
 //BA.debugLineNum = 15269897;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_edit_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_edit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_edit_click", null));}
RDebugUtils.currentLine=14221312;
 //BA.debugLineNum = 14221312;BA.debugLine="Private Sub lbl_save_edit_Click";
RDebugUtils.currentLine=14221313;
 //BA.debugLineNum = 14221313;BA.debugLine="If (myfunc.check_internet=False)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=14221314;
 //BA.debugLineNum = 14221314;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 }else 
{RDebugUtils.currentLine=14221315;
 //BA.debugLineNum = 14221315;BA.debugLine="else If(et_nameFamili.Text=\"\")Then";
if (((mostCurrent._et_namefamili.getText()).equals(""))) { 
RDebugUtils.currentLine=14221316;
 //BA.debugLineNum = 14221316;BA.debugLine="ToastMessageShow(\"قسمت نام خالی است \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("قسمت نام خالی است "),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=14221317;
 //BA.debugLineNum = 14221317;BA.debugLine="Else If(et_email.Text=\"\")Then";
if (((mostCurrent._et_email.getText()).equals(""))) { 
RDebugUtils.currentLine=14221319;
 //BA.debugLineNum = 14221319;BA.debugLine="ToastMessageShow(\"قسمت ایمیل خالی است \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("قسمت ایمیل خالی است "),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=14221320;
 //BA.debugLineNum = 14221320;BA.debugLine="Else If(myfunc.Validate_Email(et_email.Text)=Fals";
if ((mostCurrent._myfunc._validate_email /*boolean*/ (mostCurrent.activityBA,mostCurrent._et_email.getText())==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=14221322;
 //BA.debugLineNum = 14221322;BA.debugLine="ToastMessageShow(\" ایمیل نامعتبر است \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" ایمیل نامعتبر است "),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=14221324;
 //BA.debugLineNum = 14221324;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
 }}}}
;
RDebugUtils.currentLine=14221328;
 //BA.debugLineNum = 14221328;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_db_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_send_db_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_send_db_click", null));}
int _result = 0;
RDebugUtils.currentLine=15335424;
 //BA.debugLineNum = 15335424;BA.debugLine="Private Sub lbl_send_db_Click";
RDebugUtils.currentLine=15335426;
 //BA.debugLineNum = 15335426;BA.debugLine="File.Copy(File.DirInternal,\"db.db\",Starter.Provid";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._main._phon_num /*String*/ +"-db-"+mostCurrent._user_key+".db");
RDebugUtils.currentLine=15335428;
 //BA.debugLineNum = 15335428;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=15335429;
 //BA.debugLineNum = 15335429;BA.debugLine="result = Msgbox2(\"اطلاعات در سرور آنلاین ذخیره شو";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("اطلاعات در سرور آنلاین ذخیره شود؟"),BA.ObjectToCharSequence("بک آپ گیری "),"باشه","","لغو",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=15335430;
 //BA.debugLineNum = 15335430;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=15335432;
 //BA.debugLineNum = 15335432;BA.debugLine="upload_file(Starter.Provider.SharedFolder&\"/\"&Ma";
_upload_file(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ +"/"+mostCurrent._main._phon_num /*String*/ +"-db-"+mostCurrent._user_key+".db");
 };
RDebugUtils.currentLine=15335435;
 //BA.debugLineNum = 15335435;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_msg_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_send_msg_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_send_msg_click", null));}
RDebugUtils.currentLine=15138816;
 //BA.debugLineNum = 15138816;BA.debugLine="Private Sub lbl_send_msg_Click";
RDebugUtils.currentLine=15138817;
 //BA.debugLineNum = 15138817;BA.debugLine="pan_all_msg.Visible=True";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=15138820;
 //BA.debugLineNum = 15138820;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_msg_end_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_send_msg_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_send_msg_end_click", null));}
RDebugUtils.currentLine=15532032;
 //BA.debugLineNum = 15532032;BA.debugLine="Private Sub lbl_send_msg_end_Click";
RDebugUtils.currentLine=15532034;
 //BA.debugLineNum = 15532034;BA.debugLine="http_initial_1(5)";
_http_initial_1((int) (5));
RDebugUtils.currentLine=15532036;
 //BA.debugLineNum = 15532036;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_msg2_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_send_msg2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_send_msg2_click", null));}
RDebugUtils.currentLine=15859712;
 //BA.debugLineNum = 15859712;BA.debugLine="Private Sub lbl_send_msg2_Click";
RDebugUtils.currentLine=15859713;
 //BA.debugLineNum = 15859713;BA.debugLine="lbl_send_msg_Click";
_lbl_send_msg_click();
RDebugUtils.currentLine=15859714;
 //BA.debugLineNum = 15859714;BA.debugLine="pan_all_show_myMsg.Visible=False";
mostCurrent._pan_all_show_mymsg.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=15859715;
 //BA.debugLineNum = 15859715;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=15466497;
 //BA.debugLineNum = 15466497;BA.debugLine="Try";
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
RDebugUtils.currentLine=15466498;
 //BA.debugLineNum = 15466498;BA.debugLine="CC.Show(\"image/*\", \"Choose image\")";
parent._cc.Show(processBA,"image/*","Choose image");
RDebugUtils.currentLine=15466500;
 //BA.debugLineNum = 15466500;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As S";
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
RDebugUtils.currentLine=15466501;
 //BA.debugLineNum = 15466501;BA.debugLine="If Success = True Then";
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
RDebugUtils.currentLine=15466505;
 //BA.debugLineNum = 15466505;BA.debugLine="tempFile=Main.phon_num&\"-\"&myfunc.random_id(10)";
parent.mostCurrent._tempfile = parent.mostCurrent._main._phon_num /*String*/ +"-"+parent.mostCurrent._myfunc._random_id /*String*/ (mostCurrent.activityBA,(int) (10))+".jpg";
RDebugUtils.currentLine=15466507;
 //BA.debugLineNum = 15466507;BA.debugLine="Try";
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
RDebugUtils.currentLine=15466510;
 //BA.debugLineNum = 15466510;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"tempimg.jpg");
RDebugUtils.currentLine=15466511;
 //BA.debugLineNum = 15466511;BA.debugLine="bmp = comp.compressToBitmap(Starter.Provider.S";
parent.mostCurrent._bmp = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent._comp.compressToBitmap(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"tempimg.jpg")));
RDebugUtils.currentLine=15466512;
 //BA.debugLineNum = 15466512;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Star";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._tempfile,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=15466513;
 //BA.debugLineNum = 15466513;BA.debugLine="bmp.WriteToStream(out, 50, \"JPEG\")";
parent.mostCurrent._bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (50),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"JPEG"));
RDebugUtils.currentLine=15466514;
 //BA.debugLineNum = 15466514;BA.debugLine="out.Close";
_out.Close();
 if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 17;
RDebugUtils.currentLine=15466519;
 //BA.debugLineNum = 15466519;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._tempfile);
RDebugUtils.currentLine=15466522;
 //BA.debugLineNum = 15466522;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("615466522",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 12:
//C
this.state = 15;
this.catchState = 17;
;
RDebugUtils.currentLine=15466527;
 //BA.debugLineNum = 15466527;BA.debugLine="lbl_icon_up.Text=Chr(0xF00C)";
parent.mostCurrent._lbl_icon_up.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf00c))));
RDebugUtils.currentLine=15466528;
 //BA.debugLineNum = 15466528;BA.debugLine="lbl_icon_noUp.Visible=True";
parent.mostCurrent._lbl_icon_noup.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=15466530;
 //BA.debugLineNum = 15466530;BA.debugLine="ToastMessageShow(\"انجام نشد :(\",True)";
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
RDebugUtils.currentLine=15466533;
 //BA.debugLineNum = 15466533;BA.debugLine="ToastMessageShow(\"خطا در بارگزاری\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در بارگزاری"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=15466534;
 //BA.debugLineNum = 15466534;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("615466534",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=15466538;
 //BA.debugLineNum = 15466538;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=15663104;
 //BA.debugLineNum = 15663104;BA.debugLine="Private Sub lbl_send_up_icon_Click";
RDebugUtils.currentLine=15663105;
 //BA.debugLineNum = 15663105;BA.debugLine="lbl_send_up_Click";
_lbl_send_up_click();
RDebugUtils.currentLine=15663106;
 //BA.debugLineNum = 15663106;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_transfer_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_transfer_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_transfer_click", null));}
int _result = 0;
RDebugUtils.currentLine=15073280;
 //BA.debugLineNum = 15073280;BA.debugLine="Private Sub lbl_transfer_Click";
RDebugUtils.currentLine=15073281;
 //BA.debugLineNum = 15073281;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=15073282;
 //BA.debugLineNum = 15073282;BA.debugLine="result = Msgbox2(\"درخواست انتقال نسخه طلایی به گو";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("درخواست انتقال نسخه طلایی به گوشی جدید"),BA.ObjectToCharSequence("درخواست انتقال"),"ثبت درخواست ","","لغو",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=15073283;
 //BA.debugLineNum = 15073283;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=15073284;
 //BA.debugLineNum = 15073284;BA.debugLine="http_initial_1(3)";
_http_initial_1((int) (3));
 };
RDebugUtils.currentLine=15073286;
 //BA.debugLineNum = 15073286;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_edit_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_edit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_edit_click", null));}
RDebugUtils.currentLine=14155776;
 //BA.debugLineNum = 14155776;BA.debugLine="Private Sub pan_all_edit_Click";
RDebugUtils.currentLine=14155778;
 //BA.debugLineNum = 14155778;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_msg_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_msg_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_msg_click", null));}
RDebugUtils.currentLine=15400960;
 //BA.debugLineNum = 15400960;BA.debugLine="Private Sub pan_all_msg_Click";
RDebugUtils.currentLine=15400961;
 //BA.debugLineNum = 15400961;BA.debugLine="pan_all_msg.Visible=False";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=15400962;
 //BA.debugLineNum = 15400962;BA.debugLine="End Sub";
return "";
}
public static String  _panel9_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel9_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel9_click", null));}
RDebugUtils.currentLine=15597568;
 //BA.debugLineNum = 15597568;BA.debugLine="Private Sub Panel9_Click";
RDebugUtils.currentLine=15597570;
 //BA.debugLineNum = 15597570;BA.debugLine="End Sub";
return "";
}
public static String  _up_sendfile(String _value) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "up_sendfile", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "up_sendfile", new Object[] {_value}));}
RDebugUtils.currentLine=14942208;
 //BA.debugLineNum = 14942208;BA.debugLine="Sub Up_sendFile (value As String)";
RDebugUtils.currentLine=14942209;
 //BA.debugLineNum = 14942209;BA.debugLine="Log( value)";
anywheresoftware.b4a.keywords.Common.LogImpl("614942209",_value,0);
RDebugUtils.currentLine=14942210;
 //BA.debugLineNum = 14942210;BA.debugLine="End Sub";
return "";
}
public static String  _up_statusupload(String _value) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "up_statusupload", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "up_statusupload", new Object[] {_value}));}
RDebugUtils.currentLine=15007744;
 //BA.debugLineNum = 15007744;BA.debugLine="Sub Up_statusUpload (value As String)";
RDebugUtils.currentLine=15007745;
 //BA.debugLineNum = 15007745;BA.debugLine="lbl_image_up.Text=value&\" %\"";
mostCurrent._lbl_image_up.setText(BA.ObjectToCharSequence(_value+" %"));
RDebugUtils.currentLine=15007748;
 //BA.debugLineNum = 15007748;BA.debugLine="If(value>=100)Then";
if (((double)(Double.parseDouble(_value))>=100)) { 
RDebugUtils.currentLine=15007749;
 //BA.debugLineNum = 15007749;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=15007750;
 //BA.debugLineNum = 15007750;BA.debugLine="ToastMessageShow(\" ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=15007753;
 //BA.debugLineNum = 15007753;BA.debugLine="End Sub";
return "";
}
}