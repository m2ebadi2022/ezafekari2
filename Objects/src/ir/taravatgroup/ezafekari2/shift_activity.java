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
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
int _i = 0;
RDebugUtils.currentLine=25231360;
 //BA.debugLineNum = 25231360;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=25231362;
 //BA.debugLineNum = 25231362;BA.debugLine="Activity.LoadLayout(\"shift_layout\")";
mostCurrent._activity.LoadLayout("shift_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=25231364;
 //BA.debugLineNum = 25231364;BA.debugLine="scrol_v.Panel.LoadLayout(\"shift_page_items\")";
mostCurrent._scrol_v.getPanel().LoadLayout("shift_page_items",mostCurrent.activityBA);
RDebugUtils.currentLine=25231365;
 //BA.debugLineNum = 25231365;BA.debugLine="pan_hed_shift.Color=Main.color4";
mostCurrent._pan_hed_shift.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=25231366;
 //BA.debugLineNum = 25231366;BA.debugLine="lbl_hed_set_shift.Color=Main.color4";
mostCurrent._lbl_hed_set_shift.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=25231369;
 //BA.debugLineNum = 25231369;BA.debugLine="lbl0.Initialize(\"lbl0\")";
mostCurrent._lbl0.Initialize(mostCurrent.activityBA,"lbl0");
RDebugUtils.currentLine=25231370;
 //BA.debugLineNum = 25231370;BA.debugLine="lbl0.Tag=0";
mostCurrent._lbl0.setTag((Object)(0));
RDebugUtils.currentLine=25231371;
 //BA.debugLineNum = 25231371;BA.debugLine="p0.Initialize(\"p0\")";
mostCurrent._p0.Initialize(mostCurrent.activityBA,"p0");
RDebugUtils.currentLine=25231372;
 //BA.debugLineNum = 25231372;BA.debugLine="p0.Tag=0";
mostCurrent._p0.setTag((Object)(0));
RDebugUtils.currentLine=25231373;
 //BA.debugLineNum = 25231373;BA.debugLine="sh0.Initialize(\"sh0\")";
mostCurrent._sh0.Initialize(mostCurrent.activityBA,"sh0");
RDebugUtils.currentLine=25231374;
 //BA.debugLineNum = 25231374;BA.debugLine="sh0.Tag=0";
mostCurrent._sh0.setTag((Object)(0));
RDebugUtils.currentLine=25231375;
 //BA.debugLineNum = 25231375;BA.debugLine="ez0.Initialize(\"ez0\")";
mostCurrent._ez0.Initialize(mostCurrent.activityBA,"ez0");
RDebugUtils.currentLine=25231376;
 //BA.debugLineNum = 25231376;BA.debugLine="ez0.Tag=0";
mostCurrent._ez0.setTag((Object)(0));
RDebugUtils.currentLine=25231377;
 //BA.debugLineNum = 25231377;BA.debugLine="no0.Initialize(\"no0\")";
mostCurrent._no0.Initialize(mostCurrent.activityBA,"no0");
RDebugUtils.currentLine=25231378;
 //BA.debugLineNum = 25231378;BA.debugLine="no0.Tag=0";
mostCurrent._no0.setTag((Object)(0));
RDebugUtils.currentLine=25231380;
 //BA.debugLineNum = 25231380;BA.debugLine="ls_shift_moon.Initialize";
mostCurrent._ls_shift_moon.Initialize();
RDebugUtils.currentLine=25231381;
 //BA.debugLineNum = 25231381;BA.debugLine="ls_tatili_moon.Initialize";
mostCurrent._ls_tatili_moon.Initialize();
RDebugUtils.currentLine=25231382;
 //BA.debugLineNum = 25231382;BA.debugLine="ls_note_moon.Initialize";
mostCurrent._ls_note_moon.Initialize();
RDebugUtils.currentLine=25231385;
 //BA.debugLineNum = 25231385;BA.debugLine="list_sift_olgo.Initialize";
mostCurrent._list_sift_olgo.Initialize();
RDebugUtils.currentLine=25231386;
 //BA.debugLineNum = 25231386;BA.debugLine="ls_set_shift.SingleLineLayout.Label.TextColor=Col";
mostCurrent._ls_set_shift.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=25231388;
 //BA.debugLineNum = 25231388;BA.debugLine="ls_set_shift.SingleLineLayout.Label.Width=ls_set_";
mostCurrent._ls_set_shift.getSingleLineLayout().Label.setWidth((int) (mostCurrent._ls_set_shift.getWidth()-30));
RDebugUtils.currentLine=25231389;
 //BA.debugLineNum = 25231389;BA.debugLine="ls_set_shift.SingleLineLayout.Label.Typeface=Type";
mostCurrent._ls_set_shift.getSingleLineLayout().Label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(mostCurrent._myfunc._font_filename /*String*/ (mostCurrent.activityBA)));
RDebugUtils.currentLine=25231392;
 //BA.debugLineNum = 25231392;BA.debugLine="Lb = Array As Label(lbl0,lb1,lb2,lb3,lb4,lb5,lb6,";
mostCurrent._lb = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._lbl0,mostCurrent._lb1,mostCurrent._lb2,mostCurrent._lb3,mostCurrent._lb4,mostCurrent._lb5,mostCurrent._lb6,mostCurrent._lb7,mostCurrent._lb8,mostCurrent._lb9,mostCurrent._lb10,mostCurrent._lb11,mostCurrent._lb12,mostCurrent._lb13,mostCurrent._lb14,mostCurrent._lb15,mostCurrent._lb16,mostCurrent._lb17,mostCurrent._lb18,mostCurrent._lb19,mostCurrent._lb20,mostCurrent._lb21,mostCurrent._lb22,mostCurrent._lb23,mostCurrent._lb24,mostCurrent._lb25,mostCurrent._lb26,mostCurrent._lb27,mostCurrent._lb28,mostCurrent._lb29,mostCurrent._lb30,mostCurrent._lb31,mostCurrent._lb32,mostCurrent._lb33,mostCurrent._lb34,mostCurrent._lb35,mostCurrent._lb36,mostCurrent._lb37,mostCurrent._lb38,mostCurrent._lb39,mostCurrent._lb40,mostCurrent._lb41,mostCurrent._lb42};
RDebugUtils.currentLine=25231394;
 //BA.debugLineNum = 25231394;BA.debugLine="PA = Array As Panel(p0,p1,p2,p3,p4,p5,p6,p7,p8,p9";
mostCurrent._pa = new anywheresoftware.b4a.objects.PanelWrapper[]{mostCurrent._p0,mostCurrent._p1,mostCurrent._p2,mostCurrent._p3,mostCurrent._p4,mostCurrent._p5,mostCurrent._p6,mostCurrent._p7,mostCurrent._p8,mostCurrent._p9,mostCurrent._p10,mostCurrent._p11,mostCurrent._p12,mostCurrent._p13,mostCurrent._p14,mostCurrent._p15,mostCurrent._p16,mostCurrent._p17,mostCurrent._p18,mostCurrent._p19,mostCurrent._p20,mostCurrent._p21,mostCurrent._p22,mostCurrent._p23,mostCurrent._p24,mostCurrent._p25,mostCurrent._p26,mostCurrent._p27,mostCurrent._p28,mostCurrent._p29,mostCurrent._p30,mostCurrent._p31,mostCurrent._p32,mostCurrent._p33,mostCurrent._p34,mostCurrent._p35,mostCurrent._p36,mostCurrent._p37,mostCurrent._p38,mostCurrent._p39,mostCurrent._p40,mostCurrent._p41,mostCurrent._p42};
RDebugUtils.currentLine=25231396;
 //BA.debugLineNum = 25231396;BA.debugLine="SH = Array As Label(sh0,sh1,sh2,sh3,sh4,sh5,sh6,s";
mostCurrent._sh = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._sh0,mostCurrent._sh1,mostCurrent._sh2,mostCurrent._sh3,mostCurrent._sh4,mostCurrent._sh5,mostCurrent._sh6,mostCurrent._sh7,mostCurrent._sh8,mostCurrent._sh9,mostCurrent._sh10,mostCurrent._sh11,mostCurrent._sh12,mostCurrent._sh13,mostCurrent._sh14,mostCurrent._sh15,mostCurrent._sh16,mostCurrent._sh17,mostCurrent._sh18,mostCurrent._sh19,mostCurrent._sh20,mostCurrent._sh21,mostCurrent._sh22,mostCurrent._sh23,mostCurrent._sh24,mostCurrent._sh25,mostCurrent._sh26,mostCurrent._sh27,mostCurrent._sh28,mostCurrent._sh29,mostCurrent._sh30,mostCurrent._sh31,mostCurrent._sh32,mostCurrent._sh33,mostCurrent._sh34,mostCurrent._sh35,mostCurrent._sh36,mostCurrent._sh37,mostCurrent._sh38,mostCurrent._sh39,mostCurrent._sh40,mostCurrent._sh41,mostCurrent._sh42};
RDebugUtils.currentLine=25231398;
 //BA.debugLineNum = 25231398;BA.debugLine="EZ = Array As Label (ez0,ez1,ez2,ez3,ez4,ez5,ez6,";
mostCurrent._ez = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._ez0,mostCurrent._ez1,mostCurrent._ez2,mostCurrent._ez3,mostCurrent._ez4,mostCurrent._ez5,mostCurrent._ez6,mostCurrent._ez7,mostCurrent._ez8,mostCurrent._ez9,mostCurrent._ez10,mostCurrent._ez11,mostCurrent._ez12,mostCurrent._ez13,mostCurrent._ez14,mostCurrent._ez15,mostCurrent._ez16,mostCurrent._ez17,mostCurrent._ez18,mostCurrent._ez19,mostCurrent._ez20,mostCurrent._ez21,mostCurrent._ez22,mostCurrent._ez23,mostCurrent._ez24,mostCurrent._ez25,mostCurrent._ez26,mostCurrent._ez27,mostCurrent._ez28,mostCurrent._ez29,mostCurrent._ez30,mostCurrent._ez31,mostCurrent._ez32,mostCurrent._ez33,mostCurrent._ez34,mostCurrent._ez35,mostCurrent._ez36,mostCurrent._ez37,mostCurrent._ez38,mostCurrent._ez39,mostCurrent._ez40,mostCurrent._ez41,mostCurrent._ez42};
RDebugUtils.currentLine=25231401;
 //BA.debugLineNum = 25231401;BA.debugLine="NO = Array As Label (no0,no1,no2,no3,no4,no5,no6,";
mostCurrent._no = new anywheresoftware.b4a.objects.LabelWrapper[]{mostCurrent._no0,mostCurrent._no1,mostCurrent._no2,mostCurrent._no3,mostCurrent._no4,mostCurrent._no5,mostCurrent._no6,mostCurrent._no7,mostCurrent._no8,mostCurrent._no9,mostCurrent._no10,mostCurrent._no11,mostCurrent._no12,mostCurrent._no13,mostCurrent._no14,mostCurrent._no15,mostCurrent._no16,mostCurrent._no17,mostCurrent._no18,mostCurrent._no19,mostCurrent._no20,mostCurrent._no21,mostCurrent._no22,mostCurrent._no23,mostCurrent._no24,mostCurrent._no25,mostCurrent._no26,mostCurrent._no27,mostCurrent._no28,mostCurrent._no29,mostCurrent._no30,mostCurrent._no31,mostCurrent._no32,mostCurrent._no33,mostCurrent._no34,mostCurrent._no35,mostCurrent._no36,mostCurrent._no37,mostCurrent._no38,mostCurrent._no39,mostCurrent._no40,mostCurrent._no41,mostCurrent._no42};
RDebugUtils.currentLine=25231408;
 //BA.debugLineNum = 25231408;BA.debugLine="sp_noe_shift.AddAll(Array As String(\"روزکار(ر)\",\"";
mostCurrent._sp_noe_shift.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"روزکار(ر)","عصرکار(ع)","شبکار(ش)","استراحت(ا)"}));
RDebugUtils.currentLine=25231412;
 //BA.debugLineNum = 25231412;BA.debugLine="this_year=date.PersianYear";
_this_year = mostCurrent._date.getPersianYear();
RDebugUtils.currentLine=25231413;
 //BA.debugLineNum = 25231413;BA.debugLine="this_moon =date.PersianMonth";
_this_moon = mostCurrent._date.getPersianMonth();
RDebugUtils.currentLine=25231414;
 //BA.debugLineNum = 25231414;BA.debugLine="this_day =date.PersianDay";
_this_day = mostCurrent._date.getPersianDay();
RDebugUtils.currentLine=25231417;
 //BA.debugLineNum = 25231417;BA.debugLine="current_moon=date.PersianMonth";
_current_moon = mostCurrent._date.getPersianMonth();
RDebugUtils.currentLine=25231419;
 //BA.debugLineNum = 25231419;BA.debugLine="lbl_year_tagvim.Text=this_year";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_this_year));
RDebugUtils.currentLine=25231430;
 //BA.debugLineNum = 25231430;BA.debugLine="rsPOP_year_tagvim.Initialize(\"rsPOP_year_tagvim\",";
mostCurrent._rspop_year_tagvim.Initialize(mostCurrent.activityBA,"rsPOP_year_tagvim",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_year_tagvim.getObject())));
RDebugUtils.currentLine=25231432;
 //BA.debugLineNum = 25231432;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1398,1398,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1398),(int) (1398),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1398"));
RDebugUtils.currentLine=25231433;
 //BA.debugLineNum = 25231433;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1399,1399,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1399),(int) (1399),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1399"));
RDebugUtils.currentLine=25231434;
 //BA.debugLineNum = 25231434;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1400,1400,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1400),(int) (1400),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1400"));
RDebugUtils.currentLine=25231435;
 //BA.debugLineNum = 25231435;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1401,1401,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1401),(int) (1401),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1401"));
RDebugUtils.currentLine=25231436;
 //BA.debugLineNum = 25231436;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1402,1402,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1402),(int) (1402),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1402"));
RDebugUtils.currentLine=25231437;
 //BA.debugLineNum = 25231437;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1403,1403,myfunc.en";
mostCurrent._rspop_year_tagvim.AddMenuItem((int) (1403),(int) (1403),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1403"));
RDebugUtils.currentLine=25231439;
 //BA.debugLineNum = 25231439;BA.debugLine="rsPOP_moon_tagvim.Initialize(\"rsPOP_moon_tagvim\",";
mostCurrent._rspop_moon_tagvim.Initialize(mostCurrent.activityBA,"rsPOP_moon_tagvim",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_moon_name.getObject())));
RDebugUtils.currentLine=25231442;
 //BA.debugLineNum = 25231442;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(1,1,\"فروردین\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (1),(int) (1),"فروردین");
RDebugUtils.currentLine=25231443;
 //BA.debugLineNum = 25231443;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(2,2,\"اردیبهشت\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (2),(int) (2),"اردیبهشت");
RDebugUtils.currentLine=25231444;
 //BA.debugLineNum = 25231444;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(3,3,\"خرداد\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (3),(int) (3),"خرداد");
RDebugUtils.currentLine=25231445;
 //BA.debugLineNum = 25231445;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(4,4,\"تیر\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (4),(int) (4),"تیر");
RDebugUtils.currentLine=25231446;
 //BA.debugLineNum = 25231446;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(5,5,\"مرداد\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (5),(int) (5),"مرداد");
RDebugUtils.currentLine=25231447;
 //BA.debugLineNum = 25231447;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(6,6,\"شهریور\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (6),(int) (6),"شهریور");
RDebugUtils.currentLine=25231448;
 //BA.debugLineNum = 25231448;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(7,7,\"مهر\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (7),(int) (7),"مهر");
RDebugUtils.currentLine=25231449;
 //BA.debugLineNum = 25231449;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(8,8,\"آبان\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (8),(int) (8),"آبان");
RDebugUtils.currentLine=25231450;
 //BA.debugLineNum = 25231450;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(9,9,\"آذر\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (9),(int) (9),"آذر");
RDebugUtils.currentLine=25231451;
 //BA.debugLineNum = 25231451;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(10,10,\"دی\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (10),(int) (10),"دی");
RDebugUtils.currentLine=25231452;
 //BA.debugLineNum = 25231452;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(11,11,\"بهمن\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (11),(int) (11),"بهمن");
RDebugUtils.currentLine=25231453;
 //BA.debugLineNum = 25231453;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(12,12,\"اسفند\")";
mostCurrent._rspop_moon_tagvim.AddMenuItem((int) (12),(int) (12),"اسفند");
RDebugUtils.currentLine=25231461;
 //BA.debugLineNum = 25231461;BA.debugLine="rsPOP_year.Initialize(\"rsPOP_year\",lbl_years)";
mostCurrent._rspop_year.Initialize(mostCurrent.activityBA,"rsPOP_year",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_years.getObject())));
RDebugUtils.currentLine=25231463;
 //BA.debugLineNum = 25231463;BA.debugLine="rsPOP_year.AddMenuItem(1398,1398,myfunc.en2fa(\"13";
mostCurrent._rspop_year.AddMenuItem((int) (1398),(int) (1398),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1398"));
RDebugUtils.currentLine=25231464;
 //BA.debugLineNum = 25231464;BA.debugLine="rsPOP_year.AddMenuItem(1399,1399,myfunc.en2fa(\"13";
mostCurrent._rspop_year.AddMenuItem((int) (1399),(int) (1399),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1399"));
RDebugUtils.currentLine=25231465;
 //BA.debugLineNum = 25231465;BA.debugLine="rsPOP_year.AddMenuItem(1400,1400,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1400),(int) (1400),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1400"));
RDebugUtils.currentLine=25231466;
 //BA.debugLineNum = 25231466;BA.debugLine="rsPOP_year.AddMenuItem(1401,1401,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1401),(int) (1401),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1401"));
RDebugUtils.currentLine=25231467;
 //BA.debugLineNum = 25231467;BA.debugLine="rsPOP_year.AddMenuItem(1402,1402,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1402),(int) (1402),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1402"));
RDebugUtils.currentLine=25231468;
 //BA.debugLineNum = 25231468;BA.debugLine="rsPOP_year.AddMenuItem(1403,1403,myfunc.en2fa(\"14";
mostCurrent._rspop_year.AddMenuItem((int) (1403),(int) (1403),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1403"));
RDebugUtils.currentLine=25231470;
 //BA.debugLineNum = 25231470;BA.debugLine="rsPOP_mah.Initialize(\"rsPOP_mah\",lbl_mah)";
mostCurrent._rspop_mah.Initialize(mostCurrent.activityBA,"rsPOP_mah",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_mah.getObject())));
RDebugUtils.currentLine=25231472;
 //BA.debugLineNum = 25231472;BA.debugLine="lbl_mah_tagID=1";
_lbl_mah_tagid = (int) (1);
RDebugUtils.currentLine=25231474;
 //BA.debugLineNum = 25231474;BA.debugLine="rsPOP_mah.AddMenuItem(1,1,\"فروردین\")";
mostCurrent._rspop_mah.AddMenuItem((int) (1),(int) (1),"فروردین");
RDebugUtils.currentLine=25231475;
 //BA.debugLineNum = 25231475;BA.debugLine="rsPOP_mah.AddMenuItem(2,2,\"اردیبهشت\")";
mostCurrent._rspop_mah.AddMenuItem((int) (2),(int) (2),"اردیبهشت");
RDebugUtils.currentLine=25231476;
 //BA.debugLineNum = 25231476;BA.debugLine="rsPOP_mah.AddMenuItem(3,3,\"خرداد\")";
mostCurrent._rspop_mah.AddMenuItem((int) (3),(int) (3),"خرداد");
RDebugUtils.currentLine=25231477;
 //BA.debugLineNum = 25231477;BA.debugLine="rsPOP_mah.AddMenuItem(4,4,\"تیر\")";
mostCurrent._rspop_mah.AddMenuItem((int) (4),(int) (4),"تیر");
RDebugUtils.currentLine=25231478;
 //BA.debugLineNum = 25231478;BA.debugLine="rsPOP_mah.AddMenuItem(5,5,\"مرداد\")";
mostCurrent._rspop_mah.AddMenuItem((int) (5),(int) (5),"مرداد");
RDebugUtils.currentLine=25231479;
 //BA.debugLineNum = 25231479;BA.debugLine="rsPOP_mah.AddMenuItem(6,6,\"شهریور\")";
mostCurrent._rspop_mah.AddMenuItem((int) (6),(int) (6),"شهریور");
RDebugUtils.currentLine=25231480;
 //BA.debugLineNum = 25231480;BA.debugLine="rsPOP_mah.AddMenuItem(7,7,\"مهر\")";
mostCurrent._rspop_mah.AddMenuItem((int) (7),(int) (7),"مهر");
RDebugUtils.currentLine=25231481;
 //BA.debugLineNum = 25231481;BA.debugLine="rsPOP_mah.AddMenuItem(8,8,\"آبان\")";
mostCurrent._rspop_mah.AddMenuItem((int) (8),(int) (8),"آبان");
RDebugUtils.currentLine=25231482;
 //BA.debugLineNum = 25231482;BA.debugLine="rsPOP_mah.AddMenuItem(9,9,\"آذر\")";
mostCurrent._rspop_mah.AddMenuItem((int) (9),(int) (9),"آذر");
RDebugUtils.currentLine=25231483;
 //BA.debugLineNum = 25231483;BA.debugLine="rsPOP_mah.AddMenuItem(10,10,\"دی\")";
mostCurrent._rspop_mah.AddMenuItem((int) (10),(int) (10),"دی");
RDebugUtils.currentLine=25231484;
 //BA.debugLineNum = 25231484;BA.debugLine="rsPOP_mah.AddMenuItem(11,11,\"بهمن\")";
mostCurrent._rspop_mah.AddMenuItem((int) (11),(int) (11),"بهمن");
RDebugUtils.currentLine=25231485;
 //BA.debugLineNum = 25231485;BA.debugLine="rsPOP_mah.AddMenuItem(12,12,\"اسفند\")";
mostCurrent._rspop_mah.AddMenuItem((int) (12),(int) (12),"اسفند");
RDebugUtils.currentLine=25231488;
 //BA.debugLineNum = 25231488;BA.debugLine="rsPOP_roz.Initialize(\"rsPOP_roz\",lbl_roz)";
mostCurrent._rspop_roz.Initialize(mostCurrent.activityBA,"rsPOP_roz",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_roz.getObject())));
RDebugUtils.currentLine=25231491;
 //BA.debugLineNum = 25231491;BA.debugLine="For i=1 To 31";
{
final int step75 = 1;
final int limit75 = (int) (31);
_i = (int) (1) ;
for (;_i <= limit75 ;_i = _i + step75 ) {
RDebugUtils.currentLine=25231493;
 //BA.debugLineNum = 25231493;BA.debugLine="rsPOP_roz.AddMenuItem(i,i,myfunc.en2fa(i))";
mostCurrent._rspop_roz.AddMenuItem(_i,_i,mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_i)));
 }
};
RDebugUtils.currentLine=25231497;
 //BA.debugLineNum = 25231497;BA.debugLine="rsPOP_year_end.Initialize(\"rsPOP_year_end\",lbl_ye";
mostCurrent._rspop_year_end.Initialize(mostCurrent.activityBA,"rsPOP_year_end",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_years_end.getObject())));
RDebugUtils.currentLine=25231499;
 //BA.debugLineNum = 25231499;BA.debugLine="rsPOP_year_end.AddMenuItem(1398,1398,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1398),(int) (1398),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1398"));
RDebugUtils.currentLine=25231500;
 //BA.debugLineNum = 25231500;BA.debugLine="rsPOP_year_end.AddMenuItem(1399,1399,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1399),(int) (1399),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1399"));
RDebugUtils.currentLine=25231501;
 //BA.debugLineNum = 25231501;BA.debugLine="rsPOP_year_end.AddMenuItem(1400,1400,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1400),(int) (1400),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1400"));
RDebugUtils.currentLine=25231502;
 //BA.debugLineNum = 25231502;BA.debugLine="rsPOP_year_end.AddMenuItem(1401,1401,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1401),(int) (1401),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1401"));
RDebugUtils.currentLine=25231503;
 //BA.debugLineNum = 25231503;BA.debugLine="rsPOP_year_end.AddMenuItem(1402,1402,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1402),(int) (1402),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1402"));
RDebugUtils.currentLine=25231504;
 //BA.debugLineNum = 25231504;BA.debugLine="rsPOP_year_end.AddMenuItem(1403,1403,myfunc.en2fa";
mostCurrent._rspop_year_end.AddMenuItem((int) (1403),(int) (1403),mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,"1403"));
RDebugUtils.currentLine=25231507;
 //BA.debugLineNum = 25231507;BA.debugLine="rsPOP_mah_end.Initialize(\"rsPOP_mah_end\",lbl_mah_";
mostCurrent._rspop_mah_end.Initialize(mostCurrent.activityBA,"rsPOP_mah_end",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_mah_end.getObject())));
RDebugUtils.currentLine=25231509;
 //BA.debugLineNum = 25231509;BA.debugLine="lbl_mah_end_tagID=12";
_lbl_mah_end_tagid = (int) (12);
RDebugUtils.currentLine=25231511;
 //BA.debugLineNum = 25231511;BA.debugLine="rsPOP_mah_end.AddMenuItem(1,1,\"فروردین\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (1),(int) (1),"فروردین");
RDebugUtils.currentLine=25231512;
 //BA.debugLineNum = 25231512;BA.debugLine="rsPOP_mah_end.AddMenuItem(2,2,\"اردیبهشت\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (2),(int) (2),"اردیبهشت");
RDebugUtils.currentLine=25231513;
 //BA.debugLineNum = 25231513;BA.debugLine="rsPOP_mah_end.AddMenuItem(3,3,\"خرداد\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (3),(int) (3),"خرداد");
RDebugUtils.currentLine=25231514;
 //BA.debugLineNum = 25231514;BA.debugLine="rsPOP_mah_end.AddMenuItem(4,4,\"تیر\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (4),(int) (4),"تیر");
RDebugUtils.currentLine=25231515;
 //BA.debugLineNum = 25231515;BA.debugLine="rsPOP_mah_end.AddMenuItem(5,5,\"مرداد\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (5),(int) (5),"مرداد");
RDebugUtils.currentLine=25231516;
 //BA.debugLineNum = 25231516;BA.debugLine="rsPOP_mah_end.AddMenuItem(6,6,\"شهریور\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (6),(int) (6),"شهریور");
RDebugUtils.currentLine=25231517;
 //BA.debugLineNum = 25231517;BA.debugLine="rsPOP_mah_end.AddMenuItem(7,7,\"مهر\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (7),(int) (7),"مهر");
RDebugUtils.currentLine=25231518;
 //BA.debugLineNum = 25231518;BA.debugLine="rsPOP_mah_end.AddMenuItem(8,8,\"آبان\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (8),(int) (8),"آبان");
RDebugUtils.currentLine=25231519;
 //BA.debugLineNum = 25231519;BA.debugLine="rsPOP_mah_end.AddMenuItem(9,9,\"آذر\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (9),(int) (9),"آذر");
RDebugUtils.currentLine=25231520;
 //BA.debugLineNum = 25231520;BA.debugLine="rsPOP_mah_end.AddMenuItem(10,10,\"دی\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (10),(int) (10),"دی");
RDebugUtils.currentLine=25231521;
 //BA.debugLineNum = 25231521;BA.debugLine="rsPOP_mah_end.AddMenuItem(11,11,\"بهمن\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (11),(int) (11),"بهمن");
RDebugUtils.currentLine=25231522;
 //BA.debugLineNum = 25231522;BA.debugLine="rsPOP_mah_end.AddMenuItem(12,12,\"اسفند\")";
mostCurrent._rspop_mah_end.AddMenuItem((int) (12),(int) (12),"اسفند");
RDebugUtils.currentLine=25231524;
 //BA.debugLineNum = 25231524;BA.debugLine="rsPOP_roz_end.Initialize(\"rsPOP_roz_end\",lbl_roz_";
mostCurrent._rspop_roz_end.Initialize(mostCurrent.activityBA,"rsPOP_roz_end",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_roz_end.getObject())));
RDebugUtils.currentLine=25231525;
 //BA.debugLineNum = 25231525;BA.debugLine="For i=1 To 31";
{
final int step100 = 1;
final int limit100 = (int) (31);
_i = (int) (1) ;
for (;_i <= limit100 ;_i = _i + step100 ) {
RDebugUtils.currentLine=25231526;
 //BA.debugLineNum = 25231526;BA.debugLine="rsPOP_roz_end.AddMenuItem(i,i,myfunc.en2fa(i))";
mostCurrent._rspop_roz_end.AddMenuItem(_i,_i,mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_i)));
 }
};
RDebugUtils.currentLine=25231532;
 //BA.debugLineNum = 25231532;BA.debugLine="lbl_go_today_Click";
_lbl_go_today_click();
RDebugUtils.currentLine=25231534;
 //BA.debugLineNum = 25231534;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=25231537;
 //BA.debugLineNum = 25231537;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_go_today_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_go_today_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_go_today_click", null));}
RDebugUtils.currentLine=25296896;
 //BA.debugLineNum = 25296896;BA.debugLine="Private Sub lbl_go_today_Click";
RDebugUtils.currentLine=25296898;
 //BA.debugLineNum = 25296898;BA.debugLine="selectedDay_id=dbCode.get_day_id(this_year,this_m";
_selectedday_id = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_this_year,_this_moon,_this_day);
RDebugUtils.currentLine=25296902;
 //BA.debugLineNum = 25296902;BA.debugLine="generat_taghvim(this_year,this_moon)";
_generat_taghvim(_this_year,_this_moon);
RDebugUtils.currentLine=25296904;
 //BA.debugLineNum = 25296904;BA.debugLine="get_monasebat( selectedDay_id )";
_get_monasebat(_selectedday_id);
RDebugUtils.currentLine=25296905;
 //BA.debugLineNum = 25296905;BA.debugLine="get_note(selectedDay_id)";
_get_note(_selectedday_id);
RDebugUtils.currentLine=25296907;
 //BA.debugLineNum = 25296907;BA.debugLine="get_ezafekari(this_year&\"/\"&myfunc.convert_adad(t";
_get_ezafekari(BA.NumberToString(_this_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_day));
RDebugUtils.currentLine=25296908;
 //BA.debugLineNum = 25296908;BA.debugLine="get_morakhasi(this_year&\"/\"&myfunc.convert_adad(t";
_get_morakhasi(BA.NumberToString(_this_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_day));
RDebugUtils.currentLine=25296909;
 //BA.debugLineNum = 25296909;BA.debugLine="get_taradod(this_year&\"/\"&myfunc.convert_adad(thi";
_get_taradod(BA.NumberToString(_this_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_this_day));
RDebugUtils.currentLine=25296915;
 //BA.debugLineNum = 25296915;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=26607616;
 //BA.debugLineNum = 26607616;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=26607617;
 //BA.debugLineNum = 26607617;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=26607618;
 //BA.debugLineNum = 26607618;BA.debugLine="If(pan_all_setSift.Visible=True)Then";
if ((mostCurrent._pan_all_setsift.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=26607619;
 //BA.debugLineNum = 26607619;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=26607620;
 //BA.debugLineNum = 26607620;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
 }else 
{RDebugUtils.currentLine=26607622;
 //BA.debugLineNum = 26607622;BA.debugLine="Else If (pan_all_note.Visible=True)Then";
if ((mostCurrent._pan_all_note.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=26607623;
 //BA.debugLineNum = 26607623;BA.debugLine="pan_all_note.Visible=False";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=26607625;
 //BA.debugLineNum = 26607625;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 }}
;
RDebugUtils.currentLine=26607628;
 //BA.debugLineNum = 26607628;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=26607630;
 //BA.debugLineNum = 26607630;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=26607632;
 //BA.debugLineNum = 26607632;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_delete_lis_olgo_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_delete_lis_olgo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_delete_lis_olgo_click", null));}
RDebugUtils.currentLine=27721728;
 //BA.debugLineNum = 27721728;BA.debugLine="Private Sub lbl_delete_lis_olgo_Click";
RDebugUtils.currentLine=27721729;
 //BA.debugLineNum = 27721729;BA.debugLine="ls_set_shift.Clear";
mostCurrent._ls_set_shift.Clear();
RDebugUtils.currentLine=27721730;
 //BA.debugLineNum = 27721730;BA.debugLine="list_sift_olgo.Clear";
mostCurrent._list_sift_olgo.Clear();
RDebugUtils.currentLine=27721731;
 //BA.debugLineNum = 27721731;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=26542080;
 //BA.debugLineNum = 26542080;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=26542082;
 //BA.debugLineNum = 26542082;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=26542083;
 //BA.debugLineNum = 26542083;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="shift_activity";
RDebugUtils.currentLine=26476544;
 //BA.debugLineNum = 26476544;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=26476546;
 //BA.debugLineNum = 26476546;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=26411008;
 //BA.debugLineNum = 26411008;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=26411010;
 //BA.debugLineNum = 26411010;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=27000832;
 //BA.debugLineNum = 27000832;BA.debugLine="Sub generat_taghvim(year As Int , moon As Int)";
RDebugUtils.currentLine=27000833;
 //BA.debugLineNum = 27000833;BA.debugLine="Try";
try {RDebugUtils.currentLine=27000836;
 //BA.debugLineNum = 27000836;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=27000840;
 //BA.debugLineNum = 27000840;BA.debugLine="For d=0 To PA.Length-1";
{
final int step3 = 1;
final int limit3 = (int) (mostCurrent._pa.length-1);
_d = (int) (0) ;
for (;_d <= limit3 ;_d = _d + step3 ) {
RDebugUtils.currentLine=27000841;
 //BA.debugLineNum = 27000841;BA.debugLine="PA(d).Visible=True";
mostCurrent._pa[_d].setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=27000842;
 //BA.debugLineNum = 27000842;BA.debugLine="PA(d).Color=0xFFEFEFEF";
mostCurrent._pa[_d].setColor(((int)0xffefefef));
RDebugUtils.currentLine=27000845;
 //BA.debugLineNum = 27000845;BA.debugLine="EZ(d).Text=\"\"";
mostCurrent._ez[_d].setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=27000846;
 //BA.debugLineNum = 27000846;BA.debugLine="NO(d).Text=\"\"";
mostCurrent._no[_d].setText(BA.ObjectToCharSequence(""));
 }
};
RDebugUtils.currentLine=27000850;
 //BA.debugLineNum = 27000850;BA.debugLine="ls_shift_moon.Clear";
mostCurrent._ls_shift_moon.Clear();
RDebugUtils.currentLine=27000851;
 //BA.debugLineNum = 27000851;BA.debugLine="ls_tatili_moon.Clear";
mostCurrent._ls_tatili_moon.Clear();
RDebugUtils.currentLine=27000852;
 //BA.debugLineNum = 27000852;BA.debugLine="ls_note_moon.Clear";
mostCurrent._ls_note_moon.Clear();
RDebugUtils.currentLine=27000854;
 //BA.debugLineNum = 27000854;BA.debugLine="Dim count_day_moon As Int";
_count_day_moon = 0;
RDebugUtils.currentLine=27000856;
 //BA.debugLineNum = 27000856;BA.debugLine="current_moon=moon";
_current_moon = _moon;
RDebugUtils.currentLine=27000857;
 //BA.debugLineNum = 27000857;BA.debugLine="lbl_moon_name.Tag=moon";
mostCurrent._lbl_moon_name.setTag((Object)(_moon));
RDebugUtils.currentLine=27000858;
 //BA.debugLineNum = 27000858;BA.debugLine="lbl_year_tagvim.Text=year";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_year));
RDebugUtils.currentLine=27000860;
 //BA.debugLineNum = 27000860;BA.debugLine="Select moon";
switch (_moon) {
case 1: {
RDebugUtils.currentLine=27000862;
 //BA.debugLineNum = 27000862;BA.debugLine="lbl_moon_name.Text=\"فروردین\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("فروردین"));
 break; }
case 2: {
RDebugUtils.currentLine=27000864;
 //BA.debugLineNum = 27000864;BA.debugLine="lbl_moon_name.Text=\"اردیبهشت\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("اردیبهشت"));
 break; }
case 3: {
RDebugUtils.currentLine=27000866;
 //BA.debugLineNum = 27000866;BA.debugLine="lbl_moon_name.Text=\"خرداد\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("خرداد"));
 break; }
case 4: {
RDebugUtils.currentLine=27000868;
 //BA.debugLineNum = 27000868;BA.debugLine="lbl_moon_name.Text=\"تیر\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("تیر"));
 break; }
case 5: {
RDebugUtils.currentLine=27000870;
 //BA.debugLineNum = 27000870;BA.debugLine="lbl_moon_name.Text=\"مرداد\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("مرداد"));
 break; }
case 6: {
RDebugUtils.currentLine=27000872;
 //BA.debugLineNum = 27000872;BA.debugLine="lbl_moon_name.Text=\"شهریور\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("شهریور"));
 break; }
case 7: {
RDebugUtils.currentLine=27000874;
 //BA.debugLineNum = 27000874;BA.debugLine="lbl_moon_name.Text=\"مهر\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("مهر"));
 break; }
case 8: {
RDebugUtils.currentLine=27000876;
 //BA.debugLineNum = 27000876;BA.debugLine="lbl_moon_name.Text=\"آبان\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("آبان"));
 break; }
case 9: {
RDebugUtils.currentLine=27000878;
 //BA.debugLineNum = 27000878;BA.debugLine="lbl_moon_name.Text=\"آذر\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("آذر"));
 break; }
case 10: {
RDebugUtils.currentLine=27000880;
 //BA.debugLineNum = 27000880;BA.debugLine="lbl_moon_name.Text=\"دی\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("دی"));
 break; }
case 11: {
RDebugUtils.currentLine=27000882;
 //BA.debugLineNum = 27000882;BA.debugLine="lbl_moon_name.Text=\"بهمن\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("بهمن"));
 break; }
case 12: {
RDebugUtils.currentLine=27000884;
 //BA.debugLineNum = 27000884;BA.debugLine="lbl_moon_name.Text=\"اسفند\"";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence("اسفند"));
 break; }
}
;
RDebugUtils.currentLine=27000890;
 //BA.debugLineNum = 27000890;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE year="+BA.NumberToString(_year)+" AND moon="+BA.NumberToString(_moon)+" ;")));
RDebugUtils.currentLine=27000894;
 //BA.debugLineNum = 27000894;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=27000896;
 //BA.debugLineNum = 27000896;BA.debugLine="count_day_moon=dbCode.res.RowCount";
_count_day_moon = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount();
RDebugUtils.currentLine=27000897;
 //BA.debugLineNum = 27000897;BA.debugLine="dbCode.res.Position =0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=27000898;
 //BA.debugLineNum = 27000898;BA.debugLine="start_day=dbCode.res.Getint(\"day_h\")";
_start_day = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_h");
RDebugUtils.currentLine=27000901;
 //BA.debugLineNum = 27000901;BA.debugLine="For i=0 To dbCode.res.RowCount-1";
{
final int step47 = 1;
final int limit47 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit47 ;_i = _i + step47 ) {
RDebugUtils.currentLine=27000902;
 //BA.debugLineNum = 27000902;BA.debugLine="dbCode.res.Position =i";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_i);
RDebugUtils.currentLine=27000904;
 //BA.debugLineNum = 27000904;BA.debugLine="If (dbCode.res.GetString(\"shift\") = Null)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")== null)) { 
RDebugUtils.currentLine=27000905;
 //BA.debugLineNum = 27000905;BA.debugLine="ls_shift_moon.Add(\"\")";
mostCurrent._ls_shift_moon.Add((Object)(""));
 }else {
RDebugUtils.currentLine=27000907;
 //BA.debugLineNum = 27000907;BA.debugLine="ls_shift_moon.Add(dbCode.res.GetString(\"shift";
mostCurrent._ls_shift_moon.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")));
 };
RDebugUtils.currentLine=27000911;
 //BA.debugLineNum = 27000911;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Th";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=27000912;
 //BA.debugLineNum = 27000912;BA.debugLine="ls_tatili_moon.Add(True)";
mostCurrent._ls_tatili_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.True));
 }else {
RDebugUtils.currentLine=27000914;
 //BA.debugLineNum = 27000914;BA.debugLine="ls_tatili_moon.Add(False)";
mostCurrent._ls_tatili_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.False));
 };
RDebugUtils.currentLine=27000918;
 //BA.debugLineNum = 27000918;BA.debugLine="If (dbCode.res.GetString(\"note\") = \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")).equals(""))) { 
RDebugUtils.currentLine=27000919;
 //BA.debugLineNum = 27000919;BA.debugLine="ls_note_moon.Add(False)";
mostCurrent._ls_note_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.False));
 }else {
RDebugUtils.currentLine=27000921;
 //BA.debugLineNum = 27000921;BA.debugLine="ls_note_moon.Add(True)";
mostCurrent._ls_note_moon.Add((Object)(anywheresoftware.b4a.keywords.Common.True));
 };
 }
};
 }else {
RDebugUtils.currentLine=27000930;
 //BA.debugLineNum = 27000930;BA.debugLine="Log(\"nooop data\")";
anywheresoftware.b4a.keywords.Common.LogImpl("327000930","nooop data",0);
 };
RDebugUtils.currentLine=27000935;
 //BA.debugLineNum = 27000935;BA.debugLine="For  j=start_day-1 To 0 Step -1";
{
final int step68 = -1;
final int limit68 = (int) (0);
_j = (int) (_start_day-1) ;
for (;_j >= limit68 ;_j = _j + step68 ) {
RDebugUtils.currentLine=27000936;
 //BA.debugLineNum = 27000936;BA.debugLine="PA(j).Visible=False";
mostCurrent._pa[_j].setVisible(anywheresoftware.b4a.keywords.Common.False);
 }
};
RDebugUtils.currentLine=27000941;
 //BA.debugLineNum = 27000941;BA.debugLine="Dim counter As Int=1";
_counter = (int) (1);
RDebugUtils.currentLine=27000943;
 //BA.debugLineNum = 27000943;BA.debugLine="For i = start_day To count_day_moon+start_day";
{
final int step72 = 1;
final int limit72 = (int) (_count_day_moon+_start_day);
_i = _start_day ;
for (;_i <= limit72 ;_i = _i + step72 ) {
RDebugUtils.currentLine=27000949;
 //BA.debugLineNum = 27000949;BA.debugLine="Lb(i).Text=counter";
mostCurrent._lb[_i].setText(BA.ObjectToCharSequence(_counter));
RDebugUtils.currentLine=27000950;
 //BA.debugLineNum = 27000950;BA.debugLine="PA(i).Tag=counter";
mostCurrent._pa[_i].setTag((Object)(_counter));
RDebugUtils.currentLine=27000955;
 //BA.debugLineNum = 27000955;BA.debugLine="If(counter-1 < count_day_moon)Then";
if ((_counter-1<_count_day_moon)) { 
RDebugUtils.currentLine=27000956;
 //BA.debugLineNum = 27000956;BA.debugLine="SH(i).Text=ls_shift_moon.Get(counter-1)  ''---s";
mostCurrent._sh[_i].setText(BA.ObjectToCharSequence(mostCurrent._ls_shift_moon.Get((int) (_counter-1))));
RDebugUtils.currentLine=27000961;
 //BA.debugLineNum = 27000961;BA.debugLine="If(ls_tatili_moon.Get(counter-1)=True)Then";
if (((mostCurrent._ls_tatili_moon.Get((int) (_counter-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=27000962;
 //BA.debugLineNum = 27000962;BA.debugLine="PA(i).Color=0xFFFF5252";
mostCurrent._pa[_i].setColor(((int)0xffff5252));
 };
RDebugUtils.currentLine=27000968;
 //BA.debugLineNum = 27000968;BA.debugLine="If(ls_note_moon.Get(counter-1)=True)Then";
if (((mostCurrent._ls_note_moon.Get((int) (_counter-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=27000969;
 //BA.debugLineNum = 27000969;BA.debugLine="NO(i).Text=\"•\"";
mostCurrent._no[_i].setText(BA.ObjectToCharSequence("•"));
RDebugUtils.currentLine=27000970;
 //BA.debugLineNum = 27000970;BA.debugLine="NO(i).textColor=Colors.Blue";
mostCurrent._no[_i].setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 };
RDebugUtils.currentLine=27000975;
 //BA.debugLineNum = 27000975;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(year&\"/\"&my";
if ((mostCurrent._dbcode._isexist_ezafekari_by_date /*boolean*/ (mostCurrent.activityBA,BA.NumberToString(_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_counter))==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=27000976;
 //BA.debugLineNum = 27000976;BA.debugLine="EZ(i).Text=\"*\"";
mostCurrent._ez[_i].setText(BA.ObjectToCharSequence("*"));
RDebugUtils.currentLine=27000977;
 //BA.debugLineNum = 27000977;BA.debugLine="EZ(i).TextColor=0xFF00941C";
mostCurrent._ez[_i].setTextColor(((int)0xff00941c));
 }else 
{RDebugUtils.currentLine=27000978;
 //BA.debugLineNum = 27000978;BA.debugLine="Else if (dbCode.isexist_morakhasi_by_date(year&";
if ((mostCurrent._dbcode._isexist_morakhasi_by_date /*boolean*/ (mostCurrent.activityBA,BA.NumberToString(_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_counter))==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=27000979;
 //BA.debugLineNum = 27000979;BA.debugLine="EZ(i).Text=\"*\"";
mostCurrent._ez[_i].setText(BA.ObjectToCharSequence("*"));
RDebugUtils.currentLine=27000980;
 //BA.debugLineNum = 27000980;BA.debugLine="EZ(i).TextColor=0xFFFF5200";
mostCurrent._ez[_i].setTextColor(((int)0xffff5200));
 }else 
{RDebugUtils.currentLine=27000981;
 //BA.debugLineNum = 27000981;BA.debugLine="Else if (dbCode.isexist_taradod_by_date(year&\"/";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,BA.NumberToString(_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_moon)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_counter))==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=27000982;
 //BA.debugLineNum = 27000982;BA.debugLine="EZ(i).Text=\"*\"";
mostCurrent._ez[_i].setText(BA.ObjectToCharSequence("*"));
RDebugUtils.currentLine=27000983;
 //BA.debugLineNum = 27000983;BA.debugLine="EZ(i).TextColor=0xFFFF5200";
mostCurrent._ez[_i].setTextColor(((int)0xffff5200));
 }}}
;
 };
RDebugUtils.currentLine=27000992;
 //BA.debugLineNum = 27000992;BA.debugLine="If(counter=this_day And moon=date.PersianMonth A";
if ((_counter==_this_day && _moon==mostCurrent._date.getPersianMonth() && _year==_this_year)) { 
RDebugUtils.currentLine=27000994;
 //BA.debugLineNum = 27000994;BA.debugLine="PA(i).Color=0xFFFFBD30";
mostCurrent._pa[_i].setColor(((int)0xffffbd30));
RDebugUtils.currentLine=27000995;
 //BA.debugLineNum = 27000995;BA.debugLine="index_i_today=i";
_index_i_today = _i;
 };
RDebugUtils.currentLine=27000998;
 //BA.debugLineNum = 27000998;BA.debugLine="If(counter>=count_day_moon)Then";
if ((_counter>=_count_day_moon)) { 
RDebugUtils.currentLine=27001000;
 //BA.debugLineNum = 27001000;BA.debugLine="For f=i+1 To Lb.Length-1";
{
final int step100 = 1;
final int limit100 = (int) (mostCurrent._lb.length-1);
_f = (int) (_i+1) ;
for (;_f <= limit100 ;_f = _f + step100 ) {
RDebugUtils.currentLine=27001001;
 //BA.debugLineNum = 27001001;BA.debugLine="PA(f).Visible=False";
mostCurrent._pa[_f].setVisible(anywheresoftware.b4a.keywords.Common.False);
 }
};
 };
RDebugUtils.currentLine=27001007;
 //BA.debugLineNum = 27001007;BA.debugLine="counter=counter+1";
_counter = (int) (_counter+1);
 }
};
 } 
       catch (Exception e107) {
			processBA.setLastException(e107);RDebugUtils.currentLine=27001011;
 //BA.debugLineNum = 27001011;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("327001011",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=27001015;
 //BA.debugLineNum = 27001015;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=26869760;
 //BA.debugLineNum = 26869760;BA.debugLine="Sub get_ezafekari(date1 As String)";
RDebugUtils.currentLine=26869761;
 //BA.debugLineNum = 26869761;BA.debugLine="lbl_ezafekari_day.Text=\"\"";
mostCurrent._lbl_ezafekari_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=26869762;
 //BA.debugLineNum = 26869762;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=26869763;
 //BA.debugLineNum = 26869763;BA.debugLine="Dim ezList As List";
_ezlist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=26869764;
 //BA.debugLineNum = 26869764;BA.debugLine="ezList.Initialize";
_ezlist.Initialize();
RDebugUtils.currentLine=26869765;
 //BA.debugLineNum = 26869765;BA.debugLine="Dim newLine As String=\"\"";
_newline = "";
RDebugUtils.currentLine=26869767;
 //BA.debugLineNum = 26869767;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"+_date1+"';")));
RDebugUtils.currentLine=26869769;
 //BA.debugLineNum = 26869769;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=26869770;
 //BA.debugLineNum = 26869770;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_k = (int) (0) ;
for (;_k <= limit8 ;_k = _k + step8 ) {
RDebugUtils.currentLine=26869771;
 //BA.debugLineNum = 26869771;BA.debugLine="dbCode.res.Position=K";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_k);
RDebugUtils.currentLine=26869773;
 //BA.debugLineNum = 26869773;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
_ezlist.Add((Object)(_newline+"از "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" تا "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+"  ( "+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_h"))+":"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_m"))+")"));
RDebugUtils.currentLine=26869774;
 //BA.debugLineNum = 26869774;BA.debugLine="newLine=CRLF";
_newline = anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 }else {
RDebugUtils.currentLine=26869780;
 //BA.debugLineNum = 26869780;BA.debugLine="ezList.Add(\"-\")";
_ezlist.Add((Object)("-"));
 };
RDebugUtils.currentLine=26869783;
 //BA.debugLineNum = 26869783;BA.debugLine="For i=0 To ezList.Size-1";
{
final int step16 = 1;
final int limit16 = (int) (_ezlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
RDebugUtils.currentLine=26869784;
 //BA.debugLineNum = 26869784;BA.debugLine="lbl_ezafekari_day.Text=lbl_ezafekari_day.Text &";
mostCurrent._lbl_ezafekari_day.setText(BA.ObjectToCharSequence(mostCurrent._lbl_ezafekari_day.getText()+BA.ObjectToString(_ezlist.Get(_i))));
 }
};
RDebugUtils.currentLine=26869787;
 //BA.debugLineNum = 26869787;BA.debugLine="End Sub";
return "";
}
public static String  _get_monasebat(int _id) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_monasebat", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_monasebat", new Object[] {_id}));}
String _str_sh = "";
RDebugUtils.currentLine=26673152;
 //BA.debugLineNum = 26673152;BA.debugLine="Sub get_monasebat ( id As Int)";
RDebugUtils.currentLine=26673153;
 //BA.debugLineNum = 26673153;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=26673154;
 //BA.debugLineNum = 26673154;BA.debugLine="lbl_today_monasebat.Text=\"\"";
mostCurrent._lbl_today_monasebat.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=26673155;
 //BA.debugLineNum = 26673155;BA.debugLine="lbl_today.Text=\"\"";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=26673157;
 //BA.debugLineNum = 26673157;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=26673160;
 //BA.debugLineNum = 26673160;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=26673164;
 //BA.debugLineNum = 26673164;BA.debugLine="If(dbCode.res.GetString(\"monasebat\")<> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("monasebat")).equals("") == false)) { 
RDebugUtils.currentLine=26673165;
 //BA.debugLineNum = 26673165;BA.debugLine="lbl_today_monasebat.Text=dbCode.res.GetString(\"m";
mostCurrent._lbl_today_monasebat.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("monasebat")));
 };
RDebugUtils.currentLine=26673169;
 //BA.debugLineNum = 26673169;BA.debugLine="lbl_today.Text=lbl_year_tagvim.Text&\"/\"&dbCode.re";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("moon")+"/"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_c"))));
RDebugUtils.currentLine=26673172;
 //BA.debugLineNum = 26673172;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=26673173;
 //BA.debugLineNum = 26673173;BA.debugLine="lbl_today.Text=lbl_today.Text&\" (تعطیل) \"";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_today.getText()+" (تعطیل) "));
 };
RDebugUtils.currentLine=26673176;
 //BA.debugLineNum = 26673176;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")).equals("") == false)) { 
RDebugUtils.currentLine=26673177;
 //BA.debugLineNum = 26673177;BA.debugLine="Dim str_sh As String";
_str_sh = "";
RDebugUtils.currentLine=26673178;
 //BA.debugLineNum = 26673178;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift"),"ر","ش","ع","ا")) {
case 0: {
RDebugUtils.currentLine=26673180;
 //BA.debugLineNum = 26673180;BA.debugLine="str_sh=\"روزکار\"";
_str_sh = "روزکار";
 break; }
case 1: {
RDebugUtils.currentLine=26673182;
 //BA.debugLineNum = 26673182;BA.debugLine="str_sh=\"شبکار\"";
_str_sh = "شبکار";
 break; }
case 2: {
RDebugUtils.currentLine=26673184;
 //BA.debugLineNum = 26673184;BA.debugLine="str_sh=\"عصرکار\"";
_str_sh = "عصرکار";
 break; }
case 3: {
RDebugUtils.currentLine=26673186;
 //BA.debugLineNum = 26673186;BA.debugLine="str_sh=\"استراحت\"";
_str_sh = "استراحت";
 break; }
}
;
RDebugUtils.currentLine=26673189;
 //BA.debugLineNum = 26673189;BA.debugLine="lbl_today.Text=lbl_today.Text&\"- (( شیفت : \"&str";
mostCurrent._lbl_today.setText(BA.ObjectToCharSequence(mostCurrent._lbl_today.getText()+"- (( شیفت : "+_str_sh+" )) "));
 };
RDebugUtils.currentLine=26673193;
 //BA.debugLineNum = 26673193;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=26935296;
 //BA.debugLineNum = 26935296;BA.debugLine="Sub get_morakhasi(date1 As String)";
RDebugUtils.currentLine=26935297;
 //BA.debugLineNum = 26935297;BA.debugLine="lbl_morakhasi_day.Text=\"\"";
mostCurrent._lbl_morakhasi_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=26935298;
 //BA.debugLineNum = 26935298;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=26935299;
 //BA.debugLineNum = 26935299;BA.debugLine="Dim ezList As List";
_ezlist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=26935300;
 //BA.debugLineNum = 26935300;BA.debugLine="ezList.Initialize";
_ezlist.Initialize();
RDebugUtils.currentLine=26935301;
 //BA.debugLineNum = 26935301;BA.debugLine="Dim newLine As String=\"\"";
_newline = "";
RDebugUtils.currentLine=26935303;
 //BA.debugLineNum = 26935303;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"+_date1+"';")));
RDebugUtils.currentLine=26935305;
 //BA.debugLineNum = 26935305;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=26935306;
 //BA.debugLineNum = 26935306;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_k = (int) (0) ;
for (;_k <= limit8 ;_k = _k + step8 ) {
RDebugUtils.currentLine=26935307;
 //BA.debugLineNum = 26935307;BA.debugLine="dbCode.res.Position=K";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_k);
RDebugUtils.currentLine=26935309;
 //BA.debugLineNum = 26935309;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
_ezlist.Add((Object)(_newline+"از "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" تا "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+"  ( "+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_d"))+":"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_h"))+":"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("end_tim_m"))+")"));
RDebugUtils.currentLine=26935310;
 //BA.debugLineNum = 26935310;BA.debugLine="newLine=CRLF";
_newline = anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 }else {
RDebugUtils.currentLine=26935316;
 //BA.debugLineNum = 26935316;BA.debugLine="ezList.Add(\"-\")";
_ezlist.Add((Object)("-"));
 };
RDebugUtils.currentLine=26935319;
 //BA.debugLineNum = 26935319;BA.debugLine="For i=0 To ezList.Size-1";
{
final int step16 = 1;
final int limit16 = (int) (_ezlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
RDebugUtils.currentLine=26935320;
 //BA.debugLineNum = 26935320;BA.debugLine="lbl_morakhasi_day.Text=lbl_morakhasi_day.Text &";
mostCurrent._lbl_morakhasi_day.setText(BA.ObjectToCharSequence(mostCurrent._lbl_morakhasi_day.getText()+BA.ObjectToString(_ezlist.Get(_i))));
 }
};
RDebugUtils.currentLine=26935323;
 //BA.debugLineNum = 26935323;BA.debugLine="End Sub";
return "";
}
public static String  _get_note(int _id) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_note", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_note", new Object[] {_id}));}
RDebugUtils.currentLine=26738688;
 //BA.debugLineNum = 26738688;BA.debugLine="Sub get_note ( id As Int)";
RDebugUtils.currentLine=26738689;
 //BA.debugLineNum = 26738689;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=26738690;
 //BA.debugLineNum = 26738690;BA.debugLine="lbl_note_day.Text=\"\"";
mostCurrent._lbl_note_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=26738693;
 //BA.debugLineNum = 26738693;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=26738694;
 //BA.debugLineNum = 26738694;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=26738696;
 //BA.debugLineNum = 26738696;BA.debugLine="If(dbCode.res.GetString(\"note\")<> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")).equals("") == false)) { 
RDebugUtils.currentLine=26738697;
 //BA.debugLineNum = 26738697;BA.debugLine="lbl_note_day.Text=dbCode.res.GetString(\"note\")";
mostCurrent._lbl_note_day.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")));
 };
RDebugUtils.currentLine=26738700;
 //BA.debugLineNum = 26738700;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=26804224;
 //BA.debugLineNum = 26804224;BA.debugLine="Sub get_taradod(date1 As String)";
RDebugUtils.currentLine=26804225;
 //BA.debugLineNum = 26804225;BA.debugLine="lbl_taradod_day.Text=\"\"";
mostCurrent._lbl_taradod_day.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=26804226;
 //BA.debugLineNum = 26804226;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=26804227;
 //BA.debugLineNum = 26804227;BA.debugLine="Dim ezList As List";
_ezlist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=26804228;
 //BA.debugLineNum = 26804228;BA.debugLine="ezList.Initialize";
_ezlist.Initialize();
RDebugUtils.currentLine=26804229;
 //BA.debugLineNum = 26804229;BA.debugLine="Dim newLine As String=\"\"";
_newline = "";
RDebugUtils.currentLine=26804231;
 //BA.debugLineNum = 26804231;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+_date1+"';")));
RDebugUtils.currentLine=26804233;
 //BA.debugLineNum = 26804233;BA.debugLine="If (dbCode.res.RowCount>0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()>0)) { 
RDebugUtils.currentLine=26804234;
 //BA.debugLineNum = 26804234;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()-1);
_k = (int) (0) ;
for (;_k <= limit8 ;_k = _k + step8 ) {
RDebugUtils.currentLine=26804235;
 //BA.debugLineNum = 26804235;BA.debugLine="dbCode.res.Position=K";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition(_k);
RDebugUtils.currentLine=26804237;
 //BA.debugLineNum = 26804237;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
_ezlist.Add((Object)(_newline+"از "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" تا "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
RDebugUtils.currentLine=26804238;
 //BA.debugLineNum = 26804238;BA.debugLine="newLine=CRLF";
_newline = anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 }else {
RDebugUtils.currentLine=26804242;
 //BA.debugLineNum = 26804242;BA.debugLine="ezList.Add(\"-\")";
_ezlist.Add((Object)("-"));
 };
RDebugUtils.currentLine=26804245;
 //BA.debugLineNum = 26804245;BA.debugLine="For i=0 To ezList.Size-1";
{
final int step16 = 1;
final int limit16 = (int) (_ezlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
RDebugUtils.currentLine=26804246;
 //BA.debugLineNum = 26804246;BA.debugLine="lbl_taradod_day.Text=lbl_taradod_day.Text & ezLi";
mostCurrent._lbl_taradod_day.setText(BA.ObjectToCharSequence(mostCurrent._lbl_taradod_day.getText()+BA.ObjectToString(_ezlist.Get(_i))));
 }
};
RDebugUtils.currentLine=26804249;
 //BA.debugLineNum = 26804249;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_2_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_2_click", null));}
RDebugUtils.currentLine=27656192;
 //BA.debugLineNum = 27656192;BA.debugLine="Private Sub lbl_back_2_Click";
RDebugUtils.currentLine=27656193;
 //BA.debugLineNum = 27656193;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=27656194;
 //BA.debugLineNum = 27656194;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
RDebugUtils.currentLine=27656195;
 //BA.debugLineNum = 27656195;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_del_shiftha_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_del_shiftha_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_del_shiftha_click", null));}
RDebugUtils.currentLine=27787264;
 //BA.debugLineNum = 27787264;BA.debugLine="Private Sub lbl_del_shiftha_Click";
RDebugUtils.currentLine=27787265;
 //BA.debugLineNum = 27787265;BA.debugLine="shift_rest";
_shift_rest();
RDebugUtils.currentLine=27787266;
 //BA.debugLineNum = 27787266;BA.debugLine="End Sub";
return "";
}
public static String  _shift_rest() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "shift_rest", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "shift_rest", null));}
RDebugUtils.currentLine=27852800;
 //BA.debugLineNum = 27852800;BA.debugLine="Sub shift_rest";
RDebugUtils.currentLine=27852801;
 //BA.debugLineNum = 27852801;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=27852802;
 //BA.debugLineNum = 27852802;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' set";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set shift='' ");
RDebugUtils.currentLine=27852803;
 //BA.debugLineNum = 27852803;BA.debugLine="If(File.Exists(File.DirInternal,\"shift_olgo\"))The";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo"))) { 
RDebugUtils.currentLine=27852804;
 //BA.debugLineNum = 27852804;BA.debugLine="File.Delete(File.DirInternal,\"shift_olgo\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo");
RDebugUtils.currentLine=27852805;
 //BA.debugLineNum = 27852805;BA.debugLine="File.Delete(File.DirInternal,\"shift_olgo_cod\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo_cod");
 };
RDebugUtils.currentLine=27852809;
 //BA.debugLineNum = 27852809;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=27852810;
 //BA.debugLineNum = 27852810;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
RDebugUtils.currentLine=27852811;
 //BA.debugLineNum = 27852811;BA.debugLine="generat_taghvim(this_year,this_moon)";
_generat_taghvim(_this_year,_this_moon);
RDebugUtils.currentLine=27852812;
 //BA.debugLineNum = 27852812;BA.debugLine="ToastMessageShow(\"همه شیفت ها حذف شدند\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("همه شیفت ها حذف شدند"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=27852814;
 //BA.debugLineNum = 27852814;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_note_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_note_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_note_click", null));}
RDebugUtils.currentLine=27918336;
 //BA.debugLineNum = 27918336;BA.debugLine="Private Sub lbl_edit_note_Click";
RDebugUtils.currentLine=27918337;
 //BA.debugLineNum = 27918337;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=27918338;
 //BA.debugLineNum = 27918338;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_selectedday_id))));
RDebugUtils.currentLine=27918339;
 //BA.debugLineNum = 27918339;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=27918342;
 //BA.debugLineNum = 27918342;BA.debugLine="et_note.Text=dbCode.res.GetString(\"note\")";
mostCurrent._et_note.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("note")));
RDebugUtils.currentLine=27918344;
 //BA.debugLineNum = 27918344;BA.debugLine="lbl_date_in_note.Text=lbl_year_tagvim.Text&\"/\"&db";
mostCurrent._lbl_date_in_note.setText(BA.ObjectToCharSequence(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("moon")+"/"+BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_c"))));
RDebugUtils.currentLine=27918347;
 //BA.debugLineNum = 27918347;BA.debugLine="pan_all_note.Visible=True";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=27918348;
 //BA.debugLineNum = 27918348;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_mah_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_mah_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_mah_click", null));}
RDebugUtils.currentLine=25886720;
 //BA.debugLineNum = 25886720;BA.debugLine="Private Sub lbl_mah_Click";
RDebugUtils.currentLine=25886721;
 //BA.debugLineNum = 25886721;BA.debugLine="rsPOP_mah.Show";
mostCurrent._rspop_mah.Show();
RDebugUtils.currentLine=25886722;
 //BA.debugLineNum = 25886722;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_mah_end_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_mah_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_mah_end_click", null));}
RDebugUtils.currentLine=26279936;
 //BA.debugLineNum = 26279936;BA.debugLine="Private Sub lbl_mah_end_Click";
RDebugUtils.currentLine=26279937;
 //BA.debugLineNum = 26279937;BA.debugLine="rsPOP_mah_end.Show";
mostCurrent._rspop_mah_end.Show();
RDebugUtils.currentLine=26279938;
 //BA.debugLineNum = 26279938;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_moon_name_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_moon_name_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_moon_name_click", null));}
RDebugUtils.currentLine=25493504;
 //BA.debugLineNum = 25493504;BA.debugLine="Private Sub lbl_moon_name_Click";
RDebugUtils.currentLine=25493505;
 //BA.debugLineNum = 25493505;BA.debugLine="rsPOP_moon_tagvim.Show";
mostCurrent._rspop_moon_tagvim.Show();
RDebugUtils.currentLine=25493506;
 //BA.debugLineNum = 25493506;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_new_line_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_new_line_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_new_line_click", null));}
int _i = 0;
RDebugUtils.currentLine=27328512;
 //BA.debugLineNum = 27328512;BA.debugLine="Private Sub lbl_new_line_Click";
RDebugUtils.currentLine=27328515;
 //BA.debugLineNum = 27328515;BA.debugLine="ls_set_shift.AddSingleLine(et_num_roz.Text&\" \"&sp";
mostCurrent._ls_set_shift.AddSingleLine(BA.ObjectToCharSequence(mostCurrent._et_num_roz.getText()+" "+mostCurrent._sp_noe_shift.getSelectedItem()));
RDebugUtils.currentLine=27328516;
 //BA.debugLineNum = 27328516;BA.debugLine="For i=1 To et_num_roz.Text";
{
final int step2 = 1;
final int limit2 = (int)(Double.parseDouble(mostCurrent._et_num_roz.getText()));
_i = (int) (1) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=27328518;
 //BA.debugLineNum = 27328518;BA.debugLine="Select sp_noe_shift.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_noe_shift.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
RDebugUtils.currentLine=27328521;
 //BA.debugLineNum = 27328521;BA.debugLine="list_sift_olgo.Add(\"ر\")";
mostCurrent._list_sift_olgo.Add((Object)("ر"));
 break; }
case 1: {
RDebugUtils.currentLine=27328523;
 //BA.debugLineNum = 27328523;BA.debugLine="list_sift_olgo.Add(\"ع\")";
mostCurrent._list_sift_olgo.Add((Object)("ع"));
 break; }
case 2: {
RDebugUtils.currentLine=27328525;
 //BA.debugLineNum = 27328525;BA.debugLine="list_sift_olgo.Add(\"ش\")";
mostCurrent._list_sift_olgo.Add((Object)("ش"));
 break; }
case 3: {
RDebugUtils.currentLine=27328527;
 //BA.debugLineNum = 27328527;BA.debugLine="list_sift_olgo.Add(\"ا\")";
mostCurrent._list_sift_olgo.Add((Object)("ا"));
 break; }
}
;
 }
};
RDebugUtils.currentLine=27328536;
 //BA.debugLineNum = 27328536;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_next_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_next_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_next_click", null));}
int _adad = 0;
RDebugUtils.currentLine=27131904;
 //BA.debugLineNum = 27131904;BA.debugLine="Private Sub lbl_next_Click";
RDebugUtils.currentLine=27131906;
 //BA.debugLineNum = 27131906;BA.debugLine="If (current_moon>=12)Then";
if ((_current_moon>=12)) { 
RDebugUtils.currentLine=27131908;
 //BA.debugLineNum = 27131908;BA.debugLine="If(lbl_year_tagvim.Text<1403)Then";
if (((double)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()))<1403)) { 
RDebugUtils.currentLine=27131909;
 //BA.debugLineNum = 27131909;BA.debugLine="Dim adad As Int=lbl_year_tagvim.Text";
_adad = (int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()));
RDebugUtils.currentLine=27131910;
 //BA.debugLineNum = 27131910;BA.debugLine="lbl_year_tagvim.Text=adad+1";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_adad+1));
RDebugUtils.currentLine=27131911;
 //BA.debugLineNum = 27131911;BA.debugLine="current_moon=1";
_current_moon = (int) (1);
 }else {
RDebugUtils.currentLine=27131913;
 //BA.debugLineNum = 27131913;BA.debugLine="current_moon=12";
_current_moon = (int) (12);
 };
 }else {
RDebugUtils.currentLine=27131919;
 //BA.debugLineNum = 27131919;BA.debugLine="current_moon=current_moon+1";
_current_moon = (int) (_current_moon+1);
 };
RDebugUtils.currentLine=27131921;
 //BA.debugLineNum = 27131921;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_current_moon);
RDebugUtils.currentLine=27131923;
 //BA.debugLineNum = 27131923;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_prev_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_prev_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_prev_click", null));}
int _adad = 0;
RDebugUtils.currentLine=27197440;
 //BA.debugLineNum = 27197440;BA.debugLine="Private Sub lbl_prev_Click";
RDebugUtils.currentLine=27197442;
 //BA.debugLineNum = 27197442;BA.debugLine="If (current_moon<=1)Then";
if ((_current_moon<=1)) { 
RDebugUtils.currentLine=27197445;
 //BA.debugLineNum = 27197445;BA.debugLine="If(lbl_year_tagvim.Text>1398)Then";
if (((double)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()))>1398)) { 
RDebugUtils.currentLine=27197446;
 //BA.debugLineNum = 27197446;BA.debugLine="Dim adad As Int=lbl_year_tagvim.Text";
_adad = (int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText()));
RDebugUtils.currentLine=27197447;
 //BA.debugLineNum = 27197447;BA.debugLine="lbl_year_tagvim.Text=adad-1";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_adad-1));
RDebugUtils.currentLine=27197448;
 //BA.debugLineNum = 27197448;BA.debugLine="current_moon=12";
_current_moon = (int) (12);
 }else {
RDebugUtils.currentLine=27197450;
 //BA.debugLineNum = 27197450;BA.debugLine="current_moon=1";
_current_moon = (int) (1);
 };
 }else {
RDebugUtils.currentLine=27197455;
 //BA.debugLineNum = 27197455;BA.debugLine="current_moon=current_moon-1";
_current_moon = (int) (_current_moon-1);
 };
RDebugUtils.currentLine=27197457;
 //BA.debugLineNum = 27197457;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_current_moon);
RDebugUtils.currentLine=27197459;
 //BA.debugLineNum = 27197459;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_roz_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_roz_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_roz_click", null));}
RDebugUtils.currentLine=25952256;
 //BA.debugLineNum = 25952256;BA.debugLine="Private Sub lbl_roz_Click";
RDebugUtils.currentLine=25952257;
 //BA.debugLineNum = 25952257;BA.debugLine="rsPOP_roz.Show";
mostCurrent._rspop_roz.Show();
RDebugUtils.currentLine=25952258;
 //BA.debugLineNum = 25952258;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_roz_end_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_roz_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_roz_end_click", null));}
RDebugUtils.currentLine=26345472;
 //BA.debugLineNum = 26345472;BA.debugLine="Private Sub lbl_roz_end_Click";
RDebugUtils.currentLine=26345473;
 //BA.debugLineNum = 26345473;BA.debugLine="rsPOP_roz_end.Show";
mostCurrent._rspop_roz_end.Show();
RDebugUtils.currentLine=26345474;
 //BA.debugLineNum = 26345474;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_note_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_note_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_note_click", null));}
RDebugUtils.currentLine=28180480;
 //BA.debugLineNum = 28180480;BA.debugLine="Private Sub lbl_save_note_Click";
RDebugUtils.currentLine=28180482;
 //BA.debugLineNum = 28180482;BA.debugLine="set_note(selectedDay_id,et_note.Text)";
_set_note(_selectedday_id,mostCurrent._et_note.getText());
RDebugUtils.currentLine=28180483;
 //BA.debugLineNum = 28180483;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,lbl_moon_nam";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())));
RDebugUtils.currentLine=28180484;
 //BA.debugLineNum = 28180484;BA.debugLine="pan_all_note.Visible=False";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=28180485;
 //BA.debugLineNum = 28180485;BA.debugLine="End Sub";
return "";
}
public static String  _set_note(int _id,String _matn) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "set_note", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "set_note", new Object[] {_id,_matn}));}
RDebugUtils.currentLine=28246016;
 //BA.debugLineNum = 28246016;BA.debugLine="Sub set_note(id As Int , matn As String)";
RDebugUtils.currentLine=28246017;
 //BA.debugLineNum = 28246017;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=28246018;
 //BA.debugLineNum = 28246018;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' set";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set note='"+_matn+"' WHERE id="+BA.NumberToString(_id));
RDebugUtils.currentLine=28246020;
 //BA.debugLineNum = 28246020;BA.debugLine="ToastMessageShow(\"یادداشت ذخیره شد\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("یادداشت ذخیره شد"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=28246021;
 //BA.debugLineNum = 28246021;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_shift_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_shift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_shift_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_tosave = null;
int _p = 0;
RDebugUtils.currentLine=27394048;
 //BA.debugLineNum = 27394048;BA.debugLine="Private Sub lbl_save_shift_Click";
RDebugUtils.currentLine=27394051;
 //BA.debugLineNum = 27394051;BA.debugLine="If(ls_set_shift.Size<1)Then";
if ((mostCurrent._ls_set_shift.getSize()<1)) { 
RDebugUtils.currentLine=27394052;
 //BA.debugLineNum = 27394052;BA.debugLine="ToastMessageShow(\"الگو باید حداقل یک مورد باشد\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("الگو باید حداقل یک مورد باشد"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=27394057;
 //BA.debugLineNum = 27394057;BA.debugLine="set_shift(list_sift_olgo)";
_set_shift(mostCurrent._list_sift_olgo);
RDebugUtils.currentLine=27394060;
 //BA.debugLineNum = 27394060;BA.debugLine="Dim ls_toSave As List";
_ls_tosave = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=27394061;
 //BA.debugLineNum = 27394061;BA.debugLine="ls_toSave.Initialize";
_ls_tosave.Initialize();
RDebugUtils.currentLine=27394063;
 //BA.debugLineNum = 27394063;BA.debugLine="For p=0 To ls_set_shift.Size-1";
{
final int step7 = 1;
final int limit7 = (int) (mostCurrent._ls_set_shift.getSize()-1);
_p = (int) (0) ;
for (;_p <= limit7 ;_p = _p + step7 ) {
RDebugUtils.currentLine=27394064;
 //BA.debugLineNum = 27394064;BA.debugLine="ls_toSave.Add(ls_set_shift.GetItem(p))";
_ls_tosave.Add(mostCurrent._ls_set_shift.GetItem(_p));
 }
};
RDebugUtils.currentLine=27394067;
 //BA.debugLineNum = 27394067;BA.debugLine="File.WriteList(File.DirInternal,\"shift_olgo\",ls_";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo",_ls_tosave);
RDebugUtils.currentLine=27394068;
 //BA.debugLineNum = 27394068;BA.debugLine="File.WriteList(File.DirInternal,\"shift_olgo_cod\"";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo_cod",mostCurrent._list_sift_olgo);
RDebugUtils.currentLine=27394071;
 //BA.debugLineNum = 27394071;BA.debugLine="pan_all_setSift.Visible=False";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=27394075;
 //BA.debugLineNum = 27394075;BA.debugLine="lbl_delete_lis_olgo_Click";
_lbl_delete_lis_olgo_click();
RDebugUtils.currentLine=27394076;
 //BA.debugLineNum = 27394076;BA.debugLine="generat_taghvim(this_year,this_moon)";
_generat_taghvim(_this_year,_this_moon);
 };
RDebugUtils.currentLine=27394081;
 //BA.debugLineNum = 27394081;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=27525120;
 //BA.debugLineNum = 27525120;BA.debugLine="Sub set_shift(ol As List )";
RDebugUtils.currentLine=27525122;
 //BA.debugLineNum = 27525122;BA.debugLine="Try";
try {RDebugUtils.currentLine=27525123;
 //BA.debugLineNum = 27525123;BA.debugLine="ProgressDialogShow(\"در حال تنظیم شیفت ها\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("در حال تنظیم شیفت ها"));
RDebugUtils.currentLine=27525125;
 //BA.debugLineNum = 27525125;BA.debugLine="Dim start_shift As Int";
_start_shift = 0;
RDebugUtils.currentLine=27525126;
 //BA.debugLineNum = 27525126;BA.debugLine="Dim end_shift As Int";
_end_shift = 0;
RDebugUtils.currentLine=27525128;
 //BA.debugLineNum = 27525128;BA.debugLine="Dim index_curent_shift As Int=0";
_index_curent_shift = (int) (0);
RDebugUtils.currentLine=27525129;
 //BA.debugLineNum = 27525129;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=27525131;
 //BA.debugLineNum = 27525131;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' se";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE 'my_calander' set shift=''");
RDebugUtils.currentLine=27525134;
 //BA.debugLineNum = 27525134;BA.debugLine="start_shift=dbCode.get_day_id(lbl_years.Text,lbl";
_start_shift = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_years.getText())),_lbl_mah_tagid,(int)(Double.parseDouble(mostCurrent._lbl_roz.getText())));
RDebugUtils.currentLine=27525135;
 //BA.debugLineNum = 27525135;BA.debugLine="end_shift=dbCode.get_day_id(lbl_years_end.Text,l";
_end_shift = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_years_end.getText())),_lbl_mah_end_tagid,(int)(Double.parseDouble(mostCurrent._lbl_roz_end.getText())));
RDebugUtils.currentLine=27525138;
 //BA.debugLineNum = 27525138;BA.debugLine="For i=start_shift To end_shift";
{
final int step10 = 1;
final int limit10 = _end_shift;
_i = _start_shift ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=27525140;
 //BA.debugLineNum = 27525140;BA.debugLine="dbCode.sql.ExecNonQuery2(\"UPDATE 'my_calander'";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE 'my_calander' set shift=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{mostCurrent._list_sift_olgo.Get(_index_curent_shift),(Object)(_i)}));
RDebugUtils.currentLine=27525143;
 //BA.debugLineNum = 27525143;BA.debugLine="If(index_curent_shift=list_sift_olgo.Size-1)The";
if ((_index_curent_shift==mostCurrent._list_sift_olgo.getSize()-1)) { 
RDebugUtils.currentLine=27525144;
 //BA.debugLineNum = 27525144;BA.debugLine="index_curent_shift=0";
_index_curent_shift = (int) (0);
 }else {
RDebugUtils.currentLine=27525146;
 //BA.debugLineNum = 27525146;BA.debugLine="index_curent_shift=index_curent_shift+1";
_index_curent_shift = (int) (_index_curent_shift+1);
 };
 }
};
RDebugUtils.currentLine=27525151;
 //BA.debugLineNum = 27525151;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=27525152;
 //BA.debugLineNum = 27525152;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 } 
       catch (Exception e21) {
			processBA.setLastException(e21);RDebugUtils.currentLine=27525155;
 //BA.debugLineNum = 27525155;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("327525155",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=27525156;
 //BA.debugLineNum = 27525156;BA.debugLine="ToastMessageShow(\"خطا در تاریخ\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در تاریخ"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=27525162;
 //BA.debugLineNum = 27525162;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_show_panshift_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_show_panshift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_show_panshift_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_toload = null;
int _i = 0;
RDebugUtils.currentLine=27459584;
 //BA.debugLineNum = 27459584;BA.debugLine="Private Sub lbl_show_panShift_Click";
RDebugUtils.currentLine=27459586;
 //BA.debugLineNum = 27459586;BA.debugLine="If(File.Exists(File.DirInternal,\"shift_olgo\")=Tru";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=27459588;
 //BA.debugLineNum = 27459588;BA.debugLine="Dim ls_toLoad As List";
_ls_toload = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=27459589;
 //BA.debugLineNum = 27459589;BA.debugLine="ls_toLoad.Initialize";
_ls_toload.Initialize();
RDebugUtils.currentLine=27459591;
 //BA.debugLineNum = 27459591;BA.debugLine="ls_toLoad=File.ReadList(File.DirInternal,\"shift_";
_ls_toload = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo");
RDebugUtils.currentLine=27459593;
 //BA.debugLineNum = 27459593;BA.debugLine="For i=0 To ls_toLoad.Size-1";
{
final int step5 = 1;
final int limit5 = (int) (_ls_toload.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=27459594;
 //BA.debugLineNum = 27459594;BA.debugLine="ls_set_shift.AddSingleLine(ls_toLoad.Get(i))";
mostCurrent._ls_set_shift.AddSingleLine(BA.ObjectToCharSequence(_ls_toload.Get(_i)));
 }
};
RDebugUtils.currentLine=27459597;
 //BA.debugLineNum = 27459597;BA.debugLine="list_sift_olgo=File.ReadList(File.DirInternal,\"s";
mostCurrent._list_sift_olgo = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"shift_olgo_cod");
 };
RDebugUtils.currentLine=27459601;
 //BA.debugLineNum = 27459601;BA.debugLine="pan_all_setSift.Visible=True";
mostCurrent._pan_all_setsift.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=27459603;
 //BA.debugLineNum = 27459603;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_year_tagvim_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_year_tagvim_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_year_tagvim_click", null));}
RDebugUtils.currentLine=25427968;
 //BA.debugLineNum = 25427968;BA.debugLine="Private Sub lbl_year_tagvim_Click";
RDebugUtils.currentLine=25427969;
 //BA.debugLineNum = 25427969;BA.debugLine="rsPOP_year_tagvim.Show";
mostCurrent._rspop_year_tagvim.Show();
RDebugUtils.currentLine=25427970;
 //BA.debugLineNum = 25427970;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_years_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_years_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_years_click", null));}
RDebugUtils.currentLine=25821184;
 //BA.debugLineNum = 25821184;BA.debugLine="Private Sub lbl_years_Click";
RDebugUtils.currentLine=25821185;
 //BA.debugLineNum = 25821185;BA.debugLine="rsPOP_year.Show";
mostCurrent._rspop_year.Show();
RDebugUtils.currentLine=25821186;
 //BA.debugLineNum = 25821186;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_years_end_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_years_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_years_end_click", null));}
RDebugUtils.currentLine=26214400;
 //BA.debugLineNum = 26214400;BA.debugLine="Private Sub lbl_years_end_Click";
RDebugUtils.currentLine=26214401;
 //BA.debugLineNum = 26214401;BA.debugLine="rsPOP_year_end.Show";
mostCurrent._rspop_year_end.Show();
RDebugUtils.currentLine=26214402;
 //BA.debugLineNum = 26214402;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=27066368;
 //BA.debugLineNum = 27066368;BA.debugLine="Private Sub PA_Click";
RDebugUtils.currentLine=27066369;
 //BA.debugLineNum = 27066369;BA.debugLine="Dim str_t As String";
_str_t = "";
RDebugUtils.currentLine=27066370;
 //BA.debugLineNum = 27066370;BA.debugLine="Dim B As Panel = Sender";
_b = new anywheresoftware.b4a.objects.PanelWrapper();
_b = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=27066371;
 //BA.debugLineNum = 27066371;BA.debugLine="selectedDay_id=dbCode.get_day_id(lbl_year_tagvim.";
_selectedday_id = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())),(int)(BA.ObjectToNumber(_b.getTag())));
RDebugUtils.currentLine=27066373;
 //BA.debugLineNum = 27066373;BA.debugLine="For d=0 To PA.Length-1";
{
final int step4 = 1;
final int limit4 = (int) (mostCurrent._pa.length-1);
_d = (int) (0) ;
for (;_d <= limit4 ;_d = _d + step4 ) {
RDebugUtils.currentLine=27066374;
 //BA.debugLineNum = 27066374;BA.debugLine="str_t=PA(d).Tag";
_str_t = BA.ObjectToString(mostCurrent._pa[_d].getTag());
RDebugUtils.currentLine=27066375;
 //BA.debugLineNum = 27066375;BA.debugLine="If ( str_t = last_selected_itemTag )Then";
if (((_str_t).equals(BA.NumberToString(_last_selected_itemtag)))) { 
RDebugUtils.currentLine=27066379;
 //BA.debugLineNum = 27066379;BA.debugLine="If(last_selected_itemTag<>0)Then";
if ((_last_selected_itemtag!=0)) { 
RDebugUtils.currentLine=27066381;
 //BA.debugLineNum = 27066381;BA.debugLine="If(ls_tatili_moon.Get(last_selected_itemTag-1)";
if (((mostCurrent._ls_tatili_moon.Get((int) (_last_selected_itemtag-1))).equals((Object)(anywheresoftware.b4a.keywords.Common.True)))) { 
RDebugUtils.currentLine=27066382;
 //BA.debugLineNum = 27066382;BA.debugLine="PA(d).Color=0xFFFF5252";
mostCurrent._pa[_d].setColor(((int)0xffff5252));
 }else {
RDebugUtils.currentLine=27066384;
 //BA.debugLineNum = 27066384;BA.debugLine="PA(d).Color=0xFFEFEFEF";
mostCurrent._pa[_d].setColor(((int)0xffefefef));
 };
 };
 };
 }
};
RDebugUtils.currentLine=27066396;
 //BA.debugLineNum = 27066396;BA.debugLine="Dim moon_tag As Int=lbl_moon_name.Tag";
_moon_tag = (int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag()));
RDebugUtils.currentLine=27066397;
 //BA.debugLineNum = 27066397;BA.debugLine="If( moon_tag=this_moon)Then";
if ((_moon_tag==_this_moon)) { 
RDebugUtils.currentLine=27066398;
 //BA.debugLineNum = 27066398;BA.debugLine="PA(index_i_today).Color=0xFFFFBD30";
mostCurrent._pa[_index_i_today].setColor(((int)0xffffbd30));
 };
RDebugUtils.currentLine=27066403;
 //BA.debugLineNum = 27066403;BA.debugLine="B.Color=Colors.Gray";
_b.setColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=27066404;
 //BA.debugLineNum = 27066404;BA.debugLine="get_monasebat(selectedDay_id)";
_get_monasebat(_selectedday_id);
RDebugUtils.currentLine=27066405;
 //BA.debugLineNum = 27066405;BA.debugLine="get_note(selectedDay_id)";
_get_note(_selectedday_id);
RDebugUtils.currentLine=27066407;
 //BA.debugLineNum = 27066407;BA.debugLine="get_ezafekari(lbl_year_tagvim.Text&\"/\"&myfunc.con";
_get_ezafekari(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))));
RDebugUtils.currentLine=27066408;
 //BA.debugLineNum = 27066408;BA.debugLine="get_morakhasi(lbl_year_tagvim.Text&\"/\"&myfunc.con";
_get_morakhasi(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))));
RDebugUtils.currentLine=27066409;
 //BA.debugLineNum = 27066409;BA.debugLine="get_taradod(lbl_year_tagvim.Text&\"/\"&myfunc.conve";
_get_taradod(mostCurrent._lbl_year_tagvim.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))));
RDebugUtils.currentLine=27066411;
 //BA.debugLineNum = 27066411;BA.debugLine="last_selected_itemTag=B.Tag";
_last_selected_itemtag = (int)(BA.ObjectToNumber(_b.getTag()));
RDebugUtils.currentLine=27066414;
 //BA.debugLineNum = 27066414;BA.debugLine="End Sub";
return "";
}
public static String  _pa_longclick() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pa_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pa_longclick", null));}
anywheresoftware.b4a.objects.PanelWrapper _b = null;
RDebugUtils.currentLine=27983872;
 //BA.debugLineNum = 27983872;BA.debugLine="Private Sub PA_LongClick";
RDebugUtils.currentLine=27983873;
 //BA.debugLineNum = 27983873;BA.debugLine="Dim B As Panel = Sender";
_b = new anywheresoftware.b4a.objects.PanelWrapper();
_b = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=27983875;
 //BA.debugLineNum = 27983875;BA.debugLine="selectedDay_id=dbCode.get_day_id(lbl_year_tagvim.";
_selectedday_id = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),(int)(BA.ObjectToNumber(mostCurrent._lbl_moon_name.getTag())),(int)(BA.ObjectToNumber(_b.getTag())));
RDebugUtils.currentLine=27983877;
 //BA.debugLineNum = 27983877;BA.debugLine="B.Color=Colors.Gray";
_b.setColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=27983879;
 //BA.debugLineNum = 27983879;BA.debugLine="lbl_edit_note_Click";
_lbl_edit_note_click();
RDebugUtils.currentLine=27983881;
 //BA.debugLineNum = 27983881;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_note_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_note_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_note_click", null));}
RDebugUtils.currentLine=28049408;
 //BA.debugLineNum = 28049408;BA.debugLine="Private Sub pan_all_note_Click";
RDebugUtils.currentLine=28049409;
 //BA.debugLineNum = 28049409;BA.debugLine="pan_all_note.Visible=False";
mostCurrent._pan_all_note.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=28049410;
 //BA.debugLineNum = 28049410;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_setsift_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_setsift_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_setsift_click", null));}
RDebugUtils.currentLine=27262976;
 //BA.debugLineNum = 27262976;BA.debugLine="Private Sub pan_all_setSift_Click";
RDebugUtils.currentLine=27262978;
 //BA.debugLineNum = 27262978;BA.debugLine="End Sub";
return "";
}
public static String  _panel12_click() throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel12_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel12_click", null));}
RDebugUtils.currentLine=28114944;
 //BA.debugLineNum = 28114944;BA.debugLine="Private Sub Panel12_Click";
RDebugUtils.currentLine=28114946;
 //BA.debugLineNum = 28114946;BA.debugLine="End Sub";
return "";
}
public static boolean  _rspop_mah_end_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_mah_end_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_mah_end_menuitemclick", new Object[] {_itemid}));}
String _mmah = "";
RDebugUtils.currentLine=26083328;
 //BA.debugLineNum = 26083328;BA.debugLine="Sub rsPOP_mah_end_MenuItemClick (ItemId As Int) As";
RDebugUtils.currentLine=26083329;
 //BA.debugLineNum = 26083329;BA.debugLine="Dim mmah As String";
_mmah = "";
RDebugUtils.currentLine=26083330;
 //BA.debugLineNum = 26083330;BA.debugLine="Select ItemId";
switch (_itemid) {
case 1: {
RDebugUtils.currentLine=26083332;
 //BA.debugLineNum = 26083332;BA.debugLine="mmah=\"فروردین\"";
_mmah = "فروردین";
 break; }
case 2: {
RDebugUtils.currentLine=26083334;
 //BA.debugLineNum = 26083334;BA.debugLine="mmah=\"اردیبهشت\"";
_mmah = "اردیبهشت";
 break; }
case 3: {
RDebugUtils.currentLine=26083336;
 //BA.debugLineNum = 26083336;BA.debugLine="mmah=\"خرداد\"";
_mmah = "خرداد";
 break; }
case 4: {
RDebugUtils.currentLine=26083338;
 //BA.debugLineNum = 26083338;BA.debugLine="mmah=\"تیر\"";
_mmah = "تیر";
 break; }
case 5: {
RDebugUtils.currentLine=26083340;
 //BA.debugLineNum = 26083340;BA.debugLine="mmah=\"مرداد\"";
_mmah = "مرداد";
 break; }
case 6: {
RDebugUtils.currentLine=26083342;
 //BA.debugLineNum = 26083342;BA.debugLine="mmah=\"شهریور\"";
_mmah = "شهریور";
 break; }
case 7: {
RDebugUtils.currentLine=26083344;
 //BA.debugLineNum = 26083344;BA.debugLine="mmah=\"مهر\"";
_mmah = "مهر";
 break; }
case 8: {
RDebugUtils.currentLine=26083346;
 //BA.debugLineNum = 26083346;BA.debugLine="mmah=\"آبان\"";
_mmah = "آبان";
 break; }
case 9: {
RDebugUtils.currentLine=26083348;
 //BA.debugLineNum = 26083348;BA.debugLine="mmah=\"آذر\"";
_mmah = "آذر";
 break; }
case 10: {
RDebugUtils.currentLine=26083350;
 //BA.debugLineNum = 26083350;BA.debugLine="mmah=\"دی\"";
_mmah = "دی";
 break; }
case 11: {
RDebugUtils.currentLine=26083352;
 //BA.debugLineNum = 26083352;BA.debugLine="mmah=\"بهمن\"";
_mmah = "بهمن";
 break; }
case 12: {
RDebugUtils.currentLine=26083354;
 //BA.debugLineNum = 26083354;BA.debugLine="mmah=\"اسفند\"";
_mmah = "اسفند";
 break; }
}
;
RDebugUtils.currentLine=26083360;
 //BA.debugLineNum = 26083360;BA.debugLine="lbl_mah_end.Text=mmah";
mostCurrent._lbl_mah_end.setText(BA.ObjectToCharSequence(_mmah));
RDebugUtils.currentLine=26083361;
 //BA.debugLineNum = 26083361;BA.debugLine="lbl_mah_end_tagID=ItemId";
_lbl_mah_end_tagid = _itemid;
RDebugUtils.currentLine=26083363;
 //BA.debugLineNum = 26083363;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=26083364;
 //BA.debugLineNum = 26083364;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_mah_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_mah_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_mah_menuitemclick", new Object[] {_itemid}));}
String _mmah = "";
RDebugUtils.currentLine=25690112;
 //BA.debugLineNum = 25690112;BA.debugLine="Sub rsPOP_mah_MenuItemClick (ItemId As Int) As Boo";
RDebugUtils.currentLine=25690113;
 //BA.debugLineNum = 25690113;BA.debugLine="Dim mmah As String";
_mmah = "";
RDebugUtils.currentLine=25690114;
 //BA.debugLineNum = 25690114;BA.debugLine="Select ItemId";
switch (_itemid) {
case 1: {
RDebugUtils.currentLine=25690116;
 //BA.debugLineNum = 25690116;BA.debugLine="mmah=\"فروردین\"";
_mmah = "فروردین";
 break; }
case 2: {
RDebugUtils.currentLine=25690118;
 //BA.debugLineNum = 25690118;BA.debugLine="mmah=\"اردیبهشت\"";
_mmah = "اردیبهشت";
 break; }
case 3: {
RDebugUtils.currentLine=25690120;
 //BA.debugLineNum = 25690120;BA.debugLine="mmah=\"خرداد\"";
_mmah = "خرداد";
 break; }
case 4: {
RDebugUtils.currentLine=25690122;
 //BA.debugLineNum = 25690122;BA.debugLine="mmah=\"تیر\"";
_mmah = "تیر";
 break; }
case 5: {
RDebugUtils.currentLine=25690124;
 //BA.debugLineNum = 25690124;BA.debugLine="mmah=\"مرداد\"";
_mmah = "مرداد";
 break; }
case 6: {
RDebugUtils.currentLine=25690126;
 //BA.debugLineNum = 25690126;BA.debugLine="mmah=\"شهریور\"";
_mmah = "شهریور";
 break; }
case 7: {
RDebugUtils.currentLine=25690128;
 //BA.debugLineNum = 25690128;BA.debugLine="mmah=\"مهر\"";
_mmah = "مهر";
 break; }
case 8: {
RDebugUtils.currentLine=25690130;
 //BA.debugLineNum = 25690130;BA.debugLine="mmah=\"آبان\"";
_mmah = "آبان";
 break; }
case 9: {
RDebugUtils.currentLine=25690132;
 //BA.debugLineNum = 25690132;BA.debugLine="mmah=\"آذر\"";
_mmah = "آذر";
 break; }
case 10: {
RDebugUtils.currentLine=25690134;
 //BA.debugLineNum = 25690134;BA.debugLine="mmah=\"دی\"";
_mmah = "دی";
 break; }
case 11: {
RDebugUtils.currentLine=25690136;
 //BA.debugLineNum = 25690136;BA.debugLine="mmah=\"بهمن\"";
_mmah = "بهمن";
 break; }
case 12: {
RDebugUtils.currentLine=25690138;
 //BA.debugLineNum = 25690138;BA.debugLine="mmah=\"اسفند\"";
_mmah = "اسفند";
 break; }
}
;
RDebugUtils.currentLine=25690142;
 //BA.debugLineNum = 25690142;BA.debugLine="lbl_mah.Text=mmah";
mostCurrent._lbl_mah.setText(BA.ObjectToCharSequence(_mmah));
RDebugUtils.currentLine=25690143;
 //BA.debugLineNum = 25690143;BA.debugLine="lbl_mah_tagID=ItemId";
_lbl_mah_tagid = _itemid;
RDebugUtils.currentLine=25690145;
 //BA.debugLineNum = 25690145;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=25690146;
 //BA.debugLineNum = 25690146;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_moon_tagvim_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_moon_tagvim_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_moon_tagvim_menuitemclick", new Object[] {_itemid}));}
String _mmah = "";
RDebugUtils.currentLine=25559040;
 //BA.debugLineNum = 25559040;BA.debugLine="Sub rsPOP_moon_tagvim_MenuItemClick (ItemId As Int";
RDebugUtils.currentLine=25559041;
 //BA.debugLineNum = 25559041;BA.debugLine="Dim mmah As String";
_mmah = "";
RDebugUtils.currentLine=25559042;
 //BA.debugLineNum = 25559042;BA.debugLine="Select ItemId";
switch (_itemid) {
case 1: {
RDebugUtils.currentLine=25559044;
 //BA.debugLineNum = 25559044;BA.debugLine="mmah=\"فروردین\"";
_mmah = "فروردین";
 break; }
case 2: {
RDebugUtils.currentLine=25559046;
 //BA.debugLineNum = 25559046;BA.debugLine="mmah=\"اردیبهشت\"";
_mmah = "اردیبهشت";
 break; }
case 3: {
RDebugUtils.currentLine=25559048;
 //BA.debugLineNum = 25559048;BA.debugLine="mmah=\"خرداد\"";
_mmah = "خرداد";
 break; }
case 4: {
RDebugUtils.currentLine=25559050;
 //BA.debugLineNum = 25559050;BA.debugLine="mmah=\"تیر\"";
_mmah = "تیر";
 break; }
case 5: {
RDebugUtils.currentLine=25559052;
 //BA.debugLineNum = 25559052;BA.debugLine="mmah=\"مرداد\"";
_mmah = "مرداد";
 break; }
case 6: {
RDebugUtils.currentLine=25559054;
 //BA.debugLineNum = 25559054;BA.debugLine="mmah=\"شهریور\"";
_mmah = "شهریور";
 break; }
case 7: {
RDebugUtils.currentLine=25559056;
 //BA.debugLineNum = 25559056;BA.debugLine="mmah=\"مهر\"";
_mmah = "مهر";
 break; }
case 8: {
RDebugUtils.currentLine=25559058;
 //BA.debugLineNum = 25559058;BA.debugLine="mmah=\"آبان\"";
_mmah = "آبان";
 break; }
case 9: {
RDebugUtils.currentLine=25559060;
 //BA.debugLineNum = 25559060;BA.debugLine="mmah=\"آذر\"";
_mmah = "آذر";
 break; }
case 10: {
RDebugUtils.currentLine=25559062;
 //BA.debugLineNum = 25559062;BA.debugLine="mmah=\"دی\"";
_mmah = "دی";
 break; }
case 11: {
RDebugUtils.currentLine=25559064;
 //BA.debugLineNum = 25559064;BA.debugLine="mmah=\"بهمن\"";
_mmah = "بهمن";
 break; }
case 12: {
RDebugUtils.currentLine=25559066;
 //BA.debugLineNum = 25559066;BA.debugLine="mmah=\"اسفند\"";
_mmah = "اسفند";
 break; }
}
;
RDebugUtils.currentLine=25559070;
 //BA.debugLineNum = 25559070;BA.debugLine="lbl_moon_name.Text=mmah";
mostCurrent._lbl_moon_name.setText(BA.ObjectToCharSequence(_mmah));
RDebugUtils.currentLine=25559072;
 //BA.debugLineNum = 25559072;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,ItemId)";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_itemid);
RDebugUtils.currentLine=25559073;
 //BA.debugLineNum = 25559073;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=25559074;
 //BA.debugLineNum = 25559074;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_roz_end_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_roz_end_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_roz_end_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=26148864;
 //BA.debugLineNum = 26148864;BA.debugLine="Sub rsPOP_roz_end_MenuItemClick (ItemId As Int) As";
RDebugUtils.currentLine=26148866;
 //BA.debugLineNum = 26148866;BA.debugLine="lbl_roz_end.Text=ItemId";
mostCurrent._lbl_roz_end.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=26148867;
 //BA.debugLineNum = 26148867;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=26148868;
 //BA.debugLineNum = 26148868;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_roz_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_roz_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_roz_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=25755648;
 //BA.debugLineNum = 25755648;BA.debugLine="Sub rsPOP_roz_MenuItemClick (ItemId As Int) As Boo";
RDebugUtils.currentLine=25755650;
 //BA.debugLineNum = 25755650;BA.debugLine="lbl_roz.Text=ItemId";
mostCurrent._lbl_roz.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=25755651;
 //BA.debugLineNum = 25755651;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=25755652;
 //BA.debugLineNum = 25755652;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_year_end_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_year_end_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_year_end_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=26017792;
 //BA.debugLineNum = 26017792;BA.debugLine="Sub rsPOP_year_end_MenuItemClick (ItemId As Int) A";
RDebugUtils.currentLine=26017793;
 //BA.debugLineNum = 26017793;BA.debugLine="lbl_years_end.Text=ItemId";
mostCurrent._lbl_years_end.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=26017794;
 //BA.debugLineNum = 26017794;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=26017795;
 //BA.debugLineNum = 26017795;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_year_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_year_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_year_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=25624576;
 //BA.debugLineNum = 25624576;BA.debugLine="Sub rsPOP_year_MenuItemClick (ItemId As Int) As Bo";
RDebugUtils.currentLine=25624577;
 //BA.debugLineNum = 25624577;BA.debugLine="lbl_years.Text=ItemId";
mostCurrent._lbl_years.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=25624578;
 //BA.debugLineNum = 25624578;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=25624579;
 //BA.debugLineNum = 25624579;BA.debugLine="End Sub";
return false;
}
public static boolean  _rspop_year_tagvim_menuitemclick(int _itemid) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rspop_year_tagvim_menuitemclick", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "rspop_year_tagvim_menuitemclick", new Object[] {_itemid}));}
RDebugUtils.currentLine=25362432;
 //BA.debugLineNum = 25362432;BA.debugLine="Sub rsPOP_year_tagvim_MenuItemClick (ItemId As Int";
RDebugUtils.currentLine=25362433;
 //BA.debugLineNum = 25362433;BA.debugLine="lbl_year_tagvim.Text=ItemId";
mostCurrent._lbl_year_tagvim.setText(BA.ObjectToCharSequence(_itemid));
RDebugUtils.currentLine=25362434;
 //BA.debugLineNum = 25362434;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
_generat_taghvim((int)(Double.parseDouble(mostCurrent._lbl_year_tagvim.getText())),_current_moon);
RDebugUtils.currentLine=25362435;
 //BA.debugLineNum = 25362435;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=25362436;
 //BA.debugLineNum = 25362436;BA.debugLine="End Sub";
return false;
}
public static String  _sql_nonquerycomplete(boolean _success) throws Exception{
RDebugUtils.currentModule="shift_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sql_nonquerycomplete", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sql_nonquerycomplete", new Object[] {_success}));}
RDebugUtils.currentLine=27590656;
 //BA.debugLineNum = 27590656;BA.debugLine="Sub sql_NonQueryComplete (Success As Boolean)";
RDebugUtils.currentLine=27590658;
 //BA.debugLineNum = 27590658;BA.debugLine="End Sub";
return "";
}
}