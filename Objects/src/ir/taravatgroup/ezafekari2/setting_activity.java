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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.setting_activity");
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



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
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
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _togglebtn_offon_lock = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _togglebtn_finger = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_pass_lock = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_lock = null;
public ir.taravatgroup.ezafekari2.fingerprintmanager _fingerprint1 = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _sc_view_items = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_hint_lock = null;
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
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=31916032;
 //BA.debugLineNum = 31916032;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=31916034;
 //BA.debugLineNum = 31916034;BA.debugLine="Activity.LoadLayout(\"setting_layout\")";
mostCurrent._activity.LoadLayout("setting_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=31916035;
 //BA.debugLineNum = 31916035;BA.debugLine="sc_view_items.Panel.LoadLayout(\"setting_layout_it";
mostCurrent._sc_view_items.getPanel().LoadLayout("setting_layout_items",mostCurrent.activityBA);
RDebugUtils.currentLine=31916039;
 //BA.debugLineNum = 31916039;BA.debugLine="pan_hed_setting.Color=Main.color4";
mostCurrent._pan_hed_setting.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=31916040;
 //BA.debugLineNum = 31916040;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=31916043;
 //BA.debugLineNum = 31916043;BA.debugLine="sp_font.Add(\"یکان\")";
mostCurrent._sp_font.Add("یکان");
RDebugUtils.currentLine=31916044;
 //BA.debugLineNum = 31916044;BA.debugLine="sp_font.Add(\"نازنین\")";
mostCurrent._sp_font.Add("نازنین");
RDebugUtils.currentLine=31916045;
 //BA.debugLineNum = 31916045;BA.debugLine="sp_font.Add(\"وزیر\")";
mostCurrent._sp_font.Add("وزیر");
RDebugUtils.currentLine=31916046;
 //BA.debugLineNum = 31916046;BA.debugLine="sp_font.Add(\"دست نویس\")";
mostCurrent._sp_font.Add("دست نویس");
RDebugUtils.currentLine=31916047;
 //BA.debugLineNum = 31916047;BA.debugLine="sp_font.Add(\"کودک\")";
mostCurrent._sp_font.Add("کودک");
RDebugUtils.currentLine=31916050;
 //BA.debugLineNum = 31916050;BA.debugLine="skb_f1.Value=Main.size_f1";
mostCurrent._skb_f1.setValue(mostCurrent._main._size_f1 /*int*/ );
RDebugUtils.currentLine=31916051;
 //BA.debugLineNum = 31916051;BA.debugLine="skb_f2.Value=Main.size_f2";
mostCurrent._skb_f2.setValue(mostCurrent._main._size_f2 /*int*/ );
RDebugUtils.currentLine=31916052;
 //BA.debugLineNum = 31916052;BA.debugLine="skb_f3.Value=Main.size_f3";
mostCurrent._skb_f3.setValue(mostCurrent._main._size_f3 /*int*/ );
RDebugUtils.currentLine=31916054;
 //BA.debugLineNum = 31916054;BA.debugLine="lbl_skb_f1.Text=Main.size_f1";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f1 /*int*/ ));
RDebugUtils.currentLine=31916055;
 //BA.debugLineNum = 31916055;BA.debugLine="lbl_skb_f2.Text=Main.size_f2";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f2 /*int*/ ));
RDebugUtils.currentLine=31916056;
 //BA.debugLineNum = 31916056;BA.debugLine="lbl_skb_f3.Text=Main.size_f3";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f3 /*int*/ ));
RDebugUtils.currentLine=31916060;
 //BA.debugLineNum = 31916060;BA.debugLine="sp_font.SelectedIndex=sp_font.IndexOf(Main.main_f";
mostCurrent._sp_font.setSelectedIndex(mostCurrent._sp_font.IndexOf(mostCurrent._main._main_font /*String*/ ));
RDebugUtils.currentLine=31916062;
 //BA.debugLineNum = 31916062;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=32112640;
 //BA.debugLineNum = 32112640;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=32112641;
 //BA.debugLineNum = 32112641;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=32112642;
 //BA.debugLineNum = 32112642;BA.debugLine="If(pan_all.Visible=True)Then";
if ((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=32112643;
 //BA.debugLineNum = 32112643;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=32112645;
 //BA.debugLineNum = 32112645;BA.debugLine="Else If (pan_all_help.Visible=True) Then";
if ((mostCurrent._pan_all_help.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=32112646;
 //BA.debugLineNum = 32112646;BA.debugLine="pan_all_help.Visible=False";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=32112647;
 //BA.debugLineNum = 32112647;BA.debugLine="Else If (pan_all2.Visible=True)Then";
if ((mostCurrent._pan_all2.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=32112648;
 //BA.debugLineNum = 32112648;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=32112649;
 //BA.debugLineNum = 32112649;BA.debugLine="Else If(pan_all_lock.Visible=True)Then";
if ((mostCurrent._pan_all_lock.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=32112650;
 //BA.debugLineNum = 32112650;BA.debugLine="pan_all_lock.Visible=False";
mostCurrent._pan_all_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=32112652;
 //BA.debugLineNum = 32112652;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 }}}}
;
RDebugUtils.currentLine=32112655;
 //BA.debugLineNum = 32112655;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=32112657;
 //BA.debugLineNum = 32112657;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=32112659;
 //BA.debugLineNum = 32112659;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=32178176;
 //BA.debugLineNum = 32178176;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=32178177;
 //BA.debugLineNum = 32178177;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=32178178;
 //BA.debugLineNum = 32178178;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=32178179;
 //BA.debugLineNum = 32178179;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="setting_activity";
RDebugUtils.currentLine=32047104;
 //BA.debugLineNum = 32047104;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=32047106;
 //BA.debugLineNum = 32047106;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=31981568;
 //BA.debugLineNum = 31981568;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=31981570;
 //BA.debugLineNum = 31981570;BA.debugLine="End Sub";
return "";
}
public static String  _et_pass_lock_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_pass_lock_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_pass_lock_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=33947648;
 //BA.debugLineNum = 33947648;BA.debugLine="Private Sub et_pass_lock_TextChanged (Old As Strin";
RDebugUtils.currentLine=33947649;
 //BA.debugLineNum = 33947649;BA.debugLine="If(New.Length>4)Then";
if ((_new.length()>4)) { 
RDebugUtils.currentLine=33947650;
 //BA.debugLineNum = 33947650;BA.debugLine="ToastMessageShow(\"رمز فقط 4 رقم باشد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("رمز فقط 4 رقم باشد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33947651;
 //BA.debugLineNum = 33947651;BA.debugLine="et_pass_lock.Text=Old";
mostCurrent._et_pass_lock.setText(BA.ObjectToCharSequence(_old));
 };
RDebugUtils.currentLine=33947653;
 //BA.debugLineNum = 33947653;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_backup_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_backup_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_backup_click", null));}
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
RDebugUtils.currentLine=32243712;
 //BA.debugLineNum = 32243712;BA.debugLine="Private Sub lbl_backup_Click";
RDebugUtils.currentLine=32243714;
 //BA.debugLineNum = 32243714;BA.debugLine="Dim FileName As String = \"db.db\"";
_filename = "db.db";
RDebugUtils.currentLine=32243717;
 //BA.debugLineNum = 32243717;BA.debugLine="File.Copy(File.DirInternal, FileName, Starter.Pro";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename,mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename);
RDebugUtils.currentLine=32243719;
 //BA.debugLineNum = 32243719;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=32243720;
 //BA.debugLineNum = 32243720;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
RDebugUtils.currentLine=32243721;
 //BA.debugLineNum = 32243721;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
RDebugUtils.currentLine=32243722;
 //BA.debugLineNum = 32243722;BA.debugLine="email.Body = \"backup-\"&DateTime.Date(DateTime.Now";
_email.Body = "backup-"+anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=32243723;
 //BA.debugLineNum = 32243723;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (null,_filename));
RDebugUtils.currentLine=32243725;
 //BA.debugLineNum = 32243725;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
RDebugUtils.currentLine=32243728;
 //BA.debugLineNum = 32243728;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
RDebugUtils.currentLine=32243729;
 //BA.debugLineNum = 32243729;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
RDebugUtils.currentLine=32243731;
 //BA.debugLineNum = 32243731;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_help_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_help_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_help_font_click", null));}
RDebugUtils.currentLine=33751040;
 //BA.debugLineNum = 33751040;BA.debugLine="Private Sub lbl_close_help_font_Click";
RDebugUtils.currentLine=33751041;
 //BA.debugLineNum = 33751041;BA.debugLine="pan_all_help.Visible=False";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33751042;
 //BA.debugLineNum = 33751042;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_color_home_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_color_home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_color_home_click", null));}
RDebugUtils.currentLine=33030144;
 //BA.debugLineNum = 33030144;BA.debugLine="Private Sub lbl_color_home_Click";
RDebugUtils.currentLine=33030145;
 //BA.debugLineNum = 33030145;BA.debugLine="lbl_color1_Click";
_lbl_color1_click();
RDebugUtils.currentLine=33030146;
 //BA.debugLineNum = 33030146;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_color1_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_color1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_color1_click", null));}
RDebugUtils.currentLine=32374784;
 //BA.debugLineNum = 32374784;BA.debugLine="Private Sub lbl_color1_Click";
RDebugUtils.currentLine=32374785;
 //BA.debugLineNum = 32374785;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=32374787;
 //BA.debugLineNum = 32374787;BA.debugLine="color_index=Main.color_index";
_color_index = mostCurrent._main._color_index /*int*/ ;
RDebugUtils.currentLine=32374789;
 //BA.debugLineNum = 32374789;BA.debugLine="Select color_index";
switch (_color_index) {
case 1: {
RDebugUtils.currentLine=32374791;
 //BA.debugLineNum = 32374791;BA.debugLine="pan_color1_Click";
_pan_color1_click();
 break; }
case 2: {
RDebugUtils.currentLine=32374793;
 //BA.debugLineNum = 32374793;BA.debugLine="pan_color2_Click";
_pan_color2_click();
 break; }
case 3: {
RDebugUtils.currentLine=32374795;
 //BA.debugLineNum = 32374795;BA.debugLine="pan_color3_Click";
_pan_color3_click();
 break; }
case 4: {
RDebugUtils.currentLine=32374797;
 //BA.debugLineNum = 32374797;BA.debugLine="pan_color4_Click";
_pan_color4_click();
 break; }
case 5: {
RDebugUtils.currentLine=32374799;
 //BA.debugLineNum = 32374799;BA.debugLine="pan_color5_Click";
_pan_color5_click();
 break; }
case 6: {
RDebugUtils.currentLine=32374801;
 //BA.debugLineNum = 32374801;BA.debugLine="pan_color6_Click";
_pan_color6_click();
 break; }
}
;
RDebugUtils.currentLine=32374808;
 //BA.debugLineNum = 32374808;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color1_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color1_click", null));}
RDebugUtils.currentLine=32833536;
 //BA.debugLineNum = 32833536;BA.debugLine="Private Sub pan_color1_Click";
RDebugUtils.currentLine=32833537;
 //BA.debugLineNum = 32833537;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=32833538;
 //BA.debugLineNum = 32833538;BA.debugLine="color1=0XFF69AC00";
_color1 = ((int)0xff69ac00);
RDebugUtils.currentLine=32833539;
 //BA.debugLineNum = 32833539;BA.debugLine="color2=0xFF00C7C7";
_color2 = ((int)0xff00c7c7);
RDebugUtils.currentLine=32833540;
 //BA.debugLineNum = 32833540;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=32833541;
 //BA.debugLineNum = 32833541;BA.debugLine="color4=0XFF69AC00";
_color4 = ((int)0xff69ac00);
RDebugUtils.currentLine=32833542;
 //BA.debugLineNum = 32833542;BA.debugLine="color5=0xFF00C7C7";
_color5 = ((int)0xff00c7c7);
RDebugUtils.currentLine=32833545;
 //BA.debugLineNum = 32833545;BA.debugLine="color_index=1";
_color_index = (int) (1);
RDebugUtils.currentLine=32833546;
 //BA.debugLineNum = 32833546;BA.debugLine="tik1.Visible=True";
mostCurrent._tik1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=32833548;
 //BA.debugLineNum = 32833548;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color2_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color2_click", null));}
RDebugUtils.currentLine=32768000;
 //BA.debugLineNum = 32768000;BA.debugLine="Private Sub pan_color2_Click";
RDebugUtils.currentLine=32768001;
 //BA.debugLineNum = 32768001;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=32768002;
 //BA.debugLineNum = 32768002;BA.debugLine="color1 = 0xFF7F19EE";
_color1 = ((int)0xff7f19ee);
RDebugUtils.currentLine=32768003;
 //BA.debugLineNum = 32768003;BA.debugLine="color2 = 0xFF567BFF";
_color2 = ((int)0xff567bff);
RDebugUtils.currentLine=32768004;
 //BA.debugLineNum = 32768004;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=32768005;
 //BA.debugLineNum = 32768005;BA.debugLine="color4=0xFF567BFF";
_color4 = ((int)0xff567bff);
RDebugUtils.currentLine=32768006;
 //BA.debugLineNum = 32768006;BA.debugLine="color5=0xFF567BFF";
_color5 = ((int)0xff567bff);
RDebugUtils.currentLine=32768010;
 //BA.debugLineNum = 32768010;BA.debugLine="color_index=2";
_color_index = (int) (2);
RDebugUtils.currentLine=32768011;
 //BA.debugLineNum = 32768011;BA.debugLine="tik2.Visible=True";
mostCurrent._tik2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=32768013;
 //BA.debugLineNum = 32768013;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color3_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color3_click", null));}
RDebugUtils.currentLine=32702464;
 //BA.debugLineNum = 32702464;BA.debugLine="Private Sub pan_color3_Click";
RDebugUtils.currentLine=32702465;
 //BA.debugLineNum = 32702465;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=32702466;
 //BA.debugLineNum = 32702466;BA.debugLine="color1 = 0xFF2BC1F6";
_color1 = ((int)0xff2bc1f6);
RDebugUtils.currentLine=32702467;
 //BA.debugLineNum = 32702467;BA.debugLine="color2 = 0xFF1E45D1";
_color2 = ((int)0xff1e45d1);
RDebugUtils.currentLine=32702468;
 //BA.debugLineNum = 32702468;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=32702469;
 //BA.debugLineNum = 32702469;BA.debugLine="color4=0xFF2BC1F6";
_color4 = ((int)0xff2bc1f6);
RDebugUtils.currentLine=32702470;
 //BA.debugLineNum = 32702470;BA.debugLine="color5=0xFF1E45D1";
_color5 = ((int)0xff1e45d1);
RDebugUtils.currentLine=32702475;
 //BA.debugLineNum = 32702475;BA.debugLine="color_index=3";
_color_index = (int) (3);
RDebugUtils.currentLine=32702476;
 //BA.debugLineNum = 32702476;BA.debugLine="tik3.Visible=True";
mostCurrent._tik3.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=32702477;
 //BA.debugLineNum = 32702477;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color4_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color4_click", null));}
RDebugUtils.currentLine=32636928;
 //BA.debugLineNum = 32636928;BA.debugLine="Private Sub pan_color4_Click";
RDebugUtils.currentLine=32636929;
 //BA.debugLineNum = 32636929;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=32636930;
 //BA.debugLineNum = 32636930;BA.debugLine="color1 = 0xFFDD00FF";
_color1 = ((int)0xffdd00ff);
RDebugUtils.currentLine=32636931;
 //BA.debugLineNum = 32636931;BA.debugLine="color2 = 0xFF0090FF";
_color2 = ((int)0xff0090ff);
RDebugUtils.currentLine=32636932;
 //BA.debugLineNum = 32636932;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=32636933;
 //BA.debugLineNum = 32636933;BA.debugLine="color4=0xFFDD00FF";
_color4 = ((int)0xffdd00ff);
RDebugUtils.currentLine=32636934;
 //BA.debugLineNum = 32636934;BA.debugLine="color5=0xFF24EB9D";
_color5 = ((int)0xff24eb9d);
RDebugUtils.currentLine=32636939;
 //BA.debugLineNum = 32636939;BA.debugLine="color_index=4";
_color_index = (int) (4);
RDebugUtils.currentLine=32636940;
 //BA.debugLineNum = 32636940;BA.debugLine="tik4.Visible=True";
mostCurrent._tik4.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=32636941;
 //BA.debugLineNum = 32636941;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color5_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color5_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color5_click", null));}
RDebugUtils.currentLine=32571392;
 //BA.debugLineNum = 32571392;BA.debugLine="Private Sub pan_color5_Click";
RDebugUtils.currentLine=32571393;
 //BA.debugLineNum = 32571393;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=32571394;
 //BA.debugLineNum = 32571394;BA.debugLine="color1 = 0xFFCF5263";
_color1 = ((int)0xffcf5263);
RDebugUtils.currentLine=32571395;
 //BA.debugLineNum = 32571395;BA.debugLine="color2 = 0xFFABC01A";
_color2 = ((int)0xffabc01a);
RDebugUtils.currentLine=32571396;
 //BA.debugLineNum = 32571396;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=32571397;
 //BA.debugLineNum = 32571397;BA.debugLine="color4=0xFFCF5263";
_color4 = ((int)0xffcf5263);
RDebugUtils.currentLine=32571398;
 //BA.debugLineNum = 32571398;BA.debugLine="color5=0xFFABC01A";
_color5 = ((int)0xffabc01a);
RDebugUtils.currentLine=32571402;
 //BA.debugLineNum = 32571402;BA.debugLine="color_index=5";
_color_index = (int) (5);
RDebugUtils.currentLine=32571403;
 //BA.debugLineNum = 32571403;BA.debugLine="tik5.Visible=True";
mostCurrent._tik5.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=32571404;
 //BA.debugLineNum = 32571404;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color6_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color6_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color6_click", null));}
RDebugUtils.currentLine=32505856;
 //BA.debugLineNum = 32505856;BA.debugLine="Private Sub pan_color6_Click";
RDebugUtils.currentLine=32505857;
 //BA.debugLineNum = 32505857;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=32505858;
 //BA.debugLineNum = 32505858;BA.debugLine="color1= 0xFF5289CF";
_color1 = ((int)0xff5289cf);
RDebugUtils.currentLine=32505859;
 //BA.debugLineNum = 32505859;BA.debugLine="color2= 0xFFABC01A";
_color2 = ((int)0xffabc01a);
RDebugUtils.currentLine=32505860;
 //BA.debugLineNum = 32505860;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=32505861;
 //BA.debugLineNum = 32505861;BA.debugLine="color4=0xFF5289CF";
_color4 = ((int)0xff5289cf);
RDebugUtils.currentLine=32505862;
 //BA.debugLineNum = 32505862;BA.debugLine="color5=0xFFABC01A";
_color5 = ((int)0xffabc01a);
RDebugUtils.currentLine=32505867;
 //BA.debugLineNum = 32505867;BA.debugLine="color_index=6";
_color_index = (int) (6);
RDebugUtils.currentLine=32505868;
 //BA.debugLineNum = 32505868;BA.debugLine="tik6.Visible=True";
mostCurrent._tik6.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=32505869;
 //BA.debugLineNum = 32505869;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_font_pan_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_font_pan_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_font_pan_click", null));}
RDebugUtils.currentLine=33161216;
 //BA.debugLineNum = 33161216;BA.debugLine="Private Sub lbl_font_pan_Click";
RDebugUtils.currentLine=33161217;
 //BA.debugLineNum = 33161217;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=33161223;
 //BA.debugLineNum = 33161223;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_font_click", null));}
RDebugUtils.currentLine=33292288;
 //BA.debugLineNum = 33292288;BA.debugLine="Private Sub lbl_help_font_Click";
RDebugUtils.currentLine=33292293;
 //BA.debugLineNum = 33292293;BA.debugLine="pan_all_help.Visible=True";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=33292294;
 //BA.debugLineNum = 33292294;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_lock_app_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_lock_app_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_lock_app_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_lock0 = null;
anywheresoftware.b4a.objects.collections.List _ls_lock3 = null;
RDebugUtils.currentLine=33816576;
 //BA.debugLineNum = 33816576;BA.debugLine="Private Sub lbl_lock_app_Click";
RDebugUtils.currentLine=33816578;
 //BA.debugLineNum = 33816578;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=True)T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=33816579;
 //BA.debugLineNum = 33816579;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=33816580;
 //BA.debugLineNum = 33816580;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
RDebugUtils.currentLine=33816582;
 //BA.debugLineNum = 33816582;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_lock";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
RDebugUtils.currentLine=33816584;
 //BA.debugLineNum = 33816584;BA.debugLine="If(ls_lock0.Get(0)=\"true\")Then";
if (((_ls_lock0.Get((int) (0))).equals((Object)("true")))) { 
RDebugUtils.currentLine=33816585;
 //BA.debugLineNum = 33816585;BA.debugLine="ToggleBtn_OffOn_lock.Checked=True";
mostCurrent._togglebtn_offon_lock.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=33816586;
 //BA.debugLineNum = 33816586;BA.debugLine="et_pass_lock.Enabled=True";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=33816587;
 //BA.debugLineNum = 33816587;BA.debugLine="et_pass_lock.Text=ls_lock0.Get(2)";
mostCurrent._et_pass_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (2))));
RDebugUtils.currentLine=33816588;
 //BA.debugLineNum = 33816588;BA.debugLine="et_hint_lock.Text=ls_lock0.Get(3)";
mostCurrent._et_hint_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (3))));
 }else {
RDebugUtils.currentLine=33816590;
 //BA.debugLineNum = 33816590;BA.debugLine="ToggleBtn_OffOn_lock.Checked=False";
mostCurrent._togglebtn_offon_lock.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33816591;
 //BA.debugLineNum = 33816591;BA.debugLine="ToggleBtn_finger.Enabled=False";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33816592;
 //BA.debugLineNum = 33816592;BA.debugLine="et_pass_lock.Enabled=False";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33816593;
 //BA.debugLineNum = 33816593;BA.debugLine="et_hint_lock.Enabled=False";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33816594;
 //BA.debugLineNum = 33816594;BA.debugLine="et_pass_lock.Text=\"\"";
mostCurrent._et_pass_lock.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=33816597;
 //BA.debugLineNum = 33816597;BA.debugLine="If(ls_lock0.Get(1)=\"true\")Then";
if (((_ls_lock0.Get((int) (1))).equals((Object)("true")))) { 
RDebugUtils.currentLine=33816598;
 //BA.debugLineNum = 33816598;BA.debugLine="ToggleBtn_finger.Checked=True";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=33816600;
 //BA.debugLineNum = 33816600;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=33816602;
 //BA.debugLineNum = 33816602;BA.debugLine="et_hint_lock.Text=ls_lock0.Get(3)";
mostCurrent._et_hint_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (3))));
 }else {
RDebugUtils.currentLine=33816605;
 //BA.debugLineNum = 33816605;BA.debugLine="Dim ls_lock3 As List";
_ls_lock3 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=33816606;
 //BA.debugLineNum = 33816606;BA.debugLine="ls_lock3.Initialize";
_ls_lock3.Initialize();
RDebugUtils.currentLine=33816608;
 //BA.debugLineNum = 33816608;BA.debugLine="ls_lock3.Add(\"false\")";
_ls_lock3.Add((Object)("false"));
RDebugUtils.currentLine=33816609;
 //BA.debugLineNum = 33816609;BA.debugLine="ls_lock3.Add(\"false\")";
_ls_lock3.Add((Object)("false"));
RDebugUtils.currentLine=33816610;
 //BA.debugLineNum = 33816610;BA.debugLine="ls_lock3.Add(\"\")";
_ls_lock3.Add((Object)(""));
RDebugUtils.currentLine=33816611;
 //BA.debugLineNum = 33816611;BA.debugLine="ls_lock3.Add(\"\")";
_ls_lock3.Add((Object)(""));
RDebugUtils.currentLine=33816614;
 //BA.debugLineNum = 33816614;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_loc";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock3);
RDebugUtils.currentLine=33816617;
 //BA.debugLineNum = 33816617;BA.debugLine="ToggleBtn_OffOn_lock.Checked=False";
mostCurrent._togglebtn_offon_lock.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33816618;
 //BA.debugLineNum = 33816618;BA.debugLine="ToggleBtn_finger.Enabled=False";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33816619;
 //BA.debugLineNum = 33816619;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33816620;
 //BA.debugLineNum = 33816620;BA.debugLine="et_pass_lock.Enabled=False";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33816621;
 //BA.debugLineNum = 33816621;BA.debugLine="et_hint_lock.Enabled=False";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=33816628;
 //BA.debugLineNum = 33816628;BA.debugLine="pan_all_lock.Visible=True";
mostCurrent._pan_all_lock.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=33816629;
 //BA.debugLineNum = 33816629;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_rest_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_rest_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_rest_font_click", null));}
RDebugUtils.currentLine=33226752;
 //BA.debugLineNum = 33226752;BA.debugLine="Private Sub lbl_rest_font_Click";
RDebugUtils.currentLine=33226753;
 //BA.debugLineNum = 33226753;BA.debugLine="sp_font.SelectedIndex=0";
mostCurrent._sp_font.setSelectedIndex((int) (0));
RDebugUtils.currentLine=33226755;
 //BA.debugLineNum = 33226755;BA.debugLine="skb_f1.Value=17";
mostCurrent._skb_f1.setValue((int) (17));
RDebugUtils.currentLine=33226756;
 //BA.debugLineNum = 33226756;BA.debugLine="skb_f2.Value=15";
mostCurrent._skb_f2.setValue((int) (15));
RDebugUtils.currentLine=33226757;
 //BA.debugLineNum = 33226757;BA.debugLine="skb_f3.Value=13";
mostCurrent._skb_f3.setValue((int) (13));
RDebugUtils.currentLine=33226759;
 //BA.debugLineNum = 33226759;BA.debugLine="lbl_skb_f1.Text=17";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(17));
RDebugUtils.currentLine=33226760;
 //BA.debugLineNum = 33226760;BA.debugLine="lbl_skb_f2.Text=15";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(15));
RDebugUtils.currentLine=33226761;
 //BA.debugLineNum = 33226761;BA.debugLine="lbl_skb_f3.Text=13";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(13));
RDebugUtils.currentLine=33226766;
 //BA.debugLineNum = 33226766;BA.debugLine="End Sub";
return "";
}
public static void  _lbl_restore_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_restore_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "lbl_restore_click", null); return;}
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
RDebugUtils.currentModule="setting_activity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=32309249;
 //BA.debugLineNum = 32309249;BA.debugLine="cc.Initialize(\"CC\")";
parent._cc.Initialize("CC");
RDebugUtils.currentLine=32309250;
 //BA.debugLineNum = 32309250;BA.debugLine="cc.Show(\"*/*\", \"انتخاب فایل دیتابیس\")";
parent._cc.Show(processBA,"*/*","انتخاب فایل دیتابیس");
RDebugUtils.currentLine=32309251;
 //BA.debugLineNum = 32309251;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
anywheresoftware.b4a.keywords.Common.WaitFor("cc_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "setting_activity", "lbl_restore_click"), null);
this.state = 9;
return;
case 9:
//C
this.state = 1;
_success = (Boolean) result[0];
_dir = (String) result[1];
_filename = (String) result[2];
;
RDebugUtils.currentLine=32309252;
 //BA.debugLineNum = 32309252;BA.debugLine="If Success Then";
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
RDebugUtils.currentLine=32309253;
 //BA.debugLineNum = 32309253;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.SharedFo";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db");
RDebugUtils.currentLine=32309255;
 //BA.debugLineNum = 32309255;BA.debugLine="Log( Dir)";
anywheresoftware.b4a.keywords.Common.LogImpl("632309255",_dir,0);
RDebugUtils.currentLine=32309256;
 //BA.debugLineNum = 32309256;BA.debugLine="Log(FileName)";
anywheresoftware.b4a.keywords.Common.LogImpl("632309256",_filename,0);
RDebugUtils.currentLine=32309257;
 //BA.debugLineNum = 32309257;BA.debugLine="Log(File.Exists(Starter.Provider.SharedFolder,\"d";
anywheresoftware.b4a.keywords.Common.LogImpl("632309257",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.File.Exists(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db")),0);
RDebugUtils.currentLine=32309259;
 //BA.debugLineNum = 32309259;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=32309261;
 //BA.debugLineNum = 32309261;BA.debugLine="result = Msgbox2(\"دیتای قبلی حذف و دیتای جدید جا";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("دیتای قبلی حذف و دیتای جدید جایگزین می شود."),BA.ObjectToCharSequence("توجه"),"باشه","","نه",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=32309262;
 //BA.debugLineNum = 32309262;BA.debugLine="If result = DialogResponse.Positive Then";
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
RDebugUtils.currentLine=32309263;
 //BA.debugLineNum = 32309263;BA.debugLine="File.Copy(Starter.Provider.SharedFolder,\"db2.db";
anywheresoftware.b4a.keywords.Common.File.Copy(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db");
RDebugUtils.currentLine=32309264;
 //BA.debugLineNum = 32309264;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=32309265;
 //BA.debugLineNum = 32309265;BA.debugLine="Activity.Finish";
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
RDebugUtils.currentLine=32309271;
 //BA.debugLineNum = 32309271;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _lbl_save_color_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_color_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_color_click", null));}
RDebugUtils.currentLine=32899072;
 //BA.debugLineNum = 32899072;BA.debugLine="Private Sub lbl_save_color_Click";
RDebugUtils.currentLine=32899073;
 //BA.debugLineNum = 32899073;BA.debugLine="Main.color1=color1";
mostCurrent._main._color1 /*int*/  = _color1;
RDebugUtils.currentLine=32899074;
 //BA.debugLineNum = 32899074;BA.debugLine="Main.color2=color2";
mostCurrent._main._color2 /*int*/  = _color2;
RDebugUtils.currentLine=32899075;
 //BA.debugLineNum = 32899075;BA.debugLine="Main.color3=color3";
mostCurrent._main._color3 /*int*/  = _color3;
RDebugUtils.currentLine=32899076;
 //BA.debugLineNum = 32899076;BA.debugLine="Main.color4=color4";
mostCurrent._main._color4 /*int*/  = _color4;
RDebugUtils.currentLine=32899077;
 //BA.debugLineNum = 32899077;BA.debugLine="Main.color5=color5";
mostCurrent._main._color5 /*int*/  = _color5;
RDebugUtils.currentLine=32899078;
 //BA.debugLineNum = 32899078;BA.debugLine="Main.color_index=color_index";
mostCurrent._main._color_index /*int*/  = _color_index;
RDebugUtils.currentLine=32899080;
 //BA.debugLineNum = 32899080;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(mostCurrent._main._color1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color2 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color_index /*int*/ )+","+BA.NumberToString(mostCurrent._main._color3 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color4 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color5 /*int*/ )+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._main._main_font /*String*/ +","+BA.NumberToString(mostCurrent._main._size_f1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._size_f2 /*int*/ )+","+BA.NumberToString(mostCurrent._main._size_f3 /*int*/ ));
RDebugUtils.currentLine=32899082;
 //BA.debugLineNum = 32899082;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=32899083;
 //BA.debugLineNum = 32899083;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=32899087;
 //BA.debugLineNum = 32899087;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_font_click", null));}
RDebugUtils.currentLine=33357824;
 //BA.debugLineNum = 33357824;BA.debugLine="Private Sub lbl_save_font_Click";
RDebugUtils.currentLine=33357828;
 //BA.debugLineNum = 33357828;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(mostCurrent._main._color1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color2 /*int*/ )+","+BA.NumberToString(_color_index)+","+BA.NumberToString(mostCurrent._main._color3 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color4 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color5 /*int*/ )+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._sp_font.getSelectedItem()+","+BA.NumberToString(mostCurrent._skb_f1.getValue())+","+BA.NumberToString(mostCurrent._skb_f2.getValue())+","+BA.NumberToString(mostCurrent._skb_f3.getValue()));
RDebugUtils.currentLine=33357832;
 //BA.debugLineNum = 33357832;BA.debugLine="pan_all2_Click";
_pan_all2_click();
RDebugUtils.currentLine=33357833;
 //BA.debugLineNum = 33357833;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33357837;
 //BA.debugLineNum = 33357837;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all2_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all2_click", null));}
RDebugUtils.currentLine=33619968;
 //BA.debugLineNum = 33619968;BA.debugLine="Private Sub pan_all2_Click";
RDebugUtils.currentLine=33619969;
 //BA.debugLineNum = 33619969;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33619970;
 //BA.debugLineNum = 33619970;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_lock_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_lock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_lock_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_lock = null;
RDebugUtils.currentLine=33882112;
 //BA.debugLineNum = 33882112;BA.debugLine="Private Sub lbl_save_lock_Click";
RDebugUtils.currentLine=33882113;
 //BA.debugLineNum = 33882113;BA.debugLine="Dim ls_lock As List";
_ls_lock = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=33882114;
 //BA.debugLineNum = 33882114;BA.debugLine="ls_lock.Initialize";
_ls_lock.Initialize();
RDebugUtils.currentLine=33882118;
 //BA.debugLineNum = 33882118;BA.debugLine="If (ToggleBtn_OffOn_lock.Checked=True)Then";
if ((mostCurrent._togglebtn_offon_lock.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=33882119;
 //BA.debugLineNum = 33882119;BA.debugLine="If(et_pass_lock.Text.Length <> 4)Then";
if ((mostCurrent._et_pass_lock.getText().length()!=4)) { 
RDebugUtils.currentLine=33882120;
 //BA.debugLineNum = 33882120;BA.debugLine="ToastMessageShow(\"تعیین رمز\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تعیین رمز"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=33882124;
 //BA.debugLineNum = 33882124;BA.debugLine="ls_lock.Add(\"true\")";
_ls_lock.Add((Object)("true"));
RDebugUtils.currentLine=33882125;
 //BA.debugLineNum = 33882125;BA.debugLine="ls_lock.Add(ToggleBtn_finger.Checked)";
_ls_lock.Add((Object)(mostCurrent._togglebtn_finger.getChecked()));
RDebugUtils.currentLine=33882126;
 //BA.debugLineNum = 33882126;BA.debugLine="ls_lock.Add(et_pass_lock.Text)";
_ls_lock.Add((Object)(mostCurrent._et_pass_lock.getText()));
RDebugUtils.currentLine=33882127;
 //BA.debugLineNum = 33882127;BA.debugLine="ls_lock.Add(et_hint_lock.Text)";
_ls_lock.Add((Object)(mostCurrent._et_hint_lock.getText()));
RDebugUtils.currentLine=33882130;
 //BA.debugLineNum = 33882130;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_lo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock);
RDebugUtils.currentLine=33882132;
 //BA.debugLineNum = 33882132;BA.debugLine="pan_all_lock_Click";
_pan_all_lock_click();
 };
 }else {
RDebugUtils.currentLine=33882136;
 //BA.debugLineNum = 33882136;BA.debugLine="ls_lock.Add(\"false\")";
_ls_lock.Add((Object)("false"));
RDebugUtils.currentLine=33882137;
 //BA.debugLineNum = 33882137;BA.debugLine="ls_lock.Add(ToggleBtn_finger.Checked)";
_ls_lock.Add((Object)(mostCurrent._togglebtn_finger.getChecked()));
RDebugUtils.currentLine=33882138;
 //BA.debugLineNum = 33882138;BA.debugLine="ls_lock.Add(\"\")";
_ls_lock.Add((Object)(""));
RDebugUtils.currentLine=33882139;
 //BA.debugLineNum = 33882139;BA.debugLine="ls_lock.Add(\"\")";
_ls_lock.Add((Object)(""));
RDebugUtils.currentLine=33882140;
 //BA.debugLineNum = 33882140;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_loc";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock);
RDebugUtils.currentLine=33882141;
 //BA.debugLineNum = 33882141;BA.debugLine="pan_all_lock_Click";
_pan_all_lock_click();
 };
RDebugUtils.currentLine=33882145;
 //BA.debugLineNum = 33882145;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_lock_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_lock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_lock_click", null));}
RDebugUtils.currentLine=34078720;
 //BA.debugLineNum = 34078720;BA.debugLine="Private Sub pan_all_lock_Click";
RDebugUtils.currentLine=34078721;
 //BA.debugLineNum = 34078721;BA.debugLine="pan_all_lock.Visible=False";
mostCurrent._pan_all_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34078722;
 //BA.debugLineNum = 34078722;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=32440320;
 //BA.debugLineNum = 32440320;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=32440321;
 //BA.debugLineNum = 32440321;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=32440323;
 //BA.debugLineNum = 32440323;BA.debugLine="End Sub";
return "";
}
public static String  _tik_all_dis() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tik_all_dis", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tik_all_dis", null));}
RDebugUtils.currentLine=32964608;
 //BA.debugLineNum = 32964608;BA.debugLine="Sub tik_all_dis";
RDebugUtils.currentLine=32964609;
 //BA.debugLineNum = 32964609;BA.debugLine="tik1.Visible=False";
mostCurrent._tik1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=32964610;
 //BA.debugLineNum = 32964610;BA.debugLine="tik2.Visible=False";
mostCurrent._tik2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=32964611;
 //BA.debugLineNum = 32964611;BA.debugLine="tik3.Visible=False";
mostCurrent._tik3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=32964612;
 //BA.debugLineNum = 32964612;BA.debugLine="tik4.Visible=False";
mostCurrent._tik4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=32964613;
 //BA.debugLineNum = 32964613;BA.debugLine="tik5.Visible=False";
mostCurrent._tik5.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=32964614;
 //BA.debugLineNum = 32964614;BA.debugLine="tik6.Visible=False";
mostCurrent._tik6.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=32964615;
 //BA.debugLineNum = 32964615;BA.debugLine="End Sub";
return "";
}
public static String  _pan_colors_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_colors_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_colors_click", null));}
RDebugUtils.currentLine=33095680;
 //BA.debugLineNum = 33095680;BA.debugLine="Private Sub pan_colors_Click";
RDebugUtils.currentLine=33095682;
 //BA.debugLineNum = 33095682;BA.debugLine="End Sub";
return "";
}
public static String  _pan_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_font_click", null));}
RDebugUtils.currentLine=33685504;
 //BA.debugLineNum = 33685504;BA.debugLine="Private Sub pan_font_Click";
RDebugUtils.currentLine=33685506;
 //BA.debugLineNum = 33685506;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lock_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_lock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_lock_click", null));}
RDebugUtils.currentLine=34144256;
 //BA.debugLineNum = 34144256;BA.debugLine="Private Sub pan_lock_Click";
RDebugUtils.currentLine=34144258;
 //BA.debugLineNum = 34144258;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f1_valuechanged(int _value,boolean _userchanged) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "skb_f1_valuechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "skb_f1_valuechanged", new Object[] {_value,_userchanged}));}
RDebugUtils.currentLine=33554432;
 //BA.debugLineNum = 33554432;BA.debugLine="Private Sub skb_f1_ValueChanged (Value As Int, Use";
RDebugUtils.currentLine=33554433;
 //BA.debugLineNum = 33554433;BA.debugLine="lbl_skb_f1.Text=Value";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=33554434;
 //BA.debugLineNum = 33554434;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f2_valuechanged(int _value,boolean _userchanged) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "skb_f2_valuechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "skb_f2_valuechanged", new Object[] {_value,_userchanged}));}
RDebugUtils.currentLine=33488896;
 //BA.debugLineNum = 33488896;BA.debugLine="Private Sub skb_f2_ValueChanged (Value As Int, Use";
RDebugUtils.currentLine=33488897;
 //BA.debugLineNum = 33488897;BA.debugLine="lbl_skb_f2.Text=Value";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=33488898;
 //BA.debugLineNum = 33488898;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f3_valuechanged(int _value,boolean _userchanged) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "skb_f3_valuechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "skb_f3_valuechanged", new Object[] {_value,_userchanged}));}
RDebugUtils.currentLine=33423360;
 //BA.debugLineNum = 33423360;BA.debugLine="Private Sub skb_f3_ValueChanged (Value As Int, Use";
RDebugUtils.currentLine=33423361;
 //BA.debugLineNum = 33423361;BA.debugLine="lbl_skb_f3.Text=Value";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=33423362;
 //BA.debugLineNum = 33423362;BA.debugLine="End Sub";
return "";
}
public static String  _togglebtn_finger_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "togglebtn_finger_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "togglebtn_finger_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=34209792;
 //BA.debugLineNum = 34209792;BA.debugLine="Private Sub ToggleBtn_finger_CheckedChange(Checked";
RDebugUtils.currentLine=34209793;
 //BA.debugLineNum = 34209793;BA.debugLine="Try";
try {RDebugUtils.currentLine=34209794;
 //BA.debugLineNum = 34209794;BA.debugLine="fingerprint1.Initialize (Me, \"auth\")";
mostCurrent._fingerprint1._initialize /*String*/ (null,processBA,setting_activity.getObject(),"auth");
RDebugUtils.currentLine=34209795;
 //BA.debugLineNum = 34209795;BA.debugLine="If fingerprint1.HardwareDetected = False Then";
if (mostCurrent._fingerprint1._gethardwaredetected /*boolean*/ (null)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=34209796;
 //BA.debugLineNum = 34209796;BA.debugLine="ToastMessageShow(\"سنسور اثر انگشت موجود نیست\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("سنسور اثر انگشت موجود نیست"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=34209797;
 //BA.debugLineNum = 34209797;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=34209798;
 //BA.debugLineNum = 34209798;BA.debugLine="Else if fingerprint1.HasEnrolledFingerprints = F";
if (mostCurrent._fingerprint1._gethasenrolledfingerprints /*boolean*/ (null)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=34209799;
 //BA.debugLineNum = 34209799;BA.debugLine="ToastMessageShow(\"اثر انگشت تعریف نشده است\", Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اثر انگشت تعریف نشده است"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34209800;
 //BA.debugLineNum = 34209800;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }}
;
 } 
       catch (Exception e11) {
			processBA.setLastException(e11);RDebugUtils.currentLine=34209804;
 //BA.debugLineNum = 34209804;BA.debugLine="ToastMessageShow(\"سنسور اثر انگشت موجود نیست\", T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("سنسور اثر انگشت موجود نیست"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=34209805;
 //BA.debugLineNum = 34209805;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34209806;
 //BA.debugLineNum = 34209806;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("634209806",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=34209809;
 //BA.debugLineNum = 34209809;BA.debugLine="End Sub";
return "";
}
public static String  _togglebtn_offon_lock_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "togglebtn_offon_lock_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "togglebtn_offon_lock_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=34013184;
 //BA.debugLineNum = 34013184;BA.debugLine="Private Sub ToggleBtn_OffOn_lock_CheckedChange(Che";
RDebugUtils.currentLine=34013185;
 //BA.debugLineNum = 34013185;BA.debugLine="Try";
try {RDebugUtils.currentLine=34013186;
 //BA.debugLineNum = 34013186;BA.debugLine="If(ToggleBtn_OffOn_lock.Checked=False)Then";
if ((mostCurrent._togglebtn_offon_lock.getChecked()==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=34013187;
 //BA.debugLineNum = 34013187;BA.debugLine="et_pass_lock.Enabled=False";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34013188;
 //BA.debugLineNum = 34013188;BA.debugLine="ToggleBtn_finger.Enabled=False";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34013189;
 //BA.debugLineNum = 34013189;BA.debugLine="et_hint_lock.Enabled=False";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=34013191;
 //BA.debugLineNum = 34013191;BA.debugLine="et_pass_lock.Enabled=True";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=34013192;
 //BA.debugLineNum = 34013192;BA.debugLine="ToggleBtn_finger.Enabled=True";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=34013193;
 //BA.debugLineNum = 34013193;BA.debugLine="et_hint_lock.Enabled=True";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e12) {
			processBA.setLastException(e12);RDebugUtils.currentLine=34013197;
 //BA.debugLineNum = 34013197;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("634013197",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=34013203;
 //BA.debugLineNum = 34013203;BA.debugLine="End Sub";
return "";
}
}