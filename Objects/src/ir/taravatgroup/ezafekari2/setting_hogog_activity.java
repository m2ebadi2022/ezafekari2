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
RDebugUtils.currentLine=34340864;
 //BA.debugLineNum = 34340864;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=34340866;
 //BA.debugLineNum = 34340866;BA.debugLine="Activity.LoadLayout(\"setting_hogog_layout\")";
mostCurrent._activity.LoadLayout("setting_hogog_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=34340867;
 //BA.debugLineNum = 34340867;BA.debugLine="scv_sett_hogog.Panel.LoadLayout(\"sett_hogog_item\"";
mostCurrent._scv_sett_hogog.getPanel().LoadLayout("sett_hogog_item",mostCurrent.activityBA);
RDebugUtils.currentLine=34340868;
 //BA.debugLineNum = 34340868;BA.debugLine="et_paye.Color=Colors.White";
mostCurrent._et_paye.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340869;
 //BA.debugLineNum = 34340869;BA.debugLine="et_maskan.Color=Colors.White";
mostCurrent._et_maskan.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340870;
 //BA.debugLineNum = 34340870;BA.debugLine="et_fani.Color=Colors.White";
mostCurrent._et_fani.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340871;
 //BA.debugLineNum = 34340871;BA.debugLine="et_masoliat.Color=Colors.White";
mostCurrent._et_masoliat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340872;
 //BA.debugLineNum = 34340872;BA.debugLine="et_olad.Color=Colors.White";
mostCurrent._et_olad.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340873;
 //BA.debugLineNum = 34340873;BA.debugLine="et_bon.Color=Colors.White";
mostCurrent._et_bon.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340874;
 //BA.debugLineNum = 34340874;BA.debugLine="et_bime_takmil.Color=Colors.White";
mostCurrent._et_bime_takmil.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340875;
 //BA.debugLineNum = 34340875;BA.debugLine="et_maliat.Color=Colors.White";
mostCurrent._et_maliat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340876;
 //BA.debugLineNum = 34340876;BA.debugLine="et_bime_tamin.Color=Colors.White";
mostCurrent._et_bime_tamin.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340877;
 //BA.debugLineNum = 34340877;BA.debugLine="et_shift.Color=Colors.White";
mostCurrent._et_shift.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340878;
 //BA.debugLineNum = 34340878;BA.debugLine="et_sanavat.Color=Colors.White";
mostCurrent._et_sanavat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340879;
 //BA.debugLineNum = 34340879;BA.debugLine="et_sarparast.Color=Colors.White";
mostCurrent._et_sarparast.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340880;
 //BA.debugLineNum = 34340880;BA.debugLine="et_mazaya.Color=Colors.White";
mostCurrent._et_mazaya.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340881;
 //BA.debugLineNum = 34340881;BA.debugLine="et_ksorat.Color=Colors.White";
mostCurrent._et_ksorat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340882;
 //BA.debugLineNum = 34340882;BA.debugLine="et_saat_kari.Color=Colors.White";
mostCurrent._et_saat_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340883;
 //BA.debugLineNum = 34340883;BA.debugLine="et_min_kari.Color=Colors.White";
mostCurrent._et_min_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34340886;
 //BA.debugLineNum = 34340886;BA.debugLine="read_onvan";
_read_onvan();
RDebugUtils.currentLine=34340889;
 //BA.debugLineNum = 34340889;BA.debugLine="pan_hed_sethogog.Color=Main.color4";
mostCurrent._pan_hed_sethogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=34340890;
 //BA.debugLineNum = 34340890;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=34340894;
 //BA.debugLineNum = 34340894;BA.debugLine="olad_vahed=417975";
_olad_vahed = (int) (417975);
RDebugUtils.currentLine=34340898;
 //BA.debugLineNum = 34340898;BA.debugLine="sp_ganon_kar.Add(\"سال 1399\")";
mostCurrent._sp_ganon_kar.Add("سال 1399");
RDebugUtils.currentLine=34340899;
 //BA.debugLineNum = 34340899;BA.debugLine="sp_ganon_kar.Add(\"سال 1400\")";
mostCurrent._sp_ganon_kar.Add("سال 1400");
RDebugUtils.currentLine=34340900;
 //BA.debugLineNum = 34340900;BA.debugLine="sp_ganon_kar.Add(\"سال 1401\")";
mostCurrent._sp_ganon_kar.Add("سال 1401");
RDebugUtils.currentLine=34340901;
 //BA.debugLineNum = 34340901;BA.debugLine="sp_ganon_kar.Add(\"سفارشی شده\")";
mostCurrent._sp_ganon_kar.Add("سفارشی شده");
RDebugUtils.currentLine=34340905;
 //BA.debugLineNum = 34340905;BA.debugLine="sp_olad.AddAll(Array As String(0,1,2,3,4,5,6,7,8,";
mostCurrent._sp_olad.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9),BA.NumberToString(10)}));
RDebugUtils.currentLine=34340910;
 //BA.debugLineNum = 34340910;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=34340911;
 //BA.debugLineNum = 34340911;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=34340913;
 //BA.debugLineNum = 34340913;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=34340914;
 //BA.debugLineNum = 34340914;BA.debugLine="et_paye.Text=myfunc.show_num_pool(dbCode.res.GetS";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=34340915;
 //BA.debugLineNum = 34340915;BA.debugLine="et_paye.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_paye.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=34340919;
 //BA.debugLineNum = 34340919;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (1));
RDebugUtils.currentLine=34340920;
 //BA.debugLineNum = 34340920;BA.debugLine="et_maskan.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_maskan.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=34340921;
 //BA.debugLineNum = 34340921;BA.debugLine="et_maskan.Text=myfunc.show_num_pool(dbCode.res.Ge";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=34340923;
 //BA.debugLineNum = 34340923;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (3));
RDebugUtils.currentLine=34340924;
 //BA.debugLineNum = 34340924;BA.debugLine="et_olad.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_olad.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=34340925;
 //BA.debugLineNum = 34340925;BA.debugLine="et_olad.Text=myfunc.show_num_pool(dbCode.res.GetS";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=34340927;
 //BA.debugLineNum = 34340927;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (4));
RDebugUtils.currentLine=34340928;
 //BA.debugLineNum = 34340928;BA.debugLine="et_fani.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_fani.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=34340929;
 //BA.debugLineNum = 34340929;BA.debugLine="et_fani.Text=myfunc.show_num_pool(dbCode.res.GetS";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=34340931;
 //BA.debugLineNum = 34340931;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (5));
RDebugUtils.currentLine=34340932;
 //BA.debugLineNum = 34340932;BA.debugLine="et_masoliat.tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_masoliat.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=34340933;
 //BA.debugLineNum = 34340933;BA.debugLine="et_masoliat.Text=myfunc.show_num_pool(dbCode.res.";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=34340935;
 //BA.debugLineNum = 34340935;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (2));
RDebugUtils.currentLine=34340936;
 //BA.debugLineNum = 34340936;BA.debugLine="et_bon.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_bon.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=34340937;
 //BA.debugLineNum = 34340937;BA.debugLine="et_bon.Text=myfunc.show_num_pool(dbCode.res.GetSt";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=34340939;
 //BA.debugLineNum = 34340939;BA.debugLine="dbCode.res.Position=6 ''--------bime_tamin------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (6));
RDebugUtils.currentLine=34340940;
 //BA.debugLineNum = 34340940;BA.debugLine="et_bime_tamin.Text=dbCode.res.GetString(\"value\")";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=34340942;
 //BA.debugLineNum = 34340942;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (11));
RDebugUtils.currentLine=34340943;
 //BA.debugLineNum = 34340943;BA.debugLine="et_bime_takmil.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_bime_takmil.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=34340944;
 //BA.debugLineNum = 34340944;BA.debugLine="et_bime_takmil.Text=myfunc.show_num_pool(dbCode.r";
mostCurrent._et_bime_takmil.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=34340946;
 //BA.debugLineNum = 34340946;BA.debugLine="dbCode.res.Position=13 ''--------hag shift------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (13));
RDebugUtils.currentLine=34340947;
 //BA.debugLineNum = 34340947;BA.debugLine="et_shift.Text=dbCode.res.GetString(\"value\")";
mostCurrent._et_shift.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=34340949;
 //BA.debugLineNum = 34340949;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (14));
RDebugUtils.currentLine=34340950;
 //BA.debugLineNum = 34340950;BA.debugLine="et_sanavat.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_sanavat.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=34340951;
 //BA.debugLineNum = 34340951;BA.debugLine="et_sanavat.Text=myfunc.show_num_pool(dbCode.res.G";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=34340953;
 //BA.debugLineNum = 34340953;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (15));
RDebugUtils.currentLine=34340954;
 //BA.debugLineNum = 34340954;BA.debugLine="et_sarparast.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_sarparast.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=34340955;
 //BA.debugLineNum = 34340955;BA.debugLine="et_sarparast.Text=myfunc.show_num_pool(dbCode.res";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=34340957;
 //BA.debugLineNum = 34340957;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (16));
RDebugUtils.currentLine=34340958;
 //BA.debugLineNum = 34340958;BA.debugLine="et_mazaya.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_mazaya.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=34340959;
 //BA.debugLineNum = 34340959;BA.debugLine="et_mazaya.Text=myfunc.show_num_pool(dbCode.res.Ge";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=34340961;
 //BA.debugLineNum = 34340961;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (19));
RDebugUtils.currentLine=34340962;
 //BA.debugLineNum = 34340962;BA.debugLine="et_ksorat.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_ksorat.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=34340963;
 //BA.debugLineNum = 34340963;BA.debugLine="et_ksorat.Text=myfunc.show_num_pool(dbCode.res.Ge";
mostCurrent._et_ksorat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=34340971;
 //BA.debugLineNum = 34340971;BA.debugLine="dbCode.res.Position=18 ''--------number olad-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (18));
RDebugUtils.currentLine=34340972;
 //BA.debugLineNum = 34340972;BA.debugLine="sp_olad.SelectedIndex=dbCode.res.GetString(\"value";
mostCurrent._sp_olad.setSelectedIndex((int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))));
RDebugUtils.currentLine=34340974;
 //BA.debugLineNum = 34340974;BA.debugLine="dbCode.res.Position=26 ''--------saat  kari dar r";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (26));
RDebugUtils.currentLine=34340975;
 //BA.debugLineNum = 34340975;BA.debugLine="min_saat_kari=dbCode.res.GetString(\"value\")";
_min_saat_kari = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=34340977;
 //BA.debugLineNum = 34340977;BA.debugLine="Dim sat1 As Int= min_saat_kari/60";
_sat1 = (int) (_min_saat_kari/(double)60);
RDebugUtils.currentLine=34340978;
 //BA.debugLineNum = 34340978;BA.debugLine="Dim dag1 As Int= min_saat_kari Mod 60";
_dag1 = (int) (_min_saat_kari%60);
RDebugUtils.currentLine=34340980;
 //BA.debugLineNum = 34340980;BA.debugLine="et_saat_kari.Text=sat1";
mostCurrent._et_saat_kari.setText(BA.ObjectToCharSequence(_sat1));
RDebugUtils.currentLine=34340981;
 //BA.debugLineNum = 34340981;BA.debugLine="et_min_kari.Text=dag1";
mostCurrent._et_min_kari.setText(BA.ObjectToCharSequence(_dag1));
RDebugUtils.currentLine=34340989;
 //BA.debugLineNum = 34340989;BA.debugLine="lbl_vahed.Text=\"واحد : تومان\"";
mostCurrent._lbl_vahed.setText(BA.ObjectToCharSequence("واحد : تومان"));
RDebugUtils.currentLine=34340991;
 //BA.debugLineNum = 34340991;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=34340992;
 //BA.debugLineNum = 34340992;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=34340995;
 //BA.debugLineNum = 34340995;BA.debugLine="Dim pay_ch As Int=et_paye.tag";
_pay_ch = (int)(BA.ObjectToNumber(mostCurrent._et_paye.getTag()));
RDebugUtils.currentLine=34340997;
 //BA.debugLineNum = 34340997;BA.debugLine="If (pay_ch=4179755)Then";
if ((_pay_ch==4179755)) { 
RDebugUtils.currentLine=34340998;
 //BA.debugLineNum = 34340998;BA.debugLine="sp_ganon_kar.SelectedIndex=2";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (2));
 }else 
{RDebugUtils.currentLine=34341000;
 //BA.debugLineNum = 34341000;BA.debugLine="else If (pay_ch=2655492)Then";
if ((_pay_ch==2655492)) { 
RDebugUtils.currentLine=34341001;
 //BA.debugLineNum = 34341001;BA.debugLine="sp_ganon_kar.SelectedIndex=1";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (1));
 }else 
{RDebugUtils.currentLine=34341003;
 //BA.debugLineNum = 34341003;BA.debugLine="Else If (pay_ch=1910427) Then";
if ((_pay_ch==1910427)) { 
RDebugUtils.currentLine=34341004;
 //BA.debugLineNum = 34341004;BA.debugLine="sp_ganon_kar.SelectedIndex=0";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (0));
 }else {
RDebugUtils.currentLine=34341006;
 //BA.debugLineNum = 34341006;BA.debugLine="sp_ganon_kar.SelectedIndex=3";
mostCurrent._sp_ganon_kar.setSelectedIndex((int) (3));
 }}}
;
RDebugUtils.currentLine=34341011;
 //BA.debugLineNum = 34341011;BA.debugLine="If (File.Exists(File.DirInternal,\"help_set_hogog\"";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_set_hogog")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=34341012;
 //BA.debugLineNum = 34341012;BA.debugLine="show_help";
_show_help();
RDebugUtils.currentLine=34341013;
 //BA.debugLineNum = 34341013;BA.debugLine="File.WriteString(File.DirInternal,\"help_set_hogo";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_set_hogog","");
 };
RDebugUtils.currentLine=34341016;
 //BA.debugLineNum = 34341016;BA.debugLine="End Sub";
return "";
}
public static String  _read_onvan() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "read_onvan", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "read_onvan", null));}
anywheresoftware.b4a.objects.collections.List _ls_onv = null;
RDebugUtils.currentLine=35717120;
 //BA.debugLineNum = 35717120;BA.debugLine="Sub read_onvan";
RDebugUtils.currentLine=35717122;
 //BA.debugLineNum = 35717122;BA.debugLine="Dim ls_onv As List";
_ls_onv = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=35717123;
 //BA.debugLineNum = 35717123;BA.debugLine="ls_onv.Initialize";
_ls_onv.Initialize();
RDebugUtils.currentLine=35717124;
 //BA.debugLineNum = 35717124;BA.debugLine="ls_onv=dbCode.read_onvan_db";
_ls_onv = mostCurrent._dbcode._read_onvan_db /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=35717127;
 //BA.debugLineNum = 35717127;BA.debugLine="lbl_onv1.Text=ls_onv.Get(0)";
mostCurrent._lbl_onv1.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (0))));
RDebugUtils.currentLine=35717128;
 //BA.debugLineNum = 35717128;BA.debugLine="lbl_onv2.Text=ls_onv.Get(1)";
mostCurrent._lbl_onv2.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (1))));
RDebugUtils.currentLine=35717129;
 //BA.debugLineNum = 35717129;BA.debugLine="lbl_onv3.Text=ls_onv.Get(2)";
mostCurrent._lbl_onv3.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (2))));
RDebugUtils.currentLine=35717130;
 //BA.debugLineNum = 35717130;BA.debugLine="lbl_onv4.Text=ls_onv.Get(3)";
mostCurrent._lbl_onv4.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (3))));
RDebugUtils.currentLine=35717131;
 //BA.debugLineNum = 35717131;BA.debugLine="lbl_onv5.Text=ls_onv.Get(4)";
mostCurrent._lbl_onv5.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (4))));
RDebugUtils.currentLine=35717132;
 //BA.debugLineNum = 35717132;BA.debugLine="lbl_onv6.Text=ls_onv.Get(5)";
mostCurrent._lbl_onv6.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (5))));
RDebugUtils.currentLine=35717133;
 //BA.debugLineNum = 35717133;BA.debugLine="lbl_onv7.Text=ls_onv.Get(6)";
mostCurrent._lbl_onv7.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (6))));
RDebugUtils.currentLine=35717134;
 //BA.debugLineNum = 35717134;BA.debugLine="lbl_onv8.Text=ls_onv.Get(7)";
mostCurrent._lbl_onv8.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (7))));
RDebugUtils.currentLine=35717135;
 //BA.debugLineNum = 35717135;BA.debugLine="lbl_onv9.Text=ls_onv.Get(8)";
mostCurrent._lbl_onv9.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (8))));
RDebugUtils.currentLine=35717136;
 //BA.debugLineNum = 35717136;BA.debugLine="lbl_onv10.Text=ls_onv.Get(9)";
mostCurrent._lbl_onv10.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (9))));
RDebugUtils.currentLine=35717137;
 //BA.debugLineNum = 35717137;BA.debugLine="lbl_onv11.Text=ls_onv.Get(10)";
mostCurrent._lbl_onv11.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (10))));
RDebugUtils.currentLine=35717138;
 //BA.debugLineNum = 35717138;BA.debugLine="lbl_onv12.Text=ls_onv.Get(11)";
mostCurrent._lbl_onv12.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (11))));
RDebugUtils.currentLine=35717139;
 //BA.debugLineNum = 35717139;BA.debugLine="lbl_onv13.Text=ls_onv.Get(12)";
mostCurrent._lbl_onv13.setText(BA.ObjectToCharSequence(_ls_onv.Get((int) (12))));
RDebugUtils.currentLine=35717142;
 //BA.debugLineNum = 35717142;BA.debugLine="End Sub";
return "";
}
public static String  _show_help() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_help", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_help", null));}
RDebugUtils.currentLine=34406400;
 //BA.debugLineNum = 34406400;BA.debugLine="Sub show_help";
RDebugUtils.currentLine=34406401;
 //BA.debugLineNum = 34406401;BA.debugLine="Msgbox(\"همه قیمت ها به تومان می باشد\",\"هشدار مهم\"";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("همه قیمت ها به تومان می باشد"),BA.ObjectToCharSequence("هشدار مهم"),mostCurrent.activityBA);
RDebugUtils.currentLine=34406402;
 //BA.debugLineNum = 34406402;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=34734080;
 //BA.debugLineNum = 34734080;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=34734081;
 //BA.debugLineNum = 34734081;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=34734082;
 //BA.debugLineNum = 34734082;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=34734083;
 //BA.debugLineNum = 34734083;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=34734085;
 //BA.debugLineNum = 34734085;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=34734087;
 //BA.debugLineNum = 34734087;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=34603008;
 //BA.debugLineNum = 34603008;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=34603009;
 //BA.debugLineNum = 34603009;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=34603011;
 //BA.debugLineNum = 34603011;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=34603012;
 //BA.debugLineNum = 34603012;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
RDebugUtils.currentLine=34537472;
 //BA.debugLineNum = 34537472;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=34537474;
 //BA.debugLineNum = 34537474;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=34471936;
 //BA.debugLineNum = 34471936;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=34471938;
 //BA.debugLineNum = 34471938;BA.debugLine="End Sub";
return "";
}
public static boolean  _empty_fild(anywheresoftware.b4a.objects.EditTextWrapper _et) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "empty_fild", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "empty_fild", new Object[] {_et}));}
RDebugUtils.currentLine=35651584;
 //BA.debugLineNum = 35651584;BA.debugLine="Sub empty_fild(et As EditText) As Boolean";
RDebugUtils.currentLine=35651585;
 //BA.debugLineNum = 35651585;BA.debugLine="If(et.Text.Trim=\"\")Then";
if (((_et.getText().trim()).equals(""))) { 
RDebugUtils.currentLine=35651586;
 //BA.debugLineNum = 35651586;BA.debugLine="ToastMessageShow(\"فیلد خالی است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("فیلد خالی است"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35651587;
 //BA.debugLineNum = 35651587;BA.debugLine="et.Color=0x9FFF4E4E";
_et.setColor(((int)0x9fff4e4e));
RDebugUtils.currentLine=35651588;
 //BA.debugLineNum = 35651588;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=35651590;
 //BA.debugLineNum = 35651590;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=35651591;
 //BA.debugLineNum = 35651591;BA.debugLine="End Sub";
return false;
}
public static String  _et_bime_takmil_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_bime_takmil_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_bime_takmil_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=35127296;
 //BA.debugLineNum = 35127296;BA.debugLine="Private Sub et_bime_takmil_TextChanged (Old As Str";
RDebugUtils.currentLine=35127297;
 //BA.debugLineNum = 35127297;BA.debugLine="et_bime_takmil.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_bime_takmil.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=35127298;
 //BA.debugLineNum = 35127298;BA.debugLine="myfunc.change_formater(Old,New,et_bime_takmil)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_bime_takmil);
RDebugUtils.currentLine=35127299;
 //BA.debugLineNum = 35127299;BA.debugLine="End Sub";
return "";
}
public static String  _et_bon_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_bon_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_bon_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=35192832;
 //BA.debugLineNum = 35192832;BA.debugLine="Private Sub et_bon_TextChanged (Old As String, New";
RDebugUtils.currentLine=35192833;
 //BA.debugLineNum = 35192833;BA.debugLine="et_bon.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_bon.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=35192834;
 //BA.debugLineNum = 35192834;BA.debugLine="myfunc.change_formater(Old,New,et_bon)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_bon);
RDebugUtils.currentLine=35192835;
 //BA.debugLineNum = 35192835;BA.debugLine="End Sub";
return "";
}
public static String  _et_fani_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_fani_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_fani_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=35389440;
 //BA.debugLineNum = 35389440;BA.debugLine="Private Sub et_fani_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=35389441;
 //BA.debugLineNum = 35389441;BA.debugLine="et_fani.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_fani.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=35389442;
 //BA.debugLineNum = 35389442;BA.debugLine="myfunc.change_formater(Old,New,et_fani)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_fani);
RDebugUtils.currentLine=35389443;
 //BA.debugLineNum = 35389443;BA.debugLine="End Sub";
return "";
}
public static String  _et_ksorat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_ksorat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_ksorat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=35061760;
 //BA.debugLineNum = 35061760;BA.debugLine="Private Sub et_ksorat_TextChanged (Old As String,";
RDebugUtils.currentLine=35061761;
 //BA.debugLineNum = 35061761;BA.debugLine="et_ksorat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_ksorat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=35061762;
 //BA.debugLineNum = 35061762;BA.debugLine="myfunc.change_formater(Old,New,et_ksorat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_ksorat);
RDebugUtils.currentLine=35061763;
 //BA.debugLineNum = 35061763;BA.debugLine="End Sub";
return "";
}
public static String  _et_maskan_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_maskan_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_maskan_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=35520512;
 //BA.debugLineNum = 35520512;BA.debugLine="Private Sub et_maskan_TextChanged (Old As String,";
RDebugUtils.currentLine=35520513;
 //BA.debugLineNum = 35520513;BA.debugLine="et_maskan.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_maskan.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=35520514;
 //BA.debugLineNum = 35520514;BA.debugLine="myfunc.change_formater(Old,New,et_maskan)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_maskan);
RDebugUtils.currentLine=35520515;
 //BA.debugLineNum = 35520515;BA.debugLine="End Sub";
return "";
}
public static String  _et_masoliat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_masoliat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_masoliat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=35323904;
 //BA.debugLineNum = 35323904;BA.debugLine="Private Sub et_masoliat_TextChanged (Old As String";
RDebugUtils.currentLine=35323905;
 //BA.debugLineNum = 35323905;BA.debugLine="et_masoliat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_masoliat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=35323906;
 //BA.debugLineNum = 35323906;BA.debugLine="myfunc.change_formater(Old,New,et_masoliat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_masoliat);
RDebugUtils.currentLine=35323907;
 //BA.debugLineNum = 35323907;BA.debugLine="End Sub";
return "";
}
public static String  _et_mazaya_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mazaya_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mazaya_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=34996224;
 //BA.debugLineNum = 34996224;BA.debugLine="Private Sub et_mazaya_TextChanged (Old As String,";
RDebugUtils.currentLine=34996225;
 //BA.debugLineNum = 34996225;BA.debugLine="et_mazaya.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_mazaya.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=34996226;
 //BA.debugLineNum = 34996226;BA.debugLine="myfunc.change_formater(Old,New,et_mazaya)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_mazaya);
RDebugUtils.currentLine=34996227;
 //BA.debugLineNum = 34996227;BA.debugLine="End Sub";
return "";
}
public static String  _et_olad_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_olad_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_olad_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=35454976;
 //BA.debugLineNum = 35454976;BA.debugLine="Private Sub et_olad_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=35454977;
 //BA.debugLineNum = 35454977;BA.debugLine="et_olad.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_olad.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=35454978;
 //BA.debugLineNum = 35454978;BA.debugLine="myfunc.change_formater(Old,New,et_olad)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_olad);
RDebugUtils.currentLine=35454979;
 //BA.debugLineNum = 35454979;BA.debugLine="End Sub";
return "";
}
public static String  _et_paye_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_paye_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_paye_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=34930688;
 //BA.debugLineNum = 34930688;BA.debugLine="Private Sub et_paye_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=34930689;
 //BA.debugLineNum = 34930689;BA.debugLine="et_paye.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_paye.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=34930690;
 //BA.debugLineNum = 34930690;BA.debugLine="myfunc.change_formater(Old,New,et_paye)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_paye);
RDebugUtils.currentLine=34930691;
 //BA.debugLineNum = 34930691;BA.debugLine="End Sub";
return "";
}
public static String  _et_sanavat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_sanavat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_sanavat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=35586048;
 //BA.debugLineNum = 35586048;BA.debugLine="Private Sub et_sanavat_TextChanged (Old As String,";
RDebugUtils.currentLine=35586049;
 //BA.debugLineNum = 35586049;BA.debugLine="et_sanavat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_sanavat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=35586050;
 //BA.debugLineNum = 35586050;BA.debugLine="myfunc.change_formater(Old,New,et_sanavat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_sanavat);
RDebugUtils.currentLine=35586051;
 //BA.debugLineNum = 35586051;BA.debugLine="End Sub";
return "";
}
public static String  _et_sarparast_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_sarparast_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_sarparast_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=35258368;
 //BA.debugLineNum = 35258368;BA.debugLine="Private Sub et_sarparast_TextChanged (Old As Strin";
RDebugUtils.currentLine=35258369;
 //BA.debugLineNum = 35258369;BA.debugLine="et_sarparast.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_sarparast.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=35258370;
 //BA.debugLineNum = 35258370;BA.debugLine="myfunc.change_formater(Old,New,et_sarparast)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_sarparast);
RDebugUtils.currentLine=35258371;
 //BA.debugLineNum = 35258371;BA.debugLine="End Sub";
return "";
}
public static String  _ev_onv_longclick() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ev_onv_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ev_onv_longclick", null));}
anywheresoftware.b4a.objects.LabelWrapper _this_onv = null;
RDebugUtils.currentLine=35913728;
 //BA.debugLineNum = 35913728;BA.debugLine="Private Sub EV_onv_LongClick";
RDebugUtils.currentLine=35913729;
 //BA.debugLineNum = 35913729;BA.debugLine="Dim this_onv As Label";
_this_onv = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=35913730;
 //BA.debugLineNum = 35913730;BA.debugLine="this_onv=Sender";
_this_onv = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=35913733;
 //BA.debugLineNum = 35913733;BA.debugLine="current_index_onvan=this_onv.Tag";
_current_index_onvan = (int)(BA.ObjectToNumber(_this_onv.getTag()));
RDebugUtils.currentLine=35913735;
 //BA.debugLineNum = 35913735;BA.debugLine="lbl_onv_def.Text=get_onvan_byId(this_onv.Tag).Get";
mostCurrent._lbl_onv_def.setText(BA.ObjectToCharSequence(_get_onvan_byid((int)(BA.ObjectToNumber(_this_onv.getTag()))).Get((int) (0))));
RDebugUtils.currentLine=35913736;
 //BA.debugLineNum = 35913736;BA.debugLine="et_onv_new.Text=get_onvan_byId(this_onv.Tag).Get(";
mostCurrent._et_onv_new.setText(BA.ObjectToCharSequence(_get_onvan_byid((int)(BA.ObjectToNumber(_this_onv.getTag()))).Get((int) (1))));
RDebugUtils.currentLine=35913739;
 //BA.debugLineNum = 35913739;BA.debugLine="pan_all_onvanHa.Visible=True";
mostCurrent._pan_all_onvanha.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=35913740;
 //BA.debugLineNum = 35913740;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _get_onvan_byid(int _id1) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_onvan_byid", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(mostCurrent.activityBA, "get_onvan_byid", new Object[] {_id1}));}
anywheresoftware.b4a.objects.collections.List _ls_result = null;
RDebugUtils.currentLine=36044800;
 //BA.debugLineNum = 36044800;BA.debugLine="Sub get_onvan_byId (id1 As Int) As List";
RDebugUtils.currentLine=36044801;
 //BA.debugLineNum = 36044801;BA.debugLine="Dim ls_result As List";
_ls_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=36044802;
 //BA.debugLineNum = 36044802;BA.debugLine="ls_result.Initialize";
_ls_result.Initialize();
RDebugUtils.currentLine=36044803;
 //BA.debugLineNum = 36044803;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=36044804;
 //BA.debugLineNum = 36044804;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tbl_onvanha WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=36044805;
 //BA.debugLineNum = 36044805;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=36044806;
 //BA.debugLineNum = 36044806;BA.debugLine="ls_result.Add(dbCode.res.GetString(\"def_name\"))";
_ls_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("def_name")));
RDebugUtils.currentLine=36044807;
 //BA.debugLineNum = 36044807;BA.debugLine="ls_result.Add(dbCode.res.GetString(\"custom_name\")";
_ls_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("custom_name")));
RDebugUtils.currentLine=36044808;
 //BA.debugLineNum = 36044808;BA.debugLine="Return ls_result";
if (true) return _ls_result;
RDebugUtils.currentLine=36044809;
 //BA.debugLineNum = 36044809;BA.debugLine="End Sub";
return null;
}
public static String  _lbl_help_onv_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_onv_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_onv_click", null));}
RDebugUtils.currentLine=36175872;
 //BA.debugLineNum = 36175872;BA.debugLine="Private Sub lbl_help_onv_Click";
RDebugUtils.currentLine=36175873;
 //BA.debugLineNum = 36175873;BA.debugLine="myfunc.help_man(\"راهنما\",\"با نگه داشتن انگشت روی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","با نگه داشتن انگشت روی عنوان آیتم ها میتوانید آنها را ویرایش کنید. توجه داشته باشید که عملکرد آنها در محاسبات تغییر نخواهد کرد.");
RDebugUtils.currentLine=36175874;
 //BA.debugLineNum = 36175874;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_onv_def_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_onv_def_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_onv_def_click", null));}
RDebugUtils.currentLine=36110336;
 //BA.debugLineNum = 36110336;BA.debugLine="Private Sub lbl_onv_def_Click";
RDebugUtils.currentLine=36110337;
 //BA.debugLineNum = 36110337;BA.debugLine="et_onv_new.Text=lbl_onv_def.Text";
mostCurrent._et_onv_new.setText(BA.ObjectToCharSequence(mostCurrent._lbl_onv_def.getText()));
RDebugUtils.currentLine=36110339;
 //BA.debugLineNum = 36110339;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_click", null));}
boolean _exep = false;
int _min_sat_kar = 0;
anywheresoftware.b4a.objects.collections.List _data = null;
RDebugUtils.currentLine=34668544;
 //BA.debugLineNum = 34668544;BA.debugLine="Private Sub lbl_save_Click";
RDebugUtils.currentLine=34668545;
 //BA.debugLineNum = 34668545;BA.debugLine="Dim exep As Boolean=True";
_exep = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=34668547;
 //BA.debugLineNum = 34668547;BA.debugLine="et_paye.Color=Colors.White";
mostCurrent._et_paye.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34668548;
 //BA.debugLineNum = 34668548;BA.debugLine="et_maskan.Color=Colors.White";
mostCurrent._et_maskan.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34668549;
 //BA.debugLineNum = 34668549;BA.debugLine="et_fani.Color=Colors.White";
mostCurrent._et_fani.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34668550;
 //BA.debugLineNum = 34668550;BA.debugLine="et_masoliat.Color=Colors.White";
mostCurrent._et_masoliat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34668551;
 //BA.debugLineNum = 34668551;BA.debugLine="et_olad.Color=Colors.White";
mostCurrent._et_olad.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34668552;
 //BA.debugLineNum = 34668552;BA.debugLine="et_bon.Color=Colors.White";
mostCurrent._et_bon.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34668553;
 //BA.debugLineNum = 34668553;BA.debugLine="et_bime_takmil.Color=Colors.White";
mostCurrent._et_bime_takmil.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34668556;
 //BA.debugLineNum = 34668556;BA.debugLine="et_shift.Color=Colors.White";
mostCurrent._et_shift.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34668557;
 //BA.debugLineNum = 34668557;BA.debugLine="et_sanavat.Color=Colors.White";
mostCurrent._et_sanavat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34668558;
 //BA.debugLineNum = 34668558;BA.debugLine="et_sarparast.Color=Colors.White";
mostCurrent._et_sarparast.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34668559;
 //BA.debugLineNum = 34668559;BA.debugLine="et_mazaya.Color=Colors.White";
mostCurrent._et_mazaya.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34668560;
 //BA.debugLineNum = 34668560;BA.debugLine="et_ksorat.Color=Colors.White";
mostCurrent._et_ksorat.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34668561;
 //BA.debugLineNum = 34668561;BA.debugLine="et_saat_kari.Color=Colors.White";
mostCurrent._et_saat_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34668562;
 //BA.debugLineNum = 34668562;BA.debugLine="et_min_kari.Color=Colors.White";
mostCurrent._et_min_kari.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=34668577;
 //BA.debugLineNum = 34668577;BA.debugLine="et_maliat.TextColor=Colors.Black";
mostCurrent._et_maliat.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=34668580;
 //BA.debugLineNum = 34668580;BA.debugLine="If(et_shift.Text=\"\")Then";
if (((mostCurrent._et_shift.getText()).equals(""))) { 
RDebugUtils.currentLine=34668581;
 //BA.debugLineNum = 34668581;BA.debugLine="et_shift.Text=0";
mostCurrent._et_shift.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=34668583;
 //BA.debugLineNum = 34668583;BA.debugLine="If(et_saat_kari.Text=\"\")Then";
if (((mostCurrent._et_saat_kari.getText()).equals(""))) { 
RDebugUtils.currentLine=34668584;
 //BA.debugLineNum = 34668584;BA.debugLine="et_saat_kari.Text=8";
mostCurrent._et_saat_kari.setText(BA.ObjectToCharSequence(8));
 };
RDebugUtils.currentLine=34668586;
 //BA.debugLineNum = 34668586;BA.debugLine="If(et_min_kari.Text=\"\")Then";
if (((mostCurrent._et_min_kari.getText()).equals(""))) { 
RDebugUtils.currentLine=34668587;
 //BA.debugLineNum = 34668587;BA.debugLine="et_min_kari.Text=0";
mostCurrent._et_min_kari.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=34668591;
 //BA.debugLineNum = 34668591;BA.debugLine="If(et_shift.Text>100 Or et_shift.Text<0 Or  et_sh";
if (((double)(Double.parseDouble(mostCurrent._et_shift.getText()))>100 || (double)(Double.parseDouble(mostCurrent._et_shift.getText()))<0 || (mostCurrent._et_shift.getText()).equals(""))) { 
RDebugUtils.currentLine=34668592;
 //BA.debugLineNum = 34668592;BA.debugLine="ToastMessageShow(\"خطا درصد-(0 تا 100)\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا درصد-(0 تا 100)"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34668593;
 //BA.debugLineNum = 34668593;BA.debugLine="et_shift.TextColor=Colors.Red";
mostCurrent._et_shift.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=34668594;
 //BA.debugLineNum = 34668594;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=34668596;
 //BA.debugLineNum = 34668596;BA.debugLine="et_shift.TextColor=Colors.Black";
mostCurrent._et_shift.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=34668599;
 //BA.debugLineNum = 34668599;BA.debugLine="If(et_saat_kari.Text>24 Or et_saat_kari.Text<0 )T";
if (((double)(Double.parseDouble(mostCurrent._et_saat_kari.getText()))>24 || (double)(Double.parseDouble(mostCurrent._et_saat_kari.getText()))<0)) { 
RDebugUtils.currentLine=34668600;
 //BA.debugLineNum = 34668600;BA.debugLine="ToastMessageShow(\"ساعت کاری را اصلاح نمائید\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ساعت کاری را اصلاح نمائید"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34668601;
 //BA.debugLineNum = 34668601;BA.debugLine="et_saat_kari.TextColor=Colors.Red";
mostCurrent._et_saat_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=34668602;
 //BA.debugLineNum = 34668602;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=34668604;
 //BA.debugLineNum = 34668604;BA.debugLine="et_saat_kari.TextColor=Colors.Black";
mostCurrent._et_saat_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=34668607;
 //BA.debugLineNum = 34668607;BA.debugLine="If(et_min_kari.Text>59 Or et_min_kari.Text<0 )The";
if (((double)(Double.parseDouble(mostCurrent._et_min_kari.getText()))>59 || (double)(Double.parseDouble(mostCurrent._et_min_kari.getText()))<0)) { 
RDebugUtils.currentLine=34668608;
 //BA.debugLineNum = 34668608;BA.debugLine="ToastMessageShow(\"ساعت کاری را اصلاح نمائید\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ساعت کاری را اصلاح نمائید"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34668609;
 //BA.debugLineNum = 34668609;BA.debugLine="et_min_kari.TextColor=Colors.Red";
mostCurrent._et_min_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=34668610;
 //BA.debugLineNum = 34668610;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=34668612;
 //BA.debugLineNum = 34668612;BA.debugLine="et_min_kari.TextColor=Colors.Black";
mostCurrent._et_min_kari.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=34668618;
 //BA.debugLineNum = 34668618;BA.debugLine="If(empty_fild(et_paye)=True)Then";
if ((_empty_fild(mostCurrent._et_paye)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=34668619;
 //BA.debugLineNum = 34668619;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=34668621;
 //BA.debugLineNum = 34668621;BA.debugLine="If(empty_fild(et_maskan)=True)Then";
if ((_empty_fild(mostCurrent._et_maskan)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=34668622;
 //BA.debugLineNum = 34668622;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=34668624;
 //BA.debugLineNum = 34668624;BA.debugLine="If(empty_fild(et_bon)=True)Then";
if ((_empty_fild(mostCurrent._et_bon)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=34668625;
 //BA.debugLineNum = 34668625;BA.debugLine="exep=False";
_exep = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=34668628;
 //BA.debugLineNum = 34668628;BA.debugLine="If(et_sanavat.Text=\"\")Then";
if (((mostCurrent._et_sanavat.getText()).equals(""))) { 
RDebugUtils.currentLine=34668629;
 //BA.debugLineNum = 34668629;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=34668631;
 //BA.debugLineNum = 34668631;BA.debugLine="If(et_olad.Text=\"\")Then";
if (((mostCurrent._et_olad.getText()).equals(""))) { 
RDebugUtils.currentLine=34668632;
 //BA.debugLineNum = 34668632;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=34668634;
 //BA.debugLineNum = 34668634;BA.debugLine="If(et_fani.Text=\"\")Then";
if (((mostCurrent._et_fani.getText()).equals(""))) { 
RDebugUtils.currentLine=34668635;
 //BA.debugLineNum = 34668635;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=34668637;
 //BA.debugLineNum = 34668637;BA.debugLine="If(et_masoliat.Text=\"\")Then";
if (((mostCurrent._et_masoliat.getText()).equals(""))) { 
RDebugUtils.currentLine=34668638;
 //BA.debugLineNum = 34668638;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=34668640;
 //BA.debugLineNum = 34668640;BA.debugLine="If(et_sarparast.Text=\"\")Then";
if (((mostCurrent._et_sarparast.getText()).equals(""))) { 
RDebugUtils.currentLine=34668641;
 //BA.debugLineNum = 34668641;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=34668643;
 //BA.debugLineNum = 34668643;BA.debugLine="If(et_bime_takmil.Text=\"\")Then";
if (((mostCurrent._et_bime_takmil.getText()).equals(""))) { 
RDebugUtils.currentLine=34668644;
 //BA.debugLineNum = 34668644;BA.debugLine="et_bime_takmil.Text=0";
mostCurrent._et_bime_takmil.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=34668646;
 //BA.debugLineNum = 34668646;BA.debugLine="If(et_mazaya.Text=\"\")Then";
if (((mostCurrent._et_mazaya.getText()).equals(""))) { 
RDebugUtils.currentLine=34668647;
 //BA.debugLineNum = 34668647;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=34668649;
 //BA.debugLineNum = 34668649;BA.debugLine="If(et_ksorat.Text=\"\")Then";
if (((mostCurrent._et_ksorat.getText()).equals(""))) { 
RDebugUtils.currentLine=34668650;
 //BA.debugLineNum = 34668650;BA.debugLine="et_ksorat.Text=0";
mostCurrent._et_ksorat.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=34668654;
 //BA.debugLineNum = 34668654;BA.debugLine="Dim min_sat_kar As Int=(et_saat_kari.Text*60)+et_";
_min_sat_kar = (int) (((double)(Double.parseDouble(mostCurrent._et_saat_kari.getText()))*60)+(double)(Double.parseDouble(mostCurrent._et_min_kari.getText())));
RDebugUtils.currentLine=34668656;
 //BA.debugLineNum = 34668656;BA.debugLine="If(exep=True)Then";
if ((_exep==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=34668657;
 //BA.debugLineNum = 34668657;BA.debugLine="Dim data As List";
_data = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=34668658;
 //BA.debugLineNum = 34668658;BA.debugLine="data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=34668659;
 //BA.debugLineNum = 34668659;BA.debugLine="data.AddAll(Array As String(et_paye.Tag,et_maska";
_data.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{BA.ObjectToString(mostCurrent._et_paye.getTag()),BA.ObjectToString(mostCurrent._et_maskan.getTag()),BA.ObjectToString(mostCurrent._et_olad.getTag()),BA.ObjectToString(mostCurrent._et_fani.getTag()),BA.ObjectToString(mostCurrent._et_masoliat.getTag()),BA.ObjectToString(mostCurrent._et_bon.getTag()),mostCurrent._et_bime_tamin.getText(),BA.ObjectToString(mostCurrent._et_bime_takmil.getTag()),BA.NumberToString(10),mostCurrent._et_shift.getText(),BA.ObjectToString(mostCurrent._et_sanavat.getTag()),BA.ObjectToString(mostCurrent._et_sarparast.getTag()),BA.ObjectToString(mostCurrent._et_mazaya.getTag()),mostCurrent._sp_olad.getSelectedItem(),BA.ObjectToString(mostCurrent._et_ksorat.getTag()),BA.NumberToString(_min_sat_kar)}));
RDebugUtils.currentLine=34668662;
 //BA.debugLineNum = 34668662;BA.debugLine="If (dbCode.add_setting_hogog(data)) Then";
if ((mostCurrent._dbcode._add_setting_hogog /*boolean*/ (mostCurrent.activityBA,_data))) { 
RDebugUtils.currentLine=34668663;
 //BA.debugLineNum = 34668663;BA.debugLine="ToastMessageShow (\"ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34668665;
 //BA.debugLineNum = 34668665;BA.debugLine="Main.saat_kar_min=min_sat_kar";
mostCurrent._main._saat_kar_min /*int*/  = _min_sat_kar;
RDebugUtils.currentLine=34668666;
 //BA.debugLineNum = 34668666;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 };
RDebugUtils.currentLine=34668673;
 //BA.debugLineNum = 34668673;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_onvan_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_onvan_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_onvan_click", null));}
RDebugUtils.currentLine=35979264;
 //BA.debugLineNum = 35979264;BA.debugLine="Private Sub lbl_save_onvan_Click";
RDebugUtils.currentLine=35979265;
 //BA.debugLineNum = 35979265;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=35979266;
 //BA.debugLineNum = 35979266;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tbl_onvanha SET '";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tbl_onvanha SET 'custom_name' ='"+mostCurrent._et_onv_new.getText()+"'  WHERE id="+BA.NumberToString(_current_index_onvan));
RDebugUtils.currentLine=35979268;
 //BA.debugLineNum = 35979268;BA.debugLine="read_onvan";
_read_onvan();
RDebugUtils.currentLine=35979269;
 //BA.debugLineNum = 35979269;BA.debugLine="pan_all_onvanHa.Visible=False";
mostCurrent._pan_all_onvanha.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35979270;
 //BA.debugLineNum = 35979270;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_onvanha_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_onvanha_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_onvanha_click", null));}
RDebugUtils.currentLine=35782656;
 //BA.debugLineNum = 35782656;BA.debugLine="Private Sub pan_all_onvanHa_Click";
RDebugUtils.currentLine=35782658;
 //BA.debugLineNum = 35782658;BA.debugLine="pan_all_onvanHa.Visible=False";
mostCurrent._pan_all_onvanha.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35782659;
 //BA.debugLineNum = 35782659;BA.debugLine="End Sub";
return "";
}
public static String  _panel15_click() throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel15_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel15_click", null));}
RDebugUtils.currentLine=35848192;
 //BA.debugLineNum = 35848192;BA.debugLine="Private Sub Panel15_Click";
RDebugUtils.currentLine=35848194;
 //BA.debugLineNum = 35848194;BA.debugLine="End Sub";
return "";
}
public static String  _sp_ganon_kar_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_ganon_kar_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_ganon_kar_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=34799616;
 //BA.debugLineNum = 34799616;BA.debugLine="Private Sub sp_ganon_kar_ItemClick (Position As In";
RDebugUtils.currentLine=34799619;
 //BA.debugLineNum = 34799619;BA.debugLine="Select Value";
switch (BA.switchObjectToInt(_value,(Object)("سال 1401"),(Object)("سال 1400"),(Object)("سال 1399"))) {
case 0: {
RDebugUtils.currentLine=34799622;
 //BA.debugLineNum = 34799622;BA.debugLine="et_paye.Text=4179755";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(4179755));
RDebugUtils.currentLine=34799623;
 //BA.debugLineNum = 34799623;BA.debugLine="et_maskan.Text=650000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(650000));
RDebugUtils.currentLine=34799624;
 //BA.debugLineNum = 34799624;BA.debugLine="et_bon.Text=850000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(850000));
RDebugUtils.currentLine=34799625;
 //BA.debugLineNum = 34799625;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=34799628;
 //BA.debugLineNum = 34799628;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=34799629;
 //BA.debugLineNum = 34799629;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=34799630;
 //BA.debugLineNum = 34799630;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=34799631;
 //BA.debugLineNum = 34799631;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=34799634;
 //BA.debugLineNum = 34799634;BA.debugLine="olad_vahed=417975";
_olad_vahed = (int) (417975);
RDebugUtils.currentLine=34799635;
 //BA.debugLineNum = 34799635;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=34799639;
 //BA.debugLineNum = 34799639;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
case 1: {
RDebugUtils.currentLine=34799642;
 //BA.debugLineNum = 34799642;BA.debugLine="et_paye.Text=2655492";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(2655492));
RDebugUtils.currentLine=34799643;
 //BA.debugLineNum = 34799643;BA.debugLine="et_maskan.Text=450000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(450000));
RDebugUtils.currentLine=34799644;
 //BA.debugLineNum = 34799644;BA.debugLine="et_bon.Text=600000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(600000));
RDebugUtils.currentLine=34799645;
 //BA.debugLineNum = 34799645;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=34799648;
 //BA.debugLineNum = 34799648;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=34799649;
 //BA.debugLineNum = 34799649;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=34799650;
 //BA.debugLineNum = 34799650;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=34799651;
 //BA.debugLineNum = 34799651;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=34799654;
 //BA.debugLineNum = 34799654;BA.debugLine="olad_vahed=265549";
_olad_vahed = (int) (265549);
RDebugUtils.currentLine=34799655;
 //BA.debugLineNum = 34799655;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=34799659;
 //BA.debugLineNum = 34799659;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
case 2: {
RDebugUtils.currentLine=34799662;
 //BA.debugLineNum = 34799662;BA.debugLine="et_paye.Text=1910427";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(1910427));
RDebugUtils.currentLine=34799663;
 //BA.debugLineNum = 34799663;BA.debugLine="et_maskan.Text=300000";
mostCurrent._et_maskan.setText(BA.ObjectToCharSequence(300000));
RDebugUtils.currentLine=34799664;
 //BA.debugLineNum = 34799664;BA.debugLine="et_bon.Text=400000";
mostCurrent._et_bon.setText(BA.ObjectToCharSequence(400000));
RDebugUtils.currentLine=34799665;
 //BA.debugLineNum = 34799665;BA.debugLine="et_bime_tamin.Text=7";
mostCurrent._et_bime_tamin.setText(BA.ObjectToCharSequence(7));
RDebugUtils.currentLine=34799668;
 //BA.debugLineNum = 34799668;BA.debugLine="et_fani.Text=0";
mostCurrent._et_fani.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=34799669;
 //BA.debugLineNum = 34799669;BA.debugLine="et_masoliat.Text=0";
mostCurrent._et_masoliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=34799670;
 //BA.debugLineNum = 34799670;BA.debugLine="et_sarparast.Text=0";
mostCurrent._et_sarparast.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=34799671;
 //BA.debugLineNum = 34799671;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=34799674;
 //BA.debugLineNum = 34799674;BA.debugLine="olad_vahed=191127";
_olad_vahed = (int) (191127);
RDebugUtils.currentLine=34799675;
 //BA.debugLineNum = 34799675;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=34799679;
 //BA.debugLineNum = 34799679;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 break; }
default: {
RDebugUtils.currentLine=34799682;
 //BA.debugLineNum = 34799682;BA.debugLine="sp_ganon_kar.Clear";
mostCurrent._sp_ganon_kar.Clear();
RDebugUtils.currentLine=34799683;
 //BA.debugLineNum = 34799683;BA.debugLine="Activity_Create(False)";
_activity_create(anywheresoftware.b4a.keywords.Common.False);
 break; }
}
;
RDebugUtils.currentLine=34799687;
 //BA.debugLineNum = 34799687;BA.debugLine="End Sub";
return "";
}
public static String  _sp_olad_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="setting_hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_olad_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_olad_itemclick", new Object[] {_position,_value}));}
int _num = 0;
RDebugUtils.currentLine=34865152;
 //BA.debugLineNum = 34865152;BA.debugLine="Private Sub sp_olad_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=34865153;
 //BA.debugLineNum = 34865153;BA.debugLine="Dim num As Int=Value";
_num = (int)(BA.ObjectToNumber(_value));
RDebugUtils.currentLine=34865154;
 //BA.debugLineNum = 34865154;BA.debugLine="et_olad.Text=olad_vahed*num";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(_olad_vahed*_num));
RDebugUtils.currentLine=34865155;
 //BA.debugLineNum = 34865155;BA.debugLine="End Sub";
return "";
}
}