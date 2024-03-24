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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.shift_activity");
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
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.food_activity _food_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.ayabzahab_activity _ayabzahab_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.gestha_activity _gestha_activity = null;
public ir.taravatgroup.ezafekari2.help_kharid_activity _help_kharid_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.mosaedeh_activity _mosaedeh_activity = null;
public ir.taravatgroup.ezafekari2.padash_activity _padash_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
public ir.taravatgroup.ezafekari2.savabeg_activity _savabeg_activity = null;
public ir.taravatgroup.ezafekari2.sayer_activity _sayer_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
int _i = 0;
 //BA.debugLineNum = 335;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 338;BA.debugLine="Activity.LoadLayout(\"shift_layout\")";
mostCurrent._activity.LoadLayout("shift_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 340;BA.debugLine="scrol_v.Panel.LoadLayout(\"shift_page_items\")";
mostCurrent._scrol_v.getPanel().LoadLayout("shift_page_items",mostCurrent.activityBA);
 //BA.debugLineNum = 342;BA.debugLine="pan_hed_shift.Color=Main.color4";
mostCurrent._pan_hed_shift.setColor(mostCurrent._main._color4 /*int*/ );
 //BA.debugLineNum = 343;BA.debugLine="lbl_hed_set_shift.Color=Main.color4";
mostCurrent._lbl_hed_set_shift.setColor(mostCurrent._main._color4 /*int*/ );
 //BA.debugLineNum = 346;BA.debugLine="lbl0.Initialize(\"lbl0\")";
mostCurrent._lbl0.Initialize(mostCurrent.activityBA,"lbl0");
 //BA.debugLineNum = 347;BA.debugLine="lbl0.Tag=0";
mostCurrent._lbl0.setTag((Object)(0));
 //BA.debugLineNum = 348;BA.debugLine="p0.Initialize(\"p0\")";
mostCurrent._p0.Initialize(mostCurrent.activityBA,"p0");
 //BA.debugLineNum = 349;BA.debugLine="p0.Tag=0";
mostCurrent._p0.setTag((Object)(0));
 //BA.debugLineNum = 350;BA.debugLine="sh0.Initialize(\"sh0\")";
mostCurrent._sh0.Initialize(mostCurrent.activityBA,"sh0");
 //BA.debugLineNum = 351;BA.debugLine="sh0.Tag=0";
mostCurrent._sh0.setTag((Object)(0));
 //BA.debugLineNum = 352;BA.debugLine="ez0.Initialize(\"ez0\")";
mostCurrent._ez0.Initialize(mostCurrent.activityBA,"ez0");
 //BA.debugLineNum = 353;BA.debugLine="ez0.Tag=0";
mostCurrent._ez0.setTag((Object)(0));
 //BA.debugLineNum = 354;BA.debugLine="no0.Initialize(\"no0\")";
mostCurrent._no0.Initialize(mostCurrent.activityBA,"no0");
 //BA.debugLineNum = 355;BA.debugLine="no0.Tag=0";
mostCurrent._no0.setTag((Object)(0));
 //BA.debugLineNum = 357;BA.debugLine="ls_shift_moon.Initialize";
mostCurrent._ls_shift_moon.Initialize();
 //BA.debugLineNum = 358;BA.debugLine="ls_tatili_moon.Initialize";
mostCurrent._ls_tatili_moon.Initialize();
 //BA.debugLineNum = 359;BA.debugLine="ls_tatili_custom_moon.Initialize";
mostCurrent._ls_tatili_custom_moon.Initialize();
 //BA.debugLineNum = 360;BA.debugLine="ls_note_moon.Initialize";
mostCurrent._ls_note_moon.Initialize();
 //BA.debugLineNum = 363;BA.debugLine="list_sift_olgo.Initialize";
mostCurrent._list_sift_olgo.Initialize();
 //BA.debugLineNum = 364;BA.debugLine="ls_set_shift.SingleLineLayout.Label.TextColor=Col";
mostCurrent._ls_set_shift.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 366;BA.debugLine="ls_set_shift.SingleLineLayout.Label.Width=ls_set_";
mostCurrent._ls_set_shift.getSingleLineLayout().Label.setWidth((int) (mostCurrent._ls_set_shift.getWidth()-30));
 //BA.debugLineNum = 367;BA.debugLine="ls_set_shift.SingleLineLayout.Label.Typeface=Type";
mostCurrent._ls_set_shift.getSingleLineLayout().Label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(mostCurrent._myfunc._font_filename /*String*/ (mostCurrent.activityBA)));
 //BA.debugLineNum = 370;BA.debugLine="Lb = Array As Label(lbl0,lb1,lb2,lb3,lb4,lb5,lb6,";
mostCurrent._lb = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._lbl0,mostCurrent._lb1,mostCurrent._lb2,mostCurrent._lb3,mostCurrent._lb4,mostCurrent._lb5,mostCurrent._lb6,mostCurrent._lb7,mostCurrent._lb8,mostCurrent._lb9,mostCurrent._lb10,mostCurrent._lb11,mostCurrent._lb12,mostCurrent._lb13,mostCurrent._lb14,mostCurrent._lb15,mostCurrent._lb16,mostCurrent._lb17,mostCurrent._lb18,mostCurrent._lb19,mostCurrent._lb20,mostCurrent._lb21,mostCurrent._lb22,mostCurrent._lb23,mostCurrent._lb24,mostCurrent._lb25,mostCurrent._lb26,mostCurrent._lb27,mostCurrent._lb28,mostCurrent._lb29,mostCurrent._lb30,mostCurrent._lb31,mostCurrent._lb32,mostCurrent._lb33,mostCurrent._lb34,mostCurrent._lb35,mostCurrent._lb36,mostCurrent._lb37,mostCurrent._lb38,mostCurrent._lb39,mostCurrent._lb40,mostCurrent._lb41,mostCurrent._lb42};
 //BA.debugLineNum = 372;BA.debugLine="PA = Array As Panel(p0,p1,p2,p3,p4,p5,p6,p7,p8,p9";
mostCurrent._pa = new anywheresoftware.b4a.objects.PanelWrapper[]{mostCurrent._p0,mostCurrent._p1,mostCurrent._p2,mostCurrent._p3,mostCurrent._p4,mostCurrent._p5,mostCurrent._p6,mostCurrent._p7,mostCurrent._p8,mostCurrent._p9,mostCurrent._p10,mostCurrent._p11,mostCurrent._p12,mostCurrent._p13,mostCurrent._p14,mostCurrent._p15,mostCurrent._p16,mostCurrent._p17,mostCurrent._p18,mostCurrent._p19,mostCurrent._p20,mostCurrent._p21,mostCurrent._p22,mostCurrent._p23,mostCurrent._p24,mostCurrent._p25,mostCurrent._p26,mostCurrent._p27,mostCurrent._p28,mostCurrent._p29,mostCurrent._p30,mostCurrent._p31,mostCurrent._p32,mostCurrent._p33,mostCurrent._p34,mostCurrent._p35,mostCurrent._p36,mostCurrent._p37,mostCurrent._p38,mostCurrent._p39,mostCurrent._p40,mostCurrent._p41,mostCurrent._p42};
 //BA.debugLineNum = 374;BA.debugLine="SH = Array As Label(sh0,sh1,sh2,sh3,sh4,sh5,sh6,s";
mostCurrent._sh = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._sh0,mostCurrent._sh1,mostCurrent._sh2,mostCurrent._sh3,mostCurrent._sh4,mostCurrent._sh5,mostCurrent._sh6,mostCurrent._sh7,mostCurrent._sh8,mostCurrent._sh9,mostCurrent._sh10,mostCurrent._sh11,mostCurrent._sh12,mostCurrent._sh13,mostCurrent._sh14,mostCurrent._sh15,mostCurrent._sh16,mostCurrent._sh17,mostCurrent._sh18,mostCurrent._sh19,mostCurrent._sh20,mostCurrent._sh21,mostCurrent._sh22,mostCurrent._sh23,mostCurrent._sh24,mostCurrent._sh25,mostCurrent._sh26,mostCurrent._sh27,mostCurrent._sh28,mostCurrent._sh29,mostCurrent._sh30,mostCurrent._sh31,mostCurrent._sh32,mostCurrent._sh33,mostCurrent._sh34,mostCurrent._sh35,mostCurrent._sh36,mostCurrent._sh37,mostCurrent._sh38,mostCurrent._sh39,mostCurrent._sh40,mostCurrent._sh41,mostCurrent._sh42};
 //BA.debugLineNum = 376;BA.debugLine="EZ = Array As Label (ez0,ez1,ez2,ez3,ez4,ez5,ez6,";
mostCurrent._ez = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._ez0,mostCurrent._ez1,mostCurrent._ez2,mostCurrent._ez3,mostCurrent._ez4,mostCurrent._ez5,mostCurrent._ez6,mostCurrent._ez7,mostCurrent._ez8,mostCurrent._ez9,mostCurrent._ez10,mostCurrent._ez11,mostCurrent._ez12,mostCurrent._ez13,mostCurrent._ez14,mostCurrent._ez15,mostCurrent._ez16,mostCurrent._ez17,mostCurrent._ez18,mostCurrent._ez19,mostCurrent._ez20,mostCurrent._ez21,mostCurrent._ez22,mostCurrent._ez23,mostCurrent._ez24,mostCurrent._ez25,mostCurrent._ez26,mostCurrent._ez27,mostCurrent._ez28,mostCurrent._ez29,mostCurrent._ez30,mostCurrent._ez31,mostCurrent._ez32,mostCurrent._ez33,mostCurrent._ez34,mostCurrent._ez35,mostCurrent._ez36,mostCurrent._ez37,mostCurrent._ez38,mostCurrent._ez39,mostCurrent._ez40,mostCurrent._ez41,mostCurrent._ez42};
 //BA.debugLineNum = 379;BA.debugLine="NO = Array As Label (no0,no1,no2,no3,no4,no5,no6,";
mostCurrent._no = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._no0,mostCurrent._no1,mostCurrent._no2,mostCurrent._no3,mostCurrent._no4,mostCurrent._no5,mostCurrent._no6,mostCurrent._no7,mostCurrent._no8,mostCurrent._no9,mostCurrent._no10,mostCurrent._no11,mostCurrent._no12,mostCurrent._no13,mostCurrent._no14,mostCurrent._no15,mostCurrent._no16,mostCurrent._no17,mostCurrent._no18,mostCurrent._no19,mostCurrent._no20,mostCurrent._no21,mostCurrent._no22,mostCurrent._no23,mostCurrent._no24,mostCurrent._no25,mostCurrent._no26,mostCurrent._no27,mostCurrent._no28,mostCurrent._no29,mostCurrent._no30,mostCurrent._no31,mostCurrent._no32,mostCurrent._no33,mostCurrent._no34,mostCurrent._no35,mostCurrent._no36,mostCurrent._no37,mostCurrent._no38,mostCurrent._no39,mostCurrent._no40,mostCurrent._no41,mostCurrent._no42};
 //BA.debugLineNum = 386;BA.debugLine="sp_noe_shift.AddAll(Array As String(\"روزکار(ر)\",\"";
mostCurrent._sp_noe_shift.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"روزکار(ر)","عصرکار(ع)","شبکار(ش)","استراحت(ا)"}));
 //BA.debugLineNum = 390;BA.debugLine="this_year=date.PersianYear";
_this_year = mostCurrent._date.getPersianYear();
 //BA.debugLineNum = 391;BA.debugLine="this_moon =date.PersianMonth";
_this_moon = mostCurrent._date.getPersianMonth();
 //BA.debugLineNum = 392;BA.debugLine="this_day =date.PersianDay";
_this_day = mostCurrent._date.getPersianDay();
 //BA.debugLineNum = 395;BA.debugLine="current_moon=date.PersianMonth";
_current_moon = mostCurrent._date.getPersianMonth();
 //BA.debugLineNum = 397;BA.debugLine="lbl_year_tagvim.Text=this_year";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_this_year));
 //BA.debugLineNum = 408;BA.debugLine="rsPOP_year_tagvim.Initialize(\"rsPOP_year_tagvim\",";
mostCurrent._rspop_year_tagvim.Initialize(mostCurrent.activityBA,"rsPOP_year_tagvim",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_year_tagvim.getObject())));
 //BA.debugLineNum = 410;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1398,1398,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1398),(int) (1398),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1398"));
 //BA.debugLineNum = 411;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1399,1399,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1399),(int) (1399),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1399"));
 //BA.debugLineNum = 412;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1400,1400,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1400),(int) (1400),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1400"));
 //BA.debugLineNum = 413;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1401,1401,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1401),(int) (1401),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1401"));
 //BA.debugLineNum = 414;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1402,1402,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1402),(int) (1402),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1402"));
 //BA.debugLineNum = 415;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1403,1403,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1403),(int) (1403),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1403"));
 //BA.debugLineNum = 417;BA.debugLine="rsPOP_moon_tagvim.Initialize(\"rsPOP_moon_tagvim\",";
mostCurrent._rspop_moon_tagvim.Initialize(mostCurrent.activityBA,"rsPOP_moon_tagvim",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_moon_name.getObject())));
 //BA.debugLineNum = 420;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(1,1,\"فروردین\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (1),(int) (1),"فروردین");
 //BA.debugLineNum = 421;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(2,2,\"اردیبهشت\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (2),(int) (2),"اردیبهشت");
 //BA.debugLineNum = 422;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(3,3,\"خرداد\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (3),(int) (3),"خرداد");
 //BA.debugLineNum = 423;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(4,4,\"تیر\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (4),(int) (4),"تیر");
 //BA.debugLineNum = 424;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(5,5,\"مرداد\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (5),(int) (5),"مرداد");
 //BA.debugLineNum = 425;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(6,6,\"شهریور\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (6),(int) (6),"شهریور");
 //BA.debugLineNum = 426;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(7,7,\"مهر\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (7),(int) (7),"مهر");
 //BA.debugLineNum = 427;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(8,8,\"آبان\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (8),(int) (8),"آبان");
 //BA.debugLineNum = 428;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(9,9,\"آذر\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (9),(int) (9),"آذر");
 //BA.debugLineNum = 429;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(10,10,\"دی\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (10),(int) (10),"دی");
 //BA.debugLineNum = 430;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(11,11,\"بهمن\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (11),(int) (11),"بهمن");
 //BA.debugLineNum = 431;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(12,12,\"اسفند\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (12),(int) (12),"اسفند");
 //BA.debugLineNum = 439;BA.debugLine="rsPOP_year.Initialize(\"rsPOP_year\",lbl_years)";
mostCurrent._rspop_year.Initialize(mostCurrent.activityBA,"rsPOP_year",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_years.getObject())));
 //BA.debugLineNum = 441;BA.debugLine="rsPOP_year.AddMenuItem(1398,1398,myfunc.en2fa(\"13";
mostCurrent._rspop_year.AddMenuItem((int) (1398),(int) (1398),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1398"));
 //BA.debugLineNum = 442;BA.debugLine="rsPOP_year.AddMenuItem(1399,1399,myfunc.en2fa(\"13";
mostCurrent._rspop_year.AddMenuItem((int) (1399),(int) (1399),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1399"));
 //BA.debugLineNum = 443;BA.debugLine="rsPOP_year.AddMenuItem(1400,1400,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1400),(int) (1400),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1400"));
 //BA.debugLineNum = 444;BA.debugLine="rsPOP_year.AddMenuItem(1401,1401,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1401),(int) (1401),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1401"));
 //BA.debugLineNum = 445;BA.debugLine="rsPOP_year.AddMenuItem(1402,1402,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1402),(int) (1402),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1402"));
 //BA.debugLineNum = 446;BA.debugLine="rsPOP_year.AddMenuItem(1403,1403,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1403),(int) (1403),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1403"));
 //BA.debugLineNum = 448;BA.debugLine="rsPOP_mah.Initialize(\"rsPOP_mah\",lbl_mah)";
mostCurrent._rspop_mah.Initialize(mostCurrent.activityBA,"rsPOP_mah",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_mah.getObject())));
 //BA.debugLineNum = 450;BA.debugLine="lbl_mah_tagID=1";
_lbl_mah_tagid = (int) (1);
 //BA.debugLineNum = 452;BA.debugLine="rsPOP_mah.AddMenuItem(1,1,\"فروردین\")";
mostCurrent._rspop_mah.AddMenuItem((int) (1),(int) (1),"فروردین");
 //BA.debugLineNum = 453;BA.debugLine="rsPOP_mah.AddMenuItem(2,2,\"اردیبهشت\")";
mostCurrent._rspop_mah.AddMenuItem((int) (2),(int) (2),"اردیبهشت");
 //BA.debugLineNum = 454;BA.debugLine="rsPOP_mah.AddMenuItem(3,3,\"خرداد\")";
mostCurrent._rspop_mah.AddMenuItem((int) (3),(int) (3),"خرداد");
 //BA.debugLineNum = 455;BA.debugLine="rsPOP_mah.AddMenuItem(4,4,\"تیر\")";
mostCurrent._rspop_mah.AddMenuItem((int) (4),(int) (4),"تیر");
 //BA.debugLineNum = 456;BA.debugLine="rsPOP_mah.AddMenuItem(5,5,\"مرداد\")";
mostCurrent._rspop_mah.AddMenuItem((int) (5),(int) (5),"مرداد");
 //BA.debugLineNum = 457;BA.debugLine="rsPOP_mah.AddMenuItem(6,6,\"شهریور\")";
mostCurrent._rspop_mah.AddMenuItem((int) (6),(int) (6),"شهریور");
 //BA.debugLineNum = 458;BA.debugLine="rsPOP_mah.AddMenuItem(7,7,\"مهر\")";
mostCurrent._rspop_mah.AddMenuItem((int) (7),(int) (7),"مهر");
 //BA.debugLineNum = 459;BA.debugLine="rsPOP_mah.AddMenuItem(8,8,\"آبان\")";
mostCurrent._rspop_mah.AddMenuItem((int) (8),(int) (8),"آبان");
 //BA.debugLineNum = 460;BA.debugLine="rsPOP_mah.AddMenuItem(9,9,\"آذر\")";
mostCurrent._rspop_mah.AddMenuItem((int) (9),(int) (9),"آذر");
 //BA.debugLineNum = 461;BA.debugLine="rsPOP_mah.AddMenuItem(10,10,\"دی\")";
mostCurrent._rspop_mah.AddMenuItem((int) (10),(int) (10),"دی");
 //BA.debugLineNum = 462;BA.debugLine="rsPOP_mah.AddMenuItem(11,11,\"بهمن\")";
mostCurrent._rspop_mah.AddMenuItem((int) (11),(int) (11),"بهمن");
 //BA.debugLineNum = 463;BA.debugLine="rsPOP_mah.AddMenuItem(12,12,\"اسفند\")";
mostCurrent._rspop_mah.AddMenuItem((int) (12),(int) (12),"اسفند");
 //BA.debugLineNum = 466;BA.debugLine="rsPOP_roz.Initialize(\"rsPOP_roz\",lbl_roz)";
mostCurrent._rspop_roz.Initialize(mostCurrent.activityBA,"rsPOP_roz",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_roz.getObject())));
 //BA.debugLineNum = 469;BA.debugLine="For i=1 To 31";
{
final int step76 = 1;
final int limit76 = (int) (31);
_i = (int) (1) ;
for (;_i <= limit76 ;_i = _i + step76 ) {
 //BA.debugLineNum = 471;BA.debugLine="rsPOP_roz.AddMenuItem(i,i,myfunc.en2fa(i))";
mostCurrent._rspop_roz.AddMenuItem(_i,_i,mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_i)));
 }
};
 //BA.debugLineNum = 475;BA.debugLine="rsPOP_year_end.Initialize(\"rsPOP_year_end\",lbl_ye";
mostCurrent._rspop_year_end.Initialize(mostCurrent.activityBA,"rsPOP_year_end",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_years_end.getObject())));
 //BA.debugLineNum = 477;BA.debugLine="rsPOP_year_end.AddMenuItem(1398,1398,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1398),(int) (1398),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1398"));
 //BA.debugLineNum = 478;BA.debugLine="rsPOP_year_end.AddMenuItem(1399,1399,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1399),(int) (1399),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1399"));
 //BA.debugLineNum = 479;BA.debugLine="rsPOP_year_end.AddMenuItem(1400,1400,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1400),(int) (1400),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1400"));
 //BA.debugLineNum = 480;BA.debugLine="rsPOP_year_end.AddMenuItem(1401,1401,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1401),(int) (1401),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1401"));
 //BA.debugLineNum = 481;BA.debugLine="rsPOP_year_end.AddMenuItem(1402,1402,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1402),(int) (1402),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1402"));
 //BA.debugLineNum = 482;BA.debugLine="rsPOP_year_end.AddMenuItem(1403,1403,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1403),(int) (1403),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1403"));
 //BA.debugLineNum = 485;BA.debugLine="rsPOP_mah_end.Initialize(\"rsPOP_mah_end\",lbl_mah_";
mostCurrent._rspop_mah_end.Initialize(mostCurrent.activityBA,"rsPOP_mah_end",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_mah_end.getObject())));
 //BA.debugLineNum = 487;BA.debugLine="lbl_mah_end_tagID=12";
_lbl_mah_end_tagid = (int) (12);
 //BA.debugLineNum = 489;BA.debugLine="rsPOP_mah_end.AddMenuItem(1,1,\"فروردین\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (1),(int) (1),"فروردین");
 //BA.debugLineNum = 490;BA.debugLine="rsPOP_mah_end.AddMenuItem(2,2,\"اردیبهشت\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (2),(int) (2),"اردیبهشت");
 //BA.debugLineNum = 491;BA.debugLine="rsPOP_mah_end.AddMenuItem(3,3,\"خرداد\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (3),(int) (3),"خرداد");
 //BA.debugLineNum = 492;BA.debugLine="rsPOP_mah_end.AddMenuItem(4,4,\"تیر\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (4),(int) (4),"تیر");
 //BA.debugLineNum = 493;BA.debugLine="rsPOP_mah_end.AddMenuItem(5,5,\"مرداد\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (5),(int) (5),"مرداد");
 //BA.debugLineNum = 494;BA.debugLine="rsPOP_mah_end.AddMenuItem(6,6,\"شهریور\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (6),(int) (6),"شهریور");
 //BA.debugLineNum = 495;BA.debugLine="rsPOP_mah_end.AddMenuItem(7,7,\"مهر\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (7),(int) (7),"مهر");
 //BA.debugLineNum = 496;BA.debugLine="rsPOP_mah_end.AddMenuItem(8,8,\"آبان\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (8),(int) (8),"آبان");
 //BA.debugLineNum = 497;BA.debugLine="rsPOP_mah_end.AddMenuItem(9,9,\"آذر\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (9),(int) (9),"آذر");
 //BA.debugLineNum = 498;BA.debugLine="rsPOP_mah_end.AddMenuItem(10,10,\"دی\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (10),(int) (10),"دی");
 //BA.debugLineNum = 499;BA.debugLine="rsPOP_mah_end.AddMenuItem(11,11,\"بهمن\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (11),(int) (11),"بهمن");
 //BA.debugLineNum = 500;BA.debugLine="rsPOP_mah_end.AddMenuItem(12,12,\"اسفند\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (12),(int) (12),"اسفند");
 //BA.debugLineNum = 502;BA.debugLine="rsPOP_roz_end.Initialize(\"rsPOP_roz_end\",lbl_roz_";
mostCurrent._rspop_roz_end.Initialize(mostCurrent.activityBA,"rsPOP_roz_end",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_roz_end.getObject())));
 //BA.debugLineNum = 503;BA.debugLine="For i=1 To 31";
{
final int step101 = 1;
final int limit101 = (int) (31);
_i = (int) (1) ;
for (;_i <= limit101 ;_i = _i + step101 ) {
 //BA.debugLineNum = 504;BA.debugLine="rsPOP_roz_end.AddMenuItem(i,i,myfunc.en2fa(i))";
mostCurrent._rspop_roz_end.AddMenuItem(_i,_i,mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_i)));
 }
};
 //BA.debugLineNum = 510;BA.debugLine="lbl_go_today_Click";
_lbl_go_today_click();
 //BA.debugLineNum = 512;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 513;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 515;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 740;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 741;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 742;BA.debugLine="If(pan_all_setSift.Visible=True)Then";
if ((mostCurrent._pan_all_setsift.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 743;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 744;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
 }else if((mostCurrent._pan_all_note.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 747;BA.debugLine="pan_all_note.Visible=False";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 749;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 //BA.debugLineNum = 752;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 754;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 756;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 729;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 731;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 725;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 727;BA.debugLine="End Sub";
return "";
}
public static String  _checkbox_tatil_garardadi_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 1525;BA.debugLine="Private Sub CheckBox_tatil_garardadi_CheckedChange";
 //BA.debugLineNum = 1526;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1527;BA.debugLine="If(Checked=True)Then";
if ((_checked==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1529;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' se";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set state='tatil1' WHERE id="+BA.NumberToString(_selectedday_id));
 }else {
 //BA.debugLineNum = 1533;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' se";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set state='' WHERE id="+BA.NumberToString(_selectedday_id));
 };
 //BA.debugLineNum = 1536;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,lbl_moon_nam";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())));
 //BA.debugLineNum = 1538;BA.debugLine="pan_all_menu_day_Click";
_pan_all_menu_day_click();
 //BA.debugLineNum = 1539;BA.debugLine="ToastMessageShow(\" ذخیره شد\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" ذخیره شد"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1540;BA.debugLine="End Sub";
return "";
}
public static String  _generat_taghvim(int _year,int _moon) throws Exception{
int _d = 0;
int _count_day_moon = 0;
int _i = 0;
int _j = 0;
int _counter = 0;
int _f = 0;
 //BA.debugLineNum = 931;BA.debugLine="Sub generat_taghvim(year As Int , moon As Int)";
 //BA.debugLineNum = 932;BA.debugLine="Try";
try { //BA.debugLineNum = 935;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 939;BA.debugLine="For d=0 To PA.Length-1";
{
final int step3 = 1;
final int limit3 = (int) (mostCurrent._pa.length-1);
_d = (int) (0) ;
for (;_d <= limit3 ;_d = _d + step3 ) {
 //BA.debugLineNum = 940;BA.debugLine="PA(d).Visible=True";
mostCurrent._pa[_d].setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 941;BA.debugLine="PA(d).Color=0xFFEFEFEF";
mostCurrent._pa[_d].setColor(((int)0xffefefef));
 //BA.debugLineNum = 944;BA.debugLine="EZ(d).Text=\"\"";
mostCurrent._ez[_d].setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 945;BA.debugLine="NO(d).Text=\"\"";
mostCurrent._no[_d].setText(BA.ObjectToCharSequence(""));
 }
};
 //BA.debugLineNum = 949;BA.debugLine="ls_shift_moon.Clear";
mostCurrent._ls_shift_moon.Clear();
 //BA.debugLineNum = 950;BA.debugLine="ls_tatili_moon.Clear";
mostCurrent._ls_tatili_moon.Clear();
 //BA.debugLineNum = 951;BA.debugLine="ls_tatili_custom_moon.Clear";
mostCurrent._ls_tatili_custom_moon.Clear();
 //BA.debugLineNum = 952;BA.debugLine="ls_note_moon.Clear";
mostCurrent._ls_note_moon.Clear();
 //BA.debugLineNum = 954;BA.debugLine="Dim count_day_moon As Int";
_count_day_moon = 0;
 //BA.debugLineNum = 956;BA.debugLine="current_moon=moon";
_current_moon = _moon;
 //BA.debugLineNum = 957;BA.debugLine="lbl_moon_name.Tag=moon";
mostCurrent._lbl_moon_name.setTag((Object)(_moon));
 //BA.debugLineNum = 958;BA.debugLine="lbl_year_tagvim.Text=year";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_year));
 //BA.debugLineNum = 960;BA.debugLine="Select moon";
switch (_moon) {
case 1: {
 //BA.debugLineNum = 962;BA.debugLine="lbl_moon_name.Text=\"فروردین\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("فروردین"));
 break; }
case 2: {
 //BA.debugLineNum = 964;BA.debugLine="lbl_moon_name.Text=\"اردیبهشت\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("اردیبهشت"));
 break; }
case 3: {
 //BA.debugLineNum = 966;BA.debugLine="lbl_moon_name.Text=\"خرداد\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("خرداد"));
 break; }
case 4: {
 //BA.debugLineNum = 968;BA.debugLine="lbl_moon_name.Text=\"تیر\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("تیر"));
 break; }
case 5: {
 //BA.debugLineNum = 970;BA.debugLine="lbl_moon_name.Text=\"مرداد\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("مرداد"));
 break; }
case 6: {
 //BA.debugLineNum = 972;BA.debugLine="lbl_moon_name.Text=\"شهریور\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("شهریور"));
 break; }
case 7: {
 //BA.debugLineNum = 974;BA.debugLine="lbl_moon_name.Text=\"مهر\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("مهر"));
 break; }
case 8: {
 //BA.debugLineNum = 976;BA.debugLine="lbl_moon_name.Text=\"آبان\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("آبان"));
 break; }
case 9: {
 //BA.debugLineNum = 978;BA.debugLine="lbl_moon_name.Text=\"آذر\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("آذر"));
 break; }
case 10: {
 //BA.debugLineNum = 980;BA.debugLine="lbl_moon_name.Text=\"دی\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("دی"));
 break; }
case 11: {
 //BA.debugLineNum = 982;BA.debugLine="lbl_moon_name.Text=\"بهمن\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("بهمن"));
 break; }
case 12: {
 //BA.debugLineNum = 984;BA.debugLine="lbl_moon_name.Text=\"اسفند\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("اسفند"));
 break; }
}
;
 //BA.debugLineNum = 990;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE year="+BA.NumberToString(_year)+" AND moon="+BA.NumberToString(_moon)+" ;")));
 //BA.debugLineNum = 994;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
 //BA.debugLineNum = 996;BA.debugLine="count_day_moon=dbCode.res.RowCount";
_count_day_moon = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount();
 //BA.debugLineNum = 997;BA.debugLine="dbCode.res.Position =0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 998;BA.debugLine="start_day=dbCode.res.Getint(\"day_h\")";
_start_day = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_h");
 //BA.debugLineNum = 1001;BA.debugLine="For i=0 To dbCode.res.RowCount-1";
{
final int step48 = 1;
final int limit48 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit48 ;_i = _i + step48 ) {
 //BA.debugLineNum = 1002;BA.debugLine="dbCode.res.Position =i";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_i);
 //BA.debugLineNum = 1004;BA.debugLine="If (dbCode.res.GetString(\"shift\") = Null)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")== null)) { 
 //BA.debugLineNum = 1005;BA.debugLine="ls_shift_moon.Add(\"\")";
mostCurrent._ls_shift_moon.Add((Object)(""));
 }else {
 //BA.debugLineNum = 1007;BA.debugLine="ls_shift_moon.Add(dbCode.res.GetString(\"shift";
mostCurrent._ls_shift_moon.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")));
 };
 //BA.debugLineNum = 1011;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Th";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
 //BA.debugLineNum = 1012;BA.debugLine="ls_tatili_moon.Add(True)";
mostCurrent._ls_tatili_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.True));
 }else {
 //BA.debugLineNum = 1014;BA.debugLine="ls_tatili_moon.Add(False)";
mostCurrent._ls_tatili_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.False));
 };
 //BA.debugLineNum = 1018;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil1\")T";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil1"))) { 
 //BA.debugLineNum = 1019;BA.debugLine="ls_tatili_custom_moon.Add(True)";
mostCurrent._ls_tatili_custom_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.True));
 }else {
 //BA.debugLineNum = 1021;BA.debugLine="ls_tatili_custom_moon.Add(False)";
mostCurrent._ls_tatili_custom_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.False));
 };
 //BA.debugLineNum = 1025;BA.debugLine="If (dbCode.res.GetString(\"note\") = \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")).equals(""))) { 
 //BA.debugLineNum = 1026;BA.debugLine="ls_note_moon.Add(False)";
mostCurrent._ls_note_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.False));
 }else {
 //BA.debugLineNum = 1028;BA.debugLine="ls_note_moon.Add(True)";
mostCurrent._ls_note_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.True));
 };
 }
};
 }else {
 //BA.debugLineNum = 1037;BA.debugLine="Log(\"nooop data\")";
anywheresoftware.b4a.keywords.Common.LogImpl("129294698","nooop data",0);
 };
 //BA.debugLineNum = 1042;BA.debugLine="For  j=start_day-1 To 0 Step -1";
{
final int step74 = -1;
final int limit74 = (int) (0);
_j = (int) (_start_day-1) ;
for (;_j >= limit74 ;_j = _j + step74 ) {
 //BA.debugLineNum = 1043;BA.debugLine="PA(j).Visible=False";
mostCurrent._pa[_j].setVisible(anywheresoftware.b4a.keywords.Common.False);
 }
};
 //BA.debugLineNum = 1048;BA.debugLine="Dim counter As Int=1";
_counter = (int) (1);
 //BA.debugLineNum = 1050;BA.debugLine="For i = start_day To count_day_moon+start_day";
{
final int step78 = 1;
final int limit78 = (int) (_count_day_moon+_start_day);
_i = _start_day ;
for (;_i <= limit78 ;_i = _i + step78 ) {
 //BA.debugLineNum = 1056;BA.debugLine="Lb(i).Text=counter";
mostCurrent._lb[_i].setText(BA.ObjectToCharSequence(_counter));
 //BA.debugLineNum = 1057;BA.debugLine="PA(i).Tag=counter";
mostCurrent._pa[_i].setTag((Object)(_counter));
 //BA.debugLineNum = 1062;BA.debugLine="If(counter-1 < count_day_moon)Then";
if ((_counter-1<_count_day_moon)) { 
 //BA.debugLineNum = 1063;BA.debugLine="SH(i).Text=ls_shift_moon.Get(counter-1)  ''---s";
mostCurrent._sh[_i].setText(BA.ObjectToCharSequence(mostCurrent._ls_shift_moon.Get((int) (_counter-1))));
 //BA.debugLineNum = 1064;BA.debugLine="If(SH(i).Text=\"ر\")Then";
if (((mostCurrent._sh[_i].getText()).equals("ر"))) { 
 //BA.debugLineNum = 1065;BA.debugLine="SH(i).Color=0x96FFFA00";
mostCurrent._sh[_i].setColor(((int)0x96fffa00));
 }else if(((mostCurrent._sh[_i].getText()).equals("ع"))) { 
 //BA.debugLineNum = 1067;BA.debugLine="SH(i).Color=0x960066FF";
mostCurrent._sh[_i].setColor(((int)0x960066ff));
 }else if(((mostCurrent._sh[_i].getText()).equals("ش"))) { 
 //BA.debugLineNum = 1069;BA.debugLine="SH(i).Color=0x96414141";
mostCurrent._sh[_i].setColor(((int)0x96414141));
 }else if(((mostCurrent._sh[_i].getText()).equals("ا"))) { 
 //BA.debugLineNum = 1071;BA.debugLine="SH(i).Color=0x9600FF24";
mostCurrent._sh[_i].setColor(((int)0x9600ff24));
 }else {
 //BA.debugLineNum = 1073;BA.debugLine="SH(i).Color=Colors.Transparent";
mostCurrent._sh[_i].setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 };
 //BA.debugLineNum = 1079;BA.debugLine="If(ls_tatili_moon.Get(counter-1)=True)Then";
if (((mostCurrent._ls_tatili_moon.Get((int) (_counter-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
 //BA.debugLineNum = 1080;BA.debugLine="PA(i).Color=0xFFFF5252";
mostCurrent._pa[_i].setColor(((int)0xffff5252));
 };
 //BA.debugLineNum = 1084;BA.debugLine="If(ls_tatili_custom_moon.Get(counter-1)=True)T";
if (((mostCurrent._ls_tatili_custom_moon.Get((int) (_counter-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
 //BA.debugLineNum = 1085;BA.debugLine="PA(i).Color=0xFF00BB8B";
mostCurrent._pa[_i].setColor(((int)0xff00bb8b));
 };
 //BA.debugLineNum = 1089;BA.debugLine="If(ls_note_moon.Get(counter-1)=True)Then";
if (((mostCurrent._ls_note_moon.Get((int) (_counter-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
 //BA.debugLineNum = 1090;BA.debugLine="NO(i).Text=\"•\"";
mostCurrent._no[_i].setText(BA.ObjectToCharSequence("•"));
 //BA.debugLineNum = 1091;BA.debugLine="NO(i).textColor=Colors.Blue";
mostCurrent._no[_i].setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 };
 //BA.debugLineNum = 1096;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(year&\"/\"&my";
if ((mostCurrent._dbcode._isexist_ezafekari_by_date /*boolean*/ (mostCurrent.activityBA,BA.NumberToString(_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_counter))==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1097;BA.debugLine="EZ(i).Text=\"*\"";
mostCurrent._ez[_i].setText(BA.ObjectToCharSequence("*"));
 //BA.debugLineNum = 1098;BA.debugLine="EZ(i).TextColor=0xFF00941C";
mostCurrent._ez[_i].setTextColor(((int)0xff00941c));
 }else if((mostCurrent._dbcode._isexist_morakhasi_by_date /*boolean*/ (mostCurrent.activityBA,BA.NumberToString(_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_counter))==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1100;BA.debugLine="EZ(i).Text=\"*\"";
mostCurrent._ez[_i].setText(BA.ObjectToCharSequence("*"));
 //BA.debugLineNum = 1101;BA.debugLine="EZ(i).TextColor=0xFFFF5200";
mostCurrent._ez[_i].setTextColor(((int)0xffff5200));
 }else if((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,BA.NumberToString(_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_counter))==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1103;BA.debugLine="EZ(i).Text=\"*\"";
mostCurrent._ez[_i].setText(BA.ObjectToCharSequence("*"));
 //BA.debugLineNum = 1104;BA.debugLine="EZ(i).TextColor=0xFFFF5200";
mostCurrent._ez[_i].setTextColor(((int)0xffff5200));
 };
 };
 //BA.debugLineNum = 1113;BA.debugLine="If(counter=this_day And moon=date.PersianMonth A";
if ((_counter==_this_day && _moon==mostCurrent._date.getPersianMonth() && _year==_this_year)) { 
 //BA.debugLineNum = 1116;BA.debugLine="Lb(i).TextColor=0xFFFF9000";
mostCurrent._lb[_i].setTextColor(((int)0xffff9000));
 //BA.debugLineNum = 1117;BA.debugLine="index_i_today=i";
_index_i_today = _i;
 };
 //BA.debugLineNum = 1120;BA.debugLine="If(counter>=count_day_moon)Then";
if ((_counter>=_count_day_moon)) { 
 //BA.debugLineNum = 1122;BA.debugLine="For f=i+1 To Lb.Length-1";
{
final int step120 = 1;
final int limit120 = (int) (mostCurrent._lb.length-1);
_f = (int) (_i+1) ;
for (;_f <= limit120 ;_f = _f + step120 ) {
 //BA.debugLineNum = 1123;BA.debugLine="PA(f).Visible=False";
mostCurrent._pa[_f].setVisible(anywheresoftware.b4a.keywords.Common.False);
 }
};
 };
 //BA.debugLineNum = 1129;BA.debugLine="counter=counter+1";
_counter = (int) (_counter+1);
 }
};
 } 
       catch (Exception e127) {
			processBA.setLastException(e127); //BA.debugLineNum = 1133;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("129294794",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 1137;BA.debugLine="End Sub";
return "";
}
public static String  _get_ezafekari(String _date1) throws Exception{
anywheresoftware.b4a.objects.collections.List _ezlist = null;
String _newline = "";
int _k = 0;
anywheresoftware.b4a.objects.collections.List _ls_time_conv = null;
int _i = 0;
 //BA.debugLineNum = 857;BA.debugLine="Sub get_ezafekari(date1 As String)";
 //BA.debugLineNum = 858;BA.debugLine="lbl_ezafekari_day.Text=\"\"";
mostCurrent._lbl_ezafekari_day.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 859;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 860;BA.debugLine="Dim ezList As List";
_ezlist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 861;BA.debugLine="ezList.Initialize";
_ezlist.Initialize();
 //BA.debugLineNum = 862;BA.debugLine="Dim newLine As String=\"\"";
_newline = "";
 //BA.debugLineNum = 864;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"+_date1+"';")));
 //BA.debugLineNum = 866;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
 //BA.debugLineNum = 867;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_k = (int) (0) ;
for (;_k <= limit8 ;_k = _k + step8 ) {
 //BA.debugLineNum = 868;BA.debugLine="dbCode.res.Position=K";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_k);
 //BA.debugLineNum = 871;BA.debugLine="Dim ls_time_conv As List";
_ls_time_conv = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 872;BA.debugLine="ls_time_conv.Initialize";
_ls_time_conv.Initialize();
 //BA.debugLineNum = 873;BA.debugLine="ls_time_conv=myfunc.Min_to_saatMinRoz2_dontDay(";
_ls_time_conv = mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_m"));
 //BA.debugLineNum = 876;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
_ezlist.Add((Object)(_newline+"از "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" تا "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+"  ( "+BA.ObjectToString(_ls_time_conv.Get((int) (0)))+":"+BA.ObjectToString(_ls_time_conv.Get((int) (1)))+")"));
 //BA.debugLineNum = 877;BA.debugLine="newLine=CRLF";
_newline = anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 }else {
 //BA.debugLineNum = 883;BA.debugLine="ezList.Add(\"-\")";
_ezlist.Add((Object)("-"));
 };
 //BA.debugLineNum = 886;BA.debugLine="For i=0 To ezList.Size-1";
{
final int step19 = 1;
final int limit19 = (int) (_ezlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit19 ;_i = _i + step19 ) {
 //BA.debugLineNum = 887;BA.debugLine="lbl_ezafekari_day.Text=lbl_ezafekari_day.Text &";
mostCurrent._lbl_ezafekari_day.setText(BA.ObjectToCharSequence(mostCurrent._lbl_ezafekari_day.getText()+BA.ObjectToString(_ezlist.Get(_i))));
 }
};
 //BA.debugLineNum = 890;BA.debugLine="End Sub";
return "";
}
public static String  _get_monasebat(int _id) throws Exception{
String _str_sh = "";
 //BA.debugLineNum = 764;BA.debugLine="Sub get_monasebat ( id As Int)";
 //BA.debugLineNum = 765;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 766;BA.debugLine="lbl_today_monasebat.Text=\"\"";
mostCurrent._lbl_today_monasebat.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 767;BA.debugLine="lbl_today.Text=\"\"";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 769;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
 //BA.debugLineNum = 772;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 776;BA.debugLine="If(dbCode.res.GetString(\"monasebat\")<> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("monasebat")).equals("") == false)) { 
 //BA.debugLineNum = 777;BA.debugLine="lbl_today_monasebat.Text=dbCode.res.GetString(\"m";
mostCurrent._lbl_today_monasebat.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("monasebat")));
 };
 //BA.debugLineNum = 781;BA.debugLine="lbl_today.Text=lbl_year_tagvim.Text&\"/\"&dbCode.re";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("moon")+"/"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_c"))));
 //BA.debugLineNum = 784;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
 //BA.debugLineNum = 785;BA.debugLine="lbl_today.Text=lbl_today.Text&\" (تعطیل) \"";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_today.getText()+" (تعطیل) "));
 };
 //BA.debugLineNum = 788;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil1\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil1"))) { 
 //BA.debugLineNum = 789;BA.debugLine="lbl_today.Text=lbl_today.Text&\" ( تعطیل قراردادی";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_today.getText()+" ( تعطیل قراردادی) "));
 };
 //BA.debugLineNum = 792;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")).equals("") == false)) { 
 //BA.debugLineNum = 793;BA.debugLine="Dim str_sh As String";
_str_sh = "";
 //BA.debugLineNum = 794;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift"),"ر","ش","ع","ا")) {
case 0: {
 //BA.debugLineNum = 796;BA.debugLine="str_sh=\"روزکار\"";
_str_sh = "روزکار";
 break; }
case 1: {
 //BA.debugLineNum = 798;BA.debugLine="str_sh=\"شبکار\"";
_str_sh = "شبکار";
 break; }
case 2: {
 //BA.debugLineNum = 800;BA.debugLine="str_sh=\"عصرکار\"";
_str_sh = "عصرکار";
 break; }
case 3: {
 //BA.debugLineNum = 802;BA.debugLine="str_sh=\"استراحت\"";
_str_sh = "استراحت";
 break; }
}
;
 //BA.debugLineNum = 805;BA.debugLine="lbl_today.Text=lbl_today.Text&\"- (( شیفت : \"&str";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_today.getText()+"- (( شیفت : "+_str_sh+" )) "));
 };
 //BA.debugLineNum = 809;BA.debugLine="End Sub";
return "";
}
public static String  _get_morakhasi(String _date1) throws Exception{
anywheresoftware.b4a.objects.collections.List _ezlist = null;
String _newline = "";
int _k = 0;
anywheresoftware.b4a.objects.collections.List _ls_time_conv = null;
int _i = 0;
 //BA.debugLineNum = 892;BA.debugLine="Sub get_morakhasi(date1 As String)";
 //BA.debugLineNum = 893;BA.debugLine="lbl_morakhasi_day.Text=\"\"";
mostCurrent._lbl_morakhasi_day.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 894;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 895;BA.debugLine="Dim ezList As List";
_ezlist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 896;BA.debugLine="ezList.Initialize";
_ezlist.Initialize();
 //BA.debugLineNum = 897;BA.debugLine="Dim newLine As String=\"\"";
_newline = "";
 //BA.debugLineNum = 899;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"+_date1+"';")));
 //BA.debugLineNum = 901;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
 //BA.debugLineNum = 902;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_k = (int) (0) ;
for (;_k <= limit8 ;_k = _k + step8 ) {
 //BA.debugLineNum = 903;BA.debugLine="dbCode.res.Position=K";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_k);
 //BA.debugLineNum = 905;BA.debugLine="Dim ls_time_conv As List";
_ls_time_conv = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 906;BA.debugLine="ls_time_conv.Initialize";
_ls_time_conv.Initialize();
 //BA.debugLineNum = 907;BA.debugLine="ls_time_conv=myfunc.Min_to_saatMinRoz(dbCode.re";
_ls_time_conv = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_m"));
 //BA.debugLineNum = 910;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
_ezlist.Add((Object)(_newline+"از "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" تا "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+"  ( "+BA.ObjectToString(_ls_time_conv.Get((int) (2)))+":"+BA.ObjectToString(_ls_time_conv.Get((int) (0)))+":"+BA.ObjectToString(_ls_time_conv.Get((int) (1)))+")"));
 //BA.debugLineNum = 911;BA.debugLine="newLine=CRLF";
_newline = anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 }else {
 //BA.debugLineNum = 917;BA.debugLine="ezList.Add(\"-\")";
_ezlist.Add((Object)("-"));
 };
 //BA.debugLineNum = 920;BA.debugLine="For i=0 To ezList.Size-1";
{
final int step19 = 1;
final int limit19 = (int) (_ezlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit19 ;_i = _i + step19 ) {
 //BA.debugLineNum = 921;BA.debugLine="lbl_morakhasi_day.Text=lbl_morakhasi_day.Text &";
mostCurrent._lbl_morakhasi_day.setText(BA.ObjectToCharSequence(mostCurrent._lbl_morakhasi_day.getText()+BA.ObjectToString(_ezlist.Get(_i))));
 }
};
 //BA.debugLineNum = 924;BA.debugLine="End Sub";
return "";
}
public static String  _get_note(int _id) throws Exception{
 //BA.debugLineNum = 812;BA.debugLine="Sub get_note ( id As Int)";
 //BA.debugLineNum = 813;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 814;BA.debugLine="lbl_note_day.Text=\"\"";
mostCurrent._lbl_note_day.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 817;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
 //BA.debugLineNum = 818;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 820;BA.debugLine="If(dbCode.res.GetString(\"note\")<> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")).equals("") == false)) { 
 //BA.debugLineNum = 821;BA.debugLine="lbl_note_day.Text=dbCode.res.GetString(\"note\")";
mostCurrent._lbl_note_day.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")));
 };
 //BA.debugLineNum = 824;BA.debugLine="End Sub";
return "";
}
public static String  _get_taradod(String _date1) throws Exception{
anywheresoftware.b4a.objects.collections.List _ezlist = null;
String _newline = "";
int _k = 0;
int _i = 0;
 //BA.debugLineNum = 828;BA.debugLine="Sub get_taradod(date1 As String)";
 //BA.debugLineNum = 829;BA.debugLine="lbl_taradod_day.Text=\"\"";
mostCurrent._lbl_taradod_day.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 830;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 831;BA.debugLine="Dim ezList As List";
_ezlist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 832;BA.debugLine="ezList.Initialize";
_ezlist.Initialize();
 //BA.debugLineNum = 833;BA.debugLine="Dim newLine As String=\"\"";
_newline = "";
 //BA.debugLineNum = 835;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+_date1+"';")));
 //BA.debugLineNum = 837;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
 //BA.debugLineNum = 838;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_k = (int) (0) ;
for (;_k <= limit8 ;_k = _k + step8 ) {
 //BA.debugLineNum = 839;BA.debugLine="dbCode.res.Position=K";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_k);
 //BA.debugLineNum = 841;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
_ezlist.Add((Object)(_newline+"از "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" تا "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
 //BA.debugLineNum = 842;BA.debugLine="newLine=CRLF";
_newline = anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 }else {
 //BA.debugLineNum = 846;BA.debugLine="ezList.Add(\"-\")";
_ezlist.Add((Object)("-"));
 };
 //BA.debugLineNum = 849;BA.debugLine="For i=0 To ezList.Size-1";
{
final int step16 = 1;
final int limit16 = (int) (_ezlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
 //BA.debugLineNum = 850;BA.debugLine="lbl_taradod_day.Text=lbl_taradod_day.Text & ezLi";
mostCurrent._lbl_taradod_day.setText(BA.ObjectToCharSequence(mostCurrent._lbl_taradod_day.getText()+BA.ObjectToString(_ezlist.Get(_i))));
 }
};
 //BA.debugLineNum = 853;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private pan_hed_shift As Panel";
mostCurrent._pan_hed_shift = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private lbl0 As Label ''labl 0";
mostCurrent._lbl0 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private sh0 As Label ''sh 0";
mostCurrent._sh0 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private ez0 As Label ''ez 0";
mostCurrent._ez0 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private no0 As Label ''no 0";
mostCurrent._no0 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private p0 As Panel ''panel 0";
mostCurrent._p0 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private p1 As Panel";
mostCurrent._p1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private lb1 As Label";
mostCurrent._lb1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private p2 As Panel";
mostCurrent._p2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private lb2 As Label";
mostCurrent._lb2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private p3 As Panel";
mostCurrent._p3 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private lb3 As Label";
mostCurrent._lb3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private p4 As Panel";
mostCurrent._p4 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private lb4 As Label";
mostCurrent._lb4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private p5 As Panel";
mostCurrent._p5 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private lb5 As Label";
mostCurrent._lb5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private p6 As Panel";
mostCurrent._p6 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private lb6 As Label";
mostCurrent._lb6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private p7 As Panel";
mostCurrent._p7 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private lb7 As Label";
mostCurrent._lb7 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private p8 As Panel";
mostCurrent._p8 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private lb8 As Label";
mostCurrent._lb8 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private p9 As Panel";
mostCurrent._p9 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private lb9 As Label";
mostCurrent._lb9 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private p10 As Panel";
mostCurrent._p10 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private lb10 As Label";
mostCurrent._lb10 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private p11 As Panel";
mostCurrent._p11 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private lb11 As Label";
mostCurrent._lb11 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private p12 As Panel";
mostCurrent._p12 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private lb12 As Label";
mostCurrent._lb12 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private p13 As Panel";
mostCurrent._p13 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private lb13 As Label";
mostCurrent._lb13 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private p14 As Panel";
mostCurrent._p14 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private lb14 As Label";
mostCurrent._lb14 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private p22 As Panel";
mostCurrent._p22 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private lb22 As Label";
mostCurrent._lb22 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private p23 As Panel";
mostCurrent._p23 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Private lb23 As Label";
mostCurrent._lb23 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private p24 As Panel";
mostCurrent._p24 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private lb24 As Label";
mostCurrent._lb24 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private p25 As Panel";
mostCurrent._p25 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Private lb25 As Label";
mostCurrent._lb25 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private p26 As Panel";
mostCurrent._p26 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private lb26 As Label";
mostCurrent._lb26 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Private p27 As Panel";
mostCurrent._p27 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Private lb27 As Label";
mostCurrent._lb27 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 64;BA.debugLine="Private p28 As Panel";
mostCurrent._p28 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 65;BA.debugLine="Private lb28 As Label";
mostCurrent._lb28 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 66;BA.debugLine="Private p21 As Panel";
mostCurrent._p21 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 67;BA.debugLine="Private lb21 As Label";
mostCurrent._lb21 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 68;BA.debugLine="Private p20 As Panel";
mostCurrent._p20 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 69;BA.debugLine="Private lb20 As Label";
mostCurrent._lb20 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 70;BA.debugLine="Private p19 As Panel";
mostCurrent._p19 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 71;BA.debugLine="Private lb19 As Label";
mostCurrent._lb19 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 72;BA.debugLine="Private p18 As Panel";
mostCurrent._p18 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 73;BA.debugLine="Private lb18 As Label";
mostCurrent._lb18 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 74;BA.debugLine="Private p17 As Panel";
mostCurrent._p17 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 75;BA.debugLine="Private lb17 As Label";
mostCurrent._lb17 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 76;BA.debugLine="Private p16 As Panel";
mostCurrent._p16 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 77;BA.debugLine="Private lb16 As Label";
mostCurrent._lb16 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 78;BA.debugLine="Private p15 As Panel";
mostCurrent._p15 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 79;BA.debugLine="Private lb15 As Label";
mostCurrent._lb15 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 80;BA.debugLine="Private p29 As Panel";
mostCurrent._p29 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 81;BA.debugLine="Private lb29 As Label";
mostCurrent._lb29 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 82;BA.debugLine="Private p30 As Panel";
mostCurrent._p30 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 83;BA.debugLine="Private lb30 As Label";
mostCurrent._lb30 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 84;BA.debugLine="Private p31 As Panel";
mostCurrent._p31 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 85;BA.debugLine="Private lb31 As Label";
mostCurrent._lb31 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 86;BA.debugLine="Private p32 As Panel";
mostCurrent._p32 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 87;BA.debugLine="Private lb32 As Label";
mostCurrent._lb32 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 88;BA.debugLine="Private p33 As Panel";
mostCurrent._p33 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 89;BA.debugLine="Private lb33 As Label";
mostCurrent._lb33 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 90;BA.debugLine="Private p34 As Panel";
mostCurrent._p34 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 91;BA.debugLine="Private lb34 As Label";
mostCurrent._lb34 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 92;BA.debugLine="Private p35 As Panel";
mostCurrent._p35 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 93;BA.debugLine="Private lb35 As Label";
mostCurrent._lb35 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 97;BA.debugLine="Private p36 As Panel";
mostCurrent._p36 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 98;BA.debugLine="Private lb36 As Label";
mostCurrent._lb36 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 99;BA.debugLine="Private p37 As Panel";
mostCurrent._p37 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 100;BA.debugLine="Private lb37 As Label";
mostCurrent._lb37 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 101;BA.debugLine="Private p38 As Panel";
mostCurrent._p38 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 102;BA.debugLine="Private lb38 As Label";
mostCurrent._lb38 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 103;BA.debugLine="Private p39 As Panel";
mostCurrent._p39 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 104;BA.debugLine="Private lb39 As Label";
mostCurrent._lb39 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 105;BA.debugLine="Private p40 As Panel";
mostCurrent._p40 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 106;BA.debugLine="Private lb40 As Label";
mostCurrent._lb40 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 107;BA.debugLine="Private p41 As Panel";
mostCurrent._p41 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 108;BA.debugLine="Private lb41 As Label";
mostCurrent._lb41 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 109;BA.debugLine="Private p42 As Panel";
mostCurrent._p42 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 110;BA.debugLine="Private lb42 As Label";
mostCurrent._lb42 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 111;BA.debugLine="Private lbl_moon_name As Label";
mostCurrent._lbl_moon_name = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 112;BA.debugLine="Dim current_moon As Int";
_current_moon = 0;
 //BA.debugLineNum = 113;BA.debugLine="Dim Lb() As Label";
mostCurrent._lb = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = mostCurrent._lb.length;
for (int i0 = 0;i0 < d0;i0++) {
mostCurrent._lb[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
 //BA.debugLineNum = 114;BA.debugLine="Dim PA() As Panel";
mostCurrent._pa = new anywheresoftware.b4a.objects.PanelWrapper[(int) (0)];
{
int d0 = mostCurrent._pa.length;
for (int i0 = 0;i0 < d0;i0++) {
mostCurrent._pa[i0] = new anywheresoftware.b4a.objects.PanelWrapper();
}
}
;
 //BA.debugLineNum = 115;BA.debugLine="Dim SH() As Label";
mostCurrent._sh = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = mostCurrent._sh.length;
for (int i0 = 0;i0 < d0;i0++) {
mostCurrent._sh[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
 //BA.debugLineNum = 116;BA.debugLine="Dim EZ() As Label";
mostCurrent._ez = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = mostCurrent._ez.length;
for (int i0 = 0;i0 < d0;i0++) {
mostCurrent._ez[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
 //BA.debugLineNum = 117;BA.debugLine="Dim NO() As Label";
mostCurrent._no = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = mostCurrent._no.length;
for (int i0 = 0;i0 < d0;i0++) {
mostCurrent._no[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
 //BA.debugLineNum = 123;BA.debugLine="Private lbl_today_monasebat As Label";
mostCurrent._lbl_today_monasebat = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 124;BA.debugLine="Private lbl_today As Label";
mostCurrent._lbl_today = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 126;BA.debugLine="Dim index_i_today As Int";
_index_i_today = 0;
 //BA.debugLineNum = 127;BA.debugLine="Dim this_day As Int";
_this_day = 0;
 //BA.debugLineNum = 128;BA.debugLine="Dim this_year As Int";
_this_year = 0;
 //BA.debugLineNum = 129;BA.debugLine="Dim this_moon As Int";
_this_moon = 0;
 //BA.debugLineNum = 131;BA.debugLine="Dim last_selected_itemTag As Int";
_last_selected_itemtag = 0;
 //BA.debugLineNum = 133;BA.debugLine="Dim selectedDay_id As Int";
_selectedday_id = 0;
 //BA.debugLineNum = 136;BA.debugLine="Private sh42 As Label";
mostCurrent._sh42 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 137;BA.debugLine="Private sh41 As Label";
mostCurrent._sh41 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 138;BA.debugLine="Private sh40 As Label";
mostCurrent._sh40 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 139;BA.debugLine="Private sh39 As Label";
mostCurrent._sh39 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 140;BA.debugLine="Private sh38 As Label";
mostCurrent._sh38 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 141;BA.debugLine="Private sh37 As Label";
mostCurrent._sh37 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 142;BA.debugLine="Private sh36 As Label";
mostCurrent._sh36 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 143;BA.debugLine="Private sh29 As Label";
mostCurrent._sh29 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 144;BA.debugLine="Private sh30 As Label";
mostCurrent._sh30 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 145;BA.debugLine="Private sh31 As Label";
mostCurrent._sh31 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 146;BA.debugLine="Private sh32 As Label";
mostCurrent._sh32 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 147;BA.debugLine="Private sh33 As Label";
mostCurrent._sh33 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 148;BA.debugLine="Private sh34 As Label";
mostCurrent._sh34 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 149;BA.debugLine="Private sh35 As Label";
mostCurrent._sh35 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 150;BA.debugLine="Private sh28 As Label";
mostCurrent._sh28 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 151;BA.debugLine="Private sh21 As Label";
mostCurrent._sh21 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 152;BA.debugLine="Private sh14 As Label";
mostCurrent._sh14 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 153;BA.debugLine="Private sh7 As Label";
mostCurrent._sh7 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 154;BA.debugLine="Private sh6 As Label";
mostCurrent._sh6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 155;BA.debugLine="Private sh13 As Label";
mostCurrent._sh13 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 156;BA.debugLine="Private sh20 As Label";
mostCurrent._sh20 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 157;BA.debugLine="Private sh27 As Label";
mostCurrent._sh27 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 158;BA.debugLine="Private sh26 As Label";
mostCurrent._sh26 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 159;BA.debugLine="Private sh19 As Label";
mostCurrent._sh19 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 160;BA.debugLine="Private sh12 As Label";
mostCurrent._sh12 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 161;BA.debugLine="Private sh5 As Label";
mostCurrent._sh5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 162;BA.debugLine="Private sh4 As Label";
mostCurrent._sh4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 163;BA.debugLine="Private sh11 As Label";
mostCurrent._sh11 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 164;BA.debugLine="Private sh18 As Label";
mostCurrent._sh18 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 165;BA.debugLine="Private sh25 As Label";
mostCurrent._sh25 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 166;BA.debugLine="Private sh24 As Label";
mostCurrent._sh24 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 167;BA.debugLine="Private sh17 As Label";
mostCurrent._sh17 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 168;BA.debugLine="Private sh10 As Label";
mostCurrent._sh10 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 169;BA.debugLine="Private sh3 As Label";
mostCurrent._sh3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 170;BA.debugLine="Private sh2 As Label";
mostCurrent._sh2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 171;BA.debugLine="Private sh9 As Label";
mostCurrent._sh9 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 172;BA.debugLine="Private sh16 As Label";
mostCurrent._sh16 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 173;BA.debugLine="Private sh23 As Label";
mostCurrent._sh23 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 174;BA.debugLine="Private sh22 As Label";
mostCurrent._sh22 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 175;BA.debugLine="Private sh15 As Label";
mostCurrent._sh15 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 176;BA.debugLine="Private sh8 As Label";
mostCurrent._sh8 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 177;BA.debugLine="Private sh1 As Label";
mostCurrent._sh1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 180;BA.debugLine="Dim date As ManamPersianDate";
mostCurrent._date = new com.b4a.manamsoftware.PersianDate.ManamPersianDate();
 //BA.debugLineNum = 181;BA.debugLine="Dim start_day As Int";
_start_day = 0;
 //BA.debugLineNum = 183;BA.debugLine="Dim ls_shift_moon As List";
mostCurrent._ls_shift_moon = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 184;BA.debugLine="Dim ls_tatili_moon As List";
mostCurrent._ls_tatili_moon = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 185;BA.debugLine="Dim ls_tatili_custom_moon As List";
mostCurrent._ls_tatili_custom_moon = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 186;BA.debugLine="Dim ls_note_moon As List";
mostCurrent._ls_note_moon = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 190;BA.debugLine="Private pan_all_setSift As Panel";
mostCurrent._pan_all_setsift = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 191;BA.debugLine="Private ls_set_shift As ListView";
mostCurrent._ls_set_shift = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 192;BA.debugLine="Private et_num_roz As EditText";
mostCurrent._et_num_roz = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 193;BA.debugLine="Private sp_noe_shift As Spinner";
mostCurrent._sp_noe_shift = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 196;BA.debugLine="Dim list_sift_olgo As List";
mostCurrent._list_sift_olgo = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 199;BA.debugLine="Private lbl_hed_set_shift As Label";
mostCurrent._lbl_hed_set_shift = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 200;BA.debugLine="Private no1 As Label";
mostCurrent._no1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 201;BA.debugLine="Private no2 As Label";
mostCurrent._no2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 202;BA.debugLine="Private no3 As Label";
mostCurrent._no3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 203;BA.debugLine="Private no4 As Label";
mostCurrent._no4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 204;BA.debugLine="Private no5 As Label";
mostCurrent._no5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 205;BA.debugLine="Private no6 As Label";
mostCurrent._no6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 206;BA.debugLine="Private no7 As Label";
mostCurrent._no7 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 207;BA.debugLine="Private no8 As Label";
mostCurrent._no8 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 208;BA.debugLine="Private no9 As Label";
mostCurrent._no9 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 209;BA.debugLine="Private no10 As Label";
mostCurrent._no10 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 210;BA.debugLine="Private no11 As Label";
mostCurrent._no11 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 211;BA.debugLine="Private no12 As Label";
mostCurrent._no12 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 212;BA.debugLine="Private no13 As Label";
mostCurrent._no13 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 213;BA.debugLine="Private no14 As Label";
mostCurrent._no14 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 214;BA.debugLine="Private no22 As Label";
mostCurrent._no22 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 215;BA.debugLine="Private no23 As Label";
mostCurrent._no23 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 216;BA.debugLine="Private no24 As Label";
mostCurrent._no24 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 217;BA.debugLine="Private no25 As Label";
mostCurrent._no25 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 218;BA.debugLine="Private no26 As Label";
mostCurrent._no26 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 219;BA.debugLine="Private no27 As Label";
mostCurrent._no27 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 220;BA.debugLine="Private no28 As Label";
mostCurrent._no28 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 221;BA.debugLine="Private no21 As Label";
mostCurrent._no21 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 222;BA.debugLine="Private no20 As Label";
mostCurrent._no20 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 223;BA.debugLine="Private no19 As Label";
mostCurrent._no19 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 224;BA.debugLine="Private no18 As Label";
mostCurrent._no18 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 225;BA.debugLine="Private no17 As Label";
mostCurrent._no17 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 226;BA.debugLine="Private no16 As Label";
mostCurrent._no16 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 227;BA.debugLine="Private no15 As Label";
mostCurrent._no15 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 228;BA.debugLine="Private no29 As Label";
mostCurrent._no29 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 229;BA.debugLine="Private no30 As Label";
mostCurrent._no30 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 230;BA.debugLine="Private no31 As Label";
mostCurrent._no31 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 231;BA.debugLine="Private no32 As Label";
mostCurrent._no32 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 232;BA.debugLine="Private no33 As Label";
mostCurrent._no33 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 233;BA.debugLine="Private no34 As Label";
mostCurrent._no34 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 234;BA.debugLine="Private no35 As Label";
mostCurrent._no35 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 235;BA.debugLine="Private no36 As Label";
mostCurrent._no36 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 236;BA.debugLine="Private no37 As Label";
mostCurrent._no37 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 237;BA.debugLine="Private no38 As Label";
mostCurrent._no38 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 238;BA.debugLine="Private no39 As Label";
mostCurrent._no39 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 239;BA.debugLine="Private no40 As Label";
mostCurrent._no40 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 240;BA.debugLine="Private no41 As Label";
mostCurrent._no41 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 241;BA.debugLine="Private no42 As Label";
mostCurrent._no42 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 242;BA.debugLine="Private ez42 As Label";
mostCurrent._ez42 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 243;BA.debugLine="Private ez41 As Label";
mostCurrent._ez41 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 244;BA.debugLine="Private ez40 As Label";
mostCurrent._ez40 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 245;BA.debugLine="Private ez39 As Label";
mostCurrent._ez39 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 246;BA.debugLine="Private ez38 As Label";
mostCurrent._ez38 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 247;BA.debugLine="Private ez37 As Label";
mostCurrent._ez37 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 248;BA.debugLine="Private ez36 As Label";
mostCurrent._ez36 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 249;BA.debugLine="Private ez35 As Label";
mostCurrent._ez35 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 250;BA.debugLine="Private ez34 As Label";
mostCurrent._ez34 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 251;BA.debugLine="Private ez33 As Label";
mostCurrent._ez33 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 252;BA.debugLine="Private ez32 As Label";
mostCurrent._ez32 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 253;BA.debugLine="Private ez31 As Label";
mostCurrent._ez31 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 254;BA.debugLine="Private ez30 As Label";
mostCurrent._ez30 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 255;BA.debugLine="Private ez29 As Label";
mostCurrent._ez29 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 256;BA.debugLine="Private ez15 As Label";
mostCurrent._ez15 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 257;BA.debugLine="Private ez16 As Label";
mostCurrent._ez16 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 258;BA.debugLine="Private ez17 As Label";
mostCurrent._ez17 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 259;BA.debugLine="Private ez18 As Label";
mostCurrent._ez18 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 260;BA.debugLine="Private ez19 As Label";
mostCurrent._ez19 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 261;BA.debugLine="Private ez20 As Label";
mostCurrent._ez20 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 262;BA.debugLine="Private ez21 As Label";
mostCurrent._ez21 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 263;BA.debugLine="Private ez28 As Label";
mostCurrent._ez28 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 264;BA.debugLine="Private ez27 As Label";
mostCurrent._ez27 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 265;BA.debugLine="Private ez26 As Label";
mostCurrent._ez26 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 266;BA.debugLine="Private ez25 As Label";
mostCurrent._ez25 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 267;BA.debugLine="Private ez24 As Label";
mostCurrent._ez24 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 268;BA.debugLine="Private ez23 As Label";
mostCurrent._ez23 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 269;BA.debugLine="Private ez22 As Label";
mostCurrent._ez22 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 270;BA.debugLine="Private ez14 As Label";
mostCurrent._ez14 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 271;BA.debugLine="Private ez13 As Label";
mostCurrent._ez13 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 272;BA.debugLine="Private ez12 As Label";
mostCurrent._ez12 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 273;BA.debugLine="Private ez11 As Label";
mostCurrent._ez11 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 274;BA.debugLine="Private ez10 As Label";
mostCurrent._ez10 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 275;BA.debugLine="Private ez9 As Label";
mostCurrent._ez9 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 276;BA.debugLine="Private ez8 As Label";
mostCurrent._ez8 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 277;BA.debugLine="Private ez7 As Label";
mostCurrent._ez7 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 278;BA.debugLine="Private ez6 As Label";
mostCurrent._ez6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 279;BA.debugLine="Private ez5 As Label";
mostCurrent._ez5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 280;BA.debugLine="Private ez4 As Label";
mostCurrent._ez4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 281;BA.debugLine="Private ez3 As Label";
mostCurrent._ez3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 282;BA.debugLine="Private ez2 As Label";
mostCurrent._ez2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 283;BA.debugLine="Private ez1 As Label";
mostCurrent._ez1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 284;BA.debugLine="Private lbl_morakhasi_day As Label";
mostCurrent._lbl_morakhasi_day = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 285;BA.debugLine="Private lbl_ezafekari_day As Label";
mostCurrent._lbl_ezafekari_day = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 288;BA.debugLine="Private lbl_note_day As Label";
mostCurrent._lbl_note_day = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 289;BA.debugLine="Private et_note As EditText";
mostCurrent._et_note = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 290;BA.debugLine="Private pan_all_note As Panel";
mostCurrent._pan_all_note = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 291;BA.debugLine="Private lbl_date_in_note As Label";
mostCurrent._lbl_date_in_note = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 296;BA.debugLine="Dim rsPOP_year As RSPopupMenu";
mostCurrent._rspop_year = new com.rootsoft.rspopupmenu.RSPopupMenu();
 //BA.debugLineNum = 297;BA.debugLine="Dim rsPOP_mah As RSPopupMenu";
mostCurrent._rspop_mah = new com.rootsoft.rspopupmenu.RSPopupMenu();
 //BA.debugLineNum = 298;BA.debugLine="Dim rsPOP_roz As RSPopupMenu";
mostCurrent._rspop_roz = new com.rootsoft.rspopupmenu.RSPopupMenu();
 //BA.debugLineNum = 300;BA.debugLine="Dim rsPOP_year_end As RSPopupMenu";
mostCurrent._rspop_year_end = new com.rootsoft.rspopupmenu.RSPopupMenu();
 //BA.debugLineNum = 301;BA.debugLine="Dim rsPOP_mah_end As RSPopupMenu";
mostCurrent._rspop_mah_end = new com.rootsoft.rspopupmenu.RSPopupMenu();
 //BA.debugLineNum = 302;BA.debugLine="Dim rsPOP_roz_end As RSPopupMenu";
mostCurrent._rspop_roz_end = new com.rootsoft.rspopupmenu.RSPopupMenu();
 //BA.debugLineNum = 305;BA.debugLine="Dim rsPOP_year_tagvim As RSPopupMenu";
mostCurrent._rspop_year_tagvim = new com.rootsoft.rspopupmenu.RSPopupMenu();
 //BA.debugLineNum = 306;BA.debugLine="Dim rsPOP_moon_tagvim As RSPopupMenu";
mostCurrent._rspop_moon_tagvim = new com.rootsoft.rspopupmenu.RSPopupMenu();
 //BA.debugLineNum = 310;BA.debugLine="Private lbl_years As Label";
mostCurrent._lbl_years = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 311;BA.debugLine="Private lbl_mah As Label";
mostCurrent._lbl_mah = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 312;BA.debugLine="Dim lbl_mah_tagID As Int  '----for int mah";
_lbl_mah_tagid = 0;
 //BA.debugLineNum = 313;BA.debugLine="Private lbl_roz As Label";
mostCurrent._lbl_roz = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 315;BA.debugLine="Private lbl_roz_end As Label";
mostCurrent._lbl_roz_end = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 316;BA.debugLine="Private lbl_mah_end As Label";
mostCurrent._lbl_mah_end = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 317;BA.debugLine="Dim lbl_mah_end_tagID As Int  '----for int mah";
_lbl_mah_end_tagid = 0;
 //BA.debugLineNum = 318;BA.debugLine="Private lbl_years_end As Label";
mostCurrent._lbl_years_end = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 322;BA.debugLine="Private lbl_taradod_day As Label";
mostCurrent._lbl_taradod_day = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 323;BA.debugLine="Private lbl_year_tagvim As Label";
mostCurrent._lbl_year_tagvim = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 328;BA.debugLine="Private scrol_v As ScrollView";
mostCurrent._scrol_v = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 329;BA.debugLine="Private pan_all_menu_day As Panel";
mostCurrent._pan_all_menu_day = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 330;BA.debugLine="Private CheckBox_tatil_garardadi As CheckBox";
mostCurrent._checkbox_tatil_garardadi = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 331;BA.debugLine="Private lbl_CheckBox_tatil_garardadi As Label";
mostCurrent._lbl_checkbox_tatil_garardadi = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 332;BA.debugLine="Private lbl_title_day_menu As Label";
mostCurrent._lbl_title_day_menu = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 333;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_2_click() throws Exception{
 //BA.debugLineNum = 1385;BA.debugLine="Private Sub lbl_back_2_Click";
 //BA.debugLineNum = 1386;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1387;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
 //BA.debugLineNum = 1388;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 735;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 737;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 738;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_checkbox_tatil_garardadi_click() throws Exception{
 //BA.debugLineNum = 1515;BA.debugLine="Private Sub lbl_CheckBox_tatil_garardadi_Click";
 //BA.debugLineNum = 1517;BA.debugLine="If(CheckBox_tatil_garardadi.Checked=True)Then";
if ((mostCurrent._checkbox_tatil_garardadi.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1518;BA.debugLine="CheckBox_tatil_garardadi.Checked=False";
mostCurrent._checkbox_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 1520;BA.debugLine="CheckBox_tatil_garardadi.Checked=True";
mostCurrent._checkbox_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 1523;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_del_shiftha_click() throws Exception{
 //BA.debugLineNum = 1396;BA.debugLine="Private Sub lbl_del_shiftha_Click";
 //BA.debugLineNum = 1397;BA.debugLine="shift_rest";
_shift_rest();
 //BA.debugLineNum = 1398;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_delete_lis_olgo_click() throws Exception{
 //BA.debugLineNum = 1390;BA.debugLine="Private Sub lbl_delete_lis_olgo_Click";
 //BA.debugLineNum = 1391;BA.debugLine="ls_set_shift.Clear";
mostCurrent._ls_set_shift.Clear();
 //BA.debugLineNum = 1392;BA.debugLine="list_sift_olgo.Clear";
mostCurrent._list_sift_olgo.Clear();
 //BA.debugLineNum = 1393;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_note_click() throws Exception{
 //BA.debugLineNum = 1417;BA.debugLine="Private Sub lbl_edit_note_Click";
 //BA.debugLineNum = 1418;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1419;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_selectedday_id))));
 //BA.debugLineNum = 1420;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 1423;BA.debugLine="et_note.Text=dbCode.res.GetString(\"note\")";
mostCurrent._et_note.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")));
 //BA.debugLineNum = 1425;BA.debugLine="lbl_date_in_note.Text=lbl_year_tagvim.Text&\"/\"&db";
mostCurrent._lbl_date_in_note.setText(BA.ObjectToCharSequence(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("moon")+"/"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_c"))));
 //BA.debugLineNum = 1428;BA.debugLine="pan_all_note.Visible=True";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1429;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_go_today_click() throws Exception{
 //BA.debugLineNum = 518;BA.debugLine="Private Sub lbl_go_today_Click";
 //BA.debugLineNum = 520;BA.debugLine="selectedDay_id=dbCode.get_day_id(this_year,this_m";
_selectedday_id = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_this_year,_this_moon,_this_day);
 //BA.debugLineNum = 524;BA.debugLine="generat_taghvim(this_year,this_moon)";
_generat_taghvim(_this_year,_this_moon);
 //BA.debugLineNum = 526;BA.debugLine="get_monasebat( selectedDay_id )";
_get_monasebat(_selectedday_id);
 //BA.debugLineNum = 527;BA.debugLine="get_note(selectedDay_id)";
_get_note(_selectedday_id);
 //BA.debugLineNum = 529;BA.debugLine="get_ezafekari(this_year&\"/\"&myfunc.convert_adad(t";
_get_ezafekari(BA.NumberToString(_this_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_day));
 //BA.debugLineNum = 530;BA.debugLine="get_morakhasi(this_year&\"/\"&myfunc.convert_adad(t";
_get_morakhasi(BA.NumberToString(_this_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_day));
 //BA.debugLineNum = 531;BA.debugLine="get_taradod(this_year&\"/\"&myfunc.convert_adad(thi";
_get_taradod(BA.NumberToString(_this_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_day));
 //BA.debugLineNum = 537;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_shift_click() throws Exception{
 //BA.debugLineNum = 1542;BA.debugLine="Private Sub lbl_help_shift_Click";
 //BA.debugLineNum = 1543;BA.debugLine="myfunc.help_man(\"راهنما\",\"1- با نگهداشتن انگشت رو";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","1- با نگهداشتن انگشت روی روزها منو ابزارها باز میشود. "+anywheresoftware.b4a.keywords.Common.CRLF+" 2- برای شیفت بندی روزها از قسمت تنظیم شیفت اقدام کنید.");
 //BA.debugLineNum = 1544;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_mah_end_click() throws Exception{
 //BA.debugLineNum = 710;BA.debugLine="Private Sub lbl_mah_end_Click";
 //BA.debugLineNum = 711;BA.debugLine="rsPOP_mah_end.Show";
mostCurrent._rspop_mah_end.Show();
 //BA.debugLineNum = 712;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_moon_name_click() throws Exception{
 //BA.debugLineNum = 553;BA.debugLine="Private Sub lbl_moon_name_Click";
 //BA.debugLineNum = 554;BA.debugLine="rsPOP_moon_tagvim.Show";
mostCurrent._rspop_moon_tagvim.Show();
 //BA.debugLineNum = 555;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_new_line_click() throws Exception{
int _i = 0;
 //BA.debugLineNum = 1249;BA.debugLine="Private Sub lbl_new_line_Click";
 //BA.debugLineNum = 1252;BA.debugLine="ls_set_shift.AddSingleLine(et_num_roz.Text&\" \"&sp";
mostCurrent._ls_set_shift.AddSingleLine(BA.ObjectToCharSequence(mostCurrent._et_num_roz.getText()+" "+mostCurrent._sp_noe_shift.getSelectedItem()));
 //BA.debugLineNum = 1253;BA.debugLine="For i=1 To et_num_roz.Text";
{
final int step2 = 1;
final int limit2 = (int)(Double.parseDouble(mostCurrent._et_num_roz.getText()));
_i = (int) (1) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 1255;BA.debugLine="Select sp_noe_shift.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_noe_shift.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
 //BA.debugLineNum = 1258;BA.debugLine="list_sift_olgo.Add(\"ر\")";
mostCurrent._list_sift_olgo.Add((Object)("ر"));
 break; }
case 1: {
 //BA.debugLineNum = 1260;BA.debugLine="list_sift_olgo.Add(\"ع\")";
mostCurrent._list_sift_olgo.Add((Object)("ع"));
 break; }
case 2: {
 //BA.debugLineNum = 1262;BA.debugLine="list_sift_olgo.Add(\"ش\")";
mostCurrent._list_sift_olgo.Add((Object)("ش"));
 break; }
case 3: {
 //BA.debugLineNum = 1264;BA.debugLine="list_sift_olgo.Add(\"ا\")";
mostCurrent._list_sift_olgo.Add((Object)("ا"));
 break; }
}
;
 }
};
 //BA.debugLineNum = 1273;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_next_click() throws Exception{
int _adad = 0;
 //BA.debugLineNum = 1199;BA.debugLine="Private Sub lbl_next_Click";
 //BA.debugLineNum = 1201;BA.debugLine="If (current_moon>=12)Then";
if ((_current_moon>=12)) { 
 //BA.debugLineNum = 1203;BA.debugLine="If(lbl_year_tagvim.Text<1403)Then";
if (((double)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()))<1403)) { 
 //BA.debugLineNum = 1204;BA.debugLine="Dim adad As Int=lbl_year_tagvim.Text";
_adad = (int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()));
 //BA.debugLineNum = 1205;BA.debugLine="lbl_year_tagvim.Text=adad+1";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_adad+1));
 //BA.debugLineNum = 1206;BA.debugLine="current_moon=1";
_current_moon = (int) (1);
 }else {
 //BA.debugLineNum = 1208;BA.debugLine="current_moon=12";
_current_moon = (int) (12);
 };
 }else {
 //BA.debugLineNum = 1214;BA.debugLine="current_moon=current_moon+1";
_current_moon = (int) (_current_moon+1);
 };
 //BA.debugLineNum = 1216;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_current_moon);
 //BA.debugLineNum = 1218;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_note_day_menu_click() throws Exception{
 //BA.debugLineNum = 1510;BA.debugLine="Private Sub lbl_note_day_menu_Click";
 //BA.debugLineNum = 1511;BA.debugLine="lbl_edit_note_Click";
_lbl_edit_note_click();
 //BA.debugLineNum = 1512;BA.debugLine="pan_all_menu_day_Click";
_pan_all_menu_day_click();
 //BA.debugLineNum = 1513;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_prev_click() throws Exception{
int _adad = 0;
 //BA.debugLineNum = 1220;BA.debugLine="Private Sub lbl_prev_Click";
 //BA.debugLineNum = 1222;BA.debugLine="If (current_moon<=1)Then";
if ((_current_moon<=1)) { 
 //BA.debugLineNum = 1225;BA.debugLine="If(lbl_year_tagvim.Text>1398)Then";
if (((double)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()))>1398)) { 
 //BA.debugLineNum = 1226;BA.debugLine="Dim adad As Int=lbl_year_tagvim.Text";
_adad = (int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()));
 //BA.debugLineNum = 1227;BA.debugLine="lbl_year_tagvim.Text=adad-1";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_adad-1));
 //BA.debugLineNum = 1228;BA.debugLine="current_moon=12";
_current_moon = (int) (12);
 }else {
 //BA.debugLineNum = 1230;BA.debugLine="current_moon=1";
_current_moon = (int) (1);
 };
 }else {
 //BA.debugLineNum = 1235;BA.debugLine="current_moon=current_moon-1";
_current_moon = (int) (_current_moon-1);
 };
 //BA.debugLineNum = 1237;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_current_moon);
 //BA.debugLineNum = 1239;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_roz_click() throws Exception{
 //BA.debugLineNum = 651;BA.debugLine="Private Sub lbl_roz_Click";
 //BA.debugLineNum = 652;BA.debugLine="rsPOP_roz.Show";
mostCurrent._rspop_roz.Show();
 //BA.debugLineNum = 653;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_roz_end_click() throws Exception{
 //BA.debugLineNum = 714;BA.debugLine="Private Sub lbl_roz_end_Click";
 //BA.debugLineNum = 715;BA.debugLine="rsPOP_roz_end.Show";
mostCurrent._rspop_roz_end.Show();
 //BA.debugLineNum = 716;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_note_click() throws Exception{
 //BA.debugLineNum = 1482;BA.debugLine="Private Sub lbl_save_note_Click";
 //BA.debugLineNum = 1484;BA.debugLine="set_note(selectedDay_id,et_note.Text)";
_set_note(_selectedday_id,mostCurrent._et_note.getText());
 //BA.debugLineNum = 1485;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,lbl_moon_nam";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())));
 //BA.debugLineNum = 1486;BA.debugLine="pan_all_note.Visible=False";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1487;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_shift_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_tosave = null;
int _p = 0;
 //BA.debugLineNum = 1277;BA.debugLine="Private Sub lbl_save_shift_Click";
 //BA.debugLineNum = 1280;BA.debugLine="If(ls_set_shift.Size<1)Then";
if ((mostCurrent._ls_set_shift.getSize()<1)) { 
 //BA.debugLineNum = 1281;BA.debugLine="ToastMessageShow(\"الگو باید حداقل یک مورد باشد\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("الگو باید حداقل یک مورد باشد"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 1286;BA.debugLine="set_shift(list_sift_olgo)";
_set_shift(mostCurrent._list_sift_olgo);
 //BA.debugLineNum = 1289;BA.debugLine="Dim ls_toSave As List";
_ls_tosave = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1290;BA.debugLine="ls_toSave.Initialize";
_ls_tosave.Initialize();
 //BA.debugLineNum = 1292;BA.debugLine="For p=0 To ls_set_shift.Size-1";
{
final int step7 = 1;
final int limit7 = (int) (mostCurrent._ls_set_shift.getSize()-1);
_p = (int) (0) ;
for (;_p <= limit7 ;_p = _p + step7 ) {
 //BA.debugLineNum = 1293;BA.debugLine="ls_toSave.Add(ls_set_shift.GetItem(p))";
_ls_tosave.Add(mostCurrent._ls_set_shift.GetItem(_p));
 }
};
 //BA.debugLineNum = 1296;BA.debugLine="File.WriteList(File.DirInternal,\"shift_olgo\",ls_";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo",_ls_tosave);
 //BA.debugLineNum = 1297;BA.debugLine="File.WriteList(File.DirInternal,\"shift_olgo_cod\"";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo_cod",mostCurrent._list_sift_olgo);
 //BA.debugLineNum = 1300;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1304;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
 //BA.debugLineNum = 1305;BA.debugLine="generat_taghvim(this_year,this_moon)";
_generat_taghvim(_this_year,_this_moon);
 };
 //BA.debugLineNum = 1310;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_show_panshift_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_toload = null;
int _i = 0;
 //BA.debugLineNum = 1312;BA.debugLine="Private Sub lbl_show_panShift_Click";
 //BA.debugLineNum = 1314;BA.debugLine="If(File.Exists(File.DirInternal,\"shift_olgo\")=Tru";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1316;BA.debugLine="Dim ls_toLoad As List";
_ls_toload = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1317;BA.debugLine="ls_toLoad.Initialize";
_ls_toload.Initialize();
 //BA.debugLineNum = 1319;BA.debugLine="ls_toLoad=File.ReadList(File.DirInternal,\"shift_";
_ls_toload = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo");
 //BA.debugLineNum = 1321;BA.debugLine="For i=0 To ls_toLoad.Size-1";
{
final int step5 = 1;
final int limit5 = (int) (_ls_toload.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 1322;BA.debugLine="ls_set_shift.AddSingleLine(ls_toLoad.Get(i))";
mostCurrent._ls_set_shift.AddSingleLine(BA.ObjectToCharSequence(_ls_toload.Get(_i)));
 }
};
 //BA.debugLineNum = 1325;BA.debugLine="list_sift_olgo=File.ReadList(File.DirInternal,\"s";
mostCurrent._list_sift_olgo = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo_cod");
 };
 //BA.debugLineNum = 1329;BA.debugLine="pan_all_setSift.Visible=True";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1331;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_year_tagvim_click() throws Exception{
 //BA.debugLineNum = 549;BA.debugLine="Private Sub lbl_year_tagvim_Click";
 //BA.debugLineNum = 550;BA.debugLine="rsPOP_year_tagvim.Show";
mostCurrent._rspop_year_tagvim.Show();
 //BA.debugLineNum = 551;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_years_click() throws Exception{
 //BA.debugLineNum = 643;BA.debugLine="Private Sub lbl_years_Click";
 //BA.debugLineNum = 644;BA.debugLine="rsPOP_year.Show";
mostCurrent._rspop_year.Show();
 //BA.debugLineNum = 645;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_years_end_click() throws Exception{
 //BA.debugLineNum = 706;BA.debugLine="Private Sub lbl_years_end_Click";
 //BA.debugLineNum = 707;BA.debugLine="rsPOP_year_end.Show";
mostCurrent._rspop_year_end.Show();
 //BA.debugLineNum = 708;BA.debugLine="End Sub";
return "";
}
public static String  _mod_tatil_garardadi(int _id) throws Exception{
 //BA.debugLineNum = 1447;BA.debugLine="Sub mod_tatil_garardadi (id As Int)";
 //BA.debugLineNum = 1448;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1449;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
 //BA.debugLineNum = 1450;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 1453;BA.debugLine="If(dbCode.res.GetString(\"state\")=\"tatil\") Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
 //BA.debugLineNum = 1454;BA.debugLine="CheckBox_tatil_garardadi.Enabled=False";
mostCurrent._checkbox_tatil_garardadi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1455;BA.debugLine="lbl_CheckBox_tatil_garardadi.Enabled=False";
mostCurrent._lbl_checkbox_tatil_garardadi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1456;BA.debugLine="CheckBox_tatil_garardadi.Checked=False";
mostCurrent._checkbox_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else if(((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil1"))) { 
 //BA.debugLineNum = 1459;BA.debugLine="CheckBox_tatil_garardadi.Enabled=True";
mostCurrent._checkbox_tatil_garardadi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1460;BA.debugLine="lbl_CheckBox_tatil_garardadi.Enabled=True";
mostCurrent._lbl_checkbox_tatil_garardadi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1461;BA.debugLine="CheckBox_tatil_garardadi.Checked=True";
mostCurrent._checkbox_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 1463;BA.debugLine="CheckBox_tatil_garardadi.Enabled=True";
mostCurrent._checkbox_tatil_garardadi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1464;BA.debugLine="lbl_CheckBox_tatil_garardadi.Enabled=True";
mostCurrent._lbl_checkbox_tatil_garardadi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1465;BA.debugLine="CheckBox_tatil_garardadi.Checked=False";
mostCurrent._checkbox_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 1470;BA.debugLine="End Sub";
return "";
}
public static String  _pa_click() throws Exception{
String _str_t = "";
anywheresoftware.b4a.objects.PanelWrapper _b = null;
int _d = 0;
int _moon_tag = 0;
 //BA.debugLineNum = 1143;BA.debugLine="Private Sub PA_Click";
 //BA.debugLineNum = 1144;BA.debugLine="Dim str_t As String";
_str_t = "";
 //BA.debugLineNum = 1145;BA.debugLine="Dim B As Panel = Sender";
_b = new anywheresoftware.b4a.objects.PanelWrapper();
_b = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 1146;BA.debugLine="selectedDay_id=dbCode.get_day_id(lbl_year_tagvim.";
_selectedday_id = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())),(int)(BA.ObjectToNumber(_b.getTag())));
 //BA.debugLineNum = 1148;BA.debugLine="For d=0 To PA.Length-1";
{
final int step4 = 1;
final int limit4 = (int) (mostCurrent._pa.length-1);
_d = (int) (0) ;
for (;_d <= limit4 ;_d = _d + step4 ) {
 //BA.debugLineNum = 1149;BA.debugLine="str_t=PA(d).Tag";
_str_t = BA.ObjectToString(mostCurrent._pa[_d].getTag());
 //BA.debugLineNum = 1150;BA.debugLine="If ( str_t = last_selected_itemTag )Then";
if (((_str_t).equals(BA.NumberToString(_last_selected_itemtag)))) { 
 //BA.debugLineNum = 1154;BA.debugLine="If(last_selected_itemTag<>0)Then";
if ((_last_selected_itemtag!=0)) { 
 //BA.debugLineNum = 1156;BA.debugLine="If(ls_tatili_moon.Get(last_selected_itemTag-1)";
if (((mostCurrent._ls_tatili_moon.Get((int) (_last_selected_itemtag-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
 //BA.debugLineNum = 1157;BA.debugLine="PA(d).Color=0xFFFF5252";
mostCurrent._pa[_d].setColor(((int)0xffff5252));
 }else if(((mostCurrent._ls_tatili_custom_moon.Get((int) (_last_selected_itemtag-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
 //BA.debugLineNum = 1160;BA.debugLine="PA(d).Color=0xFF00BB8B";
mostCurrent._pa[_d].setColor(((int)0xff00bb8b));
 }else {
 //BA.debugLineNum = 1163;BA.debugLine="PA(d).Color=0xFFEFEFEF";
mostCurrent._pa[_d].setColor(((int)0xffefefef));
 };
 };
 };
 }
};
 //BA.debugLineNum = 1176;BA.debugLine="Dim moon_tag As Int=lbl_moon_name.Tag";
_moon_tag = (int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag()));
 //BA.debugLineNum = 1177;BA.debugLine="If( moon_tag=this_moon)Then";
if ((_moon_tag==_this_moon)) { 
 //BA.debugLineNum = 1179;BA.debugLine="Lb(index_i_today).TextColor=0xFFFF9000";
mostCurrent._lb[_index_i_today].setTextColor(((int)0xffff9000));
 };
 //BA.debugLineNum = 1184;BA.debugLine="B.Color=Colors.Gray";
_b.setColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 1185;BA.debugLine="get_monasebat(selectedDay_id)";
_get_monasebat(_selectedday_id);
 //BA.debugLineNum = 1186;BA.debugLine="get_note(selectedDay_id)";
_get_note(_selectedday_id);
 //BA.debugLineNum = 1188;BA.debugLine="get_ezafekari(lbl_year_tagvim.Text&\"/\"&myfunc.con";
_get_ezafekari(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))));
 //BA.debugLineNum = 1189;BA.debugLine="get_morakhasi(lbl_year_tagvim.Text&\"/\"&myfunc.con";
_get_morakhasi(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))));
 //BA.debugLineNum = 1190;BA.debugLine="get_taradod(lbl_year_tagvim.Text&\"/\"&myfunc.conve";
_get_taradod(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))));
 //BA.debugLineNum = 1192;BA.debugLine="last_selected_itemTag=B.Tag";
_last_selected_itemtag = (int)(BA.ObjectToNumber(_b.getTag()));
 //BA.debugLineNum = 1195;BA.debugLine="End Sub";
return "";
}
public static String  _pa_longclick() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _b = null;
 //BA.debugLineNum = 1431;BA.debugLine="Private Sub PA_LongClick";
 //BA.debugLineNum = 1432;BA.debugLine="Dim B As Panel = Sender";
_b = new anywheresoftware.b4a.objects.PanelWrapper();
_b = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 1435;BA.debugLine="selectedDay_id=dbCode.get_day_id(lbl_year_tagvim.";
_selectedday_id = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())),(int)(BA.ObjectToNumber(_b.getTag())));
 //BA.debugLineNum = 1442;BA.debugLine="lbl_title_day_menu.Text=lbl_year_tagvim.Text&\"/\"&";
mostCurrent._lbl_title_day_menu.setText(BA.ObjectToCharSequence(mostCurrent._lbl_year_tagvim.getText()+"/"+BA.ObjectToString(mostCurrent._lbl_moon_name.getTag())+"/"+BA.ObjectToString(_b.getTag())));
 //BA.debugLineNum = 1443;BA.debugLine="mod_tatil_garardadi(selectedDay_id)";
_mod_tatil_garardadi(_selectedday_id);
 //BA.debugLineNum = 1444;BA.debugLine="pan_all_menu_day.Visible=True";
mostCurrent._pan_all_menu_day.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1445;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_menu_day_click() throws Exception{
 //BA.debugLineNum = 1502;BA.debugLine="Private Sub pan_all_menu_day_Click";
 //BA.debugLineNum = 1503;BA.debugLine="pan_all_menu_day.Visible=False";
mostCurrent._pan_all_menu_day.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1504;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_note_click() throws Exception{
 //BA.debugLineNum = 1474;BA.debugLine="Private Sub pan_all_note_Click";
 //BA.debugLineNum = 1475;BA.debugLine="pan_all_note.Visible=False";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1476;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_setsift_click() throws Exception{
 //BA.debugLineNum = 1245;BA.debugLine="Private Sub pan_all_setSift_Click";
 //BA.debugLineNum = 1247;BA.debugLine="End Sub";
return "";
}
public static String  _panel12_click() throws Exception{
 //BA.debugLineNum = 1478;BA.debugLine="Private Sub Panel12_Click";
 //BA.debugLineNum = 1480;BA.debugLine="End Sub";
return "";
}
public static String  _panel8_click() throws Exception{
 //BA.debugLineNum = 1506;BA.debugLine="Private Sub Panel8_Click";
 //BA.debugLineNum = 1508;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static boolean  _rspop_mah_end_menuitemclick(int _itemid) throws Exception{
String _mmah = "";
 //BA.debugLineNum = 662;BA.debugLine="Sub rsPOP_mah_end_MenuItemClick (ItemId As Int) As";
 //BA.debugLineNum = 663;BA.debugLine="Dim mmah As String";
_mmah = "";
 //BA.debugLineNum = 664;BA.debugLine="Select ItemId";
switch (_itemid) {
case 1: {
 //BA.debugLineNum = 666;BA.debugLine="mmah=\"فروردین\"";
_mmah = "فروردین";
 break; }
case 2: {
 //BA.debugLineNum = 668;BA.debugLine="mmah=\"اردیبهشت\"";
_mmah = "اردیبهشت";
 break; }
case 3: {
 //BA.debugLineNum = 670;BA.debugLine="mmah=\"خرداد\"";
_mmah = "خرداد";
 break; }
case 4: {
 //BA.debugLineNum = 672;BA.debugLine="mmah=\"تیر\"";
_mmah = "تیر";
 break; }
case 5: {
 //BA.debugLineNum = 674;BA.debugLine="mmah=\"مرداد\"";
_mmah = "مرداد";
 break; }
case 6: {
 //BA.debugLineNum = 676;BA.debugLine="mmah=\"شهریور\"";
_mmah = "شهریور";
 break; }
case 7: {
 //BA.debugLineNum = 678;BA.debugLine="mmah=\"مهر\"";
_mmah = "مهر";
 break; }
case 8: {
 //BA.debugLineNum = 680;BA.debugLine="mmah=\"آبان\"";
_mmah = "آبان";
 break; }
case 9: {
 //BA.debugLineNum = 682;BA.debugLine="mmah=\"آذر\"";
_mmah = "آذر";
 break; }
case 10: {
 //BA.debugLineNum = 684;BA.debugLine="mmah=\"دی\"";
_mmah = "دی";
 break; }
case 11: {
 //BA.debugLineNum = 686;BA.debugLine="mmah=\"بهمن\"";
_mmah = "بهمن";
 break; }
case 12: {
 //BA.debugLineNum = 688;BA.debugLine="mmah=\"اسفند\"";
_mmah = "اسفند";
 break; }
}
;
 //BA.debugLineNum = 694;BA.debugLine="lbl_mah_end.Text=mmah";
mostCurrent._lbl_mah_end.setText(BA.ObjectToCharSequence(_mmah));
 //BA.debugLineNum = 695;BA.debugLine="lbl_mah_end_tagID=ItemId";
_lbl_mah_end_tagid = _itemid;
 //BA.debugLineNum = 697;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 698;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_mah_menuitemclick(int _itemid) throws Exception{
String _mmah = "";
 //BA.debugLineNum = 602;BA.debugLine="Sub rsPOP_mah_MenuItemClick (ItemId As Int) As Boo";
 //BA.debugLineNum = 603;BA.debugLine="Dim mmah As String";
_mmah = "";
 //BA.debugLineNum = 604;BA.debugLine="Select ItemId";
switch (_itemid) {
case 1: {
 //BA.debugLineNum = 606;BA.debugLine="mmah=\"فروردین\"";
_mmah = "فروردین";
 break; }
case 2: {
 //BA.debugLineNum = 608;BA.debugLine="mmah=\"اردیبهشت\"";
_mmah = "اردیبهشت";
 break; }
case 3: {
 //BA.debugLineNum = 610;BA.debugLine="mmah=\"خرداد\"";
_mmah = "خرداد";
 break; }
case 4: {
 //BA.debugLineNum = 612;BA.debugLine="mmah=\"تیر\"";
_mmah = "تیر";
 break; }
case 5: {
 //BA.debugLineNum = 614;BA.debugLine="mmah=\"مرداد\"";
_mmah = "مرداد";
 break; }
case 6: {
 //BA.debugLineNum = 616;BA.debugLine="mmah=\"شهریور\"";
_mmah = "شهریور";
 break; }
case 7: {
 //BA.debugLineNum = 618;BA.debugLine="mmah=\"مهر\"";
_mmah = "مهر";
 break; }
case 8: {
 //BA.debugLineNum = 620;BA.debugLine="mmah=\"آبان\"";
_mmah = "آبان";
 break; }
case 9: {
 //BA.debugLineNum = 622;BA.debugLine="mmah=\"آذر\"";
_mmah = "آذر";
 break; }
case 10: {
 //BA.debugLineNum = 624;BA.debugLine="mmah=\"دی\"";
_mmah = "دی";
 break; }
case 11: {
 //BA.debugLineNum = 626;BA.debugLine="mmah=\"بهمن\"";
_mmah = "بهمن";
 break; }
case 12: {
 //BA.debugLineNum = 628;BA.debugLine="mmah=\"اسفند\"";
_mmah = "اسفند";
 break; }
}
;
 //BA.debugLineNum = 633;BA.debugLine="lbl_mah_tagID=ItemId";
_lbl_mah_tagid = _itemid;
 //BA.debugLineNum = 635;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 636;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_moon_tagvim_menuitemclick(int _itemid) throws Exception{
String _mmah = "";
 //BA.debugLineNum = 559;BA.debugLine="Sub rsPOP_moon_tagvim_MenuItemClick (ItemId As Int";
 //BA.debugLineNum = 560;BA.debugLine="Dim mmah As String";
_mmah = "";
 //BA.debugLineNum = 561;BA.debugLine="Select ItemId";
switch (_itemid) {
case 1: {
 //BA.debugLineNum = 563;BA.debugLine="mmah=\"فروردین\"";
_mmah = "فروردین";
 break; }
case 2: {
 //BA.debugLineNum = 565;BA.debugLine="mmah=\"اردیبهشت\"";
_mmah = "اردیبهشت";
 break; }
case 3: {
 //BA.debugLineNum = 567;BA.debugLine="mmah=\"خرداد\"";
_mmah = "خرداد";
 break; }
case 4: {
 //BA.debugLineNum = 569;BA.debugLine="mmah=\"تیر\"";
_mmah = "تیر";
 break; }
case 5: {
 //BA.debugLineNum = 571;BA.debugLine="mmah=\"مرداد\"";
_mmah = "مرداد";
 break; }
case 6: {
 //BA.debugLineNum = 573;BA.debugLine="mmah=\"شهریور\"";
_mmah = "شهریور";
 break; }
case 7: {
 //BA.debugLineNum = 575;BA.debugLine="mmah=\"مهر\"";
_mmah = "مهر";
 break; }
case 8: {
 //BA.debugLineNum = 577;BA.debugLine="mmah=\"آبان\"";
_mmah = "آبان";
 break; }
case 9: {
 //BA.debugLineNum = 579;BA.debugLine="mmah=\"آذر\"";
_mmah = "آذر";
 break; }
case 10: {
 //BA.debugLineNum = 581;BA.debugLine="mmah=\"دی\"";
_mmah = "دی";
 break; }
case 11: {
 //BA.debugLineNum = 583;BA.debugLine="mmah=\"بهمن\"";
_mmah = "بهمن";
 break; }
case 12: {
 //BA.debugLineNum = 585;BA.debugLine="mmah=\"اسفند\"";
_mmah = "اسفند";
 break; }
}
;
 //BA.debugLineNum = 589;BA.debugLine="lbl_moon_name.Text=mmah";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence(_mmah));
 //BA.debugLineNum = 591;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,ItemId)";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_itemid);
 //BA.debugLineNum = 592;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 593;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_roz_end_menuitemclick(int _itemid) throws Exception{
 //BA.debugLineNum = 699;BA.debugLine="Sub rsPOP_roz_end_MenuItemClick (ItemId As Int) As";
 //BA.debugLineNum = 701;BA.debugLine="lbl_roz_end.Text=ItemId";
mostCurrent._lbl_roz_end.setText(BA.ObjectToCharSequence(_itemid));
 //BA.debugLineNum = 702;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 703;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_roz_menuitemclick(int _itemid) throws Exception{
 //BA.debugLineNum = 637;BA.debugLine="Sub rsPOP_roz_MenuItemClick (ItemId As Int) As Boo";
 //BA.debugLineNum = 639;BA.debugLine="lbl_roz.Text=ItemId";
mostCurrent._lbl_roz.setText(BA.ObjectToCharSequence(_itemid));
 //BA.debugLineNum = 640;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 641;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_year_end_menuitemclick(int _itemid) throws Exception{
 //BA.debugLineNum = 658;BA.debugLine="Sub rsPOP_year_end_MenuItemClick (ItemId As Int) A";
 //BA.debugLineNum = 659;BA.debugLine="lbl_years_end.Text=ItemId";
mostCurrent._lbl_years_end.setText(BA.ObjectToCharSequence(_itemid));
 //BA.debugLineNum = 660;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 661;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_year_menuitemclick(int _itemid) throws Exception{
 //BA.debugLineNum = 598;BA.debugLine="Sub rsPOP_year_MenuItemClick (ItemId As Int) As Bo";
 //BA.debugLineNum = 599;BA.debugLine="lbl_years.Text=ItemId";
mostCurrent._lbl_years.setText(BA.ObjectToCharSequence(_itemid));
 //BA.debugLineNum = 600;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 601;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_year_tagvim_menuitemclick(int _itemid) throws Exception{
 //BA.debugLineNum = 543;BA.debugLine="Sub rsPOP_year_tagvim_MenuItemClick (ItemId As Int";
 //BA.debugLineNum = 544;BA.debugLine="lbl_year_tagvim.Text=ItemId";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_itemid));
 //BA.debugLineNum = 545;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_current_moon);
 //BA.debugLineNum = 546;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 547;BA.debugLine="End Sub";
return false;
}
public static String  _set_note(int _id,String _matn) throws Exception{
 //BA.debugLineNum = 1491;BA.debugLine="Sub set_note(id As Int , matn As String)";
 //BA.debugLineNum = 1492;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1493;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' set";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set note='"+_matn+"' WHERE id="+BA.NumberToString(_id));
 //BA.debugLineNum = 1495;BA.debugLine="ToastMessageShow(\"یادداشت ذخیره شد\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("یادداشت ذخیره شد"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1496;BA.debugLine="End Sub";
return "";
}
public static String  _set_shift(anywheresoftware.b4a.objects.collections.List _ol) throws Exception{
int _start_shift = 0;
int _end_shift = 0;
int _index_curent_shift = 0;
int _i = 0;
 //BA.debugLineNum = 1335;BA.debugLine="Sub set_shift(ol As List )";
 //BA.debugLineNum = 1337;BA.debugLine="Try";
try { //BA.debugLineNum = 1338;BA.debugLine="ProgressDialogShow(\"در حال تنظیم شیفت ها\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("در حال تنظیم شیفت ها"));
 //BA.debugLineNum = 1340;BA.debugLine="Dim start_shift As Int";
_start_shift = 0;
 //BA.debugLineNum = 1341;BA.debugLine="Dim end_shift As Int";
_end_shift = 0;
 //BA.debugLineNum = 1343;BA.debugLine="Dim index_curent_shift As Int=0";
_index_curent_shift = (int) (0);
 //BA.debugLineNum = 1344;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1346;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' se";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set shift=''");
 //BA.debugLineNum = 1349;BA.debugLine="start_shift=dbCode.get_day_id(lbl_years.Text,lbl";
_start_shift = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_years.getText())),_lbl_mah_tagid,(int)(Double.parseDouble(mostCurrent._lbl_roz.getText())));
 //BA.debugLineNum = 1350;BA.debugLine="end_shift=dbCode.get_day_id(lbl_years_end.Text,l";
_end_shift = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_years_end.getText())),_lbl_mah_end_tagid,(int)(Double.parseDouble(mostCurrent._lbl_roz_end.getText())));
 //BA.debugLineNum = 1353;BA.debugLine="For i=start_shift To end_shift";
{
final int step10 = 1;
final int limit10 = _end_shift;
_i = _start_shift ;
for (;_i <= limit10 ;_i = _i + step10 ) {
 //BA.debugLineNum = 1355;BA.debugLine="dbCode.sql.ExecNonQuery2(\"UPDATE 'my_calander'";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE 'my_calander' set shift=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{mostCurrent._list_sift_olgo.Get(_index_curent_shift),(Object)(_i)}));
 //BA.debugLineNum = 1358;BA.debugLine="If(index_curent_shift=list_sift_olgo.Size-1)The";
if ((_index_curent_shift==mostCurrent._list_sift_olgo.getSize()-1)) { 
 //BA.debugLineNum = 1359;BA.debugLine="index_curent_shift=0";
_index_curent_shift = (int) (0);
 }else {
 //BA.debugLineNum = 1361;BA.debugLine="index_curent_shift=index_curent_shift+1";
_index_curent_shift = (int) (_index_curent_shift+1);
 };
 }
};
 //BA.debugLineNum = 1366;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1367;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 } 
       catch (Exception e21) {
			processBA.setLastException(e21); //BA.debugLineNum = 1370;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("129818915",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 1371;BA.debugLine="ToastMessageShow(\"خطا در تاریخ\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در تاریخ"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 1377;BA.debugLine="End Sub";
return "";
}
public static String  _shift_rest() throws Exception{
 //BA.debugLineNum = 1400;BA.debugLine="Sub shift_rest";
 //BA.debugLineNum = 1401;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1402;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' set";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set shift='' ");
 //BA.debugLineNum = 1403;BA.debugLine="If(File.Exists(File.DirInternal,\"shift_olgo\"))The";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo"))) { 
 //BA.debugLineNum = 1404;BA.debugLine="File.Delete(File.DirInternal,\"shift_olgo\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo");
 //BA.debugLineNum = 1405;BA.debugLine="File.Delete(File.DirInternal,\"shift_olgo_cod\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo_cod");
 };
 //BA.debugLineNum = 1409;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1410;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
 //BA.debugLineNum = 1411;BA.debugLine="generat_taghvim(this_year,this_moon)";
_generat_taghvim(_this_year,_this_moon);
 //BA.debugLineNum = 1412;BA.debugLine="ToastMessageShow(\"همه شیفت ها حذف شدند\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("همه شیفت ها حذف شدند"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1414;BA.debugLine="End Sub";
return "";
}
public static String  _sql_nonquerycomplete(boolean _success) throws Exception{
 //BA.debugLineNum = 1379;BA.debugLine="Sub sql_NonQueryComplete (Success As Boolean)";
 //BA.debugLineNum = 1381;BA.debugLine="End Sub";
return "";
}
}
