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

public class setting_hogog_activity extends Activity implements B4AActivity{
	public static setting_hogog_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.setting_hogog_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (setting_hogog_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.setting_hogog_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.setting_hogog_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (setting_hogog_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (setting_hogog_activity) Resume **");
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
		return setting_hogog_activity.class;
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
            BA.LogInfo("** Activity (setting_hogog_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (setting_hogog_activity) Pause event (activity is not paused). **");
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
            setting_hogog_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (setting_hogog_activity) Resume **");
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
public anywheresoftware.b4a.objects.EditTextWrapper _et_paye = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_maskan = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_fani = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_masoliat = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_olad = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_bon = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_bime_takmil = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_maliat = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_bime_tamin = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_vahed = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_shift = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_sanavat = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_sarparast = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mazaya = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _sp_ganon_kar = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scv_sett_hogog = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _sp_olad = null;
public static int _olad_vahed = 0;
public anywheresoftware.b4a.objects.EditTextWrapper _et_ksorat = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_sethogog = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_onvanha = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_onv_new = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv_def = null;
public static int _current_index_onvan = 0;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv6 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv7 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv10 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv14 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv15 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv9 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv8 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv11 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv12 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv13 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_saat_kari = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_min_kari = null;
public static int _min_saat_kari = 0;
public anywheresoftware.b4a.objects.EditTextWrapper _et_hamsar = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onv16 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chek_hamsar = null;
public static int _hamsar_int = 0;
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
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
int _sat1 = 0;
int _dag1 = 0;
int _pay_ch = 0;
RDebugUtils.currentLine=50397184;
 //BA.debugLineNum = 50397184;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=50397186;
 //BA.debugLineNum = 50397186;BA.debugLine="Activity.LoadLayout(\"setting_hogog_layout\")";
mostCurrent._activity.LoadLayout("setting_hogog_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=50397187;
 //BA.debugLineNum = 50397187;BA.debugLine="scv_sett_hogog.Panel.LoadLayout(\"sett_hogog_item\"";
mostCurrent._scv_sett_hogog.getPanel().LoadLayout("sett_hogog_item",mostCurrent.activityBA);
RDebugUtils.currentLine=50397188;
 //BA.debugLineNum = 50397188;BA.debugLine="et_paye.Color=Colors.White";
mostCurrent._et_paye.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397189;
 //BA.debugLineNum = 50397189;BA.debugLine="et_maskan.Color=Colors.White";
mostCurrent._et_maskan.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397190;
 //BA.debugLineNum = 50397190;BA.debugLine="et_fani.Color=Colors.White";
mostCurrent._et_fani.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397191;
 //BA.debugLineNum = 50397191;BA.debugLine="et_masoliat.Color=Colors.White";
mostCurrent._et_masoliat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397192;
 //BA.debugLineNum = 50397192;BA.debugLine="et_olad.Color=Colors.White";
mostCurrent._et_olad.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397193;
 //BA.debugLineNum = 50397193;BA.debugLine="et_bon.Color=Colors.White";
mostCurrent._et_bon.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397194;
 //BA.debugLineNum = 50397194;BA.debugLine="et_hamsar.Color=Colors.White";
mostCurrent._et_hamsar.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397196;
 //BA.debugLineNum = 50397196;BA.debugLine="et_bime_takmil.Color=Colors.White";
mostCurrent._et_bime_takmil.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397197;
 //BA.debugLineNum = 50397197;BA.debugLine="et_maliat.Color=Colors.White";
mostCurrent._et_maliat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397198;
 //BA.debugLineNum = 50397198;BA.debugLine="et_bime_tamin.Color=Colors.White";
mostCurrent._et_bime_tamin.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397199;
 //BA.debugLineNum = 50397199;BA.debugLine="et_shift.Color=Colors.White";
mostCurrent._et_shift.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397200;
 //BA.debugLineNum = 50397200;BA.debugLine="et_sanavat.Color=Colors.White";
mostCurrent._et_sanavat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397201;
 //BA.debugLineNum = 50397201;BA.debugLine="et_sarparast.Color=Colors.White";
mostCurrent._et_sarparast.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397202;
 //BA.debugLineNum = 50397202;BA.debugLine="et_mazaya.Color=Colors.White";
mostCurrent._et_mazaya.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397203;
 //BA.debugLineNum = 50397203;BA.debugLine="et_ksorat.Color=Colors.White";
mostCurrent._et_ksorat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397204;
 //BA.debugLineNum = 50397204;BA.debugLine="et_saat_kari.Color=Colors.White";
mostCurrent._et_saat_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397205;
 //BA.debugLineNum = 50397205;BA.debugLine="et_min_kari.Color=Colors.White";
mostCurrent._et_min_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50397208;
 //BA.debugLineNum = 50397208;BA.debugLine="read_onvan";
_read_onvan();
RDebugUtils.currentLine=50397211;
 //BA.debugLineNum = 50397211;BA.debugLine="pan_hed_sethogog.Color=Main.color4";
mostCurrent._pan_hed_sethogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=50397212;
 //BA.debugLineNum = 50397212;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=50397219;
 //BA.debugLineNum = 50397219;BA.debugLine="olad_vahed=1039096    ' sal 1404  eslah";
_olad_vahed = (int) (1039096);
RDebugUtils.currentLine=50397224;
 //BA.debugLineNum = 50397224;BA.debugLine="sp_ganon_kar.Add(\"سال 1404\")";
mostCurrent._sp_ganon_kar.Add("سال 1404");
RDebugUtils.currentLine=50397225;
 //BA.debugLineNum = 50397225;BA.debugLine="sp_ganon_kar.Add(\"سال 1403\")";
mostCurrent._sp_ganon_kar.Add("سال 1403");
RDebugUtils.currentLine=50397226;
 //BA.debugLineNum = 50397226;BA.debugLine="sp_ganon_kar.Add(\"سال 1402\")";
mostCurrent._sp_ganon_kar.Add("سال 1402");
RDebugUtils.currentLine=50397227;
 //BA.debugLineNum = 50397227;BA.debugLine="sp_ganon_kar.Add(\"سال 1401\")";
mostCurrent._sp_ganon_kar.Add("سال 1401");
RDebugUtils.currentLine=50397228;
 //BA.debugLineNum = 50397228;BA.debugLine="sp_ganon_kar.Add(\"سال 1400\")";
mostCurrent._sp_ganon_kar.Add("سال 1400");
RDebugUtils.currentLine=50397229;
 //BA.debugLineNum = 50397229;BA.debugLine="sp_ganon_kar.Add(\"سال 1399\")";
mostCurrent._sp_ganon_kar.Add("سال 1399");
RDebugUtils.currentLine=50397230;
 //BA.debugLineNum = 50397230;BA.debugLine="sp_ganon_kar.Add(\"سفارشی شده\")";
mostCurrent._sp_ganon_kar.Add("سفارشی شده");
RDebugUtils.currentLine=50397235;
 //BA.debugLineNum = 50397235;BA.debugLine="sp_olad.AddAll(Array As String(0,1,2,3,4,5,6,7,8,";
mostCurrent._sp_olad.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9),BA.NumberToString(10)}));
RDebugUtils.currentLine=50397240;
 //BA.debugLineNum = 50397240;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=50397241;
 //BA.debugLineNum = 50397241;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=50397243;
 //BA.debugLineNum = 50397243;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=50397244;
 //BA.debugLineNum = 50397244;BA.debugLine="et_paye.Text=myfunc.show_num_pool(dbCode.res.GetS";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=50397245;
 //BA.debugLineNum = 50397245;BA.debugLine="et_paye.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_paye.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=50397249;
 //BA.debugLineNum = 50397249;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (1));
RDebugUtils.currentLine=50397250;
 //BA.debugLineNum = 50397250;BA.debugLine="et_maskan.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_maskan.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=50397251;
 //BA.debugLineNum = 50397251;BA.debugLine="et_maskan.Text=myfunc.show_num_pool(dbCode.res.Ge";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=50397253;
 //BA.debugLineNum = 50397253;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (3));
RDebugUtils.currentLine=50397254;
 //BA.debugLineNum = 50397254;BA.debugLine="et_olad.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_olad.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=50397255;
 //BA.debugLineNum = 50397255;BA.debugLine="et_olad.Text=myfunc.show_num_pool(dbCode.res.GetS";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=50397259;
 //BA.debugLineNum = 50397259;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (4));
RDebugUtils.currentLine=50397260;
 //BA.debugLineNum = 50397260;BA.debugLine="et_fani.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_fani.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=50397261;
 //BA.debugLineNum = 50397261;BA.debugLine="et_fani.Text=myfunc.show_num_pool(dbCode.res.GetS";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=50397263;
 //BA.debugLineNum = 50397263;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (5));
RDebugUtils.currentLine=50397264;
 //BA.debugLineNum = 50397264;BA.debugLine="et_masoliat.tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_masoliat.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=50397265;
 //BA.debugLineNum = 50397265;BA.debugLine="et_masoliat.Text=myfunc.show_num_pool(dbCode.res.";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=50397267;
 //BA.debugLineNum = 50397267;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (2));
RDebugUtils.currentLine=50397268;
 //BA.debugLineNum = 50397268;BA.debugLine="et_bon.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_bon.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=50397269;
 //BA.debugLineNum = 50397269;BA.debugLine="et_bon.Text=myfunc.show_num_pool(dbCode.res.GetSt";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=50397274;
 //BA.debugLineNum = 50397274;BA.debugLine="dbCode.res.Position=6 ''--------bime_tamin------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (6));
RDebugUtils.currentLine=50397275;
 //BA.debugLineNum = 50397275;BA.debugLine="et_bime_tamin.Text=dbCode.res.GetString(\"value\")";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=50397277;
 //BA.debugLineNum = 50397277;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (11));
RDebugUtils.currentLine=50397278;
 //BA.debugLineNum = 50397278;BA.debugLine="et_bime_takmil.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_bime_takmil.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=50397279;
 //BA.debugLineNum = 50397279;BA.debugLine="et_bime_takmil.Text=myfunc.show_num_pool(dbCode.r";
mostCurrent._et_bime_takmil.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=50397281;
 //BA.debugLineNum = 50397281;BA.debugLine="dbCode.res.Position=13 ''--------hag shift------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (13));
RDebugUtils.currentLine=50397282;
 //BA.debugLineNum = 50397282;BA.debugLine="et_shift.Text=dbCode.res.GetString(\"value\")";
mostCurrent._et_shift.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=50397284;
 //BA.debugLineNum = 50397284;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (14));
RDebugUtils.currentLine=50397285;
 //BA.debugLineNum = 50397285;BA.debugLine="et_sanavat.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_sanavat.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=50397286;
 //BA.debugLineNum = 50397286;BA.debugLine="et_sanavat.Text=myfunc.show_num_pool(dbCode.res.G";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=50397288;
 //BA.debugLineNum = 50397288;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (15));
RDebugUtils.currentLine=50397289;
 //BA.debugLineNum = 50397289;BA.debugLine="et_sarparast.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_sarparast.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=50397290;
 //BA.debugLineNum = 50397290;BA.debugLine="et_sarparast.Text=myfunc.show_num_pool(dbCode.res";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=50397292;
 //BA.debugLineNum = 50397292;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (16));
RDebugUtils.currentLine=50397293;
 //BA.debugLineNum = 50397293;BA.debugLine="et_mazaya.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_mazaya.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=50397294;
 //BA.debugLineNum = 50397294;BA.debugLine="et_mazaya.Text=myfunc.show_num_pool(dbCode.res.Ge";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=50397296;
 //BA.debugLineNum = 50397296;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (19));
RDebugUtils.currentLine=50397297;
 //BA.debugLineNum = 50397297;BA.debugLine="et_ksorat.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_ksorat.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=50397298;
 //BA.debugLineNum = 50397298;BA.debugLine="et_ksorat.Text=myfunc.show_num_pool(dbCode.res.Ge";
mostCurrent._et_ksorat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=50397306;
 //BA.debugLineNum = 50397306;BA.debugLine="dbCode.res.Position=18 ''--------number olad-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (18));
RDebugUtils.currentLine=50397307;
 //BA.debugLineNum = 50397307;BA.debugLine="sp_olad.SelectedIndex=dbCode.res.GetString(\"value";
mostCurrent._sp_olad.setSelectedIndex((int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))));
RDebugUtils.currentLine=50397309;
 //BA.debugLineNum = 50397309;BA.debugLine="dbCode.res.Position=26 ''--------saat  kari dar r";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (26));
RDebugUtils.currentLine=50397310;
 //BA.debugLineNum = 50397310;BA.debugLine="min_saat_kari=dbCode.res.GetString(\"value\")";
_min_saat_kari = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=50397312;
 //BA.debugLineNum = 50397312;BA.debugLine="Dim sat1 As Int= min_saat_kari/60";
_sat1 = (int) (_min_saat_kari/(double)60);
RDebugUtils.currentLine=50397313;
 //BA.debugLineNum = 50397313;BA.debugLine="Dim dag1 As Int= min_saat_kari Mod 60";
_dag1 = (int) (_min_saat_kari%60);
RDebugUtils.currentLine=50397315;
 //BA.debugLineNum = 50397315;BA.debugLine="et_saat_kari.Text=sat1";
mostCurrent._et_saat_kari.setText(BA.ObjectToCharSequence(_sat1));
RDebugUtils.currentLine=50397316;
 //BA.debugLineNum = 50397316;BA.debugLine="et_min_kari.Text=dag1";
mostCurrent._et_min_kari.setText(BA.ObjectToCharSequence(_dag1));
RDebugUtils.currentLine=50397324;
 //BA.debugLineNum = 50397324;BA.debugLine="lbl_vahed.Text=\"واحد : تومان\"";
mostCurrent._lbl_vahed.setText(BA.ObjectToCharSequence("واحد : تومان"));
RDebugUtils.currentLine=50397326;
 //BA.debugLineNum = 50397326;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=50397327;
 //BA.debugLineNum = 50397327;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=50397332;
 //BA.debugLineNum = 50397332;BA.debugLine="et_hamsar.Tag=dbCode.get_setting_byName(\"hag_hams";
mostCurrent._et_hamsar.setTag((Object)(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"hag_hamsar")));
RDebugUtils.currentLine=50397333;
 //BA.debugLineNum = 50397333;BA.debugLine="et_hamsar.Text=myfunc.show_num_pool(et_hamsar.Tag";
mostCurrent._et_hamsar.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._et_hamsar.getTag())))));
RDebugUtils.currentLine=50397334;
 //BA.debugLineNum = 50397334;BA.debugLine="If(et_hamsar.Tag > 0)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._et_hamsar.getTag()))>0)) { 
RDebugUtils.currentLine=50397335;
 //BA.debugLineNum = 50397335;BA.debugLine="chek_hamsar.Checked=True";
mostCurrent._chek_hamsar.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=50397337;
 //BA.debugLineNum = 50397337;BA.debugLine="chek_hamsar.Checked=False";
mostCurrent._chek_hamsar.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=50397343;
 //BA.debugLineNum = 50397343;BA.debugLine="Dim pay_ch As Int=et_paye.tag";
_pay_ch = (int)(BA.ObjectToNumber(mostCurrent._et_paye.getTag()));
RDebugUtils.currentLine=50397345;
 //BA.debugLineNum = 50397345;BA.debugLine="If (pay_ch=10390968)Then   '' sal 1404  eslah";
if ((_pay_ch==10390968)) { 
RDebugUtils.currentLine=50397346;
 //BA.debugLineNum = 50397346;BA.debugLine="sp_ganon_kar.SelectedIndex=0";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (0));
 }else 
{RDebugUtils.currentLine=50397347;
 //BA.debugLineNum = 50397347;BA.debugLine="else If (pay_ch=7166184)Then   '' sal 1403";
if ((_pay_ch==7166184)) { 
RDebugUtils.currentLine=50397348;
 //BA.debugLineNum = 50397348;BA.debugLine="sp_ganon_kar.SelectedIndex=1";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (1));
 }else 
{RDebugUtils.currentLine=50397350;
 //BA.debugLineNum = 50397350;BA.debugLine="else If (pay_ch=5308284)Then    ''sal 1402";
if ((_pay_ch==5308284)) { 
RDebugUtils.currentLine=50397351;
 //BA.debugLineNum = 50397351;BA.debugLine="sp_ganon_kar.SelectedIndex=2";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (2));
 }else 
{RDebugUtils.currentLine=50397353;
 //BA.debugLineNum = 50397353;BA.debugLine="else If (pay_ch=4179755)Then";
if ((_pay_ch==4179755)) { 
RDebugUtils.currentLine=50397354;
 //BA.debugLineNum = 50397354;BA.debugLine="sp_ganon_kar.SelectedIndex=3";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (3));
 }else 
{RDebugUtils.currentLine=50397356;
 //BA.debugLineNum = 50397356;BA.debugLine="else If (pay_ch=2655492)Then";
if ((_pay_ch==2655492)) { 
RDebugUtils.currentLine=50397357;
 //BA.debugLineNum = 50397357;BA.debugLine="sp_ganon_kar.SelectedIndex=4";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (4));
 }else 
{RDebugUtils.currentLine=50397359;
 //BA.debugLineNum = 50397359;BA.debugLine="Else If (pay_ch=1910427) Then";
if ((_pay_ch==1910427)) { 
RDebugUtils.currentLine=50397360;
 //BA.debugLineNum = 50397360;BA.debugLine="sp_ganon_kar.SelectedIndex=5";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (5));
 }else {
RDebugUtils.currentLine=50397362;
 //BA.debugLineNum = 50397362;BA.debugLine="sp_ganon_kar.SelectedIndex=6";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (6));
 }}}}}}
;
RDebugUtils.currentLine=50397367;
 //BA.debugLineNum = 50397367;BA.debugLine="If (File.Exists(File.DirInternal,\"help_set_hogog\"";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_set_hogog")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=50397368;
 //BA.debugLineNum = 50397368;BA.debugLine="show_help";
_show_help();
RDebugUtils.currentLine=50397369;
 //BA.debugLineNum = 50397369;BA.debugLine="File.WriteString(File.DirInternal,\"help_set_hogo";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_set_hogog","");
 };
RDebugUtils.currentLine=50397372;
 //BA.debugLineNum = 50397372;BA.debugLine="End Sub";
return "";
}
public static String  _read_onvan() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "read_onvan", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "read_onvan", null));}
anywheresoftware.b4a.objects.collections.List _ls_onv = null;
RDebugUtils.currentLine=51838976;
 //BA.debugLineNum = 51838976;BA.debugLine="Sub read_onvan";
RDebugUtils.currentLine=51838978;
 //BA.debugLineNum = 51838978;BA.debugLine="Dim ls_onv As List";
_ls_onv = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=51838979;
 //BA.debugLineNum = 51838979;BA.debugLine="ls_onv.Initialize";
_ls_onv.Initialize();
RDebugUtils.currentLine=51838980;
 //BA.debugLineNum = 51838980;BA.debugLine="ls_onv=dbCode.read_onvan_db";
_ls_onv = mostCurrent._dbcode._read_onvan_db /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=51838983;
 //BA.debugLineNum = 51838983;BA.debugLine="lbl_onv1.Text=ls_onv.Get(0)";
mostCurrent._lbl_onv1.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (0))));
RDebugUtils.currentLine=51838984;
 //BA.debugLineNum = 51838984;BA.debugLine="lbl_onv2.Text=ls_onv.Get(1)";
mostCurrent._lbl_onv2.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (1))));
RDebugUtils.currentLine=51838985;
 //BA.debugLineNum = 51838985;BA.debugLine="lbl_onv3.Text=ls_onv.Get(2)";
mostCurrent._lbl_onv3.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (2))));
RDebugUtils.currentLine=51838986;
 //BA.debugLineNum = 51838986;BA.debugLine="lbl_onv4.Text=ls_onv.Get(3)";
mostCurrent._lbl_onv4.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (3))));
RDebugUtils.currentLine=51838987;
 //BA.debugLineNum = 51838987;BA.debugLine="lbl_onv5.Text=ls_onv.Get(4)";
mostCurrent._lbl_onv5.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (4))));
RDebugUtils.currentLine=51838988;
 //BA.debugLineNum = 51838988;BA.debugLine="lbl_onv6.Text=ls_onv.Get(5)";
mostCurrent._lbl_onv6.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (5))));
RDebugUtils.currentLine=51838989;
 //BA.debugLineNum = 51838989;BA.debugLine="lbl_onv7.Text=ls_onv.Get(6)";
mostCurrent._lbl_onv7.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (6))));
RDebugUtils.currentLine=51838990;
 //BA.debugLineNum = 51838990;BA.debugLine="lbl_onv8.Text=ls_onv.Get(7)";
mostCurrent._lbl_onv8.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (7))));
RDebugUtils.currentLine=51838991;
 //BA.debugLineNum = 51838991;BA.debugLine="lbl_onv9.Text=ls_onv.Get(8)";
mostCurrent._lbl_onv9.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (8))));
RDebugUtils.currentLine=51838992;
 //BA.debugLineNum = 51838992;BA.debugLine="lbl_onv10.Text=ls_onv.Get(9)";
mostCurrent._lbl_onv10.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (9))));
RDebugUtils.currentLine=51838993;
 //BA.debugLineNum = 51838993;BA.debugLine="lbl_onv11.Text=ls_onv.Get(10)";
mostCurrent._lbl_onv11.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (10))));
RDebugUtils.currentLine=51838994;
 //BA.debugLineNum = 51838994;BA.debugLine="lbl_onv12.Text=ls_onv.Get(11)";
mostCurrent._lbl_onv12.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (11))));
RDebugUtils.currentLine=51838995;
 //BA.debugLineNum = 51838995;BA.debugLine="lbl_onv13.Text=ls_onv.Get(12)";
mostCurrent._lbl_onv13.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (12))));
RDebugUtils.currentLine=51838996;
 //BA.debugLineNum = 51838996;BA.debugLine="lbl_onv16.Text=ls_onv.Get(13)";
mostCurrent._lbl_onv16.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (13))));
RDebugUtils.currentLine=51838999;
 //BA.debugLineNum = 51838999;BA.debugLine="End Sub";
return "";
}
public static String  _show_help() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_help", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_help", null));}
RDebugUtils.currentLine=50462720;
 //BA.debugLineNum = 50462720;BA.debugLine="Sub show_help";
RDebugUtils.currentLine=50462721;
 //BA.debugLineNum = 50462721;BA.debugLine="Msgbox(\"همه قیمت ها به تومان می باشد\",\"هشدار مهم\"";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("همه قیمت ها به تومان می باشد"),BA.ObjectToCharSequence("هشدار مهم"),mostCurrent.activityBA);
RDebugUtils.currentLine=50462722;
 //BA.debugLineNum = 50462722;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=50790400;
 //BA.debugLineNum = 50790400;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=50790401;
 //BA.debugLineNum = 50790401;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=50790402;
 //BA.debugLineNum = 50790402;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=50790403;
 //BA.debugLineNum = 50790403;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=50790405;
 //BA.debugLineNum = 50790405;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=50790407;
 //BA.debugLineNum = 50790407;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=50659328;
 //BA.debugLineNum = 50659328;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=50659330;
 //BA.debugLineNum = 50659330;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=50659331;
 //BA.debugLineNum = 50659331;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=50659334;
 //BA.debugLineNum = 50659334;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
RDebugUtils.currentLine=50593792;
 //BA.debugLineNum = 50593792;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=50593794;
 //BA.debugLineNum = 50593794;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=50528256;
 //BA.debugLineNum = 50528256;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=50528258;
 //BA.debugLineNum = 50528258;BA.debugLine="End Sub";
return "";
}
public static String  _chek_hamsar_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chek_hamsar_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chek_hamsar_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=52363264;
 //BA.debugLineNum = 52363264;BA.debugLine="Private Sub chek_hamsar_CheckedChange(Checked As B";
RDebugUtils.currentLine=52363265;
 //BA.debugLineNum = 52363265;BA.debugLine="If(Checked)Then";
if ((_checked)) { 
RDebugUtils.currentLine=52363266;
 //BA.debugLineNum = 52363266;BA.debugLine="et_hamsar.Tag=hamsar_int";
mostCurrent._et_hamsar.setTag((Object)(_hamsar_int));
RDebugUtils.currentLine=52363267;
 //BA.debugLineNum = 52363267;BA.debugLine="et_hamsar.Text=myfunc.show_num_pool(hamsar_int)";
mostCurrent._et_hamsar.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_hamsar_int)));
 }else {
RDebugUtils.currentLine=52363270;
 //BA.debugLineNum = 52363270;BA.debugLine="et_hamsar.Tag=0";
mostCurrent._et_hamsar.setTag((Object)(0));
RDebugUtils.currentLine=52363271;
 //BA.debugLineNum = 52363271;BA.debugLine="et_hamsar.Text=myfunc.show_num_pool(0)";
mostCurrent._et_hamsar.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int) (0))));
 };
RDebugUtils.currentLine=52363274;
 //BA.debugLineNum = 52363274;BA.debugLine="End Sub";
return "";
}
public static boolean  _empty_fild(anywheresoftware.b4a.objects.EditTextWrapper _et) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "empty_fild", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "empty_fild", new Object[] {_et}));}
RDebugUtils.currentLine=51773440;
 //BA.debugLineNum = 51773440;BA.debugLine="Sub empty_fild(et As EditText) As Boolean";
RDebugUtils.currentLine=51773441;
 //BA.debugLineNum = 51773441;BA.debugLine="If(et.Text.Trim=\"\")Then";
if (((_et.getText().trim()).equals(""))) { 
RDebugUtils.currentLine=51773442;
 //BA.debugLineNum = 51773442;BA.debugLine="ToastMessageShow(\"فیلد خالی است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("فیلد خالی است"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51773443;
 //BA.debugLineNum = 51773443;BA.debugLine="et.Color=0x9FFF4E4E";
_et.setColor(((int)0x9fff4e4e));
RDebugUtils.currentLine=51773444;
 //BA.debugLineNum = 51773444;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=51773446;
 //BA.debugLineNum = 51773446;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=51773447;
 //BA.debugLineNum = 51773447;BA.debugLine="End Sub";
return false;
}
public static String  _et_bime_takmil_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_bime_takmil_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_bime_takmil_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=51183616;
 //BA.debugLineNum = 51183616;BA.debugLine="Private Sub et_bime_takmil_TextChanged (Old As Str";
RDebugUtils.currentLine=51183617;
 //BA.debugLineNum = 51183617;BA.debugLine="et_bime_takmil.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_bime_takmil.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=51183618;
 //BA.debugLineNum = 51183618;BA.debugLine="myfunc.change_formater(Old,New,et_bime_takmil)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_bime_takmil);
RDebugUtils.currentLine=51183619;
 //BA.debugLineNum = 51183619;BA.debugLine="End Sub";
return "";
}
public static String  _et_bon_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_bon_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_bon_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=51249152;
 //BA.debugLineNum = 51249152;BA.debugLine="Private Sub et_bon_TextChanged (Old As String, New";
RDebugUtils.currentLine=51249153;
 //BA.debugLineNum = 51249153;BA.debugLine="et_bon.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_bon.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=51249154;
 //BA.debugLineNum = 51249154;BA.debugLine="myfunc.change_formater(Old,New,et_bon)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_bon);
RDebugUtils.currentLine=51249155;
 //BA.debugLineNum = 51249155;BA.debugLine="End Sub";
return "";
}
public static String  _et_fani_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_fani_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_fani_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=51511296;
 //BA.debugLineNum = 51511296;BA.debugLine="Private Sub et_fani_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=51511297;
 //BA.debugLineNum = 51511297;BA.debugLine="et_fani.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_fani.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=51511298;
 //BA.debugLineNum = 51511298;BA.debugLine="myfunc.change_formater(Old,New,et_fani)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_fani);
RDebugUtils.currentLine=51511299;
 //BA.debugLineNum = 51511299;BA.debugLine="End Sub";
return "";
}
public static String  _et_hamsar_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_hamsar_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_hamsar_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=51314688;
 //BA.debugLineNum = 51314688;BA.debugLine="Private Sub et_hamsar_TextChanged (Old As String,";
RDebugUtils.currentLine=51314689;
 //BA.debugLineNum = 51314689;BA.debugLine="et_hamsar.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_hamsar.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=51314690;
 //BA.debugLineNum = 51314690;BA.debugLine="myfunc.change_formater(Old,New,et_hamsar)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_hamsar);
RDebugUtils.currentLine=51314691;
 //BA.debugLineNum = 51314691;BA.debugLine="End Sub";
return "";
}
public static String  _et_ksorat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_ksorat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_ksorat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=51118080;
 //BA.debugLineNum = 51118080;BA.debugLine="Private Sub et_ksorat_TextChanged (Old As String,";
RDebugUtils.currentLine=51118081;
 //BA.debugLineNum = 51118081;BA.debugLine="et_ksorat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_ksorat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=51118082;
 //BA.debugLineNum = 51118082;BA.debugLine="myfunc.change_formater(Old,New,et_ksorat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_ksorat);
RDebugUtils.currentLine=51118083;
 //BA.debugLineNum = 51118083;BA.debugLine="End Sub";
return "";
}
public static String  _et_maskan_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_maskan_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_maskan_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=51642368;
 //BA.debugLineNum = 51642368;BA.debugLine="Private Sub et_maskan_TextChanged (Old As String,";
RDebugUtils.currentLine=51642369;
 //BA.debugLineNum = 51642369;BA.debugLine="et_maskan.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_maskan.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=51642370;
 //BA.debugLineNum = 51642370;BA.debugLine="myfunc.change_formater(Old,New,et_maskan)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_maskan);
RDebugUtils.currentLine=51642371;
 //BA.debugLineNum = 51642371;BA.debugLine="End Sub";
return "";
}
public static String  _et_masoliat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_masoliat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_masoliat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=51445760;
 //BA.debugLineNum = 51445760;BA.debugLine="Private Sub et_masoliat_TextChanged (Old As String";
RDebugUtils.currentLine=51445761;
 //BA.debugLineNum = 51445761;BA.debugLine="et_masoliat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_masoliat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=51445762;
 //BA.debugLineNum = 51445762;BA.debugLine="myfunc.change_formater(Old,New,et_masoliat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_masoliat);
RDebugUtils.currentLine=51445763;
 //BA.debugLineNum = 51445763;BA.debugLine="End Sub";
return "";
}
public static String  _et_mazaya_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mazaya_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mazaya_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=51052544;
 //BA.debugLineNum = 51052544;BA.debugLine="Private Sub et_mazaya_TextChanged (Old As String,";
RDebugUtils.currentLine=51052545;
 //BA.debugLineNum = 51052545;BA.debugLine="et_mazaya.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_mazaya.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=51052546;
 //BA.debugLineNum = 51052546;BA.debugLine="myfunc.change_formater(Old,New,et_mazaya)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_mazaya);
RDebugUtils.currentLine=51052547;
 //BA.debugLineNum = 51052547;BA.debugLine="End Sub";
return "";
}
public static String  _et_olad_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_olad_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_olad_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=51576832;
 //BA.debugLineNum = 51576832;BA.debugLine="Private Sub et_olad_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=51576833;
 //BA.debugLineNum = 51576833;BA.debugLine="et_olad.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_olad.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=51576834;
 //BA.debugLineNum = 51576834;BA.debugLine="myfunc.change_formater(Old,New,et_olad)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_olad);
RDebugUtils.currentLine=51576835;
 //BA.debugLineNum = 51576835;BA.debugLine="End Sub";
return "";
}
public static String  _et_paye_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_paye_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_paye_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=50987008;
 //BA.debugLineNum = 50987008;BA.debugLine="Private Sub et_paye_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=50987009;
 //BA.debugLineNum = 50987009;BA.debugLine="et_paye.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_paye.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=50987010;
 //BA.debugLineNum = 50987010;BA.debugLine="myfunc.change_formater(Old,New,et_paye)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_paye);
RDebugUtils.currentLine=50987011;
 //BA.debugLineNum = 50987011;BA.debugLine="End Sub";
return "";
}
public static String  _et_sanavat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_sanavat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_sanavat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=51707904;
 //BA.debugLineNum = 51707904;BA.debugLine="Private Sub et_sanavat_TextChanged (Old As String,";
RDebugUtils.currentLine=51707905;
 //BA.debugLineNum = 51707905;BA.debugLine="et_sanavat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_sanavat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=51707906;
 //BA.debugLineNum = 51707906;BA.debugLine="myfunc.change_formater(Old,New,et_sanavat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_sanavat);
RDebugUtils.currentLine=51707907;
 //BA.debugLineNum = 51707907;BA.debugLine="End Sub";
return "";
}
public static String  _et_sarparast_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_sarparast_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_sarparast_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=51380224;
 //BA.debugLineNum = 51380224;BA.debugLine="Private Sub et_sarparast_TextChanged (Old As Strin";
RDebugUtils.currentLine=51380225;
 //BA.debugLineNum = 51380225;BA.debugLine="et_sarparast.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_sarparast.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=51380226;
 //BA.debugLineNum = 51380226;BA.debugLine="myfunc.change_formater(Old,New,et_sarparast)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_sarparast);
RDebugUtils.currentLine=51380227;
 //BA.debugLineNum = 51380227;BA.debugLine="End Sub";
return "";
}
public static String  _ev_onv_longclick() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ev_onv_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ev_onv_longclick", null));}
anywheresoftware.b4a.objects.LabelWrapper _this_onv = null;
RDebugUtils.currentLine=52035584;
 //BA.debugLineNum = 52035584;BA.debugLine="Private Sub EV_onv_LongClick";
RDebugUtils.currentLine=52035585;
 //BA.debugLineNum = 52035585;BA.debugLine="Dim this_onv As Label";
_this_onv = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=52035586;
 //BA.debugLineNum = 52035586;BA.debugLine="this_onv=Sender";
_this_onv = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=52035589;
 //BA.debugLineNum = 52035589;BA.debugLine="current_index_onvan=this_onv.Tag";
_current_index_onvan = (int)(BA.ObjectToNumber(_this_onv.getTag()));
RDebugUtils.currentLine=52035591;
 //BA.debugLineNum = 52035591;BA.debugLine="lbl_onv_def.Text=get_onvan_byId(this_onv.Tag).Get";
mostCurrent._lbl_onv_def.setText(BA.ObjectToCharSequence(_get_onvan_byid((int)(BA.ObjectToNumber(_this_onv.getTag()))).Get((int) (0))));
RDebugUtils.currentLine=52035592;
 //BA.debugLineNum = 52035592;BA.debugLine="et_onv_new.Text=get_onvan_byId(this_onv.Tag).Get(";
mostCurrent._et_onv_new.setText(BA.ObjectToCharSequence(_get_onvan_byid((int)(BA.ObjectToNumber(_this_onv.getTag()))).Get((int) (1))));
RDebugUtils.currentLine=52035595;
 //BA.debugLineNum = 52035595;BA.debugLine="pan_all_onvanHa.Visible=True";
mostCurrent._pan_all_onvanha.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=52035596;
 //BA.debugLineNum = 52035596;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _get_onvan_byid(int _id1) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_onvan_byid", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(mostCurrent.activityBA, "get_onvan_byid", new Object[] {_id1}));}
anywheresoftware.b4a.objects.collections.List _ls_result = null;
RDebugUtils.currentLine=52166656;
 //BA.debugLineNum = 52166656;BA.debugLine="Sub get_onvan_byId (id1 As Int) As List";
RDebugUtils.currentLine=52166657;
 //BA.debugLineNum = 52166657;BA.debugLine="Dim ls_result As List";
_ls_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=52166658;
 //BA.debugLineNum = 52166658;BA.debugLine="ls_result.Initialize";
_ls_result.Initialize();
RDebugUtils.currentLine=52166659;
 //BA.debugLineNum = 52166659;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=52166660;
 //BA.debugLineNum = 52166660;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tbl_onvanha WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=52166661;
 //BA.debugLineNum = 52166661;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=52166662;
 //BA.debugLineNum = 52166662;BA.debugLine="ls_result.Add(dbCode.res.GetString(\"def_name\"))";
_ls_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("def_name")));
RDebugUtils.currentLine=52166663;
 //BA.debugLineNum = 52166663;BA.debugLine="ls_result.Add(dbCode.res.GetString(\"custom_name\")";
_ls_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("custom_name")));
RDebugUtils.currentLine=52166664;
 //BA.debugLineNum = 52166664;BA.debugLine="Return ls_result";
if (true) return _ls_result;
RDebugUtils.currentLine=52166665;
 //BA.debugLineNum = 52166665;BA.debugLine="End Sub";
return null;
}
public static String  _lbl_help_onv_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_onv_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_onv_click", null));}
RDebugUtils.currentLine=52297728;
 //BA.debugLineNum = 52297728;BA.debugLine="Private Sub lbl_help_onv_Click";
RDebugUtils.currentLine=52297729;
 //BA.debugLineNum = 52297729;BA.debugLine="myfunc.help_man(\"راهنما\",\"با نگه داشتن انگشت روی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","با نگه داشتن انگشت روی عنوان آیتم ها میتوانید آنها را ویرایش کنید. توجه داشته باشید که عملکرد آنها در محاسبات تغییر نخواهد کرد.");
RDebugUtils.currentLine=52297730;
 //BA.debugLineNum = 52297730;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_onv_def_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_onv_def_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_onv_def_click", null));}
RDebugUtils.currentLine=52232192;
 //BA.debugLineNum = 52232192;BA.debugLine="Private Sub lbl_onv_def_Click";
RDebugUtils.currentLine=52232193;
 //BA.debugLineNum = 52232193;BA.debugLine="et_onv_new.Text=lbl_onv_def.Text";
mostCurrent._et_onv_new.setText(BA.ObjectToCharSequence(mostCurrent._lbl_onv_def.getText()));
RDebugUtils.currentLine=52232195;
 //BA.debugLineNum = 52232195;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_click", null));}
boolean _exep = false;
int _min_sat_kar = 0;
anywheresoftware.b4a.objects.collections.List _data = null;
RDebugUtils.currentLine=50724864;
 //BA.debugLineNum = 50724864;BA.debugLine="Private Sub lbl_save_Click";
RDebugUtils.currentLine=50724865;
 //BA.debugLineNum = 50724865;BA.debugLine="Dim exep As Boolean=True";
_exep = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=50724867;
 //BA.debugLineNum = 50724867;BA.debugLine="et_paye.Color=Colors.White";
mostCurrent._et_paye.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50724868;
 //BA.debugLineNum = 50724868;BA.debugLine="et_maskan.Color=Colors.White";
mostCurrent._et_maskan.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50724869;
 //BA.debugLineNum = 50724869;BA.debugLine="et_fani.Color=Colors.White";
mostCurrent._et_fani.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50724870;
 //BA.debugLineNum = 50724870;BA.debugLine="et_masoliat.Color=Colors.White";
mostCurrent._et_masoliat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50724871;
 //BA.debugLineNum = 50724871;BA.debugLine="et_olad.Color=Colors.White";
mostCurrent._et_olad.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50724872;
 //BA.debugLineNum = 50724872;BA.debugLine="et_bon.Color=Colors.White";
mostCurrent._et_bon.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50724873;
 //BA.debugLineNum = 50724873;BA.debugLine="et_hamsar.Color=Colors.White";
mostCurrent._et_hamsar.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50724875;
 //BA.debugLineNum = 50724875;BA.debugLine="et_bime_takmil.Color=Colors.White";
mostCurrent._et_bime_takmil.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50724878;
 //BA.debugLineNum = 50724878;BA.debugLine="et_shift.Color=Colors.White";
mostCurrent._et_shift.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50724879;
 //BA.debugLineNum = 50724879;BA.debugLine="et_sanavat.Color=Colors.White";
mostCurrent._et_sanavat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50724880;
 //BA.debugLineNum = 50724880;BA.debugLine="et_sarparast.Color=Colors.White";
mostCurrent._et_sarparast.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50724881;
 //BA.debugLineNum = 50724881;BA.debugLine="et_mazaya.Color=Colors.White";
mostCurrent._et_mazaya.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50724882;
 //BA.debugLineNum = 50724882;BA.debugLine="et_ksorat.Color=Colors.White";
mostCurrent._et_ksorat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50724883;
 //BA.debugLineNum = 50724883;BA.debugLine="et_saat_kari.Color=Colors.White";
mostCurrent._et_saat_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50724884;
 //BA.debugLineNum = 50724884;BA.debugLine="et_min_kari.Color=Colors.White";
mostCurrent._et_min_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=50724899;
 //BA.debugLineNum = 50724899;BA.debugLine="et_maliat.TextColor=Colors.Black";
mostCurrent._et_maliat.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=50724902;
 //BA.debugLineNum = 50724902;BA.debugLine="If(et_shift.Text=\"\")Then";
if (((mostCurrent._et_shift.getText()).equals(""))) { 
RDebugUtils.currentLine=50724903;
 //BA.debugLineNum = 50724903;BA.debugLine="et_shift.Text=0";
mostCurrent._et_shift.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=50724905;
 //BA.debugLineNum = 50724905;BA.debugLine="If(et_saat_kari.Text=\"\")Then";
if (((mostCurrent._et_saat_kari.getText()).equals(""))) { 
RDebugUtils.currentLine=50724906;
 //BA.debugLineNum = 50724906;BA.debugLine="et_saat_kari.Text=8";
mostCurrent._et_saat_kari.setText(BA.ObjectToCharSequence(8));
 };
RDebugUtils.currentLine=50724908;
 //BA.debugLineNum = 50724908;BA.debugLine="If(et_min_kari.Text=\"\")Then";
if (((mostCurrent._et_min_kari.getText()).equals(""))) { 
RDebugUtils.currentLine=50724909;
 //BA.debugLineNum = 50724909;BA.debugLine="et_min_kari.Text=0";
mostCurrent._et_min_kari.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=50724913;
 //BA.debugLineNum = 50724913;BA.debugLine="If(et_shift.Text>100 Or et_shift.Text<0 Or  et_sh";
if (((double)(Double.parseDouble(mostCurrent._et_shift.getText()))>100 || (double)(Double.parseDouble(mostCurrent._et_shift.getText()))<0 || (mostCurrent._et_shift.getText()).equals(""))) { 
RDebugUtils.currentLine=50724914;
 //BA.debugLineNum = 50724914;BA.debugLine="ToastMessageShow(\"خطا درصد-(0 تا 100)\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا درصد-(0 تا 100)"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=50724915;
 //BA.debugLineNum = 50724915;BA.debugLine="et_shift.TextColor=Colors.Red";
mostCurrent._et_shift.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=50724916;
 //BA.debugLineNum = 50724916;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=50724918;
 //BA.debugLineNum = 50724918;BA.debugLine="et_shift.TextColor=Colors.Black";
mostCurrent._et_shift.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=50724921;
 //BA.debugLineNum = 50724921;BA.debugLine="If(et_saat_kari.Text>24 Or et_saat_kari.Text<0 )T";
if (((double)(Double.parseDouble(mostCurrent._et_saat_kari.getText()))>24 || (double)(Double.parseDouble(mostCurrent._et_saat_kari.getText()))<0)) { 
RDebugUtils.currentLine=50724922;
 //BA.debugLineNum = 50724922;BA.debugLine="ToastMessageShow(\"ساعت کاری را اصلاح نمائید\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ساعت کاری را اصلاح نمائید"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=50724923;
 //BA.debugLineNum = 50724923;BA.debugLine="et_saat_kari.TextColor=Colors.Red";
mostCurrent._et_saat_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=50724924;
 //BA.debugLineNum = 50724924;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=50724926;
 //BA.debugLineNum = 50724926;BA.debugLine="et_saat_kari.TextColor=Colors.Black";
mostCurrent._et_saat_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=50724929;
 //BA.debugLineNum = 50724929;BA.debugLine="If(et_min_kari.Text>59 Or et_min_kari.Text<0 )The";
if (((double)(Double.parseDouble(mostCurrent._et_min_kari.getText()))>59 || (double)(Double.parseDouble(mostCurrent._et_min_kari.getText()))<0)) { 
RDebugUtils.currentLine=50724930;
 //BA.debugLineNum = 50724930;BA.debugLine="ToastMessageShow(\"ساعت کاری را اصلاح نمائید\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ساعت کاری را اصلاح نمائید"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=50724931;
 //BA.debugLineNum = 50724931;BA.debugLine="et_min_kari.TextColor=Colors.Red";
mostCurrent._et_min_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=50724932;
 //BA.debugLineNum = 50724932;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=50724934;
 //BA.debugLineNum = 50724934;BA.debugLine="et_min_kari.TextColor=Colors.Black";
mostCurrent._et_min_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=50724940;
 //BA.debugLineNum = 50724940;BA.debugLine="If(empty_fild(et_paye)=True)Then";
if ((_empty_fild(mostCurrent._et_paye)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=50724941;
 //BA.debugLineNum = 50724941;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=50724943;
 //BA.debugLineNum = 50724943;BA.debugLine="If(empty_fild(et_maskan)=True)Then";
if ((_empty_fild(mostCurrent._et_maskan)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=50724944;
 //BA.debugLineNum = 50724944;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=50724946;
 //BA.debugLineNum = 50724946;BA.debugLine="If(empty_fild(et_bon)=True)Then";
if ((_empty_fild(mostCurrent._et_bon)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=50724947;
 //BA.debugLineNum = 50724947;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=50724949;
 //BA.debugLineNum = 50724949;BA.debugLine="If(empty_fild(et_hamsar)=True)Then";
if ((_empty_fild(mostCurrent._et_hamsar)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=50724950;
 //BA.debugLineNum = 50724950;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=50724953;
 //BA.debugLineNum = 50724953;BA.debugLine="If(et_sanavat.Text=\"\")Then";
if (((mostCurrent._et_sanavat.getText()).equals(""))) { 
RDebugUtils.currentLine=50724954;
 //BA.debugLineNum = 50724954;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=50724956;
 //BA.debugLineNum = 50724956;BA.debugLine="If(et_olad.Text=\"\")Then";
if (((mostCurrent._et_olad.getText()).equals(""))) { 
RDebugUtils.currentLine=50724957;
 //BA.debugLineNum = 50724957;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=50724959;
 //BA.debugLineNum = 50724959;BA.debugLine="If(et_fani.Text=\"\")Then";
if (((mostCurrent._et_fani.getText()).equals(""))) { 
RDebugUtils.currentLine=50724960;
 //BA.debugLineNum = 50724960;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=50724962;
 //BA.debugLineNum = 50724962;BA.debugLine="If(et_masoliat.Text=\"\")Then";
if (((mostCurrent._et_masoliat.getText()).equals(""))) { 
RDebugUtils.currentLine=50724963;
 //BA.debugLineNum = 50724963;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=50724965;
 //BA.debugLineNum = 50724965;BA.debugLine="If(et_sarparast.Text=\"\")Then";
if (((mostCurrent._et_sarparast.getText()).equals(""))) { 
RDebugUtils.currentLine=50724966;
 //BA.debugLineNum = 50724966;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=50724968;
 //BA.debugLineNum = 50724968;BA.debugLine="If(et_bime_takmil.Text=\"\")Then";
if (((mostCurrent._et_bime_takmil.getText()).equals(""))) { 
RDebugUtils.currentLine=50724969;
 //BA.debugLineNum = 50724969;BA.debugLine="et_bime_takmil.Text=0";
mostCurrent._et_bime_takmil.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=50724971;
 //BA.debugLineNum = 50724971;BA.debugLine="If(et_mazaya.Text=\"\")Then";
if (((mostCurrent._et_mazaya.getText()).equals(""))) { 
RDebugUtils.currentLine=50724972;
 //BA.debugLineNum = 50724972;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=50724974;
 //BA.debugLineNum = 50724974;BA.debugLine="If(et_ksorat.Text=\"\")Then";
if (((mostCurrent._et_ksorat.getText()).equals(""))) { 
RDebugUtils.currentLine=50724975;
 //BA.debugLineNum = 50724975;BA.debugLine="et_ksorat.Text=0";
mostCurrent._et_ksorat.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=50724979;
 //BA.debugLineNum = 50724979;BA.debugLine="Dim min_sat_kar As Int=(et_saat_kari.Text*60)+et_";
_min_sat_kar = (int) (((double)(Double.parseDouble(mostCurrent._et_saat_kari.getText()))*60)+(double)(Double.parseDouble(mostCurrent._et_min_kari.getText())));
RDebugUtils.currentLine=50724981;
 //BA.debugLineNum = 50724981;BA.debugLine="If(exep=True)Then";
if ((_exep==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=50724982;
 //BA.debugLineNum = 50724982;BA.debugLine="Dim data As List";
_data = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=50724983;
 //BA.debugLineNum = 50724983;BA.debugLine="data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=50724984;
 //BA.debugLineNum = 50724984;BA.debugLine="data.AddAll(Array As String(et_paye.Tag,et_maska";
_data.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{BA.ObjectToString(mostCurrent._et_paye.getTag()),BA.ObjectToString(mostCurrent._et_maskan.getTag()),BA.ObjectToString(mostCurrent._et_olad.getTag()),BA.ObjectToString(mostCurrent._et_fani.getTag()),BA.ObjectToString(mostCurrent._et_masoliat.getTag()),BA.ObjectToString(mostCurrent._et_bon.getTag()),mostCurrent._et_bime_tamin.getText(),BA.ObjectToString(mostCurrent._et_bime_takmil.getTag()),BA.NumberToString(10),mostCurrent._et_shift.getText(),BA.ObjectToString(mostCurrent._et_sanavat.getTag()),BA.ObjectToString(mostCurrent._et_sarparast.getTag()),BA.ObjectToString(mostCurrent._et_mazaya.getTag()),mostCurrent._sp_olad.getSelectedItem(),BA.ObjectToString(mostCurrent._et_ksorat.getTag()),BA.NumberToString(_min_sat_kar),BA.ObjectToString(mostCurrent._et_hamsar.getTag())}));
RDebugUtils.currentLine=50724987;
 //BA.debugLineNum = 50724987;BA.debugLine="If (dbCode.add_setting_hogog(data)) Then";
if ((mostCurrent._dbcode._add_setting_hogog /*boolean*/ (mostCurrent.activityBA,_data))) { 
RDebugUtils.currentLine=50724988;
 //BA.debugLineNum = 50724988;BA.debugLine="ToastMessageShow (\"ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=50724990;
 //BA.debugLineNum = 50724990;BA.debugLine="Main.saat_kar_min=min_sat_kar";
mostCurrent._main._saat_kar_min /*int*/  = _min_sat_kar;
RDebugUtils.currentLine=50724991;
 //BA.debugLineNum = 50724991;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 };
RDebugUtils.currentLine=50724998;
 //BA.debugLineNum = 50724998;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_onvan_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_onvan_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_onvan_click", null));}
RDebugUtils.currentLine=52101120;
 //BA.debugLineNum = 52101120;BA.debugLine="Private Sub lbl_save_onvan_Click";
RDebugUtils.currentLine=52101121;
 //BA.debugLineNum = 52101121;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=52101122;
 //BA.debugLineNum = 52101122;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tbl_onvanha SET '";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tbl_onvanha SET 'custom_name' ='"+mostCurrent._et_onv_new.getText()+"'  WHERE id="+BA.NumberToString(_current_index_onvan));
RDebugUtils.currentLine=52101124;
 //BA.debugLineNum = 52101124;BA.debugLine="read_onvan";
_read_onvan();
RDebugUtils.currentLine=52101125;
 //BA.debugLineNum = 52101125;BA.debugLine="pan_all_onvanHa.Visible=False";
mostCurrent._pan_all_onvanha.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=52101126;
 //BA.debugLineNum = 52101126;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_onvanha_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_onvanha_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_onvanha_click", null));}
RDebugUtils.currentLine=51904512;
 //BA.debugLineNum = 51904512;BA.debugLine="Private Sub pan_all_onvanHa_Click";
RDebugUtils.currentLine=51904514;
 //BA.debugLineNum = 51904514;BA.debugLine="pan_all_onvanHa.Visible=False";
mostCurrent._pan_all_onvanha.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51904515;
 //BA.debugLineNum = 51904515;BA.debugLine="End Sub";
return "";
}
public static String  _panel15_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel15_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel15_click", null));}
RDebugUtils.currentLine=51970048;
 //BA.debugLineNum = 51970048;BA.debugLine="Private Sub Panel15_Click";
RDebugUtils.currentLine=51970050;
 //BA.debugLineNum = 51970050;BA.debugLine="End Sub";
return "";
}
public static String  _sp_ganon_kar_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_ganon_kar_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_ganon_kar_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=50855936;
 //BA.debugLineNum = 50855936;BA.debugLine="Private Sub sp_ganon_kar_ItemClick (Position As In";
RDebugUtils.currentLine=50855939;
 //BA.debugLineNum = 50855939;BA.debugLine="Select Value";
switch (BA.switchObjectToInt(_value,(Object)("سال 1404"),(Object)("سال 1403"),(Object)("سال 1402"),(Object)("سال 1401"),(Object)("سال 1400"),(Object)("سال 1399"))) {
case 0: {
RDebugUtils.currentLine=50855942;
 //BA.debugLineNum = 50855942;BA.debugLine="et_paye.Text=10390968";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(10390968));
RDebugUtils.currentLine=50855943;
 //BA.debugLineNum = 50855943;BA.debugLine="et_maskan.Text=900000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(900000));
RDebugUtils.currentLine=50855944;
 //BA.debugLineNum = 50855944;BA.debugLine="et_bon.Text=2200000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(2200000));
RDebugUtils.currentLine=50855946;
 //BA.debugLineNum = 50855946;BA.debugLine="hamsar_int=500000";
_hamsar_int = (int) (500000);
RDebugUtils.currentLine=50855948;
 //BA.debugLineNum = 50855948;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=50855951;
 //BA.debugLineNum = 50855951;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50855952;
 //BA.debugLineNum = 50855952;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50855953;
 //BA.debugLineNum = 50855953;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50855954;
 //BA.debugLineNum = 50855954;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50855957;
 //BA.debugLineNum = 50855957;BA.debugLine="olad_vahed=1039096";
_olad_vahed = (int) (1039096);
RDebugUtils.currentLine=50855958;
 //BA.debugLineNum = 50855958;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50855962;
 //BA.debugLineNum = 50855962;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
case 1: {
RDebugUtils.currentLine=50855966;
 //BA.debugLineNum = 50855966;BA.debugLine="et_paye.Text=7166184";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(7166184));
RDebugUtils.currentLine=50855967;
 //BA.debugLineNum = 50855967;BA.debugLine="et_maskan.Text=900000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(900000));
RDebugUtils.currentLine=50855968;
 //BA.debugLineNum = 50855968;BA.debugLine="et_bon.Text=1400000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(1400000));
RDebugUtils.currentLine=50855970;
 //BA.debugLineNum = 50855970;BA.debugLine="hamsar_int=500000";
_hamsar_int = (int) (500000);
RDebugUtils.currentLine=50855972;
 //BA.debugLineNum = 50855972;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=50855975;
 //BA.debugLineNum = 50855975;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50855976;
 //BA.debugLineNum = 50855976;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50855977;
 //BA.debugLineNum = 50855977;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50855978;
 //BA.debugLineNum = 50855978;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50855981;
 //BA.debugLineNum = 50855981;BA.debugLine="olad_vahed=716618";
_olad_vahed = (int) (716618);
RDebugUtils.currentLine=50855982;
 //BA.debugLineNum = 50855982;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50855986;
 //BA.debugLineNum = 50855986;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
case 2: {
RDebugUtils.currentLine=50855992;
 //BA.debugLineNum = 50855992;BA.debugLine="et_paye.Text=5308284";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(5308284));
RDebugUtils.currentLine=50855993;
 //BA.debugLineNum = 50855993;BA.debugLine="et_maskan.Text=900000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(900000));
RDebugUtils.currentLine=50855994;
 //BA.debugLineNum = 50855994;BA.debugLine="et_bon.Text=1100000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(1100000));
RDebugUtils.currentLine=50855995;
 //BA.debugLineNum = 50855995;BA.debugLine="hamsar_int=0";
_hamsar_int = (int) (0);
RDebugUtils.currentLine=50855996;
 //BA.debugLineNum = 50855996;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=50855999;
 //BA.debugLineNum = 50855999;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856000;
 //BA.debugLineNum = 50856000;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856001;
 //BA.debugLineNum = 50856001;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856002;
 //BA.debugLineNum = 50856002;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856005;
 //BA.debugLineNum = 50856005;BA.debugLine="olad_vahed=530828";
_olad_vahed = (int) (530828);
RDebugUtils.currentLine=50856006;
 //BA.debugLineNum = 50856006;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856010;
 //BA.debugLineNum = 50856010;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
case 3: {
RDebugUtils.currentLine=50856013;
 //BA.debugLineNum = 50856013;BA.debugLine="et_paye.Text=4179755";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(4179755));
RDebugUtils.currentLine=50856014;
 //BA.debugLineNum = 50856014;BA.debugLine="et_maskan.Text=650000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(650000));
RDebugUtils.currentLine=50856015;
 //BA.debugLineNum = 50856015;BA.debugLine="et_bon.Text=850000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(850000));
RDebugUtils.currentLine=50856016;
 //BA.debugLineNum = 50856016;BA.debugLine="hamsar_int=0";
_hamsar_int = (int) (0);
RDebugUtils.currentLine=50856017;
 //BA.debugLineNum = 50856017;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=50856020;
 //BA.debugLineNum = 50856020;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856021;
 //BA.debugLineNum = 50856021;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856022;
 //BA.debugLineNum = 50856022;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856023;
 //BA.debugLineNum = 50856023;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856026;
 //BA.debugLineNum = 50856026;BA.debugLine="olad_vahed=417975";
_olad_vahed = (int) (417975);
RDebugUtils.currentLine=50856027;
 //BA.debugLineNum = 50856027;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856031;
 //BA.debugLineNum = 50856031;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
case 4: {
RDebugUtils.currentLine=50856034;
 //BA.debugLineNum = 50856034;BA.debugLine="et_paye.Text=2655492";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(2655492));
RDebugUtils.currentLine=50856035;
 //BA.debugLineNum = 50856035;BA.debugLine="et_maskan.Text=450000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(450000));
RDebugUtils.currentLine=50856036;
 //BA.debugLineNum = 50856036;BA.debugLine="et_bon.Text=600000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(600000));
RDebugUtils.currentLine=50856037;
 //BA.debugLineNum = 50856037;BA.debugLine="hamsar_int=0";
_hamsar_int = (int) (0);
RDebugUtils.currentLine=50856038;
 //BA.debugLineNum = 50856038;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=50856041;
 //BA.debugLineNum = 50856041;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856042;
 //BA.debugLineNum = 50856042;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856043;
 //BA.debugLineNum = 50856043;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856044;
 //BA.debugLineNum = 50856044;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856047;
 //BA.debugLineNum = 50856047;BA.debugLine="olad_vahed=265549";
_olad_vahed = (int) (265549);
RDebugUtils.currentLine=50856048;
 //BA.debugLineNum = 50856048;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856052;
 //BA.debugLineNum = 50856052;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
case 5: {
RDebugUtils.currentLine=50856055;
 //BA.debugLineNum = 50856055;BA.debugLine="et_paye.Text=1910427";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(1910427));
RDebugUtils.currentLine=50856056;
 //BA.debugLineNum = 50856056;BA.debugLine="et_maskan.Text=300000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(300000));
RDebugUtils.currentLine=50856057;
 //BA.debugLineNum = 50856057;BA.debugLine="et_bon.Text=400000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(400000));
RDebugUtils.currentLine=50856058;
 //BA.debugLineNum = 50856058;BA.debugLine="hamsar_int=0";
_hamsar_int = (int) (0);
RDebugUtils.currentLine=50856059;
 //BA.debugLineNum = 50856059;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=50856062;
 //BA.debugLineNum = 50856062;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856063;
 //BA.debugLineNum = 50856063;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856064;
 //BA.debugLineNum = 50856064;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856065;
 //BA.debugLineNum = 50856065;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856068;
 //BA.debugLineNum = 50856068;BA.debugLine="olad_vahed=191127";
_olad_vahed = (int) (191127);
RDebugUtils.currentLine=50856069;
 //BA.debugLineNum = 50856069;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856073;
 //BA.debugLineNum = 50856073;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
default: {
RDebugUtils.currentLine=50856076;
 //BA.debugLineNum = 50856076;BA.debugLine="et_paye.Text=0";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856077;
 //BA.debugLineNum = 50856077;BA.debugLine="et_maskan.Text=0";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856078;
 //BA.debugLineNum = 50856078;BA.debugLine="et_bon.Text=0";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856079;
 //BA.debugLineNum = 50856079;BA.debugLine="hamsar_int=500000";
_hamsar_int = (int) (500000);
RDebugUtils.currentLine=50856080;
 //BA.debugLineNum = 50856080;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=50856083;
 //BA.debugLineNum = 50856083;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856084;
 //BA.debugLineNum = 50856084;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856085;
 //BA.debugLineNum = 50856085;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856086;
 //BA.debugLineNum = 50856086;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856088;
 //BA.debugLineNum = 50856088;BA.debugLine="olad_vahed=0";
_olad_vahed = (int) (0);
RDebugUtils.currentLine=50856089;
 //BA.debugLineNum = 50856089;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=50856091;
 //BA.debugLineNum = 50856091;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
}
;
RDebugUtils.currentLine=50856096;
 //BA.debugLineNum = 50856096;BA.debugLine="End Sub";
return "";
}
public static String  _sp_olad_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_olad_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_olad_itemclick", new Object[] {_position,_value}));}
int _num = 0;
RDebugUtils.currentLine=50921472;
 //BA.debugLineNum = 50921472;BA.debugLine="Private Sub sp_olad_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=50921473;
 //BA.debugLineNum = 50921473;BA.debugLine="Dim num As Int=Value";
_num = (int)(BA.ObjectToNumber(_value));
RDebugUtils.currentLine=50921474;
 //BA.debugLineNum = 50921474;BA.debugLine="et_olad.Text=olad_vahed*num";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(_olad_vahed*_num));
RDebugUtils.currentLine=50921475;
 //BA.debugLineNum = 50921475;BA.debugLine="End Sub";
return "";
}
}