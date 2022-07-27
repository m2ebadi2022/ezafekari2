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
        
        BA.LogInfo("** Activity (setting_hogog_activity) Create, isFirst = " + isFirst + " **");
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
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
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
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
int _sat1 = 0;
int _dag1 = 0;
int _pay_ch = 0;
RDebugUtils.currentLine=31129600;
 //BA.debugLineNum = 31129600;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=31129602;
 //BA.debugLineNum = 31129602;BA.debugLine="Activity.LoadLayout(\"setting_hogog_layout\")";
mostCurrent._activity.LoadLayout("setting_hogog_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=31129603;
 //BA.debugLineNum = 31129603;BA.debugLine="scv_sett_hogog.Panel.LoadLayout(\"sett_hogog_item\"";
mostCurrent._scv_sett_hogog.getPanel().LoadLayout("sett_hogog_item",mostCurrent.activityBA);
RDebugUtils.currentLine=31129604;
 //BA.debugLineNum = 31129604;BA.debugLine="et_paye.Color=Colors.White";
mostCurrent._et_paye.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129605;
 //BA.debugLineNum = 31129605;BA.debugLine="et_maskan.Color=Colors.White";
mostCurrent._et_maskan.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129606;
 //BA.debugLineNum = 31129606;BA.debugLine="et_fani.Color=Colors.White";
mostCurrent._et_fani.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129607;
 //BA.debugLineNum = 31129607;BA.debugLine="et_masoliat.Color=Colors.White";
mostCurrent._et_masoliat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129608;
 //BA.debugLineNum = 31129608;BA.debugLine="et_olad.Color=Colors.White";
mostCurrent._et_olad.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129609;
 //BA.debugLineNum = 31129609;BA.debugLine="et_bon.Color=Colors.White";
mostCurrent._et_bon.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129610;
 //BA.debugLineNum = 31129610;BA.debugLine="et_bime_takmil.Color=Colors.White";
mostCurrent._et_bime_takmil.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129611;
 //BA.debugLineNum = 31129611;BA.debugLine="et_maliat.Color=Colors.White";
mostCurrent._et_maliat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129612;
 //BA.debugLineNum = 31129612;BA.debugLine="et_bime_tamin.Color=Colors.White";
mostCurrent._et_bime_tamin.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129613;
 //BA.debugLineNum = 31129613;BA.debugLine="et_shift.Color=Colors.White";
mostCurrent._et_shift.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129614;
 //BA.debugLineNum = 31129614;BA.debugLine="et_sanavat.Color=Colors.White";
mostCurrent._et_sanavat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129615;
 //BA.debugLineNum = 31129615;BA.debugLine="et_sarparast.Color=Colors.White";
mostCurrent._et_sarparast.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129616;
 //BA.debugLineNum = 31129616;BA.debugLine="et_mazaya.Color=Colors.White";
mostCurrent._et_mazaya.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129617;
 //BA.debugLineNum = 31129617;BA.debugLine="et_ksorat.Color=Colors.White";
mostCurrent._et_ksorat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129618;
 //BA.debugLineNum = 31129618;BA.debugLine="et_saat_kari.Color=Colors.White";
mostCurrent._et_saat_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129619;
 //BA.debugLineNum = 31129619;BA.debugLine="et_min_kari.Color=Colors.White";
mostCurrent._et_min_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31129622;
 //BA.debugLineNum = 31129622;BA.debugLine="read_onvan";
_read_onvan();
RDebugUtils.currentLine=31129625;
 //BA.debugLineNum = 31129625;BA.debugLine="pan_hed_sethogog.Color=Main.color4";
mostCurrent._pan_hed_sethogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=31129626;
 //BA.debugLineNum = 31129626;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=31129630;
 //BA.debugLineNum = 31129630;BA.debugLine="olad_vahed=417975";
_olad_vahed = (int) (417975);
RDebugUtils.currentLine=31129634;
 //BA.debugLineNum = 31129634;BA.debugLine="sp_ganon_kar.Add(\"سال 1399\")";
mostCurrent._sp_ganon_kar.Add("سال 1399");
RDebugUtils.currentLine=31129635;
 //BA.debugLineNum = 31129635;BA.debugLine="sp_ganon_kar.Add(\"سال 1400\")";
mostCurrent._sp_ganon_kar.Add("سال 1400");
RDebugUtils.currentLine=31129636;
 //BA.debugLineNum = 31129636;BA.debugLine="sp_ganon_kar.Add(\"سال 1401\")";
mostCurrent._sp_ganon_kar.Add("سال 1401");
RDebugUtils.currentLine=31129637;
 //BA.debugLineNum = 31129637;BA.debugLine="sp_ganon_kar.Add(\"سفارشی شده\")";
mostCurrent._sp_ganon_kar.Add("سفارشی شده");
RDebugUtils.currentLine=31129641;
 //BA.debugLineNum = 31129641;BA.debugLine="sp_olad.AddAll(Array As String(0,1,2,3,4,5,6,7,8,";
mostCurrent._sp_olad.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9),BA.NumberToString(10)}));
RDebugUtils.currentLine=31129646;
 //BA.debugLineNum = 31129646;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=31129647;
 //BA.debugLineNum = 31129647;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=31129649;
 //BA.debugLineNum = 31129649;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=31129650;
 //BA.debugLineNum = 31129650;BA.debugLine="et_paye.Text=myfunc.show_num_pool(dbCode.res.GetS";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=31129651;
 //BA.debugLineNum = 31129651;BA.debugLine="et_paye.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_paye.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=31129655;
 //BA.debugLineNum = 31129655;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (1));
RDebugUtils.currentLine=31129656;
 //BA.debugLineNum = 31129656;BA.debugLine="et_maskan.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_maskan.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=31129657;
 //BA.debugLineNum = 31129657;BA.debugLine="et_maskan.Text=myfunc.show_num_pool(dbCode.res.Ge";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=31129659;
 //BA.debugLineNum = 31129659;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (3));
RDebugUtils.currentLine=31129660;
 //BA.debugLineNum = 31129660;BA.debugLine="et_olad.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_olad.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=31129661;
 //BA.debugLineNum = 31129661;BA.debugLine="et_olad.Text=myfunc.show_num_pool(dbCode.res.GetS";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=31129663;
 //BA.debugLineNum = 31129663;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (4));
RDebugUtils.currentLine=31129664;
 //BA.debugLineNum = 31129664;BA.debugLine="et_fani.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_fani.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=31129665;
 //BA.debugLineNum = 31129665;BA.debugLine="et_fani.Text=myfunc.show_num_pool(dbCode.res.GetS";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=31129667;
 //BA.debugLineNum = 31129667;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (5));
RDebugUtils.currentLine=31129668;
 //BA.debugLineNum = 31129668;BA.debugLine="et_masoliat.tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_masoliat.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=31129669;
 //BA.debugLineNum = 31129669;BA.debugLine="et_masoliat.Text=myfunc.show_num_pool(dbCode.res.";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=31129671;
 //BA.debugLineNum = 31129671;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (2));
RDebugUtils.currentLine=31129672;
 //BA.debugLineNum = 31129672;BA.debugLine="et_bon.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_bon.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=31129673;
 //BA.debugLineNum = 31129673;BA.debugLine="et_bon.Text=myfunc.show_num_pool(dbCode.res.GetSt";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=31129675;
 //BA.debugLineNum = 31129675;BA.debugLine="dbCode.res.Position=6 ''--------bime_tamin------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (6));
RDebugUtils.currentLine=31129676;
 //BA.debugLineNum = 31129676;BA.debugLine="et_bime_tamin.Text=dbCode.res.GetString(\"value\")";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=31129678;
 //BA.debugLineNum = 31129678;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (11));
RDebugUtils.currentLine=31129679;
 //BA.debugLineNum = 31129679;BA.debugLine="et_bime_takmil.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_bime_takmil.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=31129680;
 //BA.debugLineNum = 31129680;BA.debugLine="et_bime_takmil.Text=myfunc.show_num_pool(dbCode.r";
mostCurrent._et_bime_takmil.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=31129682;
 //BA.debugLineNum = 31129682;BA.debugLine="dbCode.res.Position=13 ''--------hag shift------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (13));
RDebugUtils.currentLine=31129683;
 //BA.debugLineNum = 31129683;BA.debugLine="et_shift.Text=dbCode.res.GetString(\"value\")";
mostCurrent._et_shift.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=31129685;
 //BA.debugLineNum = 31129685;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (14));
RDebugUtils.currentLine=31129686;
 //BA.debugLineNum = 31129686;BA.debugLine="et_sanavat.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_sanavat.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=31129687;
 //BA.debugLineNum = 31129687;BA.debugLine="et_sanavat.Text=myfunc.show_num_pool(dbCode.res.G";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=31129689;
 //BA.debugLineNum = 31129689;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (15));
RDebugUtils.currentLine=31129690;
 //BA.debugLineNum = 31129690;BA.debugLine="et_sarparast.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_sarparast.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=31129691;
 //BA.debugLineNum = 31129691;BA.debugLine="et_sarparast.Text=myfunc.show_num_pool(dbCode.res";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=31129693;
 //BA.debugLineNum = 31129693;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (16));
RDebugUtils.currentLine=31129694;
 //BA.debugLineNum = 31129694;BA.debugLine="et_mazaya.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_mazaya.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=31129695;
 //BA.debugLineNum = 31129695;BA.debugLine="et_mazaya.Text=myfunc.show_num_pool(dbCode.res.Ge";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=31129697;
 //BA.debugLineNum = 31129697;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (19));
RDebugUtils.currentLine=31129698;
 //BA.debugLineNum = 31129698;BA.debugLine="et_ksorat.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_ksorat.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=31129699;
 //BA.debugLineNum = 31129699;BA.debugLine="et_ksorat.Text=myfunc.show_num_pool(dbCode.res.Ge";
mostCurrent._et_ksorat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=31129707;
 //BA.debugLineNum = 31129707;BA.debugLine="dbCode.res.Position=18 ''--------number olad-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (18));
RDebugUtils.currentLine=31129708;
 //BA.debugLineNum = 31129708;BA.debugLine="sp_olad.SelectedIndex=dbCode.res.GetString(\"value";
mostCurrent._sp_olad.setSelectedIndex((int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))));
RDebugUtils.currentLine=31129710;
 //BA.debugLineNum = 31129710;BA.debugLine="dbCode.res.Position=26 ''--------saat  kari dar r";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (26));
RDebugUtils.currentLine=31129711;
 //BA.debugLineNum = 31129711;BA.debugLine="min_saat_kari=dbCode.res.GetString(\"value\")";
_min_saat_kari = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=31129713;
 //BA.debugLineNum = 31129713;BA.debugLine="Dim sat1 As Int= min_saat_kari/60";
_sat1 = (int) (_min_saat_kari/(double)60);
RDebugUtils.currentLine=31129714;
 //BA.debugLineNum = 31129714;BA.debugLine="Dim dag1 As Int= min_saat_kari Mod 60";
_dag1 = (int) (_min_saat_kari%60);
RDebugUtils.currentLine=31129716;
 //BA.debugLineNum = 31129716;BA.debugLine="et_saat_kari.Text=sat1";
mostCurrent._et_saat_kari.setText(BA.ObjectToCharSequence(_sat1));
RDebugUtils.currentLine=31129717;
 //BA.debugLineNum = 31129717;BA.debugLine="et_min_kari.Text=dag1";
mostCurrent._et_min_kari.setText(BA.ObjectToCharSequence(_dag1));
RDebugUtils.currentLine=31129725;
 //BA.debugLineNum = 31129725;BA.debugLine="lbl_vahed.Text=\"واحد : تومان\"";
mostCurrent._lbl_vahed.setText(BA.ObjectToCharSequence("واحد : تومان"));
RDebugUtils.currentLine=31129727;
 //BA.debugLineNum = 31129727;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=31129728;
 //BA.debugLineNum = 31129728;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=31129731;
 //BA.debugLineNum = 31129731;BA.debugLine="Dim pay_ch As Int=et_paye.tag";
_pay_ch = (int)(BA.ObjectToNumber(mostCurrent._et_paye.getTag()));
RDebugUtils.currentLine=31129733;
 //BA.debugLineNum = 31129733;BA.debugLine="If (pay_ch=4179755)Then";
if ((_pay_ch==4179755)) { 
RDebugUtils.currentLine=31129734;
 //BA.debugLineNum = 31129734;BA.debugLine="sp_ganon_kar.SelectedIndex=2";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (2));
 }else 
{RDebugUtils.currentLine=31129736;
 //BA.debugLineNum = 31129736;BA.debugLine="else If (pay_ch=2655492)Then";
if ((_pay_ch==2655492)) { 
RDebugUtils.currentLine=31129737;
 //BA.debugLineNum = 31129737;BA.debugLine="sp_ganon_kar.SelectedIndex=1";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (1));
 }else 
{RDebugUtils.currentLine=31129739;
 //BA.debugLineNum = 31129739;BA.debugLine="Else If (pay_ch=1910427) Then";
if ((_pay_ch==1910427)) { 
RDebugUtils.currentLine=31129740;
 //BA.debugLineNum = 31129740;BA.debugLine="sp_ganon_kar.SelectedIndex=0";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (0));
 }else {
RDebugUtils.currentLine=31129742;
 //BA.debugLineNum = 31129742;BA.debugLine="sp_ganon_kar.SelectedIndex=3";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (3));
 }}}
;
RDebugUtils.currentLine=31129747;
 //BA.debugLineNum = 31129747;BA.debugLine="If (File.Exists(File.DirInternal,\"help_set_hogog\"";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_set_hogog")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=31129748;
 //BA.debugLineNum = 31129748;BA.debugLine="show_help";
_show_help();
RDebugUtils.currentLine=31129749;
 //BA.debugLineNum = 31129749;BA.debugLine="File.WriteString(File.DirInternal,\"help_set_hogo";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_set_hogog","");
 };
RDebugUtils.currentLine=31129752;
 //BA.debugLineNum = 31129752;BA.debugLine="End Sub";
return "";
}
public static String  _read_onvan() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "read_onvan", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "read_onvan", null));}
anywheresoftware.b4a.objects.collections.List _ls_onv = null;
RDebugUtils.currentLine=32505856;
 //BA.debugLineNum = 32505856;BA.debugLine="Sub read_onvan";
RDebugUtils.currentLine=32505858;
 //BA.debugLineNum = 32505858;BA.debugLine="Dim ls_onv As List";
_ls_onv = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=32505859;
 //BA.debugLineNum = 32505859;BA.debugLine="ls_onv.Initialize";
_ls_onv.Initialize();
RDebugUtils.currentLine=32505860;
 //BA.debugLineNum = 32505860;BA.debugLine="ls_onv=dbCode.read_onvan_db";
_ls_onv = mostCurrent._dbcode._read_onvan_db /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=32505863;
 //BA.debugLineNum = 32505863;BA.debugLine="lbl_onv1.Text=ls_onv.Get(0)";
mostCurrent._lbl_onv1.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (0))));
RDebugUtils.currentLine=32505864;
 //BA.debugLineNum = 32505864;BA.debugLine="lbl_onv2.Text=ls_onv.Get(1)";
mostCurrent._lbl_onv2.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (1))));
RDebugUtils.currentLine=32505865;
 //BA.debugLineNum = 32505865;BA.debugLine="lbl_onv3.Text=ls_onv.Get(2)";
mostCurrent._lbl_onv3.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (2))));
RDebugUtils.currentLine=32505866;
 //BA.debugLineNum = 32505866;BA.debugLine="lbl_onv4.Text=ls_onv.Get(3)";
mostCurrent._lbl_onv4.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (3))));
RDebugUtils.currentLine=32505867;
 //BA.debugLineNum = 32505867;BA.debugLine="lbl_onv5.Text=ls_onv.Get(4)";
mostCurrent._lbl_onv5.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (4))));
RDebugUtils.currentLine=32505868;
 //BA.debugLineNum = 32505868;BA.debugLine="lbl_onv6.Text=ls_onv.Get(5)";
mostCurrent._lbl_onv6.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (5))));
RDebugUtils.currentLine=32505869;
 //BA.debugLineNum = 32505869;BA.debugLine="lbl_onv7.Text=ls_onv.Get(6)";
mostCurrent._lbl_onv7.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (6))));
RDebugUtils.currentLine=32505870;
 //BA.debugLineNum = 32505870;BA.debugLine="lbl_onv8.Text=ls_onv.Get(7)";
mostCurrent._lbl_onv8.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (7))));
RDebugUtils.currentLine=32505871;
 //BA.debugLineNum = 32505871;BA.debugLine="lbl_onv9.Text=ls_onv.Get(8)";
mostCurrent._lbl_onv9.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (8))));
RDebugUtils.currentLine=32505872;
 //BA.debugLineNum = 32505872;BA.debugLine="lbl_onv10.Text=ls_onv.Get(9)";
mostCurrent._lbl_onv10.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (9))));
RDebugUtils.currentLine=32505873;
 //BA.debugLineNum = 32505873;BA.debugLine="lbl_onv11.Text=ls_onv.Get(10)";
mostCurrent._lbl_onv11.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (10))));
RDebugUtils.currentLine=32505874;
 //BA.debugLineNum = 32505874;BA.debugLine="lbl_onv12.Text=ls_onv.Get(11)";
mostCurrent._lbl_onv12.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (11))));
RDebugUtils.currentLine=32505875;
 //BA.debugLineNum = 32505875;BA.debugLine="lbl_onv13.Text=ls_onv.Get(12)";
mostCurrent._lbl_onv13.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (12))));
RDebugUtils.currentLine=32505878;
 //BA.debugLineNum = 32505878;BA.debugLine="End Sub";
return "";
}
public static String  _show_help() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_help", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_help", null));}
RDebugUtils.currentLine=31195136;
 //BA.debugLineNum = 31195136;BA.debugLine="Sub show_help";
RDebugUtils.currentLine=31195137;
 //BA.debugLineNum = 31195137;BA.debugLine="Msgbox(\"همه قیمت ها به تومان می باشد\",\"هشدار مهم\"";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("همه قیمت ها به تومان می باشد"),BA.ObjectToCharSequence("هشدار مهم"),mostCurrent.activityBA);
RDebugUtils.currentLine=31195138;
 //BA.debugLineNum = 31195138;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=31522816;
 //BA.debugLineNum = 31522816;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=31522817;
 //BA.debugLineNum = 31522817;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=31522818;
 //BA.debugLineNum = 31522818;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=31522819;
 //BA.debugLineNum = 31522819;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=31522821;
 //BA.debugLineNum = 31522821;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=31522823;
 //BA.debugLineNum = 31522823;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=31391744;
 //BA.debugLineNum = 31391744;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=31391745;
 //BA.debugLineNum = 31391745;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=31391747;
 //BA.debugLineNum = 31391747;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=31391748;
 //BA.debugLineNum = 31391748;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
RDebugUtils.currentLine=31326208;
 //BA.debugLineNum = 31326208;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=31326210;
 //BA.debugLineNum = 31326210;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=31260672;
 //BA.debugLineNum = 31260672;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=31260674;
 //BA.debugLineNum = 31260674;BA.debugLine="End Sub";
return "";
}
public static boolean  _empty_fild(anywheresoftware.b4a.objects.EditTextWrapper _et) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "empty_fild", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "empty_fild", new Object[] {_et}));}
RDebugUtils.currentLine=32440320;
 //BA.debugLineNum = 32440320;BA.debugLine="Sub empty_fild(et As EditText) As Boolean";
RDebugUtils.currentLine=32440321;
 //BA.debugLineNum = 32440321;BA.debugLine="If(et.Text.Trim=\"\")Then";
if (((_et.getText().trim()).equals(""))) { 
RDebugUtils.currentLine=32440322;
 //BA.debugLineNum = 32440322;BA.debugLine="ToastMessageShow(\"فیلد خالی است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("فیلد خالی است"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=32440323;
 //BA.debugLineNum = 32440323;BA.debugLine="et.Color=0x9FFF4E4E";
_et.setColor(((int)0x9fff4e4e));
RDebugUtils.currentLine=32440324;
 //BA.debugLineNum = 32440324;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=32440326;
 //BA.debugLineNum = 32440326;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=32440327;
 //BA.debugLineNum = 32440327;BA.debugLine="End Sub";
return false;
}
public static String  _et_bime_takmil_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_bime_takmil_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_bime_takmil_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=31916032;
 //BA.debugLineNum = 31916032;BA.debugLine="Private Sub et_bime_takmil_TextChanged (Old As Str";
RDebugUtils.currentLine=31916033;
 //BA.debugLineNum = 31916033;BA.debugLine="et_bime_takmil.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_bime_takmil.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=31916034;
 //BA.debugLineNum = 31916034;BA.debugLine="myfunc.change_formater(Old,New,et_bime_takmil)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_bime_takmil);
RDebugUtils.currentLine=31916035;
 //BA.debugLineNum = 31916035;BA.debugLine="End Sub";
return "";
}
public static String  _et_bon_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_bon_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_bon_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=31981568;
 //BA.debugLineNum = 31981568;BA.debugLine="Private Sub et_bon_TextChanged (Old As String, New";
RDebugUtils.currentLine=31981569;
 //BA.debugLineNum = 31981569;BA.debugLine="et_bon.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_bon.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=31981570;
 //BA.debugLineNum = 31981570;BA.debugLine="myfunc.change_formater(Old,New,et_bon)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_bon);
RDebugUtils.currentLine=31981571;
 //BA.debugLineNum = 31981571;BA.debugLine="End Sub";
return "";
}
public static String  _et_fani_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_fani_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_fani_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=32178176;
 //BA.debugLineNum = 32178176;BA.debugLine="Private Sub et_fani_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=32178177;
 //BA.debugLineNum = 32178177;BA.debugLine="et_fani.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_fani.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=32178178;
 //BA.debugLineNum = 32178178;BA.debugLine="myfunc.change_formater(Old,New,et_fani)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_fani);
RDebugUtils.currentLine=32178179;
 //BA.debugLineNum = 32178179;BA.debugLine="End Sub";
return "";
}
public static String  _et_ksorat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_ksorat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_ksorat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=31850496;
 //BA.debugLineNum = 31850496;BA.debugLine="Private Sub et_ksorat_TextChanged (Old As String,";
RDebugUtils.currentLine=31850497;
 //BA.debugLineNum = 31850497;BA.debugLine="et_ksorat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_ksorat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=31850498;
 //BA.debugLineNum = 31850498;BA.debugLine="myfunc.change_formater(Old,New,et_ksorat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_ksorat);
RDebugUtils.currentLine=31850499;
 //BA.debugLineNum = 31850499;BA.debugLine="End Sub";
return "";
}
public static String  _et_maskan_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_maskan_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_maskan_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=32309248;
 //BA.debugLineNum = 32309248;BA.debugLine="Private Sub et_maskan_TextChanged (Old As String,";
RDebugUtils.currentLine=32309249;
 //BA.debugLineNum = 32309249;BA.debugLine="et_maskan.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_maskan.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=32309250;
 //BA.debugLineNum = 32309250;BA.debugLine="myfunc.change_formater(Old,New,et_maskan)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_maskan);
RDebugUtils.currentLine=32309251;
 //BA.debugLineNum = 32309251;BA.debugLine="End Sub";
return "";
}
public static String  _et_masoliat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_masoliat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_masoliat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=32112640;
 //BA.debugLineNum = 32112640;BA.debugLine="Private Sub et_masoliat_TextChanged (Old As String";
RDebugUtils.currentLine=32112641;
 //BA.debugLineNum = 32112641;BA.debugLine="et_masoliat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_masoliat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=32112642;
 //BA.debugLineNum = 32112642;BA.debugLine="myfunc.change_formater(Old,New,et_masoliat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_masoliat);
RDebugUtils.currentLine=32112643;
 //BA.debugLineNum = 32112643;BA.debugLine="End Sub";
return "";
}
public static String  _et_mazaya_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mazaya_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mazaya_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=31784960;
 //BA.debugLineNum = 31784960;BA.debugLine="Private Sub et_mazaya_TextChanged (Old As String,";
RDebugUtils.currentLine=31784961;
 //BA.debugLineNum = 31784961;BA.debugLine="et_mazaya.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_mazaya.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=31784962;
 //BA.debugLineNum = 31784962;BA.debugLine="myfunc.change_formater(Old,New,et_mazaya)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_mazaya);
RDebugUtils.currentLine=31784963;
 //BA.debugLineNum = 31784963;BA.debugLine="End Sub";
return "";
}
public static String  _et_olad_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_olad_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_olad_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=32243712;
 //BA.debugLineNum = 32243712;BA.debugLine="Private Sub et_olad_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=32243713;
 //BA.debugLineNum = 32243713;BA.debugLine="et_olad.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_olad.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=32243714;
 //BA.debugLineNum = 32243714;BA.debugLine="myfunc.change_formater(Old,New,et_olad)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_olad);
RDebugUtils.currentLine=32243715;
 //BA.debugLineNum = 32243715;BA.debugLine="End Sub";
return "";
}
public static String  _et_paye_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_paye_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_paye_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=31719424;
 //BA.debugLineNum = 31719424;BA.debugLine="Private Sub et_paye_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=31719425;
 //BA.debugLineNum = 31719425;BA.debugLine="et_paye.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_paye.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=31719426;
 //BA.debugLineNum = 31719426;BA.debugLine="myfunc.change_formater(Old,New,et_paye)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_paye);
RDebugUtils.currentLine=31719427;
 //BA.debugLineNum = 31719427;BA.debugLine="End Sub";
return "";
}
public static String  _et_sanavat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_sanavat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_sanavat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=32374784;
 //BA.debugLineNum = 32374784;BA.debugLine="Private Sub et_sanavat_TextChanged (Old As String,";
RDebugUtils.currentLine=32374785;
 //BA.debugLineNum = 32374785;BA.debugLine="et_sanavat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_sanavat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=32374786;
 //BA.debugLineNum = 32374786;BA.debugLine="myfunc.change_formater(Old,New,et_sanavat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_sanavat);
RDebugUtils.currentLine=32374787;
 //BA.debugLineNum = 32374787;BA.debugLine="End Sub";
return "";
}
public static String  _et_sarparast_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_sarparast_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_sarparast_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=32047104;
 //BA.debugLineNum = 32047104;BA.debugLine="Private Sub et_sarparast_TextChanged (Old As Strin";
RDebugUtils.currentLine=32047105;
 //BA.debugLineNum = 32047105;BA.debugLine="et_sarparast.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_sarparast.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=32047106;
 //BA.debugLineNum = 32047106;BA.debugLine="myfunc.change_formater(Old,New,et_sarparast)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_sarparast);
RDebugUtils.currentLine=32047107;
 //BA.debugLineNum = 32047107;BA.debugLine="End Sub";
return "";
}
public static String  _ev_onv_longclick() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ev_onv_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ev_onv_longclick", null));}
anywheresoftware.b4a.objects.LabelWrapper _this_onv = null;
RDebugUtils.currentLine=32702464;
 //BA.debugLineNum = 32702464;BA.debugLine="Private Sub EV_onv_LongClick";
RDebugUtils.currentLine=32702465;
 //BA.debugLineNum = 32702465;BA.debugLine="Dim this_onv As Label";
_this_onv = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=32702466;
 //BA.debugLineNum = 32702466;BA.debugLine="this_onv=Sender";
_this_onv = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=32702469;
 //BA.debugLineNum = 32702469;BA.debugLine="current_index_onvan=this_onv.Tag";
_current_index_onvan = (int)(BA.ObjectToNumber(_this_onv.getTag()));
RDebugUtils.currentLine=32702471;
 //BA.debugLineNum = 32702471;BA.debugLine="lbl_onv_def.Text=get_onvan_byId(this_onv.Tag).Get";
mostCurrent._lbl_onv_def.setText(BA.ObjectToCharSequence(_get_onvan_byid((int)(BA.ObjectToNumber(_this_onv.getTag()))).Get((int) (0))));
RDebugUtils.currentLine=32702472;
 //BA.debugLineNum = 32702472;BA.debugLine="et_onv_new.Text=get_onvan_byId(this_onv.Tag).Get(";
mostCurrent._et_onv_new.setText(BA.ObjectToCharSequence(_get_onvan_byid((int)(BA.ObjectToNumber(_this_onv.getTag()))).Get((int) (1))));
RDebugUtils.currentLine=32702475;
 //BA.debugLineNum = 32702475;BA.debugLine="pan_all_onvanHa.Visible=True";
mostCurrent._pan_all_onvanha.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=32702476;
 //BA.debugLineNum = 32702476;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _get_onvan_byid(int _id1) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_onvan_byid", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(mostCurrent.activityBA, "get_onvan_byid", new Object[] {_id1}));}
anywheresoftware.b4a.objects.collections.List _ls_result = null;
RDebugUtils.currentLine=32833536;
 //BA.debugLineNum = 32833536;BA.debugLine="Sub get_onvan_byId (id1 As Int) As List";
RDebugUtils.currentLine=32833537;
 //BA.debugLineNum = 32833537;BA.debugLine="Dim ls_result As List";
_ls_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=32833538;
 //BA.debugLineNum = 32833538;BA.debugLine="ls_result.Initialize";
_ls_result.Initialize();
RDebugUtils.currentLine=32833539;
 //BA.debugLineNum = 32833539;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=32833540;
 //BA.debugLineNum = 32833540;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tbl_onvanha WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=32833541;
 //BA.debugLineNum = 32833541;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=32833542;
 //BA.debugLineNum = 32833542;BA.debugLine="ls_result.Add(dbCode.res.GetString(\"def_name\"))";
_ls_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("def_name")));
RDebugUtils.currentLine=32833543;
 //BA.debugLineNum = 32833543;BA.debugLine="ls_result.Add(dbCode.res.GetString(\"custom_name\")";
_ls_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("custom_name")));
RDebugUtils.currentLine=32833544;
 //BA.debugLineNum = 32833544;BA.debugLine="Return ls_result";
if (true) return _ls_result;
RDebugUtils.currentLine=32833545;
 //BA.debugLineNum = 32833545;BA.debugLine="End Sub";
return null;
}
public static String  _lbl_help_onv_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_onv_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_onv_click", null));}
RDebugUtils.currentLine=32964608;
 //BA.debugLineNum = 32964608;BA.debugLine="Private Sub lbl_help_onv_Click";
RDebugUtils.currentLine=32964609;
 //BA.debugLineNum = 32964609;BA.debugLine="myfunc.help_man(\"راهنما\",\"با نگه داشتن انگشت روی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","با نگه داشتن انگشت روی عنوان آیتم ها میتوانید آنها را ویرایش کنید. توجه داشته باشید که عملکرد آنها در محاسبات تغییر نخواهد کرد.");
RDebugUtils.currentLine=32964610;
 //BA.debugLineNum = 32964610;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_onv_def_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_onv_def_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_onv_def_click", null));}
RDebugUtils.currentLine=32899072;
 //BA.debugLineNum = 32899072;BA.debugLine="Private Sub lbl_onv_def_Click";
RDebugUtils.currentLine=32899073;
 //BA.debugLineNum = 32899073;BA.debugLine="et_onv_new.Text=lbl_onv_def.Text";
mostCurrent._et_onv_new.setText(BA.ObjectToCharSequence(mostCurrent._lbl_onv_def.getText()));
RDebugUtils.currentLine=32899075;
 //BA.debugLineNum = 32899075;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_click", null));}
boolean _exep = false;
int _min_sat_kar = 0;
anywheresoftware.b4a.objects.collections.List _data = null;
RDebugUtils.currentLine=31457280;
 //BA.debugLineNum = 31457280;BA.debugLine="Private Sub lbl_save_Click";
RDebugUtils.currentLine=31457281;
 //BA.debugLineNum = 31457281;BA.debugLine="Dim exep As Boolean=True";
_exep = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=31457283;
 //BA.debugLineNum = 31457283;BA.debugLine="et_paye.Color=Colors.White";
mostCurrent._et_paye.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31457284;
 //BA.debugLineNum = 31457284;BA.debugLine="et_maskan.Color=Colors.White";
mostCurrent._et_maskan.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31457285;
 //BA.debugLineNum = 31457285;BA.debugLine="et_fani.Color=Colors.White";
mostCurrent._et_fani.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31457286;
 //BA.debugLineNum = 31457286;BA.debugLine="et_masoliat.Color=Colors.White";
mostCurrent._et_masoliat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31457287;
 //BA.debugLineNum = 31457287;BA.debugLine="et_olad.Color=Colors.White";
mostCurrent._et_olad.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31457288;
 //BA.debugLineNum = 31457288;BA.debugLine="et_bon.Color=Colors.White";
mostCurrent._et_bon.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31457289;
 //BA.debugLineNum = 31457289;BA.debugLine="et_bime_takmil.Color=Colors.White";
mostCurrent._et_bime_takmil.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31457292;
 //BA.debugLineNum = 31457292;BA.debugLine="et_shift.Color=Colors.White";
mostCurrent._et_shift.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31457293;
 //BA.debugLineNum = 31457293;BA.debugLine="et_sanavat.Color=Colors.White";
mostCurrent._et_sanavat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31457294;
 //BA.debugLineNum = 31457294;BA.debugLine="et_sarparast.Color=Colors.White";
mostCurrent._et_sarparast.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31457295;
 //BA.debugLineNum = 31457295;BA.debugLine="et_mazaya.Color=Colors.White";
mostCurrent._et_mazaya.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31457296;
 //BA.debugLineNum = 31457296;BA.debugLine="et_ksorat.Color=Colors.White";
mostCurrent._et_ksorat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31457297;
 //BA.debugLineNum = 31457297;BA.debugLine="et_saat_kari.Color=Colors.White";
mostCurrent._et_saat_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31457298;
 //BA.debugLineNum = 31457298;BA.debugLine="et_min_kari.Color=Colors.White";
mostCurrent._et_min_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=31457313;
 //BA.debugLineNum = 31457313;BA.debugLine="et_maliat.TextColor=Colors.Black";
mostCurrent._et_maliat.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=31457316;
 //BA.debugLineNum = 31457316;BA.debugLine="If(et_shift.Text=\"\")Then";
if (((mostCurrent._et_shift.getText()).equals(""))) { 
RDebugUtils.currentLine=31457317;
 //BA.debugLineNum = 31457317;BA.debugLine="et_shift.Text=0";
mostCurrent._et_shift.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=31457319;
 //BA.debugLineNum = 31457319;BA.debugLine="If(et_saat_kari.Text=\"\")Then";
if (((mostCurrent._et_saat_kari.getText()).equals(""))) { 
RDebugUtils.currentLine=31457320;
 //BA.debugLineNum = 31457320;BA.debugLine="et_saat_kari.Text=8";
mostCurrent._et_saat_kari.setText(BA.ObjectToCharSequence(8));
 };
RDebugUtils.currentLine=31457322;
 //BA.debugLineNum = 31457322;BA.debugLine="If(et_min_kari.Text=\"\")Then";
if (((mostCurrent._et_min_kari.getText()).equals(""))) { 
RDebugUtils.currentLine=31457323;
 //BA.debugLineNum = 31457323;BA.debugLine="et_min_kari.Text=0";
mostCurrent._et_min_kari.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=31457327;
 //BA.debugLineNum = 31457327;BA.debugLine="If(et_shift.Text>100 Or et_shift.Text<0 Or  et_sh";
if (((double)(Double.parseDouble(mostCurrent._et_shift.getText()))>100 || (double)(Double.parseDouble(mostCurrent._et_shift.getText()))<0 || (mostCurrent._et_shift.getText()).equals(""))) { 
RDebugUtils.currentLine=31457328;
 //BA.debugLineNum = 31457328;BA.debugLine="ToastMessageShow(\"خطا درصد-(0 تا 100)\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا درصد-(0 تا 100)"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=31457329;
 //BA.debugLineNum = 31457329;BA.debugLine="et_shift.TextColor=Colors.Red";
mostCurrent._et_shift.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=31457330;
 //BA.debugLineNum = 31457330;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=31457332;
 //BA.debugLineNum = 31457332;BA.debugLine="et_shift.TextColor=Colors.Black";
mostCurrent._et_shift.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=31457335;
 //BA.debugLineNum = 31457335;BA.debugLine="If(et_saat_kari.Text>24 Or et_saat_kari.Text<0 )T";
if (((double)(Double.parseDouble(mostCurrent._et_saat_kari.getText()))>24 || (double)(Double.parseDouble(mostCurrent._et_saat_kari.getText()))<0)) { 
RDebugUtils.currentLine=31457336;
 //BA.debugLineNum = 31457336;BA.debugLine="ToastMessageShow(\"ساعت کاری را اصلاح نمائید\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ساعت کاری را اصلاح نمائید"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=31457337;
 //BA.debugLineNum = 31457337;BA.debugLine="et_saat_kari.TextColor=Colors.Red";
mostCurrent._et_saat_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=31457338;
 //BA.debugLineNum = 31457338;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=31457340;
 //BA.debugLineNum = 31457340;BA.debugLine="et_saat_kari.TextColor=Colors.Black";
mostCurrent._et_saat_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=31457343;
 //BA.debugLineNum = 31457343;BA.debugLine="If(et_min_kari.Text>59 Or et_min_kari.Text<0 )The";
if (((double)(Double.parseDouble(mostCurrent._et_min_kari.getText()))>59 || (double)(Double.parseDouble(mostCurrent._et_min_kari.getText()))<0)) { 
RDebugUtils.currentLine=31457344;
 //BA.debugLineNum = 31457344;BA.debugLine="ToastMessageShow(\"ساعت کاری را اصلاح نمائید\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ساعت کاری را اصلاح نمائید"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=31457345;
 //BA.debugLineNum = 31457345;BA.debugLine="et_min_kari.TextColor=Colors.Red";
mostCurrent._et_min_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=31457346;
 //BA.debugLineNum = 31457346;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=31457348;
 //BA.debugLineNum = 31457348;BA.debugLine="et_min_kari.TextColor=Colors.Black";
mostCurrent._et_min_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=31457354;
 //BA.debugLineNum = 31457354;BA.debugLine="If(empty_fild(et_paye)=True)Then";
if ((_empty_fild(mostCurrent._et_paye)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=31457355;
 //BA.debugLineNum = 31457355;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=31457357;
 //BA.debugLineNum = 31457357;BA.debugLine="If(empty_fild(et_maskan)=True)Then";
if ((_empty_fild(mostCurrent._et_maskan)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=31457358;
 //BA.debugLineNum = 31457358;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=31457360;
 //BA.debugLineNum = 31457360;BA.debugLine="If(empty_fild(et_bon)=True)Then";
if ((_empty_fild(mostCurrent._et_bon)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=31457361;
 //BA.debugLineNum = 31457361;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=31457364;
 //BA.debugLineNum = 31457364;BA.debugLine="If(et_sanavat.Text=\"\")Then";
if (((mostCurrent._et_sanavat.getText()).equals(""))) { 
RDebugUtils.currentLine=31457365;
 //BA.debugLineNum = 31457365;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=31457367;
 //BA.debugLineNum = 31457367;BA.debugLine="If(et_olad.Text=\"\")Then";
if (((mostCurrent._et_olad.getText()).equals(""))) { 
RDebugUtils.currentLine=31457368;
 //BA.debugLineNum = 31457368;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=31457370;
 //BA.debugLineNum = 31457370;BA.debugLine="If(et_fani.Text=\"\")Then";
if (((mostCurrent._et_fani.getText()).equals(""))) { 
RDebugUtils.currentLine=31457371;
 //BA.debugLineNum = 31457371;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=31457373;
 //BA.debugLineNum = 31457373;BA.debugLine="If(et_masoliat.Text=\"\")Then";
if (((mostCurrent._et_masoliat.getText()).equals(""))) { 
RDebugUtils.currentLine=31457374;
 //BA.debugLineNum = 31457374;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=31457376;
 //BA.debugLineNum = 31457376;BA.debugLine="If(et_sarparast.Text=\"\")Then";
if (((mostCurrent._et_sarparast.getText()).equals(""))) { 
RDebugUtils.currentLine=31457377;
 //BA.debugLineNum = 31457377;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=31457379;
 //BA.debugLineNum = 31457379;BA.debugLine="If(et_bime_takmil.Text=\"\")Then";
if (((mostCurrent._et_bime_takmil.getText()).equals(""))) { 
RDebugUtils.currentLine=31457380;
 //BA.debugLineNum = 31457380;BA.debugLine="et_bime_takmil.Text=0";
mostCurrent._et_bime_takmil.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=31457382;
 //BA.debugLineNum = 31457382;BA.debugLine="If(et_mazaya.Text=\"\")Then";
if (((mostCurrent._et_mazaya.getText()).equals(""))) { 
RDebugUtils.currentLine=31457383;
 //BA.debugLineNum = 31457383;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=31457385;
 //BA.debugLineNum = 31457385;BA.debugLine="If(et_ksorat.Text=\"\")Then";
if (((mostCurrent._et_ksorat.getText()).equals(""))) { 
RDebugUtils.currentLine=31457386;
 //BA.debugLineNum = 31457386;BA.debugLine="et_ksorat.Text=0";
mostCurrent._et_ksorat.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=31457390;
 //BA.debugLineNum = 31457390;BA.debugLine="Dim min_sat_kar As Int=(et_saat_kari.Text*60)+et_";
_min_sat_kar = (int) (((double)(Double.parseDouble(mostCurrent._et_saat_kari.getText()))*60)+(double)(Double.parseDouble(mostCurrent._et_min_kari.getText())));
RDebugUtils.currentLine=31457392;
 //BA.debugLineNum = 31457392;BA.debugLine="If(exep=True)Then";
if ((_exep==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=31457393;
 //BA.debugLineNum = 31457393;BA.debugLine="Dim data As List";
_data = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=31457394;
 //BA.debugLineNum = 31457394;BA.debugLine="data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=31457395;
 //BA.debugLineNum = 31457395;BA.debugLine="data.AddAll(Array As String(et_paye.Tag,et_maska";
_data.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{BA.ObjectToString(mostCurrent._et_paye.getTag()),BA.ObjectToString(mostCurrent._et_maskan.getTag()),BA.ObjectToString(mostCurrent._et_olad.getTag()),BA.ObjectToString(mostCurrent._et_fani.getTag()),BA.ObjectToString(mostCurrent._et_masoliat.getTag()),BA.ObjectToString(mostCurrent._et_bon.getTag()),mostCurrent._et_bime_tamin.getText(),BA.ObjectToString(mostCurrent._et_bime_takmil.getTag()),BA.NumberToString(10),mostCurrent._et_shift.getText(),BA.ObjectToString(mostCurrent._et_sanavat.getTag()),BA.ObjectToString(mostCurrent._et_sarparast.getTag()),BA.ObjectToString(mostCurrent._et_mazaya.getTag()),mostCurrent._sp_olad.getSelectedItem(),BA.ObjectToString(mostCurrent._et_ksorat.getTag()),BA.NumberToString(_min_sat_kar)}));
RDebugUtils.currentLine=31457398;
 //BA.debugLineNum = 31457398;BA.debugLine="If (dbCode.add_setting_hogog(data)) Then";
if ((mostCurrent._dbcode._add_setting_hogog /*boolean*/ (mostCurrent.activityBA,_data))) { 
RDebugUtils.currentLine=31457399;
 //BA.debugLineNum = 31457399;BA.debugLine="ToastMessageShow (\"ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=31457401;
 //BA.debugLineNum = 31457401;BA.debugLine="Main.saat_kar_min=min_sat_kar";
mostCurrent._main._saat_kar_min /*int*/  = _min_sat_kar;
RDebugUtils.currentLine=31457402;
 //BA.debugLineNum = 31457402;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 };
RDebugUtils.currentLine=31457409;
 //BA.debugLineNum = 31457409;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_onvan_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_onvan_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_onvan_click", null));}
RDebugUtils.currentLine=32768000;
 //BA.debugLineNum = 32768000;BA.debugLine="Private Sub lbl_save_onvan_Click";
RDebugUtils.currentLine=32768001;
 //BA.debugLineNum = 32768001;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=32768002;
 //BA.debugLineNum = 32768002;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tbl_onvanha SET '";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tbl_onvanha SET 'custom_name' ='"+mostCurrent._et_onv_new.getText()+"'  WHERE id="+BA.NumberToString(_current_index_onvan));
RDebugUtils.currentLine=32768004;
 //BA.debugLineNum = 32768004;BA.debugLine="read_onvan";
_read_onvan();
RDebugUtils.currentLine=32768005;
 //BA.debugLineNum = 32768005;BA.debugLine="pan_all_onvanHa.Visible=False";
mostCurrent._pan_all_onvanha.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=32768006;
 //BA.debugLineNum = 32768006;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_onvanha_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_onvanha_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_onvanha_click", null));}
RDebugUtils.currentLine=32571392;
 //BA.debugLineNum = 32571392;BA.debugLine="Private Sub pan_all_onvanHa_Click";
RDebugUtils.currentLine=32571394;
 //BA.debugLineNum = 32571394;BA.debugLine="pan_all_onvanHa.Visible=False";
mostCurrent._pan_all_onvanha.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=32571395;
 //BA.debugLineNum = 32571395;BA.debugLine="End Sub";
return "";
}
public static String  _panel15_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel15_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel15_click", null));}
RDebugUtils.currentLine=32636928;
 //BA.debugLineNum = 32636928;BA.debugLine="Private Sub Panel15_Click";
RDebugUtils.currentLine=32636930;
 //BA.debugLineNum = 32636930;BA.debugLine="End Sub";
return "";
}
public static String  _sp_ganon_kar_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_ganon_kar_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_ganon_kar_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=31588352;
 //BA.debugLineNum = 31588352;BA.debugLine="Private Sub sp_ganon_kar_ItemClick (Position As In";
RDebugUtils.currentLine=31588355;
 //BA.debugLineNum = 31588355;BA.debugLine="Select Value";
switch (BA.switchObjectToInt(_value,(Object)("سال 1401"),(Object)("سال 1400"),(Object)("سال 1399"))) {
case 0: {
RDebugUtils.currentLine=31588358;
 //BA.debugLineNum = 31588358;BA.debugLine="et_paye.Text=4179755";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(4179755));
RDebugUtils.currentLine=31588359;
 //BA.debugLineNum = 31588359;BA.debugLine="et_maskan.Text=650000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(650000));
RDebugUtils.currentLine=31588360;
 //BA.debugLineNum = 31588360;BA.debugLine="et_bon.Text=850000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(850000));
RDebugUtils.currentLine=31588361;
 //BA.debugLineNum = 31588361;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=31588364;
 //BA.debugLineNum = 31588364;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31588365;
 //BA.debugLineNum = 31588365;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31588366;
 //BA.debugLineNum = 31588366;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31588367;
 //BA.debugLineNum = 31588367;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31588370;
 //BA.debugLineNum = 31588370;BA.debugLine="olad_vahed=417975";
_olad_vahed = (int) (417975);
RDebugUtils.currentLine=31588371;
 //BA.debugLineNum = 31588371;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31588375;
 //BA.debugLineNum = 31588375;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
case 1: {
RDebugUtils.currentLine=31588378;
 //BA.debugLineNum = 31588378;BA.debugLine="et_paye.Text=2655492";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(2655492));
RDebugUtils.currentLine=31588379;
 //BA.debugLineNum = 31588379;BA.debugLine="et_maskan.Text=450000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(450000));
RDebugUtils.currentLine=31588380;
 //BA.debugLineNum = 31588380;BA.debugLine="et_bon.Text=600000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(600000));
RDebugUtils.currentLine=31588381;
 //BA.debugLineNum = 31588381;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=31588384;
 //BA.debugLineNum = 31588384;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31588385;
 //BA.debugLineNum = 31588385;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31588386;
 //BA.debugLineNum = 31588386;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31588387;
 //BA.debugLineNum = 31588387;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31588390;
 //BA.debugLineNum = 31588390;BA.debugLine="olad_vahed=265549";
_olad_vahed = (int) (265549);
RDebugUtils.currentLine=31588391;
 //BA.debugLineNum = 31588391;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31588395;
 //BA.debugLineNum = 31588395;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
case 2: {
RDebugUtils.currentLine=31588398;
 //BA.debugLineNum = 31588398;BA.debugLine="et_paye.Text=1910427";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(1910427));
RDebugUtils.currentLine=31588399;
 //BA.debugLineNum = 31588399;BA.debugLine="et_maskan.Text=300000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(300000));
RDebugUtils.currentLine=31588400;
 //BA.debugLineNum = 31588400;BA.debugLine="et_bon.Text=400000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(400000));
RDebugUtils.currentLine=31588401;
 //BA.debugLineNum = 31588401;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=31588404;
 //BA.debugLineNum = 31588404;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31588405;
 //BA.debugLineNum = 31588405;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31588406;
 //BA.debugLineNum = 31588406;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31588407;
 //BA.debugLineNum = 31588407;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31588410;
 //BA.debugLineNum = 31588410;BA.debugLine="olad_vahed=191127";
_olad_vahed = (int) (191127);
RDebugUtils.currentLine=31588411;
 //BA.debugLineNum = 31588411;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31588415;
 //BA.debugLineNum = 31588415;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
default: {
RDebugUtils.currentLine=31588418;
 //BA.debugLineNum = 31588418;BA.debugLine="sp_ganon_kar.Clear";
mostCurrent._sp_ganon_kar.Clear();
RDebugUtils.currentLine=31588419;
 //BA.debugLineNum = 31588419;BA.debugLine="Activity_Create(False)";
_activity_create(anywheresoftware.b4a.keywords.Common.False);
 break; }
}
;
RDebugUtils.currentLine=31588423;
 //BA.debugLineNum = 31588423;BA.debugLine="End Sub";
return "";
}
public static String  _sp_olad_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_olad_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_olad_itemclick", new Object[] {_position,_value}));}
int _num = 0;
RDebugUtils.currentLine=31653888;
 //BA.debugLineNum = 31653888;BA.debugLine="Private Sub sp_olad_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=31653889;
 //BA.debugLineNum = 31653889;BA.debugLine="Dim num As Int=Value";
_num = (int)(BA.ObjectToNumber(_value));
RDebugUtils.currentLine=31653890;
 //BA.debugLineNum = 31653890;BA.debugLine="et_olad.Text=olad_vahed*num";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(_olad_vahed*_num));
RDebugUtils.currentLine=31653891;
 //BA.debugLineNum = 31653891;BA.debugLine="End Sub";
return "";
}
}