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
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
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
vis = vis | (info_activity.mostCurrent != null);
vis = vis | (ayabzahab_activity.mostCurrent != null);
vis = vis | (bime_activity.mostCurrent != null);
vis = vis | (calc_activity.mostCurrent != null);
vis = vis | (comment_activity.mostCurrent != null);
vis = vis | (darsad_activity.mostCurrent != null);
vis = vis | (eidi_activity.mostCurrent != null);
vis = vis | (fast_run_activity.mostCurrent != null);
vis = vis | (food_activity.mostCurrent != null);
vis = vis | (ganon_activity.mostCurrent != null);
vis = vis | (gestha_activity.mostCurrent != null);
vis = vis | (help_kharid_activity.mostCurrent != null);
vis = vis | (hogog_activity.mostCurrent != null);
vis = vis | (morakhasi_activity.mostCurrent != null);
vis = vis | (mosaedeh_activity.mostCurrent != null);
vis = vis | (padash_activity.mostCurrent != null);
vis = vis | (payankar_activity.mostCurrent != null);
vis = vis | (sabt2_activity.mostCurrent != null);
vis = vis | (sayer_activity.mostCurrent != null);
vis = vis | (setting_activity.mostCurrent != null);
vis = vis | (setting_hogog_activity.mostCurrent != null);
vis = vis | (shift_activity.mostCurrent != null);
vis = vis | (show_gozaresh_activity.mostCurrent != null);
vis = vis | (step0_activity.mostCurrent != null);
vis = vis | (step1_activity.mostCurrent != null);
vis = vis | (step2_activity.mostCurrent != null);
vis = vis | (vam_activity.mostCurrent != null);
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
            if (ayabzahab_activity.previousOne != null) {
				__a = ayabzahab_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(ayabzahab_activity.mostCurrent == null ? null : ayabzahab_activity.mostCurrent.processBA);
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
            if (food_activity.previousOne != null) {
				__a = food_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(food_activity.mostCurrent == null ? null : food_activity.mostCurrent.processBA);
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
            if (gestha_activity.previousOne != null) {
				__a = gestha_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(gestha_activity.mostCurrent == null ? null : gestha_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (help_kharid_activity.previousOne != null) {
				__a = help_kharid_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(help_kharid_activity.mostCurrent == null ? null : help_kharid_activity.mostCurrent.processBA);
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
            if (mosaedeh_activity.previousOne != null) {
				__a = mosaedeh_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(mosaedeh_activity.mostCurrent == null ? null : mosaedeh_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (padash_activity.previousOne != null) {
				__a = padash_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(padash_activity.mostCurrent == null ? null : padash_activity.mostCurrent.processBA);
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
            if (sabt2_activity.previousOne != null) {
				__a = sabt2_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(sabt2_activity.mostCurrent == null ? null : sabt2_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (sayer_activity.previousOne != null) {
				__a = sayer_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(sayer_activity.mostCurrent == null ? null : sayer_activity.mostCurrent.processBA);
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
            if (vam_activity.previousOne != null) {
				__a = vam_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(vam_activity.mostCurrent == null ? null : vam_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, httputils2service.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static String _app_vesion = "";
public static anywheresoftware.b4a.objects.Timer _timer1 = null;
public static anywheresoftware.b4a.objects.Timer _tim_msg = null;
public static anywheresoftware.b4a.objects.Timer _tim_lock_lbl = null;
public static anywheresoftware.b4a.objects.Timer _tim_msg_newyear = null;
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
public static int _msg_page_show = 0;
public static String _current_idvam = "";
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
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
public anywheresoftware.b4a.objects.collections.List _list_mamoriat_id = null;
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
public b4a.example3.customlistview _cust_lv_mamoriat = null;
public static boolean _is_new_msg = false;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radio_ez_fog = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radio_ez_adi = null;
public b4a.example.dateutils _dateutils = null;
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
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
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
anywheresoftware.b4a.keywords.Common.LogImpl("2131079",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
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
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="dbCode.init_notfound(\"tog_maliat\",1)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"tog_maliat",BA.NumberToString(1));
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="dbCode.init_notfound(\"tog_bime\",1)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"tog_bime",BA.NumberToString(1));
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="dbCode.init_notfound(\"tog_food\",1)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"tog_food",BA.NumberToString(1));
RDebugUtils.currentLine=131100;
 //BA.debugLineNum = 131100;BA.debugLine="dbCode.init_notfound(\"tog_vam\",1)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"tog_vam",BA.NumberToString(1));
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="dbCode.init_notfound(\"tog_ayab\",1)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"tog_ayab",BA.NumberToString(1));
RDebugUtils.currentLine=131102;
 //BA.debugLineNum = 131102;BA.debugLine="dbCode.init_notfound(\"tog_padash\",1)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"tog_padash",BA.NumberToString(1));
RDebugUtils.currentLine=131103;
 //BA.debugLineNum = 131103;BA.debugLine="dbCode.init_notfound(\"tog_mosaede\",1)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"tog_mosaede",BA.NumberToString(1));
RDebugUtils.currentLine=131104;
 //BA.debugLineNum = 131104;BA.debugLine="dbCode.init_notfound(\"tog_sayer\",1)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"tog_sayer",BA.NumberToString(1));
RDebugUtils.currentLine=131106;
 //BA.debugLineNum = 131106;BA.debugLine="dbCode.init_notfound(\"refind_time_m\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"refind_time_m",BA.NumberToString(0));
RDebugUtils.currentLine=131110;
 //BA.debugLineNum = 131110;BA.debugLine="dbCode.install_db_tbl_taradod";
mostCurrent._dbcode._install_db_tbl_taradod /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=131111;
 //BA.debugLineNum = 131111;BA.debugLine="dbCode.install_db_tbl_myCalander";
mostCurrent._dbcode._install_db_tbl_mycalander /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=131112;
 //BA.debugLineNum = 131112;BA.debugLine="dbCode.cheng_tagvim";
mostCurrent._dbcode._cheng_tagvim /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=131113;
 //BA.debugLineNum = 131113;BA.debugLine="dbCode.install_db_tbl_onvanha";
mostCurrent._dbcode._install_db_tbl_onvanha /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=131115;
 //BA.debugLineNum = 131115;BA.debugLine="dbCode.refind_time_to_m";
mostCurrent._dbcode._refind_time_to_m /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=131119;
 //BA.debugLineNum = 131119;BA.debugLine="img1.Initialize(LoadBitmap(File.DirAssets,\"m1.png";
mostCurrent._img1.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m1.png").getObject()));
RDebugUtils.currentLine=131120;
 //BA.debugLineNum = 131120;BA.debugLine="img1.Gravity=Gravity.FILL";
mostCurrent._img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=131122;
 //BA.debugLineNum = 131122;BA.debugLine="img2.Initialize(LoadBitmap(File.DirAssets,\"m2.png";
mostCurrent._img2.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m2.png").getObject()));
RDebugUtils.currentLine=131123;
 //BA.debugLineNum = 131123;BA.debugLine="img2.Gravity=Gravity.FILL";
mostCurrent._img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=131125;
 //BA.debugLineNum = 131125;BA.debugLine="img3.Initialize(LoadBitmap(File.DirAssets,\"m3.png";
mostCurrent._img3.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m3.png").getObject()));
RDebugUtils.currentLine=131126;
 //BA.debugLineNum = 131126;BA.debugLine="img3.Gravity=Gravity.FILL";
mostCurrent._img3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=131128;
 //BA.debugLineNum = 131128;BA.debugLine="If(FirstTime)Then";
if ((_firsttime)) { 
RDebugUtils.currentLine=131129;
 //BA.debugLineNum = 131129;BA.debugLine="Activity.LoadLayout(\"splash_layout\")";
mostCurrent._activity.LoadLayout("splash_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131130;
 //BA.debugLineNum = 131130;BA.debugLine="lbl_vesion_app.Text=app_vesion";
mostCurrent._lbl_vesion_app.setText(BA.ObjectToCharSequence(_app_vesion));
RDebugUtils.currentLine=131131;
 //BA.debugLineNum = 131131;BA.debugLine="cv_loader.Show";
mostCurrent._cv_loader._show /*String*/ (null);
RDebugUtils.currentLine=131132;
 //BA.debugLineNum = 131132;BA.debugLine="timer1.Initialize(\"timer1\" , 1500)";
_timer1.Initialize(processBA,"timer1",(long) (1500));
RDebugUtils.currentLine=131134;
 //BA.debugLineNum = 131134;BA.debugLine="timer1.Enabled=True";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=131136;
 //BA.debugLineNum = 131136;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131137;
 //BA.debugLineNum = 131137;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
RDebugUtils.currentLine=131141;
 //BA.debugLineNum = 131141;BA.debugLine="moon.Initialize";
mostCurrent._moon.Initialize();
RDebugUtils.currentLine=131142;
 //BA.debugLineNum = 131142;BA.debugLine="moon.AddAll(Array As String(\"فروردین\", \"اردیبهشت\"";
mostCurrent._moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=131145;
 //BA.debugLineNum = 131145;BA.debugLine="strfun.Initialize";
mostCurrent._strfun._initialize(processBA);
RDebugUtils.currentLine=131149;
 //BA.debugLineNum = 131149;BA.debugLine="If(buy_index=1)Then";
if ((_buy_index==1)) { 
RDebugUtils.currentLine=131150;
 //BA.debugLineNum = 131150;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
RDebugUtils.currentLine=131151;
 //BA.debugLineNum = 131151;BA.debugLine="buy_index=0";
_buy_index = (int) (0);
 };
RDebugUtils.currentLine=131157;
 //BA.debugLineNum = 131157;BA.debugLine="tim_msg.Initialize(\"tim_msg\",4000)";
_tim_msg.Initialize(processBA,"tim_msg",(long) (4000));
RDebugUtils.currentLine=131159;
 //BA.debugLineNum = 131159;BA.debugLine="ls1.Initialize";
mostCurrent._ls1.Initialize();
RDebugUtils.currentLine=131160;
 //BA.debugLineNum = 131160;BA.debugLine="ls2.Initialize";
mostCurrent._ls2.Initialize();
RDebugUtils.currentLine=131161;
 //BA.debugLineNum = 131161;BA.debugLine="ls3.Initialize";
mostCurrent._ls3.Initialize();
RDebugUtils.currentLine=131164;
 //BA.debugLineNum = 131164;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1"))) { 
RDebugUtils.currentLine=131165;
 //BA.debugLineNum = 131165;BA.debugLine="ls1=File.ReadList(File.DirInternal,\"ls1\")";
mostCurrent._ls1 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1");
RDebugUtils.currentLine=131166;
 //BA.debugLineNum = 131166;BA.debugLine="ls2=File.ReadList(File.DirInternal,\"ls2\")";
mostCurrent._ls2 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls2");
RDebugUtils.currentLine=131167;
 //BA.debugLineNum = 131167;BA.debugLine="ls3=File.ReadList(File.DirInternal,\"ls3\")";
mostCurrent._ls3 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls3");
RDebugUtils.currentLine=131169;
 //BA.debugLineNum = 131169;BA.debugLine="last_notif=ls1.Get(ls1.Size-1)";
mostCurrent._last_notif = BA.ObjectToString(mostCurrent._ls1.Get((int) (mostCurrent._ls1.getSize()-1)));
RDebugUtils.currentLine=131170;
 //BA.debugLineNum = 131170;BA.debugLine="is_now_instal=False";
_is_now_instal = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=131178;
 //BA.debugLineNum = 131178;BA.debugLine="If(myfunc.check_karid=True)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=131179;
 //BA.debugLineNum = 131179;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
 }else {
RDebugUtils.currentLine=131181;
 //BA.debugLineNum = 131181;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
 };
RDebugUtils.currentLine=131199;
 //BA.debugLineNum = 131199;BA.debugLine="If(File.Exists(File.DirInternal,\"phonNum\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum"))) { 
RDebugUtils.currentLine=131200;
 //BA.debugLineNum = 131200;BA.debugLine="phon_num=File.ReadString(File.DirInternal,\"phonN";
_phon_num = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum");
 };
RDebugUtils.currentLine=131203;
 //BA.debugLineNum = 131203;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc"))) { 
RDebugUtils.currentLine=131204;
 //BA.debugLineNum = 131204;BA.debugLine="Dim ls_user As List";
_ls_user = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=131205;
 //BA.debugLineNum = 131205;BA.debugLine="ls_user.Initialize";
_ls_user.Initialize();
RDebugUtils.currentLine=131206;
 //BA.debugLineNum = 131206;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAcc\"";
_ls_user = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
RDebugUtils.currentLine=131207;
 //BA.debugLineNum = 131207;BA.debugLine="user_nameFamili=ls_user.Get(0)";
_user_namefamili = BA.ObjectToString(_ls_user.Get((int) (0)));
 };
RDebugUtils.currentLine=131212;
 //BA.debugLineNum = 131212;BA.debugLine="End Sub";
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
int _result = 0;
RDebugUtils.currentLine=47448064;
 //BA.debugLineNum = 47448064;BA.debugLine="Private Sub btn_menu_home_Click";
RDebugUtils.currentLine=47448065;
 //BA.debugLineNum = 47448065;BA.debugLine="index_page=1";
_index_page = (int) (1);
RDebugUtils.currentLine=47448066;
 //BA.debugLineNum = 47448066;BA.debugLine="pan_imag.Background=img1";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img1.getObject()));
RDebugUtils.currentLine=47448068;
 //BA.debugLineNum = 47448068;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
RDebugUtils.currentLine=47448069;
 //BA.debugLineNum = 47448069;BA.debugLine="pan_main.LoadLayout(\"home_layout\")";
mostCurrent._pan_main.LoadLayout("home_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=47448070;
 //BA.debugLineNum = 47448070;BA.debugLine="scv_home_item.Panel.LoadLayout(\"home_item\")";
mostCurrent._scv_home_item.getPanel().LoadLayout("home_item",mostCurrent.activityBA);
RDebugUtils.currentLine=47448071;
 //BA.debugLineNum = 47448071;BA.debugLine="lbl_date_home.Text=myfunc.fa2en(persianDate.Persi";
mostCurrent._lbl_date_home.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianLongDate())));
RDebugUtils.currentLine=47448073;
 //BA.debugLineNum = 47448073;BA.debugLine="saat_kar_min =dbCode.get_setting_byName(\"saat_kar";
_saat_kar_min = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_darRoz")));
RDebugUtils.currentLine=47448075;
 //BA.debugLineNum = 47448075;BA.debugLine="If(saat_kar_min<18)Then";
if ((_saat_kar_min<18)) { 
RDebugUtils.currentLine=47448076;
 //BA.debugLineNum = 47448076;BA.debugLine="myfunc.help_man(\"توجه\",\"لطفا ساعت کاری خود را تن";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","لطفا ساعت کاری خود را تنظیم کنید");
 };
RDebugUtils.currentLine=47448079;
 //BA.debugLineNum = 47448079;BA.debugLine="Dim list_ezafekari As List";
_list_ezafekari = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=47448080;
 //BA.debugLineNum = 47448080;BA.debugLine="list_ezafekari.Initialize";
_list_ezafekari.Initialize();
RDebugUtils.currentLine=47448082;
 //BA.debugLineNum = 47448082;BA.debugLine="year_num=myfunc.fa2en(persianDate.PersianYear)";
_year_num = mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()));
RDebugUtils.currentLine=47448084;
 //BA.debugLineNum = 47448084;BA.debugLine="moon_num=myfunc.convert_adad(persianDate.PersianM";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_persiandate.getPersianMonth());
RDebugUtils.currentLine=47448086;
 //BA.debugLineNum = 47448086;BA.debugLine="list_ezafekari=dbCode.all_ezafekari_mah(year_num,";
_list_ezafekari = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num,(int) (1));
RDebugUtils.currentLine=47448092;
 //BA.debugLineNum = 47448092;BA.debugLine="Dim list_morakhasi As List";
_list_morakhasi = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=47448093;
 //BA.debugLineNum = 47448093;BA.debugLine="list_morakhasi.Initialize";
_list_morakhasi.Initialize();
RDebugUtils.currentLine=47448095;
 //BA.debugLineNum = 47448095;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(year_num,";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num);
RDebugUtils.currentLine=47448098;
 //BA.debugLineNum = 47448098;BA.debugLine="lbl_ezafekari_mah_m.Text=list_ezafekari.Get(1)&\"";
mostCurrent._lbl_ezafekari_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (1)))+" دقیقه "));
RDebugUtils.currentLine=47448099;
 //BA.debugLineNum = 47448099;BA.debugLine="lbl_ezafekari_mah_h.Text=list_ezafekari.Get(0)&\"";
mostCurrent._lbl_ezafekari_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (0)))+" ساعت "));
RDebugUtils.currentLine=47448101;
 //BA.debugLineNum = 47448101;BA.debugLine="lbl_morakhasi_mah_m.Text=list_morakhasi.Get(2)&\"";
mostCurrent._lbl_morakhasi_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (2)))+" دقیقه "));
RDebugUtils.currentLine=47448102;
 //BA.debugLineNum = 47448102;BA.debugLine="lbl_morakhasi_mah_h.Text=list_morakhasi.Get(1)&\"";
mostCurrent._lbl_morakhasi_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (1)))+" ساعت "));
RDebugUtils.currentLine=47448103;
 //BA.debugLineNum = 47448103;BA.debugLine="lbl_morakhasi_mah_d.Text=list_morakhasi.Get(0)&\"";
mostCurrent._lbl_morakhasi_mah_d.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (0)))+" روز "));
RDebugUtils.currentLine=47448105;
 //BA.debugLineNum = 47448105;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=47448107;
 //BA.debugLineNum = 47448107;BA.debugLine="lbl_vip.TextColor=0xFFFFD800";
mostCurrent._lbl_vip.setTextColor(((int)0xffffd800));
RDebugUtils.currentLine=47448108;
 //BA.debugLineNum = 47448108;BA.debugLine="lbl_vip2.Text=\"نسخه طلایی\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه طلایی"));
 }else {
RDebugUtils.currentLine=47448111;
 //BA.debugLineNum = 47448111;BA.debugLine="lbl_vip.TextColor=Colors.Green";
mostCurrent._lbl_vip.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=47448112;
 //BA.debugLineNum = 47448112;BA.debugLine="lbl_vip2.Text=\"نسخه هدیه\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه هدیه"));
 };
RDebugUtils.currentLine=47448117;
 //BA.debugLineNum = 47448117;BA.debugLine="If (File.Exists(File.DirInternal,\"help_start\")=Fa";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=47448118;
 //BA.debugLineNum = 47448118;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=47448119;
 //BA.debugLineNum = 47448119;BA.debugLine="File.WriteString(File.DirInternal,\"help_start\",\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start","");
 };
RDebugUtils.currentLine=47448125;
 //BA.debugLineNum = 47448125;BA.debugLine="If (File.Exists(File.DirInternal,\"setcolor.txt\"))";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt"))) { 
RDebugUtils.currentLine=47448126;
 //BA.debugLineNum = 47448126;BA.debugLine="Dim list_color As List";
_list_color = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=47448127;
 //BA.debugLineNum = 47448127;BA.debugLine="list_color.Initialize";
_list_color.Initialize();
RDebugUtils.currentLine=47448128;
 //BA.debugLineNum = 47448128;BA.debugLine="list_color = File.ReadList(File.DirInternal,\"set";
_list_color = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt");
RDebugUtils.currentLine=47448130;
 //BA.debugLineNum = 47448130;BA.debugLine="Dim col As List";
_col = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=47448131;
 //BA.debugLineNum = 47448131;BA.debugLine="col.Initialize";
_col.Initialize();
RDebugUtils.currentLine=47448133;
 //BA.debugLineNum = 47448133;BA.debugLine="Dim col_font As List";
_col_font = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=47448134;
 //BA.debugLineNum = 47448134;BA.debugLine="col_font.Initialize";
_col_font.Initialize();
RDebugUtils.currentLine=47448136;
 //BA.debugLineNum = 47448136;BA.debugLine="col=Regex.Split(\",\",list_color.Get(0))";
_col = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (0)))));
RDebugUtils.currentLine=47448137;
 //BA.debugLineNum = 47448137;BA.debugLine="col_font=Regex.Split(\",\",list_color.Get(1))";
_col_font = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (1)))));
RDebugUtils.currentLine=47448141;
 //BA.debugLineNum = 47448141;BA.debugLine="color1= col.Get(0)";
_color1 = (int)(BA.ObjectToNumber(_col.Get((int) (0))));
RDebugUtils.currentLine=47448142;
 //BA.debugLineNum = 47448142;BA.debugLine="color2= col.Get(1)";
_color2 = (int)(BA.ObjectToNumber(_col.Get((int) (1))));
RDebugUtils.currentLine=47448143;
 //BA.debugLineNum = 47448143;BA.debugLine="color_index=col.Get(2)  'index color";
_color_index = (int)(BA.ObjectToNumber(_col.Get((int) (2))));
RDebugUtils.currentLine=47448144;
 //BA.debugLineNum = 47448144;BA.debugLine="color3= col.Get(3)";
_color3 = (int)(BA.ObjectToNumber(_col.Get((int) (3))));
RDebugUtils.currentLine=47448145;
 //BA.debugLineNum = 47448145;BA.debugLine="color4= col.Get(4)";
_color4 = (int)(BA.ObjectToNumber(_col.Get((int) (4))));
RDebugUtils.currentLine=47448146;
 //BA.debugLineNum = 47448146;BA.debugLine="color5= col.Get(5)";
_color5 = (int)(BA.ObjectToNumber(_col.Get((int) (5))));
RDebugUtils.currentLine=47448148;
 //BA.debugLineNum = 47448148;BA.debugLine="main_font=col_font.Get(0)";
_main_font = BA.ObjectToString(_col_font.Get((int) (0)));
RDebugUtils.currentLine=47448149;
 //BA.debugLineNum = 47448149;BA.debugLine="size_f1=col_font.Get(1)";
_size_f1 = (int)(BA.ObjectToNumber(_col_font.Get((int) (1))));
RDebugUtils.currentLine=47448150;
 //BA.debugLineNum = 47448150;BA.debugLine="size_f2=col_font.Get(2)";
_size_f2 = (int)(BA.ObjectToNumber(_col_font.Get((int) (2))));
RDebugUtils.currentLine=47448151;
 //BA.debugLineNum = 47448151;BA.debugLine="size_f3=col_font.Get(3)";
_size_f3 = (int)(BA.ObjectToNumber(_col_font.Get((int) (3))));
 }else {
RDebugUtils.currentLine=47448155;
 //BA.debugLineNum = 47448155;BA.debugLine="color_index=1";
_color_index = (int) (1);
RDebugUtils.currentLine=47448156;
 //BA.debugLineNum = 47448156;BA.debugLine="color1= 0XFF69AC00";
_color1 = ((int)0xff69ac00);
RDebugUtils.currentLine=47448157;
 //BA.debugLineNum = 47448157;BA.debugLine="color2= 0xFF00C7C7";
_color2 = ((int)0xff00c7c7);
RDebugUtils.currentLine=47448158;
 //BA.debugLineNum = 47448158;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=47448159;
 //BA.debugLineNum = 47448159;BA.debugLine="color4=0XFF69AC00";
_color4 = ((int)0xff69ac00);
RDebugUtils.currentLine=47448160;
 //BA.debugLineNum = 47448160;BA.debugLine="color5=0XFF69AC00";
_color5 = ((int)0xff69ac00);
RDebugUtils.currentLine=47448162;
 //BA.debugLineNum = 47448162;BA.debugLine="main_font=\"یکان\"";
_main_font = "یکان";
RDebugUtils.currentLine=47448163;
 //BA.debugLineNum = 47448163;BA.debugLine="size_f1=17";
_size_f1 = (int) (17);
RDebugUtils.currentLine=47448164;
 //BA.debugLineNum = 47448164;BA.debugLine="size_f2=15";
_size_f2 = (int) (15);
RDebugUtils.currentLine=47448165;
 //BA.debugLineNum = 47448165;BA.debugLine="size_f3=13";
_size_f3 = (int) (13);
RDebugUtils.currentLine=47448168;
 //BA.debugLineNum = 47448168;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(_color1)+","+BA.NumberToString(_color2)+","+BA.NumberToString(_color_index)+","+BA.NumberToString(_color3)+","+BA.NumberToString(_color4)+","+BA.NumberToString(_color5)+anywheresoftware.b4a.keywords.Common.CRLF+_main_font+","+BA.NumberToString(_size_f1)+","+BA.NumberToString(_size_f2)+","+BA.NumberToString(_size_f3));
 };
RDebugUtils.currentLine=47448176;
 //BA.debugLineNum = 47448176;BA.debugLine="Dim dw As GradientDrawable";
_dw = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=47448177;
 //BA.debugLineNum = 47448177;BA.debugLine="Dim clr() As Int = Array  As Int(color1,color2)";
_clr = new int[]{_color1,_color2};
RDebugUtils.currentLine=47448178;
 //BA.debugLineNum = 47448178;BA.debugLine="dw.Initialize(\"TOP_BOTTOM\",clr)";
_dw.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clr);
RDebugUtils.currentLine=47448179;
 //BA.debugLineNum = 47448179;BA.debugLine="dw.CornerRadius=50dip";
_dw.setCornerRadius((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))));
RDebugUtils.currentLine=47448180;
 //BA.debugLineNum = 47448180;BA.debugLine="Panel1.Background=dw";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_dw.getObject()));
RDebugUtils.currentLine=47448188;
 //BA.debugLineNum = 47448188;BA.debugLine="lbl_box_title.Color=color4";
mostCurrent._lbl_box_title.setColor(_color4);
RDebugUtils.currentLine=47448197;
 //BA.debugLineNum = 47448197;BA.debugLine="get_today_shift";
_get_today_shift();
RDebugUtils.currentLine=47448200;
 //BA.debugLineNum = 47448200;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=47448202;
 //BA.debugLineNum = 47448202;BA.debugLine="If(is_new_msg=True)Then";
if ((_is_new_msg==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=47448203;
 //BA.debugLineNum = 47448203;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=47448204;
 //BA.debugLineNum = 47448204;BA.debugLine="result = Msgbox2(\"آیا الان مشاهده میکنید؟\", \"پیا";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا الان مشاهده میکنید؟"),BA.ObjectToCharSequence("پیام جدید"),"بله","بعدا","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"notif.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=47448205;
 //BA.debugLineNum = 47448205;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=47448206;
 //BA.debugLineNum = 47448206;BA.debugLine="lbl_account_Click";
_lbl_account_click();
RDebugUtils.currentLine=47448207;
 //BA.debugLineNum = 47448207;BA.debugLine="msg_page_show=1";
_msg_page_show = (int) (1);
 };
 };
RDebugUtils.currentLine=47448214;
 //BA.debugLineNum = 47448214;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip_click", null));}
RDebugUtils.currentLine=51314688;
 //BA.debugLineNum = 51314688;BA.debugLine="Private Sub lbl_vip_Click";
RDebugUtils.currentLine=51314690;
 //BA.debugLineNum = 51314690;BA.debugLine="pan_all_noskhe.Visible=True";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=51314691;
 //BA.debugLineNum = 51314691;BA.debugLine="scroll_v_noskhe.Panel.LoadLayout(\"noske_item\")";
mostCurrent._scroll_v_noskhe.getPanel().LoadLayout("noske_item",mostCurrent.activityBA);
RDebugUtils.currentLine=51314693;
 //BA.debugLineNum = 51314693;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=51314694;
 //BA.debugLineNum = 51314694;BA.debugLine="lbl_show_vip.Text=\"نسخه کامل ( طلایی ) فعال می ب";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه کامل ( طلایی ) فعال می باشد."));
 }else {
RDebugUtils.currentLine=51314696;
 //BA.debugLineNum = 51314696;BA.debugLine="lbl_show_vip.Text=\"نسخه معمولی ( هدیه ) فعال می";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه معمولی ( هدیه ) فعال می باشد."));
 };
RDebugUtils.currentLine=51314699;
 //BA.debugLineNum = 51314699;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "http_initial_1", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "http_initial_1", new Object[] {_type1}));}
String _send = "";
RDebugUtils.currentLine=45875200;
 //BA.debugLineNum = 45875200;BA.debugLine="Sub http_initial_1(type1 As Int)";
RDebugUtils.currentLine=45875201;
 //BA.debugLineNum = 45875201;BA.debugLine="ht.Initialize(\"ht\",Me)";
mostCurrent._ht._initialize /*String*/ (null,processBA,"ht",main.getObject());
RDebugUtils.currentLine=45875202;
 //BA.debugLineNum = 45875202;BA.debugLine="Dim send As String";
_send = "";
RDebugUtils.currentLine=45875203;
 //BA.debugLineNum = 45875203;BA.debugLine="send = \"username=mahdi&password=1234&div_id=\"&pho";
_send = "username=mahdi&password=1234&div_id="+_phon.GetSettings("android_id")+"&sdk_ver="+BA.NumberToString(_phon.getSdkVersion())+"&oprator="+_phon.GetNetworkOperatorName()+"&type_app="+BA.NumberToString(_type1)+"&div_model="+_phon.getModel()+"&last_notif="+mostCurrent._last_notif+"&var=0&is_now_instal="+BA.ObjectToString(_is_now_instal)+"&version_code="+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Application.getVersionCode());
RDebugUtils.currentLine=45875204;
 //BA.debugLineNum = 45875204;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/ezafekari2";
mostCurrent._ht._poststring /*String*/ (null,"https://taravatgroup.ir/ezafekari2.php",_send);
RDebugUtils.currentLine=45875207;
 //BA.debugLineNum = 45875207;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
int _result = 0;
RDebugUtils.currentLine=49086464;
 //BA.debugLineNum = 49086464;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=49086465;
 //BA.debugLineNum = 49086465;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=49086466;
 //BA.debugLineNum = 49086466;BA.debugLine="If (pan_all_msgNewYear.Visible=True)Then";
if ((mostCurrent._pan_all_msgnewyear.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=49086467;
 //BA.debugLineNum = 49086467;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=49086469;
 //BA.debugLineNum = 49086469;BA.debugLine="else If (pan_help.Visible=True)Then";
if ((mostCurrent._pan_help.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=49086470;
 //BA.debugLineNum = 49086470;BA.debugLine="lbl_close_help_Click";
_lbl_close_help_click();
 }else 
{RDebugUtils.currentLine=49086472;
 //BA.debugLineNum = 49086472;BA.debugLine="Else If (pan_all.Visible=True )Then";
if ((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=49086474;
 //BA.debugLineNum = 49086474;BA.debugLine="If(pan_all2.Visible=True)Then";
if ((mostCurrent._pan_all2.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=49086475;
 //BA.debugLineNum = 49086475;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=49086477;
 //BA.debugLineNum = 49086477;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }else 
{RDebugUtils.currentLine=49086480;
 //BA.debugLineNum = 49086480;BA.debugLine="Else if(pan_notifi_all.Visible==True) Then";
if ((mostCurrent._pan_notifi_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=49086481;
 //BA.debugLineNum = 49086481;BA.debugLine="lbl_close_notif_Click";
_lbl_close_notif_click();
 }else 
{RDebugUtils.currentLine=49086482;
 //BA.debugLineNum = 49086482;BA.debugLine="Else If(index_page=2 Or index_page=3)Then";
if ((_index_page==2 || _index_page==3)) { 
RDebugUtils.currentLine=49086483;
 //BA.debugLineNum = 49086483;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 }else 
{RDebugUtils.currentLine=49086484;
 //BA.debugLineNum = 49086484;BA.debugLine="Else If(pan_all_noskhe.Visible==True)Then";
if ((mostCurrent._pan_all_noskhe.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=49086485;
 //BA.debugLineNum = 49086485;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
 }else 
{RDebugUtils.currentLine=49086486;
 //BA.debugLineNum = 49086486;BA.debugLine="Else If(pan_all_liteMenu.Visible==True)Then";
if ((mostCurrent._pan_all_litemenu.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=49086487;
 //BA.debugLineNum = 49086487;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=49086488;
 //BA.debugLineNum = 49086488;BA.debugLine="Else If (pan_all_chekUpdate.Visible==True)Then";
if ((mostCurrent._pan_all_chekupdate.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=49086489;
 //BA.debugLineNum = 49086489;BA.debugLine="pan_all_chekUpdate.Visible=False";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=49086490;
 //BA.debugLineNum = 49086490;BA.debugLine="Else If(pan_all_FT.Visible=True)Then";
if ((mostCurrent._pan_all_ft.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=49086491;
 //BA.debugLineNum = 49086491;BA.debugLine="pan_all_FT.Visible=False";
mostCurrent._pan_all_ft.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=49086495;
 //BA.debugLineNum = 49086495;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=49086496;
 //BA.debugLineNum = 49086496;BA.debugLine="result = Msgbox2(\"آیا قصد خروج دارید؟\", \"خروج\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا قصد خروج دارید؟"),BA.ObjectToCharSequence("خروج"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=49086497;
 //BA.debugLineNum = 49086497;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=49086498;
 //BA.debugLineNum = 49086498;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 };
 }}}}}}}}}
;
RDebugUtils.currentLine=49086504;
 //BA.debugLineNum = 49086504;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=49086506;
 //BA.debugLineNum = 49086506;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=49086508;
 //BA.debugLineNum = 49086508;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_close_help_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_help_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_help_click", null));}
RDebugUtils.currentLine=51445760;
 //BA.debugLineNum = 51445760;BA.debugLine="Private Sub lbl_close_help_Click";
RDebugUtils.currentLine=51445761;
 //BA.debugLineNum = 51445761;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51445762;
 //BA.debugLineNum = 51445762;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_notif_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_notif_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_notif_click", null));}
RDebugUtils.currentLine=46137344;
 //BA.debugLineNum = 46137344;BA.debugLine="Private Sub lbl_close_notif_Click";
RDebugUtils.currentLine=46137345;
 //BA.debugLineNum = 46137345;BA.debugLine="pan_notifi_all.Visible=False";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46137346;
 //BA.debugLineNum = 46137346;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_noskhe_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_noskhe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_noskhe_click", null));}
RDebugUtils.currentLine=52363264;
 //BA.debugLineNum = 52363264;BA.debugLine="Private Sub pan_all_noskhe_Click";
RDebugUtils.currentLine=52363265;
 //BA.debugLineNum = 52363265;BA.debugLine="pan_all_noskhe.Visible=False";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=52363266;
 //BA.debugLineNum = 52363266;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _add_end() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_end", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_end", null));}
boolean _chek = false;
anywheresoftware.b4a.objects.collections.List _alist = null;
RDebugUtils.currentLine=48758784;
 //BA.debugLineNum = 48758784;BA.debugLine="Sub add_end";
RDebugUtils.currentLine=48758785;
 //BA.debugLineNum = 48758785;BA.debugLine="Dim chek As Boolean";
_chek = false;
RDebugUtils.currentLine=48758786;
 //BA.debugLineNum = 48758786;BA.debugLine="chek=myfunc.check_karid";
_chek = mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=48758787;
 //BA.debugLineNum = 48758787;BA.debugLine="Dim alist As List";
_alist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=48758788;
 //BA.debugLineNum = 48758788;BA.debugLine="alist.Initialize";
_alist.Initialize();
RDebugUtils.currentLine=48758790;
 //BA.debugLineNum = 48758790;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(myfunc";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth())))));
RDebugUtils.currentLine=48758793;
 //BA.debugLineNum = 48758793;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(persianDate.Pe";
_alist = mostCurrent._myfunc._num_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear())),_moon_num);
RDebugUtils.currentLine=48758796;
 //BA.debugLineNum = 48758796;BA.debugLine="If(index_box=1) Then";
if ((_index_box==1)) { 
RDebugUtils.currentLine=48758797;
 //BA.debugLineNum = 48758797;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=48758798;
 //BA.debugLineNum = 48758798;BA.debugLine="If(alist.Get(0)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (0))))<5)) { 
RDebugUtils.currentLine=48758799;
 //BA.debugLineNum = 48758799;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 }else {
RDebugUtils.currentLine=48758801;
 //BA.debugLineNum = 48758801;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=48758805;
 //BA.debugLineNum = 48758805;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 };
 }else 
{RDebugUtils.currentLine=48758808;
 //BA.debugLineNum = 48758808;BA.debugLine="Else If (index_box=2) Then";
if ((_index_box==2)) { 
RDebugUtils.currentLine=48758810;
 //BA.debugLineNum = 48758810;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=48758811;
 //BA.debugLineNum = 48758811;BA.debugLine="If(alist.Get(1)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (1))))<5)) { 
RDebugUtils.currentLine=48758812;
 //BA.debugLineNum = 48758812;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 }else {
RDebugUtils.currentLine=48758814;
 //BA.debugLineNum = 48758814;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=48758817;
 //BA.debugLineNum = 48758817;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 };
 }else 
{RDebugUtils.currentLine=48758820;
 //BA.debugLineNum = 48758820;BA.debugLine="Else If (index_box=3) Then";
if ((_index_box==3)) { 
RDebugUtils.currentLine=48758822;
 //BA.debugLineNum = 48758822;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=48758823;
 //BA.debugLineNum = 48758823;BA.debugLine="If(alist.Get(3)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (3))))<5)) { 
RDebugUtils.currentLine=48758824;
 //BA.debugLineNum = 48758824;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 }else {
RDebugUtils.currentLine=48758826;
 //BA.debugLineNum = 48758826;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=48758829;
 //BA.debugLineNum = 48758829;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 }else 
{RDebugUtils.currentLine=48758833;
 //BA.debugLineNum = 48758833;BA.debugLine="Else If (index_box=4) Then";
if ((_index_box==4)) { 
RDebugUtils.currentLine=48758835;
 //BA.debugLineNum = 48758835;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=48758836;
 //BA.debugLineNum = 48758836;BA.debugLine="If(alist.Get(3)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (3))))<5)) { 
RDebugUtils.currentLine=48758837;
 //BA.debugLineNum = 48758837;BA.debugLine="add_taradod_fast";
_add_taradod_fast();
 }else {
RDebugUtils.currentLine=48758839;
 //BA.debugLineNum = 48758839;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
RDebugUtils.currentLine=48758840;
 //BA.debugLineNum = 48758840;BA.debugLine="lbl_tim_vorod_FT.Text=\"00:00\"";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=48758841;
 //BA.debugLineNum = 48758841;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
RDebugUtils.currentLine=48758842;
 //BA.debugLineNum = 48758842;BA.debugLine="pan_all_FT_Click";
_pan_all_ft_click();
 };
 }else {
RDebugUtils.currentLine=48758845;
 //BA.debugLineNum = 48758845;BA.debugLine="add_taradod_fast";
_add_taradod_fast();
 };
 }else 
{RDebugUtils.currentLine=48758847;
 //BA.debugLineNum = 48758847;BA.debugLine="Else If (index_box=5) Then";
if ((_index_box==5)) { 
RDebugUtils.currentLine=48758849;
 //BA.debugLineNum = 48758849;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=48758850;
 //BA.debugLineNum = 48758850;BA.debugLine="If(alist.Get(4)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (4))))<5)) { 
RDebugUtils.currentLine=48758851;
 //BA.debugLineNum = 48758851;BA.debugLine="add_mamoriat_sub";
_add_mamoriat_sub();
 }else {
RDebugUtils.currentLine=48758853;
 //BA.debugLineNum = 48758853;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=48758857;
 //BA.debugLineNum = 48758857;BA.debugLine="add_mamoriat_sub";
_add_mamoriat_sub();
 };
 }}}}}
;
RDebugUtils.currentLine=48758861;
 //BA.debugLineNum = 48758861;BA.debugLine="End Sub";
return "";
}
public static String  _add_ezafe_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_ezafe_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_ezafe_sub", null));}
int _state_mod = 0;
String _str_mod = "";
boolean _result_a = false;
anywheresoftware.b4a.objects.collections.List _ls_temp_time1 = null;
RDebugUtils.currentLine=48824320;
 //BA.debugLineNum = 48824320;BA.debugLine="Sub add_ezafe_sub";
RDebugUtils.currentLine=48824321;
 //BA.debugLineNum = 48824321;BA.debugLine="Dim state_mod As Int=0";
_state_mod = (int) (0);
RDebugUtils.currentLine=48824322;
 //BA.debugLineNum = 48824322;BA.debugLine="Dim str_mod As String=\"\"";
_str_mod = "";
RDebugUtils.currentLine=48824323;
 //BA.debugLineNum = 48824323;BA.debugLine="If(ckb_ezaf_taradod.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=48824324;
 //BA.debugLineNum = 48824324;BA.debugLine="state_mod=2";
_state_mod = (int) (2);
RDebugUtils.currentLine=48824325;
 //BA.debugLineNum = 48824325;BA.debugLine="str_mod=\" (فوق العاده)- \"";
_str_mod = " (فوق العاده)- ";
 }else {
RDebugUtils.currentLine=48824327;
 //BA.debugLineNum = 48824327;BA.debugLine="state_mod=0";
_state_mod = (int) (0);
 };
RDebugUtils.currentLine=48824331;
 //BA.debugLineNum = 48824331;BA.debugLine="Try";
try {RDebugUtils.currentLine=48824333;
 //BA.debugLineNum = 48824333;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=48824334;
 //BA.debugLineNum = 48824334;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=48824336;
 //BA.debugLineNum = 48824336;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0 Or day_bt<>0)T";
if ((_moon_bt!=0 || _year_bt!=0 || _day_bt!=0)) { 
RDebugUtils.currentLine=48824337;
 //BA.debugLineNum = 48824337;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=48824338;
 //BA.debugLineNum = 48824338;BA.debugLine="Else If (hour_bt=0 And min_bt=0 )Then";
if ((_hour_bt==0 && _min_bt==0)) { 
RDebugUtils.currentLine=48824339;
 //BA.debugLineNum = 48824339;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=48824343;
 //BA.debugLineNum = 48824343;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=48824344;
 //BA.debugLineNum = 48824344;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_ezafekari_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=48824346;
 //BA.debugLineNum = 48824346;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
RDebugUtils.currentLine=48824347;
 //BA.debugLineNum = 48824347;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ اضافه کاری وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
RDebugUtils.currentLine=48824348;
 //BA.debugLineNum = 48824348;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=48824349;
 //BA.debugLineNum = 48824349;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Te";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=48824351;
 //BA.debugLineNum = 48824351;BA.debugLine="Dim ls_temp_time1 As List";
_ls_temp_time1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=48824352;
 //BA.debugLineNum = 48824352;BA.debugLine="ls_temp_time1.Initialize";
_ls_temp_time1.Initialize();
RDebugUtils.currentLine=48824354;
 //BA.debugLineNum = 48824354;BA.debugLine="ls_temp_time1.Add(lbl_tim1.Text)";
_ls_temp_time1.Add((Object)(mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=48824355;
 //BA.debugLineNum = 48824355;BA.debugLine="ls_temp_time1.Add(lbl_tim2.Text)";
_ls_temp_time1.Add((Object)(mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=48824357;
 //BA.debugLineNum = 48824357;BA.debugLine="File.WriteList(File.DirInternal,\"temp_time1.";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time1.txt",_ls_temp_time1);
RDebugUtils.currentLine=48824359;
 //BA.debugLineNum = 48824359;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48824360;
 //BA.debugLineNum = 48824360;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=48824365;
 //BA.debugLineNum = 48824365;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=48824367;
 //BA.debugLineNum = 48824367;BA.debugLine="Dim ls_temp_time1 As List";
_ls_temp_time1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=48824368;
 //BA.debugLineNum = 48824368;BA.debugLine="ls_temp_time1.Initialize";
_ls_temp_time1.Initialize();
RDebugUtils.currentLine=48824370;
 //BA.debugLineNum = 48824370;BA.debugLine="ls_temp_time1.Add(lbl_tim1.Text)";
_ls_temp_time1.Add((Object)(mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=48824371;
 //BA.debugLineNum = 48824371;BA.debugLine="ls_temp_time1.Add(lbl_tim2.Text)";
_ls_temp_time1.Add((Object)(mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=48824373;
 //BA.debugLineNum = 48824373;BA.debugLine="File.WriteList(File.DirInternal,\"temp_time1.t";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time1.txt",_ls_temp_time1);
RDebugUtils.currentLine=48824375;
 //BA.debugLineNum = 48824375;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48824376;
 //BA.debugLineNum = 48824376;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=48824380;
 //BA.debugLineNum = 48824380;BA.debugLine="dbCode.edit_ezafekari(current_id_edit,date1,da";
mostCurrent._dbcode._edit_ezafekari /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=48824381;
 //BA.debugLineNum = 48824381;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48824384;
 //BA.debugLineNum = 48824384;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=48824389;
 //BA.debugLineNum = 48824389;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e49) {
			processBA.setLastException(e49);RDebugUtils.currentLine=48824395;
 //BA.debugLineNum = 48824395;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=48824400;
 //BA.debugLineNum = 48824400;BA.debugLine="End Sub";
return "";
}
public static String  _add_morakhasi_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_morakhasi_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_morakhasi_sub", null));}
String _str_noe2 = "";
boolean _result_a = false;
RDebugUtils.currentLine=48889856;
 //BA.debugLineNum = 48889856;BA.debugLine="Sub add_morakhasi_sub";
RDebugUtils.currentLine=48889857;
 //BA.debugLineNum = 48889857;BA.debugLine="Dim str_noe2 As String";
_str_noe2 = "";
RDebugUtils.currentLine=48889858;
 //BA.debugLineNum = 48889858;BA.debugLine="str_noe2=\"(\"&str_noe&\")- \"";
_str_noe2 = "("+mostCurrent._str_noe+")- ";
RDebugUtils.currentLine=48889860;
 //BA.debugLineNum = 48889860;BA.debugLine="Try";
try {RDebugUtils.currentLine=48889861;
 //BA.debugLineNum = 48889861;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
if ((_day_bt<0 || _hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=48889862;
 //BA.debugLineNum = 48889862;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=48889863;
 //BA.debugLineNum = 48889863;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0)Then";
if ((_moon_bt!=0 || _year_bt!=0)) { 
RDebugUtils.currentLine=48889864;
 //BA.debugLineNum = 48889864;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=48889865;
 //BA.debugLineNum = 48889865;BA.debugLine="Else If (hour_bt=0 And min_bt=0 And day_bt=0 )Th";
if ((_hour_bt==0 && _min_bt==0 && _day_bt==0)) { 
RDebugUtils.currentLine=48889866;
 //BA.debugLineNum = 48889866;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=48889871;
 //BA.debugLineNum = 48889871;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=48889872;
 //BA.debugLineNum = 48889872;BA.debugLine="If(dbCode.isexist_morakhasi_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_morakhasi_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=48889874;
 //BA.debugLineNum = 48889874;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
RDebugUtils.currentLine=48889875;
 //BA.debugLineNum = 48889875;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ مرخصی وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
RDebugUtils.currentLine=48889876;
 //BA.debugLineNum = 48889876;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=48889877;
 //BA.debugLineNum = 48889877;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Te";
mostCurrent._dbcode._add_morakhasi /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_noe2+mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
RDebugUtils.currentLine=48889878;
 //BA.debugLineNum = 48889878;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48889879;
 //BA.debugLineNum = 48889879;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=48889884;
 //BA.debugLineNum = 48889884;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_morakhasi /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_noe2+mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
RDebugUtils.currentLine=48889885;
 //BA.debugLineNum = 48889885;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48889886;
 //BA.debugLineNum = 48889886;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=48889889;
 //BA.debugLineNum = 48889889;BA.debugLine="dbCode.edit_morakhasi(current_id_edit,date1,da";
mostCurrent._dbcode._edit_morakhasi /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
RDebugUtils.currentLine=48889891;
 //BA.debugLineNum = 48889891;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48889892;
 //BA.debugLineNum = 48889892;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=48889899;
 //BA.debugLineNum = 48889899;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e33) {
			processBA.setLastException(e33);RDebugUtils.currentLine=48889905;
 //BA.debugLineNum = 48889905;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=48889910;
 //BA.debugLineNum = 48889910;BA.debugLine="End Sub";
return "";
}
public static String  _add_taradod_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_taradod_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_taradod_sub", null));}
boolean _result_a = false;
String _str_tozih1 = "";
String _str_tozih2 = "";
anywheresoftware.b4a.objects.collections.List _ls_temp_time2 = null;
String _str_tozih0 = "";
RDebugUtils.currentLine=48955392;
 //BA.debugLineNum = 48955392;BA.debugLine="Sub add_taradod_sub";
RDebugUtils.currentLine=48955393;
 //BA.debugLineNum = 48955393;BA.debugLine="Try";
try {RDebugUtils.currentLine=48955395;
 //BA.debugLineNum = 48955395;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=48955396;
 //BA.debugLineNum = 48955396;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=48955398;
 //BA.debugLineNum = 48955398;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0 Or day_bt>2)Th";
if ((_moon_bt!=0 || _year_bt!=0 || _day_bt>2)) { 
RDebugUtils.currentLine=48955399;
 //BA.debugLineNum = 48955399;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=48955400;
 //BA.debugLineNum = 48955400;BA.debugLine="Else If (hour_bt=0 And min_bt=0 )Then";
if ((_hour_bt==0 && _min_bt==0)) { 
RDebugUtils.currentLine=48955401;
 //BA.debugLineNum = 48955401;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=48955406;
 //BA.debugLineNum = 48955406;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=48955407;
 //BA.debugLineNum = 48955407;BA.debugLine="If(dbCode.isexist_taradod_by_date(date1)=True)";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=48955410;
 //BA.debugLineNum = 48955410;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
RDebugUtils.currentLine=48955411;
 //BA.debugLineNum = 48955411;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ تردد وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
RDebugUtils.currentLine=48955412;
 //BA.debugLineNum = 48955412;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=48955416;
 //BA.debugLineNum = 48955416;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_e";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=48955421;
 //BA.debugLineNum = 48955421;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=48955422;
 //BA.debugLineNum = 48955422;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=48955424;
 //BA.debugLineNum = 48955424;BA.debugLine="dbCode.add_ezafekari(date1,date2,\"0:0\",lbl_";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,"0:0",mostCurrent._lbl_tim2.getText(),(int) (0),(int) ((((double)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (0)))))+((double)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (2)))))*8)))),(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (1))))),_str_tozih1,(int) (0));
RDebugUtils.currentLine=48955426;
 //BA.debugLineNum = 48955426;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_tozih2,(int) (0));
 }else {
RDebugUtils.currentLine=48955428;
 //BA.debugLineNum = 48955428;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
 };
RDebugUtils.currentLine=48955431;
 //BA.debugLineNum = 48955431;BA.debugLine="Dim ls_temp_time2 As List";
_ls_temp_time2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=48955432;
 //BA.debugLineNum = 48955432;BA.debugLine="ls_temp_time2.Initialize";
_ls_temp_time2.Initialize();
RDebugUtils.currentLine=48955434;
 //BA.debugLineNum = 48955434;BA.debugLine="ls_temp_time2.Add(lbl_tim1.Text)";
_ls_temp_time2.Add((Object)(mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=48955435;
 //BA.debugLineNum = 48955435;BA.debugLine="ls_temp_time2.Add(lbl_tim2.Text)";
_ls_temp_time2.Add((Object)(mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=48955437;
 //BA.debugLineNum = 48955437;BA.debugLine="File.WriteList(File.DirInternal,\"temp_time2.";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time2.txt",_ls_temp_time2);
RDebugUtils.currentLine=48955439;
 //BA.debugLineNum = 48955439;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48955440;
 //BA.debugLineNum = 48955440;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=48955447;
 //BA.debugLineNum = 48955447;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_ez";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=48955452;
 //BA.debugLineNum = 48955452;BA.debugLine="Dim str_tozih0 As String=\"(فوق العاده)(تردد";
_str_tozih0 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=48955453;
 //BA.debugLineNum = 48955453;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_t";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=48955454;
 //BA.debugLineNum = 48955454;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=48955457;
 //BA.debugLineNum = 48955457;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=48955458;
 //BA.debugLineNum = 48955458;BA.debugLine="dbCode.add_ezafekari(date1,date2,\"0:0\",lbl_";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,"0:0",mostCurrent._lbl_tim2.getText(),_day_bt,(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (0))))),(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (1))))),_str_tozih0,(int) (2));
 }else {
RDebugUtils.currentLine=48955460;
 //BA.debugLineNum = 48955460;BA.debugLine="dbCode.add_ezafekari(date1,date2,\"0:0\",lbl_";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,"0:0",mostCurrent._lbl_tim2.getText(),_day_bt,(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (0))))),(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (1))))),_str_tozih1,(int) (0));
 };
RDebugUtils.currentLine=48955465;
 //BA.debugLineNum = 48955465;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_tozih2,(int) (0));
 }else {
RDebugUtils.currentLine=48955467;
 //BA.debugLineNum = 48955467;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
 };
RDebugUtils.currentLine=48955470;
 //BA.debugLineNum = 48955470;BA.debugLine="Dim ls_temp_time2 As List";
_ls_temp_time2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=48955471;
 //BA.debugLineNum = 48955471;BA.debugLine="ls_temp_time2.Initialize";
_ls_temp_time2.Initialize();
RDebugUtils.currentLine=48955473;
 //BA.debugLineNum = 48955473;BA.debugLine="ls_temp_time2.Add(lbl_tim1.Text)";
_ls_temp_time2.Add((Object)(mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=48955474;
 //BA.debugLineNum = 48955474;BA.debugLine="ls_temp_time2.Add(lbl_tim2.Text)";
_ls_temp_time2.Add((Object)(mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=48955476;
 //BA.debugLineNum = 48955476;BA.debugLine="File.WriteList(File.DirInternal,\"temp_time2.t";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time2.txt",_ls_temp_time2);
RDebugUtils.currentLine=48955478;
 //BA.debugLineNum = 48955478;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48955479;
 //BA.debugLineNum = 48955479;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=48955482;
 //BA.debugLineNum = 48955482;BA.debugLine="dbCode.edit_taradod(current_id_edit,date1,date";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
RDebugUtils.currentLine=48955484;
 //BA.debugLineNum = 48955484;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48955485;
 //BA.debugLineNum = 48955485;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=48955491;
 //BA.debugLineNum = 48955491;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e60) {
			processBA.setLastException(e60);RDebugUtils.currentLine=48955496;
 //BA.debugLineNum = 48955496;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=48955499;
 //BA.debugLineNum = 48955499;BA.debugLine="End Sub";
return "";
}
public static String  _add_taradod_fast() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_taradod_fast", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_taradod_fast", null));}
String _str_ft1 = "";
int _id_last_fast_taradod2 = 0;
String _date_fast1 = "";
int _tim_min2 = 0;
String _str_ft2 = "";
String _str_ft3 = "";
RDebugUtils.currentLine=53739520;
 //BA.debugLineNum = 53739520;BA.debugLine="Sub add_taradod_fast";
RDebugUtils.currentLine=53739522;
 //BA.debugLineNum = 53739522;BA.debugLine="Try";
try {RDebugUtils.currentLine=53739524;
 //BA.debugLineNum = 53739524;BA.debugLine="If(isExistFile_taradod_fast=False)Then";
if ((_isexistfile_taradod_fast()==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=53739526;
 //BA.debugLineNum = 53739526;BA.debugLine="Dim str_Ft1 As String=et_tozihat_FT.Text";
_str_ft1 = mostCurrent._et_tozihat_ft.getText();
RDebugUtils.currentLine=53739527;
 //BA.debugLineNum = 53739527;BA.debugLine="If (ckb_ezaf_taradod_FT.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod_ft.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=53739530;
 //BA.debugLineNum = 53739530;BA.debugLine="dbCode.add_taradod(lbl_date_FT.Text,lbl_date_F";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),(int) (0),(int) (0),(int) (0),_str_ft1,(int) (20));
 }else {
RDebugUtils.currentLine=53739534;
 //BA.debugLineNum = 53739534;BA.debugLine="dbCode.add_taradod(lbl_date_FT.Text,lbl_date_F";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),(int) (0),(int) (0),(int) (0),_str_ft1,(int) (10));
 };
RDebugUtils.currentLine=53739538;
 //BA.debugLineNum = 53739538;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=53739539;
 //BA.debugLineNum = 53739539;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_taradod WHERE id = (SELECT MAX(id) FROM tb_taradod)")));
RDebugUtils.currentLine=53739540;
 //BA.debugLineNum = 53739540;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=53739541;
 //BA.debugLineNum = 53739541;BA.debugLine="File.WriteString(File.DirInternal,\"taradod_fs_i";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"taradod_fs_id.txt",mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id"));
RDebugUtils.currentLine=53739543;
 //BA.debugLineNum = 53739543;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=53739546;
 //BA.debugLineNum = 53739546;BA.debugLine="ToastMessageShow(\"ورود ثبت شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ورود ثبت شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53739549;
 //BA.debugLineNum = 53739549;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=53739550;
 //BA.debugLineNum = 53739550;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53739552;
 //BA.debugLineNum = 53739552;BA.debugLine="pan_add_taradod_fast_Click";
_pan_add_taradod_fast_click();
 }else {
RDebugUtils.currentLine=53739556;
 //BA.debugLineNum = 53739556;BA.debugLine="Dim id_last_fast_taradod2 As Int";
_id_last_fast_taradod2 = 0;
RDebugUtils.currentLine=53739557;
 //BA.debugLineNum = 53739557;BA.debugLine="id_last_fast_taradod2=File.ReadString(File.DirI";
_id_last_fast_taradod2 = (int)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"taradod_fs_id.txt")));
RDebugUtils.currentLine=53739558;
 //BA.debugLineNum = 53739558;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=53739560;
 //BA.debugLineNum = 53739560;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE id="+BA.NumberToString(_id_last_fast_taradod2))));
RDebugUtils.currentLine=53739561;
 //BA.debugLineNum = 53739561;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=53739562;
 //BA.debugLineNum = 53739562;BA.debugLine="Dim date_fast1 As String=dbCode.res.GetString(\"";
_date_fast1 = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from");
RDebugUtils.currentLine=53739563;
 //BA.debugLineNum = 53739563;BA.debugLine="time_show2(	date_fast1,lbl_date_FT.Text,lbl_tim";
_time_show2(_date_fast1,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
RDebugUtils.currentLine=53739565;
 //BA.debugLineNum = 53739565;BA.debugLine="If (ckb_ezaf_taradod_FT.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod_ft.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=53739567;
 //BA.debugLineNum = 53739567;BA.debugLine="Dim tim_min2 As Int=(day_bt*24*60)+(hour_bt*60";
_tim_min2 = (int) ((_day_bt*24*60)+(_hour_bt*60)+_min_bt);
RDebugUtils.currentLine=53739570;
 //BA.debugLineNum = 53739570;BA.debugLine="If(tim_min2>saat_kar_min) Then";
if ((_tim_min2>_saat_kar_min)) { 
RDebugUtils.currentLine=53739593;
 //BA.debugLineNum = 53739593;BA.debugLine="dbCode.add_ezafekari(date_fast1,lbl_date_FT.T";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date_fast1,mostCurrent._lbl_date_ft.getText(),"0:0",mostCurrent._lbl_tim_khoroj_ft.getText(),_day_bt,(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min2-_saat_kar_min)).Get((int) (0))))),(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min2-_saat_kar_min)).Get((int) (1)))))," (ثبت سریع-تردد دارد)- ",(int) (0));
 };
RDebugUtils.currentLine=53739596;
 //BA.debugLineNum = 53739596;BA.debugLine="Dim str_Ft2 As String=\"(ثبت سریع-اضافه کاری)-\"";
_str_ft2 = "(ثبت سریع-اضافه کاری)-"+mostCurrent._et_tozihat_ft.getText();
RDebugUtils.currentLine=53739597;
 //BA.debugLineNum = 53739597;BA.debugLine="dbCode.edit_taradod(current_id_edit,date_fast1";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,_date_fast1,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),_day_bt,_hour_bt,_min_bt,_str_ft2,(int) (21));
 }else {
RDebugUtils.currentLine=53739599;
 //BA.debugLineNum = 53739599;BA.debugLine="Dim str_Ft3 As String=\"(ثبت سریع)-\"&et_tozihat";
_str_ft3 = "(ثبت سریع)-"+mostCurrent._et_tozihat_ft.getText();
RDebugUtils.currentLine=53739600;
 //BA.debugLineNum = 53739600;BA.debugLine="dbCode.edit_taradod(current_id_edit,date_fast1";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,_date_fast1,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),_day_bt,_hour_bt,_min_bt,_str_ft3,(int) (11));
 };
RDebugUtils.currentLine=53739604;
 //BA.debugLineNum = 53739604;BA.debugLine="ToastMessageShow(\"خروج ثبت شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خروج ثبت شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53739606;
 //BA.debugLineNum = 53739606;BA.debugLine="File.Delete(File.DirInternal,\"taradod_fs_id.txt";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"taradod_fs_id.txt");
RDebugUtils.currentLine=53739608;
 //BA.debugLineNum = 53739608;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 };
 } 
       catch (Exception e42) {
			processBA.setLastException(e42);RDebugUtils.currentLine=53739617;
 //BA.debugLineNum = 53739617;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=53739621;
 //BA.debugLineNum = 53739621;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_ft_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_ft_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_ft_click", null));}
RDebugUtils.currentLine=53411840;
 //BA.debugLineNum = 53411840;BA.debugLine="Private Sub pan_all_FT_Click";
RDebugUtils.currentLine=53411841;
 //BA.debugLineNum = 53411841;BA.debugLine="pan_all_FT.Visible=False";
mostCurrent._pan_all_ft.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53411842;
 //BA.debugLineNum = 53411842;BA.debugLine="End Sub";
return "";
}
public static String  _add_mamoriat_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_mamoriat_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_mamoriat_sub", null));}
int _state_mod = 0;
String _str_mod = "";
boolean _result_a = false;
RDebugUtils.currentLine=49020928;
 //BA.debugLineNum = 49020928;BA.debugLine="Sub add_mamoriat_sub";
RDebugUtils.currentLine=49020929;
 //BA.debugLineNum = 49020929;BA.debugLine="Dim state_mod As Int=0";
_state_mod = (int) (0);
RDebugUtils.currentLine=49020930;
 //BA.debugLineNum = 49020930;BA.debugLine="Dim str_mod As String=\"\"";
_str_mod = "";
RDebugUtils.currentLine=49020939;
 //BA.debugLineNum = 49020939;BA.debugLine="Try";
try {RDebugUtils.currentLine=49020940;
 //BA.debugLineNum = 49020940;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
if ((_day_bt<0 || _hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=49020941;
 //BA.debugLineNum = 49020941;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=49020942;
 //BA.debugLineNum = 49020942;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0)Then";
if ((_moon_bt!=0 || _year_bt!=0)) { 
RDebugUtils.currentLine=49020943;
 //BA.debugLineNum = 49020943;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=49020944;
 //BA.debugLineNum = 49020944;BA.debugLine="Else If (hour_bt=0 And min_bt=0 And day_bt=0 )Th";
if ((_hour_bt==0 && _min_bt==0 && _day_bt==0)) { 
RDebugUtils.currentLine=49020945;
 //BA.debugLineNum = 49020945;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=49020948;
 //BA.debugLineNum = 49020948;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=49020949;
 //BA.debugLineNum = 49020949;BA.debugLine="If(dbCode.isexist_mamoriat_by_date(date1)=True";
if ((mostCurrent._dbcode._isexist_mamoriat_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=49020951;
 //BA.debugLineNum = 49020951;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
RDebugUtils.currentLine=49020952;
 //BA.debugLineNum = 49020952;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ ماموریت وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
RDebugUtils.currentLine=49020953;
 //BA.debugLineNum = 49020953;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=49020954;
 //BA.debugLineNum = 49020954;BA.debugLine="dbCode.add_mamoriat(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_mamoriat /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=49020956;
 //BA.debugLineNum = 49020956;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=49020957;
 //BA.debugLineNum = 49020957;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=49020960;
 //BA.debugLineNum = 49020960;BA.debugLine="dbCode.add_mamoriat(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_mamoriat /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=49020962;
 //BA.debugLineNum = 49020962;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=49020963;
 //BA.debugLineNum = 49020963;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=49020967;
 //BA.debugLineNum = 49020967;BA.debugLine="dbCode.edit_mamoriat(current_id_edit,date1,dat";
mostCurrent._dbcode._edit_mamoriat /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=49020968;
 //BA.debugLineNum = 49020968;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=49020971;
 //BA.debugLineNum = 49020971;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=49020976;
 //BA.debugLineNum = 49020976;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e33) {
			processBA.setLastException(e33);RDebugUtils.currentLine=49020982;
 //BA.debugLineNum = 49020982;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=49020987;
 //BA.debugLineNum = 49020987;BA.debugLine="End Sub";
return "";
}
public static String  _fill_lists(String _year1,String _moon1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_lists", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_lists", new Object[] {_year1,_moon1}));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _str1 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _str2 = null;
anywheresoftware.b4a.objects.B4XViewWrapper _p2 = null;
RDebugUtils.currentLine=47710208;
 //BA.debugLineNum = 47710208;BA.debugLine="Sub fill_lists (year1 As String, moon1 As String)";
RDebugUtils.currentLine=47710209;
 //BA.debugLineNum = 47710209;BA.debugLine="Log(moon1)";
anywheresoftware.b4a.keywords.Common.LogImpl("247710209",_moon1,0);
RDebugUtils.currentLine=47710212;
 //BA.debugLineNum = 47710212;BA.debugLine="cust_LV_ezafekari.Clear";
mostCurrent._cust_lv_ezafekari._clear();
RDebugUtils.currentLine=47710213;
 //BA.debugLineNum = 47710213;BA.debugLine="list_ezafekari_id.Clear";
mostCurrent._list_ezafekari_id.Clear();
RDebugUtils.currentLine=47710215;
 //BA.debugLineNum = 47710215;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=47710216;
 //BA.debugLineNum = 47710216;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
RDebugUtils.currentLine=47710217;
 //BA.debugLineNum = 47710217;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=47710218;
 //BA.debugLineNum = 47710218;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=47710219;
 //BA.debugLineNum = 47710219;BA.debugLine="str1.Initialize";
_str1.Initialize();
RDebugUtils.currentLine=47710220;
 //BA.debugLineNum = 47710220;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")).equals(BA.NumberToString(0)) == false)) { 
RDebugUtils.currentLine=47710221;
 //BA.debugLineNum = 47710221;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")+" روز ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
RDebugUtils.currentLine=47710223;
 //BA.debugLineNum = 47710223;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")+" ساعت ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=47710224;
 //BA.debugLineNum = 47710224;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m")+" دقیقه ");
RDebugUtils.currentLine=47710228;
 //BA.debugLineNum = 47710228;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=47710229;
 //BA.debugLineNum = 47710229;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=47710230;
 //BA.debugLineNum = 47710230;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
RDebugUtils.currentLine=47710232;
 //BA.debugLineNum = 47710232;BA.debugLine="cust_LV_ezafekari.Add(p,dbCode.res.GetString(\"id";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47710234;
 //BA.debugLineNum = 47710234;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=47710236;
 //BA.debugLineNum = 47710236;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
RDebugUtils.currentLine=47710237;
 //BA.debugLineNum = 47710237;BA.debugLine="lbl_hour_CLV.Text=dbCode.res.GetString(\"time_fro";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=47710238;
 //BA.debugLineNum = 47710238;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str1.ToString()));
RDebugUtils.currentLine=47710239;
 //BA.debugLineNum = 47710239;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=47710240;
 //BA.debugLineNum = 47710240;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47710241;
 //BA.debugLineNum = 47710241;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47710243;
 //BA.debugLineNum = 47710243;BA.debugLine="list_ezafekari_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_ezafekari_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=47710248;
 //BA.debugLineNum = 47710248;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=47710249;
 //BA.debugLineNum = 47710249;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=47710251;
 //BA.debugLineNum = 47710251;BA.debugLine="If(cust_LV_ezafekari.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_ezafekari._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=47710252;
 //BA.debugLineNum = 47710252;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=47710253;
 //BA.debugLineNum = 47710253;BA.debugLine="Select cust_LV_ezafekari.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_ezafekari._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=47710255;
 //BA.debugLineNum = 47710255;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
RDebugUtils.currentLine=47710257;
 //BA.debugLineNum = 47710257;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=47710259;
 //BA.debugLineNum = 47710259;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=47710261;
 //BA.debugLineNum = 47710261;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=47710263;
 //BA.debugLineNum = 47710263;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=47710265;
 //BA.debugLineNum = 47710265;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=47710267;
 //BA.debugLineNum = 47710267;BA.debugLine="cust_LV_ezafekari.Add(p,\"\")";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=47710271;
 //BA.debugLineNum = 47710271;BA.debugLine="cust_LV_morakhasi.Clear";
mostCurrent._cust_lv_morakhasi._clear();
RDebugUtils.currentLine=47710272;
 //BA.debugLineNum = 47710272;BA.debugLine="list_morakhasi_id.Clear";
mostCurrent._list_morakhasi_id.Clear();
RDebugUtils.currentLine=47710274;
 //BA.debugLineNum = 47710274;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=47710275;
 //BA.debugLineNum = 47710275;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
RDebugUtils.currentLine=47710276;
 //BA.debugLineNum = 47710276;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=47710277;
 //BA.debugLineNum = 47710277;BA.debugLine="Dim str2 As StringBuilder";
_str2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=47710278;
 //BA.debugLineNum = 47710278;BA.debugLine="str2.Initialize";
_str2.Initialize();
RDebugUtils.currentLine=47710279;
 //BA.debugLineNum = 47710279;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")).equals(BA.NumberToString(0)) == false)) { 
RDebugUtils.currentLine=47710280;
 //BA.debugLineNum = 47710280;BA.debugLine="str2.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
_str2.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")+" روز ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
RDebugUtils.currentLine=47710282;
 //BA.debugLineNum = 47710282;BA.debugLine="str2.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
_str2.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")+" ساعت ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=47710283;
 //BA.debugLineNum = 47710283;BA.debugLine="str2.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
_str2.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m")+" دقیقه ");
RDebugUtils.currentLine=47710287;
 //BA.debugLineNum = 47710287;BA.debugLine="Dim p2 As B4XView = xui.CreatePanel(\"\")";
_p2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p2 = mostCurrent._xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=47710288;
 //BA.debugLineNum = 47710288;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=47710289;
 //BA.debugLineNum = 47710289;BA.debugLine="p2.LoadLayout(\"item_list\")";
_p2.LoadLayout("item_list",mostCurrent.activityBA);
RDebugUtils.currentLine=47710291;
 //BA.debugLineNum = 47710291;BA.debugLine="cust_LV_morakhasi.Add(p2,dbCode.res.GetString(\"i";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47710293;
 //BA.debugLineNum = 47710293;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=47710295;
 //BA.debugLineNum = 47710295;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
RDebugUtils.currentLine=47710296;
 //BA.debugLineNum = 47710296;BA.debugLine="lbl_hour_CLV.Text=dbCode.res.GetString(\"time_fro";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=47710297;
 //BA.debugLineNum = 47710297;BA.debugLine="lbl_time_CLV.Text=str2.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str2.ToString()));
RDebugUtils.currentLine=47710298;
 //BA.debugLineNum = 47710298;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=47710299;
 //BA.debugLineNum = 47710299;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47710300;
 //BA.debugLineNum = 47710300;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47710302;
 //BA.debugLineNum = 47710302;BA.debugLine="list_morakhasi_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_morakhasi_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=47710307;
 //BA.debugLineNum = 47710307;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=47710308;
 //BA.debugLineNum = 47710308;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=47710314;
 //BA.debugLineNum = 47710314;BA.debugLine="If(cust_LV_morakhasi.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_morakhasi._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=47710315;
 //BA.debugLineNum = 47710315;BA.debugLine="p2 = xui.CreatePanel(\"p\")";
_p2 = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=47710316;
 //BA.debugLineNum = 47710316;BA.debugLine="Select cust_LV_morakhasi.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_morakhasi._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=47710318;
 //BA.debugLineNum = 47710318;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
RDebugUtils.currentLine=47710320;
 //BA.debugLineNum = 47710320;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=47710322;
 //BA.debugLineNum = 47710322;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=47710324;
 //BA.debugLineNum = 47710324;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=47710326;
 //BA.debugLineNum = 47710326;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=47710328;
 //BA.debugLineNum = 47710328;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=47710330;
 //BA.debugLineNum = 47710330;BA.debugLine="cust_LV_morakhasi.Add(p2,\"\")";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(""));
 };
RDebugUtils.currentLine=47710335;
 //BA.debugLineNum = 47710335;BA.debugLine="cust_LV_taradod.Clear";
mostCurrent._cust_lv_taradod._clear();
RDebugUtils.currentLine=47710336;
 //BA.debugLineNum = 47710336;BA.debugLine="list_taradod_id.Clear";
mostCurrent._list_taradod_id.Clear();
RDebugUtils.currentLine=47710338;
 //BA.debugLineNum = 47710338;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=47710339;
 //BA.debugLineNum = 47710339;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
RDebugUtils.currentLine=47710340;
 //BA.debugLineNum = 47710340;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=47710341;
 //BA.debugLineNum = 47710341;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=47710342;
 //BA.debugLineNum = 47710342;BA.debugLine="str1.Initialize";
_str1.Initialize();
RDebugUtils.currentLine=47710343;
 //BA.debugLineNum = 47710343;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")).equals(BA.NumberToString(0)) == false)) { 
RDebugUtils.currentLine=47710344;
 //BA.debugLineNum = 47710344;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")+" روز ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
RDebugUtils.currentLine=47710346;
 //BA.debugLineNum = 47710346;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")+" ساعت ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=47710347;
 //BA.debugLineNum = 47710347;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m")+" دقیقه ");
RDebugUtils.currentLine=47710351;
 //BA.debugLineNum = 47710351;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=47710352;
 //BA.debugLineNum = 47710352;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=47710353;
 //BA.debugLineNum = 47710353;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
RDebugUtils.currentLine=47710355;
 //BA.debugLineNum = 47710355;BA.debugLine="cust_LV_taradod.Add(p,dbCode.res.GetString(\"id\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47710357;
 //BA.debugLineNum = 47710357;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=47710359;
 //BA.debugLineNum = 47710359;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
RDebugUtils.currentLine=47710360;
 //BA.debugLineNum = 47710360;BA.debugLine="lbl_hour_CLV.Text=\" ورود : \"&dbCode.res.GetStrin";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence(" ورود : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" -- "+" خروج : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=47710362;
 //BA.debugLineNum = 47710362;BA.debugLine="lbl_time_CLV.Typeface=Typeface.MATERIALICONS";
mostCurrent._lbl_time_clv.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
RDebugUtils.currentLine=47710363;
 //BA.debugLineNum = 47710363;BA.debugLine="lbl_time_CLV.Text=Chr(0xE8D5)";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe8d5))));
RDebugUtils.currentLine=47710364;
 //BA.debugLineNum = 47710364;BA.debugLine="lbl_time_CLV.TextSize=25";
mostCurrent._lbl_time_clv.setTextSize((float) (25));
RDebugUtils.currentLine=47710366;
 //BA.debugLineNum = 47710366;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=47710367;
 //BA.debugLineNum = 47710367;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47710368;
 //BA.debugLineNum = 47710368;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47710370;
 //BA.debugLineNum = 47710370;BA.debugLine="list_taradod_id.Add(dbCode.res.GetString(\"id\"))";
mostCurrent._list_taradod_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=47710375;
 //BA.debugLineNum = 47710375;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=47710376;
 //BA.debugLineNum = 47710376;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=47710378;
 //BA.debugLineNum = 47710378;BA.debugLine="If(cust_LV_taradod.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_taradod._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=47710379;
 //BA.debugLineNum = 47710379;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=47710380;
 //BA.debugLineNum = 47710380;BA.debugLine="Select cust_LV_taradod.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_taradod._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=47710382;
 //BA.debugLineNum = 47710382;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
RDebugUtils.currentLine=47710384;
 //BA.debugLineNum = 47710384;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=47710386;
 //BA.debugLineNum = 47710386;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=47710388;
 //BA.debugLineNum = 47710388;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=47710390;
 //BA.debugLineNum = 47710390;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=47710392;
 //BA.debugLineNum = 47710392;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=47710394;
 //BA.debugLineNum = 47710394;BA.debugLine="cust_LV_taradod.Add(p,\"\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=47710400;
 //BA.debugLineNum = 47710400;BA.debugLine="cust_LV_mamoriat.Clear";
mostCurrent._cust_lv_mamoriat._clear();
RDebugUtils.currentLine=47710401;
 //BA.debugLineNum = 47710401;BA.debugLine="list_mamoriat_id.Clear";
mostCurrent._list_mamoriat_id.Clear();
RDebugUtils.currentLine=47710403;
 //BA.debugLineNum = 47710403;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=47710404;
 //BA.debugLineNum = 47710404;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
RDebugUtils.currentLine=47710405;
 //BA.debugLineNum = 47710405;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=47710406;
 //BA.debugLineNum = 47710406;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=47710407;
 //BA.debugLineNum = 47710407;BA.debugLine="str1.Initialize";
_str1.Initialize();
RDebugUtils.currentLine=47710408;
 //BA.debugLineNum = 47710408;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")).equals(BA.NumberToString(0)) == false)) { 
RDebugUtils.currentLine=47710409;
 //BA.debugLineNum = 47710409;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")+" روز ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
RDebugUtils.currentLine=47710411;
 //BA.debugLineNum = 47710411;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")+" ساعت ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=47710412;
 //BA.debugLineNum = 47710412;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m")+" دقیقه ");
RDebugUtils.currentLine=47710416;
 //BA.debugLineNum = 47710416;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=47710417;
 //BA.debugLineNum = 47710417;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=47710418;
 //BA.debugLineNum = 47710418;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
RDebugUtils.currentLine=47710420;
 //BA.debugLineNum = 47710420;BA.debugLine="cust_LV_mamoriat.Add(p,dbCode.res.GetString(\"id\"";
mostCurrent._cust_lv_mamoriat._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47710422;
 //BA.debugLineNum = 47710422;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=47710424;
 //BA.debugLineNum = 47710424;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
RDebugUtils.currentLine=47710425;
 //BA.debugLineNum = 47710425;BA.debugLine="lbl_hour_CLV.Text=dbCode.res.GetString(\"time_fro";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=47710426;
 //BA.debugLineNum = 47710426;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str1.ToString()));
RDebugUtils.currentLine=47710427;
 //BA.debugLineNum = 47710427;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=47710428;
 //BA.debugLineNum = 47710428;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47710429;
 //BA.debugLineNum = 47710429;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47710431;
 //BA.debugLineNum = 47710431;BA.debugLine="list_mamoriat_id.Add(dbCode.res.GetString(\"id\"))";
mostCurrent._list_mamoriat_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=47710436;
 //BA.debugLineNum = 47710436;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=47710437;
 //BA.debugLineNum = 47710437;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=47710439;
 //BA.debugLineNum = 47710439;BA.debugLine="If(cust_LV_mamoriat.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_mamoriat._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=47710440;
 //BA.debugLineNum = 47710440;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=47710441;
 //BA.debugLineNum = 47710441;BA.debugLine="Select cust_LV_mamoriat.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_mamoriat._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=47710443;
 //BA.debugLineNum = 47710443;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
RDebugUtils.currentLine=47710445;
 //BA.debugLineNum = 47710445;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=47710447;
 //BA.debugLineNum = 47710447;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=47710449;
 //BA.debugLineNum = 47710449;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=47710451;
 //BA.debugLineNum = 47710451;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=47710453;
 //BA.debugLineNum = 47710453;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=47710455;
 //BA.debugLineNum = 47710455;BA.debugLine="cust_LV_mamoriat.Add(p,\"\")";
mostCurrent._cust_lv_mamoriat._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=47710459;
 //BA.debugLineNum = 47710459;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
RDebugUtils.currentLine=47710461;
 //BA.debugLineNum = 47710461;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=48562176;
 //BA.debugLineNum = 48562176;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=48562177;
 //BA.debugLineNum = 48562177;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48562178;
 //BA.debugLineNum = 48562178;BA.debugLine="End Sub";
return "";
}
public static boolean  _isexistfile_taradod_fast() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "isexistfile_taradod_fast", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "isexistfile_taradod_fast", null));}
RDebugUtils.currentLine=53149696;
 //BA.debugLineNum = 53149696;BA.debugLine="Sub isExistFile_taradod_fast As Boolean";
RDebugUtils.currentLine=53149697;
 //BA.debugLineNum = 53149697;BA.debugLine="Return File.Exists(File.DirInternal,\"taradod_fs_i";
if (true) return anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"taradod_fs_id.txt");
RDebugUtils.currentLine=53149698;
 //BA.debugLineNum = 53149698;BA.debugLine="End Sub";
return false;
}
public static String  _pan_add_taradod_fast_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_taradod_fast_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_taradod_fast_click", null));}
int _id_last_fast_taradod = 0;
RDebugUtils.currentLine=53215232;
 //BA.debugLineNum = 53215232;BA.debugLine="Private Sub pan_add_taradod_fast_Click";
RDebugUtils.currentLine=53215233;
 //BA.debugLineNum = 53215233;BA.debugLine="pan_all_FT.Visible=True";
mostCurrent._pan_all_ft.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=53215234;
 //BA.debugLineNum = 53215234;BA.debugLine="lbl_date_FT.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date_ft.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=53215235;
 //BA.debugLineNum = 53215235;BA.debugLine="DateTime.TimeFormat = \"HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm");
RDebugUtils.currentLine=53215239;
 //BA.debugLineNum = 53215239;BA.debugLine="Try";
try {RDebugUtils.currentLine=53215242;
 //BA.debugLineNum = 53215242;BA.debugLine="If(isExistFile_taradod_fast=True)Then";
if ((_isexistfile_taradod_fast()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=53215243;
 //BA.debugLineNum = 53215243;BA.debugLine="Dim id_last_fast_taradod As Int";
_id_last_fast_taradod = 0;
RDebugUtils.currentLine=53215244;
 //BA.debugLineNum = 53215244;BA.debugLine="id_last_fast_taradod=File.ReadString(File.DirIn";
_id_last_fast_taradod = (int)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"taradod_fs_id.txt")));
RDebugUtils.currentLine=53215245;
 //BA.debugLineNum = 53215245;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=53215246;
 //BA.debugLineNum = 53215246;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE id="+BA.NumberToString(_id_last_fast_taradod))));
RDebugUtils.currentLine=53215247;
 //BA.debugLineNum = 53215247;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=53215249;
 //BA.debugLineNum = 53215249;BA.debugLine="lbl_tim_vorod_FT.Text=dbCode.res.GetString(\"tim";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")));
RDebugUtils.currentLine=53215250;
 //BA.debugLineNum = 53215250;BA.debugLine="lbl_tim_khoroj_FT.Text=dbCode.res.GetString(\"ti";
mostCurrent._lbl_tim_khoroj_ft.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=53215252;
 //BA.debugLineNum = 53215252;BA.debugLine="et_tozihat_FT.Text=dbCode.res.GetString(\"toziha";
mostCurrent._et_tozihat_ft.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=53215254;
 //BA.debugLineNum = 53215254;BA.debugLine="current_id_edit=dbCode.res.GetInt(\"id\")";
_current_id_edit = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("id");
RDebugUtils.currentLine=53215255;
 //BA.debugLineNum = 53215255;BA.debugLine="Log(dbCode.res.GetInt(\"state\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("253215255",BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")),0);
RDebugUtils.currentLine=53215257;
 //BA.debugLineNum = 53215257;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=53215258;
 //BA.debugLineNum = 53215258;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=53215261;
 //BA.debugLineNum = 53215261;BA.debugLine="If(dbCode.res.GetInt(\"state\")=10)Then  ''vorod";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==10)) { 
RDebugUtils.currentLine=53215262;
 //BA.debugLineNum = 53215262;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=53215263;
 //BA.debugLineNum = 53215263;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=53215264;
 //BA.debugLineNum = 53215264;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53215265;
 //BA.debugLineNum = 53215265;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53215267;
 //BA.debugLineNum = 53215267;BA.debugLine="code_fast_taradod=10";
_code_fast_taradod = (int) (10);
 }else 
{RDebugUtils.currentLine=53215268;
 //BA.debugLineNum = 53215268;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=20)Then  ''";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==20)) { 
RDebugUtils.currentLine=53215269;
 //BA.debugLineNum = 53215269;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=53215270;
 //BA.debugLineNum = 53215270;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=53215271;
 //BA.debugLineNum = 53215271;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=53215272;
 //BA.debugLineNum = 53215272;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53215274;
 //BA.debugLineNum = 53215274;BA.debugLine="code_fast_taradod=20";
_code_fast_taradod = (int) (20);
 }else 
{RDebugUtils.currentLine=53215275;
 //BA.debugLineNum = 53215275;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=11)Then  ''";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==11)) { 
RDebugUtils.currentLine=53215276;
 //BA.debugLineNum = 53215276;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=53215277;
 //BA.debugLineNum = 53215277;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=53215278;
 //BA.debugLineNum = 53215278;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53215279;
 //BA.debugLineNum = 53215279;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53215281;
 //BA.debugLineNum = 53215281;BA.debugLine="et_tozihat_FT.Enabled=False";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53215283;
 //BA.debugLineNum = 53215283;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,l";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
RDebugUtils.currentLine=53215284;
 //BA.debugLineNum = 53215284;BA.debugLine="code_fast_taradod=11";
_code_fast_taradod = (int) (11);
RDebugUtils.currentLine=53215285;
 //BA.debugLineNum = 53215285;BA.debugLine="ToastMessageShow(\"تردد امروز ثبت شده است\",Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تردد امروز ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=53215288;
 //BA.debugLineNum = 53215288;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=21)Then  ''";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==21)) { 
RDebugUtils.currentLine=53215289;
 //BA.debugLineNum = 53215289;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=53215290;
 //BA.debugLineNum = 53215290;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=53215291;
 //BA.debugLineNum = 53215291;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=53215292;
 //BA.debugLineNum = 53215292;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53215294;
 //BA.debugLineNum = 53215294;BA.debugLine="et_tozihat_FT.Enabled=False";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53215296;
 //BA.debugLineNum = 53215296;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,l";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
RDebugUtils.currentLine=53215298;
 //BA.debugLineNum = 53215298;BA.debugLine="code_fast_taradod=21";
_code_fast_taradod = (int) (21);
RDebugUtils.currentLine=53215299;
 //BA.debugLineNum = 53215299;BA.debugLine="ToastMessageShow(\"تردد امروز ثبت شده است\",Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تردد امروز ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=53215302;
 //BA.debugLineNum = 53215302;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=0)Then  ''d";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==0)) { 
RDebugUtils.currentLine=53215303;
 //BA.debugLineNum = 53215303;BA.debugLine="File.Delete(File.DirInternal,\"taradod_fs_id.tx";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"taradod_fs_id.txt");
RDebugUtils.currentLine=53215304;
 //BA.debugLineNum = 53215304;BA.debugLine="pan_add_taradod_fast_Click";
_pan_add_taradod_fast_click();
 }}}}}
;
 }else {
RDebugUtils.currentLine=53215319;
 //BA.debugLineNum = 53215319;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=53215320;
 //BA.debugLineNum = 53215320;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=53215322;
 //BA.debugLineNum = 53215322;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=53215323;
 //BA.debugLineNum = 53215323;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=True";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=53215324;
 //BA.debugLineNum = 53215324;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
RDebugUtils.currentLine=53215325;
 //BA.debugLineNum = 53215325;BA.debugLine="et_tozihat_FT.Enabled=True";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=53215327;
 //BA.debugLineNum = 53215327;BA.debugLine="lbl_tim_vorod_FT.Text=\"00:00\"";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=53215328;
 //BA.debugLineNum = 53215328;BA.debugLine="lbl_tim_khoroj_FT.Text=\"00:00\"";
mostCurrent._lbl_tim_khoroj_ft.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=53215329;
 //BA.debugLineNum = 53215329;BA.debugLine="lbl_time_show_FT.Text=\"\"";
mostCurrent._lbl_time_show_ft.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=53215330;
 //BA.debugLineNum = 53215330;BA.debugLine="et_tozihat_FT.Text=\"\"";
mostCurrent._et_tozihat_ft.setText(BA.ObjectToCharSequence(""));
 };
 } 
       catch (Exception e65) {
			processBA.setLastException(e65);RDebugUtils.currentLine=53215336;
 //BA.debugLineNum = 53215336;BA.debugLine="File.Delete(File.DirInternal,\"taradod_fs_id.txt\"";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"taradod_fs_id.txt");
RDebugUtils.currentLine=53215337;
 //BA.debugLineNum = 53215337;BA.debugLine="pan_all_FT_Click";
_pan_all_ft_click();
RDebugUtils.currentLine=53215338;
 //BA.debugLineNum = 53215338;BA.debugLine="pan_add_taradod_fast_Click";
_pan_add_taradod_fast_click();
RDebugUtils.currentLine=53215339;
 //BA.debugLineNum = 53215339;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("253215339",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=53215343;
 //BA.debugLineNum = 53215343;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=49217536;
 //BA.debugLineNum = 49217536;BA.debugLine="Sub time_show2 (dat1 As String,dat2 As String, tim";
RDebugUtils.currentLine=49217538;
 //BA.debugLineNum = 49217538;BA.debugLine="Try";
try {RDebugUtils.currentLine=49217539;
 //BA.debugLineNum = 49217539;BA.debugLine="Log(dat1)";
anywheresoftware.b4a.keywords.Common.LogImpl("249217539",_dat1,0);
RDebugUtils.currentLine=49217540;
 //BA.debugLineNum = 49217540;BA.debugLine="Log(dat2)";
anywheresoftware.b4a.keywords.Common.LogImpl("249217540",_dat2,0);
RDebugUtils.currentLine=49217542;
 //BA.debugLineNum = 49217542;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=49217543;
 //BA.debugLineNum = 49217543;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=49217544;
 //BA.debugLineNum = 49217544;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
RDebugUtils.currentLine=49217545;
 //BA.debugLineNum = 49217545;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
RDebugUtils.currentLine=49217547;
 //BA.debugLineNum = 49217547;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=49217548;
 //BA.debugLineNum = 49217548;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=49217549;
 //BA.debugLineNum = 49217549;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=49217550;
 //BA.debugLineNum = 49217550;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=49217559;
 //BA.debugLineNum = 49217559;BA.debugLine="date1=dat1";
mostCurrent._date1 = _dat1;
RDebugUtils.currentLine=49217560;
 //BA.debugLineNum = 49217560;BA.debugLine="date2=dat2";
mostCurrent._date2 = _dat2;
RDebugUtils.currentLine=49217561;
 //BA.debugLineNum = 49217561;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
RDebugUtils.currentLine=49217562;
 //BA.debugLineNum = 49217562;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
RDebugUtils.currentLine=49217566;
 //BA.debugLineNum = 49217566;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_dat";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=49217567;
 //BA.debugLineNum = 49217567;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_dat";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=49217570;
 //BA.debugLineNum = 49217570;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=49217571;
 //BA.debugLineNum = 49217571;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=49217574;
 //BA.debugLineNum = 49217574;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
RDebugUtils.currentLine=49217575;
 //BA.debugLineNum = 49217575;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
RDebugUtils.currentLine=49217577;
 //BA.debugLineNum = 49217577;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date_";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=49217578;
 //BA.debugLineNum = 49217578;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date_";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=49217580;
 //BA.debugLineNum = 49217580;BA.debugLine="time_end2=tim2&\":00\"";
_time_end2 = _tim2+":00";
RDebugUtils.currentLine=49217581;
 //BA.debugLineNum = 49217581;BA.debugLine="time_end1=tim1&\":00\"";
_time_end1 = _tim1+":00";
RDebugUtils.currentLine=49217583;
 //BA.debugLineNum = 49217583;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
RDebugUtils.currentLine=49217584;
 //BA.debugLineNum = 49217584;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
RDebugUtils.currentLine=49217585;
 //BA.debugLineNum = 49217585;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
RDebugUtils.currentLine=49217586;
 //BA.debugLineNum = 49217586;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
RDebugUtils.currentLine=49217590;
 //BA.debugLineNum = 49217590;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
RDebugUtils.currentLine=49217591;
 //BA.debugLineNum = 49217591;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
RDebugUtils.currentLine=49217594;
 //BA.debugLineNum = 49217594;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=49217595;
 //BA.debugLineNum = 49217595;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
RDebugUtils.currentLine=49217597;
 //BA.debugLineNum = 49217597;BA.debugLine="If (period_between.Years<>0)Then";
if ((_period_between.Years!=0)) { 
RDebugUtils.currentLine=49217598;
 //BA.debugLineNum = 49217598;BA.debugLine="str_show.Append(period_between.Years&\" سال \").A";
_str_show.Append(BA.NumberToString(_period_between.Years)+" سال ").Append(" و ");
 };
RDebugUtils.currentLine=49217600;
 //BA.debugLineNum = 49217600;BA.debugLine="If (period_between.Months<>0)Then";
if ((_period_between.Months!=0)) { 
RDebugUtils.currentLine=49217601;
 //BA.debugLineNum = 49217601;BA.debugLine="str_show.Append(period_between.Months&\" ماه \").";
_str_show.Append(BA.NumberToString(_period_between.Months)+" ماه ").Append(" و ");
 };
RDebugUtils.currentLine=49217603;
 //BA.debugLineNum = 49217603;BA.debugLine="If (period_between.Days<>0)Then";
if ((_period_between.Days!=0)) { 
RDebugUtils.currentLine=49217604;
 //BA.debugLineNum = 49217604;BA.debugLine="str_show.Append(period_between.Days&\" روز \").Ap";
_str_show.Append(BA.NumberToString(_period_between.Days)+" روز ").Append(" و ");
 };
RDebugUtils.currentLine=49217607;
 //BA.debugLineNum = 49217607;BA.debugLine="str_show.Append(period_between.Hours&\" ساعت \").A";
_str_show.Append(BA.NumberToString(_period_between.Hours)+" ساعت ").Append(" و ");
RDebugUtils.currentLine=49217608;
 //BA.debugLineNum = 49217608;BA.debugLine="str_show.Append(period_between.Minutes&\" دقیقه \"";
_str_show.Append(BA.NumberToString(_period_between.Minutes)+" دقیقه ");
RDebugUtils.currentLine=49217611;
 //BA.debugLineNum = 49217611;BA.debugLine="year_bt=period_between.Years";
_year_bt = _period_between.Years;
RDebugUtils.currentLine=49217612;
 //BA.debugLineNum = 49217612;BA.debugLine="moon_bt=period_between.Months";
_moon_bt = _period_between.Months;
RDebugUtils.currentLine=49217613;
 //BA.debugLineNum = 49217613;BA.debugLine="day_bt=period_between.Days";
_day_bt = _period_between.Days;
RDebugUtils.currentLine=49217614;
 //BA.debugLineNum = 49217614;BA.debugLine="hour_bt=period_between.Hours";
_hour_bt = _period_between.Hours;
RDebugUtils.currentLine=49217615;
 //BA.debugLineNum = 49217615;BA.debugLine="min_bt=period_between.Minutes";
_min_bt = _period_between.Minutes;
RDebugUtils.currentLine=49217618;
 //BA.debugLineNum = 49217618;BA.debugLine="lbl_time_show_FT.Text=str_show";
mostCurrent._lbl_time_show_ft.setText(BA.ObjectToCharSequence(_str_show.getObject()));
 } 
       catch (Exception e52) {
			processBA.setLastException(e52);RDebugUtils.currentLine=49217621;
 //BA.debugLineNum = 49217621;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=49217623;
 //BA.debugLineNum = 49217623;BA.debugLine="End Sub";
return "";
}
public static String  _auth_complete(boolean _success,String _errormessage) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "auth_complete", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "auth_complete", new Object[] {_success,_errormessage}));}
RDebugUtils.currentLine=46596096;
 //BA.debugLineNum = 46596096;BA.debugLine="Sub Auth_Complete (Success As Boolean, ErrorMessag";
RDebugUtils.currentLine=46596097;
 //BA.debugLineNum = 46596097;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=46596098;
 //BA.debugLineNum = 46596098;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46596099;
 //BA.debugLineNum = 46596099;BA.debugLine="tim_lock_lbl.Enabled=False";
_tim_lock_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=46596101;
 //BA.debugLineNum = 46596101;BA.debugLine="ToastMessageShow($\"Error: ${ErrorMessage}\"$, Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(("Error: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_errormessage))+"")),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=46596102;
 //BA.debugLineNum = 46596102;BA.debugLine="Log(ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("246596102",_errormessage,0);
 };
RDebugUtils.currentLine=46596104;
 //BA.debugLineNum = 46596104;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_gozaresh_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_menu_gozaresh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_menu_gozaresh_click", null));}
RDebugUtils.currentLine=47775744;
 //BA.debugLineNum = 47775744;BA.debugLine="Private Sub btn_menu_gozaresh_Click";
RDebugUtils.currentLine=47775745;
 //BA.debugLineNum = 47775745;BA.debugLine="index_page=3";
_index_page = (int) (3);
RDebugUtils.currentLine=47775746;
 //BA.debugLineNum = 47775746;BA.debugLine="pan_imag.Background=img3";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img3.getObject()));
RDebugUtils.currentLine=47775748;
 //BA.debugLineNum = 47775748;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
RDebugUtils.currentLine=47775749;
 //BA.debugLineNum = 47775749;BA.debugLine="pan_main.LoadLayout(\"gozaresh_layout\")";
mostCurrent._pan_main.LoadLayout("gozaresh_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=47775751;
 //BA.debugLineNum = 47775751;BA.debugLine="sp_year_gozaresh.Add(\"1402\")";
mostCurrent._sp_year_gozaresh.Add("1402");
RDebugUtils.currentLine=47775752;
 //BA.debugLineNum = 47775752;BA.debugLine="sp_year_gozaresh.Add(\"1401\")";
mostCurrent._sp_year_gozaresh.Add("1401");
RDebugUtils.currentLine=47775753;
 //BA.debugLineNum = 47775753;BA.debugLine="sp_year_gozaresh.Add(\"1400\")";
mostCurrent._sp_year_gozaresh.Add("1400");
RDebugUtils.currentLine=47775754;
 //BA.debugLineNum = 47775754;BA.debugLine="sp_year_gozaresh.Add(\"1399\")";
mostCurrent._sp_year_gozaresh.Add("1399");
RDebugUtils.currentLine=47775755;
 //BA.debugLineNum = 47775755;BA.debugLine="sp_year_gozaresh.Add(\"1398\")";
mostCurrent._sp_year_gozaresh.Add("1398");
RDebugUtils.currentLine=47775757;
 //BA.debugLineNum = 47775757;BA.debugLine="sp_year_gozaresh.SelectedIndex=0";
mostCurrent._sp_year_gozaresh.setSelectedIndex((int) (0));
RDebugUtils.currentLine=47775762;
 //BA.debugLineNum = 47775762;BA.debugLine="pan_hed_gozaresh.Color=color4";
mostCurrent._pan_hed_gozaresh.setColor(_color4);
RDebugUtils.currentLine=47775767;
 //BA.debugLineNum = 47775767;BA.debugLine="list_gozareshat_id.Initialize";
mostCurrent._list_gozareshat_id.Initialize();
RDebugUtils.currentLine=47775770;
 //BA.debugLineNum = 47775770;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
RDebugUtils.currentLine=47775772;
 //BA.debugLineNum = 47775772;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_gozareshat(String _year1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_list_gozareshat", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_list_gozareshat", new Object[] {_year1}));}
RDebugUtils.currentLine=47841280;
 //BA.debugLineNum = 47841280;BA.debugLine="Sub fill_list_gozareshat(year1 As String)";
RDebugUtils.currentLine=47841281;
 //BA.debugLineNum = 47841281;BA.debugLine="CLV_gozaresh.Clear";
mostCurrent._clv_gozaresh._clear();
RDebugUtils.currentLine=47841282;
 //BA.debugLineNum = 47841282;BA.debugLine="list_gozareshat_id.Clear";
mostCurrent._list_gozareshat_id.Clear();
RDebugUtils.currentLine=47841284;
 //BA.debugLineNum = 47841284;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=47841285;
 //BA.debugLineNum = 47841285;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ORDER BY  id DESC;")));
RDebugUtils.currentLine=47841286;
 //BA.debugLineNum = 47841286;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=47841289;
 //BA.debugLineNum = 47841289;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=47841290;
 //BA.debugLineNum = 47841290;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 96%x, 114dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (114)));
RDebugUtils.currentLine=47841291;
 //BA.debugLineNum = 47841291;BA.debugLine="p.LoadLayout(\"item_list_2\")";
mostCurrent._p.LoadLayout("item_list_2",mostCurrent.activityBA);
RDebugUtils.currentLine=47841293;
 //BA.debugLineNum = 47841293;BA.debugLine="CLV_gozaresh.Add(p,dbCode.res.GetString(\"id\"))";
mostCurrent._clv_gozaresh._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47841294;
 //BA.debugLineNum = 47841294;BA.debugLine="lbl_dateGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_dategozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date")));
RDebugUtils.currentLine=47841295;
 //BA.debugLineNum = 47841295;BA.debugLine="lbl_nameGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_namegozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title")));
RDebugUtils.currentLine=47841296;
 //BA.debugLineNum = 47841296;BA.debugLine="lbl_tozihGozaresh_CLV.Text=dbCode.res.GetString(";
mostCurrent._lbl_tozihgozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozih")));
RDebugUtils.currentLine=47841297;
 //BA.debugLineNum = 47841297;BA.debugLine="lbl_remove_from_list2.Tag=dbCode.res.GetString(\"";
mostCurrent._lbl_remove_from_list2.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47841298;
 //BA.debugLineNum = 47841298;BA.debugLine="pan_item_gozaresh.Tag=dbCode.res.GetString(\"id\")";
mostCurrent._pan_item_gozaresh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47841299;
 //BA.debugLineNum = 47841299;BA.debugLine="list_gozareshat_id.Add(dbCode.res.GetString(\"id\"";
mostCurrent._list_gozareshat_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=47841300;
 //BA.debugLineNum = 47841300;BA.debugLine="Log(dbCode.res.GetString(\"id\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("247841300",mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id"),0);
 }
;
RDebugUtils.currentLine=47841302;
 //BA.debugLineNum = 47841302;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=47841303;
 //BA.debugLineNum = 47841303;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=47841305;
 //BA.debugLineNum = 47841305;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_click", null));}
RDebugUtils.currentLine=51380224;
 //BA.debugLineNum = 51380224;BA.debugLine="Private Sub lbl_help_Click";
RDebugUtils.currentLine=51380227;
 //BA.debugLineNum = 51380227;BA.debugLine="bit_img0.Initialize(File.DirAssets,\"home-h0.jpg\")";
mostCurrent._bit_img0.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h0.jpg");
RDebugUtils.currentLine=51380228;
 //BA.debugLineNum = 51380228;BA.debugLine="bit_img1.Initialize(File.DirAssets,\"home-h1.jpg\")";
mostCurrent._bit_img1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h1.jpg");
RDebugUtils.currentLine=51380229;
 //BA.debugLineNum = 51380229;BA.debugLine="bit_img2.Initialize(File.DirAssets,\"home-h2.jpg\")";
mostCurrent._bit_img2.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h2.jpg");
RDebugUtils.currentLine=51380230;
 //BA.debugLineNum = 51380230;BA.debugLine="bit_img3.Initialize(File.DirAssets,\"home-h3.jpg\")";
mostCurrent._bit_img3.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h3.jpg");
RDebugUtils.currentLine=51380231;
 //BA.debugLineNum = 51380231;BA.debugLine="bit_img4.Initialize(File.DirAssets,\"home-h4.jpg\")";
mostCurrent._bit_img4.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h4.jpg");
RDebugUtils.currentLine=51380234;
 //BA.debugLineNum = 51380234;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
RDebugUtils.currentLine=51380235;
 //BA.debugLineNum = 51380235;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
RDebugUtils.currentLine=51380236;
 //BA.debugLineNum = 51380236;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=51380238;
 //BA.debugLineNum = 51380238;BA.debugLine="End Sub";
return "";
}
public static String  _get_today_shift() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_today_shift", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_today_shift", null));}
int _id_today = 0;
String _str_sh = "";
RDebugUtils.currentLine=47513600;
 //BA.debugLineNum = 47513600;BA.debugLine="Sub get_today_shift";
RDebugUtils.currentLine=47513601;
 //BA.debugLineNum = 47513601;BA.debugLine="Dim id_today As Int";
_id_today = 0;
RDebugUtils.currentLine=47513602;
 //BA.debugLineNum = 47513602;BA.debugLine="id_today=dbCode.get_day_id(persianDate.PersianYea";
_id_today = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_persiandate.getPersianYear(),_persiandate.getPersianMonth(),_persiandate.getPersianDay());
RDebugUtils.currentLine=47513604;
 //BA.debugLineNum = 47513604;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=47513605;
 //BA.debugLineNum = 47513605;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id_today))));
RDebugUtils.currentLine=47513607;
 //BA.debugLineNum = 47513607;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=47513611;
 //BA.debugLineNum = 47513611;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")).equals("") == false)) { 
RDebugUtils.currentLine=47513612;
 //BA.debugLineNum = 47513612;BA.debugLine="Dim str_sh As String";
_str_sh = "";
RDebugUtils.currentLine=47513613;
 //BA.debugLineNum = 47513613;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift"),"ر","ش","ع","ا")) {
case 0: {
RDebugUtils.currentLine=47513615;
 //BA.debugLineNum = 47513615;BA.debugLine="str_sh=\"روزکار\"";
_str_sh = "روزکار";
 break; }
case 1: {
RDebugUtils.currentLine=47513617;
 //BA.debugLineNum = 47513617;BA.debugLine="str_sh=\"شبکار\"";
_str_sh = "شبکار";
 break; }
case 2: {
RDebugUtils.currentLine=47513619;
 //BA.debugLineNum = 47513619;BA.debugLine="str_sh=\"عصرکار\"";
_str_sh = "عصرکار";
 break; }
case 3: {
RDebugUtils.currentLine=47513621;
 //BA.debugLineNum = 47513621;BA.debugLine="str_sh=\"استراحت\"";
_str_sh = "استراحت";
 break; }
}
;
RDebugUtils.currentLine=47513623;
 //BA.debugLineNum = 47513623;BA.debugLine="lbl_shift_home.Text=\"(\"&str_sh&\")\"";
mostCurrent._lbl_shift_home.setText(BA.ObjectToCharSequence("("+_str_sh+")"));
 };
RDebugUtils.currentLine=47513628;
 //BA.debugLineNum = 47513628;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_account_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_account_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_account_click", null));}
RDebugUtils.currentLine=54329344;
 //BA.debugLineNum = 54329344;BA.debugLine="Private Sub lbl_account_Click";
RDebugUtils.currentLine=54329353;
 //BA.debugLineNum = 54329353;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=54329354;
 //BA.debugLineNum = 54329354;BA.debugLine="StartActivity(step2_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step2_activity.getObject()));
 }else {
RDebugUtils.currentLine=54329356;
 //BA.debugLineNum = 54329356;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 };
RDebugUtils.currentLine=54329362;
 //BA.debugLineNum = 54329362;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
RDebugUtils.currentLine=54329363;
 //BA.debugLineNum = 54329363;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_list_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_menu_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_menu_list_click", null));}
RDebugUtils.currentLine=47579136;
 //BA.debugLineNum = 47579136;BA.debugLine="Private Sub btn_menu_list_Click";
RDebugUtils.currentLine=47579137;
 //BA.debugLineNum = 47579137;BA.debugLine="index_page=2";
_index_page = (int) (2);
RDebugUtils.currentLine=47579138;
 //BA.debugLineNum = 47579138;BA.debugLine="pan_imag.Background=img2";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img2.getObject()));
RDebugUtils.currentLine=47579140;
 //BA.debugLineNum = 47579140;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
RDebugUtils.currentLine=47579141;
 //BA.debugLineNum = 47579141;BA.debugLine="pan_main.LoadLayout(\"list_layout\")";
mostCurrent._pan_main.LoadLayout("list_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=47579143;
 //BA.debugLineNum = 47579143;BA.debugLine="sp_year.Add(\"1402\")";
mostCurrent._sp_year.Add("1402");
RDebugUtils.currentLine=47579144;
 //BA.debugLineNum = 47579144;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
RDebugUtils.currentLine=47579145;
 //BA.debugLineNum = 47579145;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
RDebugUtils.currentLine=47579146;
 //BA.debugLineNum = 47579146;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
RDebugUtils.currentLine=47579147;
 //BA.debugLineNum = 47579147;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
RDebugUtils.currentLine=47579149;
 //BA.debugLineNum = 47579149;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=47579152;
 //BA.debugLineNum = 47579152;BA.debugLine="sp_year.SelectedIndex=0";
mostCurrent._sp_year.setSelectedIndex((int) (0));
RDebugUtils.currentLine=47579153;
 //BA.debugLineNum = 47579153;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(persianDate.Pe";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))))-1));
RDebugUtils.currentLine=47579155;
 //BA.debugLineNum = 47579155;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(sp_moo";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=47579158;
 //BA.debugLineNum = 47579158;BA.debugLine="TabHost1.AddTab(\"اضافه کاری\" , \"tab_layout_ezafek";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"اضافه کاری","tab_layout_ezafekari.bal");
RDebugUtils.currentLine=47579159;
 //BA.debugLineNum = 47579159;BA.debugLine="TabHost1.AddTab(\"مرخصی\" , \"tab_layout_morakhasi.b";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"مرخصی","tab_layout_morakhasi.bal");
RDebugUtils.currentLine=47579160;
 //BA.debugLineNum = 47579160;BA.debugLine="TabHost1.AddTab(\"تردد\" , \"tab_layout_taradod.bal\"";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"تردد","tab_layout_taradod.bal");
RDebugUtils.currentLine=47579161;
 //BA.debugLineNum = 47579161;BA.debugLine="TabHost1.AddTab(\"ماموریت\" , \"tab_layout_mamoriat.";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"ماموریت","tab_layout_mamoriat.bal");
RDebugUtils.currentLine=47579163;
 //BA.debugLineNum = 47579163;BA.debugLine="TabHost1.CurrentTab=curent_tab_list";
mostCurrent._tabhost1.setCurrentTab(_curent_tab_list);
RDebugUtils.currentLine=47579165;
 //BA.debugLineNum = 47579165;BA.debugLine="list_ezafekari_id.Initialize";
mostCurrent._list_ezafekari_id.Initialize();
RDebugUtils.currentLine=47579168;
 //BA.debugLineNum = 47579168;BA.debugLine="list_morakhasi_id.Initialize";
mostCurrent._list_morakhasi_id.Initialize();
RDebugUtils.currentLine=47579171;
 //BA.debugLineNum = 47579171;BA.debugLine="list_taradod_id.Initialize";
mostCurrent._list_taradod_id.Initialize();
RDebugUtils.currentLine=47579174;
 //BA.debugLineNum = 47579174;BA.debugLine="list_mamoriat_id.Initialize";
mostCurrent._list_mamoriat_id.Initialize();
RDebugUtils.currentLine=47579178;
 //BA.debugLineNum = 47579178;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=47579182;
 //BA.debugLineNum = 47579182;BA.debugLine="pan_hed_list.Color=color4";
mostCurrent._pan_hed_list.setColor(_color4);
RDebugUtils.currentLine=47579189;
 //BA.debugLineNum = 47579189;BA.debugLine="End Sub";
return "";
}
public static String  _btneight_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btneight_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btneight_click", null));}
RDebugUtils.currentLine=47185920;
 //BA.debugLineNum = 47185920;BA.debugLine="Sub btnEight_Click";
RDebugUtils.currentLine=47185921;
 //BA.debugLineNum = 47185921;BA.debugLine="click_count_Increment_and_fill(btnEight.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btneight.getText());
RDebugUtils.currentLine=47185922;
 //BA.debugLineNum = 47185922;BA.debugLine="End Sub";
return "";
}
public static String  _click_count_increment_and_fill(String _input_text) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "click_count_increment_and_fill", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "click_count_increment_and_fill", new Object[] {_input_text}));}
RDebugUtils.currentLine=47316992;
 //BA.debugLineNum = 47316992;BA.debugLine="Sub click_count_Increment_and_fill (input_Text As";
RDebugUtils.currentLine=47316994;
 //BA.debugLineNum = 47316994;BA.debugLine="Click_Count = Click_Count + 1";
_click_count = (int) (_click_count+1);
RDebugUtils.currentLine=47316996;
 //BA.debugLineNum = 47316996;BA.debugLine="Select Click_Count";
switch (_click_count) {
case 1: {
RDebugUtils.currentLine=47316998;
 //BA.debugLineNum = 47316998;BA.debugLine="key1.Color = Colors.Red";
mostCurrent._key1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=47317001;
 //BA.debugLineNum = 47317001;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 2: {
RDebugUtils.currentLine=47317004;
 //BA.debugLineNum = 47317004;BA.debugLine="key2.Color = Colors.Red";
mostCurrent._key2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=47317007;
 //BA.debugLineNum = 47317007;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 3: {
RDebugUtils.currentLine=47317010;
 //BA.debugLineNum = 47317010;BA.debugLine="key3.Color = Colors.Red";
mostCurrent._key3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=47317013;
 //BA.debugLineNum = 47317013;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 4: {
RDebugUtils.currentLine=47317016;
 //BA.debugLineNum = 47317016;BA.debugLine="key4.Color = Colors.Red";
mostCurrent._key4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=47317019;
 //BA.debugLineNum = 47317019;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
RDebugUtils.currentLine=47317025;
 //BA.debugLineNum = 47317025;BA.debugLine="If entered_Password = Master_Password Then";
if ((mostCurrent._entered_password).equals(mostCurrent._master_password)) { 
RDebugUtils.currentLine=47317028;
 //BA.debugLineNum = 47317028;BA.debugLine="resetting_all";
_resetting_all();
RDebugUtils.currentLine=47317030;
 //BA.debugLineNum = 47317030;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=47317032;
 //BA.debugLineNum = 47317032;BA.debugLine="ToastMessageShow(\"رمز عبور اشتباه است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("رمز عبور اشتباه است"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=47317036;
 //BA.debugLineNum = 47317036;BA.debugLine="resetting_all";
_resetting_all();
 };
 break; }
}
;
RDebugUtils.currentLine=47317041;
 //BA.debugLineNum = 47317041;BA.debugLine="End Sub";
return "";
}
public static String  _btnfive_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnfive_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnfive_click", null));}
RDebugUtils.currentLine=46989312;
 //BA.debugLineNum = 46989312;BA.debugLine="Sub btnFive_Click";
RDebugUtils.currentLine=46989313;
 //BA.debugLineNum = 46989313;BA.debugLine="click_count_Increment_and_fill(btnFive.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnfive.getText());
RDebugUtils.currentLine=46989314;
 //BA.debugLineNum = 46989314;BA.debugLine="End Sub";
return "";
}
public static String  _btnfour_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnfour_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnfour_click", null));}
RDebugUtils.currentLine=46923776;
 //BA.debugLineNum = 46923776;BA.debugLine="Sub btnFour_Click";
RDebugUtils.currentLine=46923777;
 //BA.debugLineNum = 46923777;BA.debugLine="click_count_Increment_and_fill(btnFour.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnfour.getText());
RDebugUtils.currentLine=46923778;
 //BA.debugLineNum = 46923778;BA.debugLine="End Sub";
return "";
}
public static String  _btnnine_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnnine_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnnine_click", null));}
RDebugUtils.currentLine=47251456;
 //BA.debugLineNum = 47251456;BA.debugLine="Sub btnNine_Click";
RDebugUtils.currentLine=47251457;
 //BA.debugLineNum = 47251457;BA.debugLine="click_count_Increment_and_fill(btnNine.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnnine.getText());
RDebugUtils.currentLine=47251458;
 //BA.debugLineNum = 47251458;BA.debugLine="End Sub";
return "";
}
public static String  _btnone_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnone_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnone_click", null));}
RDebugUtils.currentLine=46727168;
 //BA.debugLineNum = 46727168;BA.debugLine="Sub btnOne_Click";
RDebugUtils.currentLine=46727169;
 //BA.debugLineNum = 46727169;BA.debugLine="click_count_Increment_and_fill(btnOne.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btnone.getText());
RDebugUtils.currentLine=46727170;
 //BA.debugLineNum = 46727170;BA.debugLine="End Sub";
return "";
}
public static String  _btnseven_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnseven_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnseven_click", null));}
RDebugUtils.currentLine=47120384;
 //BA.debugLineNum = 47120384;BA.debugLine="Sub btnSeven_Click";
RDebugUtils.currentLine=47120385;
 //BA.debugLineNum = 47120385;BA.debugLine="click_count_Increment_and_fill(btnSeven.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btnseven.getText());
RDebugUtils.currentLine=47120386;
 //BA.debugLineNum = 47120386;BA.debugLine="End Sub";
return "";
}
public static String  _btnsix_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnsix_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnsix_click", null));}
RDebugUtils.currentLine=47054848;
 //BA.debugLineNum = 47054848;BA.debugLine="Sub btnSix_Click";
RDebugUtils.currentLine=47054849;
 //BA.debugLineNum = 47054849;BA.debugLine="click_count_Increment_and_fill(btnSix.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btnsix.getText());
RDebugUtils.currentLine=47054850;
 //BA.debugLineNum = 47054850;BA.debugLine="End Sub";
return "";
}
public static String  _btnthree_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnthree_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnthree_click", null));}
RDebugUtils.currentLine=46858240;
 //BA.debugLineNum = 46858240;BA.debugLine="Sub btnThree_Click";
RDebugUtils.currentLine=46858241;
 //BA.debugLineNum = 46858241;BA.debugLine="click_count_Increment_and_fill(btnThree.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btnthree.getText());
RDebugUtils.currentLine=46858242;
 //BA.debugLineNum = 46858242;BA.debugLine="End Sub";
return "";
}
public static String  _btntwo_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btntwo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btntwo_click", null));}
RDebugUtils.currentLine=46792704;
 //BA.debugLineNum = 46792704;BA.debugLine="Sub btnTwo_Click";
RDebugUtils.currentLine=46792705;
 //BA.debugLineNum = 46792705;BA.debugLine="click_count_Increment_and_fill(btnTwo.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btntwo.getText());
RDebugUtils.currentLine=46792706;
 //BA.debugLineNum = 46792706;BA.debugLine="End Sub";
return "";
}
public static String  _btnzero_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnzero_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnzero_click", null));}
RDebugUtils.currentLine=46661632;
 //BA.debugLineNum = 46661632;BA.debugLine="Sub btnZero_Click";
RDebugUtils.currentLine=46661633;
 //BA.debugLineNum = 46661633;BA.debugLine="click_count_Increment_and_fill(btnZero.Text)";
_click_count_increment_and_fill(mostCurrent._btnzero.getText());
RDebugUtils.currentLine=46661634;
 //BA.debugLineNum = 46661634;BA.debugLine="End Sub";
return "";
}
public static String  _ckb_ezaf_taradod_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ckb_ezaf_taradod_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ckb_ezaf_taradod_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=54657024;
 //BA.debugLineNum = 54657024;BA.debugLine="Private Sub ckb_ezaf_taradod_CheckedChange(Checked";
RDebugUtils.currentLine=54657025;
 //BA.debugLineNum = 54657025;BA.debugLine="If(Checked=True)Then";
if ((_checked==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=54657026;
 //BA.debugLineNum = 54657026;BA.debugLine="radio_ez_adi.Enabled=True";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=54657027;
 //BA.debugLineNum = 54657027;BA.debugLine="radio_ez_fog.Enabled=True";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=54657029;
 //BA.debugLineNum = 54657029;BA.debugLine="radio_ez_adi.Enabled=False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=54657030;
 //BA.debugLineNum = 54657030;BA.debugLine="radio_ez_fog.Enabled=False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=54657032;
 //BA.debugLineNum = 54657032;BA.debugLine="End Sub";
return "";
}
public static String  _resetting_all() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "resetting_all", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "resetting_all", null));}
RDebugUtils.currentLine=47382528;
 //BA.debugLineNum = 47382528;BA.debugLine="Sub resetting_all";
RDebugUtils.currentLine=47382530;
 //BA.debugLineNum = 47382530;BA.debugLine="key1.color = Colors.White";
mostCurrent._key1.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=47382531;
 //BA.debugLineNum = 47382531;BA.debugLine="key2.Color = Colors.White";
mostCurrent._key2.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=47382532;
 //BA.debugLineNum = 47382532;BA.debugLine="key3.Color = Colors.White";
mostCurrent._key3.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=47382533;
 //BA.debugLineNum = 47382533;BA.debugLine="key4.Color = Colors.white";
mostCurrent._key4.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=47382536;
 //BA.debugLineNum = 47382536;BA.debugLine="entered_Password = \"\"";
mostCurrent._entered_password = "";
RDebugUtils.currentLine=47382540;
 //BA.debugLineNum = 47382540;BA.debugLine="Click_Count = 0";
_click_count = (int) (0);
RDebugUtils.currentLine=47382541;
 //BA.debugLineNum = 47382541;BA.debugLine="End Sub";
return "";
}
public static String  _cust_lv_taradod_itemclick(int _index,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cust_lv_taradod_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cust_lv_taradod_itemclick", new Object[] {_index,_value}));}
RDebugUtils.currentLine=52690944;
 //BA.debugLineNum = 52690944;BA.debugLine="Private Sub cust_LV_taradod_ItemClick (Index As In";
RDebugUtils.currentLine=52690946;
 //BA.debugLineNum = 52690946;BA.debugLine="End Sub";
return "";
}
public static String  _tabhost1_tabchanged() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tabhost1_tabchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tabhost1_tabchanged", null));}
anywheresoftware.b4a.objects.collections.List _ls_all_saat = null;
String _str_saat = "";
RDebugUtils.currentLine=47644672;
 //BA.debugLineNum = 47644672;BA.debugLine="Private Sub TabHost1_TabChanged";
RDebugUtils.currentLine=47644674;
 //BA.debugLineNum = 47644674;BA.debugLine="Dim ls_all_saat As List";
_ls_all_saat = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=47644675;
 //BA.debugLineNum = 47644675;BA.debugLine="ls_all_saat.Initialize";
_ls_all_saat.Initialize();
RDebugUtils.currentLine=47644676;
 //BA.debugLineNum = 47644676;BA.debugLine="Dim str_saat As String";
_str_saat = "";
RDebugUtils.currentLine=47644678;
 //BA.debugLineNum = 47644678;BA.debugLine="If(sp_year.IsInitialized)Then";
if ((mostCurrent._sp_year.IsInitialized())) { 
RDebugUtils.currentLine=47644684;
 //BA.debugLineNum = 47644684;BA.debugLine="Select TabHost1.CurrentTab";
switch (BA.switchObjectToInt(mostCurrent._tabhost1.getCurrentTab(),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
RDebugUtils.currentLine=47644686;
 //BA.debugLineNum = 47644686;BA.debugLine="ls_all_saat=dbCode.all_ezafekari_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
RDebugUtils.currentLine=47644687;
 //BA.debugLineNum = 47644687;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
case 1: {
RDebugUtils.currentLine=47644689;
 //BA.debugLineNum = 47644689;BA.debugLine="ls_all_saat=dbCode.all_morakhasi_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=47644691;
 //BA.debugLineNum = 47644691;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" روز و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" ساعت و "+BA.ObjectToString(_ls_all_saat.Get((int) (2)))+" دقیقه ";
 break; }
case 2: {
RDebugUtils.currentLine=47644693;
 //BA.debugLineNum = 47644693;BA.debugLine="ls_all_saat=dbCode.all_taradod_mah(myfunc.fa2e";
_ls_all_saat = mostCurrent._dbcode._all_taradod_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=47644694;
 //BA.debugLineNum = 47644694;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
case 3: {
RDebugUtils.currentLine=47644696;
 //BA.debugLineNum = 47644696;BA.debugLine="ls_all_saat=dbCode.all_mamoriat_mah(myfunc.fa2";
_ls_all_saat = mostCurrent._dbcode._all_mamoriat_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=47644697;
 //BA.debugLineNum = 47644697;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" روز و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" ساعت و "+BA.ObjectToString(_ls_all_saat.Get((int) (2)))+" دقیقه ";
 break; }
}
;
RDebugUtils.currentLine=47644704;
 //BA.debugLineNum = 47644704;BA.debugLine="lbl_majmoe_saat.Text=str_saat";
mostCurrent._lbl_majmoe_saat.setText(BA.ObjectToCharSequence(_str_saat));
 };
RDebugUtils.currentLine=47644710;
 //BA.debugLineNum = 47644710;BA.debugLine="End Sub";
return "";
}
public static String  _finger_scaning() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "finger_scaning", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "finger_scaning", null));}
RDebugUtils.currentLine=46530560;
 //BA.debugLineNum = 46530560;BA.debugLine="Sub finger_scaning";
RDebugUtils.currentLine=46530561;
 //BA.debugLineNum = 46530561;BA.debugLine="fingerprint.Authenticate";
mostCurrent._fingerprint._authenticate /*String*/ (null);
RDebugUtils.currentLine=46530562;
 //BA.debugLineNum = 46530562;BA.debugLine="ToastMessageShow(\"Scanning...\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Scanning..."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46530563;
 //BA.debugLineNum = 46530563;BA.debugLine="End Sub";
return "";
}
public static String  _get_dataedit_byid(int _id1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_dataedit_byid", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_dataedit_byid", new Object[] {_id1}));}
RDebugUtils.currentLine=51773440;
 //BA.debugLineNum = 51773440;BA.debugLine="Sub get_dataEdit_byId(id1 As Int)";
RDebugUtils.currentLine=51773441;
 //BA.debugLineNum = 51773441;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=51773442;
 //BA.debugLineNum = 51773442;BA.debugLine="If(index_box=1)Then";
if ((_index_box==1)) { 
RDebugUtils.currentLine=51773443;
 //BA.debugLineNum = 51773443;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=51773444;
 //BA.debugLineNum = 51773444;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=51773446;
 //BA.debugLineNum = 51773446;BA.debugLine="If(dbCode.res.GetInt(\"state\")=0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==0)) { 
RDebugUtils.currentLine=51773447;
 //BA.debugLineNum = 51773447;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=51773449;
 //BA.debugLineNum = 51773449;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
 }else 
{RDebugUtils.currentLine=51773454;
 //BA.debugLineNum = 51773454;BA.debugLine="Else If(index_box=2)Then";
if ((_index_box==2)) { 
RDebugUtils.currentLine=51773455;
 //BA.debugLineNum = 51773455;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=51773456;
 //BA.debugLineNum = 51773456;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=51773459;
 //BA.debugLineNum = 51773459;BA.debugLine="Select dbCode.res.GetInt(\"state\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
RDebugUtils.currentLine=51773461;
 //BA.debugLineNum = 51773461;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
RDebugUtils.currentLine=51773463;
 //BA.debugLineNum = 51773463;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
RDebugUtils.currentLine=51773465;
 //BA.debugLineNum = 51773465;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
RDebugUtils.currentLine=51773467;
 //BA.debugLineNum = 51773467;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
RDebugUtils.currentLine=51773471;
 //BA.debugLineNum = 51773471;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
RDebugUtils.currentLine=51773472;
 //BA.debugLineNum = 51773472;BA.debugLine="index_noe_morakhasi=dbCode.res.GetInt(\"state\")";
_index_noe_morakhasi = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state");
 }else 
{RDebugUtils.currentLine=51773476;
 //BA.debugLineNum = 51773476;BA.debugLine="Else If(index_box=3)Then";
if ((_index_box==3)) { 
RDebugUtils.currentLine=51773477;
 //BA.debugLineNum = 51773477;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=51773478;
 //BA.debugLineNum = 51773478;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 }else 
{RDebugUtils.currentLine=51773481;
 //BA.debugLineNum = 51773481;BA.debugLine="Else If(index_box=5)Then";
if ((_index_box==5)) { 
RDebugUtils.currentLine=51773482;
 //BA.debugLineNum = 51773482;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mamoriat WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=51773483;
 //BA.debugLineNum = 51773483;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 }}}}
;
RDebugUtils.currentLine=51773490;
 //BA.debugLineNum = 51773490;BA.debugLine="lbl_tim1.Text=dbCode.res.GetString(\"time_from\")";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")));
RDebugUtils.currentLine=51773491;
 //BA.debugLineNum = 51773491;BA.debugLine="lbl_tim2.Text=dbCode.res.GetString(\"time_to\")";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=51773493;
 //BA.debugLineNum = 51773493;BA.debugLine="lbl_date1.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=51773494;
 //BA.debugLineNum = 51773494;BA.debugLine="lbl_date2.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))));
RDebugUtils.currentLine=51773496;
 //BA.debugLineNum = 51773496;BA.debugLine="et_tozihat.Text=dbCode.res.GetString(\"tozihat\")";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=51773499;
 //BA.debugLineNum = 51773499;BA.debugLine="End Sub";
return "";
}
public static String  _img_slider(int _index1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "img_slider", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "img_slider", new Object[] {_index1}));}
RDebugUtils.currentLine=51642368;
 //BA.debugLineNum = 51642368;BA.debugLine="Sub img_slider (index1 As Int)";
RDebugUtils.currentLine=51642369;
 //BA.debugLineNum = 51642369;BA.debugLine="Select index1";
switch (_index1) {
case 0: {
RDebugUtils.currentLine=51642371;
 //BA.debugLineNum = 51642371;BA.debugLine="img_help.Bitmap=bit_img0";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img0.getObject()));
 break; }
case 1: {
RDebugUtils.currentLine=51642373;
 //BA.debugLineNum = 51642373;BA.debugLine="img_help.Bitmap=bit_img1";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img1.getObject()));
 break; }
case 2: {
RDebugUtils.currentLine=51642376;
 //BA.debugLineNum = 51642376;BA.debugLine="img_help.Bitmap=bit_img2";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img2.getObject()));
 break; }
case 3: {
RDebugUtils.currentLine=51642379;
 //BA.debugLineNum = 51642379;BA.debugLine="img_help.Bitmap=bit_img3";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img3.getObject()));
 break; }
case 4: {
RDebugUtils.currentLine=51642382;
 //BA.debugLineNum = 51642382;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
 break; }
default: {
RDebugUtils.currentLine=51642385;
 //BA.debugLineNum = 51642385;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("251642385","error",0);
 break; }
}
;
RDebugUtils.currentLine=51642388;
 //BA.debugLineNum = 51642388;BA.debugLine="End Sub";
return "";
}
public static String  _inapp_purchasecompleted(boolean _success,anywheresoftware.b4a.inappbilling3.BillingManager3.Prchase _product) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "inapp_purchasecompleted", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "inapp_purchasecompleted", new Object[] {_success,_product}));}
RDebugUtils.currentLine=46333952;
 //BA.debugLineNum = 46333952;BA.debugLine="Sub inapp_PurchaseCompleted (Success As Boolean, P";
RDebugUtils.currentLine=46333955;
 //BA.debugLineNum = 46333955;BA.debugLine="If Success=True Then";
if (_success==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=46333957;
 //BA.debugLineNum = 46333957;BA.debugLine="If Product.ProductId=\"ezafekari2\" Then";
if ((_product.getProductId()).equals("ezafekari2")) { 
RDebugUtils.currentLine=46333959;
 //BA.debugLineNum = 46333959;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\",\"\")";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
RDebugUtils.currentLine=46333960;
 //BA.debugLineNum = 46333960;BA.debugLine="MsgboxAsync(\"پرداخت انجام شده است\",\"انجام شد\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("پرداخت انجام شده است"),BA.ObjectToCharSequence("انجام شد"),processBA);
RDebugUtils.currentLine=46333961;
 //BA.debugLineNum = 46333961;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی ا";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=46333963;
 //BA.debugLineNum = 46333963;BA.debugLine="inapp.ConsumeProduct(Product)";
mostCurrent._inapp.ConsumeProduct(processBA,_product);
RDebugUtils.currentLine=46333965;
 //BA.debugLineNum = 46333965;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
RDebugUtils.currentLine=46333966;
 //BA.debugLineNum = 46333966;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=46333970;
 //BA.debugLineNum = 46333970;BA.debugLine="ToastMessageShow(\"خرید انجام نشد. دوباره تلاش کن";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خرید انجام نشد. دوباره تلاش کنید"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=46333972;
 //BA.debugLineNum = 46333972;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=45940736;
 //BA.debugLineNum = 45940736;BA.debugLine="Sub Jobdone (job As HttpJob)";
RDebugUtils.currentLine=45940737;
 //BA.debugLineNum = 45940737;BA.debugLine="Try";
try {RDebugUtils.currentLine=45940739;
 //BA.debugLineNum = 45940739;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=45940740;
 //BA.debugLineNum = 45940740;BA.debugLine="If job.JobName=\"ht\" Then";
if ((_job._jobname /*String*/ ).equals("ht")) { 
RDebugUtils.currentLine=45940741;
 //BA.debugLineNum = 45940741;BA.debugLine="If(job.GetString <> \"\")Then";
if (((_job._getstring /*String*/ (null)).equals("") == false)) { 
RDebugUtils.currentLine=45940743;
 //BA.debugLineNum = 45940743;BA.debugLine="If(job.GetString.Contains(\"accessok\"))Then";
if ((_job._getstring /*String*/ (null).contains("accessok"))) { 
RDebugUtils.currentLine=45940746;
 //BA.debugLineNum = 45940746;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
 }else {
RDebugUtils.currentLine=45940749;
 //BA.debugLineNum = 45940749;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
RDebugUtils.currentLine=45940750;
 //BA.debugLineNum = 45940750;BA.debugLine="myfunc.help_man(\"توجه\",\"نسخه طلایی از طرف ا";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","نسخه طلایی از طرف ادمین فعال شد");
 };
 }else 
{RDebugUtils.currentLine=45940753;
 //BA.debugLineNum = 45940753;BA.debugLine="Else If (job.GetString.Contains(\"accessno\"))T";
if ((_job._getstring /*String*/ (null).contains("accessno"))) { 
RDebugUtils.currentLine=45940755;
 //BA.debugLineNum = 45940755;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
RDebugUtils.currentLine=45940756;
 //BA.debugLineNum = 45940756;BA.debugLine="File.Delete(File.DirInternal,\"payokok\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok");
RDebugUtils.currentLine=45940757;
 //BA.debugLineNum = 45940757;BA.debugLine="myfunc.help_man(\"توجه\",\" نسخه طلایی از طرف";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه"," نسخه طلایی از طرف ادمین غیرفعال شد");
 };
 }else 
{RDebugUtils.currentLine=45940759;
 //BA.debugLineNum = 45940759;BA.debugLine="Else If (job.GetString.Contains(\"lockok\"))The";
if ((_job._getstring /*String*/ (null).contains("lockok"))) { 
RDebugUtils.currentLine=45940761;
 //BA.debugLineNum = 45940761;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=45940762;
 //BA.debugLineNum = 45940762;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
RDebugUtils.currentLine=45940764;
 //BA.debugLineNum = 45940764;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=45940765;
 //BA.debugLineNum = 45940765;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
RDebugUtils.currentLine=45940766;
 //BA.debugLineNum = 45940766;BA.debugLine="ls_lock0.Set(0,\"true\")";
_ls_lock0.Set((int) (0),(Object)("true"));
RDebugUtils.currentLine=45940767;
 //BA.debugLineNum = 45940767;BA.debugLine="ls_lock0.Set(1,\"false\")";
_ls_lock0.Set((int) (1),(Object)("false"));
RDebugUtils.currentLine=45940768;
 //BA.debugLineNum = 45940768;BA.debugLine="ls_lock0.Set(2,\"2022\")";
_ls_lock0.Set((int) (2),(Object)("2022"));
 }else {
RDebugUtils.currentLine=45940770;
 //BA.debugLineNum = 45940770;BA.debugLine="ls_lock0.Add(\"true\")";
_ls_lock0.Add((Object)("true"));
RDebugUtils.currentLine=45940771;
 //BA.debugLineNum = 45940771;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
RDebugUtils.currentLine=45940772;
 //BA.debugLineNum = 45940772;BA.debugLine="ls_lock0.Add(\"2022\")";
_ls_lock0.Add((Object)("2022"));
RDebugUtils.currentLine=45940773;
 //BA.debugLineNum = 45940773;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 };
RDebugUtils.currentLine=45940775;
 //BA.debugLineNum = 45940775;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock0);
 }else 
{RDebugUtils.currentLine=45940777;
 //BA.debugLineNum = 45940777;BA.debugLine="Else If (job.GetString.Contains(\"lockno\"))The";
if ((_job._getstring /*String*/ (null).contains("lockno"))) { 
RDebugUtils.currentLine=45940778;
 //BA.debugLineNum = 45940778;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=45940779;
 //BA.debugLineNum = 45940779;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
RDebugUtils.currentLine=45940781;
 //BA.debugLineNum = 45940781;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=45940782;
 //BA.debugLineNum = 45940782;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
RDebugUtils.currentLine=45940783;
 //BA.debugLineNum = 45940783;BA.debugLine="ls_lock0.Set(0,\"false\")";
_ls_lock0.Set((int) (0),(Object)("false"));
RDebugUtils.currentLine=45940784;
 //BA.debugLineNum = 45940784;BA.debugLine="ls_lock0.Set(1,\"false\")";
_ls_lock0.Set((int) (1),(Object)("false"));
RDebugUtils.currentLine=45940785;
 //BA.debugLineNum = 45940785;BA.debugLine="ls_lock0.Set(2,\"\")";
_ls_lock0.Set((int) (2),(Object)(""));
 }else {
RDebugUtils.currentLine=45940787;
 //BA.debugLineNum = 45940787;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
RDebugUtils.currentLine=45940788;
 //BA.debugLineNum = 45940788;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
RDebugUtils.currentLine=45940789;
 //BA.debugLineNum = 45940789;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
RDebugUtils.currentLine=45940790;
 //BA.debugLineNum = 45940790;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 };
RDebugUtils.currentLine=45940792;
 //BA.debugLineNum = 45940792;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock0);
 }else 
{RDebugUtils.currentLine=45940795;
 //BA.debugLineNum = 45940795;BA.debugLine="Else If (job.GetString.Contains(\"new_msg\"))Th";
if ((_job._getstring /*String*/ (null).contains("new_msg"))) { 
RDebugUtils.currentLine=45940797;
 //BA.debugLineNum = 45940797;BA.debugLine="is_new_msg=True";
_is_new_msg = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=45940803;
 //BA.debugLineNum = 45940803;BA.debugLine="msg=job.GetString";
mostCurrent._msg = _job._getstring /*String*/ (null);
RDebugUtils.currentLine=45940805;
 //BA.debugLineNum = 45940805;BA.debugLine="tim_msg.Enabled=True";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }}}}}
;
 };
 };
RDebugUtils.currentLine=45940814;
 //BA.debugLineNum = 45940814;BA.debugLine="If job.JobName=\"chkupdate\" Then";
if ((_job._jobname /*String*/ ).equals("chkupdate")) { 
RDebugUtils.currentLine=45940816;
 //BA.debugLineNum = 45940816;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=45940818;
 //BA.debugLineNum = 45940818;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=45940820;
 //BA.debugLineNum = 45940820;BA.debugLine="Dim root1 As List";
_root1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=45940821;
 //BA.debugLineNum = 45940821;BA.debugLine="root1.Initialize";
_root1.Initialize();
RDebugUtils.currentLine=45940822;
 //BA.debugLineNum = 45940822;BA.debugLine="root1=parser.NextArray";
_root1 = _parser.NextArray();
RDebugUtils.currentLine=45940824;
 //BA.debugLineNum = 45940824;BA.debugLine="Dim str_type As String = root1.Get(0)";
_str_type = BA.ObjectToString(_root1.Get((int) (0)));
RDebugUtils.currentLine=45940825;
 //BA.debugLineNum = 45940825;BA.debugLine="str_type= str_type.Replace(\"type:\",\"\")";
_str_type = _str_type.replace("type:","");
RDebugUtils.currentLine=45940827;
 //BA.debugLineNum = 45940827;BA.debugLine="Dim str_version_code As String = root1.Get(1)";
_str_version_code = BA.ObjectToString(_root1.Get((int) (1)));
RDebugUtils.currentLine=45940828;
 //BA.debugLineNum = 45940828;BA.debugLine="str_version_code=str_version_code.Replace(\"ver";
_str_version_code = _str_version_code.replace("version_code:","");
RDebugUtils.currentLine=45940830;
 //BA.debugLineNum = 45940830;BA.debugLine="Dim str_version_name As String = root1.Get(2)";
_str_version_name = BA.ObjectToString(_root1.Get((int) (2)));
RDebugUtils.currentLine=45940831;
 //BA.debugLineNum = 45940831;BA.debugLine="str_version_name=str_version_name.Replace(\"ver";
_str_version_name = _str_version_name.replace("version_name:","");
RDebugUtils.currentLine=45940833;
 //BA.debugLineNum = 45940833;BA.debugLine="Dim str_changelog_fa As String = root1.Get(3)";
_str_changelog_fa = BA.ObjectToString(_root1.Get((int) (3)));
RDebugUtils.currentLine=45940834;
 //BA.debugLineNum = 45940834;BA.debugLine="str_changelog_fa=str_changelog_fa.Replace(\"cha";
_str_changelog_fa = _str_changelog_fa.replace("changelog_fa:","");
RDebugUtils.currentLine=45940836;
 //BA.debugLineNum = 45940836;BA.debugLine="Dim str_message As String = root1.Get(4)";
_str_message = BA.ObjectToString(_root1.Get((int) (4)));
RDebugUtils.currentLine=45940837;
 //BA.debugLineNum = 45940837;BA.debugLine="str_message=str_message.Replace(\"message:\",\"\")";
_str_message = _str_message.replace("message:","");
RDebugUtils.currentLine=45940844;
 //BA.debugLineNum = 45940844;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=45940845;
 //BA.debugLineNum = 45940845;BA.debugLine="pan_all_chekUpdate.Visible=True";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=45940846;
 //BA.debugLineNum = 45940846;BA.debugLine="If(str_type==\"success\")Then";
if (((_str_type).equals("success"))) { 
RDebugUtils.currentLine=45940847;
 //BA.debugLineNum = 45940847;BA.debugLine="If(str_version_code>Application.VersionCode)T";
if (((double)(Double.parseDouble(_str_version_code))>anywheresoftware.b4a.keywords.Common.Application.getVersionCode())) { 
RDebugUtils.currentLine=45940848;
 //BA.debugLineNum = 45940848;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl'";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body><span style='color:#3AAD00; font-weight: bold;'> بروزرسانی جدید موجود است. </span><br> "+_str_changelog_fa+"</body></html>");
RDebugUtils.currentLine=45940849;
 //BA.debugLineNum = 45940849;BA.debugLine="lbl_chk_update_ok.Tag=1";
mostCurrent._lbl_chk_update_ok.setTag((Object)(1));
RDebugUtils.currentLine=45940850;
 //BA.debugLineNum = 45940850;BA.debugLine="lbl_chk_update_ok.Text=\"بروزرسانی برنامه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("بروزرسانی برنامه"));
 }else {
RDebugUtils.currentLine=45940852;
 //BA.debugLineNum = 45940852;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl'";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body> برنامه شما بروز می باشد. با تشکر </body></html>");
RDebugUtils.currentLine=45940853;
 //BA.debugLineNum = 45940853;BA.debugLine="lbl_chk_update_ok.Tag=0";
mostCurrent._lbl_chk_update_ok.setTag((Object)(0));
RDebugUtils.currentLine=45940854;
 //BA.debugLineNum = 45940854;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("باشه"));
 };
 }else 
{RDebugUtils.currentLine=45940857;
 //BA.debugLineNum = 45940857;BA.debugLine="Else if (str_type==\"unsuccess\")Then";
if (((_str_type).equals("unsuccess"))) { 
RDebugUtils.currentLine=45940858;
 //BA.debugLineNum = 45940858;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl'>";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>خطا در اتصال</body></html>");
RDebugUtils.currentLine=45940859;
 //BA.debugLineNum = 45940859;BA.debugLine="lbl_chk_update_ok.Tag=0";
mostCurrent._lbl_chk_update_ok.setTag((Object)(0));
RDebugUtils.currentLine=45940860;
 //BA.debugLineNum = 45940860;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("باشه"));
 }}
;
 };
 }else {
 };
 } 
       catch (Exception e91) {
			processBA.setLastException(e91);RDebugUtils.currentLine=45940873;
 //BA.debugLineNum = 45940873;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("245940873",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=45940874;
 //BA.debugLineNum = 45940874;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=45940877;
 //BA.debugLineNum = 45940877;BA.debugLine="End Sub";
return "";
}
public static String  _kharid() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "kharid", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "kharid", null));}
RDebugUtils.currentLine=46268416;
 //BA.debugLineNum = 46268416;BA.debugLine="Sub kharid";
RDebugUtils.currentLine=46268419;
 //BA.debugLineNum = 46268419;BA.debugLine="If(myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=46268420;
 //BA.debugLineNum = 46268420;BA.debugLine="Try";
try {RDebugUtils.currentLine=46268422;
 //BA.debugLineNum = 46268422;BA.debugLine="inapp.RequestPayment(\"ezafekari2\",\"inapp\",\"ezaf";
mostCurrent._inapp.RequestPayment(processBA,"ezafekari2","inapp","ezafekari2");
 } 
       catch (Exception e5) {
			processBA.setLastException(e5);RDebugUtils.currentLine=46268425;
 //BA.debugLineNum = 46268425;BA.debugLine="MsgboxAsync(\"1- از نصب بودن برنامه بازار اطمینا";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("1- از نصب بودن برنامه بازار اطمینان یابید."+anywheresoftware.b4a.keywords.Common.CRLF+" 2- برنامه ها را ببندید و دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 };
 }else {
RDebugUtils.currentLine=46268428;
 //BA.debugLineNum = 46268428;BA.debugLine="ToastMessageShow(\"خطا در اتصال \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال "),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=46268431;
 //BA.debugLineNum = 46268431;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_litemenu_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_litemenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_litemenu_click", null));}
RDebugUtils.currentLine=52953088;
 //BA.debugLineNum = 52953088;BA.debugLine="Private Sub pan_all_liteMenu_Click";
RDebugUtils.currentLine=52953089;
 //BA.debugLineNum = 52953089;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=52953090;
 //BA.debugLineNum = 52953090;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chk_update_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_chk_update_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_chk_update_click", null));}
String _send2 = "";
RDebugUtils.currentLine=54263808;
 //BA.debugLineNum = 54263808;BA.debugLine="Private Sub lbl_chk_update_Click";
RDebugUtils.currentLine=54263810;
 //BA.debugLineNum = 54263810;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=54263811;
 //BA.debugLineNum = 54263811;BA.debugLine="ProgressDialogShow(\"بررسی بروزرسانی ...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("بررسی بروزرسانی ..."));
RDebugUtils.currentLine=54263812;
 //BA.debugLineNum = 54263812;BA.debugLine="ht.Initialize(\"chkupdate\",Me)";
mostCurrent._ht._initialize /*String*/ (null,processBA,"chkupdate",main.getObject());
RDebugUtils.currentLine=54263813;
 //BA.debugLineNum = 54263813;BA.debugLine="Dim send2 As String";
_send2 = "";
RDebugUtils.currentLine=54263814;
 //BA.debugLineNum = 54263814;BA.debugLine="send2 = \"var=checkupdate\"";
_send2 = "var=checkupdate";
RDebugUtils.currentLine=54263815;
 //BA.debugLineNum = 54263815;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/chek_upda";
mostCurrent._ht._poststring /*String*/ (null,"https://taravatgroup.ir/chek_update.php",_send2);
 }else {
RDebugUtils.currentLine=54263817;
 //BA.debugLineNum = 54263817;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 };
RDebugUtils.currentLine=54263821;
 //BA.debugLineNum = 54263821;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
RDebugUtils.currentLine=54263822;
 //BA.debugLineNum = 54263822;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chk_update_ok_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_chk_update_ok_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_chk_update_ok_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _op = null;
RDebugUtils.currentLine=54525952;
 //BA.debugLineNum = 54525952;BA.debugLine="Private Sub lbl_chk_update_ok_Click";
RDebugUtils.currentLine=54525953;
 //BA.debugLineNum = 54525953;BA.debugLine="If (lbl_chk_update_ok.Tag==1)Then";
if (((mostCurrent._lbl_chk_update_ok.getTag()).equals((Object)(1)))) { 
RDebugUtils.currentLine=54525954;
 //BA.debugLineNum = 54525954;BA.debugLine="Try";
try {RDebugUtils.currentLine=54525955;
 //BA.debugLineNum = 54525955;BA.debugLine="Dim op As Intent";
_op = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=54525956;
 //BA.debugLineNum = 54525956;BA.debugLine="op.Initialize(op.ACTION_VIEW,\"bazaar://details?";
_op.Initialize(_op.ACTION_VIEW,"bazaar://details?id=ir.taravatgroup.ezafekari2");
RDebugUtils.currentLine=54525957;
 //BA.debugLineNum = 54525957;BA.debugLine="op.SetPackage(\"com.farsitel.bazaar\")";
_op.SetPackage("com.farsitel.bazaar");
RDebugUtils.currentLine=54525958;
 //BA.debugLineNum = 54525958;BA.debugLine="StartActivity(op)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_op.getObject()));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=54525960;
 //BA.debugLineNum = 54525960;BA.debugLine="myfunc.help_man(\"توجه\",\"برنامه بازار را نصب کنی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","برنامه بازار را نصب کنید !");
RDebugUtils.currentLine=54525962;
 //BA.debugLineNum = 54525962;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("254525962",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
RDebugUtils.currentLine=54525969;
 //BA.debugLineNum = 54525969;BA.debugLine="pan_all_chekUpdate_Click";
_pan_all_chekupdate_click();
RDebugUtils.currentLine=54525970;
 //BA.debugLineNum = 54525970;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_chekupdate_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_chekupdate_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_chekupdate_click", null));}
RDebugUtils.currentLine=54394880;
 //BA.debugLineNum = 54394880;BA.debugLine="Private Sub pan_all_chekUpdate_Click";
RDebugUtils.currentLine=54394881;
 //BA.debugLineNum = 54394881;BA.debugLine="pan_all_chekUpdate.Visible=False";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=54394882;
 //BA.debugLineNum = 54394882;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_ft_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_ft_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_ft_click", null));}
int _result = 0;
int _id_last_fast_taradod1 = 0;
RDebugUtils.currentLine=53346304;
 //BA.debugLineNum = 53346304;BA.debugLine="Private Sub lbl_close_FT_Click";
RDebugUtils.currentLine=53346306;
 //BA.debugLineNum = 53346306;BA.debugLine="If(isExistFile_taradod_fast=True)Then";
if ((_isexistfile_taradod_fast()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=53346307;
 //BA.debugLineNum = 53346307;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=53346308;
 //BA.debugLineNum = 53346308;BA.debugLine="result = Msgbox2(\"از اول ثبت تردد میکنید؟\", \"توج";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("از اول ثبت تردد میکنید؟"),BA.ObjectToCharSequence("توجه"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=53346309;
 //BA.debugLineNum = 53346309;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=53346311;
 //BA.debugLineNum = 53346311;BA.debugLine="Dim id_last_fast_taradod1 As Int";
_id_last_fast_taradod1 = 0;
RDebugUtils.currentLine=53346312;
 //BA.debugLineNum = 53346312;BA.debugLine="id_last_fast_taradod1=File.ReadString(File.DirI";
_id_last_fast_taradod1 = (int)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"taradod_fs_id.txt")));
RDebugUtils.currentLine=53346313;
 //BA.debugLineNum = 53346313;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=53346315;
 //BA.debugLineNum = 53346315;BA.debugLine="dbCode.sql.ExecNonQuery(\"DELETE FROM tb_taradod";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("DELETE FROM tb_taradod WHERE  id="+BA.NumberToString(_id_last_fast_taradod1));
RDebugUtils.currentLine=53346317;
 //BA.debugLineNum = 53346317;BA.debugLine="File.Delete(File.DirInternal,\"taradod_fs_id.txt";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"taradod_fs_id.txt");
RDebugUtils.currentLine=53346318;
 //BA.debugLineNum = 53346318;BA.debugLine="pan_add_taradod_fast_Click";
_pan_add_taradod_fast_click();
 };
 }else {
RDebugUtils.currentLine=53346335;
 //BA.debugLineNum = 53346335;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
RDebugUtils.currentLine=53346336;
 //BA.debugLineNum = 53346336;BA.debugLine="pan_add_taradod_fast_Click";
_pan_add_taradod_fast_click();
 };
RDebugUtils.currentLine=53346339;
 //BA.debugLineNum = 53346339;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_msgnewy_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_msgnewy_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_msgnewy_click", null));}
RDebugUtils.currentLine=45744128;
 //BA.debugLineNum = 45744128;BA.debugLine="Private Sub lbl_close_msgNewY_Click";
RDebugUtils.currentLine=45744130;
 //BA.debugLineNum = 45744130;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=45744131;
 //BA.debugLineNum = 45744131;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date1_click", null));}
RDebugUtils.currentLine=50790400;
 //BA.debugLineNum = 50790400;BA.debugLine="Private Sub lbl_date1_Click";
RDebugUtils.currentLine=50790401;
 //BA.debugLineNum = 50790401;BA.debugLine="lbl_tim1_Click";
_lbl_tim1_click();
RDebugUtils.currentLine=50790402;
 //BA.debugLineNum = 50790402;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_tim1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_tim1_click", null));}
RDebugUtils.currentLine=50855936;
 //BA.debugLineNum = 50855936;BA.debugLine="Private Sub lbl_tim1_Click";
RDebugUtils.currentLine=50855937;
 //BA.debugLineNum = 50855937;BA.debugLine="index_piker=1";
_index_piker = (int) (1);
RDebugUtils.currentLine=50855939;
 //BA.debugLineNum = 50855939;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim1.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (0))));
RDebugUtils.currentLine=50855940;
 //BA.debugLineNum = 50855940;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim1.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (1))));
RDebugUtils.currentLine=50855942;
 //BA.debugLineNum = 50855942;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date1.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (0))));
RDebugUtils.currentLine=50855943;
 //BA.debugLineNum = 50855943;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (1)));
RDebugUtils.currentLine=50855944;
 //BA.debugLineNum = 50855944;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=50855945;
 //BA.debugLineNum = 50855945;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (2))));
RDebugUtils.currentLine=50855949;
 //BA.debugLineNum = 50855949;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=50855951;
 //BA.debugLineNum = 50855951;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=50855952;
 //BA.debugLineNum = 50855952;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=50855953;
 //BA.debugLineNum = 50855953;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
RDebugUtils.currentLine=50855954;
 //BA.debugLineNum = 50855954;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
RDebugUtils.currentLine=50855955;
 //BA.debugLineNum = 50855955;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
RDebugUtils.currentLine=50855958;
 //BA.debugLineNum = 50855958;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date2_click", null));}
RDebugUtils.currentLine=50724864;
 //BA.debugLineNum = 50724864;BA.debugLine="Private Sub lbl_date2_Click";
RDebugUtils.currentLine=50724865;
 //BA.debugLineNum = 50724865;BA.debugLine="lbl_tim2_Click";
_lbl_tim2_click();
RDebugUtils.currentLine=50724866;
 //BA.debugLineNum = 50724866;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_tim2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_tim2_click", null));}
RDebugUtils.currentLine=50659328;
 //BA.debugLineNum = 50659328;BA.debugLine="Private Sub lbl_tim2_Click";
RDebugUtils.currentLine=50659329;
 //BA.debugLineNum = 50659329;BA.debugLine="index_piker=2";
_index_piker = (int) (2);
RDebugUtils.currentLine=50659330;
 //BA.debugLineNum = 50659330;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim2.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (0))));
RDebugUtils.currentLine=50659331;
 //BA.debugLineNum = 50659331;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim2.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (1))));
RDebugUtils.currentLine=50659333;
 //BA.debugLineNum = 50659333;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date2.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (0))));
RDebugUtils.currentLine=50659334;
 //BA.debugLineNum = 50659334;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (1)));
RDebugUtils.currentLine=50659335;
 //BA.debugLineNum = 50659335;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=50659336;
 //BA.debugLineNum = 50659336;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (2))));
RDebugUtils.currentLine=50659339;
 //BA.debugLineNum = 50659339;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=50659342;
 //BA.debugLineNum = 50659342;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=50659343;
 //BA.debugLineNum = 50659343;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=50659344;
 //BA.debugLineNum = 50659344;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
RDebugUtils.currentLine=50659345;
 //BA.debugLineNum = 50659345;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
RDebugUtils.currentLine=50659346;
 //BA.debugLineNum = 50659346;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
RDebugUtils.currentLine=50659348;
 //BA.debugLineNum = 50659348;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_from_list_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
RDebugUtils.currentLine=51707904;
 //BA.debugLineNum = 51707904;BA.debugLine="Private Sub lbl_edit_from_list_Click";
RDebugUtils.currentLine=51707905;
 //BA.debugLineNum = 51707905;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=51707906;
 //BA.debugLineNum = 51707906;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=51707907;
 //BA.debugLineNum = 51707907;BA.debugLine="Log(b.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("251707907",BA.ObjectToString(_b.getTag()),0);
RDebugUtils.currentLine=51707908;
 //BA.debugLineNum = 51707908;BA.debugLine="current_id_edit=b.Tag";
_current_id_edit = (int)(BA.ObjectToNumber(_b.getTag()));
RDebugUtils.currentLine=51707911;
 //BA.debugLineNum = 51707911;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
RDebugUtils.currentLine=51707912;
 //BA.debugLineNum = 51707912;BA.debugLine="pan_add_ezafekari_Click";
_pan_add_ezafekari_click();
RDebugUtils.currentLine=51707913;
 //BA.debugLineNum = 51707913;BA.debugLine="lbl_box_title.Text=\"ویرایش اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش اضافه کاری"));
 }else 
{RDebugUtils.currentLine=51707915;
 //BA.debugLineNum = 51707915;BA.debugLine="Else if (TabHost1.CurrentTab=1)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==1)) { 
RDebugUtils.currentLine=51707916;
 //BA.debugLineNum = 51707916;BA.debugLine="pan_add_morakhasi_Click";
_pan_add_morakhasi_click();
RDebugUtils.currentLine=51707917;
 //BA.debugLineNum = 51707917;BA.debugLine="lbl_box_title.Text=\"ویرایش مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش مرخصی"));
 }else 
{RDebugUtils.currentLine=51707919;
 //BA.debugLineNum = 51707919;BA.debugLine="Else if (TabHost1.CurrentTab=2)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==2)) { 
RDebugUtils.currentLine=51707920;
 //BA.debugLineNum = 51707920;BA.debugLine="pan_add_taradod_Click";
_pan_add_taradod_click();
RDebugUtils.currentLine=51707921;
 //BA.debugLineNum = 51707921;BA.debugLine="lbl_box_title.Text=\"ویرایش تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش تردد"));
RDebugUtils.currentLine=51707922;
 //BA.debugLineNum = 51707922;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51707923;
 //BA.debugLineNum = 51707923;BA.debugLine="lbl_ezaf_taradod.Visible=False";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=51707924;
 //BA.debugLineNum = 51707924;BA.debugLine="Else if (TabHost1.CurrentTab=3)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==3)) { 
RDebugUtils.currentLine=51707925;
 //BA.debugLineNum = 51707925;BA.debugLine="pan_add_mamoriat_Click";
_pan_add_mamoriat_click();
RDebugUtils.currentLine=51707926;
 //BA.debugLineNum = 51707926;BA.debugLine="lbl_box_title.Text=\"ویرایش ماموریت\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش ماموریت"));
RDebugUtils.currentLine=51707927;
 //BA.debugLineNum = 51707927;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51707928;
 //BA.debugLineNum = 51707928;BA.debugLine="lbl_ezaf_taradod.Visible=False";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }}}}
;
RDebugUtils.currentLine=51707930;
 //BA.debugLineNum = 51707930;BA.debugLine="is_for_edit=True";
_is_for_edit = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=51707931;
 //BA.debugLineNum = 51707931;BA.debugLine="get_dataEdit_byId(current_id_edit)";
_get_dataedit_byid(_current_id_edit);
RDebugUtils.currentLine=51707941;
 //BA.debugLineNum = 51707941;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=51707944;
 //BA.debugLineNum = 51707944;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_ezafekari_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_ezafekari_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_ezafekari_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_temp_time1 = null;
RDebugUtils.currentLine=48365568;
 //BA.debugLineNum = 48365568;BA.debugLine="Private Sub pan_add_ezafekari_Click";
RDebugUtils.currentLine=48365569;
 //BA.debugLineNum = 48365569;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=48365570;
 //BA.debugLineNum = 48365570;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48365572;
 //BA.debugLineNum = 48365572;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48365573;
 //BA.debugLineNum = 48365573;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48365575;
 //BA.debugLineNum = 48365575;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48365576;
 //BA.debugLineNum = 48365576;BA.debugLine="lbl_box_title.Text=\"ثبت اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت اضافه کاری"));
RDebugUtils.currentLine=48365577;
 //BA.debugLineNum = 48365577;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
RDebugUtils.currentLine=48365578;
 //BA.debugLineNum = 48365578;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
RDebugUtils.currentLine=48365579;
 //BA.debugLineNum = 48365579;BA.debugLine="index_box=1";
_index_box = (int) (1);
RDebugUtils.currentLine=48365580;
 //BA.debugLineNum = 48365580;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=48365581;
 //BA.debugLineNum = 48365581;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=48365582;
 //BA.debugLineNum = 48365582;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48365583;
 //BA.debugLineNum = 48365583;BA.debugLine="lbl_ezaf_taradod.Text=\"فوق العاده (جمعه کاری)\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("فوق العاده (جمعه کاری)"));
RDebugUtils.currentLine=48365584;
 //BA.debugLineNum = 48365584;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=48365585;
 //BA.debugLineNum = 48365585;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48365586;
 //BA.debugLineNum = 48365586;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48365587;
 //BA.debugLineNum = 48365587;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48365593;
 //BA.debugLineNum = 48365593;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
RDebugUtils.currentLine=48365594;
 //BA.debugLineNum = 48365594;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
RDebugUtils.currentLine=48365595;
 //BA.debugLineNum = 48365595;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=48365596;
 //BA.debugLineNum = 48365596;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
RDebugUtils.currentLine=48365599;
 //BA.debugLineNum = 48365599;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=48365600;
 //BA.debugLineNum = 48365600;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=48365605;
 //BA.debugLineNum = 48365605;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_time1.txt\")";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time1.txt"))) { 
RDebugUtils.currentLine=48365606;
 //BA.debugLineNum = 48365606;BA.debugLine="Dim ls_temp_time1 As List";
_ls_temp_time1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=48365607;
 //BA.debugLineNum = 48365607;BA.debugLine="ls_temp_time1.Initialize";
_ls_temp_time1.Initialize();
RDebugUtils.currentLine=48365608;
 //BA.debugLineNum = 48365608;BA.debugLine="ls_temp_time1=File.ReadList(File.DirInternal,\"te";
_ls_temp_time1 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time1.txt");
RDebugUtils.currentLine=48365610;
 //BA.debugLineNum = 48365610;BA.debugLine="lbl_tim1.Text=ls_temp_time1.Get(0)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_temp_time1.Get((int) (0))));
RDebugUtils.currentLine=48365611;
 //BA.debugLineNum = 48365611;BA.debugLine="lbl_tim2.Text=ls_temp_time1.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_temp_time1.Get((int) (1))));
RDebugUtils.currentLine=48365612;
 //BA.debugLineNum = 48365612;BA.debugLine="time_show";
_time_show();
 }else {
RDebugUtils.currentLine=48365614;
 //BA.debugLineNum = 48365614;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=48365615;
 //BA.debugLineNum = 48365615;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=48365619;
 //BA.debugLineNum = 48365619;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_morakhasi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_morakhasi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_morakhasi_click", null));}
RDebugUtils.currentLine=48168960;
 //BA.debugLineNum = 48168960;BA.debugLine="Private Sub pan_add_morakhasi_Click";
RDebugUtils.currentLine=48168961;
 //BA.debugLineNum = 48168961;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=48168962;
 //BA.debugLineNum = 48168962;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48168964;
 //BA.debugLineNum = 48168964;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48168965;
 //BA.debugLineNum = 48168965;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48168967;
 //BA.debugLineNum = 48168967;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48168968;
 //BA.debugLineNum = 48168968;BA.debugLine="lbl_box_title.Text=\"ثبت مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت مرخصی"));
RDebugUtils.currentLine=48168969;
 //BA.debugLineNum = 48168969;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
RDebugUtils.currentLine=48168970;
 //BA.debugLineNum = 48168970;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
RDebugUtils.currentLine=48168971;
 //BA.debugLineNum = 48168971;BA.debugLine="index_box=2";
_index_box = (int) (2);
RDebugUtils.currentLine=48168972;
 //BA.debugLineNum = 48168972;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=48168973;
 //BA.debugLineNum = 48168973;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=48168974;
 //BA.debugLineNum = 48168974;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
RDebugUtils.currentLine=48168975;
 //BA.debugLineNum = 48168975;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48168976;
 //BA.debugLineNum = 48168976;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
RDebugUtils.currentLine=48168977;
 //BA.debugLineNum = 48168977;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Red";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=48168978;
 //BA.debugLineNum = 48168978;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48168979;
 //BA.debugLineNum = 48168979;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48168983;
 //BA.debugLineNum = 48168983;BA.debugLine="rsPOP_noe.Initialize(\"rsPOP_noe\",lbl_ezaf_taradod";
mostCurrent._rspop_noe.Initialize(mostCurrent.activityBA,"rsPOP_noe",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_ezaf_taradod.getObject())));
RDebugUtils.currentLine=48168985;
 //BA.debugLineNum = 48168985;BA.debugLine="rsPOP_noe.AddMenuItem(0,0,\"استحقاقی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (0),(int) (0),"استحقاقی");
RDebugUtils.currentLine=48168986;
 //BA.debugLineNum = 48168986;BA.debugLine="rsPOP_noe.AddMenuItem(1,1,\"استعلاجی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (1),(int) (1),"استعلاجی");
RDebugUtils.currentLine=48168987;
 //BA.debugLineNum = 48168987;BA.debugLine="rsPOP_noe.AddMenuItem(2,2,\"سایر (با حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (2),(int) (2),"سایر (با حقوق)");
RDebugUtils.currentLine=48168988;
 //BA.debugLineNum = 48168988;BA.debugLine="rsPOP_noe.AddMenuItem(3,3,\"سایر (بدون حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (3),(int) (3),"سایر (بدون حقوق)");
RDebugUtils.currentLine=48168993;
 //BA.debugLineNum = 48168993;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
RDebugUtils.currentLine=48168994;
 //BA.debugLineNum = 48168994;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
RDebugUtils.currentLine=48168995;
 //BA.debugLineNum = 48168995;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=48168996;
 //BA.debugLineNum = 48168996;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
RDebugUtils.currentLine=48168999;
 //BA.debugLineNum = 48168999;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=48169000;
 //BA.debugLineNum = 48169000;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=48169002;
 //BA.debugLineNum = 48169002;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=48169003;
 //BA.debugLineNum = 48169003;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=48169007;
 //BA.debugLineNum = 48169007;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_taradod_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_taradod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_taradod_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_temp_time2 = null;
RDebugUtils.currentLine=48431104;
 //BA.debugLineNum = 48431104;BA.debugLine="Private Sub pan_add_taradod_Click";
RDebugUtils.currentLine=48431105;
 //BA.debugLineNum = 48431105;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=48431106;
 //BA.debugLineNum = 48431106;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48431108;
 //BA.debugLineNum = 48431108;BA.debugLine="radio_ez_adi.Visible=True";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48431109;
 //BA.debugLineNum = 48431109;BA.debugLine="radio_ez_fog.Visible=True";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48431110;
 //BA.debugLineNum = 48431110;BA.debugLine="radio_ez_adi.Checked=True";
mostCurrent._radio_ez_adi.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48431111;
 //BA.debugLineNum = 48431111;BA.debugLine="radio_ez_fog.Checked=False";
mostCurrent._radio_ez_fog.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48431113;
 //BA.debugLineNum = 48431113;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48431114;
 //BA.debugLineNum = 48431114;BA.debugLine="lbl_box_title.Text=\"ثبت تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت تردد"));
RDebugUtils.currentLine=48431115;
 //BA.debugLineNum = 48431115;BA.debugLine="lbl_time_as.Text=\"ورود :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("ورود :"));
RDebugUtils.currentLine=48431116;
 //BA.debugLineNum = 48431116;BA.debugLine="lbl_time_ta.Text=\"خروج :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("خروج :"));
RDebugUtils.currentLine=48431117;
 //BA.debugLineNum = 48431117;BA.debugLine="index_box=3";
_index_box = (int) (3);
RDebugUtils.currentLine=48431118;
 //BA.debugLineNum = 48431118;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=48431119;
 //BA.debugLineNum = 48431119;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=48431120;
 //BA.debugLineNum = 48431120;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48431121;
 //BA.debugLineNum = 48431121;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=48431122;
 //BA.debugLineNum = 48431122;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=48431124;
 //BA.debugLineNum = 48431124;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48431125;
 //BA.debugLineNum = 48431125;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48431126;
 //BA.debugLineNum = 48431126;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48431128;
 //BA.debugLineNum = 48431128;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
RDebugUtils.currentLine=48431129;
 //BA.debugLineNum = 48431129;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
RDebugUtils.currentLine=48431130;
 //BA.debugLineNum = 48431130;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=48431131;
 //BA.debugLineNum = 48431131;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
RDebugUtils.currentLine=48431134;
 //BA.debugLineNum = 48431134;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=48431135;
 //BA.debugLineNum = 48431135;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=48431139;
 //BA.debugLineNum = 48431139;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_time2.txt\")";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time2.txt"))) { 
RDebugUtils.currentLine=48431140;
 //BA.debugLineNum = 48431140;BA.debugLine="Dim ls_temp_time2 As List";
_ls_temp_time2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=48431141;
 //BA.debugLineNum = 48431141;BA.debugLine="ls_temp_time2.Initialize";
_ls_temp_time2.Initialize();
RDebugUtils.currentLine=48431142;
 //BA.debugLineNum = 48431142;BA.debugLine="ls_temp_time2=File.ReadList(File.DirInternal,\"te";
_ls_temp_time2 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time2.txt");
RDebugUtils.currentLine=48431144;
 //BA.debugLineNum = 48431144;BA.debugLine="lbl_tim1.Text=ls_temp_time2.Get(0)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_temp_time2.Get((int) (0))));
RDebugUtils.currentLine=48431145;
 //BA.debugLineNum = 48431145;BA.debugLine="lbl_tim2.Text=ls_temp_time2.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_temp_time2.Get((int) (1))));
RDebugUtils.currentLine=48431146;
 //BA.debugLineNum = 48431146;BA.debugLine="time_show";
_time_show();
 }else {
RDebugUtils.currentLine=48431148;
 //BA.debugLineNum = 48431148;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=48431149;
 //BA.debugLineNum = 48431149;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=48431153;
 //BA.debugLineNum = 48431153;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_mamoriat_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_mamoriat_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_mamoriat_click", null));}
RDebugUtils.currentLine=48496640;
 //BA.debugLineNum = 48496640;BA.debugLine="Private Sub pan_add_mamoriat_Click";
RDebugUtils.currentLine=48496641;
 //BA.debugLineNum = 48496641;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=48496642;
 //BA.debugLineNum = 48496642;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48496643;
 //BA.debugLineNum = 48496643;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48496645;
 //BA.debugLineNum = 48496645;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48496646;
 //BA.debugLineNum = 48496646;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48496648;
 //BA.debugLineNum = 48496648;BA.debugLine="lbl_box_title.Text=\"ثبت ماموریت\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت ماموریت"));
RDebugUtils.currentLine=48496649;
 //BA.debugLineNum = 48496649;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
RDebugUtils.currentLine=48496650;
 //BA.debugLineNum = 48496650;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
RDebugUtils.currentLine=48496651;
 //BA.debugLineNum = 48496651;BA.debugLine="index_box=5";
_index_box = (int) (5);
RDebugUtils.currentLine=48496652;
 //BA.debugLineNum = 48496652;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=48496653;
 //BA.debugLineNum = 48496653;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=48496654;
 //BA.debugLineNum = 48496654;BA.debugLine="lbl_ezaf_taradod.Visible=False";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48496657;
 //BA.debugLineNum = 48496657;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48496658;
 //BA.debugLineNum = 48496658;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48496659;
 //BA.debugLineNum = 48496659;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48496665;
 //BA.debugLineNum = 48496665;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
RDebugUtils.currentLine=48496666;
 //BA.debugLineNum = 48496666;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
RDebugUtils.currentLine=48496667;
 //BA.debugLineNum = 48496667;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=48496668;
 //BA.debugLineNum = 48496668;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
RDebugUtils.currentLine=48496671;
 //BA.debugLineNum = 48496671;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=48496672;
 //BA.debugLineNum = 48496672;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=48496676;
 //BA.debugLineNum = 48496676;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=48496677;
 //BA.debugLineNum = 48496677;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
RDebugUtils.currentLine=48496679;
 //BA.debugLineNum = 48496679;BA.debugLine="End Sub";
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
String _date_vorod_0 = "";
String _date_khoroj_0 = "";
RDebugUtils.currentLine=49152000;
 //BA.debugLineNum = 49152000;BA.debugLine="Sub time_show";
RDebugUtils.currentLine=49152002;
 //BA.debugLineNum = 49152002;BA.debugLine="Try";
try {RDebugUtils.currentLine=49152005;
 //BA.debugLineNum = 49152005;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=49152006;
 //BA.debugLineNum = 49152006;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=49152007;
 //BA.debugLineNum = 49152007;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
RDebugUtils.currentLine=49152008;
 //BA.debugLineNum = 49152008;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
RDebugUtils.currentLine=49152010;
 //BA.debugLineNum = 49152010;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=49152011;
 //BA.debugLineNum = 49152011;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=49152012;
 //BA.debugLineNum = 49152012;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=49152013;
 //BA.debugLineNum = 49152013;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=49152016;
 //BA.debugLineNum = 49152016;BA.debugLine="pik_moon1.Tag=myfunc.convert_adad(pik_moon1.Tag)";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))));
RDebugUtils.currentLine=49152021;
 //BA.debugLineNum = 49152021;BA.debugLine="date1=lbl_date1.Text";
mostCurrent._date1 = mostCurrent._lbl_date1.getText();
RDebugUtils.currentLine=49152022;
 //BA.debugLineNum = 49152022;BA.debugLine="date2=lbl_date2.Text";
mostCurrent._date2 = mostCurrent._lbl_date2.getText();
RDebugUtils.currentLine=49152023;
 //BA.debugLineNum = 49152023;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
RDebugUtils.currentLine=49152024;
 //BA.debugLineNum = 49152024;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
RDebugUtils.currentLine=49152028;
 //BA.debugLineNum = 49152028;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_dat";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=49152029;
 //BA.debugLineNum = 49152029;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_dat";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=49152032;
 //BA.debugLineNum = 49152032;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=49152033;
 //BA.debugLineNum = 49152033;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=49152036;
 //BA.debugLineNum = 49152036;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
RDebugUtils.currentLine=49152037;
 //BA.debugLineNum = 49152037;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
RDebugUtils.currentLine=49152039;
 //BA.debugLineNum = 49152039;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date_";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=49152040;
 //BA.debugLineNum = 49152040;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date_";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=49152042;
 //BA.debugLineNum = 49152042;BA.debugLine="time_end2=lbl_tim2.Text&\":00\"";
_time_end2 = mostCurrent._lbl_tim2.getText()+":00";
RDebugUtils.currentLine=49152043;
 //BA.debugLineNum = 49152043;BA.debugLine="time_end1=lbl_tim1.Text&\":00\"";
_time_end1 = mostCurrent._lbl_tim1.getText()+":00";
RDebugUtils.currentLine=49152045;
 //BA.debugLineNum = 49152045;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
RDebugUtils.currentLine=49152046;
 //BA.debugLineNum = 49152046;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
RDebugUtils.currentLine=49152047;
 //BA.debugLineNum = 49152047;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
RDebugUtils.currentLine=49152048;
 //BA.debugLineNum = 49152048;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
RDebugUtils.currentLine=49152052;
 //BA.debugLineNum = 49152052;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
RDebugUtils.currentLine=49152053;
 //BA.debugLineNum = 49152053;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
RDebugUtils.currentLine=49152056;
 //BA.debugLineNum = 49152056;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=49152057;
 //BA.debugLineNum = 49152057;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
RDebugUtils.currentLine=49152059;
 //BA.debugLineNum = 49152059;BA.debugLine="If (period_between.Years<>0)Then";
if ((_period_between.Years!=0)) { 
RDebugUtils.currentLine=49152060;
 //BA.debugLineNum = 49152060;BA.debugLine="str_show.Append(period_between.Years&\" سال \").A";
_str_show.Append(BA.NumberToString(_period_between.Years)+" سال ").Append(" و ");
 };
RDebugUtils.currentLine=49152062;
 //BA.debugLineNum = 49152062;BA.debugLine="If (period_between.Months<>0)Then";
if ((_period_between.Months!=0)) { 
RDebugUtils.currentLine=49152063;
 //BA.debugLineNum = 49152063;BA.debugLine="str_show.Append(period_between.Months&\" ماه \").";
_str_show.Append(BA.NumberToString(_period_between.Months)+" ماه ").Append(" و ");
 };
RDebugUtils.currentLine=49152065;
 //BA.debugLineNum = 49152065;BA.debugLine="If (period_between.Days<>0)Then";
if ((_period_between.Days!=0)) { 
RDebugUtils.currentLine=49152066;
 //BA.debugLineNum = 49152066;BA.debugLine="str_show.Append(period_between.Days&\" روز \").Ap";
_str_show.Append(BA.NumberToString(_period_between.Days)+" روز ").Append(" و ");
 };
RDebugUtils.currentLine=49152069;
 //BA.debugLineNum = 49152069;BA.debugLine="str_show.Append(period_between.Hours&\" ساعت \").A";
_str_show.Append(BA.NumberToString(_period_between.Hours)+" ساعت ").Append(" و ");
RDebugUtils.currentLine=49152070;
 //BA.debugLineNum = 49152070;BA.debugLine="str_show.Append(period_between.Minutes&\" دقیقه \"";
_str_show.Append(BA.NumberToString(_period_between.Minutes)+" دقیقه ");
RDebugUtils.currentLine=49152073;
 //BA.debugLineNum = 49152073;BA.debugLine="year_bt=period_between.Years";
_year_bt = _period_between.Years;
RDebugUtils.currentLine=49152074;
 //BA.debugLineNum = 49152074;BA.debugLine="moon_bt=period_between.Months";
_moon_bt = _period_between.Months;
RDebugUtils.currentLine=49152075;
 //BA.debugLineNum = 49152075;BA.debugLine="day_bt=period_between.Days";
_day_bt = _period_between.Days;
RDebugUtils.currentLine=49152076;
 //BA.debugLineNum = 49152076;BA.debugLine="hour_bt=period_between.Hours";
_hour_bt = _period_between.Hours;
RDebugUtils.currentLine=49152077;
 //BA.debugLineNum = 49152077;BA.debugLine="min_bt=period_between.Minutes";
_min_bt = _period_between.Minutes;
RDebugUtils.currentLine=49152080;
 //BA.debugLineNum = 49152080;BA.debugLine="lbl_time_show.Text=str_show";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(_str_show.getObject()));
RDebugUtils.currentLine=49152081;
 //BA.debugLineNum = 49152081;BA.debugLine="If(index_box=3)Then";
if ((_index_box==3)) { 
RDebugUtils.currentLine=49152085;
 //BA.debugLineNum = 49152085;BA.debugLine="tim_min=(day_bt*24*60)+(hour_bt*60)+min_bt";
_tim_min = (int) ((_day_bt*24*60)+(_hour_bt*60)+_min_bt);
RDebugUtils.currentLine=49152088;
 //BA.debugLineNum = 49152088;BA.debugLine="If(tim_min>saat_kar_min) Then";
if ((_tim_min>_saat_kar_min)) { 
RDebugUtils.currentLine=49152092;
 //BA.debugLineNum = 49152092;BA.debugLine="Dim date_vorod_0 As String=lbl_date1.Text";
_date_vorod_0 = mostCurrent._lbl_date1.getText();
RDebugUtils.currentLine=49152093;
 //BA.debugLineNum = 49152093;BA.debugLine="Dim date_khoroj_0 As String=lbl_date2.Text";
_date_khoroj_0 = mostCurrent._lbl_date2.getText();
RDebugUtils.currentLine=49152115;
 //BA.debugLineNum = 49152115;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=49152116;
 //BA.debugLineNum = 49152116;BA.debugLine="radio_ez_adi.Enabled=True";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=49152117;
 //BA.debugLineNum = 49152117;BA.debugLine="radio_ez_fog.Enabled=True";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=49152123;
 //BA.debugLineNum = 49152123;BA.debugLine="lbl_ezaf_taradod.Text=\"افزودن به اضافه کاری \"&";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("افزودن به اضافه کاری "+BA.ObjectToString(((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (0)))))+" ساعت و "+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min))).Get((int) (1)))+" دقیقه "));
 }else {
RDebugUtils.currentLine=49152126;
 //BA.debugLineNum = 49152126;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=49152127;
 //BA.debugLineNum = 49152127;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=49152128;
 //BA.debugLineNum = 49152128;BA.debugLine="radio_ez_adi.Enabled=False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=49152129;
 //BA.debugLineNum = 49152129;BA.debugLine="radio_ez_fog.Enabled=False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 } 
       catch (Exception e67) {
			processBA.setLastException(e67);RDebugUtils.currentLine=49152137;
 //BA.debugLineNum = 49152137;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=49152147;
 //BA.debugLineNum = 49152147;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_ezaf_taradod_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_ezaf_taradod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_ezaf_taradod_click", null));}
RDebugUtils.currentLine=48234496;
 //BA.debugLineNum = 48234496;BA.debugLine="Private Sub lbl_ezaf_taradod_Click";
RDebugUtils.currentLine=48234497;
 //BA.debugLineNum = 48234497;BA.debugLine="If(index_box=2)Then";
if ((_index_box==2)) { 
RDebugUtils.currentLine=48234498;
 //BA.debugLineNum = 48234498;BA.debugLine="rsPOP_noe.Show";
mostCurrent._rspop_noe.Show();
 };
RDebugUtils.currentLine=48234500;
 //BA.debugLineNum = 48234500;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_ft_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_ft_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_ft_click", null));}
RDebugUtils.currentLine=54001664;
 //BA.debugLineNum = 54001664;BA.debugLine="Private Sub lbl_help_FT_Click";
RDebugUtils.currentLine=54001665;
 //BA.debugLineNum = 54001665;BA.debugLine="myfunc.help_man(\"راهنما\",\"برای ثبت ورود یا خروج ا";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","برای ثبت ورود یا خروج انگشت خود را در قسمت مشخص شده 3 ثانیه نگه دارید.");
RDebugUtils.currentLine=54001666;
 //BA.debugLineNum = 54001666;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_piker_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_piker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_piker_click", null));}
RDebugUtils.currentLine=52494336;
 //BA.debugLineNum = 52494336;BA.debugLine="Private Sub lbl_help_piker_Click";
RDebugUtils.currentLine=52494338;
 //BA.debugLineNum = 52494338;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
RDebugUtils.currentLine=52494340;
 //BA.debugLineNum = 52494340;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
RDebugUtils.currentLine=52494341;
 //BA.debugLineNum = 52494341;BA.debugLine="lbl_close_help.Visible=False";
mostCurrent._lbl_close_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=52494342;
 //BA.debugLineNum = 52494342;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=52494344;
 //BA.debugLineNum = 52494344;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help2_click", null));}
RDebugUtils.currentLine=51970048;
 //BA.debugLineNum = 51970048;BA.debugLine="Private Sub lbl_help2_Click";
RDebugUtils.currentLine=51970049;
 //BA.debugLineNum = 51970049;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=51970050;
 //BA.debugLineNum = 51970050;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_khoroj_ft_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_khoroj_ft_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_khoroj_ft_click", null));}
RDebugUtils.currentLine=53542912;
 //BA.debugLineNum = 53542912;BA.debugLine="Private Sub lbl_khoroj_FT_Click";
RDebugUtils.currentLine=53542913;
 //BA.debugLineNum = 53542913;BA.debugLine="ToastMessageShow(\"انگشت خود را 3 ثانیه نگه دارید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("انگشت خود را 3 ثانیه نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53542914;
 //BA.debugLineNum = 53542914;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_khoroj_ft_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_khoroj_ft_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_khoroj_ft_longclick", null));}
RDebugUtils.currentLine=53673984;
 //BA.debugLineNum = 53673984;BA.debugLine="Private Sub lbl_khoroj_FT_LongClick";
RDebugUtils.currentLine=53673985;
 //BA.debugLineNum = 53673985;BA.debugLine="If(code_fast_taradod=10 Or code_fast_taradod=20)T";
if ((_code_fast_taradod==10 || _code_fast_taradod==20)) { 
RDebugUtils.currentLine=53673986;
 //BA.debugLineNum = 53673986;BA.debugLine="index_box=4";
_index_box = (int) (4);
RDebugUtils.currentLine=53673987;
 //BA.debugLineNum = 53673987;BA.debugLine="lbl_tim_khoroj_FT.Text=DateTime.Time(DateTime.No";
mostCurrent._lbl_tim_khoroj_ft.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
RDebugUtils.currentLine=53673988;
 //BA.debugLineNum = 53673988;BA.debugLine="add_taradod_fast";
_add_taradod_fast();
RDebugUtils.currentLine=53673989;
 //BA.debugLineNum = 53673989;BA.debugLine="code_fast_taradod=11";
_code_fast_taradod = (int) (11);
 }else 
{RDebugUtils.currentLine=53673990;
 //BA.debugLineNum = 53673990;BA.debugLine="Else If(code_fast_taradod=0)Then";
if ((_code_fast_taradod==0)) { 
RDebugUtils.currentLine=53673991;
 //BA.debugLineNum = 53673991;BA.debugLine="ToastMessageShow(\"تردد امروز دستی ثبت شده است\",F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تردد امروز دستی ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=53673992;
 //BA.debugLineNum = 53673992;BA.debugLine="Else If(code_fast_taradod=1)Then";
if ((_code_fast_taradod==1)) { 
RDebugUtils.currentLine=53673993;
 //BA.debugLineNum = 53673993;BA.debugLine="ToastMessageShow(\"ابتدا قسمت ورود را بزنید\",Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ابتدا قسمت ورود را بزنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=53673995;
 //BA.debugLineNum = 53673995;BA.debugLine="ToastMessageShow(\"زمان خروج ثبت شده است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("زمان خروج ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }}}
;
RDebugUtils.currentLine=53673997;
 //BA.debugLineNum = 53673997;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_lite_menu_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_lite_menu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_lite_menu_click", null));}
RDebugUtils.currentLine=52887552;
 //BA.debugLineNum = 52887552;BA.debugLine="Private Sub lbl_lite_menu_Click";
RDebugUtils.currentLine=52887553;
 //BA.debugLineNum = 52887553;BA.debugLine="pan_all_liteMenu.Visible=True";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=52887554;
 //BA.debugLineNum = 52887554;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_notefi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_notefi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_notefi_click", null));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _html = null;
int _i = 0;
RDebugUtils.currentLine=46071808;
 //BA.debugLineNum = 46071808;BA.debugLine="Private Sub lbl_notefi_Click";
RDebugUtils.currentLine=46071809;
 //BA.debugLineNum = 46071809;BA.debugLine="lbl_title_msgPan.Text=\"پیام ها\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام ها"));
RDebugUtils.currentLine=46071810;
 //BA.debugLineNum = 46071810;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=46071811;
 //BA.debugLineNum = 46071811;BA.debugLine="pan_notif.Top=10%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=46071812;
 //BA.debugLineNum = 46071812;BA.debugLine="pan_notif.Height=70%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
RDebugUtils.currentLine=46071813;
 //BA.debugLineNum = 46071813;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
RDebugUtils.currentLine=46071816;
 //BA.debugLineNum = 46071816;BA.debugLine="Dim html As StringBuilder";
_html = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=46071817;
 //BA.debugLineNum = 46071817;BA.debugLine="html.Initialize";
_html.Initialize();
RDebugUtils.currentLine=46071819;
 //BA.debugLineNum = 46071819;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1"))) { 
RDebugUtils.currentLine=46071821;
 //BA.debugLineNum = 46071821;BA.debugLine="html.Append(\"<!DOCTYPE html><html><meta charset=";
_html.Append("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'>");
RDebugUtils.currentLine=46071822;
 //BA.debugLineNum = 46071822;BA.debugLine="For i = ls1.Size-1 To 0 Step -1";
{
final int step10 = -1;
final int limit10 = (int) (0);
_i = (int) (mostCurrent._ls1.getSize()-1) ;
for (;_i >= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=46071823;
 //BA.debugLineNum = 46071823;BA.debugLine="html.Append(\"<div style='background-color: #99f";
_html.Append("<div style='background-color: #99ffff; font-size: 13px;'>"+"کد پیام : "+BA.ObjectToString(mostCurrent._ls1.Get(_i))+" - مورخ : "+BA.ObjectToString(mostCurrent._ls3.Get(_i))+"</div><div style='background-color: #e6ffff; font-size: 16px;'><br>"+BA.ObjectToString(mostCurrent._ls2.Get(_i))).Append("<br></div><br>");
 }
};
RDebugUtils.currentLine=46071825;
 //BA.debugLineNum = 46071825;BA.debugLine="html.Append(\"</body></html>\")";
_html.Append("</body></html>");
RDebugUtils.currentLine=46071828;
 //BA.debugLineNum = 46071828;BA.debugLine="web_msg_show.LoadHtml(html.ToString)";
mostCurrent._web_msg_show.LoadHtml(_html.ToString());
 }else {
RDebugUtils.currentLine=46071831;
 //BA.debugLineNum = 46071831;BA.debugLine="web_msg_show.LoadHtml(\"<html><body dir='rtl'>لیس";
mostCurrent._web_msg_show.LoadHtml("<html><body dir='rtl'>لیست پیام خالی ... </body></html>");
 };
RDebugUtils.currentLine=46071835;
 //BA.debugLineNum = 46071835;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_remove_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_remove_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
RDebugUtils.currentLine=51838976;
 //BA.debugLineNum = 51838976;BA.debugLine="Private Sub lbl_remove_from_list_Click";
RDebugUtils.currentLine=51838978;
 //BA.debugLineNum = 51838978;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=51838979;
 //BA.debugLineNum = 51838979;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=51838981;
 //BA.debugLineNum = 51838981;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
RDebugUtils.currentLine=51838982;
 //BA.debugLineNum = 51838982;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=51838983;
 //BA.debugLineNum = 51838983;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=51838984;
 //BA.debugLineNum = 51838984;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=51838986;
 //BA.debugLineNum = 51838986;BA.debugLine="If (dbCode.delete_ezafekari(b.Tag))Then";
if ((mostCurrent._dbcode._delete_ezafekari /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=51838987;
 //BA.debugLineNum = 51838987;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51838989;
 //BA.debugLineNum = 51838989;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
RDebugUtils.currentLine=51838992;
 //BA.debugLineNum = 51838992;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else 
{RDebugUtils.currentLine=51838995;
 //BA.debugLineNum = 51838995;BA.debugLine="Else if (TabHost1.CurrentTab=1)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==1)) { 
RDebugUtils.currentLine=51838997;
 //BA.debugLineNum = 51838997;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=51838998;
 //BA.debugLineNum = 51838998;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=51838999;
 //BA.debugLineNum = 51838999;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=51839001;
 //BA.debugLineNum = 51839001;BA.debugLine="If (dbCode.delete_morakhasi(b.Tag))Then";
if ((mostCurrent._dbcode._delete_morakhasi /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=51839002;
 //BA.debugLineNum = 51839002;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51839003;
 //BA.debugLineNum = 51839003;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
RDebugUtils.currentLine=51839004;
 //BA.debugLineNum = 51839004;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else 
{RDebugUtils.currentLine=51839008;
 //BA.debugLineNum = 51839008;BA.debugLine="Else if (TabHost1.CurrentTab=2)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==2)) { 
RDebugUtils.currentLine=51839009;
 //BA.debugLineNum = 51839009;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=51839010;
 //BA.debugLineNum = 51839010;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=51839011;
 //BA.debugLineNum = 51839011;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=51839013;
 //BA.debugLineNum = 51839013;BA.debugLine="If (dbCode.delete_taradod(b.Tag))Then";
if ((mostCurrent._dbcode._delete_taradod /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=51839014;
 //BA.debugLineNum = 51839014;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51839016;
 //BA.debugLineNum = 51839016;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
RDebugUtils.currentLine=51839017;
 //BA.debugLineNum = 51839017;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else 
{RDebugUtils.currentLine=51839021;
 //BA.debugLineNum = 51839021;BA.debugLine="Else if (TabHost1.CurrentTab=3)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==3)) { 
RDebugUtils.currentLine=51839022;
 //BA.debugLineNum = 51839022;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=51839023;
 //BA.debugLineNum = 51839023;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=51839024;
 //BA.debugLineNum = 51839024;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=51839026;
 //BA.debugLineNum = 51839026;BA.debugLine="If (dbCode.delete_mamoriat(b.Tag))Then";
if ((mostCurrent._dbcode._delete_mamoriat /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=51839027;
 //BA.debugLineNum = 51839027;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51839029;
 //BA.debugLineNum = 51839029;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
RDebugUtils.currentLine=51839030;
 //BA.debugLineNum = 51839030;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }}}}
;
RDebugUtils.currentLine=51839040;
 //BA.debugLineNum = 51839040;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_remove_from_list2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_remove_from_list2_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
RDebugUtils.currentLine=51904512;
 //BA.debugLineNum = 51904512;BA.debugLine="Private Sub lbl_remove_from_list2_Click";
RDebugUtils.currentLine=51904513;
 //BA.debugLineNum = 51904513;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=51904514;
 //BA.debugLineNum = 51904514;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=51904517;
 //BA.debugLineNum = 51904517;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=51904518;
 //BA.debugLineNum = 51904518;BA.debugLine="result = Msgbox2(\"آیا این گزارش حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این گزارش حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=51904519;
 //BA.debugLineNum = 51904519;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=51904521;
 //BA.debugLineNum = 51904521;BA.debugLine="If (dbCode.delete_gozaresh(b.tag))Then";
if ((mostCurrent._dbcode._delete_gozaresh /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=51904522;
 //BA.debugLineNum = 51904522;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51904523;
 //BA.debugLineNum = 51904523;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedI";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
 };
 };
RDebugUtils.currentLine=51904528;
 //BA.debugLineNum = 51904528;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_box_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_box_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_box_click", null));}
RDebugUtils.currentLine=48693248;
 //BA.debugLineNum = 48693248;BA.debugLine="Private Sub lbl_save_box_Click";
RDebugUtils.currentLine=48693250;
 //BA.debugLineNum = 48693250;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=48693251;
 //BA.debugLineNum = 48693251;BA.debugLine="add_end";
_add_end();
RDebugUtils.currentLine=48693254;
 //BA.debugLineNum = 48693254;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_picker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_picker_click", null));}
String _value = "";
String _value1 = "";
String _value2 = "";
RDebugUtils.currentLine=50921472;
 //BA.debugLineNum = 50921472;BA.debugLine="Private Sub lbl_save_picker_Click";
RDebugUtils.currentLine=50921474;
 //BA.debugLineNum = 50921474;BA.debugLine="Dim value As String";
_value = "";
RDebugUtils.currentLine=50921475;
 //BA.debugLineNum = 50921475;BA.debugLine="value=pik_hour1.Text";
_value = mostCurrent._pik_hour1.getText();
RDebugUtils.currentLine=50921476;
 //BA.debugLineNum = 50921476;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(value)";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_value)))));
RDebugUtils.currentLine=50921479;
 //BA.debugLineNum = 50921479;BA.debugLine="Dim value1 As String";
_value1 = "";
RDebugUtils.currentLine=50921480;
 //BA.debugLineNum = 50921480;BA.debugLine="value1=pik_min1.Text";
_value1 = mostCurrent._pik_min1.getText();
RDebugUtils.currentLine=50921481;
 //BA.debugLineNum = 50921481;BA.debugLine="pik_min1.Text=myfunc.convert_adad(value1)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_value1)))));
RDebugUtils.currentLine=50921484;
 //BA.debugLineNum = 50921484;BA.debugLine="Dim value2 As String";
_value2 = "";
RDebugUtils.currentLine=50921485;
 //BA.debugLineNum = 50921485;BA.debugLine="value2=pik_day1.Text";
_value2 = mostCurrent._pik_day1.getText();
RDebugUtils.currentLine=50921486;
 //BA.debugLineNum = 50921486;BA.debugLine="pik_day1.Text=myfunc.convert_adad(value2)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_value2)))));
RDebugUtils.currentLine=50921487;
 //BA.debugLineNum = 50921487;BA.debugLine="pik_moon1.Tag=myfunc.convert_adad(pik_moon1.Tag)";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))));
RDebugUtils.currentLine=50921492;
 //BA.debugLineNum = 50921492;BA.debugLine="If(index_piker=1)Then  'date1";
if ((_index_piker==1)) { 
RDebugUtils.currentLine=50921494;
 //BA.debugLineNum = 50921494;BA.debugLine="lbl_tim1.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
RDebugUtils.currentLine=50921495;
 //BA.debugLineNum = 50921495;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
 }else 
{RDebugUtils.currentLine=50921497;
 //BA.debugLineNum = 50921497;BA.debugLine="Else If (index_piker=2)Then  'date2";
if ((_index_piker==2)) { 
RDebugUtils.currentLine=50921499;
 //BA.debugLineNum = 50921499;BA.debugLine="lbl_tim2.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
RDebugUtils.currentLine=50921500;
 //BA.debugLineNum = 50921500;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
 }}
;
RDebugUtils.currentLine=50921505;
 //BA.debugLineNum = 50921505;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=50921506;
 //BA.debugLineNum = 50921506;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=50921507;
 //BA.debugLineNum = 50921507;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_app_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_share_app_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_share_app_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _i = null;
RDebugUtils.currentLine=54198272;
 //BA.debugLineNum = 54198272;BA.debugLine="Private Sub lbl_share_app_Click";
RDebugUtils.currentLine=54198273;
 //BA.debugLineNum = 54198273;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=54198274;
 //BA.debugLineNum = 54198274;BA.debugLine="i.Initialize(i.ACTION_SEND, \"\")";
_i.Initialize(_i.ACTION_SEND,"");
RDebugUtils.currentLine=54198275;
 //BA.debugLineNum = 54198275;BA.debugLine="i.SetType(\"text/plain\")";
_i.SetType("text/plain");
RDebugUtils.currentLine=54198276;
 //BA.debugLineNum = 54198276;BA.debugLine="i.PutExtra(\"android.intent.extra.TEXT\", \"https://";
_i.PutExtra("android.intent.extra.TEXT",(Object)("https://cafebazaar.ir/app/ir.taravatgroup.ezafekari2"));
RDebugUtils.currentLine=54198277;
 //BA.debugLineNum = 54198277;BA.debugLine="i.WrapAsIntentChooser(\"انتخاب کنید\")";
_i.WrapAsIntentChooser("انتخاب کنید");
RDebugUtils.currentLine=54198278;
 //BA.debugLineNum = 54198278;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_i.getObject()));
RDebugUtils.currentLine=54198279;
 //BA.debugLineNum = 54198279;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
RDebugUtils.currentLine=54198280;
 //BA.debugLineNum = 54198280;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_later_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip_later_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip_later_click", null));}
RDebugUtils.currentLine=52232192;
 //BA.debugLineNum = 52232192;BA.debugLine="Private Sub lbl_vip_later_Click";
RDebugUtils.currentLine=52232193;
 //BA.debugLineNum = 52232193;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
RDebugUtils.currentLine=52232194;
 //BA.debugLineNum = 52232194;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_now_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip_now_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip_now_click", null));}
String _title = "";
String _matn = "";
int _result = 0;
RDebugUtils.currentLine=52297728;
 //BA.debugLineNum = 52297728;BA.debugLine="Private Sub lbl_vip_now_Click";
RDebugUtils.currentLine=52297729;
 //BA.debugLineNum = 52297729;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=52297731;
 //BA.debugLineNum = 52297731;BA.debugLine="Dim title , matn As String";
_title = "";
_matn = "";
RDebugUtils.currentLine=52297732;
 //BA.debugLineNum = 52297732;BA.debugLine="title=\" تبریک \"";
_title = " تبریک ";
RDebugUtils.currentLine=52297733;
 //BA.debugLineNum = 52297733;BA.debugLine="matn=\" شما صاحب نسخه طلایی و بدون محدودیت برنامه";
_matn = " شما صاحب نسخه طلایی و بدون محدودیت برنامه اضافه کاری من می باشید. ";
RDebugUtils.currentLine=52297735;
 //BA.debugLineNum = 52297735;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=52297736;
 //BA.debugLineNum = 52297736;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Lo";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"باشه","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"buy.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=52297737;
 //BA.debugLineNum = 52297737;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
 }else {
RDebugUtils.currentLine=52297742;
 //BA.debugLineNum = 52297742;BA.debugLine="kharid";
_kharid();
 };
RDebugUtils.currentLine=52297744;
 //BA.debugLineNum = 52297744;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip2_click", null));}
RDebugUtils.currentLine=52035584;
 //BA.debugLineNum = 52035584;BA.debugLine="Private Sub lbl_vip2_Click";
RDebugUtils.currentLine=52035585;
 //BA.debugLineNum = 52035585;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
RDebugUtils.currentLine=52035586;
 //BA.debugLineNum = 52035586;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vorod_ft_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vorod_ft_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vorod_ft_click", null));}
RDebugUtils.currentLine=53477376;
 //BA.debugLineNum = 53477376;BA.debugLine="Private Sub lbl_vorod_FT_Click";
RDebugUtils.currentLine=53477377;
 //BA.debugLineNum = 53477377;BA.debugLine="ToastMessageShow(\"انگشت خود را 3 ثانیه نگه دارید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("انگشت خود را 3 ثانیه نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53477378;
 //BA.debugLineNum = 53477378;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vorod_ft_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vorod_ft_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vorod_ft_longclick", null));}
RDebugUtils.currentLine=53608448;
 //BA.debugLineNum = 53608448;BA.debugLine="Private Sub lbl_vorod_FT_LongClick";
RDebugUtils.currentLine=53608450;
 //BA.debugLineNum = 53608450;BA.debugLine="If(code_fast_taradod=1)Then";
if ((_code_fast_taradod==1)) { 
RDebugUtils.currentLine=53608451;
 //BA.debugLineNum = 53608451;BA.debugLine="index_box=4";
_index_box = (int) (4);
RDebugUtils.currentLine=53608452;
 //BA.debugLineNum = 53608452;BA.debugLine="lbl_tim_vorod_FT.Text=DateTime.Time(DateTime.Now";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
RDebugUtils.currentLine=53608453;
 //BA.debugLineNum = 53608453;BA.debugLine="code_fast_taradod=10";
_code_fast_taradod = (int) (10);
RDebugUtils.currentLine=53608454;
 //BA.debugLineNum = 53608454;BA.debugLine="add_end";
_add_end();
 }else 
{RDebugUtils.currentLine=53608456;
 //BA.debugLineNum = 53608456;BA.debugLine="Else If(code_fast_taradod=0)Then";
if ((_code_fast_taradod==0)) { 
RDebugUtils.currentLine=53608457;
 //BA.debugLineNum = 53608457;BA.debugLine="ToastMessageShow(\" تردد امروز دستی ثبت شده است\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" تردد امروز دستی ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=53608459;
 //BA.debugLineNum = 53608459;BA.debugLine="ToastMessageShow(\"زمان ورود ثبت شده است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("زمان ورود ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }}
;
RDebugUtils.currentLine=53608462;
 //BA.debugLineNum = 53608462;BA.debugLine="End Sub";
return "";
}
public static int  _min_between_to_time(String _dat1,String _dat2,String _tim1,String _tim2) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "min_between_to_time", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "min_between_to_time", new Object[] {_dat1,_dat2,_tim1,_tim2}));}
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
RDebugUtils.currentLine=53805056;
 //BA.debugLineNum = 53805056;BA.debugLine="Sub min_between_to_time(dat1 As String,dat2 As Str";
RDebugUtils.currentLine=53805069;
 //BA.debugLineNum = 53805069;BA.debugLine="Try";
try {RDebugUtils.currentLine=53805071;
 //BA.debugLineNum = 53805071;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=53805072;
 //BA.debugLineNum = 53805072;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=53805073;
 //BA.debugLineNum = 53805073;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
RDebugUtils.currentLine=53805074;
 //BA.debugLineNum = 53805074;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
RDebugUtils.currentLine=53805076;
 //BA.debugLineNum = 53805076;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=53805077;
 //BA.debugLineNum = 53805077;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=53805078;
 //BA.debugLineNum = 53805078;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=53805079;
 //BA.debugLineNum = 53805079;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=53805088;
 //BA.debugLineNum = 53805088;BA.debugLine="date1=dat1";
mostCurrent._date1 = _dat1;
RDebugUtils.currentLine=53805089;
 //BA.debugLineNum = 53805089;BA.debugLine="date2=dat2";
mostCurrent._date2 = _dat2;
RDebugUtils.currentLine=53805090;
 //BA.debugLineNum = 53805090;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
RDebugUtils.currentLine=53805091;
 //BA.debugLineNum = 53805091;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
RDebugUtils.currentLine=53805095;
 //BA.debugLineNum = 53805095;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_da";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=53805096;
 //BA.debugLineNum = 53805096;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_da";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=53805099;
 //BA.debugLineNum = 53805099;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=53805100;
 //BA.debugLineNum = 53805100;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=53805103;
 //BA.debugLineNum = 53805103;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
RDebugUtils.currentLine=53805104;
 //BA.debugLineNum = 53805104;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
RDebugUtils.currentLine=53805106;
 //BA.debugLineNum = 53805106;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=53805107;
 //BA.debugLineNum = 53805107;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=53805109;
 //BA.debugLineNum = 53805109;BA.debugLine="time_end2=tim2&\":00\"";
_time_end2 = _tim2+":00";
RDebugUtils.currentLine=53805110;
 //BA.debugLineNum = 53805110;BA.debugLine="time_end1=tim1&\":00\"";
_time_end1 = _tim1+":00";
RDebugUtils.currentLine=53805112;
 //BA.debugLineNum = 53805112;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
RDebugUtils.currentLine=53805113;
 //BA.debugLineNum = 53805113;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
RDebugUtils.currentLine=53805114;
 //BA.debugLineNum = 53805114;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
RDebugUtils.currentLine=53805115;
 //BA.debugLineNum = 53805115;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
RDebugUtils.currentLine=53805119;
 //BA.debugLineNum = 53805119;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
RDebugUtils.currentLine=53805120;
 //BA.debugLineNum = 53805120;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
 } 
       catch (Exception e31) {
			processBA.setLastException(e31);RDebugUtils.currentLine=53805125;
 //BA.debugLineNum = 53805125;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=53805128;
 //BA.debugLineNum = 53805128;BA.debugLine="Return (period_between.Days*24*60)+(period_betwee";
if (true) return (int) ((_period_between.Days*24*60)+(_period_between.Hours*60)+_period_between.Minutes);
RDebugUtils.currentLine=53805129;
 //BA.debugLineNum = 53805129;BA.debugLine="End Sub";
return 0;
}
public static String  _pan_add_other_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_other_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_other_click", null));}
RDebugUtils.currentLine=50593792;
 //BA.debugLineNum = 50593792;BA.debugLine="Private Sub pan_add_other_Click";
RDebugUtils.currentLine=50593793;
 //BA.debugLineNum = 50593793;BA.debugLine="StartActivity(sabt2_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._sabt2_activity.getObject()));
RDebugUtils.currentLine=50593794;
 //BA.debugLineNum = 50593794;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_taradod_fast_click_org() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_taradod_fast_click_org", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_taradod_fast_click_org", null));}
RDebugUtils.currentLine=53280768;
 //BA.debugLineNum = 53280768;BA.debugLine="Private Sub pan_add_taradod_fast_Click_org";
RDebugUtils.currentLine=53280769;
 //BA.debugLineNum = 53280769;BA.debugLine="pan_all_FT.Visible=True";
mostCurrent._pan_all_ft.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=53280770;
 //BA.debugLineNum = 53280770;BA.debugLine="lbl_date_FT.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date_ft.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=53280771;
 //BA.debugLineNum = 53280771;BA.debugLine="DateTime.TimeFormat = \"HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm");
RDebugUtils.currentLine=53280773;
 //BA.debugLineNum = 53280773;BA.debugLine="If(dbCode.isexist_taradod_by_date(lbl_date_FT.Tex";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText())==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=53280774;
 //BA.debugLineNum = 53280774;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+mostCurrent._lbl_date_ft.getText()+"';")));
RDebugUtils.currentLine=53280775;
 //BA.debugLineNum = 53280775;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=53280777;
 //BA.debugLineNum = 53280777;BA.debugLine="lbl_tim_vorod_FT.Text=dbCode.res.GetString(\"time";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")));
RDebugUtils.currentLine=53280778;
 //BA.debugLineNum = 53280778;BA.debugLine="lbl_tim_khoroj_FT.Text=dbCode.res.GetString(\"tim";
mostCurrent._lbl_tim_khoroj_ft.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=53280780;
 //BA.debugLineNum = 53280780;BA.debugLine="et_tozihat_FT.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._et_tozihat_ft.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=53280782;
 //BA.debugLineNum = 53280782;BA.debugLine="current_id_edit=dbCode.res.GetInt(\"id\")";
_current_id_edit = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("id");
RDebugUtils.currentLine=53280783;
 //BA.debugLineNum = 53280783;BA.debugLine="Log(dbCode.res.GetInt(\"state\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("253280783",BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")),0);
RDebugUtils.currentLine=53280785;
 //BA.debugLineNum = 53280785;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=53280786;
 //BA.debugLineNum = 53280786;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=53280789;
 //BA.debugLineNum = 53280789;BA.debugLine="If(dbCode.res.GetInt(\"state\")=10)Then  ''vorod n";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==10)) { 
RDebugUtils.currentLine=53280790;
 //BA.debugLineNum = 53280790;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=53280791;
 //BA.debugLineNum = 53280791;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=53280792;
 //BA.debugLineNum = 53280792;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53280793;
 //BA.debugLineNum = 53280793;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53280795;
 //BA.debugLineNum = 53280795;BA.debugLine="code_fast_taradod=10";
_code_fast_taradod = (int) (10);
 }else 
{RDebugUtils.currentLine=53280796;
 //BA.debugLineNum = 53280796;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=20)Then  ''v";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==20)) { 
RDebugUtils.currentLine=53280797;
 //BA.debugLineNum = 53280797;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=53280798;
 //BA.debugLineNum = 53280798;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=53280799;
 //BA.debugLineNum = 53280799;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=53280800;
 //BA.debugLineNum = 53280800;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53280802;
 //BA.debugLineNum = 53280802;BA.debugLine="code_fast_taradod=20";
_code_fast_taradod = (int) (20);
 }else 
{RDebugUtils.currentLine=53280803;
 //BA.debugLineNum = 53280803;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=11)Then  ''k";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==11)) { 
RDebugUtils.currentLine=53280804;
 //BA.debugLineNum = 53280804;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=53280805;
 //BA.debugLineNum = 53280805;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=53280806;
 //BA.debugLineNum = 53280806;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53280807;
 //BA.debugLineNum = 53280807;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53280809;
 //BA.debugLineNum = 53280809;BA.debugLine="et_tozihat_FT.Enabled=False";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53280811;
 //BA.debugLineNum = 53280811;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
RDebugUtils.currentLine=53280812;
 //BA.debugLineNum = 53280812;BA.debugLine="code_fast_taradod=11";
_code_fast_taradod = (int) (11);
RDebugUtils.currentLine=53280813;
 //BA.debugLineNum = 53280813;BA.debugLine="ToastMessageShow(\"تردد امروز ثبت شده است\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تردد امروز ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=53280816;
 //BA.debugLineNum = 53280816;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=21)Then  ''k";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==21)) { 
RDebugUtils.currentLine=53280817;
 //BA.debugLineNum = 53280817;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=53280818;
 //BA.debugLineNum = 53280818;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=53280819;
 //BA.debugLineNum = 53280819;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=53280820;
 //BA.debugLineNum = 53280820;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53280822;
 //BA.debugLineNum = 53280822;BA.debugLine="et_tozihat_FT.Enabled=False";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53280824;
 //BA.debugLineNum = 53280824;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
RDebugUtils.currentLine=53280826;
 //BA.debugLineNum = 53280826;BA.debugLine="code_fast_taradod=21";
_code_fast_taradod = (int) (21);
RDebugUtils.currentLine=53280827;
 //BA.debugLineNum = 53280827;BA.debugLine="ToastMessageShow(\"تردد امروز ثبت شده است\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تردد امروز ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=53280830;
 //BA.debugLineNum = 53280830;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=0)Then  ''da";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==0)) { 
RDebugUtils.currentLine=53280831;
 //BA.debugLineNum = 53280831;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Red";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=53280832;
 //BA.debugLineNum = 53280832;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Red";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=53280833;
 //BA.debugLineNum = 53280833;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53280834;
 //BA.debugLineNum = 53280834;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53280836;
 //BA.debugLineNum = 53280836;BA.debugLine="et_tozihat_FT.Enabled=False";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53280837;
 //BA.debugLineNum = 53280837;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
RDebugUtils.currentLine=53280839;
 //BA.debugLineNum = 53280839;BA.debugLine="ToastMessageShow(\"برای امروز تردد دستی ثبت شده";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برای امروز تردد دستی ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=53280841;
 //BA.debugLineNum = 53280841;BA.debugLine="code_fast_taradod=0";
_code_fast_taradod = (int) (0);
 }}}}}
;
 }else {
RDebugUtils.currentLine=53280844;
 //BA.debugLineNum = 53280844;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=53280845;
 //BA.debugLineNum = 53280845;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=53280847;
 //BA.debugLineNum = 53280847;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=53280848;
 //BA.debugLineNum = 53280848;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=True";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=53280849;
 //BA.debugLineNum = 53280849;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
RDebugUtils.currentLine=53280850;
 //BA.debugLineNum = 53280850;BA.debugLine="et_tozihat_FT.Enabled=True";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=53280852;
 //BA.debugLineNum = 53280852;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_msgnewyear_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_msgnewyear_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_msgnewyear_click", null));}
RDebugUtils.currentLine=45809664;
 //BA.debugLineNum = 45809664;BA.debugLine="Private Sub pan_all_msgNewYear_Click";
RDebugUtils.currentLine=45809666;
 //BA.debugLineNum = 45809666;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all2_click", null));}
RDebugUtils.currentLine=50987008;
 //BA.debugLineNum = 50987008;BA.debugLine="Private Sub pan_all2_Click";
RDebugUtils.currentLine=50987011;
 //BA.debugLineNum = 50987011;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=50987012;
 //BA.debugLineNum = 50987012;BA.debugLine="End Sub";
return "";
}
public static String  _pan_bime_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_bime_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_bime_click", null));}
RDebugUtils.currentLine=54067200;
 //BA.debugLineNum = 54067200;BA.debugLine="Private Sub pan_bime_Click";
RDebugUtils.currentLine=54067201;
 //BA.debugLineNum = 54067201;BA.debugLine="StartActivity(bime_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._bime_activity.getObject()));
RDebugUtils.currentLine=54067203;
 //BA.debugLineNum = 54067203;BA.debugLine="End Sub";
return "";
}
public static String  _pan_calc_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_calc_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_calc_click", null));}
RDebugUtils.currentLine=51249152;
 //BA.debugLineNum = 51249152;BA.debugLine="Private Sub pan_calc_Click";
RDebugUtils.currentLine=51249153;
 //BA.debugLineNum = 51249153;BA.debugLine="StartActivity(calc_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._calc_activity.getObject()));
RDebugUtils.currentLine=51249156;
 //BA.debugLineNum = 51249156;BA.debugLine="End Sub";
return "";
}
public static String  _pan_comment_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_comment_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_comment_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _market = null;
String _url = "";
RDebugUtils.currentLine=51118080;
 //BA.debugLineNum = 51118080;BA.debugLine="Private Sub pan_comment_Click";
RDebugUtils.currentLine=51118082;
 //BA.debugLineNum = 51118082;BA.debugLine="Try";
try {RDebugUtils.currentLine=51118083;
 //BA.debugLineNum = 51118083;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=51118085;
 //BA.debugLineNum = 51118085;BA.debugLine="Try";
try {RDebugUtils.currentLine=51118086;
 //BA.debugLineNum = 51118086;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=51118087;
 //BA.debugLineNum = 51118087;BA.debugLine="Dim url As String";
_url = "";
RDebugUtils.currentLine=51118089;
 //BA.debugLineNum = 51118089;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafek";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
RDebugUtils.currentLine=51118090;
 //BA.debugLineNum = 51118090;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
RDebugUtils.currentLine=51118091;
 //BA.debugLineNum = 51118091;BA.debugLine="market.SetPackage(\"com.farsitel.bazaar\")";
_market.SetPackage("com.farsitel.bazaar");
RDebugUtils.currentLine=51118092;
 //BA.debugLineNum = 51118092;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e11) {
			processBA.setLastException(e11);RDebugUtils.currentLine=51118095;
 //BA.debugLineNum = 51118095;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=51118098;
 //BA.debugLineNum = 51118098;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e17) {
			processBA.setLastException(e17);RDebugUtils.currentLine=51118102;
 //BA.debugLineNum = 51118102;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=51118104;
 //BA.debugLineNum = 51118104;BA.debugLine="Try";
try {RDebugUtils.currentLine=51118105;
 //BA.debugLineNum = 51118105;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=51118106;
 //BA.debugLineNum = 51118106;BA.debugLine="Dim url As String";
_url = "";
RDebugUtils.currentLine=51118108;
 //BA.debugLineNum = 51118108;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafe";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
RDebugUtils.currentLine=51118109;
 //BA.debugLineNum = 51118109;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
RDebugUtils.currentLine=51118110;
 //BA.debugLineNum = 51118110;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e25) {
			processBA.setLastException(e25);RDebugUtils.currentLine=51118113;
 //BA.debugLineNum = 51118113;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=51118116;
 //BA.debugLineNum = 51118116;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 };
RDebugUtils.currentLine=51118123;
 //BA.debugLineNum = 51118123;BA.debugLine="End Sub";
return "";
}
public static String  _pan_darsad_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_darsad_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_darsad_click", null));}
RDebugUtils.currentLine=51052544;
 //BA.debugLineNum = 51052544;BA.debugLine="Private Sub pan_darsad_Click";
RDebugUtils.currentLine=51052545;
 //BA.debugLineNum = 51052545;BA.debugLine="StartActivity(darsad_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._darsad_activity.getObject()));
RDebugUtils.currentLine=51052547;
 //BA.debugLineNum = 51052547;BA.debugLine="End Sub";
return "";
}
public static String  _pan_eidi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_eidi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_eidi_click", null));}
RDebugUtils.currentLine=50397184;
 //BA.debugLineNum = 50397184;BA.debugLine="Private Sub pan_eidi_Click";
RDebugUtils.currentLine=50397185;
 //BA.debugLineNum = 50397185;BA.debugLine="StartActivity(eidi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._eidi_activity.getObject()));
RDebugUtils.currentLine=50397187;
 //BA.debugLineNum = 50397187;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ezafekari_mah_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_ezafekari_mah_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_ezafekari_mah_click", null));}
RDebugUtils.currentLine=52101120;
 //BA.debugLineNum = 52101120;BA.debugLine="Private Sub pan_ezafekari_mah_Click";
RDebugUtils.currentLine=52101121;
 //BA.debugLineNum = 52101121;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
RDebugUtils.currentLine=52101122;
 //BA.debugLineNum = 52101122;BA.debugLine="TabHost1.CurrentTab=0";
mostCurrent._tabhost1.setCurrentTab((int) (0));
RDebugUtils.currentLine=52101124;
 //BA.debugLineNum = 52101124;BA.debugLine="End Sub";
return "";
}
public static String  _pan_fast_run_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_fast_run_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_fast_run_click", null));}
RDebugUtils.currentLine=47906816;
 //BA.debugLineNum = 47906816;BA.debugLine="Private Sub pan_fast_run_Click";
RDebugUtils.currentLine=47906821;
 //BA.debugLineNum = 47906821;BA.debugLine="StartActivity(fast_run_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._fast_run_activity.getObject()));
RDebugUtils.currentLine=47906825;
 //BA.debugLineNum = 47906825;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ganon_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_ganon_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_ganon_click", null));}
RDebugUtils.currentLine=52559872;
 //BA.debugLineNum = 52559872;BA.debugLine="Private Sub pan_ganon_Click";
RDebugUtils.currentLine=52559873;
 //BA.debugLineNum = 52559873;BA.debugLine="StartActivity(ganon_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ganon_activity.getObject()));
RDebugUtils.currentLine=52559875;
 //BA.debugLineNum = 52559875;BA.debugLine="End Sub";
return "";
}
public static String  _pan_help_kharid_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_help_kharid_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_help_kharid_click", null));}
RDebugUtils.currentLine=54591488;
 //BA.debugLineNum = 54591488;BA.debugLine="Private Sub pan_help_kharid_Click";
RDebugUtils.currentLine=54591491;
 //BA.debugLineNum = 54591491;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=54591492;
 //BA.debugLineNum = 54591492;BA.debugLine="StartActivity(help_kharid_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._help_kharid_activity.getObject()));
 }else {
RDebugUtils.currentLine=54591494;
 //BA.debugLineNum = 54591494;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 };
RDebugUtils.currentLine=54591499;
 //BA.debugLineNum = 54591499;BA.debugLine="End Sub";
return "";
}
public static String  _pan_help_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_help_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_help_touch", new Object[] {_action,_x,_y}));}
RDebugUtils.currentLine=51511296;
 //BA.debugLineNum = 51511296;BA.debugLine="Private Sub pan_help_Touch (Action As Int, X As Fl";
RDebugUtils.currentLine=51511298;
 //BA.debugLineNum = 51511298;BA.debugLine="If (Action=0)Then";
if ((_action==0)) { 
RDebugUtils.currentLine=51511299;
 //BA.debugLineNum = 51511299;BA.debugLine="index_x_start_swap=x";
_index_x_start_swap = (int) (_x);
RDebugUtils.currentLine=51511300;
 //BA.debugLineNum = 51511300;BA.debugLine="If (index_curent_img=4)Then";
if ((_index_curent_img==4)) { 
RDebugUtils.currentLine=51511301;
 //BA.debugLineNum = 51511301;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
RDebugUtils.currentLine=51511304;
 //BA.debugLineNum = 51511304;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=51511305;
 //BA.debugLineNum = 51511305;BA.debugLine="If(X<(index_x_start_swap-150))Then";
if ((_x<(_index_x_start_swap-150))) { 
RDebugUtils.currentLine=51511308;
 //BA.debugLineNum = 51511308;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
RDebugUtils.currentLine=51511309;
 //BA.debugLineNum = 51511309;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
RDebugUtils.currentLine=51511310;
 //BA.debugLineNum = 51511310;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 }else 
{RDebugUtils.currentLine=51511314;
 //BA.debugLineNum = 51511314;BA.debugLine="Else If(X>(index_x_start_swap+150))Then";
if ((_x>(_index_x_start_swap+150))) { 
RDebugUtils.currentLine=51511317;
 //BA.debugLineNum = 51511317;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
RDebugUtils.currentLine=51511318;
 //BA.debugLineNum = 51511318;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
RDebugUtils.currentLine=51511319;
 //BA.debugLineNum = 51511319;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else 
{RDebugUtils.currentLine=51511323;
 //BA.debugLineNum = 51511323;BA.debugLine="Else If(index_x_start_swap<(pan_help.Width/2))Th";
if ((_index_x_start_swap<(mostCurrent._pan_help.getWidth()/(double)2))) { 
RDebugUtils.currentLine=51511325;
 //BA.debugLineNum = 51511325;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
RDebugUtils.currentLine=51511326;
 //BA.debugLineNum = 51511326;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
RDebugUtils.currentLine=51511327;
 //BA.debugLineNum = 51511327;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else 
{RDebugUtils.currentLine=51511330;
 //BA.debugLineNum = 51511330;BA.debugLine="Else If(index_x_start_swap>(pan_help.Width/2))Th";
if ((_index_x_start_swap>(mostCurrent._pan_help.getWidth()/(double)2))) { 
RDebugUtils.currentLine=51511332;
 //BA.debugLineNum = 51511332;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
RDebugUtils.currentLine=51511333;
 //BA.debugLineNum = 51511333;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
RDebugUtils.currentLine=51511334;
 //BA.debugLineNum = 51511334;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 }}}}
;
RDebugUtils.currentLine=51511339;
 //BA.debugLineNum = 51511339;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 };
RDebugUtils.currentLine=51511342;
 //BA.debugLineNum = 51511342;BA.debugLine="End Sub";
return "";
}
public static String  _pan_info_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_info_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_info_click", null));}
RDebugUtils.currentLine=50528256;
 //BA.debugLineNum = 50528256;BA.debugLine="Private Sub pan_info_Click";
RDebugUtils.currentLine=50528257;
 //BA.debugLineNum = 50528257;BA.debugLine="StartActivity(info_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._info_activity.getObject()));
RDebugUtils.currentLine=50528260;
 //BA.debugLineNum = 50528260;BA.debugLine="End Sub";
return "";
}
public static String  _pan_item_gozaresh_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_item_gozaresh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_item_gozaresh_click", null));}
anywheresoftware.b4a.objects.PanelWrapper _ba = null;
RDebugUtils.currentLine=51183616;
 //BA.debugLineNum = 51183616;BA.debugLine="Private Sub pan_item_gozaresh_Click";
RDebugUtils.currentLine=51183617;
 //BA.debugLineNum = 51183617;BA.debugLine="Dim Ba As Panel = Sender";
_ba = new anywheresoftware.b4a.objects.PanelWrapper();
_ba = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=51183619;
 //BA.debugLineNum = 51183619;BA.debugLine="current_gozaresh_id=Ba.Tag";
_current_gozaresh_id = (int)(BA.ObjectToNumber(_ba.getTag()));
RDebugUtils.currentLine=51183620;
 //BA.debugLineNum = 51183620;BA.debugLine="StartActivity(show_gozaresh_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._show_gozaresh_activity.getObject()));
RDebugUtils.currentLine=51183622;
 //BA.debugLineNum = 51183622;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lelp_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_lelp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_lelp_click", null));}
RDebugUtils.currentLine=51576832;
 //BA.debugLineNum = 51576832;BA.debugLine="Private Sub pan_lelp_Click";
RDebugUtils.currentLine=51576834;
 //BA.debugLineNum = 51576834;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lock_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_lock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_lock_click", null));}
RDebugUtils.currentLine=54132736;
 //BA.debugLineNum = 54132736;BA.debugLine="Private Sub pan_lock_Click";
RDebugUtils.currentLine=54132738;
 //BA.debugLineNum = 54132738;BA.debugLine="End Sub";
return "";
}
public static String  _pan_morakhasi_mah_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_morakhasi_mah_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_morakhasi_mah_click", null));}
RDebugUtils.currentLine=52166656;
 //BA.debugLineNum = 52166656;BA.debugLine="Private Sub pan_morakhasi_mah_Click";
RDebugUtils.currentLine=52166657;
 //BA.debugLineNum = 52166657;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
RDebugUtils.currentLine=52166658;
 //BA.debugLineNum = 52166658;BA.debugLine="TabHost1.CurrentTab=1";
mostCurrent._tabhost1.setCurrentTab((int) (1));
RDebugUtils.currentLine=52166660;
 //BA.debugLineNum = 52166660;BA.debugLine="End Sub";
return "";
}
public static String  _pan_notifi_all_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_notifi_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_notifi_all_click", null));}
RDebugUtils.currentLine=46202880;
 //BA.debugLineNum = 46202880;BA.debugLine="Private Sub pan_notifi_all_Click";
RDebugUtils.currentLine=46202882;
 //BA.debugLineNum = 46202882;BA.debugLine="End Sub";
return "";
}
public static String  _pan_payankar_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_payankar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_payankar_click", null));}
RDebugUtils.currentLine=50462720;
 //BA.debugLineNum = 50462720;BA.debugLine="Private Sub pan_payankar_Click";
RDebugUtils.currentLine=50462721;
 //BA.debugLineNum = 50462721;BA.debugLine="StartActivity(payankar_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._payankar_activity.getObject()));
RDebugUtils.currentLine=50462723;
 //BA.debugLineNum = 50462723;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_hogog_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_run_hogog_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_run_hogog_click", null));}
RDebugUtils.currentLine=48103424;
 //BA.debugLineNum = 48103424;BA.debugLine="Private Sub pan_run_hogog_Click";
RDebugUtils.currentLine=48103425;
 //BA.debugLineNum = 48103425;BA.debugLine="If (myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=48103426;
 //BA.debugLineNum = 48103426;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
 }else {
RDebugUtils.currentLine=48103428;
 //BA.debugLineNum = 48103428;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
RDebugUtils.currentLine=48103429;
 //BA.debugLineNum = 48103429;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
RDebugUtils.currentLine=48103434;
 //BA.debugLineNum = 48103434;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_morakhasi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_run_morakhasi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_run_morakhasi_click", null));}
RDebugUtils.currentLine=48037888;
 //BA.debugLineNum = 48037888;BA.debugLine="Private Sub pan_run_morakhasi_Click";
RDebugUtils.currentLine=48037890;
 //BA.debugLineNum = 48037890;BA.debugLine="StartActivity(morakhasi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._morakhasi_activity.getObject()));
RDebugUtils.currentLine=48037897;
 //BA.debugLineNum = 48037897;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_setting_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_setting_click", null));}
RDebugUtils.currentLine=52625408;
 //BA.debugLineNum = 52625408;BA.debugLine="Private Sub pan_setting_Click";
RDebugUtils.currentLine=52625409;
 //BA.debugLineNum = 52625409;BA.debugLine="StartActivity(setting_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_activity.getObject()));
RDebugUtils.currentLine=52625410;
 //BA.debugLineNum = 52625410;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=52625411;
 //BA.debugLineNum = 52625411;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_hogog_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_setting_hogog_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_setting_hogog_click", null));}
RDebugUtils.currentLine=47972352;
 //BA.debugLineNum = 47972352;BA.debugLine="Private Sub pan_setting_hogog_Click";
RDebugUtils.currentLine=47972353;
 //BA.debugLineNum = 47972353;BA.debugLine="StartActivity(setting_hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_hogog_activity.getObject()));
RDebugUtils.currentLine=47972354;
 //BA.debugLineNum = 47972354;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=47972356;
 //BA.debugLineNum = 47972356;BA.debugLine="End Sub";
return "";
}
public static String  _pan_shift_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_shift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_shift_click", null));}
RDebugUtils.currentLine=52756480;
 //BA.debugLineNum = 52756480;BA.debugLine="Private Sub pan_shift_Click";
RDebugUtils.currentLine=52756482;
 //BA.debugLineNum = 52756482;BA.debugLine="StartActivity(shift_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._shift_activity.getObject()));
RDebugUtils.currentLine=52756484;
 //BA.debugLineNum = 52756484;BA.debugLine="End Sub";
return "";
}
public static String  _pan_taghvim_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_taghvim_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_taghvim_click", null));}
RDebugUtils.currentLine=52822016;
 //BA.debugLineNum = 52822016;BA.debugLine="Private Sub pan_taghvim_Click";
RDebugUtils.currentLine=52822017;
 //BA.debugLineNum = 52822017;BA.debugLine="pan_shift_Click";
_pan_shift_click();
RDebugUtils.currentLine=52822018;
 //BA.debugLineNum = 52822018;BA.debugLine="End Sub";
return "";
}
public static String  _panel1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel1_click", null));}
RDebugUtils.currentLine=53018624;
 //BA.debugLineNum = 53018624;BA.debugLine="Private Sub Panel1_Click";
RDebugUtils.currentLine=53018626;
 //BA.debugLineNum = 53018626;BA.debugLine="End Sub";
return "";
}
public static String  _panel10_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel10_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel10_click", null));}
RDebugUtils.currentLine=54460416;
 //BA.debugLineNum = 54460416;BA.debugLine="Private Sub Panel10_Click";
RDebugUtils.currentLine=54460418;
 //BA.debugLineNum = 54460418;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel4_click", null));}
RDebugUtils.currentLine=48627712;
 //BA.debugLineNum = 48627712;BA.debugLine="Private Sub Panel4_Click";
RDebugUtils.currentLine=48627714;
 //BA.debugLineNum = 48627714;BA.debugLine="End Sub";
return "";
}
public static String  _panel5_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel5_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel5_click", null));}
RDebugUtils.currentLine=52428800;
 //BA.debugLineNum = 52428800;BA.debugLine="Private Sub Panel5_Click";
RDebugUtils.currentLine=52428802;
 //BA.debugLineNum = 52428802;BA.debugLine="End Sub";
return "";
}
public static String  _panel6_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel6_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel6_click", null));}
RDebugUtils.currentLine=53870592;
 //BA.debugLineNum = 53870592;BA.debugLine="Private Sub Panel6_Click";
RDebugUtils.currentLine=53870594;
 //BA.debugLineNum = 53870594;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=50135040;
 //BA.debugLineNum = 50135040;BA.debugLine="Private Sub pik_day_bala1_Click";
RDebugUtils.currentLine=50135041;
 //BA.debugLineNum = 50135041;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=50135042;
 //BA.debugLineNum = 50135042;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=50135045;
 //BA.debugLineNum = 50135045;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=50135046;
 //BA.debugLineNum = 50135046;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=50135047;
 //BA.debugLineNum = 50135047;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=50135049;
 //BA.debugLineNum = 50135049;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=50135050;
 //BA.debugLineNum = 50135050;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=50135053;
 //BA.debugLineNum = 50135053;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=50135054;
 //BA.debugLineNum = 50135054;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=50135056;
 //BA.debugLineNum = 50135056;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=50135057;
 //BA.debugLineNum = 50135057;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=50135061;
 //BA.debugLineNum = 50135061;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=50200576;
 //BA.debugLineNum = 50200576;BA.debugLine="Private Sub pik_day_paeen1_Click";
RDebugUtils.currentLine=50200577;
 //BA.debugLineNum = 50200577;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=50200578;
 //BA.debugLineNum = 50200578;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=50200579;
 //BA.debugLineNum = 50200579;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=50200580;
 //BA.debugLineNum = 50200580;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=50200581;
 //BA.debugLineNum = 50200581;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=50200583;
 //BA.debugLineNum = 50200583;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=50200584;
 //BA.debugLineNum = 50200584;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=50200587;
 //BA.debugLineNum = 50200587;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=50200588;
 //BA.debugLineNum = 50200588;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=50200590;
 //BA.debugLineNum = 50200590;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=50200591;
 //BA.debugLineNum = 50200591;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=50200595;
 //BA.debugLineNum = 50200595;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_hour_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_hour_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=49283072;
 //BA.debugLineNum = 49283072;BA.debugLine="Private Sub pik_hour_bala1_Click";
RDebugUtils.currentLine=49283074;
 //BA.debugLineNum = 49283074;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
RDebugUtils.currentLine=49283075;
 //BA.debugLineNum = 49283075;BA.debugLine="pik_hour1.Text=int1+1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=49283077;
 //BA.debugLineNum = 49283077;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
RDebugUtils.currentLine=49283078;
 //BA.debugLineNum = 49283078;BA.debugLine="pik_hour1.Text=00";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(00));
 };
RDebugUtils.currentLine=49283080;
 //BA.debugLineNum = 49283080;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
RDebugUtils.currentLine=49283081;
 //BA.debugLineNum = 49283081;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
RDebugUtils.currentLine=49283084;
 //BA.debugLineNum = 49283084;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_hour_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_hour_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=49348608;
 //BA.debugLineNum = 49348608;BA.debugLine="Private Sub pik_hour_paeen1_Click";
RDebugUtils.currentLine=49348609;
 //BA.debugLineNum = 49348609;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
RDebugUtils.currentLine=49348610;
 //BA.debugLineNum = 49348610;BA.debugLine="pik_hour1.Text=int1-1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=49348612;
 //BA.debugLineNum = 49348612;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
RDebugUtils.currentLine=49348613;
 //BA.debugLineNum = 49348613;BA.debugLine="pik_hour1.Text=00";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(00));
 };
RDebugUtils.currentLine=49348615;
 //BA.debugLineNum = 49348615;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
RDebugUtils.currentLine=49348616;
 //BA.debugLineNum = 49348616;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
RDebugUtils.currentLine=49348619;
 //BA.debugLineNum = 49348619;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_min_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_min_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=49414144;
 //BA.debugLineNum = 49414144;BA.debugLine="Private Sub pik_min_bala1_Click";
RDebugUtils.currentLine=49414145;
 //BA.debugLineNum = 49414145;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
RDebugUtils.currentLine=49414146;
 //BA.debugLineNum = 49414146;BA.debugLine="pik_min1.Text=int1+1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=49414148;
 //BA.debugLineNum = 49414148;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
RDebugUtils.currentLine=49414149;
 //BA.debugLineNum = 49414149;BA.debugLine="pik_min1.Text=00";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(00));
 };
RDebugUtils.currentLine=49414151;
 //BA.debugLineNum = 49414151;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
RDebugUtils.currentLine=49414152;
 //BA.debugLineNum = 49414152;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
RDebugUtils.currentLine=49414155;
 //BA.debugLineNum = 49414155;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_min_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_min_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=49479680;
 //BA.debugLineNum = 49479680;BA.debugLine="Private Sub pik_min_paeen1_Click";
RDebugUtils.currentLine=49479681;
 //BA.debugLineNum = 49479681;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
RDebugUtils.currentLine=49479682;
 //BA.debugLineNum = 49479682;BA.debugLine="pik_min1.Text=int1-1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=49479684;
 //BA.debugLineNum = 49479684;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
RDebugUtils.currentLine=49479685;
 //BA.debugLineNum = 49479685;BA.debugLine="pik_min1.Text=00";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(00));
 };
RDebugUtils.currentLine=49479687;
 //BA.debugLineNum = 49479687;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
RDebugUtils.currentLine=49479688;
 //BA.debugLineNum = 49479688;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
RDebugUtils.currentLine=49479691;
 //BA.debugLineNum = 49479691;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=49872896;
 //BA.debugLineNum = 49872896;BA.debugLine="Private Sub pik_moon_bala1_Click";
RDebugUtils.currentLine=49872897;
 //BA.debugLineNum = 49872897;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=49872898;
 //BA.debugLineNum = 49872898;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
RDebugUtils.currentLine=49872900;
 //BA.debugLineNum = 49872900;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=49872901;
 //BA.debugLineNum = 49872901;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=49872903;
 //BA.debugLineNum = 49872903;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=49872904;
 //BA.debugLineNum = 49872904;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=49872906;
 //BA.debugLineNum = 49872906;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=49872908;
 //BA.debugLineNum = 49872908;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=49938432;
 //BA.debugLineNum = 49938432;BA.debugLine="Private Sub pik_moon_paeen1_Click";
RDebugUtils.currentLine=49938433;
 //BA.debugLineNum = 49938433;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=49938434;
 //BA.debugLineNum = 49938434;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
RDebugUtils.currentLine=49938436;
 //BA.debugLineNum = 49938436;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=49938437;
 //BA.debugLineNum = 49938437;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=49938439;
 //BA.debugLineNum = 49938439;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=49938440;
 //BA.debugLineNum = 49938440;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=49938442;
 //BA.debugLineNum = 49938442;BA.debugLine="pik_moon1.Text=moon.Get(myfunc.fa2en(pik_moon1.Ta";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
RDebugUtils.currentLine=49938444;
 //BA.debugLineNum = 49938444;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_day1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_day1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=49807360;
 //BA.debugLineNum = 49807360;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
RDebugUtils.currentLine=49807361;
 //BA.debugLineNum = 49807361;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=49807362;
 //BA.debugLineNum = 49807362;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=49807363;
 //BA.debugLineNum = 49807363;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=49807366;
 //BA.debugLineNum = 49807366;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=49807368;
 //BA.debugLineNum = 49807368;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=49807369;
 //BA.debugLineNum = 49807369;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
RDebugUtils.currentLine=49807370;
 //BA.debugLineNum = 49807370;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=49807371;
 //BA.debugLineNum = 49807371;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=49807373;
 //BA.debugLineNum = 49807373;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=49807374;
 //BA.debugLineNum = 49807374;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
RDebugUtils.currentLine=49807375;
 //BA.debugLineNum = 49807375;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=49807376;
 //BA.debugLineNum = 49807376;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=49807379;
 //BA.debugLineNum = 49807379;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=49807380;
 //BA.debugLineNum = 49807380;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=49807381;
 //BA.debugLineNum = 49807381;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=49807383;
 //BA.debugLineNum = 49807383;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=49807384;
 //BA.debugLineNum = 49807384;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=49807387;
 //BA.debugLineNum = 49807387;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=49807388;
 //BA.debugLineNum = 49807388;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=49807390;
 //BA.debugLineNum = 49807390;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=49807391;
 //BA.debugLineNum = 49807391;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 };
RDebugUtils.currentLine=49807398;
 //BA.debugLineNum = 49807398;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_hour1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_hour1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_hour1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=49545216;
 //BA.debugLineNum = 49545216;BA.debugLine="Private Sub pik_pan_hour1_Touch (Action As Int, X";
RDebugUtils.currentLine=49545217;
 //BA.debugLineNum = 49545217;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=49545218;
 //BA.debugLineNum = 49545218;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=49545219;
 //BA.debugLineNum = 49545219;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=49545222;
 //BA.debugLineNum = 49545222;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=49545224;
 //BA.debugLineNum = 49545224;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=49545225;
 //BA.debugLineNum = 49545225;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))-1);
RDebugUtils.currentLine=49545226;
 //BA.debugLineNum = 49545226;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=49545227;
 //BA.debugLineNum = 49545227;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=49545229;
 //BA.debugLineNum = 49545229;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=49545230;
 //BA.debugLineNum = 49545230;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))+1);
RDebugUtils.currentLine=49545231;
 //BA.debugLineNum = 49545231;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=49545232;
 //BA.debugLineNum = 49545232;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=49545235;
 //BA.debugLineNum = 49545235;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
RDebugUtils.currentLine=49545236;
 //BA.debugLineNum = 49545236;BA.debugLine="pik_hour1.Text=00";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(00));
 };
RDebugUtils.currentLine=49545238;
 //BA.debugLineNum = 49545238;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
RDebugUtils.currentLine=49545239;
 //BA.debugLineNum = 49545239;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
 };
RDebugUtils.currentLine=49545244;
 //BA.debugLineNum = 49545244;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_min1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_min1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_min1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=49610752;
 //BA.debugLineNum = 49610752;BA.debugLine="Private Sub pik_pan_min1_Touch (Action As Int, X A";
RDebugUtils.currentLine=49610753;
 //BA.debugLineNum = 49610753;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=49610754;
 //BA.debugLineNum = 49610754;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=49610755;
 //BA.debugLineNum = 49610755;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=49610758;
 //BA.debugLineNum = 49610758;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=49610760;
 //BA.debugLineNum = 49610760;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=49610762;
 //BA.debugLineNum = 49610762;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))-1);
RDebugUtils.currentLine=49610763;
 //BA.debugLineNum = 49610763;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=49610766;
 //BA.debugLineNum = 49610766;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=49610768;
 //BA.debugLineNum = 49610768;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=49610770;
 //BA.debugLineNum = 49610770;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))+1);
RDebugUtils.currentLine=49610771;
 //BA.debugLineNum = 49610771;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=49610774;
 //BA.debugLineNum = 49610774;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=49610778;
 //BA.debugLineNum = 49610778;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
RDebugUtils.currentLine=49610779;
 //BA.debugLineNum = 49610779;BA.debugLine="pik_min1.Text=00";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(00));
 };
RDebugUtils.currentLine=49610782;
 //BA.debugLineNum = 49610782;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
RDebugUtils.currentLine=49610783;
 //BA.debugLineNum = 49610783;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
 };
RDebugUtils.currentLine=49610790;
 //BA.debugLineNum = 49610790;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_moon1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_moon1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=49676288;
 //BA.debugLineNum = 49676288;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
RDebugUtils.currentLine=49676289;
 //BA.debugLineNum = 49676289;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=49676290;
 //BA.debugLineNum = 49676290;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=49676291;
 //BA.debugLineNum = 49676291;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=49676294;
 //BA.debugLineNum = 49676294;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=49676296;
 //BA.debugLineNum = 49676296;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=49676297;
 //BA.debugLineNum = 49676297;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
RDebugUtils.currentLine=49676298;
 //BA.debugLineNum = 49676298;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=49676299;
 //BA.debugLineNum = 49676299;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=49676301;
 //BA.debugLineNum = 49676301;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=49676302;
 //BA.debugLineNum = 49676302;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
RDebugUtils.currentLine=49676303;
 //BA.debugLineNum = 49676303;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=49676304;
 //BA.debugLineNum = 49676304;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=49676307;
 //BA.debugLineNum = 49676307;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=49676308;
 //BA.debugLineNum = 49676308;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=49676310;
 //BA.debugLineNum = 49676310;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=49676311;
 //BA.debugLineNum = 49676311;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=49676313;
 //BA.debugLineNum = 49676313;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
RDebugUtils.currentLine=49676316;
 //BA.debugLineNum = 49676316;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_year1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_year1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=49741824;
 //BA.debugLineNum = 49741824;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
RDebugUtils.currentLine=49741825;
 //BA.debugLineNum = 49741825;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=49741826;
 //BA.debugLineNum = 49741826;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=49741827;
 //BA.debugLineNum = 49741827;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=49741830;
 //BA.debugLineNum = 49741830;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=49741832;
 //BA.debugLineNum = 49741832;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=49741833;
 //BA.debugLineNum = 49741833;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
RDebugUtils.currentLine=49741834;
 //BA.debugLineNum = 49741834;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=49741835;
 //BA.debugLineNum = 49741835;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=49741837;
 //BA.debugLineNum = 49741837;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=49741838;
 //BA.debugLineNum = 49741838;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
RDebugUtils.currentLine=49741839;
 //BA.debugLineNum = 49741839;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=49741840;
 //BA.debugLineNum = 49741840;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=49741843;
 //BA.debugLineNum = 49741843;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=49741844;
 //BA.debugLineNum = 49741844;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=49741846;
 //BA.debugLineNum = 49741846;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=49741847;
 //BA.debugLineNum = 49741847;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
RDebugUtils.currentLine=49741852;
 //BA.debugLineNum = 49741852;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=50003968;
 //BA.debugLineNum = 50003968;BA.debugLine="Private Sub pik_year_bala1_Click";
RDebugUtils.currentLine=50003969;
 //BA.debugLineNum = 50003969;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=50003970;
 //BA.debugLineNum = 50003970;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=50003972;
 //BA.debugLineNum = 50003972;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=50003973;
 //BA.debugLineNum = 50003973;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=50003975;
 //BA.debugLineNum = 50003975;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=50003976;
 //BA.debugLineNum = 50003976;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=50003979;
 //BA.debugLineNum = 50003979;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=50069504;
 //BA.debugLineNum = 50069504;BA.debugLine="Private Sub pik_year_paeen1_Click";
RDebugUtils.currentLine=50069505;
 //BA.debugLineNum = 50069505;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=50069506;
 //BA.debugLineNum = 50069506;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=50069508;
 //BA.debugLineNum = 50069508;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=50069509;
 //BA.debugLineNum = 50069509;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=50069511;
 //BA.debugLineNum = 50069511;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=50069512;
 //BA.debugLineNum = 50069512;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=50069515;
 //BA.debugLineNum = 50069515;BA.debugLine="End Sub";
return "";
}
public static boolean  _rspop_noe_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_noe_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_noe_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=48300032;
 //BA.debugLineNum = 48300032;BA.debugLine="Sub rsPOP_noe_MenuItemClick (ItemId As Int) As Boo";
RDebugUtils.currentLine=48300034;
 //BA.debugLineNum = 48300034;BA.debugLine="Select ItemId";
switch (_itemid) {
case 0: {
RDebugUtils.currentLine=48300036;
 //BA.debugLineNum = 48300036;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
RDebugUtils.currentLine=48300038;
 //BA.debugLineNum = 48300038;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
RDebugUtils.currentLine=48300040;
 //BA.debugLineNum = 48300040;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
RDebugUtils.currentLine=48300042;
 //BA.debugLineNum = 48300042;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
RDebugUtils.currentLine=48300046;
 //BA.debugLineNum = 48300046;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
RDebugUtils.currentLine=48300047;
 //BA.debugLineNum = 48300047;BA.debugLine="index_noe_morakhasi=ItemId";
_index_noe_morakhasi = _itemid;
RDebugUtils.currentLine=48300048;
 //BA.debugLineNum = 48300048;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=48300049;
 //BA.debugLineNum = 48300049;BA.debugLine="End Sub";
return false;
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_moon_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_moon_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=50331648;
 //BA.debugLineNum = 50331648;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=50331649;
 //BA.debugLineNum = 50331649;BA.debugLine="Dim moon_num As String";
_moon_num = "";
RDebugUtils.currentLine=50331651;
 //BA.debugLineNum = 50331651;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=50331654;
 //BA.debugLineNum = 50331654;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=50331655;
 //BA.debugLineNum = 50331655;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
RDebugUtils.currentLine=50331656;
 //BA.debugLineNum = 50331656;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_gozaresh_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_gozaresh_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_gozaresh_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=53084160;
 //BA.debugLineNum = 53084160;BA.debugLine="Private Sub sp_year_gozaresh_ItemClick (Position A";
RDebugUtils.currentLine=53084161;
 //BA.debugLineNum = 53084161;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
RDebugUtils.currentLine=53084162;
 //BA.debugLineNum = 53084162;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=50266112;
 //BA.debugLineNum = 50266112;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=50266117;
 //BA.debugLineNum = 50266117;BA.debugLine="Dim moon_num As String";
_moon_num = "";
RDebugUtils.currentLine=50266118;
 //BA.debugLineNum = 50266118;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=50266120;
 //BA.debugLineNum = 50266120;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=50266122;
 //BA.debugLineNum = 50266122;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
RDebugUtils.currentLine=50266124;
 //BA.debugLineNum = 50266124;BA.debugLine="End Sub";
return "";
}
public static String  _tim_lock_lbl_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_lock_lbl_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_lock_lbl_tick", null));}
RDebugUtils.currentLine=46465024;
 //BA.debugLineNum = 46465024;BA.debugLine="Sub tim_lock_lbl_Tick";
RDebugUtils.currentLine=46465025;
 //BA.debugLineNum = 46465025;BA.debugLine="If(stat_finger=0)Then";
if ((_stat_finger==0)) { 
RDebugUtils.currentLine=46465026;
 //BA.debugLineNum = 46465026;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
mostCurrent._lbl_finger.setTextColor(((int)0xff0b6200));
RDebugUtils.currentLine=46465027;
 //BA.debugLineNum = 46465027;BA.debugLine="stat_finger=1";
_stat_finger = (int) (1);
 }else {
RDebugUtils.currentLine=46465029;
 //BA.debugLineNum = 46465029;BA.debugLine="lbl_finger.TextColor=0xFF2FFF00";
mostCurrent._lbl_finger.setTextColor(((int)0xff2fff00));
RDebugUtils.currentLine=46465030;
 //BA.debugLineNum = 46465030;BA.debugLine="stat_finger=0";
_stat_finger = (int) (0);
 };
RDebugUtils.currentLine=46465032;
 //BA.debugLineNum = 46465032;BA.debugLine="End Sub";
return "";
}
public static String  _tim_msg_newyear_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_msg_newyear_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_msg_newyear_tick", null));}
RDebugUtils.currentLine=45678592;
 //BA.debugLineNum = 45678592;BA.debugLine="Sub tim_msg_newYear_Tick";
RDebugUtils.currentLine=45678593;
 //BA.debugLineNum = 45678593;BA.debugLine="pan_all_msgNewYear.Visible=True";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=45678595;
 //BA.debugLineNum = 45678595;BA.debugLine="tim_msg_newYear.Enabled=False";
_tim_msg_newyear.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=45678596;
 //BA.debugLineNum = 45678596;BA.debugLine="End Sub";
return "";
}
public static String  _tim_msg_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_msg_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_msg_tick", null));}
String _msg_key = "";
String _msg_value = "";
RDebugUtils.currentLine=46006272;
 //BA.debugLineNum = 46006272;BA.debugLine="Sub tim_msg_Tick";
RDebugUtils.currentLine=46006274;
 //BA.debugLineNum = 46006274;BA.debugLine="Dim msg_key As String";
_msg_key = "";
RDebugUtils.currentLine=46006275;
 //BA.debugLineNum = 46006275;BA.debugLine="Dim msg_value As String";
_msg_value = "";
RDebugUtils.currentLine=46006278;
 //BA.debugLineNum = 46006278;BA.debugLine="msg_key=msg.SubString2(0,4)";
_msg_key = mostCurrent._msg.substring((int) (0),(int) (4));
RDebugUtils.currentLine=46006279;
 //BA.debugLineNum = 46006279;BA.debugLine="msg_value=msg.SubString(5)";
_msg_value = mostCurrent._msg.substring((int) (5));
RDebugUtils.currentLine=46006281;
 //BA.debugLineNum = 46006281;BA.debugLine="ls1.Add(msg_key)";
mostCurrent._ls1.Add((Object)(_msg_key));
RDebugUtils.currentLine=46006282;
 //BA.debugLineNum = 46006282;BA.debugLine="ls2.Add(msg_value)";
mostCurrent._ls2.Add((Object)(_msg_value));
RDebugUtils.currentLine=46006283;
 //BA.debugLineNum = 46006283;BA.debugLine="ls3.Add(lbl_date_home.Text)";
mostCurrent._ls3.Add((Object)(mostCurrent._lbl_date_home.getText()));
RDebugUtils.currentLine=46006285;
 //BA.debugLineNum = 46006285;BA.debugLine="File.WriteList(File.DirInternal,\"ls1\",ls1)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1",mostCurrent._ls1);
RDebugUtils.currentLine=46006286;
 //BA.debugLineNum = 46006286;BA.debugLine="File.WriteList(File.DirInternal,\"ls2\",ls2)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls2",mostCurrent._ls2);
RDebugUtils.currentLine=46006287;
 //BA.debugLineNum = 46006287;BA.debugLine="File.WriteList(File.DirInternal,\"ls3\",ls3)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls3",mostCurrent._ls3);
RDebugUtils.currentLine=46006289;
 //BA.debugLineNum = 46006289;BA.debugLine="lbl_title_msgPan.Text=\"پیام جدید\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام جدید"));
RDebugUtils.currentLine=46006290;
 //BA.debugLineNum = 46006290;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=46006292;
 //BA.debugLineNum = 46006292;BA.debugLine="pan_notif.Top=20%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA));
RDebugUtils.currentLine=46006293;
 //BA.debugLineNum = 46006293;BA.debugLine="pan_notif.Height=50%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA));
RDebugUtils.currentLine=46006294;
 //BA.debugLineNum = 46006294;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
RDebugUtils.currentLine=46006297;
 //BA.debugLineNum = 46006297;BA.debugLine="web_msg_show.LoadHtml(\"<!DOCTYPE html><html><meta";
mostCurrent._web_msg_show.LoadHtml("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'><div style='background-color: #99ffff; font-size: 14px;'>"+"کد پیام : "+_msg_key+" - مورخ : "+mostCurrent._lbl_date_home.getText()+"</div><div style='background-color: #e6ffff; font-size: 18px;'><br>"+_msg_value+"<br></div><br></body></html>");
RDebugUtils.currentLine=46006299;
 //BA.debugLineNum = 46006299;BA.debugLine="tim_msg.Enabled=False";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46006300;
 //BA.debugLineNum = 46006300;BA.debugLine="End Sub";
return "";
}
public static int  _tim_vorod_conv_ezaf(String _tim1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_vorod_conv_ezaf", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "tim_vorod_conv_ezaf", new Object[] {_tim1}));}
String[] _ste_tim = null;
RDebugUtils.currentLine=53936128;
 //BA.debugLineNum = 53936128;BA.debugLine="Sub tim_vorod_conv_ezaf (tim1 As String) As Int";
RDebugUtils.currentLine=53936130;
 //BA.debugLineNum = 53936130;BA.debugLine="Dim ste_tim() As String";
_ste_tim = new String[(int) (0)];
java.util.Arrays.fill(_ste_tim,"");
RDebugUtils.currentLine=53936131;
 //BA.debugLineNum = 53936131;BA.debugLine="ste_tim=Regex.Split(\":\",tim1)";
_ste_tim = anywheresoftware.b4a.keywords.Common.Regex.Split(":",_tim1);
RDebugUtils.currentLine=53936134;
 //BA.debugLineNum = 53936134;BA.debugLine="Return (ste_tim(0)*60)+ste_tim(1) +saat_kar_min";
if (true) return (int) (((double)(Double.parseDouble(_ste_tim[(int) (0)]))*60)+(double)(Double.parseDouble(_ste_tim[(int) (1)]))+_saat_kar_min);
RDebugUtils.currentLine=53936137;
 //BA.debugLineNum = 53936137;BA.debugLine="End Sub";
return 0;
}
public static String  _timer1_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "timer1_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "timer1_tick", null));}
anywheresoftware.b4a.objects.collections.List _ls_lock0 = null;
RDebugUtils.currentLine=46399488;
 //BA.debugLineNum = 46399488;BA.debugLine="Sub timer1_Tick";
RDebugUtils.currentLine=46399490;
 //BA.debugLineNum = 46399490;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=46399491;
 //BA.debugLineNum = 46399491;BA.debugLine="timer1.Enabled=False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46399492;
 //BA.debugLineNum = 46399492;BA.debugLine="cv_loader.Hide";
mostCurrent._cv_loader._hide /*String*/ (null);
RDebugUtils.currentLine=46399493;
 //BA.debugLineNum = 46399493;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
RDebugUtils.currentLine=46399499;
 //BA.debugLineNum = 46399499;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=True)T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=46399500;
 //BA.debugLineNum = 46399500;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=46399501;
 //BA.debugLineNum = 46399501;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
RDebugUtils.currentLine=46399502;
 //BA.debugLineNum = 46399502;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_lock";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
RDebugUtils.currentLine=46399504;
 //BA.debugLineNum = 46399504;BA.debugLine="If(ls_lock0.Get(0)=\"true\")Then";
if (((_ls_lock0.Get((int) (0))).equals((Object)("true")))) { 
RDebugUtils.currentLine=46399505;
 //BA.debugLineNum = 46399505;BA.debugLine="Master_Password=ls_lock0.Get(2)";
mostCurrent._master_password = BA.ObjectToString(_ls_lock0.Get((int) (2)));
RDebugUtils.currentLine=46399506;
 //BA.debugLineNum = 46399506;BA.debugLine="pan_lock.Visible=True";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=46399507;
 //BA.debugLineNum = 46399507;BA.debugLine="lbl_hint_lock.Text=ls_lock0.Get(3)";
mostCurrent._lbl_hint_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (3))));
RDebugUtils.currentLine=46399509;
 //BA.debugLineNum = 46399509;BA.debugLine="If(ls_lock0.Get(1)=\"true\")Then";
if (((_ls_lock0.Get((int) (1))).equals((Object)("true")))) { 
RDebugUtils.currentLine=46399511;
 //BA.debugLineNum = 46399511;BA.debugLine="tim_lock_lbl.Initialize(\"tim_lock_lbl\",500)";
_tim_lock_lbl.Initialize(processBA,"tim_lock_lbl",(long) (500));
RDebugUtils.currentLine=46399512;
 //BA.debugLineNum = 46399512;BA.debugLine="Try";
try {RDebugUtils.currentLine=46399513;
 //BA.debugLineNum = 46399513;BA.debugLine="fingerprint.Initialize (Me, \"auth\")";
mostCurrent._fingerprint._initialize /*String*/ (null,processBA,main.getObject(),"auth");
RDebugUtils.currentLine=46399516;
 //BA.debugLineNum = 46399516;BA.debugLine="If fingerprint.HardwareDetected = False Then";
if (mostCurrent._fingerprint._gethardwaredetected /*boolean*/ (null)==anywheresoftware.b4a.keywords.Common.False) { 
 }else 
{RDebugUtils.currentLine=46399519;
 //BA.debugLineNum = 46399519;BA.debugLine="Else if fingerprint.HasEnrolledFingerprints =";
if (mostCurrent._fingerprint._gethasenrolledfingerprints /*boolean*/ (null)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=46399520;
 //BA.debugLineNum = 46399520;BA.debugLine="ToastMessageShow(\"اثر انگشت تعریف نشده است\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اثر انگشت تعریف نشده است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=46399522;
 //BA.debugLineNum = 46399522;BA.debugLine="lbl_finger.Visible=True";
mostCurrent._lbl_finger.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=46399523;
 //BA.debugLineNum = 46399523;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
mostCurrent._lbl_finger.setTextColor(((int)0xff0b6200));
RDebugUtils.currentLine=46399524;
 //BA.debugLineNum = 46399524;BA.debugLine="finger_scaning";
_finger_scaning();
RDebugUtils.currentLine=46399525;
 //BA.debugLineNum = 46399525;BA.debugLine="tim_lock_lbl.Enabled=True";
_tim_lock_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }}
;
 } 
       catch (Exception e27) {
			processBA.setLastException(e27);RDebugUtils.currentLine=46399529;
 //BA.debugLineNum = 46399529;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("246399529",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
 };
 }else {
RDebugUtils.currentLine=46399536;
 //BA.debugLineNum = 46399536;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=46399543;
 //BA.debugLineNum = 46399543;BA.debugLine="End Sub";
return "";
}
}