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
vis = vis | (info_activity.mostCurrent != null);
vis = vis | (morakhasi_activity.mostCurrent != null);
vis = vis | (mosaedeh_activity.mostCurrent != null);
vis = vis | (padash_activity.mostCurrent != null);
vis = vis | (payankar_activity.mostCurrent != null);
vis = vis | (sabt2_activity.mostCurrent != null);
vis = vis | (savabeg_activity.mostCurrent != null);
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
            if (savabeg_activity.previousOne != null) {
				__a = savabeg_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(savabeg_activity.mostCurrent == null ? null : savabeg_activity.mostCurrent.processBA);
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

}
public anywheresoftware.b4a.keywords.Common __c = null;
public static String _app_vesion = "";
public static anywheresoftware.b4a.objects.Timer _timer1 = null;
public static anywheresoftware.b4a.objects.Timer _tim_msg = null;
public static anywheresoftware.b4a.objects.Timer _tim_lock_lbl = null;
public static anywheresoftware.b4a.objects.Timer _tim_msg_newyear = null;
public static anywheresoftware.b4a.objects.Timer _tim_check_update = null;
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
public static int _backup_page_show = 0;
public static String _current_idvam = "";
public static boolean _is_first_time = false;
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
public ir.cafebazaar.poolakey.b4a.B4APayment _poolakey = null;
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
public static boolean _is_time_backup = false;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radio_ez_fog = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radio_ez_adi = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_finger_khoroj = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_finger_vorod = null;
public static boolean _user_request_update = false;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_setting_date = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_setting_date = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _ckb_setting_date_finger = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_finger_taradod = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_finger_fs_vorod = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_finger_fs_khoroj = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_finger_fs_vorod_time = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_finger_fs_khoroj_time = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_time_show_fs = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_ezaf_taradod_fs = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _ckb_ezaf_taradod_fs = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_save_box = null;
public static boolean _save_box_allow = false;
public static int _state_tatil = 0;
public static int _day_inweek_id = 0;
public static String _day_inweek_name = "";
public static int _state_tatil_setting = 0;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _ckb_tatil_rasmi = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _ckb_tatil_garardadi = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_tatil_show = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview_sett_taradod = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_saat_kari0 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_min_kari0 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_saat_kari1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_min_kari1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_min_kari2 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_saat_kari2 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_saat_kari3 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_min_kari3 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_min_kari4 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_saat_kari4 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_saat_kari5 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_min_kari5 = null;
public static String _notif_code = "";
public static String _notif_matn = "";
public b4a.example.dateutils _dateutils = null;
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
try {RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="Poolakey.Initialize _ .EnableSecurityCheck(key)";
mostCurrent._poolakey.Initialize().EnableSecurityCheck(mostCurrent._key).Build(processBA);
 } 
       catch (Exception e4) {
			processBA.setLastException(e4);RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("6131091",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="If(FirstTime=True)Then";
if ((_firsttime==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=131095;
 //BA.debugLineNum = 131095;BA.debugLine="dbCode.cheng_tagvim2";
mostCurrent._dbcode._cheng_tagvim2 /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=131096;
 //BA.debugLineNum = 131096;BA.debugLine="dbCode.check_old_adds";
mostCurrent._dbcode._check_old_adds /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="dbCode.install_db_tbl_myCalander";
mostCurrent._dbcode._install_db_tbl_mycalander /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="dbCode.check_new_add";
mostCurrent._dbcode._check_new_add /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=131100;
 //BA.debugLineNum = 131100;BA.debugLine="dbCode.init_notfound(\"hag_hamsar\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"hag_hamsar",BA.NumberToString(0));
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="dbCode.init_notfound_onvanha(14,\"hamsar\",\"حق تأه";
mostCurrent._dbcode._init_notfound_onvanha /*String*/ (mostCurrent.activityBA,(int) (14),"hamsar","حق تأهل");
 };
RDebugUtils.currentLine=131108;
 //BA.debugLineNum = 131108;BA.debugLine="img1.Initialize(LoadBitmap(File.DirAssets,\"m1.png";
mostCurrent._img1.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m1.png").getObject()));
RDebugUtils.currentLine=131109;
 //BA.debugLineNum = 131109;BA.debugLine="img1.Gravity=Gravity.FILL";
mostCurrent._img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=131111;
 //BA.debugLineNum = 131111;BA.debugLine="img2.Initialize(LoadBitmap(File.DirAssets,\"m2.png";
mostCurrent._img2.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m2.png").getObject()));
RDebugUtils.currentLine=131112;
 //BA.debugLineNum = 131112;BA.debugLine="img2.Gravity=Gravity.FILL";
mostCurrent._img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=131114;
 //BA.debugLineNum = 131114;BA.debugLine="img3.Initialize(LoadBitmap(File.DirAssets,\"m3.png";
mostCurrent._img3.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m3.png").getObject()));
RDebugUtils.currentLine=131115;
 //BA.debugLineNum = 131115;BA.debugLine="img3.Gravity=Gravity.FILL";
mostCurrent._img3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=131117;
 //BA.debugLineNum = 131117;BA.debugLine="If(FirstTime)Then";
if ((_firsttime)) { 
RDebugUtils.currentLine=131118;
 //BA.debugLineNum = 131118;BA.debugLine="Activity.LoadLayout(\"splash_layout\")";
mostCurrent._activity.LoadLayout("splash_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131119;
 //BA.debugLineNum = 131119;BA.debugLine="lbl_vesion_app.Text=app_vesion";
mostCurrent._lbl_vesion_app.setText(BA.ObjectToCharSequence(_app_vesion));
RDebugUtils.currentLine=131120;
 //BA.debugLineNum = 131120;BA.debugLine="cv_loader.Show";
mostCurrent._cv_loader._show /*String*/ (null);
RDebugUtils.currentLine=131121;
 //BA.debugLineNum = 131121;BA.debugLine="timer1.Initialize(\"timer1\" , 1500)";
_timer1.Initialize(processBA,"timer1",(long) (1500));
RDebugUtils.currentLine=131123;
 //BA.debugLineNum = 131123;BA.debugLine="timer1.Enabled=True";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131124;
 //BA.debugLineNum = 131124;BA.debugLine="is_first_time=True";
_is_first_time = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=131126;
 //BA.debugLineNum = 131126;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131127;
 //BA.debugLineNum = 131127;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
RDebugUtils.currentLine=131128;
 //BA.debugLineNum = 131128;BA.debugLine="is_first_time=False";
_is_first_time = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=131133;
 //BA.debugLineNum = 131133;BA.debugLine="moon.Initialize";
mostCurrent._moon.Initialize();
RDebugUtils.currentLine=131134;
 //BA.debugLineNum = 131134;BA.debugLine="moon.AddAll(Array As String(\"فروردین\", \"اردیبهشت\"";
mostCurrent._moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=131137;
 //BA.debugLineNum = 131137;BA.debugLine="strfun.Initialize";
mostCurrent._strfun._initialize(processBA);
RDebugUtils.currentLine=131141;
 //BA.debugLineNum = 131141;BA.debugLine="If(buy_index=1)Then";
if ((_buy_index==1)) { 
RDebugUtils.currentLine=131142;
 //BA.debugLineNum = 131142;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
RDebugUtils.currentLine=131143;
 //BA.debugLineNum = 131143;BA.debugLine="buy_index=0";
_buy_index = (int) (0);
 };
RDebugUtils.currentLine=131149;
 //BA.debugLineNum = 131149;BA.debugLine="tim_msg.Initialize(\"tim_msg\",4000)";
_tim_msg.Initialize(processBA,"tim_msg",(long) (4000));
RDebugUtils.currentLine=131151;
 //BA.debugLineNum = 131151;BA.debugLine="ls1.Initialize";
mostCurrent._ls1.Initialize();
RDebugUtils.currentLine=131152;
 //BA.debugLineNum = 131152;BA.debugLine="ls2.Initialize";
mostCurrent._ls2.Initialize();
RDebugUtils.currentLine=131153;
 //BA.debugLineNum = 131153;BA.debugLine="ls3.Initialize";
mostCurrent._ls3.Initialize();
RDebugUtils.currentLine=131156;
 //BA.debugLineNum = 131156;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1"))) { 
RDebugUtils.currentLine=131157;
 //BA.debugLineNum = 131157;BA.debugLine="ls1=File.ReadList(File.DirInternal,\"ls1\")";
mostCurrent._ls1 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1");
RDebugUtils.currentLine=131158;
 //BA.debugLineNum = 131158;BA.debugLine="ls2=File.ReadList(File.DirInternal,\"ls2\")";
mostCurrent._ls2 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls2");
RDebugUtils.currentLine=131159;
 //BA.debugLineNum = 131159;BA.debugLine="ls3=File.ReadList(File.DirInternal,\"ls3\")";
mostCurrent._ls3 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls3");
RDebugUtils.currentLine=131161;
 //BA.debugLineNum = 131161;BA.debugLine="last_notif=ls1.Get(ls1.Size-1)";
mostCurrent._last_notif = BA.ObjectToString(mostCurrent._ls1.Get((int) (mostCurrent._ls1.getSize()-1)));
RDebugUtils.currentLine=131162;
 //BA.debugLineNum = 131162;BA.debugLine="is_now_instal=False";
_is_now_instal = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=131168;
 //BA.debugLineNum = 131168;BA.debugLine="If(FirstTime=True)Then";
if ((_firsttime==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=131169;
 //BA.debugLineNum = 131169;BA.debugLine="If(myfunc.check_karid=True)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=131170;
 //BA.debugLineNum = 131170;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
 }else {
RDebugUtils.currentLine=131172;
 //BA.debugLineNum = 131172;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
 };
 };
RDebugUtils.currentLine=131191;
 //BA.debugLineNum = 131191;BA.debugLine="If(File.Exists(File.DirInternal,\"phonNum\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum"))) { 
RDebugUtils.currentLine=131192;
 //BA.debugLineNum = 131192;BA.debugLine="phon_num=File.ReadString(File.DirInternal,\"phonN";
_phon_num = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum");
 };
RDebugUtils.currentLine=131195;
 //BA.debugLineNum = 131195;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc"))) { 
RDebugUtils.currentLine=131196;
 //BA.debugLineNum = 131196;BA.debugLine="Dim ls_user As List";
_ls_user = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=131197;
 //BA.debugLineNum = 131197;BA.debugLine="ls_user.Initialize";
_ls_user.Initialize();
RDebugUtils.currentLine=131198;
 //BA.debugLineNum = 131198;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAcc\"";
_ls_user = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
RDebugUtils.currentLine=131199;
 //BA.debugLineNum = 131199;BA.debugLine="user_nameFamili=ls_user.Get(0)";
_user_namefamili = BA.ObjectToString(_ls_user.Get((int) (0)));
 };
RDebugUtils.currentLine=131203;
 //BA.debugLineNum = 131203;BA.debugLine="If(FirstTime=True)Then";
if ((_firsttime==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=131204;
 //BA.debugLineNum = 131204;BA.debugLine="tim_check_update.Initialize(\"tim_check_update\",9";
_tim_check_update.Initialize(processBA,"tim_check_update",(long) (9000));
RDebugUtils.currentLine=131205;
 //BA.debugLineNum = 131205;BA.debugLine="tim_check_update.Enabled=True";
_tim_check_update.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=131208;
 //BA.debugLineNum = 131208;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Private Sub btn_menu_home_Click";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="index_page=1";
_index_page = (int) (1);
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="pan_imag.Background=img1";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img1.getObject()));
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
RDebugUtils.currentLine=2752518;
 //BA.debugLineNum = 2752518;BA.debugLine="pan_main.LoadLayout(\"home_layout\")";
mostCurrent._pan_main.LoadLayout("home_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=2752519;
 //BA.debugLineNum = 2752519;BA.debugLine="scv_home_item.Panel.LoadLayout(\"home_item\")";
mostCurrent._scv_home_item.getPanel().LoadLayout("home_item",mostCurrent.activityBA);
RDebugUtils.currentLine=2752524;
 //BA.debugLineNum = 2752524;BA.debugLine="lbl_date_home.Text=myfunc.fa2en(persianDate.Persi";
mostCurrent._lbl_date_home.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianLongDate())));
RDebugUtils.currentLine=2752526;
 //BA.debugLineNum = 2752526;BA.debugLine="saat_kar_min =dbCode.get_setting_byName(\"saat_kar";
_saat_kar_min = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_darRoz")));
RDebugUtils.currentLine=2752528;
 //BA.debugLineNum = 2752528;BA.debugLine="If(saat_kar_min<18)Then";
if ((_saat_kar_min<18)) { 
RDebugUtils.currentLine=2752529;
 //BA.debugLineNum = 2752529;BA.debugLine="myfunc.help_man(\"توجه\",\"لطفا ساعت کاری خود را در";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","لطفا ساعت کاری خود را در صفحه ثبت اطلاعات حقوق تنظیم کنید");
 };
RDebugUtils.currentLine=2752532;
 //BA.debugLineNum = 2752532;BA.debugLine="Dim list_ezafekari As List";
_list_ezafekari = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2752533;
 //BA.debugLineNum = 2752533;BA.debugLine="list_ezafekari.Initialize";
_list_ezafekari.Initialize();
RDebugUtils.currentLine=2752535;
 //BA.debugLineNum = 2752535;BA.debugLine="year_num=myfunc.fa2en(persianDate.PersianYear)";
_year_num = mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()));
RDebugUtils.currentLine=2752537;
 //BA.debugLineNum = 2752537;BA.debugLine="moon_num=myfunc.convert_adad(persianDate.PersianM";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_persiandate.getPersianMonth());
RDebugUtils.currentLine=2752539;
 //BA.debugLineNum = 2752539;BA.debugLine="list_ezafekari=dbCode.all_ezafekari_mah(year_num,";
_list_ezafekari = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num,(int) (1));
RDebugUtils.currentLine=2752545;
 //BA.debugLineNum = 2752545;BA.debugLine="Dim list_morakhasi As List";
_list_morakhasi = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2752546;
 //BA.debugLineNum = 2752546;BA.debugLine="list_morakhasi.Initialize";
_list_morakhasi.Initialize();
RDebugUtils.currentLine=2752548;
 //BA.debugLineNum = 2752548;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(year_num,";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num);
RDebugUtils.currentLine=2752551;
 //BA.debugLineNum = 2752551;BA.debugLine="lbl_ezafekari_mah_m.Text=list_ezafekari.Get(1)&\"";
mostCurrent._lbl_ezafekari_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (1)))+" دقیقه "));
RDebugUtils.currentLine=2752552;
 //BA.debugLineNum = 2752552;BA.debugLine="lbl_ezafekari_mah_h.Text=list_ezafekari.Get(0)&\"";
mostCurrent._lbl_ezafekari_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (0)))+" ساعت "));
RDebugUtils.currentLine=2752554;
 //BA.debugLineNum = 2752554;BA.debugLine="lbl_morakhasi_mah_m.Text=list_morakhasi.Get(2)&\"";
mostCurrent._lbl_morakhasi_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (2)))+" دقیقه "));
RDebugUtils.currentLine=2752555;
 //BA.debugLineNum = 2752555;BA.debugLine="lbl_morakhasi_mah_h.Text=list_morakhasi.Get(1)&\"";
mostCurrent._lbl_morakhasi_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (1)))+" ساعت "));
RDebugUtils.currentLine=2752556;
 //BA.debugLineNum = 2752556;BA.debugLine="lbl_morakhasi_mah_d.Text=list_morakhasi.Get(0)&\"";
mostCurrent._lbl_morakhasi_mah_d.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (0)))+" روز "));
RDebugUtils.currentLine=2752558;
 //BA.debugLineNum = 2752558;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=2752560;
 //BA.debugLineNum = 2752560;BA.debugLine="lbl_vip.TextColor=0xFFFFD800";
mostCurrent._lbl_vip.setTextColor(((int)0xffffd800));
RDebugUtils.currentLine=2752561;
 //BA.debugLineNum = 2752561;BA.debugLine="lbl_vip2.Text=\"نسخه طلایی\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه طلایی"));
 }else {
RDebugUtils.currentLine=2752564;
 //BA.debugLineNum = 2752564;BA.debugLine="lbl_vip.TextColor=Colors.Green";
mostCurrent._lbl_vip.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=2752565;
 //BA.debugLineNum = 2752565;BA.debugLine="lbl_vip2.Text=\"نسخه هدیه\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه هدیه"));
 };
RDebugUtils.currentLine=2752570;
 //BA.debugLineNum = 2752570;BA.debugLine="If (File.Exists(File.DirInternal,\"help_start\")=Fa";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=2752571;
 //BA.debugLineNum = 2752571;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=2752572;
 //BA.debugLineNum = 2752572;BA.debugLine="File.WriteString(File.DirInternal,\"help_start\",\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start","");
 };
RDebugUtils.currentLine=2752578;
 //BA.debugLineNum = 2752578;BA.debugLine="If (File.Exists(File.DirInternal,\"setcolor.txt\"))";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt"))) { 
RDebugUtils.currentLine=2752579;
 //BA.debugLineNum = 2752579;BA.debugLine="Dim list_color As List";
_list_color = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2752580;
 //BA.debugLineNum = 2752580;BA.debugLine="list_color.Initialize";
_list_color.Initialize();
RDebugUtils.currentLine=2752581;
 //BA.debugLineNum = 2752581;BA.debugLine="list_color = File.ReadList(File.DirInternal,\"set";
_list_color = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt");
RDebugUtils.currentLine=2752583;
 //BA.debugLineNum = 2752583;BA.debugLine="Dim col As List";
_col = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2752584;
 //BA.debugLineNum = 2752584;BA.debugLine="col.Initialize";
_col.Initialize();
RDebugUtils.currentLine=2752586;
 //BA.debugLineNum = 2752586;BA.debugLine="Dim col_font As List";
_col_font = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2752587;
 //BA.debugLineNum = 2752587;BA.debugLine="col_font.Initialize";
_col_font.Initialize();
RDebugUtils.currentLine=2752589;
 //BA.debugLineNum = 2752589;BA.debugLine="col=Regex.Split(\",\",list_color.Get(0))";
_col = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (0)))));
RDebugUtils.currentLine=2752590;
 //BA.debugLineNum = 2752590;BA.debugLine="col_font=Regex.Split(\",\",list_color.Get(1))";
_col_font = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (1)))));
RDebugUtils.currentLine=2752594;
 //BA.debugLineNum = 2752594;BA.debugLine="color1= col.Get(0)";
_color1 = (int)(BA.ObjectToNumber(_col.Get((int) (0))));
RDebugUtils.currentLine=2752595;
 //BA.debugLineNum = 2752595;BA.debugLine="color2= col.Get(1)";
_color2 = (int)(BA.ObjectToNumber(_col.Get((int) (1))));
RDebugUtils.currentLine=2752596;
 //BA.debugLineNum = 2752596;BA.debugLine="color_index=col.Get(2)  'index color";
_color_index = (int)(BA.ObjectToNumber(_col.Get((int) (2))));
RDebugUtils.currentLine=2752597;
 //BA.debugLineNum = 2752597;BA.debugLine="color3= col.Get(3)";
_color3 = (int)(BA.ObjectToNumber(_col.Get((int) (3))));
RDebugUtils.currentLine=2752598;
 //BA.debugLineNum = 2752598;BA.debugLine="color4= col.Get(4)";
_color4 = (int)(BA.ObjectToNumber(_col.Get((int) (4))));
RDebugUtils.currentLine=2752599;
 //BA.debugLineNum = 2752599;BA.debugLine="color5= col.Get(5)";
_color5 = (int)(BA.ObjectToNumber(_col.Get((int) (5))));
RDebugUtils.currentLine=2752601;
 //BA.debugLineNum = 2752601;BA.debugLine="main_font=col_font.Get(0)";
_main_font = BA.ObjectToString(_col_font.Get((int) (0)));
RDebugUtils.currentLine=2752602;
 //BA.debugLineNum = 2752602;BA.debugLine="size_f1=col_font.Get(1)";
_size_f1 = (int)(BA.ObjectToNumber(_col_font.Get((int) (1))));
RDebugUtils.currentLine=2752603;
 //BA.debugLineNum = 2752603;BA.debugLine="size_f2=col_font.Get(2)";
_size_f2 = (int)(BA.ObjectToNumber(_col_font.Get((int) (2))));
RDebugUtils.currentLine=2752604;
 //BA.debugLineNum = 2752604;BA.debugLine="size_f3=col_font.Get(3)";
_size_f3 = (int)(BA.ObjectToNumber(_col_font.Get((int) (3))));
 }else {
RDebugUtils.currentLine=2752608;
 //BA.debugLineNum = 2752608;BA.debugLine="color_index=1";
_color_index = (int) (1);
RDebugUtils.currentLine=2752609;
 //BA.debugLineNum = 2752609;BA.debugLine="color1= 0XFF69AC00";
_color1 = ((int)0xff69ac00);
RDebugUtils.currentLine=2752610;
 //BA.debugLineNum = 2752610;BA.debugLine="color2= 0xFF00C7C7";
_color2 = ((int)0xff00c7c7);
RDebugUtils.currentLine=2752611;
 //BA.debugLineNum = 2752611;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=2752612;
 //BA.debugLineNum = 2752612;BA.debugLine="color4=0XFF69AC00";
_color4 = ((int)0xff69ac00);
RDebugUtils.currentLine=2752613;
 //BA.debugLineNum = 2752613;BA.debugLine="color5=0XFF69AC00";
_color5 = ((int)0xff69ac00);
RDebugUtils.currentLine=2752615;
 //BA.debugLineNum = 2752615;BA.debugLine="main_font=\"یکان\"";
_main_font = "یکان";
RDebugUtils.currentLine=2752616;
 //BA.debugLineNum = 2752616;BA.debugLine="size_f1=17";
_size_f1 = (int) (17);
RDebugUtils.currentLine=2752617;
 //BA.debugLineNum = 2752617;BA.debugLine="size_f2=15";
_size_f2 = (int) (15);
RDebugUtils.currentLine=2752618;
 //BA.debugLineNum = 2752618;BA.debugLine="size_f3=13";
_size_f3 = (int) (13);
RDebugUtils.currentLine=2752621;
 //BA.debugLineNum = 2752621;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(_color1)+","+BA.NumberToString(_color2)+","+BA.NumberToString(_color_index)+","+BA.NumberToString(_color3)+","+BA.NumberToString(_color4)+","+BA.NumberToString(_color5)+anywheresoftware.b4a.keywords.Common.CRLF+_main_font+","+BA.NumberToString(_size_f1)+","+BA.NumberToString(_size_f2)+","+BA.NumberToString(_size_f3));
 };
RDebugUtils.currentLine=2752629;
 //BA.debugLineNum = 2752629;BA.debugLine="Dim dw As GradientDrawable";
_dw = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=2752630;
 //BA.debugLineNum = 2752630;BA.debugLine="Dim clr() As Int = Array  As Int(color1,color2)";
_clr = new int[]{_color1,_color2};
RDebugUtils.currentLine=2752631;
 //BA.debugLineNum = 2752631;BA.debugLine="dw.Initialize(\"TOP_BOTTOM\",clr)";
_dw.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clr);
RDebugUtils.currentLine=2752632;
 //BA.debugLineNum = 2752632;BA.debugLine="dw.CornerRadius=50dip";
_dw.setCornerRadius((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))));
RDebugUtils.currentLine=2752633;
 //BA.debugLineNum = 2752633;BA.debugLine="Panel1.Background=dw";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_dw.getObject()));
RDebugUtils.currentLine=2752641;
 //BA.debugLineNum = 2752641;BA.debugLine="lbl_box_title.Color=color4";
mostCurrent._lbl_box_title.setColor(_color4);
RDebugUtils.currentLine=2752650;
 //BA.debugLineNum = 2752650;BA.debugLine="get_today_shift";
_get_today_shift();
RDebugUtils.currentLine=2752657;
 //BA.debugLineNum = 2752657;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=2752660;
 //BA.debugLineNum = 2752660;BA.debugLine="If(is_first_time=True)Then";
if ((_is_first_time==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=2752661;
 //BA.debugLineNum = 2752661;BA.debugLine="chek_time_backup";
_chek_time_backup();
 };
RDebugUtils.currentLine=2752665;
 //BA.debugLineNum = 2752665;BA.debugLine="If(is_new_msg=True And is_first_time=True)Then";
if ((_is_new_msg==anywheresoftware.b4a.keywords.Common.True && _is_first_time==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=2752666;
 //BA.debugLineNum = 2752666;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=2752667;
 //BA.debugLineNum = 2752667;BA.debugLine="result = Msgbox2(\"آیا الان مشاهده میکنید؟\", \"پیا";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا الان مشاهده میکنید؟"),BA.ObjectToCharSequence("پیام جدید"),"بله","بعدا","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"notif.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=2752668;
 //BA.debugLineNum = 2752668;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=2752669;
 //BA.debugLineNum = 2752669;BA.debugLine="lbl_account_Click";
_lbl_account_click();
RDebugUtils.currentLine=2752670;
 //BA.debugLineNum = 2752670;BA.debugLine="msg_page_show=1";
_msg_page_show = (int) (1);
 };
RDebugUtils.currentLine=2752672;
 //BA.debugLineNum = 2752672;BA.debugLine="is_first_time=False";
_is_first_time = anywheresoftware.b4a.keywords.Common.False;
 }else 
{RDebugUtils.currentLine=2752673;
 //BA.debugLineNum = 2752673;BA.debugLine="else If(is_time_backup=True And is_first_time=Tru";
if ((_is_time_backup==anywheresoftware.b4a.keywords.Common.True && _is_first_time==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=2752674;
 //BA.debugLineNum = 2752674;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=2752675;
 //BA.debugLineNum = 2752675;BA.debugLine="result = Msgbox2(\"پشتیبان گیری از داده ها انجام";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("پشتیبان گیری از داده ها انجام گردد؟"),BA.ObjectToCharSequence("یاد آور پشتیبان گیری"),"بله","بعدا","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"notif.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=2752676;
 //BA.debugLineNum = 2752676;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=2752677;
 //BA.debugLineNum = 2752677;BA.debugLine="lbl_account_Click";
_lbl_account_click();
RDebugUtils.currentLine=2752678;
 //BA.debugLineNum = 2752678;BA.debugLine="backup_page_show=1";
_backup_page_show = (int) (1);
 };
RDebugUtils.currentLine=2752681;
 //BA.debugLineNum = 2752681;BA.debugLine="is_first_time=False";
_is_first_time = anywheresoftware.b4a.keywords.Common.False;
 }}
;
RDebugUtils.currentLine=2752688;
 //BA.debugLineNum = 2752688;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip_click", null));}
RDebugUtils.currentLine=7012352;
 //BA.debugLineNum = 7012352;BA.debugLine="Private Sub lbl_vip_Click";
RDebugUtils.currentLine=7012354;
 //BA.debugLineNum = 7012354;BA.debugLine="pan_all_noskhe.Visible=True";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7012355;
 //BA.debugLineNum = 7012355;BA.debugLine="scroll_v_noskhe.Panel.LoadLayout(\"noske_item\")";
mostCurrent._scroll_v_noskhe.getPanel().LoadLayout("noske_item",mostCurrent.activityBA);
RDebugUtils.currentLine=7012358;
 //BA.debugLineNum = 7012358;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=7012359;
 //BA.debugLineNum = 7012359;BA.debugLine="lbl_show_vip.Text=\"نسخه کامل ( طلایی ) فعال می ب";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه کامل ( طلایی ) فعال می باشد."));
 }else {
RDebugUtils.currentLine=7012361;
 //BA.debugLineNum = 7012361;BA.debugLine="lbl_show_vip.Text=\"نسخه معمولی ( هدیه ) فعال می";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه معمولی ( هدیه ) فعال می باشد."));
 };
RDebugUtils.currentLine=7012364;
 //BA.debugLineNum = 7012364;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "http_initial_1", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "http_initial_1", new Object[] {_type1}));}
String _send = "";
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub http_initial_1(type1 As Int)";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="ht.Initialize(\"ht\",Me)";
mostCurrent._ht._initialize /*String*/ (null,processBA,"ht",main.getObject());
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="Dim send As String";
_send = "";
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="send = \"username=mahdisend&password=123pass456&di";
_send = "username=mahdisend&password=123pass456&div_id="+_phon.GetSettings("android_id")+"&sdk_ver="+BA.NumberToString(_phon.getSdkVersion())+"&oprator="+_phon.GetNetworkOperatorName()+"&type_app="+BA.NumberToString(_type1)+"&div_model="+_phon.getModel()+"&last_notif="+mostCurrent._last_notif+"	&is_now_instal="+BA.ObjectToString(_is_now_instal)+"&version_code="+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Application.getVersionCode());
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/ezafekari2";
mostCurrent._ht._poststring /*String*/ (null,"https://taravatgroup.ir/ezafekari2_new.php",_send);
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="Log(\"ht sended\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6655365","ht sended",0);
RDebugUtils.currentLine=655367;
 //BA.debugLineNum = 655367;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
int _result = 0;
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="If (pan_all_msgNewYear.Visible=True)Then";
if ((mostCurrent._pan_all_msgnewyear.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=4521989;
 //BA.debugLineNum = 4521989;BA.debugLine="else If (pan_help.Visible=True)Then";
if ((mostCurrent._pan_help.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4521990;
 //BA.debugLineNum = 4521990;BA.debugLine="lbl_close_help_Click";
_lbl_close_help_click();
 }else 
{RDebugUtils.currentLine=4521991;
 //BA.debugLineNum = 4521991;BA.debugLine="Else If (pan_all_setting_date.Visible==True)Then";
if ((mostCurrent._pan_all_setting_date.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4521992;
 //BA.debugLineNum = 4521992;BA.debugLine="pan_all_setting_date.Visible=False";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=4521993;
 //BA.debugLineNum = 4521993;BA.debugLine="Else If (pan_all.Visible=True )Then";
if ((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4521995;
 //BA.debugLineNum = 4521995;BA.debugLine="If(pan_all2.Visible=True)Then";
if ((mostCurrent._pan_all2.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4521996;
 //BA.debugLineNum = 4521996;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=4521998;
 //BA.debugLineNum = 4521998;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }else 
{RDebugUtils.currentLine=4522001;
 //BA.debugLineNum = 4522001;BA.debugLine="Else if(pan_notifi_all.Visible==True) Then";
if ((mostCurrent._pan_notifi_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4522002;
 //BA.debugLineNum = 4522002;BA.debugLine="lbl_close_notif_Click";
_lbl_close_notif_click();
 }else 
{RDebugUtils.currentLine=4522003;
 //BA.debugLineNum = 4522003;BA.debugLine="Else If(index_page=2 Or index_page=3)Then";
if ((_index_page==2 || _index_page==3)) { 
RDebugUtils.currentLine=4522004;
 //BA.debugLineNum = 4522004;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 }else 
{RDebugUtils.currentLine=4522005;
 //BA.debugLineNum = 4522005;BA.debugLine="Else If(pan_all_noskhe.Visible==True)Then";
if ((mostCurrent._pan_all_noskhe.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4522006;
 //BA.debugLineNum = 4522006;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
 }else 
{RDebugUtils.currentLine=4522007;
 //BA.debugLineNum = 4522007;BA.debugLine="Else If(pan_all_liteMenu.Visible==True)Then";
if ((mostCurrent._pan_all_litemenu.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4522008;
 //BA.debugLineNum = 4522008;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=4522009;
 //BA.debugLineNum = 4522009;BA.debugLine="Else If (pan_all_chekUpdate.Visible==True)Then";
if ((mostCurrent._pan_all_chekupdate.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4522010;
 //BA.debugLineNum = 4522010;BA.debugLine="pan_all_chekUpdate.Visible=False";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=4522015;
 //BA.debugLineNum = 4522015;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=4522016;
 //BA.debugLineNum = 4522016;BA.debugLine="result = Msgbox2(\"آیا قصد خروج دارید؟\", \"خروج\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا قصد خروج دارید؟"),BA.ObjectToCharSequence("خروج"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=4522017;
 //BA.debugLineNum = 4522017;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=4522018;
 //BA.debugLineNum = 4522018;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=4522019;
 //BA.debugLineNum = 4522019;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 };
 }}}}}}}}}
;
RDebugUtils.currentLine=4522025;
 //BA.debugLineNum = 4522025;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=4522027;
 //BA.debugLineNum = 4522027;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=4522029;
 //BA.debugLineNum = 4522029;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_close_help_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_help_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_help_click", null));}
RDebugUtils.currentLine=7143424;
 //BA.debugLineNum = 7143424;BA.debugLine="Private Sub lbl_close_help_Click";
RDebugUtils.currentLine=7143425;
 //BA.debugLineNum = 7143425;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7143426;
 //BA.debugLineNum = 7143426;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_notif_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_notif_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_notif_click", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Private Sub lbl_close_notif_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="pan_notifi_all.Visible=False";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_noskhe_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_noskhe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_noskhe_click", null));}
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Private Sub pan_all_noskhe_Click";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="pan_all_noskhe.Visible=False";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="If UserClosed Then Poolakey.Connection.Disconnect";
if (_userclosed) { 
mostCurrent._poolakey.getConnection().Disconnect();};
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="End Sub";
return "";
}
public static String  _add_end() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_end", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_end", null));}
boolean _chek = false;
anywheresoftware.b4a.objects.collections.List _alist = null;
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub add_end";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="Dim chek As Boolean";
_chek = false;
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="chek=myfunc.check_karid";
_chek = mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="Dim alist As List";
_alist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="alist.Initialize";
_alist.Initialize();
RDebugUtils.currentLine=4128774;
 //BA.debugLineNum = 4128774;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(myfunc";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth())))));
RDebugUtils.currentLine=4128777;
 //BA.debugLineNum = 4128777;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(persianDate.Pe";
_alist = mostCurrent._myfunc._num_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear())),_moon_num);
RDebugUtils.currentLine=4128780;
 //BA.debugLineNum = 4128780;BA.debugLine="If(index_box=1) Then";
if ((_index_box==1)) { 
RDebugUtils.currentLine=4128781;
 //BA.debugLineNum = 4128781;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=4128782;
 //BA.debugLineNum = 4128782;BA.debugLine="If(alist.Get(0)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (0))))<5)) { 
RDebugUtils.currentLine=4128783;
 //BA.debugLineNum = 4128783;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 }else {
RDebugUtils.currentLine=4128785;
 //BA.debugLineNum = 4128785;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=4128789;
 //BA.debugLineNum = 4128789;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 };
 }else 
{RDebugUtils.currentLine=4128792;
 //BA.debugLineNum = 4128792;BA.debugLine="Else If (index_box=2) Then";
if ((_index_box==2)) { 
RDebugUtils.currentLine=4128794;
 //BA.debugLineNum = 4128794;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=4128795;
 //BA.debugLineNum = 4128795;BA.debugLine="If(alist.Get(1)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (1))))<5)) { 
RDebugUtils.currentLine=4128796;
 //BA.debugLineNum = 4128796;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 }else {
RDebugUtils.currentLine=4128798;
 //BA.debugLineNum = 4128798;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=4128801;
 //BA.debugLineNum = 4128801;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 };
 }else 
{RDebugUtils.currentLine=4128804;
 //BA.debugLineNum = 4128804;BA.debugLine="Else If (index_box=3) Then";
if ((_index_box==3)) { 
RDebugUtils.currentLine=4128806;
 //BA.debugLineNum = 4128806;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=4128807;
 //BA.debugLineNum = 4128807;BA.debugLine="If(alist.Get(3)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (3))))<5)) { 
RDebugUtils.currentLine=4128810;
 //BA.debugLineNum = 4128810;BA.debugLine="Select state_tatil_setting";
switch (_state_tatil_setting) {
case 0: {
RDebugUtils.currentLine=4128812;
 //BA.debugLineNum = 4128812;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 break; }
case 1: {
RDebugUtils.currentLine=4128814;
 //BA.debugLineNum = 4128814;BA.debugLine="If (state_tatil=1 Or state_tatil=2) Then 'ta";
if ((_state_tatil==1 || _state_tatil==2)) { 
RDebugUtils.currentLine=4128815;
 //BA.debugLineNum = 4128815;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
RDebugUtils.currentLine=4128817;
 //BA.debugLineNum = 4128817;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 11: {
RDebugUtils.currentLine=4128822;
 //BA.debugLineNum = 4128822;BA.debugLine="If (state_tatil=1) Then 'tatil rasmi";
if ((_state_tatil==1)) { 
RDebugUtils.currentLine=4128823;
 //BA.debugLineNum = 4128823;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
RDebugUtils.currentLine=4128825;
 //BA.debugLineNum = 4128825;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 22: {
RDebugUtils.currentLine=4128830;
 //BA.debugLineNum = 4128830;BA.debugLine="If (state_tatil=2) Then  'tatil garardadi";
if ((_state_tatil==2)) { 
RDebugUtils.currentLine=4128831;
 //BA.debugLineNum = 4128831;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
RDebugUtils.currentLine=4128833;
 //BA.debugLineNum = 4128833;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
}
;
RDebugUtils.currentLine=4128840;
 //BA.debugLineNum = 4128840;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=4128841;
 //BA.debugLineNum = 4128841;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
 };
 }else {
RDebugUtils.currentLine=4128845;
 //BA.debugLineNum = 4128845;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=4128849;
 //BA.debugLineNum = 4128849;BA.debugLine="Select state_tatil_setting";
switch (_state_tatil_setting) {
case 0: {
RDebugUtils.currentLine=4128851;
 //BA.debugLineNum = 4128851;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 break; }
case 1: {
RDebugUtils.currentLine=4128853;
 //BA.debugLineNum = 4128853;BA.debugLine="If (state_tatil=1 Or state_tatil=2) Then 'tat";
if ((_state_tatil==1 || _state_tatil==2)) { 
RDebugUtils.currentLine=4128854;
 //BA.debugLineNum = 4128854;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
RDebugUtils.currentLine=4128856;
 //BA.debugLineNum = 4128856;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 11: {
RDebugUtils.currentLine=4128861;
 //BA.debugLineNum = 4128861;BA.debugLine="If (state_tatil=1) Then 'tatil rasmi";
if ((_state_tatil==1)) { 
RDebugUtils.currentLine=4128862;
 //BA.debugLineNum = 4128862;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
RDebugUtils.currentLine=4128864;
 //BA.debugLineNum = 4128864;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 22: {
RDebugUtils.currentLine=4128869;
 //BA.debugLineNum = 4128869;BA.debugLine="If (state_tatil=2) Then  'tatil garardadi";
if ((_state_tatil==2)) { 
RDebugUtils.currentLine=4128870;
 //BA.debugLineNum = 4128870;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
RDebugUtils.currentLine=4128872;
 //BA.debugLineNum = 4128872;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
}
;
RDebugUtils.currentLine=4128879;
 //BA.debugLineNum = 4128879;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=4128880;
 //BA.debugLineNum = 4128880;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
 };
 };
 }else 
{RDebugUtils.currentLine=4128886;
 //BA.debugLineNum = 4128886;BA.debugLine="Else If (index_box=5) Then";
if ((_index_box==5)) { 
RDebugUtils.currentLine=4128888;
 //BA.debugLineNum = 4128888;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=4128889;
 //BA.debugLineNum = 4128889;BA.debugLine="If(alist.Get(4)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (4))))<5)) { 
RDebugUtils.currentLine=4128890;
 //BA.debugLineNum = 4128890;BA.debugLine="add_mamoriat_sub";
_add_mamoriat_sub();
 }else {
RDebugUtils.currentLine=4128892;
 //BA.debugLineNum = 4128892;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=4128896;
 //BA.debugLineNum = 4128896;BA.debugLine="add_mamoriat_sub";
_add_mamoriat_sub();
 };
 }}}}
;
RDebugUtils.currentLine=4128900;
 //BA.debugLineNum = 4128900;BA.debugLine="End Sub";
return "";
}
public static String  _add_ezafe_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_ezafe_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_ezafe_sub", null));}
int _state_mod = 0;
String _str_mod = "";
boolean _result_a = false;
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub add_ezafe_sub";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="Dim state_mod As Int=0";
_state_mod = (int) (0);
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="Dim str_mod As String=\"\"";
_str_mod = "";
RDebugUtils.currentLine=4194307;
 //BA.debugLineNum = 4194307;BA.debugLine="If(ckb_ezaf_taradod.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="state_mod=2";
_state_mod = (int) (2);
RDebugUtils.currentLine=4194309;
 //BA.debugLineNum = 4194309;BA.debugLine="str_mod=\" (فوق العاده)- \"";
_str_mod = " (فوق العاده)- ";
 }else {
RDebugUtils.currentLine=4194311;
 //BA.debugLineNum = 4194311;BA.debugLine="state_mod=0";
_state_mod = (int) (0);
 };
RDebugUtils.currentLine=4194315;
 //BA.debugLineNum = 4194315;BA.debugLine="Try";
try {RDebugUtils.currentLine=4194317;
 //BA.debugLineNum = 4194317;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=4194318;
 //BA.debugLineNum = 4194318;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=4194320;
 //BA.debugLineNum = 4194320;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0 Or day_bt<>0)T";
if ((_moon_bt!=0 || _year_bt!=0 || _day_bt!=0)) { 
RDebugUtils.currentLine=4194321;
 //BA.debugLineNum = 4194321;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=4194322;
 //BA.debugLineNum = 4194322;BA.debugLine="Else If (hour_bt=0 And min_bt=0 )Then";
if ((_hour_bt==0 && _min_bt==0)) { 
RDebugUtils.currentLine=4194323;
 //BA.debugLineNum = 4194323;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=4194327;
 //BA.debugLineNum = 4194327;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=4194328;
 //BA.debugLineNum = 4194328;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_ezafekari_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4194330;
 //BA.debugLineNum = 4194330;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
RDebugUtils.currentLine=4194331;
 //BA.debugLineNum = 4194331;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ اضافه کاری وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
RDebugUtils.currentLine=4194332;
 //BA.debugLineNum = 4194332;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4194333;
 //BA.debugLineNum = 4194333;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Te";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=4194336;
 //BA.debugLineNum = 4194336;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4194337;
 //BA.debugLineNum = 4194337;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=4194342;
 //BA.debugLineNum = 4194342;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=4194345;
 //BA.debugLineNum = 4194345;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4194346;
 //BA.debugLineNum = 4194346;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=4194350;
 //BA.debugLineNum = 4194350;BA.debugLine="dbCode.edit_ezafekari(current_id_edit,date1,da";
mostCurrent._dbcode._edit_ezafekari /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=4194351;
 //BA.debugLineNum = 4194351;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4194354;
 //BA.debugLineNum = 4194354;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=4194359;
 //BA.debugLineNum = 4194359;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e39) {
			processBA.setLastException(e39);RDebugUtils.currentLine=4194365;
 //BA.debugLineNum = 4194365;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=4194370;
 //BA.debugLineNum = 4194370;BA.debugLine="End Sub";
return "";
}
public static String  _add_morakhasi_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_morakhasi_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_morakhasi_sub", null));}
String _str_noe2 = "";
boolean _result_a = false;
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub add_morakhasi_sub";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="Dim str_noe2 As String";
_str_noe2 = "";
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="str_noe2=\"(\"&str_noe&\")- \"";
_str_noe2 = "("+mostCurrent._str_noe+")- ";
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="Try";
try {RDebugUtils.currentLine=4259845;
 //BA.debugLineNum = 4259845;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
if ((_day_bt<0 || _hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=4259846;
 //BA.debugLineNum = 4259846;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=4259847;
 //BA.debugLineNum = 4259847;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0)Then";
if ((_moon_bt!=0 || _year_bt!=0)) { 
RDebugUtils.currentLine=4259848;
 //BA.debugLineNum = 4259848;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=4259849;
 //BA.debugLineNum = 4259849;BA.debugLine="Else If (hour_bt=0 And min_bt=0 And day_bt=0 )Th";
if ((_hour_bt==0 && _min_bt==0 && _day_bt==0)) { 
RDebugUtils.currentLine=4259850;
 //BA.debugLineNum = 4259850;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=4259855;
 //BA.debugLineNum = 4259855;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=4259856;
 //BA.debugLineNum = 4259856;BA.debugLine="If(dbCode.isexist_morakhasi_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_morakhasi_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4259858;
 //BA.debugLineNum = 4259858;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
RDebugUtils.currentLine=4259859;
 //BA.debugLineNum = 4259859;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ مرخصی وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
RDebugUtils.currentLine=4259860;
 //BA.debugLineNum = 4259860;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4259861;
 //BA.debugLineNum = 4259861;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Te";
mostCurrent._dbcode._add_morakhasi /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_noe2+mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
RDebugUtils.currentLine=4259862;
 //BA.debugLineNum = 4259862;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4259863;
 //BA.debugLineNum = 4259863;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=4259868;
 //BA.debugLineNum = 4259868;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_morakhasi /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_noe2+mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
RDebugUtils.currentLine=4259869;
 //BA.debugLineNum = 4259869;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4259870;
 //BA.debugLineNum = 4259870;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=4259873;
 //BA.debugLineNum = 4259873;BA.debugLine="dbCode.edit_morakhasi(current_id_edit,date1,da";
mostCurrent._dbcode._edit_morakhasi /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
RDebugUtils.currentLine=4259875;
 //BA.debugLineNum = 4259875;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4259876;
 //BA.debugLineNum = 4259876;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=4259883;
 //BA.debugLineNum = 4259883;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e33) {
			processBA.setLastException(e33);RDebugUtils.currentLine=4259889;
 //BA.debugLineNum = 4259889;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=4259894;
 //BA.debugLineNum = 4259894;BA.debugLine="End Sub";
return "";
}
public static String  _add_taradod_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_taradod_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_taradod_sub", null));}
boolean _result_a = false;
String _str_tozih0 = "";
String _str_tozih1 = "";
String _str_tozih2 = "";
int _tim_ezaf_min = 0;
anywheresoftware.b4a.objects.collections.List _ls_res_tim1 = null;
String _tim1_saat = "";
String _date1_refind = "";
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub add_taradod_sub";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="Try";
try {RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=4325382;
 //BA.debugLineNum = 4325382;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0 Or day_bt>2)Th";
if ((_moon_bt!=0 || _year_bt!=0 || _day_bt>2)) { 
RDebugUtils.currentLine=4325383;
 //BA.debugLineNum = 4325383;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="Else If (hour_bt=0 And min_bt=0 )Then";
if ((_hour_bt==0 && _min_bt==0)) { 
RDebugUtils.currentLine=4325385;
 //BA.debugLineNum = 4325385;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=4325390;
 //BA.debugLineNum = 4325390;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=4325391;
 //BA.debugLineNum = 4325391;BA.debugLine="If(dbCode.isexist_taradod_by_date(date1)=True)";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4325394;
 //BA.debugLineNum = 4325394;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
RDebugUtils.currentLine=4325395;
 //BA.debugLineNum = 4325395;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ تردد وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
RDebugUtils.currentLine=4325396;
 //BA.debugLineNum = 4325396;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4325399;
 //BA.debugLineNum = 4325399;BA.debugLine="Dim str_tozih0 As String=\"(فوق العاده)(تردد";
_str_tozih0 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=4325400;
 //BA.debugLineNum = 4325400;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_t";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=4325401;
 //BA.debugLineNum = 4325401;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=4325403;
 //BA.debugLineNum = 4325403;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_e";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4325410;
 //BA.debugLineNum = 4325410;BA.debugLine="Dim tim_ezaf_min As Int=tim_min-(myfunc.get";
_tim_ezaf_min = (int) (_tim_min-(mostCurrent._myfunc._get_saatkari_inweek /*int*/ (mostCurrent.activityBA,_day_inweek_id)));
RDebugUtils.currentLine=4325412;
 //BA.debugLineNum = 4325412;BA.debugLine="Dim ls_res_tim1 As List";
_ls_res_tim1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4325413;
 //BA.debugLineNum = 4325413;BA.debugLine="ls_res_tim1.Initialize";
_ls_res_tim1.Initialize();
RDebugUtils.currentLine=4325414;
 //BA.debugLineNum = 4325414;BA.debugLine="ls_res_tim1=myfunc.find_tim1_taradod(lbl_ti";
_ls_res_tim1 = mostCurrent._myfunc._find_tim1_taradod /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._lbl_tim2.getText(),_tim_ezaf_min);
RDebugUtils.currentLine=4325415;
 //BA.debugLineNum = 4325415;BA.debugLine="Dim tim1_saat As String=ls_res_tim1.Get(0)";
_tim1_saat = BA.ObjectToString(_ls_res_tim1.Get((int) (0)));
RDebugUtils.currentLine=4325416;
 //BA.debugLineNum = 4325416;BA.debugLine="Dim date1_refind As String=\"\"";
_date1_refind = "";
RDebugUtils.currentLine=4325417;
 //BA.debugLineNum = 4325417;BA.debugLine="If(ls_res_tim1.Get(1)=1) Then";
if (((_ls_res_tim1.Get((int) (1))).equals((Object)(1)))) { 
RDebugUtils.currentLine=4325418;
 //BA.debugLineNum = 4325418;BA.debugLine="date1_refind=date2";
_date1_refind = mostCurrent._date2;
 }else {
RDebugUtils.currentLine=4325420;
 //BA.debugLineNum = 4325420;BA.debugLine="date1_refind=date1";
_date1_refind = mostCurrent._date1;
 };
RDebugUtils.currentLine=4325424;
 //BA.debugLineNum = 4325424;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4325425;
 //BA.debugLineNum = 4325425;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,ti";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih0,(int) (2));
 }else {
RDebugUtils.currentLine=4325427;
 //BA.debugLineNum = 4325427;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,ti";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih1,(int) (0));
 };
RDebugUtils.currentLine=4325432;
 //BA.debugLineNum = 4325432;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
RDebugUtils.currentLine=4325434;
 //BA.debugLineNum = 4325434;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,mostCurrent._et_tozihat.getText(),(int) (0));
 };
RDebugUtils.currentLine=4325441;
 //BA.debugLineNum = 4325441;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325442;
 //BA.debugLineNum = 4325442;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=4325450;
 //BA.debugLineNum = 4325450;BA.debugLine="Dim str_tozih0 As String=\"(فوق العاده)(تردد د";
_str_tozih0 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=4325451;
 //BA.debugLineNum = 4325451;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_to";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=4325452;
 //BA.debugLineNum = 4325452;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-\"";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=4325455;
 //BA.debugLineNum = 4325455;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_ez";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4325459;
 //BA.debugLineNum = 4325459;BA.debugLine="Dim tim_ezaf_min As Int=tim_min-(myfunc.get_";
_tim_ezaf_min = (int) (_tim_min-(mostCurrent._myfunc._get_saatkari_inweek /*int*/ (mostCurrent.activityBA,_day_inweek_id)));
RDebugUtils.currentLine=4325462;
 //BA.debugLineNum = 4325462;BA.debugLine="Dim ls_res_tim1 As List";
_ls_res_tim1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4325463;
 //BA.debugLineNum = 4325463;BA.debugLine="ls_res_tim1.Initialize";
_ls_res_tim1.Initialize();
RDebugUtils.currentLine=4325464;
 //BA.debugLineNum = 4325464;BA.debugLine="ls_res_tim1=myfunc.find_tim1_taradod(lbl_tim";
_ls_res_tim1 = mostCurrent._myfunc._find_tim1_taradod /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._lbl_tim2.getText(),_tim_ezaf_min);
RDebugUtils.currentLine=4325465;
 //BA.debugLineNum = 4325465;BA.debugLine="Dim tim1_saat As String=ls_res_tim1.Get(0)";
_tim1_saat = BA.ObjectToString(_ls_res_tim1.Get((int) (0)));
RDebugUtils.currentLine=4325466;
 //BA.debugLineNum = 4325466;BA.debugLine="Dim date1_refind As String=\"\"";
_date1_refind = "";
RDebugUtils.currentLine=4325467;
 //BA.debugLineNum = 4325467;BA.debugLine="If(ls_res_tim1.Get(1)=1) Then";
if (((_ls_res_tim1.Get((int) (1))).equals((Object)(1)))) { 
RDebugUtils.currentLine=4325468;
 //BA.debugLineNum = 4325468;BA.debugLine="date1_refind=date2";
_date1_refind = mostCurrent._date2;
 }else {
RDebugUtils.currentLine=4325470;
 //BA.debugLineNum = 4325470;BA.debugLine="date1_refind=date1";
_date1_refind = mostCurrent._date1;
 };
RDebugUtils.currentLine=4325474;
 //BA.debugLineNum = 4325474;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4325475;
 //BA.debugLineNum = 4325475;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,tim";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih0,(int) (2));
 }else {
RDebugUtils.currentLine=4325477;
 //BA.debugLineNum = 4325477;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,tim";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih1,(int) (0));
 };
RDebugUtils.currentLine=4325481;
 //BA.debugLineNum = 4325481;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
RDebugUtils.currentLine=4325483;
 //BA.debugLineNum = 4325483;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,mostCurrent._et_tozihat.getText(),(int) (0));
 };
RDebugUtils.currentLine=4325487;
 //BA.debugLineNum = 4325487;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325488;
 //BA.debugLineNum = 4325488;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=4325491;
 //BA.debugLineNum = 4325491;BA.debugLine="dbCode.edit_taradod(current_id_edit,date1,date";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
RDebugUtils.currentLine=4325493;
 //BA.debugLineNum = 4325493;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325494;
 //BA.debugLineNum = 4325494;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=4325500;
 //BA.debugLineNum = 4325500;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e77) {
			processBA.setLastException(e77);RDebugUtils.currentLine=4325506;
 //BA.debugLineNum = 4325506;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=4325509;
 //BA.debugLineNum = 4325509;BA.debugLine="End Sub";
return "";
}
public static String  _add_taradod_sub2() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_taradod_sub2", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_taradod_sub2", null));}
boolean _result_a = false;
String _str_tozih2 = "";
String _str_tozih1 = "";
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub add_taradod_sub2";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="Try";
try {RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0 Or day_bt>2)Th";
if ((_moon_bt!=0 || _year_bt!=0 || _day_bt>2)) { 
RDebugUtils.currentLine=4390919;
 //BA.debugLineNum = 4390919;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="Else If (hour_bt=0 And min_bt=0 )Then";
if ((_hour_bt==0 && _min_bt==0)) { 
RDebugUtils.currentLine=4390921;
 //BA.debugLineNum = 4390921;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=4390926;
 //BA.debugLineNum = 4390926;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=4390927;
 //BA.debugLineNum = 4390927;BA.debugLine="If(dbCode.isexist_taradod_by_date(date1)=True)";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4390930;
 //BA.debugLineNum = 4390930;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
RDebugUtils.currentLine=4390931;
 //BA.debugLineNum = 4390931;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ تردد وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
RDebugUtils.currentLine=4390932;
 //BA.debugLineNum = 4390932;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4390934;
 //BA.debugLineNum = 4390934;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=4390936;
 //BA.debugLineNum = 4390936;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_e";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4390938;
 //BA.debugLineNum = 4390938;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4390939;
 //BA.debugLineNum = 4390939;BA.debugLine="Dim str_tozih1 As String=\"(فوق العاده)(تر";
_str_tozih1 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=4390940;
 //BA.debugLineNum = 4390940;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (2));
 }else {
RDebugUtils.currentLine=4390942;
 //BA.debugLineNum = 4390942;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&e";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=4390943;
 //BA.debugLineNum = 4390943;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (0));
 };
RDebugUtils.currentLine=4390949;
 //BA.debugLineNum = 4390949;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Te";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
RDebugUtils.currentLine=4390951;
 //BA.debugLineNum = 4390951;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 };
RDebugUtils.currentLine=4390954;
 //BA.debugLineNum = 4390954;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4390955;
 //BA.debugLineNum = 4390955;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=4390962;
 //BA.debugLineNum = 4390962;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-\"";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=4390964;
 //BA.debugLineNum = 4390964;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_ez";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4390966;
 //BA.debugLineNum = 4390966;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4390967;
 //BA.debugLineNum = 4390967;BA.debugLine="Dim str_tozih1 As String=\"(فوق العاده)(تردد";
_str_tozih1 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=4390968;
 //BA.debugLineNum = 4390968;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.T";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (2));
 }else {
RDebugUtils.currentLine=4390970;
 //BA.debugLineNum = 4390970;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=4390971;
 //BA.debugLineNum = 4390971;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.T";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (0));
 };
RDebugUtils.currentLine=4390978;
 //BA.debugLineNum = 4390978;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
RDebugUtils.currentLine=4390981;
 //BA.debugLineNum = 4390981;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 };
RDebugUtils.currentLine=4390984;
 //BA.debugLineNum = 4390984;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4390985;
 //BA.debugLineNum = 4390985;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=4390990;
 //BA.debugLineNum = 4390990;BA.debugLine="dbCode.edit_taradod(current_id_edit,date1,date";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
RDebugUtils.currentLine=4390992;
 //BA.debugLineNum = 4390992;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4390993;
 //BA.debugLineNum = 4390993;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=4390999;
 //BA.debugLineNum = 4390999;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e55) {
			processBA.setLastException(e55);RDebugUtils.currentLine=4391005;
 //BA.debugLineNum = 4391005;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=4391008;
 //BA.debugLineNum = 4391008;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_rest_finger_fs_taradod_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_rest_finger_fs_taradod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_rest_finger_fs_taradod_click", null));}
RDebugUtils.currentLine=10551296;
 //BA.debugLineNum = 10551296;BA.debugLine="Private Sub lbl_rest_finger_fs_taradod_Click";
RDebugUtils.currentLine=10551297;
 //BA.debugLineNum = 10551297;BA.debugLine="lbl_finger_fs_vorod_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(" - "));
RDebugUtils.currentLine=10551298;
 //BA.debugLineNum = 10551298;BA.debugLine="lbl_finger_fs_khoroj_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(" - "));
RDebugUtils.currentLine=10551300;
 //BA.debugLineNum = 10551300;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=10551301;
 //BA.debugLineNum = 10551301;BA.debugLine="lbl_time_show_fs.Text=\"\"";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=10551303;
 //BA.debugLineNum = 10551303;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=10551304;
 //BA.debugLineNum = 10551304;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=10551305;
 //BA.debugLineNum = 10551305;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551306;
 //BA.debugLineNum = 10551306;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551307;
 //BA.debugLineNum = 10551307;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551308;
 //BA.debugLineNum = 10551308;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10551310;
 //BA.debugLineNum = 10551310;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=10551311;
 //BA.debugLineNum = 10551311;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=10551313;
 //BA.debugLineNum = 10551313;BA.debugLine="lbl_finger_fs_vorod.Tag=1";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(1));
RDebugUtils.currentLine=10551314;
 //BA.debugLineNum = 10551314;BA.debugLine="lbl_finger_fs_khoroj.Tag=2";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(2));
RDebugUtils.currentLine=10551315;
 //BA.debugLineNum = 10551315;BA.debugLine="File.WriteString(File.DirInternal,\"finger_vorod_t";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt","0");
RDebugUtils.currentLine=10551316;
 //BA.debugLineNum = 10551316;BA.debugLine="save_box_allow=False";
_save_box_allow = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=10551317;
 //BA.debugLineNum = 10551317;BA.debugLine="End Sub";
return "";
}
public static String  _add_mamoriat_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_mamoriat_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_mamoriat_sub", null));}
int _state_mod = 0;
String _str_mod = "";
boolean _result_a = false;
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub add_mamoriat_sub";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="Dim state_mod As Int=0";
_state_mod = (int) (0);
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="Dim str_mod As String=\"\"";
_str_mod = "";
RDebugUtils.currentLine=4456459;
 //BA.debugLineNum = 4456459;BA.debugLine="Try";
try {RDebugUtils.currentLine=4456460;
 //BA.debugLineNum = 4456460;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
if ((_day_bt<0 || _hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=4456461;
 //BA.debugLineNum = 4456461;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=4456462;
 //BA.debugLineNum = 4456462;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0)Then";
if ((_moon_bt!=0 || _year_bt!=0)) { 
RDebugUtils.currentLine=4456463;
 //BA.debugLineNum = 4456463;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=4456464;
 //BA.debugLineNum = 4456464;BA.debugLine="Else If (hour_bt=0 And min_bt=0 And day_bt=0 )Th";
if ((_hour_bt==0 && _min_bt==0 && _day_bt==0)) { 
RDebugUtils.currentLine=4456465;
 //BA.debugLineNum = 4456465;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=4456468;
 //BA.debugLineNum = 4456468;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=4456469;
 //BA.debugLineNum = 4456469;BA.debugLine="If(dbCode.isexist_mamoriat_by_date(date1)=True";
if ((mostCurrent._dbcode._isexist_mamoriat_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4456471;
 //BA.debugLineNum = 4456471;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
RDebugUtils.currentLine=4456472;
 //BA.debugLineNum = 4456472;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ مأموریت وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
RDebugUtils.currentLine=4456473;
 //BA.debugLineNum = 4456473;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4456474;
 //BA.debugLineNum = 4456474;BA.debugLine="dbCode.add_mamoriat(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_mamoriat /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=4456476;
 //BA.debugLineNum = 4456476;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456477;
 //BA.debugLineNum = 4456477;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=4456480;
 //BA.debugLineNum = 4456480;BA.debugLine="dbCode.add_mamoriat(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_mamoriat /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=4456482;
 //BA.debugLineNum = 4456482;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456483;
 //BA.debugLineNum = 4456483;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=4456487;
 //BA.debugLineNum = 4456487;BA.debugLine="dbCode.edit_mamoriat(current_id_edit,date1,dat";
mostCurrent._dbcode._edit_mamoriat /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=4456488;
 //BA.debugLineNum = 4456488;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456491;
 //BA.debugLineNum = 4456491;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=4456496;
 //BA.debugLineNum = 4456496;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e33) {
			processBA.setLastException(e33);RDebugUtils.currentLine=4456502;
 //BA.debugLineNum = 4456502;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=4456507;
 //BA.debugLineNum = 4456507;BA.debugLine="End Sub";
return "";
}
public static String  _fill_lists(String _year1,String _moon1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_lists", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_lists", new Object[] {_year1,_moon1}));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _str1 = null;
anywheresoftware.b4a.objects.collections.List _ls_ezafe = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _str2 = null;
anywheresoftware.b4a.objects.collections.List _ls_morkh = null;
anywheresoftware.b4a.objects.B4XViewWrapper _p2 = null;
anywheresoftware.b4a.objects.collections.List _ls_tarad = null;
anywheresoftware.b4a.objects.collections.List _ls_mamor = null;
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub fill_lists (year1 As String, moon1 As String)";
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="cust_LV_ezafekari.Clear";
mostCurrent._cust_lv_ezafekari._clear();
RDebugUtils.currentLine=3080196;
 //BA.debugLineNum = 3080196;BA.debugLine="list_ezafekari_id.Clear";
mostCurrent._list_ezafekari_id.Clear();
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=3080199;
 //BA.debugLineNum = 3080199;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
RDebugUtils.currentLine=3080200;
 //BA.debugLineNum = 3080200;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=3080201;
 //BA.debugLineNum = 3080201;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=3080202;
 //BA.debugLineNum = 3080202;BA.debugLine="str1.Initialize";
_str1.Initialize();
RDebugUtils.currentLine=3080206;
 //BA.debugLineNum = 3080206;BA.debugLine="Dim ls_ezafe As List";
_ls_ezafe = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3080207;
 //BA.debugLineNum = 3080207;BA.debugLine="ls_ezafe.Initialize";
_ls_ezafe.Initialize();
RDebugUtils.currentLine=3080209;
 //BA.debugLineNum = 3080209;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz2_dontDay(dbCod";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
RDebugUtils.currentLine=3080211;
 //BA.debugLineNum = 3080211;BA.debugLine="If((ls_ezafe.Get(0))<>0)Then";
if ((((_ls_ezafe.Get((int) (0)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080212;
 //BA.debugLineNum = 3080212;BA.debugLine="str1.Append(ls_ezafe.Get(0)&\" ساعت \")";
_str1.Append(BA.ObjectToString(_ls_ezafe.Get((int) (0)))+" ساعت ");
RDebugUtils.currentLine=3080213;
 //BA.debugLineNum = 3080213;BA.debugLine="If((ls_ezafe.Get(1))<>0)Then";
if ((((_ls_ezafe.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080214;
 //BA.debugLineNum = 3080214;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
RDebugUtils.currentLine=3080217;
 //BA.debugLineNum = 3080217;BA.debugLine="If((ls_ezafe.Get(1))<>0)Then";
if ((((_ls_ezafe.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080218;
 //BA.debugLineNum = 3080218;BA.debugLine="str1.Append(ls_ezafe.Get(1)&\" دقیقه \")";
_str1.Append(BA.ObjectToString(_ls_ezafe.Get((int) (1)))+" دقیقه ");
 };
RDebugUtils.currentLine=3080222;
 //BA.debugLineNum = 3080222;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=3080223;
 //BA.debugLineNum = 3080223;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=3080224;
 //BA.debugLineNum = 3080224;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
RDebugUtils.currentLine=3080226;
 //BA.debugLineNum = 3080226;BA.debugLine="cust_LV_ezafekari.Add(p,dbCode.res.GetString(\"id";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3080228;
 //BA.debugLineNum = 3080228;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=3080231;
 //BA.debugLineNum = 3080231;BA.debugLine="lbl_date_CLV.Text=\"از : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("از : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
RDebugUtils.currentLine=3080232;
 //BA.debugLineNum = 3080232;BA.debugLine="lbl_hour_CLV.Text=\"تا : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("تا : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
RDebugUtils.currentLine=3080235;
 //BA.debugLineNum = 3080235;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str1.ToString()));
RDebugUtils.currentLine=3080236;
 //BA.debugLineNum = 3080236;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=3080237;
 //BA.debugLineNum = 3080237;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3080238;
 //BA.debugLineNum = 3080238;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3080240;
 //BA.debugLineNum = 3080240;BA.debugLine="list_ezafekari_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_ezafekari_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=3080245;
 //BA.debugLineNum = 3080245;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=3080246;
 //BA.debugLineNum = 3080246;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3080248;
 //BA.debugLineNum = 3080248;BA.debugLine="If(cust_LV_ezafekari.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_ezafekari._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=3080249;
 //BA.debugLineNum = 3080249;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=3080250;
 //BA.debugLineNum = 3080250;BA.debugLine="Select cust_LV_ezafekari.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_ezafekari._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=3080252;
 //BA.debugLineNum = 3080252;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
RDebugUtils.currentLine=3080254;
 //BA.debugLineNum = 3080254;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=3080256;
 //BA.debugLineNum = 3080256;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=3080258;
 //BA.debugLineNum = 3080258;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=3080260;
 //BA.debugLineNum = 3080260;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=3080262;
 //BA.debugLineNum = 3080262;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=3080264;
 //BA.debugLineNum = 3080264;BA.debugLine="cust_LV_ezafekari.Add(p,\"\")";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=3080268;
 //BA.debugLineNum = 3080268;BA.debugLine="cust_LV_morakhasi.Clear";
mostCurrent._cust_lv_morakhasi._clear();
RDebugUtils.currentLine=3080269;
 //BA.debugLineNum = 3080269;BA.debugLine="list_morakhasi_id.Clear";
mostCurrent._list_morakhasi_id.Clear();
RDebugUtils.currentLine=3080271;
 //BA.debugLineNum = 3080271;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=3080272;
 //BA.debugLineNum = 3080272;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
RDebugUtils.currentLine=3080273;
 //BA.debugLineNum = 3080273;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=3080274;
 //BA.debugLineNum = 3080274;BA.debugLine="Dim str2 As StringBuilder";
_str2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=3080275;
 //BA.debugLineNum = 3080275;BA.debugLine="str2.Initialize";
_str2.Initialize();
RDebugUtils.currentLine=3080277;
 //BA.debugLineNum = 3080277;BA.debugLine="Dim ls_morkh As List";
_ls_morkh = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3080278;
 //BA.debugLineNum = 3080278;BA.debugLine="ls_morkh.Initialize";
_ls_morkh.Initialize();
RDebugUtils.currentLine=3080280;
 //BA.debugLineNum = 3080280;BA.debugLine="ls_morkh=myfunc.Min_to_saatMinRoz(dbCode.res.Get";
_ls_morkh = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
RDebugUtils.currentLine=3080284;
 //BA.debugLineNum = 3080284;BA.debugLine="If((ls_morkh.Get(2))<>0)Then";
if ((((_ls_morkh.Get((int) (2)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080285;
 //BA.debugLineNum = 3080285;BA.debugLine="str2.Append(ls_morkh.Get(2)&\" روز \")";
_str2.Append(BA.ObjectToString(_ls_morkh.Get((int) (2)))+" روز ");
RDebugUtils.currentLine=3080286;
 //BA.debugLineNum = 3080286;BA.debugLine="If((ls_morkh.Get(0))<>0 Or (ls_morkh.Get(1))<>0";
if ((((_ls_morkh.Get((int) (0)))).equals((Object)(0)) == false || ((_ls_morkh.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080287;
 //BA.debugLineNum = 3080287;BA.debugLine="str2.Append(CRLF)";
_str2.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
RDebugUtils.currentLine=3080290;
 //BA.debugLineNum = 3080290;BA.debugLine="If((ls_morkh.Get(0))<>0)Then";
if ((((_ls_morkh.Get((int) (0)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080291;
 //BA.debugLineNum = 3080291;BA.debugLine="str2.Append(ls_morkh.Get(0)&\" ساعت \")";
_str2.Append(BA.ObjectToString(_ls_morkh.Get((int) (0)))+" ساعت ");
RDebugUtils.currentLine=3080292;
 //BA.debugLineNum = 3080292;BA.debugLine="If((ls_morkh.Get(1))<>0)Then";
if ((((_ls_morkh.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080293;
 //BA.debugLineNum = 3080293;BA.debugLine="str2.Append(CRLF)";
_str2.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
RDebugUtils.currentLine=3080296;
 //BA.debugLineNum = 3080296;BA.debugLine="If((ls_morkh.Get(1))<>0)Then";
if ((((_ls_morkh.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080297;
 //BA.debugLineNum = 3080297;BA.debugLine="str2.Append(ls_morkh.Get(1)&\" دقیقه \")";
_str2.Append(BA.ObjectToString(_ls_morkh.Get((int) (1)))+" دقیقه ");
 };
RDebugUtils.currentLine=3080301;
 //BA.debugLineNum = 3080301;BA.debugLine="Dim p2 As B4XView = xui.CreatePanel(\"\")";
_p2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p2 = mostCurrent._xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=3080302;
 //BA.debugLineNum = 3080302;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=3080303;
 //BA.debugLineNum = 3080303;BA.debugLine="p2.LoadLayout(\"item_list\")";
_p2.LoadLayout("item_list",mostCurrent.activityBA);
RDebugUtils.currentLine=3080305;
 //BA.debugLineNum = 3080305;BA.debugLine="cust_LV_morakhasi.Add(p2,dbCode.res.GetString(\"i";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3080307;
 //BA.debugLineNum = 3080307;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=3080309;
 //BA.debugLineNum = 3080309;BA.debugLine="lbl_date_CLV.Text=\"از : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("از : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
RDebugUtils.currentLine=3080310;
 //BA.debugLineNum = 3080310;BA.debugLine="lbl_hour_CLV.Text=\"تا : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("تا : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
RDebugUtils.currentLine=3080311;
 //BA.debugLineNum = 3080311;BA.debugLine="lbl_time_CLV.Text=str2.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str2.ToString()));
RDebugUtils.currentLine=3080312;
 //BA.debugLineNum = 3080312;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=3080313;
 //BA.debugLineNum = 3080313;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3080314;
 //BA.debugLineNum = 3080314;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3080316;
 //BA.debugLineNum = 3080316;BA.debugLine="list_morakhasi_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_morakhasi_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=3080321;
 //BA.debugLineNum = 3080321;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=3080322;
 //BA.debugLineNum = 3080322;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3080328;
 //BA.debugLineNum = 3080328;BA.debugLine="If(cust_LV_morakhasi.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_morakhasi._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=3080329;
 //BA.debugLineNum = 3080329;BA.debugLine="p2 = xui.CreatePanel(\"p\")";
_p2 = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=3080330;
 //BA.debugLineNum = 3080330;BA.debugLine="Select cust_LV_morakhasi.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_morakhasi._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=3080332;
 //BA.debugLineNum = 3080332;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
RDebugUtils.currentLine=3080334;
 //BA.debugLineNum = 3080334;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=3080336;
 //BA.debugLineNum = 3080336;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=3080338;
 //BA.debugLineNum = 3080338;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=3080340;
 //BA.debugLineNum = 3080340;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=3080342;
 //BA.debugLineNum = 3080342;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=3080344;
 //BA.debugLineNum = 3080344;BA.debugLine="cust_LV_morakhasi.Add(p2,\"\")";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(""));
 };
RDebugUtils.currentLine=3080349;
 //BA.debugLineNum = 3080349;BA.debugLine="cust_LV_taradod.Clear";
mostCurrent._cust_lv_taradod._clear();
RDebugUtils.currentLine=3080350;
 //BA.debugLineNum = 3080350;BA.debugLine="list_taradod_id.Clear";
mostCurrent._list_taradod_id.Clear();
RDebugUtils.currentLine=3080352;
 //BA.debugLineNum = 3080352;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=3080353;
 //BA.debugLineNum = 3080353;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
RDebugUtils.currentLine=3080354;
 //BA.debugLineNum = 3080354;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=3080355;
 //BA.debugLineNum = 3080355;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=3080356;
 //BA.debugLineNum = 3080356;BA.debugLine="str1.Initialize";
_str1.Initialize();
RDebugUtils.currentLine=3080358;
 //BA.debugLineNum = 3080358;BA.debugLine="Dim ls_tarad As List";
_ls_tarad = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3080359;
 //BA.debugLineNum = 3080359;BA.debugLine="ls_tarad.Initialize";
_ls_tarad.Initialize();
RDebugUtils.currentLine=3080361;
 //BA.debugLineNum = 3080361;BA.debugLine="ls_tarad=myfunc.Min_to_saatMinRoz(dbCode.res.Get";
_ls_tarad = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
RDebugUtils.currentLine=3080365;
 //BA.debugLineNum = 3080365;BA.debugLine="If((ls_tarad.Get(2))<>0)Then";
if ((((_ls_tarad.Get((int) (2)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080366;
 //BA.debugLineNum = 3080366;BA.debugLine="str1.Append(ls_tarad.Get(2)&\" روز \")";
_str1.Append(BA.ObjectToString(_ls_tarad.Get((int) (2)))+" روز ");
RDebugUtils.currentLine=3080367;
 //BA.debugLineNum = 3080367;BA.debugLine="If((ls_tarad.Get(0))<>0 Or (ls_tarad.Get(1))<>0";
if ((((_ls_tarad.Get((int) (0)))).equals((Object)(0)) == false || ((_ls_tarad.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080368;
 //BA.debugLineNum = 3080368;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
RDebugUtils.currentLine=3080371;
 //BA.debugLineNum = 3080371;BA.debugLine="If((ls_tarad.Get(0))<>0)Then";
if ((((_ls_tarad.Get((int) (0)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080372;
 //BA.debugLineNum = 3080372;BA.debugLine="str1.Append(ls_tarad.Get(0)&\" ساعت \")";
_str1.Append(BA.ObjectToString(_ls_tarad.Get((int) (0)))+" ساعت ");
RDebugUtils.currentLine=3080373;
 //BA.debugLineNum = 3080373;BA.debugLine="If((ls_tarad.Get(1))<>0)Then";
if ((((_ls_tarad.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080374;
 //BA.debugLineNum = 3080374;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
RDebugUtils.currentLine=3080377;
 //BA.debugLineNum = 3080377;BA.debugLine="If((ls_tarad.Get(1))<>0)Then";
if ((((_ls_tarad.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080378;
 //BA.debugLineNum = 3080378;BA.debugLine="str1.Append(ls_tarad.Get(1)&\" دقیقه \")";
_str1.Append(BA.ObjectToString(_ls_tarad.Get((int) (1)))+" دقیقه ");
 };
RDebugUtils.currentLine=3080382;
 //BA.debugLineNum = 3080382;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=3080383;
 //BA.debugLineNum = 3080383;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=3080384;
 //BA.debugLineNum = 3080384;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
RDebugUtils.currentLine=3080386;
 //BA.debugLineNum = 3080386;BA.debugLine="cust_LV_taradod.Add(p,dbCode.res.GetString(\"id\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3080388;
 //BA.debugLineNum = 3080388;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=3080390;
 //BA.debugLineNum = 3080390;BA.debugLine="lbl_date_CLV.Text=\"ورود : \"&dbCode.res.GetString";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("ورود : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
RDebugUtils.currentLine=3080391;
 //BA.debugLineNum = 3080391;BA.debugLine="lbl_hour_CLV.Text=\"خروج : \"&dbCode.res.GetString";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("خروج : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
RDebugUtils.currentLine=3080393;
 //BA.debugLineNum = 3080393;BA.debugLine="lbl_time_CLV.Typeface=Typeface.MATERIALICONS";
mostCurrent._lbl_time_clv.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
RDebugUtils.currentLine=3080394;
 //BA.debugLineNum = 3080394;BA.debugLine="lbl_time_CLV.Text=Chr(0xE8D5)";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe8d5))));
RDebugUtils.currentLine=3080395;
 //BA.debugLineNum = 3080395;BA.debugLine="lbl_time_CLV.TextSize=25";
mostCurrent._lbl_time_clv.setTextSize((float) (25));
RDebugUtils.currentLine=3080397;
 //BA.debugLineNum = 3080397;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=3080398;
 //BA.debugLineNum = 3080398;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3080399;
 //BA.debugLineNum = 3080399;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3080401;
 //BA.debugLineNum = 3080401;BA.debugLine="list_taradod_id.Add(dbCode.res.GetString(\"id\"))";
mostCurrent._list_taradod_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=3080406;
 //BA.debugLineNum = 3080406;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=3080407;
 //BA.debugLineNum = 3080407;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3080409;
 //BA.debugLineNum = 3080409;BA.debugLine="If(cust_LV_taradod.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_taradod._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=3080410;
 //BA.debugLineNum = 3080410;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=3080411;
 //BA.debugLineNum = 3080411;BA.debugLine="Select cust_LV_taradod.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_taradod._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=3080413;
 //BA.debugLineNum = 3080413;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
RDebugUtils.currentLine=3080415;
 //BA.debugLineNum = 3080415;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=3080417;
 //BA.debugLineNum = 3080417;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=3080419;
 //BA.debugLineNum = 3080419;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=3080421;
 //BA.debugLineNum = 3080421;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=3080423;
 //BA.debugLineNum = 3080423;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=3080425;
 //BA.debugLineNum = 3080425;BA.debugLine="cust_LV_taradod.Add(p,\"\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=3080431;
 //BA.debugLineNum = 3080431;BA.debugLine="cust_LV_mamoriat.Clear";
mostCurrent._cust_lv_mamoriat._clear();
RDebugUtils.currentLine=3080432;
 //BA.debugLineNum = 3080432;BA.debugLine="list_mamoriat_id.Clear";
mostCurrent._list_mamoriat_id.Clear();
RDebugUtils.currentLine=3080435;
 //BA.debugLineNum = 3080435;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=3080436;
 //BA.debugLineNum = 3080436;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
RDebugUtils.currentLine=3080439;
 //BA.debugLineNum = 3080439;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=3080440;
 //BA.debugLineNum = 3080440;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=3080441;
 //BA.debugLineNum = 3080441;BA.debugLine="str1.Initialize";
_str1.Initialize();
RDebugUtils.currentLine=3080443;
 //BA.debugLineNum = 3080443;BA.debugLine="Dim ls_mamor As List";
_ls_mamor = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3080444;
 //BA.debugLineNum = 3080444;BA.debugLine="ls_mamor.Initialize";
_ls_mamor.Initialize();
RDebugUtils.currentLine=3080446;
 //BA.debugLineNum = 3080446;BA.debugLine="ls_mamor=myfunc.Min_to_saatMinRoz(dbCode.res.Get";
_ls_mamor = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
RDebugUtils.currentLine=3080450;
 //BA.debugLineNum = 3080450;BA.debugLine="If((ls_mamor.Get(2))<>0)Then";
if ((((_ls_mamor.Get((int) (2)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080451;
 //BA.debugLineNum = 3080451;BA.debugLine="str1.Append(ls_mamor.Get(2)&\" روز \")";
_str1.Append(BA.ObjectToString(_ls_mamor.Get((int) (2)))+" روز ");
RDebugUtils.currentLine=3080452;
 //BA.debugLineNum = 3080452;BA.debugLine="If((ls_mamor.Get(0))<>0 Or (ls_mamor.Get(1))<>0";
if ((((_ls_mamor.Get((int) (0)))).equals((Object)(0)) == false || ((_ls_mamor.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080453;
 //BA.debugLineNum = 3080453;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
RDebugUtils.currentLine=3080456;
 //BA.debugLineNum = 3080456;BA.debugLine="If((ls_mamor.Get(0))<>0)Then";
if ((((_ls_mamor.Get((int) (0)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080457;
 //BA.debugLineNum = 3080457;BA.debugLine="str1.Append(ls_mamor.Get(0)&\" ساعت \")";
_str1.Append(BA.ObjectToString(_ls_mamor.Get((int) (0)))+" ساعت ");
RDebugUtils.currentLine=3080458;
 //BA.debugLineNum = 3080458;BA.debugLine="If((ls_mamor.Get(1))<>0)Then";
if ((((_ls_mamor.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080459;
 //BA.debugLineNum = 3080459;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
RDebugUtils.currentLine=3080462;
 //BA.debugLineNum = 3080462;BA.debugLine="If((ls_mamor.Get(1))<>0)Then";
if ((((_ls_mamor.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=3080463;
 //BA.debugLineNum = 3080463;BA.debugLine="str1.Append(ls_mamor.Get(1)&\" دقیقه \")";
_str1.Append(BA.ObjectToString(_ls_mamor.Get((int) (1)))+" دقیقه ");
 };
RDebugUtils.currentLine=3080467;
 //BA.debugLineNum = 3080467;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=3080468;
 //BA.debugLineNum = 3080468;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=3080469;
 //BA.debugLineNum = 3080469;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
RDebugUtils.currentLine=3080471;
 //BA.debugLineNum = 3080471;BA.debugLine="cust_LV_mamoriat.Add(p,dbCode.res.GetString(\"id\"";
mostCurrent._cust_lv_mamoriat._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3080473;
 //BA.debugLineNum = 3080473;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=3080475;
 //BA.debugLineNum = 3080475;BA.debugLine="lbl_date_CLV.Text=\"از : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("از : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
RDebugUtils.currentLine=3080476;
 //BA.debugLineNum = 3080476;BA.debugLine="lbl_hour_CLV.Text=\"تا : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("تا : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
RDebugUtils.currentLine=3080477;
 //BA.debugLineNum = 3080477;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str1.ToString()));
RDebugUtils.currentLine=3080478;
 //BA.debugLineNum = 3080478;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=3080479;
 //BA.debugLineNum = 3080479;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3080480;
 //BA.debugLineNum = 3080480;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3080482;
 //BA.debugLineNum = 3080482;BA.debugLine="list_mamoriat_id.Add(dbCode.res.GetString(\"id\"))";
mostCurrent._list_mamoriat_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=3080487;
 //BA.debugLineNum = 3080487;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=3080488;
 //BA.debugLineNum = 3080488;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3080492;
 //BA.debugLineNum = 3080492;BA.debugLine="If(cust_LV_mamoriat.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_mamoriat._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=3080493;
 //BA.debugLineNum = 3080493;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=3080494;
 //BA.debugLineNum = 3080494;BA.debugLine="Select cust_LV_mamoriat.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_mamoriat._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=3080496;
 //BA.debugLineNum = 3080496;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
RDebugUtils.currentLine=3080498;
 //BA.debugLineNum = 3080498;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=3080500;
 //BA.debugLineNum = 3080500;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=3080502;
 //BA.debugLineNum = 3080502;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=3080504;
 //BA.debugLineNum = 3080504;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=3080506;
 //BA.debugLineNum = 3080506;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=3080508;
 //BA.debugLineNum = 3080508;BA.debugLine="cust_LV_mamoriat.Add(p,\"\")";
mostCurrent._cust_lv_mamoriat._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=3080512;
 //BA.debugLineNum = 3080512;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
RDebugUtils.currentLine=3080514;
 //BA.debugLineNum = 3080514;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="End Sub";
return "";
}
public static String  _auth_complete(boolean _success,String _errormessage) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "auth_complete", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "auth_complete", new Object[] {_success,_errormessage}));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub Auth_Complete (Success As Boolean, ErrorMessag";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="tim_lock_lbl.Enabled=False";
_tim_lock_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="ToastMessageShow($\"Error: ${ErrorMessage}\"$, Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(("Error: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_errormessage))+"")),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="Log(ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("61769478",_errormessage,0);
 };
RDebugUtils.currentLine=1769480;
 //BA.debugLineNum = 1769480;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_gozaresh_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_menu_gozaresh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_menu_gozaresh_click", null));}
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Private Sub btn_menu_gozaresh_Click";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="index_page=3";
_index_page = (int) (3);
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="pan_imag.Background=img3";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img3.getObject()));
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
RDebugUtils.currentLine=3145733;
 //BA.debugLineNum = 3145733;BA.debugLine="pan_main.LoadLayout(\"gozaresh_layout\")";
mostCurrent._pan_main.LoadLayout("gozaresh_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=3145735;
 //BA.debugLineNum = 3145735;BA.debugLine="sp_year_gozaresh.Add(\"1404\")";
mostCurrent._sp_year_gozaresh.Add("1404");
RDebugUtils.currentLine=3145736;
 //BA.debugLineNum = 3145736;BA.debugLine="sp_year_gozaresh.Add(\"1403\")";
mostCurrent._sp_year_gozaresh.Add("1403");
RDebugUtils.currentLine=3145737;
 //BA.debugLineNum = 3145737;BA.debugLine="sp_year_gozaresh.Add(\"1402\")";
mostCurrent._sp_year_gozaresh.Add("1402");
RDebugUtils.currentLine=3145738;
 //BA.debugLineNum = 3145738;BA.debugLine="sp_year_gozaresh.Add(\"1401\")";
mostCurrent._sp_year_gozaresh.Add("1401");
RDebugUtils.currentLine=3145739;
 //BA.debugLineNum = 3145739;BA.debugLine="sp_year_gozaresh.Add(\"1400\")";
mostCurrent._sp_year_gozaresh.Add("1400");
RDebugUtils.currentLine=3145740;
 //BA.debugLineNum = 3145740;BA.debugLine="sp_year_gozaresh.Add(\"1399\")";
mostCurrent._sp_year_gozaresh.Add("1399");
RDebugUtils.currentLine=3145741;
 //BA.debugLineNum = 3145741;BA.debugLine="sp_year_gozaresh.Add(\"1398\")";
mostCurrent._sp_year_gozaresh.Add("1398");
RDebugUtils.currentLine=3145743;
 //BA.debugLineNum = 3145743;BA.debugLine="sp_year_gozaresh.SelectedIndex=0";
mostCurrent._sp_year_gozaresh.setSelectedIndex((int) (0));
RDebugUtils.currentLine=3145748;
 //BA.debugLineNum = 3145748;BA.debugLine="pan_hed_gozaresh.Color=color4";
mostCurrent._pan_hed_gozaresh.setColor(_color4);
RDebugUtils.currentLine=3145753;
 //BA.debugLineNum = 3145753;BA.debugLine="list_gozareshat_id.Initialize";
mostCurrent._list_gozareshat_id.Initialize();
RDebugUtils.currentLine=3145756;
 //BA.debugLineNum = 3145756;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
RDebugUtils.currentLine=3145758;
 //BA.debugLineNum = 3145758;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_gozareshat(String _year1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_list_gozareshat", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_list_gozareshat", new Object[] {_year1}));}
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub fill_list_gozareshat(year1 As String)";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="CLV_gozaresh.Clear";
mostCurrent._clv_gozaresh._clear();
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="list_gozareshat_id.Clear";
mostCurrent._list_gozareshat_id.Clear();
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ORDER BY  id DESC;")));
RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=3211273;
 //BA.debugLineNum = 3211273;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=3211274;
 //BA.debugLineNum = 3211274;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 96%x, 114dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (114)));
RDebugUtils.currentLine=3211275;
 //BA.debugLineNum = 3211275;BA.debugLine="p.LoadLayout(\"item_list_2\")";
mostCurrent._p.LoadLayout("item_list_2",mostCurrent.activityBA);
RDebugUtils.currentLine=3211277;
 //BA.debugLineNum = 3211277;BA.debugLine="CLV_gozaresh.Add(p,dbCode.res.GetString(\"id\"))";
mostCurrent._clv_gozaresh._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3211278;
 //BA.debugLineNum = 3211278;BA.debugLine="lbl_dateGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_dategozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date")));
RDebugUtils.currentLine=3211279;
 //BA.debugLineNum = 3211279;BA.debugLine="lbl_nameGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_namegozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title")));
RDebugUtils.currentLine=3211280;
 //BA.debugLineNum = 3211280;BA.debugLine="lbl_tozihGozaresh_CLV.Text=dbCode.res.GetString(";
mostCurrent._lbl_tozihgozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozih")));
RDebugUtils.currentLine=3211281;
 //BA.debugLineNum = 3211281;BA.debugLine="lbl_remove_from_list2.Tag=dbCode.res.GetString(\"";
mostCurrent._lbl_remove_from_list2.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3211282;
 //BA.debugLineNum = 3211282;BA.debugLine="pan_item_gozaresh.Tag=dbCode.res.GetString(\"id\")";
mostCurrent._pan_item_gozaresh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3211283;
 //BA.debugLineNum = 3211283;BA.debugLine="list_gozareshat_id.Add(dbCode.res.GetString(\"id\"";
mostCurrent._list_gozareshat_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=3211284;
 //BA.debugLineNum = 3211284;BA.debugLine="Log(dbCode.res.GetString(\"id\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("63211284",mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id"),0);
 }
;
RDebugUtils.currentLine=3211286;
 //BA.debugLineNum = 3211286;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=3211287;
 //BA.debugLineNum = 3211287;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=3211289;
 //BA.debugLineNum = 3211289;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_click", null));}
RDebugUtils.currentLine=7077888;
 //BA.debugLineNum = 7077888;BA.debugLine="Private Sub lbl_help_Click";
RDebugUtils.currentLine=7077891;
 //BA.debugLineNum = 7077891;BA.debugLine="bit_img0.Initialize(File.DirAssets,\"home-h0.jpg\")";
mostCurrent._bit_img0.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h0.jpg");
RDebugUtils.currentLine=7077892;
 //BA.debugLineNum = 7077892;BA.debugLine="bit_img1.Initialize(File.DirAssets,\"home-h1.jpg\")";
mostCurrent._bit_img1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h1.jpg");
RDebugUtils.currentLine=7077893;
 //BA.debugLineNum = 7077893;BA.debugLine="bit_img2.Initialize(File.DirAssets,\"home-h2.jpg\")";
mostCurrent._bit_img2.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h2.jpg");
RDebugUtils.currentLine=7077894;
 //BA.debugLineNum = 7077894;BA.debugLine="bit_img3.Initialize(File.DirAssets,\"home-h3.jpg\")";
mostCurrent._bit_img3.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h3.jpg");
RDebugUtils.currentLine=7077895;
 //BA.debugLineNum = 7077895;BA.debugLine="bit_img4.Initialize(File.DirAssets,\"home-h4.jpg\")";
mostCurrent._bit_img4.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h4.jpg");
RDebugUtils.currentLine=7077898;
 //BA.debugLineNum = 7077898;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
RDebugUtils.currentLine=7077899;
 //BA.debugLineNum = 7077899;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
RDebugUtils.currentLine=7077900;
 //BA.debugLineNum = 7077900;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7077902;
 //BA.debugLineNum = 7077902;BA.debugLine="End Sub";
return "";
}
public static String  _get_today_shift() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_today_shift", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_today_shift", null));}
int _id_today = 0;
String _str_sh = "";
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub get_today_shift";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Dim id_today As Int";
_id_today = 0;
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="id_today=dbCode.get_day_id(persianDate.PersianYea";
_id_today = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_persiandate.getPersianYear(),_persiandate.getPersianMonth(),_persiandate.getPersianDay());
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id_today))));
RDebugUtils.currentLine=2883591;
 //BA.debugLineNum = 2883591;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=2883592;
 //BA.debugLineNum = 2883592;BA.debugLine="Try";
try {RDebugUtils.currentLine=2883593;
 //BA.debugLineNum = 2883593;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")).equals("") == false)) { 
RDebugUtils.currentLine=2883594;
 //BA.debugLineNum = 2883594;BA.debugLine="Dim str_sh As String";
_str_sh = "";
RDebugUtils.currentLine=2883595;
 //BA.debugLineNum = 2883595;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift"),"ر","ش","ع","ا","ص/ع","ع/ش","ص/ش")) {
case 0: {
RDebugUtils.currentLine=2883597;
 //BA.debugLineNum = 2883597;BA.debugLine="str_sh=\"روزکار\"";
_str_sh = "روزکار";
 break; }
case 1: {
RDebugUtils.currentLine=2883599;
 //BA.debugLineNum = 2883599;BA.debugLine="str_sh=\"شبکار\"";
_str_sh = "شبکار";
 break; }
case 2: {
RDebugUtils.currentLine=2883601;
 //BA.debugLineNum = 2883601;BA.debugLine="str_sh=\"عصرکار\"";
_str_sh = "عصرکار";
 break; }
case 3: {
RDebugUtils.currentLine=2883603;
 //BA.debugLineNum = 2883603;BA.debugLine="str_sh=\"استراحت\"";
_str_sh = "استراحت";
 break; }
case 4: {
RDebugUtils.currentLine=2883605;
 //BA.debugLineNum = 2883605;BA.debugLine="str_sh=\"صبح-عصر\"";
_str_sh = "صبح-عصر";
 break; }
case 5: {
RDebugUtils.currentLine=2883607;
 //BA.debugLineNum = 2883607;BA.debugLine="str_sh=\"عصر-شب\"";
_str_sh = "عصر-شب";
 break; }
case 6: {
RDebugUtils.currentLine=2883609;
 //BA.debugLineNum = 2883609;BA.debugLine="str_sh=\"صبح-شب\"";
_str_sh = "صبح-شب";
 break; }
}
;
RDebugUtils.currentLine=2883611;
 //BA.debugLineNum = 2883611;BA.debugLine="lbl_shift_home.Text=\"(\"&str_sh&\")\"";
mostCurrent._lbl_shift_home.setText(BA.ObjectToCharSequence("("+_str_sh+")"));
 };
 } 
       catch (Exception e28) {
			processBA.setLastException(e28);RDebugUtils.currentLine=2883614;
 //BA.debugLineNum = 2883614;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("62883614",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=2883621;
 //BA.debugLineNum = 2883621;BA.debugLine="End Sub";
return "";
}
public static String  _chek_time_backup() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chek_time_backup", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chek_time_backup", null));}
String _tim1_ck_backup = "";
String _tim2_ck_backup = "";
long _time_between = 0L;
int _days_for_backup = 0;
int _res_backup = 0;
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub chek_time_backup";
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="If(File.Exists(File.DirInternal,\"chk_backup.txt\")";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"chk_backup.txt")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=2818053;
 //BA.debugLineNum = 2818053;BA.debugLine="File.WriteString(File.DirInternal,\"chk_backup.tx";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"chk_backup.txt",mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 }else {
RDebugUtils.currentLine=2818056;
 //BA.debugLineNum = 2818056;BA.debugLine="Dim tim1_ck_backup As String=File.ReadString(Fil";
_tim1_ck_backup = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"chk_backup.txt");
RDebugUtils.currentLine=2818057;
 //BA.debugLineNum = 2818057;BA.debugLine="Dim tim2_ck_backup As String=myfunc.fa2en(DateTi";
_tim2_ck_backup = mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=2818058;
 //BA.debugLineNum = 2818058;BA.debugLine="Dim time_between As Long = persianDate.Calculate";
_time_between = _persiandate.CalculateDaysBetween(_tim1_ck_backup,_tim2_ck_backup);
RDebugUtils.currentLine=2818060;
 //BA.debugLineNum = 2818060;BA.debugLine="Dim days_for_backup As Int";
_days_for_backup = 0;
RDebugUtils.currentLine=2818061;
 //BA.debugLineNum = 2818061;BA.debugLine="Dim res_backup As Int = dbCode.get_setting_byNam";
_res_backup = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"backup_online")));
RDebugUtils.currentLine=2818062;
 //BA.debugLineNum = 2818062;BA.debugLine="Select res_backup";
switch (_res_backup) {
case 0: {
RDebugUtils.currentLine=2818064;
 //BA.debugLineNum = 2818064;BA.debugLine="days_for_backup=7";
_days_for_backup = (int) (7);
 break; }
case 1: {
RDebugUtils.currentLine=2818066;
 //BA.debugLineNum = 2818066;BA.debugLine="days_for_backup=14";
_days_for_backup = (int) (14);
 break; }
case 2: {
RDebugUtils.currentLine=2818068;
 //BA.debugLineNum = 2818068;BA.debugLine="days_for_backup=30";
_days_for_backup = (int) (30);
 break; }
case 3: {
RDebugUtils.currentLine=2818070;
 //BA.debugLineNum = 2818070;BA.debugLine="days_for_backup=-1";
_days_for_backup = (int) (-1);
 break; }
}
;
RDebugUtils.currentLine=2818076;
 //BA.debugLineNum = 2818076;BA.debugLine="If(days_for_backup<0)Then";
if ((_days_for_backup<0)) { 
RDebugUtils.currentLine=2818077;
 //BA.debugLineNum = 2818077;BA.debugLine="is_time_backup=False";
_is_time_backup = anywheresoftware.b4a.keywords.Common.False;
 }else 
{RDebugUtils.currentLine=2818078;
 //BA.debugLineNum = 2818078;BA.debugLine="else If(time_between>= days_for_backup)Then";
if ((_time_between>=_days_for_backup)) { 
RDebugUtils.currentLine=2818079;
 //BA.debugLineNum = 2818079;BA.debugLine="is_time_backup=True";
_is_time_backup = anywheresoftware.b4a.keywords.Common.True;
 }}
;
 };
RDebugUtils.currentLine=2818086;
 //BA.debugLineNum = 2818086;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_account_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_account_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_account_click", null));}
int _result12 = 0;
RDebugUtils.currentLine=9371648;
 //BA.debugLineNum = 9371648;BA.debugLine="Private Sub lbl_account_Click";
RDebugUtils.currentLine=9371657;
 //BA.debugLineNum = 9371657;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=9371658;
 //BA.debugLineNum = 9371658;BA.debugLine="StartActivity(step2_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step2_activity.getObject()));
 }else {
RDebugUtils.currentLine=9371663;
 //BA.debugLineNum = 9371663;BA.debugLine="Dim result12 As Int";
_result12 = 0;
RDebugUtils.currentLine=9371664;
 //BA.debugLineNum = 9371664;BA.debugLine="result12 = Msgbox2(\"اتصال اینترنت را بررسی کنید\"";
_result12 = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("اتصال اینترنت را بررسی کنید"),BA.ObjectToCharSequence("توجه!"),"تلاش دوباره","","بستن",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=9371665;
 //BA.debugLineNum = 9371665;BA.debugLine="If result12 = DialogResponse.Positive Then";
if (_result12==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=9371666;
 //BA.debugLineNum = 9371666;BA.debugLine="lbl_account_Click";
_lbl_account_click();
 };
 };
RDebugUtils.currentLine=9371672;
 //BA.debugLineNum = 9371672;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
RDebugUtils.currentLine=9371673;
 //BA.debugLineNum = 9371673;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_list_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_menu_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_menu_list_click", null));}
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Private Sub btn_menu_list_Click";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="index_page=2";
_index_page = (int) (2);
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="pan_imag.Background=img2";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img2.getObject()));
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="pan_main.LoadLayout(\"list_layout\")";
mostCurrent._pan_main.LoadLayout("list_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=2949127;
 //BA.debugLineNum = 2949127;BA.debugLine="sp_year.Add(\"1404\")";
mostCurrent._sp_year.Add("1404");
RDebugUtils.currentLine=2949128;
 //BA.debugLineNum = 2949128;BA.debugLine="sp_year.Add(\"1403\")";
mostCurrent._sp_year.Add("1403");
RDebugUtils.currentLine=2949129;
 //BA.debugLineNum = 2949129;BA.debugLine="sp_year.Add(\"1402\")";
mostCurrent._sp_year.Add("1402");
RDebugUtils.currentLine=2949130;
 //BA.debugLineNum = 2949130;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
RDebugUtils.currentLine=2949131;
 //BA.debugLineNum = 2949131;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
RDebugUtils.currentLine=2949132;
 //BA.debugLineNum = 2949132;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
RDebugUtils.currentLine=2949133;
 //BA.debugLineNum = 2949133;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
RDebugUtils.currentLine=2949135;
 //BA.debugLineNum = 2949135;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=2949138;
 //BA.debugLineNum = 2949138;BA.debugLine="sp_year.SelectedIndex=0";
mostCurrent._sp_year.setSelectedIndex((int) (0));
RDebugUtils.currentLine=2949139;
 //BA.debugLineNum = 2949139;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(persianDate.Pe";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))))-1));
RDebugUtils.currentLine=2949141;
 //BA.debugLineNum = 2949141;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(sp_moo";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=2949144;
 //BA.debugLineNum = 2949144;BA.debugLine="TabHost1.AddTab(\"اضافه کاری\" , \"tab_layout_ezafek";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"اضافه کاری","tab_layout_ezafekari.bal");
RDebugUtils.currentLine=2949145;
 //BA.debugLineNum = 2949145;BA.debugLine="TabHost1.AddTab(\"مرخصی\" , \"tab_layout_morakhasi.b";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"مرخصی","tab_layout_morakhasi.bal");
RDebugUtils.currentLine=2949146;
 //BA.debugLineNum = 2949146;BA.debugLine="TabHost1.AddTab(\"تردد\" , \"tab_layout_taradod.bal\"";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"تردد","tab_layout_taradod.bal");
RDebugUtils.currentLine=2949147;
 //BA.debugLineNum = 2949147;BA.debugLine="TabHost1.AddTab(\"مأموریت\" , \"tab_layout_mamoriat.";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"مأموریت","tab_layout_mamoriat.bal");
RDebugUtils.currentLine=2949149;
 //BA.debugLineNum = 2949149;BA.debugLine="TabHost1.CurrentTab=curent_tab_list";
mostCurrent._tabhost1.setCurrentTab(_curent_tab_list);
RDebugUtils.currentLine=2949151;
 //BA.debugLineNum = 2949151;BA.debugLine="list_ezafekari_id.Initialize";
mostCurrent._list_ezafekari_id.Initialize();
RDebugUtils.currentLine=2949154;
 //BA.debugLineNum = 2949154;BA.debugLine="list_morakhasi_id.Initialize";
mostCurrent._list_morakhasi_id.Initialize();
RDebugUtils.currentLine=2949157;
 //BA.debugLineNum = 2949157;BA.debugLine="list_taradod_id.Initialize";
mostCurrent._list_taradod_id.Initialize();
RDebugUtils.currentLine=2949160;
 //BA.debugLineNum = 2949160;BA.debugLine="list_mamoriat_id.Initialize";
mostCurrent._list_mamoriat_id.Initialize();
RDebugUtils.currentLine=2949164;
 //BA.debugLineNum = 2949164;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=2949168;
 //BA.debugLineNum = 2949168;BA.debugLine="pan_hed_list.Color=color4";
mostCurrent._pan_hed_list.setColor(_color4);
RDebugUtils.currentLine=2949175;
 //BA.debugLineNum = 2949175;BA.debugLine="End Sub";
return "";
}
public static String  _btneight_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btneight_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btneight_click", null));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub btnEight_Click";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="click_count_Increment_and_fill(btnEight.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btneight.getText());
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="End Sub";
return "";
}
public static String  _click_count_increment_and_fill(String _input_text) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "click_count_increment_and_fill", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "click_count_increment_and_fill", new Object[] {_input_text}));}
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub click_count_Increment_and_fill (input_Text As";
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="Click_Count = Click_Count + 1";
_click_count = (int) (_click_count+1);
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="Select Click_Count";
switch (_click_count) {
case 1: {
RDebugUtils.currentLine=2490374;
 //BA.debugLineNum = 2490374;BA.debugLine="key1.Color = Colors.Red";
mostCurrent._key1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2490377;
 //BA.debugLineNum = 2490377;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 2: {
RDebugUtils.currentLine=2490380;
 //BA.debugLineNum = 2490380;BA.debugLine="key2.Color = Colors.Red";
mostCurrent._key2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2490383;
 //BA.debugLineNum = 2490383;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 3: {
RDebugUtils.currentLine=2490386;
 //BA.debugLineNum = 2490386;BA.debugLine="key3.Color = Colors.Red";
mostCurrent._key3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2490389;
 //BA.debugLineNum = 2490389;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 4: {
RDebugUtils.currentLine=2490392;
 //BA.debugLineNum = 2490392;BA.debugLine="key4.Color = Colors.Red";
mostCurrent._key4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2490395;
 //BA.debugLineNum = 2490395;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
RDebugUtils.currentLine=2490401;
 //BA.debugLineNum = 2490401;BA.debugLine="If entered_Password = Master_Password Then";
if ((mostCurrent._entered_password).equals(mostCurrent._master_password)) { 
RDebugUtils.currentLine=2490404;
 //BA.debugLineNum = 2490404;BA.debugLine="resetting_all";
_resetting_all();
RDebugUtils.currentLine=2490406;
 //BA.debugLineNum = 2490406;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=2490408;
 //BA.debugLineNum = 2490408;BA.debugLine="ToastMessageShow(\"رمز عبور اشتباه است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("رمز عبور اشتباه است"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2490412;
 //BA.debugLineNum = 2490412;BA.debugLine="resetting_all";
_resetting_all();
 };
 break; }
}
;
RDebugUtils.currentLine=2490417;
 //BA.debugLineNum = 2490417;BA.debugLine="End Sub";
return "";
}
public static String  _btnfive_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnfive_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnfive_click", null));}
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub btnFive_Click";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="click_count_Increment_and_fill(btnFive.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnfive.getText());
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="End Sub";
return "";
}
public static String  _btnfour_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnfour_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnfour_click", null));}
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub btnFour_Click";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="click_count_Increment_and_fill(btnFour.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnfour.getText());
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="End Sub";
return "";
}
public static String  _btnnine_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnnine_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnnine_click", null));}
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub btnNine_Click";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="click_count_Increment_and_fill(btnNine.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnnine.getText());
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="End Sub";
return "";
}
public static String  _btnone_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnone_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnone_click", null));}
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub btnOne_Click";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="click_count_Increment_and_fill(btnOne.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btnone.getText());
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="End Sub";
return "";
}
public static String  _btnseven_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnseven_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnseven_click", null));}
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub btnSeven_Click";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="click_count_Increment_and_fill(btnSeven.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btnseven.getText());
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="End Sub";
return "";
}
public static String  _btnsix_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnsix_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnsix_click", null));}
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub btnSix_Click";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="click_count_Increment_and_fill(btnSix.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btnsix.getText());
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="End Sub";
return "";
}
public static String  _btnthree_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnthree_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnthree_click", null));}
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub btnThree_Click";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="click_count_Increment_and_fill(btnThree.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btnthree.getText());
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="End Sub";
return "";
}
public static String  _btntwo_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btntwo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btntwo_click", null));}
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub btnTwo_Click";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="click_count_Increment_and_fill(btnTwo.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btntwo.getText());
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="End Sub";
return "";
}
public static String  _btnzero_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnzero_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnzero_click", null));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub btnZero_Click";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="click_count_Increment_and_fill(btnZero.Text)";
_click_count_increment_and_fill(mostCurrent._btnzero.getText());
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="End Sub";
return "";
}
public static int  _chek_tatil_day(int _year1,int _moon1,int _day1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chek_tatil_day", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "chek_tatil_day", new Object[] {_year1,_moon1,_day1}));}
int _id_thisday = 0;
int _result_int = 0;
RDebugUtils.currentLine=6553600;
 //BA.debugLineNum = 6553600;BA.debugLine="Sub chek_tatil_day (year1 As Int,moon1 As Int, day";
RDebugUtils.currentLine=6553602;
 //BA.debugLineNum = 6553602;BA.debugLine="Dim id_thisDay As Int";
_id_thisday = 0;
RDebugUtils.currentLine=6553603;
 //BA.debugLineNum = 6553603;BA.debugLine="id_thisDay=dbCode.get_day_id(year1,moon1,day1)";
_id_thisday = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_year1,_moon1,_day1);
RDebugUtils.currentLine=6553605;
 //BA.debugLineNum = 6553605;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=6553606;
 //BA.debugLineNum = 6553606;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id_thisday))));
RDebugUtils.currentLine=6553608;
 //BA.debugLineNum = 6553608;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=6553611;
 //BA.debugLineNum = 6553611;BA.debugLine="Dim result_int As Int=0";
_result_int = (int) (0);
RDebugUtils.currentLine=6553612;
 //BA.debugLineNum = 6553612;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=6553613;
 //BA.debugLineNum = 6553613;BA.debugLine="result_int=1";
_result_int = (int) (1);
 }else 
{RDebugUtils.currentLine=6553614;
 //BA.debugLineNum = 6553614;BA.debugLine="else If (dbCode.res.GetString(\"state\") = \"tatil1\"";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil1"))) { 
RDebugUtils.currentLine=6553615;
 //BA.debugLineNum = 6553615;BA.debugLine="result_int=2";
_result_int = (int) (2);
 }}
;
RDebugUtils.currentLine=6553622;
 //BA.debugLineNum = 6553622;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=6553623;
 //BA.debugLineNum = 6553623;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=6553626;
 //BA.debugLineNum = 6553626;BA.debugLine="Return result_int    ' result_int=0 is not tatil";
if (true) return _result_int;
RDebugUtils.currentLine=6553628;
 //BA.debugLineNum = 6553628;BA.debugLine="End Sub";
return 0;
}
public static int  _chek_tatil_setting() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chek_tatil_setting", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "chek_tatil_setting", null));}
int _temp = 0;
int _sett_a = 0;
int _sett_b = 0;
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Sub chek_tatil_setting As Int";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="Dim temp As Int=0";
_temp = (int) (0);
RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="Dim sett_a ,sett_b  As Int=0";
_sett_a = 0;
_sett_b = (int) (0);
RDebugUtils.currentLine=6619140;
 //BA.debugLineNum = 6619140;BA.debugLine="sett_a=dbCode.get_setting_byName(\"setting_tatil_r";
_sett_a = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi")));
RDebugUtils.currentLine=6619141;
 //BA.debugLineNum = 6619141;BA.debugLine="sett_b=dbCode.get_setting_byName(\"setting_tatil_g";
_sett_b = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi")));
RDebugUtils.currentLine=6619144;
 //BA.debugLineNum = 6619144;BA.debugLine="If(sett_a=1)Then";
if ((_sett_a==1)) { 
RDebugUtils.currentLine=6619145;
 //BA.debugLineNum = 6619145;BA.debugLine="temp=11";
_temp = (int) (11);
RDebugUtils.currentLine=6619146;
 //BA.debugLineNum = 6619146;BA.debugLine="If (sett_b=1)Then";
if ((_sett_b==1)) { 
RDebugUtils.currentLine=6619147;
 //BA.debugLineNum = 6619147;BA.debugLine="temp=1";
_temp = (int) (1);
 };
 }else {
RDebugUtils.currentLine=6619151;
 //BA.debugLineNum = 6619151;BA.debugLine="temp=0";
_temp = (int) (0);
RDebugUtils.currentLine=6619152;
 //BA.debugLineNum = 6619152;BA.debugLine="If (sett_b=1)Then";
if ((_sett_b==1)) { 
RDebugUtils.currentLine=6619153;
 //BA.debugLineNum = 6619153;BA.debugLine="temp=22";
_temp = (int) (22);
 };
 };
RDebugUtils.currentLine=6619158;
 //BA.debugLineNum = 6619158;BA.debugLine="Return temp";
if (true) return _temp;
RDebugUtils.currentLine=6619160;
 //BA.debugLineNum = 6619160;BA.debugLine="End Sub";
return 0;
}
public static String  _chk_update_auto() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chk_update_auto", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chk_update_auto", null));}
String _send2 = "";
RDebugUtils.currentLine=9306112;
 //BA.debugLineNum = 9306112;BA.debugLine="Sub chk_update_auto";
RDebugUtils.currentLine=9306114;
 //BA.debugLineNum = 9306114;BA.debugLine="user_request_update=False";
_user_request_update = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=9306115;
 //BA.debugLineNum = 9306115;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=9306117;
 //BA.debugLineNum = 9306117;BA.debugLine="ht.Initialize(\"chkupdate\",Me)";
mostCurrent._ht._initialize /*String*/ (null,processBA,"chkupdate",main.getObject());
RDebugUtils.currentLine=9306118;
 //BA.debugLineNum = 9306118;BA.debugLine="Dim send2 As String";
_send2 = "";
RDebugUtils.currentLine=9306119;
 //BA.debugLineNum = 9306119;BA.debugLine="send2 = \"var=checkupdate\"";
_send2 = "var=checkupdate";
RDebugUtils.currentLine=9306120;
 //BA.debugLineNum = 9306120;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/chek_upda";
mostCurrent._ht._poststring /*String*/ (null,"https://taravatgroup.ir/chek_update.php",_send2);
 };
RDebugUtils.currentLine=9306123;
 //BA.debugLineNum = 9306123;BA.debugLine="End Sub";
return "";
}
public static String  _ckb_ezaf_taradod_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ckb_ezaf_taradod_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ckb_ezaf_taradod_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=9699328;
 //BA.debugLineNum = 9699328;BA.debugLine="Private Sub ckb_ezaf_taradod_CheckedChange(Checked";
RDebugUtils.currentLine=9699329;
 //BA.debugLineNum = 9699329;BA.debugLine="If(Checked=True)Then";
if ((_checked==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=9699330;
 //BA.debugLineNum = 9699330;BA.debugLine="radio_ez_adi.Enabled=True";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=9699331;
 //BA.debugLineNum = 9699331;BA.debugLine="radio_ez_fog.Enabled=True";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=9699333;
 //BA.debugLineNum = 9699333;BA.debugLine="radio_ez_adi.Enabled=False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9699334;
 //BA.debugLineNum = 9699334;BA.debugLine="radio_ez_fog.Enabled=False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=9699336;
 //BA.debugLineNum = 9699336;BA.debugLine="End Sub";
return "";
}
public static String  _ckb_ezaf_taradod_fs_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ckb_ezaf_taradod_fs_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ckb_ezaf_taradod_fs_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=10616832;
 //BA.debugLineNum = 10616832;BA.debugLine="Private Sub ckb_ezaf_taradod_fs_CheckedChange(Chec";
RDebugUtils.currentLine=10616833;
 //BA.debugLineNum = 10616833;BA.debugLine="If(Checked=True)Then";
if ((_checked==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=10616834;
 //BA.debugLineNum = 10616834;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=10616836;
 //BA.debugLineNum = 10616836;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=10616838;
 //BA.debugLineNum = 10616838;BA.debugLine="End Sub";
return "";
}
public static String  _resetting_all() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "resetting_all", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "resetting_all", null));}
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub resetting_all";
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="key1.color = Colors.White";
mostCurrent._key1.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="key2.Color = Colors.White";
mostCurrent._key2.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2555908;
 //BA.debugLineNum = 2555908;BA.debugLine="key3.Color = Colors.White";
mostCurrent._key3.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="key4.Color = Colors.white";
mostCurrent._key4.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2555912;
 //BA.debugLineNum = 2555912;BA.debugLine="entered_Password = \"\"";
mostCurrent._entered_password = "";
RDebugUtils.currentLine=2555916;
 //BA.debugLineNum = 2555916;BA.debugLine="Click_Count = 0";
_click_count = (int) (0);
RDebugUtils.currentLine=2555917;
 //BA.debugLineNum = 2555917;BA.debugLine="End Sub";
return "";
}
public static String  _cust_lv_taradod_itemclick(int _index,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cust_lv_taradod_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cust_lv_taradod_itemclick", new Object[] {_index,_value}));}
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Private Sub cust_LV_taradod_ItemClick (Index As In";
RDebugUtils.currentLine=8388610;
 //BA.debugLineNum = 8388610;BA.debugLine="End Sub";
return "";
}
public static String  _tabhost1_tabchanged() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tabhost1_tabchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tabhost1_tabchanged", null));}
anywheresoftware.b4a.objects.collections.List _ls_all_saat = null;
String _str_saat = "";
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Private Sub TabHost1_TabChanged";
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="Dim ls_all_saat As List";
_ls_all_saat = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="ls_all_saat.Initialize";
_ls_all_saat.Initialize();
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="Dim str_saat As String";
_str_saat = "";
RDebugUtils.currentLine=3014662;
 //BA.debugLineNum = 3014662;BA.debugLine="If(sp_year.IsInitialized)Then";
if ((mostCurrent._sp_year.IsInitialized())) { 
RDebugUtils.currentLine=3014668;
 //BA.debugLineNum = 3014668;BA.debugLine="Select TabHost1.CurrentTab";
switch (BA.switchObjectToInt(mostCurrent._tabhost1.getCurrentTab(),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
RDebugUtils.currentLine=3014670;
 //BA.debugLineNum = 3014670;BA.debugLine="ls_all_saat=dbCode.all_ezafekari_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
RDebugUtils.currentLine=3014671;
 //BA.debugLineNum = 3014671;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
case 1: {
RDebugUtils.currentLine=3014673;
 //BA.debugLineNum = 3014673;BA.debugLine="ls_all_saat=dbCode.all_morakhasi_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=3014675;
 //BA.debugLineNum = 3014675;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" روز و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" ساعت و "+BA.ObjectToString(_ls_all_saat.Get((int) (2)))+" دقیقه ";
 break; }
case 2: {
RDebugUtils.currentLine=3014677;
 //BA.debugLineNum = 3014677;BA.debugLine="ls_all_saat=dbCode.all_taradod_mah(myfunc.fa2e";
_ls_all_saat = mostCurrent._dbcode._all_taradod_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=3014678;
 //BA.debugLineNum = 3014678;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
case 3: {
RDebugUtils.currentLine=3014680;
 //BA.debugLineNum = 3014680;BA.debugLine="ls_all_saat=dbCode.all_mamoriat_mah(myfunc.fa2";
_ls_all_saat = mostCurrent._dbcode._all_mamoriat_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=3014681;
 //BA.debugLineNum = 3014681;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" روز و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" ساعت و "+BA.ObjectToString(_ls_all_saat.Get((int) (2)))+" دقیقه ";
 break; }
}
;
RDebugUtils.currentLine=3014688;
 //BA.debugLineNum = 3014688;BA.debugLine="lbl_majmoe_saat.Text=str_saat";
mostCurrent._lbl_majmoe_saat.setText(BA.ObjectToCharSequence(_str_saat));
 };
RDebugUtils.currentLine=3014694;
 //BA.debugLineNum = 3014694;BA.debugLine="End Sub";
return "";
}
public static String  _finger_scaning() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "finger_scaning", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "finger_scaning", null));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub finger_scaning";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="fingerprint.Authenticate";
mostCurrent._fingerprint._authenticate /*String*/ (null);
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="ToastMessageShow(\"Scanning...\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Scanning..."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="End Sub";
return "";
}
public static String  _get_dataedit_byid(int _id1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_dataedit_byid", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_dataedit_byid", new Object[] {_id1}));}
RDebugUtils.currentLine=7471104;
 //BA.debugLineNum = 7471104;BA.debugLine="Sub get_dataEdit_byId(id1 As Int)";
RDebugUtils.currentLine=7471105;
 //BA.debugLineNum = 7471105;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=7471106;
 //BA.debugLineNum = 7471106;BA.debugLine="If(index_box=1)Then";
if ((_index_box==1)) { 
RDebugUtils.currentLine=7471107;
 //BA.debugLineNum = 7471107;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=7471108;
 //BA.debugLineNum = 7471108;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=7471110;
 //BA.debugLineNum = 7471110;BA.debugLine="If(dbCode.res.GetInt(\"state\")=0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==0)) { 
RDebugUtils.currentLine=7471111;
 //BA.debugLineNum = 7471111;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=7471113;
 //BA.debugLineNum = 7471113;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
 }else 
{RDebugUtils.currentLine=7471118;
 //BA.debugLineNum = 7471118;BA.debugLine="Else If(index_box=2)Then";
if ((_index_box==2)) { 
RDebugUtils.currentLine=7471119;
 //BA.debugLineNum = 7471119;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=7471120;
 //BA.debugLineNum = 7471120;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=7471123;
 //BA.debugLineNum = 7471123;BA.debugLine="Select dbCode.res.GetInt(\"state\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
RDebugUtils.currentLine=7471125;
 //BA.debugLineNum = 7471125;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
RDebugUtils.currentLine=7471127;
 //BA.debugLineNum = 7471127;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
RDebugUtils.currentLine=7471129;
 //BA.debugLineNum = 7471129;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
RDebugUtils.currentLine=7471131;
 //BA.debugLineNum = 7471131;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
RDebugUtils.currentLine=7471135;
 //BA.debugLineNum = 7471135;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
RDebugUtils.currentLine=7471136;
 //BA.debugLineNum = 7471136;BA.debugLine="index_noe_morakhasi=dbCode.res.GetInt(\"state\")";
_index_noe_morakhasi = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state");
 }else 
{RDebugUtils.currentLine=7471140;
 //BA.debugLineNum = 7471140;BA.debugLine="Else If(index_box=3)Then";
if ((_index_box==3)) { 
RDebugUtils.currentLine=7471141;
 //BA.debugLineNum = 7471141;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=7471142;
 //BA.debugLineNum = 7471142;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 }else 
{RDebugUtils.currentLine=7471145;
 //BA.debugLineNum = 7471145;BA.debugLine="Else If(index_box=5)Then";
if ((_index_box==5)) { 
RDebugUtils.currentLine=7471146;
 //BA.debugLineNum = 7471146;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mamoriat WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=7471147;
 //BA.debugLineNum = 7471147;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 }}}}
;
RDebugUtils.currentLine=7471154;
 //BA.debugLineNum = 7471154;BA.debugLine="lbl_tim1.Text=dbCode.res.GetString(\"time_from\")";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")));
RDebugUtils.currentLine=7471155;
 //BA.debugLineNum = 7471155;BA.debugLine="lbl_tim2.Text=dbCode.res.GetString(\"time_to\")";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=7471157;
 //BA.debugLineNum = 7471157;BA.debugLine="lbl_date1.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=7471158;
 //BA.debugLineNum = 7471158;BA.debugLine="lbl_date2.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))));
RDebugUtils.currentLine=7471160;
 //BA.debugLineNum = 7471160;BA.debugLine="et_tozihat.Text=dbCode.res.GetString(\"tozihat\")";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=7471163;
 //BA.debugLineNum = 7471163;BA.debugLine="End Sub";
return "";
}
public static String  _get_request_kharid() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_request_kharid", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_request_kharid", null));}
ir.cafebazaar.poolakey.b4a.B4APurchaseRequest _request = null;
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub get_request_kharid";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Dim Request As PoolakeyPurchaseRequest";
_request = new ir.cafebazaar.poolakey.b4a.B4APurchaseRequest();
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="Request.ProductId = \"ezafekari2\"";
_request.setProductId("ezafekari2");
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="Request.Payload = \"PAYLOAD\"";
_request.setPayload("PAYLOAD");
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="Poolakey.PurchaseProduct(\"Purchase\", Request)";
mostCurrent._poolakey.PurchaseProduct(mostCurrent.activityBA,"Purchase",_request);
RDebugUtils.currentLine=1507336;
 //BA.debugLineNum = 1507336;BA.debugLine="End Sub";
return "";
}
public static String  _img_slider(int _index1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "img_slider", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "img_slider", new Object[] {_index1}));}
RDebugUtils.currentLine=7340032;
 //BA.debugLineNum = 7340032;BA.debugLine="Sub img_slider (index1 As Int)";
RDebugUtils.currentLine=7340033;
 //BA.debugLineNum = 7340033;BA.debugLine="Select index1";
switch (_index1) {
case 0: {
RDebugUtils.currentLine=7340035;
 //BA.debugLineNum = 7340035;BA.debugLine="img_help.Bitmap=bit_img0";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img0.getObject()));
 break; }
case 1: {
RDebugUtils.currentLine=7340037;
 //BA.debugLineNum = 7340037;BA.debugLine="img_help.Bitmap=bit_img1";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img1.getObject()));
 break; }
case 2: {
RDebugUtils.currentLine=7340040;
 //BA.debugLineNum = 7340040;BA.debugLine="img_help.Bitmap=bit_img2";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img2.getObject()));
 break; }
case 3: {
RDebugUtils.currentLine=7340043;
 //BA.debugLineNum = 7340043;BA.debugLine="img_help.Bitmap=bit_img3";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img3.getObject()));
 break; }
case 4: {
RDebugUtils.currentLine=7340046;
 //BA.debugLineNum = 7340046;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
 break; }
default: {
RDebugUtils.currentLine=7340049;
 //BA.debugLineNum = 7340049;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("67340049","error",0);
 break; }
}
;
RDebugUtils.currentLine=7340052;
 //BA.debugLineNum = 7340052;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(ir.taravatgroup.ezafekari2.httpjob _job) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
anywheresoftware.b4a.objects.collections.JSONParser _json_data = null;
anywheresoftware.b4a.objects.collections.List _listdata_fromjson = null;
String _date_json0 = "";
String _date_json1 = "";
String _date_json2 = "";
String _date_json3 = "";
String _date_json4 = "";
String _date_json5 = "";
String _date_json6 = "";
String _date_json7 = "";
String _date_json8 = "";
String _date_json9 = "";
anywheresoftware.b4a.objects.collections.List _ls_lock0 = null;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root1 = null;
String _str_type = "";
String _str_version_code = "";
String _str_version_name = "";
String _str_changelog_fa = "";
String _str_message = "";
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub Jobdone (job As HttpJob)";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Try";
try {RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="If job.JobName=\"ht\" Then";
if ((_job._jobname /*String*/ ).equals("ht")) { 
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="If(job.GetString <> \"\")Then";
if (((_job._getstring /*String*/ (null)).equals("") == false)) { 
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="Log(job.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("6720903",_job._getstring /*String*/ (null),0);
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="Dim Json_Data As JSONParser";
_json_data = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=720907;
 //BA.debugLineNum = 720907;BA.debugLine="Json_Data.Initialize(job.GetString)";
_json_data.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=720909;
 //BA.debugLineNum = 720909;BA.debugLine="Dim ListData_fromJson As List";
_listdata_fromjson = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=720910;
 //BA.debugLineNum = 720910;BA.debugLine="ListData_fromJson.Initialize";
_listdata_fromjson.Initialize();
RDebugUtils.currentLine=720911;
 //BA.debugLineNum = 720911;BA.debugLine="ListData_fromJson=Json_Data.NextArray";
_listdata_fromjson = _json_data.NextArray();
RDebugUtils.currentLine=720915;
 //BA.debugLineNum = 720915;BA.debugLine="Dim date_Json0 As String = ListData_fromJson.";
_date_json0 = BA.ObjectToString(_listdata_fromjson.Get((int) (0)));
RDebugUtils.currentLine=720916;
 //BA.debugLineNum = 720916;BA.debugLine="date_Json0=date_Json0.Replace(\"serv_key:\",\"\")";
_date_json0 = _date_json0.replace("serv_key:","");
RDebugUtils.currentLine=720917;
 //BA.debugLineNum = 720917;BA.debugLine="Dim date_Json1 As String = ListData_fromJson.";
_date_json1 = BA.ObjectToString(_listdata_fromjson.Get((int) (1)));
RDebugUtils.currentLine=720918;
 //BA.debugLineNum = 720918;BA.debugLine="date_Json1=date_Json1.Replace(\"serv_lock:\",\"\"";
_date_json1 = _date_json1.replace("serv_lock:","");
RDebugUtils.currentLine=720919;
 //BA.debugLineNum = 720919;BA.debugLine="Dim date_Json2 As String = ListData_fromJson.";
_date_json2 = BA.ObjectToString(_listdata_fromjson.Get((int) (2)));
RDebugUtils.currentLine=720920;
 //BA.debugLineNum = 720920;BA.debugLine="date_Json2=date_Json2.Replace(\"serv_activer:\"";
_date_json2 = _date_json2.replace("serv_activer:","");
RDebugUtils.currentLine=720921;
 //BA.debugLineNum = 720921;BA.debugLine="Dim date_Json3 As String = ListData_fromJson.";
_date_json3 = BA.ObjectToString(_listdata_fromjson.Get((int) (3)));
RDebugUtils.currentLine=720922;
 //BA.debugLineNum = 720922;BA.debugLine="date_Json3=date_Json3.Replace(\"serv_msg_code:";
_date_json3 = _date_json3.replace("serv_msg_code:","");
RDebugUtils.currentLine=720923;
 //BA.debugLineNum = 720923;BA.debugLine="Dim date_Json4 As String = ListData_fromJson.";
_date_json4 = BA.ObjectToString(_listdata_fromjson.Get((int) (4)));
RDebugUtils.currentLine=720924;
 //BA.debugLineNum = 720924;BA.debugLine="date_Json4=date_Json4.Replace(\"serv_msg:\",\"\")";
_date_json4 = _date_json4.replace("serv_msg:","");
RDebugUtils.currentLine=720925;
 //BA.debugLineNum = 720925;BA.debugLine="Dim date_Json5 As String = ListData_fromJson.";
_date_json5 = BA.ObjectToString(_listdata_fromjson.Get((int) (5)));
RDebugUtils.currentLine=720926;
 //BA.debugLineNum = 720926;BA.debugLine="date_Json5=date_Json5.Replace(\"serv_notif_cod";
_date_json5 = _date_json5.replace("serv_notif_code:","");
RDebugUtils.currentLine=720927;
 //BA.debugLineNum = 720927;BA.debugLine="Dim date_Json6 As String = ListData_fromJson.";
_date_json6 = BA.ObjectToString(_listdata_fromjson.Get((int) (6)));
RDebugUtils.currentLine=720928;
 //BA.debugLineNum = 720928;BA.debugLine="date_Json6=date_Json6.Replace(\"serv_notif:\",\"";
_date_json6 = _date_json6.replace("serv_notif:","");
RDebugUtils.currentLine=720929;
 //BA.debugLineNum = 720929;BA.debugLine="Dim date_Json7 As String = ListData_fromJson.";
_date_json7 = BA.ObjectToString(_listdata_fromjson.Get((int) (7)));
RDebugUtils.currentLine=720930;
 //BA.debugLineNum = 720930;BA.debugLine="date_Json7=date_Json7.Replace(\"serv_status:\",";
_date_json7 = _date_json7.replace("serv_status:","");
RDebugUtils.currentLine=720931;
 //BA.debugLineNum = 720931;BA.debugLine="Dim date_Json8 As String = ListData_fromJson.";
_date_json8 = BA.ObjectToString(_listdata_fromjson.Get((int) (8)));
RDebugUtils.currentLine=720932;
 //BA.debugLineNum = 720932;BA.debugLine="date_Json8=date_Json8.Replace(\"serv_err:\",\"\")";
_date_json8 = _date_json8.replace("serv_err:","");
RDebugUtils.currentLine=720933;
 //BA.debugLineNum = 720933;BA.debugLine="Dim date_Json9 As String = ListData_fromJson.";
_date_json9 = BA.ObjectToString(_listdata_fromjson.Get((int) (9)));
RDebugUtils.currentLine=720934;
 //BA.debugLineNum = 720934;BA.debugLine="date_Json9=date_Json9.Replace(\"serv_err_msg:\"";
_date_json9 = _date_json9.replace("serv_err_msg:","");
RDebugUtils.currentLine=720937;
 //BA.debugLineNum = 720937;BA.debugLine="Log(\"date_Json0:   \"&date_Json0)";
anywheresoftware.b4a.keywords.Common.LogImpl("6720937","date_Json0:   "+_date_json0,0);
RDebugUtils.currentLine=720938;
 //BA.debugLineNum = 720938;BA.debugLine="Log(\"date_Json1:   \"&date_Json1)";
anywheresoftware.b4a.keywords.Common.LogImpl("6720938","date_Json1:   "+_date_json1,0);
RDebugUtils.currentLine=720939;
 //BA.debugLineNum = 720939;BA.debugLine="Log(\"date_Json2:   \"&date_Json2)";
anywheresoftware.b4a.keywords.Common.LogImpl("6720939","date_Json2:   "+_date_json2,0);
RDebugUtils.currentLine=720940;
 //BA.debugLineNum = 720940;BA.debugLine="Log(\"date_Json3:   \"&date_Json3)";
anywheresoftware.b4a.keywords.Common.LogImpl("6720940","date_Json3:   "+_date_json3,0);
RDebugUtils.currentLine=720941;
 //BA.debugLineNum = 720941;BA.debugLine="Log(\"date_Json4:   \"&date_Json4)";
anywheresoftware.b4a.keywords.Common.LogImpl("6720941","date_Json4:   "+_date_json4,0);
RDebugUtils.currentLine=720942;
 //BA.debugLineNum = 720942;BA.debugLine="Log(\"date_Json5:   \"&date_Json5)";
anywheresoftware.b4a.keywords.Common.LogImpl("6720942","date_Json5:   "+_date_json5,0);
RDebugUtils.currentLine=720943;
 //BA.debugLineNum = 720943;BA.debugLine="Log(\"date_Json6:   \"&date_Json6)";
anywheresoftware.b4a.keywords.Common.LogImpl("6720943","date_Json6:   "+_date_json6,0);
RDebugUtils.currentLine=720944;
 //BA.debugLineNum = 720944;BA.debugLine="Log(\"date_Json7:   \"&date_Json7)";
anywheresoftware.b4a.keywords.Common.LogImpl("6720944","date_Json7:   "+_date_json7,0);
RDebugUtils.currentLine=720945;
 //BA.debugLineNum = 720945;BA.debugLine="Log(\"date_Json8:   \"&date_Json8)";
anywheresoftware.b4a.keywords.Common.LogImpl("6720945","date_Json8:   "+_date_json8,0);
RDebugUtils.currentLine=720946;
 //BA.debugLineNum = 720946;BA.debugLine="Log(\"date_Json9:   \"&date_Json9)";
anywheresoftware.b4a.keywords.Common.LogImpl("6720946","date_Json9:   "+_date_json9,0);
RDebugUtils.currentLine=720948;
 //BA.debugLineNum = 720948;BA.debugLine="If(date_Json0=\"wresv435fgd4443gfg\")Then";
if (((_date_json0).equals("wresv435fgd4443gfg"))) { 
RDebugUtils.currentLine=720951;
 //BA.debugLineNum = 720951;BA.debugLine="If (date_Json1=\"lockok\")Then";
if (((_date_json1).equals("lockok"))) { 
RDebugUtils.currentLine=720953;
 //BA.debugLineNum = 720953;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=720954;
 //BA.debugLineNum = 720954;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
RDebugUtils.currentLine=720956;
 //BA.debugLineNum = 720956;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=720957;
 //BA.debugLineNum = 720957;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"l";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
RDebugUtils.currentLine=720958;
 //BA.debugLineNum = 720958;BA.debugLine="ls_lock0.Set(0,\"true\")";
_ls_lock0.Set((int) (0),(Object)("true"));
RDebugUtils.currentLine=720959;
 //BA.debugLineNum = 720959;BA.debugLine="ls_lock0.Set(1,\"false\")";
_ls_lock0.Set((int) (1),(Object)("false"));
RDebugUtils.currentLine=720960;
 //BA.debugLineNum = 720960;BA.debugLine="ls_lock0.Set(2,\"2022\")";
_ls_lock0.Set((int) (2),(Object)("2022"));
 }else {
RDebugUtils.currentLine=720962;
 //BA.debugLineNum = 720962;BA.debugLine="ls_lock0.Add(\"true\")";
_ls_lock0.Add((Object)("true"));
RDebugUtils.currentLine=720963;
 //BA.debugLineNum = 720963;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
RDebugUtils.currentLine=720964;
 //BA.debugLineNum = 720964;BA.debugLine="ls_lock0.Add(\"2022\")";
_ls_lock0.Add((Object)("2022"));
RDebugUtils.currentLine=720965;
 //BA.debugLineNum = 720965;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 };
RDebugUtils.currentLine=720967;
 //BA.debugLineNum = 720967;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",l";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock0);
 }else 
{RDebugUtils.currentLine=720969;
 //BA.debugLineNum = 720969;BA.debugLine="Else If (date_Json1=\"lockno\")Then  ''-------";
if (((_date_json1).equals("lockno"))) { 
RDebugUtils.currentLine=720970;
 //BA.debugLineNum = 720970;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=720971;
 //BA.debugLineNum = 720971;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
RDebugUtils.currentLine=720973;
 //BA.debugLineNum = 720973;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=720974;
 //BA.debugLineNum = 720974;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"l";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
RDebugUtils.currentLine=720975;
 //BA.debugLineNum = 720975;BA.debugLine="ls_lock0.Set(0,\"false\")";
_ls_lock0.Set((int) (0),(Object)("false"));
RDebugUtils.currentLine=720976;
 //BA.debugLineNum = 720976;BA.debugLine="ls_lock0.Set(1,\"false\")";
_ls_lock0.Set((int) (1),(Object)("false"));
RDebugUtils.currentLine=720977;
 //BA.debugLineNum = 720977;BA.debugLine="ls_lock0.Set(2,\"\")";
_ls_lock0.Set((int) (2),(Object)(""));
 }else {
RDebugUtils.currentLine=720979;
 //BA.debugLineNum = 720979;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
RDebugUtils.currentLine=720980;
 //BA.debugLineNum = 720980;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
RDebugUtils.currentLine=720981;
 //BA.debugLineNum = 720981;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
RDebugUtils.currentLine=720982;
 //BA.debugLineNum = 720982;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 };
RDebugUtils.currentLine=720984;
 //BA.debugLineNum = 720984;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",l";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock0);
 }}
;
RDebugUtils.currentLine=720988;
 //BA.debugLineNum = 720988;BA.debugLine="If(date_Json2=\"accessok\")Then";
if (((_date_json2).equals("accessok"))) { 
RDebugUtils.currentLine=720991;
 //BA.debugLineNum = 720991;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\")";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
 }else {
RDebugUtils.currentLine=720994;
 //BA.debugLineNum = 720994;BA.debugLine="File.WriteString(File.DirInternal,\"payokok";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
RDebugUtils.currentLine=720995;
 //BA.debugLineNum = 720995;BA.debugLine="myfunc.help_man(\"توجه\",\"نسخه طلایی از طرف";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","نسخه طلایی از طرف ادمین فعال شد");
 };
 }else 
{RDebugUtils.currentLine=720999;
 //BA.debugLineNum = 720999;BA.debugLine="Else If (date_Json2=\"accessno\")Then";
if (((_date_json2).equals("accessno"))) { 
RDebugUtils.currentLine=721001;
 //BA.debugLineNum = 721001;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\")";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
RDebugUtils.currentLine=721002;
 //BA.debugLineNum = 721002;BA.debugLine="File.Delete(File.DirInternal,\"payokok\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok");
RDebugUtils.currentLine=721003;
 //BA.debugLineNum = 721003;BA.debugLine="myfunc.help_man(\"توجه\",\" نسخه طلایی از طرف";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه"," نسخه طلایی از طرف ادمین غیرفعال شد");
 };
 }}
;
RDebugUtils.currentLine=721010;
 //BA.debugLineNum = 721010;BA.debugLine="If (date_Json5<>\"0\")Then   ''-------new_noti";
if (((_date_json5).equals("0") == false)) { 
RDebugUtils.currentLine=721014;
 //BA.debugLineNum = 721014;BA.debugLine="notif_code=date_Json5";
mostCurrent._notif_code = _date_json5;
RDebugUtils.currentLine=721015;
 //BA.debugLineNum = 721015;BA.debugLine="notif_matn=date_Json6";
mostCurrent._notif_matn = _date_json6;
RDebugUtils.currentLine=721016;
 //BA.debugLineNum = 721016;BA.debugLine="tim_msg.Enabled=True";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=721020;
 //BA.debugLineNum = 721020;BA.debugLine="If (date_Json3<>\"0\")Then   ''-------new_noti";
if (((_date_json3).equals("0") == false)) { 
 };
 }else {
RDebugUtils.currentLine=721030;
 //BA.debugLineNum = 721030;BA.debugLine="ToastMessageShow(\"ارتباط با سرور برقرار نشد.";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط با سرور برقرار نشد."),anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=721114;
 //BA.debugLineNum = 721114;BA.debugLine="If job.JobName=\"chkupdate\" Then";
if ((_job._jobname /*String*/ ).equals("chkupdate")) { 
RDebugUtils.currentLine=721116;
 //BA.debugLineNum = 721116;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=721118;
 //BA.debugLineNum = 721118;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=721120;
 //BA.debugLineNum = 721120;BA.debugLine="Dim root1 As List";
_root1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=721121;
 //BA.debugLineNum = 721121;BA.debugLine="root1.Initialize";
_root1.Initialize();
RDebugUtils.currentLine=721122;
 //BA.debugLineNum = 721122;BA.debugLine="root1=parser.NextArray";
_root1 = _parser.NextArray();
RDebugUtils.currentLine=721124;
 //BA.debugLineNum = 721124;BA.debugLine="Dim str_type As String = root1.Get(0)";
_str_type = BA.ObjectToString(_root1.Get((int) (0)));
RDebugUtils.currentLine=721125;
 //BA.debugLineNum = 721125;BA.debugLine="str_type= str_type.Replace(\"type:\",\"\")";
_str_type = _str_type.replace("type:","");
RDebugUtils.currentLine=721127;
 //BA.debugLineNum = 721127;BA.debugLine="Dim str_version_code As String = root1.Get(1)";
_str_version_code = BA.ObjectToString(_root1.Get((int) (1)));
RDebugUtils.currentLine=721128;
 //BA.debugLineNum = 721128;BA.debugLine="str_version_code=str_version_code.Replace(\"ver";
_str_version_code = _str_version_code.replace("version_code:","");
RDebugUtils.currentLine=721130;
 //BA.debugLineNum = 721130;BA.debugLine="Dim str_version_name As String = root1.Get(2)";
_str_version_name = BA.ObjectToString(_root1.Get((int) (2)));
RDebugUtils.currentLine=721131;
 //BA.debugLineNum = 721131;BA.debugLine="str_version_name=str_version_name.Replace(\"ver";
_str_version_name = _str_version_name.replace("version_name:","");
RDebugUtils.currentLine=721133;
 //BA.debugLineNum = 721133;BA.debugLine="Dim str_changelog_fa As String = root1.Get(3)";
_str_changelog_fa = BA.ObjectToString(_root1.Get((int) (3)));
RDebugUtils.currentLine=721134;
 //BA.debugLineNum = 721134;BA.debugLine="str_changelog_fa=str_changelog_fa.Replace(\"cha";
_str_changelog_fa = _str_changelog_fa.replace("changelog_fa:","");
RDebugUtils.currentLine=721136;
 //BA.debugLineNum = 721136;BA.debugLine="Dim str_message As String = root1.Get(4)";
_str_message = BA.ObjectToString(_root1.Get((int) (4)));
RDebugUtils.currentLine=721137;
 //BA.debugLineNum = 721137;BA.debugLine="str_message=str_message.Replace(\"message:\",\"\")";
_str_message = _str_message.replace("message:","");
RDebugUtils.currentLine=721144;
 //BA.debugLineNum = 721144;BA.debugLine="If(user_request_update=True)Then";
if ((_user_request_update==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=721146;
 //BA.debugLineNum = 721146;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=721147;
 //BA.debugLineNum = 721147;BA.debugLine="pan_all_chekUpdate.Visible=True";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=721149;
 //BA.debugLineNum = 721149;BA.debugLine="If(str_type==\"success\")Then";
if (((_str_type).equals("success"))) { 
RDebugUtils.currentLine=721150;
 //BA.debugLineNum = 721150;BA.debugLine="If(str_version_code>Application.VersionCode)";
if (((double)(Double.parseDouble(_str_version_code))>anywheresoftware.b4a.keywords.Common.Application.getVersionCode())) { 
RDebugUtils.currentLine=721151;
 //BA.debugLineNum = 721151;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body><span style='color:#3AAD00; font-weight: bold;'> بروزرسانی جدید موجود است. </span><br> "+_str_changelog_fa+"</body></html>");
RDebugUtils.currentLine=721152;
 //BA.debugLineNum = 721152;BA.debugLine="lbl_chk_update_ok.Tag=1";
mostCurrent._lbl_chk_update_ok.setTag((Object)(1));
RDebugUtils.currentLine=721153;
 //BA.debugLineNum = 721153;BA.debugLine="lbl_chk_update_ok.Text=\"بروزرسانی برنامه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("بروزرسانی برنامه"));
 }else {
RDebugUtils.currentLine=721155;
 //BA.debugLineNum = 721155;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body> برنامه شما بروز می باشد. با تشکر </body></html>");
RDebugUtils.currentLine=721156;
 //BA.debugLineNum = 721156;BA.debugLine="lbl_chk_update_ok.Tag=0";
mostCurrent._lbl_chk_update_ok.setTag((Object)(0));
RDebugUtils.currentLine=721157;
 //BA.debugLineNum = 721157;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("باشه"));
 };
 }else 
{RDebugUtils.currentLine=721160;
 //BA.debugLineNum = 721160;BA.debugLine="Else if (str_type==\"unsuccess\")Then";
if (((_str_type).equals("unsuccess"))) { 
RDebugUtils.currentLine=721161;
 //BA.debugLineNum = 721161;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl'";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>خطا در اتصال</body></html>");
RDebugUtils.currentLine=721162;
 //BA.debugLineNum = 721162;BA.debugLine="lbl_chk_update_ok.Tag=0";
mostCurrent._lbl_chk_update_ok.setTag((Object)(0));
RDebugUtils.currentLine=721163;
 //BA.debugLineNum = 721163;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("باشه"));
 }}
;
 }else {
RDebugUtils.currentLine=721171;
 //BA.debugLineNum = 721171;BA.debugLine="If(str_type==\"success\")Then";
if (((_str_type).equals("success"))) { 
RDebugUtils.currentLine=721173;
 //BA.debugLineNum = 721173;BA.debugLine="If(str_version_code>Application.VersionCode)";
if (((double)(Double.parseDouble(_str_version_code))>anywheresoftware.b4a.keywords.Common.Application.getVersionCode())) { 
RDebugUtils.currentLine=721174;
 //BA.debugLineNum = 721174;BA.debugLine="pan_all_chekUpdate.Visible=True";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=721176;
 //BA.debugLineNum = 721176;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body><span style='color:#3AAD00; font-weight: bold;'> بروزرسانی جدید موجود است. </span><br> "+_str_changelog_fa+"</body></html>");
RDebugUtils.currentLine=721177;
 //BA.debugLineNum = 721177;BA.debugLine="lbl_chk_update_ok.Tag=1";
mostCurrent._lbl_chk_update_ok.setTag((Object)(1));
RDebugUtils.currentLine=721178;
 //BA.debugLineNum = 721178;BA.debugLine="lbl_chk_update_ok.Text=\"بروزرسانی برنامه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("بروزرسانی برنامه"));
 };
 };
 };
 };
 }else {
 };
 } 
       catch (Exception e145) {
			processBA.setLastException(e145);RDebugUtils.currentLine=721193;
 //BA.debugLineNum = 721193;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("6721193",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=721194;
 //BA.debugLineNum = 721194;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=721197;
 //BA.debugLineNum = 721197;BA.debugLine="End Sub";
return "";
}
public static void  _kharid() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "kharid", false))
	 {Debug.delegate(mostCurrent.activityBA, "kharid", null); return;}
ResumableSub_kharid rsub = new ResumableSub_kharid(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_kharid extends BA.ResumableSub {
public ResumableSub_kharid(ir.taravatgroup.ezafekari2.main parent) {
this.parent = parent;
}
ir.taravatgroup.ezafekari2.main parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=1048585;
 //BA.debugLineNum = 1048585;BA.debugLine="If(myfunc.check_internet)Then";
if (true) break;

case 1:
//if
this.state = 12;
if ((parent.mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
this.state = 3;
}else {
this.state = 11;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=1048586;
 //BA.debugLineNum = 1048586;BA.debugLine="Try";
if (true) break;

case 4:
//try
this.state = 9;
this.catchState = 8;
this.state = 6;
if (true) break;

case 6:
//C
this.state = 9;
this.catchState = 8;
RDebugUtils.currentLine=1048589;
 //BA.debugLineNum = 1048589;BA.debugLine="Poolakey.Connect(\"Poolakey\")";
parent.mostCurrent._poolakey.Connect(mostCurrent.activityBA,"Poolakey");
RDebugUtils.currentLine=1048590;
 //BA.debugLineNum = 1048590;BA.debugLine="Wait For Poolakey_ConnectionSucceed";
anywheresoftware.b4a.keywords.Common.WaitFor("poolakey_connectionsucceed", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "kharid"), null);
this.state = 13;
return;
case 13:
//C
this.state = 9;
;
RDebugUtils.currentLine=1048596;
 //BA.debugLineNum = 1048596;BA.debugLine="Poolakey.GetPurchasedProducts(\"Query\")";
parent.mostCurrent._poolakey.GetPurchasedProducts(mostCurrent.activityBA,"Query");
 if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
RDebugUtils.currentLine=1048599;
 //BA.debugLineNum = 1048599;BA.debugLine="MsgboxAsync(\"1- از نصب بودن برنامه بازار اطمینا";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("1- از نصب بودن برنامه بازار اطمینان یابید."+anywheresoftware.b4a.keywords.Common.CRLF+" 2- برنامه ها را ببندید و دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 if (true) break;
if (true) break;

case 9:
//C
this.state = 12;
this.catchState = 0;
;
 if (true) break;

case 11:
//C
this.state = 12;
RDebugUtils.currentLine=1048602;
 //BA.debugLineNum = 1048602;BA.debugLine="ToastMessageShow(\"خطا در اتصال \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال "),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 12:
//C
this.state = -1;
;
RDebugUtils.currentLine=1048608;
 //BA.debugLineNum = 1048608;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static String  _pan_all_litemenu_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_litemenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_litemenu_click", null));}
RDebugUtils.currentLine=8650752;
 //BA.debugLineNum = 8650752;BA.debugLine="Private Sub pan_all_liteMenu_Click";
RDebugUtils.currentLine=8650753;
 //BA.debugLineNum = 8650753;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=8650754;
 //BA.debugLineNum = 8650754;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chk_update_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_chk_update_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_chk_update_click", null));}
String _send2 = "";
RDebugUtils.currentLine=9240576;
 //BA.debugLineNum = 9240576;BA.debugLine="Private Sub lbl_chk_update_Click";
RDebugUtils.currentLine=9240578;
 //BA.debugLineNum = 9240578;BA.debugLine="user_request_update=True";
_user_request_update = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=9240579;
 //BA.debugLineNum = 9240579;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=9240580;
 //BA.debugLineNum = 9240580;BA.debugLine="ProgressDialogShow(\"بررسی بروزرسانی ...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("بررسی بروزرسانی ..."));
RDebugUtils.currentLine=9240581;
 //BA.debugLineNum = 9240581;BA.debugLine="ht.Initialize(\"chkupdate\",Me)";
mostCurrent._ht._initialize /*String*/ (null,processBA,"chkupdate",main.getObject());
RDebugUtils.currentLine=9240582;
 //BA.debugLineNum = 9240582;BA.debugLine="Dim send2 As String";
_send2 = "";
RDebugUtils.currentLine=9240583;
 //BA.debugLineNum = 9240583;BA.debugLine="send2 = \"var=checkupdate\"";
_send2 = "var=checkupdate";
RDebugUtils.currentLine=9240584;
 //BA.debugLineNum = 9240584;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/chek_upda";
mostCurrent._ht._poststring /*String*/ (null,"https://taravatgroup.ir/chek_update.php",_send2);
 }else {
RDebugUtils.currentLine=9240586;
 //BA.debugLineNum = 9240586;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 };
RDebugUtils.currentLine=9240590;
 //BA.debugLineNum = 9240590;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
RDebugUtils.currentLine=9240591;
 //BA.debugLineNum = 9240591;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chk_update_ok_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_chk_update_ok_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_chk_update_ok_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _op = null;
RDebugUtils.currentLine=9568256;
 //BA.debugLineNum = 9568256;BA.debugLine="Private Sub lbl_chk_update_ok_Click";
RDebugUtils.currentLine=9568257;
 //BA.debugLineNum = 9568257;BA.debugLine="If (lbl_chk_update_ok.Tag==1)Then";
if (((mostCurrent._lbl_chk_update_ok.getTag()).equals((Object)(1)))) { 
RDebugUtils.currentLine=9568258;
 //BA.debugLineNum = 9568258;BA.debugLine="Try";
try {RDebugUtils.currentLine=9568259;
 //BA.debugLineNum = 9568259;BA.debugLine="Dim op As Intent";
_op = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=9568260;
 //BA.debugLineNum = 9568260;BA.debugLine="op.Initialize(op.ACTION_VIEW,\"bazaar://details?";
_op.Initialize(_op.ACTION_VIEW,"bazaar://details?id=ir.taravatgroup.ezafekari2");
RDebugUtils.currentLine=9568261;
 //BA.debugLineNum = 9568261;BA.debugLine="op.SetPackage(\"com.farsitel.bazaar\")";
_op.SetPackage("com.farsitel.bazaar");
RDebugUtils.currentLine=9568262;
 //BA.debugLineNum = 9568262;BA.debugLine="StartActivity(op)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_op.getObject()));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=9568264;
 //BA.debugLineNum = 9568264;BA.debugLine="myfunc.help_man(\"توجه\",\"برنامه بازار را نصب کنی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","برنامه بازار را نصب کنید !");
RDebugUtils.currentLine=9568266;
 //BA.debugLineNum = 9568266;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("69568266",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
RDebugUtils.currentLine=9568273;
 //BA.debugLineNum = 9568273;BA.debugLine="pan_all_chekUpdate_Click";
_pan_all_chekupdate_click();
RDebugUtils.currentLine=9568274;
 //BA.debugLineNum = 9568274;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_chekupdate_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_chekupdate_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_chekupdate_click", null));}
RDebugUtils.currentLine=9437184;
 //BA.debugLineNum = 9437184;BA.debugLine="Private Sub pan_all_chekUpdate_Click";
RDebugUtils.currentLine=9437185;
 //BA.debugLineNum = 9437185;BA.debugLine="pan_all_chekUpdate.Visible=False";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9437186;
 //BA.debugLineNum = 9437186;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_msgnewy_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_msgnewy_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_msgnewy_click", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub lbl_close_msgNewY_Click";
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date1_click", null));}
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Private Sub lbl_date1_Click";
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="lbl_tim1_Click";
_lbl_tim1_click();
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_tim1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_tim1_click", null));}
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Private Sub lbl_tim1_Click";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="index_piker=1";
_index_piker = (int) (1);
RDebugUtils.currentLine=6356995;
 //BA.debugLineNum = 6356995;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim1.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (0))));
RDebugUtils.currentLine=6356996;
 //BA.debugLineNum = 6356996;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim1.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (1))));
RDebugUtils.currentLine=6356998;
 //BA.debugLineNum = 6356998;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date1.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (0))));
RDebugUtils.currentLine=6356999;
 //BA.debugLineNum = 6356999;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (1)));
RDebugUtils.currentLine=6357000;
 //BA.debugLineNum = 6357000;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=6357001;
 //BA.debugLineNum = 6357001;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (2))));
RDebugUtils.currentLine=6357005;
 //BA.debugLineNum = 6357005;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6357007;
 //BA.debugLineNum = 6357007;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=6357008;
 //BA.debugLineNum = 6357008;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=6357009;
 //BA.debugLineNum = 6357009;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
RDebugUtils.currentLine=6357010;
 //BA.debugLineNum = 6357010;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
RDebugUtils.currentLine=6357011;
 //BA.debugLineNum = 6357011;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
RDebugUtils.currentLine=6357014;
 //BA.debugLineNum = 6357014;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date2_click", null));}
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Private Sub lbl_date2_Click";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="lbl_tim2_Click";
_lbl_tim2_click();
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_tim2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_tim2_click", null));}
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Private Sub lbl_tim2_Click";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="index_piker=2";
_index_piker = (int) (2);
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim2.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (0))));
RDebugUtils.currentLine=6160387;
 //BA.debugLineNum = 6160387;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim2.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (1))));
RDebugUtils.currentLine=6160389;
 //BA.debugLineNum = 6160389;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date2.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (0))));
RDebugUtils.currentLine=6160390;
 //BA.debugLineNum = 6160390;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (1)));
RDebugUtils.currentLine=6160391;
 //BA.debugLineNum = 6160391;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=6160392;
 //BA.debugLineNum = 6160392;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (2))));
RDebugUtils.currentLine=6160395;
 //BA.debugLineNum = 6160395;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6160398;
 //BA.debugLineNum = 6160398;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=6160399;
 //BA.debugLineNum = 6160399;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=6160400;
 //BA.debugLineNum = 6160400;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
RDebugUtils.currentLine=6160401;
 //BA.debugLineNum = 6160401;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
RDebugUtils.currentLine=6160402;
 //BA.debugLineNum = 6160402;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
RDebugUtils.currentLine=6160404;
 //BA.debugLineNum = 6160404;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_from_list_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
RDebugUtils.currentLine=7405568;
 //BA.debugLineNum = 7405568;BA.debugLine="Private Sub lbl_edit_from_list_Click";
RDebugUtils.currentLine=7405569;
 //BA.debugLineNum = 7405569;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7405570;
 //BA.debugLineNum = 7405570;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=7405571;
 //BA.debugLineNum = 7405571;BA.debugLine="Log(b.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("67405571",BA.ObjectToString(_b.getTag()),0);
RDebugUtils.currentLine=7405572;
 //BA.debugLineNum = 7405572;BA.debugLine="current_id_edit=b.Tag";
_current_id_edit = (int)(BA.ObjectToNumber(_b.getTag()));
RDebugUtils.currentLine=7405576;
 //BA.debugLineNum = 7405576;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
RDebugUtils.currentLine=7405577;
 //BA.debugLineNum = 7405577;BA.debugLine="pan_add_ezafekari_Click";
_pan_add_ezafekari_click();
RDebugUtils.currentLine=7405578;
 //BA.debugLineNum = 7405578;BA.debugLine="lbl_box_title.Text=\"ویرایش اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش اضافه کاری"));
 }else 
{RDebugUtils.currentLine=7405580;
 //BA.debugLineNum = 7405580;BA.debugLine="Else if (TabHost1.CurrentTab=1)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==1)) { 
RDebugUtils.currentLine=7405581;
 //BA.debugLineNum = 7405581;BA.debugLine="pan_add_morakhasi_Click";
_pan_add_morakhasi_click();
RDebugUtils.currentLine=7405582;
 //BA.debugLineNum = 7405582;BA.debugLine="lbl_box_title.Text=\"ویرایش مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش مرخصی"));
 }else 
{RDebugUtils.currentLine=7405584;
 //BA.debugLineNum = 7405584;BA.debugLine="Else if (TabHost1.CurrentTab=2)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==2)) { 
RDebugUtils.currentLine=7405585;
 //BA.debugLineNum = 7405585;BA.debugLine="pan_add_taradod_Click";
_pan_add_taradod_click();
RDebugUtils.currentLine=7405586;
 //BA.debugLineNum = 7405586;BA.debugLine="lbl_box_title.Text=\"ویرایش تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش تردد"));
RDebugUtils.currentLine=7405588;
 //BA.debugLineNum = 7405588;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7405589;
 //BA.debugLineNum = 7405589;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7405591;
 //BA.debugLineNum = 7405591;BA.debugLine="myfunc.help_man(\"توجه\",\"اگر برای این تردد اضافه";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اگر برای این تردد اضافه کاری ثبت شده است، لازم است آن را هم ویرایش کنید.");
 }else 
{RDebugUtils.currentLine=7405592;
 //BA.debugLineNum = 7405592;BA.debugLine="Else if (TabHost1.CurrentTab=3)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==3)) { 
RDebugUtils.currentLine=7405593;
 //BA.debugLineNum = 7405593;BA.debugLine="pan_add_mamoriat_Click";
_pan_add_mamoriat_click();
RDebugUtils.currentLine=7405594;
 //BA.debugLineNum = 7405594;BA.debugLine="lbl_box_title.Text=\"ویرایش مأموریت\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش مأموریت"));
 }}}}
;
RDebugUtils.currentLine=7405597;
 //BA.debugLineNum = 7405597;BA.debugLine="is_for_edit=True";
_is_for_edit = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=7405598;
 //BA.debugLineNum = 7405598;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7405599;
 //BA.debugLineNum = 7405599;BA.debugLine="get_dataEdit_byId(current_id_edit)";
_get_dataedit_byid(_current_id_edit);
RDebugUtils.currentLine=7405603;
 //BA.debugLineNum = 7405603;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7405604;
 //BA.debugLineNum = 7405604;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=7405608;
 //BA.debugLineNum = 7405608;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=7405612;
 //BA.debugLineNum = 7405612;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_ezafekari_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_ezafekari_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_ezafekari_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Private Sub pan_add_ezafekari_Click";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3735559;
 //BA.debugLineNum = 3735559;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3735561;
 //BA.debugLineNum = 3735561;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3735562;
 //BA.debugLineNum = 3735562;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3735564;
 //BA.debugLineNum = 3735564;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3735565;
 //BA.debugLineNum = 3735565;BA.debugLine="lbl_box_title.Text=\"ثبت اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت اضافه کاری"));
RDebugUtils.currentLine=3735566;
 //BA.debugLineNum = 3735566;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
RDebugUtils.currentLine=3735567;
 //BA.debugLineNum = 3735567;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
RDebugUtils.currentLine=3735568;
 //BA.debugLineNum = 3735568;BA.debugLine="index_box=1";
_index_box = (int) (1);
RDebugUtils.currentLine=3735569;
 //BA.debugLineNum = 3735569;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3735570;
 //BA.debugLineNum = 3735570;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3735571;
 //BA.debugLineNum = 3735571;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3735572;
 //BA.debugLineNum = 3735572;BA.debugLine="lbl_ezaf_taradod.Text=\"فوق العاده (جمعه کاری)\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("فوق العاده (جمعه کاری)"));
RDebugUtils.currentLine=3735573;
 //BA.debugLineNum = 3735573;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3735574;
 //BA.debugLineNum = 3735574;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3735575;
 //BA.debugLineNum = 3735575;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3735576;
 //BA.debugLineNum = 3735576;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3735581;
 //BA.debugLineNum = 3735581;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
RDebugUtils.currentLine=3735582;
 //BA.debugLineNum = 3735582;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
RDebugUtils.currentLine=3735583;
 //BA.debugLineNum = 3735583;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=3735584;
 //BA.debugLineNum = 3735584;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
RDebugUtils.currentLine=3735587;
 //BA.debugLineNum = 3735587;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3735588;
 //BA.debugLineNum = 3735588;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3735592;
 //BA.debugLineNum = 3735592;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_from_ezafe";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3735593;
 //BA.debugLineNum = 3735593;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3735594;
 //BA.debugLineNum = 3735594;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=3735595;
 //BA.debugLineNum = 3735595;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_f";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt");
RDebugUtils.currentLine=3735600;
 //BA.debugLineNum = 3735600;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3735604;
 //BA.debugLineNum = 3735604;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
RDebugUtils.currentLine=3735606;
 //BA.debugLineNum = 3735606;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3735607;
 //BA.debugLineNum = 3735607;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=3735611;
 //BA.debugLineNum = 3735611;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_to_ezafeka";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3735612;
 //BA.debugLineNum = 3735612;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3735613;
 //BA.debugLineNum = 3735613;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=3735614;
 //BA.debugLineNum = 3735614;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt");
RDebugUtils.currentLine=3735620;
 //BA.debugLineNum = 3735620;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3735624;
 //BA.debugLineNum = 3735624;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
RDebugUtils.currentLine=3735626;
 //BA.debugLineNum = 3735626;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3735627;
 //BA.debugLineNum = 3735627;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=3735632;
 //BA.debugLineNum = 3735632;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3735634;
 //BA.debugLineNum = 3735634;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=3735637;
 //BA.debugLineNum = 3735637;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_morakhasi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_morakhasi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_morakhasi_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Private Sub pan_add_morakhasi_Click";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3538948;
 //BA.debugLineNum = 3538948;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3538950;
 //BA.debugLineNum = 3538950;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3538952;
 //BA.debugLineNum = 3538952;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3538953;
 //BA.debugLineNum = 3538953;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3538955;
 //BA.debugLineNum = 3538955;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3538956;
 //BA.debugLineNum = 3538956;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3538958;
 //BA.debugLineNum = 3538958;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3538959;
 //BA.debugLineNum = 3538959;BA.debugLine="lbl_box_title.Text=\"ثبت مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت مرخصی"));
RDebugUtils.currentLine=3538960;
 //BA.debugLineNum = 3538960;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
RDebugUtils.currentLine=3538961;
 //BA.debugLineNum = 3538961;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
RDebugUtils.currentLine=3538962;
 //BA.debugLineNum = 3538962;BA.debugLine="index_box=2";
_index_box = (int) (2);
RDebugUtils.currentLine=3538963;
 //BA.debugLineNum = 3538963;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3538964;
 //BA.debugLineNum = 3538964;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3538965;
 //BA.debugLineNum = 3538965;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
RDebugUtils.currentLine=3538966;
 //BA.debugLineNum = 3538966;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3538967;
 //BA.debugLineNum = 3538967;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
RDebugUtils.currentLine=3538968;
 //BA.debugLineNum = 3538968;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Red";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=3538969;
 //BA.debugLineNum = 3538969;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3538970;
 //BA.debugLineNum = 3538970;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3538975;
 //BA.debugLineNum = 3538975;BA.debugLine="rsPOP_noe.Initialize(\"rsPOP_noe\",lbl_ezaf_taradod";
mostCurrent._rspop_noe.Initialize(mostCurrent.activityBA,"rsPOP_noe",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_ezaf_taradod.getObject())));
RDebugUtils.currentLine=3538977;
 //BA.debugLineNum = 3538977;BA.debugLine="rsPOP_noe.AddMenuItem(0,0,\"استحقاقی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (0),(int) (0),"استحقاقی");
RDebugUtils.currentLine=3538978;
 //BA.debugLineNum = 3538978;BA.debugLine="rsPOP_noe.AddMenuItem(1,1,\"استعلاجی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (1),(int) (1),"استعلاجی");
RDebugUtils.currentLine=3538979;
 //BA.debugLineNum = 3538979;BA.debugLine="rsPOP_noe.AddMenuItem(2,2,\"سایر (با حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (2),(int) (2),"سایر (با حقوق)");
RDebugUtils.currentLine=3538980;
 //BA.debugLineNum = 3538980;BA.debugLine="rsPOP_noe.AddMenuItem(3,3,\"سایر (بدون حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (3),(int) (3),"سایر (بدون حقوق)");
RDebugUtils.currentLine=3538985;
 //BA.debugLineNum = 3538985;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
RDebugUtils.currentLine=3538986;
 //BA.debugLineNum = 3538986;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
RDebugUtils.currentLine=3538987;
 //BA.debugLineNum = 3538987;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=3538988;
 //BA.debugLineNum = 3538988;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
RDebugUtils.currentLine=3538991;
 //BA.debugLineNum = 3538991;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3538992;
 //BA.debugLineNum = 3538992;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3538998;
 //BA.debugLineNum = 3538998;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_from_morak";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3538999;
 //BA.debugLineNum = 3538999;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3539000;
 //BA.debugLineNum = 3539000;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=3539001;
 //BA.debugLineNum = 3539001;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_f";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt");
RDebugUtils.currentLine=3539006;
 //BA.debugLineNum = 3539006;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3539010;
 //BA.debugLineNum = 3539010;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
RDebugUtils.currentLine=3539012;
 //BA.debugLineNum = 3539012;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3539013;
 //BA.debugLineNum = 3539013;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=3539017;
 //BA.debugLineNum = 3539017;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_to_morakha";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3539018;
 //BA.debugLineNum = 3539018;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3539019;
 //BA.debugLineNum = 3539019;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=3539020;
 //BA.debugLineNum = 3539020;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt");
RDebugUtils.currentLine=3539025;
 //BA.debugLineNum = 3539025;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3539029;
 //BA.debugLineNum = 3539029;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
RDebugUtils.currentLine=3539031;
 //BA.debugLineNum = 3539031;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3539032;
 //BA.debugLineNum = 3539032;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=3539037;
 //BA.debugLineNum = 3539037;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3539039;
 //BA.debugLineNum = 3539039;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=3539043;
 //BA.debugLineNum = 3539043;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_taradod_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_taradod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_taradod_click", null));}
int _res_val2 = 0;
String _temp_finger = "";
anywheresoftware.b4a.objects.collections.List _ls_vorod0 = null;
anywheresoftware.b4a.objects.collections.List _ls_vorod1 = null;
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Private Sub pan_add_taradod_Click";
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="radio_ez_adi.Visible=True";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801095;
 //BA.debugLineNum = 3801095;BA.debugLine="radio_ez_fog.Visible=True";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801096;
 //BA.debugLineNum = 3801096;BA.debugLine="radio_ez_adi.Checked=True";
mostCurrent._radio_ez_adi.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801097;
 //BA.debugLineNum = 3801097;BA.debugLine="radio_ez_fog.Checked=False";
mostCurrent._radio_ez_fog.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801099;
 //BA.debugLineNum = 3801099;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801100;
 //BA.debugLineNum = 3801100;BA.debugLine="lbl_box_title.Text=\"ثبت تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت تردد"));
RDebugUtils.currentLine=3801101;
 //BA.debugLineNum = 3801101;BA.debugLine="lbl_time_as.Text=\"ورود :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("ورود :"));
RDebugUtils.currentLine=3801102;
 //BA.debugLineNum = 3801102;BA.debugLine="lbl_time_ta.Text=\"خروج :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("خروج :"));
RDebugUtils.currentLine=3801103;
 //BA.debugLineNum = 3801103;BA.debugLine="index_box=3";
_index_box = (int) (3);
RDebugUtils.currentLine=3801104;
 //BA.debugLineNum = 3801104;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3801105;
 //BA.debugLineNum = 3801105;BA.debugLine="lbl_time_show_fs.Text=\"\"";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3801107;
 //BA.debugLineNum = 3801107;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3801108;
 //BA.debugLineNum = 3801108;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801109;
 //BA.debugLineNum = 3801109;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3801110;
 //BA.debugLineNum = 3801110;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3801112;
 //BA.debugLineNum = 3801112;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801114;
 //BA.debugLineNum = 3801114;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801115;
 //BA.debugLineNum = 3801115;BA.debugLine="ckb_ezaf_taradod_fs.Checked=True";
mostCurrent._ckb_ezaf_taradod_fs.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801117;
 //BA.debugLineNum = 3801117;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
RDebugUtils.currentLine=3801118;
 //BA.debugLineNum = 3801118;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
RDebugUtils.currentLine=3801119;
 //BA.debugLineNum = 3801119;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=3801120;
 //BA.debugLineNum = 3801120;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
RDebugUtils.currentLine=3801123;
 //BA.debugLineNum = 3801123;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801124;
 //BA.debugLineNum = 3801124;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801129;
 //BA.debugLineNum = 3801129;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=3801130;
 //BA.debugLineNum = 3801130;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=3801131;
 //BA.debugLineNum = 3801131;BA.debugLine="lbl_setting_date.Visible=True";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801135;
 //BA.debugLineNum = 3801135;BA.debugLine="state_tatil= chek_tatil_day(myfunc.fa2en(pik_year";
_state_tatil = _chek_tatil_day((int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText()))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag())))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText()))));
RDebugUtils.currentLine=3801137;
 //BA.debugLineNum = 3801137;BA.debugLine="state_tatil_setting = chek_tatil_setting";
_state_tatil_setting = _chek_tatil_setting();
RDebugUtils.currentLine=3801139;
 //BA.debugLineNum = 3801139;BA.debugLine="day_inWeek_id=what_day(myfunc.fa2en(pik_year1.Tex";
_day_inweek_id = _what_day((int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText()))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag())))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText()))));
RDebugUtils.currentLine=3801142;
 //BA.debugLineNum = 3801142;BA.debugLine="If(state_tatil=0)Then";
if ((_state_tatil==0)) { 
RDebugUtils.currentLine=3801143;
 //BA.debugLineNum = 3801143;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+""));
 }else 
{RDebugUtils.currentLine=3801144;
 //BA.debugLineNum = 3801144;BA.debugLine="Else if (state_tatil=1) Then";
if ((_state_tatil==1)) { 
RDebugUtils.currentLine=3801145;
 //BA.debugLineNum = 3801145;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل رسم";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+" (تعطیل رسمی) "));
 }else 
{RDebugUtils.currentLine=3801146;
 //BA.debugLineNum = 3801146;BA.debugLine="Else if (state_tatil=2) Then";
if ((_state_tatil==2)) { 
RDebugUtils.currentLine=3801147;
 //BA.debugLineNum = 3801147;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل قرا";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+" (تعطیل قراردادی) "));
 }}}
;
RDebugUtils.currentLine=3801152;
 //BA.debugLineNum = 3801152;BA.debugLine="Dim res_val2 As Int =dbCode.get_setting_byName(\"s";
_res_val2 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode")));
RDebugUtils.currentLine=3801153;
 //BA.debugLineNum = 3801153;BA.debugLine="If(res_val2=1)Then";
if ((_res_val2==1)) { 
RDebugUtils.currentLine=3801155;
 //BA.debugLineNum = 3801155;BA.debugLine="pan_finger_taradod.Visible=True";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801157;
 //BA.debugLineNum = 3801157;BA.debugLine="lbl_finger_fs_vorod.Typeface=Typeface.MATERIALIC";
mostCurrent._lbl_finger_fs_vorod.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
RDebugUtils.currentLine=3801158;
 //BA.debugLineNum = 3801158;BA.debugLine="lbl_finger_fs_khoroj.Typeface=Typeface.MATERIALI";
mostCurrent._lbl_finger_fs_khoroj.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
RDebugUtils.currentLine=3801159;
 //BA.debugLineNum = 3801159;BA.debugLine="lbl_finger_fs_vorod.Text=Chr(0xE90D)";
mostCurrent._lbl_finger_fs_vorod.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe90d))));
RDebugUtils.currentLine=3801160;
 //BA.debugLineNum = 3801160;BA.debugLine="lbl_finger_fs_khoroj.Text=Chr(0xE90D)";
mostCurrent._lbl_finger_fs_khoroj.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe90d))));
RDebugUtils.currentLine=3801162;
 //BA.debugLineNum = 3801162;BA.debugLine="If(File.Exists(File.DirInternal,\"finger_vorod_ta";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3801165;
 //BA.debugLineNum = 3801165;BA.debugLine="Dim temp_finger As String = File.readString(Fil";
_temp_finger = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt");
RDebugUtils.currentLine=3801166;
 //BA.debugLineNum = 3801166;BA.debugLine="If(temp_finger=0)Then";
if (((_temp_finger).equals(BA.NumberToString(0)))) { 
RDebugUtils.currentLine=3801168;
 //BA.debugLineNum = 3801168;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
RDebugUtils.currentLine=3801170;
 //BA.debugLineNum = 3801170;BA.debugLine="save_box_allow=False";
_save_box_allow = anywheresoftware.b4a.keywords.Common.False;
 }else 
{RDebugUtils.currentLine=3801172;
 //BA.debugLineNum = 3801172;BA.debugLine="Else if (temp_finger=1)Then";
if (((_temp_finger).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=3801175;
 //BA.debugLineNum = 3801175;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=3801176;
 //BA.debugLineNum = 3801176;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=3801178;
 //BA.debugLineNum = 3801178;BA.debugLine="Dim ls_vorod0 As List";
_ls_vorod0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3801179;
 //BA.debugLineNum = 3801179;BA.debugLine="ls_vorod0.Initialize";
_ls_vorod0.Initialize();
RDebugUtils.currentLine=3801180;
 //BA.debugLineNum = 3801180;BA.debugLine="ls_vorod0=File.ReadList(File.DirInternal,\"temp";
_ls_vorod0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt");
RDebugUtils.currentLine=3801182;
 //BA.debugLineNum = 3801182;BA.debugLine="lbl_date1.Text=ls_vorod0.Get(0)";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (0))));
RDebugUtils.currentLine=3801183;
 //BA.debugLineNum = 3801183;BA.debugLine="lbl_tim1.Text=ls_vorod0.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (1))));
RDebugUtils.currentLine=3801185;
 //BA.debugLineNum = 3801185;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=3801187;
 //BA.debugLineNum = 3801187;BA.debugLine="lbl_finger_fs_vorod.Tag=0";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(0));
RDebugUtils.currentLine=3801188;
 //BA.debugLineNum = 3801188;BA.debugLine="lbl_finger_fs_khoroj.Tag=1";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(1));
RDebugUtils.currentLine=3801190;
 //BA.debugLineNum = 3801190;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3801191;
 //BA.debugLineNum = 3801191;BA.debugLine="lbl_time_show_fs.Text=\"\"";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3801193;
 //BA.debugLineNum = 3801193;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3801194;
 //BA.debugLineNum = 3801194;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3801196;
 //BA.debugLineNum = 3801196;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801197;
 //BA.debugLineNum = 3801197;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801198;
 //BA.debugLineNum = 3801198;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801199;
 //BA.debugLineNum = 3801199;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801203;
 //BA.debugLineNum = 3801203;BA.debugLine="save_box_allow=False";
_save_box_allow = anywheresoftware.b4a.keywords.Common.False;
 }else 
{RDebugUtils.currentLine=3801205;
 //BA.debugLineNum = 3801205;BA.debugLine="Else if (temp_finger=2)Then";
if (((_temp_finger).equals(BA.NumberToString(2)))) { 
RDebugUtils.currentLine=3801207;
 //BA.debugLineNum = 3801207;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=3801208;
 //BA.debugLineNum = 3801208;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=3801210;
 //BA.debugLineNum = 3801210;BA.debugLine="Dim ls_vorod0 As List";
_ls_vorod0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3801211;
 //BA.debugLineNum = 3801211;BA.debugLine="ls_vorod0.Initialize";
_ls_vorod0.Initialize();
RDebugUtils.currentLine=3801212;
 //BA.debugLineNum = 3801212;BA.debugLine="ls_vorod0=File.ReadList(File.DirInternal,\"temp";
_ls_vorod0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt");
RDebugUtils.currentLine=3801213;
 //BA.debugLineNum = 3801213;BA.debugLine="lbl_date1.Text=ls_vorod0.Get(0)";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (0))));
RDebugUtils.currentLine=3801214;
 //BA.debugLineNum = 3801214;BA.debugLine="lbl_tim1.Text=ls_vorod0.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (1))));
RDebugUtils.currentLine=3801215;
 //BA.debugLineNum = 3801215;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=3801219;
 //BA.debugLineNum = 3801219;BA.debugLine="Dim ls_vorod1 As List";
_ls_vorod1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3801220;
 //BA.debugLineNum = 3801220;BA.debugLine="ls_vorod1.Initialize";
_ls_vorod1.Initialize();
RDebugUtils.currentLine=3801221;
 //BA.debugLineNum = 3801221;BA.debugLine="ls_vorod1=File.ReadList(File.DirInternal,\"temp";
_ls_vorod1 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_khoroj.txt");
RDebugUtils.currentLine=3801222;
 //BA.debugLineNum = 3801222;BA.debugLine="lbl_date2.Text=ls_vorod1.Get(0)";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(_ls_vorod1.Get((int) (0))));
RDebugUtils.currentLine=3801223;
 //BA.debugLineNum = 3801223;BA.debugLine="lbl_tim2.Text=ls_vorod1.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_vorod1.Get((int) (1))));
RDebugUtils.currentLine=3801224;
 //BA.debugLineNum = 3801224;BA.debugLine="lbl_finger_fs_khoroj_time.Text=lbl_date2.Text&";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date2.getText()+" - "+mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=3801226;
 //BA.debugLineNum = 3801226;BA.debugLine="lbl_finger_fs_vorod.Tag=0";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(0));
RDebugUtils.currentLine=3801227;
 //BA.debugLineNum = 3801227;BA.debugLine="lbl_finger_fs_khoroj.Tag=0";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(0));
RDebugUtils.currentLine=3801229;
 //BA.debugLineNum = 3801229;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=3801231;
 //BA.debugLineNum = 3801231;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 }}}
;
 }else {
RDebugUtils.currentLine=3801234;
 //BA.debugLineNum = 3801234;BA.debugLine="lbl_finger_fs_vorod_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(" - "));
RDebugUtils.currentLine=3801235;
 //BA.debugLineNum = 3801235;BA.debugLine="lbl_finger_fs_khoroj_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(" - "));
RDebugUtils.currentLine=3801236;
 //BA.debugLineNum = 3801236;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=3801237;
 //BA.debugLineNum = 3801237;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=3801239;
 //BA.debugLineNum = 3801239;BA.debugLine="lbl_finger_fs_vorod.Tag=1";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(1));
RDebugUtils.currentLine=3801240;
 //BA.debugLineNum = 3801240;BA.debugLine="lbl_finger_fs_khoroj.Tag=2";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(2));
 };
 }else {
RDebugUtils.currentLine=3801248;
 //BA.debugLineNum = 3801248;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_vorod_tara";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3801249;
 //BA.debugLineNum = 3801249;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3801250;
 //BA.debugLineNum = 3801250;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=3801251;
 //BA.debugLineNum = 3801251;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_v";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt");
RDebugUtils.currentLine=3801256;
 //BA.debugLineNum = 3801256;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3801259;
 //BA.debugLineNum = 3801259;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
RDebugUtils.currentLine=3801261;
 //BA.debugLineNum = 3801261;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3801262;
 //BA.debugLineNum = 3801262;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=3801266;
 //BA.debugLineNum = 3801266;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_khoroj_tar";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3801267;
 //BA.debugLineNum = 3801267;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3801268;
 //BA.debugLineNum = 3801268;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=3801269;
 //BA.debugLineNum = 3801269;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt");
RDebugUtils.currentLine=3801274;
 //BA.debugLineNum = 3801274;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3801279;
 //BA.debugLineNum = 3801279;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
RDebugUtils.currentLine=3801281;
 //BA.debugLineNum = 3801281;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3801282;
 //BA.debugLineNum = 3801282;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=3801292;
 //BA.debugLineNum = 3801292;BA.debugLine="time_show";
_time_show();
 };
RDebugUtils.currentLine=3801305;
 //BA.debugLineNum = 3801305;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_mamoriat_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_mamoriat_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_mamoriat_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Private Sub pan_add_mamoriat_Click";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3866629;
 //BA.debugLineNum = 3866629;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3866631;
 //BA.debugLineNum = 3866631;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3866632;
 //BA.debugLineNum = 3866632;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3866633;
 //BA.debugLineNum = 3866633;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3866635;
 //BA.debugLineNum = 3866635;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3866636;
 //BA.debugLineNum = 3866636;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3866638;
 //BA.debugLineNum = 3866638;BA.debugLine="lbl_box_title.Text=\"ثبت مأموریت\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت مأموریت"));
RDebugUtils.currentLine=3866639;
 //BA.debugLineNum = 3866639;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
RDebugUtils.currentLine=3866640;
 //BA.debugLineNum = 3866640;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
RDebugUtils.currentLine=3866641;
 //BA.debugLineNum = 3866641;BA.debugLine="index_box=5";
_index_box = (int) (5);
RDebugUtils.currentLine=3866642;
 //BA.debugLineNum = 3866642;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3866643;
 //BA.debugLineNum = 3866643;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3866644;
 //BA.debugLineNum = 3866644;BA.debugLine="lbl_ezaf_taradod.Visible=False";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3866647;
 //BA.debugLineNum = 3866647;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3866648;
 //BA.debugLineNum = 3866648;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3866649;
 //BA.debugLineNum = 3866649;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3866654;
 //BA.debugLineNum = 3866654;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
RDebugUtils.currentLine=3866655;
 //BA.debugLineNum = 3866655;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
RDebugUtils.currentLine=3866656;
 //BA.debugLineNum = 3866656;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=3866657;
 //BA.debugLineNum = 3866657;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
RDebugUtils.currentLine=3866660;
 //BA.debugLineNum = 3866660;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3866661;
 //BA.debugLineNum = 3866661;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3866665;
 //BA.debugLineNum = 3866665;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_from_mamori";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3866666;
 //BA.debugLineNum = 3866666;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3866667;
 //BA.debugLineNum = 3866667;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=3866668;
 //BA.debugLineNum = 3866668;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_fr";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt");
RDebugUtils.currentLine=3866672;
 //BA.debugLineNum = 3866672;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3866676;
 //BA.debugLineNum = 3866676;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
RDebugUtils.currentLine=3866678;
 //BA.debugLineNum = 3866678;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3866679;
 //BA.debugLineNum = 3866679;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=3866683;
 //BA.debugLineNum = 3866683;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_to_mamoriat";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=3866684;
 //BA.debugLineNum = 3866684;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3866685;
 //BA.debugLineNum = 3866685;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=3866686;
 //BA.debugLineNum = 3866686;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_t";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt");
RDebugUtils.currentLine=3866690;
 //BA.debugLineNum = 3866690;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3866695;
 //BA.debugLineNum = 3866695;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
RDebugUtils.currentLine=3866697;
 //BA.debugLineNum = 3866697;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=3866698;
 //BA.debugLineNum = 3866698;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=3866717;
 //BA.debugLineNum = 3866717;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3866719;
 //BA.debugLineNum = 3866719;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=3866724;
 //BA.debugLineNum = 3866724;BA.debugLine="End Sub";
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
String _dat_mil_1 = "";
String _dat_mil_2 = "";
String _date_end1 = "";
String _date_end2 = "";
String _time_end1 = "";
String _time_end2 = "";
long _tim1_long = 0L;
long _tim2_long = 0L;
b4a.example.dateutils._period _period_between = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _str_show = null;
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Sub time_show";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="Try";
try {RDebugUtils.currentLine=4587523;
 //BA.debugLineNum = 4587523;BA.debugLine="Dim list_date_per1, list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4587524;
 //BA.debugLineNum = 4587524;BA.debugLine="Dim list_date_miladi1, list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4587525;
 //BA.debugLineNum = 4587525;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=4587526;
 //BA.debugLineNum = 4587526;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=4587527;
 //BA.debugLineNum = 4587527;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=4587528;
 //BA.debugLineNum = 4587528;BA.debugLine="list_date_miladi2.Initialize";
_list_date_miladi2.Initialize();
RDebugUtils.currentLine=4587531;
 //BA.debugLineNum = 4587531;BA.debugLine="list_date_per1 = strfun.Split(lbl_date1.Text, \"/";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/");
RDebugUtils.currentLine=4587532;
 //BA.debugLineNum = 4587532;BA.debugLine="list_date_per2 = strfun.Split(lbl_date2.Text, \"/";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/");
RDebugUtils.currentLine=4587535;
 //BA.debugLineNum = 4587535;BA.debugLine="Dim dat_mil_1 As String = persianDate.PersianToG";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=4587536;
 //BA.debugLineNum = 4587536;BA.debugLine="Dim dat_mil_2 As String = persianDate.PersianToG";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=4587539;
 //BA.debugLineNum = 4587539;BA.debugLine="list_date_miladi1 = strfun.Split(dat_mil_1, \"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=4587540;
 //BA.debugLineNum = 4587540;BA.debugLine="list_date_miladi2 = strfun.Split(dat_mil_2, \"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=4587543;
 //BA.debugLineNum = 4587543;BA.debugLine="Dim date_end1 As String = list_date_miladi1.Get(";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=4587544;
 //BA.debugLineNum = 4587544;BA.debugLine="Dim date_end2 As String = list_date_miladi2.Get(";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=4587545;
 //BA.debugLineNum = 4587545;BA.debugLine="Dim time_end1 As String = lbl_tim1.Text & \":00\"";
_time_end1 = mostCurrent._lbl_tim1.getText()+":00";
RDebugUtils.currentLine=4587546;
 //BA.debugLineNum = 4587546;BA.debugLine="Dim time_end2 As String = lbl_tim2.Text & \":00\"";
_time_end2 = mostCurrent._lbl_tim2.getText()+":00";
RDebugUtils.currentLine=4587549;
 //BA.debugLineNum = 4587549;BA.debugLine="Dim tim1_long As Long = DateTime.DateTimeParse(m";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
RDebugUtils.currentLine=4587550;
 //BA.debugLineNum = 4587550;BA.debugLine="Dim tim2_long As Long = DateTime.DateTimeParse(m";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
RDebugUtils.currentLine=4587553;
 //BA.debugLineNum = 4587553;BA.debugLine="Dim period_between As Period = DateUtils.PeriodB";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,_tim1_long,_tim2_long);
RDebugUtils.currentLine=4587556;
 //BA.debugLineNum = 4587556;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=4587557;
 //BA.debugLineNum = 4587557;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
RDebugUtils.currentLine=4587558;
 //BA.debugLineNum = 4587558;BA.debugLine="If period_between.Years <> 0 Then str_show.Appen";
if (_period_between.Years!=0) { 
_str_show.Append(BA.NumberToString(_period_between.Years)+" سال و ");};
RDebugUtils.currentLine=4587559;
 //BA.debugLineNum = 4587559;BA.debugLine="If period_between.Months <> 0 Then str_show.Appe";
if (_period_between.Months!=0) { 
_str_show.Append(BA.NumberToString(_period_between.Months)+" ماه و ");};
RDebugUtils.currentLine=4587560;
 //BA.debugLineNum = 4587560;BA.debugLine="If period_between.Days <> 0 Then str_show.Append";
if (_period_between.Days!=0) { 
_str_show.Append(BA.NumberToString(_period_between.Days)+" روز و ");};
RDebugUtils.currentLine=4587561;
 //BA.debugLineNum = 4587561;BA.debugLine="str_show.Append(period_between.Hours & \" ساعت و";
_str_show.Append(BA.NumberToString(_period_between.Hours)+" ساعت و ");
RDebugUtils.currentLine=4587562;
 //BA.debugLineNum = 4587562;BA.debugLine="str_show.Append(period_between.Minutes & \" دقیقه";
_str_show.Append(BA.NumberToString(_period_between.Minutes)+" دقیقه ");
RDebugUtils.currentLine=4587565;
 //BA.debugLineNum = 4587565;BA.debugLine="lbl_time_show.Text = str_show.ToString";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(_str_show.ToString()));
RDebugUtils.currentLine=4587566;
 //BA.debugLineNum = 4587566;BA.debugLine="lbl_time_show_fs.Text = lbl_time_show.Text";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(mostCurrent._lbl_time_show.getText()));
RDebugUtils.currentLine=4587569;
 //BA.debugLineNum = 4587569;BA.debugLine="year_bt = period_between.Years";
_year_bt = _period_between.Years;
RDebugUtils.currentLine=4587570;
 //BA.debugLineNum = 4587570;BA.debugLine="moon_bt = period_between.Months";
_moon_bt = _period_between.Months;
RDebugUtils.currentLine=4587571;
 //BA.debugLineNum = 4587571;BA.debugLine="day_bt = period_between.Days";
_day_bt = _period_between.Days;
RDebugUtils.currentLine=4587572;
 //BA.debugLineNum = 4587572;BA.debugLine="hour_bt = period_between.Hours";
_hour_bt = _period_between.Hours;
RDebugUtils.currentLine=4587573;
 //BA.debugLineNum = 4587573;BA.debugLine="min_bt = period_between.Minutes";
_min_bt = _period_between.Minutes;
RDebugUtils.currentLine=4587576;
 //BA.debugLineNum = 4587576;BA.debugLine="If index_box = 3 Then";
if (_index_box==3) { 
RDebugUtils.currentLine=4587578;
 //BA.debugLineNum = 4587578;BA.debugLine="tim_min = (day_bt * 24 * 60) + (hour_bt * 60) +";
_tim_min = (int) ((_day_bt*24*60)+(_hour_bt*60)+_min_bt);
RDebugUtils.currentLine=4587581;
 //BA.debugLineNum = 4587581;BA.debugLine="Select state_tatil_setting";
switch (_state_tatil_setting) {
case 0: {
RDebugUtils.currentLine=4587583;
 //BA.debugLineNum = 4587583;BA.debugLine="tatil_nist";
_tatil_nist();
 break; }
case 1: {
RDebugUtils.currentLine=4587585;
 //BA.debugLineNum = 4587585;BA.debugLine="If state_tatil = 1 Or state_tatil = 2 Then ta";
if (_state_tatil==1 || _state_tatil==2) { 
_tatil_hast();}
else {
_tatil_nist();};
 break; }
case 11: {
RDebugUtils.currentLine=4587587;
 //BA.debugLineNum = 4587587;BA.debugLine="If state_tatil = 1 Then tatil_hast Else tatil";
if (_state_tatil==1) { 
_tatil_hast();}
else {
_tatil_nist();};
 break; }
case 22: {
RDebugUtils.currentLine=4587589;
 //BA.debugLineNum = 4587589;BA.debugLine="If state_tatil = 2 Then tatil_hast Else tatil";
if (_state_tatil==2) { 
_tatil_hast();}
else {
_tatil_nist();};
 break; }
}
;
RDebugUtils.currentLine=4587593;
 //BA.debugLineNum = 4587593;BA.debugLine="If is_for_edit Then";
if (_is_for_edit) { 
RDebugUtils.currentLine=4587594;
 //BA.debugLineNum = 4587594;BA.debugLine="lbl_ezaf_taradod.Text = \"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4587595;
 //BA.debugLineNum = 4587595;BA.debugLine="ckb_ezaf_taradod.Enabled = False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4587596;
 //BA.debugLineNum = 4587596;BA.debugLine="ckb_ezaf_taradod.Visible = False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4587597;
 //BA.debugLineNum = 4587597;BA.debugLine="radio_ez_adi.Enabled = False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4587598;
 //BA.debugLineNum = 4587598;BA.debugLine="radio_ez_fog.Enabled = False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4587600;
 //BA.debugLineNum = 4587600;BA.debugLine="lbl_ezaf_taradod_fs.Text = \"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4587601;
 //BA.debugLineNum = 4587601;BA.debugLine="ckb_ezaf_taradod_fs.Enabled = False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4587602;
 //BA.debugLineNum = 4587602;BA.debugLine="ckb_ezaf_taradod_fs.Visible = False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 } 
       catch (Exception e59) {
			processBA.setLastException(e59);RDebugUtils.currentLine=4587607;
 //BA.debugLineNum = 4587607;BA.debugLine="ToastMessageShow(\"خطا در پردازش زمان\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در پردازش زمان"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=4587609;
 //BA.debugLineNum = 4587609;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_ezaf_taradod_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_ezaf_taradod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_ezaf_taradod_click", null));}
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Private Sub lbl_ezaf_taradod_Click";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="If(index_box=2)Then";
if ((_index_box==2)) { 
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="rsPOP_noe.Show";
mostCurrent._rspop_noe.Show();
 };
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_khoroj_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_finger_fs_khoroj_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_finger_fs_khoroj_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
RDebugUtils.currentLine=10289152;
 //BA.debugLineNum = 10289152;BA.debugLine="Private Sub lbl_finger_fs_khoroj_Click";
RDebugUtils.currentLine=10289154;
 //BA.debugLineNum = 10289154;BA.debugLine="If(lbl_finger_fs_khoroj.Tag=0)Then";
if (((mostCurrent._lbl_finger_fs_khoroj.getTag()).equals((Object)(0)))) { 
RDebugUtils.currentLine=10289155;
 //BA.debugLineNum = 10289155;BA.debugLine="ToastMessageShow(\"قبلا ثبت شده-برای ثبت دوباره ر";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("قبلا ثبت شده-برای ثبت دوباره روی آن نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=10289156;
 //BA.debugLineNum = 10289156;BA.debugLine="Else If (lbl_finger_fs_khoroj.Tag=2)Then";
if (((mostCurrent._lbl_finger_fs_khoroj.getTag()).equals((Object)(2)))) { 
RDebugUtils.currentLine=10289157;
 //BA.debugLineNum = 10289157;BA.debugLine="ToastMessageShow(\"ابتدا ورود را بزنید\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ابتدا ورود را بزنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=10289160;
 //BA.debugLineNum = 10289160;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=10289161;
 //BA.debugLineNum = 10289161;BA.debugLine="lbl_tim2.Text=myfunc.fa2en(DateTime.Time(DateTim";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
RDebugUtils.currentLine=10289162;
 //BA.debugLineNum = 10289162;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=10289163;
 //BA.debugLineNum = 10289163;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=10289164;
 //BA.debugLineNum = 10289164;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
RDebugUtils.currentLine=10289165;
 //BA.debugLineNum = 10289165;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=10289166;
 //BA.debugLineNum = 10289166;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_kho";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_khoroj.txt",_ls_khoroj);
RDebugUtils.currentLine=10289172;
 //BA.debugLineNum = 10289172;BA.debugLine="lbl_finger_fs_khoroj_time.Text=lbl_date2.Text&\"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date2.getText()+" - "+mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=10289173;
 //BA.debugLineNum = 10289173;BA.debugLine="File.WriteString(File.DirInternal,\"finger_vorod_";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt","2");
RDebugUtils.currentLine=10289174;
 //BA.debugLineNum = 10289174;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=10289175;
 //BA.debugLineNum = 10289175;BA.debugLine="lbl_finger_fs_khoroj.Tag=0";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(0));
RDebugUtils.currentLine=10289176;
 //BA.debugLineNum = 10289176;BA.debugLine="ToastMessageShow(\"ثبت زمان خروج\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان خروج"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10289177;
 //BA.debugLineNum = 10289177;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=10289178;
 //BA.debugLineNum = 10289178;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 }}
;
RDebugUtils.currentLine=10289182;
 //BA.debugLineNum = 10289182;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_khoroj_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_finger_fs_khoroj_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_finger_fs_khoroj_longclick", null));}
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
RDebugUtils.currentLine=10420224;
 //BA.debugLineNum = 10420224;BA.debugLine="Private Sub lbl_finger_fs_khoroj_LongClick";
RDebugUtils.currentLine=10420226;
 //BA.debugLineNum = 10420226;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=10420227;
 //BA.debugLineNum = 10420227;BA.debugLine="lbl_tim2.Text=myfunc.fa2en(DateTime.Time(DateTim";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
RDebugUtils.currentLine=10420228;
 //BA.debugLineNum = 10420228;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=10420229;
 //BA.debugLineNum = 10420229;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=10420230;
 //BA.debugLineNum = 10420230;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
RDebugUtils.currentLine=10420231;
 //BA.debugLineNum = 10420231;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=10420232;
 //BA.debugLineNum = 10420232;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_kho";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_khoroj.txt",_ls_khoroj);
RDebugUtils.currentLine=10420235;
 //BA.debugLineNum = 10420235;BA.debugLine="lbl_finger_fs_khoroj_time.Text=lbl_date2.Text&\"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date2.getText()+" - "+mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=10420237;
 //BA.debugLineNum = 10420237;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=10420238;
 //BA.debugLineNum = 10420238;BA.debugLine="ToastMessageShow(\"ثبت زمان خروج\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان خروج"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10420239;
 //BA.debugLineNum = 10420239;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=10420241;
 //BA.debugLineNum = 10420241;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_vorod_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_finger_fs_vorod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_finger_fs_vorod_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
RDebugUtils.currentLine=10354688;
 //BA.debugLineNum = 10354688;BA.debugLine="Private Sub lbl_finger_fs_vorod_Click";
RDebugUtils.currentLine=10354690;
 //BA.debugLineNum = 10354690;BA.debugLine="If(lbl_finger_fs_vorod.Tag=0)Then";
if (((mostCurrent._lbl_finger_fs_vorod.getTag()).equals((Object)(0)))) { 
RDebugUtils.currentLine=10354691;
 //BA.debugLineNum = 10354691;BA.debugLine="ToastMessageShow(\"قبلا ثبت شده-برای ثبت دوباره ر";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("قبلا ثبت شده-برای ثبت دوباره روی آن نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=10354695;
 //BA.debugLineNum = 10354695;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=10354696;
 //BA.debugLineNum = 10354696;BA.debugLine="lbl_tim1.Text=myfunc.fa2en(DateTime.Time(DateTim";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
RDebugUtils.currentLine=10354697;
 //BA.debugLineNum = 10354697;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=10354698;
 //BA.debugLineNum = 10354698;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=10354699;
 //BA.debugLineNum = 10354699;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
RDebugUtils.currentLine=10354700;
 //BA.debugLineNum = 10354700;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=10354701;
 //BA.debugLineNum = 10354701;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_vor";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt",_ls_vorod);
RDebugUtils.currentLine=10354706;
 //BA.debugLineNum = 10354706;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\" -";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=10354707;
 //BA.debugLineNum = 10354707;BA.debugLine="File.WriteString(File.DirInternal,\"finger_vorod_";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt","1");
RDebugUtils.currentLine=10354708;
 //BA.debugLineNum = 10354708;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=10354709;
 //BA.debugLineNum = 10354709;BA.debugLine="lbl_finger_fs_vorod.Tag=0";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(0));
RDebugUtils.currentLine=10354710;
 //BA.debugLineNum = 10354710;BA.debugLine="lbl_finger_fs_khoroj.Tag=1";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(1));
RDebugUtils.currentLine=10354711;
 //BA.debugLineNum = 10354711;BA.debugLine="ToastMessageShow(\"ثبت زمان ورود\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان ورود"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=10354718;
 //BA.debugLineNum = 10354718;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_vorod_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_finger_fs_vorod_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_finger_fs_vorod_longclick", null));}
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
RDebugUtils.currentLine=10485760;
 //BA.debugLineNum = 10485760;BA.debugLine="Private Sub lbl_finger_fs_vorod_LongClick";
RDebugUtils.currentLine=10485761;
 //BA.debugLineNum = 10485761;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=10485762;
 //BA.debugLineNum = 10485762;BA.debugLine="lbl_tim1.Text=myfunc.fa2en(DateTime.Time(DateTime";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
RDebugUtils.currentLine=10485763;
 //BA.debugLineNum = 10485763;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=10485764;
 //BA.debugLineNum = 10485764;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=10485765;
 //BA.debugLineNum = 10485765;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
RDebugUtils.currentLine=10485766;
 //BA.debugLineNum = 10485766;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=10485767;
 //BA.debugLineNum = 10485767;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_voro";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt",_ls_vorod);
RDebugUtils.currentLine=10485771;
 //BA.debugLineNum = 10485771;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\" -";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=10485773;
 //BA.debugLineNum = 10485773;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=10485774;
 //BA.debugLineNum = 10485774;BA.debugLine="ToastMessageShow(\"ثبت زمان ورود\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان ورود"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10485775;
 //BA.debugLineNum = 10485775;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=10485777;
 //BA.debugLineNum = 10485777;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_khoroj_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_finger_khoroj_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_finger_khoroj_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
RDebugUtils.currentLine=9830400;
 //BA.debugLineNum = 9830400;BA.debugLine="Private Sub lbl_finger_khoroj_Click";
RDebugUtils.currentLine=9830401;
 //BA.debugLineNum = 9830401;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=9830402;
 //BA.debugLineNum = 9830402;BA.debugLine="lbl_tim2.Text=myfunc.fa2en(DateTime.Time(DateTime";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
RDebugUtils.currentLine=9830405;
 //BA.debugLineNum = 9830405;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9830406;
 //BA.debugLineNum = 9830406;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=9830407;
 //BA.debugLineNum = 9830407;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
RDebugUtils.currentLine=9830408;
 //BA.debugLineNum = 9830408;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=9830410;
 //BA.debugLineNum = 9830410;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
RDebugUtils.currentLine=9830412;
 //BA.debugLineNum = 9830412;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_ezafek";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt",_ls_khoroj);
 break; }
case 2: {
RDebugUtils.currentLine=9830414;
 //BA.debugLineNum = 9830414;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_morakh";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt",_ls_khoroj);
 break; }
case 3: {
RDebugUtils.currentLine=9830416;
 //BA.debugLineNum = 9830416;BA.debugLine="File.WriteList(File.DirInternal,\"temp_khoroj_ta";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt",_ls_khoroj);
 break; }
case 5: {
RDebugUtils.currentLine=9830419;
 //BA.debugLineNum = 9830419;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_mamori";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt",_ls_khoroj);
 break; }
}
;
RDebugUtils.currentLine=9830423;
 //BA.debugLineNum = 9830423;BA.debugLine="ToastMessageShow(\"ثبت زمان 2\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان 2"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9830424;
 //BA.debugLineNum = 9830424;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=9830425;
 //BA.debugLineNum = 9830425;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_vorod_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_finger_vorod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_finger_vorod_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
RDebugUtils.currentLine=9764864;
 //BA.debugLineNum = 9764864;BA.debugLine="Private Sub lbl_finger_vorod_Click";
RDebugUtils.currentLine=9764865;
 //BA.debugLineNum = 9764865;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=9764866;
 //BA.debugLineNum = 9764866;BA.debugLine="lbl_tim1.Text=myfunc.fa2en(DateTime.Time(DateTime";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
RDebugUtils.currentLine=9764869;
 //BA.debugLineNum = 9764869;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9764870;
 //BA.debugLineNum = 9764870;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=9764871;
 //BA.debugLineNum = 9764871;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
RDebugUtils.currentLine=9764872;
 //BA.debugLineNum = 9764872;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=9764875;
 //BA.debugLineNum = 9764875;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
RDebugUtils.currentLine=9764877;
 //BA.debugLineNum = 9764877;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_ezaf";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt",_ls_vorod);
 break; }
case 2: {
RDebugUtils.currentLine=9764879;
 //BA.debugLineNum = 9764879;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_mora";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt",_ls_vorod);
 break; }
case 3: {
RDebugUtils.currentLine=9764881;
 //BA.debugLineNum = 9764881;BA.debugLine="File.WriteList(File.DirInternal,\"temp_vorod_tar";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt",_ls_vorod);
 break; }
case 5: {
RDebugUtils.currentLine=9764885;
 //BA.debugLineNum = 9764885;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_mamo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt",_ls_vorod);
 break; }
}
;
RDebugUtils.currentLine=9764892;
 //BA.debugLineNum = 9764892;BA.debugLine="ToastMessageShow(\"ثبت زمان 1\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان 1"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9764893;
 //BA.debugLineNum = 9764893;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=9764894;
 //BA.debugLineNum = 9764894;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_piker_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_piker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_piker_click", null));}
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Private Sub lbl_help_piker_Click";
RDebugUtils.currentLine=8192002;
 //BA.debugLineNum = 8192002;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
RDebugUtils.currentLine=8192004;
 //BA.debugLineNum = 8192004;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
RDebugUtils.currentLine=8192005;
 //BA.debugLineNum = 8192005;BA.debugLine="lbl_close_help.Visible=False";
mostCurrent._lbl_close_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=8192006;
 //BA.debugLineNum = 8192006;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=8192008;
 //BA.debugLineNum = 8192008;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_saatkari_inweek_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_saatkari_inweek_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_saatkari_inweek_click", null));}
RDebugUtils.currentLine=10878976;
 //BA.debugLineNum = 10878976;BA.debugLine="Private Sub lbl_help_saatKari_inWeek_Click";
RDebugUtils.currentLine=10878977;
 //BA.debugLineNum = 10878977;BA.debugLine="myfunc.help_man(\"راهنما\",\"اگر در روزهای هفته ساعت";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","اگر در روزهای هفته ساعت کاری مختلف دارید آنها را تنظیم کنید تا در موقع ثبت تردد با آن حساب شود. ");
RDebugUtils.currentLine=10878978;
 //BA.debugLineNum = 10878978;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_setting_finger_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_setting_finger_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_setting_finger_click", null));}
RDebugUtils.currentLine=10682368;
 //BA.debugLineNum = 10682368;BA.debugLine="Private Sub lbl_help_setting_finger_Click";
RDebugUtils.currentLine=10682369;
 //BA.debugLineNum = 10682369;BA.debugLine="myfunc.help_man(\"راهنما\",\"با فعال کردن این گزینه";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","با فعال کردن این گزینه ثبت ترددها به انگشتی انجام میشود . به این صورت که در موقع ورود و خروج انگشت میزنیم تا زمان ثبت شود و در آخر ذخیره میکنیم.");
RDebugUtils.currentLine=10682370;
 //BA.debugLineNum = 10682370;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_tatil_garardadi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_tatil_garardadi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_tatil_garardadi_click", null));}
RDebugUtils.currentLine=10813440;
 //BA.debugLineNum = 10813440;BA.debugLine="Private Sub lbl_help_tatil_garardadi_Click";
RDebugUtils.currentLine=10813441;
 //BA.debugLineNum = 10813441;BA.debugLine="myfunc.help_man(\"راهنما\",\"تردد در روزهای تعطیل قر";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","تردد در روزهای تعطیل قراردادی اضافه کاری محسوب شود- برای تعین روزها به عنوان تعطیل قراردادی در صفحه تقویم روی هر روز انگشت خود را نگه دارید و بعد تیک تعطیل قراردادی را بزنید. ");
RDebugUtils.currentLine=10813442;
 //BA.debugLineNum = 10813442;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_tatil_rasmi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_tatil_rasmi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_tatil_rasmi_click", null));}
RDebugUtils.currentLine=10747904;
 //BA.debugLineNum = 10747904;BA.debugLine="Private Sub lbl_help_tatil_rasmi_Click";
RDebugUtils.currentLine=10747905;
 //BA.debugLineNum = 10747905;BA.debugLine="myfunc.help_man(\"راهنما\",\"تردد در روزهای تعطیل رس";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","تردد در روزهای تعطیل رسمی و جمعه ها اضافه کاری محسوب شوند.");
RDebugUtils.currentLine=10747906;
 //BA.debugLineNum = 10747906;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help2_click", null));}
RDebugUtils.currentLine=7667712;
 //BA.debugLineNum = 7667712;BA.debugLine="Private Sub lbl_help2_Click";
RDebugUtils.currentLine=7667713;
 //BA.debugLineNum = 7667713;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=7667714;
 //BA.debugLineNum = 7667714;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_lite_menu_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_lite_menu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_lite_menu_click", null));}
RDebugUtils.currentLine=8585216;
 //BA.debugLineNum = 8585216;BA.debugLine="Private Sub lbl_lite_menu_Click";
RDebugUtils.currentLine=8585217;
 //BA.debugLineNum = 8585217;BA.debugLine="pan_all_liteMenu.Visible=True";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=8585218;
 //BA.debugLineNum = 8585218;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_notefi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_notefi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_notefi_click", null));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _html = null;
int _i = 0;
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Private Sub lbl_notefi_Click";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="lbl_title_msgPan.Text=\"پیام ها\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام ها"));
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="pan_notif.Top=10%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="pan_notif.Height=70%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="Dim html As StringBuilder";
_html = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="html.Initialize";
_html.Initialize();
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1"))) { 
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="html.Append(\"<!DOCTYPE html><html><meta charset=";
_html.Append("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'>");
RDebugUtils.currentLine=851982;
 //BA.debugLineNum = 851982;BA.debugLine="For i = ls1.Size-1 To 0 Step -1";
{
final int step10 = -1;
final int limit10 = (int) (0);
_i = (int) (mostCurrent._ls1.getSize()-1) ;
for (;_i >= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=851983;
 //BA.debugLineNum = 851983;BA.debugLine="html.Append(\"<div style='background-color: #99f";
_html.Append("<div style='background-color: #99ffff; font-size: 13px;'>"+"کد پیام : "+BA.ObjectToString(mostCurrent._ls1.Get(_i))+" - مورخ : "+BA.ObjectToString(mostCurrent._ls3.Get(_i))+"</div><div style='background-color: #e6ffff; font-size: 16px;'><br>"+BA.ObjectToString(mostCurrent._ls2.Get(_i))).Append("<br></div><br>");
 }
};
RDebugUtils.currentLine=851985;
 //BA.debugLineNum = 851985;BA.debugLine="html.Append(\"</body></html>\")";
_html.Append("</body></html>");
RDebugUtils.currentLine=851988;
 //BA.debugLineNum = 851988;BA.debugLine="web_msg_show.LoadHtml(html.ToString)";
mostCurrent._web_msg_show.LoadHtml(_html.ToString());
 }else {
RDebugUtils.currentLine=851991;
 //BA.debugLineNum = 851991;BA.debugLine="web_msg_show.LoadHtml(\"<html><body dir='rtl'>لیس";
mostCurrent._web_msg_show.LoadHtml("<html><body dir='rtl'>لیست پیام خالی ... </body></html>");
 };
RDebugUtils.currentLine=851995;
 //BA.debugLineNum = 851995;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_remove_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_remove_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
RDebugUtils.currentLine=7536640;
 //BA.debugLineNum = 7536640;BA.debugLine="Private Sub lbl_remove_from_list_Click";
RDebugUtils.currentLine=7536642;
 //BA.debugLineNum = 7536642;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7536643;
 //BA.debugLineNum = 7536643;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=7536645;
 //BA.debugLineNum = 7536645;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
RDebugUtils.currentLine=7536646;
 //BA.debugLineNum = 7536646;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=7536647;
 //BA.debugLineNum = 7536647;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=7536648;
 //BA.debugLineNum = 7536648;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=7536650;
 //BA.debugLineNum = 7536650;BA.debugLine="If (dbCode.delete_ezafekari(b.Tag))Then";
if ((mostCurrent._dbcode._delete_ezafekari /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=7536651;
 //BA.debugLineNum = 7536651;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536653;
 //BA.debugLineNum = 7536653;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
RDebugUtils.currentLine=7536656;
 //BA.debugLineNum = 7536656;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else 
{RDebugUtils.currentLine=7536659;
 //BA.debugLineNum = 7536659;BA.debugLine="Else if (TabHost1.CurrentTab=1)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==1)) { 
RDebugUtils.currentLine=7536661;
 //BA.debugLineNum = 7536661;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=7536662;
 //BA.debugLineNum = 7536662;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=7536663;
 //BA.debugLineNum = 7536663;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=7536665;
 //BA.debugLineNum = 7536665;BA.debugLine="If (dbCode.delete_morakhasi(b.Tag))Then";
if ((mostCurrent._dbcode._delete_morakhasi /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=7536666;
 //BA.debugLineNum = 7536666;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536667;
 //BA.debugLineNum = 7536667;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
RDebugUtils.currentLine=7536668;
 //BA.debugLineNum = 7536668;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else 
{RDebugUtils.currentLine=7536672;
 //BA.debugLineNum = 7536672;BA.debugLine="Else if (TabHost1.CurrentTab=2)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==2)) { 
RDebugUtils.currentLine=7536673;
 //BA.debugLineNum = 7536673;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=7536674;
 //BA.debugLineNum = 7536674;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=7536675;
 //BA.debugLineNum = 7536675;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=7536677;
 //BA.debugLineNum = 7536677;BA.debugLine="If (dbCode.delete_taradod(b.Tag))Then";
if ((mostCurrent._dbcode._delete_taradod /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=7536678;
 //BA.debugLineNum = 7536678;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536680;
 //BA.debugLineNum = 7536680;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
RDebugUtils.currentLine=7536681;
 //BA.debugLineNum = 7536681;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else 
{RDebugUtils.currentLine=7536685;
 //BA.debugLineNum = 7536685;BA.debugLine="Else if (TabHost1.CurrentTab=3)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==3)) { 
RDebugUtils.currentLine=7536686;
 //BA.debugLineNum = 7536686;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=7536687;
 //BA.debugLineNum = 7536687;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=7536688;
 //BA.debugLineNum = 7536688;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=7536690;
 //BA.debugLineNum = 7536690;BA.debugLine="If (dbCode.delete_mamoriat(b.Tag))Then";
if ((mostCurrent._dbcode._delete_mamoriat /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=7536691;
 //BA.debugLineNum = 7536691;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536693;
 //BA.debugLineNum = 7536693;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
RDebugUtils.currentLine=7536694;
 //BA.debugLineNum = 7536694;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }}}}
;
RDebugUtils.currentLine=7536704;
 //BA.debugLineNum = 7536704;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_remove_from_list2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_remove_from_list2_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
RDebugUtils.currentLine=7602176;
 //BA.debugLineNum = 7602176;BA.debugLine="Private Sub lbl_remove_from_list2_Click";
RDebugUtils.currentLine=7602177;
 //BA.debugLineNum = 7602177;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7602178;
 //BA.debugLineNum = 7602178;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=7602181;
 //BA.debugLineNum = 7602181;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=7602182;
 //BA.debugLineNum = 7602182;BA.debugLine="result = Msgbox2(\"آیا این گزارش حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این گزارش حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=7602183;
 //BA.debugLineNum = 7602183;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=7602185;
 //BA.debugLineNum = 7602185;BA.debugLine="If (dbCode.delete_gozaresh(b.tag))Then";
if ((mostCurrent._dbcode._delete_gozaresh /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=7602186;
 //BA.debugLineNum = 7602186;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7602187;
 //BA.debugLineNum = 7602187;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedI";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
 };
 };
RDebugUtils.currentLine=7602192;
 //BA.debugLineNum = 7602192;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_box_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_box_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_box_click", null));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Private Sub lbl_save_box_Click";
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="If(save_box_allow=False)Then";
if ((_save_box_allow==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="ToastMessageShow(\"ورود یا خروج ناقص است.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ورود یا خروج ناقص است."),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=4063237;
 //BA.debugLineNum = 4063237;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="add_end";
_add_end();
 };
RDebugUtils.currentLine=4063243;
 //BA.debugLineNum = 4063243;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_picker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_picker_click", null));}
String _value = "";
String _value1 = "";
String _value2 = "";
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Private Sub lbl_save_picker_Click";
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="Dim value As String";
_value = "";
RDebugUtils.currentLine=6422531;
 //BA.debugLineNum = 6422531;BA.debugLine="value=pik_hour1.Text";
_value = mostCurrent._pik_hour1.getText();
RDebugUtils.currentLine=6422532;
 //BA.debugLineNum = 6422532;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(value)";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_value)))));
RDebugUtils.currentLine=6422535;
 //BA.debugLineNum = 6422535;BA.debugLine="Dim value1 As String";
_value1 = "";
RDebugUtils.currentLine=6422536;
 //BA.debugLineNum = 6422536;BA.debugLine="value1=pik_min1.Text";
_value1 = mostCurrent._pik_min1.getText();
RDebugUtils.currentLine=6422537;
 //BA.debugLineNum = 6422537;BA.debugLine="pik_min1.Text=myfunc.convert_adad(value1)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_value1)))));
RDebugUtils.currentLine=6422540;
 //BA.debugLineNum = 6422540;BA.debugLine="Dim value2 As String";
_value2 = "";
RDebugUtils.currentLine=6422541;
 //BA.debugLineNum = 6422541;BA.debugLine="value2=pik_day1.Text";
_value2 = mostCurrent._pik_day1.getText();
RDebugUtils.currentLine=6422542;
 //BA.debugLineNum = 6422542;BA.debugLine="pik_day1.Text=myfunc.convert_adad(value2)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_value2)))));
RDebugUtils.currentLine=6422543;
 //BA.debugLineNum = 6422543;BA.debugLine="pik_moon1.Tag=myfunc.convert_adad(pik_moon1.Tag)";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))));
RDebugUtils.currentLine=6422548;
 //BA.debugLineNum = 6422548;BA.debugLine="If(index_piker=1)Then  'date1";
if ((_index_piker==1)) { 
RDebugUtils.currentLine=6422551;
 //BA.debugLineNum = 6422551;BA.debugLine="lbl_tim1.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
RDebugUtils.currentLine=6422552;
 //BA.debugLineNum = 6422552;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
RDebugUtils.currentLine=6422554;
 //BA.debugLineNum = 6422554;BA.debugLine="If (is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=6422556;
 //BA.debugLineNum = 6422556;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6422557;
 //BA.debugLineNum = 6422557;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=6422558;
 //BA.debugLineNum = 6422558;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
RDebugUtils.currentLine=6422559;
 //BA.debugLineNum = 6422559;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=6422561;
 //BA.debugLineNum = 6422561;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
RDebugUtils.currentLine=6422563;
 //BA.debugLineNum = 6422563;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_ez";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt",_ls_vorod);
 break; }
case 2: {
RDebugUtils.currentLine=6422565;
 //BA.debugLineNum = 6422565;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_mo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt",_ls_vorod);
 break; }
case 3: {
RDebugUtils.currentLine=6422567;
 //BA.debugLineNum = 6422567;BA.debugLine="File.WriteList(File.DirInternal,\"temp_vorod_t";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt",_ls_vorod);
 break; }
case 5: {
RDebugUtils.currentLine=6422569;
 //BA.debugLineNum = 6422569;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_ma";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt",_ls_vorod);
 break; }
}
;
 };
RDebugUtils.currentLine=6422577;
 //BA.debugLineNum = 6422577;BA.debugLine="state_tatil= chek_tatil_day(myfunc.fa2en(pik_yea";
_state_tatil = _chek_tatil_day((int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText()))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag())))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText()))));
RDebugUtils.currentLine=6422578;
 //BA.debugLineNum = 6422578;BA.debugLine="state_tatil_setting = chek_tatil_setting";
_state_tatil_setting = _chek_tatil_setting();
RDebugUtils.currentLine=6422580;
 //BA.debugLineNum = 6422580;BA.debugLine="day_inWeek_id=what_day(myfunc.fa2en(pik_year1.Te";
_day_inweek_id = _what_day((int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText()))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag())))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText()))));
RDebugUtils.currentLine=6422583;
 //BA.debugLineNum = 6422583;BA.debugLine="If(state_tatil=0)Then";
if ((_state_tatil==0)) { 
RDebugUtils.currentLine=6422584;
 //BA.debugLineNum = 6422584;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+""));
 }else 
{RDebugUtils.currentLine=6422585;
 //BA.debugLineNum = 6422585;BA.debugLine="Else if (state_tatil=1) Then";
if ((_state_tatil==1)) { 
RDebugUtils.currentLine=6422586;
 //BA.debugLineNum = 6422586;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل رس";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+" (تعطیل رسمی)"));
 }else 
{RDebugUtils.currentLine=6422587;
 //BA.debugLineNum = 6422587;BA.debugLine="Else if (state_tatil=2) Then";
if ((_state_tatil==2)) { 
RDebugUtils.currentLine=6422588;
 //BA.debugLineNum = 6422588;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل قر";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+" (تعطیل قراردادی)"));
 }}}
;
RDebugUtils.currentLine=6422594;
 //BA.debugLineNum = 6422594;BA.debugLine="If (index_box <> 3) Then";
if ((_index_box!=3)) { 
RDebugUtils.currentLine=6422595;
 //BA.debugLineNum = 6422595;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
 };
 }else 
{RDebugUtils.currentLine=6422599;
 //BA.debugLineNum = 6422599;BA.debugLine="Else If (index_piker=2)Then  'date2";
if ((_index_piker==2)) { 
RDebugUtils.currentLine=6422601;
 //BA.debugLineNum = 6422601;BA.debugLine="lbl_tim2.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
RDebugUtils.currentLine=6422602;
 //BA.debugLineNum = 6422602;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
RDebugUtils.currentLine=6422605;
 //BA.debugLineNum = 6422605;BA.debugLine="If (is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=6422607;
 //BA.debugLineNum = 6422607;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6422608;
 //BA.debugLineNum = 6422608;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=6422609;
 //BA.debugLineNum = 6422609;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
RDebugUtils.currentLine=6422610;
 //BA.debugLineNum = 6422610;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=6422612;
 //BA.debugLineNum = 6422612;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
RDebugUtils.currentLine=6422614;
 //BA.debugLineNum = 6422614;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_ezaf";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt",_ls_khoroj);
 break; }
case 2: {
RDebugUtils.currentLine=6422616;
 //BA.debugLineNum = 6422616;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_mora";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt",_ls_khoroj);
 break; }
case 3: {
RDebugUtils.currentLine=6422618;
 //BA.debugLineNum = 6422618;BA.debugLine="File.WriteList(File.DirInternal,\"temp_khoroj_";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt",_ls_khoroj);
 break; }
case 5: {
RDebugUtils.currentLine=6422620;
 //BA.debugLineNum = 6422620;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_mamo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt",_ls_khoroj);
 break; }
}
;
 };
 }}
;
RDebugUtils.currentLine=6422630;
 //BA.debugLineNum = 6422630;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6422631;
 //BA.debugLineNum = 6422631;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=6422632;
 //BA.debugLineNum = 6422632;BA.debugLine="End Sub";
return "";
}
public static int  _what_day(int _year1,int _moon1,int _day1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "what_day", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "what_day", new Object[] {_year1,_moon1,_day1}));}
int _id_myday = 0;
int _result_int = 0;
RDebugUtils.currentLine=6488064;
 //BA.debugLineNum = 6488064;BA.debugLine="Sub what_day (year1 As Int,moon1 As Int, day1 As I";
RDebugUtils.currentLine=6488065;
 //BA.debugLineNum = 6488065;BA.debugLine="Dim id_MyDay As Int";
_id_myday = 0;
RDebugUtils.currentLine=6488066;
 //BA.debugLineNum = 6488066;BA.debugLine="id_MyDay=dbCode.get_day_id(year1,moon1,day1)";
_id_myday = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_year1,_moon1,_day1);
RDebugUtils.currentLine=6488068;
 //BA.debugLineNum = 6488068;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=6488069;
 //BA.debugLineNum = 6488069;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id_myday))));
RDebugUtils.currentLine=6488071;
 //BA.debugLineNum = 6488071;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=6488072;
 //BA.debugLineNum = 6488072;BA.debugLine="Dim result_int As Int=dbCode.res.GetInt(\"day_h\")";
_result_int = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_h");
RDebugUtils.currentLine=6488076;
 //BA.debugLineNum = 6488076;BA.debugLine="Select result_int";
switch (_result_int) {
case 1: {
RDebugUtils.currentLine=6488078;
 //BA.debugLineNum = 6488078;BA.debugLine="day_inWeek_name=\"شنبه\"";
mostCurrent._day_inweek_name = "شنبه";
 break; }
case 2: {
RDebugUtils.currentLine=6488080;
 //BA.debugLineNum = 6488080;BA.debugLine="day_inWeek_name=\"یکشنبه\"";
mostCurrent._day_inweek_name = "یکشنبه";
 break; }
case 3: {
RDebugUtils.currentLine=6488082;
 //BA.debugLineNum = 6488082;BA.debugLine="day_inWeek_name=\"دوشنبه\"";
mostCurrent._day_inweek_name = "دوشنبه";
 break; }
case 4: {
RDebugUtils.currentLine=6488084;
 //BA.debugLineNum = 6488084;BA.debugLine="day_inWeek_name=\"سه شنبه\"";
mostCurrent._day_inweek_name = "سه شنبه";
 break; }
case 5: {
RDebugUtils.currentLine=6488086;
 //BA.debugLineNum = 6488086;BA.debugLine="day_inWeek_name=\"چهارشنبه\"";
mostCurrent._day_inweek_name = "چهارشنبه";
 break; }
case 6: {
RDebugUtils.currentLine=6488088;
 //BA.debugLineNum = 6488088;BA.debugLine="day_inWeek_name=\"پنجشنبه\"";
mostCurrent._day_inweek_name = "پنجشنبه";
 break; }
case 7: {
RDebugUtils.currentLine=6488090;
 //BA.debugLineNum = 6488090;BA.debugLine="day_inWeek_name=\"جمعه\"";
mostCurrent._day_inweek_name = "جمعه";
 break; }
}
;
RDebugUtils.currentLine=6488094;
 //BA.debugLineNum = 6488094;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=6488095;
 //BA.debugLineNum = 6488095;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=6488097;
 //BA.debugLineNum = 6488097;BA.debugLine="Return result_int";
if (true) return _result_int;
RDebugUtils.currentLine=6488098;
 //BA.debugLineNum = 6488098;BA.debugLine="End Sub";
return 0;
}
public static String  _lbl_save_setting_date_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_setting_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_setting_date_click", null));}
RDebugUtils.currentLine=10092544;
 //BA.debugLineNum = 10092544;BA.debugLine="Private Sub lbl_save_setting_date_Click";
RDebugUtils.currentLine=10092548;
 //BA.debugLineNum = 10092548;BA.debugLine="If(ckb_setting_date_finger.Checked=True)Then";
if ((mostCurrent._ckb_setting_date_finger.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=10092549;
 //BA.debugLineNum = 10092549;BA.debugLine="dbCode.update_setting_byname(\"setting_finger_mod";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode",BA.NumberToString(1));
RDebugUtils.currentLine=10092550;
 //BA.debugLineNum = 10092550;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
RDebugUtils.currentLine=10092551;
 //BA.debugLineNum = 10092551;BA.debugLine="pan_finger_taradod.Visible=True";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=10092553;
 //BA.debugLineNum = 10092553;BA.debugLine="dbCode.update_setting_byname(\"setting_finger_mod";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode",BA.NumberToString(0));
RDebugUtils.currentLine=10092554;
 //BA.debugLineNum = 10092554;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10092555;
 //BA.debugLineNum = 10092555;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
RDebugUtils.currentLine=10092556;
 //BA.debugLineNum = 10092556;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=10092559;
 //BA.debugLineNum = 10092559;BA.debugLine="If(ckb_tatil_rasmi.Checked=True)Then";
if ((mostCurrent._ckb_tatil_rasmi.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=10092560;
 //BA.debugLineNum = 10092560;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_rasm";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi",BA.NumberToString(1));
 }else {
RDebugUtils.currentLine=10092562;
 //BA.debugLineNum = 10092562;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_rasm";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi",BA.NumberToString(0));
 };
RDebugUtils.currentLine=10092565;
 //BA.debugLineNum = 10092565;BA.debugLine="If(ckb_tatil_garardadi.Checked=True)Then";
if ((mostCurrent._ckb_tatil_garardadi.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=10092566;
 //BA.debugLineNum = 10092566;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_gara";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi",BA.NumberToString(1));
 }else {
RDebugUtils.currentLine=10092568;
 //BA.debugLineNum = 10092568;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_gara";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi",BA.NumberToString(0));
 };
RDebugUtils.currentLine=10092573;
 //BA.debugLineNum = 10092573;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Shanbe\",((";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Shanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari0.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari0.getText())));
RDebugUtils.currentLine=10092574;
 //BA.debugLineNum = 10092574;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Yekshanbe\"";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Yekshanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari1.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari1.getText())));
RDebugUtils.currentLine=10092575;
 //BA.debugLineNum = 10092575;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Doshanbe\",";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Doshanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari2.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari2.getText())));
RDebugUtils.currentLine=10092576;
 //BA.debugLineNum = 10092576;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Seshanbe\",";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Seshanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari3.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari3.getText())));
RDebugUtils.currentLine=10092577;
 //BA.debugLineNum = 10092577;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Charshanbe";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Charshanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari4.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari4.getText())));
RDebugUtils.currentLine=10092578;
 //BA.debugLineNum = 10092578;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Panjshanbe";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Panjshanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari5.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari5.getText())));
RDebugUtils.currentLine=10092586;
 //BA.debugLineNum = 10092586;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10092587;
 //BA.debugLineNum = 10092587;BA.debugLine="pan_all_setting_date.Visible=False";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10092588;
 //BA.debugLineNum = 10092588;BA.debugLine="pan_all_Click";
_pan_all_click();
RDebugUtils.currentLine=10092589;
 //BA.debugLineNum = 10092589;BA.debugLine="End Sub";
return "";
}
public static int  _validat_et_saatkari(String _val) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "validat_et_saatkari", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "validat_et_saatkari", new Object[] {_val}));}
RDebugUtils.currentLine=10158080;
 //BA.debugLineNum = 10158080;BA.debugLine="Sub validat_et_saatKari (val As String) As Int";
RDebugUtils.currentLine=10158081;
 //BA.debugLineNum = 10158081;BA.debugLine="If (val=\"\") Then";
if (((_val).equals(""))) { 
RDebugUtils.currentLine=10158082;
 //BA.debugLineNum = 10158082;BA.debugLine="val=0";
_val = BA.NumberToString(0);
 };
RDebugUtils.currentLine=10158084;
 //BA.debugLineNum = 10158084;BA.debugLine="Return val";
if (true) return (int)(Double.parseDouble(_val));
RDebugUtils.currentLine=10158085;
 //BA.debugLineNum = 10158085;BA.debugLine="End Sub";
return 0;
}
public static String  _lbl_setting_date_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_setting_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_setting_date_click", null));}
int _res_val2 = 0;
int _res_tatil_rasmi = 0;
int _res_tatil_garardadi = 0;
int _minroz_0 = 0;
int _minroz_1 = 0;
int _minroz_2 = 0;
int _minroz_3 = 0;
int _minroz_4 = 0;
int _minroz_5 = 0;
RDebugUtils.currentLine=9961472;
 //BA.debugLineNum = 9961472;BA.debugLine="Private Sub lbl_setting_date_Click";
RDebugUtils.currentLine=9961474;
 //BA.debugLineNum = 9961474;BA.debugLine="Try";
try {RDebugUtils.currentLine=9961476;
 //BA.debugLineNum = 9961476;BA.debugLine="Dim res_val2 As Int =dbCode.get_setting_byName(\"";
_res_val2 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode")));
RDebugUtils.currentLine=9961477;
 //BA.debugLineNum = 9961477;BA.debugLine="If(res_val2=0)Then";
if ((_res_val2==0)) { 
RDebugUtils.currentLine=9961478;
 //BA.debugLineNum = 9961478;BA.debugLine="ckb_setting_date_finger.Checked=False";
mostCurrent._ckb_setting_date_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=9961480;
 //BA.debugLineNum = 9961480;BA.debugLine="ckb_setting_date_finger.Checked=True";
mostCurrent._ckb_setting_date_finger.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=9961483;
 //BA.debugLineNum = 9961483;BA.debugLine="Dim res_tatil_rasmi As Int =dbCode.get_setting_b";
_res_tatil_rasmi = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi")));
RDebugUtils.currentLine=9961484;
 //BA.debugLineNum = 9961484;BA.debugLine="If(res_tatil_rasmi=0)Then";
if ((_res_tatil_rasmi==0)) { 
RDebugUtils.currentLine=9961485;
 //BA.debugLineNum = 9961485;BA.debugLine="ckb_tatil_rasmi.Checked=False";
mostCurrent._ckb_tatil_rasmi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=9961487;
 //BA.debugLineNum = 9961487;BA.debugLine="ckb_tatil_rasmi.Checked=True";
mostCurrent._ckb_tatil_rasmi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=9961490;
 //BA.debugLineNum = 9961490;BA.debugLine="Dim res_tatil_garardadi As Int =dbCode.get_setti";
_res_tatil_garardadi = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi")));
RDebugUtils.currentLine=9961491;
 //BA.debugLineNum = 9961491;BA.debugLine="If(res_tatil_garardadi=0)Then";
if ((_res_tatil_garardadi==0)) { 
RDebugUtils.currentLine=9961492;
 //BA.debugLineNum = 9961492;BA.debugLine="ckb_tatil_garardadi.Checked=False";
mostCurrent._ckb_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=9961494;
 //BA.debugLineNum = 9961494;BA.debugLine="ckb_tatil_garardadi.Checked=True";
mostCurrent._ckb_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=9961498;
 //BA.debugLineNum = 9961498;BA.debugLine="Dim minRoz_0 , minRoz_1, minRoz_2, minRoz_3, min";
_minroz_0 = 0;
_minroz_1 = 0;
_minroz_2 = 0;
_minroz_3 = 0;
_minroz_4 = 0;
_minroz_5 = (int) (0);
RDebugUtils.currentLine=9961499;
 //BA.debugLineNum = 9961499;BA.debugLine="minRoz_0=dbCode.get_setting_byName(\"saat_kar_Sha";
_minroz_0 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Shanbe")));
RDebugUtils.currentLine=9961500;
 //BA.debugLineNum = 9961500;BA.debugLine="minRoz_1=dbCode.get_setting_byName(\"saat_kar_Yek";
_minroz_1 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Yekshanbe")));
RDebugUtils.currentLine=9961501;
 //BA.debugLineNum = 9961501;BA.debugLine="minRoz_2=dbCode.get_setting_byName(\"saat_kar_Dos";
_minroz_2 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Doshanbe")));
RDebugUtils.currentLine=9961502;
 //BA.debugLineNum = 9961502;BA.debugLine="minRoz_3=dbCode.get_setting_byName(\"saat_kar_Ses";
_minroz_3 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Seshanbe")));
RDebugUtils.currentLine=9961503;
 //BA.debugLineNum = 9961503;BA.debugLine="minRoz_4=dbCode.get_setting_byName(\"saat_kar_Cha";
_minroz_4 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Charshanbe")));
RDebugUtils.currentLine=9961504;
 //BA.debugLineNum = 9961504;BA.debugLine="minRoz_5=dbCode.get_setting_byName(\"saat_kar_Pan";
_minroz_5 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Panjshanbe")));
RDebugUtils.currentLine=9961508;
 //BA.debugLineNum = 9961508;BA.debugLine="et_saat_kari0.Text=myfunc.strTOint(minRoz_0/60)";
mostCurrent._et_saat_kari0.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_0/(double)60))));
RDebugUtils.currentLine=9961509;
 //BA.debugLineNum = 9961509;BA.debugLine="et_min_kari0.Text=myfunc.strTOint(minRoz_0 Mod 6";
mostCurrent._et_min_kari0.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_0%60))));
RDebugUtils.currentLine=9961511;
 //BA.debugLineNum = 9961511;BA.debugLine="et_saat_kari1.Text=myfunc.strTOint(minRoz_1/60)";
mostCurrent._et_saat_kari1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_1/(double)60))));
RDebugUtils.currentLine=9961512;
 //BA.debugLineNum = 9961512;BA.debugLine="et_min_kari1.Text=myfunc.strTOint(minRoz_1 Mod 6";
mostCurrent._et_min_kari1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_1%60))));
RDebugUtils.currentLine=9961514;
 //BA.debugLineNum = 9961514;BA.debugLine="et_saat_kari2.Text=myfunc.strTOint(minRoz_2/60)";
mostCurrent._et_saat_kari2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_2/(double)60))));
RDebugUtils.currentLine=9961515;
 //BA.debugLineNum = 9961515;BA.debugLine="et_min_kari2.Text=myfunc.strTOint(minRoz_2 Mod 6";
mostCurrent._et_min_kari2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_2%60))));
RDebugUtils.currentLine=9961517;
 //BA.debugLineNum = 9961517;BA.debugLine="et_saat_kari3.Text=myfunc.strTOint(minRoz_3/60)";
mostCurrent._et_saat_kari3.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_3/(double)60))));
RDebugUtils.currentLine=9961518;
 //BA.debugLineNum = 9961518;BA.debugLine="et_min_kari3.Text=myfunc.strTOint(minRoz_3 Mod 6";
mostCurrent._et_min_kari3.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_3%60))));
RDebugUtils.currentLine=9961520;
 //BA.debugLineNum = 9961520;BA.debugLine="et_saat_kari4.Text=myfunc.strTOint(minRoz_4/60)";
mostCurrent._et_saat_kari4.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_4/(double)60))));
RDebugUtils.currentLine=9961521;
 //BA.debugLineNum = 9961521;BA.debugLine="et_min_kari4.Text=myfunc.strTOint(minRoz_4 Mod 6";
mostCurrent._et_min_kari4.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_4%60))));
RDebugUtils.currentLine=9961523;
 //BA.debugLineNum = 9961523;BA.debugLine="et_saat_kari5.Text=myfunc.strTOint(minRoz_5/60)";
mostCurrent._et_saat_kari5.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_5/(double)60))));
RDebugUtils.currentLine=9961524;
 //BA.debugLineNum = 9961524;BA.debugLine="et_min_kari5.Text=myfunc.strTOint(minRoz_5 Mod 6";
mostCurrent._et_min_kari5.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_5%60))));
RDebugUtils.currentLine=9961529;
 //BA.debugLineNum = 9961529;BA.debugLine="pan_all_setting_date.Visible=True";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
 } 
       catch (Exception e41) {
			processBA.setLastException(e41);RDebugUtils.currentLine=9961535;
 //BA.debugLineNum = 9961535;BA.debugLine="ScrollView_sett_taradod.Panel.LoadLayout(\"item_s";
mostCurrent._scrollview_sett_taradod.getPanel().LoadLayout("item_settingTaradod_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=9961536;
 //BA.debugLineNum = 9961536;BA.debugLine="lbl_setting_date_Click";
_lbl_setting_date_click();
RDebugUtils.currentLine=9961537;
 //BA.debugLineNum = 9961537;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("69961537",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=9961541;
 //BA.debugLineNum = 9961541;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_app_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_share_app_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_share_app_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _i = null;
RDebugUtils.currentLine=9175040;
 //BA.debugLineNum = 9175040;BA.debugLine="Private Sub lbl_share_app_Click";
RDebugUtils.currentLine=9175041;
 //BA.debugLineNum = 9175041;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=9175042;
 //BA.debugLineNum = 9175042;BA.debugLine="i.Initialize(i.ACTION_SEND, \"\")";
_i.Initialize(_i.ACTION_SEND,"");
RDebugUtils.currentLine=9175043;
 //BA.debugLineNum = 9175043;BA.debugLine="i.SetType(\"text/plain\")";
_i.SetType("text/plain");
RDebugUtils.currentLine=9175044;
 //BA.debugLineNum = 9175044;BA.debugLine="i.PutExtra(\"android.intent.extra.TEXT\", \"https://";
_i.PutExtra("android.intent.extra.TEXT",(Object)("https://cafebazaar.ir/app/ir.taravatgroup.ezafekari2"));
RDebugUtils.currentLine=9175045;
 //BA.debugLineNum = 9175045;BA.debugLine="i.WrapAsIntentChooser(\"انتخاب کنید\")";
_i.WrapAsIntentChooser("انتخاب کنید");
RDebugUtils.currentLine=9175046;
 //BA.debugLineNum = 9175046;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_i.getObject()));
RDebugUtils.currentLine=9175047;
 //BA.debugLineNum = 9175047;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
RDebugUtils.currentLine=9175048;
 //BA.debugLineNum = 9175048;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_share_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_share_click", null));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _str_file_matn = null;
String _name_gozaresh = "";
String _name_gozaresh_en = "";
anywheresoftware.b4a.objects.collections.List _ls_ezafe = null;
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
RDebugUtils.currentLine=9895936;
 //BA.debugLineNum = 9895936;BA.debugLine="Private Sub lbl_share_Click";
RDebugUtils.currentLine=9895938;
 //BA.debugLineNum = 9895938;BA.debugLine="Dim str_file_matn As StringBuilder";
_str_file_matn = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=9895939;
 //BA.debugLineNum = 9895939;BA.debugLine="str_file_matn.Initialize";
_str_file_matn.Initialize();
RDebugUtils.currentLine=9895940;
 //BA.debugLineNum = 9895940;BA.debugLine="Dim name_gozaresh As String=\"\"";
_name_gozaresh = "";
RDebugUtils.currentLine=9895941;
 //BA.debugLineNum = 9895941;BA.debugLine="Dim name_gozaresh_en As String=\"\"";
_name_gozaresh_en = "";
RDebugUtils.currentLine=9895943;
 //BA.debugLineNum = 9895943;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=9895945;
 //BA.debugLineNum = 9895945;BA.debugLine="Select TabHost1.CurrentTab";
switch (BA.switchObjectToInt(mostCurrent._tabhost1.getCurrentTab(),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
RDebugUtils.currentLine=9895948;
 //BA.debugLineNum = 9895948;BA.debugLine="name_gozaresh=\"اضافه کاری ها-\"";
_name_gozaresh = "اضافه کاری ها-";
RDebugUtils.currentLine=9895949;
 //BA.debugLineNum = 9895949;BA.debugLine="name_gozaresh_en=\"ezafekari\"";
_name_gozaresh_en = "ezafekari";
RDebugUtils.currentLine=9895950;
 //BA.debugLineNum = 9895950;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
case 1: {
RDebugUtils.currentLine=9895953;
 //BA.debugLineNum = 9895953;BA.debugLine="name_gozaresh=\"مرخصی ها-\"";
_name_gozaresh = "مرخصی ها-";
RDebugUtils.currentLine=9895954;
 //BA.debugLineNum = 9895954;BA.debugLine="name_gozaresh_en=\"morakhasi\"";
_name_gozaresh_en = "morakhasi";
RDebugUtils.currentLine=9895955;
 //BA.debugLineNum = 9895955;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
case 2: {
RDebugUtils.currentLine=9895958;
 //BA.debugLineNum = 9895958;BA.debugLine="name_gozaresh=\"ترددها-\"";
_name_gozaresh = "ترددها-";
RDebugUtils.currentLine=9895959;
 //BA.debugLineNum = 9895959;BA.debugLine="name_gozaresh_en=\"taradod\"";
_name_gozaresh_en = "taradod";
RDebugUtils.currentLine=9895960;
 //BA.debugLineNum = 9895960;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
case 3: {
RDebugUtils.currentLine=9895963;
 //BA.debugLineNum = 9895963;BA.debugLine="name_gozaresh=\"مأموریت ها-\"";
_name_gozaresh = "مأموریت ها-";
RDebugUtils.currentLine=9895964;
 //BA.debugLineNum = 9895964;BA.debugLine="name_gozaresh_en=\"mamoriat\"";
_name_gozaresh_en = "mamoriat";
RDebugUtils.currentLine=9895965;
 //BA.debugLineNum = 9895965;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
}
;
RDebugUtils.currentLine=9895973;
 //BA.debugLineNum = 9895973;BA.debugLine="str_file_matn.Append(\"<!DOCTYPE html><html dir='r";
_str_file_matn.Append("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>");
RDebugUtils.currentLine=9895974;
 //BA.debugLineNum = 9895974;BA.debugLine="str_file_matn.Append(\"<style>table , td {border:";
_str_file_matn.Append("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	</style>");
RDebugUtils.currentLine=9895976;
 //BA.debugLineNum = 9895976;BA.debugLine="str_file_matn.Append(\"<h3>\").Append(\" گزارش \"&nam";
_str_file_matn.Append("<h3>").Append(" گزارش "+_name_gozaresh+mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())).Append("</h3>");
RDebugUtils.currentLine=9895982;
 //BA.debugLineNum = 9895982;BA.debugLine="str_file_matn.Append(\"نام کاربر :\").Append(\"<span";
_str_file_matn.Append("نام کاربر :").Append("<span> "+_user_namefamili+"</span>").Append("<br>");
RDebugUtils.currentLine=9895984;
 //BA.debugLineNum = 9895984;BA.debugLine="str_file_matn.Append(\"<div style=' background-col";
_str_file_matn.Append("<div style=' background-color: #f5f5f5;'>");
RDebugUtils.currentLine=9895987;
 //BA.debugLineNum = 9895987;BA.debugLine="str_file_matn.Append(\"<table style='width:100%;'>";
_str_file_matn.Append("<table style='width:100%;'><tr style='text-align: center;'>");
RDebugUtils.currentLine=9895988;
 //BA.debugLineNum = 9895988;BA.debugLine="str_file_matn.Append(\"<td><b> ردیف</b></td><td><b";
_str_file_matn.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td><br></tr>");
RDebugUtils.currentLine=9895990;
 //BA.debugLineNum = 9895990;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=9895991;
 //BA.debugLineNum = 9895991;BA.debugLine="str_file_matn.Append(\"<tr style='text-align: cen";
_str_file_matn.Append("<tr style='text-align: center;'>");
RDebugUtils.currentLine=9895992;
 //BA.debugLineNum = 9895992;BA.debugLine="str_file_matn.Append(\"<td>\").Append(myfunc.en2fa";
_str_file_matn.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
RDebugUtils.currentLine=9895993;
 //BA.debugLineNum = 9895993;BA.debugLine="str_file_matn.Append(\"<td>\").Append(myfunc.en2fa";
_str_file_matn.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
RDebugUtils.currentLine=9895994;
 //BA.debugLineNum = 9895994;BA.debugLine="str_file_matn.Append(\"<td>\").Append(myfunc.en2fa";
_str_file_matn.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
RDebugUtils.currentLine=9895996;
 //BA.debugLineNum = 9895996;BA.debugLine="str_file_matn.Append(\"<td>\")";
_str_file_matn.Append("<td>");
RDebugUtils.currentLine=9895999;
 //BA.debugLineNum = 9895999;BA.debugLine="Dim ls_ezafe As List";
_ls_ezafe = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9896000;
 //BA.debugLineNum = 9896000;BA.debugLine="ls_ezafe.Initialize";
_ls_ezafe.Initialize();
RDebugUtils.currentLine=9896002;
 //BA.debugLineNum = 9896002;BA.debugLine="If( TabHost1.CurrentTab=0 Or  TabHost1.CurrentTa";
if ((mostCurrent._tabhost1.getCurrentTab()==0 || mostCurrent._tabhost1.getCurrentTab()==2)) { 
RDebugUtils.currentLine=9896003;
 //BA.debugLineNum = 9896003;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz2_dontDay(dbCo";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 }else {
RDebugUtils.currentLine=9896005;
 //BA.debugLineNum = 9896005;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz(dbCode.res.Ge";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
RDebugUtils.currentLine=9896006;
 //BA.debugLineNum = 9896006;BA.debugLine="str_file_matn.Append(ls_ezafe.Get(2))";
_str_file_matn.Append(BA.ObjectToString(_ls_ezafe.Get((int) (2))));
RDebugUtils.currentLine=9896007;
 //BA.debugLineNum = 9896007;BA.debugLine="str_file_matn.Append(\":\")";
_str_file_matn.Append(":");
 };
RDebugUtils.currentLine=9896015;
 //BA.debugLineNum = 9896015;BA.debugLine="str_file_matn.Append(ls_ezafe.Get(0))";
_str_file_matn.Append(BA.ObjectToString(_ls_ezafe.Get((int) (0))));
RDebugUtils.currentLine=9896016;
 //BA.debugLineNum = 9896016;BA.debugLine="str_file_matn.Append(\":\")";
_str_file_matn.Append(":");
RDebugUtils.currentLine=9896017;
 //BA.debugLineNum = 9896017;BA.debugLine="str_file_matn.Append(ls_ezafe.Get(1)).Append(\"</t";
_str_file_matn.Append(BA.ObjectToString(_ls_ezafe.Get((int) (1)))).Append("</td>");
RDebugUtils.currentLine=9896019;
 //BA.debugLineNum = 9896019;BA.debugLine="str_file_matn.Append(\"</tr>\")";
_str_file_matn.Append("</tr>");
 }
;
RDebugUtils.currentLine=9896023;
 //BA.debugLineNum = 9896023;BA.debugLine="str_file_matn.Append(\"</table>\")";
_str_file_matn.Append("</table>");
RDebugUtils.currentLine=9896024;
 //BA.debugLineNum = 9896024;BA.debugLine="str_file_matn.Append(\"مجموع ساعت  :<span style='co";
_str_file_matn.Append("مجموع ساعت  :<span style='color:#5E35B1;'> "+mostCurrent._lbl_majmoe_saat.getText()+" </span><br></div><br> ");
RDebugUtils.currentLine=9896030;
 //BA.debugLineNum = 9896030;BA.debugLine="str_file_matn.Append(\"<br></details></div>\")";
_str_file_matn.Append("<br></details></div>");
RDebugUtils.currentLine=9896032;
 //BA.debugLineNum = 9896032;BA.debugLine="str_file_matn.Append(\"<footer style=' text-align:";
_str_file_matn.Append("<footer style=' text-align: center; '><h6> اپلیکیشن اضافه کاری من </h6></footer>");
RDebugUtils.currentLine=9896034;
 //BA.debugLineNum = 9896034;BA.debugLine="str_file_matn.Append(\"</body></html>\")";
_str_file_matn.Append("</body></html>");
RDebugUtils.currentLine=9896039;
 //BA.debugLineNum = 9896039;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=9896040;
 //BA.debugLineNum = 9896040;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=9896047;
 //BA.debugLineNum = 9896047;BA.debugLine="Dim FileName As String =name_gozaresh_en&\"-\"&myfu";
_filename = _name_gozaresh_en+"-"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+".html";
RDebugUtils.currentLine=9896050;
 //BA.debugLineNum = 9896050;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
anywheresoftware.b4a.keywords.Common.File.WriteString(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename,_str_file_matn.ToString());
RDebugUtils.currentLine=9896052;
 //BA.debugLineNum = 9896052;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=9896053;
 //BA.debugLineNum = 9896053;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
RDebugUtils.currentLine=9896054;
 //BA.debugLineNum = 9896054;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
RDebugUtils.currentLine=9896055;
 //BA.debugLineNum = 9896055;BA.debugLine="email.Body = \" گزارش  \"&name_gozaresh&CRLF&\"اپلیک";
_email.Body = " گزارش  "+_name_gozaresh+anywheresoftware.b4a.keywords.Common.CRLF+"اپلیکیشن اضافه کاری من"+anywheresoftware.b4a.keywords.Common.CRLF+"دانلود از بازار";
RDebugUtils.currentLine=9896056;
 //BA.debugLineNum = 9896056;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (null,_filename));
RDebugUtils.currentLine=9896058;
 //BA.debugLineNum = 9896058;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
RDebugUtils.currentLine=9896059;
 //BA.debugLineNum = 9896059;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
RDebugUtils.currentLine=9896060;
 //BA.debugLineNum = 9896060;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
RDebugUtils.currentLine=9896063;
 //BA.debugLineNum = 9896063;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_later_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip_later_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip_later_click", null));}
RDebugUtils.currentLine=7929856;
 //BA.debugLineNum = 7929856;BA.debugLine="Private Sub lbl_vip_later_Click";
RDebugUtils.currentLine=7929857;
 //BA.debugLineNum = 7929857;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
RDebugUtils.currentLine=7929858;
 //BA.debugLineNum = 7929858;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_now_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip_now_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip_now_click", null));}
String _title = "";
String _matn = "";
int _result = 0;
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Private Sub lbl_vip_now_Click";
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=7995396;
 //BA.debugLineNum = 7995396;BA.debugLine="Dim title , matn As String";
_title = "";
_matn = "";
RDebugUtils.currentLine=7995397;
 //BA.debugLineNum = 7995397;BA.debugLine="title=\" تبریک \"";
_title = " تبریک ";
RDebugUtils.currentLine=7995398;
 //BA.debugLineNum = 7995398;BA.debugLine="matn=\" شما صاحب نسخه طلایی و بدون محدودیت برنامه";
_matn = " شما صاحب نسخه طلایی و بدون محدودیت برنامه اضافه کاری من می باشید. ";
RDebugUtils.currentLine=7995400;
 //BA.debugLineNum = 7995400;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=7995401;
 //BA.debugLineNum = 7995401;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Lo";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"باشه","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"buy.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=7995402;
 //BA.debugLineNum = 7995402;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
 }else {
RDebugUtils.currentLine=7995409;
 //BA.debugLineNum = 7995409;BA.debugLine="kharid";
_kharid();
 };
RDebugUtils.currentLine=7995411;
 //BA.debugLineNum = 7995411;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip2_click", null));}
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Private Sub lbl_vip2_Click";
RDebugUtils.currentLine=7733249;
 //BA.debugLineNum = 7733249;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
RDebugUtils.currentLine=7733250;
 //BA.debugLineNum = 7733250;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=8847360;
 //BA.debugLineNum = 8847360;BA.debugLine="Sub min_between_to_time(dat1 As String,dat2 As Str";
RDebugUtils.currentLine=8847363;
 //BA.debugLineNum = 8847363;BA.debugLine="Try";
try {RDebugUtils.currentLine=8847365;
 //BA.debugLineNum = 8847365;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8847366;
 //BA.debugLineNum = 8847366;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8847367;
 //BA.debugLineNum = 8847367;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
RDebugUtils.currentLine=8847368;
 //BA.debugLineNum = 8847368;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
RDebugUtils.currentLine=8847370;
 //BA.debugLineNum = 8847370;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=8847371;
 //BA.debugLineNum = 8847371;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=8847372;
 //BA.debugLineNum = 8847372;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=8847373;
 //BA.debugLineNum = 8847373;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=8847382;
 //BA.debugLineNum = 8847382;BA.debugLine="date1=dat1";
mostCurrent._date1 = _dat1;
RDebugUtils.currentLine=8847383;
 //BA.debugLineNum = 8847383;BA.debugLine="date2=dat2";
mostCurrent._date2 = _dat2;
RDebugUtils.currentLine=8847384;
 //BA.debugLineNum = 8847384;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
RDebugUtils.currentLine=8847385;
 //BA.debugLineNum = 8847385;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
RDebugUtils.currentLine=8847389;
 //BA.debugLineNum = 8847389;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_da";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=8847390;
 //BA.debugLineNum = 8847390;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_da";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=8847393;
 //BA.debugLineNum = 8847393;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=8847394;
 //BA.debugLineNum = 8847394;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=8847397;
 //BA.debugLineNum = 8847397;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
RDebugUtils.currentLine=8847398;
 //BA.debugLineNum = 8847398;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
RDebugUtils.currentLine=8847400;
 //BA.debugLineNum = 8847400;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=8847401;
 //BA.debugLineNum = 8847401;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=8847403;
 //BA.debugLineNum = 8847403;BA.debugLine="time_end2=tim2&\":00\"";
_time_end2 = _tim2+":00";
RDebugUtils.currentLine=8847404;
 //BA.debugLineNum = 8847404;BA.debugLine="time_end1=tim1&\":00\"";
_time_end1 = _tim1+":00";
RDebugUtils.currentLine=8847406;
 //BA.debugLineNum = 8847406;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
RDebugUtils.currentLine=8847407;
 //BA.debugLineNum = 8847407;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
RDebugUtils.currentLine=8847408;
 //BA.debugLineNum = 8847408;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
RDebugUtils.currentLine=8847409;
 //BA.debugLineNum = 8847409;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
RDebugUtils.currentLine=8847413;
 //BA.debugLineNum = 8847413;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
RDebugUtils.currentLine=8847414;
 //BA.debugLineNum = 8847414;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
 } 
       catch (Exception e31) {
			processBA.setLastException(e31);RDebugUtils.currentLine=8847419;
 //BA.debugLineNum = 8847419;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=8847422;
 //BA.debugLineNum = 8847422;BA.debugLine="Return (period_between.Days*24*60)+(period_betwee";
if (true) return (int) ((_period_between.Days*24*60)+(_period_between.Hours*60)+_period_between.Minutes);
RDebugUtils.currentLine=8847423;
 //BA.debugLineNum = 8847423;BA.debugLine="End Sub";
return 0;
}
public static String  _pan_add_other_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_other_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_other_click", null));}
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Private Sub pan_add_other_Click";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="StartActivity(sabt2_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._sabt2_activity.getObject()));
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_msgnewyear_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_msgnewyear_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_msgnewyear_click", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub pan_all_msgNewYear_Click";
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_setting_date_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_setting_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_setting_date_click", null));}
RDebugUtils.currentLine=10027008;
 //BA.debugLineNum = 10027008;BA.debugLine="Private Sub pan_all_setting_date_Click";
RDebugUtils.currentLine=10027009;
 //BA.debugLineNum = 10027009;BA.debugLine="pan_all_setting_date.Visible=False";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10027010;
 //BA.debugLineNum = 10027010;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all2_click", null));}
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Private Sub pan_all2_Click";
RDebugUtils.currentLine=6684675;
 //BA.debugLineNum = 6684675;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6684676;
 //BA.debugLineNum = 6684676;BA.debugLine="End Sub";
return "";
}
public static String  _pan_bime_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_bime_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_bime_click", null));}
anywheresoftware.b4a.phone.Phone.PhoneIntents _phoneintents1 = null;
RDebugUtils.currentLine=9043968;
 //BA.debugLineNum = 9043968;BA.debugLine="Private Sub pan_bime_Click";
RDebugUtils.currentLine=9043971;
 //BA.debugLineNum = 9043971;BA.debugLine="Dim PhoneIntents1 As PhoneIntents";
_phoneintents1 = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
RDebugUtils.currentLine=9043972;
 //BA.debugLineNum = 9043972;BA.debugLine="StartActivity (PhoneIntents1.OpenBrowser(\"https:/";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_phoneintents1.OpenBrowser("https://eservices.tamin.ir/view/#/history")));
RDebugUtils.currentLine=9043974;
 //BA.debugLineNum = 9043974;BA.debugLine="End Sub";
return "";
}
public static String  _pan_calc_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_calc_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_calc_click", null));}
RDebugUtils.currentLine=6946816;
 //BA.debugLineNum = 6946816;BA.debugLine="Private Sub pan_calc_Click";
RDebugUtils.currentLine=6946817;
 //BA.debugLineNum = 6946817;BA.debugLine="StartActivity(calc_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._calc_activity.getObject()));
RDebugUtils.currentLine=6946820;
 //BA.debugLineNum = 6946820;BA.debugLine="End Sub";
return "";
}
public static String  _pan_comment_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_comment_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_comment_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _market = null;
String _url = "";
RDebugUtils.currentLine=6815744;
 //BA.debugLineNum = 6815744;BA.debugLine="Private Sub pan_comment_Click";
RDebugUtils.currentLine=6815746;
 //BA.debugLineNum = 6815746;BA.debugLine="Try";
try {RDebugUtils.currentLine=6815747;
 //BA.debugLineNum = 6815747;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=6815749;
 //BA.debugLineNum = 6815749;BA.debugLine="Try";
try {RDebugUtils.currentLine=6815750;
 //BA.debugLineNum = 6815750;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=6815751;
 //BA.debugLineNum = 6815751;BA.debugLine="Dim url As String";
_url = "";
RDebugUtils.currentLine=6815753;
 //BA.debugLineNum = 6815753;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafek";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
RDebugUtils.currentLine=6815754;
 //BA.debugLineNum = 6815754;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
RDebugUtils.currentLine=6815755;
 //BA.debugLineNum = 6815755;BA.debugLine="market.SetPackage(\"com.farsitel.bazaar\")";
_market.SetPackage("com.farsitel.bazaar");
RDebugUtils.currentLine=6815756;
 //BA.debugLineNum = 6815756;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e11) {
			processBA.setLastException(e11);RDebugUtils.currentLine=6815759;
 //BA.debugLineNum = 6815759;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=6815762;
 //BA.debugLineNum = 6815762;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e17) {
			processBA.setLastException(e17);RDebugUtils.currentLine=6815766;
 //BA.debugLineNum = 6815766;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=6815768;
 //BA.debugLineNum = 6815768;BA.debugLine="Try";
try {RDebugUtils.currentLine=6815769;
 //BA.debugLineNum = 6815769;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=6815770;
 //BA.debugLineNum = 6815770;BA.debugLine="Dim url As String";
_url = "";
RDebugUtils.currentLine=6815772;
 //BA.debugLineNum = 6815772;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafe";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
RDebugUtils.currentLine=6815773;
 //BA.debugLineNum = 6815773;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
RDebugUtils.currentLine=6815774;
 //BA.debugLineNum = 6815774;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e25) {
			processBA.setLastException(e25);RDebugUtils.currentLine=6815777;
 //BA.debugLineNum = 6815777;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=6815780;
 //BA.debugLineNum = 6815780;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 };
RDebugUtils.currentLine=6815787;
 //BA.debugLineNum = 6815787;BA.debugLine="End Sub";
return "";
}
public static String  _pan_darsad_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_darsad_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_darsad_click", null));}
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Private Sub pan_darsad_Click";
RDebugUtils.currentLine=6750209;
 //BA.debugLineNum = 6750209;BA.debugLine="StartActivity(darsad_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._darsad_activity.getObject()));
RDebugUtils.currentLine=6750211;
 //BA.debugLineNum = 6750211;BA.debugLine="End Sub";
return "";
}
public static String  _pan_eidi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_eidi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_eidi_click", null));}
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Private Sub pan_eidi_Click";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="StartActivity(eidi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._eidi_activity.getObject()));
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ezafekari_mah_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_ezafekari_mah_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_ezafekari_mah_click", null));}
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Private Sub pan_ezafekari_mah_Click";
RDebugUtils.currentLine=7798785;
 //BA.debugLineNum = 7798785;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="TabHost1.CurrentTab=0";
mostCurrent._tabhost1.setCurrentTab((int) (0));
RDebugUtils.currentLine=7798788;
 //BA.debugLineNum = 7798788;BA.debugLine="End Sub";
return "";
}
public static String  _pan_fast_run_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_fast_run_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_fast_run_click", null));}
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Private Sub pan_fast_run_Click";
RDebugUtils.currentLine=3276805;
 //BA.debugLineNum = 3276805;BA.debugLine="StartActivity(fast_run_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._fast_run_activity.getObject()));
RDebugUtils.currentLine=3276809;
 //BA.debugLineNum = 3276809;BA.debugLine="End Sub";
return "";
}
public static String  _pan_finger_taradod_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_finger_taradod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_finger_taradod_click", null));}
RDebugUtils.currentLine=10223616;
 //BA.debugLineNum = 10223616;BA.debugLine="Private Sub pan_finger_taradod_Click";
RDebugUtils.currentLine=10223618;
 //BA.debugLineNum = 10223618;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ganon_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_ganon_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_ganon_click", null));}
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Private Sub pan_ganon_Click";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="StartActivity(ganon_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ganon_activity.getObject()));
RDebugUtils.currentLine=8257539;
 //BA.debugLineNum = 8257539;BA.debugLine="End Sub";
return "";
}
public static String  _pan_help_kharid_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_help_kharid_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_help_kharid_click", null));}
RDebugUtils.currentLine=9633792;
 //BA.debugLineNum = 9633792;BA.debugLine="Private Sub pan_help_kharid_Click";
RDebugUtils.currentLine=9633795;
 //BA.debugLineNum = 9633795;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=9633796;
 //BA.debugLineNum = 9633796;BA.debugLine="StartActivity(help_kharid_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._help_kharid_activity.getObject()));
 }else {
RDebugUtils.currentLine=9633798;
 //BA.debugLineNum = 9633798;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 };
RDebugUtils.currentLine=9633803;
 //BA.debugLineNum = 9633803;BA.debugLine="End Sub";
return "";
}
public static String  _pan_help_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_help_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_help_touch", new Object[] {_action,_x,_y}));}
RDebugUtils.currentLine=7208960;
 //BA.debugLineNum = 7208960;BA.debugLine="Private Sub pan_help_Touch (Action As Int, X As Fl";
RDebugUtils.currentLine=7208962;
 //BA.debugLineNum = 7208962;BA.debugLine="If (Action=0)Then";
if ((_action==0)) { 
RDebugUtils.currentLine=7208963;
 //BA.debugLineNum = 7208963;BA.debugLine="index_x_start_swap=x";
_index_x_start_swap = (int) (_x);
RDebugUtils.currentLine=7208964;
 //BA.debugLineNum = 7208964;BA.debugLine="If (index_curent_img=4)Then";
if ((_index_curent_img==4)) { 
RDebugUtils.currentLine=7208965;
 //BA.debugLineNum = 7208965;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
RDebugUtils.currentLine=7208968;
 //BA.debugLineNum = 7208968;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=7208969;
 //BA.debugLineNum = 7208969;BA.debugLine="If(X<(index_x_start_swap-150))Then";
if ((_x<(_index_x_start_swap-150))) { 
RDebugUtils.currentLine=7208972;
 //BA.debugLineNum = 7208972;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
RDebugUtils.currentLine=7208973;
 //BA.debugLineNum = 7208973;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
RDebugUtils.currentLine=7208974;
 //BA.debugLineNum = 7208974;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 }else 
{RDebugUtils.currentLine=7208978;
 //BA.debugLineNum = 7208978;BA.debugLine="Else If(X>(index_x_start_swap+150))Then";
if ((_x>(_index_x_start_swap+150))) { 
RDebugUtils.currentLine=7208981;
 //BA.debugLineNum = 7208981;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
RDebugUtils.currentLine=7208982;
 //BA.debugLineNum = 7208982;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
RDebugUtils.currentLine=7208983;
 //BA.debugLineNum = 7208983;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else 
{RDebugUtils.currentLine=7208987;
 //BA.debugLineNum = 7208987;BA.debugLine="Else If(index_x_start_swap<(pan_help.Width/2))Th";
if ((_index_x_start_swap<(mostCurrent._pan_help.getWidth()/(double)2))) { 
RDebugUtils.currentLine=7208989;
 //BA.debugLineNum = 7208989;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
RDebugUtils.currentLine=7208990;
 //BA.debugLineNum = 7208990;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
RDebugUtils.currentLine=7208991;
 //BA.debugLineNum = 7208991;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else 
{RDebugUtils.currentLine=7208994;
 //BA.debugLineNum = 7208994;BA.debugLine="Else If(index_x_start_swap>(pan_help.Width/2))Th";
if ((_index_x_start_swap>(mostCurrent._pan_help.getWidth()/(double)2))) { 
RDebugUtils.currentLine=7208996;
 //BA.debugLineNum = 7208996;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
RDebugUtils.currentLine=7208997;
 //BA.debugLineNum = 7208997;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
RDebugUtils.currentLine=7208998;
 //BA.debugLineNum = 7208998;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 }}}}
;
RDebugUtils.currentLine=7209003;
 //BA.debugLineNum = 7209003;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 };
RDebugUtils.currentLine=7209006;
 //BA.debugLineNum = 7209006;BA.debugLine="End Sub";
return "";
}
public static String  _pan_info_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_info_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_info_click", null));}
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Private Sub pan_info_Click";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="StartActivity(info_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._info_activity.getObject()));
RDebugUtils.currentLine=6029316;
 //BA.debugLineNum = 6029316;BA.debugLine="End Sub";
return "";
}
public static String  _pan_item_gozaresh_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_item_gozaresh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_item_gozaresh_click", null));}
anywheresoftware.b4a.objects.PanelWrapper _ba = null;
RDebugUtils.currentLine=6881280;
 //BA.debugLineNum = 6881280;BA.debugLine="Private Sub pan_item_gozaresh_Click";
RDebugUtils.currentLine=6881281;
 //BA.debugLineNum = 6881281;BA.debugLine="Dim Ba As Panel = Sender";
_ba = new anywheresoftware.b4a.objects.PanelWrapper();
_ba = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=6881283;
 //BA.debugLineNum = 6881283;BA.debugLine="current_gozaresh_id=Ba.Tag";
_current_gozaresh_id = (int)(BA.ObjectToNumber(_ba.getTag()));
RDebugUtils.currentLine=6881284;
 //BA.debugLineNum = 6881284;BA.debugLine="StartActivity(show_gozaresh_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._show_gozaresh_activity.getObject()));
RDebugUtils.currentLine=6881286;
 //BA.debugLineNum = 6881286;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lelp_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_lelp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_lelp_click", null));}
RDebugUtils.currentLine=7274496;
 //BA.debugLineNum = 7274496;BA.debugLine="Private Sub pan_lelp_Click";
RDebugUtils.currentLine=7274498;
 //BA.debugLineNum = 7274498;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lock_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_lock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_lock_click", null));}
RDebugUtils.currentLine=9109504;
 //BA.debugLineNum = 9109504;BA.debugLine="Private Sub pan_lock_Click";
RDebugUtils.currentLine=9109506;
 //BA.debugLineNum = 9109506;BA.debugLine="End Sub";
return "";
}
public static String  _pan_morakhasi_mah_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_morakhasi_mah_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_morakhasi_mah_click", null));}
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Private Sub pan_morakhasi_mah_Click";
RDebugUtils.currentLine=7864321;
 //BA.debugLineNum = 7864321;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
RDebugUtils.currentLine=7864322;
 //BA.debugLineNum = 7864322;BA.debugLine="TabHost1.CurrentTab=1";
mostCurrent._tabhost1.setCurrentTab((int) (1));
RDebugUtils.currentLine=7864324;
 //BA.debugLineNum = 7864324;BA.debugLine="End Sub";
return "";
}
public static String  _pan_notifi_all_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_notifi_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_notifi_all_click", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Private Sub pan_notifi_all_Click";
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="End Sub";
return "";
}
public static String  _pan_payankar_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_payankar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_payankar_click", null));}
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Private Sub pan_payankar_Click";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="StartActivity(payankar_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._payankar_activity.getObject()));
RDebugUtils.currentLine=5963779;
 //BA.debugLineNum = 5963779;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_hogog_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_run_hogog_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_run_hogog_click", null));}
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Private Sub pan_run_hogog_Click";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="If (myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
 }else {
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
 };
RDebugUtils.currentLine=3473418;
 //BA.debugLineNum = 3473418;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_morakhasi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_run_morakhasi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_run_morakhasi_click", null));}
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Private Sub pan_run_morakhasi_Click";
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="StartActivity(morakhasi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._morakhasi_activity.getObject()));
RDebugUtils.currentLine=3407881;
 //BA.debugLineNum = 3407881;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_setting_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_setting_click", null));}
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Private Sub pan_setting_Click";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="StartActivity(setting_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_activity.getObject()));
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=8323075;
 //BA.debugLineNum = 8323075;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_hogog_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_setting_hogog_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_setting_hogog_click", null));}
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Private Sub pan_setting_hogog_Click";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="StartActivity(setting_hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_hogog_activity.getObject()));
RDebugUtils.currentLine=3342340;
 //BA.debugLineNum = 3342340;BA.debugLine="End Sub";
return "";
}
public static String  _pan_shift_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_shift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_shift_click", null));}
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Private Sub pan_shift_Click";
RDebugUtils.currentLine=8454146;
 //BA.debugLineNum = 8454146;BA.debugLine="StartActivity(shift_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._shift_activity.getObject()));
RDebugUtils.currentLine=8454148;
 //BA.debugLineNum = 8454148;BA.debugLine="End Sub";
return "";
}
public static String  _pan_taghvim_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_taghvim_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_taghvim_click", null));}
RDebugUtils.currentLine=8519680;
 //BA.debugLineNum = 8519680;BA.debugLine="Private Sub pan_taghvim_Click";
RDebugUtils.currentLine=8519681;
 //BA.debugLineNum = 8519681;BA.debugLine="pan_shift_Click";
_pan_shift_click();
RDebugUtils.currentLine=8519682;
 //BA.debugLineNum = 8519682;BA.debugLine="End Sub";
return "";
}
public static String  _panel1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel1_click", null));}
RDebugUtils.currentLine=8716288;
 //BA.debugLineNum = 8716288;BA.debugLine="Private Sub Panel1_Click";
RDebugUtils.currentLine=8716290;
 //BA.debugLineNum = 8716290;BA.debugLine="End Sub";
return "";
}
public static String  _panel10_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel10_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel10_click", null));}
RDebugUtils.currentLine=9502720;
 //BA.debugLineNum = 9502720;BA.debugLine="Private Sub Panel10_Click";
RDebugUtils.currentLine=9502722;
 //BA.debugLineNum = 9502722;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel4_click", null));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Private Sub Panel4_Click";
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="End Sub";
return "";
}
public static String  _panel5_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel5_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel5_click", null));}
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Private Sub Panel5_Click";
RDebugUtils.currentLine=8126466;
 //BA.debugLineNum = 8126466;BA.debugLine="End Sub";
return "";
}
public static String  _panel6_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel6_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel6_click", null));}
RDebugUtils.currentLine=8912896;
 //BA.debugLineNum = 8912896;BA.debugLine="Private Sub Panel6_Click";
RDebugUtils.currentLine=8912898;
 //BA.debugLineNum = 8912898;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=5636096;
 //BA.debugLineNum = 5636096;BA.debugLine="Private Sub pik_day_bala1_Click";
RDebugUtils.currentLine=5636097;
 //BA.debugLineNum = 5636097;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=5636098;
 //BA.debugLineNum = 5636098;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=5636101;
 //BA.debugLineNum = 5636101;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=5636102;
 //BA.debugLineNum = 5636102;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=5636103;
 //BA.debugLineNum = 5636103;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=5636105;
 //BA.debugLineNum = 5636105;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=5636106;
 //BA.debugLineNum = 5636106;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=5636109;
 //BA.debugLineNum = 5636109;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=5636110;
 //BA.debugLineNum = 5636110;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=5636112;
 //BA.debugLineNum = 5636112;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=5636113;
 //BA.debugLineNum = 5636113;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=5636117;
 //BA.debugLineNum = 5636117;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=5636119;
 //BA.debugLineNum = 5636119;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Private Sub pik_day_paeen1_Click";
RDebugUtils.currentLine=5701633;
 //BA.debugLineNum = 5701633;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=5701634;
 //BA.debugLineNum = 5701634;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=5701635;
 //BA.debugLineNum = 5701635;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=5701636;
 //BA.debugLineNum = 5701636;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=5701637;
 //BA.debugLineNum = 5701637;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=5701639;
 //BA.debugLineNum = 5701639;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=5701640;
 //BA.debugLineNum = 5701640;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=5701643;
 //BA.debugLineNum = 5701643;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=5701644;
 //BA.debugLineNum = 5701644;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=5701646;
 //BA.debugLineNum = 5701646;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=5701647;
 //BA.debugLineNum = 5701647;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=5701651;
 //BA.debugLineNum = 5701651;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=5701653;
 //BA.debugLineNum = 5701653;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_hour_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_hour_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Private Sub pik_hour_bala1_Click";
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
RDebugUtils.currentLine=4784131;
 //BA.debugLineNum = 4784131;BA.debugLine="pik_hour1.Text=int1+1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=4784135;
 //BA.debugLineNum = 4784135;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
RDebugUtils.currentLine=4784136;
 //BA.debugLineNum = 4784136;BA.debugLine="pik_hour1.Text=0";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=4784138;
 //BA.debugLineNum = 4784138;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
RDebugUtils.currentLine=4784139;
 //BA.debugLineNum = 4784139;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
RDebugUtils.currentLine=4784142;
 //BA.debugLineNum = 4784142;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(pik_hour1.Text";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_hour1.getText())))));
RDebugUtils.currentLine=4784144;
 //BA.debugLineNum = 4784144;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_hour_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_hour_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Private Sub pik_hour_paeen1_Click";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="pik_hour1.Text=int1-1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=4849668;
 //BA.debugLineNum = 4849668;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
RDebugUtils.currentLine=4849669;
 //BA.debugLineNum = 4849669;BA.debugLine="pik_hour1.Text=0";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=4849671;
 //BA.debugLineNum = 4849671;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
RDebugUtils.currentLine=4849672;
 //BA.debugLineNum = 4849672;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
RDebugUtils.currentLine=4849675;
 //BA.debugLineNum = 4849675;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(pik_hour1.Text";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_hour1.getText())))));
RDebugUtils.currentLine=4849676;
 //BA.debugLineNum = 4849676;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_min_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_min_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Private Sub pik_min_bala1_Click";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
RDebugUtils.currentLine=4915202;
 //BA.debugLineNum = 4915202;BA.debugLine="pik_min1.Text=int1+1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=4915204;
 //BA.debugLineNum = 4915204;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
RDebugUtils.currentLine=4915205;
 //BA.debugLineNum = 4915205;BA.debugLine="pik_min1.Text=0";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=4915207;
 //BA.debugLineNum = 4915207;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
RDebugUtils.currentLine=4915208;
 //BA.debugLineNum = 4915208;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
RDebugUtils.currentLine=4915211;
 //BA.debugLineNum = 4915211;BA.debugLine="pik_min1.Text=myfunc.convert_adad(pik_min1.Text)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_min1.getText())))));
RDebugUtils.currentLine=4915213;
 //BA.debugLineNum = 4915213;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_min_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_min_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Private Sub pik_min_paeen1_Click";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="pik_min1.Text=int1-1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=4980740;
 //BA.debugLineNum = 4980740;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
RDebugUtils.currentLine=4980741;
 //BA.debugLineNum = 4980741;BA.debugLine="pik_min1.Text=0";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=4980743;
 //BA.debugLineNum = 4980743;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
RDebugUtils.currentLine=4980744;
 //BA.debugLineNum = 4980744;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
RDebugUtils.currentLine=4980746;
 //BA.debugLineNum = 4980746;BA.debugLine="pik_min1.Text=myfunc.convert_adad(pik_min1.Text)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_min1.getText())))));
RDebugUtils.currentLine=4980748;
 //BA.debugLineNum = 4980748;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=5373952;
 //BA.debugLineNum = 5373952;BA.debugLine="Private Sub pik_moon_bala1_Click";
RDebugUtils.currentLine=5373953;
 //BA.debugLineNum = 5373953;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=5373954;
 //BA.debugLineNum = 5373954;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
RDebugUtils.currentLine=5373956;
 //BA.debugLineNum = 5373956;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=5373957;
 //BA.debugLineNum = 5373957;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=5373959;
 //BA.debugLineNum = 5373959;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=5373960;
 //BA.debugLineNum = 5373960;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=5373962;
 //BA.debugLineNum = 5373962;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=5373964;
 //BA.debugLineNum = 5373964;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Private Sub pik_moon_paeen1_Click";
RDebugUtils.currentLine=5439489;
 //BA.debugLineNum = 5439489;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=5439490;
 //BA.debugLineNum = 5439490;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
RDebugUtils.currentLine=5439492;
 //BA.debugLineNum = 5439492;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=5439493;
 //BA.debugLineNum = 5439493;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=5439495;
 //BA.debugLineNum = 5439495;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=5439496;
 //BA.debugLineNum = 5439496;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=5439498;
 //BA.debugLineNum = 5439498;BA.debugLine="pik_moon1.Text=moon.Get(myfunc.fa2en(pik_moon1.Ta";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
RDebugUtils.currentLine=5439500;
 //BA.debugLineNum = 5439500;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_day1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_day1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=5308416;
 //BA.debugLineNum = 5308416;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
RDebugUtils.currentLine=5308417;
 //BA.debugLineNum = 5308417;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=5308418;
 //BA.debugLineNum = 5308418;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=5308419;
 //BA.debugLineNum = 5308419;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=5308422;
 //BA.debugLineNum = 5308422;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=5308424;
 //BA.debugLineNum = 5308424;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=5308425;
 //BA.debugLineNum = 5308425;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
RDebugUtils.currentLine=5308426;
 //BA.debugLineNum = 5308426;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=5308427;
 //BA.debugLineNum = 5308427;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=5308429;
 //BA.debugLineNum = 5308429;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=5308430;
 //BA.debugLineNum = 5308430;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
RDebugUtils.currentLine=5308431;
 //BA.debugLineNum = 5308431;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=5308432;
 //BA.debugLineNum = 5308432;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=5308435;
 //BA.debugLineNum = 5308435;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=5308436;
 //BA.debugLineNum = 5308436;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=5308437;
 //BA.debugLineNum = 5308437;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=5308439;
 //BA.debugLineNum = 5308439;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=5308440;
 //BA.debugLineNum = 5308440;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=5308443;
 //BA.debugLineNum = 5308443;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=5308444;
 //BA.debugLineNum = 5308444;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=5308446;
 //BA.debugLineNum = 5308446;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=5308447;
 //BA.debugLineNum = 5308447;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=5308451;
 //BA.debugLineNum = 5308451;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 };
RDebugUtils.currentLine=5308454;
 //BA.debugLineNum = 5308454;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_hour1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_hour1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_hour1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Private Sub pik_pan_hour1_Touch (Action As Int, X";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=5046275;
 //BA.debugLineNum = 5046275;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=5046278;
 //BA.debugLineNum = 5046278;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=5046280;
 //BA.debugLineNum = 5046280;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=5046281;
 //BA.debugLineNum = 5046281;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))-1);
RDebugUtils.currentLine=5046282;
 //BA.debugLineNum = 5046282;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=5046283;
 //BA.debugLineNum = 5046283;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=5046285;
 //BA.debugLineNum = 5046285;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=5046286;
 //BA.debugLineNum = 5046286;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))+1);
RDebugUtils.currentLine=5046287;
 //BA.debugLineNum = 5046287;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=5046288;
 //BA.debugLineNum = 5046288;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=5046291;
 //BA.debugLineNum = 5046291;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
RDebugUtils.currentLine=5046292;
 //BA.debugLineNum = 5046292;BA.debugLine="pik_hour1.Text=0";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=5046294;
 //BA.debugLineNum = 5046294;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
RDebugUtils.currentLine=5046295;
 //BA.debugLineNum = 5046295;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
RDebugUtils.currentLine=5046298;
 //BA.debugLineNum = 5046298;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(pik_hour1.Tex";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_hour1.getText())))));
 };
RDebugUtils.currentLine=5046303;
 //BA.debugLineNum = 5046303;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_min1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_min1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_min1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Private Sub pik_pan_min1_Touch (Action As Int, X A";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=5111810;
 //BA.debugLineNum = 5111810;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=5111811;
 //BA.debugLineNum = 5111811;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=5111814;
 //BA.debugLineNum = 5111814;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=5111816;
 //BA.debugLineNum = 5111816;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=5111818;
 //BA.debugLineNum = 5111818;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))-1);
RDebugUtils.currentLine=5111819;
 //BA.debugLineNum = 5111819;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=5111822;
 //BA.debugLineNum = 5111822;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=5111824;
 //BA.debugLineNum = 5111824;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=5111826;
 //BA.debugLineNum = 5111826;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))+1);
RDebugUtils.currentLine=5111827;
 //BA.debugLineNum = 5111827;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=5111830;
 //BA.debugLineNum = 5111830;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=5111834;
 //BA.debugLineNum = 5111834;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
RDebugUtils.currentLine=5111835;
 //BA.debugLineNum = 5111835;BA.debugLine="pik_min1.Text=0";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=5111838;
 //BA.debugLineNum = 5111838;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
RDebugUtils.currentLine=5111839;
 //BA.debugLineNum = 5111839;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
RDebugUtils.currentLine=5111841;
 //BA.debugLineNum = 5111841;BA.debugLine="pik_min1.Text=myfunc.convert_adad(pik_min1.Text)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_min1.getText())))));
 };
RDebugUtils.currentLine=5111847;
 //BA.debugLineNum = 5111847;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_moon1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_moon1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=5177347;
 //BA.debugLineNum = 5177347;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=5177350;
 //BA.debugLineNum = 5177350;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=5177352;
 //BA.debugLineNum = 5177352;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=5177353;
 //BA.debugLineNum = 5177353;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
RDebugUtils.currentLine=5177354;
 //BA.debugLineNum = 5177354;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=5177355;
 //BA.debugLineNum = 5177355;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=5177357;
 //BA.debugLineNum = 5177357;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=5177358;
 //BA.debugLineNum = 5177358;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
RDebugUtils.currentLine=5177359;
 //BA.debugLineNum = 5177359;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=5177360;
 //BA.debugLineNum = 5177360;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=5177363;
 //BA.debugLineNum = 5177363;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=5177364;
 //BA.debugLineNum = 5177364;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=5177366;
 //BA.debugLineNum = 5177366;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=5177367;
 //BA.debugLineNum = 5177367;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=5177369;
 //BA.debugLineNum = 5177369;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
RDebugUtils.currentLine=5177372;
 //BA.debugLineNum = 5177372;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_year1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_year1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=5242883;
 //BA.debugLineNum = 5242883;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=5242886;
 //BA.debugLineNum = 5242886;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=5242888;
 //BA.debugLineNum = 5242888;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=5242889;
 //BA.debugLineNum = 5242889;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
RDebugUtils.currentLine=5242890;
 //BA.debugLineNum = 5242890;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=5242891;
 //BA.debugLineNum = 5242891;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=5242893;
 //BA.debugLineNum = 5242893;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=5242894;
 //BA.debugLineNum = 5242894;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
RDebugUtils.currentLine=5242895;
 //BA.debugLineNum = 5242895;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=5242896;
 //BA.debugLineNum = 5242896;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=5242899;
 //BA.debugLineNum = 5242899;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=5242900;
 //BA.debugLineNum = 5242900;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=5242902;
 //BA.debugLineNum = 5242902;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=5242903;
 //BA.debugLineNum = 5242903;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
RDebugUtils.currentLine=5242908;
 //BA.debugLineNum = 5242908;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=5505024;
 //BA.debugLineNum = 5505024;BA.debugLine="Private Sub pik_year_bala1_Click";
RDebugUtils.currentLine=5505025;
 //BA.debugLineNum = 5505025;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=5505026;
 //BA.debugLineNum = 5505026;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=5505028;
 //BA.debugLineNum = 5505028;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=5505029;
 //BA.debugLineNum = 5505029;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=5505031;
 //BA.debugLineNum = 5505031;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=5505032;
 //BA.debugLineNum = 5505032;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=5505035;
 //BA.debugLineNum = 5505035;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=5570560;
 //BA.debugLineNum = 5570560;BA.debugLine="Private Sub pik_year_paeen1_Click";
RDebugUtils.currentLine=5570561;
 //BA.debugLineNum = 5570561;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=5570562;
 //BA.debugLineNum = 5570562;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=5570564;
 //BA.debugLineNum = 5570564;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=5570565;
 //BA.debugLineNum = 5570565;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=5570567;
 //BA.debugLineNum = 5570567;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=5570568;
 //BA.debugLineNum = 5570568;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=5570571;
 //BA.debugLineNum = 5570571;BA.debugLine="End Sub";
return "";
}
public static String  _poolakey_connectionfailed(ir.cafebazaar.poolakey.b4a.B4AException _error) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "poolakey_connectionfailed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "poolakey_connectionfailed", new Object[] {_error}));}
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Private Sub Poolakey_ConnectionFailed (Error As Po";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Log(\"Service: Failed to Connect\" & CRLF & Error.E";
anywheresoftware.b4a.keywords.Common.LogImpl("6327681","Service: Failed to Connect"+anywheresoftware.b4a.keywords.Common.CRLF+_error.getErrorMessage(),0);
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="MsgboxAsync(\"1- از نصب بودن برنامه بازار اطمینان";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("1- از نصب بودن برنامه بازار اطمینان یابید."+anywheresoftware.b4a.keywords.Common.CRLF+" 2- برنامه ها را ببندید و دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="End Sub";
return "";
}
public static String  _poolakey_connectionsucceed() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "poolakey_connectionsucceed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "poolakey_connectionsucceed", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Private Sub Poolakey_ConnectionSucceed";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="Log(\"Service: Connected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6196609","Service: Connected",0);
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _poolakey_disconnected() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "poolakey_disconnected", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "poolakey_disconnected", null));}
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Private Sub Poolakey_Disconnected";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="Log(\"Service: Not Connected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6262145","Service: Not Connected",0);
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _purchase_purchasecanceled() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "purchase_purchasecanceled", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "purchase_purchasecanceled", null));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Private Sub Purchase_PurchaseCanceled";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Log(\"کاربر کنسل کرد\")";
anywheresoftware.b4a.keywords.Common.LogImpl("61245185","کاربر کنسل کرد",0);
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="End Sub";
return "";
}
public static String  _purchase_purchasefailed(ir.cafebazaar.poolakey.b4a.B4AException _error) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "purchase_purchasefailed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "purchase_purchasefailed", new Object[] {_error}));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Private Sub Purchase_PurchaseFailed (Error As Pool";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="Log(\"کاربر sss کرد\")";
anywheresoftware.b4a.keywords.Common.LogImpl("61310721","کاربر sss کرد",0);
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="End Sub";
return "";
}
public static String  _purchase_purchasefailedtobeginflow(ir.cafebazaar.poolakey.b4a.B4AException _error) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "purchase_purchasefailedtobeginflow", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "purchase_purchasefailedtobeginflow", new Object[] {_error}));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Private Sub Purchase_PurchaseFailedToBeginFlow (Er";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Log(Error)";
anywheresoftware.b4a.keywords.Common.LogImpl("61114113",BA.ObjectToString(_error),0);
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="End Sub";
return "";
}
public static String  _purchase_purchasesucceed(ir.cafebazaar.poolakey.b4a.B4APurchaseInfo _purchaseinfo) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "purchase_purchasesucceed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "purchase_purchasesucceed", new Object[] {_purchaseinfo}));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Private Sub Purchase_PurchaseSucceed (PurchaseInfo";
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="Log(\"p info : \"&PurchaseInfo.PurchaseToken)";
anywheresoftware.b4a.keywords.Common.LogImpl("61179652","p info : "+_purchaseinfo.getPurchaseToken(),0);
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="If PurchaseInfo.ProductId=\"ezafekari2\" Then";
if ((_purchaseinfo.getProductId()).equals("ezafekari2")) { 
RDebugUtils.currentLine=1179658;
 //BA.debugLineNum = 1179658;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\",\"\")";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
RDebugUtils.currentLine=1179659;
 //BA.debugLineNum = 1179659;BA.debugLine="MsgboxAsync(\"پرداخت انجام شده است\",\"انجام شد\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("پرداخت انجام شده است"),BA.ObjectToCharSequence("انجام شد"),processBA);
RDebugUtils.currentLine=1179660;
 //BA.debugLineNum = 1179660;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی ا";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1179665;
 //BA.debugLineNum = 1179665;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
RDebugUtils.currentLine=1179666;
 //BA.debugLineNum = 1179666;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
RDebugUtils.currentLine=1179674;
 //BA.debugLineNum = 1179674;BA.debugLine="End Sub";
return "";
}
public static String  _query_queryfailed(ir.cafebazaar.poolakey.b4a.B4AException _error) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "query_queryfailed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "query_queryfailed", new Object[] {_error}));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub Query_QueryFailed (Error As PoolakeyEx";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="Log(\"Query failed: \" & Error)";
anywheresoftware.b4a.keywords.Common.LogImpl("61441793","Query failed: "+BA.ObjectToString(_error),0);
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="Try";
try {RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="get_request_kharid";
_get_request_kharid();
 } 
       catch (Exception e5) {
			processBA.setLastException(e5);RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("61441797",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=1441799;
 //BA.debugLineNum = 1441799;BA.debugLine="End Sub";
return "";
}
public static String  _query_querysucceed(ir.cafebazaar.poolakey.b4a.B4APurchaseQuery _query) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "query_querysucceed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "query_querysucceed", new Object[] {_query}));}
int _i = 0;
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub Query_QuerySucceed (Query As PoolakeyP";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="Log(\"query: \"&Query)";
anywheresoftware.b4a.keywords.Common.LogImpl("61376257","query: "+BA.ObjectToString(_query),0);
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="If(Query.Size<>0)Then";
if ((_query.getSize()!=0)) { 
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="For i = 0 To Query.Size - 1";
{
final int step3 = 1;
final int limit3 = (int) (_query.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="If (Query.Get(i).ProductId=\"ezafekari2\") Then";
if (((_query.Get(_i).getProductId()).equals("ezafekari2"))) { 
RDebugUtils.currentLine=1376265;
 //BA.debugLineNum = 1376265;BA.debugLine="Try";
try {RDebugUtils.currentLine=1376267;
 //BA.debugLineNum = 1376267;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\",\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
RDebugUtils.currentLine=1376268;
 //BA.debugLineNum = 1376268;BA.debugLine="MsgboxAsync(\"پرداخت انجام شده است\",\"انجام شد\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("پرداخت انجام شده است"),BA.ObjectToCharSequence("انجام شد"),processBA);
RDebugUtils.currentLine=1376269;
 //BA.debugLineNum = 1376269;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376271;
 //BA.debugLineNum = 1376271;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
RDebugUtils.currentLine=1376272;
 //BA.debugLineNum = 1376272;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 } 
       catch (Exception e12) {
			processBA.setLastException(e12);RDebugUtils.currentLine=1376276;
 //BA.debugLineNum = 1376276;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("61376276",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 }else {
RDebugUtils.currentLine=1376281;
 //BA.debugLineNum = 1376281;BA.debugLine="Try";
try {RDebugUtils.currentLine=1376283;
 //BA.debugLineNum = 1376283;BA.debugLine="get_request_kharid";
_get_request_kharid();
 } 
       catch (Exception e18) {
			processBA.setLastException(e18);RDebugUtils.currentLine=1376285;
 //BA.debugLineNum = 1376285;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("61376285",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
 }
};
 }else {
RDebugUtils.currentLine=1376297;
 //BA.debugLineNum = 1376297;BA.debugLine="Try";
try {RDebugUtils.currentLine=1376299;
 //BA.debugLineNum = 1376299;BA.debugLine="get_request_kharid";
_get_request_kharid();
 } 
       catch (Exception e26) {
			processBA.setLastException(e26);RDebugUtils.currentLine=1376301;
 //BA.debugLineNum = 1376301;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("61376301",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
RDebugUtils.currentLine=1376307;
 //BA.debugLineNum = 1376307;BA.debugLine="End Sub";
return "";
}
public static boolean  _rspop_noe_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_noe_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_noe_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub rsPOP_noe_MenuItemClick (ItemId As Int) As Boo";
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="Select ItemId";
switch (_itemid) {
case 0: {
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
RDebugUtils.currentLine=3670022;
 //BA.debugLineNum = 3670022;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
RDebugUtils.currentLine=3670024;
 //BA.debugLineNum = 3670024;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
RDebugUtils.currentLine=3670026;
 //BA.debugLineNum = 3670026;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
RDebugUtils.currentLine=3670030;
 //BA.debugLineNum = 3670030;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
RDebugUtils.currentLine=3670031;
 //BA.debugLineNum = 3670031;BA.debugLine="index_noe_morakhasi=ItemId";
_index_noe_morakhasi = _itemid;
RDebugUtils.currentLine=3670032;
 //BA.debugLineNum = 3670032;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3670033;
 //BA.debugLineNum = 3670033;BA.debugLine="End Sub";
return false;
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_moon_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_moon_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=5832705;
 //BA.debugLineNum = 5832705;BA.debugLine="Dim moon_num As String";
_moon_num = "";
RDebugUtils.currentLine=5832707;
 //BA.debugLineNum = 5832707;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=5832710;
 //BA.debugLineNum = 5832710;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=5832711;
 //BA.debugLineNum = 5832711;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
RDebugUtils.currentLine=5832712;
 //BA.debugLineNum = 5832712;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_gozaresh_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_gozaresh_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_gozaresh_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=8781824;
 //BA.debugLineNum = 8781824;BA.debugLine="Private Sub sp_year_gozaresh_ItemClick (Position A";
RDebugUtils.currentLine=8781825;
 //BA.debugLineNum = 8781825;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
RDebugUtils.currentLine=8781826;
 //BA.debugLineNum = 8781826;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=5767173;
 //BA.debugLineNum = 5767173;BA.debugLine="Dim moon_num As String";
_moon_num = "";
RDebugUtils.currentLine=5767174;
 //BA.debugLineNum = 5767174;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=5767176;
 //BA.debugLineNum = 5767176;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=5767178;
 //BA.debugLineNum = 5767178;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
RDebugUtils.currentLine=5767180;
 //BA.debugLineNum = 5767180;BA.debugLine="End Sub";
return "";
}
public static String  _tatil_hast() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tatil_hast", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tatil_hast", null));}
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub tatil_hast";
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718596;
 //BA.debugLineNum = 4718596;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=True";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718597;
 //BA.debugLineNum = 4718597;BA.debugLine="ckb_ezaf_taradod_fs.Visible=True";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718600;
 //BA.debugLineNum = 4718600;BA.debugLine="radio_ez_adi.Enabled=True";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718601;
 //BA.debugLineNum = 4718601;BA.debugLine="radio_ez_fog.Enabled=True";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718604;
 //BA.debugLineNum = 4718604;BA.debugLine="lbl_ezaf_taradod.Text=\"افزودن به اضافه کاری \"&((m";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("افزودن به اضافه کاری "+BA.ObjectToString(((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_tim_min).Get((int) (0)))))+" ساعت و "+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_tim_min)).Get((int) (1)))+" دقیقه "));
RDebugUtils.currentLine=4718606;
 //BA.debugLineNum = 4718606;BA.debugLine="lbl_ezaf_taradod_fs.Text=lbl_ezaf_taradod.Text";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(mostCurrent._lbl_ezaf_taradod.getText()));
RDebugUtils.currentLine=4718609;
 //BA.debugLineNum = 4718609;BA.debugLine="End Sub";
return "";
}
public static String  _tatil_nist() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tatil_nist", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tatil_nist", null));}
int _min_satkari_inweek = 0;
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub tatil_nist";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="Dim min_satKari_inWeek As Int =myfunc.get_saatKar";
_min_satkari_inweek = mostCurrent._myfunc._get_saatkari_inweek /*int*/ (mostCurrent.activityBA,_day_inweek_id);
RDebugUtils.currentLine=4653059;
 //BA.debugLineNum = 4653059;BA.debugLine="If(tim_min>min_satKari_inWeek) Then";
if ((_tim_min>_min_satkari_inweek)) { 
RDebugUtils.currentLine=4653062;
 //BA.debugLineNum = 4653062;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4653063;
 //BA.debugLineNum = 4653063;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4653064;
 //BA.debugLineNum = 4653064;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=True";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4653065;
 //BA.debugLineNum = 4653065;BA.debugLine="ckb_ezaf_taradod_fs.Visible=True";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4653068;
 //BA.debugLineNum = 4653068;BA.debugLine="radio_ez_adi.Enabled=True";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4653069;
 //BA.debugLineNum = 4653069;BA.debugLine="radio_ez_fog.Enabled=True";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4653072;
 //BA.debugLineNum = 4653072;BA.debugLine="lbl_ezaf_taradod.Text=\"افزودن به اضافه کاری \"&((";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("افزودن به اضافه کاری "+BA.ObjectToString(((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_min_satkari_inweek)).Get((int) (0)))))+" ساعت و "+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_min_satkari_inweek))).Get((int) (1)))+" دقیقه "));
RDebugUtils.currentLine=4653074;
 //BA.debugLineNum = 4653074;BA.debugLine="lbl_ezaf_taradod_fs.Text=lbl_ezaf_taradod.Text";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(mostCurrent._lbl_ezaf_taradod.getText()));
 }else {
RDebugUtils.currentLine=4653077;
 //BA.debugLineNum = 4653077;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4653078;
 //BA.debugLineNum = 4653078;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653079;
 //BA.debugLineNum = 4653079;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653080;
 //BA.debugLineNum = 4653080;BA.debugLine="radio_ez_adi.Enabled=False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653081;
 //BA.debugLineNum = 4653081;BA.debugLine="radio_ez_fog.Enabled=False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653082;
 //BA.debugLineNum = 4653082;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4653083;
 //BA.debugLineNum = 4653083;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653084;
 //BA.debugLineNum = 4653084;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=4653087;
 //BA.debugLineNum = 4653087;BA.debugLine="End Sub";
return "";
}
public static String  _tim_check_update_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_check_update_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_check_update_tick", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub tim_check_update_Tick";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="chk_update_auto";
_chk_update_auto();
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="Log(\"now cheking ....\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6393218","now cheking ....",0);
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="tim_check_update.Enabled=False";
_tim_check_update.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="End Sub";
return "";
}
public static String  _tim_lock_lbl_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_lock_lbl_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_lock_lbl_tick", null));}
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub tim_lock_lbl_Tick";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="If(stat_finger=0)Then";
if ((_stat_finger==0)) { 
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
mostCurrent._lbl_finger.setTextColor(((int)0xff0b6200));
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="stat_finger=1";
_stat_finger = (int) (1);
 }else {
RDebugUtils.currentLine=1638405;
 //BA.debugLineNum = 1638405;BA.debugLine="lbl_finger.TextColor=0xFF2FFF00";
mostCurrent._lbl_finger.setTextColor(((int)0xff2fff00));
RDebugUtils.currentLine=1638406;
 //BA.debugLineNum = 1638406;BA.debugLine="stat_finger=0";
_stat_finger = (int) (0);
 };
RDebugUtils.currentLine=1638408;
 //BA.debugLineNum = 1638408;BA.debugLine="End Sub";
return "";
}
public static String  _tim_msg_newyear_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_msg_newyear_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_msg_newyear_tick", null));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub tim_msg_newYear_Tick";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="pan_all_msgNewYear.Visible=True";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="tim_msg_newYear.Enabled=False";
_tim_msg_newyear.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="End Sub";
return "";
}
public static String  _tim_msg_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_msg_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_msg_tick", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub tim_msg_Tick";
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="ls1.Add(notif_code)";
mostCurrent._ls1.Add((Object)(mostCurrent._notif_code));
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="ls2.Add(notif_matn)";
mostCurrent._ls2.Add((Object)(mostCurrent._notif_matn));
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="ls3.Add(lbl_date_home.Text)";
mostCurrent._ls3.Add((Object)(mostCurrent._lbl_date_home.getText()));
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="File.WriteList(File.DirInternal,\"ls1\",ls1)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1",mostCurrent._ls1);
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="File.WriteList(File.DirInternal,\"ls2\",ls2)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls2",mostCurrent._ls2);
RDebugUtils.currentLine=786441;
 //BA.debugLineNum = 786441;BA.debugLine="File.WriteList(File.DirInternal,\"ls3\",ls3)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls3",mostCurrent._ls3);
RDebugUtils.currentLine=786443;
 //BA.debugLineNum = 786443;BA.debugLine="lbl_title_msgPan.Text=\"پیام جدید\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام جدید"));
RDebugUtils.currentLine=786444;
 //BA.debugLineNum = 786444;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786446;
 //BA.debugLineNum = 786446;BA.debugLine="pan_notif.Top=20%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA));
RDebugUtils.currentLine=786447;
 //BA.debugLineNum = 786447;BA.debugLine="pan_notif.Height=50%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA));
RDebugUtils.currentLine=786448;
 //BA.debugLineNum = 786448;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
RDebugUtils.currentLine=786451;
 //BA.debugLineNum = 786451;BA.debugLine="web_msg_show.LoadHtml(\"<!DOCTYPE html><html><meta";
mostCurrent._web_msg_show.LoadHtml("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'><div style='background-color: #99ffff; font-size: 14px;'>"+"کد پیام : "+mostCurrent._notif_code+" - مورخ : "+mostCurrent._lbl_date_home.getText()+"</div><div style='background-color: #e6ffff; font-size: 18px;'><br>"+mostCurrent._notif_matn+"<br></div><br></body></html>");
RDebugUtils.currentLine=786453;
 //BA.debugLineNum = 786453;BA.debugLine="tim_msg.Enabled=False";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786454;
 //BA.debugLineNum = 786454;BA.debugLine="End Sub";
return "";
}
public static int  _tim_vorod_conv_ezaf(String _tim1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_vorod_conv_ezaf", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "tim_vorod_conv_ezaf", new Object[] {_tim1}));}
String[] _ste_tim = null;
RDebugUtils.currentLine=8978432;
 //BA.debugLineNum = 8978432;BA.debugLine="Sub tim_vorod_conv_ezaf (tim1 As String) As Int";
RDebugUtils.currentLine=8978434;
 //BA.debugLineNum = 8978434;BA.debugLine="Dim ste_tim() As String";
_ste_tim = new String[(int) (0)];
java.util.Arrays.fill(_ste_tim,"");
RDebugUtils.currentLine=8978435;
 //BA.debugLineNum = 8978435;BA.debugLine="ste_tim=Regex.Split(\":\",tim1)";
_ste_tim = anywheresoftware.b4a.keywords.Common.Regex.Split(":",_tim1);
RDebugUtils.currentLine=8978438;
 //BA.debugLineNum = 8978438;BA.debugLine="Return (ste_tim(0)*60)+ste_tim(1) +saat_kar_min";
if (true) return (int) (((double)(Double.parseDouble(_ste_tim[(int) (0)]))*60)+(double)(Double.parseDouble(_ste_tim[(int) (1)]))+_saat_kar_min);
RDebugUtils.currentLine=8978441;
 //BA.debugLineNum = 8978441;BA.debugLine="End Sub";
return 0;
}
public static String  _time_show_2() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time_show_2", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "time_show_2", null));}
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
RDebugUtils.currentLine=66322432;
 //BA.debugLineNum = 66322432;BA.debugLine="Sub time_show_2";
RDebugUtils.currentLine=66322434;
 //BA.debugLineNum = 66322434;BA.debugLine="Try";
try {RDebugUtils.currentLine=66322437;
 //BA.debugLineNum = 66322437;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=66322438;
 //BA.debugLineNum = 66322438;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=66322439;
 //BA.debugLineNum = 66322439;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
RDebugUtils.currentLine=66322440;
 //BA.debugLineNum = 66322440;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
RDebugUtils.currentLine=66322442;
 //BA.debugLineNum = 66322442;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=66322443;
 //BA.debugLineNum = 66322443;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=66322444;
 //BA.debugLineNum = 66322444;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=66322445;
 //BA.debugLineNum = 66322445;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=66322448;
 //BA.debugLineNum = 66322448;BA.debugLine="pik_moon1.Tag=myfunc.convert_adad(pik_moon1.Tag)";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))));
RDebugUtils.currentLine=66322453;
 //BA.debugLineNum = 66322453;BA.debugLine="date1=lbl_date1.Text";
mostCurrent._date1 = mostCurrent._lbl_date1.getText();
RDebugUtils.currentLine=66322454;
 //BA.debugLineNum = 66322454;BA.debugLine="date2=lbl_date2.Text";
mostCurrent._date2 = mostCurrent._lbl_date2.getText();
RDebugUtils.currentLine=66322455;
 //BA.debugLineNum = 66322455;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
RDebugUtils.currentLine=66322456;
 //BA.debugLineNum = 66322456;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
RDebugUtils.currentLine=66322460;
 //BA.debugLineNum = 66322460;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_dat";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=66322461;
 //BA.debugLineNum = 66322461;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_dat";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=66322464;
 //BA.debugLineNum = 66322464;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=66322465;
 //BA.debugLineNum = 66322465;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=66322468;
 //BA.debugLineNum = 66322468;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
RDebugUtils.currentLine=66322469;
 //BA.debugLineNum = 66322469;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
RDebugUtils.currentLine=66322471;
 //BA.debugLineNum = 66322471;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date_";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=66322472;
 //BA.debugLineNum = 66322472;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date_";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=66322474;
 //BA.debugLineNum = 66322474;BA.debugLine="time_end2=lbl_tim2.Text&\":00\"";
_time_end2 = mostCurrent._lbl_tim2.getText()+":00";
RDebugUtils.currentLine=66322475;
 //BA.debugLineNum = 66322475;BA.debugLine="time_end1=lbl_tim1.Text&\":00\"";
_time_end1 = mostCurrent._lbl_tim1.getText()+":00";
RDebugUtils.currentLine=66322477;
 //BA.debugLineNum = 66322477;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
RDebugUtils.currentLine=66322478;
 //BA.debugLineNum = 66322478;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
RDebugUtils.currentLine=66322479;
 //BA.debugLineNum = 66322479;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
RDebugUtils.currentLine=66322480;
 //BA.debugLineNum = 66322480;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
RDebugUtils.currentLine=66322484;
 //BA.debugLineNum = 66322484;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
RDebugUtils.currentLine=66322485;
 //BA.debugLineNum = 66322485;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
RDebugUtils.currentLine=66322488;
 //BA.debugLineNum = 66322488;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=66322489;
 //BA.debugLineNum = 66322489;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
RDebugUtils.currentLine=66322491;
 //BA.debugLineNum = 66322491;BA.debugLine="If (period_between.Years<>0)Then";
if ((_period_between.Years!=0)) { 
RDebugUtils.currentLine=66322492;
 //BA.debugLineNum = 66322492;BA.debugLine="str_show.Append(period_between.Years&\" سال \").A";
_str_show.Append(BA.NumberToString(_period_between.Years)+" سال ").Append(" و ");
 };
RDebugUtils.currentLine=66322494;
 //BA.debugLineNum = 66322494;BA.debugLine="If (period_between.Months<>0)Then";
if ((_period_between.Months!=0)) { 
RDebugUtils.currentLine=66322495;
 //BA.debugLineNum = 66322495;BA.debugLine="str_show.Append(period_between.Months&\" ماه \").";
_str_show.Append(BA.NumberToString(_period_between.Months)+" ماه ").Append(" و ");
 };
RDebugUtils.currentLine=66322497;
 //BA.debugLineNum = 66322497;BA.debugLine="If (period_between.Days<>0)Then";
if ((_period_between.Days!=0)) { 
RDebugUtils.currentLine=66322498;
 //BA.debugLineNum = 66322498;BA.debugLine="str_show.Append(period_between.Days&\" روز \").Ap";
_str_show.Append(BA.NumberToString(_period_between.Days)+" روز ").Append(" و ");
 };
RDebugUtils.currentLine=66322501;
 //BA.debugLineNum = 66322501;BA.debugLine="str_show.Append(period_between.Hours&\" ساعت \").A";
_str_show.Append(BA.NumberToString(_period_between.Hours)+" ساعت ").Append(" و ");
RDebugUtils.currentLine=66322502;
 //BA.debugLineNum = 66322502;BA.debugLine="str_show.Append(period_between.Minutes&\" دقیقه \"";
_str_show.Append(BA.NumberToString(_period_between.Minutes)+" دقیقه ");
RDebugUtils.currentLine=66322505;
 //BA.debugLineNum = 66322505;BA.debugLine="year_bt=period_between.Years";
_year_bt = _period_between.Years;
RDebugUtils.currentLine=66322506;
 //BA.debugLineNum = 66322506;BA.debugLine="moon_bt=period_between.Months";
_moon_bt = _period_between.Months;
RDebugUtils.currentLine=66322507;
 //BA.debugLineNum = 66322507;BA.debugLine="day_bt=period_between.Days";
_day_bt = _period_between.Days;
RDebugUtils.currentLine=66322508;
 //BA.debugLineNum = 66322508;BA.debugLine="hour_bt=period_between.Hours";
_hour_bt = _period_between.Hours;
RDebugUtils.currentLine=66322509;
 //BA.debugLineNum = 66322509;BA.debugLine="min_bt=period_between.Minutes";
_min_bt = _period_between.Minutes;
RDebugUtils.currentLine=66322512;
 //BA.debugLineNum = 66322512;BA.debugLine="lbl_time_show.Text=str_show";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(_str_show.getObject()));
RDebugUtils.currentLine=66322513;
 //BA.debugLineNum = 66322513;BA.debugLine="lbl_time_show_fs.Text=lbl_time_show.Text";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(mostCurrent._lbl_time_show.getText()));
RDebugUtils.currentLine=66322515;
 //BA.debugLineNum = 66322515;BA.debugLine="If(index_box=3)Then";
if ((_index_box==3)) { 
RDebugUtils.currentLine=66322519;
 //BA.debugLineNum = 66322519;BA.debugLine="tim_min=(day_bt*24*60)+(hour_bt*60)+min_bt";
_tim_min = (int) ((_day_bt*24*60)+(_hour_bt*60)+_min_bt);
RDebugUtils.currentLine=66322522;
 //BA.debugLineNum = 66322522;BA.debugLine="Select state_tatil_setting";
switch (_state_tatil_setting) {
case 0: {
RDebugUtils.currentLine=66322525;
 //BA.debugLineNum = 66322525;BA.debugLine="tatil_nist";
_tatil_nist();
 break; }
case 1: {
RDebugUtils.currentLine=66322528;
 //BA.debugLineNum = 66322528;BA.debugLine="If (state_tatil=1 Or state_tatil=2 ) Then 'ta";
if ((_state_tatil==1 || _state_tatil==2)) { 
RDebugUtils.currentLine=66322529;
 //BA.debugLineNum = 66322529;BA.debugLine="tatil_hast";
_tatil_hast();
 }else {
RDebugUtils.currentLine=66322531;
 //BA.debugLineNum = 66322531;BA.debugLine="tatil_nist";
_tatil_nist();
 };
 break; }
case 11: {
RDebugUtils.currentLine=66322535;
 //BA.debugLineNum = 66322535;BA.debugLine="If (state_tatil=1 ) Then 'tatil rasmi";
if ((_state_tatil==1)) { 
RDebugUtils.currentLine=66322536;
 //BA.debugLineNum = 66322536;BA.debugLine="tatil_hast";
_tatil_hast();
 }else {
RDebugUtils.currentLine=66322538;
 //BA.debugLineNum = 66322538;BA.debugLine="tatil_nist";
_tatil_nist();
 };
 break; }
case 22: {
RDebugUtils.currentLine=66322543;
 //BA.debugLineNum = 66322543;BA.debugLine="If (state_tatil=2 ) Then  'tatil garardadi";
if ((_state_tatil==2)) { 
RDebugUtils.currentLine=66322544;
 //BA.debugLineNum = 66322544;BA.debugLine="tatil_hast";
_tatil_hast();
 }else {
RDebugUtils.currentLine=66322546;
 //BA.debugLineNum = 66322546;BA.debugLine="tatil_nist";
_tatil_nist();
 };
 break; }
}
;
RDebugUtils.currentLine=66322553;
 //BA.debugLineNum = 66322553;BA.debugLine="If(is_for_edit=True)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=66322554;
 //BA.debugLineNum = 66322554;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=66322555;
 //BA.debugLineNum = 66322555;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=66322556;
 //BA.debugLineNum = 66322556;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=66322557;
 //BA.debugLineNum = 66322557;BA.debugLine="radio_ez_adi.Enabled=False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=66322558;
 //BA.debugLineNum = 66322558;BA.debugLine="radio_ez_fog.Enabled=False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=66322559;
 //BA.debugLineNum = 66322559;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=66322560;
 //BA.debugLineNum = 66322560;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=66322561;
 //BA.debugLineNum = 66322561;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 } 
       catch (Exception e87) {
			processBA.setLastException(e87);RDebugUtils.currentLine=66322568;
 //BA.debugLineNum = 66322568;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=66322574;
 //BA.debugLineNum = 66322574;BA.debugLine="End Sub";
return "";
}
public static String  _timer1_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "timer1_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "timer1_tick", null));}
anywheresoftware.b4a.objects.collections.List _ls_lock0 = null;
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub timer1_Tick";
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="timer1.Enabled=False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="cv_loader.Hide";
mostCurrent._cv_loader._hide /*String*/ (null);
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="ScrollView_sett_taradod.Panel.LoadLayout(\"item_se";
mostCurrent._scrollview_sett_taradod.getPanel().LoadLayout("item_settingTaradod_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=1572877;
 //BA.debugLineNum = 1572877;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=True)T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=1572878;
 //BA.debugLineNum = 1572878;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1572879;
 //BA.debugLineNum = 1572879;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
RDebugUtils.currentLine=1572880;
 //BA.debugLineNum = 1572880;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_lock";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
RDebugUtils.currentLine=1572882;
 //BA.debugLineNum = 1572882;BA.debugLine="If(ls_lock0.Get(0)=\"true\")Then";
if (((_ls_lock0.Get((int) (0))).equals((Object)("true")))) { 
RDebugUtils.currentLine=1572883;
 //BA.debugLineNum = 1572883;BA.debugLine="Master_Password=ls_lock0.Get(2)";
mostCurrent._master_password = BA.ObjectToString(_ls_lock0.Get((int) (2)));
RDebugUtils.currentLine=1572884;
 //BA.debugLineNum = 1572884;BA.debugLine="pan_lock.Visible=True";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1572885;
 //BA.debugLineNum = 1572885;BA.debugLine="lbl_hint_lock.Text=ls_lock0.Get(3)";
mostCurrent._lbl_hint_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (3))));
RDebugUtils.currentLine=1572887;
 //BA.debugLineNum = 1572887;BA.debugLine="If(ls_lock0.Get(1)=\"true\")Then";
if (((_ls_lock0.Get((int) (1))).equals((Object)("true")))) { 
RDebugUtils.currentLine=1572889;
 //BA.debugLineNum = 1572889;BA.debugLine="tim_lock_lbl.Initialize(\"tim_lock_lbl\",500)";
_tim_lock_lbl.Initialize(processBA,"tim_lock_lbl",(long) (500));
RDebugUtils.currentLine=1572890;
 //BA.debugLineNum = 1572890;BA.debugLine="Try";
try {RDebugUtils.currentLine=1572891;
 //BA.debugLineNum = 1572891;BA.debugLine="fingerprint.Initialize (Me, \"auth\")";
mostCurrent._fingerprint._initialize /*String*/ (null,processBA,main.getObject(),"auth");
RDebugUtils.currentLine=1572894;
 //BA.debugLineNum = 1572894;BA.debugLine="If fingerprint.HardwareDetected = False Then";
if (mostCurrent._fingerprint._gethardwaredetected /*boolean*/ (null)==anywheresoftware.b4a.keywords.Common.False) { 
 }else 
{RDebugUtils.currentLine=1572897;
 //BA.debugLineNum = 1572897;BA.debugLine="Else if fingerprint.HasEnrolledFingerprints =";
if (mostCurrent._fingerprint._gethasenrolledfingerprints /*boolean*/ (null)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1572898;
 //BA.debugLineNum = 1572898;BA.debugLine="ToastMessageShow(\"اثر انگشت تعریف نشده است\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اثر انگشت تعریف نشده است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=1572900;
 //BA.debugLineNum = 1572900;BA.debugLine="lbl_finger.Visible=True";
mostCurrent._lbl_finger.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1572901;
 //BA.debugLineNum = 1572901;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
mostCurrent._lbl_finger.setTextColor(((int)0xff0b6200));
RDebugUtils.currentLine=1572902;
 //BA.debugLineNum = 1572902;BA.debugLine="finger_scaning";
_finger_scaning();
RDebugUtils.currentLine=1572903;
 //BA.debugLineNum = 1572903;BA.debugLine="tim_lock_lbl.Enabled=True";
_tim_lock_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }}
;
 } 
       catch (Exception e28) {
			processBA.setLastException(e28);RDebugUtils.currentLine=1572907;
 //BA.debugLineNum = 1572907;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("61572907",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
 };
 }else {
RDebugUtils.currentLine=1572914;
 //BA.debugLineNum = 1572914;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=1572921;
 //BA.debugLineNum = 1572921;BA.debugLine="End Sub";
return "";
}
}