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

public class hogog_activity extends Activity implements B4AActivity{
	public static hogog_activity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.hogog_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (hogog_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.hogog_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.hogog_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (hogog_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (hogog_activity) Resume **");
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
		return hogog_activity.class;
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
            BA.LogInfo("** Activity (hogog_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (hogog_activity) Pause event (activity is not paused). **");
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
            hogog_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (hogog_activity) Resume **");
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
public static String _paye = "";
public static int _maskan = 0;
public static int _olad = 0;
public static int _fani = 0;
public static int _masoliat = 0;
public static int _bon = 0;
public static int _bime_tamin = 0;
public static int _bime_takmil = 0;
public static int _roze_kari = 0;
public static int _sarparasti = 0;
public static int _sanavat = 0;
public static int _mazaya = 0;
public static int _ksorat = 0;
public static double _shift = 0;
public anywheresoftware.b4a.keywords.StringBuilderWrapper _str1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_time_h = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_time_m = null;
public anywheresoftware.b4a.objects.WebViewWrapper _webview1 = null;
public anywheresoftware.b4a.objects.WebViewWrapper _webview2 = null;
public static int _paye_end = 0;
public static int _vahed_ezafekari = 0;
public static int _ezafekari_end = 0;
public static int _bime_tamin_end = 0;
public static int _shift_end = 0;
public static int _maliat_end = 0;
public static int _maskan_end = 0;
public static int _sanavat_end = 0;
public static int _olad_end = 0;
public static int _fani_end = 0;
public static int _bon_end = 0;
public static int _masoliat_end = 0;
public static int _sarparasti_end = 0;
public static int _mazaya_end = 0;
public static int _vahed_ezafekari_vij = 0;
public static int _ezafekari_end_vij = 0;
public static int _hogog_nakhales = 0;
public static int _hogog_khales = 0;
public static int _jame_kosorat = 0;
public anywheresoftware.b4a.objects.SpinnerWrapper _sp_year = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _sp_moon = null;
public static String _moon_num = "";
public anywheresoftware.b4a.objects.PanelWrapper _pan_mohasebat = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_rozekari = null;
public anywheresoftware.b4a.keywords.StringBuilderWrapper _str_web1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_name_gozaresh = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_tozih_gozaresh = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_load = null;
public ir.taravatgroup.ezafekari2.b4xloadingindicator _b4xloadingindicator1 = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scv_hogog = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_vahed_ezafekari = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_hogog = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_main_hed_hogog = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_gozaresh = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_vahed_ezafekari_vij = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_time_h_vij = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_time_m_vij = null;
public anywheresoftware.b4a.objects.collections.List _ls_onvanha = null;
public anywheresoftware.b4a.objects.PdfDocumentWrapper.Printer _printer = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radio_type1 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radio_type2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date_to = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date_from = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_set_date = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_year1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_moon1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_day1 = null;
public static int _num_datapik = 0;
public anywheresoftware.b4a.objects.collections.List _moon_datapik = null;
public static int _index_datepik = 0;
public static int _type_mohasebe = 0;
public static int _mosaedeh_all = 0;
public static int _food_all = 0;
public static int _padash_all = 0;
public static int _sayer_1_all = 0;
public static int _sayer_2_all = 0;
public static int _ayab_1_all = 0;
public static int _ayab_2_all = 0;
public static int _gest_vam = 0;
public static String _date2_fixed = "";
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
public ir.taravatgroup.ezafekari2.gestha_activity _gestha_activity = null;
public ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
public ir.taravatgroup.ezafekari2.sayer_activity _sayer_activity = null;
public ir.taravatgroup.ezafekari2.help_kharid_activity _help_kharid_activity = null;
public ir.taravatgroup.ezafekari2.ayabzahab_activity _ayabzahab_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.food_activity _food_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.mosaedeh_activity _mosaedeh_activity = null;
public ir.taravatgroup.ezafekari2.padash_activity _padash_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.drawable.BitmapDrawable _imm = null;
 //BA.debugLineNum = 128;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 130;BA.debugLine="Activity.LoadLayout(\"hogog_layout\")";
mostCurrent._activity.LoadLayout("hogog_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 131;BA.debugLine="scv_hogog.Panel.LoadLayout(\"item_hogog\")";
mostCurrent._scv_hogog.getPanel().LoadLayout("item_hogog",mostCurrent.activityBA);
 //BA.debugLineNum = 133;BA.debugLine="get_data_hogogi";
_get_data_hogogi();
 //BA.debugLineNum = 135;BA.debugLine="Main.time_page_load.Initialize(\"time_page_load\",1";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .Initialize(processBA,"time_page_load",(long) (1500));
 //BA.debugLineNum = 136;BA.debugLine="Main.time_page_load.Enabled=True";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 137;BA.debugLine="B4XLoadingIndicator1.Show";
mostCurrent._b4xloadingindicator1._show /*String*/ ();
 //BA.debugLineNum = 139;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
 //BA.debugLineNum = 140;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
 //BA.debugLineNum = 141;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
 //BA.debugLineNum = 142;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
 //BA.debugLineNum = 144;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
 //BA.debugLineNum = 146;BA.debugLine="Dim imm As BitmapDrawable";
_imm = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 147;BA.debugLine="imm.Initialize(LoadBitmap(File.DirAssets,\"textBox";
_imm.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"textBox.png").getObject()));
 //BA.debugLineNum = 148;BA.debugLine="imm.Gravity=Gravity.FILL";
_imm.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 149;BA.debugLine="sp_year.Background=imm";
mostCurrent._sp_year.setBackground((android.graphics.drawable.Drawable)(_imm.getObject()));
 //BA.debugLineNum = 150;BA.debugLine="sp_moon.Background=imm";
mostCurrent._sp_moon.setBackground((android.graphics.drawable.Drawable)(_imm.getObject()));
 //BA.debugLineNum = 153;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))-1));
 //BA.debugLineNum = 158;BA.debugLine="pan_hed_hogog.Color=Main.color4";
mostCurrent._pan_hed_hogog.setColor(mostCurrent._main._color4 /*int*/ );
 //BA.debugLineNum = 159;BA.debugLine="pan_main_hed_hogog.Color=Main.color4";
mostCurrent._pan_main_hed_hogog.setColor(mostCurrent._main._color4 /*int*/ );
 //BA.debugLineNum = 160;BA.debugLine="pan_hed_gozaresh.Color=Main.color4";
mostCurrent._pan_hed_gozaresh.setColor(mostCurrent._main._color4 /*int*/ );
 //BA.debugLineNum = 161;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 164;BA.debugLine="WebView1.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview1.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 165;BA.debugLine="WebView2.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview2.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 168;BA.debugLine="ls_onvanHa.Initialize";
mostCurrent._ls_onvanha.Initialize();
 //BA.debugLineNum = 169;BA.debugLine="ls_onvanHa=dbCode.read_onvan_db";
mostCurrent._ls_onvanha = mostCurrent._dbcode._read_onvan_db /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 172;BA.debugLine="str_web1.Initialize";
mostCurrent._str_web1.Initialize();
 //BA.debugLineNum = 173;BA.debugLine="str_web1.Append(\"<html dir='rtl'><meta charset='U";
mostCurrent._str_web1.Append("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>");
 //BA.debugLineNum = 174;BA.debugLine="str_web1.Append(\"<h4 align='center' >اطلاعات حقوق";
mostCurrent._str_web1.Append("<h4 align='center' >اطلاعات حقوق برای ۳۰ روز</h4>");
 //BA.debugLineNum = 175;BA.debugLine="str_web1.Append(\"<h6 align='center'>واحد : تومان<";
mostCurrent._str_web1.Append("<h6 align='center'>واحد : تومان</h6>");
 //BA.debugLineNum = 176;BA.debugLine="str_web1.Append(\"<table style='width:100%'><tr>\")";
mostCurrent._str_web1.Append("<table style='width:100%'><tr>");
 //BA.debugLineNum = 177;BA.debugLine="str_web1.Append(\"<td>\"&\"\"&ls_onvanHa.Get(0)&\" : \"";
mostCurrent._str_web1.Append("<td>"+""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (0)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool((int)(Double.parseDouble(mostCurrent._paye))))+"<br>");
 //BA.debugLineNum = 178;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(2)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (2)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maskan))+"<br>");
 //BA.debugLineNum = 179;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(3)&\" : \"&myfun";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (3)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bon))+"<br>");
 //BA.debugLineNum = 180;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(4)&\"  : \"&myfun";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (4)))+"  : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad))+"<br>");
 //BA.debugLineNum = 181;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(5)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (5)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_fani))+"<br>");
 //BA.debugLineNum = 182;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(6)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (6)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_masoliat))+"<br>");
 //BA.debugLineNum = 183;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(7)&\"  : \"&myfu";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (7)))+"  : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sarparasti))+"<br></td>");
 //BA.debugLineNum = 187;BA.debugLine="str_web1.Append(\"<td>\"&\" \"&ls_onvanHa.Get(1)&\" :";
mostCurrent._str_web1.Append("<td>"+" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (1)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat))+"<br>");
 //BA.debugLineNum = 188;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(8)&\" : \"&myfun";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (8)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_shift))+"<br>");
 //BA.debugLineNum = 189;BA.debugLine="str_web1.Append(\"بیمه تامین اجتماعی : %\"&myfunc.e";
mostCurrent._str_web1.Append("بیمه تامین اجتماعی : %"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_bime_tamin))+"<br>");
 //BA.debugLineNum = 190;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(9)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (9)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_takmil))+"<br>");
 //BA.debugLineNum = 191;BA.debugLine="str_web1.Append(\" مالیات : مطابق قانون کار<br>\")";
mostCurrent._str_web1.Append(" مالیات : مطابق قانون کار<br>");
 //BA.debugLineNum = 192;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(10)&\" : \"&myf";
mostCurrent._str_web1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (10)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya))+"<br>");
 //BA.debugLineNum = 193;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(11)&\" : \"&myf";
mostCurrent._str_web1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (11)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat))+"</td>");
 //BA.debugLineNum = 194;BA.debugLine="str_web1.Append(\"</tr></table>\")";
mostCurrent._str_web1.Append("</tr></table>");
 //BA.debugLineNum = 195;BA.debugLine="str_web1.Append(\"</body></html>\")";
mostCurrent._str_web1.Append("</body></html>");
 //BA.debugLineNum = 197;BA.debugLine="WebView1.LoadHtml(str_web1)";
mostCurrent._webview1.LoadHtml(BA.ObjectToString(mostCurrent._str_web1));
 //BA.debugLineNum = 202;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
 //BA.debugLineNum = 203;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
 //BA.debugLineNum = 205;BA.debugLine="lbl_date_from.Text=myfunc.fa2en(Main.persianDate.";
mostCurrent._lbl_date_from.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear()))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth())-1)))))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianDay())))))));
 //BA.debugLineNum = 206;BA.debugLine="lbl_date_to.Text=myfunc.fa2en(Main.persianDate.Pe";
mostCurrent._lbl_date_to.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear()))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth())))))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianDay())))))));
 //BA.debugLineNum = 212;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
 //BA.debugLineNum = 215;BA.debugLine="et_time_inDB";
_et_time_indb();
 //BA.debugLineNum = 217;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
 //BA.debugLineNum = 218;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
 //BA.debugLineNum = 223;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 372;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 373;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 374;BA.debugLine="If(pan_mohasebat.Visible=True)Then";
if ((mostCurrent._pan_mohasebat.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 375;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
mostCurrent._pan_mohasebat.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 377;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 //BA.debugLineNum = 380;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 382;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 384;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 361;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 363;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 357;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 359;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari() throws Exception{
 //BA.debugLineNum = 255;BA.debugLine="Sub calc_vahed_ezafekari";
 //BA.debugLineNum = 257;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
 //BA.debugLineNum = 260;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
 //BA.debugLineNum = 263;BA.debugLine="vahed_ezafekari=((paye+sanavat)/220)*1.4";
_vahed_ezafekari = (int) ((((double)(Double.parseDouble(mostCurrent._paye))+_sanavat)/(double)220)*1.4);
 //BA.debugLineNum = 267;BA.debugLine="et_vahed_ezafekari.Tag=vahed_ezafekari";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_vahed_ezafekari));
 //BA.debugLineNum = 268;BA.debugLine="et_vahed_ezafekari.Text=myfunc.show_num_pool(vahe";
mostCurrent._et_vahed_ezafekari.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari)));
 //BA.debugLineNum = 271;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari_vij() throws Exception{
 //BA.debugLineNum = 273;BA.debugLine="Sub calc_vahed_ezafekari_vij";
 //BA.debugLineNum = 275;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
 //BA.debugLineNum = 278;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
 //BA.debugLineNum = 281;BA.debugLine="vahed_ezafekari_vij=((paye+sanavat)/220)*1.8";
_vahed_ezafekari_vij = (int) ((((double)(Double.parseDouble(mostCurrent._paye))+_sanavat)/(double)220)*1.8);
 //BA.debugLineNum = 285;BA.debugLine="et_vahed_ezafekari_vij.Tag=vahed_ezafekari_vij";
mostCurrent._et_vahed_ezafekari_vij.setTag((Object)(_vahed_ezafekari_vij));
 //BA.debugLineNum = 286;BA.debugLine="et_vahed_ezafekari_vij.Text=myfunc.show_num_pool(";
mostCurrent._et_vahed_ezafekari_vij.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari_vij)));
 //BA.debugLineNum = 288;BA.debugLine="End Sub";
return "";
}
public static boolean  _check_date_iscorrect() throws Exception{
int _y1_shamsi = 0;
int _m1_shamsi = 0;
int _d1_shamsi = 0;
int _y2_shamsi = 0;
int _m2_shamsi = 0;
int _d2_shamsi = 0;
int _rozzzz = 0;
boolean _check_date = false;
int _mah1 = 0;
 //BA.debugLineNum = 1173;BA.debugLine="Sub check_date_iscorrect As Boolean";
 //BA.debugLineNum = 1175;BA.debugLine="Dim y1_shamsi As Int =myfunc.fa2en( lbl_date_from";
_y1_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (0),(int) (4)))));
 //BA.debugLineNum = 1176;BA.debugLine="Dim m1_shamsi As Int =myfunc.fa2en(lbl_date_from.";
_m1_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (5),(int) (7)))));
 //BA.debugLineNum = 1177;BA.debugLine="Dim d1_shamsi As Int =myfunc.fa2en(lbl_date_from.";
_d1_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (8),(int) (10)))));
 //BA.debugLineNum = 1180;BA.debugLine="Dim y2_shamsi As Int =myfunc.fa2en(lbl_date_to.Te";
_y2_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (0),(int) (4)))));
 //BA.debugLineNum = 1181;BA.debugLine="Dim m2_shamsi As Int =myfunc.fa2en(lbl_date_to.Te";
_m2_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (5),(int) (7)))));
 //BA.debugLineNum = 1182;BA.debugLine="Dim d2_shamsi As Int =myfunc.fa2en(lbl_date_to.Te";
_d2_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (8),(int) (10)))));
 //BA.debugLineNum = 1185;BA.debugLine="Dim rozzzz As Int=0";
_rozzzz = (int) (0);
 //BA.debugLineNum = 1186;BA.debugLine="Dim check_date As Boolean = True";
_check_date = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 1188;BA.debugLine="Dim mah1 As Int=count_mah(m1_shamsi)";
_mah1 = _count_mah(_m1_shamsi);
 //BA.debugLineNum = 1193;BA.debugLine="If(m2_shamsi-m1_shamsi)=0 Then";
if ((_m2_shamsi-_m1_shamsi)==0) { 
 //BA.debugLineNum = 1194;BA.debugLine="rozzzz=d2_shamsi-d1_shamsi";
_rozzzz = (int) (_d2_shamsi-_d1_shamsi);
 //BA.debugLineNum = 1195;BA.debugLine="If(y2_shamsi-y1_shamsi <> 0) Then";
if ((_y2_shamsi-_y1_shamsi!=0)) { 
 //BA.debugLineNum = 1196;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else if((_m2_shamsi-_m1_shamsi)==1) { 
 //BA.debugLineNum = 1199;BA.debugLine="rozzzz=(mah1-d1_shamsi) + (d2_shamsi)";
_rozzzz = (int) ((_mah1-_d1_shamsi)+(_d2_shamsi));
 //BA.debugLineNum = 1201;BA.debugLine="If(y2_shamsi-y1_shamsi <> 0) Then";
if ((_y2_shamsi-_y1_shamsi!=0)) { 
 //BA.debugLineNum = 1202;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else if(((_m2_shamsi-_m1_shamsi)==-11)) { 
 //BA.debugLineNum = 1206;BA.debugLine="rozzzz=(mah1-d1_shamsi) + (d2_shamsi)";
_rozzzz = (int) ((_mah1-_d1_shamsi)+(_d2_shamsi));
 //BA.debugLineNum = 1207;BA.debugLine="If(y2_shamsi-y1_shamsi <> 0) Then";
if ((_y2_shamsi-_y1_shamsi!=0)) { 
 //BA.debugLineNum = 1208;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else if(((_m2_shamsi-_m1_shamsi)>-11 && (_m2_shamsi-_m1_shamsi)<0)) { 
 //BA.debugLineNum = 1211;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 }else {
 //BA.debugLineNum = 1213;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1217;BA.debugLine="If(check_date=True)Then";
if ((_check_date==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 1218;BA.debugLine="If(rozzzz>31)Then";
if ((_rozzzz>31)) { 
 //BA.debugLineNum = 1219;BA.debugLine="ToastMessageShow(\"تاریخ را اصلاح کنید - حداکثر";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تاریخ را اصلاح کنید - حداکثر 31 روز باشد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1220;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else {
 //BA.debugLineNum = 1223;BA.debugLine="ToastMessageShow(\"تاریخ را اصلاح کنید - حداکثر 3";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تاریخ را اصلاح کنید - حداکثر 31 روز باشد"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 1227;BA.debugLine="Return check_date";
if (true) return _check_date;
 //BA.debugLineNum = 1228;BA.debugLine="End Sub";
return false;
}
public static int  _count_mah(int _adad_mah) throws Exception{
int _res = 0;
 //BA.debugLineNum = 1161;BA.debugLine="Sub count_mah (adad_mah As Int) As Int";
 //BA.debugLineNum = 1162;BA.debugLine="Dim res As Int=0";
_res = (int) (0);
 //BA.debugLineNum = 1163;BA.debugLine="If(adad_mah<7)Then";
if ((_adad_mah<7)) { 
 //BA.debugLineNum = 1164;BA.debugLine="res=31";
_res = (int) (31);
 }else {
 //BA.debugLineNum = 1166;BA.debugLine="res=30";
_res = (int) (30);
 };
 //BA.debugLineNum = 1169;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 1171;BA.debugLine="End Sub";
return 0;
}
public static String  _et_time_indb() throws Exception{
anywheresoftware.b4a.objects.collections.List _list_ezafekari1 = null;
anywheresoftware.b4a.objects.collections.List _list_ezafekari2 = null;
 //BA.debugLineNum = 314;BA.debugLine="Sub et_time_inDB";
 //BA.debugLineNum = 317;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
mostCurrent._moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
 //BA.debugLineNum = 320;BA.debugLine="Dim list_ezafekari1 As List";
_list_ezafekari1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 321;BA.debugLine="list_ezafekari1.Initialize";
_list_ezafekari1.Initialize();
 //BA.debugLineNum = 324;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
 //BA.debugLineNum = 325;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_mah(myfunc.";
_list_ezafekari1 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._moon_num),(int) (2));
 }else {
 //BA.debugLineNum = 327;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_byDate(myfu";
_list_ezafekari1 = mostCurrent._dbcode._all_ezafekari_bydate /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText()),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._date2_fixed),(int) (2));
 };
 //BA.debugLineNum = 330;BA.debugLine="et_time_h.Text=list_ezafekari1.Get(0)";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (0))));
 //BA.debugLineNum = 331;BA.debugLine="et_time_m.Text=list_ezafekari1.Get(1)";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (1))));
 //BA.debugLineNum = 334;BA.debugLine="Dim list_ezafekari2 As List";
_list_ezafekari2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 335;BA.debugLine="list_ezafekari2.Initialize";
_list_ezafekari2.Initialize();
 //BA.debugLineNum = 338;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
 //BA.debugLineNum = 339;BA.debugLine="list_ezafekari2=dbCode.all_ezafekari_mah(sp_year";
_list_ezafekari2 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num,(int) (3));
 }else {
 //BA.debugLineNum = 341;BA.debugLine="list_ezafekari2=dbCode.all_ezafekari_byDate(myfu";
_list_ezafekari2 = mostCurrent._dbcode._all_ezafekari_bydate /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText()),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._date2_fixed),(int) (3));
 };
 //BA.debugLineNum = 344;BA.debugLine="et_time_h_vij.Text=list_ezafekari2.Get(0)";
mostCurrent._et_time_h_vij.setText(BA.ObjectToCharSequence(_list_ezafekari2.Get((int) (0))));
 //BA.debugLineNum = 345;BA.debugLine="et_time_m_vij.Text=list_ezafekari2.Get(1)";
mostCurrent._et_time_m_vij.setText(BA.ObjectToCharSequence(_list_ezafekari2.Get((int) (1))));
 //BA.debugLineNum = 348;BA.debugLine="If(moon_num<7)Then";
if (((double)(Double.parseDouble(mostCurrent._moon_num))<7)) { 
 //BA.debugLineNum = 349;BA.debugLine="roze_kari=31";
_roze_kari = (int) (31);
 }else {
 //BA.debugLineNum = 351;BA.debugLine="roze_kari=30";
_roze_kari = (int) (30);
 };
 //BA.debugLineNum = 355;BA.debugLine="et_rozekari.Text=roze_kari";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(_roze_kari));
 //BA.debugLineNum = 356;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 292;BA.debugLine="Private Sub et_vahed_ezafekari_TextChanged (Old As";
 //BA.debugLineNum = 293;BA.debugLine="et_vahed_ezafekari.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_new.replace(",","")));
 //BA.debugLineNum = 294;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari);
 //BA.debugLineNum = 295;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_vij_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 297;BA.debugLine="Private Sub et_vahed_ezafekari_vij_TextChanged (Ol";
 //BA.debugLineNum = 298;BA.debugLine="et_vahed_ezafekari_vij.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari_vij.setTag((Object)(_new.replace(",","")));
 //BA.debugLineNum = 299;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari_vij);
 //BA.debugLineNum = 300;BA.debugLine="End Sub";
return "";
}
public static String  _fix_date2_decreceone() throws Exception{
int _y_date2 = 0;
int _m_date2 = 0;
int _d_date2 = 0;
 //BA.debugLineNum = 225;BA.debugLine="Sub fix_date2_decreceOne";
 //BA.debugLineNum = 228;BA.debugLine="Dim y_date2 As Int =myfunc.fa2en( lbl_date_to.Tex";
_y_date2 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (0),(int) (4)))));
 //BA.debugLineNum = 229;BA.debugLine="Dim m_date2 As Int =myfunc.fa2en(lbl_date_to.Text";
_m_date2 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (5),(int) (7)))));
 //BA.debugLineNum = 230;BA.debugLine="Dim d_date2 As Int =myfunc.fa2en(lbl_date_to.Text";
_d_date2 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (8),(int) (10)))));
 //BA.debugLineNum = 232;BA.debugLine="If(d_date2-1=0)Then";
if ((_d_date2-1==0)) { 
 //BA.debugLineNum = 235;BA.debugLine="If(m_date2-1=0)Then";
if ((_m_date2-1==0)) { 
 //BA.debugLineNum = 236;BA.debugLine="d_date2=29";
_d_date2 = (int) (29);
 //BA.debugLineNum = 237;BA.debugLine="m_date2=12";
_m_date2 = (int) (12);
 //BA.debugLineNum = 238;BA.debugLine="y_date2=y_date2-1";
_y_date2 = (int) (_y_date2-1);
 }else {
 //BA.debugLineNum = 240;BA.debugLine="d_date2=count_mah(m_date2-1)";
_d_date2 = _count_mah((int) (_m_date2-1));
 //BA.debugLineNum = 241;BA.debugLine="m_date2=m_date2-1";
_m_date2 = (int) (_m_date2-1);
 };
 }else {
 //BA.debugLineNum = 246;BA.debugLine="d_date2=d_date2-1";
_d_date2 = (int) (_d_date2-1);
 };
 //BA.debugLineNum = 250;BA.debugLine="date2_fixed=y_date2&\"/\"&myfunc.convert_adad(m_dat";
mostCurrent._date2_fixed = BA.NumberToString(_y_date2)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_m_date2)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_d_date2);
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return "";
}
public static String  _get_data_hogogi() throws Exception{
 //BA.debugLineNum = 386;BA.debugLine="Sub get_data_hogogi";
 //BA.debugLineNum = 388;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 389;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
 //BA.debugLineNum = 391;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 392;BA.debugLine="paye=dbCode.res.GetString(\"value\")";
mostCurrent._paye = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value");
 //BA.debugLineNum = 394;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (1));
 //BA.debugLineNum = 395;BA.debugLine="maskan=dbCode.res.GetString(\"value\")";
_maskan = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 397;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (3));
 //BA.debugLineNum = 398;BA.debugLine="olad=dbCode.res.GetString(\"value\")";
_olad = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 400;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (4));
 //BA.debugLineNum = 401;BA.debugLine="fani=dbCode.res.GetString(\"value\")";
_fani = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 403;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (5));
 //BA.debugLineNum = 404;BA.debugLine="masoliat=dbCode.res.GetString(\"value\")";
_masoliat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 406;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (2));
 //BA.debugLineNum = 407;BA.debugLine="bon=dbCode.res.GetString(\"value\")";
_bon = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 409;BA.debugLine="dbCode.res.Position=6 ''--------bime_tamin------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (6));
 //BA.debugLineNum = 410;BA.debugLine="bime_tamin=dbCode.res.GetString(\"value\")";
_bime_tamin = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 412;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (11));
 //BA.debugLineNum = 413;BA.debugLine="bime_takmil=dbCode.res.GetString(\"value\")";
_bime_takmil = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 421;BA.debugLine="dbCode.res.Position=13 ''--------hag shift------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (13));
 //BA.debugLineNum = 422;BA.debugLine="shift=dbCode.res.GetString(\"value\")";
_shift = (double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 424;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (14));
 //BA.debugLineNum = 425;BA.debugLine="sanavat=dbCode.res.GetString(\"value\")";
_sanavat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 427;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (15));
 //BA.debugLineNum = 428;BA.debugLine="sarparasti=dbCode.res.GetString(\"value\")";
_sarparasti = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 430;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (16));
 //BA.debugLineNum = 431;BA.debugLine="mazaya=dbCode.res.GetString(\"value\")";
_mazaya = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 433;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (19));
 //BA.debugLineNum = 434;BA.debugLine="ksorat=dbCode.res.GetString(\"value\")";
_ksorat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 444;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 445;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 449;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim paye As String";
mostCurrent._paye = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim maskan As Int";
_maskan = 0;
 //BA.debugLineNum = 17;BA.debugLine="Dim olad As Int";
_olad = 0;
 //BA.debugLineNum = 18;BA.debugLine="Dim fani As Int";
_fani = 0;
 //BA.debugLineNum = 19;BA.debugLine="Dim masoliat As Int";
_masoliat = 0;
 //BA.debugLineNum = 20;BA.debugLine="Dim bon As Int";
_bon = 0;
 //BA.debugLineNum = 21;BA.debugLine="Dim bime_tamin As Int";
_bime_tamin = 0;
 //BA.debugLineNum = 22;BA.debugLine="Dim bime_takmil As Int";
_bime_takmil = 0;
 //BA.debugLineNum = 24;BA.debugLine="Dim roze_kari As Int";
_roze_kari = 0;
 //BA.debugLineNum = 26;BA.debugLine="Dim sarparasti As Int";
_sarparasti = 0;
 //BA.debugLineNum = 27;BA.debugLine="Dim sanavat As Int";
_sanavat = 0;
 //BA.debugLineNum = 28;BA.debugLine="Dim mazaya As Int";
_mazaya = 0;
 //BA.debugLineNum = 29;BA.debugLine="Dim ksorat As Int";
_ksorat = 0;
 //BA.debugLineNum = 30;BA.debugLine="Dim shift As Double";
_shift = 0;
 //BA.debugLineNum = 35;BA.debugLine="Dim str1 As StringBuilder";
mostCurrent._str1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private et_time_h As EditText";
mostCurrent._et_time_h = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private et_time_m As EditText";
mostCurrent._et_time_m = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private WebView1 As WebView";
mostCurrent._webview1 = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private WebView2 As WebView";
mostCurrent._webview2 = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Dim paye_end As Int";
_paye_end = 0;
 //BA.debugLineNum = 47;BA.debugLine="Dim vahed_ezafekari As Int";
_vahed_ezafekari = 0;
 //BA.debugLineNum = 48;BA.debugLine="Dim ezafekari_end As Int";
_ezafekari_end = 0;
 //BA.debugLineNum = 49;BA.debugLine="Dim bime_tamin_end As Int";
_bime_tamin_end = 0;
 //BA.debugLineNum = 50;BA.debugLine="Dim shift_end As Int";
_shift_end = 0;
 //BA.debugLineNum = 51;BA.debugLine="Dim maliat_end As Int";
_maliat_end = 0;
 //BA.debugLineNum = 52;BA.debugLine="Dim maskan_end As Int";
_maskan_end = 0;
 //BA.debugLineNum = 53;BA.debugLine="Dim sanavat_end As Int";
_sanavat_end = 0;
 //BA.debugLineNum = 54;BA.debugLine="Dim olad_end As Int";
_olad_end = 0;
 //BA.debugLineNum = 55;BA.debugLine="Dim fani_end As Int";
_fani_end = 0;
 //BA.debugLineNum = 56;BA.debugLine="Dim bon_end As Int";
_bon_end = 0;
 //BA.debugLineNum = 57;BA.debugLine="Dim masoliat_end As Int";
_masoliat_end = 0;
 //BA.debugLineNum = 58;BA.debugLine="Dim sarparasti_end As Int";
_sarparasti_end = 0;
 //BA.debugLineNum = 59;BA.debugLine="Dim mazaya_end As Int";
_mazaya_end = 0;
 //BA.debugLineNum = 62;BA.debugLine="Dim vahed_ezafekari_vij As Int";
_vahed_ezafekari_vij = 0;
 //BA.debugLineNum = 63;BA.debugLine="Dim ezafekari_end_vij As Int";
_ezafekari_end_vij = 0;
 //BA.debugLineNum = 65;BA.debugLine="Dim hogog_nakhales As Int";
_hogog_nakhales = 0;
 //BA.debugLineNum = 66;BA.debugLine="Dim hogog_khales As Int";
_hogog_khales = 0;
 //BA.debugLineNum = 67;BA.debugLine="Dim jame_kosorat As Int";
_jame_kosorat = 0;
 //BA.debugLineNum = 69;BA.debugLine="Private sp_year As Spinner";
mostCurrent._sp_year = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 70;BA.debugLine="Private sp_moon As Spinner";
mostCurrent._sp_moon = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 72;BA.debugLine="Dim moon_num As String= \"00\"";
mostCurrent._moon_num = "00";
 //BA.debugLineNum = 73;BA.debugLine="Private pan_mohasebat As Panel";
mostCurrent._pan_mohasebat = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 74;BA.debugLine="Private et_rozekari As EditText";
mostCurrent._et_rozekari = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 76;BA.debugLine="Dim str_web1 As StringBuilder";
mostCurrent._str_web1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 79;BA.debugLine="Private et_name_gozaresh As EditText";
mostCurrent._et_name_gozaresh = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 80;BA.debugLine="Private et_tozih_gozaresh As EditText";
mostCurrent._et_tozih_gozaresh = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 81;BA.debugLine="Private pan_all As Panel";
mostCurrent._pan_all = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 82;BA.debugLine="Private pan_load As Panel";
mostCurrent._pan_load = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 83;BA.debugLine="Private B4XLoadingIndicator1 As B4XLoadingIndicat";
mostCurrent._b4xloadingindicator1 = new ir.taravatgroup.ezafekari2.b4xloadingindicator();
 //BA.debugLineNum = 84;BA.debugLine="Private scv_hogog As ScrollView";
mostCurrent._scv_hogog = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 85;BA.debugLine="Private et_vahed_ezafekari As EditText";
mostCurrent._et_vahed_ezafekari = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 88;BA.debugLine="Private pan_hed_hogog As Panel";
mostCurrent._pan_hed_hogog = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 90;BA.debugLine="Private pan_main_hed_hogog As Panel";
mostCurrent._pan_main_hed_hogog = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 91;BA.debugLine="Private pan_hed_gozaresh As Panel";
mostCurrent._pan_hed_gozaresh = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 92;BA.debugLine="Private et_vahed_ezafekari_vij As EditText";
mostCurrent._et_vahed_ezafekari_vij = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 93;BA.debugLine="Private et_time_h_vij As EditText";
mostCurrent._et_time_h_vij = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 94;BA.debugLine="Private et_time_m_vij As EditText";
mostCurrent._et_time_m_vij = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 95;BA.debugLine="Dim ls_onvanHa As List";
mostCurrent._ls_onvanha = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 97;BA.debugLine="Private printer As Printer";
mostCurrent._printer = new anywheresoftware.b4a.objects.PdfDocumentWrapper.Printer();
 //BA.debugLineNum = 98;BA.debugLine="Private radio_type1 As RadioButton";
mostCurrent._radio_type1 = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 99;BA.debugLine="Private radio_type2 As RadioButton";
mostCurrent._radio_type2 = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 100;BA.debugLine="Private lbl_date_to As Label";
mostCurrent._lbl_date_to = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 101;BA.debugLine="Private lbl_date_from As Label";
mostCurrent._lbl_date_from = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 102;BA.debugLine="Private pan_all_set_date As Panel";
mostCurrent._pan_all_set_date = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 103;BA.debugLine="Private pik_year1 As Label";
mostCurrent._pik_year1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 104;BA.debugLine="Private pik_moon1 As Label";
mostCurrent._pik_moon1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 105;BA.debugLine="Private pik_day1 As Label";
mostCurrent._pik_day1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 108;BA.debugLine="Dim num_dataPik As Int=0  '' for time picker";
_num_datapik = (int) (0);
 //BA.debugLineNum = 109;BA.debugLine="Dim moon_dataPik As List  '' for date picker";
mostCurrent._moon_datapik = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 110;BA.debugLine="Dim index_datePik As Int";
_index_datepik = 0;
 //BA.debugLineNum = 111;BA.debugLine="Dim type_mohasebe As Int=1";
_type_mohasebe = (int) (1);
 //BA.debugLineNum = 114;BA.debugLine="Dim mosaedeh_all As Int=0";
_mosaedeh_all = (int) (0);
 //BA.debugLineNum = 115;BA.debugLine="Dim food_all As Int=0";
_food_all = (int) (0);
 //BA.debugLineNum = 116;BA.debugLine="Dim padash_all As Int=0";
_padash_all = (int) (0);
 //BA.debugLineNum = 117;BA.debugLine="Dim sayer_1_all As Int=0";
_sayer_1_all = (int) (0);
 //BA.debugLineNum = 118;BA.debugLine="Dim sayer_2_all As Int=0";
_sayer_2_all = (int) (0);
 //BA.debugLineNum = 120;BA.debugLine="Dim ayab_1_all As Int=0";
_ayab_1_all = (int) (0);
 //BA.debugLineNum = 121;BA.debugLine="Dim ayab_2_all As Int=0";
_ayab_2_all = (int) (0);
 //BA.debugLineNum = 123;BA.debugLine="Dim gest_vam As Int=0";
_gest_vam = (int) (0);
 //BA.debugLineNum = 124;BA.debugLine="Dim date2_fixed As String";
mostCurrent._date2_fixed = "";
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 366;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 367;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 368;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 369;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_backto_hogog_click() throws Exception{
 //BA.debugLineNum = 1026;BA.debugLine="Private Sub lbl_backTo_hogog_Click";
 //BA.debugLineNum = 1028;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
mostCurrent._pan_mohasebat.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1029;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_from_click() throws Exception{
 //BA.debugLineNum = 1113;BA.debugLine="Private Sub lbl_date_from_Click";
 //BA.debugLineNum = 1114;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1115;BA.debugLine="index_datePik=1";
_index_datepik = (int) (1);
 //BA.debugLineNum = 1117;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_from.Text.Su";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (0),(int) (4)))));
 //BA.debugLineNum = 1118;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_from.Text.Sub";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (5),(int) (7)))));
 //BA.debugLineNum = 1119;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 1120;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_from.Text.Sub";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (8),(int) (10)))));
 //BA.debugLineNum = 1124;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_to_click() throws Exception{
 //BA.debugLineNum = 1126;BA.debugLine="Private Sub lbl_date_to_Click";
 //BA.debugLineNum = 1127;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1128;BA.debugLine="index_datePik=2";
_index_datepik = (int) (2);
 //BA.debugLineNum = 1130;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_to.Text.SubS";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (0),(int) (4)))));
 //BA.debugLineNum = 1131;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_to.Text.SubSt";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (5),(int) (7)))));
 //BA.debugLineNum = 1132;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 1133;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_to.Text.SubSt";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (8),(int) (10)))));
 //BA.debugLineNum = 1136;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_tatil_click() throws Exception{
 //BA.debugLineNum = 1059;BA.debugLine="Private Sub lbl_help_tatil_Click";
 //BA.debugLineNum = 1061;BA.debugLine="myfunc.help_man(\"راهنما\",\"روزهای جمعه که برای آن";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","روزهای جمعه که برای آن روز دیگری را تعطیل نکنند، اضافه کاری فوق العاده محسوب و با ضریب 1.8 محاسبه می شود.");
 //BA.debugLineNum = 1062;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_print_click() throws Exception{
 //BA.debugLineNum = 1084;BA.debugLine="Private Sub lbl_print_Click";
 //BA.debugLineNum = 1086;BA.debugLine="printer.Initialize(\"\")";
mostCurrent._printer.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 1089;BA.debugLine="printer.PrintWebView(\"job\",WebView2)";
mostCurrent._printer.PrintWebView("job",(android.webkit.WebView)(mostCurrent._webview2.getObject()));
 //BA.debugLineNum = 1090;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_click() throws Exception{
 //BA.debugLineNum = 1050;BA.debugLine="Private Sub lbl_refresh_vahed_Click";
 //BA.debugLineNum = 1051;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
 //BA.debugLineNum = 1052;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_vij_click() throws Exception{
 //BA.debugLineNum = 1054;BA.debugLine="Private Sub lbl_refresh_vahed_vij_Click";
 //BA.debugLineNum = 1055;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
 //BA.debugLineNum = 1056;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run_mohasebe_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _list_morakhasi = null;
 //BA.debugLineNum = 452;BA.debugLine="Private Sub lbl_run_mohasebe_Click";
 //BA.debugLineNum = 453;BA.debugLine="If(et_rozekari.Text=\"\")Then";
if (((mostCurrent._et_rozekari.getText()).equals(""))) { 
 //BA.debugLineNum = 454;BA.debugLine="et_rozekari.Text=0";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 457;BA.debugLine="roze_kari=et_rozekari.Text";
_roze_kari = (int)(Double.parseDouble(mostCurrent._et_rozekari.getText()));
 //BA.debugLineNum = 459;BA.debugLine="If(et_time_h.Text=\"\")Then";
if (((mostCurrent._et_time_h.getText()).equals(""))) { 
 //BA.debugLineNum = 460;BA.debugLine="et_time_h.Text=0";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 462;BA.debugLine="If(et_time_m.Text=\"\")Then";
if (((mostCurrent._et_time_m.getText()).equals(""))) { 
 //BA.debugLineNum = 463;BA.debugLine="et_time_m.Text=0";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 466;BA.debugLine="If(et_time_h_vij.Text=\"\")Then";
if (((mostCurrent._et_time_h_vij.getText()).equals(""))) { 
 //BA.debugLineNum = 467;BA.debugLine="et_time_h_vij.Text=0";
mostCurrent._et_time_h_vij.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 469;BA.debugLine="If(et_time_m_vij.Text=\"\")Then";
if (((mostCurrent._et_time_m_vij.getText()).equals(""))) { 
 //BA.debugLineNum = 470;BA.debugLine="et_time_m_vij.Text=0";
mostCurrent._et_time_m_vij.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 475;BA.debugLine="If(et_vahed_ezafekari.Text=\"\")Then";
if (((mostCurrent._et_vahed_ezafekari.getText()).equals(""))) { 
 //BA.debugLineNum = 476;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
 };
 //BA.debugLineNum = 478;BA.debugLine="If(et_vahed_ezafekari_vij.Text=\"\")Then";
if (((mostCurrent._et_vahed_ezafekari_vij.getText()).equals(""))) { 
 //BA.debugLineNum = 479;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
 };
 //BA.debugLineNum = 483;BA.debugLine="If (roze_kari > 31 Or roze_kari < 0)Then";
if ((_roze_kari>31 || _roze_kari<0)) { 
 //BA.debugLineNum = 484;BA.debugLine="ToastMessageShow(\" تعداد روز کاری نادرست است\",Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" تعداد روز کاری نادرست است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 486;BA.debugLine="If(check_date_iscorrect=True)Then";
if ((_check_date_iscorrect()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 487;BA.debugLine="pan_mohasebat.Visible=True";
mostCurrent._pan_mohasebat.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 488;BA.debugLine="pan_mohasebat.SetLayoutAnimated(100,0,0,100%x,10";
mostCurrent._pan_mohasebat.SetLayoutAnimated((int) (100),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 489;BA.debugLine="mohasebe";
_mohasebe();
 //BA.debugLineNum = 494;BA.debugLine="str1.Initialize";
mostCurrent._str1.Initialize();
 //BA.debugLineNum = 496;BA.debugLine="str1.Append(\"<!DOCTYPE html><html dir='rtl' lang";
mostCurrent._str1.Append("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>");
 //BA.debugLineNum = 497;BA.debugLine="str1.Append(\"<style>table , td {border: 1px soli";
mostCurrent._str1.Append("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	summary {	font-weight: bold;	margin: -.5em -.5em 0;	padding: .5em;} details[open] {	padding: .5em;	}	details[open] summary {border-bottom: 1px solid #aaa;margin-bottom: .5em;}</style>");
 //BA.debugLineNum = 501;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 502;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
 //BA.debugLineNum = 503;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+mostCurrent._sp_year.getSelectedItem()+"/"+mostCurrent._moon_num+"%';")));
 //BA.debugLineNum = 504;BA.debugLine="str1.Append(\"<h3>\").Append(\"گزارش \"& sp_moon.Se";
mostCurrent._str1.Append("<h3>").Append("گزارش "+mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())).Append("</h3>");
 }else {
 //BA.debugLineNum = 506;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FRO";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+mostCurrent._lbl_date_from.getText()+"' AND '"+mostCurrent._date2_fixed+"' ;")));
 //BA.debugLineNum = 507;BA.debugLine="str1.Append(\"<h3>\").Append(\"گزارش از تاریخ \").";
mostCurrent._str1.Append("<h3>").Append("گزارش از تاریخ ").Append(mostCurrent._lbl_date_from.getText()).Append(" تا ").Append(mostCurrent._date2_fixed).Append("</h3>");
 };
 //BA.debugLineNum = 516;BA.debugLine="str1.Append(\"نام کاربر :\").Append(\"<span> \"&Main";
mostCurrent._str1.Append("نام کاربر :").Append("<span> "+mostCurrent._main._user_namefamili /*String*/ +"</span>").Append("<br>");
 //BA.debugLineNum = 518;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5;'><details>");
 //BA.debugLineNum = 520;BA.debugLine="str1.Append(\"<summary><b> اضافه کاری های این ماه";
mostCurrent._str1.Append("<summary><b> اضافه کاری های این ماه</b></summary>");
 //BA.debugLineNum = 521;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr styl";
mostCurrent._str1.Append("<table style='width:100%;'><tr style='text-align: center;'>");
 //BA.debugLineNum = 522;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ<";
mostCurrent._str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td><br></tr>");
 //BA.debugLineNum = 524;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 525;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
mostCurrent._str1.Append("<tr style='text-align: center;'>");
 //BA.debugLineNum = 526;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
 //BA.debugLineNum = 527;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
 //BA.debugLineNum = 528;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
 //BA.debugLineNum = 530;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
 //BA.debugLineNum = 531;BA.debugLine="str1.Append(myfunc.en2fa((dbCode.res.GetString(";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(((double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")))+((double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")))*24)))));
 //BA.debugLineNum = 532;BA.debugLine="str1.Append(\":\")";
mostCurrent._str1.Append(":");
 //BA.debugLineNum = 533;BA.debugLine="str1.Append(myfunc.en2fa(dbCode.res.GetString(\"";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))).Append("</td>");
 //BA.debugLineNum = 535;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
 }
;
 //BA.debugLineNum = 538;BA.debugLine="str1.Append(\"</table>\")";
mostCurrent._str1.Append("</table>");
 //BA.debugLineNum = 539;BA.debugLine="str1.Append(\"مجموع ساعت اضافه کاری :<span style=";
mostCurrent._str1.Append("مجموع ساعت اضافه کاری :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h.getText())+" ساعت و"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m.getText())+"دقیقه </span><br></details></div><br> ");
 //BA.debugLineNum = 547;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
 //BA.debugLineNum = 548;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+mostCurrent._sp_year.getSelectedItem()+"/"+mostCurrent._moon_num+"%';")));
 }else {
 //BA.debugLineNum = 550;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from BETWEEN '"+mostCurrent._lbl_date_from.getText()+"' AND '"+mostCurrent._lbl_date_to.getText()+"' ;")));
 };
 //BA.debugLineNum = 554;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5 ;'><details>");
 //BA.debugLineNum = 555;BA.debugLine="str1.Append(\"<summary><b> مرخصی های این ماه</b><";
mostCurrent._str1.Append("<summary><b> مرخصی های این ماه</b></summary>");
 //BA.debugLineNum = 556;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr styl";
mostCurrent._str1.Append("<table style='width:100%;'><tr style='text-align: center;'>");
 //BA.debugLineNum = 557;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ<";
mostCurrent._str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b>زمان/روز</b></td><td><b> زمان/ساعت</b></td><br></tr>");
 //BA.debugLineNum = 559;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 560;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
mostCurrent._str1.Append("<tr style='text-align: center;'>");
 //BA.debugLineNum = 561;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
 //BA.debugLineNum = 562;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
 //BA.debugLineNum = 563;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
 //BA.debugLineNum = 564;BA.debugLine="str1.Append(\"<td>\").Append((myfunc.en2fa(dbCode";
mostCurrent._str1.Append("<td>").Append((mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")))).Append("</td>");
 //BA.debugLineNum = 565;BA.debugLine="str1.Append(\"<td>\").Append((myfunc.en2fa(dbCode";
mostCurrent._str1.Append("<td>").Append((mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")))+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))).Append("</td>");
 //BA.debugLineNum = 567;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
 }
;
 //BA.debugLineNum = 572;BA.debugLine="str1.Append(\"</table>\")";
mostCurrent._str1.Append("</table>");
 //BA.debugLineNum = 574;BA.debugLine="Dim list_morakhasi As List";
_list_morakhasi = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 575;BA.debugLine="list_morakhasi.Initialize";
_list_morakhasi.Initialize();
 //BA.debugLineNum = 577;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
 //BA.debugLineNum = 578;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(sp_year";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num);
 }else {
 //BA.debugLineNum = 580;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_byDate(lbl_";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_bydate /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._lbl_date_to.getText());
 };
 //BA.debugLineNum = 584;BA.debugLine="str1.Append(\"مجموع مرخصی ها :<span style='color:";
mostCurrent._str1.Append("مجموع مرخصی ها :<span style='color:#5E35B1;'><b> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (0))))+" روز و "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (1))))+" ساعت و "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (2))))+" دقیقه ");
 //BA.debugLineNum = 586;BA.debugLine="str1.Append(\"</b></span><br></details></div><br>";
mostCurrent._str1.Append("</b></span><br></details></div><br>");
 //BA.debugLineNum = 592;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5 ;' ><details open>");
 //BA.debugLineNum = 593;BA.debugLine="str1.Append(\"<summary><b>محاسبه حقوق</b></summar";
mostCurrent._str1.Append("<summary><b>محاسبه حقوق</b></summary>");
 //BA.debugLineNum = 595;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr>\")";
mostCurrent._str1.Append("<table style='width:100%;'><tr>");
 //BA.debugLineNum = 596;BA.debugLine="str1.Append(\"<td><div style='text-align: center;";
mostCurrent._str1.Append("<td><div style='text-align: center;color:#661400;'><b> مزایا</b></div></td>");
 //BA.debugLineNum = 597;BA.debugLine="str1.Append(\"<td><div style='text-align: center;";
mostCurrent._str1.Append("<td><div style='text-align: center;color:#661400;'><b>کسورات</b></div></td> </tr>");
 //BA.debugLineNum = 598;BA.debugLine="str1.Append(\"<tr style='vertical-align: text-top";
mostCurrent._str1.Append("<tr style='vertical-align: text-top;'><td>");
 //BA.debugLineNum = 599;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(0)&\" برای \"&myfunc";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (0)))+" برای "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_roze_kari))+" روز کاری : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_paye_end))+"</span><br>");
 //BA.debugLineNum = 600;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(2)&\" : <span style";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (2)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maskan_end))+"</span><br>");
 //BA.debugLineNum = 601;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(3)&\" : <span styl";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (3)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bon_end))+"</span><br>");
 //BA.debugLineNum = 602;BA.debugLine="If(olad_end<>0)Then";
if ((_olad_end!=0)) { 
 //BA.debugLineNum = 603;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(4)&\"  :<span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (4)))+"  :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad_end))+"</span><br>");
 };
 //BA.debugLineNum = 605;BA.debugLine="If(sanavat_end<>0)Then";
if ((_sanavat_end!=0)) { 
 //BA.debugLineNum = 606;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(1)&\"  : <span sty";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (1)))+"  : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat_end))+"</span><br>");
 };
 //BA.debugLineNum = 608;BA.debugLine="If(fani_end<>0)Then";
if ((_fani_end!=0)) { 
 //BA.debugLineNum = 609;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(5)&\" : <span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (5)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_fani_end))+"</span><br>");
 };
 //BA.debugLineNum = 611;BA.debugLine="If(masoliat_end<>0)Then";
if ((_masoliat_end!=0)) { 
 //BA.debugLineNum = 612;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(6)&\" : <span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (6)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_masoliat_end))+"</span><br>");
 };
 //BA.debugLineNum = 614;BA.debugLine="If(sarparasti_end<>0)Then";
if ((_sarparasti_end!=0)) { 
 //BA.debugLineNum = 615;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(7)&\" : <span sty";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (7)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sarparasti_end))+"</span><br>");
 };
 //BA.debugLineNum = 617;BA.debugLine="If(shift_end<>0)Then";
if ((_shift_end!=0)) { 
 //BA.debugLineNum = 618;BA.debugLine="str1.Append(\" حق شیفت \"&myfunc.en2fa(shift)&\" د";
mostCurrent._str1.Append(" حق شیفت "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_shift))+" درصد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_shift_end))+"</span><br>");
 };
 //BA.debugLineNum = 621;BA.debugLine="If(padash_all<>0)Then";
if ((_padash_all!=0)) { 
 //BA.debugLineNum = 622;BA.debugLine="str1.Append(\"  پاداش : <span style='color:#5E3";
mostCurrent._str1.Append("  پاداش : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_padash_all))+"</span><br>");
 };
 //BA.debugLineNum = 625;BA.debugLine="If(sayer_1_all<>0)Then";
if ((_sayer_1_all!=0)) { 
 //BA.debugLineNum = 626;BA.debugLine="str1.Append(\"  سایر: <span style='color:#5E35B";
mostCurrent._str1.Append("  سایر: <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sayer_1_all))+"</span><br>");
 };
 //BA.debugLineNum = 629;BA.debugLine="If(ayab_1_all<>0)Then";
if ((_ayab_1_all!=0)) { 
 //BA.debugLineNum = 630;BA.debugLine="str1.Append(\" ایاب ذهاب: <span style='color:#5";
mostCurrent._str1.Append(" ایاب ذهاب: <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ayab_1_all))+"</span><br>");
 };
 //BA.debugLineNum = 633;BA.debugLine="If(mazaya_end<>0)Then";
if ((_mazaya_end!=0)) { 
 //BA.debugLineNum = 634;BA.debugLine="str1.Append(\"  \"&ls_onvanHa.Get(10)&\" : <span";
mostCurrent._str1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (10)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya_end))+"</span><br>");
 };
 //BA.debugLineNum = 643;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
 //BA.debugLineNum = 644;BA.debugLine="str1.Append(\"اضافه کاری عادی\").Append(\"<br>\")";
mostCurrent._str1.Append("اضافه کاری عادی").Append("<br>");
 //BA.debugLineNum = 646;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B";
mostCurrent._str1.Append(" ساعات : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h.getText())+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m.getText())+"</span><br>");
 //BA.debugLineNum = 648;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5";
mostCurrent._str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_vahed_ezafekari))+"</span><br>");
 //BA.debugLineNum = 654;BA.debugLine="If(ezafekari_end_vij<>0)Then";
if ((_ezafekari_end_vij!=0)) { 
 //BA.debugLineNum = 655;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
 //BA.debugLineNum = 657;BA.debugLine="str1.Append(\"اضافه کاری <span style='color:#ff4d";
mostCurrent._str1.Append("اضافه کاری <span style='color:#ff4d00;'>"+"فوق العاده"+"</span>").Append("<br>");
 //BA.debugLineNum = 659;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B1";
mostCurrent._str1.Append(" ساعات : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h_vij.getText())+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m_vij.getText())+"</span><br>");
 //BA.debugLineNum = 662;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5E";
mostCurrent._str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_vahed_ezafekari_vij))+"</span><br>");
 };
 //BA.debugLineNum = 666;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
 //BA.debugLineNum = 667;BA.debugLine="str1.Append(\"مجموع اضافه کاری : <span style='col";
mostCurrent._str1.Append("مجموع اضافه کاری : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool((int) (_ezafekari_end+_ezafekari_end_vij)))+"</span><br></td>");
 //BA.debugLineNum = 670;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
 //BA.debugLineNum = 671;BA.debugLine="str1.Append(\"بیمه تامین اجتماعی \"&myfunc.en2fa(s";
mostCurrent._str1.Append("بیمه تامین اجتماعی "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_tamin))+" درصد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_tamin_end))+"</span><br>");
 //BA.debugLineNum = 673;BA.debugLine="If(bime_takmil<>0)Then";
if ((_bime_takmil!=0)) { 
 //BA.debugLineNum = 674;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(9)&\" :<span style";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (9)))+" :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_takmil))+"</span><br>");
 };
 //BA.debugLineNum = 677;BA.debugLine="If(maliat_end<>0)Then";
if ((_maliat_end!=0)) { 
 //BA.debugLineNum = 678;BA.debugLine="str1.Append(\" مالیات : <span style='color:#5E35";
mostCurrent._str1.Append(" مالیات : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maliat_end))+"</span><br>");
 };
 //BA.debugLineNum = 681;BA.debugLine="If(mosaedeh_all<>0)Then";
if ((_mosaedeh_all!=0)) { 
 //BA.debugLineNum = 682;BA.debugLine="str1.Append(\" مساعده : <span style='color:#5E35";
mostCurrent._str1.Append(" مساعده : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mosaedeh_all))+"</span><br>");
 };
 //BA.debugLineNum = 685;BA.debugLine="If(food_all<>0)Then";
if ((_food_all!=0)) { 
 //BA.debugLineNum = 686;BA.debugLine="str1.Append(\" هزینه غذا : <span style='color:#";
mostCurrent._str1.Append(" هزینه غذا : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_food_all))+"</span><br>");
 };
 //BA.debugLineNum = 689;BA.debugLine="If(sayer_2_all<>0)Then";
if ((_sayer_2_all!=0)) { 
 //BA.debugLineNum = 690;BA.debugLine="str1.Append(\" سایر : <span style='color:#5E35B1";
mostCurrent._str1.Append(" سایر : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sayer_2_all))+"</span><br>");
 };
 //BA.debugLineNum = 693;BA.debugLine="If(ayab_2_all<>0)Then";
if ((_ayab_2_all!=0)) { 
 //BA.debugLineNum = 694;BA.debugLine="str1.Append(\" ایاب ذهاب : <span style='color:#5";
mostCurrent._str1.Append(" ایاب ذهاب : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ayab_2_all))+"</span><br>");
 };
 //BA.debugLineNum = 697;BA.debugLine="If(gest_vam<>0)Then";
if ((_gest_vam!=0)) { 
 //BA.debugLineNum = 698;BA.debugLine="str1.Append(\" قسط وام  : <span style='color:#5E";
mostCurrent._str1.Append(" قسط وام  : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_gest_vam))+"</span><br>");
 };
 //BA.debugLineNum = 703;BA.debugLine="If(ksorat<>0)Then";
if ((_ksorat!=0)) { 
 //BA.debugLineNum = 704;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(11)&\" : <span st";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (11)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat))+"</span></td>");
 };
 //BA.debugLineNum = 707;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
 //BA.debugLineNum = 709;BA.debugLine="str1.Append(\"<tr><td>\")";
mostCurrent._str1.Append("<tr><td>");
 //BA.debugLineNum = 710;BA.debugLine="str1.Append(\"جمع مزایا :  <span style='color:#5E";
mostCurrent._str1.Append("جمع مزایا :  <span style='color:#5E35B1;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_nakhales))+"</b></span>");
 //BA.debugLineNum = 711;BA.debugLine="str1.Append(\"</td><td>\")";
mostCurrent._str1.Append("</td><td>");
 //BA.debugLineNum = 713;BA.debugLine="str1.Append(\"جمع کسورات :  <span style='color:#5";
mostCurrent._str1.Append("جمع کسورات :  <span style='color:#5E35B1;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_jame_kosorat))+"</b></span>");
 //BA.debugLineNum = 714;BA.debugLine="str1.Append(\"</td></tr></table><br>\")";
mostCurrent._str1.Append("</td></tr></table><br>");
 //BA.debugLineNum = 716;BA.debugLine="str1.Append(\" دریافتی خالص :  <span style='color";
mostCurrent._str1.Append(" دریافتی خالص :  <span style='color:#388E3C;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_khales))+" </b></span></b>");
 //BA.debugLineNum = 717;BA.debugLine="str1.Append(\"<span style='font-size: 11px;'> توم";
mostCurrent._str1.Append("<span style='font-size: 11px;'> تومان </span>");
 //BA.debugLineNum = 719;BA.debugLine="str1.Append(\"<br></details></div>\")";
mostCurrent._str1.Append("<br></details></div>");
 //BA.debugLineNum = 721;BA.debugLine="str1.Append(\"<footer style=' text-align: center;";
mostCurrent._str1.Append("<footer style=' text-align: center; '><h6> اپلیکیشن اضافه کاری من </h6></footer>");
 //BA.debugLineNum = 723;BA.debugLine="str1.Append(\"</body></html>\")";
mostCurrent._str1.Append("</body></html>");
 //BA.debugLineNum = 725;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 726;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 731;BA.debugLine="WebView2.LoadHtml(str1.ToString)";
mostCurrent._webview2.LoadHtml(mostCurrent._str1.ToString());
 };
 };
 //BA.debugLineNum = 736;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_gozaresh_click() throws Exception{
 //BA.debugLineNum = 991;BA.debugLine="Private Sub lbl_save_gozaresh_Click";
 //BA.debugLineNum = 992;BA.debugLine="et_name_gozaresh.Text=sp_moon.SelectedItem&\" \"&sp";
mostCurrent._et_name_gozaresh.setText(BA.ObjectToCharSequence(mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._sp_year.getSelectedItem()));
 //BA.debugLineNum = 993;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 994;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_gozaresh_end_click() throws Exception{
 //BA.debugLineNum = 1035;BA.debugLine="Private Sub lbl_save_gozaresh_end_Click";
 //BA.debugLineNum = 1036;BA.debugLine="save_gozaresh";
_save_gozaresh();
 //BA.debugLineNum = 1037;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1038;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
 //BA.debugLineNum = 1144;BA.debugLine="Private Sub lbl_save_picker_Click";
 //BA.debugLineNum = 1146;BA.debugLine="If(index_datePik=1) Then";
if ((_index_datepik==1)) { 
 //BA.debugLineNum = 1147;BA.debugLine="lbl_date_from.Text=pik_year1.Text&\"/\"&myfunc.con";
mostCurrent._lbl_date_from.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 }else if((_index_datepik==2)) { 
 //BA.debugLineNum = 1150;BA.debugLine="lbl_date_to.Text=pik_year1.Text&\"/\"&myfunc.conve";
mostCurrent._lbl_date_to.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 //BA.debugLineNum = 1151;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
 };
 //BA.debugLineNum = 1154;BA.debugLine="et_time_inDB";
_et_time_indb();
 //BA.debugLineNum = 1156;BA.debugLine="et_rozekari.Text=myfunc.time_mohasebe(lbl_date_fr";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._time_mohasebe /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed)));
 //BA.debugLineNum = 1157;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1159;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_click() throws Exception{
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
 //BA.debugLineNum = 1065;BA.debugLine="Private Sub lbl_share_Click";
 //BA.debugLineNum = 1066;BA.debugLine="Dim FileName As String =Main.current_gozaresh_id&";
_filename = BA.NumberToString(mostCurrent._main._current_gozaresh_id /*int*/ )+".html";
 //BA.debugLineNum = 1069;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
anywheresoftware.b4a.keywords.Common.File.WriteString(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename,mostCurrent._str1.ToString());
 //BA.debugLineNum = 1071;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
 //BA.debugLineNum = 1072;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
 //BA.debugLineNum = 1073;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
 //BA.debugLineNum = 1074;BA.debugLine="email.Body = \" گزارش حقوق \"&str1.ToString&CRLF&\"ا";
_email.Body = " گزارش حقوق "+mostCurrent._str1.ToString()+anywheresoftware.b4a.keywords.Common.CRLF+"اپلیکیشن اضافه کاری من"+anywheresoftware.b4a.keywords.Common.CRLF+"دانلود از بازار";
 //BA.debugLineNum = 1075;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (_filename));
 //BA.debugLineNum = 1077;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
 //BA.debugLineNum = 1078;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
 //BA.debugLineNum = 1079;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 //BA.debugLineNum = 1080;BA.debugLine="End Sub";
return "";
}
public static String  _mohasebe() throws Exception{
int _nak_mal = 0;
 //BA.debugLineNum = 738;BA.debugLine="Sub mohasebe";
 //BA.debugLineNum = 742;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
 //BA.debugLineNum = 745;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
 //BA.debugLineNum = 752;BA.debugLine="If (roze_kari<30)Then";
if ((_roze_kari<30)) { 
 //BA.debugLineNum = 753;BA.debugLine="maskan_end=(maskan/30)*roze_kari";
_maskan_end = (int) ((_maskan/(double)30)*_roze_kari);
 }else {
 //BA.debugLineNum = 755;BA.debugLine="maskan_end=maskan";
_maskan_end = _maskan;
 };
 //BA.debugLineNum = 760;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
 //BA.debugLineNum = 761;BA.debugLine="bon_end=(bon/30)*roze_kari";
_bon_end = (int) ((_bon/(double)30)*_roze_kari);
 }else {
 //BA.debugLineNum = 763;BA.debugLine="bon_end=bon";
_bon_end = _bon;
 };
 //BA.debugLineNum = 768;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
 //BA.debugLineNum = 769;BA.debugLine="olad_end=(olad/30)*roze_kari";
_olad_end = (int) ((_olad/(double)30)*_roze_kari);
 }else {
 //BA.debugLineNum = 771;BA.debugLine="olad_end=olad";
_olad_end = _olad;
 };
 //BA.debugLineNum = 776;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
 //BA.debugLineNum = 777;BA.debugLine="fani_end=(fani/30)*roze_kari";
_fani_end = (int) ((_fani/(double)30)*_roze_kari);
 }else {
 //BA.debugLineNum = 779;BA.debugLine="fani_end=fani";
_fani_end = _fani;
 };
 //BA.debugLineNum = 783;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
 //BA.debugLineNum = 784;BA.debugLine="masoliat_end=(masoliat/30)*roze_kari";
_masoliat_end = (int) ((_masoliat/(double)30)*_roze_kari);
 }else {
 //BA.debugLineNum = 786;BA.debugLine="masoliat_end=masoliat";
_masoliat_end = _masoliat;
 };
 //BA.debugLineNum = 790;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
 //BA.debugLineNum = 791;BA.debugLine="sarparasti_end=(sarparasti/30)*roze_kari";
_sarparasti_end = (int) ((_sarparasti/(double)30)*_roze_kari);
 }else {
 //BA.debugLineNum = 793;BA.debugLine="sarparasti_end=sarparasti";
_sarparasti_end = _sarparasti;
 };
 //BA.debugLineNum = 797;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
 //BA.debugLineNum = 798;BA.debugLine="mazaya_end=(mazaya/30)*roze_kari";
_mazaya_end = (int) ((_mazaya/(double)30)*_roze_kari);
 }else {
 //BA.debugLineNum = 800;BA.debugLine="mazaya_end=mazaya";
_mazaya_end = _mazaya;
 };
 //BA.debugLineNum = 804;BA.debugLine="shift_end=((paye_end+sanavat_end)*shift)/100";
_shift_end = (int) (((_paye_end+_sanavat_end)*_shift)/(double)100);
 //BA.debugLineNum = 807;BA.debugLine="vahed_ezafekari=et_vahed_ezafekari.Tag";
_vahed_ezafekari = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari.getTag()));
 //BA.debugLineNum = 808;BA.debugLine="ezafekari_end=vahed_ezafekari*(et_time_h.Text+(et";
_ezafekari_end = (int) (_vahed_ezafekari*((double)(Double.parseDouble(mostCurrent._et_time_h.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m.getText()))/(double)60)));
 //BA.debugLineNum = 812;BA.debugLine="vahed_ezafekari_vij=et_vahed_ezafekari_vij.Tag";
_vahed_ezafekari_vij = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari_vij.getTag()));
 //BA.debugLineNum = 813;BA.debugLine="ezafekari_end_vij=vahed_ezafekari_vij*(et_time_h_";
_ezafekari_end_vij = (int) (_vahed_ezafekari_vij*((double)(Double.parseDouble(mostCurrent._et_time_h_vij.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m_vij.getText()))/(double)60)));
 //BA.debugLineNum = 818;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
 //BA.debugLineNum = 819;BA.debugLine="mosaedeh_all=dbCode.all_mosaedeh_mah(sp_year.Sel";
_mosaedeh_all = mostCurrent._dbcode._all_mosaedeh_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 }else {
 //BA.debugLineNum = 821;BA.debugLine="mosaedeh_all=dbCode.all_mosaedeh_byDate(lbl_date";
_mosaedeh_all = mostCurrent._dbcode._all_mosaedeh_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed);
 };
 //BA.debugLineNum = 825;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
 //BA.debugLineNum = 826;BA.debugLine="food_all=dbCode.all_food_mah(sp_year.SelectedIte";
_food_all = mostCurrent._dbcode._all_food_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 }else {
 //BA.debugLineNum = 828;BA.debugLine="food_all=dbCode.all_food_byDate(lbl_date_from.Te";
_food_all = mostCurrent._dbcode._all_food_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed);
 };
 //BA.debugLineNum = 833;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
 //BA.debugLineNum = 834;BA.debugLine="padash_all=dbCode.all_padash_mah(sp_year.Selecte";
_padash_all = mostCurrent._dbcode._all_padash_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 }else {
 //BA.debugLineNum = 836;BA.debugLine="padash_all=dbCode.all_padash_byDate(lbl_date_fro";
_padash_all = mostCurrent._dbcode._all_padash_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed);
 };
 //BA.debugLineNum = 840;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
 //BA.debugLineNum = 841;BA.debugLine="sayer_1_all=dbCode.all_sayer_mah(sp_year.Selecte";
_sayer_1_all = mostCurrent._dbcode._all_sayer_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
 //BA.debugLineNum = 842;BA.debugLine="sayer_2_all=dbCode.all_sayer_mah(sp_year.Selecte";
_sayer_2_all = mostCurrent._dbcode._all_sayer_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (2));
 }else {
 //BA.debugLineNum = 844;BA.debugLine="sayer_1_all=dbCode.all_sayer_byDate(lbl_date_fro";
_sayer_1_all = mostCurrent._dbcode._all_sayer_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (1));
 //BA.debugLineNum = 845;BA.debugLine="sayer_2_all=dbCode.all_sayer_byDate(lbl_date_fro";
_sayer_2_all = mostCurrent._dbcode._all_sayer_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (2));
 };
 //BA.debugLineNum = 849;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
 //BA.debugLineNum = 850;BA.debugLine="ayab_1_all=dbCode.all_ayabZahab_mah(sp_year.Sele";
_ayab_1_all = mostCurrent._dbcode._all_ayabzahab_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
 //BA.debugLineNum = 851;BA.debugLine="ayab_2_all=dbCode.all_ayabZahab_mah(sp_year.Sele";
_ayab_2_all = mostCurrent._dbcode._all_ayabzahab_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (2));
 }else {
 //BA.debugLineNum = 853;BA.debugLine="ayab_1_all=dbCode.all_ayabZahab_byDate(lbl_date_";
_ayab_1_all = mostCurrent._dbcode._all_ayabzahab_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (1));
 //BA.debugLineNum = 854;BA.debugLine="ayab_2_all=dbCode.all_ayabZahab_byDate(lbl_date_";
_ayab_2_all = mostCurrent._dbcode._all_ayabzahab_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (2));
 };
 //BA.debugLineNum = 859;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
 //BA.debugLineNum = 860;BA.debugLine="gest_vam=dbCode.all_gestVam_mah(sp_year.Selected";
_gest_vam = mostCurrent._dbcode._all_gestvam_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 }else {
 //BA.debugLineNum = 862;BA.debugLine="gest_vam=dbCode.all_gestVam_byDate(date2_fixed.S";
_gest_vam = mostCurrent._dbcode._all_gestvam_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._date2_fixed.substring((int) (0),(int) (7)));
 };
 //BA.debugLineNum = 868;BA.debugLine="hogog_nakhales=paye_end+ezafekari_end+ezafekari_e";
_hogog_nakhales = (int) (_paye_end+_ezafekari_end+_ezafekari_end_vij+_maskan_end+_bon_end+_olad_end+_fani_end+_masoliat_end+_sarparasti_end+_sanavat_end+_mazaya_end+_shift_end+_padash_all+_sayer_1_all+_ayab_1_all);
 //BA.debugLineNum = 871;BA.debugLine="bime_tamin_end=(hogog_nakhales-olad_end)*0.07";
_bime_tamin_end = (int) ((_hogog_nakhales-_olad_end)*0.07);
 //BA.debugLineNum = 873;BA.debugLine="Dim nak_mal As Int";
_nak_mal = 0;
 //BA.debugLineNum = 874;BA.debugLine="nak_mal=hogog_nakhales-((bime_tamin_end*2)/7)  ''";
_nak_mal = (int) (_hogog_nakhales-((_bime_tamin_end*2)/(double)7));
 //BA.debugLineNum = 878;BA.debugLine="maliat_end=mohasebe_maliat(nak_mal,sp_year.Select";
_maliat_end = _mohasebe_maliat(_nak_mal,(int)(Double.parseDouble(mostCurrent._sp_year.getSelectedItem())));
 //BA.debugLineNum = 882;BA.debugLine="jame_kosorat=bime_tamin_end+maliat_end+bime_takmi";
_jame_kosorat = (int) (_bime_tamin_end+_maliat_end+_bime_takmil+_ksorat+_mosaedeh_all+_food_all+_sayer_2_all+_ayab_2_all+_gest_vam);
 //BA.debugLineNum = 884;BA.debugLine="hogog_khales=hogog_nakhales-jame_kosorat";
_hogog_khales = (int) (_hogog_nakhales-_jame_kosorat);
 //BA.debugLineNum = 886;BA.debugLine="End Sub";
return "";
}
public static int  _mohasebe_maliat(int _hogog,int _year) throws Exception{
int _all_maliat = 0;
int _state1 = 0;
int _state2 = 0;
int _state3 = 0;
int _state4 = 0;
int _state5 = 0;
int _state6 = 0;
 //BA.debugLineNum = 887;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
 //BA.debugLineNum = 888;BA.debugLine="Dim all_maliat As Int=0";
_all_maliat = (int) (0);
 //BA.debugLineNum = 889;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
 //BA.debugLineNum = 890;BA.debugLine="Dim state2 As Int=0";
_state2 = (int) (0);
 //BA.debugLineNum = 891;BA.debugLine="Dim state3 As Int=0";
_state3 = (int) (0);
 //BA.debugLineNum = 892;BA.debugLine="Dim state4 As Int=0";
_state4 = (int) (0);
 //BA.debugLineNum = 893;BA.debugLine="Dim state5 As Int=0";
_state5 = (int) (0);
 //BA.debugLineNum = 894;BA.debugLine="Dim state6 As Int=0";
_state6 = (int) (0);
 //BA.debugLineNum = 896;BA.debugLine="If (year=1399)Then";
if ((_year==1399)) { 
 //BA.debugLineNum = 897;BA.debugLine="If(hogog>3000001 And hogog<7500001)Then	  ''----";
if ((_hogog>3000001 && _hogog<7500001)) { 
 //BA.debugLineNum = 898;BA.debugLine="state1=(hogog-3000000)*0.1";
_state1 = (int) ((_hogog-3000000)*0.1);
 };
 //BA.debugLineNum = 900;BA.debugLine="If(hogog>7500001 And hogog<10500001)Then	  ''---";
if ((_hogog>7500001 && _hogog<10500001)) { 
 //BA.debugLineNum = 901;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
 //BA.debugLineNum = 902;BA.debugLine="state2=(hogog-7500000)*0.15";
_state2 = (int) ((_hogog-7500000)*0.15);
 };
 //BA.debugLineNum = 904;BA.debugLine="If(hogog>10500001 And hogog<15000001)Then	  ''--";
if ((_hogog>10500001 && _hogog<15000001)) { 
 //BA.debugLineNum = 905;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
 //BA.debugLineNum = 906;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
 //BA.debugLineNum = 907;BA.debugLine="state3=(hogog-10500000)*0.2";
_state3 = (int) ((_hogog-10500000)*0.2);
 };
 //BA.debugLineNum = 909;BA.debugLine="If(hogog>15000001)Then	  ''-----stat4";
if ((_hogog>15000001)) { 
 //BA.debugLineNum = 910;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
 //BA.debugLineNum = 911;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
 //BA.debugLineNum = 912;BA.debugLine="state3=(4500000)*0.2";
_state3 = (int) ((4500000)*0.2);
 //BA.debugLineNum = 913;BA.debugLine="state4=(hogog-15000001)*0.25";
_state4 = (int) ((_hogog-15000001)*0.25);
 };
 };
 //BA.debugLineNum = 917;BA.debugLine="If (year=1400)Then";
if ((_year==1400)) { 
 //BA.debugLineNum = 918;BA.debugLine="If(hogog>4000001 And hogog<8000001)Then	  ''----";
if ((_hogog>4000001 && _hogog<8000001)) { 
 //BA.debugLineNum = 919;BA.debugLine="state1=(hogog-4000000)*0.1";
_state1 = (int) ((_hogog-4000000)*0.1);
 };
 //BA.debugLineNum = 921;BA.debugLine="If(hogog>8000001 And hogog<12000001)Then	  ''---";
if ((_hogog>8000001 && _hogog<12000001)) { 
 //BA.debugLineNum = 922;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
 //BA.debugLineNum = 923;BA.debugLine="state2=(hogog-8000000)*0.15";
_state2 = (int) ((_hogog-8000000)*0.15);
 };
 //BA.debugLineNum = 925;BA.debugLine="If(hogog>12000001 And hogog<18000001)Then	  ''--";
if ((_hogog>12000001 && _hogog<18000001)) { 
 //BA.debugLineNum = 926;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
 //BA.debugLineNum = 927;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
 //BA.debugLineNum = 928;BA.debugLine="state3=(hogog-12000000)*0.2";
_state3 = (int) ((_hogog-12000000)*0.2);
 };
 //BA.debugLineNum = 930;BA.debugLine="If(hogog>18000001 And hogog<24000001)Then	  ''--";
if ((_hogog>18000001 && _hogog<24000001)) { 
 //BA.debugLineNum = 931;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
 //BA.debugLineNum = 932;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
 //BA.debugLineNum = 933;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
 //BA.debugLineNum = 934;BA.debugLine="state4=(hogog-18000000)*0.25";
_state4 = (int) ((_hogog-18000000)*0.25);
 };
 //BA.debugLineNum = 936;BA.debugLine="If(hogog>24000001 And hogog<32000001)Then	  ''--";
if ((_hogog>24000001 && _hogog<32000001)) { 
 //BA.debugLineNum = 937;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
 //BA.debugLineNum = 938;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
 //BA.debugLineNum = 939;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
 //BA.debugLineNum = 940;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
 //BA.debugLineNum = 941;BA.debugLine="state5=(hogog-24000000)*0.3";
_state5 = (int) ((_hogog-24000000)*0.3);
 };
 //BA.debugLineNum = 943;BA.debugLine="If(hogog>32000001)Then	  ''-----stat4";
if ((_hogog>32000001)) { 
 //BA.debugLineNum = 944;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
 //BA.debugLineNum = 945;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
 //BA.debugLineNum = 946;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
 //BA.debugLineNum = 947;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
 //BA.debugLineNum = 948;BA.debugLine="state5=(6000000)*0.3";
_state5 = (int) ((6000000)*0.3);
 //BA.debugLineNum = 949;BA.debugLine="state6=(hogog-32000000)*0.35";
_state6 = (int) ((_hogog-32000000)*0.35);
 };
 };
 //BA.debugLineNum = 953;BA.debugLine="If (year=1401)Then";
if ((_year==1401)) { 
 //BA.debugLineNum = 954;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
if ((_hogog>5600001 && _hogog<12500001)) { 
 //BA.debugLineNum = 955;BA.debugLine="state1=(hogog-5600000)*0.1";
_state1 = (int) ((_hogog-5600000)*0.1);
 };
 //BA.debugLineNum = 957;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
if ((_hogog>12500001 && _hogog<20830001)) { 
 //BA.debugLineNum = 958;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
 //BA.debugLineNum = 959;BA.debugLine="state2=(hogog-12500000)*0.15";
_state2 = (int) ((_hogog-12500000)*0.15);
 };
 //BA.debugLineNum = 961;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
if ((_hogog>20830001 && _hogog<29160001)) { 
 //BA.debugLineNum = 962;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
 //BA.debugLineNum = 963;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
 //BA.debugLineNum = 964;BA.debugLine="state3=(hogog-20830000)*0.2";
_state3 = (int) ((_hogog-20830000)*0.2);
 };
 //BA.debugLineNum = 967;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
if ((_hogog>29160001)) { 
 //BA.debugLineNum = 968;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
 //BA.debugLineNum = 969;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
 //BA.debugLineNum = 970;BA.debugLine="state3=(8330000)*0.2";
_state3 = (int) ((8330000)*0.2);
 //BA.debugLineNum = 972;BA.debugLine="state4=(hogog-29160000)*0.3";
_state4 = (int) ((_hogog-29160000)*0.3);
 };
 };
 //BA.debugLineNum = 977;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
_all_maliat = (int) (_state1+_state2+_state3+_state4+_state5+_state6);
 //BA.debugLineNum = 978;BA.debugLine="Return all_maliat";
if (true) return _all_maliat;
 //BA.debugLineNum = 980;BA.debugLine="End Sub";
return 0;
}
public static String  _pan_all_click() throws Exception{
 //BA.debugLineNum = 1044;BA.debugLine="Private Sub pan_all_Click";
 //BA.debugLineNum = 1045;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1046;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_set_date_click() throws Exception{
 //BA.debugLineNum = 1138;BA.debugLine="Private Sub pan_all_set_date_Click";
 //BA.debugLineNum = 1139;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1140;BA.debugLine="End Sub";
return "";
}
public static String  _pan_mohasebat_click() throws Exception{
 //BA.debugLineNum = 1031;BA.debugLine="Private Sub pan_mohasebat_Click";
 //BA.debugLineNum = 1033;BA.debugLine="End Sub";
return "";
}
public static String  _panel7_click() throws Exception{
 //BA.debugLineNum = 1040;BA.debugLine="Private Sub Panel7_Click";
 //BA.debugLineNum = 1042;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 1384;BA.debugLine="Private Sub pik_day_bala1_Click";
 //BA.debugLineNum = 1385;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 1386;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 1389;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 1390;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 1391;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 1393;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 1394;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 1397;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 1398;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 1400;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 1401;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 1405;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 1407;BA.debugLine="Private Sub pik_day_paeen1_Click";
 //BA.debugLineNum = 1408;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 1409;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 1410;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 1411;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 1412;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 1414;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 1415;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 1418;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 1419;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 1421;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 1422;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 1426;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 1330;BA.debugLine="Private Sub pik_moon_bala1_Click";
 //BA.debugLineNum = 1331;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 1332;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
 //BA.debugLineNum = 1334;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 1335;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 1337;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 1338;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 1340;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 1342;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 1344;BA.debugLine="Private Sub pik_moon_paeen1_Click";
 //BA.debugLineNum = 1345;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 1346;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
 //BA.debugLineNum = 1348;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 1349;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 1351;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 1352;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 1354;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
 //BA.debugLineNum = 1356;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 1290;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
 //BA.debugLineNum = 1291;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 1292;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 1293;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 1296;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 1298;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
 //BA.debugLineNum = 1299;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
 //BA.debugLineNum = 1300;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 1301;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 1303;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
 //BA.debugLineNum = 1304;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
 //BA.debugLineNum = 1305;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 1306;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 1309;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 1310;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 1311;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 1313;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 1314;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 1317;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 1318;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 1320;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 1321;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 };
 //BA.debugLineNum = 1328;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 1230;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
 //BA.debugLineNum = 1231;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 1232;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 1233;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 1236;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 1238;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
 //BA.debugLineNum = 1239;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
 //BA.debugLineNum = 1240;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 1241;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 1243;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
 //BA.debugLineNum = 1244;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
 //BA.debugLineNum = 1245;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 1246;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 1249;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 1250;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 1252;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 1253;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 1255;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
 //BA.debugLineNum = 1258;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 1260;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
 //BA.debugLineNum = 1261;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 1262;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 1263;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 1266;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 1268;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
 //BA.debugLineNum = 1269;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
 //BA.debugLineNum = 1270;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 1271;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 1273;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
 //BA.debugLineNum = 1274;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
 //BA.debugLineNum = 1275;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 1276;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 1279;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 1280;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 1282;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 1283;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
 //BA.debugLineNum = 1288;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 1358;BA.debugLine="Private Sub pik_year_bala1_Click";
 //BA.debugLineNum = 1359;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 1360;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 1362;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 1363;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 1365;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 1366;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 1369;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 1371;BA.debugLine="Private Sub pik_year_paeen1_Click";
 //BA.debugLineNum = 1372;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 1373;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 1375;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 1376;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 1378;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 1379;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 1382;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _radio_type1_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 1103;BA.debugLine="Private Sub radio_type1_CheckedChange(Checked As B";
 //BA.debugLineNum = 1104;BA.debugLine="sp_moon.Enabled=True";
mostCurrent._sp_moon.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1105;BA.debugLine="sp_year.Enabled=True";
mostCurrent._sp_year.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1106;BA.debugLine="lbl_date_from.Enabled=False";
mostCurrent._lbl_date_from.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1107;BA.debugLine="lbl_date_to.Enabled=False";
mostCurrent._lbl_date_to.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1108;BA.debugLine="type_mohasebe=1";
_type_mohasebe = (int) (1);
 //BA.debugLineNum = 1109;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
 //BA.debugLineNum = 1110;BA.debugLine="et_time_inDB";
_et_time_indb();
 //BA.debugLineNum = 1111;BA.debugLine="End Sub";
return "";
}
public static String  _radio_type2_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 1093;BA.debugLine="Private Sub radio_type2_CheckedChange(Checked As B";
 //BA.debugLineNum = 1094;BA.debugLine="sp_moon.Enabled=False";
mostCurrent._sp_moon.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1095;BA.debugLine="sp_year.Enabled=False";
mostCurrent._sp_year.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1096;BA.debugLine="lbl_date_from.Enabled=True";
mostCurrent._lbl_date_from.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1097;BA.debugLine="lbl_date_to.Enabled=True";
mostCurrent._lbl_date_to.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1098;BA.debugLine="type_mohasebe=2";
_type_mohasebe = (int) (2);
 //BA.debugLineNum = 1099;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
 //BA.debugLineNum = 1100;BA.debugLine="et_time_inDB";
_et_time_indb();
 //BA.debugLineNum = 1101;BA.debugLine="End Sub";
return "";
}
public static String  _save_gozaresh() throws Exception{
boolean _chek = false;
anywheresoftware.b4a.objects.collections.List _alist = null;
 //BA.debugLineNum = 996;BA.debugLine="Sub save_gozaresh";
 //BA.debugLineNum = 999;BA.debugLine="Dim chek As Boolean";
_chek = false;
 //BA.debugLineNum = 1000;BA.debugLine="chek=myfunc.check_karid";
_chek = mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 1001;BA.debugLine="Dim alist As List";
_alist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1002;BA.debugLine="alist.Initialize";
_alist.Initialize();
 //BA.debugLineNum = 1004;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(Main.persianDa";
_alist = mostCurrent._myfunc._num_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())),BA.NumberToString(01));
 //BA.debugLineNum = 1007;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 1008;BA.debugLine="If(alist.Get(2)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (2))))<5)) { 
 //BA.debugLineNum = 1009;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDa";
mostCurrent._dbcode._add_gozaresh /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),mostCurrent._et_name_gozaresh.getText(),mostCurrent._et_tozih_gozaresh.getText(),mostCurrent._str1.ToString(),BA.NumberToString(_hogog_nakhales),BA.NumberToString(_hogog_khales));
 //BA.debugLineNum = 1010;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("گزارش ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 1012;BA.debugLine="Main.buy_index=1";
mostCurrent._main._buy_index /*int*/  = (int) (1);
 //BA.debugLineNum = 1013;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 1014;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 }else {
 //BA.debugLineNum = 1017;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDat";
mostCurrent._dbcode._add_gozaresh /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),mostCurrent._et_name_gozaresh.getText(),mostCurrent._et_tozih_gozaresh.getText(),mostCurrent._str1.ToString(),BA.NumberToString(_hogog_nakhales),BA.NumberToString(_hogog_khales));
 //BA.debugLineNum = 1018;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("گزارش ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 1023;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(int _num) throws Exception{
 //BA.debugLineNum = 311;BA.debugLine="Sub show_num_pool (num As Int) As String";
 //BA.debugLineNum = 312;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
 //BA.debugLineNum = 313;BA.debugLine="End Sub";
return "";
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 982;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
 //BA.debugLineNum = 983;BA.debugLine="et_time_inDB";
_et_time_indb();
 //BA.debugLineNum = 985;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 987;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
 //BA.debugLineNum = 988;BA.debugLine="et_time_inDB";
_et_time_indb();
 //BA.debugLineNum = 989;BA.debugLine="End Sub";
return "";
}
public static String  _time_page_load_tick() throws Exception{
 //BA.debugLineNum = 305;BA.debugLine="Sub time_page_load_Tick";
 //BA.debugLineNum = 306;BA.debugLine="pan_load.Visible=False";
mostCurrent._pan_load.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 307;BA.debugLine="B4XLoadingIndicator1.Hide";
mostCurrent._b4xloadingindicator1._hide /*String*/ ();
 //BA.debugLineNum = 308;BA.debugLine="Main.time_page_load.Enabled=False";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 309;BA.debugLine="End Sub";
return "";
}
}
