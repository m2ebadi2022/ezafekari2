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
anywheresoftware.b4a.keywords.Common.LogImpl("3131091",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
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
RDebugUtils.currentLine=41549824;
 //BA.debugLineNum = 41549824;BA.debugLine="Private Sub btn_menu_home_Click";
RDebugUtils.currentLine=41549825;
 //BA.debugLineNum = 41549825;BA.debugLine="index_page=1";
_index_page = (int) (1);
RDebugUtils.currentLine=41549826;
 //BA.debugLineNum = 41549826;BA.debugLine="pan_imag.Background=img1";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img1.getObject()));
RDebugUtils.currentLine=41549828;
 //BA.debugLineNum = 41549828;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
RDebugUtils.currentLine=41549830;
 //BA.debugLineNum = 41549830;BA.debugLine="pan_main.LoadLayout(\"home_layout\")";
mostCurrent._pan_main.LoadLayout("home_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=41549831;
 //BA.debugLineNum = 41549831;BA.debugLine="scv_home_item.Panel.LoadLayout(\"home_item\")";
mostCurrent._scv_home_item.getPanel().LoadLayout("home_item",mostCurrent.activityBA);
RDebugUtils.currentLine=41549836;
 //BA.debugLineNum = 41549836;BA.debugLine="lbl_date_home.Text=myfunc.fa2en(persianDate.Persi";
mostCurrent._lbl_date_home.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianLongDate())));
RDebugUtils.currentLine=41549838;
 //BA.debugLineNum = 41549838;BA.debugLine="saat_kar_min =dbCode.get_setting_byName(\"saat_kar";
_saat_kar_min = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_darRoz")));
RDebugUtils.currentLine=41549840;
 //BA.debugLineNum = 41549840;BA.debugLine="If(saat_kar_min<18)Then";
if ((_saat_kar_min<18)) { 
RDebugUtils.currentLine=41549841;
 //BA.debugLineNum = 41549841;BA.debugLine="myfunc.help_man(\"توجه\",\"لطفا ساعت کاری خود را در";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","لطفا ساعت کاری خود را در صفحه ثبت اطلاعات حقوق تنظیم کنید");
 };
RDebugUtils.currentLine=41549844;
 //BA.debugLineNum = 41549844;BA.debugLine="Dim list_ezafekari As List";
_list_ezafekari = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=41549845;
 //BA.debugLineNum = 41549845;BA.debugLine="list_ezafekari.Initialize";
_list_ezafekari.Initialize();
RDebugUtils.currentLine=41549847;
 //BA.debugLineNum = 41549847;BA.debugLine="year_num=myfunc.fa2en(persianDate.PersianYear)";
_year_num = mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()));
RDebugUtils.currentLine=41549849;
 //BA.debugLineNum = 41549849;BA.debugLine="moon_num=myfunc.convert_adad(persianDate.PersianM";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_persiandate.getPersianMonth());
RDebugUtils.currentLine=41549851;
 //BA.debugLineNum = 41549851;BA.debugLine="list_ezafekari=dbCode.all_ezafekari_mah(year_num,";
_list_ezafekari = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num,(int) (1));
RDebugUtils.currentLine=41549857;
 //BA.debugLineNum = 41549857;BA.debugLine="Dim list_morakhasi As List";
_list_morakhasi = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=41549858;
 //BA.debugLineNum = 41549858;BA.debugLine="list_morakhasi.Initialize";
_list_morakhasi.Initialize();
RDebugUtils.currentLine=41549860;
 //BA.debugLineNum = 41549860;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(year_num,";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num);
RDebugUtils.currentLine=41549863;
 //BA.debugLineNum = 41549863;BA.debugLine="lbl_ezafekari_mah_m.Text=list_ezafekari.Get(1)&\"";
mostCurrent._lbl_ezafekari_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (1)))+" دقیقه "));
RDebugUtils.currentLine=41549864;
 //BA.debugLineNum = 41549864;BA.debugLine="lbl_ezafekari_mah_h.Text=list_ezafekari.Get(0)&\"";
mostCurrent._lbl_ezafekari_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (0)))+" ساعت "));
RDebugUtils.currentLine=41549866;
 //BA.debugLineNum = 41549866;BA.debugLine="lbl_morakhasi_mah_m.Text=list_morakhasi.Get(2)&\"";
mostCurrent._lbl_morakhasi_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (2)))+" دقیقه "));
RDebugUtils.currentLine=41549867;
 //BA.debugLineNum = 41549867;BA.debugLine="lbl_morakhasi_mah_h.Text=list_morakhasi.Get(1)&\"";
mostCurrent._lbl_morakhasi_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (1)))+" ساعت "));
RDebugUtils.currentLine=41549868;
 //BA.debugLineNum = 41549868;BA.debugLine="lbl_morakhasi_mah_d.Text=list_morakhasi.Get(0)&\"";
mostCurrent._lbl_morakhasi_mah_d.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (0)))+" روز "));
RDebugUtils.currentLine=41549870;
 //BA.debugLineNum = 41549870;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=41549872;
 //BA.debugLineNum = 41549872;BA.debugLine="lbl_vip.TextColor=0xFFFFD800";
mostCurrent._lbl_vip.setTextColor(((int)0xffffd800));
RDebugUtils.currentLine=41549873;
 //BA.debugLineNum = 41549873;BA.debugLine="lbl_vip2.Text=\"نسخه طلایی\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه طلایی"));
 }else {
RDebugUtils.currentLine=41549876;
 //BA.debugLineNum = 41549876;BA.debugLine="lbl_vip.TextColor=Colors.Green";
mostCurrent._lbl_vip.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=41549877;
 //BA.debugLineNum = 41549877;BA.debugLine="lbl_vip2.Text=\"نسخه هدیه\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه هدیه"));
 };
RDebugUtils.currentLine=41549882;
 //BA.debugLineNum = 41549882;BA.debugLine="If (File.Exists(File.DirInternal,\"help_start\")=Fa";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=41549883;
 //BA.debugLineNum = 41549883;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=41549884;
 //BA.debugLineNum = 41549884;BA.debugLine="File.WriteString(File.DirInternal,\"help_start\",\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start","");
 };
RDebugUtils.currentLine=41549890;
 //BA.debugLineNum = 41549890;BA.debugLine="If (File.Exists(File.DirInternal,\"setcolor.txt\"))";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt"))) { 
RDebugUtils.currentLine=41549891;
 //BA.debugLineNum = 41549891;BA.debugLine="Dim list_color As List";
_list_color = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=41549892;
 //BA.debugLineNum = 41549892;BA.debugLine="list_color.Initialize";
_list_color.Initialize();
RDebugUtils.currentLine=41549893;
 //BA.debugLineNum = 41549893;BA.debugLine="list_color = File.ReadList(File.DirInternal,\"set";
_list_color = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt");
RDebugUtils.currentLine=41549895;
 //BA.debugLineNum = 41549895;BA.debugLine="Dim col As List";
_col = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=41549896;
 //BA.debugLineNum = 41549896;BA.debugLine="col.Initialize";
_col.Initialize();
RDebugUtils.currentLine=41549898;
 //BA.debugLineNum = 41549898;BA.debugLine="Dim col_font As List";
_col_font = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=41549899;
 //BA.debugLineNum = 41549899;BA.debugLine="col_font.Initialize";
_col_font.Initialize();
RDebugUtils.currentLine=41549901;
 //BA.debugLineNum = 41549901;BA.debugLine="col=Regex.Split(\",\",list_color.Get(0))";
_col = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (0)))));
RDebugUtils.currentLine=41549902;
 //BA.debugLineNum = 41549902;BA.debugLine="col_font=Regex.Split(\",\",list_color.Get(1))";
_col_font = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (1)))));
RDebugUtils.currentLine=41549906;
 //BA.debugLineNum = 41549906;BA.debugLine="color1= col.Get(0)";
_color1 = (int)(BA.ObjectToNumber(_col.Get((int) (0))));
RDebugUtils.currentLine=41549907;
 //BA.debugLineNum = 41549907;BA.debugLine="color2= col.Get(1)";
_color2 = (int)(BA.ObjectToNumber(_col.Get((int) (1))));
RDebugUtils.currentLine=41549908;
 //BA.debugLineNum = 41549908;BA.debugLine="color_index=col.Get(2)  'index color";
_color_index = (int)(BA.ObjectToNumber(_col.Get((int) (2))));
RDebugUtils.currentLine=41549909;
 //BA.debugLineNum = 41549909;BA.debugLine="color3= col.Get(3)";
_color3 = (int)(BA.ObjectToNumber(_col.Get((int) (3))));
RDebugUtils.currentLine=41549910;
 //BA.debugLineNum = 41549910;BA.debugLine="color4= col.Get(4)";
_color4 = (int)(BA.ObjectToNumber(_col.Get((int) (4))));
RDebugUtils.currentLine=41549911;
 //BA.debugLineNum = 41549911;BA.debugLine="color5= col.Get(5)";
_color5 = (int)(BA.ObjectToNumber(_col.Get((int) (5))));
RDebugUtils.currentLine=41549913;
 //BA.debugLineNum = 41549913;BA.debugLine="main_font=col_font.Get(0)";
_main_font = BA.ObjectToString(_col_font.Get((int) (0)));
RDebugUtils.currentLine=41549914;
 //BA.debugLineNum = 41549914;BA.debugLine="size_f1=col_font.Get(1)";
_size_f1 = (int)(BA.ObjectToNumber(_col_font.Get((int) (1))));
RDebugUtils.currentLine=41549915;
 //BA.debugLineNum = 41549915;BA.debugLine="size_f2=col_font.Get(2)";
_size_f2 = (int)(BA.ObjectToNumber(_col_font.Get((int) (2))));
RDebugUtils.currentLine=41549916;
 //BA.debugLineNum = 41549916;BA.debugLine="size_f3=col_font.Get(3)";
_size_f3 = (int)(BA.ObjectToNumber(_col_font.Get((int) (3))));
 }else {
RDebugUtils.currentLine=41549920;
 //BA.debugLineNum = 41549920;BA.debugLine="color_index=1";
_color_index = (int) (1);
RDebugUtils.currentLine=41549921;
 //BA.debugLineNum = 41549921;BA.debugLine="color1= 0XFF69AC00";
_color1 = ((int)0xff69ac00);
RDebugUtils.currentLine=41549922;
 //BA.debugLineNum = 41549922;BA.debugLine="color2= 0xFF00C7C7";
_color2 = ((int)0xff00c7c7);
RDebugUtils.currentLine=41549923;
 //BA.debugLineNum = 41549923;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=41549924;
 //BA.debugLineNum = 41549924;BA.debugLine="color4=0XFF69AC00";
_color4 = ((int)0xff69ac00);
RDebugUtils.currentLine=41549925;
 //BA.debugLineNum = 41549925;BA.debugLine="color5=0XFF69AC00";
_color5 = ((int)0xff69ac00);
RDebugUtils.currentLine=41549927;
 //BA.debugLineNum = 41549927;BA.debugLine="main_font=\"یکان\"";
_main_font = "یکان";
RDebugUtils.currentLine=41549928;
 //BA.debugLineNum = 41549928;BA.debugLine="size_f1=17";
_size_f1 = (int) (17);
RDebugUtils.currentLine=41549929;
 //BA.debugLineNum = 41549929;BA.debugLine="size_f2=15";
_size_f2 = (int) (15);
RDebugUtils.currentLine=41549930;
 //BA.debugLineNum = 41549930;BA.debugLine="size_f3=13";
_size_f3 = (int) (13);
RDebugUtils.currentLine=41549933;
 //BA.debugLineNum = 41549933;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(_color1)+","+BA.NumberToString(_color2)+","+BA.NumberToString(_color_index)+","+BA.NumberToString(_color3)+","+BA.NumberToString(_color4)+","+BA.NumberToString(_color5)+anywheresoftware.b4a.keywords.Common.CRLF+_main_font+","+BA.NumberToString(_size_f1)+","+BA.NumberToString(_size_f2)+","+BA.NumberToString(_size_f3));
 };
RDebugUtils.currentLine=41549941;
 //BA.debugLineNum = 41549941;BA.debugLine="Dim dw As GradientDrawable";
_dw = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=41549942;
 //BA.debugLineNum = 41549942;BA.debugLine="Dim clr() As Int = Array  As Int(color1,color2)";
_clr = new int[]{_color1,_color2};
RDebugUtils.currentLine=41549943;
 //BA.debugLineNum = 41549943;BA.debugLine="dw.Initialize(\"TOP_BOTTOM\",clr)";
_dw.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clr);
RDebugUtils.currentLine=41549944;
 //BA.debugLineNum = 41549944;BA.debugLine="dw.CornerRadius=50dip";
_dw.setCornerRadius((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))));
RDebugUtils.currentLine=41549945;
 //BA.debugLineNum = 41549945;BA.debugLine="Panel1.Background=dw";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_dw.getObject()));
RDebugUtils.currentLine=41549953;
 //BA.debugLineNum = 41549953;BA.debugLine="lbl_box_title.Color=color4";
mostCurrent._lbl_box_title.setColor(_color4);
RDebugUtils.currentLine=41549962;
 //BA.debugLineNum = 41549962;BA.debugLine="get_today_shift";
_get_today_shift();
RDebugUtils.currentLine=41549969;
 //BA.debugLineNum = 41549969;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=41549972;
 //BA.debugLineNum = 41549972;BA.debugLine="If(is_first_time=True)Then";
if ((_is_first_time==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=41549973;
 //BA.debugLineNum = 41549973;BA.debugLine="chek_time_backup";
_chek_time_backup();
 };
RDebugUtils.currentLine=41549977;
 //BA.debugLineNum = 41549977;BA.debugLine="If(is_new_msg=True And is_first_time=True)Then";
if ((_is_new_msg==anywheresoftware.b4a.keywords.Common.True && _is_first_time==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=41549978;
 //BA.debugLineNum = 41549978;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=41549979;
 //BA.debugLineNum = 41549979;BA.debugLine="result = Msgbox2(\"آیا الان مشاهده میکنید؟\", \"پیا";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا الان مشاهده میکنید؟"),BA.ObjectToCharSequence("پیام جدید"),"بله","بعدا","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"notif.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=41549980;
 //BA.debugLineNum = 41549980;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=41549981;
 //BA.debugLineNum = 41549981;BA.debugLine="lbl_account_Click";
_lbl_account_click();
RDebugUtils.currentLine=41549982;
 //BA.debugLineNum = 41549982;BA.debugLine="msg_page_show=1";
_msg_page_show = (int) (1);
 };
RDebugUtils.currentLine=41549984;
 //BA.debugLineNum = 41549984;BA.debugLine="is_first_time=False";
_is_first_time = anywheresoftware.b4a.keywords.Common.False;
 }else 
{RDebugUtils.currentLine=41549985;
 //BA.debugLineNum = 41549985;BA.debugLine="else If(is_time_backup=True And is_first_time=Tru";
if ((_is_time_backup==anywheresoftware.b4a.keywords.Common.True && _is_first_time==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=41549986;
 //BA.debugLineNum = 41549986;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=41549987;
 //BA.debugLineNum = 41549987;BA.debugLine="result = Msgbox2(\"پشتیبان گیری از داده ها انجام";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("پشتیبان گیری از داده ها انجام گردد؟"),BA.ObjectToCharSequence("یاد آور پشتیبان گیری"),"بله","بعدا","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"notif.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=41549988;
 //BA.debugLineNum = 41549988;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=41549989;
 //BA.debugLineNum = 41549989;BA.debugLine="lbl_account_Click";
_lbl_account_click();
RDebugUtils.currentLine=41549990;
 //BA.debugLineNum = 41549990;BA.debugLine="backup_page_show=1";
_backup_page_show = (int) (1);
 };
RDebugUtils.currentLine=41549993;
 //BA.debugLineNum = 41549993;BA.debugLine="is_first_time=False";
_is_first_time = anywheresoftware.b4a.keywords.Common.False;
 }}
;
RDebugUtils.currentLine=41550000;
 //BA.debugLineNum = 41550000;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip_click", null));}
RDebugUtils.currentLine=45875200;
 //BA.debugLineNum = 45875200;BA.debugLine="Private Sub lbl_vip_Click";
RDebugUtils.currentLine=45875202;
 //BA.debugLineNum = 45875202;BA.debugLine="pan_all_noskhe.Visible=True";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=45875203;
 //BA.debugLineNum = 45875203;BA.debugLine="scroll_v_noskhe.Panel.LoadLayout(\"noske_item\")";
mostCurrent._scroll_v_noskhe.getPanel().LoadLayout("noske_item",mostCurrent.activityBA);
RDebugUtils.currentLine=45875206;
 //BA.debugLineNum = 45875206;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=45875207;
 //BA.debugLineNum = 45875207;BA.debugLine="lbl_show_vip.Text=\"نسخه کامل ( طلایی ) فعال می ب";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه کامل ( طلایی ) فعال می باشد."));
 }else {
RDebugUtils.currentLine=45875209;
 //BA.debugLineNum = 45875209;BA.debugLine="lbl_show_vip.Text=\"نسخه معمولی ( هدیه ) فعال می";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه معمولی ( هدیه ) فعال می باشد."));
 };
RDebugUtils.currentLine=45875212;
 //BA.debugLineNum = 45875212;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "http_initial_1", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "http_initial_1", new Object[] {_type1}));}
String _send = "";
RDebugUtils.currentLine=39583744;
 //BA.debugLineNum = 39583744;BA.debugLine="Sub http_initial_1(type1 As Int)";
RDebugUtils.currentLine=39583745;
 //BA.debugLineNum = 39583745;BA.debugLine="ht.Initialize(\"ht\",Me)";
mostCurrent._ht._initialize /*String*/ (null,processBA,"ht",main.getObject());
RDebugUtils.currentLine=39583746;
 //BA.debugLineNum = 39583746;BA.debugLine="Dim send As String";
_send = "";
RDebugUtils.currentLine=39583747;
 //BA.debugLineNum = 39583747;BA.debugLine="send = \"username=mahdisend&password=123pass456&di";
_send = "username=mahdisend&password=123pass456&div_id="+_phon.GetSettings("android_id")+"&sdk_ver="+BA.NumberToString(_phon.getSdkVersion())+"&oprator="+_phon.GetNetworkOperatorName()+"&type_app="+BA.NumberToString(_type1)+"&div_model="+_phon.getModel()+"&last_notif="+mostCurrent._last_notif+"	&is_now_instal="+BA.ObjectToString(_is_now_instal)+"&version_code="+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Application.getVersionCode());
RDebugUtils.currentLine=39583748;
 //BA.debugLineNum = 39583748;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/ezafekari2";
mostCurrent._ht._poststring /*String*/ (null,"https://taravatgroup.ir/ezafekari2_new.php",_send);
RDebugUtils.currentLine=39583749;
 //BA.debugLineNum = 39583749;BA.debugLine="Log(\"ht sended\")";
anywheresoftware.b4a.keywords.Common.LogImpl("339583749","ht sended",0);
RDebugUtils.currentLine=39583751;
 //BA.debugLineNum = 39583751;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
int _result = 0;
RDebugUtils.currentLine=43319296;
 //BA.debugLineNum = 43319296;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=43319297;
 //BA.debugLineNum = 43319297;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=43319298;
 //BA.debugLineNum = 43319298;BA.debugLine="If (pan_all_msgNewYear.Visible=True)Then";
if ((mostCurrent._pan_all_msgnewyear.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43319299;
 //BA.debugLineNum = 43319299;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=43319301;
 //BA.debugLineNum = 43319301;BA.debugLine="else If (pan_help.Visible=True)Then";
if ((mostCurrent._pan_help.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43319302;
 //BA.debugLineNum = 43319302;BA.debugLine="lbl_close_help_Click";
_lbl_close_help_click();
 }else 
{RDebugUtils.currentLine=43319303;
 //BA.debugLineNum = 43319303;BA.debugLine="Else If (pan_all_setting_date.Visible==True)Then";
if ((mostCurrent._pan_all_setting_date.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43319304;
 //BA.debugLineNum = 43319304;BA.debugLine="pan_all_setting_date.Visible=False";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=43319305;
 //BA.debugLineNum = 43319305;BA.debugLine="Else If (pan_all.Visible=True )Then";
if ((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43319307;
 //BA.debugLineNum = 43319307;BA.debugLine="If(pan_all2.Visible=True)Then";
if ((mostCurrent._pan_all2.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43319308;
 //BA.debugLineNum = 43319308;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=43319310;
 //BA.debugLineNum = 43319310;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }else 
{RDebugUtils.currentLine=43319313;
 //BA.debugLineNum = 43319313;BA.debugLine="Else if(pan_notifi_all.Visible==True) Then";
if ((mostCurrent._pan_notifi_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43319314;
 //BA.debugLineNum = 43319314;BA.debugLine="lbl_close_notif_Click";
_lbl_close_notif_click();
 }else 
{RDebugUtils.currentLine=43319315;
 //BA.debugLineNum = 43319315;BA.debugLine="Else If(index_page=2 Or index_page=3)Then";
if ((_index_page==2 || _index_page==3)) { 
RDebugUtils.currentLine=43319316;
 //BA.debugLineNum = 43319316;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 }else 
{RDebugUtils.currentLine=43319317;
 //BA.debugLineNum = 43319317;BA.debugLine="Else If(pan_all_noskhe.Visible==True)Then";
if ((mostCurrent._pan_all_noskhe.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43319318;
 //BA.debugLineNum = 43319318;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
 }else 
{RDebugUtils.currentLine=43319319;
 //BA.debugLineNum = 43319319;BA.debugLine="Else If(pan_all_liteMenu.Visible==True)Then";
if ((mostCurrent._pan_all_litemenu.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43319320;
 //BA.debugLineNum = 43319320;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=43319321;
 //BA.debugLineNum = 43319321;BA.debugLine="Else If (pan_all_chekUpdate.Visible==True)Then";
if ((mostCurrent._pan_all_chekupdate.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43319322;
 //BA.debugLineNum = 43319322;BA.debugLine="pan_all_chekUpdate.Visible=False";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=43319327;
 //BA.debugLineNum = 43319327;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=43319328;
 //BA.debugLineNum = 43319328;BA.debugLine="result = Msgbox2(\"آیا قصد خروج دارید؟\", \"خروج\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا قصد خروج دارید؟"),BA.ObjectToCharSequence("خروج"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=43319329;
 //BA.debugLineNum = 43319329;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=43319330;
 //BA.debugLineNum = 43319330;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=43319331;
 //BA.debugLineNum = 43319331;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 };
 }}}}}}}}}
;
RDebugUtils.currentLine=43319337;
 //BA.debugLineNum = 43319337;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=43319339;
 //BA.debugLineNum = 43319339;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=43319341;
 //BA.debugLineNum = 43319341;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_close_help_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_help_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_help_click", null));}
RDebugUtils.currentLine=46006272;
 //BA.debugLineNum = 46006272;BA.debugLine="Private Sub lbl_close_help_Click";
RDebugUtils.currentLine=46006273;
 //BA.debugLineNum = 46006273;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46006274;
 //BA.debugLineNum = 46006274;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_notif_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_notif_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_notif_click", null));}
RDebugUtils.currentLine=39845888;
 //BA.debugLineNum = 39845888;BA.debugLine="Private Sub lbl_close_notif_Click";
RDebugUtils.currentLine=39845889;
 //BA.debugLineNum = 39845889;BA.debugLine="pan_notifi_all.Visible=False";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=39845890;
 //BA.debugLineNum = 39845890;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_noskhe_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_noskhe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_noskhe_click", null));}
RDebugUtils.currentLine=46923776;
 //BA.debugLineNum = 46923776;BA.debugLine="Private Sub pan_all_noskhe_Click";
RDebugUtils.currentLine=46923777;
 //BA.debugLineNum = 46923777;BA.debugLine="pan_all_noskhe.Visible=False";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46923778;
 //BA.debugLineNum = 46923778;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="If UserClosed Then Poolakey.Connection.Disconnect";
if (_userclosed) { 
mostCurrent._poolakey.getConnection().Disconnect();};
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
RDebugUtils.currentLine=42926080;
 //BA.debugLineNum = 42926080;BA.debugLine="Sub add_end";
RDebugUtils.currentLine=42926081;
 //BA.debugLineNum = 42926081;BA.debugLine="Dim chek As Boolean";
_chek = false;
RDebugUtils.currentLine=42926082;
 //BA.debugLineNum = 42926082;BA.debugLine="chek=myfunc.check_karid";
_chek = mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=42926083;
 //BA.debugLineNum = 42926083;BA.debugLine="Dim alist As List";
_alist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=42926084;
 //BA.debugLineNum = 42926084;BA.debugLine="alist.Initialize";
_alist.Initialize();
RDebugUtils.currentLine=42926086;
 //BA.debugLineNum = 42926086;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(myfunc";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth())))));
RDebugUtils.currentLine=42926089;
 //BA.debugLineNum = 42926089;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(persianDate.Pe";
_alist = mostCurrent._myfunc._num_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear())),_moon_num);
RDebugUtils.currentLine=42926092;
 //BA.debugLineNum = 42926092;BA.debugLine="If(index_box=1) Then";
if ((_index_box==1)) { 
RDebugUtils.currentLine=42926093;
 //BA.debugLineNum = 42926093;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=42926094;
 //BA.debugLineNum = 42926094;BA.debugLine="If(alist.Get(0)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (0))))<5)) { 
RDebugUtils.currentLine=42926095;
 //BA.debugLineNum = 42926095;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 }else {
RDebugUtils.currentLine=42926097;
 //BA.debugLineNum = 42926097;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=42926101;
 //BA.debugLineNum = 42926101;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 };
 }else 
{RDebugUtils.currentLine=42926104;
 //BA.debugLineNum = 42926104;BA.debugLine="Else If (index_box=2) Then";
if ((_index_box==2)) { 
RDebugUtils.currentLine=42926106;
 //BA.debugLineNum = 42926106;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=42926107;
 //BA.debugLineNum = 42926107;BA.debugLine="If(alist.Get(1)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (1))))<5)) { 
RDebugUtils.currentLine=42926108;
 //BA.debugLineNum = 42926108;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 }else {
RDebugUtils.currentLine=42926110;
 //BA.debugLineNum = 42926110;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=42926113;
 //BA.debugLineNum = 42926113;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 };
 }else 
{RDebugUtils.currentLine=42926116;
 //BA.debugLineNum = 42926116;BA.debugLine="Else If (index_box=3) Then";
if ((_index_box==3)) { 
RDebugUtils.currentLine=42926118;
 //BA.debugLineNum = 42926118;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=42926119;
 //BA.debugLineNum = 42926119;BA.debugLine="If(alist.Get(3)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (3))))<5)) { 
RDebugUtils.currentLine=42926122;
 //BA.debugLineNum = 42926122;BA.debugLine="Select state_tatil_setting";
switch (_state_tatil_setting) {
case 0: {
RDebugUtils.currentLine=42926124;
 //BA.debugLineNum = 42926124;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 break; }
case 1: {
RDebugUtils.currentLine=42926126;
 //BA.debugLineNum = 42926126;BA.debugLine="If (state_tatil=1 Or state_tatil=2) Then 'ta";
if ((_state_tatil==1 || _state_tatil==2)) { 
RDebugUtils.currentLine=42926127;
 //BA.debugLineNum = 42926127;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
RDebugUtils.currentLine=42926129;
 //BA.debugLineNum = 42926129;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 11: {
RDebugUtils.currentLine=42926134;
 //BA.debugLineNum = 42926134;BA.debugLine="If (state_tatil=1) Then 'tatil rasmi";
if ((_state_tatil==1)) { 
RDebugUtils.currentLine=42926135;
 //BA.debugLineNum = 42926135;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
RDebugUtils.currentLine=42926137;
 //BA.debugLineNum = 42926137;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 22: {
RDebugUtils.currentLine=42926142;
 //BA.debugLineNum = 42926142;BA.debugLine="If (state_tatil=2) Then  'tatil garardadi";
if ((_state_tatil==2)) { 
RDebugUtils.currentLine=42926143;
 //BA.debugLineNum = 42926143;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
RDebugUtils.currentLine=42926145;
 //BA.debugLineNum = 42926145;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
}
;
RDebugUtils.currentLine=42926152;
 //BA.debugLineNum = 42926152;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=42926153;
 //BA.debugLineNum = 42926153;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
 };
 }else {
RDebugUtils.currentLine=42926157;
 //BA.debugLineNum = 42926157;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=42926161;
 //BA.debugLineNum = 42926161;BA.debugLine="Select state_tatil_setting";
switch (_state_tatil_setting) {
case 0: {
RDebugUtils.currentLine=42926163;
 //BA.debugLineNum = 42926163;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 break; }
case 1: {
RDebugUtils.currentLine=42926165;
 //BA.debugLineNum = 42926165;BA.debugLine="If (state_tatil=1 Or state_tatil=2) Then 'tat";
if ((_state_tatil==1 || _state_tatil==2)) { 
RDebugUtils.currentLine=42926166;
 //BA.debugLineNum = 42926166;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
RDebugUtils.currentLine=42926168;
 //BA.debugLineNum = 42926168;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 11: {
RDebugUtils.currentLine=42926173;
 //BA.debugLineNum = 42926173;BA.debugLine="If (state_tatil=1) Then 'tatil rasmi";
if ((_state_tatil==1)) { 
RDebugUtils.currentLine=42926174;
 //BA.debugLineNum = 42926174;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
RDebugUtils.currentLine=42926176;
 //BA.debugLineNum = 42926176;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 22: {
RDebugUtils.currentLine=42926181;
 //BA.debugLineNum = 42926181;BA.debugLine="If (state_tatil=2) Then  'tatil garardadi";
if ((_state_tatil==2)) { 
RDebugUtils.currentLine=42926182;
 //BA.debugLineNum = 42926182;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
RDebugUtils.currentLine=42926184;
 //BA.debugLineNum = 42926184;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
}
;
RDebugUtils.currentLine=42926191;
 //BA.debugLineNum = 42926191;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=42926192;
 //BA.debugLineNum = 42926192;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
 };
 };
 }else 
{RDebugUtils.currentLine=42926198;
 //BA.debugLineNum = 42926198;BA.debugLine="Else If (index_box=5) Then";
if ((_index_box==5)) { 
RDebugUtils.currentLine=42926200;
 //BA.debugLineNum = 42926200;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=42926201;
 //BA.debugLineNum = 42926201;BA.debugLine="If(alist.Get(4)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (4))))<5)) { 
RDebugUtils.currentLine=42926202;
 //BA.debugLineNum = 42926202;BA.debugLine="add_mamoriat_sub";
_add_mamoriat_sub();
 }else {
RDebugUtils.currentLine=42926204;
 //BA.debugLineNum = 42926204;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
RDebugUtils.currentLine=42926208;
 //BA.debugLineNum = 42926208;BA.debugLine="add_mamoriat_sub";
_add_mamoriat_sub();
 };
 }}}}
;
RDebugUtils.currentLine=42926212;
 //BA.debugLineNum = 42926212;BA.debugLine="End Sub";
return "";
}
public static String  _add_ezafe_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_ezafe_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_ezafe_sub", null));}
int _state_mod = 0;
String _str_mod = "";
boolean _result_a = false;
RDebugUtils.currentLine=42991616;
 //BA.debugLineNum = 42991616;BA.debugLine="Sub add_ezafe_sub";
RDebugUtils.currentLine=42991617;
 //BA.debugLineNum = 42991617;BA.debugLine="Dim state_mod As Int=0";
_state_mod = (int) (0);
RDebugUtils.currentLine=42991618;
 //BA.debugLineNum = 42991618;BA.debugLine="Dim str_mod As String=\"\"";
_str_mod = "";
RDebugUtils.currentLine=42991619;
 //BA.debugLineNum = 42991619;BA.debugLine="If(ckb_ezaf_taradod.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=42991620;
 //BA.debugLineNum = 42991620;BA.debugLine="state_mod=2";
_state_mod = (int) (2);
RDebugUtils.currentLine=42991621;
 //BA.debugLineNum = 42991621;BA.debugLine="str_mod=\" (فوق العاده)- \"";
_str_mod = " (فوق العاده)- ";
 }else {
RDebugUtils.currentLine=42991623;
 //BA.debugLineNum = 42991623;BA.debugLine="state_mod=0";
_state_mod = (int) (0);
 };
RDebugUtils.currentLine=42991627;
 //BA.debugLineNum = 42991627;BA.debugLine="Try";
try {RDebugUtils.currentLine=42991629;
 //BA.debugLineNum = 42991629;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=42991630;
 //BA.debugLineNum = 42991630;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=42991632;
 //BA.debugLineNum = 42991632;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0 Or day_bt<>0)T";
if ((_moon_bt!=0 || _year_bt!=0 || _day_bt!=0)) { 
RDebugUtils.currentLine=42991633;
 //BA.debugLineNum = 42991633;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=42991634;
 //BA.debugLineNum = 42991634;BA.debugLine="Else If (hour_bt=0 And min_bt=0 )Then";
if ((_hour_bt==0 && _min_bt==0)) { 
RDebugUtils.currentLine=42991635;
 //BA.debugLineNum = 42991635;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=42991639;
 //BA.debugLineNum = 42991639;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=42991640;
 //BA.debugLineNum = 42991640;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_ezafekari_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=42991642;
 //BA.debugLineNum = 42991642;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
RDebugUtils.currentLine=42991643;
 //BA.debugLineNum = 42991643;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ اضافه کاری وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
RDebugUtils.currentLine=42991644;
 //BA.debugLineNum = 42991644;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=42991645;
 //BA.debugLineNum = 42991645;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Te";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=42991648;
 //BA.debugLineNum = 42991648;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42991649;
 //BA.debugLineNum = 42991649;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=42991654;
 //BA.debugLineNum = 42991654;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=42991657;
 //BA.debugLineNum = 42991657;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42991658;
 //BA.debugLineNum = 42991658;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=42991662;
 //BA.debugLineNum = 42991662;BA.debugLine="dbCode.edit_ezafekari(current_id_edit,date1,da";
mostCurrent._dbcode._edit_ezafekari /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=42991663;
 //BA.debugLineNum = 42991663;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42991666;
 //BA.debugLineNum = 42991666;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=42991671;
 //BA.debugLineNum = 42991671;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e39) {
			processBA.setLastException(e39);RDebugUtils.currentLine=42991677;
 //BA.debugLineNum = 42991677;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=42991682;
 //BA.debugLineNum = 42991682;BA.debugLine="End Sub";
return "";
}
public static String  _add_morakhasi_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_morakhasi_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_morakhasi_sub", null));}
String _str_noe2 = "";
boolean _result_a = false;
RDebugUtils.currentLine=43057152;
 //BA.debugLineNum = 43057152;BA.debugLine="Sub add_morakhasi_sub";
RDebugUtils.currentLine=43057153;
 //BA.debugLineNum = 43057153;BA.debugLine="Dim str_noe2 As String";
_str_noe2 = "";
RDebugUtils.currentLine=43057154;
 //BA.debugLineNum = 43057154;BA.debugLine="str_noe2=\"(\"&str_noe&\")- \"";
_str_noe2 = "("+mostCurrent._str_noe+")- ";
RDebugUtils.currentLine=43057156;
 //BA.debugLineNum = 43057156;BA.debugLine="Try";
try {RDebugUtils.currentLine=43057157;
 //BA.debugLineNum = 43057157;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
if ((_day_bt<0 || _hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=43057158;
 //BA.debugLineNum = 43057158;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=43057159;
 //BA.debugLineNum = 43057159;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0)Then";
if ((_moon_bt!=0 || _year_bt!=0)) { 
RDebugUtils.currentLine=43057160;
 //BA.debugLineNum = 43057160;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=43057161;
 //BA.debugLineNum = 43057161;BA.debugLine="Else If (hour_bt=0 And min_bt=0 And day_bt=0 )Th";
if ((_hour_bt==0 && _min_bt==0 && _day_bt==0)) { 
RDebugUtils.currentLine=43057162;
 //BA.debugLineNum = 43057162;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=43057167;
 //BA.debugLineNum = 43057167;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=43057168;
 //BA.debugLineNum = 43057168;BA.debugLine="If(dbCode.isexist_morakhasi_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_morakhasi_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43057170;
 //BA.debugLineNum = 43057170;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
RDebugUtils.currentLine=43057171;
 //BA.debugLineNum = 43057171;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ مرخصی وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
RDebugUtils.currentLine=43057172;
 //BA.debugLineNum = 43057172;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43057173;
 //BA.debugLineNum = 43057173;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Te";
mostCurrent._dbcode._add_morakhasi /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_noe2+mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
RDebugUtils.currentLine=43057174;
 //BA.debugLineNum = 43057174;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43057175;
 //BA.debugLineNum = 43057175;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=43057180;
 //BA.debugLineNum = 43057180;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_morakhasi /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_noe2+mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
RDebugUtils.currentLine=43057181;
 //BA.debugLineNum = 43057181;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43057182;
 //BA.debugLineNum = 43057182;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=43057185;
 //BA.debugLineNum = 43057185;BA.debugLine="dbCode.edit_morakhasi(current_id_edit,date1,da";
mostCurrent._dbcode._edit_morakhasi /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
RDebugUtils.currentLine=43057187;
 //BA.debugLineNum = 43057187;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43057188;
 //BA.debugLineNum = 43057188;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=43057195;
 //BA.debugLineNum = 43057195;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e33) {
			processBA.setLastException(e33);RDebugUtils.currentLine=43057201;
 //BA.debugLineNum = 43057201;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=43057206;
 //BA.debugLineNum = 43057206;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=43122688;
 //BA.debugLineNum = 43122688;BA.debugLine="Sub add_taradod_sub";
RDebugUtils.currentLine=43122689;
 //BA.debugLineNum = 43122689;BA.debugLine="Try";
try {RDebugUtils.currentLine=43122691;
 //BA.debugLineNum = 43122691;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=43122692;
 //BA.debugLineNum = 43122692;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=43122694;
 //BA.debugLineNum = 43122694;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0 Or day_bt>2)Th";
if ((_moon_bt!=0 || _year_bt!=0 || _day_bt>2)) { 
RDebugUtils.currentLine=43122695;
 //BA.debugLineNum = 43122695;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=43122696;
 //BA.debugLineNum = 43122696;BA.debugLine="Else If (hour_bt=0 And min_bt=0 )Then";
if ((_hour_bt==0 && _min_bt==0)) { 
RDebugUtils.currentLine=43122697;
 //BA.debugLineNum = 43122697;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=43122702;
 //BA.debugLineNum = 43122702;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=43122703;
 //BA.debugLineNum = 43122703;BA.debugLine="If(dbCode.isexist_taradod_by_date(date1)=True)";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43122706;
 //BA.debugLineNum = 43122706;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
RDebugUtils.currentLine=43122707;
 //BA.debugLineNum = 43122707;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ تردد وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
RDebugUtils.currentLine=43122708;
 //BA.debugLineNum = 43122708;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43122711;
 //BA.debugLineNum = 43122711;BA.debugLine="Dim str_tozih0 As String=\"(فوق العاده)(تردد";
_str_tozih0 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=43122712;
 //BA.debugLineNum = 43122712;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_t";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=43122713;
 //BA.debugLineNum = 43122713;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=43122715;
 //BA.debugLineNum = 43122715;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_e";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43122722;
 //BA.debugLineNum = 43122722;BA.debugLine="Dim tim_ezaf_min As Int=tim_min-(myfunc.get";
_tim_ezaf_min = (int) (_tim_min-(mostCurrent._myfunc._get_saatkari_inweek /*int*/ (mostCurrent.activityBA,_day_inweek_id)));
RDebugUtils.currentLine=43122724;
 //BA.debugLineNum = 43122724;BA.debugLine="Dim ls_res_tim1 As List";
_ls_res_tim1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=43122725;
 //BA.debugLineNum = 43122725;BA.debugLine="ls_res_tim1.Initialize";
_ls_res_tim1.Initialize();
RDebugUtils.currentLine=43122726;
 //BA.debugLineNum = 43122726;BA.debugLine="ls_res_tim1=myfunc.find_tim1_taradod(lbl_ti";
_ls_res_tim1 = mostCurrent._myfunc._find_tim1_taradod /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._lbl_tim2.getText(),_tim_ezaf_min);
RDebugUtils.currentLine=43122727;
 //BA.debugLineNum = 43122727;BA.debugLine="Dim tim1_saat As String=ls_res_tim1.Get(0)";
_tim1_saat = BA.ObjectToString(_ls_res_tim1.Get((int) (0)));
RDebugUtils.currentLine=43122728;
 //BA.debugLineNum = 43122728;BA.debugLine="Dim date1_refind As String=\"\"";
_date1_refind = "";
RDebugUtils.currentLine=43122729;
 //BA.debugLineNum = 43122729;BA.debugLine="If(ls_res_tim1.Get(1)=1) Then";
if (((_ls_res_tim1.Get((int) (1))).equals((Object)(1)))) { 
RDebugUtils.currentLine=43122730;
 //BA.debugLineNum = 43122730;BA.debugLine="date1_refind=date2";
_date1_refind = mostCurrent._date2;
 }else {
RDebugUtils.currentLine=43122732;
 //BA.debugLineNum = 43122732;BA.debugLine="date1_refind=date1";
_date1_refind = mostCurrent._date1;
 };
RDebugUtils.currentLine=43122736;
 //BA.debugLineNum = 43122736;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43122737;
 //BA.debugLineNum = 43122737;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,ti";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih0,(int) (2));
 }else {
RDebugUtils.currentLine=43122739;
 //BA.debugLineNum = 43122739;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,ti";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih1,(int) (0));
 };
RDebugUtils.currentLine=43122744;
 //BA.debugLineNum = 43122744;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
RDebugUtils.currentLine=43122746;
 //BA.debugLineNum = 43122746;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,mostCurrent._et_tozihat.getText(),(int) (0));
 };
RDebugUtils.currentLine=43122753;
 //BA.debugLineNum = 43122753;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43122754;
 //BA.debugLineNum = 43122754;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=43122762;
 //BA.debugLineNum = 43122762;BA.debugLine="Dim str_tozih0 As String=\"(فوق العاده)(تردد د";
_str_tozih0 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=43122763;
 //BA.debugLineNum = 43122763;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_to";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=43122764;
 //BA.debugLineNum = 43122764;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-\"";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=43122767;
 //BA.debugLineNum = 43122767;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_ez";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43122771;
 //BA.debugLineNum = 43122771;BA.debugLine="Dim tim_ezaf_min As Int=tim_min-(myfunc.get_";
_tim_ezaf_min = (int) (_tim_min-(mostCurrent._myfunc._get_saatkari_inweek /*int*/ (mostCurrent.activityBA,_day_inweek_id)));
RDebugUtils.currentLine=43122774;
 //BA.debugLineNum = 43122774;BA.debugLine="Dim ls_res_tim1 As List";
_ls_res_tim1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=43122775;
 //BA.debugLineNum = 43122775;BA.debugLine="ls_res_tim1.Initialize";
_ls_res_tim1.Initialize();
RDebugUtils.currentLine=43122776;
 //BA.debugLineNum = 43122776;BA.debugLine="ls_res_tim1=myfunc.find_tim1_taradod(lbl_tim";
_ls_res_tim1 = mostCurrent._myfunc._find_tim1_taradod /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._lbl_tim2.getText(),_tim_ezaf_min);
RDebugUtils.currentLine=43122777;
 //BA.debugLineNum = 43122777;BA.debugLine="Dim tim1_saat As String=ls_res_tim1.Get(0)";
_tim1_saat = BA.ObjectToString(_ls_res_tim1.Get((int) (0)));
RDebugUtils.currentLine=43122778;
 //BA.debugLineNum = 43122778;BA.debugLine="Dim date1_refind As String=\"\"";
_date1_refind = "";
RDebugUtils.currentLine=43122779;
 //BA.debugLineNum = 43122779;BA.debugLine="If(ls_res_tim1.Get(1)=1) Then";
if (((_ls_res_tim1.Get((int) (1))).equals((Object)(1)))) { 
RDebugUtils.currentLine=43122780;
 //BA.debugLineNum = 43122780;BA.debugLine="date1_refind=date2";
_date1_refind = mostCurrent._date2;
 }else {
RDebugUtils.currentLine=43122782;
 //BA.debugLineNum = 43122782;BA.debugLine="date1_refind=date1";
_date1_refind = mostCurrent._date1;
 };
RDebugUtils.currentLine=43122786;
 //BA.debugLineNum = 43122786;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43122787;
 //BA.debugLineNum = 43122787;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,tim";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih0,(int) (2));
 }else {
RDebugUtils.currentLine=43122789;
 //BA.debugLineNum = 43122789;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,tim";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih1,(int) (0));
 };
RDebugUtils.currentLine=43122793;
 //BA.debugLineNum = 43122793;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
RDebugUtils.currentLine=43122795;
 //BA.debugLineNum = 43122795;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,mostCurrent._et_tozihat.getText(),(int) (0));
 };
RDebugUtils.currentLine=43122799;
 //BA.debugLineNum = 43122799;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43122800;
 //BA.debugLineNum = 43122800;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=43122803;
 //BA.debugLineNum = 43122803;BA.debugLine="dbCode.edit_taradod(current_id_edit,date1,date";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
RDebugUtils.currentLine=43122805;
 //BA.debugLineNum = 43122805;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43122806;
 //BA.debugLineNum = 43122806;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=43122812;
 //BA.debugLineNum = 43122812;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e77) {
			processBA.setLastException(e77);RDebugUtils.currentLine=43122818;
 //BA.debugLineNum = 43122818;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=43122821;
 //BA.debugLineNum = 43122821;BA.debugLine="End Sub";
return "";
}
public static String  _add_taradod_sub2() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_taradod_sub2", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_taradod_sub2", null));}
boolean _result_a = false;
String _str_tozih2 = "";
String _str_tozih1 = "";
RDebugUtils.currentLine=43188224;
 //BA.debugLineNum = 43188224;BA.debugLine="Sub add_taradod_sub2";
RDebugUtils.currentLine=43188225;
 //BA.debugLineNum = 43188225;BA.debugLine="Try";
try {RDebugUtils.currentLine=43188227;
 //BA.debugLineNum = 43188227;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=43188228;
 //BA.debugLineNum = 43188228;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=43188230;
 //BA.debugLineNum = 43188230;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0 Or day_bt>2)Th";
if ((_moon_bt!=0 || _year_bt!=0 || _day_bt>2)) { 
RDebugUtils.currentLine=43188231;
 //BA.debugLineNum = 43188231;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=43188232;
 //BA.debugLineNum = 43188232;BA.debugLine="Else If (hour_bt=0 And min_bt=0 )Then";
if ((_hour_bt==0 && _min_bt==0)) { 
RDebugUtils.currentLine=43188233;
 //BA.debugLineNum = 43188233;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=43188238;
 //BA.debugLineNum = 43188238;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=43188239;
 //BA.debugLineNum = 43188239;BA.debugLine="If(dbCode.isexist_taradod_by_date(date1)=True)";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43188242;
 //BA.debugLineNum = 43188242;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
RDebugUtils.currentLine=43188243;
 //BA.debugLineNum = 43188243;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ تردد وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
RDebugUtils.currentLine=43188244;
 //BA.debugLineNum = 43188244;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43188246;
 //BA.debugLineNum = 43188246;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=43188248;
 //BA.debugLineNum = 43188248;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_e";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43188250;
 //BA.debugLineNum = 43188250;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43188251;
 //BA.debugLineNum = 43188251;BA.debugLine="Dim str_tozih1 As String=\"(فوق العاده)(تر";
_str_tozih1 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=43188252;
 //BA.debugLineNum = 43188252;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (2));
 }else {
RDebugUtils.currentLine=43188254;
 //BA.debugLineNum = 43188254;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&e";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=43188255;
 //BA.debugLineNum = 43188255;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (0));
 };
RDebugUtils.currentLine=43188261;
 //BA.debugLineNum = 43188261;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Te";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
RDebugUtils.currentLine=43188263;
 //BA.debugLineNum = 43188263;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 };
RDebugUtils.currentLine=43188266;
 //BA.debugLineNum = 43188266;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43188267;
 //BA.debugLineNum = 43188267;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=43188274;
 //BA.debugLineNum = 43188274;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-\"";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=43188276;
 //BA.debugLineNum = 43188276;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_ez";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43188278;
 //BA.debugLineNum = 43188278;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43188279;
 //BA.debugLineNum = 43188279;BA.debugLine="Dim str_tozih1 As String=\"(فوق العاده)(تردد";
_str_tozih1 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=43188280;
 //BA.debugLineNum = 43188280;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.T";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (2));
 }else {
RDebugUtils.currentLine=43188282;
 //BA.debugLineNum = 43188282;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
RDebugUtils.currentLine=43188283;
 //BA.debugLineNum = 43188283;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.T";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (0));
 };
RDebugUtils.currentLine=43188290;
 //BA.debugLineNum = 43188290;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
RDebugUtils.currentLine=43188293;
 //BA.debugLineNum = 43188293;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 };
RDebugUtils.currentLine=43188296;
 //BA.debugLineNum = 43188296;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43188297;
 //BA.debugLineNum = 43188297;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=43188302;
 //BA.debugLineNum = 43188302;BA.debugLine="dbCode.edit_taradod(current_id_edit,date1,date";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
RDebugUtils.currentLine=43188304;
 //BA.debugLineNum = 43188304;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43188305;
 //BA.debugLineNum = 43188305;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=43188311;
 //BA.debugLineNum = 43188311;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e55) {
			processBA.setLastException(e55);RDebugUtils.currentLine=43188317;
 //BA.debugLineNum = 43188317;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=43188320;
 //BA.debugLineNum = 43188320;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_rest_finger_fs_taradod_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_rest_finger_fs_taradod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_rest_finger_fs_taradod_click", null));}
RDebugUtils.currentLine=49414144;
 //BA.debugLineNum = 49414144;BA.debugLine="Private Sub lbl_rest_finger_fs_taradod_Click";
RDebugUtils.currentLine=49414145;
 //BA.debugLineNum = 49414145;BA.debugLine="lbl_finger_fs_vorod_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(" - "));
RDebugUtils.currentLine=49414146;
 //BA.debugLineNum = 49414146;BA.debugLine="lbl_finger_fs_khoroj_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(" - "));
RDebugUtils.currentLine=49414148;
 //BA.debugLineNum = 49414148;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=49414149;
 //BA.debugLineNum = 49414149;BA.debugLine="lbl_time_show_fs.Text=\"\"";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=49414151;
 //BA.debugLineNum = 49414151;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=49414152;
 //BA.debugLineNum = 49414152;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=49414153;
 //BA.debugLineNum = 49414153;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=49414154;
 //BA.debugLineNum = 49414154;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=49414155;
 //BA.debugLineNum = 49414155;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=49414156;
 //BA.debugLineNum = 49414156;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=49414158;
 //BA.debugLineNum = 49414158;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=49414159;
 //BA.debugLineNum = 49414159;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=49414161;
 //BA.debugLineNum = 49414161;BA.debugLine="lbl_finger_fs_vorod.Tag=1";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(1));
RDebugUtils.currentLine=49414162;
 //BA.debugLineNum = 49414162;BA.debugLine="lbl_finger_fs_khoroj.Tag=2";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(2));
RDebugUtils.currentLine=49414163;
 //BA.debugLineNum = 49414163;BA.debugLine="File.WriteString(File.DirInternal,\"finger_vorod_t";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt","0");
RDebugUtils.currentLine=49414164;
 //BA.debugLineNum = 49414164;BA.debugLine="save_box_allow=False";
_save_box_allow = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=49414165;
 //BA.debugLineNum = 49414165;BA.debugLine="End Sub";
return "";
}
public static String  _add_mamoriat_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_mamoriat_sub", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_mamoriat_sub", null));}
int _state_mod = 0;
String _str_mod = "";
boolean _result_a = false;
RDebugUtils.currentLine=43253760;
 //BA.debugLineNum = 43253760;BA.debugLine="Sub add_mamoriat_sub";
RDebugUtils.currentLine=43253761;
 //BA.debugLineNum = 43253761;BA.debugLine="Dim state_mod As Int=0";
_state_mod = (int) (0);
RDebugUtils.currentLine=43253762;
 //BA.debugLineNum = 43253762;BA.debugLine="Dim str_mod As String=\"\"";
_str_mod = "";
RDebugUtils.currentLine=43253771;
 //BA.debugLineNum = 43253771;BA.debugLine="Try";
try {RDebugUtils.currentLine=43253772;
 //BA.debugLineNum = 43253772;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
if ((_day_bt<0 || _hour_bt<0 || _min_bt<0)) { 
RDebugUtils.currentLine=43253773;
 //BA.debugLineNum = 43253773;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=43253774;
 //BA.debugLineNum = 43253774;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0)Then";
if ((_moon_bt!=0 || _year_bt!=0)) { 
RDebugUtils.currentLine=43253775;
 //BA.debugLineNum = 43253775;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=43253776;
 //BA.debugLineNum = 43253776;BA.debugLine="Else If (hour_bt=0 And min_bt=0 And day_bt=0 )Th";
if ((_hour_bt==0 && _min_bt==0 && _day_bt==0)) { 
RDebugUtils.currentLine=43253777;
 //BA.debugLineNum = 43253777;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=43253780;
 //BA.debugLineNum = 43253780;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=43253781;
 //BA.debugLineNum = 43253781;BA.debugLine="If(dbCode.isexist_mamoriat_by_date(date1)=True";
if ((mostCurrent._dbcode._isexist_mamoriat_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43253783;
 //BA.debugLineNum = 43253783;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
RDebugUtils.currentLine=43253784;
 //BA.debugLineNum = 43253784;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ مأموریت وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
RDebugUtils.currentLine=43253785;
 //BA.debugLineNum = 43253785;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43253786;
 //BA.debugLineNum = 43253786;BA.debugLine="dbCode.add_mamoriat(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_mamoriat /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=43253788;
 //BA.debugLineNum = 43253788;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43253789;
 //BA.debugLineNum = 43253789;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=43253792;
 //BA.debugLineNum = 43253792;BA.debugLine="dbCode.add_mamoriat(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_mamoriat /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=43253794;
 //BA.debugLineNum = 43253794;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43253795;
 //BA.debugLineNum = 43253795;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
RDebugUtils.currentLine=43253799;
 //BA.debugLineNum = 43253799;BA.debugLine="dbCode.edit_mamoriat(current_id_edit,date1,dat";
mostCurrent._dbcode._edit_mamoriat /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_state_mod);
RDebugUtils.currentLine=43253800;
 //BA.debugLineNum = 43253800;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43253803;
 //BA.debugLineNum = 43253803;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
RDebugUtils.currentLine=43253808;
 //BA.debugLineNum = 43253808;BA.debugLine="pan_all_Click";
_pan_all_click();
 }}}
;
 } 
       catch (Exception e33) {
			processBA.setLastException(e33);RDebugUtils.currentLine=43253814;
 //BA.debugLineNum = 43253814;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=43253819;
 //BA.debugLineNum = 43253819;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=41877504;
 //BA.debugLineNum = 41877504;BA.debugLine="Sub fill_lists (year1 As String, moon1 As String)";
RDebugUtils.currentLine=41877507;
 //BA.debugLineNum = 41877507;BA.debugLine="cust_LV_ezafekari.Clear";
mostCurrent._cust_lv_ezafekari._clear();
RDebugUtils.currentLine=41877508;
 //BA.debugLineNum = 41877508;BA.debugLine="list_ezafekari_id.Clear";
mostCurrent._list_ezafekari_id.Clear();
RDebugUtils.currentLine=41877510;
 //BA.debugLineNum = 41877510;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=41877511;
 //BA.debugLineNum = 41877511;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
RDebugUtils.currentLine=41877512;
 //BA.debugLineNum = 41877512;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=41877513;
 //BA.debugLineNum = 41877513;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=41877514;
 //BA.debugLineNum = 41877514;BA.debugLine="str1.Initialize";
_str1.Initialize();
RDebugUtils.currentLine=41877518;
 //BA.debugLineNum = 41877518;BA.debugLine="Dim ls_ezafe As List";
_ls_ezafe = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=41877519;
 //BA.debugLineNum = 41877519;BA.debugLine="ls_ezafe.Initialize";
_ls_ezafe.Initialize();
RDebugUtils.currentLine=41877521;
 //BA.debugLineNum = 41877521;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz2_dontDay(dbCod";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
RDebugUtils.currentLine=41877523;
 //BA.debugLineNum = 41877523;BA.debugLine="If((ls_ezafe.Get(0))<>0)Then";
if ((((_ls_ezafe.Get((int) (0)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877524;
 //BA.debugLineNum = 41877524;BA.debugLine="str1.Append(ls_ezafe.Get(0)&\" ساعت \")";
_str1.Append(BA.ObjectToString(_ls_ezafe.Get((int) (0)))+" ساعت ");
RDebugUtils.currentLine=41877525;
 //BA.debugLineNum = 41877525;BA.debugLine="If((ls_ezafe.Get(1))<>0)Then";
if ((((_ls_ezafe.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877526;
 //BA.debugLineNum = 41877526;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
RDebugUtils.currentLine=41877529;
 //BA.debugLineNum = 41877529;BA.debugLine="If((ls_ezafe.Get(1))<>0)Then";
if ((((_ls_ezafe.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877530;
 //BA.debugLineNum = 41877530;BA.debugLine="str1.Append(ls_ezafe.Get(1)&\" دقیقه \")";
_str1.Append(BA.ObjectToString(_ls_ezafe.Get((int) (1)))+" دقیقه ");
 };
RDebugUtils.currentLine=41877534;
 //BA.debugLineNum = 41877534;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=41877535;
 //BA.debugLineNum = 41877535;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=41877536;
 //BA.debugLineNum = 41877536;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
RDebugUtils.currentLine=41877538;
 //BA.debugLineNum = 41877538;BA.debugLine="cust_LV_ezafekari.Add(p,dbCode.res.GetString(\"id";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=41877540;
 //BA.debugLineNum = 41877540;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=41877543;
 //BA.debugLineNum = 41877543;BA.debugLine="lbl_date_CLV.Text=\"از : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("از : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
RDebugUtils.currentLine=41877544;
 //BA.debugLineNum = 41877544;BA.debugLine="lbl_hour_CLV.Text=\"تا : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("تا : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
RDebugUtils.currentLine=41877547;
 //BA.debugLineNum = 41877547;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str1.ToString()));
RDebugUtils.currentLine=41877548;
 //BA.debugLineNum = 41877548;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=41877549;
 //BA.debugLineNum = 41877549;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=41877550;
 //BA.debugLineNum = 41877550;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=41877552;
 //BA.debugLineNum = 41877552;BA.debugLine="list_ezafekari_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_ezafekari_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=41877557;
 //BA.debugLineNum = 41877557;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=41877558;
 //BA.debugLineNum = 41877558;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=41877560;
 //BA.debugLineNum = 41877560;BA.debugLine="If(cust_LV_ezafekari.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_ezafekari._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=41877561;
 //BA.debugLineNum = 41877561;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=41877562;
 //BA.debugLineNum = 41877562;BA.debugLine="Select cust_LV_ezafekari.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_ezafekari._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=41877564;
 //BA.debugLineNum = 41877564;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
RDebugUtils.currentLine=41877566;
 //BA.debugLineNum = 41877566;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=41877568;
 //BA.debugLineNum = 41877568;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=41877570;
 //BA.debugLineNum = 41877570;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=41877572;
 //BA.debugLineNum = 41877572;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=41877574;
 //BA.debugLineNum = 41877574;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=41877576;
 //BA.debugLineNum = 41877576;BA.debugLine="cust_LV_ezafekari.Add(p,\"\")";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=41877580;
 //BA.debugLineNum = 41877580;BA.debugLine="cust_LV_morakhasi.Clear";
mostCurrent._cust_lv_morakhasi._clear();
RDebugUtils.currentLine=41877581;
 //BA.debugLineNum = 41877581;BA.debugLine="list_morakhasi_id.Clear";
mostCurrent._list_morakhasi_id.Clear();
RDebugUtils.currentLine=41877583;
 //BA.debugLineNum = 41877583;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=41877584;
 //BA.debugLineNum = 41877584;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
RDebugUtils.currentLine=41877585;
 //BA.debugLineNum = 41877585;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=41877586;
 //BA.debugLineNum = 41877586;BA.debugLine="Dim str2 As StringBuilder";
_str2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=41877587;
 //BA.debugLineNum = 41877587;BA.debugLine="str2.Initialize";
_str2.Initialize();
RDebugUtils.currentLine=41877589;
 //BA.debugLineNum = 41877589;BA.debugLine="Dim ls_morkh As List";
_ls_morkh = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=41877590;
 //BA.debugLineNum = 41877590;BA.debugLine="ls_morkh.Initialize";
_ls_morkh.Initialize();
RDebugUtils.currentLine=41877592;
 //BA.debugLineNum = 41877592;BA.debugLine="ls_morkh=myfunc.Min_to_saatMinRoz(dbCode.res.Get";
_ls_morkh = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
RDebugUtils.currentLine=41877596;
 //BA.debugLineNum = 41877596;BA.debugLine="If((ls_morkh.Get(2))<>0)Then";
if ((((_ls_morkh.Get((int) (2)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877597;
 //BA.debugLineNum = 41877597;BA.debugLine="str2.Append(ls_morkh.Get(2)&\" روز \")";
_str2.Append(BA.ObjectToString(_ls_morkh.Get((int) (2)))+" روز ");
RDebugUtils.currentLine=41877598;
 //BA.debugLineNum = 41877598;BA.debugLine="If((ls_morkh.Get(0))<>0 Or (ls_morkh.Get(1))<>0";
if ((((_ls_morkh.Get((int) (0)))).equals((Object)(0)) == false || ((_ls_morkh.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877599;
 //BA.debugLineNum = 41877599;BA.debugLine="str2.Append(CRLF)";
_str2.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
RDebugUtils.currentLine=41877602;
 //BA.debugLineNum = 41877602;BA.debugLine="If((ls_morkh.Get(0))<>0)Then";
if ((((_ls_morkh.Get((int) (0)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877603;
 //BA.debugLineNum = 41877603;BA.debugLine="str2.Append(ls_morkh.Get(0)&\" ساعت \")";
_str2.Append(BA.ObjectToString(_ls_morkh.Get((int) (0)))+" ساعت ");
RDebugUtils.currentLine=41877604;
 //BA.debugLineNum = 41877604;BA.debugLine="If((ls_morkh.Get(1))<>0)Then";
if ((((_ls_morkh.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877605;
 //BA.debugLineNum = 41877605;BA.debugLine="str2.Append(CRLF)";
_str2.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
RDebugUtils.currentLine=41877608;
 //BA.debugLineNum = 41877608;BA.debugLine="If((ls_morkh.Get(1))<>0)Then";
if ((((_ls_morkh.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877609;
 //BA.debugLineNum = 41877609;BA.debugLine="str2.Append(ls_morkh.Get(1)&\" دقیقه \")";
_str2.Append(BA.ObjectToString(_ls_morkh.Get((int) (1)))+" دقیقه ");
 };
RDebugUtils.currentLine=41877613;
 //BA.debugLineNum = 41877613;BA.debugLine="Dim p2 As B4XView = xui.CreatePanel(\"\")";
_p2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p2 = mostCurrent._xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=41877614;
 //BA.debugLineNum = 41877614;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=41877615;
 //BA.debugLineNum = 41877615;BA.debugLine="p2.LoadLayout(\"item_list\")";
_p2.LoadLayout("item_list",mostCurrent.activityBA);
RDebugUtils.currentLine=41877617;
 //BA.debugLineNum = 41877617;BA.debugLine="cust_LV_morakhasi.Add(p2,dbCode.res.GetString(\"i";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=41877619;
 //BA.debugLineNum = 41877619;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=41877621;
 //BA.debugLineNum = 41877621;BA.debugLine="lbl_date_CLV.Text=\"از : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("از : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
RDebugUtils.currentLine=41877622;
 //BA.debugLineNum = 41877622;BA.debugLine="lbl_hour_CLV.Text=\"تا : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("تا : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
RDebugUtils.currentLine=41877623;
 //BA.debugLineNum = 41877623;BA.debugLine="lbl_time_CLV.Text=str2.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str2.ToString()));
RDebugUtils.currentLine=41877624;
 //BA.debugLineNum = 41877624;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=41877625;
 //BA.debugLineNum = 41877625;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=41877626;
 //BA.debugLineNum = 41877626;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=41877628;
 //BA.debugLineNum = 41877628;BA.debugLine="list_morakhasi_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_morakhasi_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=41877633;
 //BA.debugLineNum = 41877633;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=41877634;
 //BA.debugLineNum = 41877634;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=41877640;
 //BA.debugLineNum = 41877640;BA.debugLine="If(cust_LV_morakhasi.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_morakhasi._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=41877641;
 //BA.debugLineNum = 41877641;BA.debugLine="p2 = xui.CreatePanel(\"p\")";
_p2 = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=41877642;
 //BA.debugLineNum = 41877642;BA.debugLine="Select cust_LV_morakhasi.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_morakhasi._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=41877644;
 //BA.debugLineNum = 41877644;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
RDebugUtils.currentLine=41877646;
 //BA.debugLineNum = 41877646;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=41877648;
 //BA.debugLineNum = 41877648;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=41877650;
 //BA.debugLineNum = 41877650;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=41877652;
 //BA.debugLineNum = 41877652;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=41877654;
 //BA.debugLineNum = 41877654;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=41877656;
 //BA.debugLineNum = 41877656;BA.debugLine="cust_LV_morakhasi.Add(p2,\"\")";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(""));
 };
RDebugUtils.currentLine=41877661;
 //BA.debugLineNum = 41877661;BA.debugLine="cust_LV_taradod.Clear";
mostCurrent._cust_lv_taradod._clear();
RDebugUtils.currentLine=41877662;
 //BA.debugLineNum = 41877662;BA.debugLine="list_taradod_id.Clear";
mostCurrent._list_taradod_id.Clear();
RDebugUtils.currentLine=41877664;
 //BA.debugLineNum = 41877664;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=41877665;
 //BA.debugLineNum = 41877665;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
RDebugUtils.currentLine=41877666;
 //BA.debugLineNum = 41877666;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=41877667;
 //BA.debugLineNum = 41877667;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=41877668;
 //BA.debugLineNum = 41877668;BA.debugLine="str1.Initialize";
_str1.Initialize();
RDebugUtils.currentLine=41877670;
 //BA.debugLineNum = 41877670;BA.debugLine="Dim ls_tarad As List";
_ls_tarad = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=41877671;
 //BA.debugLineNum = 41877671;BA.debugLine="ls_tarad.Initialize";
_ls_tarad.Initialize();
RDebugUtils.currentLine=41877673;
 //BA.debugLineNum = 41877673;BA.debugLine="ls_tarad=myfunc.Min_to_saatMinRoz(dbCode.res.Get";
_ls_tarad = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
RDebugUtils.currentLine=41877677;
 //BA.debugLineNum = 41877677;BA.debugLine="If((ls_tarad.Get(2))<>0)Then";
if ((((_ls_tarad.Get((int) (2)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877678;
 //BA.debugLineNum = 41877678;BA.debugLine="str1.Append(ls_tarad.Get(2)&\" روز \")";
_str1.Append(BA.ObjectToString(_ls_tarad.Get((int) (2)))+" روز ");
RDebugUtils.currentLine=41877679;
 //BA.debugLineNum = 41877679;BA.debugLine="If((ls_tarad.Get(0))<>0 Or (ls_tarad.Get(1))<>0";
if ((((_ls_tarad.Get((int) (0)))).equals((Object)(0)) == false || ((_ls_tarad.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877680;
 //BA.debugLineNum = 41877680;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
RDebugUtils.currentLine=41877683;
 //BA.debugLineNum = 41877683;BA.debugLine="If((ls_tarad.Get(0))<>0)Then";
if ((((_ls_tarad.Get((int) (0)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877684;
 //BA.debugLineNum = 41877684;BA.debugLine="str1.Append(ls_tarad.Get(0)&\" ساعت \")";
_str1.Append(BA.ObjectToString(_ls_tarad.Get((int) (0)))+" ساعت ");
RDebugUtils.currentLine=41877685;
 //BA.debugLineNum = 41877685;BA.debugLine="If((ls_tarad.Get(1))<>0)Then";
if ((((_ls_tarad.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877686;
 //BA.debugLineNum = 41877686;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
RDebugUtils.currentLine=41877689;
 //BA.debugLineNum = 41877689;BA.debugLine="If((ls_tarad.Get(1))<>0)Then";
if ((((_ls_tarad.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877690;
 //BA.debugLineNum = 41877690;BA.debugLine="str1.Append(ls_tarad.Get(1)&\" دقیقه \")";
_str1.Append(BA.ObjectToString(_ls_tarad.Get((int) (1)))+" دقیقه ");
 };
RDebugUtils.currentLine=41877694;
 //BA.debugLineNum = 41877694;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=41877695;
 //BA.debugLineNum = 41877695;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=41877696;
 //BA.debugLineNum = 41877696;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
RDebugUtils.currentLine=41877698;
 //BA.debugLineNum = 41877698;BA.debugLine="cust_LV_taradod.Add(p,dbCode.res.GetString(\"id\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=41877700;
 //BA.debugLineNum = 41877700;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=41877702;
 //BA.debugLineNum = 41877702;BA.debugLine="lbl_date_CLV.Text=\"ورود : \"&dbCode.res.GetString";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("ورود : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
RDebugUtils.currentLine=41877703;
 //BA.debugLineNum = 41877703;BA.debugLine="lbl_hour_CLV.Text=\"خروج : \"&dbCode.res.GetString";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("خروج : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
RDebugUtils.currentLine=41877705;
 //BA.debugLineNum = 41877705;BA.debugLine="lbl_time_CLV.Typeface=Typeface.MATERIALICONS";
mostCurrent._lbl_time_clv.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
RDebugUtils.currentLine=41877706;
 //BA.debugLineNum = 41877706;BA.debugLine="lbl_time_CLV.Text=Chr(0xE8D5)";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe8d5))));
RDebugUtils.currentLine=41877707;
 //BA.debugLineNum = 41877707;BA.debugLine="lbl_time_CLV.TextSize=25";
mostCurrent._lbl_time_clv.setTextSize((float) (25));
RDebugUtils.currentLine=41877709;
 //BA.debugLineNum = 41877709;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=41877710;
 //BA.debugLineNum = 41877710;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=41877711;
 //BA.debugLineNum = 41877711;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=41877713;
 //BA.debugLineNum = 41877713;BA.debugLine="list_taradod_id.Add(dbCode.res.GetString(\"id\"))";
mostCurrent._list_taradod_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=41877718;
 //BA.debugLineNum = 41877718;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=41877719;
 //BA.debugLineNum = 41877719;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=41877721;
 //BA.debugLineNum = 41877721;BA.debugLine="If(cust_LV_taradod.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_taradod._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=41877722;
 //BA.debugLineNum = 41877722;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=41877723;
 //BA.debugLineNum = 41877723;BA.debugLine="Select cust_LV_taradod.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_taradod._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=41877725;
 //BA.debugLineNum = 41877725;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
RDebugUtils.currentLine=41877727;
 //BA.debugLineNum = 41877727;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=41877729;
 //BA.debugLineNum = 41877729;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=41877731;
 //BA.debugLineNum = 41877731;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=41877733;
 //BA.debugLineNum = 41877733;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=41877735;
 //BA.debugLineNum = 41877735;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=41877737;
 //BA.debugLineNum = 41877737;BA.debugLine="cust_LV_taradod.Add(p,\"\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=41877743;
 //BA.debugLineNum = 41877743;BA.debugLine="cust_LV_mamoriat.Clear";
mostCurrent._cust_lv_mamoriat._clear();
RDebugUtils.currentLine=41877744;
 //BA.debugLineNum = 41877744;BA.debugLine="list_mamoriat_id.Clear";
mostCurrent._list_mamoriat_id.Clear();
RDebugUtils.currentLine=41877747;
 //BA.debugLineNum = 41877747;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=41877748;
 //BA.debugLineNum = 41877748;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
RDebugUtils.currentLine=41877751;
 //BA.debugLineNum = 41877751;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=41877752;
 //BA.debugLineNum = 41877752;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=41877753;
 //BA.debugLineNum = 41877753;BA.debugLine="str1.Initialize";
_str1.Initialize();
RDebugUtils.currentLine=41877755;
 //BA.debugLineNum = 41877755;BA.debugLine="Dim ls_mamor As List";
_ls_mamor = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=41877756;
 //BA.debugLineNum = 41877756;BA.debugLine="ls_mamor.Initialize";
_ls_mamor.Initialize();
RDebugUtils.currentLine=41877758;
 //BA.debugLineNum = 41877758;BA.debugLine="ls_mamor=myfunc.Min_to_saatMinRoz(dbCode.res.Get";
_ls_mamor = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
RDebugUtils.currentLine=41877762;
 //BA.debugLineNum = 41877762;BA.debugLine="If((ls_mamor.Get(2))<>0)Then";
if ((((_ls_mamor.Get((int) (2)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877763;
 //BA.debugLineNum = 41877763;BA.debugLine="str1.Append(ls_mamor.Get(2)&\" روز \")";
_str1.Append(BA.ObjectToString(_ls_mamor.Get((int) (2)))+" روز ");
RDebugUtils.currentLine=41877764;
 //BA.debugLineNum = 41877764;BA.debugLine="If((ls_mamor.Get(0))<>0 Or (ls_mamor.Get(1))<>0";
if ((((_ls_mamor.Get((int) (0)))).equals((Object)(0)) == false || ((_ls_mamor.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877765;
 //BA.debugLineNum = 41877765;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
RDebugUtils.currentLine=41877768;
 //BA.debugLineNum = 41877768;BA.debugLine="If((ls_mamor.Get(0))<>0)Then";
if ((((_ls_mamor.Get((int) (0)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877769;
 //BA.debugLineNum = 41877769;BA.debugLine="str1.Append(ls_mamor.Get(0)&\" ساعت \")";
_str1.Append(BA.ObjectToString(_ls_mamor.Get((int) (0)))+" ساعت ");
RDebugUtils.currentLine=41877770;
 //BA.debugLineNum = 41877770;BA.debugLine="If((ls_mamor.Get(1))<>0)Then";
if ((((_ls_mamor.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877771;
 //BA.debugLineNum = 41877771;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
RDebugUtils.currentLine=41877774;
 //BA.debugLineNum = 41877774;BA.debugLine="If((ls_mamor.Get(1))<>0)Then";
if ((((_ls_mamor.Get((int) (1)))).equals((Object)(0)) == false)) { 
RDebugUtils.currentLine=41877775;
 //BA.debugLineNum = 41877775;BA.debugLine="str1.Append(ls_mamor.Get(1)&\" دقیقه \")";
_str1.Append(BA.ObjectToString(_ls_mamor.Get((int) (1)))+" دقیقه ");
 };
RDebugUtils.currentLine=41877779;
 //BA.debugLineNum = 41877779;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=41877780;
 //BA.debugLineNum = 41877780;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=41877781;
 //BA.debugLineNum = 41877781;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
RDebugUtils.currentLine=41877783;
 //BA.debugLineNum = 41877783;BA.debugLine="cust_LV_mamoriat.Add(p,dbCode.res.GetString(\"id\"";
mostCurrent._cust_lv_mamoriat._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=41877785;
 //BA.debugLineNum = 41877785;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=41877787;
 //BA.debugLineNum = 41877787;BA.debugLine="lbl_date_CLV.Text=\"از : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("از : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
RDebugUtils.currentLine=41877788;
 //BA.debugLineNum = 41877788;BA.debugLine="lbl_hour_CLV.Text=\"تا : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("تا : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
RDebugUtils.currentLine=41877789;
 //BA.debugLineNum = 41877789;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str1.ToString()));
RDebugUtils.currentLine=41877790;
 //BA.debugLineNum = 41877790;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=41877791;
 //BA.debugLineNum = 41877791;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=41877792;
 //BA.debugLineNum = 41877792;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=41877794;
 //BA.debugLineNum = 41877794;BA.debugLine="list_mamoriat_id.Add(dbCode.res.GetString(\"id\"))";
mostCurrent._list_mamoriat_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=41877799;
 //BA.debugLineNum = 41877799;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=41877800;
 //BA.debugLineNum = 41877800;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=41877804;
 //BA.debugLineNum = 41877804;BA.debugLine="If(cust_LV_mamoriat.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_mamoriat._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=41877805;
 //BA.debugLineNum = 41877805;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
RDebugUtils.currentLine=41877806;
 //BA.debugLineNum = 41877806;BA.debugLine="Select cust_LV_mamoriat.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_mamoriat._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=41877808;
 //BA.debugLineNum = 41877808;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
RDebugUtils.currentLine=41877810;
 //BA.debugLineNum = 41877810;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=41877812;
 //BA.debugLineNum = 41877812;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=41877814;
 //BA.debugLineNum = 41877814;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=41877816;
 //BA.debugLineNum = 41877816;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=41877818;
 //BA.debugLineNum = 41877818;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=41877820;
 //BA.debugLineNum = 41877820;BA.debugLine="cust_LV_mamoriat.Add(p,\"\")";
mostCurrent._cust_lv_mamoriat._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=41877824;
 //BA.debugLineNum = 41877824;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
RDebugUtils.currentLine=41877826;
 //BA.debugLineNum = 41877826;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=42729472;
 //BA.debugLineNum = 42729472;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=42729473;
 //BA.debugLineNum = 42729473;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42729474;
 //BA.debugLineNum = 42729474;BA.debugLine="End Sub";
return "";
}
public static String  _auth_complete(boolean _success,String _errormessage) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "auth_complete", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "auth_complete", new Object[] {_success,_errormessage}));}
RDebugUtils.currentLine=40697856;
 //BA.debugLineNum = 40697856;BA.debugLine="Sub Auth_Complete (Success As Boolean, ErrorMessag";
RDebugUtils.currentLine=40697857;
 //BA.debugLineNum = 40697857;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=40697858;
 //BA.debugLineNum = 40697858;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=40697859;
 //BA.debugLineNum = 40697859;BA.debugLine="tim_lock_lbl.Enabled=False";
_tim_lock_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=40697861;
 //BA.debugLineNum = 40697861;BA.debugLine="ToastMessageShow($\"Error: ${ErrorMessage}\"$, Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(("Error: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_errormessage))+"")),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=40697862;
 //BA.debugLineNum = 40697862;BA.debugLine="Log(ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("340697862",_errormessage,0);
 };
RDebugUtils.currentLine=40697864;
 //BA.debugLineNum = 40697864;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_gozaresh_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_menu_gozaresh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_menu_gozaresh_click", null));}
RDebugUtils.currentLine=41943040;
 //BA.debugLineNum = 41943040;BA.debugLine="Private Sub btn_menu_gozaresh_Click";
RDebugUtils.currentLine=41943041;
 //BA.debugLineNum = 41943041;BA.debugLine="index_page=3";
_index_page = (int) (3);
RDebugUtils.currentLine=41943042;
 //BA.debugLineNum = 41943042;BA.debugLine="pan_imag.Background=img3";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img3.getObject()));
RDebugUtils.currentLine=41943044;
 //BA.debugLineNum = 41943044;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
RDebugUtils.currentLine=41943045;
 //BA.debugLineNum = 41943045;BA.debugLine="pan_main.LoadLayout(\"gozaresh_layout\")";
mostCurrent._pan_main.LoadLayout("gozaresh_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=41943047;
 //BA.debugLineNum = 41943047;BA.debugLine="sp_year_gozaresh.Add(\"1404\")";
mostCurrent._sp_year_gozaresh.Add("1404");
RDebugUtils.currentLine=41943048;
 //BA.debugLineNum = 41943048;BA.debugLine="sp_year_gozaresh.Add(\"1403\")";
mostCurrent._sp_year_gozaresh.Add("1403");
RDebugUtils.currentLine=41943049;
 //BA.debugLineNum = 41943049;BA.debugLine="sp_year_gozaresh.Add(\"1402\")";
mostCurrent._sp_year_gozaresh.Add("1402");
RDebugUtils.currentLine=41943050;
 //BA.debugLineNum = 41943050;BA.debugLine="sp_year_gozaresh.Add(\"1401\")";
mostCurrent._sp_year_gozaresh.Add("1401");
RDebugUtils.currentLine=41943051;
 //BA.debugLineNum = 41943051;BA.debugLine="sp_year_gozaresh.Add(\"1400\")";
mostCurrent._sp_year_gozaresh.Add("1400");
RDebugUtils.currentLine=41943052;
 //BA.debugLineNum = 41943052;BA.debugLine="sp_year_gozaresh.Add(\"1399\")";
mostCurrent._sp_year_gozaresh.Add("1399");
RDebugUtils.currentLine=41943053;
 //BA.debugLineNum = 41943053;BA.debugLine="sp_year_gozaresh.Add(\"1398\")";
mostCurrent._sp_year_gozaresh.Add("1398");
RDebugUtils.currentLine=41943055;
 //BA.debugLineNum = 41943055;BA.debugLine="sp_year_gozaresh.SelectedIndex=0";
mostCurrent._sp_year_gozaresh.setSelectedIndex((int) (0));
RDebugUtils.currentLine=41943060;
 //BA.debugLineNum = 41943060;BA.debugLine="pan_hed_gozaresh.Color=color4";
mostCurrent._pan_hed_gozaresh.setColor(_color4);
RDebugUtils.currentLine=41943065;
 //BA.debugLineNum = 41943065;BA.debugLine="list_gozareshat_id.Initialize";
mostCurrent._list_gozareshat_id.Initialize();
RDebugUtils.currentLine=41943068;
 //BA.debugLineNum = 41943068;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
RDebugUtils.currentLine=41943070;
 //BA.debugLineNum = 41943070;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_gozareshat(String _year1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_list_gozareshat", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_list_gozareshat", new Object[] {_year1}));}
RDebugUtils.currentLine=42008576;
 //BA.debugLineNum = 42008576;BA.debugLine="Sub fill_list_gozareshat(year1 As String)";
RDebugUtils.currentLine=42008577;
 //BA.debugLineNum = 42008577;BA.debugLine="CLV_gozaresh.Clear";
mostCurrent._clv_gozaresh._clear();
RDebugUtils.currentLine=42008578;
 //BA.debugLineNum = 42008578;BA.debugLine="list_gozareshat_id.Clear";
mostCurrent._list_gozareshat_id.Clear();
RDebugUtils.currentLine=42008580;
 //BA.debugLineNum = 42008580;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=42008581;
 //BA.debugLineNum = 42008581;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ORDER BY  id DESC;")));
RDebugUtils.currentLine=42008582;
 //BA.debugLineNum = 42008582;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=42008585;
 //BA.debugLineNum = 42008585;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=42008586;
 //BA.debugLineNum = 42008586;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 96%x, 114dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (114)));
RDebugUtils.currentLine=42008587;
 //BA.debugLineNum = 42008587;BA.debugLine="p.LoadLayout(\"item_list_2\")";
mostCurrent._p.LoadLayout("item_list_2",mostCurrent.activityBA);
RDebugUtils.currentLine=42008589;
 //BA.debugLineNum = 42008589;BA.debugLine="CLV_gozaresh.Add(p,dbCode.res.GetString(\"id\"))";
mostCurrent._clv_gozaresh._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=42008590;
 //BA.debugLineNum = 42008590;BA.debugLine="lbl_dateGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_dategozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date")));
RDebugUtils.currentLine=42008591;
 //BA.debugLineNum = 42008591;BA.debugLine="lbl_nameGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_namegozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title")));
RDebugUtils.currentLine=42008592;
 //BA.debugLineNum = 42008592;BA.debugLine="lbl_tozihGozaresh_CLV.Text=dbCode.res.GetString(";
mostCurrent._lbl_tozihgozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozih")));
RDebugUtils.currentLine=42008593;
 //BA.debugLineNum = 42008593;BA.debugLine="lbl_remove_from_list2.Tag=dbCode.res.GetString(\"";
mostCurrent._lbl_remove_from_list2.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=42008594;
 //BA.debugLineNum = 42008594;BA.debugLine="pan_item_gozaresh.Tag=dbCode.res.GetString(\"id\")";
mostCurrent._pan_item_gozaresh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=42008595;
 //BA.debugLineNum = 42008595;BA.debugLine="list_gozareshat_id.Add(dbCode.res.GetString(\"id\"";
mostCurrent._list_gozareshat_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=42008596;
 //BA.debugLineNum = 42008596;BA.debugLine="Log(dbCode.res.GetString(\"id\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("342008596",mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id"),0);
 }
;
RDebugUtils.currentLine=42008598;
 //BA.debugLineNum = 42008598;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=42008599;
 //BA.debugLineNum = 42008599;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=42008601;
 //BA.debugLineNum = 42008601;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_click", null));}
RDebugUtils.currentLine=45940736;
 //BA.debugLineNum = 45940736;BA.debugLine="Private Sub lbl_help_Click";
RDebugUtils.currentLine=45940739;
 //BA.debugLineNum = 45940739;BA.debugLine="bit_img0.Initialize(File.DirAssets,\"home-h0.jpg\")";
mostCurrent._bit_img0.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h0.jpg");
RDebugUtils.currentLine=45940740;
 //BA.debugLineNum = 45940740;BA.debugLine="bit_img1.Initialize(File.DirAssets,\"home-h1.jpg\")";
mostCurrent._bit_img1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h1.jpg");
RDebugUtils.currentLine=45940741;
 //BA.debugLineNum = 45940741;BA.debugLine="bit_img2.Initialize(File.DirAssets,\"home-h2.jpg\")";
mostCurrent._bit_img2.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h2.jpg");
RDebugUtils.currentLine=45940742;
 //BA.debugLineNum = 45940742;BA.debugLine="bit_img3.Initialize(File.DirAssets,\"home-h3.jpg\")";
mostCurrent._bit_img3.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h3.jpg");
RDebugUtils.currentLine=45940743;
 //BA.debugLineNum = 45940743;BA.debugLine="bit_img4.Initialize(File.DirAssets,\"home-h4.jpg\")";
mostCurrent._bit_img4.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h4.jpg");
RDebugUtils.currentLine=45940746;
 //BA.debugLineNum = 45940746;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
RDebugUtils.currentLine=45940747;
 //BA.debugLineNum = 45940747;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
RDebugUtils.currentLine=45940748;
 //BA.debugLineNum = 45940748;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=45940750;
 //BA.debugLineNum = 45940750;BA.debugLine="End Sub";
return "";
}
public static String  _get_today_shift() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_today_shift", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_today_shift", null));}
int _id_today = 0;
String _str_sh = "";
RDebugUtils.currentLine=41680896;
 //BA.debugLineNum = 41680896;BA.debugLine="Sub get_today_shift";
RDebugUtils.currentLine=41680897;
 //BA.debugLineNum = 41680897;BA.debugLine="Dim id_today As Int";
_id_today = 0;
RDebugUtils.currentLine=41680898;
 //BA.debugLineNum = 41680898;BA.debugLine="id_today=dbCode.get_day_id(persianDate.PersianYea";
_id_today = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_persiandate.getPersianYear(),_persiandate.getPersianMonth(),_persiandate.getPersianDay());
RDebugUtils.currentLine=41680900;
 //BA.debugLineNum = 41680900;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=41680901;
 //BA.debugLineNum = 41680901;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id_today))));
RDebugUtils.currentLine=41680903;
 //BA.debugLineNum = 41680903;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=41680904;
 //BA.debugLineNum = 41680904;BA.debugLine="Try";
try {RDebugUtils.currentLine=41680905;
 //BA.debugLineNum = 41680905;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")).equals("") == false)) { 
RDebugUtils.currentLine=41680906;
 //BA.debugLineNum = 41680906;BA.debugLine="Dim str_sh As String";
_str_sh = "";
RDebugUtils.currentLine=41680907;
 //BA.debugLineNum = 41680907;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift"),"ر","ش","ع","ا","ص/ع","ع/ش","ص/ش")) {
case 0: {
RDebugUtils.currentLine=41680909;
 //BA.debugLineNum = 41680909;BA.debugLine="str_sh=\"روزکار\"";
_str_sh = "روزکار";
 break; }
case 1: {
RDebugUtils.currentLine=41680911;
 //BA.debugLineNum = 41680911;BA.debugLine="str_sh=\"شبکار\"";
_str_sh = "شبکار";
 break; }
case 2: {
RDebugUtils.currentLine=41680913;
 //BA.debugLineNum = 41680913;BA.debugLine="str_sh=\"عصرکار\"";
_str_sh = "عصرکار";
 break; }
case 3: {
RDebugUtils.currentLine=41680915;
 //BA.debugLineNum = 41680915;BA.debugLine="str_sh=\"استراحت\"";
_str_sh = "استراحت";
 break; }
case 4: {
RDebugUtils.currentLine=41680917;
 //BA.debugLineNum = 41680917;BA.debugLine="str_sh=\"صبح-عصر\"";
_str_sh = "صبح-عصر";
 break; }
case 5: {
RDebugUtils.currentLine=41680919;
 //BA.debugLineNum = 41680919;BA.debugLine="str_sh=\"عصر-شب\"";
_str_sh = "عصر-شب";
 break; }
case 6: {
RDebugUtils.currentLine=41680921;
 //BA.debugLineNum = 41680921;BA.debugLine="str_sh=\"صبح-شب\"";
_str_sh = "صبح-شب";
 break; }
}
;
RDebugUtils.currentLine=41680923;
 //BA.debugLineNum = 41680923;BA.debugLine="lbl_shift_home.Text=\"(\"&str_sh&\")\"";
mostCurrent._lbl_shift_home.setText(BA.ObjectToCharSequence("("+_str_sh+")"));
 };
 } 
       catch (Exception e28) {
			processBA.setLastException(e28);RDebugUtils.currentLine=41680926;
 //BA.debugLineNum = 41680926;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("341680926",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=41680933;
 //BA.debugLineNum = 41680933;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=41615360;
 //BA.debugLineNum = 41615360;BA.debugLine="Sub chek_time_backup";
RDebugUtils.currentLine=41615364;
 //BA.debugLineNum = 41615364;BA.debugLine="If(File.Exists(File.DirInternal,\"chk_backup.txt\")";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"chk_backup.txt")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=41615365;
 //BA.debugLineNum = 41615365;BA.debugLine="File.WriteString(File.DirInternal,\"chk_backup.tx";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"chk_backup.txt",mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 }else {
RDebugUtils.currentLine=41615368;
 //BA.debugLineNum = 41615368;BA.debugLine="Dim tim1_ck_backup As String=File.ReadString(Fil";
_tim1_ck_backup = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"chk_backup.txt");
RDebugUtils.currentLine=41615369;
 //BA.debugLineNum = 41615369;BA.debugLine="Dim tim2_ck_backup As String=myfunc.fa2en(DateTi";
_tim2_ck_backup = mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=41615370;
 //BA.debugLineNum = 41615370;BA.debugLine="Dim time_between As Long = persianDate.Calculate";
_time_between = _persiandate.CalculateDaysBetween(_tim1_ck_backup,_tim2_ck_backup);
RDebugUtils.currentLine=41615372;
 //BA.debugLineNum = 41615372;BA.debugLine="Dim days_for_backup As Int";
_days_for_backup = 0;
RDebugUtils.currentLine=41615373;
 //BA.debugLineNum = 41615373;BA.debugLine="Dim res_backup As Int = dbCode.get_setting_byNam";
_res_backup = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"backup_online")));
RDebugUtils.currentLine=41615374;
 //BA.debugLineNum = 41615374;BA.debugLine="Select res_backup";
switch (_res_backup) {
case 0: {
RDebugUtils.currentLine=41615376;
 //BA.debugLineNum = 41615376;BA.debugLine="days_for_backup=7";
_days_for_backup = (int) (7);
 break; }
case 1: {
RDebugUtils.currentLine=41615378;
 //BA.debugLineNum = 41615378;BA.debugLine="days_for_backup=14";
_days_for_backup = (int) (14);
 break; }
case 2: {
RDebugUtils.currentLine=41615380;
 //BA.debugLineNum = 41615380;BA.debugLine="days_for_backup=30";
_days_for_backup = (int) (30);
 break; }
case 3: {
RDebugUtils.currentLine=41615382;
 //BA.debugLineNum = 41615382;BA.debugLine="days_for_backup=-1";
_days_for_backup = (int) (-1);
 break; }
}
;
RDebugUtils.currentLine=41615388;
 //BA.debugLineNum = 41615388;BA.debugLine="If(days_for_backup<0)Then";
if ((_days_for_backup<0)) { 
RDebugUtils.currentLine=41615389;
 //BA.debugLineNum = 41615389;BA.debugLine="is_time_backup=False";
_is_time_backup = anywheresoftware.b4a.keywords.Common.False;
 }else 
{RDebugUtils.currentLine=41615390;
 //BA.debugLineNum = 41615390;BA.debugLine="else If(time_between>= days_for_backup)Then";
if ((_time_between>=_days_for_backup)) { 
RDebugUtils.currentLine=41615391;
 //BA.debugLineNum = 41615391;BA.debugLine="is_time_backup=True";
_is_time_backup = anywheresoftware.b4a.keywords.Common.True;
 }}
;
 };
RDebugUtils.currentLine=41615398;
 //BA.debugLineNum = 41615398;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_account_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_account_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_account_click", null));}
int _result12 = 0;
RDebugUtils.currentLine=48234496;
 //BA.debugLineNum = 48234496;BA.debugLine="Private Sub lbl_account_Click";
RDebugUtils.currentLine=48234505;
 //BA.debugLineNum = 48234505;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=48234506;
 //BA.debugLineNum = 48234506;BA.debugLine="StartActivity(step2_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step2_activity.getObject()));
 }else {
RDebugUtils.currentLine=48234511;
 //BA.debugLineNum = 48234511;BA.debugLine="Dim result12 As Int";
_result12 = 0;
RDebugUtils.currentLine=48234512;
 //BA.debugLineNum = 48234512;BA.debugLine="result12 = Msgbox2(\"اتصال اینترنت را بررسی کنید\"";
_result12 = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("اتصال اینترنت را بررسی کنید"),BA.ObjectToCharSequence("توجه!"),"تلاش دوباره","","بستن",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=48234513;
 //BA.debugLineNum = 48234513;BA.debugLine="If result12 = DialogResponse.Positive Then";
if (_result12==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=48234514;
 //BA.debugLineNum = 48234514;BA.debugLine="lbl_account_Click";
_lbl_account_click();
 };
 };
RDebugUtils.currentLine=48234520;
 //BA.debugLineNum = 48234520;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
RDebugUtils.currentLine=48234521;
 //BA.debugLineNum = 48234521;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_list_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_menu_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_menu_list_click", null));}
RDebugUtils.currentLine=41746432;
 //BA.debugLineNum = 41746432;BA.debugLine="Private Sub btn_menu_list_Click";
RDebugUtils.currentLine=41746433;
 //BA.debugLineNum = 41746433;BA.debugLine="index_page=2";
_index_page = (int) (2);
RDebugUtils.currentLine=41746434;
 //BA.debugLineNum = 41746434;BA.debugLine="pan_imag.Background=img2";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img2.getObject()));
RDebugUtils.currentLine=41746436;
 //BA.debugLineNum = 41746436;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
RDebugUtils.currentLine=41746437;
 //BA.debugLineNum = 41746437;BA.debugLine="pan_main.LoadLayout(\"list_layout\")";
mostCurrent._pan_main.LoadLayout("list_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=41746439;
 //BA.debugLineNum = 41746439;BA.debugLine="sp_year.Add(\"1404\")";
mostCurrent._sp_year.Add("1404");
RDebugUtils.currentLine=41746440;
 //BA.debugLineNum = 41746440;BA.debugLine="sp_year.Add(\"1403\")";
mostCurrent._sp_year.Add("1403");
RDebugUtils.currentLine=41746441;
 //BA.debugLineNum = 41746441;BA.debugLine="sp_year.Add(\"1402\")";
mostCurrent._sp_year.Add("1402");
RDebugUtils.currentLine=41746442;
 //BA.debugLineNum = 41746442;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
RDebugUtils.currentLine=41746443;
 //BA.debugLineNum = 41746443;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
RDebugUtils.currentLine=41746444;
 //BA.debugLineNum = 41746444;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
RDebugUtils.currentLine=41746445;
 //BA.debugLineNum = 41746445;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
RDebugUtils.currentLine=41746447;
 //BA.debugLineNum = 41746447;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=41746450;
 //BA.debugLineNum = 41746450;BA.debugLine="sp_year.SelectedIndex=0";
mostCurrent._sp_year.setSelectedIndex((int) (0));
RDebugUtils.currentLine=41746451;
 //BA.debugLineNum = 41746451;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(persianDate.Pe";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))))-1));
RDebugUtils.currentLine=41746453;
 //BA.debugLineNum = 41746453;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(sp_moo";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=41746456;
 //BA.debugLineNum = 41746456;BA.debugLine="TabHost1.AddTab(\"اضافه کاری\" , \"tab_layout_ezafek";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"اضافه کاری","tab_layout_ezafekari.bal");
RDebugUtils.currentLine=41746457;
 //BA.debugLineNum = 41746457;BA.debugLine="TabHost1.AddTab(\"مرخصی\" , \"tab_layout_morakhasi.b";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"مرخصی","tab_layout_morakhasi.bal");
RDebugUtils.currentLine=41746458;
 //BA.debugLineNum = 41746458;BA.debugLine="TabHost1.AddTab(\"تردد\" , \"tab_layout_taradod.bal\"";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"تردد","tab_layout_taradod.bal");
RDebugUtils.currentLine=41746459;
 //BA.debugLineNum = 41746459;BA.debugLine="TabHost1.AddTab(\"مأموریت\" , \"tab_layout_mamoriat.";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"مأموریت","tab_layout_mamoriat.bal");
RDebugUtils.currentLine=41746461;
 //BA.debugLineNum = 41746461;BA.debugLine="TabHost1.CurrentTab=curent_tab_list";
mostCurrent._tabhost1.setCurrentTab(_curent_tab_list);
RDebugUtils.currentLine=41746463;
 //BA.debugLineNum = 41746463;BA.debugLine="list_ezafekari_id.Initialize";
mostCurrent._list_ezafekari_id.Initialize();
RDebugUtils.currentLine=41746466;
 //BA.debugLineNum = 41746466;BA.debugLine="list_morakhasi_id.Initialize";
mostCurrent._list_morakhasi_id.Initialize();
RDebugUtils.currentLine=41746469;
 //BA.debugLineNum = 41746469;BA.debugLine="list_taradod_id.Initialize";
mostCurrent._list_taradod_id.Initialize();
RDebugUtils.currentLine=41746472;
 //BA.debugLineNum = 41746472;BA.debugLine="list_mamoriat_id.Initialize";
mostCurrent._list_mamoriat_id.Initialize();
RDebugUtils.currentLine=41746476;
 //BA.debugLineNum = 41746476;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=41746480;
 //BA.debugLineNum = 41746480;BA.debugLine="pan_hed_list.Color=color4";
mostCurrent._pan_hed_list.setColor(_color4);
RDebugUtils.currentLine=41746487;
 //BA.debugLineNum = 41746487;BA.debugLine="End Sub";
return "";
}
public static String  _btneight_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btneight_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btneight_click", null));}
RDebugUtils.currentLine=41287680;
 //BA.debugLineNum = 41287680;BA.debugLine="Sub btnEight_Click";
RDebugUtils.currentLine=41287681;
 //BA.debugLineNum = 41287681;BA.debugLine="click_count_Increment_and_fill(btnEight.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btneight.getText());
RDebugUtils.currentLine=41287682;
 //BA.debugLineNum = 41287682;BA.debugLine="End Sub";
return "";
}
public static String  _click_count_increment_and_fill(String _input_text) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "click_count_increment_and_fill", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "click_count_increment_and_fill", new Object[] {_input_text}));}
RDebugUtils.currentLine=41418752;
 //BA.debugLineNum = 41418752;BA.debugLine="Sub click_count_Increment_and_fill (input_Text As";
RDebugUtils.currentLine=41418754;
 //BA.debugLineNum = 41418754;BA.debugLine="Click_Count = Click_Count + 1";
_click_count = (int) (_click_count+1);
RDebugUtils.currentLine=41418756;
 //BA.debugLineNum = 41418756;BA.debugLine="Select Click_Count";
switch (_click_count) {
case 1: {
RDebugUtils.currentLine=41418758;
 //BA.debugLineNum = 41418758;BA.debugLine="key1.Color = Colors.Red";
mostCurrent._key1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=41418761;
 //BA.debugLineNum = 41418761;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 2: {
RDebugUtils.currentLine=41418764;
 //BA.debugLineNum = 41418764;BA.debugLine="key2.Color = Colors.Red";
mostCurrent._key2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=41418767;
 //BA.debugLineNum = 41418767;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 3: {
RDebugUtils.currentLine=41418770;
 //BA.debugLineNum = 41418770;BA.debugLine="key3.Color = Colors.Red";
mostCurrent._key3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=41418773;
 //BA.debugLineNum = 41418773;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 4: {
RDebugUtils.currentLine=41418776;
 //BA.debugLineNum = 41418776;BA.debugLine="key4.Color = Colors.Red";
mostCurrent._key4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=41418779;
 //BA.debugLineNum = 41418779;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
RDebugUtils.currentLine=41418785;
 //BA.debugLineNum = 41418785;BA.debugLine="If entered_Password = Master_Password Then";
if ((mostCurrent._entered_password).equals(mostCurrent._master_password)) { 
RDebugUtils.currentLine=41418788;
 //BA.debugLineNum = 41418788;BA.debugLine="resetting_all";
_resetting_all();
RDebugUtils.currentLine=41418790;
 //BA.debugLineNum = 41418790;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=41418792;
 //BA.debugLineNum = 41418792;BA.debugLine="ToastMessageShow(\"رمز عبور اشتباه است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("رمز عبور اشتباه است"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=41418796;
 //BA.debugLineNum = 41418796;BA.debugLine="resetting_all";
_resetting_all();
 };
 break; }
}
;
RDebugUtils.currentLine=41418801;
 //BA.debugLineNum = 41418801;BA.debugLine="End Sub";
return "";
}
public static String  _btnfive_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnfive_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnfive_click", null));}
RDebugUtils.currentLine=41091072;
 //BA.debugLineNum = 41091072;BA.debugLine="Sub btnFive_Click";
RDebugUtils.currentLine=41091073;
 //BA.debugLineNum = 41091073;BA.debugLine="click_count_Increment_and_fill(btnFive.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnfive.getText());
RDebugUtils.currentLine=41091074;
 //BA.debugLineNum = 41091074;BA.debugLine="End Sub";
return "";
}
public static String  _btnfour_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnfour_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnfour_click", null));}
RDebugUtils.currentLine=41025536;
 //BA.debugLineNum = 41025536;BA.debugLine="Sub btnFour_Click";
RDebugUtils.currentLine=41025537;
 //BA.debugLineNum = 41025537;BA.debugLine="click_count_Increment_and_fill(btnFour.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnfour.getText());
RDebugUtils.currentLine=41025538;
 //BA.debugLineNum = 41025538;BA.debugLine="End Sub";
return "";
}
public static String  _btnnine_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnnine_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnnine_click", null));}
RDebugUtils.currentLine=41353216;
 //BA.debugLineNum = 41353216;BA.debugLine="Sub btnNine_Click";
RDebugUtils.currentLine=41353217;
 //BA.debugLineNum = 41353217;BA.debugLine="click_count_Increment_and_fill(btnNine.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnnine.getText());
RDebugUtils.currentLine=41353218;
 //BA.debugLineNum = 41353218;BA.debugLine="End Sub";
return "";
}
public static String  _btnone_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnone_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnone_click", null));}
RDebugUtils.currentLine=40828928;
 //BA.debugLineNum = 40828928;BA.debugLine="Sub btnOne_Click";
RDebugUtils.currentLine=40828929;
 //BA.debugLineNum = 40828929;BA.debugLine="click_count_Increment_and_fill(btnOne.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btnone.getText());
RDebugUtils.currentLine=40828930;
 //BA.debugLineNum = 40828930;BA.debugLine="End Sub";
return "";
}
public static String  _btnseven_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnseven_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnseven_click", null));}
RDebugUtils.currentLine=41222144;
 //BA.debugLineNum = 41222144;BA.debugLine="Sub btnSeven_Click";
RDebugUtils.currentLine=41222145;
 //BA.debugLineNum = 41222145;BA.debugLine="click_count_Increment_and_fill(btnSeven.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btnseven.getText());
RDebugUtils.currentLine=41222146;
 //BA.debugLineNum = 41222146;BA.debugLine="End Sub";
return "";
}
public static String  _btnsix_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnsix_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnsix_click", null));}
RDebugUtils.currentLine=41156608;
 //BA.debugLineNum = 41156608;BA.debugLine="Sub btnSix_Click";
RDebugUtils.currentLine=41156609;
 //BA.debugLineNum = 41156609;BA.debugLine="click_count_Increment_and_fill(btnSix.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btnsix.getText());
RDebugUtils.currentLine=41156610;
 //BA.debugLineNum = 41156610;BA.debugLine="End Sub";
return "";
}
public static String  _btnthree_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnthree_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnthree_click", null));}
RDebugUtils.currentLine=40960000;
 //BA.debugLineNum = 40960000;BA.debugLine="Sub btnThree_Click";
RDebugUtils.currentLine=40960001;
 //BA.debugLineNum = 40960001;BA.debugLine="click_count_Increment_and_fill(btnThree.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btnthree.getText());
RDebugUtils.currentLine=40960002;
 //BA.debugLineNum = 40960002;BA.debugLine="End Sub";
return "";
}
public static String  _btntwo_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btntwo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btntwo_click", null));}
RDebugUtils.currentLine=40894464;
 //BA.debugLineNum = 40894464;BA.debugLine="Sub btnTwo_Click";
RDebugUtils.currentLine=40894465;
 //BA.debugLineNum = 40894465;BA.debugLine="click_count_Increment_and_fill(btnTwo.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btntwo.getText());
RDebugUtils.currentLine=40894466;
 //BA.debugLineNum = 40894466;BA.debugLine="End Sub";
return "";
}
public static String  _btnzero_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnzero_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnzero_click", null));}
RDebugUtils.currentLine=40763392;
 //BA.debugLineNum = 40763392;BA.debugLine="Sub btnZero_Click";
RDebugUtils.currentLine=40763393;
 //BA.debugLineNum = 40763393;BA.debugLine="click_count_Increment_and_fill(btnZero.Text)";
_click_count_increment_and_fill(mostCurrent._btnzero.getText());
RDebugUtils.currentLine=40763394;
 //BA.debugLineNum = 40763394;BA.debugLine="End Sub";
return "";
}
public static int  _chek_tatil_day(int _year1,int _moon1,int _day1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chek_tatil_day", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "chek_tatil_day", new Object[] {_year1,_moon1,_day1}));}
int _id_thisday = 0;
int _result_int = 0;
RDebugUtils.currentLine=45416448;
 //BA.debugLineNum = 45416448;BA.debugLine="Sub chek_tatil_day (year1 As Int,moon1 As Int, day";
RDebugUtils.currentLine=45416450;
 //BA.debugLineNum = 45416450;BA.debugLine="Dim id_thisDay As Int";
_id_thisday = 0;
RDebugUtils.currentLine=45416451;
 //BA.debugLineNum = 45416451;BA.debugLine="id_thisDay=dbCode.get_day_id(year1,moon1,day1)";
_id_thisday = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_year1,_moon1,_day1);
RDebugUtils.currentLine=45416453;
 //BA.debugLineNum = 45416453;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=45416454;
 //BA.debugLineNum = 45416454;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id_thisday))));
RDebugUtils.currentLine=45416456;
 //BA.debugLineNum = 45416456;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=45416459;
 //BA.debugLineNum = 45416459;BA.debugLine="Dim result_int As Int=0";
_result_int = (int) (0);
RDebugUtils.currentLine=45416460;
 //BA.debugLineNum = 45416460;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=45416461;
 //BA.debugLineNum = 45416461;BA.debugLine="result_int=1";
_result_int = (int) (1);
 }else 
{RDebugUtils.currentLine=45416462;
 //BA.debugLineNum = 45416462;BA.debugLine="else If (dbCode.res.GetString(\"state\") = \"tatil1\"";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil1"))) { 
RDebugUtils.currentLine=45416463;
 //BA.debugLineNum = 45416463;BA.debugLine="result_int=2";
_result_int = (int) (2);
 }}
;
RDebugUtils.currentLine=45416470;
 //BA.debugLineNum = 45416470;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=45416471;
 //BA.debugLineNum = 45416471;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=45416474;
 //BA.debugLineNum = 45416474;BA.debugLine="Return result_int    ' result_int=0 is not tatil";
if (true) return _result_int;
RDebugUtils.currentLine=45416476;
 //BA.debugLineNum = 45416476;BA.debugLine="End Sub";
return 0;
}
public static int  _chek_tatil_setting() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chek_tatil_setting", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "chek_tatil_setting", null));}
int _temp = 0;
int _sett_a = 0;
int _sett_b = 0;
RDebugUtils.currentLine=45481984;
 //BA.debugLineNum = 45481984;BA.debugLine="Sub chek_tatil_setting As Int";
RDebugUtils.currentLine=45481985;
 //BA.debugLineNum = 45481985;BA.debugLine="Dim temp As Int=0";
_temp = (int) (0);
RDebugUtils.currentLine=45481986;
 //BA.debugLineNum = 45481986;BA.debugLine="Dim sett_a ,sett_b  As Int=0";
_sett_a = 0;
_sett_b = (int) (0);
RDebugUtils.currentLine=45481988;
 //BA.debugLineNum = 45481988;BA.debugLine="sett_a=dbCode.get_setting_byName(\"setting_tatil_r";
_sett_a = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi")));
RDebugUtils.currentLine=45481989;
 //BA.debugLineNum = 45481989;BA.debugLine="sett_b=dbCode.get_setting_byName(\"setting_tatil_g";
_sett_b = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi")));
RDebugUtils.currentLine=45481992;
 //BA.debugLineNum = 45481992;BA.debugLine="If(sett_a=1)Then";
if ((_sett_a==1)) { 
RDebugUtils.currentLine=45481993;
 //BA.debugLineNum = 45481993;BA.debugLine="temp=11";
_temp = (int) (11);
RDebugUtils.currentLine=45481994;
 //BA.debugLineNum = 45481994;BA.debugLine="If (sett_b=1)Then";
if ((_sett_b==1)) { 
RDebugUtils.currentLine=45481995;
 //BA.debugLineNum = 45481995;BA.debugLine="temp=1";
_temp = (int) (1);
 };
 }else {
RDebugUtils.currentLine=45481999;
 //BA.debugLineNum = 45481999;BA.debugLine="temp=0";
_temp = (int) (0);
RDebugUtils.currentLine=45482000;
 //BA.debugLineNum = 45482000;BA.debugLine="If (sett_b=1)Then";
if ((_sett_b==1)) { 
RDebugUtils.currentLine=45482001;
 //BA.debugLineNum = 45482001;BA.debugLine="temp=22";
_temp = (int) (22);
 };
 };
RDebugUtils.currentLine=45482006;
 //BA.debugLineNum = 45482006;BA.debugLine="Return temp";
if (true) return _temp;
RDebugUtils.currentLine=45482008;
 //BA.debugLineNum = 45482008;BA.debugLine="End Sub";
return 0;
}
public static String  _chk_update_auto() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chk_update_auto", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chk_update_auto", null));}
String _send2 = "";
RDebugUtils.currentLine=48168960;
 //BA.debugLineNum = 48168960;BA.debugLine="Sub chk_update_auto";
RDebugUtils.currentLine=48168962;
 //BA.debugLineNum = 48168962;BA.debugLine="user_request_update=False";
_user_request_update = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=48168963;
 //BA.debugLineNum = 48168963;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=48168965;
 //BA.debugLineNum = 48168965;BA.debugLine="ht.Initialize(\"chkupdate\",Me)";
mostCurrent._ht._initialize /*String*/ (null,processBA,"chkupdate",main.getObject());
RDebugUtils.currentLine=48168966;
 //BA.debugLineNum = 48168966;BA.debugLine="Dim send2 As String";
_send2 = "";
RDebugUtils.currentLine=48168967;
 //BA.debugLineNum = 48168967;BA.debugLine="send2 = \"var=checkupdate\"";
_send2 = "var=checkupdate";
RDebugUtils.currentLine=48168968;
 //BA.debugLineNum = 48168968;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/chek_upda";
mostCurrent._ht._poststring /*String*/ (null,"https://taravatgroup.ir/chek_update.php",_send2);
 };
RDebugUtils.currentLine=48168971;
 //BA.debugLineNum = 48168971;BA.debugLine="End Sub";
return "";
}
public static String  _ckb_ezaf_taradod_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ckb_ezaf_taradod_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ckb_ezaf_taradod_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=48562176;
 //BA.debugLineNum = 48562176;BA.debugLine="Private Sub ckb_ezaf_taradod_CheckedChange(Checked";
RDebugUtils.currentLine=48562177;
 //BA.debugLineNum = 48562177;BA.debugLine="If(Checked=True)Then";
if ((_checked==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=48562178;
 //BA.debugLineNum = 48562178;BA.debugLine="radio_ez_adi.Enabled=True";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=48562179;
 //BA.debugLineNum = 48562179;BA.debugLine="radio_ez_fog.Enabled=True";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=48562181;
 //BA.debugLineNum = 48562181;BA.debugLine="radio_ez_adi.Enabled=False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48562182;
 //BA.debugLineNum = 48562182;BA.debugLine="radio_ez_fog.Enabled=False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=48562184;
 //BA.debugLineNum = 48562184;BA.debugLine="End Sub";
return "";
}
public static String  _ckb_ezaf_taradod_fs_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ckb_ezaf_taradod_fs_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ckb_ezaf_taradod_fs_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=49479680;
 //BA.debugLineNum = 49479680;BA.debugLine="Private Sub ckb_ezaf_taradod_fs_CheckedChange(Chec";
RDebugUtils.currentLine=49479681;
 //BA.debugLineNum = 49479681;BA.debugLine="If(Checked=True)Then";
if ((_checked==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=49479682;
 //BA.debugLineNum = 49479682;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=49479684;
 //BA.debugLineNum = 49479684;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=49479686;
 //BA.debugLineNum = 49479686;BA.debugLine="End Sub";
return "";
}
public static String  _resetting_all() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "resetting_all", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "resetting_all", null));}
RDebugUtils.currentLine=41484288;
 //BA.debugLineNum = 41484288;BA.debugLine="Sub resetting_all";
RDebugUtils.currentLine=41484290;
 //BA.debugLineNum = 41484290;BA.debugLine="key1.color = Colors.White";
mostCurrent._key1.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=41484291;
 //BA.debugLineNum = 41484291;BA.debugLine="key2.Color = Colors.White";
mostCurrent._key2.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=41484292;
 //BA.debugLineNum = 41484292;BA.debugLine="key3.Color = Colors.White";
mostCurrent._key3.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=41484293;
 //BA.debugLineNum = 41484293;BA.debugLine="key4.Color = Colors.white";
mostCurrent._key4.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=41484296;
 //BA.debugLineNum = 41484296;BA.debugLine="entered_Password = \"\"";
mostCurrent._entered_password = "";
RDebugUtils.currentLine=41484300;
 //BA.debugLineNum = 41484300;BA.debugLine="Click_Count = 0";
_click_count = (int) (0);
RDebugUtils.currentLine=41484301;
 //BA.debugLineNum = 41484301;BA.debugLine="End Sub";
return "";
}
public static String  _cust_lv_taradod_itemclick(int _index,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cust_lv_taradod_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cust_lv_taradod_itemclick", new Object[] {_index,_value}));}
RDebugUtils.currentLine=47251456;
 //BA.debugLineNum = 47251456;BA.debugLine="Private Sub cust_LV_taradod_ItemClick (Index As In";
RDebugUtils.currentLine=47251458;
 //BA.debugLineNum = 47251458;BA.debugLine="End Sub";
return "";
}
public static String  _tabhost1_tabchanged() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tabhost1_tabchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tabhost1_tabchanged", null));}
anywheresoftware.b4a.objects.collections.List _ls_all_saat = null;
String _str_saat = "";
RDebugUtils.currentLine=41811968;
 //BA.debugLineNum = 41811968;BA.debugLine="Private Sub TabHost1_TabChanged";
RDebugUtils.currentLine=41811970;
 //BA.debugLineNum = 41811970;BA.debugLine="Dim ls_all_saat As List";
_ls_all_saat = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=41811971;
 //BA.debugLineNum = 41811971;BA.debugLine="ls_all_saat.Initialize";
_ls_all_saat.Initialize();
RDebugUtils.currentLine=41811972;
 //BA.debugLineNum = 41811972;BA.debugLine="Dim str_saat As String";
_str_saat = "";
RDebugUtils.currentLine=41811974;
 //BA.debugLineNum = 41811974;BA.debugLine="If(sp_year.IsInitialized)Then";
if ((mostCurrent._sp_year.IsInitialized())) { 
RDebugUtils.currentLine=41811980;
 //BA.debugLineNum = 41811980;BA.debugLine="Select TabHost1.CurrentTab";
switch (BA.switchObjectToInt(mostCurrent._tabhost1.getCurrentTab(),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
RDebugUtils.currentLine=41811982;
 //BA.debugLineNum = 41811982;BA.debugLine="ls_all_saat=dbCode.all_ezafekari_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
RDebugUtils.currentLine=41811983;
 //BA.debugLineNum = 41811983;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
case 1: {
RDebugUtils.currentLine=41811985;
 //BA.debugLineNum = 41811985;BA.debugLine="ls_all_saat=dbCode.all_morakhasi_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=41811987;
 //BA.debugLineNum = 41811987;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" روز و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" ساعت و "+BA.ObjectToString(_ls_all_saat.Get((int) (2)))+" دقیقه ";
 break; }
case 2: {
RDebugUtils.currentLine=41811989;
 //BA.debugLineNum = 41811989;BA.debugLine="ls_all_saat=dbCode.all_taradod_mah(myfunc.fa2e";
_ls_all_saat = mostCurrent._dbcode._all_taradod_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=41811990;
 //BA.debugLineNum = 41811990;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
case 3: {
RDebugUtils.currentLine=41811992;
 //BA.debugLineNum = 41811992;BA.debugLine="ls_all_saat=dbCode.all_mamoriat_mah(myfunc.fa2";
_ls_all_saat = mostCurrent._dbcode._all_mamoriat_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=41811993;
 //BA.debugLineNum = 41811993;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" روز و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" ساعت و "+BA.ObjectToString(_ls_all_saat.Get((int) (2)))+" دقیقه ";
 break; }
}
;
RDebugUtils.currentLine=41812000;
 //BA.debugLineNum = 41812000;BA.debugLine="lbl_majmoe_saat.Text=str_saat";
mostCurrent._lbl_majmoe_saat.setText(BA.ObjectToCharSequence(_str_saat));
 };
RDebugUtils.currentLine=41812006;
 //BA.debugLineNum = 41812006;BA.debugLine="End Sub";
return "";
}
public static String  _finger_scaning() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "finger_scaning", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "finger_scaning", null));}
RDebugUtils.currentLine=40632320;
 //BA.debugLineNum = 40632320;BA.debugLine="Sub finger_scaning";
RDebugUtils.currentLine=40632321;
 //BA.debugLineNum = 40632321;BA.debugLine="fingerprint.Authenticate";
mostCurrent._fingerprint._authenticate /*String*/ (null);
RDebugUtils.currentLine=40632322;
 //BA.debugLineNum = 40632322;BA.debugLine="ToastMessageShow(\"Scanning...\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Scanning..."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=40632323;
 //BA.debugLineNum = 40632323;BA.debugLine="End Sub";
return "";
}
public static String  _get_dataedit_byid(int _id1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_dataedit_byid", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_dataedit_byid", new Object[] {_id1}));}
RDebugUtils.currentLine=46333952;
 //BA.debugLineNum = 46333952;BA.debugLine="Sub get_dataEdit_byId(id1 As Int)";
RDebugUtils.currentLine=46333953;
 //BA.debugLineNum = 46333953;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=46333954;
 //BA.debugLineNum = 46333954;BA.debugLine="If(index_box=1)Then";
if ((_index_box==1)) { 
RDebugUtils.currentLine=46333955;
 //BA.debugLineNum = 46333955;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=46333956;
 //BA.debugLineNum = 46333956;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=46333958;
 //BA.debugLineNum = 46333958;BA.debugLine="If(dbCode.res.GetInt(\"state\")=0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==0)) { 
RDebugUtils.currentLine=46333959;
 //BA.debugLineNum = 46333959;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=46333961;
 //BA.debugLineNum = 46333961;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
 }else 
{RDebugUtils.currentLine=46333966;
 //BA.debugLineNum = 46333966;BA.debugLine="Else If(index_box=2)Then";
if ((_index_box==2)) { 
RDebugUtils.currentLine=46333967;
 //BA.debugLineNum = 46333967;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=46333968;
 //BA.debugLineNum = 46333968;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=46333971;
 //BA.debugLineNum = 46333971;BA.debugLine="Select dbCode.res.GetInt(\"state\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
RDebugUtils.currentLine=46333973;
 //BA.debugLineNum = 46333973;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
RDebugUtils.currentLine=46333975;
 //BA.debugLineNum = 46333975;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
RDebugUtils.currentLine=46333977;
 //BA.debugLineNum = 46333977;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
RDebugUtils.currentLine=46333979;
 //BA.debugLineNum = 46333979;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
RDebugUtils.currentLine=46333983;
 //BA.debugLineNum = 46333983;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
RDebugUtils.currentLine=46333984;
 //BA.debugLineNum = 46333984;BA.debugLine="index_noe_morakhasi=dbCode.res.GetInt(\"state\")";
_index_noe_morakhasi = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state");
 }else 
{RDebugUtils.currentLine=46333988;
 //BA.debugLineNum = 46333988;BA.debugLine="Else If(index_box=3)Then";
if ((_index_box==3)) { 
RDebugUtils.currentLine=46333989;
 //BA.debugLineNum = 46333989;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=46333990;
 //BA.debugLineNum = 46333990;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 }else 
{RDebugUtils.currentLine=46333993;
 //BA.debugLineNum = 46333993;BA.debugLine="Else If(index_box=5)Then";
if ((_index_box==5)) { 
RDebugUtils.currentLine=46333994;
 //BA.debugLineNum = 46333994;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mamoriat WHERE id="+BA.NumberToString(_id1))));
RDebugUtils.currentLine=46333995;
 //BA.debugLineNum = 46333995;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 }}}}
;
RDebugUtils.currentLine=46334002;
 //BA.debugLineNum = 46334002;BA.debugLine="lbl_tim1.Text=dbCode.res.GetString(\"time_from\")";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")));
RDebugUtils.currentLine=46334003;
 //BA.debugLineNum = 46334003;BA.debugLine="lbl_tim2.Text=dbCode.res.GetString(\"time_to\")";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=46334005;
 //BA.debugLineNum = 46334005;BA.debugLine="lbl_date1.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
RDebugUtils.currentLine=46334006;
 //BA.debugLineNum = 46334006;BA.debugLine="lbl_date2.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))));
RDebugUtils.currentLine=46334008;
 //BA.debugLineNum = 46334008;BA.debugLine="et_tozihat.Text=dbCode.res.GetString(\"tozihat\")";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=46334011;
 //BA.debugLineNum = 46334011;BA.debugLine="End Sub";
return "";
}
public static String  _get_request_kharid() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_request_kharid", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_request_kharid", null));}
ir.cafebazaar.poolakey.b4a.B4APurchaseRequest _request = null;
RDebugUtils.currentLine=40435712;
 //BA.debugLineNum = 40435712;BA.debugLine="Sub get_request_kharid";
RDebugUtils.currentLine=40435713;
 //BA.debugLineNum = 40435713;BA.debugLine="Dim Request As PoolakeyPurchaseRequest";
_request = new ir.cafebazaar.poolakey.b4a.B4APurchaseRequest();
RDebugUtils.currentLine=40435714;
 //BA.debugLineNum = 40435714;BA.debugLine="Request.ProductId = \"ezafekari2\"";
_request.setProductId("ezafekari2");
RDebugUtils.currentLine=40435715;
 //BA.debugLineNum = 40435715;BA.debugLine="Request.Payload = \"PAYLOAD\"";
_request.setPayload("PAYLOAD");
RDebugUtils.currentLine=40435717;
 //BA.debugLineNum = 40435717;BA.debugLine="Poolakey.PurchaseProduct(\"Purchase\", Request)";
mostCurrent._poolakey.PurchaseProduct(mostCurrent.activityBA,"Purchase",_request);
RDebugUtils.currentLine=40435720;
 //BA.debugLineNum = 40435720;BA.debugLine="End Sub";
return "";
}
public static String  _img_slider(int _index1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "img_slider", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "img_slider", new Object[] {_index1}));}
RDebugUtils.currentLine=46202880;
 //BA.debugLineNum = 46202880;BA.debugLine="Sub img_slider (index1 As Int)";
RDebugUtils.currentLine=46202881;
 //BA.debugLineNum = 46202881;BA.debugLine="Select index1";
switch (_index1) {
case 0: {
RDebugUtils.currentLine=46202883;
 //BA.debugLineNum = 46202883;BA.debugLine="img_help.Bitmap=bit_img0";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img0.getObject()));
 break; }
case 1: {
RDebugUtils.currentLine=46202885;
 //BA.debugLineNum = 46202885;BA.debugLine="img_help.Bitmap=bit_img1";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img1.getObject()));
 break; }
case 2: {
RDebugUtils.currentLine=46202888;
 //BA.debugLineNum = 46202888;BA.debugLine="img_help.Bitmap=bit_img2";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img2.getObject()));
 break; }
case 3: {
RDebugUtils.currentLine=46202891;
 //BA.debugLineNum = 46202891;BA.debugLine="img_help.Bitmap=bit_img3";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img3.getObject()));
 break; }
case 4: {
RDebugUtils.currentLine=46202894;
 //BA.debugLineNum = 46202894;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
 break; }
default: {
RDebugUtils.currentLine=46202897;
 //BA.debugLineNum = 46202897;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("346202897","error",0);
 break; }
}
;
RDebugUtils.currentLine=46202900;
 //BA.debugLineNum = 46202900;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=39649280;
 //BA.debugLineNum = 39649280;BA.debugLine="Sub Jobdone (job As HttpJob)";
RDebugUtils.currentLine=39649281;
 //BA.debugLineNum = 39649281;BA.debugLine="Try";
try {RDebugUtils.currentLine=39649283;
 //BA.debugLineNum = 39649283;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=39649284;
 //BA.debugLineNum = 39649284;BA.debugLine="If job.JobName=\"ht\" Then";
if ((_job._jobname /*String*/ ).equals("ht")) { 
RDebugUtils.currentLine=39649285;
 //BA.debugLineNum = 39649285;BA.debugLine="If(job.GetString <> \"\")Then";
if (((_job._getstring /*String*/ (null)).equals("") == false)) { 
RDebugUtils.currentLine=39649287;
 //BA.debugLineNum = 39649287;BA.debugLine="Log(job.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("339649287",_job._getstring /*String*/ (null),0);
RDebugUtils.currentLine=39649289;
 //BA.debugLineNum = 39649289;BA.debugLine="Dim Json_Data As JSONParser";
_json_data = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=39649291;
 //BA.debugLineNum = 39649291;BA.debugLine="Json_Data.Initialize(job.GetString)";
_json_data.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=39649293;
 //BA.debugLineNum = 39649293;BA.debugLine="Dim ListData_fromJson As List";
_listdata_fromjson = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=39649294;
 //BA.debugLineNum = 39649294;BA.debugLine="ListData_fromJson.Initialize";
_listdata_fromjson.Initialize();
RDebugUtils.currentLine=39649295;
 //BA.debugLineNum = 39649295;BA.debugLine="ListData_fromJson=Json_Data.NextArray";
_listdata_fromjson = _json_data.NextArray();
RDebugUtils.currentLine=39649299;
 //BA.debugLineNum = 39649299;BA.debugLine="Dim date_Json0 As String = ListData_fromJson.";
_date_json0 = BA.ObjectToString(_listdata_fromjson.Get((int) (0)));
RDebugUtils.currentLine=39649300;
 //BA.debugLineNum = 39649300;BA.debugLine="date_Json0=date_Json0.Replace(\"serv_key:\",\"\")";
_date_json0 = _date_json0.replace("serv_key:","");
RDebugUtils.currentLine=39649301;
 //BA.debugLineNum = 39649301;BA.debugLine="Dim date_Json1 As String = ListData_fromJson.";
_date_json1 = BA.ObjectToString(_listdata_fromjson.Get((int) (1)));
RDebugUtils.currentLine=39649302;
 //BA.debugLineNum = 39649302;BA.debugLine="date_Json1=date_Json1.Replace(\"serv_lock:\",\"\"";
_date_json1 = _date_json1.replace("serv_lock:","");
RDebugUtils.currentLine=39649303;
 //BA.debugLineNum = 39649303;BA.debugLine="Dim date_Json2 As String = ListData_fromJson.";
_date_json2 = BA.ObjectToString(_listdata_fromjson.Get((int) (2)));
RDebugUtils.currentLine=39649304;
 //BA.debugLineNum = 39649304;BA.debugLine="date_Json2=date_Json2.Replace(\"serv_activer:\"";
_date_json2 = _date_json2.replace("serv_activer:","");
RDebugUtils.currentLine=39649305;
 //BA.debugLineNum = 39649305;BA.debugLine="Dim date_Json3 As String = ListData_fromJson.";
_date_json3 = BA.ObjectToString(_listdata_fromjson.Get((int) (3)));
RDebugUtils.currentLine=39649306;
 //BA.debugLineNum = 39649306;BA.debugLine="date_Json3=date_Json3.Replace(\"serv_msg_code:";
_date_json3 = _date_json3.replace("serv_msg_code:","");
RDebugUtils.currentLine=39649307;
 //BA.debugLineNum = 39649307;BA.debugLine="Dim date_Json4 As String = ListData_fromJson.";
_date_json4 = BA.ObjectToString(_listdata_fromjson.Get((int) (4)));
RDebugUtils.currentLine=39649308;
 //BA.debugLineNum = 39649308;BA.debugLine="date_Json4=date_Json4.Replace(\"serv_msg:\",\"\")";
_date_json4 = _date_json4.replace("serv_msg:","");
RDebugUtils.currentLine=39649309;
 //BA.debugLineNum = 39649309;BA.debugLine="Dim date_Json5 As String = ListData_fromJson.";
_date_json5 = BA.ObjectToString(_listdata_fromjson.Get((int) (5)));
RDebugUtils.currentLine=39649310;
 //BA.debugLineNum = 39649310;BA.debugLine="date_Json5=date_Json5.Replace(\"serv_notif_cod";
_date_json5 = _date_json5.replace("serv_notif_code:","");
RDebugUtils.currentLine=39649311;
 //BA.debugLineNum = 39649311;BA.debugLine="Dim date_Json6 As String = ListData_fromJson.";
_date_json6 = BA.ObjectToString(_listdata_fromjson.Get((int) (6)));
RDebugUtils.currentLine=39649312;
 //BA.debugLineNum = 39649312;BA.debugLine="date_Json6=date_Json6.Replace(\"serv_notif:\",\"";
_date_json6 = _date_json6.replace("serv_notif:","");
RDebugUtils.currentLine=39649313;
 //BA.debugLineNum = 39649313;BA.debugLine="Dim date_Json7 As String = ListData_fromJson.";
_date_json7 = BA.ObjectToString(_listdata_fromjson.Get((int) (7)));
RDebugUtils.currentLine=39649314;
 //BA.debugLineNum = 39649314;BA.debugLine="date_Json7=date_Json7.Replace(\"serv_status:\",";
_date_json7 = _date_json7.replace("serv_status:","");
RDebugUtils.currentLine=39649315;
 //BA.debugLineNum = 39649315;BA.debugLine="Dim date_Json8 As String = ListData_fromJson.";
_date_json8 = BA.ObjectToString(_listdata_fromjson.Get((int) (8)));
RDebugUtils.currentLine=39649316;
 //BA.debugLineNum = 39649316;BA.debugLine="date_Json8=date_Json8.Replace(\"serv_err:\",\"\")";
_date_json8 = _date_json8.replace("serv_err:","");
RDebugUtils.currentLine=39649317;
 //BA.debugLineNum = 39649317;BA.debugLine="Dim date_Json9 As String = ListData_fromJson.";
_date_json9 = BA.ObjectToString(_listdata_fromjson.Get((int) (9)));
RDebugUtils.currentLine=39649318;
 //BA.debugLineNum = 39649318;BA.debugLine="date_Json9=date_Json9.Replace(\"serv_err_msg:\"";
_date_json9 = _date_json9.replace("serv_err_msg:","");
RDebugUtils.currentLine=39649321;
 //BA.debugLineNum = 39649321;BA.debugLine="Log(\"date_Json0:   \"&date_Json0)";
anywheresoftware.b4a.keywords.Common.LogImpl("339649321","date_Json0:   "+_date_json0,0);
RDebugUtils.currentLine=39649322;
 //BA.debugLineNum = 39649322;BA.debugLine="Log(\"date_Json1:   \"&date_Json1)";
anywheresoftware.b4a.keywords.Common.LogImpl("339649322","date_Json1:   "+_date_json1,0);
RDebugUtils.currentLine=39649323;
 //BA.debugLineNum = 39649323;BA.debugLine="Log(\"date_Json2:   \"&date_Json2)";
anywheresoftware.b4a.keywords.Common.LogImpl("339649323","date_Json2:   "+_date_json2,0);
RDebugUtils.currentLine=39649324;
 //BA.debugLineNum = 39649324;BA.debugLine="Log(\"date_Json3:   \"&date_Json3)";
anywheresoftware.b4a.keywords.Common.LogImpl("339649324","date_Json3:   "+_date_json3,0);
RDebugUtils.currentLine=39649325;
 //BA.debugLineNum = 39649325;BA.debugLine="Log(\"date_Json4:   \"&date_Json4)";
anywheresoftware.b4a.keywords.Common.LogImpl("339649325","date_Json4:   "+_date_json4,0);
RDebugUtils.currentLine=39649326;
 //BA.debugLineNum = 39649326;BA.debugLine="Log(\"date_Json5:   \"&date_Json5)";
anywheresoftware.b4a.keywords.Common.LogImpl("339649326","date_Json5:   "+_date_json5,0);
RDebugUtils.currentLine=39649327;
 //BA.debugLineNum = 39649327;BA.debugLine="Log(\"date_Json6:   \"&date_Json6)";
anywheresoftware.b4a.keywords.Common.LogImpl("339649327","date_Json6:   "+_date_json6,0);
RDebugUtils.currentLine=39649328;
 //BA.debugLineNum = 39649328;BA.debugLine="Log(\"date_Json7:   \"&date_Json7)";
anywheresoftware.b4a.keywords.Common.LogImpl("339649328","date_Json7:   "+_date_json7,0);
RDebugUtils.currentLine=39649329;
 //BA.debugLineNum = 39649329;BA.debugLine="Log(\"date_Json8:   \"&date_Json8)";
anywheresoftware.b4a.keywords.Common.LogImpl("339649329","date_Json8:   "+_date_json8,0);
RDebugUtils.currentLine=39649330;
 //BA.debugLineNum = 39649330;BA.debugLine="Log(\"date_Json9:   \"&date_Json9)";
anywheresoftware.b4a.keywords.Common.LogImpl("339649330","date_Json9:   "+_date_json9,0);
RDebugUtils.currentLine=39649332;
 //BA.debugLineNum = 39649332;BA.debugLine="If(date_Json0=\"wresv435fgd4443gfg\")Then";
if (((_date_json0).equals("wresv435fgd4443gfg"))) { 
RDebugUtils.currentLine=39649335;
 //BA.debugLineNum = 39649335;BA.debugLine="If (date_Json1=\"lockok\")Then";
if (((_date_json1).equals("lockok"))) { 
RDebugUtils.currentLine=39649337;
 //BA.debugLineNum = 39649337;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=39649338;
 //BA.debugLineNum = 39649338;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
RDebugUtils.currentLine=39649340;
 //BA.debugLineNum = 39649340;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=39649341;
 //BA.debugLineNum = 39649341;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"l";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
RDebugUtils.currentLine=39649342;
 //BA.debugLineNum = 39649342;BA.debugLine="ls_lock0.Set(0,\"true\")";
_ls_lock0.Set((int) (0),(Object)("true"));
RDebugUtils.currentLine=39649343;
 //BA.debugLineNum = 39649343;BA.debugLine="ls_lock0.Set(1,\"false\")";
_ls_lock0.Set((int) (1),(Object)("false"));
RDebugUtils.currentLine=39649344;
 //BA.debugLineNum = 39649344;BA.debugLine="ls_lock0.Set(2,\"2022\")";
_ls_lock0.Set((int) (2),(Object)("2022"));
 }else {
RDebugUtils.currentLine=39649346;
 //BA.debugLineNum = 39649346;BA.debugLine="ls_lock0.Add(\"true\")";
_ls_lock0.Add((Object)("true"));
RDebugUtils.currentLine=39649347;
 //BA.debugLineNum = 39649347;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
RDebugUtils.currentLine=39649348;
 //BA.debugLineNum = 39649348;BA.debugLine="ls_lock0.Add(\"2022\")";
_ls_lock0.Add((Object)("2022"));
RDebugUtils.currentLine=39649349;
 //BA.debugLineNum = 39649349;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 };
RDebugUtils.currentLine=39649351;
 //BA.debugLineNum = 39649351;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",l";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock0);
 }else 
{RDebugUtils.currentLine=39649353;
 //BA.debugLineNum = 39649353;BA.debugLine="Else If (date_Json1=\"lockno\")Then  ''-------";
if (((_date_json1).equals("lockno"))) { 
RDebugUtils.currentLine=39649354;
 //BA.debugLineNum = 39649354;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=39649355;
 //BA.debugLineNum = 39649355;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
RDebugUtils.currentLine=39649357;
 //BA.debugLineNum = 39649357;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=39649358;
 //BA.debugLineNum = 39649358;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"l";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
RDebugUtils.currentLine=39649359;
 //BA.debugLineNum = 39649359;BA.debugLine="ls_lock0.Set(0,\"false\")";
_ls_lock0.Set((int) (0),(Object)("false"));
RDebugUtils.currentLine=39649360;
 //BA.debugLineNum = 39649360;BA.debugLine="ls_lock0.Set(1,\"false\")";
_ls_lock0.Set((int) (1),(Object)("false"));
RDebugUtils.currentLine=39649361;
 //BA.debugLineNum = 39649361;BA.debugLine="ls_lock0.Set(2,\"\")";
_ls_lock0.Set((int) (2),(Object)(""));
 }else {
RDebugUtils.currentLine=39649363;
 //BA.debugLineNum = 39649363;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
RDebugUtils.currentLine=39649364;
 //BA.debugLineNum = 39649364;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
RDebugUtils.currentLine=39649365;
 //BA.debugLineNum = 39649365;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
RDebugUtils.currentLine=39649366;
 //BA.debugLineNum = 39649366;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 };
RDebugUtils.currentLine=39649368;
 //BA.debugLineNum = 39649368;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",l";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock0);
 }}
;
RDebugUtils.currentLine=39649372;
 //BA.debugLineNum = 39649372;BA.debugLine="If(date_Json2=\"accessok\")Then";
if (((_date_json2).equals("accessok"))) { 
RDebugUtils.currentLine=39649375;
 //BA.debugLineNum = 39649375;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\")";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
 }else {
RDebugUtils.currentLine=39649378;
 //BA.debugLineNum = 39649378;BA.debugLine="File.WriteString(File.DirInternal,\"payokok";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
RDebugUtils.currentLine=39649379;
 //BA.debugLineNum = 39649379;BA.debugLine="myfunc.help_man(\"توجه\",\"نسخه طلایی از طرف";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","نسخه طلایی از طرف ادمین فعال شد");
 };
 }else 
{RDebugUtils.currentLine=39649383;
 //BA.debugLineNum = 39649383;BA.debugLine="Else If (date_Json2=\"accessno\")Then";
if (((_date_json2).equals("accessno"))) { 
RDebugUtils.currentLine=39649385;
 //BA.debugLineNum = 39649385;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\")";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
RDebugUtils.currentLine=39649386;
 //BA.debugLineNum = 39649386;BA.debugLine="File.Delete(File.DirInternal,\"payokok\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok");
RDebugUtils.currentLine=39649387;
 //BA.debugLineNum = 39649387;BA.debugLine="myfunc.help_man(\"توجه\",\" نسخه طلایی از طرف";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه"," نسخه طلایی از طرف ادمین غیرفعال شد");
 };
 }}
;
RDebugUtils.currentLine=39649394;
 //BA.debugLineNum = 39649394;BA.debugLine="If (date_Json5<>\"0\")Then   ''-------new_noti";
if (((_date_json5).equals("0") == false)) { 
RDebugUtils.currentLine=39649398;
 //BA.debugLineNum = 39649398;BA.debugLine="notif_code=date_Json5";
mostCurrent._notif_code = _date_json5;
RDebugUtils.currentLine=39649399;
 //BA.debugLineNum = 39649399;BA.debugLine="notif_matn=date_Json6";
mostCurrent._notif_matn = _date_json6;
RDebugUtils.currentLine=39649400;
 //BA.debugLineNum = 39649400;BA.debugLine="tim_msg.Enabled=True";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=39649404;
 //BA.debugLineNum = 39649404;BA.debugLine="If (date_Json3<>\"0\")Then   ''-------new_noti";
if (((_date_json3).equals("0") == false)) { 
 };
 }else {
RDebugUtils.currentLine=39649414;
 //BA.debugLineNum = 39649414;BA.debugLine="ToastMessageShow(\"ارتباط با سرور برقرار نشد.";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط با سرور برقرار نشد."),anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=39649498;
 //BA.debugLineNum = 39649498;BA.debugLine="If job.JobName=\"chkupdate\" Then";
if ((_job._jobname /*String*/ ).equals("chkupdate")) { 
RDebugUtils.currentLine=39649500;
 //BA.debugLineNum = 39649500;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=39649502;
 //BA.debugLineNum = 39649502;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=39649504;
 //BA.debugLineNum = 39649504;BA.debugLine="Dim root1 As List";
_root1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=39649505;
 //BA.debugLineNum = 39649505;BA.debugLine="root1.Initialize";
_root1.Initialize();
RDebugUtils.currentLine=39649506;
 //BA.debugLineNum = 39649506;BA.debugLine="root1=parser.NextArray";
_root1 = _parser.NextArray();
RDebugUtils.currentLine=39649508;
 //BA.debugLineNum = 39649508;BA.debugLine="Dim str_type As String = root1.Get(0)";
_str_type = BA.ObjectToString(_root1.Get((int) (0)));
RDebugUtils.currentLine=39649509;
 //BA.debugLineNum = 39649509;BA.debugLine="str_type= str_type.Replace(\"type:\",\"\")";
_str_type = _str_type.replace("type:","");
RDebugUtils.currentLine=39649511;
 //BA.debugLineNum = 39649511;BA.debugLine="Dim str_version_code As String = root1.Get(1)";
_str_version_code = BA.ObjectToString(_root1.Get((int) (1)));
RDebugUtils.currentLine=39649512;
 //BA.debugLineNum = 39649512;BA.debugLine="str_version_code=str_version_code.Replace(\"ver";
_str_version_code = _str_version_code.replace("version_code:","");
RDebugUtils.currentLine=39649514;
 //BA.debugLineNum = 39649514;BA.debugLine="Dim str_version_name As String = root1.Get(2)";
_str_version_name = BA.ObjectToString(_root1.Get((int) (2)));
RDebugUtils.currentLine=39649515;
 //BA.debugLineNum = 39649515;BA.debugLine="str_version_name=str_version_name.Replace(\"ver";
_str_version_name = _str_version_name.replace("version_name:","");
RDebugUtils.currentLine=39649517;
 //BA.debugLineNum = 39649517;BA.debugLine="Dim str_changelog_fa As String = root1.Get(3)";
_str_changelog_fa = BA.ObjectToString(_root1.Get((int) (3)));
RDebugUtils.currentLine=39649518;
 //BA.debugLineNum = 39649518;BA.debugLine="str_changelog_fa=str_changelog_fa.Replace(\"cha";
_str_changelog_fa = _str_changelog_fa.replace("changelog_fa:","");
RDebugUtils.currentLine=39649520;
 //BA.debugLineNum = 39649520;BA.debugLine="Dim str_message As String = root1.Get(4)";
_str_message = BA.ObjectToString(_root1.Get((int) (4)));
RDebugUtils.currentLine=39649521;
 //BA.debugLineNum = 39649521;BA.debugLine="str_message=str_message.Replace(\"message:\",\"\")";
_str_message = _str_message.replace("message:","");
RDebugUtils.currentLine=39649528;
 //BA.debugLineNum = 39649528;BA.debugLine="If(user_request_update=True)Then";
if ((_user_request_update==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=39649530;
 //BA.debugLineNum = 39649530;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=39649531;
 //BA.debugLineNum = 39649531;BA.debugLine="pan_all_chekUpdate.Visible=True";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=39649533;
 //BA.debugLineNum = 39649533;BA.debugLine="If(str_type==\"success\")Then";
if (((_str_type).equals("success"))) { 
RDebugUtils.currentLine=39649534;
 //BA.debugLineNum = 39649534;BA.debugLine="If(str_version_code>Application.VersionCode)";
if (((double)(Double.parseDouble(_str_version_code))>anywheresoftware.b4a.keywords.Common.Application.getVersionCode())) { 
RDebugUtils.currentLine=39649535;
 //BA.debugLineNum = 39649535;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body><span style='color:#3AAD00; font-weight: bold;'> بروزرسانی جدید موجود است. </span><br> "+_str_changelog_fa+"</body></html>");
RDebugUtils.currentLine=39649536;
 //BA.debugLineNum = 39649536;BA.debugLine="lbl_chk_update_ok.Tag=1";
mostCurrent._lbl_chk_update_ok.setTag((Object)(1));
RDebugUtils.currentLine=39649537;
 //BA.debugLineNum = 39649537;BA.debugLine="lbl_chk_update_ok.Text=\"بروزرسانی برنامه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("بروزرسانی برنامه"));
 }else {
RDebugUtils.currentLine=39649539;
 //BA.debugLineNum = 39649539;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body> برنامه شما بروز می باشد. با تشکر </body></html>");
RDebugUtils.currentLine=39649540;
 //BA.debugLineNum = 39649540;BA.debugLine="lbl_chk_update_ok.Tag=0";
mostCurrent._lbl_chk_update_ok.setTag((Object)(0));
RDebugUtils.currentLine=39649541;
 //BA.debugLineNum = 39649541;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("باشه"));
 };
 }else 
{RDebugUtils.currentLine=39649544;
 //BA.debugLineNum = 39649544;BA.debugLine="Else if (str_type==\"unsuccess\")Then";
if (((_str_type).equals("unsuccess"))) { 
RDebugUtils.currentLine=39649545;
 //BA.debugLineNum = 39649545;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl'";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>خطا در اتصال</body></html>");
RDebugUtils.currentLine=39649546;
 //BA.debugLineNum = 39649546;BA.debugLine="lbl_chk_update_ok.Tag=0";
mostCurrent._lbl_chk_update_ok.setTag((Object)(0));
RDebugUtils.currentLine=39649547;
 //BA.debugLineNum = 39649547;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("باشه"));
 }}
;
 }else {
RDebugUtils.currentLine=39649555;
 //BA.debugLineNum = 39649555;BA.debugLine="If(str_type==\"success\")Then";
if (((_str_type).equals("success"))) { 
RDebugUtils.currentLine=39649557;
 //BA.debugLineNum = 39649557;BA.debugLine="If(str_version_code>Application.VersionCode)";
if (((double)(Double.parseDouble(_str_version_code))>anywheresoftware.b4a.keywords.Common.Application.getVersionCode())) { 
RDebugUtils.currentLine=39649558;
 //BA.debugLineNum = 39649558;BA.debugLine="pan_all_chekUpdate.Visible=True";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=39649560;
 //BA.debugLineNum = 39649560;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body><span style='color:#3AAD00; font-weight: bold;'> بروزرسانی جدید موجود است. </span><br> "+_str_changelog_fa+"</body></html>");
RDebugUtils.currentLine=39649561;
 //BA.debugLineNum = 39649561;BA.debugLine="lbl_chk_update_ok.Tag=1";
mostCurrent._lbl_chk_update_ok.setTag((Object)(1));
RDebugUtils.currentLine=39649562;
 //BA.debugLineNum = 39649562;BA.debugLine="lbl_chk_update_ok.Text=\"بروزرسانی برنامه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("بروزرسانی برنامه"));
 };
 };
 };
 };
 }else {
 };
 } 
       catch (Exception e145) {
			processBA.setLastException(e145);RDebugUtils.currentLine=39649577;
 //BA.debugLineNum = 39649577;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("339649577",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=39649578;
 //BA.debugLineNum = 39649578;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=39649581;
 //BA.debugLineNum = 39649581;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=39976969;
 //BA.debugLineNum = 39976969;BA.debugLine="If(myfunc.check_internet)Then";
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
RDebugUtils.currentLine=39976970;
 //BA.debugLineNum = 39976970;BA.debugLine="Try";
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
RDebugUtils.currentLine=39976973;
 //BA.debugLineNum = 39976973;BA.debugLine="Poolakey.Connect(\"Poolakey\")";
parent.mostCurrent._poolakey.Connect(mostCurrent.activityBA,"Poolakey");
RDebugUtils.currentLine=39976974;
 //BA.debugLineNum = 39976974;BA.debugLine="Wait For Poolakey_ConnectionSucceed";
anywheresoftware.b4a.keywords.Common.WaitFor("poolakey_connectionsucceed", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "kharid"), null);
this.state = 13;
return;
case 13:
//C
this.state = 9;
;
RDebugUtils.currentLine=39976980;
 //BA.debugLineNum = 39976980;BA.debugLine="Poolakey.GetPurchasedProducts(\"Query\")";
parent.mostCurrent._poolakey.GetPurchasedProducts(mostCurrent.activityBA,"Query");
 if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
RDebugUtils.currentLine=39976983;
 //BA.debugLineNum = 39976983;BA.debugLine="MsgboxAsync(\"1- از نصب بودن برنامه بازار اطمینا";
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
RDebugUtils.currentLine=39976986;
 //BA.debugLineNum = 39976986;BA.debugLine="ToastMessageShow(\"خطا در اتصال \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال "),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 12:
//C
this.state = -1;
;
RDebugUtils.currentLine=39976992;
 //BA.debugLineNum = 39976992;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=47513600;
 //BA.debugLineNum = 47513600;BA.debugLine="Private Sub pan_all_liteMenu_Click";
RDebugUtils.currentLine=47513601;
 //BA.debugLineNum = 47513601;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=47513602;
 //BA.debugLineNum = 47513602;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chk_update_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_chk_update_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_chk_update_click", null));}
String _send2 = "";
RDebugUtils.currentLine=48103424;
 //BA.debugLineNum = 48103424;BA.debugLine="Private Sub lbl_chk_update_Click";
RDebugUtils.currentLine=48103426;
 //BA.debugLineNum = 48103426;BA.debugLine="user_request_update=True";
_user_request_update = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=48103427;
 //BA.debugLineNum = 48103427;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=48103428;
 //BA.debugLineNum = 48103428;BA.debugLine="ProgressDialogShow(\"بررسی بروزرسانی ...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("بررسی بروزرسانی ..."));
RDebugUtils.currentLine=48103429;
 //BA.debugLineNum = 48103429;BA.debugLine="ht.Initialize(\"chkupdate\",Me)";
mostCurrent._ht._initialize /*String*/ (null,processBA,"chkupdate",main.getObject());
RDebugUtils.currentLine=48103430;
 //BA.debugLineNum = 48103430;BA.debugLine="Dim send2 As String";
_send2 = "";
RDebugUtils.currentLine=48103431;
 //BA.debugLineNum = 48103431;BA.debugLine="send2 = \"var=checkupdate\"";
_send2 = "var=checkupdate";
RDebugUtils.currentLine=48103432;
 //BA.debugLineNum = 48103432;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/chek_upda";
mostCurrent._ht._poststring /*String*/ (null,"https://taravatgroup.ir/chek_update.php",_send2);
 }else {
RDebugUtils.currentLine=48103434;
 //BA.debugLineNum = 48103434;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 };
RDebugUtils.currentLine=48103438;
 //BA.debugLineNum = 48103438;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
RDebugUtils.currentLine=48103439;
 //BA.debugLineNum = 48103439;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chk_update_ok_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_chk_update_ok_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_chk_update_ok_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _op = null;
RDebugUtils.currentLine=48431104;
 //BA.debugLineNum = 48431104;BA.debugLine="Private Sub lbl_chk_update_ok_Click";
RDebugUtils.currentLine=48431105;
 //BA.debugLineNum = 48431105;BA.debugLine="If (lbl_chk_update_ok.Tag==1)Then";
if (((mostCurrent._lbl_chk_update_ok.getTag()).equals((Object)(1)))) { 
RDebugUtils.currentLine=48431106;
 //BA.debugLineNum = 48431106;BA.debugLine="Try";
try {RDebugUtils.currentLine=48431107;
 //BA.debugLineNum = 48431107;BA.debugLine="Dim op As Intent";
_op = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=48431108;
 //BA.debugLineNum = 48431108;BA.debugLine="op.Initialize(op.ACTION_VIEW,\"bazaar://details?";
_op.Initialize(_op.ACTION_VIEW,"bazaar://details?id=ir.taravatgroup.ezafekari2");
RDebugUtils.currentLine=48431109;
 //BA.debugLineNum = 48431109;BA.debugLine="op.SetPackage(\"com.farsitel.bazaar\")";
_op.SetPackage("com.farsitel.bazaar");
RDebugUtils.currentLine=48431110;
 //BA.debugLineNum = 48431110;BA.debugLine="StartActivity(op)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_op.getObject()));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=48431112;
 //BA.debugLineNum = 48431112;BA.debugLine="myfunc.help_man(\"توجه\",\"برنامه بازار را نصب کنی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","برنامه بازار را نصب کنید !");
RDebugUtils.currentLine=48431114;
 //BA.debugLineNum = 48431114;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("348431114",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
RDebugUtils.currentLine=48431121;
 //BA.debugLineNum = 48431121;BA.debugLine="pan_all_chekUpdate_Click";
_pan_all_chekupdate_click();
RDebugUtils.currentLine=48431122;
 //BA.debugLineNum = 48431122;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_chekupdate_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_chekupdate_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_chekupdate_click", null));}
RDebugUtils.currentLine=48300032;
 //BA.debugLineNum = 48300032;BA.debugLine="Private Sub pan_all_chekUpdate_Click";
RDebugUtils.currentLine=48300033;
 //BA.debugLineNum = 48300033;BA.debugLine="pan_all_chekUpdate.Visible=False";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48300034;
 //BA.debugLineNum = 48300034;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_msgnewy_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_msgnewy_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_msgnewy_click", null));}
RDebugUtils.currentLine=39452672;
 //BA.debugLineNum = 39452672;BA.debugLine="Private Sub lbl_close_msgNewY_Click";
RDebugUtils.currentLine=39452674;
 //BA.debugLineNum = 39452674;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=39452675;
 //BA.debugLineNum = 39452675;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date1_click", null));}
RDebugUtils.currentLine=45154304;
 //BA.debugLineNum = 45154304;BA.debugLine="Private Sub lbl_date1_Click";
RDebugUtils.currentLine=45154305;
 //BA.debugLineNum = 45154305;BA.debugLine="lbl_tim1_Click";
_lbl_tim1_click();
RDebugUtils.currentLine=45154306;
 //BA.debugLineNum = 45154306;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_tim1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_tim1_click", null));}
RDebugUtils.currentLine=45219840;
 //BA.debugLineNum = 45219840;BA.debugLine="Private Sub lbl_tim1_Click";
RDebugUtils.currentLine=45219841;
 //BA.debugLineNum = 45219841;BA.debugLine="index_piker=1";
_index_piker = (int) (1);
RDebugUtils.currentLine=45219843;
 //BA.debugLineNum = 45219843;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim1.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (0))));
RDebugUtils.currentLine=45219844;
 //BA.debugLineNum = 45219844;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim1.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (1))));
RDebugUtils.currentLine=45219846;
 //BA.debugLineNum = 45219846;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date1.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (0))));
RDebugUtils.currentLine=45219847;
 //BA.debugLineNum = 45219847;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (1)));
RDebugUtils.currentLine=45219848;
 //BA.debugLineNum = 45219848;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=45219849;
 //BA.debugLineNum = 45219849;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (2))));
RDebugUtils.currentLine=45219853;
 //BA.debugLineNum = 45219853;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=45219855;
 //BA.debugLineNum = 45219855;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=45219856;
 //BA.debugLineNum = 45219856;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=45219857;
 //BA.debugLineNum = 45219857;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
RDebugUtils.currentLine=45219858;
 //BA.debugLineNum = 45219858;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
RDebugUtils.currentLine=45219859;
 //BA.debugLineNum = 45219859;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
RDebugUtils.currentLine=45219862;
 //BA.debugLineNum = 45219862;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date2_click", null));}
RDebugUtils.currentLine=45088768;
 //BA.debugLineNum = 45088768;BA.debugLine="Private Sub lbl_date2_Click";
RDebugUtils.currentLine=45088769;
 //BA.debugLineNum = 45088769;BA.debugLine="lbl_tim2_Click";
_lbl_tim2_click();
RDebugUtils.currentLine=45088770;
 //BA.debugLineNum = 45088770;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_tim2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_tim2_click", null));}
RDebugUtils.currentLine=45023232;
 //BA.debugLineNum = 45023232;BA.debugLine="Private Sub lbl_tim2_Click";
RDebugUtils.currentLine=45023233;
 //BA.debugLineNum = 45023233;BA.debugLine="index_piker=2";
_index_piker = (int) (2);
RDebugUtils.currentLine=45023234;
 //BA.debugLineNum = 45023234;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim2.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (0))));
RDebugUtils.currentLine=45023235;
 //BA.debugLineNum = 45023235;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim2.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (1))));
RDebugUtils.currentLine=45023237;
 //BA.debugLineNum = 45023237;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date2.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (0))));
RDebugUtils.currentLine=45023238;
 //BA.debugLineNum = 45023238;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (1)));
RDebugUtils.currentLine=45023239;
 //BA.debugLineNum = 45023239;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=45023240;
 //BA.debugLineNum = 45023240;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (2))));
RDebugUtils.currentLine=45023243;
 //BA.debugLineNum = 45023243;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=45023246;
 //BA.debugLineNum = 45023246;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=45023247;
 //BA.debugLineNum = 45023247;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=45023248;
 //BA.debugLineNum = 45023248;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
RDebugUtils.currentLine=45023249;
 //BA.debugLineNum = 45023249;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
RDebugUtils.currentLine=45023250;
 //BA.debugLineNum = 45023250;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
RDebugUtils.currentLine=45023252;
 //BA.debugLineNum = 45023252;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_from_list_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
RDebugUtils.currentLine=46268416;
 //BA.debugLineNum = 46268416;BA.debugLine="Private Sub lbl_edit_from_list_Click";
RDebugUtils.currentLine=46268417;
 //BA.debugLineNum = 46268417;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=46268418;
 //BA.debugLineNum = 46268418;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=46268419;
 //BA.debugLineNum = 46268419;BA.debugLine="Log(b.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("346268419",BA.ObjectToString(_b.getTag()),0);
RDebugUtils.currentLine=46268420;
 //BA.debugLineNum = 46268420;BA.debugLine="current_id_edit=b.Tag";
_current_id_edit = (int)(BA.ObjectToNumber(_b.getTag()));
RDebugUtils.currentLine=46268424;
 //BA.debugLineNum = 46268424;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
RDebugUtils.currentLine=46268425;
 //BA.debugLineNum = 46268425;BA.debugLine="pan_add_ezafekari_Click";
_pan_add_ezafekari_click();
RDebugUtils.currentLine=46268426;
 //BA.debugLineNum = 46268426;BA.debugLine="lbl_box_title.Text=\"ویرایش اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش اضافه کاری"));
 }else 
{RDebugUtils.currentLine=46268428;
 //BA.debugLineNum = 46268428;BA.debugLine="Else if (TabHost1.CurrentTab=1)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==1)) { 
RDebugUtils.currentLine=46268429;
 //BA.debugLineNum = 46268429;BA.debugLine="pan_add_morakhasi_Click";
_pan_add_morakhasi_click();
RDebugUtils.currentLine=46268430;
 //BA.debugLineNum = 46268430;BA.debugLine="lbl_box_title.Text=\"ویرایش مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش مرخصی"));
 }else 
{RDebugUtils.currentLine=46268432;
 //BA.debugLineNum = 46268432;BA.debugLine="Else if (TabHost1.CurrentTab=2)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==2)) { 
RDebugUtils.currentLine=46268433;
 //BA.debugLineNum = 46268433;BA.debugLine="pan_add_taradod_Click";
_pan_add_taradod_click();
RDebugUtils.currentLine=46268434;
 //BA.debugLineNum = 46268434;BA.debugLine="lbl_box_title.Text=\"ویرایش تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش تردد"));
RDebugUtils.currentLine=46268436;
 //BA.debugLineNum = 46268436;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46268437;
 //BA.debugLineNum = 46268437;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46268439;
 //BA.debugLineNum = 46268439;BA.debugLine="myfunc.help_man(\"توجه\",\"اگر برای این تردد اضافه";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اگر برای این تردد اضافه کاری ثبت شده است، لازم است آن را هم ویرایش کنید.");
 }else 
{RDebugUtils.currentLine=46268440;
 //BA.debugLineNum = 46268440;BA.debugLine="Else if (TabHost1.CurrentTab=3)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==3)) { 
RDebugUtils.currentLine=46268441;
 //BA.debugLineNum = 46268441;BA.debugLine="pan_add_mamoriat_Click";
_pan_add_mamoriat_click();
RDebugUtils.currentLine=46268442;
 //BA.debugLineNum = 46268442;BA.debugLine="lbl_box_title.Text=\"ویرایش مأموریت\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش مأموریت"));
 }}}}
;
RDebugUtils.currentLine=46268445;
 //BA.debugLineNum = 46268445;BA.debugLine="is_for_edit=True";
_is_for_edit = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=46268446;
 //BA.debugLineNum = 46268446;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46268447;
 //BA.debugLineNum = 46268447;BA.debugLine="get_dataEdit_byId(current_id_edit)";
_get_dataedit_byid(_current_id_edit);
RDebugUtils.currentLine=46268451;
 //BA.debugLineNum = 46268451;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46268452;
 //BA.debugLineNum = 46268452;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=46268456;
 //BA.debugLineNum = 46268456;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=46268460;
 //BA.debugLineNum = 46268460;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_ezafekari_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_ezafekari_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_ezafekari_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
RDebugUtils.currentLine=42532864;
 //BA.debugLineNum = 42532864;BA.debugLine="Private Sub pan_add_ezafekari_Click";
RDebugUtils.currentLine=42532865;
 //BA.debugLineNum = 42532865;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=42532866;
 //BA.debugLineNum = 42532866;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=42532867;
 //BA.debugLineNum = 42532867;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42532868;
 //BA.debugLineNum = 42532868;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42532869;
 //BA.debugLineNum = 42532869;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=42532870;
 //BA.debugLineNum = 42532870;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=42532871;
 //BA.debugLineNum = 42532871;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42532873;
 //BA.debugLineNum = 42532873;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42532874;
 //BA.debugLineNum = 42532874;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42532876;
 //BA.debugLineNum = 42532876;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42532877;
 //BA.debugLineNum = 42532877;BA.debugLine="lbl_box_title.Text=\"ثبت اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت اضافه کاری"));
RDebugUtils.currentLine=42532878;
 //BA.debugLineNum = 42532878;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
RDebugUtils.currentLine=42532879;
 //BA.debugLineNum = 42532879;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
RDebugUtils.currentLine=42532880;
 //BA.debugLineNum = 42532880;BA.debugLine="index_box=1";
_index_box = (int) (1);
RDebugUtils.currentLine=42532881;
 //BA.debugLineNum = 42532881;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42532882;
 //BA.debugLineNum = 42532882;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42532883;
 //BA.debugLineNum = 42532883;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42532884;
 //BA.debugLineNum = 42532884;BA.debugLine="lbl_ezaf_taradod.Text=\"فوق العاده (جمعه کاری)\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("فوق العاده (جمعه کاری)"));
RDebugUtils.currentLine=42532885;
 //BA.debugLineNum = 42532885;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=42532886;
 //BA.debugLineNum = 42532886;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42532887;
 //BA.debugLineNum = 42532887;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42532888;
 //BA.debugLineNum = 42532888;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42532893;
 //BA.debugLineNum = 42532893;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
RDebugUtils.currentLine=42532894;
 //BA.debugLineNum = 42532894;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
RDebugUtils.currentLine=42532895;
 //BA.debugLineNum = 42532895;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=42532896;
 //BA.debugLineNum = 42532896;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
RDebugUtils.currentLine=42532899;
 //BA.debugLineNum = 42532899;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42532900;
 //BA.debugLineNum = 42532900;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42532904;
 //BA.debugLineNum = 42532904;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_from_ezafe";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=42532905;
 //BA.debugLineNum = 42532905;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=42532906;
 //BA.debugLineNum = 42532906;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=42532907;
 //BA.debugLineNum = 42532907;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_f";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt");
RDebugUtils.currentLine=42532912;
 //BA.debugLineNum = 42532912;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42532916;
 //BA.debugLineNum = 42532916;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
RDebugUtils.currentLine=42532918;
 //BA.debugLineNum = 42532918;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42532919;
 //BA.debugLineNum = 42532919;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=42532923;
 //BA.debugLineNum = 42532923;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_to_ezafeka";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=42532924;
 //BA.debugLineNum = 42532924;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=42532925;
 //BA.debugLineNum = 42532925;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=42532926;
 //BA.debugLineNum = 42532926;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt");
RDebugUtils.currentLine=42532932;
 //BA.debugLineNum = 42532932;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42532936;
 //BA.debugLineNum = 42532936;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
RDebugUtils.currentLine=42532938;
 //BA.debugLineNum = 42532938;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42532939;
 //BA.debugLineNum = 42532939;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=42532944;
 //BA.debugLineNum = 42532944;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42532946;
 //BA.debugLineNum = 42532946;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=42532949;
 //BA.debugLineNum = 42532949;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_morakhasi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_morakhasi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_morakhasi_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
RDebugUtils.currentLine=42336256;
 //BA.debugLineNum = 42336256;BA.debugLine="Private Sub pan_add_morakhasi_Click";
RDebugUtils.currentLine=42336257;
 //BA.debugLineNum = 42336257;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=42336258;
 //BA.debugLineNum = 42336258;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=42336259;
 //BA.debugLineNum = 42336259;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42336260;
 //BA.debugLineNum = 42336260;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42336262;
 //BA.debugLineNum = 42336262;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=42336264;
 //BA.debugLineNum = 42336264;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=42336265;
 //BA.debugLineNum = 42336265;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42336267;
 //BA.debugLineNum = 42336267;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42336268;
 //BA.debugLineNum = 42336268;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42336270;
 //BA.debugLineNum = 42336270;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42336271;
 //BA.debugLineNum = 42336271;BA.debugLine="lbl_box_title.Text=\"ثبت مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت مرخصی"));
RDebugUtils.currentLine=42336272;
 //BA.debugLineNum = 42336272;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
RDebugUtils.currentLine=42336273;
 //BA.debugLineNum = 42336273;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
RDebugUtils.currentLine=42336274;
 //BA.debugLineNum = 42336274;BA.debugLine="index_box=2";
_index_box = (int) (2);
RDebugUtils.currentLine=42336275;
 //BA.debugLineNum = 42336275;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42336276;
 //BA.debugLineNum = 42336276;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42336277;
 //BA.debugLineNum = 42336277;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
RDebugUtils.currentLine=42336278;
 //BA.debugLineNum = 42336278;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42336279;
 //BA.debugLineNum = 42336279;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
RDebugUtils.currentLine=42336280;
 //BA.debugLineNum = 42336280;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Red";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=42336281;
 //BA.debugLineNum = 42336281;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42336282;
 //BA.debugLineNum = 42336282;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42336287;
 //BA.debugLineNum = 42336287;BA.debugLine="rsPOP_noe.Initialize(\"rsPOP_noe\",lbl_ezaf_taradod";
mostCurrent._rspop_noe.Initialize(mostCurrent.activityBA,"rsPOP_noe",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_ezaf_taradod.getObject())));
RDebugUtils.currentLine=42336289;
 //BA.debugLineNum = 42336289;BA.debugLine="rsPOP_noe.AddMenuItem(0,0,\"استحقاقی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (0),(int) (0),"استحقاقی");
RDebugUtils.currentLine=42336290;
 //BA.debugLineNum = 42336290;BA.debugLine="rsPOP_noe.AddMenuItem(1,1,\"استعلاجی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (1),(int) (1),"استعلاجی");
RDebugUtils.currentLine=42336291;
 //BA.debugLineNum = 42336291;BA.debugLine="rsPOP_noe.AddMenuItem(2,2,\"سایر (با حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (2),(int) (2),"سایر (با حقوق)");
RDebugUtils.currentLine=42336292;
 //BA.debugLineNum = 42336292;BA.debugLine="rsPOP_noe.AddMenuItem(3,3,\"سایر (بدون حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (3),(int) (3),"سایر (بدون حقوق)");
RDebugUtils.currentLine=42336297;
 //BA.debugLineNum = 42336297;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
RDebugUtils.currentLine=42336298;
 //BA.debugLineNum = 42336298;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
RDebugUtils.currentLine=42336299;
 //BA.debugLineNum = 42336299;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=42336300;
 //BA.debugLineNum = 42336300;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
RDebugUtils.currentLine=42336303;
 //BA.debugLineNum = 42336303;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42336304;
 //BA.debugLineNum = 42336304;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42336310;
 //BA.debugLineNum = 42336310;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_from_morak";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=42336311;
 //BA.debugLineNum = 42336311;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=42336312;
 //BA.debugLineNum = 42336312;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=42336313;
 //BA.debugLineNum = 42336313;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_f";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt");
RDebugUtils.currentLine=42336318;
 //BA.debugLineNum = 42336318;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42336322;
 //BA.debugLineNum = 42336322;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
RDebugUtils.currentLine=42336324;
 //BA.debugLineNum = 42336324;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42336325;
 //BA.debugLineNum = 42336325;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=42336329;
 //BA.debugLineNum = 42336329;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_to_morakha";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=42336330;
 //BA.debugLineNum = 42336330;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=42336331;
 //BA.debugLineNum = 42336331;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=42336332;
 //BA.debugLineNum = 42336332;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt");
RDebugUtils.currentLine=42336337;
 //BA.debugLineNum = 42336337;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42336341;
 //BA.debugLineNum = 42336341;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
RDebugUtils.currentLine=42336343;
 //BA.debugLineNum = 42336343;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42336344;
 //BA.debugLineNum = 42336344;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=42336349;
 //BA.debugLineNum = 42336349;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42336351;
 //BA.debugLineNum = 42336351;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=42336355;
 //BA.debugLineNum = 42336355;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=42598400;
 //BA.debugLineNum = 42598400;BA.debugLine="Private Sub pan_add_taradod_Click";
RDebugUtils.currentLine=42598403;
 //BA.debugLineNum = 42598403;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=42598404;
 //BA.debugLineNum = 42598404;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42598405;
 //BA.debugLineNum = 42598405;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=42598406;
 //BA.debugLineNum = 42598406;BA.debugLine="radio_ez_adi.Visible=True";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42598407;
 //BA.debugLineNum = 42598407;BA.debugLine="radio_ez_fog.Visible=True";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42598408;
 //BA.debugLineNum = 42598408;BA.debugLine="radio_ez_adi.Checked=True";
mostCurrent._radio_ez_adi.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42598409;
 //BA.debugLineNum = 42598409;BA.debugLine="radio_ez_fog.Checked=False";
mostCurrent._radio_ez_fog.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42598411;
 //BA.debugLineNum = 42598411;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42598412;
 //BA.debugLineNum = 42598412;BA.debugLine="lbl_box_title.Text=\"ثبت تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت تردد"));
RDebugUtils.currentLine=42598413;
 //BA.debugLineNum = 42598413;BA.debugLine="lbl_time_as.Text=\"ورود :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("ورود :"));
RDebugUtils.currentLine=42598414;
 //BA.debugLineNum = 42598414;BA.debugLine="lbl_time_ta.Text=\"خروج :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("خروج :"));
RDebugUtils.currentLine=42598415;
 //BA.debugLineNum = 42598415;BA.debugLine="index_box=3";
_index_box = (int) (3);
RDebugUtils.currentLine=42598416;
 //BA.debugLineNum = 42598416;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42598417;
 //BA.debugLineNum = 42598417;BA.debugLine="lbl_time_show_fs.Text=\"\"";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42598419;
 //BA.debugLineNum = 42598419;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42598420;
 //BA.debugLineNum = 42598420;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42598421;
 //BA.debugLineNum = 42598421;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42598422;
 //BA.debugLineNum = 42598422;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=42598424;
 //BA.debugLineNum = 42598424;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42598426;
 //BA.debugLineNum = 42598426;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42598427;
 //BA.debugLineNum = 42598427;BA.debugLine="ckb_ezaf_taradod_fs.Checked=True";
mostCurrent._ckb_ezaf_taradod_fs.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42598429;
 //BA.debugLineNum = 42598429;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
RDebugUtils.currentLine=42598430;
 //BA.debugLineNum = 42598430;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
RDebugUtils.currentLine=42598431;
 //BA.debugLineNum = 42598431;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=42598432;
 //BA.debugLineNum = 42598432;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
RDebugUtils.currentLine=42598435;
 //BA.debugLineNum = 42598435;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42598436;
 //BA.debugLineNum = 42598436;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42598441;
 //BA.debugLineNum = 42598441;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=42598442;
 //BA.debugLineNum = 42598442;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=42598443;
 //BA.debugLineNum = 42598443;BA.debugLine="lbl_setting_date.Visible=True";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42598447;
 //BA.debugLineNum = 42598447;BA.debugLine="state_tatil= chek_tatil_day(myfunc.fa2en(pik_year";
_state_tatil = _chek_tatil_day((int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText()))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag())))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText()))));
RDebugUtils.currentLine=42598449;
 //BA.debugLineNum = 42598449;BA.debugLine="state_tatil_setting = chek_tatil_setting";
_state_tatil_setting = _chek_tatil_setting();
RDebugUtils.currentLine=42598451;
 //BA.debugLineNum = 42598451;BA.debugLine="day_inWeek_id=what_day(myfunc.fa2en(pik_year1.Tex";
_day_inweek_id = _what_day((int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText()))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag())))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText()))));
RDebugUtils.currentLine=42598454;
 //BA.debugLineNum = 42598454;BA.debugLine="If(state_tatil=0)Then";
if ((_state_tatil==0)) { 
RDebugUtils.currentLine=42598455;
 //BA.debugLineNum = 42598455;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+""));
 }else 
{RDebugUtils.currentLine=42598456;
 //BA.debugLineNum = 42598456;BA.debugLine="Else if (state_tatil=1) Then";
if ((_state_tatil==1)) { 
RDebugUtils.currentLine=42598457;
 //BA.debugLineNum = 42598457;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل رسم";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+" (تعطیل رسمی) "));
 }else 
{RDebugUtils.currentLine=42598458;
 //BA.debugLineNum = 42598458;BA.debugLine="Else if (state_tatil=2) Then";
if ((_state_tatil==2)) { 
RDebugUtils.currentLine=42598459;
 //BA.debugLineNum = 42598459;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل قرا";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+" (تعطیل قراردادی) "));
 }}}
;
RDebugUtils.currentLine=42598464;
 //BA.debugLineNum = 42598464;BA.debugLine="Dim res_val2 As Int =dbCode.get_setting_byName(\"s";
_res_val2 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode")));
RDebugUtils.currentLine=42598465;
 //BA.debugLineNum = 42598465;BA.debugLine="If(res_val2=1)Then";
if ((_res_val2==1)) { 
RDebugUtils.currentLine=42598467;
 //BA.debugLineNum = 42598467;BA.debugLine="pan_finger_taradod.Visible=True";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42598469;
 //BA.debugLineNum = 42598469;BA.debugLine="lbl_finger_fs_vorod.Typeface=Typeface.MATERIALIC";
mostCurrent._lbl_finger_fs_vorod.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
RDebugUtils.currentLine=42598470;
 //BA.debugLineNum = 42598470;BA.debugLine="lbl_finger_fs_khoroj.Typeface=Typeface.MATERIALI";
mostCurrent._lbl_finger_fs_khoroj.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
RDebugUtils.currentLine=42598471;
 //BA.debugLineNum = 42598471;BA.debugLine="lbl_finger_fs_vorod.Text=Chr(0xE90D)";
mostCurrent._lbl_finger_fs_vorod.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe90d))));
RDebugUtils.currentLine=42598472;
 //BA.debugLineNum = 42598472;BA.debugLine="lbl_finger_fs_khoroj.Text=Chr(0xE90D)";
mostCurrent._lbl_finger_fs_khoroj.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe90d))));
RDebugUtils.currentLine=42598474;
 //BA.debugLineNum = 42598474;BA.debugLine="If(File.Exists(File.DirInternal,\"finger_vorod_ta";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=42598477;
 //BA.debugLineNum = 42598477;BA.debugLine="Dim temp_finger As String = File.readString(Fil";
_temp_finger = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt");
RDebugUtils.currentLine=42598478;
 //BA.debugLineNum = 42598478;BA.debugLine="If(temp_finger=0)Then";
if (((_temp_finger).equals(BA.NumberToString(0)))) { 
RDebugUtils.currentLine=42598480;
 //BA.debugLineNum = 42598480;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
RDebugUtils.currentLine=42598482;
 //BA.debugLineNum = 42598482;BA.debugLine="save_box_allow=False";
_save_box_allow = anywheresoftware.b4a.keywords.Common.False;
 }else 
{RDebugUtils.currentLine=42598484;
 //BA.debugLineNum = 42598484;BA.debugLine="Else if (temp_finger=1)Then";
if (((_temp_finger).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=42598487;
 //BA.debugLineNum = 42598487;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=42598488;
 //BA.debugLineNum = 42598488;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=42598490;
 //BA.debugLineNum = 42598490;BA.debugLine="Dim ls_vorod0 As List";
_ls_vorod0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=42598491;
 //BA.debugLineNum = 42598491;BA.debugLine="ls_vorod0.Initialize";
_ls_vorod0.Initialize();
RDebugUtils.currentLine=42598492;
 //BA.debugLineNum = 42598492;BA.debugLine="ls_vorod0=File.ReadList(File.DirInternal,\"temp";
_ls_vorod0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt");
RDebugUtils.currentLine=42598494;
 //BA.debugLineNum = 42598494;BA.debugLine="lbl_date1.Text=ls_vorod0.Get(0)";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (0))));
RDebugUtils.currentLine=42598495;
 //BA.debugLineNum = 42598495;BA.debugLine="lbl_tim1.Text=ls_vorod0.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (1))));
RDebugUtils.currentLine=42598497;
 //BA.debugLineNum = 42598497;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=42598499;
 //BA.debugLineNum = 42598499;BA.debugLine="lbl_finger_fs_vorod.Tag=0";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(0));
RDebugUtils.currentLine=42598500;
 //BA.debugLineNum = 42598500;BA.debugLine="lbl_finger_fs_khoroj.Tag=1";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(1));
RDebugUtils.currentLine=42598502;
 //BA.debugLineNum = 42598502;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42598503;
 //BA.debugLineNum = 42598503;BA.debugLine="lbl_time_show_fs.Text=\"\"";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42598505;
 //BA.debugLineNum = 42598505;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42598506;
 //BA.debugLineNum = 42598506;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42598508;
 //BA.debugLineNum = 42598508;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42598509;
 //BA.debugLineNum = 42598509;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42598510;
 //BA.debugLineNum = 42598510;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42598511;
 //BA.debugLineNum = 42598511;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42598515;
 //BA.debugLineNum = 42598515;BA.debugLine="save_box_allow=False";
_save_box_allow = anywheresoftware.b4a.keywords.Common.False;
 }else 
{RDebugUtils.currentLine=42598517;
 //BA.debugLineNum = 42598517;BA.debugLine="Else if (temp_finger=2)Then";
if (((_temp_finger).equals(BA.NumberToString(2)))) { 
RDebugUtils.currentLine=42598519;
 //BA.debugLineNum = 42598519;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=42598520;
 //BA.debugLineNum = 42598520;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=42598522;
 //BA.debugLineNum = 42598522;BA.debugLine="Dim ls_vorod0 As List";
_ls_vorod0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=42598523;
 //BA.debugLineNum = 42598523;BA.debugLine="ls_vorod0.Initialize";
_ls_vorod0.Initialize();
RDebugUtils.currentLine=42598524;
 //BA.debugLineNum = 42598524;BA.debugLine="ls_vorod0=File.ReadList(File.DirInternal,\"temp";
_ls_vorod0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt");
RDebugUtils.currentLine=42598525;
 //BA.debugLineNum = 42598525;BA.debugLine="lbl_date1.Text=ls_vorod0.Get(0)";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (0))));
RDebugUtils.currentLine=42598526;
 //BA.debugLineNum = 42598526;BA.debugLine="lbl_tim1.Text=ls_vorod0.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (1))));
RDebugUtils.currentLine=42598527;
 //BA.debugLineNum = 42598527;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=42598531;
 //BA.debugLineNum = 42598531;BA.debugLine="Dim ls_vorod1 As List";
_ls_vorod1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=42598532;
 //BA.debugLineNum = 42598532;BA.debugLine="ls_vorod1.Initialize";
_ls_vorod1.Initialize();
RDebugUtils.currentLine=42598533;
 //BA.debugLineNum = 42598533;BA.debugLine="ls_vorod1=File.ReadList(File.DirInternal,\"temp";
_ls_vorod1 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_khoroj.txt");
RDebugUtils.currentLine=42598534;
 //BA.debugLineNum = 42598534;BA.debugLine="lbl_date2.Text=ls_vorod1.Get(0)";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(_ls_vorod1.Get((int) (0))));
RDebugUtils.currentLine=42598535;
 //BA.debugLineNum = 42598535;BA.debugLine="lbl_tim2.Text=ls_vorod1.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_vorod1.Get((int) (1))));
RDebugUtils.currentLine=42598536;
 //BA.debugLineNum = 42598536;BA.debugLine="lbl_finger_fs_khoroj_time.Text=lbl_date2.Text&";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date2.getText()+" - "+mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=42598538;
 //BA.debugLineNum = 42598538;BA.debugLine="lbl_finger_fs_vorod.Tag=0";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(0));
RDebugUtils.currentLine=42598539;
 //BA.debugLineNum = 42598539;BA.debugLine="lbl_finger_fs_khoroj.Tag=0";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(0));
RDebugUtils.currentLine=42598541;
 //BA.debugLineNum = 42598541;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=42598543;
 //BA.debugLineNum = 42598543;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 }}}
;
 }else {
RDebugUtils.currentLine=42598546;
 //BA.debugLineNum = 42598546;BA.debugLine="lbl_finger_fs_vorod_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(" - "));
RDebugUtils.currentLine=42598547;
 //BA.debugLineNum = 42598547;BA.debugLine="lbl_finger_fs_khoroj_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(" - "));
RDebugUtils.currentLine=42598548;
 //BA.debugLineNum = 42598548;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=42598549;
 //BA.debugLineNum = 42598549;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=42598551;
 //BA.debugLineNum = 42598551;BA.debugLine="lbl_finger_fs_vorod.Tag=1";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(1));
RDebugUtils.currentLine=42598552;
 //BA.debugLineNum = 42598552;BA.debugLine="lbl_finger_fs_khoroj.Tag=2";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(2));
 };
 }else {
RDebugUtils.currentLine=42598560;
 //BA.debugLineNum = 42598560;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_vorod_tara";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=42598561;
 //BA.debugLineNum = 42598561;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=42598562;
 //BA.debugLineNum = 42598562;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=42598563;
 //BA.debugLineNum = 42598563;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_v";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt");
RDebugUtils.currentLine=42598568;
 //BA.debugLineNum = 42598568;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42598571;
 //BA.debugLineNum = 42598571;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
RDebugUtils.currentLine=42598573;
 //BA.debugLineNum = 42598573;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42598574;
 //BA.debugLineNum = 42598574;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=42598578;
 //BA.debugLineNum = 42598578;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_khoroj_tar";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=42598579;
 //BA.debugLineNum = 42598579;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=42598580;
 //BA.debugLineNum = 42598580;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=42598581;
 //BA.debugLineNum = 42598581;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt");
RDebugUtils.currentLine=42598586;
 //BA.debugLineNum = 42598586;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42598591;
 //BA.debugLineNum = 42598591;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
RDebugUtils.currentLine=42598593;
 //BA.debugLineNum = 42598593;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42598594;
 //BA.debugLineNum = 42598594;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=42598604;
 //BA.debugLineNum = 42598604;BA.debugLine="time_show";
_time_show();
 };
RDebugUtils.currentLine=42598617;
 //BA.debugLineNum = 42598617;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_mamoriat_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_mamoriat_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_mamoriat_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
RDebugUtils.currentLine=42663936;
 //BA.debugLineNum = 42663936;BA.debugLine="Private Sub pan_add_mamoriat_Click";
RDebugUtils.currentLine=42663937;
 //BA.debugLineNum = 42663937;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=42663938;
 //BA.debugLineNum = 42663938;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
RDebugUtils.currentLine=42663939;
 //BA.debugLineNum = 42663939;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42663940;
 //BA.debugLineNum = 42663940;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42663941;
 //BA.debugLineNum = 42663941;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=42663943;
 //BA.debugLineNum = 42663943;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=42663944;
 //BA.debugLineNum = 42663944;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42663945;
 //BA.debugLineNum = 42663945;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42663947;
 //BA.debugLineNum = 42663947;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42663948;
 //BA.debugLineNum = 42663948;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42663950;
 //BA.debugLineNum = 42663950;BA.debugLine="lbl_box_title.Text=\"ثبت مأموریت\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت مأموریت"));
RDebugUtils.currentLine=42663951;
 //BA.debugLineNum = 42663951;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
RDebugUtils.currentLine=42663952;
 //BA.debugLineNum = 42663952;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
RDebugUtils.currentLine=42663953;
 //BA.debugLineNum = 42663953;BA.debugLine="index_box=5";
_index_box = (int) (5);
RDebugUtils.currentLine=42663954;
 //BA.debugLineNum = 42663954;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42663955;
 //BA.debugLineNum = 42663955;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42663956;
 //BA.debugLineNum = 42663956;BA.debugLine="lbl_ezaf_taradod.Visible=False";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42663959;
 //BA.debugLineNum = 42663959;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42663960;
 //BA.debugLineNum = 42663960;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42663961;
 //BA.debugLineNum = 42663961;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42663966;
 //BA.debugLineNum = 42663966;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
RDebugUtils.currentLine=42663967;
 //BA.debugLineNum = 42663967;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
RDebugUtils.currentLine=42663968;
 //BA.debugLineNum = 42663968;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=42663969;
 //BA.debugLineNum = 42663969;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
RDebugUtils.currentLine=42663972;
 //BA.debugLineNum = 42663972;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42663973;
 //BA.debugLineNum = 42663973;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42663977;
 //BA.debugLineNum = 42663977;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_from_mamori";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=42663978;
 //BA.debugLineNum = 42663978;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=42663979;
 //BA.debugLineNum = 42663979;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=42663980;
 //BA.debugLineNum = 42663980;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_fr";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt");
RDebugUtils.currentLine=42663984;
 //BA.debugLineNum = 42663984;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42663988;
 //BA.debugLineNum = 42663988;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
RDebugUtils.currentLine=42663990;
 //BA.debugLineNum = 42663990;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42663991;
 //BA.debugLineNum = 42663991;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=42663995;
 //BA.debugLineNum = 42663995;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_to_mamoriat";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=42663996;
 //BA.debugLineNum = 42663996;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=42663997;
 //BA.debugLineNum = 42663997;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=42663998;
 //BA.debugLineNum = 42663998;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_t";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt");
RDebugUtils.currentLine=42664002;
 //BA.debugLineNum = 42664002;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42664007;
 //BA.debugLineNum = 42664007;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
RDebugUtils.currentLine=42664009;
 //BA.debugLineNum = 42664009;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=42664010;
 //BA.debugLineNum = 42664010;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
RDebugUtils.currentLine=42664029;
 //BA.debugLineNum = 42664029;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=42664031;
 //BA.debugLineNum = 42664031;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=42664036;
 //BA.debugLineNum = 42664036;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=43450368;
 //BA.debugLineNum = 43450368;BA.debugLine="Sub time_show";
RDebugUtils.currentLine=43450370;
 //BA.debugLineNum = 43450370;BA.debugLine="Try";
try {RDebugUtils.currentLine=43450373;
 //BA.debugLineNum = 43450373;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=43450374;
 //BA.debugLineNum = 43450374;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=43450375;
 //BA.debugLineNum = 43450375;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
RDebugUtils.currentLine=43450376;
 //BA.debugLineNum = 43450376;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
RDebugUtils.currentLine=43450378;
 //BA.debugLineNum = 43450378;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=43450379;
 //BA.debugLineNum = 43450379;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=43450380;
 //BA.debugLineNum = 43450380;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=43450381;
 //BA.debugLineNum = 43450381;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=43450384;
 //BA.debugLineNum = 43450384;BA.debugLine="pik_moon1.Tag=myfunc.convert_adad(pik_moon1.Tag)";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))));
RDebugUtils.currentLine=43450389;
 //BA.debugLineNum = 43450389;BA.debugLine="date1=lbl_date1.Text";
mostCurrent._date1 = mostCurrent._lbl_date1.getText();
RDebugUtils.currentLine=43450390;
 //BA.debugLineNum = 43450390;BA.debugLine="date2=lbl_date2.Text";
mostCurrent._date2 = mostCurrent._lbl_date2.getText();
RDebugUtils.currentLine=43450391;
 //BA.debugLineNum = 43450391;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
RDebugUtils.currentLine=43450392;
 //BA.debugLineNum = 43450392;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
RDebugUtils.currentLine=43450396;
 //BA.debugLineNum = 43450396;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_dat";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=43450397;
 //BA.debugLineNum = 43450397;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_dat";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=43450400;
 //BA.debugLineNum = 43450400;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=43450401;
 //BA.debugLineNum = 43450401;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=43450404;
 //BA.debugLineNum = 43450404;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
RDebugUtils.currentLine=43450405;
 //BA.debugLineNum = 43450405;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
RDebugUtils.currentLine=43450407;
 //BA.debugLineNum = 43450407;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date_";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=43450408;
 //BA.debugLineNum = 43450408;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date_";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=43450410;
 //BA.debugLineNum = 43450410;BA.debugLine="time_end2=lbl_tim2.Text&\":00\"";
_time_end2 = mostCurrent._lbl_tim2.getText()+":00";
RDebugUtils.currentLine=43450411;
 //BA.debugLineNum = 43450411;BA.debugLine="time_end1=lbl_tim1.Text&\":00\"";
_time_end1 = mostCurrent._lbl_tim1.getText()+":00";
RDebugUtils.currentLine=43450413;
 //BA.debugLineNum = 43450413;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
RDebugUtils.currentLine=43450414;
 //BA.debugLineNum = 43450414;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
RDebugUtils.currentLine=43450415;
 //BA.debugLineNum = 43450415;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
RDebugUtils.currentLine=43450416;
 //BA.debugLineNum = 43450416;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
RDebugUtils.currentLine=43450420;
 //BA.debugLineNum = 43450420;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
RDebugUtils.currentLine=43450421;
 //BA.debugLineNum = 43450421;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
RDebugUtils.currentLine=43450424;
 //BA.debugLineNum = 43450424;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=43450425;
 //BA.debugLineNum = 43450425;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
RDebugUtils.currentLine=43450427;
 //BA.debugLineNum = 43450427;BA.debugLine="If (period_between.Years<>0)Then";
if ((_period_between.Years!=0)) { 
RDebugUtils.currentLine=43450428;
 //BA.debugLineNum = 43450428;BA.debugLine="str_show.Append(period_between.Years&\" سال \").A";
_str_show.Append(BA.NumberToString(_period_between.Years)+" سال ").Append(" و ");
 };
RDebugUtils.currentLine=43450430;
 //BA.debugLineNum = 43450430;BA.debugLine="If (period_between.Months<>0)Then";
if ((_period_between.Months!=0)) { 
RDebugUtils.currentLine=43450431;
 //BA.debugLineNum = 43450431;BA.debugLine="str_show.Append(period_between.Months&\" ماه \").";
_str_show.Append(BA.NumberToString(_period_between.Months)+" ماه ").Append(" و ");
 };
RDebugUtils.currentLine=43450433;
 //BA.debugLineNum = 43450433;BA.debugLine="If (period_between.Days<>0)Then";
if ((_period_between.Days!=0)) { 
RDebugUtils.currentLine=43450434;
 //BA.debugLineNum = 43450434;BA.debugLine="str_show.Append(period_between.Days&\" روز \").Ap";
_str_show.Append(BA.NumberToString(_period_between.Days)+" روز ").Append(" و ");
 };
RDebugUtils.currentLine=43450437;
 //BA.debugLineNum = 43450437;BA.debugLine="str_show.Append(period_between.Hours&\" ساعت \").A";
_str_show.Append(BA.NumberToString(_period_between.Hours)+" ساعت ").Append(" و ");
RDebugUtils.currentLine=43450438;
 //BA.debugLineNum = 43450438;BA.debugLine="str_show.Append(period_between.Minutes&\" دقیقه \"";
_str_show.Append(BA.NumberToString(_period_between.Minutes)+" دقیقه ");
RDebugUtils.currentLine=43450441;
 //BA.debugLineNum = 43450441;BA.debugLine="year_bt=period_between.Years";
_year_bt = _period_between.Years;
RDebugUtils.currentLine=43450442;
 //BA.debugLineNum = 43450442;BA.debugLine="moon_bt=period_between.Months";
_moon_bt = _period_between.Months;
RDebugUtils.currentLine=43450443;
 //BA.debugLineNum = 43450443;BA.debugLine="day_bt=period_between.Days";
_day_bt = _period_between.Days;
RDebugUtils.currentLine=43450444;
 //BA.debugLineNum = 43450444;BA.debugLine="hour_bt=period_between.Hours";
_hour_bt = _period_between.Hours;
RDebugUtils.currentLine=43450445;
 //BA.debugLineNum = 43450445;BA.debugLine="min_bt=period_between.Minutes";
_min_bt = _period_between.Minutes;
RDebugUtils.currentLine=43450448;
 //BA.debugLineNum = 43450448;BA.debugLine="lbl_time_show.Text=str_show";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(_str_show.getObject()));
RDebugUtils.currentLine=43450449;
 //BA.debugLineNum = 43450449;BA.debugLine="lbl_time_show_fs.Text=lbl_time_show.Text";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(mostCurrent._lbl_time_show.getText()));
RDebugUtils.currentLine=43450451;
 //BA.debugLineNum = 43450451;BA.debugLine="If(index_box=3)Then";
if ((_index_box==3)) { 
RDebugUtils.currentLine=43450455;
 //BA.debugLineNum = 43450455;BA.debugLine="tim_min=(day_bt*24*60)+(hour_bt*60)+min_bt";
_tim_min = (int) ((_day_bt*24*60)+(_hour_bt*60)+_min_bt);
RDebugUtils.currentLine=43450458;
 //BA.debugLineNum = 43450458;BA.debugLine="Select state_tatil_setting";
switch (_state_tatil_setting) {
case 0: {
RDebugUtils.currentLine=43450461;
 //BA.debugLineNum = 43450461;BA.debugLine="tatil_nist";
_tatil_nist();
 break; }
case 1: {
RDebugUtils.currentLine=43450464;
 //BA.debugLineNum = 43450464;BA.debugLine="If (state_tatil=1 Or state_tatil=2 ) Then 'ta";
if ((_state_tatil==1 || _state_tatil==2)) { 
RDebugUtils.currentLine=43450465;
 //BA.debugLineNum = 43450465;BA.debugLine="tatil_hast";
_tatil_hast();
 }else {
RDebugUtils.currentLine=43450467;
 //BA.debugLineNum = 43450467;BA.debugLine="tatil_nist";
_tatil_nist();
 };
 break; }
case 11: {
RDebugUtils.currentLine=43450471;
 //BA.debugLineNum = 43450471;BA.debugLine="If (state_tatil=1 ) Then 'tatil rasmi";
if ((_state_tatil==1)) { 
RDebugUtils.currentLine=43450472;
 //BA.debugLineNum = 43450472;BA.debugLine="tatil_hast";
_tatil_hast();
 }else {
RDebugUtils.currentLine=43450474;
 //BA.debugLineNum = 43450474;BA.debugLine="tatil_nist";
_tatil_nist();
 };
 break; }
case 22: {
RDebugUtils.currentLine=43450479;
 //BA.debugLineNum = 43450479;BA.debugLine="If (state_tatil=2 ) Then  'tatil garardadi";
if ((_state_tatil==2)) { 
RDebugUtils.currentLine=43450480;
 //BA.debugLineNum = 43450480;BA.debugLine="tatil_hast";
_tatil_hast();
 }else {
RDebugUtils.currentLine=43450482;
 //BA.debugLineNum = 43450482;BA.debugLine="tatil_nist";
_tatil_nist();
 };
 break; }
}
;
RDebugUtils.currentLine=43450489;
 //BA.debugLineNum = 43450489;BA.debugLine="If(is_for_edit=True)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=43450490;
 //BA.debugLineNum = 43450490;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=43450491;
 //BA.debugLineNum = 43450491;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43450492;
 //BA.debugLineNum = 43450492;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43450493;
 //BA.debugLineNum = 43450493;BA.debugLine="radio_ez_adi.Enabled=False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43450494;
 //BA.debugLineNum = 43450494;BA.debugLine="radio_ez_fog.Enabled=False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43450495;
 //BA.debugLineNum = 43450495;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=43450496;
 //BA.debugLineNum = 43450496;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43450497;
 //BA.debugLineNum = 43450497;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 } 
       catch (Exception e87) {
			processBA.setLastException(e87);RDebugUtils.currentLine=43450504;
 //BA.debugLineNum = 43450504;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=43450510;
 //BA.debugLineNum = 43450510;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_ezaf_taradod_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_ezaf_taradod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_ezaf_taradod_click", null));}
RDebugUtils.currentLine=42401792;
 //BA.debugLineNum = 42401792;BA.debugLine="Private Sub lbl_ezaf_taradod_Click";
RDebugUtils.currentLine=42401793;
 //BA.debugLineNum = 42401793;BA.debugLine="If(index_box=2)Then";
if ((_index_box==2)) { 
RDebugUtils.currentLine=42401794;
 //BA.debugLineNum = 42401794;BA.debugLine="rsPOP_noe.Show";
mostCurrent._rspop_noe.Show();
 };
RDebugUtils.currentLine=42401796;
 //BA.debugLineNum = 42401796;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_khoroj_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_finger_fs_khoroj_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_finger_fs_khoroj_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
RDebugUtils.currentLine=49152000;
 //BA.debugLineNum = 49152000;BA.debugLine="Private Sub lbl_finger_fs_khoroj_Click";
RDebugUtils.currentLine=49152002;
 //BA.debugLineNum = 49152002;BA.debugLine="If(lbl_finger_fs_khoroj.Tag=0)Then";
if (((mostCurrent._lbl_finger_fs_khoroj.getTag()).equals((Object)(0)))) { 
RDebugUtils.currentLine=49152003;
 //BA.debugLineNum = 49152003;BA.debugLine="ToastMessageShow(\"قبلا ثبت شده-برای ثبت دوباره ر";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("قبلا ثبت شده-برای ثبت دوباره روی آن نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=49152004;
 //BA.debugLineNum = 49152004;BA.debugLine="Else If (lbl_finger_fs_khoroj.Tag=2)Then";
if (((mostCurrent._lbl_finger_fs_khoroj.getTag()).equals((Object)(2)))) { 
RDebugUtils.currentLine=49152005;
 //BA.debugLineNum = 49152005;BA.debugLine="ToastMessageShow(\"ابتدا ورود را بزنید\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ابتدا ورود را بزنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=49152008;
 //BA.debugLineNum = 49152008;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=49152009;
 //BA.debugLineNum = 49152009;BA.debugLine="lbl_tim2.Text=myfunc.fa2en(DateTime.Time(DateTim";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
RDebugUtils.currentLine=49152010;
 //BA.debugLineNum = 49152010;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=49152011;
 //BA.debugLineNum = 49152011;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=49152012;
 //BA.debugLineNum = 49152012;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
RDebugUtils.currentLine=49152013;
 //BA.debugLineNum = 49152013;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=49152014;
 //BA.debugLineNum = 49152014;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_kho";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_khoroj.txt",_ls_khoroj);
RDebugUtils.currentLine=49152020;
 //BA.debugLineNum = 49152020;BA.debugLine="lbl_finger_fs_khoroj_time.Text=lbl_date2.Text&\"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date2.getText()+" - "+mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=49152021;
 //BA.debugLineNum = 49152021;BA.debugLine="File.WriteString(File.DirInternal,\"finger_vorod_";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt","2");
RDebugUtils.currentLine=49152022;
 //BA.debugLineNum = 49152022;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=49152023;
 //BA.debugLineNum = 49152023;BA.debugLine="lbl_finger_fs_khoroj.Tag=0";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(0));
RDebugUtils.currentLine=49152024;
 //BA.debugLineNum = 49152024;BA.debugLine="ToastMessageShow(\"ثبت زمان خروج\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان خروج"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=49152025;
 //BA.debugLineNum = 49152025;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=49152026;
 //BA.debugLineNum = 49152026;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 }}
;
RDebugUtils.currentLine=49152030;
 //BA.debugLineNum = 49152030;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_khoroj_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_finger_fs_khoroj_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_finger_fs_khoroj_longclick", null));}
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
RDebugUtils.currentLine=49283072;
 //BA.debugLineNum = 49283072;BA.debugLine="Private Sub lbl_finger_fs_khoroj_LongClick";
RDebugUtils.currentLine=49283074;
 //BA.debugLineNum = 49283074;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=49283075;
 //BA.debugLineNum = 49283075;BA.debugLine="lbl_tim2.Text=myfunc.fa2en(DateTime.Time(DateTim";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
RDebugUtils.currentLine=49283076;
 //BA.debugLineNum = 49283076;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=49283077;
 //BA.debugLineNum = 49283077;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=49283078;
 //BA.debugLineNum = 49283078;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
RDebugUtils.currentLine=49283079;
 //BA.debugLineNum = 49283079;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=49283080;
 //BA.debugLineNum = 49283080;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_kho";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_khoroj.txt",_ls_khoroj);
RDebugUtils.currentLine=49283083;
 //BA.debugLineNum = 49283083;BA.debugLine="lbl_finger_fs_khoroj_time.Text=lbl_date2.Text&\"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date2.getText()+" - "+mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=49283085;
 //BA.debugLineNum = 49283085;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=49283086;
 //BA.debugLineNum = 49283086;BA.debugLine="ToastMessageShow(\"ثبت زمان خروج\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان خروج"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=49283087;
 //BA.debugLineNum = 49283087;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=49283089;
 //BA.debugLineNum = 49283089;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_vorod_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_finger_fs_vorod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_finger_fs_vorod_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
RDebugUtils.currentLine=49217536;
 //BA.debugLineNum = 49217536;BA.debugLine="Private Sub lbl_finger_fs_vorod_Click";
RDebugUtils.currentLine=49217538;
 //BA.debugLineNum = 49217538;BA.debugLine="If(lbl_finger_fs_vorod.Tag=0)Then";
if (((mostCurrent._lbl_finger_fs_vorod.getTag()).equals((Object)(0)))) { 
RDebugUtils.currentLine=49217539;
 //BA.debugLineNum = 49217539;BA.debugLine="ToastMessageShow(\"قبلا ثبت شده-برای ثبت دوباره ر";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("قبلا ثبت شده-برای ثبت دوباره روی آن نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=49217543;
 //BA.debugLineNum = 49217543;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=49217544;
 //BA.debugLineNum = 49217544;BA.debugLine="lbl_tim1.Text=myfunc.fa2en(DateTime.Time(DateTim";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
RDebugUtils.currentLine=49217545;
 //BA.debugLineNum = 49217545;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=49217546;
 //BA.debugLineNum = 49217546;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=49217547;
 //BA.debugLineNum = 49217547;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
RDebugUtils.currentLine=49217548;
 //BA.debugLineNum = 49217548;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=49217549;
 //BA.debugLineNum = 49217549;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_vor";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt",_ls_vorod);
RDebugUtils.currentLine=49217554;
 //BA.debugLineNum = 49217554;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\" -";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=49217555;
 //BA.debugLineNum = 49217555;BA.debugLine="File.WriteString(File.DirInternal,\"finger_vorod_";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt","1");
RDebugUtils.currentLine=49217556;
 //BA.debugLineNum = 49217556;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=49217557;
 //BA.debugLineNum = 49217557;BA.debugLine="lbl_finger_fs_vorod.Tag=0";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(0));
RDebugUtils.currentLine=49217558;
 //BA.debugLineNum = 49217558;BA.debugLine="lbl_finger_fs_khoroj.Tag=1";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(1));
RDebugUtils.currentLine=49217559;
 //BA.debugLineNum = 49217559;BA.debugLine="ToastMessageShow(\"ثبت زمان ورود\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان ورود"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=49217566;
 //BA.debugLineNum = 49217566;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_vorod_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_finger_fs_vorod_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_finger_fs_vorod_longclick", null));}
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
RDebugUtils.currentLine=49348608;
 //BA.debugLineNum = 49348608;BA.debugLine="Private Sub lbl_finger_fs_vorod_LongClick";
RDebugUtils.currentLine=49348609;
 //BA.debugLineNum = 49348609;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=49348610;
 //BA.debugLineNum = 49348610;BA.debugLine="lbl_tim1.Text=myfunc.fa2en(DateTime.Time(DateTime";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
RDebugUtils.currentLine=49348611;
 //BA.debugLineNum = 49348611;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=49348612;
 //BA.debugLineNum = 49348612;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=49348613;
 //BA.debugLineNum = 49348613;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
RDebugUtils.currentLine=49348614;
 //BA.debugLineNum = 49348614;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=49348615;
 //BA.debugLineNum = 49348615;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_voro";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt",_ls_vorod);
RDebugUtils.currentLine=49348619;
 //BA.debugLineNum = 49348619;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\" -";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=49348621;
 //BA.debugLineNum = 49348621;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=49348622;
 //BA.debugLineNum = 49348622;BA.debugLine="ToastMessageShow(\"ثبت زمان ورود\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان ورود"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=49348623;
 //BA.debugLineNum = 49348623;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=49348625;
 //BA.debugLineNum = 49348625;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_khoroj_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_finger_khoroj_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_finger_khoroj_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
RDebugUtils.currentLine=48693248;
 //BA.debugLineNum = 48693248;BA.debugLine="Private Sub lbl_finger_khoroj_Click";
RDebugUtils.currentLine=48693249;
 //BA.debugLineNum = 48693249;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=48693250;
 //BA.debugLineNum = 48693250;BA.debugLine="lbl_tim2.Text=myfunc.fa2en(DateTime.Time(DateTime";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
RDebugUtils.currentLine=48693253;
 //BA.debugLineNum = 48693253;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=48693254;
 //BA.debugLineNum = 48693254;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=48693255;
 //BA.debugLineNum = 48693255;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
RDebugUtils.currentLine=48693256;
 //BA.debugLineNum = 48693256;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=48693258;
 //BA.debugLineNum = 48693258;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
RDebugUtils.currentLine=48693260;
 //BA.debugLineNum = 48693260;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_ezafek";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt",_ls_khoroj);
 break; }
case 2: {
RDebugUtils.currentLine=48693262;
 //BA.debugLineNum = 48693262;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_morakh";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt",_ls_khoroj);
 break; }
case 3: {
RDebugUtils.currentLine=48693264;
 //BA.debugLineNum = 48693264;BA.debugLine="File.WriteList(File.DirInternal,\"temp_khoroj_ta";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt",_ls_khoroj);
 break; }
case 5: {
RDebugUtils.currentLine=48693267;
 //BA.debugLineNum = 48693267;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_mamori";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt",_ls_khoroj);
 break; }
}
;
RDebugUtils.currentLine=48693271;
 //BA.debugLineNum = 48693271;BA.debugLine="ToastMessageShow(\"ثبت زمان 2\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان 2"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48693272;
 //BA.debugLineNum = 48693272;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=48693273;
 //BA.debugLineNum = 48693273;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_vorod_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_finger_vorod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_finger_vorod_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
RDebugUtils.currentLine=48627712;
 //BA.debugLineNum = 48627712;BA.debugLine="Private Sub lbl_finger_vorod_Click";
RDebugUtils.currentLine=48627713;
 //BA.debugLineNum = 48627713;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
RDebugUtils.currentLine=48627714;
 //BA.debugLineNum = 48627714;BA.debugLine="lbl_tim1.Text=myfunc.fa2en(DateTime.Time(DateTime";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
RDebugUtils.currentLine=48627717;
 //BA.debugLineNum = 48627717;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=48627718;
 //BA.debugLineNum = 48627718;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=48627719;
 //BA.debugLineNum = 48627719;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
RDebugUtils.currentLine=48627720;
 //BA.debugLineNum = 48627720;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=48627723;
 //BA.debugLineNum = 48627723;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
RDebugUtils.currentLine=48627725;
 //BA.debugLineNum = 48627725;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_ezaf";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt",_ls_vorod);
 break; }
case 2: {
RDebugUtils.currentLine=48627727;
 //BA.debugLineNum = 48627727;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_mora";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt",_ls_vorod);
 break; }
case 3: {
RDebugUtils.currentLine=48627729;
 //BA.debugLineNum = 48627729;BA.debugLine="File.WriteList(File.DirInternal,\"temp_vorod_tar";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt",_ls_vorod);
 break; }
case 5: {
RDebugUtils.currentLine=48627733;
 //BA.debugLineNum = 48627733;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_mamo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt",_ls_vorod);
 break; }
}
;
RDebugUtils.currentLine=48627740;
 //BA.debugLineNum = 48627740;BA.debugLine="ToastMessageShow(\"ثبت زمان 1\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان 1"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48627741;
 //BA.debugLineNum = 48627741;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=48627742;
 //BA.debugLineNum = 48627742;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_piker_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_piker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_piker_click", null));}
RDebugUtils.currentLine=47054848;
 //BA.debugLineNum = 47054848;BA.debugLine="Private Sub lbl_help_piker_Click";
RDebugUtils.currentLine=47054850;
 //BA.debugLineNum = 47054850;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
RDebugUtils.currentLine=47054852;
 //BA.debugLineNum = 47054852;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
RDebugUtils.currentLine=47054853;
 //BA.debugLineNum = 47054853;BA.debugLine="lbl_close_help.Visible=False";
mostCurrent._lbl_close_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=47054854;
 //BA.debugLineNum = 47054854;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=47054856;
 //BA.debugLineNum = 47054856;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_saatkari_inweek_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_saatkari_inweek_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_saatkari_inweek_click", null));}
RDebugUtils.currentLine=49741824;
 //BA.debugLineNum = 49741824;BA.debugLine="Private Sub lbl_help_saatKari_inWeek_Click";
RDebugUtils.currentLine=49741825;
 //BA.debugLineNum = 49741825;BA.debugLine="myfunc.help_man(\"راهنما\",\"اگر در روزهای هفته ساعت";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","اگر در روزهای هفته ساعت کاری مختلف دارید آنها را تنظیم کنید تا در موقع ثبت تردد با آن حساب شود. ");
RDebugUtils.currentLine=49741826;
 //BA.debugLineNum = 49741826;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_setting_finger_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_setting_finger_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_setting_finger_click", null));}
RDebugUtils.currentLine=49545216;
 //BA.debugLineNum = 49545216;BA.debugLine="Private Sub lbl_help_setting_finger_Click";
RDebugUtils.currentLine=49545217;
 //BA.debugLineNum = 49545217;BA.debugLine="myfunc.help_man(\"راهنما\",\"با فعال کردن این گزینه";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","با فعال کردن این گزینه ثبت ترددها به انگشتی انجام میشود . به این صورت که در موقع ورود و خروج انگشت میزنیم تا زمان ثبت شود و در آخر ذخیره میکنیم.");
RDebugUtils.currentLine=49545218;
 //BA.debugLineNum = 49545218;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_tatil_garardadi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_tatil_garardadi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_tatil_garardadi_click", null));}
RDebugUtils.currentLine=49676288;
 //BA.debugLineNum = 49676288;BA.debugLine="Private Sub lbl_help_tatil_garardadi_Click";
RDebugUtils.currentLine=49676289;
 //BA.debugLineNum = 49676289;BA.debugLine="myfunc.help_man(\"راهنما\",\"تردد در روزهای تعطیل قر";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","تردد در روزهای تعطیل قراردادی اضافه کاری محسوب شود- برای تعین روزها به عنوان تعطیل قراردادی در صفحه تقویم روی هر روز انگشت خود را نگه دارید و بعد تیک تعطیل قراردادی را بزنید. ");
RDebugUtils.currentLine=49676290;
 //BA.debugLineNum = 49676290;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_tatil_rasmi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_tatil_rasmi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_tatil_rasmi_click", null));}
RDebugUtils.currentLine=49610752;
 //BA.debugLineNum = 49610752;BA.debugLine="Private Sub lbl_help_tatil_rasmi_Click";
RDebugUtils.currentLine=49610753;
 //BA.debugLineNum = 49610753;BA.debugLine="myfunc.help_man(\"راهنما\",\"تردد در روزهای تعطیل رس";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","تردد در روزهای تعطیل رسمی و جمعه ها اضافه کاری محسوب شوند.");
RDebugUtils.currentLine=49610754;
 //BA.debugLineNum = 49610754;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help2_click", null));}
RDebugUtils.currentLine=46530560;
 //BA.debugLineNum = 46530560;BA.debugLine="Private Sub lbl_help2_Click";
RDebugUtils.currentLine=46530561;
 //BA.debugLineNum = 46530561;BA.debugLine="lbl_help_Click";
_lbl_help_click();
RDebugUtils.currentLine=46530562;
 //BA.debugLineNum = 46530562;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_lite_menu_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_lite_menu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_lite_menu_click", null));}
RDebugUtils.currentLine=47448064;
 //BA.debugLineNum = 47448064;BA.debugLine="Private Sub lbl_lite_menu_Click";
RDebugUtils.currentLine=47448065;
 //BA.debugLineNum = 47448065;BA.debugLine="pan_all_liteMenu.Visible=True";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=47448066;
 //BA.debugLineNum = 47448066;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_notefi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_notefi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_notefi_click", null));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _html = null;
int _i = 0;
RDebugUtils.currentLine=39780352;
 //BA.debugLineNum = 39780352;BA.debugLine="Private Sub lbl_notefi_Click";
RDebugUtils.currentLine=39780353;
 //BA.debugLineNum = 39780353;BA.debugLine="lbl_title_msgPan.Text=\"پیام ها\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام ها"));
RDebugUtils.currentLine=39780354;
 //BA.debugLineNum = 39780354;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=39780355;
 //BA.debugLineNum = 39780355;BA.debugLine="pan_notif.Top=10%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=39780356;
 //BA.debugLineNum = 39780356;BA.debugLine="pan_notif.Height=70%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
RDebugUtils.currentLine=39780357;
 //BA.debugLineNum = 39780357;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
RDebugUtils.currentLine=39780360;
 //BA.debugLineNum = 39780360;BA.debugLine="Dim html As StringBuilder";
_html = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=39780361;
 //BA.debugLineNum = 39780361;BA.debugLine="html.Initialize";
_html.Initialize();
RDebugUtils.currentLine=39780363;
 //BA.debugLineNum = 39780363;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1"))) { 
RDebugUtils.currentLine=39780365;
 //BA.debugLineNum = 39780365;BA.debugLine="html.Append(\"<!DOCTYPE html><html><meta charset=";
_html.Append("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'>");
RDebugUtils.currentLine=39780366;
 //BA.debugLineNum = 39780366;BA.debugLine="For i = ls1.Size-1 To 0 Step -1";
{
final int step10 = -1;
final int limit10 = (int) (0);
_i = (int) (mostCurrent._ls1.getSize()-1) ;
for (;_i >= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=39780367;
 //BA.debugLineNum = 39780367;BA.debugLine="html.Append(\"<div style='background-color: #99f";
_html.Append("<div style='background-color: #99ffff; font-size: 13px;'>"+"کد پیام : "+BA.ObjectToString(mostCurrent._ls1.Get(_i))+" - مورخ : "+BA.ObjectToString(mostCurrent._ls3.Get(_i))+"</div><div style='background-color: #e6ffff; font-size: 16px;'><br>"+BA.ObjectToString(mostCurrent._ls2.Get(_i))).Append("<br></div><br>");
 }
};
RDebugUtils.currentLine=39780369;
 //BA.debugLineNum = 39780369;BA.debugLine="html.Append(\"</body></html>\")";
_html.Append("</body></html>");
RDebugUtils.currentLine=39780372;
 //BA.debugLineNum = 39780372;BA.debugLine="web_msg_show.LoadHtml(html.ToString)";
mostCurrent._web_msg_show.LoadHtml(_html.ToString());
 }else {
RDebugUtils.currentLine=39780375;
 //BA.debugLineNum = 39780375;BA.debugLine="web_msg_show.LoadHtml(\"<html><body dir='rtl'>لیس";
mostCurrent._web_msg_show.LoadHtml("<html><body dir='rtl'>لیست پیام خالی ... </body></html>");
 };
RDebugUtils.currentLine=39780379;
 //BA.debugLineNum = 39780379;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_remove_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_remove_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
RDebugUtils.currentLine=46399488;
 //BA.debugLineNum = 46399488;BA.debugLine="Private Sub lbl_remove_from_list_Click";
RDebugUtils.currentLine=46399490;
 //BA.debugLineNum = 46399490;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=46399491;
 //BA.debugLineNum = 46399491;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=46399493;
 //BA.debugLineNum = 46399493;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
RDebugUtils.currentLine=46399494;
 //BA.debugLineNum = 46399494;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=46399495;
 //BA.debugLineNum = 46399495;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=46399496;
 //BA.debugLineNum = 46399496;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=46399498;
 //BA.debugLineNum = 46399498;BA.debugLine="If (dbCode.delete_ezafekari(b.Tag))Then";
if ((mostCurrent._dbcode._delete_ezafekari /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=46399499;
 //BA.debugLineNum = 46399499;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46399501;
 //BA.debugLineNum = 46399501;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
RDebugUtils.currentLine=46399504;
 //BA.debugLineNum = 46399504;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else 
{RDebugUtils.currentLine=46399507;
 //BA.debugLineNum = 46399507;BA.debugLine="Else if (TabHost1.CurrentTab=1)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==1)) { 
RDebugUtils.currentLine=46399509;
 //BA.debugLineNum = 46399509;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=46399510;
 //BA.debugLineNum = 46399510;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=46399511;
 //BA.debugLineNum = 46399511;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=46399513;
 //BA.debugLineNum = 46399513;BA.debugLine="If (dbCode.delete_morakhasi(b.Tag))Then";
if ((mostCurrent._dbcode._delete_morakhasi /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=46399514;
 //BA.debugLineNum = 46399514;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46399515;
 //BA.debugLineNum = 46399515;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
RDebugUtils.currentLine=46399516;
 //BA.debugLineNum = 46399516;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else 
{RDebugUtils.currentLine=46399520;
 //BA.debugLineNum = 46399520;BA.debugLine="Else if (TabHost1.CurrentTab=2)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==2)) { 
RDebugUtils.currentLine=46399521;
 //BA.debugLineNum = 46399521;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=46399522;
 //BA.debugLineNum = 46399522;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=46399523;
 //BA.debugLineNum = 46399523;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=46399525;
 //BA.debugLineNum = 46399525;BA.debugLine="If (dbCode.delete_taradod(b.Tag))Then";
if ((mostCurrent._dbcode._delete_taradod /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=46399526;
 //BA.debugLineNum = 46399526;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46399528;
 //BA.debugLineNum = 46399528;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
RDebugUtils.currentLine=46399529;
 //BA.debugLineNum = 46399529;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else 
{RDebugUtils.currentLine=46399533;
 //BA.debugLineNum = 46399533;BA.debugLine="Else if (TabHost1.CurrentTab=3)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==3)) { 
RDebugUtils.currentLine=46399534;
 //BA.debugLineNum = 46399534;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=46399535;
 //BA.debugLineNum = 46399535;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=46399536;
 //BA.debugLineNum = 46399536;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=46399538;
 //BA.debugLineNum = 46399538;BA.debugLine="If (dbCode.delete_mamoriat(b.Tag))Then";
if ((mostCurrent._dbcode._delete_mamoriat /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=46399539;
 //BA.debugLineNum = 46399539;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46399541;
 //BA.debugLineNum = 46399541;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
RDebugUtils.currentLine=46399542;
 //BA.debugLineNum = 46399542;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }}}}
;
RDebugUtils.currentLine=46399552;
 //BA.debugLineNum = 46399552;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_remove_from_list2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_remove_from_list2_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
RDebugUtils.currentLine=46465024;
 //BA.debugLineNum = 46465024;BA.debugLine="Private Sub lbl_remove_from_list2_Click";
RDebugUtils.currentLine=46465025;
 //BA.debugLineNum = 46465025;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=46465026;
 //BA.debugLineNum = 46465026;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=46465029;
 //BA.debugLineNum = 46465029;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=46465030;
 //BA.debugLineNum = 46465030;BA.debugLine="result = Msgbox2(\"آیا این گزارش حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این گزارش حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=46465031;
 //BA.debugLineNum = 46465031;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=46465033;
 //BA.debugLineNum = 46465033;BA.debugLine="If (dbCode.delete_gozaresh(b.tag))Then";
if ((mostCurrent._dbcode._delete_gozaresh /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=46465034;
 //BA.debugLineNum = 46465034;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46465035;
 //BA.debugLineNum = 46465035;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedI";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
 };
 };
RDebugUtils.currentLine=46465040;
 //BA.debugLineNum = 46465040;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_box_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_box_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_box_click", null));}
RDebugUtils.currentLine=42860544;
 //BA.debugLineNum = 42860544;BA.debugLine="Private Sub lbl_save_box_Click";
RDebugUtils.currentLine=42860546;
 //BA.debugLineNum = 42860546;BA.debugLine="If(save_box_allow=False)Then";
if ((_save_box_allow==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=42860547;
 //BA.debugLineNum = 42860547;BA.debugLine="ToastMessageShow(\"ورود یا خروج ناقص است.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ورود یا خروج ناقص است."),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=42860549;
 //BA.debugLineNum = 42860549;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=42860550;
 //BA.debugLineNum = 42860550;BA.debugLine="add_end";
_add_end();
 };
RDebugUtils.currentLine=42860555;
 //BA.debugLineNum = 42860555;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=45285376;
 //BA.debugLineNum = 45285376;BA.debugLine="Private Sub lbl_save_picker_Click";
RDebugUtils.currentLine=45285378;
 //BA.debugLineNum = 45285378;BA.debugLine="Dim value As String";
_value = "";
RDebugUtils.currentLine=45285379;
 //BA.debugLineNum = 45285379;BA.debugLine="value=pik_hour1.Text";
_value = mostCurrent._pik_hour1.getText();
RDebugUtils.currentLine=45285380;
 //BA.debugLineNum = 45285380;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(value)";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_value)))));
RDebugUtils.currentLine=45285383;
 //BA.debugLineNum = 45285383;BA.debugLine="Dim value1 As String";
_value1 = "";
RDebugUtils.currentLine=45285384;
 //BA.debugLineNum = 45285384;BA.debugLine="value1=pik_min1.Text";
_value1 = mostCurrent._pik_min1.getText();
RDebugUtils.currentLine=45285385;
 //BA.debugLineNum = 45285385;BA.debugLine="pik_min1.Text=myfunc.convert_adad(value1)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_value1)))));
RDebugUtils.currentLine=45285388;
 //BA.debugLineNum = 45285388;BA.debugLine="Dim value2 As String";
_value2 = "";
RDebugUtils.currentLine=45285389;
 //BA.debugLineNum = 45285389;BA.debugLine="value2=pik_day1.Text";
_value2 = mostCurrent._pik_day1.getText();
RDebugUtils.currentLine=45285390;
 //BA.debugLineNum = 45285390;BA.debugLine="pik_day1.Text=myfunc.convert_adad(value2)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_value2)))));
RDebugUtils.currentLine=45285391;
 //BA.debugLineNum = 45285391;BA.debugLine="pik_moon1.Tag=myfunc.convert_adad(pik_moon1.Tag)";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))));
RDebugUtils.currentLine=45285396;
 //BA.debugLineNum = 45285396;BA.debugLine="If(index_piker=1)Then  'date1";
if ((_index_piker==1)) { 
RDebugUtils.currentLine=45285399;
 //BA.debugLineNum = 45285399;BA.debugLine="lbl_tim1.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
RDebugUtils.currentLine=45285400;
 //BA.debugLineNum = 45285400;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
RDebugUtils.currentLine=45285402;
 //BA.debugLineNum = 45285402;BA.debugLine="If (is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=45285404;
 //BA.debugLineNum = 45285404;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=45285405;
 //BA.debugLineNum = 45285405;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
RDebugUtils.currentLine=45285406;
 //BA.debugLineNum = 45285406;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
RDebugUtils.currentLine=45285407;
 //BA.debugLineNum = 45285407;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
RDebugUtils.currentLine=45285409;
 //BA.debugLineNum = 45285409;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
RDebugUtils.currentLine=45285411;
 //BA.debugLineNum = 45285411;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_ez";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt",_ls_vorod);
 break; }
case 2: {
RDebugUtils.currentLine=45285413;
 //BA.debugLineNum = 45285413;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_mo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt",_ls_vorod);
 break; }
case 3: {
RDebugUtils.currentLine=45285415;
 //BA.debugLineNum = 45285415;BA.debugLine="File.WriteList(File.DirInternal,\"temp_vorod_t";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt",_ls_vorod);
 break; }
case 5: {
RDebugUtils.currentLine=45285417;
 //BA.debugLineNum = 45285417;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_ma";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt",_ls_vorod);
 break; }
}
;
 };
RDebugUtils.currentLine=45285425;
 //BA.debugLineNum = 45285425;BA.debugLine="state_tatil= chek_tatil_day(myfunc.fa2en(pik_yea";
_state_tatil = _chek_tatil_day((int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText()))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag())))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText()))));
RDebugUtils.currentLine=45285426;
 //BA.debugLineNum = 45285426;BA.debugLine="state_tatil_setting = chek_tatil_setting";
_state_tatil_setting = _chek_tatil_setting();
RDebugUtils.currentLine=45285428;
 //BA.debugLineNum = 45285428;BA.debugLine="day_inWeek_id=what_day(myfunc.fa2en(pik_year1.Te";
_day_inweek_id = _what_day((int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText()))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag())))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText()))));
RDebugUtils.currentLine=45285431;
 //BA.debugLineNum = 45285431;BA.debugLine="If(state_tatil=0)Then";
if ((_state_tatil==0)) { 
RDebugUtils.currentLine=45285432;
 //BA.debugLineNum = 45285432;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+""));
 }else 
{RDebugUtils.currentLine=45285433;
 //BA.debugLineNum = 45285433;BA.debugLine="Else if (state_tatil=1) Then";
if ((_state_tatil==1)) { 
RDebugUtils.currentLine=45285434;
 //BA.debugLineNum = 45285434;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل رس";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+" (تعطیل رسمی)"));
 }else 
{RDebugUtils.currentLine=45285435;
 //BA.debugLineNum = 45285435;BA.debugLine="Else if (state_tatil=2) Then";
if ((_state_tatil==2)) { 
RDebugUtils.currentLine=45285436;
 //BA.debugLineNum = 45285436;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل قر";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+" (تعطیل قراردادی)"));
 }}}
;
RDebugUtils.currentLine=45285442;
 //BA.debugLineNum = 45285442;BA.debugLine="If (index_box <> 3) Then";
if ((_index_box!=3)) { 
RDebugUtils.currentLine=45285443;
 //BA.debugLineNum = 45285443;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
 };
 }else 
{RDebugUtils.currentLine=45285447;
 //BA.debugLineNum = 45285447;BA.debugLine="Else If (index_piker=2)Then  'date2";
if ((_index_piker==2)) { 
RDebugUtils.currentLine=45285449;
 //BA.debugLineNum = 45285449;BA.debugLine="lbl_tim2.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
RDebugUtils.currentLine=45285450;
 //BA.debugLineNum = 45285450;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
RDebugUtils.currentLine=45285453;
 //BA.debugLineNum = 45285453;BA.debugLine="If (is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=45285455;
 //BA.debugLineNum = 45285455;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=45285456;
 //BA.debugLineNum = 45285456;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
RDebugUtils.currentLine=45285457;
 //BA.debugLineNum = 45285457;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
RDebugUtils.currentLine=45285458;
 //BA.debugLineNum = 45285458;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
RDebugUtils.currentLine=45285460;
 //BA.debugLineNum = 45285460;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
RDebugUtils.currentLine=45285462;
 //BA.debugLineNum = 45285462;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_ezaf";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt",_ls_khoroj);
 break; }
case 2: {
RDebugUtils.currentLine=45285464;
 //BA.debugLineNum = 45285464;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_mora";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt",_ls_khoroj);
 break; }
case 3: {
RDebugUtils.currentLine=45285466;
 //BA.debugLineNum = 45285466;BA.debugLine="File.WriteList(File.DirInternal,\"temp_khoroj_";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt",_ls_khoroj);
 break; }
case 5: {
RDebugUtils.currentLine=45285468;
 //BA.debugLineNum = 45285468;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_mamo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt",_ls_khoroj);
 break; }
}
;
 };
 }}
;
RDebugUtils.currentLine=45285478;
 //BA.debugLineNum = 45285478;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=45285479;
 //BA.debugLineNum = 45285479;BA.debugLine="time_show";
_time_show();
RDebugUtils.currentLine=45285480;
 //BA.debugLineNum = 45285480;BA.debugLine="End Sub";
return "";
}
public static int  _what_day(int _year1,int _moon1,int _day1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "what_day", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "what_day", new Object[] {_year1,_moon1,_day1}));}
int _id_myday = 0;
int _result_int = 0;
RDebugUtils.currentLine=45350912;
 //BA.debugLineNum = 45350912;BA.debugLine="Sub what_day (year1 As Int,moon1 As Int, day1 As I";
RDebugUtils.currentLine=45350913;
 //BA.debugLineNum = 45350913;BA.debugLine="Dim id_MyDay As Int";
_id_myday = 0;
RDebugUtils.currentLine=45350914;
 //BA.debugLineNum = 45350914;BA.debugLine="id_MyDay=dbCode.get_day_id(year1,moon1,day1)";
_id_myday = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_year1,_moon1,_day1);
RDebugUtils.currentLine=45350916;
 //BA.debugLineNum = 45350916;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=45350917;
 //BA.debugLineNum = 45350917;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id_myday))));
RDebugUtils.currentLine=45350919;
 //BA.debugLineNum = 45350919;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=45350920;
 //BA.debugLineNum = 45350920;BA.debugLine="Dim result_int As Int=dbCode.res.GetInt(\"day_h\")";
_result_int = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_h");
RDebugUtils.currentLine=45350924;
 //BA.debugLineNum = 45350924;BA.debugLine="Select result_int";
switch (_result_int) {
case 1: {
RDebugUtils.currentLine=45350926;
 //BA.debugLineNum = 45350926;BA.debugLine="day_inWeek_name=\"شنبه\"";
mostCurrent._day_inweek_name = "شنبه";
 break; }
case 2: {
RDebugUtils.currentLine=45350928;
 //BA.debugLineNum = 45350928;BA.debugLine="day_inWeek_name=\"یکشنبه\"";
mostCurrent._day_inweek_name = "یکشنبه";
 break; }
case 3: {
RDebugUtils.currentLine=45350930;
 //BA.debugLineNum = 45350930;BA.debugLine="day_inWeek_name=\"دوشنبه\"";
mostCurrent._day_inweek_name = "دوشنبه";
 break; }
case 4: {
RDebugUtils.currentLine=45350932;
 //BA.debugLineNum = 45350932;BA.debugLine="day_inWeek_name=\"سه شنبه\"";
mostCurrent._day_inweek_name = "سه شنبه";
 break; }
case 5: {
RDebugUtils.currentLine=45350934;
 //BA.debugLineNum = 45350934;BA.debugLine="day_inWeek_name=\"چهارشنبه\"";
mostCurrent._day_inweek_name = "چهارشنبه";
 break; }
case 6: {
RDebugUtils.currentLine=45350936;
 //BA.debugLineNum = 45350936;BA.debugLine="day_inWeek_name=\"پنجشنبه\"";
mostCurrent._day_inweek_name = "پنجشنبه";
 break; }
case 7: {
RDebugUtils.currentLine=45350938;
 //BA.debugLineNum = 45350938;BA.debugLine="day_inWeek_name=\"جمعه\"";
mostCurrent._day_inweek_name = "جمعه";
 break; }
}
;
RDebugUtils.currentLine=45350942;
 //BA.debugLineNum = 45350942;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=45350943;
 //BA.debugLineNum = 45350943;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=45350945;
 //BA.debugLineNum = 45350945;BA.debugLine="Return result_int";
if (true) return _result_int;
RDebugUtils.currentLine=45350946;
 //BA.debugLineNum = 45350946;BA.debugLine="End Sub";
return 0;
}
public static String  _lbl_save_setting_date_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_setting_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_setting_date_click", null));}
RDebugUtils.currentLine=48955392;
 //BA.debugLineNum = 48955392;BA.debugLine="Private Sub lbl_save_setting_date_Click";
RDebugUtils.currentLine=48955396;
 //BA.debugLineNum = 48955396;BA.debugLine="If(ckb_setting_date_finger.Checked=True)Then";
if ((mostCurrent._ckb_setting_date_finger.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=48955397;
 //BA.debugLineNum = 48955397;BA.debugLine="dbCode.update_setting_byname(\"setting_finger_mod";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode",BA.NumberToString(1));
RDebugUtils.currentLine=48955398;
 //BA.debugLineNum = 48955398;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
RDebugUtils.currentLine=48955399;
 //BA.debugLineNum = 48955399;BA.debugLine="pan_finger_taradod.Visible=True";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=48955401;
 //BA.debugLineNum = 48955401;BA.debugLine="dbCode.update_setting_byname(\"setting_finger_mod";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode",BA.NumberToString(0));
RDebugUtils.currentLine=48955402;
 //BA.debugLineNum = 48955402;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48955403;
 //BA.debugLineNum = 48955403;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
RDebugUtils.currentLine=48955404;
 //BA.debugLineNum = 48955404;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=48955407;
 //BA.debugLineNum = 48955407;BA.debugLine="If(ckb_tatil_rasmi.Checked=True)Then";
if ((mostCurrent._ckb_tatil_rasmi.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=48955408;
 //BA.debugLineNum = 48955408;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_rasm";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi",BA.NumberToString(1));
 }else {
RDebugUtils.currentLine=48955410;
 //BA.debugLineNum = 48955410;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_rasm";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi",BA.NumberToString(0));
 };
RDebugUtils.currentLine=48955413;
 //BA.debugLineNum = 48955413;BA.debugLine="If(ckb_tatil_garardadi.Checked=True)Then";
if ((mostCurrent._ckb_tatil_garardadi.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=48955414;
 //BA.debugLineNum = 48955414;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_gara";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi",BA.NumberToString(1));
 }else {
RDebugUtils.currentLine=48955416;
 //BA.debugLineNum = 48955416;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_gara";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi",BA.NumberToString(0));
 };
RDebugUtils.currentLine=48955421;
 //BA.debugLineNum = 48955421;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Shanbe\",((";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Shanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari0.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari0.getText())));
RDebugUtils.currentLine=48955422;
 //BA.debugLineNum = 48955422;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Yekshanbe\"";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Yekshanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari1.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari1.getText())));
RDebugUtils.currentLine=48955423;
 //BA.debugLineNum = 48955423;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Doshanbe\",";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Doshanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari2.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari2.getText())));
RDebugUtils.currentLine=48955424;
 //BA.debugLineNum = 48955424;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Seshanbe\",";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Seshanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari3.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari3.getText())));
RDebugUtils.currentLine=48955425;
 //BA.debugLineNum = 48955425;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Charshanbe";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Charshanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari4.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari4.getText())));
RDebugUtils.currentLine=48955426;
 //BA.debugLineNum = 48955426;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Panjshanbe";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Panjshanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari5.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari5.getText())));
RDebugUtils.currentLine=48955434;
 //BA.debugLineNum = 48955434;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48955435;
 //BA.debugLineNum = 48955435;BA.debugLine="pan_all_setting_date.Visible=False";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48955436;
 //BA.debugLineNum = 48955436;BA.debugLine="pan_all_Click";
_pan_all_click();
RDebugUtils.currentLine=48955437;
 //BA.debugLineNum = 48955437;BA.debugLine="End Sub";
return "";
}
public static int  _validat_et_saatkari(String _val) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "validat_et_saatkari", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "validat_et_saatkari", new Object[] {_val}));}
RDebugUtils.currentLine=49020928;
 //BA.debugLineNum = 49020928;BA.debugLine="Sub validat_et_saatKari (val As String) As Int";
RDebugUtils.currentLine=49020929;
 //BA.debugLineNum = 49020929;BA.debugLine="If (val=\"\") Then";
if (((_val).equals(""))) { 
RDebugUtils.currentLine=49020930;
 //BA.debugLineNum = 49020930;BA.debugLine="val=0";
_val = BA.NumberToString(0);
 };
RDebugUtils.currentLine=49020932;
 //BA.debugLineNum = 49020932;BA.debugLine="Return val";
if (true) return (int)(Double.parseDouble(_val));
RDebugUtils.currentLine=49020933;
 //BA.debugLineNum = 49020933;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=48824320;
 //BA.debugLineNum = 48824320;BA.debugLine="Private Sub lbl_setting_date_Click";
RDebugUtils.currentLine=48824322;
 //BA.debugLineNum = 48824322;BA.debugLine="Try";
try {RDebugUtils.currentLine=48824324;
 //BA.debugLineNum = 48824324;BA.debugLine="Dim res_val2 As Int =dbCode.get_setting_byName(\"";
_res_val2 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode")));
RDebugUtils.currentLine=48824325;
 //BA.debugLineNum = 48824325;BA.debugLine="If(res_val2=0)Then";
if ((_res_val2==0)) { 
RDebugUtils.currentLine=48824326;
 //BA.debugLineNum = 48824326;BA.debugLine="ckb_setting_date_finger.Checked=False";
mostCurrent._ckb_setting_date_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=48824328;
 //BA.debugLineNum = 48824328;BA.debugLine="ckb_setting_date_finger.Checked=True";
mostCurrent._ckb_setting_date_finger.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=48824331;
 //BA.debugLineNum = 48824331;BA.debugLine="Dim res_tatil_rasmi As Int =dbCode.get_setting_b";
_res_tatil_rasmi = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi")));
RDebugUtils.currentLine=48824332;
 //BA.debugLineNum = 48824332;BA.debugLine="If(res_tatil_rasmi=0)Then";
if ((_res_tatil_rasmi==0)) { 
RDebugUtils.currentLine=48824333;
 //BA.debugLineNum = 48824333;BA.debugLine="ckb_tatil_rasmi.Checked=False";
mostCurrent._ckb_tatil_rasmi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=48824335;
 //BA.debugLineNum = 48824335;BA.debugLine="ckb_tatil_rasmi.Checked=True";
mostCurrent._ckb_tatil_rasmi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=48824338;
 //BA.debugLineNum = 48824338;BA.debugLine="Dim res_tatil_garardadi As Int =dbCode.get_setti";
_res_tatil_garardadi = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi")));
RDebugUtils.currentLine=48824339;
 //BA.debugLineNum = 48824339;BA.debugLine="If(res_tatil_garardadi=0)Then";
if ((_res_tatil_garardadi==0)) { 
RDebugUtils.currentLine=48824340;
 //BA.debugLineNum = 48824340;BA.debugLine="ckb_tatil_garardadi.Checked=False";
mostCurrent._ckb_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=48824342;
 //BA.debugLineNum = 48824342;BA.debugLine="ckb_tatil_garardadi.Checked=True";
mostCurrent._ckb_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=48824346;
 //BA.debugLineNum = 48824346;BA.debugLine="Dim minRoz_0 , minRoz_1, minRoz_2, minRoz_3, min";
_minroz_0 = 0;
_minroz_1 = 0;
_minroz_2 = 0;
_minroz_3 = 0;
_minroz_4 = 0;
_minroz_5 = (int) (0);
RDebugUtils.currentLine=48824347;
 //BA.debugLineNum = 48824347;BA.debugLine="minRoz_0=dbCode.get_setting_byName(\"saat_kar_Sha";
_minroz_0 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Shanbe")));
RDebugUtils.currentLine=48824348;
 //BA.debugLineNum = 48824348;BA.debugLine="minRoz_1=dbCode.get_setting_byName(\"saat_kar_Yek";
_minroz_1 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Yekshanbe")));
RDebugUtils.currentLine=48824349;
 //BA.debugLineNum = 48824349;BA.debugLine="minRoz_2=dbCode.get_setting_byName(\"saat_kar_Dos";
_minroz_2 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Doshanbe")));
RDebugUtils.currentLine=48824350;
 //BA.debugLineNum = 48824350;BA.debugLine="minRoz_3=dbCode.get_setting_byName(\"saat_kar_Ses";
_minroz_3 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Seshanbe")));
RDebugUtils.currentLine=48824351;
 //BA.debugLineNum = 48824351;BA.debugLine="minRoz_4=dbCode.get_setting_byName(\"saat_kar_Cha";
_minroz_4 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Charshanbe")));
RDebugUtils.currentLine=48824352;
 //BA.debugLineNum = 48824352;BA.debugLine="minRoz_5=dbCode.get_setting_byName(\"saat_kar_Pan";
_minroz_5 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Panjshanbe")));
RDebugUtils.currentLine=48824356;
 //BA.debugLineNum = 48824356;BA.debugLine="et_saat_kari0.Text=myfunc.strTOint(minRoz_0/60)";
mostCurrent._et_saat_kari0.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_0/(double)60))));
RDebugUtils.currentLine=48824357;
 //BA.debugLineNum = 48824357;BA.debugLine="et_min_kari0.Text=myfunc.strTOint(minRoz_0 Mod 6";
mostCurrent._et_min_kari0.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_0%60))));
RDebugUtils.currentLine=48824359;
 //BA.debugLineNum = 48824359;BA.debugLine="et_saat_kari1.Text=myfunc.strTOint(minRoz_1/60)";
mostCurrent._et_saat_kari1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_1/(double)60))));
RDebugUtils.currentLine=48824360;
 //BA.debugLineNum = 48824360;BA.debugLine="et_min_kari1.Text=myfunc.strTOint(minRoz_1 Mod 6";
mostCurrent._et_min_kari1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_1%60))));
RDebugUtils.currentLine=48824362;
 //BA.debugLineNum = 48824362;BA.debugLine="et_saat_kari2.Text=myfunc.strTOint(minRoz_2/60)";
mostCurrent._et_saat_kari2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_2/(double)60))));
RDebugUtils.currentLine=48824363;
 //BA.debugLineNum = 48824363;BA.debugLine="et_min_kari2.Text=myfunc.strTOint(minRoz_2 Mod 6";
mostCurrent._et_min_kari2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_2%60))));
RDebugUtils.currentLine=48824365;
 //BA.debugLineNum = 48824365;BA.debugLine="et_saat_kari3.Text=myfunc.strTOint(minRoz_3/60)";
mostCurrent._et_saat_kari3.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_3/(double)60))));
RDebugUtils.currentLine=48824366;
 //BA.debugLineNum = 48824366;BA.debugLine="et_min_kari3.Text=myfunc.strTOint(minRoz_3 Mod 6";
mostCurrent._et_min_kari3.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_3%60))));
RDebugUtils.currentLine=48824368;
 //BA.debugLineNum = 48824368;BA.debugLine="et_saat_kari4.Text=myfunc.strTOint(minRoz_4/60)";
mostCurrent._et_saat_kari4.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_4/(double)60))));
RDebugUtils.currentLine=48824369;
 //BA.debugLineNum = 48824369;BA.debugLine="et_min_kari4.Text=myfunc.strTOint(minRoz_4 Mod 6";
mostCurrent._et_min_kari4.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_4%60))));
RDebugUtils.currentLine=48824371;
 //BA.debugLineNum = 48824371;BA.debugLine="et_saat_kari5.Text=myfunc.strTOint(minRoz_5/60)";
mostCurrent._et_saat_kari5.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_5/(double)60))));
RDebugUtils.currentLine=48824372;
 //BA.debugLineNum = 48824372;BA.debugLine="et_min_kari5.Text=myfunc.strTOint(minRoz_5 Mod 6";
mostCurrent._et_min_kari5.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_5%60))));
RDebugUtils.currentLine=48824377;
 //BA.debugLineNum = 48824377;BA.debugLine="pan_all_setting_date.Visible=True";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
 } 
       catch (Exception e41) {
			processBA.setLastException(e41);RDebugUtils.currentLine=48824383;
 //BA.debugLineNum = 48824383;BA.debugLine="ScrollView_sett_taradod.Panel.LoadLayout(\"item_s";
mostCurrent._scrollview_sett_taradod.getPanel().LoadLayout("item_settingTaradod_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=48824384;
 //BA.debugLineNum = 48824384;BA.debugLine="lbl_setting_date_Click";
_lbl_setting_date_click();
RDebugUtils.currentLine=48824385;
 //BA.debugLineNum = 48824385;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("348824385",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=48824389;
 //BA.debugLineNum = 48824389;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_app_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_share_app_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_share_app_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _i = null;
RDebugUtils.currentLine=48037888;
 //BA.debugLineNum = 48037888;BA.debugLine="Private Sub lbl_share_app_Click";
RDebugUtils.currentLine=48037889;
 //BA.debugLineNum = 48037889;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=48037890;
 //BA.debugLineNum = 48037890;BA.debugLine="i.Initialize(i.ACTION_SEND, \"\")";
_i.Initialize(_i.ACTION_SEND,"");
RDebugUtils.currentLine=48037891;
 //BA.debugLineNum = 48037891;BA.debugLine="i.SetType(\"text/plain\")";
_i.SetType("text/plain");
RDebugUtils.currentLine=48037892;
 //BA.debugLineNum = 48037892;BA.debugLine="i.PutExtra(\"android.intent.extra.TEXT\", \"https://";
_i.PutExtra("android.intent.extra.TEXT",(Object)("https://cafebazaar.ir/app/ir.taravatgroup.ezafekari2"));
RDebugUtils.currentLine=48037893;
 //BA.debugLineNum = 48037893;BA.debugLine="i.WrapAsIntentChooser(\"انتخاب کنید\")";
_i.WrapAsIntentChooser("انتخاب کنید");
RDebugUtils.currentLine=48037894;
 //BA.debugLineNum = 48037894;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_i.getObject()));
RDebugUtils.currentLine=48037895;
 //BA.debugLineNum = 48037895;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
RDebugUtils.currentLine=48037896;
 //BA.debugLineNum = 48037896;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=48758784;
 //BA.debugLineNum = 48758784;BA.debugLine="Private Sub lbl_share_Click";
RDebugUtils.currentLine=48758786;
 //BA.debugLineNum = 48758786;BA.debugLine="Dim str_file_matn As StringBuilder";
_str_file_matn = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=48758787;
 //BA.debugLineNum = 48758787;BA.debugLine="str_file_matn.Initialize";
_str_file_matn.Initialize();
RDebugUtils.currentLine=48758788;
 //BA.debugLineNum = 48758788;BA.debugLine="Dim name_gozaresh As String=\"\"";
_name_gozaresh = "";
RDebugUtils.currentLine=48758789;
 //BA.debugLineNum = 48758789;BA.debugLine="Dim name_gozaresh_en As String=\"\"";
_name_gozaresh_en = "";
RDebugUtils.currentLine=48758791;
 //BA.debugLineNum = 48758791;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=48758793;
 //BA.debugLineNum = 48758793;BA.debugLine="Select TabHost1.CurrentTab";
switch (BA.switchObjectToInt(mostCurrent._tabhost1.getCurrentTab(),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
RDebugUtils.currentLine=48758796;
 //BA.debugLineNum = 48758796;BA.debugLine="name_gozaresh=\"اضافه کاری ها-\"";
_name_gozaresh = "اضافه کاری ها-";
RDebugUtils.currentLine=48758797;
 //BA.debugLineNum = 48758797;BA.debugLine="name_gozaresh_en=\"ezafekari\"";
_name_gozaresh_en = "ezafekari";
RDebugUtils.currentLine=48758798;
 //BA.debugLineNum = 48758798;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
case 1: {
RDebugUtils.currentLine=48758801;
 //BA.debugLineNum = 48758801;BA.debugLine="name_gozaresh=\"مرخصی ها-\"";
_name_gozaresh = "مرخصی ها-";
RDebugUtils.currentLine=48758802;
 //BA.debugLineNum = 48758802;BA.debugLine="name_gozaresh_en=\"morakhasi\"";
_name_gozaresh_en = "morakhasi";
RDebugUtils.currentLine=48758803;
 //BA.debugLineNum = 48758803;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
case 2: {
RDebugUtils.currentLine=48758806;
 //BA.debugLineNum = 48758806;BA.debugLine="name_gozaresh=\"ترددها-\"";
_name_gozaresh = "ترددها-";
RDebugUtils.currentLine=48758807;
 //BA.debugLineNum = 48758807;BA.debugLine="name_gozaresh_en=\"taradod\"";
_name_gozaresh_en = "taradod";
RDebugUtils.currentLine=48758808;
 //BA.debugLineNum = 48758808;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
case 3: {
RDebugUtils.currentLine=48758811;
 //BA.debugLineNum = 48758811;BA.debugLine="name_gozaresh=\"مأموریت ها-\"";
_name_gozaresh = "مأموریت ها-";
RDebugUtils.currentLine=48758812;
 //BA.debugLineNum = 48758812;BA.debugLine="name_gozaresh_en=\"mamoriat\"";
_name_gozaresh_en = "mamoriat";
RDebugUtils.currentLine=48758813;
 //BA.debugLineNum = 48758813;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
}
;
RDebugUtils.currentLine=48758821;
 //BA.debugLineNum = 48758821;BA.debugLine="str_file_matn.Append(\"<!DOCTYPE html><html dir='r";
_str_file_matn.Append("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>");
RDebugUtils.currentLine=48758822;
 //BA.debugLineNum = 48758822;BA.debugLine="str_file_matn.Append(\"<style>table , td {border:";
_str_file_matn.Append("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	</style>");
RDebugUtils.currentLine=48758824;
 //BA.debugLineNum = 48758824;BA.debugLine="str_file_matn.Append(\"<h3>\").Append(\" گزارش \"&nam";
_str_file_matn.Append("<h3>").Append(" گزارش "+_name_gozaresh+mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())).Append("</h3>");
RDebugUtils.currentLine=48758830;
 //BA.debugLineNum = 48758830;BA.debugLine="str_file_matn.Append(\"نام کاربر :\").Append(\"<span";
_str_file_matn.Append("نام کاربر :").Append("<span> "+_user_namefamili+"</span>").Append("<br>");
RDebugUtils.currentLine=48758832;
 //BA.debugLineNum = 48758832;BA.debugLine="str_file_matn.Append(\"<div style=' background-col";
_str_file_matn.Append("<div style=' background-color: #f5f5f5;'>");
RDebugUtils.currentLine=48758835;
 //BA.debugLineNum = 48758835;BA.debugLine="str_file_matn.Append(\"<table style='width:100%;'>";
_str_file_matn.Append("<table style='width:100%;'><tr style='text-align: center;'>");
RDebugUtils.currentLine=48758836;
 //BA.debugLineNum = 48758836;BA.debugLine="str_file_matn.Append(\"<td><b> ردیف</b></td><td><b";
_str_file_matn.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td><br></tr>");
RDebugUtils.currentLine=48758838;
 //BA.debugLineNum = 48758838;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=48758839;
 //BA.debugLineNum = 48758839;BA.debugLine="str_file_matn.Append(\"<tr style='text-align: cen";
_str_file_matn.Append("<tr style='text-align: center;'>");
RDebugUtils.currentLine=48758840;
 //BA.debugLineNum = 48758840;BA.debugLine="str_file_matn.Append(\"<td>\").Append(myfunc.en2fa";
_str_file_matn.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
RDebugUtils.currentLine=48758841;
 //BA.debugLineNum = 48758841;BA.debugLine="str_file_matn.Append(\"<td>\").Append(myfunc.en2fa";
_str_file_matn.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
RDebugUtils.currentLine=48758842;
 //BA.debugLineNum = 48758842;BA.debugLine="str_file_matn.Append(\"<td>\").Append(myfunc.en2fa";
_str_file_matn.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
RDebugUtils.currentLine=48758844;
 //BA.debugLineNum = 48758844;BA.debugLine="str_file_matn.Append(\"<td>\")";
_str_file_matn.Append("<td>");
RDebugUtils.currentLine=48758847;
 //BA.debugLineNum = 48758847;BA.debugLine="Dim ls_ezafe As List";
_ls_ezafe = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=48758848;
 //BA.debugLineNum = 48758848;BA.debugLine="ls_ezafe.Initialize";
_ls_ezafe.Initialize();
RDebugUtils.currentLine=48758850;
 //BA.debugLineNum = 48758850;BA.debugLine="If( TabHost1.CurrentTab=0 Or  TabHost1.CurrentTa";
if ((mostCurrent._tabhost1.getCurrentTab()==0 || mostCurrent._tabhost1.getCurrentTab()==2)) { 
RDebugUtils.currentLine=48758851;
 //BA.debugLineNum = 48758851;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz2_dontDay(dbCo";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 }else {
RDebugUtils.currentLine=48758853;
 //BA.debugLineNum = 48758853;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz(dbCode.res.Ge";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
RDebugUtils.currentLine=48758854;
 //BA.debugLineNum = 48758854;BA.debugLine="str_file_matn.Append(ls_ezafe.Get(2))";
_str_file_matn.Append(BA.ObjectToString(_ls_ezafe.Get((int) (2))));
RDebugUtils.currentLine=48758855;
 //BA.debugLineNum = 48758855;BA.debugLine="str_file_matn.Append(\":\")";
_str_file_matn.Append(":");
 };
RDebugUtils.currentLine=48758863;
 //BA.debugLineNum = 48758863;BA.debugLine="str_file_matn.Append(ls_ezafe.Get(0))";
_str_file_matn.Append(BA.ObjectToString(_ls_ezafe.Get((int) (0))));
RDebugUtils.currentLine=48758864;
 //BA.debugLineNum = 48758864;BA.debugLine="str_file_matn.Append(\":\")";
_str_file_matn.Append(":");
RDebugUtils.currentLine=48758865;
 //BA.debugLineNum = 48758865;BA.debugLine="str_file_matn.Append(ls_ezafe.Get(1)).Append(\"</t";
_str_file_matn.Append(BA.ObjectToString(_ls_ezafe.Get((int) (1)))).Append("</td>");
RDebugUtils.currentLine=48758867;
 //BA.debugLineNum = 48758867;BA.debugLine="str_file_matn.Append(\"</tr>\")";
_str_file_matn.Append("</tr>");
 }
;
RDebugUtils.currentLine=48758871;
 //BA.debugLineNum = 48758871;BA.debugLine="str_file_matn.Append(\"</table>\")";
_str_file_matn.Append("</table>");
RDebugUtils.currentLine=48758872;
 //BA.debugLineNum = 48758872;BA.debugLine="str_file_matn.Append(\"مجموع ساعت  :<span style='co";
_str_file_matn.Append("مجموع ساعت  :<span style='color:#5E35B1;'> "+mostCurrent._lbl_majmoe_saat.getText()+" </span><br></div><br> ");
RDebugUtils.currentLine=48758878;
 //BA.debugLineNum = 48758878;BA.debugLine="str_file_matn.Append(\"<br></details></div>\")";
_str_file_matn.Append("<br></details></div>");
RDebugUtils.currentLine=48758880;
 //BA.debugLineNum = 48758880;BA.debugLine="str_file_matn.Append(\"<footer style=' text-align:";
_str_file_matn.Append("<footer style=' text-align: center; '><h6> اپلیکیشن اضافه کاری من </h6></footer>");
RDebugUtils.currentLine=48758882;
 //BA.debugLineNum = 48758882;BA.debugLine="str_file_matn.Append(\"</body></html>\")";
_str_file_matn.Append("</body></html>");
RDebugUtils.currentLine=48758887;
 //BA.debugLineNum = 48758887;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=48758888;
 //BA.debugLineNum = 48758888;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=48758895;
 //BA.debugLineNum = 48758895;BA.debugLine="Dim FileName As String =name_gozaresh_en&\"-\"&myfu";
_filename = _name_gozaresh_en+"-"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+".html";
RDebugUtils.currentLine=48758898;
 //BA.debugLineNum = 48758898;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
anywheresoftware.b4a.keywords.Common.File.WriteString(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename,_str_file_matn.ToString());
RDebugUtils.currentLine=48758900;
 //BA.debugLineNum = 48758900;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=48758901;
 //BA.debugLineNum = 48758901;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
RDebugUtils.currentLine=48758902;
 //BA.debugLineNum = 48758902;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
RDebugUtils.currentLine=48758903;
 //BA.debugLineNum = 48758903;BA.debugLine="email.Body = \" گزارش  \"&name_gozaresh&CRLF&\"اپلیک";
_email.Body = " گزارش  "+_name_gozaresh+anywheresoftware.b4a.keywords.Common.CRLF+"اپلیکیشن اضافه کاری من"+anywheresoftware.b4a.keywords.Common.CRLF+"دانلود از بازار";
RDebugUtils.currentLine=48758904;
 //BA.debugLineNum = 48758904;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (null,_filename));
RDebugUtils.currentLine=48758906;
 //BA.debugLineNum = 48758906;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
RDebugUtils.currentLine=48758907;
 //BA.debugLineNum = 48758907;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
RDebugUtils.currentLine=48758908;
 //BA.debugLineNum = 48758908;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
RDebugUtils.currentLine=48758911;
 //BA.debugLineNum = 48758911;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_later_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip_later_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip_later_click", null));}
RDebugUtils.currentLine=46792704;
 //BA.debugLineNum = 46792704;BA.debugLine="Private Sub lbl_vip_later_Click";
RDebugUtils.currentLine=46792705;
 //BA.debugLineNum = 46792705;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
RDebugUtils.currentLine=46792706;
 //BA.debugLineNum = 46792706;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_now_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip_now_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip_now_click", null));}
String _title = "";
String _matn = "";
int _result = 0;
RDebugUtils.currentLine=46858240;
 //BA.debugLineNum = 46858240;BA.debugLine="Private Sub lbl_vip_now_Click";
RDebugUtils.currentLine=46858242;
 //BA.debugLineNum = 46858242;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=46858244;
 //BA.debugLineNum = 46858244;BA.debugLine="Dim title , matn As String";
_title = "";
_matn = "";
RDebugUtils.currentLine=46858245;
 //BA.debugLineNum = 46858245;BA.debugLine="title=\" تبریک \"";
_title = " تبریک ";
RDebugUtils.currentLine=46858246;
 //BA.debugLineNum = 46858246;BA.debugLine="matn=\" شما صاحب نسخه طلایی و بدون محدودیت برنامه";
_matn = " شما صاحب نسخه طلایی و بدون محدودیت برنامه اضافه کاری من می باشید. ";
RDebugUtils.currentLine=46858248;
 //BA.debugLineNum = 46858248;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=46858249;
 //BA.debugLineNum = 46858249;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Lo";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"باشه","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"buy.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=46858250;
 //BA.debugLineNum = 46858250;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
 }else {
RDebugUtils.currentLine=46858257;
 //BA.debugLineNum = 46858257;BA.debugLine="kharid";
_kharid();
 };
RDebugUtils.currentLine=46858259;
 //BA.debugLineNum = 46858259;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_vip2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_vip2_click", null));}
RDebugUtils.currentLine=46596096;
 //BA.debugLineNum = 46596096;BA.debugLine="Private Sub lbl_vip2_Click";
RDebugUtils.currentLine=46596097;
 //BA.debugLineNum = 46596097;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
RDebugUtils.currentLine=46596098;
 //BA.debugLineNum = 46596098;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=47710208;
 //BA.debugLineNum = 47710208;BA.debugLine="Sub min_between_to_time(dat1 As String,dat2 As Str";
RDebugUtils.currentLine=47710211;
 //BA.debugLineNum = 47710211;BA.debugLine="Try";
try {RDebugUtils.currentLine=47710213;
 //BA.debugLineNum = 47710213;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=47710214;
 //BA.debugLineNum = 47710214;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=47710215;
 //BA.debugLineNum = 47710215;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
RDebugUtils.currentLine=47710216;
 //BA.debugLineNum = 47710216;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
RDebugUtils.currentLine=47710218;
 //BA.debugLineNum = 47710218;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=47710219;
 //BA.debugLineNum = 47710219;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=47710220;
 //BA.debugLineNum = 47710220;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=47710221;
 //BA.debugLineNum = 47710221;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=47710230;
 //BA.debugLineNum = 47710230;BA.debugLine="date1=dat1";
mostCurrent._date1 = _dat1;
RDebugUtils.currentLine=47710231;
 //BA.debugLineNum = 47710231;BA.debugLine="date2=dat2";
mostCurrent._date2 = _dat2;
RDebugUtils.currentLine=47710232;
 //BA.debugLineNum = 47710232;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
RDebugUtils.currentLine=47710233;
 //BA.debugLineNum = 47710233;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
RDebugUtils.currentLine=47710237;
 //BA.debugLineNum = 47710237;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_da";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=47710238;
 //BA.debugLineNum = 47710238;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_da";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=47710241;
 //BA.debugLineNum = 47710241;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=47710242;
 //BA.debugLineNum = 47710242;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=47710245;
 //BA.debugLineNum = 47710245;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
RDebugUtils.currentLine=47710246;
 //BA.debugLineNum = 47710246;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
RDebugUtils.currentLine=47710248;
 //BA.debugLineNum = 47710248;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=47710249;
 //BA.debugLineNum = 47710249;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=47710251;
 //BA.debugLineNum = 47710251;BA.debugLine="time_end2=tim2&\":00\"";
_time_end2 = _tim2+":00";
RDebugUtils.currentLine=47710252;
 //BA.debugLineNum = 47710252;BA.debugLine="time_end1=tim1&\":00\"";
_time_end1 = _tim1+":00";
RDebugUtils.currentLine=47710254;
 //BA.debugLineNum = 47710254;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
RDebugUtils.currentLine=47710255;
 //BA.debugLineNum = 47710255;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
RDebugUtils.currentLine=47710256;
 //BA.debugLineNum = 47710256;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
RDebugUtils.currentLine=47710257;
 //BA.debugLineNum = 47710257;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
RDebugUtils.currentLine=47710261;
 //BA.debugLineNum = 47710261;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
RDebugUtils.currentLine=47710262;
 //BA.debugLineNum = 47710262;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
 } 
       catch (Exception e31) {
			processBA.setLastException(e31);RDebugUtils.currentLine=47710267;
 //BA.debugLineNum = 47710267;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=47710270;
 //BA.debugLineNum = 47710270;BA.debugLine="Return (period_between.Days*24*60)+(period_betwee";
if (true) return (int) ((_period_between.Days*24*60)+(_period_between.Hours*60)+_period_between.Minutes);
RDebugUtils.currentLine=47710271;
 //BA.debugLineNum = 47710271;BA.debugLine="End Sub";
return 0;
}
public static String  _pan_add_other_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_add_other_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_add_other_click", null));}
RDebugUtils.currentLine=44957696;
 //BA.debugLineNum = 44957696;BA.debugLine="Private Sub pan_add_other_Click";
RDebugUtils.currentLine=44957697;
 //BA.debugLineNum = 44957697;BA.debugLine="StartActivity(sabt2_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._sabt2_activity.getObject()));
RDebugUtils.currentLine=44957698;
 //BA.debugLineNum = 44957698;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_msgnewyear_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_msgnewyear_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_msgnewyear_click", null));}
RDebugUtils.currentLine=39518208;
 //BA.debugLineNum = 39518208;BA.debugLine="Private Sub pan_all_msgNewYear_Click";
RDebugUtils.currentLine=39518210;
 //BA.debugLineNum = 39518210;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_setting_date_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_setting_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_setting_date_click", null));}
RDebugUtils.currentLine=48889856;
 //BA.debugLineNum = 48889856;BA.debugLine="Private Sub pan_all_setting_date_Click";
RDebugUtils.currentLine=48889857;
 //BA.debugLineNum = 48889857;BA.debugLine="pan_all_setting_date.Visible=False";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=48889858;
 //BA.debugLineNum = 48889858;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all2_click", null));}
RDebugUtils.currentLine=45547520;
 //BA.debugLineNum = 45547520;BA.debugLine="Private Sub pan_all2_Click";
RDebugUtils.currentLine=45547523;
 //BA.debugLineNum = 45547523;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=45547524;
 //BA.debugLineNum = 45547524;BA.debugLine="End Sub";
return "";
}
public static String  _pan_bime_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_bime_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_bime_click", null));}
anywheresoftware.b4a.phone.Phone.PhoneIntents _phoneintents1 = null;
RDebugUtils.currentLine=47906816;
 //BA.debugLineNum = 47906816;BA.debugLine="Private Sub pan_bime_Click";
RDebugUtils.currentLine=47906819;
 //BA.debugLineNum = 47906819;BA.debugLine="Dim PhoneIntents1 As PhoneIntents";
_phoneintents1 = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
RDebugUtils.currentLine=47906820;
 //BA.debugLineNum = 47906820;BA.debugLine="StartActivity (PhoneIntents1.OpenBrowser(\"https:/";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_phoneintents1.OpenBrowser("https://eservices.tamin.ir/view/#/history")));
RDebugUtils.currentLine=47906822;
 //BA.debugLineNum = 47906822;BA.debugLine="End Sub";
return "";
}
public static String  _pan_calc_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_calc_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_calc_click", null));}
RDebugUtils.currentLine=45809664;
 //BA.debugLineNum = 45809664;BA.debugLine="Private Sub pan_calc_Click";
RDebugUtils.currentLine=45809665;
 //BA.debugLineNum = 45809665;BA.debugLine="StartActivity(calc_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._calc_activity.getObject()));
RDebugUtils.currentLine=45809668;
 //BA.debugLineNum = 45809668;BA.debugLine="End Sub";
return "";
}
public static String  _pan_comment_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_comment_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_comment_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _market = null;
String _url = "";
RDebugUtils.currentLine=45678592;
 //BA.debugLineNum = 45678592;BA.debugLine="Private Sub pan_comment_Click";
RDebugUtils.currentLine=45678594;
 //BA.debugLineNum = 45678594;BA.debugLine="Try";
try {RDebugUtils.currentLine=45678595;
 //BA.debugLineNum = 45678595;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=45678597;
 //BA.debugLineNum = 45678597;BA.debugLine="Try";
try {RDebugUtils.currentLine=45678598;
 //BA.debugLineNum = 45678598;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=45678599;
 //BA.debugLineNum = 45678599;BA.debugLine="Dim url As String";
_url = "";
RDebugUtils.currentLine=45678601;
 //BA.debugLineNum = 45678601;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafek";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
RDebugUtils.currentLine=45678602;
 //BA.debugLineNum = 45678602;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
RDebugUtils.currentLine=45678603;
 //BA.debugLineNum = 45678603;BA.debugLine="market.SetPackage(\"com.farsitel.bazaar\")";
_market.SetPackage("com.farsitel.bazaar");
RDebugUtils.currentLine=45678604;
 //BA.debugLineNum = 45678604;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e11) {
			processBA.setLastException(e11);RDebugUtils.currentLine=45678607;
 //BA.debugLineNum = 45678607;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=45678610;
 //BA.debugLineNum = 45678610;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e17) {
			processBA.setLastException(e17);RDebugUtils.currentLine=45678614;
 //BA.debugLineNum = 45678614;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=45678616;
 //BA.debugLineNum = 45678616;BA.debugLine="Try";
try {RDebugUtils.currentLine=45678617;
 //BA.debugLineNum = 45678617;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=45678618;
 //BA.debugLineNum = 45678618;BA.debugLine="Dim url As String";
_url = "";
RDebugUtils.currentLine=45678620;
 //BA.debugLineNum = 45678620;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafe";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
RDebugUtils.currentLine=45678621;
 //BA.debugLineNum = 45678621;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
RDebugUtils.currentLine=45678622;
 //BA.debugLineNum = 45678622;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e25) {
			processBA.setLastException(e25);RDebugUtils.currentLine=45678625;
 //BA.debugLineNum = 45678625;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=45678628;
 //BA.debugLineNum = 45678628;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 };
RDebugUtils.currentLine=45678635;
 //BA.debugLineNum = 45678635;BA.debugLine="End Sub";
return "";
}
public static String  _pan_darsad_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_darsad_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_darsad_click", null));}
RDebugUtils.currentLine=45613056;
 //BA.debugLineNum = 45613056;BA.debugLine="Private Sub pan_darsad_Click";
RDebugUtils.currentLine=45613057;
 //BA.debugLineNum = 45613057;BA.debugLine="StartActivity(darsad_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._darsad_activity.getObject()));
RDebugUtils.currentLine=45613059;
 //BA.debugLineNum = 45613059;BA.debugLine="End Sub";
return "";
}
public static String  _pan_eidi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_eidi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_eidi_click", null));}
RDebugUtils.currentLine=44761088;
 //BA.debugLineNum = 44761088;BA.debugLine="Private Sub pan_eidi_Click";
RDebugUtils.currentLine=44761089;
 //BA.debugLineNum = 44761089;BA.debugLine="StartActivity(eidi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._eidi_activity.getObject()));
RDebugUtils.currentLine=44761091;
 //BA.debugLineNum = 44761091;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ezafekari_mah_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_ezafekari_mah_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_ezafekari_mah_click", null));}
RDebugUtils.currentLine=46661632;
 //BA.debugLineNum = 46661632;BA.debugLine="Private Sub pan_ezafekari_mah_Click";
RDebugUtils.currentLine=46661633;
 //BA.debugLineNum = 46661633;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
RDebugUtils.currentLine=46661634;
 //BA.debugLineNum = 46661634;BA.debugLine="TabHost1.CurrentTab=0";
mostCurrent._tabhost1.setCurrentTab((int) (0));
RDebugUtils.currentLine=46661636;
 //BA.debugLineNum = 46661636;BA.debugLine="End Sub";
return "";
}
public static String  _pan_fast_run_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_fast_run_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_fast_run_click", null));}
RDebugUtils.currentLine=42074112;
 //BA.debugLineNum = 42074112;BA.debugLine="Private Sub pan_fast_run_Click";
RDebugUtils.currentLine=42074117;
 //BA.debugLineNum = 42074117;BA.debugLine="StartActivity(fast_run_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._fast_run_activity.getObject()));
RDebugUtils.currentLine=42074121;
 //BA.debugLineNum = 42074121;BA.debugLine="End Sub";
return "";
}
public static String  _pan_finger_taradod_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_finger_taradod_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_finger_taradod_click", null));}
RDebugUtils.currentLine=49086464;
 //BA.debugLineNum = 49086464;BA.debugLine="Private Sub pan_finger_taradod_Click";
RDebugUtils.currentLine=49086466;
 //BA.debugLineNum = 49086466;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ganon_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_ganon_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_ganon_click", null));}
RDebugUtils.currentLine=47120384;
 //BA.debugLineNum = 47120384;BA.debugLine="Private Sub pan_ganon_Click";
RDebugUtils.currentLine=47120385;
 //BA.debugLineNum = 47120385;BA.debugLine="StartActivity(ganon_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ganon_activity.getObject()));
RDebugUtils.currentLine=47120387;
 //BA.debugLineNum = 47120387;BA.debugLine="End Sub";
return "";
}
public static String  _pan_help_kharid_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_help_kharid_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_help_kharid_click", null));}
RDebugUtils.currentLine=48496640;
 //BA.debugLineNum = 48496640;BA.debugLine="Private Sub pan_help_kharid_Click";
RDebugUtils.currentLine=48496643;
 //BA.debugLineNum = 48496643;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=48496644;
 //BA.debugLineNum = 48496644;BA.debugLine="StartActivity(help_kharid_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._help_kharid_activity.getObject()));
 }else {
RDebugUtils.currentLine=48496646;
 //BA.debugLineNum = 48496646;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 };
RDebugUtils.currentLine=48496651;
 //BA.debugLineNum = 48496651;BA.debugLine="End Sub";
return "";
}
public static String  _pan_help_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_help_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_help_touch", new Object[] {_action,_x,_y}));}
RDebugUtils.currentLine=46071808;
 //BA.debugLineNum = 46071808;BA.debugLine="Private Sub pan_help_Touch (Action As Int, X As Fl";
RDebugUtils.currentLine=46071810;
 //BA.debugLineNum = 46071810;BA.debugLine="If (Action=0)Then";
if ((_action==0)) { 
RDebugUtils.currentLine=46071811;
 //BA.debugLineNum = 46071811;BA.debugLine="index_x_start_swap=x";
_index_x_start_swap = (int) (_x);
RDebugUtils.currentLine=46071812;
 //BA.debugLineNum = 46071812;BA.debugLine="If (index_curent_img=4)Then";
if ((_index_curent_img==4)) { 
RDebugUtils.currentLine=46071813;
 //BA.debugLineNum = 46071813;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
RDebugUtils.currentLine=46071816;
 //BA.debugLineNum = 46071816;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=46071817;
 //BA.debugLineNum = 46071817;BA.debugLine="If(X<(index_x_start_swap-150))Then";
if ((_x<(_index_x_start_swap-150))) { 
RDebugUtils.currentLine=46071820;
 //BA.debugLineNum = 46071820;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
RDebugUtils.currentLine=46071821;
 //BA.debugLineNum = 46071821;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
RDebugUtils.currentLine=46071822;
 //BA.debugLineNum = 46071822;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 }else 
{RDebugUtils.currentLine=46071826;
 //BA.debugLineNum = 46071826;BA.debugLine="Else If(X>(index_x_start_swap+150))Then";
if ((_x>(_index_x_start_swap+150))) { 
RDebugUtils.currentLine=46071829;
 //BA.debugLineNum = 46071829;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
RDebugUtils.currentLine=46071830;
 //BA.debugLineNum = 46071830;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
RDebugUtils.currentLine=46071831;
 //BA.debugLineNum = 46071831;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else 
{RDebugUtils.currentLine=46071835;
 //BA.debugLineNum = 46071835;BA.debugLine="Else If(index_x_start_swap<(pan_help.Width/2))Th";
if ((_index_x_start_swap<(mostCurrent._pan_help.getWidth()/(double)2))) { 
RDebugUtils.currentLine=46071837;
 //BA.debugLineNum = 46071837;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
RDebugUtils.currentLine=46071838;
 //BA.debugLineNum = 46071838;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
RDebugUtils.currentLine=46071839;
 //BA.debugLineNum = 46071839;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else 
{RDebugUtils.currentLine=46071842;
 //BA.debugLineNum = 46071842;BA.debugLine="Else If(index_x_start_swap>(pan_help.Width/2))Th";
if ((_index_x_start_swap>(mostCurrent._pan_help.getWidth()/(double)2))) { 
RDebugUtils.currentLine=46071844;
 //BA.debugLineNum = 46071844;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
RDebugUtils.currentLine=46071845;
 //BA.debugLineNum = 46071845;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
RDebugUtils.currentLine=46071846;
 //BA.debugLineNum = 46071846;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 }}}}
;
RDebugUtils.currentLine=46071851;
 //BA.debugLineNum = 46071851;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 };
RDebugUtils.currentLine=46071854;
 //BA.debugLineNum = 46071854;BA.debugLine="End Sub";
return "";
}
public static String  _pan_info_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_info_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_info_click", null));}
RDebugUtils.currentLine=44892160;
 //BA.debugLineNum = 44892160;BA.debugLine="Private Sub pan_info_Click";
RDebugUtils.currentLine=44892161;
 //BA.debugLineNum = 44892161;BA.debugLine="StartActivity(info_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._info_activity.getObject()));
RDebugUtils.currentLine=44892164;
 //BA.debugLineNum = 44892164;BA.debugLine="End Sub";
return "";
}
public static String  _pan_item_gozaresh_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_item_gozaresh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_item_gozaresh_click", null));}
anywheresoftware.b4a.objects.PanelWrapper _ba = null;
RDebugUtils.currentLine=45744128;
 //BA.debugLineNum = 45744128;BA.debugLine="Private Sub pan_item_gozaresh_Click";
RDebugUtils.currentLine=45744129;
 //BA.debugLineNum = 45744129;BA.debugLine="Dim Ba As Panel = Sender";
_ba = new anywheresoftware.b4a.objects.PanelWrapper();
_ba = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=45744131;
 //BA.debugLineNum = 45744131;BA.debugLine="current_gozaresh_id=Ba.Tag";
_current_gozaresh_id = (int)(BA.ObjectToNumber(_ba.getTag()));
RDebugUtils.currentLine=45744132;
 //BA.debugLineNum = 45744132;BA.debugLine="StartActivity(show_gozaresh_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._show_gozaresh_activity.getObject()));
RDebugUtils.currentLine=45744134;
 //BA.debugLineNum = 45744134;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lelp_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_lelp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_lelp_click", null));}
RDebugUtils.currentLine=46137344;
 //BA.debugLineNum = 46137344;BA.debugLine="Private Sub pan_lelp_Click";
RDebugUtils.currentLine=46137346;
 //BA.debugLineNum = 46137346;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lock_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_lock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_lock_click", null));}
RDebugUtils.currentLine=47972352;
 //BA.debugLineNum = 47972352;BA.debugLine="Private Sub pan_lock_Click";
RDebugUtils.currentLine=47972354;
 //BA.debugLineNum = 47972354;BA.debugLine="End Sub";
return "";
}
public static String  _pan_morakhasi_mah_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_morakhasi_mah_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_morakhasi_mah_click", null));}
RDebugUtils.currentLine=46727168;
 //BA.debugLineNum = 46727168;BA.debugLine="Private Sub pan_morakhasi_mah_Click";
RDebugUtils.currentLine=46727169;
 //BA.debugLineNum = 46727169;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
RDebugUtils.currentLine=46727170;
 //BA.debugLineNum = 46727170;BA.debugLine="TabHost1.CurrentTab=1";
mostCurrent._tabhost1.setCurrentTab((int) (1));
RDebugUtils.currentLine=46727172;
 //BA.debugLineNum = 46727172;BA.debugLine="End Sub";
return "";
}
public static String  _pan_notifi_all_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_notifi_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_notifi_all_click", null));}
RDebugUtils.currentLine=39911424;
 //BA.debugLineNum = 39911424;BA.debugLine="Private Sub pan_notifi_all_Click";
RDebugUtils.currentLine=39911426;
 //BA.debugLineNum = 39911426;BA.debugLine="End Sub";
return "";
}
public static String  _pan_payankar_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_payankar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_payankar_click", null));}
RDebugUtils.currentLine=44826624;
 //BA.debugLineNum = 44826624;BA.debugLine="Private Sub pan_payankar_Click";
RDebugUtils.currentLine=44826625;
 //BA.debugLineNum = 44826625;BA.debugLine="StartActivity(payankar_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._payankar_activity.getObject()));
RDebugUtils.currentLine=44826627;
 //BA.debugLineNum = 44826627;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_hogog_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_run_hogog_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_run_hogog_click", null));}
RDebugUtils.currentLine=42270720;
 //BA.debugLineNum = 42270720;BA.debugLine="Private Sub pan_run_hogog_Click";
RDebugUtils.currentLine=42270721;
 //BA.debugLineNum = 42270721;BA.debugLine="If (myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
RDebugUtils.currentLine=42270722;
 //BA.debugLineNum = 42270722;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
 }else {
RDebugUtils.currentLine=42270724;
 //BA.debugLineNum = 42270724;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
 };
RDebugUtils.currentLine=42270730;
 //BA.debugLineNum = 42270730;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_morakhasi_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_run_morakhasi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_run_morakhasi_click", null));}
RDebugUtils.currentLine=42205184;
 //BA.debugLineNum = 42205184;BA.debugLine="Private Sub pan_run_morakhasi_Click";
RDebugUtils.currentLine=42205186;
 //BA.debugLineNum = 42205186;BA.debugLine="StartActivity(morakhasi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._morakhasi_activity.getObject()));
RDebugUtils.currentLine=42205193;
 //BA.debugLineNum = 42205193;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_setting_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_setting_click", null));}
RDebugUtils.currentLine=47185920;
 //BA.debugLineNum = 47185920;BA.debugLine="Private Sub pan_setting_Click";
RDebugUtils.currentLine=47185921;
 //BA.debugLineNum = 47185921;BA.debugLine="StartActivity(setting_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_activity.getObject()));
RDebugUtils.currentLine=47185922;
 //BA.debugLineNum = 47185922;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=47185923;
 //BA.debugLineNum = 47185923;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_hogog_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_setting_hogog_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_setting_hogog_click", null));}
RDebugUtils.currentLine=42139648;
 //BA.debugLineNum = 42139648;BA.debugLine="Private Sub pan_setting_hogog_Click";
RDebugUtils.currentLine=42139649;
 //BA.debugLineNum = 42139649;BA.debugLine="StartActivity(setting_hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_hogog_activity.getObject()));
RDebugUtils.currentLine=42139652;
 //BA.debugLineNum = 42139652;BA.debugLine="End Sub";
return "";
}
public static String  _pan_shift_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_shift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_shift_click", null));}
RDebugUtils.currentLine=47316992;
 //BA.debugLineNum = 47316992;BA.debugLine="Private Sub pan_shift_Click";
RDebugUtils.currentLine=47316994;
 //BA.debugLineNum = 47316994;BA.debugLine="StartActivity(shift_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._shift_activity.getObject()));
RDebugUtils.currentLine=47316996;
 //BA.debugLineNum = 47316996;BA.debugLine="End Sub";
return "";
}
public static String  _pan_taghvim_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_taghvim_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_taghvim_click", null));}
RDebugUtils.currentLine=47382528;
 //BA.debugLineNum = 47382528;BA.debugLine="Private Sub pan_taghvim_Click";
RDebugUtils.currentLine=47382529;
 //BA.debugLineNum = 47382529;BA.debugLine="pan_shift_Click";
_pan_shift_click();
RDebugUtils.currentLine=47382530;
 //BA.debugLineNum = 47382530;BA.debugLine="End Sub";
return "";
}
public static String  _panel1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel1_click", null));}
RDebugUtils.currentLine=47579136;
 //BA.debugLineNum = 47579136;BA.debugLine="Private Sub Panel1_Click";
RDebugUtils.currentLine=47579138;
 //BA.debugLineNum = 47579138;BA.debugLine="End Sub";
return "";
}
public static String  _panel10_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel10_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel10_click", null));}
RDebugUtils.currentLine=48365568;
 //BA.debugLineNum = 48365568;BA.debugLine="Private Sub Panel10_Click";
RDebugUtils.currentLine=48365570;
 //BA.debugLineNum = 48365570;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel4_click", null));}
RDebugUtils.currentLine=42795008;
 //BA.debugLineNum = 42795008;BA.debugLine="Private Sub Panel4_Click";
RDebugUtils.currentLine=42795010;
 //BA.debugLineNum = 42795010;BA.debugLine="End Sub";
return "";
}
public static String  _panel5_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel5_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel5_click", null));}
RDebugUtils.currentLine=46989312;
 //BA.debugLineNum = 46989312;BA.debugLine="Private Sub Panel5_Click";
RDebugUtils.currentLine=46989314;
 //BA.debugLineNum = 46989314;BA.debugLine="End Sub";
return "";
}
public static String  _panel6_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel6_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel6_click", null));}
RDebugUtils.currentLine=47775744;
 //BA.debugLineNum = 47775744;BA.debugLine="Private Sub Panel6_Click";
RDebugUtils.currentLine=47775746;
 //BA.debugLineNum = 47775746;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=44498944;
 //BA.debugLineNum = 44498944;BA.debugLine="Private Sub pik_day_bala1_Click";
RDebugUtils.currentLine=44498945;
 //BA.debugLineNum = 44498945;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=44498946;
 //BA.debugLineNum = 44498946;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=44498949;
 //BA.debugLineNum = 44498949;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=44498950;
 //BA.debugLineNum = 44498950;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=44498951;
 //BA.debugLineNum = 44498951;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=44498953;
 //BA.debugLineNum = 44498953;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=44498954;
 //BA.debugLineNum = 44498954;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=44498957;
 //BA.debugLineNum = 44498957;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=44498958;
 //BA.debugLineNum = 44498958;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=44498960;
 //BA.debugLineNum = 44498960;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=44498961;
 //BA.debugLineNum = 44498961;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=44498965;
 //BA.debugLineNum = 44498965;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=44498967;
 //BA.debugLineNum = 44498967;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=44564480;
 //BA.debugLineNum = 44564480;BA.debugLine="Private Sub pik_day_paeen1_Click";
RDebugUtils.currentLine=44564481;
 //BA.debugLineNum = 44564481;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=44564482;
 //BA.debugLineNum = 44564482;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=44564483;
 //BA.debugLineNum = 44564483;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=44564484;
 //BA.debugLineNum = 44564484;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=44564485;
 //BA.debugLineNum = 44564485;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=44564487;
 //BA.debugLineNum = 44564487;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=44564488;
 //BA.debugLineNum = 44564488;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=44564491;
 //BA.debugLineNum = 44564491;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=44564492;
 //BA.debugLineNum = 44564492;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=44564494;
 //BA.debugLineNum = 44564494;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=44564495;
 //BA.debugLineNum = 44564495;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=44564499;
 //BA.debugLineNum = 44564499;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=44564501;
 //BA.debugLineNum = 44564501;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_hour_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_hour_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=43646976;
 //BA.debugLineNum = 43646976;BA.debugLine="Private Sub pik_hour_bala1_Click";
RDebugUtils.currentLine=43646978;
 //BA.debugLineNum = 43646978;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
RDebugUtils.currentLine=43646979;
 //BA.debugLineNum = 43646979;BA.debugLine="pik_hour1.Text=int1+1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=43646983;
 //BA.debugLineNum = 43646983;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
RDebugUtils.currentLine=43646984;
 //BA.debugLineNum = 43646984;BA.debugLine="pik_hour1.Text=0";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=43646986;
 //BA.debugLineNum = 43646986;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
RDebugUtils.currentLine=43646987;
 //BA.debugLineNum = 43646987;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
RDebugUtils.currentLine=43646990;
 //BA.debugLineNum = 43646990;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(pik_hour1.Text";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_hour1.getText())))));
RDebugUtils.currentLine=43646992;
 //BA.debugLineNum = 43646992;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_hour_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_hour_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=43712512;
 //BA.debugLineNum = 43712512;BA.debugLine="Private Sub pik_hour_paeen1_Click";
RDebugUtils.currentLine=43712513;
 //BA.debugLineNum = 43712513;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
RDebugUtils.currentLine=43712514;
 //BA.debugLineNum = 43712514;BA.debugLine="pik_hour1.Text=int1-1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=43712516;
 //BA.debugLineNum = 43712516;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
RDebugUtils.currentLine=43712517;
 //BA.debugLineNum = 43712517;BA.debugLine="pik_hour1.Text=0";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=43712519;
 //BA.debugLineNum = 43712519;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
RDebugUtils.currentLine=43712520;
 //BA.debugLineNum = 43712520;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
RDebugUtils.currentLine=43712523;
 //BA.debugLineNum = 43712523;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(pik_hour1.Text";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_hour1.getText())))));
RDebugUtils.currentLine=43712524;
 //BA.debugLineNum = 43712524;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_min_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_min_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=43778048;
 //BA.debugLineNum = 43778048;BA.debugLine="Private Sub pik_min_bala1_Click";
RDebugUtils.currentLine=43778049;
 //BA.debugLineNum = 43778049;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
RDebugUtils.currentLine=43778050;
 //BA.debugLineNum = 43778050;BA.debugLine="pik_min1.Text=int1+1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=43778052;
 //BA.debugLineNum = 43778052;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
RDebugUtils.currentLine=43778053;
 //BA.debugLineNum = 43778053;BA.debugLine="pik_min1.Text=0";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=43778055;
 //BA.debugLineNum = 43778055;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
RDebugUtils.currentLine=43778056;
 //BA.debugLineNum = 43778056;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
RDebugUtils.currentLine=43778059;
 //BA.debugLineNum = 43778059;BA.debugLine="pik_min1.Text=myfunc.convert_adad(pik_min1.Text)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_min1.getText())))));
RDebugUtils.currentLine=43778061;
 //BA.debugLineNum = 43778061;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_min_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_min_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=43843584;
 //BA.debugLineNum = 43843584;BA.debugLine="Private Sub pik_min_paeen1_Click";
RDebugUtils.currentLine=43843585;
 //BA.debugLineNum = 43843585;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
RDebugUtils.currentLine=43843586;
 //BA.debugLineNum = 43843586;BA.debugLine="pik_min1.Text=int1-1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=43843588;
 //BA.debugLineNum = 43843588;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
RDebugUtils.currentLine=43843589;
 //BA.debugLineNum = 43843589;BA.debugLine="pik_min1.Text=0";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=43843591;
 //BA.debugLineNum = 43843591;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
RDebugUtils.currentLine=43843592;
 //BA.debugLineNum = 43843592;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
RDebugUtils.currentLine=43843594;
 //BA.debugLineNum = 43843594;BA.debugLine="pik_min1.Text=myfunc.convert_adad(pik_min1.Text)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_min1.getText())))));
RDebugUtils.currentLine=43843596;
 //BA.debugLineNum = 43843596;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=44236800;
 //BA.debugLineNum = 44236800;BA.debugLine="Private Sub pik_moon_bala1_Click";
RDebugUtils.currentLine=44236801;
 //BA.debugLineNum = 44236801;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=44236802;
 //BA.debugLineNum = 44236802;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
RDebugUtils.currentLine=44236804;
 //BA.debugLineNum = 44236804;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=44236805;
 //BA.debugLineNum = 44236805;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=44236807;
 //BA.debugLineNum = 44236807;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=44236808;
 //BA.debugLineNum = 44236808;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=44236810;
 //BA.debugLineNum = 44236810;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=44236812;
 //BA.debugLineNum = 44236812;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=44302336;
 //BA.debugLineNum = 44302336;BA.debugLine="Private Sub pik_moon_paeen1_Click";
RDebugUtils.currentLine=44302337;
 //BA.debugLineNum = 44302337;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=44302338;
 //BA.debugLineNum = 44302338;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
RDebugUtils.currentLine=44302340;
 //BA.debugLineNum = 44302340;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=44302341;
 //BA.debugLineNum = 44302341;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=44302343;
 //BA.debugLineNum = 44302343;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=44302344;
 //BA.debugLineNum = 44302344;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=44302346;
 //BA.debugLineNum = 44302346;BA.debugLine="pik_moon1.Text=moon.Get(myfunc.fa2en(pik_moon1.Ta";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
RDebugUtils.currentLine=44302348;
 //BA.debugLineNum = 44302348;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_day1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_day1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=44171264;
 //BA.debugLineNum = 44171264;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
RDebugUtils.currentLine=44171265;
 //BA.debugLineNum = 44171265;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=44171266;
 //BA.debugLineNum = 44171266;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=44171267;
 //BA.debugLineNum = 44171267;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=44171270;
 //BA.debugLineNum = 44171270;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=44171272;
 //BA.debugLineNum = 44171272;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=44171273;
 //BA.debugLineNum = 44171273;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
RDebugUtils.currentLine=44171274;
 //BA.debugLineNum = 44171274;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=44171275;
 //BA.debugLineNum = 44171275;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=44171277;
 //BA.debugLineNum = 44171277;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=44171278;
 //BA.debugLineNum = 44171278;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
RDebugUtils.currentLine=44171279;
 //BA.debugLineNum = 44171279;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=44171280;
 //BA.debugLineNum = 44171280;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=44171283;
 //BA.debugLineNum = 44171283;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=44171284;
 //BA.debugLineNum = 44171284;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=44171285;
 //BA.debugLineNum = 44171285;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=44171287;
 //BA.debugLineNum = 44171287;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=44171288;
 //BA.debugLineNum = 44171288;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=44171291;
 //BA.debugLineNum = 44171291;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=44171292;
 //BA.debugLineNum = 44171292;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=44171294;
 //BA.debugLineNum = 44171294;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=44171295;
 //BA.debugLineNum = 44171295;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=44171299;
 //BA.debugLineNum = 44171299;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 };
RDebugUtils.currentLine=44171302;
 //BA.debugLineNum = 44171302;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_hour1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_hour1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_hour1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=43909120;
 //BA.debugLineNum = 43909120;BA.debugLine="Private Sub pik_pan_hour1_Touch (Action As Int, X";
RDebugUtils.currentLine=43909121;
 //BA.debugLineNum = 43909121;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=43909122;
 //BA.debugLineNum = 43909122;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=43909123;
 //BA.debugLineNum = 43909123;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=43909126;
 //BA.debugLineNum = 43909126;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=43909128;
 //BA.debugLineNum = 43909128;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=43909129;
 //BA.debugLineNum = 43909129;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))-1);
RDebugUtils.currentLine=43909130;
 //BA.debugLineNum = 43909130;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=43909131;
 //BA.debugLineNum = 43909131;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=43909133;
 //BA.debugLineNum = 43909133;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=43909134;
 //BA.debugLineNum = 43909134;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))+1);
RDebugUtils.currentLine=43909135;
 //BA.debugLineNum = 43909135;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=43909136;
 //BA.debugLineNum = 43909136;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=43909139;
 //BA.debugLineNum = 43909139;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
RDebugUtils.currentLine=43909140;
 //BA.debugLineNum = 43909140;BA.debugLine="pik_hour1.Text=0";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=43909142;
 //BA.debugLineNum = 43909142;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
RDebugUtils.currentLine=43909143;
 //BA.debugLineNum = 43909143;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
RDebugUtils.currentLine=43909146;
 //BA.debugLineNum = 43909146;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(pik_hour1.Tex";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_hour1.getText())))));
 };
RDebugUtils.currentLine=43909151;
 //BA.debugLineNum = 43909151;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_min1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_min1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_min1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=43974656;
 //BA.debugLineNum = 43974656;BA.debugLine="Private Sub pik_pan_min1_Touch (Action As Int, X A";
RDebugUtils.currentLine=43974657;
 //BA.debugLineNum = 43974657;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=43974658;
 //BA.debugLineNum = 43974658;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=43974659;
 //BA.debugLineNum = 43974659;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=43974662;
 //BA.debugLineNum = 43974662;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=43974664;
 //BA.debugLineNum = 43974664;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=43974666;
 //BA.debugLineNum = 43974666;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))-1);
RDebugUtils.currentLine=43974667;
 //BA.debugLineNum = 43974667;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=43974670;
 //BA.debugLineNum = 43974670;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=43974672;
 //BA.debugLineNum = 43974672;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=43974674;
 //BA.debugLineNum = 43974674;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))+1);
RDebugUtils.currentLine=43974675;
 //BA.debugLineNum = 43974675;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=43974678;
 //BA.debugLineNum = 43974678;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=43974682;
 //BA.debugLineNum = 43974682;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
RDebugUtils.currentLine=43974683;
 //BA.debugLineNum = 43974683;BA.debugLine="pik_min1.Text=0";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=43974686;
 //BA.debugLineNum = 43974686;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
RDebugUtils.currentLine=43974687;
 //BA.debugLineNum = 43974687;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
RDebugUtils.currentLine=43974689;
 //BA.debugLineNum = 43974689;BA.debugLine="pik_min1.Text=myfunc.convert_adad(pik_min1.Text)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_min1.getText())))));
 };
RDebugUtils.currentLine=43974695;
 //BA.debugLineNum = 43974695;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_moon1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_moon1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=44040192;
 //BA.debugLineNum = 44040192;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
RDebugUtils.currentLine=44040193;
 //BA.debugLineNum = 44040193;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=44040194;
 //BA.debugLineNum = 44040194;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=44040195;
 //BA.debugLineNum = 44040195;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=44040198;
 //BA.debugLineNum = 44040198;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=44040200;
 //BA.debugLineNum = 44040200;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=44040201;
 //BA.debugLineNum = 44040201;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
RDebugUtils.currentLine=44040202;
 //BA.debugLineNum = 44040202;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=44040203;
 //BA.debugLineNum = 44040203;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=44040205;
 //BA.debugLineNum = 44040205;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=44040206;
 //BA.debugLineNum = 44040206;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
RDebugUtils.currentLine=44040207;
 //BA.debugLineNum = 44040207;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=44040208;
 //BA.debugLineNum = 44040208;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=44040211;
 //BA.debugLineNum = 44040211;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=44040212;
 //BA.debugLineNum = 44040212;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=44040214;
 //BA.debugLineNum = 44040214;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=44040215;
 //BA.debugLineNum = 44040215;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=44040217;
 //BA.debugLineNum = 44040217;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
RDebugUtils.currentLine=44040220;
 //BA.debugLineNum = 44040220;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_year1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_year1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=44105728;
 //BA.debugLineNum = 44105728;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
RDebugUtils.currentLine=44105729;
 //BA.debugLineNum = 44105729;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=44105730;
 //BA.debugLineNum = 44105730;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=44105731;
 //BA.debugLineNum = 44105731;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=44105734;
 //BA.debugLineNum = 44105734;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=44105736;
 //BA.debugLineNum = 44105736;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
RDebugUtils.currentLine=44105737;
 //BA.debugLineNum = 44105737;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
RDebugUtils.currentLine=44105738;
 //BA.debugLineNum = 44105738;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=44105739;
 //BA.debugLineNum = 44105739;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=44105741;
 //BA.debugLineNum = 44105741;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
RDebugUtils.currentLine=44105742;
 //BA.debugLineNum = 44105742;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
RDebugUtils.currentLine=44105743;
 //BA.debugLineNum = 44105743;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=44105744;
 //BA.debugLineNum = 44105744;BA.debugLine="num=y";
_num = (int) (_y);
 };
RDebugUtils.currentLine=44105747;
 //BA.debugLineNum = 44105747;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=44105748;
 //BA.debugLineNum = 44105748;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=44105750;
 //BA.debugLineNum = 44105750;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=44105751;
 //BA.debugLineNum = 44105751;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
RDebugUtils.currentLine=44105756;
 //BA.debugLineNum = 44105756;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=44367872;
 //BA.debugLineNum = 44367872;BA.debugLine="Private Sub pik_year_bala1_Click";
RDebugUtils.currentLine=44367873;
 //BA.debugLineNum = 44367873;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=44367874;
 //BA.debugLineNum = 44367874;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=44367876;
 //BA.debugLineNum = 44367876;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=44367877;
 //BA.debugLineNum = 44367877;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=44367879;
 //BA.debugLineNum = 44367879;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=44367880;
 //BA.debugLineNum = 44367880;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=44367883;
 //BA.debugLineNum = 44367883;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=44433408;
 //BA.debugLineNum = 44433408;BA.debugLine="Private Sub pik_year_paeen1_Click";
RDebugUtils.currentLine=44433409;
 //BA.debugLineNum = 44433409;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=44433410;
 //BA.debugLineNum = 44433410;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=44433412;
 //BA.debugLineNum = 44433412;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=44433413;
 //BA.debugLineNum = 44433413;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=44433415;
 //BA.debugLineNum = 44433415;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=44433416;
 //BA.debugLineNum = 44433416;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=44433419;
 //BA.debugLineNum = 44433419;BA.debugLine="End Sub";
return "";
}
public static String  _poolakey_connectionfailed(ir.cafebazaar.poolakey.b4a.B4AException _error) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "poolakey_connectionfailed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "poolakey_connectionfailed", new Object[] {_error}));}
RDebugUtils.currentLine=39256064;
 //BA.debugLineNum = 39256064;BA.debugLine="Private Sub Poolakey_ConnectionFailed (Error As Po";
RDebugUtils.currentLine=39256065;
 //BA.debugLineNum = 39256065;BA.debugLine="Log(\"Service: Failed to Connect\" & CRLF & Error.E";
anywheresoftware.b4a.keywords.Common.LogImpl("339256065","Service: Failed to Connect"+anywheresoftware.b4a.keywords.Common.CRLF+_error.getErrorMessage(),0);
RDebugUtils.currentLine=39256066;
 //BA.debugLineNum = 39256066;BA.debugLine="MsgboxAsync(\"1- از نصب بودن برنامه بازار اطمینان";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("1- از نصب بودن برنامه بازار اطمینان یابید."+anywheresoftware.b4a.keywords.Common.CRLF+" 2- برنامه ها را ببندید و دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
RDebugUtils.currentLine=39256067;
 //BA.debugLineNum = 39256067;BA.debugLine="End Sub";
return "";
}
public static String  _poolakey_connectionsucceed() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "poolakey_connectionsucceed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "poolakey_connectionsucceed", null));}
RDebugUtils.currentLine=39124992;
 //BA.debugLineNum = 39124992;BA.debugLine="Private Sub Poolakey_ConnectionSucceed";
RDebugUtils.currentLine=39124993;
 //BA.debugLineNum = 39124993;BA.debugLine="Log(\"Service: Connected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("339124993","Service: Connected",0);
RDebugUtils.currentLine=39124994;
 //BA.debugLineNum = 39124994;BA.debugLine="End Sub";
return "";
}
public static String  _poolakey_disconnected() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "poolakey_disconnected", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "poolakey_disconnected", null));}
RDebugUtils.currentLine=39190528;
 //BA.debugLineNum = 39190528;BA.debugLine="Private Sub Poolakey_Disconnected";
RDebugUtils.currentLine=39190529;
 //BA.debugLineNum = 39190529;BA.debugLine="Log(\"Service: Not Connected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("339190529","Service: Not Connected",0);
RDebugUtils.currentLine=39190530;
 //BA.debugLineNum = 39190530;BA.debugLine="End Sub";
return "";
}
public static String  _purchase_purchasecanceled() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "purchase_purchasecanceled", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "purchase_purchasecanceled", null));}
RDebugUtils.currentLine=40173568;
 //BA.debugLineNum = 40173568;BA.debugLine="Private Sub Purchase_PurchaseCanceled";
RDebugUtils.currentLine=40173569;
 //BA.debugLineNum = 40173569;BA.debugLine="Log(\"کاربر کنسل کرد\")";
anywheresoftware.b4a.keywords.Common.LogImpl("340173569","کاربر کنسل کرد",0);
RDebugUtils.currentLine=40173570;
 //BA.debugLineNum = 40173570;BA.debugLine="End Sub";
return "";
}
public static String  _purchase_purchasefailed(ir.cafebazaar.poolakey.b4a.B4AException _error) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "purchase_purchasefailed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "purchase_purchasefailed", new Object[] {_error}));}
RDebugUtils.currentLine=40239104;
 //BA.debugLineNum = 40239104;BA.debugLine="Private Sub Purchase_PurchaseFailed (Error As Pool";
RDebugUtils.currentLine=40239105;
 //BA.debugLineNum = 40239105;BA.debugLine="Log(\"کاربر sss کرد\")";
anywheresoftware.b4a.keywords.Common.LogImpl("340239105","کاربر sss کرد",0);
RDebugUtils.currentLine=40239106;
 //BA.debugLineNum = 40239106;BA.debugLine="End Sub";
return "";
}
public static String  _purchase_purchasefailedtobeginflow(ir.cafebazaar.poolakey.b4a.B4AException _error) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "purchase_purchasefailedtobeginflow", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "purchase_purchasefailedtobeginflow", new Object[] {_error}));}
RDebugUtils.currentLine=40042496;
 //BA.debugLineNum = 40042496;BA.debugLine="Private Sub Purchase_PurchaseFailedToBeginFlow (Er";
RDebugUtils.currentLine=40042497;
 //BA.debugLineNum = 40042497;BA.debugLine="Log(Error)";
anywheresoftware.b4a.keywords.Common.LogImpl("340042497",BA.ObjectToString(_error),0);
RDebugUtils.currentLine=40042498;
 //BA.debugLineNum = 40042498;BA.debugLine="End Sub";
return "";
}
public static String  _purchase_purchasesucceed(ir.cafebazaar.poolakey.b4a.B4APurchaseInfo _purchaseinfo) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "purchase_purchasesucceed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "purchase_purchasesucceed", new Object[] {_purchaseinfo}));}
RDebugUtils.currentLine=40108032;
 //BA.debugLineNum = 40108032;BA.debugLine="Private Sub Purchase_PurchaseSucceed (PurchaseInfo";
RDebugUtils.currentLine=40108036;
 //BA.debugLineNum = 40108036;BA.debugLine="Log(\"p info : \"&PurchaseInfo.PurchaseToken)";
anywheresoftware.b4a.keywords.Common.LogImpl("340108036","p info : "+_purchaseinfo.getPurchaseToken(),0);
RDebugUtils.currentLine=40108039;
 //BA.debugLineNum = 40108039;BA.debugLine="If PurchaseInfo.ProductId=\"ezafekari2\" Then";
if ((_purchaseinfo.getProductId()).equals("ezafekari2")) { 
RDebugUtils.currentLine=40108042;
 //BA.debugLineNum = 40108042;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\",\"\")";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
RDebugUtils.currentLine=40108043;
 //BA.debugLineNum = 40108043;BA.debugLine="MsgboxAsync(\"پرداخت انجام شده است\",\"انجام شد\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("پرداخت انجام شده است"),BA.ObjectToCharSequence("انجام شد"),processBA);
RDebugUtils.currentLine=40108044;
 //BA.debugLineNum = 40108044;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی ا";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=40108049;
 //BA.debugLineNum = 40108049;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
RDebugUtils.currentLine=40108050;
 //BA.debugLineNum = 40108050;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
RDebugUtils.currentLine=40108058;
 //BA.debugLineNum = 40108058;BA.debugLine="End Sub";
return "";
}
public static String  _query_queryfailed(ir.cafebazaar.poolakey.b4a.B4AException _error) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "query_queryfailed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "query_queryfailed", new Object[] {_error}));}
RDebugUtils.currentLine=40370176;
 //BA.debugLineNum = 40370176;BA.debugLine="Private Sub Query_QueryFailed (Error As PoolakeyEx";
RDebugUtils.currentLine=40370177;
 //BA.debugLineNum = 40370177;BA.debugLine="Log(\"Query failed: \" & Error)";
anywheresoftware.b4a.keywords.Common.LogImpl("340370177","Query failed: "+BA.ObjectToString(_error),0);
RDebugUtils.currentLine=40370178;
 //BA.debugLineNum = 40370178;BA.debugLine="Try";
try {RDebugUtils.currentLine=40370179;
 //BA.debugLineNum = 40370179;BA.debugLine="get_request_kharid";
_get_request_kharid();
 } 
       catch (Exception e5) {
			processBA.setLastException(e5);RDebugUtils.currentLine=40370181;
 //BA.debugLineNum = 40370181;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("340370181",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=40370183;
 //BA.debugLineNum = 40370183;BA.debugLine="End Sub";
return "";
}
public static String  _query_querysucceed(ir.cafebazaar.poolakey.b4a.B4APurchaseQuery _query) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "query_querysucceed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "query_querysucceed", new Object[] {_query}));}
int _i = 0;
RDebugUtils.currentLine=40304640;
 //BA.debugLineNum = 40304640;BA.debugLine="Private Sub Query_QuerySucceed (Query As PoolakeyP";
RDebugUtils.currentLine=40304641;
 //BA.debugLineNum = 40304641;BA.debugLine="Log(\"query: \"&Query)";
anywheresoftware.b4a.keywords.Common.LogImpl("340304641","query: "+BA.ObjectToString(_query),0);
RDebugUtils.currentLine=40304642;
 //BA.debugLineNum = 40304642;BA.debugLine="If(Query.Size<>0)Then";
if ((_query.getSize()!=0)) { 
RDebugUtils.currentLine=40304643;
 //BA.debugLineNum = 40304643;BA.debugLine="For i = 0 To Query.Size - 1";
{
final int step3 = 1;
final int limit3 = (int) (_query.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=40304645;
 //BA.debugLineNum = 40304645;BA.debugLine="If (Query.Get(i).ProductId=\"ezafekari2\") Then";
if (((_query.Get(_i).getProductId()).equals("ezafekari2"))) { 
RDebugUtils.currentLine=40304649;
 //BA.debugLineNum = 40304649;BA.debugLine="Try";
try {RDebugUtils.currentLine=40304651;
 //BA.debugLineNum = 40304651;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\",\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
RDebugUtils.currentLine=40304652;
 //BA.debugLineNum = 40304652;BA.debugLine="MsgboxAsync(\"پرداخت انجام شده است\",\"انجام شد\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("پرداخت انجام شده است"),BA.ObjectToCharSequence("انجام شد"),processBA);
RDebugUtils.currentLine=40304653;
 //BA.debugLineNum = 40304653;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=40304655;
 //BA.debugLineNum = 40304655;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
RDebugUtils.currentLine=40304656;
 //BA.debugLineNum = 40304656;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 } 
       catch (Exception e12) {
			processBA.setLastException(e12);RDebugUtils.currentLine=40304660;
 //BA.debugLineNum = 40304660;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("340304660",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 }else {
RDebugUtils.currentLine=40304665;
 //BA.debugLineNum = 40304665;BA.debugLine="Try";
try {RDebugUtils.currentLine=40304667;
 //BA.debugLineNum = 40304667;BA.debugLine="get_request_kharid";
_get_request_kharid();
 } 
       catch (Exception e18) {
			processBA.setLastException(e18);RDebugUtils.currentLine=40304669;
 //BA.debugLineNum = 40304669;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("340304669",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
 }
};
 }else {
RDebugUtils.currentLine=40304681;
 //BA.debugLineNum = 40304681;BA.debugLine="Try";
try {RDebugUtils.currentLine=40304683;
 //BA.debugLineNum = 40304683;BA.debugLine="get_request_kharid";
_get_request_kharid();
 } 
       catch (Exception e26) {
			processBA.setLastException(e26);RDebugUtils.currentLine=40304685;
 //BA.debugLineNum = 40304685;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("340304685",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
RDebugUtils.currentLine=40304691;
 //BA.debugLineNum = 40304691;BA.debugLine="End Sub";
return "";
}
public static boolean  _rspop_noe_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_noe_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_noe_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=42467328;
 //BA.debugLineNum = 42467328;BA.debugLine="Sub rsPOP_noe_MenuItemClick (ItemId As Int) As Boo";
RDebugUtils.currentLine=42467330;
 //BA.debugLineNum = 42467330;BA.debugLine="Select ItemId";
switch (_itemid) {
case 0: {
RDebugUtils.currentLine=42467332;
 //BA.debugLineNum = 42467332;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
RDebugUtils.currentLine=42467334;
 //BA.debugLineNum = 42467334;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
RDebugUtils.currentLine=42467336;
 //BA.debugLineNum = 42467336;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
RDebugUtils.currentLine=42467338;
 //BA.debugLineNum = 42467338;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
RDebugUtils.currentLine=42467342;
 //BA.debugLineNum = 42467342;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
RDebugUtils.currentLine=42467343;
 //BA.debugLineNum = 42467343;BA.debugLine="index_noe_morakhasi=ItemId";
_index_noe_morakhasi = _itemid;
RDebugUtils.currentLine=42467344;
 //BA.debugLineNum = 42467344;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=42467345;
 //BA.debugLineNum = 42467345;BA.debugLine="End Sub";
return false;
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_moon_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_moon_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=44695552;
 //BA.debugLineNum = 44695552;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=44695553;
 //BA.debugLineNum = 44695553;BA.debugLine="Dim moon_num As String";
_moon_num = "";
RDebugUtils.currentLine=44695555;
 //BA.debugLineNum = 44695555;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=44695558;
 //BA.debugLineNum = 44695558;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=44695559;
 //BA.debugLineNum = 44695559;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
RDebugUtils.currentLine=44695560;
 //BA.debugLineNum = 44695560;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_gozaresh_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_gozaresh_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_gozaresh_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=47644672;
 //BA.debugLineNum = 47644672;BA.debugLine="Private Sub sp_year_gozaresh_ItemClick (Position A";
RDebugUtils.currentLine=47644673;
 //BA.debugLineNum = 47644673;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
RDebugUtils.currentLine=47644674;
 //BA.debugLineNum = 47644674;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=44630016;
 //BA.debugLineNum = 44630016;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=44630021;
 //BA.debugLineNum = 44630021;BA.debugLine="Dim moon_num As String";
_moon_num = "";
RDebugUtils.currentLine=44630022;
 //BA.debugLineNum = 44630022;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=44630024;
 //BA.debugLineNum = 44630024;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=44630026;
 //BA.debugLineNum = 44630026;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
RDebugUtils.currentLine=44630028;
 //BA.debugLineNum = 44630028;BA.debugLine="End Sub";
return "";
}
public static String  _tatil_hast() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tatil_hast", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tatil_hast", null));}
RDebugUtils.currentLine=43581440;
 //BA.debugLineNum = 43581440;BA.debugLine="Sub tatil_hast";
RDebugUtils.currentLine=43581442;
 //BA.debugLineNum = 43581442;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=43581443;
 //BA.debugLineNum = 43581443;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=43581444;
 //BA.debugLineNum = 43581444;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=True";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=43581445;
 //BA.debugLineNum = 43581445;BA.debugLine="ckb_ezaf_taradod_fs.Visible=True";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=43581448;
 //BA.debugLineNum = 43581448;BA.debugLine="radio_ez_adi.Enabled=True";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=43581449;
 //BA.debugLineNum = 43581449;BA.debugLine="radio_ez_fog.Enabled=True";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=43581452;
 //BA.debugLineNum = 43581452;BA.debugLine="lbl_ezaf_taradod.Text=\"افزودن به اضافه کاری \"&((m";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("افزودن به اضافه کاری "+BA.ObjectToString(((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_tim_min).Get((int) (0)))))+" ساعت و "+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_tim_min)).Get((int) (1)))+" دقیقه "));
RDebugUtils.currentLine=43581454;
 //BA.debugLineNum = 43581454;BA.debugLine="lbl_ezaf_taradod_fs.Text=lbl_ezaf_taradod.Text";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(mostCurrent._lbl_ezaf_taradod.getText()));
RDebugUtils.currentLine=43581457;
 //BA.debugLineNum = 43581457;BA.debugLine="End Sub";
return "";
}
public static String  _tatil_nist() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tatil_nist", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tatil_nist", null));}
int _min_satkari_inweek = 0;
RDebugUtils.currentLine=43515904;
 //BA.debugLineNum = 43515904;BA.debugLine="Sub tatil_nist";
RDebugUtils.currentLine=43515905;
 //BA.debugLineNum = 43515905;BA.debugLine="Dim min_satKari_inWeek As Int =myfunc.get_saatKar";
_min_satkari_inweek = mostCurrent._myfunc._get_saatkari_inweek /*int*/ (mostCurrent.activityBA,_day_inweek_id);
RDebugUtils.currentLine=43515907;
 //BA.debugLineNum = 43515907;BA.debugLine="If(tim_min>min_satKari_inWeek) Then";
if ((_tim_min>_min_satkari_inweek)) { 
RDebugUtils.currentLine=43515910;
 //BA.debugLineNum = 43515910;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=43515911;
 //BA.debugLineNum = 43515911;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=43515912;
 //BA.debugLineNum = 43515912;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=True";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=43515913;
 //BA.debugLineNum = 43515913;BA.debugLine="ckb_ezaf_taradod_fs.Visible=True";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=43515916;
 //BA.debugLineNum = 43515916;BA.debugLine="radio_ez_adi.Enabled=True";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=43515917;
 //BA.debugLineNum = 43515917;BA.debugLine="radio_ez_fog.Enabled=True";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=43515920;
 //BA.debugLineNum = 43515920;BA.debugLine="lbl_ezaf_taradod.Text=\"افزودن به اضافه کاری \"&((";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("افزودن به اضافه کاری "+BA.ObjectToString(((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_min_satkari_inweek)).Get((int) (0)))))+" ساعت و "+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_min_satkari_inweek))).Get((int) (1)))+" دقیقه "));
RDebugUtils.currentLine=43515922;
 //BA.debugLineNum = 43515922;BA.debugLine="lbl_ezaf_taradod_fs.Text=lbl_ezaf_taradod.Text";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(mostCurrent._lbl_ezaf_taradod.getText()));
 }else {
RDebugUtils.currentLine=43515925;
 //BA.debugLineNum = 43515925;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=43515926;
 //BA.debugLineNum = 43515926;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43515927;
 //BA.debugLineNum = 43515927;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43515928;
 //BA.debugLineNum = 43515928;BA.debugLine="radio_ez_adi.Enabled=False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43515929;
 //BA.debugLineNum = 43515929;BA.debugLine="radio_ez_fog.Enabled=False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43515930;
 //BA.debugLineNum = 43515930;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=43515931;
 //BA.debugLineNum = 43515931;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43515932;
 //BA.debugLineNum = 43515932;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=43515935;
 //BA.debugLineNum = 43515935;BA.debugLine="End Sub";
return "";
}
public static String  _tim_check_update_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_check_update_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_check_update_tick", null));}
RDebugUtils.currentLine=39321600;
 //BA.debugLineNum = 39321600;BA.debugLine="Sub tim_check_update_Tick";
RDebugUtils.currentLine=39321601;
 //BA.debugLineNum = 39321601;BA.debugLine="chk_update_auto";
_chk_update_auto();
RDebugUtils.currentLine=39321602;
 //BA.debugLineNum = 39321602;BA.debugLine="Log(\"now cheking ....\")";
anywheresoftware.b4a.keywords.Common.LogImpl("339321602","now cheking ....",0);
RDebugUtils.currentLine=39321603;
 //BA.debugLineNum = 39321603;BA.debugLine="tim_check_update.Enabled=False";
_tim_check_update.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=39321604;
 //BA.debugLineNum = 39321604;BA.debugLine="End Sub";
return "";
}
public static String  _tim_lock_lbl_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_lock_lbl_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_lock_lbl_tick", null));}
RDebugUtils.currentLine=40566784;
 //BA.debugLineNum = 40566784;BA.debugLine="Sub tim_lock_lbl_Tick";
RDebugUtils.currentLine=40566785;
 //BA.debugLineNum = 40566785;BA.debugLine="If(stat_finger=0)Then";
if ((_stat_finger==0)) { 
RDebugUtils.currentLine=40566786;
 //BA.debugLineNum = 40566786;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
mostCurrent._lbl_finger.setTextColor(((int)0xff0b6200));
RDebugUtils.currentLine=40566787;
 //BA.debugLineNum = 40566787;BA.debugLine="stat_finger=1";
_stat_finger = (int) (1);
 }else {
RDebugUtils.currentLine=40566789;
 //BA.debugLineNum = 40566789;BA.debugLine="lbl_finger.TextColor=0xFF2FFF00";
mostCurrent._lbl_finger.setTextColor(((int)0xff2fff00));
RDebugUtils.currentLine=40566790;
 //BA.debugLineNum = 40566790;BA.debugLine="stat_finger=0";
_stat_finger = (int) (0);
 };
RDebugUtils.currentLine=40566792;
 //BA.debugLineNum = 40566792;BA.debugLine="End Sub";
return "";
}
public static String  _tim_msg_newyear_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_msg_newyear_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_msg_newyear_tick", null));}
RDebugUtils.currentLine=39387136;
 //BA.debugLineNum = 39387136;BA.debugLine="Sub tim_msg_newYear_Tick";
RDebugUtils.currentLine=39387137;
 //BA.debugLineNum = 39387137;BA.debugLine="pan_all_msgNewYear.Visible=True";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=39387139;
 //BA.debugLineNum = 39387139;BA.debugLine="tim_msg_newYear.Enabled=False";
_tim_msg_newyear.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=39387140;
 //BA.debugLineNum = 39387140;BA.debugLine="End Sub";
return "";
}
public static String  _tim_msg_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_msg_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tim_msg_tick", null));}
RDebugUtils.currentLine=39714816;
 //BA.debugLineNum = 39714816;BA.debugLine="Sub tim_msg_Tick";
RDebugUtils.currentLine=39714819;
 //BA.debugLineNum = 39714819;BA.debugLine="ls1.Add(notif_code)";
mostCurrent._ls1.Add((Object)(mostCurrent._notif_code));
RDebugUtils.currentLine=39714820;
 //BA.debugLineNum = 39714820;BA.debugLine="ls2.Add(notif_matn)";
mostCurrent._ls2.Add((Object)(mostCurrent._notif_matn));
RDebugUtils.currentLine=39714821;
 //BA.debugLineNum = 39714821;BA.debugLine="ls3.Add(lbl_date_home.Text)";
mostCurrent._ls3.Add((Object)(mostCurrent._lbl_date_home.getText()));
RDebugUtils.currentLine=39714823;
 //BA.debugLineNum = 39714823;BA.debugLine="File.WriteList(File.DirInternal,\"ls1\",ls1)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1",mostCurrent._ls1);
RDebugUtils.currentLine=39714824;
 //BA.debugLineNum = 39714824;BA.debugLine="File.WriteList(File.DirInternal,\"ls2\",ls2)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls2",mostCurrent._ls2);
RDebugUtils.currentLine=39714825;
 //BA.debugLineNum = 39714825;BA.debugLine="File.WriteList(File.DirInternal,\"ls3\",ls3)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls3",mostCurrent._ls3);
RDebugUtils.currentLine=39714827;
 //BA.debugLineNum = 39714827;BA.debugLine="lbl_title_msgPan.Text=\"پیام جدید\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام جدید"));
RDebugUtils.currentLine=39714828;
 //BA.debugLineNum = 39714828;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=39714830;
 //BA.debugLineNum = 39714830;BA.debugLine="pan_notif.Top=20%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA));
RDebugUtils.currentLine=39714831;
 //BA.debugLineNum = 39714831;BA.debugLine="pan_notif.Height=50%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA));
RDebugUtils.currentLine=39714832;
 //BA.debugLineNum = 39714832;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
RDebugUtils.currentLine=39714835;
 //BA.debugLineNum = 39714835;BA.debugLine="web_msg_show.LoadHtml(\"<!DOCTYPE html><html><meta";
mostCurrent._web_msg_show.LoadHtml("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'><div style='background-color: #99ffff; font-size: 14px;'>"+"کد پیام : "+mostCurrent._notif_code+" - مورخ : "+mostCurrent._lbl_date_home.getText()+"</div><div style='background-color: #e6ffff; font-size: 18px;'><br>"+mostCurrent._notif_matn+"<br></div><br></body></html>");
RDebugUtils.currentLine=39714837;
 //BA.debugLineNum = 39714837;BA.debugLine="tim_msg.Enabled=False";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=39714838;
 //BA.debugLineNum = 39714838;BA.debugLine="End Sub";
return "";
}
public static int  _tim_vorod_conv_ezaf(String _tim1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tim_vorod_conv_ezaf", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "tim_vorod_conv_ezaf", new Object[] {_tim1}));}
String[] _ste_tim = null;
RDebugUtils.currentLine=47841280;
 //BA.debugLineNum = 47841280;BA.debugLine="Sub tim_vorod_conv_ezaf (tim1 As String) As Int";
RDebugUtils.currentLine=47841282;
 //BA.debugLineNum = 47841282;BA.debugLine="Dim ste_tim() As String";
_ste_tim = new String[(int) (0)];
java.util.Arrays.fill(_ste_tim,"");
RDebugUtils.currentLine=47841283;
 //BA.debugLineNum = 47841283;BA.debugLine="ste_tim=Regex.Split(\":\",tim1)";
_ste_tim = anywheresoftware.b4a.keywords.Common.Regex.Split(":",_tim1);
RDebugUtils.currentLine=47841286;
 //BA.debugLineNum = 47841286;BA.debugLine="Return (ste_tim(0)*60)+ste_tim(1) +saat_kar_min";
if (true) return (int) (((double)(Double.parseDouble(_ste_tim[(int) (0)]))*60)+(double)(Double.parseDouble(_ste_tim[(int) (1)]))+_saat_kar_min);
RDebugUtils.currentLine=47841289;
 //BA.debugLineNum = 47841289;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=43384832;
 //BA.debugLineNum = 43384832;BA.debugLine="Sub time_show_2";
RDebugUtils.currentLine=43384833;
 //BA.debugLineNum = 43384833;BA.debugLine="Try";
try {RDebugUtils.currentLine=43384835;
 //BA.debugLineNum = 43384835;BA.debugLine="Dim list_date_per1, list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=43384836;
 //BA.debugLineNum = 43384836;BA.debugLine="Dim list_date_miladi1, list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=43384837;
 //BA.debugLineNum = 43384837;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=43384838;
 //BA.debugLineNum = 43384838;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=43384839;
 //BA.debugLineNum = 43384839;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=43384840;
 //BA.debugLineNum = 43384840;BA.debugLine="list_date_miladi2.Initialize";
_list_date_miladi2.Initialize();
RDebugUtils.currentLine=43384843;
 //BA.debugLineNum = 43384843;BA.debugLine="list_date_per1 = strfun.Split(lbl_date1.Text, \"/";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/");
RDebugUtils.currentLine=43384844;
 //BA.debugLineNum = 43384844;BA.debugLine="list_date_per2 = strfun.Split(lbl_date2.Text, \"/";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/");
RDebugUtils.currentLine=43384847;
 //BA.debugLineNum = 43384847;BA.debugLine="Dim dat_mil_1 As String = persianDate.PersianToG";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=43384848;
 //BA.debugLineNum = 43384848;BA.debugLine="Dim dat_mil_2 As String = persianDate.PersianToG";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=43384851;
 //BA.debugLineNum = 43384851;BA.debugLine="list_date_miladi1 = strfun.Split(dat_mil_1, \"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=43384852;
 //BA.debugLineNum = 43384852;BA.debugLine="list_date_miladi2 = strfun.Split(dat_mil_2, \"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=43384855;
 //BA.debugLineNum = 43384855;BA.debugLine="Dim date_end1 As String = list_date_miladi1.Get(";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=43384856;
 //BA.debugLineNum = 43384856;BA.debugLine="Dim date_end2 As String = list_date_miladi2.Get(";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=43384857;
 //BA.debugLineNum = 43384857;BA.debugLine="Dim time_end1 As String = lbl_tim1.Text & \":00\"";
_time_end1 = mostCurrent._lbl_tim1.getText()+":00";
RDebugUtils.currentLine=43384858;
 //BA.debugLineNum = 43384858;BA.debugLine="Dim time_end2 As String = lbl_tim2.Text & \":00\"";
_time_end2 = mostCurrent._lbl_tim2.getText()+":00";
RDebugUtils.currentLine=43384861;
 //BA.debugLineNum = 43384861;BA.debugLine="Dim tim1_long As Long = DateTime.DateTimeParse(m";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
RDebugUtils.currentLine=43384862;
 //BA.debugLineNum = 43384862;BA.debugLine="Dim tim2_long As Long = DateTime.DateTimeParse(m";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
RDebugUtils.currentLine=43384865;
 //BA.debugLineNum = 43384865;BA.debugLine="Dim period_between As Period = DateUtils.PeriodB";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,_tim1_long,_tim2_long);
RDebugUtils.currentLine=43384868;
 //BA.debugLineNum = 43384868;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=43384869;
 //BA.debugLineNum = 43384869;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
RDebugUtils.currentLine=43384870;
 //BA.debugLineNum = 43384870;BA.debugLine="If period_between.Years <> 0 Then str_show.Appen";
if (_period_between.Years!=0) { 
_str_show.Append(BA.NumberToString(_period_between.Years)+" سال و ");};
RDebugUtils.currentLine=43384871;
 //BA.debugLineNum = 43384871;BA.debugLine="If period_between.Months <> 0 Then str_show.Appe";
if (_period_between.Months!=0) { 
_str_show.Append(BA.NumberToString(_period_between.Months)+" ماه و ");};
RDebugUtils.currentLine=43384872;
 //BA.debugLineNum = 43384872;BA.debugLine="If period_between.Days <> 0 Then str_show.Append";
if (_period_between.Days!=0) { 
_str_show.Append(BA.NumberToString(_period_between.Days)+" روز و ");};
RDebugUtils.currentLine=43384873;
 //BA.debugLineNum = 43384873;BA.debugLine="str_show.Append(period_between.Hours & \" ساعت و";
_str_show.Append(BA.NumberToString(_period_between.Hours)+" ساعت و ");
RDebugUtils.currentLine=43384874;
 //BA.debugLineNum = 43384874;BA.debugLine="str_show.Append(period_between.Minutes & \" دقیقه";
_str_show.Append(BA.NumberToString(_period_between.Minutes)+" دقیقه ");
RDebugUtils.currentLine=43384877;
 //BA.debugLineNum = 43384877;BA.debugLine="lbl_time_show.Text = str_show.ToString";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(_str_show.ToString()));
RDebugUtils.currentLine=43384878;
 //BA.debugLineNum = 43384878;BA.debugLine="lbl_time_show_fs.Text = lbl_time_show.Text";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(mostCurrent._lbl_time_show.getText()));
RDebugUtils.currentLine=43384881;
 //BA.debugLineNum = 43384881;BA.debugLine="year_bt = period_between.Years";
_year_bt = _period_between.Years;
RDebugUtils.currentLine=43384882;
 //BA.debugLineNum = 43384882;BA.debugLine="moon_bt = period_between.Months";
_moon_bt = _period_between.Months;
RDebugUtils.currentLine=43384883;
 //BA.debugLineNum = 43384883;BA.debugLine="day_bt = period_between.Days";
_day_bt = _period_between.Days;
RDebugUtils.currentLine=43384884;
 //BA.debugLineNum = 43384884;BA.debugLine="hour_bt = period_between.Hours";
_hour_bt = _period_between.Hours;
RDebugUtils.currentLine=43384885;
 //BA.debugLineNum = 43384885;BA.debugLine="min_bt = period_between.Minutes";
_min_bt = _period_between.Minutes;
RDebugUtils.currentLine=43384888;
 //BA.debugLineNum = 43384888;BA.debugLine="If index_box = 3 Then";
if (_index_box==3) { 
RDebugUtils.currentLine=43384890;
 //BA.debugLineNum = 43384890;BA.debugLine="tim_min = (day_bt * 24 * 60) + (hour_bt * 60) +";
_tim_min = (int) ((_day_bt*24*60)+(_hour_bt*60)+_min_bt);
RDebugUtils.currentLine=43384893;
 //BA.debugLineNum = 43384893;BA.debugLine="Select state_tatil_setting";
switch (_state_tatil_setting) {
case 0: {
RDebugUtils.currentLine=43384895;
 //BA.debugLineNum = 43384895;BA.debugLine="tatil_nist";
_tatil_nist();
 break; }
case 1: {
RDebugUtils.currentLine=43384897;
 //BA.debugLineNum = 43384897;BA.debugLine="If state_tatil = 1 Or state_tatil = 2 Then ta";
if (_state_tatil==1 || _state_tatil==2) { 
_tatil_hast();}
else {
_tatil_nist();};
 break; }
case 11: {
RDebugUtils.currentLine=43384899;
 //BA.debugLineNum = 43384899;BA.debugLine="If state_tatil = 1 Then tatil_hast Else tatil";
if (_state_tatil==1) { 
_tatil_hast();}
else {
_tatil_nist();};
 break; }
case 22: {
RDebugUtils.currentLine=43384901;
 //BA.debugLineNum = 43384901;BA.debugLine="If state_tatil = 2 Then tatil_hast Else tatil";
if (_state_tatil==2) { 
_tatil_hast();}
else {
_tatil_nist();};
 break; }
}
;
RDebugUtils.currentLine=43384905;
 //BA.debugLineNum = 43384905;BA.debugLine="If is_for_edit Then";
if (_is_for_edit) { 
RDebugUtils.currentLine=43384906;
 //BA.debugLineNum = 43384906;BA.debugLine="lbl_ezaf_taradod.Text = \"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=43384907;
 //BA.debugLineNum = 43384907;BA.debugLine="ckb_ezaf_taradod.Enabled = False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43384908;
 //BA.debugLineNum = 43384908;BA.debugLine="ckb_ezaf_taradod.Visible = False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43384909;
 //BA.debugLineNum = 43384909;BA.debugLine="radio_ez_adi.Enabled = False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43384910;
 //BA.debugLineNum = 43384910;BA.debugLine="radio_ez_fog.Enabled = False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43384912;
 //BA.debugLineNum = 43384912;BA.debugLine="lbl_ezaf_taradod_fs.Text = \"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=43384913;
 //BA.debugLineNum = 43384913;BA.debugLine="ckb_ezaf_taradod_fs.Enabled = False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43384914;
 //BA.debugLineNum = 43384914;BA.debugLine="ckb_ezaf_taradod_fs.Visible = False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 } 
       catch (Exception e59) {
			processBA.setLastException(e59);RDebugUtils.currentLine=43384919;
 //BA.debugLineNum = 43384919;BA.debugLine="ToastMessageShow(\"خطا در پردازش زمان\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در پردازش زمان"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=43384921;
 //BA.debugLineNum = 43384921;BA.debugLine="End Sub";
return "";
}
public static String  _timer1_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "timer1_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "timer1_tick", null));}
anywheresoftware.b4a.objects.collections.List _ls_lock0 = null;
RDebugUtils.currentLine=40501248;
 //BA.debugLineNum = 40501248;BA.debugLine="Sub timer1_Tick";
RDebugUtils.currentLine=40501250;
 //BA.debugLineNum = 40501250;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=40501251;
 //BA.debugLineNum = 40501251;BA.debugLine="timer1.Enabled=False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=40501252;
 //BA.debugLineNum = 40501252;BA.debugLine="cv_loader.Hide";
mostCurrent._cv_loader._hide /*String*/ (null);
RDebugUtils.currentLine=40501253;
 //BA.debugLineNum = 40501253;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
RDebugUtils.currentLine=40501254;
 //BA.debugLineNum = 40501254;BA.debugLine="ScrollView_sett_taradod.Panel.LoadLayout(\"item_se";
mostCurrent._scrollview_sett_taradod.getPanel().LoadLayout("item_settingTaradod_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=40501261;
 //BA.debugLineNum = 40501261;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=True)T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=40501262;
 //BA.debugLineNum = 40501262;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=40501263;
 //BA.debugLineNum = 40501263;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
RDebugUtils.currentLine=40501264;
 //BA.debugLineNum = 40501264;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_lock";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
RDebugUtils.currentLine=40501266;
 //BA.debugLineNum = 40501266;BA.debugLine="If(ls_lock0.Get(0)=\"true\")Then";
if (((_ls_lock0.Get((int) (0))).equals((Object)("true")))) { 
RDebugUtils.currentLine=40501267;
 //BA.debugLineNum = 40501267;BA.debugLine="Master_Password=ls_lock0.Get(2)";
mostCurrent._master_password = BA.ObjectToString(_ls_lock0.Get((int) (2)));
RDebugUtils.currentLine=40501268;
 //BA.debugLineNum = 40501268;BA.debugLine="pan_lock.Visible=True";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=40501269;
 //BA.debugLineNum = 40501269;BA.debugLine="lbl_hint_lock.Text=ls_lock0.Get(3)";
mostCurrent._lbl_hint_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (3))));
RDebugUtils.currentLine=40501271;
 //BA.debugLineNum = 40501271;BA.debugLine="If(ls_lock0.Get(1)=\"true\")Then";
if (((_ls_lock0.Get((int) (1))).equals((Object)("true")))) { 
RDebugUtils.currentLine=40501273;
 //BA.debugLineNum = 40501273;BA.debugLine="tim_lock_lbl.Initialize(\"tim_lock_lbl\",500)";
_tim_lock_lbl.Initialize(processBA,"tim_lock_lbl",(long) (500));
RDebugUtils.currentLine=40501274;
 //BA.debugLineNum = 40501274;BA.debugLine="Try";
try {RDebugUtils.currentLine=40501275;
 //BA.debugLineNum = 40501275;BA.debugLine="fingerprint.Initialize (Me, \"auth\")";
mostCurrent._fingerprint._initialize /*String*/ (null,processBA,main.getObject(),"auth");
RDebugUtils.currentLine=40501278;
 //BA.debugLineNum = 40501278;BA.debugLine="If fingerprint.HardwareDetected = False Then";
if (mostCurrent._fingerprint._gethardwaredetected /*boolean*/ (null)==anywheresoftware.b4a.keywords.Common.False) { 
 }else 
{RDebugUtils.currentLine=40501281;
 //BA.debugLineNum = 40501281;BA.debugLine="Else if fingerprint.HasEnrolledFingerprints =";
if (mostCurrent._fingerprint._gethasenrolledfingerprints /*boolean*/ (null)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=40501282;
 //BA.debugLineNum = 40501282;BA.debugLine="ToastMessageShow(\"اثر انگشت تعریف نشده است\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اثر انگشت تعریف نشده است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=40501284;
 //BA.debugLineNum = 40501284;BA.debugLine="lbl_finger.Visible=True";
mostCurrent._lbl_finger.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=40501285;
 //BA.debugLineNum = 40501285;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
mostCurrent._lbl_finger.setTextColor(((int)0xff0b6200));
RDebugUtils.currentLine=40501286;
 //BA.debugLineNum = 40501286;BA.debugLine="finger_scaning";
_finger_scaning();
RDebugUtils.currentLine=40501287;
 //BA.debugLineNum = 40501287;BA.debugLine="tim_lock_lbl.Enabled=True";
_tim_lock_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }}
;
 } 
       catch (Exception e28) {
			processBA.setLastException(e28);RDebugUtils.currentLine=40501291;
 //BA.debugLineNum = 40501291;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("340501291",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
 };
 }else {
RDebugUtils.currentLine=40501298;
 //BA.debugLineNum = 40501298;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=40501305;
 //BA.debugLineNum = 40501305;BA.debugLine="End Sub";
return "";
}
}