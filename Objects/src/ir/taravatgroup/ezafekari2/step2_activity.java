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
public static anywheresoftware.b4a.objects.Timer _tim_send_backup = null;
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
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_sendbackup = null;
public anywheresoftware.b4a.objects.ProgressBarWrapper _progressbar1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_progressbar = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_progressbar1 = null;
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
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
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
public ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=61865984;
 //BA.debugLineNum = 61865984;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=61865992;
 //BA.debugLineNum = 61865992;BA.debugLine="If(File.Exists(File.DirInternal,\"phonNum\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum"))) { 
RDebugUtils.currentLine=61865993;
 //BA.debugLineNum = 61865993;BA.debugLine="Activity.LoadLayout(\"step2\")";
mostCurrent._activity.LoadLayout("step2",mostCurrent.activityBA);
RDebugUtils.currentLine=61865995;
 //BA.debugLineNum = 61865995;BA.debugLine="Main.phon_num=File.ReadString(File.DirInternal,\"";
mostCurrent._main._phon_num /*String*/  = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum");
RDebugUtils.currentLine=61865998;
 //BA.debugLineNum = 61865998;BA.debugLine="If(myfunc.check_karid=False)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=61865999;
 //BA.debugLineNum = 61865999;BA.debugLine="lbl_noske.Text=\"نسخه هدیه\"";
mostCurrent._lbl_noske.setText(BA.ObjectToCharSequence("نسخه هدیه"));
RDebugUtils.currentLine=61866000;
 //BA.debugLineNum = 61866000;BA.debugLine="type_app=0";
_type_app = (int) (0);
 }else {
RDebugUtils.currentLine=61866002;
 //BA.debugLineNum = 61866002;BA.debugLine="lbl_noske.Text=\"نسخه طلایی\"";
mostCurrent._lbl_noske.setText(BA.ObjectToCharSequence("نسخه طلایی"));
RDebugUtils.currentLine=61866003;
 //BA.debugLineNum = 61866003;BA.debugLine="type_app=1";
_type_app = (int) (1);
 };
RDebugUtils.currentLine=61866006;
 //BA.debugLineNum = 61866006;BA.debugLine="If (Main.backup_page_show=1)Then";
if ((mostCurrent._main._backup_page_show /*int*/ ==1)) { 
RDebugUtils.currentLine=61866007;
 //BA.debugLineNum = 61866007;BA.debugLine="pan_all_sendBackup.Visible=True";
mostCurrent._pan_all_sendbackup.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=61866008;
 //BA.debugLineNum = 61866008;BA.debugLine="pan_progressBar.Visible=True";
mostCurrent._pan_progressbar.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=61866009;
 //BA.debugLineNum = 61866009;BA.debugLine="ProgressBar1.Enabled=True";
mostCurrent._progressbar1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=61866010;
 //BA.debugLineNum = 61866010;BA.debugLine="ProgressDialogShow2(\"پشتیبان گیری آنلاین ...\",F";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("پشتیبان گیری آنلاین ..."),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=61866012;
 //BA.debugLineNum = 61866012;BA.debugLine="pan_all_sendBackup.Visible=False";
mostCurrent._pan_all_sendbackup.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=61866013;
 //BA.debugLineNum = 61866013;BA.debugLine="ProgressDialogShow(\"بارگذاری ...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("بارگذاری ..."));
 };
RDebugUtils.currentLine=61866018;
 //BA.debugLineNum = 61866018;BA.debugLine="CC.Initialize(\"CC\")";
_cc.Initialize("CC");
RDebugUtils.currentLine=61866019;
 //BA.debugLineNum = 61866019;BA.debugLine="Url_Php_Page=\"https://taravatgroup.ir/avatar_up1";
mostCurrent._url_php_page = "https://taravatgroup.ir/avatar_up1.php";
RDebugUtils.currentLine=61866021;
 //BA.debugLineNum = 61866021;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=61866022;
 //BA.debugLineNum = 61866022;BA.debugLine="Up.B4A_log=True";
mostCurrent._up.B4A_log = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=61866023;
 //BA.debugLineNum = 61866023;BA.debugLine="Up.Initialize(\"Up\")";
mostCurrent._up.Initialize(processBA,"Up");
 };
RDebugUtils.currentLine=61866027;
 //BA.debugLineNum = 61866027;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
RDebugUtils.currentLine=61866038;
 //BA.debugLineNum = 61866038;BA.debugLine="Label12.Color=Main.color4";
mostCurrent._label12.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=61866039;
 //BA.debugLineNum = 61866039;BA.debugLine="Panel12.Color=Main.color4";
mostCurrent._panel12.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=61866040;
 //BA.debugLineNum = 61866040;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 }else {
RDebugUtils.currentLine=61866044;
 //BA.debugLineNum = 61866044;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=61866045;
 //BA.debugLineNum = 61866045;BA.debugLine="StartActivity(step0_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step0_activity.getObject()));
 };
RDebugUtils.currentLine=61866052;
 //BA.debugLineNum = 61866052;BA.debugLine="tim_send_backup.Initialize(\"tim_send_backup\",4500";
_tim_send_backup.Initialize(processBA,"tim_send_backup",(long) (4500));
RDebugUtils.currentLine=61866055;
 //BA.debugLineNum = 61866055;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "http_initial_1", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "http_initial_1", new Object[] {_type1}));}
String _send = "";
int _exist_pic = 0;
RDebugUtils.currentLine=62324736;
 //BA.debugLineNum = 62324736;BA.debugLine="Sub http_initial_1(type1 As Int)";
RDebugUtils.currentLine=62324737;
 //BA.debugLineNum = 62324737;BA.debugLine="Try";
try {RDebugUtils.currentLine=62324740;
 //BA.debugLineNum = 62324740;BA.debugLine="If (myfunc.check_internet=False)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=62324741;
 //BA.debugLineNum = 62324741;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 }else {
RDebugUtils.currentLine=62324746;
 //BA.debugLineNum = 62324746;BA.debugLine="If(type1=1)Then";
if ((_type1==1)) { 
RDebugUtils.currentLine=62324748;
 //BA.debugLineNum = 62324748;BA.debugLine="http3.Initialize(\"ht1\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht1",step2_activity.getObject());
RDebugUtils.currentLine=62324749;
 //BA.debugLineNum = 62324749;BA.debugLine="Dim send As String= \"var=3&phone=\"&Main.phon_n";
_send = "var=3&phone="+mostCurrent._main._phon_num /*String*/ +"&type_app="+BA.NumberToString(_type_app)+"&div_id="+mostCurrent._pp.GetSettings("android_id")+"&div_model="+mostCurrent._pp.getModel();
RDebugUtils.currentLine=62324750;
 //BA.debugLineNum = 62324750;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }else 
{RDebugUtils.currentLine=62324753;
 //BA.debugLineNum = 62324753;BA.debugLine="Else If(type1=2)Then ' to edit";
if ((_type1==2)) { 
RDebugUtils.currentLine=62324754;
 //BA.debugLineNum = 62324754;BA.debugLine="Dim exist_pic As Int=0";
_exist_pic = (int) (0);
RDebugUtils.currentLine=62324755;
 //BA.debugLineNum = 62324755;BA.debugLine="If(File.Exists(Starter.Provider.SharedFolder,p";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._picname))) { 
RDebugUtils.currentLine=62324756;
 //BA.debugLineNum = 62324756;BA.debugLine="upload_img(Starter.Provider.SharedFolder&\"/\"&";
_upload_img(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ +"/"+mostCurrent._picname);
RDebugUtils.currentLine=62324757;
 //BA.debugLineNum = 62324757;BA.debugLine="exist_pic=1";
_exist_pic = (int) (1);
 };
RDebugUtils.currentLine=62324760;
 //BA.debugLineNum = 62324760;BA.debugLine="http3.Initialize(\"ht2\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht2",step2_activity.getObject());
RDebugUtils.currentLine=62324761;
 //BA.debugLineNum = 62324761;BA.debugLine="Dim send As String=\"var=2&name=\"&et_nameFamili";
_send = "var=2&name="+mostCurrent._et_namefamili.getText()+"&email="+mostCurrent._et_email.getText()+"&phone="+mostCurrent._main._phon_num /*String*/ +"&exist_pic="+BA.NumberToString(_exist_pic)+"&pic_name="+mostCurrent._picname;
RDebugUtils.currentLine=62324762;
 //BA.debugLineNum = 62324762;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }else 
{RDebugUtils.currentLine=62324766;
 //BA.debugLineNum = 62324766;BA.debugLine="Else If(type1=3)Then '  req transfer noskhe";
if ((_type1==3)) { 
RDebugUtils.currentLine=62324767;
 //BA.debugLineNum = 62324767;BA.debugLine="http3.Initialize(\"ht3\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht3",step2_activity.getObject());
RDebugUtils.currentLine=62324768;
 //BA.debugLineNum = 62324768;BA.debugLine="Dim send As String= \"var=4&phone=\"&Main.phon_n";
_send = "var=4&phone="+mostCurrent._main._phon_num /*String*/ +"&name="+mostCurrent._lbl_namefamili.getText();
RDebugUtils.currentLine=62324769;
 //BA.debugLineNum = 62324769;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }else 
{RDebugUtils.currentLine=62324771;
 //BA.debugLineNum = 62324771;BA.debugLine="Else If(type1=4)Then '  req chek noskhe";
if ((_type1==4)) { 
RDebugUtils.currentLine=62324772;
 //BA.debugLineNum = 62324772;BA.debugLine="http3.Initialize(\"ht4\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht4",step2_activity.getObject());
RDebugUtils.currentLine=62324773;
 //BA.debugLineNum = 62324773;BA.debugLine="Dim send As String= \"var=5&phone=\"&Main.phon_n";
_send = "var=5&phone="+mostCurrent._main._phon_num /*String*/ +"&name="+mostCurrent._lbl_namefamili.getText();
RDebugUtils.currentLine=62324774;
 //BA.debugLineNum = 62324774;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }else 
{RDebugUtils.currentLine=62324776;
 //BA.debugLineNum = 62324776;BA.debugLine="Else If(type1=5)Then '  send msg";
if ((_type1==5)) { 
RDebugUtils.currentLine=62324777;
 //BA.debugLineNum = 62324777;BA.debugLine="If(File.Exists(Starter.Provider.SharedFolder,t";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._tempfile))) { 
RDebugUtils.currentLine=62324778;
 //BA.debugLineNum = 62324778;BA.debugLine="upload_file(Starter.Provider.SharedFolder&\"/\"";
_upload_file(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ +"/"+mostCurrent._tempfile);
 }else {
RDebugUtils.currentLine=62324780;
 //BA.debugLineNum = 62324780;BA.debugLine="tempFile=\"\"";
mostCurrent._tempfile = "";
 };
RDebugUtils.currentLine=62324783;
 //BA.debugLineNum = 62324783;BA.debugLine="If(et_msg.Text.Trim=\"\")Then";
if (((mostCurrent._et_msg.getText().trim()).equals(""))) { 
RDebugUtils.currentLine=62324784;
 //BA.debugLineNum = 62324784;BA.debugLine="ToastMessageShow(\"کادر پیام خالی است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("کادر پیام خالی است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=62324787;
 //BA.debugLineNum = 62324787;BA.debugLine="http3.Initialize(\"ht5\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht5",step2_activity.getObject());
RDebugUtils.currentLine=62324788;
 //BA.debugLineNum = 62324788;BA.debugLine="Dim send As String= \"var=6&phone=\"&Main.phon_";
_send = "var=6&phone="+mostCurrent._main._phon_num /*String*/ +"&msg="+mostCurrent._et_msg.getText()+"&file_name="+mostCurrent._tempfile+"&name="+mostCurrent._lbl_namefamili.getText();
RDebugUtils.currentLine=62324789;
 //BA.debugLineNum = 62324789;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/sav";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
RDebugUtils.currentLine=62324790;
 //BA.debugLineNum = 62324790;BA.debugLine="pan_all_msg.Visible=False";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }else 
{RDebugUtils.currentLine=62324796;
 //BA.debugLineNum = 62324796;BA.debugLine="Else If (type1=6) Then  ' recive pic";
if ((_type1==6)) { 
RDebugUtils.currentLine=62324797;
 //BA.debugLineNum = 62324797;BA.debugLine="http3.Initialize(\"ht7\", Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht7",step2_activity.getObject());
RDebugUtils.currentLine=62324798;
 //BA.debugLineNum = 62324798;BA.debugLine="http3.Download(\"https://taravatgroup.ir/avatar";
mostCurrent._http3._download /*String*/ (null,"https://taravatgroup.ir/avatar_ezaf_users/"+mostCurrent._picname);
 }else 
{RDebugUtils.currentLine=62324799;
 //BA.debugLineNum = 62324799;BA.debugLine="Else If(type1=7)Then";
if ((_type1==7)) { 
RDebugUtils.currentLine=62324801;
 //BA.debugLineNum = 62324801;BA.debugLine="http3.Initialize(\"ht8\", Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht8",step2_activity.getObject());
RDebugUtils.currentLine=62324803;
 //BA.debugLineNum = 62324803;BA.debugLine="Dim send As String= \"var=1&phone=\"&Main.phon_n";
_send = "var=1&phone="+mostCurrent._main._phon_num /*String*/ +"&key=mME22eBbA20aDd1401";
RDebugUtils.currentLine=62324804;
 //BA.debugLineNum = 62324804;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/user";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/user_msg.php",_send);
 }else 
{RDebugUtils.currentLine=62324807;
 //BA.debugLineNum = 62324807;BA.debugLine="Else If(type1=8)Then";
if ((_type1==8)) { 
RDebugUtils.currentLine=62324809;
 //BA.debugLineNum = 62324809;BA.debugLine="http3.Initialize(\"ht9\",Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht9",step2_activity.getObject());
RDebugUtils.currentLine=62324810;
 //BA.debugLineNum = 62324810;BA.debugLine="Dim send As String= \"var=7&phone=\"&Main.phon_n";
_send = "var=7&phone="+mostCurrent._main._phon_num /*String*/ +"&div_id="+mostCurrent._pp.GetSettings("android_id");
RDebugUtils.currentLine=62324811;
 //BA.debugLineNum = 62324811;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save";
mostCurrent._http3._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }}}}}}}}
;
 };
 } 
       catch (Exception e54) {
			processBA.setLastException(e54);RDebugUtils.currentLine=62324823;
 //BA.debugLineNum = 62324823;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("362324823",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=62324828;
 //BA.debugLineNum = 62324828;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=62652416;
 //BA.debugLineNum = 62652416;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=62652417;
 //BA.debugLineNum = 62652417;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=62652418;
 //BA.debugLineNum = 62652418;BA.debugLine="If(pan_all_edit.Visible=True)Then";
if ((mostCurrent._pan_all_edit.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=62652419;
 //BA.debugLineNum = 62652419;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 }else 
{RDebugUtils.currentLine=62652420;
 //BA.debugLineNum = 62652420;BA.debugLine="Else If(pan_all_msg.Visible=True)Then";
if ((mostCurrent._pan_all_msg.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=62652421;
 //BA.debugLineNum = 62652421;BA.debugLine="pan_all_msg.Visible=False";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=62652422;
 //BA.debugLineNum = 62652422;BA.debugLine="Else If(pan_all_show_myMsg.Visible=True)Then";
if ((mostCurrent._pan_all_show_mymsg.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=62652423;
 //BA.debugLineNum = 62652423;BA.debugLine="lbl_back_Shmsg_Click";
_lbl_back_shmsg_click();
 }else {
RDebugUtils.currentLine=62652425;
 //BA.debugLineNum = 62652425;BA.debugLine="lbl_back_home_Click";
_lbl_back_home_click();
 }}}
;
RDebugUtils.currentLine=62652428;
 //BA.debugLineNum = 62652428;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=62652430;
 //BA.debugLineNum = 62652430;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=62652432;
 //BA.debugLineNum = 62652432;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=62193664;
 //BA.debugLineNum = 62193664;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=62193665;
 //BA.debugLineNum = 62193665;BA.debugLine="pan_all_edit.Visible=False";
mostCurrent._pan_all_edit.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=62193666;
 //BA.debugLineNum = 62193666;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_shmsg_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_shmsg_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_shmsg_click", null));}
RDebugUtils.currentLine=63832064;
 //BA.debugLineNum = 63832064;BA.debugLine="Private Sub lbl_back_Shmsg_Click";
RDebugUtils.currentLine=63832065;
 //BA.debugLineNum = 63832065;BA.debugLine="pan_all_show_myMsg.Visible=False";
mostCurrent._pan_all_show_mymsg.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=63832066;
 //BA.debugLineNum = 63832066;BA.debugLine="Main.msg_page_show=0";
mostCurrent._main._msg_page_show /*int*/  = (int) (0);
RDebugUtils.currentLine=63832067;
 //BA.debugLineNum = 63832067;BA.debugLine="http_initial_1(8)";
_http_initial_1((int) (8));
RDebugUtils.currentLine=63832068;
 //BA.debugLineNum = 63832068;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_home_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_home_click", null));}
RDebugUtils.currentLine=62717952;
 //BA.debugLineNum = 62717952;BA.debugLine="Private Sub lbl_back_home_Click";
RDebugUtils.currentLine=62717953;
 //BA.debugLineNum = 62717953;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=62717954;
 //BA.debugLineNum = 62717954;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=62717956;
 //BA.debugLineNum = 62717956;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="step2_activity";
RDebugUtils.currentLine=61997056;
 //BA.debugLineNum = 61997056;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=61997058;
 //BA.debugLineNum = 61997058;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=61931520;
 //BA.debugLineNum = 61931520;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=61931522;
 //BA.debugLineNum = 61931522;BA.debugLine="End Sub";
return "";
}
public static String  _upload_img(String _path) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "upload_img", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "upload_img", new Object[] {_path}));}
RDebugUtils.currentLine=62849024;
 //BA.debugLineNum = 62849024;BA.debugLine="Sub upload_img(path As String)";
RDebugUtils.currentLine=62849026;
 //BA.debugLineNum = 62849026;BA.debugLine="File.Copy(Starter.Provider.SharedFolder,picName,";
anywheresoftware.b4a.keywords.Common.File.Copy(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._picname,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname);
RDebugUtils.currentLine=62849027;
 //BA.debugLineNum = 62849027;BA.debugLine="Path_Phone_Image = path";
mostCurrent._path_phone_image = _path;
RDebugUtils.currentLine=62849028;
 //BA.debugLineNum = 62849028;BA.debugLine="Up.doFileUpload( Null,Null,Path_Phone_Image,Url_";
mostCurrent._up.doFileUpload(processBA,(android.widget.ProgressBar)(anywheresoftware.b4a.keywords.Common.Null),(android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent._path_phone_image,mostCurrent._url_php_page);
RDebugUtils.currentLine=62849030;
 //BA.debugLineNum = 62849030;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitmap(";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
RDebugUtils.currentLine=62849031;
 //BA.debugLineNum = 62849031;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitmap";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
RDebugUtils.currentLine=62849035;
 //BA.debugLineNum = 62849035;BA.debugLine="End Sub";
return "";
}
public static String  _upload_file(String _path) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "upload_file", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "upload_file", new Object[] {_path}));}
RDebugUtils.currentLine=62914560;
 //BA.debugLineNum = 62914560;BA.debugLine="Sub upload_file(path As String)";
RDebugUtils.currentLine=62914562;
 //BA.debugLineNum = 62914562;BA.debugLine="If (Main.backup_page_show<>1)Then";
if ((mostCurrent._main._backup_page_show /*int*/ !=1)) { 
 };
RDebugUtils.currentLine=62914566;
 //BA.debugLineNum = 62914566;BA.debugLine="pan_progressBar.Visible=True";
mostCurrent._pan_progressbar.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=62914567;
 //BA.debugLineNum = 62914567;BA.debugLine="Up.doFileUpload( Null,Null,path,\"https://taravat";
mostCurrent._up.doFileUpload(processBA,(android.widget.ProgressBar)(anywheresoftware.b4a.keywords.Common.Null),(android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Null),_path,"https://taravatgroup.ir/file_up.php");
RDebugUtils.currentLine=62914570;
 //BA.debugLineNum = 62914570;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(ir.taravatgroup.ezafekari2.httpjob _job) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
String[] _a = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
anywheresoftware.b4a.objects.collections.List _ls_user = null;
RDebugUtils.currentLine=62390272;
 //BA.debugLineNum = 62390272;BA.debugLine="Sub Jobdone (job As HttpJob)";
RDebugUtils.currentLine=62390273;
 //BA.debugLineNum = 62390273;BA.debugLine="Try";
try {RDebugUtils.currentLine=62390275;
 //BA.debugLineNum = 62390275;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=62390277;
 //BA.debugLineNum = 62390277;BA.debugLine="If job.JobName=\"ht1\" Then";
if ((_job._jobname /*String*/ ).equals("ht1")) { 
RDebugUtils.currentLine=62390278;
 //BA.debugLineNum = 62390278;BA.debugLine="If(job.GetString.Contains(\"nouser\"))Then";
if ((_job._getstring /*String*/ (null).contains("nouser"))) { 
RDebugUtils.currentLine=62390280;
 //BA.debugLineNum = 62390280;BA.debugLine="File.Delete(File.DirInternal,\"userAcc\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
RDebugUtils.currentLine=62390281;
 //BA.debugLineNum = 62390281;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=62390283;
 //BA.debugLineNum = 62390283;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=62390284;
 //BA.debugLineNum = 62390284;BA.debugLine="StartActivity(step0_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step0_activity.getObject()));
 }else {
RDebugUtils.currentLine=62390288;
 //BA.debugLineNum = 62390288;BA.debugLine="Dim a() As String";
_a = new String[(int) (0)];
java.util.Arrays.fill(_a,"");
RDebugUtils.currentLine=62390289;
 //BA.debugLineNum = 62390289;BA.debugLine="a=Regex.Split(\"&\",job.GetString)";
_a = anywheresoftware.b4a.keywords.Common.Regex.Split("&",_job._getstring /*String*/ (null));
RDebugUtils.currentLine=62390291;
 //BA.debugLineNum = 62390291;BA.debugLine="lbl_nameFamili.Text=a(0)";
mostCurrent._lbl_namefamili.setText(BA.ObjectToCharSequence(_a[(int) (0)]));
RDebugUtils.currentLine=62390292;
 //BA.debugLineNum = 62390292;BA.debugLine="lbl_email.Text=a(1)";
mostCurrent._lbl_email.setText(BA.ObjectToCharSequence(_a[(int) (1)]));
RDebugUtils.currentLine=62390300;
 //BA.debugLineNum = 62390300;BA.debugLine="lbl_phoneNum.Text=a(2)";
mostCurrent._lbl_phonenum.setText(BA.ObjectToCharSequence(_a[(int) (2)]));
RDebugUtils.currentLine=62390302;
 //BA.debugLineNum = 62390302;BA.debugLine="user_key=a(4)";
mostCurrent._user_key = _a[(int) (4)];
RDebugUtils.currentLine=62390306;
 //BA.debugLineNum = 62390306;BA.debugLine="If(Main.msg_page_show=1)Then";
if ((mostCurrent._main._msg_page_show /*int*/ ==1)) { 
RDebugUtils.currentLine=62390307;
 //BA.debugLineNum = 62390307;BA.debugLine="lbl_all_msg_Click";
_lbl_all_msg_click();
 }else 
{RDebugUtils.currentLine=62390308;
 //BA.debugLineNum = 62390308;BA.debugLine="Else If (Main.backup_page_show=1)Then";
if ((mostCurrent._main._backup_page_show /*int*/ ==1)) { 
RDebugUtils.currentLine=62390309;
 //BA.debugLineNum = 62390309;BA.debugLine="tim_send_backup.Enabled=True";
_tim_send_backup.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }}
;
RDebugUtils.currentLine=62390314;
 //BA.debugLineNum = 62390314;BA.debugLine="File.WriteList(File.DirInternal,\"userAcc\",a)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc",anywheresoftware.b4a.keywords.Common.ArrayToList(_a));
RDebugUtils.currentLine=62390316;
 //BA.debugLineNum = 62390316;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=62390318;
 //BA.debugLineNum = 62390318;BA.debugLine="picName=\"user-\"&Main.phon_num&\"-\"&a(4)&\".jpg\"";
mostCurrent._picname = "user-"+mostCurrent._main._phon_num /*String*/ +"-"+_a[(int) (4)]+".jpg";
RDebugUtils.currentLine=62390319;
 //BA.debugLineNum = 62390319;BA.debugLine="If(File.Exists(File.DirInternal,picName)=Fals";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=62390320;
 //BA.debugLineNum = 62390320;BA.debugLine="If(a(3)=\"1\")Then";
if (((_a[(int) (3)]).equals("1"))) { 
RDebugUtils.currentLine=62390321;
 //BA.debugLineNum = 62390321;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=62390322;
 //BA.debugLineNum = 62390322;BA.debugLine="http_initial_1(6)";
_http_initial_1((int) (6));
 };
 }else {
RDebugUtils.currentLine=62390325;
 //BA.debugLineNum = 62390325;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBit";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
RDebugUtils.currentLine=62390326;
 //BA.debugLineNum = 62390326;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBi";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 };
 };
 }else 
{RDebugUtils.currentLine=62390339;
 //BA.debugLineNum = 62390339;BA.debugLine="else If job.JobName=\"ht2\" Then";
if ((_job._jobname /*String*/ ).equals("ht2")) { 
RDebugUtils.currentLine=62390340;
 //BA.debugLineNum = 62390340;BA.debugLine="If(job.GetString.Contains(\"true\"))Then";
if ((_job._getstring /*String*/ (null).contains("true"))) { 
RDebugUtils.currentLine=62390341;
 //BA.debugLineNum = 62390341;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=62390342;
 //BA.debugLineNum = 62390342;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
RDebugUtils.currentLine=62390343;
 //BA.debugLineNum = 62390343;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 }else 
{RDebugUtils.currentLine=62390346;
 //BA.debugLineNum = 62390346;BA.debugLine="else If job.JobName=\"ht3\" Then  '  req transfer";
if ((_job._jobname /*String*/ ).equals("ht3")) { 
RDebugUtils.currentLine=62390348;
 //BA.debugLineNum = 62390348;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
if ((_job._getstring /*String*/ (null).contains("ok_add"))) { 
RDebugUtils.currentLine=62390349;
 //BA.debugLineNum = 62390349;BA.debugLine="MsgboxAsync(\"درخواست شما با موفقیت ثبت گردید";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("درخواست شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر "),BA.ObjectToCharSequence("پیام"),processBA);
 }else {
RDebugUtils.currentLine=62390351;
 //BA.debugLineNum = 62390351;BA.debugLine="MsgboxAsync(\"خطا در ارسال درخواست، دوباره امت";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("خطا در ارسال درخواست، دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 };
 }else 
{RDebugUtils.currentLine=62390354;
 //BA.debugLineNum = 62390354;BA.debugLine="else If job.JobName=\"ht4\" Then '  req chek nosk";
if ((_job._jobname /*String*/ ).equals("ht4")) { 
RDebugUtils.currentLine=62390356;
 //BA.debugLineNum = 62390356;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
if ((_job._getstring /*String*/ (null).contains("ok_add"))) { 
RDebugUtils.currentLine=62390357;
 //BA.debugLineNum = 62390357;BA.debugLine="MsgboxAsync(\"درخواست شما با موفقیت ثبت گردید";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("درخواست شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر "),BA.ObjectToCharSequence("پیام"),processBA);
 }else {
RDebugUtils.currentLine=62390359;
 //BA.debugLineNum = 62390359;BA.debugLine="MsgboxAsync(\"خطا در ارسال درخواست، دوباره امت";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("خطا در ارسال درخواست، دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 };
 }else 
{RDebugUtils.currentLine=62390362;
 //BA.debugLineNum = 62390362;BA.debugLine="else If job.JobName=\"ht5\" Then  '  send msg";
if ((_job._jobname /*String*/ ).equals("ht5")) { 
RDebugUtils.currentLine=62390364;
 //BA.debugLineNum = 62390364;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
if ((_job._getstring /*String*/ (null).contains("ok_add"))) { 
RDebugUtils.currentLine=62390365;
 //BA.debugLineNum = 62390365;BA.debugLine="MsgboxAsync(\"پیغام شما با موفقیت ثبت گردید ون";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("پیغام شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر "),BA.ObjectToCharSequence("پیام"),processBA);
 }else {
RDebugUtils.currentLine=62390368;
 //BA.debugLineNum = 62390368;BA.debugLine="MsgboxAsync(\"خطا در ارسال پیغام، دوباره امتحا";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("خطا در ارسال پیغام، دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 };
 }else 
{RDebugUtils.currentLine=62390371;
 //BA.debugLineNum = 62390371;BA.debugLine="else If job.JobName=\"ht6\" Then  '  recive db";
if ((_job._jobname /*String*/ ).equals("ht6")) { 
RDebugUtils.currentLine=62390374;
 //BA.debugLineNum = 62390374;BA.debugLine="Dim out As OutputStream = File.OpenOutput(File";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=62390375;
 //BA.debugLineNum = 62390375;BA.debugLine="File.Copy2(http3.GetInputStream, out)";
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(mostCurrent._http3._getinputstream /*anywheresoftware.b4a.objects.streams.File.InputStreamWrapper*/ (null).getObject()),(java.io.OutputStream)(_out.getObject()));
RDebugUtils.currentLine=62390376;
 //BA.debugLineNum = 62390376;BA.debugLine="out.Close";
_out.Close();
RDebugUtils.currentLine=62390377;
 //BA.debugLineNum = 62390377;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=62390378;
 //BA.debugLineNum = 62390378;BA.debugLine="myfunc.help_man(\"تبریک\",\"اطلاعات بازگردانده شد";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"تبریک","اطلاعات بازگردانده شد ، برای اعمال تغییرات یک بار از برنامه خارج و دوباره وارد شوید.");
RDebugUtils.currentLine=62390379;
 //BA.debugLineNum = 62390379;BA.debugLine="ToastMessageShow(\"اطلاعات بازگردانده شد\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اطلاعات بازگردانده شد"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=62390384;
 //BA.debugLineNum = 62390384;BA.debugLine="else If job.JobName=\"ht7\" Then  '  recive pic";
if ((_job._jobname /*String*/ ).equals("ht7")) { 
RDebugUtils.currentLine=62390388;
 //BA.debugLineNum = 62390388;BA.debugLine="Dim bmp As Bitmap = job.GetBitmap";
mostCurrent._bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
mostCurrent._bmp = _job._getbitmap /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (null);
RDebugUtils.currentLine=62390389;
 //BA.debugLineNum = 62390389;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=62390390;
 //BA.debugLineNum = 62390390;BA.debugLine="out = File.OpenOutput(File.DirInternal,picName";
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=62390391;
 //BA.debugLineNum = 62390391;BA.debugLine="bmp.WriteToStream(out, 100, \"JPEG\")";
mostCurrent._bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (100),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"JPEG"));
RDebugUtils.currentLine=62390392;
 //BA.debugLineNum = 62390392;BA.debugLine="out.Close";
_out.Close();
RDebugUtils.currentLine=62390396;
 //BA.debugLineNum = 62390396;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitma";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
RDebugUtils.currentLine=62390397;
 //BA.debugLineNum = 62390397;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitm";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 }else 
{RDebugUtils.currentLine=62390399;
 //BA.debugLineNum = 62390399;BA.debugLine="else If job.JobName=\"ht8\" Then  '  recive my ms";
if ((_job._jobname /*String*/ ).equals("ht8")) { 
RDebugUtils.currentLine=62390401;
 //BA.debugLineNum = 62390401;BA.debugLine="wb_show_myMsg.LoadHtml(job.GetString)";
mostCurrent._wb_show_mymsg.LoadHtml(_job._getstring /*String*/ (null));
 }else 
{RDebugUtils.currentLine=62390405;
 //BA.debugLineNum = 62390405;BA.debugLine="else If job.JobName=\"ht9\" Then  '  i see";
if ((_job._jobname /*String*/ ).equals("ht9")) { 
RDebugUtils.currentLine=62390406;
 //BA.debugLineNum = 62390406;BA.debugLine="Log(job.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("362390406",_job._getstring /*String*/ (null),0);
 }}}}}}}}}
;
RDebugUtils.currentLine=62390408;
 //BA.debugLineNum = 62390408;BA.debugLine="If (Main.backup_page_show<>1)Then";
if ((mostCurrent._main._backup_page_show /*int*/ !=1)) { 
RDebugUtils.currentLine=62390409;
 //BA.debugLineNum = 62390409;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 };
RDebugUtils.currentLine=62390412;
 //BA.debugLineNum = 62390412;BA.debugLine="job.Release";
_job._release /*String*/ (null);
 }else {
RDebugUtils.currentLine=62390416;
 //BA.debugLineNum = 62390416;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\")=True";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=62390418;
 //BA.debugLineNum = 62390418;BA.debugLine="Dim ls_user As List";
_ls_user = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62390419;
 //BA.debugLineNum = 62390419;BA.debugLine="ls_user.Initialize";
_ls_user.Initialize();
RDebugUtils.currentLine=62390420;
 //BA.debugLineNum = 62390420;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAc";
_ls_user = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
RDebugUtils.currentLine=62390422;
 //BA.debugLineNum = 62390422;BA.debugLine="lbl_nameFamili.Text=ls_user.Get(0)";
mostCurrent._lbl_namefamili.setText(BA.ObjectToCharSequence(_ls_user.Get((int) (0))));
RDebugUtils.currentLine=62390423;
 //BA.debugLineNum = 62390423;BA.debugLine="lbl_email.Text=ls_user.Get(1)";
mostCurrent._lbl_email.setText(BA.ObjectToCharSequence(_ls_user.Get((int) (1))));
RDebugUtils.currentLine=62390430;
 //BA.debugLineNum = 62390430;BA.debugLine="Main.phon_num=ls_user.Get(2)";
mostCurrent._main._phon_num /*String*/  = BA.ObjectToString(_ls_user.Get((int) (2)));
RDebugUtils.currentLine=62390431;
 //BA.debugLineNum = 62390431;BA.debugLine="lbl_phoneNum.Text=Main.phon_num";
mostCurrent._lbl_phonenum.setText(BA.ObjectToCharSequence(mostCurrent._main._phon_num /*String*/ ));
RDebugUtils.currentLine=62390433;
 //BA.debugLineNum = 62390433;BA.debugLine="picName=\"user-\"&Main.phon_num&\"-\"&ls_user.Get(";
mostCurrent._picname = "user-"+mostCurrent._main._phon_num /*String*/ +"-"+BA.ObjectToString(_ls_user.Get((int) (4)))+".jpg";
RDebugUtils.currentLine=62390435;
 //BA.debugLineNum = 62390435;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitma";
mostCurrent._img_pofil.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
RDebugUtils.currentLine=62390436;
 //BA.debugLineNum = 62390436;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitm";
mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._picname)).getObject()));
 };
 };
 } 
       catch (Exception e97) {
			processBA.setLastException(e97);RDebugUtils.currentLine=62390444;
 //BA.debugLineNum = 62390444;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("362390444",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=62390445;
 //BA.debugLineNum = 62390445;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=62390448;
 //BA.debugLineNum = 62390448;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_all_msg_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_all_msg_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_all_msg_click", null));}
RDebugUtils.currentLine=63766528;
 //BA.debugLineNum = 63766528;BA.debugLine="Private Sub lbl_all_msg_Click";
RDebugUtils.currentLine=63766529;
 //BA.debugLineNum = 63766529;BA.debugLine="ProgressDialogShow(\"بارگذاری ...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("بارگذاری ..."));
RDebugUtils.currentLine=63766530;
 //BA.debugLineNum = 63766530;BA.debugLine="http_initial_1(7)";
_http_initial_1((int) (7));
RDebugUtils.currentLine=63766531;
 //BA.debugLineNum = 63766531;BA.debugLine="pan_all_show_myMsg.Visible=True";
mostCurrent._pan_all_show_mymsg.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=63766534;
 //BA.debugLineNum = 63766534;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chek_noskhe_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_chek_noskhe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_chek_noskhe_click", null));}
int _result = 0;
RDebugUtils.currentLine=63242240;
 //BA.debugLineNum = 63242240;BA.debugLine="Private Sub lbl_chek_noskhe_Click";
RDebugUtils.currentLine=63242241;
 //BA.debugLineNum = 63242241;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=63242242;
 //BA.debugLineNum = 63242242;BA.debugLine="result = Msgbox2(\"قبلا خرید کرده ام بررسی کنید\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("قبلا خرید کرده ام بررسی کنید"),BA.ObjectToCharSequence("درخواست بررسی"),"ثبت درخواست ","","لغو",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=63242243;
 //BA.debugLineNum = 63242243;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=63242244;
 //BA.debugLineNum = 63242244;BA.debugLine="http_initial_1(4)";
_http_initial_1((int) (4));
 };
RDebugUtils.currentLine=63242246;
 //BA.debugLineNum = 63242246;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_click", null));}
RDebugUtils.currentLine=62586880;
 //BA.debugLineNum = 62586880;BA.debugLine="Private Sub lbl_edit_Click";
RDebugUtils.currentLine=62586883;
 //BA.debugLineNum = 62586883;BA.debugLine="et_nameFamili.Text=	lbl_nameFamili.Text";
mostCurrent._et_namefamili.setText(BA.ObjectToCharSequence(mostCurrent._lbl_namefamili.getText()));
RDebugUtils.currentLine=62586884;
 //BA.debugLineNum = 62586884;BA.debugLine="et_email.Text=lbl_email.Text";
mostCurrent._et_email.setText(BA.ObjectToCharSequence(mostCurrent._lbl_email.getText()));
RDebugUtils.currentLine=62586885;
 //BA.debugLineNum = 62586885;BA.debugLine="comp.Initialize(\"Compressor\")";
_comp.Initialize(processBA,"Compressor");
RDebugUtils.currentLine=62586886;
 //BA.debugLineNum = 62586886;BA.debugLine="comp.Quality=30";
_comp.setQuality((int) (30));
RDebugUtils.currentLine=62586887;
 //BA.debugLineNum = 62586887;BA.debugLine="lbl_image_up.Text=Chr(0xF0EE)";
mostCurrent._lbl_image_up.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf0ee))));
RDebugUtils.currentLine=62586888;
 //BA.debugLineNum = 62586888;BA.debugLine="pan_all_edit.Visible=True";
mostCurrent._pan_all_edit.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=62586893;
 //BA.debugLineNum = 62586893;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_icon_noup_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_icon_noup_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_icon_noup_click", null));}
RDebugUtils.currentLine=63963136;
 //BA.debugLineNum = 63963136;BA.debugLine="Private Sub lbl_icon_noUp_Click";
RDebugUtils.currentLine=63963138;
 //BA.debugLineNum = 63963138;BA.debugLine="File.Delete(Starter.Provider.SharedFolder, tempFil";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._tempfile);
RDebugUtils.currentLine=63963140;
 //BA.debugLineNum = 63963140;BA.debugLine="lbl_icon_up.Text=\"\"";
mostCurrent._lbl_icon_up.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=63963141;
 //BA.debugLineNum = 63963141;BA.debugLine="lbl_icon_noUp.Visible=False";
mostCurrent._lbl_icon_noup.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=63963142;
 //BA.debugLineNum = 63963142;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=62783489;
 //BA.debugLineNum = 62783489;BA.debugLine="Try";
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
RDebugUtils.currentLine=62783490;
 //BA.debugLineNum = 62783490;BA.debugLine="CC.Show(\"image/*\", \"Choose image\")";
parent._cc.Show(processBA,"image/*","Choose image");
RDebugUtils.currentLine=62783492;
 //BA.debugLineNum = 62783492;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As S";
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
RDebugUtils.currentLine=62783493;
 //BA.debugLineNum = 62783493;BA.debugLine="If Success = True Then";
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
RDebugUtils.currentLine=62783495;
 //BA.debugLineNum = 62783495;BA.debugLine="Try";
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
RDebugUtils.currentLine=62783496;
 //BA.debugLineNum = 62783496;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"temp_pic.jpg");
RDebugUtils.currentLine=62783497;
 //BA.debugLineNum = 62783497;BA.debugLine="bmp = comp.compressToBitmap(Starter.Provider.S";
parent.mostCurrent._bmp = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent._comp.compressToBitmap(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"temp_pic.jpg")));
RDebugUtils.currentLine=62783498;
 //BA.debugLineNum = 62783498;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Star";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._picname,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=62783499;
 //BA.debugLineNum = 62783499;BA.debugLine="bmp.WriteToStream(out, 20, \"JPEG\")";
parent.mostCurrent._bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (20),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"JPEG"));
RDebugUtils.currentLine=62783500;
 //BA.debugLineNum = 62783500;BA.debugLine="out.Close";
_out.Close();
 if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 17;
RDebugUtils.currentLine=62783503;
 //BA.debugLineNum = 62783503;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._picname);
RDebugUtils.currentLine=62783504;
 //BA.debugLineNum = 62783504;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("362783504",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 12:
//C
this.state = 15;
this.catchState = 17;
;
RDebugUtils.currentLine=62783507;
 //BA.debugLineNum = 62783507;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitma";
parent.mostCurrent._img_p_edit.setBitmap((android.graphics.Bitmap)(parent.mostCurrent._myfunc._circleimage /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._picname)).getObject()));
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=62783510;
 //BA.debugLineNum = 62783510;BA.debugLine="ToastMessageShow(\"انجام نشد :(\",True)";
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
RDebugUtils.currentLine=62783514;
 //BA.debugLineNum = 62783514;BA.debugLine="ToastMessageShow(\"خطا در بارگزاری\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در بارگزاری"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=62783515;
 //BA.debugLineNum = 62783515;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("362783515",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=62783518;
 //BA.debugLineNum = 62783518;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=62259200;
 //BA.debugLineNum = 62259200;BA.debugLine="Private Sub lbl_logOff_Click";
RDebugUtils.currentLine=62259201;
 //BA.debugLineNum = 62259201;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=62259202;
 //BA.debugLineNum = 62259202;BA.debugLine="result = Msgbox2(\"آیا از حساب خود خارج می شوید؟\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا از حساب خود خارج می شوید؟"),BA.ObjectToCharSequence("توجه"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=62259203;
 //BA.debugLineNum = 62259203;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=62259204;
 //BA.debugLineNum = 62259204;BA.debugLine="File.Delete(File.DirInternal,\"phonNum\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum");
RDebugUtils.currentLine=62259206;
 //BA.debugLineNum = 62259206;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=62259207;
 //BA.debugLineNum = 62259207;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
 };
RDebugUtils.currentLine=62259214;
 //BA.debugLineNum = 62259214;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_reseve_db_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_reseve_db_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_reseve_db_click", null));}
int _result = 0;
RDebugUtils.currentLine=63307776;
 //BA.debugLineNum = 63307776;BA.debugLine="Private Sub lbl_reseve_db_Click";
RDebugUtils.currentLine=63307777;
 //BA.debugLineNum = 63307777;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=63307778;
 //BA.debugLineNum = 63307778;BA.debugLine="result = Msgbox2(\"اطلاعات من از سرور بازیابی شوند";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("اطلاعات من از سرور بازیابی شوند.توجه داشته باشید اطلاعات قبلی حذف می شوند"),BA.ObjectToCharSequence("بازگرداندن اطلاعات "),"مطمئن هستم","","لغو",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=63307779;
 //BA.debugLineNum = 63307779;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=63307780;
 //BA.debugLineNum = 63307780;BA.debugLine="ProgressDialogShow(\"در حال دریافت ...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("در حال دریافت ..."));
RDebugUtils.currentLine=63307781;
 //BA.debugLineNum = 63307781;BA.debugLine="http3.Initialize(\"ht6\", Me)";
mostCurrent._http3._initialize /*String*/ (null,processBA,"ht6",step2_activity.getObject());
RDebugUtils.currentLine=63307782;
 //BA.debugLineNum = 63307782;BA.debugLine="http3.Download(\"https://taravatgroup.ir/uploads_";
mostCurrent._http3._download /*String*/ (null,"https://taravatgroup.ir/uploads_ezaf/"+mostCurrent._main._phon_num /*String*/ +"-db-"+mostCurrent._user_key+".db");
 };
RDebugUtils.currentLine=63307785;
 //BA.debugLineNum = 63307785;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_edit_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_edit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_edit_click", null));}
RDebugUtils.currentLine=62128128;
 //BA.debugLineNum = 62128128;BA.debugLine="Private Sub lbl_save_edit_Click";
RDebugUtils.currentLine=62128129;
 //BA.debugLineNum = 62128129;BA.debugLine="If (myfunc.check_internet=False)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=62128130;
 //BA.debugLineNum = 62128130;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 }else 
{RDebugUtils.currentLine=62128131;
 //BA.debugLineNum = 62128131;BA.debugLine="else If(et_nameFamili.Text=\"\")Then";
if (((mostCurrent._et_namefamili.getText()).equals(""))) { 
RDebugUtils.currentLine=62128132;
 //BA.debugLineNum = 62128132;BA.debugLine="ToastMessageShow(\"قسمت نام خالی است \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("قسمت نام خالی است "),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=62128133;
 //BA.debugLineNum = 62128133;BA.debugLine="Else If(et_email.Text=\"\")Then";
if (((mostCurrent._et_email.getText()).equals(""))) { 
RDebugUtils.currentLine=62128135;
 //BA.debugLineNum = 62128135;BA.debugLine="ToastMessageShow(\"قسمت ایمیل خالی است \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("قسمت ایمیل خالی است "),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=62128136;
 //BA.debugLineNum = 62128136;BA.debugLine="Else If(myfunc.Validate_Email(et_email.Text)=Fals";
if ((mostCurrent._myfunc._validate_email /*boolean*/ (mostCurrent.activityBA,mostCurrent._et_email.getText())==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=62128138;
 //BA.debugLineNum = 62128138;BA.debugLine="ToastMessageShow(\" ایمیل نامعتبر است \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" ایمیل نامعتبر است "),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=62128140;
 //BA.debugLineNum = 62128140;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
 }}}}
;
RDebugUtils.currentLine=62128144;
 //BA.debugLineNum = 62128144;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_db_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_send_db_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_send_db_click", null));}
int _result = 0;
RDebugUtils.currentLine=63373312;
 //BA.debugLineNum = 63373312;BA.debugLine="Private Sub lbl_send_db_Click";
RDebugUtils.currentLine=63373314;
 //BA.debugLineNum = 63373314;BA.debugLine="File.Copy(File.DirInternal,\"db.db\",Starter.Provid";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._main._phon_num /*String*/ +"-db-"+mostCurrent._user_key+".db");
RDebugUtils.currentLine=63373316;
 //BA.debugLineNum = 63373316;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=63373317;
 //BA.debugLineNum = 63373317;BA.debugLine="result = Msgbox2(\"اطلاعات در سرور آنلاین ذخیره شو";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("اطلاعات در سرور آنلاین ذخیره شود؟"),BA.ObjectToCharSequence("بک آپ گیری "),"باشه","","لغو",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=63373318;
 //BA.debugLineNum = 63373318;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=63373320;
 //BA.debugLineNum = 63373320;BA.debugLine="upload_file(Starter.Provider.SharedFolder&\"/\"&Ma";
_upload_file(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ +"/"+mostCurrent._main._phon_num /*String*/ +"-db-"+mostCurrent._user_key+".db");
RDebugUtils.currentLine=63373321;
 //BA.debugLineNum = 63373321;BA.debugLine="pan_progressBar.Visible=True";
mostCurrent._pan_progressbar.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=63373322;
 //BA.debugLineNum = 63373322;BA.debugLine="ProgressBar1.Enabled=True";
mostCurrent._progressbar1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=63373325;
 //BA.debugLineNum = 63373325;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_msg_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_send_msg_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_send_msg_click", null));}
RDebugUtils.currentLine=63176704;
 //BA.debugLineNum = 63176704;BA.debugLine="Private Sub lbl_send_msg_Click";
RDebugUtils.currentLine=63176705;
 //BA.debugLineNum = 63176705;BA.debugLine="pan_all_msg.Visible=True";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=63176708;
 //BA.debugLineNum = 63176708;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_msg_end_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_send_msg_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_send_msg_end_click", null));}
RDebugUtils.currentLine=63569920;
 //BA.debugLineNum = 63569920;BA.debugLine="Private Sub lbl_send_msg_end_Click";
RDebugUtils.currentLine=63569922;
 //BA.debugLineNum = 63569922;BA.debugLine="http_initial_1(5)";
_http_initial_1((int) (5));
RDebugUtils.currentLine=63569924;
 //BA.debugLineNum = 63569924;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_send_msg2_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_send_msg2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_send_msg2_click", null));}
RDebugUtils.currentLine=63897600;
 //BA.debugLineNum = 63897600;BA.debugLine="Private Sub lbl_send_msg2_Click";
RDebugUtils.currentLine=63897601;
 //BA.debugLineNum = 63897601;BA.debugLine="lbl_send_msg_Click";
_lbl_send_msg_click();
RDebugUtils.currentLine=63897602;
 //BA.debugLineNum = 63897602;BA.debugLine="lbl_back_Shmsg_Click";
_lbl_back_shmsg_click();
RDebugUtils.currentLine=63897603;
 //BA.debugLineNum = 63897603;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=63504385;
 //BA.debugLineNum = 63504385;BA.debugLine="Try";
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
RDebugUtils.currentLine=63504386;
 //BA.debugLineNum = 63504386;BA.debugLine="CC.Show(\"image/*\", \"Choose image\")";
parent._cc.Show(processBA,"image/*","Choose image");
RDebugUtils.currentLine=63504388;
 //BA.debugLineNum = 63504388;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As S";
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
RDebugUtils.currentLine=63504389;
 //BA.debugLineNum = 63504389;BA.debugLine="If Success = True Then";
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
RDebugUtils.currentLine=63504393;
 //BA.debugLineNum = 63504393;BA.debugLine="tempFile=Main.phon_num&\"-\"&myfunc.random_id(10)";
parent.mostCurrent._tempfile = parent.mostCurrent._main._phon_num /*String*/ +"-"+parent.mostCurrent._myfunc._random_id /*String*/ (mostCurrent.activityBA,(int) (10))+".jpg";
RDebugUtils.currentLine=63504395;
 //BA.debugLineNum = 63504395;BA.debugLine="Try";
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
RDebugUtils.currentLine=63504398;
 //BA.debugLineNum = 63504398;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"tempimg.jpg");
RDebugUtils.currentLine=63504399;
 //BA.debugLineNum = 63504399;BA.debugLine="bmp = comp.compressToBitmap(Starter.Provider.S";
parent.mostCurrent._bmp = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent._comp.compressToBitmap(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"tempimg.jpg")));
RDebugUtils.currentLine=63504400;
 //BA.debugLineNum = 63504400;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Star";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._tempfile,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=63504401;
 //BA.debugLineNum = 63504401;BA.debugLine="bmp.WriteToStream(out, 50, \"JPEG\")";
parent.mostCurrent._bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (50),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"JPEG"));
RDebugUtils.currentLine=63504402;
 //BA.debugLineNum = 63504402;BA.debugLine="out.Close";
_out.Close();
 if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 17;
RDebugUtils.currentLine=63504407;
 //BA.debugLineNum = 63504407;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,parent.mostCurrent._tempfile);
RDebugUtils.currentLine=63504410;
 //BA.debugLineNum = 63504410;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("363504410",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 12:
//C
this.state = 15;
this.catchState = 17;
;
RDebugUtils.currentLine=63504415;
 //BA.debugLineNum = 63504415;BA.debugLine="lbl_icon_up.Text=Chr(0xF00C)";
parent.mostCurrent._lbl_icon_up.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf00c))));
RDebugUtils.currentLine=63504416;
 //BA.debugLineNum = 63504416;BA.debugLine="lbl_icon_noUp.Visible=True";
parent.mostCurrent._lbl_icon_noup.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=63504418;
 //BA.debugLineNum = 63504418;BA.debugLine="ToastMessageShow(\"انجام نشد :(\",True)";
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
RDebugUtils.currentLine=63504421;
 //BA.debugLineNum = 63504421;BA.debugLine="ToastMessageShow(\"خطا در بارگزاری\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در بارگزاری"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=63504422;
 //BA.debugLineNum = 63504422;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("363504422",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=63504426;
 //BA.debugLineNum = 63504426;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=63700992;
 //BA.debugLineNum = 63700992;BA.debugLine="Private Sub lbl_send_up_icon_Click";
RDebugUtils.currentLine=63700993;
 //BA.debugLineNum = 63700993;BA.debugLine="lbl_send_up_Click";
_lbl_send_up_click();
RDebugUtils.currentLine=63700994;
 //BA.debugLineNum = 63700994;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_transfer_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_transfer_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_transfer_click", null));}
int _result = 0;
RDebugUtils.currentLine=63111168;
 //BA.debugLineNum = 63111168;BA.debugLine="Private Sub lbl_transfer_Click";
RDebugUtils.currentLine=63111170;
 //BA.debugLineNum = 63111170;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=63111171;
 //BA.debugLineNum = 63111171;BA.debugLine="result = Msgbox2(\"درخواست انتقال نسخه طلایی به گو";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("درخواست انتقال نسخه طلایی به گوشی جدید"),BA.ObjectToCharSequence("درخواست انتقال"),"ثبت درخواست ","","لغو",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=63111172;
 //BA.debugLineNum = 63111172;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=63111173;
 //BA.debugLineNum = 63111173;BA.debugLine="http_initial_1(3)";
_http_initial_1((int) (3));
 };
RDebugUtils.currentLine=63111175;
 //BA.debugLineNum = 63111175;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_edit_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_edit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_edit_click", null));}
RDebugUtils.currentLine=62062592;
 //BA.debugLineNum = 62062592;BA.debugLine="Private Sub pan_all_edit_Click";
RDebugUtils.currentLine=62062594;
 //BA.debugLineNum = 62062594;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_msg_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_msg_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_msg_click", null));}
RDebugUtils.currentLine=63438848;
 //BA.debugLineNum = 63438848;BA.debugLine="Private Sub pan_all_msg_Click";
RDebugUtils.currentLine=63438849;
 //BA.debugLineNum = 63438849;BA.debugLine="pan_all_msg.Visible=False";
mostCurrent._pan_all_msg.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=63438850;
 //BA.debugLineNum = 63438850;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_sendbackup_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_sendbackup_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_sendbackup_click", null));}
RDebugUtils.currentLine=64028672;
 //BA.debugLineNum = 64028672;BA.debugLine="Private Sub pan_all_sendBackup_Click";
RDebugUtils.currentLine=64028674;
 //BA.debugLineNum = 64028674;BA.debugLine="End Sub";
return "";
}
public static String  _panel9_click() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel9_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel9_click", null));}
RDebugUtils.currentLine=63635456;
 //BA.debugLineNum = 63635456;BA.debugLine="Private Sub Panel9_Click";
RDebugUtils.currentLine=63635458;
 //BA.debugLineNum = 63635458;BA.debugLine="End Sub";
return "";
}
public static String  _send_backup_func() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "send_backup_func", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "send_backup_func", null));}
RDebugUtils.currentLine=62521344;
 //BA.debugLineNum = 62521344;BA.debugLine="Sub send_backup_func";
RDebugUtils.currentLine=62521346;
 //BA.debugLineNum = 62521346;BA.debugLine="File.Copy(File.DirInternal,\"db.db\",Starter.Provid";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,mostCurrent._main._phon_num /*String*/ +"-db-"+mostCurrent._user_key+".db");
RDebugUtils.currentLine=62521347;
 //BA.debugLineNum = 62521347;BA.debugLine="upload_file(Starter.Provider.SharedFolder&\"/\"&Mai";
_upload_file(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ +"/"+mostCurrent._main._phon_num /*String*/ +"-db-"+mostCurrent._user_key+".db");
RDebugUtils.currentLine=62521348;
 //BA.debugLineNum = 62521348;BA.debugLine="Main.backup_page_show=0";
mostCurrent._main._backup_page_show /*int*/  = (int) (0);
RDebugUtils.currentLine=62521349;
 //BA.debugLineNum = 62521349;BA.debugLine="File.WriteString(File.DirInternal,\"chk_backup.txt";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"chk_backup.txt",mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
RDebugUtils.currentLine=62521351;
 //BA.debugLineNum = 62521351;BA.debugLine="End Sub";
return "";
}
public static String  _tim_send_backup_tick() throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_send_backup_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_send_backup_tick", null));}
RDebugUtils.currentLine=62455808;
 //BA.debugLineNum = 62455808;BA.debugLine="Sub tim_send_backup_Tick";
RDebugUtils.currentLine=62455809;
 //BA.debugLineNum = 62455809;BA.debugLine="send_backup_func";
_send_backup_func();
RDebugUtils.currentLine=62455810;
 //BA.debugLineNum = 62455810;BA.debugLine="tim_send_backup.Enabled=False";
_tim_send_backup.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=62455813;
 //BA.debugLineNum = 62455813;BA.debugLine="ToastMessageShow(\" ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=62455815;
 //BA.debugLineNum = 62455815;BA.debugLine="lbl_back_home_Click";
_lbl_back_home_click();
RDebugUtils.currentLine=62455816;
 //BA.debugLineNum = 62455816;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=62455817;
 //BA.debugLineNum = 62455817;BA.debugLine="End Sub";
return "";
}
public static String  _up_sendfile(String _value) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "up_sendfile", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "up_sendfile", new Object[] {_value}));}
RDebugUtils.currentLine=62980096;
 //BA.debugLineNum = 62980096;BA.debugLine="Sub Up_sendFile (value As String)";
RDebugUtils.currentLine=62980098;
 //BA.debugLineNum = 62980098;BA.debugLine="End Sub";
return "";
}
public static String  _up_statusupload(String _value) throws Exception{
RDebugUtils.currentModule="step2_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "up_statusupload", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "up_statusupload", new Object[] {_value}));}
RDebugUtils.currentLine=63045632;
 //BA.debugLineNum = 63045632;BA.debugLine="Sub Up_statusUpload (value As String)";
RDebugUtils.currentLine=63045634;
 //BA.debugLineNum = 63045634;BA.debugLine="lbl_image_up.Text=value&\" %\"";
mostCurrent._lbl_image_up.setText(BA.ObjectToCharSequence(_value+" %"));
RDebugUtils.currentLine=63045635;
 //BA.debugLineNum = 63045635;BA.debugLine="If(value>=100)Then";
if (((double)(Double.parseDouble(_value))>=100)) { 
RDebugUtils.currentLine=63045636;
 //BA.debugLineNum = 63045636;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=63045638;
 //BA.debugLineNum = 63045638;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=63045639;
 //BA.debugLineNum = 63045639;BA.debugLine="pan_progressBar.Visible=False";
mostCurrent._pan_progressbar.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=63045640;
 //BA.debugLineNum = 63045640;BA.debugLine="lbl_progressBar1.Enabled=False";
mostCurrent._lbl_progressbar1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=63045642;
 //BA.debugLineNum = 63045642;BA.debugLine="ToastMessageShow(\" ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=63045646;
 //BA.debugLineNum = 63045646;BA.debugLine="ProgressBar1.Progress=value";
mostCurrent._progressbar1.setProgress((int)(Double.parseDouble(_value)));
RDebugUtils.currentLine=63045647;
 //BA.debugLineNum = 63045647;BA.debugLine="lbl_progressBar1.Text=value&\"%\"";
mostCurrent._lbl_progressbar1.setText(BA.ObjectToCharSequence(_value+"%"));
 };
RDebugUtils.currentLine=63045654;
 //BA.debugLineNum = 63045654;BA.debugLine="End Sub";
return "";
}
}