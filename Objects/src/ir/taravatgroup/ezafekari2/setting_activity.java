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

public class setting_activity extends Activity implements B4AActivity{
	public static setting_activity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.setting_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (setting_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.setting_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.setting_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (setting_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (setting_activity) Resume **");
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
		return setting_activity.class;
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
            BA.LogInfo("** Activity (setting_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (setting_activity) Pause event (activity is not paused). **");
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
            setting_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (setting_activity) Resume **");
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
public static anywheresoftware.b4a.phone.Phone.ContentChooser _cc = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_colors = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_save_color = null;
public anywheresoftware.b4a.objects.LabelWrapper _tik1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _tik2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _tik3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _tik4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _tik5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _tik6 = null;
public static int _color1 = 0;
public static int _color2 = 0;
public static int _color3 = 0;
public static int _color4 = 0;
public static int _color5 = 0;
public static int _color_index = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_setting = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _sp_font = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_skb_f1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_skb_f2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_skb_f3 = null;
public anywheresoftware.b4a.objects.SeekBarWrapper _skb_f1 = null;
public anywheresoftware.b4a.objects.SeekBarWrapper _skb_f2 = null;
public anywheresoftware.b4a.objects.SeekBarWrapper _skb_f3 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_help = null;
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
 //BA.debugLineNum = 48;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 50;BA.debugLine="Activity.LoadLayout(\"setting_layout\")";
mostCurrent._activity.LoadLayout("setting_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 55;BA.debugLine="pan_hed_setting.Color=Main.color4";
mostCurrent._pan_hed_setting.setColor(mostCurrent._main._color4 /*int*/ );
 //BA.debugLineNum = 56;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 59;BA.debugLine="sp_font.Add(\"یکان\")";
mostCurrent._sp_font.Add("یکان");
 //BA.debugLineNum = 60;BA.debugLine="sp_font.Add(\"نازنین\")";
mostCurrent._sp_font.Add("نازنین");
 //BA.debugLineNum = 61;BA.debugLine="sp_font.Add(\"وزیر\")";
mostCurrent._sp_font.Add("وزیر");
 //BA.debugLineNum = 62;BA.debugLine="sp_font.Add(\"دست نویس\")";
mostCurrent._sp_font.Add("دست نویس");
 //BA.debugLineNum = 63;BA.debugLine="sp_font.Add(\"کودک\")";
mostCurrent._sp_font.Add("کودک");
 //BA.debugLineNum = 66;BA.debugLine="skb_f1.Value=Main.size_f1";
mostCurrent._skb_f1.setValue(mostCurrent._main._size_f1 /*int*/ );
 //BA.debugLineNum = 67;BA.debugLine="skb_f2.Value=Main.size_f2";
mostCurrent._skb_f2.setValue(mostCurrent._main._size_f2 /*int*/ );
 //BA.debugLineNum = 68;BA.debugLine="skb_f3.Value=Main.size_f3";
mostCurrent._skb_f3.setValue(mostCurrent._main._size_f3 /*int*/ );
 //BA.debugLineNum = 70;BA.debugLine="lbl_skb_f1.Text=Main.size_f1";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f1 /*int*/ ));
 //BA.debugLineNum = 71;BA.debugLine="lbl_skb_f2.Text=Main.size_f2";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f2 /*int*/ ));
 //BA.debugLineNum = 72;BA.debugLine="lbl_skb_f3.Text=Main.size_f3";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f3 /*int*/ ));
 //BA.debugLineNum = 76;BA.debugLine="sp_font.SelectedIndex=sp_font.IndexOf(Main.main_f";
mostCurrent._sp_font.setSelectedIndex(mostCurrent._sp_font.IndexOf(mostCurrent._main._main_font /*String*/ ));
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 89;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 90;BA.debugLine="If(pan_all.Visible=True)Then";
if ((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 91;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_all_help.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 94;BA.debugLine="pan_all_help.Visible=False";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_all2.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 96;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 99;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 //BA.debugLineNum = 102;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 104;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 84;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private pan_colors As Panel";
mostCurrent._pan_colors = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private pan_all As Panel";
mostCurrent._pan_all = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private lbl_save_color As Label";
mostCurrent._lbl_save_color = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private tik1 As Label";
mostCurrent._tik1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private tik2 As Label";
mostCurrent._tik2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private tik3 As Label";
mostCurrent._tik3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private tik4 As Label";
mostCurrent._tik4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private tik5 As Label";
mostCurrent._tik5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private tik6 As Label";
mostCurrent._tik6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Dim color1 As Int";
_color1 = 0;
 //BA.debugLineNum = 28;BA.debugLine="Dim color2 As Int";
_color2 = 0;
 //BA.debugLineNum = 29;BA.debugLine="Dim color3 As Int";
_color3 = 0;
 //BA.debugLineNum = 30;BA.debugLine="Dim color4 As Int";
_color4 = 0;
 //BA.debugLineNum = 31;BA.debugLine="Dim color5 As Int";
_color5 = 0;
 //BA.debugLineNum = 35;BA.debugLine="Dim color_index As Int";
_color_index = 0;
 //BA.debugLineNum = 36;BA.debugLine="Private pan_hed_setting As Panel";
mostCurrent._pan_hed_setting = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private sp_font As Spinner";
mostCurrent._sp_font = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private lbl_skb_f1 As Label";
mostCurrent._lbl_skb_f1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private lbl_skb_f2 As Label";
mostCurrent._lbl_skb_f2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private lbl_skb_f3 As Label";
mostCurrent._lbl_skb_f3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private skb_f1 As SeekBar";
mostCurrent._skb_f1 = new anywheresoftware.b4a.objects.SeekBarWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private skb_f2 As SeekBar";
mostCurrent._skb_f2 = new anywheresoftware.b4a.objects.SeekBarWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private skb_f3 As SeekBar";
mostCurrent._skb_f3 = new anywheresoftware.b4a.objects.SeekBarWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private pan_all2 As Panel";
mostCurrent._pan_all2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private pan_all_help As Panel";
mostCurrent._pan_all_help = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 108;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 109;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 110;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_backup_click() throws Exception{
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
 //BA.debugLineNum = 115;BA.debugLine="Private Sub lbl_backup_Click";
 //BA.debugLineNum = 117;BA.debugLine="Dim FileName As String = \"db.db\"";
_filename = "db.db";
 //BA.debugLineNum = 120;BA.debugLine="File.Copy(File.DirInternal, FileName, Starter.Pro";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename,mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename);
 //BA.debugLineNum = 122;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
 //BA.debugLineNum = 123;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
 //BA.debugLineNum = 124;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
 //BA.debugLineNum = 125;BA.debugLine="email.Body = \"backup-\"&DateTime.Date(DateTime.Now";
_email.Body = "backup-"+anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 //BA.debugLineNum = 126;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (_filename));
 //BA.debugLineNum = 128;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
 //BA.debugLineNum = 131;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
 //BA.debugLineNum = 132;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_help_font_click() throws Exception{
 //BA.debugLineNum = 383;BA.debugLine="Private Sub lbl_close_help_font_Click";
 //BA.debugLineNum = 384;BA.debugLine="pan_all_help.Visible=False";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 385;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_color_home_click() throws Exception{
 //BA.debugLineNum = 306;BA.debugLine="Private Sub lbl_color_home_Click";
 //BA.debugLineNum = 307;BA.debugLine="lbl_color1_Click";
_lbl_color1_click();
 //BA.debugLineNum = 308;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_color1_click() throws Exception{
 //BA.debugLineNum = 161;BA.debugLine="Private Sub lbl_color1_Click";
 //BA.debugLineNum = 162;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 164;BA.debugLine="color_index=Main.color_index";
_color_index = mostCurrent._main._color_index /*int*/ ;
 //BA.debugLineNum = 166;BA.debugLine="Select color_index";
switch (_color_index) {
case 1: {
 //BA.debugLineNum = 168;BA.debugLine="pan_color1_Click";
_pan_color1_click();
 break; }
case 2: {
 //BA.debugLineNum = 170;BA.debugLine="pan_color2_Click";
_pan_color2_click();
 break; }
case 3: {
 //BA.debugLineNum = 172;BA.debugLine="pan_color3_Click";
_pan_color3_click();
 break; }
case 4: {
 //BA.debugLineNum = 174;BA.debugLine="pan_color4_Click";
_pan_color4_click();
 break; }
case 5: {
 //BA.debugLineNum = 176;BA.debugLine="pan_color5_Click";
_pan_color5_click();
 break; }
case 6: {
 //BA.debugLineNum = 178;BA.debugLine="pan_color6_Click";
_pan_color6_click();
 break; }
}
;
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_font_pan_click() throws Exception{
 //BA.debugLineNum = 314;BA.debugLine="Private Sub lbl_font_pan_Click";
 //BA.debugLineNum = 315;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 321;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_font_click() throws Exception{
 //BA.debugLineNum = 339;BA.debugLine="Private Sub lbl_help_font_Click";
 //BA.debugLineNum = 344;BA.debugLine="pan_all_help.Visible=True";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 345;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_rest_font_click() throws Exception{
 //BA.debugLineNum = 323;BA.debugLine="Private Sub lbl_rest_font_Click";
 //BA.debugLineNum = 324;BA.debugLine="sp_font.SelectedIndex=0";
mostCurrent._sp_font.setSelectedIndex((int) (0));
 //BA.debugLineNum = 326;BA.debugLine="skb_f1.Value=17";
mostCurrent._skb_f1.setValue((int) (17));
 //BA.debugLineNum = 327;BA.debugLine="skb_f2.Value=15";
mostCurrent._skb_f2.setValue((int) (15));
 //BA.debugLineNum = 328;BA.debugLine="skb_f3.Value=13";
mostCurrent._skb_f3.setValue((int) (13));
 //BA.debugLineNum = 330;BA.debugLine="lbl_skb_f1.Text=17";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(17));
 //BA.debugLineNum = 331;BA.debugLine="lbl_skb_f2.Text=15";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(15));
 //BA.debugLineNum = 332;BA.debugLine="lbl_skb_f3.Text=13";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(13));
 //BA.debugLineNum = 337;BA.debugLine="End Sub";
return "";
}
public static void  _lbl_restore_click() throws Exception{
ResumableSub_lbl_restore_Click rsub = new ResumableSub_lbl_restore_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_lbl_restore_Click extends BA.ResumableSub {
public ResumableSub_lbl_restore_Click(ir.taravatgroup.ezafekari2.setting_activity parent) {
this.parent = parent;
}
ir.taravatgroup.ezafekari2.setting_activity parent;
boolean _success = false;
String _dir = "";
String _filename = "";
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 137;BA.debugLine="cc.Initialize(\"CC\")";
parent._cc.Initialize("CC");
 //BA.debugLineNum = 138;BA.debugLine="cc.Show(\"*/*\", \"انتخاب فایل دیتابیس\")";
parent._cc.Show(processBA,"*/*","انتخاب فایل دیتابیس");
 //BA.debugLineNum = 139;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
anywheresoftware.b4a.keywords.Common.WaitFor("cc_result", processBA, this, null);
this.state = 9;
return;
case 9:
//C
this.state = 1;
_success = (Boolean) result[0];
_dir = (String) result[1];
_filename = (String) result[2];
;
 //BA.debugLineNum = 140;BA.debugLine="If Success Then";
if (true) break;

case 1:
//if
this.state = 8;
if (_success) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 141;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.SharedFo";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db");
 //BA.debugLineNum = 143;BA.debugLine="Log( Dir)";
anywheresoftware.b4a.keywords.Common.LogImpl("721889031",_dir,0);
 //BA.debugLineNum = 144;BA.debugLine="Log(FileName)";
anywheresoftware.b4a.keywords.Common.LogImpl("721889032",_filename,0);
 //BA.debugLineNum = 145;BA.debugLine="Log(File.Exists(Starter.Provider.SharedFolder,\"d";
anywheresoftware.b4a.keywords.Common.LogImpl("721889033",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.File.Exists(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db")),0);
 //BA.debugLineNum = 147;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 149;BA.debugLine="result = Msgbox2(\"دیتای قبلی حذف و دیتای جدید جا";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("دیتای قبلی حذف و دیتای جدید جایگزین می شود."),BA.ObjectToCharSequence("توجه"),"باشه","","نه",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 150;BA.debugLine="If result = DialogResponse.Positive Then";
if (true) break;

case 4:
//if
this.state = 7;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 151;BA.debugLine="File.Copy(Starter.Provider.SharedFolder,\"db2.db";
anywheresoftware.b4a.keywords.Common.File.Copy(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db");
 //BA.debugLineNum = 152;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._main.getObject()));
 //BA.debugLineNum = 153;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 if (true) break;

case 7:
//C
this.state = 8;
;
 if (true) break;

case 8:
//C
this.state = -1;
;
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _cc_result(boolean _success,String _dir,String _filename) throws Exception{
}
public static String  _lbl_save_color_click() throws Exception{
 //BA.debugLineNum = 280;BA.debugLine="Private Sub lbl_save_color_Click";
 //BA.debugLineNum = 281;BA.debugLine="Main.color1=color1";
mostCurrent._main._color1 /*int*/  = _color1;
 //BA.debugLineNum = 282;BA.debugLine="Main.color2=color2";
mostCurrent._main._color2 /*int*/  = _color2;
 //BA.debugLineNum = 283;BA.debugLine="Main.color3=color3";
mostCurrent._main._color3 /*int*/  = _color3;
 //BA.debugLineNum = 284;BA.debugLine="Main.color4=color4";
mostCurrent._main._color4 /*int*/  = _color4;
 //BA.debugLineNum = 285;BA.debugLine="Main.color5=color5";
mostCurrent._main._color5 /*int*/  = _color5;
 //BA.debugLineNum = 286;BA.debugLine="Main.color_index=color_index";
mostCurrent._main._color_index /*int*/  = _color_index;
 //BA.debugLineNum = 288;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(mostCurrent._main._color1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color2 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color_index /*int*/ )+","+BA.NumberToString(mostCurrent._main._color3 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color4 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color5 /*int*/ )+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._main._main_font /*String*/ +","+BA.NumberToString(mostCurrent._main._size_f1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._size_f2 /*int*/ )+","+BA.NumberToString(mostCurrent._main._size_f3 /*int*/ ));
 //BA.debugLineNum = 290;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 291;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 295;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_font_click() throws Exception{
 //BA.debugLineNum = 347;BA.debugLine="Private Sub lbl_save_font_Click";
 //BA.debugLineNum = 351;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(mostCurrent._main._color1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color2 /*int*/ )+","+BA.NumberToString(_color_index)+","+BA.NumberToString(mostCurrent._main._color3 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color4 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color5 /*int*/ )+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._sp_font.getSelectedItem()+","+BA.NumberToString(mostCurrent._skb_f1.getValue())+","+BA.NumberToString(mostCurrent._skb_f2.getValue())+","+BA.NumberToString(mostCurrent._skb_f3.getValue()));
 //BA.debugLineNum = 355;BA.debugLine="pan_all2_Click";
_pan_all2_click();
 //BA.debugLineNum = 356;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 360;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_click() throws Exception{
 //BA.debugLineNum = 187;BA.debugLine="Private Sub pan_all_Click";
 //BA.debugLineNum = 188;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all2_click() throws Exception{
 //BA.debugLineNum = 374;BA.debugLine="Private Sub pan_all2_Click";
 //BA.debugLineNum = 375;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 376;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color1_click() throws Exception{
 //BA.debugLineNum = 266;BA.debugLine="Private Sub pan_color1_Click";
 //BA.debugLineNum = 267;BA.debugLine="tik_all_dis";
_tik_all_dis();
 //BA.debugLineNum = 268;BA.debugLine="color1=0XFF69AC00";
_color1 = ((int)0xff69ac00);
 //BA.debugLineNum = 269;BA.debugLine="color2=0xFF00C7C7";
_color2 = ((int)0xff00c7c7);
 //BA.debugLineNum = 270;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 271;BA.debugLine="color4=0XFF69AC00";
_color4 = ((int)0xff69ac00);
 //BA.debugLineNum = 272;BA.debugLine="color5=0xFF00C7C7";
_color5 = ((int)0xff00c7c7);
 //BA.debugLineNum = 275;BA.debugLine="color_index=1";
_color_index = (int) (1);
 //BA.debugLineNum = 276;BA.debugLine="tik1.Visible=True";
mostCurrent._tik1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 278;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color2_click() throws Exception{
 //BA.debugLineNum = 251;BA.debugLine="Private Sub pan_color2_Click";
 //BA.debugLineNum = 252;BA.debugLine="tik_all_dis";
_tik_all_dis();
 //BA.debugLineNum = 253;BA.debugLine="color1 = 0xFF7F19EE";
_color1 = ((int)0xff7f19ee);
 //BA.debugLineNum = 254;BA.debugLine="color2 = 0xFF567BFF";
_color2 = ((int)0xff567bff);
 //BA.debugLineNum = 255;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 256;BA.debugLine="color4=0xFF567BFF";
_color4 = ((int)0xff567bff);
 //BA.debugLineNum = 257;BA.debugLine="color5=0xFF567BFF";
_color5 = ((int)0xff567bff);
 //BA.debugLineNum = 261;BA.debugLine="color_index=2";
_color_index = (int) (2);
 //BA.debugLineNum = 262;BA.debugLine="tik2.Visible=True";
mostCurrent._tik2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 264;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color3_click() throws Exception{
 //BA.debugLineNum = 236;BA.debugLine="Private Sub pan_color3_Click";
 //BA.debugLineNum = 237;BA.debugLine="tik_all_dis";
_tik_all_dis();
 //BA.debugLineNum = 238;BA.debugLine="color1 = 0xFF2BC1F6";
_color1 = ((int)0xff2bc1f6);
 //BA.debugLineNum = 239;BA.debugLine="color2 = 0xFF1E45D1";
_color2 = ((int)0xff1e45d1);
 //BA.debugLineNum = 240;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 241;BA.debugLine="color4=0xFF2BC1F6";
_color4 = ((int)0xff2bc1f6);
 //BA.debugLineNum = 242;BA.debugLine="color5=0xFF1E45D1";
_color5 = ((int)0xff1e45d1);
 //BA.debugLineNum = 247;BA.debugLine="color_index=3";
_color_index = (int) (3);
 //BA.debugLineNum = 248;BA.debugLine="tik3.Visible=True";
mostCurrent._tik3.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 249;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color4_click() throws Exception{
 //BA.debugLineNum = 221;BA.debugLine="Private Sub pan_color4_Click";
 //BA.debugLineNum = 222;BA.debugLine="tik_all_dis";
_tik_all_dis();
 //BA.debugLineNum = 223;BA.debugLine="color1 = 0xFFDD00FF";
_color1 = ((int)0xffdd00ff);
 //BA.debugLineNum = 224;BA.debugLine="color2 = 0xFF0090FF";
_color2 = ((int)0xff0090ff);
 //BA.debugLineNum = 225;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 226;BA.debugLine="color4=0xFFDD00FF";
_color4 = ((int)0xffdd00ff);
 //BA.debugLineNum = 227;BA.debugLine="color5=0xFF24EB9D";
_color5 = ((int)0xff24eb9d);
 //BA.debugLineNum = 232;BA.debugLine="color_index=4";
_color_index = (int) (4);
 //BA.debugLineNum = 233;BA.debugLine="tik4.Visible=True";
mostCurrent._tik4.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 234;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color5_click() throws Exception{
 //BA.debugLineNum = 207;BA.debugLine="Private Sub pan_color5_Click";
 //BA.debugLineNum = 208;BA.debugLine="tik_all_dis";
_tik_all_dis();
 //BA.debugLineNum = 209;BA.debugLine="color1 = 0xFFCF5263";
_color1 = ((int)0xffcf5263);
 //BA.debugLineNum = 210;BA.debugLine="color2 = 0xFFABC01A";
_color2 = ((int)0xffabc01a);
 //BA.debugLineNum = 211;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 212;BA.debugLine="color4=0xFFCF5263";
_color4 = ((int)0xffcf5263);
 //BA.debugLineNum = 213;BA.debugLine="color5=0xFFABC01A";
_color5 = ((int)0xffabc01a);
 //BA.debugLineNum = 217;BA.debugLine="color_index=5";
_color_index = (int) (5);
 //BA.debugLineNum = 218;BA.debugLine="tik5.Visible=True";
mostCurrent._tik5.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 219;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color6_click() throws Exception{
 //BA.debugLineNum = 192;BA.debugLine="Private Sub pan_color6_Click";
 //BA.debugLineNum = 193;BA.debugLine="tik_all_dis";
_tik_all_dis();
 //BA.debugLineNum = 194;BA.debugLine="color1= 0xFF5289CF";
_color1 = ((int)0xff5289cf);
 //BA.debugLineNum = 195;BA.debugLine="color2= 0xFFABC01A";
_color2 = ((int)0xffabc01a);
 //BA.debugLineNum = 196;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 197;BA.debugLine="color4=0xFF5289CF";
_color4 = ((int)0xff5289cf);
 //BA.debugLineNum = 198;BA.debugLine="color5=0xFFABC01A";
_color5 = ((int)0xffabc01a);
 //BA.debugLineNum = 203;BA.debugLine="color_index=6";
_color_index = (int) (6);
 //BA.debugLineNum = 204;BA.debugLine="tik6.Visible=True";
mostCurrent._tik6.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 205;BA.debugLine="End Sub";
return "";
}
public static String  _pan_colors_click() throws Exception{
 //BA.debugLineNum = 310;BA.debugLine="Private Sub pan_colors_Click";
 //BA.debugLineNum = 312;BA.debugLine="End Sub";
return "";
}
public static String  _pan_font_click() throws Exception{
 //BA.debugLineNum = 378;BA.debugLine="Private Sub pan_font_Click";
 //BA.debugLineNum = 380;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private cc As ContentChooser";
_cc = new anywheresoftware.b4a.phone.Phone.ContentChooser();
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f1_valuechanged(int _value,boolean _userchanged) throws Exception{
 //BA.debugLineNum = 370;BA.debugLine="Private Sub skb_f1_ValueChanged (Value As Int, Use";
 //BA.debugLineNum = 371;BA.debugLine="lbl_skb_f1.Text=Value";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(_value));
 //BA.debugLineNum = 372;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f2_valuechanged(int _value,boolean _userchanged) throws Exception{
 //BA.debugLineNum = 366;BA.debugLine="Private Sub skb_f2_ValueChanged (Value As Int, Use";
 //BA.debugLineNum = 367;BA.debugLine="lbl_skb_f2.Text=Value";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(_value));
 //BA.debugLineNum = 368;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f3_valuechanged(int _value,boolean _userchanged) throws Exception{
 //BA.debugLineNum = 362;BA.debugLine="Private Sub skb_f3_ValueChanged (Value As Int, Use";
 //BA.debugLineNum = 363;BA.debugLine="lbl_skb_f3.Text=Value";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(_value));
 //BA.debugLineNum = 364;BA.debugLine="End Sub";
return "";
}
public static String  _tik_all_dis() throws Exception{
 //BA.debugLineNum = 297;BA.debugLine="Sub tik_all_dis";
 //BA.debugLineNum = 298;BA.debugLine="tik1.Visible=False";
mostCurrent._tik1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 299;BA.debugLine="tik2.Visible=False";
mostCurrent._tik2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 300;BA.debugLine="tik3.Visible=False";
mostCurrent._tik3.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 301;BA.debugLine="tik4.Visible=False";
mostCurrent._tik4.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 302;BA.debugLine="tik5.Visible=False";
mostCurrent._tik5.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 303;BA.debugLine="tik6.Visible=False";
mostCurrent._tik6.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 304;BA.debugLine="End Sub";
return "";
}
}
