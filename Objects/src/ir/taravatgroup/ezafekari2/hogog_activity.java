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
public anywheresoftware.b4a.objects.PanelWrapper _pan_paen = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_maliat = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_bime = null;
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
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.mosaedeh_activity _mosaedeh_activity = null;
public ir.taravatgroup.ezafekari2.padash_activity _padash_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
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
RDebugUtils.currentLine=20578304;
 //BA.debugLineNum = 20578304;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=20578306;
 //BA.debugLineNum = 20578306;BA.debugLine="Activity.LoadLayout(\"hogog_layout\")";
mostCurrent._activity.LoadLayout("hogog_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=20578307;
 //BA.debugLineNum = 20578307;BA.debugLine="scv_hogog.Panel.LoadLayout(\"item_hogog\")";
mostCurrent._scv_hogog.getPanel().LoadLayout("item_hogog",mostCurrent.activityBA);
RDebugUtils.currentLine=20578309;
 //BA.debugLineNum = 20578309;BA.debugLine="get_data_hogogi";
_get_data_hogogi();
RDebugUtils.currentLine=20578311;
 //BA.debugLineNum = 20578311;BA.debugLine="Main.time_page_load.Initialize(\"time_page_load\",1";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .Initialize(processBA,"time_page_load",(long) (1500));
RDebugUtils.currentLine=20578312;
 //BA.debugLineNum = 20578312;BA.debugLine="Main.time_page_load.Enabled=True";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=20578313;
 //BA.debugLineNum = 20578313;BA.debugLine="B4XLoadingIndicator1.Show";
mostCurrent._b4xloadingindicator1._show /*String*/ (null);
RDebugUtils.currentLine=20578315;
 //BA.debugLineNum = 20578315;BA.debugLine="sp_year.Add(\"1402\")";
mostCurrent._sp_year.Add("1402");
RDebugUtils.currentLine=20578316;
 //BA.debugLineNum = 20578316;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
RDebugUtils.currentLine=20578317;
 //BA.debugLineNum = 20578317;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
RDebugUtils.currentLine=20578318;
 //BA.debugLineNum = 20578318;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
RDebugUtils.currentLine=20578319;
 //BA.debugLineNum = 20578319;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
RDebugUtils.currentLine=20578321;
 //BA.debugLineNum = 20578321;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=20578323;
 //BA.debugLineNum = 20578323;BA.debugLine="Dim imm As BitmapDrawable";
_imm = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=20578324;
 //BA.debugLineNum = 20578324;BA.debugLine="imm.Initialize(LoadBitmap(File.DirAssets,\"textBox";
_imm.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"textBox.png").getObject()));
RDebugUtils.currentLine=20578325;
 //BA.debugLineNum = 20578325;BA.debugLine="imm.Gravity=Gravity.FILL";
_imm.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=20578326;
 //BA.debugLineNum = 20578326;BA.debugLine="sp_year.Background=imm";
mostCurrent._sp_year.setBackground((android.graphics.drawable.Drawable)(_imm.getObject()));
RDebugUtils.currentLine=20578327;
 //BA.debugLineNum = 20578327;BA.debugLine="sp_moon.Background=imm";
mostCurrent._sp_moon.setBackground((android.graphics.drawable.Drawable)(_imm.getObject()));
RDebugUtils.currentLine=20578330;
 //BA.debugLineNum = 20578330;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))-1));
RDebugUtils.currentLine=20578335;
 //BA.debugLineNum = 20578335;BA.debugLine="WebView1.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview1.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=20578336;
 //BA.debugLineNum = 20578336;BA.debugLine="WebView2.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview2.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=20578339;
 //BA.debugLineNum = 20578339;BA.debugLine="ls_onvanHa.Initialize";
mostCurrent._ls_onvanha.Initialize();
RDebugUtils.currentLine=20578340;
 //BA.debugLineNum = 20578340;BA.debugLine="ls_onvanHa=dbCode.read_onvan_db";
mostCurrent._ls_onvanha = mostCurrent._dbcode._read_onvan_db /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=20578343;
 //BA.debugLineNum = 20578343;BA.debugLine="str_web1.Initialize";
mostCurrent._str_web1.Initialize();
RDebugUtils.currentLine=20578344;
 //BA.debugLineNum = 20578344;BA.debugLine="str_web1.Append(\"<html dir='rtl'><meta charset='U";
mostCurrent._str_web1.Append("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>");
RDebugUtils.currentLine=20578345;
 //BA.debugLineNum = 20578345;BA.debugLine="str_web1.Append(\"<h4 align='center' >اطلاعات حقوق";
mostCurrent._str_web1.Append("<h4 align='center' >اطلاعات حقوق برای ۳۰ روز</h4>");
RDebugUtils.currentLine=20578346;
 //BA.debugLineNum = 20578346;BA.debugLine="str_web1.Append(\"<h6 align='center'>واحد : تومان<";
mostCurrent._str_web1.Append("<h6 align='center'>واحد : تومان</h6>");
RDebugUtils.currentLine=20578347;
 //BA.debugLineNum = 20578347;BA.debugLine="str_web1.Append(\"<table style='width:100%'><tr>\")";
mostCurrent._str_web1.Append("<table style='width:100%'><tr>");
RDebugUtils.currentLine=20578348;
 //BA.debugLineNum = 20578348;BA.debugLine="str_web1.Append(\"<td>\"&\"\"&ls_onvanHa.Get(0)&\" : \"";
mostCurrent._str_web1.Append("<td>"+""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (0)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool((int)(Double.parseDouble(mostCurrent._paye))))+"<br>");
RDebugUtils.currentLine=20578349;
 //BA.debugLineNum = 20578349;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(2)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (2)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maskan))+"<br>");
RDebugUtils.currentLine=20578350;
 //BA.debugLineNum = 20578350;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(3)&\" : \"&myfun";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (3)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bon))+"<br>");
RDebugUtils.currentLine=20578351;
 //BA.debugLineNum = 20578351;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(4)&\"  : \"&myfun";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (4)))+"  : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad))+"<br>");
RDebugUtils.currentLine=20578352;
 //BA.debugLineNum = 20578352;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(5)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (5)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_fani))+"<br>");
RDebugUtils.currentLine=20578353;
 //BA.debugLineNum = 20578353;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(6)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (6)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_masoliat))+"<br>");
RDebugUtils.currentLine=20578354;
 //BA.debugLineNum = 20578354;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(7)&\"  : \"&myfu";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (7)))+"  : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sarparasti))+"<br></td>");
RDebugUtils.currentLine=20578358;
 //BA.debugLineNum = 20578358;BA.debugLine="str_web1.Append(\"<td>\"&\" \"&ls_onvanHa.Get(1)&\" :";
mostCurrent._str_web1.Append("<td>"+" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (1)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat))+"<br>");
RDebugUtils.currentLine=20578359;
 //BA.debugLineNum = 20578359;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(8)&\" : \"&myfun";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (8)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_shift))+"<br>");
RDebugUtils.currentLine=20578360;
 //BA.debugLineNum = 20578360;BA.debugLine="str_web1.Append(\"بیمه تامین اجتماعی : %\"&myfunc.e";
mostCurrent._str_web1.Append("بیمه تامین اجتماعی : %"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_bime_tamin))+"<br>");
RDebugUtils.currentLine=20578361;
 //BA.debugLineNum = 20578361;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(9)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (9)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_takmil))+"<br>");
RDebugUtils.currentLine=20578362;
 //BA.debugLineNum = 20578362;BA.debugLine="str_web1.Append(\" مالیات : مطابق قانون کار<br>\")";
mostCurrent._str_web1.Append(" مالیات : مطابق قانون کار<br>");
RDebugUtils.currentLine=20578363;
 //BA.debugLineNum = 20578363;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(10)&\" : \"&myf";
mostCurrent._str_web1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (10)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya))+"<br>");
RDebugUtils.currentLine=20578364;
 //BA.debugLineNum = 20578364;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(11)&\" : \"&myf";
mostCurrent._str_web1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (11)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat))+"</td>");
RDebugUtils.currentLine=20578365;
 //BA.debugLineNum = 20578365;BA.debugLine="str_web1.Append(\"</tr></table>\")";
mostCurrent._str_web1.Append("</tr></table>");
RDebugUtils.currentLine=20578366;
 //BA.debugLineNum = 20578366;BA.debugLine="str_web1.Append(\"</body></html>\")";
mostCurrent._str_web1.Append("</body></html>");
RDebugUtils.currentLine=20578368;
 //BA.debugLineNum = 20578368;BA.debugLine="WebView1.LoadHtml(str_web1)";
mostCurrent._webview1.LoadHtml(BA.ObjectToString(mostCurrent._str_web1));
RDebugUtils.currentLine=20578373;
 //BA.debugLineNum = 20578373;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
RDebugUtils.currentLine=20578374;
 //BA.debugLineNum = 20578374;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=20578376;
 //BA.debugLineNum = 20578376;BA.debugLine="lbl_date_from.Text=myfunc.fa2en(Main.persianDate.";
mostCurrent._lbl_date_from.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear()))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianDay())))))));
RDebugUtils.currentLine=20578377;
 //BA.debugLineNum = 20578377;BA.debugLine="lbl_date_to.Text=myfunc.fa2en(Main.persianDate.Pe";
mostCurrent._lbl_date_to.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear()))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))+1))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianDay())))))));
RDebugUtils.currentLine=20578383;
 //BA.debugLineNum = 20578383;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
RDebugUtils.currentLine=20578386;
 //BA.debugLineNum = 20578386;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=20578388;
 //BA.debugLineNum = 20578388;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=20578389;
 //BA.debugLineNum = 20578389;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
RDebugUtils.currentLine=20578392;
 //BA.debugLineNum = 20578392;BA.debugLine="If(dbCode.get_setting_byName(\"tog_maliat\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_maliat")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=20578393;
 //BA.debugLineNum = 20578393;BA.debugLine="et_maliat.Text=\"محاسبه اتوماتیک\"";
mostCurrent._et_maliat.setText(BA.ObjectToCharSequence("محاسبه اتوماتیک"));
RDebugUtils.currentLine=20578394;
 //BA.debugLineNum = 20578394;BA.debugLine="et_maliat.Enabled=False";
mostCurrent._et_maliat.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=20578396;
 //BA.debugLineNum = 20578396;BA.debugLine="et_maliat.Text=0";
mostCurrent._et_maliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=20578397;
 //BA.debugLineNum = 20578397;BA.debugLine="et_maliat.Tag=0";
mostCurrent._et_maliat.setTag((Object)(0));
RDebugUtils.currentLine=20578398;
 //BA.debugLineNum = 20578398;BA.debugLine="et_maliat.Enabled=True";
mostCurrent._et_maliat.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=20578401;
 //BA.debugLineNum = 20578401;BA.debugLine="If(dbCode.get_setting_byName(\"tog_bime\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_bime")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=20578402;
 //BA.debugLineNum = 20578402;BA.debugLine="et_bime.Text=\"محاسبه اتوماتیک\"";
mostCurrent._et_bime.setText(BA.ObjectToCharSequence("محاسبه اتوماتیک"));
RDebugUtils.currentLine=20578403;
 //BA.debugLineNum = 20578403;BA.debugLine="et_bime.Enabled=False";
mostCurrent._et_bime.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=20578405;
 //BA.debugLineNum = 20578405;BA.debugLine="et_bime.Text=0";
mostCurrent._et_bime.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=20578406;
 //BA.debugLineNum = 20578406;BA.debugLine="et_bime.Tag=0";
mostCurrent._et_bime.setTag((Object)(0));
RDebugUtils.currentLine=20578407;
 //BA.debugLineNum = 20578407;BA.debugLine="et_bime.Enabled=True";
mostCurrent._et_bime.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=20578414;
 //BA.debugLineNum = 20578414;BA.debugLine="pan_hed_hogog.Color=Main.color4";
mostCurrent._pan_hed_hogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=20578415;
 //BA.debugLineNum = 20578415;BA.debugLine="pan_main_hed_hogog.Color=Main.color4";
mostCurrent._pan_main_hed_hogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=20578416;
 //BA.debugLineNum = 20578416;BA.debugLine="pan_hed_gozaresh.Color=Main.color4";
mostCurrent._pan_hed_gozaresh.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=20578417;
 //BA.debugLineNum = 20578417;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=20578420;
 //BA.debugLineNum = 20578420;BA.debugLine="End Sub";
return "";
}
public static String  _get_data_hogogi() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_data_hogogi", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_data_hogogi", null));}
RDebugUtils.currentLine=21430272;
 //BA.debugLineNum = 21430272;BA.debugLine="Sub get_data_hogogi";
RDebugUtils.currentLine=21430274;
 //BA.debugLineNum = 21430274;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=21430275;
 //BA.debugLineNum = 21430275;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=21430277;
 //BA.debugLineNum = 21430277;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=21430278;
 //BA.debugLineNum = 21430278;BA.debugLine="paye=dbCode.res.GetString(\"value\")";
mostCurrent._paye = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value");
RDebugUtils.currentLine=21430280;
 //BA.debugLineNum = 21430280;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (1));
RDebugUtils.currentLine=21430281;
 //BA.debugLineNum = 21430281;BA.debugLine="maskan=dbCode.res.GetString(\"value\")";
_maskan = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=21430283;
 //BA.debugLineNum = 21430283;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (3));
RDebugUtils.currentLine=21430284;
 //BA.debugLineNum = 21430284;BA.debugLine="olad=dbCode.res.GetString(\"value\")";
_olad = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=21430286;
 //BA.debugLineNum = 21430286;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (4));
RDebugUtils.currentLine=21430287;
 //BA.debugLineNum = 21430287;BA.debugLine="fani=dbCode.res.GetString(\"value\")";
_fani = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=21430289;
 //BA.debugLineNum = 21430289;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (5));
RDebugUtils.currentLine=21430290;
 //BA.debugLineNum = 21430290;BA.debugLine="masoliat=dbCode.res.GetString(\"value\")";
_masoliat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=21430292;
 //BA.debugLineNum = 21430292;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (2));
RDebugUtils.currentLine=21430293;
 //BA.debugLineNum = 21430293;BA.debugLine="bon=dbCode.res.GetString(\"value\")";
_bon = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=21430295;
 //BA.debugLineNum = 21430295;BA.debugLine="dbCode.res.Position=6 ''--------bime_tamin------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (6));
RDebugUtils.currentLine=21430296;
 //BA.debugLineNum = 21430296;BA.debugLine="bime_tamin=dbCode.res.GetString(\"value\")";
_bime_tamin = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=21430298;
 //BA.debugLineNum = 21430298;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (11));
RDebugUtils.currentLine=21430299;
 //BA.debugLineNum = 21430299;BA.debugLine="bime_takmil=dbCode.res.GetString(\"value\")";
_bime_takmil = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=21430307;
 //BA.debugLineNum = 21430307;BA.debugLine="dbCode.res.Position=13 ''--------hag shift------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (13));
RDebugUtils.currentLine=21430308;
 //BA.debugLineNum = 21430308;BA.debugLine="shift=dbCode.res.GetString(\"value\")";
_shift = (double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=21430310;
 //BA.debugLineNum = 21430310;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (14));
RDebugUtils.currentLine=21430311;
 //BA.debugLineNum = 21430311;BA.debugLine="sanavat=dbCode.res.GetString(\"value\")";
_sanavat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=21430313;
 //BA.debugLineNum = 21430313;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (15));
RDebugUtils.currentLine=21430314;
 //BA.debugLineNum = 21430314;BA.debugLine="sarparasti=dbCode.res.GetString(\"value\")";
_sarparasti = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=21430316;
 //BA.debugLineNum = 21430316;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (16));
RDebugUtils.currentLine=21430317;
 //BA.debugLineNum = 21430317;BA.debugLine="mazaya=dbCode.res.GetString(\"value\")";
_mazaya = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=21430319;
 //BA.debugLineNum = 21430319;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (19));
RDebugUtils.currentLine=21430320;
 //BA.debugLineNum = 21430320;BA.debugLine="ksorat=dbCode.res.GetString(\"value\")";
_ksorat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=21430330;
 //BA.debugLineNum = 21430330;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=21430331;
 //BA.debugLineNum = 21430331;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=21430335;
 //BA.debugLineNum = 21430335;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(int _num) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_num_pool", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_num_pool", new Object[] {_num}));}
RDebugUtils.currentLine=21037056;
 //BA.debugLineNum = 21037056;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=21037057;
 //BA.debugLineNum = 21037057;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
RDebugUtils.currentLine=21037058;
 //BA.debugLineNum = 21037058;BA.debugLine="End Sub";
return "";
}
public static String  _fix_date2_decreceone() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fix_date2_decreceone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fix_date2_decreceone", null));}
int _y_date2 = 0;
int _m_date2 = 0;
int _d_date2 = 0;
RDebugUtils.currentLine=20643840;
 //BA.debugLineNum = 20643840;BA.debugLine="Sub fix_date2_decreceOne";
RDebugUtils.currentLine=20643843;
 //BA.debugLineNum = 20643843;BA.debugLine="Dim y_date2 As Int =myfunc.fa2en( lbl_date_to.Tex";
_y_date2 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=20643844;
 //BA.debugLineNum = 20643844;BA.debugLine="Dim m_date2 As Int =myfunc.fa2en(lbl_date_to.Text";
_m_date2 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=20643845;
 //BA.debugLineNum = 20643845;BA.debugLine="Dim d_date2 As Int =myfunc.fa2en(lbl_date_to.Text";
_d_date2 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=20643847;
 //BA.debugLineNum = 20643847;BA.debugLine="If(d_date2-1=0)Then";
if ((_d_date2-1==0)) { 
RDebugUtils.currentLine=20643850;
 //BA.debugLineNum = 20643850;BA.debugLine="If(m_date2-1=0)Then";
if ((_m_date2-1==0)) { 
RDebugUtils.currentLine=20643851;
 //BA.debugLineNum = 20643851;BA.debugLine="d_date2=29";
_d_date2 = (int) (29);
RDebugUtils.currentLine=20643852;
 //BA.debugLineNum = 20643852;BA.debugLine="m_date2=12";
_m_date2 = (int) (12);
RDebugUtils.currentLine=20643853;
 //BA.debugLineNum = 20643853;BA.debugLine="y_date2=y_date2-1";
_y_date2 = (int) (_y_date2-1);
 }else {
RDebugUtils.currentLine=20643855;
 //BA.debugLineNum = 20643855;BA.debugLine="d_date2=count_mah(m_date2-1)";
_d_date2 = _count_mah((int) (_m_date2-1));
RDebugUtils.currentLine=20643856;
 //BA.debugLineNum = 20643856;BA.debugLine="m_date2=m_date2-1";
_m_date2 = (int) (_m_date2-1);
 };
 }else {
RDebugUtils.currentLine=20643861;
 //BA.debugLineNum = 20643861;BA.debugLine="d_date2=d_date2-1";
_d_date2 = (int) (_d_date2-1);
 };
RDebugUtils.currentLine=20643865;
 //BA.debugLineNum = 20643865;BA.debugLine="date2_fixed=y_date2&\"/\"&myfunc.convert_adad(m_dat";
mostCurrent._date2_fixed = BA.NumberToString(_y_date2)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_m_date2)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_d_date2);
RDebugUtils.currentLine=20643868;
 //BA.debugLineNum = 20643868;BA.debugLine="End Sub";
return "";
}
public static String  _et_time_indb() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_time_indb", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_time_indb", null));}
anywheresoftware.b4a.objects.collections.List _list_ezafekari1 = null;
anywheresoftware.b4a.objects.collections.List _list_ezafekari2 = null;
RDebugUtils.currentLine=21102592;
 //BA.debugLineNum = 21102592;BA.debugLine="Sub et_time_inDB";
RDebugUtils.currentLine=21102595;
 //BA.debugLineNum = 21102595;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
mostCurrent._moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=21102598;
 //BA.debugLineNum = 21102598;BA.debugLine="Dim list_ezafekari1 As List";
_list_ezafekari1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=21102599;
 //BA.debugLineNum = 21102599;BA.debugLine="list_ezafekari1.Initialize";
_list_ezafekari1.Initialize();
RDebugUtils.currentLine=21102602;
 //BA.debugLineNum = 21102602;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=21102603;
 //BA.debugLineNum = 21102603;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_mah(myfunc.";
_list_ezafekari1 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._moon_num),(int) (2));
 }else {
RDebugUtils.currentLine=21102605;
 //BA.debugLineNum = 21102605;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_byDate(myfu";
_list_ezafekari1 = mostCurrent._dbcode._all_ezafekari_bydate /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText()),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._date2_fixed),(int) (2));
 };
RDebugUtils.currentLine=21102608;
 //BA.debugLineNum = 21102608;BA.debugLine="et_time_h.Text=list_ezafekari1.Get(0)";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (0))));
RDebugUtils.currentLine=21102609;
 //BA.debugLineNum = 21102609;BA.debugLine="et_time_m.Text=list_ezafekari1.Get(1)";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (1))));
RDebugUtils.currentLine=21102612;
 //BA.debugLineNum = 21102612;BA.debugLine="Dim list_ezafekari2 As List";
_list_ezafekari2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=21102613;
 //BA.debugLineNum = 21102613;BA.debugLine="list_ezafekari2.Initialize";
_list_ezafekari2.Initialize();
RDebugUtils.currentLine=21102616;
 //BA.debugLineNum = 21102616;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=21102617;
 //BA.debugLineNum = 21102617;BA.debugLine="list_ezafekari2=dbCode.all_ezafekari_mah(sp_year";
_list_ezafekari2 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num,(int) (3));
 }else {
RDebugUtils.currentLine=21102619;
 //BA.debugLineNum = 21102619;BA.debugLine="list_ezafekari2=dbCode.all_ezafekari_byDate(myfu";
_list_ezafekari2 = mostCurrent._dbcode._all_ezafekari_bydate /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText()),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._date2_fixed),(int) (3));
 };
RDebugUtils.currentLine=21102622;
 //BA.debugLineNum = 21102622;BA.debugLine="et_time_h_vij.Text=list_ezafekari2.Get(0)";
mostCurrent._et_time_h_vij.setText(BA.ObjectToCharSequence(_list_ezafekari2.Get((int) (0))));
RDebugUtils.currentLine=21102623;
 //BA.debugLineNum = 21102623;BA.debugLine="et_time_m_vij.Text=list_ezafekari2.Get(1)";
mostCurrent._et_time_m_vij.setText(BA.ObjectToCharSequence(_list_ezafekari2.Get((int) (1))));
RDebugUtils.currentLine=21102626;
 //BA.debugLineNum = 21102626;BA.debugLine="If(moon_num<7)Then";
if (((double)(Double.parseDouble(mostCurrent._moon_num))<7)) { 
RDebugUtils.currentLine=21102627;
 //BA.debugLineNum = 21102627;BA.debugLine="roze_kari=31";
_roze_kari = (int) (31);
 }else {
RDebugUtils.currentLine=21102629;
 //BA.debugLineNum = 21102629;BA.debugLine="roze_kari=30";
_roze_kari = (int) (30);
 };
RDebugUtils.currentLine=21102633;
 //BA.debugLineNum = 21102633;BA.debugLine="et_rozekari.Text=roze_kari";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(_roze_kari));
RDebugUtils.currentLine=21102634;
 //BA.debugLineNum = 21102634;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "calc_vahed_ezafekari", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "calc_vahed_ezafekari", null));}
RDebugUtils.currentLine=20709376;
 //BA.debugLineNum = 20709376;BA.debugLine="Sub calc_vahed_ezafekari";
RDebugUtils.currentLine=20709378;
 //BA.debugLineNum = 20709378;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=20709381;
 //BA.debugLineNum = 20709381;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=20709384;
 //BA.debugLineNum = 20709384;BA.debugLine="vahed_ezafekari=((paye+sanavat)/220)*1.4";
_vahed_ezafekari = (int) ((((double)(Double.parseDouble(mostCurrent._paye))+_sanavat)/(double)220)*1.4);
RDebugUtils.currentLine=20709388;
 //BA.debugLineNum = 20709388;BA.debugLine="et_vahed_ezafekari.Tag=vahed_ezafekari";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_vahed_ezafekari));
RDebugUtils.currentLine=20709389;
 //BA.debugLineNum = 20709389;BA.debugLine="et_vahed_ezafekari.Text=myfunc.show_num_pool(vahe";
mostCurrent._et_vahed_ezafekari.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari)));
RDebugUtils.currentLine=20709392;
 //BA.debugLineNum = 20709392;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari_vij() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "calc_vahed_ezafekari_vij", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "calc_vahed_ezafekari_vij", null));}
RDebugUtils.currentLine=20774912;
 //BA.debugLineNum = 20774912;BA.debugLine="Sub calc_vahed_ezafekari_vij";
RDebugUtils.currentLine=20774914;
 //BA.debugLineNum = 20774914;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=20774917;
 //BA.debugLineNum = 20774917;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=20774920;
 //BA.debugLineNum = 20774920;BA.debugLine="vahed_ezafekari_vij=((paye+sanavat)/220)*1.8";
_vahed_ezafekari_vij = (int) ((((double)(Double.parseDouble(mostCurrent._paye))+_sanavat)/(double)220)*1.8);
RDebugUtils.currentLine=20774924;
 //BA.debugLineNum = 20774924;BA.debugLine="et_vahed_ezafekari_vij.Tag=vahed_ezafekari_vij";
mostCurrent._et_vahed_ezafekari_vij.setTag((Object)(_vahed_ezafekari_vij));
RDebugUtils.currentLine=20774925;
 //BA.debugLineNum = 20774925;BA.debugLine="et_vahed_ezafekari_vij.Text=myfunc.show_num_pool(";
mostCurrent._et_vahed_ezafekari_vij.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari_vij)));
RDebugUtils.currentLine=20774927;
 //BA.debugLineNum = 20774927;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=21364736;
 //BA.debugLineNum = 21364736;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=21364737;
 //BA.debugLineNum = 21364737;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=21364738;
 //BA.debugLineNum = 21364738;BA.debugLine="If(pan_mohasebat.Visible=True)Then";
if ((mostCurrent._pan_mohasebat.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=21364739;
 //BA.debugLineNum = 21364739;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
mostCurrent._pan_mohasebat.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=21364741;
 //BA.debugLineNum = 21364741;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
RDebugUtils.currentLine=21364744;
 //BA.debugLineNum = 21364744;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=21364746;
 //BA.debugLineNum = 21364746;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=21364748;
 //BA.debugLineNum = 21364748;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=21299200;
 //BA.debugLineNum = 21299200;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=21299201;
 //BA.debugLineNum = 21299201;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=21299202;
 //BA.debugLineNum = 21299202;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=21299203;
 //BA.debugLineNum = 21299203;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="hogog_activity";
RDebugUtils.currentLine=21233664;
 //BA.debugLineNum = 21233664;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=21233666;
 //BA.debugLineNum = 21233666;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=21168128;
 //BA.debugLineNum = 21168128;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=21168130;
 //BA.debugLineNum = 21168130;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=23068672;
 //BA.debugLineNum = 23068672;BA.debugLine="Sub check_date_iscorrect As Boolean";
RDebugUtils.currentLine=23068674;
 //BA.debugLineNum = 23068674;BA.debugLine="Dim y1_shamsi As Int =myfunc.fa2en( lbl_date_from";
_y1_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=23068675;
 //BA.debugLineNum = 23068675;BA.debugLine="Dim m1_shamsi As Int =myfunc.fa2en(lbl_date_from.";
_m1_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=23068676;
 //BA.debugLineNum = 23068676;BA.debugLine="Dim d1_shamsi As Int =myfunc.fa2en(lbl_date_from.";
_d1_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=23068679;
 //BA.debugLineNum = 23068679;BA.debugLine="Dim y2_shamsi As Int =myfunc.fa2en(lbl_date_to.Te";
_y2_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=23068680;
 //BA.debugLineNum = 23068680;BA.debugLine="Dim m2_shamsi As Int =myfunc.fa2en(lbl_date_to.Te";
_m2_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=23068681;
 //BA.debugLineNum = 23068681;BA.debugLine="Dim d2_shamsi As Int =myfunc.fa2en(lbl_date_to.Te";
_d2_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=23068684;
 //BA.debugLineNum = 23068684;BA.debugLine="Dim rozzzz As Int=0";
_rozzzz = (int) (0);
RDebugUtils.currentLine=23068685;
 //BA.debugLineNum = 23068685;BA.debugLine="Dim check_date As Boolean = True";
_check_date = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=23068687;
 //BA.debugLineNum = 23068687;BA.debugLine="Dim mah1 As Int=count_mah(m1_shamsi)";
_mah1 = _count_mah(_m1_shamsi);
RDebugUtils.currentLine=23068692;
 //BA.debugLineNum = 23068692;BA.debugLine="If(m2_shamsi-m1_shamsi)=0 Then";
if ((_m2_shamsi-_m1_shamsi)==0) { 
RDebugUtils.currentLine=23068693;
 //BA.debugLineNum = 23068693;BA.debugLine="rozzzz=d2_shamsi-d1_shamsi";
_rozzzz = (int) (_d2_shamsi-_d1_shamsi);
RDebugUtils.currentLine=23068694;
 //BA.debugLineNum = 23068694;BA.debugLine="If(y2_shamsi-y1_shamsi <> 0) Then";
if ((_y2_shamsi-_y1_shamsi!=0)) { 
RDebugUtils.currentLine=23068695;
 //BA.debugLineNum = 23068695;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else 
{RDebugUtils.currentLine=23068697;
 //BA.debugLineNum = 23068697;BA.debugLine="Else If (m2_shamsi-m1_shamsi)=1 Then";
if ((_m2_shamsi-_m1_shamsi)==1) { 
RDebugUtils.currentLine=23068698;
 //BA.debugLineNum = 23068698;BA.debugLine="rozzzz=(mah1-d1_shamsi) + (d2_shamsi)";
_rozzzz = (int) ((_mah1-_d1_shamsi)+(_d2_shamsi));
RDebugUtils.currentLine=23068700;
 //BA.debugLineNum = 23068700;BA.debugLine="If(y2_shamsi-y1_shamsi <> 0) Then";
if ((_y2_shamsi-_y1_shamsi!=0)) { 
RDebugUtils.currentLine=23068701;
 //BA.debugLineNum = 23068701;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else 
{RDebugUtils.currentLine=23068704;
 //BA.debugLineNum = 23068704;BA.debugLine="Else if ((m2_shamsi-m1_shamsi)=-11 ) Then";
if (((_m2_shamsi-_m1_shamsi)==-11)) { 
RDebugUtils.currentLine=23068705;
 //BA.debugLineNum = 23068705;BA.debugLine="rozzzz=(mah1-d1_shamsi) + (d2_shamsi)";
_rozzzz = (int) ((_mah1-_d1_shamsi)+(_d2_shamsi));
RDebugUtils.currentLine=23068706;
 //BA.debugLineNum = 23068706;BA.debugLine="If(y2_shamsi-y1_shamsi <> 0) Then";
if ((_y2_shamsi-_y1_shamsi!=0)) { 
RDebugUtils.currentLine=23068707;
 //BA.debugLineNum = 23068707;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else 
{RDebugUtils.currentLine=23068709;
 //BA.debugLineNum = 23068709;BA.debugLine="Else if ((m2_shamsi-m1_shamsi)>-11  And (m2_shams";
if (((_m2_shamsi-_m1_shamsi)>-11 && (_m2_shamsi-_m1_shamsi)<0)) { 
RDebugUtils.currentLine=23068710;
 //BA.debugLineNum = 23068710;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=23068712;
 //BA.debugLineNum = 23068712;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 }}}}
;
RDebugUtils.currentLine=23068716;
 //BA.debugLineNum = 23068716;BA.debugLine="If(check_date=True)Then";
if ((_check_date==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=23068717;
 //BA.debugLineNum = 23068717;BA.debugLine="If(rozzzz>31)Then";
if ((_rozzzz>31)) { 
RDebugUtils.currentLine=23068718;
 //BA.debugLineNum = 23068718;BA.debugLine="ToastMessageShow(\"تاریخ را اصلاح کنید - حداکثر";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تاریخ را اصلاح کنید - حداکثر 31 روز باشد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=23068719;
 //BA.debugLineNum = 23068719;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else {
RDebugUtils.currentLine=23068722;
 //BA.debugLineNum = 23068722;BA.debugLine="ToastMessageShow(\"تاریخ را اصلاح کنید - حداکثر 3";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تاریخ را اصلاح کنید - حداکثر 31 روز باشد"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=23068726;
 //BA.debugLineNum = 23068726;BA.debugLine="Return check_date";
if (true) return _check_date;
RDebugUtils.currentLine=23068727;
 //BA.debugLineNum = 23068727;BA.debugLine="End Sub";
return false;
}
public static int  _count_mah(int _adad_mah) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "count_mah", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "count_mah", new Object[] {_adad_mah}));}
int _res = 0;
RDebugUtils.currentLine=23003136;
 //BA.debugLineNum = 23003136;BA.debugLine="Sub count_mah (adad_mah As Int) As Int";
RDebugUtils.currentLine=23003137;
 //BA.debugLineNum = 23003137;BA.debugLine="Dim res As Int=0";
_res = (int) (0);
RDebugUtils.currentLine=23003138;
 //BA.debugLineNum = 23003138;BA.debugLine="If(adad_mah<7)Then";
if ((_adad_mah<7)) { 
RDebugUtils.currentLine=23003139;
 //BA.debugLineNum = 23003139;BA.debugLine="res=31";
_res = (int) (31);
 }else {
RDebugUtils.currentLine=23003141;
 //BA.debugLineNum = 23003141;BA.debugLine="res=30";
_res = (int) (30);
 };
RDebugUtils.currentLine=23003144;
 //BA.debugLineNum = 23003144;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=23003146;
 //BA.debugLineNum = 23003146;BA.debugLine="End Sub";
return 0;
}
public static String  _et_bime_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_bime_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_bime_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=23789568;
 //BA.debugLineNum = 23789568;BA.debugLine="Private Sub et_bime_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=23789569;
 //BA.debugLineNum = 23789569;BA.debugLine="et_bime.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_bime.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=23789570;
 //BA.debugLineNum = 23789570;BA.debugLine="myfunc.change_formater(Old,New,et_bime)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_bime);
RDebugUtils.currentLine=23789571;
 //BA.debugLineNum = 23789571;BA.debugLine="End Sub";
return "";
}
public static String  _et_maliat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_maliat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_maliat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=23724032;
 //BA.debugLineNum = 23724032;BA.debugLine="Private Sub et_maliat_TextChanged (Old As String,";
RDebugUtils.currentLine=23724033;
 //BA.debugLineNum = 23724033;BA.debugLine="et_maliat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_maliat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=23724034;
 //BA.debugLineNum = 23724034;BA.debugLine="myfunc.change_formater(Old,New,et_maliat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_maliat);
RDebugUtils.currentLine=23724035;
 //BA.debugLineNum = 23724035;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_vahed_ezafekari_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_vahed_ezafekari_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=20840448;
 //BA.debugLineNum = 20840448;BA.debugLine="Private Sub et_vahed_ezafekari_TextChanged (Old As";
RDebugUtils.currentLine=20840449;
 //BA.debugLineNum = 20840449;BA.debugLine="et_vahed_ezafekari.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=20840450;
 //BA.debugLineNum = 20840450;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari);
RDebugUtils.currentLine=20840451;
 //BA.debugLineNum = 20840451;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_vij_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_vahed_ezafekari_vij_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_vahed_ezafekari_vij_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=20905984;
 //BA.debugLineNum = 20905984;BA.debugLine="Private Sub et_vahed_ezafekari_vij_TextChanged (Ol";
RDebugUtils.currentLine=20905985;
 //BA.debugLineNum = 20905985;BA.debugLine="et_vahed_ezafekari_vij.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari_vij.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=20905986;
 //BA.debugLineNum = 20905986;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari_vij);
RDebugUtils.currentLine=20905987;
 //BA.debugLineNum = 20905987;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_backto_hogog_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_backto_hogog_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_backto_hogog_click", null));}
RDebugUtils.currentLine=21954560;
 //BA.debugLineNum = 21954560;BA.debugLine="Private Sub lbl_backTo_hogog_Click";
RDebugUtils.currentLine=21954562;
 //BA.debugLineNum = 21954562;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
mostCurrent._pan_mohasebat.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=21954563;
 //BA.debugLineNum = 21954563;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_from_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date_from_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date_from_click", null));}
RDebugUtils.currentLine=22740992;
 //BA.debugLineNum = 22740992;BA.debugLine="Private Sub lbl_date_from_Click";
RDebugUtils.currentLine=22740993;
 //BA.debugLineNum = 22740993;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22740994;
 //BA.debugLineNum = 22740994;BA.debugLine="index_datePik=1";
_index_datepik = (int) (1);
RDebugUtils.currentLine=22740996;
 //BA.debugLineNum = 22740996;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_from.Text.Su";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=22740997;
 //BA.debugLineNum = 22740997;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_from.Text.Sub";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=22740998;
 //BA.debugLineNum = 22740998;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=22740999;
 //BA.debugLineNum = 22740999;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_from.Text.Sub";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=22741003;
 //BA.debugLineNum = 22741003;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_to_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date_to_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date_to_click", null));}
RDebugUtils.currentLine=22806528;
 //BA.debugLineNum = 22806528;BA.debugLine="Private Sub lbl_date_to_Click";
RDebugUtils.currentLine=22806529;
 //BA.debugLineNum = 22806529;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22806530;
 //BA.debugLineNum = 22806530;BA.debugLine="index_datePik=2";
_index_datepik = (int) (2);
RDebugUtils.currentLine=22806532;
 //BA.debugLineNum = 22806532;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_to.Text.SubS";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=22806533;
 //BA.debugLineNum = 22806533;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_to.Text.SubSt";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=22806534;
 //BA.debugLineNum = 22806534;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=22806535;
 //BA.debugLineNum = 22806535;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_to.Text.SubSt";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=22806538;
 //BA.debugLineNum = 22806538;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_tatil_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_tatil_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_tatil_click", null));}
RDebugUtils.currentLine=22413312;
 //BA.debugLineNum = 22413312;BA.debugLine="Private Sub lbl_help_tatil_Click";
RDebugUtils.currentLine=22413314;
 //BA.debugLineNum = 22413314;BA.debugLine="myfunc.help_man(\"راهنما\",\"روزهای جمعه که برای آن";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","روزهای جمعه که برای آن روز دیگری را تعطیل نکنند، اضافه کاری فوق العاده محسوب و با ضریب 1.8 محاسبه می شود.");
RDebugUtils.currentLine=22413315;
 //BA.debugLineNum = 22413315;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_print_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_print_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_print_click", null));}
RDebugUtils.currentLine=22544384;
 //BA.debugLineNum = 22544384;BA.debugLine="Private Sub lbl_print_Click";
RDebugUtils.currentLine=22544386;
 //BA.debugLineNum = 22544386;BA.debugLine="printer.Initialize(\"\")";
mostCurrent._printer.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=22544389;
 //BA.debugLineNum = 22544389;BA.debugLine="printer.PrintWebView(\"job\",WebView2)";
mostCurrent._printer.PrintWebView("job",(android.webkit.WebView)(mostCurrent._webview2.getObject()));
RDebugUtils.currentLine=22544390;
 //BA.debugLineNum = 22544390;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_refresh_vahed_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_refresh_vahed_click", null));}
RDebugUtils.currentLine=22282240;
 //BA.debugLineNum = 22282240;BA.debugLine="Private Sub lbl_refresh_vahed_Click";
RDebugUtils.currentLine=22282241;
 //BA.debugLineNum = 22282241;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=22282242;
 //BA.debugLineNum = 22282242;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_vij_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_refresh_vahed_vij_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_refresh_vahed_vij_click", null));}
RDebugUtils.currentLine=22347776;
 //BA.debugLineNum = 22347776;BA.debugLine="Private Sub lbl_refresh_vahed_vij_Click";
RDebugUtils.currentLine=22347777;
 //BA.debugLineNum = 22347777;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
RDebugUtils.currentLine=22347778;
 //BA.debugLineNum = 22347778;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run_mohasebe_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", null));}
anywheresoftware.b4a.objects.collections.List _list_morakhasi = null;
RDebugUtils.currentLine=21495808;
 //BA.debugLineNum = 21495808;BA.debugLine="Private Sub lbl_run_mohasebe_Click";
RDebugUtils.currentLine=21495809;
 //BA.debugLineNum = 21495809;BA.debugLine="If(et_rozekari.Text=\"\")Then";
if (((mostCurrent._et_rozekari.getText()).equals(""))) { 
RDebugUtils.currentLine=21495810;
 //BA.debugLineNum = 21495810;BA.debugLine="et_rozekari.Text=0";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=21495813;
 //BA.debugLineNum = 21495813;BA.debugLine="roze_kari=et_rozekari.Text";
_roze_kari = (int)(Double.parseDouble(mostCurrent._et_rozekari.getText()));
RDebugUtils.currentLine=21495815;
 //BA.debugLineNum = 21495815;BA.debugLine="If(et_time_h.Text=\"\")Then";
if (((mostCurrent._et_time_h.getText()).equals(""))) { 
RDebugUtils.currentLine=21495816;
 //BA.debugLineNum = 21495816;BA.debugLine="et_time_h.Text=0";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=21495818;
 //BA.debugLineNum = 21495818;BA.debugLine="If(et_time_m.Text=\"\")Then";
if (((mostCurrent._et_time_m.getText()).equals(""))) { 
RDebugUtils.currentLine=21495819;
 //BA.debugLineNum = 21495819;BA.debugLine="et_time_m.Text=0";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=21495822;
 //BA.debugLineNum = 21495822;BA.debugLine="If(et_time_h_vij.Text=\"\")Then";
if (((mostCurrent._et_time_h_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=21495823;
 //BA.debugLineNum = 21495823;BA.debugLine="et_time_h_vij.Text=0";
mostCurrent._et_time_h_vij.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=21495825;
 //BA.debugLineNum = 21495825;BA.debugLine="If(et_time_m_vij.Text=\"\")Then";
if (((mostCurrent._et_time_m_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=21495826;
 //BA.debugLineNum = 21495826;BA.debugLine="et_time_m_vij.Text=0";
mostCurrent._et_time_m_vij.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=21495831;
 //BA.debugLineNum = 21495831;BA.debugLine="If(et_vahed_ezafekari.Text=\"\")Then";
if (((mostCurrent._et_vahed_ezafekari.getText()).equals(""))) { 
RDebugUtils.currentLine=21495832;
 //BA.debugLineNum = 21495832;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
 };
RDebugUtils.currentLine=21495834;
 //BA.debugLineNum = 21495834;BA.debugLine="If(et_vahed_ezafekari_vij.Text=\"\")Then";
if (((mostCurrent._et_vahed_ezafekari_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=21495835;
 //BA.debugLineNum = 21495835;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
 };
RDebugUtils.currentLine=21495839;
 //BA.debugLineNum = 21495839;BA.debugLine="If (roze_kari > 31 Or roze_kari < 0)Then";
if ((_roze_kari>31 || _roze_kari<0)) { 
RDebugUtils.currentLine=21495840;
 //BA.debugLineNum = 21495840;BA.debugLine="ToastMessageShow(\" تعداد روز کاری نادرست است\",Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" تعداد روز کاری نادرست است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=21495842;
 //BA.debugLineNum = 21495842;BA.debugLine="If(check_date_iscorrect=True)Then";
if ((_check_date_iscorrect()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=21495843;
 //BA.debugLineNum = 21495843;BA.debugLine="pan_mohasebat.Visible=True";
mostCurrent._pan_mohasebat.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=21495844;
 //BA.debugLineNum = 21495844;BA.debugLine="pan_mohasebat.SetLayoutAnimated(100,0,0,100%x,10";
mostCurrent._pan_mohasebat.SetLayoutAnimated((int) (100),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=21495845;
 //BA.debugLineNum = 21495845;BA.debugLine="mohasebe";
_mohasebe();
RDebugUtils.currentLine=21495850;
 //BA.debugLineNum = 21495850;BA.debugLine="str1.Initialize";
mostCurrent._str1.Initialize();
RDebugUtils.currentLine=21495852;
 //BA.debugLineNum = 21495852;BA.debugLine="str1.Append(\"<!DOCTYPE html><html dir='rtl' lang";
mostCurrent._str1.Append("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>");
RDebugUtils.currentLine=21495853;
 //BA.debugLineNum = 21495853;BA.debugLine="str1.Append(\"<style>table , td {border: 1px soli";
mostCurrent._str1.Append("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	summary {	font-weight: bold;	margin: -.5em -.5em 0;	padding: .5em;} details[open] {	padding: .5em;	}	details[open] summary {border-bottom: 1px solid #aaa;margin-bottom: .5em;}</style>");
RDebugUtils.currentLine=21495857;
 //BA.debugLineNum = 21495857;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=21495858;
 //BA.debugLineNum = 21495858;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=21495859;
 //BA.debugLineNum = 21495859;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+mostCurrent._sp_year.getSelectedItem()+"/"+mostCurrent._moon_num+"%';")));
RDebugUtils.currentLine=21495860;
 //BA.debugLineNum = 21495860;BA.debugLine="str1.Append(\"<h3>\").Append(\"گزارش \"& sp_moon.Se";
mostCurrent._str1.Append("<h3>").Append("گزارش "+mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())).Append("</h3>");
 }else {
RDebugUtils.currentLine=21495862;
 //BA.debugLineNum = 21495862;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FRO";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+mostCurrent._lbl_date_from.getText()+"' AND '"+mostCurrent._date2_fixed+"' ;")));
RDebugUtils.currentLine=21495863;
 //BA.debugLineNum = 21495863;BA.debugLine="str1.Append(\"<h3>\").Append(\"گزارش از تاریخ \").";
mostCurrent._str1.Append("<h3>").Append("گزارش از تاریخ ").Append(mostCurrent._lbl_date_from.getText()).Append(" تا ").Append(mostCurrent._date2_fixed).Append("</h3>");
 };
RDebugUtils.currentLine=21495872;
 //BA.debugLineNum = 21495872;BA.debugLine="str1.Append(\"نام کاربر :\").Append(\"<span> \"&Main";
mostCurrent._str1.Append("نام کاربر :").Append("<span> "+mostCurrent._main._user_namefamili /*String*/ +"</span>").Append("<br>");
RDebugUtils.currentLine=21495874;
 //BA.debugLineNum = 21495874;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5;'><details>");
RDebugUtils.currentLine=21495876;
 //BA.debugLineNum = 21495876;BA.debugLine="str1.Append(\"<summary><b> اضافه کاری های این ماه";
mostCurrent._str1.Append("<summary><b> اضافه کاری های این ماه</b></summary>");
RDebugUtils.currentLine=21495877;
 //BA.debugLineNum = 21495877;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr styl";
mostCurrent._str1.Append("<table style='width:100%;'><tr style='text-align: center;'>");
RDebugUtils.currentLine=21495878;
 //BA.debugLineNum = 21495878;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ<";
mostCurrent._str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td><br></tr>");
RDebugUtils.currentLine=21495880;
 //BA.debugLineNum = 21495880;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=21495881;
 //BA.debugLineNum = 21495881;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
mostCurrent._str1.Append("<tr style='text-align: center;'>");
RDebugUtils.currentLine=21495882;
 //BA.debugLineNum = 21495882;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
RDebugUtils.currentLine=21495883;
 //BA.debugLineNum = 21495883;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
RDebugUtils.currentLine=21495884;
 //BA.debugLineNum = 21495884;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
RDebugUtils.currentLine=21495886;
 //BA.debugLineNum = 21495886;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=21495887;
 //BA.debugLineNum = 21495887;BA.debugLine="str1.Append(myfunc.en2fa((dbCode.res.GetString(";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(((double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")))+((double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")))*24)))));
RDebugUtils.currentLine=21495888;
 //BA.debugLineNum = 21495888;BA.debugLine="str1.Append(\":\")";
mostCurrent._str1.Append(":");
RDebugUtils.currentLine=21495889;
 //BA.debugLineNum = 21495889;BA.debugLine="str1.Append(myfunc.en2fa(dbCode.res.GetString(\"";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))).Append("</td>");
RDebugUtils.currentLine=21495891;
 //BA.debugLineNum = 21495891;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
 }
;
RDebugUtils.currentLine=21495894;
 //BA.debugLineNum = 21495894;BA.debugLine="str1.Append(\"</table>\")";
mostCurrent._str1.Append("</table>");
RDebugUtils.currentLine=21495895;
 //BA.debugLineNum = 21495895;BA.debugLine="str1.Append(\"مجموع ساعت اضافه کاری :<span style=";
mostCurrent._str1.Append("مجموع ساعت اضافه کاری :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h.getText())+" ساعت و"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m.getText())+"دقیقه </span><br></details></div><br> ");
RDebugUtils.currentLine=21495903;
 //BA.debugLineNum = 21495903;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=21495904;
 //BA.debugLineNum = 21495904;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+mostCurrent._sp_year.getSelectedItem()+"/"+mostCurrent._moon_num+"%';")));
 }else {
RDebugUtils.currentLine=21495906;
 //BA.debugLineNum = 21495906;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from BETWEEN '"+mostCurrent._lbl_date_from.getText()+"' AND '"+mostCurrent._lbl_date_to.getText()+"' ;")));
 };
RDebugUtils.currentLine=21495910;
 //BA.debugLineNum = 21495910;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5 ;'><details>");
RDebugUtils.currentLine=21495911;
 //BA.debugLineNum = 21495911;BA.debugLine="str1.Append(\"<summary><b> مرخصی های این ماه</b><";
mostCurrent._str1.Append("<summary><b> مرخصی های این ماه</b></summary>");
RDebugUtils.currentLine=21495912;
 //BA.debugLineNum = 21495912;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr styl";
mostCurrent._str1.Append("<table style='width:100%;'><tr style='text-align: center;'>");
RDebugUtils.currentLine=21495913;
 //BA.debugLineNum = 21495913;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ<";
mostCurrent._str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b>زمان/روز</b></td><td><b> زمان/ساعت</b></td><br></tr>");
RDebugUtils.currentLine=21495915;
 //BA.debugLineNum = 21495915;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=21495916;
 //BA.debugLineNum = 21495916;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
mostCurrent._str1.Append("<tr style='text-align: center;'>");
RDebugUtils.currentLine=21495917;
 //BA.debugLineNum = 21495917;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
RDebugUtils.currentLine=21495918;
 //BA.debugLineNum = 21495918;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
RDebugUtils.currentLine=21495919;
 //BA.debugLineNum = 21495919;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
RDebugUtils.currentLine=21495920;
 //BA.debugLineNum = 21495920;BA.debugLine="str1.Append(\"<td>\").Append((myfunc.en2fa(dbCode";
mostCurrent._str1.Append("<td>").Append((mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")))).Append("</td>");
RDebugUtils.currentLine=21495921;
 //BA.debugLineNum = 21495921;BA.debugLine="str1.Append(\"<td>\").Append((myfunc.en2fa(dbCode";
mostCurrent._str1.Append("<td>").Append((mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")))+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))).Append("</td>");
RDebugUtils.currentLine=21495923;
 //BA.debugLineNum = 21495923;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
 }
;
RDebugUtils.currentLine=21495928;
 //BA.debugLineNum = 21495928;BA.debugLine="str1.Append(\"</table>\")";
mostCurrent._str1.Append("</table>");
RDebugUtils.currentLine=21495930;
 //BA.debugLineNum = 21495930;BA.debugLine="Dim list_morakhasi As List";
_list_morakhasi = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=21495931;
 //BA.debugLineNum = 21495931;BA.debugLine="list_morakhasi.Initialize";
_list_morakhasi.Initialize();
RDebugUtils.currentLine=21495933;
 //BA.debugLineNum = 21495933;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=21495934;
 //BA.debugLineNum = 21495934;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(sp_year";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num);
 }else {
RDebugUtils.currentLine=21495936;
 //BA.debugLineNum = 21495936;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_byDate(lbl_";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_bydate /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._lbl_date_to.getText());
 };
RDebugUtils.currentLine=21495940;
 //BA.debugLineNum = 21495940;BA.debugLine="str1.Append(\"مجموع مرخصی ها :<span style='color:";
mostCurrent._str1.Append("مجموع مرخصی ها :<span style='color:#5E35B1;'><b> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (0))))+" روز و "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (1))))+" ساعت و "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (2))))+" دقیقه ");
RDebugUtils.currentLine=21495942;
 //BA.debugLineNum = 21495942;BA.debugLine="str1.Append(\"</b></span><br></details></div><br>";
mostCurrent._str1.Append("</b></span><br></details></div><br>");
RDebugUtils.currentLine=21495948;
 //BA.debugLineNum = 21495948;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5 ;' ><details open>");
RDebugUtils.currentLine=21495949;
 //BA.debugLineNum = 21495949;BA.debugLine="str1.Append(\"<summary><b>محاسبه حقوق</b></summar";
mostCurrent._str1.Append("<summary><b>محاسبه حقوق</b></summary>");
RDebugUtils.currentLine=21495951;
 //BA.debugLineNum = 21495951;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr>\")";
mostCurrent._str1.Append("<table style='width:100%;'><tr>");
RDebugUtils.currentLine=21495952;
 //BA.debugLineNum = 21495952;BA.debugLine="str1.Append(\"<td><div style='text-align: center;";
mostCurrent._str1.Append("<td><div style='text-align: center;color:#661400;'><b> مزایا</b></div></td>");
RDebugUtils.currentLine=21495953;
 //BA.debugLineNum = 21495953;BA.debugLine="str1.Append(\"<td><div style='text-align: center;";
mostCurrent._str1.Append("<td><div style='text-align: center;color:#661400;'><b>کسورات</b></div></td> </tr>");
RDebugUtils.currentLine=21495954;
 //BA.debugLineNum = 21495954;BA.debugLine="str1.Append(\"<tr style='vertical-align: text-top";
mostCurrent._str1.Append("<tr style='vertical-align: text-top;'><td>");
RDebugUtils.currentLine=21495955;
 //BA.debugLineNum = 21495955;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(0)&\" برای \"&myfunc";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (0)))+" برای "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_roze_kari))+" روز کاری : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_paye_end))+"</span><br>");
RDebugUtils.currentLine=21495956;
 //BA.debugLineNum = 21495956;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(2)&\" : <span style";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (2)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maskan_end))+"</span><br>");
RDebugUtils.currentLine=21495957;
 //BA.debugLineNum = 21495957;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(3)&\" : <span styl";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (3)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bon_end))+"</span><br>");
RDebugUtils.currentLine=21495958;
 //BA.debugLineNum = 21495958;BA.debugLine="If(olad_end<>0)Then";
if ((_olad_end!=0)) { 
RDebugUtils.currentLine=21495959;
 //BA.debugLineNum = 21495959;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(4)&\"  :<span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (4)))+"  :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad_end))+"</span><br>");
 };
RDebugUtils.currentLine=21495961;
 //BA.debugLineNum = 21495961;BA.debugLine="If(sanavat_end<>0)Then";
if ((_sanavat_end!=0)) { 
RDebugUtils.currentLine=21495962;
 //BA.debugLineNum = 21495962;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(1)&\"  : <span sty";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (1)))+"  : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat_end))+"</span><br>");
 };
RDebugUtils.currentLine=21495964;
 //BA.debugLineNum = 21495964;BA.debugLine="If(fani_end<>0)Then";
if ((_fani_end!=0)) { 
RDebugUtils.currentLine=21495965;
 //BA.debugLineNum = 21495965;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(5)&\" : <span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (5)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_fani_end))+"</span><br>");
 };
RDebugUtils.currentLine=21495967;
 //BA.debugLineNum = 21495967;BA.debugLine="If(masoliat_end<>0)Then";
if ((_masoliat_end!=0)) { 
RDebugUtils.currentLine=21495968;
 //BA.debugLineNum = 21495968;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(6)&\" : <span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (6)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_masoliat_end))+"</span><br>");
 };
RDebugUtils.currentLine=21495970;
 //BA.debugLineNum = 21495970;BA.debugLine="If(sarparasti_end<>0)Then";
if ((_sarparasti_end!=0)) { 
RDebugUtils.currentLine=21495971;
 //BA.debugLineNum = 21495971;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(7)&\" : <span sty";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (7)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sarparasti_end))+"</span><br>");
 };
RDebugUtils.currentLine=21495973;
 //BA.debugLineNum = 21495973;BA.debugLine="If(shift_end<>0)Then";
if ((_shift_end!=0)) { 
RDebugUtils.currentLine=21495974;
 //BA.debugLineNum = 21495974;BA.debugLine="str1.Append(\" حق شیفت \"&myfunc.en2fa(shift)&\" د";
mostCurrent._str1.Append(" حق شیفت "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_shift))+" درصد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_shift_end))+"</span><br>");
 };
RDebugUtils.currentLine=21495978;
 //BA.debugLineNum = 21495978;BA.debugLine="If(dbCode.get_setting_byName(\"tog_padash\")=1)Th";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_padash")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21495979;
 //BA.debugLineNum = 21495979;BA.debugLine="If(padash_all<>0)Then";
if ((_padash_all!=0)) { 
RDebugUtils.currentLine=21495980;
 //BA.debugLineNum = 21495980;BA.debugLine="str1.Append(\"  پاداش : <span style='color:#5E";
mostCurrent._str1.Append("  پاداش : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_padash_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=21495984;
 //BA.debugLineNum = 21495984;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)The";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21495985;
 //BA.debugLineNum = 21495985;BA.debugLine="If(sayer_1_all<>0)Then";
if ((_sayer_1_all!=0)) { 
RDebugUtils.currentLine=21495986;
 //BA.debugLineNum = 21495986;BA.debugLine="str1.Append(\"  سایر: <span style='color:#5E35";
mostCurrent._str1.Append("  سایر: <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sayer_1_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=21495990;
 //BA.debugLineNum = 21495990;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21495991;
 //BA.debugLineNum = 21495991;BA.debugLine="If(ayab_1_all<>0)Then";
if ((_ayab_1_all!=0)) { 
RDebugUtils.currentLine=21495992;
 //BA.debugLineNum = 21495992;BA.debugLine="str1.Append(\" ایاب ذهاب: <span style='color:#";
mostCurrent._str1.Append(" ایاب ذهاب: <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ayab_1_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=21495997;
 //BA.debugLineNum = 21495997;BA.debugLine="If(mazaya_end<>0)Then";
if ((_mazaya_end!=0)) { 
RDebugUtils.currentLine=21495998;
 //BA.debugLineNum = 21495998;BA.debugLine="str1.Append(\"  \"&ls_onvanHa.Get(10)&\" : <span";
mostCurrent._str1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (10)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya_end))+"</span><br>");
 };
RDebugUtils.currentLine=21496007;
 //BA.debugLineNum = 21496007;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=21496008;
 //BA.debugLineNum = 21496008;BA.debugLine="str1.Append(\"اضافه کاری عادی\").Append(\"<br>\")";
mostCurrent._str1.Append("اضافه کاری عادی").Append("<br>");
RDebugUtils.currentLine=21496010;
 //BA.debugLineNum = 21496010;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B";
mostCurrent._str1.Append(" ساعات : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h.getText())+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m.getText())+"</span><br>");
RDebugUtils.currentLine=21496012;
 //BA.debugLineNum = 21496012;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5";
mostCurrent._str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_vahed_ezafekari))+"</span><br>");
RDebugUtils.currentLine=21496018;
 //BA.debugLineNum = 21496018;BA.debugLine="If(ezafekari_end_vij<>0)Then";
if ((_ezafekari_end_vij!=0)) { 
RDebugUtils.currentLine=21496019;
 //BA.debugLineNum = 21496019;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=21496021;
 //BA.debugLineNum = 21496021;BA.debugLine="str1.Append(\"اضافه کاری <span style='color:#ff4d";
mostCurrent._str1.Append("اضافه کاری <span style='color:#ff4d00;'>"+"فوق العاده"+"</span>").Append("<br>");
RDebugUtils.currentLine=21496023;
 //BA.debugLineNum = 21496023;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B1";
mostCurrent._str1.Append(" ساعات : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h_vij.getText())+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m_vij.getText())+"</span><br>");
RDebugUtils.currentLine=21496026;
 //BA.debugLineNum = 21496026;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5E";
mostCurrent._str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_vahed_ezafekari_vij))+"</span><br>");
 };
RDebugUtils.currentLine=21496030;
 //BA.debugLineNum = 21496030;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=21496031;
 //BA.debugLineNum = 21496031;BA.debugLine="str1.Append(\"مجموع اضافه کاری : <span style='col";
mostCurrent._str1.Append("مجموع اضافه کاری : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool((int) (_ezafekari_end+_ezafekari_end_vij)))+"</span><br></td>");
RDebugUtils.currentLine=21496034;
 //BA.debugLineNum = 21496034;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=21496037;
 //BA.debugLineNum = 21496037;BA.debugLine="str1.Append(\"بیمه تامین اجتماعی : <span style='";
mostCurrent._str1.Append("بیمه تامین اجتماعی : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_tamin_end))+"</span><br>");
RDebugUtils.currentLine=21496040;
 //BA.debugLineNum = 21496040;BA.debugLine="If(bime_takmil<>0)Then";
if ((_bime_takmil!=0)) { 
RDebugUtils.currentLine=21496041;
 //BA.debugLineNum = 21496041;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(9)&\" :<span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (9)))+" :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_takmil))+"</span><br>");
 };
RDebugUtils.currentLine=21496046;
 //BA.debugLineNum = 21496046;BA.debugLine="If(maliat_end<>0)Then";
if ((_maliat_end!=0)) { 
RDebugUtils.currentLine=21496047;
 //BA.debugLineNum = 21496047;BA.debugLine="str1.Append(\" مالیات : <span style='color:#5E3";
mostCurrent._str1.Append(" مالیات : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maliat_end))+"</span><br>");
 };
RDebugUtils.currentLine=21496051;
 //BA.debugLineNum = 21496051;BA.debugLine="If(dbCode.get_setting_byName(\"tog_mosaede\")=1)Th";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_mosaede")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21496052;
 //BA.debugLineNum = 21496052;BA.debugLine="If(mosaedeh_all<>0)Then";
if ((_mosaedeh_all!=0)) { 
RDebugUtils.currentLine=21496053;
 //BA.debugLineNum = 21496053;BA.debugLine="str1.Append(\" مساعده : <span style='color:#5E3";
mostCurrent._str1.Append(" مساعده : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mosaedeh_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=21496057;
 //BA.debugLineNum = 21496057;BA.debugLine="If(dbCode.get_setting_byName(\"tog_food\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21496058;
 //BA.debugLineNum = 21496058;BA.debugLine="If(food_all<>0)Then";
if ((_food_all!=0)) { 
RDebugUtils.currentLine=21496059;
 //BA.debugLineNum = 21496059;BA.debugLine="str1.Append(\" هزینه غذا : <span style='color:";
mostCurrent._str1.Append(" هزینه غذا : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_food_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=21496064;
 //BA.debugLineNum = 21496064;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)The";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21496065;
 //BA.debugLineNum = 21496065;BA.debugLine="If(sayer_2_all<>0)Then";
if ((_sayer_2_all!=0)) { 
RDebugUtils.currentLine=21496066;
 //BA.debugLineNum = 21496066;BA.debugLine="str1.Append(\" سایر : <span style='color:#5E35";
mostCurrent._str1.Append(" سایر : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sayer_2_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=21496070;
 //BA.debugLineNum = 21496070;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21496071;
 //BA.debugLineNum = 21496071;BA.debugLine="If(ayab_2_all<>0)Then";
if ((_ayab_2_all!=0)) { 
RDebugUtils.currentLine=21496072;
 //BA.debugLineNum = 21496072;BA.debugLine="str1.Append(\" ایاب ذهاب : <span style='color:";
mostCurrent._str1.Append(" ایاب ذهاب : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ayab_2_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=21496076;
 //BA.debugLineNum = 21496076;BA.debugLine="If(dbCode.get_setting_byName(\"tog_vam\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_vam")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21496077;
 //BA.debugLineNum = 21496077;BA.debugLine="If(gest_vam<>0)Then";
if ((_gest_vam!=0)) { 
RDebugUtils.currentLine=21496078;
 //BA.debugLineNum = 21496078;BA.debugLine="str1.Append(\" قسط وام  : <span style='color:#";
mostCurrent._str1.Append(" قسط وام  : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_gest_vam))+"</span><br>");
 };
 };
RDebugUtils.currentLine=21496086;
 //BA.debugLineNum = 21496086;BA.debugLine="If(ksorat<>0)Then";
if ((_ksorat!=0)) { 
RDebugUtils.currentLine=21496087;
 //BA.debugLineNum = 21496087;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(11)&\" : <span st";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (11)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat))+"</span></td>");
 };
RDebugUtils.currentLine=21496090;
 //BA.debugLineNum = 21496090;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
RDebugUtils.currentLine=21496092;
 //BA.debugLineNum = 21496092;BA.debugLine="str1.Append(\"<tr><td>\")";
mostCurrent._str1.Append("<tr><td>");
RDebugUtils.currentLine=21496093;
 //BA.debugLineNum = 21496093;BA.debugLine="str1.Append(\"جمع مزایا :  <span style='color:#5E";
mostCurrent._str1.Append("جمع مزایا :  <span style='color:#5E35B1;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_nakhales))+"</b></span>");
RDebugUtils.currentLine=21496094;
 //BA.debugLineNum = 21496094;BA.debugLine="str1.Append(\"</td><td>\")";
mostCurrent._str1.Append("</td><td>");
RDebugUtils.currentLine=21496096;
 //BA.debugLineNum = 21496096;BA.debugLine="str1.Append(\"جمع کسورات :  <span style='color:#5";
mostCurrent._str1.Append("جمع کسورات :  <span style='color:#5E35B1;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_jame_kosorat))+"</b></span>");
RDebugUtils.currentLine=21496097;
 //BA.debugLineNum = 21496097;BA.debugLine="str1.Append(\"</td></tr></table><br>\")";
mostCurrent._str1.Append("</td></tr></table><br>");
RDebugUtils.currentLine=21496099;
 //BA.debugLineNum = 21496099;BA.debugLine="str1.Append(\" دریافتی خالص :  <span style='color";
mostCurrent._str1.Append(" دریافتی خالص :  <span style='color:#388E3C;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_khales))+" </b></span></b>");
RDebugUtils.currentLine=21496100;
 //BA.debugLineNum = 21496100;BA.debugLine="str1.Append(\"<span style='font-size: 11px;'> توم";
mostCurrent._str1.Append("<span style='font-size: 11px;'> تومان </span>");
RDebugUtils.currentLine=21496102;
 //BA.debugLineNum = 21496102;BA.debugLine="str1.Append(\"<br></details></div>\")";
mostCurrent._str1.Append("<br></details></div>");
RDebugUtils.currentLine=21496104;
 //BA.debugLineNum = 21496104;BA.debugLine="str1.Append(\"<footer style=' text-align: center;";
mostCurrent._str1.Append("<footer style=' text-align: center; '><h6> اپلیکیشن اضافه کاری من </h6></footer>");
RDebugUtils.currentLine=21496106;
 //BA.debugLineNum = 21496106;BA.debugLine="str1.Append(\"</body></html>\")";
mostCurrent._str1.Append("</body></html>");
RDebugUtils.currentLine=21496108;
 //BA.debugLineNum = 21496108;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=21496109;
 //BA.debugLineNum = 21496109;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=21496114;
 //BA.debugLineNum = 21496114;BA.debugLine="WebView2.LoadHtml(str1.ToString)";
mostCurrent._webview2.LoadHtml(mostCurrent._str1.ToString());
 };
 };
RDebugUtils.currentLine=21496119;
 //BA.debugLineNum = 21496119;BA.debugLine="End Sub";
return "";
}
public static String  _mohasebe() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mohasebe", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "mohasebe", null));}
int _hogog_nakhales_maliaty = 0;
int _nak_mal = 0;
RDebugUtils.currentLine=21561344;
 //BA.debugLineNum = 21561344;BA.debugLine="Sub mohasebe";
RDebugUtils.currentLine=21561348;
 //BA.debugLineNum = 21561348;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=21561351;
 //BA.debugLineNum = 21561351;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=21561358;
 //BA.debugLineNum = 21561358;BA.debugLine="If (roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=21561359;
 //BA.debugLineNum = 21561359;BA.debugLine="maskan_end=(maskan/30)*roze_kari";
_maskan_end = (int) ((_maskan/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=21561361;
 //BA.debugLineNum = 21561361;BA.debugLine="maskan_end=maskan";
_maskan_end = _maskan;
 };
RDebugUtils.currentLine=21561366;
 //BA.debugLineNum = 21561366;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=21561367;
 //BA.debugLineNum = 21561367;BA.debugLine="bon_end=(bon/30)*roze_kari";
_bon_end = (int) ((_bon/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=21561369;
 //BA.debugLineNum = 21561369;BA.debugLine="bon_end=bon";
_bon_end = _bon;
 };
RDebugUtils.currentLine=21561374;
 //BA.debugLineNum = 21561374;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=21561375;
 //BA.debugLineNum = 21561375;BA.debugLine="olad_end=(olad/30)*roze_kari";
_olad_end = (int) ((_olad/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=21561377;
 //BA.debugLineNum = 21561377;BA.debugLine="olad_end=olad";
_olad_end = _olad;
 };
RDebugUtils.currentLine=21561382;
 //BA.debugLineNum = 21561382;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=21561383;
 //BA.debugLineNum = 21561383;BA.debugLine="fani_end=(fani/30)*roze_kari";
_fani_end = (int) ((_fani/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=21561385;
 //BA.debugLineNum = 21561385;BA.debugLine="fani_end=fani";
_fani_end = _fani;
 };
RDebugUtils.currentLine=21561389;
 //BA.debugLineNum = 21561389;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=21561390;
 //BA.debugLineNum = 21561390;BA.debugLine="masoliat_end=(masoliat/30)*roze_kari";
_masoliat_end = (int) ((_masoliat/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=21561392;
 //BA.debugLineNum = 21561392;BA.debugLine="masoliat_end=masoliat";
_masoliat_end = _masoliat;
 };
RDebugUtils.currentLine=21561396;
 //BA.debugLineNum = 21561396;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=21561397;
 //BA.debugLineNum = 21561397;BA.debugLine="sarparasti_end=(sarparasti/30)*roze_kari";
_sarparasti_end = (int) ((_sarparasti/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=21561399;
 //BA.debugLineNum = 21561399;BA.debugLine="sarparasti_end=sarparasti";
_sarparasti_end = _sarparasti;
 };
RDebugUtils.currentLine=21561403;
 //BA.debugLineNum = 21561403;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=21561404;
 //BA.debugLineNum = 21561404;BA.debugLine="mazaya_end=(mazaya/30)*roze_kari";
_mazaya_end = (int) ((_mazaya/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=21561406;
 //BA.debugLineNum = 21561406;BA.debugLine="mazaya_end=mazaya";
_mazaya_end = _mazaya;
 };
RDebugUtils.currentLine=21561410;
 //BA.debugLineNum = 21561410;BA.debugLine="shift_end=((paye_end+sanavat_end)*shift)/100";
_shift_end = (int) (((_paye_end+_sanavat_end)*_shift)/(double)100);
RDebugUtils.currentLine=21561413;
 //BA.debugLineNum = 21561413;BA.debugLine="vahed_ezafekari=et_vahed_ezafekari.Tag";
_vahed_ezafekari = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari.getTag()));
RDebugUtils.currentLine=21561414;
 //BA.debugLineNum = 21561414;BA.debugLine="ezafekari_end=vahed_ezafekari*(et_time_h.Text+(et";
_ezafekari_end = (int) (_vahed_ezafekari*((double)(Double.parseDouble(mostCurrent._et_time_h.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m.getText()))/(double)60)));
RDebugUtils.currentLine=21561418;
 //BA.debugLineNum = 21561418;BA.debugLine="vahed_ezafekari_vij=et_vahed_ezafekari_vij.Tag";
_vahed_ezafekari_vij = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari_vij.getTag()));
RDebugUtils.currentLine=21561419;
 //BA.debugLineNum = 21561419;BA.debugLine="ezafekari_end_vij=vahed_ezafekari_vij*(et_time_h_";
_ezafekari_end_vij = (int) (_vahed_ezafekari_vij*((double)(Double.parseDouble(mostCurrent._et_time_h_vij.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m_vij.getText()))/(double)60)));
RDebugUtils.currentLine=21561424;
 //BA.debugLineNum = 21561424;BA.debugLine="If(dbCode.get_setting_byName(\"tog_mosaede\")=1)The";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_mosaede")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21561425;
 //BA.debugLineNum = 21561425;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=21561426;
 //BA.debugLineNum = 21561426;BA.debugLine="mosaedeh_all=dbCode.all_mosaedeh_mah(sp_year.Se";
_mosaedeh_all = mostCurrent._dbcode._all_mosaedeh_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 }else {
RDebugUtils.currentLine=21561428;
 //BA.debugLineNum = 21561428;BA.debugLine="mosaedeh_all=dbCode.all_mosaedeh_byDate(lbl_dat";
_mosaedeh_all = mostCurrent._dbcode._all_mosaedeh_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed);
 };
 };
RDebugUtils.currentLine=21561432;
 //BA.debugLineNum = 21561432;BA.debugLine="If(dbCode.get_setting_byName(\"tog_food\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21561433;
 //BA.debugLineNum = 21561433;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=21561434;
 //BA.debugLineNum = 21561434;BA.debugLine="food_all=dbCode.all_food_mah(sp_year.SelectedIt";
_food_all = mostCurrent._dbcode._all_food_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 }else {
RDebugUtils.currentLine=21561436;
 //BA.debugLineNum = 21561436;BA.debugLine="food_all=dbCode.all_food_byDate(lbl_date_from.T";
_food_all = mostCurrent._dbcode._all_food_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed);
 };
 };
RDebugUtils.currentLine=21561443;
 //BA.debugLineNum = 21561443;BA.debugLine="If(dbCode.get_setting_byName(\"tog_padash\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_padash")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21561444;
 //BA.debugLineNum = 21561444;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=21561445;
 //BA.debugLineNum = 21561445;BA.debugLine="padash_all=dbCode.all_padash_mah(sp_year.Select";
_padash_all = mostCurrent._dbcode._all_padash_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 }else {
RDebugUtils.currentLine=21561447;
 //BA.debugLineNum = 21561447;BA.debugLine="padash_all=dbCode.all_padash_byDate(lbl_date_fr";
_padash_all = mostCurrent._dbcode._all_padash_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed);
 };
 };
RDebugUtils.currentLine=21561453;
 //BA.debugLineNum = 21561453;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21561454;
 //BA.debugLineNum = 21561454;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=21561455;
 //BA.debugLineNum = 21561455;BA.debugLine="sayer_1_all=dbCode.all_sayer_mah(sp_year.Select";
_sayer_1_all = mostCurrent._dbcode._all_sayer_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
RDebugUtils.currentLine=21561456;
 //BA.debugLineNum = 21561456;BA.debugLine="sayer_2_all=dbCode.all_sayer_mah(sp_year.Select";
_sayer_2_all = mostCurrent._dbcode._all_sayer_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (2));
 }else {
RDebugUtils.currentLine=21561458;
 //BA.debugLineNum = 21561458;BA.debugLine="sayer_1_all=dbCode.all_sayer_byDate(lbl_date_fr";
_sayer_1_all = mostCurrent._dbcode._all_sayer_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (1));
RDebugUtils.currentLine=21561459;
 //BA.debugLineNum = 21561459;BA.debugLine="sayer_2_all=dbCode.all_sayer_byDate(lbl_date_fr";
_sayer_2_all = mostCurrent._dbcode._all_sayer_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (2));
 };
 };
RDebugUtils.currentLine=21561465;
 //BA.debugLineNum = 21561465;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21561466;
 //BA.debugLineNum = 21561466;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=21561467;
 //BA.debugLineNum = 21561467;BA.debugLine="ayab_1_all=dbCode.all_ayabZahab_mah(sp_year.Sel";
_ayab_1_all = mostCurrent._dbcode._all_ayabzahab_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
RDebugUtils.currentLine=21561468;
 //BA.debugLineNum = 21561468;BA.debugLine="ayab_2_all=dbCode.all_ayabZahab_mah(sp_year.Sel";
_ayab_2_all = mostCurrent._dbcode._all_ayabzahab_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (2));
 }else {
RDebugUtils.currentLine=21561470;
 //BA.debugLineNum = 21561470;BA.debugLine="ayab_1_all=dbCode.all_ayabZahab_byDate(lbl_date";
_ayab_1_all = mostCurrent._dbcode._all_ayabzahab_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (1));
RDebugUtils.currentLine=21561471;
 //BA.debugLineNum = 21561471;BA.debugLine="ayab_2_all=dbCode.all_ayabZahab_byDate(lbl_date";
_ayab_2_all = mostCurrent._dbcode._all_ayabzahab_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (2));
 };
 };
RDebugUtils.currentLine=21561476;
 //BA.debugLineNum = 21561476;BA.debugLine="If(dbCode.get_setting_byName(\"tog_vam\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_vam")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21561477;
 //BA.debugLineNum = 21561477;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=21561478;
 //BA.debugLineNum = 21561478;BA.debugLine="gest_vam=dbCode.all_gestVam_mah(sp_year.Selecte";
_gest_vam = mostCurrent._dbcode._all_gestvam_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 }else {
RDebugUtils.currentLine=21561480;
 //BA.debugLineNum = 21561480;BA.debugLine="gest_vam=dbCode.all_gestVam_byDate(date2_fixed.";
_gest_vam = mostCurrent._dbcode._all_gestvam_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._date2_fixed.substring((int) (0),(int) (7)));
 };
 };
RDebugUtils.currentLine=21561488;
 //BA.debugLineNum = 21561488;BA.debugLine="hogog_nakhales=paye_end+ezafekari_end+ezafekari_e";
_hogog_nakhales = (int) (_paye_end+_ezafekari_end+_ezafekari_end_vij+_maskan_end+_bon_end+_olad_end+_fani_end+_masoliat_end+_sarparasti_end+_sanavat_end+_mazaya_end+_shift_end+_padash_all+_sayer_1_all+_ayab_1_all);
RDebugUtils.currentLine=21561491;
 //BA.debugLineNum = 21561491;BA.debugLine="Dim hogog_nakhales_maliaty As Int";
_hogog_nakhales_maliaty = 0;
RDebugUtils.currentLine=21561493;
 //BA.debugLineNum = 21561493;BA.debugLine="hogog_nakhales_maliaty=paye_end+ezafekari_end+eza";
_hogog_nakhales_maliaty = (int) (_paye_end+_ezafekari_end+_ezafekari_end_vij+_maskan_end+_bon_end+_olad_end+_fani_end+_masoliat_end+_sarparasti_end+_sanavat_end+_mazaya_end+_shift_end);
RDebugUtils.currentLine=21561497;
 //BA.debugLineNum = 21561497;BA.debugLine="If(dbCode.get_setting_byName(\"tog_bime\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_bime")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21561498;
 //BA.debugLineNum = 21561498;BA.debugLine="bime_tamin_end=(hogog_nakhales-olad_end)*0.07";
_bime_tamin_end = (int) ((_hogog_nakhales-_olad_end)*0.07);
 }else {
RDebugUtils.currentLine=21561502;
 //BA.debugLineNum = 21561502;BA.debugLine="If(et_bime.Tag=\"\")Then";
if (((mostCurrent._et_bime.getTag()).equals((Object)("")))) { 
RDebugUtils.currentLine=21561503;
 //BA.debugLineNum = 21561503;BA.debugLine="bime_tamin_end=0";
_bime_tamin_end = (int) (0);
RDebugUtils.currentLine=21561504;
 //BA.debugLineNum = 21561504;BA.debugLine="et_bime.Text=0";
mostCurrent._et_bime.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=21561505;
 //BA.debugLineNum = 21561505;BA.debugLine="et_bime.Tag=0";
mostCurrent._et_bime.setTag((Object)(0));
 }else {
RDebugUtils.currentLine=21561507;
 //BA.debugLineNum = 21561507;BA.debugLine="bime_tamin_end=et_bime.Tag";
_bime_tamin_end = (int)(BA.ObjectToNumber(mostCurrent._et_bime.getTag()));
 };
 };
RDebugUtils.currentLine=21561515;
 //BA.debugLineNum = 21561515;BA.debugLine="Dim nak_mal As Int";
_nak_mal = 0;
RDebugUtils.currentLine=21561516;
 //BA.debugLineNum = 21561516;BA.debugLine="nak_mal=hogog_nakhales_maliaty-((bime_tamin_end*2";
_nak_mal = (int) (_hogog_nakhales_maliaty-((_bime_tamin_end*2)/(double)7));
RDebugUtils.currentLine=21561519;
 //BA.debugLineNum = 21561519;BA.debugLine="If(dbCode.get_setting_byName(\"tog_maliat\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_maliat")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21561521;
 //BA.debugLineNum = 21561521;BA.debugLine="maliat_end=mohasebe_maliat(nak_mal,sp_year.Selec";
_maliat_end = _mohasebe_maliat(_nak_mal,(int)(Double.parseDouble(mostCurrent._sp_year.getSelectedItem())));
 }else {
RDebugUtils.currentLine=21561526;
 //BA.debugLineNum = 21561526;BA.debugLine="If(et_maliat.Tag=\"\")Then";
if (((mostCurrent._et_maliat.getTag()).equals((Object)("")))) { 
RDebugUtils.currentLine=21561527;
 //BA.debugLineNum = 21561527;BA.debugLine="maliat_end=0";
_maliat_end = (int) (0);
RDebugUtils.currentLine=21561528;
 //BA.debugLineNum = 21561528;BA.debugLine="et_maliat.Text=0";
mostCurrent._et_maliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=21561529;
 //BA.debugLineNum = 21561529;BA.debugLine="et_maliat.Tag=0";
mostCurrent._et_maliat.setTag((Object)(0));
 }else {
RDebugUtils.currentLine=21561531;
 //BA.debugLineNum = 21561531;BA.debugLine="maliat_end=et_maliat.Tag";
_maliat_end = (int)(BA.ObjectToNumber(mostCurrent._et_maliat.getTag()));
 };
 };
RDebugUtils.currentLine=21561538;
 //BA.debugLineNum = 21561538;BA.debugLine="jame_kosorat=bime_tamin_end+maliat_end+bime_takmi";
_jame_kosorat = (int) (_bime_tamin_end+_maliat_end+_bime_takmil+_ksorat+_mosaedeh_all+_food_all+_sayer_2_all+_ayab_2_all+_gest_vam);
RDebugUtils.currentLine=21561540;
 //BA.debugLineNum = 21561540;BA.debugLine="hogog_khales=hogog_nakhales-jame_kosorat";
_hogog_khales = (int) (_hogog_nakhales-_jame_kosorat);
RDebugUtils.currentLine=21561542;
 //BA.debugLineNum = 21561542;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_gozaresh_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_gozaresh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_gozaresh_click", null));}
RDebugUtils.currentLine=21823488;
 //BA.debugLineNum = 21823488;BA.debugLine="Private Sub lbl_save_gozaresh_Click";
RDebugUtils.currentLine=21823489;
 //BA.debugLineNum = 21823489;BA.debugLine="et_name_gozaresh.Text=sp_moon.SelectedItem&\" \"&sp";
mostCurrent._et_name_gozaresh.setText(BA.ObjectToCharSequence(mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._sp_year.getSelectedItem()));
RDebugUtils.currentLine=21823490;
 //BA.debugLineNum = 21823490;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=21823491;
 //BA.debugLineNum = 21823491;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_gozaresh_end_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_gozaresh_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_gozaresh_end_click", null));}
RDebugUtils.currentLine=22085632;
 //BA.debugLineNum = 22085632;BA.debugLine="Private Sub lbl_save_gozaresh_end_Click";
RDebugUtils.currentLine=22085633;
 //BA.debugLineNum = 22085633;BA.debugLine="save_gozaresh";
_save_gozaresh();
RDebugUtils.currentLine=22085634;
 //BA.debugLineNum = 22085634;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22085635;
 //BA.debugLineNum = 22085635;BA.debugLine="End Sub";
return "";
}
public static String  _save_gozaresh() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "save_gozaresh", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "save_gozaresh", null));}
boolean _chek = false;
anywheresoftware.b4a.objects.collections.List _alist = null;
RDebugUtils.currentLine=21889024;
 //BA.debugLineNum = 21889024;BA.debugLine="Sub save_gozaresh";
RDebugUtils.currentLine=21889027;
 //BA.debugLineNum = 21889027;BA.debugLine="Dim chek As Boolean";
_chek = false;
RDebugUtils.currentLine=21889028;
 //BA.debugLineNum = 21889028;BA.debugLine="chek=myfunc.check_karid";
_chek = mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=21889029;
 //BA.debugLineNum = 21889029;BA.debugLine="Dim alist As List";
_alist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=21889030;
 //BA.debugLineNum = 21889030;BA.debugLine="alist.Initialize";
_alist.Initialize();
RDebugUtils.currentLine=21889032;
 //BA.debugLineNum = 21889032;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(Main.persianDa";
_alist = mostCurrent._myfunc._num_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())),BA.NumberToString(01));
RDebugUtils.currentLine=21889035;
 //BA.debugLineNum = 21889035;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=21889036;
 //BA.debugLineNum = 21889036;BA.debugLine="If(alist.Get(2)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (2))))<5)) { 
RDebugUtils.currentLine=21889037;
 //BA.debugLineNum = 21889037;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDa";
mostCurrent._dbcode._add_gozaresh /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),mostCurrent._et_name_gozaresh.getText(),mostCurrent._et_tozih_gozaresh.getText(),mostCurrent._str1.ToString(),BA.NumberToString(_hogog_nakhales),BA.NumberToString(_hogog_khales));
RDebugUtils.currentLine=21889038;
 //BA.debugLineNum = 21889038;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("گزارش ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=21889040;
 //BA.debugLineNum = 21889040;BA.debugLine="Main.buy_index=1";
mostCurrent._main._buy_index /*int*/  = (int) (1);
RDebugUtils.currentLine=21889041;
 //BA.debugLineNum = 21889041;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=21889042;
 //BA.debugLineNum = 21889042;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 }else {
RDebugUtils.currentLine=21889045;
 //BA.debugLineNum = 21889045;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDat";
mostCurrent._dbcode._add_gozaresh /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),mostCurrent._et_name_gozaresh.getText(),mostCurrent._et_tozih_gozaresh.getText(),mostCurrent._str1.ToString(),BA.NumberToString(_hogog_nakhales),BA.NumberToString(_hogog_khales));
RDebugUtils.currentLine=21889046;
 //BA.debugLineNum = 21889046;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("گزارش ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=21889051;
 //BA.debugLineNum = 21889051;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_picker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_picker_click", null));}
RDebugUtils.currentLine=22937600;
 //BA.debugLineNum = 22937600;BA.debugLine="Private Sub lbl_save_picker_Click";
RDebugUtils.currentLine=22937602;
 //BA.debugLineNum = 22937602;BA.debugLine="If(index_datePik=1) Then";
if ((_index_datepik==1)) { 
RDebugUtils.currentLine=22937603;
 //BA.debugLineNum = 22937603;BA.debugLine="lbl_date_from.Text=pik_year1.Text&\"/\"&myfunc.con";
mostCurrent._lbl_date_from.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 }else 
{RDebugUtils.currentLine=22937605;
 //BA.debugLineNum = 22937605;BA.debugLine="Else If(index_datePik=2) Then";
if ((_index_datepik==2)) { 
RDebugUtils.currentLine=22937606;
 //BA.debugLineNum = 22937606;BA.debugLine="lbl_date_to.Text=pik_year1.Text&\"/\"&myfunc.conve";
mostCurrent._lbl_date_to.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=22937607;
 //BA.debugLineNum = 22937607;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
 }}
;
RDebugUtils.currentLine=22937610;
 //BA.debugLineNum = 22937610;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=22937612;
 //BA.debugLineNum = 22937612;BA.debugLine="et_rozekari.Text=myfunc.time_mohasebe(lbl_date_fr";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._time_mohasebe /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed)));
RDebugUtils.currentLine=22937613;
 //BA.debugLineNum = 22937613;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22937615;
 //BA.debugLineNum = 22937615;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_share_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_share_click", null));}
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
RDebugUtils.currentLine=22478848;
 //BA.debugLineNum = 22478848;BA.debugLine="Private Sub lbl_share_Click";
RDebugUtils.currentLine=22478849;
 //BA.debugLineNum = 22478849;BA.debugLine="Dim FileName As String =Main.current_gozaresh_id&";
_filename = BA.NumberToString(mostCurrent._main._current_gozaresh_id /*int*/ )+".html";
RDebugUtils.currentLine=22478852;
 //BA.debugLineNum = 22478852;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
anywheresoftware.b4a.keywords.Common.File.WriteString(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename,mostCurrent._str1.ToString());
RDebugUtils.currentLine=22478854;
 //BA.debugLineNum = 22478854;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=22478855;
 //BA.debugLineNum = 22478855;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
RDebugUtils.currentLine=22478856;
 //BA.debugLineNum = 22478856;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
RDebugUtils.currentLine=22478857;
 //BA.debugLineNum = 22478857;BA.debugLine="email.Body = \" گزارش حقوق \"&str1.ToString&CRLF&\"ا";
_email.Body = " گزارش حقوق "+mostCurrent._str1.ToString()+anywheresoftware.b4a.keywords.Common.CRLF+"اپلیکیشن اضافه کاری من"+anywheresoftware.b4a.keywords.Common.CRLF+"دانلود از بازار";
RDebugUtils.currentLine=22478858;
 //BA.debugLineNum = 22478858;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (null,_filename));
RDebugUtils.currentLine=22478860;
 //BA.debugLineNum = 22478860;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
RDebugUtils.currentLine=22478861;
 //BA.debugLineNum = 22478861;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
RDebugUtils.currentLine=22478862;
 //BA.debugLineNum = 22478862;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
RDebugUtils.currentLine=22478863;
 //BA.debugLineNum = 22478863;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=21626880;
 //BA.debugLineNum = 21626880;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
RDebugUtils.currentLine=21626881;
 //BA.debugLineNum = 21626881;BA.debugLine="Dim all_maliat As Int=0";
_all_maliat = (int) (0);
RDebugUtils.currentLine=21626882;
 //BA.debugLineNum = 21626882;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
RDebugUtils.currentLine=21626883;
 //BA.debugLineNum = 21626883;BA.debugLine="Dim state2 As Int=0";
_state2 = (int) (0);
RDebugUtils.currentLine=21626884;
 //BA.debugLineNum = 21626884;BA.debugLine="Dim state3 As Int=0";
_state3 = (int) (0);
RDebugUtils.currentLine=21626885;
 //BA.debugLineNum = 21626885;BA.debugLine="Dim state4 As Int=0";
_state4 = (int) (0);
RDebugUtils.currentLine=21626886;
 //BA.debugLineNum = 21626886;BA.debugLine="Dim state5 As Int=0";
_state5 = (int) (0);
RDebugUtils.currentLine=21626887;
 //BA.debugLineNum = 21626887;BA.debugLine="Dim state6 As Int=0";
_state6 = (int) (0);
RDebugUtils.currentLine=21626889;
 //BA.debugLineNum = 21626889;BA.debugLine="If (year=1399)Then";
if ((_year==1399)) { 
RDebugUtils.currentLine=21626890;
 //BA.debugLineNum = 21626890;BA.debugLine="If(hogog>3000001 And hogog<7500001)Then	  ''----";
if ((_hogog>3000001 && _hogog<7500001)) { 
RDebugUtils.currentLine=21626891;
 //BA.debugLineNum = 21626891;BA.debugLine="state1=(hogog-3000000)*0.1";
_state1 = (int) ((_hogog-3000000)*0.1);
 };
RDebugUtils.currentLine=21626893;
 //BA.debugLineNum = 21626893;BA.debugLine="If(hogog>7500001 And hogog<10500001)Then	  ''---";
if ((_hogog>7500001 && _hogog<10500001)) { 
RDebugUtils.currentLine=21626894;
 //BA.debugLineNum = 21626894;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=21626895;
 //BA.debugLineNum = 21626895;BA.debugLine="state2=(hogog-7500000)*0.15";
_state2 = (int) ((_hogog-7500000)*0.15);
 };
RDebugUtils.currentLine=21626897;
 //BA.debugLineNum = 21626897;BA.debugLine="If(hogog>10500001 And hogog<15000001)Then	  ''--";
if ((_hogog>10500001 && _hogog<15000001)) { 
RDebugUtils.currentLine=21626898;
 //BA.debugLineNum = 21626898;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=21626899;
 //BA.debugLineNum = 21626899;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=21626900;
 //BA.debugLineNum = 21626900;BA.debugLine="state3=(hogog-10500000)*0.2";
_state3 = (int) ((_hogog-10500000)*0.2);
 };
RDebugUtils.currentLine=21626902;
 //BA.debugLineNum = 21626902;BA.debugLine="If(hogog>15000001)Then	  ''-----stat4";
if ((_hogog>15000001)) { 
RDebugUtils.currentLine=21626903;
 //BA.debugLineNum = 21626903;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=21626904;
 //BA.debugLineNum = 21626904;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=21626905;
 //BA.debugLineNum = 21626905;BA.debugLine="state3=(4500000)*0.2";
_state3 = (int) ((4500000)*0.2);
RDebugUtils.currentLine=21626906;
 //BA.debugLineNum = 21626906;BA.debugLine="state4=(hogog-15000001)*0.25";
_state4 = (int) ((_hogog-15000001)*0.25);
 };
 };
RDebugUtils.currentLine=21626910;
 //BA.debugLineNum = 21626910;BA.debugLine="If (year=1400)Then";
if ((_year==1400)) { 
RDebugUtils.currentLine=21626911;
 //BA.debugLineNum = 21626911;BA.debugLine="If(hogog>4000001 And hogog<8000001)Then	  ''----";
if ((_hogog>4000001 && _hogog<8000001)) { 
RDebugUtils.currentLine=21626912;
 //BA.debugLineNum = 21626912;BA.debugLine="state1=(hogog-4000000)*0.1";
_state1 = (int) ((_hogog-4000000)*0.1);
 };
RDebugUtils.currentLine=21626914;
 //BA.debugLineNum = 21626914;BA.debugLine="If(hogog>8000001 And hogog<12000001)Then	  ''---";
if ((_hogog>8000001 && _hogog<12000001)) { 
RDebugUtils.currentLine=21626915;
 //BA.debugLineNum = 21626915;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=21626916;
 //BA.debugLineNum = 21626916;BA.debugLine="state2=(hogog-8000000)*0.15";
_state2 = (int) ((_hogog-8000000)*0.15);
 };
RDebugUtils.currentLine=21626918;
 //BA.debugLineNum = 21626918;BA.debugLine="If(hogog>12000001 And hogog<18000001)Then	  ''--";
if ((_hogog>12000001 && _hogog<18000001)) { 
RDebugUtils.currentLine=21626919;
 //BA.debugLineNum = 21626919;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=21626920;
 //BA.debugLineNum = 21626920;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=21626921;
 //BA.debugLineNum = 21626921;BA.debugLine="state3=(hogog-12000000)*0.2";
_state3 = (int) ((_hogog-12000000)*0.2);
 };
RDebugUtils.currentLine=21626923;
 //BA.debugLineNum = 21626923;BA.debugLine="If(hogog>18000001 And hogog<24000001)Then	  ''--";
if ((_hogog>18000001 && _hogog<24000001)) { 
RDebugUtils.currentLine=21626924;
 //BA.debugLineNum = 21626924;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=21626925;
 //BA.debugLineNum = 21626925;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=21626926;
 //BA.debugLineNum = 21626926;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=21626927;
 //BA.debugLineNum = 21626927;BA.debugLine="state4=(hogog-18000000)*0.25";
_state4 = (int) ((_hogog-18000000)*0.25);
 };
RDebugUtils.currentLine=21626929;
 //BA.debugLineNum = 21626929;BA.debugLine="If(hogog>24000001 And hogog<32000001)Then	  ''--";
if ((_hogog>24000001 && _hogog<32000001)) { 
RDebugUtils.currentLine=21626930;
 //BA.debugLineNum = 21626930;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=21626931;
 //BA.debugLineNum = 21626931;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=21626932;
 //BA.debugLineNum = 21626932;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=21626933;
 //BA.debugLineNum = 21626933;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=21626934;
 //BA.debugLineNum = 21626934;BA.debugLine="state5=(hogog-24000000)*0.3";
_state5 = (int) ((_hogog-24000000)*0.3);
 };
RDebugUtils.currentLine=21626936;
 //BA.debugLineNum = 21626936;BA.debugLine="If(hogog>32000001)Then	  ''-----stat4";
if ((_hogog>32000001)) { 
RDebugUtils.currentLine=21626937;
 //BA.debugLineNum = 21626937;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=21626938;
 //BA.debugLineNum = 21626938;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=21626939;
 //BA.debugLineNum = 21626939;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=21626940;
 //BA.debugLineNum = 21626940;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=21626941;
 //BA.debugLineNum = 21626941;BA.debugLine="state5=(6000000)*0.3";
_state5 = (int) ((6000000)*0.3);
RDebugUtils.currentLine=21626942;
 //BA.debugLineNum = 21626942;BA.debugLine="state6=(hogog-32000000)*0.35";
_state6 = (int) ((_hogog-32000000)*0.35);
 };
 };
RDebugUtils.currentLine=21626946;
 //BA.debugLineNum = 21626946;BA.debugLine="If (year=1401)Then";
if ((_year==1401)) { 
RDebugUtils.currentLine=21626947;
 //BA.debugLineNum = 21626947;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
if ((_hogog>5600001 && _hogog<12500001)) { 
RDebugUtils.currentLine=21626948;
 //BA.debugLineNum = 21626948;BA.debugLine="state1=(hogog-5600000)*0.1";
_state1 = (int) ((_hogog-5600000)*0.1);
 };
RDebugUtils.currentLine=21626950;
 //BA.debugLineNum = 21626950;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
if ((_hogog>12500001 && _hogog<20830001)) { 
RDebugUtils.currentLine=21626951;
 //BA.debugLineNum = 21626951;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=21626952;
 //BA.debugLineNum = 21626952;BA.debugLine="state2=(hogog-12500000)*0.15";
_state2 = (int) ((_hogog-12500000)*0.15);
 };
RDebugUtils.currentLine=21626954;
 //BA.debugLineNum = 21626954;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
if ((_hogog>20830001 && _hogog<29160001)) { 
RDebugUtils.currentLine=21626955;
 //BA.debugLineNum = 21626955;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=21626956;
 //BA.debugLineNum = 21626956;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=21626957;
 //BA.debugLineNum = 21626957;BA.debugLine="state3=(hogog-20830000)*0.2";
_state3 = (int) ((_hogog-20830000)*0.2);
 };
RDebugUtils.currentLine=21626960;
 //BA.debugLineNum = 21626960;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
if ((_hogog>29160001)) { 
RDebugUtils.currentLine=21626961;
 //BA.debugLineNum = 21626961;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=21626962;
 //BA.debugLineNum = 21626962;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=21626963;
 //BA.debugLineNum = 21626963;BA.debugLine="state3=(8330000)*0.2";
_state3 = (int) ((8330000)*0.2);
RDebugUtils.currentLine=21626965;
 //BA.debugLineNum = 21626965;BA.debugLine="state4=(hogog-29160000)*0.3";
_state4 = (int) ((_hogog-29160000)*0.3);
 };
 };
RDebugUtils.currentLine=21626970;
 //BA.debugLineNum = 21626970;BA.debugLine="If (year=1402)Then";
if ((_year==1402)) { 
RDebugUtils.currentLine=21626971;
 //BA.debugLineNum = 21626971;BA.debugLine="If(hogog>10000001 And hogog<14000001)Then	  ''--";
if ((_hogog>10000001 && _hogog<14000001)) { 
RDebugUtils.currentLine=21626972;
 //BA.debugLineNum = 21626972;BA.debugLine="state1=(hogog-10000000)*0.1";
_state1 = (int) ((_hogog-10000000)*0.1);
 };
RDebugUtils.currentLine=21626974;
 //BA.debugLineNum = 21626974;BA.debugLine="If(hogog>14000001 And hogog<23000001)Then	  ''--";
if ((_hogog>14000001 && _hogog<23000001)) { 
RDebugUtils.currentLine=21626975;
 //BA.debugLineNum = 21626975;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=21626976;
 //BA.debugLineNum = 21626976;BA.debugLine="state2=(hogog-14000000)*0.15";
_state2 = (int) ((_hogog-14000000)*0.15);
 };
RDebugUtils.currentLine=21626978;
 //BA.debugLineNum = 21626978;BA.debugLine="If(hogog>23000001 And hogog<34000001)Then	  ''--";
if ((_hogog>23000001 && _hogog<34000001)) { 
RDebugUtils.currentLine=21626979;
 //BA.debugLineNum = 21626979;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=21626980;
 //BA.debugLineNum = 21626980;BA.debugLine="state2=(9000000)*0.15";
_state2 = (int) ((9000000)*0.15);
RDebugUtils.currentLine=21626981;
 //BA.debugLineNum = 21626981;BA.debugLine="state3=(hogog-23000000)*0.2";
_state3 = (int) ((_hogog-23000000)*0.2);
 };
RDebugUtils.currentLine=21626984;
 //BA.debugLineNum = 21626984;BA.debugLine="If(hogog>34000001)Then	  ''-----stat4";
if ((_hogog>34000001)) { 
RDebugUtils.currentLine=21626985;
 //BA.debugLineNum = 21626985;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=21626986;
 //BA.debugLineNum = 21626986;BA.debugLine="state2=(9000000)*0.15";
_state2 = (int) ((9000000)*0.15);
RDebugUtils.currentLine=21626987;
 //BA.debugLineNum = 21626987;BA.debugLine="state3=(11000000)*0.2";
_state3 = (int) ((11000000)*0.2);
RDebugUtils.currentLine=21626989;
 //BA.debugLineNum = 21626989;BA.debugLine="state4=(hogog-34000001)*0.3";
_state4 = (int) ((_hogog-34000001)*0.3);
 };
 };
RDebugUtils.currentLine=21626993;
 //BA.debugLineNum = 21626993;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
_all_maliat = (int) (_state1+_state2+_state3+_state4+_state5+_state6);
RDebugUtils.currentLine=21626994;
 //BA.debugLineNum = 21626994;BA.debugLine="Return all_maliat";
if (true) return _all_maliat;
RDebugUtils.currentLine=21626996;
 //BA.debugLineNum = 21626996;BA.debugLine="End Sub";
return 0;
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=22216704;
 //BA.debugLineNum = 22216704;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=22216705;
 //BA.debugLineNum = 22216705;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22216706;
 //BA.debugLineNum = 22216706;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_set_date_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_set_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_set_date_click", null));}
RDebugUtils.currentLine=22872064;
 //BA.debugLineNum = 22872064;BA.debugLine="Private Sub pan_all_set_date_Click";
RDebugUtils.currentLine=22872065;
 //BA.debugLineNum = 22872065;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22872066;
 //BA.debugLineNum = 22872066;BA.debugLine="End Sub";
return "";
}
public static String  _pan_mohasebat_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_mohasebat_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_mohasebat_click", null));}
RDebugUtils.currentLine=22020096;
 //BA.debugLineNum = 22020096;BA.debugLine="Private Sub pan_mohasebat_Click";
RDebugUtils.currentLine=22020098;
 //BA.debugLineNum = 22020098;BA.debugLine="End Sub";
return "";
}
public static String  _panel7_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel7_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel7_click", null));}
RDebugUtils.currentLine=22151168;
 //BA.debugLineNum = 22151168;BA.debugLine="Private Sub Panel7_Click";
RDebugUtils.currentLine=22151170;
 //BA.debugLineNum = 22151170;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=23592960;
 //BA.debugLineNum = 23592960;BA.debugLine="Private Sub pik_day_bala1_Click";
RDebugUtils.currentLine=23592961;
 //BA.debugLineNum = 23592961;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=23592962;
 //BA.debugLineNum = 23592962;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=23592965;
 //BA.debugLineNum = 23592965;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=23592966;
 //BA.debugLineNum = 23592966;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=23592967;
 //BA.debugLineNum = 23592967;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=23592969;
 //BA.debugLineNum = 23592969;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=23592970;
 //BA.debugLineNum = 23592970;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=23592973;
 //BA.debugLineNum = 23592973;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=23592974;
 //BA.debugLineNum = 23592974;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=23592976;
 //BA.debugLineNum = 23592976;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=23592977;
 //BA.debugLineNum = 23592977;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=23592981;
 //BA.debugLineNum = 23592981;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=23658496;
 //BA.debugLineNum = 23658496;BA.debugLine="Private Sub pik_day_paeen1_Click";
RDebugUtils.currentLine=23658497;
 //BA.debugLineNum = 23658497;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=23658498;
 //BA.debugLineNum = 23658498;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=23658499;
 //BA.debugLineNum = 23658499;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=23658500;
 //BA.debugLineNum = 23658500;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=23658501;
 //BA.debugLineNum = 23658501;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=23658503;
 //BA.debugLineNum = 23658503;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=23658504;
 //BA.debugLineNum = 23658504;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=23658507;
 //BA.debugLineNum = 23658507;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=23658508;
 //BA.debugLineNum = 23658508;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=23658510;
 //BA.debugLineNum = 23658510;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=23658511;
 //BA.debugLineNum = 23658511;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=23658515;
 //BA.debugLineNum = 23658515;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=23330816;
 //BA.debugLineNum = 23330816;BA.debugLine="Private Sub pik_moon_bala1_Click";
RDebugUtils.currentLine=23330817;
 //BA.debugLineNum = 23330817;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=23330818;
 //BA.debugLineNum = 23330818;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
RDebugUtils.currentLine=23330820;
 //BA.debugLineNum = 23330820;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=23330821;
 //BA.debugLineNum = 23330821;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=23330823;
 //BA.debugLineNum = 23330823;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=23330824;
 //BA.debugLineNum = 23330824;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=23330826;
 //BA.debugLineNum = 23330826;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=23330828;
 //BA.debugLineNum = 23330828;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=23396352;
 //BA.debugLineNum = 23396352;BA.debugLine="Private Sub pik_moon_paeen1_Click";
RDebugUtils.currentLine=23396353;
 //BA.debugLineNum = 23396353;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=23396354;
 //BA.debugLineNum = 23396354;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
RDebugUtils.currentLine=23396356;
 //BA.debugLineNum = 23396356;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=23396357;
 //BA.debugLineNum = 23396357;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=23396359;
 //BA.debugLineNum = 23396359;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=23396360;
 //BA.debugLineNum = 23396360;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=23396362;
 //BA.debugLineNum = 23396362;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
RDebugUtils.currentLine=23396364;
 //BA.debugLineNum = 23396364;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_day1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_day1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=23265280;
 //BA.debugLineNum = 23265280;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
RDebugUtils.currentLine=23265281;
 //BA.debugLineNum = 23265281;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=23265282;
 //BA.debugLineNum = 23265282;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=23265283;
 //BA.debugLineNum = 23265283;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23265286;
 //BA.debugLineNum = 23265286;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=23265288;
 //BA.debugLineNum = 23265288;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=23265289;
 //BA.debugLineNum = 23265289;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
RDebugUtils.currentLine=23265290;
 //BA.debugLineNum = 23265290;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=23265291;
 //BA.debugLineNum = 23265291;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23265293;
 //BA.debugLineNum = 23265293;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=23265294;
 //BA.debugLineNum = 23265294;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
RDebugUtils.currentLine=23265295;
 //BA.debugLineNum = 23265295;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=23265296;
 //BA.debugLineNum = 23265296;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23265299;
 //BA.debugLineNum = 23265299;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=23265300;
 //BA.debugLineNum = 23265300;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=23265301;
 //BA.debugLineNum = 23265301;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=23265303;
 //BA.debugLineNum = 23265303;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=23265304;
 //BA.debugLineNum = 23265304;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=23265307;
 //BA.debugLineNum = 23265307;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=23265308;
 //BA.debugLineNum = 23265308;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=23265310;
 //BA.debugLineNum = 23265310;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=23265311;
 //BA.debugLineNum = 23265311;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 };
RDebugUtils.currentLine=23265318;
 //BA.debugLineNum = 23265318;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_moon1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_moon1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=23134208;
 //BA.debugLineNum = 23134208;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
RDebugUtils.currentLine=23134209;
 //BA.debugLineNum = 23134209;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=23134210;
 //BA.debugLineNum = 23134210;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=23134211;
 //BA.debugLineNum = 23134211;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23134214;
 //BA.debugLineNum = 23134214;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=23134216;
 //BA.debugLineNum = 23134216;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=23134217;
 //BA.debugLineNum = 23134217;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
RDebugUtils.currentLine=23134218;
 //BA.debugLineNum = 23134218;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=23134219;
 //BA.debugLineNum = 23134219;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23134221;
 //BA.debugLineNum = 23134221;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=23134222;
 //BA.debugLineNum = 23134222;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
RDebugUtils.currentLine=23134223;
 //BA.debugLineNum = 23134223;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=23134224;
 //BA.debugLineNum = 23134224;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23134227;
 //BA.debugLineNum = 23134227;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=23134228;
 //BA.debugLineNum = 23134228;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=23134230;
 //BA.debugLineNum = 23134230;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=23134231;
 //BA.debugLineNum = 23134231;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=23134233;
 //BA.debugLineNum = 23134233;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
RDebugUtils.currentLine=23134236;
 //BA.debugLineNum = 23134236;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_year1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_year1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=23199744;
 //BA.debugLineNum = 23199744;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
RDebugUtils.currentLine=23199745;
 //BA.debugLineNum = 23199745;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=23199746;
 //BA.debugLineNum = 23199746;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=23199747;
 //BA.debugLineNum = 23199747;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23199750;
 //BA.debugLineNum = 23199750;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=23199752;
 //BA.debugLineNum = 23199752;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=23199753;
 //BA.debugLineNum = 23199753;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
RDebugUtils.currentLine=23199754;
 //BA.debugLineNum = 23199754;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=23199755;
 //BA.debugLineNum = 23199755;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23199757;
 //BA.debugLineNum = 23199757;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=23199758;
 //BA.debugLineNum = 23199758;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
RDebugUtils.currentLine=23199759;
 //BA.debugLineNum = 23199759;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=23199760;
 //BA.debugLineNum = 23199760;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23199763;
 //BA.debugLineNum = 23199763;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=23199764;
 //BA.debugLineNum = 23199764;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=23199766;
 //BA.debugLineNum = 23199766;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=23199767;
 //BA.debugLineNum = 23199767;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
RDebugUtils.currentLine=23199772;
 //BA.debugLineNum = 23199772;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=23461888;
 //BA.debugLineNum = 23461888;BA.debugLine="Private Sub pik_year_bala1_Click";
RDebugUtils.currentLine=23461889;
 //BA.debugLineNum = 23461889;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=23461890;
 //BA.debugLineNum = 23461890;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=23461892;
 //BA.debugLineNum = 23461892;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=23461893;
 //BA.debugLineNum = 23461893;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=23461895;
 //BA.debugLineNum = 23461895;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=23461896;
 //BA.debugLineNum = 23461896;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=23461899;
 //BA.debugLineNum = 23461899;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=23527424;
 //BA.debugLineNum = 23527424;BA.debugLine="Private Sub pik_year_paeen1_Click";
RDebugUtils.currentLine=23527425;
 //BA.debugLineNum = 23527425;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=23527426;
 //BA.debugLineNum = 23527426;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=23527428;
 //BA.debugLineNum = 23527428;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=23527429;
 //BA.debugLineNum = 23527429;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=23527431;
 //BA.debugLineNum = 23527431;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=23527432;
 //BA.debugLineNum = 23527432;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=23527435;
 //BA.debugLineNum = 23527435;BA.debugLine="End Sub";
return "";
}
public static String  _radio_type1_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "radio_type1_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "radio_type1_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=22675456;
 //BA.debugLineNum = 22675456;BA.debugLine="Private Sub radio_type1_CheckedChange(Checked As B";
RDebugUtils.currentLine=22675457;
 //BA.debugLineNum = 22675457;BA.debugLine="sp_moon.Enabled=True";
mostCurrent._sp_moon.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22675458;
 //BA.debugLineNum = 22675458;BA.debugLine="sp_year.Enabled=True";
mostCurrent._sp_year.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22675459;
 //BA.debugLineNum = 22675459;BA.debugLine="lbl_date_from.Enabled=False";
mostCurrent._lbl_date_from.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22675460;
 //BA.debugLineNum = 22675460;BA.debugLine="lbl_date_to.Enabled=False";
mostCurrent._lbl_date_to.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22675461;
 //BA.debugLineNum = 22675461;BA.debugLine="type_mohasebe=1";
_type_mohasebe = (int) (1);
RDebugUtils.currentLine=22675462;
 //BA.debugLineNum = 22675462;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
RDebugUtils.currentLine=22675463;
 //BA.debugLineNum = 22675463;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=22675464;
 //BA.debugLineNum = 22675464;BA.debugLine="End Sub";
return "";
}
public static String  _radio_type2_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "radio_type2_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "radio_type2_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=22609920;
 //BA.debugLineNum = 22609920;BA.debugLine="Private Sub radio_type2_CheckedChange(Checked As B";
RDebugUtils.currentLine=22609921;
 //BA.debugLineNum = 22609921;BA.debugLine="sp_moon.Enabled=False";
mostCurrent._sp_moon.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22609922;
 //BA.debugLineNum = 22609922;BA.debugLine="sp_year.Enabled=False";
mostCurrent._sp_year.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22609923;
 //BA.debugLineNum = 22609923;BA.debugLine="lbl_date_from.Enabled=True";
mostCurrent._lbl_date_from.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22609924;
 //BA.debugLineNum = 22609924;BA.debugLine="lbl_date_to.Enabled=True";
mostCurrent._lbl_date_to.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22609925;
 //BA.debugLineNum = 22609925;BA.debugLine="type_mohasebe=2";
_type_mohasebe = (int) (2);
RDebugUtils.currentLine=22609926;
 //BA.debugLineNum = 22609926;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
RDebugUtils.currentLine=22609927;
 //BA.debugLineNum = 22609927;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=22609928;
 //BA.debugLineNum = 22609928;BA.debugLine="End Sub";
return "";
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_moon_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_moon_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=21692416;
 //BA.debugLineNum = 21692416;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=21692417;
 //BA.debugLineNum = 21692417;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=21692419;
 //BA.debugLineNum = 21692419;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=21757952;
 //BA.debugLineNum = 21757952;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=21757953;
 //BA.debugLineNum = 21757953;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=21757954;
 //BA.debugLineNum = 21757954;BA.debugLine="End Sub";
return "";
}
public static String  _time_page_load_tick() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time_page_load_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "time_page_load_tick", null));}
RDebugUtils.currentLine=20971520;
 //BA.debugLineNum = 20971520;BA.debugLine="Sub time_page_load_Tick";
RDebugUtils.currentLine=20971521;
 //BA.debugLineNum = 20971521;BA.debugLine="pan_load.Visible=False";
mostCurrent._pan_load.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=20971522;
 //BA.debugLineNum = 20971522;BA.debugLine="B4XLoadingIndicator1.Hide";
mostCurrent._b4xloadingindicator1._hide /*String*/ (null);
RDebugUtils.currentLine=20971523;
 //BA.debugLineNum = 20971523;BA.debugLine="Main.time_page_load.Enabled=False";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=20971524;
 //BA.debugLineNum = 20971524;BA.debugLine="End Sub";
return "";
}
}