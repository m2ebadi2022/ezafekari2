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
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
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
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (fast_run_activity.mostCurrent != null);
vis = vis | (bime_activity.mostCurrent != null);
vis = vis | (calc_activity.mostCurrent != null);
vis = vis | (comment_activity.mostCurrent != null);
vis = vis | (darsad_activity.mostCurrent != null);
vis = vis | (eidi_activity.mostCurrent != null);
vis = vis | (ganon_activity.mostCurrent != null);
vis = vis | (hogog_activity.mostCurrent != null);
vis = vis | (info_activity.mostCurrent != null);
vis = vis | (morakhasi_activity.mostCurrent != null);
vis = vis | (payankar_activity.mostCurrent != null);
vis = vis | (setting_activity.mostCurrent != null);
vis = vis | (setting_hogog_activity.mostCurrent != null);
vis = vis | (shift_activity.mostCurrent != null);
vis = vis | (show_gozaresh_activity.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 260;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 264;BA.debugLine="Try";
try { //BA.debugLineNum = 265;BA.debugLine="inapp.Initialize(\"inapp\",key)";
mostCurrent._inapp.Initialize(processBA,"inapp",mostCurrent._key);
 } 
       catch (Exception e4) {
			processBA.setLastException(e4); //BA.debugLineNum = 267;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("2131079",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 272;BA.debugLine="dbCode.init_notfound(\"ksorat\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"ksorat",BA.NumberToString(0));
 //BA.debugLineNum = 274;BA.debugLine="dbCode.init_notfound(\"morakhasi_mande_d\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_mande_d",BA.NumberToString(0));
 //BA.debugLineNum = 275;BA.debugLine="dbCode.init_notfound(\"morakhasi_mande_h\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_mande_h",BA.NumberToString(0));
 //BA.debugLineNum = 276;BA.debugLine="dbCode.init_notfound(\"morakhasi_mande_m\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_mande_m",BA.NumberToString(0));
 //BA.debugLineNum = 278;BA.debugLine="dbCode.init_notfound(\"morakhasi_darMah_d\",2)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_darMah_d",BA.NumberToString(2));
 //BA.debugLineNum = 279;BA.debugLine="dbCode.init_notfound(\"morakhasi_darMah_h\",4)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_darMah_h",BA.NumberToString(4));
 //BA.debugLineNum = 280;BA.debugLine="dbCode.init_notfound(\"morakhasi_darMah_m\",0)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"morakhasi_darMah_m",BA.NumberToString(0));
 //BA.debugLineNum = 282;BA.debugLine="dbCode.init_notfound(\"saat_kar_darRoz\",480)";
mostCurrent._dbcode._init_notfound /*String*/ (mostCurrent.activityBA,"saat_kar_darRoz",BA.NumberToString(480));
 //BA.debugLineNum = 286;BA.debugLine="dbCode.install_db_tbl_taradod";
mostCurrent._dbcode._install_db_tbl_taradod /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 287;BA.debugLine="dbCode.install_db_tbl_myCalander";
mostCurrent._dbcode._install_db_tbl_mycalander /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 288;BA.debugLine="dbCode.cheng_tagvim";
mostCurrent._dbcode._cheng_tagvim /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 289;BA.debugLine="dbCode.install_db_tbl_onvanha";
mostCurrent._dbcode._install_db_tbl_onvanha /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 293;BA.debugLine="img1.Initialize(LoadBitmap(File.DirAssets,\"m1.png";
mostCurrent._img1.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m1.png").getObject()));
 //BA.debugLineNum = 294;BA.debugLine="img1.Gravity=Gravity.FILL";
mostCurrent._img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 296;BA.debugLine="img2.Initialize(LoadBitmap(File.DirAssets,\"m2.png";
mostCurrent._img2.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m2.png").getObject()));
 //BA.debugLineNum = 297;BA.debugLine="img2.Gravity=Gravity.FILL";
mostCurrent._img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 299;BA.debugLine="img3.Initialize(LoadBitmap(File.DirAssets,\"m3.png";
mostCurrent._img3.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"m3.png").getObject()));
 //BA.debugLineNum = 300;BA.debugLine="img3.Gravity=Gravity.FILL";
mostCurrent._img3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 302;BA.debugLine="If(FirstTime)Then";
if ((_firsttime)) { 
 //BA.debugLineNum = 303;BA.debugLine="Activity.LoadLayout(\"splash_layout\")";
mostCurrent._activity.LoadLayout("splash_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 304;BA.debugLine="lbl_vesion_app.Text=app_vesion";
mostCurrent._lbl_vesion_app.setText(BA.ObjectToCharSequence(_app_vesion));
 //BA.debugLineNum = 305;BA.debugLine="cv_loader.Show";
mostCurrent._cv_loader._show /*String*/ ();
 //BA.debugLineNum = 306;BA.debugLine="timer1.Initialize(\"timer1\" , 1500)";
_timer1.Initialize(processBA,"timer1",(long) (1500));
 //BA.debugLineNum = 308;BA.debugLine="timer1.Enabled=True";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 310;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 311;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 //BA.debugLineNum = 315;BA.debugLine="moon.Initialize";
mostCurrent._moon.Initialize();
 //BA.debugLineNum = 316;BA.debugLine="moon.AddAll(Array As String(\"فروردین\", \"اردیبهشت\"";
mostCurrent._moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
 //BA.debugLineNum = 319;BA.debugLine="strfun.Initialize";
mostCurrent._strfun._initialize(processBA);
 //BA.debugLineNum = 323;BA.debugLine="If(buy_index=1)Then";
if ((_buy_index==1)) { 
 //BA.debugLineNum = 324;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 //BA.debugLineNum = 325;BA.debugLine="buy_index=0";
_buy_index = (int) (0);
 };
 //BA.debugLineNum = 331;BA.debugLine="tim_msg.Initialize(\"tim_msg\",4000)";
_tim_msg.Initialize(processBA,"tim_msg",(long) (4000));
 //BA.debugLineNum = 333;BA.debugLine="ls1.Initialize";
mostCurrent._ls1.Initialize();
 //BA.debugLineNum = 334;BA.debugLine="ls2.Initialize";
mostCurrent._ls2.Initialize();
 //BA.debugLineNum = 335;BA.debugLine="ls3.Initialize";
mostCurrent._ls3.Initialize();
 //BA.debugLineNum = 338;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1"))) { 
 //BA.debugLineNum = 339;BA.debugLine="ls1=File.ReadList(File.DirInternal,\"ls1\")";
mostCurrent._ls1 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1");
 //BA.debugLineNum = 340;BA.debugLine="ls2=File.ReadList(File.DirInternal,\"ls2\")";
mostCurrent._ls2 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls2");
 //BA.debugLineNum = 341;BA.debugLine="ls3=File.ReadList(File.DirInternal,\"ls3\")";
mostCurrent._ls3 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls3");
 //BA.debugLineNum = 343;BA.debugLine="last_notif=ls1.Get(ls1.Size-1)";
mostCurrent._last_notif = BA.ObjectToString(mostCurrent._ls1.Get((int) (mostCurrent._ls1.getSize()-1)));
 //BA.debugLineNum = 344;BA.debugLine="is_now_instal=False";
_is_now_instal = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 352;BA.debugLine="If(myfunc.check_karid=True)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 353;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
 }else {
 //BA.debugLineNum = 355;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
 };
 //BA.debugLineNum = 377;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
int _result = 0;
 //BA.debugLineNum = 1638;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 1639;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 1640;BA.debugLine="If (pan_all_msgNewYear.Visible=True)Then";
if ((mostCurrent._pan_all_msgnewyear.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1641;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_help.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1644;BA.debugLine="lbl_close_help_Click";
_lbl_close_help_click();
 }else if((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1648;BA.debugLine="If(pan_all2.Visible=True)Then";
if ((mostCurrent._pan_all2.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1649;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 1651;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }else if((mostCurrent._pan_notifi_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1655;BA.debugLine="lbl_close_notif_Click";
_lbl_close_notif_click();
 }else if((_index_page==2 || _index_page==3)) { 
 //BA.debugLineNum = 1657;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 }else if((mostCurrent._pan_all_noskhe.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1659;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
 }else if((mostCurrent._pan_all_litemenu.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1661;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 1665;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 1666;BA.debugLine="result = Msgbox2(\"آیا قصد خروج دارید؟\", \"خروج\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا قصد خروج دارید؟"),BA.ObjectToCharSequence("خروج"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 1667;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 1668;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 };
 };
 //BA.debugLineNum = 1674;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 1676;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1678;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 573;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 575;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 569;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 571;BA.debugLine="End Sub";
return "";
}
public static String  _add_end() throws Exception{
boolean _chek = false;
anywheresoftware.b4a.objects.collections.List _alist = null;
 //BA.debugLineNum = 1370;BA.debugLine="Sub add_end";
 //BA.debugLineNum = 1371;BA.debugLine="Dim chek As Boolean";
_chek = false;
 //BA.debugLineNum = 1372;BA.debugLine="chek=myfunc.check_karid";
_chek = mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1373;BA.debugLine="Dim alist As List";
_alist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1374;BA.debugLine="alist.Initialize";
_alist.Initialize();
 //BA.debugLineNum = 1376;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 1377;BA.debugLine="Select myfunc.fa2en(persianDate.PersianMonth)";
switch (BA.switchObjectToInt(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth())),BA.NumberToString(0),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9),BA.NumberToString(10),BA.NumberToString(11),BA.NumberToString(12))) {
case 0: {
 //BA.debugLineNum = 1379;BA.debugLine="moon_num=\"01\"";
_moon_num = "01";
 break; }
case 1: {
 //BA.debugLineNum = 1381;BA.debugLine="moon_num=\"02\"";
_moon_num = "02";
 break; }
case 2: {
 //BA.debugLineNum = 1383;BA.debugLine="moon_num=\"03\"";
_moon_num = "03";
 break; }
case 3: {
 //BA.debugLineNum = 1385;BA.debugLine="moon_num=\"04\"";
_moon_num = "04";
 break; }
case 4: {
 //BA.debugLineNum = 1387;BA.debugLine="moon_num=\"05\"";
_moon_num = "05";
 break; }
case 5: {
 //BA.debugLineNum = 1389;BA.debugLine="moon_num=\"06\"";
_moon_num = "06";
 break; }
case 6: {
 //BA.debugLineNum = 1391;BA.debugLine="moon_num=\"07\"";
_moon_num = "07";
 break; }
case 7: {
 //BA.debugLineNum = 1393;BA.debugLine="moon_num=\"08\"";
_moon_num = "08";
 break; }
case 8: {
 //BA.debugLineNum = 1395;BA.debugLine="moon_num=\"09\"";
_moon_num = "09";
 break; }
case 9: {
 //BA.debugLineNum = 1397;BA.debugLine="moon_num=\"10\"";
_moon_num = "10";
 break; }
case 10: {
 //BA.debugLineNum = 1399;BA.debugLine="moon_num=\"11\"";
_moon_num = "11";
 break; }
case 11: {
 //BA.debugLineNum = 1401;BA.debugLine="moon_num=\"12\"";
_moon_num = "12";
 break; }
}
;
 //BA.debugLineNum = 1404;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(persianDate.Pe";
_alist = mostCurrent._myfunc._num_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear())),_moon_num);
 //BA.debugLineNum = 1407;BA.debugLine="If(index_box=1) Then";
if ((_index_box==1)) { 
 //BA.debugLineNum = 1408;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1409;BA.debugLine="If(alist.Get(0)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (0))))<5)) { 
 //BA.debugLineNum = 1410;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 }else {
 //BA.debugLineNum = 1412;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 1416;BA.debugLine="add_ezafe_sub";
_add_ezafe_sub();
 };
 }else if((_index_box==2)) { 
 //BA.debugLineNum = 1421;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1422;BA.debugLine="If(alist.Get(1)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (1))))<5)) { 
 //BA.debugLineNum = 1423;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 }else {
 //BA.debugLineNum = 1425;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 1428;BA.debugLine="add_morakhasi_sub";
_add_morakhasi_sub();
 };
 }else if((_index_box==3)) { 
 //BA.debugLineNum = 1433;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1434;BA.debugLine="If(alist.Get(3)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (3))))<5)) { 
 //BA.debugLineNum = 1435;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 }else {
 //BA.debugLineNum = 1437;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 1440;BA.debugLine="add_taradod_sub";
_add_taradod_sub();
 };
 }else if((_index_box==4)) { 
 //BA.debugLineNum = 1446;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1447;BA.debugLine="If(alist.Get(3)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (3))))<5)) { 
 //BA.debugLineNum = 1448;BA.debugLine="add_taradod_fast";
_add_taradod_fast();
 }else {
 //BA.debugLineNum = 1450;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 //BA.debugLineNum = 1451;BA.debugLine="lbl_tim_vorod_FT.Text=\"00:00\"";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 1452;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
 //BA.debugLineNum = 1453;BA.debugLine="pan_all_FT_Click";
_pan_all_ft_click();
 };
 }else {
 //BA.debugLineNum = 1456;BA.debugLine="add_taradod_fast";
_add_taradod_fast();
 };
 };
 //BA.debugLineNum = 1460;BA.debugLine="End Sub";
return "";
}
public static String  _add_ezafe_sub() throws Exception{
int _state_mod = 0;
String _str_mod = "";
anywheresoftware.b4a.objects.collections.List _ls_temp_time1 = null;
 //BA.debugLineNum = 1462;BA.debugLine="Sub add_ezafe_sub";
 //BA.debugLineNum = 1463;BA.debugLine="Dim state_mod As Int=0";
_state_mod = (int) (0);
 //BA.debugLineNum = 1464;BA.debugLine="Dim str_mod As String=\"\"";
_str_mod = "";
 //BA.debugLineNum = 1465;BA.debugLine="If(ckb_ezaf_taradod.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1466;BA.debugLine="state_mod=2";
_state_mod = (int) (2);
 //BA.debugLineNum = 1467;BA.debugLine="str_mod=\" (فوق العاده)- \"";
_str_mod = " (فوق العاده)- ";
 }else {
 //BA.debugLineNum = 1469;BA.debugLine="state_mod=0";
_state_mod = (int) (0);
 };
 //BA.debugLineNum = 1473;BA.debugLine="Try";
try { //BA.debugLineNum = 1475;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 1476;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0 || _day_bt!=0)) { 
 //BA.debugLineNum = 1479;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0)) { 
 //BA.debugLineNum = 1481;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 1485;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1486;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_ezafekari_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1487;BA.debugLine="myfunc.help_man(\"برای این تاریخ اضافه کاری وج";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"برای این تاریخ اضافه کاری وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید");
 }else {
 //BA.debugLineNum = 1489;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_mod+mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 1491;BA.debugLine="Dim ls_temp_time1 As List";
_ls_temp_time1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1492;BA.debugLine="ls_temp_time1.Initialize";
_ls_temp_time1.Initialize();
 //BA.debugLineNum = 1494;BA.debugLine="ls_temp_time1.Add(lbl_tim1.Text)";
_ls_temp_time1.Add((Object)(mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 1495;BA.debugLine="ls_temp_time1.Add(lbl_tim2.Text)";
_ls_temp_time1.Add((Object)(mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 1497;BA.debugLine="File.WriteList(File.DirInternal,\"temp_time1.t";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time1.txt",_ls_temp_time1);
 //BA.debugLineNum = 1499;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1500;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 1504;BA.debugLine="dbCode.edit_ezafekari(current_id_edit,date1,da";
mostCurrent._dbcode._edit_ezafekari /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_state_mod);
 //BA.debugLineNum = 1505;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1507;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 //BA.debugLineNum = 1508;BA.debugLine="TabHost1.CurrentTab=0";
mostCurrent._tabhost1.setCurrentTab((int) (0));
 };
 //BA.debugLineNum = 1511;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e39) {
			processBA.setLastException(e39); //BA.debugLineNum = 1517;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 1522;BA.debugLine="End Sub";
return "";
}
public static String  _add_morakhasi_sub() throws Exception{
String _str_noe2 = "";
 //BA.debugLineNum = 1524;BA.debugLine="Sub add_morakhasi_sub";
 //BA.debugLineNum = 1525;BA.debugLine="Dim str_noe2 As String";
_str_noe2 = "";
 //BA.debugLineNum = 1526;BA.debugLine="str_noe2=\"(\"&str_noe&\")- \"";
_str_noe2 = "("+mostCurrent._str_noe+")- ";
 //BA.debugLineNum = 1528;BA.debugLine="Try";
try { //BA.debugLineNum = 1529;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
if ((_day_bt<0 || _hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 1530;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0)) { 
 //BA.debugLineNum = 1532;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0 && _day_bt==0)) { 
 //BA.debugLineNum = 1534;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 1539;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1540;BA.debugLine="If(dbCode.isexist_morakhasi_by_date(date1)=Tru";
if ((mostCurrent._dbcode._isexist_morakhasi_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1541;BA.debugLine="myfunc.help_man(\"برای این تاریخ مرخصی وجود دا";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"برای این تاریخ مرخصی وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید");
 }else {
 //BA.debugLineNum = 1543;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Tex";
mostCurrent._dbcode._add_morakhasi /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_noe2+mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
 //BA.debugLineNum = 1544;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1545;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 1548;BA.debugLine="dbCode.edit_morakhasi(current_id_edit,date1,da";
mostCurrent._dbcode._edit_morakhasi /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),_index_noe_morakhasi);
 //BA.debugLineNum = 1550;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1551;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 //BA.debugLineNum = 1552;BA.debugLine="TabHost1.CurrentTab=1";
mostCurrent._tabhost1.setCurrentTab((int) (1));
 };
 //BA.debugLineNum = 1557;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e28) {
			processBA.setLastException(e28); //BA.debugLineNum = 1563;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 1568;BA.debugLine="End Sub";
return "";
}
public static String  _add_taradod_fast() throws Exception{
String _str_ft1 = "";
int _tim_min2 = 0;
int _dagige_fixed = 0;
String _saat_fixed = "";
String _str_ft2 = "";
String _str_ft3 = "";
 //BA.debugLineNum = 3141;BA.debugLine="Sub add_taradod_fast";
 //BA.debugLineNum = 3143;BA.debugLine="Try";
try { //BA.debugLineNum = 3145;BA.debugLine="If(dbCode.isexist_taradod_by_date(lbl_date_FT.Te";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText())==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 3147;BA.debugLine="Dim str_Ft1 As String=et_tozihat_FT.Text";
_str_ft1 = mostCurrent._et_tozihat_ft.getText();
 //BA.debugLineNum = 3148;BA.debugLine="If (ckb_ezaf_taradod_FT.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod_ft.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 3151;BA.debugLine="dbCode.add_taradod(lbl_date_FT.Text,lbl_date_F";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),(int) (0),(int) (0),(int) (0),_str_ft1,(int) (20));
 }else {
 //BA.debugLineNum = 3155;BA.debugLine="dbCode.add_taradod(lbl_date_FT.Text,lbl_date_F";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),(int) (0),(int) (0),(int) (0),_str_ft1,(int) (10));
 };
 //BA.debugLineNum = 3158;BA.debugLine="Log(\"is frest\")";
anywheresoftware.b4a.keywords.Common.LogImpl("27012369","is frest",0);
 //BA.debugLineNum = 3159;BA.debugLine="ToastMessageShow(\"ورود ثبت شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ورود ثبت شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3162;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 3163;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 3169;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
 //BA.debugLineNum = 3171;BA.debugLine="If (ckb_ezaf_taradod_FT.Checked=True)Then";
if ((mostCurrent._ckb_ezaf_taradod_ft.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 3173;BA.debugLine="Dim tim_min2 As Int=(hour_bt*60)+min_bt";
_tim_min2 = (int) ((_hour_bt*60)+_min_bt);
 //BA.debugLineNum = 3176;BA.debugLine="If(tim_min2>saat_kar_min) Then";
if ((_tim_min2>_saat_kar_min)) { 
 //BA.debugLineNum = 3178;BA.debugLine="Dim dagige_fixed As Int = tim_vorod_conv_ezaf";
_dagige_fixed = _tim_vorod_conv_ezaf(mostCurrent._lbl_tim_vorod_ft.getText());
 //BA.debugLineNum = 3179;BA.debugLine="Dim saat_fixed As String = (myfunc.Min_to_saa";
_saat_fixed = BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_dagige_fixed).Get((int) (0))))+":"+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_dagige_fixed).Get((int) (1))));
 //BA.debugLineNum = 3181;BA.debugLine="dbCode.add_ezafekari(lbl_date_FT.Text,lbl_dat";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),_saat_fixed,mostCurrent._lbl_tim_khoroj_ft.getText(),_day_bt,(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min2-_saat_kar_min)).Get((int) (0))))),(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min2-_saat_kar_min)).Get((int) (1)))))," (ثبت سریع-تردد دارد)- ",(int) (0));
 };
 //BA.debugLineNum = 3184;BA.debugLine="Dim str_Ft2 As String=\"(ثبت سریع-اضافه کاری)-\"";
_str_ft2 = "(ثبت سریع-اضافه کاری)-"+mostCurrent._et_tozihat_ft.getText();
 //BA.debugLineNum = 3185;BA.debugLine="dbCode.edit_taradod(current_id_edit,lbl_date_F";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),_day_bt,_hour_bt,_min_bt,_str_ft2,(int) (21));
 }else {
 //BA.debugLineNum = 3187;BA.debugLine="Dim str_Ft3 As String=\"(ثبت سریع)-\"&et_tozihat";
_str_ft3 = "(ثبت سریع)-"+mostCurrent._et_tozihat_ft.getText();
 //BA.debugLineNum = 3188;BA.debugLine="dbCode.edit_taradod(current_id_edit,lbl_date_F";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText(),_day_bt,_hour_bt,_min_bt,_str_ft3,(int) (11));
 };
 //BA.debugLineNum = 3191;BA.debugLine="Log(\"is secend\")";
anywheresoftware.b4a.keywords.Common.LogImpl("27012402","is secend",0);
 //BA.debugLineNum = 3192;BA.debugLine="ToastMessageShow(\"خروج ثبت شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خروج ثبت شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3195;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 };
 } 
       catch (Exception e33) {
			processBA.setLastException(e33); //BA.debugLineNum = 3204;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 3208;BA.debugLine="End Sub";
return "";
}
public static String  _add_taradod_sub() throws Exception{
int _dagige_fixed = 0;
String _saat_fixed = "";
String _str_tozih1 = "";
String _str_tozih2 = "";
anywheresoftware.b4a.objects.collections.List _ls_temp_time2 = null;
 //BA.debugLineNum = 1571;BA.debugLine="Sub add_taradod_sub";
 //BA.debugLineNum = 1572;BA.debugLine="Try";
try { //BA.debugLineNum = 1574;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
if ((_hour_bt<0 || _min_bt<0)) { 
 //BA.debugLineNum = 1575;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_moon_bt!=0 || _year_bt!=0 || _day_bt!=0)) { 
 //BA.debugLineNum = 1578;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! زمان نادرست است"),anywheresoftware.b4a.keywords.Common.True);
 }else if((_hour_bt==0 && _min_bt==0)) { 
 //BA.debugLineNum = 1580;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا! انتخاب زمان  "),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 1585;BA.debugLine="If(is_for_edit=False)Then";
if ((_is_for_edit==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1586;BA.debugLine="If(dbCode.isexist_taradod_by_date(date1)=True)";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1587;BA.debugLine="myfunc.help_man(\"برای این تاریخ تردد وجود دار";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"برای این تاریخ تردد وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید");
 }else {
 //BA.debugLineNum = 1590;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_ez";
if ((mostCurrent._ckb_ezaf_taradod.getChecked()==anywheresoftware.b4a.keywords.Common.True && mostCurrent._ckb_ezaf_taradod.getEnabled()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1592;BA.debugLine="Dim dagige_fixed As Int = tim_vorod_conv_eza";
_dagige_fixed = _tim_vorod_conv_ezaf(mostCurrent._lbl_tim1.getText());
 //BA.debugLineNum = 1593;BA.debugLine="Dim saat_fixed As String = (myfunc.Min_to_sa";
_saat_fixed = BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_dagige_fixed).Get((int) (0))))+":"+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_dagige_fixed).Get((int) (1))));
 //BA.debugLineNum = 1595;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_t";
_str_tozih1 = "(تردد دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 1596;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-";
_str_tozih2 = "(اضافه کاری دارد)-"+mostCurrent._et_tozihat.getText();
 //BA.debugLineNum = 1598;BA.debugLine="dbCode.add_ezafekari(date1,date2,saat_fixed,";
mostCurrent._dbcode._add_ezafekari /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,_saat_fixed,mostCurrent._lbl_tim2.getText(),_day_bt,(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (0))))),(int)(BA.ObjectToNumber((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (1))))),_str_tozih1,(int) (0));
 //BA.debugLineNum = 1600;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,_str_tozih2,(int) (0));
 }else {
 //BA.debugLineNum = 1602;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
mostCurrent._dbcode._add_taradod /*boolean*/ (mostCurrent.activityBA,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
 };
 //BA.debugLineNum = 1605;BA.debugLine="Dim ls_temp_time2 As List";
_ls_temp_time2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1606;BA.debugLine="ls_temp_time2.Initialize";
_ls_temp_time2.Initialize();
 //BA.debugLineNum = 1608;BA.debugLine="ls_temp_time2.Add(lbl_tim1.Text)";
_ls_temp_time2.Add((Object)(mostCurrent._lbl_tim1.getText()));
 //BA.debugLineNum = 1609;BA.debugLine="ls_temp_time2.Add(lbl_tim2.Text)";
_ls_temp_time2.Add((Object)(mostCurrent._lbl_tim2.getText()));
 //BA.debugLineNum = 1611;BA.debugLine="File.WriteList(File.DirInternal,\"temp_time2.t";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time2.txt",_ls_temp_time2);
 //BA.debugLineNum = 1613;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1614;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 };
 }else {
 //BA.debugLineNum = 1617;BA.debugLine="dbCode.edit_taradod(current_id_edit,date1,date";
mostCurrent._dbcode._edit_taradod /*boolean*/ (mostCurrent.activityBA,_current_id_edit,mostCurrent._date1,mostCurrent._date2,mostCurrent._lbl_tim1.getText(),mostCurrent._lbl_tim2.getText(),_day_bt,_hour_bt,_min_bt,mostCurrent._et_tozihat.getText(),(int) (0));
 //BA.debugLineNum = 1619;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1620;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 //BA.debugLineNum = 1621;BA.debugLine="TabHost1.CurrentTab=2";
mostCurrent._tabhost1.setCurrentTab((int) (2));
 };
 //BA.debugLineNum = 1625;BA.debugLine="pan_all_Click";
_pan_all_click();
 };
 } 
       catch (Exception e40) {
			processBA.setLastException(e40); //BA.debugLineNum = 1630;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 1633;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_gozaresh_click() throws Exception{
 //BA.debugLineNum = 1092;BA.debugLine="Private Sub btn_menu_gozaresh_Click";
 //BA.debugLineNum = 1093;BA.debugLine="index_page=3";
_index_page = (int) (3);
 //BA.debugLineNum = 1094;BA.debugLine="pan_imag.Background=img3";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img3.getObject()));
 //BA.debugLineNum = 1096;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
 //BA.debugLineNum = 1097;BA.debugLine="pan_main.LoadLayout(\"gozaresh_layout\")";
mostCurrent._pan_main.LoadLayout("gozaresh_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 1099;BA.debugLine="sp_year_gozaresh.Add(\"1401\")";
mostCurrent._sp_year_gozaresh.Add("1401");
 //BA.debugLineNum = 1100;BA.debugLine="sp_year_gozaresh.Add(\"1400\")";
mostCurrent._sp_year_gozaresh.Add("1400");
 //BA.debugLineNum = 1101;BA.debugLine="sp_year_gozaresh.Add(\"1399\")";
mostCurrent._sp_year_gozaresh.Add("1399");
 //BA.debugLineNum = 1102;BA.debugLine="sp_year_gozaresh.Add(\"1398\")";
mostCurrent._sp_year_gozaresh.Add("1398");
 //BA.debugLineNum = 1104;BA.debugLine="sp_year_gozaresh.SelectedIndex=0";
mostCurrent._sp_year_gozaresh.setSelectedIndex((int) (0));
 //BA.debugLineNum = 1109;BA.debugLine="pan_hed_gozaresh.Color=color4";
mostCurrent._pan_hed_gozaresh.setColor(_color4);
 //BA.debugLineNum = 1114;BA.debugLine="list_gozareshat_id.Initialize";
mostCurrent._list_gozareshat_id.Initialize();
 //BA.debugLineNum = 1117;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
 //BA.debugLineNum = 1119;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 578;BA.debugLine="Private Sub btn_menu_home_Click";
 //BA.debugLineNum = 579;BA.debugLine="index_page=1";
_index_page = (int) (1);
 //BA.debugLineNum = 580;BA.debugLine="pan_imag.Background=img1";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img1.getObject()));
 //BA.debugLineNum = 582;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
 //BA.debugLineNum = 583;BA.debugLine="pan_main.LoadLayout(\"home_layout\")";
mostCurrent._pan_main.LoadLayout("home_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 584;BA.debugLine="scv_home_item.Panel.LoadLayout(\"home_item\")";
mostCurrent._scv_home_item.getPanel().LoadLayout("home_item",mostCurrent.activityBA);
 //BA.debugLineNum = 585;BA.debugLine="lbl_date_home.Text=myfunc.fa2en(persianDate.Persi";
mostCurrent._lbl_date_home.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianLongDate())));
 //BA.debugLineNum = 587;BA.debugLine="saat_kar_min =dbCode.get_setting_byName(\"saat_kar";
_saat_kar_min = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"saat_kar_darRoz")));
 //BA.debugLineNum = 589;BA.debugLine="If(saat_kar_min<18)Then";
if ((_saat_kar_min<18)) { 
 //BA.debugLineNum = 590;BA.debugLine="myfunc.help_man(\"لطفا ساعت کاری خود را تنظیم کنی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"لطفا ساعت کاری خود را تنظیم کنید");
 };
 //BA.debugLineNum = 593;BA.debugLine="Dim list_ezafekari As List";
_list_ezafekari = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 594;BA.debugLine="list_ezafekari.Initialize";
_list_ezafekari.Initialize();
 //BA.debugLineNum = 596;BA.debugLine="year_num=myfunc.fa2en(persianDate.PersianYear)";
_year_num = mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()));
 //BA.debugLineNum = 598;BA.debugLine="Select persianDate.PersianMonth";
switch (BA.switchObjectToInt(_persiandate.getPersianMonth(),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11),(int) (12))) {
case 0: {
 //BA.debugLineNum = 600;BA.debugLine="moon_num=\"01\"";
_moon_num = "01";
 break; }
case 1: {
 //BA.debugLineNum = 602;BA.debugLine="moon_num=\"02\"";
_moon_num = "02";
 break; }
case 2: {
 //BA.debugLineNum = 604;BA.debugLine="moon_num=\"03\"";
_moon_num = "03";
 break; }
case 3: {
 //BA.debugLineNum = 606;BA.debugLine="moon_num=\"04\"";
_moon_num = "04";
 break; }
case 4: {
 //BA.debugLineNum = 608;BA.debugLine="moon_num=\"05\"";
_moon_num = "05";
 break; }
case 5: {
 //BA.debugLineNum = 610;BA.debugLine="moon_num=\"06\"";
_moon_num = "06";
 break; }
case 6: {
 //BA.debugLineNum = 612;BA.debugLine="moon_num=\"07\"";
_moon_num = "07";
 break; }
case 7: {
 //BA.debugLineNum = 614;BA.debugLine="moon_num=\"08\"";
_moon_num = "08";
 break; }
case 8: {
 //BA.debugLineNum = 616;BA.debugLine="moon_num=\"09\"";
_moon_num = "09";
 break; }
case 9: {
 //BA.debugLineNum = 618;BA.debugLine="moon_num=\"10\"";
_moon_num = "10";
 break; }
case 10: {
 //BA.debugLineNum = 620;BA.debugLine="moon_num=\"11\"";
_moon_num = "11";
 break; }
case 11: {
 //BA.debugLineNum = 622;BA.debugLine="moon_num=\"12\"";
_moon_num = "12";
 break; }
}
;
 //BA.debugLineNum = 624;BA.debugLine="list_ezafekari=dbCode.all_ezafekari_mah(year_num,";
_list_ezafekari = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num,(int) (1));
 //BA.debugLineNum = 630;BA.debugLine="Dim list_morakhasi As List";
_list_morakhasi = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 631;BA.debugLine="list_morakhasi.Initialize";
_list_morakhasi.Initialize();
 //BA.debugLineNum = 633;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(year_num,";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_year_num,_moon_num);
 //BA.debugLineNum = 636;BA.debugLine="lbl_ezafekari_mah_m.Text=list_ezafekari.Get(1)&\"";
mostCurrent._lbl_ezafekari_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (1)))+" دقیقه "));
 //BA.debugLineNum = 637;BA.debugLine="lbl_ezafekari_mah_h.Text=list_ezafekari.Get(0)&\"";
mostCurrent._lbl_ezafekari_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_ezafekari.Get((int) (0)))+" ساعت "));
 //BA.debugLineNum = 639;BA.debugLine="lbl_morakhasi_mah_m.Text=list_morakhasi.Get(2)&\"";
mostCurrent._lbl_morakhasi_mah_m.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (2)))+" دقیقه "));
 //BA.debugLineNum = 640;BA.debugLine="lbl_morakhasi_mah_h.Text=list_morakhasi.Get(1)&\"";
mostCurrent._lbl_morakhasi_mah_h.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (1)))+" ساعت "));
 //BA.debugLineNum = 641;BA.debugLine="lbl_morakhasi_mah_d.Text=list_morakhasi.Get(0)&\"";
mostCurrent._lbl_morakhasi_mah_d.setText(BA.ObjectToCharSequence(BA.ObjectToString(_list_morakhasi.Get((int) (0)))+" روز "));
 //BA.debugLineNum = 643;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 645;BA.debugLine="lbl_vip.TextColor=0xFFFFD800";
mostCurrent._lbl_vip.setTextColor(((int)0xffffd800));
 //BA.debugLineNum = 646;BA.debugLine="lbl_vip2.Text=\"نسخه طلایی\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه طلایی"));
 }else {
 //BA.debugLineNum = 649;BA.debugLine="lbl_vip.TextColor=Colors.Green";
mostCurrent._lbl_vip.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 650;BA.debugLine="lbl_vip2.Text=\"نسخه هدیه\"";
mostCurrent._lbl_vip2.setText(BA.ObjectToCharSequence("نسخه هدیه"));
 };
 //BA.debugLineNum = 655;BA.debugLine="If (File.Exists(File.DirInternal,\"help_start\")=Fa";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 656;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 657;BA.debugLine="File.WriteString(File.DirInternal,\"help_start\",\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_start","");
 };
 //BA.debugLineNum = 663;BA.debugLine="If (File.Exists(File.DirInternal,\"setcolor.txt\"))";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt"))) { 
 //BA.debugLineNum = 664;BA.debugLine="Dim list_color As List";
_list_color = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 665;BA.debugLine="list_color.Initialize";
_list_color.Initialize();
 //BA.debugLineNum = 666;BA.debugLine="list_color = File.ReadList(File.DirInternal,\"set";
_list_color = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt");
 //BA.debugLineNum = 668;BA.debugLine="Dim col As List";
_col = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 669;BA.debugLine="col.Initialize";
_col.Initialize();
 //BA.debugLineNum = 671;BA.debugLine="Dim col_font As List";
_col_font = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 672;BA.debugLine="col_font.Initialize";
_col_font.Initialize();
 //BA.debugLineNum = 674;BA.debugLine="col=Regex.Split(\",\",list_color.Get(0))";
_col = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (0)))));
 //BA.debugLineNum = 675;BA.debugLine="col_font=Regex.Split(\",\",list_color.Get(1))";
_col_font = anywheresoftware.b4a.keywords.Common.ArrayToList(anywheresoftware.b4a.keywords.Common.Regex.Split(",",BA.ObjectToString(_list_color.Get((int) (1)))));
 //BA.debugLineNum = 679;BA.debugLine="color1= col.Get(0)";
_color1 = (int)(BA.ObjectToNumber(_col.Get((int) (0))));
 //BA.debugLineNum = 680;BA.debugLine="color2= col.Get(1)";
_color2 = (int)(BA.ObjectToNumber(_col.Get((int) (1))));
 //BA.debugLineNum = 681;BA.debugLine="color_index=col.Get(2)  'index color";
_color_index = (int)(BA.ObjectToNumber(_col.Get((int) (2))));
 //BA.debugLineNum = 682;BA.debugLine="color3= col.Get(3)";
_color3 = (int)(BA.ObjectToNumber(_col.Get((int) (3))));
 //BA.debugLineNum = 683;BA.debugLine="color4= col.Get(4)";
_color4 = (int)(BA.ObjectToNumber(_col.Get((int) (4))));
 //BA.debugLineNum = 684;BA.debugLine="color5= col.Get(5)";
_color5 = (int)(BA.ObjectToNumber(_col.Get((int) (5))));
 //BA.debugLineNum = 686;BA.debugLine="main_font=col_font.Get(0)";
_main_font = BA.ObjectToString(_col_font.Get((int) (0)));
 //BA.debugLineNum = 687;BA.debugLine="size_f1=col_font.Get(1)";
_size_f1 = (int)(BA.ObjectToNumber(_col_font.Get((int) (1))));
 //BA.debugLineNum = 688;BA.debugLine="size_f2=col_font.Get(2)";
_size_f2 = (int)(BA.ObjectToNumber(_col_font.Get((int) (2))));
 //BA.debugLineNum = 689;BA.debugLine="size_f3=col_font.Get(3)";
_size_f3 = (int)(BA.ObjectToNumber(_col_font.Get((int) (3))));
 }else {
 //BA.debugLineNum = 693;BA.debugLine="color_index=1";
_color_index = (int) (1);
 //BA.debugLineNum = 694;BA.debugLine="color1= 0XFF69AC00";
_color1 = ((int)0xff69ac00);
 //BA.debugLineNum = 695;BA.debugLine="color2= 0xFF00C7C7";
_color2 = ((int)0xff00c7c7);
 //BA.debugLineNum = 696;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 697;BA.debugLine="color4=0XFF69AC00";
_color4 = ((int)0xff69ac00);
 //BA.debugLineNum = 698;BA.debugLine="color5=0XFF69AC00";
_color5 = ((int)0xff69ac00);
 //BA.debugLineNum = 700;BA.debugLine="main_font=\"یکان\"";
_main_font = "یکان";
 //BA.debugLineNum = 701;BA.debugLine="size_f1=17";
_size_f1 = (int) (17);
 //BA.debugLineNum = 702;BA.debugLine="size_f2=15";
_size_f2 = (int) (15);
 //BA.debugLineNum = 703;BA.debugLine="size_f3=13";
_size_f3 = (int) (13);
 //BA.debugLineNum = 706;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(_color1)+","+BA.NumberToString(_color2)+","+BA.NumberToString(_color_index)+","+BA.NumberToString(_color3)+","+BA.NumberToString(_color4)+","+BA.NumberToString(_color5)+anywheresoftware.b4a.keywords.Common.CRLF+_main_font+","+BA.NumberToString(_size_f1)+","+BA.NumberToString(_size_f2)+","+BA.NumberToString(_size_f3));
 };
 //BA.debugLineNum = 714;BA.debugLine="Dim dw As GradientDrawable";
_dw = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
 //BA.debugLineNum = 715;BA.debugLine="Dim clr() As Int = Array  As Int(color1,color2)";
_clr = new int[]{_color1,_color2};
 //BA.debugLineNum = 716;BA.debugLine="dw.Initialize(\"TOP_BOTTOM\",clr)";
_dw.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),_clr);
 //BA.debugLineNum = 717;BA.debugLine="dw.CornerRadius=50dip";
_dw.setCornerRadius((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))));
 //BA.debugLineNum = 718;BA.debugLine="Panel1.Background=dw";
mostCurrent._panel1.setBackground((android.graphics.drawable.Drawable)(_dw.getObject()));
 //BA.debugLineNum = 726;BA.debugLine="lbl_box_title.Color=color4";
mostCurrent._lbl_box_title.setColor(_color4);
 //BA.debugLineNum = 735;BA.debugLine="get_today_shift";
_get_today_shift();
 //BA.debugLineNum = 738;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 746;BA.debugLine="End Sub";
return "";
}
public static String  _btn_menu_list_click() throws Exception{
 //BA.debugLineNum = 783;BA.debugLine="Private Sub btn_menu_list_Click";
 //BA.debugLineNum = 784;BA.debugLine="index_page=2";
_index_page = (int) (2);
 //BA.debugLineNum = 785;BA.debugLine="pan_imag.Background=img2";
mostCurrent._pan_imag.setBackground((android.graphics.drawable.Drawable)(mostCurrent._img2.getObject()));
 //BA.debugLineNum = 787;BA.debugLine="pan_main.RemoveAllViews";
mostCurrent._pan_main.RemoveAllViews();
 //BA.debugLineNum = 788;BA.debugLine="pan_main.LoadLayout(\"list_layout\")";
mostCurrent._pan_main.LoadLayout("list_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 791;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
 //BA.debugLineNum = 792;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
 //BA.debugLineNum = 793;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
 //BA.debugLineNum = 794;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
 //BA.debugLineNum = 796;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
 //BA.debugLineNum = 799;BA.debugLine="sp_year.SelectedIndex=0";
mostCurrent._sp_year.setSelectedIndex((int) (0));
 //BA.debugLineNum = 800;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(persianDate.Pe";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))))-1));
 //BA.debugLineNum = 802;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 803;BA.debugLine="Select sp_moon.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_moon.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11))) {
case 0: {
 //BA.debugLineNum = 805;BA.debugLine="moon_num=\"01\"";
_moon_num = "01";
 break; }
case 1: {
 //BA.debugLineNum = 807;BA.debugLine="moon_num=\"02\"";
_moon_num = "02";
 break; }
case 2: {
 //BA.debugLineNum = 809;BA.debugLine="moon_num=\"03\"";
_moon_num = "03";
 break; }
case 3: {
 //BA.debugLineNum = 811;BA.debugLine="moon_num=\"04\"";
_moon_num = "04";
 break; }
case 4: {
 //BA.debugLineNum = 813;BA.debugLine="moon_num=\"05\"";
_moon_num = "05";
 break; }
case 5: {
 //BA.debugLineNum = 815;BA.debugLine="moon_num=\"06\"";
_moon_num = "06";
 break; }
case 6: {
 //BA.debugLineNum = 817;BA.debugLine="moon_num=\"07\"";
_moon_num = "07";
 break; }
case 7: {
 //BA.debugLineNum = 819;BA.debugLine="moon_num=\"08\"";
_moon_num = "08";
 break; }
case 8: {
 //BA.debugLineNum = 821;BA.debugLine="moon_num=\"09\"";
_moon_num = "09";
 break; }
case 9: {
 //BA.debugLineNum = 823;BA.debugLine="moon_num=\"10\"";
_moon_num = "10";
 break; }
case 10: {
 //BA.debugLineNum = 825;BA.debugLine="moon_num=\"11\"";
_moon_num = "11";
 break; }
case 11: {
 //BA.debugLineNum = 827;BA.debugLine="moon_num=\"12\"";
_moon_num = "12";
 break; }
}
;
 //BA.debugLineNum = 831;BA.debugLine="TabHost1.AddTab(\"اضافه کاری ها\" , \"tab_layout_eza";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"اضافه کاری ها","tab_layout_ezafekari.bal");
 //BA.debugLineNum = 832;BA.debugLine="TabHost1.AddTab(\" مرخصی ها\" , \"tab_layout_morakha";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA," مرخصی ها","tab_layout_morakhasi.bal");
 //BA.debugLineNum = 833;BA.debugLine="TabHost1.AddTab(\" تردد ها\" , \"tab_layout_taradod.";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA," تردد ها","tab_layout_taradod.bal");
 //BA.debugLineNum = 836;BA.debugLine="TabHost1.CurrentTab=curent_tab_list";
mostCurrent._tabhost1.setCurrentTab(_curent_tab_list);
 //BA.debugLineNum = 838;BA.debugLine="list_ezafekari_id.Initialize";
mostCurrent._list_ezafekari_id.Initialize();
 //BA.debugLineNum = 841;BA.debugLine="list_morakhasi_id.Initialize";
mostCurrent._list_morakhasi_id.Initialize();
 //BA.debugLineNum = 844;BA.debugLine="list_taradod_id.Initialize";
mostCurrent._list_taradod_id.Initialize();
 //BA.debugLineNum = 848;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
 //BA.debugLineNum = 852;BA.debugLine="pan_hed_list.Color=color4";
mostCurrent._pan_hed_list.setColor(_color4);
 //BA.debugLineNum = 859;BA.debugLine="End Sub";
return "";
}
public static String  _cust_lv_taradod_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 2944;BA.debugLine="Private Sub cust_LV_taradod_ItemClick (Index As In";
 //BA.debugLineNum = 2946;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_gozareshat(String _year1) throws Exception{
 //BA.debugLineNum = 1121;BA.debugLine="Sub fill_list_gozareshat(year1 As String)";
 //BA.debugLineNum = 1122;BA.debugLine="CLV_gozaresh.Clear";
mostCurrent._clv_gozaresh._clear();
 //BA.debugLineNum = 1123;BA.debugLine="list_gozareshat_id.Clear";
mostCurrent._list_gozareshat_id.Clear();
 //BA.debugLineNum = 1125;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1126;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ORDER BY  id DESC;")));
 //BA.debugLineNum = 1127;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1130;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
mostCurrent._p = _xui.CreatePanel(processBA,"");
 //BA.debugLineNum = 1131;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 96%x, 114dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (114)));
 //BA.debugLineNum = 1132;BA.debugLine="p.LoadLayout(\"item_list_2\")";
mostCurrent._p.LoadLayout("item_list_2",mostCurrent.activityBA);
 //BA.debugLineNum = 1134;BA.debugLine="CLV_gozaresh.Add(p,dbCode.res.GetString(\"id\"))";
mostCurrent._clv_gozaresh._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1135;BA.debugLine="lbl_dateGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_dategozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date")));
 //BA.debugLineNum = 1136;BA.debugLine="lbl_nameGozaresh_CLV.Text=dbCode.res.GetString(\"";
mostCurrent._lbl_namegozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("title")));
 //BA.debugLineNum = 1137;BA.debugLine="lbl_tozihGozaresh_CLV.Text=dbCode.res.GetString(";
mostCurrent._lbl_tozihgozaresh_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozih")));
 //BA.debugLineNum = 1138;BA.debugLine="lbl_remove_from_list2.Tag=dbCode.res.GetString(\"";
mostCurrent._lbl_remove_from_list2.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1139;BA.debugLine="pan_item_gozaresh.Tag=dbCode.res.GetString(\"id\")";
mostCurrent._pan_item_gozaresh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1140;BA.debugLine="list_gozareshat_id.Add(dbCode.res.GetString(\"id\"";
mostCurrent._list_gozareshat_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1141;BA.debugLine="Log(dbCode.res.GetString(\"id\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("21441812",mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id"),0);
 }
;
 //BA.debugLineNum = 1143;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1144;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1146;BA.debugLine="End Sub";
return "";
}
public static String  _fill_lists(String _year1,String _moon1) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _str1 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _str2 = null;
anywheresoftware.b4a.objects.B4XViewWrapper _p2 = null;
 //BA.debugLineNum = 902;BA.debugLine="Sub fill_lists (year1 As String, moon1 As String)";
 //BA.debugLineNum = 906;BA.debugLine="cust_LV_ezafekari.Clear";
mostCurrent._cust_lv_ezafekari._clear();
 //BA.debugLineNum = 907;BA.debugLine="list_ezafekari_id.Clear";
mostCurrent._list_ezafekari_id.Clear();
 //BA.debugLineNum = 909;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 910;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  id DESC;")));
 //BA.debugLineNum = 911;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 912;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 913;BA.debugLine="str1.Initialize";
_str1.Initialize();
 //BA.debugLineNum = 914;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")).equals(BA.NumberToString(0)) == false)) { 
 //BA.debugLineNum = 915;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")+" روز ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 //BA.debugLineNum = 917;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")+" ساعت ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 918;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m")+" دقیقه ");
 //BA.debugLineNum = 922;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = _xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 923;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 134dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (134)));
 //BA.debugLineNum = 924;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
 //BA.debugLineNum = 926;BA.debugLine="cust_LV_ezafekari.Add(p,dbCode.res.GetString(\"id";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 927;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
 //BA.debugLineNum = 928;BA.debugLine="lbl_hour_CLV.Text=dbCode.res.GetString(\"time_fro";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
 //BA.debugLineNum = 929;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str1.ToString()));
 //BA.debugLineNum = 930;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 931;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 932;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 934;BA.debugLine="list_ezafekari_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_ezafekari_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
 //BA.debugLineNum = 939;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 940;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 942;BA.debugLine="If(cust_LV_ezafekari.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_ezafekari._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 943;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = _xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 944;BA.debugLine="Select cust_LV_ezafekari.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_ezafekari._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 946;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
 //BA.debugLineNum = 948;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 950;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 952;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 954;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 956;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 958;BA.debugLine="cust_LV_ezafekari.Add(p,\"\")";
mostCurrent._cust_lv_ezafekari._add(mostCurrent._p,(Object)(""));
 };
 //BA.debugLineNum = 962;BA.debugLine="cust_LV_morakhasi.Clear";
mostCurrent._cust_lv_morakhasi._clear();
 //BA.debugLineNum = 963;BA.debugLine="list_morakhasi_id.Clear";
mostCurrent._list_morakhasi_id.Clear();
 //BA.debugLineNum = 965;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 966;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  id DESC;")));
 //BA.debugLineNum = 967;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 968;BA.debugLine="Dim str2 As StringBuilder";
_str2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 969;BA.debugLine="str2.Initialize";
_str2.Initialize();
 //BA.debugLineNum = 970;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")).equals(BA.NumberToString(0)) == false)) { 
 //BA.debugLineNum = 971;BA.debugLine="str2.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
_str2.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")+" روز ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 //BA.debugLineNum = 973;BA.debugLine="str2.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
_str2.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")+" ساعت ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 974;BA.debugLine="str2.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
_str2.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m")+" دقیقه ");
 //BA.debugLineNum = 978;BA.debugLine="Dim p2 As B4XView = xui.CreatePanel(\"\")";
_p2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p2 = _xui.CreatePanel(processBA,"");
 //BA.debugLineNum = 979;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 134dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (134)));
 //BA.debugLineNum = 980;BA.debugLine="p2.LoadLayout(\"item_list\")";
_p2.LoadLayout("item_list",mostCurrent.activityBA);
 //BA.debugLineNum = 982;BA.debugLine="cust_LV_morakhasi.Add(p2,dbCode.res.GetString(\"i";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 983;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
 //BA.debugLineNum = 984;BA.debugLine="lbl_hour_CLV.Text=dbCode.res.GetString(\"time_fro";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
 //BA.debugLineNum = 985;BA.debugLine="lbl_time_CLV.Text=str2.ToString";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(_str2.ToString()));
 //BA.debugLineNum = 986;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 987;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 988;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 990;BA.debugLine="list_morakhasi_id.Add(dbCode.res.GetString(\"id\")";
mostCurrent._list_morakhasi_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
 //BA.debugLineNum = 995;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 996;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1002;BA.debugLine="If(cust_LV_morakhasi.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_morakhasi._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 1003;BA.debugLine="p2 = xui.CreatePanel(\"p\")";
_p2 = _xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1004;BA.debugLine="Select cust_LV_morakhasi.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_morakhasi._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 1006;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
 //BA.debugLineNum = 1008;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 1010;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 1012;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 1014;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 1016;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
_p2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 1018;BA.debugLine="cust_LV_morakhasi.Add(p2,\"\")";
mostCurrent._cust_lv_morakhasi._add(_p2,(Object)(""));
 };
 //BA.debugLineNum = 1023;BA.debugLine="cust_LV_taradod.Clear";
mostCurrent._cust_lv_taradod._clear();
 //BA.debugLineNum = 1024;BA.debugLine="list_taradod_id.Clear";
mostCurrent._list_taradod_id.Clear();
 //BA.debugLineNum = 1026;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1027;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ORDER BY  id DESC;")));
 //BA.debugLineNum = 1028;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 1029;BA.debugLine="Dim str1 As StringBuilder";
_str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1030;BA.debugLine="str1.Initialize";
_str1.Initialize();
 //BA.debugLineNum = 1031;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")).equals(BA.NumberToString(0)) == false)) { 
 //BA.debugLineNum = 1032;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")+" روز ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 //BA.debugLineNum = 1034;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")+" ساعت ").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 1035;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
_str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m")+" دقیقه ");
 //BA.debugLineNum = 1039;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = _xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1040;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 134dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (134)));
 //BA.debugLineNum = 1041;BA.debugLine="p.LoadLayout(\"item_list\")";
mostCurrent._p.LoadLayout("item_list",mostCurrent.activityBA);
 //BA.debugLineNum = 1043;BA.debugLine="cust_LV_taradod.Add(p,dbCode.res.GetString(\"id\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1044;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
mostCurrent._lbl_date_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from")+" - "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to")));
 //BA.debugLineNum = 1045;BA.debugLine="lbl_hour_CLV.Text=\" ورود : \"&dbCode.res.GetStrin";
mostCurrent._lbl_hour_clv.setText(BA.ObjectToCharSequence(" ورود : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")+" -- "+" خروج : "+mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
 //BA.debugLineNum = 1047;BA.debugLine="lbl_time_CLV.Typeface=Typeface.MATERIALICONS";
mostCurrent._lbl_time_clv.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
 //BA.debugLineNum = 1048;BA.debugLine="lbl_time_CLV.Text=Chr(0xE8D5)";
mostCurrent._lbl_time_clv.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xe8d5))));
 //BA.debugLineNum = 1049;BA.debugLine="lbl_time_CLV.TextSize=25";
mostCurrent._lbl_time_clv.setTextSize((float) (25));
 //BA.debugLineNum = 1051;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._lbl_tozih_clv.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 1052;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1053;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 1055;BA.debugLine="list_taradod_id.Add(dbCode.res.GetString(\"id\"))";
mostCurrent._list_taradod_id.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
 //BA.debugLineNum = 1060;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 1061;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 1063;BA.debugLine="If(cust_LV_taradod.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_taradod._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 1064;BA.debugLine="p = xui.CreatePanel(\"p\")";
mostCurrent._p = _xui.CreatePanel(processBA,"p");
 //BA.debugLineNum = 1065;BA.debugLine="Select cust_LV_taradod.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_taradod._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 1067;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((mostCurrent._tabhost1.getHeight()-100)));
 break; }
case 1: {
 //BA.debugLineNum = 1069;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 1071;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 1073;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 1075;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 1077;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 1079;BA.debugLine="cust_LV_taradod.Add(p,\"\")";
mostCurrent._cust_lv_taradod._add(mostCurrent._p,(Object)(""));
 };
 //BA.debugLineNum = 1085;BA.debugLine="End Sub";
return "";
}
public static String  _get_dataedit_byid(int _id1) throws Exception{
 //BA.debugLineNum = 2742;BA.debugLine="Sub get_dataEdit_byId(id1 As Int)";
 //BA.debugLineNum = 2743;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 2744;BA.debugLine="If(index_box=1)Then";
if ((_index_box==1)) { 
 //BA.debugLineNum = 2745;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE id="+BA.NumberToString(_id1))));
 //BA.debugLineNum = 2746;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 2748;BA.debugLine="If(dbCode.res.GetInt(\"state\")=0)Then";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==0)) { 
 //BA.debugLineNum = 2749;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 2751;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
 }else if((_index_box==2)) { 
 //BA.debugLineNum = 2757;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE id="+BA.NumberToString(_id1))));
 //BA.debugLineNum = 2758;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 2761;BA.debugLine="Select dbCode.res.GetInt(\"state\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state"),(int) (0),(int) (1),(int) (2),(int) (3))) {
case 0: {
 //BA.debugLineNum = 2763;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
 //BA.debugLineNum = 2765;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
 //BA.debugLineNum = 2767;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
 //BA.debugLineNum = 2769;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
 //BA.debugLineNum = 2773;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
 //BA.debugLineNum = 2774;BA.debugLine="index_noe_morakhasi=dbCode.res.GetInt(\"state\")";
_index_noe_morakhasi = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state");
 }else if((_index_box==3)) { 
 //BA.debugLineNum = 2779;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE id="+BA.NumberToString(_id1))));
 //BA.debugLineNum = 2780;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 };
 //BA.debugLineNum = 2787;BA.debugLine="lbl_tim1.Text=dbCode.res.GetString(\"time_from\")";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")));
 //BA.debugLineNum = 2788;BA.debugLine="lbl_tim2.Text=dbCode.res.GetString(\"time_to\")";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
 //BA.debugLineNum = 2790;BA.debugLine="lbl_date1.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))));
 //BA.debugLineNum = 2791;BA.debugLine="lbl_date2.Text=myfunc.fa2en(dbCode.res.GetString(";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))));
 //BA.debugLineNum = 2793;BA.debugLine="et_tozihat.Text=dbCode.res.GetString(\"tozihat\")";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 2796;BA.debugLine="End Sub";
return "";
}
public static String  _get_today_shift() throws Exception{
int _id_today = 0;
String _str_sh = "";
 //BA.debugLineNum = 750;BA.debugLine="Sub get_today_shift";
 //BA.debugLineNum = 751;BA.debugLine="Dim id_today As Int";
_id_today = 0;
 //BA.debugLineNum = 752;BA.debugLine="id_today=dbCode.get_day_id(persianDate.PersianYea";
_id_today = mostCurrent._dbcode._get_day_id /*int*/ (mostCurrent.activityBA,_persiandate.getPersianYear(),_persiandate.getPersianMonth(),_persiandate.getPersianDay());
 //BA.debugLineNum = 754;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 755;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id_today))));
 //BA.debugLineNum = 757;BA.debugLine="dbCode.res.Position = 0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 761;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift")).equals("") == false)) { 
 //BA.debugLineNum = 762;BA.debugLine="Dim str_sh As String";
_str_sh = "";
 //BA.debugLineNum = 763;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
switch (BA.switchObjectToInt(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("shift"),"ر","ش","ع","ا")) {
case 0: {
 //BA.debugLineNum = 765;BA.debugLine="str_sh=\"روزکار\"";
_str_sh = "روزکار";
 break; }
case 1: {
 //BA.debugLineNum = 767;BA.debugLine="str_sh=\"شبکار\"";
_str_sh = "شبکار";
 break; }
case 2: {
 //BA.debugLineNum = 769;BA.debugLine="str_sh=\"عصرکار\"";
_str_sh = "عصرکار";
 break; }
case 3: {
 //BA.debugLineNum = 771;BA.debugLine="str_sh=\"استراحت\"";
_str_sh = "استراحت";
 break; }
}
;
 //BA.debugLineNum = 773;BA.debugLine="lbl_shift_home.Text=\"(\"&str_sh&\")\"";
mostCurrent._lbl_shift_home.setText(BA.ObjectToCharSequence("("+_str_sh+")"));
 };
 //BA.debugLineNum = 778;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 56;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 60;BA.debugLine="Dim xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 62;BA.debugLine="Private lbl_date_home As Label";
mostCurrent._lbl_date_home = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 65;BA.debugLine="Private pan_all As Panel";
mostCurrent._pan_all = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 66;BA.debugLine="Private lbl_box_title As Label";
mostCurrent._lbl_box_title = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 71;BA.debugLine="Dim index_box As Int";
_index_box = 0;
 //BA.debugLineNum = 72;BA.debugLine="Dim year_bt As Int =0";
_year_bt = (int) (0);
 //BA.debugLineNum = 73;BA.debugLine="Dim moon_bt As Int =0";
_moon_bt = (int) (0);
 //BA.debugLineNum = 74;BA.debugLine="Dim day_bt As Int =0";
_day_bt = (int) (0);
 //BA.debugLineNum = 75;BA.debugLine="Dim hour_bt As Int =0";
_hour_bt = (int) (0);
 //BA.debugLineNum = 76;BA.debugLine="Dim min_bt As Int =0";
_min_bt = (int) (0);
 //BA.debugLineNum = 77;BA.debugLine="Dim num As Int=0  '' for time picker";
_num = (int) (0);
 //BA.debugLineNum = 78;BA.debugLine="Dim moon As List  '' for date picker";
mostCurrent._moon = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 80;BA.debugLine="Dim date1 As String";
mostCurrent._date1 = "";
 //BA.debugLineNum = 81;BA.debugLine="Dim date2 As String";
mostCurrent._date2 = "";
 //BA.debugLineNum = 83;BA.debugLine="Dim list_ezafekari_id As List";
mostCurrent._list_ezafekari_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 84;BA.debugLine="Dim list_morakhasi_id As List";
mostCurrent._list_morakhasi_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 85;BA.debugLine="Dim list_taradod_id As List";
mostCurrent._list_taradod_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 86;BA.debugLine="Dim list_gozareshat_id As List";
mostCurrent._list_gozareshat_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 89;BA.debugLine="Dim curent_tab_list As Int =0";
_curent_tab_list = (int) (0);
 //BA.debugLineNum = 92;BA.debugLine="Private pan_main As Panel";
mostCurrent._pan_main = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 93;BA.debugLine="Private pan_imag As Panel";
mostCurrent._pan_imag = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 96;BA.debugLine="Private TabHost1 As TabHost";
mostCurrent._tabhost1 = new anywheresoftware.b4a.objects.TabHostWrapper();
 //BA.debugLineNum = 100;BA.debugLine="Dim img1 As BitmapDrawable";
mostCurrent._img1 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 101;BA.debugLine="Dim img2 As BitmapDrawable";
mostCurrent._img2 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 102;BA.debugLine="Dim img3 As BitmapDrawable";
mostCurrent._img3 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 106;BA.debugLine="Dim index_page As Int";
_index_page = 0;
 //BA.debugLineNum = 107;BA.debugLine="Dim index_piker As Int";
_index_piker = 0;
 //BA.debugLineNum = 110;BA.debugLine="Private lbl_time_show As Label";
mostCurrent._lbl_time_show = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 111;BA.debugLine="Private pik_min1 As Label";
mostCurrent._pik_min1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 112;BA.debugLine="Private pik_hour1 As Label";
mostCurrent._pik_hour1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 116;BA.debugLine="Private pik_day1 As Label";
mostCurrent._pik_day1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 117;BA.debugLine="Private pik_year1 As Label";
mostCurrent._pik_year1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 118;BA.debugLine="Private pik_moon1 As Label";
mostCurrent._pik_moon1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 120;BA.debugLine="Private sp_moon As Spinner";
mostCurrent._sp_moon = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 121;BA.debugLine="Private sp_year As Spinner";
mostCurrent._sp_year = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 122;BA.debugLine="Private et_tozihat As EditText";
mostCurrent._et_tozihat = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 123;BA.debugLine="Private scv_home_item As ScrollView";
mostCurrent._scv_home_item = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 124;BA.debugLine="Private lbl_tim1 As Label";
mostCurrent._lbl_tim1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 125;BA.debugLine="Private lbl_date1 As Label";
mostCurrent._lbl_date1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 126;BA.debugLine="Private lbl_date2 As Label";
mostCurrent._lbl_date2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 127;BA.debugLine="Private lbl_tim2 As Label";
mostCurrent._lbl_tim2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 128;BA.debugLine="Private pan_picker As Panel";
mostCurrent._pan_picker = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 129;BA.debugLine="Private pan_all2 As Panel";
mostCurrent._pan_all2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 132;BA.debugLine="Dim strfun As StringFunctions";
mostCurrent._strfun = new adr.stringfunctions.stringfunctions();
 //BA.debugLineNum = 134;BA.debugLine="Private cust_LV_ezafekari As CustomListView";
mostCurrent._cust_lv_ezafekari = new b4a.example3.customlistview();
 //BA.debugLineNum = 135;BA.debugLine="Private lbl_date_CLV As Label";
mostCurrent._lbl_date_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 136;BA.debugLine="Private lbl_time_CLV As Label";
mostCurrent._lbl_time_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 137;BA.debugLine="Private lbl_hour_CLV As Label";
mostCurrent._lbl_hour_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 138;BA.debugLine="Private lbl_tozih_CLV As Label";
mostCurrent._lbl_tozih_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 139;BA.debugLine="Private cust_LV_morakhasi As CustomListView";
mostCurrent._cust_lv_morakhasi = new b4a.example3.customlistview();
 //BA.debugLineNum = 140;BA.debugLine="Private CLV_gozaresh As CustomListView";
mostCurrent._clv_gozaresh = new b4a.example3.customlistview();
 //BA.debugLineNum = 141;BA.debugLine="Private lbl_dateGozaresh_CLV As Label";
mostCurrent._lbl_dategozaresh_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 142;BA.debugLine="Private lbl_nameGozaresh_CLV As Label";
mostCurrent._lbl_namegozaresh_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 143;BA.debugLine="Private lbl_tozihGozaresh_CLV As Label";
mostCurrent._lbl_tozihgozaresh_clv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 144;BA.debugLine="Private lbl_ezafekari_mah_m As Label";
mostCurrent._lbl_ezafekari_mah_m = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 145;BA.debugLine="Private lbl_ezafekari_mah_h As Label";
mostCurrent._lbl_ezafekari_mah_h = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 146;BA.debugLine="Private lbl_morakhasi_mah_m As Label";
mostCurrent._lbl_morakhasi_mah_m = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 147;BA.debugLine="Private lbl_morakhasi_mah_h As Label";
mostCurrent._lbl_morakhasi_mah_h = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 148;BA.debugLine="Private lbl_morakhasi_mah_d As Label";
mostCurrent._lbl_morakhasi_mah_d = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 154;BA.debugLine="Dim p As B4XView";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 157;BA.debugLine="Dim key As String= \"MIHNMA0GCSqGSIb3DQEBAQUAA4G7A";
mostCurrent._key = "MIHNMA0GCSqGSIb3DQEBAQUAA4G7ADCBtwKBrwDZmEdlPq6691EaSKn8zBkr1hyrYE3RPU4xYwuVh69GnEP3HIKQhrEYqti4EL5re8GJS4itFD5nfbmy+U67aqJcl9zcWWpRIBtQN9wYZF8vZ1Ooz/8h2V4hjiVjRZ9MO/o68voESDIpdYTsj4yyapRRZe9iLosW7lH3ZCHStJFWZQiC0WyJ69HYB3v94DchwDd1EE2HNJwcGR/x4okAI5AFLrfIsMgQAyy32Rl6t8UCAwEAAQ==";
 //BA.debugLineNum = 160;BA.debugLine="Dim inapp As BillingManager3";
mostCurrent._inapp = new anywheresoftware.b4a.inappbilling3.BillingManager3();
 //BA.debugLineNum = 161;BA.debugLine="Private lbl_vip As Label";
mostCurrent._lbl_vip = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 163;BA.debugLine="Private img_help As ImageView";
mostCurrent._img_help = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 164;BA.debugLine="Dim index_x_start_swap As Int=0";
_index_x_start_swap = (int) (0);
 //BA.debugLineNum = 165;BA.debugLine="Dim index_curent_img As Int=1";
_index_curent_img = (int) (1);
 //BA.debugLineNum = 166;BA.debugLine="Private pan_help As Panel";
mostCurrent._pan_help = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 167;BA.debugLine="Private lbl_remove_from_list As Label";
mostCurrent._lbl_remove_from_list = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 168;BA.debugLine="Private lbl_remove_from_list2 As Label";
mostCurrent._lbl_remove_from_list2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 170;BA.debugLine="Private cv_loader As B4XLoadingIndicator";
mostCurrent._cv_loader = new ir.taravatgroup.ezafekari2.b4xloadingindicator();
 //BA.debugLineNum = 171;BA.debugLine="Private lbl_vip2 As Label";
mostCurrent._lbl_vip2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 172;BA.debugLine="Private lbl_show_vip As Label";
mostCurrent._lbl_show_vip = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 173;BA.debugLine="Private lbl_vip_now As Label";
mostCurrent._lbl_vip_now = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 174;BA.debugLine="Private pan_all_noskhe As Panel";
mostCurrent._pan_all_noskhe = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 177;BA.debugLine="Private pik_min_bala1 As Label";
mostCurrent._pik_min_bala1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 178;BA.debugLine="Private pik_hour_bala1 As Label";
mostCurrent._pik_hour_bala1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 179;BA.debugLine="Private pik_min_paeen1 As Label";
mostCurrent._pik_min_paeen1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 180;BA.debugLine="Private pik_hour_paeen1 As Label";
mostCurrent._pik_hour_paeen1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 181;BA.debugLine="Private scroll_v_noskhe As ScrollView";
mostCurrent._scroll_v_noskhe = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 184;BA.debugLine="Dim bit_img0 As Bitmap";
mostCurrent._bit_img0 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 185;BA.debugLine="Dim bit_img1 As Bitmap";
mostCurrent._bit_img1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 186;BA.debugLine="Dim bit_img2 As Bitmap";
mostCurrent._bit_img2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 187;BA.debugLine="Dim bit_img3 As Bitmap";
mostCurrent._bit_img3 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 188;BA.debugLine="Dim bit_img4 As Bitmap";
mostCurrent._bit_img4 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 191;BA.debugLine="Private lbl_close_help As Label";
mostCurrent._lbl_close_help = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 192;BA.debugLine="Private lbl_time_as As Label";
mostCurrent._lbl_time_as = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 193;BA.debugLine="Private lbl_time_ta As Label";
mostCurrent._lbl_time_ta = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 194;BA.debugLine="Private cust_LV_taradod As CustomListView";
mostCurrent._cust_lv_taradod = new b4a.example3.customlistview();
 //BA.debugLineNum = 196;BA.debugLine="Dim ht As HttpJob";
mostCurrent._ht = new ir.taravatgroup.ezafekari2.httpjob();
 //BA.debugLineNum = 198;BA.debugLine="Dim msg As String=\"\"";
mostCurrent._msg = "";
 //BA.debugLineNum = 200;BA.debugLine="Private pan_notifi_all As Panel";
mostCurrent._pan_notifi_all = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 201;BA.debugLine="Private web_msg_show As WebView";
mostCurrent._web_msg_show = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 204;BA.debugLine="Dim ls1 As List		'num msg";
mostCurrent._ls1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 205;BA.debugLine="Dim ls2 As List		'msg";
mostCurrent._ls2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 206;BA.debugLine="Dim ls3 As List		'date msg";
mostCurrent._ls3 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 208;BA.debugLine="Dim last_notif As String =\"0000\"";
mostCurrent._last_notif = "0000";
 //BA.debugLineNum = 209;BA.debugLine="Dim is_now_instal As Boolean=True";
_is_now_instal = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 211;BA.debugLine="Private lbl_title_msgPan As Label";
mostCurrent._lbl_title_msgpan = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 212;BA.debugLine="Private pan_notif As Panel";
mostCurrent._pan_notif = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 216;BA.debugLine="Private ckb_ezaf_taradod As CheckBox";
mostCurrent._ckb_ezaf_taradod = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 217;BA.debugLine="Private lbl_ezaf_taradod As Label";
mostCurrent._lbl_ezaf_taradod = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 218;BA.debugLine="Private pan_ezaf_taradod As Panel";
mostCurrent._pan_ezaf_taradod = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 219;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 220;BA.debugLine="Private pan_hed_list As Panel";
mostCurrent._pan_hed_list = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 221;BA.debugLine="Private pan_hed_gozaresh As Panel";
mostCurrent._pan_hed_gozaresh = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 226;BA.debugLine="Private pan_all_msgNewYear As Panel";
mostCurrent._pan_all_msgnewyear = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 227;BA.debugLine="Private lbl_majmoe_saat As Label";
mostCurrent._lbl_majmoe_saat = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 228;BA.debugLine="Private pan_all_liteMenu As Panel";
mostCurrent._pan_all_litemenu = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 229;BA.debugLine="Private lbl_shift_home As Label";
mostCurrent._lbl_shift_home = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 230;BA.debugLine="Private sp_year_gozaresh As Spinner";
mostCurrent._sp_year_gozaresh = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 231;BA.debugLine="Private pan_item_gozaresh As Panel";
mostCurrent._pan_item_gozaresh = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 234;BA.debugLine="Dim rsPOP_noe As RSPopupMenu";
mostCurrent._rspop_noe = new com.rootsoft.rspopupmenu.RSPopupMenu();
 //BA.debugLineNum = 235;BA.debugLine="Dim index_noe_morakhasi As Int=0";
_index_noe_morakhasi = (int) (0);
 //BA.debugLineNum = 236;BA.debugLine="Dim str_noe As String=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 //BA.debugLineNum = 237;BA.debugLine="Private lbl_edit_from_list As Label";
mostCurrent._lbl_edit_from_list = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 240;BA.debugLine="Dim current_id_edit As Int=0";
_current_id_edit = (int) (0);
 //BA.debugLineNum = 241;BA.debugLine="Dim	is_for_edit As Boolean=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 244;BA.debugLine="Dim tim_min As Int";
_tim_min = 0;
 //BA.debugLineNum = 246;BA.debugLine="Private lbl_vesion_app As Label";
mostCurrent._lbl_vesion_app = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 247;BA.debugLine="Private lbl_date_FT As Label";
mostCurrent._lbl_date_ft = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 248;BA.debugLine="Private lbl_vorod_FT As Label";
mostCurrent._lbl_vorod_ft = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 249;BA.debugLine="Private lbl_khoroj_FT As Label";
mostCurrent._lbl_khoroj_ft = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 250;BA.debugLine="Private lbl_time_show_FT As Label";
mostCurrent._lbl_time_show_ft = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 251;BA.debugLine="Private lbl_tim_khoroj_FT As Label";
mostCurrent._lbl_tim_khoroj_ft = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 252;BA.debugLine="Private lbl_tim_vorod_FT As Label";
mostCurrent._lbl_tim_vorod_ft = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 253;BA.debugLine="Private ckb_ezaf_taradod_FT As CheckBox";
mostCurrent._ckb_ezaf_taradod_ft = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 254;BA.debugLine="Private pan_all_FT As Panel";
mostCurrent._pan_all_ft = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 256;BA.debugLine="Dim code_fast_taradod As Int=1";
_code_fast_taradod = (int) (1);
 //BA.debugLineNum = 257;BA.debugLine="Private et_tozihat_FT As EditText";
mostCurrent._et_tozihat_ft = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 258;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
String _send = "";
 //BA.debugLineNum = 397;BA.debugLine="Sub http_initial_1(type1 As Int)";
 //BA.debugLineNum = 398;BA.debugLine="ht.Initialize(\"ht\",Me)";
mostCurrent._ht._initialize /*String*/ (processBA,"ht",main.getObject());
 //BA.debugLineNum = 399;BA.debugLine="Dim send As String";
_send = "";
 //BA.debugLineNum = 400;BA.debugLine="send = \"username=mahdi&password=1234&div_id=\"&pho";
_send = "username=mahdi&password=1234&div_id="+_phon.GetSettings("android_id")+"&sdk_ver="+BA.NumberToString(_phon.getSdkVersion())+"&oprator="+_phon.GetNetworkOperatorName()+"&type_app="+BA.NumberToString(_type1)+"&div_model="+_phon.getModel()+"&last_notif="+mostCurrent._last_notif+"&var=0&is_now_instal="+BA.ObjectToString(_is_now_instal)+"&version_code="+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Application.getVersionCode());
 //BA.debugLineNum = 401;BA.debugLine="ht.PostString(\"https://azarfadak.com/ezafekari2.p";
mostCurrent._ht._poststring /*String*/ ("https://azarfadak.com/ezafekari2.php",_send);
 //BA.debugLineNum = 404;BA.debugLine="End Sub";
return "";
}
public static String  _img_slider(int _index1) throws Exception{
 //BA.debugLineNum = 2683;BA.debugLine="Sub img_slider (index1 As Int)";
 //BA.debugLineNum = 2684;BA.debugLine="Select index1";
switch (_index1) {
case 0: {
 //BA.debugLineNum = 2686;BA.debugLine="img_help.Bitmap=bit_img0";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img0.getObject()));
 break; }
case 1: {
 //BA.debugLineNum = 2688;BA.debugLine="img_help.Bitmap=bit_img1";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img1.getObject()));
 break; }
case 2: {
 //BA.debugLineNum = 2691;BA.debugLine="img_help.Bitmap=bit_img2";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img2.getObject()));
 break; }
case 3: {
 //BA.debugLineNum = 2694;BA.debugLine="img_help.Bitmap=bit_img3";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img3.getObject()));
 break; }
case 4: {
 //BA.debugLineNum = 2697;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
 break; }
default: {
 //BA.debugLineNum = 2700;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("25046289","error",0);
 break; }
}
;
 //BA.debugLineNum = 2703;BA.debugLine="End Sub";
return "";
}
public static String  _inapp_purchasecompleted(boolean _success,anywheresoftware.b4a.inappbilling3.BillingManager3.Prchase _product) throws Exception{
 //BA.debugLineNum = 538;BA.debugLine="Sub inapp_PurchaseCompleted (Success As Boolean, P";
 //BA.debugLineNum = 541;BA.debugLine="If Success=True Then";
if (_success==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 543;BA.debugLine="If Product.ProductId=\"ezafekari2\" Then";
if ((_product.getProductId()).equals("ezafekari2")) { 
 //BA.debugLineNum = 545;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\",\"\")";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
 //BA.debugLineNum = 546;BA.debugLine="MsgboxAsync(\"پرداخت انجام شده است\",\"انجام شد\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("پرداخت انجام شده است"),BA.ObjectToCharSequence("انجام شد"),processBA);
 //BA.debugLineNum = 547;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی ا";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 549;BA.debugLine="inapp.ConsumeProduct(Product)";
mostCurrent._inapp.ConsumeProduct(processBA,_product);
 //BA.debugLineNum = 551;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 //BA.debugLineNum = 552;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 };
 }else {
 //BA.debugLineNum = 556;BA.debugLine="ToastMessageShow(\"خرید انجام نشد. دوباره تلاش کن";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خرید انجام نشد. دوباره تلاش کنید"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 558;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(ir.taravatgroup.ezafekari2.httpjob _job) throws Exception{
 //BA.debugLineNum = 408;BA.debugLine="Sub Jobdone (job As HttpJob)";
 //BA.debugLineNum = 409;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 410;BA.debugLine="If job.JobName=\"ht\" Then";
if ((_job._jobname /*String*/ ).equals("ht")) { 
 //BA.debugLineNum = 411;BA.debugLine="If(job.GetString <> \"\")Then";
if (((_job._getstring /*String*/ ()).equals("") == false)) { 
 //BA.debugLineNum = 413;BA.debugLine="If(job.GetString.Contains(\"accessok\"))Then";
if ((_job._getstring /*String*/ ().contains("accessok"))) { 
 //BA.debugLineNum = 416;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") Th";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
 }else {
 //BA.debugLineNum = 419;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok","");
 //BA.debugLineNum = 420;BA.debugLine="myfunc.help_man(\"نسخه طلایی از طرف ادمین فعا";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"نسخه طلایی از طرف ادمین فعال شد");
 };
 }else if((_job._getstring /*String*/ ().contains("accessno"))) { 
 //BA.debugLineNum = 425;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") Th";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
 //BA.debugLineNum = 426;BA.debugLine="File.Delete(File.DirInternal,\"payokok\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok");
 //BA.debugLineNum = 427;BA.debugLine="myfunc.help_man(\" نسخه طلایی از طرف ادمین غی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA," نسخه طلایی از طرف ادمین غیرفعال شد");
 };
 }else {
 //BA.debugLineNum = 432;BA.debugLine="msg=job.GetString";
mostCurrent._msg = _job._getstring /*String*/ ();
 //BA.debugLineNum = 433;BA.debugLine="tim_msg.Enabled=True";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 };
 };
 }else {
 };
 //BA.debugLineNum = 444;BA.debugLine="End Sub";
return "";
}
public static String  _kharid() throws Exception{
 //BA.debugLineNum = 520;BA.debugLine="Sub kharid";
 //BA.debugLineNum = 523;BA.debugLine="If(myfunc.check_internet)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 524;BA.debugLine="Try";
try { //BA.debugLineNum = 526;BA.debugLine="inapp.RequestPayment(\"ezafekari2\",\"inapp\",\"ezaf";
mostCurrent._inapp.RequestPayment(processBA,"ezafekari2","inapp","ezafekari2");
 } 
       catch (Exception e5) {
			processBA.setLastException(e5); //BA.debugLineNum = 529;BA.debugLine="MsgboxAsync(\"1- از نصب بودن برنامه بازار اطمینا";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("1- از نصب بودن برنامه بازار اطمینان یابید."+anywheresoftware.b4a.keywords.Common.CRLF+" 2- برنامه ها را ببندید و دوباره امتحان کنید."),BA.ObjectToCharSequence("خطا"),processBA);
 };
 }else {
 //BA.debugLineNum = 532;BA.debugLine="ToastMessageShow(\"خطا در اتصال \",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا در اتصال "),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 535;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_ft_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 3065;BA.debugLine="Private Sub lbl_close_FT_Click";
 //BA.debugLineNum = 3067;BA.debugLine="If(dbCode.isexist_taradod_by_date(myfunc.fa2en(pe";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate()))==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 3068;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 3069;BA.debugLine="result = Msgbox2(\"تردد و اضافه کاری امروز پاک شو";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("تردد و اضافه کاری امروز پاک شود؟"),BA.ObjectToCharSequence("توجه"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 3070;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 3072;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 3074;BA.debugLine="dbCode.sql.ExecNonQuery(\"DELETE FROM tb_taradod";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("DELETE FROM tb_taradod WHERE date_from LIKE '%"+mostCurrent._lbl_date_ft.getText()+"%'; ");
 //BA.debugLineNum = 3076;BA.debugLine="dbCode.sql.ExecNonQuery(\"DELETE FROM tb_ezafeka";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("DELETE FROM tb_ezafekari WHERE date_from LIKE '%"+mostCurrent._lbl_date_ft.getText()+"%'; ");
 //BA.debugLineNum = 3077;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 3078;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 3080;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3081;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=True";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3082;BA.debugLine="lbl_tim_vorod_FT.Text=\"00:00\"";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 3083;BA.debugLine="lbl_tim_khoroj_FT.Text=\"00:00\"";
mostCurrent._lbl_tim_khoroj_ft.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 3084;BA.debugLine="lbl_time_show_FT.Text=\"\"";
mostCurrent._lbl_time_show_ft.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 3085;BA.debugLine="et_tozihat_FT.Enabled=True";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3086;BA.debugLine="et_tozihat_FT.Text=\"\"";
mostCurrent._et_tozihat_ft.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 3087;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
 };
 }else {
 //BA.debugLineNum = 3091;BA.debugLine="myfunc.help_man(\"برای امروز هنوز ترددی ثبت نشده";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"برای امروز هنوز ترددی ثبت نشده است");
 //BA.debugLineNum = 3092;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
 };
 //BA.debugLineNum = 3095;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_help_click() throws Exception{
 //BA.debugLineNum = 2627;BA.debugLine="Private Sub lbl_close_help_Click";
 //BA.debugLineNum = 2628;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2629;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_msgnewy_click() throws Exception{
 //BA.debugLineNum = 386;BA.debugLine="Private Sub lbl_close_msgNewY_Click";
 //BA.debugLineNum = 388;BA.debugLine="pan_all_msgNewYear.Visible=False";
mostCurrent._pan_all_msgnewyear.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 389;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_notif_click() throws Exception{
 //BA.debugLineNum = 508;BA.debugLine="Private Sub lbl_close_notif_Click";
 //BA.debugLineNum = 509;BA.debugLine="pan_notifi_all.Visible=False";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 510;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date1_click() throws Exception{
 //BA.debugLineNum = 2377;BA.debugLine="Private Sub lbl_date1_Click";
 //BA.debugLineNum = 2378;BA.debugLine="lbl_tim1_Click";
_lbl_tim1_click();
 //BA.debugLineNum = 2379;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date2_click() throws Exception{
 //BA.debugLineNum = 2372;BA.debugLine="Private Sub lbl_date2_Click";
 //BA.debugLineNum = 2373;BA.debugLine="lbl_tim2_Click";
_lbl_tim2_click();
 //BA.debugLineNum = 2374;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_from_list_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _b = null;
 //BA.debugLineNum = 2706;BA.debugLine="Private Sub lbl_edit_from_list_Click";
 //BA.debugLineNum = 2707;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 2708;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 2709;BA.debugLine="Log(b.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("25111811",BA.ObjectToString(_b.getTag()),0);
 //BA.debugLineNum = 2710;BA.debugLine="current_id_edit=b.Tag";
_current_id_edit = (int)(BA.ObjectToNumber(_b.getTag()));
 //BA.debugLineNum = 2713;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
 //BA.debugLineNum = 2714;BA.debugLine="pan_add_ezafekari_Click";
_pan_add_ezafekari_click();
 //BA.debugLineNum = 2715;BA.debugLine="lbl_box_title.Text=\"ویرایش اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش اضافه کاری"));
 }else if((mostCurrent._tabhost1.getCurrentTab()==1)) { 
 //BA.debugLineNum = 2718;BA.debugLine="pan_add_morakhasi_Click";
_pan_add_morakhasi_click();
 //BA.debugLineNum = 2719;BA.debugLine="lbl_box_title.Text=\"ویرایش مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش مرخصی"));
 }else if((mostCurrent._tabhost1.getCurrentTab()==2)) { 
 //BA.debugLineNum = 2722;BA.debugLine="pan_add_taradod_Click";
_pan_add_taradod_click();
 //BA.debugLineNum = 2723;BA.debugLine="lbl_box_title.Text=\"ویرایش تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ویرایش تردد"));
 //BA.debugLineNum = 2724;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2725;BA.debugLine="lbl_ezaf_taradod.Visible=False";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 2727;BA.debugLine="is_for_edit=True";
_is_for_edit = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 2728;BA.debugLine="get_dataEdit_byId(current_id_edit)";
_get_dataedit_byid(_current_id_edit);
 //BA.debugLineNum = 2738;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 2741;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_ezaf_taradod_click() throws Exception{
 //BA.debugLineNum = 1234;BA.debugLine="Private Sub lbl_ezaf_taradod_Click";
 //BA.debugLineNum = 1235;BA.debugLine="If(index_box=2)Then";
if ((_index_box==2)) { 
 //BA.debugLineNum = 1236;BA.debugLine="rsPOP_noe.Show";
mostCurrent._rspop_noe.Show();
 };
 //BA.debugLineNum = 1238;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_click() throws Exception{
 //BA.debugLineNum = 2611;BA.debugLine="Private Sub lbl_help_Click";
 //BA.debugLineNum = 2614;BA.debugLine="bit_img0.Initialize(File.DirAssets,\"home-h0.jpg\")";
mostCurrent._bit_img0.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h0.jpg");
 //BA.debugLineNum = 2615;BA.debugLine="bit_img1.Initialize(File.DirAssets,\"home-h1.jpg\")";
mostCurrent._bit_img1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h1.jpg");
 //BA.debugLineNum = 2616;BA.debugLine="bit_img2.Initialize(File.DirAssets,\"home-h2.jpg\")";
mostCurrent._bit_img2.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h2.jpg");
 //BA.debugLineNum = 2617;BA.debugLine="bit_img3.Initialize(File.DirAssets,\"home-h3.jpg\")";
mostCurrent._bit_img3.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h3.jpg");
 //BA.debugLineNum = 2618;BA.debugLine="bit_img4.Initialize(File.DirAssets,\"home-h4.jpg\")";
mostCurrent._bit_img4.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"home-h4.jpg");
 //BA.debugLineNum = 2621;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 //BA.debugLineNum = 2622;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 //BA.debugLineNum = 2623;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2625;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_ft_click() throws Exception{
 //BA.debugLineNum = 3226;BA.debugLine="Private Sub lbl_help_FT_Click";
 //BA.debugLineNum = 3227;BA.debugLine="myfunc.help_man(\"برای ثبت ورود یا خروج انگشت خود";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"برای ثبت ورود یا خروج انگشت خود را در قسمت مشخص شده 3 ثانیه نگه دارید.");
 //BA.debugLineNum = 3228;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_piker_click() throws Exception{
 //BA.debugLineNum = 2920;BA.debugLine="Private Sub lbl_help_piker_Click";
 //BA.debugLineNum = 2922;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 //BA.debugLineNum = 2924;BA.debugLine="img_help.Bitmap=bit_img4";
mostCurrent._img_help.setBitmap((android.graphics.Bitmap)(mostCurrent._bit_img4.getObject()));
 //BA.debugLineNum = 2925;BA.debugLine="lbl_close_help.Visible=False";
mostCurrent._lbl_close_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2926;BA.debugLine="pan_help.Visible=True";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2928;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help2_click() throws Exception{
 //BA.debugLineNum = 2870;BA.debugLine="Private Sub lbl_help2_Click";
 //BA.debugLineNum = 2871;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 2872;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_khoroj_ft_click() throws Exception{
 //BA.debugLineNum = 3104;BA.debugLine="Private Sub lbl_khoroj_FT_Click";
 //BA.debugLineNum = 3105;BA.debugLine="ToastMessageShow(\"انگشت خود را 3 ثانیه نگه دارید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("انگشت خود را 3 ثانیه نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3106;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_khoroj_ft_longclick() throws Exception{
 //BA.debugLineNum = 3125;BA.debugLine="Private Sub lbl_khoroj_FT_LongClick";
 //BA.debugLineNum = 3126;BA.debugLine="If(code_fast_taradod=10 Or code_fast_taradod=20)T";
if ((_code_fast_taradod==10 || _code_fast_taradod==20)) { 
 //BA.debugLineNum = 3127;BA.debugLine="index_box=4";
_index_box = (int) (4);
 //BA.debugLineNum = 3128;BA.debugLine="lbl_tim_khoroj_FT.Text=DateTime.Time(DateTime.No";
mostCurrent._lbl_tim_khoroj_ft.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 //BA.debugLineNum = 3129;BA.debugLine="add_taradod_fast";
_add_taradod_fast();
 //BA.debugLineNum = 3130;BA.debugLine="code_fast_taradod=11";
_code_fast_taradod = (int) (11);
 }else if((_code_fast_taradod==0)) { 
 //BA.debugLineNum = 3132;BA.debugLine="ToastMessageShow(\"تردد امروز دستی ثبت شده است\",F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تردد امروز دستی ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else if((_code_fast_taradod==1)) { 
 //BA.debugLineNum = 3134;BA.debugLine="ToastMessageShow(\"ابتدا قسمت ورود را بزنید\",Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ابتدا قسمت ورود را بزنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 3136;BA.debugLine="ToastMessageShow(\"زمان خروج ثبت شده است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("زمان خروج ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 3138;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_lite_menu_click() throws Exception{
 //BA.debugLineNum = 2960;BA.debugLine="Private Sub lbl_lite_menu_Click";
 //BA.debugLineNum = 2961;BA.debugLine="pan_all_liteMenu.Visible=True";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2962;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_notefi_click() throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _html = null;
int _i = 0;
 //BA.debugLineNum = 479;BA.debugLine="Private Sub lbl_notefi_Click";
 //BA.debugLineNum = 480;BA.debugLine="lbl_title_msgPan.Text=\"پیام ها\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام ها"));
 //BA.debugLineNum = 481;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 482;BA.debugLine="pan_notif.Top=10%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 483;BA.debugLine="pan_notif.Height=70%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 484;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
 //BA.debugLineNum = 487;BA.debugLine="Dim html As StringBuilder";
_html = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 488;BA.debugLine="html.Initialize";
_html.Initialize();
 //BA.debugLineNum = 490;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1"))) { 
 //BA.debugLineNum = 492;BA.debugLine="html.Append(\"<!DOCTYPE html><html><meta charset=";
_html.Append("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'>");
 //BA.debugLineNum = 493;BA.debugLine="For i = ls1.Size-1 To 0 Step -1";
{
final int step10 = -1;
final int limit10 = (int) (0);
_i = (int) (mostCurrent._ls1.getSize()-1) ;
for (;_i >= limit10 ;_i = _i + step10 ) {
 //BA.debugLineNum = 494;BA.debugLine="html.Append(\"<div style='background-color: #99f";
_html.Append("<div style='background-color: #99ffff; font-size: 13px;'>"+"کد پیام : "+BA.ObjectToString(mostCurrent._ls1.Get(_i))+" - مورخ : "+BA.ObjectToString(mostCurrent._ls3.Get(_i))+"</div><div style='background-color: #e6ffff; font-size: 16px;'><br>"+BA.ObjectToString(mostCurrent._ls2.Get(_i))).Append("<br></div><br>");
 }
};
 //BA.debugLineNum = 496;BA.debugLine="html.Append(\"</body></html>\")";
_html.Append("</body></html>");
 //BA.debugLineNum = 499;BA.debugLine="web_msg_show.LoadHtml(html.ToString)";
mostCurrent._web_msg_show.LoadHtml(_html.ToString());
 }else {
 //BA.debugLineNum = 502;BA.debugLine="web_msg_show.LoadHtml(\"<html><body dir='rtl'>لیس";
mostCurrent._web_msg_show.LoadHtml("<html><body dir='rtl'>لیست پیام خالی ... </body></html>");
 };
 //BA.debugLineNum = 506;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
 //BA.debugLineNum = 2798;BA.debugLine="Private Sub lbl_remove_from_list_Click";
 //BA.debugLineNum = 2800;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 2801;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 2803;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
if ((mostCurrent._tabhost1.getCurrentTab()==0)) { 
 //BA.debugLineNum = 2804;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 2805;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 2806;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 2808;BA.debugLine="If (dbCode.delete_ezafekari(b.Tag))Then";
if ((mostCurrent._dbcode._delete_ezafekari /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 2809;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2811;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
 //BA.debugLineNum = 2812;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 };
 };
 }else if((mostCurrent._tabhost1.getCurrentTab()==1)) { 
 //BA.debugLineNum = 2817;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 2818;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 2819;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 2821;BA.debugLine="If (dbCode.delete_morakhasi(b.Tag))Then";
if ((mostCurrent._dbcode._delete_morakhasi /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 2822;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2823;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
 //BA.debugLineNum = 2824;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 };
 };
 }else if((mostCurrent._tabhost1.getCurrentTab()==2)) { 
 //BA.debugLineNum = 2828;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 2829;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 2830;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 2832;BA.debugLine="If (dbCode.delete_taradod(b.Tag))Then";
if ((mostCurrent._dbcode._delete_taradod /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 2833;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2835;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
_curent_tab_list = mostCurrent._tabhost1.getCurrentTab();
 //BA.debugLineNum = 2836;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 };
 };
 };
 //BA.debugLineNum = 2846;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list2_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
 //BA.debugLineNum = 2849;BA.debugLine="Private Sub lbl_remove_from_list2_Click";
 //BA.debugLineNum = 2850;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 2851;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 2854;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 2855;BA.debugLine="result = Msgbox2(\"آیا این گزارش حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این گزارش حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 2856;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 2858;BA.debugLine="If (dbCode.delete_gozaresh(b.tag))Then";
if ((mostCurrent._dbcode._delete_gozaresh /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 2859;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2861;BA.debugLine="btn_menu_gozaresh_Click";
_btn_menu_gozaresh_click();
 };
 };
 //BA.debugLineNum = 2865;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_box_click() throws Exception{
 //BA.debugLineNum = 1361;BA.debugLine="Private Sub lbl_save_box_Click";
 //BA.debugLineNum = 1363;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 1364;BA.debugLine="add_end";
_add_end();
 //BA.debugLineNum = 1368;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
String _value = "";
String _value1 = "";
String _value2 = "";
 //BA.debugLineNum = 2405;BA.debugLine="Private Sub lbl_save_picker_Click";
 //BA.debugLineNum = 2407;BA.debugLine="Dim value As String";
_value = "";
 //BA.debugLineNum = 2408;BA.debugLine="value=pik_hour1.Text";
_value = mostCurrent._pik_hour1.getText();
 //BA.debugLineNum = 2409;BA.debugLine="Select value";
switch (BA.switchObjectToInt(_value,"1","2","3","4","5","6","7","8","9")) {
case 0: {
 //BA.debugLineNum = 2411;BA.debugLine="pik_hour1.Text=\"01\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("01"));
 break; }
case 1: {
 //BA.debugLineNum = 2413;BA.debugLine="pik_hour1.Text=\"02\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("02"));
 break; }
case 2: {
 //BA.debugLineNum = 2415;BA.debugLine="pik_hour1.Text=\"03\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("03"));
 break; }
case 3: {
 //BA.debugLineNum = 2417;BA.debugLine="pik_hour1.Text=\"04\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("04"));
 break; }
case 4: {
 //BA.debugLineNum = 2419;BA.debugLine="pik_hour1.Text=\"05\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("05"));
 break; }
case 5: {
 //BA.debugLineNum = 2421;BA.debugLine="pik_hour1.Text=\"06\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("06"));
 break; }
case 6: {
 //BA.debugLineNum = 2423;BA.debugLine="pik_hour1.Text=\"07\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("07"));
 break; }
case 7: {
 //BA.debugLineNum = 2425;BA.debugLine="pik_hour1.Text=\"08\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("08"));
 break; }
case 8: {
 //BA.debugLineNum = 2427;BA.debugLine="pik_hour1.Text=\"09\"";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence("09"));
 break; }
}
;
 //BA.debugLineNum = 2430;BA.debugLine="Dim value1 As String";
_value1 = "";
 //BA.debugLineNum = 2431;BA.debugLine="value1=pik_min1.Text";
_value1 = mostCurrent._pik_min1.getText();
 //BA.debugLineNum = 2432;BA.debugLine="Select value1";
switch (BA.switchObjectToInt(_value1,"1","2","3","4","5","6","7","8","9")) {
case 0: {
 //BA.debugLineNum = 2434;BA.debugLine="pik_min1.Text=\"01\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("01"));
 break; }
case 1: {
 //BA.debugLineNum = 2436;BA.debugLine="pik_min1.Text=\"02\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("02"));
 break; }
case 2: {
 //BA.debugLineNum = 2438;BA.debugLine="pik_min1.Text=\"03\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("03"));
 break; }
case 3: {
 //BA.debugLineNum = 2440;BA.debugLine="pik_min1.Text=\"04\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("04"));
 break; }
case 4: {
 //BA.debugLineNum = 2442;BA.debugLine="pik_min1.Text=\"05\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("05"));
 break; }
case 5: {
 //BA.debugLineNum = 2444;BA.debugLine="pik_min1.Text=\"06\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("06"));
 break; }
case 6: {
 //BA.debugLineNum = 2446;BA.debugLine="pik_min1.Text=\"07\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("07"));
 break; }
case 7: {
 //BA.debugLineNum = 2448;BA.debugLine="pik_min1.Text=\"08\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("08"));
 break; }
case 8: {
 //BA.debugLineNum = 2450;BA.debugLine="pik_min1.Text=\"09\"";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence("09"));
 break; }
}
;
 //BA.debugLineNum = 2453;BA.debugLine="Dim value2 As String";
_value2 = "";
 //BA.debugLineNum = 2454;BA.debugLine="value2=pik_day1.Text";
_value2 = mostCurrent._pik_day1.getText();
 //BA.debugLineNum = 2455;BA.debugLine="Select value2";
switch (BA.switchObjectToInt(_value2,"1","2","3","4","5","6","7","8","9")) {
case 0: {
 //BA.debugLineNum = 2457;BA.debugLine="pik_day1.Text=\"01\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("01"));
 break; }
case 1: {
 //BA.debugLineNum = 2459;BA.debugLine="pik_day1.Text=\"02\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("02"));
 break; }
case 2: {
 //BA.debugLineNum = 2461;BA.debugLine="pik_day1.Text=\"03\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("03"));
 break; }
case 3: {
 //BA.debugLineNum = 2463;BA.debugLine="pik_day1.Text=\"04\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("04"));
 break; }
case 4: {
 //BA.debugLineNum = 2465;BA.debugLine="pik_day1.Text=\"05\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("05"));
 break; }
case 5: {
 //BA.debugLineNum = 2467;BA.debugLine="pik_day1.Text=\"06\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("06"));
 break; }
case 6: {
 //BA.debugLineNum = 2469;BA.debugLine="pik_day1.Text=\"07\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("07"));
 break; }
case 7: {
 //BA.debugLineNum = 2471;BA.debugLine="pik_day1.Text=\"08\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("08"));
 break; }
case 8: {
 //BA.debugLineNum = 2473;BA.debugLine="pik_day1.Text=\"09\"";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence("09"));
 break; }
}
;
 //BA.debugLineNum = 2475;BA.debugLine="Select pik_moon1.Tag";
switch (BA.switchObjectToInt(mostCurrent._pik_moon1.getTag(),(Object)(1),(Object)(2),(Object)(3),(Object)(4),(Object)(5),(Object)(6),(Object)(7),(Object)(8),(Object)(9),(Object)(10),(Object)(11),(Object)(12))) {
case 0: {
 //BA.debugLineNum = 2477;BA.debugLine="pik_moon1.Tag=\"01\"";
mostCurrent._pik_moon1.setTag((Object)("01"));
 break; }
case 1: {
 //BA.debugLineNum = 2479;BA.debugLine="pik_moon1.Tag=\"02\"";
mostCurrent._pik_moon1.setTag((Object)("02"));
 break; }
case 2: {
 //BA.debugLineNum = 2481;BA.debugLine="pik_moon1.Tag=\"03\"";
mostCurrent._pik_moon1.setTag((Object)("03"));
 break; }
case 3: {
 //BA.debugLineNum = 2483;BA.debugLine="pik_moon1.Tag=\"04\"";
mostCurrent._pik_moon1.setTag((Object)("04"));
 break; }
case 4: {
 //BA.debugLineNum = 2485;BA.debugLine="pik_moon1.Tag=\"05\"";
mostCurrent._pik_moon1.setTag((Object)("05"));
 break; }
case 5: {
 //BA.debugLineNum = 2487;BA.debugLine="pik_moon1.Tag=\"06\"";
mostCurrent._pik_moon1.setTag((Object)("06"));
 break; }
case 6: {
 //BA.debugLineNum = 2489;BA.debugLine="pik_moon1.Tag=\"07\"";
mostCurrent._pik_moon1.setTag((Object)("07"));
 break; }
case 7: {
 //BA.debugLineNum = 2491;BA.debugLine="pik_moon1.Tag=\"08\"";
mostCurrent._pik_moon1.setTag((Object)("08"));
 break; }
case 8: {
 //BA.debugLineNum = 2493;BA.debugLine="pik_moon1.Tag=\"09\"";
mostCurrent._pik_moon1.setTag((Object)("09"));
 break; }
case 9: {
 //BA.debugLineNum = 2495;BA.debugLine="pik_moon1.Tag=\"10\"";
mostCurrent._pik_moon1.setTag((Object)("10"));
 break; }
case 10: {
 //BA.debugLineNum = 2497;BA.debugLine="pik_moon1.Tag=\"11\"";
mostCurrent._pik_moon1.setTag((Object)("11"));
 break; }
case 11: {
 //BA.debugLineNum = 2499;BA.debugLine="pik_moon1.Tag=\"12\"";
mostCurrent._pik_moon1.setTag((Object)("12"));
 break; }
}
;
 //BA.debugLineNum = 2504;BA.debugLine="If(index_piker=1)Then  'date1";
if ((_index_piker==1)) { 
 //BA.debugLineNum = 2506;BA.debugLine="lbl_tim1.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
 //BA.debugLineNum = 2507;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
 }else if((_index_piker==2)) { 
 //BA.debugLineNum = 2511;BA.debugLine="lbl_tim2.Text=pik_hour1.Text&\":\"&pik_min1.Text";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(mostCurrent._pik_hour1.getText()+":"+mostCurrent._pik_min1.getText()));
 //BA.debugLineNum = 2512;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+BA.ObjectToString(mostCurrent._pik_moon1.getTag())+"/"+mostCurrent._pik_day1.getText()));
 };
 //BA.debugLineNum = 2517;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2518;BA.debugLine="time_show";
_time_show();
 //BA.debugLineNum = 2519;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim1_click() throws Exception{
 //BA.debugLineNum = 2381;BA.debugLine="Private Sub lbl_tim1_Click";
 //BA.debugLineNum = 2382;BA.debugLine="index_piker=1";
_index_piker = (int) (1);
 //BA.debugLineNum = 2384;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim1.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (0))));
 //BA.debugLineNum = 2385;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim1.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim1.getText(),":").Get((int) (1))));
 //BA.debugLineNum = 2387;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date1.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (0))));
 //BA.debugLineNum = 2388;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (1)));
 //BA.debugLineNum = 2389;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 2390;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date1.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date1.getText(),"/").Get((int) (2))));
 //BA.debugLineNum = 2394;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2396;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2397;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 2398;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 //BA.debugLineNum = 2399;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 //BA.debugLineNum = 2400;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
 //BA.debugLineNum = 2403;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_tim2_click() throws Exception{
 //BA.debugLineNum = 2350;BA.debugLine="Private Sub lbl_tim2_Click";
 //BA.debugLineNum = 2351;BA.debugLine="index_piker=2";
_index_piker = (int) (2);
 //BA.debugLineNum = 2352;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim2.Text,\":\").Ge";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (0))));
 //BA.debugLineNum = 2353;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim2.Text,\":\").Get";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_tim2.getText(),":").Get((int) (1))));
 //BA.debugLineNum = 2355;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date2.Text,\"/\").G";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (0))));
 //BA.debugLineNum = 2356;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_moon1.setTag(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (1)));
 //BA.debugLineNum = 2357;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 2358;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date2.Text,\"/\").Ge";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._strfun._vvvvvv5(mostCurrent._lbl_date2.getText(),"/").Get((int) (2))));
 //BA.debugLineNum = 2361;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2364;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim")==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 2365;BA.debugLine="lbl_help_Click";
_lbl_help_click();
 //BA.debugLineNum = 2366;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 //BA.debugLineNum = 2367;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 //BA.debugLineNum = 2368;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"help_piktim","");
 };
 //BA.debugLineNum = 2370;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_click() throws Exception{
 //BA.debugLineNum = 2598;BA.debugLine="Private Sub lbl_vip_Click";
 //BA.debugLineNum = 2600;BA.debugLine="pan_all_noskhe.Visible=True";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2601;BA.debugLine="scroll_v_noskhe.Panel.LoadLayout(\"noske_item\")";
mostCurrent._scroll_v_noskhe.getPanel().LoadLayout("noske_item",mostCurrent.activityBA);
 //BA.debugLineNum = 2603;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 2604;BA.debugLine="lbl_show_vip.Text=\"نسخه کامل ( طلایی ) فعال می ب";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه کامل ( طلایی ) فعال می باشد."));
 }else {
 //BA.debugLineNum = 2606;BA.debugLine="lbl_show_vip.Text=\"نسخه معمولی ( هدیه ) فعال می";
mostCurrent._lbl_show_vip.setText(BA.ObjectToCharSequence("نسخه معمولی ( هدیه ) فعال می باشد."));
 };
 //BA.debugLineNum = 2609;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_later_click() throws Exception{
 //BA.debugLineNum = 2890;BA.debugLine="Private Sub lbl_vip_later_Click";
 //BA.debugLineNum = 2891;BA.debugLine="pan_all_noskhe_Click";
_pan_all_noskhe_click();
 //BA.debugLineNum = 2892;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip_now_click() throws Exception{
String _title = "";
String _matn = "";
int _result = 0;
 //BA.debugLineNum = 2894;BA.debugLine="Private Sub lbl_vip_now_Click";
 //BA.debugLineNum = 2895;BA.debugLine="If(myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 2897;BA.debugLine="Dim title , matn As String";
_title = "";
_matn = "";
 //BA.debugLineNum = 2898;BA.debugLine="title=\" تبریک \"";
_title = " تبریک ";
 //BA.debugLineNum = 2899;BA.debugLine="matn=\" شما صاحب نسخه طلایی و بدون محدودیت برنامه";
_matn = " شما صاحب نسخه طلایی و بدون محدودیت برنامه اضافه کاری من می باشید. ";
 //BA.debugLineNum = 2901;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 2902;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Lo";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"باشه","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"buy.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 2903;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
 }else {
 //BA.debugLineNum = 2908;BA.debugLine="kharid";
_kharid();
 };
 //BA.debugLineNum = 2910;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vip2_click() throws Exception{
 //BA.debugLineNum = 2874;BA.debugLine="Private Sub lbl_vip2_Click";
 //BA.debugLineNum = 2875;BA.debugLine="lbl_vip_Click";
_lbl_vip_click();
 //BA.debugLineNum = 2876;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vorod_ft_click() throws Exception{
 //BA.debugLineNum = 3101;BA.debugLine="Private Sub lbl_vorod_FT_Click";
 //BA.debugLineNum = 3102;BA.debugLine="ToastMessageShow(\"انگشت خود را 3 ثانیه نگه دارید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("انگشت خود را 3 ثانیه نگه دارید"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3103;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_vorod_ft_longclick() throws Exception{
 //BA.debugLineNum = 3109;BA.debugLine="Private Sub lbl_vorod_FT_LongClick";
 //BA.debugLineNum = 3111;BA.debugLine="If(code_fast_taradod=1)Then";
if ((_code_fast_taradod==1)) { 
 //BA.debugLineNum = 3112;BA.debugLine="index_box=4";
_index_box = (int) (4);
 //BA.debugLineNum = 3113;BA.debugLine="lbl_tim_vorod_FT.Text=DateTime.Time(DateTime.Now";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 //BA.debugLineNum = 3114;BA.debugLine="code_fast_taradod=10";
_code_fast_taradod = (int) (10);
 //BA.debugLineNum = 3115;BA.debugLine="add_end";
_add_end();
 //BA.debugLineNum = 3116;BA.debugLine="pan_add_taradod_fast_Click";
_pan_add_taradod_fast_click();
 }else if((_code_fast_taradod==0)) { 
 //BA.debugLineNum = 3118;BA.debugLine="ToastMessageShow(\" تردد امروز دستی ثبت شده است\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" تردد امروز دستی ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 3120;BA.debugLine="ToastMessageShow(\"زمان ورود ثبت شده است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("زمان ورود ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 3123;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_ezafekari_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_temp_time1 = null;
 //BA.debugLineNum = 1260;BA.debugLine="Private Sub pan_add_ezafekari_Click";
 //BA.debugLineNum = 1261;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1262;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1263;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1264;BA.debugLine="lbl_box_title.Text=\"ثبت اضافه کاری\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت اضافه کاری"));
 //BA.debugLineNum = 1265;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
 //BA.debugLineNum = 1266;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
 //BA.debugLineNum = 1267;BA.debugLine="index_box=1";
_index_box = (int) (1);
 //BA.debugLineNum = 1268;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1269;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1270;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1271;BA.debugLine="lbl_ezaf_taradod.Text=\"فوق العاده (جمعه کاری)\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("فوق العاده (جمعه کاری)"));
 //BA.debugLineNum = 1272;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 1273;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1274;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1275;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1281;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
 //BA.debugLineNum = 1282;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
 //BA.debugLineNum = 1283;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 1284;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
 //BA.debugLineNum = 1287;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1288;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1293;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_time1.txt\")";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time1.txt"))) { 
 //BA.debugLineNum = 1294;BA.debugLine="Dim ls_temp_time1 As List";
_ls_temp_time1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1295;BA.debugLine="ls_temp_time1.Initialize";
_ls_temp_time1.Initialize();
 //BA.debugLineNum = 1296;BA.debugLine="ls_temp_time1=File.ReadList(File.DirInternal,\"te";
_ls_temp_time1 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time1.txt");
 //BA.debugLineNum = 1298;BA.debugLine="lbl_tim1.Text=ls_temp_time1.Get(0)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_temp_time1.Get((int) (0))));
 //BA.debugLineNum = 1299;BA.debugLine="lbl_tim2.Text=ls_temp_time1.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_temp_time1.Get((int) (1))));
 //BA.debugLineNum = 1300;BA.debugLine="time_show";
_time_show();
 }else {
 //BA.debugLineNum = 1302;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 1303;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 1307;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_morakhasi_click() throws Exception{
 //BA.debugLineNum = 1189;BA.debugLine="Private Sub pan_add_morakhasi_Click";
 //BA.debugLineNum = 1190;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1191;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1192;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1193;BA.debugLine="lbl_box_title.Text=\"ثبت مرخصی\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت مرخصی"));
 //BA.debugLineNum = 1194;BA.debugLine="lbl_time_as.Text=\"از :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("از :"));
 //BA.debugLineNum = 1195;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("تا :"));
 //BA.debugLineNum = 1196;BA.debugLine="index_box=2";
_index_box = (int) (2);
 //BA.debugLineNum = 1197;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1198;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1199;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 //BA.debugLineNum = 1200;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1201;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
 //BA.debugLineNum = 1202;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Red";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 1203;BA.debugLine="ckb_ezaf_taradod.Visible=False";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1204;BA.debugLine="ckb_ezaf_taradod.Checked=False";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1208;BA.debugLine="rsPOP_noe.Initialize(\"rsPOP_noe\",lbl_ezaf_taradod";
mostCurrent._rspop_noe.Initialize(mostCurrent.activityBA,"rsPOP_noe",(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbl_ezaf_taradod.getObject())));
 //BA.debugLineNum = 1210;BA.debugLine="rsPOP_noe.AddMenuItem(0,0,\"استحقاقی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (0),(int) (0),"استحقاقی");
 //BA.debugLineNum = 1211;BA.debugLine="rsPOP_noe.AddMenuItem(1,1,\"استعلاجی\")";
mostCurrent._rspop_noe.AddMenuItem((int) (1),(int) (1),"استعلاجی");
 //BA.debugLineNum = 1212;BA.debugLine="rsPOP_noe.AddMenuItem(2,2,\"سایر (با حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (2),(int) (2),"سایر (با حقوق)");
 //BA.debugLineNum = 1213;BA.debugLine="rsPOP_noe.AddMenuItem(3,3,\"سایر (بدون حقوق)\")";
mostCurrent._rspop_noe.AddMenuItem((int) (3),(int) (3),"سایر (بدون حقوق)");
 //BA.debugLineNum = 1218;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
 //BA.debugLineNum = 1219;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
 //BA.debugLineNum = 1220;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 1221;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
 //BA.debugLineNum = 1224;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1225;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1227;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 1228;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 1232;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_taradod_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_temp_time2 = null;
 //BA.debugLineNum = 1309;BA.debugLine="Private Sub pan_add_taradod_Click";
 //BA.debugLineNum = 1310;BA.debugLine="is_for_edit=False";
_is_for_edit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1311;BA.debugLine="pan_ezaf_taradod.Visible=True";
mostCurrent._pan_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1312;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1313;BA.debugLine="lbl_box_title.Text=\"ثبت تردد\"";
mostCurrent._lbl_box_title.setText(BA.ObjectToCharSequence("ثبت تردد"));
 //BA.debugLineNum = 1314;BA.debugLine="lbl_time_as.Text=\"ورود :\"";
mostCurrent._lbl_time_as.setText(BA.ObjectToCharSequence("ورود :"));
 //BA.debugLineNum = 1315;BA.debugLine="lbl_time_ta.Text=\"خروج :\"";
mostCurrent._lbl_time_ta.setText(BA.ObjectToCharSequence("خروج :"));
 //BA.debugLineNum = 1316;BA.debugLine="index_box=3";
_index_box = (int) (3);
 //BA.debugLineNum = 1317;BA.debugLine="lbl_time_show.Text=\"\"";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1318;BA.debugLine="et_tozihat.Text=\"\"";
mostCurrent._et_tozihat.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1319;BA.debugLine="lbl_ezaf_taradod.Visible=True";
mostCurrent._lbl_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1320;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1321;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
mostCurrent._lbl_ezaf_taradod.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 1323;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1324;BA.debugLine="ckb_ezaf_taradod.Visible=True";
mostCurrent._ckb_ezaf_taradod.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1325;BA.debugLine="ckb_ezaf_taradod.Checked=True";
mostCurrent._ckb_ezaf_taradod.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1327;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianYear()))));
 //BA.debugLineNum = 1328;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianMonth()))));
 //BA.debugLineNum = 1329;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 1330;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_persiandate.getPersianDay()))));
 //BA.debugLineNum = 1333;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1334;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 1337;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_time2.txt\")";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time2.txt"))) { 
 //BA.debugLineNum = 1338;BA.debugLine="Dim ls_temp_time2 As List";
_ls_temp_time2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1339;BA.debugLine="ls_temp_time2.Initialize";
_ls_temp_time2.Initialize();
 //BA.debugLineNum = 1340;BA.debugLine="ls_temp_time2=File.ReadList(File.DirInternal,\"te";
_ls_temp_time2 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp_time2.txt");
 //BA.debugLineNum = 1342;BA.debugLine="lbl_tim1.Text=ls_temp_time2.Get(0)";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence(_ls_temp_time2.Get((int) (0))));
 //BA.debugLineNum = 1343;BA.debugLine="lbl_tim2.Text=ls_temp_time2.Get(1)";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence(_ls_temp_time2.Get((int) (1))));
 //BA.debugLineNum = 1344;BA.debugLine="time_show";
_time_show();
 }else {
 //BA.debugLineNum = 1346;BA.debugLine="lbl_tim1.Text=\"00:00\"";
mostCurrent._lbl_tim1.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 1347;BA.debugLine="lbl_tim2.Text=\"00:00\"";
mostCurrent._lbl_tim2.setText(BA.ObjectToCharSequence("00:00"));
 };
 //BA.debugLineNum = 1351;BA.debugLine="End Sub";
return "";
}
public static String  _pan_add_taradod_fast_click() throws Exception{
 //BA.debugLineNum = 2979;BA.debugLine="Private Sub pan_add_taradod_fast_Click";
 //BA.debugLineNum = 2980;BA.debugLine="pan_all_FT.Visible=True";
mostCurrent._pan_all_ft.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 2981;BA.debugLine="lbl_date_FT.Text=myfunc.fa2en(persianDate.Persian";
mostCurrent._lbl_date_ft.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_persiandate.getPersianShortDate())));
 //BA.debugLineNum = 2982;BA.debugLine="DateTime.TimeFormat = \"HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm");
 //BA.debugLineNum = 2984;BA.debugLine="If(dbCode.isexist_taradod_by_date(lbl_date_FT.Tex";
if ((mostCurrent._dbcode._isexist_taradod_by_date /*boolean*/ (mostCurrent.activityBA,mostCurrent._lbl_date_ft.getText())==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2985;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+mostCurrent._lbl_date_ft.getText()+"';")));
 //BA.debugLineNum = 2986;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 2988;BA.debugLine="lbl_tim_vorod_FT.Text=dbCode.res.GetString(\"time";
mostCurrent._lbl_tim_vorod_ft.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from")));
 //BA.debugLineNum = 2989;BA.debugLine="lbl_tim_khoroj_FT.Text=dbCode.res.GetString(\"tim";
mostCurrent._lbl_tim_khoroj_ft.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to")));
 //BA.debugLineNum = 2991;BA.debugLine="et_tozihat_FT.Text=dbCode.res.GetString(\"tozihat";
mostCurrent._et_tozihat_ft.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 2993;BA.debugLine="current_id_edit=dbCode.res.GetInt(\"id\")";
_current_id_edit = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("id");
 //BA.debugLineNum = 2994;BA.debugLine="Log(dbCode.res.GetInt(\"state\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("26553615",BA.NumberToString(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")),0);
 //BA.debugLineNum = 2996;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 2997;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 3000;BA.debugLine="If(dbCode.res.GetInt(\"state\")=10)Then  ''vorod n";
if ((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==10)) { 
 //BA.debugLineNum = 3001;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 3002;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 3003;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3004;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3006;BA.debugLine="code_fast_taradod=10";
_code_fast_taradod = (int) (10);
 }else if((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==20)) { 
 //BA.debugLineNum = 3008;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 3009;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 3010;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3011;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3013;BA.debugLine="code_fast_taradod=20";
_code_fast_taradod = (int) (20);
 }else if((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==11)) { 
 //BA.debugLineNum = 3015;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 3016;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 3017;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3018;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3020;BA.debugLine="et_tozihat_FT.Enabled=False";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3022;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
 //BA.debugLineNum = 3023;BA.debugLine="code_fast_taradod=11";
_code_fast_taradod = (int) (11);
 //BA.debugLineNum = 3024;BA.debugLine="ToastMessageShow(\"تردد امروز ثبت شده است\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تردد امروز ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==21)) { 
 //BA.debugLineNum = 3028;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 3029;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 3030;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3031;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3033;BA.debugLine="et_tozihat_FT.Enabled=False";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3035;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
 //BA.debugLineNum = 3037;BA.debugLine="code_fast_taradod=21";
_code_fast_taradod = (int) (21);
 //BA.debugLineNum = 3038;BA.debugLine="ToastMessageShow(\"تردد امروز ثبت شده است\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تردد امروز ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetInt("state")==0)) { 
 //BA.debugLineNum = 3042;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Red";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 3043;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Red";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 3044;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3045;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3047;BA.debugLine="et_tozihat_FT.Enabled=False";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3048;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
_time_show2(mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_date_ft.getText(),mostCurrent._lbl_tim_vorod_ft.getText(),mostCurrent._lbl_tim_khoroj_ft.getText());
 //BA.debugLineNum = 3050;BA.debugLine="ToastMessageShow(\"برای امروز تردد دستی ثبت شده";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برای امروز تردد دستی ثبت شده است"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3052;BA.debugLine="code_fast_taradod=0";
_code_fast_taradod = (int) (0);
 };
 }else {
 //BA.debugLineNum = 3055;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
mostCurrent._lbl_vorod_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 3056;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
mostCurrent._lbl_khoroj_ft.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 3058;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
mostCurrent._ckb_ezaf_taradod_ft.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3059;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=True";
mostCurrent._ckb_ezaf_taradod_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 3060;BA.debugLine="code_fast_taradod=1";
_code_fast_taradod = (int) (1);
 //BA.debugLineNum = 3061;BA.debugLine="et_tozihat_FT.Enabled=True";
mostCurrent._et_tozihat_ft.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 3063;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_click() throws Exception{
 //BA.debugLineNum = 1353;BA.debugLine="Private Sub pan_all_Click";
 //BA.debugLineNum = 1354;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1355;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_ft_click() throws Exception{
 //BA.debugLineNum = 3097;BA.debugLine="Private Sub pan_all_FT_Click";
 //BA.debugLineNum = 3098;BA.debugLine="pan_all_FT.Visible=False";
mostCurrent._pan_all_ft.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 3099;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_litemenu_click() throws Exception{
 //BA.debugLineNum = 2964;BA.debugLine="Private Sub pan_all_liteMenu_Click";
 //BA.debugLineNum = 2965;BA.debugLine="pan_all_liteMenu.Visible=False";
mostCurrent._pan_all_litemenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2966;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_msgnewyear_click() throws Exception{
 //BA.debugLineNum = 391;BA.debugLine="Private Sub pan_all_msgNewYear_Click";
 //BA.debugLineNum = 393;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_noskhe_click() throws Exception{
 //BA.debugLineNum = 2912;BA.debugLine="Private Sub pan_all_noskhe_Click";
 //BA.debugLineNum = 2913;BA.debugLine="pan_all_noskhe.Visible=False";
mostCurrent._pan_all_noskhe.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2914;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all2_click() throws Exception{
 //BA.debugLineNum = 2521;BA.debugLine="Private Sub pan_all2_Click";
 //BA.debugLineNum = 2524;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2525;BA.debugLine="End Sub";
return "";
}
public static String  _pan_bime_click() throws Exception{
 //BA.debugLineNum = 3230;BA.debugLine="Private Sub pan_bime_Click";
 //BA.debugLineNum = 3231;BA.debugLine="StartActivity(bime_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._bime_activity.getObject()));
 //BA.debugLineNum = 3233;BA.debugLine="End Sub";
return "";
}
public static String  _pan_calc_click() throws Exception{
 //BA.debugLineNum = 2590;BA.debugLine="Private Sub pan_calc_Click";
 //BA.debugLineNum = 2591;BA.debugLine="StartActivity(calc_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._calc_activity.getObject()));
 //BA.debugLineNum = 2594;BA.debugLine="End Sub";
return "";
}
public static String  _pan_comment_click() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _market = null;
String _url = "";
 //BA.debugLineNum = 2532;BA.debugLine="Private Sub pan_comment_Click";
 //BA.debugLineNum = 2534;BA.debugLine="Try";
try { //BA.debugLineNum = 2535;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2537;BA.debugLine="Try";
try { //BA.debugLineNum = 2538;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 2539;BA.debugLine="Dim url As String";
_url = "";
 //BA.debugLineNum = 2541;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafek";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
 //BA.debugLineNum = 2542;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
 //BA.debugLineNum = 2543;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e10) {
			processBA.setLastException(e10); //BA.debugLineNum = 2546;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
 //BA.debugLineNum = 2549;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e16) {
			processBA.setLastException(e16); //BA.debugLineNum = 2553;BA.debugLine="If (myfunc.check_internet=True)Then";
if ((mostCurrent._myfunc._check_internet /*boolean*/ (mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 2555;BA.debugLine="Try";
try { //BA.debugLineNum = 2556;BA.debugLine="Dim market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 2557;BA.debugLine="Dim url As String";
_url = "";
 //BA.debugLineNum = 2559;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafe";
_url = "bazaar://details?id=ir.taravatgroup.ezafekari2";
 //BA.debugLineNum = 2560;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
_market.Initialize(_market.ACTION_EDIT,_url);
 //BA.debugLineNum = 2561;BA.debugLine="market.SetPackage(\"ir.taravatgroup.ezafekari2\"";
_market.SetPackage("ir.taravatgroup.ezafekari2");
 //BA.debugLineNum = 2562;BA.debugLine="StartActivity(market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
 } 
       catch (Exception e25) {
			processBA.setLastException(e25); //BA.debugLineNum = 2565;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("برنامه بازار را نصب کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
 //BA.debugLineNum = 2568;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید"),anywheresoftware.b4a.keywords.Common.True);
 };
 };
 //BA.debugLineNum = 2575;BA.debugLine="End Sub";
return "";
}
public static String  _pan_darsad_click() throws Exception{
 //BA.debugLineNum = 2527;BA.debugLine="Private Sub pan_darsad_Click";
 //BA.debugLineNum = 2528;BA.debugLine="StartActivity(darsad_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._darsad_activity.getObject()));
 //BA.debugLineNum = 2530;BA.debugLine="End Sub";
return "";
}
public static String  _pan_eidi_click() throws Exception{
 //BA.debugLineNum = 2335;BA.debugLine="Private Sub pan_eidi_Click";
 //BA.debugLineNum = 2336;BA.debugLine="StartActivity(eidi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._eidi_activity.getObject()));
 //BA.debugLineNum = 2338;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ezafekari_mah_click() throws Exception{
 //BA.debugLineNum = 2878;BA.debugLine="Private Sub pan_ezafekari_mah_Click";
 //BA.debugLineNum = 2879;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 //BA.debugLineNum = 2880;BA.debugLine="TabHost1.CurrentTab=0";
mostCurrent._tabhost1.setCurrentTab((int) (0));
 //BA.debugLineNum = 2882;BA.debugLine="End Sub";
return "";
}
public static String  _pan_fast_run_click() throws Exception{
 //BA.debugLineNum = 1149;BA.debugLine="Private Sub pan_fast_run_Click";
 //BA.debugLineNum = 1154;BA.debugLine="StartActivity(fast_run_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._fast_run_activity.getObject()));
 //BA.debugLineNum = 1158;BA.debugLine="End Sub";
return "";
}
public static String  _pan_ganon_click() throws Exception{
 //BA.debugLineNum = 2932;BA.debugLine="Private Sub pan_ganon_Click";
 //BA.debugLineNum = 2933;BA.debugLine="StartActivity(ganon_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ganon_activity.getObject()));
 //BA.debugLineNum = 2935;BA.debugLine="End Sub";
return "";
}
public static String  _pan_help_touch(int _action,float _x,float _y) throws Exception{
 //BA.debugLineNum = 2631;BA.debugLine="Private Sub pan_help_Touch (Action As Int, X As Fl";
 //BA.debugLineNum = 2633;BA.debugLine="If (Action=0)Then";
if ((_action==0)) { 
 //BA.debugLineNum = 2634;BA.debugLine="index_x_start_swap=x";
_index_x_start_swap = (int) (_x);
 //BA.debugLineNum = 2635;BA.debugLine="If (index_curent_img=4)Then";
if ((_index_curent_img==4)) { 
 //BA.debugLineNum = 2636;BA.debugLine="pan_help.Visible=False";
mostCurrent._pan_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 //BA.debugLineNum = 2639;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 2640;BA.debugLine="If(X<(index_x_start_swap-150))Then";
if ((_x<(_index_x_start_swap-150))) { 
 //BA.debugLineNum = 2643;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
 //BA.debugLineNum = 2644;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
 //BA.debugLineNum = 2645;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 }else if((_x>(_index_x_start_swap+150))) { 
 //BA.debugLineNum = 2652;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
 //BA.debugLineNum = 2653;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
 //BA.debugLineNum = 2654;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else if((_index_x_start_swap<(mostCurrent._pan_help.getWidth()/(double)2))) { 
 //BA.debugLineNum = 2660;BA.debugLine="index_curent_img=index_curent_img-1";
_index_curent_img = (int) (_index_curent_img-1);
 //BA.debugLineNum = 2661;BA.debugLine="If(index_curent_img<0)Then";
if ((_index_curent_img<0)) { 
 //BA.debugLineNum = 2662;BA.debugLine="index_curent_img=0";
_index_curent_img = (int) (0);
 };
 }else if((_index_x_start_swap>(mostCurrent._pan_help.getWidth()/(double)2))) { 
 //BA.debugLineNum = 2667;BA.debugLine="index_curent_img=index_curent_img+1";
_index_curent_img = (int) (_index_curent_img+1);
 //BA.debugLineNum = 2668;BA.debugLine="If(index_curent_img>4)Then";
if ((_index_curent_img>4)) { 
 //BA.debugLineNum = 2669;BA.debugLine="index_curent_img=4";
_index_curent_img = (int) (4);
 };
 };
 //BA.debugLineNum = 2674;BA.debugLine="img_slider(index_curent_img)";
_img_slider(_index_curent_img);
 };
 //BA.debugLineNum = 2677;BA.debugLine="End Sub";
return "";
}
public static String  _pan_info_click() throws Exception{
 //BA.debugLineNum = 2345;BA.debugLine="Private Sub pan_info_Click";
 //BA.debugLineNum = 2346;BA.debugLine="StartActivity(info_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._info_activity.getObject()));
 //BA.debugLineNum = 2348;BA.debugLine="End Sub";
return "";
}
public static String  _pan_item_gozaresh_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _ba = null;
 //BA.debugLineNum = 2579;BA.debugLine="Private Sub pan_item_gozaresh_Click";
 //BA.debugLineNum = 2580;BA.debugLine="Dim Ba As Panel = Sender";
_ba = new anywheresoftware.b4a.objects.PanelWrapper();
_ba = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 2582;BA.debugLine="current_gozaresh_id=Ba.Tag";
_current_gozaresh_id = (int)(BA.ObjectToNumber(_ba.getTag()));
 //BA.debugLineNum = 2583;BA.debugLine="StartActivity(show_gozaresh_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._show_gozaresh_activity.getObject()));
 //BA.debugLineNum = 2585;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lelp_click() throws Exception{
 //BA.debugLineNum = 2679;BA.debugLine="Private Sub pan_lelp_Click";
 //BA.debugLineNum = 2681;BA.debugLine="End Sub";
return "";
}
public static String  _pan_morakhasi_mah_click() throws Exception{
 //BA.debugLineNum = 2884;BA.debugLine="Private Sub pan_morakhasi_mah_Click";
 //BA.debugLineNum = 2885;BA.debugLine="btn_menu_list_Click";
_btn_menu_list_click();
 //BA.debugLineNum = 2886;BA.debugLine="TabHost1.CurrentTab=1";
mostCurrent._tabhost1.setCurrentTab((int) (1));
 //BA.debugLineNum = 2888;BA.debugLine="End Sub";
return "";
}
public static String  _pan_notifi_all_click() throws Exception{
 //BA.debugLineNum = 513;BA.debugLine="Private Sub pan_notifi_all_Click";
 //BA.debugLineNum = 515;BA.debugLine="End Sub";
return "";
}
public static String  _pan_payankar_click() throws Exception{
 //BA.debugLineNum = 2340;BA.debugLine="Private Sub pan_payankar_Click";
 //BA.debugLineNum = 2341;BA.debugLine="StartActivity(payankar_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._payankar_activity.getObject()));
 //BA.debugLineNum = 2343;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_hogog_click() throws Exception{
 //BA.debugLineNum = 1177;BA.debugLine="Private Sub pan_run_hogog_Click";
 //BA.debugLineNum = 1178;BA.debugLine="If (myfunc.check_karid)Then";
if ((mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA))) { 
 //BA.debugLineNum = 1179;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
 }else {
 //BA.debugLineNum = 1181;BA.debugLine="StartActivity(hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._hogog_activity.getObject()));
 //BA.debugLineNum = 1182;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 1187;BA.debugLine="End Sub";
return "";
}
public static String  _pan_run_morakhasi_click() throws Exception{
 //BA.debugLineNum = 1166;BA.debugLine="Private Sub pan_run_morakhasi_Click";
 //BA.debugLineNum = 1168;BA.debugLine="StartActivity(morakhasi_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._morakhasi_activity.getObject()));
 //BA.debugLineNum = 1175;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_click() throws Exception{
 //BA.debugLineNum = 2937;BA.debugLine="Private Sub pan_setting_Click";
 //BA.debugLineNum = 2938;BA.debugLine="StartActivity(setting_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_activity.getObject()));
 //BA.debugLineNum = 2939;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 2940;BA.debugLine="End Sub";
return "";
}
public static String  _pan_setting_hogog_click() throws Exception{
 //BA.debugLineNum = 1160;BA.debugLine="Private Sub pan_setting_hogog_Click";
 //BA.debugLineNum = 1161;BA.debugLine="StartActivity(setting_hogog_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._setting_hogog_activity.getObject()));
 //BA.debugLineNum = 1162;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 1164;BA.debugLine="End Sub";
return "";
}
public static String  _pan_shift_click() throws Exception{
 //BA.debugLineNum = 2950;BA.debugLine="Private Sub pan_shift_Click";
 //BA.debugLineNum = 2951;BA.debugLine="StartActivity(shift_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._shift_activity.getObject()));
 //BA.debugLineNum = 2953;BA.debugLine="End Sub";
return "";
}
public static String  _pan_taghvim_click() throws Exception{
 //BA.debugLineNum = 2955;BA.debugLine="Private Sub pan_taghvim_Click";
 //BA.debugLineNum = 2956;BA.debugLine="pan_shift_Click";
_pan_shift_click();
 //BA.debugLineNum = 2957;BA.debugLine="End Sub";
return "";
}
public static String  _panel1_click() throws Exception{
 //BA.debugLineNum = 2968;BA.debugLine="Private Sub Panel1_Click";
 //BA.debugLineNum = 2970;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
 //BA.debugLineNum = 1357;BA.debugLine="Private Sub Panel4_Click";
 //BA.debugLineNum = 1359;BA.debugLine="End Sub";
return "";
}
public static String  _panel5_click() throws Exception{
 //BA.debugLineNum = 2916;BA.debugLine="Private Sub Panel5_Click";
 //BA.debugLineNum = 2918;BA.debugLine="End Sub";
return "";
}
public static String  _panel6_click() throws Exception{
 //BA.debugLineNum = 3210;BA.debugLine="Private Sub Panel6_Click";
 //BA.debugLineNum = 3212;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2215;BA.debugLine="Private Sub pik_day_bala1_Click";
 //BA.debugLineNum = 2216;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 2217;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 2220;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 2221;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 2222;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 2224;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 2225;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 2228;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 2229;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 2231;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 2232;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 2236;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2238;BA.debugLine="Private Sub pik_day_paeen1_Click";
 //BA.debugLineNum = 2239;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 2240;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 2241;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 2242;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 2243;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 2245;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 2246;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 2249;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 2250;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 2252;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 2253;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 2257;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 1934;BA.debugLine="Private Sub pik_hour_bala1_Click";
 //BA.debugLineNum = 1936;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
 //BA.debugLineNum = 1937;BA.debugLine="pik_hour1.Text=int1+1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 1939;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
 //BA.debugLineNum = 1940;BA.debugLine="pik_hour1.Text=00";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(00));
 };
 //BA.debugLineNum = 1942;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
 //BA.debugLineNum = 1943;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
 //BA.debugLineNum = 1946;BA.debugLine="End Sub";
return "";
}
public static String  _pik_hour_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 1948;BA.debugLine="Private Sub pik_hour_paeen1_Click";
 //BA.debugLineNum = 1949;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())));
 //BA.debugLineNum = 1950;BA.debugLine="pik_hour1.Text=int1-1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 1952;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
 //BA.debugLineNum = 1953;BA.debugLine="pik_hour1.Text=00";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(00));
 };
 //BA.debugLineNum = 1955;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
 //BA.debugLineNum = 1956;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
 //BA.debugLineNum = 1959;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 1961;BA.debugLine="Private Sub pik_min_bala1_Click";
 //BA.debugLineNum = 1962;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
 //BA.debugLineNum = 1963;BA.debugLine="pik_min1.Text=int1+1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 1965;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
 //BA.debugLineNum = 1966;BA.debugLine="pik_min1.Text=00";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(00));
 };
 //BA.debugLineNum = 1968;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
 //BA.debugLineNum = 1969;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
 //BA.debugLineNum = 1972;BA.debugLine="End Sub";
return "";
}
public static String  _pik_min_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 1974;BA.debugLine="Private Sub pik_min_paeen1_Click";
 //BA.debugLineNum = 1975;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())));
 //BA.debugLineNum = 1976;BA.debugLine="pik_min1.Text=int1-1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 1978;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
 //BA.debugLineNum = 1979;BA.debugLine="pik_min1.Text=00";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(00));
 };
 //BA.debugLineNum = 1981;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
 //BA.debugLineNum = 1982;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
 //BA.debugLineNum = 1985;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2161;BA.debugLine="Private Sub pik_moon_bala1_Click";
 //BA.debugLineNum = 2162;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 2163;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
 //BA.debugLineNum = 2165;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 2166;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 2168;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 2169;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 2171;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 2173;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2175;BA.debugLine="Private Sub pik_moon_paeen1_Click";
 //BA.debugLineNum = 2176;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 2177;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
 //BA.debugLineNum = 2179;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 2180;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 2182;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 2183;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 2185;BA.debugLine="pik_moon1.Text=moon.Get(myfunc.fa2en(pik_moon1.Ta";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
 //BA.debugLineNum = 2187;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2121;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
 //BA.debugLineNum = 2122;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 2123;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 2124;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2127;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 2129;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 2130;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
 //BA.debugLineNum = 2131;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 2132;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2134;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 2135;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
 //BA.debugLineNum = 2136;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 2137;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2140;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 2141;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 2142;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 2144;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 2145;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 2148;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 2149;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 2151;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 2152;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 };
 //BA.debugLineNum = 2159;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_hour1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 1987;BA.debugLine="Private Sub pik_pan_hour1_Touch (Action As Int, X";
 //BA.debugLineNum = 1988;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 1989;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 1990;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 1993;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 1995;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 1996;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))-1);
 //BA.debugLineNum = 1997;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 1998;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2000;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 2001;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_hour1.getText())))+1);
 //BA.debugLineNum = 2002;BA.debugLine="pik_hour1.Text=int1";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 2003;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2006;BA.debugLine="If(pik_hour1.Text>23)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))>23)) { 
 //BA.debugLineNum = 2007;BA.debugLine="pik_hour1.Text=00";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(00));
 };
 //BA.debugLineNum = 2009;BA.debugLine="If(pik_hour1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_hour1.getText()))<0)) { 
 //BA.debugLineNum = 2010;BA.debugLine="pik_hour1.Text=23";
mostCurrent._pik_hour1.setText(BA.ObjectToCharSequence(23));
 };
 };
 //BA.debugLineNum = 2015;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_min1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2017;BA.debugLine="Private Sub pik_pan_min1_Touch (Action As Int, X A";
 //BA.debugLineNum = 2018;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 2019;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 2020;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2023;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 2025;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 2027;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))-1);
 //BA.debugLineNum = 2028;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 2031;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2033;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 2035;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_min1.getText())))+1);
 //BA.debugLineNum = 2036;BA.debugLine="pik_min1.Text=int1";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 2039;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2043;BA.debugLine="If(pik_min1.Text>59)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))>59)) { 
 //BA.debugLineNum = 2044;BA.debugLine="pik_min1.Text=00";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(00));
 };
 //BA.debugLineNum = 2047;BA.debugLine="If(pik_min1.Text<0)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_min1.getText()))<0)) { 
 //BA.debugLineNum = 2048;BA.debugLine="pik_min1.Text=59";
mostCurrent._pik_min1.setText(BA.ObjectToCharSequence(59));
 };
 };
 //BA.debugLineNum = 2055;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2061;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
 //BA.debugLineNum = 2062;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 2063;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 2064;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2067;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 2069;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 2070;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
 //BA.debugLineNum = 2071;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 2072;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2074;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 2075;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
 //BA.debugLineNum = 2076;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 2077;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2080;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 2081;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 2083;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 2084;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 2086;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
 //BA.debugLineNum = 2089;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2091;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
 //BA.debugLineNum = 2092;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 2093;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 2094;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2097;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 2099;BA.debugLine="If(Y>num+20)Then";
if ((_y>_num+20)) { 
 //BA.debugLineNum = 2100;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
 //BA.debugLineNum = 2101;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 2102;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2104;BA.debugLine="If(Y<num-20)Then";
if ((_y<_num-20)) { 
 //BA.debugLineNum = 2105;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
 //BA.debugLineNum = 2106;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 2107;BA.debugLine="num=y";
_num = (int) (_y);
 };
 //BA.debugLineNum = 2110;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 2111;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 2113;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 2114;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
 //BA.debugLineNum = 2119;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2189;BA.debugLine="Private Sub pik_year_bala1_Click";
 //BA.debugLineNum = 2190;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 2191;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 2193;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 2194;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 2196;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 2197;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 2200;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 2202;BA.debugLine="Private Sub pik_year_paeen1_Click";
 //BA.debugLineNum = 2203;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 2204;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 2206;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 2207;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 2209;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 2210;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 2213;BA.debugLine="End Sub";
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
bime_activity._process_globals();
calc_activity._process_globals();
comment_activity._process_globals();
darsad_activity._process_globals();
eidi_activity._process_globals();
ganon_activity._process_globals();
hogog_activity._process_globals();
info_activity._process_globals();
morakhasi_activity._process_globals();
payankar_activity._process_globals();
setting_activity._process_globals();
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
 //BA.debugLineNum = 26;BA.debugLine="Dim current_gozaresh_id As Int";
_current_gozaresh_id = 0;
 //BA.debugLineNum = 27;BA.debugLine="Dim persianDate As ManamPersianDate";
_persiandate = new com.b4a.manamsoftware.PersianDate.ManamPersianDate();
 //BA.debugLineNum = 29;BA.debugLine="Dim year_num As String";
_year_num = "";
 //BA.debugLineNum = 30;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 33;BA.debugLine="Dim phon As Phone";
_phon = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 35;BA.debugLine="Dim buy_index As Int";
_buy_index = 0;
 //BA.debugLineNum = 37;BA.debugLine="Dim time_page_load As Timer";
_time_page_load = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 39;BA.debugLine="Dim color_index As Int=1";
_color_index = (int) (1);
 //BA.debugLineNum = 40;BA.debugLine="Dim color1 As Int=0XFF69AC00   ' hed home1";
_color1 = ((int)0xff69ac00);
 //BA.debugLineNum = 41;BA.debugLine="Dim color2 As Int=0xFF00C7C7	' hed home2";
_color2 = ((int)0xff00c7c7);
 //BA.debugLineNum = 42;BA.debugLine="Dim color3 As Int=0XFFFFFFFF	' hed home3 font";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 43;BA.debugLine="Dim color4 As Int=0XFF69AC00	' all head";
_color4 = ((int)0xff69ac00);
 //BA.debugLineNum = 44;BA.debugLine="Dim color5 As Int=0XFF69AC00	' calc";
_color5 = ((int)0xff69ac00);
 //BA.debugLineNum = 46;BA.debugLine="Dim main_font As String=\"یکان\"";
_main_font = "یکان";
 //BA.debugLineNum = 47;BA.debugLine="Dim size_f1 As Int=17";
_size_f1 = (int) (17);
 //BA.debugLineNum = 48;BA.debugLine="Dim size_f2 As Int=15";
_size_f2 = (int) (15);
 //BA.debugLineNum = 49;BA.debugLine="Dim size_f3 As Int=13";
_size_f3 = (int) (13);
 //BA.debugLineNum = 51;BA.debugLine="Dim saat_kar_min As Int";
_saat_kar_min = 0;
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public static boolean  _rspop_noe_menuitemclick(int _itemid) throws Exception{
 //BA.debugLineNum = 1241;BA.debugLine="Sub rsPOP_noe_MenuItemClick (ItemId As Int) As Boo";
 //BA.debugLineNum = 1243;BA.debugLine="Select ItemId";
switch (_itemid) {
case 0: {
 //BA.debugLineNum = 1245;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
mostCurrent._str_noe = "استحقاقی-ساعتی/روزانه";
 break; }
case 1: {
 //BA.debugLineNum = 1247;BA.debugLine="str_noe=\"استعلاجی\"";
mostCurrent._str_noe = "استعلاجی";
 break; }
case 2: {
 //BA.debugLineNum = 1249;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
mostCurrent._str_noe = "سایر (با حقوق)";
 break; }
case 3: {
 //BA.debugLineNum = 1251;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
mostCurrent._str_noe = "سایر (بدون حقوق)";
 break; }
}
;
 //BA.debugLineNum = 1255;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("نوع مرخصی : "+mostCurrent._str_noe));
 //BA.debugLineNum = 1256;BA.debugLine="index_noe_morakhasi=ItemId";
_index_noe_morakhasi = _itemid;
 //BA.debugLineNum = 1257;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1258;BA.debugLine="End Sub";
return false;
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 2302;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
 //BA.debugLineNum = 2303;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 2304;BA.debugLine="Select sp_moon.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_moon.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11))) {
case 0: {
 //BA.debugLineNum = 2306;BA.debugLine="moon_num=\"01\"";
_moon_num = "01";
 break; }
case 1: {
 //BA.debugLineNum = 2308;BA.debugLine="moon_num=\"02\"";
_moon_num = "02";
 break; }
case 2: {
 //BA.debugLineNum = 2310;BA.debugLine="moon_num=\"03\"";
_moon_num = "03";
 break; }
case 3: {
 //BA.debugLineNum = 2312;BA.debugLine="moon_num=\"04\"";
_moon_num = "04";
 break; }
case 4: {
 //BA.debugLineNum = 2314;BA.debugLine="moon_num=\"05\"";
_moon_num = "05";
 break; }
case 5: {
 //BA.debugLineNum = 2316;BA.debugLine="moon_num=\"06\"";
_moon_num = "06";
 break; }
case 6: {
 //BA.debugLineNum = 2318;BA.debugLine="moon_num=\"07\"";
_moon_num = "07";
 break; }
case 7: {
 //BA.debugLineNum = 2320;BA.debugLine="moon_num=\"08\"";
_moon_num = "08";
 break; }
case 8: {
 //BA.debugLineNum = 2322;BA.debugLine="moon_num=\"09\"";
_moon_num = "09";
 break; }
case 9: {
 //BA.debugLineNum = 2324;BA.debugLine="moon_num=\"10\"";
_moon_num = "10";
 break; }
case 10: {
 //BA.debugLineNum = 2326;BA.debugLine="moon_num=\"11\"";
_moon_num = "11";
 break; }
case 11: {
 //BA.debugLineNum = 2328;BA.debugLine="moon_num=\"12\"";
_moon_num = "12";
 break; }
}
;
 //BA.debugLineNum = 2331;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
 //BA.debugLineNum = 2332;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
 //BA.debugLineNum = 2333;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_gozaresh_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 2972;BA.debugLine="Private Sub sp_year_gozaresh_ItemClick (Position A";
 //BA.debugLineNum = 2973;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
_fill_list_gozareshat(mostCurrent._sp_year_gozaresh.getSelectedItem());
 //BA.debugLineNum = 2974;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 2264;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
 //BA.debugLineNum = 2269;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 2270;BA.debugLine="Select sp_moon.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_moon.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11))) {
case 0: {
 //BA.debugLineNum = 2272;BA.debugLine="moon_num=\"01\"";
_moon_num = "01";
 break; }
case 1: {
 //BA.debugLineNum = 2274;BA.debugLine="moon_num=\"02\"";
_moon_num = "02";
 break; }
case 2: {
 //BA.debugLineNum = 2276;BA.debugLine="moon_num=\"03\"";
_moon_num = "03";
 break; }
case 3: {
 //BA.debugLineNum = 2278;BA.debugLine="moon_num=\"04\"";
_moon_num = "04";
 break; }
case 4: {
 //BA.debugLineNum = 2280;BA.debugLine="moon_num=\"05\"";
_moon_num = "05";
 break; }
case 5: {
 //BA.debugLineNum = 2282;BA.debugLine="moon_num=\"06\"";
_moon_num = "06";
 break; }
case 6: {
 //BA.debugLineNum = 2284;BA.debugLine="moon_num=\"07\"";
_moon_num = "07";
 break; }
case 7: {
 //BA.debugLineNum = 2286;BA.debugLine="moon_num=\"08\"";
_moon_num = "08";
 break; }
case 8: {
 //BA.debugLineNum = 2288;BA.debugLine="moon_num=\"09\"";
_moon_num = "09";
 break; }
case 9: {
 //BA.debugLineNum = 2290;BA.debugLine="moon_num=\"10\"";
_moon_num = "10";
 break; }
case 10: {
 //BA.debugLineNum = 2292;BA.debugLine="moon_num=\"11\"";
_moon_num = "11";
 break; }
case 11: {
 //BA.debugLineNum = 2294;BA.debugLine="moon_num=\"12\"";
_moon_num = "12";
 break; }
}
;
 //BA.debugLineNum = 2296;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
_fill_lists(mostCurrent._sp_year.getSelectedItem(),_moon_num);
 //BA.debugLineNum = 2298;BA.debugLine="TabHost1_TabChanged";
_tabhost1_tabchanged();
 //BA.debugLineNum = 2300;BA.debugLine="End Sub";
return "";
}
public static String  _tabhost1_tabchanged() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_all_saat = null;
String _str_saat = "";
 //BA.debugLineNum = 861;BA.debugLine="Private Sub TabHost1_TabChanged";
 //BA.debugLineNum = 863;BA.debugLine="Dim ls_all_saat As List";
_ls_all_saat = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 864;BA.debugLine="ls_all_saat.Initialize";
_ls_all_saat.Initialize();
 //BA.debugLineNum = 865;BA.debugLine="Dim str_saat As String";
_str_saat = "";
 //BA.debugLineNum = 867;BA.debugLine="If(sp_year.IsInitialized)Then";
if ((mostCurrent._sp_year.IsInitialized())) { 
 //BA.debugLineNum = 873;BA.debugLine="Select TabHost1.CurrentTab";
switch (BA.switchObjectToInt(mostCurrent._tabhost1.getCurrentTab(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 875;BA.debugLine="ls_all_saat=dbCode.all_ezafekari_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
 //BA.debugLineNum = 876;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
case 1: {
 //BA.debugLineNum = 878;BA.debugLine="ls_all_saat=dbCode.all_morakhasi_mah(myfunc.fa";
_ls_all_saat = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 //BA.debugLineNum = 880;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" روز و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" ساعت و "+BA.ObjectToString(_ls_all_saat.Get((int) (2)))+" دقیقه ";
 break; }
case 2: {
 //BA.debugLineNum = 882;BA.debugLine="ls_all_saat=dbCode.all_taradod_mah(myfunc.fa2e";
_ls_all_saat = mostCurrent._dbcode._all_taradod_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 //BA.debugLineNum = 883;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
_str_saat = BA.ObjectToString(_ls_all_saat.Get((int) (0)))+" ساعت و"+BA.ObjectToString(_ls_all_saat.Get((int) (1)))+" دقیقه ";
 break; }
}
;
 //BA.debugLineNum = 890;BA.debugLine="lbl_majmoe_saat.Text=str_saat";
mostCurrent._lbl_majmoe_saat.setText(BA.ObjectToCharSequence(_str_saat));
 };
 //BA.debugLineNum = 896;BA.debugLine="End Sub";
return "";
}
public static String  _tim_msg_tick() throws Exception{
String _msg_key = "";
String _msg_value = "";
 //BA.debugLineNum = 449;BA.debugLine="Sub tim_msg_Tick";
 //BA.debugLineNum = 451;BA.debugLine="Dim msg_key As String";
_msg_key = "";
 //BA.debugLineNum = 452;BA.debugLine="Dim msg_value As String";
_msg_value = "";
 //BA.debugLineNum = 455;BA.debugLine="msg_key=msg.SubString2(0,4)";
_msg_key = mostCurrent._msg.substring((int) (0),(int) (4));
 //BA.debugLineNum = 456;BA.debugLine="msg_value=msg.SubString(5)";
_msg_value = mostCurrent._msg.substring((int) (5));
 //BA.debugLineNum = 458;BA.debugLine="ls1.Add(msg_key)";
mostCurrent._ls1.Add((Object)(_msg_key));
 //BA.debugLineNum = 459;BA.debugLine="ls2.Add(msg_value)";
mostCurrent._ls2.Add((Object)(_msg_value));
 //BA.debugLineNum = 460;BA.debugLine="ls3.Add(lbl_date_home.Text)";
mostCurrent._ls3.Add((Object)(mostCurrent._lbl_date_home.getText()));
 //BA.debugLineNum = 462;BA.debugLine="File.WriteList(File.DirInternal,\"ls1\",ls1)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls1",mostCurrent._ls1);
 //BA.debugLineNum = 463;BA.debugLine="File.WriteList(File.DirInternal,\"ls2\",ls2)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls2",mostCurrent._ls2);
 //BA.debugLineNum = 464;BA.debugLine="File.WriteList(File.DirInternal,\"ls3\",ls3)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls3",mostCurrent._ls3);
 //BA.debugLineNum = 466;BA.debugLine="lbl_title_msgPan.Text=\"پیام جدید\"";
mostCurrent._lbl_title_msgpan.setText(BA.ObjectToCharSequence("پیام جدید"));
 //BA.debugLineNum = 467;BA.debugLine="pan_notifi_all.Visible=True";
mostCurrent._pan_notifi_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 469;BA.debugLine="pan_notif.Top=20%y";
mostCurrent._pan_notif.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 470;BA.debugLine="pan_notif.Height=50%y";
mostCurrent._pan_notif.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA));
 //BA.debugLineNum = 471;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
mostCurrent._web_msg_show.setHeight((int) (mostCurrent._pan_notif.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60))));
 //BA.debugLineNum = 474;BA.debugLine="web_msg_show.LoadHtml(\"<!DOCTYPE html><html><meta";
mostCurrent._web_msg_show.LoadHtml("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'><div style='background-color: #99ffff; font-size: 14px;'>"+"کد پیام : "+_msg_key+" - مورخ : "+mostCurrent._lbl_date_home.getText()+"</div><div style='background-color: #e6ffff; font-size: 18px;'><br>"+_msg_value+"<br></div><br></body></html>");
 //BA.debugLineNum = 476;BA.debugLine="tim_msg.Enabled=False";
_tim_msg.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 477;BA.debugLine="End Sub";
return "";
}
public static int  _tim_vorod_conv_ezaf(String _tim1) throws Exception{
String[] _ste_tim = null;
 //BA.debugLineNum = 3214;BA.debugLine="Sub tim_vorod_conv_ezaf (tim1 As String) As Int";
 //BA.debugLineNum = 3216;BA.debugLine="Dim ste_tim() As String";
_ste_tim = new String[(int) (0)];
java.util.Arrays.fill(_ste_tim,"");
 //BA.debugLineNum = 3217;BA.debugLine="ste_tim=Regex.Split(\":\",tim1)";
_ste_tim = anywheresoftware.b4a.keywords.Common.Regex.Split(":",_tim1);
 //BA.debugLineNum = 3220;BA.debugLine="Return (ste_tim(0)*60)+ste_tim(1) +saat_kar_min";
if (true) return (int) (((double)(Double.parseDouble(_ste_tim[(int) (0)]))*60)+(double)(Double.parseDouble(_ste_tim[(int) (1)]))+_saat_kar_min);
 //BA.debugLineNum = 3223;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 1682;BA.debugLine="Sub time_show";
 //BA.debugLineNum = 1684;BA.debugLine="Try";
try { //BA.debugLineNum = 1687;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1688;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1689;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
 //BA.debugLineNum = 1690;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
 //BA.debugLineNum = 1692;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
 //BA.debugLineNum = 1693;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
 //BA.debugLineNum = 1694;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 1695;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 1697;BA.debugLine="Select pik_moon1.Tag";
switch (BA.switchObjectToInt(mostCurrent._pik_moon1.getTag(),(Object)(1),(Object)(2),(Object)(3),(Object)(4),(Object)(5),(Object)(6),(Object)(7),(Object)(8),(Object)(9),(Object)(10),(Object)(11),(Object)(12))) {
case 0: {
 //BA.debugLineNum = 1699;BA.debugLine="pik_moon1.Tag=\"01\"";
mostCurrent._pik_moon1.setTag((Object)("01"));
 break; }
case 1: {
 //BA.debugLineNum = 1701;BA.debugLine="pik_moon1.Tag=\"02\"";
mostCurrent._pik_moon1.setTag((Object)("02"));
 break; }
case 2: {
 //BA.debugLineNum = 1703;BA.debugLine="pik_moon1.Tag=\"03\"";
mostCurrent._pik_moon1.setTag((Object)("03"));
 break; }
case 3: {
 //BA.debugLineNum = 1705;BA.debugLine="pik_moon1.Tag=\"04\"";
mostCurrent._pik_moon1.setTag((Object)("04"));
 break; }
case 4: {
 //BA.debugLineNum = 1707;BA.debugLine="pik_moon1.Tag=\"05\"";
mostCurrent._pik_moon1.setTag((Object)("05"));
 break; }
case 5: {
 //BA.debugLineNum = 1709;BA.debugLine="pik_moon1.Tag=\"06\"";
mostCurrent._pik_moon1.setTag((Object)("06"));
 break; }
case 6: {
 //BA.debugLineNum = 1711;BA.debugLine="pik_moon1.Tag=\"07\"";
mostCurrent._pik_moon1.setTag((Object)("07"));
 break; }
case 7: {
 //BA.debugLineNum = 1713;BA.debugLine="pik_moon1.Tag=\"08\"";
mostCurrent._pik_moon1.setTag((Object)("08"));
 break; }
case 8: {
 //BA.debugLineNum = 1715;BA.debugLine="pik_moon1.Tag=\"09\"";
mostCurrent._pik_moon1.setTag((Object)("09"));
 break; }
case 9: {
 //BA.debugLineNum = 1717;BA.debugLine="pik_moon1.Tag=\"10\"";
mostCurrent._pik_moon1.setTag((Object)("10"));
 break; }
case 10: {
 //BA.debugLineNum = 1719;BA.debugLine="pik_moon1.Tag=\"11\"";
mostCurrent._pik_moon1.setTag((Object)("11"));
 break; }
case 11: {
 //BA.debugLineNum = 1721;BA.debugLine="pik_moon1.Tag=\"12\"";
mostCurrent._pik_moon1.setTag((Object)("12"));
 break; }
}
;
 //BA.debugLineNum = 1727;BA.debugLine="date1=lbl_date1.Text";
mostCurrent._date1 = mostCurrent._lbl_date1.getText();
 //BA.debugLineNum = 1728;BA.debugLine="date2=lbl_date2.Text";
mostCurrent._date2 = mostCurrent._lbl_date2.getText();
 //BA.debugLineNum = 1729;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
 //BA.debugLineNum = 1730;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
 //BA.debugLineNum = 1734;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_dat";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
 //BA.debugLineNum = 1735;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_dat";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
 //BA.debugLineNum = 1738;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
 //BA.debugLineNum = 1739;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
 //BA.debugLineNum = 1742;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
 //BA.debugLineNum = 1743;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
 //BA.debugLineNum = 1745;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date_";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
 //BA.debugLineNum = 1746;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date_";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
 //BA.debugLineNum = 1748;BA.debugLine="time_end2=lbl_tim2.Text&\":00\"";
_time_end2 = mostCurrent._lbl_tim2.getText()+":00";
 //BA.debugLineNum = 1749;BA.debugLine="time_end1=lbl_tim1.Text&\":00\"";
_time_end1 = mostCurrent._lbl_tim1.getText()+":00";
 //BA.debugLineNum = 1751;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
 //BA.debugLineNum = 1752;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
 //BA.debugLineNum = 1753;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
 //BA.debugLineNum = 1754;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
 //BA.debugLineNum = 1758;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
 //BA.debugLineNum = 1759;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
 //BA.debugLineNum = 1762;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1763;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
 //BA.debugLineNum = 1765;BA.debugLine="If (period_between.Years<>0)Then";
if ((_period_between.Years!=0)) { 
 //BA.debugLineNum = 1766;BA.debugLine="str_show.Append(period_between.Years&\" سال \").A";
_str_show.Append(BA.NumberToString(_period_between.Years)+" سال ").Append(" و ");
 };
 //BA.debugLineNum = 1768;BA.debugLine="If (period_between.Months<>0)Then";
if ((_period_between.Months!=0)) { 
 //BA.debugLineNum = 1769;BA.debugLine="str_show.Append(period_between.Months&\" ماه \").";
_str_show.Append(BA.NumberToString(_period_between.Months)+" ماه ").Append(" و ");
 };
 //BA.debugLineNum = 1771;BA.debugLine="If (period_between.Days<>0)Then";
if ((_period_between.Days!=0)) { 
 //BA.debugLineNum = 1772;BA.debugLine="str_show.Append(period_between.Days&\" روز \").Ap";
_str_show.Append(BA.NumberToString(_period_between.Days)+" روز ").Append(" و ");
 };
 //BA.debugLineNum = 1775;BA.debugLine="str_show.Append(period_between.Hours&\" ساعت \").A";
_str_show.Append(BA.NumberToString(_period_between.Hours)+" ساعت ").Append(" و ");
 //BA.debugLineNum = 1776;BA.debugLine="str_show.Append(period_between.Minutes&\" دقیقه \"";
_str_show.Append(BA.NumberToString(_period_between.Minutes)+" دقیقه ");
 //BA.debugLineNum = 1779;BA.debugLine="year_bt=period_between.Years";
_year_bt = _period_between.Years;
 //BA.debugLineNum = 1780;BA.debugLine="moon_bt=period_between.Months";
_moon_bt = _period_between.Months;
 //BA.debugLineNum = 1781;BA.debugLine="day_bt=period_between.Days";
_day_bt = _period_between.Days;
 //BA.debugLineNum = 1782;BA.debugLine="hour_bt=period_between.Hours";
_hour_bt = _period_between.Hours;
 //BA.debugLineNum = 1783;BA.debugLine="min_bt=period_between.Minutes";
_min_bt = _period_between.Minutes;
 //BA.debugLineNum = 1786;BA.debugLine="lbl_time_show.Text=str_show";
mostCurrent._lbl_time_show.setText(BA.ObjectToCharSequence(_str_show.getObject()));
 //BA.debugLineNum = 1787;BA.debugLine="If(index_box=3)Then";
if ((_index_box==3)) { 
 //BA.debugLineNum = 1789;BA.debugLine="tim_min=(hour_bt*60)+min_bt";
_tim_min = (int) ((_hour_bt*60)+_min_bt);
 //BA.debugLineNum = 1793;BA.debugLine="If(tim_min>saat_kar_min) Then";
if ((_tim_min>_saat_kar_min)) { 
 //BA.debugLineNum = 1794;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1798;BA.debugLine="lbl_ezaf_taradod.Text=\"افزودن به اضافه کاری \"&";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence("افزودن به اضافه کاری "+BA.ObjectToString((mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (0))))+" ساعت و "+BA.ObjectToString(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_tim_min-_saat_kar_min)).Get((int) (1)))+" دقیقه "));
 }else {
 //BA.debugLineNum = 1802;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
mostCurrent._lbl_ezaf_taradod.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1803;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
mostCurrent._ckb_ezaf_taradod.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 } 
       catch (Exception e86) {
			processBA.setLastException(e86); //BA.debugLineNum = 1811;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 1813;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 1817;BA.debugLine="Sub time_show2 (dat1 As String,dat2 As String, tim";
 //BA.debugLineNum = 1819;BA.debugLine="Try";
try { //BA.debugLineNum = 1822;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1823;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1824;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
 //BA.debugLineNum = 1825;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
 //BA.debugLineNum = 1827;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
 //BA.debugLineNum = 1828;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
 //BA.debugLineNum = 1829;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 1830;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 1832;BA.debugLine="Select pik_moon1.Tag";
switch (BA.switchObjectToInt(mostCurrent._pik_moon1.getTag(),(Object)(1),(Object)(2),(Object)(3),(Object)(4),(Object)(5),(Object)(6),(Object)(7),(Object)(8),(Object)(9),(Object)(10),(Object)(11),(Object)(12))) {
case 0: {
 //BA.debugLineNum = 1834;BA.debugLine="pik_moon1.Tag=\"01\"";
mostCurrent._pik_moon1.setTag((Object)("01"));
 break; }
case 1: {
 //BA.debugLineNum = 1836;BA.debugLine="pik_moon1.Tag=\"02\"";
mostCurrent._pik_moon1.setTag((Object)("02"));
 break; }
case 2: {
 //BA.debugLineNum = 1838;BA.debugLine="pik_moon1.Tag=\"03\"";
mostCurrent._pik_moon1.setTag((Object)("03"));
 break; }
case 3: {
 //BA.debugLineNum = 1840;BA.debugLine="pik_moon1.Tag=\"04\"";
mostCurrent._pik_moon1.setTag((Object)("04"));
 break; }
case 4: {
 //BA.debugLineNum = 1842;BA.debugLine="pik_moon1.Tag=\"05\"";
mostCurrent._pik_moon1.setTag((Object)("05"));
 break; }
case 5: {
 //BA.debugLineNum = 1844;BA.debugLine="pik_moon1.Tag=\"06\"";
mostCurrent._pik_moon1.setTag((Object)("06"));
 break; }
case 6: {
 //BA.debugLineNum = 1846;BA.debugLine="pik_moon1.Tag=\"07\"";
mostCurrent._pik_moon1.setTag((Object)("07"));
 break; }
case 7: {
 //BA.debugLineNum = 1848;BA.debugLine="pik_moon1.Tag=\"08\"";
mostCurrent._pik_moon1.setTag((Object)("08"));
 break; }
case 8: {
 //BA.debugLineNum = 1850;BA.debugLine="pik_moon1.Tag=\"09\"";
mostCurrent._pik_moon1.setTag((Object)("09"));
 break; }
case 9: {
 //BA.debugLineNum = 1852;BA.debugLine="pik_moon1.Tag=\"10\"";
mostCurrent._pik_moon1.setTag((Object)("10"));
 break; }
case 10: {
 //BA.debugLineNum = 1854;BA.debugLine="pik_moon1.Tag=\"11\"";
mostCurrent._pik_moon1.setTag((Object)("11"));
 break; }
case 11: {
 //BA.debugLineNum = 1856;BA.debugLine="pik_moon1.Tag=\"12\"";
mostCurrent._pik_moon1.setTag((Object)("12"));
 break; }
}
;
 //BA.debugLineNum = 1862;BA.debugLine="date1=dat1";
mostCurrent._date1 = _dat1;
 //BA.debugLineNum = 1863;BA.debugLine="date2=dat2";
mostCurrent._date2 = _dat2;
 //BA.debugLineNum = 1864;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = mostCurrent._strfun._vvvvvv5(mostCurrent._date1,"/");
 //BA.debugLineNum = 1865;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = mostCurrent._strfun._vvvvvv5(mostCurrent._date2,"/");
 //BA.debugLineNum = 1869;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_dat";
_dat_mil_2 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
 //BA.debugLineNum = 1870;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_dat";
_dat_mil_1 = _persiandate.PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
 //BA.debugLineNum = 1873;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = mostCurrent._strfun._vvvvvv5(_dat_mil_1,"/");
 //BA.debugLineNum = 1874;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = mostCurrent._strfun._vvvvvv5(_dat_mil_2,"/");
 //BA.debugLineNum = 1877;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
 //BA.debugLineNum = 1878;BA.debugLine="Dim time_end1 ,time_end2 As String";
_time_end1 = "";
_time_end2 = "";
 //BA.debugLineNum = 1880;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date_";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
 //BA.debugLineNum = 1881;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date_";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
 //BA.debugLineNum = 1883;BA.debugLine="time_end2=tim2&\":00\"";
_time_end2 = _tim2+":00";
 //BA.debugLineNum = 1884;BA.debugLine="time_end1=tim1&\":00\"";
_time_end1 = _tim1+":00";
 //BA.debugLineNum = 1886;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
 //BA.debugLineNum = 1887;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
 //BA.debugLineNum = 1888;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end1));
 //BA.debugLineNum = 1889;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_time_end2));
 //BA.debugLineNum = 1893;BA.debugLine="Dim period_between As Period";
_period_between = new b4a.example.dateutils._period();
 //BA.debugLineNum = 1894;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
_period_between = mostCurrent._dateutils._periodbetween(mostCurrent.activityBA,(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim1_long)))),(long)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(_tim2_long)))));
 //BA.debugLineNum = 1897;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1898;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
 //BA.debugLineNum = 1900;BA.debugLine="If (period_between.Years<>0)Then";
if ((_period_between.Years!=0)) { 
 //BA.debugLineNum = 1901;BA.debugLine="str_show.Append(period_between.Years&\" سال \").A";
_str_show.Append(BA.NumberToString(_period_between.Years)+" سال ").Append(" و ");
 };
 //BA.debugLineNum = 1903;BA.debugLine="If (period_between.Months<>0)Then";
if ((_period_between.Months!=0)) { 
 //BA.debugLineNum = 1904;BA.debugLine="str_show.Append(period_between.Months&\" ماه \").";
_str_show.Append(BA.NumberToString(_period_between.Months)+" ماه ").Append(" و ");
 };
 //BA.debugLineNum = 1906;BA.debugLine="If (period_between.Days<>0)Then";
if ((_period_between.Days!=0)) { 
 //BA.debugLineNum = 1907;BA.debugLine="str_show.Append(period_between.Days&\" روز \").Ap";
_str_show.Append(BA.NumberToString(_period_between.Days)+" روز ").Append(" و ");
 };
 //BA.debugLineNum = 1910;BA.debugLine="str_show.Append(period_between.Hours&\" ساعت \").A";
_str_show.Append(BA.NumberToString(_period_between.Hours)+" ساعت ").Append(" و ");
 //BA.debugLineNum = 1911;BA.debugLine="str_show.Append(period_between.Minutes&\" دقیقه \"";
_str_show.Append(BA.NumberToString(_period_between.Minutes)+" دقیقه ");
 //BA.debugLineNum = 1914;BA.debugLine="year_bt=period_between.Years";
_year_bt = _period_between.Years;
 //BA.debugLineNum = 1915;BA.debugLine="moon_bt=period_between.Months";
_moon_bt = _period_between.Months;
 //BA.debugLineNum = 1916;BA.debugLine="day_bt=period_between.Days";
_day_bt = _period_between.Days;
 //BA.debugLineNum = 1917;BA.debugLine="hour_bt=period_between.Hours";
_hour_bt = _period_between.Hours;
 //BA.debugLineNum = 1918;BA.debugLine="min_bt=period_between.Minutes";
_min_bt = _period_between.Minutes;
 //BA.debugLineNum = 1921;BA.debugLine="lbl_time_show_FT.Text=str_show";
mostCurrent._lbl_time_show_ft.setText(BA.ObjectToCharSequence(_str_show.getObject()));
 } 
       catch (Exception e76) {
			processBA.setLastException(e76); //BA.debugLineNum = 1924;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 1926;BA.debugLine="End Sub";
return "";
}
public static String  _timer1_tick() throws Exception{
 //BA.debugLineNum = 561;BA.debugLine="Sub timer1_Tick";
 //BA.debugLineNum = 562;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
mostCurrent._activity.LoadLayout("main_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 563;BA.debugLine="timer1.Enabled=False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 564;BA.debugLine="cv_loader.Hide";
mostCurrent._cv_loader._hide /*String*/ ();
 //BA.debugLineNum = 566;BA.debugLine="btn_menu_home_Click";
_btn_menu_home_click();
 //BA.debugLineNum = 568;BA.debugLine="End Sub";
return "";
}
}
