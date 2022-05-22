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
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=21495808;
 //BA.debugLineNum = 21495808;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=21495810;
 //BA.debugLineNum = 21495810;BA.debugLine="Activity.LoadLayout(\"setting_layout\")";
mostCurrent._activity.LoadLayout("setting_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=21495815;
 //BA.debugLineNum = 21495815;BA.debugLine="pan_hed_setting.Color=Main.color4";
mostCurrent._pan_hed_setting.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=21495816;
 //BA.debugLineNum = 21495816;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=21495819;
 //BA.debugLineNum = 21495819;BA.debugLine="sp_font.Add(\"یکان\")";
mostCurrent._sp_font.Add("یکان");
RDebugUtils.currentLine=21495820;
 //BA.debugLineNum = 21495820;BA.debugLine="sp_font.Add(\"نازنین\")";
mostCurrent._sp_font.Add("نازنین");
RDebugUtils.currentLine=21495821;
 //BA.debugLineNum = 21495821;BA.debugLine="sp_font.Add(\"وزیر\")";
mostCurrent._sp_font.Add("وزیر");
RDebugUtils.currentLine=21495822;
 //BA.debugLineNum = 21495822;BA.debugLine="sp_font.Add(\"دست نویس\")";
mostCurrent._sp_font.Add("دست نویس");
RDebugUtils.currentLine=21495823;
 //BA.debugLineNum = 21495823;BA.debugLine="sp_font.Add(\"کودک\")";
mostCurrent._sp_font.Add("کودک");
RDebugUtils.currentLine=21495826;
 //BA.debugLineNum = 21495826;BA.debugLine="skb_f1.Value=Main.size_f1";
mostCurrent._skb_f1.setValue(mostCurrent._main._size_f1 /*int*/ );
RDebugUtils.currentLine=21495827;
 //BA.debugLineNum = 21495827;BA.debugLine="skb_f2.Value=Main.size_f2";
mostCurrent._skb_f2.setValue(mostCurrent._main._size_f2 /*int*/ );
RDebugUtils.currentLine=21495828;
 //BA.debugLineNum = 21495828;BA.debugLine="skb_f3.Value=Main.size_f3";
mostCurrent._skb_f3.setValue(mostCurrent._main._size_f3 /*int*/ );
RDebugUtils.currentLine=21495830;
 //BA.debugLineNum = 21495830;BA.debugLine="lbl_skb_f1.Text=Main.size_f1";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f1 /*int*/ ));
RDebugUtils.currentLine=21495831;
 //BA.debugLineNum = 21495831;BA.debugLine="lbl_skb_f2.Text=Main.size_f2";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f2 /*int*/ ));
RDebugUtils.currentLine=21495832;
 //BA.debugLineNum = 21495832;BA.debugLine="lbl_skb_f3.Text=Main.size_f3";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f3 /*int*/ ));
RDebugUtils.currentLine=21495836;
 //BA.debugLineNum = 21495836;BA.debugLine="sp_font.SelectedIndex=sp_font.IndexOf(Main.main_f";
mostCurrent._sp_font.setSelectedIndex(mostCurrent._sp_font.IndexOf(mostCurrent._main._main_font /*String*/ ));
RDebugUtils.currentLine=21495838;
 //BA.debugLineNum = 21495838;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=21692416;
 //BA.debugLineNum = 21692416;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=21692417;
 //BA.debugLineNum = 21692417;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=21692418;
 //BA.debugLineNum = 21692418;BA.debugLine="If(pan_all.Visible=True)Then";
if ((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=21692419;
 //BA.debugLineNum = 21692419;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=21692421;
 //BA.debugLineNum = 21692421;BA.debugLine="Else If (pan_all_help.Visible=True) Then";
if ((mostCurrent._pan_all_help.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=21692422;
 //BA.debugLineNum = 21692422;BA.debugLine="pan_all_help.Visible=False";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=21692423;
 //BA.debugLineNum = 21692423;BA.debugLine="Else If (pan_all2.Visible=True)Then";
if ((mostCurrent._pan_all2.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=21692424;
 //BA.debugLineNum = 21692424;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=21692427;
 //BA.debugLineNum = 21692427;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 }}}
;
RDebugUtils.currentLine=21692430;
 //BA.debugLineNum = 21692430;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=21692432;
 //BA.debugLineNum = 21692432;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=21692434;
 //BA.debugLineNum = 21692434;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=21757952;
 //BA.debugLineNum = 21757952;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=21757953;
 //BA.debugLineNum = 21757953;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=21757954;
 //BA.debugLineNum = 21757954;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=21757955;
 //BA.debugLineNum = 21757955;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="setting_activity";
RDebugUtils.currentLine=21626880;
 //BA.debugLineNum = 21626880;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=21626882;
 //BA.debugLineNum = 21626882;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=21561344;
 //BA.debugLineNum = 21561344;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=21561346;
 //BA.debugLineNum = 21561346;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_backup_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_backup_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_backup_click", null));}
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
RDebugUtils.currentLine=21823488;
 //BA.debugLineNum = 21823488;BA.debugLine="Private Sub lbl_backup_Click";
RDebugUtils.currentLine=21823490;
 //BA.debugLineNum = 21823490;BA.debugLine="Dim FileName As String = \"db.db\"";
_filename = "db.db";
RDebugUtils.currentLine=21823493;
 //BA.debugLineNum = 21823493;BA.debugLine="File.Copy(File.DirInternal, FileName, Starter.Pro";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename,mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename);
RDebugUtils.currentLine=21823495;
 //BA.debugLineNum = 21823495;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=21823496;
 //BA.debugLineNum = 21823496;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
RDebugUtils.currentLine=21823497;
 //BA.debugLineNum = 21823497;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
RDebugUtils.currentLine=21823498;
 //BA.debugLineNum = 21823498;BA.debugLine="email.Body = \"backup-\"&DateTime.Date(DateTime.Now";
_email.Body = "backup-"+anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=21823499;
 //BA.debugLineNum = 21823499;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (null,_filename));
RDebugUtils.currentLine=21823501;
 //BA.debugLineNum = 21823501;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
RDebugUtils.currentLine=21823504;
 //BA.debugLineNum = 21823504;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
RDebugUtils.currentLine=21823505;
 //BA.debugLineNum = 21823505;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
RDebugUtils.currentLine=21823507;
 //BA.debugLineNum = 21823507;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_help_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_help_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_help_font_click", null));}
RDebugUtils.currentLine=23330816;
 //BA.debugLineNum = 23330816;BA.debugLine="Private Sub lbl_close_help_font_Click";
RDebugUtils.currentLine=23330817;
 //BA.debugLineNum = 23330817;BA.debugLine="pan_all_help.Visible=False";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=23330818;
 //BA.debugLineNum = 23330818;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_color_home_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_color_home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_color_home_click", null));}
RDebugUtils.currentLine=22609920;
 //BA.debugLineNum = 22609920;BA.debugLine="Private Sub lbl_color_home_Click";
RDebugUtils.currentLine=22609921;
 //BA.debugLineNum = 22609921;BA.debugLine="lbl_color1_Click";
_lbl_color1_click();
RDebugUtils.currentLine=22609922;
 //BA.debugLineNum = 22609922;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_color1_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_color1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_color1_click", null));}
RDebugUtils.currentLine=21954560;
 //BA.debugLineNum = 21954560;BA.debugLine="Private Sub lbl_color1_Click";
RDebugUtils.currentLine=21954561;
 //BA.debugLineNum = 21954561;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=21954563;
 //BA.debugLineNum = 21954563;BA.debugLine="color_index=Main.color_index";
_color_index = mostCurrent._main._color_index /*int*/ ;
RDebugUtils.currentLine=21954565;
 //BA.debugLineNum = 21954565;BA.debugLine="Select color_index";
switch (_color_index) {
case 1: {
RDebugUtils.currentLine=21954567;
 //BA.debugLineNum = 21954567;BA.debugLine="pan_color1_Click";
_pan_color1_click();
 break; }
case 2: {
RDebugUtils.currentLine=21954569;
 //BA.debugLineNum = 21954569;BA.debugLine="pan_color2_Click";
_pan_color2_click();
 break; }
case 3: {
RDebugUtils.currentLine=21954571;
 //BA.debugLineNum = 21954571;BA.debugLine="pan_color3_Click";
_pan_color3_click();
 break; }
case 4: {
RDebugUtils.currentLine=21954573;
 //BA.debugLineNum = 21954573;BA.debugLine="pan_color4_Click";
_pan_color4_click();
 break; }
case 5: {
RDebugUtils.currentLine=21954575;
 //BA.debugLineNum = 21954575;BA.debugLine="pan_color5_Click";
_pan_color5_click();
 break; }
case 6: {
RDebugUtils.currentLine=21954577;
 //BA.debugLineNum = 21954577;BA.debugLine="pan_color6_Click";
_pan_color6_click();
 break; }
}
;
RDebugUtils.currentLine=21954584;
 //BA.debugLineNum = 21954584;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color1_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color1_click", null));}
RDebugUtils.currentLine=22413312;
 //BA.debugLineNum = 22413312;BA.debugLine="Private Sub pan_color1_Click";
RDebugUtils.currentLine=22413313;
 //BA.debugLineNum = 22413313;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=22413314;
 //BA.debugLineNum = 22413314;BA.debugLine="color1=0XFF69AC00";
_color1 = ((int)0xff69ac00);
RDebugUtils.currentLine=22413315;
 //BA.debugLineNum = 22413315;BA.debugLine="color2=0xFF00C7C7";
_color2 = ((int)0xff00c7c7);
RDebugUtils.currentLine=22413316;
 //BA.debugLineNum = 22413316;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=22413317;
 //BA.debugLineNum = 22413317;BA.debugLine="color4=0XFF69AC00";
_color4 = ((int)0xff69ac00);
RDebugUtils.currentLine=22413318;
 //BA.debugLineNum = 22413318;BA.debugLine="color5=0xFF00C7C7";
_color5 = ((int)0xff00c7c7);
RDebugUtils.currentLine=22413321;
 //BA.debugLineNum = 22413321;BA.debugLine="color_index=1";
_color_index = (int) (1);
RDebugUtils.currentLine=22413322;
 //BA.debugLineNum = 22413322;BA.debugLine="tik1.Visible=True";
mostCurrent._tik1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22413324;
 //BA.debugLineNum = 22413324;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color2_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color2_click", null));}
RDebugUtils.currentLine=22347776;
 //BA.debugLineNum = 22347776;BA.debugLine="Private Sub pan_color2_Click";
RDebugUtils.currentLine=22347777;
 //BA.debugLineNum = 22347777;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=22347778;
 //BA.debugLineNum = 22347778;BA.debugLine="color1 = 0xFF7F19EE";
_color1 = ((int)0xff7f19ee);
RDebugUtils.currentLine=22347779;
 //BA.debugLineNum = 22347779;BA.debugLine="color2 = 0xFF567BFF";
_color2 = ((int)0xff567bff);
RDebugUtils.currentLine=22347780;
 //BA.debugLineNum = 22347780;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=22347781;
 //BA.debugLineNum = 22347781;BA.debugLine="color4=0xFF567BFF";
_color4 = ((int)0xff567bff);
RDebugUtils.currentLine=22347782;
 //BA.debugLineNum = 22347782;BA.debugLine="color5=0xFF567BFF";
_color5 = ((int)0xff567bff);
RDebugUtils.currentLine=22347786;
 //BA.debugLineNum = 22347786;BA.debugLine="color_index=2";
_color_index = (int) (2);
RDebugUtils.currentLine=22347787;
 //BA.debugLineNum = 22347787;BA.debugLine="tik2.Visible=True";
mostCurrent._tik2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22347789;
 //BA.debugLineNum = 22347789;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color3_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color3_click", null));}
RDebugUtils.currentLine=22282240;
 //BA.debugLineNum = 22282240;BA.debugLine="Private Sub pan_color3_Click";
RDebugUtils.currentLine=22282241;
 //BA.debugLineNum = 22282241;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=22282242;
 //BA.debugLineNum = 22282242;BA.debugLine="color1 = 0xFF2BC1F6";
_color1 = ((int)0xff2bc1f6);
RDebugUtils.currentLine=22282243;
 //BA.debugLineNum = 22282243;BA.debugLine="color2 = 0xFF1E45D1";
_color2 = ((int)0xff1e45d1);
RDebugUtils.currentLine=22282244;
 //BA.debugLineNum = 22282244;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=22282245;
 //BA.debugLineNum = 22282245;BA.debugLine="color4=0xFF2BC1F6";
_color4 = ((int)0xff2bc1f6);
RDebugUtils.currentLine=22282246;
 //BA.debugLineNum = 22282246;BA.debugLine="color5=0xFF1E45D1";
_color5 = ((int)0xff1e45d1);
RDebugUtils.currentLine=22282251;
 //BA.debugLineNum = 22282251;BA.debugLine="color_index=3";
_color_index = (int) (3);
RDebugUtils.currentLine=22282252;
 //BA.debugLineNum = 22282252;BA.debugLine="tik3.Visible=True";
mostCurrent._tik3.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22282253;
 //BA.debugLineNum = 22282253;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color4_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color4_click", null));}
RDebugUtils.currentLine=22216704;
 //BA.debugLineNum = 22216704;BA.debugLine="Private Sub pan_color4_Click";
RDebugUtils.currentLine=22216705;
 //BA.debugLineNum = 22216705;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=22216706;
 //BA.debugLineNum = 22216706;BA.debugLine="color1 = 0xFFDD00FF";
_color1 = ((int)0xffdd00ff);
RDebugUtils.currentLine=22216707;
 //BA.debugLineNum = 22216707;BA.debugLine="color2 = 0xFF0090FF";
_color2 = ((int)0xff0090ff);
RDebugUtils.currentLine=22216708;
 //BA.debugLineNum = 22216708;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=22216709;
 //BA.debugLineNum = 22216709;BA.debugLine="color4=0xFFDD00FF";
_color4 = ((int)0xffdd00ff);
RDebugUtils.currentLine=22216710;
 //BA.debugLineNum = 22216710;BA.debugLine="color5=0xFF24EB9D";
_color5 = ((int)0xff24eb9d);
RDebugUtils.currentLine=22216715;
 //BA.debugLineNum = 22216715;BA.debugLine="color_index=4";
_color_index = (int) (4);
RDebugUtils.currentLine=22216716;
 //BA.debugLineNum = 22216716;BA.debugLine="tik4.Visible=True";
mostCurrent._tik4.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22216717;
 //BA.debugLineNum = 22216717;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color5_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color5_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color5_click", null));}
RDebugUtils.currentLine=22151168;
 //BA.debugLineNum = 22151168;BA.debugLine="Private Sub pan_color5_Click";
RDebugUtils.currentLine=22151169;
 //BA.debugLineNum = 22151169;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=22151170;
 //BA.debugLineNum = 22151170;BA.debugLine="color1 = 0xFFCF5263";
_color1 = ((int)0xffcf5263);
RDebugUtils.currentLine=22151171;
 //BA.debugLineNum = 22151171;BA.debugLine="color2 = 0xFFABC01A";
_color2 = ((int)0xffabc01a);
RDebugUtils.currentLine=22151172;
 //BA.debugLineNum = 22151172;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=22151173;
 //BA.debugLineNum = 22151173;BA.debugLine="color4=0xFFCF5263";
_color4 = ((int)0xffcf5263);
RDebugUtils.currentLine=22151174;
 //BA.debugLineNum = 22151174;BA.debugLine="color5=0xFFABC01A";
_color5 = ((int)0xffabc01a);
RDebugUtils.currentLine=22151178;
 //BA.debugLineNum = 22151178;BA.debugLine="color_index=5";
_color_index = (int) (5);
RDebugUtils.currentLine=22151179;
 //BA.debugLineNum = 22151179;BA.debugLine="tik5.Visible=True";
mostCurrent._tik5.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22151180;
 //BA.debugLineNum = 22151180;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color6_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color6_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color6_click", null));}
RDebugUtils.currentLine=22085632;
 //BA.debugLineNum = 22085632;BA.debugLine="Private Sub pan_color6_Click";
RDebugUtils.currentLine=22085633;
 //BA.debugLineNum = 22085633;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=22085634;
 //BA.debugLineNum = 22085634;BA.debugLine="color1= 0xFF5289CF";
_color1 = ((int)0xff5289cf);
RDebugUtils.currentLine=22085635;
 //BA.debugLineNum = 22085635;BA.debugLine="color2= 0xFFABC01A";
_color2 = ((int)0xffabc01a);
RDebugUtils.currentLine=22085636;
 //BA.debugLineNum = 22085636;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=22085637;
 //BA.debugLineNum = 22085637;BA.debugLine="color4=0xFF5289CF";
_color4 = ((int)0xff5289cf);
RDebugUtils.currentLine=22085638;
 //BA.debugLineNum = 22085638;BA.debugLine="color5=0xFFABC01A";
_color5 = ((int)0xffabc01a);
RDebugUtils.currentLine=22085643;
 //BA.debugLineNum = 22085643;BA.debugLine="color_index=6";
_color_index = (int) (6);
RDebugUtils.currentLine=22085644;
 //BA.debugLineNum = 22085644;BA.debugLine="tik6.Visible=True";
mostCurrent._tik6.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22085645;
 //BA.debugLineNum = 22085645;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_font_pan_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_font_pan_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_font_pan_click", null));}
RDebugUtils.currentLine=22740992;
 //BA.debugLineNum = 22740992;BA.debugLine="Private Sub lbl_font_pan_Click";
RDebugUtils.currentLine=22740993;
 //BA.debugLineNum = 22740993;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22740999;
 //BA.debugLineNum = 22740999;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_font_click", null));}
RDebugUtils.currentLine=22872064;
 //BA.debugLineNum = 22872064;BA.debugLine="Private Sub lbl_help_font_Click";
RDebugUtils.currentLine=22872069;
 //BA.debugLineNum = 22872069;BA.debugLine="pan_all_help.Visible=True";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22872070;
 //BA.debugLineNum = 22872070;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_rest_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_rest_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_rest_font_click", null));}
RDebugUtils.currentLine=22806528;
 //BA.debugLineNum = 22806528;BA.debugLine="Private Sub lbl_rest_font_Click";
RDebugUtils.currentLine=22806529;
 //BA.debugLineNum = 22806529;BA.debugLine="sp_font.SelectedIndex=0";
mostCurrent._sp_font.setSelectedIndex((int) (0));
RDebugUtils.currentLine=22806531;
 //BA.debugLineNum = 22806531;BA.debugLine="skb_f1.Value=17";
mostCurrent._skb_f1.setValue((int) (17));
RDebugUtils.currentLine=22806532;
 //BA.debugLineNum = 22806532;BA.debugLine="skb_f2.Value=15";
mostCurrent._skb_f2.setValue((int) (15));
RDebugUtils.currentLine=22806533;
 //BA.debugLineNum = 22806533;BA.debugLine="skb_f3.Value=13";
mostCurrent._skb_f3.setValue((int) (13));
RDebugUtils.currentLine=22806535;
 //BA.debugLineNum = 22806535;BA.debugLine="lbl_skb_f1.Text=17";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(17));
RDebugUtils.currentLine=22806536;
 //BA.debugLineNum = 22806536;BA.debugLine="lbl_skb_f2.Text=15";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(15));
RDebugUtils.currentLine=22806537;
 //BA.debugLineNum = 22806537;BA.debugLine="lbl_skb_f3.Text=13";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(13));
RDebugUtils.currentLine=22806542;
 //BA.debugLineNum = 22806542;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=21889025;
 //BA.debugLineNum = 21889025;BA.debugLine="cc.Initialize(\"CC\")";
parent._cc.Initialize("CC");
RDebugUtils.currentLine=21889026;
 //BA.debugLineNum = 21889026;BA.debugLine="cc.Show(\"*/*\", \"انتخاب فایل دیتابیس\")";
parent._cc.Show(processBA,"*/*","انتخاب فایل دیتابیس");
RDebugUtils.currentLine=21889027;
 //BA.debugLineNum = 21889027;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
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
RDebugUtils.currentLine=21889028;
 //BA.debugLineNum = 21889028;BA.debugLine="If Success Then";
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
RDebugUtils.currentLine=21889029;
 //BA.debugLineNum = 21889029;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.SharedFo";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db");
RDebugUtils.currentLine=21889031;
 //BA.debugLineNum = 21889031;BA.debugLine="Log( Dir)";
anywheresoftware.b4a.keywords.Common.LogImpl("621889031",_dir,0);
RDebugUtils.currentLine=21889032;
 //BA.debugLineNum = 21889032;BA.debugLine="Log(FileName)";
anywheresoftware.b4a.keywords.Common.LogImpl("621889032",_filename,0);
RDebugUtils.currentLine=21889033;
 //BA.debugLineNum = 21889033;BA.debugLine="Log(File.Exists(Starter.Provider.SharedFolder,\"d";
anywheresoftware.b4a.keywords.Common.LogImpl("621889033",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.File.Exists(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db")),0);
RDebugUtils.currentLine=21889035;
 //BA.debugLineNum = 21889035;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=21889037;
 //BA.debugLineNum = 21889037;BA.debugLine="result = Msgbox2(\"دیتای قبلی حذف و دیتای جدید جا";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("دیتای قبلی حذف و دیتای جدید جایگزین می شود."),BA.ObjectToCharSequence("توجه"),"باشه","","نه",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=21889038;
 //BA.debugLineNum = 21889038;BA.debugLine="If result = DialogResponse.Positive Then";
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
RDebugUtils.currentLine=21889039;
 //BA.debugLineNum = 21889039;BA.debugLine="File.Copy(Starter.Provider.SharedFolder,\"db2.db";
anywheresoftware.b4a.keywords.Common.File.Copy(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db");
RDebugUtils.currentLine=21889040;
 //BA.debugLineNum = 21889040;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=21889041;
 //BA.debugLineNum = 21889041;BA.debugLine="Activity.Finish";
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
RDebugUtils.currentLine=21889047;
 //BA.debugLineNum = 21889047;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _lbl_save_color_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_color_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_color_click", null));}
RDebugUtils.currentLine=22478848;
 //BA.debugLineNum = 22478848;BA.debugLine="Private Sub lbl_save_color_Click";
RDebugUtils.currentLine=22478849;
 //BA.debugLineNum = 22478849;BA.debugLine="Main.color1=color1";
mostCurrent._main._color1 /*int*/  = _color1;
RDebugUtils.currentLine=22478850;
 //BA.debugLineNum = 22478850;BA.debugLine="Main.color2=color2";
mostCurrent._main._color2 /*int*/  = _color2;
RDebugUtils.currentLine=22478851;
 //BA.debugLineNum = 22478851;BA.debugLine="Main.color3=color3";
mostCurrent._main._color3 /*int*/  = _color3;
RDebugUtils.currentLine=22478852;
 //BA.debugLineNum = 22478852;BA.debugLine="Main.color4=color4";
mostCurrent._main._color4 /*int*/  = _color4;
RDebugUtils.currentLine=22478853;
 //BA.debugLineNum = 22478853;BA.debugLine="Main.color5=color5";
mostCurrent._main._color5 /*int*/  = _color5;
RDebugUtils.currentLine=22478854;
 //BA.debugLineNum = 22478854;BA.debugLine="Main.color_index=color_index";
mostCurrent._main._color_index /*int*/  = _color_index;
RDebugUtils.currentLine=22478856;
 //BA.debugLineNum = 22478856;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(mostCurrent._main._color1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color2 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color_index /*int*/ )+","+BA.NumberToString(mostCurrent._main._color3 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color4 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color5 /*int*/ )+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._main._main_font /*String*/ +","+BA.NumberToString(mostCurrent._main._size_f1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._size_f2 /*int*/ )+","+BA.NumberToString(mostCurrent._main._size_f3 /*int*/ ));
RDebugUtils.currentLine=22478858;
 //BA.debugLineNum = 22478858;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22478859;
 //BA.debugLineNum = 22478859;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22478863;
 //BA.debugLineNum = 22478863;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_font_click", null));}
RDebugUtils.currentLine=22937600;
 //BA.debugLineNum = 22937600;BA.debugLine="Private Sub lbl_save_font_Click";
RDebugUtils.currentLine=22937604;
 //BA.debugLineNum = 22937604;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(mostCurrent._main._color1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color2 /*int*/ )+","+BA.NumberToString(_color_index)+","+BA.NumberToString(mostCurrent._main._color3 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color4 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color5 /*int*/ )+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._sp_font.getSelectedItem()+","+BA.NumberToString(mostCurrent._skb_f1.getValue())+","+BA.NumberToString(mostCurrent._skb_f2.getValue())+","+BA.NumberToString(mostCurrent._skb_f3.getValue()));
RDebugUtils.currentLine=22937608;
 //BA.debugLineNum = 22937608;BA.debugLine="pan_all2_Click";
_pan_all2_click();
RDebugUtils.currentLine=22937609;
 //BA.debugLineNum = 22937609;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22937613;
 //BA.debugLineNum = 22937613;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all2_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all2_click", null));}
RDebugUtils.currentLine=23199744;
 //BA.debugLineNum = 23199744;BA.debugLine="Private Sub pan_all2_Click";
RDebugUtils.currentLine=23199745;
 //BA.debugLineNum = 23199745;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=23199746;
 //BA.debugLineNum = 23199746;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=22020096;
 //BA.debugLineNum = 22020096;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=22020097;
 //BA.debugLineNum = 22020097;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22020099;
 //BA.debugLineNum = 22020099;BA.debugLine="End Sub";
return "";
}
public static String  _tik_all_dis() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tik_all_dis", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tik_all_dis", null));}
RDebugUtils.currentLine=22544384;
 //BA.debugLineNum = 22544384;BA.debugLine="Sub tik_all_dis";
RDebugUtils.currentLine=22544385;
 //BA.debugLineNum = 22544385;BA.debugLine="tik1.Visible=False";
mostCurrent._tik1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22544386;
 //BA.debugLineNum = 22544386;BA.debugLine="tik2.Visible=False";
mostCurrent._tik2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22544387;
 //BA.debugLineNum = 22544387;BA.debugLine="tik3.Visible=False";
mostCurrent._tik3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22544388;
 //BA.debugLineNum = 22544388;BA.debugLine="tik4.Visible=False";
mostCurrent._tik4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22544389;
 //BA.debugLineNum = 22544389;BA.debugLine="tik5.Visible=False";
mostCurrent._tik5.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22544390;
 //BA.debugLineNum = 22544390;BA.debugLine="tik6.Visible=False";
mostCurrent._tik6.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22544391;
 //BA.debugLineNum = 22544391;BA.debugLine="End Sub";
return "";
}
public static String  _pan_colors_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_colors_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_colors_click", null));}
RDebugUtils.currentLine=22675456;
 //BA.debugLineNum = 22675456;BA.debugLine="Private Sub pan_colors_Click";
RDebugUtils.currentLine=22675458;
 //BA.debugLineNum = 22675458;BA.debugLine="End Sub";
return "";
}
public static String  _pan_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_font_click", null));}
RDebugUtils.currentLine=23265280;
 //BA.debugLineNum = 23265280;BA.debugLine="Private Sub pan_font_Click";
RDebugUtils.currentLine=23265282;
 //BA.debugLineNum = 23265282;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f1_valuechanged(int _value,boolean _userchanged) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "skb_f1_valuechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "skb_f1_valuechanged", new Object[] {_value,_userchanged}));}
RDebugUtils.currentLine=23134208;
 //BA.debugLineNum = 23134208;BA.debugLine="Private Sub skb_f1_ValueChanged (Value As Int, Use";
RDebugUtils.currentLine=23134209;
 //BA.debugLineNum = 23134209;BA.debugLine="lbl_skb_f1.Text=Value";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=23134210;
 //BA.debugLineNum = 23134210;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f2_valuechanged(int _value,boolean _userchanged) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "skb_f2_valuechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "skb_f2_valuechanged", new Object[] {_value,_userchanged}));}
RDebugUtils.currentLine=23068672;
 //BA.debugLineNum = 23068672;BA.debugLine="Private Sub skb_f2_ValueChanged (Value As Int, Use";
RDebugUtils.currentLine=23068673;
 //BA.debugLineNum = 23068673;BA.debugLine="lbl_skb_f2.Text=Value";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=23068674;
 //BA.debugLineNum = 23068674;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f3_valuechanged(int _value,boolean _userchanged) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "skb_f3_valuechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "skb_f3_valuechanged", new Object[] {_value,_userchanged}));}
RDebugUtils.currentLine=23003136;
 //BA.debugLineNum = 23003136;BA.debugLine="Private Sub skb_f3_ValueChanged (Value As Int, Use";
RDebugUtils.currentLine=23003137;
 //BA.debugLineNum = 23003137;BA.debugLine="lbl_skb_f3.Text=Value";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=23003138;
 //BA.debugLineNum = 23003138;BA.debugLine="End Sub";
return "";
}
}