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
public static int _state_tatil_setting = 0;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _ckb_tatil_rasmi = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _ckb_tatil_garardadi = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_tatil_show = null;
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
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

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (shift_activity.mostCurrent != null);
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
vis = vis | (show_gozaresh_activity.mostCurrent != null);
vis = vis | (step0_activity.mostCurrent != null);
vis = vis | (step1_activity.mostCurrent != null);
vis = vis | (step2_activity.mostCurrent != null);
vis = vis | (vam_activity.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_user = null;
 //BA.debugLineNum = 324;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 328;BA.debugLine="Try";
try { //BA.debugLineNum = 329;BA.debugLine="inapp.Initialize(\"inapp\",key)";
mostCurrent._inapp.Initialize(processBA,"inapp",mostCurrent._key);
 } 
       catch (Exception e4) {
			processBA.setLastException(e4); //BA.debugLineNum = 331;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("5131079",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 334;BA.debugLine="If(FirstTime=True)Then";
if ((_firsttime==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 335;BA.debugLine="dbCode.check_old_adds";
mostCurrent._dbcode._check_old_adds /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 336;BA.debugLine="dbCode.check_new_add";
mostCurrent._dbcode._check_new_add /*String*/ (mostCurrent.activityBA);
 };
 //BA.debugLineNum = 344;BA.debugLine="img1.Initialize(LoadBitmap(File.DirAssets,\"m1.png";
mostCurrent._img1.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m1.png").getObject()));
 //BA.debugLineNum = 345;BA.debugLine="img1.Gravity=Gravity.FILL";
mostCurrent._img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 347;BA.debugLine="img2.Initialize(LoadBitmap(File.DirAssets,\"m2.png";
mostCurrent._img2.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m2.png").getObject()));
 //BA.debugLineNum = 348;BA.debugLine="img2.Gravity=Gravity.FILL";
mostCurrent._img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 350;BA.debugLine="img3.Initialize(LoadBitmap(File.DirAssets,\"m3.png";
mostCurrent._img3.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m3.png").getObject()));
 //BA.debugLineNum = 351;BA.debugLine="img3.Gravity=Gravity.FILL";
mostCurrent._img3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 353;BA.debugLine="If(FirstTime)Then";
if ((_firsttime)) { 
 //BA.debugLineNum = 354;BA.debugLine="Activity.LoadLayout(\"splash_layout\")";
mostCurrent._activity.LoadLayout("splash_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 355;BA.debugLine="lbl_vesion_app.Text=app_vesion";
mostCurrent._lbl_vesion_app.setText(BA.ObjectToCharSequence(_app_vesion));
 //BA.debugLineNum = 356;BA.debugLine="cv_loader.Show";
mostCurrent._cv_loader._show /*String*/ ();
 //BA.debugLineNum = 357;BA.debugLine="timer1.Initialize(\"timer1\" , 1500)";
_timer1.Initialize(processBA,"timer1",(long) (1500));
 //BA.debugLineNum = 359;BA.debugLine="timer1.Enabled=True";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 360;BA.debugLine="is_first_time=True";
_is_first_time = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 362;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 363;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 //BA.debugLineNum = 364;BA.debugLine="is_first_time=False";
_is_first_time = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 369;BA.debugLine="moon.Initialize";
mostCurrent._moon.Initialize();
 //BA.debugLineNum = 370;BA.debugLine="moon.AddAll(Array As String(\"فروردین\", \"اردیبهشت\"";
mostCurrent._moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
 //BA.debugLineNum = 373;BA.debugLine="strfun.Initialize";
mostCurrent._strfun._initialize(processBA);
 //BA.debugLineNum = 377;BA.debugLine="If(buy_index=1)Then";
if ((_buy_index==1)) { 
 //BA.debugLineNum = 378;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 //BA.debugLineNum = 379;BA.debugLine="buy_index=0";
_buy_index = (int) (0);
 };
 //BA.debugLineNum = 385;BA.debugLine="tim_msg.Initialize(\"tim_msg\",4000)";
_tim_msg.Initialize(processBA,"tim_msg",(long) (4000));
 //BA.debugLineNum = 387;BA.debugLine="ls1.Initialize";
mostCurrent._ls1.Initialize();
 //BA.debugLineNum = 388;BA.debugLine="ls2.Initialize";
mostCurrent._ls2.Initialize();
 //BA.debugLineNum = 389;BA.debugLine="ls3.Initialize";
mostCurrent._ls3.Initialize();
 //BA.debugLineNum = 392;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1"))) { 
 //BA.debugLineNum = 393;BA.debugLine="ls1=File.ReadList(File.DirInternal,\"ls1\")";
mostCurrent._ls1 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1");
 //BA.debugLineNum = 394;BA.debugLine="ls2=File.ReadList(File.DirInternal,\"ls2\")";
mostCurrent._ls2 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls2");
 //BA.debugLineNum = 395;BA.debugLine="ls3=File.ReadList(File.DirInternal,\"ls3\")";
mostCurrent._ls3 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls3");
 //BA.debugLineNum = 397;BA.debugLine="last_notif=ls1.Get(ls1.Size-1)";
mostCurrent._last_notif = BA.ObjectToString(mostCurrent._ls1.Get((int) (mostCurrent._ls1.getSize()-1)));
 //BA.debugLineNum = 398;BA.debugLine="is_now_instal=False";
_is_now_instal = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 404;BA.debugLine="If(FirstTime=True)Then";
if ((_firsttime==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 405;BA.debugLine="If(myfunc.check_karid=True)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 406;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
 }else {
 //BA.debugLineNum = 408;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
 };
 };
 //BA.debugLineNum = 427;BA.debugLine="If(File.Exists(File.DirInternal,\"phonNum\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum"))) { 
 //BA.debugLineNum = 428;BA.debugLine="phon_num=File.ReadString(File.DirInternal,\"phonN";
_phon_num = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum");
 };
 //BA.debugLineNum = 431;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc"))) { 
 //BA.debugLineNum = 432;BA.debugLine="Dim ls_user As List";
_ls_user = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 433;BA.debugLine="ls_user.Initialize";
_ls_user.Initialize();
 //BA.debugLineNum = 434;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAcc\"";
_ls_user = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
 //BA.debugLineNum = 435;BA.debugLine="user_nameFamili=ls_user.Get(0)";
_user_namefamili = BA.ObjectToString(_ls_user.Get((int) (0)));
 };
 //BA.debugLineNum = 439;BA.debugLine="If(FirstTime=True)Then";
if ((_firsttime==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 440;BA.debugLine="tim_check_update.Initialize(\"tim_check_update\",9";
_tim_check_update.Initialize(processBA,"tim_check_update",(long) (9000));
 //BA.debugLineNum = 441;BA.debugLine="tim_check_update.Enabled=True";
_tim_check_update.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 444;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
int _result = 0;
 //BA.debugLineNum = 2840;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 2841;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 2842;BA.debugLine="If (pan_all_msgNewYear.Visible=True)Then";
if ((mostCurrent._pan_all_msgnewyear.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2843;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_help.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2846;BA.debugLine="lbl_close_help_Click";
_lbl_close_help_click();
 }else if((mostCurrent._pan_all_setting_date.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2848;BA.debugLine="pan_all_setting_date.Visible=False";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2851;BA.debugLine="If(pan_all2.Visible=True)Then";
if ((mostCurrent._pan_all2.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2852;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 2854;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }else if((mostCurrent._pan_notifi_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2858;BA.debugLine="lbl_close_notif_Click";
_lbl_close_notif_click();
 }else if((_index_page==2 || _index_page==3)) { 
 //BA.debugLineNum = 2860;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 }else if((mostCurrent._pan_all_noskhe.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2862;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
 }else if((mostCurrent._pan_all_litemenu.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2864;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_all_chekupdate.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2866;BA.debugLine="pan_all_chekUpdate.Visible=False";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 2871;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 2872;BA.debugLine="result = Msgbox2(\"آیا قصد خروج دارید؟\", \"خروج\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا قصد خروج دارید؟"),BA.ObjectToCharSequence("خروج"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 2873;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 2874;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 };
 };
 //BA.debugLineNum = 2880;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 2882;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 2884;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 957;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 959;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 953;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 955;BA.debugLine="End Sub";
return "";
}
public static String  _add_end() throws Exception{
boolean _chek = false;
anywheresoftware.b4a.objects.collections.List _alist = null;
 //BA.debugLineNum = 2284;BA.debugLine="Sub add_end";
 //BA.debugLineNum = 2285;BA.debugLine="Dim chek As Boolean";
_chek = false;
 //BA.debugLineNum = 2286;BA.debugLine="chek=myfunc.check_karid";
_chek = mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 2287;BA.debugLine="Dim alist As List";
_alist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2288;BA.debugLine="alist.Initialize";
_alist.Initialize();
 //BA.debugLineNum = 2290;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(myfunc";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth())))));
 //BA.debugLineNum = 2293;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(persianDate.Pe";
_alist = mostCurrent._myfunc._num_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear())),_moon_num);
 //BA.debugLineNum = 2296;BA.debugLine="If(index_box=1) Then";
if ((_index_box==1)) { 
 //BA.debugLineNum = 2297;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2298;BA.debugLine="If(alist.Get(0)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (0))))<5)) { 
 //BA.debugLineNum = 2299;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 }else {
 //BA.debugLineNum = 2301;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 2305;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 };
 }else if((_index_box==2)) { 
 //BA.debugLineNum = 2310;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2311;BA.debugLine="If(alist.Get(1)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (1))))<5)) { 
 //BA.debugLineNum = 2312;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 }else {
 //BA.debugLineNum = 2314;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 2317;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 };
 }else if((_index_box==3)) { 
 //BA.debugLineNum = 2322;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2323;BA.debugLine="If(alist.Get(3)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (3))))<5)) { 
 //BA.debugLineNum = 2326;BA.debugLine="Select state_tatil_setting";
switch (_state_tatil_setting) {
case 0: {
 //BA.debugLineNum = 2328;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 break; }
case 1: {
 //BA.debugLineNum = 2330;BA.debugLine="If (state_tatil=1 Or state_tatil=2) Then 'ta";
if ((_state_tatil==1 || _state_tatil==2)) { 
 //BA.debugLineNum = 2331;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
 //BA.debugLineNum = 2333;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 11: {
 //BA.debugLineNum = 2338;BA.debugLine="If (state_tatil=1) Then 'tatil rasmi";
if ((_state_tatil==1)) { 
 //BA.debugLineNum = 2339;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
 //BA.debugLineNum = 2341;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 22: {
 //BA.debugLineNum = 2346;BA.debugLine="If (state_tatil=2) Then  'tatil garardadi";
if ((_state_tatil==2)) { 
 //BA.debugLineNum = 2347;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
 //BA.debugLineNum = 2349;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
}
;
 //BA.debugLineNum = 2356;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2357;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
 };
 }else {
 //BA.debugLineNum = 2361;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 2365;BA.debugLine="Select state_tatil_setting";
switch (_state_tatil_setting) {
case 0: {
 //BA.debugLineNum = 2367;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 break; }
case 1: {
 //BA.debugLineNum = 2369;BA.debugLine="If (state_tatil=1 Or state_tatil=2) Then 'tat";
if ((_state_tatil==1 || _state_tatil==2)) { 
 //BA.debugLineNum = 2370;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
 //BA.debugLineNum = 2372;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 11: {
 //BA.debugLineNum = 2377;BA.debugLine="If (state_tatil=1) Then 'tatil rasmi";
if ((_state_tatil==1)) { 
 //BA.debugLineNum = 2378;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
 //BA.debugLineNum = 2380;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 22: {
 //BA.debugLineNum = 2385;BA.debugLine="If (state_tatil=2) Then  'tatil garardadi";
if ((_state_tatil==2)) { 
 //BA.debugLineNum = 2386;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
 //BA.debugLineNum = 2388;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
}
;
 //BA.debugLineNum = 2395;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2396;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
 };
 };
 }else if((_index_box==5)) { 
 //BA.debugLineNum = 2404;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2405;BA.debugLine="If(alist.Get(4)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (4))))<5)) { 
 //BA.debugLineNum = 2406;BA.debugLine="add_mamoriat_sub";
_add_mamoriat_sub();
 }else {
 //BA.debugLineNum = 2408;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 2412;BA.debugLine="add_mamoriat_sub";
_add_mamoriat_sub();
 };
 };
 //BA.debugLineNum = 2416;BA.debugLine="End Sub";
return "";
}
public static String  _add_ezafe_sub() throws Exception{
int _state_mod = 0;
String _str_mod = "";
boolean _result_a = false;
 //BA.debugLineNum = 2418;BA.debugLine="Sub add_ezafe_sub";
 //BA.debugLineNum = 2419;BA.debugLine="Dim state_mod As Int=0";
_state_mod = (int) (0);
 //BA.debugLineNum = 2420;BA.debugLine="Dim str_mod As String=\"\"";
_str_mod = "";
 //BA.debugLineNum = 2421;BA.debugLine="If(ckb_ezaf_taradod.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2422;BA.debugLine="state_mod=2";
_state_mod = (int) (2);
 //BA.debugLineNum = 2423;BA.debugLine="str_mod=\" (فوق العاده)- \"";
_str_mod = " (فوق العاده)- ";
 }else {
 //BA.debugLineNum = 2425;BA.debugLine="state_mod=0";
_state_mod = (int) (0);
 };
 //BA.debugLineNum = 2429;BA.debugLine="Try";
try { //BA.debugLineNum = 2431;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 2432;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0 || _day_bt!=0)) { 
 //BA.debugLineNum = 2435;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0)) { 
 //BA.debugLineNum = 2437;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 2441;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2442;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_ezafekari_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2444;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
 //BA.debugLineNum = 2445;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ اضافه کاری وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
 //BA.debugLineNum = 2446;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2447;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Te";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 2450;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2451;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2456;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 2459;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2460;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2464;BA.debugLine="dbCode.edit_ezafekari(current_id_edit,date1,da";
mostCurrent._dbcode._edit_ezafekari /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 2465;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2468;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 //BA.debugLineNum = 2473;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e39) {
			processBA.setLastException(e39); //BA.debugLineNum = 2479;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 2484;BA.debugLine="End Sub";
return "";
}
public static String  _add_mamoriat_sub() throws Exception{
int _state_mod = 0;
String _str_mod = "";
boolean _result_a = false;
 //BA.debugLineNum = 2777;BA.debugLine="Sub add_mamoriat_sub";
 //BA.debugLineNum = 2778;BA.debugLine="Dim state_mod As Int=0";
_state_mod = (int) (0);
 //BA.debugLineNum = 2779;BA.debugLine="Dim str_mod As String=\"\"";
_str_mod = "";
 //BA.debugLineNum = 2788;BA.debugLine="Try";
try { //BA.debugLineNum = 2789;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
if ((_day_bt<0 || _hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 2790;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0)) { 
 //BA.debugLineNum = 2792;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0 && _day_bt==0)) { 
 //BA.debugLineNum = 2794;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 2797;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2798;BA.debugLine="If(dbCode.isexist_mamoriat_by_date(date1)=True";
if ((mostCurrent._dbcode._isexist_mamoriat_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2800;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
 //BA.debugLineNum = 2801;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ مأموریت وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
 //BA.debugLineNum = 2802;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2803;BA.debugLine="dbCode.add_mamoriat(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_mamoriat /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 2805;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2806;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2809;BA.debugLine="dbCode.add_mamoriat(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_mamoriat /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 2811;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2812;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2816;BA.debugLine="dbCode.edit_mamoriat(current_id_edit,date1,dat";
mostCurrent._dbcode._edit_mamoriat /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 2817;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2820;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 //BA.debugLineNum = 2825;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e33) {
			processBA.setLastException(e33); //BA.debugLineNum = 2831;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 2836;BA.debugLine="End Sub";
return "";
}
public static String  _add_morakhasi_sub() throws Exception{
String _str_noe2 = "";
boolean _result_a = false;
 //BA.debugLineNum = 2486;BA.debugLine="Sub add_morakhasi_sub";
 //BA.debugLineNum = 2487;BA.debugLine="Dim str_noe2 As String";
_str_noe2 = "";
 //BA.debugLineNum = 2488;BA.debugLine="str_noe2=\"(\"&str_noe&\")- \"";
_str_noe2 = "("+mostCurrent._str_noe+")- ";
 //BA.debugLineNum = 2490;BA.debugLine="Try";
try { //BA.debugLineNum = 2491;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
if ((_day_bt<0 || _hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 2492;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0)) { 
 //BA.debugLineNum = 2494;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0 && _day_bt==0)) { 
 //BA.debugLineNum = 2496;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 2501;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2502;BA.debugLine="If(dbCode.isexist_morakhasi_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_morakhasi_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2504;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
 //BA.debugLineNum = 2505;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ مرخصی وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
 //BA.debugLineNum = 2506;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2507;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Te";
mostCurrent._dbcode._add_morakhasi /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_noe2+mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
 //BA.debugLineNum = 2508;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2509;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2514;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_morakhasi /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_noe2+mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
 //BA.debugLineNum = 2515;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2516;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2519;BA.debugLine="dbCode.edit_morakhasi(current_id_edit,date1,da";
mostCurrent._dbcode._edit_morakhasi /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
 //BA.debugLineNum = 2521;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2522;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 //BA.debugLineNum = 2529;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e33) {
			processBA.setLastException(e33); //BA.debugLineNum = 2535;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 2540;BA.debugLine="End Sub";
return "";
}
public static String  _add_taradod_sub() throws Exception{
boolean _result_a = false;
String _str_tozih0 = "";
String _str_tozih1 = "";
String _str_tozih2 = "";
int _tim_ezaf_min = 0;
anywheresoftware.b4a.objects.collections.List _ls_res_tim1 = null;
String _tim1_saat = "";
String _date1_refind = "";
 //BA.debugLineNum = 2543;BA.debugLine="Sub add_taradod_sub";
 //BA.debugLineNum = 2544;BA.debugLine="Try";
try { //BA.debugLineNum = 2546;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 2547;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0 || _day_bt>2)) { 
 //BA.debugLineNum = 2550;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0)) { 
 //BA.debugLineNum = 2552;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 2557;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2558;BA.debugLine="If(dbCode.isexist_taradod_by_date(date1)=True)";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2561;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
 //BA.debugLineNum = 2562;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ تردد وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
 //BA.debugLineNum = 2563;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2566;BA.debugLine="Dim str_tozih0 As String=\"(فوق العاده)(تردد";
_str_tozih0 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2567;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_t";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2568;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2570;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_e";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2574;BA.debugLine="Dim tim_ezaf_min As Int=tim_min-saat_kar_mi";
_tim_ezaf_min = (int) (_tim_min-_saat_kar_min);
 //BA.debugLineNum = 2576;BA.debugLine="Dim ls_res_tim1 As List";
_ls_res_tim1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2577;BA.debugLine="ls_res_tim1.Initialize";
_ls_res_tim1.Initialize();
 //BA.debugLineNum = 2578;BA.debugLine="ls_res_tim1=myfunc.find_tim1_taradod(lbl_ti";
_ls_res_tim1 = mostCurrent._myfunc._find_tim1_taradod /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._lbl_tim2.getText(),_tim_ezaf_min);
 //BA.debugLineNum = 2579;BA.debugLine="Dim tim1_saat As String=ls_res_tim1.Get(0)";
_tim1_saat = BA.ObjectToString(_ls_res_tim1.Get((int) (0)));
 //BA.debugLineNum = 2580;BA.debugLine="Dim date1_refind As String=\"\"";
_date1_refind = "";
 //BA.debugLineNum = 2581;BA.debugLine="If(ls_res_tim1.Get(1)=1) Then";
if (((_ls_res_tim1.Get((int) (1))).equals((Object)(1)))) { 
 //BA.debugLineNum = 2582;BA.debugLine="date1_refind=date2";
_date1_refind = mostCurrent._date2;
 }else {
 //BA.debugLineNum = 2584;BA.debugLine="date1_refind=date1";
_date1_refind = mostCurrent._date1;
 };
 //BA.debugLineNum = 2588;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2589;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,ti";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih0,(int) (2));
 }else {
 //BA.debugLineNum = 2591;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,ti";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih1,(int) (0));
 };
 //BA.debugLineNum = 2596;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
 //BA.debugLineNum = 2598;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,mostCurrent._et_tozihat.getText(),(int) (0));
 };
 //BA.debugLineNum = 2605;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2606;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2614;BA.debugLine="Dim str_tozih0 As String=\"(فوق العاده)(تردد د";
_str_tozih0 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2615;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_to";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2616;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-\"";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2619;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_ez";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2623;BA.debugLine="Dim tim_ezaf_min As Int=tim_min-saat_kar_min";
_tim_ezaf_min = (int) (_tim_min-_saat_kar_min);
 //BA.debugLineNum = 2626;BA.debugLine="Dim ls_res_tim1 As List";
_ls_res_tim1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2627;BA.debugLine="ls_res_tim1.Initialize";
_ls_res_tim1.Initialize();
 //BA.debugLineNum = 2628;BA.debugLine="ls_res_tim1=myfunc.find_tim1_taradod(lbl_tim";
_ls_res_tim1 = mostCurrent._myfunc._find_tim1_taradod /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._lbl_tim2.getText(),_tim_ezaf_min);
 //BA.debugLineNum = 2629;BA.debugLine="Dim tim1_saat As String=ls_res_tim1.Get(0)";
_tim1_saat = BA.ObjectToString(_ls_res_tim1.Get((int) (0)));
 //BA.debugLineNum = 2630;BA.debugLine="Dim date1_refind As String=\"\"";
_date1_refind = "";
 //BA.debugLineNum = 2631;BA.debugLine="If(ls_res_tim1.Get(1)=1) Then";
if (((_ls_res_tim1.Get((int) (1))).equals((Object)(1)))) { 
 //BA.debugLineNum = 2632;BA.debugLine="date1_refind=date2";
_date1_refind = mostCurrent._date2;
 }else {
 //BA.debugLineNum = 2634;BA.debugLine="date1_refind=date1";
_date1_refind = mostCurrent._date1;
 };
 //BA.debugLineNum = 2638;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2639;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,tim";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih0,(int) (2));
 }else {
 //BA.debugLineNum = 2641;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,tim";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih1,(int) (0));
 };
 //BA.debugLineNum = 2645;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
 //BA.debugLineNum = 2647;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,mostCurrent._et_tozihat.getText(),(int) (0));
 };
 //BA.debugLineNum = 2651;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2652;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2655;BA.debugLine="dbCode.edit_taradod(current_id_edit,date1,date";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
 //BA.debugLineNum = 2657;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2658;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 //BA.debugLineNum = 2664;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e77) {
			processBA.setLastException(e77); //BA.debugLineNum = 2670;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 2673;BA.debugLine="End Sub";
return "";
}
public static String  _add_taradod_sub2() throws Exception{
boolean _result_a = false;
String _str_tozih2 = "";
String _str_tozih1 = "";
 //BA.debugLineNum = 2677;BA.debugLine="Sub add_taradod_sub2";
 //BA.debugLineNum = 2678;BA.debugLine="Try";
try { //BA.debugLineNum = 2680;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 2681;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0 || _day_bt>2)) { 
 //BA.debugLineNum = 2684;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0)) { 
 //BA.debugLineNum = 2686;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 2691;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2692;BA.debugLine="If(dbCode.isexist_taradod_by_date(date1)=True)";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2695;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
 //BA.debugLineNum = 2696;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ تردد وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
 //BA.debugLineNum = 2697;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2699;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2701;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_e";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2703;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2704;BA.debugLine="Dim str_tozih1 As String=\"(فوق العاده)(تر";
_str_tozih1 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2705;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (2));
 }else {
 //BA.debugLineNum = 2707;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&e";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2708;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (0));
 };
 //BA.debugLineNum = 2714;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Te";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
 //BA.debugLineNum = 2716;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 };
 //BA.debugLineNum = 2719;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2720;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2727;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-\"";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2729;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_ez";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2731;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2732;BA.debugLine="Dim str_tozih1 As String=\"(فوق العاده)(تردد";
_str_tozih1 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2733;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.T";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (2));
 }else {
 //BA.debugLineNum = 2735;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2736;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.T";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (0));
 };
 //BA.debugLineNum = 2743;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
 //BA.debugLineNum = 2746;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 };
 //BA.debugLineNum = 2749;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2750;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2755;BA.debugLine="dbCode.edit_taradod(current_id_edit,date1,date";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
 //BA.debugLineNum = 2757;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2758;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 //BA.debugLineNum = 2764;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e55) {
			processBA.setLastException(e55); //BA.debugLineNum = 2770;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 2773;BA.debugLine="End Sub";
return "";
}
public static String  _auth_complete(boolean _success,String _errormessage) throws Exception{
 //BA.debugLineNum = 834;BA.debugLine="Sub Auth_Complete (Success As Boolean, ErrorMessag";
 //BA.debugLineNum = 835;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 836;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 837;BA.debugLine="tim_lock_lbl.Enabled=False";
_tim_lock_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 839;BA.debugLine="ToastMessageShow($\"Error: ${ErrorMessage}\"$, Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(("Error: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_errormessage))+"")),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 840;BA.debugLine="Log(ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("51179654",_errormessage,0);
 };
 //BA.debugLineNum = 842;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_gozaresh_click() throws Exception{
 //BA.debugLineNum = 1632;BA.debugLine="Private Sub btn_menu_gozaresh_Click";
 //BA.debugLineNum = 1633;BA.debugLine="index_page=3";
_index_page = (int) (3);
 //BA.debugLineNum = 1634;BA.debugLine="pan_imag.Background=img3";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img3.getObject()));
 //BA.debugLineNum = 1636;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
 //BA.debugLineNum = 1637;BA.debugLine="pan_main.LoadLayout(\"gozaresh_layout\")";
mostCurrent._pan_main.LoadLayout("gozaresh_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 1639;BA.debugLine="sp_year_gozaresh.Add(\"1402\")";
mostCurrent._sp_year_gozaresh.Add("1402");
 //BA.debugLineNum = 1640;BA.debugLine="sp_year_gozaresh.Add(\"1401\")";
mostCurrent._sp_year_gozaresh.Add("1401");
 //BA.debugLineNum = 1641;BA.debugLine="sp_year_gozaresh.Add(\"1400\")";
mostCurrent._sp_year_gozaresh.Add("1400");
 //BA.debugLineNum = 1642;BA.debugLine="sp_year_gozaresh.Add(\"1399\")";
mostCurrent._sp_year_gozaresh.Add("1399");
 //BA.debugLineNum = 1643;BA.debugLine="sp_year_gozaresh.Add(\"1398\")";
mostCurrent._sp_year_gozaresh.Add("1398");
 //BA.debugLineNum = 1645;BA.debugLine="sp_year_gozaresh.SelectedIndex=0";
mostCurrent._sp_year_gozaresh.setSelectedIndex((int) (0));
 //BA.debugLineNum = 1650;BA.debugLine="pan_hed_gozaresh.Color=color4";
mostCurrent._pan_hed_gozaresh.setColor(_color4);
 //BA.debugLineNum = 1655;BA.debugLine="list_gozareshat_id.Initialize";
mostCurrent._list_gozareshat_id.Initialize();
 //BA.debugLineNum = 1658;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
 //BA.debugLineNum = 1660;BA.debugLine="End Sub";
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
int _result = 0;
 //BA.debugLineNum = 962;BA.debugLine="Private Sub btn_menu_home_Click";
 //BA.debugLineNum = 963;BA.debugLine="index_page=1";
_index_page = (int) (1);
 //BA.debugLineNum = 964;BA.debugLine="pan_imag.Background=img1";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img1.getObject()));
 //BA.debugLineNum = 966;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
 //BA.debugLineNum = 967;BA.debugLine="pan_main.LoadLayout(\"home_layout\")";
mostCurrent._pan_main.LoadLayout("home_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 968;BA.debugLine="scv_home_item.Panel.LoadLayout(\"home_item\")";
mostCurrent._scv_home_item.getPanel().LoadLayout("home_item",mostCurrent.activityBA);
 //BA.debugLineNum = 969;BA.debugLine="lbl_date_home.Text=myfunc.fa2en(persianDate.Persi";
mostCurrent._lbl_date_home.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianLongDate())));
 //BA.debugLineNum = 971;BA.debugLine="saat_kar_min =dbCode.get_setting_byName(\"saat_kar";
_saat_kar_min = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_darRoz")));
 //BA.debugLineNum = 973;BA.debugLine="If(saat_kar_min<18)Then";
if ((_saat_kar_min<18)) { 
 //BA.debugLineNum = 974;BA.debugLine="myfunc.help_man(\"توجه\",\"لطفا ساعت کاری خود را تن";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","لطفا ساعت کاری خود را تنظیم کنید");
 };
 //BA.debugLineNum = 977;BA.debugLine="Dim list_ezafekari As List";
_list_ezafekari = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 978;BA.debugLine="list_ezafekari.Initialize";
_list_ezafekari.Initialize();
 //BA.debugLineNum = 980;BA.debugLine="year_num=myfunc.fa2en(persianDate.PersianYear)";
_year_num = mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()));
 //BA.debugLineNum = 982;BA.debugLine="moon_num=myfunc.convert_adad(persianDate.PersianM";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_persiandate.getPersianMonth());
 //BA.debugLineNum = 984;BA.debugLine="list_ezafekari=dbCode.all_ezafekari_mah(year_num,";
_list_ezafekari = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num,(int) (1));
 //BA.debugLineNum = 990;BA.debugLine="Dim list_morakhasi As List";
_list_morakhasi = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 991;BA.debugLine="list_morakhasi.Initialize";
_list_morakhasi.Initialize();
 //BA.debugLineNum = 993;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(year_num,";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num);
 //BA.debugLineNum = 996;BA.debugLine="lbl_ezafekari_mah_m.Text=list_ezafekari.Get(1)&\"";
mostCurrent._lbl_ezafekari_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (1)))+" دقیقه "));
 //BA.debugLineNum = 997;BA.debugLine="lbl_ezafekari_mah_h.Text=list_ezafekari.Get(0)&\"";
mostCurrent._lbl_ezafekari_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (0)))+" ساعت "));
 //BA.debugLineNum = 999;BA.debugLine="lbl_morakhasi_mah_m.Text=list_morakhasi.Get(2)&\"";
mostCurrent._lbl_morakhasi_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (2)))+" دقیقه "));
 //BA.debugLineNum = 1000;BA.debugLine="lbl_morakhasi_mah_h.Text=list_morakhasi.Get(1)&\"";
mostCurrent._lbl_morakhasi_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (1)))+" ساعت "));
 //BA.debugLineNum = 1001;BA.debugLine="lbl_morakhasi_mah_d.Text=list_morakhasi.Get(0)&\"";
mostCurrent._lbl_morakhasi_mah_d.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (0)))+" روز "));
 //BA.debugLineNum = 1003;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 1005;BA.debugLine="lbl_vip.TextColor=0xFFFFD800";
mostCurrent._lbl_vip.setTextColor(((int)0xffffd800));
 //BA.debugLineNum = 1006;BA.debugLine="lbl_vip2.Text=\"نسخه طلایی\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه طلایی"));
 }else {
 //BA.debugLineNum = 1009;BA.debugLine="lbl_vip.TextColor=Colors.Green";
mostCurrent._lbl_vip.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 1010;BA.debugLine="lbl_vip2.Text=\"نسخه هدیه\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه هدیه"));
 };
 //BA.debugLineNum = 1015;BA.debugLine="If (File.Exists(File.DirInternal,\"help_start\")=Fa";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1016;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 1017;BA.debugLine="File.WriteString(File.DirInternal,\"help_start\",\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start","");
 };
 //BA.debugLineNum = 1023;BA.debugLine="If (File.Exists(File.DirInternal,\"setcolor.txt\"))";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt"))) { 
 //BA.debugLineNum = 1024;BA.debugLine="Dim list_color As List";
_list_color = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1025;BA.debugLine="list_color.Initialize";
_list_color.Initialize();
 //BA.debugLineNum = 1026;BA.debugLine="list_color = File.ReadList(File.DirInternal,\"set";
_list_color = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt");
 //BA.debugLineNum = 1028;BA.debugLine="Dim col As List";
_col = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1029;BA.debugLine="col.Initialize";
_col.Initialize();
 //BA.debugLineNum = 1031;BA.debugLine="Dim col_font As List";
_col_font = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1032;BA.debugLine="col_font.Initialize";
_col_font.Initialize();
 //BA.debugLineNum = 1034;BA.debugLine="col=Regex.Split(\",\",list_color.Get(0))";
_col = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (0)))));
 //BA.debugLineNum = 1035;BA.debugLine="col_font=Regex.Split(\",\",list_color.Get(1))";
_col_font = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (1)))));
 //BA.debugLineNum = 1039;BA.debugLine="color1= col.Get(0)";
_color1 = (int)(BA.ObjectToNumber(_col.Get((int) (0))));
 //BA.debugLineNum = 1040;BA.debugLine="color2= col.Get(1)";
_color2 = (int)(BA.ObjectToNumber(_col.Get((int) (1))));
 //BA.debugLineNum = 1041;BA.debugLine="color_index=col.Get(2)  'index color";
_color_index = (int)(BA.ObjectToNumber(_col.Get((int) (2))));
 //BA.debugLineNum = 1042;BA.debugLine="color3= col.Get(3)";
_color3 = (int)(BA.ObjectToNumber(_col.Get((int) (3))));
 //BA.debugLineNum = 1043;BA.debugLine="color4= col.Get(4)";
_color4 = (int)(BA.ObjectToNumber(_col.Get((int) (4))));
 //BA.debugLineNum = 1044;BA.debugLine="color5= col.Get(5)";
_color5 = (int)(BA.ObjectToNumber(_col.Get((int) (5))));
 //BA.debugLineNum = 1046;BA.debugLine="main_font=col_font.Get(0)";
_main_font = BA.ObjectToString(_col_font.Get((int) (0)));
 //BA.debugLineNum = 1047;BA.debugLine="size_f1=col_font.Get(1)";
_size_f1 = (int)(BA.ObjectToNumber(_col_font.Get((int) (1))));
 //BA.debugLineNum = 1048;BA.debugLine="size_f2=col_font.Get(2)";
_size_f2 = (int)(BA.ObjectToNumber(_col_font.Get((int) (2))));
 //BA.debugLineNum = 1049;BA.debugLine="size_f3=col_font.Get(3)";
_size_f3 = (int)(BA.ObjectToNumber(_col_font.Get((int) (3))));
 }else {
 //BA.debugLineNum = 1053;BA.debugLine="color_index=1";
_color_index = (int) (1);
 //BA.debugLineNum = 1054;BA.debugLine="color1= 0XFF69AC00";
_color1 = ((int)0xff69ac00);
 //BA.debugLineNum = 1055;BA.debugLine="color2= 0xFF00C7C7";
_color2 = ((int)0xff00c7c7);
 //BA.debugLineNum = 1056;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 1057;BA.debugLine="color4=0XFF69AC00";
_color4 = ((int)0xff69ac00);
 //BA.debugLineNum = 1058;BA.debugLine="color5=0XFF69AC00";
_color5 = ((int)0xff69ac00);
 //BA.debugLineNum = 1060;BA.debugLine="main_font=\"یکان\"";
_main_font = "یکان";
 //BA.debugLineNum = 1061;BA.debugLine="size_f1=17";
_size_f1 = (int) (17);
 //BA.debugLineNum = 1062;BA.debugLine="size_f2=15";
_size_f2 = (int) (15);
 //BA.debugLineNum = 1063;BA.debugLine="size_f3=13";
_size_f3 = (int) (13);
 //BA.debugLineNum = 1066;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(_color1)+","+BA.NumberToString(_color2)+","+BA.NumberToString(_color_index)+","+BA.NumberToString(_color3)+","+BA.NumberToString(_color4)+","+BA.NumberToString(_color5)+anywheresoftware.b4a.keywords.Common.CRLF+_main_font+","+BA.NumberToString(_size_f1)+","+BA.NumberToString(_size_f2)+","+BA.NumberToString(_size_f3));
 };
 //BA.debugLineNum = 1074;BA.debugLine="Dim dw As GradientDrawable";
_dw = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
 //BA.debugLineNum = 1075;BA.debugLine="Dim clr() As Int = Array  As Int(color1,color2)";
_clr = new int[]{_color1,_color2};
 //BA.debugLineNum = 1076;BA.debugLine="dw.Initialize(\"TOP_BOTTOM\",clr)";
_dw.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clr);
 //BA.debugLineNum = 1077;BA.debugLine="dw.CornerRadius=50dip";
_dw.setCornerRadius((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))));
 //BA.debugLineNum = 1078;BA.debugLine="Panel1.Background=dw";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_dw.getObject()));
 //BA.debugLineNum = 1086;BA.debugLine="lbl_box_title.Color=color4";
mostCurrent._lbl_box_title.setColor(_color4);
 //BA.debugLineNum = 1095;BA.debugLine="get_today_shift";
_get_today_shift();
 //BA.debugLineNum = 1098;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 1101;BA.debugLine="If(is_first_time=True)Then";
if ((_is_first_time==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1102;BA.debugLine="chek_time_backup";
_chek_time_backup();
 };
 //BA.debugLineNum = 1106;BA.debugLine="If(is_new_msg=True And is_first_time=True)Then";
if ((_is_new_msg==anywheresoftware.b4a.keywords.Common.True && _is_first_time==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1107;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 1108;BA.debugLine="result = Msgbox2(\"آیا الان مشاهده میکنید؟\", \"پیا";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا الان مشاهده میکنید؟"),BA.ObjectToCharSequence("پیام جدید"),"بله","بعدا","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"notif.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 1109;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 1110;BA.debugLine="lbl_account_Click";
_lbl_account_click();
 //BA.debugLineNum = 1111;BA.debugLine="msg_page_show=1";
_msg_page_show = (int) (1);
 };
 //BA.debugLineNum = 1113;BA.debugLine="is_first_time=False";
_is_first_time = anywheresoftware.b4a.keywords.Common.False;
 }else if((_is_time_backup==anywheresoftware.b4a.keywords.Common.True && _is_first_time==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1115;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 1116;BA.debugLine="result = Msgbox2(\"پشتیبان گیری از داده ها انجام";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("پشتیبان گیری از داده ها انجام گردد؟"),BA.ObjectToCharSequence("یاد آور پشتیبان گیری"),"بله","بعدا","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"notif.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 1117;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 1118;BA.debugLine="lbl_account_Click";
_lbl_account_click();
 //BA.debugLineNum = 1119;BA.debugLine="backup_page_show=1";
_backup_page_show = (int) (1);
 };
 //BA.debugLineNum = 1122;BA.debugLine="is_first_time=False";
_is_first_time = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1129;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_list_click() throws Exception{
 //BA.debugLineNum = 1204;BA.debugLine="Private Sub btn_menu_list_Click";
 //BA.debugLineNum = 1205;BA.debugLine="index_page=2";
_index_page = (int) (2);
 //BA.debugLineNum = 1206;BA.debugLine="pan_imag.Background=img2";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img2.getObject()));
 //BA.debugLineNum = 1208;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
 //BA.debugLineNum = 1209;BA.debugLine="pan_main.LoadLayout(\"list_layout\")";
mostCurrent._pan_main.LoadLayout("list_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 1211;BA.debugLine="sp_year.Add(\"1402\")";
mostCurrent._sp_year.Add("1402");
 //BA.debugLineNum = 1212;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
 //BA.debugLineNum = 1213;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
 //BA.debugLineNum = 1214;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
 //BA.debugLineNum = 1215;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
 //BA.debugLineNum = 1217;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
 //BA.debugLineNum = 1220;BA.debugLine="sp_year.SelectedIndex=0";
mostCurrent._sp_year.setSelectedIndex((int) (0));
 //BA.debugLineNum = 1221;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(persianDate.Pe";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))))-1));
 //BA.debugLineNum = 1223;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(sp_moo";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
 //BA.debugLineNum = 1226;BA.debugLine="TabHost1.AddTab(\"اضافه کاری\" , \"tab_layout_ezafek";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"اضافه کاری","tab_layout_ezafekari.bal");
 //BA.debugLineNum = 1227;BA.debugLine="TabHost1.AddTab(\"مرخصی\" , \"tab_layout_morakhasi.b";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"مرخصی","tab_layout_morakhasi.bal");
 //BA.debugLineNum = 1228;BA.debugLine="TabHost1.AddTab(\"تردد\" , \"tab_layout_taradod.bal\"";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"تردد","tab_layout_taradod.bal");
 //BA.debugLineNum = 1229;BA.debugLine="TabHost1.AddTab(\"مأموریت\" , \"tab_layout_mamoriat.";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"مأموریت","tab_layout_mamoriat.bal");
 //BA.debugLineNum = 1231;BA.debugLine="TabHost1.CurrentTab=curent_tab_list";
mostCurrent._tabhost1.setCurrentTab(_curent_tab_list);
 //BA.debugLineNum = 1233;BA.debugLine="list_ezafekari_id.Initialize";
mostCurrent._list_ezafekari_id.Initialize();
 //BA.debugLineNum = 1236;BA.debugLine="list_morakhasi_id.Initialize";
mostCurrent._list_morakhasi_id.Initialize();
 //BA.debugLineNum = 1239;BA.debugLine="list_taradod_id.Initialize";
mostCurrent._list_taradod_id.Initialize();
 //BA.debugLineNum = 1242;BA.debugLine="list_mamoriat_id.Initialize";
mostCurrent._list_mamoriat_id.Initialize();
 //BA.debugLineNum = 1246;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
 //BA.debugLineNum = 1250;BA.debugLine="pan_hed_list.Color=color4";
mostCurrent._pan_hed_list.setColor(_color4);
 //BA.debugLineNum = 1257;BA.debugLine="End Sub";
return "";
}
public static String  _btneight_click() throws Exception{
 //BA.debugLineNum = 877;BA.debugLine="Sub btnEight_Click";
 //BA.debugLineNum = 878;BA.debugLine="click_count_Increment_and_fill(btnEight.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btneight.getText());
 //BA.debugLineNum = 879;BA.debugLine="End Sub";
return "";
}
public static String  _btnfive_click() throws Exception{
 //BA.debugLineNum = 865;BA.debugLine="Sub btnFive_Click";
 //BA.debugLineNum = 866;BA.debugLine="click_count_Increment_and_fill(btnFive.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnfive.getText());
 //BA.debugLineNum = 867;BA.debugLine="End Sub";
return "";
}
public static String  _btnfour_click() throws Exception{
 //BA.debugLineNum = 861;BA.debugLine="Sub btnFour_Click";
 //BA.debugLineNum = 862;BA.debugLine="click_count_Increment_and_fill(btnFour.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnfour.getText());
 //BA.debugLineNum = 863;BA.debugLine="End Sub";
return "";
}
public static String  _btnnine_click() throws Exception{
 //BA.debugLineNum = 881;BA.debugLine="Sub btnNine_Click";
 //BA.debugLineNum = 882;BA.debugLine="click_count_Increment_and_fill(btnNine.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnnine.getText());
 //BA.debugLineNum = 883;BA.debugLine="End Sub";
return "";
}
public static String  _btnone_click() throws Exception{
 //BA.debugLineNum = 849;BA.debugLine="Sub btnOne_Click";
 //BA.debugLineNum = 850;BA.debugLine="click_count_Increment_and_fill(btnOne.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btnone.getText());
 //BA.debugLineNum = 851;BA.debugLine="End Sub";
return "";
}
public static String  _btnseven_click() throws Exception{
 //BA.debugLineNum = 873;BA.debugLine="Sub btnSeven_Click";
 //BA.debugLineNum = 874;BA.debugLine="click_count_Increment_and_fill(btnSeven.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btnseven.getText());
 //BA.debugLineNum = 875;BA.debugLine="End Sub";
return "";
}
public static String  _btnsix_click() throws Exception{
 //BA.debugLineNum = 869;BA.debugLine="Sub btnSix_Click";
 //BA.debugLineNum = 870;BA.debugLine="click_count_Increment_and_fill(btnSix.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btnsix.getText());
 //BA.debugLineNum = 871;BA.debugLine="End Sub";
return "";
}
public static String  _btnthree_click() throws Exception{
 //BA.debugLineNum = 857;BA.debugLine="Sub btnThree_Click";
 //BA.debugLineNum = 858;BA.debugLine="click_count_Increment_and_fill(btnThree.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btnthree.getText());
 //BA.debugLineNum = 859;BA.debugLine="End Sub";
return "";
}
public static String  _btntwo_click() throws Exception{
 //BA.debugLineNum = 853;BA.debugLine="Sub btnTwo_Click";
 //BA.debugLineNum = 854;BA.debugLine="click_count_Increment_and_fill(btnTwo.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btntwo.getText());
 //BA.debugLineNum = 855;BA.debugLine="End Sub";
return "";
}
public static String  _btnzero_click() throws Exception{
 //BA.debugLineNum = 845;BA.debugLine="Sub btnZero_Click";
 //BA.debugLineNum = 846;BA.debugLine="click_count_Increment_and_fill(btnZero.Text)";
_click_count_increment_and_fill(mostCurrent._btnzero.getText());
 //BA.debugLineNum = 847;BA.debugLine="End Sub";
return "";
}
public static int  _chek_tatil_day(int _year1,int _moon1,int _day1) throws Exception{
int _id_thisday = 0;
int _result_int = 0;
 //BA.debugLineNum = 3631;BA.debugLine="Sub chek_tatil_day (year1 As Int,moon1 As Int, day";
 //BA.debugLineNum = 3633;BA.debugLine="Dim id_thisDay As Int";
_id_thisday = 0;
 //BA.debugLineNum = 3634;BA.debugLine="id_thisDay=dbCode.get_day_id(year1,moon1,day1)";
_id_thisday = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_year1,_moon1,_day1);
 //BA.debugLineNum = 3636;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 3637;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id_thisday))));
 //BA.debugLineNum = 3639;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 3642;BA.debugLine="Dim result_int As Int=0";
_result_int = (int) (0);
 //BA.debugLineNum = 3643;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
 //BA.debugLineNum = 3644;BA.debugLine="result_int=1";
_result_int = (int) (1);
 }else if(((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil1"))) { 
 //BA.debugLineNum = 3646;BA.debugLine="result_int=2";
_result_int = (int) (2);
 };
 //BA.debugLineNum = 3653;BA.debugLine="Return result_int    ' result_int=0 is not tatil";
if (true) return _result_int;
 //BA.debugLineNum = 3655;BA.debugLine="End Sub";
return 0;
}
public static int  _chek_tatil_setting() throws Exception{
int _temp = 0;
int _sett_a = 0;
int _sett_b = 0;
 //BA.debugLineNum = 3657;BA.debugLine="Sub chek_tatil_setting As Int";
 //BA.debugLineNum = 3658;BA.debugLine="Dim temp As Int=0";
_temp = (int) (0);
 //BA.debugLineNum = 3659;BA.debugLine="Dim sett_a ,sett_b  As Int=0";
_sett_a = 0;
_sett_b = (int) (0);
 //BA.debugLineNum = 3661;BA.debugLine="sett_a=dbCode.get_setting_byName(\"setting_tatil_r";
_sett_a = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi")));
 //BA.debugLineNum = 3662;BA.debugLine="sett_b=dbCode.get_setting_byName(\"setting_tatil_g";
_sett_b = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi")));
 //BA.debugLineNum = 3665;BA.debugLine="If(sett_a=1)Then";
if ((_sett_a==1)) { 
 //BA.debugLineNum = 3666;BA.debugLine="temp=11";
_temp = (int) (11);
 //BA.debugLineNum = 3667;BA.debugLine="If (sett_b=1)Then";
if ((_sett_b==1)) { 
 //BA.debugLineNum = 3668;BA.debugLine="temp=1";
_temp = (int) (1);
 };
 }else {
 //BA.debugLineNum = 3672;BA.debugLine="temp=0";
_temp = (int) (0);
 //BA.debugLineNum = 3673;BA.debugLine="If (sett_b=1)Then";
if ((_sett_b==1)) { 
 //BA.debugLineNum = 3674;BA.debugLine="temp=22";
_temp = (int) (22);
 };
 };
 //BA.debugLineNum = 3679;BA.debugLine="Return temp";
if (true) return _temp;
 //BA.debugLineNum = 3681;BA.debugLine="End Sub";
return 0;
}
public static String  _chek_time_backup() throws Exception{
String _tim1_ck_backup = "";
String _tim2_ck_backup = "";
long _time_between = 0L;
int _days_for_backup = 0;
int _res_backup = 0;
 //BA.debugLineNum = 1131;BA.debugLine="Sub chek_time_backup";
 //BA.debugLineNum = 1135;BA.debugLine="If(File.Exists(File.DirInternal,\"chk_backup.txt\")";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"chk_backup.txt")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1136;BA.debugLine="File.WriteString(File.DirInternal,\"chk_backup.tx";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"chk_backup.txt",mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 }else {
 //BA.debugLineNum = 1139;BA.debugLine="Dim tim1_ck_backup As String=File.ReadString(Fil";
_tim1_ck_backup = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"chk_backup.txt");
 //BA.debugLineNum = 1140;BA.debugLine="Dim tim2_ck_backup As String=myfunc.fa2en(DateTi";
_tim2_ck_backup = mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 //BA.debugLineNum = 1141;BA.debugLine="Dim time_between As Long = persianDate.Calculate";
_time_between = _persiandate.CalculateDaysBetween(_tim1_ck_backup,_tim2_ck_backup);
 //BA.debugLineNum = 1143;BA.debugLine="Dim days_for_backup As Int";
_days_for_backup = 0;
 //BA.debugLineNum = 1144;BA.debugLine="Dim res_backup As Int = dbCode.get_setting_byNam";
_res_backup = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"backup_online")));
 //BA.debugLineNum = 1145;BA.debugLine="Select res_backup";
switch (_res_backup) {
case 0: {
 //BA.debugLineNum = 1147;BA.debugLine="days_for_backup=7";
_days_for_backup = (int) (7);
 break; }
case 1: {
 //BA.debugLineNum = 1149;BA.debugLine="days_for_backup=14";
_days_for_backup = (int) (14);
 break; }
case 2: {
 //BA.debugLineNum = 1151;BA.debugLine="days_for_backup=30";
_days_for_backup = (int) (30);
 break; }
case 3: {
 //BA.debugLineNum = 1153;BA.debugLine="days_for_backup=-1";
_days_for_backup = (int) (-1);
 break; }
}
;
 //BA.debugLineNum = 1159;BA.debugLine="If(days_for_backup<0)Then";
if ((_days_for_backup<0)) { 
 //BA.debugLineNum = 1160;BA.debugLine="is_time_backup=False";
_is_time_backup = anywheresoftware.b4a.keywords.Common.False;
 }else if((_time_between>=_days_for_backup)) { 
 //BA.debugLineNum = 1162;BA.debugLine="is_time_backup=True";
_is_time_backup = anywheresoftware.b4a.keywords.Common.True;
 };
 };
 //BA.debugLineNum = 1169;BA.debugLine="End Sub";
return "";
}
public static String  _chk_update_auto() throws Exception{
String _send2 = "";
 //BA.debugLineNum = 4294;BA.debugLine="Sub chk_update_auto";
 //BA.debugLineNum = 4296;BA.debugLine="user_request_update=False";
_user_request_update = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 4297;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 4299;BA.debugLine="ht.Initialize(\"chkupdate\",Me)";
mostCurrent._ht._initialize /*String*/ (processBA,"chkupdate",main.getObject());
 //BA.debugLineNum = 4300;BA.debugLine="Dim send2 As String";
_send2 = "";
 //BA.debugLineNum = 4301;BA.debugLine="send2 = \"var=checkupdate\"";
_send2 = "var=checkupdate";
 //BA.debugLineNum = 4302;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/chek_upda";
mostCurrent._ht._poststring /*String*/ ("https://taravatgroup.ir/chek_update.php",_send2);
 };
 //BA.debugLineNum = 4305;BA.debugLine="End Sub";
return "";
}
public static String  _ckb_ezaf_taradod_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 4381;BA.debugLine="Private Sub ckb_ezaf_taradod_CheckedChange(Checked";
 //BA.debugLineNum = 4382;BA.debugLine="If(Checked=True)Then";
if ((_checked==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 4383;BA.debugLine="radio_ez_adi.Enabled=True";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 4384;BA.debugLine="radio_ez_fog.Enabled=True";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 4386;BA.debugLine="radio_ez_adi.Enabled=False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4387;BA.debugLine="radio_ez_fog.Enabled=False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 4389;BA.debugLine="End Sub";
return "";
}
public static String  _ckb_ezaf_taradod_fs_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 4776;BA.debugLine="Private Sub ckb_ezaf_taradod_fs_CheckedChange(Chec";
 //BA.debugLineNum = 4777;BA.debugLine="If(Checked=True)Then";
if ((_checked==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 4778;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 4780;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 4782;BA.debugLine="End Sub";
return "";
}
public static String  _click_count_increment_and_fill(String _input_text) throws Exception{
 //BA.debugLineNum = 885;BA.debugLine="Sub click_count_Increment_and_fill (input_Text As";
 //BA.debugLineNum = 887;BA.debugLine="Click_Count = Click_Count + 1";
_click_count = (int) (_click_count+1);
 //BA.debugLineNum = 889;BA.debugLine="Select Click_Count";
switch (_click_count) {
case 1: {
 //BA.debugLineNum = 891;BA.debugLine="key1.Color = Colors.Red";
mostCurrent._key1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 894;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 2: {
 //BA.debugLineNum = 897;BA.debugLine="key2.Color = Colors.Red";
mostCurrent._key2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 900;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 3: {
 //BA.debugLineNum = 903;BA.debugLine="key3.Color = Colors.Red";
mostCurrent._key3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 906;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 4: {
 //BA.debugLineNum = 909;BA.debugLine="key4.Color = Colors.Red";
mostCurrent._key4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 912;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 //BA.debugLineNum = 918;BA.debugLine="If entered_Password = Master_Password Then";
if ((mostCurrent._entered_password).equals(mostCurrent._master_password)) { 
 //BA.debugLineNum = 921;BA.debugLine="resetting_all";
_resetting_all();
 //BA.debugLineNum = 923;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 925;BA.debugLine="ToastMessageShow(\"رمز عبور اشتباه است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("رمز عبور اشتباه است"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 929;BA.debugLine="resetting_all";
_resetting_all();
 };
 break; }
}
;
 //BA.debugLineNum = 934;BA.debugLine="End Sub";
return "";
}
public static String  _cust_lv_taradod_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 4136;BA.debugLine="Private Sub cust_LV_taradod_ItemClick (Index As In";
 //BA.debugLineNum = 4138;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_gozareshat(String _year1) throws Exception{
 //BA.debugLineNum = 1662;BA.debugLine="Sub fill_list_gozareshat(year1 As String)";
 //BA.debugLineNum = 1663;BA.debugLine="CLV_gozaresh.Clear";
mostCurrent._clv_gozaresh._clear();
 //BA.debugLineNum = 1664;BA.debugLine="list_gozareshat_id.Clear";
mostCurrent._list_gozareshat_id.Clear();
 //BA.debugLineNum = 1666;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1667;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ORDER BY  id DESC;")));
 //BA.debugLineNum = 1668;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1671;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"");
 //BA.debugLineNum = 1672;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 96%x, 114dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (114)));
 //BA.debugLineNum = 1673;BA.debugLine="p.LoadLayout(\"item_list_2\")";
mostCurrent._p.LoadLayout("item_list_2",mostCurrent.activityBA);
 //BA.debugLineNum = 1675;BA.debugLine="CLV_gozaresh.Add(p,dbCode.res.GetString(\"id\"))";
mostCurrent._clv_gozaresh._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1676;BA.debugLine="lbl_dateGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_dategozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date")));
 //BA.debugLineNum = 1677;BA.debugLine="lbl_nameGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_namegozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title")));
 //BA.debugLineNum = 1678;BA.debugLine="lbl_tozihGozaresh_CLV.Text=dbCode.res.GetString(";
mostCurrent._lbl_tozihgozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozih")));
 //BA.debugLineNum = 1679;BA.debugLine="lbl_remove_from_list2.Tag=dbCode.res.GetString(\"";
mostCurrent._lbl_remove_from_list2.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1680;BA.debugLine="pan_item_gozaresh.Tag=dbCode.res.GetString(\"id\")";
mostCurrent._pan_item_gozaresh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1681;BA.debugLine="list_gozareshat_id.Add(dbCode.res.GetString(\"id\"";
mostCurrent._list_gozareshat_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1682;BA.debugLine="Log(dbCode.res.GetString(\"id\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("52621460",mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id"),0);
 }
;
 //BA.debugLineNum = 1684;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1685;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1687;BA.debugLine="End Sub";
return "";
}
public static String  _fill_lists(String _year1,String _moon1) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _str1 = null;
anywheresoftware.b4a.objects.collections.List _ls_ezafe = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _str2 = null;
anywheresoftware.b4a.objects.collections.List _ls_morkh = null;
anywheresoftware.b4a.objects.B4XViewWrapper _p2 = null;
anywheresoftware.b4a.objects.collections.List _ls_tarad = null;
anywheresoftware.b4a.objects.collections.List _ls_mamor = null;
 //BA.debugLineNum = 1303;BA.debugLine="Sub fill_lists (year1 As String, moon1 As String)";
 //BA.debugLineNum = 1306;BA.debugLine="cust_LV_ezafekari.Clear";
mostCurrent._cust_lv_ezafekari._clear();
 //BA.debugLineNum = 1307;BA.debugLine="list_ezafekari_id.Clear";
mostCurrent._list_ezafekari_id.Clear();
 //BA.debugLineNum = 1309;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1310;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
 //BA.debugLineNum = 1311;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1312;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1313;BA.debugLine="str1.Initialize";
_str1.Initialize();
 //BA.debugLineNum = 1317;BA.debugLine="Dim ls_ezafe As List";
_ls_ezafe = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1318;BA.debugLine="ls_ezafe.Initialize";
_ls_ezafe.Initialize();
 //BA.debugLineNum = 1320;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz2_dontDay(dbCod";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 //BA.debugLineNum = 1322;BA.debugLine="If((ls_ezafe.Get(0))<>0)Then";
if ((((_ls_ezafe.Get((int) (0)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1323;BA.debugLine="str1.Append(ls_ezafe.Get(0)&\" ساعت \")";
_str1.Append(BA.ObjectToString(_ls_ezafe.Get((int) (0)))+" ساعت ");
 //BA.debugLineNum = 1324;BA.debugLine="If((ls_ezafe.Get(1))<>0)Then";
if ((((_ls_ezafe.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1325;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
 //BA.debugLineNum = 1328;BA.debugLine="If((ls_ezafe.Get(1))<>0)Then";
if ((((_ls_ezafe.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1329;BA.debugLine="str1.Append(ls_ezafe.Get(1)&\" دقیقه \")";
_str1.Append(BA.ObjectToString(_ls_ezafe.Get((int) (1)))+" دقیقه ");
 };
 //BA.debugLineNum = 1333;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1334;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
 //BA.debugLineNum = 1335;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
 //BA.debugLineNum = 1337;BA.debugLine="cust_LV_ezafekari.Add(p,dbCode.res.GetString(\"id";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1339;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
 //BA.debugLineNum = 1342;BA.debugLine="lbl_date_CLV.Text=\"از : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("از : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
 //BA.debugLineNum = 1343;BA.debugLine="lbl_hour_CLV.Text=\"تا : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("تا : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
 //BA.debugLineNum = 1346;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str1.ToString()));
 //BA.debugLineNum = 1347;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 1348;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1349;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1351;BA.debugLine="list_ezafekari_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_ezafekari_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
 //BA.debugLineNum = 1356;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1357;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1359;BA.debugLine="If(cust_LV_ezafekari.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_ezafekari._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 1360;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1361;BA.debugLine="Select cust_LV_ezafekari.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_ezafekari._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 1363;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
 //BA.debugLineNum = 1365;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 1367;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 1369;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 1371;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 1373;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 1375;BA.debugLine="cust_LV_ezafekari.Add(p,\"\")";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(""));
 };
 //BA.debugLineNum = 1379;BA.debugLine="cust_LV_morakhasi.Clear";
mostCurrent._cust_lv_morakhasi._clear();
 //BA.debugLineNum = 1380;BA.debugLine="list_morakhasi_id.Clear";
mostCurrent._list_morakhasi_id.Clear();
 //BA.debugLineNum = 1382;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1383;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
 //BA.debugLineNum = 1384;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1385;BA.debugLine="Dim str2 As StringBuilder";
_str2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1386;BA.debugLine="str2.Initialize";
_str2.Initialize();
 //BA.debugLineNum = 1388;BA.debugLine="Dim ls_morkh As List";
_ls_morkh = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1389;BA.debugLine="ls_morkh.Initialize";
_ls_morkh.Initialize();
 //BA.debugLineNum = 1391;BA.debugLine="ls_morkh=myfunc.Min_to_saatMinRoz(dbCode.res.Get";
_ls_morkh = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 //BA.debugLineNum = 1395;BA.debugLine="If((ls_morkh.Get(2))<>0)Then";
if ((((_ls_morkh.Get((int) (2)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1396;BA.debugLine="str2.Append(ls_morkh.Get(2)&\" روز \")";
_str2.Append(BA.ObjectToString(_ls_morkh.Get((int) (2)))+" روز ");
 //BA.debugLineNum = 1397;BA.debugLine="If((ls_morkh.Get(0))<>0 Or (ls_morkh.Get(1))<>0";
if ((((_ls_morkh.Get((int) (0)))).equals((Object)(0)) == false || ((_ls_morkh.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1398;BA.debugLine="str2.Append(CRLF)";
_str2.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
 //BA.debugLineNum = 1401;BA.debugLine="If((ls_morkh.Get(0))<>0)Then";
if ((((_ls_morkh.Get((int) (0)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1402;BA.debugLine="str2.Append(ls_morkh.Get(0)&\" ساعت \")";
_str2.Append(BA.ObjectToString(_ls_morkh.Get((int) (0)))+" ساعت ");
 //BA.debugLineNum = 1403;BA.debugLine="If((ls_morkh.Get(1))<>0)Then";
if ((((_ls_morkh.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1404;BA.debugLine="str2.Append(CRLF)";
_str2.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
 //BA.debugLineNum = 1407;BA.debugLine="If((ls_morkh.Get(1))<>0)Then";
if ((((_ls_morkh.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1408;BA.debugLine="str2.Append(ls_morkh.Get(1)&\" دقیقه \")";
_str2.Append(BA.ObjectToString(_ls_morkh.Get((int) (1)))+" دقیقه ");
 };
 //BA.debugLineNum = 1412;BA.debugLine="Dim p2 As B4XView = xui.CreatePanel(\"\")";
_p2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p2 = mostCurrent._xui.CreatePanel(processBA,"");
 //BA.debugLineNum = 1413;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
 //BA.debugLineNum = 1414;BA.debugLine="p2.LoadLayout(\"item_list\")";
_p2.LoadLayout("item_list",mostCurrent.activityBA);
 //BA.debugLineNum = 1416;BA.debugLine="cust_LV_morakhasi.Add(p2,dbCode.res.GetString(\"i";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1418;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
 //BA.debugLineNum = 1420;BA.debugLine="lbl_date_CLV.Text=\"از : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("از : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
 //BA.debugLineNum = 1421;BA.debugLine="lbl_hour_CLV.Text=\"تا : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("تا : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
 //BA.debugLineNum = 1422;BA.debugLine="lbl_time_CLV.Text=str2.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str2.ToString()));
 //BA.debugLineNum = 1423;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 1424;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1425;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1427;BA.debugLine="list_morakhasi_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_morakhasi_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
 //BA.debugLineNum = 1432;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1433;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1439;BA.debugLine="If(cust_LV_morakhasi.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_morakhasi._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 1440;BA.debugLine="p2 = xui.CreatePanel(\"p\")";
_p2 = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1441;BA.debugLine="Select cust_LV_morakhasi.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_morakhasi._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 1443;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
 //BA.debugLineNum = 1445;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 1447;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 1449;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 1451;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 1453;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 1455;BA.debugLine="cust_LV_morakhasi.Add(p2,\"\")";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(""));
 };
 //BA.debugLineNum = 1460;BA.debugLine="cust_LV_taradod.Clear";
mostCurrent._cust_lv_taradod._clear();
 //BA.debugLineNum = 1461;BA.debugLine="list_taradod_id.Clear";
mostCurrent._list_taradod_id.Clear();
 //BA.debugLineNum = 1463;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1464;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
 //BA.debugLineNum = 1465;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1466;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1467;BA.debugLine="str1.Initialize";
_str1.Initialize();
 //BA.debugLineNum = 1469;BA.debugLine="Dim ls_tarad As List";
_ls_tarad = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1470;BA.debugLine="ls_tarad.Initialize";
_ls_tarad.Initialize();
 //BA.debugLineNum = 1472;BA.debugLine="ls_tarad=myfunc.Min_to_saatMinRoz(dbCode.res.Get";
_ls_tarad = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 //BA.debugLineNum = 1476;BA.debugLine="If((ls_tarad.Get(2))<>0)Then";
if ((((_ls_tarad.Get((int) (2)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1477;BA.debugLine="str1.Append(ls_tarad.Get(2)&\" روز \")";
_str1.Append(BA.ObjectToString(_ls_tarad.Get((int) (2)))+" روز ");
 //BA.debugLineNum = 1478;BA.debugLine="If((ls_tarad.Get(0))<>0 Or (ls_tarad.Get(1))<>0";
if ((((_ls_tarad.Get((int) (0)))).equals((Object)(0)) == false || ((_ls_tarad.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1479;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
 //BA.debugLineNum = 1482;BA.debugLine="If((ls_tarad.Get(0))<>0)Then";
if ((((_ls_tarad.Get((int) (0)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1483;BA.debugLine="str1.Append(ls_tarad.Get(0)&\" ساعت \")";
_str1.Append(BA.ObjectToString(_ls_tarad.Get((int) (0)))+" ساعت ");
 //BA.debugLineNum = 1484;BA.debugLine="If((ls_tarad.Get(1))<>0)Then";
if ((((_ls_tarad.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1485;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
 //BA.debugLineNum = 1488;BA.debugLine="If((ls_tarad.Get(1))<>0)Then";
if ((((_ls_tarad.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1489;BA.debugLine="str1.Append(ls_tarad.Get(1)&\" دقیقه \")";
_str1.Append(BA.ObjectToString(_ls_tarad.Get((int) (1)))+" دقیقه ");
 };
 //BA.debugLineNum = 1493;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1494;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
 //BA.debugLineNum = 1495;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
 //BA.debugLineNum = 1497;BA.debugLine="cust_LV_taradod.Add(p,dbCode.res.GetString(\"id\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1499;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
 //BA.debugLineNum = 1501;BA.debugLine="lbl_date_CLV.Text=\"ورود : \"&dbCode.res.GetString";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("ورود : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
 //BA.debugLineNum = 1502;BA.debugLine="lbl_hour_CLV.Text=\"خروج : \"&dbCode.res.GetString";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("خروج : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
 //BA.debugLineNum = 1504;BA.debugLine="lbl_time_CLV.Typeface=Typeface.MATERIALICONS";
mostCurrent._lbl_time_clv.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
 //BA.debugLineNum = 1505;BA.debugLine="lbl_time_CLV.Text=Chr(0xE8D5)";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe8d5))));
 //BA.debugLineNum = 1506;BA.debugLine="lbl_time_CLV.TextSize=25";
mostCurrent._lbl_time_clv.setTextSize((float) (25));
 //BA.debugLineNum = 1508;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 1509;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1510;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1512;BA.debugLine="list_taradod_id.Add(dbCode.res.GetString(\"id\"))";
mostCurrent._list_taradod_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
 //BA.debugLineNum = 1517;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1518;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1520;BA.debugLine="If(cust_LV_taradod.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_taradod._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 1521;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1522;BA.debugLine="Select cust_LV_taradod.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_taradod._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 1524;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
 //BA.debugLineNum = 1526;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 1528;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 1530;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 1532;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 1534;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 1536;BA.debugLine="cust_LV_taradod.Add(p,\"\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(""));
 };
 //BA.debugLineNum = 1542;BA.debugLine="cust_LV_mamoriat.Clear";
mostCurrent._cust_lv_mamoriat._clear();
 //BA.debugLineNum = 1543;BA.debugLine="list_mamoriat_id.Clear";
mostCurrent._list_mamoriat_id.Clear();
 //BA.debugLineNum = 1546;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1547;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
 //BA.debugLineNum = 1550;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1551;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1552;BA.debugLine="str1.Initialize";
_str1.Initialize();
 //BA.debugLineNum = 1554;BA.debugLine="Dim ls_mamor As List";
_ls_mamor = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1555;BA.debugLine="ls_mamor.Initialize";
_ls_mamor.Initialize();
 //BA.debugLineNum = 1557;BA.debugLine="ls_mamor=myfunc.Min_to_saatMinRoz(dbCode.res.Get";
_ls_mamor = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 //BA.debugLineNum = 1561;BA.debugLine="If((ls_mamor.Get(2))<>0)Then";
if ((((_ls_mamor.Get((int) (2)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1562;BA.debugLine="str1.Append(ls_mamor.Get(2)&\" روز \")";
_str1.Append(BA.ObjectToString(_ls_mamor.Get((int) (2)))+" روز ");
 //BA.debugLineNum = 1563;BA.debugLine="If((ls_mamor.Get(0))<>0 Or (ls_mamor.Get(1))<>0";
if ((((_ls_mamor.Get((int) (0)))).equals((Object)(0)) == false || ((_ls_mamor.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1564;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
 //BA.debugLineNum = 1567;BA.debugLine="If((ls_mamor.Get(0))<>0)Then";
if ((((_ls_mamor.Get((int) (0)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1568;BA.debugLine="str1.Append(ls_mamor.Get(0)&\" ساعت \")";
_str1.Append(BA.ObjectToString(_ls_mamor.Get((int) (0)))+" ساعت ");
 //BA.debugLineNum = 1569;BA.debugLine="If((ls_mamor.Get(1))<>0)Then";
if ((((_ls_mamor.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1570;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
 //BA.debugLineNum = 1573;BA.debugLine="If((ls_mamor.Get(1))<>0)Then";
if ((((_ls_mamor.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1574;BA.debugLine="str1.Append(ls_mamor.Get(1)&\" دقیقه \")";
_str1.Append(BA.ObjectToString(_ls_mamor.Get((int) (1)))+" دقیقه ");
 };
 //BA.debugLineNum = 1578;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1579;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
 //BA.debugLineNum = 1580;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
 //BA.debugLineNum = 1582;BA.debugLine="cust_LV_mamoriat.Add(p,dbCode.res.GetString(\"id\"";
mostCurrent._cust_lv_mamoriat._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1584;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
 //BA.debugLineNum = 1586;BA.debugLine="lbl_date_CLV.Text=\"از : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("از : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
 //BA.debugLineNum = 1587;BA.debugLine="lbl_hour_CLV.Text=\"تا : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("تا : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
 //BA.debugLineNum = 1588;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str1.ToString()));
 //BA.debugLineNum = 1589;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 1590;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1591;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1593;BA.debugLine="list_mamoriat_id.Add(dbCode.res.GetString(\"id\"))";
mostCurrent._list_mamoriat_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
 //BA.debugLineNum = 1598;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1599;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1603;BA.debugLine="If(cust_LV_mamoriat.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_mamoriat._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 1604;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1605;BA.debugLine="Select cust_LV_mamoriat.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_mamoriat._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 1607;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
 //BA.debugLineNum = 1609;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 1611;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 1613;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 1615;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 1617;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 1619;BA.debugLine="cust_LV_mamoriat.Add(p,\"\")";
mostCurrent._cust_lv_mamoriat._add(mostCurrent._p,(Object)(""));
 };
 //BA.debugLineNum = 1623;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
 //BA.debugLineNum = 1625;BA.debugLine="End Sub";
return "";
}
public static String  _finger_scaning() throws Exception{
 //BA.debugLineNum = 829;BA.debugLine="Sub finger_scaning";
 //BA.debugLineNum = 830;BA.debugLine="fingerprint.Authenticate";
mostCurrent._fingerprint._authenticate /*String*/ ();
 //BA.debugLineNum = 831;BA.debugLine="ToastMessageShow(\"Scanning...\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Scanning..."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 832;BA.debugLine="End Sub";
return "";
}
public static String  _get_dataedit_byid(int _id1) throws Exception{
 //BA.debugLineNum = 3913;BA.debugLine="Sub get_dataEdit_byId(id1 As Int)";
 //BA.debugLineNum = 3914;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 3915;BA.debugLine="If(index_box=1)Then";
if ((_index_box==1)) { 
 //BA.debugLineNum = 3916;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE id="+BA.NumberToString(_id1))));
 //BA.debugLineNum = 3917;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 3919;BA.debugLine="If(dbCode.res.GetInt(\"state\")=0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==0)) { 
 //BA.debugLineNum = 3920;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 3922;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
 }else if((_index_box==2)) { 
 //BA.debugLineNum = 3928;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE id="+BA.NumberToString(_id1))));
 //BA.debugLineNum = 3929;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 3932;BA.debugLine="Select dbCode.res.GetInt(\"state\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
 //BA.debugLineNum = 3934;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
 //BA.debugLineNum = 3936;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
 //BA.debugLineNum = 3938;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
 //BA.debugLineNum = 3940;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
 //BA.debugLineNum = 3944;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
 //BA.debugLineNum = 3945;BA.debugLine="index_noe_morakhasi=dbCode.res.GetInt(\"state\")";
_index_noe_morakhasi = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state");
 }else if((_index_box==3)) { 
 //BA.debugLineNum = 3950;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE id="+BA.NumberToString(_id1))));
 //BA.debugLineNum = 3951;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 }else if((_index_box==5)) { 
 //BA.debugLineNum = 3955;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mamoriat WHERE id="+BA.NumberToString(_id1))));
 //BA.debugLineNum = 3956;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 };
 //BA.debugLineNum = 3963;BA.debugLine="lbl_tim1.Text=dbCode.res.GetString(\"time_from\")";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")));
 //BA.debugLineNum = 3964;BA.debugLine="lbl_tim2.Text=dbCode.res.GetString(\"time_to\")";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
 //BA.debugLineNum = 3966;BA.debugLine="lbl_date1.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
 //BA.debugLineNum = 3967;BA.debugLine="lbl_date2.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))));
 //BA.debugLineNum = 3969;BA.debugLine="et_tozihat.Text=dbCode.res.GetString(\"tozihat\")";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 3972;BA.debugLine="End Sub";
return "";
}
public static String  _get_today_shift() throws Exception{
int _id_today = 0;
String _str_sh = "";
 //BA.debugLineNum = 1171;BA.debugLine="Sub get_today_shift";
 //BA.debugLineNum = 1172;BA.debugLine="Dim id_today As Int";
_id_today = 0;
 //BA.debugLineNum = 1173;BA.debugLine="id_today=dbCode.get_day_id(persianDate.PersianYea";
_id_today = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_persiandate.getPersianYear(),_persiandate.getPersianMonth(),_persiandate.getPersianDay());
 //BA.debugLineNum = 1175;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1176;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id_today))));
 //BA.debugLineNum = 1178;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 1182;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")).equals("") == false)) { 
 //BA.debugLineNum = 1183;BA.debugLine="Dim str_sh As String";
_str_sh = "";
 //BA.debugLineNum = 1184;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift"),"ر","ش","ع","ا")) {
case 0: {
 //BA.debugLineNum = 1186;BA.debugLine="str_sh=\"روزکار\"";
_str_sh = "روزکار";
 break; }
case 1: {
 //BA.debugLineNum = 1188;BA.debugLine="str_sh=\"شبکار\"";
_str_sh = "شبکار";
 break; }
case 2: {
 //BA.debugLineNum = 1190;BA.debugLine="str_sh=\"عصرکار\"";
_str_sh = "عصرکار";
 break; }
case 3: {
 //BA.debugLineNum = 1192;BA.debugLine="str_sh=\"استراحت\"";
_str_sh = "استراحت";
 break; }
}
;
 //BA.debugLineNum = 1194;BA.debugLine="lbl_shift_home.Text=\"(\"&str_sh&\")\"";
mostCurrent._lbl_shift_home.setText(BA.ObjectToCharSequence("("+_str_sh+")"));
 };
 //BA.debugLineNum = 1199;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 70;BA.debugLine="Dim xui As XUI";
mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 72;BA.debugLine="Private lbl_date_home As Label";
mostCurrent._lbl_date_home = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 75;BA.debugLine="Private pan_all As Panel";
mostCurrent._pan_all = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 76;BA.debugLine="Private lbl_box_title As Label";
mostCurrent._lbl_box_title = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 81;BA.debugLine="Dim index_box As Int";
_index_box = 0;
 //BA.debugLineNum = 82;BA.debugLine="Dim year_bt As Int =0";
_year_bt = (int) (0);
 //BA.debugLineNum = 83;BA.debugLine="Dim moon_bt As Int =0";
_moon_bt = (int) (0);
 //BA.debugLineNum = 84;BA.debugLine="Dim day_bt As Int =0";
_day_bt = (int) (0);
 //BA.debugLineNum = 85;BA.debugLine="Dim hour_bt As Int =0";
_hour_bt = (int) (0);
 //BA.debugLineNum = 86;BA.debugLine="Dim min_bt As Int =0";
_min_bt = (int) (0);
 //BA.debugLineNum = 87;BA.debugLine="Dim num As Int=0  '' for time picker";
_num = (int) (0);
 //BA.debugLineNum = 88;BA.debugLine="Dim moon As List  '' for date picker";
mostCurrent._moon = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 90;BA.debugLine="Dim date1 As String";
mostCurrent._date1 = "";
 //BA.debugLineNum = 91;BA.debugLine="Dim date2 As String";
mostCurrent._date2 = "";
 //BA.debugLineNum = 93;BA.debugLine="Dim list_ezafekari_id As List";
mostCurrent._list_ezafekari_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 94;BA.debugLine="Dim list_morakhasi_id As List";
mostCurrent._list_morakhasi_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 95;BA.debugLine="Dim list_taradod_id As List";
mostCurrent._list_taradod_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 96;BA.debugLine="Dim list_mamoriat_id As List";
mostCurrent._list_mamoriat_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 97;BA.debugLine="Dim list_gozareshat_id As List";
mostCurrent._list_gozareshat_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 100;BA.debugLine="Dim curent_tab_list As Int =0";
_curent_tab_list = (int) (0);
 //BA.debugLineNum = 103;BA.debugLine="Private pan_main As Panel";
mostCurrent._pan_main = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 104;BA.debugLine="Private pan_imag As Panel";
mostCurrent._pan_imag = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 107;BA.debugLine="Private TabHost1 As TabHost";
mostCurrent._tabhost1 = new anywheresoftware.b4a.objects.TabHostWrapper();
 //BA.debugLineNum = 111;BA.debugLine="Dim img1 As BitmapDrawable";
mostCurrent._img1 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 112;BA.debugLine="Dim img2 As BitmapDrawable";
mostCurrent._img2 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 113;BA.debugLine="Dim img3 As BitmapDrawable";
mostCurrent._img3 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 117;BA.debugLine="Dim index_page As Int";
_index_page = 0;
 //BA.debugLineNum = 118;BA.debugLine="Dim index_piker As Int";
_index_piker = 0;
 //BA.debugLineNum = 121;BA.debugLine="Private lbl_time_show As Label";
mostCurrent._lbl_time_show = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 122;BA.debugLine="Private pik_min1 As Label";
mostCurrent._pik_min1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 123;BA.debugLine="Private pik_hour1 As Label";
mostCurrent._pik_hour1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 127;BA.debugLine="Private pik_day1 As Label";
mostCurrent._pik_day1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 128;BA.debugLine="Private pik_year1 As Label";
mostCurrent._pik_year1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 129;BA.debugLine="Private pik_moon1 As Label";
mostCurrent._pik_moon1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 131;BA.debugLine="Private sp_moon As Spinner";
mostCurrent._sp_moon = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 132;BA.debugLine="Private sp_year As Spinner";
mostCurrent._sp_year = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 133;BA.debugLine="Private et_tozihat As EditText";
mostCurrent._et_tozihat = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 134;BA.debugLine="Private scv_home_item As ScrollView";
mostCurrent._scv_home_item = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 135;BA.debugLine="Private lbl_tim1 As Label";
mostCurrent._lbl_tim1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 136;BA.debugLine="Private lbl_date1 As Label";
mostCurrent._lbl_date1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 137;BA.debugLine="Private lbl_date2 As Label";
mostCurrent._lbl_date2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 138;BA.debugLine="Private lbl_tim2 As Label";
mostCurrent._lbl_tim2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 139;BA.debugLine="Private pan_picker As Panel";
mostCurrent._pan_picker = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 140;BA.debugLine="Private pan_all2 As Panel";
mostCurrent._pan_all2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 143;BA.debugLine="Dim strfun As StringFunctions";
mostCurrent._strfun = new adr.stringfunctions.stringfunctions();
 //BA.debugLineNum = 145;BA.debugLine="Private cust_LV_ezafekari As CustomListView";
mostCurrent._cust_lv_ezafekari = new b4a.example3.customlistview();
 //BA.debugLineNum = 146;BA.debugLine="Private lbl_date_CLV As Label";
mostCurrent._lbl_date_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 147;BA.debugLine="Private lbl_time_CLV As Label";
mostCurrent._lbl_time_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 148;BA.debugLine="Private lbl_hour_CLV As Label";
mostCurrent._lbl_hour_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 149;BA.debugLine="Private lbl_tozih_CLV As Label";
mostCurrent._lbl_tozih_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 150;BA.debugLine="Private cust_LV_morakhasi As CustomListView";
mostCurrent._cust_lv_morakhasi = new b4a.example3.customlistview();
 //BA.debugLineNum = 151;BA.debugLine="Private CLV_gozaresh As CustomListView";
mostCurrent._clv_gozaresh = new b4a.example3.customlistview();
 //BA.debugLineNum = 152;BA.debugLine="Private lbl_dateGozaresh_CLV As Label";
mostCurrent._lbl_dategozaresh_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 153;BA.debugLine="Private lbl_nameGozaresh_CLV As Label";
mostCurrent._lbl_namegozaresh_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 154;BA.debugLine="Private lbl_tozihGozaresh_CLV As Label";
mostCurrent._lbl_tozihgozaresh_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 155;BA.debugLine="Private lbl_ezafekari_mah_m As Label";
mostCurrent._lbl_ezafekari_mah_m = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 156;BA.debugLine="Private lbl_ezafekari_mah_h As Label";
mostCurrent._lbl_ezafekari_mah_h = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 157;BA.debugLine="Private lbl_morakhasi_mah_m As Label";
mostCurrent._lbl_morakhasi_mah_m = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 158;BA.debugLine="Private lbl_morakhasi_mah_h As Label";
mostCurrent._lbl_morakhasi_mah_h = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 159;BA.debugLine="Private lbl_morakhasi_mah_d As Label";
mostCurrent._lbl_morakhasi_mah_d = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 165;BA.debugLine="Dim p As B4XView";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 168;BA.debugLine="Dim key As String= \"MIHNMA0GCSqGSIb3DQEBAQUAA4G7A";
mostCurrent._key = "MIHNMA0GCSqGSIb3DQEBAQUAA4G7ADCBtwKBrwDZmEdlPq6691EaSKn8zBkr1hyrYE3RPU4xYwuVh69GnEP3HIKQhrEYqti4EL5re8GJS4itFD5nfbmy+U67aqJcl9zcWWpRIBtQN9wYZF8vZ1Ooz/8h2V4hjiVjRZ9MO/o68voESDIpdYTsj4yyapRRZe9iLosW7lH3ZCHStJFWZQiC0WyJ69HYB3v94DchwDd1EE2HNJwcGR/x4okAI5AFLrfIsMgQAyy32Rl6t8UCAwEAAQ==";
 //BA.debugLineNum = 171;BA.debugLine="Dim inapp As BillingManager3";
mostCurrent._inapp = new anywheresoftware.b4a.inappbilling3.BillingManager3();
 //BA.debugLineNum = 172;BA.debugLine="Private lbl_vip As Label";
mostCurrent._lbl_vip = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 174;BA.debugLine="Private img_help As ImageView";
mostCurrent._img_help = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 175;BA.debugLine="Dim index_x_start_swap As Int=0";
_index_x_start_swap = (int) (0);
 //BA.debugLineNum = 176;BA.debugLine="Dim index_curent_img As Int=1";
_index_curent_img = (int) (1);
 //BA.debugLineNum = 177;BA.debugLine="Private pan_help As Panel";
mostCurrent._pan_help = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 178;BA.debugLine="Private lbl_remove_from_list As Label";
mostCurrent._lbl_remove_from_list = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 179;BA.debugLine="Private lbl_remove_from_list2 As Label";
mostCurrent._lbl_remove_from_list2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 181;BA.debugLine="Private cv_loader As B4XLoadingIndicator";
mostCurrent._cv_loader = new ir.taravatgroup.ezafekari2.b4xloadingindicator();
 //BA.debugLineNum = 182;BA.debugLine="Private lbl_vip2 As Label";
mostCurrent._lbl_vip2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 183;BA.debugLine="Private lbl_show_vip As Label";
mostCurrent._lbl_show_vip = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 184;BA.debugLine="Private lbl_vip_now As Label";
mostCurrent._lbl_vip_now = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 185;BA.debugLine="Private pan_all_noskhe As Panel";
mostCurrent._pan_all_noskhe = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 188;BA.debugLine="Private pik_min_bala1 As Label";
mostCurrent._pik_min_bala1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 189;BA.debugLine="Private pik_hour_bala1 As Label";
mostCurrent._pik_hour_bala1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 190;BA.debugLine="Private pik_min_paeen1 As Label";
mostCurrent._pik_min_paeen1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 191;BA.debugLine="Private pik_hour_paeen1 As Label";
mostCurrent._pik_hour_paeen1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 192;BA.debugLine="Private scroll_v_noskhe As ScrollView";
mostCurrent._scroll_v_noskhe = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 195;BA.debugLine="Dim bit_img0 As Bitmap";
mostCurrent._bit_img0 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 196;BA.debugLine="Dim bit_img1 As Bitmap";
mostCurrent._bit_img1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 197;BA.debugLine="Dim bit_img2 As Bitmap";
mostCurrent._bit_img2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 198;BA.debugLine="Dim bit_img3 As Bitmap";
mostCurrent._bit_img3 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 199;BA.debugLine="Dim bit_img4 As Bitmap";
mostCurrent._bit_img4 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 202;BA.debugLine="Private lbl_close_help As Label";
mostCurrent._lbl_close_help = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 203;BA.debugLine="Private lbl_time_as As Label";
mostCurrent._lbl_time_as = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 204;BA.debugLine="Private lbl_time_ta As Label";
mostCurrent._lbl_time_ta = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 205;BA.debugLine="Private cust_LV_taradod As CustomListView";
mostCurrent._cust_lv_taradod = new b4a.example3.customlistview();
 //BA.debugLineNum = 207;BA.debugLine="Dim ht As HttpJob";
mostCurrent._ht = new ir.taravatgroup.ezafekari2.httpjob();
 //BA.debugLineNum = 209;BA.debugLine="Dim msg As String=\"\"";
mostCurrent._msg = "";
 //BA.debugLineNum = 211;BA.debugLine="Private pan_notifi_all As Panel";
mostCurrent._pan_notifi_all = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 212;BA.debugLine="Private web_msg_show As WebView";
mostCurrent._web_msg_show = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 215;BA.debugLine="Dim ls1 As List		'num msg";
mostCurrent._ls1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 216;BA.debugLine="Dim ls2 As List		'msg";
mostCurrent._ls2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 217;BA.debugLine="Dim ls3 As List		'date msg";
mostCurrent._ls3 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 219;BA.debugLine="Dim last_notif As String =\"0000\"";
mostCurrent._last_notif = "0000";
 //BA.debugLineNum = 220;BA.debugLine="Dim is_now_instal As Boolean=True";
_is_now_instal = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 222;BA.debugLine="Private lbl_title_msgPan As Label";
mostCurrent._lbl_title_msgpan = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 223;BA.debugLine="Private pan_notif As Panel";
mostCurrent._pan_notif = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 227;BA.debugLine="Private ckb_ezaf_taradod As CheckBox";
mostCurrent._ckb_ezaf_taradod = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 228;BA.debugLine="Private lbl_ezaf_taradod As Label";
mostCurrent._lbl_ezaf_taradod = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 229;BA.debugLine="Private pan_ezaf_taradod As Panel";
mostCurrent._pan_ezaf_taradod = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 230;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 231;BA.debugLine="Private pan_hed_list As Panel";
mostCurrent._pan_hed_list = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 232;BA.debugLine="Private pan_hed_gozaresh As Panel";
mostCurrent._pan_hed_gozaresh = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 237;BA.debugLine="Private pan_all_msgNewYear As Panel";
mostCurrent._pan_all_msgnewyear = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 238;BA.debugLine="Private lbl_majmoe_saat As Label";
mostCurrent._lbl_majmoe_saat = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 239;BA.debugLine="Private pan_all_liteMenu As Panel";
mostCurrent._pan_all_litemenu = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 240;BA.debugLine="Private lbl_shift_home As Label";
mostCurrent._lbl_shift_home = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 241;BA.debugLine="Private sp_year_gozaresh As Spinner";
mostCurrent._sp_year_gozaresh = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 242;BA.debugLine="Private pan_item_gozaresh As Panel";
mostCurrent._pan_item_gozaresh = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 245;BA.debugLine="Dim rsPOP_noe As RSPopupMenu";
mostCurrent._rspop_noe = new com.rootsoft.rspopupmenu.RSPopupMenu();
 //BA.debugLineNum = 246;BA.debugLine="Dim index_noe_morakhasi As Int=0";
_index_noe_morakhasi = (int) (0);
 //BA.debugLineNum = 247;BA.debugLine="Dim str_noe As String=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 //BA.debugLineNum = 248;BA.debugLine="Private lbl_edit_from_list As Label";
mostCurrent._lbl_edit_from_list = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 251;BA.debugLine="Dim current_id_edit As Int=0";
_current_id_edit = (int) (0);
 //BA.debugLineNum = 252;BA.debugLine="Dim	is_for_edit As Boolean=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 255;BA.debugLine="Dim tim_min As Int";
_tim_min = 0;
 //BA.debugLineNum = 257;BA.debugLine="Private lbl_vesion_app As Label";
mostCurrent._lbl_vesion_app = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 260;BA.debugLine="Private btnEight As Button";
mostCurrent._btneight = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 261;BA.debugLine="Private btnFive As Button";
mostCurrent._btnfive = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 262;BA.debugLine="Private btnFour As Button";
mostCurrent._btnfour = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 263;BA.debugLine="Private btnNine As Button";
mostCurrent._btnnine = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 264;BA.debugLine="Private btnOne As Button";
mostCurrent._btnone = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 265;BA.debugLine="Private btnSeven As Button";
mostCurrent._btnseven = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 266;BA.debugLine="Private btnSix As Button";
mostCurrent._btnsix = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 267;BA.debugLine="Private btnThree As Button";
mostCurrent._btnthree = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 268;BA.debugLine="Private btnTwo As Button";
mostCurrent._btntwo = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 269;BA.debugLine="Private btnZero As Button";
mostCurrent._btnzero = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 270;BA.debugLine="Private key1 As Panel";
mostCurrent._key1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 271;BA.debugLine="Private key2 As Panel";
mostCurrent._key2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 272;BA.debugLine="Private key3 As Panel";
mostCurrent._key3 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 273;BA.debugLine="Private key4 As Panel";
mostCurrent._key4 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 276;BA.debugLine="Dim Click_Count As Int = 0";
_click_count = (int) (0);
 //BA.debugLineNum = 277;BA.debugLine="Dim Master_Password As String";
mostCurrent._master_password = "";
 //BA.debugLineNum = 278;BA.debugLine="Dim entered_Password As String";
mostCurrent._entered_password = "";
 //BA.debugLineNum = 279;BA.debugLine="Dim fingerprint As FingerprintManager";
mostCurrent._fingerprint = new ir.taravatgroup.ezafekari2.fingerprintmanager();
 //BA.debugLineNum = 280;BA.debugLine="Private lbl_finger As Label";
mostCurrent._lbl_finger = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 282;BA.debugLine="Dim stat_finger As Int=0";
_stat_finger = (int) (0);
 //BA.debugLineNum = 284;BA.debugLine="Private pan_lock As Panel";
mostCurrent._pan_lock = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 285;BA.debugLine="Private lbl_hint_lock As Label";
mostCurrent._lbl_hint_lock = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 286;BA.debugLine="Private pan_all_chekUpdate As Panel";
mostCurrent._pan_all_chekupdate = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 287;BA.debugLine="Private webVeiw_chk_update As WebView";
mostCurrent._webveiw_chk_update = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 288;BA.debugLine="Private lbl_chk_update_ok As Label";
mostCurrent._lbl_chk_update_ok = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 289;BA.debugLine="Private lbl_day_CLV As Label";
mostCurrent._lbl_day_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 290;BA.debugLine="Private cust_LV_mamoriat As CustomListView";
mostCurrent._cust_lv_mamoriat = new b4a.example3.customlistview();
 //BA.debugLineNum = 292;BA.debugLine="Dim is_new_msg As Boolean=False";
_is_new_msg = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 293;BA.debugLine="Dim is_time_backup As Boolean=False";
_is_time_backup = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 295;BA.debugLine="Private radio_ez_fog As RadioButton";
mostCurrent._radio_ez_fog = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 296;BA.debugLine="Private radio_ez_adi As RadioButton";
mostCurrent._radio_ez_adi = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 297;BA.debugLine="Private lbl_finger_khoroj As Label";
mostCurrent._lbl_finger_khoroj = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 298;BA.debugLine="Private lbl_finger_vorod As Label";
mostCurrent._lbl_finger_vorod = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 300;BA.debugLine="Dim user_request_update As Boolean=False";
_user_request_update = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 301;BA.debugLine="Private lbl_setting_date As Label";
mostCurrent._lbl_setting_date = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 302;BA.debugLine="Private pan_all_setting_date As Panel";
mostCurrent._pan_all_setting_date = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 303;BA.debugLine="Private ckb_setting_date_finger As CheckBox";
mostCurrent._ckb_setting_date_finger = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 305;BA.debugLine="Private pan_finger_taradod As Panel";
mostCurrent._pan_finger_taradod = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 306;BA.debugLine="Private lbl_finger_fs_vorod As Label";
mostCurrent._lbl_finger_fs_vorod = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 307;BA.debugLine="Private lbl_finger_fs_khoroj As Label";
mostCurrent._lbl_finger_fs_khoroj = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 308;BA.debugLine="Private lbl_finger_fs_vorod_time As Label";
mostCurrent._lbl_finger_fs_vorod_time = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 309;BA.debugLine="Private lbl_finger_fs_khoroj_time As Label";
mostCurrent._lbl_finger_fs_khoroj_time = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 310;BA.debugLine="Private lbl_time_show_fs As Label";
mostCurrent._lbl_time_show_fs = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 311;BA.debugLine="Private lbl_ezaf_taradod_fs As Label";
mostCurrent._lbl_ezaf_taradod_fs = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 312;BA.debugLine="Private ckb_ezaf_taradod_fs As CheckBox";
mostCurrent._ckb_ezaf_taradod_fs = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 313;BA.debugLine="Private lbl_save_box As Label";
mostCurrent._lbl_save_box = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 314;BA.debugLine="Dim save_box_allow As Boolean=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 316;BA.debugLine="Dim state_tatil As Int=0";
_state_tatil = (int) (0);
 //BA.debugLineNum = 317;BA.debugLine="Dim state_tatil_setting As Int=0  ' 0 all is off";
_state_tatil_setting = (int) (0);
 //BA.debugLineNum = 319;BA.debugLine="Private ckb_tatil_rasmi As CheckBox";
mostCurrent._ckb_tatil_rasmi = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 320;BA.debugLine="Private ckb_tatil_garardadi As CheckBox";
mostCurrent._ckb_tatil_garardadi = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 321;BA.debugLine="Private lbl_tatil_show As Label";
mostCurrent._lbl_tatil_show = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 322;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
String _send = "";
 //BA.debugLineNum = 469;BA.debugLine="Sub http_initial_1(type1 As Int)";
 //BA.debugLineNum = 470;BA.debugLine="ht.Initialize(\"ht\",Me)";
mostCurrent._ht._initialize /*String*/ (processBA,"ht",main.getObject());
 //BA.debugLineNum = 471;BA.debugLine="Dim send As String";
_send = "";
 //BA.debugLineNum = 472;BA.debugLine="send = \"username=mahdi&password=1234&div_id=\"&pho";
_send = "username=mahdi&password=1234&div_id="+_phon.GetSettings("android_id")+"&sdk_ver="+BA.NumberToString(_phon.getSdkVersion())+"&oprator="+_phon.GetNetworkOperatorName()+"&type_app="+BA.NumberToString(_type1)+"&div_model="+_phon.getModel()+"&last_notif="+mostCurrent._last_notif+"&var=0&is_now_instal="+BA.ObjectToString(_is_now_instal)+"&version_code="+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Application.getVersionCode());
 //BA.debugLineNum = 473;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/ezafekari2";
mostCurrent._ht._poststring /*String*/ ("https://taravatgroup.ir/ezafekari2.php",_send);
 //BA.debugLineNum = 474;BA.debugLine="Log(\"ht sended\")";
anywheresoftware.b4a.keywords.Common.LogImpl("5458757","ht sended",0);
 //BA.debugLineNum = 476;BA.debugLine="End Sub";
return "";
}
public static String  _img_slider(int _index1) throws Exception{
 //BA.debugLineNum = 3845;BA.debugLine="Sub img_slider (index1 As Int)";
 //BA.debugLineNum = 3846;BA.debugLine="Select index1";
switch (_index1) {
case 0: {
 //BA.debugLineNum = 3848;BA.debugLine="img_help.Bitmap=bit_img0";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img0.getObject()));
 break; }
case 1: {
 //BA.debugLineNum = 3850;BA.debugLine="img_help.Bitmap=bit_img1";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img1.getObject()));
 break; }
case 2: {
 //BA.debugLineNum = 3853;BA.debugLine="img_help.Bitmap=bit_img2";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img2.getObject()));
 break; }
case 3: {
 //BA.debugLineNum = 3856;BA.debugLine="img_help.Bitmap=bit_img3";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img3.getObject()));
 break; }
case 4: {
 //BA.debugLineNum = 3859;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
 break; }
default: {
 //BA.debugLineNum = 3862;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("56684689","error",0);
 break; }
}
;
 //BA.debugLineNum = 3865;BA.debugLine="End Sub";
return "";
}
public static String  _inapp_purchasecompleted(boolean _success,anywheresoftware.b4a.inappbilling3.BillingManager3.Prchase _product) throws Exception{
 //BA.debugLineNum = 739;BA.debugLine="Sub inapp_PurchaseCompleted (Success As Boolean, P";
 //BA.debugLineNum = 742;BA.debugLine="If Success=True Then";
if (_success==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 744;BA.debugLine="If Product.ProductId=\"ezafekari2\" Then";
if ((_product.getProductId()).equals("ezafekari2")) { 
 //BA.debugLineNum = 746;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\",\"\")";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
 //BA.debugLineNum = 747;BA.debugLine="MsgboxAsync(\"پرداخت انجام شده است\",\"انجام شد\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("پرداخت انجام شده است"),BA.ObjectToCharSequence("انجام شد"),processBA);
 //BA.debugLineNum = 748;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی ا";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 750;BA.debugLine="inapp.ConsumeProduct(Product)";
mostCurrent._inapp.ConsumeProduct(processBA,_product);
 //BA.debugLineNum = 752;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 //BA.debugLineNum = 753;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 757;BA.debugLine="ToastMessageShow(\"خرید انجام نشد. دوباره تلاش کن";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خرید انجام نشد. دوباره تلاش کنید"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 759;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(ir.taravatgroup.ezafekari2.httpjob _job) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_lock0 = null;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root1 = null;
String _str_type = "";
String _str_version_code = "";
String _str_version_name = "";
String _str_changelog_fa = "";
String _str_message = "";
 //BA.debugLineNum = 480;BA.debugLine="Sub Jobdone (job As HttpJob)";
 //BA.debugLineNum = 481;BA.debugLine="Try";
try { //BA.debugLineNum = 483;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 484;BA.debugLine="If job.JobName=\"ht\" Then";
if ((_job._jobname /*String*/ ).equals("ht")) { 
 //BA.debugLineNum = 485;BA.debugLine="If(job.GetString <> \"\")Then";
if (((_job._getstring /*String*/ ()).equals("") == false)) { 
 //BA.debugLineNum = 487;BA.debugLine="If(job.GetString.Contains(\"accessok\"))Then";
if ((_job._getstring /*String*/ ().contains("accessok"))) { 
 //BA.debugLineNum = 490;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
 }else {
 //BA.debugLineNum = 493;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
 //BA.debugLineNum = 494;BA.debugLine="myfunc.help_man(\"توجه\",\"نسخه طلایی از طرف ا";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","نسخه طلایی از طرف ادمین فعال شد");
 };
 }else if((_job._getstring /*String*/ ().contains("accessno"))) { 
 //BA.debugLineNum = 499;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
 //BA.debugLineNum = 500;BA.debugLine="File.Delete(File.DirInternal,\"payokok\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok");
 //BA.debugLineNum = 501;BA.debugLine="myfunc.help_man(\"توجه\",\" نسخه طلایی از طرف";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه"," نسخه طلایی از طرف ادمین غیرفعال شد");
 };
 }else if((_job._getstring /*String*/ ().contains("lockok"))) { 
 //BA.debugLineNum = 505;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 506;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
 //BA.debugLineNum = 508;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 509;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
 //BA.debugLineNum = 510;BA.debugLine="ls_lock0.Set(0,\"true\")";
_ls_lock0.Set((int) (0),(Object)("true"));
 //BA.debugLineNum = 511;BA.debugLine="ls_lock0.Set(1,\"false\")";
_ls_lock0.Set((int) (1),(Object)("false"));
 //BA.debugLineNum = 512;BA.debugLine="ls_lock0.Set(2,\"2022\")";
_ls_lock0.Set((int) (2),(Object)("2022"));
 }else {
 //BA.debugLineNum = 514;BA.debugLine="ls_lock0.Add(\"true\")";
_ls_lock0.Add((Object)("true"));
 //BA.debugLineNum = 515;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
 //BA.debugLineNum = 516;BA.debugLine="ls_lock0.Add(\"2022\")";
_ls_lock0.Add((Object)("2022"));
 //BA.debugLineNum = 517;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 };
 //BA.debugLineNum = 519;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock0);
 }else if((_job._getstring /*String*/ ().contains("lockno"))) { 
 //BA.debugLineNum = 522;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 523;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
 //BA.debugLineNum = 525;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 526;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
 //BA.debugLineNum = 527;BA.debugLine="ls_lock0.Set(0,\"false\")";
_ls_lock0.Set((int) (0),(Object)("false"));
 //BA.debugLineNum = 528;BA.debugLine="ls_lock0.Set(1,\"false\")";
_ls_lock0.Set((int) (1),(Object)("false"));
 //BA.debugLineNum = 529;BA.debugLine="ls_lock0.Set(2,\"\")";
_ls_lock0.Set((int) (2),(Object)(""));
 }else {
 //BA.debugLineNum = 531;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
 //BA.debugLineNum = 532;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
 //BA.debugLineNum = 533;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 //BA.debugLineNum = 534;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 };
 //BA.debugLineNum = 536;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock0);
 }else if((_job._getstring /*String*/ ().contains("new_msg"))) { 
 //BA.debugLineNum = 543;BA.debugLine="is_new_msg=True";
_is_new_msg = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 549;BA.debugLine="msg=job.GetString";
mostCurrent._msg = _job._getstring /*String*/ ();
 //BA.debugLineNum = 551;BA.debugLine="tim_msg.Enabled=True";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 };
 };
 //BA.debugLineNum = 562;BA.debugLine="If job.JobName=\"chkupdate\" Then";
if ((_job._jobname /*String*/ ).equals("chkupdate")) { 
 //BA.debugLineNum = 564;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 566;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ ());
 //BA.debugLineNum = 568;BA.debugLine="Dim root1 As List";
_root1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 569;BA.debugLine="root1.Initialize";
_root1.Initialize();
 //BA.debugLineNum = 570;BA.debugLine="root1=parser.NextArray";
_root1 = _parser.NextArray();
 //BA.debugLineNum = 572;BA.debugLine="Dim str_type As String = root1.Get(0)";
_str_type = BA.ObjectToString(_root1.Get((int) (0)));
 //BA.debugLineNum = 573;BA.debugLine="str_type= str_type.Replace(\"type:\",\"\")";
_str_type = _str_type.replace("type:","");
 //BA.debugLineNum = 575;BA.debugLine="Dim str_version_code As String = root1.Get(1)";
_str_version_code = BA.ObjectToString(_root1.Get((int) (1)));
 //BA.debugLineNum = 576;BA.debugLine="str_version_code=str_version_code.Replace(\"ver";
_str_version_code = _str_version_code.replace("version_code:","");
 //BA.debugLineNum = 578;BA.debugLine="Dim str_version_name As String = root1.Get(2)";
_str_version_name = BA.ObjectToString(_root1.Get((int) (2)));
 //BA.debugLineNum = 579;BA.debugLine="str_version_name=str_version_name.Replace(\"ver";
_str_version_name = _str_version_name.replace("version_name:","");
 //BA.debugLineNum = 581;BA.debugLine="Dim str_changelog_fa As String = root1.Get(3)";
_str_changelog_fa = BA.ObjectToString(_root1.Get((int) (3)));
 //BA.debugLineNum = 582;BA.debugLine="str_changelog_fa=str_changelog_fa.Replace(\"cha";
_str_changelog_fa = _str_changelog_fa.replace("changelog_fa:","");
 //BA.debugLineNum = 584;BA.debugLine="Dim str_message As String = root1.Get(4)";
_str_message = BA.ObjectToString(_root1.Get((int) (4)));
 //BA.debugLineNum = 585;BA.debugLine="str_message=str_message.Replace(\"message:\",\"\")";
_str_message = _str_message.replace("message:","");
 //BA.debugLineNum = 592;BA.debugLine="If(user_request_update=True)Then";
if ((_user_request_update==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 594;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 595;BA.debugLine="pan_all_chekUpdate.Visible=True";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 597;BA.debugLine="If(str_type==\"success\")Then";
if (((_str_type).equals("success"))) { 
 //BA.debugLineNum = 598;BA.debugLine="If(str_version_code>Application.VersionCode)";
if (((double)(Double.parseDouble(_str_version_code))>anywheresoftware.b4a.keywords.Common.Application.getVersionCode())) { 
 //BA.debugLineNum = 599;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body><span style='color:#3AAD00; font-weight: bold;'> بروزرسانی جدید موجود است. </span><br> "+_str_changelog_fa+"</body></html>");
 //BA.debugLineNum = 600;BA.debugLine="lbl_chk_update_ok.Tag=1";
mostCurrent._lbl_chk_update_ok.setTag((Object)(1));
 //BA.debugLineNum = 601;BA.debugLine="lbl_chk_update_ok.Text=\"بروزرسانی برنامه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("بروزرسانی برنامه"));
 }else {
 //BA.debugLineNum = 603;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body> برنامه شما بروز می باشد. با تشکر </body></html>");
 //BA.debugLineNum = 604;BA.debugLine="lbl_chk_update_ok.Tag=0";
mostCurrent._lbl_chk_update_ok.setTag((Object)(0));
 //BA.debugLineNum = 605;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("باشه"));
 };
 }else if(((_str_type).equals("unsuccess"))) { 
 //BA.debugLineNum = 609;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl'";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>خطا در اتصال</body></html>");
 //BA.debugLineNum = 610;BA.debugLine="lbl_chk_update_ok.Tag=0";
mostCurrent._lbl_chk_update_ok.setTag((Object)(0));
 //BA.debugLineNum = 611;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("باشه"));
 };
 }else {
 //BA.debugLineNum = 619;BA.debugLine="If(str_type==\"success\")Then";
if (((_str_type).equals("success"))) { 
 //BA.debugLineNum = 621;BA.debugLine="If(str_version_code>Application.VersionCode)";
if (((double)(Double.parseDouble(_str_version_code))>anywheresoftware.b4a.keywords.Common.Application.getVersionCode())) { 
 //BA.debugLineNum = 622;BA.debugLine="pan_all_chekUpdate.Visible=True";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 624;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body><span style='color:#3AAD00; font-weight: bold;'> بروزرسانی جدید موجود است. </span><br> "+_str_changelog_fa+"</body></html>");
 //BA.debugLineNum = 625;BA.debugLine="lbl_chk_update_ok.Tag=1";
mostCurrent._lbl_chk_update_ok.setTag((Object)(1));
 //BA.debugLineNum = 626;BA.debugLine="lbl_chk_update_ok.Text=\"بروزرسانی برنامه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("بروزرسانی برنامه"));
 };
 };
 };
 };
 }else {
 };
 } 
       catch (Exception e102) {
			processBA.setLastException(e102); //BA.debugLineNum = 641;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("5524449",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 642;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 645;BA.debugLine="End Sub";
return "";
}
public static String  _kharid() throws Exception{
 //BA.debugLineNum = 721;BA.debugLine="Sub kharid";
 //BA.debugLineNum = 724;BA.debugLine="If(myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 725;BA.debugLine="Try";
try { //BA.debugLineNum = 727;BA.debugLine="inapp.RequestPayment(\"ezafekari2\",\"inapp\",\"ezaf";
mostCurrent._inapp.RequestPayment(processBA,"ezafekari2","inapp","ezafekari2");
 } 
       catch (Exception e5) {
			processBA.setLastException(e5); //BA.debugLineNum = 730;BA.debugLine="MsgboxAsync(\"1- از نصب بودن برنامه بازار اطمینا";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("1- از نصب بودن برنامه بازار اطمینان یابید."+anywheresoftware.b4a.keywords.Common.CRLF+" 2- برنامه ها را ببندید و دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 };
 }else {
 //BA.debugLineNum = 733;BA.debugLine="ToastMessageShow(\"خطا در اتصال \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال "),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 736;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_account_click() throws Exception{
int _result12 = 0;
 //BA.debugLineNum = 4308;BA.debugLine="Private Sub lbl_account_Click";
 //BA.debugLineNum = 4317;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 4318;BA.debugLine="StartActivity(step2_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step2_activity.getObject()));
 }else {
 //BA.debugLineNum = 4323;BA.debugLine="Dim result12 As Int";
_result12 = 0;
 //BA.debugLineNum = 4324;BA.debugLine="result12 = Msgbox2(\"اتصال اینترنت را بررسی کنید\"";
_result12 = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("اتصال اینترنت را بررسی کنید"),BA.ObjectToCharSequence("توجه!"),"تلاش دوباره","","بستن",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 4325;BA.debugLine="If result12 = DialogResponse.Positive Then";
if (_result12==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 4326;BA.debugLine="lbl_account_Click";
_lbl_account_click();
 };
 };
 //BA.debugLineNum = 4332;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
 //BA.debugLineNum = 4333;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chk_update_click() throws Exception{
String _send2 = "";
 //BA.debugLineNum = 4277;BA.debugLine="Private Sub lbl_chk_update_Click";
 //BA.debugLineNum = 4279;BA.debugLine="user_request_update=True";
_user_request_update = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 4280;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 4281;BA.debugLine="ProgressDialogShow(\"بررسی بروزرسانی ...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("بررسی بروزرسانی ..."));
 //BA.debugLineNum = 4282;BA.debugLine="ht.Initialize(\"chkupdate\",Me)";
mostCurrent._ht._initialize /*String*/ (processBA,"chkupdate",main.getObject());
 //BA.debugLineNum = 4283;BA.debugLine="Dim send2 As String";
_send2 = "";
 //BA.debugLineNum = 4284;BA.debugLine="send2 = \"var=checkupdate\"";
_send2 = "var=checkupdate";
 //BA.debugLineNum = 4285;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/chek_upda";
mostCurrent._ht._poststring /*String*/ ("https://taravatgroup.ir/chek_update.php",_send2);
 }else {
 //BA.debugLineNum = 4287;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 };
 //BA.debugLineNum = 4291;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
 //BA.debugLineNum = 4292;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chk_update_ok_click() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _op = null;
 //BA.debugLineNum = 4343;BA.debugLine="Private Sub lbl_chk_update_ok_Click";
 //BA.debugLineNum = 4344;BA.debugLine="If (lbl_chk_update_ok.Tag==1)Then";
if (((mostCurrent._lbl_chk_update_ok.getTag()).equals((Object)(1)))) { 
 //BA.debugLineNum = 4345;BA.debugLine="Try";
try { //BA.debugLineNum = 4346;BA.debugLine="Dim op As Intent";
_op = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 4347;BA.debugLine="op.Initialize(op.ACTION_VIEW,\"bazaar://details?";
_op.Initialize(_op.ACTION_VIEW,"bazaar://details?id=ir.taravatgroup.ezafekari2");
 //BA.debugLineNum = 4348;BA.debugLine="op.SetPackage(\"com.farsitel.bazaar\")";
_op.SetPackage("com.farsitel.bazaar");
 //BA.debugLineNum = 4349;BA.debugLine="StartActivity(op)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_op.getObject()));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8); //BA.debugLineNum = 4351;BA.debugLine="myfunc.help_man(\"توجه\",\"برنامه بازار را نصب کنی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","برنامه بازار را نصب کنید !");
 //BA.debugLineNum = 4353;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("58912906",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
 //BA.debugLineNum = 4360;BA.debugLine="pan_all_chekUpdate_Click";
_pan_all_chekupdate_click();
 //BA.debugLineNum = 4361;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_help_click() throws Exception{
 //BA.debugLineNum = 3789;BA.debugLine="Private Sub lbl_close_help_Click";
 //BA.debugLineNum = 3790;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3791;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_msgnewy_click() throws Exception{
 //BA.debugLineNum = 458;BA.debugLine="Private Sub lbl_close_msgNewY_Click";
 //BA.debugLineNum = 460;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 461;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_notif_click() throws Exception{
 //BA.debugLineNum = 709;BA.debugLine="Private Sub lbl_close_notif_Click";
 //BA.debugLineNum = 710;BA.debugLine="pan_notifi_all.Visible=False";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 711;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date1_click() throws Exception{
 //BA.debugLineNum = 3504;BA.debugLine="Private Sub lbl_date1_Click";
 //BA.debugLineNum = 3505;BA.debugLine="lbl_tim1_Click";
_lbl_tim1_click();
 //BA.debugLineNum = 3506;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date2_click() throws Exception{
 //BA.debugLineNum = 3499;BA.debugLine="Private Sub lbl_date2_Click";
 //BA.debugLineNum = 3500;BA.debugLine="lbl_tim2_Click";
_lbl_tim2_click();
 //BA.debugLineNum = 3501;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_from_list_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _b = null;
 //BA.debugLineNum = 3868;BA.debugLine="Private Sub lbl_edit_from_list_Click";
 //BA.debugLineNum = 3869;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 3870;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 3871;BA.debugLine="Log(b.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("56750211",BA.ObjectToString(_b.getTag()),0);
 //BA.debugLineNum = 3872;BA.debugLine="current_id_edit=b.Tag";
_current_id_edit = (int)(BA.ObjectToNumber(_b.getTag()));
 //BA.debugLineNum = 3876;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
 //BA.debugLineNum = 3877;BA.debugLine="pan_add_ezafekari_Click";
_pan_add_ezafekari_click();
 //BA.debugLineNum = 3878;BA.debugLine="lbl_box_title.Text=\"ویرایش اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش اضافه کاری"));
 }else if((mostCurrent._tabhost1.getCurrentTab()==1)) { 
 //BA.debugLineNum = 3881;BA.debugLine="pan_add_morakhasi_Click";
_pan_add_morakhasi_click();
 //BA.debugLineNum = 3882;BA.debugLine="lbl_box_title.Text=\"ویرایش مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش مرخصی"));
 }else if((mostCurrent._tabhost1.getCurrentTab()==2)) { 
 //BA.debugLineNum = 3885;BA.debugLine="pan_add_taradod_Click";
_pan_add_taradod_click();
 //BA.debugLineNum = 3886;BA.debugLine="lbl_box_title.Text=\"ویرایش تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش تردد"));
 //BA.debugLineNum = 3888;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3889;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3891;BA.debugLine="myfunc.help_man(\"توجه\",\"اگر برای این تردد اضافه";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اگر برای این تردد اضافه کاری ثبت شده است، لازم است آن را هم ویرایش کنید.");
 }else if((mostCurrent._tabhost1.getCurrentTab()==3)) { 
 //BA.debugLineNum = 3893;BA.debugLine="pan_add_mamoriat_Click";
_pan_add_mamoriat_click();
 //BA.debugLineNum = 3894;BA.debugLine="lbl_box_title.Text=\"ویرایش مأموریت\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش مأموریت"));
 };
 //BA.debugLineNum = 3897;BA.debugLine="is_for_edit=True";
_is_for_edit = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 3898;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3899;BA.debugLine="get_dataEdit_byId(current_id_edit)";
_get_dataedit_byid(_current_id_edit);
 //BA.debugLineNum = 3903;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3904;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 3908;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 3912;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_ezaf_taradod_click() throws Exception{
 //BA.debugLineNum = 1831;BA.debugLine="Private Sub lbl_ezaf_taradod_Click";
 //BA.debugLineNum = 1832;BA.debugLine="If(index_box=2)Then";
if ((_index_box==2)) { 
 //BA.debugLineNum = 1833;BA.debugLine="rsPOP_noe.Show";
mostCurrent._rspop_noe.Show();
 };
 //BA.debugLineNum = 1835;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_khoroj_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 4651;BA.debugLine="Private Sub lbl_finger_fs_khoroj_Click";
 //BA.debugLineNum = 4653;BA.debugLine="If(lbl_finger_fs_khoroj.Tag=0)Then";
if (((mostCurrent._lbl_finger_fs_khoroj.getTag()).equals((Object)(0)))) { 
 //BA.debugLineNum = 4654;BA.debugLine="ToastMessageShow(\"قبلا ثبت شده-برای ثبت دوباره ر";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("قبلا ثبت شده-برای ثبت دوباره روی آن نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
 }else if(((mostCurrent._lbl_finger_fs_khoroj.getTag()).equals((Object)(2)))) { 
 //BA.debugLineNum = 4656;BA.debugLine="ToastMessageShow(\"ابتدا ورود را بزنید\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ابتدا ورود را بزنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 4659;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 4660;BA.debugLine="lbl_tim2.Text=myfunc.fa2en(DateTime.Time(DateTim";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
 //BA.debugLineNum = 4661;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4662;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 4663;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
 //BA.debugLineNum = 4664;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 4665;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_kho";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_khoroj.txt",_ls_khoroj);
 //BA.debugLineNum = 4671;BA.debugLine="lbl_finger_fs_khoroj_time.Text=lbl_date2.Text&\"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date2.getText()+" - "+mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 4672;BA.debugLine="File.WriteString(File.DirInternal,\"finger_vorod_";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt","2");
 //BA.debugLineNum = 4673;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 4674;BA.debugLine="lbl_finger_fs_khoroj.Tag=0";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(0));
 //BA.debugLineNum = 4675;BA.debugLine="ToastMessageShow(\"ثبت زمان خروج\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان خروج"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4676;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 4677;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 4681;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_khoroj_longclick() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 4715;BA.debugLine="Private Sub lbl_finger_fs_khoroj_LongClick";
 //BA.debugLineNum = 4717;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 4718;BA.debugLine="lbl_tim2.Text=myfunc.fa2en(DateTime.Time(DateTim";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
 //BA.debugLineNum = 4719;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4720;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 4721;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
 //BA.debugLineNum = 4722;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 4723;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_kho";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_khoroj.txt",_ls_khoroj);
 //BA.debugLineNum = 4726;BA.debugLine="lbl_finger_fs_khoroj_time.Text=lbl_date2.Text&\"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date2.getText()+" - "+mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 4728;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 4729;BA.debugLine="ToastMessageShow(\"ثبت زمان خروج\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان خروج"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4730;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 4732;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_vorod_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
 //BA.debugLineNum = 4683;BA.debugLine="Private Sub lbl_finger_fs_vorod_Click";
 //BA.debugLineNum = 4685;BA.debugLine="If(lbl_finger_fs_vorod.Tag=0)Then";
if (((mostCurrent._lbl_finger_fs_vorod.getTag()).equals((Object)(0)))) { 
 //BA.debugLineNum = 4686;BA.debugLine="ToastMessageShow(\"قبلا ثبت شده-برای ثبت دوباره ر";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("قبلا ثبت شده-برای ثبت دوباره روی آن نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 4690;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 4691;BA.debugLine="lbl_tim1.Text=myfunc.fa2en(DateTime.Time(DateTim";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
 //BA.debugLineNum = 4692;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4693;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 4694;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
 //BA.debugLineNum = 4695;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 4696;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_vor";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt",_ls_vorod);
 //BA.debugLineNum = 4701;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\" -";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 4702;BA.debugLine="File.WriteString(File.DirInternal,\"finger_vorod_";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt","1");
 //BA.debugLineNum = 4703;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 4704;BA.debugLine="lbl_finger_fs_vorod.Tag=0";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(0));
 //BA.debugLineNum = 4705;BA.debugLine="lbl_finger_fs_khoroj.Tag=1";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(1));
 //BA.debugLineNum = 4706;BA.debugLine="ToastMessageShow(\"ثبت زمان ورود\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان ورود"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 4713;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_vorod_longclick() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
 //BA.debugLineNum = 4734;BA.debugLine="Private Sub lbl_finger_fs_vorod_LongClick";
 //BA.debugLineNum = 4735;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 4736;BA.debugLine="lbl_tim1.Text=myfunc.fa2en(DateTime.Time(DateTime";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
 //BA.debugLineNum = 4737;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4738;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 4739;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
 //BA.debugLineNum = 4740;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 4741;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_voro";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt",_ls_vorod);
 //BA.debugLineNum = 4745;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\" -";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 4747;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 4748;BA.debugLine="ToastMessageShow(\"ثبت زمان ورود\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان ورود"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4749;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 4751;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_khoroj_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 4423;BA.debugLine="Private Sub lbl_finger_khoroj_Click";
 //BA.debugLineNum = 4424;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 4425;BA.debugLine="lbl_tim2.Text=myfunc.fa2en(DateTime.Time(DateTime";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
 //BA.debugLineNum = 4428;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4429;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 4430;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
 //BA.debugLineNum = 4431;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 4433;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
 //BA.debugLineNum = 4435;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_ezafek";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt",_ls_khoroj);
 break; }
case 2: {
 //BA.debugLineNum = 4437;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_morakh";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt",_ls_khoroj);
 break; }
case 3: {
 //BA.debugLineNum = 4439;BA.debugLine="File.WriteList(File.DirInternal,\"temp_khoroj_ta";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt",_ls_khoroj);
 break; }
case 5: {
 //BA.debugLineNum = 4442;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_mamori";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt",_ls_khoroj);
 break; }
}
;
 //BA.debugLineNum = 4446;BA.debugLine="ToastMessageShow(\"ثبت زمان 2\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان 2"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4447;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 4448;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_vorod_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
 //BA.debugLineNum = 4391;BA.debugLine="Private Sub lbl_finger_vorod_Click";
 //BA.debugLineNum = 4392;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 4393;BA.debugLine="lbl_tim1.Text=myfunc.fa2en(DateTime.Time(DateTime";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
 //BA.debugLineNum = 4396;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4397;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 4398;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
 //BA.debugLineNum = 4399;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 4402;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
 //BA.debugLineNum = 4404;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_ezaf";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt",_ls_vorod);
 break; }
case 2: {
 //BA.debugLineNum = 4406;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_mora";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt",_ls_vorod);
 break; }
case 3: {
 //BA.debugLineNum = 4408;BA.debugLine="File.WriteList(File.DirInternal,\"temp_vorod_tar";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt",_ls_vorod);
 break; }
case 5: {
 //BA.debugLineNum = 4412;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_mamo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt",_ls_vorod);
 break; }
}
;
 //BA.debugLineNum = 4419;BA.debugLine="ToastMessageShow(\"ثبت زمان 1\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان 1"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4420;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 4421;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_click() throws Exception{
 //BA.debugLineNum = 3773;BA.debugLine="Private Sub lbl_help_Click";
 //BA.debugLineNum = 3776;BA.debugLine="bit_img0.Initialize(File.DirAssets,\"home-h0.jpg\")";
mostCurrent._bit_img0.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h0.jpg");
 //BA.debugLineNum = 3777;BA.debugLine="bit_img1.Initialize(File.DirAssets,\"home-h1.jpg\")";
mostCurrent._bit_img1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h1.jpg");
 //BA.debugLineNum = 3778;BA.debugLine="bit_img2.Initialize(File.DirAssets,\"home-h2.jpg\")";
mostCurrent._bit_img2.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h2.jpg");
 //BA.debugLineNum = 3779;BA.debugLine="bit_img3.Initialize(File.DirAssets,\"home-h3.jpg\")";
mostCurrent._bit_img3.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h3.jpg");
 //BA.debugLineNum = 3780;BA.debugLine="bit_img4.Initialize(File.DirAssets,\"home-h4.jpg\")";
mostCurrent._bit_img4.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h4.jpg");
 //BA.debugLineNum = 3783;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 //BA.debugLineNum = 3784;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 //BA.debugLineNum = 3785;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3787;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_piker_click() throws Exception{
 //BA.debugLineNum = 4112;BA.debugLine="Private Sub lbl_help_piker_Click";
 //BA.debugLineNum = 4114;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 //BA.debugLineNum = 4116;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
 //BA.debugLineNum = 4117;BA.debugLine="lbl_close_help.Visible=False";
mostCurrent._lbl_close_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4118;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 4120;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_setting_finger_click() throws Exception{
 //BA.debugLineNum = 4784;BA.debugLine="Private Sub lbl_help_setting_finger_Click";
 //BA.debugLineNum = 4785;BA.debugLine="myfunc.help_man(\"راهنما\",\"با فعال کردن این گزینه";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","با فعال کردن این گزینه ثبت ترددها به انگشتی انجام میشود . به این صورت که در موقع ورود و خروج انگشت میزنیم تا زمان ثبت شود و در آخر ذخیره میکنیم.");
 //BA.debugLineNum = 4786;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_tatil_garardadi_click() throws Exception{
 //BA.debugLineNum = 4793;BA.debugLine="Private Sub lbl_help_tatil_garardadi_Click";
 //BA.debugLineNum = 4794;BA.debugLine="myfunc.help_man(\"راهنما\",\"تردد در روزهای تعطیل قر";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","تردد در روزهای تعطیل قراردادی اضافه کاری محسوب شود- برای تعین روزها به عنوان تعطیل قراردادی در صفحه تقویم روی هر روز انگشت خود را نگه دارید و بعد تیک تعطیل قراردادی را بزنید. ");
 //BA.debugLineNum = 4795;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_tatil_rasmi_click() throws Exception{
 //BA.debugLineNum = 4789;BA.debugLine="Private Sub lbl_help_tatil_rasmi_Click";
 //BA.debugLineNum = 4790;BA.debugLine="myfunc.help_man(\"راهنما\",\"تردد در روزهای تعطیل رس";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","تردد در روزهای تعطیل رسمی و جمعه ها اضافه کاری محسوب شوند.");
 //BA.debugLineNum = 4791;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help2_click() throws Exception{
 //BA.debugLineNum = 4062;BA.debugLine="Private Sub lbl_help2_Click";
 //BA.debugLineNum = 4063;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 4064;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_lite_menu_click() throws Exception{
 //BA.debugLineNum = 4153;BA.debugLine="Private Sub lbl_lite_menu_Click";
 //BA.debugLineNum = 4154;BA.debugLine="pan_all_liteMenu.Visible=True";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 4155;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_notefi_click() throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _html = null;
int _i = 0;
 //BA.debugLineNum = 680;BA.debugLine="Private Sub lbl_notefi_Click";
 //BA.debugLineNum = 681;BA.debugLine="lbl_title_msgPan.Text=\"پیام ها\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام ها"));
 //BA.debugLineNum = 682;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 683;BA.debugLine="pan_notif.Top=10%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 684;BA.debugLine="pan_notif.Height=70%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 685;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
 //BA.debugLineNum = 688;BA.debugLine="Dim html As StringBuilder";
_html = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 689;BA.debugLine="html.Initialize";
_html.Initialize();
 //BA.debugLineNum = 691;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1"))) { 
 //BA.debugLineNum = 693;BA.debugLine="html.Append(\"<!DOCTYPE html><html><meta charset=";
_html.Append("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'>");
 //BA.debugLineNum = 694;BA.debugLine="For i = ls1.Size-1 To 0 Step -1";
{
final int step10 = -1;
final int limit10 = (int) (0);
_i = (int) (mostCurrent._ls1.getSize()-1) ;
for (;_i >= limit10 ;_i = _i + step10 ) {
 //BA.debugLineNum = 695;BA.debugLine="html.Append(\"<div style='background-color: #99f";
_html.Append("<div style='background-color: #99ffff; font-size: 13px;'>"+"کد پیام : "+BA.ObjectToString(mostCurrent._ls1.Get(_i))+" - مورخ : "+BA.ObjectToString(mostCurrent._ls3.Get(_i))+"</div><div style='background-color: #e6ffff; font-size: 16px;'><br>"+BA.ObjectToString(mostCurrent._ls2.Get(_i))).Append("<br></div><br>");
 }
};
 //BA.debugLineNum = 697;BA.debugLine="html.Append(\"</body></html>\")";
_html.Append("</body></html>");
 //BA.debugLineNum = 700;BA.debugLine="web_msg_show.LoadHtml(html.ToString)";
mostCurrent._web_msg_show.LoadHtml(_html.ToString());
 }else {
 //BA.debugLineNum = 703;BA.debugLine="web_msg_show.LoadHtml(\"<html><body dir='rtl'>لیس";
mostCurrent._web_msg_show.LoadHtml("<html><body dir='rtl'>لیست پیام خالی ... </body></html>");
 };
 //BA.debugLineNum = 707;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
 //BA.debugLineNum = 3974;BA.debugLine="Private Sub lbl_remove_from_list_Click";
 //BA.debugLineNum = 3976;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 3977;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 3979;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
 //BA.debugLineNum = 3980;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 3981;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 3982;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 3984;BA.debugLine="If (dbCode.delete_ezafekari(b.Tag))Then";
if ((mostCurrent._dbcode._delete_ezafekari /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 3985;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3987;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
 //BA.debugLineNum = 3990;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else if((mostCurrent._tabhost1.getCurrentTab()==1)) { 
 //BA.debugLineNum = 3995;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 3996;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 3997;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 3999;BA.debugLine="If (dbCode.delete_morakhasi(b.Tag))Then";
if ((mostCurrent._dbcode._delete_morakhasi /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 4000;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4001;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
 //BA.debugLineNum = 4002;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else if((mostCurrent._tabhost1.getCurrentTab()==2)) { 
 //BA.debugLineNum = 4007;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 4008;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 4009;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 4011;BA.debugLine="If (dbCode.delete_taradod(b.Tag))Then";
if ((mostCurrent._dbcode._delete_taradod /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 4012;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4014;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
 //BA.debugLineNum = 4015;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else if((mostCurrent._tabhost1.getCurrentTab()==3)) { 
 //BA.debugLineNum = 4020;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 4021;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 4022;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 4024;BA.debugLine="If (dbCode.delete_mamoriat(b.Tag))Then";
if ((mostCurrent._dbcode._delete_mamoriat /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 4025;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4027;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
 //BA.debugLineNum = 4028;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 };
 //BA.debugLineNum = 4038;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list2_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
 //BA.debugLineNum = 4041;BA.debugLine="Private Sub lbl_remove_from_list2_Click";
 //BA.debugLineNum = 4042;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 4043;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 4046;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 4047;BA.debugLine="result = Msgbox2(\"آیا این گزارش حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این گزارش حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 4048;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 4050;BA.debugLine="If (dbCode.delete_gozaresh(b.tag))Then";
if ((mostCurrent._dbcode._delete_gozaresh /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 4051;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4052;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedI";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
 };
 };
 //BA.debugLineNum = 4057;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_rest_finger_fs_taradod_click() throws Exception{
 //BA.debugLineNum = 4753;BA.debugLine="Private Sub lbl_rest_finger_fs_taradod_Click";
 //BA.debugLineNum = 4754;BA.debugLine="lbl_finger_fs_vorod_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(" - "));
 //BA.debugLineNum = 4755;BA.debugLine="lbl_finger_fs_khoroj_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(" - "));
 //BA.debugLineNum = 4757;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 4758;BA.debugLine="lbl_time_show_fs.Text=\"\"";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 4760;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 4761;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 4762;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4763;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4764;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4765;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4767;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 4768;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 4770;BA.debugLine="lbl_finger_fs_vorod.Tag=1";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(1));
 //BA.debugLineNum = 4771;BA.debugLine="lbl_finger_fs_khoroj.Tag=2";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(2));
 //BA.debugLineNum = 4772;BA.debugLine="File.WriteString(File.DirInternal,\"finger_vorod_t";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt","0");
 //BA.debugLineNum = 4773;BA.debugLine="save_box_allow=False";
_save_box_allow = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 4774;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_box_click() throws Exception{
 //BA.debugLineNum = 2271;BA.debugLine="Private Sub lbl_save_box_Click";
 //BA.debugLineNum = 2273;BA.debugLine="If(save_box_allow=False)Then";
if ((_save_box_allow==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2274;BA.debugLine="ToastMessageShow(\"ورود یا خروج ناقص است.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ورود یا خروج ناقص است."),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 2276;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 2277;BA.debugLine="add_end";
_add_end();
 };
 //BA.debugLineNum = 2282;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
String _value = "";
String _value1 = "";
String _value2 = "";
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 3532;BA.debugLine="Private Sub lbl_save_picker_Click";
 //BA.debugLineNum = 3534;BA.debugLine="Dim value As String";
_value = "";
 //BA.debugLineNum = 3535;BA.debugLine="value=pik_hour1.Text";
_value = mostCurrent._pik_hour1.getText();
 //BA.debugLineNum = 3536;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(value)";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_value)))));
 //BA.debugLineNum = 3539;BA.debugLine="Dim value1 As String";
_value1 = "";
 //BA.debugLineNum = 3540;BA.debugLine="value1=pik_min1.Text";
_value1 = mostCurrent._pik_min1.getText();
 //BA.debugLineNum = 3541;BA.debugLine="pik_min1.Text=myfunc.convert_adad(value1)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_value1)))));
 //BA.debugLineNum = 3544;BA.debugLine="Dim value2 As String";
_value2 = "";
 //BA.debugLineNum = 3545;BA.debugLine="value2=pik_day1.Text";
_value2 = mostCurrent._pik_day1.getText();
 //BA.debugLineNum = 3546;BA.debugLine="pik_day1.Text=myfunc.convert_adad(value2)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_value2)))));
 //BA.debugLineNum = 3547;BA.debugLine="pik_moon1.Tag=myfunc.convert_adad(pik_moon1.Tag)";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))));
 //BA.debugLineNum = 3552;BA.debugLine="If(index_piker=1)Then  'date1";
if ((_index_piker==1)) { 
 //BA.debugLineNum = 3555;BA.debugLine="lbl_tim1.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
 //BA.debugLineNum = 3556;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
 //BA.debugLineNum = 3558;BA.debugLine="If (is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 3560;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 3561;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 3562;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
 //BA.debugLineNum = 3563;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 3565;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
 //BA.debugLineNum = 3567;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_ez";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt",_ls_vorod);
 break; }
case 2: {
 //BA.debugLineNum = 3569;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_mo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt",_ls_vorod);
 break; }
case 3: {
 //BA.debugLineNum = 3571;BA.debugLine="File.WriteList(File.DirInternal,\"temp_vorod_t";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt",_ls_vorod);
 break; }
case 5: {
 //BA.debugLineNum = 3573;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_ma";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt",_ls_vorod);
 break; }
}
;
 };
 //BA.debugLineNum = 3578;BA.debugLine="state_tatil= chek_tatil_day(myfunc.fa2en(pik_yea";
_state_tatil = _chek_tatil_day((int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText()))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag())))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText()))));
 //BA.debugLineNum = 3579;BA.debugLine="state_tatil_setting = chek_tatil_setting";
_state_tatil_setting = _chek_tatil_setting();
 //BA.debugLineNum = 3582;BA.debugLine="If(state_tatil=0)Then";
if ((_state_tatil==0)) { 
 //BA.debugLineNum = 3583;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
 }else if((_state_tatil==1)) { 
 //BA.debugLineNum = 3585;BA.debugLine="lbl_tatil_show.Text=\"(تعطیل رسمی)\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence("(تعطیل رسمی)"));
 }else if((_state_tatil==2)) { 
 //BA.debugLineNum = 3587;BA.debugLine="lbl_tatil_show.Text=\"(تعطیل قراردادی)\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence("(تعطیل قراردادی)"));
 };
 //BA.debugLineNum = 3590;BA.debugLine="If (index_box <> 3) Then";
if ((_index_box!=3)) { 
 //BA.debugLineNum = 3591;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
 };
 }else if((_index_piker==2)) { 
 //BA.debugLineNum = 3597;BA.debugLine="lbl_tim2.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
 //BA.debugLineNum = 3598;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
 //BA.debugLineNum = 3601;BA.debugLine="If (is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 3603;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 3604;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 3605;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
 //BA.debugLineNum = 3606;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 3608;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
 //BA.debugLineNum = 3610;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_ezaf";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt",_ls_khoroj);
 break; }
case 2: {
 //BA.debugLineNum = 3612;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_mora";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt",_ls_khoroj);
 break; }
case 3: {
 //BA.debugLineNum = 3614;BA.debugLine="File.WriteList(File.DirInternal,\"temp_khoroj_";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt",_ls_khoroj);
 break; }
case 5: {
 //BA.debugLineNum = 3616;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_mamo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt",_ls_khoroj);
 break; }
}
;
 };
 };
 //BA.debugLineNum = 3626;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3627;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 3628;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_setting_date_click() throws Exception{
 //BA.debugLineNum = 4614;BA.debugLine="Private Sub lbl_save_setting_date_Click";
 //BA.debugLineNum = 4618;BA.debugLine="If(ckb_setting_date_finger.Checked=True)Then";
if ((mostCurrent._ckb_setting_date_finger.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 4619;BA.debugLine="dbCode.update_setting_byname(\"setting_finger_mod";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode",BA.NumberToString(1));
 //BA.debugLineNum = 4620;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
 //BA.debugLineNum = 4621;BA.debugLine="pan_finger_taradod.Visible=True";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 4623;BA.debugLine="dbCode.update_setting_byname(\"setting_finger_mod";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode",BA.NumberToString(0));
 //BA.debugLineNum = 4624;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4625;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
 //BA.debugLineNum = 4626;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 4629;BA.debugLine="If(ckb_tatil_rasmi.Checked=True)Then";
if ((mostCurrent._ckb_tatil_rasmi.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 4630;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_rasm";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi",BA.NumberToString(1));
 }else {
 //BA.debugLineNum = 4632;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_rasm";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi",BA.NumberToString(0));
 };
 //BA.debugLineNum = 4635;BA.debugLine="If(ckb_tatil_garardadi.Checked=True)Then";
if ((mostCurrent._ckb_tatil_garardadi.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 4636;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_gara";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi",BA.NumberToString(1));
 }else {
 //BA.debugLineNum = 4638;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_gara";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi",BA.NumberToString(0));
 };
 //BA.debugLineNum = 4642;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4643;BA.debugLine="pan_all_setting_date.Visible=False";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4644;BA.debugLine="pan_all_Click";
_pan_all_click();
 //BA.debugLineNum = 4645;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_setting_date_click() throws Exception{
int _res_val2 = 0;
int _res_tatil_rasmi = 0;
int _res_tatil_garardadi = 0;
 //BA.debugLineNum = 4579;BA.debugLine="Private Sub lbl_setting_date_Click";
 //BA.debugLineNum = 4582;BA.debugLine="Dim res_val2 As Int =dbCode.get_setting_byName(\"s";
_res_val2 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode")));
 //BA.debugLineNum = 4583;BA.debugLine="If(res_val2=0)Then";
if ((_res_val2==0)) { 
 //BA.debugLineNum = 4584;BA.debugLine="ckb_setting_date_finger.Checked=False";
mostCurrent._ckb_setting_date_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 4586;BA.debugLine="ckb_setting_date_finger.Checked=True";
mostCurrent._ckb_setting_date_finger.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 4589;BA.debugLine="Dim res_tatil_rasmi As Int =dbCode.get_setting_by";
_res_tatil_rasmi = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi")));
 //BA.debugLineNum = 4590;BA.debugLine="If(res_tatil_rasmi=0)Then";
if ((_res_tatil_rasmi==0)) { 
 //BA.debugLineNum = 4591;BA.debugLine="ckb_tatil_rasmi.Checked=False";
mostCurrent._ckb_tatil_rasmi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 4593;BA.debugLine="ckb_tatil_rasmi.Checked=True";
mostCurrent._ckb_tatil_rasmi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 4596;BA.debugLine="Dim res_tatil_garardadi As Int =dbCode.get_settin";
_res_tatil_garardadi = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi")));
 //BA.debugLineNum = 4597;BA.debugLine="If(res_tatil_garardadi=0)Then";
if ((_res_tatil_garardadi==0)) { 
 //BA.debugLineNum = 4598;BA.debugLine="ckb_tatil_garardadi.Checked=False";
mostCurrent._ckb_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 4600;BA.debugLine="ckb_tatil_garardadi.Checked=True";
mostCurrent._ckb_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 4606;BA.debugLine="pan_all_setting_date.Visible=True";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 4608;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_app_click() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _i = null;
 //BA.debugLineNum = 4267;BA.debugLine="Private Sub lbl_share_app_Click";
 //BA.debugLineNum = 4268;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 4269;BA.debugLine="i.Initialize(i.ACTION_SEND, \"\")";
_i.Initialize(_i.ACTION_SEND,"");
 //BA.debugLineNum = 4270;BA.debugLine="i.SetType(\"text/plain\")";
_i.SetType("text/plain");
 //BA.debugLineNum = 4271;BA.debugLine="i.PutExtra(\"android.intent.extra.TEXT\", \"https://";
_i.PutExtra("android.intent.extra.TEXT",(Object)("https://cafebazaar.ir/app/ir.taravatgroup.ezafekari2"));
 //BA.debugLineNum = 4272;BA.debugLine="i.WrapAsIntentChooser(\"انتخاب کنید\")";
_i.WrapAsIntentChooser("انتخاب کنید");
 //BA.debugLineNum = 4273;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_i.getObject()));
 //BA.debugLineNum = 4274;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
 //BA.debugLineNum = 4275;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_click() throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _str_file_matn = null;
String _name_gozaresh = "";
String _name_gozaresh_en = "";
anywheresoftware.b4a.objects.collections.List _ls_ezafe = null;
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
 //BA.debugLineNum = 4450;BA.debugLine="Private Sub lbl_share_Click";
 //BA.debugLineNum = 4452;BA.debugLine="Dim str_file_matn As StringBuilder";
_str_file_matn = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 4453;BA.debugLine="str_file_matn.Initialize";
_str_file_matn.Initialize();
 //BA.debugLineNum = 4454;BA.debugLine="Dim name_gozaresh As String=\"\"";
_name_gozaresh = "";
 //BA.debugLineNum = 4455;BA.debugLine="Dim name_gozaresh_en As String=\"\"";
_name_gozaresh_en = "";
 //BA.debugLineNum = 4457;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 4459;BA.debugLine="Select TabHost1.CurrentTab";
switch (BA.switchObjectToInt(mostCurrent._tabhost1.getCurrentTab(),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
 //BA.debugLineNum = 4462;BA.debugLine="name_gozaresh=\"اضافه کاری ها-\"";
_name_gozaresh = "اضافه کاری ها-";
 //BA.debugLineNum = 4463;BA.debugLine="name_gozaresh_en=\"ezafekari\"";
_name_gozaresh_en = "ezafekari";
 //BA.debugLineNum = 4464;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
case 1: {
 //BA.debugLineNum = 4467;BA.debugLine="name_gozaresh=\"مرخصی ها-\"";
_name_gozaresh = "مرخصی ها-";
 //BA.debugLineNum = 4468;BA.debugLine="name_gozaresh_en=\"morakhasi\"";
_name_gozaresh_en = "morakhasi";
 //BA.debugLineNum = 4469;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
case 2: {
 //BA.debugLineNum = 4472;BA.debugLine="name_gozaresh=\"ترددها-\"";
_name_gozaresh = "ترددها-";
 //BA.debugLineNum = 4473;BA.debugLine="name_gozaresh_en=\"taradod\"";
_name_gozaresh_en = "taradod";
 //BA.debugLineNum = 4474;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
case 3: {
 //BA.debugLineNum = 4477;BA.debugLine="name_gozaresh=\"مأموریت ها-\"";
_name_gozaresh = "مأموریت ها-";
 //BA.debugLineNum = 4478;BA.debugLine="name_gozaresh_en=\"mamoriat\"";
_name_gozaresh_en = "mamoriat";
 //BA.debugLineNum = 4479;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
}
;
 //BA.debugLineNum = 4487;BA.debugLine="str_file_matn.Append(\"<!DOCTYPE html><html dir='r";
_str_file_matn.Append("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>");
 //BA.debugLineNum = 4488;BA.debugLine="str_file_matn.Append(\"<style>table , td {border:";
_str_file_matn.Append("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	</style>");
 //BA.debugLineNum = 4490;BA.debugLine="str_file_matn.Append(\"<h3>\").Append(\" گزارش \"&nam";
_str_file_matn.Append("<h3>").Append(" گزارش "+_name_gozaresh+mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())).Append("</h3>");
 //BA.debugLineNum = 4496;BA.debugLine="str_file_matn.Append(\"نام کاربر :\").Append(\"<span";
_str_file_matn.Append("نام کاربر :").Append("<span> "+_user_namefamili+"</span>").Append("<br>");
 //BA.debugLineNum = 4498;BA.debugLine="str_file_matn.Append(\"<div style=' background-col";
_str_file_matn.Append("<div style=' background-color: #f5f5f5;'>");
 //BA.debugLineNum = 4501;BA.debugLine="str_file_matn.Append(\"<table style='width:100%;'>";
_str_file_matn.Append("<table style='width:100%;'><tr style='text-align: center;'>");
 //BA.debugLineNum = 4502;BA.debugLine="str_file_matn.Append(\"<td><b> ردیف</b></td><td><b";
_str_file_matn.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td><br></tr>");
 //BA.debugLineNum = 4504;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 4505;BA.debugLine="str_file_matn.Append(\"<tr style='text-align: cen";
_str_file_matn.Append("<tr style='text-align: center;'>");
 //BA.debugLineNum = 4506;BA.debugLine="str_file_matn.Append(\"<td>\").Append(myfunc.en2fa";
_str_file_matn.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
 //BA.debugLineNum = 4507;BA.debugLine="str_file_matn.Append(\"<td>\").Append(myfunc.en2fa";
_str_file_matn.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
 //BA.debugLineNum = 4508;BA.debugLine="str_file_matn.Append(\"<td>\").Append(myfunc.en2fa";
_str_file_matn.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
 //BA.debugLineNum = 4510;BA.debugLine="str_file_matn.Append(\"<td>\")";
_str_file_matn.Append("<td>");
 //BA.debugLineNum = 4513;BA.debugLine="Dim ls_ezafe As List";
_ls_ezafe = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4514;BA.debugLine="ls_ezafe.Initialize";
_ls_ezafe.Initialize();
 //BA.debugLineNum = 4516;BA.debugLine="If( TabHost1.CurrentTab=0 Or  TabHost1.CurrentTa";
if ((mostCurrent._tabhost1.getCurrentTab()==0 || mostCurrent._tabhost1.getCurrentTab()==2)) { 
 //BA.debugLineNum = 4517;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz2_dontDay(dbCo";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 }else {
 //BA.debugLineNum = 4519;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz(dbCode.res.Ge";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 //BA.debugLineNum = 4520;BA.debugLine="str_file_matn.Append(ls_ezafe.Get(2))";
_str_file_matn.Append(BA.ObjectToString(_ls_ezafe.Get((int) (2))));
 //BA.debugLineNum = 4521;BA.debugLine="str_file_matn.Append(\":\")";
_str_file_matn.Append(":");
 };
 //BA.debugLineNum = 4529;BA.debugLine="str_file_matn.Append(ls_ezafe.Get(0))";
_str_file_matn.Append(BA.ObjectToString(_ls_ezafe.Get((int) (0))));
 //BA.debugLineNum = 4530;BA.debugLine="str_file_matn.Append(\":\")";
_str_file_matn.Append(":");
 //BA.debugLineNum = 4531;BA.debugLine="str_file_matn.Append(ls_ezafe.Get(1)).Append(\"</t";
_str_file_matn.Append(BA.ObjectToString(_ls_ezafe.Get((int) (1)))).Append("</td>");
 //BA.debugLineNum = 4533;BA.debugLine="str_file_matn.Append(\"</tr>\")";
_str_file_matn.Append("</tr>");
 }
;
 //BA.debugLineNum = 4537;BA.debugLine="str_file_matn.Append(\"</table>\")";
_str_file_matn.Append("</table>");
 //BA.debugLineNum = 4538;BA.debugLine="str_file_matn.Append(\"مجموع ساعت  :<span style='co";
_str_file_matn.Append("مجموع ساعت  :<span style='color:#5E35B1;'> "+mostCurrent._lbl_majmoe_saat.getText()+" </span><br></div><br> ");
 //BA.debugLineNum = 4544;BA.debugLine="str_file_matn.Append(\"<br></details></div>\")";
_str_file_matn.Append("<br></details></div>");
 //BA.debugLineNum = 4546;BA.debugLine="str_file_matn.Append(\"<footer style=' text-align:";
_str_file_matn.Append("<footer style=' text-align: center; '><h6> اپلیکیشن اضافه کاری من </h6></footer>");
 //BA.debugLineNum = 4548;BA.debugLine="str_file_matn.Append(\"</body></html>\")";
_str_file_matn.Append("</body></html>");
 //BA.debugLineNum = 4553;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 4554;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 4561;BA.debugLine="Dim FileName As String =name_gozaresh_en&\"-\"&myfu";
_filename = _name_gozaresh_en+"-"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+".html";
 //BA.debugLineNum = 4564;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
anywheresoftware.b4a.keywords.Common.File.WriteString(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename,_str_file_matn.ToString());
 //BA.debugLineNum = 4566;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
 //BA.debugLineNum = 4567;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
 //BA.debugLineNum = 4568;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
 //BA.debugLineNum = 4569;BA.debugLine="email.Body = \" گزارش  \"&name_gozaresh&CRLF&\"اپلیک";
_email.Body = " گزارش  "+_name_gozaresh+anywheresoftware.b4a.keywords.Common.CRLF+"اپلیکیشن اضافه کاری من"+anywheresoftware.b4a.keywords.Common.CRLF+"دانلود از بازار";
 //BA.debugLineNum = 4570;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (_filename));
 //BA.debugLineNum = 4572;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
 //BA.debugLineNum = 4573;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
 //BA.debugLineNum = 4574;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 //BA.debugLineNum = 4577;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim1_click() throws Exception{
 //BA.debugLineNum = 3508;BA.debugLine="Private Sub lbl_tim1_Click";
 //BA.debugLineNum = 3509;BA.debugLine="index_piker=1";
_index_piker = (int) (1);
 //BA.debugLineNum = 3511;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim1.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (0))));
 //BA.debugLineNum = 3512;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim1.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (1))));
 //BA.debugLineNum = 3514;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date1.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (0))));
 //BA.debugLineNum = 3515;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (1)));
 //BA.debugLineNum = 3516;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 3517;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (2))));
 //BA.debugLineNum = 3521;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3523;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 3524;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 3525;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 //BA.debugLineNum = 3526;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 //BA.debugLineNum = 3527;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
 //BA.debugLineNum = 3530;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim2_click() throws Exception{
 //BA.debugLineNum = 3477;BA.debugLine="Private Sub lbl_tim2_Click";
 //BA.debugLineNum = 3478;BA.debugLine="index_piker=2";
_index_piker = (int) (2);
 //BA.debugLineNum = 3479;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim2.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (0))));
 //BA.debugLineNum = 3480;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim2.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (1))));
 //BA.debugLineNum = 3482;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date2.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (0))));
 //BA.debugLineNum = 3483;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (1)));
 //BA.debugLineNum = 3484;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 3485;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (2))));
 //BA.debugLineNum = 3488;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3491;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 3492;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 3493;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 //BA.debugLineNum = 3494;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 //BA.debugLineNum = 3495;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
 //BA.debugLineNum = 3497;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_click() throws Exception{
 //BA.debugLineNum = 3760;BA.debugLine="Private Sub lbl_vip_Click";
 //BA.debugLineNum = 3762;BA.debugLine="pan_all_noskhe.Visible=True";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3763;BA.debugLine="scroll_v_noskhe.Panel.LoadLayout(\"noske_item\")";
mostCurrent._scroll_v_noskhe.getPanel().LoadLayout("noske_item",mostCurrent.activityBA);
 //BA.debugLineNum = 3765;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 3766;BA.debugLine="lbl_show_vip.Text=\"نسخه کامل ( طلایی ) فعال می ب";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه کامل ( طلایی ) فعال می باشد."));
 }else {
 //BA.debugLineNum = 3768;BA.debugLine="lbl_show_vip.Text=\"نسخه معمولی ( هدیه ) فعال می";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه معمولی ( هدیه ) فعال می باشد."));
 };
 //BA.debugLineNum = 3771;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_later_click() throws Exception{
 //BA.debugLineNum = 4082;BA.debugLine="Private Sub lbl_vip_later_Click";
 //BA.debugLineNum = 4083;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
 //BA.debugLineNum = 4084;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_now_click() throws Exception{
String _title = "";
String _matn = "";
int _result = 0;
 //BA.debugLineNum = 4086;BA.debugLine="Private Sub lbl_vip_now_Click";
 //BA.debugLineNum = 4087;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 4089;BA.debugLine="Dim title , matn As String";
_title = "";
_matn = "";
 //BA.debugLineNum = 4090;BA.debugLine="title=\" تبریک \"";
_title = " تبریک ";
 //BA.debugLineNum = 4091;BA.debugLine="matn=\" شما صاحب نسخه طلایی و بدون محدودیت برنامه";
_matn = " شما صاحب نسخه طلایی و بدون محدودیت برنامه اضافه کاری من می باشید. ";
 //BA.debugLineNum = 4093;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 4094;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Lo";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"باشه","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"buy.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 4095;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
 }else {
 //BA.debugLineNum = 4100;BA.debugLine="kharid";
_kharid();
 };
 //BA.debugLineNum = 4102;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip2_click() throws Exception{
 //BA.debugLineNum = 4066;BA.debugLine="Private Sub lbl_vip2_Click";
 //BA.debugLineNum = 4067;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 //BA.debugLineNum = 4068;BA.debugLine="End Sub";
return "";
}
public static int  _min_between_to_time(String _dat1,String _dat2,String _tim1,String _tim2) throws Exception{
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
 //BA.debugLineNum = 4172;BA.debugLine="Sub min_between_to_time(dat1 As String,dat2 As Str";
 //BA.debugLineNum = 4175;BA.debugLine="Try";
try { //BA.debugLineNum = 4177;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4178;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4179;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
 //BA.debugLineNum = 4180;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
 //BA.debugLineNum = 4182;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
 //BA.debugLineNum = 4183;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
 //BA.debugLineNum = 4184;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 4185;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 4194;BA.debugLine="date1=dat1";
mostCurrent._date1 = _dat1;
 //BA.debugLineNum = 4195;BA.debugLine="date2=dat2";
mostCurrent._date2 = _dat2;
 //BA.debugLineNum = 4196;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
 //BA.debugLineNum = 4197;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
 //BA.debugLineNum = 4201;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_da";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
 //BA.debugLineNum = 4202;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_da";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
 //BA.debugLineNum = 4205;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
 //BA.debugLineNum = 4206;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
 //BA.debugLineNum = 4209;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
 //BA.debugLineNum = 4210;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
 //BA.debugLineNum = 4212;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
 //BA.debugLineNum = 4213;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
 //BA.debugLineNum = 4215;BA.debugLine="time_end2=tim2&\":00\"";
_time_end2 = _tim2+":00";
 //BA.debugLineNum = 4216;BA.debugLine="time_end1=tim1&\":00\"";
_time_end1 = _tim1+":00";
 //BA.debugLineNum = 4218;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
 //BA.debugLineNum = 4219;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
 //BA.debugLineNum = 4220;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
 //BA.debugLineNum = 4221;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
 //BA.debugLineNum = 4225;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
 //BA.debugLineNum = 4226;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
 } 
       catch (Exception e31) {
			processBA.setLastException(e31); //BA.debugLineNum = 4231;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 4234;BA.debugLine="Return (period_between.Days*24*60)+(period_betwee";
if (true) return (int) ((_period_between.Days*24*60)+(_period_between.Hours*60)+_period_between.Minutes);
 //BA.debugLineNum = 4235;BA.debugLine="End Sub";
return 0;
}
public static String  _pan_add_ezafekari_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 1857;BA.debugLine="Private Sub pan_add_ezafekari_Click";
 //BA.debugLineNum = 1858;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 1859;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 1860;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1861;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1862;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 1863;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1864;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1866;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1867;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1869;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1870;BA.debugLine="lbl_box_title.Text=\"ثبت اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت اضافه کاری"));
 //BA.debugLineNum = 1871;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
 //BA.debugLineNum = 1872;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
 //BA.debugLineNum = 1873;BA.debugLine="index_box=1";
_index_box = (int) (1);
 //BA.debugLineNum = 1874;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1875;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1876;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1877;BA.debugLine="lbl_ezaf_taradod.Text=\"فوق العاده (جمعه کاری)\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("فوق العاده (جمعه کاری)"));
 //BA.debugLineNum = 1878;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 1879;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1880;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1881;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1886;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
 //BA.debugLineNum = 1887;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
 //BA.debugLineNum = 1888;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 1889;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
 //BA.debugLineNum = 1892;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1893;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1897;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_from_ezafe";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1898;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1899;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 1900;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_f";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt");
 //BA.debugLineNum = 1905;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1909;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
 //BA.debugLineNum = 1911;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1912;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 1916;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_to_ezafeka";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1917;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1918;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 1919;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt");
 //BA.debugLineNum = 1925;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1929;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
 //BA.debugLineNum = 1931;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1932;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 1937;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1939;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 1942;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_mamoriat_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 2161;BA.debugLine="Private Sub pan_add_mamoriat_Click";
 //BA.debugLineNum = 2162;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 2163;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 2164;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2165;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2166;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 2168;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 2169;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2170;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2172;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2173;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2175;BA.debugLine="lbl_box_title.Text=\"ثبت مأموریت\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت مأموریت"));
 //BA.debugLineNum = 2176;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
 //BA.debugLineNum = 2177;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
 //BA.debugLineNum = 2178;BA.debugLine="index_box=5";
_index_box = (int) (5);
 //BA.debugLineNum = 2179;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2180;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2181;BA.debugLine="lbl_ezaf_taradod.Visible=False";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2184;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2185;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2186;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2191;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
 //BA.debugLineNum = 2192;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
 //BA.debugLineNum = 2193;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 2194;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
 //BA.debugLineNum = 2197;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2198;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2202;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_from_mamori";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2203;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2204;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 2205;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_fr";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt");
 //BA.debugLineNum = 2209;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2213;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
 //BA.debugLineNum = 2215;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2216;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 2220;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_to_mamoriat";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2221;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2222;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 2223;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_t";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt");
 //BA.debugLineNum = 2227;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2232;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
 //BA.debugLineNum = 2234;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2235;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 2254;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2256;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 2261;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_morakhasi_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 1730;BA.debugLine="Private Sub pan_add_morakhasi_Click";
 //BA.debugLineNum = 1731;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 1732;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 1733;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1734;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1736;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 1738;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1739;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1741;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1742;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1744;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1745;BA.debugLine="lbl_box_title.Text=\"ثبت مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت مرخصی"));
 //BA.debugLineNum = 1746;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
 //BA.debugLineNum = 1747;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
 //BA.debugLineNum = 1748;BA.debugLine="index_box=2";
_index_box = (int) (2);
 //BA.debugLineNum = 1749;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1750;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1751;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 //BA.debugLineNum = 1752;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1753;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
 //BA.debugLineNum = 1754;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Red";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 1755;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1756;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1761;BA.debugLine="rsPOP_noe.Initialize(\"rsPOP_noe\",lbl_ezaf_taradod";
mostCurrent._rspop_noe.Initialize(mostCurrent.activityBA,"rsPOP_noe",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_ezaf_taradod.getObject())));
 //BA.debugLineNum = 1763;BA.debugLine="rsPOP_noe.AddMenuItem(0,0,\"استحقاقی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (0),(int) (0),"استحقاقی");
 //BA.debugLineNum = 1764;BA.debugLine="rsPOP_noe.AddMenuItem(1,1,\"استعلاجی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (1),(int) (1),"استعلاجی");
 //BA.debugLineNum = 1765;BA.debugLine="rsPOP_noe.AddMenuItem(2,2,\"سایر (با حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (2),(int) (2),"سایر (با حقوق)");
 //BA.debugLineNum = 1766;BA.debugLine="rsPOP_noe.AddMenuItem(3,3,\"سایر (بدون حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (3),(int) (3),"سایر (بدون حقوق)");
 //BA.debugLineNum = 1771;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
 //BA.debugLineNum = 1772;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
 //BA.debugLineNum = 1773;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 1774;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
 //BA.debugLineNum = 1777;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1778;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1784;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_from_morak";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1785;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1786;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 1787;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_f";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt");
 //BA.debugLineNum = 1792;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1796;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
 //BA.debugLineNum = 1798;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1799;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 1803;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_to_morakha";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1804;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1805;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 1806;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt");
 //BA.debugLineNum = 1811;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1815;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
 //BA.debugLineNum = 1817;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1818;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 1823;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1825;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 1829;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_other_click() throws Exception{
 //BA.debugLineNum = 3473;BA.debugLine="Private Sub pan_add_other_Click";
 //BA.debugLineNum = 3474;BA.debugLine="StartActivity(sabt2_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._sabt2_activity.getObject()));
 //BA.debugLineNum = 3475;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_taradod_click() throws Exception{
int _res_val2 = 0;
String _temp_finger = "";
anywheresoftware.b4a.objects.collections.List _ls_vorod0 = null;
anywheresoftware.b4a.objects.collections.List _ls_vorod1 = null;
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 1944;BA.debugLine="Private Sub pan_add_taradod_Click";
 //BA.debugLineNum = 1947;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1948;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1949;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 1950;BA.debugLine="radio_ez_adi.Visible=True";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1951;BA.debugLine="radio_ez_fog.Visible=True";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1952;BA.debugLine="radio_ez_adi.Checked=True";
mostCurrent._radio_ez_adi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1953;BA.debugLine="radio_ez_fog.Checked=False";
mostCurrent._radio_ez_fog.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1955;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1956;BA.debugLine="lbl_box_title.Text=\"ثبت تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت تردد"));
 //BA.debugLineNum = 1957;BA.debugLine="lbl_time_as.Text=\"ورود :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("ورود :"));
 //BA.debugLineNum = 1958;BA.debugLine="lbl_time_ta.Text=\"خروج :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("خروج :"));
 //BA.debugLineNum = 1959;BA.debugLine="index_box=3";
_index_box = (int) (3);
 //BA.debugLineNum = 1960;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1961;BA.debugLine="lbl_time_show_fs.Text=\"\"";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1963;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1964;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1965;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1966;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 1968;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1970;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1971;BA.debugLine="ckb_ezaf_taradod_fs.Checked=True";
mostCurrent._ckb_ezaf_taradod_fs.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1973;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
 //BA.debugLineNum = 1974;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
 //BA.debugLineNum = 1975;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 1976;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
 //BA.debugLineNum = 1979;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1980;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1985;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 1986;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 1987;BA.debugLine="lbl_setting_date.Visible=True";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1991;BA.debugLine="state_tatil= chek_tatil_day(myfunc.fa2en(pik_year";
_state_tatil = _chek_tatil_day((int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText()))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag())))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText()))));
 //BA.debugLineNum = 1993;BA.debugLine="state_tatil_setting = chek_tatil_setting";
_state_tatil_setting = _chek_tatil_setting();
 //BA.debugLineNum = 1995;BA.debugLine="If(state_tatil=0)Then";
if ((_state_tatil==0)) { 
 //BA.debugLineNum = 1996;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
 }else if((_state_tatil==1)) { 
 //BA.debugLineNum = 1998;BA.debugLine="lbl_tatil_show.Text=\"(تعطیل رسمی)\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence("(تعطیل رسمی)"));
 }else if((_state_tatil==2)) { 
 //BA.debugLineNum = 2000;BA.debugLine="lbl_tatil_show.Text=\"(تعطیل قراردادی)\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence("(تعطیل قراردادی)"));
 };
 //BA.debugLineNum = 2005;BA.debugLine="Dim res_val2 As Int =dbCode.get_setting_byName(\"s";
_res_val2 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode")));
 //BA.debugLineNum = 2006;BA.debugLine="If(res_val2=1)Then";
if ((_res_val2==1)) { 
 //BA.debugLineNum = 2008;BA.debugLine="pan_finger_taradod.Visible=True";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2010;BA.debugLine="lbl_finger_fs_vorod.Typeface=Typeface.MATERIALIC";
mostCurrent._lbl_finger_fs_vorod.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
 //BA.debugLineNum = 2011;BA.debugLine="lbl_finger_fs_khoroj.Typeface=Typeface.MATERIALI";
mostCurrent._lbl_finger_fs_khoroj.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
 //BA.debugLineNum = 2012;BA.debugLine="lbl_finger_fs_vorod.Text=Chr(0xE90D)";
mostCurrent._lbl_finger_fs_vorod.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe90d))));
 //BA.debugLineNum = 2013;BA.debugLine="lbl_finger_fs_khoroj.Text=Chr(0xE90D)";
mostCurrent._lbl_finger_fs_khoroj.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe90d))));
 //BA.debugLineNum = 2015;BA.debugLine="If(File.Exists(File.DirInternal,\"finger_vorod_ta";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2018;BA.debugLine="Dim temp_finger As String = File.readString(Fil";
_temp_finger = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt");
 //BA.debugLineNum = 2019;BA.debugLine="If(temp_finger=0)Then";
if (((_temp_finger).equals(BA.NumberToString(0)))) { 
 //BA.debugLineNum = 2021;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
 //BA.debugLineNum = 2023;BA.debugLine="save_box_allow=False";
_save_box_allow = anywheresoftware.b4a.keywords.Common.False;
 }else if(((_temp_finger).equals(BA.NumberToString(1)))) { 
 //BA.debugLineNum = 2028;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 2029;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 2031;BA.debugLine="Dim ls_vorod0 As List";
_ls_vorod0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2032;BA.debugLine="ls_vorod0.Initialize";
_ls_vorod0.Initialize();
 //BA.debugLineNum = 2033;BA.debugLine="ls_vorod0=File.ReadList(File.DirInternal,\"temp";
_ls_vorod0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt");
 //BA.debugLineNum = 2035;BA.debugLine="lbl_date1.Text=ls_vorod0.Get(0)";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (0))));
 //BA.debugLineNum = 2036;BA.debugLine="lbl_tim1.Text=ls_vorod0.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (1))));
 //BA.debugLineNum = 2038;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 2040;BA.debugLine="lbl_finger_fs_vorod.Tag=0";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(0));
 //BA.debugLineNum = 2041;BA.debugLine="lbl_finger_fs_khoroj.Tag=1";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(1));
 //BA.debugLineNum = 2043;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2044;BA.debugLine="lbl_time_show_fs.Text=\"\"";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2046;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2047;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2049;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2050;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2051;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2052;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2056;BA.debugLine="save_box_allow=False";
_save_box_allow = anywheresoftware.b4a.keywords.Common.False;
 }else if(((_temp_finger).equals(BA.NumberToString(2)))) { 
 //BA.debugLineNum = 2060;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 2061;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 2063;BA.debugLine="Dim ls_vorod0 As List";
_ls_vorod0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2064;BA.debugLine="ls_vorod0.Initialize";
_ls_vorod0.Initialize();
 //BA.debugLineNum = 2065;BA.debugLine="ls_vorod0=File.ReadList(File.DirInternal,\"temp";
_ls_vorod0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt");
 //BA.debugLineNum = 2066;BA.debugLine="lbl_date1.Text=ls_vorod0.Get(0)";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (0))));
 //BA.debugLineNum = 2067;BA.debugLine="lbl_tim1.Text=ls_vorod0.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (1))));
 //BA.debugLineNum = 2068;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 2072;BA.debugLine="Dim ls_vorod1 As List";
_ls_vorod1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2073;BA.debugLine="ls_vorod1.Initialize";
_ls_vorod1.Initialize();
 //BA.debugLineNum = 2074;BA.debugLine="ls_vorod1=File.ReadList(File.DirInternal,\"temp";
_ls_vorod1 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_khoroj.txt");
 //BA.debugLineNum = 2075;BA.debugLine="lbl_date2.Text=ls_vorod1.Get(0)";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(_ls_vorod1.Get((int) (0))));
 //BA.debugLineNum = 2076;BA.debugLine="lbl_tim2.Text=ls_vorod1.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_vorod1.Get((int) (1))));
 //BA.debugLineNum = 2077;BA.debugLine="lbl_finger_fs_khoroj_time.Text=lbl_date2.Text&";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date2.getText()+" - "+mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 2079;BA.debugLine="lbl_finger_fs_vorod.Tag=0";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(0));
 //BA.debugLineNum = 2080;BA.debugLine="lbl_finger_fs_khoroj.Tag=0";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(0));
 //BA.debugLineNum = 2082;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 2084;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 };
 }else {
 //BA.debugLineNum = 2087;BA.debugLine="lbl_finger_fs_vorod_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(" - "));
 //BA.debugLineNum = 2088;BA.debugLine="lbl_finger_fs_khoroj_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(" - "));
 //BA.debugLineNum = 2089;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 2090;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 2092;BA.debugLine="lbl_finger_fs_vorod.Tag=1";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(1));
 //BA.debugLineNum = 2093;BA.debugLine="lbl_finger_fs_khoroj.Tag=2";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(2));
 };
 }else {
 //BA.debugLineNum = 2101;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_vorod_tara";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2102;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2103;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 2104;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_v";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt");
 //BA.debugLineNum = 2109;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2112;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
 //BA.debugLineNum = 2114;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2115;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 2119;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_khoroj_tar";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2120;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2121;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 2122;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt");
 //BA.debugLineNum = 2127;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2132;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
 //BA.debugLineNum = 2134;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2135;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 2145;BA.debugLine="time_show";
_time_show();
 };
 //BA.debugLineNum = 2158;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_chekupdate_click() throws Exception{
 //BA.debugLineNum = 4335;BA.debugLine="Private Sub pan_all_chekUpdate_Click";
 //BA.debugLineNum = 4336;BA.debugLine="pan_all_chekUpdate.Visible=False";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4337;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_click() throws Exception{
 //BA.debugLineNum = 2263;BA.debugLine="Private Sub pan_all_Click";
 //BA.debugLineNum = 2264;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2265;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_litemenu_click() throws Exception{
 //BA.debugLineNum = 4157;BA.debugLine="Private Sub pan_all_liteMenu_Click";
 //BA.debugLineNum = 4158;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4159;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_msgnewyear_click() throws Exception{
 //BA.debugLineNum = 463;BA.debugLine="Private Sub pan_all_msgNewYear_Click";
 //BA.debugLineNum = 465;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_noskhe_click() throws Exception{
 //BA.debugLineNum = 4104;BA.debugLine="Private Sub pan_all_noskhe_Click";
 //BA.debugLineNum = 4105;BA.debugLine="pan_all_noskhe.Visible=False";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4106;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_setting_date_click() throws Exception{
 //BA.debugLineNum = 4610;BA.debugLine="Private Sub pan_all_setting_date_Click";
 //BA.debugLineNum = 4611;BA.debugLine="pan_all_setting_date.Visible=False";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4612;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all2_click() throws Exception{
 //BA.debugLineNum = 3683;BA.debugLine="Private Sub pan_all2_Click";
 //BA.debugLineNum = 3686;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3687;BA.debugLine="End Sub";
return "";
}
public static String  _pan_bime_click() throws Exception{
anywheresoftware.b4a.phone.Phone.PhoneIntents _phoneintents1 = null;
 //BA.debugLineNum = 4253;BA.debugLine="Private Sub pan_bime_Click";
 //BA.debugLineNum = 4256;BA.debugLine="Dim PhoneIntents1 As PhoneIntents";
_phoneintents1 = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
 //BA.debugLineNum = 4257;BA.debugLine="StartActivity (PhoneIntents1.OpenBrowser(\"https:/";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_phoneintents1.OpenBrowser("https://eservices.tamin.ir/view/#/history")));
 //BA.debugLineNum = 4259;BA.debugLine="End Sub";
return "";
}
public static String  _pan_calc_click() throws Exception{
 //BA.debugLineNum = 3752;BA.debugLine="Private Sub pan_calc_Click";
 //BA.debugLineNum = 3753;BA.debugLine="StartActivity(calc_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._calc_activity.getObject()));
 //BA.debugLineNum = 3756;BA.debugLine="End Sub";
return "";
}
public static String  _pan_comment_click() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _market = null;
String _url = "";
 //BA.debugLineNum = 3694;BA.debugLine="Private Sub pan_comment_Click";
 //BA.debugLineNum = 3696;BA.debugLine="Try";
try { //BA.debugLineNum = 3697;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 3699;BA.debugLine="Try";
try { //BA.debugLineNum = 3700;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 3701;BA.debugLine="Dim url As String";
_url = "";
 //BA.debugLineNum = 3703;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafek";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
 //BA.debugLineNum = 3704;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
 //BA.debugLineNum = 3705;BA.debugLine="market.SetPackage(\"com.farsitel.bazaar\")";
_market.SetPackage("com.farsitel.bazaar");
 //BA.debugLineNum = 3706;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e11) {
			processBA.setLastException(e11); //BA.debugLineNum = 3709;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
 //BA.debugLineNum = 3712;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e17) {
			processBA.setLastException(e17); //BA.debugLineNum = 3716;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 3718;BA.debugLine="Try";
try { //BA.debugLineNum = 3719;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 3720;BA.debugLine="Dim url As String";
_url = "";
 //BA.debugLineNum = 3722;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafe";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
 //BA.debugLineNum = 3723;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
 //BA.debugLineNum = 3724;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e25) {
			processBA.setLastException(e25); //BA.debugLineNum = 3727;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
 //BA.debugLineNum = 3730;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 };
 //BA.debugLineNum = 3737;BA.debugLine="End Sub";
return "";
}
public static String  _pan_darsad_click() throws Exception{
 //BA.debugLineNum = 3689;BA.debugLine="Private Sub pan_darsad_Click";
 //BA.debugLineNum = 3690;BA.debugLine="StartActivity(darsad_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._darsad_activity.getObject()));
 //BA.debugLineNum = 3692;BA.debugLine="End Sub";
return "";
}
public static String  _pan_eidi_click() throws Exception{
 //BA.debugLineNum = 3453;BA.debugLine="Private Sub pan_eidi_Click";
 //BA.debugLineNum = 3454;BA.debugLine="StartActivity(eidi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._eidi_activity.getObject()));
 //BA.debugLineNum = 3456;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ezafekari_mah_click() throws Exception{
 //BA.debugLineNum = 4070;BA.debugLine="Private Sub pan_ezafekari_mah_Click";
 //BA.debugLineNum = 4071;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 //BA.debugLineNum = 4072;BA.debugLine="TabHost1.CurrentTab=0";
mostCurrent._tabhost1.setCurrentTab((int) (0));
 //BA.debugLineNum = 4074;BA.debugLine="End Sub";
return "";
}
public static String  _pan_fast_run_click() throws Exception{
 //BA.debugLineNum = 1690;BA.debugLine="Private Sub pan_fast_run_Click";
 //BA.debugLineNum = 1695;BA.debugLine="StartActivity(fast_run_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._fast_run_activity.getObject()));
 //BA.debugLineNum = 1699;BA.debugLine="End Sub";
return "";
}
public static String  _pan_finger_taradod_click() throws Exception{
 //BA.debugLineNum = 4647;BA.debugLine="Private Sub pan_finger_taradod_Click";
 //BA.debugLineNum = 4649;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ganon_click() throws Exception{
 //BA.debugLineNum = 4124;BA.debugLine="Private Sub pan_ganon_Click";
 //BA.debugLineNum = 4125;BA.debugLine="StartActivity(ganon_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ganon_activity.getObject()));
 //BA.debugLineNum = 4127;BA.debugLine="End Sub";
return "";
}
public static String  _pan_help_kharid_click() throws Exception{
 //BA.debugLineNum = 4368;BA.debugLine="Private Sub pan_help_kharid_Click";
 //BA.debugLineNum = 4371;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 4372;BA.debugLine="StartActivity(help_kharid_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._help_kharid_activity.getObject()));
 }else {
 //BA.debugLineNum = 4374;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 };
 //BA.debugLineNum = 4379;BA.debugLine="End Sub";
return "";
}
public static String  _pan_help_touch(int _action,float _x,float _y) throws Exception{
 //BA.debugLineNum = 3793;BA.debugLine="Private Sub pan_help_Touch (Action As Int, X As Fl";
 //BA.debugLineNum = 3795;BA.debugLine="If (Action=0)Then";
if ((_action==0)) { 
 //BA.debugLineNum = 3796;BA.debugLine="index_x_start_swap=x";
_index_x_start_swap = (int) (_x);
 //BA.debugLineNum = 3797;BA.debugLine="If (index_curent_img=4)Then";
if ((_index_curent_img==4)) { 
 //BA.debugLineNum = 3798;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 //BA.debugLineNum = 3801;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 3802;BA.debugLine="If(X<(index_x_start_swap-150))Then";
if ((_x<(_index_x_start_swap-150))) { 
 //BA.debugLineNum = 3805;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
 //BA.debugLineNum = 3806;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
 //BA.debugLineNum = 3807;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 }else if((_x>(_index_x_start_swap+150))) { 
 //BA.debugLineNum = 3814;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
 //BA.debugLineNum = 3815;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
 //BA.debugLineNum = 3816;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else if((_index_x_start_swap<(mostCurrent._pan_help.getWidth()/(double)2))) { 
 //BA.debugLineNum = 3822;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
 //BA.debugLineNum = 3823;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
 //BA.debugLineNum = 3824;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else if((_index_x_start_swap>(mostCurrent._pan_help.getWidth()/(double)2))) { 
 //BA.debugLineNum = 3829;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
 //BA.debugLineNum = 3830;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
 //BA.debugLineNum = 3831;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 };
 //BA.debugLineNum = 3836;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 };
 //BA.debugLineNum = 3839;BA.debugLine="End Sub";
return "";
}
public static String  _pan_info_click() throws Exception{
 //BA.debugLineNum = 3463;BA.debugLine="Private Sub pan_info_Click";
 //BA.debugLineNum = 3464;BA.debugLine="StartActivity(info_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._info_activity.getObject()));
 //BA.debugLineNum = 3467;BA.debugLine="End Sub";
return "";
}
public static String  _pan_item_gozaresh_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _ba = null;
 //BA.debugLineNum = 3741;BA.debugLine="Private Sub pan_item_gozaresh_Click";
 //BA.debugLineNum = 3742;BA.debugLine="Dim Ba As Panel = Sender";
_ba = new anywheresoftware.b4a.objects.PanelWrapper();
_ba = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 3744;BA.debugLine="current_gozaresh_id=Ba.Tag";
_current_gozaresh_id = (int)(BA.ObjectToNumber(_ba.getTag()));
 //BA.debugLineNum = 3745;BA.debugLine="StartActivity(show_gozaresh_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._show_gozaresh_activity.getObject()));
 //BA.debugLineNum = 3747;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lelp_click() throws Exception{
 //BA.debugLineNum = 3841;BA.debugLine="Private Sub pan_lelp_Click";
 //BA.debugLineNum = 3843;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lock_click() throws Exception{
 //BA.debugLineNum = 4261;BA.debugLine="Private Sub pan_lock_Click";
 //BA.debugLineNum = 4263;BA.debugLine="End Sub";
return "";
}
public static String  _pan_morakhasi_mah_click() throws Exception{
 //BA.debugLineNum = 4076;BA.debugLine="Private Sub pan_morakhasi_mah_Click";
 //BA.debugLineNum = 4077;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 //BA.debugLineNum = 4078;BA.debugLine="TabHost1.CurrentTab=1";
mostCurrent._tabhost1.setCurrentTab((int) (1));
 //BA.debugLineNum = 4080;BA.debugLine="End Sub";
return "";
}
public static String  _pan_notifi_all_click() throws Exception{
 //BA.debugLineNum = 714;BA.debugLine="Private Sub pan_notifi_all_Click";
 //BA.debugLineNum = 716;BA.debugLine="End Sub";
return "";
}
public static String  _pan_payankar_click() throws Exception{
 //BA.debugLineNum = 3458;BA.debugLine="Private Sub pan_payankar_Click";
 //BA.debugLineNum = 3459;BA.debugLine="StartActivity(payankar_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._payankar_activity.getObject()));
 //BA.debugLineNum = 3461;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_hogog_click() throws Exception{
 //BA.debugLineNum = 1718;BA.debugLine="Private Sub pan_run_hogog_Click";
 //BA.debugLineNum = 1719;BA.debugLine="If (myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 1720;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
 }else {
 //BA.debugLineNum = 1722;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
 //BA.debugLineNum = 1723;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 1728;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_morakhasi_click() throws Exception{
 //BA.debugLineNum = 1707;BA.debugLine="Private Sub pan_run_morakhasi_Click";
 //BA.debugLineNum = 1709;BA.debugLine="StartActivity(morakhasi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._morakhasi_activity.getObject()));
 //BA.debugLineNum = 1716;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_click() throws Exception{
 //BA.debugLineNum = 4129;BA.debugLine="Private Sub pan_setting_Click";
 //BA.debugLineNum = 4130;BA.debugLine="StartActivity(setting_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_activity.getObject()));
 //BA.debugLineNum = 4131;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 4132;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_hogog_click() throws Exception{
 //BA.debugLineNum = 1701;BA.debugLine="Private Sub pan_setting_hogog_Click";
 //BA.debugLineNum = 1702;BA.debugLine="StartActivity(setting_hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_hogog_activity.getObject()));
 //BA.debugLineNum = 1703;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 1705;BA.debugLine="End Sub";
return "";
}
public static String  _pan_shift_click() throws Exception{
 //BA.debugLineNum = 4142;BA.debugLine="Private Sub pan_shift_Click";
 //BA.debugLineNum = 4144;BA.debugLine="StartActivity(shift_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._shift_activity.getObject()));
 //BA.debugLineNum = 4146;BA.debugLine="End Sub";
return "";
}
public static String  _pan_taghvim_click() throws Exception{
 //BA.debugLineNum = 4148;BA.debugLine="Private Sub pan_taghvim_Click";
 //BA.debugLineNum = 4149;BA.debugLine="pan_shift_Click";
_pan_shift_click();
 //BA.debugLineNum = 4150;BA.debugLine="End Sub";
return "";
}
public static String  _panel1_click() throws Exception{
 //BA.debugLineNum = 4161;BA.debugLine="Private Sub Panel1_Click";
 //BA.debugLineNum = 4163;BA.debugLine="End Sub";
return "";
}
public static String  _panel10_click() throws Exception{
 //BA.debugLineNum = 4339;BA.debugLine="Private Sub Panel10_Click";
 //BA.debugLineNum = 4341;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
 //BA.debugLineNum = 2267;BA.debugLine="Private Sub Panel4_Click";
 //BA.debugLineNum = 2269;BA.debugLine="End Sub";
return "";
}
public static String  _panel5_click() throws Exception{
 //BA.debugLineNum = 4108;BA.debugLine="Private Sub Panel5_Click";
 //BA.debugLineNum = 4110;BA.debugLine="End Sub";
return "";
}
public static String  _panel6_click() throws Exception{
 //BA.debugLineNum = 4237;BA.debugLine="Private Sub Panel6_Click";
 //BA.debugLineNum = 4239;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3376;BA.debugLine="Private Sub pik_day_bala1_Click";
 //BA.debugLineNum = 3377;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 3378;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 3381;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 3382;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 3383;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 3385;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 3386;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 3389;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 3390;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 3392;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 3393;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 3397;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 //BA.debugLineNum = 3399;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3401;BA.debugLine="Private Sub pik_day_paeen1_Click";
 //BA.debugLineNum = 3402;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 3403;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 3404;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 3405;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 3406;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 3408;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 3409;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 3412;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 3413;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 3415;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 3416;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 3420;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 //BA.debugLineNum = 3422;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3083;BA.debugLine="Private Sub pik_hour_bala1_Click";
 //BA.debugLineNum = 3085;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
 //BA.debugLineNum = 3086;BA.debugLine="pik_hour1.Text=int1+1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 3090;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
 //BA.debugLineNum = 3091;BA.debugLine="pik_hour1.Text=0";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 3093;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
 //BA.debugLineNum = 3094;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
 //BA.debugLineNum = 3097;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(pik_hour1.Text";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_hour1.getText())))));
 //BA.debugLineNum = 3099;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3101;BA.debugLine="Private Sub pik_hour_paeen1_Click";
 //BA.debugLineNum = 3102;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
 //BA.debugLineNum = 3103;BA.debugLine="pik_hour1.Text=int1-1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 3105;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
 //BA.debugLineNum = 3106;BA.debugLine="pik_hour1.Text=0";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 3108;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
 //BA.debugLineNum = 3109;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
 //BA.debugLineNum = 3112;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(pik_hour1.Text";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_hour1.getText())))));
 //BA.debugLineNum = 3113;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3115;BA.debugLine="Private Sub pik_min_bala1_Click";
 //BA.debugLineNum = 3116;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
 //BA.debugLineNum = 3117;BA.debugLine="pik_min1.Text=int1+1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 3119;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
 //BA.debugLineNum = 3120;BA.debugLine="pik_min1.Text=0";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 3122;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
 //BA.debugLineNum = 3123;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
 //BA.debugLineNum = 3126;BA.debugLine="pik_min1.Text=myfunc.convert_adad(pik_min1.Text)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_min1.getText())))));
 //BA.debugLineNum = 3128;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3130;BA.debugLine="Private Sub pik_min_paeen1_Click";
 //BA.debugLineNum = 3131;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
 //BA.debugLineNum = 3132;BA.debugLine="pik_min1.Text=int1-1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 3134;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
 //BA.debugLineNum = 3135;BA.debugLine="pik_min1.Text=0";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 3137;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
 //BA.debugLineNum = 3138;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
 //BA.debugLineNum = 3140;BA.debugLine="pik_min1.Text=myfunc.convert_adad(pik_min1.Text)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_min1.getText())))));
 //BA.debugLineNum = 3142;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3322;BA.debugLine="Private Sub pik_moon_bala1_Click";
 //BA.debugLineNum = 3323;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 3324;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
 //BA.debugLineNum = 3326;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 3327;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 3329;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 3330;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 3332;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 3334;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3336;BA.debugLine="Private Sub pik_moon_paeen1_Click";
 //BA.debugLineNum = 3337;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 3338;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
 //BA.debugLineNum = 3340;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 3341;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 3343;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 3344;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 3346;BA.debugLine="pik_moon1.Text=moon.Get(myfunc.fa2en(pik_moon1.Ta";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
 //BA.debugLineNum = 3348;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3282;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
 //BA.debugLineNum = 3283;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 3284;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 3285;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3288;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 3290;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 3291;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
 //BA.debugLineNum = 3292;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3293;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3295;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 3296;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
 //BA.debugLineNum = 3297;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3298;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3301;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 3302;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 3303;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 3305;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 3306;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 3309;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 3310;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 3312;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 3313;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 3317;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 };
 //BA.debugLineNum = 3320;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_hour1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3144;BA.debugLine="Private Sub pik_pan_hour1_Touch (Action As Int, X";
 //BA.debugLineNum = 3145;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 3146;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 3147;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3150;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 3152;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 3153;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))-1);
 //BA.debugLineNum = 3154;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3155;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3157;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 3158;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))+1);
 //BA.debugLineNum = 3159;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3160;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3163;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
 //BA.debugLineNum = 3164;BA.debugLine="pik_hour1.Text=0";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 3166;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
 //BA.debugLineNum = 3167;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
 //BA.debugLineNum = 3170;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(pik_hour1.Tex";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_hour1.getText())))));
 };
 //BA.debugLineNum = 3175;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_min1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3177;BA.debugLine="Private Sub pik_pan_min1_Touch (Action As Int, X A";
 //BA.debugLineNum = 3178;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 3179;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 3180;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3183;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 3185;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 3187;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))-1);
 //BA.debugLineNum = 3188;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3191;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3193;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 3195;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))+1);
 //BA.debugLineNum = 3196;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3199;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3203;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
 //BA.debugLineNum = 3204;BA.debugLine="pik_min1.Text=0";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 3207;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
 //BA.debugLineNum = 3208;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
 //BA.debugLineNum = 3210;BA.debugLine="pik_min1.Text=myfunc.convert_adad(pik_min1.Text)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_min1.getText())))));
 };
 //BA.debugLineNum = 3216;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3222;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
 //BA.debugLineNum = 3223;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 3224;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 3225;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3228;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 3230;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 3231;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
 //BA.debugLineNum = 3232;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 3233;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3235;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 3236;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
 //BA.debugLineNum = 3237;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 3238;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3241;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 3242;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 3244;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 3245;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 3247;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
 //BA.debugLineNum = 3250;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3252;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
 //BA.debugLineNum = 3253;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 3254;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 3255;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3258;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 3260;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 3261;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
 //BA.debugLineNum = 3262;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3263;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3265;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 3266;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
 //BA.debugLineNum = 3267;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3268;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3271;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 3272;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 3274;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 3275;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
 //BA.debugLineNum = 3280;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3350;BA.debugLine="Private Sub pik_year_bala1_Click";
 //BA.debugLineNum = 3351;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 3352;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 3354;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 3355;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 3357;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 3358;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 3361;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3363;BA.debugLine="Private Sub pik_year_paeen1_Click";
 //BA.debugLineNum = 3364;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 3365;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 3367;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 3368;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 3370;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 3371;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 3374;BA.debugLine="End Sub";
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
shift_activity._process_globals();
ayabzahab_activity._process_globals();
bime_activity._process_globals();
calc_activity._process_globals();
comment_activity._process_globals();
darsad_activity._process_globals();
eidi_activity._process_globals();
fast_run_activity._process_globals();
food_activity._process_globals();
ganon_activity._process_globals();
gestha_activity._process_globals();
help_kharid_activity._process_globals();
hogog_activity._process_globals();
info_activity._process_globals();
morakhasi_activity._process_globals();
mosaedeh_activity._process_globals();
padash_activity._process_globals();
payankar_activity._process_globals();
sabt2_activity._process_globals();
savabeg_activity._process_globals();
sayer_activity._process_globals();
setting_activity._process_globals();
setting_hogog_activity._process_globals();
show_gozaresh_activity._process_globals();
starter._process_globals();
step0_activity._process_globals();
step1_activity._process_globals();
step2_activity._process_globals();
vam_activity._process_globals();
httputils2service._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 20;BA.debugLine="Dim app_vesion As String=Application.VersionName";
_app_vesion = anywheresoftware.b4a.keywords.Common.Application.getVersionName();
 //BA.debugLineNum = 22;BA.debugLine="Dim timer1 As Timer";
_timer1 = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 23;BA.debugLine="Dim tim_msg As Timer";
_tim_msg = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 25;BA.debugLine="Dim tim_lock_lbl As Timer";
_tim_lock_lbl = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 26;BA.debugLine="Dim tim_msg_newYear As Timer";
_tim_msg_newyear = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 27;BA.debugLine="Dim tim_check_update As Timer";
_tim_check_update = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 29;BA.debugLine="Dim current_gozaresh_id As Int";
_current_gozaresh_id = 0;
 //BA.debugLineNum = 30;BA.debugLine="Dim persianDate As ManamPersianDate";
_persiandate = new com.b4a.manamsoftware.PersianDate.ManamPersianDate();
 //BA.debugLineNum = 32;BA.debugLine="Dim year_num As String";
_year_num = "";
 //BA.debugLineNum = 33;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 36;BA.debugLine="Dim phon As Phone";
_phon = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 38;BA.debugLine="Dim buy_index As Int";
_buy_index = 0;
 //BA.debugLineNum = 40;BA.debugLine="Dim time_page_load As Timer";
_time_page_load = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 42;BA.debugLine="Dim color_index As Int=1";
_color_index = (int) (1);
 //BA.debugLineNum = 43;BA.debugLine="Dim color1 As Int=0XFF69AC00   ' hed home1";
_color1 = ((int)0xff69ac00);
 //BA.debugLineNum = 44;BA.debugLine="Dim color2 As Int=0xFF00C7C7	' hed home2";
_color2 = ((int)0xff00c7c7);
 //BA.debugLineNum = 45;BA.debugLine="Dim color3 As Int=0XFFFFFFFF	' hed home3 font";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 46;BA.debugLine="Dim color4 As Int=0XFF69AC00	' all head";
_color4 = ((int)0xff69ac00);
 //BA.debugLineNum = 47;BA.debugLine="Dim color5 As Int=0XFF69AC00	' calc";
_color5 = ((int)0xff69ac00);
 //BA.debugLineNum = 49;BA.debugLine="Dim main_font As String=\"یکان\"";
_main_font = "یکان";
 //BA.debugLineNum = 50;BA.debugLine="Dim size_f1 As Int=17";
_size_f1 = (int) (17);
 //BA.debugLineNum = 51;BA.debugLine="Dim size_f2 As Int=15";
_size_f2 = (int) (15);
 //BA.debugLineNum = 52;BA.debugLine="Dim size_f3 As Int=13";
_size_f3 = (int) (13);
 //BA.debugLineNum = 54;BA.debugLine="Dim saat_kar_min As Int";
_saat_kar_min = 0;
 //BA.debugLineNum = 56;BA.debugLine="Dim phon_num As String";
_phon_num = "";
 //BA.debugLineNum = 57;BA.debugLine="Dim user_nameFamili As String=\"کاربر\"";
_user_namefamili = "کاربر";
 //BA.debugLineNum = 59;BA.debugLine="Dim msg_page_show As Int =0";
_msg_page_show = (int) (0);
 //BA.debugLineNum = 60;BA.debugLine="Dim backup_page_show As Int =0";
_backup_page_show = (int) (0);
 //BA.debugLineNum = 62;BA.debugLine="Dim current_idvam As String=\"\"";
_current_idvam = "";
 //BA.debugLineNum = 63;BA.debugLine="Dim is_first_time As Boolean=False";
_is_first_time = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public static String  _resetting_all() throws Exception{
 //BA.debugLineNum = 936;BA.debugLine="Sub resetting_all";
 //BA.debugLineNum = 938;BA.debugLine="key1.color = Colors.White";
mostCurrent._key1.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 939;BA.debugLine="key2.Color = Colors.White";
mostCurrent._key2.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 940;BA.debugLine="key3.Color = Colors.White";
mostCurrent._key3.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 941;BA.debugLine="key4.Color = Colors.white";
mostCurrent._key4.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 944;BA.debugLine="entered_Password = \"\"";
mostCurrent._entered_password = "";
 //BA.debugLineNum = 948;BA.debugLine="Click_Count = 0";
_click_count = (int) (0);
 //BA.debugLineNum = 949;BA.debugLine="End Sub";
return "";
}
public static boolean  _rspop_noe_menuitemclick(int _itemid) throws Exception{
 //BA.debugLineNum = 1838;BA.debugLine="Sub rsPOP_noe_MenuItemClick (ItemId As Int) As Boo";
 //BA.debugLineNum = 1840;BA.debugLine="Select ItemId";
switch (_itemid) {
case 0: {
 //BA.debugLineNum = 1842;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
 //BA.debugLineNum = 1844;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
 //BA.debugLineNum = 1846;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
 //BA.debugLineNum = 1848;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
 //BA.debugLineNum = 1852;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
 //BA.debugLineNum = 1853;BA.debugLine="index_noe_morakhasi=ItemId";
_index_noe_morakhasi = _itemid;
 //BA.debugLineNum = 1854;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1855;BA.debugLine="End Sub";
return false;
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 3443;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
 //BA.debugLineNum = 3444;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 3446;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
 //BA.debugLineNum = 3449;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
 //BA.debugLineNum = 3450;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
 //BA.debugLineNum = 3451;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_gozaresh_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 4165;BA.debugLine="Private Sub sp_year_gozaresh_ItemClick (Position A";
 //BA.debugLineNum = 4166;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
 //BA.debugLineNum = 4167;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 3429;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
 //BA.debugLineNum = 3434;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 3435;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
 //BA.debugLineNum = 3437;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
 //BA.debugLineNum = 3439;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
 //BA.debugLineNum = 3441;BA.debugLine="End Sub";
return "";
}
public static String  _tabhost1_tabchanged() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_all_saat = null;
String _str_saat = "";
 //BA.debugLineNum = 1259;BA.debugLine="Private Sub TabHost1_TabChanged";
 //BA.debugLineNum = 1261;BA.debugLine="Dim ls_all_saat As List";
_ls_all_saat = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1262;BA.debugLine="ls_all_saat.Initialize";
_ls_all_saat.Initialize();
 //BA.debugLineNum = 1263;BA.debugLine="Dim str_saat As String";
_str_saat = "";
 //BA.debugLineNum = 1265;BA.debugLine="If(sp_year.IsInitialized)Then";
if ((mostCurrent._sp_year.IsInitialized())) { 
 //BA.debugLineNum = 1271;BA.debugLine="Select TabHost1.CurrentTab";
switch (BA.switchObjectToInt(mostCurrent._tabhost1.getCurrentTab(),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
 //BA.debugLineNum = 1273;BA.debugLine="ls_all_saat=dbCode.all_ezafekari_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
 //BA.debugLineNum = 1274;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
case 1: {
 //BA.debugLineNum = 1276;BA.debugLine="ls_all_saat=dbCode.all_morakhasi_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 //BA.debugLineNum = 1278;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" روز و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" ساعت و "+BA.ObjectToString(_ls_all_saat.Get((int) (2)))+" دقیقه ";
 break; }
case 2: {
 //BA.debugLineNum = 1280;BA.debugLine="ls_all_saat=dbCode.all_taradod_mah(myfunc.fa2e";
_ls_all_saat = mostCurrent._dbcode._all_taradod_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 //BA.debugLineNum = 1281;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
case 3: {
 //BA.debugLineNum = 1283;BA.debugLine="ls_all_saat=dbCode.all_mamoriat_mah(myfunc.fa2";
_ls_all_saat = mostCurrent._dbcode._all_mamoriat_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 //BA.debugLineNum = 1284;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" روز و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" ساعت و "+BA.ObjectToString(_ls_all_saat.Get((int) (2)))+" دقیقه ";
 break; }
}
;
 //BA.debugLineNum = 1291;BA.debugLine="lbl_majmoe_saat.Text=str_saat";
mostCurrent._lbl_majmoe_saat.setText(BA.ObjectToCharSequence(_str_saat));
 };
 //BA.debugLineNum = 1297;BA.debugLine="End Sub";
return "";
}
public static String  _tatil_hast() throws Exception{
 //BA.debugLineNum = 3064;BA.debugLine="Sub tatil_hast";
 //BA.debugLineNum = 3066;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3067;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3068;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=True";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3069;BA.debugLine="ckb_ezaf_taradod_fs.Visible=True";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3072;BA.debugLine="radio_ez_adi.Enabled=True";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3073;BA.debugLine="radio_ez_fog.Enabled=True";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3076;BA.debugLine="lbl_ezaf_taradod.Text=\"افزودن به اضافه کاری \"&((m";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("افزودن به اضافه کاری "+BA.ObjectToString(((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_tim_min).Get((int) (0)))))+" ساعت و "+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_tim_min)).Get((int) (1)))+" دقیقه "));
 //BA.debugLineNum = 3078;BA.debugLine="lbl_ezaf_taradod_fs.Text=lbl_ezaf_taradod.Text";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(mostCurrent._lbl_ezaf_taradod.getText()));
 //BA.debugLineNum = 3081;BA.debugLine="End Sub";
return "";
}
public static String  _tatil_nist() throws Exception{
 //BA.debugLineNum = 3033;BA.debugLine="Sub tatil_nist";
 //BA.debugLineNum = 3034;BA.debugLine="If(tim_min>saat_kar_min) Then";
if ((_tim_min>_saat_kar_min)) { 
 //BA.debugLineNum = 3037;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3038;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3039;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=True";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3040;BA.debugLine="ckb_ezaf_taradod_fs.Visible=True";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3043;BA.debugLine="radio_ez_adi.Enabled=True";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3044;BA.debugLine="radio_ez_fog.Enabled=True";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3047;BA.debugLine="lbl_ezaf_taradod.Text=\"افزودن به اضافه کاری \"&((";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("افزودن به اضافه کاری "+BA.ObjectToString(((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (0)))))+" ساعت و "+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min))).Get((int) (1)))+" دقیقه "));
 //BA.debugLineNum = 3049;BA.debugLine="lbl_ezaf_taradod_fs.Text=lbl_ezaf_taradod.Text";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(mostCurrent._lbl_ezaf_taradod.getText()));
 }else {
 //BA.debugLineNum = 3052;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 3053;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3054;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3055;BA.debugLine="radio_ez_adi.Enabled=False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3056;BA.debugLine="radio_ez_fog.Enabled=False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3057;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 3058;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3059;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 3062;BA.debugLine="End Sub";
return "";
}
public static String  _tim_check_update_tick() throws Exception{
 //BA.debugLineNum = 445;BA.debugLine="Sub tim_check_update_Tick";
 //BA.debugLineNum = 446;BA.debugLine="chk_update_auto";
_chk_update_auto();
 //BA.debugLineNum = 447;BA.debugLine="Log(\"now cheking ....\")";
anywheresoftware.b4a.keywords.Common.LogImpl("5196610","now cheking ....",0);
 //BA.debugLineNum = 448;BA.debugLine="tim_check_update.Enabled=False";
_tim_check_update.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 449;BA.debugLine="End Sub";
return "";
}
public static String  _tim_lock_lbl_tick() throws Exception{
 //BA.debugLineNum = 819;BA.debugLine="Sub tim_lock_lbl_Tick";
 //BA.debugLineNum = 820;BA.debugLine="If(stat_finger=0)Then";
if ((_stat_finger==0)) { 
 //BA.debugLineNum = 821;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
mostCurrent._lbl_finger.setTextColor(((int)0xff0b6200));
 //BA.debugLineNum = 822;BA.debugLine="stat_finger=1";
_stat_finger = (int) (1);
 }else {
 //BA.debugLineNum = 824;BA.debugLine="lbl_finger.TextColor=0xFF2FFF00";
mostCurrent._lbl_finger.setTextColor(((int)0xff2fff00));
 //BA.debugLineNum = 825;BA.debugLine="stat_finger=0";
_stat_finger = (int) (0);
 };
 //BA.debugLineNum = 827;BA.debugLine="End Sub";
return "";
}
public static String  _tim_msg_newyear_tick() throws Exception{
 //BA.debugLineNum = 451;BA.debugLine="Sub tim_msg_newYear_Tick";
 //BA.debugLineNum = 452;BA.debugLine="pan_all_msgNewYear.Visible=True";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 454;BA.debugLine="tim_msg_newYear.Enabled=False";
_tim_msg_newyear.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 455;BA.debugLine="End Sub";
return "";
}
public static String  _tim_msg_tick() throws Exception{
String _msg_key = "";
String _msg_value = "";
 //BA.debugLineNum = 650;BA.debugLine="Sub tim_msg_Tick";
 //BA.debugLineNum = 652;BA.debugLine="Dim msg_key As String";
_msg_key = "";
 //BA.debugLineNum = 653;BA.debugLine="Dim msg_value As String";
_msg_value = "";
 //BA.debugLineNum = 656;BA.debugLine="msg_key=msg.SubString2(0,4)";
_msg_key = mostCurrent._msg.substring((int) (0),(int) (4));
 //BA.debugLineNum = 657;BA.debugLine="msg_value=msg.SubString(5)";
_msg_value = mostCurrent._msg.substring((int) (5));
 //BA.debugLineNum = 659;BA.debugLine="ls1.Add(msg_key)";
mostCurrent._ls1.Add((Object)(_msg_key));
 //BA.debugLineNum = 660;BA.debugLine="ls2.Add(msg_value)";
mostCurrent._ls2.Add((Object)(_msg_value));
 //BA.debugLineNum = 661;BA.debugLine="ls3.Add(lbl_date_home.Text)";
mostCurrent._ls3.Add((Object)(mostCurrent._lbl_date_home.getText()));
 //BA.debugLineNum = 663;BA.debugLine="File.WriteList(File.DirInternal,\"ls1\",ls1)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1",mostCurrent._ls1);
 //BA.debugLineNum = 664;BA.debugLine="File.WriteList(File.DirInternal,\"ls2\",ls2)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls2",mostCurrent._ls2);
 //BA.debugLineNum = 665;BA.debugLine="File.WriteList(File.DirInternal,\"ls3\",ls3)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls3",mostCurrent._ls3);
 //BA.debugLineNum = 667;BA.debugLine="lbl_title_msgPan.Text=\"پیام جدید\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام جدید"));
 //BA.debugLineNum = 668;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 670;BA.debugLine="pan_notif.Top=20%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 671;BA.debugLine="pan_notif.Height=50%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA));
 //BA.debugLineNum = 672;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
 //BA.debugLineNum = 675;BA.debugLine="web_msg_show.LoadHtml(\"<!DOCTYPE html><html><meta";
mostCurrent._web_msg_show.LoadHtml("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'><div style='background-color: #99ffff; font-size: 14px;'>"+"کد پیام : "+_msg_key+" - مورخ : "+mostCurrent._lbl_date_home.getText()+"</div><div style='background-color: #e6ffff; font-size: 18px;'><br>"+_msg_value+"<br></div><br></body></html>");
 //BA.debugLineNum = 677;BA.debugLine="tim_msg.Enabled=False";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 678;BA.debugLine="End Sub";
return "";
}
public static int  _tim_vorod_conv_ezaf(String _tim1) throws Exception{
String[] _ste_tim = null;
 //BA.debugLineNum = 4241;BA.debugLine="Sub tim_vorod_conv_ezaf (tim1 As String) As Int";
 //BA.debugLineNum = 4243;BA.debugLine="Dim ste_tim() As String";
_ste_tim = new String[(int) (0)];
java.util.Arrays.fill(_ste_tim,"");
 //BA.debugLineNum = 4244;BA.debugLine="ste_tim=Regex.Split(\":\",tim1)";
_ste_tim = anywheresoftware.b4a.keywords.Common.Regex.Split(":",_tim1);
 //BA.debugLineNum = 4247;BA.debugLine="Return (ste_tim(0)*60)+ste_tim(1) +saat_kar_min";
if (true) return (int) (((double)(Double.parseDouble(_ste_tim[(int) (0)]))*60)+(double)(Double.parseDouble(_ste_tim[(int) (1)]))+_saat_kar_min);
 //BA.debugLineNum = 4250;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 2888;BA.debugLine="Sub time_show";
 //BA.debugLineNum = 2890;BA.debugLine="Try";
try { //BA.debugLineNum = 2893;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2894;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2895;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
 //BA.debugLineNum = 2896;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
 //BA.debugLineNum = 2898;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
 //BA.debugLineNum = 2899;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
 //BA.debugLineNum = 2900;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 2901;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 2904;BA.debugLine="pik_moon1.Tag=myfunc.convert_adad(pik_moon1.Tag)";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))));
 //BA.debugLineNum = 2909;BA.debugLine="date1=lbl_date1.Text";
mostCurrent._date1 = mostCurrent._lbl_date1.getText();
 //BA.debugLineNum = 2910;BA.debugLine="date2=lbl_date2.Text";
mostCurrent._date2 = mostCurrent._lbl_date2.getText();
 //BA.debugLineNum = 2911;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
 //BA.debugLineNum = 2912;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
 //BA.debugLineNum = 2916;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_dat";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
 //BA.debugLineNum = 2917;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_dat";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
 //BA.debugLineNum = 2920;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
 //BA.debugLineNum = 2921;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
 //BA.debugLineNum = 2924;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
 //BA.debugLineNum = 2925;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
 //BA.debugLineNum = 2927;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date_";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
 //BA.debugLineNum = 2928;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date_";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
 //BA.debugLineNum = 2930;BA.debugLine="time_end2=lbl_tim2.Text&\":00\"";
_time_end2 = mostCurrent._lbl_tim2.getText()+":00";
 //BA.debugLineNum = 2931;BA.debugLine="time_end1=lbl_tim1.Text&\":00\"";
_time_end1 = mostCurrent._lbl_tim1.getText()+":00";
 //BA.debugLineNum = 2933;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
 //BA.debugLineNum = 2934;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
 //BA.debugLineNum = 2935;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
 //BA.debugLineNum = 2936;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
 //BA.debugLineNum = 2940;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
 //BA.debugLineNum = 2941;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
 //BA.debugLineNum = 2944;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 2945;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
 //BA.debugLineNum = 2947;BA.debugLine="If (period_between.Years<>0)Then";
if ((_period_between.Years!=0)) { 
 //BA.debugLineNum = 2948;BA.debugLine="str_show.Append(period_between.Years&\" سال \").A";
_str_show.Append(BA.NumberToString(_period_between.Years)+" سال ").Append(" و ");
 };
 //BA.debugLineNum = 2950;BA.debugLine="If (period_between.Months<>0)Then";
if ((_period_between.Months!=0)) { 
 //BA.debugLineNum = 2951;BA.debugLine="str_show.Append(period_between.Months&\" ماه \").";
_str_show.Append(BA.NumberToString(_period_between.Months)+" ماه ").Append(" و ");
 };
 //BA.debugLineNum = 2953;BA.debugLine="If (period_between.Days<>0)Then";
if ((_period_between.Days!=0)) { 
 //BA.debugLineNum = 2954;BA.debugLine="str_show.Append(period_between.Days&\" روز \").Ap";
_str_show.Append(BA.NumberToString(_period_between.Days)+" روز ").Append(" و ");
 };
 //BA.debugLineNum = 2957;BA.debugLine="str_show.Append(period_between.Hours&\" ساعت \").A";
_str_show.Append(BA.NumberToString(_period_between.Hours)+" ساعت ").Append(" و ");
 //BA.debugLineNum = 2958;BA.debugLine="str_show.Append(period_between.Minutes&\" دقیقه \"";
_str_show.Append(BA.NumberToString(_period_between.Minutes)+" دقیقه ");
 //BA.debugLineNum = 2961;BA.debugLine="year_bt=period_between.Years";
_year_bt = _period_between.Years;
 //BA.debugLineNum = 2962;BA.debugLine="moon_bt=period_between.Months";
_moon_bt = _period_between.Months;
 //BA.debugLineNum = 2963;BA.debugLine="day_bt=period_between.Days";
_day_bt = _period_between.Days;
 //BA.debugLineNum = 2964;BA.debugLine="hour_bt=period_between.Hours";
_hour_bt = _period_between.Hours;
 //BA.debugLineNum = 2965;BA.debugLine="min_bt=period_between.Minutes";
_min_bt = _period_between.Minutes;
 //BA.debugLineNum = 2968;BA.debugLine="lbl_time_show.Text=str_show";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(_str_show.getObject()));
 //BA.debugLineNum = 2969;BA.debugLine="lbl_time_show_fs.Text=lbl_time_show.Text";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(mostCurrent._lbl_time_show.getText()));
 //BA.debugLineNum = 2971;BA.debugLine="If(index_box=3)Then";
if ((_index_box==3)) { 
 //BA.debugLineNum = 2975;BA.debugLine="tim_min=(day_bt*24*60)+(hour_bt*60)+min_bt";
_tim_min = (int) ((_day_bt*24*60)+(_hour_bt*60)+_min_bt);
 //BA.debugLineNum = 2978;BA.debugLine="Select state_tatil_setting";
switch (_state_tatil_setting) {
case 0: {
 //BA.debugLineNum = 2981;BA.debugLine="tatil_nist";
_tatil_nist();
 break; }
case 1: {
 //BA.debugLineNum = 2984;BA.debugLine="If (state_tatil=1 Or state_tatil=2 ) Then 'ta";
if ((_state_tatil==1 || _state_tatil==2)) { 
 //BA.debugLineNum = 2985;BA.debugLine="tatil_hast";
_tatil_hast();
 }else {
 //BA.debugLineNum = 2987;BA.debugLine="tatil_nist";
_tatil_nist();
 };
 break; }
case 11: {
 //BA.debugLineNum = 2991;BA.debugLine="If (state_tatil=1 ) Then 'tatil rasmi";
if ((_state_tatil==1)) { 
 //BA.debugLineNum = 2992;BA.debugLine="tatil_hast";
_tatil_hast();
 }else {
 //BA.debugLineNum = 2994;BA.debugLine="tatil_nist";
_tatil_nist();
 };
 break; }
case 22: {
 //BA.debugLineNum = 2999;BA.debugLine="If (state_tatil=2 ) Then  'tatil garardadi";
if ((_state_tatil==2)) { 
 //BA.debugLineNum = 3000;BA.debugLine="tatil_hast";
_tatil_hast();
 }else {
 //BA.debugLineNum = 3002;BA.debugLine="tatil_nist";
_tatil_nist();
 };
 break; }
}
;
 //BA.debugLineNum = 3009;BA.debugLine="If(is_for_edit=True)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 3010;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 3011;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3012;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3013;BA.debugLine="radio_ez_adi.Enabled=False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3014;BA.debugLine="radio_ez_fog.Enabled=False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3015;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 3016;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3017;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 } 
       catch (Exception e87) {
			processBA.setLastException(e87); //BA.debugLineNum = 3024;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 3030;BA.debugLine="End Sub";
return "";
}
public static String  _timer1_tick() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_lock0 = null;
 //BA.debugLineNum = 762;BA.debugLine="Sub timer1_Tick";
 //BA.debugLineNum = 764;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 765;BA.debugLine="timer1.Enabled=False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 766;BA.debugLine="cv_loader.Hide";
mostCurrent._cv_loader._hide /*String*/ ();
 //BA.debugLineNum = 767;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 //BA.debugLineNum = 773;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=True)T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 774;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 775;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
 //BA.debugLineNum = 776;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_lock";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
 //BA.debugLineNum = 778;BA.debugLine="If(ls_lock0.Get(0)=\"true\")Then";
if (((_ls_lock0.Get((int) (0))).equals((Object)("true")))) { 
 //BA.debugLineNum = 779;BA.debugLine="Master_Password=ls_lock0.Get(2)";
mostCurrent._master_password = BA.ObjectToString(_ls_lock0.Get((int) (2)));
 //BA.debugLineNum = 780;BA.debugLine="pan_lock.Visible=True";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 781;BA.debugLine="lbl_hint_lock.Text=ls_lock0.Get(3)";
mostCurrent._lbl_hint_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (3))));
 //BA.debugLineNum = 783;BA.debugLine="If(ls_lock0.Get(1)=\"true\")Then";
if (((_ls_lock0.Get((int) (1))).equals((Object)("true")))) { 
 //BA.debugLineNum = 785;BA.debugLine="tim_lock_lbl.Initialize(\"tim_lock_lbl\",500)";
_tim_lock_lbl.Initialize(processBA,"tim_lock_lbl",(long) (500));
 //BA.debugLineNum = 786;BA.debugLine="Try";
try { //BA.debugLineNum = 787;BA.debugLine="fingerprint.Initialize (Me, \"auth\")";
mostCurrent._fingerprint._initialize /*String*/ (processBA,main.getObject(),"auth");
 //BA.debugLineNum = 790;BA.debugLine="If fingerprint.HardwareDetected = False Then";
if (mostCurrent._fingerprint._gethardwaredetected /*boolean*/ ()==anywheresoftware.b4a.keywords.Common.False) { 
 }else if(mostCurrent._fingerprint._gethasenrolledfingerprints /*boolean*/ ()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 794;BA.debugLine="ToastMessageShow(\"اثر انگشت تعریف نشده است\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اثر انگشت تعریف نشده است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 796;BA.debugLine="lbl_finger.Visible=True";
mostCurrent._lbl_finger.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 797;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
mostCurrent._lbl_finger.setTextColor(((int)0xff0b6200));
 //BA.debugLineNum = 798;BA.debugLine="finger_scaning";
_finger_scaning();
 //BA.debugLineNum = 799;BA.debugLine="tim_lock_lbl.Enabled=True";
_tim_lock_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e27) {
			processBA.setLastException(e27); //BA.debugLineNum = 803;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("5983081",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
 };
 }else {
 //BA.debugLineNum = 810;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 817;BA.debugLine="End Sub";
return "";
}
}
