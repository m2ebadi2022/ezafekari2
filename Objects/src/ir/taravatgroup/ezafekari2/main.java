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
public anywheresoftware.b4a.inappbilling3.BillingManager3 _inappbazar = null;
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
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.ayabzahab_activity _ayabzahab_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.food_activity _food_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.gestha_activity _gestha_activity = null;
public ir.taravatgroup.ezafekari2.help_kharid_activity _help_kharid_activity = null;
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

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (fast_run_activity.mostCurrent != null);
vis = vis | (hogog_activity.mostCurrent != null);
vis = vis | (ayabzahab_activity.mostCurrent != null);
vis = vis | (bime_activity.mostCurrent != null);
vis = vis | (calc_activity.mostCurrent != null);
vis = vis | (comment_activity.mostCurrent != null);
vis = vis | (darsad_activity.mostCurrent != null);
vis = vis | (eidi_activity.mostCurrent != null);
vis = vis | (food_activity.mostCurrent != null);
vis = vis | (ganon_activity.mostCurrent != null);
vis = vis | (gestha_activity.mostCurrent != null);
vis = vis | (help_kharid_activity.mostCurrent != null);
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
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_user = null;
 //BA.debugLineNum = 346;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 350;BA.debugLine="Try";
try { //BA.debugLineNum = 352;BA.debugLine="inappBazar.Initialize(\"inapp\",key)";
mostCurrent._inappbazar.Initialize(processBA,"inapp",mostCurrent._key);
 } 
       catch (Exception e4) {
			processBA.setLastException(e4); //BA.debugLineNum = 355;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("7131081",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 358;BA.debugLine="If(FirstTime=True)Then";
if ((_firsttime==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 359;BA.debugLine="dbCode.cheng_tagvim2";
mostCurrent._dbcode._cheng_tagvim2 /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 360;BA.debugLine="dbCode.check_old_adds";
mostCurrent._dbcode._check_old_adds /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 361;BA.debugLine="dbCode.check_new_add";
mostCurrent._dbcode._check_new_add /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 362;BA.debugLine="dbCode.init_notfound(\"hag_hamsar\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"hag_hamsar",BA.NumberToString(0));
 //BA.debugLineNum = 363;BA.debugLine="dbCode.init_notfound_onvanha(14,\"hamsar\",\"حق تأه";
mostCurrent._dbcode._init_notfound_onvanha /*String*/ (mostCurrent.activityBA,(int) (14),"hamsar","حق تأهل");
 };
 //BA.debugLineNum = 370;BA.debugLine="img1.Initialize(LoadBitmap(File.DirAssets,\"m1.png";
mostCurrent._img1.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m1.png").getObject()));
 //BA.debugLineNum = 371;BA.debugLine="img1.Gravity=Gravity.FILL";
mostCurrent._img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 373;BA.debugLine="img2.Initialize(LoadBitmap(File.DirAssets,\"m2.png";
mostCurrent._img2.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m2.png").getObject()));
 //BA.debugLineNum = 374;BA.debugLine="img2.Gravity=Gravity.FILL";
mostCurrent._img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 376;BA.debugLine="img3.Initialize(LoadBitmap(File.DirAssets,\"m3.png";
mostCurrent._img3.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m3.png").getObject()));
 //BA.debugLineNum = 377;BA.debugLine="img3.Gravity=Gravity.FILL";
mostCurrent._img3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 379;BA.debugLine="If(FirstTime)Then";
if ((_firsttime)) { 
 //BA.debugLineNum = 380;BA.debugLine="Activity.LoadLayout(\"splash_layout\")";
mostCurrent._activity.LoadLayout("splash_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 381;BA.debugLine="lbl_vesion_app.Text=app_vesion";
mostCurrent._lbl_vesion_app.setText(BA.ObjectToCharSequence(_app_vesion));
 //BA.debugLineNum = 382;BA.debugLine="cv_loader.Show";
mostCurrent._cv_loader._show /*String*/ ();
 //BA.debugLineNum = 383;BA.debugLine="timer1.Initialize(\"timer1\" , 1500)";
_timer1.Initialize(processBA,"timer1",(long) (1500));
 //BA.debugLineNum = 385;BA.debugLine="timer1.Enabled=True";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 386;BA.debugLine="is_first_time=True";
_is_first_time = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 388;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 389;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 //BA.debugLineNum = 390;BA.debugLine="is_first_time=False";
_is_first_time = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 395;BA.debugLine="moon.Initialize";
mostCurrent._moon.Initialize();
 //BA.debugLineNum = 396;BA.debugLine="moon.AddAll(Array As String(\"فروردین\", \"اردیبهشت\"";
mostCurrent._moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
 //BA.debugLineNum = 399;BA.debugLine="strfun.Initialize";
mostCurrent._strfun._initialize(processBA);
 //BA.debugLineNum = 403;BA.debugLine="If(buy_index=1)Then";
if ((_buy_index==1)) { 
 //BA.debugLineNum = 404;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 //BA.debugLineNum = 405;BA.debugLine="buy_index=0";
_buy_index = (int) (0);
 };
 //BA.debugLineNum = 411;BA.debugLine="tim_msg.Initialize(\"tim_msg\",4000)";
_tim_msg.Initialize(processBA,"tim_msg",(long) (4000));
 //BA.debugLineNum = 413;BA.debugLine="ls1.Initialize";
mostCurrent._ls1.Initialize();
 //BA.debugLineNum = 414;BA.debugLine="ls2.Initialize";
mostCurrent._ls2.Initialize();
 //BA.debugLineNum = 415;BA.debugLine="ls3.Initialize";
mostCurrent._ls3.Initialize();
 //BA.debugLineNum = 418;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1"))) { 
 //BA.debugLineNum = 419;BA.debugLine="ls1=File.ReadList(File.DirInternal,\"ls1\")";
mostCurrent._ls1 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1");
 //BA.debugLineNum = 420;BA.debugLine="ls2=File.ReadList(File.DirInternal,\"ls2\")";
mostCurrent._ls2 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls2");
 //BA.debugLineNum = 421;BA.debugLine="ls3=File.ReadList(File.DirInternal,\"ls3\")";
mostCurrent._ls3 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls3");
 //BA.debugLineNum = 423;BA.debugLine="last_notif=ls1.Get(ls1.Size-1)";
mostCurrent._last_notif = BA.ObjectToString(mostCurrent._ls1.Get((int) (mostCurrent._ls1.getSize()-1)));
 //BA.debugLineNum = 424;BA.debugLine="is_now_instal=False";
_is_now_instal = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 430;BA.debugLine="If(FirstTime=True)Then";
if ((_firsttime==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 431;BA.debugLine="If(myfunc.check_karid=True)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 432;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
 }else {
 //BA.debugLineNum = 434;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
 };
 };
 //BA.debugLineNum = 453;BA.debugLine="If(File.Exists(File.DirInternal,\"phonNum\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum"))) { 
 //BA.debugLineNum = 454;BA.debugLine="phon_num=File.ReadString(File.DirInternal,\"phonN";
_phon_num = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum");
 };
 //BA.debugLineNum = 457;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc"))) { 
 //BA.debugLineNum = 458;BA.debugLine="Dim ls_user As List";
_ls_user = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 459;BA.debugLine="ls_user.Initialize";
_ls_user.Initialize();
 //BA.debugLineNum = 460;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAcc\"";
_ls_user = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
 //BA.debugLineNum = 461;BA.debugLine="user_nameFamili=ls_user.Get(0)";
_user_namefamili = BA.ObjectToString(_ls_user.Get((int) (0)));
 };
 //BA.debugLineNum = 465;BA.debugLine="If(FirstTime=True)Then";
if ((_firsttime==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 466;BA.debugLine="tim_check_update.Initialize(\"tim_check_update\",9";
_tim_check_update.Initialize(processBA,"tim_check_update",(long) (9000));
 //BA.debugLineNum = 467;BA.debugLine="tim_check_update.Enabled=True";
_tim_check_update.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 470;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
int _result = 0;
 //BA.debugLineNum = 2897;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 2898;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 2899;BA.debugLine="If (pan_all_msgNewYear.Visible=True)Then";
if ((mostCurrent._pan_all_msgnewyear.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2900;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_help.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2903;BA.debugLine="lbl_close_help_Click";
_lbl_close_help_click();
 }else if((mostCurrent._pan_all_setting_date.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2905;BA.debugLine="pan_all_setting_date.Visible=False";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2908;BA.debugLine="If(pan_all2.Visible=True)Then";
if ((mostCurrent._pan_all2.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2909;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 2911;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }else if((mostCurrent._pan_notifi_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2915;BA.debugLine="lbl_close_notif_Click";
_lbl_close_notif_click();
 }else if((_index_page==2 || _index_page==3)) { 
 //BA.debugLineNum = 2917;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 }else if((mostCurrent._pan_all_noskhe.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2919;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
 }else if((mostCurrent._pan_all_litemenu.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2921;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_all_chekupdate.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2923;BA.debugLine="pan_all_chekUpdate.Visible=False";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 2928;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 2929;BA.debugLine="result = Msgbox2(\"آیا قصد خروج دارید؟\", \"خروج\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا قصد خروج دارید؟"),BA.ObjectToCharSequence("خروج"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 2930;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 2931;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 2932;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 };
 };
 //BA.debugLineNum = 2938;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 2940;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 2942;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 997;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 999;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 993;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 995;BA.debugLine="End Sub";
return "";
}
public static String  _add_end() throws Exception{
boolean _chek = false;
anywheresoftware.b4a.objects.collections.List _alist = null;
 //BA.debugLineNum = 2338;BA.debugLine="Sub add_end";
 //BA.debugLineNum = 2339;BA.debugLine="Dim chek As Boolean";
_chek = false;
 //BA.debugLineNum = 2340;BA.debugLine="chek=myfunc.check_karid";
_chek = mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 2341;BA.debugLine="Dim alist As List";
_alist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2342;BA.debugLine="alist.Initialize";
_alist.Initialize();
 //BA.debugLineNum = 2344;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(myfunc";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth())))));
 //BA.debugLineNum = 2347;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(persianDate.Pe";
_alist = mostCurrent._myfunc._num_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear())),_moon_num);
 //BA.debugLineNum = 2350;BA.debugLine="If(index_box=1) Then";
if ((_index_box==1)) { 
 //BA.debugLineNum = 2351;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2352;BA.debugLine="If(alist.Get(0)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (0))))<5)) { 
 //BA.debugLineNum = 2353;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 }else {
 //BA.debugLineNum = 2355;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 2359;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 };
 }else if((_index_box==2)) { 
 //BA.debugLineNum = 2364;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2365;BA.debugLine="If(alist.Get(1)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (1))))<5)) { 
 //BA.debugLineNum = 2366;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 }else {
 //BA.debugLineNum = 2368;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 2371;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 };
 }else if((_index_box==3)) { 
 //BA.debugLineNum = 2376;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2377;BA.debugLine="If(alist.Get(3)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (3))))<5)) { 
 //BA.debugLineNum = 2380;BA.debugLine="Select state_tatil_setting";
switch (_state_tatil_setting) {
case 0: {
 //BA.debugLineNum = 2382;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 break; }
case 1: {
 //BA.debugLineNum = 2384;BA.debugLine="If (state_tatil=1 Or state_tatil=2) Then 'ta";
if ((_state_tatil==1 || _state_tatil==2)) { 
 //BA.debugLineNum = 2385;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
 //BA.debugLineNum = 2387;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 11: {
 //BA.debugLineNum = 2392;BA.debugLine="If (state_tatil=1) Then 'tatil rasmi";
if ((_state_tatil==1)) { 
 //BA.debugLineNum = 2393;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
 //BA.debugLineNum = 2395;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 22: {
 //BA.debugLineNum = 2400;BA.debugLine="If (state_tatil=2) Then  'tatil garardadi";
if ((_state_tatil==2)) { 
 //BA.debugLineNum = 2401;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
 //BA.debugLineNum = 2403;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
}
;
 //BA.debugLineNum = 2410;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2411;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
 };
 }else {
 //BA.debugLineNum = 2415;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 2419;BA.debugLine="Select state_tatil_setting";
switch (_state_tatil_setting) {
case 0: {
 //BA.debugLineNum = 2421;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 break; }
case 1: {
 //BA.debugLineNum = 2423;BA.debugLine="If (state_tatil=1 Or state_tatil=2) Then 'tat";
if ((_state_tatil==1 || _state_tatil==2)) { 
 //BA.debugLineNum = 2424;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
 //BA.debugLineNum = 2426;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 11: {
 //BA.debugLineNum = 2431;BA.debugLine="If (state_tatil=1) Then 'tatil rasmi";
if ((_state_tatil==1)) { 
 //BA.debugLineNum = 2432;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
 //BA.debugLineNum = 2434;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
case 22: {
 //BA.debugLineNum = 2439;BA.debugLine="If (state_tatil=2) Then  'tatil garardadi";
if ((_state_tatil==2)) { 
 //BA.debugLineNum = 2440;BA.debugLine="add_taradod_sub2";
_add_taradod_sub2();
 }else {
 //BA.debugLineNum = 2442;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 break; }
}
;
 //BA.debugLineNum = 2449;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2450;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
 };
 };
 }else if((_index_box==5)) { 
 //BA.debugLineNum = 2458;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2459;BA.debugLine="If(alist.Get(4)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (4))))<5)) { 
 //BA.debugLineNum = 2460;BA.debugLine="add_mamoriat_sub";
_add_mamoriat_sub();
 }else {
 //BA.debugLineNum = 2462;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 2466;BA.debugLine="add_mamoriat_sub";
_add_mamoriat_sub();
 };
 };
 //BA.debugLineNum = 2470;BA.debugLine="End Sub";
return "";
}
public static String  _add_ezafe_sub() throws Exception{
int _state_mod = 0;
String _str_mod = "";
boolean _result_a = false;
 //BA.debugLineNum = 2472;BA.debugLine="Sub add_ezafe_sub";
 //BA.debugLineNum = 2473;BA.debugLine="Dim state_mod As Int=0";
_state_mod = (int) (0);
 //BA.debugLineNum = 2474;BA.debugLine="Dim str_mod As String=\"\"";
_str_mod = "";
 //BA.debugLineNum = 2475;BA.debugLine="If(ckb_ezaf_taradod.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2476;BA.debugLine="state_mod=2";
_state_mod = (int) (2);
 //BA.debugLineNum = 2477;BA.debugLine="str_mod=\" (فوق العاده)- \"";
_str_mod = " (فوق العاده)- ";
 }else {
 //BA.debugLineNum = 2479;BA.debugLine="state_mod=0";
_state_mod = (int) (0);
 };
 //BA.debugLineNum = 2483;BA.debugLine="Try";
try { //BA.debugLineNum = 2485;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 2486;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0 || _day_bt!=0)) { 
 //BA.debugLineNum = 2489;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0)) { 
 //BA.debugLineNum = 2491;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 2495;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2496;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_ezafekari_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2498;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
 //BA.debugLineNum = 2499;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ اضافه کاری وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
 //BA.debugLineNum = 2500;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2501;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Te";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 2504;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2505;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2510;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 2513;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2514;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2518;BA.debugLine="dbCode.edit_ezafekari(current_id_edit,date1,da";
mostCurrent._dbcode._edit_ezafekari /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 2519;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2522;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 //BA.debugLineNum = 2527;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e39) {
			processBA.setLastException(e39); //BA.debugLineNum = 2533;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 2538;BA.debugLine="End Sub";
return "";
}
public static String  _add_mamoriat_sub() throws Exception{
int _state_mod = 0;
String _str_mod = "";
boolean _result_a = false;
 //BA.debugLineNum = 2834;BA.debugLine="Sub add_mamoriat_sub";
 //BA.debugLineNum = 2835;BA.debugLine="Dim state_mod As Int=0";
_state_mod = (int) (0);
 //BA.debugLineNum = 2836;BA.debugLine="Dim str_mod As String=\"\"";
_str_mod = "";
 //BA.debugLineNum = 2845;BA.debugLine="Try";
try { //BA.debugLineNum = 2846;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
if ((_day_bt<0 || _hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 2847;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0)) { 
 //BA.debugLineNum = 2849;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0 && _day_bt==0)) { 
 //BA.debugLineNum = 2851;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 2854;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2855;BA.debugLine="If(dbCode.isexist_mamoriat_by_date(date1)=True";
if ((mostCurrent._dbcode._isexist_mamoriat_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2857;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
 //BA.debugLineNum = 2858;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ مأموریت وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
 //BA.debugLineNum = 2859;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2860;BA.debugLine="dbCode.add_mamoriat(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_mamoriat /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 2862;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2863;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2866;BA.debugLine="dbCode.add_mamoriat(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_mamoriat /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 2868;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2869;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2873;BA.debugLine="dbCode.edit_mamoriat(current_id_edit,date1,dat";
mostCurrent._dbcode._edit_mamoriat /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 2874;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2877;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 //BA.debugLineNum = 2882;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e33) {
			processBA.setLastException(e33); //BA.debugLineNum = 2888;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 2893;BA.debugLine="End Sub";
return "";
}
public static String  _add_morakhasi_sub() throws Exception{
String _str_noe2 = "";
boolean _result_a = false;
 //BA.debugLineNum = 2540;BA.debugLine="Sub add_morakhasi_sub";
 //BA.debugLineNum = 2541;BA.debugLine="Dim str_noe2 As String";
_str_noe2 = "";
 //BA.debugLineNum = 2542;BA.debugLine="str_noe2=\"(\"&str_noe&\")- \"";
_str_noe2 = "("+mostCurrent._str_noe+")- ";
 //BA.debugLineNum = 2544;BA.debugLine="Try";
try { //BA.debugLineNum = 2545;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
if ((_day_bt<0 || _hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 2546;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0)) { 
 //BA.debugLineNum = 2548;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0 && _day_bt==0)) { 
 //BA.debugLineNum = 2550;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 2555;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2556;BA.debugLine="If(dbCode.isexist_morakhasi_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_morakhasi_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2558;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
 //BA.debugLineNum = 2559;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ مرخصی وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
 //BA.debugLineNum = 2560;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2561;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Te";
mostCurrent._dbcode._add_morakhasi /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_noe2+mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
 //BA.debugLineNum = 2562;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2563;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2568;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_morakhasi /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_noe2+mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
 //BA.debugLineNum = 2569;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2570;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2573;BA.debugLine="dbCode.edit_morakhasi(current_id_edit,date1,da";
mostCurrent._dbcode._edit_morakhasi /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
 //BA.debugLineNum = 2575;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2576;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 //BA.debugLineNum = 2583;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e33) {
			processBA.setLastException(e33); //BA.debugLineNum = 2589;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 2594;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 2597;BA.debugLine="Sub add_taradod_sub";
 //BA.debugLineNum = 2598;BA.debugLine="Try";
try { //BA.debugLineNum = 2600;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 2601;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0 || _day_bt>2)) { 
 //BA.debugLineNum = 2604;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0)) { 
 //BA.debugLineNum = 2606;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 2611;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2612;BA.debugLine="If(dbCode.isexist_taradod_by_date(date1)=True)";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2615;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
 //BA.debugLineNum = 2616;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ تردد وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
 //BA.debugLineNum = 2617;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2620;BA.debugLine="Dim str_tozih0 As String=\"(فوق العاده)(تردد";
_str_tozih0 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2621;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_t";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2622;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2624;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_e";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2631;BA.debugLine="Dim tim_ezaf_min As Int=tim_min-(myfunc.get";
_tim_ezaf_min = (int) (_tim_min-(mostCurrent._myfunc._get_saatkari_inweek /*int*/ (mostCurrent.activityBA,_day_inweek_id)));
 //BA.debugLineNum = 2633;BA.debugLine="Dim ls_res_tim1 As List";
_ls_res_tim1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2634;BA.debugLine="ls_res_tim1.Initialize";
_ls_res_tim1.Initialize();
 //BA.debugLineNum = 2635;BA.debugLine="ls_res_tim1=myfunc.find_tim1_taradod(lbl_ti";
_ls_res_tim1 = mostCurrent._myfunc._find_tim1_taradod /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._lbl_tim2.getText(),_tim_ezaf_min);
 //BA.debugLineNum = 2636;BA.debugLine="Dim tim1_saat As String=ls_res_tim1.Get(0)";
_tim1_saat = BA.ObjectToString(_ls_res_tim1.Get((int) (0)));
 //BA.debugLineNum = 2637;BA.debugLine="Dim date1_refind As String=\"\"";
_date1_refind = "";
 //BA.debugLineNum = 2638;BA.debugLine="If(ls_res_tim1.Get(1)=1) Then";
if (((_ls_res_tim1.Get((int) (1))).equals((Object)(1)))) { 
 //BA.debugLineNum = 2639;BA.debugLine="date1_refind=date2";
_date1_refind = mostCurrent._date2;
 }else {
 //BA.debugLineNum = 2641;BA.debugLine="date1_refind=date1";
_date1_refind = mostCurrent._date1;
 };
 //BA.debugLineNum = 2645;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2646;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,ti";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih0,(int) (2));
 }else {
 //BA.debugLineNum = 2648;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,ti";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih1,(int) (0));
 };
 //BA.debugLineNum = 2653;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
 //BA.debugLineNum = 2655;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,mostCurrent._et_tozihat.getText(),(int) (0));
 };
 //BA.debugLineNum = 2662;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2663;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2671;BA.debugLine="Dim str_tozih0 As String=\"(فوق العاده)(تردد د";
_str_tozih0 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2672;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_to";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2673;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-\"";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2676;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_ez";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2680;BA.debugLine="Dim tim_ezaf_min As Int=tim_min-(myfunc.get_";
_tim_ezaf_min = (int) (_tim_min-(mostCurrent._myfunc._get_saatkari_inweek /*int*/ (mostCurrent.activityBA,_day_inweek_id)));
 //BA.debugLineNum = 2683;BA.debugLine="Dim ls_res_tim1 As List";
_ls_res_tim1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2684;BA.debugLine="ls_res_tim1.Initialize";
_ls_res_tim1.Initialize();
 //BA.debugLineNum = 2685;BA.debugLine="ls_res_tim1=myfunc.find_tim1_taradod(lbl_tim";
_ls_res_tim1 = mostCurrent._myfunc._find_tim1_taradod /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._lbl_tim2.getText(),_tim_ezaf_min);
 //BA.debugLineNum = 2686;BA.debugLine="Dim tim1_saat As String=ls_res_tim1.Get(0)";
_tim1_saat = BA.ObjectToString(_ls_res_tim1.Get((int) (0)));
 //BA.debugLineNum = 2687;BA.debugLine="Dim date1_refind As String=\"\"";
_date1_refind = "";
 //BA.debugLineNum = 2688;BA.debugLine="If(ls_res_tim1.Get(1)=1) Then";
if (((_ls_res_tim1.Get((int) (1))).equals((Object)(1)))) { 
 //BA.debugLineNum = 2689;BA.debugLine="date1_refind=date2";
_date1_refind = mostCurrent._date2;
 }else {
 //BA.debugLineNum = 2691;BA.debugLine="date1_refind=date1";
_date1_refind = mostCurrent._date1;
 };
 //BA.debugLineNum = 2695;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2696;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,tim";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih0,(int) (2));
 }else {
 //BA.debugLineNum = 2698;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,tim";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,_date1_refind,mostCurrent._date2,_tim1_saat,mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_ezaf_min,_str_tozih1,(int) (0));
 };
 //BA.debugLineNum = 2702;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
 //BA.debugLineNum = 2704;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,mostCurrent._et_tozihat.getText(),(int) (0));
 };
 //BA.debugLineNum = 2708;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2709;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2712;BA.debugLine="dbCode.edit_taradod(current_id_edit,date1,date";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
 //BA.debugLineNum = 2714;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2715;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 //BA.debugLineNum = 2721;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e77) {
			processBA.setLastException(e77); //BA.debugLineNum = 2727;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 2730;BA.debugLine="End Sub";
return "";
}
public static String  _add_taradod_sub2() throws Exception{
boolean _result_a = false;
String _str_tozih2 = "";
String _str_tozih1 = "";
 //BA.debugLineNum = 2734;BA.debugLine="Sub add_taradod_sub2";
 //BA.debugLineNum = 2735;BA.debugLine="Try";
try { //BA.debugLineNum = 2737;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 2738;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0 || _day_bt>2)) { 
 //BA.debugLineNum = 2741;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0)) { 
 //BA.debugLineNum = 2743;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 2748;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2749;BA.debugLine="If(dbCode.isexist_taradod_by_date(date1)=True)";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2752;BA.debugLine="Dim result_a As Boolean";
_result_a = false;
 //BA.debugLineNum = 2753;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
_result_a = mostCurrent._myfunc._msg_add_edit /*boolean*/ (mostCurrent.activityBA,"توجه","برای این تاریخ تردد وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ");
 //BA.debugLineNum = 2754;BA.debugLine="If (result_a=True)Then";
if ((_result_a==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2756;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2758;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_e";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2760;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2761;BA.debugLine="Dim str_tozih1 As String=\"(فوق العاده)(تر";
_str_tozih1 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2762;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (2));
 }else {
 //BA.debugLineNum = 2764;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&e";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2765;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (0));
 };
 //BA.debugLineNum = 2771;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Te";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
 //BA.debugLineNum = 2773;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 };
 //BA.debugLineNum = 2776;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2777;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2784;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-\"";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2786;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_ez";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2788;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
if ((mostCurrent._radio_ez_fog.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2789;BA.debugLine="Dim str_tozih1 As String=\"(فوق العاده)(تردد";
_str_tozih1 = "(فوق العاده)(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2790;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.T";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (2));
 }else {
 //BA.debugLineNum = 2792;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 2793;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.T";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih1,(int) (0));
 };
 //BA.debugLineNum = 2800;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 }else {
 //BA.debugLineNum = 2803;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),(int) (0),(int) (0),_tim_min,_str_tozih2,(int) (0));
 };
 //BA.debugLineNum = 2806;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2807;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 2812;BA.debugLine="dbCode.edit_taradod(current_id_edit,date1,date";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
 //BA.debugLineNum = 2814;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2815;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 //BA.debugLineNum = 2821;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e55) {
			processBA.setLastException(e55); //BA.debugLineNum = 2827;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 2830;BA.debugLine="End Sub";
return "";
}
public static String  _auth_complete(boolean _success,String _errormessage) throws Exception{
 //BA.debugLineNum = 874;BA.debugLine="Sub Auth_Complete (Success As Boolean, ErrorMessag";
 //BA.debugLineNum = 875;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 876;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 877;BA.debugLine="tim_lock_lbl.Enabled=False";
_tim_lock_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 879;BA.debugLine="ToastMessageShow($\"Error: ${ErrorMessage}\"$, Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(("Error: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_errormessage))+"")),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 880;BA.debugLine="Log(ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("71179654",_errormessage,0);
 };
 //BA.debugLineNum = 882;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_gozaresh_click() throws Exception{
 //BA.debugLineNum = 1682;BA.debugLine="Private Sub btn_menu_gozaresh_Click";
 //BA.debugLineNum = 1683;BA.debugLine="index_page=3";
_index_page = (int) (3);
 //BA.debugLineNum = 1684;BA.debugLine="pan_imag.Background=img3";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img3.getObject()));
 //BA.debugLineNum = 1686;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
 //BA.debugLineNum = 1687;BA.debugLine="pan_main.LoadLayout(\"gozaresh_layout\")";
mostCurrent._pan_main.LoadLayout("gozaresh_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 1689;BA.debugLine="sp_year_gozaresh.Add(\"1403\")";
mostCurrent._sp_year_gozaresh.Add("1403");
 //BA.debugLineNum = 1690;BA.debugLine="sp_year_gozaresh.Add(\"1402\")";
mostCurrent._sp_year_gozaresh.Add("1402");
 //BA.debugLineNum = 1691;BA.debugLine="sp_year_gozaresh.Add(\"1401\")";
mostCurrent._sp_year_gozaresh.Add("1401");
 //BA.debugLineNum = 1692;BA.debugLine="sp_year_gozaresh.Add(\"1400\")";
mostCurrent._sp_year_gozaresh.Add("1400");
 //BA.debugLineNum = 1693;BA.debugLine="sp_year_gozaresh.Add(\"1399\")";
mostCurrent._sp_year_gozaresh.Add("1399");
 //BA.debugLineNum = 1694;BA.debugLine="sp_year_gozaresh.Add(\"1398\")";
mostCurrent._sp_year_gozaresh.Add("1398");
 //BA.debugLineNum = 1696;BA.debugLine="sp_year_gozaresh.SelectedIndex=0";
mostCurrent._sp_year_gozaresh.setSelectedIndex((int) (0));
 //BA.debugLineNum = 1701;BA.debugLine="pan_hed_gozaresh.Color=color4";
mostCurrent._pan_hed_gozaresh.setColor(_color4);
 //BA.debugLineNum = 1706;BA.debugLine="list_gozareshat_id.Initialize";
mostCurrent._list_gozareshat_id.Initialize();
 //BA.debugLineNum = 1709;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
 //BA.debugLineNum = 1711;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 1002;BA.debugLine="Private Sub btn_menu_home_Click";
 //BA.debugLineNum = 1003;BA.debugLine="index_page=1";
_index_page = (int) (1);
 //BA.debugLineNum = 1004;BA.debugLine="pan_imag.Background=img1";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img1.getObject()));
 //BA.debugLineNum = 1006;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
 //BA.debugLineNum = 1008;BA.debugLine="pan_main.LoadLayout(\"home_layout\")";
mostCurrent._pan_main.LoadLayout("home_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 1009;BA.debugLine="scv_home_item.Panel.LoadLayout(\"home_item\")";
mostCurrent._scv_home_item.getPanel().LoadLayout("home_item",mostCurrent.activityBA);
 //BA.debugLineNum = 1014;BA.debugLine="lbl_date_home.Text=myfunc.fa2en(persianDate.Persi";
mostCurrent._lbl_date_home.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianLongDate())));
 //BA.debugLineNum = 1016;BA.debugLine="saat_kar_min =dbCode.get_setting_byName(\"saat_kar";
_saat_kar_min = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_darRoz")));
 //BA.debugLineNum = 1018;BA.debugLine="If(saat_kar_min<18)Then";
if ((_saat_kar_min<18)) { 
 //BA.debugLineNum = 1019;BA.debugLine="myfunc.help_man(\"توجه\",\"لطفا ساعت کاری خود را در";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","لطفا ساعت کاری خود را در صفحه ثبت اطلاعات حقوق تنظیم کنید");
 };
 //BA.debugLineNum = 1022;BA.debugLine="Dim list_ezafekari As List";
_list_ezafekari = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1023;BA.debugLine="list_ezafekari.Initialize";
_list_ezafekari.Initialize();
 //BA.debugLineNum = 1025;BA.debugLine="year_num=myfunc.fa2en(persianDate.PersianYear)";
_year_num = mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()));
 //BA.debugLineNum = 1027;BA.debugLine="moon_num=myfunc.convert_adad(persianDate.PersianM";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_persiandate.getPersianMonth());
 //BA.debugLineNum = 1029;BA.debugLine="list_ezafekari=dbCode.all_ezafekari_mah(year_num,";
_list_ezafekari = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num,(int) (1));
 //BA.debugLineNum = 1035;BA.debugLine="Dim list_morakhasi As List";
_list_morakhasi = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1036;BA.debugLine="list_morakhasi.Initialize";
_list_morakhasi.Initialize();
 //BA.debugLineNum = 1038;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(year_num,";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num);
 //BA.debugLineNum = 1041;BA.debugLine="lbl_ezafekari_mah_m.Text=list_ezafekari.Get(1)&\"";
mostCurrent._lbl_ezafekari_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (1)))+" دقیقه "));
 //BA.debugLineNum = 1042;BA.debugLine="lbl_ezafekari_mah_h.Text=list_ezafekari.Get(0)&\"";
mostCurrent._lbl_ezafekari_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (0)))+" ساعت "));
 //BA.debugLineNum = 1044;BA.debugLine="lbl_morakhasi_mah_m.Text=list_morakhasi.Get(2)&\"";
mostCurrent._lbl_morakhasi_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (2)))+" دقیقه "));
 //BA.debugLineNum = 1045;BA.debugLine="lbl_morakhasi_mah_h.Text=list_morakhasi.Get(1)&\"";
mostCurrent._lbl_morakhasi_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (1)))+" ساعت "));
 //BA.debugLineNum = 1046;BA.debugLine="lbl_morakhasi_mah_d.Text=list_morakhasi.Get(0)&\"";
mostCurrent._lbl_morakhasi_mah_d.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (0)))+" روز "));
 //BA.debugLineNum = 1048;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 1050;BA.debugLine="lbl_vip.TextColor=0xFFFFD800";
mostCurrent._lbl_vip.setTextColor(((int)0xffffd800));
 //BA.debugLineNum = 1051;BA.debugLine="lbl_vip2.Text=\"نسخه طلایی\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه طلایی"));
 }else {
 //BA.debugLineNum = 1054;BA.debugLine="lbl_vip.TextColor=Colors.Green";
mostCurrent._lbl_vip.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 1055;BA.debugLine="lbl_vip2.Text=\"نسخه هدیه\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه هدیه"));
 };
 //BA.debugLineNum = 1060;BA.debugLine="If (File.Exists(File.DirInternal,\"help_start\")=Fa";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1061;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 1062;BA.debugLine="File.WriteString(File.DirInternal,\"help_start\",\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start","");
 };
 //BA.debugLineNum = 1068;BA.debugLine="If (File.Exists(File.DirInternal,\"setcolor.txt\"))";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt"))) { 
 //BA.debugLineNum = 1069;BA.debugLine="Dim list_color As List";
_list_color = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1070;BA.debugLine="list_color.Initialize";
_list_color.Initialize();
 //BA.debugLineNum = 1071;BA.debugLine="list_color = File.ReadList(File.DirInternal,\"set";
_list_color = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt");
 //BA.debugLineNum = 1073;BA.debugLine="Dim col As List";
_col = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1074;BA.debugLine="col.Initialize";
_col.Initialize();
 //BA.debugLineNum = 1076;BA.debugLine="Dim col_font As List";
_col_font = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1077;BA.debugLine="col_font.Initialize";
_col_font.Initialize();
 //BA.debugLineNum = 1079;BA.debugLine="col=Regex.Split(\",\",list_color.Get(0))";
_col = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (0)))));
 //BA.debugLineNum = 1080;BA.debugLine="col_font=Regex.Split(\",\",list_color.Get(1))";
_col_font = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (1)))));
 //BA.debugLineNum = 1084;BA.debugLine="color1= col.Get(0)";
_color1 = (int)(BA.ObjectToNumber(_col.Get((int) (0))));
 //BA.debugLineNum = 1085;BA.debugLine="color2= col.Get(1)";
_color2 = (int)(BA.ObjectToNumber(_col.Get((int) (1))));
 //BA.debugLineNum = 1086;BA.debugLine="color_index=col.Get(2)  'index color";
_color_index = (int)(BA.ObjectToNumber(_col.Get((int) (2))));
 //BA.debugLineNum = 1087;BA.debugLine="color3= col.Get(3)";
_color3 = (int)(BA.ObjectToNumber(_col.Get((int) (3))));
 //BA.debugLineNum = 1088;BA.debugLine="color4= col.Get(4)";
_color4 = (int)(BA.ObjectToNumber(_col.Get((int) (4))));
 //BA.debugLineNum = 1089;BA.debugLine="color5= col.Get(5)";
_color5 = (int)(BA.ObjectToNumber(_col.Get((int) (5))));
 //BA.debugLineNum = 1091;BA.debugLine="main_font=col_font.Get(0)";
_main_font = BA.ObjectToString(_col_font.Get((int) (0)));
 //BA.debugLineNum = 1092;BA.debugLine="size_f1=col_font.Get(1)";
_size_f1 = (int)(BA.ObjectToNumber(_col_font.Get((int) (1))));
 //BA.debugLineNum = 1093;BA.debugLine="size_f2=col_font.Get(2)";
_size_f2 = (int)(BA.ObjectToNumber(_col_font.Get((int) (2))));
 //BA.debugLineNum = 1094;BA.debugLine="size_f3=col_font.Get(3)";
_size_f3 = (int)(BA.ObjectToNumber(_col_font.Get((int) (3))));
 }else {
 //BA.debugLineNum = 1098;BA.debugLine="color_index=1";
_color_index = (int) (1);
 //BA.debugLineNum = 1099;BA.debugLine="color1= 0XFF69AC00";
_color1 = ((int)0xff69ac00);
 //BA.debugLineNum = 1100;BA.debugLine="color2= 0xFF00C7C7";
_color2 = ((int)0xff00c7c7);
 //BA.debugLineNum = 1101;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 1102;BA.debugLine="color4=0XFF69AC00";
_color4 = ((int)0xff69ac00);
 //BA.debugLineNum = 1103;BA.debugLine="color5=0XFF69AC00";
_color5 = ((int)0xff69ac00);
 //BA.debugLineNum = 1105;BA.debugLine="main_font=\"یکان\"";
_main_font = "یکان";
 //BA.debugLineNum = 1106;BA.debugLine="size_f1=17";
_size_f1 = (int) (17);
 //BA.debugLineNum = 1107;BA.debugLine="size_f2=15";
_size_f2 = (int) (15);
 //BA.debugLineNum = 1108;BA.debugLine="size_f3=13";
_size_f3 = (int) (13);
 //BA.debugLineNum = 1111;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(_color1)+","+BA.NumberToString(_color2)+","+BA.NumberToString(_color_index)+","+BA.NumberToString(_color3)+","+BA.NumberToString(_color4)+","+BA.NumberToString(_color5)+anywheresoftware.b4a.keywords.Common.CRLF+_main_font+","+BA.NumberToString(_size_f1)+","+BA.NumberToString(_size_f2)+","+BA.NumberToString(_size_f3));
 };
 //BA.debugLineNum = 1119;BA.debugLine="Dim dw As GradientDrawable";
_dw = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
 //BA.debugLineNum = 1120;BA.debugLine="Dim clr() As Int = Array  As Int(color1,color2)";
_clr = new int[]{_color1,_color2};
 //BA.debugLineNum = 1121;BA.debugLine="dw.Initialize(\"TOP_BOTTOM\",clr)";
_dw.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clr);
 //BA.debugLineNum = 1122;BA.debugLine="dw.CornerRadius=50dip";
_dw.setCornerRadius((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))));
 //BA.debugLineNum = 1123;BA.debugLine="Panel1.Background=dw";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_dw.getObject()));
 //BA.debugLineNum = 1131;BA.debugLine="lbl_box_title.Color=color4";
mostCurrent._lbl_box_title.setColor(_color4);
 //BA.debugLineNum = 1140;BA.debugLine="get_today_shift";
_get_today_shift();
 //BA.debugLineNum = 1147;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 1150;BA.debugLine="If(is_first_time=True)Then";
if ((_is_first_time==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1151;BA.debugLine="chek_time_backup";
_chek_time_backup();
 };
 //BA.debugLineNum = 1155;BA.debugLine="If(is_new_msg=True And is_first_time=True)Then";
if ((_is_new_msg==anywheresoftware.b4a.keywords.Common.True && _is_first_time==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1156;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 1157;BA.debugLine="result = Msgbox2(\"آیا الان مشاهده میکنید؟\", \"پیا";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا الان مشاهده میکنید؟"),BA.ObjectToCharSequence("پیام جدید"),"بله","بعدا","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"notif.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 1158;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 1159;BA.debugLine="lbl_account_Click";
_lbl_account_click();
 //BA.debugLineNum = 1160;BA.debugLine="msg_page_show=1";
_msg_page_show = (int) (1);
 };
 //BA.debugLineNum = 1162;BA.debugLine="is_first_time=False";
_is_first_time = anywheresoftware.b4a.keywords.Common.False;
 }else if((_is_time_backup==anywheresoftware.b4a.keywords.Common.True && _is_first_time==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1164;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 1165;BA.debugLine="result = Msgbox2(\"پشتیبان گیری از داده ها انجام";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("پشتیبان گیری از داده ها انجام گردد؟"),BA.ObjectToCharSequence("یاد آور پشتیبان گیری"),"بله","بعدا","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"notif.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 1166;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 1167;BA.debugLine="lbl_account_Click";
_lbl_account_click();
 //BA.debugLineNum = 1168;BA.debugLine="backup_page_show=1";
_backup_page_show = (int) (1);
 };
 //BA.debugLineNum = 1171;BA.debugLine="is_first_time=False";
_is_first_time = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1178;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_list_click() throws Exception{
 //BA.debugLineNum = 1253;BA.debugLine="Private Sub btn_menu_list_Click";
 //BA.debugLineNum = 1254;BA.debugLine="index_page=2";
_index_page = (int) (2);
 //BA.debugLineNum = 1255;BA.debugLine="pan_imag.Background=img2";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img2.getObject()));
 //BA.debugLineNum = 1257;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
 //BA.debugLineNum = 1258;BA.debugLine="pan_main.LoadLayout(\"list_layout\")";
mostCurrent._pan_main.LoadLayout("list_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 1260;BA.debugLine="sp_year.Add(\"1403\")";
mostCurrent._sp_year.Add("1403");
 //BA.debugLineNum = 1261;BA.debugLine="sp_year.Add(\"1402\")";
mostCurrent._sp_year.Add("1402");
 //BA.debugLineNum = 1262;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
 //BA.debugLineNum = 1263;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
 //BA.debugLineNum = 1264;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
 //BA.debugLineNum = 1265;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
 //BA.debugLineNum = 1267;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
 //BA.debugLineNum = 1270;BA.debugLine="sp_year.SelectedIndex=0";
mostCurrent._sp_year.setSelectedIndex((int) (0));
 //BA.debugLineNum = 1271;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(persianDate.Pe";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))))-1));
 //BA.debugLineNum = 1273;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(sp_moo";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
 //BA.debugLineNum = 1276;BA.debugLine="TabHost1.AddTab(\"اضافه کاری\" , \"tab_layout_ezafek";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"اضافه کاری","tab_layout_ezafekari.bal");
 //BA.debugLineNum = 1277;BA.debugLine="TabHost1.AddTab(\"مرخصی\" , \"tab_layout_morakhasi.b";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"مرخصی","tab_layout_morakhasi.bal");
 //BA.debugLineNum = 1278;BA.debugLine="TabHost1.AddTab(\"تردد\" , \"tab_layout_taradod.bal\"";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"تردد","tab_layout_taradod.bal");
 //BA.debugLineNum = 1279;BA.debugLine="TabHost1.AddTab(\"مأموریت\" , \"tab_layout_mamoriat.";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"مأموریت","tab_layout_mamoriat.bal");
 //BA.debugLineNum = 1281;BA.debugLine="TabHost1.CurrentTab=curent_tab_list";
mostCurrent._tabhost1.setCurrentTab(_curent_tab_list);
 //BA.debugLineNum = 1283;BA.debugLine="list_ezafekari_id.Initialize";
mostCurrent._list_ezafekari_id.Initialize();
 //BA.debugLineNum = 1286;BA.debugLine="list_morakhasi_id.Initialize";
mostCurrent._list_morakhasi_id.Initialize();
 //BA.debugLineNum = 1289;BA.debugLine="list_taradod_id.Initialize";
mostCurrent._list_taradod_id.Initialize();
 //BA.debugLineNum = 1292;BA.debugLine="list_mamoriat_id.Initialize";
mostCurrent._list_mamoriat_id.Initialize();
 //BA.debugLineNum = 1296;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
 //BA.debugLineNum = 1300;BA.debugLine="pan_hed_list.Color=color4";
mostCurrent._pan_hed_list.setColor(_color4);
 //BA.debugLineNum = 1307;BA.debugLine="End Sub";
return "";
}
public static String  _btneight_click() throws Exception{
 //BA.debugLineNum = 917;BA.debugLine="Sub btnEight_Click";
 //BA.debugLineNum = 918;BA.debugLine="click_count_Increment_and_fill(btnEight.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btneight.getText());
 //BA.debugLineNum = 919;BA.debugLine="End Sub";
return "";
}
public static String  _btnfive_click() throws Exception{
 //BA.debugLineNum = 905;BA.debugLine="Sub btnFive_Click";
 //BA.debugLineNum = 906;BA.debugLine="click_count_Increment_and_fill(btnFive.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnfive.getText());
 //BA.debugLineNum = 907;BA.debugLine="End Sub";
return "";
}
public static String  _btnfour_click() throws Exception{
 //BA.debugLineNum = 901;BA.debugLine="Sub btnFour_Click";
 //BA.debugLineNum = 902;BA.debugLine="click_count_Increment_and_fill(btnFour.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnfour.getText());
 //BA.debugLineNum = 903;BA.debugLine="End Sub";
return "";
}
public static String  _btnnine_click() throws Exception{
 //BA.debugLineNum = 921;BA.debugLine="Sub btnNine_Click";
 //BA.debugLineNum = 922;BA.debugLine="click_count_Increment_and_fill(btnNine.Text) 'fil";
_click_count_increment_and_fill(mostCurrent._btnnine.getText());
 //BA.debugLineNum = 923;BA.debugLine="End Sub";
return "";
}
public static String  _btnone_click() throws Exception{
 //BA.debugLineNum = 889;BA.debugLine="Sub btnOne_Click";
 //BA.debugLineNum = 890;BA.debugLine="click_count_Increment_and_fill(btnOne.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btnone.getText());
 //BA.debugLineNum = 891;BA.debugLine="End Sub";
return "";
}
public static String  _btnseven_click() throws Exception{
 //BA.debugLineNum = 913;BA.debugLine="Sub btnSeven_Click";
 //BA.debugLineNum = 914;BA.debugLine="click_count_Increment_and_fill(btnSeven.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btnseven.getText());
 //BA.debugLineNum = 915;BA.debugLine="End Sub";
return "";
}
public static String  _btnsix_click() throws Exception{
 //BA.debugLineNum = 909;BA.debugLine="Sub btnSix_Click";
 //BA.debugLineNum = 910;BA.debugLine="click_count_Increment_and_fill(btnSix.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btnsix.getText());
 //BA.debugLineNum = 911;BA.debugLine="End Sub";
return "";
}
public static String  _btnthree_click() throws Exception{
 //BA.debugLineNum = 897;BA.debugLine="Sub btnThree_Click";
 //BA.debugLineNum = 898;BA.debugLine="click_count_Increment_and_fill(btnThree.Text) 'fi";
_click_count_increment_and_fill(mostCurrent._btnthree.getText());
 //BA.debugLineNum = 899;BA.debugLine="End Sub";
return "";
}
public static String  _btntwo_click() throws Exception{
 //BA.debugLineNum = 893;BA.debugLine="Sub btnTwo_Click";
 //BA.debugLineNum = 894;BA.debugLine="click_count_Increment_and_fill(btnTwo.Text) 'fill";
_click_count_increment_and_fill(mostCurrent._btntwo.getText());
 //BA.debugLineNum = 895;BA.debugLine="End Sub";
return "";
}
public static String  _btnzero_click() throws Exception{
 //BA.debugLineNum = 885;BA.debugLine="Sub btnZero_Click";
 //BA.debugLineNum = 886;BA.debugLine="click_count_Increment_and_fill(btnZero.Text)";
_click_count_increment_and_fill(mostCurrent._btnzero.getText());
 //BA.debugLineNum = 887;BA.debugLine="End Sub";
return "";
}
public static int  _chek_tatil_day(int _year1,int _moon1,int _day1) throws Exception{
int _id_thisday = 0;
int _result_int = 0;
 //BA.debugLineNum = 3737;BA.debugLine="Sub chek_tatil_day (year1 As Int,moon1 As Int, day";
 //BA.debugLineNum = 3739;BA.debugLine="Dim id_thisDay As Int";
_id_thisday = 0;
 //BA.debugLineNum = 3740;BA.debugLine="id_thisDay=dbCode.get_day_id(year1,moon1,day1)";
_id_thisday = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_year1,_moon1,_day1);
 //BA.debugLineNum = 3742;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 3743;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id_thisday))));
 //BA.debugLineNum = 3745;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 3748;BA.debugLine="Dim result_int As Int=0";
_result_int = (int) (0);
 //BA.debugLineNum = 3749;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil"))) { 
 //BA.debugLineNum = 3750;BA.debugLine="result_int=1";
_result_int = (int) (1);
 }else if(((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state")).equals("tatil1"))) { 
 //BA.debugLineNum = 3752;BA.debugLine="result_int=2";
_result_int = (int) (2);
 };
 //BA.debugLineNum = 3759;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 3760;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 3763;BA.debugLine="Return result_int    ' result_int=0 is not tatil";
if (true) return _result_int;
 //BA.debugLineNum = 3765;BA.debugLine="End Sub";
return 0;
}
public static int  _chek_tatil_setting() throws Exception{
int _temp = 0;
int _sett_a = 0;
int _sett_b = 0;
 //BA.debugLineNum = 3767;BA.debugLine="Sub chek_tatil_setting As Int";
 //BA.debugLineNum = 3768;BA.debugLine="Dim temp As Int=0";
_temp = (int) (0);
 //BA.debugLineNum = 3769;BA.debugLine="Dim sett_a ,sett_b  As Int=0";
_sett_a = 0;
_sett_b = (int) (0);
 //BA.debugLineNum = 3771;BA.debugLine="sett_a=dbCode.get_setting_byName(\"setting_tatil_r";
_sett_a = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi")));
 //BA.debugLineNum = 3772;BA.debugLine="sett_b=dbCode.get_setting_byName(\"setting_tatil_g";
_sett_b = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi")));
 //BA.debugLineNum = 3775;BA.debugLine="If(sett_a=1)Then";
if ((_sett_a==1)) { 
 //BA.debugLineNum = 3776;BA.debugLine="temp=11";
_temp = (int) (11);
 //BA.debugLineNum = 3777;BA.debugLine="If (sett_b=1)Then";
if ((_sett_b==1)) { 
 //BA.debugLineNum = 3778;BA.debugLine="temp=1";
_temp = (int) (1);
 };
 }else {
 //BA.debugLineNum = 3782;BA.debugLine="temp=0";
_temp = (int) (0);
 //BA.debugLineNum = 3783;BA.debugLine="If (sett_b=1)Then";
if ((_sett_b==1)) { 
 //BA.debugLineNum = 3784;BA.debugLine="temp=22";
_temp = (int) (22);
 };
 };
 //BA.debugLineNum = 3789;BA.debugLine="Return temp";
if (true) return _temp;
 //BA.debugLineNum = 3791;BA.debugLine="End Sub";
return 0;
}
public static String  _chek_time_backup() throws Exception{
String _tim1_ck_backup = "";
String _tim2_ck_backup = "";
long _time_between = 0L;
int _days_for_backup = 0;
int _res_backup = 0;
 //BA.debugLineNum = 1180;BA.debugLine="Sub chek_time_backup";
 //BA.debugLineNum = 1184;BA.debugLine="If(File.Exists(File.DirInternal,\"chk_backup.txt\")";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"chk_backup.txt")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1185;BA.debugLine="File.WriteString(File.DirInternal,\"chk_backup.tx";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"chk_backup.txt",mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 }else {
 //BA.debugLineNum = 1188;BA.debugLine="Dim tim1_ck_backup As String=File.ReadString(Fil";
_tim1_ck_backup = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"chk_backup.txt");
 //BA.debugLineNum = 1189;BA.debugLine="Dim tim2_ck_backup As String=myfunc.fa2en(DateTi";
_tim2_ck_backup = mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 //BA.debugLineNum = 1190;BA.debugLine="Dim time_between As Long = persianDate.Calculate";
_time_between = _persiandate.CalculateDaysBetween(_tim1_ck_backup,_tim2_ck_backup);
 //BA.debugLineNum = 1192;BA.debugLine="Dim days_for_backup As Int";
_days_for_backup = 0;
 //BA.debugLineNum = 1193;BA.debugLine="Dim res_backup As Int = dbCode.get_setting_byNam";
_res_backup = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"backup_online")));
 //BA.debugLineNum = 1194;BA.debugLine="Select res_backup";
switch (_res_backup) {
case 0: {
 //BA.debugLineNum = 1196;BA.debugLine="days_for_backup=7";
_days_for_backup = (int) (7);
 break; }
case 1: {
 //BA.debugLineNum = 1198;BA.debugLine="days_for_backup=14";
_days_for_backup = (int) (14);
 break; }
case 2: {
 //BA.debugLineNum = 1200;BA.debugLine="days_for_backup=30";
_days_for_backup = (int) (30);
 break; }
case 3: {
 //BA.debugLineNum = 1202;BA.debugLine="days_for_backup=-1";
_days_for_backup = (int) (-1);
 break; }
}
;
 //BA.debugLineNum = 1208;BA.debugLine="If(days_for_backup<0)Then";
if ((_days_for_backup<0)) { 
 //BA.debugLineNum = 1209;BA.debugLine="is_time_backup=False";
_is_time_backup = anywheresoftware.b4a.keywords.Common.False;
 }else if((_time_between>=_days_for_backup)) { 
 //BA.debugLineNum = 1211;BA.debugLine="is_time_backup=True";
_is_time_backup = anywheresoftware.b4a.keywords.Common.True;
 };
 };
 //BA.debugLineNum = 1218;BA.debugLine="End Sub";
return "";
}
public static String  _chk_update_auto() throws Exception{
String _send2 = "";
 //BA.debugLineNum = 4408;BA.debugLine="Sub chk_update_auto";
 //BA.debugLineNum = 4410;BA.debugLine="user_request_update=False";
_user_request_update = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 4411;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 4413;BA.debugLine="ht.Initialize(\"chkupdate\",Me)";
mostCurrent._ht._initialize /*String*/ (processBA,"chkupdate",main.getObject());
 //BA.debugLineNum = 4414;BA.debugLine="Dim send2 As String";
_send2 = "";
 //BA.debugLineNum = 4415;BA.debugLine="send2 = \"var=checkupdate\"";
_send2 = "var=checkupdate";
 //BA.debugLineNum = 4416;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/chek_upda";
mostCurrent._ht._poststring /*String*/ ("https://taravatgroup.ir/chek_update.php",_send2);
 };
 //BA.debugLineNum = 4419;BA.debugLine="End Sub";
return "";
}
public static String  _ckb_ezaf_taradod_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 4495;BA.debugLine="Private Sub ckb_ezaf_taradod_CheckedChange(Checked";
 //BA.debugLineNum = 4496;BA.debugLine="If(Checked=True)Then";
if ((_checked==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 4497;BA.debugLine="radio_ez_adi.Enabled=True";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 4498;BA.debugLine="radio_ez_fog.Enabled=True";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 4500;BA.debugLine="radio_ez_adi.Enabled=False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4501;BA.debugLine="radio_ez_fog.Enabled=False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 4503;BA.debugLine="End Sub";
return "";
}
public static String  _ckb_ezaf_taradod_fs_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 4953;BA.debugLine="Private Sub ckb_ezaf_taradod_fs_CheckedChange(Chec";
 //BA.debugLineNum = 4954;BA.debugLine="If(Checked=True)Then";
if ((_checked==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 4955;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 4957;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 4959;BA.debugLine="End Sub";
return "";
}
public static String  _click_count_increment_and_fill(String _input_text) throws Exception{
 //BA.debugLineNum = 925;BA.debugLine="Sub click_count_Increment_and_fill (input_Text As";
 //BA.debugLineNum = 927;BA.debugLine="Click_Count = Click_Count + 1";
_click_count = (int) (_click_count+1);
 //BA.debugLineNum = 929;BA.debugLine="Select Click_Count";
switch (_click_count) {
case 1: {
 //BA.debugLineNum = 931;BA.debugLine="key1.Color = Colors.Red";
mostCurrent._key1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 934;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 2: {
 //BA.debugLineNum = 937;BA.debugLine="key2.Color = Colors.Red";
mostCurrent._key2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 940;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 3: {
 //BA.debugLineNum = 943;BA.debugLine="key3.Color = Colors.Red";
mostCurrent._key3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 946;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 break; }
case 4: {
 //BA.debugLineNum = 949;BA.debugLine="key4.Color = Colors.Red";
mostCurrent._key4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 952;BA.debugLine="entered_Password = entered_Password & input_Tex";
mostCurrent._entered_password = mostCurrent._entered_password+_input_text;
 //BA.debugLineNum = 958;BA.debugLine="If entered_Password = Master_Password Then";
if ((mostCurrent._entered_password).equals(mostCurrent._master_password)) { 
 //BA.debugLineNum = 961;BA.debugLine="resetting_all";
_resetting_all();
 //BA.debugLineNum = 963;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 965;BA.debugLine="ToastMessageShow(\"رمز عبور اشتباه است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("رمز عبور اشتباه است"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 969;BA.debugLine="resetting_all";
_resetting_all();
 };
 break; }
}
;
 //BA.debugLineNum = 974;BA.debugLine="End Sub";
return "";
}
public static String  _cust_lv_taradod_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 4250;BA.debugLine="Private Sub cust_LV_taradod_ItemClick (Index As In";
 //BA.debugLineNum = 4252;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_gozareshat(String _year1) throws Exception{
 //BA.debugLineNum = 1713;BA.debugLine="Sub fill_list_gozareshat(year1 As String)";
 //BA.debugLineNum = 1714;BA.debugLine="CLV_gozaresh.Clear";
mostCurrent._clv_gozaresh._clear();
 //BA.debugLineNum = 1715;BA.debugLine="list_gozareshat_id.Clear";
mostCurrent._list_gozareshat_id.Clear();
 //BA.debugLineNum = 1717;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1718;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ORDER BY  id DESC;")));
 //BA.debugLineNum = 1719;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1722;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"");
 //BA.debugLineNum = 1723;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 96%x, 114dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (114)));
 //BA.debugLineNum = 1724;BA.debugLine="p.LoadLayout(\"item_list_2\")";
mostCurrent._p.LoadLayout("item_list_2",mostCurrent.activityBA);
 //BA.debugLineNum = 1726;BA.debugLine="CLV_gozaresh.Add(p,dbCode.res.GetString(\"id\"))";
mostCurrent._clv_gozaresh._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1727;BA.debugLine="lbl_dateGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_dategozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date")));
 //BA.debugLineNum = 1728;BA.debugLine="lbl_nameGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_namegozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title")));
 //BA.debugLineNum = 1729;BA.debugLine="lbl_tozihGozaresh_CLV.Text=dbCode.res.GetString(";
mostCurrent._lbl_tozihgozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozih")));
 //BA.debugLineNum = 1730;BA.debugLine="lbl_remove_from_list2.Tag=dbCode.res.GetString(\"";
mostCurrent._lbl_remove_from_list2.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1731;BA.debugLine="pan_item_gozaresh.Tag=dbCode.res.GetString(\"id\")";
mostCurrent._pan_item_gozaresh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1732;BA.debugLine="list_gozareshat_id.Add(dbCode.res.GetString(\"id\"";
mostCurrent._list_gozareshat_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1733;BA.debugLine="Log(dbCode.res.GetString(\"id\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("72621460",mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id"),0);
 }
;
 //BA.debugLineNum = 1735;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1736;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1738;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 1353;BA.debugLine="Sub fill_lists (year1 As String, moon1 As String)";
 //BA.debugLineNum = 1356;BA.debugLine="cust_LV_ezafekari.Clear";
mostCurrent._cust_lv_ezafekari._clear();
 //BA.debugLineNum = 1357;BA.debugLine="list_ezafekari_id.Clear";
mostCurrent._list_ezafekari_id.Clear();
 //BA.debugLineNum = 1359;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1360;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
 //BA.debugLineNum = 1361;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1362;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1363;BA.debugLine="str1.Initialize";
_str1.Initialize();
 //BA.debugLineNum = 1367;BA.debugLine="Dim ls_ezafe As List";
_ls_ezafe = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1368;BA.debugLine="ls_ezafe.Initialize";
_ls_ezafe.Initialize();
 //BA.debugLineNum = 1370;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz2_dontDay(dbCod";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 //BA.debugLineNum = 1372;BA.debugLine="If((ls_ezafe.Get(0))<>0)Then";
if ((((_ls_ezafe.Get((int) (0)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1373;BA.debugLine="str1.Append(ls_ezafe.Get(0)&\" ساعت \")";
_str1.Append(BA.ObjectToString(_ls_ezafe.Get((int) (0)))+" ساعت ");
 //BA.debugLineNum = 1374;BA.debugLine="If((ls_ezafe.Get(1))<>0)Then";
if ((((_ls_ezafe.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1375;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
 //BA.debugLineNum = 1378;BA.debugLine="If((ls_ezafe.Get(1))<>0)Then";
if ((((_ls_ezafe.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1379;BA.debugLine="str1.Append(ls_ezafe.Get(1)&\" دقیقه \")";
_str1.Append(BA.ObjectToString(_ls_ezafe.Get((int) (1)))+" دقیقه ");
 };
 //BA.debugLineNum = 1383;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1384;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
 //BA.debugLineNum = 1385;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
 //BA.debugLineNum = 1387;BA.debugLine="cust_LV_ezafekari.Add(p,dbCode.res.GetString(\"id";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1389;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
 //BA.debugLineNum = 1392;BA.debugLine="lbl_date_CLV.Text=\"از : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("از : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
 //BA.debugLineNum = 1393;BA.debugLine="lbl_hour_CLV.Text=\"تا : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("تا : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
 //BA.debugLineNum = 1396;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str1.ToString()));
 //BA.debugLineNum = 1397;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 1398;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1399;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1401;BA.debugLine="list_ezafekari_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_ezafekari_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
 //BA.debugLineNum = 1406;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1407;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1409;BA.debugLine="If(cust_LV_ezafekari.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_ezafekari._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 1410;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1411;BA.debugLine="Select cust_LV_ezafekari.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_ezafekari._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 1413;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
 //BA.debugLineNum = 1415;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 1417;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 1419;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 1421;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 1423;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 1425;BA.debugLine="cust_LV_ezafekari.Add(p,\"\")";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(""));
 };
 //BA.debugLineNum = 1429;BA.debugLine="cust_LV_morakhasi.Clear";
mostCurrent._cust_lv_morakhasi._clear();
 //BA.debugLineNum = 1430;BA.debugLine="list_morakhasi_id.Clear";
mostCurrent._list_morakhasi_id.Clear();
 //BA.debugLineNum = 1432;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1433;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
 //BA.debugLineNum = 1434;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1435;BA.debugLine="Dim str2 As StringBuilder";
_str2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1436;BA.debugLine="str2.Initialize";
_str2.Initialize();
 //BA.debugLineNum = 1438;BA.debugLine="Dim ls_morkh As List";
_ls_morkh = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1439;BA.debugLine="ls_morkh.Initialize";
_ls_morkh.Initialize();
 //BA.debugLineNum = 1441;BA.debugLine="ls_morkh=myfunc.Min_to_saatMinRoz(dbCode.res.Get";
_ls_morkh = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 //BA.debugLineNum = 1445;BA.debugLine="If((ls_morkh.Get(2))<>0)Then";
if ((((_ls_morkh.Get((int) (2)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1446;BA.debugLine="str2.Append(ls_morkh.Get(2)&\" روز \")";
_str2.Append(BA.ObjectToString(_ls_morkh.Get((int) (2)))+" روز ");
 //BA.debugLineNum = 1447;BA.debugLine="If((ls_morkh.Get(0))<>0 Or (ls_morkh.Get(1))<>0";
if ((((_ls_morkh.Get((int) (0)))).equals((Object)(0)) == false || ((_ls_morkh.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1448;BA.debugLine="str2.Append(CRLF)";
_str2.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
 //BA.debugLineNum = 1451;BA.debugLine="If((ls_morkh.Get(0))<>0)Then";
if ((((_ls_morkh.Get((int) (0)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1452;BA.debugLine="str2.Append(ls_morkh.Get(0)&\" ساعت \")";
_str2.Append(BA.ObjectToString(_ls_morkh.Get((int) (0)))+" ساعت ");
 //BA.debugLineNum = 1453;BA.debugLine="If((ls_morkh.Get(1))<>0)Then";
if ((((_ls_morkh.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1454;BA.debugLine="str2.Append(CRLF)";
_str2.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
 //BA.debugLineNum = 1457;BA.debugLine="If((ls_morkh.Get(1))<>0)Then";
if ((((_ls_morkh.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1458;BA.debugLine="str2.Append(ls_morkh.Get(1)&\" دقیقه \")";
_str2.Append(BA.ObjectToString(_ls_morkh.Get((int) (1)))+" دقیقه ");
 };
 //BA.debugLineNum = 1462;BA.debugLine="Dim p2 As B4XView = xui.CreatePanel(\"\")";
_p2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p2 = mostCurrent._xui.CreatePanel(processBA,"");
 //BA.debugLineNum = 1463;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
 //BA.debugLineNum = 1464;BA.debugLine="p2.LoadLayout(\"item_list\")";
_p2.LoadLayout("item_list",mostCurrent.activityBA);
 //BA.debugLineNum = 1466;BA.debugLine="cust_LV_morakhasi.Add(p2,dbCode.res.GetString(\"i";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1468;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
 //BA.debugLineNum = 1470;BA.debugLine="lbl_date_CLV.Text=\"از : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("از : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
 //BA.debugLineNum = 1471;BA.debugLine="lbl_hour_CLV.Text=\"تا : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("تا : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
 //BA.debugLineNum = 1472;BA.debugLine="lbl_time_CLV.Text=str2.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str2.ToString()));
 //BA.debugLineNum = 1473;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 1474;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1475;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1477;BA.debugLine="list_morakhasi_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_morakhasi_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
 //BA.debugLineNum = 1482;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1483;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1489;BA.debugLine="If(cust_LV_morakhasi.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_morakhasi._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 1490;BA.debugLine="p2 = xui.CreatePanel(\"p\")";
_p2 = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1491;BA.debugLine="Select cust_LV_morakhasi.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_morakhasi._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 1493;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
 //BA.debugLineNum = 1495;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 1497;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 1499;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 1501;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 1503;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 1505;BA.debugLine="cust_LV_morakhasi.Add(p2,\"\")";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(""));
 };
 //BA.debugLineNum = 1510;BA.debugLine="cust_LV_taradod.Clear";
mostCurrent._cust_lv_taradod._clear();
 //BA.debugLineNum = 1511;BA.debugLine="list_taradod_id.Clear";
mostCurrent._list_taradod_id.Clear();
 //BA.debugLineNum = 1513;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1514;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
 //BA.debugLineNum = 1515;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1516;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1517;BA.debugLine="str1.Initialize";
_str1.Initialize();
 //BA.debugLineNum = 1519;BA.debugLine="Dim ls_tarad As List";
_ls_tarad = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1520;BA.debugLine="ls_tarad.Initialize";
_ls_tarad.Initialize();
 //BA.debugLineNum = 1522;BA.debugLine="ls_tarad=myfunc.Min_to_saatMinRoz(dbCode.res.Get";
_ls_tarad = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 //BA.debugLineNum = 1526;BA.debugLine="If((ls_tarad.Get(2))<>0)Then";
if ((((_ls_tarad.Get((int) (2)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1527;BA.debugLine="str1.Append(ls_tarad.Get(2)&\" روز \")";
_str1.Append(BA.ObjectToString(_ls_tarad.Get((int) (2)))+" روز ");
 //BA.debugLineNum = 1528;BA.debugLine="If((ls_tarad.Get(0))<>0 Or (ls_tarad.Get(1))<>0";
if ((((_ls_tarad.Get((int) (0)))).equals((Object)(0)) == false || ((_ls_tarad.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1529;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
 //BA.debugLineNum = 1532;BA.debugLine="If((ls_tarad.Get(0))<>0)Then";
if ((((_ls_tarad.Get((int) (0)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1533;BA.debugLine="str1.Append(ls_tarad.Get(0)&\" ساعت \")";
_str1.Append(BA.ObjectToString(_ls_tarad.Get((int) (0)))+" ساعت ");
 //BA.debugLineNum = 1534;BA.debugLine="If((ls_tarad.Get(1))<>0)Then";
if ((((_ls_tarad.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1535;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
 //BA.debugLineNum = 1538;BA.debugLine="If((ls_tarad.Get(1))<>0)Then";
if ((((_ls_tarad.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1539;BA.debugLine="str1.Append(ls_tarad.Get(1)&\" دقیقه \")";
_str1.Append(BA.ObjectToString(_ls_tarad.Get((int) (1)))+" دقیقه ");
 };
 //BA.debugLineNum = 1543;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1544;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
 //BA.debugLineNum = 1545;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
 //BA.debugLineNum = 1547;BA.debugLine="cust_LV_taradod.Add(p,dbCode.res.GetString(\"id\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1549;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
 //BA.debugLineNum = 1551;BA.debugLine="lbl_date_CLV.Text=\"ورود : \"&dbCode.res.GetString";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("ورود : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
 //BA.debugLineNum = 1552;BA.debugLine="lbl_hour_CLV.Text=\"خروج : \"&dbCode.res.GetString";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("خروج : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
 //BA.debugLineNum = 1554;BA.debugLine="lbl_time_CLV.Typeface=Typeface.MATERIALICONS";
mostCurrent._lbl_time_clv.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
 //BA.debugLineNum = 1555;BA.debugLine="lbl_time_CLV.Text=Chr(0xE8D5)";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe8d5))));
 //BA.debugLineNum = 1556;BA.debugLine="lbl_time_CLV.TextSize=25";
mostCurrent._lbl_time_clv.setTextSize((float) (25));
 //BA.debugLineNum = 1558;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 1559;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1560;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1562;BA.debugLine="list_taradod_id.Add(dbCode.res.GetString(\"id\"))";
mostCurrent._list_taradod_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
 //BA.debugLineNum = 1567;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1568;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1570;BA.debugLine="If(cust_LV_taradod.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_taradod._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 1571;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1572;BA.debugLine="Select cust_LV_taradod.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_taradod._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 1574;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
 //BA.debugLineNum = 1576;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 1578;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 1580;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 1582;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 1584;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 1586;BA.debugLine="cust_LV_taradod.Add(p,\"\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(""));
 };
 //BA.debugLineNum = 1592;BA.debugLine="cust_LV_mamoriat.Clear";
mostCurrent._cust_lv_mamoriat._clear();
 //BA.debugLineNum = 1593;BA.debugLine="list_mamoriat_id.Clear";
mostCurrent._list_mamoriat_id.Clear();
 //BA.debugLineNum = 1596;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1597;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  date_from DESC;")));
 //BA.debugLineNum = 1600;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1601;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1602;BA.debugLine="str1.Initialize";
_str1.Initialize();
 //BA.debugLineNum = 1604;BA.debugLine="Dim ls_mamor As List";
_ls_mamor = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1605;BA.debugLine="ls_mamor.Initialize";
_ls_mamor.Initialize();
 //BA.debugLineNum = 1607;BA.debugLine="ls_mamor=myfunc.Min_to_saatMinRoz(dbCode.res.Get";
_ls_mamor = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 //BA.debugLineNum = 1611;BA.debugLine="If((ls_mamor.Get(2))<>0)Then";
if ((((_ls_mamor.Get((int) (2)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1612;BA.debugLine="str1.Append(ls_mamor.Get(2)&\" روز \")";
_str1.Append(BA.ObjectToString(_ls_mamor.Get((int) (2)))+" روز ");
 //BA.debugLineNum = 1613;BA.debugLine="If((ls_mamor.Get(0))<>0 Or (ls_mamor.Get(1))<>0";
if ((((_ls_mamor.Get((int) (0)))).equals((Object)(0)) == false || ((_ls_mamor.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1614;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
 //BA.debugLineNum = 1617;BA.debugLine="If((ls_mamor.Get(0))<>0)Then";
if ((((_ls_mamor.Get((int) (0)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1618;BA.debugLine="str1.Append(ls_mamor.Get(0)&\" ساعت \")";
_str1.Append(BA.ObjectToString(_ls_mamor.Get((int) (0)))+" ساعت ");
 //BA.debugLineNum = 1619;BA.debugLine="If((ls_mamor.Get(1))<>0)Then";
if ((((_ls_mamor.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1620;BA.debugLine="str1.Append(CRLF)";
_str1.Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 };
 //BA.debugLineNum = 1623;BA.debugLine="If((ls_mamor.Get(1))<>0)Then";
if ((((_ls_mamor.Get((int) (1)))).equals((Object)(0)) == false)) { 
 //BA.debugLineNum = 1624;BA.debugLine="str1.Append(ls_mamor.Get(1)&\" دقیقه \")";
_str1.Append(BA.ObjectToString(_ls_mamor.Get((int) (1)))+" دقیقه ");
 };
 //BA.debugLineNum = 1628;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1629;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
 //BA.debugLineNum = 1630;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
 //BA.debugLineNum = 1632;BA.debugLine="cust_LV_mamoriat.Add(p,dbCode.res.GetString(\"id\"";
mostCurrent._cust_lv_mamoriat._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1634;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
mostCurrent._lbl_day_clv.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._get_day_name /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
 //BA.debugLineNum = 1636;BA.debugLine="lbl_date_CLV.Text=\"از : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence("از : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")));
 //BA.debugLineNum = 1637;BA.debugLine="lbl_hour_CLV.Text=\"تا : \"&dbCode.res.GetString(\"";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence("تا : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
 //BA.debugLineNum = 1638;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str1.ToString()));
 //BA.debugLineNum = 1639;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 1640;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1641;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1643;BA.debugLine="list_mamoriat_id.Add(dbCode.res.GetString(\"id\"))";
mostCurrent._list_mamoriat_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
 //BA.debugLineNum = 1648;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1649;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1653;BA.debugLine="If(cust_LV_mamoriat.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_mamoriat._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 1654;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1655;BA.debugLine="Select cust_LV_mamoriat.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_mamoriat._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 1657;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
 //BA.debugLineNum = 1659;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 1661;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 1663;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 1665;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 1667;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 1669;BA.debugLine="cust_LV_mamoriat.Add(p,\"\")";
mostCurrent._cust_lv_mamoriat._add(mostCurrent._p,(Object)(""));
 };
 //BA.debugLineNum = 1673;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
 //BA.debugLineNum = 1675;BA.debugLine="End Sub";
return "";
}
public static String  _finger_scaning() throws Exception{
 //BA.debugLineNum = 869;BA.debugLine="Sub finger_scaning";
 //BA.debugLineNum = 870;BA.debugLine="fingerprint.Authenticate";
mostCurrent._fingerprint._authenticate /*String*/ ();
 //BA.debugLineNum = 871;BA.debugLine="ToastMessageShow(\"Scanning...\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Scanning..."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 872;BA.debugLine="End Sub";
return "";
}
public static String  _get_dataedit_byid(int _id1) throws Exception{
 //BA.debugLineNum = 4023;BA.debugLine="Sub get_dataEdit_byId(id1 As Int)";
 //BA.debugLineNum = 4024;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 4025;BA.debugLine="If(index_box=1)Then";
if ((_index_box==1)) { 
 //BA.debugLineNum = 4026;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE id="+BA.NumberToString(_id1))));
 //BA.debugLineNum = 4027;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 4029;BA.debugLine="If(dbCode.res.GetInt(\"state\")=0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==0)) { 
 //BA.debugLineNum = 4030;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 4032;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
 }else if((_index_box==2)) { 
 //BA.debugLineNum = 4038;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE id="+BA.NumberToString(_id1))));
 //BA.debugLineNum = 4039;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 4042;BA.debugLine="Select dbCode.res.GetInt(\"state\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
 //BA.debugLineNum = 4044;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
 //BA.debugLineNum = 4046;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
 //BA.debugLineNum = 4048;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
 //BA.debugLineNum = 4050;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
 //BA.debugLineNum = 4054;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
 //BA.debugLineNum = 4055;BA.debugLine="index_noe_morakhasi=dbCode.res.GetInt(\"state\")";
_index_noe_morakhasi = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state");
 }else if((_index_box==3)) { 
 //BA.debugLineNum = 4060;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE id="+BA.NumberToString(_id1))));
 //BA.debugLineNum = 4061;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 }else if((_index_box==5)) { 
 //BA.debugLineNum = 4065;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mamoriat WHERE id="+BA.NumberToString(_id1))));
 //BA.debugLineNum = 4066;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 };
 //BA.debugLineNum = 4073;BA.debugLine="lbl_tim1.Text=dbCode.res.GetString(\"time_from\")";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")));
 //BA.debugLineNum = 4074;BA.debugLine="lbl_tim2.Text=dbCode.res.GetString(\"time_to\")";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
 //BA.debugLineNum = 4076;BA.debugLine="lbl_date1.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
 //BA.debugLineNum = 4077;BA.debugLine="lbl_date2.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))));
 //BA.debugLineNum = 4079;BA.debugLine="et_tozihat.Text=dbCode.res.GetString(\"tozihat\")";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 4082;BA.debugLine="End Sub";
return "";
}
public static String  _get_today_shift() throws Exception{
int _id_today = 0;
String _str_sh = "";
 //BA.debugLineNum = 1220;BA.debugLine="Sub get_today_shift";
 //BA.debugLineNum = 1221;BA.debugLine="Dim id_today As Int";
_id_today = 0;
 //BA.debugLineNum = 1222;BA.debugLine="id_today=dbCode.get_day_id(persianDate.PersianYea";
_id_today = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_persiandate.getPersianYear(),_persiandate.getPersianMonth(),_persiandate.getPersianDay());
 //BA.debugLineNum = 1224;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1225;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id_today))));
 //BA.debugLineNum = 1227;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 1231;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")).equals("") == false)) { 
 //BA.debugLineNum = 1232;BA.debugLine="Dim str_sh As String";
_str_sh = "";
 //BA.debugLineNum = 1233;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift"),"ر","ش","ع","ا")) {
case 0: {
 //BA.debugLineNum = 1235;BA.debugLine="str_sh=\"روزکار\"";
_str_sh = "روزکار";
 break; }
case 1: {
 //BA.debugLineNum = 1237;BA.debugLine="str_sh=\"شبکار\"";
_str_sh = "شبکار";
 break; }
case 2: {
 //BA.debugLineNum = 1239;BA.debugLine="str_sh=\"عصرکار\"";
_str_sh = "عصرکار";
 break; }
case 3: {
 //BA.debugLineNum = 1241;BA.debugLine="str_sh=\"استراحت\"";
_str_sh = "استراحت";
 break; }
}
;
 //BA.debugLineNum = 1243;BA.debugLine="lbl_shift_home.Text=\"(\"&str_sh&\")\"";
mostCurrent._lbl_shift_home.setText(BA.ObjectToCharSequence("("+_str_sh+")"));
 };
 //BA.debugLineNum = 1248;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 173;BA.debugLine="Dim inappBazar As InAppBillingBazaar";
mostCurrent._inappbazar = new anywheresoftware.b4a.inappbilling3.BillingManager3();
 //BA.debugLineNum = 175;BA.debugLine="Private lbl_vip As Label";
mostCurrent._lbl_vip = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 177;BA.debugLine="Private img_help As ImageView";
mostCurrent._img_help = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 178;BA.debugLine="Dim index_x_start_swap As Int=0";
_index_x_start_swap = (int) (0);
 //BA.debugLineNum = 179;BA.debugLine="Dim index_curent_img As Int=1";
_index_curent_img = (int) (1);
 //BA.debugLineNum = 180;BA.debugLine="Private pan_help As Panel";
mostCurrent._pan_help = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 181;BA.debugLine="Private lbl_remove_from_list As Label";
mostCurrent._lbl_remove_from_list = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 182;BA.debugLine="Private lbl_remove_from_list2 As Label";
mostCurrent._lbl_remove_from_list2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 184;BA.debugLine="Private cv_loader As B4XLoadingIndicator";
mostCurrent._cv_loader = new ir.taravatgroup.ezafekari2.b4xloadingindicator();
 //BA.debugLineNum = 185;BA.debugLine="Private lbl_vip2 As Label";
mostCurrent._lbl_vip2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 186;BA.debugLine="Private lbl_show_vip As Label";
mostCurrent._lbl_show_vip = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 187;BA.debugLine="Private lbl_vip_now As Label";
mostCurrent._lbl_vip_now = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 188;BA.debugLine="Private pan_all_noskhe As Panel";
mostCurrent._pan_all_noskhe = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 191;BA.debugLine="Private pik_min_bala1 As Label";
mostCurrent._pik_min_bala1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 192;BA.debugLine="Private pik_hour_bala1 As Label";
mostCurrent._pik_hour_bala1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 193;BA.debugLine="Private pik_min_paeen1 As Label";
mostCurrent._pik_min_paeen1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 194;BA.debugLine="Private pik_hour_paeen1 As Label";
mostCurrent._pik_hour_paeen1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 195;BA.debugLine="Private scroll_v_noskhe As ScrollView";
mostCurrent._scroll_v_noskhe = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 198;BA.debugLine="Dim bit_img0 As Bitmap";
mostCurrent._bit_img0 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 199;BA.debugLine="Dim bit_img1 As Bitmap";
mostCurrent._bit_img1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 200;BA.debugLine="Dim bit_img2 As Bitmap";
mostCurrent._bit_img2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 201;BA.debugLine="Dim bit_img3 As Bitmap";
mostCurrent._bit_img3 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 202;BA.debugLine="Dim bit_img4 As Bitmap";
mostCurrent._bit_img4 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 205;BA.debugLine="Private lbl_close_help As Label";
mostCurrent._lbl_close_help = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 206;BA.debugLine="Private lbl_time_as As Label";
mostCurrent._lbl_time_as = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 207;BA.debugLine="Private lbl_time_ta As Label";
mostCurrent._lbl_time_ta = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 208;BA.debugLine="Private cust_LV_taradod As CustomListView";
mostCurrent._cust_lv_taradod = new b4a.example3.customlistview();
 //BA.debugLineNum = 210;BA.debugLine="Dim ht As HttpJob";
mostCurrent._ht = new ir.taravatgroup.ezafekari2.httpjob();
 //BA.debugLineNum = 212;BA.debugLine="Dim msg As String=\"\"";
mostCurrent._msg = "";
 //BA.debugLineNum = 214;BA.debugLine="Private pan_notifi_all As Panel";
mostCurrent._pan_notifi_all = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 215;BA.debugLine="Private web_msg_show As WebView";
mostCurrent._web_msg_show = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 218;BA.debugLine="Dim ls1 As List		'num msg";
mostCurrent._ls1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 219;BA.debugLine="Dim ls2 As List		'msg";
mostCurrent._ls2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 220;BA.debugLine="Dim ls3 As List		'date msg";
mostCurrent._ls3 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 222;BA.debugLine="Dim last_notif As String =\"0000\"";
mostCurrent._last_notif = "0000";
 //BA.debugLineNum = 223;BA.debugLine="Dim is_now_instal As Boolean=True";
_is_now_instal = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 225;BA.debugLine="Private lbl_title_msgPan As Label";
mostCurrent._lbl_title_msgpan = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 226;BA.debugLine="Private pan_notif As Panel";
mostCurrent._pan_notif = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 230;BA.debugLine="Private ckb_ezaf_taradod As CheckBox";
mostCurrent._ckb_ezaf_taradod = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 231;BA.debugLine="Private lbl_ezaf_taradod As Label";
mostCurrent._lbl_ezaf_taradod = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 232;BA.debugLine="Private pan_ezaf_taradod As Panel";
mostCurrent._pan_ezaf_taradod = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 233;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 234;BA.debugLine="Private pan_hed_list As Panel";
mostCurrent._pan_hed_list = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 235;BA.debugLine="Private pan_hed_gozaresh As Panel";
mostCurrent._pan_hed_gozaresh = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 240;BA.debugLine="Private pan_all_msgNewYear As Panel";
mostCurrent._pan_all_msgnewyear = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 241;BA.debugLine="Private lbl_majmoe_saat As Label";
mostCurrent._lbl_majmoe_saat = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 242;BA.debugLine="Private pan_all_liteMenu As Panel";
mostCurrent._pan_all_litemenu = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 243;BA.debugLine="Private lbl_shift_home As Label";
mostCurrent._lbl_shift_home = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 244;BA.debugLine="Private sp_year_gozaresh As Spinner";
mostCurrent._sp_year_gozaresh = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 245;BA.debugLine="Private pan_item_gozaresh As Panel";
mostCurrent._pan_item_gozaresh = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 248;BA.debugLine="Dim rsPOP_noe As RSPopupMenu";
mostCurrent._rspop_noe = new com.rootsoft.rspopupmenu.RSPopupMenu();
 //BA.debugLineNum = 249;BA.debugLine="Dim index_noe_morakhasi As Int=0";
_index_noe_morakhasi = (int) (0);
 //BA.debugLineNum = 250;BA.debugLine="Dim str_noe As String=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 //BA.debugLineNum = 251;BA.debugLine="Private lbl_edit_from_list As Label";
mostCurrent._lbl_edit_from_list = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 254;BA.debugLine="Dim current_id_edit As Int=0";
_current_id_edit = (int) (0);
 //BA.debugLineNum = 255;BA.debugLine="Dim	is_for_edit As Boolean=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 258;BA.debugLine="Dim tim_min As Int";
_tim_min = 0;
 //BA.debugLineNum = 260;BA.debugLine="Private lbl_vesion_app As Label";
mostCurrent._lbl_vesion_app = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 263;BA.debugLine="Private btnEight As Button";
mostCurrent._btneight = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 264;BA.debugLine="Private btnFive As Button";
mostCurrent._btnfive = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 265;BA.debugLine="Private btnFour As Button";
mostCurrent._btnfour = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 266;BA.debugLine="Private btnNine As Button";
mostCurrent._btnnine = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 267;BA.debugLine="Private btnOne As Button";
mostCurrent._btnone = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 268;BA.debugLine="Private btnSeven As Button";
mostCurrent._btnseven = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 269;BA.debugLine="Private btnSix As Button";
mostCurrent._btnsix = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 270;BA.debugLine="Private btnThree As Button";
mostCurrent._btnthree = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 271;BA.debugLine="Private btnTwo As Button";
mostCurrent._btntwo = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 272;BA.debugLine="Private btnZero As Button";
mostCurrent._btnzero = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 273;BA.debugLine="Private key1 As Panel";
mostCurrent._key1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 274;BA.debugLine="Private key2 As Panel";
mostCurrent._key2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 275;BA.debugLine="Private key3 As Panel";
mostCurrent._key3 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 276;BA.debugLine="Private key4 As Panel";
mostCurrent._key4 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 279;BA.debugLine="Dim Click_Count As Int = 0";
_click_count = (int) (0);
 //BA.debugLineNum = 280;BA.debugLine="Dim Master_Password As String";
mostCurrent._master_password = "";
 //BA.debugLineNum = 281;BA.debugLine="Dim entered_Password As String";
mostCurrent._entered_password = "";
 //BA.debugLineNum = 282;BA.debugLine="Dim fingerprint As FingerprintManager";
mostCurrent._fingerprint = new ir.taravatgroup.ezafekari2.fingerprintmanager();
 //BA.debugLineNum = 283;BA.debugLine="Private lbl_finger As Label";
mostCurrent._lbl_finger = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 285;BA.debugLine="Dim stat_finger As Int=0";
_stat_finger = (int) (0);
 //BA.debugLineNum = 287;BA.debugLine="Private pan_lock As Panel";
mostCurrent._pan_lock = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 288;BA.debugLine="Private lbl_hint_lock As Label";
mostCurrent._lbl_hint_lock = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 289;BA.debugLine="Private pan_all_chekUpdate As Panel";
mostCurrent._pan_all_chekupdate = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 290;BA.debugLine="Private webVeiw_chk_update As WebView";
mostCurrent._webveiw_chk_update = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 291;BA.debugLine="Private lbl_chk_update_ok As Label";
mostCurrent._lbl_chk_update_ok = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 292;BA.debugLine="Private lbl_day_CLV As Label";
mostCurrent._lbl_day_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 293;BA.debugLine="Private cust_LV_mamoriat As CustomListView";
mostCurrent._cust_lv_mamoriat = new b4a.example3.customlistview();
 //BA.debugLineNum = 295;BA.debugLine="Dim is_new_msg As Boolean=False";
_is_new_msg = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 296;BA.debugLine="Dim is_time_backup As Boolean=False";
_is_time_backup = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 298;BA.debugLine="Private radio_ez_fog As RadioButton";
mostCurrent._radio_ez_fog = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 299;BA.debugLine="Private radio_ez_adi As RadioButton";
mostCurrent._radio_ez_adi = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 300;BA.debugLine="Private lbl_finger_khoroj As Label";
mostCurrent._lbl_finger_khoroj = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 301;BA.debugLine="Private lbl_finger_vorod As Label";
mostCurrent._lbl_finger_vorod = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 303;BA.debugLine="Dim user_request_update As Boolean=False";
_user_request_update = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 304;BA.debugLine="Private lbl_setting_date As Label";
mostCurrent._lbl_setting_date = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 305;BA.debugLine="Private pan_all_setting_date As Panel";
mostCurrent._pan_all_setting_date = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 306;BA.debugLine="Private ckb_setting_date_finger As CheckBox";
mostCurrent._ckb_setting_date_finger = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 308;BA.debugLine="Private pan_finger_taradod As Panel";
mostCurrent._pan_finger_taradod = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 309;BA.debugLine="Private lbl_finger_fs_vorod As Label";
mostCurrent._lbl_finger_fs_vorod = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 310;BA.debugLine="Private lbl_finger_fs_khoroj As Label";
mostCurrent._lbl_finger_fs_khoroj = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 311;BA.debugLine="Private lbl_finger_fs_vorod_time As Label";
mostCurrent._lbl_finger_fs_vorod_time = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 312;BA.debugLine="Private lbl_finger_fs_khoroj_time As Label";
mostCurrent._lbl_finger_fs_khoroj_time = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 313;BA.debugLine="Private lbl_time_show_fs As Label";
mostCurrent._lbl_time_show_fs = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 314;BA.debugLine="Private lbl_ezaf_taradod_fs As Label";
mostCurrent._lbl_ezaf_taradod_fs = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 315;BA.debugLine="Private ckb_ezaf_taradod_fs As CheckBox";
mostCurrent._ckb_ezaf_taradod_fs = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 316;BA.debugLine="Private lbl_save_box As Label";
mostCurrent._lbl_save_box = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 317;BA.debugLine="Dim save_box_allow As Boolean=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 319;BA.debugLine="Dim state_tatil As Int=0";
_state_tatil = (int) (0);
 //BA.debugLineNum = 320;BA.debugLine="Dim day_inWeek_id As Int=0";
_day_inweek_id = (int) (0);
 //BA.debugLineNum = 321;BA.debugLine="Dim day_inWeek_name As String=\"\"";
mostCurrent._day_inweek_name = "";
 //BA.debugLineNum = 322;BA.debugLine="Dim state_tatil_setting As Int=0  ' 0 all is off";
_state_tatil_setting = (int) (0);
 //BA.debugLineNum = 326;BA.debugLine="Private ckb_tatil_rasmi As CheckBox";
mostCurrent._ckb_tatil_rasmi = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 327;BA.debugLine="Private ckb_tatil_garardadi As CheckBox";
mostCurrent._ckb_tatil_garardadi = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 328;BA.debugLine="Private lbl_tatil_show As Label";
mostCurrent._lbl_tatil_show = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 329;BA.debugLine="Private ScrollView_sett_taradod As ScrollView";
mostCurrent._scrollview_sett_taradod = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 331;BA.debugLine="Private et_saat_kari0 As EditText";
mostCurrent._et_saat_kari0 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 332;BA.debugLine="Private et_min_kari0 As EditText";
mostCurrent._et_min_kari0 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 333;BA.debugLine="Private et_saat_kari1 As EditText";
mostCurrent._et_saat_kari1 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 334;BA.debugLine="Private et_min_kari1 As EditText";
mostCurrent._et_min_kari1 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 335;BA.debugLine="Private et_min_kari2 As EditText";
mostCurrent._et_min_kari2 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 336;BA.debugLine="Private et_saat_kari2 As EditText";
mostCurrent._et_saat_kari2 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 337;BA.debugLine="Private et_saat_kari3 As EditText";
mostCurrent._et_saat_kari3 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 338;BA.debugLine="Private et_min_kari3 As EditText";
mostCurrent._et_min_kari3 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 339;BA.debugLine="Private et_min_kari4 As EditText";
mostCurrent._et_min_kari4 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 340;BA.debugLine="Private et_saat_kari4 As EditText";
mostCurrent._et_saat_kari4 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 341;BA.debugLine="Private et_saat_kari5 As EditText";
mostCurrent._et_saat_kari5 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 342;BA.debugLine="Private et_min_kari5 As EditText";
mostCurrent._et_min_kari5 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 344;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
String _send = "";
 //BA.debugLineNum = 495;BA.debugLine="Sub http_initial_1(type1 As Int)";
 //BA.debugLineNum = 496;BA.debugLine="ht.Initialize(\"ht\",Me)";
mostCurrent._ht._initialize /*String*/ (processBA,"ht",main.getObject());
 //BA.debugLineNum = 497;BA.debugLine="Dim send As String";
_send = "";
 //BA.debugLineNum = 498;BA.debugLine="send = \"username=mahdi&password=1234&div_id=\"&pho";
_send = "username=mahdi&password=1234&div_id="+_phon.GetSettings("android_id")+"&sdk_ver="+BA.NumberToString(_phon.getSdkVersion())+"&oprator="+_phon.GetNetworkOperatorName()+"&type_app="+BA.NumberToString(_type1)+"&div_model="+_phon.getModel()+"&last_notif="+mostCurrent._last_notif+"&var=0&is_now_instal="+BA.ObjectToString(_is_now_instal)+"&version_code="+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Application.getVersionCode());
 //BA.debugLineNum = 499;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/ezafekari2";
mostCurrent._ht._poststring /*String*/ ("https://taravatgroup.ir/ezafekari2.php",_send);
 //BA.debugLineNum = 500;BA.debugLine="Log(\"ht sended\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7458757","ht sended",0);
 //BA.debugLineNum = 502;BA.debugLine="End Sub";
return "";
}
public static String  _img_slider(int _index1) throws Exception{
 //BA.debugLineNum = 3955;BA.debugLine="Sub img_slider (index1 As Int)";
 //BA.debugLineNum = 3956;BA.debugLine="Select index1";
switch (_index1) {
case 0: {
 //BA.debugLineNum = 3958;BA.debugLine="img_help.Bitmap=bit_img0";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img0.getObject()));
 break; }
case 1: {
 //BA.debugLineNum = 3960;BA.debugLine="img_help.Bitmap=bit_img1";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img1.getObject()));
 break; }
case 2: {
 //BA.debugLineNum = 3963;BA.debugLine="img_help.Bitmap=bit_img2";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img2.getObject()));
 break; }
case 3: {
 //BA.debugLineNum = 3966;BA.debugLine="img_help.Bitmap=bit_img3";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img3.getObject()));
 break; }
case 4: {
 //BA.debugLineNum = 3969;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
 break; }
default: {
 //BA.debugLineNum = 3972;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("76750225","error",0);
 break; }
}
;
 //BA.debugLineNum = 3975;BA.debugLine="End Sub";
return "";
}
public static String  _inapp_purchasecompleted(boolean _success,anywheresoftware.b4a.inappbilling3.BillingManager3.Prchase _product) throws Exception{
 //BA.debugLineNum = 770;BA.debugLine="Sub inapp_PurchaseCompleted (Success As Boolean, P";
 //BA.debugLineNum = 771;BA.debugLine="Log(Product)";
anywheresoftware.b4a.keywords.Common.LogImpl("7917505",BA.ObjectToString(_product),0);
 //BA.debugLineNum = 773;BA.debugLine="If Success=True Then";
if (_success==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 775;BA.debugLine="If Product.ProductId=\"ezafekari2\" Then";
if ((_product.getProductId()).equals("ezafekari2")) { 
 //BA.debugLineNum = 778;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\",\"\")";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
 //BA.debugLineNum = 779;BA.debugLine="MsgboxAsync(\"پرداخت انجام شده است\",\"انجام شد\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("پرداخت انجام شده است"),BA.ObjectToCharSequence("انجام شد"),processBA);
 //BA.debugLineNum = 780;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی ا";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 783;BA.debugLine="inappBazar.ConsumeProduct(Product)";
mostCurrent._inappbazar.ConsumeProduct(processBA,_product);
 //BA.debugLineNum = 785;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 //BA.debugLineNum = 786;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 790;BA.debugLine="ToastMessageShow(\"خرید انجام نشد. دوباره تلاش کن";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خرید انجام نشد. دوباره تلاش کنید"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 792;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 506;BA.debugLine="Sub Jobdone (job As HttpJob)";
 //BA.debugLineNum = 507;BA.debugLine="Try";
try { //BA.debugLineNum = 509;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 510;BA.debugLine="If job.JobName=\"ht\" Then";
if ((_job._jobname /*String*/ ).equals("ht")) { 
 //BA.debugLineNum = 511;BA.debugLine="If(job.GetString <> \"\")Then";
if (((_job._getstring /*String*/ ()).equals("") == false)) { 
 //BA.debugLineNum = 513;BA.debugLine="If(job.GetString.Contains(\"accessok\"))Then";
if ((_job._getstring /*String*/ ().contains("accessok"))) { 
 //BA.debugLineNum = 516;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
 }else {
 //BA.debugLineNum = 519;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
 //BA.debugLineNum = 520;BA.debugLine="myfunc.help_man(\"توجه\",\"نسخه طلایی از طرف ا";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","نسخه طلایی از طرف ادمین فعال شد");
 };
 }else if((_job._getstring /*String*/ ().contains("accessno"))) { 
 //BA.debugLineNum = 526;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
 //BA.debugLineNum = 527;BA.debugLine="File.Delete(File.DirInternal,\"payokok\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok");
 //BA.debugLineNum = 528;BA.debugLine="myfunc.help_man(\"توجه\",\" نسخه طلایی از طرف";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه"," نسخه طلایی از طرف ادمین غیرفعال شد");
 };
 }else if((_job._getstring /*String*/ ().contains("lockok"))) { 
 //BA.debugLineNum = 533;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 534;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
 //BA.debugLineNum = 536;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 537;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
 //BA.debugLineNum = 538;BA.debugLine="ls_lock0.Set(0,\"true\")";
_ls_lock0.Set((int) (0),(Object)("true"));
 //BA.debugLineNum = 539;BA.debugLine="ls_lock0.Set(1,\"false\")";
_ls_lock0.Set((int) (1),(Object)("false"));
 //BA.debugLineNum = 540;BA.debugLine="ls_lock0.Set(2,\"2022\")";
_ls_lock0.Set((int) (2),(Object)("2022"));
 }else {
 //BA.debugLineNum = 542;BA.debugLine="ls_lock0.Add(\"true\")";
_ls_lock0.Add((Object)("true"));
 //BA.debugLineNum = 543;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
 //BA.debugLineNum = 544;BA.debugLine="ls_lock0.Add(\"2022\")";
_ls_lock0.Add((Object)("2022"));
 //BA.debugLineNum = 545;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 };
 //BA.debugLineNum = 547;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock0);
 }else if((_job._getstring /*String*/ ().contains("lockno"))) { 
 //BA.debugLineNum = 550;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 551;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
 //BA.debugLineNum = 553;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 554;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
 //BA.debugLineNum = 555;BA.debugLine="ls_lock0.Set(0,\"false\")";
_ls_lock0.Set((int) (0),(Object)("false"));
 //BA.debugLineNum = 556;BA.debugLine="ls_lock0.Set(1,\"false\")";
_ls_lock0.Set((int) (1),(Object)("false"));
 //BA.debugLineNum = 557;BA.debugLine="ls_lock0.Set(2,\"\")";
_ls_lock0.Set((int) (2),(Object)(""));
 }else {
 //BA.debugLineNum = 559;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
 //BA.debugLineNum = 560;BA.debugLine="ls_lock0.Add(\"false\")";
_ls_lock0.Add((Object)("false"));
 //BA.debugLineNum = 561;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 //BA.debugLineNum = 562;BA.debugLine="ls_lock0.Add(\"\")";
_ls_lock0.Add((Object)(""));
 };
 //BA.debugLineNum = 564;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock0);
 }else if((_job._getstring /*String*/ ().contains("new_msg"))) { 
 //BA.debugLineNum = 571;BA.debugLine="is_new_msg=True";
_is_new_msg = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 577;BA.debugLine="msg=job.GetString";
mostCurrent._msg = _job._getstring /*String*/ ();
 //BA.debugLineNum = 579;BA.debugLine="tim_msg.Enabled=True";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 };
 };
 //BA.debugLineNum = 590;BA.debugLine="If job.JobName=\"chkupdate\" Then";
if ((_job._jobname /*String*/ ).equals("chkupdate")) { 
 //BA.debugLineNum = 592;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 594;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ ());
 //BA.debugLineNum = 596;BA.debugLine="Dim root1 As List";
_root1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 597;BA.debugLine="root1.Initialize";
_root1.Initialize();
 //BA.debugLineNum = 598;BA.debugLine="root1=parser.NextArray";
_root1 = _parser.NextArray();
 //BA.debugLineNum = 600;BA.debugLine="Dim str_type As String = root1.Get(0)";
_str_type = BA.ObjectToString(_root1.Get((int) (0)));
 //BA.debugLineNum = 601;BA.debugLine="str_type= str_type.Replace(\"type:\",\"\")";
_str_type = _str_type.replace("type:","");
 //BA.debugLineNum = 603;BA.debugLine="Dim str_version_code As String = root1.Get(1)";
_str_version_code = BA.ObjectToString(_root1.Get((int) (1)));
 //BA.debugLineNum = 604;BA.debugLine="str_version_code=str_version_code.Replace(\"ver";
_str_version_code = _str_version_code.replace("version_code:","");
 //BA.debugLineNum = 606;BA.debugLine="Dim str_version_name As String = root1.Get(2)";
_str_version_name = BA.ObjectToString(_root1.Get((int) (2)));
 //BA.debugLineNum = 607;BA.debugLine="str_version_name=str_version_name.Replace(\"ver";
_str_version_name = _str_version_name.replace("version_name:","");
 //BA.debugLineNum = 609;BA.debugLine="Dim str_changelog_fa As String = root1.Get(3)";
_str_changelog_fa = BA.ObjectToString(_root1.Get((int) (3)));
 //BA.debugLineNum = 610;BA.debugLine="str_changelog_fa=str_changelog_fa.Replace(\"cha";
_str_changelog_fa = _str_changelog_fa.replace("changelog_fa:","");
 //BA.debugLineNum = 612;BA.debugLine="Dim str_message As String = root1.Get(4)";
_str_message = BA.ObjectToString(_root1.Get((int) (4)));
 //BA.debugLineNum = 613;BA.debugLine="str_message=str_message.Replace(\"message:\",\"\")";
_str_message = _str_message.replace("message:","");
 //BA.debugLineNum = 620;BA.debugLine="If(user_request_update=True)Then";
if ((_user_request_update==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 622;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 623;BA.debugLine="pan_all_chekUpdate.Visible=True";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 625;BA.debugLine="If(str_type==\"success\")Then";
if (((_str_type).equals("success"))) { 
 //BA.debugLineNum = 626;BA.debugLine="If(str_version_code>Application.VersionCode)";
if (((double)(Double.parseDouble(_str_version_code))>anywheresoftware.b4a.keywords.Common.Application.getVersionCode())) { 
 //BA.debugLineNum = 627;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body><span style='color:#3AAD00; font-weight: bold;'> بروزرسانی جدید موجود است. </span><br> "+_str_changelog_fa+"</body></html>");
 //BA.debugLineNum = 628;BA.debugLine="lbl_chk_update_ok.Tag=1";
mostCurrent._lbl_chk_update_ok.setTag((Object)(1));
 //BA.debugLineNum = 629;BA.debugLine="lbl_chk_update_ok.Text=\"بروزرسانی برنامه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("بروزرسانی برنامه"));
 }else {
 //BA.debugLineNum = 631;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body> برنامه شما بروز می باشد. با تشکر </body></html>");
 //BA.debugLineNum = 632;BA.debugLine="lbl_chk_update_ok.Tag=0";
mostCurrent._lbl_chk_update_ok.setTag((Object)(0));
 //BA.debugLineNum = 633;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("باشه"));
 };
 }else if(((_str_type).equals("unsuccess"))) { 
 //BA.debugLineNum = 637;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl'";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>خطا در اتصال</body></html>");
 //BA.debugLineNum = 638;BA.debugLine="lbl_chk_update_ok.Tag=0";
mostCurrent._lbl_chk_update_ok.setTag((Object)(0));
 //BA.debugLineNum = 639;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("باشه"));
 };
 }else {
 //BA.debugLineNum = 647;BA.debugLine="If(str_type==\"success\")Then";
if (((_str_type).equals("success"))) { 
 //BA.debugLineNum = 649;BA.debugLine="If(str_version_code>Application.VersionCode)";
if (((double)(Double.parseDouble(_str_version_code))>anywheresoftware.b4a.keywords.Common.Application.getVersionCode())) { 
 //BA.debugLineNum = 650;BA.debugLine="pan_all_chekUpdate.Visible=True";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 652;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl";
mostCurrent._webveiw_chk_update.LoadHtml("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body><span style='color:#3AAD00; font-weight: bold;'> بروزرسانی جدید موجود است. </span><br> "+_str_changelog_fa+"</body></html>");
 //BA.debugLineNum = 653;BA.debugLine="lbl_chk_update_ok.Tag=1";
mostCurrent._lbl_chk_update_ok.setTag((Object)(1));
 //BA.debugLineNum = 654;BA.debugLine="lbl_chk_update_ok.Text=\"بروزرسانی برنامه\"";
mostCurrent._lbl_chk_update_ok.setText(BA.ObjectToCharSequence("بروزرسانی برنامه"));
 };
 };
 };
 };
 }else {
 };
 } 
       catch (Exception e102) {
			processBA.setLastException(e102); //BA.debugLineNum = 669;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("7524451",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 670;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 673;BA.debugLine="End Sub";
return "";
}
public static String  _kharid() throws Exception{
 //BA.debugLineNum = 749;BA.debugLine="Sub kharid";
 //BA.debugLineNum = 752;BA.debugLine="If(myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 753;BA.debugLine="Try";
try { //BA.debugLineNum = 756;BA.debugLine="inappBazar.RequestPayment(\"ezafekari2\",\"inapp\",";
mostCurrent._inappbazar.RequestPayment(processBA,"ezafekari2","inapp","ezafekari2");
 } 
       catch (Exception e5) {
			processBA.setLastException(e5); //BA.debugLineNum = 761;BA.debugLine="MsgboxAsync(\"1- از نصب بودن برنامه بازار اطمینا";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("1- از نصب بودن برنامه بازار اطمینان یابید."+anywheresoftware.b4a.keywords.Common.CRLF+" 2- برنامه ها را ببندید و دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 };
 }else {
 //BA.debugLineNum = 764;BA.debugLine="ToastMessageShow(\"خطا در اتصال \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال "),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 767;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_account_click() throws Exception{
int _result12 = 0;
 //BA.debugLineNum = 4422;BA.debugLine="Private Sub lbl_account_Click";
 //BA.debugLineNum = 4431;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 4432;BA.debugLine="StartActivity(step2_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._step2_activity.getObject()));
 }else {
 //BA.debugLineNum = 4437;BA.debugLine="Dim result12 As Int";
_result12 = 0;
 //BA.debugLineNum = 4438;BA.debugLine="result12 = Msgbox2(\"اتصال اینترنت را بررسی کنید\"";
_result12 = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("اتصال اینترنت را بررسی کنید"),BA.ObjectToCharSequence("توجه!"),"تلاش دوباره","","بستن",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 4439;BA.debugLine="If result12 = DialogResponse.Positive Then";
if (_result12==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 4440;BA.debugLine="lbl_account_Click";
_lbl_account_click();
 };
 };
 //BA.debugLineNum = 4446;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
 //BA.debugLineNum = 4447;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chk_update_click() throws Exception{
String _send2 = "";
 //BA.debugLineNum = 4391;BA.debugLine="Private Sub lbl_chk_update_Click";
 //BA.debugLineNum = 4393;BA.debugLine="user_request_update=True";
_user_request_update = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 4394;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 4395;BA.debugLine="ProgressDialogShow(\"بررسی بروزرسانی ...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("بررسی بروزرسانی ..."));
 //BA.debugLineNum = 4396;BA.debugLine="ht.Initialize(\"chkupdate\",Me)";
mostCurrent._ht._initialize /*String*/ (processBA,"chkupdate",main.getObject());
 //BA.debugLineNum = 4397;BA.debugLine="Dim send2 As String";
_send2 = "";
 //BA.debugLineNum = 4398;BA.debugLine="send2 = \"var=checkupdate\"";
_send2 = "var=checkupdate";
 //BA.debugLineNum = 4399;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/chek_upda";
mostCurrent._ht._poststring /*String*/ ("https://taravatgroup.ir/chek_update.php",_send2);
 }else {
 //BA.debugLineNum = 4401;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 };
 //BA.debugLineNum = 4405;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
 //BA.debugLineNum = 4406;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_chk_update_ok_click() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _op = null;
 //BA.debugLineNum = 4457;BA.debugLine="Private Sub lbl_chk_update_ok_Click";
 //BA.debugLineNum = 4458;BA.debugLine="If (lbl_chk_update_ok.Tag==1)Then";
if (((mostCurrent._lbl_chk_update_ok.getTag()).equals((Object)(1)))) { 
 //BA.debugLineNum = 4459;BA.debugLine="Try";
try { //BA.debugLineNum = 4460;BA.debugLine="Dim op As Intent";
_op = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 4461;BA.debugLine="op.Initialize(op.ACTION_VIEW,\"bazaar://details?";
_op.Initialize(_op.ACTION_VIEW,"bazaar://details?id=ir.taravatgroup.ezafekari2");
 //BA.debugLineNum = 4462;BA.debugLine="op.SetPackage(\"com.farsitel.bazaar\")";
_op.SetPackage("com.farsitel.bazaar");
 //BA.debugLineNum = 4463;BA.debugLine="StartActivity(op)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_op.getObject()));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8); //BA.debugLineNum = 4465;BA.debugLine="myfunc.help_man(\"توجه\",\"برنامه بازار را نصب کنی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","برنامه بازار را نصب کنید !");
 //BA.debugLineNum = 4467;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("78978442",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
 //BA.debugLineNum = 4474;BA.debugLine="pan_all_chekUpdate_Click";
_pan_all_chekupdate_click();
 //BA.debugLineNum = 4475;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_help_click() throws Exception{
 //BA.debugLineNum = 3899;BA.debugLine="Private Sub lbl_close_help_Click";
 //BA.debugLineNum = 3900;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3901;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_msgnewy_click() throws Exception{
 //BA.debugLineNum = 484;BA.debugLine="Private Sub lbl_close_msgNewY_Click";
 //BA.debugLineNum = 486;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 487;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_notif_click() throws Exception{
 //BA.debugLineNum = 737;BA.debugLine="Private Sub lbl_close_notif_Click";
 //BA.debugLineNum = 738;BA.debugLine="pan_notifi_all.Visible=False";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 739;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date1_click() throws Exception{
 //BA.debugLineNum = 3564;BA.debugLine="Private Sub lbl_date1_Click";
 //BA.debugLineNum = 3565;BA.debugLine="lbl_tim1_Click";
_lbl_tim1_click();
 //BA.debugLineNum = 3566;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date2_click() throws Exception{
 //BA.debugLineNum = 3559;BA.debugLine="Private Sub lbl_date2_Click";
 //BA.debugLineNum = 3560;BA.debugLine="lbl_tim2_Click";
_lbl_tim2_click();
 //BA.debugLineNum = 3561;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_from_list_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _b = null;
 //BA.debugLineNum = 3978;BA.debugLine="Private Sub lbl_edit_from_list_Click";
 //BA.debugLineNum = 3979;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 3980;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 3981;BA.debugLine="Log(b.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("76815747",BA.ObjectToString(_b.getTag()),0);
 //BA.debugLineNum = 3982;BA.debugLine="current_id_edit=b.Tag";
_current_id_edit = (int)(BA.ObjectToNumber(_b.getTag()));
 //BA.debugLineNum = 3986;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
 //BA.debugLineNum = 3987;BA.debugLine="pan_add_ezafekari_Click";
_pan_add_ezafekari_click();
 //BA.debugLineNum = 3988;BA.debugLine="lbl_box_title.Text=\"ویرایش اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش اضافه کاری"));
 }else if((mostCurrent._tabhost1.getCurrentTab()==1)) { 
 //BA.debugLineNum = 3991;BA.debugLine="pan_add_morakhasi_Click";
_pan_add_morakhasi_click();
 //BA.debugLineNum = 3992;BA.debugLine="lbl_box_title.Text=\"ویرایش مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش مرخصی"));
 }else if((mostCurrent._tabhost1.getCurrentTab()==2)) { 
 //BA.debugLineNum = 3995;BA.debugLine="pan_add_taradod_Click";
_pan_add_taradod_click();
 //BA.debugLineNum = 3996;BA.debugLine="lbl_box_title.Text=\"ویرایش تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش تردد"));
 //BA.debugLineNum = 3998;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3999;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4001;BA.debugLine="myfunc.help_man(\"توجه\",\"اگر برای این تردد اضافه";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اگر برای این تردد اضافه کاری ثبت شده است، لازم است آن را هم ویرایش کنید.");
 }else if((mostCurrent._tabhost1.getCurrentTab()==3)) { 
 //BA.debugLineNum = 4003;BA.debugLine="pan_add_mamoriat_Click";
_pan_add_mamoriat_click();
 //BA.debugLineNum = 4004;BA.debugLine="lbl_box_title.Text=\"ویرایش مأموریت\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش مأموریت"));
 };
 //BA.debugLineNum = 4007;BA.debugLine="is_for_edit=True";
_is_for_edit = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 4008;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4009;BA.debugLine="get_dataEdit_byId(current_id_edit)";
_get_dataedit_byid(_current_id_edit);
 //BA.debugLineNum = 4013;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4014;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 4018;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 4022;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_ezaf_taradod_click() throws Exception{
 //BA.debugLineNum = 1882;BA.debugLine="Private Sub lbl_ezaf_taradod_Click";
 //BA.debugLineNum = 1883;BA.debugLine="If(index_box=2)Then";
if ((_index_box==2)) { 
 //BA.debugLineNum = 1884;BA.debugLine="rsPOP_noe.Show";
mostCurrent._rspop_noe.Show();
 };
 //BA.debugLineNum = 1886;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_khoroj_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 4828;BA.debugLine="Private Sub lbl_finger_fs_khoroj_Click";
 //BA.debugLineNum = 4830;BA.debugLine="If(lbl_finger_fs_khoroj.Tag=0)Then";
if (((mostCurrent._lbl_finger_fs_khoroj.getTag()).equals((Object)(0)))) { 
 //BA.debugLineNum = 4831;BA.debugLine="ToastMessageShow(\"قبلا ثبت شده-برای ثبت دوباره ر";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("قبلا ثبت شده-برای ثبت دوباره روی آن نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
 }else if(((mostCurrent._lbl_finger_fs_khoroj.getTag()).equals((Object)(2)))) { 
 //BA.debugLineNum = 4833;BA.debugLine="ToastMessageShow(\"ابتدا ورود را بزنید\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ابتدا ورود را بزنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 4836;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 4837;BA.debugLine="lbl_tim2.Text=myfunc.fa2en(DateTime.Time(DateTim";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
 //BA.debugLineNum = 4838;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4839;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 4840;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
 //BA.debugLineNum = 4841;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 4842;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_kho";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_khoroj.txt",_ls_khoroj);
 //BA.debugLineNum = 4848;BA.debugLine="lbl_finger_fs_khoroj_time.Text=lbl_date2.Text&\"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date2.getText()+" - "+mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 4849;BA.debugLine="File.WriteString(File.DirInternal,\"finger_vorod_";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt","2");
 //BA.debugLineNum = 4850;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 4851;BA.debugLine="lbl_finger_fs_khoroj.Tag=0";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(0));
 //BA.debugLineNum = 4852;BA.debugLine="ToastMessageShow(\"ثبت زمان خروج\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان خروج"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4853;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 4854;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 4858;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_khoroj_longclick() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 4892;BA.debugLine="Private Sub lbl_finger_fs_khoroj_LongClick";
 //BA.debugLineNum = 4894;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 4895;BA.debugLine="lbl_tim2.Text=myfunc.fa2en(DateTime.Time(DateTim";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
 //BA.debugLineNum = 4896;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4897;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 4898;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
 //BA.debugLineNum = 4899;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 4900;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_kho";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_khoroj.txt",_ls_khoroj);
 //BA.debugLineNum = 4903;BA.debugLine="lbl_finger_fs_khoroj_time.Text=lbl_date2.Text&\"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date2.getText()+" - "+mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 4905;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 4906;BA.debugLine="ToastMessageShow(\"ثبت زمان خروج\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان خروج"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4907;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 4909;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_vorod_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
 //BA.debugLineNum = 4860;BA.debugLine="Private Sub lbl_finger_fs_vorod_Click";
 //BA.debugLineNum = 4862;BA.debugLine="If(lbl_finger_fs_vorod.Tag=0)Then";
if (((mostCurrent._lbl_finger_fs_vorod.getTag()).equals((Object)(0)))) { 
 //BA.debugLineNum = 4863;BA.debugLine="ToastMessageShow(\"قبلا ثبت شده-برای ثبت دوباره ر";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("قبلا ثبت شده-برای ثبت دوباره روی آن نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 4867;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 4868;BA.debugLine="lbl_tim1.Text=myfunc.fa2en(DateTime.Time(DateTim";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
 //BA.debugLineNum = 4869;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4870;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 4871;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
 //BA.debugLineNum = 4872;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 4873;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_vor";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt",_ls_vorod);
 //BA.debugLineNum = 4878;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\" -";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 4879;BA.debugLine="File.WriteString(File.DirInternal,\"finger_vorod_";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt","1");
 //BA.debugLineNum = 4880;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 4881;BA.debugLine="lbl_finger_fs_vorod.Tag=0";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(0));
 //BA.debugLineNum = 4882;BA.debugLine="lbl_finger_fs_khoroj.Tag=1";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(1));
 //BA.debugLineNum = 4883;BA.debugLine="ToastMessageShow(\"ثبت زمان ورود\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان ورود"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 4890;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_fs_vorod_longclick() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
 //BA.debugLineNum = 4911;BA.debugLine="Private Sub lbl_finger_fs_vorod_LongClick";
 //BA.debugLineNum = 4912;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 4913;BA.debugLine="lbl_tim1.Text=myfunc.fa2en(DateTime.Time(DateTime";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
 //BA.debugLineNum = 4914;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4915;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 4916;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
 //BA.debugLineNum = 4917;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 4918;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_voro";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt",_ls_vorod);
 //BA.debugLineNum = 4922;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\" -";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 4924;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 4925;BA.debugLine="ToastMessageShow(\"ثبت زمان ورود\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان ورود"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4926;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 4928;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_khoroj_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 4537;BA.debugLine="Private Sub lbl_finger_khoroj_Click";
 //BA.debugLineNum = 4538;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 4539;BA.debugLine="lbl_tim2.Text=myfunc.fa2en(DateTime.Time(DateTime";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
 //BA.debugLineNum = 4542;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4543;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 4544;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
 //BA.debugLineNum = 4545;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 4547;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
 //BA.debugLineNum = 4549;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_ezafek";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt",_ls_khoroj);
 break; }
case 2: {
 //BA.debugLineNum = 4551;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_morakh";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt",_ls_khoroj);
 break; }
case 3: {
 //BA.debugLineNum = 4553;BA.debugLine="File.WriteList(File.DirInternal,\"temp_khoroj_ta";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt",_ls_khoroj);
 break; }
case 5: {
 //BA.debugLineNum = 4556;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_mamori";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt",_ls_khoroj);
 break; }
}
;
 //BA.debugLineNum = 4560;BA.debugLine="ToastMessageShow(\"ثبت زمان 2\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان 2"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4561;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 4562;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_finger_vorod_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
 //BA.debugLineNum = 4505;BA.debugLine="Private Sub lbl_finger_vorod_Click";
 //BA.debugLineNum = 4506;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 4507;BA.debugLine="lbl_tim1.Text=myfunc.fa2en(DateTime.Time(DateTime";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow()).substring((int) (0),(int) (5)))));
 //BA.debugLineNum = 4510;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4511;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 4512;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
 //BA.debugLineNum = 4513;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 4516;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
 //BA.debugLineNum = 4518;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_ezaf";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt",_ls_vorod);
 break; }
case 2: {
 //BA.debugLineNum = 4520;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_mora";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt",_ls_vorod);
 break; }
case 3: {
 //BA.debugLineNum = 4522;BA.debugLine="File.WriteList(File.DirInternal,\"temp_vorod_tar";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt",_ls_vorod);
 break; }
case 5: {
 //BA.debugLineNum = 4526;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_mamo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt",_ls_vorod);
 break; }
}
;
 //BA.debugLineNum = 4533;BA.debugLine="ToastMessageShow(\"ثبت زمان 1\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ثبت زمان 1"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4534;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 4535;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_click() throws Exception{
 //BA.debugLineNum = 3883;BA.debugLine="Private Sub lbl_help_Click";
 //BA.debugLineNum = 3886;BA.debugLine="bit_img0.Initialize(File.DirAssets,\"home-h0.jpg\")";
mostCurrent._bit_img0.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h0.jpg");
 //BA.debugLineNum = 3887;BA.debugLine="bit_img1.Initialize(File.DirAssets,\"home-h1.jpg\")";
mostCurrent._bit_img1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h1.jpg");
 //BA.debugLineNum = 3888;BA.debugLine="bit_img2.Initialize(File.DirAssets,\"home-h2.jpg\")";
mostCurrent._bit_img2.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h2.jpg");
 //BA.debugLineNum = 3889;BA.debugLine="bit_img3.Initialize(File.DirAssets,\"home-h3.jpg\")";
mostCurrent._bit_img3.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h3.jpg");
 //BA.debugLineNum = 3890;BA.debugLine="bit_img4.Initialize(File.DirAssets,\"home-h4.jpg\")";
mostCurrent._bit_img4.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h4.jpg");
 //BA.debugLineNum = 3893;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 //BA.debugLineNum = 3894;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 //BA.debugLineNum = 3895;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3897;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_piker_click() throws Exception{
 //BA.debugLineNum = 4226;BA.debugLine="Private Sub lbl_help_piker_Click";
 //BA.debugLineNum = 4228;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 //BA.debugLineNum = 4230;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
 //BA.debugLineNum = 4231;BA.debugLine="lbl_close_help.Visible=False";
mostCurrent._lbl_close_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4232;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 4234;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_saatkari_inweek_click() throws Exception{
 //BA.debugLineNum = 4976;BA.debugLine="Private Sub lbl_help_saatKari_inWeek_Click";
 //BA.debugLineNum = 4977;BA.debugLine="myfunc.help_man(\"راهنما\",\"اگر در روزهای هفته ساعت";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","اگر در روزهای هفته ساعت کاری مختلف دارید آنها را تنظیم کنید تا در موقع ثبت تردد با آن حساب شود. ");
 //BA.debugLineNum = 4978;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_setting_finger_click() throws Exception{
 //BA.debugLineNum = 4961;BA.debugLine="Private Sub lbl_help_setting_finger_Click";
 //BA.debugLineNum = 4962;BA.debugLine="myfunc.help_man(\"راهنما\",\"با فعال کردن این گزینه";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","با فعال کردن این گزینه ثبت ترددها به انگشتی انجام میشود . به این صورت که در موقع ورود و خروج انگشت میزنیم تا زمان ثبت شود و در آخر ذخیره میکنیم.");
 //BA.debugLineNum = 4963;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_tatil_garardadi_click() throws Exception{
 //BA.debugLineNum = 4970;BA.debugLine="Private Sub lbl_help_tatil_garardadi_Click";
 //BA.debugLineNum = 4971;BA.debugLine="myfunc.help_man(\"راهنما\",\"تردد در روزهای تعطیل قر";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","تردد در روزهای تعطیل قراردادی اضافه کاری محسوب شود- برای تعین روزها به عنوان تعطیل قراردادی در صفحه تقویم روی هر روز انگشت خود را نگه دارید و بعد تیک تعطیل قراردادی را بزنید. ");
 //BA.debugLineNum = 4972;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_tatil_rasmi_click() throws Exception{
 //BA.debugLineNum = 4966;BA.debugLine="Private Sub lbl_help_tatil_rasmi_Click";
 //BA.debugLineNum = 4967;BA.debugLine="myfunc.help_man(\"راهنما\",\"تردد در روزهای تعطیل رس";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","تردد در روزهای تعطیل رسمی و جمعه ها اضافه کاری محسوب شوند.");
 //BA.debugLineNum = 4968;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help2_click() throws Exception{
 //BA.debugLineNum = 4172;BA.debugLine="Private Sub lbl_help2_Click";
 //BA.debugLineNum = 4173;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 4174;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_lite_menu_click() throws Exception{
 //BA.debugLineNum = 4267;BA.debugLine="Private Sub lbl_lite_menu_Click";
 //BA.debugLineNum = 4268;BA.debugLine="pan_all_liteMenu.Visible=True";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 4269;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_notefi_click() throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _html = null;
int _i = 0;
 //BA.debugLineNum = 708;BA.debugLine="Private Sub lbl_notefi_Click";
 //BA.debugLineNum = 709;BA.debugLine="lbl_title_msgPan.Text=\"پیام ها\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام ها"));
 //BA.debugLineNum = 710;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 711;BA.debugLine="pan_notif.Top=10%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 712;BA.debugLine="pan_notif.Height=70%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 713;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
 //BA.debugLineNum = 716;BA.debugLine="Dim html As StringBuilder";
_html = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 717;BA.debugLine="html.Initialize";
_html.Initialize();
 //BA.debugLineNum = 719;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1"))) { 
 //BA.debugLineNum = 721;BA.debugLine="html.Append(\"<!DOCTYPE html><html><meta charset=";
_html.Append("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'>");
 //BA.debugLineNum = 722;BA.debugLine="For i = ls1.Size-1 To 0 Step -1";
{
final int step10 = -1;
final int limit10 = (int) (0);
_i = (int) (mostCurrent._ls1.getSize()-1) ;
for (;_i >= limit10 ;_i = _i + step10 ) {
 //BA.debugLineNum = 723;BA.debugLine="html.Append(\"<div style='background-color: #99f";
_html.Append("<div style='background-color: #99ffff; font-size: 13px;'>"+"کد پیام : "+BA.ObjectToString(mostCurrent._ls1.Get(_i))+" - مورخ : "+BA.ObjectToString(mostCurrent._ls3.Get(_i))+"</div><div style='background-color: #e6ffff; font-size: 16px;'><br>"+BA.ObjectToString(mostCurrent._ls2.Get(_i))).Append("<br></div><br>");
 }
};
 //BA.debugLineNum = 725;BA.debugLine="html.Append(\"</body></html>\")";
_html.Append("</body></html>");
 //BA.debugLineNum = 728;BA.debugLine="web_msg_show.LoadHtml(html.ToString)";
mostCurrent._web_msg_show.LoadHtml(_html.ToString());
 }else {
 //BA.debugLineNum = 731;BA.debugLine="web_msg_show.LoadHtml(\"<html><body dir='rtl'>لیس";
mostCurrent._web_msg_show.LoadHtml("<html><body dir='rtl'>لیست پیام خالی ... </body></html>");
 };
 //BA.debugLineNum = 735;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
 //BA.debugLineNum = 4084;BA.debugLine="Private Sub lbl_remove_from_list_Click";
 //BA.debugLineNum = 4086;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 4087;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 4089;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
 //BA.debugLineNum = 4090;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 4091;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 4092;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 4094;BA.debugLine="If (dbCode.delete_ezafekari(b.Tag))Then";
if ((mostCurrent._dbcode._delete_ezafekari /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 4095;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4097;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
 //BA.debugLineNum = 4100;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else if((mostCurrent._tabhost1.getCurrentTab()==1)) { 
 //BA.debugLineNum = 4105;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 4106;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 4107;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 4109;BA.debugLine="If (dbCode.delete_morakhasi(b.Tag))Then";
if ((mostCurrent._dbcode._delete_morakhasi /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 4110;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4111;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
 //BA.debugLineNum = 4112;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else if((mostCurrent._tabhost1.getCurrentTab()==2)) { 
 //BA.debugLineNum = 4117;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 4118;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 4119;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 4121;BA.debugLine="If (dbCode.delete_taradod(b.Tag))Then";
if ((mostCurrent._dbcode._delete_taradod /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 4122;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4124;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
 //BA.debugLineNum = 4125;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 }else if((mostCurrent._tabhost1.getCurrentTab()==3)) { 
 //BA.debugLineNum = 4130;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 4131;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 4132;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 4134;BA.debugLine="If (dbCode.delete_mamoriat(b.Tag))Then";
if ((mostCurrent._dbcode._delete_mamoriat /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 4135;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4137;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
 //BA.debugLineNum = 4138;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
 };
 //BA.debugLineNum = 4148;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list2_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
 //BA.debugLineNum = 4151;BA.debugLine="Private Sub lbl_remove_from_list2_Click";
 //BA.debugLineNum = 4152;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 4153;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 4156;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 4157;BA.debugLine="result = Msgbox2(\"آیا این گزارش حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این گزارش حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 4158;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 4160;BA.debugLine="If (dbCode.delete_gozaresh(b.tag))Then";
if ((mostCurrent._dbcode._delete_gozaresh /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 4161;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4162;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedI";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
 };
 };
 //BA.debugLineNum = 4167;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_rest_finger_fs_taradod_click() throws Exception{
 //BA.debugLineNum = 4930;BA.debugLine="Private Sub lbl_rest_finger_fs_taradod_Click";
 //BA.debugLineNum = 4931;BA.debugLine="lbl_finger_fs_vorod_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(" - "));
 //BA.debugLineNum = 4932;BA.debugLine="lbl_finger_fs_khoroj_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(" - "));
 //BA.debugLineNum = 4934;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 4935;BA.debugLine="lbl_time_show_fs.Text=\"\"";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 4937;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 4938;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 4939;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4940;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4941;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4942;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4944;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 4945;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 4947;BA.debugLine="lbl_finger_fs_vorod.Tag=1";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(1));
 //BA.debugLineNum = 4948;BA.debugLine="lbl_finger_fs_khoroj.Tag=2";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(2));
 //BA.debugLineNum = 4949;BA.debugLine="File.WriteString(File.DirInternal,\"finger_vorod_t";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt","0");
 //BA.debugLineNum = 4950;BA.debugLine="save_box_allow=False";
_save_box_allow = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 4951;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_box_click() throws Exception{
 //BA.debugLineNum = 2325;BA.debugLine="Private Sub lbl_save_box_Click";
 //BA.debugLineNum = 2327;BA.debugLine="If(save_box_allow=False)Then";
if ((_save_box_allow==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2328;BA.debugLine="ToastMessageShow(\"ورود یا خروج ناقص است.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ورود یا خروج ناقص است."),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 2330;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 2331;BA.debugLine="add_end";
_add_end();
 };
 //BA.debugLineNum = 2336;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
String _value = "";
String _value1 = "";
String _value2 = "";
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 3592;BA.debugLine="Private Sub lbl_save_picker_Click";
 //BA.debugLineNum = 3594;BA.debugLine="Dim value As String";
_value = "";
 //BA.debugLineNum = 3595;BA.debugLine="value=pik_hour1.Text";
_value = mostCurrent._pik_hour1.getText();
 //BA.debugLineNum = 3596;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(value)";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_value)))));
 //BA.debugLineNum = 3599;BA.debugLine="Dim value1 As String";
_value1 = "";
 //BA.debugLineNum = 3600;BA.debugLine="value1=pik_min1.Text";
_value1 = mostCurrent._pik_min1.getText();
 //BA.debugLineNum = 3601;BA.debugLine="pik_min1.Text=myfunc.convert_adad(value1)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_value1)))));
 //BA.debugLineNum = 3604;BA.debugLine="Dim value2 As String";
_value2 = "";
 //BA.debugLineNum = 3605;BA.debugLine="value2=pik_day1.Text";
_value2 = mostCurrent._pik_day1.getText();
 //BA.debugLineNum = 3606;BA.debugLine="pik_day1.Text=myfunc.convert_adad(value2)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_value2)))));
 //BA.debugLineNum = 3607;BA.debugLine="pik_moon1.Tag=myfunc.convert_adad(pik_moon1.Tag)";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))));
 //BA.debugLineNum = 3612;BA.debugLine="If(index_piker=1)Then  'date1";
if ((_index_piker==1)) { 
 //BA.debugLineNum = 3615;BA.debugLine="lbl_tim1.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
 //BA.debugLineNum = 3616;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
 //BA.debugLineNum = 3618;BA.debugLine="If (is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 3620;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 3621;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 3622;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_date1.getText()));
 //BA.debugLineNum = 3623;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
_ls_vorod.Add((Object)(mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 3625;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
 //BA.debugLineNum = 3627;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_ez";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt",_ls_vorod);
 break; }
case 2: {
 //BA.debugLineNum = 3629;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_mo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt",_ls_vorod);
 break; }
case 3: {
 //BA.debugLineNum = 3631;BA.debugLine="File.WriteList(File.DirInternal,\"temp_vorod_t";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt",_ls_vorod);
 break; }
case 5: {
 //BA.debugLineNum = 3633;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_ma";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt",_ls_vorod);
 break; }
}
;
 };
 //BA.debugLineNum = 3641;BA.debugLine="state_tatil= chek_tatil_day(myfunc.fa2en(pik_yea";
_state_tatil = _chek_tatil_day((int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText()))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag())))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText()))));
 //BA.debugLineNum = 3642;BA.debugLine="state_tatil_setting = chek_tatil_setting";
_state_tatil_setting = _chek_tatil_setting();
 //BA.debugLineNum = 3644;BA.debugLine="day_inWeek_id=what_day(myfunc.fa2en(pik_year1.Te";
_day_inweek_id = _what_day((int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText()))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag())))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText()))));
 //BA.debugLineNum = 3647;BA.debugLine="If(state_tatil=0)Then";
if ((_state_tatil==0)) { 
 //BA.debugLineNum = 3648;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+""));
 }else if((_state_tatil==1)) { 
 //BA.debugLineNum = 3650;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل رس";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+" (تعطیل رسمی)"));
 }else if((_state_tatil==2)) { 
 //BA.debugLineNum = 3652;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل قر";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+" (تعطیل قراردادی)"));
 };
 //BA.debugLineNum = 3658;BA.debugLine="If (index_box <> 3) Then";
if ((_index_box!=3)) { 
 //BA.debugLineNum = 3659;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
 };
 }else if((_index_piker==2)) { 
 //BA.debugLineNum = 3665;BA.debugLine="lbl_tim2.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
 //BA.debugLineNum = 3666;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
 //BA.debugLineNum = 3669;BA.debugLine="If (is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 3671;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 3672;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 3673;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_date2.getText()));
 //BA.debugLineNum = 3674;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
_ls_khoroj.Add((Object)(mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 3676;BA.debugLine="Select index_box";
switch (_index_box) {
case 1: {
 //BA.debugLineNum = 3678;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_ezaf";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt",_ls_khoroj);
 break; }
case 2: {
 //BA.debugLineNum = 3680;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_mora";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt",_ls_khoroj);
 break; }
case 3: {
 //BA.debugLineNum = 3682;BA.debugLine="File.WriteList(File.DirInternal,\"temp_khoroj_";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt",_ls_khoroj);
 break; }
case 5: {
 //BA.debugLineNum = 3684;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_mamo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt",_ls_khoroj);
 break; }
}
;
 };
 };
 //BA.debugLineNum = 3694;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3695;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 3696;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_setting_date_click() throws Exception{
 //BA.debugLineNum = 4768;BA.debugLine="Private Sub lbl_save_setting_date_Click";
 //BA.debugLineNum = 4772;BA.debugLine="If(ckb_setting_date_finger.Checked=True)Then";
if ((mostCurrent._ckb_setting_date_finger.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 4773;BA.debugLine="dbCode.update_setting_byname(\"setting_finger_mod";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode",BA.NumberToString(1));
 //BA.debugLineNum = 4774;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
 //BA.debugLineNum = 4775;BA.debugLine="pan_finger_taradod.Visible=True";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 4777;BA.debugLine="dbCode.update_setting_byname(\"setting_finger_mod";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode",BA.NumberToString(0));
 //BA.debugLineNum = 4778;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4779;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
 //BA.debugLineNum = 4780;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 4783;BA.debugLine="If(ckb_tatil_rasmi.Checked=True)Then";
if ((mostCurrent._ckb_tatil_rasmi.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 4784;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_rasm";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi",BA.NumberToString(1));
 }else {
 //BA.debugLineNum = 4786;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_rasm";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi",BA.NumberToString(0));
 };
 //BA.debugLineNum = 4789;BA.debugLine="If(ckb_tatil_garardadi.Checked=True)Then";
if ((mostCurrent._ckb_tatil_garardadi.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 4790;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_gara";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi",BA.NumberToString(1));
 }else {
 //BA.debugLineNum = 4792;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_gara";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi",BA.NumberToString(0));
 };
 //BA.debugLineNum = 4797;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Shanbe\",((";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Shanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari0.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari0.getText())));
 //BA.debugLineNum = 4798;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Yekshanbe\"";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Yekshanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari1.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari1.getText())));
 //BA.debugLineNum = 4799;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Doshanbe\",";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Doshanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari2.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari2.getText())));
 //BA.debugLineNum = 4800;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Seshanbe\",";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Seshanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari3.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari3.getText())));
 //BA.debugLineNum = 4801;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Charshanbe";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Charshanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari4.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari4.getText())));
 //BA.debugLineNum = 4802;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Panjshanbe";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Panjshanbe",BA.NumberToString(((_validat_et_saatkari(mostCurrent._et_saat_kari5.getText()))*60)+_validat_et_saatkari(mostCurrent._et_min_kari5.getText())));
 //BA.debugLineNum = 4810;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4811;BA.debugLine="pan_all_setting_date.Visible=False";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4812;BA.debugLine="pan_all_Click";
_pan_all_click();
 //BA.debugLineNum = 4813;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_setting_date_click() throws Exception{
int _res_val2 = 0;
int _res_tatil_rasmi = 0;
int _res_tatil_garardadi = 0;
int _minroz_0 = 0;
int _minroz_1 = 0;
int _minroz_2 = 0;
int _minroz_3 = 0;
int _minroz_4 = 0;
int _minroz_5 = 0;
 //BA.debugLineNum = 4693;BA.debugLine="Private Sub lbl_setting_date_Click";
 //BA.debugLineNum = 4695;BA.debugLine="Try";
try { //BA.debugLineNum = 4697;BA.debugLine="Dim res_val2 As Int =dbCode.get_setting_byName(\"";
_res_val2 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode")));
 //BA.debugLineNum = 4698;BA.debugLine="If(res_val2=0)Then";
if ((_res_val2==0)) { 
 //BA.debugLineNum = 4699;BA.debugLine="ckb_setting_date_finger.Checked=False";
mostCurrent._ckb_setting_date_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 4701;BA.debugLine="ckb_setting_date_finger.Checked=True";
mostCurrent._ckb_setting_date_finger.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 4704;BA.debugLine="Dim res_tatil_rasmi As Int =dbCode.get_setting_b";
_res_tatil_rasmi = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_rasmi")));
 //BA.debugLineNum = 4705;BA.debugLine="If(res_tatil_rasmi=0)Then";
if ((_res_tatil_rasmi==0)) { 
 //BA.debugLineNum = 4706;BA.debugLine="ckb_tatil_rasmi.Checked=False";
mostCurrent._ckb_tatil_rasmi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 4708;BA.debugLine="ckb_tatil_rasmi.Checked=True";
mostCurrent._ckb_tatil_rasmi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 4711;BA.debugLine="Dim res_tatil_garardadi As Int =dbCode.get_setti";
_res_tatil_garardadi = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_tatil_garardadi")));
 //BA.debugLineNum = 4712;BA.debugLine="If(res_tatil_garardadi=0)Then";
if ((_res_tatil_garardadi==0)) { 
 //BA.debugLineNum = 4713;BA.debugLine="ckb_tatil_garardadi.Checked=False";
mostCurrent._ckb_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 4715;BA.debugLine="ckb_tatil_garardadi.Checked=True";
mostCurrent._ckb_tatil_garardadi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 4719;BA.debugLine="Dim minRoz_0 , minRoz_1, minRoz_2, minRoz_3, min";
_minroz_0 = 0;
_minroz_1 = 0;
_minroz_2 = 0;
_minroz_3 = 0;
_minroz_4 = 0;
_minroz_5 = (int) (0);
 //BA.debugLineNum = 4720;BA.debugLine="minRoz_0=dbCode.get_setting_byName(\"saat_kar_Sha";
_minroz_0 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Shanbe")));
 //BA.debugLineNum = 4721;BA.debugLine="minRoz_1=dbCode.get_setting_byName(\"saat_kar_Yek";
_minroz_1 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Yekshanbe")));
 //BA.debugLineNum = 4722;BA.debugLine="minRoz_2=dbCode.get_setting_byName(\"saat_kar_Dos";
_minroz_2 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Doshanbe")));
 //BA.debugLineNum = 4723;BA.debugLine="minRoz_3=dbCode.get_setting_byName(\"saat_kar_Ses";
_minroz_3 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Seshanbe")));
 //BA.debugLineNum = 4724;BA.debugLine="minRoz_4=dbCode.get_setting_byName(\"saat_kar_Cha";
_minroz_4 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Charshanbe")));
 //BA.debugLineNum = 4725;BA.debugLine="minRoz_5=dbCode.get_setting_byName(\"saat_kar_Pan";
_minroz_5 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_Panjshanbe")));
 //BA.debugLineNum = 4729;BA.debugLine="et_saat_kari0.Text=myfunc.strTOint(minRoz_0/60)";
mostCurrent._et_saat_kari0.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_0/(double)60))));
 //BA.debugLineNum = 4730;BA.debugLine="et_min_kari0.Text=myfunc.strTOint(minRoz_0 Mod 6";
mostCurrent._et_min_kari0.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_0%60))));
 //BA.debugLineNum = 4732;BA.debugLine="et_saat_kari1.Text=myfunc.strTOint(minRoz_1/60)";
mostCurrent._et_saat_kari1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_1/(double)60))));
 //BA.debugLineNum = 4733;BA.debugLine="et_min_kari1.Text=myfunc.strTOint(minRoz_1 Mod 6";
mostCurrent._et_min_kari1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_1%60))));
 //BA.debugLineNum = 4735;BA.debugLine="et_saat_kari2.Text=myfunc.strTOint(minRoz_2/60)";
mostCurrent._et_saat_kari2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_2/(double)60))));
 //BA.debugLineNum = 4736;BA.debugLine="et_min_kari2.Text=myfunc.strTOint(minRoz_2 Mod 6";
mostCurrent._et_min_kari2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_2%60))));
 //BA.debugLineNum = 4738;BA.debugLine="et_saat_kari3.Text=myfunc.strTOint(minRoz_3/60)";
mostCurrent._et_saat_kari3.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_3/(double)60))));
 //BA.debugLineNum = 4739;BA.debugLine="et_min_kari3.Text=myfunc.strTOint(minRoz_3 Mod 6";
mostCurrent._et_min_kari3.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_3%60))));
 //BA.debugLineNum = 4741;BA.debugLine="et_saat_kari4.Text=myfunc.strTOint(minRoz_4/60)";
mostCurrent._et_saat_kari4.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_4/(double)60))));
 //BA.debugLineNum = 4742;BA.debugLine="et_min_kari4.Text=myfunc.strTOint(minRoz_4 Mod 6";
mostCurrent._et_min_kari4.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_4%60))));
 //BA.debugLineNum = 4744;BA.debugLine="et_saat_kari5.Text=myfunc.strTOint(minRoz_5/60)";
mostCurrent._et_saat_kari5.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_5/(double)60))));
 //BA.debugLineNum = 4745;BA.debugLine="et_min_kari5.Text=myfunc.strTOint(minRoz_5 Mod 6";
mostCurrent._et_min_kari5.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._strtoint /*int*/ (mostCurrent.activityBA,BA.NumberToString(_minroz_5%60))));
 //BA.debugLineNum = 4750;BA.debugLine="pan_all_setting_date.Visible=True";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
 } 
       catch (Exception e41) {
			processBA.setLastException(e41); //BA.debugLineNum = 4756;BA.debugLine="ScrollView_sett_taradod.Panel.LoadLayout(\"item_s";
mostCurrent._scrollview_sett_taradod.getPanel().LoadLayout("item_settingTaradod_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 4757;BA.debugLine="lbl_setting_date_Click";
_lbl_setting_date_click();
 //BA.debugLineNum = 4758;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("79371713",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 4762;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_app_click() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _i = null;
 //BA.debugLineNum = 4381;BA.debugLine="Private Sub lbl_share_app_Click";
 //BA.debugLineNum = 4382;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 4383;BA.debugLine="i.Initialize(i.ACTION_SEND, \"\")";
_i.Initialize(_i.ACTION_SEND,"");
 //BA.debugLineNum = 4384;BA.debugLine="i.SetType(\"text/plain\")";
_i.SetType("text/plain");
 //BA.debugLineNum = 4385;BA.debugLine="i.PutExtra(\"android.intent.extra.TEXT\", \"https://";
_i.PutExtra("android.intent.extra.TEXT",(Object)("https://cafebazaar.ir/app/ir.taravatgroup.ezafekari2"));
 //BA.debugLineNum = 4386;BA.debugLine="i.WrapAsIntentChooser(\"انتخاب کنید\")";
_i.WrapAsIntentChooser("انتخاب کنید");
 //BA.debugLineNum = 4387;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_i.getObject()));
 //BA.debugLineNum = 4388;BA.debugLine="pan_all_liteMenu_Click";
_pan_all_litemenu_click();
 //BA.debugLineNum = 4389;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 4564;BA.debugLine="Private Sub lbl_share_Click";
 //BA.debugLineNum = 4566;BA.debugLine="Dim str_file_matn As StringBuilder";
_str_file_matn = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 4567;BA.debugLine="str_file_matn.Initialize";
_str_file_matn.Initialize();
 //BA.debugLineNum = 4568;BA.debugLine="Dim name_gozaresh As String=\"\"";
_name_gozaresh = "";
 //BA.debugLineNum = 4569;BA.debugLine="Dim name_gozaresh_en As String=\"\"";
_name_gozaresh_en = "";
 //BA.debugLineNum = 4571;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 4573;BA.debugLine="Select TabHost1.CurrentTab";
switch (BA.switchObjectToInt(mostCurrent._tabhost1.getCurrentTab(),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
 //BA.debugLineNum = 4576;BA.debugLine="name_gozaresh=\"اضافه کاری ها-\"";
_name_gozaresh = "اضافه کاری ها-";
 //BA.debugLineNum = 4577;BA.debugLine="name_gozaresh_en=\"ezafekari\"";
_name_gozaresh_en = "ezafekari";
 //BA.debugLineNum = 4578;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
case 1: {
 //BA.debugLineNum = 4581;BA.debugLine="name_gozaresh=\"مرخصی ها-\"";
_name_gozaresh = "مرخصی ها-";
 //BA.debugLineNum = 4582;BA.debugLine="name_gozaresh_en=\"morakhasi\"";
_name_gozaresh_en = "morakhasi";
 //BA.debugLineNum = 4583;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
case 2: {
 //BA.debugLineNum = 4586;BA.debugLine="name_gozaresh=\"ترددها-\"";
_name_gozaresh = "ترددها-";
 //BA.debugLineNum = 4587;BA.debugLine="name_gozaresh_en=\"taradod\"";
_name_gozaresh_en = "taradod";
 //BA.debugLineNum = 4588;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
case 3: {
 //BA.debugLineNum = 4591;BA.debugLine="name_gozaresh=\"مأموریت ها-\"";
_name_gozaresh = "مأموریت ها-";
 //BA.debugLineNum = 4592;BA.debugLine="name_gozaresh_en=\"mamoriat\"";
_name_gozaresh_en = "mamoriat";
 //BA.debugLineNum = 4593;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+"%' ORDER BY  date_from DESC;")));
 break; }
}
;
 //BA.debugLineNum = 4601;BA.debugLine="str_file_matn.Append(\"<!DOCTYPE html><html dir='r";
_str_file_matn.Append("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>");
 //BA.debugLineNum = 4602;BA.debugLine="str_file_matn.Append(\"<style>table , td {border:";
_str_file_matn.Append("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	</style>");
 //BA.debugLineNum = 4604;BA.debugLine="str_file_matn.Append(\"<h3>\").Append(\" گزارش \"&nam";
_str_file_matn.Append("<h3>").Append(" گزارش "+_name_gozaresh+mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())).Append("</h3>");
 //BA.debugLineNum = 4610;BA.debugLine="str_file_matn.Append(\"نام کاربر :\").Append(\"<span";
_str_file_matn.Append("نام کاربر :").Append("<span> "+_user_namefamili+"</span>").Append("<br>");
 //BA.debugLineNum = 4612;BA.debugLine="str_file_matn.Append(\"<div style=' background-col";
_str_file_matn.Append("<div style=' background-color: #f5f5f5;'>");
 //BA.debugLineNum = 4615;BA.debugLine="str_file_matn.Append(\"<table style='width:100%;'>";
_str_file_matn.Append("<table style='width:100%;'><tr style='text-align: center;'>");
 //BA.debugLineNum = 4616;BA.debugLine="str_file_matn.Append(\"<td><b> ردیف</b></td><td><b";
_str_file_matn.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td><br></tr>");
 //BA.debugLineNum = 4618;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 4619;BA.debugLine="str_file_matn.Append(\"<tr style='text-align: cen";
_str_file_matn.Append("<tr style='text-align: center;'>");
 //BA.debugLineNum = 4620;BA.debugLine="str_file_matn.Append(\"<td>\").Append(myfunc.en2fa";
_str_file_matn.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
 //BA.debugLineNum = 4621;BA.debugLine="str_file_matn.Append(\"<td>\").Append(myfunc.en2fa";
_str_file_matn.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
 //BA.debugLineNum = 4622;BA.debugLine="str_file_matn.Append(\"<td>\").Append(myfunc.en2fa";
_str_file_matn.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
 //BA.debugLineNum = 4624;BA.debugLine="str_file_matn.Append(\"<td>\")";
_str_file_matn.Append("<td>");
 //BA.debugLineNum = 4627;BA.debugLine="Dim ls_ezafe As List";
_ls_ezafe = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4628;BA.debugLine="ls_ezafe.Initialize";
_ls_ezafe.Initialize();
 //BA.debugLineNum = 4630;BA.debugLine="If( TabHost1.CurrentTab=0 Or  TabHost1.CurrentTa";
if ((mostCurrent._tabhost1.getCurrentTab()==0 || mostCurrent._tabhost1.getCurrentTab()==2)) { 
 //BA.debugLineNum = 4631;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz2_dontDay(dbCo";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 }else {
 //BA.debugLineNum = 4633;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz(dbCode.res.Ge";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 //BA.debugLineNum = 4634;BA.debugLine="str_file_matn.Append(ls_ezafe.Get(2))";
_str_file_matn.Append(BA.ObjectToString(_ls_ezafe.Get((int) (2))));
 //BA.debugLineNum = 4635;BA.debugLine="str_file_matn.Append(\":\")";
_str_file_matn.Append(":");
 };
 //BA.debugLineNum = 4643;BA.debugLine="str_file_matn.Append(ls_ezafe.Get(0))";
_str_file_matn.Append(BA.ObjectToString(_ls_ezafe.Get((int) (0))));
 //BA.debugLineNum = 4644;BA.debugLine="str_file_matn.Append(\":\")";
_str_file_matn.Append(":");
 //BA.debugLineNum = 4645;BA.debugLine="str_file_matn.Append(ls_ezafe.Get(1)).Append(\"</t";
_str_file_matn.Append(BA.ObjectToString(_ls_ezafe.Get((int) (1)))).Append("</td>");
 //BA.debugLineNum = 4647;BA.debugLine="str_file_matn.Append(\"</tr>\")";
_str_file_matn.Append("</tr>");
 }
;
 //BA.debugLineNum = 4651;BA.debugLine="str_file_matn.Append(\"</table>\")";
_str_file_matn.Append("</table>");
 //BA.debugLineNum = 4652;BA.debugLine="str_file_matn.Append(\"مجموع ساعت  :<span style='co";
_str_file_matn.Append("مجموع ساعت  :<span style='color:#5E35B1;'> "+mostCurrent._lbl_majmoe_saat.getText()+" </span><br></div><br> ");
 //BA.debugLineNum = 4658;BA.debugLine="str_file_matn.Append(\"<br></details></div>\")";
_str_file_matn.Append("<br></details></div>");
 //BA.debugLineNum = 4660;BA.debugLine="str_file_matn.Append(\"<footer style=' text-align:";
_str_file_matn.Append("<footer style=' text-align: center; '><h6> اپلیکیشن اضافه کاری من </h6></footer>");
 //BA.debugLineNum = 4662;BA.debugLine="str_file_matn.Append(\"</body></html>\")";
_str_file_matn.Append("</body></html>");
 //BA.debugLineNum = 4667;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 4668;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 4675;BA.debugLine="Dim FileName As String =name_gozaresh_en&\"-\"&myfu";
_filename = _name_gozaresh_en+"-"+mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1))+".html";
 //BA.debugLineNum = 4678;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
anywheresoftware.b4a.keywords.Common.File.WriteString(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename,_str_file_matn.ToString());
 //BA.debugLineNum = 4680;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
 //BA.debugLineNum = 4681;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
 //BA.debugLineNum = 4682;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
 //BA.debugLineNum = 4683;BA.debugLine="email.Body = \" گزارش  \"&name_gozaresh&CRLF&\"اپلیک";
_email.Body = " گزارش  "+_name_gozaresh+anywheresoftware.b4a.keywords.Common.CRLF+"اپلیکیشن اضافه کاری من"+anywheresoftware.b4a.keywords.Common.CRLF+"دانلود از بازار";
 //BA.debugLineNum = 4684;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (_filename));
 //BA.debugLineNum = 4686;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
 //BA.debugLineNum = 4687;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
 //BA.debugLineNum = 4688;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 //BA.debugLineNum = 4691;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim1_click() throws Exception{
 //BA.debugLineNum = 3568;BA.debugLine="Private Sub lbl_tim1_Click";
 //BA.debugLineNum = 3569;BA.debugLine="index_piker=1";
_index_piker = (int) (1);
 //BA.debugLineNum = 3571;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim1.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (0))));
 //BA.debugLineNum = 3572;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim1.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (1))));
 //BA.debugLineNum = 3574;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date1.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (0))));
 //BA.debugLineNum = 3575;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (1)));
 //BA.debugLineNum = 3576;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 3577;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (2))));
 //BA.debugLineNum = 3581;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3583;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 3584;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 3585;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 //BA.debugLineNum = 3586;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 //BA.debugLineNum = 3587;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
 //BA.debugLineNum = 3590;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim2_click() throws Exception{
 //BA.debugLineNum = 3537;BA.debugLine="Private Sub lbl_tim2_Click";
 //BA.debugLineNum = 3538;BA.debugLine="index_piker=2";
_index_piker = (int) (2);
 //BA.debugLineNum = 3539;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim2.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (0))));
 //BA.debugLineNum = 3540;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim2.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (1))));
 //BA.debugLineNum = 3542;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date2.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (0))));
 //BA.debugLineNum = 3543;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (1)));
 //BA.debugLineNum = 3544;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 3545;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (2))));
 //BA.debugLineNum = 3548;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3551;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 3552;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 3553;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 //BA.debugLineNum = 3554;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 //BA.debugLineNum = 3555;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
 //BA.debugLineNum = 3557;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_click() throws Exception{
 //BA.debugLineNum = 3870;BA.debugLine="Private Sub lbl_vip_Click";
 //BA.debugLineNum = 3872;BA.debugLine="pan_all_noskhe.Visible=True";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3873;BA.debugLine="scroll_v_noskhe.Panel.LoadLayout(\"noske_item\")";
mostCurrent._scroll_v_noskhe.getPanel().LoadLayout("noske_item",mostCurrent.activityBA);
 //BA.debugLineNum = 3875;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 3876;BA.debugLine="lbl_show_vip.Text=\"نسخه کامل ( طلایی ) فعال می ب";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه کامل ( طلایی ) فعال می باشد."));
 }else {
 //BA.debugLineNum = 3878;BA.debugLine="lbl_show_vip.Text=\"نسخه معمولی ( هدیه ) فعال می";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه معمولی ( هدیه ) فعال می باشد."));
 };
 //BA.debugLineNum = 3881;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_later_click() throws Exception{
 //BA.debugLineNum = 4192;BA.debugLine="Private Sub lbl_vip_later_Click";
 //BA.debugLineNum = 4193;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
 //BA.debugLineNum = 4194;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_now_click() throws Exception{
String _title = "";
String _matn = "";
int _result = 0;
 //BA.debugLineNum = 4196;BA.debugLine="Private Sub lbl_vip_now_Click";
 //BA.debugLineNum = 4198;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 4200;BA.debugLine="Dim title , matn As String";
_title = "";
_matn = "";
 //BA.debugLineNum = 4201;BA.debugLine="title=\" تبریک \"";
_title = " تبریک ";
 //BA.debugLineNum = 4202;BA.debugLine="matn=\" شما صاحب نسخه طلایی و بدون محدودیت برنامه";
_matn = " شما صاحب نسخه طلایی و بدون محدودیت برنامه اضافه کاری من می باشید. ";
 //BA.debugLineNum = 4204;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 4205;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Lo";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"باشه","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"buy.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 4206;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
 }else {
 //BA.debugLineNum = 4213;BA.debugLine="kharid";
_kharid();
 };
 //BA.debugLineNum = 4215;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip2_click() throws Exception{
 //BA.debugLineNum = 4176;BA.debugLine="Private Sub lbl_vip2_Click";
 //BA.debugLineNum = 4177;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 //BA.debugLineNum = 4178;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 4286;BA.debugLine="Sub min_between_to_time(dat1 As String,dat2 As Str";
 //BA.debugLineNum = 4289;BA.debugLine="Try";
try { //BA.debugLineNum = 4291;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4292;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 4293;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
 //BA.debugLineNum = 4294;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
 //BA.debugLineNum = 4296;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
 //BA.debugLineNum = 4297;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
 //BA.debugLineNum = 4298;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 4299;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 4308;BA.debugLine="date1=dat1";
mostCurrent._date1 = _dat1;
 //BA.debugLineNum = 4309;BA.debugLine="date2=dat2";
mostCurrent._date2 = _dat2;
 //BA.debugLineNum = 4310;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
 //BA.debugLineNum = 4311;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
 //BA.debugLineNum = 4315;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_da";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
 //BA.debugLineNum = 4316;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_da";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
 //BA.debugLineNum = 4319;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
 //BA.debugLineNum = 4320;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
 //BA.debugLineNum = 4323;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
 //BA.debugLineNum = 4324;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
 //BA.debugLineNum = 4326;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
 //BA.debugLineNum = 4327;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
 //BA.debugLineNum = 4329;BA.debugLine="time_end2=tim2&\":00\"";
_time_end2 = _tim2+":00";
 //BA.debugLineNum = 4330;BA.debugLine="time_end1=tim1&\":00\"";
_time_end1 = _tim1+":00";
 //BA.debugLineNum = 4332;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
 //BA.debugLineNum = 4333;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
 //BA.debugLineNum = 4334;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
 //BA.debugLineNum = 4335;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
 //BA.debugLineNum = 4339;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
 //BA.debugLineNum = 4340;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
 } 
       catch (Exception e31) {
			processBA.setLastException(e31); //BA.debugLineNum = 4345;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 4348;BA.debugLine="Return (period_between.Days*24*60)+(period_betwee";
if (true) return (int) ((_period_between.Days*24*60)+(_period_between.Hours*60)+_period_between.Minutes);
 //BA.debugLineNum = 4349;BA.debugLine="End Sub";
return 0;
}
public static String  _pan_add_ezafekari_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 1908;BA.debugLine="Private Sub pan_add_ezafekari_Click";
 //BA.debugLineNum = 1909;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 1910;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 1911;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1912;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1913;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 1914;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1915;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1917;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1918;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1920;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1921;BA.debugLine="lbl_box_title.Text=\"ثبت اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت اضافه کاری"));
 //BA.debugLineNum = 1922;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
 //BA.debugLineNum = 1923;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
 //BA.debugLineNum = 1924;BA.debugLine="index_box=1";
_index_box = (int) (1);
 //BA.debugLineNum = 1925;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1926;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1927;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1928;BA.debugLine="lbl_ezaf_taradod.Text=\"فوق العاده (جمعه کاری)\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("فوق العاده (جمعه کاری)"));
 //BA.debugLineNum = 1929;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 1930;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1931;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1932;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1937;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
 //BA.debugLineNum = 1938;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
 //BA.debugLineNum = 1939;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 1940;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
 //BA.debugLineNum = 1943;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1944;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1948;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_from_ezafe";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1949;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1950;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 1951;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_f";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_ezafekari.txt");
 //BA.debugLineNum = 1956;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1960;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
 //BA.debugLineNum = 1962;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1963;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 1967;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_to_ezafeka";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1968;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1969;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 1970;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_ezafekari.txt");
 //BA.debugLineNum = 1976;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1980;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
 //BA.debugLineNum = 1982;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1983;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 1988;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1990;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 1993;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_mamoriat_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 2215;BA.debugLine="Private Sub pan_add_mamoriat_Click";
 //BA.debugLineNum = 2216;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 2217;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 2218;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2219;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2220;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 2222;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 2223;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2224;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2226;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2227;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2229;BA.debugLine="lbl_box_title.Text=\"ثبت مأموریت\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت مأموریت"));
 //BA.debugLineNum = 2230;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
 //BA.debugLineNum = 2231;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
 //BA.debugLineNum = 2232;BA.debugLine="index_box=5";
_index_box = (int) (5);
 //BA.debugLineNum = 2233;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2234;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2235;BA.debugLine="lbl_ezaf_taradod.Visible=False";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2238;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2239;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2240;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2245;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
 //BA.debugLineNum = 2246;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
 //BA.debugLineNum = 2247;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 2248;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
 //BA.debugLineNum = 2251;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2252;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2256;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_from_mamori";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2257;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2258;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 2259;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_fr";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_mamoriat.txt");
 //BA.debugLineNum = 2263;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2267;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
 //BA.debugLineNum = 2269;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2270;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 2274;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_to_mamoriat";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2275;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2276;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 2277;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_t";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_mamoriat.txt");
 //BA.debugLineNum = 2281;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2286;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
 //BA.debugLineNum = 2288;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianS";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2289;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 2308;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2310;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 2315;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_morakhasi_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 1781;BA.debugLine="Private Sub pan_add_morakhasi_Click";
 //BA.debugLineNum = 1782;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 1783;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 1784;BA.debugLine="pan_finger_taradod.Visible=False";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1785;BA.debugLine="lbl_setting_date.Visible=False";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1787;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 1789;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1790;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1792;BA.debugLine="radio_ez_adi.Visible=False";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1793;BA.debugLine="radio_ez_fog.Visible=False";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1795;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1796;BA.debugLine="lbl_box_title.Text=\"ثبت مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت مرخصی"));
 //BA.debugLineNum = 1797;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
 //BA.debugLineNum = 1798;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
 //BA.debugLineNum = 1799;BA.debugLine="index_box=2";
_index_box = (int) (2);
 //BA.debugLineNum = 1800;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1801;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1802;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 //BA.debugLineNum = 1803;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1804;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
 //BA.debugLineNum = 1805;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Red";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 1806;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1807;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1812;BA.debugLine="rsPOP_noe.Initialize(\"rsPOP_noe\",lbl_ezaf_taradod";
mostCurrent._rspop_noe.Initialize(mostCurrent.activityBA,"rsPOP_noe",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_ezaf_taradod.getObject())));
 //BA.debugLineNum = 1814;BA.debugLine="rsPOP_noe.AddMenuItem(0,0,\"استحقاقی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (0),(int) (0),"استحقاقی");
 //BA.debugLineNum = 1815;BA.debugLine="rsPOP_noe.AddMenuItem(1,1,\"استعلاجی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (1),(int) (1),"استعلاجی");
 //BA.debugLineNum = 1816;BA.debugLine="rsPOP_noe.AddMenuItem(2,2,\"سایر (با حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (2),(int) (2),"سایر (با حقوق)");
 //BA.debugLineNum = 1817;BA.debugLine="rsPOP_noe.AddMenuItem(3,3,\"سایر (بدون حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (3),(int) (3),"سایر (بدون حقوق)");
 //BA.debugLineNum = 1822;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
 //BA.debugLineNum = 1823;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
 //BA.debugLineNum = 1824;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 1825;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
 //BA.debugLineNum = 1828;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1829;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1835;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_from_morak";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1836;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1837;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 1838;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_f";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_from_morakhasi.txt");
 //BA.debugLineNum = 1843;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1847;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
 //BA.debugLineNum = 1849;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1850;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 1854;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_to_morakha";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1855;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1856;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 1857;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_to_morakhasi.txt");
 //BA.debugLineNum = 1862;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persia";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1866;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
 //BA.debugLineNum = 1868;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1869;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 1874;BA.debugLine="lbl_tatil_show.Text=\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1876;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 1880;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_other_click() throws Exception{
 //BA.debugLineNum = 3533;BA.debugLine="Private Sub pan_add_other_Click";
 //BA.debugLineNum = 3534;BA.debugLine="StartActivity(sabt2_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._sabt2_activity.getObject()));
 //BA.debugLineNum = 3535;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_taradod_click() throws Exception{
int _res_val2 = 0;
String _temp_finger = "";
anywheresoftware.b4a.objects.collections.List _ls_vorod0 = null;
anywheresoftware.b4a.objects.collections.List _ls_vorod1 = null;
anywheresoftware.b4a.objects.collections.List _ls_vorod = null;
anywheresoftware.b4a.objects.collections.List _ls_khoroj = null;
 //BA.debugLineNum = 1995;BA.debugLine="Private Sub pan_add_taradod_Click";
 //BA.debugLineNum = 1998;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1999;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2000;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 2001;BA.debugLine="radio_ez_adi.Visible=True";
mostCurrent._radio_ez_adi.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2002;BA.debugLine="radio_ez_fog.Visible=True";
mostCurrent._radio_ez_fog.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2003;BA.debugLine="radio_ez_adi.Checked=True";
mostCurrent._radio_ez_adi.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2004;BA.debugLine="radio_ez_fog.Checked=False";
mostCurrent._radio_ez_fog.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2006;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2007;BA.debugLine="lbl_box_title.Text=\"ثبت تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت تردد"));
 //BA.debugLineNum = 2008;BA.debugLine="lbl_time_as.Text=\"ورود :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("ورود :"));
 //BA.debugLineNum = 2009;BA.debugLine="lbl_time_ta.Text=\"خروج :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("خروج :"));
 //BA.debugLineNum = 2010;BA.debugLine="index_box=3";
_index_box = (int) (3);
 //BA.debugLineNum = 2011;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2012;BA.debugLine="lbl_time_show_fs.Text=\"\"";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2014;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2015;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2016;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2017;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 2019;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2021;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2022;BA.debugLine="ckb_ezaf_taradod_fs.Checked=True";
mostCurrent._ckb_ezaf_taradod_fs.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2024;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
 //BA.debugLineNum = 2025;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
 //BA.debugLineNum = 2026;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 2027;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
 //BA.debugLineNum = 2030;BA.debugLine="lbl_finger_vorod.Visible=True";
mostCurrent._lbl_finger_vorod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2031;BA.debugLine="lbl_finger_khoroj.Visible=True";
mostCurrent._lbl_finger_khoroj.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2036;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_vorod.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 2037;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
mostCurrent._lbl_finger_khoroj.setTextColor(((int)0xff3b78d5));
 //BA.debugLineNum = 2038;BA.debugLine="lbl_setting_date.Visible=True";
mostCurrent._lbl_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2042;BA.debugLine="state_tatil= chek_tatil_day(myfunc.fa2en(pik_year";
_state_tatil = _chek_tatil_day((int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText()))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag())))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText()))));
 //BA.debugLineNum = 2044;BA.debugLine="state_tatil_setting = chek_tatil_setting";
_state_tatil_setting = _chek_tatil_setting();
 //BA.debugLineNum = 2046;BA.debugLine="day_inWeek_id=what_day(myfunc.fa2en(pik_year1.Tex";
_day_inweek_id = _what_day((int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText()))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag())))),(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText()))));
 //BA.debugLineNum = 2049;BA.debugLine="If(state_tatil=0)Then";
if ((_state_tatil==0)) { 
 //BA.debugLineNum = 2050;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\"\"";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+""));
 }else if((_state_tatil==1)) { 
 //BA.debugLineNum = 2052;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل رسم";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+" (تعطیل رسمی) "));
 }else if((_state_tatil==2)) { 
 //BA.debugLineNum = 2054;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل قرا";
mostCurrent._lbl_tatil_show.setText(BA.ObjectToCharSequence(mostCurrent._day_inweek_name+" (تعطیل قراردادی) "));
 };
 //BA.debugLineNum = 2059;BA.debugLine="Dim res_val2 As Int =dbCode.get_setting_byName(\"s";
_res_val2 = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"setting_finger_mode")));
 //BA.debugLineNum = 2060;BA.debugLine="If(res_val2=1)Then";
if ((_res_val2==1)) { 
 //BA.debugLineNum = 2062;BA.debugLine="pan_finger_taradod.Visible=True";
mostCurrent._pan_finger_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2064;BA.debugLine="lbl_finger_fs_vorod.Typeface=Typeface.MATERIALIC";
mostCurrent._lbl_finger_fs_vorod.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
 //BA.debugLineNum = 2065;BA.debugLine="lbl_finger_fs_khoroj.Typeface=Typeface.MATERIALI";
mostCurrent._lbl_finger_fs_khoroj.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
 //BA.debugLineNum = 2066;BA.debugLine="lbl_finger_fs_vorod.Text=Chr(0xE90D)";
mostCurrent._lbl_finger_fs_vorod.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe90d))));
 //BA.debugLineNum = 2067;BA.debugLine="lbl_finger_fs_khoroj.Text=Chr(0xE90D)";
mostCurrent._lbl_finger_fs_khoroj.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe90d))));
 //BA.debugLineNum = 2069;BA.debugLine="If(File.Exists(File.DirInternal,\"finger_vorod_ta";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2072;BA.debugLine="Dim temp_finger As String = File.readString(Fil";
_temp_finger = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"finger_vorod_taradod_fs.txt");
 //BA.debugLineNum = 2073;BA.debugLine="If(temp_finger=0)Then";
if (((_temp_finger).equals(BA.NumberToString(0)))) { 
 //BA.debugLineNum = 2075;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
_lbl_rest_finger_fs_taradod_click();
 //BA.debugLineNum = 2077;BA.debugLine="save_box_allow=False";
_save_box_allow = anywheresoftware.b4a.keywords.Common.False;
 }else if(((_temp_finger).equals(BA.NumberToString(1)))) { 
 //BA.debugLineNum = 2082;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 2083;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 2085;BA.debugLine="Dim ls_vorod0 As List";
_ls_vorod0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2086;BA.debugLine="ls_vorod0.Initialize";
_ls_vorod0.Initialize();
 //BA.debugLineNum = 2087;BA.debugLine="ls_vorod0=File.ReadList(File.DirInternal,\"temp";
_ls_vorod0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt");
 //BA.debugLineNum = 2089;BA.debugLine="lbl_date1.Text=ls_vorod0.Get(0)";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (0))));
 //BA.debugLineNum = 2090;BA.debugLine="lbl_tim1.Text=ls_vorod0.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (1))));
 //BA.debugLineNum = 2092;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 2094;BA.debugLine="lbl_finger_fs_vorod.Tag=0";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(0));
 //BA.debugLineNum = 2095;BA.debugLine="lbl_finger_fs_khoroj.Tag=1";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(1));
 //BA.debugLineNum = 2097;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2098;BA.debugLine="lbl_time_show_fs.Text=\"\"";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2100;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2101;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 2103;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2104;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2105;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2106;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2110;BA.debugLine="save_box_allow=False";
_save_box_allow = anywheresoftware.b4a.keywords.Common.False;
 }else if(((_temp_finger).equals(BA.NumberToString(2)))) { 
 //BA.debugLineNum = 2114;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 2115;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Green";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 2117;BA.debugLine="Dim ls_vorod0 As List";
_ls_vorod0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2118;BA.debugLine="ls_vorod0.Initialize";
_ls_vorod0.Initialize();
 //BA.debugLineNum = 2119;BA.debugLine="ls_vorod0=File.ReadList(File.DirInternal,\"temp";
_ls_vorod0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_vorod.txt");
 //BA.debugLineNum = 2120;BA.debugLine="lbl_date1.Text=ls_vorod0.Get(0)";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (0))));
 //BA.debugLineNum = 2121;BA.debugLine="lbl_tim1.Text=ls_vorod0.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod0.Get((int) (1))));
 //BA.debugLineNum = 2122;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date1.getText()+" - "+mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 2126;BA.debugLine="Dim ls_vorod1 As List";
_ls_vorod1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2127;BA.debugLine="ls_vorod1.Initialize";
_ls_vorod1.Initialize();
 //BA.debugLineNum = 2128;BA.debugLine="ls_vorod1=File.ReadList(File.DirInternal,\"temp";
_ls_vorod1 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_finger_khoroj.txt");
 //BA.debugLineNum = 2129;BA.debugLine="lbl_date2.Text=ls_vorod1.Get(0)";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(_ls_vorod1.Get((int) (0))));
 //BA.debugLineNum = 2130;BA.debugLine="lbl_tim2.Text=ls_vorod1.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_vorod1.Get((int) (1))));
 //BA.debugLineNum = 2131;BA.debugLine="lbl_finger_fs_khoroj_time.Text=lbl_date2.Text&";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(mostCurrent._lbl_date2.getText()+" - "+mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 2133;BA.debugLine="lbl_finger_fs_vorod.Tag=0";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(0));
 //BA.debugLineNum = 2134;BA.debugLine="lbl_finger_fs_khoroj.Tag=0";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(0));
 //BA.debugLineNum = 2136;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 2138;BA.debugLine="save_box_allow=True";
_save_box_allow = anywheresoftware.b4a.keywords.Common.True;
 };
 }else {
 //BA.debugLineNum = 2141;BA.debugLine="lbl_finger_fs_vorod_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_vorod_time.setText(BA.ObjectToCharSequence(" - "));
 //BA.debugLineNum = 2142;BA.debugLine="lbl_finger_fs_khoroj_time.Text=\" - \"";
mostCurrent._lbl_finger_fs_khoroj_time.setText(BA.ObjectToCharSequence(" - "));
 //BA.debugLineNum = 2143;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_vorod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 2144;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Gray";
mostCurrent._lbl_finger_fs_khoroj.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 2146;BA.debugLine="lbl_finger_fs_vorod.Tag=1";
mostCurrent._lbl_finger_fs_vorod.setTag((Object)(1));
 //BA.debugLineNum = 2147;BA.debugLine="lbl_finger_fs_khoroj.Tag=2";
mostCurrent._lbl_finger_fs_khoroj.setTag((Object)(2));
 };
 }else {
 //BA.debugLineNum = 2155;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_vorod_tara";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2156;BA.debugLine="Dim ls_vorod As List";
_ls_vorod = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2157;BA.debugLine="ls_vorod.Initialize";
_ls_vorod.Initialize();
 //BA.debugLineNum = 2158;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_v";
_ls_vorod = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_vorod_taradod.txt");
 //BA.debugLineNum = 2163;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2166;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_vorod.Get((int) (1))));
 }else {
 //BA.debugLineNum = 2168;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2169;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 2173;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_khoroj_tar";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2174;BA.debugLine="Dim ls_khoroj As List";
_ls_khoroj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2175;BA.debugLine="ls_khoroj.Initialize";
_ls_khoroj.Initialize();
 //BA.debugLineNum = 2176;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_";
_ls_khoroj = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_khoroj_taradod.txt");
 //BA.debugLineNum = 2181;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2186;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_khoroj.Get((int) (1))));
 }else {
 //BA.debugLineNum = 2188;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2189;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 2199;BA.debugLine="time_show";
_time_show();
 };
 //BA.debugLineNum = 2212;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_chekupdate_click() throws Exception{
 //BA.debugLineNum = 4449;BA.debugLine="Private Sub pan_all_chekUpdate_Click";
 //BA.debugLineNum = 4450;BA.debugLine="pan_all_chekUpdate.Visible=False";
mostCurrent._pan_all_chekupdate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4451;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_click() throws Exception{
 //BA.debugLineNum = 2317;BA.debugLine="Private Sub pan_all_Click";
 //BA.debugLineNum = 2318;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2319;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_litemenu_click() throws Exception{
 //BA.debugLineNum = 4271;BA.debugLine="Private Sub pan_all_liteMenu_Click";
 //BA.debugLineNum = 4272;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4273;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_msgnewyear_click() throws Exception{
 //BA.debugLineNum = 489;BA.debugLine="Private Sub pan_all_msgNewYear_Click";
 //BA.debugLineNum = 491;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_noskhe_click() throws Exception{
 //BA.debugLineNum = 4218;BA.debugLine="Private Sub pan_all_noskhe_Click";
 //BA.debugLineNum = 4219;BA.debugLine="pan_all_noskhe.Visible=False";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4220;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_setting_date_click() throws Exception{
 //BA.debugLineNum = 4764;BA.debugLine="Private Sub pan_all_setting_date_Click";
 //BA.debugLineNum = 4765;BA.debugLine="pan_all_setting_date.Visible=False";
mostCurrent._pan_all_setting_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 4766;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all2_click() throws Exception{
 //BA.debugLineNum = 3793;BA.debugLine="Private Sub pan_all2_Click";
 //BA.debugLineNum = 3796;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3797;BA.debugLine="End Sub";
return "";
}
public static String  _pan_bime_click() throws Exception{
anywheresoftware.b4a.phone.Phone.PhoneIntents _phoneintents1 = null;
 //BA.debugLineNum = 4367;BA.debugLine="Private Sub pan_bime_Click";
 //BA.debugLineNum = 4370;BA.debugLine="Dim PhoneIntents1 As PhoneIntents";
_phoneintents1 = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
 //BA.debugLineNum = 4371;BA.debugLine="StartActivity (PhoneIntents1.OpenBrowser(\"https:/";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_phoneintents1.OpenBrowser("https://eservices.tamin.ir/view/#/history")));
 //BA.debugLineNum = 4373;BA.debugLine="End Sub";
return "";
}
public static String  _pan_calc_click() throws Exception{
 //BA.debugLineNum = 3862;BA.debugLine="Private Sub pan_calc_Click";
 //BA.debugLineNum = 3863;BA.debugLine="StartActivity(calc_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._calc_activity.getObject()));
 //BA.debugLineNum = 3866;BA.debugLine="End Sub";
return "";
}
public static String  _pan_comment_click() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _market = null;
String _url = "";
 //BA.debugLineNum = 3804;BA.debugLine="Private Sub pan_comment_Click";
 //BA.debugLineNum = 3806;BA.debugLine="Try";
try { //BA.debugLineNum = 3807;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 3809;BA.debugLine="Try";
try { //BA.debugLineNum = 3810;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 3811;BA.debugLine="Dim url As String";
_url = "";
 //BA.debugLineNum = 3813;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafek";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
 //BA.debugLineNum = 3814;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
 //BA.debugLineNum = 3815;BA.debugLine="market.SetPackage(\"com.farsitel.bazaar\")";
_market.SetPackage("com.farsitel.bazaar");
 //BA.debugLineNum = 3816;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e11) {
			processBA.setLastException(e11); //BA.debugLineNum = 3819;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
 //BA.debugLineNum = 3822;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e17) {
			processBA.setLastException(e17); //BA.debugLineNum = 3826;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 3828;BA.debugLine="Try";
try { //BA.debugLineNum = 3829;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 3830;BA.debugLine="Dim url As String";
_url = "";
 //BA.debugLineNum = 3832;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafe";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
 //BA.debugLineNum = 3833;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
 //BA.debugLineNum = 3834;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e25) {
			processBA.setLastException(e25); //BA.debugLineNum = 3837;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
 //BA.debugLineNum = 3840;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 };
 //BA.debugLineNum = 3847;BA.debugLine="End Sub";
return "";
}
public static String  _pan_darsad_click() throws Exception{
 //BA.debugLineNum = 3799;BA.debugLine="Private Sub pan_darsad_Click";
 //BA.debugLineNum = 3800;BA.debugLine="StartActivity(darsad_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._darsad_activity.getObject()));
 //BA.debugLineNum = 3802;BA.debugLine="End Sub";
return "";
}
public static String  _pan_eidi_click() throws Exception{
 //BA.debugLineNum = 3513;BA.debugLine="Private Sub pan_eidi_Click";
 //BA.debugLineNum = 3514;BA.debugLine="StartActivity(eidi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._eidi_activity.getObject()));
 //BA.debugLineNum = 3516;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ezafekari_mah_click() throws Exception{
 //BA.debugLineNum = 4180;BA.debugLine="Private Sub pan_ezafekari_mah_Click";
 //BA.debugLineNum = 4181;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 //BA.debugLineNum = 4182;BA.debugLine="TabHost1.CurrentTab=0";
mostCurrent._tabhost1.setCurrentTab((int) (0));
 //BA.debugLineNum = 4184;BA.debugLine="End Sub";
return "";
}
public static String  _pan_fast_run_click() throws Exception{
 //BA.debugLineNum = 1741;BA.debugLine="Private Sub pan_fast_run_Click";
 //BA.debugLineNum = 1746;BA.debugLine="StartActivity(fast_run_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._fast_run_activity.getObject()));
 //BA.debugLineNum = 1750;BA.debugLine="End Sub";
return "";
}
public static String  _pan_finger_taradod_click() throws Exception{
 //BA.debugLineNum = 4824;BA.debugLine="Private Sub pan_finger_taradod_Click";
 //BA.debugLineNum = 4826;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ganon_click() throws Exception{
 //BA.debugLineNum = 4238;BA.debugLine="Private Sub pan_ganon_Click";
 //BA.debugLineNum = 4239;BA.debugLine="StartActivity(ganon_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ganon_activity.getObject()));
 //BA.debugLineNum = 4241;BA.debugLine="End Sub";
return "";
}
public static String  _pan_help_kharid_click() throws Exception{
 //BA.debugLineNum = 4482;BA.debugLine="Private Sub pan_help_kharid_Click";
 //BA.debugLineNum = 4485;BA.debugLine="If (myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 4486;BA.debugLine="StartActivity(help_kharid_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._help_kharid_activity.getObject()));
 }else {
 //BA.debugLineNum = 4488;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"توجه","اتصال اینترنت را بررسی کنید !");
 };
 //BA.debugLineNum = 4493;BA.debugLine="End Sub";
return "";
}
public static String  _pan_help_touch(int _action,float _x,float _y) throws Exception{
 //BA.debugLineNum = 3903;BA.debugLine="Private Sub pan_help_Touch (Action As Int, X As Fl";
 //BA.debugLineNum = 3905;BA.debugLine="If (Action=0)Then";
if ((_action==0)) { 
 //BA.debugLineNum = 3906;BA.debugLine="index_x_start_swap=x";
_index_x_start_swap = (int) (_x);
 //BA.debugLineNum = 3907;BA.debugLine="If (index_curent_img=4)Then";
if ((_index_curent_img==4)) { 
 //BA.debugLineNum = 3908;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 //BA.debugLineNum = 3911;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 3912;BA.debugLine="If(X<(index_x_start_swap-150))Then";
if ((_x<(_index_x_start_swap-150))) { 
 //BA.debugLineNum = 3915;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
 //BA.debugLineNum = 3916;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
 //BA.debugLineNum = 3917;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 }else if((_x>(_index_x_start_swap+150))) { 
 //BA.debugLineNum = 3924;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
 //BA.debugLineNum = 3925;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
 //BA.debugLineNum = 3926;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else if((_index_x_start_swap<(mostCurrent._pan_help.getWidth()/(double)2))) { 
 //BA.debugLineNum = 3932;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
 //BA.debugLineNum = 3933;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
 //BA.debugLineNum = 3934;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else if((_index_x_start_swap>(mostCurrent._pan_help.getWidth()/(double)2))) { 
 //BA.debugLineNum = 3939;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
 //BA.debugLineNum = 3940;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
 //BA.debugLineNum = 3941;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 };
 //BA.debugLineNum = 3946;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 };
 //BA.debugLineNum = 3949;BA.debugLine="End Sub";
return "";
}
public static String  _pan_info_click() throws Exception{
 //BA.debugLineNum = 3523;BA.debugLine="Private Sub pan_info_Click";
 //BA.debugLineNum = 3524;BA.debugLine="StartActivity(info_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._info_activity.getObject()));
 //BA.debugLineNum = 3527;BA.debugLine="End Sub";
return "";
}
public static String  _pan_item_gozaresh_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _ba = null;
 //BA.debugLineNum = 3851;BA.debugLine="Private Sub pan_item_gozaresh_Click";
 //BA.debugLineNum = 3852;BA.debugLine="Dim Ba As Panel = Sender";
_ba = new anywheresoftware.b4a.objects.PanelWrapper();
_ba = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 3854;BA.debugLine="current_gozaresh_id=Ba.Tag";
_current_gozaresh_id = (int)(BA.ObjectToNumber(_ba.getTag()));
 //BA.debugLineNum = 3855;BA.debugLine="StartActivity(show_gozaresh_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._show_gozaresh_activity.getObject()));
 //BA.debugLineNum = 3857;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lelp_click() throws Exception{
 //BA.debugLineNum = 3951;BA.debugLine="Private Sub pan_lelp_Click";
 //BA.debugLineNum = 3953;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lock_click() throws Exception{
 //BA.debugLineNum = 4375;BA.debugLine="Private Sub pan_lock_Click";
 //BA.debugLineNum = 4377;BA.debugLine="End Sub";
return "";
}
public static String  _pan_morakhasi_mah_click() throws Exception{
 //BA.debugLineNum = 4186;BA.debugLine="Private Sub pan_morakhasi_mah_Click";
 //BA.debugLineNum = 4187;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 //BA.debugLineNum = 4188;BA.debugLine="TabHost1.CurrentTab=1";
mostCurrent._tabhost1.setCurrentTab((int) (1));
 //BA.debugLineNum = 4190;BA.debugLine="End Sub";
return "";
}
public static String  _pan_notifi_all_click() throws Exception{
 //BA.debugLineNum = 742;BA.debugLine="Private Sub pan_notifi_all_Click";
 //BA.debugLineNum = 744;BA.debugLine="End Sub";
return "";
}
public static String  _pan_payankar_click() throws Exception{
 //BA.debugLineNum = 3518;BA.debugLine="Private Sub pan_payankar_Click";
 //BA.debugLineNum = 3519;BA.debugLine="StartActivity(payankar_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._payankar_activity.getObject()));
 //BA.debugLineNum = 3521;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_hogog_click() throws Exception{
 //BA.debugLineNum = 1769;BA.debugLine="Private Sub pan_run_hogog_Click";
 //BA.debugLineNum = 1770;BA.debugLine="If (myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 1771;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
 }else {
 //BA.debugLineNum = 1773;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
 };
 //BA.debugLineNum = 1779;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_morakhasi_click() throws Exception{
 //BA.debugLineNum = 1758;BA.debugLine="Private Sub pan_run_morakhasi_Click";
 //BA.debugLineNum = 1760;BA.debugLine="StartActivity(morakhasi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._morakhasi_activity.getObject()));
 //BA.debugLineNum = 1767;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_click() throws Exception{
 //BA.debugLineNum = 4243;BA.debugLine="Private Sub pan_setting_Click";
 //BA.debugLineNum = 4244;BA.debugLine="StartActivity(setting_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_activity.getObject()));
 //BA.debugLineNum = 4245;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 4246;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_hogog_click() throws Exception{
 //BA.debugLineNum = 1752;BA.debugLine="Private Sub pan_setting_hogog_Click";
 //BA.debugLineNum = 1753;BA.debugLine="StartActivity(setting_hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_hogog_activity.getObject()));
 //BA.debugLineNum = 1756;BA.debugLine="End Sub";
return "";
}
public static String  _pan_shift_click() throws Exception{
 //BA.debugLineNum = 4256;BA.debugLine="Private Sub pan_shift_Click";
 //BA.debugLineNum = 4258;BA.debugLine="StartActivity(shift_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._shift_activity.getObject()));
 //BA.debugLineNum = 4260;BA.debugLine="End Sub";
return "";
}
public static String  _pan_taghvim_click() throws Exception{
 //BA.debugLineNum = 4262;BA.debugLine="Private Sub pan_taghvim_Click";
 //BA.debugLineNum = 4263;BA.debugLine="pan_shift_Click";
_pan_shift_click();
 //BA.debugLineNum = 4264;BA.debugLine="End Sub";
return "";
}
public static String  _panel1_click() throws Exception{
 //BA.debugLineNum = 4275;BA.debugLine="Private Sub Panel1_Click";
 //BA.debugLineNum = 4277;BA.debugLine="End Sub";
return "";
}
public static String  _panel10_click() throws Exception{
 //BA.debugLineNum = 4453;BA.debugLine="Private Sub Panel10_Click";
 //BA.debugLineNum = 4455;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
 //BA.debugLineNum = 2321;BA.debugLine="Private Sub Panel4_Click";
 //BA.debugLineNum = 2323;BA.debugLine="End Sub";
return "";
}
public static String  _panel5_click() throws Exception{
 //BA.debugLineNum = 4222;BA.debugLine="Private Sub Panel5_Click";
 //BA.debugLineNum = 4224;BA.debugLine="End Sub";
return "";
}
public static String  _panel6_click() throws Exception{
 //BA.debugLineNum = 4351;BA.debugLine="Private Sub Panel6_Click";
 //BA.debugLineNum = 4353;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3436;BA.debugLine="Private Sub pik_day_bala1_Click";
 //BA.debugLineNum = 3437;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 3438;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 3441;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 3442;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 3443;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 3445;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 3446;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 3449;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 3450;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 3452;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 3453;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 3457;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 //BA.debugLineNum = 3459;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3461;BA.debugLine="Private Sub pik_day_paeen1_Click";
 //BA.debugLineNum = 3462;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 3463;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 3464;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 3465;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 3466;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 3468;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 3469;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 3472;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 3473;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 3475;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 3476;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 3480;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 //BA.debugLineNum = 3482;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3143;BA.debugLine="Private Sub pik_hour_bala1_Click";
 //BA.debugLineNum = 3145;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
 //BA.debugLineNum = 3146;BA.debugLine="pik_hour1.Text=int1+1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 3150;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
 //BA.debugLineNum = 3151;BA.debugLine="pik_hour1.Text=0";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 3153;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
 //BA.debugLineNum = 3154;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
 //BA.debugLineNum = 3157;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(pik_hour1.Text";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_hour1.getText())))));
 //BA.debugLineNum = 3159;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3161;BA.debugLine="Private Sub pik_hour_paeen1_Click";
 //BA.debugLineNum = 3162;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
 //BA.debugLineNum = 3163;BA.debugLine="pik_hour1.Text=int1-1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 3165;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
 //BA.debugLineNum = 3166;BA.debugLine="pik_hour1.Text=0";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 3168;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
 //BA.debugLineNum = 3169;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
 //BA.debugLineNum = 3172;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(pik_hour1.Text";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_hour1.getText())))));
 //BA.debugLineNum = 3173;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3175;BA.debugLine="Private Sub pik_min_bala1_Click";
 //BA.debugLineNum = 3176;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
 //BA.debugLineNum = 3177;BA.debugLine="pik_min1.Text=int1+1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 3179;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
 //BA.debugLineNum = 3180;BA.debugLine="pik_min1.Text=0";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 3182;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
 //BA.debugLineNum = 3183;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
 //BA.debugLineNum = 3186;BA.debugLine="pik_min1.Text=myfunc.convert_adad(pik_min1.Text)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_min1.getText())))));
 //BA.debugLineNum = 3188;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3190;BA.debugLine="Private Sub pik_min_paeen1_Click";
 //BA.debugLineNum = 3191;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
 //BA.debugLineNum = 3192;BA.debugLine="pik_min1.Text=int1-1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 3194;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
 //BA.debugLineNum = 3195;BA.debugLine="pik_min1.Text=0";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 3197;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
 //BA.debugLineNum = 3198;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
 //BA.debugLineNum = 3200;BA.debugLine="pik_min1.Text=myfunc.convert_adad(pik_min1.Text)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_min1.getText())))));
 //BA.debugLineNum = 3202;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3382;BA.debugLine="Private Sub pik_moon_bala1_Click";
 //BA.debugLineNum = 3383;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 3384;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
 //BA.debugLineNum = 3386;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 3387;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 3389;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 3390;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 3392;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 3394;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3396;BA.debugLine="Private Sub pik_moon_paeen1_Click";
 //BA.debugLineNum = 3397;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 3398;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
 //BA.debugLineNum = 3400;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 3401;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 3403;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 3404;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 3406;BA.debugLine="pik_moon1.Text=moon.Get(myfunc.fa2en(pik_moon1.Ta";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
 //BA.debugLineNum = 3408;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3342;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
 //BA.debugLineNum = 3343;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 3344;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 3345;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3348;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 3350;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 3351;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
 //BA.debugLineNum = 3352;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3353;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3355;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 3356;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
 //BA.debugLineNum = 3357;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3358;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3361;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 3362;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 3363;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 3365;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 3366;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 3369;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 3370;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 3372;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 3373;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 3377;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 };
 //BA.debugLineNum = 3380;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_hour1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3204;BA.debugLine="Private Sub pik_pan_hour1_Touch (Action As Int, X";
 //BA.debugLineNum = 3205;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 3206;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 3207;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3210;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 3212;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 3213;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))-1);
 //BA.debugLineNum = 3214;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3215;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3217;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 3218;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))+1);
 //BA.debugLineNum = 3219;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3220;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3223;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
 //BA.debugLineNum = 3224;BA.debugLine="pik_hour1.Text=0";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 3226;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
 //BA.debugLineNum = 3227;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
 //BA.debugLineNum = 3230;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(pik_hour1.Tex";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_hour1.getText())))));
 };
 //BA.debugLineNum = 3235;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_min1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3237;BA.debugLine="Private Sub pik_pan_min1_Touch (Action As Int, X A";
 //BA.debugLineNum = 3238;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 3239;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 3240;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3243;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 3245;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 3247;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))-1);
 //BA.debugLineNum = 3248;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3251;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3253;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 3255;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))+1);
 //BA.debugLineNum = 3256;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3259;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3263;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
 //BA.debugLineNum = 3264;BA.debugLine="pik_min1.Text=0";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 3267;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
 //BA.debugLineNum = 3268;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
 //BA.debugLineNum = 3270;BA.debugLine="pik_min1.Text=myfunc.convert_adad(pik_min1.Text)";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_min1.getText())))));
 };
 //BA.debugLineNum = 3276;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3282;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
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
 //BA.debugLineNum = 3291;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
 //BA.debugLineNum = 3292;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 3293;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3295;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 3296;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
 //BA.debugLineNum = 3297;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 3298;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3301;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 3302;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 3304;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 3305;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 3307;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
 //BA.debugLineNum = 3310;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3312;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
 //BA.debugLineNum = 3313;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 3314;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 3315;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3318;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 3320;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 3321;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
 //BA.debugLineNum = 3322;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3323;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3325;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 3326;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
 //BA.debugLineNum = 3327;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 3328;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 3331;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 3332;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 3334;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 3335;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
 //BA.debugLineNum = 3340;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3410;BA.debugLine="Private Sub pik_year_bala1_Click";
 //BA.debugLineNum = 3411;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 3412;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 3414;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 3415;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 3417;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 3418;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 3421;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 3423;BA.debugLine="Private Sub pik_year_paeen1_Click";
 //BA.debugLineNum = 3424;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 3425;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 3427;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 3428;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 3430;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 3431;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 3434;BA.debugLine="End Sub";
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
fast_run_activity._process_globals();
hogog_activity._process_globals();
ayabzahab_activity._process_globals();
bime_activity._process_globals();
calc_activity._process_globals();
comment_activity._process_globals();
darsad_activity._process_globals();
eidi_activity._process_globals();
food_activity._process_globals();
ganon_activity._process_globals();
gestha_activity._process_globals();
help_kharid_activity._process_globals();
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
shift_activity._process_globals();
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
 //BA.debugLineNum = 976;BA.debugLine="Sub resetting_all";
 //BA.debugLineNum = 978;BA.debugLine="key1.color = Colors.White";
mostCurrent._key1.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 979;BA.debugLine="key2.Color = Colors.White";
mostCurrent._key2.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 980;BA.debugLine="key3.Color = Colors.White";
mostCurrent._key3.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 981;BA.debugLine="key4.Color = Colors.white";
mostCurrent._key4.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 984;BA.debugLine="entered_Password = \"\"";
mostCurrent._entered_password = "";
 //BA.debugLineNum = 988;BA.debugLine="Click_Count = 0";
_click_count = (int) (0);
 //BA.debugLineNum = 989;BA.debugLine="End Sub";
return "";
}
public static boolean  _rspop_noe_menuitemclick(int _itemid) throws Exception{
 //BA.debugLineNum = 1889;BA.debugLine="Sub rsPOP_noe_MenuItemClick (ItemId As Int) As Boo";
 //BA.debugLineNum = 1891;BA.debugLine="Select ItemId";
switch (_itemid) {
case 0: {
 //BA.debugLineNum = 1893;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
 //BA.debugLineNum = 1895;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
 //BA.debugLineNum = 1897;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
 //BA.debugLineNum = 1899;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
 //BA.debugLineNum = 1903;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
 //BA.debugLineNum = 1904;BA.debugLine="index_noe_morakhasi=ItemId";
_index_noe_morakhasi = _itemid;
 //BA.debugLineNum = 1905;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1906;BA.debugLine="End Sub";
return false;
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 3503;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
 //BA.debugLineNum = 3504;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 3506;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
 //BA.debugLineNum = 3509;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
 //BA.debugLineNum = 3510;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
 //BA.debugLineNum = 3511;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_gozaresh_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 4279;BA.debugLine="Private Sub sp_year_gozaresh_ItemClick (Position A";
 //BA.debugLineNum = 4280;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
 //BA.debugLineNum = 4281;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 3489;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
 //BA.debugLineNum = 3494;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 3495;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
 //BA.debugLineNum = 3497;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
 //BA.debugLineNum = 3499;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
 //BA.debugLineNum = 3501;BA.debugLine="End Sub";
return "";
}
public static String  _tabhost1_tabchanged() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_all_saat = null;
String _str_saat = "";
 //BA.debugLineNum = 1309;BA.debugLine="Private Sub TabHost1_TabChanged";
 //BA.debugLineNum = 1311;BA.debugLine="Dim ls_all_saat As List";
_ls_all_saat = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1312;BA.debugLine="ls_all_saat.Initialize";
_ls_all_saat.Initialize();
 //BA.debugLineNum = 1313;BA.debugLine="Dim str_saat As String";
_str_saat = "";
 //BA.debugLineNum = 1315;BA.debugLine="If(sp_year.IsInitialized)Then";
if ((mostCurrent._sp_year.IsInitialized())) { 
 //BA.debugLineNum = 1321;BA.debugLine="Select TabHost1.CurrentTab";
switch (BA.switchObjectToInt(mostCurrent._tabhost1.getCurrentTab(),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
 //BA.debugLineNum = 1323;BA.debugLine="ls_all_saat=dbCode.all_ezafekari_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
 //BA.debugLineNum = 1324;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
case 1: {
 //BA.debugLineNum = 1326;BA.debugLine="ls_all_saat=dbCode.all_morakhasi_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 //BA.debugLineNum = 1328;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" روز و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" ساعت و "+BA.ObjectToString(_ls_all_saat.Get((int) (2)))+" دقیقه ";
 break; }
case 2: {
 //BA.debugLineNum = 1330;BA.debugLine="ls_all_saat=dbCode.all_taradod_mah(myfunc.fa2e";
_ls_all_saat = mostCurrent._dbcode._all_taradod_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 //BA.debugLineNum = 1331;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
case 3: {
 //BA.debugLineNum = 1333;BA.debugLine="ls_all_saat=dbCode.all_mamoriat_mah(myfunc.fa2";
_ls_all_saat = mostCurrent._dbcode._all_mamoriat_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 //BA.debugLineNum = 1334;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" روز و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" ساعت و "+BA.ObjectToString(_ls_all_saat.Get((int) (2)))+" دقیقه ";
 break; }
}
;
 //BA.debugLineNum = 1341;BA.debugLine="lbl_majmoe_saat.Text=str_saat";
mostCurrent._lbl_majmoe_saat.setText(BA.ObjectToCharSequence(_str_saat));
 };
 //BA.debugLineNum = 1347;BA.debugLine="End Sub";
return "";
}
public static String  _tatil_hast() throws Exception{
 //BA.debugLineNum = 3124;BA.debugLine="Sub tatil_hast";
 //BA.debugLineNum = 3126;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3127;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3128;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=True";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3129;BA.debugLine="ckb_ezaf_taradod_fs.Visible=True";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3132;BA.debugLine="radio_ez_adi.Enabled=True";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3133;BA.debugLine="radio_ez_fog.Enabled=True";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3136;BA.debugLine="lbl_ezaf_taradod.Text=\"افزودن به اضافه کاری \"&((m";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("افزودن به اضافه کاری "+BA.ObjectToString(((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_tim_min).Get((int) (0)))))+" ساعت و "+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_tim_min)).Get((int) (1)))+" دقیقه "));
 //BA.debugLineNum = 3138;BA.debugLine="lbl_ezaf_taradod_fs.Text=lbl_ezaf_taradod.Text";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(mostCurrent._lbl_ezaf_taradod.getText()));
 //BA.debugLineNum = 3141;BA.debugLine="End Sub";
return "";
}
public static String  _tatil_nist() throws Exception{
int _min_satkari_inweek = 0;
 //BA.debugLineNum = 3091;BA.debugLine="Sub tatil_nist";
 //BA.debugLineNum = 3092;BA.debugLine="Dim min_satKari_inWeek As Int =myfunc.get_saatKar";
_min_satkari_inweek = mostCurrent._myfunc._get_saatkari_inweek /*int*/ (mostCurrent.activityBA,_day_inweek_id);
 //BA.debugLineNum = 3094;BA.debugLine="If(tim_min>min_satKari_inWeek) Then";
if ((_tim_min>_min_satkari_inweek)) { 
 //BA.debugLineNum = 3097;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3098;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3099;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=True";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3100;BA.debugLine="ckb_ezaf_taradod_fs.Visible=True";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3103;BA.debugLine="radio_ez_adi.Enabled=True";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3104;BA.debugLine="radio_ez_fog.Enabled=True";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3107;BA.debugLine="lbl_ezaf_taradod.Text=\"افزودن به اضافه کاری \"&((";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("افزودن به اضافه کاری "+BA.ObjectToString(((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_min_satkari_inweek)).Get((int) (0)))))+" ساعت و "+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_min_satkari_inweek))).Get((int) (1)))+" دقیقه "));
 //BA.debugLineNum = 3109;BA.debugLine="lbl_ezaf_taradod_fs.Text=lbl_ezaf_taradod.Text";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(mostCurrent._lbl_ezaf_taradod.getText()));
 }else {
 //BA.debugLineNum = 3112;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 3113;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3114;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3115;BA.debugLine="radio_ez_adi.Enabled=False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3116;BA.debugLine="radio_ez_fog.Enabled=False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3117;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 3118;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3119;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 3122;BA.debugLine="End Sub";
return "";
}
public static String  _tim_check_update_tick() throws Exception{
 //BA.debugLineNum = 471;BA.debugLine="Sub tim_check_update_Tick";
 //BA.debugLineNum = 472;BA.debugLine="chk_update_auto";
_chk_update_auto();
 //BA.debugLineNum = 473;BA.debugLine="Log(\"now cheking ....\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7196610","now cheking ....",0);
 //BA.debugLineNum = 474;BA.debugLine="tim_check_update.Enabled=False";
_tim_check_update.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 475;BA.debugLine="End Sub";
return "";
}
public static String  _tim_lock_lbl_tick() throws Exception{
 //BA.debugLineNum = 859;BA.debugLine="Sub tim_lock_lbl_Tick";
 //BA.debugLineNum = 860;BA.debugLine="If(stat_finger=0)Then";
if ((_stat_finger==0)) { 
 //BA.debugLineNum = 861;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
mostCurrent._lbl_finger.setTextColor(((int)0xff0b6200));
 //BA.debugLineNum = 862;BA.debugLine="stat_finger=1";
_stat_finger = (int) (1);
 }else {
 //BA.debugLineNum = 864;BA.debugLine="lbl_finger.TextColor=0xFF2FFF00";
mostCurrent._lbl_finger.setTextColor(((int)0xff2fff00));
 //BA.debugLineNum = 865;BA.debugLine="stat_finger=0";
_stat_finger = (int) (0);
 };
 //BA.debugLineNum = 867;BA.debugLine="End Sub";
return "";
}
public static String  _tim_msg_newyear_tick() throws Exception{
 //BA.debugLineNum = 477;BA.debugLine="Sub tim_msg_newYear_Tick";
 //BA.debugLineNum = 478;BA.debugLine="pan_all_msgNewYear.Visible=True";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 480;BA.debugLine="tim_msg_newYear.Enabled=False";
_tim_msg_newyear.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 481;BA.debugLine="End Sub";
return "";
}
public static String  _tim_msg_tick() throws Exception{
String _msg_key = "";
String _msg_value = "";
 //BA.debugLineNum = 678;BA.debugLine="Sub tim_msg_Tick";
 //BA.debugLineNum = 680;BA.debugLine="Dim msg_key As String";
_msg_key = "";
 //BA.debugLineNum = 681;BA.debugLine="Dim msg_value As String";
_msg_value = "";
 //BA.debugLineNum = 684;BA.debugLine="msg_key=msg.SubString2(0,4)";
_msg_key = mostCurrent._msg.substring((int) (0),(int) (4));
 //BA.debugLineNum = 685;BA.debugLine="msg_value=msg.SubString(5)";
_msg_value = mostCurrent._msg.substring((int) (5));
 //BA.debugLineNum = 687;BA.debugLine="ls1.Add(msg_key)";
mostCurrent._ls1.Add((Object)(_msg_key));
 //BA.debugLineNum = 688;BA.debugLine="ls2.Add(msg_value)";
mostCurrent._ls2.Add((Object)(_msg_value));
 //BA.debugLineNum = 689;BA.debugLine="ls3.Add(lbl_date_home.Text)";
mostCurrent._ls3.Add((Object)(mostCurrent._lbl_date_home.getText()));
 //BA.debugLineNum = 691;BA.debugLine="File.WriteList(File.DirInternal,\"ls1\",ls1)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1",mostCurrent._ls1);
 //BA.debugLineNum = 692;BA.debugLine="File.WriteList(File.DirInternal,\"ls2\",ls2)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls2",mostCurrent._ls2);
 //BA.debugLineNum = 693;BA.debugLine="File.WriteList(File.DirInternal,\"ls3\",ls3)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls3",mostCurrent._ls3);
 //BA.debugLineNum = 695;BA.debugLine="lbl_title_msgPan.Text=\"پیام جدید\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام جدید"));
 //BA.debugLineNum = 696;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 698;BA.debugLine="pan_notif.Top=20%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 699;BA.debugLine="pan_notif.Height=50%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA));
 //BA.debugLineNum = 700;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
 //BA.debugLineNum = 703;BA.debugLine="web_msg_show.LoadHtml(\"<!DOCTYPE html><html><meta";
mostCurrent._web_msg_show.LoadHtml("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'><div style='background-color: #99ffff; font-size: 14px;'>"+"کد پیام : "+_msg_key+" - مورخ : "+mostCurrent._lbl_date_home.getText()+"</div><div style='background-color: #e6ffff; font-size: 18px;'><br>"+_msg_value+"<br></div><br></body></html>");
 //BA.debugLineNum = 705;BA.debugLine="tim_msg.Enabled=False";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 706;BA.debugLine="End Sub";
return "";
}
public static int  _tim_vorod_conv_ezaf(String _tim1) throws Exception{
String[] _ste_tim = null;
 //BA.debugLineNum = 4355;BA.debugLine="Sub tim_vorod_conv_ezaf (tim1 As String) As Int";
 //BA.debugLineNum = 4357;BA.debugLine="Dim ste_tim() As String";
_ste_tim = new String[(int) (0)];
java.util.Arrays.fill(_ste_tim,"");
 //BA.debugLineNum = 4358;BA.debugLine="ste_tim=Regex.Split(\":\",tim1)";
_ste_tim = anywheresoftware.b4a.keywords.Common.Regex.Split(":",_tim1);
 //BA.debugLineNum = 4361;BA.debugLine="Return (ste_tim(0)*60)+ste_tim(1) +saat_kar_min";
if (true) return (int) (((double)(Double.parseDouble(_ste_tim[(int) (0)]))*60)+(double)(Double.parseDouble(_ste_tim[(int) (1)]))+_saat_kar_min);
 //BA.debugLineNum = 4364;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 2946;BA.debugLine="Sub time_show";
 //BA.debugLineNum = 2948;BA.debugLine="Try";
try { //BA.debugLineNum = 2951;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2952;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2953;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
 //BA.debugLineNum = 2954;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
 //BA.debugLineNum = 2956;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
 //BA.debugLineNum = 2957;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
 //BA.debugLineNum = 2958;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 2959;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 2962;BA.debugLine="pik_moon1.Tag=myfunc.convert_adad(pik_moon1.Tag)";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))));
 //BA.debugLineNum = 2967;BA.debugLine="date1=lbl_date1.Text";
mostCurrent._date1 = mostCurrent._lbl_date1.getText();
 //BA.debugLineNum = 2968;BA.debugLine="date2=lbl_date2.Text";
mostCurrent._date2 = mostCurrent._lbl_date2.getText();
 //BA.debugLineNum = 2969;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
 //BA.debugLineNum = 2970;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
 //BA.debugLineNum = 2974;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_dat";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
 //BA.debugLineNum = 2975;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_dat";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
 //BA.debugLineNum = 2978;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
 //BA.debugLineNum = 2979;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
 //BA.debugLineNum = 2982;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
 //BA.debugLineNum = 2983;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
 //BA.debugLineNum = 2985;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date_";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
 //BA.debugLineNum = 2986;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date_";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
 //BA.debugLineNum = 2988;BA.debugLine="time_end2=lbl_tim2.Text&\":00\"";
_time_end2 = mostCurrent._lbl_tim2.getText()+":00";
 //BA.debugLineNum = 2989;BA.debugLine="time_end1=lbl_tim1.Text&\":00\"";
_time_end1 = mostCurrent._lbl_tim1.getText()+":00";
 //BA.debugLineNum = 2991;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
 //BA.debugLineNum = 2992;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
 //BA.debugLineNum = 2993;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
 //BA.debugLineNum = 2994;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
 //BA.debugLineNum = 2998;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
 //BA.debugLineNum = 2999;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
 //BA.debugLineNum = 3002;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 3003;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
 //BA.debugLineNum = 3005;BA.debugLine="If (period_between.Years<>0)Then";
if ((_period_between.Years!=0)) { 
 //BA.debugLineNum = 3006;BA.debugLine="str_show.Append(period_between.Years&\" سال \").A";
_str_show.Append(BA.NumberToString(_period_between.Years)+" سال ").Append(" و ");
 };
 //BA.debugLineNum = 3008;BA.debugLine="If (period_between.Months<>0)Then";
if ((_period_between.Months!=0)) { 
 //BA.debugLineNum = 3009;BA.debugLine="str_show.Append(period_between.Months&\" ماه \").";
_str_show.Append(BA.NumberToString(_period_between.Months)+" ماه ").Append(" و ");
 };
 //BA.debugLineNum = 3011;BA.debugLine="If (period_between.Days<>0)Then";
if ((_period_between.Days!=0)) { 
 //BA.debugLineNum = 3012;BA.debugLine="str_show.Append(period_between.Days&\" روز \").Ap";
_str_show.Append(BA.NumberToString(_period_between.Days)+" روز ").Append(" و ");
 };
 //BA.debugLineNum = 3015;BA.debugLine="str_show.Append(period_between.Hours&\" ساعت \").A";
_str_show.Append(BA.NumberToString(_period_between.Hours)+" ساعت ").Append(" و ");
 //BA.debugLineNum = 3016;BA.debugLine="str_show.Append(period_between.Minutes&\" دقیقه \"";
_str_show.Append(BA.NumberToString(_period_between.Minutes)+" دقیقه ");
 //BA.debugLineNum = 3019;BA.debugLine="year_bt=period_between.Years";
_year_bt = _period_between.Years;
 //BA.debugLineNum = 3020;BA.debugLine="moon_bt=period_between.Months";
_moon_bt = _period_between.Months;
 //BA.debugLineNum = 3021;BA.debugLine="day_bt=period_between.Days";
_day_bt = _period_between.Days;
 //BA.debugLineNum = 3022;BA.debugLine="hour_bt=period_between.Hours";
_hour_bt = _period_between.Hours;
 //BA.debugLineNum = 3023;BA.debugLine="min_bt=period_between.Minutes";
_min_bt = _period_between.Minutes;
 //BA.debugLineNum = 3026;BA.debugLine="lbl_time_show.Text=str_show";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(_str_show.getObject()));
 //BA.debugLineNum = 3027;BA.debugLine="lbl_time_show_fs.Text=lbl_time_show.Text";
mostCurrent._lbl_time_show_fs.setText(BA.ObjectToCharSequence(mostCurrent._lbl_time_show.getText()));
 //BA.debugLineNum = 3029;BA.debugLine="If(index_box=3)Then";
if ((_index_box==3)) { 
 //BA.debugLineNum = 3033;BA.debugLine="tim_min=(day_bt*24*60)+(hour_bt*60)+min_bt";
_tim_min = (int) ((_day_bt*24*60)+(_hour_bt*60)+_min_bt);
 //BA.debugLineNum = 3036;BA.debugLine="Select state_tatil_setting";
switch (_state_tatil_setting) {
case 0: {
 //BA.debugLineNum = 3039;BA.debugLine="tatil_nist";
_tatil_nist();
 break; }
case 1: {
 //BA.debugLineNum = 3042;BA.debugLine="If (state_tatil=1 Or state_tatil=2 ) Then 'ta";
if ((_state_tatil==1 || _state_tatil==2)) { 
 //BA.debugLineNum = 3043;BA.debugLine="tatil_hast";
_tatil_hast();
 }else {
 //BA.debugLineNum = 3045;BA.debugLine="tatil_nist";
_tatil_nist();
 };
 break; }
case 11: {
 //BA.debugLineNum = 3049;BA.debugLine="If (state_tatil=1 ) Then 'tatil rasmi";
if ((_state_tatil==1)) { 
 //BA.debugLineNum = 3050;BA.debugLine="tatil_hast";
_tatil_hast();
 }else {
 //BA.debugLineNum = 3052;BA.debugLine="tatil_nist";
_tatil_nist();
 };
 break; }
case 22: {
 //BA.debugLineNum = 3057;BA.debugLine="If (state_tatil=2 ) Then  'tatil garardadi";
if ((_state_tatil==2)) { 
 //BA.debugLineNum = 3058;BA.debugLine="tatil_hast";
_tatil_hast();
 }else {
 //BA.debugLineNum = 3060;BA.debugLine="tatil_nist";
_tatil_nist();
 };
 break; }
}
;
 //BA.debugLineNum = 3067;BA.debugLine="If(is_for_edit=True)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 3068;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 3069;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3070;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3071;BA.debugLine="radio_ez_adi.Enabled=False";
mostCurrent._radio_ez_adi.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3072;BA.debugLine="radio_ez_fog.Enabled=False";
mostCurrent._radio_ez_fog.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3073;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
mostCurrent._lbl_ezaf_taradod_fs.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 3074;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
mostCurrent._ckb_ezaf_taradod_fs.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3075;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
mostCurrent._ckb_ezaf_taradod_fs.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 } 
       catch (Exception e87) {
			processBA.setLastException(e87); //BA.debugLineNum = 3082;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 3088;BA.debugLine="End Sub";
return "";
}
public static String  _timer1_tick() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_lock0 = null;
 //BA.debugLineNum = 800;BA.debugLine="Sub timer1_Tick";
 //BA.debugLineNum = 802;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 803;BA.debugLine="timer1.Enabled=False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 804;BA.debugLine="cv_loader.Hide";
mostCurrent._cv_loader._hide /*String*/ ();
 //BA.debugLineNum = 805;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 //BA.debugLineNum = 806;BA.debugLine="ScrollView_sett_taradod.Panel.LoadLayout(\"item_se";
mostCurrent._scrollview_sett_taradod.getPanel().LoadLayout("item_settingTaradod_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 813;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=True)T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 814;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 815;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
 //BA.debugLineNum = 816;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_lock";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
 //BA.debugLineNum = 818;BA.debugLine="If(ls_lock0.Get(0)=\"true\")Then";
if (((_ls_lock0.Get((int) (0))).equals((Object)("true")))) { 
 //BA.debugLineNum = 819;BA.debugLine="Master_Password=ls_lock0.Get(2)";
mostCurrent._master_password = BA.ObjectToString(_ls_lock0.Get((int) (2)));
 //BA.debugLineNum = 820;BA.debugLine="pan_lock.Visible=True";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 821;BA.debugLine="lbl_hint_lock.Text=ls_lock0.Get(3)";
mostCurrent._lbl_hint_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (3))));
 //BA.debugLineNum = 823;BA.debugLine="If(ls_lock0.Get(1)=\"true\")Then";
if (((_ls_lock0.Get((int) (1))).equals((Object)("true")))) { 
 //BA.debugLineNum = 825;BA.debugLine="tim_lock_lbl.Initialize(\"tim_lock_lbl\",500)";
_tim_lock_lbl.Initialize(processBA,"tim_lock_lbl",(long) (500));
 //BA.debugLineNum = 826;BA.debugLine="Try";
try { //BA.debugLineNum = 827;BA.debugLine="fingerprint.Initialize (Me, \"auth\")";
mostCurrent._fingerprint._initialize /*String*/ (processBA,main.getObject(),"auth");
 //BA.debugLineNum = 830;BA.debugLine="If fingerprint.HardwareDetected = False Then";
if (mostCurrent._fingerprint._gethardwaredetected /*boolean*/ ()==anywheresoftware.b4a.keywords.Common.False) { 
 }else if(mostCurrent._fingerprint._gethasenrolledfingerprints /*boolean*/ ()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 834;BA.debugLine="ToastMessageShow(\"اثر انگشت تعریف نشده است\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اثر انگشت تعریف نشده است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 836;BA.debugLine="lbl_finger.Visible=True";
mostCurrent._lbl_finger.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 837;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
mostCurrent._lbl_finger.setTextColor(((int)0xff0b6200));
 //BA.debugLineNum = 838;BA.debugLine="finger_scaning";
_finger_scaning();
 //BA.debugLineNum = 839;BA.debugLine="tim_lock_lbl.Enabled=True";
_tim_lock_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e28) {
			processBA.setLastException(e28); //BA.debugLineNum = 843;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("7983083",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
 };
 }else {
 //BA.debugLineNum = 850;BA.debugLine="pan_lock.Visible=False";
mostCurrent._pan_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 857;BA.debugLine="End Sub";
return "";
}
public static int  _validat_et_saatkari(String _val) throws Exception{
 //BA.debugLineNum = 4815;BA.debugLine="Sub validat_et_saatKari (val As String) As Int";
 //BA.debugLineNum = 4816;BA.debugLine="If (val=\"\") Then";
if (((_val).equals(""))) { 
 //BA.debugLineNum = 4817;BA.debugLine="val=0";
_val = BA.NumberToString(0);
 };
 //BA.debugLineNum = 4819;BA.debugLine="Return val";
if (true) return (int)(Double.parseDouble(_val));
 //BA.debugLineNum = 4820;BA.debugLine="End Sub";
return 0;
}
public static int  _what_day(int _year1,int _moon1,int _day1) throws Exception{
int _id_myday = 0;
int _result_int = 0;
 //BA.debugLineNum = 3698;BA.debugLine="Sub what_day (year1 As Int,moon1 As Int, day1 As I";
 //BA.debugLineNum = 3699;BA.debugLine="Dim id_MyDay As Int";
_id_myday = 0;
 //BA.debugLineNum = 3700;BA.debugLine="id_MyDay=dbCode.get_day_id(year1,moon1,day1)";
_id_myday = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_year1,_moon1,_day1);
 //BA.debugLineNum = 3702;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 3703;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id_myday))));
 //BA.debugLineNum = 3705;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 3706;BA.debugLine="Dim result_int As Int=dbCode.res.GetInt(\"day_h\")";
_result_int = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("day_h");
 //BA.debugLineNum = 3710;BA.debugLine="Select result_int";
switch (_result_int) {
case 1: {
 //BA.debugLineNum = 3712;BA.debugLine="day_inWeek_name=\"شنبه\"";
mostCurrent._day_inweek_name = "شنبه";
 break; }
case 2: {
 //BA.debugLineNum = 3714;BA.debugLine="day_inWeek_name=\"یکشنبه\"";
mostCurrent._day_inweek_name = "یکشنبه";
 break; }
case 3: {
 //BA.debugLineNum = 3716;BA.debugLine="day_inWeek_name=\"دوشنبه\"";
mostCurrent._day_inweek_name = "دوشنبه";
 break; }
case 4: {
 //BA.debugLineNum = 3718;BA.debugLine="day_inWeek_name=\"سه شنبه\"";
mostCurrent._day_inweek_name = "سه شنبه";
 break; }
case 5: {
 //BA.debugLineNum = 3720;BA.debugLine="day_inWeek_name=\"چهارشنبه\"";
mostCurrent._day_inweek_name = "چهارشنبه";
 break; }
case 6: {
 //BA.debugLineNum = 3722;BA.debugLine="day_inWeek_name=\"پنجشنبه\"";
mostCurrent._day_inweek_name = "پنجشنبه";
 break; }
case 7: {
 //BA.debugLineNum = 3724;BA.debugLine="day_inWeek_name=\"جمعه\"";
mostCurrent._day_inweek_name = "جمعه";
 break; }
}
;
 //BA.debugLineNum = 3728;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 3729;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 3731;BA.debugLine="Return result_int";
if (true) return _result_int;
 //BA.debugLineNum = 3732;BA.debugLine="End Sub";
return 0;
}
}
