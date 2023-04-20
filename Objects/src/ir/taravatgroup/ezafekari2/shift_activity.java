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
RDebugUtils.currentLine=39583744;
 //BA.debugLineNum = 39583744;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=39583747;
 //BA.debugLineNum = 39583747;BA.debugLine="Activity.LoadLayout(\"shift_layout\")";
mostCurrent._activity.LoadLayout("shift_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=39583749;
 //BA.debugLineNum = 39583749;BA.debugLine="scrol_v.Panel.LoadLayout(\"shift_page_items\")";
mostCurrent._scrol_v.getPanel().LoadLayout("shift_page_items",mostCurrent.activityBA);
RDebugUtils.currentLine=39583751;
 //BA.debugLineNum = 39583751;BA.debugLine="pan_hed_shift.Color=Main.color4";
mostCurrent._pan_hed_shift.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=39583752;
 //BA.debugLineNum = 39583752;BA.debugLine="lbl_hed_set_shift.Color=Main.color4";
mostCurrent._lbl_hed_set_shift.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=39583755;
 //BA.debugLineNum = 39583755;BA.debugLine="lbl0.Initialize(\"lbl0\")";
mostCurrent._lbl0.Initialize(mostCurrent.activityBA,"lbl0");
RDebugUtils.currentLine=39583756;
 //BA.debugLineNum = 39583756;BA.debugLine="lbl0.Tag=0";
mostCurrent._lbl0.setTag((Object)(0));
RDebugUtils.currentLine=39583757;
 //BA.debugLineNum = 39583757;BA.debugLine="p0.Initialize(\"p0\")";
mostCurrent._p0.Initialize(mostCurrent.activityBA,"p0");
RDebugUtils.currentLine=39583758;
 //BA.debugLineNum = 39583758;BA.debugLine="p0.Tag=0";
mostCurrent._p0.setTag((Object)(0));
RDebugUtils.currentLine=39583759;
 //BA.debugLineNum = 39583759;BA.debugLine="sh0.Initialize(\"sh0\")";
mostCurrent._sh0.Initialize(mostCurrent.activityBA,"sh0");
RDebugUtils.currentLine=39583760;
 //BA.debugLineNum = 39583760;BA.debugLine="sh0.Tag=0";
mostCurrent._sh0.setTag((Object)(0));
RDebugUtils.currentLine=39583761;
 //BA.debugLineNum = 39583761;BA.debugLine="ez0.Initialize(\"ez0\")";
mostCurrent._ez0.Initialize(mostCurrent.activityBA,"ez0");
RDebugUtils.currentLine=39583762;
 //BA.debugLineNum = 39583762;BA.debugLine="ez0.Tag=0";
mostCurrent._ez0.setTag((Object)(0));
RDebugUtils.currentLine=39583763;
 //BA.debugLineNum = 39583763;BA.debugLine="no0.Initialize(\"no0\")";
mostCurrent._no0.Initialize(mostCurrent.activityBA,"no0");
RDebugUtils.currentLine=39583764;
 //BA.debugLineNum = 39583764;BA.debugLine="no0.Tag=0";
mostCurrent._no0.setTag((Object)(0));
RDebugUtils.currentLine=39583766;
 //BA.debugLineNum = 39583766;BA.debugLine="ls_shift_moon.Initialize";
mostCurrent._ls_shift_moon.Initialize();
RDebugUtils.currentLine=39583767;
 //BA.debugLineNum = 39583767;BA.debugLine="ls_tatili_moon.Initialize";
mostCurrent._ls_tatili_moon.Initialize();
RDebugUtils.currentLine=39583768;
 //BA.debugLineNum = 39583768;BA.debugLine="ls_tatili_custom_moon.Initialize";
mostCurrent._ls_tatili_custom_moon.Initialize();
RDebugUtils.currentLine=39583769;
 //BA.debugLineNum = 39583769;BA.debugLine="ls_note_moon.Initialize";
mostCurrent._ls_note_moon.Initialize();
RDebugUtils.currentLine=39583772;
 //BA.debugLineNum = 39583772;BA.debugLine="list_sift_olgo.Initialize";
mostCurrent._list_sift_olgo.Initialize();
RDebugUtils.currentLine=39583773;
 //BA.debugLineNum = 39583773;BA.debugLine="ls_set_shift.SingleLineLayout.Label.TextColor=Col";
mostCurrent._ls_set_shift.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=39583775;
 //BA.debugLineNum = 39583775;BA.debugLine="ls_set_shift.SingleLineLayout.Label.Width=ls_set_";
mostCurrent._ls_set_shift.getSingleLineLayout().Label.setWidth((int) (mostCurrent._ls_set_shift.getWidth()-30));
RDebugUtils.currentLine=39583776;
 //BA.debugLineNum = 39583776;BA.debugLine="ls_set_shift.SingleLineLayout.Label.Typeface=Type";
mostCurrent._ls_set_shift.getSingleLineLayout().Label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(mostCurrent._myfunc._font_filename /*String*/ (mostCurrent.activityBA)));
RDebugUtils.currentLine=39583779;
 //BA.debugLineNum = 39583779;BA.debugLine="Lb = Array As Label(lbl0,lb1,lb2,lb3,lb4,lb5,lb6,";
mostCurrent._lb = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._lbl0,mostCurrent._lb1,mostCurrent._lb2,mostCurrent._lb3,mostCurrent._lb4,mostCurrent._lb5,mostCurrent._lb6,mostCurrent._lb7,mostCurrent._lb8,mostCurrent._lb9,mostCurrent._lb10,mostCurrent._lb11,mostCurrent._lb12,mostCurrent._lb13,mostCurrent._lb14,mostCurrent._lb15,mostCurrent._lb16,mostCurrent._lb17,mostCurrent._lb18,mostCurrent._lb19,mostCurrent._lb20,mostCurrent._lb21,mostCurrent._lb22,mostCurrent._lb23,mostCurrent._lb24,mostCurrent._lb25,mostCurrent._lb26,mostCurrent._lb27,mostCurrent._lb28,mostCurrent._lb29,mostCurrent._lb30,mostCurrent._lb31,mostCurrent._lb32,mostCurrent._lb33,mostCurrent._lb34,mostCurrent._lb35,mostCurrent._lb36,mostCurrent._lb37,mostCurrent._lb38,mostCurrent._lb39,mostCurrent._lb40,mostCurrent._lb41,mostCurrent._lb42};
RDebugUtils.currentLine=39583781;
 //BA.debugLineNum = 39583781;BA.debugLine="PA = Array As Panel(p0,p1,p2,p3,p4,p5,p6,p7,p8,p9";
mostCurrent._pa = new anywheresoftware.b4a.objects.PanelWrapper[]{mostCurrent._p0,mostCurrent._p1,mostCurrent._p2,mostCurrent._p3,mostCurrent._p4,mostCurrent._p5,mostCurrent._p6,mostCurrent._p7,mostCurrent._p8,mostCurrent._p9,mostCurrent._p10,mostCurrent._p11,mostCurrent._p12,mostCurrent._p13,mostCurrent._p14,mostCurrent._p15,mostCurrent._p16,mostCurrent._p17,mostCurrent._p18,mostCurrent._p19,mostCurrent._p20,mostCurrent._p21,mostCurrent._p22,mostCurrent._p23,mostCurrent._p24,mostCurrent._p25,mostCurrent._p26,mostCurrent._p27,mostCurrent._p28,mostCurrent._p29,mostCurrent._p30,mostCurrent._p31,mostCurrent._p32,mostCurrent._p33,mostCurrent._p34,mostCurrent._p35,mostCurrent._p36,mostCurrent._p37,mostCurrent._p38,mostCurrent._p39,mostCurrent._p40,mostCurrent._p41,mostCurrent._p42};
RDebugUtils.currentLine=39583783;
 //BA.debugLineNum = 39583783;BA.debugLine="SH = Array As Label(sh0,sh1,sh2,sh3,sh4,sh5,sh6,s";
mostCurrent._sh = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._sh0,mostCurrent._sh1,mostCurrent._sh2,mostCurrent._sh3,mostCurrent._sh4,mostCurrent._sh5,mostCurrent._sh6,mostCurrent._sh7,mostCurrent._sh8,mostCurrent._sh9,mostCurrent._sh10,mostCurrent._sh11,mostCurrent._sh12,mostCurrent._sh13,mostCurrent._sh14,mostCurrent._sh15,mostCurrent._sh16,mostCurrent._sh17,mostCurrent._sh18,mostCurrent._sh19,mostCurrent._sh20,mostCurrent._sh21,mostCurrent._sh22,mostCurrent._sh23,mostCurrent._sh24,mostCurrent._sh25,mostCurrent._sh26,mostCurrent._sh27,mostCurrent._sh28,mostCurrent._sh29,mostCurrent._sh30,mostCurrent._sh31,mostCurrent._sh32,mostCurrent._sh33,mostCurrent._sh34,mostCurrent._sh35,mostCurrent._sh36,mostCurrent._sh37,mostCurrent._sh38,mostCurrent._sh39,mostCurrent._sh40,mostCurrent._sh41,mostCurrent._sh42};
RDebugUtils.currentLine=39583785;
 //BA.debugLineNum = 39583785;BA.debugLine="EZ = Array As Label (ez0,ez1,ez2,ez3,ez4,ez5,ez6,";
mostCurrent._ez = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._ez0,mostCurrent._ez1,mostCurrent._ez2,mostCurrent._ez3,mostCurrent._ez4,mostCurrent._ez5,mostCurrent._ez6,mostCurrent._ez7,mostCurrent._ez8,mostCurrent._ez9,mostCurrent._ez10,mostCurrent._ez11,mostCurrent._ez12,mostCurrent._ez13,mostCurrent._ez14,mostCurrent._ez15,mostCurrent._ez16,mostCurrent._ez17,mostCurrent._ez18,mostCurrent._ez19,mostCurrent._ez20,mostCurrent._ez21,mostCurrent._ez22,mostCurrent._ez23,mostCurrent._ez24,mostCurrent._ez25,mostCurrent._ez26,mostCurrent._ez27,mostCurrent._ez28,mostCurrent._ez29,mostCurrent._ez30,mostCurrent._ez31,mostCurrent._ez32,mostCurrent._ez33,mostCurrent._ez34,mostCurrent._ez35,mostCurrent._ez36,mostCurrent._ez37,mostCurrent._ez38,mostCurrent._ez39,mostCurrent._ez40,mostCurrent._ez41,mostCurrent._ez42};
RDebugUtils.currentLine=39583788;
 //BA.debugLineNum = 39583788;BA.debugLine="NO = Array As Label (no0,no1,no2,no3,no4,no5,no6,";
mostCurrent._no = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._no0,mostCurrent._no1,mostCurrent._no2,mostCurrent._no3,mostCurrent._no4,mostCurrent._no5,mostCurrent._no6,mostCurrent._no7,mostCurrent._no8,mostCurrent._no9,mostCurrent._no10,mostCurrent._no11,mostCurrent._no12,mostCurrent._no13,mostCurrent._no14,mostCurrent._no15,mostCurrent._no16,mostCurrent._no17,mostCurrent._no18,mostCurrent._no19,mostCurrent._no20,mostCurrent._no21,mostCurrent._no22,mostCurrent._no23,mostCurrent._no24,mostCurrent._no25,mostCurrent._no26,mostCurrent._no27,mostCurrent._no28,mostCurrent._no29,mostCurrent._no30,mostCurrent._no31,mostCurrent._no32,mostCurrent._no33,mostCurrent._no34,mostCurrent._no35,mostCurrent._no36,mostCurrent._no37,mostCurrent._no38,mostCurrent._no39,mostCurrent._no40,mostCurrent._no41,mostCurrent._no42};
RDebugUtils.currentLine=39583795;
 //BA.debugLineNum = 39583795;BA.debugLine="sp_noe_shift.AddAll(Array As String(\"روزکار(ر)\",\"";
mostCurrent._sp_noe_shift.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"روزکار(ر)","عصرکار(ع)","شبکار(ش)","استراحت(ا)"}));
RDebugUtils.currentLine=39583799;
 //BA.debugLineNum = 39583799;BA.debugLine="this_year=date.PersianYear";
_this_year = mostCurrent._date.getPersianYear();
RDebugUtils.currentLine=39583800;
 //BA.debugLineNum = 39583800;BA.debugLine="this_moon =date.PersianMonth";
_this_moon = mostCurrent._date.getPersianMonth();
RDebugUtils.currentLine=39583801;
 //BA.debugLineNum = 39583801;BA.debugLine="this_day =date.PersianDay";
_this_day = mostCurrent._date.getPersianDay();
RDebugUtils.currentLine=39583804;
 //BA.debugLineNum = 39583804;BA.debugLine="current_moon=date.PersianMonth";
_current_moon = mostCurrent._date.getPersianMonth();
RDebugUtils.currentLine=39583806;
 //BA.debugLineNum = 39583806;BA.debugLine="lbl_year_tagvim.Text=this_year";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_this_year));
RDebugUtils.currentLine=39583817;
 //BA.debugLineNum = 39583817;BA.debugLine="rsPOP_year_tagvim.Initialize(\"rsPOP_year_tagvim\",";
mostCurrent._rspop_year_tagvim.Initialize(mostCurrent.activityBA,"rsPOP_year_tagvim",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_year_tagvim.getObject())));
RDebugUtils.currentLine=39583819;
 //BA.debugLineNum = 39583819;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1398,1398,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1398),(int) (1398),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1398"));
RDebugUtils.currentLine=39583820;
 //BA.debugLineNum = 39583820;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1399,1399,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1399),(int) (1399),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1399"));
RDebugUtils.currentLine=39583821;
 //BA.debugLineNum = 39583821;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1400,1400,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1400),(int) (1400),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1400"));
RDebugUtils.currentLine=39583822;
 //BA.debugLineNum = 39583822;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1401,1401,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1401),(int) (1401),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1401"));
RDebugUtils.currentLine=39583823;
 //BA.debugLineNum = 39583823;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1402,1402,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1402),(int) (1402),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1402"));
RDebugUtils.currentLine=39583824;
 //BA.debugLineNum = 39583824;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1403,1403,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1403),(int) (1403),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1403"));
RDebugUtils.currentLine=39583826;
 //BA.debugLineNum = 39583826;BA.debugLine="rsPOP_moon_tagvim.Initialize(\"rsPOP_moon_tagvim\",";
mostCurrent._rspop_moon_tagvim.Initialize(mostCurrent.activityBA,"rsPOP_moon_tagvim",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_moon_name.getObject())));
RDebugUtils.currentLine=39583829;
 //BA.debugLineNum = 39583829;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(1,1,\"فروردین\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (1),(int) (1),"فروردین");
RDebugUtils.currentLine=39583830;
 //BA.debugLineNum = 39583830;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(2,2,\"اردیبهشت\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (2),(int) (2),"اردیبهشت");
RDebugUtils.currentLine=39583831;
 //BA.debugLineNum = 39583831;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(3,3,\"خرداد\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (3),(int) (3),"خرداد");
RDebugUtils.currentLine=39583832;
 //BA.debugLineNum = 39583832;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(4,4,\"تیر\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (4),(int) (4),"تیر");
RDebugUtils.currentLine=39583833;
 //BA.debugLineNum = 39583833;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(5,5,\"مرداد\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (5),(int) (5),"مرداد");
RDebugUtils.currentLine=39583834;
 //BA.debugLineNum = 39583834;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(6,6,\"شهریور\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (6),(int) (6),"شهریور");
RDebugUtils.currentLine=39583835;
 //BA.debugLineNum = 39583835;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(7,7,\"مهر\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (7),(int) (7),"مهر");
RDebugUtils.currentLine=39583836;
 //BA.debugLineNum = 39583836;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(8,8,\"آبان\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (8),(int) (8),"آبان");
RDebugUtils.currentLine=39583837;
 //BA.debugLineNum = 39583837;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(9,9,\"آذر\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (9),(int) (9),"آذر");
RDebugUtils.currentLine=39583838;
 //BA.debugLineNum = 39583838;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(10,10,\"دی\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (10),(int) (10),"دی");
RDebugUtils.currentLine=39583839;
 //BA.debugLineNum = 39583839;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(11,11,\"بهمن\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (11),(int) (11),"بهمن");
RDebugUtils.currentLine=39583840;
 //BA.debugLineNum = 39583840;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(12,12,\"اسفند\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (12),(int) (12),"اسفند");
RDebugUtils.currentLine=39583848;
 //BA.debugLineNum = 39583848;BA.debugLine="rsPOP_year.Initialize(\"rsPOP_year\",lbl_years)";
mostCurrent._rspop_year.Initialize(mostCurrent.activityBA,"rsPOP_year",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_years.getObject())));
RDebugUtils.currentLine=39583850;
 //BA.debugLineNum = 39583850;BA.debugLine="rsPOP_year.AddMenuItem(1398,1398,myfunc.en2fa(\"13";
mostCurrent._rspop_year.AddMenuItem((int) (1398),(int) (1398),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1398"));
RDebugUtils.currentLine=39583851;
 //BA.debugLineNum = 39583851;BA.debugLine="rsPOP_year.AddMenuItem(1399,1399,myfunc.en2fa(\"13";
mostCurrent._rspop_year.AddMenuItem((int) (1399),(int) (1399),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1399"));
RDebugUtils.currentLine=39583852;
 //BA.debugLineNum = 39583852;BA.debugLine="rsPOP_year.AddMenuItem(1400,1400,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1400),(int) (1400),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1400"));
RDebugUtils.currentLine=39583853;
 //BA.debugLineNum = 39583853;BA.debugLine="rsPOP_year.AddMenuItem(1401,1401,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1401),(int) (1401),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1401"));
RDebugUtils.currentLine=39583854;
 //BA.debugLineNum = 39583854;BA.debugLine="rsPOP_year.AddMenuItem(1402,1402,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1402),(int) (1402),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1402"));
RDebugUtils.currentLine=39583855;
 //BA.debugLineNum = 39583855;BA.debugLine="rsPOP_year.AddMenuItem(1403,1403,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1403),(int) (1403),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1403"));
RDebugUtils.currentLine=39583857;
 //BA.debugLineNum = 39583857;BA.debugLine="rsPOP_mah.Initialize(\"rsPOP_mah\",lbl_mah)";
mostCurrent._rspop_mah.Initialize(mostCurrent.activityBA,"rsPOP_mah",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_mah.getObject())));
RDebugUtils.currentLine=39583859;
 //BA.debugLineNum = 39583859;BA.debugLine="lbl_mah_tagID=1";
_lbl_mah_tagid = (int) (1);
RDebugUtils.currentLine=39583861;
 //BA.debugLineNum = 39583861;BA.debugLine="rsPOP_mah.AddMenuItem(1,1,\"فروردین\")";
mostCurrent._rspop_mah.AddMenuItem((int) (1),(int) (1),"فروردین");
RDebugUtils.currentLine=39583862;
 //BA.debugLineNum = 39583862;BA.debugLine="rsPOP_mah.AddMenuItem(2,2,\"اردیبهشت\")";
mostCurrent._rspop_mah.AddMenuItem((int) (2),(int) (2),"اردیبهشت");
RDebugUtils.currentLine=39583863;
 //BA.debugLineNum = 39583863;BA.debugLine="rsPOP_mah.AddMenuItem(3,3,\"خرداد\")";
mostCurrent._rspop_mah.AddMenuItem((int) (3),(int) (3),"خرداد");
RDebugUtils.currentLine=39583864;
 //BA.debugLineNum = 39583864;BA.debugLine="rsPOP_mah.AddMenuItem(4,4,\"تیر\")";
mostCurrent._rspop_mah.AddMenuItem((int) (4),(int) (4),"تیر");
RDebugUtils.currentLine=39583865;
 //BA.debugLineNum = 39583865;BA.debugLine="rsPOP_mah.AddMenuItem(5,5,\"مرداد\")";
mostCurrent._rspop_mah.AddMenuItem((int) (5),(int) (5),"مرداد");
RDebugUtils.currentLine=39583866;
 //BA.debugLineNum = 39583866;BA.debugLine="rsPOP_mah.AddMenuItem(6,6,\"شهریور\")";
mostCurrent._rspop_mah.AddMenuItem((int) (6),(int) (6),"شهریور");
RDebugUtils.currentLine=39583867;
 //BA.debugLineNum = 39583867;BA.debugLine="rsPOP_mah.AddMenuItem(7,7,\"مهر\")";
mostCurrent._rspop_mah.AddMenuItem((int) (7),(int) (7),"مهر");
RDebugUtils.currentLine=39583868;
 //BA.debugLineNum = 39583868;BA.debugLine="rsPOP_mah.AddMenuItem(8,8,\"آبان\")";
mostCurrent._rspop_mah.AddMenuItem((int) (8),(int) (8),"آبان");
RDebugUtils.currentLine=39583869;
 //BA.debugLineNum = 39583869;BA.debugLine="rsPOP_mah.AddMenuItem(9,9,\"آذر\")";
mostCurrent._rspop_mah.AddMenuItem((int) (9),(int) (9),"آذر");
RDebugUtils.currentLine=39583870;
 //BA.debugLineNum = 39583870;BA.debugLine="rsPOP_mah.AddMenuItem(10,10,\"دی\")";
mostCurrent._rspop_mah.AddMenuItem((int) (10),(int) (10),"دی");
RDebugUtils.currentLine=39583871;
 //BA.debugLineNum = 39583871;BA.debugLine="rsPOP_mah.AddMenuItem(11,11,\"بهمن\")";
mostCurrent._rspop_mah.AddMenuItem((int) (11),(int) (11),"بهمن");
RDebugUtils.currentLine=39583872;
 //BA.debugLineNum = 39583872;BA.debugLine="rsPOP_mah.AddMenuItem(12,12,\"اسفند\")";
mostCurrent._rspop_mah.AddMenuItem((int) (12),(int) (12),"اسفند");
RDebugUtils.currentLine=39583875;
 //BA.debugLineNum = 39583875;BA.debugLine="rsPOP_roz.Initialize(\"rsPOP_roz\",lbl_roz)";
mostCurrent._rspop_roz.Initialize(mostCurrent.activityBA,"rsPOP_roz",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_roz.getObject())));
RDebugUtils.currentLine=39583878;
 //BA.debugLineNum = 39583878;BA.debugLine="For i=1 To 31";
{
final int step76 = 1;
final int limit76 = (int) (31);
_i = (int) (1) ;
for (;_i <= limit76 ;_i = _i + step76 ) {
RDebugUtils.currentLine=39583880;
 //BA.debugLineNum = 39583880;BA.debugLine="rsPOP_roz.AddMenuItem(i,i,myfunc.en2fa(i))";
mostCurrent._rspop_roz.AddMenuItem(_i,_i,mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_i)));
 }
};
RDebugUtils.currentLine=39583884;
 //BA.debugLineNum = 39583884;BA.debugLine="rsPOP_year_end.Initialize(\"rsPOP_year_end\",lbl_ye";
mostCurrent._rspop_year_end.Initialize(mostCurrent.activityBA,"rsPOP_year_end",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_years_end.getObject())));
RDebugUtils.currentLine=39583886;
 //BA.debugLineNum = 39583886;BA.debugLine="rsPOP_year_end.AddMenuItem(1398,1398,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1398),(int) (1398),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1398"));
RDebugUtils.currentLine=39583887;
 //BA.debugLineNum = 39583887;BA.debugLine="rsPOP_year_end.AddMenuItem(1399,1399,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1399),(int) (1399),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1399"));
RDebugUtils.currentLine=39583888;
 //BA.debugLineNum = 39583888;BA.debugLine="rsPOP_year_end.AddMenuItem(1400,1400,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1400),(int) (1400),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1400"));
RDebugUtils.currentLine=39583889;
 //BA.debugLineNum = 39583889;BA.debugLine="rsPOP_year_end.AddMenuItem(1401,1401,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1401),(int) (1401),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1401"));
RDebugUtils.currentLine=39583890;
 //BA.debugLineNum = 39583890;BA.debugLine="rsPOP_year_end.AddMenuItem(1402,1402,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1402),(int) (1402),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1402"));
RDebugUtils.currentLine=39583891;
 //BA.debugLineNum = 39583891;BA.debugLine="rsPOP_year_end.AddMenuItem(1403,1403,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1403),(int) (1403),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1403"));
RDebugUtils.currentLine=39583894;
 //BA.debugLineNum = 39583894;BA.debugLine="rsPOP_mah_end.Initialize(\"rsPOP_mah_end\",lbl_mah_";
mostCurrent._rspop_mah_end.Initialize(mostCurrent.activityBA,"rsPOP_mah_end",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_mah_end.getObject())));
RDebugUtils.currentLine=39583896;
 //BA.debugLineNum = 39583896;BA.debugLine="lbl_mah_end_tagID=12";
_lbl_mah_end_tagid = (int) (12);
RDebugUtils.currentLine=39583898;
 //BA.debugLineNum = 39583898;BA.debugLine="rsPOP_mah_end.AddMenuItem(1,1,\"فروردین\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (1),(int) (1),"فروردین");
RDebugUtils.currentLine=39583899;
 //BA.debugLineNum = 39583899;BA.debugLine="rsPOP_mah_end.AddMenuItem(2,2,\"اردیبهشت\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (2),(int) (2),"اردیبهشت");
RDebugUtils.currentLine=39583900;
 //BA.debugLineNum = 39583900;BA.debugLine="rsPOP_mah_end.AddMenuItem(3,3,\"خرداد\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (3),(int) (3),"خرداد");
RDebugUtils.currentLine=39583901;
 //BA.debugLineNum = 39583901;BA.debugLine="rsPOP_mah_end.AddMenuItem(4,4,\"تیر\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (4),(int) (4),"تیر");
RDebugUtils.currentLine=39583902;
 //BA.debugLineNum = 39583902;BA.debugLine="rsPOP_mah_end.AddMenuItem(5,5,\"مرداد\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (5),(int) (5),"مرداد");
RDebugUtils.currentLine=39583903;
 //BA.debugLineNum = 39583903;BA.debugLine="rsPOP_mah_end.AddMenuItem(6,6,\"شهریور\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (6),(int) (6),"شهریور");
RDebugUtils.currentLine=39583904;
 //BA.debugLineNum = 39583904;BA.debugLine="rsPOP_mah_end.AddMenuItem(7,7,\"مهر\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (7),(int) (7),"مهر");
RDebugUtils.currentLine=39583905;
 //BA.debugLineNum = 39583905;BA.debugLine="rsPOP_mah_end.AddMenuItem(8,8,\"آبان\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (8),(int) (8),"آبان");
RDebugUtils.currentLine=39583906;
 //BA.debugLineNum = 39583906;BA.debugLine="rsPOP_mah_end.AddMenuItem(9,9,\"آذر\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (9),(int) (9),"آذر");
RDebugUtils.currentLine=39583907;
 //BA.debugLineNum = 39583907;BA.debugLine="rsPOP_mah_end.AddMenuItem(10,10,\"دی\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (10),(int) (10),"دی");
RDebugUtils.currentLine=39583908;
 //BA.debugLineNum = 39583908;BA.debugLine="rsPOP_mah_end.AddMenuItem(11,11,\"بهمن\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (11),(int) (11),"بهمن");
RDebugUtils.currentLine=39583909;
 //BA.debugLineNum = 39583909;BA.debugLine="rsPOP_mah_end.AddMenuItem(12,12,\"اسفند\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (12),(int) (12),"اسفند");
RDebugUtils.currentLine=39583911;
 //BA.debugLineNum = 39583911;BA.debugLine="rsPOP_roz_end.Initialize(\"rsPOP_roz_end\",lbl_roz_";
mostCurrent._rspop_roz_end.Initialize(mostCurrent.activityBA,"rsPOP_roz_end",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_roz_end.getObject())));
RDebugUtils.currentLine=39583912;
 //BA.debugLineNum = 39583912;BA.debugLine="For i=1 To 31";
{
final int step101 = 1;
final int limit101 = (int) (31);
_i = (int) (1) ;
for (;_i <= limit101 ;_i = _i + step101 ) {
RDebugUtils.currentLine=39583913;
 //BA.debugLineNum = 39583913;BA.debugLine="rsPOP_roz_end.AddMenuItem(i,i,myfunc.en2fa(i))";
mostCurrent._rspop_roz_end.AddMenuItem(_i,_i,mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_i)));
 }
};
RDebugUtils.currentLine=39583919;
 //BA.debugLineNum = 39583919;BA.debugLine="lbl_go_today_Click";
_lbl_go_today_click();
RDebugUtils.currentLine=39583921;
 //BA.debugLineNum = 39583921;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=39583922;
 //BA.debugLineNum = 39583922;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=39583924;
 //BA.debugLineNum = 39583924;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_go_today_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_go_today_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_go_today_click", null));}
RDebugUtils.currentLine=39649280;
 //BA.debugLineNum = 39649280;BA.debugLine="Private Sub lbl_go_today_Click";
RDebugUtils.currentLine=39649282;
 //BA.debugLineNum = 39649282;BA.debugLine="selectedDay_id=dbCode.get_day_id(this_year,this_m";
_selectedday_id = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_this_year,_this_moon,_this_day);
RDebugUtils.currentLine=39649286;
 //BA.debugLineNum = 39649286;BA.debugLine="generat_taghvim(this_year,this_moon)";
_generat_taghvim(_this_year,_this_moon);
RDebugUtils.currentLine=39649288;
 //BA.debugLineNum = 39649288;BA.debugLine="get_monasebat( selectedDay_id )";
_get_monasebat(_selectedday_id);
RDebugUtils.currentLine=39649289;
 //BA.debugLineNum = 39649289;BA.debugLine="get_note(selectedDay_id)";
_get_note(_selectedday_id);
RDebugUtils.currentLine=39649291;
 //BA.debugLineNum = 39649291;BA.debugLine="get_ezafekari(this_year&\"/\"&myfunc.convert_adad(t";
_get_ezafekari(BA.NumberToString(_this_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_day));
RDebugUtils.currentLine=39649292;
 //BA.debugLineNum = 39649292;BA.debugLine="get_morakhasi(this_year&\"/\"&myfunc.convert_adad(t";
_get_morakhasi(BA.NumberToString(_this_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_day));
RDebugUtils.currentLine=39649293;
 //BA.debugLineNum = 39649293;BA.debugLine="get_taradod(this_year&\"/\"&myfunc.convert_adad(thi";
_get_taradod(BA.NumberToString(_this_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_day));
RDebugUtils.currentLine=39649299;
 //BA.debugLineNum = 39649299;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=40894464;
 //BA.debugLineNum = 40894464;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=40894465;
 //BA.debugLineNum = 40894465;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=40894466;
 //BA.debugLineNum = 40894466;BA.debugLine="If(pan_all_setSift.Visible=True)Then";
if ((mostCurrent._pan_all_setsift.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=40894467;
 //BA.debugLineNum = 40894467;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=40894468;
 //BA.debugLineNum = 40894468;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
 }else 
{RDebugUtils.currentLine=40894470;
 //BA.debugLineNum = 40894470;BA.debugLine="Else If (pan_all_note.Visible=True)Then";
if ((mostCurrent._pan_all_note.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=40894471;
 //BA.debugLineNum = 40894471;BA.debugLine="pan_all_note.Visible=False";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=40894473;
 //BA.debugLineNum = 40894473;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 }}
;
RDebugUtils.currentLine=40894476;
 //BA.debugLineNum = 40894476;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=40894478;
 //BA.debugLineNum = 40894478;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=40894480;
 //BA.debugLineNum = 40894480;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_delete_lis_olgo_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_delete_lis_olgo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_delete_lis_olgo_click", null));}
RDebugUtils.currentLine=42008576;
 //BA.debugLineNum = 42008576;BA.debugLine="Private Sub lbl_delete_lis_olgo_Click";
RDebugUtils.currentLine=42008577;
 //BA.debugLineNum = 42008577;BA.debugLine="ls_set_shift.Clear";
mostCurrent._ls_set_shift.Clear();
RDebugUtils.currentLine=42008578;
 //BA.debugLineNum = 42008578;BA.debugLine="list_sift_olgo.Clear";
mostCurrent._list_sift_olgo.Clear();
RDebugUtils.currentLine=42008579;
 //BA.debugLineNum = 42008579;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=40828928;
 //BA.debugLineNum = 40828928;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=40828930;
 //BA.debugLineNum = 40828930;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=40828931;
 //BA.debugLineNum = 40828931;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="shift_activity";
RDebugUtils.currentLine=40763392;
 //BA.debugLineNum = 40763392;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=40763394;
 //BA.debugLineNum = 40763394;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=40697856;
 //BA.debugLineNum = 40697856;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=40697858;
 //BA.debugLineNum = 40697858;BA.debugLine="End Sub";
return "";
}
public static String  _checkbox_tatil_garardadi_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "checkbox_tatil_garardadi_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "checkbox_tatil_garardadi_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=42926080;
 //BA.debugLineNum = 42926080;BA.debugLine="Private Sub CheckBox_tatil_garardadi_CheckedChange";
RDebugUtils.currentLine=42926081;
 //BA.debugLineNum = 42926081;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=42926082;
 //BA.debugLineNum = 42926082;BA.debugLine="If(Checked=True)Then";
if ((_checked==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=42926084;
 //BA.debugLineNum = 42926084;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' se";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set state='tatil1' WHERE id="+BA.NumberToString(_selectedday_id));
 }else {
RDebugUtils.currentLine=42926088;
 //BA.debugLineNum = 42926088;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' se";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set state='' WHERE id="+BA.NumberToString(_selectedday_id));
 };
RDebugUtils.currentLine=42926091;
 //BA.debugLineNum = 42926091;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,lbl_moon_nam";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())));
RDebugUtils.currentLine=42926093;
 //BA.debugLineNum = 42926093;BA.debugLine="pan_all_menu_day_Click";
_pan_all_menu_day_click();
RDebugUtils.currentLine=42926094;
 //BA.debugLineNum = 42926094;BA.debugLine="ToastMessageShow(\" ذخیره شد\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" ذخیره شد"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42926095;
 //BA.debugLineNum = 42926095;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=41287680;
 //BA.debugLineNum = 41287680;BA.debugLine="Sub generat_taghvim(year As Int , moon As Int)";
RDebugUtils.currentLine=41287681;
 //BA.debugLineNum = 41287681;BA.debugLine="Try";
try {RDebugUtils.currentLine=41287684;
 //BA.debugLineNum = 41287684;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=41287688;
 //BA.debugLineNum = 41287688;BA.debugLine="For d=0 To PA.Length-1";
{
final int step3 = 1;
final int limit3 = (int) (mostCurrent._pa.length-1);
_d = (int) (0) ;
for (;_d <= limit3 ;_d = _d + step3 ) {
RDebugUtils.currentLine=41287689;
 //BA.debugLineNum = 41287689;BA.debugLine="PA(d).Visible=True";
mostCurrent._pa[_d].setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=41287690;
 //BA.debugLineNum = 41287690;BA.debugLine="PA(d).Color=0xFFEFEFEF";
mostCurrent._pa[_d].setColor(((int)0xffefefef));
RDebugUtils.currentLine=41287693;
 //BA.debugLineNum = 41287693;BA.debugLine="EZ(d).Text=\"\"";
mostCurrent._ez[_d].setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=41287694;
 //BA.debugLineNum = 41287694;BA.debugLine="NO(d).Text=\"\"";
mostCurrent._no[_d].setText(BA.ObjectToCharSequence(""));
 }
};
RDebugUtils.currentLine=41287698;
 //BA.debugLineNum = 41287698;BA.debugLine="ls_shift_moon.Clear";
mostCurrent._ls_shift_moon.Clear();
RDebugUtils.currentLine=41287699;
 //BA.debugLineNum = 41287699;BA.debugLine="ls_tatili_moon.Clear";
mostCurrent._ls_tatili_moon.Clear();
RDebugUtils.currentLine=41287700;
 //BA.debugLineNum = 41287700;BA.debugLine="ls_tatili_custom_moon.Clear";
mostCurrent._ls_tatili_custom_moon.Clear();
RDebugUtils.currentLine=41287701;
 //BA.debugLineNum = 41287701;BA.debugLine="ls_note_moon.Clear";
mostCurrent._ls_note_moon.Clear();
RDebugUtils.currentLine=41287703;
 //BA.debugLineNum = 41287703;BA.debugLine="Dim count_day_moon As Int";
_count_day_moon = 0;
RDebugUtils.currentLine=41287705;
 //BA.debugLineNum = 41287705;BA.debugLine="current_moon=moon";
_current_moon = _moon;
RDebugUtils.currentLine=41287706;
 //BA.debugLineNum = 41287706;BA.debugLine="lbl_moon_name.Tag=moon";
mostCurrent._lbl_moon_name.setTag((Object)(_moon));
RDebugUtils.currentLine=41287707;
 //BA.debugLineNum = 41287707;BA.debugLine="lbl_year_tagvim.Text=year";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_year));
RDebugUtils.currentLine=41287709;
 //BA.debugLineNum = 41287709;BA.debugLine="Select moon";
switch (_moon) {
case 1: {
RDebugUtils.currentLine=41287711;
 //BA.debugLineNum = 41287711;BA.debugLine="lbl_moon_name.Text=\"فروردین\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("فروردین"));
 break; }
case 2: {
RDebugUtils.currentLine=41287713;
 //BA.debugLineNum = 41287713;BA.debugLine="lbl_moon_name.Text=\"اردیبهشت\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("اردیبهشت"));
 break; }
case 3: {
RDebugUtils.currentLine=41287715;
 //BA.debugLineNum = 41287715;BA.debugLine="lbl_moon_name.Text=\"خرداد\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("خرداد"));
 break; }
case 4: {
RDebugUtils.currentLine=41287717;
 //BA.debugLineNum = 41287717;BA.debugLine="lbl_moon_name.Text=\"تیر\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("تیر"));
 break; }
case 5: {
RDebugUtils.currentLine=41287719;
 //BA.debugLineNum = 41287719;BA.debugLine="lbl_moon_name.Text=\"مرداد\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("مرداد"));
 break; }
case 6: {
RDebugUtils.currentLine=41287721;
 //BA.debugLineNum = 41287721;BA.debugLine="lbl_moon_name.Text=\"شهریور\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("شهریور"));
 break; }
case 7: {
RDebugUtils.currentLine=41287723;
 //BA.debugLineNum = 41287723;BA.debugLine="lbl_moon_name.Text=\"مهر\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("مهر"));
 break; }
case 8: {
RDebugUtils.currentLine=41287725;
 //BA.debugLineNum = 41287725;BA.debugLine="lbl_moon_name.Text=\"آبان\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("آبان"));
 break; }
case 9: {
RDebugUtils.currentLine=41287727;
 //BA.debugLineNum = 41287727;BA.debugLine="lbl_moon_name.Text=\"آذر\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("آذر"));
 break; }
case 10: {
RDebugUtils.currentLine=41287729;
 //BA.debugLineNum = 41287729;BA.debugLine="lbl_moon_name.Text=\"دی\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("دی"));
 break; }
case 11: {
RDebugUtils.currentLine=41287731;
 //BA.debugLineNum = 41287731;BA.debugLine="lbl_moon_name.Text=\"بهمن\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("بهمن"));
 break; }
case 12: {
RDebugUtils.currentLine=41287733;
 //BA.debugLineNum = 41287733;BA.debugLine="lbl_moon_name.Text=\"اسفند\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("اسفند"));
 break; }
}
;
RDebugUtils.currentLine=41287739;
 //BA.debugLineNum = 41287739;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE year="+BA.NumberToString(_year)+" AND moon="+BA.NumberToString(_moon)+" ;")));
RDebugUtils.currentLine=41287743;
 //BA.debugLineNum = 41287743;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=41287745;
 //BA.debugLineNum = 41287745;BA.debugLine="count_day_moon=dbCode.res.RowCount";
_count_day_moon = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount();
RDebugUtils.currentLine=41287746;
 //BA.debugLineNum = 41287746;BA.debugLine="dbCode.res.Position =0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=41287747;
 //BA.debugLineNum = 41287747;BA.debugLine="start_day=dbCode.res.Getint(\"day_h\")";
_start_day = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_h");
RDebugUtils.currentLine=41287750;
 //BA.debugLineNum = 41287750;BA.debugLine="For i=0 To dbCode.res.RowCount-1";
{
final int step48 = 1;
final int limit48 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit48 ;_i = _i + step48 ) {
RDebugUtils.currentLine=41287751;
 //BA.debugLineNum = 41287751;BA.debugLine="dbCode.res.Position =i";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_i);
RDebugUtils.currentLine=41287753;
 //BA.debugLineNum = 41287753;BA.debugLine="If (dbCode.res.GetString(\"shift\") = Null)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")== null)) { 
RDebugUtils.currentLine=41287754;
 //BA.debugLineNum = 41287754;BA.debugLine="ls_shift_moon.Add(\"\")";
mostCurrent._ls_shift_moon.Add((Object)(""));
 }else {
RDebugUtils.currentLine=41287756;
 //BA.debugLineNum = 41287756;BA.debugLine="ls_shift_moon.Add(dbCode.res.GetString(\"shift";
mostCurrent._ls_shift_moon.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")));
 };
RDebugUtils.currentLine=41287760;
 //BA.debugLineNum = 41287760;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Th";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=41287761;
 //BA.debugLineNum = 41287761;BA.debugLine="ls_tatili_moon.Add(True)";
mostCurrent._ls_tatili_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.True));
 }else {
RDebugUtils.currentLine=41287763;
 //BA.debugLineNum = 41287763;BA.debugLine="ls_tatili_moon.Add(False)";
mostCurrent._ls_tatili_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.False));
 };
RDebugUtils.currentLine=41287767;
 //BA.debugLineNum = 41287767;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil1\")T";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil1"))) { 
RDebugUtils.currentLine=41287768;
 //BA.debugLineNum = 41287768;BA.debugLine="ls_tatili_custom_moon.Add(True)";
mostCurrent._ls_tatili_custom_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.True));
 }else {
RDebugUtils.currentLine=41287770;
 //BA.debugLineNum = 41287770;BA.debugLine="ls_tatili_custom_moon.Add(False)";
mostCurrent._ls_tatili_custom_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.False));
 };
RDebugUtils.currentLine=41287774;
 //BA.debugLineNum = 41287774;BA.debugLine="If (dbCode.res.GetString(\"note\") = \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")).equals(""))) { 
RDebugUtils.currentLine=41287775;
 //BA.debugLineNum = 41287775;BA.debugLine="ls_note_moon.Add(False)";
mostCurrent._ls_note_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.False));
 }else {
RDebugUtils.currentLine=41287777;
 //BA.debugLineNum = 41287777;BA.debugLine="ls_note_moon.Add(True)";
mostCurrent._ls_note_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.True));
 };
 }
};
 }else {
RDebugUtils.currentLine=41287786;
 //BA.debugLineNum = 41287786;BA.debugLine="Log(\"nooop data\")";
anywheresoftware.b4a.keywords.Common.LogImpl("241287786","nooop data",0);
 };
RDebugUtils.currentLine=41287791;
 //BA.debugLineNum = 41287791;BA.debugLine="For  j=start_day-1 To 0 Step -1";
{
final int step74 = -1;
final int limit74 = (int) (0);
_j = (int) (_start_day-1) ;
for (;_j >= limit74 ;_j = _j + step74 ) {
RDebugUtils.currentLine=41287792;
 //BA.debugLineNum = 41287792;BA.debugLine="PA(j).Visible=False";
mostCurrent._pa[_j].setVisible(anywheresoftware.b4a.keywords.Common.False);
 }
};
RDebugUtils.currentLine=41287797;
 //BA.debugLineNum = 41287797;BA.debugLine="Dim counter As Int=1";
_counter = (int) (1);
RDebugUtils.currentLine=41287799;
 //BA.debugLineNum = 41287799;BA.debugLine="For i = start_day To count_day_moon+start_day";
{
final int step78 = 1;
final int limit78 = (int) (_count_day_moon+_start_day);
_i = _start_day ;
for (;_i <= limit78 ;_i = _i + step78 ) {
RDebugUtils.currentLine=41287805;
 //BA.debugLineNum = 41287805;BA.debugLine="Lb(i).Text=counter";
mostCurrent._lb[_i].setText(BA.ObjectToCharSequence(_counter));
RDebugUtils.currentLine=41287806;
 //BA.debugLineNum = 41287806;BA.debugLine="PA(i).Tag=counter";
mostCurrent._pa[_i].setTag((Object)(_counter));
RDebugUtils.currentLine=41287811;
 //BA.debugLineNum = 41287811;BA.debugLine="If(counter-1 < count_day_moon)Then";
if ((_counter-1<_count_day_moon)) { 
RDebugUtils.currentLine=41287812;
 //BA.debugLineNum = 41287812;BA.debugLine="SH(i).Text=ls_shift_moon.Get(counter-1)  ''---s";
mostCurrent._sh[_i].setText(BA.ObjectToCharSequence(mostCurrent._ls_shift_moon.Get((int) (_counter-1))));
RDebugUtils.currentLine=41287813;
 //BA.debugLineNum = 41287813;BA.debugLine="If(SH(i).Text=\"ر\")Then";
if (((mostCurrent._sh[_i].getText()).equals("ر"))) { 
RDebugUtils.currentLine=41287814;
 //BA.debugLineNum = 41287814;BA.debugLine="SH(i).Color=0x96FFFA00";
mostCurrent._sh[_i].setColor(((int)0x96fffa00));
 }else 
{RDebugUtils.currentLine=41287815;
 //BA.debugLineNum = 41287815;BA.debugLine="Else If (SH(i).Text=\"ع\")Then";
if (((mostCurrent._sh[_i].getText()).equals("ع"))) { 
RDebugUtils.currentLine=41287816;
 //BA.debugLineNum = 41287816;BA.debugLine="SH(i).Color=0x960066FF";
mostCurrent._sh[_i].setColor(((int)0x960066ff));
 }else 
{RDebugUtils.currentLine=41287817;
 //BA.debugLineNum = 41287817;BA.debugLine="Else If (SH(i).Text=\"ش\")Then";
if (((mostCurrent._sh[_i].getText()).equals("ش"))) { 
RDebugUtils.currentLine=41287818;
 //BA.debugLineNum = 41287818;BA.debugLine="SH(i).Color=0x96414141";
mostCurrent._sh[_i].setColor(((int)0x96414141));
 }else 
{RDebugUtils.currentLine=41287819;
 //BA.debugLineNum = 41287819;BA.debugLine="Else If (SH(i).Text=\"ا\")Then";
if (((mostCurrent._sh[_i].getText()).equals("ا"))) { 
RDebugUtils.currentLine=41287820;
 //BA.debugLineNum = 41287820;BA.debugLine="SH(i).Color=0x9600FF24";
mostCurrent._sh[_i].setColor(((int)0x9600ff24));
 }else {
RDebugUtils.currentLine=41287822;
 //BA.debugLineNum = 41287822;BA.debugLine="SH(i).Color=Colors.Transparent";
mostCurrent._sh[_i].setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 }}}}
;
RDebugUtils.currentLine=41287828;
 //BA.debugLineNum = 41287828;BA.debugLine="If(ls_tatili_moon.Get(counter-1)=True)Then";
if (((mostCurrent._ls_tatili_moon.Get((int) (_counter-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=41287829;
 //BA.debugLineNum = 41287829;BA.debugLine="PA(i).Color=0xFFFF5252";
mostCurrent._pa[_i].setColor(((int)0xffff5252));
 };
RDebugUtils.currentLine=41287833;
 //BA.debugLineNum = 41287833;BA.debugLine="If(ls_tatili_custom_moon.Get(counter-1)=True)T";
if (((mostCurrent._ls_tatili_custom_moon.Get((int) (_counter-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=41287834;
 //BA.debugLineNum = 41287834;BA.debugLine="PA(i).Color=0xFF00BB8B";
mostCurrent._pa[_i].setColor(((int)0xff00bb8b));
 };
RDebugUtils.currentLine=41287838;
 //BA.debugLineNum = 41287838;BA.debugLine="If(ls_note_moon.Get(counter-1)=True)Then";
if (((mostCurrent._ls_note_moon.Get((int) (_counter-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=41287839;
 //BA.debugLineNum = 41287839;BA.debugLine="NO(i).Text=\"•\"";
mostCurrent._no[_i].setText(BA.ObjectToCharSequence("•"));
RDebugUtils.currentLine=41287840;
 //BA.debugLineNum = 41287840;BA.debugLine="NO(i).textColor=Colors.Blue";
mostCurrent._no[_i].setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 };
RDebugUtils.currentLine=41287845;
 //BA.debugLineNum = 41287845;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(year&\"/\"&my";
if ((mostCurrent._dbcode._isexist_ezafekari_by_date /*boolean*/ (mostCurrent.activityBA,BA.NumberToString(_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_counter))==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=41287846;
 //BA.debugLineNum = 41287846;BA.debugLine="EZ(i).Text=\"*\"";
mostCurrent._ez[_i].setText(BA.ObjectToCharSequence("*"));
RDebugUtils.currentLine=41287847;
 //BA.debugLineNum = 41287847;BA.debugLine="EZ(i).TextColor=0xFF00941C";
mostCurrent._ez[_i].setTextColor(((int)0xff00941c));
 }else 
{RDebugUtils.currentLine=41287848;
 //BA.debugLineNum = 41287848;BA.debugLine="Else if (dbCode.isexist_morakhasi_by_date(year&";
if ((mostCurrent._dbcode._isexist_morakhasi_by_date /*boolean*/ (mostCurrent.activityBA,BA.NumberToString(_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_counter))==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=41287849;
 //BA.debugLineNum = 41287849;BA.debugLine="EZ(i).Text=\"*\"";
mostCurrent._ez[_i].setText(BA.ObjectToCharSequence("*"));
RDebugUtils.currentLine=41287850;
 //BA.debugLineNum = 41287850;BA.debugLine="EZ(i).TextColor=0xFFFF5200";
mostCurrent._ez[_i].setTextColor(((int)0xffff5200));
 }else 
{RDebugUtils.currentLine=41287851;
 //BA.debugLineNum = 41287851;BA.debugLine="Else if (dbCode.isexist_taradod_by_date(year&\"/";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,BA.NumberToString(_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_counter))==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=41287852;
 //BA.debugLineNum = 41287852;BA.debugLine="EZ(i).Text=\"*\"";
mostCurrent._ez[_i].setText(BA.ObjectToCharSequence("*"));
RDebugUtils.currentLine=41287853;
 //BA.debugLineNum = 41287853;BA.debugLine="EZ(i).TextColor=0xFFFF5200";
mostCurrent._ez[_i].setTextColor(((int)0xffff5200));
 }}}
;
 };
RDebugUtils.currentLine=41287862;
 //BA.debugLineNum = 41287862;BA.debugLine="If(counter=this_day And moon=date.PersianMonth A";
if ((_counter==_this_day && _moon==mostCurrent._date.getPersianMonth() && _year==_this_year)) { 
RDebugUtils.currentLine=41287865;
 //BA.debugLineNum = 41287865;BA.debugLine="Lb(i).TextColor=0xFFFF9000";
mostCurrent._lb[_i].setTextColor(((int)0xffff9000));
RDebugUtils.currentLine=41287866;
 //BA.debugLineNum = 41287866;BA.debugLine="index_i_today=i";
_index_i_today = _i;
 };
RDebugUtils.currentLine=41287869;
 //BA.debugLineNum = 41287869;BA.debugLine="If(counter>=count_day_moon)Then";
if ((_counter>=_count_day_moon)) { 
RDebugUtils.currentLine=41287871;
 //BA.debugLineNum = 41287871;BA.debugLine="For f=i+1 To Lb.Length-1";
{
final int step120 = 1;
final int limit120 = (int) (mostCurrent._lb.length-1);
_f = (int) (_i+1) ;
for (;_f <= limit120 ;_f = _f + step120 ) {
RDebugUtils.currentLine=41287872;
 //BA.debugLineNum = 41287872;BA.debugLine="PA(f).Visible=False";
mostCurrent._pa[_f].setVisible(anywheresoftware.b4a.keywords.Common.False);
 }
};
 };
RDebugUtils.currentLine=41287878;
 //BA.debugLineNum = 41287878;BA.debugLine="counter=counter+1";
_counter = (int) (_counter+1);
 }
};
 } 
       catch (Exception e127) {
			processBA.setLastException(e127);RDebugUtils.currentLine=41287882;
 //BA.debugLineNum = 41287882;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("241287882",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=41287886;
 //BA.debugLineNum = 41287886;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_menu_day_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_menu_day_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_menu_day_click", null));}
RDebugUtils.currentLine=42663936;
 //BA.debugLineNum = 42663936;BA.debugLine="Private Sub pan_all_menu_day_Click";
RDebugUtils.currentLine=42663937;
 //BA.debugLineNum = 42663937;BA.debugLine="pan_all_menu_day.Visible=False";
mostCurrent._pan_all_menu_day.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42663938;
 //BA.debugLineNum = 42663938;BA.debugLine="End Sub";
return "";
}
public static String  _get_ezafekari(String _date1) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_ezafekari", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_ezafekari", new Object[] {_date1}));}
anywheresoftware.b4a.objects.collections.List _ezlist = null;
String _newline = "";
int _k = 0;
int _i = 0;
RDebugUtils.currentLine=41156608;
 //BA.debugLineNum = 41156608;BA.debugLine="Sub get_ezafekari(date1 As String)";
RDebugUtils.currentLine=41156609;
 //BA.debugLineNum = 41156609;BA.debugLine="lbl_ezafekari_day.Text=\"\"";
mostCurrent._lbl_ezafekari_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=41156610;
 //BA.debugLineNum = 41156610;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=41156611;
 //BA.debugLineNum = 41156611;BA.debugLine="Dim ezList As List";
_ezlist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=41156612;
 //BA.debugLineNum = 41156612;BA.debugLine="ezList.Initialize";
_ezlist.Initialize();
RDebugUtils.currentLine=41156613;
 //BA.debugLineNum = 41156613;BA.debugLine="Dim newLine As String=\"\"";
_newline = "";
RDebugUtils.currentLine=41156615;
 //BA.debugLineNum = 41156615;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"+_date1+"';")));
RDebugUtils.currentLine=41156617;
 //BA.debugLineNum = 41156617;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=41156618;
 //BA.debugLineNum = 41156618;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_k = (int) (0) ;
for (;_k <= limit8 ;_k = _k + step8 ) {
RDebugUtils.currentLine=41156619;
 //BA.debugLineNum = 41156619;BA.debugLine="dbCode.res.Position=K";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_k);
RDebugUtils.currentLine=41156621;
 //BA.debugLineNum = 41156621;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
_ezlist.Add((Object)(_newline+"از "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" تا "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+"  ( "+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_h"))+":"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_m"))+")"));
RDebugUtils.currentLine=41156622;
 //BA.debugLineNum = 41156622;BA.debugLine="newLine=CRLF";
_newline = anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 }else {
RDebugUtils.currentLine=41156628;
 //BA.debugLineNum = 41156628;BA.debugLine="ezList.Add(\"-\")";
_ezlist.Add((Object)("-"));
 };
RDebugUtils.currentLine=41156631;
 //BA.debugLineNum = 41156631;BA.debugLine="For i=0 To ezList.Size-1";
{
final int step16 = 1;
final int limit16 = (int) (_ezlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
RDebugUtils.currentLine=41156632;
 //BA.debugLineNum = 41156632;BA.debugLine="lbl_ezafekari_day.Text=lbl_ezafekari_day.Text &";
mostCurrent._lbl_ezafekari_day.setText(BA.ObjectToCharSequence(mostCurrent._lbl_ezafekari_day.getText()+BA.ObjectToString(_ezlist.Get(_i))));
 }
};
RDebugUtils.currentLine=41156635;
 //BA.debugLineNum = 41156635;BA.debugLine="End Sub";
return "";
}
public static String  _get_monasebat(int _id) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_monasebat", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_monasebat", new Object[] {_id}));}
String _str_sh = "";
RDebugUtils.currentLine=40960000;
 //BA.debugLineNum = 40960000;BA.debugLine="Sub get_monasebat ( id As Int)";
RDebugUtils.currentLine=40960001;
 //BA.debugLineNum = 40960001;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=40960002;
 //BA.debugLineNum = 40960002;BA.debugLine="lbl_today_monasebat.Text=\"\"";
mostCurrent._lbl_today_monasebat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=40960003;
 //BA.debugLineNum = 40960003;BA.debugLine="lbl_today.Text=\"\"";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=40960005;
 //BA.debugLineNum = 40960005;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=40960008;
 //BA.debugLineNum = 40960008;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=40960012;
 //BA.debugLineNum = 40960012;BA.debugLine="If(dbCode.res.GetString(\"monasebat\")<> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("monasebat")).equals("") == false)) { 
RDebugUtils.currentLine=40960013;
 //BA.debugLineNum = 40960013;BA.debugLine="lbl_today_monasebat.Text=dbCode.res.GetString(\"m";
mostCurrent._lbl_today_monasebat.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("monasebat")));
 };
RDebugUtils.currentLine=40960017;
 //BA.debugLineNum = 40960017;BA.debugLine="lbl_today.Text=lbl_year_tagvim.Text&\"/\"&dbCode.re";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("moon")+"/"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_c"))));
RDebugUtils.currentLine=40960020;
 //BA.debugLineNum = 40960020;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=40960021;
 //BA.debugLineNum = 40960021;BA.debugLine="lbl_today.Text=lbl_today.Text&\" (تعطیل) \"";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_today.getText()+" (تعطیل) "));
 };
RDebugUtils.currentLine=40960024;
 //BA.debugLineNum = 40960024;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil1\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil1"))) { 
RDebugUtils.currentLine=40960025;
 //BA.debugLineNum = 40960025;BA.debugLine="lbl_today.Text=lbl_today.Text&\" ( تعطیل قراردادی";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_today.getText()+" ( تعطیل قراردادی) "));
 };
RDebugUtils.currentLine=40960028;
 //BA.debugLineNum = 40960028;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")).equals("") == false)) { 
RDebugUtils.currentLine=40960029;
 //BA.debugLineNum = 40960029;BA.debugLine="Dim str_sh As String";
_str_sh = "";
RDebugUtils.currentLine=40960030;
 //BA.debugLineNum = 40960030;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift"),"ر","ش","ع","ا")) {
case 0: {
RDebugUtils.currentLine=40960032;
 //BA.debugLineNum = 40960032;BA.debugLine="str_sh=\"روزکار\"";
_str_sh = "روزکار";
 break; }
case 1: {
RDebugUtils.currentLine=40960034;
 //BA.debugLineNum = 40960034;BA.debugLine="str_sh=\"شبکار\"";
_str_sh = "شبکار";
 break; }
case 2: {
RDebugUtils.currentLine=40960036;
 //BA.debugLineNum = 40960036;BA.debugLine="str_sh=\"عصرکار\"";
_str_sh = "عصرکار";
 break; }
case 3: {
RDebugUtils.currentLine=40960038;
 //BA.debugLineNum = 40960038;BA.debugLine="str_sh=\"استراحت\"";
_str_sh = "استراحت";
 break; }
}
;
RDebugUtils.currentLine=40960041;
 //BA.debugLineNum = 40960041;BA.debugLine="lbl_today.Text=lbl_today.Text&\"- (( شیفت : \"&str";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_today.getText()+"- (( شیفت : "+_str_sh+" )) "));
 };
RDebugUtils.currentLine=40960045;
 //BA.debugLineNum = 40960045;BA.debugLine="End Sub";
return "";
}
public static String  _get_morakhasi(String _date1) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_morakhasi", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_morakhasi", new Object[] {_date1}));}
anywheresoftware.b4a.objects.collections.List _ezlist = null;
String _newline = "";
int _k = 0;
int _i = 0;
RDebugUtils.currentLine=41222144;
 //BA.debugLineNum = 41222144;BA.debugLine="Sub get_morakhasi(date1 As String)";
RDebugUtils.currentLine=41222145;
 //BA.debugLineNum = 41222145;BA.debugLine="lbl_morakhasi_day.Text=\"\"";
mostCurrent._lbl_morakhasi_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=41222146;
 //BA.debugLineNum = 41222146;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=41222147;
 //BA.debugLineNum = 41222147;BA.debugLine="Dim ezList As List";
_ezlist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=41222148;
 //BA.debugLineNum = 41222148;BA.debugLine="ezList.Initialize";
_ezlist.Initialize();
RDebugUtils.currentLine=41222149;
 //BA.debugLineNum = 41222149;BA.debugLine="Dim newLine As String=\"\"";
_newline = "";
RDebugUtils.currentLine=41222151;
 //BA.debugLineNum = 41222151;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"+_date1+"';")));
RDebugUtils.currentLine=41222153;
 //BA.debugLineNum = 41222153;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=41222154;
 //BA.debugLineNum = 41222154;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_k = (int) (0) ;
for (;_k <= limit8 ;_k = _k + step8 ) {
RDebugUtils.currentLine=41222155;
 //BA.debugLineNum = 41222155;BA.debugLine="dbCode.res.Position=K";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_k);
RDebugUtils.currentLine=41222157;
 //BA.debugLineNum = 41222157;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
_ezlist.Add((Object)(_newline+"از "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" تا "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+"  ( "+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_d"))+":"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_h"))+":"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_m"))+")"));
RDebugUtils.currentLine=41222158;
 //BA.debugLineNum = 41222158;BA.debugLine="newLine=CRLF";
_newline = anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 }else {
RDebugUtils.currentLine=41222164;
 //BA.debugLineNum = 41222164;BA.debugLine="ezList.Add(\"-\")";
_ezlist.Add((Object)("-"));
 };
RDebugUtils.currentLine=41222167;
 //BA.debugLineNum = 41222167;BA.debugLine="For i=0 To ezList.Size-1";
{
final int step16 = 1;
final int limit16 = (int) (_ezlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
RDebugUtils.currentLine=41222168;
 //BA.debugLineNum = 41222168;BA.debugLine="lbl_morakhasi_day.Text=lbl_morakhasi_day.Text &";
mostCurrent._lbl_morakhasi_day.setText(BA.ObjectToCharSequence(mostCurrent._lbl_morakhasi_day.getText()+BA.ObjectToString(_ezlist.Get(_i))));
 }
};
RDebugUtils.currentLine=41222171;
 //BA.debugLineNum = 41222171;BA.debugLine="End Sub";
return "";
}
public static String  _get_note(int _id) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_note", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_note", new Object[] {_id}));}
RDebugUtils.currentLine=41025536;
 //BA.debugLineNum = 41025536;BA.debugLine="Sub get_note ( id As Int)";
RDebugUtils.currentLine=41025537;
 //BA.debugLineNum = 41025537;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=41025538;
 //BA.debugLineNum = 41025538;BA.debugLine="lbl_note_day.Text=\"\"";
mostCurrent._lbl_note_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=41025541;
 //BA.debugLineNum = 41025541;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=41025542;
 //BA.debugLineNum = 41025542;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=41025544;
 //BA.debugLineNum = 41025544;BA.debugLine="If(dbCode.res.GetString(\"note\")<> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")).equals("") == false)) { 
RDebugUtils.currentLine=41025545;
 //BA.debugLineNum = 41025545;BA.debugLine="lbl_note_day.Text=dbCode.res.GetString(\"note\")";
mostCurrent._lbl_note_day.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")));
 };
RDebugUtils.currentLine=41025548;
 //BA.debugLineNum = 41025548;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=41091072;
 //BA.debugLineNum = 41091072;BA.debugLine="Sub get_taradod(date1 As String)";
RDebugUtils.currentLine=41091073;
 //BA.debugLineNum = 41091073;BA.debugLine="lbl_taradod_day.Text=\"\"";
mostCurrent._lbl_taradod_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=41091074;
 //BA.debugLineNum = 41091074;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=41091075;
 //BA.debugLineNum = 41091075;BA.debugLine="Dim ezList As List";
_ezlist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=41091076;
 //BA.debugLineNum = 41091076;BA.debugLine="ezList.Initialize";
_ezlist.Initialize();
RDebugUtils.currentLine=41091077;
 //BA.debugLineNum = 41091077;BA.debugLine="Dim newLine As String=\"\"";
_newline = "";
RDebugUtils.currentLine=41091079;
 //BA.debugLineNum = 41091079;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+_date1+"';")));
RDebugUtils.currentLine=41091081;
 //BA.debugLineNum = 41091081;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=41091082;
 //BA.debugLineNum = 41091082;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_k = (int) (0) ;
for (;_k <= limit8 ;_k = _k + step8 ) {
RDebugUtils.currentLine=41091083;
 //BA.debugLineNum = 41091083;BA.debugLine="dbCode.res.Position=K";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_k);
RDebugUtils.currentLine=41091085;
 //BA.debugLineNum = 41091085;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
_ezlist.Add((Object)(_newline+"از "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" تا "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=41091086;
 //BA.debugLineNum = 41091086;BA.debugLine="newLine=CRLF";
_newline = anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 }else {
RDebugUtils.currentLine=41091090;
 //BA.debugLineNum = 41091090;BA.debugLine="ezList.Add(\"-\")";
_ezlist.Add((Object)("-"));
 };
RDebugUtils.currentLine=41091093;
 //BA.debugLineNum = 41091093;BA.debugLine="For i=0 To ezList.Size-1";
{
final int step16 = 1;
final int limit16 = (int) (_ezlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
RDebugUtils.currentLine=41091094;
 //BA.debugLineNum = 41091094;BA.debugLine="lbl_taradod_day.Text=lbl_taradod_day.Text & ezLi";
mostCurrent._lbl_taradod_day.setText(BA.ObjectToCharSequence(mostCurrent._lbl_taradod_day.getText()+BA.ObjectToString(_ezlist.Get(_i))));
 }
};
RDebugUtils.currentLine=41091097;
 //BA.debugLineNum = 41091097;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_2_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_2_click", null));}
RDebugUtils.currentLine=41943040;
 //BA.debugLineNum = 41943040;BA.debugLine="Private Sub lbl_back_2_Click";
RDebugUtils.currentLine=41943041;
 //BA.debugLineNum = 41943041;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=41943042;
 //BA.debugLineNum = 41943042;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
RDebugUtils.currentLine=41943043;
 //BA.debugLineNum = 41943043;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_checkbox_tatil_garardadi_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_checkbox_tatil_garardadi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_checkbox_tatil_garardadi_click", null));}
RDebugUtils.currentLine=42860544;
 //BA.debugLineNum = 42860544;BA.debugLine="Private Sub lbl_CheckBox_tatil_garardadi_Click";
RDebugUtils.currentLine=42860546;
 //BA.debugLineNum = 42860546;BA.debugLine="If(CheckBox_tatil_garardadi.Checked=True)Then";
if ((mostCurrent._checkbox_tatil_garardadi.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=42860547;
 //BA.debugLineNum = 42860547;BA.debugLine="CheckBox_tatil_garardadi.Checked=False";
mostCurrent._checkbox_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=42860549;
 //BA.debugLineNum = 42860549;BA.debugLine="CheckBox_tatil_garardadi.Checked=True";
mostCurrent._checkbox_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=42860552;
 //BA.debugLineNum = 42860552;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_del_shiftha_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_del_shiftha_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_del_shiftha_click", null));}
RDebugUtils.currentLine=42074112;
 //BA.debugLineNum = 42074112;BA.debugLine="Private Sub lbl_del_shiftha_Click";
RDebugUtils.currentLine=42074113;
 //BA.debugLineNum = 42074113;BA.debugLine="shift_rest";
_shift_rest();
RDebugUtils.currentLine=42074114;
 //BA.debugLineNum = 42074114;BA.debugLine="End Sub";
return "";
}
public static String  _shift_rest() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "shift_rest", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "shift_rest", null));}
RDebugUtils.currentLine=42139648;
 //BA.debugLineNum = 42139648;BA.debugLine="Sub shift_rest";
RDebugUtils.currentLine=42139649;
 //BA.debugLineNum = 42139649;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=42139650;
 //BA.debugLineNum = 42139650;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' set";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set shift='' ");
RDebugUtils.currentLine=42139651;
 //BA.debugLineNum = 42139651;BA.debugLine="If(File.Exists(File.DirInternal,\"shift_olgo\"))The";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo"))) { 
RDebugUtils.currentLine=42139652;
 //BA.debugLineNum = 42139652;BA.debugLine="File.Delete(File.DirInternal,\"shift_olgo\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo");
RDebugUtils.currentLine=42139653;
 //BA.debugLineNum = 42139653;BA.debugLine="File.Delete(File.DirInternal,\"shift_olgo_cod\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo_cod");
 };
RDebugUtils.currentLine=42139657;
 //BA.debugLineNum = 42139657;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42139658;
 //BA.debugLineNum = 42139658;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
RDebugUtils.currentLine=42139659;
 //BA.debugLineNum = 42139659;BA.debugLine="generat_taghvim(this_year,this_moon)";
_generat_taghvim(_this_year,_this_moon);
RDebugUtils.currentLine=42139660;
 //BA.debugLineNum = 42139660;BA.debugLine="ToastMessageShow(\"همه شیفت ها حذف شدند\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("همه شیفت ها حذف شدند"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42139662;
 //BA.debugLineNum = 42139662;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_note_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_note_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_note_click", null));}
RDebugUtils.currentLine=42205184;
 //BA.debugLineNum = 42205184;BA.debugLine="Private Sub lbl_edit_note_Click";
RDebugUtils.currentLine=42205185;
 //BA.debugLineNum = 42205185;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=42205186;
 //BA.debugLineNum = 42205186;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_selectedday_id))));
RDebugUtils.currentLine=42205187;
 //BA.debugLineNum = 42205187;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=42205190;
 //BA.debugLineNum = 42205190;BA.debugLine="et_note.Text=dbCode.res.GetString(\"note\")";
mostCurrent._et_note.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")));
RDebugUtils.currentLine=42205192;
 //BA.debugLineNum = 42205192;BA.debugLine="lbl_date_in_note.Text=lbl_year_tagvim.Text&\"/\"&db";
mostCurrent._lbl_date_in_note.setText(BA.ObjectToCharSequence(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("moon")+"/"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_c"))));
RDebugUtils.currentLine=42205195;
 //BA.debugLineNum = 42205195;BA.debugLine="pan_all_note.Visible=True";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42205196;
 //BA.debugLineNum = 42205196;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_shift_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_shift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_shift_click", null));}
RDebugUtils.currentLine=42991616;
 //BA.debugLineNum = 42991616;BA.debugLine="Private Sub lbl_help_shift_Click";
RDebugUtils.currentLine=42991617;
 //BA.debugLineNum = 42991617;BA.debugLine="myfunc.help_man(\"راهنما\",\"1- با نگهداشتن انگشت رو";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","1- با نگهداشتن انگشت روی روزها منو ابزارها باز میشود. "+anywheresoftware.b4a.keywords.Common.CRLF+" 2- برای شیفت بندی روزها از قسمت تنظیم شیفت اقدام کنید.");
RDebugUtils.currentLine=42991618;
 //BA.debugLineNum = 42991618;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_mah_end_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_mah_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_mah_end_click", null));}
RDebugUtils.currentLine=40566784;
 //BA.debugLineNum = 40566784;BA.debugLine="Private Sub lbl_mah_end_Click";
RDebugUtils.currentLine=40566785;
 //BA.debugLineNum = 40566785;BA.debugLine="rsPOP_mah_end.Show";
mostCurrent._rspop_mah_end.Show();
RDebugUtils.currentLine=40566786;
 //BA.debugLineNum = 40566786;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_moon_name_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_moon_name_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_moon_name_click", null));}
RDebugUtils.currentLine=39845888;
 //BA.debugLineNum = 39845888;BA.debugLine="Private Sub lbl_moon_name_Click";
RDebugUtils.currentLine=39845889;
 //BA.debugLineNum = 39845889;BA.debugLine="rsPOP_moon_tagvim.Show";
mostCurrent._rspop_moon_tagvim.Show();
RDebugUtils.currentLine=39845890;
 //BA.debugLineNum = 39845890;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_new_line_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_new_line_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_new_line_click", null));}
int _i = 0;
RDebugUtils.currentLine=41615360;
 //BA.debugLineNum = 41615360;BA.debugLine="Private Sub lbl_new_line_Click";
RDebugUtils.currentLine=41615363;
 //BA.debugLineNum = 41615363;BA.debugLine="ls_set_shift.AddSingleLine(et_num_roz.Text&\" \"&sp";
mostCurrent._ls_set_shift.AddSingleLine(BA.ObjectToCharSequence(mostCurrent._et_num_roz.getText()+" "+mostCurrent._sp_noe_shift.getSelectedItem()));
RDebugUtils.currentLine=41615364;
 //BA.debugLineNum = 41615364;BA.debugLine="For i=1 To et_num_roz.Text";
{
final int step2 = 1;
final int limit2 = (int)(Double.parseDouble(mostCurrent._et_num_roz.getText()));
_i = (int) (1) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=41615366;
 //BA.debugLineNum = 41615366;BA.debugLine="Select sp_noe_shift.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_noe_shift.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
RDebugUtils.currentLine=41615369;
 //BA.debugLineNum = 41615369;BA.debugLine="list_sift_olgo.Add(\"ر\")";
mostCurrent._list_sift_olgo.Add((Object)("ر"));
 break; }
case 1: {
RDebugUtils.currentLine=41615371;
 //BA.debugLineNum = 41615371;BA.debugLine="list_sift_olgo.Add(\"ع\")";
mostCurrent._list_sift_olgo.Add((Object)("ع"));
 break; }
case 2: {
RDebugUtils.currentLine=41615373;
 //BA.debugLineNum = 41615373;BA.debugLine="list_sift_olgo.Add(\"ش\")";
mostCurrent._list_sift_olgo.Add((Object)("ش"));
 break; }
case 3: {
RDebugUtils.currentLine=41615375;
 //BA.debugLineNum = 41615375;BA.debugLine="list_sift_olgo.Add(\"ا\")";
mostCurrent._list_sift_olgo.Add((Object)("ا"));
 break; }
}
;
 }
};
RDebugUtils.currentLine=41615384;
 //BA.debugLineNum = 41615384;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_next_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_next_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_next_click", null));}
int _adad = 0;
RDebugUtils.currentLine=41418752;
 //BA.debugLineNum = 41418752;BA.debugLine="Private Sub lbl_next_Click";
RDebugUtils.currentLine=41418754;
 //BA.debugLineNum = 41418754;BA.debugLine="If (current_moon>=12)Then";
if ((_current_moon>=12)) { 
RDebugUtils.currentLine=41418756;
 //BA.debugLineNum = 41418756;BA.debugLine="If(lbl_year_tagvim.Text<1403)Then";
if (((double)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()))<1403)) { 
RDebugUtils.currentLine=41418757;
 //BA.debugLineNum = 41418757;BA.debugLine="Dim adad As Int=lbl_year_tagvim.Text";
_adad = (int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()));
RDebugUtils.currentLine=41418758;
 //BA.debugLineNum = 41418758;BA.debugLine="lbl_year_tagvim.Text=adad+1";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_adad+1));
RDebugUtils.currentLine=41418759;
 //BA.debugLineNum = 41418759;BA.debugLine="current_moon=1";
_current_moon = (int) (1);
 }else {
RDebugUtils.currentLine=41418761;
 //BA.debugLineNum = 41418761;BA.debugLine="current_moon=12";
_current_moon = (int) (12);
 };
 }else {
RDebugUtils.currentLine=41418767;
 //BA.debugLineNum = 41418767;BA.debugLine="current_moon=current_moon+1";
_current_moon = (int) (_current_moon+1);
 };
RDebugUtils.currentLine=41418769;
 //BA.debugLineNum = 41418769;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_current_moon);
RDebugUtils.currentLine=41418771;
 //BA.debugLineNum = 41418771;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_note_day_menu_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_note_day_menu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_note_day_menu_click", null));}
RDebugUtils.currentLine=42795008;
 //BA.debugLineNum = 42795008;BA.debugLine="Private Sub lbl_note_day_menu_Click";
RDebugUtils.currentLine=42795009;
 //BA.debugLineNum = 42795009;BA.debugLine="lbl_edit_note_Click";
_lbl_edit_note_click();
RDebugUtils.currentLine=42795010;
 //BA.debugLineNum = 42795010;BA.debugLine="pan_all_menu_day_Click";
_pan_all_menu_day_click();
RDebugUtils.currentLine=42795011;
 //BA.debugLineNum = 42795011;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_prev_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_prev_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_prev_click", null));}
int _adad = 0;
RDebugUtils.currentLine=41484288;
 //BA.debugLineNum = 41484288;BA.debugLine="Private Sub lbl_prev_Click";
RDebugUtils.currentLine=41484290;
 //BA.debugLineNum = 41484290;BA.debugLine="If (current_moon<=1)Then";
if ((_current_moon<=1)) { 
RDebugUtils.currentLine=41484293;
 //BA.debugLineNum = 41484293;BA.debugLine="If(lbl_year_tagvim.Text>1398)Then";
if (((double)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()))>1398)) { 
RDebugUtils.currentLine=41484294;
 //BA.debugLineNum = 41484294;BA.debugLine="Dim adad As Int=lbl_year_tagvim.Text";
_adad = (int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()));
RDebugUtils.currentLine=41484295;
 //BA.debugLineNum = 41484295;BA.debugLine="lbl_year_tagvim.Text=adad-1";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_adad-1));
RDebugUtils.currentLine=41484296;
 //BA.debugLineNum = 41484296;BA.debugLine="current_moon=12";
_current_moon = (int) (12);
 }else {
RDebugUtils.currentLine=41484298;
 //BA.debugLineNum = 41484298;BA.debugLine="current_moon=1";
_current_moon = (int) (1);
 };
 }else {
RDebugUtils.currentLine=41484303;
 //BA.debugLineNum = 41484303;BA.debugLine="current_moon=current_moon-1";
_current_moon = (int) (_current_moon-1);
 };
RDebugUtils.currentLine=41484305;
 //BA.debugLineNum = 41484305;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_current_moon);
RDebugUtils.currentLine=41484307;
 //BA.debugLineNum = 41484307;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_roz_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_roz_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_roz_click", null));}
RDebugUtils.currentLine=40239104;
 //BA.debugLineNum = 40239104;BA.debugLine="Private Sub lbl_roz_Click";
RDebugUtils.currentLine=40239105;
 //BA.debugLineNum = 40239105;BA.debugLine="rsPOP_roz.Show";
mostCurrent._rspop_roz.Show();
RDebugUtils.currentLine=40239106;
 //BA.debugLineNum = 40239106;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_roz_end_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_roz_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_roz_end_click", null));}
RDebugUtils.currentLine=40632320;
 //BA.debugLineNum = 40632320;BA.debugLine="Private Sub lbl_roz_end_Click";
RDebugUtils.currentLine=40632321;
 //BA.debugLineNum = 40632321;BA.debugLine="rsPOP_roz_end.Show";
mostCurrent._rspop_roz_end.Show();
RDebugUtils.currentLine=40632322;
 //BA.debugLineNum = 40632322;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_note_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_note_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_note_click", null));}
RDebugUtils.currentLine=42532864;
 //BA.debugLineNum = 42532864;BA.debugLine="Private Sub lbl_save_note_Click";
RDebugUtils.currentLine=42532866;
 //BA.debugLineNum = 42532866;BA.debugLine="set_note(selectedDay_id,et_note.Text)";
_set_note(_selectedday_id,mostCurrent._et_note.getText());
RDebugUtils.currentLine=42532867;
 //BA.debugLineNum = 42532867;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,lbl_moon_nam";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())));
RDebugUtils.currentLine=42532868;
 //BA.debugLineNum = 42532868;BA.debugLine="pan_all_note.Visible=False";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42532869;
 //BA.debugLineNum = 42532869;BA.debugLine="End Sub";
return "";
}
public static String  _set_note(int _id,String _matn) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "set_note", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "set_note", new Object[] {_id,_matn}));}
RDebugUtils.currentLine=42598400;
 //BA.debugLineNum = 42598400;BA.debugLine="Sub set_note(id As Int , matn As String)";
RDebugUtils.currentLine=42598401;
 //BA.debugLineNum = 42598401;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=42598402;
 //BA.debugLineNum = 42598402;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' set";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set note='"+_matn+"' WHERE id="+BA.NumberToString(_id));
RDebugUtils.currentLine=42598404;
 //BA.debugLineNum = 42598404;BA.debugLine="ToastMessageShow(\"یادداشت ذخیره شد\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("یادداشت ذخیره شد"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42598405;
 //BA.debugLineNum = 42598405;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_shift_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_shift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_shift_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_tosave = null;
int _p = 0;
RDebugUtils.currentLine=41680896;
 //BA.debugLineNum = 41680896;BA.debugLine="Private Sub lbl_save_shift_Click";
RDebugUtils.currentLine=41680899;
 //BA.debugLineNum = 41680899;BA.debugLine="If(ls_set_shift.Size<1)Then";
if ((mostCurrent._ls_set_shift.getSize()<1)) { 
RDebugUtils.currentLine=41680900;
 //BA.debugLineNum = 41680900;BA.debugLine="ToastMessageShow(\"الگو باید حداقل یک مورد باشد\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("الگو باید حداقل یک مورد باشد"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=41680905;
 //BA.debugLineNum = 41680905;BA.debugLine="set_shift(list_sift_olgo)";
_set_shift(mostCurrent._list_sift_olgo);
RDebugUtils.currentLine=41680908;
 //BA.debugLineNum = 41680908;BA.debugLine="Dim ls_toSave As List";
_ls_tosave = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=41680909;
 //BA.debugLineNum = 41680909;BA.debugLine="ls_toSave.Initialize";
_ls_tosave.Initialize();
RDebugUtils.currentLine=41680911;
 //BA.debugLineNum = 41680911;BA.debugLine="For p=0 To ls_set_shift.Size-1";
{
final int step7 = 1;
final int limit7 = (int) (mostCurrent._ls_set_shift.getSize()-1);
_p = (int) (0) ;
for (;_p <= limit7 ;_p = _p + step7 ) {
RDebugUtils.currentLine=41680912;
 //BA.debugLineNum = 41680912;BA.debugLine="ls_toSave.Add(ls_set_shift.GetItem(p))";
_ls_tosave.Add(mostCurrent._ls_set_shift.GetItem(_p));
 }
};
RDebugUtils.currentLine=41680915;
 //BA.debugLineNum = 41680915;BA.debugLine="File.WriteList(File.DirInternal,\"shift_olgo\",ls_";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo",_ls_tosave);
RDebugUtils.currentLine=41680916;
 //BA.debugLineNum = 41680916;BA.debugLine="File.WriteList(File.DirInternal,\"shift_olgo_cod\"";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo_cod",mostCurrent._list_sift_olgo);
RDebugUtils.currentLine=41680919;
 //BA.debugLineNum = 41680919;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=41680923;
 //BA.debugLineNum = 41680923;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
RDebugUtils.currentLine=41680924;
 //BA.debugLineNum = 41680924;BA.debugLine="generat_taghvim(this_year,this_moon)";
_generat_taghvim(_this_year,_this_moon);
 };
RDebugUtils.currentLine=41680929;
 //BA.debugLineNum = 41680929;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=41811968;
 //BA.debugLineNum = 41811968;BA.debugLine="Sub set_shift(ol As List )";
RDebugUtils.currentLine=41811970;
 //BA.debugLineNum = 41811970;BA.debugLine="Try";
try {RDebugUtils.currentLine=41811971;
 //BA.debugLineNum = 41811971;BA.debugLine="ProgressDialogShow(\"در حال تنظیم شیفت ها\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("در حال تنظیم شیفت ها"));
RDebugUtils.currentLine=41811973;
 //BA.debugLineNum = 41811973;BA.debugLine="Dim start_shift As Int";
_start_shift = 0;
RDebugUtils.currentLine=41811974;
 //BA.debugLineNum = 41811974;BA.debugLine="Dim end_shift As Int";
_end_shift = 0;
RDebugUtils.currentLine=41811976;
 //BA.debugLineNum = 41811976;BA.debugLine="Dim index_curent_shift As Int=0";
_index_curent_shift = (int) (0);
RDebugUtils.currentLine=41811977;
 //BA.debugLineNum = 41811977;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=41811979;
 //BA.debugLineNum = 41811979;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' se";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set shift=''");
RDebugUtils.currentLine=41811982;
 //BA.debugLineNum = 41811982;BA.debugLine="start_shift=dbCode.get_day_id(lbl_years.Text,lbl";
_start_shift = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_years.getText())),_lbl_mah_tagid,(int)(Double.parseDouble(mostCurrent._lbl_roz.getText())));
RDebugUtils.currentLine=41811983;
 //BA.debugLineNum = 41811983;BA.debugLine="end_shift=dbCode.get_day_id(lbl_years_end.Text,l";
_end_shift = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_years_end.getText())),_lbl_mah_end_tagid,(int)(Double.parseDouble(mostCurrent._lbl_roz_end.getText())));
RDebugUtils.currentLine=41811986;
 //BA.debugLineNum = 41811986;BA.debugLine="For i=start_shift To end_shift";
{
final int step10 = 1;
final int limit10 = _end_shift;
_i = _start_shift ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=41811988;
 //BA.debugLineNum = 41811988;BA.debugLine="dbCode.sql.ExecNonQuery2(\"UPDATE 'my_calander'";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE 'my_calander' set shift=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{mostCurrent._list_sift_olgo.Get(_index_curent_shift),(Object)(_i)}));
RDebugUtils.currentLine=41811991;
 //BA.debugLineNum = 41811991;BA.debugLine="If(index_curent_shift=list_sift_olgo.Size-1)The";
if ((_index_curent_shift==mostCurrent._list_sift_olgo.getSize()-1)) { 
RDebugUtils.currentLine=41811992;
 //BA.debugLineNum = 41811992;BA.debugLine="index_curent_shift=0";
_index_curent_shift = (int) (0);
 }else {
RDebugUtils.currentLine=41811994;
 //BA.debugLineNum = 41811994;BA.debugLine="index_curent_shift=index_curent_shift+1";
_index_curent_shift = (int) (_index_curent_shift+1);
 };
 }
};
RDebugUtils.currentLine=41811999;
 //BA.debugLineNum = 41811999;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=41812000;
 //BA.debugLineNum = 41812000;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 } 
       catch (Exception e21) {
			processBA.setLastException(e21);RDebugUtils.currentLine=41812003;
 //BA.debugLineNum = 41812003;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("241812003",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=41812004;
 //BA.debugLineNum = 41812004;BA.debugLine="ToastMessageShow(\"خطا در تاریخ\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در تاریخ"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=41812010;
 //BA.debugLineNum = 41812010;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_show_panshift_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_show_panshift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_show_panshift_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_toload = null;
int _i = 0;
RDebugUtils.currentLine=41746432;
 //BA.debugLineNum = 41746432;BA.debugLine="Private Sub lbl_show_panShift_Click";
RDebugUtils.currentLine=41746434;
 //BA.debugLineNum = 41746434;BA.debugLine="If(File.Exists(File.DirInternal,\"shift_olgo\")=Tru";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=41746436;
 //BA.debugLineNum = 41746436;BA.debugLine="Dim ls_toLoad As List";
_ls_toload = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=41746437;
 //BA.debugLineNum = 41746437;BA.debugLine="ls_toLoad.Initialize";
_ls_toload.Initialize();
RDebugUtils.currentLine=41746439;
 //BA.debugLineNum = 41746439;BA.debugLine="ls_toLoad=File.ReadList(File.DirInternal,\"shift_";
_ls_toload = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo");
RDebugUtils.currentLine=41746441;
 //BA.debugLineNum = 41746441;BA.debugLine="For i=0 To ls_toLoad.Size-1";
{
final int step5 = 1;
final int limit5 = (int) (_ls_toload.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=41746442;
 //BA.debugLineNum = 41746442;BA.debugLine="ls_set_shift.AddSingleLine(ls_toLoad.Get(i))";
mostCurrent._ls_set_shift.AddSingleLine(BA.ObjectToCharSequence(_ls_toload.Get(_i)));
 }
};
RDebugUtils.currentLine=41746445;
 //BA.debugLineNum = 41746445;BA.debugLine="list_sift_olgo=File.ReadList(File.DirInternal,\"s";
mostCurrent._list_sift_olgo = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo_cod");
 };
RDebugUtils.currentLine=41746449;
 //BA.debugLineNum = 41746449;BA.debugLine="pan_all_setSift.Visible=True";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=41746451;
 //BA.debugLineNum = 41746451;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_year_tagvim_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_year_tagvim_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_year_tagvim_click", null));}
RDebugUtils.currentLine=39780352;
 //BA.debugLineNum = 39780352;BA.debugLine="Private Sub lbl_year_tagvim_Click";
RDebugUtils.currentLine=39780353;
 //BA.debugLineNum = 39780353;BA.debugLine="rsPOP_year_tagvim.Show";
mostCurrent._rspop_year_tagvim.Show();
RDebugUtils.currentLine=39780354;
 //BA.debugLineNum = 39780354;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_years_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_years_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_years_click", null));}
RDebugUtils.currentLine=40173568;
 //BA.debugLineNum = 40173568;BA.debugLine="Private Sub lbl_years_Click";
RDebugUtils.currentLine=40173569;
 //BA.debugLineNum = 40173569;BA.debugLine="rsPOP_year.Show";
mostCurrent._rspop_year.Show();
RDebugUtils.currentLine=40173570;
 //BA.debugLineNum = 40173570;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_years_end_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_years_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_years_end_click", null));}
RDebugUtils.currentLine=40501248;
 //BA.debugLineNum = 40501248;BA.debugLine="Private Sub lbl_years_end_Click";
RDebugUtils.currentLine=40501249;
 //BA.debugLineNum = 40501249;BA.debugLine="rsPOP_year_end.Show";
mostCurrent._rspop_year_end.Show();
RDebugUtils.currentLine=40501250;
 //BA.debugLineNum = 40501250;BA.debugLine="End Sub";
return "";
}
public static String  _mod_tatil_garardadi(int _id) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mod_tatil_garardadi", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "mod_tatil_garardadi", new Object[] {_id}));}
RDebugUtils.currentLine=42336256;
 //BA.debugLineNum = 42336256;BA.debugLine="Sub mod_tatil_garardadi (id As Int)";
RDebugUtils.currentLine=42336257;
 //BA.debugLineNum = 42336257;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=42336258;
 //BA.debugLineNum = 42336258;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=42336259;
 //BA.debugLineNum = 42336259;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=42336262;
 //BA.debugLineNum = 42336262;BA.debugLine="If(dbCode.res.GetString(\"state\")=\"tatil\") Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=42336263;
 //BA.debugLineNum = 42336263;BA.debugLine="CheckBox_tatil_garardadi.Enabled=False";
mostCurrent._checkbox_tatil_garardadi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42336264;
 //BA.debugLineNum = 42336264;BA.debugLine="lbl_CheckBox_tatil_garardadi.Enabled=False";
mostCurrent._lbl_checkbox_tatil_garardadi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42336265;
 //BA.debugLineNum = 42336265;BA.debugLine="CheckBox_tatil_garardadi.Checked=False";
mostCurrent._checkbox_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=42336267;
 //BA.debugLineNum = 42336267;BA.debugLine="Else If(dbCode.res.GetString(\"state\")=\"tatil1\") T";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil1"))) { 
RDebugUtils.currentLine=42336268;
 //BA.debugLineNum = 42336268;BA.debugLine="CheckBox_tatil_garardadi.Enabled=True";
mostCurrent._checkbox_tatil_garardadi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42336269;
 //BA.debugLineNum = 42336269;BA.debugLine="lbl_CheckBox_tatil_garardadi.Enabled=True";
mostCurrent._lbl_checkbox_tatil_garardadi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42336270;
 //BA.debugLineNum = 42336270;BA.debugLine="CheckBox_tatil_garardadi.Checked=True";
mostCurrent._checkbox_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=42336272;
 //BA.debugLineNum = 42336272;BA.debugLine="CheckBox_tatil_garardadi.Enabled=True";
mostCurrent._checkbox_tatil_garardadi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42336273;
 //BA.debugLineNum = 42336273;BA.debugLine="lbl_CheckBox_tatil_garardadi.Enabled=True";
mostCurrent._lbl_checkbox_tatil_garardadi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42336274;
 //BA.debugLineNum = 42336274;BA.debugLine="CheckBox_tatil_garardadi.Checked=False";
mostCurrent._checkbox_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }}
;
RDebugUtils.currentLine=42336279;
 //BA.debugLineNum = 42336279;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=41353216;
 //BA.debugLineNum = 41353216;BA.debugLine="Private Sub PA_Click";
RDebugUtils.currentLine=41353217;
 //BA.debugLineNum = 41353217;BA.debugLine="Dim str_t As String";
_str_t = "";
RDebugUtils.currentLine=41353218;
 //BA.debugLineNum = 41353218;BA.debugLine="Dim B As Panel = Sender";
_b = new anywheresoftware.b4a.objects.PanelWrapper();
_b = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=41353219;
 //BA.debugLineNum = 41353219;BA.debugLine="selectedDay_id=dbCode.get_day_id(lbl_year_tagvim.";
_selectedday_id = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())),(int)(BA.ObjectToNumber(_b.getTag())));
RDebugUtils.currentLine=41353221;
 //BA.debugLineNum = 41353221;BA.debugLine="For d=0 To PA.Length-1";
{
final int step4 = 1;
final int limit4 = (int) (mostCurrent._pa.length-1);
_d = (int) (0) ;
for (;_d <= limit4 ;_d = _d + step4 ) {
RDebugUtils.currentLine=41353222;
 //BA.debugLineNum = 41353222;BA.debugLine="str_t=PA(d).Tag";
_str_t = BA.ObjectToString(mostCurrent._pa[_d].getTag());
RDebugUtils.currentLine=41353223;
 //BA.debugLineNum = 41353223;BA.debugLine="If ( str_t = last_selected_itemTag )Then";
if (((_str_t).equals(BA.NumberToString(_last_selected_itemtag)))) { 
RDebugUtils.currentLine=41353227;
 //BA.debugLineNum = 41353227;BA.debugLine="If(last_selected_itemTag<>0)Then";
if ((_last_selected_itemtag!=0)) { 
RDebugUtils.currentLine=41353229;
 //BA.debugLineNum = 41353229;BA.debugLine="If(ls_tatili_moon.Get(last_selected_itemTag-1)";
if (((mostCurrent._ls_tatili_moon.Get((int) (_last_selected_itemtag-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=41353230;
 //BA.debugLineNum = 41353230;BA.debugLine="PA(d).Color=0xFFFF5252";
mostCurrent._pa[_d].setColor(((int)0xffff5252));
 }else 
{RDebugUtils.currentLine=41353232;
 //BA.debugLineNum = 41353232;BA.debugLine="Else If(ls_tatili_custom_moon.Get(last_selecte";
if (((mostCurrent._ls_tatili_custom_moon.Get((int) (_last_selected_itemtag-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=41353233;
 //BA.debugLineNum = 41353233;BA.debugLine="PA(d).Color=0xFF00BB8B";
mostCurrent._pa[_d].setColor(((int)0xff00bb8b));
 }else {
RDebugUtils.currentLine=41353236;
 //BA.debugLineNum = 41353236;BA.debugLine="PA(d).Color=0xFFEFEFEF";
mostCurrent._pa[_d].setColor(((int)0xffefefef));
 }}
;
 };
 };
 }
};
RDebugUtils.currentLine=41353249;
 //BA.debugLineNum = 41353249;BA.debugLine="Dim moon_tag As Int=lbl_moon_name.Tag";
_moon_tag = (int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag()));
RDebugUtils.currentLine=41353250;
 //BA.debugLineNum = 41353250;BA.debugLine="If( moon_tag=this_moon)Then";
if ((_moon_tag==_this_moon)) { 
RDebugUtils.currentLine=41353252;
 //BA.debugLineNum = 41353252;BA.debugLine="Lb(index_i_today).TextColor=0xFFFF9000";
mostCurrent._lb[_index_i_today].setTextColor(((int)0xffff9000));
 };
RDebugUtils.currentLine=41353257;
 //BA.debugLineNum = 41353257;BA.debugLine="B.Color=Colors.Gray";
_b.setColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=41353258;
 //BA.debugLineNum = 41353258;BA.debugLine="get_monasebat(selectedDay_id)";
_get_monasebat(_selectedday_id);
RDebugUtils.currentLine=41353259;
 //BA.debugLineNum = 41353259;BA.debugLine="get_note(selectedDay_id)";
_get_note(_selectedday_id);
RDebugUtils.currentLine=41353261;
 //BA.debugLineNum = 41353261;BA.debugLine="get_ezafekari(lbl_year_tagvim.Text&\"/\"&myfunc.con";
_get_ezafekari(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))));
RDebugUtils.currentLine=41353262;
 //BA.debugLineNum = 41353262;BA.debugLine="get_morakhasi(lbl_year_tagvim.Text&\"/\"&myfunc.con";
_get_morakhasi(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))));
RDebugUtils.currentLine=41353263;
 //BA.debugLineNum = 41353263;BA.debugLine="get_taradod(lbl_year_tagvim.Text&\"/\"&myfunc.conve";
_get_taradod(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))));
RDebugUtils.currentLine=41353265;
 //BA.debugLineNum = 41353265;BA.debugLine="last_selected_itemTag=B.Tag";
_last_selected_itemtag = (int)(BA.ObjectToNumber(_b.getTag()));
RDebugUtils.currentLine=41353268;
 //BA.debugLineNum = 41353268;BA.debugLine="End Sub";
return "";
}
public static String  _pa_longclick() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pa_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pa_longclick", null));}
anywheresoftware.b4a.objects.PanelWrapper _b = null;
RDebugUtils.currentLine=42270720;
 //BA.debugLineNum = 42270720;BA.debugLine="Private Sub PA_LongClick";
RDebugUtils.currentLine=42270721;
 //BA.debugLineNum = 42270721;BA.debugLine="Dim B As Panel = Sender";
_b = new anywheresoftware.b4a.objects.PanelWrapper();
_b = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=42270724;
 //BA.debugLineNum = 42270724;BA.debugLine="selectedDay_id=dbCode.get_day_id(lbl_year_tagvim.";
_selectedday_id = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())),(int)(BA.ObjectToNumber(_b.getTag())));
RDebugUtils.currentLine=42270731;
 //BA.debugLineNum = 42270731;BA.debugLine="lbl_title_day_menu.Text=lbl_year_tagvim.Text&\"/\"&";
mostCurrent._lbl_title_day_menu.setText(BA.ObjectToCharSequence(mostCurrent._lbl_year_tagvim.getText()+"/"+BA.ObjectToString(mostCurrent._lbl_moon_name.getTag())+"/"+BA.ObjectToString(_b.getTag())));
RDebugUtils.currentLine=42270732;
 //BA.debugLineNum = 42270732;BA.debugLine="mod_tatil_garardadi(selectedDay_id)";
_mod_tatil_garardadi(_selectedday_id);
RDebugUtils.currentLine=42270733;
 //BA.debugLineNum = 42270733;BA.debugLine="pan_all_menu_day.Visible=True";
mostCurrent._pan_all_menu_day.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=42270734;
 //BA.debugLineNum = 42270734;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_note_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_note_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_note_click", null));}
RDebugUtils.currentLine=42401792;
 //BA.debugLineNum = 42401792;BA.debugLine="Private Sub pan_all_note_Click";
RDebugUtils.currentLine=42401793;
 //BA.debugLineNum = 42401793;BA.debugLine="pan_all_note.Visible=False";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=42401794;
 //BA.debugLineNum = 42401794;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_setsift_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_setsift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_setsift_click", null));}
RDebugUtils.currentLine=41549824;
 //BA.debugLineNum = 41549824;BA.debugLine="Private Sub pan_all_setSift_Click";
RDebugUtils.currentLine=41549826;
 //BA.debugLineNum = 41549826;BA.debugLine="End Sub";
return "";
}
public static String  _panel12_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel12_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel12_click", null));}
RDebugUtils.currentLine=42467328;
 //BA.debugLineNum = 42467328;BA.debugLine="Private Sub Panel12_Click";
RDebugUtils.currentLine=42467330;
 //BA.debugLineNum = 42467330;BA.debugLine="End Sub";
return "";
}
public static String  _panel8_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel8_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel8_click", null));}
RDebugUtils.currentLine=42729472;
 //BA.debugLineNum = 42729472;BA.debugLine="Private Sub Panel8_Click";
RDebugUtils.currentLine=42729474;
 //BA.debugLineNum = 42729474;BA.debugLine="End Sub";
return "";
}
public static boolean  _rspop_mah_end_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_mah_end_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_mah_end_menuitemclick", new Object[] {_itemid}));}
String _mmah = "";
RDebugUtils.currentLine=40370176;
 //BA.debugLineNum = 40370176;BA.debugLine="Sub rsPOP_mah_end_MenuItemClick (ItemId As Int) As";
RDebugUtils.currentLine=40370177;
 //BA.debugLineNum = 40370177;BA.debugLine="Dim mmah As String";
_mmah = "";
RDebugUtils.currentLine=40370178;
 //BA.debugLineNum = 40370178;BA.debugLine="Select ItemId";
switch (_itemid) {
case 1: {
RDebugUtils.currentLine=40370180;
 //BA.debugLineNum = 40370180;BA.debugLine="mmah=\"فروردین\"";
_mmah = "فروردین";
 break; }
case 2: {
RDebugUtils.currentLine=40370182;
 //BA.debugLineNum = 40370182;BA.debugLine="mmah=\"اردیبهشت\"";
_mmah = "اردیبهشت";
 break; }
case 3: {
RDebugUtils.currentLine=40370184;
 //BA.debugLineNum = 40370184;BA.debugLine="mmah=\"خرداد\"";
_mmah = "خرداد";
 break; }
case 4: {
RDebugUtils.currentLine=40370186;
 //BA.debugLineNum = 40370186;BA.debugLine="mmah=\"تیر\"";
_mmah = "تیر";
 break; }
case 5: {
RDebugUtils.currentLine=40370188;
 //BA.debugLineNum = 40370188;BA.debugLine="mmah=\"مرداد\"";
_mmah = "مرداد";
 break; }
case 6: {
RDebugUtils.currentLine=40370190;
 //BA.debugLineNum = 40370190;BA.debugLine="mmah=\"شهریور\"";
_mmah = "شهریور";
 break; }
case 7: {
RDebugUtils.currentLine=40370192;
 //BA.debugLineNum = 40370192;BA.debugLine="mmah=\"مهر\"";
_mmah = "مهر";
 break; }
case 8: {
RDebugUtils.currentLine=40370194;
 //BA.debugLineNum = 40370194;BA.debugLine="mmah=\"آبان\"";
_mmah = "آبان";
 break; }
case 9: {
RDebugUtils.currentLine=40370196;
 //BA.debugLineNum = 40370196;BA.debugLine="mmah=\"آذر\"";
_mmah = "آذر";
 break; }
case 10: {
RDebugUtils.currentLine=40370198;
 //BA.debugLineNum = 40370198;BA.debugLine="mmah=\"دی\"";
_mmah = "دی";
 break; }
case 11: {
RDebugUtils.currentLine=40370200;
 //BA.debugLineNum = 40370200;BA.debugLine="mmah=\"بهمن\"";
_mmah = "بهمن";
 break; }
case 12: {
RDebugUtils.currentLine=40370202;
 //BA.debugLineNum = 40370202;BA.debugLine="mmah=\"اسفند\"";
_mmah = "اسفند";
 break; }
}
;
RDebugUtils.currentLine=40370208;
 //BA.debugLineNum = 40370208;BA.debugLine="lbl_mah_end.Text=mmah";
mostCurrent._lbl_mah_end.setText(BA.ObjectToCharSequence(_mmah));
RDebugUtils.currentLine=40370209;
 //BA.debugLineNum = 40370209;BA.debugLine="lbl_mah_end_tagID=ItemId";
_lbl_mah_end_tagid = _itemid;
RDebugUtils.currentLine=40370211;
 //BA.debugLineNum = 40370211;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=40370212;
 //BA.debugLineNum = 40370212;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_mah_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_mah_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_mah_menuitemclick", new Object[] {_itemid}));}
String _mmah = "";
RDebugUtils.currentLine=40042496;
 //BA.debugLineNum = 40042496;BA.debugLine="Sub rsPOP_mah_MenuItemClick (ItemId As Int) As Boo";
RDebugUtils.currentLine=40042497;
 //BA.debugLineNum = 40042497;BA.debugLine="Dim mmah As String";
_mmah = "";
RDebugUtils.currentLine=40042498;
 //BA.debugLineNum = 40042498;BA.debugLine="Select ItemId";
switch (_itemid) {
case 1: {
RDebugUtils.currentLine=40042500;
 //BA.debugLineNum = 40042500;BA.debugLine="mmah=\"فروردین\"";
_mmah = "فروردین";
 break; }
case 2: {
RDebugUtils.currentLine=40042502;
 //BA.debugLineNum = 40042502;BA.debugLine="mmah=\"اردیبهشت\"";
_mmah = "اردیبهشت";
 break; }
case 3: {
RDebugUtils.currentLine=40042504;
 //BA.debugLineNum = 40042504;BA.debugLine="mmah=\"خرداد\"";
_mmah = "خرداد";
 break; }
case 4: {
RDebugUtils.currentLine=40042506;
 //BA.debugLineNum = 40042506;BA.debugLine="mmah=\"تیر\"";
_mmah = "تیر";
 break; }
case 5: {
RDebugUtils.currentLine=40042508;
 //BA.debugLineNum = 40042508;BA.debugLine="mmah=\"مرداد\"";
_mmah = "مرداد";
 break; }
case 6: {
RDebugUtils.currentLine=40042510;
 //BA.debugLineNum = 40042510;BA.debugLine="mmah=\"شهریور\"";
_mmah = "شهریور";
 break; }
case 7: {
RDebugUtils.currentLine=40042512;
 //BA.debugLineNum = 40042512;BA.debugLine="mmah=\"مهر\"";
_mmah = "مهر";
 break; }
case 8: {
RDebugUtils.currentLine=40042514;
 //BA.debugLineNum = 40042514;BA.debugLine="mmah=\"آبان\"";
_mmah = "آبان";
 break; }
case 9: {
RDebugUtils.currentLine=40042516;
 //BA.debugLineNum = 40042516;BA.debugLine="mmah=\"آذر\"";
_mmah = "آذر";
 break; }
case 10: {
RDebugUtils.currentLine=40042518;
 //BA.debugLineNum = 40042518;BA.debugLine="mmah=\"دی\"";
_mmah = "دی";
 break; }
case 11: {
RDebugUtils.currentLine=40042520;
 //BA.debugLineNum = 40042520;BA.debugLine="mmah=\"بهمن\"";
_mmah = "بهمن";
 break; }
case 12: {
RDebugUtils.currentLine=40042522;
 //BA.debugLineNum = 40042522;BA.debugLine="mmah=\"اسفند\"";
_mmah = "اسفند";
 break; }
}
;
RDebugUtils.currentLine=40042527;
 //BA.debugLineNum = 40042527;BA.debugLine="lbl_mah_tagID=ItemId";
_lbl_mah_tagid = _itemid;
RDebugUtils.currentLine=40042529;
 //BA.debugLineNum = 40042529;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=40042530;
 //BA.debugLineNum = 40042530;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_moon_tagvim_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_moon_tagvim_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_moon_tagvim_menuitemclick", new Object[] {_itemid}));}
String _mmah = "";
RDebugUtils.currentLine=39911424;
 //BA.debugLineNum = 39911424;BA.debugLine="Sub rsPOP_moon_tagvim_MenuItemClick (ItemId As Int";
RDebugUtils.currentLine=39911425;
 //BA.debugLineNum = 39911425;BA.debugLine="Dim mmah As String";
_mmah = "";
RDebugUtils.currentLine=39911426;
 //BA.debugLineNum = 39911426;BA.debugLine="Select ItemId";
switch (_itemid) {
case 1: {
RDebugUtils.currentLine=39911428;
 //BA.debugLineNum = 39911428;BA.debugLine="mmah=\"فروردین\"";
_mmah = "فروردین";
 break; }
case 2: {
RDebugUtils.currentLine=39911430;
 //BA.debugLineNum = 39911430;BA.debugLine="mmah=\"اردیبهشت\"";
_mmah = "اردیبهشت";
 break; }
case 3: {
RDebugUtils.currentLine=39911432;
 //BA.debugLineNum = 39911432;BA.debugLine="mmah=\"خرداد\"";
_mmah = "خرداد";
 break; }
case 4: {
RDebugUtils.currentLine=39911434;
 //BA.debugLineNum = 39911434;BA.debugLine="mmah=\"تیر\"";
_mmah = "تیر";
 break; }
case 5: {
RDebugUtils.currentLine=39911436;
 //BA.debugLineNum = 39911436;BA.debugLine="mmah=\"مرداد\"";
_mmah = "مرداد";
 break; }
case 6: {
RDebugUtils.currentLine=39911438;
 //BA.debugLineNum = 39911438;BA.debugLine="mmah=\"شهریور\"";
_mmah = "شهریور";
 break; }
case 7: {
RDebugUtils.currentLine=39911440;
 //BA.debugLineNum = 39911440;BA.debugLine="mmah=\"مهر\"";
_mmah = "مهر";
 break; }
case 8: {
RDebugUtils.currentLine=39911442;
 //BA.debugLineNum = 39911442;BA.debugLine="mmah=\"آبان\"";
_mmah = "آبان";
 break; }
case 9: {
RDebugUtils.currentLine=39911444;
 //BA.debugLineNum = 39911444;BA.debugLine="mmah=\"آذر\"";
_mmah = "آذر";
 break; }
case 10: {
RDebugUtils.currentLine=39911446;
 //BA.debugLineNum = 39911446;BA.debugLine="mmah=\"دی\"";
_mmah = "دی";
 break; }
case 11: {
RDebugUtils.currentLine=39911448;
 //BA.debugLineNum = 39911448;BA.debugLine="mmah=\"بهمن\"";
_mmah = "بهمن";
 break; }
case 12: {
RDebugUtils.currentLine=39911450;
 //BA.debugLineNum = 39911450;BA.debugLine="mmah=\"اسفند\"";
_mmah = "اسفند";
 break; }
}
;
RDebugUtils.currentLine=39911454;
 //BA.debugLineNum = 39911454;BA.debugLine="lbl_moon_name.Text=mmah";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence(_mmah));
RDebugUtils.currentLine=39911456;
 //BA.debugLineNum = 39911456;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,ItemId)";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_itemid);
RDebugUtils.currentLine=39911457;
 //BA.debugLineNum = 39911457;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=39911458;
 //BA.debugLineNum = 39911458;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_roz_end_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_roz_end_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_roz_end_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=40435712;
 //BA.debugLineNum = 40435712;BA.debugLine="Sub rsPOP_roz_end_MenuItemClick (ItemId As Int) As";
RDebugUtils.currentLine=40435714;
 //BA.debugLineNum = 40435714;BA.debugLine="lbl_roz_end.Text=ItemId";
mostCurrent._lbl_roz_end.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=40435715;
 //BA.debugLineNum = 40435715;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=40435716;
 //BA.debugLineNum = 40435716;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_roz_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_roz_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_roz_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=40108032;
 //BA.debugLineNum = 40108032;BA.debugLine="Sub rsPOP_roz_MenuItemClick (ItemId As Int) As Boo";
RDebugUtils.currentLine=40108034;
 //BA.debugLineNum = 40108034;BA.debugLine="lbl_roz.Text=ItemId";
mostCurrent._lbl_roz.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=40108035;
 //BA.debugLineNum = 40108035;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=40108036;
 //BA.debugLineNum = 40108036;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_year_end_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_year_end_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_year_end_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=40304640;
 //BA.debugLineNum = 40304640;BA.debugLine="Sub rsPOP_year_end_MenuItemClick (ItemId As Int) A";
RDebugUtils.currentLine=40304641;
 //BA.debugLineNum = 40304641;BA.debugLine="lbl_years_end.Text=ItemId";
mostCurrent._lbl_years_end.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=40304642;
 //BA.debugLineNum = 40304642;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=40304643;
 //BA.debugLineNum = 40304643;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_year_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_year_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_year_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=39976960;
 //BA.debugLineNum = 39976960;BA.debugLine="Sub rsPOP_year_MenuItemClick (ItemId As Int) As Bo";
RDebugUtils.currentLine=39976961;
 //BA.debugLineNum = 39976961;BA.debugLine="lbl_years.Text=ItemId";
mostCurrent._lbl_years.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=39976962;
 //BA.debugLineNum = 39976962;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=39976963;
 //BA.debugLineNum = 39976963;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_year_tagvim_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_year_tagvim_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_year_tagvim_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=39714816;
 //BA.debugLineNum = 39714816;BA.debugLine="Sub rsPOP_year_tagvim_MenuItemClick (ItemId As Int";
RDebugUtils.currentLine=39714817;
 //BA.debugLineNum = 39714817;BA.debugLine="lbl_year_tagvim.Text=ItemId";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=39714818;
 //BA.debugLineNum = 39714818;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_current_moon);
RDebugUtils.currentLine=39714819;
 //BA.debugLineNum = 39714819;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=39714820;
 //BA.debugLineNum = 39714820;BA.debugLine="End Sub";
return false;
}
public static String  _sql_nonquerycomplete(boolean _success) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sql_nonquerycomplete", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sql_nonquerycomplete", new Object[] {_success}));}
RDebugUtils.currentLine=41877504;
 //BA.debugLineNum = 41877504;BA.debugLine="Sub sql_NonQueryComplete (Success As Boolean)";
RDebugUtils.currentLine=41877506;
 //BA.debugLineNum = 41877506;BA.debugLine="End Sub";
return "";
}
}