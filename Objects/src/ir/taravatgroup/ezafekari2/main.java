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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.main");
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
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
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
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (setting_activity.mostCurrent != null);
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
vis = vis | (setting_hogog_activity.mostCurrent != null);
vis = vis | (shift_activity.mostCurrent != null);
vis = vis | (show_gozaresh_activity.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 290;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 294;BA.debugLine="Try";
try { //BA.debugLineNum = 295;BA.debugLine="inapp.Initialize(\"inapp\",key)";
mostCurrent._inapp.Initialize(processBA,"inapp",mostCurrent._key);
 } 
       catch (Exception e4) {
			processBA.setLastException(e4); //BA.debugLineNum = 297;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("2131079",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 302;BA.debugLine="dbCode.init_notfound(\"ksorat\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"ksorat",BA.NumberToString(0));
 //BA.debugLineNum = 304;BA.debugLine="dbCode.init_notfound(\"morakhasi_mande_d\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_mande_d",BA.NumberToString(0));
 //BA.debugLineNum = 305;BA.debugLine="dbCode.init_notfound(\"morakhasi_mande_h\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_mande_h",BA.NumberToString(0));
 //BA.debugLineNum = 306;BA.debugLine="dbCode.init_notfound(\"morakhasi_mande_m\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_mande_m",BA.NumberToString(0));
 //BA.debugLineNum = 308;BA.debugLine="dbCode.init_notfound(\"morakhasi_darMah_d\",2)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_darMah_d",BA.NumberToString(2));
 //BA.debugLineNum = 309;BA.debugLine="dbCode.init_notfound(\"morakhasi_darMah_h\",4)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_darMah_h",BA.NumberToString(4));
 //BA.debugLineNum = 310;BA.debugLine="dbCode.init_notfound(\"morakhasi_darMah_m\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_darMah_m",BA.NumberToString(0));
 //BA.debugLineNum = 312;BA.debugLine="dbCode.init_notfound(\"saat_kar_darRoz\",480)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"saat_kar_darRoz",BA.NumberToString(480));
 //BA.debugLineNum = 316;BA.debugLine="dbCode.install_db_tbl_taradod";
mostCurrent._dbcode._install_db_tbl_taradod /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 317;BA.debugLine="dbCode.install_db_tbl_myCalander";
mostCurrent._dbcode._install_db_tbl_mycalander /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 318;BA.debugLine="dbCode.cheng_tagvim";
mostCurrent._dbcode._cheng_tagvim /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 319;BA.debugLine="dbCode.install_db_tbl_onvanha";
mostCurrent._dbcode._install_db_tbl_onvanha /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 323;BA.debugLine="img1.Initialize(LoadBitmap(File.DirAssets,\"m1.png";
mostCurrent._img1.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m1.png").getObject()));
 //BA.debugLineNum = 324;BA.debugLine="img1.Gravity=Gravity.FILL";
mostCurrent._img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 326;BA.debugLine="img2.Initialize(LoadBitmap(File.DirAssets,\"m2.png";
mostCurrent._img2.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m2.png").getObject()));
 //BA.debugLineNum = 327;BA.debugLine="img2.Gravity=Gravity.FILL";
mostCurrent._img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 329;BA.debugLine="img3.Initialize(LoadBitmap(File.DirAssets,\"m3.png";
mostCurrent._img3.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m3.png").getObject()));
 //BA.debugLineNum = 330;BA.debugLine="img3.Gravity=Gravity.FILL";
mostCurrent._img3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 332;BA.debugLine="If(FirstTime)Then";
if ((_firsttime)) { 
 //BA.debugLineNum = 333;BA.debugLine="Activity.LoadLayout(\"splash_layout\")";
mostCurrent._activity.LoadLayout("splash_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 334;BA.debugLine="lbl_vesion_app.Text=app_vesion";
mostCurrent._lbl_vesion_app.setText(BA.ObjectToCharSequence(_app_vesion));
 //BA.debugLineNum = 335;BA.debugLine="cv_loader.Show";
mostCurrent._cv_loader._show /*String*/ ();
 //BA.debugLineNum = 336;BA.debugLine="timer1.Initialize(\"timer1\" , 1500)";
_timer1.Initialize(processBA,"timer1",(long) (1500));
 //BA.debugLineNum = 338;BA.debugLine="timer1.Enabled=True";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 340;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 341;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 //BA.debugLineNum = 345;BA.debugLine="moon.Initialize";
mostCurrent._moon.Initialize();
 //BA.debugLineNum = 346;BA.debugLine="moon.AddAll(Array As String(\"فروردین\", \"اردیبهشت\"";
mostCurrent._moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
 //BA.debugLineNum = 349;BA.debugLine="strfun.Initialize";
mostCurrent._strfun._initialize(processBA);
 //BA.debugLineNum = 353;BA.debugLine="If(buy_index=1)Then";
if ((_buy_index==1)) { 
 //BA.debugLineNum = 354;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 //BA.debugLineNum = 355;BA.debugLine="buy_index=0";
_buy_index = (int) (0);
 };
 //BA.debugLineNum = 361;BA.debugLine="tim_msg.Initialize(\"tim_msg\",4000)";
_tim_msg.Initialize(processBA,"tim_msg",(long) (4000));
 //BA.debugLineNum = 363;BA.debugLine="ls1.Initialize";
mostCurrent._ls1.Initialize();
 //BA.debugLineNum = 364;BA.debugLine="ls2.Initialize";
mostCurrent._ls2.Initialize();
 //BA.debugLineNum = 365;BA.debugLine="ls3.Initialize";
mostCurrent._ls3.Initialize();
 //BA.debugLineNum = 368;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1"))) { 
 //BA.debugLineNum = 369;BA.debugLine="ls1=File.ReadList(File.DirInternal,\"ls1\")";
mostCurrent._ls1 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1");
 //BA.debugLineNum = 370;BA.debugLine="ls2=File.ReadList(File.DirInternal,\"ls2\")";
mostCurrent._ls2 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls2");
 //BA.debugLineNum = 371;BA.debugLine="ls3=File.ReadList(File.DirInternal,\"ls3\")";
mostCurrent._ls3 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls3");
 //BA.debugLineNum = 373;BA.debugLine="last_notif=ls1.Get(ls1.Size-1)";
mostCurrent._last_notif = BA.ObjectToString(mostCurrent._ls1.Get((int) (mostCurrent._ls1.getSize()-1)));
 //BA.debugLineNum = 374;BA.debugLine="is_now_instal=False";
_is_now_instal = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 382;BA.debugLine="If(myfunc.check_karid=True)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 383;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
 }else {
 //BA.debugLineNum = 385;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
 };
 //BA.debugLineNum = 407;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
int _result = 0;
 //BA.debugLineNum = 1886;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 1887;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 1888;BA.debugLine="If (pan_all_msgNewYear.Visible=True)Then";
if ((mostCurrent._pan_all_msgnewyear.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1889;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_help.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1892;BA.debugLine="lbl_close_help_Click";
_lbl_close_help_click();
 }else if((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1896;BA.debugLine="If(pan_all2.Visible=True)Then";
if ((mostCurrent._pan_all2.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1897;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 1899;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }else if((mostCurrent._pan_notifi_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1903;BA.debugLine="lbl_close_notif_Click";
_lbl_close_notif_click();
 }else if((_index_page==2 || _index_page==3)) { 
 //BA.debugLineNum = 1905;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 }else if((mostCurrent._pan_all_noskhe.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1907;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
 }else if((mostCurrent._pan_all_litemenu.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1909;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 1913;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 1914;BA.debugLine="result = Msgbox2(\"آیا قصد خروج دارید؟\", \"خروج\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا قصد خروج دارید؟"),BA.ObjectToCharSequence("خروج"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 1915;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 1916;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 };
 };
 //BA.debugLineNum = 1922;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 1924;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1926;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 821;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 823;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 817;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 819;BA.debugLine="End Sub";
return "";
}
public static String  _add_end() throws Exception{
boolean _chek = false;
anywheresoftware.b4a.objects.collections.List _alist = null;
 //BA.debugLineNum = 1618;BA.debugLine="Sub add_end";
 //BA.debugLineNum = 1619;BA.debugLine="Dim chek As Boolean";
_chek = false;
 //BA.debugLineNum = 1620;BA.debugLine="chek=myfunc.check_karid";
_chek = mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1621;BA.debugLine="Dim alist As List";
_alist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1622;BA.debugLine="alist.Initialize";
_alist.Initialize();
 //BA.debugLineNum = 1624;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 1625;BA.debugLine="Select myfunc.fa2en(persianDate.PersianMonth)";
switch (BA.switchObjectToInt(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth())),BA.NumberToString(0),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9),BA.NumberToString(10),BA.NumberToString(11),BA.NumberToString(12))) {
case 0: {
 //BA.debugLineNum = 1627;BA.debugLine="moon_num=\"01\"";
_moon_num = "01";
 break; }
case 1: {
 //BA.debugLineNum = 1629;BA.debugLine="moon_num=\"02\"";
_moon_num = "02";
 break; }
case 2: {
 //BA.debugLineNum = 1631;BA.debugLine="moon_num=\"03\"";
_moon_num = "03";
 break; }
case 3: {
 //BA.debugLineNum = 1633;BA.debugLine="moon_num=\"04\"";
_moon_num = "04";
 break; }
case 4: {
 //BA.debugLineNum = 1635;BA.debugLine="moon_num=\"05\"";
_moon_num = "05";
 break; }
case 5: {
 //BA.debugLineNum = 1637;BA.debugLine="moon_num=\"06\"";
_moon_num = "06";
 break; }
case 6: {
 //BA.debugLineNum = 1639;BA.debugLine="moon_num=\"07\"";
_moon_num = "07";
 break; }
case 7: {
 //BA.debugLineNum = 1641;BA.debugLine="moon_num=\"08\"";
_moon_num = "08";
 break; }
case 8: {
 //BA.debugLineNum = 1643;BA.debugLine="moon_num=\"09\"";
_moon_num = "09";
 break; }
case 9: {
 //BA.debugLineNum = 1645;BA.debugLine="moon_num=\"10\"";
_moon_num = "10";
 break; }
case 10: {
 //BA.debugLineNum = 1647;BA.debugLine="moon_num=\"11\"";
_moon_num = "11";
 break; }
case 11: {
 //BA.debugLineNum = 1649;BA.debugLine="moon_num=\"12\"";
_moon_num = "12";
 break; }
}
;
 //BA.debugLineNum = 1652;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(persianDate.Pe";
_alist = mostCurrent._myfunc._num_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear())),_moon_num);
 //BA.debugLineNum = 1655;BA.debugLine="If(index_box=1) Then";
if ((_index_box==1)) { 
 //BA.debugLineNum = 1656;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1657;BA.debugLine="If(alist.Get(0)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (0))))<5)) { 
 //BA.debugLineNum = 1658;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 }else {
 //BA.debugLineNum = 1660;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 1664;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 };
 }else if((_index_box==2)) { 
 //BA.debugLineNum = 1669;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1670;BA.debugLine="If(alist.Get(1)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (1))))<5)) { 
 //BA.debugLineNum = 1671;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 }else {
 //BA.debugLineNum = 1673;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 1676;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 };
 }else if((_index_box==3)) { 
 //BA.debugLineNum = 1681;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1682;BA.debugLine="If(alist.Get(3)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (3))))<5)) { 
 //BA.debugLineNum = 1683;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 }else {
 //BA.debugLineNum = 1685;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 1688;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 }else if((_index_box==4)) { 
 //BA.debugLineNum = 1694;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1695;BA.debugLine="If(alist.Get(3)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (3))))<5)) { 
 //BA.debugLineNum = 1696;BA.debugLine="add_taradod_fast";
_add_taradod_fast();
 }else {
 //BA.debugLineNum = 1698;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 //BA.debugLineNum = 1699;BA.debugLine="lbl_tim_vorod_FT.Text=\"00:00\"";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 1700;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
 //BA.debugLineNum = 1701;BA.debugLine="pan_all_FT_Click";
_pan_all_ft_click();
 };
 }else {
 //BA.debugLineNum = 1704;BA.debugLine="add_taradod_fast";
_add_taradod_fast();
 };
 };
 //BA.debugLineNum = 1708;BA.debugLine="End Sub";
return "";
}
public static String  _add_ezafe_sub() throws Exception{
int _state_mod = 0;
String _str_mod = "";
anywheresoftware.b4a.objects.collections.List _ls_temp_time1 = null;
 //BA.debugLineNum = 1710;BA.debugLine="Sub add_ezafe_sub";
 //BA.debugLineNum = 1711;BA.debugLine="Dim state_mod As Int=0";
_state_mod = (int) (0);
 //BA.debugLineNum = 1712;BA.debugLine="Dim str_mod As String=\"\"";
_str_mod = "";
 //BA.debugLineNum = 1713;BA.debugLine="If(ckb_ezaf_taradod.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1714;BA.debugLine="state_mod=2";
_state_mod = (int) (2);
 //BA.debugLineNum = 1715;BA.debugLine="str_mod=\" (فوق العاده)- \"";
_str_mod = " (فوق العاده)- ";
 }else {
 //BA.debugLineNum = 1717;BA.debugLine="state_mod=0";
_state_mod = (int) (0);
 };
 //BA.debugLineNum = 1721;BA.debugLine="Try";
try { //BA.debugLineNum = 1723;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 1724;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0 || _day_bt!=0)) { 
 //BA.debugLineNum = 1727;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0)) { 
 //BA.debugLineNum = 1729;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 1733;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1734;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_ezafekari_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1735;BA.debugLine="myfunc.help_man(\"برای این تاریخ اضافه کاری وج";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"برای این تاریخ اضافه کاری وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید");
 }else {
 //BA.debugLineNum = 1737;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 1739;BA.debugLine="Dim ls_temp_time1 As List";
_ls_temp_time1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1740;BA.debugLine="ls_temp_time1.Initialize";
_ls_temp_time1.Initialize();
 //BA.debugLineNum = 1742;BA.debugLine="ls_temp_time1.Add(lbl_tim1.Text)";
_ls_temp_time1.Add((Object)(mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 1743;BA.debugLine="ls_temp_time1.Add(lbl_tim2.Text)";
_ls_temp_time1.Add((Object)(mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 1745;BA.debugLine="File.WriteList(File.DirInternal,\"temp_time1.t";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time1.txt",_ls_temp_time1);
 //BA.debugLineNum = 1747;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1748;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 1752;BA.debugLine="dbCode.edit_ezafekari(current_id_edit,date1,da";
mostCurrent._dbcode._edit_ezafekari /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 1753;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1755;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 //BA.debugLineNum = 1756;BA.debugLine="TabHost1.CurrentTab=0";
mostCurrent._tabhost1.setCurrentTab((int) (0));
 };
 //BA.debugLineNum = 1759;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e39) {
			processBA.setLastException(e39); //BA.debugLineNum = 1765;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 1770;BA.debugLine="End Sub";
return "";
}
public static String  _add_morakhasi_sub() throws Exception{
String _str_noe2 = "";
 //BA.debugLineNum = 1772;BA.debugLine="Sub add_morakhasi_sub";
 //BA.debugLineNum = 1773;BA.debugLine="Dim str_noe2 As String";
_str_noe2 = "";
 //BA.debugLineNum = 1774;BA.debugLine="str_noe2=\"(\"&str_noe&\")- \"";
_str_noe2 = "("+mostCurrent._str_noe+")- ";
 //BA.debugLineNum = 1776;BA.debugLine="Try";
try { //BA.debugLineNum = 1777;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
if ((_day_bt<0 || _hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 1778;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0)) { 
 //BA.debugLineNum = 1780;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0 && _day_bt==0)) { 
 //BA.debugLineNum = 1782;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 1787;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1788;BA.debugLine="If(dbCode.isexist_morakhasi_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_morakhasi_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1789;BA.debugLine="myfunc.help_man(\"برای این تاریخ مرخصی وجود دا";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"برای این تاریخ مرخصی وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید");
 }else {
 //BA.debugLineNum = 1791;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_morakhasi /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_noe2+mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
 //BA.debugLineNum = 1792;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1793;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 1796;BA.debugLine="dbCode.edit_morakhasi(current_id_edit,date1,da";
mostCurrent._dbcode._edit_morakhasi /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
 //BA.debugLineNum = 1798;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1799;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 //BA.debugLineNum = 1800;BA.debugLine="TabHost1.CurrentTab=1";
mostCurrent._tabhost1.setCurrentTab((int) (1));
 };
 //BA.debugLineNum = 1805;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e28) {
			processBA.setLastException(e28); //BA.debugLineNum = 1811;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 1816;BA.debugLine="End Sub";
return "";
}
public static String  _add_taradod_fast() throws Exception{
String _str_ft1 = "";
int _tim_min2 = 0;
int _dagige_fixed = 0;
String _saat_fixed = "";
String _str_ft2 = "";
String _str_ft3 = "";
 //BA.debugLineNum = 3389;BA.debugLine="Sub add_taradod_fast";
 //BA.debugLineNum = 3391;BA.debugLine="Try";
try { //BA.debugLineNum = 3393;BA.debugLine="If(dbCode.isexist_taradod_by_date(lbl_date_FT.Te";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText())==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 3395;BA.debugLine="Dim str_Ft1 As String=et_tozihat_FT.Text";
_str_ft1 = mostCurrent._et_tozihat_ft.getText();
 //BA.debugLineNum = 3396;BA.debugLine="If (ckb_ezaf_taradod_FT.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod_ft.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 3399;BA.debugLine="dbCode.add_taradod(lbl_date_FT.Text,lbl_date_F";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),(int) (0),(int) (0),(int) (0),_str_ft1,(int) (20));
 }else {
 //BA.debugLineNum = 3403;BA.debugLine="dbCode.add_taradod(lbl_date_FT.Text,lbl_date_F";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),(int) (0),(int) (0),(int) (0),_str_ft1,(int) (10));
 };
 //BA.debugLineNum = 3406;BA.debugLine="Log(\"is frest\")";
anywheresoftware.b4a.keywords.Common.LogImpl("216121873","is frest",0);
 //BA.debugLineNum = 3407;BA.debugLine="ToastMessageShow(\"ورود ثبت شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ورود ثبت شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3410;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 3411;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 3417;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
 //BA.debugLineNum = 3419;BA.debugLine="If (ckb_ezaf_taradod_FT.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod_ft.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 3421;BA.debugLine="Dim tim_min2 As Int=(hour_bt*60)+min_bt";
_tim_min2 = (int) ((_hour_bt*60)+_min_bt);
 //BA.debugLineNum = 3424;BA.debugLine="If(tim_min2>saat_kar_min) Then";
if ((_tim_min2>_saat_kar_min)) { 
 //BA.debugLineNum = 3426;BA.debugLine="Dim dagige_fixed As Int = tim_vorod_conv_ezaf";
_dagige_fixed = _tim_vorod_conv_ezaf(mostCurrent._lbl_tim_vorod_ft.getText());
 //BA.debugLineNum = 3427;BA.debugLine="Dim saat_fixed As String = (myfunc.Min_to_saa";
_saat_fixed = BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_dagige_fixed).Get((int) (0))))+":"+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_dagige_fixed).Get((int) (1))));
 //BA.debugLineNum = 3429;BA.debugLine="dbCode.add_ezafekari(lbl_date_FT.Text,lbl_dat";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),_saat_fixed,mostCurrent._lbl_tim_khoroj_ft.getText(),_day_bt,(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min2-_saat_kar_min)).Get((int) (0))))),(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min2-_saat_kar_min)).Get((int) (1)))))," (ثبت سریع-تردد دارد)- ",(int) (0));
 };
 //BA.debugLineNum = 3432;BA.debugLine="Dim str_Ft2 As String=\"(ثبت سریع-اضافه کاری)-\"";
_str_ft2 = "(ثبت سریع-اضافه کاری)-"+mostCurrent._et_tozihat_ft.getText();
 //BA.debugLineNum = 3433;BA.debugLine="dbCode.edit_taradod(current_id_edit,lbl_date_F";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),_day_bt,_hour_bt,_min_bt,_str_ft2,(int) (21));
 }else {
 //BA.debugLineNum = 3435;BA.debugLine="Dim str_Ft3 As String=\"(ثبت سریع)-\"&et_tozihat";
_str_ft3 = "(ثبت سریع)-"+mostCurrent._et_tozihat_ft.getText();
 //BA.debugLineNum = 3436;BA.debugLine="dbCode.edit_taradod(current_id_edit,lbl_date_F";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),_day_bt,_hour_bt,_min_bt,_str_ft3,(int) (11));
 };
 //BA.debugLineNum = 3439;BA.debugLine="Log(\"is secend\")";
anywheresoftware.b4a.keywords.Common.LogImpl("216121906","is secend",0);
 //BA.debugLineNum = 3440;BA.debugLine="ToastMessageShow(\"خروج ثبت شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خروج ثبت شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3443;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 };
 } 
       catch (Exception e33) {
			processBA.setLastException(e33); //BA.debugLineNum = 3452;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 3456;BA.debugLine="End Sub";
return "";
}
public static String  _add_taradod_sub() throws Exception{
int _dagige_fixed = 0;
String _saat_fixed = "";
String _str_tozih1 = "";
String _str_tozih2 = "";
anywheresoftware.b4a.objects.collections.List _ls_temp_time2 = null;
 //BA.debugLineNum = 1819;BA.debugLine="Sub add_taradod_sub";
 //BA.debugLineNum = 1820;BA.debugLine="Try";
try { //BA.debugLineNum = 1822;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 1823;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0 || _day_bt!=0)) { 
 //BA.debugLineNum = 1826;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0)) { 
 //BA.debugLineNum = 1828;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 1833;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1834;BA.debugLine="If(dbCode.isexist_taradod_by_date(date1)=True)";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1835;BA.debugLine="myfunc.help_man(\"برای این تاریخ تردد وجود دار";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"برای این تاریخ تردد وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید");
 }else {
 //BA.debugLineNum = 1838;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_ez";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1840;BA.debugLine="Dim dagige_fixed As Int = tim_vorod_conv_eza";
_dagige_fixed = _tim_vorod_conv_ezaf(mostCurrent._lbl_tim1.getText());
 //BA.debugLineNum = 1841;BA.debugLine="Dim saat_fixed As String = (myfunc.Min_to_sa";
_saat_fixed = BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_dagige_fixed).Get((int) (0))))+":"+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_dagige_fixed).Get((int) (1))));
 //BA.debugLineNum = 1843;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_t";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 1844;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 1846;BA.debugLine="dbCode.add_ezafekari(date1,date2,saat_fixed,";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,_saat_fixed,mostCurrent._lbl_tim2.getText(),_day_bt,(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (0))))),(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (1))))),_str_tozih1,(int) (0));
 //BA.debugLineNum = 1848;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_tozih2,(int) (0));
 }else {
 //BA.debugLineNum = 1850;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
 };
 //BA.debugLineNum = 1853;BA.debugLine="Dim ls_temp_time2 As List";
_ls_temp_time2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1854;BA.debugLine="ls_temp_time2.Initialize";
_ls_temp_time2.Initialize();
 //BA.debugLineNum = 1856;BA.debugLine="ls_temp_time2.Add(lbl_tim1.Text)";
_ls_temp_time2.Add((Object)(mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 1857;BA.debugLine="ls_temp_time2.Add(lbl_tim2.Text)";
_ls_temp_time2.Add((Object)(mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 1859;BA.debugLine="File.WriteList(File.DirInternal,\"temp_time2.t";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time2.txt",_ls_temp_time2);
 //BA.debugLineNum = 1861;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1862;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 1865;BA.debugLine="dbCode.edit_taradod(current_id_edit,date1,date";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
 //BA.debugLineNum = 1867;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1868;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 //BA.debugLineNum = 1869;BA.debugLine="TabHost1.CurrentTab=2";
mostCurrent._tabhost1.setCurrentTab((int) (2));
 };
 //BA.debugLineNum = 1873;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e40) {
			processBA.setLastException(e40); //BA.debugLineNum = 1878;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 1881;BA.debugLine="End Sub";
return "";
}
public static String  _auth_complete(boolean _success,String _errormessage) throws Exception{
 //BA.debugLineNum = 698;BA.debugLine="Sub Auth_Complete (Success As Boolean, ErrorMessag";
 //BA.debugLineNum = 699;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 700;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 701;BA.debugLine="tim_lock_lbl.Enabled=False";
_tim_lock_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 703;BA.debugLine="ToastMessageShow($\"Error: ${ErrorMessage}\"$, Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(("Error: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_errormessage))+"")),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 704;BA.debugLine="Log(ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("29306118",_errormessage,0);
 };
 //BA.debugLineNum = 706;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_gozaresh_click() throws Exception{
 //BA.debugLineNum = 1340;BA.debugLine="Private Sub btn_menu_gozaresh_Click";
 //BA.debugLineNum = 1341;BA.debugLine="index_page=3";
_index_page = (int) (3);
 //BA.debugLineNum = 1342;BA.debugLine="pan_imag.Background=img3";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img3.getObject()));
 //BA.debugLineNum = 1344;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
 //BA.debugLineNum = 1345;BA.debugLine="pan_main.LoadLayout(\"gozaresh_layout\")";
mostCurrent._pan_main.LoadLayout("gozaresh_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 1347;BA.debugLine="sp_year_gozaresh.Add(\"1401\")";
mostCurrent._sp_year_gozaresh.Add("1401");
 //BA.debugLineNum = 1348;BA.debugLine="sp_year_gozaresh.Add(\"1400\")";
mostCurrent._sp_year_gozaresh.Add("1400");
 //BA.debugLineNum = 1349;BA.debugLine="sp_year_gozaresh.Add(\"1399\")";
mostCurrent._sp_year_gozaresh.Add("1399");
 //BA.debugLineNum = 1350;BA.debugLine="sp_year_gozaresh.Add(\"1398\")";
mostCurrent._sp_year_gozaresh.Add("1398");
 //BA.debugLineNum = 1352;BA.debugLine="sp_year_gozaresh.SelectedIndex=0";
mostCurrent._sp_year_gozaresh.setSelectedIndex((int) (0));
 //BA.debugLineNum = 1357;BA.debugLine="pan_hed_gozaresh.Color=color4";
mostCurrent._pan_hed_gozaresh.setColor(_color4);
 //BA.debugLineNum = 1362;BA.debugLine="list_gozareshat_id.Initialize";
mostCurrent._list_gozareshat_id.Initialize();
 //BA.debugLineNum = 1365;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
 //BA.debugLineNum = 1367;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_home_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _list_ezafekari = null;
anywheresoftware.b4a.objects.collections.List _list_morakhasi = null;
anywheresoftware.b4a.objects.collections.List _list_color = null;
anywheresoftware.b4a.objects.collections.List _col = null;
anywheresoftware.b4a.objects.collections.List _col_font = null;
anywheresoftware.b4a.objects.drawable.GradientDrawable _dw = null;
int[] _clr = null;
 //BA.debugLineNum = 826;BA.debugLine="Private Sub btn_menu_home_Click";
 //BA.debugLineNum = 827;BA.debugLine="index_page=1";
_index_page = (int) (1);
 //BA.debugLineNum = 828;BA.debugLine="pan_imag.Background=img1";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img1.getObject()));
 //BA.debugLineNum = 830;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
 //BA.debugLineNum = 831;BA.debugLine="pan_main.LoadLayout(\"home_layout\")";
mostCurrent._pan_main.LoadLayout("home_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 832;BA.debugLine="scv_home_item.Panel.LoadLayout(\"home_item\")";
mostCurrent._scv_home_item.getPanel().LoadLayout("home_item",mostCurrent.activityBA);
 //BA.debugLineNum = 833;BA.debugLine="lbl_date_home.Text=myfunc.fa2en(persianDate.Persi";
mostCurrent._lbl_date_home.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianLongDate())));
 //BA.debugLineNum = 835;BA.debugLine="saat_kar_min =dbCode.get_setting_byName(\"saat_kar";
_saat_kar_min = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_darRoz")));
 //BA.debugLineNum = 837;BA.debugLine="If(saat_kar_min<18)Then";
if ((_saat_kar_min<18)) { 
 //BA.debugLineNum = 838;BA.debugLine="myfunc.help_man(\"لطفا ساعت کاری خود را تنظیم کنی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"لطفا ساعت کاری خود را تنظیم کنید");
 };
 //BA.debugLineNum = 841;BA.debugLine="Dim list_ezafekari As List";
_list_ezafekari = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 842;BA.debugLine="list_ezafekari.Initialize";
_list_ezafekari.Initialize();
 //BA.debugLineNum = 844;BA.debugLine="year_num=myfunc.fa2en(persianDate.PersianYear)";
_year_num = mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()));
 //BA.debugLineNum = 846;BA.debugLine="Select persianDate.PersianMonth";
switch (BA.switchObjectToInt(_persiandate.getPersianMonth(),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11),(int) (12))) {
case 0: {
 //BA.debugLineNum = 848;BA.debugLine="moon_num=\"01\"";
_moon_num = "01";
 break; }
case 1: {
 //BA.debugLineNum = 850;BA.debugLine="moon_num=\"02\"";
_moon_num = "02";
 break; }
case 2: {
 //BA.debugLineNum = 852;BA.debugLine="moon_num=\"03\"";
_moon_num = "03";
 break; }
case 3: {
 //BA.debugLineNum = 854;BA.debugLine="moon_num=\"04\"";
_moon_num = "04";
 break; }
case 4: {
 //BA.debugLineNum = 856;BA.debugLine="moon_num=\"05\"";
_moon_num = "05";
 break; }
case 5: {
 //BA.debugLineNum = 858;BA.debugLine="moon_num=\"06\"";
_moon_num = "06";
 break; }
case 6: {
 //BA.debugLineNum = 860;BA.debugLine="moon_num=\"07\"";
_moon_num = "07";
 break; }
case 7: {
 //BA.debugLineNum = 862;BA.debugLine="moon_num=\"08\"";
_moon_num = "08";
 break; }
case 8: {
 //BA.debugLineNum = 864;BA.debugLine="moon_num=\"09\"";
_moon_num = "09";
 break; }
case 9: {
 //BA.debugLineNum = 866;BA.debugLine="moon_num=\"10\"";
_moon_num = "10";
 break; }
case 10: {
 //BA.debugLineNum = 868;BA.debugLine="moon_num=\"11\"";
_moon_num = "11";
 break; }
case 11: {
 //BA.debugLineNum = 870;BA.debugLine="moon_num=\"12\"";
_moon_num = "12";
 break; }
}
;
 //BA.debugLineNum = 872;BA.debugLine="list_ezafekari=dbCode.all_ezafekari_mah(year_num,";
_list_ezafekari = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num,(int) (1));
 //BA.debugLineNum = 878;BA.debugLine="Dim list_morakhasi As List";
_list_morakhasi = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 879;BA.debugLine="list_morakhasi.Initialize";
_list_morakhasi.Initialize();
 //BA.debugLineNum = 881;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(year_num,";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num);
 //BA.debugLineNum = 884;BA.debugLine="lbl_ezafekari_mah_m.Text=list_ezafekari.Get(1)&\"";
mostCurrent._lbl_ezafekari_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (1)))+" دقیقه "));
 //BA.debugLineNum = 885;BA.debugLine="lbl_ezafekari_mah_h.Text=list_ezafekari.Get(0)&\"";
mostCurrent._lbl_ezafekari_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (0)))+" ساعت "));
 //BA.debugLineNum = 887;BA.debugLine="lbl_morakhasi_mah_m.Text=list_morakhasi.Get(2)&\"";
mostCurrent._lbl_morakhasi_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (2)))+" دقیقه "));
 //BA.debugLineNum = 888;BA.debugLine="lbl_morakhasi_mah_h.Text=list_morakhasi.Get(1)&\"";
mostCurrent._lbl_morakhasi_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (1)))+" ساعت "));
 //BA.debugLineNum = 889;BA.debugLine="lbl_morakhasi_mah_d.Text=list_morakhasi.Get(0)&\"";
mostCurrent._lbl_morakhasi_mah_d.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (0)))+" روز "));
 //BA.debugLineNum = 891;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 893;BA.debugLine="lbl_vip.TextColor=0xFFFFD800";
mostCurrent._lbl_vip.setTextColor(((int)0xffffd800));
 //BA.debugLineNum = 894;BA.debugLine="lbl_vip2.Text=\"نسخه طلایی\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه طلایی"));
 }else {
 //BA.debugLineNum = 897;BA.debugLine="lbl_vip.TextColor=Colors.Green";
mostCurrent._lbl_vip.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 898;BA.debugLine="lbl_vip2.Text=\"نسخه هدیه\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه هدیه"));
 };
 //BA.debugLineNum = 903;BA.debugLine="If (File.Exists(File.DirInternal,\"help_start\")=Fa";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 904;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 905;BA.debugLine="File.WriteString(File.DirInternal,\"help_start\",\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start","");
 };
 //BA.debugLineNum = 911;BA.debugLine="If (File.Exists(File.DirInternal,\"setcolor.txt\"))";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt"))) { 
 //BA.debugLineNum = 912;BA.debugLine="Dim list_color As List";
_list_color = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 913;BA.debugLine="list_color.Initialize";
_list_color.Initialize();
 //BA.debugLineNum = 914;BA.debugLine="list_color = File.ReadList(File.DirInternal,\"set";
_list_color = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt");
 //BA.debugLineNum = 916;BA.debugLine="Dim col As List";
_col = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 917;BA.debugLine="col.Initialize";
_col.Initialize();
 //BA.debugLineNum = 919;BA.debugLine="Dim col_font As List";
_col_font = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 920;BA.debugLine="col_font.Initialize";
_col_font.Initialize();
 //BA.debugLineNum = 922;BA.debugLine="col=Regex.Split(\",\",list_color.Get(0))";
_col = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (0)))));
 //BA.debugLineNum = 923;BA.debugLine="col_font=Regex.Split(\",\",list_color.Get(1))";
_col_font = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (1)))));
 //BA.debugLineNum = 927;BA.debugLine="color1= col.Get(0)";
_color1 = (int)(BA.ObjectToNumber(_col.Get((int) (0))));
 //BA.debugLineNum = 928;BA.debugLine="color2= col.Get(1)";
_color2 = (int)(BA.ObjectToNumber(_col.Get((int) (1))));
 //BA.debugLineNum = 929;BA.debugLine="color_index=col.Get(2)  'index color";
_color_index = (int)(BA.ObjectToNumber(_col.Get((int) (2))));
 //BA.debugLineNum = 930;BA.debugLine="color3= col.Get(3)";
_color3 = (int)(BA.ObjectToNumber(_col.Get((int) (3))));
 //BA.debugLineNum = 931;BA.debugLine="color4= col.Get(4)";
_color4 = (int)(BA.ObjectToNumber(_col.Get((int) (4))));
 //BA.debugLineNum = 932;BA.debugLine="color5= col.Get(5)";
_color5 = (int)(BA.ObjectToNumber(_col.Get((int) (5))));
 //BA.debugLineNum = 934;BA.debugLine="main_font=col_font.Get(0)";
_main_font = BA.ObjectToString(_col_font.Get((int) (0)));
 //BA.debugLineNum = 935;BA.debugLine="size_f1=col_font.Get(1)";
_size_f1 = (int)(BA.ObjectToNumber(_col_font.Get((int) (1))));
 //BA.debugLineNum = 936;BA.debugLine="size_f2=col_font.Get(2)";
_size_f2 = (int)(BA.ObjectToNumber(_col_font.Get((int) (2))));
 //BA.debugLineNum = 937;BA.debugLine="size_f3=col_font.Get(3)";
_size_f3 = (int)(BA.ObjectToNumber(_col_font.Get((int) (3))));
 }else {
 //BA.debugLineNum = 941;BA.debugLine="color_index=1";
_color_index = (int) (1);
 //BA.debugLineNum = 942;BA.debugLine="color1= 0XFF69AC00";
_color1 = ((int)0xff69ac00);
 //BA.debugLineNum = 943;BA.debugLine="color2= 0xFF00C7C7";
_color2 = ((int)0xff00c7c7);
 //BA.debugLineNum = 944;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 945;BA.debugLine="color4=0XFF69AC00";
_color4 = ((int)0xff69ac00);
 //BA.debugLineNum = 946;BA.debugLine="color5=0XFF69AC00";
_color5 = ((int)0xff69ac00);
 //BA.debugLineNum = 948;BA.debugLine="main_font=\"یکان\"";
_main_font = "یکان";
 //BA.debugLineNum = 949;BA.debugLine="size_f1=17";
_size_f1 = (int) (17);
 //BA.debugLineNum = 950;BA.debugLine="size_f2=15";
_size_f2 = (int) (15);
 //BA.debugLineNum = 951;BA.debugLine="size_f3=13";
_size_f3 = (int) (13);
 //BA.debugLineNum = 954;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(_color1)+","+BA.NumberToString(_color2)+","+BA.NumberToString(_color_index)+","+BA.NumberToString(_color3)+","+BA.NumberToString(_color4)+","+BA.NumberToString(_color5)+anywheresoftware.b4a.keywords.Common.CRLF+_main_font+","+BA.NumberToString(_size_f1)+","+BA.NumberToString(_size_f2)+","+BA.NumberToString(_size_f3));
 };
 //BA.debugLineNum = 962;BA.debugLine="Dim dw As GradientDrawable";
_dw = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
 //BA.debugLineNum = 963;BA.debugLine="Dim clr() As Int = Array  As Int(color1,color2)";
_clr = new int[]{_color1,_color2};
 //BA.debugLineNum = 964;BA.debugLine="dw.Initialize(\"TOP_BOTTOM\",clr)";
_dw.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clr);
 //BA.debugLineNum = 965;BA.debugLine="dw.CornerRadius=50dip";
_dw.setCornerRadius((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))));
 //BA.debugLineNum = 966;BA.debugLine="Panel1.Background=dw";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_dw.getObject()));
 //BA.debugLineNum = 974;BA.debugLine="lbl_box_title.Color=color4";
mostCurrent._lbl_box_title.setColor(_color4);
 //BA.debugLineNum = 983;BA.debugLine="get_today_shift";
_get_today_shift();
 //BA.debugLineNum = 986;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 994;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_list_click() throws Exception{
 //BA.debugLineNum = 1031;BA.debugLine="Private Sub btn_menu_list_Click";
 //BA.debugLineNum = 1032;BA.debugLine="index_page=2";
_index_page = (int) (2);
 //BA.debugLineNum = 1033;BA.debugLine="pan_imag.Background=img2";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img2.getObject()));
 //BA.debugLineNum = 1035;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
 //BA.debugLineNum = 1036;BA.debugLine="pan_main.LoadLayout(\"list_layout\")";
mostCurrent._pan_main.LoadLayout("list_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 1039;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
 //BA.debugLineNum = 1040;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
 //BA.debugLineNum = 1041;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
 //BA.debugLineNum = 1042;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
 //BA.debugLineNum = 1044;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
 //BA.debugLineNum = 1047;BA.debugLine="sp_year.SelectedIndex=0";
mostCurrent._sp_year.setSelectedIndex((int) (0));
 //BA.debugLineNum = 1048;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(persianDate.Pe";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))))-1));
 //BA.debugLineNum = 1050;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 1051;BA.debugLine="Select sp_moon.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_moon.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11))) {
case 0: {
 //BA.debugLineNum = 1053;BA.debugLine="moon_num=\"01\"";
_moon_num = "01";
 break; }
case 1: {
 //BA.debugLineNum = 1055;BA.debugLine="moon_num=\"02\"";
_moon_num = "02";
 break; }
case 2: {
 //BA.debugLineNum = 1057;BA.debugLine="moon_num=\"03\"";
_moon_num = "03";
 break; }
case 3: {
 //BA.debugLineNum = 1059;BA.debugLine="moon_num=\"04\"";
_moon_num = "04";
 break; }
case 4: {
 //BA.debugLineNum = 1061;BA.debugLine="moon_num=\"05\"";
_moon_num = "05";
 break; }
case 5: {
 //BA.debugLineNum = 1063;BA.debugLine="moon_num=\"06\"";
_moon_num = "06";
 break; }
case 6: {
 //BA.debugLineNum = 1065;BA.debugLine="moon_num=\"07\"";
_moon_num = "07";
 break; }
case 7: {
 //BA.debugLineNum = 1067;BA.debugLine="moon_num=\"08\"";
_moon_num = "08";
 break; }
case 8: {
 //BA.debugLineNum = 1069;BA.debugLine="moon_num=\"09\"";
_moon_num = "09";
 break; }
case 9: {
 //BA.debugLineNum = 1071;BA.debugLine="moon_num=\"10\"";
_moon_num = "10";
 break; }
case 10: {
 //BA.debugLineNum = 1073;BA.debugLine="moon_num=\"11\"";
_moon_num = "11";
 break; }
case 11: {
 //BA.debugLineNum = 1075;BA.debugLine="moon_num=\"12\"";
_moon_num = "12";
 break; }
}
;
 //BA.debugLineNum = 1079;BA.debugLine="TabHost1.AddTab(\"اضافه کاری ها\" , \"tab_layout_eza";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"اضافه کاری ها","tab_layout_ezafekari.bal");
 //BA.debugLineNum = 1080;BA.debugLine="TabHost1.AddTab(\" مرخصی ها\" , \"tab_layout_morakha";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA," مرخصی ها","tab_layout_morakhasi.bal");
 //BA.debugLineNum = 1081;BA.debugLine="TabHost1.AddTab(\" تردد ها\" , \"tab_layout_taradod.";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA," تردد ها","tab_layout_taradod.bal");
 //BA.debugLineNum = 1084;BA.debugLine="TabHost1.CurrentTab=curent_tab_list";
mostCurrent._tabhost1.setCurrentTab(_curent_tab_list);
 //BA.debugLineNum = 1086;BA.debugLine="list_ezafekari_id.Initialize";
mostCurrent._list_ezafekari_id.Initialize();
 //BA.debugLineNum = 1089;BA.debugLine="list_morakhasi_id.Initialize";
mostCurrent._list_morakhasi_id.Initialize();
 //BA.debugLineNum = 1092;BA.debugLine="list_taradod_id.Initialize";
mostCurrent._list_taradod_id.Initialize();
 //BA.debugLineNum = 1096;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
 //BA.debugLineNum = 1100;BA.debugLine="pan_hed_list.Color=color4";
mostCurrent._pan_hed_list.setColor(_color4);
 //BA.debugLineNum = 1107;BA.debugLine="End Sub";
return "";
}
public static String  _btneight_click() throws Exception{
 //BA.debugLineNum = 741;BA.debugLine="Sub btnEight_Click";
 //BA.debugLineNum = 742;BA.debugLine="click_count_Increment_and_fill(btnEight.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btneight.getText());
 //BA.debugLineNum = 743;BA.debugLine="End Sub";
return "";
}
public static String  _btnfive_click() throws Exception{
 //BA.debugLineNum = 729;BA.debugLine="Sub btnFive_Click";
 //BA.debugLineNum = 730;BA.debugLine="click_count_Increment_and_fill(btnFive.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnfive.getText());
 //BA.debugLineNum = 731;BA.debugLine="End Sub";
return "";
}
public static String  _btnfour_click() throws Exception{
 //BA.debugLineNum = 725;BA.debugLine="Sub btnFour_Click";
 //BA.debugLineNum = 726;BA.debugLine="click_count_Increment_and_fill(btnFour.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnfour.getText());
 //BA.debugLineNum = 727;BA.debugLine="End Sub";
return "";
}
public static String  _btnnine_click() throws Exception{
 //BA.debugLineNum = 745;BA.debugLine="Sub btnNine_Click";
 //BA.debugLineNum = 746;BA.debugLine="click_count_Increment_and_fill(btnNine.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnnine.getText());
 //BA.debugLineNum = 747;BA.debugLine="End Sub";
return "";
}
public static String  _btnone_click() throws Exception{
 //BA.debugLineNum = 713;BA.debugLine="Sub btnOne_Click";
 //BA.debugLineNum = 714;BA.debugLine="click_count_Increment_and_fill(btnOne.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btnone.getText());
 //BA.debugLineNum = 715;BA.debugLine="End Sub";
return "";
}
public static String  _btnseven_click() throws Exception{
 //BA.debugLineNum = 737;BA.debugLine="Sub btnSeven_Click";
 //BA.debugLineNum = 738;BA.debugLine="click_count_Increment_and_fill(btnSeven.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btnseven.getText());
 //BA.debugLineNum = 739;BA.debugLine="End Sub";
return "";
}
public static String  _btnsix_click() throws Exception{
 //BA.debugLineNum = 733;BA.debugLine="Sub btnSix_Click";
 //BA.debugLineNum = 734;BA.debugLine="click_count_Increment_and_fill(btnSix.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btnsix.getText());
 //BA.debugLineNum = 735;BA.debugLine="End Sub";
return "";
}
public static String  _btnthree_click() throws Exception{
 //BA.debugLineNum = 721;BA.debugLine="Sub btnThree_Click";
 //BA.debugLineNum = 722;BA.debugLine="click_count_Increment_and_fill(btnThree.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btnthree.getText());
 //BA.debugLineNum = 723;BA.debugLine="End Sub";
return "";
}
public static String  _btntwo_click() throws Exception{
 //BA.debugLineNum = 717;BA.debugLine="Sub btnTwo_Click";
 //BA.debugLineNum = 718;BA.debugLine="click_count_Increment_and_fill(btnTwo.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btntwo.getText());
 //BA.debugLineNum = 719;BA.debugLine="End Sub";
return "";
}
public static String  _btnzero_click() throws Exception{
 //BA.debugLineNum = 709;BA.debugLine="Sub btnZero_Click";
 //BA.debugLineNum = 710;BA.debugLine="click_count_Increment_and_fill(btnZero.Text)";
_click_count_increment_and_fill(mostCurrent._btnzero.getText());
 //BA.debugLineNum = 711;BA.debugLine="End Sub";
return "";
}
public static String  _click_count_increment_and_fill(String _input_text) throws Exception{
 //BA.debugLineNum = 749;BA.debugLine="Sub click_count_Increment_and_fill (input_Text As";
 //BA.debugLineNum = 751;BA.debugLine="Click_Count = Click_Count + 1";
_click_count = (int) (_click_count+1);
 //BA.debugLineNum = 753;BA.debugLine="Select Click_Count";
switch (_click_count) {
case 1: {
 //BA.debugLineNum = 755;BA.debugLine="key1.Color = Colors.Red";
mostCurrent._key1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 758;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 2: {
 //BA.debugLineNum = 761;BA.debugLine="key2.Color = Colors.Red";
mostCurrent._key2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 764;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 3: {
 //BA.debugLineNum = 767;BA.debugLine="key3.Color = Colors.Red";
mostCurrent._key3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 770;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 4: {
 //BA.debugLineNum = 773;BA.debugLine="key4.Color = Colors.Red";
mostCurrent._key4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 776;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 //BA.debugLineNum = 782;BA.debugLine="If entered_Password = Master_Password Then";
if ((mostCurrent._entered_password).equals(mostCurrent._master_password)) { 
 //BA.debugLineNum = 785;BA.debugLine="resetting_all";
_resetting_all();
 //BA.debugLineNum = 787;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 789;BA.debugLine="ToastMessageShow(\"رمز عبور اشتباه است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("رمز عبور اشتباه است"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 793;BA.debugLine="resetting_all";
_resetting_all();
 };
 break; }
}
;
 //BA.debugLineNum = 798;BA.debugLine="End Sub";
return "";
}
public static String  _cust_lv_taradod_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 3192;BA.debugLine="Private Sub cust_LV_taradod_ItemClick (Index As In";
 //BA.debugLineNum = 3194;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_gozareshat(String _year1) throws Exception{
 //BA.debugLineNum = 1369;BA.debugLine="Sub fill_list_gozareshat(year1 As String)";
 //BA.debugLineNum = 1370;BA.debugLine="CLV_gozaresh.Clear";
mostCurrent._clv_gozaresh._clear();
 //BA.debugLineNum = 1371;BA.debugLine="list_gozareshat_id.Clear";
mostCurrent._list_gozareshat_id.Clear();
 //BA.debugLineNum = 1373;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1374;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ORDER BY  id DESC;")));
 //BA.debugLineNum = 1375;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1378;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
mostCurrent._p = _xui.CreatePanel(processBA,"");
 //BA.debugLineNum = 1379;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 96%x, 114dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (114)));
 //BA.debugLineNum = 1380;BA.debugLine="p.LoadLayout(\"item_list_2\")";
mostCurrent._p.LoadLayout("item_list_2",mostCurrent.activityBA);
 //BA.debugLineNum = 1382;BA.debugLine="CLV_gozaresh.Add(p,dbCode.res.GetString(\"id\"))";
mostCurrent._clv_gozaresh._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1383;BA.debugLine="lbl_dateGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_dategozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date")));
 //BA.debugLineNum = 1384;BA.debugLine="lbl_nameGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_namegozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title")));
 //BA.debugLineNum = 1385;BA.debugLine="lbl_tozihGozaresh_CLV.Text=dbCode.res.GetString(";
mostCurrent._lbl_tozihgozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozih")));
 //BA.debugLineNum = 1386;BA.debugLine="lbl_remove_from_list2.Tag=dbCode.res.GetString(\"";
mostCurrent._lbl_remove_from_list2.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1387;BA.debugLine="pan_item_gozaresh.Tag=dbCode.res.GetString(\"id\")";
mostCurrent._pan_item_gozaresh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1388;BA.debugLine="list_gozareshat_id.Add(dbCode.res.GetString(\"id\"";
mostCurrent._list_gozareshat_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1389;BA.debugLine="Log(dbCode.res.GetString(\"id\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("210551316",mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id"),0);
 }
;
 //BA.debugLineNum = 1391;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1392;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1394;BA.debugLine="End Sub";
return "";
}
public static String  _fill_lists(String _year1,String _moon1) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _str1 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _str2 = null;
anywheresoftware.b4a.objects.B4XViewWrapper _p2 = null;
 //BA.debugLineNum = 1150;BA.debugLine="Sub fill_lists (year1 As String, moon1 As String)";
 //BA.debugLineNum = 1154;BA.debugLine="cust_LV_ezafekari.Clear";
mostCurrent._cust_lv_ezafekari._clear();
 //BA.debugLineNum = 1155;BA.debugLine="list_ezafekari_id.Clear";
mostCurrent._list_ezafekari_id.Clear();
 //BA.debugLineNum = 1157;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1158;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  id DESC;")));
 //BA.debugLineNum = 1159;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1160;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1161;BA.debugLine="str1.Initialize";
_str1.Initialize();
 //BA.debugLineNum = 1162;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")).equals(BA.NumberToString(0)) == false)) { 
 //BA.debugLineNum = 1163;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")+" روز ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 //BA.debugLineNum = 1165;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")+" ساعت ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 1166;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m")+" دقیقه ");
 //BA.debugLineNum = 1170;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = _xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1171;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 134dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (134)));
 //BA.debugLineNum = 1172;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
 //BA.debugLineNum = 1174;BA.debugLine="cust_LV_ezafekari.Add(p,dbCode.res.GetString(\"id";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1175;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
 //BA.debugLineNum = 1176;BA.debugLine="lbl_hour_CLV.Text=dbCode.res.GetString(\"time_fro";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
 //BA.debugLineNum = 1177;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str1.ToString()));
 //BA.debugLineNum = 1178;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 1179;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1180;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1182;BA.debugLine="list_ezafekari_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_ezafekari_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
 //BA.debugLineNum = 1187;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1188;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1190;BA.debugLine="If(cust_LV_ezafekari.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_ezafekari._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 1191;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = _xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1192;BA.debugLine="Select cust_LV_ezafekari.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_ezafekari._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 1194;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
 //BA.debugLineNum = 1196;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 1198;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 1200;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 1202;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 1204;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 1206;BA.debugLine="cust_LV_ezafekari.Add(p,\"\")";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(""));
 };
 //BA.debugLineNum = 1210;BA.debugLine="cust_LV_morakhasi.Clear";
mostCurrent._cust_lv_morakhasi._clear();
 //BA.debugLineNum = 1211;BA.debugLine="list_morakhasi_id.Clear";
mostCurrent._list_morakhasi_id.Clear();
 //BA.debugLineNum = 1213;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1214;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  id DESC;")));
 //BA.debugLineNum = 1215;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1216;BA.debugLine="Dim str2 As StringBuilder";
_str2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1217;BA.debugLine="str2.Initialize";
_str2.Initialize();
 //BA.debugLineNum = 1218;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")).equals(BA.NumberToString(0)) == false)) { 
 //BA.debugLineNum = 1219;BA.debugLine="str2.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
_str2.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")+" روز ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 //BA.debugLineNum = 1221;BA.debugLine="str2.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
_str2.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")+" ساعت ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 1222;BA.debugLine="str2.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
_str2.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m")+" دقیقه ");
 //BA.debugLineNum = 1226;BA.debugLine="Dim p2 As B4XView = xui.CreatePanel(\"\")";
_p2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p2 = _xui.CreatePanel(processBA,"");
 //BA.debugLineNum = 1227;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 134dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (134)));
 //BA.debugLineNum = 1228;BA.debugLine="p2.LoadLayout(\"item_list\")";
_p2.LoadLayout("item_list",mostCurrent.activityBA);
 //BA.debugLineNum = 1230;BA.debugLine="cust_LV_morakhasi.Add(p2,dbCode.res.GetString(\"i";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1231;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
 //BA.debugLineNum = 1232;BA.debugLine="lbl_hour_CLV.Text=dbCode.res.GetString(\"time_fro";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
 //BA.debugLineNum = 1233;BA.debugLine="lbl_time_CLV.Text=str2.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str2.ToString()));
 //BA.debugLineNum = 1234;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 1235;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1236;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1238;BA.debugLine="list_morakhasi_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_morakhasi_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
 //BA.debugLineNum = 1243;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1244;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1250;BA.debugLine="If(cust_LV_morakhasi.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_morakhasi._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 1251;BA.debugLine="p2 = xui.CreatePanel(\"p\")";
_p2 = _xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1252;BA.debugLine="Select cust_LV_morakhasi.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_morakhasi._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 1254;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
 //BA.debugLineNum = 1256;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 1258;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 1260;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 1262;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 1264;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 1266;BA.debugLine="cust_LV_morakhasi.Add(p2,\"\")";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(""));
 };
 //BA.debugLineNum = 1271;BA.debugLine="cust_LV_taradod.Clear";
mostCurrent._cust_lv_taradod._clear();
 //BA.debugLineNum = 1272;BA.debugLine="list_taradod_id.Clear";
mostCurrent._list_taradod_id.Clear();
 //BA.debugLineNum = 1274;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1275;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  id DESC;")));
 //BA.debugLineNum = 1276;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1277;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1278;BA.debugLine="str1.Initialize";
_str1.Initialize();
 //BA.debugLineNum = 1279;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")).equals(BA.NumberToString(0)) == false)) { 
 //BA.debugLineNum = 1280;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")+" روز ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 //BA.debugLineNum = 1282;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")+" ساعت ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 1283;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m")+" دقیقه ");
 //BA.debugLineNum = 1287;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = _xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1288;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 134dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (134)));
 //BA.debugLineNum = 1289;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
 //BA.debugLineNum = 1291;BA.debugLine="cust_LV_taradod.Add(p,dbCode.res.GetString(\"id\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1292;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
 //BA.debugLineNum = 1293;BA.debugLine="lbl_hour_CLV.Text=\" ورود : \"&dbCode.res.GetStrin";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence(" ورود : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" -- "+" خروج : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
 //BA.debugLineNum = 1295;BA.debugLine="lbl_time_CLV.Typeface=Typeface.MATERIALICONS";
mostCurrent._lbl_time_clv.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
 //BA.debugLineNum = 1296;BA.debugLine="lbl_time_CLV.Text=Chr(0xE8D5)";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe8d5))));
 //BA.debugLineNum = 1297;BA.debugLine="lbl_time_CLV.TextSize=25";
mostCurrent._lbl_time_clv.setTextSize((float) (25));
 //BA.debugLineNum = 1299;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 1300;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1301;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1303;BA.debugLine="list_taradod_id.Add(dbCode.res.GetString(\"id\"))";
mostCurrent._list_taradod_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
 //BA.debugLineNum = 1308;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1309;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1311;BA.debugLine="If(cust_LV_taradod.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_taradod._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 1312;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = _xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1313;BA.debugLine="Select cust_LV_taradod.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_taradod._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 1315;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
 //BA.debugLineNum = 1317;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 1319;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 1321;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 1323;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 1325;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 1327;BA.debugLine="cust_LV_taradod.Add(p,\"\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(""));
 };
 //BA.debugLineNum = 1333;BA.debugLine="End Sub";
return "";
}
public static String  _finger_scaning() throws Exception{
 //BA.debugLineNum = 693;BA.debugLine="Sub finger_scaning";
 //BA.debugLineNum = 694;BA.debugLine="fingerprint.Authenticate";
mostCurrent._fingerprint._authenticate /*String*/ ();
 //BA.debugLineNum = 695;BA.debugLine="ToastMessageShow(\"Scanning...\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Scanning..."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 696;BA.debugLine="End Sub";
return "";
}
public static String  _get_dataedit_byid(int _id1) throws Exception{
 //BA.debugLineNum = 2990;BA.debugLine="Sub get_dataEdit_byId(id1 As Int)";
 //BA.debugLineNum = 2991;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 2992;BA.debugLine="If(index_box=1)Then";
if ((_index_box==1)) { 
 //BA.debugLineNum = 2993;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE id="+BA.NumberToString(_id1))));
 //BA.debugLineNum = 2994;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 2996;BA.debugLine="If(dbCode.res.GetInt(\"state\")=0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==0)) { 
 //BA.debugLineNum = 2997;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 2999;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
 }else if((_index_box==2)) { 
 //BA.debugLineNum = 3005;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE id="+BA.NumberToString(_id1))));
 //BA.debugLineNum = 3006;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 3009;BA.debugLine="Select dbCode.res.GetInt(\"state\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
 //BA.debugLineNum = 3011;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
 //BA.debugLineNum = 3013;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
 //BA.debugLineNum = 3015;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
 //BA.debugLineNum = 3017;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
 //BA.debugLineNum = 3021;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
 //BA.debugLineNum = 3022;BA.debugLine="index_noe_morakhasi=dbCode.res.GetInt(\"state\")";
_index_noe_morakhasi = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state");
 }else if((_index_box==3)) { 
 //BA.debugLineNum = 3027;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE id="+BA.NumberToString(_id1))));
 //BA.debugLineNum = 3028;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 };
 //BA.debugLineNum = 3035;BA.debugLine="lbl_tim1.Text=dbCode.res.GetString(\"time_from\")";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")));
 //BA.debugLineNum = 3036;BA.debugLine="lbl_tim2.Text=dbCode.res.GetString(\"time_to\")";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
 //BA.debugLineNum = 3038;BA.debugLine="lbl_date1.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
 //BA.debugLineNum = 3039;BA.debugLine="lbl_date2.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))));
 //BA.debugLineNum = 3041;BA.debugLine="et_tozihat.Text=dbCode.res.GetString(\"tozihat\")";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 3044;BA.debugLine="End Sub";
return "";
}
public static String  _get_today_shift() throws Exception{
int _id_today = 0;
String _str_sh = "";
 //BA.debugLineNum = 998;BA.debugLine="Sub get_today_shift";
 //BA.debugLineNum = 999;BA.debugLine="Dim id_today As Int";
_id_today = 0;
 //BA.debugLineNum = 1000;BA.debugLine="id_today=dbCode.get_day_id(persianDate.PersianYea";
_id_today = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_persiandate.getPersianYear(),_persiandate.getPersianMonth(),_persiandate.getPersianDay());
 //BA.debugLineNum = 1002;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1003;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id_today))));
 //BA.debugLineNum = 1005;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 1009;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")).equals("") == false)) { 
 //BA.debugLineNum = 1010;BA.debugLine="Dim str_sh As String";
_str_sh = "";
 //BA.debugLineNum = 1011;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift"),"ر","ش","ع","ا")) {
case 0: {
 //BA.debugLineNum = 1013;BA.debugLine="str_sh=\"روزکار\"";
_str_sh = "روزکار";
 break; }
case 1: {
 //BA.debugLineNum = 1015;BA.debugLine="str_sh=\"شبکار\"";
_str_sh = "شبکار";
 break; }
case 2: {
 //BA.debugLineNum = 1017;BA.debugLine="str_sh=\"عصرکار\"";
_str_sh = "عصرکار";
 break; }
case 3: {
 //BA.debugLineNum = 1019;BA.debugLine="str_sh=\"استراحت\"";
_str_sh = "استراحت";
 break; }
}
;
 //BA.debugLineNum = 1021;BA.debugLine="lbl_shift_home.Text=\"(\"&str_sh&\")\"";
mostCurrent._lbl_shift_home.setText(BA.ObjectToCharSequence("("+_str_sh+")"));
 };
 //BA.debugLineNum = 1026;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 58;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 62;BA.debugLine="Dim xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 64;BA.debugLine="Private lbl_date_home As Label";
mostCurrent._lbl_date_home = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 67;BA.debugLine="Private pan_all As Panel";
mostCurrent._pan_all = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 68;BA.debugLine="Private lbl_box_title As Label";
mostCurrent._lbl_box_title = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 73;BA.debugLine="Dim index_box As Int";
_index_box = 0;
 //BA.debugLineNum = 74;BA.debugLine="Dim year_bt As Int =0";
_year_bt = (int) (0);
 //BA.debugLineNum = 75;BA.debugLine="Dim moon_bt As Int =0";
_moon_bt = (int) (0);
 //BA.debugLineNum = 76;BA.debugLine="Dim day_bt As Int =0";
_day_bt = (int) (0);
 //BA.debugLineNum = 77;BA.debugLine="Dim hour_bt As Int =0";
_hour_bt = (int) (0);
 //BA.debugLineNum = 78;BA.debugLine="Dim min_bt As Int =0";
_min_bt = (int) (0);
 //BA.debugLineNum = 79;BA.debugLine="Dim num As Int=0  '' for time picker";
_num = (int) (0);
 //BA.debugLineNum = 80;BA.debugLine="Dim moon As List  '' for date picker";
mostCurrent._moon = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 82;BA.debugLine="Dim date1 As String";
mostCurrent._date1 = "";
 //BA.debugLineNum = 83;BA.debugLine="Dim date2 As String";
mostCurrent._date2 = "";
 //BA.debugLineNum = 85;BA.debugLine="Dim list_ezafekari_id As List";
mostCurrent._list_ezafekari_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 86;BA.debugLine="Dim list_morakhasi_id As List";
mostCurrent._list_morakhasi_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 87;BA.debugLine="Dim list_taradod_id As List";
mostCurrent._list_taradod_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 88;BA.debugLine="Dim list_gozareshat_id As List";
mostCurrent._list_gozareshat_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 91;BA.debugLine="Dim curent_tab_list As Int =0";
_curent_tab_list = (int) (0);
 //BA.debugLineNum = 94;BA.debugLine="Private pan_main As Panel";
mostCurrent._pan_main = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 95;BA.debugLine="Private pan_imag As Panel";
mostCurrent._pan_imag = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 98;BA.debugLine="Private TabHost1 As TabHost";
mostCurrent._tabhost1 = new anywheresoftware.b4a.objects.TabHostWrapper();
 //BA.debugLineNum = 102;BA.debugLine="Dim img1 As BitmapDrawable";
mostCurrent._img1 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 103;BA.debugLine="Dim img2 As BitmapDrawable";
mostCurrent._img2 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 104;BA.debugLine="Dim img3 As BitmapDrawable";
mostCurrent._img3 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 108;BA.debugLine="Dim index_page As Int";
_index_page = 0;
 //BA.debugLineNum = 109;BA.debugLine="Dim index_piker As Int";
_index_piker = 0;
 //BA.debugLineNum = 112;BA.debugLine="Private lbl_time_show As Label";
mostCurrent._lbl_time_show = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 113;BA.debugLine="Private pik_min1 As Label";
mostCurrent._pik_min1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 114;BA.debugLine="Private pik_hour1 As Label";
mostCurrent._pik_hour1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 118;BA.debugLine="Private pik_day1 As Label";
mostCurrent._pik_day1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 119;BA.debugLine="Private pik_year1 As Label";
mostCurrent._pik_year1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 120;BA.debugLine="Private pik_moon1 As Label";
mostCurrent._pik_moon1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 122;BA.debugLine="Private sp_moon As Spinner";
mostCurrent._sp_moon = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 123;BA.debugLine="Private sp_year As Spinner";
mostCurrent._sp_year = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 124;BA.debugLine="Private et_tozihat As EditText";
mostCurrent._et_tozihat = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 125;BA.debugLine="Private scv_home_item As ScrollView";
mostCurrent._scv_home_item = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 126;BA.debugLine="Private lbl_tim1 As Label";
mostCurrent._lbl_tim1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 127;BA.debugLine="Private lbl_date1 As Label";
mostCurrent._lbl_date1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 128;BA.debugLine="Private lbl_date2 As Label";
mostCurrent._lbl_date2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 129;BA.debugLine="Private lbl_tim2 As Label";
mostCurrent._lbl_tim2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 130;BA.debugLine="Private pan_picker As Panel";
mostCurrent._pan_picker = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 131;BA.debugLine="Private pan_all2 As Panel";
mostCurrent._pan_all2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 134;BA.debugLine="Dim strfun As StringFunctions";
mostCurrent._strfun = new adr.stringfunctions.stringfunctions();
 //BA.debugLineNum = 136;BA.debugLine="Private cust_LV_ezafekari As CustomListView";
mostCurrent._cust_lv_ezafekari = new b4a.example3.customlistview();
 //BA.debugLineNum = 137;BA.debugLine="Private lbl_date_CLV As Label";
mostCurrent._lbl_date_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 138;BA.debugLine="Private lbl_time_CLV As Label";
mostCurrent._lbl_time_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 139;BA.debugLine="Private lbl_hour_CLV As Label";
mostCurrent._lbl_hour_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 140;BA.debugLine="Private lbl_tozih_CLV As Label";
mostCurrent._lbl_tozih_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 141;BA.debugLine="Private cust_LV_morakhasi As CustomListView";
mostCurrent._cust_lv_morakhasi = new b4a.example3.customlistview();
 //BA.debugLineNum = 142;BA.debugLine="Private CLV_gozaresh As CustomListView";
mostCurrent._clv_gozaresh = new b4a.example3.customlistview();
 //BA.debugLineNum = 143;BA.debugLine="Private lbl_dateGozaresh_CLV As Label";
mostCurrent._lbl_dategozaresh_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 144;BA.debugLine="Private lbl_nameGozaresh_CLV As Label";
mostCurrent._lbl_namegozaresh_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 145;BA.debugLine="Private lbl_tozihGozaresh_CLV As Label";
mostCurrent._lbl_tozihgozaresh_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 146;BA.debugLine="Private lbl_ezafekari_mah_m As Label";
mostCurrent._lbl_ezafekari_mah_m = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 147;BA.debugLine="Private lbl_ezafekari_mah_h As Label";
mostCurrent._lbl_ezafekari_mah_h = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 148;BA.debugLine="Private lbl_morakhasi_mah_m As Label";
mostCurrent._lbl_morakhasi_mah_m = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 149;BA.debugLine="Private lbl_morakhasi_mah_h As Label";
mostCurrent._lbl_morakhasi_mah_h = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 150;BA.debugLine="Private lbl_morakhasi_mah_d As Label";
mostCurrent._lbl_morakhasi_mah_d = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 156;BA.debugLine="Dim p As B4XView";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 159;BA.debugLine="Dim key As String= \"MIHNMA0GCSqGSIb3DQEBAQUAA4G7A";
mostCurrent._key = "MIHNMA0GCSqGSIb3DQEBAQUAA4G7ADCBtwKBrwDZmEdlPq6691EaSKn8zBkr1hyrYE3RPU4xYwuVh69GnEP3HIKQhrEYqti4EL5re8GJS4itFD5nfbmy+U67aqJcl9zcWWpRIBtQN9wYZF8vZ1Ooz/8h2V4hjiVjRZ9MO/o68voESDIpdYTsj4yyapRRZe9iLosW7lH3ZCHStJFWZQiC0WyJ69HYB3v94DchwDd1EE2HNJwcGR/x4okAI5AFLrfIsMgQAyy32Rl6t8UCAwEAAQ==";
 //BA.debugLineNum = 162;BA.debugLine="Dim inapp As BillingManager3";
mostCurrent._inapp = new anywheresoftware.b4a.inappbilling3.BillingManager3();
 //BA.debugLineNum = 163;BA.debugLine="Private lbl_vip As Label";
mostCurrent._lbl_vip = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 165;BA.debugLine="Private img_help As ImageView";
mostCurrent._img_help = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 166;BA.debugLine="Dim index_x_start_swap As Int=0";
_index_x_start_swap = (int) (0);
 //BA.debugLineNum = 167;BA.debugLine="Dim index_curent_img As Int=1";
_index_curent_img = (int) (1);
 //BA.debugLineNum = 168;BA.debugLine="Private pan_help As Panel";
mostCurrent._pan_help = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 169;BA.debugLine="Private lbl_remove_from_list As Label";
mostCurrent._lbl_remove_from_list = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 170;BA.debugLine="Private lbl_remove_from_list2 As Label";
mostCurrent._lbl_remove_from_list2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 172;BA.debugLine="Private cv_loader As B4XLoadingIndicator";
mostCurrent._cv_loader = new ir.taravatgroup.ezafekari2.b4xloadingindicator();
 //BA.debugLineNum = 173;BA.debugLine="Private lbl_vip2 As Label";
mostCurrent._lbl_vip2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 174;BA.debugLine="Private lbl_show_vip As Label";
mostCurrent._lbl_show_vip = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 175;BA.debugLine="Private lbl_vip_now As Label";
mostCurrent._lbl_vip_now = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 176;BA.debugLine="Private pan_all_noskhe As Panel";
mostCurrent._pan_all_noskhe = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 179;BA.debugLine="Private pik_min_bala1 As Label";
mostCurrent._pik_min_bala1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 180;BA.debugLine="Private pik_hour_bala1 As Label";
mostCurrent._pik_hour_bala1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 181;BA.debugLine="Private pik_min_paeen1 As Label";
mostCurrent._pik_min_paeen1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 182;BA.debugLine="Private pik_hour_paeen1 As Label";
mostCurrent._pik_hour_paeen1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 183;BA.debugLine="Private scroll_v_noskhe As ScrollView";
mostCurrent._scroll_v_noskhe = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 186;BA.debugLine="Dim bit_img0 As Bitmap";
mostCurrent._bit_img0 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 187;BA.debugLine="Dim bit_img1 As Bitmap";
mostCurrent._bit_img1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 188;BA.debugLine="Dim bit_img2 As Bitmap";
mostCurrent._bit_img2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 189;BA.debugLine="Dim bit_img3 As Bitmap";
mostCurrent._bit_img3 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 190;BA.debugLine="Dim bit_img4 As Bitmap";
mostCurrent._bit_img4 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 193;BA.debugLine="Private lbl_close_help As Label";
mostCurrent._lbl_close_help = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 194;BA.debugLine="Private lbl_time_as As Label";
mostCurrent._lbl_time_as = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 195;BA.debugLine="Private lbl_time_ta As Label";
mostCurrent._lbl_time_ta = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 196;BA.debugLine="Private cust_LV_taradod As CustomListView";
mostCurrent._cust_lv_taradod = new b4a.example3.customlistview();
 //BA.debugLineNum = 198;BA.debugLine="Dim ht As HttpJob";
mostCurrent._ht = new ir.taravatgroup.ezafekari2.httpjob();
 //BA.debugLineNum = 200;BA.debugLine="Dim msg As String=\"\"";
mostCurrent._msg = "";
 //BA.debugLineNum = 202;BA.debugLine="Private pan_notifi_all As Panel";
mostCurrent._pan_notifi_all = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 203;BA.debugLine="Private web_msg_show As WebView";
mostCurrent._web_msg_show = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 206;BA.debugLine="Dim ls1 As List		'num msg";
mostCurrent._ls1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 207;BA.debugLine="Dim ls2 As List		'msg";
mostCurrent._ls2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 208;BA.debugLine="Dim ls3 As List		'date msg";
mostCurrent._ls3 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 210;BA.debugLine="Dim last_notif As String =\"0000\"";
mostCurrent._last_notif = "0000";
 //BA.debugLineNum = 211;BA.debugLine="Dim is_now_instal As Boolean=True";
_is_now_instal = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 213;BA.debugLine="Private lbl_title_msgPan As Label";
mostCurrent._lbl_title_msgpan = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 214;BA.debugLine="Private pan_notif As Panel";
mostCurrent._pan_notif = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 218;BA.debugLine="Private ckb_ezaf_taradod As CheckBox";
mostCurrent._ckb_ezaf_taradod = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 219;BA.debugLine="Private lbl_ezaf_taradod As Label";
mostCurrent._lbl_ezaf_taradod = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 220;BA.debugLine="Private pan_ezaf_taradod As Panel";
mostCurrent._pan_ezaf_taradod = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 221;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 222;BA.debugLine="Private pan_hed_list As Panel";
mostCurrent._pan_hed_list = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 223;BA.debugLine="Private pan_hed_gozaresh As Panel";
mostCurrent._pan_hed_gozaresh = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 228;BA.debugLine="Private pan_all_msgNewYear As Panel";
mostCurrent._pan_all_msgnewyear = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 229;BA.debugLine="Private lbl_majmoe_saat As Label";
mostCurrent._lbl_majmoe_saat = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 230;BA.debugLine="Private pan_all_liteMenu As Panel";
mostCurrent._pan_all_litemenu = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 231;BA.debugLine="Private lbl_shift_home As Label";
mostCurrent._lbl_shift_home = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 232;BA.debugLine="Private sp_year_gozaresh As Spinner";
mostCurrent._sp_year_gozaresh = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 233;BA.debugLine="Private pan_item_gozaresh As Panel";
mostCurrent._pan_item_gozaresh = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 236;BA.debugLine="Dim rsPOP_noe As RSPopupMenu";
mostCurrent._rspop_noe = new com.rootsoft.rspopupmenu.RSPopupMenu();
 //BA.debugLineNum = 237;BA.debugLine="Dim index_noe_morakhasi As Int=0";
_index_noe_morakhasi = (int) (0);
 //BA.debugLineNum = 238;BA.debugLine="Dim str_noe As String=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 //BA.debugLineNum = 239;BA.debugLine="Private lbl_edit_from_list As Label";
mostCurrent._lbl_edit_from_list = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 242;BA.debugLine="Dim current_id_edit As Int=0";
_current_id_edit = (int) (0);
 //BA.debugLineNum = 243;BA.debugLine="Dim	is_for_edit As Boolean=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 246;BA.debugLine="Dim tim_min As Int";
_tim_min = 0;
 //BA.debugLineNum = 248;BA.debugLine="Private lbl_vesion_app As Label";
mostCurrent._lbl_vesion_app = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 249;BA.debugLine="Private lbl_date_FT As Label";
mostCurrent._lbl_date_ft = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 250;BA.debugLine="Private lbl_vorod_FT As Label";
mostCurrent._lbl_vorod_ft = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 251;BA.debugLine="Private lbl_khoroj_FT As Label";
mostCurrent._lbl_khoroj_ft = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 252;BA.debugLine="Private lbl_time_show_FT As Label";
mostCurrent._lbl_time_show_ft = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 253;BA.debugLine="Private lbl_tim_khoroj_FT As Label";
mostCurrent._lbl_tim_khoroj_ft = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 254;BA.debugLine="Private lbl_tim_vorod_FT As Label";
mostCurrent._lbl_tim_vorod_ft = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 255;BA.debugLine="Private ckb_ezaf_taradod_FT As CheckBox";
mostCurrent._ckb_ezaf_taradod_ft = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 256;BA.debugLine="Private pan_all_FT As Panel";
mostCurrent._pan_all_ft = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 258;BA.debugLine="Dim code_fast_taradod As Int=1";
_code_fast_taradod = (int) (1);
 //BA.debugLineNum = 259;BA.debugLine="Private et_tozihat_FT As EditText";
mostCurrent._et_tozihat_ft = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 262;BA.debugLine="Private btnEight As Button";
mostCurrent._btneight = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 263;BA.debugLine="Private btnFive As Button";
mostCurrent._btnfive = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 264;BA.debugLine="Private btnFour As Button";
mostCurrent._btnfour = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 265;BA.debugLine="Private btnNine As Button";
mostCurrent._btnnine = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 266;BA.debugLine="Private btnOne As Button";
mostCurrent._btnone = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 267;BA.debugLine="Private btnSeven As Button";
mostCurrent._btnseven = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 268;BA.debugLine="Private btnSix As Button";
mostCurrent._btnsix = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 269;BA.debugLine="Private btnThree As Button";
mostCurrent._btnthree = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 270;BA.debugLine="Private btnTwo As Button";
mostCurrent._btntwo = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 271;BA.debugLine="Private btnZero As Button";
mostCurrent._btnzero = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 272;BA.debugLine="Private key1 As Panel";
mostCurrent._key1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 273;BA.debugLine="Private key2 As Panel";
mostCurrent._key2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 274;BA.debugLine="Private key3 As Panel";
mostCurrent._key3 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 275;BA.debugLine="Private key4 As Panel";
mostCurrent._key4 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 278;BA.debugLine="Dim Click_Count As Int = 0";
_click_count = (int) (0);
 //BA.debugLineNum = 279;BA.debugLine="Dim Master_Password As String";
mostCurrent._master_password = "";
 //BA.debugLineNum = 280;BA.debugLine="Dim entered_Password As String";
mostCurrent._entered_password = "";
 //BA.debugLineNum = 281;BA.debugLine="Dim fingerprint As FingerprintManager";
mostCurrent._fingerprint = new ir.taravatgroup.ezafekari2.fingerprintmanager();
 //BA.debugLineNum = 282;BA.debugLine="Private lbl_finger As Label";
mostCurrent._lbl_finger = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 284;BA.debugLine="Dim stat_finger As Int=0";
_stat_finger = (int) (0);
 //BA.debugLineNum = 286;BA.debugLine="Private pan_lock As Panel";
mostCurrent._pan_lock = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 287;BA.debugLine="Private lbl_hint_lock As Label";
mostCurrent._lbl_hint_lock = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 288;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
String _send = "";
 //BA.debugLineNum = 427;BA.debugLine="Sub http_initial_1(type1 As Int)";
 //BA.debugLineNum = 428;BA.debugLine="ht.Initialize(\"ht\",Me)";
mostCurrent._ht._initialize /*String*/ (processBA,"ht",main.getObject());
 //BA.debugLineNum = 429;BA.debugLine="Dim send As String";
_send = "";
 //BA.debugLineNum = 430;BA.debugLine="send = \"username=mahdi&password=1234&div_id=\"&pho";
_send = "username=mahdi&password=1234&div_id="+_phon.GetSettings("android_id")+"&sdk_ver="+BA.NumberToString(_phon.getSdkVersion())+"&oprator="+_phon.GetNetworkOperatorName()+"&type_app="+BA.NumberToString(_type1)+"&div_model="+_phon.getModel()+"&last_notif="+mostCurrent._last_notif+"&var=0&is_now_instal="+BA.ObjectToString(_is_now_instal)+"&version_code="+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Application.getVersionCode());
 //BA.debugLineNum = 431;BA.debugLine="ht.PostString(\"https://azarfadak.com/ezafekari2.p";
mostCurrent._ht._poststring /*String*/ ("https://azarfadak.com/ezafekari2.php",_send);
 //BA.debugLineNum = 434;BA.debugLine="End Sub";
return "";
}
public static String  _img_slider(int _index1) throws Exception{
 //BA.debugLineNum = 2931;BA.debugLine="Sub img_slider (index1 As Int)";
 //BA.debugLineNum = 2932;BA.debugLine="Select index1";
switch (_index1) {
case 0: {
 //BA.debugLineNum = 2934;BA.debugLine="img_help.Bitmap=bit_img0";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img0.getObject()));
 break; }
case 1: {
 //BA.debugLineNum = 2936;BA.debugLine="img_help.Bitmap=bit_img1";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img1.getObject()));
 break; }
case 2: {
 //BA.debugLineNum = 2939;BA.debugLine="img_help.Bitmap=bit_img2";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img2.getObject()));
 break; }
case 3: {
 //BA.debugLineNum = 2942;BA.debugLine="img_help.Bitmap=bit_img3";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img3.getObject()));
 break; }
case 4: {
 //BA.debugLineNum = 2945;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
 break; }
default: {
 //BA.debugLineNum = 2948;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("214155793","error",0);
 break; }
}
;
 //BA.debugLineNum = 2951;BA.debugLine="End Sub";
return "";
}
public static String  _inapp_purchasecompleted(boolean _success,anywheresoftware.b4a.inappbilling3.BillingManager3.Prchase _product) throws Exception{
 //BA.debugLineNum = 603;BA.debugLine="Sub inapp_PurchaseCompleted (Success As Boolean, P";
 //BA.debugLineNum = 606;BA.debugLine="If Success=True Then";
if (_success==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 608;BA.debugLine="If Product.ProductId=\"ezafekari2\" Then";
if ((_product.getProductId()).equals("ezafekari2")) { 
 //BA.debugLineNum = 610;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\",\"\")";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
 //BA.debugLineNum = 611;BA.debugLine="MsgboxAsync(\"پرداخت انجام شده است\",\"انجام شد\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("پرداخت انجام شده است"),BA.ObjectToCharSequence("انجام شد"),processBA);
 //BA.debugLineNum = 612;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی ا";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 614;BA.debugLine="inapp.ConsumeProduct(Product)";
mostCurrent._inapp.ConsumeProduct(processBA,_product);
 //BA.debugLineNum = 616;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 //BA.debugLineNum = 617;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 621;BA.debugLine="ToastMessageShow(\"خرید انجام نشد. دوباره تلاش کن";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خرید انجام نشد. دوباره تلاش کنید"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 623;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(ir.taravatgroup.ezafekari2.httpjob _job) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_lock0 = null;
 //BA.debugLineNum = 438;BA.debugLine="Sub Jobdone (job As HttpJob)";
 //BA.debugLineNum = 439;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 440;BA.debugLine="If job.JobName=\"ht\" Then";
if ((_job._jobname /*String*/ ).equals("ht")) { 
 //BA.debugLineNum = 441;BA.debugLine="If(job.GetString <> \"\")Then";
if (((_job._getstring /*String*/ ()).equals("") == false)) { 
 //BA.debugLineNum = 443;BA.debugLine="If(job.GetString.Contains(\"accessok\"))Then";
if ((_job._getstring /*String*/ ().contains("accessok"))) { 
 //BA.debugLineNum = 446;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") Th";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
 }else {
 //BA.debugLineNum = 449;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
 //BA.debugLineNum = 450;BA.debugLine="myfunc.help_man(\"نسخه طلایی از طرف ادمین فعا";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"نسخه طلایی از طرف ادمین فعال شد");
 };
 }else if((_job._getstring /*String*/ ().contains("accessno"))) { 
 //BA.debugLineNum = 455;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") Th";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
 //BA.debugLineNum = 456;BA.debugLine="File.Delete(File.DirInternal,\"payokok\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok");
 //BA.debugLineNum = 457;BA.debugLine="myfunc.help_man(\" نسخه طلایی از طرف ادمین غی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA," نسخه طلایی از طرف ادمین غیرفعال شد");
 };
 }else if((_job._getstring /*String*/ ().contains("lockok"))) { 
 //BA.debugLineNum = 461;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 462;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
 //BA.debugLineNum = 464;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=Tr";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 465;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
 //BA.debugLineNum = 466;BA.debugLine="ls_lock0.Set(0,\"true\")";
_ls_lock0.Set((int) (0),(Object)("true"));
 //BA.debugLineNum = 467;BA.debugLine="ls_lock0.Set(1,\"false\")";
_ls_lock0.Set((int) (1),(Object)("false"));
 //BA.debugLineNum = 468;BA.debugLine="ls_lock0.Set(2,\"2022\")";
_ls_lock0.Set((int) (2),(Object)("2022"));
 }else {
 //BA.debugLineNum = 470;BA.debugLine="ls_lock0.Add(\"true\")";
_ls_lock0.Add((Object)("true"));
 //BA.debugLineNum = 471;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
 //BA.debugLineNum = 472;BA.debugLine="ls_lock0.Add(\"2022\")";
_ls_lock0.Add((Object)("2022"));
 //BA.debugLineNum = 473;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 };
 //BA.debugLineNum = 475;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock0);
 }else if((_job._getstring /*String*/ ().contains("lockno"))) { 
 //BA.debugLineNum = 478;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 479;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
 //BA.debugLineNum = 481;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=Tr";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 482;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
 //BA.debugLineNum = 483;BA.debugLine="ls_lock0.Set(0,\"false\")";
_ls_lock0.Set((int) (0),(Object)("false"));
 //BA.debugLineNum = 484;BA.debugLine="ls_lock0.Set(1,\"false\")";
_ls_lock0.Set((int) (1),(Object)("false"));
 //BA.debugLineNum = 485;BA.debugLine="ls_lock0.Set(2,\"\")";
_ls_lock0.Set((int) (2),(Object)(""));
 }else {
 //BA.debugLineNum = 487;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
 //BA.debugLineNum = 488;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
 //BA.debugLineNum = 489;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 //BA.debugLineNum = 490;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 };
 //BA.debugLineNum = 492;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock0);
 }else {
 //BA.debugLineNum = 497;BA.debugLine="msg=job.GetString";
mostCurrent._msg = _job._getstring /*String*/ ();
 //BA.debugLineNum = 498;BA.debugLine="tim_msg.Enabled=True";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 };
 };
 }else {
 };
 //BA.debugLineNum = 509;BA.debugLine="End Sub";
return "";
}
public static String  _kharid() throws Exception{
 //BA.debugLineNum = 585;BA.debugLine="Sub kharid";
 //BA.debugLineNum = 588;BA.debugLine="If(myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 589;BA.debugLine="Try";
try { //BA.debugLineNum = 591;BA.debugLine="inapp.RequestPayment(\"ezafekari2\",\"inapp\",\"ezaf";
mostCurrent._inapp.RequestPayment(processBA,"ezafekari2","inapp","ezafekari2");
 } 
       catch (Exception e5) {
			processBA.setLastException(e5); //BA.debugLineNum = 594;BA.debugLine="MsgboxAsync(\"1- از نصب بودن برنامه بازار اطمینا";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("1- از نصب بودن برنامه بازار اطمینان یابید."+anywheresoftware.b4a.keywords.Common.CRLF+" 2- برنامه ها را ببندید و دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 };
 }else {
 //BA.debugLineNum = 597;BA.debugLine="ToastMessageShow(\"خطا در اتصال \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال "),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 600;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_ft_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 3313;BA.debugLine="Private Sub lbl_close_FT_Click";
 //BA.debugLineNum = 3315;BA.debugLine="If(dbCode.isexist_taradod_by_date(myfunc.fa2en(pe";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate()))==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 3316;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 3317;BA.debugLine="result = Msgbox2(\"تردد و اضافه کاری امروز پاک شو";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("تردد و اضافه کاری امروز پاک شود؟"),BA.ObjectToCharSequence("توجه"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 3318;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 3320;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 3322;BA.debugLine="dbCode.sql.ExecNonQuery(\"DELETE FROM tb_taradod";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("DELETE FROM tb_taradod WHERE date_from LIKE '%"+mostCurrent._lbl_date_ft.getText()+"%'; ");
 //BA.debugLineNum = 3324;BA.debugLine="dbCode.sql.ExecNonQuery(\"DELETE FROM tb_ezafeka";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("DELETE FROM tb_ezafekari WHERE date_from LIKE '%"+mostCurrent._lbl_date_ft.getText()+"%'; ");
 //BA.debugLineNum = 3325;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 3326;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 3328;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3329;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=True";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3330;BA.debugLine="lbl_tim_vorod_FT.Text=\"00:00\"";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 3331;BA.debugLine="lbl_tim_khoroj_FT.Text=\"00:00\"";
mostCurrent._lbl_tim_khoroj_ft.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 3332;BA.debugLine="lbl_time_show_FT.Text=\"\"";
mostCurrent._lbl_time_show_ft.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 3333;BA.debugLine="et_tozihat_FT.Enabled=True";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3334;BA.debugLine="et_tozihat_FT.Text=\"\"";
mostCurrent._et_tozihat_ft.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 3335;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
 };
 }else {
 //BA.debugLineNum = 3339;BA.debugLine="myfunc.help_man(\"برای امروز هنوز ترددی ثبت نشده";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"برای امروز هنوز ترددی ثبت نشده است");
 //BA.debugLineNum = 3340;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
 };
 //BA.debugLineNum = 3343;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_help_click() throws Exception{
 //BA.debugLineNum = 2875;BA.debugLine="Private Sub lbl_close_help_Click";
 //BA.debugLineNum = 2876;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2877;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_msgnewy_click() throws Exception{
 //BA.debugLineNum = 416;BA.debugLine="Private Sub lbl_close_msgNewY_Click";
 //BA.debugLineNum = 418;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 419;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_notif_click() throws Exception{
 //BA.debugLineNum = 573;BA.debugLine="Private Sub lbl_close_notif_Click";
 //BA.debugLineNum = 574;BA.debugLine="pan_notifi_all.Visible=False";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 575;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date1_click() throws Exception{
 //BA.debugLineNum = 2625;BA.debugLine="Private Sub lbl_date1_Click";
 //BA.debugLineNum = 2626;BA.debugLine="lbl_tim1_Click";
_lbl_tim1_click();
 //BA.debugLineNum = 2627;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date2_click() throws Exception{
 //BA.debugLineNum = 2620;BA.debugLine="Private Sub lbl_date2_Click";
 //BA.debugLineNum = 2621;BA.debugLine="lbl_tim2_Click";
_lbl_tim2_click();
 //BA.debugLineNum = 2622;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_from_list_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _b = null;
 //BA.debugLineNum = 2954;BA.debugLine="Private Sub lbl_edit_from_list_Click";
 //BA.debugLineNum = 2955;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 2956;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 2957;BA.debugLine="Log(b.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("214221315",BA.ObjectToString(_b.getTag()),0);
 //BA.debugLineNum = 2958;BA.debugLine="current_id_edit=b.Tag";
_current_id_edit = (int)(BA.ObjectToNumber(_b.getTag()));
 //BA.debugLineNum = 2961;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
 //BA.debugLineNum = 2962;BA.debugLine="pan_add_ezafekari_Click";
_pan_add_ezafekari_click();
 //BA.debugLineNum = 2963;BA.debugLine="lbl_box_title.Text=\"ویرایش اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش اضافه کاری"));
 }else if((mostCurrent._tabhost1.getCurrentTab()==1)) { 
 //BA.debugLineNum = 2966;BA.debugLine="pan_add_morakhasi_Click";
_pan_add_morakhasi_click();
 //BA.debugLineNum = 2967;BA.debugLine="lbl_box_title.Text=\"ویرایش مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش مرخصی"));
 }else if((mostCurrent._tabhost1.getCurrentTab()==2)) { 
 //BA.debugLineNum = 2970;BA.debugLine="pan_add_taradod_Click";
_pan_add_taradod_click();
 //BA.debugLineNum = 2971;BA.debugLine="lbl_box_title.Text=\"ویرایش تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش تردد"));
 //BA.debugLineNum = 2972;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2973;BA.debugLine="lbl_ezaf_taradod.Visible=False";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 2975;BA.debugLine="is_for_edit=True";
_is_for_edit = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 2976;BA.debugLine="get_dataEdit_byId(current_id_edit)";
_get_dataedit_byid(_current_id_edit);
 //BA.debugLineNum = 2986;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 2989;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_ezaf_taradod_click() throws Exception{
 //BA.debugLineNum = 1482;BA.debugLine="Private Sub lbl_ezaf_taradod_Click";
 //BA.debugLineNum = 1483;BA.debugLine="If(index_box=2)Then";
if ((_index_box==2)) { 
 //BA.debugLineNum = 1484;BA.debugLine="rsPOP_noe.Show";
mostCurrent._rspop_noe.Show();
 };
 //BA.debugLineNum = 1486;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_click() throws Exception{
 //BA.debugLineNum = 2859;BA.debugLine="Private Sub lbl_help_Click";
 //BA.debugLineNum = 2862;BA.debugLine="bit_img0.Initialize(File.DirAssets,\"home-h0.jpg\")";
mostCurrent._bit_img0.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h0.jpg");
 //BA.debugLineNum = 2863;BA.debugLine="bit_img1.Initialize(File.DirAssets,\"home-h1.jpg\")";
mostCurrent._bit_img1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h1.jpg");
 //BA.debugLineNum = 2864;BA.debugLine="bit_img2.Initialize(File.DirAssets,\"home-h2.jpg\")";
mostCurrent._bit_img2.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h2.jpg");
 //BA.debugLineNum = 2865;BA.debugLine="bit_img3.Initialize(File.DirAssets,\"home-h3.jpg\")";
mostCurrent._bit_img3.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h3.jpg");
 //BA.debugLineNum = 2866;BA.debugLine="bit_img4.Initialize(File.DirAssets,\"home-h4.jpg\")";
mostCurrent._bit_img4.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h4.jpg");
 //BA.debugLineNum = 2869;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 //BA.debugLineNum = 2870;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 //BA.debugLineNum = 2871;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2873;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_ft_click() throws Exception{
 //BA.debugLineNum = 3474;BA.debugLine="Private Sub lbl_help_FT_Click";
 //BA.debugLineNum = 3475;BA.debugLine="myfunc.help_man(\"برای ثبت ورود یا خروج انگشت خود";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"برای ثبت ورود یا خروج انگشت خود را در قسمت مشخص شده 3 ثانیه نگه دارید.");
 //BA.debugLineNum = 3476;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_piker_click() throws Exception{
 //BA.debugLineNum = 3168;BA.debugLine="Private Sub lbl_help_piker_Click";
 //BA.debugLineNum = 3170;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 //BA.debugLineNum = 3172;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
 //BA.debugLineNum = 3173;BA.debugLine="lbl_close_help.Visible=False";
mostCurrent._lbl_close_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3174;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3176;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help2_click() throws Exception{
 //BA.debugLineNum = 3118;BA.debugLine="Private Sub lbl_help2_Click";
 //BA.debugLineNum = 3119;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 3120;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_khoroj_ft_click() throws Exception{
 //BA.debugLineNum = 3352;BA.debugLine="Private Sub lbl_khoroj_FT_Click";
 //BA.debugLineNum = 3353;BA.debugLine="ToastMessageShow(\"انگشت خود را 3 ثانیه نگه دارید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("انگشت خود را 3 ثانیه نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3354;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_khoroj_ft_longclick() throws Exception{
 //BA.debugLineNum = 3373;BA.debugLine="Private Sub lbl_khoroj_FT_LongClick";
 //BA.debugLineNum = 3374;BA.debugLine="If(code_fast_taradod=10 Or code_fast_taradod=20)T";
if ((_code_fast_taradod==10 || _code_fast_taradod==20)) { 
 //BA.debugLineNum = 3375;BA.debugLine="index_box=4";
_index_box = (int) (4);
 //BA.debugLineNum = 3376;BA.debugLine="lbl_tim_khoroj_FT.Text=DateTime.Time(DateTime.No";
mostCurrent._lbl_tim_khoroj_ft.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 //BA.debugLineNum = 3377;BA.debugLine="add_taradod_fast";
_add_taradod_fast();
 //BA.debugLineNum = 3378;BA.debugLine="code_fast_taradod=11";
_code_fast_taradod = (int) (11);
 }else if((_code_fast_taradod==0)) { 
 //BA.debugLineNum = 3380;BA.debugLine="ToastMessageShow(\"تردد امروز دستی ثبت شده است\",F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تردد امروز دستی ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else if((_code_fast_taradod==1)) { 
 //BA.debugLineNum = 3382;BA.debugLine="ToastMessageShow(\"ابتدا قسمت ورود را بزنید\",Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ابتدا قسمت ورود را بزنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 3384;BA.debugLine="ToastMessageShow(\"زمان خروج ثبت شده است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("زمان خروج ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 3386;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_lite_menu_click() throws Exception{
 //BA.debugLineNum = 3208;BA.debugLine="Private Sub lbl_lite_menu_Click";
 //BA.debugLineNum = 3209;BA.debugLine="pan_all_liteMenu.Visible=True";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3210;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_notefi_click() throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _html = null;
int _i = 0;
 //BA.debugLineNum = 544;BA.debugLine="Private Sub lbl_notefi_Click";
 //BA.debugLineNum = 545;BA.debugLine="lbl_title_msgPan.Text=\"پیام ها\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام ها"));
 //BA.debugLineNum = 546;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 547;BA.debugLine="pan_notif.Top=10%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 548;BA.debugLine="pan_notif.Height=70%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 549;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
 //BA.debugLineNum = 552;BA.debugLine="Dim html As StringBuilder";
_html = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 553;BA.debugLine="html.Initialize";
_html.Initialize();
 //BA.debugLineNum = 555;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1"))) { 
 //BA.debugLineNum = 557;BA.debugLine="html.Append(\"<!DOCTYPE html><html><meta charset=";
_html.Append("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'>");
 //BA.debugLineNum = 558;BA.debugLine="For i = ls1.Size-1 To 0 Step -1";
{
final int step10 = -1;
final int limit10 = (int) (0);
_i = (int) (mostCurrent._ls1.getSize()-1) ;
for (;_i >= limit10 ;_i = _i + step10 ) {
 //BA.debugLineNum = 559;BA.debugLine="html.Append(\"<div style='background-color: #99f";
_html.Append("<div style='background-color: #99ffff; font-size: 13px;'>"+"کد پیام : "+BA.ObjectToString(mostCurrent._ls1.Get(_i))+" - مورخ : "+BA.ObjectToString(mostCurrent._ls3.Get(_i))+"</div><div style='background-color: #e6ffff; font-size: 16px;'><br>"+BA.ObjectToString(mostCurrent._ls2.Get(_i))).Append("<br></div><br>");
 }
};
 //BA.debugLineNum = 561;BA.debugLine="html.Append(\"</body></html>\")";
_html.Append("</body></html>");
 //BA.debugLineNum = 564;BA.debugLine="web_msg_show.LoadHtml(html.ToString)";
mostCurrent._web_msg_show.LoadHtml(_html.ToString());
 }else {
 //BA.debugLineNum = 567;BA.debugLine="web_msg_show.LoadHtml(\"<html><body dir='rtl'>لیس";
mostCurrent._web_msg_show.LoadHtml("<html><body dir='rtl'>لیست پیام خالی ... </body></html>");
 };
 //BA.debugLineNum = 571;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
 //BA.debugLineNum = 3046;BA.debugLine="Private Sub lbl_remove_from_list_Click";
 //BA.debugLineNum = 3048;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 3049;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 3051;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
 //BA.debugLineNum = 3052;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 3053;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 3054;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 3056;BA.debugLine="If (dbCode.delete_ezafekari(b.Tag))Then";
if ((mostCurrent._dbcode._delete_ezafekari /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 3057;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3059;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
 //BA.debugLineNum = 3060;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 };
 };
 }else if((mostCurrent._tabhost1.getCurrentTab()==1)) { 
 //BA.debugLineNum = 3065;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 3066;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 3067;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 3069;BA.debugLine="If (dbCode.delete_morakhasi(b.Tag))Then";
if ((mostCurrent._dbcode._delete_morakhasi /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 3070;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3071;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
 //BA.debugLineNum = 3072;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 };
 };
 }else if((mostCurrent._tabhost1.getCurrentTab()==2)) { 
 //BA.debugLineNum = 3076;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 3077;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 3078;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 3080;BA.debugLine="If (dbCode.delete_taradod(b.Tag))Then";
if ((mostCurrent._dbcode._delete_taradod /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 3081;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3083;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
 //BA.debugLineNum = 3084;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 };
 };
 };
 //BA.debugLineNum = 3094;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list2_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
 //BA.debugLineNum = 3097;BA.debugLine="Private Sub lbl_remove_from_list2_Click";
 //BA.debugLineNum = 3098;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 3099;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 3102;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 3103;BA.debugLine="result = Msgbox2(\"آیا این گزارش حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این گزارش حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 3104;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 3106;BA.debugLine="If (dbCode.delete_gozaresh(b.tag))Then";
if ((mostCurrent._dbcode._delete_gozaresh /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 3107;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3109;BA.debugLine="btn_menu_gozaresh_Click";
_btn_menu_gozaresh_click();
 };
 };
 //BA.debugLineNum = 3113;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_box_click() throws Exception{
 //BA.debugLineNum = 1609;BA.debugLine="Private Sub lbl_save_box_Click";
 //BA.debugLineNum = 1611;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 1612;BA.debugLine="add_end";
_add_end();
 //BA.debugLineNum = 1616;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
String _value = "";
String _value1 = "";
String _value2 = "";
 //BA.debugLineNum = 2653;BA.debugLine="Private Sub lbl_save_picker_Click";
 //BA.debugLineNum = 2655;BA.debugLine="Dim value As String";
_value = "";
 //BA.debugLineNum = 2656;BA.debugLine="value=pik_hour1.Text";
_value = mostCurrent._pik_hour1.getText();
 //BA.debugLineNum = 2657;BA.debugLine="Select value";
switch (BA.switchObjectToInt(_value,"1","2","3","4","5","6","7","8","9")) {
case 0: {
 //BA.debugLineNum = 2659;BA.debugLine="pik_hour1.Text=\"01\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("01"));
 break; }
case 1: {
 //BA.debugLineNum = 2661;BA.debugLine="pik_hour1.Text=\"02\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("02"));
 break; }
case 2: {
 //BA.debugLineNum = 2663;BA.debugLine="pik_hour1.Text=\"03\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("03"));
 break; }
case 3: {
 //BA.debugLineNum = 2665;BA.debugLine="pik_hour1.Text=\"04\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("04"));
 break; }
case 4: {
 //BA.debugLineNum = 2667;BA.debugLine="pik_hour1.Text=\"05\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("05"));
 break; }
case 5: {
 //BA.debugLineNum = 2669;BA.debugLine="pik_hour1.Text=\"06\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("06"));
 break; }
case 6: {
 //BA.debugLineNum = 2671;BA.debugLine="pik_hour1.Text=\"07\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("07"));
 break; }
case 7: {
 //BA.debugLineNum = 2673;BA.debugLine="pik_hour1.Text=\"08\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("08"));
 break; }
case 8: {
 //BA.debugLineNum = 2675;BA.debugLine="pik_hour1.Text=\"09\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("09"));
 break; }
}
;
 //BA.debugLineNum = 2678;BA.debugLine="Dim value1 As String";
_value1 = "";
 //BA.debugLineNum = 2679;BA.debugLine="value1=pik_min1.Text";
_value1 = mostCurrent._pik_min1.getText();
 //BA.debugLineNum = 2680;BA.debugLine="Select value1";
switch (BA.switchObjectToInt(_value1,"1","2","3","4","5","6","7","8","9")) {
case 0: {
 //BA.debugLineNum = 2682;BA.debugLine="pik_min1.Text=\"01\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("01"));
 break; }
case 1: {
 //BA.debugLineNum = 2684;BA.debugLine="pik_min1.Text=\"02\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("02"));
 break; }
case 2: {
 //BA.debugLineNum = 2686;BA.debugLine="pik_min1.Text=\"03\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("03"));
 break; }
case 3: {
 //BA.debugLineNum = 2688;BA.debugLine="pik_min1.Text=\"04\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("04"));
 break; }
case 4: {
 //BA.debugLineNum = 2690;BA.debugLine="pik_min1.Text=\"05\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("05"));
 break; }
case 5: {
 //BA.debugLineNum = 2692;BA.debugLine="pik_min1.Text=\"06\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("06"));
 break; }
case 6: {
 //BA.debugLineNum = 2694;BA.debugLine="pik_min1.Text=\"07\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("07"));
 break; }
case 7: {
 //BA.debugLineNum = 2696;BA.debugLine="pik_min1.Text=\"08\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("08"));
 break; }
case 8: {
 //BA.debugLineNum = 2698;BA.debugLine="pik_min1.Text=\"09\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("09"));
 break; }
}
;
 //BA.debugLineNum = 2701;BA.debugLine="Dim value2 As String";
_value2 = "";
 //BA.debugLineNum = 2702;BA.debugLine="value2=pik_day1.Text";
_value2 = mostCurrent._pik_day1.getText();
 //BA.debugLineNum = 2703;BA.debugLine="Select value2";
switch (BA.switchObjectToInt(_value2,"1","2","3","4","5","6","7","8","9")) {
case 0: {
 //BA.debugLineNum = 2705;BA.debugLine="pik_day1.Text=\"01\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("01"));
 break; }
case 1: {
 //BA.debugLineNum = 2707;BA.debugLine="pik_day1.Text=\"02\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("02"));
 break; }
case 2: {
 //BA.debugLineNum = 2709;BA.debugLine="pik_day1.Text=\"03\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("03"));
 break; }
case 3: {
 //BA.debugLineNum = 2711;BA.debugLine="pik_day1.Text=\"04\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("04"));
 break; }
case 4: {
 //BA.debugLineNum = 2713;BA.debugLine="pik_day1.Text=\"05\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("05"));
 break; }
case 5: {
 //BA.debugLineNum = 2715;BA.debugLine="pik_day1.Text=\"06\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("06"));
 break; }
case 6: {
 //BA.debugLineNum = 2717;BA.debugLine="pik_day1.Text=\"07\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("07"));
 break; }
case 7: {
 //BA.debugLineNum = 2719;BA.debugLine="pik_day1.Text=\"08\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("08"));
 break; }
case 8: {
 //BA.debugLineNum = 2721;BA.debugLine="pik_day1.Text=\"09\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("09"));
 break; }
}
;
 //BA.debugLineNum = 2723;BA.debugLine="Select pik_moon1.Tag";
switch (BA.switchObjectToInt(mostCurrent._pik_moon1.getTag(),(Object)(1),(Object)(2),(Object)(3),(Object)(4),(Object)(5),(Object)(6),(Object)(7),(Object)(8),(Object)(9),(Object)(10),(Object)(11),(Object)(12))) {
case 0: {
 //BA.debugLineNum = 2725;BA.debugLine="pik_moon1.Tag=\"01\"";
mostCurrent._pik_moon1.setTag((Object)("01"));
 break; }
case 1: {
 //BA.debugLineNum = 2727;BA.debugLine="pik_moon1.Tag=\"02\"";
mostCurrent._pik_moon1.setTag((Object)("02"));
 break; }
case 2: {
 //BA.debugLineNum = 2729;BA.debugLine="pik_moon1.Tag=\"03\"";
mostCurrent._pik_moon1.setTag((Object)("03"));
 break; }
case 3: {
 //BA.debugLineNum = 2731;BA.debugLine="pik_moon1.Tag=\"04\"";
mostCurrent._pik_moon1.setTag((Object)("04"));
 break; }
case 4: {
 //BA.debugLineNum = 2733;BA.debugLine="pik_moon1.Tag=\"05\"";
mostCurrent._pik_moon1.setTag((Object)("05"));
 break; }
case 5: {
 //BA.debugLineNum = 2735;BA.debugLine="pik_moon1.Tag=\"06\"";
mostCurrent._pik_moon1.setTag((Object)("06"));
 break; }
case 6: {
 //BA.debugLineNum = 2737;BA.debugLine="pik_moon1.Tag=\"07\"";
mostCurrent._pik_moon1.setTag((Object)("07"));
 break; }
case 7: {
 //BA.debugLineNum = 2739;BA.debugLine="pik_moon1.Tag=\"08\"";
mostCurrent._pik_moon1.setTag((Object)("08"));
 break; }
case 8: {
 //BA.debugLineNum = 2741;BA.debugLine="pik_moon1.Tag=\"09\"";
mostCurrent._pik_moon1.setTag((Object)("09"));
 break; }
case 9: {
 //BA.debugLineNum = 2743;BA.debugLine="pik_moon1.Tag=\"10\"";
mostCurrent._pik_moon1.setTag((Object)("10"));
 break; }
case 10: {
 //BA.debugLineNum = 2745;BA.debugLine="pik_moon1.Tag=\"11\"";
mostCurrent._pik_moon1.setTag((Object)("11"));
 break; }
case 11: {
 //BA.debugLineNum = 2747;BA.debugLine="pik_moon1.Tag=\"12\"";
mostCurrent._pik_moon1.setTag((Object)("12"));
 break; }
}
;
 //BA.debugLineNum = 2752;BA.debugLine="If(index_piker=1)Then  'date1";
if ((_index_piker==1)) { 
 //BA.debugLineNum = 2754;BA.debugLine="lbl_tim1.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
 //BA.debugLineNum = 2755;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
 }else if((_index_piker==2)) { 
 //BA.debugLineNum = 2759;BA.debugLine="lbl_tim2.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
 //BA.debugLineNum = 2760;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
 };
 //BA.debugLineNum = 2765;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2766;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 2767;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim1_click() throws Exception{
 //BA.debugLineNum = 2629;BA.debugLine="Private Sub lbl_tim1_Click";
 //BA.debugLineNum = 2630;BA.debugLine="index_piker=1";
_index_piker = (int) (1);
 //BA.debugLineNum = 2632;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim1.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (0))));
 //BA.debugLineNum = 2633;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim1.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (1))));
 //BA.debugLineNum = 2635;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date1.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (0))));
 //BA.debugLineNum = 2636;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (1)));
 //BA.debugLineNum = 2637;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 2638;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (2))));
 //BA.debugLineNum = 2642;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2644;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2645;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 2646;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 //BA.debugLineNum = 2647;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 //BA.debugLineNum = 2648;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
 //BA.debugLineNum = 2651;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim2_click() throws Exception{
 //BA.debugLineNum = 2598;BA.debugLine="Private Sub lbl_tim2_Click";
 //BA.debugLineNum = 2599;BA.debugLine="index_piker=2";
_index_piker = (int) (2);
 //BA.debugLineNum = 2600;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim2.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (0))));
 //BA.debugLineNum = 2601;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim2.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (1))));
 //BA.debugLineNum = 2603;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date2.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (0))));
 //BA.debugLineNum = 2604;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (1)));
 //BA.debugLineNum = 2605;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 2606;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (2))));
 //BA.debugLineNum = 2609;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2612;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2613;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 2614;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 //BA.debugLineNum = 2615;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 //BA.debugLineNum = 2616;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
 //BA.debugLineNum = 2618;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_click() throws Exception{
 //BA.debugLineNum = 2846;BA.debugLine="Private Sub lbl_vip_Click";
 //BA.debugLineNum = 2848;BA.debugLine="pan_all_noskhe.Visible=True";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2849;BA.debugLine="scroll_v_noskhe.Panel.LoadLayout(\"noske_item\")";
mostCurrent._scroll_v_noskhe.getPanel().LoadLayout("noske_item",mostCurrent.activityBA);
 //BA.debugLineNum = 2851;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 2852;BA.debugLine="lbl_show_vip.Text=\"نسخه کامل ( طلایی ) فعال می ب";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه کامل ( طلایی ) فعال می باشد."));
 }else {
 //BA.debugLineNum = 2854;BA.debugLine="lbl_show_vip.Text=\"نسخه معمولی ( هدیه ) فعال می";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه معمولی ( هدیه ) فعال می باشد."));
 };
 //BA.debugLineNum = 2857;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_later_click() throws Exception{
 //BA.debugLineNum = 3138;BA.debugLine="Private Sub lbl_vip_later_Click";
 //BA.debugLineNum = 3139;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
 //BA.debugLineNum = 3140;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_now_click() throws Exception{
String _title = "";
String _matn = "";
int _result = 0;
 //BA.debugLineNum = 3142;BA.debugLine="Private Sub lbl_vip_now_Click";
 //BA.debugLineNum = 3143;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 3145;BA.debugLine="Dim title , matn As String";
_title = "";
_matn = "";
 //BA.debugLineNum = 3146;BA.debugLine="title=\" تبریک \"";
_title = " تبریک ";
 //BA.debugLineNum = 3147;BA.debugLine="matn=\" شما صاحب نسخه طلایی و بدون محدودیت برنامه";
_matn = " شما صاحب نسخه طلایی و بدون محدودیت برنامه اضافه کاری من می باشید. ";
 //BA.debugLineNum = 3149;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 3150;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Lo";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"باشه","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"buy.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 3151;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
 }else {
 //BA.debugLineNum = 3156;BA.debugLine="kharid";
_kharid();
 };
 //BA.debugLineNum = 3158;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip2_click() throws Exception{
 //BA.debugLineNum = 3122;BA.debugLine="Private Sub lbl_vip2_Click";
 //BA.debugLineNum = 3123;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 //BA.debugLineNum = 3124;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vorod_ft_click() throws Exception{
 //BA.debugLineNum = 3349;BA.debugLine="Private Sub lbl_vorod_FT_Click";
 //BA.debugLineNum = 3350;BA.debugLine="ToastMessageShow(\"انگشت خود را 3 ثانیه نگه دارید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("انگشت خود را 3 ثانیه نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3351;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vorod_ft_longclick() throws Exception{
 //BA.debugLineNum = 3357;BA.debugLine="Private Sub lbl_vorod_FT_LongClick";
 //BA.debugLineNum = 3359;BA.debugLine="If(code_fast_taradod=1)Then";
if ((_code_fast_taradod==1)) { 
 //BA.debugLineNum = 3360;BA.debugLine="index_box=4";
_index_box = (int) (4);
 //BA.debugLineNum = 3361;BA.debugLine="lbl_tim_vorod_FT.Text=DateTime.Time(DateTime.Now";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 //BA.debugLineNum = 3362;BA.debugLine="code_fast_taradod=10";
_code_fast_taradod = (int) (10);
 //BA.debugLineNum = 3363;BA.debugLine="add_end";
_add_end();
 //BA.debugLineNum = 3364;BA.debugLine="pan_add_taradod_fast_Click";
_pan_add_taradod_fast_click();
 }else if((_code_fast_taradod==0)) { 
 //BA.debugLineNum = 3366;BA.debugLine="ToastMessageShow(\" تردد امروز دستی ثبت شده است\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" تردد امروز دستی ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 3368;BA.debugLine="ToastMessageShow(\"زمان ورود ثبت شده است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("زمان ورود ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 3371;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_ezafekari_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_temp_time1 = null;
 //BA.debugLineNum = 1508;BA.debugLine="Private Sub pan_add_ezafekari_Click";
 //BA.debugLineNum = 1509;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1510;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1511;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1512;BA.debugLine="lbl_box_title.Text=\"ثبت اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت اضافه کاری"));
 //BA.debugLineNum = 1513;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
 //BA.debugLineNum = 1514;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
 //BA.debugLineNum = 1515;BA.debugLine="index_box=1";
_index_box = (int) (1);
 //BA.debugLineNum = 1516;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1517;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1518;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1519;BA.debugLine="lbl_ezaf_taradod.Text=\"فوق العاده (جمعه کاری)\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("فوق العاده (جمعه کاری)"));
 //BA.debugLineNum = 1520;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 1521;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1522;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1523;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1529;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
 //BA.debugLineNum = 1530;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
 //BA.debugLineNum = 1531;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 1532;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
 //BA.debugLineNum = 1535;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1536;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1541;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_time1.txt\")";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time1.txt"))) { 
 //BA.debugLineNum = 1542;BA.debugLine="Dim ls_temp_time1 As List";
_ls_temp_time1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1543;BA.debugLine="ls_temp_time1.Initialize";
_ls_temp_time1.Initialize();
 //BA.debugLineNum = 1544;BA.debugLine="ls_temp_time1=File.ReadList(File.DirInternal,\"te";
_ls_temp_time1 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time1.txt");
 //BA.debugLineNum = 1546;BA.debugLine="lbl_tim1.Text=ls_temp_time1.Get(0)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_temp_time1.Get((int) (0))));
 //BA.debugLineNum = 1547;BA.debugLine="lbl_tim2.Text=ls_temp_time1.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_temp_time1.Get((int) (1))));
 //BA.debugLineNum = 1548;BA.debugLine="time_show";
_time_show();
 }else {
 //BA.debugLineNum = 1550;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 1551;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 1555;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_morakhasi_click() throws Exception{
 //BA.debugLineNum = 1437;BA.debugLine="Private Sub pan_add_morakhasi_Click";
 //BA.debugLineNum = 1438;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1439;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1440;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1441;BA.debugLine="lbl_box_title.Text=\"ثبت مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت مرخصی"));
 //BA.debugLineNum = 1442;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
 //BA.debugLineNum = 1443;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
 //BA.debugLineNum = 1444;BA.debugLine="index_box=2";
_index_box = (int) (2);
 //BA.debugLineNum = 1445;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1446;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1447;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 //BA.debugLineNum = 1448;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1449;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
 //BA.debugLineNum = 1450;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Red";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 1451;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1452;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1456;BA.debugLine="rsPOP_noe.Initialize(\"rsPOP_noe\",lbl_ezaf_taradod";
mostCurrent._rspop_noe.Initialize(mostCurrent.activityBA,"rsPOP_noe",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_ezaf_taradod.getObject())));
 //BA.debugLineNum = 1458;BA.debugLine="rsPOP_noe.AddMenuItem(0,0,\"استحقاقی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (0),(int) (0),"استحقاقی");
 //BA.debugLineNum = 1459;BA.debugLine="rsPOP_noe.AddMenuItem(1,1,\"استعلاجی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (1),(int) (1),"استعلاجی");
 //BA.debugLineNum = 1460;BA.debugLine="rsPOP_noe.AddMenuItem(2,2,\"سایر (با حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (2),(int) (2),"سایر (با حقوق)");
 //BA.debugLineNum = 1461;BA.debugLine="rsPOP_noe.AddMenuItem(3,3,\"سایر (بدون حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (3),(int) (3),"سایر (بدون حقوق)");
 //BA.debugLineNum = 1466;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
 //BA.debugLineNum = 1467;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
 //BA.debugLineNum = 1468;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 1469;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
 //BA.debugLineNum = 1472;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1473;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1475;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 1476;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 1480;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_taradod_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_temp_time2 = null;
 //BA.debugLineNum = 1557;BA.debugLine="Private Sub pan_add_taradod_Click";
 //BA.debugLineNum = 1558;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1559;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1560;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1561;BA.debugLine="lbl_box_title.Text=\"ثبت تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت تردد"));
 //BA.debugLineNum = 1562;BA.debugLine="lbl_time_as.Text=\"ورود :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("ورود :"));
 //BA.debugLineNum = 1563;BA.debugLine="lbl_time_ta.Text=\"خروج :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("خروج :"));
 //BA.debugLineNum = 1564;BA.debugLine="index_box=3";
_index_box = (int) (3);
 //BA.debugLineNum = 1565;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1566;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1567;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1568;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1569;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 1571;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1572;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1573;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1575;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
 //BA.debugLineNum = 1576;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
 //BA.debugLineNum = 1577;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 1578;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
 //BA.debugLineNum = 1581;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1582;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1585;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_time2.txt\")";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time2.txt"))) { 
 //BA.debugLineNum = 1586;BA.debugLine="Dim ls_temp_time2 As List";
_ls_temp_time2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1587;BA.debugLine="ls_temp_time2.Initialize";
_ls_temp_time2.Initialize();
 //BA.debugLineNum = 1588;BA.debugLine="ls_temp_time2=File.ReadList(File.DirInternal,\"te";
_ls_temp_time2 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time2.txt");
 //BA.debugLineNum = 1590;BA.debugLine="lbl_tim1.Text=ls_temp_time2.Get(0)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_temp_time2.Get((int) (0))));
 //BA.debugLineNum = 1591;BA.debugLine="lbl_tim2.Text=ls_temp_time2.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_temp_time2.Get((int) (1))));
 //BA.debugLineNum = 1592;BA.debugLine="time_show";
_time_show();
 }else {
 //BA.debugLineNum = 1594;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 1595;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 1599;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_taradod_fast_click() throws Exception{
 //BA.debugLineNum = 3227;BA.debugLine="Private Sub pan_add_taradod_fast_Click";
 //BA.debugLineNum = 3228;BA.debugLine="pan_all_FT.Visible=True";
mostCurrent._pan_all_ft.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3229;BA.debugLine="lbl_date_FT.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date_ft.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 3230;BA.debugLine="DateTime.TimeFormat = \"HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm");
 //BA.debugLineNum = 3232;BA.debugLine="If(dbCode.isexist_taradod_by_date(lbl_date_FT.Tex";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText())==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 3233;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+mostCurrent._lbl_date_ft.getText()+"';")));
 //BA.debugLineNum = 3234;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 3236;BA.debugLine="lbl_tim_vorod_FT.Text=dbCode.res.GetString(\"time";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")));
 //BA.debugLineNum = 3237;BA.debugLine="lbl_tim_khoroj_FT.Text=dbCode.res.GetString(\"tim";
mostCurrent._lbl_tim_khoroj_ft.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
 //BA.debugLineNum = 3239;BA.debugLine="et_tozihat_FT.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._et_tozihat_ft.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 3241;BA.debugLine="current_id_edit=dbCode.res.GetInt(\"id\")";
_current_id_edit = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("id");
 //BA.debugLineNum = 3242;BA.debugLine="Log(dbCode.res.GetInt(\"state\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("215663119",BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")),0);
 //BA.debugLineNum = 3244;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 3245;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 3248;BA.debugLine="If(dbCode.res.GetInt(\"state\")=10)Then  ''vorod n";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==10)) { 
 //BA.debugLineNum = 3249;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 3250;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 3251;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3252;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3254;BA.debugLine="code_fast_taradod=10";
_code_fast_taradod = (int) (10);
 }else if((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==20)) { 
 //BA.debugLineNum = 3256;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 3257;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 3258;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3259;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3261;BA.debugLine="code_fast_taradod=20";
_code_fast_taradod = (int) (20);
 }else if((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==11)) { 
 //BA.debugLineNum = 3263;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 3264;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 3265;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3266;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3268;BA.debugLine="et_tozihat_FT.Enabled=False";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3270;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
 //BA.debugLineNum = 3271;BA.debugLine="code_fast_taradod=11";
_code_fast_taradod = (int) (11);
 //BA.debugLineNum = 3272;BA.debugLine="ToastMessageShow(\"تردد امروز ثبت شده است\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تردد امروز ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==21)) { 
 //BA.debugLineNum = 3276;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 3277;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 3278;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3279;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3281;BA.debugLine="et_tozihat_FT.Enabled=False";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3283;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
 //BA.debugLineNum = 3285;BA.debugLine="code_fast_taradod=21";
_code_fast_taradod = (int) (21);
 //BA.debugLineNum = 3286;BA.debugLine="ToastMessageShow(\"تردد امروز ثبت شده است\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تردد امروز ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==0)) { 
 //BA.debugLineNum = 3290;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Red";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 3291;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Red";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 3292;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3293;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3295;BA.debugLine="et_tozihat_FT.Enabled=False";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3296;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
 //BA.debugLineNum = 3298;BA.debugLine="ToastMessageShow(\"برای امروز تردد دستی ثبت شده";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برای امروز تردد دستی ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3300;BA.debugLine="code_fast_taradod=0";
_code_fast_taradod = (int) (0);
 };
 }else {
 //BA.debugLineNum = 3303;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 3304;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 3306;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3307;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=True";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3308;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
 //BA.debugLineNum = 3309;BA.debugLine="et_tozihat_FT.Enabled=True";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 3311;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_click() throws Exception{
 //BA.debugLineNum = 1601;BA.debugLine="Private Sub pan_all_Click";
 //BA.debugLineNum = 1602;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1603;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_ft_click() throws Exception{
 //BA.debugLineNum = 3345;BA.debugLine="Private Sub pan_all_FT_Click";
 //BA.debugLineNum = 3346;BA.debugLine="pan_all_FT.Visible=False";
mostCurrent._pan_all_ft.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3347;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_litemenu_click() throws Exception{
 //BA.debugLineNum = 3212;BA.debugLine="Private Sub pan_all_liteMenu_Click";
 //BA.debugLineNum = 3213;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3214;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_msgnewyear_click() throws Exception{
 //BA.debugLineNum = 421;BA.debugLine="Private Sub pan_all_msgNewYear_Click";
 //BA.debugLineNum = 423;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_noskhe_click() throws Exception{
 //BA.debugLineNum = 3160;BA.debugLine="Private Sub pan_all_noskhe_Click";
 //BA.debugLineNum = 3161;BA.debugLine="pan_all_noskhe.Visible=False";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3162;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all2_click() throws Exception{
 //BA.debugLineNum = 2769;BA.debugLine="Private Sub pan_all2_Click";
 //BA.debugLineNum = 2772;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2773;BA.debugLine="End Sub";
return "";
}
public static String  _pan_bime_click() throws Exception{
 //BA.debugLineNum = 3478;BA.debugLine="Private Sub pan_bime_Click";
 //BA.debugLineNum = 3479;BA.debugLine="StartActivity(bime_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._bime_activity.getObject()));
 //BA.debugLineNum = 3481;BA.debugLine="End Sub";
return "";
}
public static String  _pan_calc_click() throws Exception{
 //BA.debugLineNum = 2838;BA.debugLine="Private Sub pan_calc_Click";
 //BA.debugLineNum = 2839;BA.debugLine="StartActivity(calc_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._calc_activity.getObject()));
 //BA.debugLineNum = 2842;BA.debugLine="End Sub";
return "";
}
public static String  _pan_comment_click() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _market = null;
String _url = "";
 //BA.debugLineNum = 2780;BA.debugLine="Private Sub pan_comment_Click";
 //BA.debugLineNum = 2782;BA.debugLine="Try";
try { //BA.debugLineNum = 2783;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2785;BA.debugLine="Try";
try { //BA.debugLineNum = 2786;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 2787;BA.debugLine="Dim url As String";
_url = "";
 //BA.debugLineNum = 2789;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafek";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
 //BA.debugLineNum = 2790;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
 //BA.debugLineNum = 2791;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e10) {
			processBA.setLastException(e10); //BA.debugLineNum = 2794;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
 //BA.debugLineNum = 2797;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e16) {
			processBA.setLastException(e16); //BA.debugLineNum = 2801;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2803;BA.debugLine="Try";
try { //BA.debugLineNum = 2804;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 2805;BA.debugLine="Dim url As String";
_url = "";
 //BA.debugLineNum = 2807;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafe";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
 //BA.debugLineNum = 2808;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
 //BA.debugLineNum = 2809;BA.debugLine="market.SetPackage(\"ir.taravatgroup.ezafekari2\"";
_market.SetPackage("ir.taravatgroup.ezafekari2");
 //BA.debugLineNum = 2810;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e25) {
			processBA.setLastException(e25); //BA.debugLineNum = 2813;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
 //BA.debugLineNum = 2816;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 };
 //BA.debugLineNum = 2823;BA.debugLine="End Sub";
return "";
}
public static String  _pan_darsad_click() throws Exception{
 //BA.debugLineNum = 2775;BA.debugLine="Private Sub pan_darsad_Click";
 //BA.debugLineNum = 2776;BA.debugLine="StartActivity(darsad_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._darsad_activity.getObject()));
 //BA.debugLineNum = 2778;BA.debugLine="End Sub";
return "";
}
public static String  _pan_eidi_click() throws Exception{
 //BA.debugLineNum = 2583;BA.debugLine="Private Sub pan_eidi_Click";
 //BA.debugLineNum = 2584;BA.debugLine="StartActivity(eidi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._eidi_activity.getObject()));
 //BA.debugLineNum = 2586;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ezafekari_mah_click() throws Exception{
 //BA.debugLineNum = 3126;BA.debugLine="Private Sub pan_ezafekari_mah_Click";
 //BA.debugLineNum = 3127;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 //BA.debugLineNum = 3128;BA.debugLine="TabHost1.CurrentTab=0";
mostCurrent._tabhost1.setCurrentTab((int) (0));
 //BA.debugLineNum = 3130;BA.debugLine="End Sub";
return "";
}
public static String  _pan_fast_run_click() throws Exception{
 //BA.debugLineNum = 1397;BA.debugLine="Private Sub pan_fast_run_Click";
 //BA.debugLineNum = 1402;BA.debugLine="StartActivity(fast_run_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._fast_run_activity.getObject()));
 //BA.debugLineNum = 1406;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ganon_click() throws Exception{
 //BA.debugLineNum = 3180;BA.debugLine="Private Sub pan_ganon_Click";
 //BA.debugLineNum = 3181;BA.debugLine="StartActivity(ganon_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ganon_activity.getObject()));
 //BA.debugLineNum = 3183;BA.debugLine="End Sub";
return "";
}
public static String  _pan_help_touch(int _action,float _x,float _y) throws Exception{
 //BA.debugLineNum = 2879;BA.debugLine="Private Sub pan_help_Touch (Action As Int, X As Fl";
 //BA.debugLineNum = 2881;BA.debugLine="If (Action=0)Then";
if ((_action==0)) { 
 //BA.debugLineNum = 2882;BA.debugLine="index_x_start_swap=x";
_index_x_start_swap = (int) (_x);
 //BA.debugLineNum = 2883;BA.debugLine="If (index_curent_img=4)Then";
if ((_index_curent_img==4)) { 
 //BA.debugLineNum = 2884;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 //BA.debugLineNum = 2887;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 2888;BA.debugLine="If(X<(index_x_start_swap-150))Then";
if ((_x<(_index_x_start_swap-150))) { 
 //BA.debugLineNum = 2891;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
 //BA.debugLineNum = 2892;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
 //BA.debugLineNum = 2893;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 }else if((_x>(_index_x_start_swap+150))) { 
 //BA.debugLineNum = 2900;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
 //BA.debugLineNum = 2901;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
 //BA.debugLineNum = 2902;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else if((_index_x_start_swap<(mostCurrent._pan_help.getWidth()/(double)2))) { 
 //BA.debugLineNum = 2908;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
 //BA.debugLineNum = 2909;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
 //BA.debugLineNum = 2910;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else if((_index_x_start_swap>(mostCurrent._pan_help.getWidth()/(double)2))) { 
 //BA.debugLineNum = 2915;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
 //BA.debugLineNum = 2916;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
 //BA.debugLineNum = 2917;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 };
 //BA.debugLineNum = 2922;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 };
 //BA.debugLineNum = 2925;BA.debugLine="End Sub";
return "";
}
public static String  _pan_info_click() throws Exception{
 //BA.debugLineNum = 2593;BA.debugLine="Private Sub pan_info_Click";
 //BA.debugLineNum = 2594;BA.debugLine="StartActivity(info_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._info_activity.getObject()));
 //BA.debugLineNum = 2596;BA.debugLine="End Sub";
return "";
}
public static String  _pan_item_gozaresh_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _ba = null;
 //BA.debugLineNum = 2827;BA.debugLine="Private Sub pan_item_gozaresh_Click";
 //BA.debugLineNum = 2828;BA.debugLine="Dim Ba As Panel = Sender";
_ba = new anywheresoftware.b4a.objects.PanelWrapper();
_ba = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 2830;BA.debugLine="current_gozaresh_id=Ba.Tag";
_current_gozaresh_id = (int)(BA.ObjectToNumber(_ba.getTag()));
 //BA.debugLineNum = 2831;BA.debugLine="StartActivity(show_gozaresh_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._show_gozaresh_activity.getObject()));
 //BA.debugLineNum = 2833;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lelp_click() throws Exception{
 //BA.debugLineNum = 2927;BA.debugLine="Private Sub pan_lelp_Click";
 //BA.debugLineNum = 2929;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lock_click() throws Exception{
 //BA.debugLineNum = 3483;BA.debugLine="Private Sub pan_lock_Click";
 //BA.debugLineNum = 3485;BA.debugLine="End Sub";
return "";
}
public static String  _pan_morakhasi_mah_click() throws Exception{
 //BA.debugLineNum = 3132;BA.debugLine="Private Sub pan_morakhasi_mah_Click";
 //BA.debugLineNum = 3133;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 //BA.debugLineNum = 3134;BA.debugLine="TabHost1.CurrentTab=1";
mostCurrent._tabhost1.setCurrentTab((int) (1));
 //BA.debugLineNum = 3136;BA.debugLine="End Sub";
return "";
}
public static String  _pan_notifi_all_click() throws Exception{
 //BA.debugLineNum = 578;BA.debugLine="Private Sub pan_notifi_all_Click";
 //BA.debugLineNum = 580;BA.debugLine="End Sub";
return "";
}
public static String  _pan_payankar_click() throws Exception{
 //BA.debugLineNum = 2588;BA.debugLine="Private Sub pan_payankar_Click";
 //BA.debugLineNum = 2589;BA.debugLine="StartActivity(payankar_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._payankar_activity.getObject()));
 //BA.debugLineNum = 2591;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_hogog_click() throws Exception{
 //BA.debugLineNum = 1425;BA.debugLine="Private Sub pan_run_hogog_Click";
 //BA.debugLineNum = 1426;BA.debugLine="If (myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 1427;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
 }else {
 //BA.debugLineNum = 1429;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
 //BA.debugLineNum = 1430;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 1435;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_morakhasi_click() throws Exception{
 //BA.debugLineNum = 1414;BA.debugLine="Private Sub pan_run_morakhasi_Click";
 //BA.debugLineNum = 1416;BA.debugLine="StartActivity(morakhasi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._morakhasi_activity.getObject()));
 //BA.debugLineNum = 1423;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_click() throws Exception{
 //BA.debugLineNum = 3185;BA.debugLine="Private Sub pan_setting_Click";
 //BA.debugLineNum = 3186;BA.debugLine="StartActivity(setting_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_activity.getObject()));
 //BA.debugLineNum = 3187;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 3188;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_hogog_click() throws Exception{
 //BA.debugLineNum = 1408;BA.debugLine="Private Sub pan_setting_hogog_Click";
 //BA.debugLineNum = 1409;BA.debugLine="StartActivity(setting_hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_hogog_activity.getObject()));
 //BA.debugLineNum = 1410;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 1412;BA.debugLine="End Sub";
return "";
}
public static String  _pan_shift_click() throws Exception{
 //BA.debugLineNum = 3198;BA.debugLine="Private Sub pan_shift_Click";
 //BA.debugLineNum = 3199;BA.debugLine="StartActivity(shift_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._shift_activity.getObject()));
 //BA.debugLineNum = 3201;BA.debugLine="End Sub";
return "";
}
public static String  _pan_taghvim_click() throws Exception{
 //BA.debugLineNum = 3203;BA.debugLine="Private Sub pan_taghvim_Click";
 //BA.debugLineNum = 3204;BA.debugLine="pan_shift_Click";
_pan_shift_click();
 //BA.debugLineNum = 3205;BA.debugLine="End Sub";
return "";
}
public static String  _panel1_click() throws Exception{
 //BA.debugLineNum = 3216;BA.debugLine="Private Sub Panel1_Click";
 //BA.debugLineNum = 3218;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
 //BA.debugLineNum = 1605;BA.debugLine="Private Sub Panel4_Click";
 //BA.debugLineNum = 1607;BA.debugLine="End Sub";
return "";
}
public static String  _panel5_click() throws Exception{
 //BA.debugLineNum = 3164;BA.debugLine="Private Sub Panel5_Click";
 //BA.debugLineNum = 3166;BA.debugLine="End Sub";
return "";
}
public static String  _panel6_click() throws Exception{
 //BA.debugLineNum = 3458;BA.debugLine="Private Sub Panel6_Click";
 //BA.debugLineNum = 3460;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2463;BA.debugLine="Private Sub pik_day_bala1_Click";
 //BA.debugLineNum = 2464;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 2465;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 2468;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 2469;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 2470;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 2472;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 2473;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 2476;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 2477;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 2479;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 2480;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 2484;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2486;BA.debugLine="Private Sub pik_day_paeen1_Click";
 //BA.debugLineNum = 2487;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 2488;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 2489;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 2490;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 2491;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 2493;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 2494;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 2497;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 2498;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 2500;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 2501;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 2505;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2182;BA.debugLine="Private Sub pik_hour_bala1_Click";
 //BA.debugLineNum = 2184;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
 //BA.debugLineNum = 2185;BA.debugLine="pik_hour1.Text=int1+1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 2187;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
 //BA.debugLineNum = 2188;BA.debugLine="pik_hour1.Text=00";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(00));
 };
 //BA.debugLineNum = 2190;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
 //BA.debugLineNum = 2191;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
 //BA.debugLineNum = 2194;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2196;BA.debugLine="Private Sub pik_hour_paeen1_Click";
 //BA.debugLineNum = 2197;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
 //BA.debugLineNum = 2198;BA.debugLine="pik_hour1.Text=int1-1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 2200;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
 //BA.debugLineNum = 2201;BA.debugLine="pik_hour1.Text=00";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(00));
 };
 //BA.debugLineNum = 2203;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
 //BA.debugLineNum = 2204;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
 //BA.debugLineNum = 2207;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2209;BA.debugLine="Private Sub pik_min_bala1_Click";
 //BA.debugLineNum = 2210;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
 //BA.debugLineNum = 2211;BA.debugLine="pik_min1.Text=int1+1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 2213;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
 //BA.debugLineNum = 2214;BA.debugLine="pik_min1.Text=00";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(00));
 };
 //BA.debugLineNum = 2216;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
 //BA.debugLineNum = 2217;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
 //BA.debugLineNum = 2220;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2222;BA.debugLine="Private Sub pik_min_paeen1_Click";
 //BA.debugLineNum = 2223;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
 //BA.debugLineNum = 2224;BA.debugLine="pik_min1.Text=int1-1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 2226;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
 //BA.debugLineNum = 2227;BA.debugLine="pik_min1.Text=00";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(00));
 };
 //BA.debugLineNum = 2229;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
 //BA.debugLineNum = 2230;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
 //BA.debugLineNum = 2233;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2409;BA.debugLine="Private Sub pik_moon_bala1_Click";
 //BA.debugLineNum = 2410;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 2411;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
 //BA.debugLineNum = 2413;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 2414;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 2416;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 2417;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 2419;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 2421;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2423;BA.debugLine="Private Sub pik_moon_paeen1_Click";
 //BA.debugLineNum = 2424;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 2425;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
 //BA.debugLineNum = 2427;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 2428;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 2430;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 2431;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 2433;BA.debugLine="pik_moon1.Text=moon.Get(myfunc.fa2en(pik_moon1.Ta";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
 //BA.debugLineNum = 2435;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2369;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
 //BA.debugLineNum = 2370;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 2371;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 2372;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2375;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 2377;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 2378;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
 //BA.debugLineNum = 2379;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 2380;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2382;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 2383;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
 //BA.debugLineNum = 2384;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 2385;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2388;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 2389;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 2390;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 2392;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 2393;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 2396;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 2397;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 2399;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 2400;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 };
 //BA.debugLineNum = 2407;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_hour1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2235;BA.debugLine="Private Sub pik_pan_hour1_Touch (Action As Int, X";
 //BA.debugLineNum = 2236;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 2237;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 2238;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2241;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 2243;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 2244;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))-1);
 //BA.debugLineNum = 2245;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 2246;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2248;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 2249;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))+1);
 //BA.debugLineNum = 2250;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 2251;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2254;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
 //BA.debugLineNum = 2255;BA.debugLine="pik_hour1.Text=00";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(00));
 };
 //BA.debugLineNum = 2257;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
 //BA.debugLineNum = 2258;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
 };
 //BA.debugLineNum = 2263;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_min1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2265;BA.debugLine="Private Sub pik_pan_min1_Touch (Action As Int, X A";
 //BA.debugLineNum = 2266;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 2267;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 2268;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2271;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 2273;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 2275;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))-1);
 //BA.debugLineNum = 2276;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 2279;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2281;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 2283;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))+1);
 //BA.debugLineNum = 2284;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 2287;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2291;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
 //BA.debugLineNum = 2292;BA.debugLine="pik_min1.Text=00";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(00));
 };
 //BA.debugLineNum = 2295;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
 //BA.debugLineNum = 2296;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
 };
 //BA.debugLineNum = 2303;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2309;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
 //BA.debugLineNum = 2310;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 2311;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 2312;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2315;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 2317;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 2318;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
 //BA.debugLineNum = 2319;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 2320;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2322;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 2323;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
 //BA.debugLineNum = 2324;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 2325;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2328;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 2329;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 2331;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 2332;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 2334;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
 //BA.debugLineNum = 2337;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2339;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
 //BA.debugLineNum = 2340;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 2341;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 2342;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2345;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 2347;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 2348;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
 //BA.debugLineNum = 2349;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 2350;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2352;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 2353;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
 //BA.debugLineNum = 2354;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 2355;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2358;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 2359;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 2361;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 2362;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
 //BA.debugLineNum = 2367;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2437;BA.debugLine="Private Sub pik_year_bala1_Click";
 //BA.debugLineNum = 2438;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 2439;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 2441;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 2442;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 2444;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 2445;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 2448;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2450;BA.debugLine="Private Sub pik_year_paeen1_Click";
 //BA.debugLineNum = 2451;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 2452;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 2454;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 2455;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 2457;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 2458;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 2461;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4a.example.dateutils._process_globals();
main._process_globals();
myfunc._process_globals();
dbcode._process_globals();
setting_activity._process_globals();
bime_activity._process_globals();
calc_activity._process_globals();
comment_activity._process_globals();
darsad_activity._process_globals();
eidi_activity._process_globals();
fast_run_activity._process_globals();
ganon_activity._process_globals();
hogog_activity._process_globals();
info_activity._process_globals();
morakhasi_activity._process_globals();
payankar_activity._process_globals();
setting_hogog_activity._process_globals();
shift_activity._process_globals();
show_gozaresh_activity._process_globals();
starter._process_globals();
httputils2service._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 20;BA.debugLine="Dim app_vesion As String=Application.VersionName";
_app_vesion = anywheresoftware.b4a.keywords.Common.Application.getVersionName();
 //BA.debugLineNum = 21;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 22;BA.debugLine="Dim timer1 As Timer";
_timer1 = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 23;BA.debugLine="Dim tim_msg As Timer";
_tim_msg = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 25;BA.debugLine="Dim tim_lock_lbl As Timer";
_tim_lock_lbl = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 28;BA.debugLine="Dim current_gozaresh_id As Int";
_current_gozaresh_id = 0;
 //BA.debugLineNum = 29;BA.debugLine="Dim persianDate As ManamPersianDate";
_persiandate = new com.b4a.manamsoftware.PersianDate.ManamPersianDate();
 //BA.debugLineNum = 31;BA.debugLine="Dim year_num As String";
_year_num = "";
 //BA.debugLineNum = 32;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 35;BA.debugLine="Dim phon As Phone";
_phon = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 37;BA.debugLine="Dim buy_index As Int";
_buy_index = 0;
 //BA.debugLineNum = 39;BA.debugLine="Dim time_page_load As Timer";
_time_page_load = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 41;BA.debugLine="Dim color_index As Int=1";
_color_index = (int) (1);
 //BA.debugLineNum = 42;BA.debugLine="Dim color1 As Int=0XFF69AC00   ' hed home1";
_color1 = ((int)0xff69ac00);
 //BA.debugLineNum = 43;BA.debugLine="Dim color2 As Int=0xFF00C7C7	' hed home2";
_color2 = ((int)0xff00c7c7);
 //BA.debugLineNum = 44;BA.debugLine="Dim color3 As Int=0XFFFFFFFF	' hed home3 font";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 45;BA.debugLine="Dim color4 As Int=0XFF69AC00	' all head";
_color4 = ((int)0xff69ac00);
 //BA.debugLineNum = 46;BA.debugLine="Dim color5 As Int=0XFF69AC00	' calc";
_color5 = ((int)0xff69ac00);
 //BA.debugLineNum = 48;BA.debugLine="Dim main_font As String=\"یکان\"";
_main_font = "یکان";
 //BA.debugLineNum = 49;BA.debugLine="Dim size_f1 As Int=17";
_size_f1 = (int) (17);
 //BA.debugLineNum = 50;BA.debugLine="Dim size_f2 As Int=15";
_size_f2 = (int) (15);
 //BA.debugLineNum = 51;BA.debugLine="Dim size_f3 As Int=13";
_size_f3 = (int) (13);
 //BA.debugLineNum = 53;BA.debugLine="Dim saat_kar_min As Int";
_saat_kar_min = 0;
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public static String  _resetting_all() throws Exception{
 //BA.debugLineNum = 800;BA.debugLine="Sub resetting_all";
 //BA.debugLineNum = 802;BA.debugLine="key1.color = Colors.White";
mostCurrent._key1.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 803;BA.debugLine="key2.Color = Colors.White";
mostCurrent._key2.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 804;BA.debugLine="key3.Color = Colors.White";
mostCurrent._key3.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 805;BA.debugLine="key4.Color = Colors.white";
mostCurrent._key4.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 808;BA.debugLine="entered_Password = \"\"";
mostCurrent._entered_password = "";
 //BA.debugLineNum = 812;BA.debugLine="Click_Count = 0";
_click_count = (int) (0);
 //BA.debugLineNum = 813;BA.debugLine="End Sub";
return "";
}
public static boolean  _rspop_noe_menuitemclick(int _itemid) throws Exception{
 //BA.debugLineNum = 1489;BA.debugLine="Sub rsPOP_noe_MenuItemClick (ItemId As Int) As Boo";
 //BA.debugLineNum = 1491;BA.debugLine="Select ItemId";
switch (_itemid) {
case 0: {
 //BA.debugLineNum = 1493;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
 //BA.debugLineNum = 1495;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
 //BA.debugLineNum = 1497;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
 //BA.debugLineNum = 1499;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
 //BA.debugLineNum = 1503;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
 //BA.debugLineNum = 1504;BA.debugLine="index_noe_morakhasi=ItemId";
_index_noe_morakhasi = _itemid;
 //BA.debugLineNum = 1505;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1506;BA.debugLine="End Sub";
return false;
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 2550;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
 //BA.debugLineNum = 2551;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 2552;BA.debugLine="Select sp_moon.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_moon.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11))) {
case 0: {
 //BA.debugLineNum = 2554;BA.debugLine="moon_num=\"01\"";
_moon_num = "01";
 break; }
case 1: {
 //BA.debugLineNum = 2556;BA.debugLine="moon_num=\"02\"";
_moon_num = "02";
 break; }
case 2: {
 //BA.debugLineNum = 2558;BA.debugLine="moon_num=\"03\"";
_moon_num = "03";
 break; }
case 3: {
 //BA.debugLineNum = 2560;BA.debugLine="moon_num=\"04\"";
_moon_num = "04";
 break; }
case 4: {
 //BA.debugLineNum = 2562;BA.debugLine="moon_num=\"05\"";
_moon_num = "05";
 break; }
case 5: {
 //BA.debugLineNum = 2564;BA.debugLine="moon_num=\"06\"";
_moon_num = "06";
 break; }
case 6: {
 //BA.debugLineNum = 2566;BA.debugLine="moon_num=\"07\"";
_moon_num = "07";
 break; }
case 7: {
 //BA.debugLineNum = 2568;BA.debugLine="moon_num=\"08\"";
_moon_num = "08";
 break; }
case 8: {
 //BA.debugLineNum = 2570;BA.debugLine="moon_num=\"09\"";
_moon_num = "09";
 break; }
case 9: {
 //BA.debugLineNum = 2572;BA.debugLine="moon_num=\"10\"";
_moon_num = "10";
 break; }
case 10: {
 //BA.debugLineNum = 2574;BA.debugLine="moon_num=\"11\"";
_moon_num = "11";
 break; }
case 11: {
 //BA.debugLineNum = 2576;BA.debugLine="moon_num=\"12\"";
_moon_num = "12";
 break; }
}
;
 //BA.debugLineNum = 2579;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
 //BA.debugLineNum = 2580;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
 //BA.debugLineNum = 2581;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_gozaresh_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 3220;BA.debugLine="Private Sub sp_year_gozaresh_ItemClick (Position A";
 //BA.debugLineNum = 3221;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
 //BA.debugLineNum = 3222;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 2512;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
 //BA.debugLineNum = 2517;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 2518;BA.debugLine="Select sp_moon.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_moon.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11))) {
case 0: {
 //BA.debugLineNum = 2520;BA.debugLine="moon_num=\"01\"";
_moon_num = "01";
 break; }
case 1: {
 //BA.debugLineNum = 2522;BA.debugLine="moon_num=\"02\"";
_moon_num = "02";
 break; }
case 2: {
 //BA.debugLineNum = 2524;BA.debugLine="moon_num=\"03\"";
_moon_num = "03";
 break; }
case 3: {
 //BA.debugLineNum = 2526;BA.debugLine="moon_num=\"04\"";
_moon_num = "04";
 break; }
case 4: {
 //BA.debugLineNum = 2528;BA.debugLine="moon_num=\"05\"";
_moon_num = "05";
 break; }
case 5: {
 //BA.debugLineNum = 2530;BA.debugLine="moon_num=\"06\"";
_moon_num = "06";
 break; }
case 6: {
 //BA.debugLineNum = 2532;BA.debugLine="moon_num=\"07\"";
_moon_num = "07";
 break; }
case 7: {
 //BA.debugLineNum = 2534;BA.debugLine="moon_num=\"08\"";
_moon_num = "08";
 break; }
case 8: {
 //BA.debugLineNum = 2536;BA.debugLine="moon_num=\"09\"";
_moon_num = "09";
 break; }
case 9: {
 //BA.debugLineNum = 2538;BA.debugLine="moon_num=\"10\"";
_moon_num = "10";
 break; }
case 10: {
 //BA.debugLineNum = 2540;BA.debugLine="moon_num=\"11\"";
_moon_num = "11";
 break; }
case 11: {
 //BA.debugLineNum = 2542;BA.debugLine="moon_num=\"12\"";
_moon_num = "12";
 break; }
}
;
 //BA.debugLineNum = 2544;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
 //BA.debugLineNum = 2546;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
 //BA.debugLineNum = 2548;BA.debugLine="End Sub";
return "";
}
public static String  _tabhost1_tabchanged() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_all_saat = null;
String _str_saat = "";
 //BA.debugLineNum = 1109;BA.debugLine="Private Sub TabHost1_TabChanged";
 //BA.debugLineNum = 1111;BA.debugLine="Dim ls_all_saat As List";
_ls_all_saat = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1112;BA.debugLine="ls_all_saat.Initialize";
_ls_all_saat.Initialize();
 //BA.debugLineNum = 1113;BA.debugLine="Dim str_saat As String";
_str_saat = "";
 //BA.debugLineNum = 1115;BA.debugLine="If(sp_year.IsInitialized)Then";
if ((mostCurrent._sp_year.IsInitialized())) { 
 //BA.debugLineNum = 1121;BA.debugLine="Select TabHost1.CurrentTab";
switch (BA.switchObjectToInt(mostCurrent._tabhost1.getCurrentTab(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 1123;BA.debugLine="ls_all_saat=dbCode.all_ezafekari_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
 //BA.debugLineNum = 1124;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
case 1: {
 //BA.debugLineNum = 1126;BA.debugLine="ls_all_saat=dbCode.all_morakhasi_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 //BA.debugLineNum = 1128;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" روز و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" ساعت و "+BA.ObjectToString(_ls_all_saat.Get((int) (2)))+" دقیقه ";
 break; }
case 2: {
 //BA.debugLineNum = 1130;BA.debugLine="ls_all_saat=dbCode.all_taradod_mah(myfunc.fa2e";
_ls_all_saat = mostCurrent._dbcode._all_taradod_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 //BA.debugLineNum = 1131;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
}
;
 //BA.debugLineNum = 1138;BA.debugLine="lbl_majmoe_saat.Text=str_saat";
mostCurrent._lbl_majmoe_saat.setText(BA.ObjectToCharSequence(_str_saat));
 };
 //BA.debugLineNum = 1144;BA.debugLine="End Sub";
return "";
}
public static String  _tim_lock_lbl_tick() throws Exception{
 //BA.debugLineNum = 683;BA.debugLine="Sub tim_lock_lbl_Tick";
 //BA.debugLineNum = 684;BA.debugLine="If(stat_finger=0)Then";
if ((_stat_finger==0)) { 
 //BA.debugLineNum = 685;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
mostCurrent._lbl_finger.setTextColor(((int)0xff0b6200));
 //BA.debugLineNum = 686;BA.debugLine="stat_finger=1";
_stat_finger = (int) (1);
 }else {
 //BA.debugLineNum = 688;BA.debugLine="lbl_finger.TextColor=0xFF2FFF00";
mostCurrent._lbl_finger.setTextColor(((int)0xff2fff00));
 //BA.debugLineNum = 689;BA.debugLine="stat_finger=0";
_stat_finger = (int) (0);
 };
 //BA.debugLineNum = 691;BA.debugLine="End Sub";
return "";
}
public static String  _tim_msg_tick() throws Exception{
String _msg_key = "";
String _msg_value = "";
 //BA.debugLineNum = 514;BA.debugLine="Sub tim_msg_Tick";
 //BA.debugLineNum = 516;BA.debugLine="Dim msg_key As String";
_msg_key = "";
 //BA.debugLineNum = 517;BA.debugLine="Dim msg_value As String";
_msg_value = "";
 //BA.debugLineNum = 520;BA.debugLine="msg_key=msg.SubString2(0,4)";
_msg_key = mostCurrent._msg.substring((int) (0),(int) (4));
 //BA.debugLineNum = 521;BA.debugLine="msg_value=msg.SubString(5)";
_msg_value = mostCurrent._msg.substring((int) (5));
 //BA.debugLineNum = 523;BA.debugLine="ls1.Add(msg_key)";
mostCurrent._ls1.Add((Object)(_msg_key));
 //BA.debugLineNum = 524;BA.debugLine="ls2.Add(msg_value)";
mostCurrent._ls2.Add((Object)(_msg_value));
 //BA.debugLineNum = 525;BA.debugLine="ls3.Add(lbl_date_home.Text)";
mostCurrent._ls3.Add((Object)(mostCurrent._lbl_date_home.getText()));
 //BA.debugLineNum = 527;BA.debugLine="File.WriteList(File.DirInternal,\"ls1\",ls1)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1",mostCurrent._ls1);
 //BA.debugLineNum = 528;BA.debugLine="File.WriteList(File.DirInternal,\"ls2\",ls2)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls2",mostCurrent._ls2);
 //BA.debugLineNum = 529;BA.debugLine="File.WriteList(File.DirInternal,\"ls3\",ls3)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls3",mostCurrent._ls3);
 //BA.debugLineNum = 531;BA.debugLine="lbl_title_msgPan.Text=\"پیام جدید\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام جدید"));
 //BA.debugLineNum = 532;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 534;BA.debugLine="pan_notif.Top=20%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 535;BA.debugLine="pan_notif.Height=50%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA));
 //BA.debugLineNum = 536;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
 //BA.debugLineNum = 539;BA.debugLine="web_msg_show.LoadHtml(\"<!DOCTYPE html><html><meta";
mostCurrent._web_msg_show.LoadHtml("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'><div style='background-color: #99ffff; font-size: 14px;'>"+"کد پیام : "+_msg_key+" - مورخ : "+mostCurrent._lbl_date_home.getText()+"</div><div style='background-color: #e6ffff; font-size: 18px;'><br>"+_msg_value+"<br></div><br></body></html>");
 //BA.debugLineNum = 541;BA.debugLine="tim_msg.Enabled=False";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 542;BA.debugLine="End Sub";
return "";
}
public static int  _tim_vorod_conv_ezaf(String _tim1) throws Exception{
String[] _ste_tim = null;
 //BA.debugLineNum = 3462;BA.debugLine="Sub tim_vorod_conv_ezaf (tim1 As String) As Int";
 //BA.debugLineNum = 3464;BA.debugLine="Dim ste_tim() As String";
_ste_tim = new String[(int) (0)];
java.util.Arrays.fill(_ste_tim,"");
 //BA.debugLineNum = 3465;BA.debugLine="ste_tim=Regex.Split(\":\",tim1)";
_ste_tim = anywheresoftware.b4a.keywords.Common.Regex.Split(":",_tim1);
 //BA.debugLineNum = 3468;BA.debugLine="Return (ste_tim(0)*60)+ste_tim(1) +saat_kar_min";
if (true) return (int) (((double)(Double.parseDouble(_ste_tim[(int) (0)]))*60)+(double)(Double.parseDouble(_ste_tim[(int) (1)]))+_saat_kar_min);
 //BA.debugLineNum = 3471;BA.debugLine="End Sub";
return 0;
}
public static String  _time_show() throws Exception{
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
 //BA.debugLineNum = 1930;BA.debugLine="Sub time_show";
 //BA.debugLineNum = 1932;BA.debugLine="Try";
try { //BA.debugLineNum = 1935;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1936;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1937;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
 //BA.debugLineNum = 1938;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
 //BA.debugLineNum = 1940;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
 //BA.debugLineNum = 1941;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
 //BA.debugLineNum = 1942;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 1943;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 1945;BA.debugLine="Select pik_moon1.Tag";
switch (BA.switchObjectToInt(mostCurrent._pik_moon1.getTag(),(Object)(1),(Object)(2),(Object)(3),(Object)(4),(Object)(5),(Object)(6),(Object)(7),(Object)(8),(Object)(9),(Object)(10),(Object)(11),(Object)(12))) {
case 0: {
 //BA.debugLineNum = 1947;BA.debugLine="pik_moon1.Tag=\"01\"";
mostCurrent._pik_moon1.setTag((Object)("01"));
 break; }
case 1: {
 //BA.debugLineNum = 1949;BA.debugLine="pik_moon1.Tag=\"02\"";
mostCurrent._pik_moon1.setTag((Object)("02"));
 break; }
case 2: {
 //BA.debugLineNum = 1951;BA.debugLine="pik_moon1.Tag=\"03\"";
mostCurrent._pik_moon1.setTag((Object)("03"));
 break; }
case 3: {
 //BA.debugLineNum = 1953;BA.debugLine="pik_moon1.Tag=\"04\"";
mostCurrent._pik_moon1.setTag((Object)("04"));
 break; }
case 4: {
 //BA.debugLineNum = 1955;BA.debugLine="pik_moon1.Tag=\"05\"";
mostCurrent._pik_moon1.setTag((Object)("05"));
 break; }
case 5: {
 //BA.debugLineNum = 1957;BA.debugLine="pik_moon1.Tag=\"06\"";
mostCurrent._pik_moon1.setTag((Object)("06"));
 break; }
case 6: {
 //BA.debugLineNum = 1959;BA.debugLine="pik_moon1.Tag=\"07\"";
mostCurrent._pik_moon1.setTag((Object)("07"));
 break; }
case 7: {
 //BA.debugLineNum = 1961;BA.debugLine="pik_moon1.Tag=\"08\"";
mostCurrent._pik_moon1.setTag((Object)("08"));
 break; }
case 8: {
 //BA.debugLineNum = 1963;BA.debugLine="pik_moon1.Tag=\"09\"";
mostCurrent._pik_moon1.setTag((Object)("09"));
 break; }
case 9: {
 //BA.debugLineNum = 1965;BA.debugLine="pik_moon1.Tag=\"10\"";
mostCurrent._pik_moon1.setTag((Object)("10"));
 break; }
case 10: {
 //BA.debugLineNum = 1967;BA.debugLine="pik_moon1.Tag=\"11\"";
mostCurrent._pik_moon1.setTag((Object)("11"));
 break; }
case 11: {
 //BA.debugLineNum = 1969;BA.debugLine="pik_moon1.Tag=\"12\"";
mostCurrent._pik_moon1.setTag((Object)("12"));
 break; }
}
;
 //BA.debugLineNum = 1975;BA.debugLine="date1=lbl_date1.Text";
mostCurrent._date1 = mostCurrent._lbl_date1.getText();
 //BA.debugLineNum = 1976;BA.debugLine="date2=lbl_date2.Text";
mostCurrent._date2 = mostCurrent._lbl_date2.getText();
 //BA.debugLineNum = 1977;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
 //BA.debugLineNum = 1978;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
 //BA.debugLineNum = 1982;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_dat";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
 //BA.debugLineNum = 1983;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_dat";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
 //BA.debugLineNum = 1986;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
 //BA.debugLineNum = 1987;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
 //BA.debugLineNum = 1990;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
 //BA.debugLineNum = 1991;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
 //BA.debugLineNum = 1993;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date_";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
 //BA.debugLineNum = 1994;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date_";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
 //BA.debugLineNum = 1996;BA.debugLine="time_end2=lbl_tim2.Text&\":00\"";
_time_end2 = mostCurrent._lbl_tim2.getText()+":00";
 //BA.debugLineNum = 1997;BA.debugLine="time_end1=lbl_tim1.Text&\":00\"";
_time_end1 = mostCurrent._lbl_tim1.getText()+":00";
 //BA.debugLineNum = 1999;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
 //BA.debugLineNum = 2000;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
 //BA.debugLineNum = 2001;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
 //BA.debugLineNum = 2002;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
 //BA.debugLineNum = 2006;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
 //BA.debugLineNum = 2007;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
 //BA.debugLineNum = 2010;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 2011;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
 //BA.debugLineNum = 2013;BA.debugLine="If (period_between.Years<>0)Then";
if ((_period_between.Years!=0)) { 
 //BA.debugLineNum = 2014;BA.debugLine="str_show.Append(period_between.Years&\" سال \").A";
_str_show.Append(BA.NumberToString(_period_between.Years)+" سال ").Append(" و ");
 };
 //BA.debugLineNum = 2016;BA.debugLine="If (period_between.Months<>0)Then";
if ((_period_between.Months!=0)) { 
 //BA.debugLineNum = 2017;BA.debugLine="str_show.Append(period_between.Months&\" ماه \").";
_str_show.Append(BA.NumberToString(_period_between.Months)+" ماه ").Append(" و ");
 };
 //BA.debugLineNum = 2019;BA.debugLine="If (period_between.Days<>0)Then";
if ((_period_between.Days!=0)) { 
 //BA.debugLineNum = 2020;BA.debugLine="str_show.Append(period_between.Days&\" روز \").Ap";
_str_show.Append(BA.NumberToString(_period_between.Days)+" روز ").Append(" و ");
 };
 //BA.debugLineNum = 2023;BA.debugLine="str_show.Append(period_between.Hours&\" ساعت \").A";
_str_show.Append(BA.NumberToString(_period_between.Hours)+" ساعت ").Append(" و ");
 //BA.debugLineNum = 2024;BA.debugLine="str_show.Append(period_between.Minutes&\" دقیقه \"";
_str_show.Append(BA.NumberToString(_period_between.Minutes)+" دقیقه ");
 //BA.debugLineNum = 2027;BA.debugLine="year_bt=period_between.Years";
_year_bt = _period_between.Years;
 //BA.debugLineNum = 2028;BA.debugLine="moon_bt=period_between.Months";
_moon_bt = _period_between.Months;
 //BA.debugLineNum = 2029;BA.debugLine="day_bt=period_between.Days";
_day_bt = _period_between.Days;
 //BA.debugLineNum = 2030;BA.debugLine="hour_bt=period_between.Hours";
_hour_bt = _period_between.Hours;
 //BA.debugLineNum = 2031;BA.debugLine="min_bt=period_between.Minutes";
_min_bt = _period_between.Minutes;
 //BA.debugLineNum = 2034;BA.debugLine="lbl_time_show.Text=str_show";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(_str_show.getObject()));
 //BA.debugLineNum = 2035;BA.debugLine="If(index_box=3)Then";
if ((_index_box==3)) { 
 //BA.debugLineNum = 2037;BA.debugLine="tim_min=(hour_bt*60)+min_bt";
_tim_min = (int) ((_hour_bt*60)+_min_bt);
 //BA.debugLineNum = 2041;BA.debugLine="If(tim_min>saat_kar_min) Then";
if ((_tim_min>_saat_kar_min)) { 
 //BA.debugLineNum = 2042;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2046;BA.debugLine="lbl_ezaf_taradod.Text=\"افزودن به اضافه کاری \"&";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("افزودن به اضافه کاری "+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (0))))+" ساعت و "+BA.ObjectToString(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (1)))+" دقیقه "));
 }else {
 //BA.debugLineNum = 2050;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2051;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 } 
       catch (Exception e86) {
			processBA.setLastException(e86); //BA.debugLineNum = 2059;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 2061;BA.debugLine="End Sub";
return "";
}
public static String  _time_show2(String _dat1,String _dat2,String _tim1,String _tim2) throws Exception{
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
 //BA.debugLineNum = 2065;BA.debugLine="Sub time_show2 (dat1 As String,dat2 As String, tim";
 //BA.debugLineNum = 2067;BA.debugLine="Try";
try { //BA.debugLineNum = 2070;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2071;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2072;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
 //BA.debugLineNum = 2073;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
 //BA.debugLineNum = 2075;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
 //BA.debugLineNum = 2076;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
 //BA.debugLineNum = 2077;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 2078;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 2080;BA.debugLine="Select pik_moon1.Tag";
switch (BA.switchObjectToInt(mostCurrent._pik_moon1.getTag(),(Object)(1),(Object)(2),(Object)(3),(Object)(4),(Object)(5),(Object)(6),(Object)(7),(Object)(8),(Object)(9),(Object)(10),(Object)(11),(Object)(12))) {
case 0: {
 //BA.debugLineNum = 2082;BA.debugLine="pik_moon1.Tag=\"01\"";
mostCurrent._pik_moon1.setTag((Object)("01"));
 break; }
case 1: {
 //BA.debugLineNum = 2084;BA.debugLine="pik_moon1.Tag=\"02\"";
mostCurrent._pik_moon1.setTag((Object)("02"));
 break; }
case 2: {
 //BA.debugLineNum = 2086;BA.debugLine="pik_moon1.Tag=\"03\"";
mostCurrent._pik_moon1.setTag((Object)("03"));
 break; }
case 3: {
 //BA.debugLineNum = 2088;BA.debugLine="pik_moon1.Tag=\"04\"";
mostCurrent._pik_moon1.setTag((Object)("04"));
 break; }
case 4: {
 //BA.debugLineNum = 2090;BA.debugLine="pik_moon1.Tag=\"05\"";
mostCurrent._pik_moon1.setTag((Object)("05"));
 break; }
case 5: {
 //BA.debugLineNum = 2092;BA.debugLine="pik_moon1.Tag=\"06\"";
mostCurrent._pik_moon1.setTag((Object)("06"));
 break; }
case 6: {
 //BA.debugLineNum = 2094;BA.debugLine="pik_moon1.Tag=\"07\"";
mostCurrent._pik_moon1.setTag((Object)("07"));
 break; }
case 7: {
 //BA.debugLineNum = 2096;BA.debugLine="pik_moon1.Tag=\"08\"";
mostCurrent._pik_moon1.setTag((Object)("08"));
 break; }
case 8: {
 //BA.debugLineNum = 2098;BA.debugLine="pik_moon1.Tag=\"09\"";
mostCurrent._pik_moon1.setTag((Object)("09"));
 break; }
case 9: {
 //BA.debugLineNum = 2100;BA.debugLine="pik_moon1.Tag=\"10\"";
mostCurrent._pik_moon1.setTag((Object)("10"));
 break; }
case 10: {
 //BA.debugLineNum = 2102;BA.debugLine="pik_moon1.Tag=\"11\"";
mostCurrent._pik_moon1.setTag((Object)("11"));
 break; }
case 11: {
 //BA.debugLineNum = 2104;BA.debugLine="pik_moon1.Tag=\"12\"";
mostCurrent._pik_moon1.setTag((Object)("12"));
 break; }
}
;
 //BA.debugLineNum = 2110;BA.debugLine="date1=dat1";
mostCurrent._date1 = _dat1;
 //BA.debugLineNum = 2111;BA.debugLine="date2=dat2";
mostCurrent._date2 = _dat2;
 //BA.debugLineNum = 2112;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
 //BA.debugLineNum = 2113;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
 //BA.debugLineNum = 2117;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_dat";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
 //BA.debugLineNum = 2118;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_dat";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
 //BA.debugLineNum = 2121;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
 //BA.debugLineNum = 2122;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
 //BA.debugLineNum = 2125;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
 //BA.debugLineNum = 2126;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
 //BA.debugLineNum = 2128;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date_";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
 //BA.debugLineNum = 2129;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date_";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
 //BA.debugLineNum = 2131;BA.debugLine="time_end2=tim2&\":00\"";
_time_end2 = _tim2+":00";
 //BA.debugLineNum = 2132;BA.debugLine="time_end1=tim1&\":00\"";
_time_end1 = _tim1+":00";
 //BA.debugLineNum = 2134;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
 //BA.debugLineNum = 2135;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
 //BA.debugLineNum = 2136;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
 //BA.debugLineNum = 2137;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
 //BA.debugLineNum = 2141;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
 //BA.debugLineNum = 2142;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
 //BA.debugLineNum = 2145;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 2146;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
 //BA.debugLineNum = 2148;BA.debugLine="If (period_between.Years<>0)Then";
if ((_period_between.Years!=0)) { 
 //BA.debugLineNum = 2149;BA.debugLine="str_show.Append(period_between.Years&\" سال \").A";
_str_show.Append(BA.NumberToString(_period_between.Years)+" سال ").Append(" و ");
 };
 //BA.debugLineNum = 2151;BA.debugLine="If (period_between.Months<>0)Then";
if ((_period_between.Months!=0)) { 
 //BA.debugLineNum = 2152;BA.debugLine="str_show.Append(period_between.Months&\" ماه \").";
_str_show.Append(BA.NumberToString(_period_between.Months)+" ماه ").Append(" و ");
 };
 //BA.debugLineNum = 2154;BA.debugLine="If (period_between.Days<>0)Then";
if ((_period_between.Days!=0)) { 
 //BA.debugLineNum = 2155;BA.debugLine="str_show.Append(period_between.Days&\" روز \").Ap";
_str_show.Append(BA.NumberToString(_period_between.Days)+" روز ").Append(" و ");
 };
 //BA.debugLineNum = 2158;BA.debugLine="str_show.Append(period_between.Hours&\" ساعت \").A";
_str_show.Append(BA.NumberToString(_period_between.Hours)+" ساعت ").Append(" و ");
 //BA.debugLineNum = 2159;BA.debugLine="str_show.Append(period_between.Minutes&\" دقیقه \"";
_str_show.Append(BA.NumberToString(_period_between.Minutes)+" دقیقه ");
 //BA.debugLineNum = 2162;BA.debugLine="year_bt=period_between.Years";
_year_bt = _period_between.Years;
 //BA.debugLineNum = 2163;BA.debugLine="moon_bt=period_between.Months";
_moon_bt = _period_between.Months;
 //BA.debugLineNum = 2164;BA.debugLine="day_bt=period_between.Days";
_day_bt = _period_between.Days;
 //BA.debugLineNum = 2165;BA.debugLine="hour_bt=period_between.Hours";
_hour_bt = _period_between.Hours;
 //BA.debugLineNum = 2166;BA.debugLine="min_bt=period_between.Minutes";
_min_bt = _period_between.Minutes;
 //BA.debugLineNum = 2169;BA.debugLine="lbl_time_show_FT.Text=str_show";
mostCurrent._lbl_time_show_ft.setText(BA.ObjectToCharSequence(_str_show.getObject()));
 } 
       catch (Exception e76) {
			processBA.setLastException(e76); //BA.debugLineNum = 2172;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 2174;BA.debugLine="End Sub";
return "";
}
public static String  _timer1_tick() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_lock0 = null;
 //BA.debugLineNum = 626;BA.debugLine="Sub timer1_Tick";
 //BA.debugLineNum = 628;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 629;BA.debugLine="timer1.Enabled=False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 630;BA.debugLine="cv_loader.Hide";
mostCurrent._cv_loader._hide /*String*/ ();
 //BA.debugLineNum = 631;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 //BA.debugLineNum = 637;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=True)T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 638;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 639;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
 //BA.debugLineNum = 640;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_lock";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
 //BA.debugLineNum = 642;BA.debugLine="If(ls_lock0.Get(0)=\"true\")Then";
if (((_ls_lock0.Get((int) (0))).equals((Object)("true")))) { 
 //BA.debugLineNum = 643;BA.debugLine="Master_Password=ls_lock0.Get(2)";
mostCurrent._master_password = BA.ObjectToString(_ls_lock0.Get((int) (2)));
 //BA.debugLineNum = 644;BA.debugLine="pan_lock.Visible=True";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 645;BA.debugLine="lbl_hint_lock.Text=ls_lock0.Get(3)";
mostCurrent._lbl_hint_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (3))));
 //BA.debugLineNum = 647;BA.debugLine="If(ls_lock0.Get(1)=\"true\")Then";
if (((_ls_lock0.Get((int) (1))).equals((Object)("true")))) { 
 //BA.debugLineNum = 649;BA.debugLine="tim_lock_lbl.Initialize(\"tim_lock_lbl\",500)";
_tim_lock_lbl.Initialize(processBA,"tim_lock_lbl",(long) (500));
 //BA.debugLineNum = 650;BA.debugLine="Try";
try { //BA.debugLineNum = 651;BA.debugLine="fingerprint.Initialize (Me, \"auth\")";
mostCurrent._fingerprint._initialize /*String*/ (processBA,main.getObject(),"auth");
 //BA.debugLineNum = 654;BA.debugLine="If fingerprint.HardwareDetected = False Then";
if (mostCurrent._fingerprint._gethardwaredetected /*boolean*/ ()==anywheresoftware.b4a.keywords.Common.False) { 
 }else if(mostCurrent._fingerprint._gethasenrolledfingerprints /*boolean*/ ()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 658;BA.debugLine="ToastMessageShow(\"اثر انگشت تعریف نشده است\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اثر انگشت تعریف نشده است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 660;BA.debugLine="lbl_finger.Visible=True";
mostCurrent._lbl_finger.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 661;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
mostCurrent._lbl_finger.setTextColor(((int)0xff0b6200));
 //BA.debugLineNum = 662;BA.debugLine="finger_scaning";
_finger_scaning();
 //BA.debugLineNum = 663;BA.debugLine="tim_lock_lbl.Enabled=True";
_tim_lock_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e27) {
			processBA.setLastException(e27); //BA.debugLineNum = 667;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("29109545",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
 };
 }else {
 //BA.debugLineNum = 674;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 681;BA.debugLine="End Sub";
return "";
}
}
