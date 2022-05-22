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

public class show_gozaresh_activity extends Activity implements B4AActivity{
	public static show_gozaresh_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.show_gozaresh_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (show_gozaresh_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.show_gozaresh_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.show_gozaresh_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (show_gozaresh_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (show_gozaresh_activity) Resume **");
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
		return show_gozaresh_activity.class;
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
            BA.LogInfo("** Activity (show_gozaresh_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (show_gozaresh_activity) Pause event (activity is not paused). **");
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
            show_gozaresh_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (show_gozaresh_activity) Resume **");
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
public anywheresoftware.b4a.objects.WebViewWrapper _webview_gozaresh = null;
public static String _str_file_title = "";
public static String _str_file_matn = "";
public ir.taravatgroup.ezafekari2.b4xloadingindicator _b4xloadingindicator1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_show_gozaresh = null;
public anywheresoftware.b4a.objects.PdfDocumentWrapper.Printer _printer = null;
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
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
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="show_gozaresh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=28770304;
 //BA.debugLineNum = 28770304;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=28770306;
 //BA.debugLineNum = 28770306;BA.debugLine="Activity.LoadLayout(\"show_gozaresh_layout\")";
mostCurrent._activity.LoadLayout("show_gozaresh_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=28770307;
 //BA.debugLineNum = 28770307;BA.debugLine="Main.time_page_load.Initialize(\"time_page_load\",1";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .Initialize(processBA,"time_page_load",(long) (1500));
RDebugUtils.currentLine=28770308;
 //BA.debugLineNum = 28770308;BA.debugLine="Main.time_page_load.Enabled=True";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=28770309;
 //BA.debugLineNum = 28770309;BA.debugLine="B4XLoadingIndicator1.Show";
mostCurrent._b4xloadingindicator1._show /*String*/ (null);
RDebugUtils.currentLine=28770325;
 //BA.debugLineNum = 28770325;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=28770326;
 //BA.debugLineNum = 28770326;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE id="+BA.NumberToString(mostCurrent._main._current_gozaresh_id /*int*/ ))));
RDebugUtils.currentLine=28770327;
 //BA.debugLineNum = 28770327;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=28770330;
 //BA.debugLineNum = 28770330;BA.debugLine="str_file_title=dbCode.res.GetString(\"title\")";
mostCurrent._str_file_title = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title");
RDebugUtils.currentLine=28770331;
 //BA.debugLineNum = 28770331;BA.debugLine="str_file_matn=dbCode.res.GetString(\"gozaresh\")";
mostCurrent._str_file_matn = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("gozaresh");
RDebugUtils.currentLine=28770333;
 //BA.debugLineNum = 28770333;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=28770334;
 //BA.debugLineNum = 28770334;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=28770336;
 //BA.debugLineNum = 28770336;BA.debugLine="WebView_gozaresh.LoadHtml(str_file_matn)";
mostCurrent._webview_gozaresh.LoadHtml(mostCurrent._str_file_matn);
RDebugUtils.currentLine=28770339;
 //BA.debugLineNum = 28770339;BA.debugLine="pan_hed_show_gozaresh.Color=Main.color4";
mostCurrent._pan_hed_show_gozaresh.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=28770340;
 //BA.debugLineNum = 28770340;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=28770342;
 //BA.debugLineNum = 28770342;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="show_gozaresh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=29097984;
 //BA.debugLineNum = 29097984;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=29097985;
 //BA.debugLineNum = 29097985;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=29097986;
 //BA.debugLineNum = 29097986;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=29097987;
 //BA.debugLineNum = 29097987;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=29097989;
 //BA.debugLineNum = 29097989;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=29097991;
 //BA.debugLineNum = 29097991;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="show_gozaresh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=29032448;
 //BA.debugLineNum = 29032448;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=29032450;
 //BA.debugLineNum = 29032450;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=29032451;
 //BA.debugLineNum = 29032451;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="show_gozaresh_activity";
RDebugUtils.currentLine=28966912;
 //BA.debugLineNum = 28966912;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=28966914;
 //BA.debugLineNum = 28966914;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="show_gozaresh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=28901376;
 //BA.debugLineNum = 28901376;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=28901378;
 //BA.debugLineNum = 28901378;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_print_click() throws Exception{
RDebugUtils.currentModule="show_gozaresh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_print_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_print_click", null));}
RDebugUtils.currentLine=29229056;
 //BA.debugLineNum = 29229056;BA.debugLine="Private Sub lbl_print_Click";
RDebugUtils.currentLine=29229058;
 //BA.debugLineNum = 29229058;BA.debugLine="printer.Initialize(\"\")";
mostCurrent._printer.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=29229061;
 //BA.debugLineNum = 29229061;BA.debugLine="printer.PrintWebView(\"job\",WebView_gozaresh)";
mostCurrent._printer.PrintWebView("job",(android.webkit.WebView)(mostCurrent._webview_gozaresh.getObject()));
RDebugUtils.currentLine=29229062;
 //BA.debugLineNum = 29229062;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_click() throws Exception{
RDebugUtils.currentModule="show_gozaresh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_share_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_share_click", null));}
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
RDebugUtils.currentLine=29163520;
 //BA.debugLineNum = 29163520;BA.debugLine="Private Sub lbl_share_Click";
RDebugUtils.currentLine=29163521;
 //BA.debugLineNum = 29163521;BA.debugLine="Dim FileName As String =Main.current_gozaresh_id&";
_filename = BA.NumberToString(mostCurrent._main._current_gozaresh_id /*int*/ )+".html";
RDebugUtils.currentLine=29163524;
 //BA.debugLineNum = 29163524;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
anywheresoftware.b4a.keywords.Common.File.WriteString(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename,mostCurrent._str_file_matn);
RDebugUtils.currentLine=29163526;
 //BA.debugLineNum = 29163526;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=29163527;
 //BA.debugLineNum = 29163527;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
RDebugUtils.currentLine=29163528;
 //BA.debugLineNum = 29163528;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
RDebugUtils.currentLine=29163529;
 //BA.debugLineNum = 29163529;BA.debugLine="email.Body = \" گزارش حقوق \"&str_file_title&CRLF&\"";
_email.Body = " گزارش حقوق "+mostCurrent._str_file_title+anywheresoftware.b4a.keywords.Common.CRLF+"اپلیکیشن اضافه کاری من"+anywheresoftware.b4a.keywords.Common.CRLF+"دانلود از بازار";
RDebugUtils.currentLine=29163530;
 //BA.debugLineNum = 29163530;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (null,_filename));
RDebugUtils.currentLine=29163532;
 //BA.debugLineNum = 29163532;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
RDebugUtils.currentLine=29163533;
 //BA.debugLineNum = 29163533;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
RDebugUtils.currentLine=29163534;
 //BA.debugLineNum = 29163534;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
RDebugUtils.currentLine=29163535;
 //BA.debugLineNum = 29163535;BA.debugLine="End Sub";
return "";
}
public static String  _time_page_load_tick() throws Exception{
RDebugUtils.currentModule="show_gozaresh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time_page_load_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "time_page_load_tick", null));}
RDebugUtils.currentLine=28835840;
 //BA.debugLineNum = 28835840;BA.debugLine="Sub time_page_load_Tick";
RDebugUtils.currentLine=28835841;
 //BA.debugLineNum = 28835841;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=28835842;
 //BA.debugLineNum = 28835842;BA.debugLine="B4XLoadingIndicator1.Hide";
mostCurrent._b4xloadingindicator1._hide /*String*/ (null);
RDebugUtils.currentLine=28835843;
 //BA.debugLineNum = 28835843;BA.debugLine="Main.time_page_load.Enabled=False";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=28835844;
 //BA.debugLineNum = 28835844;BA.debugLine="End Sub";
return "";
}
}