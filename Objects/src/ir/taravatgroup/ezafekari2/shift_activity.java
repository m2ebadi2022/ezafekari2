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

public class shift_activity extends Activity implements B4AActivity{
	public static shift_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.shift_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (shift_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.shift_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.shift_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (shift_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (shift_activity) Resume **");
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
		return shift_activity.class;
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
            BA.LogInfo("** Activity (shift_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (shift_activity) Pause event (activity is not paused). **");
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
            shift_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (shift_activity) Resume **");
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
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_shift = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl0 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh0 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez0 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no0 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p0 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb3 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb4 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb5 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p6 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb6 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p7 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb7 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p8 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb8 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p9 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb9 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p10 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb10 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p11 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb11 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p12 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb12 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p13 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb13 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p14 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb14 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p22 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb22 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p23 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb23 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p24 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb24 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p25 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb25 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p26 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb26 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p27 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb27 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p28 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb28 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p21 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb21 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p20 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb20 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p19 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb19 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p18 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb18 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p17 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb17 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p16 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb16 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p15 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb15 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p29 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb29 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p30 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb30 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p31 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb31 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p32 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb32 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p33 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb33 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p34 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb34 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p35 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb35 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p36 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb36 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p37 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb37 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p38 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb38 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p39 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb39 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p40 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb40 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p41 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb41 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p42 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb42 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_moon_name = null;
public static int _current_moon = 0;
public anywheresoftware.b4a.objects.LabelWrapper[] _lb = null;
public anywheresoftware.b4a.objects.PanelWrapper[] _pa = null;
public anywheresoftware.b4a.objects.LabelWrapper[] _sh = null;
public anywheresoftware.b4a.objects.LabelWrapper[] _ez = null;
public anywheresoftware.b4a.objects.LabelWrapper[] _no = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_today_monasebat = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_today = null;
public static int _index_i_today = 0;
public static int _this_day = 0;
public static int _this_year = 0;
public static int _this_moon = 0;
public static int _last_selected_itemtag = 0;
public static int _selectedday_id = 0;
public anywheresoftware.b4a.objects.LabelWrapper _sh42 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh41 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh40 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh39 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh38 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh37 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh36 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh29 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh30 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh31 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh32 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh33 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh34 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh35 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh28 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh21 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh14 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh7 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh6 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh13 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh20 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh27 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh26 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh19 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh12 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh11 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh18 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh25 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh24 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh17 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh10 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh9 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh16 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh23 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh22 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh15 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh8 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sh1 = null;
public com.b4a.manamsoftware.PersianDate.ManamPersianDate _date = null;
public static int _start_day = 0;
public anywheresoftware.b4a.objects.collections.List _ls_shift_moon = null;
public anywheresoftware.b4a.objects.collections.List _ls_tatili_moon = null;
public anywheresoftware.b4a.objects.collections.List _ls_tatili_custom_moon = null;
public anywheresoftware.b4a.objects.collections.List _ls_note_moon = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_setsift = null;
public anywheresoftware.b4a.objects.ListViewWrapper _ls_set_shift = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_num_roz = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _sp_noe_shift = null;
public anywheresoftware.b4a.objects.collections.List _list_sift_olgo = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_hed_set_shift = null;
public anywheresoftware.b4a.objects.LabelWrapper _no1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no6 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no7 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no8 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no9 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no10 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no11 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no12 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no13 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no14 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no22 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no23 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no24 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no25 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no26 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no27 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no28 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no21 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no20 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no19 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no18 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no17 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no16 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no15 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no29 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no30 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no31 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no32 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no33 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no34 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no35 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no36 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no37 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no38 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no39 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no40 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no41 = null;
public anywheresoftware.b4a.objects.LabelWrapper _no42 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez42 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez41 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez40 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez39 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez38 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez37 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez36 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez35 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez34 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez33 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez32 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez31 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez30 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez29 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez15 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez16 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez17 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez18 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez19 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez20 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez21 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez28 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez27 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez26 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez25 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez24 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez23 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez22 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez14 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez13 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez12 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez11 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez10 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez9 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez8 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez7 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez6 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ez1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_morakhasi_day = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_ezafekari_day = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_note_day = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_note = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_note = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date_in_note = null;
public com.rootsoft.rspopupmenu.RSPopupMenu _rspop_year = null;
public com.rootsoft.rspopupmenu.RSPopupMenu _rspop_mah = null;
public com.rootsoft.rspopupmenu.RSPopupMenu _rspop_roz = null;
public com.rootsoft.rspopupmenu.RSPopupMenu _rspop_year_end = null;
public com.rootsoft.rspopupmenu.RSPopupMenu _rspop_mah_end = null;
public com.rootsoft.rspopupmenu.RSPopupMenu _rspop_roz_end = null;
public com.rootsoft.rspopupmenu.RSPopupMenu _rspop_year_tagvim = null;
public com.rootsoft.rspopupmenu.RSPopupMenu _rspop_moon_tagvim = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_years = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_mah = null;
public static int _lbl_mah_tagid = 0;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_roz = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_roz_end = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_mah_end = null;
public static int _lbl_mah_end_tagid = 0;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_years_end = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_taradod_day = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_year_tagvim = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrol_v = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_menu_day = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _checkbox_tatil_garardadi = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_checkbox_tatil_garardadi = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_title_day_menu = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _checkbox_tatil_rasmi = null;
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
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
int _i = 0;
RDebugUtils.currentLine=55312384;
 //BA.debugLineNum = 55312384;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=55312387;
 //BA.debugLineNum = 55312387;BA.debugLine="Activity.LoadLayout(\"shift_layout\")";
mostCurrent._activity.LoadLayout("shift_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=55312389;
 //BA.debugLineNum = 55312389;BA.debugLine="scrol_v.Panel.LoadLayout(\"shift_page_items\")";
mostCurrent._scrol_v.getPanel().LoadLayout("shift_page_items",mostCurrent.activityBA);
RDebugUtils.currentLine=55312391;
 //BA.debugLineNum = 55312391;BA.debugLine="pan_hed_shift.Color=Main.color4";
mostCurrent._pan_hed_shift.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=55312392;
 //BA.debugLineNum = 55312392;BA.debugLine="lbl_hed_set_shift.Color=Main.color4";
mostCurrent._lbl_hed_set_shift.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=55312395;
 //BA.debugLineNum = 55312395;BA.debugLine="lbl0.Initialize(\"lbl0\")";
mostCurrent._lbl0.Initialize(mostCurrent.activityBA,"lbl0");
RDebugUtils.currentLine=55312396;
 //BA.debugLineNum = 55312396;BA.debugLine="lbl0.Tag=0";
mostCurrent._lbl0.setTag((Object)(0));
RDebugUtils.currentLine=55312397;
 //BA.debugLineNum = 55312397;BA.debugLine="p0.Initialize(\"p0\")";
mostCurrent._p0.Initialize(mostCurrent.activityBA,"p0");
RDebugUtils.currentLine=55312398;
 //BA.debugLineNum = 55312398;BA.debugLine="p0.Tag=0";
mostCurrent._p0.setTag((Object)(0));
RDebugUtils.currentLine=55312399;
 //BA.debugLineNum = 55312399;BA.debugLine="sh0.Initialize(\"sh0\")";
mostCurrent._sh0.Initialize(mostCurrent.activityBA,"sh0");
RDebugUtils.currentLine=55312400;
 //BA.debugLineNum = 55312400;BA.debugLine="sh0.Tag=0";
mostCurrent._sh0.setTag((Object)(0));
RDebugUtils.currentLine=55312401;
 //BA.debugLineNum = 55312401;BA.debugLine="ez0.Initialize(\"ez0\")";
mostCurrent._ez0.Initialize(mostCurrent.activityBA,"ez0");
RDebugUtils.currentLine=55312402;
 //BA.debugLineNum = 55312402;BA.debugLine="ez0.Tag=0";
mostCurrent._ez0.setTag((Object)(0));
RDebugUtils.currentLine=55312403;
 //BA.debugLineNum = 55312403;BA.debugLine="no0.Initialize(\"no0\")";
mostCurrent._no0.Initialize(mostCurrent.activityBA,"no0");
RDebugUtils.currentLine=55312404;
 //BA.debugLineNum = 55312404;BA.debugLine="no0.Tag=0";
mostCurrent._no0.setTag((Object)(0));
RDebugUtils.currentLine=55312406;
 //BA.debugLineNum = 55312406;BA.debugLine="ls_shift_moon.Initialize";
mostCurrent._ls_shift_moon.Initialize();
RDebugUtils.currentLine=55312407;
 //BA.debugLineNum = 55312407;BA.debugLine="ls_tatili_moon.Initialize";
mostCurrent._ls_tatili_moon.Initialize();
RDebugUtils.currentLine=55312408;
 //BA.debugLineNum = 55312408;BA.debugLine="ls_tatili_custom_moon.Initialize";
mostCurrent._ls_tatili_custom_moon.Initialize();
RDebugUtils.currentLine=55312409;
 //BA.debugLineNum = 55312409;BA.debugLine="ls_note_moon.Initialize";
mostCurrent._ls_note_moon.Initialize();
RDebugUtils.currentLine=55312412;
 //BA.debugLineNum = 55312412;BA.debugLine="list_sift_olgo.Initialize";
mostCurrent._list_sift_olgo.Initialize();
RDebugUtils.currentLine=55312413;
 //BA.debugLineNum = 55312413;BA.debugLine="ls_set_shift.SingleLineLayout.Label.TextColor=Col";
mostCurrent._ls_set_shift.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=55312415;
 //BA.debugLineNum = 55312415;BA.debugLine="ls_set_shift.SingleLineLayout.Label.Width=ls_set_";
mostCurrent._ls_set_shift.getSingleLineLayout().Label.setWidth((int) (mostCurrent._ls_set_shift.getWidth()-30));
RDebugUtils.currentLine=55312416;
 //BA.debugLineNum = 55312416;BA.debugLine="ls_set_shift.SingleLineLayout.Label.Typeface=Type";
mostCurrent._ls_set_shift.getSingleLineLayout().Label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(mostCurrent._myfunc._font_filename /*String*/ (mostCurrent.activityBA)));
RDebugUtils.currentLine=55312419;
 //BA.debugLineNum = 55312419;BA.debugLine="Lb = Array As Label(lbl0,lb1,lb2,lb3,lb4,lb5,lb6,";
mostCurrent._lb = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._lbl0,mostCurrent._lb1,mostCurrent._lb2,mostCurrent._lb3,mostCurrent._lb4,mostCurrent._lb5,mostCurrent._lb6,mostCurrent._lb7,mostCurrent._lb8,mostCurrent._lb9,mostCurrent._lb10,mostCurrent._lb11,mostCurrent._lb12,mostCurrent._lb13,mostCurrent._lb14,mostCurrent._lb15,mostCurrent._lb16,mostCurrent._lb17,mostCurrent._lb18,mostCurrent._lb19,mostCurrent._lb20,mostCurrent._lb21,mostCurrent._lb22,mostCurrent._lb23,mostCurrent._lb24,mostCurrent._lb25,mostCurrent._lb26,mostCurrent._lb27,mostCurrent._lb28,mostCurrent._lb29,mostCurrent._lb30,mostCurrent._lb31,mostCurrent._lb32,mostCurrent._lb33,mostCurrent._lb34,mostCurrent._lb35,mostCurrent._lb36,mostCurrent._lb37,mostCurrent._lb38,mostCurrent._lb39,mostCurrent._lb40,mostCurrent._lb41,mostCurrent._lb42};
RDebugUtils.currentLine=55312421;
 //BA.debugLineNum = 55312421;BA.debugLine="PA = Array As Panel(p0,p1,p2,p3,p4,p5,p6,p7,p8,p9";
mostCurrent._pa = new anywheresoftware.b4a.objects.PanelWrapper[]{mostCurrent._p0,mostCurrent._p1,mostCurrent._p2,mostCurrent._p3,mostCurrent._p4,mostCurrent._p5,mostCurrent._p6,mostCurrent._p7,mostCurrent._p8,mostCurrent._p9,mostCurrent._p10,mostCurrent._p11,mostCurrent._p12,mostCurrent._p13,mostCurrent._p14,mostCurrent._p15,mostCurrent._p16,mostCurrent._p17,mostCurrent._p18,mostCurrent._p19,mostCurrent._p20,mostCurrent._p21,mostCurrent._p22,mostCurrent._p23,mostCurrent._p24,mostCurrent._p25,mostCurrent._p26,mostCurrent._p27,mostCurrent._p28,mostCurrent._p29,mostCurrent._p30,mostCurrent._p31,mostCurrent._p32,mostCurrent._p33,mostCurrent._p34,mostCurrent._p35,mostCurrent._p36,mostCurrent._p37,mostCurrent._p38,mostCurrent._p39,mostCurrent._p40,mostCurrent._p41,mostCurrent._p42};
RDebugUtils.currentLine=55312423;
 //BA.debugLineNum = 55312423;BA.debugLine="SH = Array As Label(sh0,sh1,sh2,sh3,sh4,sh5,sh6,s";
mostCurrent._sh = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._sh0,mostCurrent._sh1,mostCurrent._sh2,mostCurrent._sh3,mostCurrent._sh4,mostCurrent._sh5,mostCurrent._sh6,mostCurrent._sh7,mostCurrent._sh8,mostCurrent._sh9,mostCurrent._sh10,mostCurrent._sh11,mostCurrent._sh12,mostCurrent._sh13,mostCurrent._sh14,mostCurrent._sh15,mostCurrent._sh16,mostCurrent._sh17,mostCurrent._sh18,mostCurrent._sh19,mostCurrent._sh20,mostCurrent._sh21,mostCurrent._sh22,mostCurrent._sh23,mostCurrent._sh24,mostCurrent._sh25,mostCurrent._sh26,mostCurrent._sh27,mostCurrent._sh28,mostCurrent._sh29,mostCurrent._sh30,mostCurrent._sh31,mostCurrent._sh32,mostCurrent._sh33,mostCurrent._sh34,mostCurrent._sh35,mostCurrent._sh36,mostCurrent._sh37,mostCurrent._sh38,mostCurrent._sh39,mostCurrent._sh40,mostCurrent._sh41,mostCurrent._sh42};
RDebugUtils.currentLine=55312425;
 //BA.debugLineNum = 55312425;BA.debugLine="EZ = Array As Label (ez0,ez1,ez2,ez3,ez4,ez5,ez6,";
mostCurrent._ez = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._ez0,mostCurrent._ez1,mostCurrent._ez2,mostCurrent._ez3,mostCurrent._ez4,mostCurrent._ez5,mostCurrent._ez6,mostCurrent._ez7,mostCurrent._ez8,mostCurrent._ez9,mostCurrent._ez10,mostCurrent._ez11,mostCurrent._ez12,mostCurrent._ez13,mostCurrent._ez14,mostCurrent._ez15,mostCurrent._ez16,mostCurrent._ez17,mostCurrent._ez18,mostCurrent._ez19,mostCurrent._ez20,mostCurrent._ez21,mostCurrent._ez22,mostCurrent._ez23,mostCurrent._ez24,mostCurrent._ez25,mostCurrent._ez26,mostCurrent._ez27,mostCurrent._ez28,mostCurrent._ez29,mostCurrent._ez30,mostCurrent._ez31,mostCurrent._ez32,mostCurrent._ez33,mostCurrent._ez34,mostCurrent._ez35,mostCurrent._ez36,mostCurrent._ez37,mostCurrent._ez38,mostCurrent._ez39,mostCurrent._ez40,mostCurrent._ez41,mostCurrent._ez42};
RDebugUtils.currentLine=55312428;
 //BA.debugLineNum = 55312428;BA.debugLine="NO = Array As Label (no0,no1,no2,no3,no4,no5,no6,";
mostCurrent._no = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._no0,mostCurrent._no1,mostCurrent._no2,mostCurrent._no3,mostCurrent._no4,mostCurrent._no5,mostCurrent._no6,mostCurrent._no7,mostCurrent._no8,mostCurrent._no9,mostCurrent._no10,mostCurrent._no11,mostCurrent._no12,mostCurrent._no13,mostCurrent._no14,mostCurrent._no15,mostCurrent._no16,mostCurrent._no17,mostCurrent._no18,mostCurrent._no19,mostCurrent._no20,mostCurrent._no21,mostCurrent._no22,mostCurrent._no23,mostCurrent._no24,mostCurrent._no25,mostCurrent._no26,mostCurrent._no27,mostCurrent._no28,mostCurrent._no29,mostCurrent._no30,mostCurrent._no31,mostCurrent._no32,mostCurrent._no33,mostCurrent._no34,mostCurrent._no35,mostCurrent._no36,mostCurrent._no37,mostCurrent._no38,mostCurrent._no39,mostCurrent._no40,mostCurrent._no41,mostCurrent._no42};
RDebugUtils.currentLine=55312435;
 //BA.debugLineNum = 55312435;BA.debugLine="sp_noe_shift.AddAll(Array As String(\"روزکار(ر)\",\"";
mostCurrent._sp_noe_shift.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"روزکار(ر)","عصرکار(ع)","شبکار(ش)","استراحت(ا)","صبح-عصر(ص/ع)","عصر-شب(ع/ش)","صبح-شب(ص/ش)"}));
RDebugUtils.currentLine=55312439;
 //BA.debugLineNum = 55312439;BA.debugLine="this_year=date.PersianYear";
_this_year = mostCurrent._date.getPersianYear();
RDebugUtils.currentLine=55312440;
 //BA.debugLineNum = 55312440;BA.debugLine="this_moon =date.PersianMonth";
_this_moon = mostCurrent._date.getPersianMonth();
RDebugUtils.currentLine=55312441;
 //BA.debugLineNum = 55312441;BA.debugLine="this_day =date.PersianDay";
_this_day = mostCurrent._date.getPersianDay();
RDebugUtils.currentLine=55312444;
 //BA.debugLineNum = 55312444;BA.debugLine="current_moon=date.PersianMonth";
_current_moon = mostCurrent._date.getPersianMonth();
RDebugUtils.currentLine=55312446;
 //BA.debugLineNum = 55312446;BA.debugLine="lbl_year_tagvim.Text=this_year";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_this_year));
RDebugUtils.currentLine=55312457;
 //BA.debugLineNum = 55312457;BA.debugLine="rsPOP_year_tagvim.Initialize(\"rsPOP_year_tagvim\",";
mostCurrent._rspop_year_tagvim.Initialize(mostCurrent.activityBA,"rsPOP_year_tagvim",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_year_tagvim.getObject())));
RDebugUtils.currentLine=55312459;
 //BA.debugLineNum = 55312459;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1398,1398,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1398),(int) (1398),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1398"));
RDebugUtils.currentLine=55312460;
 //BA.debugLineNum = 55312460;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1399,1399,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1399),(int) (1399),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1399"));
RDebugUtils.currentLine=55312461;
 //BA.debugLineNum = 55312461;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1400,1400,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1400),(int) (1400),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1400"));
RDebugUtils.currentLine=55312462;
 //BA.debugLineNum = 55312462;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1401,1401,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1401),(int) (1401),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1401"));
RDebugUtils.currentLine=55312463;
 //BA.debugLineNum = 55312463;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1402,1402,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1402),(int) (1402),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1402"));
RDebugUtils.currentLine=55312464;
 //BA.debugLineNum = 55312464;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1403,1403,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1403),(int) (1403),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1403"));
RDebugUtils.currentLine=55312465;
 //BA.debugLineNum = 55312465;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1404,1404,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1404),(int) (1404),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1404"));
RDebugUtils.currentLine=55312467;
 //BA.debugLineNum = 55312467;BA.debugLine="rsPOP_moon_tagvim.Initialize(\"rsPOP_moon_tagvim\",";
mostCurrent._rspop_moon_tagvim.Initialize(mostCurrent.activityBA,"rsPOP_moon_tagvim",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_moon_name.getObject())));
RDebugUtils.currentLine=55312470;
 //BA.debugLineNum = 55312470;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(1,1,\"فروردین\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (1),(int) (1),"فروردین");
RDebugUtils.currentLine=55312471;
 //BA.debugLineNum = 55312471;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(2,2,\"اردیبهشت\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (2),(int) (2),"اردیبهشت");
RDebugUtils.currentLine=55312472;
 //BA.debugLineNum = 55312472;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(3,3,\"خرداد\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (3),(int) (3),"خرداد");
RDebugUtils.currentLine=55312473;
 //BA.debugLineNum = 55312473;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(4,4,\"تیر\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (4),(int) (4),"تیر");
RDebugUtils.currentLine=55312474;
 //BA.debugLineNum = 55312474;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(5,5,\"مرداد\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (5),(int) (5),"مرداد");
RDebugUtils.currentLine=55312475;
 //BA.debugLineNum = 55312475;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(6,6,\"شهریور\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (6),(int) (6),"شهریور");
RDebugUtils.currentLine=55312476;
 //BA.debugLineNum = 55312476;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(7,7,\"مهر\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (7),(int) (7),"مهر");
RDebugUtils.currentLine=55312477;
 //BA.debugLineNum = 55312477;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(8,8,\"آبان\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (8),(int) (8),"آبان");
RDebugUtils.currentLine=55312478;
 //BA.debugLineNum = 55312478;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(9,9,\"آذر\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (9),(int) (9),"آذر");
RDebugUtils.currentLine=55312479;
 //BA.debugLineNum = 55312479;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(10,10,\"دی\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (10),(int) (10),"دی");
RDebugUtils.currentLine=55312480;
 //BA.debugLineNum = 55312480;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(11,11,\"بهمن\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (11),(int) (11),"بهمن");
RDebugUtils.currentLine=55312481;
 //BA.debugLineNum = 55312481;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(12,12,\"اسفند\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (12),(int) (12),"اسفند");
RDebugUtils.currentLine=55312489;
 //BA.debugLineNum = 55312489;BA.debugLine="rsPOP_year.Initialize(\"rsPOP_year\",lbl_years)";
mostCurrent._rspop_year.Initialize(mostCurrent.activityBA,"rsPOP_year",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_years.getObject())));
RDebugUtils.currentLine=55312491;
 //BA.debugLineNum = 55312491;BA.debugLine="rsPOP_year.AddMenuItem(1398,1398,myfunc.en2fa(\"13";
mostCurrent._rspop_year.AddMenuItem((int) (1398),(int) (1398),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1398"));
RDebugUtils.currentLine=55312492;
 //BA.debugLineNum = 55312492;BA.debugLine="rsPOP_year.AddMenuItem(1399,1399,myfunc.en2fa(\"13";
mostCurrent._rspop_year.AddMenuItem((int) (1399),(int) (1399),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1399"));
RDebugUtils.currentLine=55312493;
 //BA.debugLineNum = 55312493;BA.debugLine="rsPOP_year.AddMenuItem(1400,1400,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1400),(int) (1400),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1400"));
RDebugUtils.currentLine=55312494;
 //BA.debugLineNum = 55312494;BA.debugLine="rsPOP_year.AddMenuItem(1401,1401,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1401),(int) (1401),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1401"));
RDebugUtils.currentLine=55312495;
 //BA.debugLineNum = 55312495;BA.debugLine="rsPOP_year.AddMenuItem(1402,1402,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1402),(int) (1402),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1402"));
RDebugUtils.currentLine=55312496;
 //BA.debugLineNum = 55312496;BA.debugLine="rsPOP_year.AddMenuItem(1403,1403,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1403),(int) (1403),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1403"));
RDebugUtils.currentLine=55312497;
 //BA.debugLineNum = 55312497;BA.debugLine="rsPOP_year.AddMenuItem(1404,1404,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1404),(int) (1404),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1404"));
RDebugUtils.currentLine=55312499;
 //BA.debugLineNum = 55312499;BA.debugLine="rsPOP_mah.Initialize(\"rsPOP_mah\",lbl_mah)";
mostCurrent._rspop_mah.Initialize(mostCurrent.activityBA,"rsPOP_mah",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_mah.getObject())));
RDebugUtils.currentLine=55312501;
 //BA.debugLineNum = 55312501;BA.debugLine="lbl_mah_tagID=1";
_lbl_mah_tagid = (int) (1);
RDebugUtils.currentLine=55312503;
 //BA.debugLineNum = 55312503;BA.debugLine="rsPOP_mah.AddMenuItem(1,1,\"فروردین\")";
mostCurrent._rspop_mah.AddMenuItem((int) (1),(int) (1),"فروردین");
RDebugUtils.currentLine=55312504;
 //BA.debugLineNum = 55312504;BA.debugLine="rsPOP_mah.AddMenuItem(2,2,\"اردیبهشت\")";
mostCurrent._rspop_mah.AddMenuItem((int) (2),(int) (2),"اردیبهشت");
RDebugUtils.currentLine=55312505;
 //BA.debugLineNum = 55312505;BA.debugLine="rsPOP_mah.AddMenuItem(3,3,\"خرداد\")";
mostCurrent._rspop_mah.AddMenuItem((int) (3),(int) (3),"خرداد");
RDebugUtils.currentLine=55312506;
 //BA.debugLineNum = 55312506;BA.debugLine="rsPOP_mah.AddMenuItem(4,4,\"تیر\")";
mostCurrent._rspop_mah.AddMenuItem((int) (4),(int) (4),"تیر");
RDebugUtils.currentLine=55312507;
 //BA.debugLineNum = 55312507;BA.debugLine="rsPOP_mah.AddMenuItem(5,5,\"مرداد\")";
mostCurrent._rspop_mah.AddMenuItem((int) (5),(int) (5),"مرداد");
RDebugUtils.currentLine=55312508;
 //BA.debugLineNum = 55312508;BA.debugLine="rsPOP_mah.AddMenuItem(6,6,\"شهریور\")";
mostCurrent._rspop_mah.AddMenuItem((int) (6),(int) (6),"شهریور");
RDebugUtils.currentLine=55312509;
 //BA.debugLineNum = 55312509;BA.debugLine="rsPOP_mah.AddMenuItem(7,7,\"مهر\")";
mostCurrent._rspop_mah.AddMenuItem((int) (7),(int) (7),"مهر");
RDebugUtils.currentLine=55312510;
 //BA.debugLineNum = 55312510;BA.debugLine="rsPOP_mah.AddMenuItem(8,8,\"آبان\")";
mostCurrent._rspop_mah.AddMenuItem((int) (8),(int) (8),"آبان");
RDebugUtils.currentLine=55312511;
 //BA.debugLineNum = 55312511;BA.debugLine="rsPOP_mah.AddMenuItem(9,9,\"آذر\")";
mostCurrent._rspop_mah.AddMenuItem((int) (9),(int) (9),"آذر");
RDebugUtils.currentLine=55312512;
 //BA.debugLineNum = 55312512;BA.debugLine="rsPOP_mah.AddMenuItem(10,10,\"دی\")";
mostCurrent._rspop_mah.AddMenuItem((int) (10),(int) (10),"دی");
RDebugUtils.currentLine=55312513;
 //BA.debugLineNum = 55312513;BA.debugLine="rsPOP_mah.AddMenuItem(11,11,\"بهمن\")";
mostCurrent._rspop_mah.AddMenuItem((int) (11),(int) (11),"بهمن");
RDebugUtils.currentLine=55312514;
 //BA.debugLineNum = 55312514;BA.debugLine="rsPOP_mah.AddMenuItem(12,12,\"اسفند\")";
mostCurrent._rspop_mah.AddMenuItem((int) (12),(int) (12),"اسفند");
RDebugUtils.currentLine=55312517;
 //BA.debugLineNum = 55312517;BA.debugLine="rsPOP_roz.Initialize(\"rsPOP_roz\",lbl_roz)";
mostCurrent._rspop_roz.Initialize(mostCurrent.activityBA,"rsPOP_roz",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_roz.getObject())));
RDebugUtils.currentLine=55312520;
 //BA.debugLineNum = 55312520;BA.debugLine="For i=1 To 31";
{
final int step78 = 1;
final int limit78 = (int) (31);
_i = (int) (1) ;
for (;_i <= limit78 ;_i = _i + step78 ) {
RDebugUtils.currentLine=55312522;
 //BA.debugLineNum = 55312522;BA.debugLine="rsPOP_roz.AddMenuItem(i,i,myfunc.en2fa(i))";
mostCurrent._rspop_roz.AddMenuItem(_i,_i,mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_i)));
 }
};
RDebugUtils.currentLine=55312526;
 //BA.debugLineNum = 55312526;BA.debugLine="rsPOP_year_end.Initialize(\"rsPOP_year_end\",lbl_ye";
mostCurrent._rspop_year_end.Initialize(mostCurrent.activityBA,"rsPOP_year_end",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_years_end.getObject())));
RDebugUtils.currentLine=55312528;
 //BA.debugLineNum = 55312528;BA.debugLine="rsPOP_year_end.AddMenuItem(1398,1398,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1398),(int) (1398),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1398"));
RDebugUtils.currentLine=55312529;
 //BA.debugLineNum = 55312529;BA.debugLine="rsPOP_year_end.AddMenuItem(1399,1399,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1399),(int) (1399),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1399"));
RDebugUtils.currentLine=55312530;
 //BA.debugLineNum = 55312530;BA.debugLine="rsPOP_year_end.AddMenuItem(1400,1400,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1400),(int) (1400),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1400"));
RDebugUtils.currentLine=55312531;
 //BA.debugLineNum = 55312531;BA.debugLine="rsPOP_year_end.AddMenuItem(1401,1401,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1401),(int) (1401),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1401"));
RDebugUtils.currentLine=55312532;
 //BA.debugLineNum = 55312532;BA.debugLine="rsPOP_year_end.AddMenuItem(1402,1402,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1402),(int) (1402),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1402"));
RDebugUtils.currentLine=55312533;
 //BA.debugLineNum = 55312533;BA.debugLine="rsPOP_year_end.AddMenuItem(1403,1403,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1403),(int) (1403),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1403"));
RDebugUtils.currentLine=55312534;
 //BA.debugLineNum = 55312534;BA.debugLine="rsPOP_year_end.AddMenuItem(1404,1404,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1404),(int) (1404),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1404"));
RDebugUtils.currentLine=55312537;
 //BA.debugLineNum = 55312537;BA.debugLine="rsPOP_mah_end.Initialize(\"rsPOP_mah_end\",lbl_mah_";
mostCurrent._rspop_mah_end.Initialize(mostCurrent.activityBA,"rsPOP_mah_end",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_mah_end.getObject())));
RDebugUtils.currentLine=55312539;
 //BA.debugLineNum = 55312539;BA.debugLine="lbl_mah_end_tagID=12";
_lbl_mah_end_tagid = (int) (12);
RDebugUtils.currentLine=55312541;
 //BA.debugLineNum = 55312541;BA.debugLine="rsPOP_mah_end.AddMenuItem(1,1,\"فروردین\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (1),(int) (1),"فروردین");
RDebugUtils.currentLine=55312542;
 //BA.debugLineNum = 55312542;BA.debugLine="rsPOP_mah_end.AddMenuItem(2,2,\"اردیبهشت\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (2),(int) (2),"اردیبهشت");
RDebugUtils.currentLine=55312543;
 //BA.debugLineNum = 55312543;BA.debugLine="rsPOP_mah_end.AddMenuItem(3,3,\"خرداد\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (3),(int) (3),"خرداد");
RDebugUtils.currentLine=55312544;
 //BA.debugLineNum = 55312544;BA.debugLine="rsPOP_mah_end.AddMenuItem(4,4,\"تیر\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (4),(int) (4),"تیر");
RDebugUtils.currentLine=55312545;
 //BA.debugLineNum = 55312545;BA.debugLine="rsPOP_mah_end.AddMenuItem(5,5,\"مرداد\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (5),(int) (5),"مرداد");
RDebugUtils.currentLine=55312546;
 //BA.debugLineNum = 55312546;BA.debugLine="rsPOP_mah_end.AddMenuItem(6,6,\"شهریور\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (6),(int) (6),"شهریور");
RDebugUtils.currentLine=55312547;
 //BA.debugLineNum = 55312547;BA.debugLine="rsPOP_mah_end.AddMenuItem(7,7,\"مهر\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (7),(int) (7),"مهر");
RDebugUtils.currentLine=55312548;
 //BA.debugLineNum = 55312548;BA.debugLine="rsPOP_mah_end.AddMenuItem(8,8,\"آبان\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (8),(int) (8),"آبان");
RDebugUtils.currentLine=55312549;
 //BA.debugLineNum = 55312549;BA.debugLine="rsPOP_mah_end.AddMenuItem(9,9,\"آذر\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (9),(int) (9),"آذر");
RDebugUtils.currentLine=55312550;
 //BA.debugLineNum = 55312550;BA.debugLine="rsPOP_mah_end.AddMenuItem(10,10,\"دی\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (10),(int) (10),"دی");
RDebugUtils.currentLine=55312551;
 //BA.debugLineNum = 55312551;BA.debugLine="rsPOP_mah_end.AddMenuItem(11,11,\"بهمن\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (11),(int) (11),"بهمن");
RDebugUtils.currentLine=55312552;
 //BA.debugLineNum = 55312552;BA.debugLine="rsPOP_mah_end.AddMenuItem(12,12,\"اسفند\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (12),(int) (12),"اسفند");
RDebugUtils.currentLine=55312554;
 //BA.debugLineNum = 55312554;BA.debugLine="rsPOP_roz_end.Initialize(\"rsPOP_roz_end\",lbl_roz_";
mostCurrent._rspop_roz_end.Initialize(mostCurrent.activityBA,"rsPOP_roz_end",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_roz_end.getObject())));
RDebugUtils.currentLine=55312555;
 //BA.debugLineNum = 55312555;BA.debugLine="For i=1 To 31";
{
final int step104 = 1;
final int limit104 = (int) (31);
_i = (int) (1) ;
for (;_i <= limit104 ;_i = _i + step104 ) {
RDebugUtils.currentLine=55312556;
 //BA.debugLineNum = 55312556;BA.debugLine="rsPOP_roz_end.AddMenuItem(i,i,myfunc.en2fa(i))";
mostCurrent._rspop_roz_end.AddMenuItem(_i,_i,mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_i)));
 }
};
RDebugUtils.currentLine=55312562;
 //BA.debugLineNum = 55312562;BA.debugLine="lbl_go_today_Click";
_lbl_go_today_click();
RDebugUtils.currentLine=55312564;
 //BA.debugLineNum = 55312564;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=55312565;
 //BA.debugLineNum = 55312565;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=55312567;
 //BA.debugLineNum = 55312567;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_go_today_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_go_today_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_go_today_click", null));}
RDebugUtils.currentLine=55377920;
 //BA.debugLineNum = 55377920;BA.debugLine="Private Sub lbl_go_today_Click";
RDebugUtils.currentLine=55377922;
 //BA.debugLineNum = 55377922;BA.debugLine="selectedDay_id=dbCode.get_day_id(this_year,this_m";
_selectedday_id = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_this_year,_this_moon,_this_day);
RDebugUtils.currentLine=55377926;
 //BA.debugLineNum = 55377926;BA.debugLine="generat_taghvim(this_year,this_moon)";
_generat_taghvim(_this_year,_this_moon);
RDebugUtils.currentLine=55377928;
 //BA.debugLineNum = 55377928;BA.debugLine="get_monasebat( selectedDay_id )";
_get_monasebat(_selectedday_id);
RDebugUtils.currentLine=55377929;
 //BA.debugLineNum = 55377929;BA.debugLine="get_note(selectedDay_id)";
_get_note(_selectedday_id);
RDebugUtils.currentLine=55377931;
 //BA.debugLineNum = 55377931;BA.debugLine="get_ezafekari(this_year&\"/\"&myfunc.convert_adad(t";
_get_ezafekari(BA.NumberToString(_this_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_day));
RDebugUtils.currentLine=55377932;
 //BA.debugLineNum = 55377932;BA.debugLine="get_morakhasi(this_year&\"/\"&myfunc.convert_adad(t";
_get_morakhasi(BA.NumberToString(_this_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_day));
RDebugUtils.currentLine=55377933;
 //BA.debugLineNum = 55377933;BA.debugLine="get_taradod(this_year&\"/\"&myfunc.convert_adad(thi";
_get_taradod(BA.NumberToString(_this_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_day));
RDebugUtils.currentLine=55377939;
 //BA.debugLineNum = 55377939;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=56688640;
 //BA.debugLineNum = 56688640;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=56688641;
 //BA.debugLineNum = 56688641;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=56688642;
 //BA.debugLineNum = 56688642;BA.debugLine="If(pan_all_setSift.Visible=True)Then";
if ((mostCurrent._pan_all_setsift.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=56688643;
 //BA.debugLineNum = 56688643;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=56688644;
 //BA.debugLineNum = 56688644;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
 }else 
{RDebugUtils.currentLine=56688646;
 //BA.debugLineNum = 56688646;BA.debugLine="Else If (pan_all_note.Visible=True)Then";
if ((mostCurrent._pan_all_note.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=56688647;
 //BA.debugLineNum = 56688647;BA.debugLine="pan_all_note.Visible=False";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=56688649;
 //BA.debugLineNum = 56688649;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 }}
;
RDebugUtils.currentLine=56688652;
 //BA.debugLineNum = 56688652;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=56688654;
 //BA.debugLineNum = 56688654;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=56688656;
 //BA.debugLineNum = 56688656;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_delete_lis_olgo_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_delete_lis_olgo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_delete_lis_olgo_click", null));}
RDebugUtils.currentLine=57802752;
 //BA.debugLineNum = 57802752;BA.debugLine="Private Sub lbl_delete_lis_olgo_Click";
RDebugUtils.currentLine=57802753;
 //BA.debugLineNum = 57802753;BA.debugLine="ls_set_shift.Clear";
mostCurrent._ls_set_shift.Clear();
RDebugUtils.currentLine=57802754;
 //BA.debugLineNum = 57802754;BA.debugLine="list_sift_olgo.Clear";
mostCurrent._list_sift_olgo.Clear();
RDebugUtils.currentLine=57802755;
 //BA.debugLineNum = 57802755;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=56623104;
 //BA.debugLineNum = 56623104;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=56623106;
 //BA.debugLineNum = 56623106;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=56623107;
 //BA.debugLineNum = 56623107;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="shift_activity";
RDebugUtils.currentLine=56557568;
 //BA.debugLineNum = 56557568;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=56557570;
 //BA.debugLineNum = 56557570;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=56492032;
 //BA.debugLineNum = 56492032;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=56492034;
 //BA.debugLineNum = 56492034;BA.debugLine="End Sub";
return "";
}
public static String  _checkbox_tatil_garardadi_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "checkbox_tatil_garardadi_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "checkbox_tatil_garardadi_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=58720256;
 //BA.debugLineNum = 58720256;BA.debugLine="Private Sub CheckBox_tatil_garardadi_CheckedChange";
RDebugUtils.currentLine=58720257;
 //BA.debugLineNum = 58720257;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=58720258;
 //BA.debugLineNum = 58720258;BA.debugLine="If(Checked=True)Then";
if ((_checked==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=58720260;
 //BA.debugLineNum = 58720260;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' se";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set state='tatil1' WHERE id="+BA.NumberToString(_selectedday_id));
 }else {
RDebugUtils.currentLine=58720264;
 //BA.debugLineNum = 58720264;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' se";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set state='' WHERE id="+BA.NumberToString(_selectedday_id));
 };
RDebugUtils.currentLine=58720267;
 //BA.debugLineNum = 58720267;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,lbl_moon_nam";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())));
RDebugUtils.currentLine=58720269;
 //BA.debugLineNum = 58720269;BA.debugLine="pan_all_menu_day_Click";
_pan_all_menu_day_click();
RDebugUtils.currentLine=58720270;
 //BA.debugLineNum = 58720270;BA.debugLine="ToastMessageShow(\" ذخیره شد\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" ذخیره شد"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=58720271;
 //BA.debugLineNum = 58720271;BA.debugLine="End Sub";
return "";
}
public static String  _generat_taghvim(int _year,int _moon) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "generat_taghvim", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "generat_taghvim", new Object[] {_year,_moon}));}
int _d = 0;
int _count_day_moon = 0;
int _i = 0;
int _j = 0;
int _counter = 0;
int _f = 0;
RDebugUtils.currentLine=57081856;
 //BA.debugLineNum = 57081856;BA.debugLine="Sub generat_taghvim(year As Int , moon As Int)";
RDebugUtils.currentLine=57081857;
 //BA.debugLineNum = 57081857;BA.debugLine="Try";
try {RDebugUtils.currentLine=57081860;
 //BA.debugLineNum = 57081860;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=57081864;
 //BA.debugLineNum = 57081864;BA.debugLine="For d=0 To PA.Length-1";
{
final int step3 = 1;
final int limit3 = (int) (mostCurrent._pa.length-1);
_d = (int) (0) ;
for (;_d <= limit3 ;_d = _d + step3 ) {
RDebugUtils.currentLine=57081865;
 //BA.debugLineNum = 57081865;BA.debugLine="PA(d).Visible=True";
mostCurrent._pa[_d].setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=57081866;
 //BA.debugLineNum = 57081866;BA.debugLine="PA(d).Color=0xFFEFEFEF";
mostCurrent._pa[_d].setColor(((int)0xffefefef));
RDebugUtils.currentLine=57081869;
 //BA.debugLineNum = 57081869;BA.debugLine="EZ(d).Text=\"\"";
mostCurrent._ez[_d].setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=57081870;
 //BA.debugLineNum = 57081870;BA.debugLine="NO(d).Text=\"\"";
mostCurrent._no[_d].setText(BA.ObjectToCharSequence(""));
 }
};
RDebugUtils.currentLine=57081874;
 //BA.debugLineNum = 57081874;BA.debugLine="ls_shift_moon.Clear";
mostCurrent._ls_shift_moon.Clear();
RDebugUtils.currentLine=57081875;
 //BA.debugLineNum = 57081875;BA.debugLine="ls_tatili_moon.Clear";
mostCurrent._ls_tatili_moon.Clear();
RDebugUtils.currentLine=57081876;
 //BA.debugLineNum = 57081876;BA.debugLine="ls_tatili_custom_moon.Clear";
mostCurrent._ls_tatili_custom_moon.Clear();
RDebugUtils.currentLine=57081877;
 //BA.debugLineNum = 57081877;BA.debugLine="ls_note_moon.Clear";
mostCurrent._ls_note_moon.Clear();
RDebugUtils.currentLine=57081879;
 //BA.debugLineNum = 57081879;BA.debugLine="Dim count_day_moon As Int";
_count_day_moon = 0;
RDebugUtils.currentLine=57081881;
 //BA.debugLineNum = 57081881;BA.debugLine="current_moon=moon";
_current_moon = _moon;
RDebugUtils.currentLine=57081882;
 //BA.debugLineNum = 57081882;BA.debugLine="lbl_moon_name.Tag=moon";
mostCurrent._lbl_moon_name.setTag((Object)(_moon));
RDebugUtils.currentLine=57081883;
 //BA.debugLineNum = 57081883;BA.debugLine="lbl_year_tagvim.Text=year";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_year));
RDebugUtils.currentLine=57081885;
 //BA.debugLineNum = 57081885;BA.debugLine="Select moon";
switch (_moon) {
case 1: {
RDebugUtils.currentLine=57081887;
 //BA.debugLineNum = 57081887;BA.debugLine="lbl_moon_name.Text=\"فروردین\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("فروردین"));
 break; }
case 2: {
RDebugUtils.currentLine=57081889;
 //BA.debugLineNum = 57081889;BA.debugLine="lbl_moon_name.Text=\"اردیبهشت\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("اردیبهشت"));
 break; }
case 3: {
RDebugUtils.currentLine=57081891;
 //BA.debugLineNum = 57081891;BA.debugLine="lbl_moon_name.Text=\"خرداد\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("خرداد"));
 break; }
case 4: {
RDebugUtils.currentLine=57081893;
 //BA.debugLineNum = 57081893;BA.debugLine="lbl_moon_name.Text=\"تیر\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("تیر"));
 break; }
case 5: {
RDebugUtils.currentLine=57081895;
 //BA.debugLineNum = 57081895;BA.debugLine="lbl_moon_name.Text=\"مرداد\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("مرداد"));
 break; }
case 6: {
RDebugUtils.currentLine=57081897;
 //BA.debugLineNum = 57081897;BA.debugLine="lbl_moon_name.Text=\"شهریور\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("شهریور"));
 break; }
case 7: {
RDebugUtils.currentLine=57081899;
 //BA.debugLineNum = 57081899;BA.debugLine="lbl_moon_name.Text=\"مهر\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("مهر"));
 break; }
case 8: {
RDebugUtils.currentLine=57081901;
 //BA.debugLineNum = 57081901;BA.debugLine="lbl_moon_name.Text=\"آبان\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("آبان"));
 break; }
case 9: {
RDebugUtils.currentLine=57081903;
 //BA.debugLineNum = 57081903;BA.debugLine="lbl_moon_name.Text=\"آذر\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("آذر"));
 break; }
case 10: {
RDebugUtils.currentLine=57081905;
 //BA.debugLineNum = 57081905;BA.debugLine="lbl_moon_name.Text=\"دی\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("دی"));
 break; }
case 11: {
RDebugUtils.currentLine=57081907;
 //BA.debugLineNum = 57081907;BA.debugLine="lbl_moon_name.Text=\"بهمن\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("بهمن"));
 break; }
case 12: {
RDebugUtils.currentLine=57081909;
 //BA.debugLineNum = 57081909;BA.debugLine="lbl_moon_name.Text=\"اسفند\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("اسفند"));
 break; }
}
;
RDebugUtils.currentLine=57081915;
 //BA.debugLineNum = 57081915;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE year="+BA.NumberToString(_year)+" AND moon="+BA.NumberToString(_moon)+" ;")));
RDebugUtils.currentLine=57081919;
 //BA.debugLineNum = 57081919;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=57081921;
 //BA.debugLineNum = 57081921;BA.debugLine="count_day_moon=dbCode.res.RowCount";
_count_day_moon = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount();
RDebugUtils.currentLine=57081922;
 //BA.debugLineNum = 57081922;BA.debugLine="dbCode.res.Position =0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=57081923;
 //BA.debugLineNum = 57081923;BA.debugLine="start_day=dbCode.res.Getint(\"day_h\")";
_start_day = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_h");
RDebugUtils.currentLine=57081926;
 //BA.debugLineNum = 57081926;BA.debugLine="For i=0 To dbCode.res.RowCount-1";
{
final int step48 = 1;
final int limit48 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit48 ;_i = _i + step48 ) {
RDebugUtils.currentLine=57081927;
 //BA.debugLineNum = 57081927;BA.debugLine="dbCode.res.Position =i";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_i);
RDebugUtils.currentLine=57081929;
 //BA.debugLineNum = 57081929;BA.debugLine="If (dbCode.res.GetString(\"shift\") = Null)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")== null)) { 
RDebugUtils.currentLine=57081930;
 //BA.debugLineNum = 57081930;BA.debugLine="ls_shift_moon.Add(\"\")";
mostCurrent._ls_shift_moon.Add((Object)(""));
 }else {
RDebugUtils.currentLine=57081932;
 //BA.debugLineNum = 57081932;BA.debugLine="ls_shift_moon.Add(dbCode.res.GetString(\"shift";
mostCurrent._ls_shift_moon.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")));
 };
RDebugUtils.currentLine=57081936;
 //BA.debugLineNum = 57081936;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Th";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=57081937;
 //BA.debugLineNum = 57081937;BA.debugLine="ls_tatili_moon.Add(True)";
mostCurrent._ls_tatili_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.True));
 }else {
RDebugUtils.currentLine=57081939;
 //BA.debugLineNum = 57081939;BA.debugLine="ls_tatili_moon.Add(False)";
mostCurrent._ls_tatili_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.False));
 };
RDebugUtils.currentLine=57081943;
 //BA.debugLineNum = 57081943;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil1\")T";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil1"))) { 
RDebugUtils.currentLine=57081944;
 //BA.debugLineNum = 57081944;BA.debugLine="ls_tatili_custom_moon.Add(True)";
mostCurrent._ls_tatili_custom_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.True));
 }else {
RDebugUtils.currentLine=57081946;
 //BA.debugLineNum = 57081946;BA.debugLine="ls_tatili_custom_moon.Add(False)";
mostCurrent._ls_tatili_custom_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.False));
 };
RDebugUtils.currentLine=57081950;
 //BA.debugLineNum = 57081950;BA.debugLine="If (dbCode.res.GetString(\"note\") = \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")).equals(""))) { 
RDebugUtils.currentLine=57081951;
 //BA.debugLineNum = 57081951;BA.debugLine="ls_note_moon.Add(False)";
mostCurrent._ls_note_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.False));
 }else {
RDebugUtils.currentLine=57081953;
 //BA.debugLineNum = 57081953;BA.debugLine="ls_note_moon.Add(True)";
mostCurrent._ls_note_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.True));
 };
 }
};
 }else {
RDebugUtils.currentLine=57081962;
 //BA.debugLineNum = 57081962;BA.debugLine="Log(\"nooop data\")";
anywheresoftware.b4a.keywords.Common.LogImpl("357081962","nooop data",0);
 };
RDebugUtils.currentLine=57081967;
 //BA.debugLineNum = 57081967;BA.debugLine="For  j=start_day-1 To 0 Step -1";
{
final int step74 = -1;
final int limit74 = (int) (0);
_j = (int) (_start_day-1) ;
for (;_j >= limit74 ;_j = _j + step74 ) {
RDebugUtils.currentLine=57081968;
 //BA.debugLineNum = 57081968;BA.debugLine="PA(j).Visible=False";
mostCurrent._pa[_j].setVisible(anywheresoftware.b4a.keywords.Common.False);
 }
};
RDebugUtils.currentLine=57081973;
 //BA.debugLineNum = 57081973;BA.debugLine="Dim counter As Int=1";
_counter = (int) (1);
RDebugUtils.currentLine=57081975;
 //BA.debugLineNum = 57081975;BA.debugLine="For i = start_day To count_day_moon+start_day";
{
final int step78 = 1;
final int limit78 = (int) (_count_day_moon+_start_day);
_i = _start_day ;
for (;_i <= limit78 ;_i = _i + step78 ) {
RDebugUtils.currentLine=57081981;
 //BA.debugLineNum = 57081981;BA.debugLine="Lb(i).Text=counter";
mostCurrent._lb[_i].setText(BA.ObjectToCharSequence(_counter));
RDebugUtils.currentLine=57081982;
 //BA.debugLineNum = 57081982;BA.debugLine="PA(i).Tag=counter";
mostCurrent._pa[_i].setTag((Object)(_counter));
RDebugUtils.currentLine=57081987;
 //BA.debugLineNum = 57081987;BA.debugLine="If(counter-1 < count_day_moon)Then";
if ((_counter-1<_count_day_moon)) { 
RDebugUtils.currentLine=57081988;
 //BA.debugLineNum = 57081988;BA.debugLine="SH(i).Text=ls_shift_moon.Get(counter-1)  ''---s";
mostCurrent._sh[_i].setText(BA.ObjectToCharSequence(mostCurrent._ls_shift_moon.Get((int) (_counter-1))));
RDebugUtils.currentLine=57081989;
 //BA.debugLineNum = 57081989;BA.debugLine="If(SH(i).Text=\"ر\")Then";
if (((mostCurrent._sh[_i].getText()).equals("ر"))) { 
RDebugUtils.currentLine=57081990;
 //BA.debugLineNum = 57081990;BA.debugLine="SH(i).Color=0x96FFFA00";
mostCurrent._sh[_i].setColor(((int)0x96fffa00));
 }else 
{RDebugUtils.currentLine=57081991;
 //BA.debugLineNum = 57081991;BA.debugLine="Else If (SH(i).Text=\"ع\")Then";
if (((mostCurrent._sh[_i].getText()).equals("ع"))) { 
RDebugUtils.currentLine=57081992;
 //BA.debugLineNum = 57081992;BA.debugLine="SH(i).Color=0x961CA4FF";
mostCurrent._sh[_i].setColor(((int)0x961ca4ff));
 }else 
{RDebugUtils.currentLine=57081993;
 //BA.debugLineNum = 57081993;BA.debugLine="Else If (SH(i).Text=\"ش\")Then";
if (((mostCurrent._sh[_i].getText()).equals("ش"))) { 
RDebugUtils.currentLine=57081994;
 //BA.debugLineNum = 57081994;BA.debugLine="SH(i).Color=0x96414141";
mostCurrent._sh[_i].setColor(((int)0x96414141));
 }else 
{RDebugUtils.currentLine=57081995;
 //BA.debugLineNum = 57081995;BA.debugLine="Else If (SH(i).Text=\"ا\")Then";
if (((mostCurrent._sh[_i].getText()).equals("ا"))) { 
RDebugUtils.currentLine=57081996;
 //BA.debugLineNum = 57081996;BA.debugLine="SH(i).Color=0x9600FF24";
mostCurrent._sh[_i].setColor(((int)0x9600ff24));
 }else 
{RDebugUtils.currentLine=57081997;
 //BA.debugLineNum = 57081997;BA.debugLine="Else If (SH(i).Text=\"ص/ع\")Then";
if (((mostCurrent._sh[_i].getText()).equals("ص/ع"))) { 
RDebugUtils.currentLine=57081998;
 //BA.debugLineNum = 57081998;BA.debugLine="SH(i).Color=0x96FF9452";
mostCurrent._sh[_i].setColor(((int)0x96ff9452));
 }else 
{RDebugUtils.currentLine=57081999;
 //BA.debugLineNum = 57081999;BA.debugLine="Else If (SH(i).Text=\"ع/ش\")Then";
if (((mostCurrent._sh[_i].getText()).equals("ع/ش"))) { 
RDebugUtils.currentLine=57082000;
 //BA.debugLineNum = 57082000;BA.debugLine="SH(i).Color=0xFF50FF89";
mostCurrent._sh[_i].setColor(((int)0xff50ff89));
 }else 
{RDebugUtils.currentLine=57082001;
 //BA.debugLineNum = 57082001;BA.debugLine="Else If (SH(i).Text=\"ص/ش\")Then";
if (((mostCurrent._sh[_i].getText()).equals("ص/ش"))) { 
RDebugUtils.currentLine=57082002;
 //BA.debugLineNum = 57082002;BA.debugLine="SH(i).Color=0x963356DA";
mostCurrent._sh[_i].setColor(((int)0x963356da));
 }else {
RDebugUtils.currentLine=57082004;
 //BA.debugLineNum = 57082004;BA.debugLine="SH(i).Color=Colors.Transparent";
mostCurrent._sh[_i].setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 }}}}}}}
;
RDebugUtils.currentLine=57082010;
 //BA.debugLineNum = 57082010;BA.debugLine="If(ls_tatili_moon.Get(counter-1)=True)Then";
if (((mostCurrent._ls_tatili_moon.Get((int) (_counter-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=57082011;
 //BA.debugLineNum = 57082011;BA.debugLine="PA(i).Color=0xFFFF5252";
mostCurrent._pa[_i].setColor(((int)0xffff5252));
 };
RDebugUtils.currentLine=57082015;
 //BA.debugLineNum = 57082015;BA.debugLine="If(ls_tatili_custom_moon.Get(counter-1)=True)T";
if (((mostCurrent._ls_tatili_custom_moon.Get((int) (_counter-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=57082016;
 //BA.debugLineNum = 57082016;BA.debugLine="PA(i).Color=0xFF00BB8B";
mostCurrent._pa[_i].setColor(((int)0xff00bb8b));
 };
RDebugUtils.currentLine=57082020;
 //BA.debugLineNum = 57082020;BA.debugLine="If(ls_note_moon.Get(counter-1)=True)Then";
if (((mostCurrent._ls_note_moon.Get((int) (_counter-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=57082021;
 //BA.debugLineNum = 57082021;BA.debugLine="NO(i).Text=\"•\"";
mostCurrent._no[_i].setText(BA.ObjectToCharSequence("•"));
RDebugUtils.currentLine=57082022;
 //BA.debugLineNum = 57082022;BA.debugLine="NO(i).textColor=Colors.Blue";
mostCurrent._no[_i].setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 };
RDebugUtils.currentLine=57082027;
 //BA.debugLineNum = 57082027;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(year&\"/\"&my";
if ((mostCurrent._dbcode._isexist_ezafekari_by_date /*boolean*/ (mostCurrent.activityBA,BA.NumberToString(_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_counter))==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=57082028;
 //BA.debugLineNum = 57082028;BA.debugLine="EZ(i).Text=\"*\"";
mostCurrent._ez[_i].setText(BA.ObjectToCharSequence("*"));
RDebugUtils.currentLine=57082029;
 //BA.debugLineNum = 57082029;BA.debugLine="EZ(i).TextColor=0xFF00941C";
mostCurrent._ez[_i].setTextColor(((int)0xff00941c));
 }else 
{RDebugUtils.currentLine=57082030;
 //BA.debugLineNum = 57082030;BA.debugLine="Else if (dbCode.isexist_morakhasi_by_date(year&";
if ((mostCurrent._dbcode._isexist_morakhasi_by_date /*boolean*/ (mostCurrent.activityBA,BA.NumberToString(_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_counter))==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=57082031;
 //BA.debugLineNum = 57082031;BA.debugLine="EZ(i).Text=\"*\"";
mostCurrent._ez[_i].setText(BA.ObjectToCharSequence("*"));
RDebugUtils.currentLine=57082032;
 //BA.debugLineNum = 57082032;BA.debugLine="EZ(i).TextColor=0xFFFF5200";
mostCurrent._ez[_i].setTextColor(((int)0xffff5200));
 }else 
{RDebugUtils.currentLine=57082033;
 //BA.debugLineNum = 57082033;BA.debugLine="Else if (dbCode.isexist_taradod_by_date(year&\"/";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,BA.NumberToString(_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_counter))==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=57082034;
 //BA.debugLineNum = 57082034;BA.debugLine="EZ(i).Text=\"*\"";
mostCurrent._ez[_i].setText(BA.ObjectToCharSequence("*"));
RDebugUtils.currentLine=57082035;
 //BA.debugLineNum = 57082035;BA.debugLine="EZ(i).TextColor=0xFFFF5200";
mostCurrent._ez[_i].setTextColor(((int)0xffff5200));
 }}}
;
 };
RDebugUtils.currentLine=57082044;
 //BA.debugLineNum = 57082044;BA.debugLine="If(counter=this_day And moon=date.PersianMonth A";
if ((_counter==_this_day && _moon==mostCurrent._date.getPersianMonth() && _year==_this_year)) { 
RDebugUtils.currentLine=57082047;
 //BA.debugLineNum = 57082047;BA.debugLine="Lb(i).TextColor=0xFFFF9000";
mostCurrent._lb[_i].setTextColor(((int)0xffff9000));
RDebugUtils.currentLine=57082048;
 //BA.debugLineNum = 57082048;BA.debugLine="index_i_today=i";
_index_i_today = _i;
 };
RDebugUtils.currentLine=57082051;
 //BA.debugLineNum = 57082051;BA.debugLine="If(counter>=count_day_moon)Then";
if ((_counter>=_count_day_moon)) { 
RDebugUtils.currentLine=57082053;
 //BA.debugLineNum = 57082053;BA.debugLine="For f=i+1 To Lb.Length-1";
{
final int step126 = 1;
final int limit126 = (int) (mostCurrent._lb.length-1);
_f = (int) (_i+1) ;
for (;_f <= limit126 ;_f = _f + step126 ) {
RDebugUtils.currentLine=57082054;
 //BA.debugLineNum = 57082054;BA.debugLine="PA(f).Visible=False";
mostCurrent._pa[_f].setVisible(anywheresoftware.b4a.keywords.Common.False);
 }
};
 };
RDebugUtils.currentLine=57082060;
 //BA.debugLineNum = 57082060;BA.debugLine="counter=counter+1";
_counter = (int) (_counter+1);
 }
};
 } 
       catch (Exception e133) {
			processBA.setLastException(e133);RDebugUtils.currentLine=57082064;
 //BA.debugLineNum = 57082064;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("357082064",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=57082068;
 //BA.debugLineNum = 57082068;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_menu_day_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_menu_day_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_menu_day_click", null));}
RDebugUtils.currentLine=58458112;
 //BA.debugLineNum = 58458112;BA.debugLine="Private Sub pan_all_menu_day_Click";
RDebugUtils.currentLine=58458113;
 //BA.debugLineNum = 58458113;BA.debugLine="pan_all_menu_day.Visible=False";
mostCurrent._pan_all_menu_day.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=58458114;
 //BA.debugLineNum = 58458114;BA.debugLine="End Sub";
return "";
}
public static String  _checkbox_tatil_rasmi_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "checkbox_tatil_rasmi_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "checkbox_tatil_rasmi_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=58916864;
 //BA.debugLineNum = 58916864;BA.debugLine="Private Sub CheckBox_tatil_rasmi_CheckedChange(Che";
RDebugUtils.currentLine=58916866;
 //BA.debugLineNum = 58916866;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=58916867;
 //BA.debugLineNum = 58916867;BA.debugLine="If(Checked=True)Then";
if ((_checked==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=58916869;
 //BA.debugLineNum = 58916869;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' se";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set state='tatil' WHERE id="+BA.NumberToString(_selectedday_id));
 }else {
RDebugUtils.currentLine=58916873;
 //BA.debugLineNum = 58916873;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' se";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set state='' WHERE id="+BA.NumberToString(_selectedday_id));
 };
RDebugUtils.currentLine=58916876;
 //BA.debugLineNum = 58916876;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,lbl_moon_nam";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())));
RDebugUtils.currentLine=58916878;
 //BA.debugLineNum = 58916878;BA.debugLine="pan_all_menu_day_Click";
_pan_all_menu_day_click();
RDebugUtils.currentLine=58916879;
 //BA.debugLineNum = 58916879;BA.debugLine="ToastMessageShow(\" ذخیره شد\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" ذخیره شد"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=58916894;
 //BA.debugLineNum = 58916894;BA.debugLine="End Sub";
return "";
}
public static String  _get_ezafekari(String _date1) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_ezafekari", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_ezafekari", new Object[] {_date1}));}
anywheresoftware.b4a.objects.collections.List _ezlist = null;
String _newline = "";
int _k = 0;
anywheresoftware.b4a.objects.collections.List _ls_time_conv = null;
int _i = 0;
RDebugUtils.currentLine=56950784;
 //BA.debugLineNum = 56950784;BA.debugLine="Sub get_ezafekari(date1 As String)";
RDebugUtils.currentLine=56950785;
 //BA.debugLineNum = 56950785;BA.debugLine="lbl_ezafekari_day.Text=\"\"";
mostCurrent._lbl_ezafekari_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=56950786;
 //BA.debugLineNum = 56950786;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=56950787;
 //BA.debugLineNum = 56950787;BA.debugLine="Dim ezList As List";
_ezlist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=56950788;
 //BA.debugLineNum = 56950788;BA.debugLine="ezList.Initialize";
_ezlist.Initialize();
RDebugUtils.currentLine=56950789;
 //BA.debugLineNum = 56950789;BA.debugLine="Dim newLine As String=\"\"";
_newline = "";
RDebugUtils.currentLine=56950791;
 //BA.debugLineNum = 56950791;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"+_date1+"';")));
RDebugUtils.currentLine=56950793;
 //BA.debugLineNum = 56950793;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=56950794;
 //BA.debugLineNum = 56950794;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_k = (int) (0) ;
for (;_k <= limit8 ;_k = _k + step8 ) {
RDebugUtils.currentLine=56950795;
 //BA.debugLineNum = 56950795;BA.debugLine="dbCode.res.Position=K";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_k);
RDebugUtils.currentLine=56950798;
 //BA.debugLineNum = 56950798;BA.debugLine="Dim ls_time_conv As List";
_ls_time_conv = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=56950799;
 //BA.debugLineNum = 56950799;BA.debugLine="ls_time_conv.Initialize";
_ls_time_conv.Initialize();
RDebugUtils.currentLine=56950800;
 //BA.debugLineNum = 56950800;BA.debugLine="ls_time_conv=myfunc.Min_to_saatMinRoz2_dontDay(";
_ls_time_conv = mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_m"));
RDebugUtils.currentLine=56950803;
 //BA.debugLineNum = 56950803;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
_ezlist.Add((Object)(_newline+"از "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" تا "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+"  ( "+BA.ObjectToString(_ls_time_conv.Get((int) (0)))+":"+BA.ObjectToString(_ls_time_conv.Get((int) (1)))+")"));
RDebugUtils.currentLine=56950804;
 //BA.debugLineNum = 56950804;BA.debugLine="newLine=CRLF";
_newline = anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 }else {
RDebugUtils.currentLine=56950810;
 //BA.debugLineNum = 56950810;BA.debugLine="ezList.Add(\"-\")";
_ezlist.Add((Object)("-"));
 };
RDebugUtils.currentLine=56950813;
 //BA.debugLineNum = 56950813;BA.debugLine="For i=0 To ezList.Size-1";
{
final int step19 = 1;
final int limit19 = (int) (_ezlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit19 ;_i = _i + step19 ) {
RDebugUtils.currentLine=56950814;
 //BA.debugLineNum = 56950814;BA.debugLine="lbl_ezafekari_day.Text=lbl_ezafekari_day.Text &";
mostCurrent._lbl_ezafekari_day.setText(BA.ObjectToCharSequence(mostCurrent._lbl_ezafekari_day.getText()+BA.ObjectToString(_ezlist.Get(_i))));
 }
};
RDebugUtils.currentLine=56950817;
 //BA.debugLineNum = 56950817;BA.debugLine="End Sub";
return "";
}
public static String  _get_monasebat(int _id) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_monasebat", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_monasebat", new Object[] {_id}));}
String _str_sh = "";
RDebugUtils.currentLine=56754176;
 //BA.debugLineNum = 56754176;BA.debugLine="Sub get_monasebat ( id As Int)";
RDebugUtils.currentLine=56754177;
 //BA.debugLineNum = 56754177;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=56754178;
 //BA.debugLineNum = 56754178;BA.debugLine="lbl_today_monasebat.Text=\"\"";
mostCurrent._lbl_today_monasebat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=56754179;
 //BA.debugLineNum = 56754179;BA.debugLine="lbl_today.Text=\"\"";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=56754181;
 //BA.debugLineNum = 56754181;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=56754184;
 //BA.debugLineNum = 56754184;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=56754188;
 //BA.debugLineNum = 56754188;BA.debugLine="If(dbCode.res.GetString(\"monasebat\")<> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("monasebat")).equals("") == false)) { 
RDebugUtils.currentLine=56754189;
 //BA.debugLineNum = 56754189;BA.debugLine="lbl_today_monasebat.Text=dbCode.res.GetString(\"m";
mostCurrent._lbl_today_monasebat.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("monasebat")));
 };
RDebugUtils.currentLine=56754193;
 //BA.debugLineNum = 56754193;BA.debugLine="lbl_today.Text=lbl_year_tagvim.Text&\"/\"&dbCode.re";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("moon")+"/"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_c"))));
RDebugUtils.currentLine=56754196;
 //BA.debugLineNum = 56754196;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=56754197;
 //BA.debugLineNum = 56754197;BA.debugLine="lbl_today.Text=lbl_today.Text&\" (تعطیل) \"";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_today.getText()+" (تعطیل) "));
 };
RDebugUtils.currentLine=56754200;
 //BA.debugLineNum = 56754200;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil1\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil1"))) { 
RDebugUtils.currentLine=56754201;
 //BA.debugLineNum = 56754201;BA.debugLine="lbl_today.Text=lbl_today.Text&\" ( تعطیل قراردادی";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_today.getText()+" ( تعطیل قراردادی) "));
 };
RDebugUtils.currentLine=56754204;
 //BA.debugLineNum = 56754204;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")).equals("") == false)) { 
RDebugUtils.currentLine=56754205;
 //BA.debugLineNum = 56754205;BA.debugLine="Dim str_sh As String";
_str_sh = "";
RDebugUtils.currentLine=56754206;
 //BA.debugLineNum = 56754206;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift"),"ر","ش","ع","ا","ص/ع","ع/ش","ص/ش")) {
case 0: {
RDebugUtils.currentLine=56754208;
 //BA.debugLineNum = 56754208;BA.debugLine="str_sh=\"روزکار\"";
_str_sh = "روزکار";
 break; }
case 1: {
RDebugUtils.currentLine=56754210;
 //BA.debugLineNum = 56754210;BA.debugLine="str_sh=\"شبکار\"";
_str_sh = "شبکار";
 break; }
case 2: {
RDebugUtils.currentLine=56754212;
 //BA.debugLineNum = 56754212;BA.debugLine="str_sh=\"عصرکار\"";
_str_sh = "عصرکار";
 break; }
case 3: {
RDebugUtils.currentLine=56754214;
 //BA.debugLineNum = 56754214;BA.debugLine="str_sh=\"استراحت\"";
_str_sh = "استراحت";
 break; }
case 4: {
RDebugUtils.currentLine=56754216;
 //BA.debugLineNum = 56754216;BA.debugLine="str_sh=\"صبح-عصر\"";
_str_sh = "صبح-عصر";
 break; }
case 5: {
RDebugUtils.currentLine=56754218;
 //BA.debugLineNum = 56754218;BA.debugLine="str_sh=\"عصر-شب\"";
_str_sh = "عصر-شب";
 break; }
case 6: {
RDebugUtils.currentLine=56754220;
 //BA.debugLineNum = 56754220;BA.debugLine="str_sh=\"صبح-شب\"";
_str_sh = "صبح-شب";
 break; }
}
;
RDebugUtils.currentLine=56754223;
 //BA.debugLineNum = 56754223;BA.debugLine="lbl_today.Text=lbl_today.Text&\"- (( شیفت : \"&str";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_today.getText()+"- (( شیفت : "+_str_sh+" )) "));
 };
RDebugUtils.currentLine=56754227;
 //BA.debugLineNum = 56754227;BA.debugLine="End Sub";
return "";
}
public static String  _get_morakhasi(String _date1) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_morakhasi", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_morakhasi", new Object[] {_date1}));}
anywheresoftware.b4a.objects.collections.List _ezlist = null;
String _newline = "";
int _k = 0;
anywheresoftware.b4a.objects.collections.List _ls_time_conv = null;
int _i = 0;
RDebugUtils.currentLine=57016320;
 //BA.debugLineNum = 57016320;BA.debugLine="Sub get_morakhasi(date1 As String)";
RDebugUtils.currentLine=57016321;
 //BA.debugLineNum = 57016321;BA.debugLine="lbl_morakhasi_day.Text=\"\"";
mostCurrent._lbl_morakhasi_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=57016322;
 //BA.debugLineNum = 57016322;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=57016323;
 //BA.debugLineNum = 57016323;BA.debugLine="Dim ezList As List";
_ezlist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=57016324;
 //BA.debugLineNum = 57016324;BA.debugLine="ezList.Initialize";
_ezlist.Initialize();
RDebugUtils.currentLine=57016325;
 //BA.debugLineNum = 57016325;BA.debugLine="Dim newLine As String=\"\"";
_newline = "";
RDebugUtils.currentLine=57016327;
 //BA.debugLineNum = 57016327;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"+_date1+"';")));
RDebugUtils.currentLine=57016329;
 //BA.debugLineNum = 57016329;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=57016330;
 //BA.debugLineNum = 57016330;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_k = (int) (0) ;
for (;_k <= limit8 ;_k = _k + step8 ) {
RDebugUtils.currentLine=57016331;
 //BA.debugLineNum = 57016331;BA.debugLine="dbCode.res.Position=K";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_k);
RDebugUtils.currentLine=57016333;
 //BA.debugLineNum = 57016333;BA.debugLine="Dim ls_time_conv As List";
_ls_time_conv = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=57016334;
 //BA.debugLineNum = 57016334;BA.debugLine="ls_time_conv.Initialize";
_ls_time_conv.Initialize();
RDebugUtils.currentLine=57016335;
 //BA.debugLineNum = 57016335;BA.debugLine="ls_time_conv=myfunc.Min_to_saatMinRoz(dbCode.re";
_ls_time_conv = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_m"));
RDebugUtils.currentLine=57016338;
 //BA.debugLineNum = 57016338;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
_ezlist.Add((Object)(_newline+"از "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" تا "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+"  ( "+BA.ObjectToString(_ls_time_conv.Get((int) (2)))+":"+BA.ObjectToString(_ls_time_conv.Get((int) (0)))+":"+BA.ObjectToString(_ls_time_conv.Get((int) (1)))+")"));
RDebugUtils.currentLine=57016339;
 //BA.debugLineNum = 57016339;BA.debugLine="newLine=CRLF";
_newline = anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 }else {
RDebugUtils.currentLine=57016345;
 //BA.debugLineNum = 57016345;BA.debugLine="ezList.Add(\"-\")";
_ezlist.Add((Object)("-"));
 };
RDebugUtils.currentLine=57016348;
 //BA.debugLineNum = 57016348;BA.debugLine="For i=0 To ezList.Size-1";
{
final int step19 = 1;
final int limit19 = (int) (_ezlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit19 ;_i = _i + step19 ) {
RDebugUtils.currentLine=57016349;
 //BA.debugLineNum = 57016349;BA.debugLine="lbl_morakhasi_day.Text=lbl_morakhasi_day.Text &";
mostCurrent._lbl_morakhasi_day.setText(BA.ObjectToCharSequence(mostCurrent._lbl_morakhasi_day.getText()+BA.ObjectToString(_ezlist.Get(_i))));
 }
};
RDebugUtils.currentLine=57016352;
 //BA.debugLineNum = 57016352;BA.debugLine="End Sub";
return "";
}
public static String  _get_note(int _id) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_note", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_note", new Object[] {_id}));}
RDebugUtils.currentLine=56819712;
 //BA.debugLineNum = 56819712;BA.debugLine="Sub get_note ( id As Int)";
RDebugUtils.currentLine=56819713;
 //BA.debugLineNum = 56819713;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=56819714;
 //BA.debugLineNum = 56819714;BA.debugLine="lbl_note_day.Text=\"\"";
mostCurrent._lbl_note_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=56819717;
 //BA.debugLineNum = 56819717;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=56819718;
 //BA.debugLineNum = 56819718;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=56819720;
 //BA.debugLineNum = 56819720;BA.debugLine="If(dbCode.res.GetString(\"note\")<> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")).equals("") == false)) { 
RDebugUtils.currentLine=56819721;
 //BA.debugLineNum = 56819721;BA.debugLine="lbl_note_day.Text=dbCode.res.GetString(\"note\")";
mostCurrent._lbl_note_day.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")));
 };
RDebugUtils.currentLine=56819724;
 //BA.debugLineNum = 56819724;BA.debugLine="End Sub";
return "";
}
public static String  _get_taradod(String _date1) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_taradod", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_taradod", new Object[] {_date1}));}
anywheresoftware.b4a.objects.collections.List _ezlist = null;
String _newline = "";
int _k = 0;
int _i = 0;
RDebugUtils.currentLine=56885248;
 //BA.debugLineNum = 56885248;BA.debugLine="Sub get_taradod(date1 As String)";
RDebugUtils.currentLine=56885249;
 //BA.debugLineNum = 56885249;BA.debugLine="lbl_taradod_day.Text=\"\"";
mostCurrent._lbl_taradod_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=56885250;
 //BA.debugLineNum = 56885250;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=56885251;
 //BA.debugLineNum = 56885251;BA.debugLine="Dim ezList As List";
_ezlist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=56885252;
 //BA.debugLineNum = 56885252;BA.debugLine="ezList.Initialize";
_ezlist.Initialize();
RDebugUtils.currentLine=56885253;
 //BA.debugLineNum = 56885253;BA.debugLine="Dim newLine As String=\"\"";
_newline = "";
RDebugUtils.currentLine=56885255;
 //BA.debugLineNum = 56885255;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+_date1+"';")));
RDebugUtils.currentLine=56885257;
 //BA.debugLineNum = 56885257;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=56885258;
 //BA.debugLineNum = 56885258;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_k = (int) (0) ;
for (;_k <= limit8 ;_k = _k + step8 ) {
RDebugUtils.currentLine=56885259;
 //BA.debugLineNum = 56885259;BA.debugLine="dbCode.res.Position=K";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_k);
RDebugUtils.currentLine=56885261;
 //BA.debugLineNum = 56885261;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
_ezlist.Add((Object)(_newline+"از "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" تا "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=56885262;
 //BA.debugLineNum = 56885262;BA.debugLine="newLine=CRLF";
_newline = anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 }else {
RDebugUtils.currentLine=56885266;
 //BA.debugLineNum = 56885266;BA.debugLine="ezList.Add(\"-\")";
_ezlist.Add((Object)("-"));
 };
RDebugUtils.currentLine=56885269;
 //BA.debugLineNum = 56885269;BA.debugLine="For i=0 To ezList.Size-1";
{
final int step16 = 1;
final int limit16 = (int) (_ezlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
RDebugUtils.currentLine=56885270;
 //BA.debugLineNum = 56885270;BA.debugLine="lbl_taradod_day.Text=lbl_taradod_day.Text & ezLi";
mostCurrent._lbl_taradod_day.setText(BA.ObjectToCharSequence(mostCurrent._lbl_taradod_day.getText()+BA.ObjectToString(_ezlist.Get(_i))));
 }
};
RDebugUtils.currentLine=56885273;
 //BA.debugLineNum = 56885273;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_2_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_2_click", null));}
RDebugUtils.currentLine=57737216;
 //BA.debugLineNum = 57737216;BA.debugLine="Private Sub lbl_back_2_Click";
RDebugUtils.currentLine=57737217;
 //BA.debugLineNum = 57737217;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=57737218;
 //BA.debugLineNum = 57737218;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
RDebugUtils.currentLine=57737219;
 //BA.debugLineNum = 57737219;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_checkbox_tatil_garardadi_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_checkbox_tatil_garardadi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_checkbox_tatil_garardadi_click", null));}
RDebugUtils.currentLine=58654720;
 //BA.debugLineNum = 58654720;BA.debugLine="Private Sub lbl_CheckBox_tatil_garardadi_Click";
RDebugUtils.currentLine=58654722;
 //BA.debugLineNum = 58654722;BA.debugLine="If(CheckBox_tatil_garardadi.Checked=True)Then";
if ((mostCurrent._checkbox_tatil_garardadi.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=58654723;
 //BA.debugLineNum = 58654723;BA.debugLine="CheckBox_tatil_garardadi.Checked=False";
mostCurrent._checkbox_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=58654725;
 //BA.debugLineNum = 58654725;BA.debugLine="CheckBox_tatil_garardadi.Checked=True";
mostCurrent._checkbox_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=58654728;
 //BA.debugLineNum = 58654728;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_checkbox_tatil_rasmi_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_checkbox_tatil_rasmi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_checkbox_tatil_rasmi_click", null));}
RDebugUtils.currentLine=58851328;
 //BA.debugLineNum = 58851328;BA.debugLine="Private Sub lbl_CheckBox_tatil_rasmi_Click";
RDebugUtils.currentLine=58851329;
 //BA.debugLineNum = 58851329;BA.debugLine="If(CheckBox_tatil_rasmi.Checked=True)Then";
if ((mostCurrent._checkbox_tatil_rasmi.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=58851330;
 //BA.debugLineNum = 58851330;BA.debugLine="CheckBox_tatil_rasmi.Checked=False";
mostCurrent._checkbox_tatil_rasmi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=58851332;
 //BA.debugLineNum = 58851332;BA.debugLine="CheckBox_tatil_rasmi.Checked=True";
mostCurrent._checkbox_tatil_rasmi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=58851337;
 //BA.debugLineNum = 58851337;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_del_shiftha_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_del_shiftha_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_del_shiftha_click", null));}
RDebugUtils.currentLine=57868288;
 //BA.debugLineNum = 57868288;BA.debugLine="Private Sub lbl_del_shiftha_Click";
RDebugUtils.currentLine=57868289;
 //BA.debugLineNum = 57868289;BA.debugLine="shift_rest";
_shift_rest();
RDebugUtils.currentLine=57868290;
 //BA.debugLineNum = 57868290;BA.debugLine="End Sub";
return "";
}
public static String  _shift_rest() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "shift_rest", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "shift_rest", null));}
RDebugUtils.currentLine=57933824;
 //BA.debugLineNum = 57933824;BA.debugLine="Sub shift_rest";
RDebugUtils.currentLine=57933825;
 //BA.debugLineNum = 57933825;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=57933826;
 //BA.debugLineNum = 57933826;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' set";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set shift='' ");
RDebugUtils.currentLine=57933827;
 //BA.debugLineNum = 57933827;BA.debugLine="If(File.Exists(File.DirInternal,\"shift_olgo\"))The";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo"))) { 
RDebugUtils.currentLine=57933828;
 //BA.debugLineNum = 57933828;BA.debugLine="File.Delete(File.DirInternal,\"shift_olgo\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo");
RDebugUtils.currentLine=57933829;
 //BA.debugLineNum = 57933829;BA.debugLine="File.Delete(File.DirInternal,\"shift_olgo_cod\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo_cod");
 };
RDebugUtils.currentLine=57933833;
 //BA.debugLineNum = 57933833;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=57933834;
 //BA.debugLineNum = 57933834;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
RDebugUtils.currentLine=57933835;
 //BA.debugLineNum = 57933835;BA.debugLine="generat_taghvim(this_year,this_moon)";
_generat_taghvim(_this_year,_this_moon);
RDebugUtils.currentLine=57933836;
 //BA.debugLineNum = 57933836;BA.debugLine="ToastMessageShow(\"همه شیفت ها حذف شدند\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("همه شیفت ها حذف شدند"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=57933838;
 //BA.debugLineNum = 57933838;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_note_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_note_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_note_click", null));}
RDebugUtils.currentLine=57999360;
 //BA.debugLineNum = 57999360;BA.debugLine="Private Sub lbl_edit_note_Click";
RDebugUtils.currentLine=57999361;
 //BA.debugLineNum = 57999361;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=57999362;
 //BA.debugLineNum = 57999362;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_selectedday_id))));
RDebugUtils.currentLine=57999363;
 //BA.debugLineNum = 57999363;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=57999366;
 //BA.debugLineNum = 57999366;BA.debugLine="et_note.Text=dbCode.res.GetString(\"note\")";
mostCurrent._et_note.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")));
RDebugUtils.currentLine=57999368;
 //BA.debugLineNum = 57999368;BA.debugLine="lbl_date_in_note.Text=lbl_year_tagvim.Text&\"/\"&db";
mostCurrent._lbl_date_in_note.setText(BA.ObjectToCharSequence(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("moon")+"/"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_c"))));
RDebugUtils.currentLine=57999371;
 //BA.debugLineNum = 57999371;BA.debugLine="pan_all_note.Visible=True";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=57999372;
 //BA.debugLineNum = 57999372;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_shift_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_shift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_shift_click", null));}
RDebugUtils.currentLine=58785792;
 //BA.debugLineNum = 58785792;BA.debugLine="Private Sub lbl_help_shift_Click";
RDebugUtils.currentLine=58785793;
 //BA.debugLineNum = 58785793;BA.debugLine="myfunc.help_man(\"راهنما\",\"1- با نگهداشتن انگشت رو";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","1- با نگهداشتن انگشت روی روزها منو ابزارها باز میشود. "+anywheresoftware.b4a.keywords.Common.CRLF+" 2- برای شیفت بندی روزها از قسمت تنظیم شیفت اقدام کنید.");
RDebugUtils.currentLine=58785794;
 //BA.debugLineNum = 58785794;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_mah_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_mah_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_mah_click", null));}
RDebugUtils.currentLine=55967744;
 //BA.debugLineNum = 55967744;BA.debugLine="Private Sub lbl_mah_Click";
RDebugUtils.currentLine=55967745;
 //BA.debugLineNum = 55967745;BA.debugLine="rsPOP_mah.Show";
mostCurrent._rspop_mah.Show();
RDebugUtils.currentLine=55967746;
 //BA.debugLineNum = 55967746;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_mah_end_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_mah_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_mah_end_click", null));}
RDebugUtils.currentLine=56360960;
 //BA.debugLineNum = 56360960;BA.debugLine="Private Sub lbl_mah_end_Click";
RDebugUtils.currentLine=56360961;
 //BA.debugLineNum = 56360961;BA.debugLine="rsPOP_mah_end.Show";
mostCurrent._rspop_mah_end.Show();
RDebugUtils.currentLine=56360962;
 //BA.debugLineNum = 56360962;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_moon_name_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_moon_name_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_moon_name_click", null));}
RDebugUtils.currentLine=55574528;
 //BA.debugLineNum = 55574528;BA.debugLine="Private Sub lbl_moon_name_Click";
RDebugUtils.currentLine=55574529;
 //BA.debugLineNum = 55574529;BA.debugLine="rsPOP_moon_tagvim.Show";
mostCurrent._rspop_moon_tagvim.Show();
RDebugUtils.currentLine=55574530;
 //BA.debugLineNum = 55574530;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_new_line_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_new_line_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_new_line_click", null));}
int _i = 0;
RDebugUtils.currentLine=57409536;
 //BA.debugLineNum = 57409536;BA.debugLine="Private Sub lbl_new_line_Click";
RDebugUtils.currentLine=57409539;
 //BA.debugLineNum = 57409539;BA.debugLine="ls_set_shift.AddSingleLine(et_num_roz.Text&\" \"&sp";
mostCurrent._ls_set_shift.AddSingleLine(BA.ObjectToCharSequence(mostCurrent._et_num_roz.getText()+" "+mostCurrent._sp_noe_shift.getSelectedItem()));
RDebugUtils.currentLine=57409540;
 //BA.debugLineNum = 57409540;BA.debugLine="For i=1 To et_num_roz.Text";
{
final int step2 = 1;
final int limit2 = (int)(Double.parseDouble(mostCurrent._et_num_roz.getText()));
_i = (int) (1) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=57409542;
 //BA.debugLineNum = 57409542;BA.debugLine="Select sp_noe_shift.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_noe_shift.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6))) {
case 0: {
RDebugUtils.currentLine=57409545;
 //BA.debugLineNum = 57409545;BA.debugLine="list_sift_olgo.Add(\"ر\")";
mostCurrent._list_sift_olgo.Add((Object)("ر"));
 break; }
case 1: {
RDebugUtils.currentLine=57409547;
 //BA.debugLineNum = 57409547;BA.debugLine="list_sift_olgo.Add(\"ع\")";
mostCurrent._list_sift_olgo.Add((Object)("ع"));
 break; }
case 2: {
RDebugUtils.currentLine=57409549;
 //BA.debugLineNum = 57409549;BA.debugLine="list_sift_olgo.Add(\"ش\")";
mostCurrent._list_sift_olgo.Add((Object)("ش"));
 break; }
case 3: {
RDebugUtils.currentLine=57409551;
 //BA.debugLineNum = 57409551;BA.debugLine="list_sift_olgo.Add(\"ا\")";
mostCurrent._list_sift_olgo.Add((Object)("ا"));
 break; }
case 4: {
RDebugUtils.currentLine=57409553;
 //BA.debugLineNum = 57409553;BA.debugLine="list_sift_olgo.Add(\"ص/ع\")";
mostCurrent._list_sift_olgo.Add((Object)("ص/ع"));
 break; }
case 5: {
RDebugUtils.currentLine=57409555;
 //BA.debugLineNum = 57409555;BA.debugLine="list_sift_olgo.Add(\"ع/ش\")";
mostCurrent._list_sift_olgo.Add((Object)("ع/ش"));
 break; }
case 6: {
RDebugUtils.currentLine=57409557;
 //BA.debugLineNum = 57409557;BA.debugLine="list_sift_olgo.Add(\"ص/ش\")";
mostCurrent._list_sift_olgo.Add((Object)("ص/ش"));
 break; }
}
;
 }
};
RDebugUtils.currentLine=57409565;
 //BA.debugLineNum = 57409565;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_next_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_next_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_next_click", null));}
int _adad = 0;
RDebugUtils.currentLine=57212928;
 //BA.debugLineNum = 57212928;BA.debugLine="Private Sub lbl_next_Click";
RDebugUtils.currentLine=57212930;
 //BA.debugLineNum = 57212930;BA.debugLine="If (current_moon>=12)Then";
if ((_current_moon>=12)) { 
RDebugUtils.currentLine=57212932;
 //BA.debugLineNum = 57212932;BA.debugLine="If(lbl_year_tagvim.Text<1404)Then";
if (((double)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()))<1404)) { 
RDebugUtils.currentLine=57212933;
 //BA.debugLineNum = 57212933;BA.debugLine="Dim adad As Int=lbl_year_tagvim.Text";
_adad = (int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()));
RDebugUtils.currentLine=57212934;
 //BA.debugLineNum = 57212934;BA.debugLine="lbl_year_tagvim.Text=adad+1";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_adad+1));
RDebugUtils.currentLine=57212935;
 //BA.debugLineNum = 57212935;BA.debugLine="current_moon=1";
_current_moon = (int) (1);
 }else {
RDebugUtils.currentLine=57212937;
 //BA.debugLineNum = 57212937;BA.debugLine="current_moon=12";
_current_moon = (int) (12);
 };
 }else {
RDebugUtils.currentLine=57212943;
 //BA.debugLineNum = 57212943;BA.debugLine="current_moon=current_moon+1";
_current_moon = (int) (_current_moon+1);
 };
RDebugUtils.currentLine=57212945;
 //BA.debugLineNum = 57212945;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_current_moon);
RDebugUtils.currentLine=57212947;
 //BA.debugLineNum = 57212947;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_note_day_menu_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_note_day_menu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_note_day_menu_click", null));}
RDebugUtils.currentLine=58589184;
 //BA.debugLineNum = 58589184;BA.debugLine="Private Sub lbl_note_day_menu_Click";
RDebugUtils.currentLine=58589185;
 //BA.debugLineNum = 58589185;BA.debugLine="lbl_edit_note_Click";
_lbl_edit_note_click();
RDebugUtils.currentLine=58589186;
 //BA.debugLineNum = 58589186;BA.debugLine="pan_all_menu_day_Click";
_pan_all_menu_day_click();
RDebugUtils.currentLine=58589187;
 //BA.debugLineNum = 58589187;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_prev_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_prev_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_prev_click", null));}
int _adad = 0;
RDebugUtils.currentLine=57278464;
 //BA.debugLineNum = 57278464;BA.debugLine="Private Sub lbl_prev_Click";
RDebugUtils.currentLine=57278466;
 //BA.debugLineNum = 57278466;BA.debugLine="If (current_moon<=1)Then";
if ((_current_moon<=1)) { 
RDebugUtils.currentLine=57278469;
 //BA.debugLineNum = 57278469;BA.debugLine="If(lbl_year_tagvim.Text>1398)Then";
if (((double)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()))>1398)) { 
RDebugUtils.currentLine=57278470;
 //BA.debugLineNum = 57278470;BA.debugLine="Dim adad As Int=lbl_year_tagvim.Text";
_adad = (int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()));
RDebugUtils.currentLine=57278471;
 //BA.debugLineNum = 57278471;BA.debugLine="lbl_year_tagvim.Text=adad-1";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_adad-1));
RDebugUtils.currentLine=57278472;
 //BA.debugLineNum = 57278472;BA.debugLine="current_moon=12";
_current_moon = (int) (12);
 }else {
RDebugUtils.currentLine=57278474;
 //BA.debugLineNum = 57278474;BA.debugLine="current_moon=1";
_current_moon = (int) (1);
 };
 }else {
RDebugUtils.currentLine=57278479;
 //BA.debugLineNum = 57278479;BA.debugLine="current_moon=current_moon-1";
_current_moon = (int) (_current_moon-1);
 };
RDebugUtils.currentLine=57278481;
 //BA.debugLineNum = 57278481;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_current_moon);
RDebugUtils.currentLine=57278483;
 //BA.debugLineNum = 57278483;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_roz_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_roz_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_roz_click", null));}
RDebugUtils.currentLine=56033280;
 //BA.debugLineNum = 56033280;BA.debugLine="Private Sub lbl_roz_Click";
RDebugUtils.currentLine=56033281;
 //BA.debugLineNum = 56033281;BA.debugLine="rsPOP_roz.Show";
mostCurrent._rspop_roz.Show();
RDebugUtils.currentLine=56033282;
 //BA.debugLineNum = 56033282;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_roz_end_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_roz_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_roz_end_click", null));}
RDebugUtils.currentLine=56426496;
 //BA.debugLineNum = 56426496;BA.debugLine="Private Sub lbl_roz_end_Click";
RDebugUtils.currentLine=56426497;
 //BA.debugLineNum = 56426497;BA.debugLine="rsPOP_roz_end.Show";
mostCurrent._rspop_roz_end.Show();
RDebugUtils.currentLine=56426498;
 //BA.debugLineNum = 56426498;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_note_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_note_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_note_click", null));}
RDebugUtils.currentLine=58327040;
 //BA.debugLineNum = 58327040;BA.debugLine="Private Sub lbl_save_note_Click";
RDebugUtils.currentLine=58327042;
 //BA.debugLineNum = 58327042;BA.debugLine="set_note(selectedDay_id,et_note.Text)";
_set_note(_selectedday_id,mostCurrent._et_note.getText());
RDebugUtils.currentLine=58327043;
 //BA.debugLineNum = 58327043;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,lbl_moon_nam";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())));
RDebugUtils.currentLine=58327044;
 //BA.debugLineNum = 58327044;BA.debugLine="pan_all_note.Visible=False";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=58327045;
 //BA.debugLineNum = 58327045;BA.debugLine="End Sub";
return "";
}
public static String  _set_note(int _id,String _matn) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "set_note", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "set_note", new Object[] {_id,_matn}));}
RDebugUtils.currentLine=58392576;
 //BA.debugLineNum = 58392576;BA.debugLine="Sub set_note(id As Int , matn As String)";
RDebugUtils.currentLine=58392577;
 //BA.debugLineNum = 58392577;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=58392578;
 //BA.debugLineNum = 58392578;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' set";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set note='"+_matn+"' WHERE id="+BA.NumberToString(_id));
RDebugUtils.currentLine=58392580;
 //BA.debugLineNum = 58392580;BA.debugLine="ToastMessageShow(\"یادداشت ذخیره شد\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("یادداشت ذخیره شد"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=58392581;
 //BA.debugLineNum = 58392581;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_shift_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_shift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_shift_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_tosave = null;
int _p = 0;
RDebugUtils.currentLine=57475072;
 //BA.debugLineNum = 57475072;BA.debugLine="Private Sub lbl_save_shift_Click";
RDebugUtils.currentLine=57475075;
 //BA.debugLineNum = 57475075;BA.debugLine="If(ls_set_shift.Size<1)Then";
if ((mostCurrent._ls_set_shift.getSize()<1)) { 
RDebugUtils.currentLine=57475076;
 //BA.debugLineNum = 57475076;BA.debugLine="ToastMessageShow(\"الگو باید حداقل یک مورد باشد\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("الگو باید حداقل یک مورد باشد"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=57475081;
 //BA.debugLineNum = 57475081;BA.debugLine="set_shift(list_sift_olgo)";
_set_shift(mostCurrent._list_sift_olgo);
RDebugUtils.currentLine=57475084;
 //BA.debugLineNum = 57475084;BA.debugLine="Dim ls_toSave As List";
_ls_tosave = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=57475085;
 //BA.debugLineNum = 57475085;BA.debugLine="ls_toSave.Initialize";
_ls_tosave.Initialize();
RDebugUtils.currentLine=57475087;
 //BA.debugLineNum = 57475087;BA.debugLine="For p=0 To ls_set_shift.Size-1";
{
final int step7 = 1;
final int limit7 = (int) (mostCurrent._ls_set_shift.getSize()-1);
_p = (int) (0) ;
for (;_p <= limit7 ;_p = _p + step7 ) {
RDebugUtils.currentLine=57475088;
 //BA.debugLineNum = 57475088;BA.debugLine="ls_toSave.Add(ls_set_shift.GetItem(p))";
_ls_tosave.Add(mostCurrent._ls_set_shift.GetItem(_p));
 }
};
RDebugUtils.currentLine=57475091;
 //BA.debugLineNum = 57475091;BA.debugLine="File.WriteList(File.DirInternal,\"shift_olgo\",ls_";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo",_ls_tosave);
RDebugUtils.currentLine=57475092;
 //BA.debugLineNum = 57475092;BA.debugLine="File.WriteList(File.DirInternal,\"shift_olgo_cod\"";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo_cod",mostCurrent._list_sift_olgo);
RDebugUtils.currentLine=57475095;
 //BA.debugLineNum = 57475095;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=57475099;
 //BA.debugLineNum = 57475099;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
RDebugUtils.currentLine=57475100;
 //BA.debugLineNum = 57475100;BA.debugLine="generat_taghvim(this_year,this_moon)";
_generat_taghvim(_this_year,_this_moon);
 };
RDebugUtils.currentLine=57475105;
 //BA.debugLineNum = 57475105;BA.debugLine="End Sub";
return "";
}
public static String  _set_shift(anywheresoftware.b4a.objects.collections.List _ol) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "set_shift", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "set_shift", new Object[] {_ol}));}
int _start_shift = 0;
int _end_shift = 0;
int _index_curent_shift = 0;
int _i = 0;
RDebugUtils.currentLine=57606144;
 //BA.debugLineNum = 57606144;BA.debugLine="Sub set_shift(ol As List )";
RDebugUtils.currentLine=57606146;
 //BA.debugLineNum = 57606146;BA.debugLine="Try";
try {RDebugUtils.currentLine=57606147;
 //BA.debugLineNum = 57606147;BA.debugLine="ProgressDialogShow(\"در حال تنظیم شیفت ها\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("در حال تنظیم شیفت ها"));
RDebugUtils.currentLine=57606149;
 //BA.debugLineNum = 57606149;BA.debugLine="Dim start_shift As Int";
_start_shift = 0;
RDebugUtils.currentLine=57606150;
 //BA.debugLineNum = 57606150;BA.debugLine="Dim end_shift As Int";
_end_shift = 0;
RDebugUtils.currentLine=57606152;
 //BA.debugLineNum = 57606152;BA.debugLine="Dim index_curent_shift As Int=0";
_index_curent_shift = (int) (0);
RDebugUtils.currentLine=57606153;
 //BA.debugLineNum = 57606153;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=57606155;
 //BA.debugLineNum = 57606155;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' se";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set shift=''");
RDebugUtils.currentLine=57606158;
 //BA.debugLineNum = 57606158;BA.debugLine="start_shift=dbCode.get_day_id(lbl_years.Text,lbl";
_start_shift = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_years.getText())),_lbl_mah_tagid,(int)(Double.parseDouble(mostCurrent._lbl_roz.getText())));
RDebugUtils.currentLine=57606159;
 //BA.debugLineNum = 57606159;BA.debugLine="end_shift=dbCode.get_day_id(lbl_years_end.Text,l";
_end_shift = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_years_end.getText())),_lbl_mah_end_tagid,(int)(Double.parseDouble(mostCurrent._lbl_roz_end.getText())));
RDebugUtils.currentLine=57606162;
 //BA.debugLineNum = 57606162;BA.debugLine="For i=start_shift To end_shift";
{
final int step10 = 1;
final int limit10 = _end_shift;
_i = _start_shift ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=57606164;
 //BA.debugLineNum = 57606164;BA.debugLine="dbCode.sql.ExecNonQuery2(\"UPDATE 'my_calander'";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE 'my_calander' set shift=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{mostCurrent._list_sift_olgo.Get(_index_curent_shift),(Object)(_i)}));
RDebugUtils.currentLine=57606167;
 //BA.debugLineNum = 57606167;BA.debugLine="If(index_curent_shift=list_sift_olgo.Size-1)The";
if ((_index_curent_shift==mostCurrent._list_sift_olgo.getSize()-1)) { 
RDebugUtils.currentLine=57606168;
 //BA.debugLineNum = 57606168;BA.debugLine="index_curent_shift=0";
_index_curent_shift = (int) (0);
 }else {
RDebugUtils.currentLine=57606170;
 //BA.debugLineNum = 57606170;BA.debugLine="index_curent_shift=index_curent_shift+1";
_index_curent_shift = (int) (_index_curent_shift+1);
 };
 }
};
RDebugUtils.currentLine=57606175;
 //BA.debugLineNum = 57606175;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=57606176;
 //BA.debugLineNum = 57606176;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 } 
       catch (Exception e21) {
			processBA.setLastException(e21);RDebugUtils.currentLine=57606179;
 //BA.debugLineNum = 57606179;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("357606179",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=57606180;
 //BA.debugLineNum = 57606180;BA.debugLine="ToastMessageShow(\"خطا در تاریخ\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در تاریخ"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=57606186;
 //BA.debugLineNum = 57606186;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_show_panshift_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_show_panshift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_show_panshift_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_toload = null;
int _i = 0;
RDebugUtils.currentLine=57540608;
 //BA.debugLineNum = 57540608;BA.debugLine="Private Sub lbl_show_panShift_Click";
RDebugUtils.currentLine=57540610;
 //BA.debugLineNum = 57540610;BA.debugLine="If(File.Exists(File.DirInternal,\"shift_olgo\")=Tru";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=57540612;
 //BA.debugLineNum = 57540612;BA.debugLine="Dim ls_toLoad As List";
_ls_toload = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=57540613;
 //BA.debugLineNum = 57540613;BA.debugLine="ls_toLoad.Initialize";
_ls_toload.Initialize();
RDebugUtils.currentLine=57540615;
 //BA.debugLineNum = 57540615;BA.debugLine="ls_toLoad=File.ReadList(File.DirInternal,\"shift_";
_ls_toload = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo");
RDebugUtils.currentLine=57540617;
 //BA.debugLineNum = 57540617;BA.debugLine="For i=0 To ls_toLoad.Size-1";
{
final int step5 = 1;
final int limit5 = (int) (_ls_toload.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=57540618;
 //BA.debugLineNum = 57540618;BA.debugLine="ls_set_shift.AddSingleLine(ls_toLoad.Get(i))";
mostCurrent._ls_set_shift.AddSingleLine(BA.ObjectToCharSequence(_ls_toload.Get(_i)));
 }
};
RDebugUtils.currentLine=57540621;
 //BA.debugLineNum = 57540621;BA.debugLine="list_sift_olgo=File.ReadList(File.DirInternal,\"s";
mostCurrent._list_sift_olgo = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo_cod");
 };
RDebugUtils.currentLine=57540625;
 //BA.debugLineNum = 57540625;BA.debugLine="pan_all_setSift.Visible=True";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=57540627;
 //BA.debugLineNum = 57540627;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_year_tagvim_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_year_tagvim_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_year_tagvim_click", null));}
RDebugUtils.currentLine=55508992;
 //BA.debugLineNum = 55508992;BA.debugLine="Private Sub lbl_year_tagvim_Click";
RDebugUtils.currentLine=55508993;
 //BA.debugLineNum = 55508993;BA.debugLine="rsPOP_year_tagvim.Show";
mostCurrent._rspop_year_tagvim.Show();
RDebugUtils.currentLine=55508994;
 //BA.debugLineNum = 55508994;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_years_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_years_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_years_click", null));}
RDebugUtils.currentLine=55902208;
 //BA.debugLineNum = 55902208;BA.debugLine="Private Sub lbl_years_Click";
RDebugUtils.currentLine=55902209;
 //BA.debugLineNum = 55902209;BA.debugLine="rsPOP_year.Show";
mostCurrent._rspop_year.Show();
RDebugUtils.currentLine=55902210;
 //BA.debugLineNum = 55902210;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_years_end_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_years_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_years_end_click", null));}
RDebugUtils.currentLine=56295424;
 //BA.debugLineNum = 56295424;BA.debugLine="Private Sub lbl_years_end_Click";
RDebugUtils.currentLine=56295425;
 //BA.debugLineNum = 56295425;BA.debugLine="rsPOP_year_end.Show";
mostCurrent._rspop_year_end.Show();
RDebugUtils.currentLine=56295426;
 //BA.debugLineNum = 56295426;BA.debugLine="End Sub";
return "";
}
public static String  _mod_tatil_garardadi(int _id) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mod_tatil_garardadi", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "mod_tatil_garardadi", new Object[] {_id}));}
RDebugUtils.currentLine=58130432;
 //BA.debugLineNum = 58130432;BA.debugLine="Sub mod_tatil_garardadi (id As Int)";
RDebugUtils.currentLine=58130433;
 //BA.debugLineNum = 58130433;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=58130434;
 //BA.debugLineNum = 58130434;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=58130435;
 //BA.debugLineNum = 58130435;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=58130438;
 //BA.debugLineNum = 58130438;BA.debugLine="If(dbCode.res.GetString(\"state\")=\"tatil\") Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=58130441;
 //BA.debugLineNum = 58130441;BA.debugLine="CheckBox_tatil_garardadi.Checked=False";
mostCurrent._checkbox_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=58130442;
 //BA.debugLineNum = 58130442;BA.debugLine="CheckBox_tatil_rasmi.Checked=True";
mostCurrent._checkbox_tatil_rasmi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=58130444;
 //BA.debugLineNum = 58130444;BA.debugLine="Else If(dbCode.res.GetString(\"state\")=\"tatil1\") T";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil1"))) { 
RDebugUtils.currentLine=58130447;
 //BA.debugLineNum = 58130447;BA.debugLine="CheckBox_tatil_garardadi.Checked=True";
mostCurrent._checkbox_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=58130448;
 //BA.debugLineNum = 58130448;BA.debugLine="CheckBox_tatil_rasmi.Checked=False";
mostCurrent._checkbox_tatil_rasmi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=58130452;
 //BA.debugLineNum = 58130452;BA.debugLine="CheckBox_tatil_garardadi.Checked=False";
mostCurrent._checkbox_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=58130453;
 //BA.debugLineNum = 58130453;BA.debugLine="CheckBox_tatil_rasmi.Checked=False";
mostCurrent._checkbox_tatil_rasmi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }}
;
RDebugUtils.currentLine=58130458;
 //BA.debugLineNum = 58130458;BA.debugLine="End Sub";
return "";
}
public static String  _pa_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pa_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pa_click", null));}
String _str_t = "";
anywheresoftware.b4a.objects.PanelWrapper _b = null;
int _d = 0;
int _moon_tag = 0;
RDebugUtils.currentLine=57147392;
 //BA.debugLineNum = 57147392;BA.debugLine="Private Sub PA_Click";
RDebugUtils.currentLine=57147393;
 //BA.debugLineNum = 57147393;BA.debugLine="Dim str_t As String";
_str_t = "";
RDebugUtils.currentLine=57147394;
 //BA.debugLineNum = 57147394;BA.debugLine="Dim B As Panel = Sender";
_b = new anywheresoftware.b4a.objects.PanelWrapper();
_b = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=57147395;
 //BA.debugLineNum = 57147395;BA.debugLine="selectedDay_id=dbCode.get_day_id(lbl_year_tagvim.";
_selectedday_id = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())),(int)(BA.ObjectToNumber(_b.getTag())));
RDebugUtils.currentLine=57147397;
 //BA.debugLineNum = 57147397;BA.debugLine="For d=0 To PA.Length-1";
{
final int step4 = 1;
final int limit4 = (int) (mostCurrent._pa.length-1);
_d = (int) (0) ;
for (;_d <= limit4 ;_d = _d + step4 ) {
RDebugUtils.currentLine=57147398;
 //BA.debugLineNum = 57147398;BA.debugLine="str_t=PA(d).Tag";
_str_t = BA.ObjectToString(mostCurrent._pa[_d].getTag());
RDebugUtils.currentLine=57147399;
 //BA.debugLineNum = 57147399;BA.debugLine="If ( str_t = last_selected_itemTag )Then";
if (((_str_t).equals(BA.NumberToString(_last_selected_itemtag)))) { 
RDebugUtils.currentLine=57147403;
 //BA.debugLineNum = 57147403;BA.debugLine="If(last_selected_itemTag<>0)Then";
if ((_last_selected_itemtag!=0)) { 
RDebugUtils.currentLine=57147405;
 //BA.debugLineNum = 57147405;BA.debugLine="If(ls_tatili_moon.Get(last_selected_itemTag-1)";
if (((mostCurrent._ls_tatili_moon.Get((int) (_last_selected_itemtag-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=57147406;
 //BA.debugLineNum = 57147406;BA.debugLine="PA(d).Color=0xFFFF5252";
mostCurrent._pa[_d].setColor(((int)0xffff5252));
 }else 
{RDebugUtils.currentLine=57147408;
 //BA.debugLineNum = 57147408;BA.debugLine="Else If(ls_tatili_custom_moon.Get(last_selecte";
if (((mostCurrent._ls_tatili_custom_moon.Get((int) (_last_selected_itemtag-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=57147409;
 //BA.debugLineNum = 57147409;BA.debugLine="PA(d).Color=0xFF00BB8B";
mostCurrent._pa[_d].setColor(((int)0xff00bb8b));
 }else {
RDebugUtils.currentLine=57147412;
 //BA.debugLineNum = 57147412;BA.debugLine="PA(d).Color=0xFFEFEFEF";
mostCurrent._pa[_d].setColor(((int)0xffefefef));
 }}
;
 };
 };
 }
};
RDebugUtils.currentLine=57147425;
 //BA.debugLineNum = 57147425;BA.debugLine="Dim moon_tag As Int=lbl_moon_name.Tag";
_moon_tag = (int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag()));
RDebugUtils.currentLine=57147426;
 //BA.debugLineNum = 57147426;BA.debugLine="If( moon_tag=this_moon)Then";
if ((_moon_tag==_this_moon)) { 
RDebugUtils.currentLine=57147428;
 //BA.debugLineNum = 57147428;BA.debugLine="Lb(index_i_today).TextColor=0xFFFF9000";
mostCurrent._lb[_index_i_today].setTextColor(((int)0xffff9000));
 };
RDebugUtils.currentLine=57147433;
 //BA.debugLineNum = 57147433;BA.debugLine="B.Color=Colors.Gray";
_b.setColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=57147434;
 //BA.debugLineNum = 57147434;BA.debugLine="get_monasebat(selectedDay_id)";
_get_monasebat(_selectedday_id);
RDebugUtils.currentLine=57147435;
 //BA.debugLineNum = 57147435;BA.debugLine="get_note(selectedDay_id)";
_get_note(_selectedday_id);
RDebugUtils.currentLine=57147437;
 //BA.debugLineNum = 57147437;BA.debugLine="get_ezafekari(lbl_year_tagvim.Text&\"/\"&myfunc.con";
_get_ezafekari(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))));
RDebugUtils.currentLine=57147438;
 //BA.debugLineNum = 57147438;BA.debugLine="get_morakhasi(lbl_year_tagvim.Text&\"/\"&myfunc.con";
_get_morakhasi(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))));
RDebugUtils.currentLine=57147439;
 //BA.debugLineNum = 57147439;BA.debugLine="get_taradod(lbl_year_tagvim.Text&\"/\"&myfunc.conve";
_get_taradod(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))));
RDebugUtils.currentLine=57147441;
 //BA.debugLineNum = 57147441;BA.debugLine="last_selected_itemTag=B.Tag";
_last_selected_itemtag = (int)(BA.ObjectToNumber(_b.getTag()));
RDebugUtils.currentLine=57147444;
 //BA.debugLineNum = 57147444;BA.debugLine="End Sub";
return "";
}
public static String  _pa_longclick() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pa_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pa_longclick", null));}
anywheresoftware.b4a.objects.PanelWrapper _b = null;
RDebugUtils.currentLine=58064896;
 //BA.debugLineNum = 58064896;BA.debugLine="Private Sub PA_LongClick";
RDebugUtils.currentLine=58064897;
 //BA.debugLineNum = 58064897;BA.debugLine="Dim B As Panel = Sender";
_b = new anywheresoftware.b4a.objects.PanelWrapper();
_b = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=58064900;
 //BA.debugLineNum = 58064900;BA.debugLine="selectedDay_id=dbCode.get_day_id(lbl_year_tagvim.";
_selectedday_id = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())),(int)(BA.ObjectToNumber(_b.getTag())));
RDebugUtils.currentLine=58064907;
 //BA.debugLineNum = 58064907;BA.debugLine="lbl_title_day_menu.Text=lbl_year_tagvim.Text&\"/\"&";
mostCurrent._lbl_title_day_menu.setText(BA.ObjectToCharSequence(mostCurrent._lbl_year_tagvim.getText()+"/"+BA.ObjectToString(mostCurrent._lbl_moon_name.getTag())+"/"+BA.ObjectToString(_b.getTag())));
RDebugUtils.currentLine=58064908;
 //BA.debugLineNum = 58064908;BA.debugLine="mod_tatil_garardadi(selectedDay_id)";
_mod_tatil_garardadi(_selectedday_id);
RDebugUtils.currentLine=58064909;
 //BA.debugLineNum = 58064909;BA.debugLine="pan_all_menu_day.Visible=True";
mostCurrent._pan_all_menu_day.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=58064910;
 //BA.debugLineNum = 58064910;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_note_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_note_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_note_click", null));}
RDebugUtils.currentLine=58195968;
 //BA.debugLineNum = 58195968;BA.debugLine="Private Sub pan_all_note_Click";
RDebugUtils.currentLine=58195969;
 //BA.debugLineNum = 58195969;BA.debugLine="pan_all_note.Visible=False";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=58195970;
 //BA.debugLineNum = 58195970;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_setsift_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_setsift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_setsift_click", null));}
RDebugUtils.currentLine=57344000;
 //BA.debugLineNum = 57344000;BA.debugLine="Private Sub pan_all_setSift_Click";
RDebugUtils.currentLine=57344002;
 //BA.debugLineNum = 57344002;BA.debugLine="End Sub";
return "";
}
public static String  _panel12_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel12_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel12_click", null));}
RDebugUtils.currentLine=58261504;
 //BA.debugLineNum = 58261504;BA.debugLine="Private Sub Panel12_Click";
RDebugUtils.currentLine=58261506;
 //BA.debugLineNum = 58261506;BA.debugLine="End Sub";
return "";
}
public static String  _panel8_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel8_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel8_click", null));}
RDebugUtils.currentLine=58523648;
 //BA.debugLineNum = 58523648;BA.debugLine="Private Sub Panel8_Click";
RDebugUtils.currentLine=58523650;
 //BA.debugLineNum = 58523650;BA.debugLine="End Sub";
return "";
}
public static boolean  _rspop_mah_end_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_mah_end_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_mah_end_menuitemclick", new Object[] {_itemid}));}
String _mmah = "";
RDebugUtils.currentLine=56164352;
 //BA.debugLineNum = 56164352;BA.debugLine="Sub rsPOP_mah_end_MenuItemClick (ItemId As Int) As";
RDebugUtils.currentLine=56164353;
 //BA.debugLineNum = 56164353;BA.debugLine="Dim mmah As String";
_mmah = "";
RDebugUtils.currentLine=56164354;
 //BA.debugLineNum = 56164354;BA.debugLine="Select ItemId";
switch (_itemid) {
case 1: {
RDebugUtils.currentLine=56164356;
 //BA.debugLineNum = 56164356;BA.debugLine="mmah=\"فروردین\"";
_mmah = "فروردین";
 break; }
case 2: {
RDebugUtils.currentLine=56164358;
 //BA.debugLineNum = 56164358;BA.debugLine="mmah=\"اردیبهشت\"";
_mmah = "اردیبهشت";
 break; }
case 3: {
RDebugUtils.currentLine=56164360;
 //BA.debugLineNum = 56164360;BA.debugLine="mmah=\"خرداد\"";
_mmah = "خرداد";
 break; }
case 4: {
RDebugUtils.currentLine=56164362;
 //BA.debugLineNum = 56164362;BA.debugLine="mmah=\"تیر\"";
_mmah = "تیر";
 break; }
case 5: {
RDebugUtils.currentLine=56164364;
 //BA.debugLineNum = 56164364;BA.debugLine="mmah=\"مرداد\"";
_mmah = "مرداد";
 break; }
case 6: {
RDebugUtils.currentLine=56164366;
 //BA.debugLineNum = 56164366;BA.debugLine="mmah=\"شهریور\"";
_mmah = "شهریور";
 break; }
case 7: {
RDebugUtils.currentLine=56164368;
 //BA.debugLineNum = 56164368;BA.debugLine="mmah=\"مهر\"";
_mmah = "مهر";
 break; }
case 8: {
RDebugUtils.currentLine=56164370;
 //BA.debugLineNum = 56164370;BA.debugLine="mmah=\"آبان\"";
_mmah = "آبان";
 break; }
case 9: {
RDebugUtils.currentLine=56164372;
 //BA.debugLineNum = 56164372;BA.debugLine="mmah=\"آذر\"";
_mmah = "آذر";
 break; }
case 10: {
RDebugUtils.currentLine=56164374;
 //BA.debugLineNum = 56164374;BA.debugLine="mmah=\"دی\"";
_mmah = "دی";
 break; }
case 11: {
RDebugUtils.currentLine=56164376;
 //BA.debugLineNum = 56164376;BA.debugLine="mmah=\"بهمن\"";
_mmah = "بهمن";
 break; }
case 12: {
RDebugUtils.currentLine=56164378;
 //BA.debugLineNum = 56164378;BA.debugLine="mmah=\"اسفند\"";
_mmah = "اسفند";
 break; }
}
;
RDebugUtils.currentLine=56164384;
 //BA.debugLineNum = 56164384;BA.debugLine="lbl_mah_end.Text=mmah";
mostCurrent._lbl_mah_end.setText(BA.ObjectToCharSequence(_mmah));
RDebugUtils.currentLine=56164385;
 //BA.debugLineNum = 56164385;BA.debugLine="lbl_mah_end_tagID=ItemId";
_lbl_mah_end_tagid = _itemid;
RDebugUtils.currentLine=56164387;
 //BA.debugLineNum = 56164387;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=56164388;
 //BA.debugLineNum = 56164388;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_mah_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_mah_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_mah_menuitemclick", new Object[] {_itemid}));}
String _mmah = "";
RDebugUtils.currentLine=55771136;
 //BA.debugLineNum = 55771136;BA.debugLine="Sub rsPOP_mah_MenuItemClick (ItemId As Int) As Boo";
RDebugUtils.currentLine=55771137;
 //BA.debugLineNum = 55771137;BA.debugLine="Dim mmah As String";
_mmah = "";
RDebugUtils.currentLine=55771138;
 //BA.debugLineNum = 55771138;BA.debugLine="Select ItemId";
switch (_itemid) {
case 1: {
RDebugUtils.currentLine=55771140;
 //BA.debugLineNum = 55771140;BA.debugLine="mmah=\"فروردین\"";
_mmah = "فروردین";
 break; }
case 2: {
RDebugUtils.currentLine=55771142;
 //BA.debugLineNum = 55771142;BA.debugLine="mmah=\"اردیبهشت\"";
_mmah = "اردیبهشت";
 break; }
case 3: {
RDebugUtils.currentLine=55771144;
 //BA.debugLineNum = 55771144;BA.debugLine="mmah=\"خرداد\"";
_mmah = "خرداد";
 break; }
case 4: {
RDebugUtils.currentLine=55771146;
 //BA.debugLineNum = 55771146;BA.debugLine="mmah=\"تیر\"";
_mmah = "تیر";
 break; }
case 5: {
RDebugUtils.currentLine=55771148;
 //BA.debugLineNum = 55771148;BA.debugLine="mmah=\"مرداد\"";
_mmah = "مرداد";
 break; }
case 6: {
RDebugUtils.currentLine=55771150;
 //BA.debugLineNum = 55771150;BA.debugLine="mmah=\"شهریور\"";
_mmah = "شهریور";
 break; }
case 7: {
RDebugUtils.currentLine=55771152;
 //BA.debugLineNum = 55771152;BA.debugLine="mmah=\"مهر\"";
_mmah = "مهر";
 break; }
case 8: {
RDebugUtils.currentLine=55771154;
 //BA.debugLineNum = 55771154;BA.debugLine="mmah=\"آبان\"";
_mmah = "آبان";
 break; }
case 9: {
RDebugUtils.currentLine=55771156;
 //BA.debugLineNum = 55771156;BA.debugLine="mmah=\"آذر\"";
_mmah = "آذر";
 break; }
case 10: {
RDebugUtils.currentLine=55771158;
 //BA.debugLineNum = 55771158;BA.debugLine="mmah=\"دی\"";
_mmah = "دی";
 break; }
case 11: {
RDebugUtils.currentLine=55771160;
 //BA.debugLineNum = 55771160;BA.debugLine="mmah=\"بهمن\"";
_mmah = "بهمن";
 break; }
case 12: {
RDebugUtils.currentLine=55771162;
 //BA.debugLineNum = 55771162;BA.debugLine="mmah=\"اسفند\"";
_mmah = "اسفند";
 break; }
}
;
RDebugUtils.currentLine=55771166;
 //BA.debugLineNum = 55771166;BA.debugLine="lbl_mah.Text=mmah";
mostCurrent._lbl_mah.setText(BA.ObjectToCharSequence(_mmah));
RDebugUtils.currentLine=55771167;
 //BA.debugLineNum = 55771167;BA.debugLine="lbl_mah_tagID=ItemId";
_lbl_mah_tagid = _itemid;
RDebugUtils.currentLine=55771169;
 //BA.debugLineNum = 55771169;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=55771170;
 //BA.debugLineNum = 55771170;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_moon_tagvim_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_moon_tagvim_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_moon_tagvim_menuitemclick", new Object[] {_itemid}));}
String _mmah = "";
RDebugUtils.currentLine=55640064;
 //BA.debugLineNum = 55640064;BA.debugLine="Sub rsPOP_moon_tagvim_MenuItemClick (ItemId As Int";
RDebugUtils.currentLine=55640065;
 //BA.debugLineNum = 55640065;BA.debugLine="Dim mmah As String";
_mmah = "";
RDebugUtils.currentLine=55640066;
 //BA.debugLineNum = 55640066;BA.debugLine="Select ItemId";
switch (_itemid) {
case 1: {
RDebugUtils.currentLine=55640068;
 //BA.debugLineNum = 55640068;BA.debugLine="mmah=\"فروردین\"";
_mmah = "فروردین";
 break; }
case 2: {
RDebugUtils.currentLine=55640070;
 //BA.debugLineNum = 55640070;BA.debugLine="mmah=\"اردیبهشت\"";
_mmah = "اردیبهشت";
 break; }
case 3: {
RDebugUtils.currentLine=55640072;
 //BA.debugLineNum = 55640072;BA.debugLine="mmah=\"خرداد\"";
_mmah = "خرداد";
 break; }
case 4: {
RDebugUtils.currentLine=55640074;
 //BA.debugLineNum = 55640074;BA.debugLine="mmah=\"تیر\"";
_mmah = "تیر";
 break; }
case 5: {
RDebugUtils.currentLine=55640076;
 //BA.debugLineNum = 55640076;BA.debugLine="mmah=\"مرداد\"";
_mmah = "مرداد";
 break; }
case 6: {
RDebugUtils.currentLine=55640078;
 //BA.debugLineNum = 55640078;BA.debugLine="mmah=\"شهریور\"";
_mmah = "شهریور";
 break; }
case 7: {
RDebugUtils.currentLine=55640080;
 //BA.debugLineNum = 55640080;BA.debugLine="mmah=\"مهر\"";
_mmah = "مهر";
 break; }
case 8: {
RDebugUtils.currentLine=55640082;
 //BA.debugLineNum = 55640082;BA.debugLine="mmah=\"آبان\"";
_mmah = "آبان";
 break; }
case 9: {
RDebugUtils.currentLine=55640084;
 //BA.debugLineNum = 55640084;BA.debugLine="mmah=\"آذر\"";
_mmah = "آذر";
 break; }
case 10: {
RDebugUtils.currentLine=55640086;
 //BA.debugLineNum = 55640086;BA.debugLine="mmah=\"دی\"";
_mmah = "دی";
 break; }
case 11: {
RDebugUtils.currentLine=55640088;
 //BA.debugLineNum = 55640088;BA.debugLine="mmah=\"بهمن\"";
_mmah = "بهمن";
 break; }
case 12: {
RDebugUtils.currentLine=55640090;
 //BA.debugLineNum = 55640090;BA.debugLine="mmah=\"اسفند\"";
_mmah = "اسفند";
 break; }
}
;
RDebugUtils.currentLine=55640094;
 //BA.debugLineNum = 55640094;BA.debugLine="lbl_moon_name.Text=mmah";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence(_mmah));
RDebugUtils.currentLine=55640096;
 //BA.debugLineNum = 55640096;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,ItemId)";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_itemid);
RDebugUtils.currentLine=55640097;
 //BA.debugLineNum = 55640097;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=55640098;
 //BA.debugLineNum = 55640098;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_roz_end_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_roz_end_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_roz_end_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=56229888;
 //BA.debugLineNum = 56229888;BA.debugLine="Sub rsPOP_roz_end_MenuItemClick (ItemId As Int) As";
RDebugUtils.currentLine=56229890;
 //BA.debugLineNum = 56229890;BA.debugLine="lbl_roz_end.Text=ItemId";
mostCurrent._lbl_roz_end.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=56229891;
 //BA.debugLineNum = 56229891;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=56229892;
 //BA.debugLineNum = 56229892;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_roz_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_roz_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_roz_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=55836672;
 //BA.debugLineNum = 55836672;BA.debugLine="Sub rsPOP_roz_MenuItemClick (ItemId As Int) As Boo";
RDebugUtils.currentLine=55836674;
 //BA.debugLineNum = 55836674;BA.debugLine="lbl_roz.Text=ItemId";
mostCurrent._lbl_roz.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=55836675;
 //BA.debugLineNum = 55836675;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=55836676;
 //BA.debugLineNum = 55836676;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_year_end_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_year_end_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_year_end_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=56098816;
 //BA.debugLineNum = 56098816;BA.debugLine="Sub rsPOP_year_end_MenuItemClick (ItemId As Int) A";
RDebugUtils.currentLine=56098817;
 //BA.debugLineNum = 56098817;BA.debugLine="lbl_years_end.Text=ItemId";
mostCurrent._lbl_years_end.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=56098818;
 //BA.debugLineNum = 56098818;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=56098819;
 //BA.debugLineNum = 56098819;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_year_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_year_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_year_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=55705600;
 //BA.debugLineNum = 55705600;BA.debugLine="Sub rsPOP_year_MenuItemClick (ItemId As Int) As Bo";
RDebugUtils.currentLine=55705601;
 //BA.debugLineNum = 55705601;BA.debugLine="lbl_years.Text=ItemId";
mostCurrent._lbl_years.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=55705602;
 //BA.debugLineNum = 55705602;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=55705603;
 //BA.debugLineNum = 55705603;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_year_tagvim_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_year_tagvim_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_year_tagvim_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=55443456;
 //BA.debugLineNum = 55443456;BA.debugLine="Sub rsPOP_year_tagvim_MenuItemClick (ItemId As Int";
RDebugUtils.currentLine=55443457;
 //BA.debugLineNum = 55443457;BA.debugLine="lbl_year_tagvim.Text=ItemId";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=55443458;
 //BA.debugLineNum = 55443458;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_current_moon);
RDebugUtils.currentLine=55443459;
 //BA.debugLineNum = 55443459;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=55443460;
 //BA.debugLineNum = 55443460;BA.debugLine="End Sub";
return false;
}
public static String  _sql_nonquerycomplete(boolean _success) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sql_nonquerycomplete", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sql_nonquerycomplete", new Object[] {_success}));}
RDebugUtils.currentLine=57671680;
 //BA.debugLineNum = 57671680;BA.debugLine="Sub sql_NonQueryComplete (Success As Boolean)";
RDebugUtils.currentLine=57671682;
 //BA.debugLineNum = 57671682;BA.debugLine="End Sub";
return "";
}
}