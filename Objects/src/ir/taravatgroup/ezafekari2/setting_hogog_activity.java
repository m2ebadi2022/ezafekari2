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
RDebugUtils.currentLine=37552128;
 //BA.debugLineNum = 37552128;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=37552130;
 //BA.debugLineNum = 37552130;BA.debugLine="Activity.LoadLayout(\"setting_hogog_layout\")";
mostCurrent._activity.LoadLayout("setting_hogog_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=37552131;
 //BA.debugLineNum = 37552131;BA.debugLine="scv_sett_hogog.Panel.LoadLayout(\"sett_hogog_item\"";
mostCurrent._scv_sett_hogog.getPanel().LoadLayout("sett_hogog_item",mostCurrent.activityBA);
RDebugUtils.currentLine=37552132;
 //BA.debugLineNum = 37552132;BA.debugLine="et_paye.Color=Colors.White";
mostCurrent._et_paye.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552133;
 //BA.debugLineNum = 37552133;BA.debugLine="et_maskan.Color=Colors.White";
mostCurrent._et_maskan.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552134;
 //BA.debugLineNum = 37552134;BA.debugLine="et_fani.Color=Colors.White";
mostCurrent._et_fani.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552135;
 //BA.debugLineNum = 37552135;BA.debugLine="et_masoliat.Color=Colors.White";
mostCurrent._et_masoliat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552136;
 //BA.debugLineNum = 37552136;BA.debugLine="et_olad.Color=Colors.White";
mostCurrent._et_olad.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552137;
 //BA.debugLineNum = 37552137;BA.debugLine="et_bon.Color=Colors.White";
mostCurrent._et_bon.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552138;
 //BA.debugLineNum = 37552138;BA.debugLine="et_bime_takmil.Color=Colors.White";
mostCurrent._et_bime_takmil.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552139;
 //BA.debugLineNum = 37552139;BA.debugLine="et_maliat.Color=Colors.White";
mostCurrent._et_maliat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552140;
 //BA.debugLineNum = 37552140;BA.debugLine="et_bime_tamin.Color=Colors.White";
mostCurrent._et_bime_tamin.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552141;
 //BA.debugLineNum = 37552141;BA.debugLine="et_shift.Color=Colors.White";
mostCurrent._et_shift.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552142;
 //BA.debugLineNum = 37552142;BA.debugLine="et_sanavat.Color=Colors.White";
mostCurrent._et_sanavat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552143;
 //BA.debugLineNum = 37552143;BA.debugLine="et_sarparast.Color=Colors.White";
mostCurrent._et_sarparast.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552144;
 //BA.debugLineNum = 37552144;BA.debugLine="et_mazaya.Color=Colors.White";
mostCurrent._et_mazaya.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552145;
 //BA.debugLineNum = 37552145;BA.debugLine="et_ksorat.Color=Colors.White";
mostCurrent._et_ksorat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552146;
 //BA.debugLineNum = 37552146;BA.debugLine="et_saat_kari.Color=Colors.White";
mostCurrent._et_saat_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552147;
 //BA.debugLineNum = 37552147;BA.debugLine="et_min_kari.Color=Colors.White";
mostCurrent._et_min_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37552150;
 //BA.debugLineNum = 37552150;BA.debugLine="read_onvan";
_read_onvan();
RDebugUtils.currentLine=37552153;
 //BA.debugLineNum = 37552153;BA.debugLine="pan_hed_sethogog.Color=Main.color4";
mostCurrent._pan_hed_sethogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=37552154;
 //BA.debugLineNum = 37552154;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=37552159;
 //BA.debugLineNum = 37552159;BA.debugLine="olad_vahed=530828    ' sal 1402";
_olad_vahed = (int) (530828);
RDebugUtils.currentLine=37552164;
 //BA.debugLineNum = 37552164;BA.debugLine="sp_ganon_kar.Add(\"سال 1402\")";
mostCurrent._sp_ganon_kar.Add("سال 1402");
RDebugUtils.currentLine=37552165;
 //BA.debugLineNum = 37552165;BA.debugLine="sp_ganon_kar.Add(\"سال 1401\")";
mostCurrent._sp_ganon_kar.Add("سال 1401");
RDebugUtils.currentLine=37552166;
 //BA.debugLineNum = 37552166;BA.debugLine="sp_ganon_kar.Add(\"سال 1400\")";
mostCurrent._sp_ganon_kar.Add("سال 1400");
RDebugUtils.currentLine=37552167;
 //BA.debugLineNum = 37552167;BA.debugLine="sp_ganon_kar.Add(\"سال 1399\")";
mostCurrent._sp_ganon_kar.Add("سال 1399");
RDebugUtils.currentLine=37552168;
 //BA.debugLineNum = 37552168;BA.debugLine="sp_ganon_kar.Add(\"سفارشی شده\")";
mostCurrent._sp_ganon_kar.Add("سفارشی شده");
RDebugUtils.currentLine=37552173;
 //BA.debugLineNum = 37552173;BA.debugLine="sp_olad.AddAll(Array As String(0,1,2,3,4,5,6,7,8,";
mostCurrent._sp_olad.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9),BA.NumberToString(10)}));
RDebugUtils.currentLine=37552178;
 //BA.debugLineNum = 37552178;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=37552179;
 //BA.debugLineNum = 37552179;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=37552181;
 //BA.debugLineNum = 37552181;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=37552182;
 //BA.debugLineNum = 37552182;BA.debugLine="et_paye.Text=myfunc.show_num_pool(dbCode.res.GetS";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=37552183;
 //BA.debugLineNum = 37552183;BA.debugLine="et_paye.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_paye.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=37552187;
 //BA.debugLineNum = 37552187;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (1));
RDebugUtils.currentLine=37552188;
 //BA.debugLineNum = 37552188;BA.debugLine="et_maskan.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_maskan.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=37552189;
 //BA.debugLineNum = 37552189;BA.debugLine="et_maskan.Text=myfunc.show_num_pool(dbCode.res.Ge";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=37552191;
 //BA.debugLineNum = 37552191;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (3));
RDebugUtils.currentLine=37552192;
 //BA.debugLineNum = 37552192;BA.debugLine="et_olad.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_olad.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=37552193;
 //BA.debugLineNum = 37552193;BA.debugLine="et_olad.Text=myfunc.show_num_pool(dbCode.res.GetS";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=37552195;
 //BA.debugLineNum = 37552195;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (4));
RDebugUtils.currentLine=37552196;
 //BA.debugLineNum = 37552196;BA.debugLine="et_fani.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_fani.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=37552197;
 //BA.debugLineNum = 37552197;BA.debugLine="et_fani.Text=myfunc.show_num_pool(dbCode.res.GetS";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=37552199;
 //BA.debugLineNum = 37552199;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (5));
RDebugUtils.currentLine=37552200;
 //BA.debugLineNum = 37552200;BA.debugLine="et_masoliat.tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_masoliat.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=37552201;
 //BA.debugLineNum = 37552201;BA.debugLine="et_masoliat.Text=myfunc.show_num_pool(dbCode.res.";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=37552203;
 //BA.debugLineNum = 37552203;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (2));
RDebugUtils.currentLine=37552204;
 //BA.debugLineNum = 37552204;BA.debugLine="et_bon.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_bon.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=37552205;
 //BA.debugLineNum = 37552205;BA.debugLine="et_bon.Text=myfunc.show_num_pool(dbCode.res.GetSt";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=37552207;
 //BA.debugLineNum = 37552207;BA.debugLine="dbCode.res.Position=6 ''--------bime_tamin------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (6));
RDebugUtils.currentLine=37552208;
 //BA.debugLineNum = 37552208;BA.debugLine="et_bime_tamin.Text=dbCode.res.GetString(\"value\")";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=37552210;
 //BA.debugLineNum = 37552210;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (11));
RDebugUtils.currentLine=37552211;
 //BA.debugLineNum = 37552211;BA.debugLine="et_bime_takmil.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_bime_takmil.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=37552212;
 //BA.debugLineNum = 37552212;BA.debugLine="et_bime_takmil.Text=myfunc.show_num_pool(dbCode.r";
mostCurrent._et_bime_takmil.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=37552214;
 //BA.debugLineNum = 37552214;BA.debugLine="dbCode.res.Position=13 ''--------hag shift------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (13));
RDebugUtils.currentLine=37552215;
 //BA.debugLineNum = 37552215;BA.debugLine="et_shift.Text=dbCode.res.GetString(\"value\")";
mostCurrent._et_shift.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=37552217;
 //BA.debugLineNum = 37552217;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (14));
RDebugUtils.currentLine=37552218;
 //BA.debugLineNum = 37552218;BA.debugLine="et_sanavat.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_sanavat.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=37552219;
 //BA.debugLineNum = 37552219;BA.debugLine="et_sanavat.Text=myfunc.show_num_pool(dbCode.res.G";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=37552221;
 //BA.debugLineNum = 37552221;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (15));
RDebugUtils.currentLine=37552222;
 //BA.debugLineNum = 37552222;BA.debugLine="et_sarparast.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_sarparast.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=37552223;
 //BA.debugLineNum = 37552223;BA.debugLine="et_sarparast.Text=myfunc.show_num_pool(dbCode.res";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=37552225;
 //BA.debugLineNum = 37552225;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (16));
RDebugUtils.currentLine=37552226;
 //BA.debugLineNum = 37552226;BA.debugLine="et_mazaya.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_mazaya.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=37552227;
 //BA.debugLineNum = 37552227;BA.debugLine="et_mazaya.Text=myfunc.show_num_pool(dbCode.res.Ge";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=37552229;
 //BA.debugLineNum = 37552229;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (19));
RDebugUtils.currentLine=37552230;
 //BA.debugLineNum = 37552230;BA.debugLine="et_ksorat.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_ksorat.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=37552231;
 //BA.debugLineNum = 37552231;BA.debugLine="et_ksorat.Text=myfunc.show_num_pool(dbCode.res.Ge";
mostCurrent._et_ksorat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=37552239;
 //BA.debugLineNum = 37552239;BA.debugLine="dbCode.res.Position=18 ''--------number olad-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (18));
RDebugUtils.currentLine=37552240;
 //BA.debugLineNum = 37552240;BA.debugLine="sp_olad.SelectedIndex=dbCode.res.GetString(\"value";
mostCurrent._sp_olad.setSelectedIndex((int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))));
RDebugUtils.currentLine=37552242;
 //BA.debugLineNum = 37552242;BA.debugLine="dbCode.res.Position=26 ''--------saat  kari dar r";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (26));
RDebugUtils.currentLine=37552243;
 //BA.debugLineNum = 37552243;BA.debugLine="min_saat_kari=dbCode.res.GetString(\"value\")";
_min_saat_kari = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=37552245;
 //BA.debugLineNum = 37552245;BA.debugLine="Dim sat1 As Int= min_saat_kari/60";
_sat1 = (int) (_min_saat_kari/(double)60);
RDebugUtils.currentLine=37552246;
 //BA.debugLineNum = 37552246;BA.debugLine="Dim dag1 As Int= min_saat_kari Mod 60";
_dag1 = (int) (_min_saat_kari%60);
RDebugUtils.currentLine=37552248;
 //BA.debugLineNum = 37552248;BA.debugLine="et_saat_kari.Text=sat1";
mostCurrent._et_saat_kari.setText(BA.ObjectToCharSequence(_sat1));
RDebugUtils.currentLine=37552249;
 //BA.debugLineNum = 37552249;BA.debugLine="et_min_kari.Text=dag1";
mostCurrent._et_min_kari.setText(BA.ObjectToCharSequence(_dag1));
RDebugUtils.currentLine=37552257;
 //BA.debugLineNum = 37552257;BA.debugLine="lbl_vahed.Text=\"واحد : تومان\"";
mostCurrent._lbl_vahed.setText(BA.ObjectToCharSequence("واحد : تومان"));
RDebugUtils.currentLine=37552259;
 //BA.debugLineNum = 37552259;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=37552260;
 //BA.debugLineNum = 37552260;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=37552263;
 //BA.debugLineNum = 37552263;BA.debugLine="Dim pay_ch As Int=et_paye.tag";
_pay_ch = (int)(BA.ObjectToNumber(mostCurrent._et_paye.getTag()));
RDebugUtils.currentLine=37552265;
 //BA.debugLineNum = 37552265;BA.debugLine="If (pay_ch=5308284)Then";
if ((_pay_ch==5308284)) { 
RDebugUtils.currentLine=37552266;
 //BA.debugLineNum = 37552266;BA.debugLine="sp_ganon_kar.SelectedIndex=0";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (0));
 }else 
{RDebugUtils.currentLine=37552268;
 //BA.debugLineNum = 37552268;BA.debugLine="else If (pay_ch=4179755)Then";
if ((_pay_ch==4179755)) { 
RDebugUtils.currentLine=37552269;
 //BA.debugLineNum = 37552269;BA.debugLine="sp_ganon_kar.SelectedIndex=1";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (1));
 }else 
{RDebugUtils.currentLine=37552271;
 //BA.debugLineNum = 37552271;BA.debugLine="else If (pay_ch=2655492)Then";
if ((_pay_ch==2655492)) { 
RDebugUtils.currentLine=37552272;
 //BA.debugLineNum = 37552272;BA.debugLine="sp_ganon_kar.SelectedIndex=2";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (2));
 }else 
{RDebugUtils.currentLine=37552274;
 //BA.debugLineNum = 37552274;BA.debugLine="Else If (pay_ch=1910427) Then";
if ((_pay_ch==1910427)) { 
RDebugUtils.currentLine=37552275;
 //BA.debugLineNum = 37552275;BA.debugLine="sp_ganon_kar.SelectedIndex=3";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (3));
 }else {
RDebugUtils.currentLine=37552277;
 //BA.debugLineNum = 37552277;BA.debugLine="sp_ganon_kar.SelectedIndex=4";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (4));
 }}}}
;
RDebugUtils.currentLine=37552282;
 //BA.debugLineNum = 37552282;BA.debugLine="If (File.Exists(File.DirInternal,\"help_set_hogog\"";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_set_hogog")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=37552283;
 //BA.debugLineNum = 37552283;BA.debugLine="show_help";
_show_help();
RDebugUtils.currentLine=37552284;
 //BA.debugLineNum = 37552284;BA.debugLine="File.WriteString(File.DirInternal,\"help_set_hogo";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_set_hogog","");
 };
RDebugUtils.currentLine=37552287;
 //BA.debugLineNum = 37552287;BA.debugLine="End Sub";
return "";
}
public static String  _read_onvan() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "read_onvan", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "read_onvan", null));}
anywheresoftware.b4a.objects.collections.List _ls_onv = null;
RDebugUtils.currentLine=38928384;
 //BA.debugLineNum = 38928384;BA.debugLine="Sub read_onvan";
RDebugUtils.currentLine=38928386;
 //BA.debugLineNum = 38928386;BA.debugLine="Dim ls_onv As List";
_ls_onv = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=38928387;
 //BA.debugLineNum = 38928387;BA.debugLine="ls_onv.Initialize";
_ls_onv.Initialize();
RDebugUtils.currentLine=38928388;
 //BA.debugLineNum = 38928388;BA.debugLine="ls_onv=dbCode.read_onvan_db";
_ls_onv = mostCurrent._dbcode._read_onvan_db /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=38928391;
 //BA.debugLineNum = 38928391;BA.debugLine="lbl_onv1.Text=ls_onv.Get(0)";
mostCurrent._lbl_onv1.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (0))));
RDebugUtils.currentLine=38928392;
 //BA.debugLineNum = 38928392;BA.debugLine="lbl_onv2.Text=ls_onv.Get(1)";
mostCurrent._lbl_onv2.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (1))));
RDebugUtils.currentLine=38928393;
 //BA.debugLineNum = 38928393;BA.debugLine="lbl_onv3.Text=ls_onv.Get(2)";
mostCurrent._lbl_onv3.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (2))));
RDebugUtils.currentLine=38928394;
 //BA.debugLineNum = 38928394;BA.debugLine="lbl_onv4.Text=ls_onv.Get(3)";
mostCurrent._lbl_onv4.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (3))));
RDebugUtils.currentLine=38928395;
 //BA.debugLineNum = 38928395;BA.debugLine="lbl_onv5.Text=ls_onv.Get(4)";
mostCurrent._lbl_onv5.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (4))));
RDebugUtils.currentLine=38928396;
 //BA.debugLineNum = 38928396;BA.debugLine="lbl_onv6.Text=ls_onv.Get(5)";
mostCurrent._lbl_onv6.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (5))));
RDebugUtils.currentLine=38928397;
 //BA.debugLineNum = 38928397;BA.debugLine="lbl_onv7.Text=ls_onv.Get(6)";
mostCurrent._lbl_onv7.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (6))));
RDebugUtils.currentLine=38928398;
 //BA.debugLineNum = 38928398;BA.debugLine="lbl_onv8.Text=ls_onv.Get(7)";
mostCurrent._lbl_onv8.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (7))));
RDebugUtils.currentLine=38928399;
 //BA.debugLineNum = 38928399;BA.debugLine="lbl_onv9.Text=ls_onv.Get(8)";
mostCurrent._lbl_onv9.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (8))));
RDebugUtils.currentLine=38928400;
 //BA.debugLineNum = 38928400;BA.debugLine="lbl_onv10.Text=ls_onv.Get(9)";
mostCurrent._lbl_onv10.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (9))));
RDebugUtils.currentLine=38928401;
 //BA.debugLineNum = 38928401;BA.debugLine="lbl_onv11.Text=ls_onv.Get(10)";
mostCurrent._lbl_onv11.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (10))));
RDebugUtils.currentLine=38928402;
 //BA.debugLineNum = 38928402;BA.debugLine="lbl_onv12.Text=ls_onv.Get(11)";
mostCurrent._lbl_onv12.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (11))));
RDebugUtils.currentLine=38928403;
 //BA.debugLineNum = 38928403;BA.debugLine="lbl_onv13.Text=ls_onv.Get(12)";
mostCurrent._lbl_onv13.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (12))));
RDebugUtils.currentLine=38928406;
 //BA.debugLineNum = 38928406;BA.debugLine="End Sub";
return "";
}
public static String  _show_help() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_help", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_help", null));}
RDebugUtils.currentLine=37617664;
 //BA.debugLineNum = 37617664;BA.debugLine="Sub show_help";
RDebugUtils.currentLine=37617665;
 //BA.debugLineNum = 37617665;BA.debugLine="Msgbox(\"همه قیمت ها به تومان می باشد\",\"هشدار مهم\"";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("همه قیمت ها به تومان می باشد"),BA.ObjectToCharSequence("هشدار مهم"),mostCurrent.activityBA);
RDebugUtils.currentLine=37617666;
 //BA.debugLineNum = 37617666;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=37945344;
 //BA.debugLineNum = 37945344;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=37945345;
 //BA.debugLineNum = 37945345;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=37945346;
 //BA.debugLineNum = 37945346;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=37945347;
 //BA.debugLineNum = 37945347;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=37945349;
 //BA.debugLineNum = 37945349;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=37945351;
 //BA.debugLineNum = 37945351;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=37814272;
 //BA.debugLineNum = 37814272;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=37814273;
 //BA.debugLineNum = 37814273;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=37814275;
 //BA.debugLineNum = 37814275;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=37814276;
 //BA.debugLineNum = 37814276;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
RDebugUtils.currentLine=37748736;
 //BA.debugLineNum = 37748736;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=37748738;
 //BA.debugLineNum = 37748738;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=37683200;
 //BA.debugLineNum = 37683200;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=37683202;
 //BA.debugLineNum = 37683202;BA.debugLine="End Sub";
return "";
}
public static boolean  _empty_fild(anywheresoftware.b4a.objects.EditTextWrapper _et) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "empty_fild", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "empty_fild", new Object[] {_et}));}
RDebugUtils.currentLine=38862848;
 //BA.debugLineNum = 38862848;BA.debugLine="Sub empty_fild(et As EditText) As Boolean";
RDebugUtils.currentLine=38862849;
 //BA.debugLineNum = 38862849;BA.debugLine="If(et.Text.Trim=\"\")Then";
if (((_et.getText().trim()).equals(""))) { 
RDebugUtils.currentLine=38862850;
 //BA.debugLineNum = 38862850;BA.debugLine="ToastMessageShow(\"فیلد خالی است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("فیلد خالی است"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=38862851;
 //BA.debugLineNum = 38862851;BA.debugLine="et.Color=0x9FFF4E4E";
_et.setColor(((int)0x9fff4e4e));
RDebugUtils.currentLine=38862852;
 //BA.debugLineNum = 38862852;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=38862854;
 //BA.debugLineNum = 38862854;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=38862855;
 //BA.debugLineNum = 38862855;BA.debugLine="End Sub";
return false;
}
public static String  _et_bime_takmil_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_bime_takmil_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_bime_takmil_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=38338560;
 //BA.debugLineNum = 38338560;BA.debugLine="Private Sub et_bime_takmil_TextChanged (Old As Str";
RDebugUtils.currentLine=38338561;
 //BA.debugLineNum = 38338561;BA.debugLine="et_bime_takmil.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_bime_takmil.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=38338562;
 //BA.debugLineNum = 38338562;BA.debugLine="myfunc.change_formater(Old,New,et_bime_takmil)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_bime_takmil);
RDebugUtils.currentLine=38338563;
 //BA.debugLineNum = 38338563;BA.debugLine="End Sub";
return "";
}
public static String  _et_bon_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_bon_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_bon_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=38404096;
 //BA.debugLineNum = 38404096;BA.debugLine="Private Sub et_bon_TextChanged (Old As String, New";
RDebugUtils.currentLine=38404097;
 //BA.debugLineNum = 38404097;BA.debugLine="et_bon.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_bon.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=38404098;
 //BA.debugLineNum = 38404098;BA.debugLine="myfunc.change_formater(Old,New,et_bon)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_bon);
RDebugUtils.currentLine=38404099;
 //BA.debugLineNum = 38404099;BA.debugLine="End Sub";
return "";
}
public static String  _et_fani_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_fani_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_fani_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=38600704;
 //BA.debugLineNum = 38600704;BA.debugLine="Private Sub et_fani_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=38600705;
 //BA.debugLineNum = 38600705;BA.debugLine="et_fani.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_fani.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=38600706;
 //BA.debugLineNum = 38600706;BA.debugLine="myfunc.change_formater(Old,New,et_fani)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_fani);
RDebugUtils.currentLine=38600707;
 //BA.debugLineNum = 38600707;BA.debugLine="End Sub";
return "";
}
public static String  _et_ksorat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_ksorat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_ksorat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=38273024;
 //BA.debugLineNum = 38273024;BA.debugLine="Private Sub et_ksorat_TextChanged (Old As String,";
RDebugUtils.currentLine=38273025;
 //BA.debugLineNum = 38273025;BA.debugLine="et_ksorat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_ksorat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=38273026;
 //BA.debugLineNum = 38273026;BA.debugLine="myfunc.change_formater(Old,New,et_ksorat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_ksorat);
RDebugUtils.currentLine=38273027;
 //BA.debugLineNum = 38273027;BA.debugLine="End Sub";
return "";
}
public static String  _et_maskan_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_maskan_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_maskan_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=38731776;
 //BA.debugLineNum = 38731776;BA.debugLine="Private Sub et_maskan_TextChanged (Old As String,";
RDebugUtils.currentLine=38731777;
 //BA.debugLineNum = 38731777;BA.debugLine="et_maskan.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_maskan.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=38731778;
 //BA.debugLineNum = 38731778;BA.debugLine="myfunc.change_formater(Old,New,et_maskan)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_maskan);
RDebugUtils.currentLine=38731779;
 //BA.debugLineNum = 38731779;BA.debugLine="End Sub";
return "";
}
public static String  _et_masoliat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_masoliat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_masoliat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=38535168;
 //BA.debugLineNum = 38535168;BA.debugLine="Private Sub et_masoliat_TextChanged (Old As String";
RDebugUtils.currentLine=38535169;
 //BA.debugLineNum = 38535169;BA.debugLine="et_masoliat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_masoliat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=38535170;
 //BA.debugLineNum = 38535170;BA.debugLine="myfunc.change_formater(Old,New,et_masoliat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_masoliat);
RDebugUtils.currentLine=38535171;
 //BA.debugLineNum = 38535171;BA.debugLine="End Sub";
return "";
}
public static String  _et_mazaya_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mazaya_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mazaya_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=38207488;
 //BA.debugLineNum = 38207488;BA.debugLine="Private Sub et_mazaya_TextChanged (Old As String,";
RDebugUtils.currentLine=38207489;
 //BA.debugLineNum = 38207489;BA.debugLine="et_mazaya.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_mazaya.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=38207490;
 //BA.debugLineNum = 38207490;BA.debugLine="myfunc.change_formater(Old,New,et_mazaya)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_mazaya);
RDebugUtils.currentLine=38207491;
 //BA.debugLineNum = 38207491;BA.debugLine="End Sub";
return "";
}
public static String  _et_olad_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_olad_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_olad_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=38666240;
 //BA.debugLineNum = 38666240;BA.debugLine="Private Sub et_olad_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=38666241;
 //BA.debugLineNum = 38666241;BA.debugLine="et_olad.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_olad.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=38666242;
 //BA.debugLineNum = 38666242;BA.debugLine="myfunc.change_formater(Old,New,et_olad)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_olad);
RDebugUtils.currentLine=38666243;
 //BA.debugLineNum = 38666243;BA.debugLine="End Sub";
return "";
}
public static String  _et_paye_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_paye_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_paye_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=38141952;
 //BA.debugLineNum = 38141952;BA.debugLine="Private Sub et_paye_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=38141953;
 //BA.debugLineNum = 38141953;BA.debugLine="et_paye.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_paye.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=38141954;
 //BA.debugLineNum = 38141954;BA.debugLine="myfunc.change_formater(Old,New,et_paye)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_paye);
RDebugUtils.currentLine=38141955;
 //BA.debugLineNum = 38141955;BA.debugLine="End Sub";
return "";
}
public static String  _et_sanavat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_sanavat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_sanavat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=38797312;
 //BA.debugLineNum = 38797312;BA.debugLine="Private Sub et_sanavat_TextChanged (Old As String,";
RDebugUtils.currentLine=38797313;
 //BA.debugLineNum = 38797313;BA.debugLine="et_sanavat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_sanavat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=38797314;
 //BA.debugLineNum = 38797314;BA.debugLine="myfunc.change_formater(Old,New,et_sanavat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_sanavat);
RDebugUtils.currentLine=38797315;
 //BA.debugLineNum = 38797315;BA.debugLine="End Sub";
return "";
}
public static String  _et_sarparast_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_sarparast_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_sarparast_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=38469632;
 //BA.debugLineNum = 38469632;BA.debugLine="Private Sub et_sarparast_TextChanged (Old As Strin";
RDebugUtils.currentLine=38469633;
 //BA.debugLineNum = 38469633;BA.debugLine="et_sarparast.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_sarparast.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=38469634;
 //BA.debugLineNum = 38469634;BA.debugLine="myfunc.change_formater(Old,New,et_sarparast)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_sarparast);
RDebugUtils.currentLine=38469635;
 //BA.debugLineNum = 38469635;BA.debugLine="End Sub";
return "";
}
public static String  _ev_onv_longclick() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ev_onv_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ev_onv_longclick", null));}
anywheresoftware.b4a.objects.LabelWrapper _this_onv = null;
RDebugUtils.currentLine=39124992;
 //BA.debugLineNum = 39124992;BA.debugLine="Private Sub EV_onv_LongClick";
RDebugUtils.currentLine=39124993;
 //BA.debugLineNum = 39124993;BA.debugLine="Dim this_onv As Label";
_this_onv = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=39124994;
 //BA.debugLineNum = 39124994;BA.debugLine="this_onv=Sender";
_this_onv = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=39124997;
 //BA.debugLineNum = 39124997;BA.debugLine="current_index_onvan=this_onv.Tag";
_current_index_onvan = (int)(BA.ObjectToNumber(_this_onv.getTag()));
RDebugUtils.currentLine=39124999;
 //BA.debugLineNum = 39124999;BA.debugLine="lbl_onv_def.Text=get_onvan_byId(this_onv.Tag).Get";
mostCurrent._lbl_onv_def.setText(BA.ObjectToCharSequence(_get_onvan_byid((int)(BA.ObjectToNumber(_this_onv.getTag()))).Get((int) (0))));
RDebugUtils.currentLine=39125000;
 //BA.debugLineNum = 39125000;BA.debugLine="et_onv_new.Text=get_onvan_byId(this_onv.Tag).Get(";
mostCurrent._et_onv_new.setText(BA.ObjectToCharSequence(_get_onvan_byid((int)(BA.ObjectToNumber(_this_onv.getTag()))).Get((int) (1))));
RDebugUtils.currentLine=39125003;
 //BA.debugLineNum = 39125003;BA.debugLine="pan_all_onvanHa.Visible=True";
mostCurrent._pan_all_onvanha.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=39125004;
 //BA.debugLineNum = 39125004;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _get_onvan_byid(int _id1) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_onvan_byid", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(mostCurrent.activityBA, "get_onvan_byid", new Object[] {_id1}));}
anywheresoftware.b4a.objects.collections.List _ls_result = null;
RDebugUtils.currentLine=39256064;
 //BA.debugLineNum = 39256064;BA.debugLine="Sub get_onvan_byId (id1 As Int) As List";
RDebugUtils.currentLine=39256065;
 //BA.debugLineNum = 39256065;BA.debugLine="Dim ls_result As List";
_ls_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=39256066;
 //BA.debugLineNum = 39256066;BA.debugLine="ls_result.Initialize";
_ls_result.Initialize();
RDebugUtils.currentLine=39256067;
 //BA.debugLineNum = 39256067;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=39256068;
 //BA.debugLineNum = 39256068;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tbl_onvanha WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=39256069;
 //BA.debugLineNum = 39256069;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=39256070;
 //BA.debugLineNum = 39256070;BA.debugLine="ls_result.Add(dbCode.res.GetString(\"def_name\"))";
_ls_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("def_name")));
RDebugUtils.currentLine=39256071;
 //BA.debugLineNum = 39256071;BA.debugLine="ls_result.Add(dbCode.res.GetString(\"custom_name\")";
_ls_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("custom_name")));
RDebugUtils.currentLine=39256072;
 //BA.debugLineNum = 39256072;BA.debugLine="Return ls_result";
if (true) return _ls_result;
RDebugUtils.currentLine=39256073;
 //BA.debugLineNum = 39256073;BA.debugLine="End Sub";
return null;
}
public static String  _lbl_help_onv_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_onv_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_onv_click", null));}
RDebugUtils.currentLine=39387136;
 //BA.debugLineNum = 39387136;BA.debugLine="Private Sub lbl_help_onv_Click";
RDebugUtils.currentLine=39387137;
 //BA.debugLineNum = 39387137;BA.debugLine="myfunc.help_man(\"راهنما\",\"با نگه داشتن انگشت روی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","با نگه داشتن انگشت روی عنوان آیتم ها میتوانید آنها را ویرایش کنید. توجه داشته باشید که عملکرد آنها در محاسبات تغییر نخواهد کرد.");
RDebugUtils.currentLine=39387138;
 //BA.debugLineNum = 39387138;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_onv_def_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_onv_def_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_onv_def_click", null));}
RDebugUtils.currentLine=39321600;
 //BA.debugLineNum = 39321600;BA.debugLine="Private Sub lbl_onv_def_Click";
RDebugUtils.currentLine=39321601;
 //BA.debugLineNum = 39321601;BA.debugLine="et_onv_new.Text=lbl_onv_def.Text";
mostCurrent._et_onv_new.setText(BA.ObjectToCharSequence(mostCurrent._lbl_onv_def.getText()));
RDebugUtils.currentLine=39321603;
 //BA.debugLineNum = 39321603;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_click", null));}
boolean _exep = false;
int _min_sat_kar = 0;
anywheresoftware.b4a.objects.collections.List _data = null;
RDebugUtils.currentLine=37879808;
 //BA.debugLineNum = 37879808;BA.debugLine="Private Sub lbl_save_Click";
RDebugUtils.currentLine=37879809;
 //BA.debugLineNum = 37879809;BA.debugLine="Dim exep As Boolean=True";
_exep = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=37879811;
 //BA.debugLineNum = 37879811;BA.debugLine="et_paye.Color=Colors.White";
mostCurrent._et_paye.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37879812;
 //BA.debugLineNum = 37879812;BA.debugLine="et_maskan.Color=Colors.White";
mostCurrent._et_maskan.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37879813;
 //BA.debugLineNum = 37879813;BA.debugLine="et_fani.Color=Colors.White";
mostCurrent._et_fani.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37879814;
 //BA.debugLineNum = 37879814;BA.debugLine="et_masoliat.Color=Colors.White";
mostCurrent._et_masoliat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37879815;
 //BA.debugLineNum = 37879815;BA.debugLine="et_olad.Color=Colors.White";
mostCurrent._et_olad.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37879816;
 //BA.debugLineNum = 37879816;BA.debugLine="et_bon.Color=Colors.White";
mostCurrent._et_bon.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37879817;
 //BA.debugLineNum = 37879817;BA.debugLine="et_bime_takmil.Color=Colors.White";
mostCurrent._et_bime_takmil.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37879820;
 //BA.debugLineNum = 37879820;BA.debugLine="et_shift.Color=Colors.White";
mostCurrent._et_shift.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37879821;
 //BA.debugLineNum = 37879821;BA.debugLine="et_sanavat.Color=Colors.White";
mostCurrent._et_sanavat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37879822;
 //BA.debugLineNum = 37879822;BA.debugLine="et_sarparast.Color=Colors.White";
mostCurrent._et_sarparast.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37879823;
 //BA.debugLineNum = 37879823;BA.debugLine="et_mazaya.Color=Colors.White";
mostCurrent._et_mazaya.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37879824;
 //BA.debugLineNum = 37879824;BA.debugLine="et_ksorat.Color=Colors.White";
mostCurrent._et_ksorat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37879825;
 //BA.debugLineNum = 37879825;BA.debugLine="et_saat_kari.Color=Colors.White";
mostCurrent._et_saat_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37879826;
 //BA.debugLineNum = 37879826;BA.debugLine="et_min_kari.Color=Colors.White";
mostCurrent._et_min_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=37879841;
 //BA.debugLineNum = 37879841;BA.debugLine="et_maliat.TextColor=Colors.Black";
mostCurrent._et_maliat.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=37879844;
 //BA.debugLineNum = 37879844;BA.debugLine="If(et_shift.Text=\"\")Then";
if (((mostCurrent._et_shift.getText()).equals(""))) { 
RDebugUtils.currentLine=37879845;
 //BA.debugLineNum = 37879845;BA.debugLine="et_shift.Text=0";
mostCurrent._et_shift.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=37879847;
 //BA.debugLineNum = 37879847;BA.debugLine="If(et_saat_kari.Text=\"\")Then";
if (((mostCurrent._et_saat_kari.getText()).equals(""))) { 
RDebugUtils.currentLine=37879848;
 //BA.debugLineNum = 37879848;BA.debugLine="et_saat_kari.Text=8";
mostCurrent._et_saat_kari.setText(BA.ObjectToCharSequence(8));
 };
RDebugUtils.currentLine=37879850;
 //BA.debugLineNum = 37879850;BA.debugLine="If(et_min_kari.Text=\"\")Then";
if (((mostCurrent._et_min_kari.getText()).equals(""))) { 
RDebugUtils.currentLine=37879851;
 //BA.debugLineNum = 37879851;BA.debugLine="et_min_kari.Text=0";
mostCurrent._et_min_kari.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=37879855;
 //BA.debugLineNum = 37879855;BA.debugLine="If(et_shift.Text>100 Or et_shift.Text<0 Or  et_sh";
if (((double)(Double.parseDouble(mostCurrent._et_shift.getText()))>100 || (double)(Double.parseDouble(mostCurrent._et_shift.getText()))<0 || (mostCurrent._et_shift.getText()).equals(""))) { 
RDebugUtils.currentLine=37879856;
 //BA.debugLineNum = 37879856;BA.debugLine="ToastMessageShow(\"خطا درصد-(0 تا 100)\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا درصد-(0 تا 100)"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=37879857;
 //BA.debugLineNum = 37879857;BA.debugLine="et_shift.TextColor=Colors.Red";
mostCurrent._et_shift.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=37879858;
 //BA.debugLineNum = 37879858;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=37879860;
 //BA.debugLineNum = 37879860;BA.debugLine="et_shift.TextColor=Colors.Black";
mostCurrent._et_shift.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=37879863;
 //BA.debugLineNum = 37879863;BA.debugLine="If(et_saat_kari.Text>24 Or et_saat_kari.Text<0 )T";
if (((double)(Double.parseDouble(mostCurrent._et_saat_kari.getText()))>24 || (double)(Double.parseDouble(mostCurrent._et_saat_kari.getText()))<0)) { 
RDebugUtils.currentLine=37879864;
 //BA.debugLineNum = 37879864;BA.debugLine="ToastMessageShow(\"ساعت کاری را اصلاح نمائید\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ساعت کاری را اصلاح نمائید"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=37879865;
 //BA.debugLineNum = 37879865;BA.debugLine="et_saat_kari.TextColor=Colors.Red";
mostCurrent._et_saat_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=37879866;
 //BA.debugLineNum = 37879866;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=37879868;
 //BA.debugLineNum = 37879868;BA.debugLine="et_saat_kari.TextColor=Colors.Black";
mostCurrent._et_saat_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=37879871;
 //BA.debugLineNum = 37879871;BA.debugLine="If(et_min_kari.Text>59 Or et_min_kari.Text<0 )The";
if (((double)(Double.parseDouble(mostCurrent._et_min_kari.getText()))>59 || (double)(Double.parseDouble(mostCurrent._et_min_kari.getText()))<0)) { 
RDebugUtils.currentLine=37879872;
 //BA.debugLineNum = 37879872;BA.debugLine="ToastMessageShow(\"ساعت کاری را اصلاح نمائید\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ساعت کاری را اصلاح نمائید"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=37879873;
 //BA.debugLineNum = 37879873;BA.debugLine="et_min_kari.TextColor=Colors.Red";
mostCurrent._et_min_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=37879874;
 //BA.debugLineNum = 37879874;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=37879876;
 //BA.debugLineNum = 37879876;BA.debugLine="et_min_kari.TextColor=Colors.Black";
mostCurrent._et_min_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=37879882;
 //BA.debugLineNum = 37879882;BA.debugLine="If(empty_fild(et_paye)=True)Then";
if ((_empty_fild(mostCurrent._et_paye)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=37879883;
 //BA.debugLineNum = 37879883;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=37879885;
 //BA.debugLineNum = 37879885;BA.debugLine="If(empty_fild(et_maskan)=True)Then";
if ((_empty_fild(mostCurrent._et_maskan)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=37879886;
 //BA.debugLineNum = 37879886;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=37879888;
 //BA.debugLineNum = 37879888;BA.debugLine="If(empty_fild(et_bon)=True)Then";
if ((_empty_fild(mostCurrent._et_bon)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=37879889;
 //BA.debugLineNum = 37879889;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=37879892;
 //BA.debugLineNum = 37879892;BA.debugLine="If(et_sanavat.Text=\"\")Then";
if (((mostCurrent._et_sanavat.getText()).equals(""))) { 
RDebugUtils.currentLine=37879893;
 //BA.debugLineNum = 37879893;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=37879895;
 //BA.debugLineNum = 37879895;BA.debugLine="If(et_olad.Text=\"\")Then";
if (((mostCurrent._et_olad.getText()).equals(""))) { 
RDebugUtils.currentLine=37879896;
 //BA.debugLineNum = 37879896;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=37879898;
 //BA.debugLineNum = 37879898;BA.debugLine="If(et_fani.Text=\"\")Then";
if (((mostCurrent._et_fani.getText()).equals(""))) { 
RDebugUtils.currentLine=37879899;
 //BA.debugLineNum = 37879899;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=37879901;
 //BA.debugLineNum = 37879901;BA.debugLine="If(et_masoliat.Text=\"\")Then";
if (((mostCurrent._et_masoliat.getText()).equals(""))) { 
RDebugUtils.currentLine=37879902;
 //BA.debugLineNum = 37879902;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=37879904;
 //BA.debugLineNum = 37879904;BA.debugLine="If(et_sarparast.Text=\"\")Then";
if (((mostCurrent._et_sarparast.getText()).equals(""))) { 
RDebugUtils.currentLine=37879905;
 //BA.debugLineNum = 37879905;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=37879907;
 //BA.debugLineNum = 37879907;BA.debugLine="If(et_bime_takmil.Text=\"\")Then";
if (((mostCurrent._et_bime_takmil.getText()).equals(""))) { 
RDebugUtils.currentLine=37879908;
 //BA.debugLineNum = 37879908;BA.debugLine="et_bime_takmil.Text=0";
mostCurrent._et_bime_takmil.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=37879910;
 //BA.debugLineNum = 37879910;BA.debugLine="If(et_mazaya.Text=\"\")Then";
if (((mostCurrent._et_mazaya.getText()).equals(""))) { 
RDebugUtils.currentLine=37879911;
 //BA.debugLineNum = 37879911;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=37879913;
 //BA.debugLineNum = 37879913;BA.debugLine="If(et_ksorat.Text=\"\")Then";
if (((mostCurrent._et_ksorat.getText()).equals(""))) { 
RDebugUtils.currentLine=37879914;
 //BA.debugLineNum = 37879914;BA.debugLine="et_ksorat.Text=0";
mostCurrent._et_ksorat.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=37879918;
 //BA.debugLineNum = 37879918;BA.debugLine="Dim min_sat_kar As Int=(et_saat_kari.Text*60)+et_";
_min_sat_kar = (int) (((double)(Double.parseDouble(mostCurrent._et_saat_kari.getText()))*60)+(double)(Double.parseDouble(mostCurrent._et_min_kari.getText())));
RDebugUtils.currentLine=37879920;
 //BA.debugLineNum = 37879920;BA.debugLine="If(exep=True)Then";
if ((_exep==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=37879921;
 //BA.debugLineNum = 37879921;BA.debugLine="Dim data As List";
_data = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=37879922;
 //BA.debugLineNum = 37879922;BA.debugLine="data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=37879923;
 //BA.debugLineNum = 37879923;BA.debugLine="data.AddAll(Array As String(et_paye.Tag,et_maska";
_data.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{BA.ObjectToString(mostCurrent._et_paye.getTag()),BA.ObjectToString(mostCurrent._et_maskan.getTag()),BA.ObjectToString(mostCurrent._et_olad.getTag()),BA.ObjectToString(mostCurrent._et_fani.getTag()),BA.ObjectToString(mostCurrent._et_masoliat.getTag()),BA.ObjectToString(mostCurrent._et_bon.getTag()),mostCurrent._et_bime_tamin.getText(),BA.ObjectToString(mostCurrent._et_bime_takmil.getTag()),BA.NumberToString(10),mostCurrent._et_shift.getText(),BA.ObjectToString(mostCurrent._et_sanavat.getTag()),BA.ObjectToString(mostCurrent._et_sarparast.getTag()),BA.ObjectToString(mostCurrent._et_mazaya.getTag()),mostCurrent._sp_olad.getSelectedItem(),BA.ObjectToString(mostCurrent._et_ksorat.getTag()),BA.NumberToString(_min_sat_kar)}));
RDebugUtils.currentLine=37879926;
 //BA.debugLineNum = 37879926;BA.debugLine="If (dbCode.add_setting_hogog(data)) Then";
if ((mostCurrent._dbcode._add_setting_hogog /*boolean*/ (mostCurrent.activityBA,_data))) { 
RDebugUtils.currentLine=37879927;
 //BA.debugLineNum = 37879927;BA.debugLine="ToastMessageShow (\"ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=37879929;
 //BA.debugLineNum = 37879929;BA.debugLine="Main.saat_kar_min=min_sat_kar";
mostCurrent._main._saat_kar_min /*int*/  = _min_sat_kar;
RDebugUtils.currentLine=37879930;
 //BA.debugLineNum = 37879930;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 };
RDebugUtils.currentLine=37879937;
 //BA.debugLineNum = 37879937;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_onvan_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_onvan_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_onvan_click", null));}
RDebugUtils.currentLine=39190528;
 //BA.debugLineNum = 39190528;BA.debugLine="Private Sub lbl_save_onvan_Click";
RDebugUtils.currentLine=39190529;
 //BA.debugLineNum = 39190529;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=39190530;
 //BA.debugLineNum = 39190530;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tbl_onvanha SET '";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tbl_onvanha SET 'custom_name' ='"+mostCurrent._et_onv_new.getText()+"'  WHERE id="+BA.NumberToString(_current_index_onvan));
RDebugUtils.currentLine=39190532;
 //BA.debugLineNum = 39190532;BA.debugLine="read_onvan";
_read_onvan();
RDebugUtils.currentLine=39190533;
 //BA.debugLineNum = 39190533;BA.debugLine="pan_all_onvanHa.Visible=False";
mostCurrent._pan_all_onvanha.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=39190534;
 //BA.debugLineNum = 39190534;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_onvanha_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_onvanha_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_onvanha_click", null));}
RDebugUtils.currentLine=38993920;
 //BA.debugLineNum = 38993920;BA.debugLine="Private Sub pan_all_onvanHa_Click";
RDebugUtils.currentLine=38993922;
 //BA.debugLineNum = 38993922;BA.debugLine="pan_all_onvanHa.Visible=False";
mostCurrent._pan_all_onvanha.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=38993923;
 //BA.debugLineNum = 38993923;BA.debugLine="End Sub";
return "";
}
public static String  _panel15_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel15_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel15_click", null));}
RDebugUtils.currentLine=39059456;
 //BA.debugLineNum = 39059456;BA.debugLine="Private Sub Panel15_Click";
RDebugUtils.currentLine=39059458;
 //BA.debugLineNum = 39059458;BA.debugLine="End Sub";
return "";
}
public static String  _sp_ganon_kar_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_ganon_kar_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_ganon_kar_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=38010880;
 //BA.debugLineNum = 38010880;BA.debugLine="Private Sub sp_ganon_kar_ItemClick (Position As In";
RDebugUtils.currentLine=38010883;
 //BA.debugLineNum = 38010883;BA.debugLine="Select Value";
switch (BA.switchObjectToInt(_value,(Object)("سال 1402"),(Object)("سال 1401"),(Object)("سال 1400"),(Object)("سال 1399"))) {
case 0: {
RDebugUtils.currentLine=38010885;
 //BA.debugLineNum = 38010885;BA.debugLine="et_paye.Text=5308284";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(5308284));
RDebugUtils.currentLine=38010886;
 //BA.debugLineNum = 38010886;BA.debugLine="et_maskan.Text=900000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(900000));
RDebugUtils.currentLine=38010887;
 //BA.debugLineNum = 38010887;BA.debugLine="et_bon.Text=1100000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(1100000));
RDebugUtils.currentLine=38010888;
 //BA.debugLineNum = 38010888;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=38010891;
 //BA.debugLineNum = 38010891;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010892;
 //BA.debugLineNum = 38010892;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010893;
 //BA.debugLineNum = 38010893;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010894;
 //BA.debugLineNum = 38010894;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010897;
 //BA.debugLineNum = 38010897;BA.debugLine="olad_vahed=530828";
_olad_vahed = (int) (530828);
RDebugUtils.currentLine=38010898;
 //BA.debugLineNum = 38010898;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010902;
 //BA.debugLineNum = 38010902;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
case 1: {
RDebugUtils.currentLine=38010905;
 //BA.debugLineNum = 38010905;BA.debugLine="et_paye.Text=4179755";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(4179755));
RDebugUtils.currentLine=38010906;
 //BA.debugLineNum = 38010906;BA.debugLine="et_maskan.Text=650000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(650000));
RDebugUtils.currentLine=38010907;
 //BA.debugLineNum = 38010907;BA.debugLine="et_bon.Text=850000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(850000));
RDebugUtils.currentLine=38010908;
 //BA.debugLineNum = 38010908;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=38010911;
 //BA.debugLineNum = 38010911;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010912;
 //BA.debugLineNum = 38010912;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010913;
 //BA.debugLineNum = 38010913;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010914;
 //BA.debugLineNum = 38010914;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010917;
 //BA.debugLineNum = 38010917;BA.debugLine="olad_vahed=417975";
_olad_vahed = (int) (417975);
RDebugUtils.currentLine=38010918;
 //BA.debugLineNum = 38010918;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010922;
 //BA.debugLineNum = 38010922;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
case 2: {
RDebugUtils.currentLine=38010925;
 //BA.debugLineNum = 38010925;BA.debugLine="et_paye.Text=2655492";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(2655492));
RDebugUtils.currentLine=38010926;
 //BA.debugLineNum = 38010926;BA.debugLine="et_maskan.Text=450000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(450000));
RDebugUtils.currentLine=38010927;
 //BA.debugLineNum = 38010927;BA.debugLine="et_bon.Text=600000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(600000));
RDebugUtils.currentLine=38010928;
 //BA.debugLineNum = 38010928;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=38010931;
 //BA.debugLineNum = 38010931;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010932;
 //BA.debugLineNum = 38010932;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010933;
 //BA.debugLineNum = 38010933;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010934;
 //BA.debugLineNum = 38010934;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010937;
 //BA.debugLineNum = 38010937;BA.debugLine="olad_vahed=265549";
_olad_vahed = (int) (265549);
RDebugUtils.currentLine=38010938;
 //BA.debugLineNum = 38010938;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010942;
 //BA.debugLineNum = 38010942;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
case 3: {
RDebugUtils.currentLine=38010945;
 //BA.debugLineNum = 38010945;BA.debugLine="et_paye.Text=1910427";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(1910427));
RDebugUtils.currentLine=38010946;
 //BA.debugLineNum = 38010946;BA.debugLine="et_maskan.Text=300000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(300000));
RDebugUtils.currentLine=38010947;
 //BA.debugLineNum = 38010947;BA.debugLine="et_bon.Text=400000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(400000));
RDebugUtils.currentLine=38010948;
 //BA.debugLineNum = 38010948;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=38010951;
 //BA.debugLineNum = 38010951;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010952;
 //BA.debugLineNum = 38010952;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010953;
 //BA.debugLineNum = 38010953;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010954;
 //BA.debugLineNum = 38010954;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010957;
 //BA.debugLineNum = 38010957;BA.debugLine="olad_vahed=191127";
_olad_vahed = (int) (191127);
RDebugUtils.currentLine=38010958;
 //BA.debugLineNum = 38010958;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010962;
 //BA.debugLineNum = 38010962;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
default: {
RDebugUtils.currentLine=38010965;
 //BA.debugLineNum = 38010965;BA.debugLine="et_paye.Text=0";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010966;
 //BA.debugLineNum = 38010966;BA.debugLine="et_maskan.Text=0";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010967;
 //BA.debugLineNum = 38010967;BA.debugLine="et_bon.Text=0";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010968;
 //BA.debugLineNum = 38010968;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=38010971;
 //BA.debugLineNum = 38010971;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010972;
 //BA.debugLineNum = 38010972;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010973;
 //BA.debugLineNum = 38010973;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010974;
 //BA.debugLineNum = 38010974;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010976;
 //BA.debugLineNum = 38010976;BA.debugLine="olad_vahed=0";
_olad_vahed = (int) (0);
RDebugUtils.currentLine=38010977;
 //BA.debugLineNum = 38010977;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=38010979;
 //BA.debugLineNum = 38010979;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
}
;
RDebugUtils.currentLine=38010984;
 //BA.debugLineNum = 38010984;BA.debugLine="End Sub";
return "";
}
public static String  _sp_olad_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_olad_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_olad_itemclick", new Object[] {_position,_value}));}
int _num = 0;
RDebugUtils.currentLine=38076416;
 //BA.debugLineNum = 38076416;BA.debugLine="Private Sub sp_olad_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=38076417;
 //BA.debugLineNum = 38076417;BA.debugLine="Dim num As Int=Value";
_num = (int)(BA.ObjectToNumber(_value));
RDebugUtils.currentLine=38076418;
 //BA.debugLineNum = 38076418;BA.debugLine="et_olad.Text=olad_vahed*num";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(_olad_vahed*_num));
RDebugUtils.currentLine=38076419;
 //BA.debugLineNum = 38076419;BA.debugLine="End Sub";
return "";
}
}