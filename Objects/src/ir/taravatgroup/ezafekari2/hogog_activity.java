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
RDebugUtils.currentLine=21299200;
 //BA.debugLineNum = 21299200;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=21299202;
 //BA.debugLineNum = 21299202;BA.debugLine="Activity.LoadLayout(\"hogog_layout\")";
mostCurrent._activity.LoadLayout("hogog_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=21299203;
 //BA.debugLineNum = 21299203;BA.debugLine="scv_hogog.Panel.LoadLayout(\"item_hogog\")";
mostCurrent._scv_hogog.getPanel().LoadLayout("item_hogog",mostCurrent.activityBA);
RDebugUtils.currentLine=21299205;
 //BA.debugLineNum = 21299205;BA.debugLine="get_data_hogogi";
_get_data_hogogi();
RDebugUtils.currentLine=21299207;
 //BA.debugLineNum = 21299207;BA.debugLine="Main.time_page_load.Initialize(\"time_page_load\",1";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .Initialize(processBA,"time_page_load",(long) (1500));
RDebugUtils.currentLine=21299208;
 //BA.debugLineNum = 21299208;BA.debugLine="Main.time_page_load.Enabled=True";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=21299209;
 //BA.debugLineNum = 21299209;BA.debugLine="B4XLoadingIndicator1.Show";
mostCurrent._b4xloadingindicator1._show /*String*/ (null);
RDebugUtils.currentLine=21299211;
 //BA.debugLineNum = 21299211;BA.debugLine="sp_year.Add(\"1404\")";
mostCurrent._sp_year.Add("1404");
RDebugUtils.currentLine=21299212;
 //BA.debugLineNum = 21299212;BA.debugLine="sp_year.Add(\"1403\")";
mostCurrent._sp_year.Add("1403");
RDebugUtils.currentLine=21299213;
 //BA.debugLineNum = 21299213;BA.debugLine="sp_year.Add(\"1402\")";
mostCurrent._sp_year.Add("1402");
RDebugUtils.currentLine=21299214;
 //BA.debugLineNum = 21299214;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
RDebugUtils.currentLine=21299215;
 //BA.debugLineNum = 21299215;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
RDebugUtils.currentLine=21299216;
 //BA.debugLineNum = 21299216;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
RDebugUtils.currentLine=21299217;
 //BA.debugLineNum = 21299217;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
RDebugUtils.currentLine=21299219;
 //BA.debugLineNum = 21299219;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=21299221;
 //BA.debugLineNum = 21299221;BA.debugLine="Dim imm As BitmapDrawable";
_imm = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=21299222;
 //BA.debugLineNum = 21299222;BA.debugLine="imm.Initialize(LoadBitmap(File.DirAssets,\"textBox";
_imm.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"textBox.png").getObject()));
RDebugUtils.currentLine=21299223;
 //BA.debugLineNum = 21299223;BA.debugLine="imm.Gravity=Gravity.FILL";
_imm.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=21299224;
 //BA.debugLineNum = 21299224;BA.debugLine="sp_year.Background=imm";
mostCurrent._sp_year.setBackground((android.graphics.drawable.Drawable)(_imm.getObject()));
RDebugUtils.currentLine=21299225;
 //BA.debugLineNum = 21299225;BA.debugLine="sp_moon.Background=imm";
mostCurrent._sp_moon.setBackground((android.graphics.drawable.Drawable)(_imm.getObject()));
RDebugUtils.currentLine=21299228;
 //BA.debugLineNum = 21299228;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))-1));
RDebugUtils.currentLine=21299233;
 //BA.debugLineNum = 21299233;BA.debugLine="WebView1.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview1.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=21299234;
 //BA.debugLineNum = 21299234;BA.debugLine="WebView2.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview2.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=21299237;
 //BA.debugLineNum = 21299237;BA.debugLine="ls_onvanHa.Initialize";
mostCurrent._ls_onvanha.Initialize();
RDebugUtils.currentLine=21299238;
 //BA.debugLineNum = 21299238;BA.debugLine="ls_onvanHa=dbCode.read_onvan_db";
mostCurrent._ls_onvanha = mostCurrent._dbcode._read_onvan_db /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=21299241;
 //BA.debugLineNum = 21299241;BA.debugLine="str_web1.Initialize";
mostCurrent._str_web1.Initialize();
RDebugUtils.currentLine=21299242;
 //BA.debugLineNum = 21299242;BA.debugLine="str_web1.Append(\"<html dir='rtl'><meta charset='U";
mostCurrent._str_web1.Append("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>");
RDebugUtils.currentLine=21299243;
 //BA.debugLineNum = 21299243;BA.debugLine="str_web1.Append(\"<h4 align='center' >اطلاعات حقوق";
mostCurrent._str_web1.Append("<h4 align='center' >اطلاعات حقوق برای ۳۰ روز</h4>");
RDebugUtils.currentLine=21299245;
 //BA.debugLineNum = 21299245;BA.debugLine="str_web1.Append(\"<table style='width:100%'><tr>\")";
mostCurrent._str_web1.Append("<table style='width:100%'><tr>");
RDebugUtils.currentLine=21299246;
 //BA.debugLineNum = 21299246;BA.debugLine="str_web1.Append(\"<td>\"&\"\"&ls_onvanHa.Get(0)&\" : \"";
mostCurrent._str_web1.Append("<td>"+""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (0)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool((int)(Double.parseDouble(mostCurrent._paye))))+"<br>");
RDebugUtils.currentLine=21299247;
 //BA.debugLineNum = 21299247;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(2)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (2)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maskan))+"<br>");
RDebugUtils.currentLine=21299248;
 //BA.debugLineNum = 21299248;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(3)&\" : \"&myfun";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (3)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bon))+"<br>");
RDebugUtils.currentLine=21299249;
 //BA.debugLineNum = 21299249;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(13)&\" : \"&myfu";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (13)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hamsar))+"<br>");
RDebugUtils.currentLine=21299251;
 //BA.debugLineNum = 21299251;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(4)&\"  : \"&myfun";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (4)))+"  : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad))+"<br>");
RDebugUtils.currentLine=21299252;
 //BA.debugLineNum = 21299252;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(5)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (5)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_fani))+"<br>");
RDebugUtils.currentLine=21299253;
 //BA.debugLineNum = 21299253;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(6)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (6)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_masoliat))+"<br>");
RDebugUtils.currentLine=21299254;
 //BA.debugLineNum = 21299254;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(7)&\"  : \"&myfu";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (7)))+"  : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sarparasti))+"<br></td>");
RDebugUtils.currentLine=21299258;
 //BA.debugLineNum = 21299258;BA.debugLine="str_web1.Append(\"<td>\"&\" \"&ls_onvanHa.Get(1)&\" :";
mostCurrent._str_web1.Append("<td>"+" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (1)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat))+"<br>");
RDebugUtils.currentLine=21299259;
 //BA.debugLineNum = 21299259;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(8)&\" : \"&myfun";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (8)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_shift))+"<br>");
RDebugUtils.currentLine=21299260;
 //BA.debugLineNum = 21299260;BA.debugLine="str_web1.Append(\"بیمه تامین اجتماعی : %\"&myfunc.e";
mostCurrent._str_web1.Append("بیمه تامین اجتماعی : %"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_bime_tamin))+"<br>");
RDebugUtils.currentLine=21299261;
 //BA.debugLineNum = 21299261;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(9)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (9)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_takmil))+"<br>");
RDebugUtils.currentLine=21299262;
 //BA.debugLineNum = 21299262;BA.debugLine="str_web1.Append(\" مالیات : مطابق قانون کار<br>\")";
mostCurrent._str_web1.Append(" مالیات : مطابق قانون کار<br>");
RDebugUtils.currentLine=21299263;
 //BA.debugLineNum = 21299263;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(10)&\" : \"&myf";
mostCurrent._str_web1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (10)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya))+"<br>");
RDebugUtils.currentLine=21299264;
 //BA.debugLineNum = 21299264;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(11)&\" : \"&myf";
mostCurrent._str_web1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (11)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat))+"</td>");
RDebugUtils.currentLine=21299265;
 //BA.debugLineNum = 21299265;BA.debugLine="str_web1.Append(\"</tr></table>\")";
mostCurrent._str_web1.Append("</tr></table>");
RDebugUtils.currentLine=21299266;
 //BA.debugLineNum = 21299266;BA.debugLine="str_web1.Append(\"</body></html>\")";
mostCurrent._str_web1.Append("</body></html>");
RDebugUtils.currentLine=21299268;
 //BA.debugLineNum = 21299268;BA.debugLine="WebView1.LoadHtml(str_web1)";
mostCurrent._webview1.LoadHtml(BA.ObjectToString(mostCurrent._str_web1));
RDebugUtils.currentLine=21299273;
 //BA.debugLineNum = 21299273;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
RDebugUtils.currentLine=21299274;
 //BA.debugLineNum = 21299274;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=21299276;
 //BA.debugLineNum = 21299276;BA.debugLine="lbl_date_from.Text=myfunc.fa2en(Main.persianDate.";
mostCurrent._lbl_date_from.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear()))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianDay())))))));
RDebugUtils.currentLine=21299277;
 //BA.debugLineNum = 21299277;BA.debugLine="lbl_date_to.Text=myfunc.fa2en(Main.persianDate.Pe";
mostCurrent._lbl_date_to.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear()))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))+1))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianDay())))))));
RDebugUtils.currentLine=21299283;
 //BA.debugLineNum = 21299283;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
RDebugUtils.currentLine=21299286;
 //BA.debugLineNum = 21299286;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=21299288;
 //BA.debugLineNum = 21299288;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=21299289;
 //BA.debugLineNum = 21299289;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
RDebugUtils.currentLine=21299292;
 //BA.debugLineNum = 21299292;BA.debugLine="If(dbCode.get_setting_byName(\"tog_maliat\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_maliat")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21299293;
 //BA.debugLineNum = 21299293;BA.debugLine="et_maliat.Text=\"محاسبه اتوماتیک\"";
mostCurrent._et_maliat.setText(BA.ObjectToCharSequence("محاسبه اتوماتیک"));
RDebugUtils.currentLine=21299294;
 //BA.debugLineNum = 21299294;BA.debugLine="et_maliat.Enabled=False";
mostCurrent._et_maliat.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=21299296;
 //BA.debugLineNum = 21299296;BA.debugLine="et_maliat.Text=0";
mostCurrent._et_maliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=21299297;
 //BA.debugLineNum = 21299297;BA.debugLine="et_maliat.Tag=0";
mostCurrent._et_maliat.setTag((Object)(0));
RDebugUtils.currentLine=21299298;
 //BA.debugLineNum = 21299298;BA.debugLine="et_maliat.Enabled=True";
mostCurrent._et_maliat.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=21299301;
 //BA.debugLineNum = 21299301;BA.debugLine="If(dbCode.get_setting_byName(\"tog_bime\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_bime")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=21299302;
 //BA.debugLineNum = 21299302;BA.debugLine="et_bime.Text=\"محاسبه اتوماتیک\"";
mostCurrent._et_bime.setText(BA.ObjectToCharSequence("محاسبه اتوماتیک"));
RDebugUtils.currentLine=21299303;
 //BA.debugLineNum = 21299303;BA.debugLine="et_bime.Enabled=False";
mostCurrent._et_bime.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=21299305;
 //BA.debugLineNum = 21299305;BA.debugLine="et_bime.Text=0";
mostCurrent._et_bime.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=21299306;
 //BA.debugLineNum = 21299306;BA.debugLine="et_bime.Tag=0";
mostCurrent._et_bime.setTag((Object)(0));
RDebugUtils.currentLine=21299307;
 //BA.debugLineNum = 21299307;BA.debugLine="et_bime.Enabled=True";
mostCurrent._et_bime.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=21299314;
 //BA.debugLineNum = 21299314;BA.debugLine="pan_hed_hogog.Color=Main.color4";
mostCurrent._pan_hed_hogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=21299315;
 //BA.debugLineNum = 21299315;BA.debugLine="pan_main_hed_hogog.Color=Main.color4";
mostCurrent._pan_main_hed_hogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=21299316;
 //BA.debugLineNum = 21299316;BA.debugLine="pan_hed_gozaresh.Color=Main.color4";
mostCurrent._pan_hed_gozaresh.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=21299317;
 //BA.debugLineNum = 21299317;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=21299320;
 //BA.debugLineNum = 21299320;BA.debugLine="End Sub";
return "";
}
public static String  _get_data_hogogi() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_data_hogogi", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_data_hogogi", null));}
RDebugUtils.currentLine=22151168;
 //BA.debugLineNum = 22151168;BA.debugLine="Sub get_data_hogogi";
RDebugUtils.currentLine=22151170;
 //BA.debugLineNum = 22151170;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=22151171;
 //BA.debugLineNum = 22151171;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=22151173;
 //BA.debugLineNum = 22151173;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=22151174;
 //BA.debugLineNum = 22151174;BA.debugLine="paye=dbCode.res.GetString(\"value\")";
mostCurrent._paye = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value");
RDebugUtils.currentLine=22151176;
 //BA.debugLineNum = 22151176;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (1));
RDebugUtils.currentLine=22151177;
 //BA.debugLineNum = 22151177;BA.debugLine="maskan=dbCode.res.GetString(\"value\")";
_maskan = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=22151179;
 //BA.debugLineNum = 22151179;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (3));
RDebugUtils.currentLine=22151180;
 //BA.debugLineNum = 22151180;BA.debugLine="olad=dbCode.res.GetString(\"value\")";
_olad = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=22151182;
 //BA.debugLineNum = 22151182;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (4));
RDebugUtils.currentLine=22151183;
 //BA.debugLineNum = 22151183;BA.debugLine="fani=dbCode.res.GetString(\"value\")";
_fani = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=22151185;
 //BA.debugLineNum = 22151185;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (5));
RDebugUtils.currentLine=22151186;
 //BA.debugLineNum = 22151186;BA.debugLine="masoliat=dbCode.res.GetString(\"value\")";
_masoliat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=22151188;
 //BA.debugLineNum = 22151188;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (2));
RDebugUtils.currentLine=22151189;
 //BA.debugLineNum = 22151189;BA.debugLine="bon=dbCode.res.GetString(\"value\")";
_bon = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=22151194;
 //BA.debugLineNum = 22151194;BA.debugLine="dbCode.res.Position=6 ''--------bime_tamin------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (6));
RDebugUtils.currentLine=22151195;
 //BA.debugLineNum = 22151195;BA.debugLine="bime_tamin=dbCode.res.GetString(\"value\")";
_bime_tamin = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=22151197;
 //BA.debugLineNum = 22151197;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (11));
RDebugUtils.currentLine=22151198;
 //BA.debugLineNum = 22151198;BA.debugLine="bime_takmil=dbCode.res.GetString(\"value\")";
_bime_takmil = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=22151206;
 //BA.debugLineNum = 22151206;BA.debugLine="dbCode.res.Position=13 ''--------hag shift------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (13));
RDebugUtils.currentLine=22151207;
 //BA.debugLineNum = 22151207;BA.debugLine="shift=dbCode.res.GetString(\"value\")";
_shift = (double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=22151209;
 //BA.debugLineNum = 22151209;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (14));
RDebugUtils.currentLine=22151210;
 //BA.debugLineNum = 22151210;BA.debugLine="sanavat=dbCode.res.GetString(\"value\")";
_sanavat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=22151212;
 //BA.debugLineNum = 22151212;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (15));
RDebugUtils.currentLine=22151213;
 //BA.debugLineNum = 22151213;BA.debugLine="sarparasti=dbCode.res.GetString(\"value\")";
_sarparasti = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=22151215;
 //BA.debugLineNum = 22151215;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (16));
RDebugUtils.currentLine=22151216;
 //BA.debugLineNum = 22151216;BA.debugLine="mazaya=dbCode.res.GetString(\"value\")";
_mazaya = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=22151218;
 //BA.debugLineNum = 22151218;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (19));
RDebugUtils.currentLine=22151219;
 //BA.debugLineNum = 22151219;BA.debugLine="ksorat=dbCode.res.GetString(\"value\")";
_ksorat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=22151229;
 //BA.debugLineNum = 22151229;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=22151230;
 //BA.debugLineNum = 22151230;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=22151234;
 //BA.debugLineNum = 22151234;BA.debugLine="hamsar=dbCode.get_setting_byName(\"hag_hamsar\")";
_hamsar = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"hag_hamsar")));
RDebugUtils.currentLine=22151237;
 //BA.debugLineNum = 22151237;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(int _num) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_num_pool", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_num_pool", new Object[] {_num}));}
RDebugUtils.currentLine=21757952;
 //BA.debugLineNum = 21757952;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=21757953;
 //BA.debugLineNum = 21757953;BA.debugLine="Return NumberFormat(num,0,0)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (0));
RDebugUtils.currentLine=21757954;
 //BA.debugLineNum = 21757954;BA.debugLine="End Sub";
return "";
}
public static String  _fix_date2_decreceone() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fix_date2_decreceone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fix_date2_decreceone", null));}
int _y_date2 = 0;
int _m_date2 = 0;
int _d_date2 = 0;
RDebugUtils.currentLine=21364736;
 //BA.debugLineNum = 21364736;BA.debugLine="Sub fix_date2_decreceOne";
RDebugUtils.currentLine=21364739;
 //BA.debugLineNum = 21364739;BA.debugLine="Dim y_date2 As Int =myfunc.fa2en( lbl_date_to.Tex";
_y_date2 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=21364740;
 //BA.debugLineNum = 21364740;BA.debugLine="Dim m_date2 As Int =myfunc.fa2en(lbl_date_to.Text";
_m_date2 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=21364741;
 //BA.debugLineNum = 21364741;BA.debugLine="Dim d_date2 As Int =myfunc.fa2en(lbl_date_to.Text";
_d_date2 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=21364762;
 //BA.debugLineNum = 21364762;BA.debugLine="date2_fixed=y_date2&\"/\"&myfunc.convert_adad(m_dat";
mostCurrent._date2_fixed = BA.NumberToString(_y_date2)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_m_date2)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_d_date2);
RDebugUtils.currentLine=21364765;
 //BA.debugLineNum = 21364765;BA.debugLine="End Sub";
return "";
}
public static String  _et_time_indb() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_time_indb", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_time_indb", null));}
anywheresoftware.b4a.objects.collections.List _list_ezafekari1 = null;
anywheresoftware.b4a.objects.collections.List _list_ezafekari2 = null;
RDebugUtils.currentLine=21823488;
 //BA.debugLineNum = 21823488;BA.debugLine="Sub et_time_inDB";
RDebugUtils.currentLine=21823491;
 //BA.debugLineNum = 21823491;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
mostCurrent._moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=21823494;
 //BA.debugLineNum = 21823494;BA.debugLine="Dim list_ezafekari1 As List";
_list_ezafekari1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=21823495;
 //BA.debugLineNum = 21823495;BA.debugLine="list_ezafekari1.Initialize";
_list_ezafekari1.Initialize();
RDebugUtils.currentLine=21823498;
 //BA.debugLineNum = 21823498;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=21823499;
 //BA.debugLineNum = 21823499;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_mah(myfunc.";
_list_ezafekari1 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem()),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._moon_num),(int) (2));
 }else {
RDebugUtils.currentLine=21823501;
 //BA.debugLineNum = 21823501;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_byDate(myfu";
_list_ezafekari1 = mostCurrent._dbcode._all_ezafekari_bydate /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText()),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._date2_fixed),(int) (2));
 };
RDebugUtils.currentLine=21823504;
 //BA.debugLineNum = 21823504;BA.debugLine="et_time_h.Text=list_ezafekari1.Get(0)";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (0))));
RDebugUtils.currentLine=21823505;
 //BA.debugLineNum = 21823505;BA.debugLine="et_time_m.Text=list_ezafekari1.Get(1)";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (1))));
RDebugUtils.currentLine=21823508;
 //BA.debugLineNum = 21823508;BA.debugLine="Dim list_ezafekari2 As List";
_list_ezafekari2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=21823509;
 //BA.debugLineNum = 21823509;BA.debugLine="list_ezafekari2.Initialize";
_list_ezafekari2.Initialize();
RDebugUtils.currentLine=21823512;
 //BA.debugLineNum = 21823512;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=21823513;
 //BA.debugLineNum = 21823513;BA.debugLine="list_ezafekari2=dbCode.all_ezafekari_mah(sp_year";
_list_ezafekari2 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num,(int) (3));
 }else {
RDebugUtils.currentLine=21823515;
 //BA.debugLineNum = 21823515;BA.debugLine="list_ezafekari2=dbCode.all_ezafekari_byDate(myfu";
_list_ezafekari2 = mostCurrent._dbcode._all_ezafekari_bydate /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText()),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._date2_fixed),(int) (3));
 };
RDebugUtils.currentLine=21823518;
 //BA.debugLineNum = 21823518;BA.debugLine="et_time_h_vij.Text=list_ezafekari2.Get(0)";
mostCurrent._et_time_h_vij.setText(BA.ObjectToCharSequence(_list_ezafekari2.Get((int) (0))));
RDebugUtils.currentLine=21823519;
 //BA.debugLineNum = 21823519;BA.debugLine="et_time_m_vij.Text=list_ezafekari2.Get(1)";
mostCurrent._et_time_m_vij.setText(BA.ObjectToCharSequence(_list_ezafekari2.Get((int) (1))));
RDebugUtils.currentLine=21823522;
 //BA.debugLineNum = 21823522;BA.debugLine="If(moon_num<7)Then";
if (((double)(Double.parseDouble(mostCurrent._moon_num))<7)) { 
RDebugUtils.currentLine=21823523;
 //BA.debugLineNum = 21823523;BA.debugLine="roze_kari=31";
_roze_kari = (int) (31);
 }else {
RDebugUtils.currentLine=21823525;
 //BA.debugLineNum = 21823525;BA.debugLine="roze_kari=30";
_roze_kari = (int) (30);
 };
RDebugUtils.currentLine=21823529;
 //BA.debugLineNum = 21823529;BA.debugLine="et_rozekari.Text=roze_kari";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(_roze_kari));
RDebugUtils.currentLine=21823530;
 //BA.debugLineNum = 21823530;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "calc_vahed_ezafekari", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "calc_vahed_ezafekari", null));}
RDebugUtils.currentLine=21430272;
 //BA.debugLineNum = 21430272;BA.debugLine="Sub calc_vahed_ezafekari";
RDebugUtils.currentLine=21430274;
 //BA.debugLineNum = 21430274;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=21430277;
 //BA.debugLineNum = 21430277;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=21430280;
 //BA.debugLineNum = 21430280;BA.debugLine="vahed_ezafekari=((paye+sanavat)/220)*1.4";
_vahed_ezafekari = (int) ((((double)(Double.parseDouble(mostCurrent._paye))+_sanavat)/(double)220)*1.4);
RDebugUtils.currentLine=21430285;
 //BA.debugLineNum = 21430285;BA.debugLine="et_vahed_ezafekari.Tag=vahed_ezafekari";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_vahed_ezafekari));
RDebugUtils.currentLine=21430286;
 //BA.debugLineNum = 21430286;BA.debugLine="et_vahed_ezafekari.Text=myfunc.show_num_pool(vahe";
mostCurrent._et_vahed_ezafekari.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari)));
RDebugUtils.currentLine=21430289;
 //BA.debugLineNum = 21430289;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari_vij() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "calc_vahed_ezafekari_vij", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "calc_vahed_ezafekari_vij", null));}
RDebugUtils.currentLine=21495808;
 //BA.debugLineNum = 21495808;BA.debugLine="Sub calc_vahed_ezafekari_vij";
RDebugUtils.currentLine=21495810;
 //BA.debugLineNum = 21495810;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=21495813;
 //BA.debugLineNum = 21495813;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=21495816;
 //BA.debugLineNum = 21495816;BA.debugLine="vahed_ezafekari_vij=((paye+sanavat)/220)*1.8";
_vahed_ezafekari_vij = (int) ((((double)(Double.parseDouble(mostCurrent._paye))+_sanavat)/(double)220)*1.8);
RDebugUtils.currentLine=21495821;
 //BA.debugLineNum = 21495821;BA.debugLine="et_vahed_ezafekari_vij.Tag=vahed_ezafekari_vij";
mostCurrent._et_vahed_ezafekari_vij.setTag((Object)(_vahed_ezafekari_vij));
RDebugUtils.currentLine=21495822;
 //BA.debugLineNum = 21495822;BA.debugLine="et_vahed_ezafekari_vij.Text=myfunc.show_num_pool(";
mostCurrent._et_vahed_ezafekari_vij.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari_vij)));
RDebugUtils.currentLine=21495824;
 //BA.debugLineNum = 21495824;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=22085632;
 //BA.debugLineNum = 22085632;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=22085633;
 //BA.debugLineNum = 22085633;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=22085634;
 //BA.debugLineNum = 22085634;BA.debugLine="If(pan_mohasebat.Visible=True)Then";
if ((mostCurrent._pan_mohasebat.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=22085635;
 //BA.debugLineNum = 22085635;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
mostCurrent._pan_mohasebat.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=22085637;
 //BA.debugLineNum = 22085637;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
RDebugUtils.currentLine=22085640;
 //BA.debugLineNum = 22085640;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=22085642;
 //BA.debugLineNum = 22085642;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=22085644;
 //BA.debugLineNum = 22085644;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=22020096;
 //BA.debugLineNum = 22020096;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=22020098;
 //BA.debugLineNum = 22020098;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=22020099;
 //BA.debugLineNum = 22020099;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=22020101;
 //BA.debugLineNum = 22020101;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="hogog_activity";
RDebugUtils.currentLine=21954560;
 //BA.debugLineNum = 21954560;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=21954562;
 //BA.debugLineNum = 21954562;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=21889024;
 //BA.debugLineNum = 21889024;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=21889026;
 //BA.debugLineNum = 21889026;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=23789568;
 //BA.debugLineNum = 23789568;BA.debugLine="Sub check_date_iscorrect As Boolean";
RDebugUtils.currentLine=23789570;
 //BA.debugLineNum = 23789570;BA.debugLine="Dim y1_shamsi As Int =myfunc.fa2en( lbl_date_from";
_y1_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=23789571;
 //BA.debugLineNum = 23789571;BA.debugLine="Dim m1_shamsi As Int =myfunc.fa2en(lbl_date_from.";
_m1_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=23789572;
 //BA.debugLineNum = 23789572;BA.debugLine="Dim d1_shamsi As Int =myfunc.fa2en(lbl_date_from.";
_d1_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=23789575;
 //BA.debugLineNum = 23789575;BA.debugLine="Dim y2_shamsi As Int =myfunc.fa2en(lbl_date_to.Te";
_y2_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=23789576;
 //BA.debugLineNum = 23789576;BA.debugLine="Dim m2_shamsi As Int =myfunc.fa2en(lbl_date_to.Te";
_m2_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=23789577;
 //BA.debugLineNum = 23789577;BA.debugLine="Dim d2_shamsi As Int =myfunc.fa2en(lbl_date_to.Te";
_d2_shamsi = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=23789580;
 //BA.debugLineNum = 23789580;BA.debugLine="Dim rozzzz As Int=0";
_rozzzz = (int) (0);
RDebugUtils.currentLine=23789581;
 //BA.debugLineNum = 23789581;BA.debugLine="Dim check_date As Boolean = True";
_check_date = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=23789583;
 //BA.debugLineNum = 23789583;BA.debugLine="Dim mah1 As Int=count_mah(m1_shamsi)";
_mah1 = _count_mah(_m1_shamsi);
RDebugUtils.currentLine=23789588;
 //BA.debugLineNum = 23789588;BA.debugLine="If(m2_shamsi-m1_shamsi)=0 Then";
if ((_m2_shamsi-_m1_shamsi)==0) { 
RDebugUtils.currentLine=23789589;
 //BA.debugLineNum = 23789589;BA.debugLine="rozzzz=d2_shamsi-d1_shamsi";
_rozzzz = (int) (_d2_shamsi-_d1_shamsi);
RDebugUtils.currentLine=23789590;
 //BA.debugLineNum = 23789590;BA.debugLine="If(y2_shamsi-y1_shamsi <> 0) Then";
if ((_y2_shamsi-_y1_shamsi!=0)) { 
RDebugUtils.currentLine=23789591;
 //BA.debugLineNum = 23789591;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else 
{RDebugUtils.currentLine=23789593;
 //BA.debugLineNum = 23789593;BA.debugLine="Else If (m2_shamsi-m1_shamsi)=1 Then";
if ((_m2_shamsi-_m1_shamsi)==1) { 
RDebugUtils.currentLine=23789594;
 //BA.debugLineNum = 23789594;BA.debugLine="rozzzz=(mah1-d1_shamsi) + (d2_shamsi)";
_rozzzz = (int) ((_mah1-_d1_shamsi)+(_d2_shamsi));
RDebugUtils.currentLine=23789596;
 //BA.debugLineNum = 23789596;BA.debugLine="If(y2_shamsi-y1_shamsi <> 0) Then";
if ((_y2_shamsi-_y1_shamsi!=0)) { 
RDebugUtils.currentLine=23789597;
 //BA.debugLineNum = 23789597;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else 
{RDebugUtils.currentLine=23789600;
 //BA.debugLineNum = 23789600;BA.debugLine="Else if ((m2_shamsi-m1_shamsi)=-11 ) Then";
if (((_m2_shamsi-_m1_shamsi)==-11)) { 
RDebugUtils.currentLine=23789601;
 //BA.debugLineNum = 23789601;BA.debugLine="rozzzz=(mah1-d1_shamsi) + (d2_shamsi)";
_rozzzz = (int) ((_mah1-_d1_shamsi)+(_d2_shamsi));
RDebugUtils.currentLine=23789602;
 //BA.debugLineNum = 23789602;BA.debugLine="If(y2_shamsi-y1_shamsi <> 0) Then";
if ((_y2_shamsi-_y1_shamsi!=0)) { 
RDebugUtils.currentLine=23789603;
 //BA.debugLineNum = 23789603;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else 
{RDebugUtils.currentLine=23789605;
 //BA.debugLineNum = 23789605;BA.debugLine="Else if ((m2_shamsi-m1_shamsi)>-11  And (m2_shams";
if (((_m2_shamsi-_m1_shamsi)>-11 && (_m2_shamsi-_m1_shamsi)<0)) { 
RDebugUtils.currentLine=23789606;
 //BA.debugLineNum = 23789606;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=23789608;
 //BA.debugLineNum = 23789608;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 }}}}
;
RDebugUtils.currentLine=23789612;
 //BA.debugLineNum = 23789612;BA.debugLine="If(check_date=True)Then";
if ((_check_date==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=23789613;
 //BA.debugLineNum = 23789613;BA.debugLine="If(rozzzz>31)Then";
if ((_rozzzz>31)) { 
RDebugUtils.currentLine=23789614;
 //BA.debugLineNum = 23789614;BA.debugLine="ToastMessageShow(\"تاریخ را اصلاح کنید - حداکثر";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تاریخ را اصلاح کنید - حداکثر 31 روز باشد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=23789615;
 //BA.debugLineNum = 23789615;BA.debugLine="check_date=False";
_check_date = anywheresoftware.b4a.keywords.Common.False;
 };
 }else {
RDebugUtils.currentLine=23789618;
 //BA.debugLineNum = 23789618;BA.debugLine="ToastMessageShow(\"تاریخ را اصلاح کنید - حداکثر 3";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تاریخ را اصلاح کنید - حداکثر 31 روز باشد"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=23789622;
 //BA.debugLineNum = 23789622;BA.debugLine="Return check_date";
if (true) return _check_date;
RDebugUtils.currentLine=23789623;
 //BA.debugLineNum = 23789623;BA.debugLine="End Sub";
return false;
}
public static int  _count_mah(int _adad_mah) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "count_mah", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "count_mah", new Object[] {_adad_mah}));}
int _res = 0;
RDebugUtils.currentLine=23724032;
 //BA.debugLineNum = 23724032;BA.debugLine="Sub count_mah (adad_mah As Int) As Int";
RDebugUtils.currentLine=23724033;
 //BA.debugLineNum = 23724033;BA.debugLine="Dim res As Int=0";
_res = (int) (0);
RDebugUtils.currentLine=23724034;
 //BA.debugLineNum = 23724034;BA.debugLine="If(adad_mah<7)Then";
if ((_adad_mah<7)) { 
RDebugUtils.currentLine=23724035;
 //BA.debugLineNum = 23724035;BA.debugLine="res=31";
_res = (int) (31);
 }else {
RDebugUtils.currentLine=23724037;
 //BA.debugLineNum = 23724037;BA.debugLine="res=30";
_res = (int) (30);
 };
RDebugUtils.currentLine=23724040;
 //BA.debugLineNum = 23724040;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=23724042;
 //BA.debugLineNum = 23724042;BA.debugLine="End Sub";
return 0;
}
public static String  _et_bime_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_bime_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_bime_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=24510464;
 //BA.debugLineNum = 24510464;BA.debugLine="Private Sub et_bime_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=24510465;
 //BA.debugLineNum = 24510465;BA.debugLine="et_bime.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_bime.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=24510466;
 //BA.debugLineNum = 24510466;BA.debugLine="myfunc.change_formater(Old,New,et_bime)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_bime);
RDebugUtils.currentLine=24510467;
 //BA.debugLineNum = 24510467;BA.debugLine="End Sub";
return "";
}
public static String  _et_maliat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_maliat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_maliat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=24444928;
 //BA.debugLineNum = 24444928;BA.debugLine="Private Sub et_maliat_TextChanged (Old As String,";
RDebugUtils.currentLine=24444929;
 //BA.debugLineNum = 24444929;BA.debugLine="et_maliat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_maliat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=24444930;
 //BA.debugLineNum = 24444930;BA.debugLine="myfunc.change_formater(Old,New,et_maliat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_maliat);
RDebugUtils.currentLine=24444931;
 //BA.debugLineNum = 24444931;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_vahed_ezafekari_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_vahed_ezafekari_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=21561344;
 //BA.debugLineNum = 21561344;BA.debugLine="Private Sub et_vahed_ezafekari_TextChanged (Old As";
RDebugUtils.currentLine=21561345;
 //BA.debugLineNum = 21561345;BA.debugLine="et_vahed_ezafekari.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=21561346;
 //BA.debugLineNum = 21561346;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari);
RDebugUtils.currentLine=21561347;
 //BA.debugLineNum = 21561347;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_vij_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_vahed_ezafekari_vij_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_vahed_ezafekari_vij_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=21626880;
 //BA.debugLineNum = 21626880;BA.debugLine="Private Sub et_vahed_ezafekari_vij_TextChanged (Ol";
RDebugUtils.currentLine=21626881;
 //BA.debugLineNum = 21626881;BA.debugLine="et_vahed_ezafekari_vij.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari_vij.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=21626882;
 //BA.debugLineNum = 21626882;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari_vij);
RDebugUtils.currentLine=21626883;
 //BA.debugLineNum = 21626883;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_backto_hogog_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_backto_hogog_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_backto_hogog_click", null));}
RDebugUtils.currentLine=22675456;
 //BA.debugLineNum = 22675456;BA.debugLine="Private Sub lbl_backTo_hogog_Click";
RDebugUtils.currentLine=22675458;
 //BA.debugLineNum = 22675458;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
mostCurrent._pan_mohasebat.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22675459;
 //BA.debugLineNum = 22675459;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_from_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date_from_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date_from_click", null));}
RDebugUtils.currentLine=23461888;
 //BA.debugLineNum = 23461888;BA.debugLine="Private Sub lbl_date_from_Click";
RDebugUtils.currentLine=23461889;
 //BA.debugLineNum = 23461889;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=23461890;
 //BA.debugLineNum = 23461890;BA.debugLine="index_datePik=1";
_index_datepik = (int) (1);
RDebugUtils.currentLine=23461892;
 //BA.debugLineNum = 23461892;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_from.Text.Su";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=23461893;
 //BA.debugLineNum = 23461893;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_from.Text.Sub";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=23461894;
 //BA.debugLineNum = 23461894;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=23461895;
 //BA.debugLineNum = 23461895;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_from.Text.Sub";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=23461899;
 //BA.debugLineNum = 23461899;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_to_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date_to_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date_to_click", null));}
RDebugUtils.currentLine=23527424;
 //BA.debugLineNum = 23527424;BA.debugLine="Private Sub lbl_date_to_Click";
RDebugUtils.currentLine=23527425;
 //BA.debugLineNum = 23527425;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=23527426;
 //BA.debugLineNum = 23527426;BA.debugLine="index_datePik=2";
_index_datepik = (int) (2);
RDebugUtils.currentLine=23527428;
 //BA.debugLineNum = 23527428;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_to.Text.SubS";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=23527429;
 //BA.debugLineNum = 23527429;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_to.Text.SubSt";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=23527430;
 //BA.debugLineNum = 23527430;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=23527431;
 //BA.debugLineNum = 23527431;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_to.Text.SubSt";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_to.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=23527434;
 //BA.debugLineNum = 23527434;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_tatil_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_tatil_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_tatil_click", null));}
RDebugUtils.currentLine=23134208;
 //BA.debugLineNum = 23134208;BA.debugLine="Private Sub lbl_help_tatil_Click";
RDebugUtils.currentLine=23134210;
 //BA.debugLineNum = 23134210;BA.debugLine="myfunc.help_man(\"راهنما\",\"روزهای جمعه که برای آن";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","روزهای جمعه که برای آن روز دیگری را تعطیل نکنند، اضافه کاری فوق العاده محسوب و با ضریب 1.8 محاسبه می شود.");
RDebugUtils.currentLine=23134211;
 //BA.debugLineNum = 23134211;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_print_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_print_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_print_click", null));}
RDebugUtils.currentLine=23265280;
 //BA.debugLineNum = 23265280;BA.debugLine="Private Sub lbl_print_Click";
RDebugUtils.currentLine=23265282;
 //BA.debugLineNum = 23265282;BA.debugLine="printer.Initialize(\"\")";
mostCurrent._printer.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=23265285;
 //BA.debugLineNum = 23265285;BA.debugLine="printer.PrintWebView(\"job\",WebView2)";
mostCurrent._printer.PrintWebView("job",(android.webkit.WebView)(mostCurrent._webview2.getObject()));
RDebugUtils.currentLine=23265286;
 //BA.debugLineNum = 23265286;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_refresh_vahed_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_refresh_vahed_click", null));}
RDebugUtils.currentLine=23003136;
 //BA.debugLineNum = 23003136;BA.debugLine="Private Sub lbl_refresh_vahed_Click";
RDebugUtils.currentLine=23003137;
 //BA.debugLineNum = 23003137;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=23003138;
 //BA.debugLineNum = 23003138;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_vij_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_refresh_vahed_vij_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_refresh_vahed_vij_click", null));}
RDebugUtils.currentLine=23068672;
 //BA.debugLineNum = 23068672;BA.debugLine="Private Sub lbl_refresh_vahed_vij_Click";
RDebugUtils.currentLine=23068673;
 //BA.debugLineNum = 23068673;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
RDebugUtils.currentLine=23068674;
 //BA.debugLineNum = 23068674;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run_mohasebe_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_ezafe = null;
anywheresoftware.b4a.objects.collections.List _list_morakhasi = null;
RDebugUtils.currentLine=22216704;
 //BA.debugLineNum = 22216704;BA.debugLine="Private Sub lbl_run_mohasebe_Click";
RDebugUtils.currentLine=22216705;
 //BA.debugLineNum = 22216705;BA.debugLine="If(et_rozekari.Text=\"\")Then";
if (((mostCurrent._et_rozekari.getText()).equals(""))) { 
RDebugUtils.currentLine=22216706;
 //BA.debugLineNum = 22216706;BA.debugLine="et_rozekari.Text=0";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=22216709;
 //BA.debugLineNum = 22216709;BA.debugLine="roze_kari=et_rozekari.Text";
_roze_kari = (int)(Double.parseDouble(mostCurrent._et_rozekari.getText()));
RDebugUtils.currentLine=22216711;
 //BA.debugLineNum = 22216711;BA.debugLine="If(et_time_h.Text=\"\")Then";
if (((mostCurrent._et_time_h.getText()).equals(""))) { 
RDebugUtils.currentLine=22216712;
 //BA.debugLineNum = 22216712;BA.debugLine="et_time_h.Text=0";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=22216714;
 //BA.debugLineNum = 22216714;BA.debugLine="If(et_time_m.Text=\"\")Then";
if (((mostCurrent._et_time_m.getText()).equals(""))) { 
RDebugUtils.currentLine=22216715;
 //BA.debugLineNum = 22216715;BA.debugLine="et_time_m.Text=0";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=22216718;
 //BA.debugLineNum = 22216718;BA.debugLine="If(et_time_h_vij.Text=\"\")Then";
if (((mostCurrent._et_time_h_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=22216719;
 //BA.debugLineNum = 22216719;BA.debugLine="et_time_h_vij.Text=0";
mostCurrent._et_time_h_vij.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=22216721;
 //BA.debugLineNum = 22216721;BA.debugLine="If(et_time_m_vij.Text=\"\")Then";
if (((mostCurrent._et_time_m_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=22216722;
 //BA.debugLineNum = 22216722;BA.debugLine="et_time_m_vij.Text=0";
mostCurrent._et_time_m_vij.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=22216727;
 //BA.debugLineNum = 22216727;BA.debugLine="If(et_vahed_ezafekari.Text=\"\")Then";
if (((mostCurrent._et_vahed_ezafekari.getText()).equals(""))) { 
RDebugUtils.currentLine=22216728;
 //BA.debugLineNum = 22216728;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
 };
RDebugUtils.currentLine=22216730;
 //BA.debugLineNum = 22216730;BA.debugLine="If(et_vahed_ezafekari_vij.Text=\"\")Then";
if (((mostCurrent._et_vahed_ezafekari_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=22216731;
 //BA.debugLineNum = 22216731;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
 };
RDebugUtils.currentLine=22216735;
 //BA.debugLineNum = 22216735;BA.debugLine="If (roze_kari > 31 Or roze_kari < 0)Then";
if ((_roze_kari>31 || _roze_kari<0)) { 
RDebugUtils.currentLine=22216736;
 //BA.debugLineNum = 22216736;BA.debugLine="ToastMessageShow(\" تعداد روز کاری نادرست است\",Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" تعداد روز کاری نادرست است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=22216738;
 //BA.debugLineNum = 22216738;BA.debugLine="If(check_date_iscorrect=True)Then";
if ((_check_date_iscorrect()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=22216739;
 //BA.debugLineNum = 22216739;BA.debugLine="pan_mohasebat.Visible=True";
mostCurrent._pan_mohasebat.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22216740;
 //BA.debugLineNum = 22216740;BA.debugLine="pan_mohasebat.SetLayoutAnimated(100,0,0,100%x,10";
mostCurrent._pan_mohasebat.SetLayoutAnimated((int) (100),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=22216741;
 //BA.debugLineNum = 22216741;BA.debugLine="mohasebe";
_mohasebe();
RDebugUtils.currentLine=22216746;
 //BA.debugLineNum = 22216746;BA.debugLine="str1.Initialize";
mostCurrent._str1.Initialize();
RDebugUtils.currentLine=22216748;
 //BA.debugLineNum = 22216748;BA.debugLine="str1.Append(\"<!DOCTYPE html><html dir='rtl' lang";
mostCurrent._str1.Append("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>");
RDebugUtils.currentLine=22216749;
 //BA.debugLineNum = 22216749;BA.debugLine="str1.Append(\"<style>table , td {border: 1px soli";
mostCurrent._str1.Append("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	summary {	font-weight: bold;	margin: -.5em -.5em 0;	padding: .5em;} details[open] {	padding: .5em;	}	details[open] summary {border-bottom: 1px solid #aaa;margin-bottom: .5em;}</style>");
RDebugUtils.currentLine=22216753;
 //BA.debugLineNum = 22216753;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=22216754;
 //BA.debugLineNum = 22216754;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=22216755;
 //BA.debugLineNum = 22216755;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+mostCurrent._sp_year.getSelectedItem()+"/"+mostCurrent._moon_num+"%';")));
RDebugUtils.currentLine=22216756;
 //BA.debugLineNum = 22216756;BA.debugLine="str1.Append(\"<h3>\").Append(\"گزارش \"& sp_moon.Se";
mostCurrent._str1.Append("<h3>").Append("گزارش "+mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())).Append("</h3>");
 }else {
RDebugUtils.currentLine=22216758;
 //BA.debugLineNum = 22216758;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FRO";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+mostCurrent._lbl_date_from.getText()+"' AND '"+mostCurrent._date2_fixed+"' ;")));
RDebugUtils.currentLine=22216759;
 //BA.debugLineNum = 22216759;BA.debugLine="str1.Append(\"<h3>\").Append(\"گزارش از تاریخ \").";
mostCurrent._str1.Append("<h3>").Append("گزارش از تاریخ ").Append(mostCurrent._lbl_date_from.getText()).Append(" تا ").Append(mostCurrent._date2_fixed).Append("</h3>");
 };
RDebugUtils.currentLine=22216768;
 //BA.debugLineNum = 22216768;BA.debugLine="str1.Append(\"نام کاربر :\").Append(\"<span> \"&Main";
mostCurrent._str1.Append("نام کاربر :").Append("<span> "+mostCurrent._main._user_namefamili /*String*/ +"</span>").Append("<br>");
RDebugUtils.currentLine=22216770;
 //BA.debugLineNum = 22216770;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5;'><details>");
RDebugUtils.currentLine=22216772;
 //BA.debugLineNum = 22216772;BA.debugLine="str1.Append(\"<summary><b> اضافه کاری های این ماه";
mostCurrent._str1.Append("<summary><b> اضافه کاری های این ماه</b></summary>");
RDebugUtils.currentLine=22216773;
 //BA.debugLineNum = 22216773;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr styl";
mostCurrent._str1.Append("<table style='width:100%;'><tr style='text-align: center;'>");
RDebugUtils.currentLine=22216774;
 //BA.debugLineNum = 22216774;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ<";
mostCurrent._str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td> <td>توضیحات</td> <br></tr>");
RDebugUtils.currentLine=22216776;
 //BA.debugLineNum = 22216776;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=22216777;
 //BA.debugLineNum = 22216777;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
mostCurrent._str1.Append("<tr style='text-align: center;'>");
RDebugUtils.currentLine=22216778;
 //BA.debugLineNum = 22216778;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
RDebugUtils.currentLine=22216779;
 //BA.debugLineNum = 22216779;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))).Append("</td>");
RDebugUtils.currentLine=22216780;
 //BA.debugLineNum = 22216780;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
RDebugUtils.currentLine=22216782;
 //BA.debugLineNum = 22216782;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=22216784;
 //BA.debugLineNum = 22216784;BA.debugLine="Dim ls_ezafe As List";
_ls_ezafe = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=22216785;
 //BA.debugLineNum = 22216785;BA.debugLine="ls_ezafe.Initialize";
_ls_ezafe.Initialize();
RDebugUtils.currentLine=22216787;
 //BA.debugLineNum = 22216787;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz2_dontDay(dbC";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz2_dontday /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
RDebugUtils.currentLine=22216790;
 //BA.debugLineNum = 22216790;BA.debugLine="str1.Append(myfunc.en2fa(ls_ezafe.Get(0)))";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_ls_ezafe.Get((int) (0)))));
RDebugUtils.currentLine=22216791;
 //BA.debugLineNum = 22216791;BA.debugLine="str1.Append(\":\")";
mostCurrent._str1.Append(":");
RDebugUtils.currentLine=22216792;
 //BA.debugLineNum = 22216792;BA.debugLine="str1.Append(myfunc.en2fa(ls_ezafe.Get(1)))";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_ls_ezafe.Get((int) (1)))));
RDebugUtils.currentLine=22216794;
 //BA.debugLineNum = 22216794;BA.debugLine="str1.Append(\"</td>\")";
mostCurrent._str1.Append("</td>");
RDebugUtils.currentLine=22216796;
 //BA.debugLineNum = 22216796;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=22216797;
 //BA.debugLineNum = 22216797;BA.debugLine="str1.Append(dbCode.res.GetString(\"tozihat\"))";
mostCurrent._str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat"));
RDebugUtils.currentLine=22216798;
 //BA.debugLineNum = 22216798;BA.debugLine="str1.Append(\"</td>\")";
mostCurrent._str1.Append("</td>");
RDebugUtils.currentLine=22216800;
 //BA.debugLineNum = 22216800;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
 }
;
RDebugUtils.currentLine=22216803;
 //BA.debugLineNum = 22216803;BA.debugLine="str1.Append(\"</table>\")";
mostCurrent._str1.Append("</table>");
RDebugUtils.currentLine=22216804;
 //BA.debugLineNum = 22216804;BA.debugLine="str1.Append(\"مجموع ساعت اضافه کاری :<span style=";
mostCurrent._str1.Append("مجموع ساعت اضافه کاری :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h.getText())+" ساعت و"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m.getText())+"دقیقه </span><br></details></div><br> ");
RDebugUtils.currentLine=22216812;
 //BA.debugLineNum = 22216812;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=22216813;
 //BA.debugLineNum = 22216813;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+mostCurrent._sp_year.getSelectedItem()+"/"+mostCurrent._moon_num+"%';")));
 }else {
RDebugUtils.currentLine=22216815;
 //BA.debugLineNum = 22216815;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from BETWEEN '"+mostCurrent._lbl_date_from.getText()+"' AND '"+mostCurrent._lbl_date_to.getText()+"' ;")));
 };
RDebugUtils.currentLine=22216819;
 //BA.debugLineNum = 22216819;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5 ;'><details>");
RDebugUtils.currentLine=22216820;
 //BA.debugLineNum = 22216820;BA.debugLine="str1.Append(\"<summary><b> مرخصی های این ماه</b><";
mostCurrent._str1.Append("<summary><b> مرخصی های این ماه</b></summary>");
RDebugUtils.currentLine=22216821;
 //BA.debugLineNum = 22216821;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr styl";
mostCurrent._str1.Append("<table style='width:100%;'><tr style='text-align: center;'>");
RDebugUtils.currentLine=22216822;
 //BA.debugLineNum = 22216822;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ<";
mostCurrent._str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b>زمان/روز</b></td><td><b> زمان/ساعت</b></td><td>توضیحات</td><br></tr>");
RDebugUtils.currentLine=22216824;
 //BA.debugLineNum = 22216824;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=22216825;
 //BA.debugLineNum = 22216825;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
mostCurrent._str1.Append("<tr style='text-align: center;'>");
RDebugUtils.currentLine=22216826;
 //BA.debugLineNum = 22216826;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
RDebugUtils.currentLine=22216827;
 //BA.debugLineNum = 22216827;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
RDebugUtils.currentLine=22216828;
 //BA.debugLineNum = 22216828;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
RDebugUtils.currentLine=22216832;
 //BA.debugLineNum = 22216832;BA.debugLine="Dim ls_ezafe As List";
_ls_ezafe = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=22216833;
 //BA.debugLineNum = 22216833;BA.debugLine="ls_ezafe.Initialize";
_ls_ezafe.Initialize();
RDebugUtils.currentLine=22216835;
 //BA.debugLineNum = 22216835;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz(dbCode.res.G";
_ls_ezafe = mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
RDebugUtils.currentLine=22216836;
 //BA.debugLineNum = 22216836;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(ls_eza";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_ls_ezafe.Get((int) (2))))).Append("</td>");
RDebugUtils.currentLine=22216838;
 //BA.debugLineNum = 22216838;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=22216840;
 //BA.debugLineNum = 22216840;BA.debugLine="str1.Append(myfunc.en2fa(ls_ezafe.Get(0)))";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_ls_ezafe.Get((int) (0)))));
RDebugUtils.currentLine=22216841;
 //BA.debugLineNum = 22216841;BA.debugLine="str1.Append(\":\")";
mostCurrent._str1.Append(":");
RDebugUtils.currentLine=22216842;
 //BA.debugLineNum = 22216842;BA.debugLine="str1.Append(myfunc.en2fa(ls_ezafe.Get(1))).App";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_ls_ezafe.Get((int) (1))))).Append("</td>");
RDebugUtils.currentLine=22216845;
 //BA.debugLineNum = 22216845;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=22216846;
 //BA.debugLineNum = 22216846;BA.debugLine="str1.Append(dbCode.res.GetString(\"tozihat\"))";
mostCurrent._str1.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat"));
RDebugUtils.currentLine=22216847;
 //BA.debugLineNum = 22216847;BA.debugLine="str1.Append(\"</td>\")";
mostCurrent._str1.Append("</td>");
RDebugUtils.currentLine=22216849;
 //BA.debugLineNum = 22216849;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
 }
;
RDebugUtils.currentLine=22216854;
 //BA.debugLineNum = 22216854;BA.debugLine="str1.Append(\"</table>\")";
mostCurrent._str1.Append("</table>");
RDebugUtils.currentLine=22216856;
 //BA.debugLineNum = 22216856;BA.debugLine="Dim list_morakhasi As List";
_list_morakhasi = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=22216857;
 //BA.debugLineNum = 22216857;BA.debugLine="list_morakhasi.Initialize";
_list_morakhasi.Initialize();
RDebugUtils.currentLine=22216859;
 //BA.debugLineNum = 22216859;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=22216860;
 //BA.debugLineNum = 22216860;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(sp_year";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num);
 }else {
RDebugUtils.currentLine=22216862;
 //BA.debugLineNum = 22216862;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_byDate(lbl_";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_bydate /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._lbl_date_to.getText());
 };
RDebugUtils.currentLine=22216866;
 //BA.debugLineNum = 22216866;BA.debugLine="str1.Append(\"مجموع مرخصی ها :<span style='color:";
mostCurrent._str1.Append("مجموع مرخصی ها :<span style='color:#5E35B1;'><b> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (0))))+" روز و "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (1))))+" ساعت و "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (2))))+" دقیقه ");
RDebugUtils.currentLine=22216868;
 //BA.debugLineNum = 22216868;BA.debugLine="str1.Append(\"</b></span><br></details></div><br>";
mostCurrent._str1.Append("</b></span><br></details></div><br>");
RDebugUtils.currentLine=22216874;
 //BA.debugLineNum = 22216874;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5 ;' ><details open>");
RDebugUtils.currentLine=22216875;
 //BA.debugLineNum = 22216875;BA.debugLine="str1.Append(\"<summary><b>محاسبه حقوق</b></summar";
mostCurrent._str1.Append("<summary><b>محاسبه حقوق</b></summary>");
RDebugUtils.currentLine=22216877;
 //BA.debugLineNum = 22216877;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr>\")";
mostCurrent._str1.Append("<table style='width:100%;'><tr>");
RDebugUtils.currentLine=22216878;
 //BA.debugLineNum = 22216878;BA.debugLine="str1.Append(\"<td><div style='text-align: center;";
mostCurrent._str1.Append("<td><div style='text-align: center;color:#661400;'><b> مزایا</b></div></td>");
RDebugUtils.currentLine=22216879;
 //BA.debugLineNum = 22216879;BA.debugLine="str1.Append(\"<td><div style='text-align: center;";
mostCurrent._str1.Append("<td><div style='text-align: center;color:#661400;'><b>کسورات</b></div></td> </tr>");
RDebugUtils.currentLine=22216880;
 //BA.debugLineNum = 22216880;BA.debugLine="str1.Append(\"<tr style='vertical-align: text-top";
mostCurrent._str1.Append("<tr style='vertical-align: text-top;'><td>");
RDebugUtils.currentLine=22216881;
 //BA.debugLineNum = 22216881;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(0)&\" برای \"&myfunc";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (0)))+" برای "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_roze_kari))+" روز کاری : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_paye_end))+"</span><br>");
RDebugUtils.currentLine=22216882;
 //BA.debugLineNum = 22216882;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(2)&\" : <span style";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (2)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maskan_end))+"</span><br>");
RDebugUtils.currentLine=22216883;
 //BA.debugLineNum = 22216883;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(3)&\" : <span styl";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (3)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bon_end))+"</span><br>");
RDebugUtils.currentLine=22216884;
 //BA.debugLineNum = 22216884;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(13)&\" : <span sty";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (13)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hamsar_end))+"</span><br>");
RDebugUtils.currentLine=22216887;
 //BA.debugLineNum = 22216887;BA.debugLine="If(olad_end<>0)Then";
if ((_olad_end!=0)) { 
RDebugUtils.currentLine=22216888;
 //BA.debugLineNum = 22216888;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(4)&\"  :<span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (4)))+"  :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad_end))+"</span><br>");
 };
RDebugUtils.currentLine=22216890;
 //BA.debugLineNum = 22216890;BA.debugLine="If(sanavat_end<>0)Then";
if ((_sanavat_end!=0)) { 
RDebugUtils.currentLine=22216891;
 //BA.debugLineNum = 22216891;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(1)&\"  : <span sty";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (1)))+"  : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat_end))+"</span><br>");
 };
RDebugUtils.currentLine=22216893;
 //BA.debugLineNum = 22216893;BA.debugLine="If(fani_end<>0)Then";
if ((_fani_end!=0)) { 
RDebugUtils.currentLine=22216894;
 //BA.debugLineNum = 22216894;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(5)&\" : <span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (5)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_fani_end))+"</span><br>");
 };
RDebugUtils.currentLine=22216896;
 //BA.debugLineNum = 22216896;BA.debugLine="If(masoliat_end<>0)Then";
if ((_masoliat_end!=0)) { 
RDebugUtils.currentLine=22216897;
 //BA.debugLineNum = 22216897;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(6)&\" : <span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (6)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_masoliat_end))+"</span><br>");
 };
RDebugUtils.currentLine=22216899;
 //BA.debugLineNum = 22216899;BA.debugLine="If(sarparasti_end<>0)Then";
if ((_sarparasti_end!=0)) { 
RDebugUtils.currentLine=22216900;
 //BA.debugLineNum = 22216900;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(7)&\" : <span sty";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (7)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sarparasti_end))+"</span><br>");
 };
RDebugUtils.currentLine=22216902;
 //BA.debugLineNum = 22216902;BA.debugLine="If(shift_end<>0)Then";
if ((_shift_end!=0)) { 
RDebugUtils.currentLine=22216903;
 //BA.debugLineNum = 22216903;BA.debugLine="str1.Append(\" حق شیفت \"&myfunc.en2fa(shift)&\" د";
mostCurrent._str1.Append(" حق شیفت "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_shift))+" درصد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_shift_end))+"</span><br>");
 };
RDebugUtils.currentLine=22216907;
 //BA.debugLineNum = 22216907;BA.debugLine="If(dbCode.get_setting_byName(\"tog_padash\")=1)Th";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_padash")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22216908;
 //BA.debugLineNum = 22216908;BA.debugLine="If(padash_all<>0)Then";
if ((_padash_all!=0)) { 
RDebugUtils.currentLine=22216909;
 //BA.debugLineNum = 22216909;BA.debugLine="str1.Append(\"  پاداش : <span style='color:#5E";
mostCurrent._str1.Append("  پاداش : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_padash_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=22216913;
 //BA.debugLineNum = 22216913;BA.debugLine="If(dbCode.get_setting_byName(\"tog_food\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22216914;
 //BA.debugLineNum = 22216914;BA.debugLine="If(food_1_all<>0)Then";
if ((_food_1_all!=0)) { 
RDebugUtils.currentLine=22216915;
 //BA.debugLineNum = 22216915;BA.debugLine="str1.Append(\" هزینه غذا: <span style='color:#";
mostCurrent._str1.Append(" هزینه غذا: <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_food_1_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=22216919;
 //BA.debugLineNum = 22216919;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)The";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22216920;
 //BA.debugLineNum = 22216920;BA.debugLine="If(sayer_1_all<>0)Then";
if ((_sayer_1_all!=0)) { 
RDebugUtils.currentLine=22216921;
 //BA.debugLineNum = 22216921;BA.debugLine="str1.Append(\"  سایر: <span style='color:#5E35";
mostCurrent._str1.Append("  سایر: <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sayer_1_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=22216925;
 //BA.debugLineNum = 22216925;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22216926;
 //BA.debugLineNum = 22216926;BA.debugLine="If(ayab_1_all<>0)Then";
if ((_ayab_1_all!=0)) { 
RDebugUtils.currentLine=22216927;
 //BA.debugLineNum = 22216927;BA.debugLine="str1.Append(\" ایاب ذهاب: <span style='color:#";
mostCurrent._str1.Append(" ایاب ذهاب: <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ayab_1_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=22216932;
 //BA.debugLineNum = 22216932;BA.debugLine="If(mazaya_end<>0)Then";
if ((_mazaya_end!=0)) { 
RDebugUtils.currentLine=22216933;
 //BA.debugLineNum = 22216933;BA.debugLine="str1.Append(\"  \"&ls_onvanHa.Get(10)&\" : <span";
mostCurrent._str1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (10)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya_end))+"</span><br>");
 };
RDebugUtils.currentLine=22216942;
 //BA.debugLineNum = 22216942;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=22216943;
 //BA.debugLineNum = 22216943;BA.debugLine="str1.Append(\"اضافه کاری عادی\").Append(\"<br>\")";
mostCurrent._str1.Append("اضافه کاری عادی").Append("<br>");
RDebugUtils.currentLine=22216945;
 //BA.debugLineNum = 22216945;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B";
mostCurrent._str1.Append(" ساعات : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h.getText())+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m.getText())+"</span><br>");
RDebugUtils.currentLine=22216947;
 //BA.debugLineNum = 22216947;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5";
mostCurrent._str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_vahed_ezafekari))+"</span><br>");
RDebugUtils.currentLine=22216953;
 //BA.debugLineNum = 22216953;BA.debugLine="If(ezafekari_end_vij<>0)Then";
if ((_ezafekari_end_vij!=0)) { 
RDebugUtils.currentLine=22216954;
 //BA.debugLineNum = 22216954;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=22216956;
 //BA.debugLineNum = 22216956;BA.debugLine="str1.Append(\"اضافه کاری <span style='color:#ff4d";
mostCurrent._str1.Append("اضافه کاری <span style='color:#ff4d00;'>"+"فوق العاده"+"</span>").Append("<br>");
RDebugUtils.currentLine=22216958;
 //BA.debugLineNum = 22216958;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B1";
mostCurrent._str1.Append(" ساعات : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h_vij.getText())+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m_vij.getText())+"</span><br>");
RDebugUtils.currentLine=22216961;
 //BA.debugLineNum = 22216961;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5E";
mostCurrent._str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_vahed_ezafekari_vij))+"</span><br>");
 };
RDebugUtils.currentLine=22216965;
 //BA.debugLineNum = 22216965;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=22216966;
 //BA.debugLineNum = 22216966;BA.debugLine="str1.Append(\"مجموع اضافه کاری : <span style='col";
mostCurrent._str1.Append("مجموع اضافه کاری : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool((int) (_ezafekari_end+_ezafekari_end_vij)))+"</span><br></td>");
RDebugUtils.currentLine=22216969;
 //BA.debugLineNum = 22216969;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=22216972;
 //BA.debugLineNum = 22216972;BA.debugLine="str1.Append(\"بیمه تامین اجتماعی : <span style='";
mostCurrent._str1.Append("بیمه تامین اجتماعی : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_tamin_end))+"</span><br>");
RDebugUtils.currentLine=22216975;
 //BA.debugLineNum = 22216975;BA.debugLine="If(bime_takmil<>0)Then";
if ((_bime_takmil!=0)) { 
RDebugUtils.currentLine=22216976;
 //BA.debugLineNum = 22216976;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(9)&\" :<span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (9)))+" :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_takmil))+"</span><br>");
 };
RDebugUtils.currentLine=22216981;
 //BA.debugLineNum = 22216981;BA.debugLine="If(maliat_end<>0)Then";
if ((_maliat_end!=0)) { 
RDebugUtils.currentLine=22216982;
 //BA.debugLineNum = 22216982;BA.debugLine="str1.Append(\" مالیات : <span style='color:#5E3";
mostCurrent._str1.Append(" مالیات : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maliat_end))+"</span><br>");
 };
RDebugUtils.currentLine=22216986;
 //BA.debugLineNum = 22216986;BA.debugLine="If(dbCode.get_setting_byName(\"tog_mosaede\")=1)Th";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_mosaede")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22216987;
 //BA.debugLineNum = 22216987;BA.debugLine="If(mosaedeh_all<>0)Then";
if ((_mosaedeh_all!=0)) { 
RDebugUtils.currentLine=22216988;
 //BA.debugLineNum = 22216988;BA.debugLine="str1.Append(\" مساعده : <span style='color:#5E3";
mostCurrent._str1.Append(" مساعده : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mosaedeh_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=22216992;
 //BA.debugLineNum = 22216992;BA.debugLine="If(dbCode.get_setting_byName(\"tog_food\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22216993;
 //BA.debugLineNum = 22216993;BA.debugLine="If(food_2_all<>0)Then";
if ((_food_2_all!=0)) { 
RDebugUtils.currentLine=22216994;
 //BA.debugLineNum = 22216994;BA.debugLine="str1.Append(\" هزینه غذا : <span style='color:";
mostCurrent._str1.Append(" هزینه غذا : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_food_2_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=22216999;
 //BA.debugLineNum = 22216999;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)The";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22217000;
 //BA.debugLineNum = 22217000;BA.debugLine="If(sayer_2_all<>0)Then";
if ((_sayer_2_all!=0)) { 
RDebugUtils.currentLine=22217001;
 //BA.debugLineNum = 22217001;BA.debugLine="str1.Append(\" سایر : <span style='color:#5E35";
mostCurrent._str1.Append(" سایر : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sayer_2_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=22217005;
 //BA.debugLineNum = 22217005;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22217006;
 //BA.debugLineNum = 22217006;BA.debugLine="If(ayab_2_all<>0)Then";
if ((_ayab_2_all!=0)) { 
RDebugUtils.currentLine=22217007;
 //BA.debugLineNum = 22217007;BA.debugLine="str1.Append(\" ایاب ذهاب : <span style='color:";
mostCurrent._str1.Append(" ایاب ذهاب : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ayab_2_all))+"</span><br>");
 };
 };
RDebugUtils.currentLine=22217011;
 //BA.debugLineNum = 22217011;BA.debugLine="If(dbCode.get_setting_byName(\"tog_vam\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_vam")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22217012;
 //BA.debugLineNum = 22217012;BA.debugLine="If(gest_vam<>0)Then";
if ((_gest_vam!=0)) { 
RDebugUtils.currentLine=22217013;
 //BA.debugLineNum = 22217013;BA.debugLine="str1.Append(\" قسط وام  : <span style='color:#";
mostCurrent._str1.Append(" قسط وام  : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_gest_vam))+"</span><br>");
 };
 };
RDebugUtils.currentLine=22217021;
 //BA.debugLineNum = 22217021;BA.debugLine="If(ksorat<>0)Then";
if ((_ksorat!=0)) { 
RDebugUtils.currentLine=22217022;
 //BA.debugLineNum = 22217022;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(11)&\" : <span st";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (11)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat))+"</span></td>");
 };
RDebugUtils.currentLine=22217025;
 //BA.debugLineNum = 22217025;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
RDebugUtils.currentLine=22217027;
 //BA.debugLineNum = 22217027;BA.debugLine="str1.Append(\"<tr><td>\")";
mostCurrent._str1.Append("<tr><td>");
RDebugUtils.currentLine=22217028;
 //BA.debugLineNum = 22217028;BA.debugLine="str1.Append(\"جمع مزایا :  <span style='color:#5E";
mostCurrent._str1.Append("جمع مزایا :  <span style='color:#5E35B1;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_nakhales))+"</b></span>");
RDebugUtils.currentLine=22217029;
 //BA.debugLineNum = 22217029;BA.debugLine="str1.Append(\"</td><td>\")";
mostCurrent._str1.Append("</td><td>");
RDebugUtils.currentLine=22217031;
 //BA.debugLineNum = 22217031;BA.debugLine="str1.Append(\"جمع کسورات :  <span style='color:#5";
mostCurrent._str1.Append("جمع کسورات :  <span style='color:#5E35B1;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_jame_kosorat))+"</b></span>");
RDebugUtils.currentLine=22217032;
 //BA.debugLineNum = 22217032;BA.debugLine="str1.Append(\"</td></tr></table><br>\")";
mostCurrent._str1.Append("</td></tr></table><br>");
RDebugUtils.currentLine=22217034;
 //BA.debugLineNum = 22217034;BA.debugLine="str1.Append(\" دریافتی خالص :  <span style='color";
mostCurrent._str1.Append(" دریافتی خالص :  <span style='color:#388E3C;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_khales))+" </b></span></b>");
RDebugUtils.currentLine=22217035;
 //BA.debugLineNum = 22217035;BA.debugLine="str1.Append(\"<span style='font-size: 11px;'> توم";
mostCurrent._str1.Append("<span style='font-size: 11px;'> تومان </span>");
RDebugUtils.currentLine=22217037;
 //BA.debugLineNum = 22217037;BA.debugLine="str1.Append(\"<br></details></div>\")";
mostCurrent._str1.Append("<br></details></div>");
RDebugUtils.currentLine=22217039;
 //BA.debugLineNum = 22217039;BA.debugLine="str1.Append(\"<footer style=' text-align: center;";
mostCurrent._str1.Append("<footer style=' text-align: center; '><h6> اپلیکیشن اضافه کاری من </h6></footer>");
RDebugUtils.currentLine=22217041;
 //BA.debugLineNum = 22217041;BA.debugLine="str1.Append(\"</body></html>\")";
mostCurrent._str1.Append("</body></html>");
RDebugUtils.currentLine=22217043;
 //BA.debugLineNum = 22217043;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=22217044;
 //BA.debugLineNum = 22217044;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=22217049;
 //BA.debugLineNum = 22217049;BA.debugLine="WebView2.LoadHtml(str1.ToString)";
mostCurrent._webview2.LoadHtml(mostCurrent._str1.ToString());
 };
 };
RDebugUtils.currentLine=22217054;
 //BA.debugLineNum = 22217054;BA.debugLine="End Sub";
return "";
}
public static String  _mohasebe() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mohasebe", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "mohasebe", null));}
int _hogog_nakhales_maliaty = 0;
int _nak_mal = 0;
RDebugUtils.currentLine=22282240;
 //BA.debugLineNum = 22282240;BA.debugLine="Sub mohasebe";
RDebugUtils.currentLine=22282244;
 //BA.debugLineNum = 22282244;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=22282247;
 //BA.debugLineNum = 22282247;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=22282254;
 //BA.debugLineNum = 22282254;BA.debugLine="If (roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=22282255;
 //BA.debugLineNum = 22282255;BA.debugLine="maskan_end=(maskan/30)*roze_kari";
_maskan_end = (int) ((_maskan/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=22282257;
 //BA.debugLineNum = 22282257;BA.debugLine="maskan_end=maskan";
_maskan_end = _maskan;
 };
RDebugUtils.currentLine=22282262;
 //BA.debugLineNum = 22282262;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=22282263;
 //BA.debugLineNum = 22282263;BA.debugLine="bon_end=(bon/30)*roze_kari";
_bon_end = (int) ((_bon/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=22282265;
 //BA.debugLineNum = 22282265;BA.debugLine="bon_end=bon";
_bon_end = _bon;
 };
RDebugUtils.currentLine=22282270;
 //BA.debugLineNum = 22282270;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=22282271;
 //BA.debugLineNum = 22282271;BA.debugLine="hamsar_end=(hamsar/30)*roze_kari";
_hamsar_end = (int) ((_hamsar/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=22282273;
 //BA.debugLineNum = 22282273;BA.debugLine="hamsar_end=hamsar";
_hamsar_end = _hamsar;
 };
RDebugUtils.currentLine=22282279;
 //BA.debugLineNum = 22282279;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=22282280;
 //BA.debugLineNum = 22282280;BA.debugLine="olad_end=(olad/30)*roze_kari";
_olad_end = (int) ((_olad/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=22282282;
 //BA.debugLineNum = 22282282;BA.debugLine="olad_end=olad";
_olad_end = _olad;
 };
RDebugUtils.currentLine=22282287;
 //BA.debugLineNum = 22282287;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=22282288;
 //BA.debugLineNum = 22282288;BA.debugLine="fani_end=(fani/30)*roze_kari";
_fani_end = (int) ((_fani/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=22282290;
 //BA.debugLineNum = 22282290;BA.debugLine="fani_end=fani";
_fani_end = _fani;
 };
RDebugUtils.currentLine=22282294;
 //BA.debugLineNum = 22282294;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=22282295;
 //BA.debugLineNum = 22282295;BA.debugLine="masoliat_end=(masoliat/30)*roze_kari";
_masoliat_end = (int) ((_masoliat/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=22282297;
 //BA.debugLineNum = 22282297;BA.debugLine="masoliat_end=masoliat";
_masoliat_end = _masoliat;
 };
RDebugUtils.currentLine=22282301;
 //BA.debugLineNum = 22282301;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=22282302;
 //BA.debugLineNum = 22282302;BA.debugLine="sarparasti_end=(sarparasti/30)*roze_kari";
_sarparasti_end = (int) ((_sarparasti/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=22282304;
 //BA.debugLineNum = 22282304;BA.debugLine="sarparasti_end=sarparasti";
_sarparasti_end = _sarparasti;
 };
RDebugUtils.currentLine=22282308;
 //BA.debugLineNum = 22282308;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=22282309;
 //BA.debugLineNum = 22282309;BA.debugLine="mazaya_end=(mazaya/30)*roze_kari";
_mazaya_end = (int) ((_mazaya/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=22282311;
 //BA.debugLineNum = 22282311;BA.debugLine="mazaya_end=mazaya";
_mazaya_end = _mazaya;
 };
RDebugUtils.currentLine=22282315;
 //BA.debugLineNum = 22282315;BA.debugLine="shift_end=((paye_end+sanavat_end)*shift)/100";
_shift_end = (int) (((_paye_end+_sanavat_end)*_shift)/(double)100);
RDebugUtils.currentLine=22282318;
 //BA.debugLineNum = 22282318;BA.debugLine="vahed_ezafekari=et_vahed_ezafekari.Tag";
_vahed_ezafekari = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari.getTag()));
RDebugUtils.currentLine=22282319;
 //BA.debugLineNum = 22282319;BA.debugLine="ezafekari_end=vahed_ezafekari*(et_time_h.Text+(et";
_ezafekari_end = (int) (_vahed_ezafekari*((double)(Double.parseDouble(mostCurrent._et_time_h.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m.getText()))/(double)60)));
RDebugUtils.currentLine=22282323;
 //BA.debugLineNum = 22282323;BA.debugLine="vahed_ezafekari_vij=et_vahed_ezafekari_vij.Tag";
_vahed_ezafekari_vij = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari_vij.getTag()));
RDebugUtils.currentLine=22282324;
 //BA.debugLineNum = 22282324;BA.debugLine="ezafekari_end_vij=vahed_ezafekari_vij*(et_time_h_";
_ezafekari_end_vij = (int) (_vahed_ezafekari_vij*((double)(Double.parseDouble(mostCurrent._et_time_h_vij.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m_vij.getText()))/(double)60)));
RDebugUtils.currentLine=22282329;
 //BA.debugLineNum = 22282329;BA.debugLine="If(dbCode.get_setting_byName(\"tog_mosaede\")=1)The";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_mosaede")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22282330;
 //BA.debugLineNum = 22282330;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=22282331;
 //BA.debugLineNum = 22282331;BA.debugLine="mosaedeh_all=dbCode.all_mosaedeh_mah(sp_year.Se";
_mosaedeh_all = mostCurrent._dbcode._all_mosaedeh_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 }else {
RDebugUtils.currentLine=22282333;
 //BA.debugLineNum = 22282333;BA.debugLine="mosaedeh_all=dbCode.all_mosaedeh_byDate(lbl_dat";
_mosaedeh_all = mostCurrent._dbcode._all_mosaedeh_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed);
 };
 };
RDebugUtils.currentLine=22282338;
 //BA.debugLineNum = 22282338;BA.debugLine="If(dbCode.get_setting_byName(\"tog_food\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22282339;
 //BA.debugLineNum = 22282339;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=22282340;
 //BA.debugLineNum = 22282340;BA.debugLine="food_1_all=dbCode.all_food_mah(sp_year.Selected";
_food_1_all = mostCurrent._dbcode._all_food_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
RDebugUtils.currentLine=22282341;
 //BA.debugLineNum = 22282341;BA.debugLine="food_2_all=dbCode.all_food_mah(sp_year.Selected";
_food_2_all = mostCurrent._dbcode._all_food_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (2));
 }else {
RDebugUtils.currentLine=22282343;
 //BA.debugLineNum = 22282343;BA.debugLine="food_1_all=dbCode.all_food_byDate(lbl_date_from";
_food_1_all = mostCurrent._dbcode._all_food_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (1));
RDebugUtils.currentLine=22282344;
 //BA.debugLineNum = 22282344;BA.debugLine="food_2_all=dbCode.all_food_byDate(lbl_date_from";
_food_2_all = mostCurrent._dbcode._all_food_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (2));
 };
 };
RDebugUtils.currentLine=22282350;
 //BA.debugLineNum = 22282350;BA.debugLine="If(dbCode.get_setting_byName(\"tog_padash\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_padash")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22282351;
 //BA.debugLineNum = 22282351;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=22282352;
 //BA.debugLineNum = 22282352;BA.debugLine="padash_all=dbCode.all_padash_mah(sp_year.Select";
_padash_all = mostCurrent._dbcode._all_padash_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 }else {
RDebugUtils.currentLine=22282354;
 //BA.debugLineNum = 22282354;BA.debugLine="padash_all=dbCode.all_padash_byDate(lbl_date_fr";
_padash_all = mostCurrent._dbcode._all_padash_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed);
 };
 };
RDebugUtils.currentLine=22282360;
 //BA.debugLineNum = 22282360;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22282361;
 //BA.debugLineNum = 22282361;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=22282362;
 //BA.debugLineNum = 22282362;BA.debugLine="sayer_1_all=dbCode.all_sayer_mah(sp_year.Select";
_sayer_1_all = mostCurrent._dbcode._all_sayer_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
RDebugUtils.currentLine=22282363;
 //BA.debugLineNum = 22282363;BA.debugLine="sayer_2_all=dbCode.all_sayer_mah(sp_year.Select";
_sayer_2_all = mostCurrent._dbcode._all_sayer_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (2));
 }else {
RDebugUtils.currentLine=22282365;
 //BA.debugLineNum = 22282365;BA.debugLine="sayer_1_all=dbCode.all_sayer_byDate(lbl_date_fr";
_sayer_1_all = mostCurrent._dbcode._all_sayer_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (1));
RDebugUtils.currentLine=22282366;
 //BA.debugLineNum = 22282366;BA.debugLine="sayer_2_all=dbCode.all_sayer_byDate(lbl_date_fr";
_sayer_2_all = mostCurrent._dbcode._all_sayer_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (2));
 };
 };
RDebugUtils.currentLine=22282372;
 //BA.debugLineNum = 22282372;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22282373;
 //BA.debugLineNum = 22282373;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=22282374;
 //BA.debugLineNum = 22282374;BA.debugLine="ayab_1_all=dbCode.all_ayabZahab_mah(sp_year.Sel";
_ayab_1_all = mostCurrent._dbcode._all_ayabzahab_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (1));
RDebugUtils.currentLine=22282375;
 //BA.debugLineNum = 22282375;BA.debugLine="ayab_2_all=dbCode.all_ayabZahab_mah(sp_year.Sel";
_ayab_2_all = mostCurrent._dbcode._all_ayabzahab_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)),(int) (2));
 }else {
RDebugUtils.currentLine=22282377;
 //BA.debugLineNum = 22282377;BA.debugLine="ayab_1_all=dbCode.all_ayabZahab_byDate(lbl_date";
_ayab_1_all = mostCurrent._dbcode._all_ayabzahab_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (1));
RDebugUtils.currentLine=22282378;
 //BA.debugLineNum = 22282378;BA.debugLine="ayab_2_all=dbCode.all_ayabZahab_byDate(lbl_date";
_ayab_2_all = mostCurrent._dbcode._all_ayabzahab_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed,(int) (2));
 };
 };
RDebugUtils.currentLine=22282383;
 //BA.debugLineNum = 22282383;BA.debugLine="If(dbCode.get_setting_byName(\"tog_vam\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_vam")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22282384;
 //BA.debugLineNum = 22282384;BA.debugLine="If(type_mohasebe=1)Then";
if ((_type_mohasebe==1)) { 
RDebugUtils.currentLine=22282385;
 //BA.debugLineNum = 22282385;BA.debugLine="gest_vam=dbCode.all_gestVam_mah(sp_year.Selecte";
_gest_vam = mostCurrent._dbcode._all_gestvam_mah /*int*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 }else {
RDebugUtils.currentLine=22282387;
 //BA.debugLineNum = 22282387;BA.debugLine="gest_vam=dbCode.all_gestVam_byDate(date2_fixed.";
_gest_vam = mostCurrent._dbcode._all_gestvam_bydate /*int*/ (mostCurrent.activityBA,mostCurrent._date2_fixed.substring((int) (0),(int) (7)));
 };
 };
RDebugUtils.currentLine=22282395;
 //BA.debugLineNum = 22282395;BA.debugLine="hogog_nakhales=paye_end+ezafekari_end+ezafekari_e";
_hogog_nakhales = (int) (_paye_end+_ezafekari_end+_ezafekari_end_vij+_maskan_end+_bon_end+_hamsar_end+_olad_end+_fani_end+_masoliat_end+_sarparasti_end+_sanavat_end+_mazaya_end+_shift_end+_padash_all+_food_1_all+_sayer_1_all+_ayab_1_all);
RDebugUtils.currentLine=22282398;
 //BA.debugLineNum = 22282398;BA.debugLine="Dim hogog_nakhales_maliaty As Int";
_hogog_nakhales_maliaty = 0;
RDebugUtils.currentLine=22282400;
 //BA.debugLineNum = 22282400;BA.debugLine="hogog_nakhales_maliaty=paye_end+ezafekari_end+eza";
_hogog_nakhales_maliaty = (int) (_paye_end+_ezafekari_end+_ezafekari_end_vij+_maskan_end+_bon_end+_hamsar_end+_olad_end+_fani_end+_masoliat_end+_sarparasti_end+_sanavat_end+_mazaya_end+_shift_end);
RDebugUtils.currentLine=22282404;
 //BA.debugLineNum = 22282404;BA.debugLine="If(dbCode.get_setting_byName(\"tog_bime\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_bime")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22282405;
 //BA.debugLineNum = 22282405;BA.debugLine="bime_tamin_end=(hogog_nakhales_maliaty-olad_end)";
_bime_tamin_end = (int) ((_hogog_nakhales_maliaty-_olad_end)*0.07);
 }else {
RDebugUtils.currentLine=22282409;
 //BA.debugLineNum = 22282409;BA.debugLine="If(et_bime.Tag=\"\")Then";
if (((mostCurrent._et_bime.getTag()).equals((Object)("")))) { 
RDebugUtils.currentLine=22282410;
 //BA.debugLineNum = 22282410;BA.debugLine="bime_tamin_end=0";
_bime_tamin_end = (int) (0);
RDebugUtils.currentLine=22282411;
 //BA.debugLineNum = 22282411;BA.debugLine="et_bime.Text=0";
mostCurrent._et_bime.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=22282412;
 //BA.debugLineNum = 22282412;BA.debugLine="et_bime.Tag=0";
mostCurrent._et_bime.setTag((Object)(0));
 }else {
RDebugUtils.currentLine=22282414;
 //BA.debugLineNum = 22282414;BA.debugLine="bime_tamin_end=et_bime.Tag";
_bime_tamin_end = (int)(BA.ObjectToNumber(mostCurrent._et_bime.getTag()));
 };
 };
RDebugUtils.currentLine=22282422;
 //BA.debugLineNum = 22282422;BA.debugLine="Dim nak_mal As Int";
_nak_mal = 0;
RDebugUtils.currentLine=22282423;
 //BA.debugLineNum = 22282423;BA.debugLine="nak_mal=hogog_nakhales_maliaty-((bime_tamin_end*2";
_nak_mal = (int) (_hogog_nakhales_maliaty-((_bime_tamin_end*2)/(double)7));
RDebugUtils.currentLine=22282426;
 //BA.debugLineNum = 22282426;BA.debugLine="If(dbCode.get_setting_byName(\"tog_maliat\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_maliat")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=22282428;
 //BA.debugLineNum = 22282428;BA.debugLine="maliat_end=mohasebe_maliat(nak_mal,sp_year.Selec";
_maliat_end = _mohasebe_maliat(_nak_mal,(int)(Double.parseDouble(mostCurrent._sp_year.getSelectedItem())));
 }else {
RDebugUtils.currentLine=22282433;
 //BA.debugLineNum = 22282433;BA.debugLine="If(et_maliat.Tag=\"\")Then";
if (((mostCurrent._et_maliat.getTag()).equals((Object)("")))) { 
RDebugUtils.currentLine=22282434;
 //BA.debugLineNum = 22282434;BA.debugLine="maliat_end=0";
_maliat_end = (int) (0);
RDebugUtils.currentLine=22282435;
 //BA.debugLineNum = 22282435;BA.debugLine="et_maliat.Text=0";
mostCurrent._et_maliat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=22282436;
 //BA.debugLineNum = 22282436;BA.debugLine="et_maliat.Tag=0";
mostCurrent._et_maliat.setTag((Object)(0));
 }else {
RDebugUtils.currentLine=22282438;
 //BA.debugLineNum = 22282438;BA.debugLine="maliat_end=et_maliat.Tag";
_maliat_end = (int)(BA.ObjectToNumber(mostCurrent._et_maliat.getTag()));
 };
 };
RDebugUtils.currentLine=22282445;
 //BA.debugLineNum = 22282445;BA.debugLine="jame_kosorat=bime_tamin_end+maliat_end+bime_takmi";
_jame_kosorat = (int) (_bime_tamin_end+_maliat_end+_bime_takmil+_ksorat+_mosaedeh_all+_food_2_all+_sayer_2_all+_ayab_2_all+_gest_vam);
RDebugUtils.currentLine=22282447;
 //BA.debugLineNum = 22282447;BA.debugLine="hogog_khales=hogog_nakhales-jame_kosorat";
_hogog_khales = (int) (_hogog_nakhales-_jame_kosorat);
RDebugUtils.currentLine=22282449;
 //BA.debugLineNum = 22282449;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_gozaresh_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_gozaresh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_gozaresh_click", null));}
RDebugUtils.currentLine=22544384;
 //BA.debugLineNum = 22544384;BA.debugLine="Private Sub lbl_save_gozaresh_Click";
RDebugUtils.currentLine=22544385;
 //BA.debugLineNum = 22544385;BA.debugLine="et_name_gozaresh.Text=sp_moon.SelectedItem&\" \"&sp";
mostCurrent._et_name_gozaresh.setText(BA.ObjectToCharSequence(mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._sp_year.getSelectedItem()));
RDebugUtils.currentLine=22544386;
 //BA.debugLineNum = 22544386;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=22544387;
 //BA.debugLineNum = 22544387;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_gozaresh_end_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_gozaresh_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_gozaresh_end_click", null));}
RDebugUtils.currentLine=22806528;
 //BA.debugLineNum = 22806528;BA.debugLine="Private Sub lbl_save_gozaresh_end_Click";
RDebugUtils.currentLine=22806529;
 //BA.debugLineNum = 22806529;BA.debugLine="save_gozaresh";
_save_gozaresh();
RDebugUtils.currentLine=22806530;
 //BA.debugLineNum = 22806530;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22806531;
 //BA.debugLineNum = 22806531;BA.debugLine="End Sub";
return "";
}
public static String  _save_gozaresh() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "save_gozaresh", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "save_gozaresh", null));}
boolean _chek = false;
anywheresoftware.b4a.objects.collections.List _alist = null;
RDebugUtils.currentLine=22609920;
 //BA.debugLineNum = 22609920;BA.debugLine="Sub save_gozaresh";
RDebugUtils.currentLine=22609923;
 //BA.debugLineNum = 22609923;BA.debugLine="Dim chek As Boolean";
_chek = false;
RDebugUtils.currentLine=22609924;
 //BA.debugLineNum = 22609924;BA.debugLine="chek=myfunc.check_karid";
_chek = mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=22609925;
 //BA.debugLineNum = 22609925;BA.debugLine="Dim alist As List";
_alist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=22609926;
 //BA.debugLineNum = 22609926;BA.debugLine="alist.Initialize";
_alist.Initialize();
RDebugUtils.currentLine=22609928;
 //BA.debugLineNum = 22609928;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(Main.persianDa";
_alist = mostCurrent._myfunc._num_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())),BA.NumberToString(01));
RDebugUtils.currentLine=22609931;
 //BA.debugLineNum = 22609931;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=22609932;
 //BA.debugLineNum = 22609932;BA.debugLine="If(alist.Get(2)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (2))))<5)) { 
RDebugUtils.currentLine=22609933;
 //BA.debugLineNum = 22609933;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDa";
mostCurrent._dbcode._add_gozaresh /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),mostCurrent._et_name_gozaresh.getText(),mostCurrent._et_tozih_gozaresh.getText(),mostCurrent._str1.ToString(),BA.NumberToString(_hogog_nakhales),BA.NumberToString(_hogog_khales));
RDebugUtils.currentLine=22609934;
 //BA.debugLineNum = 22609934;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("گزارش ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=22609936;
 //BA.debugLineNum = 22609936;BA.debugLine="Main.buy_index=1";
mostCurrent._main._buy_index /*int*/  = (int) (1);
RDebugUtils.currentLine=22609938;
 //BA.debugLineNum = 22609938;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=22609939;
 //BA.debugLineNum = 22609939;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
 };
 }else {
RDebugUtils.currentLine=22609943;
 //BA.debugLineNum = 22609943;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDat";
mostCurrent._dbcode._add_gozaresh /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),mostCurrent._et_name_gozaresh.getText(),mostCurrent._et_tozih_gozaresh.getText(),mostCurrent._str1.ToString(),BA.NumberToString(_hogog_nakhales),BA.NumberToString(_hogog_khales));
RDebugUtils.currentLine=22609944;
 //BA.debugLineNum = 22609944;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("گزارش ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=22609949;
 //BA.debugLineNum = 22609949;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_picker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_picker_click", null));}
RDebugUtils.currentLine=23658496;
 //BA.debugLineNum = 23658496;BA.debugLine="Private Sub lbl_save_picker_Click";
RDebugUtils.currentLine=23658498;
 //BA.debugLineNum = 23658498;BA.debugLine="If(index_datePik=1) Then";
if ((_index_datepik==1)) { 
RDebugUtils.currentLine=23658499;
 //BA.debugLineNum = 23658499;BA.debugLine="lbl_date_from.Text=pik_year1.Text&\"/\"&myfunc.con";
mostCurrent._lbl_date_from.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 }else 
{RDebugUtils.currentLine=23658501;
 //BA.debugLineNum = 23658501;BA.debugLine="Else If(index_datePik=2) Then";
if ((_index_datepik==2)) { 
RDebugUtils.currentLine=23658502;
 //BA.debugLineNum = 23658502;BA.debugLine="lbl_date_to.Text=pik_year1.Text&\"/\"&myfunc.conve";
mostCurrent._lbl_date_to.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=23658503;
 //BA.debugLineNum = 23658503;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
 }}
;
RDebugUtils.currentLine=23658506;
 //BA.debugLineNum = 23658506;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=23658508;
 //BA.debugLineNum = 23658508;BA.debugLine="et_rozekari.Text=myfunc.time_mohasebe(lbl_date_fr";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._time_mohasebe /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date_from.getText(),mostCurrent._date2_fixed)));
RDebugUtils.currentLine=23658509;
 //BA.debugLineNum = 23658509;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=23658511;
 //BA.debugLineNum = 23658511;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_share_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_share_click", null));}
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
RDebugUtils.currentLine=23199744;
 //BA.debugLineNum = 23199744;BA.debugLine="Private Sub lbl_share_Click";
RDebugUtils.currentLine=23199745;
 //BA.debugLineNum = 23199745;BA.debugLine="Dim FileName As String =Main.current_gozaresh_id&";
_filename = BA.NumberToString(mostCurrent._main._current_gozaresh_id /*int*/ )+".html";
RDebugUtils.currentLine=23199748;
 //BA.debugLineNum = 23199748;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
anywheresoftware.b4a.keywords.Common.File.WriteString(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename,mostCurrent._str1.ToString());
RDebugUtils.currentLine=23199750;
 //BA.debugLineNum = 23199750;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=23199751;
 //BA.debugLineNum = 23199751;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
RDebugUtils.currentLine=23199752;
 //BA.debugLineNum = 23199752;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
RDebugUtils.currentLine=23199753;
 //BA.debugLineNum = 23199753;BA.debugLine="email.Body = \" گزارش حقوق \"&str1.ToString&CRLF&\"ا";
_email.Body = " گزارش حقوق "+mostCurrent._str1.ToString()+anywheresoftware.b4a.keywords.Common.CRLF+"اپلیکیشن اضافه کاری من"+anywheresoftware.b4a.keywords.Common.CRLF+"دانلود از بازار";
RDebugUtils.currentLine=23199754;
 //BA.debugLineNum = 23199754;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (null,_filename));
RDebugUtils.currentLine=23199756;
 //BA.debugLineNum = 23199756;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
RDebugUtils.currentLine=23199757;
 //BA.debugLineNum = 23199757;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
RDebugUtils.currentLine=23199758;
 //BA.debugLineNum = 23199758;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
RDebugUtils.currentLine=23199759;
 //BA.debugLineNum = 23199759;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=22347776;
 //BA.debugLineNum = 22347776;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
RDebugUtils.currentLine=22347777;
 //BA.debugLineNum = 22347777;BA.debugLine="Dim all_maliat As Int=0";
_all_maliat = (int) (0);
RDebugUtils.currentLine=22347778;
 //BA.debugLineNum = 22347778;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
RDebugUtils.currentLine=22347779;
 //BA.debugLineNum = 22347779;BA.debugLine="Dim state2 As Int=0";
_state2 = (int) (0);
RDebugUtils.currentLine=22347780;
 //BA.debugLineNum = 22347780;BA.debugLine="Dim state3 As Int=0";
_state3 = (int) (0);
RDebugUtils.currentLine=22347781;
 //BA.debugLineNum = 22347781;BA.debugLine="Dim state4 As Int=0";
_state4 = (int) (0);
RDebugUtils.currentLine=22347782;
 //BA.debugLineNum = 22347782;BA.debugLine="Dim state5 As Int=0";
_state5 = (int) (0);
RDebugUtils.currentLine=22347783;
 //BA.debugLineNum = 22347783;BA.debugLine="Dim state6 As Int=0";
_state6 = (int) (0);
RDebugUtils.currentLine=22347785;
 //BA.debugLineNum = 22347785;BA.debugLine="If (year=1399)Then";
if ((_year==1399)) { 
RDebugUtils.currentLine=22347786;
 //BA.debugLineNum = 22347786;BA.debugLine="If(hogog>3000001 And hogog<7500001)Then	  ''----";
if ((_hogog>3000001 && _hogog<7500001)) { 
RDebugUtils.currentLine=22347787;
 //BA.debugLineNum = 22347787;BA.debugLine="state1=(hogog-3000000)*0.1";
_state1 = (int) ((_hogog-3000000)*0.1);
 };
RDebugUtils.currentLine=22347789;
 //BA.debugLineNum = 22347789;BA.debugLine="If(hogog>7500001 And hogog<10500001)Then	  ''---";
if ((_hogog>7500001 && _hogog<10500001)) { 
RDebugUtils.currentLine=22347790;
 //BA.debugLineNum = 22347790;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=22347791;
 //BA.debugLineNum = 22347791;BA.debugLine="state2=(hogog-7500000)*0.15";
_state2 = (int) ((_hogog-7500000)*0.15);
 };
RDebugUtils.currentLine=22347793;
 //BA.debugLineNum = 22347793;BA.debugLine="If(hogog>10500001 And hogog<15000001)Then	  ''--";
if ((_hogog>10500001 && _hogog<15000001)) { 
RDebugUtils.currentLine=22347794;
 //BA.debugLineNum = 22347794;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=22347795;
 //BA.debugLineNum = 22347795;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=22347796;
 //BA.debugLineNum = 22347796;BA.debugLine="state3=(hogog-10500000)*0.2";
_state3 = (int) ((_hogog-10500000)*0.2);
 };
RDebugUtils.currentLine=22347798;
 //BA.debugLineNum = 22347798;BA.debugLine="If(hogog>15000001)Then	  ''-----stat4";
if ((_hogog>15000001)) { 
RDebugUtils.currentLine=22347799;
 //BA.debugLineNum = 22347799;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=22347800;
 //BA.debugLineNum = 22347800;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=22347801;
 //BA.debugLineNum = 22347801;BA.debugLine="state3=(4500000)*0.2";
_state3 = (int) ((4500000)*0.2);
RDebugUtils.currentLine=22347802;
 //BA.debugLineNum = 22347802;BA.debugLine="state4=(hogog-15000001)*0.25";
_state4 = (int) ((_hogog-15000001)*0.25);
 };
 };
RDebugUtils.currentLine=22347806;
 //BA.debugLineNum = 22347806;BA.debugLine="If (year=1400)Then";
if ((_year==1400)) { 
RDebugUtils.currentLine=22347807;
 //BA.debugLineNum = 22347807;BA.debugLine="If(hogog>4000001 And hogog<8000001)Then	  ''----";
if ((_hogog>4000001 && _hogog<8000001)) { 
RDebugUtils.currentLine=22347808;
 //BA.debugLineNum = 22347808;BA.debugLine="state1=(hogog-4000000)*0.1";
_state1 = (int) ((_hogog-4000000)*0.1);
 };
RDebugUtils.currentLine=22347810;
 //BA.debugLineNum = 22347810;BA.debugLine="If(hogog>8000001 And hogog<12000001)Then	  ''---";
if ((_hogog>8000001 && _hogog<12000001)) { 
RDebugUtils.currentLine=22347811;
 //BA.debugLineNum = 22347811;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=22347812;
 //BA.debugLineNum = 22347812;BA.debugLine="state2=(hogog-8000000)*0.15";
_state2 = (int) ((_hogog-8000000)*0.15);
 };
RDebugUtils.currentLine=22347814;
 //BA.debugLineNum = 22347814;BA.debugLine="If(hogog>12000001 And hogog<18000001)Then	  ''--";
if ((_hogog>12000001 && _hogog<18000001)) { 
RDebugUtils.currentLine=22347815;
 //BA.debugLineNum = 22347815;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=22347816;
 //BA.debugLineNum = 22347816;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=22347817;
 //BA.debugLineNum = 22347817;BA.debugLine="state3=(hogog-12000000)*0.2";
_state3 = (int) ((_hogog-12000000)*0.2);
 };
RDebugUtils.currentLine=22347819;
 //BA.debugLineNum = 22347819;BA.debugLine="If(hogog>18000001 And hogog<24000001)Then	  ''--";
if ((_hogog>18000001 && _hogog<24000001)) { 
RDebugUtils.currentLine=22347820;
 //BA.debugLineNum = 22347820;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=22347821;
 //BA.debugLineNum = 22347821;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=22347822;
 //BA.debugLineNum = 22347822;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=22347823;
 //BA.debugLineNum = 22347823;BA.debugLine="state4=(hogog-18000000)*0.25";
_state4 = (int) ((_hogog-18000000)*0.25);
 };
RDebugUtils.currentLine=22347825;
 //BA.debugLineNum = 22347825;BA.debugLine="If(hogog>24000001 And hogog<32000001)Then	  ''--";
if ((_hogog>24000001 && _hogog<32000001)) { 
RDebugUtils.currentLine=22347826;
 //BA.debugLineNum = 22347826;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=22347827;
 //BA.debugLineNum = 22347827;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=22347828;
 //BA.debugLineNum = 22347828;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=22347829;
 //BA.debugLineNum = 22347829;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=22347830;
 //BA.debugLineNum = 22347830;BA.debugLine="state5=(hogog-24000000)*0.3";
_state5 = (int) ((_hogog-24000000)*0.3);
 };
RDebugUtils.currentLine=22347832;
 //BA.debugLineNum = 22347832;BA.debugLine="If(hogog>32000001)Then	  ''-----stat4";
if ((_hogog>32000001)) { 
RDebugUtils.currentLine=22347833;
 //BA.debugLineNum = 22347833;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=22347834;
 //BA.debugLineNum = 22347834;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=22347835;
 //BA.debugLineNum = 22347835;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=22347836;
 //BA.debugLineNum = 22347836;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=22347837;
 //BA.debugLineNum = 22347837;BA.debugLine="state5=(6000000)*0.3";
_state5 = (int) ((6000000)*0.3);
RDebugUtils.currentLine=22347838;
 //BA.debugLineNum = 22347838;BA.debugLine="state6=(hogog-32000000)*0.35";
_state6 = (int) ((_hogog-32000000)*0.35);
 };
 };
RDebugUtils.currentLine=22347842;
 //BA.debugLineNum = 22347842;BA.debugLine="If (year=1401)Then";
if ((_year==1401)) { 
RDebugUtils.currentLine=22347843;
 //BA.debugLineNum = 22347843;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
if ((_hogog>5600001 && _hogog<12500001)) { 
RDebugUtils.currentLine=22347844;
 //BA.debugLineNum = 22347844;BA.debugLine="state1=(hogog-5600000)*0.1";
_state1 = (int) ((_hogog-5600000)*0.1);
 };
RDebugUtils.currentLine=22347846;
 //BA.debugLineNum = 22347846;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
if ((_hogog>12500001 && _hogog<20830001)) { 
RDebugUtils.currentLine=22347847;
 //BA.debugLineNum = 22347847;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=22347848;
 //BA.debugLineNum = 22347848;BA.debugLine="state2=(hogog-12500000)*0.15";
_state2 = (int) ((_hogog-12500000)*0.15);
 };
RDebugUtils.currentLine=22347850;
 //BA.debugLineNum = 22347850;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
if ((_hogog>20830001 && _hogog<29160001)) { 
RDebugUtils.currentLine=22347851;
 //BA.debugLineNum = 22347851;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=22347852;
 //BA.debugLineNum = 22347852;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=22347853;
 //BA.debugLineNum = 22347853;BA.debugLine="state3=(hogog-20830000)*0.2";
_state3 = (int) ((_hogog-20830000)*0.2);
 };
RDebugUtils.currentLine=22347856;
 //BA.debugLineNum = 22347856;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
if ((_hogog>29160001)) { 
RDebugUtils.currentLine=22347857;
 //BA.debugLineNum = 22347857;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=22347858;
 //BA.debugLineNum = 22347858;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=22347859;
 //BA.debugLineNum = 22347859;BA.debugLine="state3=(8330000)*0.2";
_state3 = (int) ((8330000)*0.2);
RDebugUtils.currentLine=22347861;
 //BA.debugLineNum = 22347861;BA.debugLine="state4=(hogog-29160000)*0.3";
_state4 = (int) ((_hogog-29160000)*0.3);
 };
 };
RDebugUtils.currentLine=22347866;
 //BA.debugLineNum = 22347866;BA.debugLine="If (year=1402)Then";
if ((_year==1402)) { 
RDebugUtils.currentLine=22347867;
 //BA.debugLineNum = 22347867;BA.debugLine="If(hogog>10000001 And hogog<14000001)Then	  ''--";
if ((_hogog>10000001 && _hogog<14000001)) { 
RDebugUtils.currentLine=22347868;
 //BA.debugLineNum = 22347868;BA.debugLine="state1=(hogog-10000000)*0.1";
_state1 = (int) ((_hogog-10000000)*0.1);
 };
RDebugUtils.currentLine=22347870;
 //BA.debugLineNum = 22347870;BA.debugLine="If(hogog>14000001 And hogog<23000001)Then	  ''--";
if ((_hogog>14000001 && _hogog<23000001)) { 
RDebugUtils.currentLine=22347871;
 //BA.debugLineNum = 22347871;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=22347872;
 //BA.debugLineNum = 22347872;BA.debugLine="state2=(hogog-14000000)*0.15";
_state2 = (int) ((_hogog-14000000)*0.15);
 };
RDebugUtils.currentLine=22347874;
 //BA.debugLineNum = 22347874;BA.debugLine="If(hogog>23000001 And hogog<34000001)Then	  ''--";
if ((_hogog>23000001 && _hogog<34000001)) { 
RDebugUtils.currentLine=22347875;
 //BA.debugLineNum = 22347875;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=22347876;
 //BA.debugLineNum = 22347876;BA.debugLine="state2=(9000000)*0.15";
_state2 = (int) ((9000000)*0.15);
RDebugUtils.currentLine=22347877;
 //BA.debugLineNum = 22347877;BA.debugLine="state3=(hogog-23000000)*0.2";
_state3 = (int) ((_hogog-23000000)*0.2);
 };
RDebugUtils.currentLine=22347880;
 //BA.debugLineNum = 22347880;BA.debugLine="If(hogog>34000001)Then	  ''-----stat4";
if ((_hogog>34000001)) { 
RDebugUtils.currentLine=22347881;
 //BA.debugLineNum = 22347881;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=22347882;
 //BA.debugLineNum = 22347882;BA.debugLine="state2=(9000000)*0.15";
_state2 = (int) ((9000000)*0.15);
RDebugUtils.currentLine=22347883;
 //BA.debugLineNum = 22347883;BA.debugLine="state3=(11000000)*0.2";
_state3 = (int) ((11000000)*0.2);
RDebugUtils.currentLine=22347885;
 //BA.debugLineNum = 22347885;BA.debugLine="state4=(hogog-34000001)*0.3";
_state4 = (int) ((_hogog-34000001)*0.3);
 };
 };
RDebugUtils.currentLine=22347891;
 //BA.debugLineNum = 22347891;BA.debugLine="If (year=1403)Then";
if ((_year==1403)) { 
RDebugUtils.currentLine=22347892;
 //BA.debugLineNum = 22347892;BA.debugLine="If(hogog>12000001 And hogog<16500001)Then	  ''--";
if ((_hogog>12000001 && _hogog<16500001)) { 
RDebugUtils.currentLine=22347893;
 //BA.debugLineNum = 22347893;BA.debugLine="state1=(hogog-12000000)*0.1";
_state1 = (int) ((_hogog-12000000)*0.1);
 };
RDebugUtils.currentLine=22347895;
 //BA.debugLineNum = 22347895;BA.debugLine="If(hogog>16500001 And hogog<27000001)Then	  ''--";
if ((_hogog>16500001 && _hogog<27000001)) { 
RDebugUtils.currentLine=22347896;
 //BA.debugLineNum = 22347896;BA.debugLine="state1=(4500000)*0.1";
_state1 = (int) ((4500000)*0.1);
RDebugUtils.currentLine=22347897;
 //BA.debugLineNum = 22347897;BA.debugLine="state2=(hogog-16500000)*0.15";
_state2 = (int) ((_hogog-16500000)*0.15);
 };
RDebugUtils.currentLine=22347899;
 //BA.debugLineNum = 22347899;BA.debugLine="If(hogog>27000001 And hogog<40000001)Then	  ''--";
if ((_hogog>27000001 && _hogog<40000001)) { 
RDebugUtils.currentLine=22347900;
 //BA.debugLineNum = 22347900;BA.debugLine="state1=(4500000)*0.1";
_state1 = (int) ((4500000)*0.1);
RDebugUtils.currentLine=22347901;
 //BA.debugLineNum = 22347901;BA.debugLine="state2=(10500000)*0.15";
_state2 = (int) ((10500000)*0.15);
RDebugUtils.currentLine=22347902;
 //BA.debugLineNum = 22347902;BA.debugLine="state3=(hogog-27000000)*0.2";
_state3 = (int) ((_hogog-27000000)*0.2);
 };
RDebugUtils.currentLine=22347905;
 //BA.debugLineNum = 22347905;BA.debugLine="If(hogog>40000001)Then	  ''-----stat4";
if ((_hogog>40000001)) { 
RDebugUtils.currentLine=22347906;
 //BA.debugLineNum = 22347906;BA.debugLine="state1=(4500000)*0.1";
_state1 = (int) ((4500000)*0.1);
RDebugUtils.currentLine=22347907;
 //BA.debugLineNum = 22347907;BA.debugLine="state2=(10500000)*0.15";
_state2 = (int) ((10500000)*0.15);
RDebugUtils.currentLine=22347908;
 //BA.debugLineNum = 22347908;BA.debugLine="state3=(13000000)*0.2";
_state3 = (int) ((13000000)*0.2);
RDebugUtils.currentLine=22347910;
 //BA.debugLineNum = 22347910;BA.debugLine="state4=(hogog-40000001)*0.3";
_state4 = (int) ((_hogog-40000001)*0.3);
 };
 };
RDebugUtils.currentLine=22347919;
 //BA.debugLineNum = 22347919;BA.debugLine="If (year=1404)Then";
if ((_year==1404)) { 
RDebugUtils.currentLine=22347920;
 //BA.debugLineNum = 22347920;BA.debugLine="If(hogog>24000001 And hogog<30000001)Then	  ''--";
if ((_hogog>24000001 && _hogog<30000001)) { 
RDebugUtils.currentLine=22347921;
 //BA.debugLineNum = 22347921;BA.debugLine="state1=(hogog-24000000)*0.1";
_state1 = (int) ((_hogog-24000000)*0.1);
 };
RDebugUtils.currentLine=22347923;
 //BA.debugLineNum = 22347923;BA.debugLine="If(hogog>30000001 And hogog<38000001)Then	  ''--";
if ((_hogog>30000001 && _hogog<38000001)) { 
RDebugUtils.currentLine=22347924;
 //BA.debugLineNum = 22347924;BA.debugLine="state1=(6000000)*0.1";
_state1 = (int) ((6000000)*0.1);
RDebugUtils.currentLine=22347925;
 //BA.debugLineNum = 22347925;BA.debugLine="state2=(hogog-30000000)*0.15";
_state2 = (int) ((_hogog-30000000)*0.15);
 };
RDebugUtils.currentLine=22347927;
 //BA.debugLineNum = 22347927;BA.debugLine="If(hogog>38000001 And hogog<50000001)Then	  ''--";
if ((_hogog>38000001 && _hogog<50000001)) { 
RDebugUtils.currentLine=22347928;
 //BA.debugLineNum = 22347928;BA.debugLine="state1=(6000000)*0.1";
_state1 = (int) ((6000000)*0.1);
RDebugUtils.currentLine=22347929;
 //BA.debugLineNum = 22347929;BA.debugLine="state2=(8000000)*0.15";
_state2 = (int) ((8000000)*0.15);
RDebugUtils.currentLine=22347930;
 //BA.debugLineNum = 22347930;BA.debugLine="state3=(hogog-38000000)*0.2";
_state3 = (int) ((_hogog-38000000)*0.2);
 };
RDebugUtils.currentLine=22347933;
 //BA.debugLineNum = 22347933;BA.debugLine="If(hogog>50000001 And hogog<66700001)Then	  ''--";
if ((_hogog>50000001 && _hogog<66700001)) { 
RDebugUtils.currentLine=22347934;
 //BA.debugLineNum = 22347934;BA.debugLine="state1=(6000000)*0.1";
_state1 = (int) ((6000000)*0.1);
RDebugUtils.currentLine=22347935;
 //BA.debugLineNum = 22347935;BA.debugLine="state2=(8000000)*0.15";
_state2 = (int) ((8000000)*0.15);
RDebugUtils.currentLine=22347936;
 //BA.debugLineNum = 22347936;BA.debugLine="state3=(12000000)*0.2";
_state3 = (int) ((12000000)*0.2);
RDebugUtils.currentLine=22347937;
 //BA.debugLineNum = 22347937;BA.debugLine="state4=(hogog-50000001)*0.25";
_state4 = (int) ((_hogog-50000001)*0.25);
 };
RDebugUtils.currentLine=22347939;
 //BA.debugLineNum = 22347939;BA.debugLine="If(hogog>66700001)Then	  ''-----stat5";
if ((_hogog>66700001)) { 
RDebugUtils.currentLine=22347940;
 //BA.debugLineNum = 22347940;BA.debugLine="state1=(6000000)*0.1";
_state1 = (int) ((6000000)*0.1);
RDebugUtils.currentLine=22347941;
 //BA.debugLineNum = 22347941;BA.debugLine="state2=(8000000)*0.15";
_state2 = (int) ((8000000)*0.15);
RDebugUtils.currentLine=22347942;
 //BA.debugLineNum = 22347942;BA.debugLine="state3=(12000000)*0.2";
_state3 = (int) ((12000000)*0.2);
RDebugUtils.currentLine=22347943;
 //BA.debugLineNum = 22347943;BA.debugLine="state4=(16700000)*0.25";
_state4 = (int) ((16700000)*0.25);
RDebugUtils.currentLine=22347944;
 //BA.debugLineNum = 22347944;BA.debugLine="state5=(hogog-66700001)*0.3";
_state5 = (int) ((_hogog-66700001)*0.3);
 };
 };
RDebugUtils.currentLine=22347961;
 //BA.debugLineNum = 22347961;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
_all_maliat = (int) (_state1+_state2+_state3+_state4+_state5+_state6);
RDebugUtils.currentLine=22347962;
 //BA.debugLineNum = 22347962;BA.debugLine="Return all_maliat";
if (true) return _all_maliat;
RDebugUtils.currentLine=22347964;
 //BA.debugLineNum = 22347964;BA.debugLine="End Sub";
return 0;
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=22937600;
 //BA.debugLineNum = 22937600;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=22937601;
 //BA.debugLineNum = 22937601;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=22937602;
 //BA.debugLineNum = 22937602;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_set_date_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_set_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_set_date_click", null));}
RDebugUtils.currentLine=23592960;
 //BA.debugLineNum = 23592960;BA.debugLine="Private Sub pan_all_set_date_Click";
RDebugUtils.currentLine=23592961;
 //BA.debugLineNum = 23592961;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=23592962;
 //BA.debugLineNum = 23592962;BA.debugLine="End Sub";
return "";
}
public static String  _pan_mohasebat_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_mohasebat_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_mohasebat_click", null));}
RDebugUtils.currentLine=22740992;
 //BA.debugLineNum = 22740992;BA.debugLine="Private Sub pan_mohasebat_Click";
RDebugUtils.currentLine=22740994;
 //BA.debugLineNum = 22740994;BA.debugLine="End Sub";
return "";
}
public static String  _panel7_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel7_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel7_click", null));}
RDebugUtils.currentLine=22872064;
 //BA.debugLineNum = 22872064;BA.debugLine="Private Sub Panel7_Click";
RDebugUtils.currentLine=22872066;
 //BA.debugLineNum = 22872066;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=24313856;
 //BA.debugLineNum = 24313856;BA.debugLine="Private Sub pik_day_bala1_Click";
RDebugUtils.currentLine=24313857;
 //BA.debugLineNum = 24313857;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=24313858;
 //BA.debugLineNum = 24313858;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=24313861;
 //BA.debugLineNum = 24313861;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=24313862;
 //BA.debugLineNum = 24313862;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=24313863;
 //BA.debugLineNum = 24313863;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=24313865;
 //BA.debugLineNum = 24313865;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=24313866;
 //BA.debugLineNum = 24313866;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=24313869;
 //BA.debugLineNum = 24313869;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=24313870;
 //BA.debugLineNum = 24313870;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=24313872;
 //BA.debugLineNum = 24313872;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=24313873;
 //BA.debugLineNum = 24313873;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=24313876;
 //BA.debugLineNum = 24313876;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=24313877;
 //BA.debugLineNum = 24313877;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=24379392;
 //BA.debugLineNum = 24379392;BA.debugLine="Private Sub pik_day_paeen1_Click";
RDebugUtils.currentLine=24379393;
 //BA.debugLineNum = 24379393;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=24379394;
 //BA.debugLineNum = 24379394;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=24379395;
 //BA.debugLineNum = 24379395;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=24379396;
 //BA.debugLineNum = 24379396;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=24379397;
 //BA.debugLineNum = 24379397;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=24379399;
 //BA.debugLineNum = 24379399;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=24379400;
 //BA.debugLineNum = 24379400;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=24379403;
 //BA.debugLineNum = 24379403;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=24379404;
 //BA.debugLineNum = 24379404;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=24379406;
 //BA.debugLineNum = 24379406;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=24379407;
 //BA.debugLineNum = 24379407;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=24379410;
 //BA.debugLineNum = 24379410;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=24379411;
 //BA.debugLineNum = 24379411;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=24051712;
 //BA.debugLineNum = 24051712;BA.debugLine="Private Sub pik_moon_bala1_Click";
RDebugUtils.currentLine=24051713;
 //BA.debugLineNum = 24051713;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=24051714;
 //BA.debugLineNum = 24051714;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
RDebugUtils.currentLine=24051716;
 //BA.debugLineNum = 24051716;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=24051717;
 //BA.debugLineNum = 24051717;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=24051719;
 //BA.debugLineNum = 24051719;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=24051720;
 //BA.debugLineNum = 24051720;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=24051722;
 //BA.debugLineNum = 24051722;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=24051724;
 //BA.debugLineNum = 24051724;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=24117248;
 //BA.debugLineNum = 24117248;BA.debugLine="Private Sub pik_moon_paeen1_Click";
RDebugUtils.currentLine=24117249;
 //BA.debugLineNum = 24117249;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=24117250;
 //BA.debugLineNum = 24117250;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
RDebugUtils.currentLine=24117252;
 //BA.debugLineNum = 24117252;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=24117253;
 //BA.debugLineNum = 24117253;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=24117255;
 //BA.debugLineNum = 24117255;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=24117256;
 //BA.debugLineNum = 24117256;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=24117258;
 //BA.debugLineNum = 24117258;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
RDebugUtils.currentLine=24117260;
 //BA.debugLineNum = 24117260;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_day1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_day1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=23986176;
 //BA.debugLineNum = 23986176;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
RDebugUtils.currentLine=23986177;
 //BA.debugLineNum = 23986177;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=23986178;
 //BA.debugLineNum = 23986178;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=23986179;
 //BA.debugLineNum = 23986179;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23986182;
 //BA.debugLineNum = 23986182;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=23986184;
 //BA.debugLineNum = 23986184;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=23986185;
 //BA.debugLineNum = 23986185;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
RDebugUtils.currentLine=23986186;
 //BA.debugLineNum = 23986186;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=23986187;
 //BA.debugLineNum = 23986187;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23986189;
 //BA.debugLineNum = 23986189;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=23986190;
 //BA.debugLineNum = 23986190;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
RDebugUtils.currentLine=23986191;
 //BA.debugLineNum = 23986191;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=23986192;
 //BA.debugLineNum = 23986192;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23986195;
 //BA.debugLineNum = 23986195;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=23986196;
 //BA.debugLineNum = 23986196;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=23986197;
 //BA.debugLineNum = 23986197;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=23986199;
 //BA.debugLineNum = 23986199;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=23986200;
 //BA.debugLineNum = 23986200;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=23986203;
 //BA.debugLineNum = 23986203;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=23986204;
 //BA.debugLineNum = 23986204;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=23986206;
 //BA.debugLineNum = 23986206;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=23986207;
 //BA.debugLineNum = 23986207;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=23986210;
 //BA.debugLineNum = 23986210;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 };
RDebugUtils.currentLine=23986214;
 //BA.debugLineNum = 23986214;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_moon1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_moon1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=23855104;
 //BA.debugLineNum = 23855104;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
RDebugUtils.currentLine=23855105;
 //BA.debugLineNum = 23855105;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=23855106;
 //BA.debugLineNum = 23855106;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=23855107;
 //BA.debugLineNum = 23855107;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23855110;
 //BA.debugLineNum = 23855110;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=23855112;
 //BA.debugLineNum = 23855112;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=23855113;
 //BA.debugLineNum = 23855113;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
RDebugUtils.currentLine=23855114;
 //BA.debugLineNum = 23855114;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=23855115;
 //BA.debugLineNum = 23855115;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23855117;
 //BA.debugLineNum = 23855117;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=23855118;
 //BA.debugLineNum = 23855118;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
RDebugUtils.currentLine=23855119;
 //BA.debugLineNum = 23855119;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=23855120;
 //BA.debugLineNum = 23855120;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23855123;
 //BA.debugLineNum = 23855123;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=23855124;
 //BA.debugLineNum = 23855124;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=23855126;
 //BA.debugLineNum = 23855126;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=23855127;
 //BA.debugLineNum = 23855127;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=23855129;
 //BA.debugLineNum = 23855129;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
RDebugUtils.currentLine=23855132;
 //BA.debugLineNum = 23855132;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_year1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_year1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=23920640;
 //BA.debugLineNum = 23920640;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
RDebugUtils.currentLine=23920641;
 //BA.debugLineNum = 23920641;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=23920642;
 //BA.debugLineNum = 23920642;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=23920643;
 //BA.debugLineNum = 23920643;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23920646;
 //BA.debugLineNum = 23920646;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=23920648;
 //BA.debugLineNum = 23920648;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=23920649;
 //BA.debugLineNum = 23920649;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
RDebugUtils.currentLine=23920650;
 //BA.debugLineNum = 23920650;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=23920651;
 //BA.debugLineNum = 23920651;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23920653;
 //BA.debugLineNum = 23920653;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=23920654;
 //BA.debugLineNum = 23920654;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
RDebugUtils.currentLine=23920655;
 //BA.debugLineNum = 23920655;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=23920656;
 //BA.debugLineNum = 23920656;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=23920659;
 //BA.debugLineNum = 23920659;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=23920660;
 //BA.debugLineNum = 23920660;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=23920662;
 //BA.debugLineNum = 23920662;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=23920663;
 //BA.debugLineNum = 23920663;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
RDebugUtils.currentLine=23920668;
 //BA.debugLineNum = 23920668;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=24182784;
 //BA.debugLineNum = 24182784;BA.debugLine="Private Sub pik_year_bala1_Click";
RDebugUtils.currentLine=24182785;
 //BA.debugLineNum = 24182785;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=24182786;
 //BA.debugLineNum = 24182786;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=24182788;
 //BA.debugLineNum = 24182788;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=24182789;
 //BA.debugLineNum = 24182789;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=24182791;
 //BA.debugLineNum = 24182791;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=24182792;
 //BA.debugLineNum = 24182792;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=24182795;
 //BA.debugLineNum = 24182795;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=24248320;
 //BA.debugLineNum = 24248320;BA.debugLine="Private Sub pik_year_paeen1_Click";
RDebugUtils.currentLine=24248321;
 //BA.debugLineNum = 24248321;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=24248322;
 //BA.debugLineNum = 24248322;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=24248324;
 //BA.debugLineNum = 24248324;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=24248325;
 //BA.debugLineNum = 24248325;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=24248327;
 //BA.debugLineNum = 24248327;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=24248328;
 //BA.debugLineNum = 24248328;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=24248331;
 //BA.debugLineNum = 24248331;BA.debugLine="End Sub";
return "";
}
public static String  _radio_type1_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "radio_type1_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "radio_type1_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=23396352;
 //BA.debugLineNum = 23396352;BA.debugLine="Private Sub radio_type1_CheckedChange(Checked As B";
RDebugUtils.currentLine=23396353;
 //BA.debugLineNum = 23396353;BA.debugLine="sp_moon.Enabled=True";
mostCurrent._sp_moon.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=23396354;
 //BA.debugLineNum = 23396354;BA.debugLine="sp_year.Enabled=True";
mostCurrent._sp_year.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=23396355;
 //BA.debugLineNum = 23396355;BA.debugLine="lbl_date_from.Enabled=False";
mostCurrent._lbl_date_from.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=23396356;
 //BA.debugLineNum = 23396356;BA.debugLine="lbl_date_to.Enabled=False";
mostCurrent._lbl_date_to.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=23396357;
 //BA.debugLineNum = 23396357;BA.debugLine="type_mohasebe=1";
_type_mohasebe = (int) (1);
RDebugUtils.currentLine=23396358;
 //BA.debugLineNum = 23396358;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
RDebugUtils.currentLine=23396359;
 //BA.debugLineNum = 23396359;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=23396360;
 //BA.debugLineNum = 23396360;BA.debugLine="End Sub";
return "";
}
public static String  _radio_type2_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "radio_type2_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "radio_type2_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=23330816;
 //BA.debugLineNum = 23330816;BA.debugLine="Private Sub radio_type2_CheckedChange(Checked As B";
RDebugUtils.currentLine=23330817;
 //BA.debugLineNum = 23330817;BA.debugLine="sp_moon.Enabled=False";
mostCurrent._sp_moon.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=23330818;
 //BA.debugLineNum = 23330818;BA.debugLine="sp_year.Enabled=False";
mostCurrent._sp_year.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=23330819;
 //BA.debugLineNum = 23330819;BA.debugLine="lbl_date_from.Enabled=True";
mostCurrent._lbl_date_from.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=23330820;
 //BA.debugLineNum = 23330820;BA.debugLine="lbl_date_to.Enabled=True";
mostCurrent._lbl_date_to.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=23330821;
 //BA.debugLineNum = 23330821;BA.debugLine="type_mohasebe=2";
_type_mohasebe = (int) (2);
RDebugUtils.currentLine=23330822;
 //BA.debugLineNum = 23330822;BA.debugLine="fix_date2_decreceOne";
_fix_date2_decreceone();
RDebugUtils.currentLine=23330823;
 //BA.debugLineNum = 23330823;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=23330824;
 //BA.debugLineNum = 23330824;BA.debugLine="End Sub";
return "";
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_moon_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_moon_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=22413312;
 //BA.debugLineNum = 22413312;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=22413313;
 //BA.debugLineNum = 22413313;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=22413315;
 //BA.debugLineNum = 22413315;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=22478848;
 //BA.debugLineNum = 22478848;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=22478849;
 //BA.debugLineNum = 22478849;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=22478850;
 //BA.debugLineNum = 22478850;BA.debugLine="End Sub";
return "";
}
public static String  _time_page_load_tick() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time_page_load_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "time_page_load_tick", null));}
RDebugUtils.currentLine=21692416;
 //BA.debugLineNum = 21692416;BA.debugLine="Sub time_page_load_Tick";
RDebugUtils.currentLine=21692417;
 //BA.debugLineNum = 21692417;BA.debugLine="pan_load.Visible=False";
mostCurrent._pan_load.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=21692418;
 //BA.debugLineNum = 21692418;BA.debugLine="B4XLoadingIndicator1.Hide";
mostCurrent._b4xloadingindicator1._hide /*String*/ (null);
RDebugUtils.currentLine=21692419;
 //BA.debugLineNum = 21692419;BA.debugLine="Main.time_page_load.Enabled=False";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=21692420;
 //BA.debugLineNum = 21692420;BA.debugLine="End Sub";
return "";
}
}