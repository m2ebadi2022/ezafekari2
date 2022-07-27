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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4a.example.dateutils._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (step0_activity.mostCurrent != null);
vis = vis | (step1_activity.mostCurrent != null);
vis = vis | (step2_activity.mostCurrent != null);
vis = vis | (bime_activity.mostCurrent != null);
vis = vis | (calc_activity.mostCurrent != null);
vis = vis | (comment_activity.mostCurrent != null);
vis = vis | (darsad_activity.mostCurrent != null);
vis = vis | (eidi_activity.mostCurrent != null);
vis = vis | (fast_run_activity.mostCurrent != null);
vis = vis | (ganon_activity.mostCurrent != null);
vis = vis | (hogog_activity.mostCurrent != null);
vis = vis | (info_activity.mostCurrent != null);
vis = vis | (morakhasi_activity.mostCurrent != null);
vis = vis | (payankar_activity.mostCurrent != null);
vis = vis | (setting_activity.mostCurrent != null);
vis = vis | (setting_hogog_activity.mostCurrent != null);
vis = vis | (shift_activity.mostCurrent != null);
vis = vis | (show_gozaresh_activity.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (step0_activity.previousOne != null) {
				__a = step0_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(step0_activity.mostCurrent == null ? null : step0_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (step1_activity.previousOne != null) {
				__a = step1_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(step1_activity.mostCurrent == null ? null : step1_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (step2_activity.previousOne != null) {
				__a = step2_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(step2_activity.mostCurrent == null ? null : step2_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (bime_activity.previousOne != null) {
				__a = bime_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(bime_activity.mostCurrent == null ? null : bime_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (calc_activity.previousOne != null) {
				__a = calc_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(calc_activity.mostCurrent == null ? null : calc_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (comment_activity.previousOne != null) {
				__a = comment_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(comment_activity.mostCurrent == null ? null : comment_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (darsad_activity.previousOne != null) {
				__a = darsad_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(darsad_activity.mostCurrent == null ? null : darsad_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (eidi_activity.previousOne != null) {
				__a = eidi_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(eidi_activity.mostCurrent == null ? null : eidi_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (fast_run_activity.previousOne != null) {
				__a = fast_run_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(fast_run_activity.mostCurrent == null ? null : fast_run_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (ganon_activity.previousOne != null) {
				__a = ganon_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(ganon_activity.mostCurrent == null ? null : ganon_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (hogog_activity.previousOne != null) {
				__a = hogog_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(hogog_activity.mostCurrent == null ? null : hogog_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (info_activity.previousOne != null) {
				__a = info_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(info_activity.mostCurrent == null ? null : info_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (morakhasi_activity.previousOne != null) {
				__a = morakhasi_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(morakhasi_activity.mostCurrent == null ? null : morakhasi_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (payankar_activity.previousOne != null) {
				__a = payankar_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(payankar_activity.mostCurrent == null ? null : payankar_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (setting_activity.previousOne != null) {
				__a = setting_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(setting_activity.mostCurrent == null ? null : setting_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (setting_hogog_activity.previousOne != null) {
				__a = setting_hogog_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(setting_hogog_activity.mostCurrent == null ? null : setting_hogog_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (shift_activity.previousOne != null) {
				__a = shift_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(shift_activity.mostCurrent == null ? null : shift_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (show_gozaresh_activity.previousOne != null) {
				__a = show_gozaresh_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(show_gozaresh_activity.mostCurrent == null ? null : show_gozaresh_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, httputils2service.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static String _app_vesion = "";
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.objects.Timer _timer1 = null;
public static anywheresoftware.b4a.objects.Timer _tim_msg = null;
public static anywheresoftware.b4a.objects.Timer _tim_lock_lbl = null;
public static int _current_gozaresh_id = 0;
public static com.b4a.manamsoftware.PersianDate.ManamPersianDate _persiandate = null;
public static String _year_num = "";
public static String _moon_num = "";
public static anywheresoftware.b4a.phone.Phone _phon = null;
public static int _buy_index = 0;
public static anywheresoftware.b4a.objects.Timer _time_page_load = null;
public static int _color_index = 0;
public static int _color1 = 0;
public static int _color2 = 0;
public static int _color3 = 0;
public static int _color4 = 0;
public static int _color5 = 0;
public static String _main_font = "";
public static int _size_f1 = 0;
public static int _size_f2 = 0;
public static int _size_f3 = 0;
public static int _saat_kar_min = 0;
public static String _phon_num = "";
public static String _user_namefamili = "";
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date_home = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_box_title = null;
public static int _index_box = 0;
public static int _year_bt = 0;
public static int _moon_bt = 0;
public static int _day_bt = 0;
public static int _hour_bt = 0;
public static int _min_bt = 0;
public static int _num = 0;
public anywheresoftware.b4a.objects.collections.List _moon = null;
public static String _date1 = "";
public static String _date2 = "";
public anywheresoftware.b4a.objects.collections.List _list_ezafekari_id = null;
public anywheresoftware.b4a.objects.collections.List _list_morakhasi_id = null;
public anywheresoftware.b4a.objects.collections.List _list_taradod_id = null;
public anywheresoftware.b4a.objects.collections.List _list_gozareshat_id = null;
public static int _curent_tab_list = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pan_main = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_imag = null;
public anywheresoftware.b4a.objects.TabHostWrapper _tabhost1 = null;
public anywheresoftware.b4a.objects.drawable.BitmapDrawable _img1 = null;
public anywheresoftware.b4a.objects.drawable.BitmapDrawable _img2 = null;
public anywheresoftware.b4a.objects.drawable.BitmapDrawable _img3 = null;
public static int _index_page = 0;
public static int _index_piker = 0;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_time_show = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_min1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_hour1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_day1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_year1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_moon1 = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _sp_moon = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _sp_year = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_tozihat = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scv_home_item = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_tim1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_tim2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_picker = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all2 = null;
public adr.stringfunctions.stringfunctions _strfun = null;
public b4a.example3.customlistview _cust_lv_ezafekari = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date_clv = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_time_clv = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_hour_clv = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_tozih_clv = null;
public b4a.example3.customlistview _cust_lv_morakhasi = null;
public b4a.example3.customlistview _clv_gozaresh = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_dategozaresh_clv = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_namegozaresh_clv = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_tozihgozaresh_clv = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_ezafekari_mah_m = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_ezafekari_mah_h = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_morakhasi_mah_m = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_morakhasi_mah_h = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_morakhasi_mah_d = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
public static String _key = "";
public anywheresoftware.b4a.inappbilling3.BillingManager3 _inapp = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_vip = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _img_help = null;
public static int _index_x_start_swap = 0;
public static int _index_curent_img = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pan_help = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_remove_from_list = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_remove_from_list2 = null;
public ir.taravatgroup.ezafekari2.b4xloadingindicator _cv_loader = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_vip2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_show_vip = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_vip_now = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_noskhe = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_min_bala1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_hour_bala1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_min_paeen1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_hour_paeen1 = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scroll_v_noskhe = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bit_img0 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bit_img1 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bit_img2 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bit_img3 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bit_img4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_close_help = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_time_as = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_time_ta = null;
public b4a.example3.customlistview _cust_lv_taradod = null;
public ir.taravatgroup.ezafekari2.httpjob _ht = null;
public static String _msg = "";
public anywheresoftware.b4a.objects.PanelWrapper _pan_notifi_all = null;
public anywheresoftware.b4a.objects.WebViewWrapper _web_msg_show = null;
public anywheresoftware.b4a.objects.collections.List _ls1 = null;
public anywheresoftware.b4a.objects.collections.List _ls2 = null;
public anywheresoftware.b4a.objects.collections.List _ls3 = null;
public static String _last_notif = "";
public static boolean _is_now_instal = false;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_title_msgpan = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_notif = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _ckb_ezaf_taradod = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_ezaf_taradod = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_ezaf_taradod = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_list = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_gozaresh = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_msgnewyear = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_majmoe_saat = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_litemenu = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_shift_home = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _sp_year_gozaresh = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_item_gozaresh = null;
public com.rootsoft.rspopupmenu.RSPopupMenu _rspop_noe = null;
public static int _index_noe_morakhasi = 0;
public static String _str_noe = "";
public anywheresoftware.b4a.objects.LabelWrapper _lbl_edit_from_list = null;
public static int _current_id_edit = 0;
public static boolean _is_for_edit = false;
public static int _tim_min = 0;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_vesion_app = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date_ft = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_vorod_ft = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_khoroj_ft = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_time_show_ft = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_tim_khoroj_ft = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_tim_vorod_ft = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _ckb_ezaf_taradod_ft = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_ft = null;
public static int _code_fast_taradod = 0;
public anywheresoftware.b4a.objects.EditTextWrapper _et_tozihat_ft = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btneight = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnfive = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnfour = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnnine = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnone = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnseven = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsix = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnthree = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btntwo = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnzero = null;
public anywheresoftware.b4a.objects.PanelWrapper _key1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _key2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _key3 = null;
public anywheresoftware.b4a.objects.PanelWrapper _key4 = null;
public static int _click_count = 0;
public static String _master_password = "";
public static String _entered_password = "";
public ir.taravatgroup.ezafekari2.fingerprintmanager _fingerprint = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_finger = null;
public static int _stat_finger = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pan_lock = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_hint_lock = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_chekupdate = null;
public anywheresoftware.b4a.objects.WebViewWrapper _webveiw_chk_update = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_chk_update_ok = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_day_clv = null;
public b4a.example.dateutils _dateutils = null;
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
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.collections.List _ls_user = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="Try";
try {RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="inapp.Initialize(\"inapp\",key)";
mostCurrent._inapp.Initialize(processBA,"inapp",mostCurrent._key);
 } 
       catch (Exception e4) {
			processBA.setLastException(e4);RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("7131079",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="dbCode.init_notfound(\"ksorat\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"ksorat",BA.NumberToString(0));
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="dbCode.init_notfound(\"morakhasi_mande_d\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_mande_d",BA.NumberToString(0));
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="dbCode.init_notfound(\"morakhasi_mande_h\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_mande_h",BA.NumberToString(0));
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="dbCode.init_notfound(\"morakhasi_mande_m\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_mande_m",BA.NumberToString(0));
RDebugUtils.currentLine=131090;
 //BA.debugLineNum = 131090;BA.debugLine="dbCode.init_notfound(\"morakhasi_darMah_d\",2)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_darMah_d",BA.NumberToString(2));
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="dbCode.init_notfound(\"morakhasi_darMah_h\",4)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_darMah_h",BA.NumberToString(4));
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="dbCode.init_notfound(\"morakhasi_darMah_m\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_darMah_m",BA.NumberToString(0));
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="dbCode.init_notfound(\"saat_kar_darRoz\",480)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"saat_kar_darRoz",BA.NumberToString(480));
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="dbCode.install_db_tbl_taradod";
mostCurrent._dbcode._install_db_tbl_taradod /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="dbCode.install_db_tbl_myCalander";
mostCurrent._dbcode._install_db_tbl_mycalander /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=131100;
 //BA.debugLineNum = 131100;BA.debugLine="dbCode.cheng_tagvim";
mostCurrent._dbcode._cheng_tagvim /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="dbCode.install_db_tbl_onvanha";
mostCurrent._dbcode._install_db_tbl_onvanha /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=131105;
 //BA.debugLineNum = 131105;BA.debugLine="img1.Initialize(LoadBitmap(File.DirAssets,\"m1.png";
mostCurrent._img1.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m1.png").getObject()));
RDebugUtils.currentLine=131106;
 //BA.debugLineNum = 131106;BA.debugLine="img1.Gravity=Gravity.FILL";
mostCurrent._img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=131108;
 //BA.debugLineNum = 131108;BA.debugLine="img2.Initialize(LoadBitmap(File.DirAssets,\"m2.png";
mostCurrent._img2.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m2.png").getObject()));
RDebugUtils.currentLine=131109;
 //BA.debugLineNum = 131109;BA.debugLine="img2.Gravity=Gravity.FILL";
mostCurrent._img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=131111;
 //BA.debugLineNum = 131111;BA.debugLine="img3.Initialize(LoadBitmap(File.DirAssets,\"m3.png";
mostCurrent._img3.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m3.png").getObject()));
RDebugUtils.currentLine=131112;
 //BA.debugLineNum = 131112;BA.debugLine="img3.Gravity=Gravity.FILL";
mostCurrent._img3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=131114;
 //BA.debugLineNum = 131114;BA.debugLine="If(FirstTime)Then";
if ((_firsttime)) { 
RDebugUtils.currentLine=131115;
 //BA.debugLineNum = 131115;BA.debugLine="Activity.LoadLayout(\"splash_layout\")";
mostCurrent._activity.LoadLayout("splash_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131116;
 //BA.debugLineNum = 131116;BA.debugLine="lbl_vesion_app.Text=app_vesion";
mostCurrent._lbl_vesion_app.setText(BA.ObjectToCharSequence(_app_vesion));
RDebugUtils.currentLine=131117;
 //BA.debugLineNum = 131117;BA.debugLine="cv_loader.Show";
mostCurrent._cv_loader._show /*String*/ (null);
RDebugUtils.currentLine=131118;
 //BA.debugLineNum = 131118;BA.debugLine="timer1.Initialize(\"timer1\" , 1500)";
_timer1.Initialize(processBA,"timer1",(long) (1500));
RDebugUtils.currentLine=131120;
 //BA.debugLineNum = 131120;BA.debugLine="timer1.Enabled=True";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=131122;
 //BA.debugLineNum = 131122;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131123;
 //BA.debugLineNum = 131123;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
RDebugUtils.currentLine=131127;
 //BA.debugLineNum = 131127;BA.debugLine="moon.Initialize";
mostCurrent._moon.Initialize();
RDebugUtils.currentLine=131128;
 //BA.debugLineNum = 131128;BA.debugLine="moon.AddAll(Array As String(\"فروردین\", \"اردیبهشت\"";
mostCurrent._moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=131131;
 //BA.debugLineNum = 131131;BA.debugLine="strfun.Initialize";
mostCurrent._strfun._initialize(processBA);
RDebugUtils.currentLine=131135;
 //BA.debugLineNum = 131135;BA.debugLine="If(buy_index=1)Then";
if ((_buy_index==1)) { 
RDebugUtils.currentLine=131136;
 //BA.debugLineNum = 131136;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
RDebugUtils.currentLine=131137;
 //BA.debugLineNum = 131137;BA.debugLine="buy_index=0";
_buy_index = (int) (0);
 };
RDebugUtils.currentLine=131143;
 //BA.debugLineNum = 131143;BA.debugLine="tim_msg.Initialize(\"tim_msg\",4000)";
_tim_msg.Initialize(processBA,"tim_msg",(long) (4000));
RDebugUtils.currentLine=131145;
 //BA.debugLineNum = 131145;BA.debugLine="ls1.Initialize";
mostCurrent._ls1.Initialize();
RDebugUtils.currentLine=131146;
 //BA.debugLineNum = 131146;BA.debugLine="ls2.Initialize";
mostCurrent._ls2.Initialize();
RDebugUtils.currentLine=131147;
 //BA.debugLineNum = 131147;BA.debugLine="ls3.Initialize";
mostCurrent._ls3.Initialize();
RDebugUtils.currentLine=131150;
 //BA.debugLineNum = 131150;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1"))) { 
RDebugUtils.currentLine=131151;
 //BA.debugLineNum = 131151;BA.debugLine="ls1=File.ReadList(File.DirInternal,\"ls1\")";
mostCurrent._ls1 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1");
RDebugUtils.currentLine=131152;
 //BA.debugLineNum = 131152;BA.debugLine="ls2=File.ReadList(File.DirInternal,\"ls2\")";
mostCurrent._ls2 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls2");
RDebugUtils.currentLine=131153;
 //BA.debugLineNum = 131153;BA.debugLine="ls3=File.ReadList(File.DirInternal,\"ls3\")";
mostCurrent._ls3 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls3");
RDebugUtils.currentLine=131155;
 //BA.debugLineNum = 131155;BA.debugLine="last_notif=ls1.Get(ls1.Size-1)";
mostCurrent._last_notif = BA.ObjectToString(mostCurrent._ls1.Get((int) (mostCurrent._ls1.getSize()-1)));
RDebugUtils.currentLine=131156;
 //BA.debugLineNum = 131156;BA.debugLine="is_now_instal=False";
_is_now_instal = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=131164;
 //BA.debugLineNum = 131164;BA.debugLine="If(myfunc.check_karid=True)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=131165;
 //BA.debugLineNum = 131165;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
 }else {
RDebugUtils.currentLine=131167;
 //BA.debugLineNum = 131167;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
 };
RDebugUtils.currentLine=131185;
 //BA.debugLineNum = 131185;BA.debugLine="If(File.Exists(File.DirInternal,\"phonNum\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum"))) { 
RDebugUtils.currentLine=131186;
 //BA.debugLineNum = 131186;BA.debugLine="phon_num=File.ReadString(File.DirInternal,\"phonN";
_phon_num = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum");
 };
RDebugUtils.currentLine=131189;
 //BA.debugLineNum = 131189;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc"))) { 
RDebugUtils.currentLine=131190;
 //BA.debugLineNum = 131190;BA.debugLine="Dim ls_user As List";
_ls_user = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=131191;
 //BA.debugLineNum = 131191;BA.debugLine="ls_user.Initialize";
_ls_user.Initialize();
RDebugUtils.currentLine=131192;
 //BA.debugLineNum = 131192;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAcc\"";
_ls_user = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
RDebugUtils.currentLine=131193;
 //BA.debugLineNum = 131193;BA.debugLine="user_nameFamili=ls_user.Get(0)";
_user_namefamili = BA.ObjectToString(_ls_user.Get((int) (0)));
 };
RDebugUtils.currentLine=131198;
 //BA.debugLineNum = 131198;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_home_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_menu_home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_menu_home_click", null));}
anywheresoftware.b4a.objects.collections.List _list_ezafekari = null;
anywheresoftware.b4a.objects.collections.List _list_morakhasi = null;
anywheresoftware.b4a.objects.collections.List _list_color = null;
anywheresoftware.b4a.objects.collections.List _col = null;
anywheresoftware.b4a.objects.collections.List _col_font = null;
anywheresoftware.b4a.objects.drawable.GradientDrawable _dw = null;
int[] _clr = null;
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Private Sub btn_menu_home_Click";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="index_page=1";
_index_page = (int) (1);
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="pan_imag.Background=img1";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img1.getObject()));
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="pan_main.LoadLayout(\"home_layout\")";
mostCurrent._pan_main.LoadLayout("home_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="scv_home_item.Panel.LoadLayout(\"home_item\")";
mostCurrent._scv_home_item.getPanel().LoadLayout("home_item",mostCurrent.activityBA);
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="lbl_date_home.Text=myfunc.fa2en(persianDate.Persi";
mostCurrent._lbl_date_home.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianLongDate())));
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="saat_kar_min =dbCode.get_setting_byName(\"saat_kar";
_saat_kar_min = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_darRoz")));
RDebugUtils.currentLine=2031627;
 //BA.debugLineNum = 2031627;BA.debugLine="If(saat_kar_min<18)Then";
if ((_saat_kar_min<18)) { 
RDebugUtils.currentLine=2031628;
 //BA.debugLineNum = 2031628;BA.debugLine="myfunc.help_man(\"توجه\",\"لطفا ساعت کاری خود را تن";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","لطفا ساعت کاری خود را تنظیم کنید");
 };
RDebugUtils.currentLine=2031631;
 //BA.debugLineNum = 2031631;BA.debugLine="Dim list_ezafekari As List";
_list_ezafekari = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2031632;
 //BA.debugLineNum = 2031632;BA.debugLine="list_ezafekari.Initialize";
_list_ezafekari.Initialize();
RDebugUtils.currentLine=2031634;
 //BA.debugLineNum = 2031634;BA.debugLine="year_num=myfunc.fa2en(persianDate.PersianYear)";
_year_num = mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()));
RDebugUtils.currentLine=2031636;
 //BA.debugLineNum = 2031636;BA.debugLine="Select persianDate.PersianMonth";
switch (BA.switchObjectToInt(_persiandate.getPersianMonth(),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11),(int) (12))) {
case 0: {
RDebugUtils.currentLine=2031638;
 //BA.debugLineNum = 2031638;BA.debugLine="moon_num=\"01\"";
_moon_num = "01";
 break; }
case 1: {
RDebugUtils.currentLine=2031640;
 //BA.debugLineNum = 2031640;BA.debugLine="moon_num=\"02\"";
_moon_num = "02";
 break; }
case 2: {
RDebugUtils.currentLine=2031642;
 //BA.debugLineNum = 2031642;BA.debugLine="moon_num=\"03\"";
_moon_num = "03";
 break; }
case 3: {
RDebugUtils.currentLine=2031644;
 //BA.debugLineNum = 2031644;BA.debugLine="moon_num=\"04\"";
_moon_num = "04";
 break; }
case 4: {
RDebugUtils.currentLine=2031646;
 //BA.debugLineNum = 2031646;BA.debugLine="moon_num=\"05\"";
_moon_num = "05";
 break; }
case 5: {
RDebugUtils.currentLine=2031648;
 //BA.debugLineNum = 2031648;BA.debugLine="moon_num=\"06\"";
_moon_num = "06";
 break; }
case 6: {
RDebugUtils.currentLine=2031650;
 //BA.debugLineNum = 2031650;BA.debugLine="moon_num=\"07\"";
_moon_num = "07";
 break; }
case 7: {
RDebugUtils.currentLine=2031652;
 //BA.debugLineNum = 2031652;BA.debugLine="moon_num=\"08\"";
_moon_num = "08";
 break; }
case 8: {
RDebugUtils.currentLine=2031654;
 //BA.debugLineNum = 2031654;BA.debugLine="moon_num=\"09\"";
_moon_num = "09";
 break; }
case 9: {
RDebugUtils.currentLine=2031656;
 //BA.debugLineNum = 2031656;BA.debugLine="moon_num=\"10\"";
_moon_num = "10";
 break; }
case 10: {
RDebugUtils.currentLine=2031658;
 //BA.debugLineNum = 2031658;BA.debugLine="moon_num=\"11\"";
_moon_num = "11";
 break; }
case 11: {
RDebugUtils.currentLine=2031660;
 //BA.debugLineNum = 2031660;BA.debugLine="moon_num=\"12\"";
_moon_num = "12";
 break; }
}
;
RDebugUtils.currentLine=2031662;
 //BA.debugLineNum = 2031662;BA.debugLine="list_ezafekari=dbCode.all_ezafekari_mah(year_num,";
_list_ezafekari = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num,(int) (1));
RDebugUtils.currentLine=2031668;
 //BA.debugLineNum = 2031668;BA.debugLine="Dim list_morakhasi As List";
_list_morakhasi = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2031669;
 //BA.debugLineNum = 2031669;BA.debugLine="list_morakhasi.Initialize";
_list_morakhasi.Initialize();
RDebugUtils.currentLine=2031671;
 //BA.debugLineNum = 2031671;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(year_num,";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num);
RDebugUtils.currentLine=2031674;
 //BA.debugLineNum = 2031674;BA.debugLine="lbl_ezafekari_mah_m.Text=list_ezafekari.Get(1)&\"";
mostCurrent._lbl_ezafekari_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (1)))+" دقیقه "));
RDebugUtils.currentLine=2031675;
 //BA.debugLineNum = 2031675;BA.debugLine="lbl_ezafekari_mah_h.Text=list_ezafekari.Get(0)&\"";
mostCurrent._lbl_ezafekari_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (0)))+" ساعت "));
RDebugUtils.currentLine=2031677;
 //BA.debugLineNum = 2031677;BA.debugLine="lbl_morakhasi_mah_m.Text=list_morakhasi.Get(2)&\"";
mostCurrent._lbl_morakhasi_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (2)))+" دقیقه "));
RDebugUtils.currentLine=2031678;
 //BA.debugLineNum = 2031678;BA.debugLine="lbl_morakhasi_mah_h.Text=list_morakhasi.Get(1)&\"";
mostCurrent._lbl_morakhasi_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (1)))+" ساعت "));
RDebugUtils.currentLine=2031679;
 //BA.debugLineNum = 2031679;BA.debugLine="lbl_morakhasi_mah_d.Text=list_morakhasi.Get(0)&\"";
mostCurrent._lbl_morakhasi_mah_d.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (0)))+" روز "));
RDebugUtils.currentLine=2031681;
 //BA.debugLineNum = 2031681;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=2031683;
 //BA.debugLineNum = 2031683;BA.debugLine="lbl_vip.TextColor=0xFFFFD800";
mostCurrent._lbl_vip.setTextColor(((int)0xffffd800));
RDebugUtils.currentLine=2031684;
 //BA.debugLineNum = 2031684;BA.debugLine="lbl_vip2.Text=\"نسخه طلایی\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه طلایی"));
 }else {
RDebugUtils.currentLine=2031687;
 //BA.debugLineNum = 2031687;BA.debugLine="lbl_vip.TextColor=Colors.Green";
mostCurrent._lbl_vip.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=2031688;
 //BA.debugLineNum = 2031688;BA.debugLine="lbl_vip2.Text=\"نسخه هدیه\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه هدیه"));
 };
RDebugUtils.currentLine=2031693;
 //BA.debugLineNum = 2031693;BA.debugLine="If (File.Exists(File.DirInternal,\"help_start\")=Fa";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=2031694;
 //BA.debugLineNum = 2031694;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=2031695;
 //BA.debugLineNum = 2031695;BA.debugLine="File.WriteString(File.DirInternal,\"help_start\",\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start","");
 };
RDebugUtils.currentLine=2031701;
 //BA.debugLineNum = 2031701;BA.debugLine="If (File.Exists(File.DirInternal,\"setcolor.txt\"))";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt"))) { 
RDebugUtils.currentLine=2031702;
 //BA.debugLineNum = 2031702;BA.debugLine="Dim list_color As List";
_list_color = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2031703;
 //BA.debugLineNum = 2031703;BA.debugLine="list_color.Initialize";
_list_color.Initialize();
RDebugUtils.currentLine=2031704;
 //BA.debugLineNum = 2031704;BA.debugLine="list_color = File.ReadList(File.DirInternal,\"set";
_list_color = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt");
RDebugUtils.currentLine=2031706;
 //BA.debugLineNum = 2031706;BA.debugLine="Dim col As List";
_col = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2031707;
 //BA.debugLineNum = 2031707;BA.debugLine="col.Initialize";
_col.Initialize();
RDebugUtils.currentLine=2031709;
 //BA.debugLineNum = 2031709;BA.debugLine="Dim col_font As List";
_col_font = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2031710;
 //BA.debugLineNum = 2031710;BA.debugLine="col_font.Initialize";
_col_font.Initialize();
RDebugUtils.currentLine=2031712;
 //BA.debugLineNum = 2031712;BA.debugLine="col=Regex.Split(\",\",list_color.Get(0))";
_col = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (0)))));
RDebugUtils.currentLine=2031713;
 //BA.debugLineNum = 2031713;BA.debugLine="col_font=Regex.Split(\",\",list_color.Get(1))";
_col_font = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (1)))));
RDebugUtils.currentLine=2031717;
 //BA.debugLineNum = 2031717;BA.debugLine="color1= col.Get(0)";
_color1 = (int)(BA.ObjectToNumber(_col.Get((int) (0))));
RDebugUtils.currentLine=2031718;
 //BA.debugLineNum = 2031718;BA.debugLine="color2= col.Get(1)";
_color2 = (int)(BA.ObjectToNumber(_col.Get((int) (1))));
RDebugUtils.currentLine=2031719;
 //BA.debugLineNum = 2031719;BA.debugLine="color_index=col.Get(2)  'index color";
_color_index = (int)(BA.ObjectToNumber(_col.Get((int) (2))));
RDebugUtils.currentLine=2031720;
 //BA.debugLineNum = 2031720;BA.debugLine="color3= col.Get(3)";
_color3 = (int)(BA.ObjectToNumber(_col.Get((int) (3))));
RDebugUtils.currentLine=2031721;
 //BA.debugLineNum = 2031721;BA.debugLine="color4= col.Get(4)";
_color4 = (int)(BA.ObjectToNumber(_col.Get((int) (4))));
RDebugUtils.currentLine=2031722;
 //BA.debugLineNum = 2031722;BA.debugLine="color5= col.Get(5)";
_color5 = (int)(BA.ObjectToNumber(_col.Get((int) (5))));
RDebugUtils.currentLine=2031724;
 //BA.debugLineNum = 2031724;BA.debugLine="main_font=col_font.Get(0)";
_main_font = BA.ObjectToString(_col_font.Get((int) (0)));
RDebugUtils.currentLine=2031725;
 //BA.debugLineNum = 2031725;BA.debugLine="size_f1=col_font.Get(1)";
_size_f1 = (int)(BA.ObjectToNumber(_col_font.Get((int) (1))));
RDebugUtils.currentLine=2031726;
 //BA.debugLineNum = 2031726;BA.debugLine="size_f2=col_font.Get(2)";
_size_f2 = (int)(BA.ObjectToNumber(_col_font.Get((int) (2))));
RDebugUtils.currentLine=2031727;
 //BA.debugLineNum = 2031727;BA.debugLine="size_f3=col_font.Get(3)";
_size_f3 = (int)(BA.ObjectToNumber(_col_font.Get((int) (3))));
 }else {
RDebugUtils.currentLine=2031731;
 //BA.debugLineNum = 2031731;BA.debugLine="color_index=1";
_color_index = (int) (1);
RDebugUtils.currentLine=2031732;
 //BA.debugLineNum = 2031732;BA.debugLine="color1= 0XFF69AC00";
_color1 = ((int)0xff69ac00);
RDebugUtils.currentLine=2031733;
 //BA.debugLineNum = 2031733;BA.debugLine="color2= 0xFF00C7C7";
_color2 = ((int)0xff00c7c7);
RDebugUtils.currentLine=2031734;
 //BA.debugLineNum = 2031734;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=2031735;
 //BA.debugLineNum = 2031735;BA.debugLine="color4=0XFF69AC00";
_color4 = ((int)0xff69ac00);
RDebugUtils.currentLine=2031736;
 //BA.debugLineNum = 2031736;BA.debugLine="color5=0XFF69AC00";
_color5 = ((int)0xff69ac00);
RDebugUtils.currentLine=2031738;
 //BA.debugLineNum = 2031738;BA.debugLine="main_font=\"یکان\"";
_main_font = "یکان";
RDebugUtils.currentLine=2031739;
 //BA.debugLineNum = 2031739;BA.debugLine="size_f1=17";
_size_f1 = (int) (17);
RDebugUtils.currentLine=2031740;
 //BA.debugLineNum = 2031740;BA.debugLine="size_f2=15";
_size_f2 = (int) (15);
RDebugUtils.currentLine=2031741;
 //BA.debugLineNum = 2031741;BA.debugLine="size_f3=13";
_size_f3 = (int) (13);
RDebugUtils.currentLine=2031744;
 //BA.debugLineNum = 2031744;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(_color1)+","+BA.NumberToString(_color2)+","+BA.NumberToString(_color_index)+","+BA.NumberToString(_color3)+","+BA.NumberToString(_color4)+","+BA.NumberToString(_color5)+anywheresoftware.b4a.keywords.Common.CRLF+_main_font+","+BA.NumberToString(_size_f1)+","+BA.NumberToString(_size_f2)+","+BA.NumberToString(_size_f3));
 };
RDebugUtils.currentLine=2031752;
 //BA.debugLineNum = 2031752;BA.debugLine="Dim dw As GradientDrawable";
_dw = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=2031753;
 //BA.debugLineNum = 2031753;BA.debugLine="Dim clr() As Int = Array  As Int(color1,color2)";
_clr = new int[]{_color1,_color2};
RDebugUtils.currentLine=2031754;
 //BA.debugLineNum = 2031754;BA.debugLine="dw.Initialize(\"TOP_BOTTOM\",clr)";
_dw.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clr);
RDebugUtils.currentLine=2031755;
 //BA.debugLineNum = 2031755;BA.debugLine="dw.CornerRadius=50dip";
_dw.setCornerRadius((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))));
RDebugUtils.currentLine=2031756;
 //BA.debugLineNum = 2031756;BA.debugLine="Panel1.Background=dw";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_dw.getObject()));
RDebugUtils.currentLine=2031764;
 //BA.debugLineNum = 2031764;BA.debugLine="lbl_box_title.Color=color4";
mostCurrent._lbl_box_title.setColor(_color4);
RDebugUtils.currentLine=2031773;
 //BA.debugLineNum = 2031773;BA.debugLine="get_today_shift";
_get_today_shift();
RDebugUtils.currentLine=2031776;
 //BA.debugLineNum = 2031776;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=2031784;
 //BA.debugLineNum = 2031784;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip_click", null));}
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Private Sub lbl_vip_Click";
RDebugUtils.currentLine=5701634;
 //BA.debugLineNum = 5701634;BA.debugLine="pan_all_noskhe.Visible=True";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5701635;
 //BA.debugLineNum = 5701635;BA.debugLine="scroll_v_noskhe.Panel.LoadLayout(\"noske_item\")";
mostCurrent._scroll_v_noskhe.getPanel().LoadLayout("noske_item",mostCurrent.activityBA);
RDebugUtils.currentLine=5701637;
 //BA.debugLineNum = 5701637;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=5701638;
 //BA.debugLineNum = 5701638;BA.debugLine="lbl_show_vip.Text=\"نسخه کامل ( طلایی ) فعال می ب";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه کامل ( طلایی ) فعال می باشد."));
 }else {
RDebugUtils.currentLine=5701640;
 //BA.debugLineNum = 5701640;BA.debugLine="lbl_show_vip.Text=\"نسخه معمولی ( هدیه ) فعال می";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه معمولی ( هدیه ) فعال می باشد."));
 };
RDebugUtils.currentLine=5701643;
 //BA.debugLineNum = 5701643;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "http_initial_1", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "http_initial_1", new Object[] {_type1}));}
String _send = "";
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub http_initial_1(type1 As Int)";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="ht.Initialize(\"ht\",Me)";
mostCurrent._ht._initialize /*String*/ (null,processBA,"ht",main.getObject());
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="Dim send As String";
_send = "";
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="send = \"username=mahdi&password=1234&div_id=\"&pho";
_send = "username=mahdi&password=1234&div_id="+_phon.GetSettings("android_id")+"&sdk_ver="+BA.NumberToString(_phon.getSdkVersion())+"&oprator="+_phon.GetNetworkOperatorName()+"&type_app="+BA.NumberToString(_type1)+"&div_model="+_phon.getModel()+"&last_notif="+mostCurrent._last_notif+"&var=0&is_now_instal="+BA.ObjectToString(_is_now_instal)+"&version_code="+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Application.getVersionCode());
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="ht.PostString(\"https://azarfadak.com/ezafekari2.p";
mostCurrent._ht._poststring /*String*/ (null,"https://azarfadak.com/ezafekari2.php",_send);
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
int _result = 0;
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="If (pan_all_msgNewYear.Visible=True)Then";
if ((mostCurrent._pan_all_msgnewyear.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=3538949;
 //BA.debugLineNum = 3538949;BA.debugLine="else If (pan_help.Visible=True)Then";
if ((mostCurrent._pan_help.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3538950;
 //BA.debugLineNum = 3538950;BA.debugLine="lbl_close_help_Click";
_lbl_close_help_click();
 }else 
{RDebugUtils.currentLine=3538952;
 //BA.debugLineNum = 3538952;BA.debugLine="Else If (pan_all.Visible=True )Then";
if ((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3538954;
 //BA.debugLineNum = 3538954;BA.debugLine="If(pan_all2.Visible=True)Then";
if ((mostCurrent._pan_all2.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3538955;
 //BA.debugLineNum = 3538955;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=3538957;
 //BA.debugLineNum = 3538957;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }else 
{RDebugUtils.currentLine=3538960;
 //BA.debugLineNum = 3538960;BA.debugLine="Else if(pan_notifi_all.Visible==True) Then";
if ((mostCurrent._pan_notifi_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3538961;
 //BA.debugLineNum = 3538961;BA.debugLine="lbl_close_notif_Click";
_lbl_close_notif_click();
 }else 
{RDebugUtils.currentLine=3538962;
 //BA.debugLineNum = 3538962;BA.debugLine="Else If(index_page=2 Or index_page=3)Then";
if ((_index_page==2 || _index_page==3)) { 
RDebugUtils.currentLine=3538963;
 //BA.debugLineNum = 3538963;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 }else 
{RDebugUtils.currentLine=3538964;
 //BA.debugLineNum = 3538964;BA.debugLine="Else If(pan_all_noskhe.Visible==True)Then";
if ((mostCurrent._pan_all_noskhe.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3538965;
 //BA.debugLineNum = 3538965;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
 }else 
{RDebugUtils.currentLine=3538966;
 //BA.debugLineNum = 3538966;BA.debugLine="Else If(pan_all_liteMenu.Visible==True)Then";
if ((mostCurrent._pan_all_litemenu.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3538967;
 //BA.debugLineNum = 3538967;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=3538968;
 //BA.debugLineNum = 3538968;BA.debugLine="Else If (pan_all_chekUpdate.Visible==True)Then";
if ((mostCurrent._pan_all_chekupdate.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3538969;
 //BA.debugLineNum = 3538969;BA.debugLine="pan_all_chekUpdate.Visible=False";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=3538970;
 //BA.debugLineNum = 3538970;BA.debugLine="Else If(pan_all_FT.Visible=True)Then";
if ((mostCurrent._pan_all_ft.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3538971;
 //BA.debugLineNum = 3538971;BA.debugLine="pan_all_FT.Visible=False";
mostCurrent._pan_all_ft.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=3538975;
 //BA.debugLineNum = 3538975;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=3538976;
 //BA.debugLineNum = 3538976;BA.debugLine="result = Msgbox2(\"آیا قصد خروج دارید؟\", \"خروج\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا قصد خروج دارید؟"),BA.ObjectToCharSequence("خروج"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=3538977;
 //BA.debugLineNum = 3538977;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=3538978;
 //BA.debugLineNum = 3538978;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 };
 }}}}}}}}}
;
RDebugUtils.currentLine=3538984;
 //BA.debugLineNum = 3538984;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=3538986;
 //BA.debugLineNum = 3538986;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=3538988;
 //BA.debugLineNum = 3538988;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_close_help_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_help_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_help_click", null));}
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Private Sub lbl_close_help_Click";
RDebugUtils.currentLine=5832705;
 //BA.debugLineNum = 5832705;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_notif_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_notif_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_notif_click", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub lbl_close_notif_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="pan_notifi_all.Visible=False";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_noskhe_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_noskhe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_noskhe_click", null));}
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Private Sub pan_all_noskhe_Click";
RDebugUtils.currentLine=6750209;
 //BA.debugLineNum = 6750209;BA.debugLine="pan_all_noskhe.Visible=False";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6750210;
 //BA.debugLineNum = 6750210;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="End Sub";
return "";
}
public static String  _add_end() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_end", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_end", null));}
boolean _chek = false;
anywheresoftware.b4a.objects.collections.List _alist = null;
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub add_end";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="Dim chek As Boolean";
_chek = false;
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="chek=myfunc.check_karid";
_chek = mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=3276803;
 //BA.debugLineNum = 3276803;BA.debugLine="Dim alist As List";
_alist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3276804;
 //BA.debugLineNum = 3276804;BA.debugLine="alist.Initialize";
_alist.Initialize();
RDebugUtils.currentLine=3276806;
 //BA.debugLineNum = 3276806;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(myfunc";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth())))));
RDebugUtils.currentLine=3276809;
 //BA.debugLineNum = 3276809;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(persianDate.Pe";
_alist = mostCurrent._myfunc._num_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear())),_moon_num);
RDebugUtils.currentLine=3276812;
 //BA.debugLineNum = 3276812;BA.debugLine="If(index_box=1) Then";
if ((_index_box==1)) { 
RDebugUtils.currentLine=3276813;
 //BA.debugLineNum = 3276813;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=3276814;
 //BA.debugLineNum = 3276814;BA.debugLine="If(alist.Get(0)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (0))))<5)) { 
RDebugUtils.currentLine=3276815;
 //BA.debugLineNum = 3276815;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 }else {
RDebugUtils.currentLine=3276817;
 //BA.debugLineNum = 3276817;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=3276821;
 //BA.debugLineNum = 3276821;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 };
 }else 
{RDebugUtils.currentLine=3276824;
 //BA.debugLineNum = 3276824;BA.debugLine="Else If (index_box=2) Then";
if ((_index_box==2)) { 
RDebugUtils.currentLine=3276826;
 //BA.debugLineNum = 3276826;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=3276827;
 //BA.debugLineNum = 3276827;BA.debugLine="If(alist.Get(1)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (1))))<5)) { 
RDebugUtils.currentLine=3276828;
 //BA.debugLineNum = 3276828;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 }else {
RDebugUtils.currentLine=3276830;
 //BA.debugLineNum = 3276830;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=3276833;
 //BA.debugLineNum = 3276833;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 };
 }else 
{RDebugUtils.currentLine=3276836;
 //BA.debugLineNum = 3276836;BA.debugLine="Else If (index_box=3) Then";
if ((_index_box==3)) { 
RDebugUtils.currentLine=3276838;
 //BA.debugLineNum = 3276838;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=3276839;
 //BA.debugLineNum = 3276839;BA.debugLine="If(alist.Get(3)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (3))))<5)) { 
RDebugUtils.currentLine=3276840;
 //BA.debugLineNum = 3276840;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 }else {
RDebugUtils.currentLine=3276842;
 //BA.debugLineNum = 3276842;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=3276845;
 //BA.debugLineNum = 3276845;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 }else 
{RDebugUtils.currentLine=3276849;
 //BA.debugLineNum = 3276849;BA.debugLine="Else If (index_box=4) Then";
if ((_index_box==4)) { 
RDebugUtils.currentLine=3276851;
 //BA.debugLineNum = 3276851;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=3276852;
 //BA.debugLineNum = 3276852;BA.debugLine="If(alist.Get(3)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (3))))<5)) { 
RDebugUtils.currentLine=3276853;
 //BA.debugLineNum = 3276853;BA.debugLine="add_taradod_fast";
_add_taradod_fast();
 }else {
RDebugUtils.currentLine=3276855;
 //BA.debugLineNum = 3276855;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
RDebugUtils.currentLine=3276856;
 //BA.debugLineNum = 3276856;BA.debugLine="lbl_tim_vorod_FT.Text=\"00:00\"";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=3276857;
 //BA.debugLineNum = 3276857;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
RDebugUtils.currentLine=3276858;
 //BA.debugLineNum = 3276858;BA.debugLine="pan_all_FT_Click";
_pan_all_ft_click();
 };
 }else {
RDebugUtils.currentLine=3276861;
 //BA.debugLineNum = 3276861;BA.debugLine="add_taradod_fast";
_add_taradod_fast();
 };
 }}}}
;
RDebugUtils.currentLine=3276865;
 //BA.debugLineNum = 3276865;BA.debugLine="End Sub";
return "";
}
public static String  _add_ezafe_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_ezafe_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_ezafe_sub", null));}
int _state_mod = 0;
String _str_mod = "";
anywheresoftware.b4a.objects.collections.List _ls_temp_time1 = null;
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub add_ezafe_sub";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="Dim state_mod As Int=0";
_state_mod = (int) (0);
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="Dim str_mod As String=\"\"";
_str_mod = "";
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="If(ckb_ezaf_taradod.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3342340;
 //BA.debugLineNum = 3342340;BA.debugLine="state_mod=2";
_state_mod = (int) (2);
RDebugUtils.currentLine=3342341;
 //BA.debugLineNum = 3342341;BA.debugLine="str_mod=\" (فوق العاده)- \"";
_str_mod = " (فوق العاده)- ";
 }else {
RDebugUtils.currentLine=3342343;
 //BA.debugLineNum = 3342343;BA.debugLine="state_mod=0";
_state_mod = (int) (0);
 };
RDebugUtils.currentLine=3342347;
 //BA.debugLineNum = 3342347;BA.debugLine="Try";
try {RDebugUtils.currentLine=3342349;
 //BA.debugLineNum = 3342349;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=3342350;
 //BA.debugLineNum = 3342350;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=3342352;
 //BA.debugLineNum = 3342352;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0 Or day_bt<>0)T";
if ((_moon_bt!=0 || _year_bt!=0 || _day_bt!=0)) { 
RDebugUtils.currentLine=3342353;
 //BA.debugLineNum = 3342353;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=3342354;
 //BA.debugLineNum = 3342354;BA.debugLine="Else If (hour_bt=0 And min_bt=0 )Then";
if ((_hour_bt==0 && _min_bt==0)) { 
RDebugUtils.currentLine=3342355;
 //BA.debugLineNum = 3342355;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=3342359;
 //BA.debugLineNum = 3342359;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=3342360;
 //BA.debugLineNum = 3342360;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_ezafekari_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3342361;
 //BA.debugLineNum = 3342361;BA.debugLine="myfunc.help_man(\"توجه\",\"برای این تاریخ اضافه";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","برای این تاریخ اضافه کاری وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید");
 }else {
RDebugUtils.currentLine=3342363;
 //BA.debugLineNum = 3342363;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=3342365;
 //BA.debugLineNum = 3342365;BA.debugLine="Dim ls_temp_time1 As List";
_ls_temp_time1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3342366;
 //BA.debugLineNum = 3342366;BA.debugLine="ls_temp_time1.Initialize";
_ls_temp_time1.Initialize();
RDebugUtils.currentLine=3342368;
 //BA.debugLineNum = 3342368;BA.debugLine="ls_temp_time1.Add(lbl_tim1.Text)";
_ls_temp_time1.Add((Object)(mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=3342369;
 //BA.debugLineNum = 3342369;BA.debugLine="ls_temp_time1.Add(lbl_tim2.Text)";
_ls_temp_time1.Add((Object)(mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=3342371;
 //BA.debugLineNum = 3342371;BA.debugLine="File.WriteList(File.DirInternal,\"temp_time1.t";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time1.txt",_ls_temp_time1);
RDebugUtils.currentLine=3342373;
 //BA.debugLineNum = 3342373;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3342374;
 //BA.debugLineNum = 3342374;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=3342378;
 //BA.debugLineNum = 3342378;BA.debugLine="dbCode.edit_ezafekari(current_id_edit,date1,da";
mostCurrent._dbcode._edit_ezafekari /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=3342379;
 //BA.debugLineNum = 3342379;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3342382;
 //BA.debugLineNum = 3342382;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=3342387;
 //BA.debugLineNum = 3342387;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e38) {
			processBA.setLastException(e38);RDebugUtils.currentLine=3342393;
 //BA.debugLineNum = 3342393;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=3342398;
 //BA.debugLineNum = 3342398;BA.debugLine="End Sub";
return "";
}
public static String  _add_morakhasi_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_morakhasi_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_morakhasi_sub", null));}
String _str_noe2 = "";
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub add_morakhasi_sub";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="Dim str_noe2 As String";
_str_noe2 = "";
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="str_noe2=\"(\"&str_noe&\")- \"";
_str_noe2 = "("+mostCurrent._str_noe+")- ";
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="Try";
try {RDebugUtils.currentLine=3407877;
 //BA.debugLineNum = 3407877;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
if ((_day_bt<0 || _hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=3407878;
 //BA.debugLineNum = 3407878;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=3407879;
 //BA.debugLineNum = 3407879;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0)Then";
if ((_moon_bt!=0 || _year_bt!=0)) { 
RDebugUtils.currentLine=3407880;
 //BA.debugLineNum = 3407880;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=3407881;
 //BA.debugLineNum = 3407881;BA.debugLine="Else If (hour_bt=0 And min_bt=0 And day_bt=0 )Th";
if ((_hour_bt==0 && _min_bt==0 && _day_bt==0)) { 
RDebugUtils.currentLine=3407882;
 //BA.debugLineNum = 3407882;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=3407887;
 //BA.debugLineNum = 3407887;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=3407888;
 //BA.debugLineNum = 3407888;BA.debugLine="If(dbCode.isexist_morakhasi_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_morakhasi_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3407889;
 //BA.debugLineNum = 3407889;BA.debugLine="myfunc.help_man(\"توجه\",\"برای این تاریخ مرخصی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","برای این تاریخ مرخصی وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید");
 }else {
RDebugUtils.currentLine=3407891;
 //BA.debugLineNum = 3407891;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_morakhasi /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_noe2+mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
RDebugUtils.currentLine=3407892;
 //BA.debugLineNum = 3407892;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3407893;
 //BA.debugLineNum = 3407893;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=3407896;
 //BA.debugLineNum = 3407896;BA.debugLine="dbCode.edit_morakhasi(current_id_edit,date1,da";
mostCurrent._dbcode._edit_morakhasi /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
RDebugUtils.currentLine=3407898;
 //BA.debugLineNum = 3407898;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3407899;
 //BA.debugLineNum = 3407899;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=3407906;
 //BA.debugLineNum = 3407906;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e27) {
			processBA.setLastException(e27);RDebugUtils.currentLine=3407912;
 //BA.debugLineNum = 3407912;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=3407917;
 //BA.debugLineNum = 3407917;BA.debugLine="End Sub";
return "";
}
public static String  _add_taradod_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_taradod_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_taradod_sub", null));}
int _dagige_fixed = 0;
String _saat_fixed = "";
String _str_tozih1 = "";
String _str_tozih2 = "";
anywheresoftware.b4a.objects.collections.List _ls_temp_time2 = null;
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub add_taradod_sub";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="Try";
try {RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=3473414;
 //BA.debugLineNum = 3473414;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0 Or day_bt<>0)T";
if ((_moon_bt!=0 || _year_bt!=0 || _day_bt!=0)) { 
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=3473416;
 //BA.debugLineNum = 3473416;BA.debugLine="Else If (hour_bt=0 And min_bt=0 )Then";
if ((_hour_bt==0 && _min_bt==0)) { 
RDebugUtils.currentLine=3473417;
 //BA.debugLineNum = 3473417;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=3473422;
 //BA.debugLineNum = 3473422;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=3473423;
 //BA.debugLineNum = 3473423;BA.debugLine="If(dbCode.isexist_taradod_by_date(date1)=True)";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3473424;
 //BA.debugLineNum = 3473424;BA.debugLine="myfunc.help_man(\"توجه\",\"برای این تاریخ تردد و";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","برای این تاریخ تردد وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید");
 }else {
RDebugUtils.currentLine=3473427;
 //BA.debugLineNum = 3473427;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_ez";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3473429;
 //BA.debugLineNum = 3473429;BA.debugLine="Dim dagige_fixed As Int = tim_vorod_conv_eza";
_dagige_fixed = _tim_vorod_conv_ezaf(mostCurrent._lbl_tim1.getText());
RDebugUtils.currentLine=3473430;
 //BA.debugLineNum = 3473430;BA.debugLine="Dim saat_fixed As String = (myfunc.Min_to_sa";
_saat_fixed = BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_dagige_fixed).Get((int) (0))))+":"+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_dagige_fixed).Get((int) (1))));
RDebugUtils.currentLine=3473432;
 //BA.debugLineNum = 3473432;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_t";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=3473433;
 //BA.debugLineNum = 3473433;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=3473435;
 //BA.debugLineNum = 3473435;BA.debugLine="dbCode.add_ezafekari(date1,date2,saat_fixed,";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,_saat_fixed,mostCurrent._lbl_tim2.getText(),_day_bt,(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (0))))),(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (1))))),_str_tozih1,(int) (0));
RDebugUtils.currentLine=3473437;
 //BA.debugLineNum = 3473437;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_tozih2,(int) (0));
 }else {
RDebugUtils.currentLine=3473439;
 //BA.debugLineNum = 3473439;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
 };
RDebugUtils.currentLine=3473442;
 //BA.debugLineNum = 3473442;BA.debugLine="Dim ls_temp_time2 As List";
_ls_temp_time2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3473443;
 //BA.debugLineNum = 3473443;BA.debugLine="ls_temp_time2.Initialize";
_ls_temp_time2.Initialize();
RDebugUtils.currentLine=3473445;
 //BA.debugLineNum = 3473445;BA.debugLine="ls_temp_time2.Add(lbl_tim1.Text)";
_ls_temp_time2.Add((Object)(mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=3473446;
 //BA.debugLineNum = 3473446;BA.debugLine="ls_temp_time2.Add(lbl_tim2.Text)";
_ls_temp_time2.Add((Object)(mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=3473448;
 //BA.debugLineNum = 3473448;BA.debugLine="File.WriteList(File.DirInternal,\"temp_time2.t";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time2.txt",_ls_temp_time2);
RDebugUtils.currentLine=3473450;
 //BA.debugLineNum = 3473450;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3473451;
 //BA.debugLineNum = 3473451;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=3473454;
 //BA.debugLineNum = 3473454;BA.debugLine="dbCode.edit_taradod(current_id_edit,date1,date";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
RDebugUtils.currentLine=3473456;
 //BA.debugLineNum = 3473456;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3473457;
 //BA.debugLineNum = 3473457;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=3473463;
 //BA.debugLineNum = 3473463;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e39) {
			processBA.setLastException(e39);RDebugUtils.currentLine=3473468;
 //BA.debugLineNum = 3473468;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=3473471;
 //BA.debugLineNum = 3473471;BA.debugLine="End Sub";
return "";
}
public static String  _add_taradod_fast() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_taradod_fast", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_taradod_fast", null));}
String _str_ft1 = "";
int _tim_min2 = 0;
int _dagige_fixed = 0;
String _saat_fixed = "";
String _str_ft2 = "";
String _str_ft3 = "";
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Sub add_taradod_fast";
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="Try";
try {RDebugUtils.currentLine=7995396;
 //BA.debugLineNum = 7995396;BA.debugLine="If(dbCode.isexist_taradod_by_date(lbl_date_FT.Te";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText())==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=7995398;
 //BA.debugLineNum = 7995398;BA.debugLine="Dim str_Ft1 As String=et_tozihat_FT.Text";
_str_ft1 = mostCurrent._et_tozihat_ft.getText();
RDebugUtils.currentLine=7995399;
 //BA.debugLineNum = 7995399;BA.debugLine="If (ckb_ezaf_taradod_FT.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod_ft.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=7995402;
 //BA.debugLineNum = 7995402;BA.debugLine="dbCode.add_taradod(lbl_date_FT.Text,lbl_date_F";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),(int) (0),(int) (0),(int) (0),_str_ft1,(int) (20));
 }else {
RDebugUtils.currentLine=7995406;
 //BA.debugLineNum = 7995406;BA.debugLine="dbCode.add_taradod(lbl_date_FT.Text,lbl_date_F";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),(int) (0),(int) (0),(int) (0),_str_ft1,(int) (10));
 };
RDebugUtils.currentLine=7995409;
 //BA.debugLineNum = 7995409;BA.debugLine="Log(\"is frest\")";
anywheresoftware.b4a.keywords.Common.LogImpl("77995409","is frest",0);
RDebugUtils.currentLine=7995410;
 //BA.debugLineNum = 7995410;BA.debugLine="ToastMessageShow(\"ورود ثبت شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ورود ثبت شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7995413;
 //BA.debugLineNum = 7995413;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=7995414;
 //BA.debugLineNum = 7995414;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=7995420;
 //BA.debugLineNum = 7995420;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
RDebugUtils.currentLine=7995422;
 //BA.debugLineNum = 7995422;BA.debugLine="If (ckb_ezaf_taradod_FT.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod_ft.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=7995424;
 //BA.debugLineNum = 7995424;BA.debugLine="Dim tim_min2 As Int=(hour_bt*60)+min_bt";
_tim_min2 = (int) ((_hour_bt*60)+_min_bt);
RDebugUtils.currentLine=7995427;
 //BA.debugLineNum = 7995427;BA.debugLine="If(tim_min2>saat_kar_min) Then";
if ((_tim_min2>_saat_kar_min)) { 
RDebugUtils.currentLine=7995429;
 //BA.debugLineNum = 7995429;BA.debugLine="Dim dagige_fixed As Int = tim_vorod_conv_ezaf";
_dagige_fixed = _tim_vorod_conv_ezaf(mostCurrent._lbl_tim_vorod_ft.getText());
RDebugUtils.currentLine=7995430;
 //BA.debugLineNum = 7995430;BA.debugLine="Dim saat_fixed As String = (myfunc.Min_to_saa";
_saat_fixed = BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_dagige_fixed).Get((int) (0))))+":"+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_dagige_fixed).Get((int) (1))));
RDebugUtils.currentLine=7995432;
 //BA.debugLineNum = 7995432;BA.debugLine="dbCode.add_ezafekari(lbl_date_FT.Text,lbl_dat";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),_saat_fixed,mostCurrent._lbl_tim_khoroj_ft.getText(),_day_bt,(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min2-_saat_kar_min)).Get((int) (0))))),(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min2-_saat_kar_min)).Get((int) (1)))))," (ثبت سریع-تردد دارد)- ",(int) (0));
 };
RDebugUtils.currentLine=7995435;
 //BA.debugLineNum = 7995435;BA.debugLine="Dim str_Ft2 As String=\"(ثبت سریع-اضافه کاری)-\"";
_str_ft2 = "(ثبت سریع-اضافه کاری)-"+mostCurrent._et_tozihat_ft.getText();
RDebugUtils.currentLine=7995436;
 //BA.debugLineNum = 7995436;BA.debugLine="dbCode.edit_taradod(current_id_edit,lbl_date_F";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),_day_bt,_hour_bt,_min_bt,_str_ft2,(int) (21));
 }else {
RDebugUtils.currentLine=7995438;
 //BA.debugLineNum = 7995438;BA.debugLine="Dim str_Ft3 As String=\"(ثبت سریع)-\"&et_tozihat";
_str_ft3 = "(ثبت سریع)-"+mostCurrent._et_tozihat_ft.getText();
RDebugUtils.currentLine=7995439;
 //BA.debugLineNum = 7995439;BA.debugLine="dbCode.edit_taradod(current_id_edit,lbl_date_F";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),_day_bt,_hour_bt,_min_bt,_str_ft3,(int) (11));
 };
RDebugUtils.currentLine=7995442;
 //BA.debugLineNum = 7995442;BA.debugLine="Log(\"is secend\")";
anywheresoftware.b4a.keywords.Common.LogImpl("77995442","is secend",0);
RDebugUtils.currentLine=7995443;
 //BA.debugLineNum = 7995443;BA.debugLine="ToastMessageShow(\"خروج ثبت شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خروج ثبت شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7995446;
 //BA.debugLineNum = 7995446;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 };
 } 
       catch (Exception e33) {
			processBA.setLastException(e33);RDebugUtils.currentLine=7995455;
 //BA.debugLineNum = 7995455;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=7995459;
 //BA.debugLineNum = 7995459;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_ft_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_ft_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_ft_click", null));}
RDebugUtils.currentLine=7667712;
 //BA.debugLineNum = 7667712;BA.debugLine="Private Sub pan_all_FT_Click";
RDebugUtils.currentLine=7667713;
 //BA.debugLineNum = 7667713;BA.debugLine="pan_all_FT.Visible=False";
mostCurrent._pan_all_ft.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7667714;
 //BA.debugLineNum = 7667714;BA.debugLine="End Sub";
return "";
}
public static String  _fill_lists(String _year1,String _moon1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_lists", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_lists", new Object[] {_year1,_moon1}));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _str1 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _str2 = null;
anywheresoftware.b4a.objects.B4XViewWrapper _p2 = null;
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub fill_lists (year1 As String, moon1 As String)";
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="cust_LV_ezafekari.Clear";
mostCurrent._cust_lv_ezafekari._clear();
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="list_ezafekari_id.Clear";
mostCurrent._list_ezafekari_id.Clear();
RDebugUtils.currentLine=2293767;
 //BA.debugLineNum = 2293767;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=2293768;
 //BA.debugLineNum = 2293768;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  id DESC;")));
RDebugUtils.currentLine=2293769;
 //BA.debugLineNum = 2293769;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=2293770;
 //BA.debugLineNum = 2293770;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=2293771;
 //BA.debugLineNum = 2293771;BA.debugLine="str1.Initialize";
_str1.Initialize();
RDebugUtils.currentLine=2293772;
 //BA.debugLineNum = 2293772;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")).equals(BA.NumberToString(0)) == false)) { 
RDebugUtils.currentLine=2293773;
 //BA.debugLineNum = 2293773;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")+" روز ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
RDebugUtils.currentLine=2293775;
 //BA.debugLineNum = 2293775;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")+" ساعت ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=2293776;
 //BA.debugLineNum = 2293776;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m")+" دقیقه ");
RDebugUtils.currentLine=2293780;
 //BA.debugLineNum = 2293780;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = _xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=2293781;
 //BA.debugLineNum = 2293781;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=2293782;
 //BA.debugLineNum = 2293782;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
RDebugUtils.currentLine=2293784;
 //BA.debugLineNum = 2293784;BA.debugLine="cust_LV_ezafekari.Add(p,dbCode.res.GetString(\"id";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=2293786;
 //BA.debugLineNum = 2293786;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=2293788;
 //BA.debugLineNum = 2293788;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
RDebugUtils.currentLine=2293789;
 //BA.debugLineNum = 2293789;BA.debugLine="lbl_hour_CLV.Text=dbCode.res.GetString(\"time_fro";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=2293790;
 //BA.debugLineNum = 2293790;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str1.ToString()));
RDebugUtils.currentLine=2293791;
 //BA.debugLineNum = 2293791;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=2293792;
 //BA.debugLineNum = 2293792;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=2293793;
 //BA.debugLineNum = 2293793;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=2293795;
 //BA.debugLineNum = 2293795;BA.debugLine="list_ezafekari_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_ezafekari_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=2293800;
 //BA.debugLineNum = 2293800;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=2293801;
 //BA.debugLineNum = 2293801;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2293803;
 //BA.debugLineNum = 2293803;BA.debugLine="If(cust_LV_ezafekari.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_ezafekari._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=2293804;
 //BA.debugLineNum = 2293804;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = _xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=2293805;
 //BA.debugLineNum = 2293805;BA.debugLine="Select cust_LV_ezafekari.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_ezafekari._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=2293807;
 //BA.debugLineNum = 2293807;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
RDebugUtils.currentLine=2293809;
 //BA.debugLineNum = 2293809;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=2293811;
 //BA.debugLineNum = 2293811;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=2293813;
 //BA.debugLineNum = 2293813;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=2293815;
 //BA.debugLineNum = 2293815;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=2293817;
 //BA.debugLineNum = 2293817;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=2293819;
 //BA.debugLineNum = 2293819;BA.debugLine="cust_LV_ezafekari.Add(p,\"\")";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=2293823;
 //BA.debugLineNum = 2293823;BA.debugLine="cust_LV_morakhasi.Clear";
mostCurrent._cust_lv_morakhasi._clear();
RDebugUtils.currentLine=2293824;
 //BA.debugLineNum = 2293824;BA.debugLine="list_morakhasi_id.Clear";
mostCurrent._list_morakhasi_id.Clear();
RDebugUtils.currentLine=2293826;
 //BA.debugLineNum = 2293826;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=2293827;
 //BA.debugLineNum = 2293827;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  id DESC;")));
RDebugUtils.currentLine=2293828;
 //BA.debugLineNum = 2293828;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=2293829;
 //BA.debugLineNum = 2293829;BA.debugLine="Dim str2 As StringBuilder";
_str2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=2293830;
 //BA.debugLineNum = 2293830;BA.debugLine="str2.Initialize";
_str2.Initialize();
RDebugUtils.currentLine=2293831;
 //BA.debugLineNum = 2293831;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")).equals(BA.NumberToString(0)) == false)) { 
RDebugUtils.currentLine=2293832;
 //BA.debugLineNum = 2293832;BA.debugLine="str2.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
_str2.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")+" روز ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
RDebugUtils.currentLine=2293834;
 //BA.debugLineNum = 2293834;BA.debugLine="str2.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
_str2.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")+" ساعت ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=2293835;
 //BA.debugLineNum = 2293835;BA.debugLine="str2.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
_str2.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m")+" دقیقه ");
RDebugUtils.currentLine=2293839;
 //BA.debugLineNum = 2293839;BA.debugLine="Dim p2 As B4XView = xui.CreatePanel(\"\")";
_p2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p2 = _xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=2293840;
 //BA.debugLineNum = 2293840;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=2293841;
 //BA.debugLineNum = 2293841;BA.debugLine="p2.LoadLayout(\"item_list\")";
_p2.LoadLayout("item_list",mostCurrent.activityBA);
RDebugUtils.currentLine=2293843;
 //BA.debugLineNum = 2293843;BA.debugLine="cust_LV_morakhasi.Add(p2,dbCode.res.GetString(\"i";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=2293845;
 //BA.debugLineNum = 2293845;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=2293847;
 //BA.debugLineNum = 2293847;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
RDebugUtils.currentLine=2293848;
 //BA.debugLineNum = 2293848;BA.debugLine="lbl_hour_CLV.Text=dbCode.res.GetString(\"time_fro";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=2293849;
 //BA.debugLineNum = 2293849;BA.debugLine="lbl_time_CLV.Text=str2.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str2.ToString()));
RDebugUtils.currentLine=2293850;
 //BA.debugLineNum = 2293850;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=2293851;
 //BA.debugLineNum = 2293851;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=2293852;
 //BA.debugLineNum = 2293852;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=2293854;
 //BA.debugLineNum = 2293854;BA.debugLine="list_morakhasi_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_morakhasi_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=2293859;
 //BA.debugLineNum = 2293859;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=2293860;
 //BA.debugLineNum = 2293860;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2293866;
 //BA.debugLineNum = 2293866;BA.debugLine="If(cust_LV_morakhasi.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_morakhasi._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=2293867;
 //BA.debugLineNum = 2293867;BA.debugLine="p2 = xui.CreatePanel(\"p\")";
_p2 = _xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=2293868;
 //BA.debugLineNum = 2293868;BA.debugLine="Select cust_LV_morakhasi.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_morakhasi._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=2293870;
 //BA.debugLineNum = 2293870;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
RDebugUtils.currentLine=2293872;
 //BA.debugLineNum = 2293872;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=2293874;
 //BA.debugLineNum = 2293874;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=2293876;
 //BA.debugLineNum = 2293876;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=2293878;
 //BA.debugLineNum = 2293878;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=2293880;
 //BA.debugLineNum = 2293880;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=2293882;
 //BA.debugLineNum = 2293882;BA.debugLine="cust_LV_morakhasi.Add(p2,\"\")";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(""));
 };
RDebugUtils.currentLine=2293887;
 //BA.debugLineNum = 2293887;BA.debugLine="cust_LV_taradod.Clear";
mostCurrent._cust_lv_taradod._clear();
RDebugUtils.currentLine=2293888;
 //BA.debugLineNum = 2293888;BA.debugLine="list_taradod_id.Clear";
mostCurrent._list_taradod_id.Clear();
RDebugUtils.currentLine=2293890;
 //BA.debugLineNum = 2293890;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=2293891;
 //BA.debugLineNum = 2293891;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  id DESC;")));
RDebugUtils.currentLine=2293892;
 //BA.debugLineNum = 2293892;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=2293893;
 //BA.debugLineNum = 2293893;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=2293894;
 //BA.debugLineNum = 2293894;BA.debugLine="str1.Initialize";
_str1.Initialize();
RDebugUtils.currentLine=2293895;
 //BA.debugLineNum = 2293895;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")).equals(BA.NumberToString(0)) == false)) { 
RDebugUtils.currentLine=2293896;
 //BA.debugLineNum = 2293896;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")+" روز ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
RDebugUtils.currentLine=2293898;
 //BA.debugLineNum = 2293898;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")+" ساعت ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=2293899;
 //BA.debugLineNum = 2293899;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m")+" دقیقه ");
RDebugUtils.currentLine=2293903;
 //BA.debugLineNum = 2293903;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = _xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=2293904;
 //BA.debugLineNum = 2293904;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=2293905;
 //BA.debugLineNum = 2293905;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
RDebugUtils.currentLine=2293907;
 //BA.debugLineNum = 2293907;BA.debugLine="cust_LV_taradod.Add(p,dbCode.res.GetString(\"id\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=2293909;
 //BA.debugLineNum = 2293909;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=2293911;
 //BA.debugLineNum = 2293911;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
RDebugUtils.currentLine=2293912;
 //BA.debugLineNum = 2293912;BA.debugLine="lbl_hour_CLV.Text=\" ورود : \"&dbCode.res.GetStrin";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence(" ورود : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" -- "+" خروج : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=2293914;
 //BA.debugLineNum = 2293914;BA.debugLine="lbl_time_CLV.Typeface=Typeface.MATERIALICONS";
mostCurrent._lbl_time_clv.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
RDebugUtils.currentLine=2293915;
 //BA.debugLineNum = 2293915;BA.debugLine="lbl_time_CLV.Text=Chr(0xE8D5)";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe8d5))));
RDebugUtils.currentLine=2293916;
 //BA.debugLineNum = 2293916;BA.debugLine="lbl_time_CLV.TextSize=25";
mostCurrent._lbl_time_clv.setTextSize((float) (25));
RDebugUtils.currentLine=2293918;
 //BA.debugLineNum = 2293918;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=2293919;
 //BA.debugLineNum = 2293919;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=2293920;
 //BA.debugLineNum = 2293920;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=2293922;
 //BA.debugLineNum = 2293922;BA.debugLine="list_taradod_id.Add(dbCode.res.GetString(\"id\"))";
mostCurrent._list_taradod_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=2293927;
 //BA.debugLineNum = 2293927;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=2293928;
 //BA.debugLineNum = 2293928;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2293930;
 //BA.debugLineNum = 2293930;BA.debugLine="If(cust_LV_taradod.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_taradod._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=2293931;
 //BA.debugLineNum = 2293931;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = _xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=2293932;
 //BA.debugLineNum = 2293932;BA.debugLine="Select cust_LV_taradod.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_taradod._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=2293934;
 //BA.debugLineNum = 2293934;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
RDebugUtils.currentLine=2293936;
 //BA.debugLineNum = 2293936;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=2293938;
 //BA.debugLineNum = 2293938;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=2293940;
 //BA.debugLineNum = 2293940;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=2293942;
 //BA.debugLineNum = 2293942;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=2293944;
 //BA.debugLineNum = 2293944;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=2293946;
 //BA.debugLineNum = 2293946;BA.debugLine="cust_LV_taradod.Add(p,\"\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=2293950;
 //BA.debugLineNum = 2293950;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
RDebugUtils.currentLine=2293952;
 //BA.debugLineNum = 2293952;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="End Sub";
return "";
}
public static String  _time_show2(String _dat1,String _dat2,String _tim1,String _tim2) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time_show2", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "time_show2", new Object[] {_dat1,_dat2,_tim1,_tim2}));}
anywheresoftware.b4a.objects.collections.List _list_date_per1 = null;
anywheresoftware.b4a.objects.collections.List _list_date_per2 = null;
anywheresoftware.b4a.objects.collections.List _list_date_miladi1 = null;
anywheresoftware.b4a.objects.collections.List _list_date_miladi2 = null;
String _dat_mil_2 = "";
String _dat_mil_1 = "";
String _date_end1 = "";
String _date_end2 = "";
String _time_end1 = "";
String _time_end2 = "";
long _tim1_long = 0L;
long _tim2_long = 0L;
b4a.example.dateutils._period _period_between = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _str_show = null;
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub time_show2 (dat1 As String,dat2 As String, tim";
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="Try";
try {RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3670022;
 //BA.debugLineNum = 3670022;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3670023;
 //BA.debugLineNum = 3670023;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
RDebugUtils.currentLine=3670024;
 //BA.debugLineNum = 3670024;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
RDebugUtils.currentLine=3670026;
 //BA.debugLineNum = 3670026;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=3670027;
 //BA.debugLineNum = 3670027;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=3670028;
 //BA.debugLineNum = 3670028;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=3670029;
 //BA.debugLineNum = 3670029;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=3670031;
 //BA.debugLineNum = 3670031;BA.debugLine="Select pik_moon1.Tag";
switch (BA.switchObjectToInt(mostCurrent._pik_moon1.getTag(),(Object)(1),(Object)(2),(Object)(3),(Object)(4),(Object)(5),(Object)(6),(Object)(7),(Object)(8),(Object)(9),(Object)(10),(Object)(11),(Object)(12))) {
case 0: {
RDebugUtils.currentLine=3670033;
 //BA.debugLineNum = 3670033;BA.debugLine="pik_moon1.Tag=\"01\"";
mostCurrent._pik_moon1.setTag((Object)("01"));
 break; }
case 1: {
RDebugUtils.currentLine=3670035;
 //BA.debugLineNum = 3670035;BA.debugLine="pik_moon1.Tag=\"02\"";
mostCurrent._pik_moon1.setTag((Object)("02"));
 break; }
case 2: {
RDebugUtils.currentLine=3670037;
 //BA.debugLineNum = 3670037;BA.debugLine="pik_moon1.Tag=\"03\"";
mostCurrent._pik_moon1.setTag((Object)("03"));
 break; }
case 3: {
RDebugUtils.currentLine=3670039;
 //BA.debugLineNum = 3670039;BA.debugLine="pik_moon1.Tag=\"04\"";
mostCurrent._pik_moon1.setTag((Object)("04"));
 break; }
case 4: {
RDebugUtils.currentLine=3670041;
 //BA.debugLineNum = 3670041;BA.debugLine="pik_moon1.Tag=\"05\"";
mostCurrent._pik_moon1.setTag((Object)("05"));
 break; }
case 5: {
RDebugUtils.currentLine=3670043;
 //BA.debugLineNum = 3670043;BA.debugLine="pik_moon1.Tag=\"06\"";
mostCurrent._pik_moon1.setTag((Object)("06"));
 break; }
case 6: {
RDebugUtils.currentLine=3670045;
 //BA.debugLineNum = 3670045;BA.debugLine="pik_moon1.Tag=\"07\"";
mostCurrent._pik_moon1.setTag((Object)("07"));
 break; }
case 7: {
RDebugUtils.currentLine=3670047;
 //BA.debugLineNum = 3670047;BA.debugLine="pik_moon1.Tag=\"08\"";
mostCurrent._pik_moon1.setTag((Object)("08"));
 break; }
case 8: {
RDebugUtils.currentLine=3670049;
 //BA.debugLineNum = 3670049;BA.debugLine="pik_moon1.Tag=\"09\"";
mostCurrent._pik_moon1.setTag((Object)("09"));
 break; }
case 9: {
RDebugUtils.currentLine=3670051;
 //BA.debugLineNum = 3670051;BA.debugLine="pik_moon1.Tag=\"10\"";
mostCurrent._pik_moon1.setTag((Object)("10"));
 break; }
case 10: {
RDebugUtils.currentLine=3670053;
 //BA.debugLineNum = 3670053;BA.debugLine="pik_moon1.Tag=\"11\"";
mostCurrent._pik_moon1.setTag((Object)("11"));
 break; }
case 11: {
RDebugUtils.currentLine=3670055;
 //BA.debugLineNum = 3670055;BA.debugLine="pik_moon1.Tag=\"12\"";
mostCurrent._pik_moon1.setTag((Object)("12"));
 break; }
}
;
RDebugUtils.currentLine=3670061;
 //BA.debugLineNum = 3670061;BA.debugLine="date1=dat1";
mostCurrent._date1 = _dat1;
RDebugUtils.currentLine=3670062;
 //BA.debugLineNum = 3670062;BA.debugLine="date2=dat2";
mostCurrent._date2 = _dat2;
RDebugUtils.currentLine=3670063;
 //BA.debugLineNum = 3670063;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
RDebugUtils.currentLine=3670064;
 //BA.debugLineNum = 3670064;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
RDebugUtils.currentLine=3670068;
 //BA.debugLineNum = 3670068;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_dat";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=3670069;
 //BA.debugLineNum = 3670069;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_dat";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=3670072;
 //BA.debugLineNum = 3670072;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=3670073;
 //BA.debugLineNum = 3670073;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=3670076;
 //BA.debugLineNum = 3670076;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
RDebugUtils.currentLine=3670077;
 //BA.debugLineNum = 3670077;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
RDebugUtils.currentLine=3670079;
 //BA.debugLineNum = 3670079;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date_";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=3670080;
 //BA.debugLineNum = 3670080;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date_";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=3670082;
 //BA.debugLineNum = 3670082;BA.debugLine="time_end2=tim2&\":00\"";
_time_end2 = _tim2+":00";
RDebugUtils.currentLine=3670083;
 //BA.debugLineNum = 3670083;BA.debugLine="time_end1=tim1&\":00\"";
_time_end1 = _tim1+":00";
RDebugUtils.currentLine=3670085;
 //BA.debugLineNum = 3670085;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
RDebugUtils.currentLine=3670086;
 //BA.debugLineNum = 3670086;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
RDebugUtils.currentLine=3670087;
 //BA.debugLineNum = 3670087;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
RDebugUtils.currentLine=3670088;
 //BA.debugLineNum = 3670088;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
RDebugUtils.currentLine=3670092;
 //BA.debugLineNum = 3670092;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
RDebugUtils.currentLine=3670093;
 //BA.debugLineNum = 3670093;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
RDebugUtils.currentLine=3670096;
 //BA.debugLineNum = 3670096;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=3670097;
 //BA.debugLineNum = 3670097;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
RDebugUtils.currentLine=3670099;
 //BA.debugLineNum = 3670099;BA.debugLine="If (period_between.Years<>0)Then";
if ((_period_between.Years!=0)) { 
RDebugUtils.currentLine=3670100;
 //BA.debugLineNum = 3670100;BA.debugLine="str_show.Append(period_between.Years&\" سال \").A";
_str_show.Append(BA.NumberToString(_period_between.Years)+" سال ").Append(" و ");
 };
RDebugUtils.currentLine=3670102;
 //BA.debugLineNum = 3670102;BA.debugLine="If (period_between.Months<>0)Then";
if ((_period_between.Months!=0)) { 
RDebugUtils.currentLine=3670103;
 //BA.debugLineNum = 3670103;BA.debugLine="str_show.Append(period_between.Months&\" ماه \").";
_str_show.Append(BA.NumberToString(_period_between.Months)+" ماه ").Append(" و ");
 };
RDebugUtils.currentLine=3670105;
 //BA.debugLineNum = 3670105;BA.debugLine="If (period_between.Days<>0)Then";
if ((_period_between.Days!=0)) { 
RDebugUtils.currentLine=3670106;
 //BA.debugLineNum = 3670106;BA.debugLine="str_show.Append(period_between.Days&\" روز \").Ap";
_str_show.Append(BA.NumberToString(_period_between.Days)+" روز ").Append(" و ");
 };
RDebugUtils.currentLine=3670109;
 //BA.debugLineNum = 3670109;BA.debugLine="str_show.Append(period_between.Hours&\" ساعت \").A";
_str_show.Append(BA.NumberToString(_period_between.Hours)+" ساعت ").Append(" و ");
RDebugUtils.currentLine=3670110;
 //BA.debugLineNum = 3670110;BA.debugLine="str_show.Append(period_between.Minutes&\" دقیقه \"";
_str_show.Append(BA.NumberToString(_period_between.Minutes)+" دقیقه ");
RDebugUtils.currentLine=3670113;
 //BA.debugLineNum = 3670113;BA.debugLine="year_bt=period_between.Years";
_year_bt = _period_between.Years;
RDebugUtils.currentLine=3670114;
 //BA.debugLineNum = 3670114;BA.debugLine="moon_bt=period_between.Months";
_moon_bt = _period_between.Months;
RDebugUtils.currentLine=3670115;
 //BA.debugLineNum = 3670115;BA.debugLine="day_bt=period_between.Days";
_day_bt = _period_between.Days;
RDebugUtils.currentLine=3670116;
 //BA.debugLineNum = 3670116;BA.debugLine="hour_bt=period_between.Hours";
_hour_bt = _period_between.Hours;
RDebugUtils.currentLine=3670117;
 //BA.debugLineNum = 3670117;BA.debugLine="min_bt=period_between.Minutes";
_min_bt = _period_between.Minutes;
RDebugUtils.currentLine=3670120;
 //BA.debugLineNum = 3670120;BA.debugLine="lbl_time_show_FT.Text=str_show";
mostCurrent._lbl_time_show_ft.setText(BA.ObjectToCharSequence(_str_show.getObject()));
 } 
       catch (Exception e76) {
			processBA.setLastException(e76);RDebugUtils.currentLine=3670123;
 //BA.debugLineNum = 3670123;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=3670125;
 //BA.debugLineNum = 3670125;BA.debugLine="End Sub";
return "";
}
public static int  _tim_vorod_conv_ezaf(String _tim1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_vorod_conv_ezaf", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "tim_vorod_conv_ezaf", new Object[] {_tim1}));}
String[] _ste_tim = null;
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Sub tim_vorod_conv_ezaf (tim1 As String) As Int";
RDebugUtils.currentLine=8126466;
 //BA.debugLineNum = 8126466;BA.debugLine="Dim ste_tim() As String";
_ste_tim = new String[(int) (0)];
java.util.Arrays.fill(_ste_tim,"");
RDebugUtils.currentLine=8126467;
 //BA.debugLineNum = 8126467;BA.debugLine="ste_tim=Regex.Split(\":\",tim1)";
_ste_tim = anywheresoftware.b4a.keywords.Common.Regex.Split(":",_tim1);
RDebugUtils.currentLine=8126470;
 //BA.debugLineNum = 8126470;BA.debugLine="Return (ste_tim(0)*60)+ste_tim(1) +saat_kar_min";
if (true) return (int) (((double)(Double.parseDouble(_ste_tim[(int) (0)]))*60)+(double)(Double.parseDouble(_ste_tim[(int) (1)]))+_saat_kar_min);
RDebugUtils.currentLine=8126473;
 //BA.debugLineNum = 8126473;BA.debugLine="End Sub";
return 0;
}
public static String  _auth_complete(boolean _success,String _errormessage) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "auth_complete", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "auth_complete", new Object[] {_success,_errormessage}));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub Auth_Complete (Success As Boolean, ErrorMessag";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="tim_lock_lbl.Enabled=False";
_tim_lock_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="ToastMessageShow($\"Error: ${ErrorMessage}\"$, Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(("Error: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_errormessage))+"")),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="Log(ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("71048582",_errormessage,0);
 };
RDebugUtils.currentLine=1048584;
 //BA.debugLineNum = 1048584;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_gozaresh_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_menu_gozaresh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_menu_gozaresh_click", null));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Private Sub btn_menu_gozaresh_Click";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="index_page=3";
_index_page = (int) (3);
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="pan_imag.Background=img3";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img3.getObject()));
RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
RDebugUtils.currentLine=2359301;
 //BA.debugLineNum = 2359301;BA.debugLine="pan_main.LoadLayout(\"gozaresh_layout\")";
mostCurrent._pan_main.LoadLayout("gozaresh_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=2359303;
 //BA.debugLineNum = 2359303;BA.debugLine="sp_year_gozaresh.Add(\"1401\")";
mostCurrent._sp_year_gozaresh.Add("1401");
RDebugUtils.currentLine=2359304;
 //BA.debugLineNum = 2359304;BA.debugLine="sp_year_gozaresh.Add(\"1400\")";
mostCurrent._sp_year_gozaresh.Add("1400");
RDebugUtils.currentLine=2359305;
 //BA.debugLineNum = 2359305;BA.debugLine="sp_year_gozaresh.Add(\"1399\")";
mostCurrent._sp_year_gozaresh.Add("1399");
RDebugUtils.currentLine=2359306;
 //BA.debugLineNum = 2359306;BA.debugLine="sp_year_gozaresh.Add(\"1398\")";
mostCurrent._sp_year_gozaresh.Add("1398");
RDebugUtils.currentLine=2359308;
 //BA.debugLineNum = 2359308;BA.debugLine="sp_year_gozaresh.SelectedIndex=0";
mostCurrent._sp_year_gozaresh.setSelectedIndex((int) (0));
RDebugUtils.currentLine=2359313;
 //BA.debugLineNum = 2359313;BA.debugLine="pan_hed_gozaresh.Color=color4";
mostCurrent._pan_hed_gozaresh.setColor(_color4);
RDebugUtils.currentLine=2359318;
 //BA.debugLineNum = 2359318;BA.debugLine="list_gozareshat_id.Initialize";
mostCurrent._list_gozareshat_id.Initialize();
RDebugUtils.currentLine=2359321;
 //BA.debugLineNum = 2359321;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
RDebugUtils.currentLine=2359323;
 //BA.debugLineNum = 2359323;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_gozareshat(String _year1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_list_gozareshat", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_list_gozareshat", new Object[] {_year1}));}
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub fill_list_gozareshat(year1 As String)";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="CLV_gozaresh.Clear";
mostCurrent._clv_gozaresh._clear();
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="list_gozareshat_id.Clear";
mostCurrent._list_gozareshat_id.Clear();
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=2424837;
 //BA.debugLineNum = 2424837;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ORDER BY  id DESC;")));
RDebugUtils.currentLine=2424838;
 //BA.debugLineNum = 2424838;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=2424841;
 //BA.debugLineNum = 2424841;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
mostCurrent._p = _xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=2424842;
 //BA.debugLineNum = 2424842;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 96%x, 114dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (114)));
RDebugUtils.currentLine=2424843;
 //BA.debugLineNum = 2424843;BA.debugLine="p.LoadLayout(\"item_list_2\")";
mostCurrent._p.LoadLayout("item_list_2",mostCurrent.activityBA);
RDebugUtils.currentLine=2424845;
 //BA.debugLineNum = 2424845;BA.debugLine="CLV_gozaresh.Add(p,dbCode.res.GetString(\"id\"))";
mostCurrent._clv_gozaresh._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=2424846;
 //BA.debugLineNum = 2424846;BA.debugLine="lbl_dateGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_dategozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date")));
RDebugUtils.currentLine=2424847;
 //BA.debugLineNum = 2424847;BA.debugLine="lbl_nameGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_namegozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title")));
RDebugUtils.currentLine=2424848;
 //BA.debugLineNum = 2424848;BA.debugLine="lbl_tozihGozaresh_CLV.Text=dbCode.res.GetString(";
mostCurrent._lbl_tozihgozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozih")));
RDebugUtils.currentLine=2424849;
 //BA.debugLineNum = 2424849;BA.debugLine="lbl_remove_from_list2.Tag=dbCode.res.GetString(\"";
mostCurrent._lbl_remove_from_list2.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=2424850;
 //BA.debugLineNum = 2424850;BA.debugLine="pan_item_gozaresh.Tag=dbCode.res.GetString(\"id\")";
mostCurrent._pan_item_gozaresh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=2424851;
 //BA.debugLineNum = 2424851;BA.debugLine="list_gozareshat_id.Add(dbCode.res.GetString(\"id\"";
mostCurrent._list_gozareshat_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=2424852;
 //BA.debugLineNum = 2424852;BA.debugLine="Log(dbCode.res.GetString(\"id\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("72424852",mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id"),0);
 }
;
RDebugUtils.currentLine=2424854;
 //BA.debugLineNum = 2424854;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=2424855;
 //BA.debugLineNum = 2424855;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=2424857;
 //BA.debugLineNum = 2424857;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_click", null));}
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Private Sub lbl_help_Click";
RDebugUtils.currentLine=5767171;
 //BA.debugLineNum = 5767171;BA.debugLine="bit_img0.Initialize(File.DirAssets,\"home-h0.jpg\")";
mostCurrent._bit_img0.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h0.jpg");
RDebugUtils.currentLine=5767172;
 //BA.debugLineNum = 5767172;BA.debugLine="bit_img1.Initialize(File.DirAssets,\"home-h1.jpg\")";
mostCurrent._bit_img1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h1.jpg");
RDebugUtils.currentLine=5767173;
 //BA.debugLineNum = 5767173;BA.debugLine="bit_img2.Initialize(File.DirAssets,\"home-h2.jpg\")";
mostCurrent._bit_img2.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h2.jpg");
RDebugUtils.currentLine=5767174;
 //BA.debugLineNum = 5767174;BA.debugLine="bit_img3.Initialize(File.DirAssets,\"home-h3.jpg\")";
mostCurrent._bit_img3.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h3.jpg");
RDebugUtils.currentLine=5767175;
 //BA.debugLineNum = 5767175;BA.debugLine="bit_img4.Initialize(File.DirAssets,\"home-h4.jpg\")";
mostCurrent._bit_img4.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h4.jpg");
RDebugUtils.currentLine=5767178;
 //BA.debugLineNum = 5767178;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
RDebugUtils.currentLine=5767179;
 //BA.debugLineNum = 5767179;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
RDebugUtils.currentLine=5767180;
 //BA.debugLineNum = 5767180;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5767182;
 //BA.debugLineNum = 5767182;BA.debugLine="End Sub";
return "";
}
public static String  _get_today_shift() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_today_shift", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_today_shift", null));}
int _id_today = 0;
String _str_sh = "";
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub get_today_shift";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="Dim id_today As Int";
_id_today = 0;
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="id_today=dbCode.get_day_id(persianDate.PersianYea";
_id_today = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_persiandate.getPersianYear(),_persiandate.getPersianMonth(),_persiandate.getPersianDay());
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id_today))));
RDebugUtils.currentLine=2097159;
 //BA.debugLineNum = 2097159;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=2097163;
 //BA.debugLineNum = 2097163;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")).equals("") == false)) { 
RDebugUtils.currentLine=2097164;
 //BA.debugLineNum = 2097164;BA.debugLine="Dim str_sh As String";
_str_sh = "";
RDebugUtils.currentLine=2097165;
 //BA.debugLineNum = 2097165;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift"),"ر","ش","ع","ا")) {
case 0: {
RDebugUtils.currentLine=2097167;
 //BA.debugLineNum = 2097167;BA.debugLine="str_sh=\"روزکار\"";
_str_sh = "روزکار";
 break; }
case 1: {
RDebugUtils.currentLine=2097169;
 //BA.debugLineNum = 2097169;BA.debugLine="str_sh=\"شبکار\"";
_str_sh = "شبکار";
 break; }
case 2: {
RDebugUtils.currentLine=2097171;
 //BA.debugLineNum = 2097171;BA.debugLine="str_sh=\"عصرکار\"";
_str_sh = "عصرکار";
 break; }
case 3: {
RDebugUtils.currentLine=2097173;
 //BA.debugLineNum = 2097173;BA.debugLine="str_sh=\"استراحت\"";
_str_sh = "استراحت";
 break; }
}
;
RDebugUtils.currentLine=2097175;
 //BA.debugLineNum = 2097175;BA.debugLine="lbl_shift_home.Text=\"(\"&str_sh&\")\"";
mostCurrent._lbl_shift_home.setText(BA.ObjectToCharSequence("("+_str_sh+")"));
 };
RDebugUtils.currentLine=2097180;
 //BA.debugLineNum = 2097180;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_list_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_menu_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_menu_list_click", null));}
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Private Sub btn_menu_list_Click";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="index_page=2";
_index_page = (int) (2);
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="pan_imag.Background=img2";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img2.getObject()));
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="pan_main.LoadLayout(\"list_layout\")";
mostCurrent._pan_main.LoadLayout("list_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=2162696;
 //BA.debugLineNum = 2162696;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
RDebugUtils.currentLine=2162697;
 //BA.debugLineNum = 2162697;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
RDebugUtils.currentLine=2162698;
 //BA.debugLineNum = 2162698;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
RDebugUtils.currentLine=2162699;
 //BA.debugLineNum = 2162699;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
RDebugUtils.currentLine=2162701;
 //BA.debugLineNum = 2162701;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=2162704;
 //BA.debugLineNum = 2162704;BA.debugLine="sp_year.SelectedIndex=0";
mostCurrent._sp_year.setSelectedIndex((int) (0));
RDebugUtils.currentLine=2162705;
 //BA.debugLineNum = 2162705;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(persianDate.Pe";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))))-1));
RDebugUtils.currentLine=2162707;
 //BA.debugLineNum = 2162707;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(sp_moo";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=2162738;
 //BA.debugLineNum = 2162738;BA.debugLine="TabHost1.AddTab(\"اضافه کاری ها\" , \"tab_layout_eza";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"اضافه کاری ها","tab_layout_ezafekari.bal");
RDebugUtils.currentLine=2162739;
 //BA.debugLineNum = 2162739;BA.debugLine="TabHost1.AddTab(\" مرخصی ها\" , \"tab_layout_morakha";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA," مرخصی ها","tab_layout_morakhasi.bal");
RDebugUtils.currentLine=2162740;
 //BA.debugLineNum = 2162740;BA.debugLine="TabHost1.AddTab(\" تردد ها\" , \"tab_layout_taradod.";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA," تردد ها","tab_layout_taradod.bal");
RDebugUtils.currentLine=2162743;
 //BA.debugLineNum = 2162743;BA.debugLine="TabHost1.CurrentTab=curent_tab_list";
mostCurrent._tabhost1.setCurrentTab(_curent_tab_list);
RDebugUtils.currentLine=2162745;
 //BA.debugLineNum = 2162745;BA.debugLine="list_ezafekari_id.Initialize";
mostCurrent._list_ezafekari_id.Initialize();
RDebugUtils.currentLine=2162748;
 //BA.debugLineNum = 2162748;BA.debugLine="list_morakhasi_id.Initialize";
mostCurrent._list_morakhasi_id.Initialize();
RDebugUtils.currentLine=2162751;
 //BA.debugLineNum = 2162751;BA.debugLine="list_taradod_id.Initialize";
mostCurrent._list_taradod_id.Initialize();
RDebugUtils.currentLine=2162755;
 //BA.debugLineNum = 2162755;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=2162759;
 //BA.debugLineNum = 2162759;BA.debugLine="pan_hed_list.Color=color4";
mostCurrent._pan_hed_list.setColor(_color4);
RDebugUtils.currentLine=2162766;
 //BA.debugLineNum = 2162766;BA.debugLine="End Sub";
return "";
}
public static String  _btneight_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btneight_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btneight_click", null));}
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub btnEight_Click";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="click_count_Increment_and_fill(btnEight.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btneight.getText());
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="End Sub";
return "";
}
public static String  _click_count_increment_and_fill(String _input_text) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "click_count_increment_and_fill", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "click_count_increment_and_fill", new Object[] {_input_text}));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub click_count_Increment_and_fill (input_Text As";
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="Click_Count = Click_Count + 1";
_click_count = (int) (_click_count+1);
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="Select Click_Count";
switch (_click_count) {
case 1: {
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="key1.Color = Colors.Red";
mostCurrent._key1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1769481;
 //BA.debugLineNum = 1769481;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 2: {
RDebugUtils.currentLine=1769484;
 //BA.debugLineNum = 1769484;BA.debugLine="key2.Color = Colors.Red";
mostCurrent._key2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1769487;
 //BA.debugLineNum = 1769487;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 3: {
RDebugUtils.currentLine=1769490;
 //BA.debugLineNum = 1769490;BA.debugLine="key3.Color = Colors.Red";
mostCurrent._key3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1769493;
 //BA.debugLineNum = 1769493;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 4: {
RDebugUtils.currentLine=1769496;
 //BA.debugLineNum = 1769496;BA.debugLine="key4.Color = Colors.Red";
mostCurrent._key4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1769499;
 //BA.debugLineNum = 1769499;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
RDebugUtils.currentLine=1769505;
 //BA.debugLineNum = 1769505;BA.debugLine="If entered_Password = Master_Password Then";
if ((mostCurrent._entered_password).equals(mostCurrent._master_password)) { 
RDebugUtils.currentLine=1769508;
 //BA.debugLineNum = 1769508;BA.debugLine="resetting_all";
_resetting_all();
RDebugUtils.currentLine=1769510;
 //BA.debugLineNum = 1769510;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=1769512;
 //BA.debugLineNum = 1769512;BA.debugLine="ToastMessageShow(\"رمز عبور اشتباه است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("رمز عبور اشتباه است"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1769516;
 //BA.debugLineNum = 1769516;BA.debugLine="resetting_all";
_resetting_all();
 };
 break; }
}
;
RDebugUtils.currentLine=1769521;
 //BA.debugLineNum = 1769521;BA.debugLine="End Sub";
return "";
}
public static String  _btnfive_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnfive_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnfive_click", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub btnFive_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="click_count_Increment_and_fill(btnFive.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnfive.getText());
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="End Sub";
return "";
}
public static String  _btnfour_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnfour_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnfour_click", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub btnFour_Click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="click_count_Increment_and_fill(btnFour.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnfour.getText());
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="End Sub";
return "";
}
public static String  _btnnine_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnnine_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnnine_click", null));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub btnNine_Click";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="click_count_Increment_and_fill(btnNine.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnnine.getText());
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="End Sub";
return "";
}
public static String  _btnone_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnone_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnone_click", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub btnOne_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="click_count_Increment_and_fill(btnOne.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btnone.getText());
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="End Sub";
return "";
}
public static String  _btnseven_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnseven_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnseven_click", null));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub btnSeven_Click";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="click_count_Increment_and_fill(btnSeven.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btnseven.getText());
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="End Sub";
return "";
}
public static String  _btnsix_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnsix_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnsix_click", null));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub btnSix_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="click_count_Increment_and_fill(btnSix.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btnsix.getText());
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="End Sub";
return "";
}
public static String  _btnthree_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnthree_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnthree_click", null));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub btnThree_Click";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="click_count_Increment_and_fill(btnThree.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btnthree.getText());
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="End Sub";
return "";
}
public static String  _btntwo_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btntwo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btntwo_click", null));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub btnTwo_Click";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="click_count_Increment_and_fill(btnTwo.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btntwo.getText());
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="End Sub";
return "";
}
public static String  _btnzero_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnzero_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnzero_click", null));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub btnZero_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="click_count_Increment_and_fill(btnZero.Text)";
_click_count_increment_and_fill(mostCurrent._btnzero.getText());
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="End Sub";
return "";
}
public static String  _resetting_all() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "resetting_all", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "resetting_all", null));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub resetting_all";
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="key1.color = Colors.White";
mostCurrent._key1.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="key2.Color = Colors.White";
mostCurrent._key2.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="key3.Color = Colors.White";
mostCurrent._key3.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1835013;
 //BA.debugLineNum = 1835013;BA.debugLine="key4.Color = Colors.white";
mostCurrent._key4.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1835016;
 //BA.debugLineNum = 1835016;BA.debugLine="entered_Password = \"\"";
mostCurrent._entered_password = "";
RDebugUtils.currentLine=1835020;
 //BA.debugLineNum = 1835020;BA.debugLine="Click_Count = 0";
_click_count = (int) (0);
RDebugUtils.currentLine=1835021;
 //BA.debugLineNum = 1835021;BA.debugLine="End Sub";
return "";
}
public static String  _cust_lv_taradod_itemclick(int _index,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cust_lv_taradod_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cust_lv_taradod_itemclick", new Object[] {_index,_value}));}
RDebugUtils.currentLine=7077888;
 //BA.debugLineNum = 7077888;BA.debugLine="Private Sub cust_LV_taradod_ItemClick (Index As In";
RDebugUtils.currentLine=7077890;
 //BA.debugLineNum = 7077890;BA.debugLine="End Sub";
return "";
}
public static String  _tabhost1_tabchanged() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tabhost1_tabchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tabhost1_tabchanged", null));}
anywheresoftware.b4a.objects.collections.List _ls_all_saat = null;
String _str_saat = "";
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Private Sub TabHost1_TabChanged";
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="Dim ls_all_saat As List";
_ls_all_saat = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="ls_all_saat.Initialize";
_ls_all_saat.Initialize();
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="Dim str_saat As String";
_str_saat = "";
RDebugUtils.currentLine=2228230;
 //BA.debugLineNum = 2228230;BA.debugLine="If(sp_year.IsInitialized)Then";
if ((mostCurrent._sp_year.IsInitialized())) { 
RDebugUtils.currentLine=2228236;
 //BA.debugLineNum = 2228236;BA.debugLine="Select TabHost1.CurrentTab";
switch (BA.switchObjectToInt(mostCurrent._tabhost1.getCurrentTab(),(int) (0),(int) (1),(int) (2))) {
case 0: {
RDebugUtils.currentLine=2228238;
 //BA.debugLineNum = 2228238;BA.debugLine="ls_all_saat=dbCode.all_ezafekari_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
RDebugUtils.currentLine=2228239;
 //BA.debugLineNum = 2228239;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
case 1: {
RDebugUtils.currentLine=2228241;
 //BA.debugLineNum = 2228241;BA.debugLine="ls_all_saat=dbCode.all_morakhasi_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=2228243;
 //BA.debugLineNum = 2228243;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" روز و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" ساعت و "+BA.ObjectToString(_ls_all_saat.Get((int) (2)))+" دقیقه ";
 break; }
case 2: {
RDebugUtils.currentLine=2228245;
 //BA.debugLineNum = 2228245;BA.debugLine="ls_all_saat=dbCode.all_taradod_mah(myfunc.fa2e";
_ls_all_saat = mostCurrent._dbcode._all_taradod_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=2228246;
 //BA.debugLineNum = 2228246;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
}
;
RDebugUtils.currentLine=2228253;
 //BA.debugLineNum = 2228253;BA.debugLine="lbl_majmoe_saat.Text=str_saat";
mostCurrent._lbl_majmoe_saat.setText(BA.ObjectToCharSequence(_str_saat));
 };
RDebugUtils.currentLine=2228259;
 //BA.debugLineNum = 2228259;BA.debugLine="End Sub";
return "";
}
public static String  _finger_scaning() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "finger_scaning", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "finger_scaning", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub finger_scaning";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="fingerprint.Authenticate";
mostCurrent._fingerprint._authenticate /*String*/ (null);
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="ToastMessageShow(\"Scanning...\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Scanning..."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="End Sub";
return "";
}
public static String  _get_dataedit_byid(int _id1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_dataedit_byid", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_dataedit_byid", new Object[] {_id1}));}
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Sub get_dataEdit_byId(id1 As Int)";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="If(index_box=1)Then";
if ((_index_box==1)) { 
RDebugUtils.currentLine=6160387;
 //BA.debugLineNum = 6160387;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=6160388;
 //BA.debugLineNum = 6160388;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=6160390;
 //BA.debugLineNum = 6160390;BA.debugLine="If(dbCode.res.GetInt(\"state\")=0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==0)) { 
RDebugUtils.currentLine=6160391;
 //BA.debugLineNum = 6160391;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=6160393;
 //BA.debugLineNum = 6160393;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
 }else 
{RDebugUtils.currentLine=6160398;
 //BA.debugLineNum = 6160398;BA.debugLine="Else If(index_box=2)Then";
if ((_index_box==2)) { 
RDebugUtils.currentLine=6160399;
 //BA.debugLineNum = 6160399;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=6160400;
 //BA.debugLineNum = 6160400;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=6160403;
 //BA.debugLineNum = 6160403;BA.debugLine="Select dbCode.res.GetInt(\"state\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
RDebugUtils.currentLine=6160405;
 //BA.debugLineNum = 6160405;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
RDebugUtils.currentLine=6160407;
 //BA.debugLineNum = 6160407;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
RDebugUtils.currentLine=6160409;
 //BA.debugLineNum = 6160409;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
RDebugUtils.currentLine=6160411;
 //BA.debugLineNum = 6160411;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
RDebugUtils.currentLine=6160415;
 //BA.debugLineNum = 6160415;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
RDebugUtils.currentLine=6160416;
 //BA.debugLineNum = 6160416;BA.debugLine="index_noe_morakhasi=dbCode.res.GetInt(\"state\")";
_index_noe_morakhasi = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state");
 }else 
{RDebugUtils.currentLine=6160420;
 //BA.debugLineNum = 6160420;BA.debugLine="Else If(index_box=3)Then";
if ((_index_box==3)) { 
RDebugUtils.currentLine=6160421;
 //BA.debugLineNum = 6160421;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=6160422;
 //BA.debugLineNum = 6160422;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 }}}
;
RDebugUtils.currentLine=6160429;
 //BA.debugLineNum = 6160429;BA.debugLine="lbl_tim1.Text=dbCode.res.GetString(\"time_from\")";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")));
RDebugUtils.currentLine=6160430;
 //BA.debugLineNum = 6160430;BA.debugLine="lbl_tim2.Text=dbCode.res.GetString(\"time_to\")";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=6160432;
 //BA.debugLineNum = 6160432;BA.debugLine="lbl_date1.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=6160433;
 //BA.debugLineNum = 6160433;BA.debugLine="lbl_date2.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))));
RDebugUtils.currentLine=6160435;
 //BA.debugLineNum = 6160435;BA.debugLine="et_tozihat.Text=dbCode.res.GetString(\"tozihat\")";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=6160438;
 //BA.debugLineNum = 6160438;BA.debugLine="End Sub";
return "";
}
public static String  _img_slider(int _index1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "img_slider", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "img_slider", new Object[] {_index1}));}
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Sub img_slider (index1 As Int)";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="Select index1";
switch (_index1) {
case 0: {
RDebugUtils.currentLine=6029315;
 //BA.debugLineNum = 6029315;BA.debugLine="img_help.Bitmap=bit_img0";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img0.getObject()));
 break; }
case 1: {
RDebugUtils.currentLine=6029317;
 //BA.debugLineNum = 6029317;BA.debugLine="img_help.Bitmap=bit_img1";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img1.getObject()));
 break; }
case 2: {
RDebugUtils.currentLine=6029320;
 //BA.debugLineNum = 6029320;BA.debugLine="img_help.Bitmap=bit_img2";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img2.getObject()));
 break; }
case 3: {
RDebugUtils.currentLine=6029323;
 //BA.debugLineNum = 6029323;BA.debugLine="img_help.Bitmap=bit_img3";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img3.getObject()));
 break; }
case 4: {
RDebugUtils.currentLine=6029326;
 //BA.debugLineNum = 6029326;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
 break; }
default: {
RDebugUtils.currentLine=6029329;
 //BA.debugLineNum = 6029329;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("76029329","error",0);
 break; }
}
;
RDebugUtils.currentLine=6029332;
 //BA.debugLineNum = 6029332;BA.debugLine="End Sub";
return "";
}
public static String  _inapp_purchasecompleted(boolean _success,anywheresoftware.b4a.inappbilling3.BillingManager3.Prchase _product) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "inapp_purchasecompleted", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "inapp_purchasecompleted", new Object[] {_success,_product}));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub inapp_PurchaseCompleted (Success As Boolean, P";
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="If Success=True Then";
if (_success==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="If Product.ProductId=\"ezafekari2\" Then";
if ((_product.getProductId()).equals("ezafekari2")) { 
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\",\"\")";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="MsgboxAsync(\"پرداخت انجام شده است\",\"انجام شد\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("پرداخت انجام شده است"),BA.ObjectToCharSequence("انجام شد"),processBA);
RDebugUtils.currentLine=786441;
 //BA.debugLineNum = 786441;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی ا";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786443;
 //BA.debugLineNum = 786443;BA.debugLine="inapp.ConsumeProduct(Product)";
mostCurrent._inapp.ConsumeProduct(processBA,_product);
RDebugUtils.currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
RDebugUtils.currentLine=786446;
 //BA.debugLineNum = 786446;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=786450;
 //BA.debugLineNum = 786450;BA.debugLine="ToastMessageShow(\"خرید انجام نشد. دوباره تلاش کن";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خرید انجام نشد. دوباره تلاش کنید"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=786452;
 //BA.debugLineNum = 786452;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(ir.taravatgroup.ezafekari2.httpjob _job) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
anywheresoftware.b4a.objects.collections.List _ls_lock0 = null;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root1 = null;
String _str_type = "";
String _str_version_code = "";
String _str_version_name = "";
String _str_changelog_fa = "";
String _str_message = "";
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Jobdone (job As HttpJob)";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Try";
try {RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="If job.JobName=\"ht\" Then";
if ((_job._jobname /*String*/ ).equals("ht")) { 
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="If(job.GetString <> \"\")Then";
if (((_job._getstring /*String*/ (null)).equals("") == false)) { 
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="If(job.GetString.Contains(\"accessok\"))Then";
if ((_job._getstring /*String*/ (null).contains("accessok"))) { 
RDebugUtils.currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
 }else {
RDebugUtils.currentLine=393229;
 //BA.debugLineNum = 393229;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
RDebugUtils.currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="myfunc.help_man(\"توجه\",\"نسخه طلایی از طرف ا";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","نسخه طلایی از طرف ادمین فعال شد");
 };
 }else 
{RDebugUtils.currentLine=393233;
 //BA.debugLineNum = 393233;BA.debugLine="Else If (job.GetString.Contains(\"accessno\"))T";
if ((_job._getstring /*String*/ (null).contains("accessno"))) { 
RDebugUtils.currentLine=393235;
 //BA.debugLineNum = 393235;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
RDebugUtils.currentLine=393236;
 //BA.debugLineNum = 393236;BA.debugLine="File.Delete(File.DirInternal,\"payokok\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok");
RDebugUtils.currentLine=393237;
 //BA.debugLineNum = 393237;BA.debugLine="myfunc.help_man(\"توجه\",\" نسخه طلایی از طرف";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه"," نسخه طلایی از طرف ادمین غیرفعال شد");
 };
 }else 
{RDebugUtils.currentLine=393239;
 //BA.debugLineNum = 393239;BA.debugLine="Else If (job.GetString.Contains(\"lockok\"))The";
if ((_job._getstring /*String*/ (null).contains("lockok"))) { 
RDebugUtils.currentLine=393241;
 //BA.debugLineNum = 393241;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=393242;
 //BA.debugLineNum = 393242;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
RDebugUtils.currentLine=393244;
 //BA.debugLineNum = 393244;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=393245;
 //BA.debugLineNum = 393245;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
RDebugUtils.currentLine=393246;
 //BA.debugLineNum = 393246;BA.debugLine="ls_lock0.Set(0,\"true\")";
_ls_lock0.Set((int) (0),(Object)("true"));
RDebugUtils.currentLine=393247;
 //BA.debugLineNum = 393247;BA.debugLine="ls_lock0.Set(1,\"false\")";
_ls_lock0.Set((int) (1),(Object)("false"));
RDebugUtils.currentLine=393248;
 //BA.debugLineNum = 393248;BA.debugLine="ls_lock0.Set(2,\"2022\")";
_ls_lock0.Set((int) (2),(Object)("2022"));
 }else {
RDebugUtils.currentLine=393250;
 //BA.debugLineNum = 393250;BA.debugLine="ls_lock0.Add(\"true\")";
_ls_lock0.Add((Object)("true"));
RDebugUtils.currentLine=393251;
 //BA.debugLineNum = 393251;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
RDebugUtils.currentLine=393252;
 //BA.debugLineNum = 393252;BA.debugLine="ls_lock0.Add(\"2022\")";
_ls_lock0.Add((Object)("2022"));
RDebugUtils.currentLine=393253;
 //BA.debugLineNum = 393253;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 };
RDebugUtils.currentLine=393255;
 //BA.debugLineNum = 393255;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock0);
 }else 
{RDebugUtils.currentLine=393257;
 //BA.debugLineNum = 393257;BA.debugLine="Else If (job.GetString.Contains(\"lockno\"))The";
if ((_job._getstring /*String*/ (null).contains("lockno"))) { 
RDebugUtils.currentLine=393258;
 //BA.debugLineNum = 393258;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=393259;
 //BA.debugLineNum = 393259;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
RDebugUtils.currentLine=393261;
 //BA.debugLineNum = 393261;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=393262;
 //BA.debugLineNum = 393262;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
RDebugUtils.currentLine=393263;
 //BA.debugLineNum = 393263;BA.debugLine="ls_lock0.Set(0,\"false\")";
_ls_lock0.Set((int) (0),(Object)("false"));
RDebugUtils.currentLine=393264;
 //BA.debugLineNum = 393264;BA.debugLine="ls_lock0.Set(1,\"false\")";
_ls_lock0.Set((int) (1),(Object)("false"));
RDebugUtils.currentLine=393265;
 //BA.debugLineNum = 393265;BA.debugLine="ls_lock0.Set(2,\"\")";
_ls_lock0.Set((int) (2),(Object)(""));
 }else {
RDebugUtils.currentLine=393267;
 //BA.debugLineNum = 393267;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
RDebugUtils.currentLine=393268;
 //BA.debugLineNum = 393268;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
RDebugUtils.currentLine=393269;
 //BA.debugLineNum = 393269;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
RDebugUtils.currentLine=393270;
 //BA.debugLineNum = 393270;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 };
RDebugUtils.currentLine=393272;
 //BA.debugLineNum = 393272;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock0);
 }else {
RDebugUtils.currentLine=393277;
 //BA.debugLineNum = 393277;BA.debugLine="msg=job.GetString";
mostCurrent._msg = _job._getstring /*String*/ (null);
RDebugUtils.currentLine=393279;
 //BA.debugLineNum = 393279;BA.debugLine="tim_msg.Enabled=True";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }}}}
;
 };
 };
RDebugUtils.currentLine=393288;
 //BA.debugLineNum = 393288;BA.debugLine="If job.JobName=\"chkupdate\" Then";
if ((_job._jobname /*String*/ ).equals("chkupdate")) { 
RDebugUtils.currentLine=393290;
 //BA.debugLineNum = 393290;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=393292;
 //BA.debugLineNum = 393292;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=393294;
 //BA.debugLineNum = 393294;BA.debugLine="Dim root1 As List";
_root1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=393295;
 //BA.debugLineNum = 393295;BA.debugLine="root1.Initialize";
_root1.Initialize();
RDebugUtils.currentLine=393296;
 //BA.debugLineNum = 393296;BA.debugLine="root1=parser.NextArray";
_root1 = _parser.NextArray();
RDebugUtils.currentLine=393298;
 //BA.debugLineNum = 393298;BA.debugLine="Dim str_type As String = root1.Get(0)";
_str_type = BA.ObjectToString(_root1.Get((int) (0)));
RDebugUtils.currentLine=393299;
 //BA.debugLineNum = 393299;BA.debugLine="str_type= str_type.Replace(\"type:\",\"\")";
_str_type = _str_type.replace("type:","");
RDebugUtils.currentLine=393301;
 //BA.debugLineNum = 393301;BA.debugLine="Dim str_version_code As String = root1.Get(1)";
_str_version_code = BA.ObjectToString(_root1.Get((int) (1)));
RDebugUtils.currentLine=393302;
 //BA.debugLineNum = 393302;BA.debugLine="str_version_code=str_version_code.Replace(\"ver";
_str_version_code = _str_version_code.replace("version_code:","");
RDebugUtils.currentLine=393304;
 //BA.debugLineNum = 393304;BA.debugLine="Dim str_version_name As String = root1.Get(2)";
_str_version_name = BA.ObjectToString(_root1.Get((int) (2)));
RDebugUtils.currentLine=393305;
 //BA.debugLineNum = 393305;BA.debugLine="str_version_name=str_version_name.Replace(\"ver";
_str_version_name = _str_version_name.replace("version_name:","");
RDebugUtils.currentLine=393307;
 //BA.debugLineNum = 393307;BA.debugLine="Dim str_changelog_fa As String = root1.Get(3)";
_str_changelog_fa = BA.ObjectToString(_root1.Get((int) (3)));
RDebugUtils.currentLine=393308;
 //BA.debugLineNum = 393308;BA.debugLine="str_changelog_fa=str_changelog_fa.Replace(\"cha";
_str_changelog_fa = _str_changelog_fa.replace("changelog_fa:","");
RDebugUtils.currentLine=393310;
 //BA.debugLineNum = 393310;BA.debugLine="Dim str_message As String = root1.Get(4)";
_str_message = BA.ObjectToString(_root1.Get((int) (4)));
RDebugUtils.currentLine=393311;
 //BA.debugLineNum = 393311;BA.debugLine="str_message=str_message.Replace(\"message:\",\"\")";
_str_message = _str_message.replace("message:","");
RDebugUtils.currentLine=393318;
 //BA.debugLineNum = 393318;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=393319;
 //BA.debugLineNum = 393319;BA.debugLine="pan_all_chekUpdate.Visible=True";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=393320;
 //BA.debugLineNum = 393320;BA.debugLine="If(str_type==\"success\")Then";
if (((_str_type).equals("success"))) { 
RDebugUtils.currentLine=393321;
 //BA.debugLineNum = 393321;BA.debugLine="If(str_version_code>Application.VersionCode)T";
if (((double)(Double.parseDouble(_str_version_code))>anywheresoftware.b4a.keywords.Common.Application.getVersionCode())) { 
RDebugUtils.currentLine=393322;
 //BA.debugLineNum = 393322;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl'";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body><span style='color:#3AAD00; font-weight: bold;'> بروزرسانی جدید موجود است. </span><br> "+_str_changelog_fa+"</body></html>");
RDebugUtils.currentLine=393323;
 //BA.debugLineNum = 393323;BA.debugLine="lbl_chk_update_ok.Tag=1";
mostCurrent._lbl_chk_update_ok.setTag((Object)(1));
RDebugUtils.currentLine=393324;
 //BA.debugLineNum = 393324;BA.debugLine="lbl_chk_update_ok.Text=\"بروزرسانی برنامه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("بروزرسانی برنامه"));
 }else {
RDebugUtils.currentLine=393326;
 //BA.debugLineNum = 393326;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl'";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body> برنامه شما بروز می باشد. با تشکر </body></html>");
RDebugUtils.currentLine=393327;
 //BA.debugLineNum = 393327;BA.debugLine="lbl_chk_update_ok.Tag=0";
mostCurrent._lbl_chk_update_ok.setTag((Object)(0));
RDebugUtils.currentLine=393328;
 //BA.debugLineNum = 393328;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("باشه"));
 };
 }else 
{RDebugUtils.currentLine=393331;
 //BA.debugLineNum = 393331;BA.debugLine="Else if (str_type==\"unsuccess\")Then";
if (((_str_type).equals("unsuccess"))) { 
RDebugUtils.currentLine=393332;
 //BA.debugLineNum = 393332;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl'>";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>خطا در اتصال</body></html>");
RDebugUtils.currentLine=393333;
 //BA.debugLineNum = 393333;BA.debugLine="lbl_chk_update_ok.Tag=0";
mostCurrent._lbl_chk_update_ok.setTag((Object)(0));
RDebugUtils.currentLine=393334;
 //BA.debugLineNum = 393334;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("باشه"));
 }}
;
 };
 }else {
 };
 } 
       catch (Exception e89) {
			processBA.setLastException(e89);RDebugUtils.currentLine=393347;
 //BA.debugLineNum = 393347;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("7393347",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=393348;
 //BA.debugLineNum = 393348;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=393351;
 //BA.debugLineNum = 393351;BA.debugLine="End Sub";
return "";
}
public static String  _kharid() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "kharid", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "kharid", null));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub kharid";
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="If(myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="Try";
try {RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="inapp.RequestPayment(\"ezafekari2\",\"inapp\",\"ezaf";
mostCurrent._inapp.RequestPayment(processBA,"ezafekari2","inapp","ezafekari2");
 } 
       catch (Exception e5) {
			processBA.setLastException(e5);RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="MsgboxAsync(\"1- از نصب بودن برنامه بازار اطمینا";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("1- از نصب بودن برنامه بازار اطمینان یابید."+anywheresoftware.b4a.keywords.Common.CRLF+" 2- برنامه ها را ببندید و دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 };
 }else {
RDebugUtils.currentLine=720908;
 //BA.debugLineNum = 720908;BA.debugLine="ToastMessageShow(\"خطا در اتصال \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال "),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=720911;
 //BA.debugLineNum = 720911;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_account_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_account_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_account_click", null));}
RDebugUtils.currentLine=8519680;
 //BA.debugLineNum = 8519680;BA.debugLine="Private Sub lbl_account_Click";
RDebugUtils.currentLine=8519684;
 //BA.debugLineNum = 8519684;BA.debugLine="If (File.Exists(File.DirInternal,\"userAcc\")=True";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=8519685;
 //BA.debugLineNum = 8519685;BA.debugLine="StartActivity(step2_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step2_activity.getObject()));
RDebugUtils.currentLine=8519686;
 //BA.debugLineNum = 8519686;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 }else {
RDebugUtils.currentLine=8519689;
 //BA.debugLineNum = 8519689;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=8519690;
 //BA.debugLineNum = 8519690;BA.debugLine="StartActivity(step0_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step0_activity.getObject()));
 }else {
RDebugUtils.currentLine=8519692;
 //BA.debugLineNum = 8519692;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 };
 };
RDebugUtils.currentLine=8519698;
 //BA.debugLineNum = 8519698;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
RDebugUtils.currentLine=8519699;
 //BA.debugLineNum = 8519699;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_litemenu_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_litemenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_litemenu_click", null));}
RDebugUtils.currentLine=7340032;
 //BA.debugLineNum = 7340032;BA.debugLine="Private Sub pan_all_liteMenu_Click";
RDebugUtils.currentLine=7340033;
 //BA.debugLineNum = 7340033;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7340034;
 //BA.debugLineNum = 7340034;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chk_update_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_chk_update_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_chk_update_click", null));}
String _send2 = "";
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Private Sub lbl_chk_update_Click";
RDebugUtils.currentLine=8454146;
 //BA.debugLineNum = 8454146;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=8454147;
 //BA.debugLineNum = 8454147;BA.debugLine="ProgressDialogShow(\"بررسی بروزرسانی ...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("بررسی بروزرسانی ..."));
RDebugUtils.currentLine=8454148;
 //BA.debugLineNum = 8454148;BA.debugLine="ht.Initialize(\"chkupdate\",Me)";
mostCurrent._ht._initialize /*String*/ (null,processBA,"chkupdate",main.getObject());
RDebugUtils.currentLine=8454149;
 //BA.debugLineNum = 8454149;BA.debugLine="Dim send2 As String";
_send2 = "";
RDebugUtils.currentLine=8454150;
 //BA.debugLineNum = 8454150;BA.debugLine="send2 = \"var=checkupdate\"";
_send2 = "var=checkupdate";
RDebugUtils.currentLine=8454151;
 //BA.debugLineNum = 8454151;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/chek_upda";
mostCurrent._ht._poststring /*String*/ (null,"https://taravatgroup.ir/chek_update.php",_send2);
 }else {
RDebugUtils.currentLine=8454153;
 //BA.debugLineNum = 8454153;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 };
RDebugUtils.currentLine=8454157;
 //BA.debugLineNum = 8454157;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
RDebugUtils.currentLine=8454158;
 //BA.debugLineNum = 8454158;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chk_update_ok_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_chk_update_ok_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_chk_update_ok_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _op = null;
RDebugUtils.currentLine=8716288;
 //BA.debugLineNum = 8716288;BA.debugLine="Private Sub lbl_chk_update_ok_Click";
RDebugUtils.currentLine=8716289;
 //BA.debugLineNum = 8716289;BA.debugLine="If (lbl_chk_update_ok.Tag==1)Then";
if (((mostCurrent._lbl_chk_update_ok.getTag()).equals((Object)(1)))) { 
RDebugUtils.currentLine=8716290;
 //BA.debugLineNum = 8716290;BA.debugLine="Try";
try {RDebugUtils.currentLine=8716291;
 //BA.debugLineNum = 8716291;BA.debugLine="Dim op As Intent";
_op = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=8716292;
 //BA.debugLineNum = 8716292;BA.debugLine="op.Initialize(op.ACTION_VIEW,\"bazaar://details?";
_op.Initialize(_op.ACTION_VIEW,"bazaar://details?id=ir.taravatgroup.ezafekari2");
RDebugUtils.currentLine=8716293;
 //BA.debugLineNum = 8716293;BA.debugLine="op.SetPackage(\"com.farsitel.bazaar\")";
_op.SetPackage("com.farsitel.bazaar");
RDebugUtils.currentLine=8716294;
 //BA.debugLineNum = 8716294;BA.debugLine="StartActivity(op)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_op.getObject()));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=8716296;
 //BA.debugLineNum = 8716296;BA.debugLine="myfunc.help_man(\"توجه\",\"برنامه بازار را نصب کنی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","برنامه بازار را نصب کنید !");
RDebugUtils.currentLine=8716298;
 //BA.debugLineNum = 8716298;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("78716298",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
RDebugUtils.currentLine=8716305;
 //BA.debugLineNum = 8716305;BA.debugLine="pan_all_chekUpdate_Click";
_pan_all_chekupdate_click();
RDebugUtils.currentLine=8716306;
 //BA.debugLineNum = 8716306;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_chekupdate_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_chekupdate_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_chekupdate_click", null));}
RDebugUtils.currentLine=8585216;
 //BA.debugLineNum = 8585216;BA.debugLine="Private Sub pan_all_chekUpdate_Click";
RDebugUtils.currentLine=8585217;
 //BA.debugLineNum = 8585217;BA.debugLine="pan_all_chekUpdate.Visible=False";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=8585218;
 //BA.debugLineNum = 8585218;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_ft_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_ft_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_ft_click", null));}
int _result = 0;
RDebugUtils.currentLine=7602176;
 //BA.debugLineNum = 7602176;BA.debugLine="Private Sub lbl_close_FT_Click";
RDebugUtils.currentLine=7602178;
 //BA.debugLineNum = 7602178;BA.debugLine="If(dbCode.isexist_taradod_by_date(myfunc.fa2en(pe";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate()))==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=7602179;
 //BA.debugLineNum = 7602179;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=7602180;
 //BA.debugLineNum = 7602180;BA.debugLine="result = Msgbox2(\"تردد و اضافه کاری امروز پاک شو";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("تردد و اضافه کاری امروز پاک شود؟"),BA.ObjectToCharSequence("توجه"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=7602181;
 //BA.debugLineNum = 7602181;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=7602183;
 //BA.debugLineNum = 7602183;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=7602185;
 //BA.debugLineNum = 7602185;BA.debugLine="dbCode.sql.ExecNonQuery(\"DELETE FROM tb_taradod";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("DELETE FROM tb_taradod WHERE date_from LIKE '%"+mostCurrent._lbl_date_ft.getText()+"%'; ");
RDebugUtils.currentLine=7602187;
 //BA.debugLineNum = 7602187;BA.debugLine="dbCode.sql.ExecNonQuery(\"DELETE FROM tb_ezafeka";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("DELETE FROM tb_ezafekari WHERE date_from LIKE '%"+mostCurrent._lbl_date_ft.getText()+"%'; ");
RDebugUtils.currentLine=7602188;
 //BA.debugLineNum = 7602188;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=7602189;
 //BA.debugLineNum = 7602189;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=7602191;
 //BA.debugLineNum = 7602191;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7602192;
 //BA.debugLineNum = 7602192;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=True";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7602193;
 //BA.debugLineNum = 7602193;BA.debugLine="lbl_tim_vorod_FT.Text=\"00:00\"";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=7602194;
 //BA.debugLineNum = 7602194;BA.debugLine="lbl_tim_khoroj_FT.Text=\"00:00\"";
mostCurrent._lbl_tim_khoroj_ft.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=7602195;
 //BA.debugLineNum = 7602195;BA.debugLine="lbl_time_show_FT.Text=\"\"";
mostCurrent._lbl_time_show_ft.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=7602196;
 //BA.debugLineNum = 7602196;BA.debugLine="et_tozihat_FT.Enabled=True";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7602197;
 //BA.debugLineNum = 7602197;BA.debugLine="et_tozihat_FT.Text=\"\"";
mostCurrent._et_tozihat_ft.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=7602198;
 //BA.debugLineNum = 7602198;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
 };
 }else {
RDebugUtils.currentLine=7602202;
 //BA.debugLineNum = 7602202;BA.debugLine="myfunc.help_man(\"توجه\",\"برای امروز هنوز ترددی ثب";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","برای امروز هنوز ترددی ثبت نشده است");
RDebugUtils.currentLine=7602203;
 //BA.debugLineNum = 7602203;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
 };
RDebugUtils.currentLine=7602206;
 //BA.debugLineNum = 7602206;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_msgnewy_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_msgnewy_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_msgnewy_click", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Private Sub lbl_close_msgNewY_Click";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date1_click", null));}
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Private Sub lbl_date1_Click";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="lbl_tim1_Click";
_lbl_tim1_click();
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_tim1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_tim1_click", null));}
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="Private Sub lbl_tim1_Click";
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="index_piker=1";
_index_piker = (int) (1);
RDebugUtils.currentLine=5242883;
 //BA.debugLineNum = 5242883;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim1.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (0))));
RDebugUtils.currentLine=5242884;
 //BA.debugLineNum = 5242884;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim1.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (1))));
RDebugUtils.currentLine=5242886;
 //BA.debugLineNum = 5242886;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date1.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (0))));
RDebugUtils.currentLine=5242887;
 //BA.debugLineNum = 5242887;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (1)));
RDebugUtils.currentLine=5242888;
 //BA.debugLineNum = 5242888;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=5242889;
 //BA.debugLineNum = 5242889;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (2))));
RDebugUtils.currentLine=5242893;
 //BA.debugLineNum = 5242893;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5242895;
 //BA.debugLineNum = 5242895;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=5242896;
 //BA.debugLineNum = 5242896;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=5242897;
 //BA.debugLineNum = 5242897;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
RDebugUtils.currentLine=5242898;
 //BA.debugLineNum = 5242898;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
RDebugUtils.currentLine=5242899;
 //BA.debugLineNum = 5242899;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
RDebugUtils.currentLine=5242902;
 //BA.debugLineNum = 5242902;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date2_click", null));}
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Private Sub lbl_date2_Click";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="lbl_tim2_Click";
_lbl_tim2_click();
RDebugUtils.currentLine=5111810;
 //BA.debugLineNum = 5111810;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_tim2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_tim2_click", null));}
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Private Sub lbl_tim2_Click";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="index_piker=2";
_index_piker = (int) (2);
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim2.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (0))));
RDebugUtils.currentLine=5046275;
 //BA.debugLineNum = 5046275;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim2.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (1))));
RDebugUtils.currentLine=5046277;
 //BA.debugLineNum = 5046277;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date2.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (0))));
RDebugUtils.currentLine=5046278;
 //BA.debugLineNum = 5046278;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (1)));
RDebugUtils.currentLine=5046279;
 //BA.debugLineNum = 5046279;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=5046280;
 //BA.debugLineNum = 5046280;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (2))));
RDebugUtils.currentLine=5046283;
 //BA.debugLineNum = 5046283;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5046286;
 //BA.debugLineNum = 5046286;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=5046287;
 //BA.debugLineNum = 5046287;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=5046288;
 //BA.debugLineNum = 5046288;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
RDebugUtils.currentLine=5046289;
 //BA.debugLineNum = 5046289;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
RDebugUtils.currentLine=5046290;
 //BA.debugLineNum = 5046290;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
RDebugUtils.currentLine=5046292;
 //BA.debugLineNum = 5046292;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_from_list_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Private Sub lbl_edit_from_list_Click";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=6094851;
 //BA.debugLineNum = 6094851;BA.debugLine="Log(b.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("76094851",BA.ObjectToString(_b.getTag()),0);
RDebugUtils.currentLine=6094852;
 //BA.debugLineNum = 6094852;BA.debugLine="current_id_edit=b.Tag";
_current_id_edit = (int)(BA.ObjectToNumber(_b.getTag()));
RDebugUtils.currentLine=6094855;
 //BA.debugLineNum = 6094855;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
RDebugUtils.currentLine=6094856;
 //BA.debugLineNum = 6094856;BA.debugLine="pan_add_ezafekari_Click";
_pan_add_ezafekari_click();
RDebugUtils.currentLine=6094857;
 //BA.debugLineNum = 6094857;BA.debugLine="lbl_box_title.Text=\"ویرایش اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش اضافه کاری"));
 }else 
{RDebugUtils.currentLine=6094859;
 //BA.debugLineNum = 6094859;BA.debugLine="Else if (TabHost1.CurrentTab=1)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==1)) { 
RDebugUtils.currentLine=6094860;
 //BA.debugLineNum = 6094860;BA.debugLine="pan_add_morakhasi_Click";
_pan_add_morakhasi_click();
RDebugUtils.currentLine=6094861;
 //BA.debugLineNum = 6094861;BA.debugLine="lbl_box_title.Text=\"ویرایش مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش مرخصی"));
 }else 
{RDebugUtils.currentLine=6094863;
 //BA.debugLineNum = 6094863;BA.debugLine="Else if (TabHost1.CurrentTab=2)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==2)) { 
RDebugUtils.currentLine=6094864;
 //BA.debugLineNum = 6094864;BA.debugLine="pan_add_taradod_Click";
_pan_add_taradod_click();
RDebugUtils.currentLine=6094865;
 //BA.debugLineNum = 6094865;BA.debugLine="lbl_box_title.Text=\"ویرایش تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش تردد"));
RDebugUtils.currentLine=6094866;
 //BA.debugLineNum = 6094866;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6094867;
 //BA.debugLineNum = 6094867;BA.debugLine="lbl_ezaf_taradod.Visible=False";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }}}
;
RDebugUtils.currentLine=6094869;
 //BA.debugLineNum = 6094869;BA.debugLine="is_for_edit=True";
_is_for_edit = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=6094870;
 //BA.debugLineNum = 6094870;BA.debugLine="get_dataEdit_byId(current_id_edit)";
_get_dataedit_byid(_current_id_edit);
RDebugUtils.currentLine=6094880;
 //BA.debugLineNum = 6094880;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=6094883;
 //BA.debugLineNum = 6094883;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_ezafekari_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_ezafekari_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_ezafekari_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_temp_time1 = null;
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Private Sub pan_add_ezafekari_Click";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="lbl_box_title.Text=\"ثبت اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت اضافه کاری"));
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
RDebugUtils.currentLine=2949127;
 //BA.debugLineNum = 2949127;BA.debugLine="index_box=1";
_index_box = (int) (1);
RDebugUtils.currentLine=2949128;
 //BA.debugLineNum = 2949128;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=2949129;
 //BA.debugLineNum = 2949129;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=2949130;
 //BA.debugLineNum = 2949130;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2949131;
 //BA.debugLineNum = 2949131;BA.debugLine="lbl_ezaf_taradod.Text=\"فوق العاده (جمعه کاری)\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("فوق العاده (جمعه کاری)"));
RDebugUtils.currentLine=2949132;
 //BA.debugLineNum = 2949132;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2949133;
 //BA.debugLineNum = 2949133;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2949134;
 //BA.debugLineNum = 2949134;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2949135;
 //BA.debugLineNum = 2949135;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2949141;
 //BA.debugLineNum = 2949141;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
RDebugUtils.currentLine=2949142;
 //BA.debugLineNum = 2949142;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
RDebugUtils.currentLine=2949143;
 //BA.debugLineNum = 2949143;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=2949144;
 //BA.debugLineNum = 2949144;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
RDebugUtils.currentLine=2949147;
 //BA.debugLineNum = 2949147;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=2949148;
 //BA.debugLineNum = 2949148;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=2949153;
 //BA.debugLineNum = 2949153;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_time1.txt\")";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time1.txt"))) { 
RDebugUtils.currentLine=2949154;
 //BA.debugLineNum = 2949154;BA.debugLine="Dim ls_temp_time1 As List";
_ls_temp_time1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2949155;
 //BA.debugLineNum = 2949155;BA.debugLine="ls_temp_time1.Initialize";
_ls_temp_time1.Initialize();
RDebugUtils.currentLine=2949156;
 //BA.debugLineNum = 2949156;BA.debugLine="ls_temp_time1=File.ReadList(File.DirInternal,\"te";
_ls_temp_time1 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time1.txt");
RDebugUtils.currentLine=2949158;
 //BA.debugLineNum = 2949158;BA.debugLine="lbl_tim1.Text=ls_temp_time1.Get(0)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_temp_time1.Get((int) (0))));
RDebugUtils.currentLine=2949159;
 //BA.debugLineNum = 2949159;BA.debugLine="lbl_tim2.Text=ls_temp_time1.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_temp_time1.Get((int) (1))));
RDebugUtils.currentLine=2949160;
 //BA.debugLineNum = 2949160;BA.debugLine="time_show";
_time_show();
 }else {
RDebugUtils.currentLine=2949162;
 //BA.debugLineNum = 2949162;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=2949163;
 //BA.debugLineNum = 2949163;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=2949167;
 //BA.debugLineNum = 2949167;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_morakhasi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_morakhasi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_morakhasi_click", null));}
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Private Sub pan_add_morakhasi_Click";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="lbl_box_title.Text=\"ثبت مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت مرخصی"));
RDebugUtils.currentLine=2752517;
 //BA.debugLineNum = 2752517;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
RDebugUtils.currentLine=2752518;
 //BA.debugLineNum = 2752518;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
RDebugUtils.currentLine=2752519;
 //BA.debugLineNum = 2752519;BA.debugLine="index_box=2";
_index_box = (int) (2);
RDebugUtils.currentLine=2752520;
 //BA.debugLineNum = 2752520;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=2752521;
 //BA.debugLineNum = 2752521;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=2752522;
 //BA.debugLineNum = 2752522;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
RDebugUtils.currentLine=2752523;
 //BA.debugLineNum = 2752523;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2752524;
 //BA.debugLineNum = 2752524;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
RDebugUtils.currentLine=2752525;
 //BA.debugLineNum = 2752525;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Red";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2752526;
 //BA.debugLineNum = 2752526;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2752527;
 //BA.debugLineNum = 2752527;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2752531;
 //BA.debugLineNum = 2752531;BA.debugLine="rsPOP_noe.Initialize(\"rsPOP_noe\",lbl_ezaf_taradod";
mostCurrent._rspop_noe.Initialize(mostCurrent.activityBA,"rsPOP_noe",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_ezaf_taradod.getObject())));
RDebugUtils.currentLine=2752533;
 //BA.debugLineNum = 2752533;BA.debugLine="rsPOP_noe.AddMenuItem(0,0,\"استحقاقی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (0),(int) (0),"استحقاقی");
RDebugUtils.currentLine=2752534;
 //BA.debugLineNum = 2752534;BA.debugLine="rsPOP_noe.AddMenuItem(1,1,\"استعلاجی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (1),(int) (1),"استعلاجی");
RDebugUtils.currentLine=2752535;
 //BA.debugLineNum = 2752535;BA.debugLine="rsPOP_noe.AddMenuItem(2,2,\"سایر (با حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (2),(int) (2),"سایر (با حقوق)");
RDebugUtils.currentLine=2752536;
 //BA.debugLineNum = 2752536;BA.debugLine="rsPOP_noe.AddMenuItem(3,3,\"سایر (بدون حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (3),(int) (3),"سایر (بدون حقوق)");
RDebugUtils.currentLine=2752541;
 //BA.debugLineNum = 2752541;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
RDebugUtils.currentLine=2752542;
 //BA.debugLineNum = 2752542;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
RDebugUtils.currentLine=2752543;
 //BA.debugLineNum = 2752543;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=2752544;
 //BA.debugLineNum = 2752544;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
RDebugUtils.currentLine=2752547;
 //BA.debugLineNum = 2752547;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=2752548;
 //BA.debugLineNum = 2752548;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=2752550;
 //BA.debugLineNum = 2752550;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=2752551;
 //BA.debugLineNum = 2752551;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=2752555;
 //BA.debugLineNum = 2752555;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_taradod_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_taradod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_taradod_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_temp_time2 = null;
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Private Sub pan_add_taradod_Click";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="lbl_box_title.Text=\"ثبت تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت تردد"));
RDebugUtils.currentLine=3014661;
 //BA.debugLineNum = 3014661;BA.debugLine="lbl_time_as.Text=\"ورود :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("ورود :"));
RDebugUtils.currentLine=3014662;
 //BA.debugLineNum = 3014662;BA.debugLine="lbl_time_ta.Text=\"خروج :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("خروج :"));
RDebugUtils.currentLine=3014663;
 //BA.debugLineNum = 3014663;BA.debugLine="index_box=3";
_index_box = (int) (3);
RDebugUtils.currentLine=3014664;
 //BA.debugLineNum = 3014664;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3014665;
 //BA.debugLineNum = 3014665;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3014666;
 //BA.debugLineNum = 3014666;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3014667;
 //BA.debugLineNum = 3014667;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3014668;
 //BA.debugLineNum = 3014668;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3014670;
 //BA.debugLineNum = 3014670;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3014671;
 //BA.debugLineNum = 3014671;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3014672;
 //BA.debugLineNum = 3014672;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3014674;
 //BA.debugLineNum = 3014674;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
RDebugUtils.currentLine=3014675;
 //BA.debugLineNum = 3014675;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
RDebugUtils.currentLine=3014676;
 //BA.debugLineNum = 3014676;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=3014677;
 //BA.debugLineNum = 3014677;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
RDebugUtils.currentLine=3014680;
 //BA.debugLineNum = 3014680;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3014681;
 //BA.debugLineNum = 3014681;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3014685;
 //BA.debugLineNum = 3014685;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_time2.txt\")";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time2.txt"))) { 
RDebugUtils.currentLine=3014686;
 //BA.debugLineNum = 3014686;BA.debugLine="Dim ls_temp_time2 As List";
_ls_temp_time2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3014687;
 //BA.debugLineNum = 3014687;BA.debugLine="ls_temp_time2.Initialize";
_ls_temp_time2.Initialize();
RDebugUtils.currentLine=3014688;
 //BA.debugLineNum = 3014688;BA.debugLine="ls_temp_time2=File.ReadList(File.DirInternal,\"te";
_ls_temp_time2 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time2.txt");
RDebugUtils.currentLine=3014690;
 //BA.debugLineNum = 3014690;BA.debugLine="lbl_tim1.Text=ls_temp_time2.Get(0)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_temp_time2.Get((int) (0))));
RDebugUtils.currentLine=3014691;
 //BA.debugLineNum = 3014691;BA.debugLine="lbl_tim2.Text=ls_temp_time2.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_temp_time2.Get((int) (1))));
RDebugUtils.currentLine=3014692;
 //BA.debugLineNum = 3014692;BA.debugLine="time_show";
_time_show();
 }else {
RDebugUtils.currentLine=3014694;
 //BA.debugLineNum = 3014694;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=3014695;
 //BA.debugLineNum = 3014695;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=3014699;
 //BA.debugLineNum = 3014699;BA.debugLine="End Sub";
return "";
}
public static String  _time_show() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time_show", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "time_show", null));}
anywheresoftware.b4a.objects.collections.List _list_date_per1 = null;
anywheresoftware.b4a.objects.collections.List _list_date_per2 = null;
anywheresoftware.b4a.objects.collections.List _list_date_miladi1 = null;
anywheresoftware.b4a.objects.collections.List _list_date_miladi2 = null;
String _dat_mil_2 = "";
String _dat_mil_1 = "";
String _date_end1 = "";
String _date_end2 = "";
String _time_end1 = "";
String _time_end2 = "";
long _tim1_long = 0L;
long _tim2_long = 0L;
b4a.example.dateutils._period _period_between = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _str_show = null;
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub time_show";
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="Try";
try {RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3604487;
 //BA.debugLineNum = 3604487;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
RDebugUtils.currentLine=3604488;
 //BA.debugLineNum = 3604488;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
RDebugUtils.currentLine=3604490;
 //BA.debugLineNum = 3604490;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=3604491;
 //BA.debugLineNum = 3604491;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=3604492;
 //BA.debugLineNum = 3604492;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=3604493;
 //BA.debugLineNum = 3604493;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=3604495;
 //BA.debugLineNum = 3604495;BA.debugLine="Select pik_moon1.Tag";
switch (BA.switchObjectToInt(mostCurrent._pik_moon1.getTag(),(Object)(1),(Object)(2),(Object)(3),(Object)(4),(Object)(5),(Object)(6),(Object)(7),(Object)(8),(Object)(9),(Object)(10),(Object)(11),(Object)(12))) {
case 0: {
RDebugUtils.currentLine=3604497;
 //BA.debugLineNum = 3604497;BA.debugLine="pik_moon1.Tag=\"01\"";
mostCurrent._pik_moon1.setTag((Object)("01"));
 break; }
case 1: {
RDebugUtils.currentLine=3604499;
 //BA.debugLineNum = 3604499;BA.debugLine="pik_moon1.Tag=\"02\"";
mostCurrent._pik_moon1.setTag((Object)("02"));
 break; }
case 2: {
RDebugUtils.currentLine=3604501;
 //BA.debugLineNum = 3604501;BA.debugLine="pik_moon1.Tag=\"03\"";
mostCurrent._pik_moon1.setTag((Object)("03"));
 break; }
case 3: {
RDebugUtils.currentLine=3604503;
 //BA.debugLineNum = 3604503;BA.debugLine="pik_moon1.Tag=\"04\"";
mostCurrent._pik_moon1.setTag((Object)("04"));
 break; }
case 4: {
RDebugUtils.currentLine=3604505;
 //BA.debugLineNum = 3604505;BA.debugLine="pik_moon1.Tag=\"05\"";
mostCurrent._pik_moon1.setTag((Object)("05"));
 break; }
case 5: {
RDebugUtils.currentLine=3604507;
 //BA.debugLineNum = 3604507;BA.debugLine="pik_moon1.Tag=\"06\"";
mostCurrent._pik_moon1.setTag((Object)("06"));
 break; }
case 6: {
RDebugUtils.currentLine=3604509;
 //BA.debugLineNum = 3604509;BA.debugLine="pik_moon1.Tag=\"07\"";
mostCurrent._pik_moon1.setTag((Object)("07"));
 break; }
case 7: {
RDebugUtils.currentLine=3604511;
 //BA.debugLineNum = 3604511;BA.debugLine="pik_moon1.Tag=\"08\"";
mostCurrent._pik_moon1.setTag((Object)("08"));
 break; }
case 8: {
RDebugUtils.currentLine=3604513;
 //BA.debugLineNum = 3604513;BA.debugLine="pik_moon1.Tag=\"09\"";
mostCurrent._pik_moon1.setTag((Object)("09"));
 break; }
case 9: {
RDebugUtils.currentLine=3604515;
 //BA.debugLineNum = 3604515;BA.debugLine="pik_moon1.Tag=\"10\"";
mostCurrent._pik_moon1.setTag((Object)("10"));
 break; }
case 10: {
RDebugUtils.currentLine=3604517;
 //BA.debugLineNum = 3604517;BA.debugLine="pik_moon1.Tag=\"11\"";
mostCurrent._pik_moon1.setTag((Object)("11"));
 break; }
case 11: {
RDebugUtils.currentLine=3604519;
 //BA.debugLineNum = 3604519;BA.debugLine="pik_moon1.Tag=\"12\"";
mostCurrent._pik_moon1.setTag((Object)("12"));
 break; }
}
;
RDebugUtils.currentLine=3604525;
 //BA.debugLineNum = 3604525;BA.debugLine="date1=lbl_date1.Text";
mostCurrent._date1 = mostCurrent._lbl_date1.getText();
RDebugUtils.currentLine=3604526;
 //BA.debugLineNum = 3604526;BA.debugLine="date2=lbl_date2.Text";
mostCurrent._date2 = mostCurrent._lbl_date2.getText();
RDebugUtils.currentLine=3604527;
 //BA.debugLineNum = 3604527;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
RDebugUtils.currentLine=3604528;
 //BA.debugLineNum = 3604528;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
RDebugUtils.currentLine=3604532;
 //BA.debugLineNum = 3604532;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_dat";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=3604533;
 //BA.debugLineNum = 3604533;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_dat";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=3604536;
 //BA.debugLineNum = 3604536;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=3604537;
 //BA.debugLineNum = 3604537;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=3604540;
 //BA.debugLineNum = 3604540;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
RDebugUtils.currentLine=3604541;
 //BA.debugLineNum = 3604541;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
RDebugUtils.currentLine=3604543;
 //BA.debugLineNum = 3604543;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date_";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=3604544;
 //BA.debugLineNum = 3604544;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date_";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=3604546;
 //BA.debugLineNum = 3604546;BA.debugLine="time_end2=lbl_tim2.Text&\":00\"";
_time_end2 = mostCurrent._lbl_tim2.getText()+":00";
RDebugUtils.currentLine=3604547;
 //BA.debugLineNum = 3604547;BA.debugLine="time_end1=lbl_tim1.Text&\":00\"";
_time_end1 = mostCurrent._lbl_tim1.getText()+":00";
RDebugUtils.currentLine=3604549;
 //BA.debugLineNum = 3604549;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
RDebugUtils.currentLine=3604550;
 //BA.debugLineNum = 3604550;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
RDebugUtils.currentLine=3604551;
 //BA.debugLineNum = 3604551;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
RDebugUtils.currentLine=3604552;
 //BA.debugLineNum = 3604552;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
RDebugUtils.currentLine=3604556;
 //BA.debugLineNum = 3604556;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
RDebugUtils.currentLine=3604557;
 //BA.debugLineNum = 3604557;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
RDebugUtils.currentLine=3604560;
 //BA.debugLineNum = 3604560;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=3604561;
 //BA.debugLineNum = 3604561;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
RDebugUtils.currentLine=3604563;
 //BA.debugLineNum = 3604563;BA.debugLine="If (period_between.Years<>0)Then";
if ((_period_between.Years!=0)) { 
RDebugUtils.currentLine=3604564;
 //BA.debugLineNum = 3604564;BA.debugLine="str_show.Append(period_between.Years&\" سال \").A";
_str_show.Append(BA.NumberToString(_period_between.Years)+" سال ").Append(" و ");
 };
RDebugUtils.currentLine=3604566;
 //BA.debugLineNum = 3604566;BA.debugLine="If (period_between.Months<>0)Then";
if ((_period_between.Months!=0)) { 
RDebugUtils.currentLine=3604567;
 //BA.debugLineNum = 3604567;BA.debugLine="str_show.Append(period_between.Months&\" ماه \").";
_str_show.Append(BA.NumberToString(_period_between.Months)+" ماه ").Append(" و ");
 };
RDebugUtils.currentLine=3604569;
 //BA.debugLineNum = 3604569;BA.debugLine="If (period_between.Days<>0)Then";
if ((_period_between.Days!=0)) { 
RDebugUtils.currentLine=3604570;
 //BA.debugLineNum = 3604570;BA.debugLine="str_show.Append(period_between.Days&\" روز \").Ap";
_str_show.Append(BA.NumberToString(_period_between.Days)+" روز ").Append(" و ");
 };
RDebugUtils.currentLine=3604573;
 //BA.debugLineNum = 3604573;BA.debugLine="str_show.Append(period_between.Hours&\" ساعت \").A";
_str_show.Append(BA.NumberToString(_period_between.Hours)+" ساعت ").Append(" و ");
RDebugUtils.currentLine=3604574;
 //BA.debugLineNum = 3604574;BA.debugLine="str_show.Append(period_between.Minutes&\" دقیقه \"";
_str_show.Append(BA.NumberToString(_period_between.Minutes)+" دقیقه ");
RDebugUtils.currentLine=3604577;
 //BA.debugLineNum = 3604577;BA.debugLine="year_bt=period_between.Years";
_year_bt = _period_between.Years;
RDebugUtils.currentLine=3604578;
 //BA.debugLineNum = 3604578;BA.debugLine="moon_bt=period_between.Months";
_moon_bt = _period_between.Months;
RDebugUtils.currentLine=3604579;
 //BA.debugLineNum = 3604579;BA.debugLine="day_bt=period_between.Days";
_day_bt = _period_between.Days;
RDebugUtils.currentLine=3604580;
 //BA.debugLineNum = 3604580;BA.debugLine="hour_bt=period_between.Hours";
_hour_bt = _period_between.Hours;
RDebugUtils.currentLine=3604581;
 //BA.debugLineNum = 3604581;BA.debugLine="min_bt=period_between.Minutes";
_min_bt = _period_between.Minutes;
RDebugUtils.currentLine=3604584;
 //BA.debugLineNum = 3604584;BA.debugLine="lbl_time_show.Text=str_show";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(_str_show.getObject()));
RDebugUtils.currentLine=3604585;
 //BA.debugLineNum = 3604585;BA.debugLine="If(index_box=3)Then";
if ((_index_box==3)) { 
RDebugUtils.currentLine=3604587;
 //BA.debugLineNum = 3604587;BA.debugLine="tim_min=(hour_bt*60)+min_bt";
_tim_min = (int) ((_hour_bt*60)+_min_bt);
RDebugUtils.currentLine=3604591;
 //BA.debugLineNum = 3604591;BA.debugLine="If(tim_min>saat_kar_min) Then";
if ((_tim_min>_saat_kar_min)) { 
RDebugUtils.currentLine=3604592;
 //BA.debugLineNum = 3604592;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3604596;
 //BA.debugLineNum = 3604596;BA.debugLine="lbl_ezaf_taradod.Text=\"افزودن به اضافه کاری \"&";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("افزودن به اضافه کاری "+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (0))))+" ساعت و "+BA.ObjectToString(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (1)))+" دقیقه "));
 }else {
RDebugUtils.currentLine=3604600;
 //BA.debugLineNum = 3604600;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3604601;
 //BA.debugLineNum = 3604601;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 } 
       catch (Exception e86) {
			processBA.setLastException(e86);RDebugUtils.currentLine=3604609;
 //BA.debugLineNum = 3604609;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=3604611;
 //BA.debugLineNum = 3604611;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_ezaf_taradod_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_ezaf_taradod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_ezaf_taradod_click", null));}
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Private Sub lbl_ezaf_taradod_Click";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="If(index_box=2)Then";
if ((_index_box==2)) { 
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="rsPOP_noe.Show";
mostCurrent._rspop_noe.Show();
 };
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_ft_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_ft_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_ft_click", null));}
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Private Sub lbl_help_FT_Click";
RDebugUtils.currentLine=8192001;
 //BA.debugLineNum = 8192001;BA.debugLine="myfunc.help_man(\"راهنما\",\"برای ثبت ورود یا خروج ا";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","برای ثبت ورود یا خروج انگشت خود را در قسمت مشخص شده 3 ثانیه نگه دارید.");
RDebugUtils.currentLine=8192002;
 //BA.debugLineNum = 8192002;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_piker_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_piker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_piker_click", null));}
RDebugUtils.currentLine=6881280;
 //BA.debugLineNum = 6881280;BA.debugLine="Private Sub lbl_help_piker_Click";
RDebugUtils.currentLine=6881282;
 //BA.debugLineNum = 6881282;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
RDebugUtils.currentLine=6881284;
 //BA.debugLineNum = 6881284;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
RDebugUtils.currentLine=6881285;
 //BA.debugLineNum = 6881285;BA.debugLine="lbl_close_help.Visible=False";
mostCurrent._lbl_close_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6881286;
 //BA.debugLineNum = 6881286;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6881288;
 //BA.debugLineNum = 6881288;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help2_click", null));}
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Private Sub lbl_help2_Click";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=6356994;
 //BA.debugLineNum = 6356994;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_khoroj_ft_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_khoroj_ft_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_khoroj_ft_click", null));}
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Private Sub lbl_khoroj_FT_Click";
RDebugUtils.currentLine=7798785;
 //BA.debugLineNum = 7798785;BA.debugLine="ToastMessageShow(\"انگشت خود را 3 ثانیه نگه دارید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("انگشت خود را 3 ثانیه نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_khoroj_ft_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_khoroj_ft_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_khoroj_ft_longclick", null));}
RDebugUtils.currentLine=7929856;
 //BA.debugLineNum = 7929856;BA.debugLine="Private Sub lbl_khoroj_FT_LongClick";
RDebugUtils.currentLine=7929857;
 //BA.debugLineNum = 7929857;BA.debugLine="If(code_fast_taradod=10 Or code_fast_taradod=20)T";
if ((_code_fast_taradod==10 || _code_fast_taradod==20)) { 
RDebugUtils.currentLine=7929858;
 //BA.debugLineNum = 7929858;BA.debugLine="index_box=4";
_index_box = (int) (4);
RDebugUtils.currentLine=7929859;
 //BA.debugLineNum = 7929859;BA.debugLine="lbl_tim_khoroj_FT.Text=DateTime.Time(DateTime.No";
mostCurrent._lbl_tim_khoroj_ft.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
RDebugUtils.currentLine=7929860;
 //BA.debugLineNum = 7929860;BA.debugLine="add_taradod_fast";
_add_taradod_fast();
RDebugUtils.currentLine=7929861;
 //BA.debugLineNum = 7929861;BA.debugLine="code_fast_taradod=11";
_code_fast_taradod = (int) (11);
 }else 
{RDebugUtils.currentLine=7929862;
 //BA.debugLineNum = 7929862;BA.debugLine="Else If(code_fast_taradod=0)Then";
if ((_code_fast_taradod==0)) { 
RDebugUtils.currentLine=7929863;
 //BA.debugLineNum = 7929863;BA.debugLine="ToastMessageShow(\"تردد امروز دستی ثبت شده است\",F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تردد امروز دستی ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=7929864;
 //BA.debugLineNum = 7929864;BA.debugLine="Else If(code_fast_taradod=1)Then";
if ((_code_fast_taradod==1)) { 
RDebugUtils.currentLine=7929865;
 //BA.debugLineNum = 7929865;BA.debugLine="ToastMessageShow(\"ابتدا قسمت ورود را بزنید\",Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ابتدا قسمت ورود را بزنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=7929867;
 //BA.debugLineNum = 7929867;BA.debugLine="ToastMessageShow(\"زمان خروج ثبت شده است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("زمان خروج ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }}}
;
RDebugUtils.currentLine=7929869;
 //BA.debugLineNum = 7929869;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_lite_menu_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_lite_menu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_lite_menu_click", null));}
RDebugUtils.currentLine=7274496;
 //BA.debugLineNum = 7274496;BA.debugLine="Private Sub lbl_lite_menu_Click";
RDebugUtils.currentLine=7274497;
 //BA.debugLineNum = 7274497;BA.debugLine="pan_all_liteMenu.Visible=True";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7274498;
 //BA.debugLineNum = 7274498;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_notefi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_notefi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_notefi_click", null));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _html = null;
int _i = 0;
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub lbl_notefi_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="lbl_title_msgPan.Text=\"پیام ها\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام ها"));
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="pan_notif.Top=10%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="pan_notif.Height=70%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="Dim html As StringBuilder";
_html = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="html.Initialize";
_html.Initialize();
RDebugUtils.currentLine=524299;
 //BA.debugLineNum = 524299;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1"))) { 
RDebugUtils.currentLine=524301;
 //BA.debugLineNum = 524301;BA.debugLine="html.Append(\"<!DOCTYPE html><html><meta charset=";
_html.Append("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'>");
RDebugUtils.currentLine=524302;
 //BA.debugLineNum = 524302;BA.debugLine="For i = ls1.Size-1 To 0 Step -1";
{
final int step10 = -1;
final int limit10 = (int) (0);
_i = (int) (mostCurrent._ls1.getSize()-1) ;
for (;_i >= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=524303;
 //BA.debugLineNum = 524303;BA.debugLine="html.Append(\"<div style='background-color: #99f";
_html.Append("<div style='background-color: #99ffff; font-size: 13px;'>"+"کد پیام : "+BA.ObjectToString(mostCurrent._ls1.Get(_i))+" - مورخ : "+BA.ObjectToString(mostCurrent._ls3.Get(_i))+"</div><div style='background-color: #e6ffff; font-size: 16px;'><br>"+BA.ObjectToString(mostCurrent._ls2.Get(_i))).Append("<br></div><br>");
 }
};
RDebugUtils.currentLine=524305;
 //BA.debugLineNum = 524305;BA.debugLine="html.Append(\"</body></html>\")";
_html.Append("</body></html>");
RDebugUtils.currentLine=524308;
 //BA.debugLineNum = 524308;BA.debugLine="web_msg_show.LoadHtml(html.ToString)";
mostCurrent._web_msg_show.LoadHtml(_html.ToString());
 }else {
RDebugUtils.currentLine=524311;
 //BA.debugLineNum = 524311;BA.debugLine="web_msg_show.LoadHtml(\"<html><body dir='rtl'>لیس";
mostCurrent._web_msg_show.LoadHtml("<html><body dir='rtl'>لیست پیام خالی ... </body></html>");
 };
RDebugUtils.currentLine=524315;
 //BA.debugLineNum = 524315;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_remove_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_remove_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Private Sub lbl_remove_from_list_Click";
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=6225923;
 //BA.debugLineNum = 6225923;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=6225925;
 //BA.debugLineNum = 6225925;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
RDebugUtils.currentLine=6225926;
 //BA.debugLineNum = 6225926;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=6225927;
 //BA.debugLineNum = 6225927;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=6225928;
 //BA.debugLineNum = 6225928;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=6225930;
 //BA.debugLineNum = 6225930;BA.debugLine="If (dbCode.delete_ezafekari(b.Tag))Then";
if ((mostCurrent._dbcode._delete_ezafekari /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=6225931;
 //BA.debugLineNum = 6225931;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6225933;
 //BA.debugLineNum = 6225933;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
RDebugUtils.currentLine=6225936;
 //BA.debugLineNum = 6225936;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else 
{RDebugUtils.currentLine=6225939;
 //BA.debugLineNum = 6225939;BA.debugLine="Else if (TabHost1.CurrentTab=1)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==1)) { 
RDebugUtils.currentLine=6225941;
 //BA.debugLineNum = 6225941;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=6225942;
 //BA.debugLineNum = 6225942;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=6225943;
 //BA.debugLineNum = 6225943;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=6225945;
 //BA.debugLineNum = 6225945;BA.debugLine="If (dbCode.delete_morakhasi(b.Tag))Then";
if ((mostCurrent._dbcode._delete_morakhasi /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=6225946;
 //BA.debugLineNum = 6225946;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6225947;
 //BA.debugLineNum = 6225947;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
RDebugUtils.currentLine=6225948;
 //BA.debugLineNum = 6225948;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else 
{RDebugUtils.currentLine=6225952;
 //BA.debugLineNum = 6225952;BA.debugLine="Else if (TabHost1.CurrentTab=2)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==2)) { 
RDebugUtils.currentLine=6225953;
 //BA.debugLineNum = 6225953;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=6225954;
 //BA.debugLineNum = 6225954;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=6225955;
 //BA.debugLineNum = 6225955;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=6225957;
 //BA.debugLineNum = 6225957;BA.debugLine="If (dbCode.delete_taradod(b.Tag))Then";
if ((mostCurrent._dbcode._delete_taradod /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=6225958;
 //BA.debugLineNum = 6225958;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6225960;
 //BA.debugLineNum = 6225960;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
RDebugUtils.currentLine=6225961;
 //BA.debugLineNum = 6225961;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }}}
;
RDebugUtils.currentLine=6225972;
 //BA.debugLineNum = 6225972;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_remove_from_list2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_remove_from_list2_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Private Sub lbl_remove_from_list2_Click";
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=6291461;
 //BA.debugLineNum = 6291461;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=6291462;
 //BA.debugLineNum = 6291462;BA.debugLine="result = Msgbox2(\"آیا این گزارش حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این گزارش حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=6291463;
 //BA.debugLineNum = 6291463;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=6291465;
 //BA.debugLineNum = 6291465;BA.debugLine="If (dbCode.delete_gozaresh(b.tag))Then";
if ((mostCurrent._dbcode._delete_gozaresh /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=6291466;
 //BA.debugLineNum = 6291466;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6291467;
 //BA.debugLineNum = 6291467;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedI";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
 };
 };
RDebugUtils.currentLine=6291472;
 //BA.debugLineNum = 6291472;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_box_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_box_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_box_click", null));}
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Private Sub lbl_save_box_Click";
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="add_end";
_add_end();
RDebugUtils.currentLine=3211271;
 //BA.debugLineNum = 3211271;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_picker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_picker_click", null));}
String _value = "";
String _value1 = "";
String _value2 = "";
RDebugUtils.currentLine=5308416;
 //BA.debugLineNum = 5308416;BA.debugLine="Private Sub lbl_save_picker_Click";
RDebugUtils.currentLine=5308418;
 //BA.debugLineNum = 5308418;BA.debugLine="Dim value As String";
_value = "";
RDebugUtils.currentLine=5308419;
 //BA.debugLineNum = 5308419;BA.debugLine="value=pik_hour1.Text";
_value = mostCurrent._pik_hour1.getText();
RDebugUtils.currentLine=5308420;
 //BA.debugLineNum = 5308420;BA.debugLine="Select value";
switch (BA.switchObjectToInt(_value,"1","2","3","4","5","6","7","8","9")) {
case 0: {
RDebugUtils.currentLine=5308422;
 //BA.debugLineNum = 5308422;BA.debugLine="pik_hour1.Text=\"01\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("01"));
 break; }
case 1: {
RDebugUtils.currentLine=5308424;
 //BA.debugLineNum = 5308424;BA.debugLine="pik_hour1.Text=\"02\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("02"));
 break; }
case 2: {
RDebugUtils.currentLine=5308426;
 //BA.debugLineNum = 5308426;BA.debugLine="pik_hour1.Text=\"03\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("03"));
 break; }
case 3: {
RDebugUtils.currentLine=5308428;
 //BA.debugLineNum = 5308428;BA.debugLine="pik_hour1.Text=\"04\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("04"));
 break; }
case 4: {
RDebugUtils.currentLine=5308430;
 //BA.debugLineNum = 5308430;BA.debugLine="pik_hour1.Text=\"05\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("05"));
 break; }
case 5: {
RDebugUtils.currentLine=5308432;
 //BA.debugLineNum = 5308432;BA.debugLine="pik_hour1.Text=\"06\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("06"));
 break; }
case 6: {
RDebugUtils.currentLine=5308434;
 //BA.debugLineNum = 5308434;BA.debugLine="pik_hour1.Text=\"07\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("07"));
 break; }
case 7: {
RDebugUtils.currentLine=5308436;
 //BA.debugLineNum = 5308436;BA.debugLine="pik_hour1.Text=\"08\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("08"));
 break; }
case 8: {
RDebugUtils.currentLine=5308438;
 //BA.debugLineNum = 5308438;BA.debugLine="pik_hour1.Text=\"09\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("09"));
 break; }
}
;
RDebugUtils.currentLine=5308441;
 //BA.debugLineNum = 5308441;BA.debugLine="Dim value1 As String";
_value1 = "";
RDebugUtils.currentLine=5308442;
 //BA.debugLineNum = 5308442;BA.debugLine="value1=pik_min1.Text";
_value1 = mostCurrent._pik_min1.getText();
RDebugUtils.currentLine=5308443;
 //BA.debugLineNum = 5308443;BA.debugLine="Select value1";
switch (BA.switchObjectToInt(_value1,"1","2","3","4","5","6","7","8","9")) {
case 0: {
RDebugUtils.currentLine=5308445;
 //BA.debugLineNum = 5308445;BA.debugLine="pik_min1.Text=\"01\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("01"));
 break; }
case 1: {
RDebugUtils.currentLine=5308447;
 //BA.debugLineNum = 5308447;BA.debugLine="pik_min1.Text=\"02\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("02"));
 break; }
case 2: {
RDebugUtils.currentLine=5308449;
 //BA.debugLineNum = 5308449;BA.debugLine="pik_min1.Text=\"03\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("03"));
 break; }
case 3: {
RDebugUtils.currentLine=5308451;
 //BA.debugLineNum = 5308451;BA.debugLine="pik_min1.Text=\"04\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("04"));
 break; }
case 4: {
RDebugUtils.currentLine=5308453;
 //BA.debugLineNum = 5308453;BA.debugLine="pik_min1.Text=\"05\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("05"));
 break; }
case 5: {
RDebugUtils.currentLine=5308455;
 //BA.debugLineNum = 5308455;BA.debugLine="pik_min1.Text=\"06\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("06"));
 break; }
case 6: {
RDebugUtils.currentLine=5308457;
 //BA.debugLineNum = 5308457;BA.debugLine="pik_min1.Text=\"07\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("07"));
 break; }
case 7: {
RDebugUtils.currentLine=5308459;
 //BA.debugLineNum = 5308459;BA.debugLine="pik_min1.Text=\"08\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("08"));
 break; }
case 8: {
RDebugUtils.currentLine=5308461;
 //BA.debugLineNum = 5308461;BA.debugLine="pik_min1.Text=\"09\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("09"));
 break; }
}
;
RDebugUtils.currentLine=5308464;
 //BA.debugLineNum = 5308464;BA.debugLine="Dim value2 As String";
_value2 = "";
RDebugUtils.currentLine=5308465;
 //BA.debugLineNum = 5308465;BA.debugLine="value2=pik_day1.Text";
_value2 = mostCurrent._pik_day1.getText();
RDebugUtils.currentLine=5308466;
 //BA.debugLineNum = 5308466;BA.debugLine="Select value2";
switch (BA.switchObjectToInt(_value2,"1","2","3","4","5","6","7","8","9")) {
case 0: {
RDebugUtils.currentLine=5308468;
 //BA.debugLineNum = 5308468;BA.debugLine="pik_day1.Text=\"01\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("01"));
 break; }
case 1: {
RDebugUtils.currentLine=5308470;
 //BA.debugLineNum = 5308470;BA.debugLine="pik_day1.Text=\"02\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("02"));
 break; }
case 2: {
RDebugUtils.currentLine=5308472;
 //BA.debugLineNum = 5308472;BA.debugLine="pik_day1.Text=\"03\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("03"));
 break; }
case 3: {
RDebugUtils.currentLine=5308474;
 //BA.debugLineNum = 5308474;BA.debugLine="pik_day1.Text=\"04\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("04"));
 break; }
case 4: {
RDebugUtils.currentLine=5308476;
 //BA.debugLineNum = 5308476;BA.debugLine="pik_day1.Text=\"05\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("05"));
 break; }
case 5: {
RDebugUtils.currentLine=5308478;
 //BA.debugLineNum = 5308478;BA.debugLine="pik_day1.Text=\"06\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("06"));
 break; }
case 6: {
RDebugUtils.currentLine=5308480;
 //BA.debugLineNum = 5308480;BA.debugLine="pik_day1.Text=\"07\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("07"));
 break; }
case 7: {
RDebugUtils.currentLine=5308482;
 //BA.debugLineNum = 5308482;BA.debugLine="pik_day1.Text=\"08\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("08"));
 break; }
case 8: {
RDebugUtils.currentLine=5308484;
 //BA.debugLineNum = 5308484;BA.debugLine="pik_day1.Text=\"09\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("09"));
 break; }
}
;
RDebugUtils.currentLine=5308486;
 //BA.debugLineNum = 5308486;BA.debugLine="Select pik_moon1.Tag";
switch (BA.switchObjectToInt(mostCurrent._pik_moon1.getTag(),(Object)(1),(Object)(2),(Object)(3),(Object)(4),(Object)(5),(Object)(6),(Object)(7),(Object)(8),(Object)(9),(Object)(10),(Object)(11),(Object)(12))) {
case 0: {
RDebugUtils.currentLine=5308488;
 //BA.debugLineNum = 5308488;BA.debugLine="pik_moon1.Tag=\"01\"";
mostCurrent._pik_moon1.setTag((Object)("01"));
 break; }
case 1: {
RDebugUtils.currentLine=5308490;
 //BA.debugLineNum = 5308490;BA.debugLine="pik_moon1.Tag=\"02\"";
mostCurrent._pik_moon1.setTag((Object)("02"));
 break; }
case 2: {
RDebugUtils.currentLine=5308492;
 //BA.debugLineNum = 5308492;BA.debugLine="pik_moon1.Tag=\"03\"";
mostCurrent._pik_moon1.setTag((Object)("03"));
 break; }
case 3: {
RDebugUtils.currentLine=5308494;
 //BA.debugLineNum = 5308494;BA.debugLine="pik_moon1.Tag=\"04\"";
mostCurrent._pik_moon1.setTag((Object)("04"));
 break; }
case 4: {
RDebugUtils.currentLine=5308496;
 //BA.debugLineNum = 5308496;BA.debugLine="pik_moon1.Tag=\"05\"";
mostCurrent._pik_moon1.setTag((Object)("05"));
 break; }
case 5: {
RDebugUtils.currentLine=5308498;
 //BA.debugLineNum = 5308498;BA.debugLine="pik_moon1.Tag=\"06\"";
mostCurrent._pik_moon1.setTag((Object)("06"));
 break; }
case 6: {
RDebugUtils.currentLine=5308500;
 //BA.debugLineNum = 5308500;BA.debugLine="pik_moon1.Tag=\"07\"";
mostCurrent._pik_moon1.setTag((Object)("07"));
 break; }
case 7: {
RDebugUtils.currentLine=5308502;
 //BA.debugLineNum = 5308502;BA.debugLine="pik_moon1.Tag=\"08\"";
mostCurrent._pik_moon1.setTag((Object)("08"));
 break; }
case 8: {
RDebugUtils.currentLine=5308504;
 //BA.debugLineNum = 5308504;BA.debugLine="pik_moon1.Tag=\"09\"";
mostCurrent._pik_moon1.setTag((Object)("09"));
 break; }
case 9: {
RDebugUtils.currentLine=5308506;
 //BA.debugLineNum = 5308506;BA.debugLine="pik_moon1.Tag=\"10\"";
mostCurrent._pik_moon1.setTag((Object)("10"));
 break; }
case 10: {
RDebugUtils.currentLine=5308508;
 //BA.debugLineNum = 5308508;BA.debugLine="pik_moon1.Tag=\"11\"";
mostCurrent._pik_moon1.setTag((Object)("11"));
 break; }
case 11: {
RDebugUtils.currentLine=5308510;
 //BA.debugLineNum = 5308510;BA.debugLine="pik_moon1.Tag=\"12\"";
mostCurrent._pik_moon1.setTag((Object)("12"));
 break; }
}
;
RDebugUtils.currentLine=5308515;
 //BA.debugLineNum = 5308515;BA.debugLine="If(index_piker=1)Then  'date1";
if ((_index_piker==1)) { 
RDebugUtils.currentLine=5308517;
 //BA.debugLineNum = 5308517;BA.debugLine="lbl_tim1.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
RDebugUtils.currentLine=5308518;
 //BA.debugLineNum = 5308518;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
 }else 
{RDebugUtils.currentLine=5308520;
 //BA.debugLineNum = 5308520;BA.debugLine="Else If (index_piker=2)Then  'date2";
if ((_index_piker==2)) { 
RDebugUtils.currentLine=5308522;
 //BA.debugLineNum = 5308522;BA.debugLine="lbl_tim2.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
RDebugUtils.currentLine=5308523;
 //BA.debugLineNum = 5308523;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
 }}
;
RDebugUtils.currentLine=5308528;
 //BA.debugLineNum = 5308528;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5308529;
 //BA.debugLineNum = 5308529;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=5308530;
 //BA.debugLineNum = 5308530;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_app_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_share_app_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_share_app_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _i = null;
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Private Sub lbl_share_app_Click";
RDebugUtils.currentLine=8388609;
 //BA.debugLineNum = 8388609;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=8388610;
 //BA.debugLineNum = 8388610;BA.debugLine="i.Initialize(i.ACTION_SEND, \"\")";
_i.Initialize(_i.ACTION_SEND,"");
RDebugUtils.currentLine=8388611;
 //BA.debugLineNum = 8388611;BA.debugLine="i.SetType(\"text/plain\")";
_i.SetType("text/plain");
RDebugUtils.currentLine=8388612;
 //BA.debugLineNum = 8388612;BA.debugLine="i.PutExtra(\"android.intent.extra.TEXT\", \"https://";
_i.PutExtra("android.intent.extra.TEXT",(Object)("https://cafebazaar.ir/app/ir.taravatgroup.ezafekari2"));
RDebugUtils.currentLine=8388613;
 //BA.debugLineNum = 8388613;BA.debugLine="i.WrapAsIntentChooser(\"انتخاب کنید\")";
_i.WrapAsIntentChooser("انتخاب کنید");
RDebugUtils.currentLine=8388614;
 //BA.debugLineNum = 8388614;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_i.getObject()));
RDebugUtils.currentLine=8388615;
 //BA.debugLineNum = 8388615;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
RDebugUtils.currentLine=8388616;
 //BA.debugLineNum = 8388616;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_later_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip_later_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip_later_click", null));}
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Private Sub lbl_vip_later_Click";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_now_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip_now_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip_now_click", null));}
String _title = "";
String _matn = "";
int _result = 0;
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Private Sub lbl_vip_now_Click";
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=6684675;
 //BA.debugLineNum = 6684675;BA.debugLine="Dim title , matn As String";
_title = "";
_matn = "";
RDebugUtils.currentLine=6684676;
 //BA.debugLineNum = 6684676;BA.debugLine="title=\" تبریک \"";
_title = " تبریک ";
RDebugUtils.currentLine=6684677;
 //BA.debugLineNum = 6684677;BA.debugLine="matn=\" شما صاحب نسخه طلایی و بدون محدودیت برنامه";
_matn = " شما صاحب نسخه طلایی و بدون محدودیت برنامه اضافه کاری من می باشید. ";
RDebugUtils.currentLine=6684679;
 //BA.debugLineNum = 6684679;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=6684680;
 //BA.debugLineNum = 6684680;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Lo";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"باشه","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"buy.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=6684681;
 //BA.debugLineNum = 6684681;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
 }else {
RDebugUtils.currentLine=6684686;
 //BA.debugLineNum = 6684686;BA.debugLine="kharid";
_kharid();
 };
RDebugUtils.currentLine=6684688;
 //BA.debugLineNum = 6684688;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip2_click", null));}
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Private Sub lbl_vip2_Click";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vorod_ft_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vorod_ft_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vorod_ft_click", null));}
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Private Sub lbl_vorod_FT_Click";
RDebugUtils.currentLine=7733249;
 //BA.debugLineNum = 7733249;BA.debugLine="ToastMessageShow(\"انگشت خود را 3 ثانیه نگه دارید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("انگشت خود را 3 ثانیه نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7733250;
 //BA.debugLineNum = 7733250;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vorod_ft_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vorod_ft_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vorod_ft_longclick", null));}
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Private Sub lbl_vorod_FT_LongClick";
RDebugUtils.currentLine=7864322;
 //BA.debugLineNum = 7864322;BA.debugLine="If(code_fast_taradod=1)Then";
if ((_code_fast_taradod==1)) { 
RDebugUtils.currentLine=7864323;
 //BA.debugLineNum = 7864323;BA.debugLine="index_box=4";
_index_box = (int) (4);
RDebugUtils.currentLine=7864324;
 //BA.debugLineNum = 7864324;BA.debugLine="lbl_tim_vorod_FT.Text=DateTime.Time(DateTime.Now";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
RDebugUtils.currentLine=7864325;
 //BA.debugLineNum = 7864325;BA.debugLine="code_fast_taradod=10";
_code_fast_taradod = (int) (10);
RDebugUtils.currentLine=7864326;
 //BA.debugLineNum = 7864326;BA.debugLine="add_end";
_add_end();
RDebugUtils.currentLine=7864327;
 //BA.debugLineNum = 7864327;BA.debugLine="pan_add_taradod_fast_Click";
_pan_add_taradod_fast_click();
 }else 
{RDebugUtils.currentLine=7864328;
 //BA.debugLineNum = 7864328;BA.debugLine="Else If(code_fast_taradod=0)Then";
if ((_code_fast_taradod==0)) { 
RDebugUtils.currentLine=7864329;
 //BA.debugLineNum = 7864329;BA.debugLine="ToastMessageShow(\" تردد امروز دستی ثبت شده است\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" تردد امروز دستی ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=7864331;
 //BA.debugLineNum = 7864331;BA.debugLine="ToastMessageShow(\"زمان ورود ثبت شده است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("زمان ورود ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }}
;
RDebugUtils.currentLine=7864334;
 //BA.debugLineNum = 7864334;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_taradod_fast_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_taradod_fast_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_taradod_fast_click", null));}
RDebugUtils.currentLine=7536640;
 //BA.debugLineNum = 7536640;BA.debugLine="Private Sub pan_add_taradod_fast_Click";
RDebugUtils.currentLine=7536641;
 //BA.debugLineNum = 7536641;BA.debugLine="pan_all_FT.Visible=True";
mostCurrent._pan_all_ft.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7536642;
 //BA.debugLineNum = 7536642;BA.debugLine="lbl_date_FT.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date_ft.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=7536643;
 //BA.debugLineNum = 7536643;BA.debugLine="DateTime.TimeFormat = \"HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm");
RDebugUtils.currentLine=7536645;
 //BA.debugLineNum = 7536645;BA.debugLine="If(dbCode.isexist_taradod_by_date(lbl_date_FT.Tex";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText())==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=7536646;
 //BA.debugLineNum = 7536646;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+mostCurrent._lbl_date_ft.getText()+"';")));
RDebugUtils.currentLine=7536647;
 //BA.debugLineNum = 7536647;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=7536649;
 //BA.debugLineNum = 7536649;BA.debugLine="lbl_tim_vorod_FT.Text=dbCode.res.GetString(\"time";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")));
RDebugUtils.currentLine=7536650;
 //BA.debugLineNum = 7536650;BA.debugLine="lbl_tim_khoroj_FT.Text=dbCode.res.GetString(\"tim";
mostCurrent._lbl_tim_khoroj_ft.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=7536652;
 //BA.debugLineNum = 7536652;BA.debugLine="et_tozihat_FT.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._et_tozihat_ft.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=7536654;
 //BA.debugLineNum = 7536654;BA.debugLine="current_id_edit=dbCode.res.GetInt(\"id\")";
_current_id_edit = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("id");
RDebugUtils.currentLine=7536655;
 //BA.debugLineNum = 7536655;BA.debugLine="Log(dbCode.res.GetInt(\"state\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("77536655",BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")),0);
RDebugUtils.currentLine=7536657;
 //BA.debugLineNum = 7536657;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=7536658;
 //BA.debugLineNum = 7536658;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=7536661;
 //BA.debugLineNum = 7536661;BA.debugLine="If(dbCode.res.GetInt(\"state\")=10)Then  ''vorod n";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==10)) { 
RDebugUtils.currentLine=7536662;
 //BA.debugLineNum = 7536662;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=7536663;
 //BA.debugLineNum = 7536663;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=7536664;
 //BA.debugLineNum = 7536664;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536665;
 //BA.debugLineNum = 7536665;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536667;
 //BA.debugLineNum = 7536667;BA.debugLine="code_fast_taradod=10";
_code_fast_taradod = (int) (10);
 }else 
{RDebugUtils.currentLine=7536668;
 //BA.debugLineNum = 7536668;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=20)Then  ''v";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==20)) { 
RDebugUtils.currentLine=7536669;
 //BA.debugLineNum = 7536669;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=7536670;
 //BA.debugLineNum = 7536670;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=7536671;
 //BA.debugLineNum = 7536671;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7536672;
 //BA.debugLineNum = 7536672;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536674;
 //BA.debugLineNum = 7536674;BA.debugLine="code_fast_taradod=20";
_code_fast_taradod = (int) (20);
 }else 
{RDebugUtils.currentLine=7536675;
 //BA.debugLineNum = 7536675;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=11)Then  ''k";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==11)) { 
RDebugUtils.currentLine=7536676;
 //BA.debugLineNum = 7536676;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=7536677;
 //BA.debugLineNum = 7536677;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=7536678;
 //BA.debugLineNum = 7536678;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536679;
 //BA.debugLineNum = 7536679;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536681;
 //BA.debugLineNum = 7536681;BA.debugLine="et_tozihat_FT.Enabled=False";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536683;
 //BA.debugLineNum = 7536683;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
RDebugUtils.currentLine=7536684;
 //BA.debugLineNum = 7536684;BA.debugLine="code_fast_taradod=11";
_code_fast_taradod = (int) (11);
RDebugUtils.currentLine=7536685;
 //BA.debugLineNum = 7536685;BA.debugLine="ToastMessageShow(\"تردد امروز ثبت شده است\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تردد امروز ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=7536688;
 //BA.debugLineNum = 7536688;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=21)Then  ''k";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==21)) { 
RDebugUtils.currentLine=7536689;
 //BA.debugLineNum = 7536689;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=7536690;
 //BA.debugLineNum = 7536690;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=7536691;
 //BA.debugLineNum = 7536691;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7536692;
 //BA.debugLineNum = 7536692;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536694;
 //BA.debugLineNum = 7536694;BA.debugLine="et_tozihat_FT.Enabled=False";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536696;
 //BA.debugLineNum = 7536696;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
RDebugUtils.currentLine=7536698;
 //BA.debugLineNum = 7536698;BA.debugLine="code_fast_taradod=21";
_code_fast_taradod = (int) (21);
RDebugUtils.currentLine=7536699;
 //BA.debugLineNum = 7536699;BA.debugLine="ToastMessageShow(\"تردد امروز ثبت شده است\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تردد امروز ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=7536702;
 //BA.debugLineNum = 7536702;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=0)Then  ''da";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==0)) { 
RDebugUtils.currentLine=7536703;
 //BA.debugLineNum = 7536703;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Red";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=7536704;
 //BA.debugLineNum = 7536704;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Red";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=7536705;
 //BA.debugLineNum = 7536705;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536706;
 //BA.debugLineNum = 7536706;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536708;
 //BA.debugLineNum = 7536708;BA.debugLine="et_tozihat_FT.Enabled=False";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536709;
 //BA.debugLineNum = 7536709;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
RDebugUtils.currentLine=7536711;
 //BA.debugLineNum = 7536711;BA.debugLine="ToastMessageShow(\"برای امروز تردد دستی ثبت شده";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برای امروز تردد دستی ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536713;
 //BA.debugLineNum = 7536713;BA.debugLine="code_fast_taradod=0";
_code_fast_taradod = (int) (0);
 }}}}}
;
 }else {
RDebugUtils.currentLine=7536716;
 //BA.debugLineNum = 7536716;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=7536717;
 //BA.debugLineNum = 7536717;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=7536719;
 //BA.debugLineNum = 7536719;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7536720;
 //BA.debugLineNum = 7536720;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=True";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7536721;
 //BA.debugLineNum = 7536721;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
RDebugUtils.currentLine=7536722;
 //BA.debugLineNum = 7536722;BA.debugLine="et_tozihat_FT.Enabled=True";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=7536724;
 //BA.debugLineNum = 7536724;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_msgnewyear_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_msgnewyear_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_msgnewyear_click", null));}
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Private Sub pan_all_msgNewYear_Click";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all2_click", null));}
RDebugUtils.currentLine=5373952;
 //BA.debugLineNum = 5373952;BA.debugLine="Private Sub pan_all2_Click";
RDebugUtils.currentLine=5373955;
 //BA.debugLineNum = 5373955;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5373956;
 //BA.debugLineNum = 5373956;BA.debugLine="End Sub";
return "";
}
public static String  _pan_bime_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_bime_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_bime_click", null));}
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Private Sub pan_bime_Click";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="StartActivity(bime_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._bime_activity.getObject()));
RDebugUtils.currentLine=8257539;
 //BA.debugLineNum = 8257539;BA.debugLine="End Sub";
return "";
}
public static String  _pan_calc_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_calc_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_calc_click", null));}
RDebugUtils.currentLine=5636096;
 //BA.debugLineNum = 5636096;BA.debugLine="Private Sub pan_calc_Click";
RDebugUtils.currentLine=5636097;
 //BA.debugLineNum = 5636097;BA.debugLine="StartActivity(calc_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._calc_activity.getObject()));
RDebugUtils.currentLine=5636100;
 //BA.debugLineNum = 5636100;BA.debugLine="End Sub";
return "";
}
public static String  _pan_comment_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_comment_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_comment_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _market = null;
String _url = "";
RDebugUtils.currentLine=5505024;
 //BA.debugLineNum = 5505024;BA.debugLine="Private Sub pan_comment_Click";
RDebugUtils.currentLine=5505026;
 //BA.debugLineNum = 5505026;BA.debugLine="Try";
try {RDebugUtils.currentLine=5505027;
 //BA.debugLineNum = 5505027;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=5505029;
 //BA.debugLineNum = 5505029;BA.debugLine="Try";
try {RDebugUtils.currentLine=5505030;
 //BA.debugLineNum = 5505030;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=5505031;
 //BA.debugLineNum = 5505031;BA.debugLine="Dim url As String";
_url = "";
RDebugUtils.currentLine=5505033;
 //BA.debugLineNum = 5505033;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafek";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
RDebugUtils.currentLine=5505034;
 //BA.debugLineNum = 5505034;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
RDebugUtils.currentLine=5505035;
 //BA.debugLineNum = 5505035;BA.debugLine="market.SetPackage(\"com.farsitel.bazaar\")";
_market.SetPackage("com.farsitel.bazaar");
RDebugUtils.currentLine=5505036;
 //BA.debugLineNum = 5505036;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e11) {
			processBA.setLastException(e11);RDebugUtils.currentLine=5505039;
 //BA.debugLineNum = 5505039;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=5505042;
 //BA.debugLineNum = 5505042;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e17) {
			processBA.setLastException(e17);RDebugUtils.currentLine=5505046;
 //BA.debugLineNum = 5505046;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=5505048;
 //BA.debugLineNum = 5505048;BA.debugLine="Try";
try {RDebugUtils.currentLine=5505049;
 //BA.debugLineNum = 5505049;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=5505050;
 //BA.debugLineNum = 5505050;BA.debugLine="Dim url As String";
_url = "";
RDebugUtils.currentLine=5505052;
 //BA.debugLineNum = 5505052;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafe";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
RDebugUtils.currentLine=5505053;
 //BA.debugLineNum = 5505053;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
RDebugUtils.currentLine=5505054;
 //BA.debugLineNum = 5505054;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e25) {
			processBA.setLastException(e25);RDebugUtils.currentLine=5505057;
 //BA.debugLineNum = 5505057;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=5505060;
 //BA.debugLineNum = 5505060;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 };
RDebugUtils.currentLine=5505067;
 //BA.debugLineNum = 5505067;BA.debugLine="End Sub";
return "";
}
public static String  _pan_darsad_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_darsad_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_darsad_click", null));}
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Private Sub pan_darsad_Click";
RDebugUtils.currentLine=5439489;
 //BA.debugLineNum = 5439489;BA.debugLine="StartActivity(darsad_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._darsad_activity.getObject()));
RDebugUtils.currentLine=5439491;
 //BA.debugLineNum = 5439491;BA.debugLine="End Sub";
return "";
}
public static String  _pan_eidi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_eidi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_eidi_click", null));}
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Private Sub pan_eidi_Click";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="StartActivity(eidi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._eidi_activity.getObject()));
RDebugUtils.currentLine=4849667;
 //BA.debugLineNum = 4849667;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ezafekari_mah_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_ezafekari_mah_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_ezafekari_mah_click", null));}
RDebugUtils.currentLine=6488064;
 //BA.debugLineNum = 6488064;BA.debugLine="Private Sub pan_ezafekari_mah_Click";
RDebugUtils.currentLine=6488065;
 //BA.debugLineNum = 6488065;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
RDebugUtils.currentLine=6488066;
 //BA.debugLineNum = 6488066;BA.debugLine="TabHost1.CurrentTab=0";
mostCurrent._tabhost1.setCurrentTab((int) (0));
RDebugUtils.currentLine=6488068;
 //BA.debugLineNum = 6488068;BA.debugLine="End Sub";
return "";
}
public static String  _pan_fast_run_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_fast_run_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_fast_run_click", null));}
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Private Sub pan_fast_run_Click";
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="StartActivity(fast_run_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._fast_run_activity.getObject()));
RDebugUtils.currentLine=2490377;
 //BA.debugLineNum = 2490377;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ganon_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_ganon_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_ganon_click", null));}
RDebugUtils.currentLine=6946816;
 //BA.debugLineNum = 6946816;BA.debugLine="Private Sub pan_ganon_Click";
RDebugUtils.currentLine=6946817;
 //BA.debugLineNum = 6946817;BA.debugLine="StartActivity(ganon_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ganon_activity.getObject()));
RDebugUtils.currentLine=6946819;
 //BA.debugLineNum = 6946819;BA.debugLine="End Sub";
return "";
}
public static String  _pan_help_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_help_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_help_touch", new Object[] {_action,_x,_y}));}
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Private Sub pan_help_Touch (Action As Int, X As Fl";
RDebugUtils.currentLine=5898242;
 //BA.debugLineNum = 5898242;BA.debugLine="If (Action=0)Then";
if ((_action==0)) { 
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="index_x_start_swap=x";
_index_x_start_swap = (int) (_x);
RDebugUtils.currentLine=5898244;
 //BA.debugLineNum = 5898244;BA.debugLine="If (index_curent_img=4)Then";
if ((_index_curent_img==4)) { 
RDebugUtils.currentLine=5898245;
 //BA.debugLineNum = 5898245;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
RDebugUtils.currentLine=5898248;
 //BA.debugLineNum = 5898248;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=5898249;
 //BA.debugLineNum = 5898249;BA.debugLine="If(X<(index_x_start_swap-150))Then";
if ((_x<(_index_x_start_swap-150))) { 
RDebugUtils.currentLine=5898252;
 //BA.debugLineNum = 5898252;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
RDebugUtils.currentLine=5898253;
 //BA.debugLineNum = 5898253;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
RDebugUtils.currentLine=5898254;
 //BA.debugLineNum = 5898254;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 }else 
{RDebugUtils.currentLine=5898258;
 //BA.debugLineNum = 5898258;BA.debugLine="Else If(X>(index_x_start_swap+150))Then";
if ((_x>(_index_x_start_swap+150))) { 
RDebugUtils.currentLine=5898261;
 //BA.debugLineNum = 5898261;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
RDebugUtils.currentLine=5898262;
 //BA.debugLineNum = 5898262;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
RDebugUtils.currentLine=5898263;
 //BA.debugLineNum = 5898263;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else 
{RDebugUtils.currentLine=5898267;
 //BA.debugLineNum = 5898267;BA.debugLine="Else If(index_x_start_swap<(pan_help.Width/2))Th";
if ((_index_x_start_swap<(mostCurrent._pan_help.getWidth()/(double)2))) { 
RDebugUtils.currentLine=5898269;
 //BA.debugLineNum = 5898269;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
RDebugUtils.currentLine=5898270;
 //BA.debugLineNum = 5898270;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
RDebugUtils.currentLine=5898271;
 //BA.debugLineNum = 5898271;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else 
{RDebugUtils.currentLine=5898274;
 //BA.debugLineNum = 5898274;BA.debugLine="Else If(index_x_start_swap>(pan_help.Width/2))Th";
if ((_index_x_start_swap>(mostCurrent._pan_help.getWidth()/(double)2))) { 
RDebugUtils.currentLine=5898276;
 //BA.debugLineNum = 5898276;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
RDebugUtils.currentLine=5898277;
 //BA.debugLineNum = 5898277;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
RDebugUtils.currentLine=5898278;
 //BA.debugLineNum = 5898278;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 }}}}
;
RDebugUtils.currentLine=5898283;
 //BA.debugLineNum = 5898283;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 };
RDebugUtils.currentLine=5898286;
 //BA.debugLineNum = 5898286;BA.debugLine="End Sub";
return "";
}
public static String  _pan_info_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_info_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_info_click", null));}
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Private Sub pan_info_Click";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="StartActivity(info_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._info_activity.getObject()));
RDebugUtils.currentLine=4980739;
 //BA.debugLineNum = 4980739;BA.debugLine="End Sub";
return "";
}
public static String  _pan_item_gozaresh_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_item_gozaresh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_item_gozaresh_click", null));}
anywheresoftware.b4a.objects.PanelWrapper _ba = null;
RDebugUtils.currentLine=5570560;
 //BA.debugLineNum = 5570560;BA.debugLine="Private Sub pan_item_gozaresh_Click";
RDebugUtils.currentLine=5570561;
 //BA.debugLineNum = 5570561;BA.debugLine="Dim Ba As Panel = Sender";
_ba = new anywheresoftware.b4a.objects.PanelWrapper();
_ba = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=5570563;
 //BA.debugLineNum = 5570563;BA.debugLine="current_gozaresh_id=Ba.Tag";
_current_gozaresh_id = (int)(BA.ObjectToNumber(_ba.getTag()));
RDebugUtils.currentLine=5570564;
 //BA.debugLineNum = 5570564;BA.debugLine="StartActivity(show_gozaresh_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._show_gozaresh_activity.getObject()));
RDebugUtils.currentLine=5570566;
 //BA.debugLineNum = 5570566;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lelp_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_lelp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_lelp_click", null));}
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Private Sub pan_lelp_Click";
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lock_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_lock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_lock_click", null));}
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Private Sub pan_lock_Click";
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="End Sub";
return "";
}
public static String  _pan_morakhasi_mah_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_morakhasi_mah_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_morakhasi_mah_click", null));}
RDebugUtils.currentLine=6553600;
 //BA.debugLineNum = 6553600;BA.debugLine="Private Sub pan_morakhasi_mah_Click";
RDebugUtils.currentLine=6553601;
 //BA.debugLineNum = 6553601;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
RDebugUtils.currentLine=6553602;
 //BA.debugLineNum = 6553602;BA.debugLine="TabHost1.CurrentTab=1";
mostCurrent._tabhost1.setCurrentTab((int) (1));
RDebugUtils.currentLine=6553604;
 //BA.debugLineNum = 6553604;BA.debugLine="End Sub";
return "";
}
public static String  _pan_notifi_all_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_notifi_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_notifi_all_click", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Private Sub pan_notifi_all_Click";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _pan_payankar_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_payankar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_payankar_click", null));}
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Private Sub pan_payankar_Click";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="StartActivity(payankar_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._payankar_activity.getObject()));
RDebugUtils.currentLine=4915203;
 //BA.debugLineNum = 4915203;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_hogog_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_run_hogog_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_run_hogog_click", null));}
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Private Sub pan_run_hogog_Click";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="If (myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
 }else {
RDebugUtils.currentLine=2686980;
 //BA.debugLineNum = 2686980;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
RDebugUtils.currentLine=2686981;
 //BA.debugLineNum = 2686981;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
RDebugUtils.currentLine=2686986;
 //BA.debugLineNum = 2686986;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_morakhasi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_run_morakhasi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_run_morakhasi_click", null));}
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Private Sub pan_run_morakhasi_Click";
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="StartActivity(morakhasi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._morakhasi_activity.getObject()));
RDebugUtils.currentLine=2621449;
 //BA.debugLineNum = 2621449;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_setting_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_setting_click", null));}
RDebugUtils.currentLine=7012352;
 //BA.debugLineNum = 7012352;BA.debugLine="Private Sub pan_setting_Click";
RDebugUtils.currentLine=7012353;
 //BA.debugLineNum = 7012353;BA.debugLine="StartActivity(setting_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_activity.getObject()));
RDebugUtils.currentLine=7012354;
 //BA.debugLineNum = 7012354;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=7012355;
 //BA.debugLineNum = 7012355;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_hogog_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_setting_hogog_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_setting_hogog_click", null));}
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Private Sub pan_setting_hogog_Click";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="StartActivity(setting_hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_hogog_activity.getObject()));
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=2555908;
 //BA.debugLineNum = 2555908;BA.debugLine="End Sub";
return "";
}
public static String  _pan_shift_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_shift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_shift_click", null));}
RDebugUtils.currentLine=7143424;
 //BA.debugLineNum = 7143424;BA.debugLine="Private Sub pan_shift_Click";
RDebugUtils.currentLine=7143425;
 //BA.debugLineNum = 7143425;BA.debugLine="StartActivity(shift_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._shift_activity.getObject()));
RDebugUtils.currentLine=7143427;
 //BA.debugLineNum = 7143427;BA.debugLine="End Sub";
return "";
}
public static String  _pan_taghvim_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_taghvim_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_taghvim_click", null));}
RDebugUtils.currentLine=7208960;
 //BA.debugLineNum = 7208960;BA.debugLine="Private Sub pan_taghvim_Click";
RDebugUtils.currentLine=7208961;
 //BA.debugLineNum = 7208961;BA.debugLine="pan_shift_Click";
_pan_shift_click();
RDebugUtils.currentLine=7208962;
 //BA.debugLineNum = 7208962;BA.debugLine="End Sub";
return "";
}
public static String  _panel1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel1_click", null));}
RDebugUtils.currentLine=7405568;
 //BA.debugLineNum = 7405568;BA.debugLine="Private Sub Panel1_Click";
RDebugUtils.currentLine=7405570;
 //BA.debugLineNum = 7405570;BA.debugLine="End Sub";
return "";
}
public static String  _panel10_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel10_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel10_click", null));}
RDebugUtils.currentLine=8650752;
 //BA.debugLineNum = 8650752;BA.debugLine="Private Sub Panel10_Click";
RDebugUtils.currentLine=8650754;
 //BA.debugLineNum = 8650754;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel4_click", null));}
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Private Sub Panel4_Click";
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="End Sub";
return "";
}
public static String  _panel5_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel5_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel5_click", null));}
RDebugUtils.currentLine=6815744;
 //BA.debugLineNum = 6815744;BA.debugLine="Private Sub Panel5_Click";
RDebugUtils.currentLine=6815746;
 //BA.debugLineNum = 6815746;BA.debugLine="End Sub";
return "";
}
public static String  _panel6_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel6_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel6_click", null));}
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Private Sub Panel6_Click";
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Private Sub pik_day_bala1_Click";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=4587525;
 //BA.debugLineNum = 4587525;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=4587526;
 //BA.debugLineNum = 4587526;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=4587527;
 //BA.debugLineNum = 4587527;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=4587529;
 //BA.debugLineNum = 4587529;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=4587530;
 //BA.debugLineNum = 4587530;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=4587533;
 //BA.debugLineNum = 4587533;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=4587534;
 //BA.debugLineNum = 4587534;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=4587536;
 //BA.debugLineNum = 4587536;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=4587537;
 //BA.debugLineNum = 4587537;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=4587541;
 //BA.debugLineNum = 4587541;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Private Sub pik_day_paeen1_Click";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=4653059;
 //BA.debugLineNum = 4653059;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=4653060;
 //BA.debugLineNum = 4653060;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=4653061;
 //BA.debugLineNum = 4653061;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=4653063;
 //BA.debugLineNum = 4653063;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=4653064;
 //BA.debugLineNum = 4653064;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=4653067;
 //BA.debugLineNum = 4653067;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=4653068;
 //BA.debugLineNum = 4653068;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=4653070;
 //BA.debugLineNum = 4653070;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=4653071;
 //BA.debugLineNum = 4653071;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=4653075;
 //BA.debugLineNum = 4653075;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_hour_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_hour_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Private Sub pik_hour_bala1_Click";
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="pik_hour1.Text=int1+1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="pik_hour1.Text=00";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(00));
 };
RDebugUtils.currentLine=3735560;
 //BA.debugLineNum = 3735560;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
RDebugUtils.currentLine=3735561;
 //BA.debugLineNum = 3735561;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
RDebugUtils.currentLine=3735564;
 //BA.debugLineNum = 3735564;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_hour_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_hour_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Private Sub pik_hour_paeen1_Click";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="pik_hour1.Text=int1-1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="pik_hour1.Text=00";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(00));
 };
RDebugUtils.currentLine=3801095;
 //BA.debugLineNum = 3801095;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
RDebugUtils.currentLine=3801096;
 //BA.debugLineNum = 3801096;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
RDebugUtils.currentLine=3801099;
 //BA.debugLineNum = 3801099;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_min_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_min_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Private Sub pik_min_bala1_Click";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="pik_min1.Text=int1+1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
RDebugUtils.currentLine=3866629;
 //BA.debugLineNum = 3866629;BA.debugLine="pik_min1.Text=00";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(00));
 };
RDebugUtils.currentLine=3866631;
 //BA.debugLineNum = 3866631;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
RDebugUtils.currentLine=3866632;
 //BA.debugLineNum = 3866632;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
RDebugUtils.currentLine=3866635;
 //BA.debugLineNum = 3866635;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_min_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_min_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Private Sub pik_min_paeen1_Click";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="pik_min1.Text=int1-1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
RDebugUtils.currentLine=3932165;
 //BA.debugLineNum = 3932165;BA.debugLine="pik_min1.Text=00";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(00));
 };
RDebugUtils.currentLine=3932167;
 //BA.debugLineNum = 3932167;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
RDebugUtils.currentLine=3932168;
 //BA.debugLineNum = 3932168;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
RDebugUtils.currentLine=3932171;
 //BA.debugLineNum = 3932171;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Private Sub pik_moon_bala1_Click";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=4325383;
 //BA.debugLineNum = 4325383;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=4325386;
 //BA.debugLineNum = 4325386;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=4325388;
 //BA.debugLineNum = 4325388;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Private Sub pik_moon_paeen1_Click";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=4390919;
 //BA.debugLineNum = 4390919;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=4390922;
 //BA.debugLineNum = 4390922;BA.debugLine="pik_moon1.Text=moon.Get(myfunc.fa2en(pik_moon1.Ta";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
RDebugUtils.currentLine=4390924;
 //BA.debugLineNum = 4390924;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_day1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_day1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=4259843;
 //BA.debugLineNum = 4259843;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=4259846;
 //BA.debugLineNum = 4259846;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=4259848;
 //BA.debugLineNum = 4259848;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=4259849;
 //BA.debugLineNum = 4259849;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
RDebugUtils.currentLine=4259850;
 //BA.debugLineNum = 4259850;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=4259851;
 //BA.debugLineNum = 4259851;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=4259853;
 //BA.debugLineNum = 4259853;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=4259854;
 //BA.debugLineNum = 4259854;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
RDebugUtils.currentLine=4259855;
 //BA.debugLineNum = 4259855;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=4259856;
 //BA.debugLineNum = 4259856;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=4259859;
 //BA.debugLineNum = 4259859;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=4259860;
 //BA.debugLineNum = 4259860;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=4259861;
 //BA.debugLineNum = 4259861;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=4259863;
 //BA.debugLineNum = 4259863;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=4259864;
 //BA.debugLineNum = 4259864;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=4259867;
 //BA.debugLineNum = 4259867;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=4259868;
 //BA.debugLineNum = 4259868;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=4259870;
 //BA.debugLineNum = 4259870;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=4259871;
 //BA.debugLineNum = 4259871;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 };
RDebugUtils.currentLine=4259878;
 //BA.debugLineNum = 4259878;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_hour1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_hour1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_hour1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Private Sub pik_pan_hour1_Touch (Action As Int, X";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=3997702;
 //BA.debugLineNum = 3997702;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=3997704;
 //BA.debugLineNum = 3997704;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=3997705;
 //BA.debugLineNum = 3997705;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))-1);
RDebugUtils.currentLine=3997706;
 //BA.debugLineNum = 3997706;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=3997707;
 //BA.debugLineNum = 3997707;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=3997709;
 //BA.debugLineNum = 3997709;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=3997710;
 //BA.debugLineNum = 3997710;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))+1);
RDebugUtils.currentLine=3997711;
 //BA.debugLineNum = 3997711;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=3997712;
 //BA.debugLineNum = 3997712;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=3997715;
 //BA.debugLineNum = 3997715;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
RDebugUtils.currentLine=3997716;
 //BA.debugLineNum = 3997716;BA.debugLine="pik_hour1.Text=00";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(00));
 };
RDebugUtils.currentLine=3997718;
 //BA.debugLineNum = 3997718;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
RDebugUtils.currentLine=3997719;
 //BA.debugLineNum = 3997719;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
 };
RDebugUtils.currentLine=3997724;
 //BA.debugLineNum = 3997724;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_min1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_min1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_min1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Private Sub pik_pan_min1_Touch (Action As Int, X A";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=4063240;
 //BA.debugLineNum = 4063240;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=4063242;
 //BA.debugLineNum = 4063242;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))-1);
RDebugUtils.currentLine=4063243;
 //BA.debugLineNum = 4063243;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=4063246;
 //BA.debugLineNum = 4063246;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=4063248;
 //BA.debugLineNum = 4063248;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=4063250;
 //BA.debugLineNum = 4063250;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))+1);
RDebugUtils.currentLine=4063251;
 //BA.debugLineNum = 4063251;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=4063254;
 //BA.debugLineNum = 4063254;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=4063258;
 //BA.debugLineNum = 4063258;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
RDebugUtils.currentLine=4063259;
 //BA.debugLineNum = 4063259;BA.debugLine="pik_min1.Text=00";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(00));
 };
RDebugUtils.currentLine=4063262;
 //BA.debugLineNum = 4063262;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
RDebugUtils.currentLine=4063263;
 //BA.debugLineNum = 4063263;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
 };
RDebugUtils.currentLine=4063270;
 //BA.debugLineNum = 4063270;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_moon1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_moon1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=4128774;
 //BA.debugLineNum = 4128774;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=4128776;
 //BA.debugLineNum = 4128776;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=4128777;
 //BA.debugLineNum = 4128777;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
RDebugUtils.currentLine=4128778;
 //BA.debugLineNum = 4128778;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=4128779;
 //BA.debugLineNum = 4128779;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=4128781;
 //BA.debugLineNum = 4128781;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=4128782;
 //BA.debugLineNum = 4128782;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
RDebugUtils.currentLine=4128783;
 //BA.debugLineNum = 4128783;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=4128784;
 //BA.debugLineNum = 4128784;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=4128787;
 //BA.debugLineNum = 4128787;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=4128788;
 //BA.debugLineNum = 4128788;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=4128790;
 //BA.debugLineNum = 4128790;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=4128791;
 //BA.debugLineNum = 4128791;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=4128793;
 //BA.debugLineNum = 4128793;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
RDebugUtils.currentLine=4128796;
 //BA.debugLineNum = 4128796;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_year1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_year1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=4194307;
 //BA.debugLineNum = 4194307;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=4194310;
 //BA.debugLineNum = 4194310;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=4194312;
 //BA.debugLineNum = 4194312;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=4194313;
 //BA.debugLineNum = 4194313;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
RDebugUtils.currentLine=4194314;
 //BA.debugLineNum = 4194314;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=4194315;
 //BA.debugLineNum = 4194315;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=4194317;
 //BA.debugLineNum = 4194317;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=4194318;
 //BA.debugLineNum = 4194318;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
RDebugUtils.currentLine=4194319;
 //BA.debugLineNum = 4194319;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=4194320;
 //BA.debugLineNum = 4194320;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=4194323;
 //BA.debugLineNum = 4194323;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=4194324;
 //BA.debugLineNum = 4194324;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=4194326;
 //BA.debugLineNum = 4194326;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=4194327;
 //BA.debugLineNum = 4194327;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
RDebugUtils.currentLine=4194332;
 //BA.debugLineNum = 4194332;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Private Sub pik_year_bala1_Click";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=4456452;
 //BA.debugLineNum = 4456452;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=4456453;
 //BA.debugLineNum = 4456453;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=4456455;
 //BA.debugLineNum = 4456455;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=4456456;
 //BA.debugLineNum = 4456456;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=4456459;
 //BA.debugLineNum = 4456459;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Private Sub pik_year_paeen1_Click";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=4521988;
 //BA.debugLineNum = 4521988;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=4521989;
 //BA.debugLineNum = 4521989;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=4521991;
 //BA.debugLineNum = 4521991;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=4521992;
 //BA.debugLineNum = 4521992;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=4521995;
 //BA.debugLineNum = 4521995;BA.debugLine="End Sub";
return "";
}
public static boolean  _rspop_noe_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_noe_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_noe_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub rsPOP_noe_MenuItemClick (ItemId As Int) As Boo";
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="Select ItemId";
switch (_itemid) {
case 0: {
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
RDebugUtils.currentLine=2883592;
 //BA.debugLineNum = 2883592;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
RDebugUtils.currentLine=2883594;
 //BA.debugLineNum = 2883594;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
RDebugUtils.currentLine=2883598;
 //BA.debugLineNum = 2883598;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
RDebugUtils.currentLine=2883599;
 //BA.debugLineNum = 2883599;BA.debugLine="index_noe_morakhasi=ItemId";
_index_noe_morakhasi = _itemid;
RDebugUtils.currentLine=2883600;
 //BA.debugLineNum = 2883600;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=2883601;
 //BA.debugLineNum = 2883601;BA.debugLine="End Sub";
return false;
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_moon_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_moon_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="Dim moon_num As String";
_moon_num = "";
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="Select sp_moon.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_moon.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11))) {
case 0: {
RDebugUtils.currentLine=4784132;
 //BA.debugLineNum = 4784132;BA.debugLine="moon_num=\"01\"";
_moon_num = "01";
 break; }
case 1: {
RDebugUtils.currentLine=4784134;
 //BA.debugLineNum = 4784134;BA.debugLine="moon_num=\"02\"";
_moon_num = "02";
 break; }
case 2: {
RDebugUtils.currentLine=4784136;
 //BA.debugLineNum = 4784136;BA.debugLine="moon_num=\"03\"";
_moon_num = "03";
 break; }
case 3: {
RDebugUtils.currentLine=4784138;
 //BA.debugLineNum = 4784138;BA.debugLine="moon_num=\"04\"";
_moon_num = "04";
 break; }
case 4: {
RDebugUtils.currentLine=4784140;
 //BA.debugLineNum = 4784140;BA.debugLine="moon_num=\"05\"";
_moon_num = "05";
 break; }
case 5: {
RDebugUtils.currentLine=4784142;
 //BA.debugLineNum = 4784142;BA.debugLine="moon_num=\"06\"";
_moon_num = "06";
 break; }
case 6: {
RDebugUtils.currentLine=4784144;
 //BA.debugLineNum = 4784144;BA.debugLine="moon_num=\"07\"";
_moon_num = "07";
 break; }
case 7: {
RDebugUtils.currentLine=4784146;
 //BA.debugLineNum = 4784146;BA.debugLine="moon_num=\"08\"";
_moon_num = "08";
 break; }
case 8: {
RDebugUtils.currentLine=4784148;
 //BA.debugLineNum = 4784148;BA.debugLine="moon_num=\"09\"";
_moon_num = "09";
 break; }
case 9: {
RDebugUtils.currentLine=4784150;
 //BA.debugLineNum = 4784150;BA.debugLine="moon_num=\"10\"";
_moon_num = "10";
 break; }
case 10: {
RDebugUtils.currentLine=4784152;
 //BA.debugLineNum = 4784152;BA.debugLine="moon_num=\"11\"";
_moon_num = "11";
 break; }
case 11: {
RDebugUtils.currentLine=4784154;
 //BA.debugLineNum = 4784154;BA.debugLine="moon_num=\"12\"";
_moon_num = "12";
 break; }
}
;
RDebugUtils.currentLine=4784157;
 //BA.debugLineNum = 4784157;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=4784158;
 //BA.debugLineNum = 4784158;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
RDebugUtils.currentLine=4784159;
 //BA.debugLineNum = 4784159;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_gozaresh_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_gozaresh_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_gozaresh_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=7471104;
 //BA.debugLineNum = 7471104;BA.debugLine="Private Sub sp_year_gozaresh_ItemClick (Position A";
RDebugUtils.currentLine=7471105;
 //BA.debugLineNum = 7471105;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
RDebugUtils.currentLine=7471106;
 //BA.debugLineNum = 7471106;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=4718597;
 //BA.debugLineNum = 4718597;BA.debugLine="Dim moon_num As String";
_moon_num = "";
RDebugUtils.currentLine=4718598;
 //BA.debugLineNum = 4718598;BA.debugLine="Select sp_moon.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_moon.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11))) {
case 0: {
RDebugUtils.currentLine=4718600;
 //BA.debugLineNum = 4718600;BA.debugLine="moon_num=\"01\"";
_moon_num = "01";
 break; }
case 1: {
RDebugUtils.currentLine=4718602;
 //BA.debugLineNum = 4718602;BA.debugLine="moon_num=\"02\"";
_moon_num = "02";
 break; }
case 2: {
RDebugUtils.currentLine=4718604;
 //BA.debugLineNum = 4718604;BA.debugLine="moon_num=\"03\"";
_moon_num = "03";
 break; }
case 3: {
RDebugUtils.currentLine=4718606;
 //BA.debugLineNum = 4718606;BA.debugLine="moon_num=\"04\"";
_moon_num = "04";
 break; }
case 4: {
RDebugUtils.currentLine=4718608;
 //BA.debugLineNum = 4718608;BA.debugLine="moon_num=\"05\"";
_moon_num = "05";
 break; }
case 5: {
RDebugUtils.currentLine=4718610;
 //BA.debugLineNum = 4718610;BA.debugLine="moon_num=\"06\"";
_moon_num = "06";
 break; }
case 6: {
RDebugUtils.currentLine=4718612;
 //BA.debugLineNum = 4718612;BA.debugLine="moon_num=\"07\"";
_moon_num = "07";
 break; }
case 7: {
RDebugUtils.currentLine=4718614;
 //BA.debugLineNum = 4718614;BA.debugLine="moon_num=\"08\"";
_moon_num = "08";
 break; }
case 8: {
RDebugUtils.currentLine=4718616;
 //BA.debugLineNum = 4718616;BA.debugLine="moon_num=\"09\"";
_moon_num = "09";
 break; }
case 9: {
RDebugUtils.currentLine=4718618;
 //BA.debugLineNum = 4718618;BA.debugLine="moon_num=\"10\"";
_moon_num = "10";
 break; }
case 10: {
RDebugUtils.currentLine=4718620;
 //BA.debugLineNum = 4718620;BA.debugLine="moon_num=\"11\"";
_moon_num = "11";
 break; }
case 11: {
RDebugUtils.currentLine=4718622;
 //BA.debugLineNum = 4718622;BA.debugLine="moon_num=\"12\"";
_moon_num = "12";
 break; }
}
;
RDebugUtils.currentLine=4718624;
 //BA.debugLineNum = 4718624;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=4718626;
 //BA.debugLineNum = 4718626;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
RDebugUtils.currentLine=4718628;
 //BA.debugLineNum = 4718628;BA.debugLine="End Sub";
return "";
}
public static String  _tim_lock_lbl_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_lock_lbl_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_lock_lbl_tick", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub tim_lock_lbl_Tick";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="If(stat_finger=0)Then";
if ((_stat_finger==0)) { 
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
mostCurrent._lbl_finger.setTextColor(((int)0xff0b6200));
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="stat_finger=1";
_stat_finger = (int) (1);
 }else {
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="lbl_finger.TextColor=0xFF2FFF00";
mostCurrent._lbl_finger.setTextColor(((int)0xff2fff00));
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="stat_finger=0";
_stat_finger = (int) (0);
 };
RDebugUtils.currentLine=917512;
 //BA.debugLineNum = 917512;BA.debugLine="End Sub";
return "";
}
public static String  _tim_msg_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_msg_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_msg_tick", null));}
String _msg_key = "";
String _msg_value = "";
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub tim_msg_Tick";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="Dim msg_key As String";
_msg_key = "";
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="Dim msg_value As String";
_msg_value = "";
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="msg_key=msg.SubString2(0,4)";
_msg_key = mostCurrent._msg.substring((int) (0),(int) (4));
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="msg_value=msg.SubString(5)";
_msg_value = mostCurrent._msg.substring((int) (5));
RDebugUtils.currentLine=458761;
 //BA.debugLineNum = 458761;BA.debugLine="ls1.Add(msg_key)";
mostCurrent._ls1.Add((Object)(_msg_key));
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="ls2.Add(msg_value)";
mostCurrent._ls2.Add((Object)(_msg_value));
RDebugUtils.currentLine=458763;
 //BA.debugLineNum = 458763;BA.debugLine="ls3.Add(lbl_date_home.Text)";
mostCurrent._ls3.Add((Object)(mostCurrent._lbl_date_home.getText()));
RDebugUtils.currentLine=458765;
 //BA.debugLineNum = 458765;BA.debugLine="File.WriteList(File.DirInternal,\"ls1\",ls1)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1",mostCurrent._ls1);
RDebugUtils.currentLine=458766;
 //BA.debugLineNum = 458766;BA.debugLine="File.WriteList(File.DirInternal,\"ls2\",ls2)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls2",mostCurrent._ls2);
RDebugUtils.currentLine=458767;
 //BA.debugLineNum = 458767;BA.debugLine="File.WriteList(File.DirInternal,\"ls3\",ls3)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls3",mostCurrent._ls3);
RDebugUtils.currentLine=458769;
 //BA.debugLineNum = 458769;BA.debugLine="lbl_title_msgPan.Text=\"پیام جدید\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام جدید"));
RDebugUtils.currentLine=458770;
 //BA.debugLineNum = 458770;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=458772;
 //BA.debugLineNum = 458772;BA.debugLine="pan_notif.Top=20%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA));
RDebugUtils.currentLine=458773;
 //BA.debugLineNum = 458773;BA.debugLine="pan_notif.Height=50%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA));
RDebugUtils.currentLine=458774;
 //BA.debugLineNum = 458774;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
RDebugUtils.currentLine=458777;
 //BA.debugLineNum = 458777;BA.debugLine="web_msg_show.LoadHtml(\"<!DOCTYPE html><html><meta";
mostCurrent._web_msg_show.LoadHtml("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'><div style='background-color: #99ffff; font-size: 14px;'>"+"کد پیام : "+_msg_key+" - مورخ : "+mostCurrent._lbl_date_home.getText()+"</div><div style='background-color: #e6ffff; font-size: 18px;'><br>"+_msg_value+"<br></div><br></body></html>");
RDebugUtils.currentLine=458779;
 //BA.debugLineNum = 458779;BA.debugLine="tim_msg.Enabled=False";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458780;
 //BA.debugLineNum = 458780;BA.debugLine="End Sub";
return "";
}
public static String  _timer1_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "timer1_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "timer1_tick", null));}
anywheresoftware.b4a.objects.collections.List _ls_lock0 = null;
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub timer1_Tick";
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="timer1.Enabled=False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="cv_loader.Hide";
mostCurrent._cv_loader._hide /*String*/ (null);
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=True)T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=851980;
 //BA.debugLineNum = 851980;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
RDebugUtils.currentLine=851982;
 //BA.debugLineNum = 851982;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_lock";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
RDebugUtils.currentLine=851984;
 //BA.debugLineNum = 851984;BA.debugLine="If(ls_lock0.Get(0)=\"true\")Then";
if (((_ls_lock0.Get((int) (0))).equals((Object)("true")))) { 
RDebugUtils.currentLine=851985;
 //BA.debugLineNum = 851985;BA.debugLine="Master_Password=ls_lock0.Get(2)";
mostCurrent._master_password = BA.ObjectToString(_ls_lock0.Get((int) (2)));
RDebugUtils.currentLine=851986;
 //BA.debugLineNum = 851986;BA.debugLine="pan_lock.Visible=True";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=851987;
 //BA.debugLineNum = 851987;BA.debugLine="lbl_hint_lock.Text=ls_lock0.Get(3)";
mostCurrent._lbl_hint_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (3))));
RDebugUtils.currentLine=851989;
 //BA.debugLineNum = 851989;BA.debugLine="If(ls_lock0.Get(1)=\"true\")Then";
if (((_ls_lock0.Get((int) (1))).equals((Object)("true")))) { 
RDebugUtils.currentLine=851991;
 //BA.debugLineNum = 851991;BA.debugLine="tim_lock_lbl.Initialize(\"tim_lock_lbl\",500)";
_tim_lock_lbl.Initialize(processBA,"tim_lock_lbl",(long) (500));
RDebugUtils.currentLine=851992;
 //BA.debugLineNum = 851992;BA.debugLine="Try";
try {RDebugUtils.currentLine=851993;
 //BA.debugLineNum = 851993;BA.debugLine="fingerprint.Initialize (Me, \"auth\")";
mostCurrent._fingerprint._initialize /*String*/ (null,processBA,main.getObject(),"auth");
RDebugUtils.currentLine=851996;
 //BA.debugLineNum = 851996;BA.debugLine="If fingerprint.HardwareDetected = False Then";
if (mostCurrent._fingerprint._gethardwaredetected /*boolean*/ (null)==anywheresoftware.b4a.keywords.Common.False) { 
 }else 
{RDebugUtils.currentLine=851999;
 //BA.debugLineNum = 851999;BA.debugLine="Else if fingerprint.HasEnrolledFingerprints =";
if (mostCurrent._fingerprint._gethasenrolledfingerprints /*boolean*/ (null)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=852000;
 //BA.debugLineNum = 852000;BA.debugLine="ToastMessageShow(\"اثر انگشت تعریف نشده است\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اثر انگشت تعریف نشده است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=852002;
 //BA.debugLineNum = 852002;BA.debugLine="lbl_finger.Visible=True";
mostCurrent._lbl_finger.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=852003;
 //BA.debugLineNum = 852003;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
mostCurrent._lbl_finger.setTextColor(((int)0xff0b6200));
RDebugUtils.currentLine=852004;
 //BA.debugLineNum = 852004;BA.debugLine="finger_scaning";
_finger_scaning();
RDebugUtils.currentLine=852005;
 //BA.debugLineNum = 852005;BA.debugLine="tim_lock_lbl.Enabled=True";
_tim_lock_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }}
;
 } 
       catch (Exception e27) {
			processBA.setLastException(e27);RDebugUtils.currentLine=852009;
 //BA.debugLineNum = 852009;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("7852009",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
 };
 }else {
RDebugUtils.currentLine=852016;
 //BA.debugLineNum = 852016;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=852023;
 //BA.debugLineNum = 852023;BA.debugLine="End Sub";
return "";
}
}