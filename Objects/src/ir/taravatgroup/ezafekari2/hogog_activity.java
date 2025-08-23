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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.hogog_activity");
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
        
        BA.LogInfo("** Activity (hogog_activity) Create " + (isFirst ? "(first time)" : "") + " **");
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



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static String _paye = "";
public static int _maskan = 0;
public static int _olad = 0;
public static int _fani = 0;
public static int _masoliat = 0;
public static int _bon = 0;
public static int _hamsar = 0;
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
public static int _hamsar_end = 0;
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
public static int _food_1_all = 0;
public static int _food_2_all = 0;
public static int _sayer_1_all = 0;
public static int _sayer_2_all = 0;
public static int _ayab_1_all = 0;
public static int _ayab_2_all = 0;
public static int _padash_all = 0;
public static int _gest_vam = 0;
public static String _date2_fixed = "";
public anywheresoftware.b4a.objects.PanelWrapper _pan_paen = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_maliat = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_bime = null;
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
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.drawable.BitmapDrawable _imm = null;
RDebugUtils.currentLine=31916032;
 //BA.debugLineNum = 31916032;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=31916034;
 //BA.debugLineNum = 31916034;BA.debugLine="Activity.LoadLayout(\"hogog_layout\")";
mostCurrent._activity.LoadLayout("hogog_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=31916035;
 //BA.debugLineNum = 31916035;BA.debugLine="scv_hogog.Panel.LoadLayout(\"item_hogog\")";
mostCurrent._scv_hogog.getPanel().LoadLayout("item_hogog",mostCurrent.activityBA);
RDebugUtils.currentLine=31916037;
 //BA.debugLineNum = 31916037;BA.debugLine="get_data_hogogi";
_get_data_hogogi();
RDebugUtils.currentLine=31916039;
 //BA.debugLineNum = 31916039;BA.debugLine="Main.time_page_load.Initialize(\"time_page_load\",1";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .Initialize(processBA,"time_page_load",(long) (1500));
RDebugUtils.currentLine=31916040;
 //BA.debugLineNum = 31916040;BA.debugLine="Main.time_page_load.Enabled=True";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=31916041;
 //BA.debugLineNum = 31916041;BA.debugLine="B4XLoadingIndicator1.Show";
mostCurrent._b4xloadingindicator1._show /*String*/ (null);
RDebugUtils.currentLine=31916043;
 //BA.debugLineNum = 31916043;BA.debugLine="sp_year.Add(\"1404\")";
mostCurrent._sp_year.Add("1404");
RDebugUtils.currentLine=31916044;
 //BA.debugLineNum = 31916044;BA.debugLine="sp_year.Add(\"1403\")";
mostCurrent._sp_year.Add("1403");
RDebugUtils.currentLine=31916045;
 //BA.debugLineNum = 31916045;BA.debugLine="sp_year.Add(\"1402\")";
mostCurrent._sp_year.Add("1402");
RDebugUtils.currentLine=31916046;
 //BA.debugLineNum = 31916046;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
RDebugUtils.currentLine=31916047;
 //BA.debugLineNum = 31916047;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
RDebugUtils.currentLine=31916048;
 //BA.debugLineNum = 31916048;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
RDebugUtils.currentLine=31916049;
 //BA.debugLineNum = 31916049;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
RDebugUtils.currentLine=31916051;
 //BA.debugLineNum = 31916051;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=31916053;
 //BA.debugLineNum = 31916053;BA.debugLine="Dim imm As BitmapDrawable";
_imm = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=31916054;
 //BA.debugLineNum = 31916054;BA.debugLine="imm.Initialize(LoadBitmap(File.DirAssets,\"textBox";
_imm.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"textBox.png").getObject()));
RDebugUtils.currentLine=31916055;
 //BA.debugLineNum = 31916055;BA.debugLine="imm.Gravity=Gravity.FILL";
_imm.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=31916056;
 //BA.debugLineNum = 31916056;BA.debugLine="sp_year.Background=imm";
mostCurrent._sp_year.setBackground((android.graphics.drawable.Drawable)(_imm.getObject()));
RDebugUtils.currentLine=31916057;
 //BA.debugLineNum = 31916057;BA.debugLine="sp_moon.Background=imm";
mostCurrent._sp_moon.setBackground((android.graphics.drawable.Drawable)(_imm.getObject()));
RDebugUtils.currentLine=31916060;
 //BA.debugLineNum = 31916060;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))-1));
RDebugUtils.currentLine=31916065;
 //BA.debugLineNum = 31916065;BA.debugLine="WebView1.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview1.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=31916066;
 //BA.debugLineNum = 31916066;BA.debugLine="WebView2.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview2.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=31916069;
 //BA.debugLineNum = 31916069;BA.debugLine="ls_onvanHa.Initialize";
mostCurrent._ls_onvanha.Initialize();
RDebugUtils.currentLine=31916070;
 //BA.debugLineNum = 31916070;BA.debugLine="ls_onvanHa=dbCode.read_onvan_db";
mostCurrent._ls_onvanha = mostCurrent._dbcode._read_onvan_db /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=31916073;
 //BA.debugLineNum = 31916073;BA.debugLine="str_web1.Initialize";
mostCurrent._str_web1.Initialize();
RDebugUtils.currentLine=31916074;
 //BA.debugLineNum = 31916074;BA.debugLine="str_web1.Append(\"<html dir='rtl'><meta charset='U";
mostCurrent._str_web1.Append("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>");
RDebugUtils.currentLine=31916075;
 //BA.debugLineNum = 31916075;BA.debugLine="str_web1.Append(\"<h4 align='center' >اطلاعات حقوق";
mostCurrent._str_web1.Append("<h4 align='center' >اطلاعات حقوق برای ۳۰ روز</h4>");
RDebugUtils.currentLine=31916077;
 //BA.debugLineNum = 31916077;BA.debugLine="str_web1.Append(\"<table style='width:100%'><tr>\")";
mostCurrent._str_web1.Append("<table style='width:100%'><tr>");
RDebugUtils.currentLine=31916078;
 //BA.debugLineNum = 31916078;BA.debugLine="str_web1.Append(\"<td>\"&\"\"&ls_onvanHa.Get(0)&\" : \"";
mostCurrent._str_web1.Append("<td>"+""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (0)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool((int)(Double.parseDouble(mostCurrent._paye))))+"<br>");
RDebugUtils.currentLine=31916079;
 //BA.debugLineNum = 31916079;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(2)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (2)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maskan))+"<br>");
RDebugUtils.currentLine=31916080;
 //BA.debugLineNum = 31916080;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(3)&\" : \"&myfun";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (3)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bon))+"<br>");
RDebugUtils.currentLine=31916081;
 //BA.debugLineNum = 31916081;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(13)&\" : \"&myfu";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (13)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hamsar))+"<br>");
RDebugUtils.currentLine=31916083;
 //BA.debugLineNum = 31916083;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(4)&\"  : \"&myfun";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (4)))+"  : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad))+"<br>");
RDebugUtils.currentLine=31916084;
 //BA.debugLineNum = 31916084;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(5)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (5)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_fani))+"<br>");
RDebugUtils.currentLine=31916085;
 //BA.debugLineNum = 31916085;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(6)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (6)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_masoliat))+"<br>");
RDebugUtils.currentLine=31916086;
 //BA.debugLineNum = 31916086;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(7)&\"  : \"&myfu";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (7)))+"  : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sarparasti))+"<br></td>");
RDebugUtils.currentLine=31916090;
 //BA.debugLineNum = 31916090;BA.debugLine="str_web1.Append(\"<td>\"&\" \"&ls_onvanHa.Get(1)&\" :";
mostCurrent._str_web1.Append("<td>"+" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (1)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat))+"<br>");
RDebugUtils.currentLine=31916091;
 //BA.debugLineNum = 31916091;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(8)&\" : \"&myfun";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (8)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_shift))+"<br>");
RDebugUtils.currentLine=31916092;
 //BA.debugLineNum = 31916092;BA.debugLine="str_web1.Append(\"بیمه تامین اجتماعی : %\"&myfunc.e";
mostCurrent._str_web1.Append("بیمه تامین اجتماعی : %"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_bime_tamin))+"<br>");
RDebugUtils.currentLine=31916093;
 //BA.debugLineNum = 31916093;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(9)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (9)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_takmil))+"<br>");
RDebugUtils.currentLine=31916094;
 //BA.debugLineNum = 31916094;BA.debugLine="str_web1.Append(\" مالیات : مطابق قانون کار<br>\")";
mostCurrent._str_web1.Append(" مالیات : مطابق قانون کار<br>");
RDebugUtils.currentLine=31916095;
 //BA.debugLineNum = 31916095;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(10)&\" : \"&myf";
mostCurrent._str_web1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (10)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya))+"<br>");
RDebugUtils.currentLine=31916096;
 //BA.debugLineNum = 31916096;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(11)&\" : \"&myf";
mostCurrent._str_web1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (11)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat))+"</td>");
RDebugUtils.currentLine=31916097;
 //BA.debugLineNum = 31916097;BA.debugLine="str_web1.Append(\"</tr></table>\")";
mostCurrent._str_web1.Append("</tr></table>");
RDebugUtils.currentLine=31916098;
 //BA.debugLineNum = 31916098;BA.debugLine="str_web1.Append(\"</body></html>\")";
mostCurrent._str_web1.Append("</body></html>");
RDebugUtils.currentLine=31916100;
 //BA.debugLineNum = 31916100;BA.debugLine="WebView1.LoadHtml(str_web1)";
mostCurrent._webview1.LoadHtml(BA.ObjectToString(mostCurrent._str_web1));
RDebugUtils.currentLine=31916105;
 //BA.debugLineNum = 31916105;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
RDebugUtils.currentLine=31916106;
 //BA.debugLineNum = 31916106;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=31916108;
 //BA.debugLineNum = 31916108;BA.debugLine="lbl_date_from.Text=myfunc.fa2en(Main.persianDate.";
mostCurrent._lbl_date_from.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear()))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianDay())))))));
RDebugUtils.currentLine=31916109;
 //BA.debugLineNum = 31916109;BA.debugLine="lbl_date_to.Text=myfunc.fa2en(Main.persianDate.Pe";
mostCurrent._lbl_date_to.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear()))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))+1))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianDay())))))));
RDebugUtils.currentLine=31916115;
 //BA.debugLineNum = 31916115;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
RDebugUtils.currentLine=31916118;
 //BA.debugLineNum = 31916118;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=31916120;
 //BA.debugLineNum = 31916120;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=31916121;
 //BA.debugLineNum = 31916121;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
RDebugUtils.currentLine=31916124;
 //BA.debugLineNum = 31916124;BA.debugLine="If(dbCode.get_setting_byName(\"tog_maliat\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_maliat")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=31916125;
 //BA.debugLineNum = 31916125;BA.debugLine="et_maliat.Text=\"محاسبه اتوماتیک\"";
mostCurrent._et_maliat.setText(BA.ObjectToCharSequence("محاسبه اتوماتیک"));
RDebugUtils.currentLine=31916126;
 //BA.debugLineNum = 31916126;BA.debugLine="et_maliat.Enabled=False";
mostCurrent._et_maliat.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=31916128;
 //BA.debugLineNum = 31916128;BA.debugLine="et_maliat.Text=0";
mostCurrent._et_maliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31916129;
 //BA.debugLineNum = 31916129;BA.debugLine="et_maliat.Tag=0";
mostCurrent._et_maliat.setTag((Object)(0));
RDebugUtils.currentLine=31916130;
 //BA.debugLineNum = 31916130;BA.debugLine="et_maliat.Enabled=True";
mostCurrent._et_maliat.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=31916133;
 //BA.debugLineNum = 31916133;BA.debugLine="If(dbCode.get_setting_byName(\"tog_bime\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_bime")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=31916134;
 //BA.debugLineNum = 31916134;BA.debugLine="et_bime.Text=\"محاسبه اتوماتیک\"";
mostCurrent._et_bime.setText(BA.ObjectToCharSequence("محاسبه اتوماتیک"));
RDebugUtils.currentLine=31916135;
 //BA.debugLineNum = 31916135;BA.debugLine="et_bime.Enabled=False";
mostCurrent._et_bime.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=31916137;
 //BA.debugLineNum = 31916137;BA.debugLine="et_bime.Text=0";
mostCurrent._et_bime.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=31916138;
 //BA.debugLineNum = 31916138;BA.debugLine="et_bime.Tag=0";
mostCurrent._et_bime.setTag((Object)(0));
RDebugUtils.currentLine=31916139;
 //BA.debugLineNum = 31916139;BA.debugLine="et_bime.Enabled=True";
mostCurrent._et_bime.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=31916146;
 //BA.debugLineNum = 31916146;BA.debugLine="pan_hed_hogog.Color=Main.color4";
mostCurrent._pan_hed_hogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=31916147;
 //BA.debugLineNum = 31916147;BA.debugLine="pan_main_hed_hogog.Color=Main.color4";
mostCurrent._pan_main_hed_hogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=31916148;
 //BA.debugLineNum = 31916148;BA.debugLine="pan_hed_gozaresh.Color=Main.color4";
mostCurrent._pan_hed_gozaresh.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=31916149;
 //BA.debugLineNum = 31916149;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=31916152;
 //BA.debugLineNum = 31916152;BA.debugLine="End Sub";
return "";
}
public static String  _get_data_hogogi() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_data_hogogi", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_data_hogogi", null));}
RDebugUtils.currentLine=32768000;
 //BA.debugLineNum = 32768000;BA.debugLine="Sub get_data_hogogi";
RDebugUtils.currentLine=32768002;
 //BA.debugLineNum = 32768002;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=32768003;
 //BA.debugLineNum = 32768003;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=32768005;
 //BA.debugLineNum = 32768005;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=32768006;
 //BA.debugLineNum = 32768006;BA.debugLine="paye=dbCode.res.GetString(\"value\")";
mostCurrent._paye = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value");
RDebugUtils.currentLine=32768008;
 //BA.debugLineNum = 32768008;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (1));
RDebugUtils.currentLine=32768009;
 //BA.debugLineNum = 32768009;BA.debugLine="maskan=dbCode.res.GetString(\"value\")";
_maskan = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=32768011;
 //BA.debugLineNum = 32768011;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (3));
RDebugUtils.currentLine=32768012;
 //BA.debugLineNum = 32768012;BA.debugLine="olad=dbCode.res.GetString(\"value\")";
_olad = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=32768014;
 //BA.debugLineNum = 32768014;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (4));
RDebugUtils.currentLine=32768015;
 //BA.debugLineNum = 32768015;BA.debugLine="fani=dbCode.res.GetString(\"value\")";
_fani = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=32768017;
 //BA.debugLineNum = 32768017;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (5));
RDebugUtils.currentLine=32768018;
 //BA.debugLineNum = 32768018;BA.debugLine="masoliat=dbCode.res.GetString(\"value\")";
_masoliat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=32768020;
 //BA.debugLineNum = 32768020;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (2));
RDebugUtils.currentLine=32768021;
 //BA.debugLineNum = 32768021;BA.debugLine="bon=dbCode.res.GetString(\"value\")";
_bon = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=32768026;
 //BA.debugLineNum = 32768026;BA.debugLine="dbCode.res.Position=6 ''--------bime_tamin------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (6));
RDebugUtils.currentLine=32768027;
 //BA.debugLineNum = 32768027;BA.debugLine="bime_tamin=dbCode.res.GetString(\"value\")";
_bime_tamin = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=32768029;
 //BA.debugLineNum = 32768029;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (11));
RDebugUtils.currentLine=32768030;
 //BA.debugLineNum = 32768030;BA.debugLine="bime_takmil=dbCode.res.GetString(\"value\")";
_bime_takmil = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=32768038;
 //BA.debugLineNum = 32768038;BA.debugLine="dbCode.res.Position=13 ''--------hag shift------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (13));
RDebugUtils.currentLine=32768039;
 //BA.debugLineNum = 32768039;BA.debugLine="shift=dbCode.res.GetString(\"value\")";
_shift = (double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=32768041;
 //BA.debugLineNum = 32768041;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (14));
RDebugUtils.currentLine=32768042;
 //BA.debugLineNum = 32768042;BA.debugLine="sanavat=dbCode.res.GetString(\"value\")";
_sanavat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=32768044;
 //BA.debugLineNum = 32768044;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (15));
RDebugUtils.currentLine=32768045;
 //BA.debugLineNum = 32768045;BA.debugLine="sarparasti=dbCode.res.GetString(\"value\")";
_sarparasti = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=32768047;
 //BA.debugLineNum = 32768047;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (16));
RDebugUtils.currentLine=32768048;
 //BA.debugLineNum = 32768048;BA.debugLine="mazaya=dbCode.res.GetString(\"value\")";
_mazaya = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=32768050;
 //BA.debugLineNum = 32768050;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (19));
RDebugUtils.currentLine=32768051;
 //BA.debugLineNum = 32768051;BA.debugLine="ksorat=dbCode.res.GetString(\"value\")";
_ksorat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=32768061;
 //BA.debugLineNum = 32768061;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=32768062;
 //BA.debugLineNum = 32768062;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=32768066;
 //BA.debugLineNum = 32768066;BA.debugLine="hamsar=dbCode.get_setting_byName(\"hag_hamsar\")";
_hamsar = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"hag_hamsar")));
RDebugUtils.currentLine=32768069;
 //BA.debugLineNum = 32768069;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(int _num) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_num_pool", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_num_pool", new Object[] {_num}));}
RDebugUtils.currentLine=32374784;
 //BA.debugLineNum = 32374784;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=32374785;
 //BA.debugLineNum = 32374785;BA.debugLine="Return NumberFormat(num,0,0)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (0));
RDebugUtils.currentLine=32374786;
 //BA.debugLineNum = 32374786;BA.debugLine="End Sub";
return "";
}
public static String  _fix_date2_decreceone() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fix_date2_decreceone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fix_date2_decreceone", null));}
int _y_date2 = 0;
int _m_date2 = 0;
int _d_date2 = 0;
RDebugUtils.currentLine=31981568;
 //BA.debugLineNum = 31981568;BA.debugLine="Sub fix_date2_decreceOne";
RDebugUtils.currentLine=31981571;
 //BA.debugLineNum = 31981571;BA.debugLine="Dim y_date2 As Int =myfunc.fa2en( lbl_date_to.Tex";
_y_date2 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=31981572;
 //BA.debugLineNum = 31981572;BA.debugLine="Dim m_date2 As Int =myfunc.fa2en(lbl_date_to.Text";
_m_date2 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=31981573;
 //BA.debugLineNum = 31981573;BA.debugLine="Dim d_date2 As Int =myfunc.fa2en(lbl_date_to.Text";
_d_date2 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=31981594;
 //BA.debugLineNum = 31981594;BA.debugLine="date2_fixed=y_date2&\"/\"&myfunc.convert_adad(m_dat";
mostCurrent._date2_fixed = BA.NumberToString(_y_date2)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_m_date2)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_d_date2);
RDebugUtils.currentLine=31981597;
 //BA.debugLineNum = 31981597;BA.debugLine="End Sub";
return "";
}
public static String  _et_time_indb() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_time_indb", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_time_indb", null));}
anywheresoftware.b4a.objects.collections.List _list_ezafekari1 = null;
anywheresoftware.b4a.objects.collections.List _list_ezafekari2 = null;
RDebugUtils.currentLine=32440320;
 //BA.debugLineNum = 32440320;BA.debugLine="Sub et_time_inDB";
RDebugUtils.currentLine=32440323;
 //BA.debugLineNum = 32440323;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
mostCurrent._moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=32440326;
 //BA.debugLineNum = 32440326;BA.debugLine="Dim list_ezafekari1 As List";
_list_ezafekari1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=32440327;
 //BA.debugLineNum = 32440327;BA.debugLine="list_ezafekari1.Initialize";
_list_ezafekari1.Initialize();
RDebugUtils.currentLine=32440330;
 //BA.debugLineNum = 32440330;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=32440331;
 //BA.debugLineNum = 32440331;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_mah(myfunc.";
_list_ezafekari1 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._moon_num),(int) (2));
 }else {
RDebugUtils.currentLine=32440333;
 //BA.debugLineNum = 32440333;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_byDate(myfu";
_list_ezafekari1 = mostCurrent._dbcode._all_ezafekari_bydate /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText()),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._date2_fixed),(int) (2));
 };
RDebugUtils.currentLine=32440336;
 //BA.debugLineNum = 32440336;BA.debugLine="et_time_h.Text=list_ezafekari1.Get(0)";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (0))));
RDebugUtils.currentLine=32440337;
 //BA.debugLineNum = 32440337;BA.debugLine="et_time_m.Text=list_ezafekari1.Get(1)";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (1))));
RDebugUtils.currentLine=32440340;
 //BA.debugLineNum = 32440340;BA.debugLine="Dim list_ezafekari2 As List";
_list_ezafekari2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=32440341;
 //BA.debugLineNum = 32440341;BA.debugLine="list_ezafekari2.Initialize";
_list_ezafekari2.Initialize();
RDebugUtils.currentLine=32440344;
 //BA.debugLineNum = 32440344;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=32440345;
 //BA.debugLineNum = 32440345;BA.debugLine="list_ezafekari2=dbCode.all_ezafekari_mah(sp_year";
_list_ezafekari2 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num,(int) (3));
 }else {
RDebugUtils.currentLine=32440347;
 //BA.debugLineNum = 32440347;BA.debugLine="list_ezafekari2=dbCode.all_ezafekari_byDate(myfu";
_list_ezafekari2 = mostCurrent._dbcode._all_ezafekari_bydate /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText()),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._date2_fixed),(int) (3));
 };
RDebugUtils.currentLine=32440350;
 //BA.debugLineNum = 32440350;BA.debugLine="et_time_h_vij.Text=list_ezafekari2.Get(0)";
mostCurrent._et_time_h_vij.setText(BA.ObjectToCharSequence(_list_ezafekari2.Get((int) (0))));
RDebugUtils.currentLine=32440351;
 //BA.debugLineNum = 32440351;BA.debugLine="et_time_m_vij.Text=list_ezafekari2.Get(1)";
mostCurrent._et_time_m_vij.setText(BA.ObjectToCharSequence(_list_ezafekari2.Get((int) (1))));
RDebugUtils.currentLine=32440354;
 //BA.debugLineNum = 32440354;BA.debugLine="If(moon_num<7)Then";
if (((double)(Double.parseDouble(mostCurrent._moon_num))<7)) { 
RDebugUtils.currentLine=32440355;
 //BA.debugLineNum = 32440355;BA.debugLine="roze_kari=31";
_roze_kari = (int) (31);
 }else {
RDebugUtils.currentLine=32440357;
 //BA.debugLineNum = 32440357;BA.debugLine="roze_kari=30";
_roze_kari = (int) (30);
 };
RDebugUtils.currentLine=32440361;
 //BA.debugLineNum = 32440361;BA.debugLine="et_rozekari.Text=roze_kari";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(_roze_kari));
RDebugUtils.currentLine=32440362;
 //BA.debugLineNum = 32440362;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "calc_vahed_ezafekari", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "calc_vahed_ezafekari", null));}
RDebugUtils.currentLine=32047104;
 //BA.debugLineNum = 32047104;BA.debugLine="Sub calc_vahed_ezafekari";
RDebugUtils.currentLine=32047106;
 //BA.debugLineNum = 32047106;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=32047109;
 //BA.debugLineNum = 32047109;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=32047112;
 //BA.debugLineNum = 32047112;BA.debugLine="vahed_ezafekari=((paye+sanavat)/220)*1.4";
_vahed_ezafekari = (int) ((((double)(Double.parseDouble(mostCurrent._paye))+_sanavat)/(double)220)*1.4);
RDebugUtils.currentLine=32047117;
 //BA.debugLineNum = 32047117;BA.debugLine="et_vahed_ezafekari.Tag=vahed_ezafekari";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_vahed_ezafekari));
RDebugUtils.currentLine=32047118;
 //BA.debugLineNum = 32047118;BA.debugLine="et_vahed_ezafekari.Text=myfunc.show_num_pool(vahe";
mostCurrent._et_vahed_ezafekari.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari)));
RDebugUtils.currentLine=32047121;
 //BA.debugLineNum = 32047121;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari_vij() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "calc_vahed_ezafekari_vij", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "calc_vahed_ezafekari_vij", null));}
RDebugUtils.currentLine=32112640;
 //BA.debugLineNum = 32112640;BA.debugLine="Sub calc_vahed_ezafekari_vij";
RDebugUtils.currentLine=32112642;
 //BA.debugLineNum = 32112642;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=32112645;
 //BA.debugLineNum = 32112645;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=32112648;
 //BA.debugLineNum = 32112648;BA.debugLine="vahed_ezafekari_vij=((paye+sanavat)/220)*1.8";
_vahed_ezafekari_vij = (int) ((((double)(Double.parseDouble(mostCurrent._paye))+_sanavat)/(double)220)*1.8);
RDebugUtils.currentLine=32112653;
 //BA.debugLineNum = 32112653;BA.debugLine="et_vahed_ezafekari_vij.Tag=vahed_ezafekari_vij";
mostCurrent._et_vahed_ezafekari_vij.setTag((Object)(_vahed_ezafekari_vij));
RDebugUtils.currentLine=32112654;
 //BA.debugLineNum = 32112654;BA.debugLine="et_vahed_ezafekari_vij.Text=myfunc.show_num_pool(";
mostCurrent._et_vahed_ezafekari_vij.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari_vij)));
RDebugUtils.currentLine=32112656;
 //BA.debugLineNum = 32112656;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=32702464;
 //BA.debugLineNum = 32702464;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=32702465;
 //BA.debugLineNum = 32702465;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=32702466;
 //BA.debugLineNum = 32702466;BA.debugLine="If(pan_mohasebat.Visible=True)Then";
if ((mostCurrent._pan_mohasebat.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=32702467;
 //BA.debugLineNum = 32702467;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
mostCurrent._pan_mohasebat.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=32702469;
 //BA.debugLineNum = 32702469;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
RDebugUtils.currentLine=32702472;
 //BA.debugLineNum = 32702472;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=32702474;
 //BA.debugLineNum = 32702474;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=32702476;
 //BA.debugLineNum = 32702476;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=32636928;
 //BA.debugLineNum = 32636928;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=32636930;
 //BA.debugLineNum = 32636930;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=32636931;
 //BA.debugLineNum = 32636931;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=32636933;
 //BA.debugLineNum = 32636933;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="hogog_activity";
RDebugUtils.currentLine=32571392;
 //BA.debugLineNum = 32571392;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=32571394;
 //BA.debugLineNum = 32571394;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=32505856;
 //BA.debugLineNum = 32505856;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=32505858;
 //BA.debugLineNum = 32505858;BA.debugLine="End Sub";
return "";
}
public static boolean  _check_date_iscorrect() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "check_date_iscorrect", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "check_date_iscorrect", null));}
int _y1_shamsi = 0;
int _m1_shamsi = 0;
int _d1_shamsi = 0;
int _y2_shamsi = 0;
int _m2_shamsi = 0;
int _d2_shamsi = 0;
int _rozzzz = 0;
boolean _check_date = false;
int _mah1 = 0;
RDebugUtils.currentLine=34406400;
 //BA.debugLineNum = 34406400;BA.debugLine="Sub check_date_iscorrect As Boolean";
RDebugUtils.currentLine=34406402;
 //BA.debugLineNum = 34406402;BA.debugLine="Dim y1_shamsi As Int =myfunc.fa2en( lbl_date_from";
_y1_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=34406403;
 //BA.debugLineNum = 34406403;BA.debugLine="Dim m1_shamsi As Int =myfunc.fa2en(lbl_date_from.";
_m1_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=34406404;
 //BA.debugLineNum = 34406404;BA.debugLine="Dim d1_shamsi As Int =myfunc.fa2en(lbl_date_from.";
_d1_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=34406407;
 //BA.debugLineNum = 34406407;BA.debugLine="Dim y2_shamsi As Int =myfunc.fa2en(lbl_date_to.Te";
_y2_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=34406408;
 //BA.debugLineNum = 34406408;BA.debugLine="Dim m2_shamsi As Int =myfunc.fa2en(lbl_date_to.Te";
_m2_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=34406409;
 //BA.debugLineNum = 34406409;BA.debugLine="Dim d2_shamsi As Int =myfunc.fa2en(lbl_date_to.Te";
_d2_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=34406412;
 //BA.debugLineNum = 34406412;BA.debugLine="Dim rozzzz As Int=0";
_rozzzz = (int) (0);
RDebugUtils.currentLine=34406413;
 //BA.debugLineNum = 34406413;BA.debugLine="Dim check_date As Boolean = True";
_check_date = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=34406415;
 //BA.debugLineNum = 34406415;BA.debugLine="Dim mah1 As Int=count_mah(m1_shamsi)";
_mah1 = _count_mah(_m1_shamsi);
RDebugUtils.currentLine=34406420;
 //BA.debugLineNum = 34406420;BA.debugLine="If(m2_shamsi-m1_shamsi)=0 Then";
if ((_m2_shamsi-_m1_shamsi)==0) { 
RDebugUtils.currentLine=34406421;
 //BA.debugLineNum = 34406421;BA.debugLine="rozzzz=d2_shamsi-d1_shamsi";
_rozzzz = (int) (_d2_shamsi-_d1_shamsi);
RDebugUtils.currentLine=34406422;
 //BA.debugLineNum = 34406422;BA.debugLine="If(y2_shamsi-y1_shamsi <> 0) Then";
if ((_y2_shamsi-_y1_shamsi!=0)) { 
RDebugUtils.currentLine=34406423;
 //BA.debugLineNum = 34406423;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else 
{RDebugUtils.currentLine=34406425;
 //BA.debugLineNum = 34406425;BA.debugLine="Else If (m2_shamsi-m1_shamsi)=1 Then";
if ((_m2_shamsi-_m1_shamsi)==1) { 
RDebugUtils.currentLine=34406426;
 //BA.debugLineNum = 34406426;BA.debugLine="rozzzz=(mah1-d1_shamsi) + (d2_shamsi)";
_rozzzz = (int) ((_mah1-_d1_shamsi)+(_d2_shamsi));
RDebugUtils.currentLine=34406428;
 //BA.debugLineNum = 34406428;BA.debugLine="If(y2_shamsi-y1_shamsi <> 0) Then";
if ((_y2_shamsi-_y1_shamsi!=0)) { 
RDebugUtils.currentLine=34406429;
 //BA.debugLineNum = 34406429;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else 
{RDebugUtils.currentLine=34406432;
 //BA.debugLineNum = 34406432;BA.debugLine="Else if ((m2_shamsi-m1_shamsi)=-11 ) Then";
if (((_m2_shamsi-_m1_shamsi)==-11)) { 
RDebugUtils.currentLine=34406433;
 //BA.debugLineNum = 34406433;BA.debugLine="rozzzz=(mah1-d1_shamsi) + (d2_shamsi)";
_rozzzz = (int) ((_mah1-_d1_shamsi)+(_d2_shamsi));
RDebugUtils.currentLine=34406434;
 //BA.debugLineNum = 34406434;BA.debugLine="If(y2_shamsi-y1_shamsi <> 0) Then";
if ((_y2_shamsi-_y1_shamsi!=0)) { 
RDebugUtils.currentLine=34406435;
 //BA.debugLineNum = 34406435;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else 
{RDebugUtils.currentLine=34406437;
 //BA.debugLineNum = 34406437;BA.debugLine="Else if ((m2_shamsi-m1_shamsi)>-11  And (m2_shams";
if (((_m2_shamsi-_m1_shamsi)>-11 && (_m2_shamsi-_m1_shamsi)<0)) { 
RDebugUtils.currentLine=34406438;
 //BA.debugLineNum = 34406438;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=34406440;
 //BA.debugLineNum = 34406440;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 }}}}
;
RDebugUtils.currentLine=34406444;
 //BA.debugLineNum = 34406444;BA.debugLine="If(check_date=True)Then";
if ((_check_date==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=34406445;
 //BA.debugLineNum = 34406445;BA.debugLine="If(rozzzz>31)Then";
if ((_rozzzz>31)) { 
RDebugUtils.currentLine=34406446;
 //BA.debugLineNum = 34406446;BA.debugLine="ToastMessageShow(\"تاریخ را اصلاح کنید - حداکثر";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تاریخ را اصلاح کنید - حداکثر 31 روز باشد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34406447;
 //BA.debugLineNum = 34406447;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else {
RDebugUtils.currentLine=34406450;
 //BA.debugLineNum = 34406450;BA.debugLine="ToastMessageShow(\"تاریخ را اصلاح کنید - حداکثر 3";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تاریخ را اصلاح کنید - حداکثر 31 روز باشد"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=34406454;
 //BA.debugLineNum = 34406454;BA.debugLine="Return check_date";
if (true) return _check_date;
RDebugUtils.currentLine=34406455;
 //BA.debugLineNum = 34406455;BA.debugLine="End Sub";
return false;
}
public static int  _count_mah(int _adad_mah) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "count_mah", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "count_mah", new Object[] {_adad_mah}));}
int _res = 0;
RDebugUtils.currentLine=34340864;
 //BA.debugLineNum = 34340864;BA.debugLine="Sub count_mah (adad_mah As Int) As Int";
RDebugUtils.currentLine=34340865;
 //BA.debugLineNum = 34340865;BA.debugLine="Dim res As Int=0";
_res = (int) (0);
RDebugUtils.currentLine=34340866;
 //BA.debugLineNum = 34340866;BA.debugLine="If(adad_mah<7)Then";
if ((_adad_mah<7)) { 
RDebugUtils.currentLine=34340867;
 //BA.debugLineNum = 34340867;BA.debugLine="res=31";
_res = (int) (31);
 }else {
RDebugUtils.currentLine=34340869;
 //BA.debugLineNum = 34340869;BA.debugLine="res=30";
_res = (int) (30);
 };
RDebugUtils.currentLine=34340872;
 //BA.debugLineNum = 34340872;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=34340874;
 //BA.debugLineNum = 34340874;BA.debugLine="End Sub";
return 0;
}
public static String  _et_bime_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_bime_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_bime_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=35127296;
 //BA.debugLineNum = 35127296;BA.debugLine="Private Sub et_bime_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=35127297;
 //BA.debugLineNum = 35127297;BA.debugLine="et_bime.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_bime.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=35127298;
 //BA.debugLineNum = 35127298;BA.debugLine="myfunc.change_formater(Old,New,et_bime)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_bime);
RDebugUtils.currentLine=35127299;
 //BA.debugLineNum = 35127299;BA.debugLine="End Sub";
return "";
}
public static String  _et_maliat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_maliat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_maliat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=35061760;
 //BA.debugLineNum = 35061760;BA.debugLine="Private Sub et_maliat_TextChanged (Old As String,";
RDebugUtils.currentLine=35061761;
 //BA.debugLineNum = 35061761;BA.debugLine="et_maliat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_maliat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=35061762;
 //BA.debugLineNum = 35061762;BA.debugLine="myfunc.change_formater(Old,New,et_maliat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_maliat);
RDebugUtils.currentLine=35061763;
 //BA.debugLineNum = 35061763;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_vahed_ezafekari_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_vahed_ezafekari_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=32178176;
 //BA.debugLineNum = 32178176;BA.debugLine="Private Sub et_vahed_ezafekari_TextChanged (Old As";
RDebugUtils.currentLine=32178177;
 //BA.debugLineNum = 32178177;BA.debugLine="et_vahed_ezafekari.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=32178178;
 //BA.debugLineNum = 32178178;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari);
RDebugUtils.currentLine=32178179;
 //BA.debugLineNum = 32178179;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_vij_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_vahed_ezafekari_vij_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_vahed_ezafekari_vij_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=32243712;
 //BA.debugLineNum = 32243712;BA.debugLine="Private Sub et_vahed_ezafekari_vij_TextChanged (Ol";
RDebugUtils.currentLine=32243713;
 //BA.debugLineNum = 32243713;BA.debugLine="et_vahed_ezafekari_vij.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari_vij.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=32243714;
 //BA.debugLineNum = 32243714;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari_vij);
RDebugUtils.currentLine=32243715;
 //BA.debugLineNum = 32243715;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_backto_hogog_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_backto_hogog_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_backto_hogog_click", null));}
RDebugUtils.currentLine=33292288;
 //BA.debugLineNum = 33292288;BA.debugLine="Private Sub lbl_backTo_hogog_Click";
RDebugUtils.currentLine=33292290;
 //BA.debugLineNum = 33292290;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
mostCurrent._pan_mohasebat.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33292291;
 //BA.debugLineNum = 33292291;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_from_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date_from_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date_from_click", null));}
RDebugUtils.currentLine=34078720;
 //BA.debugLineNum = 34078720;BA.debugLine="Private Sub lbl_date_from_Click";
RDebugUtils.currentLine=34078721;
 //BA.debugLineNum = 34078721;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=34078722;
 //BA.debugLineNum = 34078722;BA.debugLine="index_datePik=1";
_index_datepik = (int) (1);
RDebugUtils.currentLine=34078724;
 //BA.debugLineNum = 34078724;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_from.Text.Su";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=34078725;
 //BA.debugLineNum = 34078725;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_from.Text.Sub";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=34078726;
 //BA.debugLineNum = 34078726;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=34078727;
 //BA.debugLineNum = 34078727;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_from.Text.Sub";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=34078731;
 //BA.debugLineNum = 34078731;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_to_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date_to_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date_to_click", null));}
RDebugUtils.currentLine=34144256;
 //BA.debugLineNum = 34144256;BA.debugLine="Private Sub lbl_date_to_Click";
RDebugUtils.currentLine=34144257;
 //BA.debugLineNum = 34144257;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=34144258;
 //BA.debugLineNum = 34144258;BA.debugLine="index_datePik=2";
_index_datepik = (int) (2);
RDebugUtils.currentLine=34144260;
 //BA.debugLineNum = 34144260;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_to.Text.SubS";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=34144261;
 //BA.debugLineNum = 34144261;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_to.Text.SubSt";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=34144262;
 //BA.debugLineNum = 34144262;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=34144263;
 //BA.debugLineNum = 34144263;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_to.Text.SubSt";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=34144266;
 //BA.debugLineNum = 34144266;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_tatil_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_tatil_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_tatil_click", null));}
RDebugUtils.currentLine=33751040;
 //BA.debugLineNum = 33751040;BA.debugLine="Private Sub lbl_help_tatil_Click";
RDebugUtils.currentLine=33751042;
 //BA.debugLineNum = 33751042;BA.debugLine="myfunc.help_man(\"راهنما\",\"روزهای جمعه که برای آن";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","روزهای جمعه که برای آن روز دیگری را تعطیل نکنند، اضافه کاری فوق العاده محسوب و با ضریب 1.8 محاسبه می شود.");
RDebugUtils.currentLine=33751043;
 //BA.debugLineNum = 33751043;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_print_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_print_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_print_click", null));}
RDebugUtils.currentLine=33882112;
 //BA.debugLineNum = 33882112;BA.debugLine="Private Sub lbl_print_Click";
RDebugUtils.currentLine=33882114;
 //BA.debugLineNum = 33882114;BA.debugLine="printer.Initialize(\"\")";
mostCurrent._printer.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=33882117;
 //BA.debugLineNum = 33882117;BA.debugLine="printer.PrintWebView(\"job\",WebView2)";
mostCurrent._printer.PrintWebView("job",(android.webkit.WebView)(mostCurrent._webview2.getObject()));
RDebugUtils.currentLine=33882118;
 //BA.debugLineNum = 33882118;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_refresh_vahed_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_refresh_vahed_click", null));}
RDebugUtils.currentLine=33619968;
 //BA.debugLineNum = 33619968;BA.debugLine="Private Sub lbl_refresh_vahed_Click";
RDebugUtils.currentLine=33619969;
 //BA.debugLineNum = 33619969;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=33619970;
 //BA.debugLineNum = 33619970;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_vij_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_refresh_vahed_vij_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_refresh_vahed_vij_click", null));}
RDebugUtils.currentLine=33685504;
 //BA.debugLineNum = 33685504;BA.debugLine="Private Sub lbl_refresh_vahed_vij_Click";
RDebugUtils.currentLine=33685505;
 //BA.debugLineNum = 33685505;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
RDebugUtils.currentLine=33685506;
 //BA.debugLineNum = 33685506;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run_mohasebe_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_ezafe = null;
anywheresoftware.b4a.objects.collections.List _list_morakhasi = null;
RDebugUtils.currentLine=32833536;
 //BA.debugLineNum = 32833536;BA.debugLine="Private Sub lbl_run_mohasebe_Click";
RDebugUtils.currentLine=32833537;
 //BA.debugLineNum = 32833537;BA.debugLine="If(et_rozekari.Text=\"\")Then";
if (((mostCurrent._et_rozekari.getText()).equals(""))) { 
RDebugUtils.currentLine=32833538;
 //BA.debugLineNum = 32833538;BA.debugLine="et_rozekari.Text=0";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=32833541;
 //BA.debugLineNum = 32833541;BA.debugLine="roze_kari=et_rozekari.Text";
_roze_kari = (int)(Double.parseDouble(mostCurrent._et_rozekari.getText()));
RDebugUtils.currentLine=32833543;
 //BA.debugLineNum = 32833543;BA.debugLine="If(et_time_h.Text=\"\")Then";
if (((mostCurrent._et_time_h.getText()).equals(""))) { 
RDebugUtils.currentLine=32833544;
 //BA.debugLineNum = 32833544;BA.debugLine="et_time_h.Text=0";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=32833546;
 //BA.debugLineNum = 32833546;BA.debugLine="If(et_time_m.Text=\"\")Then";
if (((mostCurrent._et_time_m.getText()).equals(""))) { 
RDebugUtils.currentLine=32833547;
 //BA.debugLineNum = 32833547;BA.debugLine="et_time_m.Text=0";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=32833550;
 //BA.debugLineNum = 32833550;BA.debugLine="If(et_time_h_vij.Text=\"\")Then";
if (((mostCurrent._et_time_h_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=32833551;
 //BA.debugLineNum = 32833551;BA.debugLine="et_time_h_vij.Text=0";
mostCurrent._et_time_h_vij.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=32833553;
 //BA.debugLineNum = 32833553;BA.debugLine="If(et_time_m_vij.Text=\"\")Then";
if (((mostCurrent._et_time_m_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=32833554;
 //BA.debugLineNum = 32833554;BA.debugLine="et_time_m_vij.Text=0";
mostCurrent._et_time_m_vij.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=32833559;
 //BA.debugLineNum = 32833559;BA.debugLine="If(et_vahed_ezafekari.Text=\"\")Then";
if (((mostCurrent._et_vahed_ezafekari.getText()).equals(""))) { 
RDebugUtils.currentLine=32833560;
 //BA.debugLineNum = 32833560;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
 };
RDebugUtils.currentLine=32833562;
 //BA.debugLineNum = 32833562;BA.debugLine="If(et_vahed_ezafekari_vij.Text=\"\")Then";
if (((mostCurrent._et_vahed_ezafekari_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=32833563;
 //BA.debugLineNum = 32833563;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
 };
RDebugUtils.currentLine=32833567;
 //BA.debugLineNum = 32833567;BA.debugLine="If (roze_kari > 31 Or roze_kari < 0)Then";
if ((_roze_kari>31 || _roze_kari<0)) { 
RDebugUtils.currentLine=32833568;
 //BA.debugLineNum = 32833568;BA.debugLine="ToastMessageShow(\" تعداد روز کاری نادرست است\",Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" تعداد روز کاری نادرست است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=32833570;
 //BA.debugLineNum = 32833570;BA.debugLine="If(check_date_iscorrect=True)Then";
if ((_check_date_iscorrect()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=32833571;
 //BA.debugLineNum = 32833571;BA.debugLine="pan_mohasebat.Visible=True";
mostCurrent._pan_mohasebat.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=32833572;
 //BA.debugLineNum = 32833572;BA.debugLine="pan_mohasebat.SetLayoutAnimated(100,0,0,100%x,10";
mostCurrent._pan_mohasebat.SetLayoutAnimated((int) (100),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=32833573;
 //BA.debugLineNum = 32833573;BA.debugLine="mohasebe";
_mohasebe();
RDebugUtils.currentLine=32833578;
 //BA.debugLineNum = 32833578;BA.debugLine="str1.Initialize";
mostCurrent._str1.Initialize();
RDebugUtils.currentLine=32833580;
 //BA.debugLineNum = 32833580;BA.debugLine="str1.Append(\"<!DOCTYPE html><html dir='rtl' lang";
mostCurrent._str1.Append("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>");
RDebugUtils.currentLine=32833581;
 //BA.debugLineNum = 32833581;BA.debugLine="str1.Append(\"<style>table , td {border: 1px soli";
mostCurrent._str1.Append("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	summary {	font-weight: bold;	margin: -.5em -.5em 0;	padding: .5em;} details[open] {	padding: .5em;	}	details[open] summary {border-bottom: 1px solid #aaa;margin-bottom: .5em;}</style>");
RDebugUtils.currentLine=32833585;
 //BA.debugLineNum = 32833585;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=32833586;
 //BA.debugLineNum = 32833586;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=32833587;
 //BA.debugLineNum = 32833587;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+mostCurrent._sp_year.getSelectedItem()+"/"+mostCurrent._moon_num+"%';")));
RDebugUtils.currentLine=32833588;
 //BA.debugLineNum = 32833588;BA.debugLine="str1.Append(\"<h3>\").Append(\"گزارش \"& sp_moon.Se";
mostCurrent._str1.Append("<h3>").Append("گزارش "+mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())).Append("</h3>");
 }else {
RDebugUtils.currentLine=32833590;
 //BA.debugLineNum = 32833590;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FRO";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+mostCurrent._lbl_date_from.getText()+"' AND '"+mostCurrent._date2_fixed+"' ;")));
RDebugUtils.currentLine=32833591;
 //BA.debugLineNum = 32833591;BA.debugLine="str1.Append(\"<h3>\").Append(\"گزارش از تاریخ \").";
mostCurrent._str1.Append("<h3>").Append("گزارش از تاریخ ").Append(mostCurrent._lbl_date_from.getText()).Append(" تا ").Append(mostCurrent._date2_fixed).Append("</h3>");
 };
RDebugUtils.currentLine=32833600;
 //BA.debugLineNum = 32833600;BA.debugLine="str1.Append(\"نام کاربر :\").Append(\"<span> \"&Main";
mostCurrent._str1.Append("نام کاربر :").Append("<span> "+mostCurrent._main._user_namefamili /*String*/ +"</span>").Append("<br>");
RDebugUtils.currentLine=32833602;
 //BA.debugLineNum = 32833602;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5;'><details>");
RDebugUtils.currentLine=32833604;
 //BA.debugLineNum = 32833604;BA.debugLine="str1.Append(\"<summary><b> اضافه کاری های این ماه";
mostCurrent._str1.Append("<summary><b> اضافه کاری های این ماه</b></summary>");
RDebugUtils.currentLine=32833605;
 //BA.debugLineNum = 32833605;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr styl";
mostCurrent._str1.Append("<table style='width:100%;'><tr style='text-align: center;'>");
RDebugUtils.currentLine=32833606;
 //BA.debugLineNum = 32833606;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ<";
mostCurrent._str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td> <td>توضیحات</td> <br></tr>");
RDebugUtils.currentLine=32833608;
 //BA.debugLineNum = 32833608;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=32833609;
 //BA.debugLineNum = 32833609;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
mostCurrent._str1.Append("<tr style='text-align: center;'>");
RDebugUtils.currentLine=32833610;
 //BA.debugLineNum = 32833610;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
RDebugUtils.currentLine=32833611;
 //BA.debugLineNum = 32833611;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))).Append("</td>");
RDebugUtils.currentLine=32833612;
 //BA.debugLineNum = 32833612;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
RDebugUtils.currentLine=32833614;
 //BA.debugLineNum = 32833614;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=32833616;
 //BA.debugLineNum = 32833616;BA.debugLine="Dim ls_ezafe As List";
_ls_ezafe = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=32833617;
 //BA.debugLineNum = 32833617;BA.debugLine="ls_ezafe.Initialize";
_ls_ezafe.Initialize();
RDebugUtils.currentLine=32833619;
 //BA.debugLineNum = 32833619;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz2_dontDay(dbC";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
RDebugUtils.currentLine=32833622;
 //BA.debugLineNum = 32833622;BA.debugLine="str1.Append(myfunc.en2fa(ls_ezafe.Get(0)))";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_ls_ezafe.Get((int) (0)))));
RDebugUtils.currentLine=32833623;
 //BA.debugLineNum = 32833623;BA.debugLine="str1.Append(\":\")";
mostCurrent._str1.Append(":");
RDebugUtils.currentLine=32833624;
 //BA.debugLineNum = 32833624;BA.debugLine="str1.Append(myfunc.en2fa(ls_ezafe.Get(1)))";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_ls_ezafe.Get((int) (1)))));
RDebugUtils.currentLine=32833626;
 //BA.debugLineNum = 32833626;BA.debugLine="str1.Append(\"</td>\")";
mostCurrent._str1.Append("</td>");
RDebugUtils.currentLine=32833628;
 //BA.debugLineNum = 32833628;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=32833629;
 //BA.debugLineNum = 32833629;BA.debugLine="str1.Append(dbCode.res.GetString(\"tozihat\"))";
mostCurrent._str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat"));
RDebugUtils.currentLine=32833630;
 //BA.debugLineNum = 32833630;BA.debugLine="str1.Append(\"</td>\")";
mostCurrent._str1.Append("</td>");
RDebugUtils.currentLine=32833632;
 //BA.debugLineNum = 32833632;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
 }
;
RDebugUtils.currentLine=32833635;
 //BA.debugLineNum = 32833635;BA.debugLine="str1.Append(\"</table>\")";
mostCurrent._str1.Append("</table>");
RDebugUtils.currentLine=32833636;
 //BA.debugLineNum = 32833636;BA.debugLine="str1.Append(\"مجموع ساعت اضافه کاری :<span style=";
mostCurrent._str1.Append("مجموع ساعت اضافه کاری :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h.getText())+" ساعت و"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m.getText())+"دقیقه </span><br></details></div><br> ");
RDebugUtils.currentLine=32833644;
 //BA.debugLineNum = 32833644;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=32833645;
 //BA.debugLineNum = 32833645;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+mostCurrent._sp_year.getSelectedItem()+"/"+mostCurrent._moon_num+"%';")));
 }else {
RDebugUtils.currentLine=32833647;
 //BA.debugLineNum = 32833647;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from BETWEEN '"+mostCurrent._lbl_date_from.getText()+"' AND '"+mostCurrent._lbl_date_to.getText()+"' ;")));
 };
RDebugUtils.currentLine=32833651;
 //BA.debugLineNum = 32833651;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5 ;'><details>");
RDebugUtils.currentLine=32833652;
 //BA.debugLineNum = 32833652;BA.debugLine="str1.Append(\"<summary><b> مرخصی های این ماه</b><";
mostCurrent._str1.Append("<summary><b> مرخصی های این ماه</b></summary>");
RDebugUtils.currentLine=32833653;
 //BA.debugLineNum = 32833653;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr styl";
mostCurrent._str1.Append("<table style='width:100%;'><tr style='text-align: center;'>");
RDebugUtils.currentLine=32833654;
 //BA.debugLineNum = 32833654;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ<";
mostCurrent._str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b>زمان/روز</b></td><td><b> زمان/ساعت</b></td><td>توضیحات</td><br></tr>");
RDebugUtils.currentLine=32833656;
 //BA.debugLineNum = 32833656;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=32833657;
 //BA.debugLineNum = 32833657;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
mostCurrent._str1.Append("<tr style='text-align: center;'>");
RDebugUtils.currentLine=32833658;
 //BA.debugLineNum = 32833658;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
RDebugUtils.currentLine=32833659;
 //BA.debugLineNum = 32833659;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
RDebugUtils.currentLine=32833660;
 //BA.debugLineNum = 32833660;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
RDebugUtils.currentLine=32833664;
 //BA.debugLineNum = 32833664;BA.debugLine="Dim ls_ezafe As List";
_ls_ezafe = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=32833665;
 //BA.debugLineNum = 32833665;BA.debugLine="ls_ezafe.Initialize";
_ls_ezafe.Initialize();
RDebugUtils.currentLine=32833667;
 //BA.debugLineNum = 32833667;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz(dbCode.res.G";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
RDebugUtils.currentLine=32833668;
 //BA.debugLineNum = 32833668;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(ls_eza";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_ls_ezafe.Get((int) (2))))).Append("</td>");
RDebugUtils.currentLine=32833670;
 //BA.debugLineNum = 32833670;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=32833672;
 //BA.debugLineNum = 32833672;BA.debugLine="str1.Append(myfunc.en2fa(ls_ezafe.Get(0)))";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_ls_ezafe.Get((int) (0)))));
RDebugUtils.currentLine=32833673;
 //BA.debugLineNum = 32833673;BA.debugLine="str1.Append(\":\")";
mostCurrent._str1.Append(":");
RDebugUtils.currentLine=32833674;
 //BA.debugLineNum = 32833674;BA.debugLine="str1.Append(myfunc.en2fa(ls_ezafe.Get(1))).App";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_ls_ezafe.Get((int) (1))))).Append("</td>");
RDebugUtils.currentLine=32833677;
 //BA.debugLineNum = 32833677;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=32833678;
 //BA.debugLineNum = 32833678;BA.debugLine="str1.Append(dbCode.res.GetString(\"tozihat\"))";
mostCurrent._str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat"));
RDebugUtils.currentLine=32833679;
 //BA.debugLineNum = 32833679;BA.debugLine="str1.Append(\"</td>\")";
mostCurrent._str1.Append("</td>");
RDebugUtils.currentLine=32833681;
 //BA.debugLineNum = 32833681;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
 }
;
RDebugUtils.currentLine=32833686;
 //BA.debugLineNum = 32833686;BA.debugLine="str1.Append(\"</table>\")";
mostCurrent._str1.Append("</table>");
RDebugUtils.currentLine=32833688;
 //BA.debugLineNum = 32833688;BA.debugLine="Dim list_morakhasi As List";
_list_morakhasi = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=32833689;
 //BA.debugLineNum = 32833689;BA.debugLine="list_morakhasi.Initialize";
_list_morakhasi.Initialize();
RDebugUtils.currentLine=32833691;
 //BA.debugLineNum = 32833691;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=32833692;
 //BA.debugLineNum = 32833692;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(sp_year";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num);
 }else {
RDebugUtils.currentLine=32833694;
 //BA.debugLineNum = 32833694;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_byDate(lbl_";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_bydate /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._lbl_date_to.getText());
 };
RDebugUtils.currentLine=32833698;
 //BA.debugLineNum = 32833698;BA.debugLine="str1.Append(\"مجموع مرخصی ها :<span style='color:";
mostCurrent._str1.Append("مجموع مرخصی ها :<span style='color:#5E35B1;'><b> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (0))))+" روز و "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (1))))+" ساعت و "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (2))))+" دقیقه ");
RDebugUtils.currentLine=32833700;
 //BA.debugLineNum = 32833700;BA.debugLine="str1.Append(\"</b></span><br></details></div><br>";
mostCurrent._str1.Append("</b></span><br></details></div><br>");
RDebugUtils.currentLine=32833706;
 //BA.debugLineNum = 32833706;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5 ;' ><details open>");
RDebugUtils.currentLine=32833707;
 //BA.debugLineNum = 32833707;BA.debugLine="str1.Append(\"<summary><b>محاسبه حقوق</b></summar";
mostCurrent._str1.Append("<summary><b>محاسبه حقوق</b></summary>");
RDebugUtils.currentLine=32833709;
 //BA.debugLineNum = 32833709;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr>\")";
mostCurrent._str1.Append("<table style='width:100%;'><tr>");
RDebugUtils.currentLine=32833710;
 //BA.debugLineNum = 32833710;BA.debugLine="str1.Append(\"<td><div style='text-align: center;";
mostCurrent._str1.Append("<td><div style='text-align: center;color:#661400;'><b> مزایا</b></div></td>");
RDebugUtils.currentLine=32833711;
 //BA.debugLineNum = 32833711;BA.debugLine="str1.Append(\"<td><div style='text-align: center;";
mostCurrent._str1.Append("<td><div style='text-align: center;color:#661400;'><b>کسورات</b></div></td> </tr>");
RDebugUtils.currentLine=32833712;
 //BA.debugLineNum = 32833712;BA.debugLine="str1.Append(\"<tr style='vertical-align: text-top";
mostCurrent._str1.Append("<tr style='vertical-align: text-top;'><td>");
RDebugUtils.currentLine=32833713;
 //BA.debugLineNum = 32833713;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(0)&\" برای \"&myfunc";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (0)))+" برای "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_roze_kari))+" روز کاری : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_paye_end))+"</span><br>");
RDebugUtils.currentLine=32833714;
 //BA.debugLineNum = 32833714;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(2)&\" : <span style";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (2)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maskan_end))+"</span><br>");
RDebugUtils.currentLine=32833715;
 //BA.debugLineNum = 32833715;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(3)&\" : <span styl";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (3)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bon_end))+"</span><br>");
RDebugUtils.currentLine=32833716;
 //BA.debugLineNum = 32833716;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(13)&\" : <span sty";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (13)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hamsar_end))+"</span><br>");
RDebugUtils.currentLine=32833719;
 //BA.debugLineNum = 32833719;BA.debugLine="If(olad_end<>0)Then";
if ((_olad_end!=0)) { 
RDebugUtils.currentLine=32833720;
 //BA.debugLineNum = 32833720;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(4)&\"  :<span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (4)))+"  :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad_end))+"</span><br>");
 };
RDebugUtils.currentLine=32833722;
 //BA.debugLineNum = 32833722;BA.debugLine="If(sanavat_end<>0)Then";
if ((_sanavat_end!=0)) { 
RDebugUtils.currentLine=32833723;
 //BA.debugLineNum = 32833723;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(1)&\"  : <span sty";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (1)))+"  : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat_end))+"</span><br>");
 };
RDebugUtils.currentLine=32833725;
 //BA.debugLineNum = 32833725;BA.debugLine="If(fani_end<>0)Then";
if ((_fani_end!=0)) { 
RDebugUtils.currentLine=32833726;
 //BA.debugLineNum = 32833726;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(5)&\" : <span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (5)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_fani_end))+"</span><br>");
 };
RDebugUtils.currentLine=32833728;
 //BA.debugLineNum = 32833728;BA.debugLine="If(masoliat_end<>0)Then";
if ((_masoliat_end!=0)) { 
RDebugUtils.currentLine=32833729;
 //BA.debugLineNum = 32833729;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(6)&\" : <span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (6)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_masoliat_end))+"</span><br>");
 };
RDebugUtils.currentLine=32833731;
 //BA.debugLineNum = 32833731;BA.debugLine="If(sarparasti_end<>0)Then";
if ((_sarparasti_end!=0)) { 
RDebugUtils.currentLine=32833732;
 //BA.debugLineNum = 32833732;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(7)&\" : <span sty";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (7)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sarparasti_end))+"</span><br>");
 };
RDebugUtils.currentLine=32833734;
 //BA.debugLineNum = 32833734;BA.debugLine="If(shift_end<>0)Then";
if ((_shift_end!=0)) { 
RDebugUtils.currentLine=32833735;
 //BA.debugLineNum = 32833735;BA.debugLine="str1.Append(\" حق شیفت \"&myfunc.en2fa(shift)&\" د";
mostCurrent._str1.Append(" حق شیفت "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_shift))+" درصد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_shift_end))+"</span><br>");
 };
RDebugUtils.currentLine=32833739;
 //BA.debugLineNum = 32833739;BA.debugLine="If(dbCode.get_setting_byName(\"tog_padash\")=1)Th";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_padash")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32833740;
 //BA.debugLineNum = 32833740;BA.debugLine="If(padash_all<>0)Then";
if ((_padash_all!=0)) { 
RDebugUtils.currentLine=32833741;
 //BA.debugLineNum = 32833741;BA.debugLine="str1.Append(\"  پاداش : <span style='color:#5E";
mostCurrent._str1.Append("  پاداش : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_padash_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=32833745;
 //BA.debugLineNum = 32833745;BA.debugLine="If(dbCode.get_setting_byName(\"tog_food\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32833746;
 //BA.debugLineNum = 32833746;BA.debugLine="If(food_1_all<>0)Then";
if ((_food_1_all!=0)) { 
RDebugUtils.currentLine=32833747;
 //BA.debugLineNum = 32833747;BA.debugLine="str1.Append(\" هزینه غذا: <span style='color:#";
mostCurrent._str1.Append(" هزینه غذا: <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_food_1_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=32833751;
 //BA.debugLineNum = 32833751;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)The";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32833752;
 //BA.debugLineNum = 32833752;BA.debugLine="If(sayer_1_all<>0)Then";
if ((_sayer_1_all!=0)) { 
RDebugUtils.currentLine=32833753;
 //BA.debugLineNum = 32833753;BA.debugLine="str1.Append(\"  سایر: <span style='color:#5E35";
mostCurrent._str1.Append("  سایر: <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sayer_1_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=32833757;
 //BA.debugLineNum = 32833757;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32833758;
 //BA.debugLineNum = 32833758;BA.debugLine="If(ayab_1_all<>0)Then";
if ((_ayab_1_all!=0)) { 
RDebugUtils.currentLine=32833759;
 //BA.debugLineNum = 32833759;BA.debugLine="str1.Append(\" ایاب ذهاب: <span style='color:#";
mostCurrent._str1.Append(" ایاب ذهاب: <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ayab_1_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=32833764;
 //BA.debugLineNum = 32833764;BA.debugLine="If(mazaya_end<>0)Then";
if ((_mazaya_end!=0)) { 
RDebugUtils.currentLine=32833765;
 //BA.debugLineNum = 32833765;BA.debugLine="str1.Append(\"  \"&ls_onvanHa.Get(10)&\" : <span";
mostCurrent._str1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (10)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya_end))+"</span><br>");
 };
RDebugUtils.currentLine=32833774;
 //BA.debugLineNum = 32833774;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=32833775;
 //BA.debugLineNum = 32833775;BA.debugLine="str1.Append(\"اضافه کاری عادی\").Append(\"<br>\")";
mostCurrent._str1.Append("اضافه کاری عادی").Append("<br>");
RDebugUtils.currentLine=32833777;
 //BA.debugLineNum = 32833777;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B";
mostCurrent._str1.Append(" ساعات : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h.getText())+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m.getText())+"</span><br>");
RDebugUtils.currentLine=32833779;
 //BA.debugLineNum = 32833779;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5";
mostCurrent._str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_vahed_ezafekari))+"</span><br>");
RDebugUtils.currentLine=32833785;
 //BA.debugLineNum = 32833785;BA.debugLine="If(ezafekari_end_vij<>0)Then";
if ((_ezafekari_end_vij!=0)) { 
RDebugUtils.currentLine=32833786;
 //BA.debugLineNum = 32833786;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=32833788;
 //BA.debugLineNum = 32833788;BA.debugLine="str1.Append(\"اضافه کاری <span style='color:#ff4d";
mostCurrent._str1.Append("اضافه کاری <span style='color:#ff4d00;'>"+"فوق العاده"+"</span>").Append("<br>");
RDebugUtils.currentLine=32833790;
 //BA.debugLineNum = 32833790;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B1";
mostCurrent._str1.Append(" ساعات : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h_vij.getText())+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m_vij.getText())+"</span><br>");
RDebugUtils.currentLine=32833793;
 //BA.debugLineNum = 32833793;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5E";
mostCurrent._str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_vahed_ezafekari_vij))+"</span><br>");
 };
RDebugUtils.currentLine=32833797;
 //BA.debugLineNum = 32833797;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=32833798;
 //BA.debugLineNum = 32833798;BA.debugLine="str1.Append(\"مجموع اضافه کاری : <span style='col";
mostCurrent._str1.Append("مجموع اضافه کاری : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool((int) (_ezafekari_end+_ezafekari_end_vij)))+"</span><br></td>");
RDebugUtils.currentLine=32833801;
 //BA.debugLineNum = 32833801;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=32833804;
 //BA.debugLineNum = 32833804;BA.debugLine="str1.Append(\"بیمه تامین اجتماعی : <span style='";
mostCurrent._str1.Append("بیمه تامین اجتماعی : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_tamin_end))+"</span><br>");
RDebugUtils.currentLine=32833807;
 //BA.debugLineNum = 32833807;BA.debugLine="If(bime_takmil<>0)Then";
if ((_bime_takmil!=0)) { 
RDebugUtils.currentLine=32833808;
 //BA.debugLineNum = 32833808;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(9)&\" :<span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (9)))+" :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_takmil))+"</span><br>");
 };
RDebugUtils.currentLine=32833813;
 //BA.debugLineNum = 32833813;BA.debugLine="If(maliat_end<>0)Then";
if ((_maliat_end!=0)) { 
RDebugUtils.currentLine=32833814;
 //BA.debugLineNum = 32833814;BA.debugLine="str1.Append(\" مالیات : <span style='color:#5E3";
mostCurrent._str1.Append(" مالیات : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maliat_end))+"</span><br>");
 };
RDebugUtils.currentLine=32833818;
 //BA.debugLineNum = 32833818;BA.debugLine="If(dbCode.get_setting_byName(\"tog_mosaede\")=1)Th";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_mosaede")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32833819;
 //BA.debugLineNum = 32833819;BA.debugLine="If(mosaedeh_all<>0)Then";
if ((_mosaedeh_all!=0)) { 
RDebugUtils.currentLine=32833820;
 //BA.debugLineNum = 32833820;BA.debugLine="str1.Append(\" مساعده : <span style='color:#5E3";
mostCurrent._str1.Append(" مساعده : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mosaedeh_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=32833824;
 //BA.debugLineNum = 32833824;BA.debugLine="If(dbCode.get_setting_byName(\"tog_food\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32833825;
 //BA.debugLineNum = 32833825;BA.debugLine="If(food_2_all<>0)Then";
if ((_food_2_all!=0)) { 
RDebugUtils.currentLine=32833826;
 //BA.debugLineNum = 32833826;BA.debugLine="str1.Append(\" هزینه غذا : <span style='color:";
mostCurrent._str1.Append(" هزینه غذا : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_food_2_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=32833831;
 //BA.debugLineNum = 32833831;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)The";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32833832;
 //BA.debugLineNum = 32833832;BA.debugLine="If(sayer_2_all<>0)Then";
if ((_sayer_2_all!=0)) { 
RDebugUtils.currentLine=32833833;
 //BA.debugLineNum = 32833833;BA.debugLine="str1.Append(\" سایر : <span style='color:#5E35";
mostCurrent._str1.Append(" سایر : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sayer_2_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=32833837;
 //BA.debugLineNum = 32833837;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32833838;
 //BA.debugLineNum = 32833838;BA.debugLine="If(ayab_2_all<>0)Then";
if ((_ayab_2_all!=0)) { 
RDebugUtils.currentLine=32833839;
 //BA.debugLineNum = 32833839;BA.debugLine="str1.Append(\" ایاب ذهاب : <span style='color:";
mostCurrent._str1.Append(" ایاب ذهاب : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ayab_2_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=32833843;
 //BA.debugLineNum = 32833843;BA.debugLine="If(dbCode.get_setting_byName(\"tog_vam\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_vam")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32833844;
 //BA.debugLineNum = 32833844;BA.debugLine="If(gest_vam<>0)Then";
if ((_gest_vam!=0)) { 
RDebugUtils.currentLine=32833845;
 //BA.debugLineNum = 32833845;BA.debugLine="str1.Append(\" قسط وام  : <span style='color:#";
mostCurrent._str1.Append(" قسط وام  : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_gest_vam))+"</span><br>");
 };
 };
RDebugUtils.currentLine=32833853;
 //BA.debugLineNum = 32833853;BA.debugLine="If(ksorat<>0)Then";
if ((_ksorat!=0)) { 
RDebugUtils.currentLine=32833854;
 //BA.debugLineNum = 32833854;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(11)&\" : <span st";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (11)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat))+"</span></td>");
 };
RDebugUtils.currentLine=32833857;
 //BA.debugLineNum = 32833857;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
RDebugUtils.currentLine=32833859;
 //BA.debugLineNum = 32833859;BA.debugLine="str1.Append(\"<tr><td>\")";
mostCurrent._str1.Append("<tr><td>");
RDebugUtils.currentLine=32833860;
 //BA.debugLineNum = 32833860;BA.debugLine="str1.Append(\"جمع مزایا :  <span style='color:#5E";
mostCurrent._str1.Append("جمع مزایا :  <span style='color:#5E35B1;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_nakhales))+"</b></span>");
RDebugUtils.currentLine=32833861;
 //BA.debugLineNum = 32833861;BA.debugLine="str1.Append(\"</td><td>\")";
mostCurrent._str1.Append("</td><td>");
RDebugUtils.currentLine=32833863;
 //BA.debugLineNum = 32833863;BA.debugLine="str1.Append(\"جمع کسورات :  <span style='color:#5";
mostCurrent._str1.Append("جمع کسورات :  <span style='color:#5E35B1;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_jame_kosorat))+"</b></span>");
RDebugUtils.currentLine=32833864;
 //BA.debugLineNum = 32833864;BA.debugLine="str1.Append(\"</td></tr></table><br>\")";
mostCurrent._str1.Append("</td></tr></table><br>");
RDebugUtils.currentLine=32833866;
 //BA.debugLineNum = 32833866;BA.debugLine="str1.Append(\" دریافتی خالص :  <span style='color";
mostCurrent._str1.Append(" دریافتی خالص :  <span style='color:#388E3C;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_khales))+" </b></span></b>");
RDebugUtils.currentLine=32833867;
 //BA.debugLineNum = 32833867;BA.debugLine="str1.Append(\"<span style='font-size: 11px;'> توم";
mostCurrent._str1.Append("<span style='font-size: 11px;'> تومان </span>");
RDebugUtils.currentLine=32833869;
 //BA.debugLineNum = 32833869;BA.debugLine="str1.Append(\"<br></details></div>\")";
mostCurrent._str1.Append("<br></details></div>");
RDebugUtils.currentLine=32833871;
 //BA.debugLineNum = 32833871;BA.debugLine="str1.Append(\"<footer style=' text-align: center;";
mostCurrent._str1.Append("<footer style=' text-align: center; '><h6> اپلیکیشن اضافه کاری من </h6></footer>");
RDebugUtils.currentLine=32833873;
 //BA.debugLineNum = 32833873;BA.debugLine="str1.Append(\"</body></html>\")";
mostCurrent._str1.Append("</body></html>");
RDebugUtils.currentLine=32833875;
 //BA.debugLineNum = 32833875;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=32833876;
 //BA.debugLineNum = 32833876;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=32833881;
 //BA.debugLineNum = 32833881;BA.debugLine="WebView2.LoadHtml(str1.ToString)";
mostCurrent._webview2.LoadHtml(mostCurrent._str1.ToString());
 };
 };
RDebugUtils.currentLine=32833886;
 //BA.debugLineNum = 32833886;BA.debugLine="End Sub";
return "";
}
public static String  _mohasebe() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mohasebe", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "mohasebe", null));}
int _hogog_nakhales_maliaty = 0;
int _nak_mal = 0;
RDebugUtils.currentLine=32899072;
 //BA.debugLineNum = 32899072;BA.debugLine="Sub mohasebe";
RDebugUtils.currentLine=32899076;
 //BA.debugLineNum = 32899076;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=32899079;
 //BA.debugLineNum = 32899079;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=32899086;
 //BA.debugLineNum = 32899086;BA.debugLine="If (roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=32899087;
 //BA.debugLineNum = 32899087;BA.debugLine="maskan_end=(maskan/30)*roze_kari";
_maskan_end = (int) ((_maskan/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=32899089;
 //BA.debugLineNum = 32899089;BA.debugLine="maskan_end=maskan";
_maskan_end = _maskan;
 };
RDebugUtils.currentLine=32899094;
 //BA.debugLineNum = 32899094;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=32899095;
 //BA.debugLineNum = 32899095;BA.debugLine="bon_end=(bon/30)*roze_kari";
_bon_end = (int) ((_bon/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=32899097;
 //BA.debugLineNum = 32899097;BA.debugLine="bon_end=bon";
_bon_end = _bon;
 };
RDebugUtils.currentLine=32899102;
 //BA.debugLineNum = 32899102;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=32899103;
 //BA.debugLineNum = 32899103;BA.debugLine="hamsar_end=(hamsar/30)*roze_kari";
_hamsar_end = (int) ((_hamsar/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=32899105;
 //BA.debugLineNum = 32899105;BA.debugLine="hamsar_end=hamsar";
_hamsar_end = _hamsar;
 };
RDebugUtils.currentLine=32899111;
 //BA.debugLineNum = 32899111;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=32899112;
 //BA.debugLineNum = 32899112;BA.debugLine="olad_end=(olad/30)*roze_kari";
_olad_end = (int) ((_olad/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=32899114;
 //BA.debugLineNum = 32899114;BA.debugLine="olad_end=olad";
_olad_end = _olad;
 };
RDebugUtils.currentLine=32899119;
 //BA.debugLineNum = 32899119;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=32899120;
 //BA.debugLineNum = 32899120;BA.debugLine="fani_end=(fani/30)*roze_kari";
_fani_end = (int) ((_fani/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=32899122;
 //BA.debugLineNum = 32899122;BA.debugLine="fani_end=fani";
_fani_end = _fani;
 };
RDebugUtils.currentLine=32899126;
 //BA.debugLineNum = 32899126;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=32899127;
 //BA.debugLineNum = 32899127;BA.debugLine="masoliat_end=(masoliat/30)*roze_kari";
_masoliat_end = (int) ((_masoliat/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=32899129;
 //BA.debugLineNum = 32899129;BA.debugLine="masoliat_end=masoliat";
_masoliat_end = _masoliat;
 };
RDebugUtils.currentLine=32899133;
 //BA.debugLineNum = 32899133;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=32899134;
 //BA.debugLineNum = 32899134;BA.debugLine="sarparasti_end=(sarparasti/30)*roze_kari";
_sarparasti_end = (int) ((_sarparasti/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=32899136;
 //BA.debugLineNum = 32899136;BA.debugLine="sarparasti_end=sarparasti";
_sarparasti_end = _sarparasti;
 };
RDebugUtils.currentLine=32899140;
 //BA.debugLineNum = 32899140;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=32899141;
 //BA.debugLineNum = 32899141;BA.debugLine="mazaya_end=(mazaya/30)*roze_kari";
_mazaya_end = (int) ((_mazaya/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=32899143;
 //BA.debugLineNum = 32899143;BA.debugLine="mazaya_end=mazaya";
_mazaya_end = _mazaya;
 };
RDebugUtils.currentLine=32899147;
 //BA.debugLineNum = 32899147;BA.debugLine="shift_end=((paye_end+sanavat_end)*shift)/100";
_shift_end = (int) (((_paye_end+_sanavat_end)*_shift)/(double)100);
RDebugUtils.currentLine=32899150;
 //BA.debugLineNum = 32899150;BA.debugLine="vahed_ezafekari=et_vahed_ezafekari.Tag";
_vahed_ezafekari = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari.getTag()));
RDebugUtils.currentLine=32899151;
 //BA.debugLineNum = 32899151;BA.debugLine="ezafekari_end=vahed_ezafekari*(et_time_h.Text+(et";
_ezafekari_end = (int) (_vahed_ezafekari*((double)(Double.parseDouble(mostCurrent._et_time_h.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m.getText()))/(double)60)));
RDebugUtils.currentLine=32899155;
 //BA.debugLineNum = 32899155;BA.debugLine="vahed_ezafekari_vij=et_vahed_ezafekari_vij.Tag";
_vahed_ezafekari_vij = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari_vij.getTag()));
RDebugUtils.currentLine=32899156;
 //BA.debugLineNum = 32899156;BA.debugLine="ezafekari_end_vij=vahed_ezafekari_vij*(et_time_h_";
_ezafekari_end_vij = (int) (_vahed_ezafekari_vij*((double)(Double.parseDouble(mostCurrent._et_time_h_vij.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m_vij.getText()))/(double)60)));
RDebugUtils.currentLine=32899161;
 //BA.debugLineNum = 32899161;BA.debugLine="If(dbCode.get_setting_byName(\"tog_mosaede\")=1)The";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_mosaede")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32899162;
 //BA.debugLineNum = 32899162;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=32899163;
 //BA.debugLineNum = 32899163;BA.debugLine="mosaedeh_all=dbCode.all_mosaedeh_mah(sp_year.Se";
_mosaedeh_all = mostCurrent._dbcode._all_mosaedeh_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 }else {
RDebugUtils.currentLine=32899165;
 //BA.debugLineNum = 32899165;BA.debugLine="mosaedeh_all=dbCode.all_mosaedeh_byDate(lbl_dat";
_mosaedeh_all = mostCurrent._dbcode._all_mosaedeh_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed);
 };
 };
RDebugUtils.currentLine=32899170;
 //BA.debugLineNum = 32899170;BA.debugLine="If(dbCode.get_setting_byName(\"tog_food\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32899171;
 //BA.debugLineNum = 32899171;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=32899172;
 //BA.debugLineNum = 32899172;BA.debugLine="food_1_all=dbCode.all_food_mah(sp_year.Selected";
_food_1_all = mostCurrent._dbcode._all_food_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
RDebugUtils.currentLine=32899173;
 //BA.debugLineNum = 32899173;BA.debugLine="food_2_all=dbCode.all_food_mah(sp_year.Selected";
_food_2_all = mostCurrent._dbcode._all_food_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (2));
 }else {
RDebugUtils.currentLine=32899175;
 //BA.debugLineNum = 32899175;BA.debugLine="food_1_all=dbCode.all_food_byDate(lbl_date_from";
_food_1_all = mostCurrent._dbcode._all_food_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (1));
RDebugUtils.currentLine=32899176;
 //BA.debugLineNum = 32899176;BA.debugLine="food_2_all=dbCode.all_food_byDate(lbl_date_from";
_food_2_all = mostCurrent._dbcode._all_food_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (2));
 };
 };
RDebugUtils.currentLine=32899182;
 //BA.debugLineNum = 32899182;BA.debugLine="If(dbCode.get_setting_byName(\"tog_padash\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_padash")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32899183;
 //BA.debugLineNum = 32899183;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=32899184;
 //BA.debugLineNum = 32899184;BA.debugLine="padash_all=dbCode.all_padash_mah(sp_year.Select";
_padash_all = mostCurrent._dbcode._all_padash_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 }else {
RDebugUtils.currentLine=32899186;
 //BA.debugLineNum = 32899186;BA.debugLine="padash_all=dbCode.all_padash_byDate(lbl_date_fr";
_padash_all = mostCurrent._dbcode._all_padash_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed);
 };
 };
RDebugUtils.currentLine=32899192;
 //BA.debugLineNum = 32899192;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32899193;
 //BA.debugLineNum = 32899193;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=32899194;
 //BA.debugLineNum = 32899194;BA.debugLine="sayer_1_all=dbCode.all_sayer_mah(sp_year.Select";
_sayer_1_all = mostCurrent._dbcode._all_sayer_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
RDebugUtils.currentLine=32899195;
 //BA.debugLineNum = 32899195;BA.debugLine="sayer_2_all=dbCode.all_sayer_mah(sp_year.Select";
_sayer_2_all = mostCurrent._dbcode._all_sayer_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (2));
 }else {
RDebugUtils.currentLine=32899197;
 //BA.debugLineNum = 32899197;BA.debugLine="sayer_1_all=dbCode.all_sayer_byDate(lbl_date_fr";
_sayer_1_all = mostCurrent._dbcode._all_sayer_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (1));
RDebugUtils.currentLine=32899198;
 //BA.debugLineNum = 32899198;BA.debugLine="sayer_2_all=dbCode.all_sayer_byDate(lbl_date_fr";
_sayer_2_all = mostCurrent._dbcode._all_sayer_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (2));
 };
 };
RDebugUtils.currentLine=32899204;
 //BA.debugLineNum = 32899204;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32899205;
 //BA.debugLineNum = 32899205;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=32899206;
 //BA.debugLineNum = 32899206;BA.debugLine="ayab_1_all=dbCode.all_ayabZahab_mah(sp_year.Sel";
_ayab_1_all = mostCurrent._dbcode._all_ayabzahab_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
RDebugUtils.currentLine=32899207;
 //BA.debugLineNum = 32899207;BA.debugLine="ayab_2_all=dbCode.all_ayabZahab_mah(sp_year.Sel";
_ayab_2_all = mostCurrent._dbcode._all_ayabzahab_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (2));
 }else {
RDebugUtils.currentLine=32899209;
 //BA.debugLineNum = 32899209;BA.debugLine="ayab_1_all=dbCode.all_ayabZahab_byDate(lbl_date";
_ayab_1_all = mostCurrent._dbcode._all_ayabzahab_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (1));
RDebugUtils.currentLine=32899210;
 //BA.debugLineNum = 32899210;BA.debugLine="ayab_2_all=dbCode.all_ayabZahab_byDate(lbl_date";
_ayab_2_all = mostCurrent._dbcode._all_ayabzahab_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (2));
 };
 };
RDebugUtils.currentLine=32899215;
 //BA.debugLineNum = 32899215;BA.debugLine="If(dbCode.get_setting_byName(\"tog_vam\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_vam")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32899216;
 //BA.debugLineNum = 32899216;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=32899217;
 //BA.debugLineNum = 32899217;BA.debugLine="gest_vam=dbCode.all_gestVam_mah(sp_year.Selecte";
_gest_vam = mostCurrent._dbcode._all_gestvam_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 }else {
RDebugUtils.currentLine=32899219;
 //BA.debugLineNum = 32899219;BA.debugLine="gest_vam=dbCode.all_gestVam_byDate(date2_fixed.";
_gest_vam = mostCurrent._dbcode._all_gestvam_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._date2_fixed.substring((int) (0),(int) (7)));
 };
 };
RDebugUtils.currentLine=32899227;
 //BA.debugLineNum = 32899227;BA.debugLine="hogog_nakhales=paye_end+ezafekari_end+ezafekari_e";
_hogog_nakhales = (int) (_paye_end+_ezafekari_end+_ezafekari_end_vij+_maskan_end+_bon_end+_hamsar_end+_olad_end+_fani_end+_masoliat_end+_sarparasti_end+_sanavat_end+_mazaya_end+_shift_end+_padash_all+_food_1_all+_sayer_1_all+_ayab_1_all);
RDebugUtils.currentLine=32899230;
 //BA.debugLineNum = 32899230;BA.debugLine="Dim hogog_nakhales_maliaty As Int";
_hogog_nakhales_maliaty = 0;
RDebugUtils.currentLine=32899232;
 //BA.debugLineNum = 32899232;BA.debugLine="hogog_nakhales_maliaty=paye_end+ezafekari_end+eza";
_hogog_nakhales_maliaty = (int) (_paye_end+_ezafekari_end+_ezafekari_end_vij+_maskan_end+_bon_end+_hamsar_end+_olad_end+_fani_end+_masoliat_end+_sarparasti_end+_sanavat_end+_mazaya_end+_shift_end);
RDebugUtils.currentLine=32899236;
 //BA.debugLineNum = 32899236;BA.debugLine="If(dbCode.get_setting_byName(\"tog_bime\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_bime")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32899237;
 //BA.debugLineNum = 32899237;BA.debugLine="bime_tamin_end=(hogog_nakhales_maliaty-olad_end)";
_bime_tamin_end = (int) ((_hogog_nakhales_maliaty-_olad_end)*0.07);
 }else {
RDebugUtils.currentLine=32899241;
 //BA.debugLineNum = 32899241;BA.debugLine="If(et_bime.Tag=\"\")Then";
if (((mostCurrent._et_bime.getTag()).equals((Object)("")))) { 
RDebugUtils.currentLine=32899242;
 //BA.debugLineNum = 32899242;BA.debugLine="bime_tamin_end=0";
_bime_tamin_end = (int) (0);
RDebugUtils.currentLine=32899243;
 //BA.debugLineNum = 32899243;BA.debugLine="et_bime.Text=0";
mostCurrent._et_bime.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=32899244;
 //BA.debugLineNum = 32899244;BA.debugLine="et_bime.Tag=0";
mostCurrent._et_bime.setTag((Object)(0));
 }else {
RDebugUtils.currentLine=32899246;
 //BA.debugLineNum = 32899246;BA.debugLine="bime_tamin_end=et_bime.Tag";
_bime_tamin_end = (int)(BA.ObjectToNumber(mostCurrent._et_bime.getTag()));
 };
 };
RDebugUtils.currentLine=32899254;
 //BA.debugLineNum = 32899254;BA.debugLine="Dim nak_mal As Int";
_nak_mal = 0;
RDebugUtils.currentLine=32899255;
 //BA.debugLineNum = 32899255;BA.debugLine="nak_mal=hogog_nakhales_maliaty-((bime_tamin_end*2";
_nak_mal = (int) (_hogog_nakhales_maliaty-((_bime_tamin_end*2)/(double)7));
RDebugUtils.currentLine=32899258;
 //BA.debugLineNum = 32899258;BA.debugLine="If(dbCode.get_setting_byName(\"tog_maliat\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_maliat")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=32899260;
 //BA.debugLineNum = 32899260;BA.debugLine="maliat_end=mohasebe_maliat(nak_mal,sp_year.Selec";
_maliat_end = _mohasebe_maliat(_nak_mal,(int)(Double.parseDouble(mostCurrent._sp_year.getSelectedItem())));
 }else {
RDebugUtils.currentLine=32899265;
 //BA.debugLineNum = 32899265;BA.debugLine="If(et_maliat.Tag=\"\")Then";
if (((mostCurrent._et_maliat.getTag()).equals((Object)("")))) { 
RDebugUtils.currentLine=32899266;
 //BA.debugLineNum = 32899266;BA.debugLine="maliat_end=0";
_maliat_end = (int) (0);
RDebugUtils.currentLine=32899267;
 //BA.debugLineNum = 32899267;BA.debugLine="et_maliat.Text=0";
mostCurrent._et_maliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=32899268;
 //BA.debugLineNum = 32899268;BA.debugLine="et_maliat.Tag=0";
mostCurrent._et_maliat.setTag((Object)(0));
 }else {
RDebugUtils.currentLine=32899270;
 //BA.debugLineNum = 32899270;BA.debugLine="maliat_end=et_maliat.Tag";
_maliat_end = (int)(BA.ObjectToNumber(mostCurrent._et_maliat.getTag()));
 };
 };
RDebugUtils.currentLine=32899277;
 //BA.debugLineNum = 32899277;BA.debugLine="jame_kosorat=bime_tamin_end+maliat_end+bime_takmi";
_jame_kosorat = (int) (_bime_tamin_end+_maliat_end+_bime_takmil+_ksorat+_mosaedeh_all+_food_2_all+_sayer_2_all+_ayab_2_all+_gest_vam);
RDebugUtils.currentLine=32899279;
 //BA.debugLineNum = 32899279;BA.debugLine="hogog_khales=hogog_nakhales-jame_kosorat";
_hogog_khales = (int) (_hogog_nakhales-_jame_kosorat);
RDebugUtils.currentLine=32899281;
 //BA.debugLineNum = 32899281;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_gozaresh_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_gozaresh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_gozaresh_click", null));}
RDebugUtils.currentLine=33161216;
 //BA.debugLineNum = 33161216;BA.debugLine="Private Sub lbl_save_gozaresh_Click";
RDebugUtils.currentLine=33161217;
 //BA.debugLineNum = 33161217;BA.debugLine="et_name_gozaresh.Text=sp_moon.SelectedItem&\" \"&sp";
mostCurrent._et_name_gozaresh.setText(BA.ObjectToCharSequence(mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._sp_year.getSelectedItem()));
RDebugUtils.currentLine=33161218;
 //BA.debugLineNum = 33161218;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=33161219;
 //BA.debugLineNum = 33161219;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_gozaresh_end_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_gozaresh_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_gozaresh_end_click", null));}
RDebugUtils.currentLine=33423360;
 //BA.debugLineNum = 33423360;BA.debugLine="Private Sub lbl_save_gozaresh_end_Click";
RDebugUtils.currentLine=33423361;
 //BA.debugLineNum = 33423361;BA.debugLine="save_gozaresh";
_save_gozaresh();
RDebugUtils.currentLine=33423362;
 //BA.debugLineNum = 33423362;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33423363;
 //BA.debugLineNum = 33423363;BA.debugLine="End Sub";
return "";
}
public static String  _save_gozaresh() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "save_gozaresh", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "save_gozaresh", null));}
boolean _chek = false;
anywheresoftware.b4a.objects.collections.List _alist = null;
RDebugUtils.currentLine=33226752;
 //BA.debugLineNum = 33226752;BA.debugLine="Sub save_gozaresh";
RDebugUtils.currentLine=33226755;
 //BA.debugLineNum = 33226755;BA.debugLine="Dim chek As Boolean";
_chek = false;
RDebugUtils.currentLine=33226756;
 //BA.debugLineNum = 33226756;BA.debugLine="chek=myfunc.check_karid";
_chek = mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=33226757;
 //BA.debugLineNum = 33226757;BA.debugLine="Dim alist As List";
_alist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=33226758;
 //BA.debugLineNum = 33226758;BA.debugLine="alist.Initialize";
_alist.Initialize();
RDebugUtils.currentLine=33226760;
 //BA.debugLineNum = 33226760;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(Main.persianDa";
_alist = mostCurrent._myfunc._num_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())),BA.NumberToString(01));
RDebugUtils.currentLine=33226763;
 //BA.debugLineNum = 33226763;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=33226764;
 //BA.debugLineNum = 33226764;BA.debugLine="If(alist.Get(2)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (2))))<5)) { 
RDebugUtils.currentLine=33226765;
 //BA.debugLineNum = 33226765;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDa";
mostCurrent._dbcode._add_gozaresh /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),mostCurrent._et_name_gozaresh.getText(),mostCurrent._et_tozih_gozaresh.getText(),mostCurrent._str1.ToString(),BA.NumberToString(_hogog_nakhales),BA.NumberToString(_hogog_khales));
RDebugUtils.currentLine=33226766;
 //BA.debugLineNum = 33226766;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("گزارش ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=33226768;
 //BA.debugLineNum = 33226768;BA.debugLine="Main.buy_index=1";
mostCurrent._main._buy_index /*int*/  = (int) (1);
RDebugUtils.currentLine=33226770;
 //BA.debugLineNum = 33226770;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=33226771;
 //BA.debugLineNum = 33226771;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
 };
 }else {
RDebugUtils.currentLine=33226775;
 //BA.debugLineNum = 33226775;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDat";
mostCurrent._dbcode._add_gozaresh /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),mostCurrent._et_name_gozaresh.getText(),mostCurrent._et_tozih_gozaresh.getText(),mostCurrent._str1.ToString(),BA.NumberToString(_hogog_nakhales),BA.NumberToString(_hogog_khales));
RDebugUtils.currentLine=33226776;
 //BA.debugLineNum = 33226776;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("گزارش ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=33226781;
 //BA.debugLineNum = 33226781;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_picker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_picker_click", null));}
RDebugUtils.currentLine=34275328;
 //BA.debugLineNum = 34275328;BA.debugLine="Private Sub lbl_save_picker_Click";
RDebugUtils.currentLine=34275330;
 //BA.debugLineNum = 34275330;BA.debugLine="If(index_datePik=1) Then";
if ((_index_datepik==1)) { 
RDebugUtils.currentLine=34275331;
 //BA.debugLineNum = 34275331;BA.debugLine="lbl_date_from.Text=pik_year1.Text&\"/\"&myfunc.con";
mostCurrent._lbl_date_from.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 }else 
{RDebugUtils.currentLine=34275333;
 //BA.debugLineNum = 34275333;BA.debugLine="Else If(index_datePik=2) Then";
if ((_index_datepik==2)) { 
RDebugUtils.currentLine=34275334;
 //BA.debugLineNum = 34275334;BA.debugLine="lbl_date_to.Text=pik_year1.Text&\"/\"&myfunc.conve";
mostCurrent._lbl_date_to.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=34275335;
 //BA.debugLineNum = 34275335;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
 }}
;
RDebugUtils.currentLine=34275338;
 //BA.debugLineNum = 34275338;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=34275340;
 //BA.debugLineNum = 34275340;BA.debugLine="et_rozekari.Text=myfunc.time_mohasebe(lbl_date_fr";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._time_mohasebe /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed)));
RDebugUtils.currentLine=34275341;
 //BA.debugLineNum = 34275341;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34275343;
 //BA.debugLineNum = 34275343;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_share_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_share_click", null));}
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
RDebugUtils.currentLine=33816576;
 //BA.debugLineNum = 33816576;BA.debugLine="Private Sub lbl_share_Click";
RDebugUtils.currentLine=33816577;
 //BA.debugLineNum = 33816577;BA.debugLine="Dim FileName As String =Main.current_gozaresh_id&";
_filename = BA.NumberToString(mostCurrent._main._current_gozaresh_id /*int*/ )+".html";
RDebugUtils.currentLine=33816580;
 //BA.debugLineNum = 33816580;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
anywheresoftware.b4a.keywords.Common.File.WriteString(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename,mostCurrent._str1.ToString());
RDebugUtils.currentLine=33816582;
 //BA.debugLineNum = 33816582;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=33816583;
 //BA.debugLineNum = 33816583;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
RDebugUtils.currentLine=33816584;
 //BA.debugLineNum = 33816584;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
RDebugUtils.currentLine=33816585;
 //BA.debugLineNum = 33816585;BA.debugLine="email.Body = \" گزارش حقوق \"&str1.ToString&CRLF&\"ا";
_email.Body = " گزارش حقوق "+mostCurrent._str1.ToString()+anywheresoftware.b4a.keywords.Common.CRLF+"اپلیکیشن اضافه کاری من"+anywheresoftware.b4a.keywords.Common.CRLF+"دانلود از بازار";
RDebugUtils.currentLine=33816586;
 //BA.debugLineNum = 33816586;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (null,_filename));
RDebugUtils.currentLine=33816588;
 //BA.debugLineNum = 33816588;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
RDebugUtils.currentLine=33816589;
 //BA.debugLineNum = 33816589;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
RDebugUtils.currentLine=33816590;
 //BA.debugLineNum = 33816590;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
RDebugUtils.currentLine=33816591;
 //BA.debugLineNum = 33816591;BA.debugLine="End Sub";
return "";
}
public static int  _mohasebe_maliat(int _hogog,int _year) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mohasebe_maliat", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "mohasebe_maliat", new Object[] {_hogog,_year}));}
int _all_maliat = 0;
int _state1 = 0;
int _state2 = 0;
int _state3 = 0;
int _state4 = 0;
int _state5 = 0;
int _state6 = 0;
RDebugUtils.currentLine=32964608;
 //BA.debugLineNum = 32964608;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
RDebugUtils.currentLine=32964609;
 //BA.debugLineNum = 32964609;BA.debugLine="Dim all_maliat As Int=0";
_all_maliat = (int) (0);
RDebugUtils.currentLine=32964610;
 //BA.debugLineNum = 32964610;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
RDebugUtils.currentLine=32964611;
 //BA.debugLineNum = 32964611;BA.debugLine="Dim state2 As Int=0";
_state2 = (int) (0);
RDebugUtils.currentLine=32964612;
 //BA.debugLineNum = 32964612;BA.debugLine="Dim state3 As Int=0";
_state3 = (int) (0);
RDebugUtils.currentLine=32964613;
 //BA.debugLineNum = 32964613;BA.debugLine="Dim state4 As Int=0";
_state4 = (int) (0);
RDebugUtils.currentLine=32964614;
 //BA.debugLineNum = 32964614;BA.debugLine="Dim state5 As Int=0";
_state5 = (int) (0);
RDebugUtils.currentLine=32964615;
 //BA.debugLineNum = 32964615;BA.debugLine="Dim state6 As Int=0";
_state6 = (int) (0);
RDebugUtils.currentLine=32964617;
 //BA.debugLineNum = 32964617;BA.debugLine="If (year=1399)Then";
if ((_year==1399)) { 
RDebugUtils.currentLine=32964618;
 //BA.debugLineNum = 32964618;BA.debugLine="If(hogog>3000001 And hogog<7500001)Then	  ''----";
if ((_hogog>3000001 && _hogog<7500001)) { 
RDebugUtils.currentLine=32964619;
 //BA.debugLineNum = 32964619;BA.debugLine="state1=(hogog-3000000)*0.1";
_state1 = (int) ((_hogog-3000000)*0.1);
 };
RDebugUtils.currentLine=32964621;
 //BA.debugLineNum = 32964621;BA.debugLine="If(hogog>7500001 And hogog<10500001)Then	  ''---";
if ((_hogog>7500001 && _hogog<10500001)) { 
RDebugUtils.currentLine=32964622;
 //BA.debugLineNum = 32964622;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=32964623;
 //BA.debugLineNum = 32964623;BA.debugLine="state2=(hogog-7500000)*0.15";
_state2 = (int) ((_hogog-7500000)*0.15);
 };
RDebugUtils.currentLine=32964625;
 //BA.debugLineNum = 32964625;BA.debugLine="If(hogog>10500001 And hogog<15000001)Then	  ''--";
if ((_hogog>10500001 && _hogog<15000001)) { 
RDebugUtils.currentLine=32964626;
 //BA.debugLineNum = 32964626;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=32964627;
 //BA.debugLineNum = 32964627;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=32964628;
 //BA.debugLineNum = 32964628;BA.debugLine="state3=(hogog-10500000)*0.2";
_state3 = (int) ((_hogog-10500000)*0.2);
 };
RDebugUtils.currentLine=32964630;
 //BA.debugLineNum = 32964630;BA.debugLine="If(hogog>15000001)Then	  ''-----stat4";
if ((_hogog>15000001)) { 
RDebugUtils.currentLine=32964631;
 //BA.debugLineNum = 32964631;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=32964632;
 //BA.debugLineNum = 32964632;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=32964633;
 //BA.debugLineNum = 32964633;BA.debugLine="state3=(4500000)*0.2";
_state3 = (int) ((4500000)*0.2);
RDebugUtils.currentLine=32964634;
 //BA.debugLineNum = 32964634;BA.debugLine="state4=(hogog-15000001)*0.25";
_state4 = (int) ((_hogog-15000001)*0.25);
 };
 };
RDebugUtils.currentLine=32964638;
 //BA.debugLineNum = 32964638;BA.debugLine="If (year=1400)Then";
if ((_year==1400)) { 
RDebugUtils.currentLine=32964639;
 //BA.debugLineNum = 32964639;BA.debugLine="If(hogog>4000001 And hogog<8000001)Then	  ''----";
if ((_hogog>4000001 && _hogog<8000001)) { 
RDebugUtils.currentLine=32964640;
 //BA.debugLineNum = 32964640;BA.debugLine="state1=(hogog-4000000)*0.1";
_state1 = (int) ((_hogog-4000000)*0.1);
 };
RDebugUtils.currentLine=32964642;
 //BA.debugLineNum = 32964642;BA.debugLine="If(hogog>8000001 And hogog<12000001)Then	  ''---";
if ((_hogog>8000001 && _hogog<12000001)) { 
RDebugUtils.currentLine=32964643;
 //BA.debugLineNum = 32964643;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=32964644;
 //BA.debugLineNum = 32964644;BA.debugLine="state2=(hogog-8000000)*0.15";
_state2 = (int) ((_hogog-8000000)*0.15);
 };
RDebugUtils.currentLine=32964646;
 //BA.debugLineNum = 32964646;BA.debugLine="If(hogog>12000001 And hogog<18000001)Then	  ''--";
if ((_hogog>12000001 && _hogog<18000001)) { 
RDebugUtils.currentLine=32964647;
 //BA.debugLineNum = 32964647;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=32964648;
 //BA.debugLineNum = 32964648;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=32964649;
 //BA.debugLineNum = 32964649;BA.debugLine="state3=(hogog-12000000)*0.2";
_state3 = (int) ((_hogog-12000000)*0.2);
 };
RDebugUtils.currentLine=32964651;
 //BA.debugLineNum = 32964651;BA.debugLine="If(hogog>18000001 And hogog<24000001)Then	  ''--";
if ((_hogog>18000001 && _hogog<24000001)) { 
RDebugUtils.currentLine=32964652;
 //BA.debugLineNum = 32964652;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=32964653;
 //BA.debugLineNum = 32964653;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=32964654;
 //BA.debugLineNum = 32964654;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=32964655;
 //BA.debugLineNum = 32964655;BA.debugLine="state4=(hogog-18000000)*0.25";
_state4 = (int) ((_hogog-18000000)*0.25);
 };
RDebugUtils.currentLine=32964657;
 //BA.debugLineNum = 32964657;BA.debugLine="If(hogog>24000001 And hogog<32000001)Then	  ''--";
if ((_hogog>24000001 && _hogog<32000001)) { 
RDebugUtils.currentLine=32964658;
 //BA.debugLineNum = 32964658;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=32964659;
 //BA.debugLineNum = 32964659;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=32964660;
 //BA.debugLineNum = 32964660;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=32964661;
 //BA.debugLineNum = 32964661;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=32964662;
 //BA.debugLineNum = 32964662;BA.debugLine="state5=(hogog-24000000)*0.3";
_state5 = (int) ((_hogog-24000000)*0.3);
 };
RDebugUtils.currentLine=32964664;
 //BA.debugLineNum = 32964664;BA.debugLine="If(hogog>32000001)Then	  ''-----stat4";
if ((_hogog>32000001)) { 
RDebugUtils.currentLine=32964665;
 //BA.debugLineNum = 32964665;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=32964666;
 //BA.debugLineNum = 32964666;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=32964667;
 //BA.debugLineNum = 32964667;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=32964668;
 //BA.debugLineNum = 32964668;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=32964669;
 //BA.debugLineNum = 32964669;BA.debugLine="state5=(6000000)*0.3";
_state5 = (int) ((6000000)*0.3);
RDebugUtils.currentLine=32964670;
 //BA.debugLineNum = 32964670;BA.debugLine="state6=(hogog-32000000)*0.35";
_state6 = (int) ((_hogog-32000000)*0.35);
 };
 };
RDebugUtils.currentLine=32964674;
 //BA.debugLineNum = 32964674;BA.debugLine="If (year=1401)Then";
if ((_year==1401)) { 
RDebugUtils.currentLine=32964675;
 //BA.debugLineNum = 32964675;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
if ((_hogog>5600001 && _hogog<12500001)) { 
RDebugUtils.currentLine=32964676;
 //BA.debugLineNum = 32964676;BA.debugLine="state1=(hogog-5600000)*0.1";
_state1 = (int) ((_hogog-5600000)*0.1);
 };
RDebugUtils.currentLine=32964678;
 //BA.debugLineNum = 32964678;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
if ((_hogog>12500001 && _hogog<20830001)) { 
RDebugUtils.currentLine=32964679;
 //BA.debugLineNum = 32964679;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=32964680;
 //BA.debugLineNum = 32964680;BA.debugLine="state2=(hogog-12500000)*0.15";
_state2 = (int) ((_hogog-12500000)*0.15);
 };
RDebugUtils.currentLine=32964682;
 //BA.debugLineNum = 32964682;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
if ((_hogog>20830001 && _hogog<29160001)) { 
RDebugUtils.currentLine=32964683;
 //BA.debugLineNum = 32964683;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=32964684;
 //BA.debugLineNum = 32964684;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=32964685;
 //BA.debugLineNum = 32964685;BA.debugLine="state3=(hogog-20830000)*0.2";
_state3 = (int) ((_hogog-20830000)*0.2);
 };
RDebugUtils.currentLine=32964688;
 //BA.debugLineNum = 32964688;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
if ((_hogog>29160001)) { 
RDebugUtils.currentLine=32964689;
 //BA.debugLineNum = 32964689;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=32964690;
 //BA.debugLineNum = 32964690;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=32964691;
 //BA.debugLineNum = 32964691;BA.debugLine="state3=(8330000)*0.2";
_state3 = (int) ((8330000)*0.2);
RDebugUtils.currentLine=32964693;
 //BA.debugLineNum = 32964693;BA.debugLine="state4=(hogog-29160000)*0.3";
_state4 = (int) ((_hogog-29160000)*0.3);
 };
 };
RDebugUtils.currentLine=32964698;
 //BA.debugLineNum = 32964698;BA.debugLine="If (year=1402)Then";
if ((_year==1402)) { 
RDebugUtils.currentLine=32964699;
 //BA.debugLineNum = 32964699;BA.debugLine="If(hogog>10000001 And hogog<14000001)Then	  ''--";
if ((_hogog>10000001 && _hogog<14000001)) { 
RDebugUtils.currentLine=32964700;
 //BA.debugLineNum = 32964700;BA.debugLine="state1=(hogog-10000000)*0.1";
_state1 = (int) ((_hogog-10000000)*0.1);
 };
RDebugUtils.currentLine=32964702;
 //BA.debugLineNum = 32964702;BA.debugLine="If(hogog>14000001 And hogog<23000001)Then	  ''--";
if ((_hogog>14000001 && _hogog<23000001)) { 
RDebugUtils.currentLine=32964703;
 //BA.debugLineNum = 32964703;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=32964704;
 //BA.debugLineNum = 32964704;BA.debugLine="state2=(hogog-14000000)*0.15";
_state2 = (int) ((_hogog-14000000)*0.15);
 };
RDebugUtils.currentLine=32964706;
 //BA.debugLineNum = 32964706;BA.debugLine="If(hogog>23000001 And hogog<34000001)Then	  ''--";
if ((_hogog>23000001 && _hogog<34000001)) { 
RDebugUtils.currentLine=32964707;
 //BA.debugLineNum = 32964707;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=32964708;
 //BA.debugLineNum = 32964708;BA.debugLine="state2=(9000000)*0.15";
_state2 = (int) ((9000000)*0.15);
RDebugUtils.currentLine=32964709;
 //BA.debugLineNum = 32964709;BA.debugLine="state3=(hogog-23000000)*0.2";
_state3 = (int) ((_hogog-23000000)*0.2);
 };
RDebugUtils.currentLine=32964712;
 //BA.debugLineNum = 32964712;BA.debugLine="If(hogog>34000001)Then	  ''-----stat4";
if ((_hogog>34000001)) { 
RDebugUtils.currentLine=32964713;
 //BA.debugLineNum = 32964713;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=32964714;
 //BA.debugLineNum = 32964714;BA.debugLine="state2=(9000000)*0.15";
_state2 = (int) ((9000000)*0.15);
RDebugUtils.currentLine=32964715;
 //BA.debugLineNum = 32964715;BA.debugLine="state3=(11000000)*0.2";
_state3 = (int) ((11000000)*0.2);
RDebugUtils.currentLine=32964717;
 //BA.debugLineNum = 32964717;BA.debugLine="state4=(hogog-34000001)*0.3";
_state4 = (int) ((_hogog-34000001)*0.3);
 };
 };
RDebugUtils.currentLine=32964723;
 //BA.debugLineNum = 32964723;BA.debugLine="If (year=1403)Then";
if ((_year==1403)) { 
RDebugUtils.currentLine=32964724;
 //BA.debugLineNum = 32964724;BA.debugLine="If(hogog>12000001 And hogog<16500001)Then	  ''--";
if ((_hogog>12000001 && _hogog<16500001)) { 
RDebugUtils.currentLine=32964725;
 //BA.debugLineNum = 32964725;BA.debugLine="state1=(hogog-12000000)*0.1";
_state1 = (int) ((_hogog-12000000)*0.1);
 };
RDebugUtils.currentLine=32964727;
 //BA.debugLineNum = 32964727;BA.debugLine="If(hogog>16500001 And hogog<27000001)Then	  ''--";
if ((_hogog>16500001 && _hogog<27000001)) { 
RDebugUtils.currentLine=32964728;
 //BA.debugLineNum = 32964728;BA.debugLine="state1=(4500000)*0.1";
_state1 = (int) ((4500000)*0.1);
RDebugUtils.currentLine=32964729;
 //BA.debugLineNum = 32964729;BA.debugLine="state2=(hogog-16500000)*0.15";
_state2 = (int) ((_hogog-16500000)*0.15);
 };
RDebugUtils.currentLine=32964731;
 //BA.debugLineNum = 32964731;BA.debugLine="If(hogog>27000001 And hogog<40000001)Then	  ''--";
if ((_hogog>27000001 && _hogog<40000001)) { 
RDebugUtils.currentLine=32964732;
 //BA.debugLineNum = 32964732;BA.debugLine="state1=(4500000)*0.1";
_state1 = (int) ((4500000)*0.1);
RDebugUtils.currentLine=32964733;
 //BA.debugLineNum = 32964733;BA.debugLine="state2=(10500000)*0.15";
_state2 = (int) ((10500000)*0.15);
RDebugUtils.currentLine=32964734;
 //BA.debugLineNum = 32964734;BA.debugLine="state3=(hogog-27000000)*0.2";
_state3 = (int) ((_hogog-27000000)*0.2);
 };
RDebugUtils.currentLine=32964737;
 //BA.debugLineNum = 32964737;BA.debugLine="If(hogog>40000001)Then	  ''-----stat4";
if ((_hogog>40000001)) { 
RDebugUtils.currentLine=32964738;
 //BA.debugLineNum = 32964738;BA.debugLine="state1=(4500000)*0.1";
_state1 = (int) ((4500000)*0.1);
RDebugUtils.currentLine=32964739;
 //BA.debugLineNum = 32964739;BA.debugLine="state2=(10500000)*0.15";
_state2 = (int) ((10500000)*0.15);
RDebugUtils.currentLine=32964740;
 //BA.debugLineNum = 32964740;BA.debugLine="state3=(13000000)*0.2";
_state3 = (int) ((13000000)*0.2);
RDebugUtils.currentLine=32964742;
 //BA.debugLineNum = 32964742;BA.debugLine="state4=(hogog-40000001)*0.3";
_state4 = (int) ((_hogog-40000001)*0.3);
 };
 };
RDebugUtils.currentLine=32964751;
 //BA.debugLineNum = 32964751;BA.debugLine="If (year=1404)Then";
if ((_year==1404)) { 
RDebugUtils.currentLine=32964752;
 //BA.debugLineNum = 32964752;BA.debugLine="If(hogog>24000001 And hogog<30000001)Then	  ''--";
if ((_hogog>24000001 && _hogog<30000001)) { 
RDebugUtils.currentLine=32964753;
 //BA.debugLineNum = 32964753;BA.debugLine="state1=(hogog-24000000)*0.1";
_state1 = (int) ((_hogog-24000000)*0.1);
 };
RDebugUtils.currentLine=32964755;
 //BA.debugLineNum = 32964755;BA.debugLine="If(hogog>30000001 And hogog<38000001)Then	  ''--";
if ((_hogog>30000001 && _hogog<38000001)) { 
RDebugUtils.currentLine=32964756;
 //BA.debugLineNum = 32964756;BA.debugLine="state1=(6000000)*0.1";
_state1 = (int) ((6000000)*0.1);
RDebugUtils.currentLine=32964757;
 //BA.debugLineNum = 32964757;BA.debugLine="state2=(hogog-30000000)*0.15";
_state2 = (int) ((_hogog-30000000)*0.15);
 };
RDebugUtils.currentLine=32964759;
 //BA.debugLineNum = 32964759;BA.debugLine="If(hogog>38000001 And hogog<50000001)Then	  ''--";
if ((_hogog>38000001 && _hogog<50000001)) { 
RDebugUtils.currentLine=32964760;
 //BA.debugLineNum = 32964760;BA.debugLine="state1=(6000000)*0.1";
_state1 = (int) ((6000000)*0.1);
RDebugUtils.currentLine=32964761;
 //BA.debugLineNum = 32964761;BA.debugLine="state2=(8000000)*0.15";
_state2 = (int) ((8000000)*0.15);
RDebugUtils.currentLine=32964762;
 //BA.debugLineNum = 32964762;BA.debugLine="state3=(hogog-38000000)*0.2";
_state3 = (int) ((_hogog-38000000)*0.2);
 };
RDebugUtils.currentLine=32964765;
 //BA.debugLineNum = 32964765;BA.debugLine="If(hogog>50000001 And hogog<66700001)Then	  ''--";
if ((_hogog>50000001 && _hogog<66700001)) { 
RDebugUtils.currentLine=32964766;
 //BA.debugLineNum = 32964766;BA.debugLine="state1=(6000000)*0.1";
_state1 = (int) ((6000000)*0.1);
RDebugUtils.currentLine=32964767;
 //BA.debugLineNum = 32964767;BA.debugLine="state2=(8000000)*0.15";
_state2 = (int) ((8000000)*0.15);
RDebugUtils.currentLine=32964768;
 //BA.debugLineNum = 32964768;BA.debugLine="state3=(12000000)*0.2";
_state3 = (int) ((12000000)*0.2);
RDebugUtils.currentLine=32964769;
 //BA.debugLineNum = 32964769;BA.debugLine="state4=(hogog-50000001)*0.25";
_state4 = (int) ((_hogog-50000001)*0.25);
 };
RDebugUtils.currentLine=32964771;
 //BA.debugLineNum = 32964771;BA.debugLine="If(hogog>66700001)Then	  ''-----stat5";
if ((_hogog>66700001)) { 
RDebugUtils.currentLine=32964772;
 //BA.debugLineNum = 32964772;BA.debugLine="state1=(6000000)*0.1";
_state1 = (int) ((6000000)*0.1);
RDebugUtils.currentLine=32964773;
 //BA.debugLineNum = 32964773;BA.debugLine="state2=(8000000)*0.15";
_state2 = (int) ((8000000)*0.15);
RDebugUtils.currentLine=32964774;
 //BA.debugLineNum = 32964774;BA.debugLine="state3=(12000000)*0.2";
_state3 = (int) ((12000000)*0.2);
RDebugUtils.currentLine=32964775;
 //BA.debugLineNum = 32964775;BA.debugLine="state4=(16700000)*0.25";
_state4 = (int) ((16700000)*0.25);
RDebugUtils.currentLine=32964776;
 //BA.debugLineNum = 32964776;BA.debugLine="state5=(hogog-66700001)*0.3";
_state5 = (int) ((_hogog-66700001)*0.3);
 };
 };
RDebugUtils.currentLine=32964793;
 //BA.debugLineNum = 32964793;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
_all_maliat = (int) (_state1+_state2+_state3+_state4+_state5+_state6);
RDebugUtils.currentLine=32964794;
 //BA.debugLineNum = 32964794;BA.debugLine="Return all_maliat";
if (true) return _all_maliat;
RDebugUtils.currentLine=32964796;
 //BA.debugLineNum = 32964796;BA.debugLine="End Sub";
return 0;
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=33554432;
 //BA.debugLineNum = 33554432;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=33554433;
 //BA.debugLineNum = 33554433;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33554434;
 //BA.debugLineNum = 33554434;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_set_date_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_set_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_set_date_click", null));}
RDebugUtils.currentLine=34209792;
 //BA.debugLineNum = 34209792;BA.debugLine="Private Sub pan_all_set_date_Click";
RDebugUtils.currentLine=34209793;
 //BA.debugLineNum = 34209793;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34209794;
 //BA.debugLineNum = 34209794;BA.debugLine="End Sub";
return "";
}
public static String  _pan_mohasebat_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_mohasebat_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_mohasebat_click", null));}
RDebugUtils.currentLine=33357824;
 //BA.debugLineNum = 33357824;BA.debugLine="Private Sub pan_mohasebat_Click";
RDebugUtils.currentLine=33357826;
 //BA.debugLineNum = 33357826;BA.debugLine="End Sub";
return "";
}
public static String  _panel7_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel7_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel7_click", null));}
RDebugUtils.currentLine=33488896;
 //BA.debugLineNum = 33488896;BA.debugLine="Private Sub Panel7_Click";
RDebugUtils.currentLine=33488898;
 //BA.debugLineNum = 33488898;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=34930688;
 //BA.debugLineNum = 34930688;BA.debugLine="Private Sub pik_day_bala1_Click";
RDebugUtils.currentLine=34930689;
 //BA.debugLineNum = 34930689;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=34930690;
 //BA.debugLineNum = 34930690;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=34930693;
 //BA.debugLineNum = 34930693;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=34930694;
 //BA.debugLineNum = 34930694;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=34930695;
 //BA.debugLineNum = 34930695;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=34930697;
 //BA.debugLineNum = 34930697;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=34930698;
 //BA.debugLineNum = 34930698;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=34930701;
 //BA.debugLineNum = 34930701;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=34930702;
 //BA.debugLineNum = 34930702;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=34930704;
 //BA.debugLineNum = 34930704;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=34930705;
 //BA.debugLineNum = 34930705;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=34930708;
 //BA.debugLineNum = 34930708;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=34930709;
 //BA.debugLineNum = 34930709;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=34996224;
 //BA.debugLineNum = 34996224;BA.debugLine="Private Sub pik_day_paeen1_Click";
RDebugUtils.currentLine=34996225;
 //BA.debugLineNum = 34996225;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=34996226;
 //BA.debugLineNum = 34996226;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=34996227;
 //BA.debugLineNum = 34996227;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=34996228;
 //BA.debugLineNum = 34996228;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=34996229;
 //BA.debugLineNum = 34996229;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=34996231;
 //BA.debugLineNum = 34996231;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=34996232;
 //BA.debugLineNum = 34996232;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=34996235;
 //BA.debugLineNum = 34996235;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=34996236;
 //BA.debugLineNum = 34996236;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=34996238;
 //BA.debugLineNum = 34996238;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=34996239;
 //BA.debugLineNum = 34996239;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=34996242;
 //BA.debugLineNum = 34996242;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=34996243;
 //BA.debugLineNum = 34996243;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=34668544;
 //BA.debugLineNum = 34668544;BA.debugLine="Private Sub pik_moon_bala1_Click";
RDebugUtils.currentLine=34668545;
 //BA.debugLineNum = 34668545;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=34668546;
 //BA.debugLineNum = 34668546;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
RDebugUtils.currentLine=34668548;
 //BA.debugLineNum = 34668548;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=34668549;
 //BA.debugLineNum = 34668549;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=34668551;
 //BA.debugLineNum = 34668551;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=34668552;
 //BA.debugLineNum = 34668552;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=34668554;
 //BA.debugLineNum = 34668554;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=34668556;
 //BA.debugLineNum = 34668556;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=34734080;
 //BA.debugLineNum = 34734080;BA.debugLine="Private Sub pik_moon_paeen1_Click";
RDebugUtils.currentLine=34734081;
 //BA.debugLineNum = 34734081;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=34734082;
 //BA.debugLineNum = 34734082;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
RDebugUtils.currentLine=34734084;
 //BA.debugLineNum = 34734084;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=34734085;
 //BA.debugLineNum = 34734085;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=34734087;
 //BA.debugLineNum = 34734087;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=34734088;
 //BA.debugLineNum = 34734088;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=34734090;
 //BA.debugLineNum = 34734090;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
RDebugUtils.currentLine=34734092;
 //BA.debugLineNum = 34734092;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_day1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_day1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=34603008;
 //BA.debugLineNum = 34603008;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
RDebugUtils.currentLine=34603009;
 //BA.debugLineNum = 34603009;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=34603010;
 //BA.debugLineNum = 34603010;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=34603011;
 //BA.debugLineNum = 34603011;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=34603014;
 //BA.debugLineNum = 34603014;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=34603016;
 //BA.debugLineNum = 34603016;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=34603017;
 //BA.debugLineNum = 34603017;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
RDebugUtils.currentLine=34603018;
 //BA.debugLineNum = 34603018;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=34603019;
 //BA.debugLineNum = 34603019;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=34603021;
 //BA.debugLineNum = 34603021;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=34603022;
 //BA.debugLineNum = 34603022;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
RDebugUtils.currentLine=34603023;
 //BA.debugLineNum = 34603023;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=34603024;
 //BA.debugLineNum = 34603024;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=34603027;
 //BA.debugLineNum = 34603027;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=34603028;
 //BA.debugLineNum = 34603028;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=34603029;
 //BA.debugLineNum = 34603029;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=34603031;
 //BA.debugLineNum = 34603031;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=34603032;
 //BA.debugLineNum = 34603032;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=34603035;
 //BA.debugLineNum = 34603035;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=34603036;
 //BA.debugLineNum = 34603036;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=34603038;
 //BA.debugLineNum = 34603038;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=34603039;
 //BA.debugLineNum = 34603039;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=34603042;
 //BA.debugLineNum = 34603042;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 };
RDebugUtils.currentLine=34603046;
 //BA.debugLineNum = 34603046;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_moon1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_moon1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=34471936;
 //BA.debugLineNum = 34471936;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
RDebugUtils.currentLine=34471937;
 //BA.debugLineNum = 34471937;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=34471938;
 //BA.debugLineNum = 34471938;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=34471939;
 //BA.debugLineNum = 34471939;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=34471942;
 //BA.debugLineNum = 34471942;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=34471944;
 //BA.debugLineNum = 34471944;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=34471945;
 //BA.debugLineNum = 34471945;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
RDebugUtils.currentLine=34471946;
 //BA.debugLineNum = 34471946;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=34471947;
 //BA.debugLineNum = 34471947;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=34471949;
 //BA.debugLineNum = 34471949;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=34471950;
 //BA.debugLineNum = 34471950;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
RDebugUtils.currentLine=34471951;
 //BA.debugLineNum = 34471951;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=34471952;
 //BA.debugLineNum = 34471952;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=34471955;
 //BA.debugLineNum = 34471955;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=34471956;
 //BA.debugLineNum = 34471956;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=34471958;
 //BA.debugLineNum = 34471958;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=34471959;
 //BA.debugLineNum = 34471959;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=34471961;
 //BA.debugLineNum = 34471961;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
RDebugUtils.currentLine=34471964;
 //BA.debugLineNum = 34471964;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_year1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_year1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=34537472;
 //BA.debugLineNum = 34537472;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
RDebugUtils.currentLine=34537473;
 //BA.debugLineNum = 34537473;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=34537474;
 //BA.debugLineNum = 34537474;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=34537475;
 //BA.debugLineNum = 34537475;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=34537478;
 //BA.debugLineNum = 34537478;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=34537480;
 //BA.debugLineNum = 34537480;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=34537481;
 //BA.debugLineNum = 34537481;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
RDebugUtils.currentLine=34537482;
 //BA.debugLineNum = 34537482;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=34537483;
 //BA.debugLineNum = 34537483;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=34537485;
 //BA.debugLineNum = 34537485;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=34537486;
 //BA.debugLineNum = 34537486;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
RDebugUtils.currentLine=34537487;
 //BA.debugLineNum = 34537487;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=34537488;
 //BA.debugLineNum = 34537488;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=34537491;
 //BA.debugLineNum = 34537491;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=34537492;
 //BA.debugLineNum = 34537492;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=34537494;
 //BA.debugLineNum = 34537494;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=34537495;
 //BA.debugLineNum = 34537495;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
RDebugUtils.currentLine=34537500;
 //BA.debugLineNum = 34537500;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=34799616;
 //BA.debugLineNum = 34799616;BA.debugLine="Private Sub pik_year_bala1_Click";
RDebugUtils.currentLine=34799617;
 //BA.debugLineNum = 34799617;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=34799618;
 //BA.debugLineNum = 34799618;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=34799620;
 //BA.debugLineNum = 34799620;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=34799621;
 //BA.debugLineNum = 34799621;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=34799623;
 //BA.debugLineNum = 34799623;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=34799624;
 //BA.debugLineNum = 34799624;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=34799627;
 //BA.debugLineNum = 34799627;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=34865152;
 //BA.debugLineNum = 34865152;BA.debugLine="Private Sub pik_year_paeen1_Click";
RDebugUtils.currentLine=34865153;
 //BA.debugLineNum = 34865153;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=34865154;
 //BA.debugLineNum = 34865154;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=34865156;
 //BA.debugLineNum = 34865156;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=34865157;
 //BA.debugLineNum = 34865157;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=34865159;
 //BA.debugLineNum = 34865159;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=34865160;
 //BA.debugLineNum = 34865160;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=34865163;
 //BA.debugLineNum = 34865163;BA.debugLine="End Sub";
return "";
}
public static String  _radio_type1_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "radio_type1_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "radio_type1_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=34013184;
 //BA.debugLineNum = 34013184;BA.debugLine="Private Sub radio_type1_CheckedChange(Checked As B";
RDebugUtils.currentLine=34013185;
 //BA.debugLineNum = 34013185;BA.debugLine="sp_moon.Enabled=True";
mostCurrent._sp_moon.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=34013186;
 //BA.debugLineNum = 34013186;BA.debugLine="sp_year.Enabled=True";
mostCurrent._sp_year.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=34013187;
 //BA.debugLineNum = 34013187;BA.debugLine="lbl_date_from.Enabled=False";
mostCurrent._lbl_date_from.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34013188;
 //BA.debugLineNum = 34013188;BA.debugLine="lbl_date_to.Enabled=False";
mostCurrent._lbl_date_to.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34013189;
 //BA.debugLineNum = 34013189;BA.debugLine="type_mohasebe=1";
_type_mohasebe = (int) (1);
RDebugUtils.currentLine=34013190;
 //BA.debugLineNum = 34013190;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
RDebugUtils.currentLine=34013191;
 //BA.debugLineNum = 34013191;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=34013192;
 //BA.debugLineNum = 34013192;BA.debugLine="End Sub";
return "";
}
public static String  _radio_type2_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "radio_type2_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "radio_type2_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=33947648;
 //BA.debugLineNum = 33947648;BA.debugLine="Private Sub radio_type2_CheckedChange(Checked As B";
RDebugUtils.currentLine=33947649;
 //BA.debugLineNum = 33947649;BA.debugLine="sp_moon.Enabled=False";
mostCurrent._sp_moon.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33947650;
 //BA.debugLineNum = 33947650;BA.debugLine="sp_year.Enabled=False";
mostCurrent._sp_year.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=33947651;
 //BA.debugLineNum = 33947651;BA.debugLine="lbl_date_from.Enabled=True";
mostCurrent._lbl_date_from.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=33947652;
 //BA.debugLineNum = 33947652;BA.debugLine="lbl_date_to.Enabled=True";
mostCurrent._lbl_date_to.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=33947653;
 //BA.debugLineNum = 33947653;BA.debugLine="type_mohasebe=2";
_type_mohasebe = (int) (2);
RDebugUtils.currentLine=33947654;
 //BA.debugLineNum = 33947654;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
RDebugUtils.currentLine=33947655;
 //BA.debugLineNum = 33947655;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=33947656;
 //BA.debugLineNum = 33947656;BA.debugLine="End Sub";
return "";
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_moon_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_moon_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=33030144;
 //BA.debugLineNum = 33030144;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=33030145;
 //BA.debugLineNum = 33030145;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=33030147;
 //BA.debugLineNum = 33030147;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=33095680;
 //BA.debugLineNum = 33095680;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=33095681;
 //BA.debugLineNum = 33095681;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=33095682;
 //BA.debugLineNum = 33095682;BA.debugLine="End Sub";
return "";
}
public static String  _time_page_load_tick() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time_page_load_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "time_page_load_tick", null));}
RDebugUtils.currentLine=32309248;
 //BA.debugLineNum = 32309248;BA.debugLine="Sub time_page_load_Tick";
RDebugUtils.currentLine=32309249;
 //BA.debugLineNum = 32309249;BA.debugLine="pan_load.Visible=False";
mostCurrent._pan_load.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=32309250;
 //BA.debugLineNum = 32309250;BA.debugLine="B4XLoadingIndicator1.Hide";
mostCurrent._b4xloadingindicator1._hide /*String*/ (null);
RDebugUtils.currentLine=32309251;
 //BA.debugLineNum = 32309251;BA.debugLine="Main.time_page_load.Enabled=False";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=32309252;
 //BA.debugLineNum = 32309252;BA.debugLine="End Sub";
return "";
}
}