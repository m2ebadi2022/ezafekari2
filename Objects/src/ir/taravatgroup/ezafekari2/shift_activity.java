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
        
        BA.LogInfo("** Activity (shift_activity) Create, isFirst = " + isFirst + " **");
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
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
int _i = 0;
RDebugUtils.currentLine=25034752;
 //BA.debugLineNum = 25034752;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=25034754;
 //BA.debugLineNum = 25034754;BA.debugLine="Activity.LoadLayout(\"shift_layout\")";
mostCurrent._activity.LoadLayout("shift_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=25034756;
 //BA.debugLineNum = 25034756;BA.debugLine="scrol_v.Panel.LoadLayout(\"shift_page_items\")";
mostCurrent._scrol_v.getPanel().LoadLayout("shift_page_items",mostCurrent.activityBA);
RDebugUtils.currentLine=25034757;
 //BA.debugLineNum = 25034757;BA.debugLine="pan_hed_shift.Color=Main.color4";
mostCurrent._pan_hed_shift.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=25034758;
 //BA.debugLineNum = 25034758;BA.debugLine="lbl_hed_set_shift.Color=Main.color4";
mostCurrent._lbl_hed_set_shift.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=25034761;
 //BA.debugLineNum = 25034761;BA.debugLine="lbl0.Initialize(\"lbl0\")";
mostCurrent._lbl0.Initialize(mostCurrent.activityBA,"lbl0");
RDebugUtils.currentLine=25034762;
 //BA.debugLineNum = 25034762;BA.debugLine="lbl0.Tag=0";
mostCurrent._lbl0.setTag((Object)(0));
RDebugUtils.currentLine=25034763;
 //BA.debugLineNum = 25034763;BA.debugLine="p0.Initialize(\"p0\")";
mostCurrent._p0.Initialize(mostCurrent.activityBA,"p0");
RDebugUtils.currentLine=25034764;
 //BA.debugLineNum = 25034764;BA.debugLine="p0.Tag=0";
mostCurrent._p0.setTag((Object)(0));
RDebugUtils.currentLine=25034765;
 //BA.debugLineNum = 25034765;BA.debugLine="sh0.Initialize(\"sh0\")";
mostCurrent._sh0.Initialize(mostCurrent.activityBA,"sh0");
RDebugUtils.currentLine=25034766;
 //BA.debugLineNum = 25034766;BA.debugLine="sh0.Tag=0";
mostCurrent._sh0.setTag((Object)(0));
RDebugUtils.currentLine=25034767;
 //BA.debugLineNum = 25034767;BA.debugLine="ez0.Initialize(\"ez0\")";
mostCurrent._ez0.Initialize(mostCurrent.activityBA,"ez0");
RDebugUtils.currentLine=25034768;
 //BA.debugLineNum = 25034768;BA.debugLine="ez0.Tag=0";
mostCurrent._ez0.setTag((Object)(0));
RDebugUtils.currentLine=25034769;
 //BA.debugLineNum = 25034769;BA.debugLine="no0.Initialize(\"no0\")";
mostCurrent._no0.Initialize(mostCurrent.activityBA,"no0");
RDebugUtils.currentLine=25034770;
 //BA.debugLineNum = 25034770;BA.debugLine="no0.Tag=0";
mostCurrent._no0.setTag((Object)(0));
RDebugUtils.currentLine=25034772;
 //BA.debugLineNum = 25034772;BA.debugLine="ls_shift_moon.Initialize";
mostCurrent._ls_shift_moon.Initialize();
RDebugUtils.currentLine=25034773;
 //BA.debugLineNum = 25034773;BA.debugLine="ls_tatili_moon.Initialize";
mostCurrent._ls_tatili_moon.Initialize();
RDebugUtils.currentLine=25034774;
 //BA.debugLineNum = 25034774;BA.debugLine="ls_note_moon.Initialize";
mostCurrent._ls_note_moon.Initialize();
RDebugUtils.currentLine=25034777;
 //BA.debugLineNum = 25034777;BA.debugLine="list_sift_olgo.Initialize";
mostCurrent._list_sift_olgo.Initialize();
RDebugUtils.currentLine=25034778;
 //BA.debugLineNum = 25034778;BA.debugLine="ls_set_shift.SingleLineLayout.Label.TextColor=Col";
mostCurrent._ls_set_shift.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=25034780;
 //BA.debugLineNum = 25034780;BA.debugLine="ls_set_shift.SingleLineLayout.Label.Width=ls_set_";
mostCurrent._ls_set_shift.getSingleLineLayout().Label.setWidth((int) (mostCurrent._ls_set_shift.getWidth()-30));
RDebugUtils.currentLine=25034781;
 //BA.debugLineNum = 25034781;BA.debugLine="ls_set_shift.SingleLineLayout.Label.Typeface=Type";
mostCurrent._ls_set_shift.getSingleLineLayout().Label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(mostCurrent._myfunc._font_filename /*String*/ (mostCurrent.activityBA)));
RDebugUtils.currentLine=25034784;
 //BA.debugLineNum = 25034784;BA.debugLine="Lb = Array As Label(lbl0,lb1,lb2,lb3,lb4,lb5,lb6,";
mostCurrent._lb = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._lbl0,mostCurrent._lb1,mostCurrent._lb2,mostCurrent._lb3,mostCurrent._lb4,mostCurrent._lb5,mostCurrent._lb6,mostCurrent._lb7,mostCurrent._lb8,mostCurrent._lb9,mostCurrent._lb10,mostCurrent._lb11,mostCurrent._lb12,mostCurrent._lb13,mostCurrent._lb14,mostCurrent._lb15,mostCurrent._lb16,mostCurrent._lb17,mostCurrent._lb18,mostCurrent._lb19,mostCurrent._lb20,mostCurrent._lb21,mostCurrent._lb22,mostCurrent._lb23,mostCurrent._lb24,mostCurrent._lb25,mostCurrent._lb26,mostCurrent._lb27,mostCurrent._lb28,mostCurrent._lb29,mostCurrent._lb30,mostCurrent._lb31,mostCurrent._lb32,mostCurrent._lb33,mostCurrent._lb34,mostCurrent._lb35,mostCurrent._lb36,mostCurrent._lb37,mostCurrent._lb38,mostCurrent._lb39,mostCurrent._lb40,mostCurrent._lb41,mostCurrent._lb42};
RDebugUtils.currentLine=25034786;
 //BA.debugLineNum = 25034786;BA.debugLine="PA = Array As Panel(p0,p1,p2,p3,p4,p5,p6,p7,p8,p9";
mostCurrent._pa = new anywheresoftware.b4a.objects.PanelWrapper[]{mostCurrent._p0,mostCurrent._p1,mostCurrent._p2,mostCurrent._p3,mostCurrent._p4,mostCurrent._p5,mostCurrent._p6,mostCurrent._p7,mostCurrent._p8,mostCurrent._p9,mostCurrent._p10,mostCurrent._p11,mostCurrent._p12,mostCurrent._p13,mostCurrent._p14,mostCurrent._p15,mostCurrent._p16,mostCurrent._p17,mostCurrent._p18,mostCurrent._p19,mostCurrent._p20,mostCurrent._p21,mostCurrent._p22,mostCurrent._p23,mostCurrent._p24,mostCurrent._p25,mostCurrent._p26,mostCurrent._p27,mostCurrent._p28,mostCurrent._p29,mostCurrent._p30,mostCurrent._p31,mostCurrent._p32,mostCurrent._p33,mostCurrent._p34,mostCurrent._p35,mostCurrent._p36,mostCurrent._p37,mostCurrent._p38,mostCurrent._p39,mostCurrent._p40,mostCurrent._p41,mostCurrent._p42};
RDebugUtils.currentLine=25034788;
 //BA.debugLineNum = 25034788;BA.debugLine="SH = Array As Label(sh0,sh1,sh2,sh3,sh4,sh5,sh6,s";
mostCurrent._sh = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._sh0,mostCurrent._sh1,mostCurrent._sh2,mostCurrent._sh3,mostCurrent._sh4,mostCurrent._sh5,mostCurrent._sh6,mostCurrent._sh7,mostCurrent._sh8,mostCurrent._sh9,mostCurrent._sh10,mostCurrent._sh11,mostCurrent._sh12,mostCurrent._sh13,mostCurrent._sh14,mostCurrent._sh15,mostCurrent._sh16,mostCurrent._sh17,mostCurrent._sh18,mostCurrent._sh19,mostCurrent._sh20,mostCurrent._sh21,mostCurrent._sh22,mostCurrent._sh23,mostCurrent._sh24,mostCurrent._sh25,mostCurrent._sh26,mostCurrent._sh27,mostCurrent._sh28,mostCurrent._sh29,mostCurrent._sh30,mostCurrent._sh31,mostCurrent._sh32,mostCurrent._sh33,mostCurrent._sh34,mostCurrent._sh35,mostCurrent._sh36,mostCurrent._sh37,mostCurrent._sh38,mostCurrent._sh39,mostCurrent._sh40,mostCurrent._sh41,mostCurrent._sh42};
RDebugUtils.currentLine=25034790;
 //BA.debugLineNum = 25034790;BA.debugLine="EZ = Array As Label (ez0,ez1,ez2,ez3,ez4,ez5,ez6,";
mostCurrent._ez = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._ez0,mostCurrent._ez1,mostCurrent._ez2,mostCurrent._ez3,mostCurrent._ez4,mostCurrent._ez5,mostCurrent._ez6,mostCurrent._ez7,mostCurrent._ez8,mostCurrent._ez9,mostCurrent._ez10,mostCurrent._ez11,mostCurrent._ez12,mostCurrent._ez13,mostCurrent._ez14,mostCurrent._ez15,mostCurrent._ez16,mostCurrent._ez17,mostCurrent._ez18,mostCurrent._ez19,mostCurrent._ez20,mostCurrent._ez21,mostCurrent._ez22,mostCurrent._ez23,mostCurrent._ez24,mostCurrent._ez25,mostCurrent._ez26,mostCurrent._ez27,mostCurrent._ez28,mostCurrent._ez29,mostCurrent._ez30,mostCurrent._ez31,mostCurrent._ez32,mostCurrent._ez33,mostCurrent._ez34,mostCurrent._ez35,mostCurrent._ez36,mostCurrent._ez37,mostCurrent._ez38,mostCurrent._ez39,mostCurrent._ez40,mostCurrent._ez41,mostCurrent._ez42};
RDebugUtils.currentLine=25034793;
 //BA.debugLineNum = 25034793;BA.debugLine="NO = Array As Label (no0,no1,no2,no3,no4,no5,no6,";
mostCurrent._no = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._no0,mostCurrent._no1,mostCurrent._no2,mostCurrent._no3,mostCurrent._no4,mostCurrent._no5,mostCurrent._no6,mostCurrent._no7,mostCurrent._no8,mostCurrent._no9,mostCurrent._no10,mostCurrent._no11,mostCurrent._no12,mostCurrent._no13,mostCurrent._no14,mostCurrent._no15,mostCurrent._no16,mostCurrent._no17,mostCurrent._no18,mostCurrent._no19,mostCurrent._no20,mostCurrent._no21,mostCurrent._no22,mostCurrent._no23,mostCurrent._no24,mostCurrent._no25,mostCurrent._no26,mostCurrent._no27,mostCurrent._no28,mostCurrent._no29,mostCurrent._no30,mostCurrent._no31,mostCurrent._no32,mostCurrent._no33,mostCurrent._no34,mostCurrent._no35,mostCurrent._no36,mostCurrent._no37,mostCurrent._no38,mostCurrent._no39,mostCurrent._no40,mostCurrent._no41,mostCurrent._no42};
RDebugUtils.currentLine=25034800;
 //BA.debugLineNum = 25034800;BA.debugLine="sp_noe_shift.AddAll(Array As String(\"روزکار(ر)\",\"";
mostCurrent._sp_noe_shift.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"روزکار(ر)","عصرکار(ع)","شبکار(ش)","استراحت(ا)"}));
RDebugUtils.currentLine=25034804;
 //BA.debugLineNum = 25034804;BA.debugLine="this_year=date.PersianYear";
_this_year = mostCurrent._date.getPersianYear();
RDebugUtils.currentLine=25034805;
 //BA.debugLineNum = 25034805;BA.debugLine="this_moon =date.PersianMonth";
_this_moon = mostCurrent._date.getPersianMonth();
RDebugUtils.currentLine=25034806;
 //BA.debugLineNum = 25034806;BA.debugLine="this_day =date.PersianDay";
_this_day = mostCurrent._date.getPersianDay();
RDebugUtils.currentLine=25034809;
 //BA.debugLineNum = 25034809;BA.debugLine="current_moon=date.PersianMonth";
_current_moon = mostCurrent._date.getPersianMonth();
RDebugUtils.currentLine=25034811;
 //BA.debugLineNum = 25034811;BA.debugLine="lbl_year_tagvim.Text=this_year";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_this_year));
RDebugUtils.currentLine=25034822;
 //BA.debugLineNum = 25034822;BA.debugLine="rsPOP_year_tagvim.Initialize(\"rsPOP_year_tagvim\",";
mostCurrent._rspop_year_tagvim.Initialize(mostCurrent.activityBA,"rsPOP_year_tagvim",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_year_tagvim.getObject())));
RDebugUtils.currentLine=25034824;
 //BA.debugLineNum = 25034824;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1398,1398,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1398),(int) (1398),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1398"));
RDebugUtils.currentLine=25034825;
 //BA.debugLineNum = 25034825;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1399,1399,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1399),(int) (1399),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1399"));
RDebugUtils.currentLine=25034826;
 //BA.debugLineNum = 25034826;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1400,1400,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1400),(int) (1400),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1400"));
RDebugUtils.currentLine=25034827;
 //BA.debugLineNum = 25034827;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1401,1401,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1401),(int) (1401),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1401"));
RDebugUtils.currentLine=25034828;
 //BA.debugLineNum = 25034828;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1402,1402,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1402),(int) (1402),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1402"));
RDebugUtils.currentLine=25034829;
 //BA.debugLineNum = 25034829;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1403,1403,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1403),(int) (1403),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1403"));
RDebugUtils.currentLine=25034831;
 //BA.debugLineNum = 25034831;BA.debugLine="rsPOP_moon_tagvim.Initialize(\"rsPOP_moon_tagvim\",";
mostCurrent._rspop_moon_tagvim.Initialize(mostCurrent.activityBA,"rsPOP_moon_tagvim",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_moon_name.getObject())));
RDebugUtils.currentLine=25034834;
 //BA.debugLineNum = 25034834;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(1,1,\"فروردین\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (1),(int) (1),"فروردین");
RDebugUtils.currentLine=25034835;
 //BA.debugLineNum = 25034835;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(2,2,\"اردیبهشت\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (2),(int) (2),"اردیبهشت");
RDebugUtils.currentLine=25034836;
 //BA.debugLineNum = 25034836;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(3,3,\"خرداد\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (3),(int) (3),"خرداد");
RDebugUtils.currentLine=25034837;
 //BA.debugLineNum = 25034837;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(4,4,\"تیر\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (4),(int) (4),"تیر");
RDebugUtils.currentLine=25034838;
 //BA.debugLineNum = 25034838;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(5,5,\"مرداد\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (5),(int) (5),"مرداد");
RDebugUtils.currentLine=25034839;
 //BA.debugLineNum = 25034839;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(6,6,\"شهریور\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (6),(int) (6),"شهریور");
RDebugUtils.currentLine=25034840;
 //BA.debugLineNum = 25034840;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(7,7,\"مهر\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (7),(int) (7),"مهر");
RDebugUtils.currentLine=25034841;
 //BA.debugLineNum = 25034841;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(8,8,\"آبان\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (8),(int) (8),"آبان");
RDebugUtils.currentLine=25034842;
 //BA.debugLineNum = 25034842;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(9,9,\"آذر\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (9),(int) (9),"آذر");
RDebugUtils.currentLine=25034843;
 //BA.debugLineNum = 25034843;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(10,10,\"دی\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (10),(int) (10),"دی");
RDebugUtils.currentLine=25034844;
 //BA.debugLineNum = 25034844;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(11,11,\"بهمن\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (11),(int) (11),"بهمن");
RDebugUtils.currentLine=25034845;
 //BA.debugLineNum = 25034845;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(12,12,\"اسفند\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (12),(int) (12),"اسفند");
RDebugUtils.currentLine=25034853;
 //BA.debugLineNum = 25034853;BA.debugLine="rsPOP_year.Initialize(\"rsPOP_year\",lbl_years)";
mostCurrent._rspop_year.Initialize(mostCurrent.activityBA,"rsPOP_year",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_years.getObject())));
RDebugUtils.currentLine=25034855;
 //BA.debugLineNum = 25034855;BA.debugLine="rsPOP_year.AddMenuItem(1398,1398,myfunc.en2fa(\"13";
mostCurrent._rspop_year.AddMenuItem((int) (1398),(int) (1398),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1398"));
RDebugUtils.currentLine=25034856;
 //BA.debugLineNum = 25034856;BA.debugLine="rsPOP_year.AddMenuItem(1399,1399,myfunc.en2fa(\"13";
mostCurrent._rspop_year.AddMenuItem((int) (1399),(int) (1399),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1399"));
RDebugUtils.currentLine=25034857;
 //BA.debugLineNum = 25034857;BA.debugLine="rsPOP_year.AddMenuItem(1400,1400,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1400),(int) (1400),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1400"));
RDebugUtils.currentLine=25034858;
 //BA.debugLineNum = 25034858;BA.debugLine="rsPOP_year.AddMenuItem(1401,1401,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1401),(int) (1401),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1401"));
RDebugUtils.currentLine=25034859;
 //BA.debugLineNum = 25034859;BA.debugLine="rsPOP_year.AddMenuItem(1402,1402,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1402),(int) (1402),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1402"));
RDebugUtils.currentLine=25034860;
 //BA.debugLineNum = 25034860;BA.debugLine="rsPOP_year.AddMenuItem(1403,1403,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1403),(int) (1403),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1403"));
RDebugUtils.currentLine=25034862;
 //BA.debugLineNum = 25034862;BA.debugLine="rsPOP_mah.Initialize(\"rsPOP_mah\",lbl_mah)";
mostCurrent._rspop_mah.Initialize(mostCurrent.activityBA,"rsPOP_mah",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_mah.getObject())));
RDebugUtils.currentLine=25034864;
 //BA.debugLineNum = 25034864;BA.debugLine="lbl_mah_tagID=1";
_lbl_mah_tagid = (int) (1);
RDebugUtils.currentLine=25034866;
 //BA.debugLineNum = 25034866;BA.debugLine="rsPOP_mah.AddMenuItem(1,1,\"فروردین\")";
mostCurrent._rspop_mah.AddMenuItem((int) (1),(int) (1),"فروردین");
RDebugUtils.currentLine=25034867;
 //BA.debugLineNum = 25034867;BA.debugLine="rsPOP_mah.AddMenuItem(2,2,\"اردیبهشت\")";
mostCurrent._rspop_mah.AddMenuItem((int) (2),(int) (2),"اردیبهشت");
RDebugUtils.currentLine=25034868;
 //BA.debugLineNum = 25034868;BA.debugLine="rsPOP_mah.AddMenuItem(3,3,\"خرداد\")";
mostCurrent._rspop_mah.AddMenuItem((int) (3),(int) (3),"خرداد");
RDebugUtils.currentLine=25034869;
 //BA.debugLineNum = 25034869;BA.debugLine="rsPOP_mah.AddMenuItem(4,4,\"تیر\")";
mostCurrent._rspop_mah.AddMenuItem((int) (4),(int) (4),"تیر");
RDebugUtils.currentLine=25034870;
 //BA.debugLineNum = 25034870;BA.debugLine="rsPOP_mah.AddMenuItem(5,5,\"مرداد\")";
mostCurrent._rspop_mah.AddMenuItem((int) (5),(int) (5),"مرداد");
RDebugUtils.currentLine=25034871;
 //BA.debugLineNum = 25034871;BA.debugLine="rsPOP_mah.AddMenuItem(6,6,\"شهریور\")";
mostCurrent._rspop_mah.AddMenuItem((int) (6),(int) (6),"شهریور");
RDebugUtils.currentLine=25034872;
 //BA.debugLineNum = 25034872;BA.debugLine="rsPOP_mah.AddMenuItem(7,7,\"مهر\")";
mostCurrent._rspop_mah.AddMenuItem((int) (7),(int) (7),"مهر");
RDebugUtils.currentLine=25034873;
 //BA.debugLineNum = 25034873;BA.debugLine="rsPOP_mah.AddMenuItem(8,8,\"آبان\")";
mostCurrent._rspop_mah.AddMenuItem((int) (8),(int) (8),"آبان");
RDebugUtils.currentLine=25034874;
 //BA.debugLineNum = 25034874;BA.debugLine="rsPOP_mah.AddMenuItem(9,9,\"آذر\")";
mostCurrent._rspop_mah.AddMenuItem((int) (9),(int) (9),"آذر");
RDebugUtils.currentLine=25034875;
 //BA.debugLineNum = 25034875;BA.debugLine="rsPOP_mah.AddMenuItem(10,10,\"دی\")";
mostCurrent._rspop_mah.AddMenuItem((int) (10),(int) (10),"دی");
RDebugUtils.currentLine=25034876;
 //BA.debugLineNum = 25034876;BA.debugLine="rsPOP_mah.AddMenuItem(11,11,\"بهمن\")";
mostCurrent._rspop_mah.AddMenuItem((int) (11),(int) (11),"بهمن");
RDebugUtils.currentLine=25034877;
 //BA.debugLineNum = 25034877;BA.debugLine="rsPOP_mah.AddMenuItem(12,12,\"اسفند\")";
mostCurrent._rspop_mah.AddMenuItem((int) (12),(int) (12),"اسفند");
RDebugUtils.currentLine=25034880;
 //BA.debugLineNum = 25034880;BA.debugLine="rsPOP_roz.Initialize(\"rsPOP_roz\",lbl_roz)";
mostCurrent._rspop_roz.Initialize(mostCurrent.activityBA,"rsPOP_roz",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_roz.getObject())));
RDebugUtils.currentLine=25034883;
 //BA.debugLineNum = 25034883;BA.debugLine="For i=1 To 31";
{
final int step75 = 1;
final int limit75 = (int) (31);
_i = (int) (1) ;
for (;_i <= limit75 ;_i = _i + step75 ) {
RDebugUtils.currentLine=25034885;
 //BA.debugLineNum = 25034885;BA.debugLine="rsPOP_roz.AddMenuItem(i,i,myfunc.en2fa(i))";
mostCurrent._rspop_roz.AddMenuItem(_i,_i,mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_i)));
 }
};
RDebugUtils.currentLine=25034889;
 //BA.debugLineNum = 25034889;BA.debugLine="rsPOP_year_end.Initialize(\"rsPOP_year_end\",lbl_ye";
mostCurrent._rspop_year_end.Initialize(mostCurrent.activityBA,"rsPOP_year_end",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_years_end.getObject())));
RDebugUtils.currentLine=25034891;
 //BA.debugLineNum = 25034891;BA.debugLine="rsPOP_year_end.AddMenuItem(1398,1398,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1398),(int) (1398),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1398"));
RDebugUtils.currentLine=25034892;
 //BA.debugLineNum = 25034892;BA.debugLine="rsPOP_year_end.AddMenuItem(1399,1399,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1399),(int) (1399),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1399"));
RDebugUtils.currentLine=25034893;
 //BA.debugLineNum = 25034893;BA.debugLine="rsPOP_year_end.AddMenuItem(1400,1400,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1400),(int) (1400),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1400"));
RDebugUtils.currentLine=25034894;
 //BA.debugLineNum = 25034894;BA.debugLine="rsPOP_year_end.AddMenuItem(1401,1401,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1401),(int) (1401),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1401"));
RDebugUtils.currentLine=25034895;
 //BA.debugLineNum = 25034895;BA.debugLine="rsPOP_year_end.AddMenuItem(1402,1402,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1402),(int) (1402),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1402"));
RDebugUtils.currentLine=25034896;
 //BA.debugLineNum = 25034896;BA.debugLine="rsPOP_year_end.AddMenuItem(1403,1403,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1403),(int) (1403),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1403"));
RDebugUtils.currentLine=25034899;
 //BA.debugLineNum = 25034899;BA.debugLine="rsPOP_mah_end.Initialize(\"rsPOP_mah_end\",lbl_mah_";
mostCurrent._rspop_mah_end.Initialize(mostCurrent.activityBA,"rsPOP_mah_end",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_mah_end.getObject())));
RDebugUtils.currentLine=25034901;
 //BA.debugLineNum = 25034901;BA.debugLine="lbl_mah_end_tagID=12";
_lbl_mah_end_tagid = (int) (12);
RDebugUtils.currentLine=25034903;
 //BA.debugLineNum = 25034903;BA.debugLine="rsPOP_mah_end.AddMenuItem(1,1,\"فروردین\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (1),(int) (1),"فروردین");
RDebugUtils.currentLine=25034904;
 //BA.debugLineNum = 25034904;BA.debugLine="rsPOP_mah_end.AddMenuItem(2,2,\"اردیبهشت\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (2),(int) (2),"اردیبهشت");
RDebugUtils.currentLine=25034905;
 //BA.debugLineNum = 25034905;BA.debugLine="rsPOP_mah_end.AddMenuItem(3,3,\"خرداد\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (3),(int) (3),"خرداد");
RDebugUtils.currentLine=25034906;
 //BA.debugLineNum = 25034906;BA.debugLine="rsPOP_mah_end.AddMenuItem(4,4,\"تیر\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (4),(int) (4),"تیر");
RDebugUtils.currentLine=25034907;
 //BA.debugLineNum = 25034907;BA.debugLine="rsPOP_mah_end.AddMenuItem(5,5,\"مرداد\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (5),(int) (5),"مرداد");
RDebugUtils.currentLine=25034908;
 //BA.debugLineNum = 25034908;BA.debugLine="rsPOP_mah_end.AddMenuItem(6,6,\"شهریور\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (6),(int) (6),"شهریور");
RDebugUtils.currentLine=25034909;
 //BA.debugLineNum = 25034909;BA.debugLine="rsPOP_mah_end.AddMenuItem(7,7,\"مهر\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (7),(int) (7),"مهر");
RDebugUtils.currentLine=25034910;
 //BA.debugLineNum = 25034910;BA.debugLine="rsPOP_mah_end.AddMenuItem(8,8,\"آبان\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (8),(int) (8),"آبان");
RDebugUtils.currentLine=25034911;
 //BA.debugLineNum = 25034911;BA.debugLine="rsPOP_mah_end.AddMenuItem(9,9,\"آذر\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (9),(int) (9),"آذر");
RDebugUtils.currentLine=25034912;
 //BA.debugLineNum = 25034912;BA.debugLine="rsPOP_mah_end.AddMenuItem(10,10,\"دی\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (10),(int) (10),"دی");
RDebugUtils.currentLine=25034913;
 //BA.debugLineNum = 25034913;BA.debugLine="rsPOP_mah_end.AddMenuItem(11,11,\"بهمن\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (11),(int) (11),"بهمن");
RDebugUtils.currentLine=25034914;
 //BA.debugLineNum = 25034914;BA.debugLine="rsPOP_mah_end.AddMenuItem(12,12,\"اسفند\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (12),(int) (12),"اسفند");
RDebugUtils.currentLine=25034916;
 //BA.debugLineNum = 25034916;BA.debugLine="rsPOP_roz_end.Initialize(\"rsPOP_roz_end\",lbl_roz_";
mostCurrent._rspop_roz_end.Initialize(mostCurrent.activityBA,"rsPOP_roz_end",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_roz_end.getObject())));
RDebugUtils.currentLine=25034917;
 //BA.debugLineNum = 25034917;BA.debugLine="For i=1 To 31";
{
final int step100 = 1;
final int limit100 = (int) (31);
_i = (int) (1) ;
for (;_i <= limit100 ;_i = _i + step100 ) {
RDebugUtils.currentLine=25034918;
 //BA.debugLineNum = 25034918;BA.debugLine="rsPOP_roz_end.AddMenuItem(i,i,myfunc.en2fa(i))";
mostCurrent._rspop_roz_end.AddMenuItem(_i,_i,mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_i)));
 }
};
RDebugUtils.currentLine=25034924;
 //BA.debugLineNum = 25034924;BA.debugLine="lbl_go_today_Click";
_lbl_go_today_click();
RDebugUtils.currentLine=25034926;
 //BA.debugLineNum = 25034926;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=25034929;
 //BA.debugLineNum = 25034929;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_go_today_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_go_today_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_go_today_click", null));}
RDebugUtils.currentLine=25100288;
 //BA.debugLineNum = 25100288;BA.debugLine="Private Sub lbl_go_today_Click";
RDebugUtils.currentLine=25100290;
 //BA.debugLineNum = 25100290;BA.debugLine="selectedDay_id=dbCode.get_day_id(this_year,this_m";
_selectedday_id = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_this_year,_this_moon,_this_day);
RDebugUtils.currentLine=25100294;
 //BA.debugLineNum = 25100294;BA.debugLine="generat_taghvim(this_year,this_moon)";
_generat_taghvim(_this_year,_this_moon);
RDebugUtils.currentLine=25100296;
 //BA.debugLineNum = 25100296;BA.debugLine="get_monasebat( selectedDay_id )";
_get_monasebat(_selectedday_id);
RDebugUtils.currentLine=25100297;
 //BA.debugLineNum = 25100297;BA.debugLine="get_note(selectedDay_id)";
_get_note(_selectedday_id);
RDebugUtils.currentLine=25100299;
 //BA.debugLineNum = 25100299;BA.debugLine="get_ezafekari(this_year&\"/\"&myfunc.convert_adad(t";
_get_ezafekari(BA.NumberToString(_this_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_day));
RDebugUtils.currentLine=25100300;
 //BA.debugLineNum = 25100300;BA.debugLine="get_morakhasi(this_year&\"/\"&myfunc.convert_adad(t";
_get_morakhasi(BA.NumberToString(_this_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_day));
RDebugUtils.currentLine=25100301;
 //BA.debugLineNum = 25100301;BA.debugLine="get_taradod(this_year&\"/\"&myfunc.convert_adad(thi";
_get_taradod(BA.NumberToString(_this_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_day));
RDebugUtils.currentLine=25100307;
 //BA.debugLineNum = 25100307;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=26411008;
 //BA.debugLineNum = 26411008;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=26411009;
 //BA.debugLineNum = 26411009;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=26411010;
 //BA.debugLineNum = 26411010;BA.debugLine="If(pan_all_setSift.Visible=True)Then";
if ((mostCurrent._pan_all_setsift.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=26411011;
 //BA.debugLineNum = 26411011;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=26411012;
 //BA.debugLineNum = 26411012;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
 }else 
{RDebugUtils.currentLine=26411014;
 //BA.debugLineNum = 26411014;BA.debugLine="Else If (pan_all_note.Visible=True)Then";
if ((mostCurrent._pan_all_note.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=26411015;
 //BA.debugLineNum = 26411015;BA.debugLine="pan_all_note.Visible=False";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=26411017;
 //BA.debugLineNum = 26411017;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 }}
;
RDebugUtils.currentLine=26411020;
 //BA.debugLineNum = 26411020;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=26411022;
 //BA.debugLineNum = 26411022;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=26411024;
 //BA.debugLineNum = 26411024;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_delete_lis_olgo_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_delete_lis_olgo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_delete_lis_olgo_click", null));}
RDebugUtils.currentLine=27525120;
 //BA.debugLineNum = 27525120;BA.debugLine="Private Sub lbl_delete_lis_olgo_Click";
RDebugUtils.currentLine=27525121;
 //BA.debugLineNum = 27525121;BA.debugLine="ls_set_shift.Clear";
mostCurrent._ls_set_shift.Clear();
RDebugUtils.currentLine=27525122;
 //BA.debugLineNum = 27525122;BA.debugLine="list_sift_olgo.Clear";
mostCurrent._list_sift_olgo.Clear();
RDebugUtils.currentLine=27525123;
 //BA.debugLineNum = 27525123;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=26345472;
 //BA.debugLineNum = 26345472;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=26345474;
 //BA.debugLineNum = 26345474;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=26345475;
 //BA.debugLineNum = 26345475;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="shift_activity";
RDebugUtils.currentLine=26279936;
 //BA.debugLineNum = 26279936;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=26279938;
 //BA.debugLineNum = 26279938;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=26214400;
 //BA.debugLineNum = 26214400;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=26214402;
 //BA.debugLineNum = 26214402;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=26804224;
 //BA.debugLineNum = 26804224;BA.debugLine="Sub generat_taghvim(year As Int , moon As Int)";
RDebugUtils.currentLine=26804225;
 //BA.debugLineNum = 26804225;BA.debugLine="Try";
try {RDebugUtils.currentLine=26804228;
 //BA.debugLineNum = 26804228;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=26804232;
 //BA.debugLineNum = 26804232;BA.debugLine="For d=0 To PA.Length-1";
{
final int step3 = 1;
final int limit3 = (int) (mostCurrent._pa.length-1);
_d = (int) (0) ;
for (;_d <= limit3 ;_d = _d + step3 ) {
RDebugUtils.currentLine=26804233;
 //BA.debugLineNum = 26804233;BA.debugLine="PA(d).Visible=True";
mostCurrent._pa[_d].setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=26804234;
 //BA.debugLineNum = 26804234;BA.debugLine="PA(d).Color=0xFFEFEFEF";
mostCurrent._pa[_d].setColor(((int)0xffefefef));
RDebugUtils.currentLine=26804237;
 //BA.debugLineNum = 26804237;BA.debugLine="EZ(d).Text=\"\"";
mostCurrent._ez[_d].setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=26804238;
 //BA.debugLineNum = 26804238;BA.debugLine="NO(d).Text=\"\"";
mostCurrent._no[_d].setText(BA.ObjectToCharSequence(""));
 }
};
RDebugUtils.currentLine=26804242;
 //BA.debugLineNum = 26804242;BA.debugLine="ls_shift_moon.Clear";
mostCurrent._ls_shift_moon.Clear();
RDebugUtils.currentLine=26804243;
 //BA.debugLineNum = 26804243;BA.debugLine="ls_tatili_moon.Clear";
mostCurrent._ls_tatili_moon.Clear();
RDebugUtils.currentLine=26804244;
 //BA.debugLineNum = 26804244;BA.debugLine="ls_note_moon.Clear";
mostCurrent._ls_note_moon.Clear();
RDebugUtils.currentLine=26804246;
 //BA.debugLineNum = 26804246;BA.debugLine="Dim count_day_moon As Int";
_count_day_moon = 0;
RDebugUtils.currentLine=26804248;
 //BA.debugLineNum = 26804248;BA.debugLine="current_moon=moon";
_current_moon = _moon;
RDebugUtils.currentLine=26804249;
 //BA.debugLineNum = 26804249;BA.debugLine="lbl_moon_name.Tag=moon";
mostCurrent._lbl_moon_name.setTag((Object)(_moon));
RDebugUtils.currentLine=26804250;
 //BA.debugLineNum = 26804250;BA.debugLine="lbl_year_tagvim.Text=year";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_year));
RDebugUtils.currentLine=26804252;
 //BA.debugLineNum = 26804252;BA.debugLine="Select moon";
switch (_moon) {
case 1: {
RDebugUtils.currentLine=26804254;
 //BA.debugLineNum = 26804254;BA.debugLine="lbl_moon_name.Text=\"فروردین\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("فروردین"));
 break; }
case 2: {
RDebugUtils.currentLine=26804256;
 //BA.debugLineNum = 26804256;BA.debugLine="lbl_moon_name.Text=\"اردیبهشت\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("اردیبهشت"));
 break; }
case 3: {
RDebugUtils.currentLine=26804258;
 //BA.debugLineNum = 26804258;BA.debugLine="lbl_moon_name.Text=\"خرداد\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("خرداد"));
 break; }
case 4: {
RDebugUtils.currentLine=26804260;
 //BA.debugLineNum = 26804260;BA.debugLine="lbl_moon_name.Text=\"تیر\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("تیر"));
 break; }
case 5: {
RDebugUtils.currentLine=26804262;
 //BA.debugLineNum = 26804262;BA.debugLine="lbl_moon_name.Text=\"مرداد\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("مرداد"));
 break; }
case 6: {
RDebugUtils.currentLine=26804264;
 //BA.debugLineNum = 26804264;BA.debugLine="lbl_moon_name.Text=\"شهریور\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("شهریور"));
 break; }
case 7: {
RDebugUtils.currentLine=26804266;
 //BA.debugLineNum = 26804266;BA.debugLine="lbl_moon_name.Text=\"مهر\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("مهر"));
 break; }
case 8: {
RDebugUtils.currentLine=26804268;
 //BA.debugLineNum = 26804268;BA.debugLine="lbl_moon_name.Text=\"آبان\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("آبان"));
 break; }
case 9: {
RDebugUtils.currentLine=26804270;
 //BA.debugLineNum = 26804270;BA.debugLine="lbl_moon_name.Text=\"آذر\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("آذر"));
 break; }
case 10: {
RDebugUtils.currentLine=26804272;
 //BA.debugLineNum = 26804272;BA.debugLine="lbl_moon_name.Text=\"دی\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("دی"));
 break; }
case 11: {
RDebugUtils.currentLine=26804274;
 //BA.debugLineNum = 26804274;BA.debugLine="lbl_moon_name.Text=\"بهمن\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("بهمن"));
 break; }
case 12: {
RDebugUtils.currentLine=26804276;
 //BA.debugLineNum = 26804276;BA.debugLine="lbl_moon_name.Text=\"اسفند\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("اسفند"));
 break; }
}
;
RDebugUtils.currentLine=26804282;
 //BA.debugLineNum = 26804282;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE year="+BA.NumberToString(_year)+" AND moon="+BA.NumberToString(_moon)+" ;")));
RDebugUtils.currentLine=26804286;
 //BA.debugLineNum = 26804286;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=26804288;
 //BA.debugLineNum = 26804288;BA.debugLine="count_day_moon=dbCode.res.RowCount";
_count_day_moon = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount();
RDebugUtils.currentLine=26804289;
 //BA.debugLineNum = 26804289;BA.debugLine="dbCode.res.Position =0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=26804290;
 //BA.debugLineNum = 26804290;BA.debugLine="start_day=dbCode.res.Getint(\"day_h\")";
_start_day = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_h");
RDebugUtils.currentLine=26804293;
 //BA.debugLineNum = 26804293;BA.debugLine="For i=0 To dbCode.res.RowCount-1";
{
final int step47 = 1;
final int limit47 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit47 ;_i = _i + step47 ) {
RDebugUtils.currentLine=26804294;
 //BA.debugLineNum = 26804294;BA.debugLine="dbCode.res.Position =i";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_i);
RDebugUtils.currentLine=26804296;
 //BA.debugLineNum = 26804296;BA.debugLine="If (dbCode.res.GetString(\"shift\") = Null)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")== null)) { 
RDebugUtils.currentLine=26804297;
 //BA.debugLineNum = 26804297;BA.debugLine="ls_shift_moon.Add(\"\")";
mostCurrent._ls_shift_moon.Add((Object)(""));
 }else {
RDebugUtils.currentLine=26804299;
 //BA.debugLineNum = 26804299;BA.debugLine="ls_shift_moon.Add(dbCode.res.GetString(\"shift";
mostCurrent._ls_shift_moon.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")));
 };
RDebugUtils.currentLine=26804303;
 //BA.debugLineNum = 26804303;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Th";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=26804304;
 //BA.debugLineNum = 26804304;BA.debugLine="ls_tatili_moon.Add(True)";
mostCurrent._ls_tatili_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.True));
 }else {
RDebugUtils.currentLine=26804306;
 //BA.debugLineNum = 26804306;BA.debugLine="ls_tatili_moon.Add(False)";
mostCurrent._ls_tatili_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.False));
 };
RDebugUtils.currentLine=26804310;
 //BA.debugLineNum = 26804310;BA.debugLine="If (dbCode.res.GetString(\"note\") = \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")).equals(""))) { 
RDebugUtils.currentLine=26804311;
 //BA.debugLineNum = 26804311;BA.debugLine="ls_note_moon.Add(False)";
mostCurrent._ls_note_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.False));
 }else {
RDebugUtils.currentLine=26804313;
 //BA.debugLineNum = 26804313;BA.debugLine="ls_note_moon.Add(True)";
mostCurrent._ls_note_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.True));
 };
 }
};
 }else {
RDebugUtils.currentLine=26804322;
 //BA.debugLineNum = 26804322;BA.debugLine="Log(\"nooop data\")";
anywheresoftware.b4a.keywords.Common.LogImpl("326804322","nooop data",0);
 };
RDebugUtils.currentLine=26804327;
 //BA.debugLineNum = 26804327;BA.debugLine="For  j=start_day-1 To 0 Step -1";
{
final int step68 = -1;
final int limit68 = (int) (0);
_j = (int) (_start_day-1) ;
for (;_j >= limit68 ;_j = _j + step68 ) {
RDebugUtils.currentLine=26804328;
 //BA.debugLineNum = 26804328;BA.debugLine="PA(j).Visible=False";
mostCurrent._pa[_j].setVisible(anywheresoftware.b4a.keywords.Common.False);
 }
};
RDebugUtils.currentLine=26804333;
 //BA.debugLineNum = 26804333;BA.debugLine="Dim counter As Int=1";
_counter = (int) (1);
RDebugUtils.currentLine=26804335;
 //BA.debugLineNum = 26804335;BA.debugLine="For i = start_day To count_day_moon+start_day";
{
final int step72 = 1;
final int limit72 = (int) (_count_day_moon+_start_day);
_i = _start_day ;
for (;_i <= limit72 ;_i = _i + step72 ) {
RDebugUtils.currentLine=26804341;
 //BA.debugLineNum = 26804341;BA.debugLine="Lb(i).Text=counter";
mostCurrent._lb[_i].setText(BA.ObjectToCharSequence(_counter));
RDebugUtils.currentLine=26804342;
 //BA.debugLineNum = 26804342;BA.debugLine="PA(i).Tag=counter";
mostCurrent._pa[_i].setTag((Object)(_counter));
RDebugUtils.currentLine=26804347;
 //BA.debugLineNum = 26804347;BA.debugLine="If(counter-1 < count_day_moon)Then";
if ((_counter-1<_count_day_moon)) { 
RDebugUtils.currentLine=26804348;
 //BA.debugLineNum = 26804348;BA.debugLine="SH(i).Text=ls_shift_moon.Get(counter-1)  ''---s";
mostCurrent._sh[_i].setText(BA.ObjectToCharSequence(mostCurrent._ls_shift_moon.Get((int) (_counter-1))));
RDebugUtils.currentLine=26804353;
 //BA.debugLineNum = 26804353;BA.debugLine="If(ls_tatili_moon.Get(counter-1)=True)Then";
if (((mostCurrent._ls_tatili_moon.Get((int) (_counter-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=26804354;
 //BA.debugLineNum = 26804354;BA.debugLine="PA(i).Color=0xFFFF5252";
mostCurrent._pa[_i].setColor(((int)0xffff5252));
 };
RDebugUtils.currentLine=26804360;
 //BA.debugLineNum = 26804360;BA.debugLine="If(ls_note_moon.Get(counter-1)=True)Then";
if (((mostCurrent._ls_note_moon.Get((int) (_counter-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=26804361;
 //BA.debugLineNum = 26804361;BA.debugLine="NO(i).Text=\"•\"";
mostCurrent._no[_i].setText(BA.ObjectToCharSequence("•"));
RDebugUtils.currentLine=26804362;
 //BA.debugLineNum = 26804362;BA.debugLine="NO(i).textColor=Colors.Blue";
mostCurrent._no[_i].setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 };
RDebugUtils.currentLine=26804367;
 //BA.debugLineNum = 26804367;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(year&\"/\"&my";
if ((mostCurrent._dbcode._isexist_ezafekari_by_date /*boolean*/ (mostCurrent.activityBA,BA.NumberToString(_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_counter))==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=26804368;
 //BA.debugLineNum = 26804368;BA.debugLine="EZ(i).Text=\"*\"";
mostCurrent._ez[_i].setText(BA.ObjectToCharSequence("*"));
RDebugUtils.currentLine=26804369;
 //BA.debugLineNum = 26804369;BA.debugLine="EZ(i).TextColor=0xFF00941C";
mostCurrent._ez[_i].setTextColor(((int)0xff00941c));
 }else 
{RDebugUtils.currentLine=26804370;
 //BA.debugLineNum = 26804370;BA.debugLine="Else if (dbCode.isexist_morakhasi_by_date(year&";
if ((mostCurrent._dbcode._isexist_morakhasi_by_date /*boolean*/ (mostCurrent.activityBA,BA.NumberToString(_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_counter))==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=26804371;
 //BA.debugLineNum = 26804371;BA.debugLine="EZ(i).Text=\"*\"";
mostCurrent._ez[_i].setText(BA.ObjectToCharSequence("*"));
RDebugUtils.currentLine=26804372;
 //BA.debugLineNum = 26804372;BA.debugLine="EZ(i).TextColor=0xFFFF5200";
mostCurrent._ez[_i].setTextColor(((int)0xffff5200));
 }else 
{RDebugUtils.currentLine=26804373;
 //BA.debugLineNum = 26804373;BA.debugLine="Else if (dbCode.isexist_taradod_by_date(year&\"/";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,BA.NumberToString(_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_counter))==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=26804374;
 //BA.debugLineNum = 26804374;BA.debugLine="EZ(i).Text=\"*\"";
mostCurrent._ez[_i].setText(BA.ObjectToCharSequence("*"));
RDebugUtils.currentLine=26804375;
 //BA.debugLineNum = 26804375;BA.debugLine="EZ(i).TextColor=0xFFFF5200";
mostCurrent._ez[_i].setTextColor(((int)0xffff5200));
 }}}
;
 };
RDebugUtils.currentLine=26804384;
 //BA.debugLineNum = 26804384;BA.debugLine="If(counter=this_day And moon=date.PersianMonth A";
if ((_counter==_this_day && _moon==mostCurrent._date.getPersianMonth() && _year==_this_year)) { 
RDebugUtils.currentLine=26804386;
 //BA.debugLineNum = 26804386;BA.debugLine="PA(i).Color=0xFFFFBD30";
mostCurrent._pa[_i].setColor(((int)0xffffbd30));
RDebugUtils.currentLine=26804387;
 //BA.debugLineNum = 26804387;BA.debugLine="index_i_today=i";
_index_i_today = _i;
 };
RDebugUtils.currentLine=26804390;
 //BA.debugLineNum = 26804390;BA.debugLine="If(counter>=count_day_moon)Then";
if ((_counter>=_count_day_moon)) { 
RDebugUtils.currentLine=26804392;
 //BA.debugLineNum = 26804392;BA.debugLine="For f=i+1 To Lb.Length-1";
{
final int step100 = 1;
final int limit100 = (int) (mostCurrent._lb.length-1);
_f = (int) (_i+1) ;
for (;_f <= limit100 ;_f = _f + step100 ) {
RDebugUtils.currentLine=26804393;
 //BA.debugLineNum = 26804393;BA.debugLine="PA(f).Visible=False";
mostCurrent._pa[_f].setVisible(anywheresoftware.b4a.keywords.Common.False);
 }
};
 };
RDebugUtils.currentLine=26804399;
 //BA.debugLineNum = 26804399;BA.debugLine="counter=counter+1";
_counter = (int) (_counter+1);
 }
};
 } 
       catch (Exception e107) {
			processBA.setLastException(e107);RDebugUtils.currentLine=26804403;
 //BA.debugLineNum = 26804403;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("326804403",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=26804407;
 //BA.debugLineNum = 26804407;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=26673152;
 //BA.debugLineNum = 26673152;BA.debugLine="Sub get_ezafekari(date1 As String)";
RDebugUtils.currentLine=26673153;
 //BA.debugLineNum = 26673153;BA.debugLine="lbl_ezafekari_day.Text=\"\"";
mostCurrent._lbl_ezafekari_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=26673154;
 //BA.debugLineNum = 26673154;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=26673155;
 //BA.debugLineNum = 26673155;BA.debugLine="Dim ezList As List";
_ezlist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=26673156;
 //BA.debugLineNum = 26673156;BA.debugLine="ezList.Initialize";
_ezlist.Initialize();
RDebugUtils.currentLine=26673157;
 //BA.debugLineNum = 26673157;BA.debugLine="Dim newLine As String=\"\"";
_newline = "";
RDebugUtils.currentLine=26673159;
 //BA.debugLineNum = 26673159;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"+_date1+"';")));
RDebugUtils.currentLine=26673161;
 //BA.debugLineNum = 26673161;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=26673162;
 //BA.debugLineNum = 26673162;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_k = (int) (0) ;
for (;_k <= limit8 ;_k = _k + step8 ) {
RDebugUtils.currentLine=26673163;
 //BA.debugLineNum = 26673163;BA.debugLine="dbCode.res.Position=K";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_k);
RDebugUtils.currentLine=26673165;
 //BA.debugLineNum = 26673165;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
_ezlist.Add((Object)(_newline+"از "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" تا "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+"  ( "+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_h"))+":"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_m"))+")"));
RDebugUtils.currentLine=26673166;
 //BA.debugLineNum = 26673166;BA.debugLine="newLine=CRLF";
_newline = anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 }else {
RDebugUtils.currentLine=26673172;
 //BA.debugLineNum = 26673172;BA.debugLine="ezList.Add(\"-\")";
_ezlist.Add((Object)("-"));
 };
RDebugUtils.currentLine=26673175;
 //BA.debugLineNum = 26673175;BA.debugLine="For i=0 To ezList.Size-1";
{
final int step16 = 1;
final int limit16 = (int) (_ezlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
RDebugUtils.currentLine=26673176;
 //BA.debugLineNum = 26673176;BA.debugLine="lbl_ezafekari_day.Text=lbl_ezafekari_day.Text &";
mostCurrent._lbl_ezafekari_day.setText(BA.ObjectToCharSequence(mostCurrent._lbl_ezafekari_day.getText()+BA.ObjectToString(_ezlist.Get(_i))));
 }
};
RDebugUtils.currentLine=26673179;
 //BA.debugLineNum = 26673179;BA.debugLine="End Sub";
return "";
}
public static String  _get_monasebat(int _id) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_monasebat", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_monasebat", new Object[] {_id}));}
String _str_sh = "";
RDebugUtils.currentLine=26476544;
 //BA.debugLineNum = 26476544;BA.debugLine="Sub get_monasebat ( id As Int)";
RDebugUtils.currentLine=26476545;
 //BA.debugLineNum = 26476545;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=26476546;
 //BA.debugLineNum = 26476546;BA.debugLine="lbl_today_monasebat.Text=\"\"";
mostCurrent._lbl_today_monasebat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=26476547;
 //BA.debugLineNum = 26476547;BA.debugLine="lbl_today.Text=\"\"";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=26476549;
 //BA.debugLineNum = 26476549;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=26476552;
 //BA.debugLineNum = 26476552;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=26476556;
 //BA.debugLineNum = 26476556;BA.debugLine="If(dbCode.res.GetString(\"monasebat\")<> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("monasebat")).equals("") == false)) { 
RDebugUtils.currentLine=26476557;
 //BA.debugLineNum = 26476557;BA.debugLine="lbl_today_monasebat.Text=dbCode.res.GetString(\"m";
mostCurrent._lbl_today_monasebat.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("monasebat")));
 };
RDebugUtils.currentLine=26476561;
 //BA.debugLineNum = 26476561;BA.debugLine="lbl_today.Text=lbl_year_tagvim.Text&\"/\"&dbCode.re";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("moon")+"/"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_c"))));
RDebugUtils.currentLine=26476564;
 //BA.debugLineNum = 26476564;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=26476565;
 //BA.debugLineNum = 26476565;BA.debugLine="lbl_today.Text=lbl_today.Text&\" (تعطیل) \"";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_today.getText()+" (تعطیل) "));
 };
RDebugUtils.currentLine=26476568;
 //BA.debugLineNum = 26476568;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")).equals("") == false)) { 
RDebugUtils.currentLine=26476569;
 //BA.debugLineNum = 26476569;BA.debugLine="Dim str_sh As String";
_str_sh = "";
RDebugUtils.currentLine=26476570;
 //BA.debugLineNum = 26476570;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift"),"ر","ش","ع","ا")) {
case 0: {
RDebugUtils.currentLine=26476572;
 //BA.debugLineNum = 26476572;BA.debugLine="str_sh=\"روزکار\"";
_str_sh = "روزکار";
 break; }
case 1: {
RDebugUtils.currentLine=26476574;
 //BA.debugLineNum = 26476574;BA.debugLine="str_sh=\"شبکار\"";
_str_sh = "شبکار";
 break; }
case 2: {
RDebugUtils.currentLine=26476576;
 //BA.debugLineNum = 26476576;BA.debugLine="str_sh=\"عصرکار\"";
_str_sh = "عصرکار";
 break; }
case 3: {
RDebugUtils.currentLine=26476578;
 //BA.debugLineNum = 26476578;BA.debugLine="str_sh=\"استراحت\"";
_str_sh = "استراحت";
 break; }
}
;
RDebugUtils.currentLine=26476581;
 //BA.debugLineNum = 26476581;BA.debugLine="lbl_today.Text=lbl_today.Text&\"- (( شیفت : \"&str";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_today.getText()+"- (( شیفت : "+_str_sh+" )) "));
 };
RDebugUtils.currentLine=26476585;
 //BA.debugLineNum = 26476585;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=26738688;
 //BA.debugLineNum = 26738688;BA.debugLine="Sub get_morakhasi(date1 As String)";
RDebugUtils.currentLine=26738689;
 //BA.debugLineNum = 26738689;BA.debugLine="lbl_morakhasi_day.Text=\"\"";
mostCurrent._lbl_morakhasi_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=26738690;
 //BA.debugLineNum = 26738690;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=26738691;
 //BA.debugLineNum = 26738691;BA.debugLine="Dim ezList As List";
_ezlist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=26738692;
 //BA.debugLineNum = 26738692;BA.debugLine="ezList.Initialize";
_ezlist.Initialize();
RDebugUtils.currentLine=26738693;
 //BA.debugLineNum = 26738693;BA.debugLine="Dim newLine As String=\"\"";
_newline = "";
RDebugUtils.currentLine=26738695;
 //BA.debugLineNum = 26738695;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"+_date1+"';")));
RDebugUtils.currentLine=26738697;
 //BA.debugLineNum = 26738697;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=26738698;
 //BA.debugLineNum = 26738698;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_k = (int) (0) ;
for (;_k <= limit8 ;_k = _k + step8 ) {
RDebugUtils.currentLine=26738699;
 //BA.debugLineNum = 26738699;BA.debugLine="dbCode.res.Position=K";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_k);
RDebugUtils.currentLine=26738701;
 //BA.debugLineNum = 26738701;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
_ezlist.Add((Object)(_newline+"از "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" تا "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+"  ( "+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_d"))+":"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_h"))+":"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_m"))+")"));
RDebugUtils.currentLine=26738702;
 //BA.debugLineNum = 26738702;BA.debugLine="newLine=CRLF";
_newline = anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 }else {
RDebugUtils.currentLine=26738708;
 //BA.debugLineNum = 26738708;BA.debugLine="ezList.Add(\"-\")";
_ezlist.Add((Object)("-"));
 };
RDebugUtils.currentLine=26738711;
 //BA.debugLineNum = 26738711;BA.debugLine="For i=0 To ezList.Size-1";
{
final int step16 = 1;
final int limit16 = (int) (_ezlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
RDebugUtils.currentLine=26738712;
 //BA.debugLineNum = 26738712;BA.debugLine="lbl_morakhasi_day.Text=lbl_morakhasi_day.Text &";
mostCurrent._lbl_morakhasi_day.setText(BA.ObjectToCharSequence(mostCurrent._lbl_morakhasi_day.getText()+BA.ObjectToString(_ezlist.Get(_i))));
 }
};
RDebugUtils.currentLine=26738715;
 //BA.debugLineNum = 26738715;BA.debugLine="End Sub";
return "";
}
public static String  _get_note(int _id) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_note", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_note", new Object[] {_id}));}
RDebugUtils.currentLine=26542080;
 //BA.debugLineNum = 26542080;BA.debugLine="Sub get_note ( id As Int)";
RDebugUtils.currentLine=26542081;
 //BA.debugLineNum = 26542081;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=26542082;
 //BA.debugLineNum = 26542082;BA.debugLine="lbl_note_day.Text=\"\"";
mostCurrent._lbl_note_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=26542085;
 //BA.debugLineNum = 26542085;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=26542086;
 //BA.debugLineNum = 26542086;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=26542088;
 //BA.debugLineNum = 26542088;BA.debugLine="If(dbCode.res.GetString(\"note\")<> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")).equals("") == false)) { 
RDebugUtils.currentLine=26542089;
 //BA.debugLineNum = 26542089;BA.debugLine="lbl_note_day.Text=dbCode.res.GetString(\"note\")";
mostCurrent._lbl_note_day.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")));
 };
RDebugUtils.currentLine=26542092;
 //BA.debugLineNum = 26542092;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=26607616;
 //BA.debugLineNum = 26607616;BA.debugLine="Sub get_taradod(date1 As String)";
RDebugUtils.currentLine=26607617;
 //BA.debugLineNum = 26607617;BA.debugLine="lbl_taradod_day.Text=\"\"";
mostCurrent._lbl_taradod_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=26607618;
 //BA.debugLineNum = 26607618;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=26607619;
 //BA.debugLineNum = 26607619;BA.debugLine="Dim ezList As List";
_ezlist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=26607620;
 //BA.debugLineNum = 26607620;BA.debugLine="ezList.Initialize";
_ezlist.Initialize();
RDebugUtils.currentLine=26607621;
 //BA.debugLineNum = 26607621;BA.debugLine="Dim newLine As String=\"\"";
_newline = "";
RDebugUtils.currentLine=26607623;
 //BA.debugLineNum = 26607623;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+_date1+"';")));
RDebugUtils.currentLine=26607625;
 //BA.debugLineNum = 26607625;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=26607626;
 //BA.debugLineNum = 26607626;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_k = (int) (0) ;
for (;_k <= limit8 ;_k = _k + step8 ) {
RDebugUtils.currentLine=26607627;
 //BA.debugLineNum = 26607627;BA.debugLine="dbCode.res.Position=K";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_k);
RDebugUtils.currentLine=26607629;
 //BA.debugLineNum = 26607629;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
_ezlist.Add((Object)(_newline+"از "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" تا "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=26607630;
 //BA.debugLineNum = 26607630;BA.debugLine="newLine=CRLF";
_newline = anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 }else {
RDebugUtils.currentLine=26607634;
 //BA.debugLineNum = 26607634;BA.debugLine="ezList.Add(\"-\")";
_ezlist.Add((Object)("-"));
 };
RDebugUtils.currentLine=26607637;
 //BA.debugLineNum = 26607637;BA.debugLine="For i=0 To ezList.Size-1";
{
final int step16 = 1;
final int limit16 = (int) (_ezlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
RDebugUtils.currentLine=26607638;
 //BA.debugLineNum = 26607638;BA.debugLine="lbl_taradod_day.Text=lbl_taradod_day.Text & ezLi";
mostCurrent._lbl_taradod_day.setText(BA.ObjectToCharSequence(mostCurrent._lbl_taradod_day.getText()+BA.ObjectToString(_ezlist.Get(_i))));
 }
};
RDebugUtils.currentLine=26607641;
 //BA.debugLineNum = 26607641;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_2_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_2_click", null));}
RDebugUtils.currentLine=27459584;
 //BA.debugLineNum = 27459584;BA.debugLine="Private Sub lbl_back_2_Click";
RDebugUtils.currentLine=27459585;
 //BA.debugLineNum = 27459585;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=27459586;
 //BA.debugLineNum = 27459586;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
RDebugUtils.currentLine=27459587;
 //BA.debugLineNum = 27459587;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_del_shiftha_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_del_shiftha_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_del_shiftha_click", null));}
RDebugUtils.currentLine=27590656;
 //BA.debugLineNum = 27590656;BA.debugLine="Private Sub lbl_del_shiftha_Click";
RDebugUtils.currentLine=27590657;
 //BA.debugLineNum = 27590657;BA.debugLine="shift_rest";
_shift_rest();
RDebugUtils.currentLine=27590658;
 //BA.debugLineNum = 27590658;BA.debugLine="End Sub";
return "";
}
public static String  _shift_rest() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "shift_rest", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "shift_rest", null));}
RDebugUtils.currentLine=27656192;
 //BA.debugLineNum = 27656192;BA.debugLine="Sub shift_rest";
RDebugUtils.currentLine=27656193;
 //BA.debugLineNum = 27656193;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=27656194;
 //BA.debugLineNum = 27656194;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' set";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set shift='' ");
RDebugUtils.currentLine=27656195;
 //BA.debugLineNum = 27656195;BA.debugLine="If(File.Exists(File.DirInternal,\"shift_olgo\"))The";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo"))) { 
RDebugUtils.currentLine=27656196;
 //BA.debugLineNum = 27656196;BA.debugLine="File.Delete(File.DirInternal,\"shift_olgo\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo");
RDebugUtils.currentLine=27656197;
 //BA.debugLineNum = 27656197;BA.debugLine="File.Delete(File.DirInternal,\"shift_olgo_cod\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo_cod");
 };
RDebugUtils.currentLine=27656201;
 //BA.debugLineNum = 27656201;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=27656202;
 //BA.debugLineNum = 27656202;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
RDebugUtils.currentLine=27656203;
 //BA.debugLineNum = 27656203;BA.debugLine="generat_taghvim(this_year,this_moon)";
_generat_taghvim(_this_year,_this_moon);
RDebugUtils.currentLine=27656204;
 //BA.debugLineNum = 27656204;BA.debugLine="ToastMessageShow(\"همه شیفت ها حذف شدند\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("همه شیفت ها حذف شدند"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=27656206;
 //BA.debugLineNum = 27656206;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_note_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_note_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_note_click", null));}
RDebugUtils.currentLine=27721728;
 //BA.debugLineNum = 27721728;BA.debugLine="Private Sub lbl_edit_note_Click";
RDebugUtils.currentLine=27721729;
 //BA.debugLineNum = 27721729;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=27721730;
 //BA.debugLineNum = 27721730;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_selectedday_id))));
RDebugUtils.currentLine=27721731;
 //BA.debugLineNum = 27721731;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=27721734;
 //BA.debugLineNum = 27721734;BA.debugLine="et_note.Text=dbCode.res.GetString(\"note\")";
mostCurrent._et_note.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")));
RDebugUtils.currentLine=27721736;
 //BA.debugLineNum = 27721736;BA.debugLine="lbl_date_in_note.Text=lbl_year_tagvim.Text&\"/\"&db";
mostCurrent._lbl_date_in_note.setText(BA.ObjectToCharSequence(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("moon")+"/"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_c"))));
RDebugUtils.currentLine=27721739;
 //BA.debugLineNum = 27721739;BA.debugLine="pan_all_note.Visible=True";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=27721740;
 //BA.debugLineNum = 27721740;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_mah_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_mah_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_mah_click", null));}
RDebugUtils.currentLine=25690112;
 //BA.debugLineNum = 25690112;BA.debugLine="Private Sub lbl_mah_Click";
RDebugUtils.currentLine=25690113;
 //BA.debugLineNum = 25690113;BA.debugLine="rsPOP_mah.Show";
mostCurrent._rspop_mah.Show();
RDebugUtils.currentLine=25690114;
 //BA.debugLineNum = 25690114;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_mah_end_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_mah_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_mah_end_click", null));}
RDebugUtils.currentLine=26083328;
 //BA.debugLineNum = 26083328;BA.debugLine="Private Sub lbl_mah_end_Click";
RDebugUtils.currentLine=26083329;
 //BA.debugLineNum = 26083329;BA.debugLine="rsPOP_mah_end.Show";
mostCurrent._rspop_mah_end.Show();
RDebugUtils.currentLine=26083330;
 //BA.debugLineNum = 26083330;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_moon_name_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_moon_name_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_moon_name_click", null));}
RDebugUtils.currentLine=25296896;
 //BA.debugLineNum = 25296896;BA.debugLine="Private Sub lbl_moon_name_Click";
RDebugUtils.currentLine=25296897;
 //BA.debugLineNum = 25296897;BA.debugLine="rsPOP_moon_tagvim.Show";
mostCurrent._rspop_moon_tagvim.Show();
RDebugUtils.currentLine=25296898;
 //BA.debugLineNum = 25296898;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_new_line_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_new_line_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_new_line_click", null));}
int _i = 0;
RDebugUtils.currentLine=27131904;
 //BA.debugLineNum = 27131904;BA.debugLine="Private Sub lbl_new_line_Click";
RDebugUtils.currentLine=27131907;
 //BA.debugLineNum = 27131907;BA.debugLine="ls_set_shift.AddSingleLine(et_num_roz.Text&\" \"&sp";
mostCurrent._ls_set_shift.AddSingleLine(BA.ObjectToCharSequence(mostCurrent._et_num_roz.getText()+" "+mostCurrent._sp_noe_shift.getSelectedItem()));
RDebugUtils.currentLine=27131908;
 //BA.debugLineNum = 27131908;BA.debugLine="For i=1 To et_num_roz.Text";
{
final int step2 = 1;
final int limit2 = (int)(Double.parseDouble(mostCurrent._et_num_roz.getText()));
_i = (int) (1) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=27131910;
 //BA.debugLineNum = 27131910;BA.debugLine="Select sp_noe_shift.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_noe_shift.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
RDebugUtils.currentLine=27131913;
 //BA.debugLineNum = 27131913;BA.debugLine="list_sift_olgo.Add(\"ر\")";
mostCurrent._list_sift_olgo.Add((Object)("ر"));
 break; }
case 1: {
RDebugUtils.currentLine=27131915;
 //BA.debugLineNum = 27131915;BA.debugLine="list_sift_olgo.Add(\"ع\")";
mostCurrent._list_sift_olgo.Add((Object)("ع"));
 break; }
case 2: {
RDebugUtils.currentLine=27131917;
 //BA.debugLineNum = 27131917;BA.debugLine="list_sift_olgo.Add(\"ش\")";
mostCurrent._list_sift_olgo.Add((Object)("ش"));
 break; }
case 3: {
RDebugUtils.currentLine=27131919;
 //BA.debugLineNum = 27131919;BA.debugLine="list_sift_olgo.Add(\"ا\")";
mostCurrent._list_sift_olgo.Add((Object)("ا"));
 break; }
}
;
 }
};
RDebugUtils.currentLine=27131928;
 //BA.debugLineNum = 27131928;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_next_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_next_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_next_click", null));}
int _adad = 0;
RDebugUtils.currentLine=26935296;
 //BA.debugLineNum = 26935296;BA.debugLine="Private Sub lbl_next_Click";
RDebugUtils.currentLine=26935298;
 //BA.debugLineNum = 26935298;BA.debugLine="If (current_moon>=12)Then";
if ((_current_moon>=12)) { 
RDebugUtils.currentLine=26935300;
 //BA.debugLineNum = 26935300;BA.debugLine="If(lbl_year_tagvim.Text<1403)Then";
if (((double)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()))<1403)) { 
RDebugUtils.currentLine=26935301;
 //BA.debugLineNum = 26935301;BA.debugLine="Dim adad As Int=lbl_year_tagvim.Text";
_adad = (int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()));
RDebugUtils.currentLine=26935302;
 //BA.debugLineNum = 26935302;BA.debugLine="lbl_year_tagvim.Text=adad+1";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_adad+1));
RDebugUtils.currentLine=26935303;
 //BA.debugLineNum = 26935303;BA.debugLine="current_moon=1";
_current_moon = (int) (1);
 }else {
RDebugUtils.currentLine=26935305;
 //BA.debugLineNum = 26935305;BA.debugLine="current_moon=12";
_current_moon = (int) (12);
 };
 }else {
RDebugUtils.currentLine=26935311;
 //BA.debugLineNum = 26935311;BA.debugLine="current_moon=current_moon+1";
_current_moon = (int) (_current_moon+1);
 };
RDebugUtils.currentLine=26935313;
 //BA.debugLineNum = 26935313;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_current_moon);
RDebugUtils.currentLine=26935315;
 //BA.debugLineNum = 26935315;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_prev_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_prev_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_prev_click", null));}
int _adad = 0;
RDebugUtils.currentLine=27000832;
 //BA.debugLineNum = 27000832;BA.debugLine="Private Sub lbl_prev_Click";
RDebugUtils.currentLine=27000834;
 //BA.debugLineNum = 27000834;BA.debugLine="If (current_moon<=1)Then";
if ((_current_moon<=1)) { 
RDebugUtils.currentLine=27000837;
 //BA.debugLineNum = 27000837;BA.debugLine="If(lbl_year_tagvim.Text>1398)Then";
if (((double)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()))>1398)) { 
RDebugUtils.currentLine=27000838;
 //BA.debugLineNum = 27000838;BA.debugLine="Dim adad As Int=lbl_year_tagvim.Text";
_adad = (int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()));
RDebugUtils.currentLine=27000839;
 //BA.debugLineNum = 27000839;BA.debugLine="lbl_year_tagvim.Text=adad-1";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_adad-1));
RDebugUtils.currentLine=27000840;
 //BA.debugLineNum = 27000840;BA.debugLine="current_moon=12";
_current_moon = (int) (12);
 }else {
RDebugUtils.currentLine=27000842;
 //BA.debugLineNum = 27000842;BA.debugLine="current_moon=1";
_current_moon = (int) (1);
 };
 }else {
RDebugUtils.currentLine=27000847;
 //BA.debugLineNum = 27000847;BA.debugLine="current_moon=current_moon-1";
_current_moon = (int) (_current_moon-1);
 };
RDebugUtils.currentLine=27000849;
 //BA.debugLineNum = 27000849;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_current_moon);
RDebugUtils.currentLine=27000851;
 //BA.debugLineNum = 27000851;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_roz_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_roz_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_roz_click", null));}
RDebugUtils.currentLine=25755648;
 //BA.debugLineNum = 25755648;BA.debugLine="Private Sub lbl_roz_Click";
RDebugUtils.currentLine=25755649;
 //BA.debugLineNum = 25755649;BA.debugLine="rsPOP_roz.Show";
mostCurrent._rspop_roz.Show();
RDebugUtils.currentLine=25755650;
 //BA.debugLineNum = 25755650;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_roz_end_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_roz_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_roz_end_click", null));}
RDebugUtils.currentLine=26148864;
 //BA.debugLineNum = 26148864;BA.debugLine="Private Sub lbl_roz_end_Click";
RDebugUtils.currentLine=26148865;
 //BA.debugLineNum = 26148865;BA.debugLine="rsPOP_roz_end.Show";
mostCurrent._rspop_roz_end.Show();
RDebugUtils.currentLine=26148866;
 //BA.debugLineNum = 26148866;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_note_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_note_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_note_click", null));}
RDebugUtils.currentLine=27983872;
 //BA.debugLineNum = 27983872;BA.debugLine="Private Sub lbl_save_note_Click";
RDebugUtils.currentLine=27983874;
 //BA.debugLineNum = 27983874;BA.debugLine="set_note(selectedDay_id,et_note.Text)";
_set_note(_selectedday_id,mostCurrent._et_note.getText());
RDebugUtils.currentLine=27983875;
 //BA.debugLineNum = 27983875;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,lbl_moon_nam";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())));
RDebugUtils.currentLine=27983876;
 //BA.debugLineNum = 27983876;BA.debugLine="pan_all_note.Visible=False";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=27983877;
 //BA.debugLineNum = 27983877;BA.debugLine="End Sub";
return "";
}
public static String  _set_note(int _id,String _matn) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "set_note", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "set_note", new Object[] {_id,_matn}));}
RDebugUtils.currentLine=28049408;
 //BA.debugLineNum = 28049408;BA.debugLine="Sub set_note(id As Int , matn As String)";
RDebugUtils.currentLine=28049409;
 //BA.debugLineNum = 28049409;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=28049410;
 //BA.debugLineNum = 28049410;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' set";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set note='"+_matn+"' WHERE id="+BA.NumberToString(_id));
RDebugUtils.currentLine=28049412;
 //BA.debugLineNum = 28049412;BA.debugLine="ToastMessageShow(\"یادداشت ذخیره شد\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("یادداشت ذخیره شد"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=28049413;
 //BA.debugLineNum = 28049413;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_shift_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_shift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_shift_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_tosave = null;
int _p = 0;
RDebugUtils.currentLine=27197440;
 //BA.debugLineNum = 27197440;BA.debugLine="Private Sub lbl_save_shift_Click";
RDebugUtils.currentLine=27197443;
 //BA.debugLineNum = 27197443;BA.debugLine="If(ls_set_shift.Size<1)Then";
if ((mostCurrent._ls_set_shift.getSize()<1)) { 
RDebugUtils.currentLine=27197444;
 //BA.debugLineNum = 27197444;BA.debugLine="ToastMessageShow(\"الگو باید حداقل یک مورد باشد\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("الگو باید حداقل یک مورد باشد"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=27197449;
 //BA.debugLineNum = 27197449;BA.debugLine="set_shift(list_sift_olgo)";
_set_shift(mostCurrent._list_sift_olgo);
RDebugUtils.currentLine=27197452;
 //BA.debugLineNum = 27197452;BA.debugLine="Dim ls_toSave As List";
_ls_tosave = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=27197453;
 //BA.debugLineNum = 27197453;BA.debugLine="ls_toSave.Initialize";
_ls_tosave.Initialize();
RDebugUtils.currentLine=27197455;
 //BA.debugLineNum = 27197455;BA.debugLine="For p=0 To ls_set_shift.Size-1";
{
final int step7 = 1;
final int limit7 = (int) (mostCurrent._ls_set_shift.getSize()-1);
_p = (int) (0) ;
for (;_p <= limit7 ;_p = _p + step7 ) {
RDebugUtils.currentLine=27197456;
 //BA.debugLineNum = 27197456;BA.debugLine="ls_toSave.Add(ls_set_shift.GetItem(p))";
_ls_tosave.Add(mostCurrent._ls_set_shift.GetItem(_p));
 }
};
RDebugUtils.currentLine=27197459;
 //BA.debugLineNum = 27197459;BA.debugLine="File.WriteList(File.DirInternal,\"shift_olgo\",ls_";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo",_ls_tosave);
RDebugUtils.currentLine=27197460;
 //BA.debugLineNum = 27197460;BA.debugLine="File.WriteList(File.DirInternal,\"shift_olgo_cod\"";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo_cod",mostCurrent._list_sift_olgo);
RDebugUtils.currentLine=27197463;
 //BA.debugLineNum = 27197463;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=27197467;
 //BA.debugLineNum = 27197467;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
RDebugUtils.currentLine=27197468;
 //BA.debugLineNum = 27197468;BA.debugLine="generat_taghvim(this_year,this_moon)";
_generat_taghvim(_this_year,_this_moon);
 };
RDebugUtils.currentLine=27197473;
 //BA.debugLineNum = 27197473;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=27328512;
 //BA.debugLineNum = 27328512;BA.debugLine="Sub set_shift(ol As List )";
RDebugUtils.currentLine=27328514;
 //BA.debugLineNum = 27328514;BA.debugLine="Try";
try {RDebugUtils.currentLine=27328515;
 //BA.debugLineNum = 27328515;BA.debugLine="ProgressDialogShow(\"در حال تنظیم شیفت ها\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("در حال تنظیم شیفت ها"));
RDebugUtils.currentLine=27328517;
 //BA.debugLineNum = 27328517;BA.debugLine="Dim start_shift As Int";
_start_shift = 0;
RDebugUtils.currentLine=27328518;
 //BA.debugLineNum = 27328518;BA.debugLine="Dim end_shift As Int";
_end_shift = 0;
RDebugUtils.currentLine=27328520;
 //BA.debugLineNum = 27328520;BA.debugLine="Dim index_curent_shift As Int=0";
_index_curent_shift = (int) (0);
RDebugUtils.currentLine=27328521;
 //BA.debugLineNum = 27328521;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=27328523;
 //BA.debugLineNum = 27328523;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' se";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set shift=''");
RDebugUtils.currentLine=27328526;
 //BA.debugLineNum = 27328526;BA.debugLine="start_shift=dbCode.get_day_id(lbl_years.Text,lbl";
_start_shift = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_years.getText())),_lbl_mah_tagid,(int)(Double.parseDouble(mostCurrent._lbl_roz.getText())));
RDebugUtils.currentLine=27328527;
 //BA.debugLineNum = 27328527;BA.debugLine="end_shift=dbCode.get_day_id(lbl_years_end.Text,l";
_end_shift = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_years_end.getText())),_lbl_mah_end_tagid,(int)(Double.parseDouble(mostCurrent._lbl_roz_end.getText())));
RDebugUtils.currentLine=27328530;
 //BA.debugLineNum = 27328530;BA.debugLine="For i=start_shift To end_shift";
{
final int step10 = 1;
final int limit10 = _end_shift;
_i = _start_shift ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=27328532;
 //BA.debugLineNum = 27328532;BA.debugLine="dbCode.sql.ExecNonQuery2(\"UPDATE 'my_calander'";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE 'my_calander' set shift=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{mostCurrent._list_sift_olgo.Get(_index_curent_shift),(Object)(_i)}));
RDebugUtils.currentLine=27328535;
 //BA.debugLineNum = 27328535;BA.debugLine="If(index_curent_shift=list_sift_olgo.Size-1)The";
if ((_index_curent_shift==mostCurrent._list_sift_olgo.getSize()-1)) { 
RDebugUtils.currentLine=27328536;
 //BA.debugLineNum = 27328536;BA.debugLine="index_curent_shift=0";
_index_curent_shift = (int) (0);
 }else {
RDebugUtils.currentLine=27328538;
 //BA.debugLineNum = 27328538;BA.debugLine="index_curent_shift=index_curent_shift+1";
_index_curent_shift = (int) (_index_curent_shift+1);
 };
 }
};
RDebugUtils.currentLine=27328543;
 //BA.debugLineNum = 27328543;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=27328544;
 //BA.debugLineNum = 27328544;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 } 
       catch (Exception e21) {
			processBA.setLastException(e21);RDebugUtils.currentLine=27328547;
 //BA.debugLineNum = 27328547;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("327328547",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=27328548;
 //BA.debugLineNum = 27328548;BA.debugLine="ToastMessageShow(\"خطا در تاریخ\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در تاریخ"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=27328554;
 //BA.debugLineNum = 27328554;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_show_panshift_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_show_panshift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_show_panshift_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_toload = null;
int _i = 0;
RDebugUtils.currentLine=27262976;
 //BA.debugLineNum = 27262976;BA.debugLine="Private Sub lbl_show_panShift_Click";
RDebugUtils.currentLine=27262978;
 //BA.debugLineNum = 27262978;BA.debugLine="If(File.Exists(File.DirInternal,\"shift_olgo\")=Tru";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=27262980;
 //BA.debugLineNum = 27262980;BA.debugLine="Dim ls_toLoad As List";
_ls_toload = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=27262981;
 //BA.debugLineNum = 27262981;BA.debugLine="ls_toLoad.Initialize";
_ls_toload.Initialize();
RDebugUtils.currentLine=27262983;
 //BA.debugLineNum = 27262983;BA.debugLine="ls_toLoad=File.ReadList(File.DirInternal,\"shift_";
_ls_toload = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo");
RDebugUtils.currentLine=27262985;
 //BA.debugLineNum = 27262985;BA.debugLine="For i=0 To ls_toLoad.Size-1";
{
final int step5 = 1;
final int limit5 = (int) (_ls_toload.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=27262986;
 //BA.debugLineNum = 27262986;BA.debugLine="ls_set_shift.AddSingleLine(ls_toLoad.Get(i))";
mostCurrent._ls_set_shift.AddSingleLine(BA.ObjectToCharSequence(_ls_toload.Get(_i)));
 }
};
RDebugUtils.currentLine=27262989;
 //BA.debugLineNum = 27262989;BA.debugLine="list_sift_olgo=File.ReadList(File.DirInternal,\"s";
mostCurrent._list_sift_olgo = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo_cod");
 };
RDebugUtils.currentLine=27262993;
 //BA.debugLineNum = 27262993;BA.debugLine="pan_all_setSift.Visible=True";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=27262995;
 //BA.debugLineNum = 27262995;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_year_tagvim_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_year_tagvim_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_year_tagvim_click", null));}
RDebugUtils.currentLine=25231360;
 //BA.debugLineNum = 25231360;BA.debugLine="Private Sub lbl_year_tagvim_Click";
RDebugUtils.currentLine=25231361;
 //BA.debugLineNum = 25231361;BA.debugLine="rsPOP_year_tagvim.Show";
mostCurrent._rspop_year_tagvim.Show();
RDebugUtils.currentLine=25231362;
 //BA.debugLineNum = 25231362;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_years_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_years_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_years_click", null));}
RDebugUtils.currentLine=25624576;
 //BA.debugLineNum = 25624576;BA.debugLine="Private Sub lbl_years_Click";
RDebugUtils.currentLine=25624577;
 //BA.debugLineNum = 25624577;BA.debugLine="rsPOP_year.Show";
mostCurrent._rspop_year.Show();
RDebugUtils.currentLine=25624578;
 //BA.debugLineNum = 25624578;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_years_end_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_years_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_years_end_click", null));}
RDebugUtils.currentLine=26017792;
 //BA.debugLineNum = 26017792;BA.debugLine="Private Sub lbl_years_end_Click";
RDebugUtils.currentLine=26017793;
 //BA.debugLineNum = 26017793;BA.debugLine="rsPOP_year_end.Show";
mostCurrent._rspop_year_end.Show();
RDebugUtils.currentLine=26017794;
 //BA.debugLineNum = 26017794;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=26869760;
 //BA.debugLineNum = 26869760;BA.debugLine="Private Sub PA_Click";
RDebugUtils.currentLine=26869761;
 //BA.debugLineNum = 26869761;BA.debugLine="Dim str_t As String";
_str_t = "";
RDebugUtils.currentLine=26869762;
 //BA.debugLineNum = 26869762;BA.debugLine="Dim B As Panel = Sender";
_b = new anywheresoftware.b4a.objects.PanelWrapper();
_b = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=26869763;
 //BA.debugLineNum = 26869763;BA.debugLine="selectedDay_id=dbCode.get_day_id(lbl_year_tagvim.";
_selectedday_id = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())),(int)(BA.ObjectToNumber(_b.getTag())));
RDebugUtils.currentLine=26869765;
 //BA.debugLineNum = 26869765;BA.debugLine="For d=0 To PA.Length-1";
{
final int step4 = 1;
final int limit4 = (int) (mostCurrent._pa.length-1);
_d = (int) (0) ;
for (;_d <= limit4 ;_d = _d + step4 ) {
RDebugUtils.currentLine=26869766;
 //BA.debugLineNum = 26869766;BA.debugLine="str_t=PA(d).Tag";
_str_t = BA.ObjectToString(mostCurrent._pa[_d].getTag());
RDebugUtils.currentLine=26869767;
 //BA.debugLineNum = 26869767;BA.debugLine="If ( str_t = last_selected_itemTag )Then";
if (((_str_t).equals(BA.NumberToString(_last_selected_itemtag)))) { 
RDebugUtils.currentLine=26869771;
 //BA.debugLineNum = 26869771;BA.debugLine="If(last_selected_itemTag<>0)Then";
if ((_last_selected_itemtag!=0)) { 
RDebugUtils.currentLine=26869773;
 //BA.debugLineNum = 26869773;BA.debugLine="If(ls_tatili_moon.Get(last_selected_itemTag-1)";
if (((mostCurrent._ls_tatili_moon.Get((int) (_last_selected_itemtag-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=26869774;
 //BA.debugLineNum = 26869774;BA.debugLine="PA(d).Color=0xFFFF5252";
mostCurrent._pa[_d].setColor(((int)0xffff5252));
 }else {
RDebugUtils.currentLine=26869776;
 //BA.debugLineNum = 26869776;BA.debugLine="PA(d).Color=0xFFEFEFEF";
mostCurrent._pa[_d].setColor(((int)0xffefefef));
 };
 };
 };
 }
};
RDebugUtils.currentLine=26869788;
 //BA.debugLineNum = 26869788;BA.debugLine="Dim moon_tag As Int=lbl_moon_name.Tag";
_moon_tag = (int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag()));
RDebugUtils.currentLine=26869789;
 //BA.debugLineNum = 26869789;BA.debugLine="If( moon_tag=this_moon)Then";
if ((_moon_tag==_this_moon)) { 
RDebugUtils.currentLine=26869790;
 //BA.debugLineNum = 26869790;BA.debugLine="PA(index_i_today).Color=0xFFFFBD30";
mostCurrent._pa[_index_i_today].setColor(((int)0xffffbd30));
 };
RDebugUtils.currentLine=26869795;
 //BA.debugLineNum = 26869795;BA.debugLine="B.Color=Colors.Gray";
_b.setColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=26869796;
 //BA.debugLineNum = 26869796;BA.debugLine="get_monasebat(selectedDay_id)";
_get_monasebat(_selectedday_id);
RDebugUtils.currentLine=26869797;
 //BA.debugLineNum = 26869797;BA.debugLine="get_note(selectedDay_id)";
_get_note(_selectedday_id);
RDebugUtils.currentLine=26869799;
 //BA.debugLineNum = 26869799;BA.debugLine="get_ezafekari(lbl_year_tagvim.Text&\"/\"&myfunc.con";
_get_ezafekari(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))));
RDebugUtils.currentLine=26869800;
 //BA.debugLineNum = 26869800;BA.debugLine="get_morakhasi(lbl_year_tagvim.Text&\"/\"&myfunc.con";
_get_morakhasi(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))));
RDebugUtils.currentLine=26869801;
 //BA.debugLineNum = 26869801;BA.debugLine="get_taradod(lbl_year_tagvim.Text&\"/\"&myfunc.conve";
_get_taradod(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))));
RDebugUtils.currentLine=26869803;
 //BA.debugLineNum = 26869803;BA.debugLine="last_selected_itemTag=B.Tag";
_last_selected_itemtag = (int)(BA.ObjectToNumber(_b.getTag()));
RDebugUtils.currentLine=26869806;
 //BA.debugLineNum = 26869806;BA.debugLine="End Sub";
return "";
}
public static String  _pa_longclick() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pa_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pa_longclick", null));}
anywheresoftware.b4a.objects.PanelWrapper _b = null;
RDebugUtils.currentLine=27787264;
 //BA.debugLineNum = 27787264;BA.debugLine="Private Sub PA_LongClick";
RDebugUtils.currentLine=27787265;
 //BA.debugLineNum = 27787265;BA.debugLine="Dim B As Panel = Sender";
_b = new anywheresoftware.b4a.objects.PanelWrapper();
_b = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=27787267;
 //BA.debugLineNum = 27787267;BA.debugLine="selectedDay_id=dbCode.get_day_id(lbl_year_tagvim.";
_selectedday_id = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())),(int)(BA.ObjectToNumber(_b.getTag())));
RDebugUtils.currentLine=27787269;
 //BA.debugLineNum = 27787269;BA.debugLine="B.Color=Colors.Gray";
_b.setColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=27787271;
 //BA.debugLineNum = 27787271;BA.debugLine="lbl_edit_note_Click";
_lbl_edit_note_click();
RDebugUtils.currentLine=27787273;
 //BA.debugLineNum = 27787273;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_note_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_note_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_note_click", null));}
RDebugUtils.currentLine=27852800;
 //BA.debugLineNum = 27852800;BA.debugLine="Private Sub pan_all_note_Click";
RDebugUtils.currentLine=27852801;
 //BA.debugLineNum = 27852801;BA.debugLine="pan_all_note.Visible=False";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=27852802;
 //BA.debugLineNum = 27852802;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_setsift_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_setsift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_setsift_click", null));}
RDebugUtils.currentLine=27066368;
 //BA.debugLineNum = 27066368;BA.debugLine="Private Sub pan_all_setSift_Click";
RDebugUtils.currentLine=27066370;
 //BA.debugLineNum = 27066370;BA.debugLine="End Sub";
return "";
}
public static String  _panel12_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel12_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel12_click", null));}
RDebugUtils.currentLine=27918336;
 //BA.debugLineNum = 27918336;BA.debugLine="Private Sub Panel12_Click";
RDebugUtils.currentLine=27918338;
 //BA.debugLineNum = 27918338;BA.debugLine="End Sub";
return "";
}
public static boolean  _rspop_mah_end_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_mah_end_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_mah_end_menuitemclick", new Object[] {_itemid}));}
String _mmah = "";
RDebugUtils.currentLine=25886720;
 //BA.debugLineNum = 25886720;BA.debugLine="Sub rsPOP_mah_end_MenuItemClick (ItemId As Int) As";
RDebugUtils.currentLine=25886721;
 //BA.debugLineNum = 25886721;BA.debugLine="Dim mmah As String";
_mmah = "";
RDebugUtils.currentLine=25886722;
 //BA.debugLineNum = 25886722;BA.debugLine="Select ItemId";
switch (_itemid) {
case 1: {
RDebugUtils.currentLine=25886724;
 //BA.debugLineNum = 25886724;BA.debugLine="mmah=\"فروردین\"";
_mmah = "فروردین";
 break; }
case 2: {
RDebugUtils.currentLine=25886726;
 //BA.debugLineNum = 25886726;BA.debugLine="mmah=\"اردیبهشت\"";
_mmah = "اردیبهشت";
 break; }
case 3: {
RDebugUtils.currentLine=25886728;
 //BA.debugLineNum = 25886728;BA.debugLine="mmah=\"خرداد\"";
_mmah = "خرداد";
 break; }
case 4: {
RDebugUtils.currentLine=25886730;
 //BA.debugLineNum = 25886730;BA.debugLine="mmah=\"تیر\"";
_mmah = "تیر";
 break; }
case 5: {
RDebugUtils.currentLine=25886732;
 //BA.debugLineNum = 25886732;BA.debugLine="mmah=\"مرداد\"";
_mmah = "مرداد";
 break; }
case 6: {
RDebugUtils.currentLine=25886734;
 //BA.debugLineNum = 25886734;BA.debugLine="mmah=\"شهریور\"";
_mmah = "شهریور";
 break; }
case 7: {
RDebugUtils.currentLine=25886736;
 //BA.debugLineNum = 25886736;BA.debugLine="mmah=\"مهر\"";
_mmah = "مهر";
 break; }
case 8: {
RDebugUtils.currentLine=25886738;
 //BA.debugLineNum = 25886738;BA.debugLine="mmah=\"آبان\"";
_mmah = "آبان";
 break; }
case 9: {
RDebugUtils.currentLine=25886740;
 //BA.debugLineNum = 25886740;BA.debugLine="mmah=\"آذر\"";
_mmah = "آذر";
 break; }
case 10: {
RDebugUtils.currentLine=25886742;
 //BA.debugLineNum = 25886742;BA.debugLine="mmah=\"دی\"";
_mmah = "دی";
 break; }
case 11: {
RDebugUtils.currentLine=25886744;
 //BA.debugLineNum = 25886744;BA.debugLine="mmah=\"بهمن\"";
_mmah = "بهمن";
 break; }
case 12: {
RDebugUtils.currentLine=25886746;
 //BA.debugLineNum = 25886746;BA.debugLine="mmah=\"اسفند\"";
_mmah = "اسفند";
 break; }
}
;
RDebugUtils.currentLine=25886752;
 //BA.debugLineNum = 25886752;BA.debugLine="lbl_mah_end.Text=mmah";
mostCurrent._lbl_mah_end.setText(BA.ObjectToCharSequence(_mmah));
RDebugUtils.currentLine=25886753;
 //BA.debugLineNum = 25886753;BA.debugLine="lbl_mah_end_tagID=ItemId";
_lbl_mah_end_tagid = _itemid;
RDebugUtils.currentLine=25886755;
 //BA.debugLineNum = 25886755;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=25886756;
 //BA.debugLineNum = 25886756;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_mah_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_mah_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_mah_menuitemclick", new Object[] {_itemid}));}
String _mmah = "";
RDebugUtils.currentLine=25493504;
 //BA.debugLineNum = 25493504;BA.debugLine="Sub rsPOP_mah_MenuItemClick (ItemId As Int) As Boo";
RDebugUtils.currentLine=25493505;
 //BA.debugLineNum = 25493505;BA.debugLine="Dim mmah As String";
_mmah = "";
RDebugUtils.currentLine=25493506;
 //BA.debugLineNum = 25493506;BA.debugLine="Select ItemId";
switch (_itemid) {
case 1: {
RDebugUtils.currentLine=25493508;
 //BA.debugLineNum = 25493508;BA.debugLine="mmah=\"فروردین\"";
_mmah = "فروردین";
 break; }
case 2: {
RDebugUtils.currentLine=25493510;
 //BA.debugLineNum = 25493510;BA.debugLine="mmah=\"اردیبهشت\"";
_mmah = "اردیبهشت";
 break; }
case 3: {
RDebugUtils.currentLine=25493512;
 //BA.debugLineNum = 25493512;BA.debugLine="mmah=\"خرداد\"";
_mmah = "خرداد";
 break; }
case 4: {
RDebugUtils.currentLine=25493514;
 //BA.debugLineNum = 25493514;BA.debugLine="mmah=\"تیر\"";
_mmah = "تیر";
 break; }
case 5: {
RDebugUtils.currentLine=25493516;
 //BA.debugLineNum = 25493516;BA.debugLine="mmah=\"مرداد\"";
_mmah = "مرداد";
 break; }
case 6: {
RDebugUtils.currentLine=25493518;
 //BA.debugLineNum = 25493518;BA.debugLine="mmah=\"شهریور\"";
_mmah = "شهریور";
 break; }
case 7: {
RDebugUtils.currentLine=25493520;
 //BA.debugLineNum = 25493520;BA.debugLine="mmah=\"مهر\"";
_mmah = "مهر";
 break; }
case 8: {
RDebugUtils.currentLine=25493522;
 //BA.debugLineNum = 25493522;BA.debugLine="mmah=\"آبان\"";
_mmah = "آبان";
 break; }
case 9: {
RDebugUtils.currentLine=25493524;
 //BA.debugLineNum = 25493524;BA.debugLine="mmah=\"آذر\"";
_mmah = "آذر";
 break; }
case 10: {
RDebugUtils.currentLine=25493526;
 //BA.debugLineNum = 25493526;BA.debugLine="mmah=\"دی\"";
_mmah = "دی";
 break; }
case 11: {
RDebugUtils.currentLine=25493528;
 //BA.debugLineNum = 25493528;BA.debugLine="mmah=\"بهمن\"";
_mmah = "بهمن";
 break; }
case 12: {
RDebugUtils.currentLine=25493530;
 //BA.debugLineNum = 25493530;BA.debugLine="mmah=\"اسفند\"";
_mmah = "اسفند";
 break; }
}
;
RDebugUtils.currentLine=25493534;
 //BA.debugLineNum = 25493534;BA.debugLine="lbl_mah.Text=mmah";
mostCurrent._lbl_mah.setText(BA.ObjectToCharSequence(_mmah));
RDebugUtils.currentLine=25493535;
 //BA.debugLineNum = 25493535;BA.debugLine="lbl_mah_tagID=ItemId";
_lbl_mah_tagid = _itemid;
RDebugUtils.currentLine=25493537;
 //BA.debugLineNum = 25493537;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=25493538;
 //BA.debugLineNum = 25493538;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_moon_tagvim_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_moon_tagvim_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_moon_tagvim_menuitemclick", new Object[] {_itemid}));}
String _mmah = "";
RDebugUtils.currentLine=25362432;
 //BA.debugLineNum = 25362432;BA.debugLine="Sub rsPOP_moon_tagvim_MenuItemClick (ItemId As Int";
RDebugUtils.currentLine=25362433;
 //BA.debugLineNum = 25362433;BA.debugLine="Dim mmah As String";
_mmah = "";
RDebugUtils.currentLine=25362434;
 //BA.debugLineNum = 25362434;BA.debugLine="Select ItemId";
switch (_itemid) {
case 1: {
RDebugUtils.currentLine=25362436;
 //BA.debugLineNum = 25362436;BA.debugLine="mmah=\"فروردین\"";
_mmah = "فروردین";
 break; }
case 2: {
RDebugUtils.currentLine=25362438;
 //BA.debugLineNum = 25362438;BA.debugLine="mmah=\"اردیبهشت\"";
_mmah = "اردیبهشت";
 break; }
case 3: {
RDebugUtils.currentLine=25362440;
 //BA.debugLineNum = 25362440;BA.debugLine="mmah=\"خرداد\"";
_mmah = "خرداد";
 break; }
case 4: {
RDebugUtils.currentLine=25362442;
 //BA.debugLineNum = 25362442;BA.debugLine="mmah=\"تیر\"";
_mmah = "تیر";
 break; }
case 5: {
RDebugUtils.currentLine=25362444;
 //BA.debugLineNum = 25362444;BA.debugLine="mmah=\"مرداد\"";
_mmah = "مرداد";
 break; }
case 6: {
RDebugUtils.currentLine=25362446;
 //BA.debugLineNum = 25362446;BA.debugLine="mmah=\"شهریور\"";
_mmah = "شهریور";
 break; }
case 7: {
RDebugUtils.currentLine=25362448;
 //BA.debugLineNum = 25362448;BA.debugLine="mmah=\"مهر\"";
_mmah = "مهر";
 break; }
case 8: {
RDebugUtils.currentLine=25362450;
 //BA.debugLineNum = 25362450;BA.debugLine="mmah=\"آبان\"";
_mmah = "آبان";
 break; }
case 9: {
RDebugUtils.currentLine=25362452;
 //BA.debugLineNum = 25362452;BA.debugLine="mmah=\"آذر\"";
_mmah = "آذر";
 break; }
case 10: {
RDebugUtils.currentLine=25362454;
 //BA.debugLineNum = 25362454;BA.debugLine="mmah=\"دی\"";
_mmah = "دی";
 break; }
case 11: {
RDebugUtils.currentLine=25362456;
 //BA.debugLineNum = 25362456;BA.debugLine="mmah=\"بهمن\"";
_mmah = "بهمن";
 break; }
case 12: {
RDebugUtils.currentLine=25362458;
 //BA.debugLineNum = 25362458;BA.debugLine="mmah=\"اسفند\"";
_mmah = "اسفند";
 break; }
}
;
RDebugUtils.currentLine=25362462;
 //BA.debugLineNum = 25362462;BA.debugLine="lbl_moon_name.Text=mmah";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence(_mmah));
RDebugUtils.currentLine=25362464;
 //BA.debugLineNum = 25362464;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,ItemId)";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_itemid);
RDebugUtils.currentLine=25362465;
 //BA.debugLineNum = 25362465;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=25362466;
 //BA.debugLineNum = 25362466;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_roz_end_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_roz_end_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_roz_end_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=25952256;
 //BA.debugLineNum = 25952256;BA.debugLine="Sub rsPOP_roz_end_MenuItemClick (ItemId As Int) As";
RDebugUtils.currentLine=25952258;
 //BA.debugLineNum = 25952258;BA.debugLine="lbl_roz_end.Text=ItemId";
mostCurrent._lbl_roz_end.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=25952259;
 //BA.debugLineNum = 25952259;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=25952260;
 //BA.debugLineNum = 25952260;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_roz_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_roz_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_roz_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=25559040;
 //BA.debugLineNum = 25559040;BA.debugLine="Sub rsPOP_roz_MenuItemClick (ItemId As Int) As Boo";
RDebugUtils.currentLine=25559042;
 //BA.debugLineNum = 25559042;BA.debugLine="lbl_roz.Text=ItemId";
mostCurrent._lbl_roz.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=25559043;
 //BA.debugLineNum = 25559043;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=25559044;
 //BA.debugLineNum = 25559044;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_year_end_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_year_end_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_year_end_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=25821184;
 //BA.debugLineNum = 25821184;BA.debugLine="Sub rsPOP_year_end_MenuItemClick (ItemId As Int) A";
RDebugUtils.currentLine=25821185;
 //BA.debugLineNum = 25821185;BA.debugLine="lbl_years_end.Text=ItemId";
mostCurrent._lbl_years_end.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=25821186;
 //BA.debugLineNum = 25821186;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=25821187;
 //BA.debugLineNum = 25821187;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_year_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_year_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_year_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=25427968;
 //BA.debugLineNum = 25427968;BA.debugLine="Sub rsPOP_year_MenuItemClick (ItemId As Int) As Bo";
RDebugUtils.currentLine=25427969;
 //BA.debugLineNum = 25427969;BA.debugLine="lbl_years.Text=ItemId";
mostCurrent._lbl_years.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=25427970;
 //BA.debugLineNum = 25427970;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=25427971;
 //BA.debugLineNum = 25427971;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_year_tagvim_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_year_tagvim_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_year_tagvim_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=25165824;
 //BA.debugLineNum = 25165824;BA.debugLine="Sub rsPOP_year_tagvim_MenuItemClick (ItemId As Int";
RDebugUtils.currentLine=25165825;
 //BA.debugLineNum = 25165825;BA.debugLine="lbl_year_tagvim.Text=ItemId";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=25165826;
 //BA.debugLineNum = 25165826;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_current_moon);
RDebugUtils.currentLine=25165827;
 //BA.debugLineNum = 25165827;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=25165828;
 //BA.debugLineNum = 25165828;BA.debugLine="End Sub";
return false;
}
public static String  _sql_nonquerycomplete(boolean _success) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sql_nonquerycomplete", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sql_nonquerycomplete", new Object[] {_success}));}
RDebugUtils.currentLine=27394048;
 //BA.debugLineNum = 27394048;BA.debugLine="Sub sql_NonQueryComplete (Success As Boolean)";
RDebugUtils.currentLine=27394050;
 //BA.debugLineNum = 27394050;BA.debugLine="End Sub";
return "";
}
}