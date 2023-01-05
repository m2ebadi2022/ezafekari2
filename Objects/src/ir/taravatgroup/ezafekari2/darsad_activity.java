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

public class darsad_activity extends Activity implements B4AActivity{
	public static darsad_activity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.darsad_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (darsad_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.darsad_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.darsad_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (darsad_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (darsad_activity) Resume **");
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
		return darsad_activity.class;
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
            BA.LogInfo("** Activity (darsad_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (darsad_activity) Pause event (activity is not paused). **");
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
            darsad_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (darsad_activity) Resume **");
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
public anywheresoftware.b4a.objects.EditTextWrapper _et_r1_asli = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_r1_darsad = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_r2_asli = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_r2_joze = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_r1_megdar_darsad = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_r1_megdar_kol = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_r2_darsad = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_r2_result = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_r1_result = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_darsad = null;
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.ayabzahab_activity _ayabzahab_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.food_activity _food_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.gestha_activity _gestha_activity = null;
public ir.taravatgroup.ezafekari2.help_kharid_activity _help_kharid_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.mosaedeh_activity _mosaedeh_activity = null;
public ir.taravatgroup.ezafekari2.padash_activity _padash_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
public ir.taravatgroup.ezafekari2.sayer_activity _sayer_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 31;BA.debugLine="Activity.LoadLayout(\"darsad_layout\")";
mostCurrent._activity.LoadLayout("darsad_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 32;BA.debugLine="ScrollView1.Panel.LoadLayout(\"item_darsad\")";
mostCurrent._scrollview1.getPanel().LoadLayout("item_darsad",mostCurrent.activityBA);
 //BA.debugLineNum = 35;BA.debugLine="pan_hed_darsad.Color=Main.color4";
mostCurrent._pan_hed_darsad.setColor(mostCurrent._main._color4 /*int*/ );
 //BA.debugLineNum = 36;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 56;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 57;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 //BA.debugLineNum = 58;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 60;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public static String  _et_r1_asli_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 107;BA.debugLine="Private Sub et_R1_asli_TextChanged (Old As String,";
 //BA.debugLineNum = 108;BA.debugLine="et_R1_asli.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_r1_asli.setTag((Object)(_new.replace(",","")));
 //BA.debugLineNum = 109;BA.debugLine="myfunc.change_formater(Old,New,et_R1_asli)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_r1_asli);
 //BA.debugLineNum = 110;BA.debugLine="If(et_R1_asli.Text <> \"\" And et_R1_darsad.Text <>";
if (((mostCurrent._et_r1_asli.getText()).equals("") == false && (mostCurrent._et_r1_darsad.getText()).equals("") == false)) { 
 //BA.debugLineNum = 111;BA.debugLine="run1";
_run1();
 };
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public static String  _et_r1_darsad_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 99;BA.debugLine="Private Sub et_R1_darsad_TextChanged (Old As Strin";
 //BA.debugLineNum = 100;BA.debugLine="et_R1_asli.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_r1_asli.setTag((Object)(_new.replace(",","")));
 //BA.debugLineNum = 101;BA.debugLine="myfunc.change_formater(Old,New,et_R1_asli)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_r1_asli);
 //BA.debugLineNum = 102;BA.debugLine="If(et_R1_asli.Text <> \"\" And et_R1_darsad.Text <>";
if (((mostCurrent._et_r1_asli.getText()).equals("") == false && (mostCurrent._et_r1_darsad.getText()).equals("") == false)) { 
 //BA.debugLineNum = 103;BA.debugLine="run1";
_run1();
 };
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public static String  _et_r2_asli_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 125;BA.debugLine="Private Sub et_R2_asli_TextChanged (Old As String,";
 //BA.debugLineNum = 126;BA.debugLine="et_R2_asli.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_r2_asli.setTag((Object)(_new.replace(",","")));
 //BA.debugLineNum = 127;BA.debugLine="myfunc.change_formater(Old,New,et_R2_asli)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_r2_asli);
 //BA.debugLineNum = 130;BA.debugLine="If(et_R2_asli.Text <> \"\" And et_R2_joze.Text <> \"";
if (((mostCurrent._et_r2_asli.getText()).equals("") == false && (mostCurrent._et_r2_joze.getText()).equals("") == false)) { 
 //BA.debugLineNum = 131;BA.debugLine="run2";
_run2();
 };
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public static String  _et_r2_joze_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 117;BA.debugLine="Private Sub et_R2_joze_TextChanged (Old As String,";
 //BA.debugLineNum = 118;BA.debugLine="et_R2_joze.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_r2_joze.setTag((Object)(_new.replace(",","")));
 //BA.debugLineNum = 119;BA.debugLine="myfunc.change_formater(Old,New,et_R2_joze)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_r2_joze);
 //BA.debugLineNum = 120;BA.debugLine="If(et_R2_asli.Text <> \"\" And et_R2_joze.Text <> \"";
if (((mostCurrent._et_r2_asli.getText()).equals("") == false && (mostCurrent._et_r2_joze.getText()).equals("") == false)) { 
 //BA.debugLineNum = 121;BA.debugLine="run2";
_run2();
 };
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private et_R1_asli As EditText";
mostCurrent._et_r1_asli = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private et_R1_darsad As EditText";
mostCurrent._et_r1_darsad = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private et_R2_asli As EditText";
mostCurrent._et_r2_asli = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private et_R2_joze As EditText";
mostCurrent._et_r2_joze = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private lbl_R1_megdar_darsad As Label";
mostCurrent._lbl_r1_megdar_darsad = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private lbl_R1_megdar_kol As Label";
mostCurrent._lbl_r1_megdar_kol = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_R2_darsad As Label";
mostCurrent._lbl_r2_darsad = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private lbl_R2_result As Label";
mostCurrent._lbl_r2_result = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private lbl_R1_result As Label";
mostCurrent._lbl_r1_result = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private ScrollView1 As ScrollView";
mostCurrent._scrollview1 = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private pan_hed_darsad As Panel";
mostCurrent._pan_hed_darsad = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 49;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _run1() throws Exception{
long _a = 0L;
double _b = 0;
long _c = 0L;
long _d = 0L;
 //BA.debugLineNum = 68;BA.debugLine="Private Sub run1";
 //BA.debugLineNum = 70;BA.debugLine="Dim a   As Long =0";
_a = (long) (0);
 //BA.debugLineNum = 71;BA.debugLine="Dim  b  As Double =0";
_b = 0;
 //BA.debugLineNum = 73;BA.debugLine="Dim c,d As Long=0";
_c = 0L;
_d = (long) (0);
 //BA.debugLineNum = 74;BA.debugLine="a=et_R1_asli.tag";
_a = BA.ObjectToLongNumber(mostCurrent._et_r1_asli.getTag());
 //BA.debugLineNum = 75;BA.debugLine="b=et_R1_darsad.Text";
_b = (double)(Double.parseDouble(mostCurrent._et_r1_darsad.getText()));
 //BA.debugLineNum = 78;BA.debugLine="c=a*(b/100)";
_c = (long) (_a*(_b/(double)100));
 //BA.debugLineNum = 79;BA.debugLine="d=a-c";
_d = (long) (_a-_c);
 //BA.debugLineNum = 81;BA.debugLine="lbl_R1_megdar_darsad.Text=myfunc.show_num_pool(c)";
mostCurrent._lbl_r1_megdar_darsad.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int) (_c))));
 //BA.debugLineNum = 82;BA.debugLine="lbl_R1_megdar_kol.Text=myfunc.show_num_pool(d)";
mostCurrent._lbl_r1_megdar_kol.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int) (_d))));
 //BA.debugLineNum = 84;BA.debugLine="lbl_R1_result.Text=b&\" درصد از \"&myfunc.show_num_";
mostCurrent._lbl_r1_result.setText(BA.ObjectToCharSequence(BA.NumberToString(_b)+" درصد از "+mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int) (_a))+" برابر است با : "+mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int) (_c))));
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public static String  _run2() throws Exception{
long _a = 0L;
long _b = 0L;
double _c = 0;
 //BA.debugLineNum = 87;BA.debugLine="Private Sub run2";
 //BA.debugLineNum = 88;BA.debugLine="Dim a , b  As Long =0";
_a = 0L;
_b = (long) (0);
 //BA.debugLineNum = 89;BA.debugLine="Dim c As Double=0";
_c = 0;
 //BA.debugLineNum = 90;BA.debugLine="a=et_R2_asli.Tag";
_a = BA.ObjectToLongNumber(mostCurrent._et_r2_asli.getTag());
 //BA.debugLineNum = 91;BA.debugLine="b=et_R2_joze.tag";
_b = BA.ObjectToLongNumber(mostCurrent._et_r2_joze.getTag());
 //BA.debugLineNum = 92;BA.debugLine="c=(b/a)*100";
_c = (_b/(double)_a)*100;
 //BA.debugLineNum = 95;BA.debugLine="lbl_R2_darsad.Text=c & \"  درصد  \"";
mostCurrent._lbl_r2_darsad.setText(BA.ObjectToCharSequence(BA.NumberToString(_c)+"  درصد  "));
 //BA.debugLineNum = 96;BA.debugLine="lbl_R2_result.Text=myfunc.show_num_pool(b)&\" براب";
mostCurrent._lbl_r2_result.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int) (_b))+" برابر است با : "+BA.NumberToString(_c)+" درصد عدد "+mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int) (_a))));
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return "";
}
}
