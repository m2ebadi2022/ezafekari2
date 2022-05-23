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
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.drawable.BitmapDrawable _imm = null;
RDebugUtils.currentLine=17301504;
 //BA.debugLineNum = 17301504;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=17301506;
 //BA.debugLineNum = 17301506;BA.debugLine="Activity.LoadLayout(\"hogog_layout\")";
mostCurrent._activity.LoadLayout("hogog_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=17301507;
 //BA.debugLineNum = 17301507;BA.debugLine="scv_hogog.Panel.LoadLayout(\"item_hogog\")";
mostCurrent._scv_hogog.getPanel().LoadLayout("item_hogog",mostCurrent.activityBA);
RDebugUtils.currentLine=17301509;
 //BA.debugLineNum = 17301509;BA.debugLine="get_data_hogogi";
_get_data_hogogi();
RDebugUtils.currentLine=17301511;
 //BA.debugLineNum = 17301511;BA.debugLine="Main.time_page_load.Initialize(\"time_page_load\",1";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .Initialize(processBA,"time_page_load",(long) (1500));
RDebugUtils.currentLine=17301512;
 //BA.debugLineNum = 17301512;BA.debugLine="Main.time_page_load.Enabled=True";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=17301513;
 //BA.debugLineNum = 17301513;BA.debugLine="B4XLoadingIndicator1.Show";
mostCurrent._b4xloadingindicator1._show /*String*/ (null);
RDebugUtils.currentLine=17301515;
 //BA.debugLineNum = 17301515;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
RDebugUtils.currentLine=17301516;
 //BA.debugLineNum = 17301516;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
RDebugUtils.currentLine=17301517;
 //BA.debugLineNum = 17301517;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
RDebugUtils.currentLine=17301518;
 //BA.debugLineNum = 17301518;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
RDebugUtils.currentLine=17301520;
 //BA.debugLineNum = 17301520;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=17301522;
 //BA.debugLineNum = 17301522;BA.debugLine="Dim imm As BitmapDrawable";
_imm = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=17301523;
 //BA.debugLineNum = 17301523;BA.debugLine="imm.Initialize(LoadBitmap(File.DirAssets,\"textBox";
_imm.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"textBox.png").getObject()));
RDebugUtils.currentLine=17301524;
 //BA.debugLineNum = 17301524;BA.debugLine="imm.Gravity=Gravity.FILL";
_imm.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=17301525;
 //BA.debugLineNum = 17301525;BA.debugLine="sp_year.Background=imm";
mostCurrent._sp_year.setBackground((android.graphics.drawable.Drawable)(_imm.getObject()));
RDebugUtils.currentLine=17301526;
 //BA.debugLineNum = 17301526;BA.debugLine="sp_moon.Background=imm";
mostCurrent._sp_moon.setBackground((android.graphics.drawable.Drawable)(_imm.getObject()));
RDebugUtils.currentLine=17301529;
 //BA.debugLineNum = 17301529;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))-1));
RDebugUtils.currentLine=17301530;
 //BA.debugLineNum = 17301530;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=17301534;
 //BA.debugLineNum = 17301534;BA.debugLine="pan_hed_hogog.Color=Main.color4";
mostCurrent._pan_hed_hogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=17301535;
 //BA.debugLineNum = 17301535;BA.debugLine="pan_main_hed_hogog.Color=Main.color4";
mostCurrent._pan_main_hed_hogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=17301536;
 //BA.debugLineNum = 17301536;BA.debugLine="pan_hed_gozaresh.Color=Main.color4";
mostCurrent._pan_hed_gozaresh.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=17301537;
 //BA.debugLineNum = 17301537;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=17301540;
 //BA.debugLineNum = 17301540;BA.debugLine="WebView1.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview1.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=17301541;
 //BA.debugLineNum = 17301541;BA.debugLine="WebView2.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview2.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=17301544;
 //BA.debugLineNum = 17301544;BA.debugLine="ls_onvanHa.Initialize";
mostCurrent._ls_onvanha.Initialize();
RDebugUtils.currentLine=17301545;
 //BA.debugLineNum = 17301545;BA.debugLine="ls_onvanHa=dbCode.read_onvan_db";
mostCurrent._ls_onvanha = mostCurrent._dbcode._read_onvan_db /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=17301548;
 //BA.debugLineNum = 17301548;BA.debugLine="str_web1.Initialize";
mostCurrent._str_web1.Initialize();
RDebugUtils.currentLine=17301549;
 //BA.debugLineNum = 17301549;BA.debugLine="str_web1.Append(\"<html dir='rtl'><meta charset='U";
mostCurrent._str_web1.Append("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>");
RDebugUtils.currentLine=17301550;
 //BA.debugLineNum = 17301550;BA.debugLine="str_web1.Append(\"<h4 align='center' >اطلاعات حقوق";
mostCurrent._str_web1.Append("<h4 align='center' >اطلاعات حقوق برای ۳۰ روز</h4>");
RDebugUtils.currentLine=17301551;
 //BA.debugLineNum = 17301551;BA.debugLine="str_web1.Append(\"<h6 align='center'>واحد : تومان<";
mostCurrent._str_web1.Append("<h6 align='center'>واحد : تومان</h6>");
RDebugUtils.currentLine=17301552;
 //BA.debugLineNum = 17301552;BA.debugLine="str_web1.Append(\"<table style='width:100%'><tr>\")";
mostCurrent._str_web1.Append("<table style='width:100%'><tr>");
RDebugUtils.currentLine=17301553;
 //BA.debugLineNum = 17301553;BA.debugLine="str_web1.Append(\"<td>\"&\"\"&ls_onvanHa.Get(0)&\" : \"";
mostCurrent._str_web1.Append("<td>"+""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (0)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool((int)(Double.parseDouble(mostCurrent._paye))))+"<br>");
RDebugUtils.currentLine=17301554;
 //BA.debugLineNum = 17301554;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(2)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (2)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maskan))+"<br>");
RDebugUtils.currentLine=17301555;
 //BA.debugLineNum = 17301555;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(3)&\" : \"&myfun";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (3)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bon))+"<br>");
RDebugUtils.currentLine=17301556;
 //BA.debugLineNum = 17301556;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(4)&\"  : \"&myfun";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (4)))+"  : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad))+"<br>");
RDebugUtils.currentLine=17301557;
 //BA.debugLineNum = 17301557;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(5)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (5)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_fani))+"<br>");
RDebugUtils.currentLine=17301558;
 //BA.debugLineNum = 17301558;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(6)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (6)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_masoliat))+"<br>");
RDebugUtils.currentLine=17301559;
 //BA.debugLineNum = 17301559;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(7)&\"  : \"&myfu";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (7)))+"  : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sarparasti))+"<br></td>");
RDebugUtils.currentLine=17301563;
 //BA.debugLineNum = 17301563;BA.debugLine="str_web1.Append(\"<td>\"&\" \"&ls_onvanHa.Get(1)&\" :";
mostCurrent._str_web1.Append("<td>"+" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (1)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat))+"<br>");
RDebugUtils.currentLine=17301564;
 //BA.debugLineNum = 17301564;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(8)&\" : \"&myfun";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (8)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_shift))+"<br>");
RDebugUtils.currentLine=17301565;
 //BA.debugLineNum = 17301565;BA.debugLine="str_web1.Append(\"بیمه تامین اجتماعی : %\"&myfunc.e";
mostCurrent._str_web1.Append("بیمه تامین اجتماعی : %"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_bime_tamin))+"<br>");
RDebugUtils.currentLine=17301566;
 //BA.debugLineNum = 17301566;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(9)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (9)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_takmil))+"<br>");
RDebugUtils.currentLine=17301567;
 //BA.debugLineNum = 17301567;BA.debugLine="str_web1.Append(\" مالیات : مطابق قانون کار<br>\")";
mostCurrent._str_web1.Append(" مالیات : مطابق قانون کار<br>");
RDebugUtils.currentLine=17301568;
 //BA.debugLineNum = 17301568;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(10)&\" : \"&myf";
mostCurrent._str_web1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (10)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya))+"<br>");
RDebugUtils.currentLine=17301569;
 //BA.debugLineNum = 17301569;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(11)&\" : \"&myf";
mostCurrent._str_web1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (11)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat))+"</td>");
RDebugUtils.currentLine=17301570;
 //BA.debugLineNum = 17301570;BA.debugLine="str_web1.Append(\"</tr></table>\")";
mostCurrent._str_web1.Append("</tr></table>");
RDebugUtils.currentLine=17301571;
 //BA.debugLineNum = 17301571;BA.debugLine="str_web1.Append(\"</body></html>\")";
mostCurrent._str_web1.Append("</body></html>");
RDebugUtils.currentLine=17301573;
 //BA.debugLineNum = 17301573;BA.debugLine="WebView1.LoadHtml(str_web1)";
mostCurrent._webview1.LoadHtml(BA.ObjectToString(mostCurrent._str_web1));
RDebugUtils.currentLine=17301577;
 //BA.debugLineNum = 17301577;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=17301578;
 //BA.debugLineNum = 17301578;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
RDebugUtils.currentLine=17301579;
 //BA.debugLineNum = 17301579;BA.debugLine="End Sub";
return "";
}
public static String  _get_data_hogogi() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_data_hogogi", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_data_hogogi", null));}
RDebugUtils.currentLine=18087936;
 //BA.debugLineNum = 18087936;BA.debugLine="Sub get_data_hogogi";
RDebugUtils.currentLine=18087938;
 //BA.debugLineNum = 18087938;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=18087939;
 //BA.debugLineNum = 18087939;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=18087941;
 //BA.debugLineNum = 18087941;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=18087942;
 //BA.debugLineNum = 18087942;BA.debugLine="paye=dbCode.res.GetString(\"value\")";
mostCurrent._paye = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value");
RDebugUtils.currentLine=18087944;
 //BA.debugLineNum = 18087944;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (1));
RDebugUtils.currentLine=18087945;
 //BA.debugLineNum = 18087945;BA.debugLine="maskan=dbCode.res.GetString(\"value\")";
_maskan = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=18087947;
 //BA.debugLineNum = 18087947;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (3));
RDebugUtils.currentLine=18087948;
 //BA.debugLineNum = 18087948;BA.debugLine="olad=dbCode.res.GetString(\"value\")";
_olad = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=18087950;
 //BA.debugLineNum = 18087950;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (4));
RDebugUtils.currentLine=18087951;
 //BA.debugLineNum = 18087951;BA.debugLine="fani=dbCode.res.GetString(\"value\")";
_fani = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=18087953;
 //BA.debugLineNum = 18087953;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (5));
RDebugUtils.currentLine=18087954;
 //BA.debugLineNum = 18087954;BA.debugLine="masoliat=dbCode.res.GetString(\"value\")";
_masoliat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=18087956;
 //BA.debugLineNum = 18087956;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (2));
RDebugUtils.currentLine=18087957;
 //BA.debugLineNum = 18087957;BA.debugLine="bon=dbCode.res.GetString(\"value\")";
_bon = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=18087959;
 //BA.debugLineNum = 18087959;BA.debugLine="dbCode.res.Position=6 ''--------bime_tamin------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (6));
RDebugUtils.currentLine=18087960;
 //BA.debugLineNum = 18087960;BA.debugLine="bime_tamin=dbCode.res.GetString(\"value\")";
_bime_tamin = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=18087962;
 //BA.debugLineNum = 18087962;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (11));
RDebugUtils.currentLine=18087963;
 //BA.debugLineNum = 18087963;BA.debugLine="bime_takmil=dbCode.res.GetString(\"value\")";
_bime_takmil = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=18087971;
 //BA.debugLineNum = 18087971;BA.debugLine="dbCode.res.Position=13 ''--------hag shift------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (13));
RDebugUtils.currentLine=18087972;
 //BA.debugLineNum = 18087972;BA.debugLine="shift=dbCode.res.GetString(\"value\")";
_shift = (double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=18087974;
 //BA.debugLineNum = 18087974;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (14));
RDebugUtils.currentLine=18087975;
 //BA.debugLineNum = 18087975;BA.debugLine="sanavat=dbCode.res.GetString(\"value\")";
_sanavat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=18087977;
 //BA.debugLineNum = 18087977;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (15));
RDebugUtils.currentLine=18087978;
 //BA.debugLineNum = 18087978;BA.debugLine="sarparasti=dbCode.res.GetString(\"value\")";
_sarparasti = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=18087980;
 //BA.debugLineNum = 18087980;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (16));
RDebugUtils.currentLine=18087981;
 //BA.debugLineNum = 18087981;BA.debugLine="mazaya=dbCode.res.GetString(\"value\")";
_mazaya = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=18087983;
 //BA.debugLineNum = 18087983;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (19));
RDebugUtils.currentLine=18087984;
 //BA.debugLineNum = 18087984;BA.debugLine="ksorat=dbCode.res.GetString(\"value\")";
_ksorat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=18087994;
 //BA.debugLineNum = 18087994;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=18087995;
 //BA.debugLineNum = 18087995;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=18087999;
 //BA.debugLineNum = 18087999;BA.debugLine="End Sub";
return "";
}
public static String  _et_time_indb() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_time_indb", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_time_indb", null));}
anywheresoftware.b4a.objects.collections.List _list_ezafekari1 = null;
anywheresoftware.b4a.objects.collections.List _list_ezafekari2 = null;
RDebugUtils.currentLine=17760256;
 //BA.debugLineNum = 17760256;BA.debugLine="Sub et_time_inDB";
RDebugUtils.currentLine=17760259;
 //BA.debugLineNum = 17760259;BA.debugLine="Select sp_moon.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_moon.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11))) {
case 0: {
RDebugUtils.currentLine=17760261;
 //BA.debugLineNum = 17760261;BA.debugLine="moon_num=\"01\"";
mostCurrent._moon_num = "01";
 break; }
case 1: {
RDebugUtils.currentLine=17760263;
 //BA.debugLineNum = 17760263;BA.debugLine="moon_num=\"02\"";
mostCurrent._moon_num = "02";
 break; }
case 2: {
RDebugUtils.currentLine=17760265;
 //BA.debugLineNum = 17760265;BA.debugLine="moon_num=\"03\"";
mostCurrent._moon_num = "03";
 break; }
case 3: {
RDebugUtils.currentLine=17760267;
 //BA.debugLineNum = 17760267;BA.debugLine="moon_num=\"04\"";
mostCurrent._moon_num = "04";
 break; }
case 4: {
RDebugUtils.currentLine=17760269;
 //BA.debugLineNum = 17760269;BA.debugLine="moon_num=\"05\"";
mostCurrent._moon_num = "05";
 break; }
case 5: {
RDebugUtils.currentLine=17760271;
 //BA.debugLineNum = 17760271;BA.debugLine="moon_num=\"06\"";
mostCurrent._moon_num = "06";
 break; }
case 6: {
RDebugUtils.currentLine=17760273;
 //BA.debugLineNum = 17760273;BA.debugLine="moon_num=\"07\"";
mostCurrent._moon_num = "07";
 break; }
case 7: {
RDebugUtils.currentLine=17760275;
 //BA.debugLineNum = 17760275;BA.debugLine="moon_num=\"08\"";
mostCurrent._moon_num = "08";
 break; }
case 8: {
RDebugUtils.currentLine=17760277;
 //BA.debugLineNum = 17760277;BA.debugLine="moon_num=\"09\"";
mostCurrent._moon_num = "09";
 break; }
case 9: {
RDebugUtils.currentLine=17760279;
 //BA.debugLineNum = 17760279;BA.debugLine="moon_num=\"10\"";
mostCurrent._moon_num = "10";
 break; }
case 10: {
RDebugUtils.currentLine=17760281;
 //BA.debugLineNum = 17760281;BA.debugLine="moon_num=\"11\"";
mostCurrent._moon_num = "11";
 break; }
case 11: {
RDebugUtils.currentLine=17760283;
 //BA.debugLineNum = 17760283;BA.debugLine="moon_num=\"12\"";
mostCurrent._moon_num = "12";
 break; }
}
;
RDebugUtils.currentLine=17760288;
 //BA.debugLineNum = 17760288;BA.debugLine="Dim list_ezafekari1 As List";
_list_ezafekari1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17760289;
 //BA.debugLineNum = 17760289;BA.debugLine="list_ezafekari1.Initialize";
_list_ezafekari1.Initialize();
RDebugUtils.currentLine=17760290;
 //BA.debugLineNum = 17760290;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_mah(sp_year.";
_list_ezafekari1 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num,(int) (2));
RDebugUtils.currentLine=17760291;
 //BA.debugLineNum = 17760291;BA.debugLine="et_time_h.Text=list_ezafekari1.Get(0)";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (0))));
RDebugUtils.currentLine=17760292;
 //BA.debugLineNum = 17760292;BA.debugLine="et_time_m.Text=list_ezafekari1.Get(1)";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (1))));
RDebugUtils.currentLine=17760295;
 //BA.debugLineNum = 17760295;BA.debugLine="Dim list_ezafekari2 As List";
_list_ezafekari2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17760296;
 //BA.debugLineNum = 17760296;BA.debugLine="list_ezafekari2.Initialize";
_list_ezafekari2.Initialize();
RDebugUtils.currentLine=17760297;
 //BA.debugLineNum = 17760297;BA.debugLine="list_ezafekari2=dbCode.all_ezafekari_mah(sp_year.";
_list_ezafekari2 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num,(int) (3));
RDebugUtils.currentLine=17760298;
 //BA.debugLineNum = 17760298;BA.debugLine="et_time_h_vij.Text=list_ezafekari2.Get(0)";
mostCurrent._et_time_h_vij.setText(BA.ObjectToCharSequence(_list_ezafekari2.Get((int) (0))));
RDebugUtils.currentLine=17760299;
 //BA.debugLineNum = 17760299;BA.debugLine="et_time_m_vij.Text=list_ezafekari2.Get(1)";
mostCurrent._et_time_m_vij.setText(BA.ObjectToCharSequence(_list_ezafekari2.Get((int) (1))));
RDebugUtils.currentLine=17760303;
 //BA.debugLineNum = 17760303;BA.debugLine="If(moon_num<7)Then";
if (((double)(Double.parseDouble(mostCurrent._moon_num))<7)) { 
RDebugUtils.currentLine=17760304;
 //BA.debugLineNum = 17760304;BA.debugLine="roze_kari=31";
_roze_kari = (int) (31);
 }else {
RDebugUtils.currentLine=17760306;
 //BA.debugLineNum = 17760306;BA.debugLine="roze_kari=30";
_roze_kari = (int) (30);
 };
RDebugUtils.currentLine=17760308;
 //BA.debugLineNum = 17760308;BA.debugLine="et_rozekari.Text=roze_kari";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(_roze_kari));
RDebugUtils.currentLine=17760309;
 //BA.debugLineNum = 17760309;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(int _num) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_num_pool", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_num_pool", new Object[] {_num}));}
RDebugUtils.currentLine=17694720;
 //BA.debugLineNum = 17694720;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=17694721;
 //BA.debugLineNum = 17694721;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
RDebugUtils.currentLine=17694722;
 //BA.debugLineNum = 17694722;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "calc_vahed_ezafekari", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "calc_vahed_ezafekari", null));}
RDebugUtils.currentLine=17367040;
 //BA.debugLineNum = 17367040;BA.debugLine="Sub calc_vahed_ezafekari";
RDebugUtils.currentLine=17367042;
 //BA.debugLineNum = 17367042;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=17367045;
 //BA.debugLineNum = 17367045;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=17367048;
 //BA.debugLineNum = 17367048;BA.debugLine="vahed_ezafekari=((paye+sanavat)/220)*1.4";
_vahed_ezafekari = (int) ((((double)(Double.parseDouble(mostCurrent._paye))+_sanavat)/(double)220)*1.4);
RDebugUtils.currentLine=17367051;
 //BA.debugLineNum = 17367051;BA.debugLine="et_vahed_ezafekari.Tag=vahed_ezafekari";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_vahed_ezafekari));
RDebugUtils.currentLine=17367052;
 //BA.debugLineNum = 17367052;BA.debugLine="et_vahed_ezafekari.Text=myfunc.show_num_pool(vahe";
mostCurrent._et_vahed_ezafekari.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari)));
RDebugUtils.currentLine=17367055;
 //BA.debugLineNum = 17367055;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari_vij() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "calc_vahed_ezafekari_vij", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "calc_vahed_ezafekari_vij", null));}
RDebugUtils.currentLine=17432576;
 //BA.debugLineNum = 17432576;BA.debugLine="Sub calc_vahed_ezafekari_vij";
RDebugUtils.currentLine=17432578;
 //BA.debugLineNum = 17432578;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=17432581;
 //BA.debugLineNum = 17432581;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=17432584;
 //BA.debugLineNum = 17432584;BA.debugLine="vahed_ezafekari_vij=((paye+sanavat)/220)*1.8";
_vahed_ezafekari_vij = (int) ((((double)(Double.parseDouble(mostCurrent._paye))+_sanavat)/(double)220)*1.8);
RDebugUtils.currentLine=17432587;
 //BA.debugLineNum = 17432587;BA.debugLine="et_vahed_ezafekari_vij.Tag=vahed_ezafekari_vij";
mostCurrent._et_vahed_ezafekari_vij.setTag((Object)(_vahed_ezafekari_vij));
RDebugUtils.currentLine=17432588;
 //BA.debugLineNum = 17432588;BA.debugLine="et_vahed_ezafekari_vij.Text=myfunc.show_num_pool(";
mostCurrent._et_vahed_ezafekari_vij.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari_vij)));
RDebugUtils.currentLine=17432590;
 //BA.debugLineNum = 17432590;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=18022400;
 //BA.debugLineNum = 18022400;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=18022401;
 //BA.debugLineNum = 18022401;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=18022402;
 //BA.debugLineNum = 18022402;BA.debugLine="If(pan_mohasebat.Visible=True)Then";
if ((mostCurrent._pan_mohasebat.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=18022403;
 //BA.debugLineNum = 18022403;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
mostCurrent._pan_mohasebat.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=18022405;
 //BA.debugLineNum = 18022405;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
RDebugUtils.currentLine=18022408;
 //BA.debugLineNum = 18022408;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=18022410;
 //BA.debugLineNum = 18022410;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=18022412;
 //BA.debugLineNum = 18022412;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=17956864;
 //BA.debugLineNum = 17956864;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=17956865;
 //BA.debugLineNum = 17956865;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=17956866;
 //BA.debugLineNum = 17956866;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=17956867;
 //BA.debugLineNum = 17956867;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="hogog_activity";
RDebugUtils.currentLine=17891328;
 //BA.debugLineNum = 17891328;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=17891330;
 //BA.debugLineNum = 17891330;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=17825792;
 //BA.debugLineNum = 17825792;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=17825794;
 //BA.debugLineNum = 17825794;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_vahed_ezafekari_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_vahed_ezafekari_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=17498112;
 //BA.debugLineNum = 17498112;BA.debugLine="Private Sub et_vahed_ezafekari_TextChanged (Old As";
RDebugUtils.currentLine=17498113;
 //BA.debugLineNum = 17498113;BA.debugLine="et_vahed_ezafekari.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=17498114;
 //BA.debugLineNum = 17498114;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari);
RDebugUtils.currentLine=17498115;
 //BA.debugLineNum = 17498115;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_vij_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_vahed_ezafekari_vij_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_vahed_ezafekari_vij_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=17563648;
 //BA.debugLineNum = 17563648;BA.debugLine="Private Sub et_vahed_ezafekari_vij_TextChanged (Ol";
RDebugUtils.currentLine=17563649;
 //BA.debugLineNum = 17563649;BA.debugLine="et_vahed_ezafekari_vij.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari_vij.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=17563650;
 //BA.debugLineNum = 17563650;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari_vij);
RDebugUtils.currentLine=17563651;
 //BA.debugLineNum = 17563651;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_backto_hogog_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_backto_hogog_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_backto_hogog_click", null));}
RDebugUtils.currentLine=18612224;
 //BA.debugLineNum = 18612224;BA.debugLine="Private Sub lbl_backTo_hogog_Click";
RDebugUtils.currentLine=18612226;
 //BA.debugLineNum = 18612226;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
mostCurrent._pan_mohasebat.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=18612227;
 //BA.debugLineNum = 18612227;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_tatil_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_tatil_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_tatil_click", null));}
RDebugUtils.currentLine=19070976;
 //BA.debugLineNum = 19070976;BA.debugLine="Private Sub lbl_help_tatil_Click";
RDebugUtils.currentLine=19070978;
 //BA.debugLineNum = 19070978;BA.debugLine="myfunc.help_man(\"روزهای جمعه که برای آن روز دیگری";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"روزهای جمعه که برای آن روز دیگری را تعطیل نکنند، اضافه کاری فوق العاده محسوب و با ضریب 1.8 محاسبه می شود.");
RDebugUtils.currentLine=19070979;
 //BA.debugLineNum = 19070979;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_print_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_print_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_print_click", null));}
RDebugUtils.currentLine=19202048;
 //BA.debugLineNum = 19202048;BA.debugLine="Private Sub lbl_print_Click";
RDebugUtils.currentLine=19202050;
 //BA.debugLineNum = 19202050;BA.debugLine="printer.Initialize(\"\")";
mostCurrent._printer.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=19202053;
 //BA.debugLineNum = 19202053;BA.debugLine="printer.PrintWebView(\"job\",WebView2)";
mostCurrent._printer.PrintWebView("job",(android.webkit.WebView)(mostCurrent._webview2.getObject()));
RDebugUtils.currentLine=19202054;
 //BA.debugLineNum = 19202054;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_refresh_vahed_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_refresh_vahed_click", null));}
RDebugUtils.currentLine=18939904;
 //BA.debugLineNum = 18939904;BA.debugLine="Private Sub lbl_refresh_vahed_Click";
RDebugUtils.currentLine=18939905;
 //BA.debugLineNum = 18939905;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=18939906;
 //BA.debugLineNum = 18939906;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_vij_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_refresh_vahed_vij_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_refresh_vahed_vij_click", null));}
RDebugUtils.currentLine=19005440;
 //BA.debugLineNum = 19005440;BA.debugLine="Private Sub lbl_refresh_vahed_vij_Click";
RDebugUtils.currentLine=19005441;
 //BA.debugLineNum = 19005441;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
RDebugUtils.currentLine=19005442;
 //BA.debugLineNum = 19005442;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run_mohasebe_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", null));}
anywheresoftware.b4a.objects.collections.List _list_morakhasi = null;
RDebugUtils.currentLine=18153472;
 //BA.debugLineNum = 18153472;BA.debugLine="Private Sub lbl_run_mohasebe_Click";
RDebugUtils.currentLine=18153473;
 //BA.debugLineNum = 18153473;BA.debugLine="If(et_rozekari.Text=\"\")Then";
if (((mostCurrent._et_rozekari.getText()).equals(""))) { 
RDebugUtils.currentLine=18153474;
 //BA.debugLineNum = 18153474;BA.debugLine="et_rozekari.Text=0";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=18153477;
 //BA.debugLineNum = 18153477;BA.debugLine="roze_kari=et_rozekari.Text";
_roze_kari = (int)(Double.parseDouble(mostCurrent._et_rozekari.getText()));
RDebugUtils.currentLine=18153479;
 //BA.debugLineNum = 18153479;BA.debugLine="If(et_time_h.Text=\"\")Then";
if (((mostCurrent._et_time_h.getText()).equals(""))) { 
RDebugUtils.currentLine=18153480;
 //BA.debugLineNum = 18153480;BA.debugLine="et_time_h.Text=0";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=18153482;
 //BA.debugLineNum = 18153482;BA.debugLine="If(et_time_m.Text=\"\")Then";
if (((mostCurrent._et_time_m.getText()).equals(""))) { 
RDebugUtils.currentLine=18153483;
 //BA.debugLineNum = 18153483;BA.debugLine="et_time_m.Text=0";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=18153486;
 //BA.debugLineNum = 18153486;BA.debugLine="If(et_time_h_vij.Text=\"\")Then";
if (((mostCurrent._et_time_h_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=18153487;
 //BA.debugLineNum = 18153487;BA.debugLine="et_time_h_vij.Text=0";
mostCurrent._et_time_h_vij.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=18153489;
 //BA.debugLineNum = 18153489;BA.debugLine="If(et_time_m_vij.Text=\"\")Then";
if (((mostCurrent._et_time_m_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=18153490;
 //BA.debugLineNum = 18153490;BA.debugLine="et_time_m_vij.Text=0";
mostCurrent._et_time_m_vij.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=18153495;
 //BA.debugLineNum = 18153495;BA.debugLine="If(et_vahed_ezafekari.Text=\"\")Then";
if (((mostCurrent._et_vahed_ezafekari.getText()).equals(""))) { 
RDebugUtils.currentLine=18153496;
 //BA.debugLineNum = 18153496;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
 };
RDebugUtils.currentLine=18153498;
 //BA.debugLineNum = 18153498;BA.debugLine="If(et_vahed_ezafekari_vij.Text=\"\")Then";
if (((mostCurrent._et_vahed_ezafekari_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=18153499;
 //BA.debugLineNum = 18153499;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
 };
RDebugUtils.currentLine=18153503;
 //BA.debugLineNum = 18153503;BA.debugLine="If (roze_kari > 31 Or roze_kari < 0)Then";
if ((_roze_kari>31 || _roze_kari<0)) { 
RDebugUtils.currentLine=18153504;
 //BA.debugLineNum = 18153504;BA.debugLine="ToastMessageShow(\" تعداد روز کاری نادرست است\",Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" تعداد روز کاری نادرست است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=18153506;
 //BA.debugLineNum = 18153506;BA.debugLine="pan_mohasebat.Visible=True";
mostCurrent._pan_mohasebat.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=18153507;
 //BA.debugLineNum = 18153507;BA.debugLine="pan_mohasebat.SetLayoutAnimated(100,0,0,100%x,10";
mostCurrent._pan_mohasebat.SetLayoutAnimated((int) (100),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=18153508;
 //BA.debugLineNum = 18153508;BA.debugLine="mohasebe";
_mohasebe();
 };
RDebugUtils.currentLine=18153515;
 //BA.debugLineNum = 18153515;BA.debugLine="str1.Initialize";
mostCurrent._str1.Initialize();
RDebugUtils.currentLine=18153517;
 //BA.debugLineNum = 18153517;BA.debugLine="str1.Append(\"<!DOCTYPE html><html dir='rtl' lang=";
mostCurrent._str1.Append("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>");
RDebugUtils.currentLine=18153518;
 //BA.debugLineNum = 18153518;BA.debugLine="str1.Append(\"<style>table , td {border: 1px solid";
mostCurrent._str1.Append("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	summary {	font-weight: bold;	margin: -.5em -.5em 0;	padding: .5em;} details[open] {	padding: .5em;	}	details[open] summary {border-bottom: 1px solid #aaa;margin-bottom: .5em;}</style>");
RDebugUtils.currentLine=18153522;
 //BA.debugLineNum = 18153522;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=18153523;
 //BA.debugLineNum = 18153523;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+mostCurrent._sp_year.getSelectedItem()+"/"+mostCurrent._moon_num+"%';")));
RDebugUtils.currentLine=18153525;
 //BA.debugLineNum = 18153525;BA.debugLine="str1.Append(\"<h3>\").Append(\"گزارش \"& sp_moon.Sele";
mostCurrent._str1.Append("<h3>").Append("گزارش "+mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())).Append("</h3>");
RDebugUtils.currentLine=18153528;
 //BA.debugLineNum = 18153528;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f5";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5;'><details>");
RDebugUtils.currentLine=18153530;
 //BA.debugLineNum = 18153530;BA.debugLine="str1.Append(\"<summary><b> اضافه کاری های این ماه<";
mostCurrent._str1.Append("<summary><b> اضافه کاری های این ماه</b></summary>");
RDebugUtils.currentLine=18153531;
 //BA.debugLineNum = 18153531;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr style";
mostCurrent._str1.Append("<table style='width:100%;'><tr style='text-align: center;'>");
RDebugUtils.currentLine=18153532;
 //BA.debugLineNum = 18153532;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ</";
mostCurrent._str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td><br></tr>");
RDebugUtils.currentLine=18153534;
 //BA.debugLineNum = 18153534;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=18153535;
 //BA.debugLineNum = 18153535;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
mostCurrent._str1.Append("<tr style='text-align: center;'>");
RDebugUtils.currentLine=18153536;
 //BA.debugLineNum = 18153536;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
RDebugUtils.currentLine=18153537;
 //BA.debugLineNum = 18153537;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
RDebugUtils.currentLine=18153538;
 //BA.debugLineNum = 18153538;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
RDebugUtils.currentLine=18153540;
 //BA.debugLineNum = 18153540;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=18153541;
 //BA.debugLineNum = 18153541;BA.debugLine="str1.Append(myfunc.en2fa((dbCode.res.GetString(\"";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(((double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")))+((double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")))*24)))));
RDebugUtils.currentLine=18153542;
 //BA.debugLineNum = 18153542;BA.debugLine="str1.Append(\":\")";
mostCurrent._str1.Append(":");
RDebugUtils.currentLine=18153543;
 //BA.debugLineNum = 18153543;BA.debugLine="str1.Append(myfunc.en2fa(dbCode.res.GetString(\"e";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))).Append("</td>");
RDebugUtils.currentLine=18153545;
 //BA.debugLineNum = 18153545;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
 }
;
RDebugUtils.currentLine=18153548;
 //BA.debugLineNum = 18153548;BA.debugLine="str1.Append(\"</table>\")";
mostCurrent._str1.Append("</table>");
RDebugUtils.currentLine=18153549;
 //BA.debugLineNum = 18153549;BA.debugLine="str1.Append(\"مجموع ساعت اضافه کاری :<span style='";
mostCurrent._str1.Append("مجموع ساعت اضافه کاری :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h.getText())+" ساعت و"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m.getText())+"دقیقه </span><br></details></div><br> ");
RDebugUtils.currentLine=18153555;
 //BA.debugLineNum = 18153555;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+mostCurrent._sp_year.getSelectedItem()+"/"+mostCurrent._moon_num+"%';")));
RDebugUtils.currentLine=18153557;
 //BA.debugLineNum = 18153557;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f5";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5 ;'><details>");
RDebugUtils.currentLine=18153558;
 //BA.debugLineNum = 18153558;BA.debugLine="str1.Append(\"<summary><b> مرخصی های این ماه</b></";
mostCurrent._str1.Append("<summary><b> مرخصی های این ماه</b></summary>");
RDebugUtils.currentLine=18153559;
 //BA.debugLineNum = 18153559;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr style";
mostCurrent._str1.Append("<table style='width:100%;'><tr style='text-align: center;'>");
RDebugUtils.currentLine=18153560;
 //BA.debugLineNum = 18153560;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ</";
mostCurrent._str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b>زمان/روز</b></td><td><b> زمان/ساعت</b></td><br></tr>");
RDebugUtils.currentLine=18153562;
 //BA.debugLineNum = 18153562;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=18153563;
 //BA.debugLineNum = 18153563;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
mostCurrent._str1.Append("<tr style='text-align: center;'>");
RDebugUtils.currentLine=18153564;
 //BA.debugLineNum = 18153564;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
RDebugUtils.currentLine=18153565;
 //BA.debugLineNum = 18153565;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
RDebugUtils.currentLine=18153566;
 //BA.debugLineNum = 18153566;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
RDebugUtils.currentLine=18153567;
 //BA.debugLineNum = 18153567;BA.debugLine="str1.Append(\"<td>\").Append((myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append((mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")))).Append("</td>");
RDebugUtils.currentLine=18153568;
 //BA.debugLineNum = 18153568;BA.debugLine="str1.Append(\"<td>\").Append((myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append((mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")))+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))).Append("</td>");
RDebugUtils.currentLine=18153570;
 //BA.debugLineNum = 18153570;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
 }
;
RDebugUtils.currentLine=18153575;
 //BA.debugLineNum = 18153575;BA.debugLine="str1.Append(\"</table>\")";
mostCurrent._str1.Append("</table>");
RDebugUtils.currentLine=18153577;
 //BA.debugLineNum = 18153577;BA.debugLine="Dim list_morakhasi As List";
_list_morakhasi = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=18153578;
 //BA.debugLineNum = 18153578;BA.debugLine="list_morakhasi.Initialize";
_list_morakhasi.Initialize();
RDebugUtils.currentLine=18153580;
 //BA.debugLineNum = 18153580;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(sp_year.S";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num);
RDebugUtils.currentLine=18153582;
 //BA.debugLineNum = 18153582;BA.debugLine="str1.Append(\"مجموع مرخصی ها :<span style='color:#";
mostCurrent._str1.Append("مجموع مرخصی ها :<span style='color:#5E35B1;'><b> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (0))))+" روز و "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (1))))+" ساعت و "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (2))))+" دقیقه ");
RDebugUtils.currentLine=18153584;
 //BA.debugLineNum = 18153584;BA.debugLine="str1.Append(\"</b></span><br></details></div><br>\"";
mostCurrent._str1.Append("</b></span><br></details></div><br>");
RDebugUtils.currentLine=18153590;
 //BA.debugLineNum = 18153590;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f5";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5 ;' ><details open>");
RDebugUtils.currentLine=18153591;
 //BA.debugLineNum = 18153591;BA.debugLine="str1.Append(\"<summary><b>محاسبه حقوق</b></summary";
mostCurrent._str1.Append("<summary><b>محاسبه حقوق</b></summary>");
RDebugUtils.currentLine=18153593;
 //BA.debugLineNum = 18153593;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr>\")";
mostCurrent._str1.Append("<table style='width:100%;'><tr>");
RDebugUtils.currentLine=18153594;
 //BA.debugLineNum = 18153594;BA.debugLine="str1.Append(\"<td><div style='text-align: center;c";
mostCurrent._str1.Append("<td><div style='text-align: center;color:#661400;'><b> مزایا</b></div></td>");
RDebugUtils.currentLine=18153595;
 //BA.debugLineNum = 18153595;BA.debugLine="str1.Append(\"<td><div style='text-align: center;c";
mostCurrent._str1.Append("<td><div style='text-align: center;color:#661400;'><b>کسورات</b></div></td> </tr>");
RDebugUtils.currentLine=18153596;
 //BA.debugLineNum = 18153596;BA.debugLine="str1.Append(\"<tr style='vertical-align: text-top;";
mostCurrent._str1.Append("<tr style='vertical-align: text-top;'><td>");
RDebugUtils.currentLine=18153597;
 //BA.debugLineNum = 18153597;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(0)&\" برای \"&myfunc.";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (0)))+" برای "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_roze_kari))+" روز کاری : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_paye_end))+"</span><br>");
RDebugUtils.currentLine=18153598;
 //BA.debugLineNum = 18153598;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(2)&\" : <span style=";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (2)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maskan_end))+"</span><br>");
RDebugUtils.currentLine=18153599;
 //BA.debugLineNum = 18153599;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(3)&\" : <span style";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (3)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bon_end))+"</span><br>");
RDebugUtils.currentLine=18153600;
 //BA.debugLineNum = 18153600;BA.debugLine="If(olad_end<>0)Then";
if ((_olad_end!=0)) { 
RDebugUtils.currentLine=18153601;
 //BA.debugLineNum = 18153601;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(4)&\"  :<span style";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (4)))+"  :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad_end))+"</span><br>");
 };
RDebugUtils.currentLine=18153603;
 //BA.debugLineNum = 18153603;BA.debugLine="If(sanavat_end<>0)Then";
if ((_sanavat_end!=0)) { 
RDebugUtils.currentLine=18153604;
 //BA.debugLineNum = 18153604;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(1)&\"  : <span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (1)))+"  : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat_end))+"</span><br>");
 };
RDebugUtils.currentLine=18153606;
 //BA.debugLineNum = 18153606;BA.debugLine="If(fani_end<>0)Then";
if ((_fani_end!=0)) { 
RDebugUtils.currentLine=18153607;
 //BA.debugLineNum = 18153607;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(5)&\" : <span style";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (5)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_fani_end))+"</span><br>");
 };
RDebugUtils.currentLine=18153609;
 //BA.debugLineNum = 18153609;BA.debugLine="If(masoliat_end<>0)Then";
if ((_masoliat_end!=0)) { 
RDebugUtils.currentLine=18153610;
 //BA.debugLineNum = 18153610;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(6)&\" : <span style";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (6)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_masoliat_end))+"</span><br>");
 };
RDebugUtils.currentLine=18153612;
 //BA.debugLineNum = 18153612;BA.debugLine="If(sarparasti_end<>0)Then";
if ((_sarparasti_end!=0)) { 
RDebugUtils.currentLine=18153613;
 //BA.debugLineNum = 18153613;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(7)&\" : <span styl";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (7)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sarparasti_end))+"</span><br>");
 };
RDebugUtils.currentLine=18153615;
 //BA.debugLineNum = 18153615;BA.debugLine="If(shift_end<>0)Then";
if ((_shift_end!=0)) { 
RDebugUtils.currentLine=18153616;
 //BA.debugLineNum = 18153616;BA.debugLine="str1.Append(\" حق شیفت \"&myfunc.en2fa(shift)&\" در";
mostCurrent._str1.Append(" حق شیفت "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_shift))+" درصد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_shift_end))+"</span><br>");
 };
RDebugUtils.currentLine=18153618;
 //BA.debugLineNum = 18153618;BA.debugLine="If(mazaya_end<>0)Then";
if ((_mazaya_end!=0)) { 
RDebugUtils.currentLine=18153619;
 //BA.debugLineNum = 18153619;BA.debugLine="str1.Append(\"  \"&ls_onvanHa.Get(10)&\" : <span st";
mostCurrent._str1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (10)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya_end))+"</span><br>");
 };
RDebugUtils.currentLine=18153625;
 //BA.debugLineNum = 18153625;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=18153626;
 //BA.debugLineNum = 18153626;BA.debugLine="str1.Append(\"اضافه کاری عادی\").Append(\"<br>\")";
mostCurrent._str1.Append("اضافه کاری عادی").Append("<br>");
RDebugUtils.currentLine=18153628;
 //BA.debugLineNum = 18153628;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B1";
mostCurrent._str1.Append(" ساعات : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h.getText())+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m.getText())+"</span><br>");
RDebugUtils.currentLine=18153630;
 //BA.debugLineNum = 18153630;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5E";
mostCurrent._str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_vahed_ezafekari))+"</span><br>");
RDebugUtils.currentLine=18153636;
 //BA.debugLineNum = 18153636;BA.debugLine="If(ezafekari_end_vij<>0)Then";
if ((_ezafekari_end_vij!=0)) { 
RDebugUtils.currentLine=18153637;
 //BA.debugLineNum = 18153637;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=18153639;
 //BA.debugLineNum = 18153639;BA.debugLine="str1.Append(\"اضافه کاری <span style='color:#ff4d0";
mostCurrent._str1.Append("اضافه کاری <span style='color:#ff4d00;'>"+"فوق العاده"+"</span>").Append("<br>");
RDebugUtils.currentLine=18153641;
 //BA.debugLineNum = 18153641;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B1;";
mostCurrent._str1.Append(" ساعات : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h_vij.getText())+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m_vij.getText())+"</span><br>");
RDebugUtils.currentLine=18153644;
 //BA.debugLineNum = 18153644;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5E3";
mostCurrent._str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_vahed_ezafekari_vij))+"</span><br>");
 };
RDebugUtils.currentLine=18153648;
 //BA.debugLineNum = 18153648;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=18153649;
 //BA.debugLineNum = 18153649;BA.debugLine="str1.Append(\"مجموع اضافه کاری : <span style='colo";
mostCurrent._str1.Append("مجموع اضافه کاری : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool((int) (_ezafekari_end+_ezafekari_end_vij)))+"</span><br></td>");
RDebugUtils.currentLine=18153652;
 //BA.debugLineNum = 18153652;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=18153653;
 //BA.debugLineNum = 18153653;BA.debugLine="str1.Append(\"بیمه تامین اجتماعی \"&myfunc.en2fa(sh";
mostCurrent._str1.Append("بیمه تامین اجتماعی "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_tamin))+" درصد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_tamin_end))+"</span><br>");
RDebugUtils.currentLine=18153655;
 //BA.debugLineNum = 18153655;BA.debugLine="If(bime_takmil<>0)Then";
if ((_bime_takmil!=0)) { 
RDebugUtils.currentLine=18153656;
 //BA.debugLineNum = 18153656;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(9)&\" :<span style=";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (9)))+" :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_takmil))+"</span><br>");
 };
RDebugUtils.currentLine=18153659;
 //BA.debugLineNum = 18153659;BA.debugLine="If(maliat_end<>0)Then";
if ((_maliat_end!=0)) { 
RDebugUtils.currentLine=18153660;
 //BA.debugLineNum = 18153660;BA.debugLine="str1.Append(\" مالیات : <span style='color:#5E35B";
mostCurrent._str1.Append(" مالیات : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maliat_end))+"</span><br>");
 };
RDebugUtils.currentLine=18153662;
 //BA.debugLineNum = 18153662;BA.debugLine="If(ksorat<>0)Then";
if ((_ksorat!=0)) { 
RDebugUtils.currentLine=18153663;
 //BA.debugLineNum = 18153663;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(11)&\" : <span sty";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (11)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat))+"</span></td>");
 };
RDebugUtils.currentLine=18153666;
 //BA.debugLineNum = 18153666;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
RDebugUtils.currentLine=18153668;
 //BA.debugLineNum = 18153668;BA.debugLine="str1.Append(\"<tr><td>\")";
mostCurrent._str1.Append("<tr><td>");
RDebugUtils.currentLine=18153669;
 //BA.debugLineNum = 18153669;BA.debugLine="str1.Append(\"جمع مزایا :  <span style='color:#5E3";
mostCurrent._str1.Append("جمع مزایا :  <span style='color:#5E35B1;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_nakhales))+"</b></span>");
RDebugUtils.currentLine=18153670;
 //BA.debugLineNum = 18153670;BA.debugLine="str1.Append(\"</td><td>\")";
mostCurrent._str1.Append("</td><td>");
RDebugUtils.currentLine=18153672;
 //BA.debugLineNum = 18153672;BA.debugLine="str1.Append(\"جمع کسورات :  <span style='color:#5E";
mostCurrent._str1.Append("جمع کسورات :  <span style='color:#5E35B1;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_jame_kosorat))+"</b></span>");
RDebugUtils.currentLine=18153673;
 //BA.debugLineNum = 18153673;BA.debugLine="str1.Append(\"</td></tr></table><br>\")";
mostCurrent._str1.Append("</td></tr></table><br>");
RDebugUtils.currentLine=18153675;
 //BA.debugLineNum = 18153675;BA.debugLine="str1.Append(\" دریافتی خالص :  <span style='color:";
mostCurrent._str1.Append(" دریافتی خالص :  <span style='color:#388E3C;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_khales))+" </b></span></b>");
RDebugUtils.currentLine=18153676;
 //BA.debugLineNum = 18153676;BA.debugLine="str1.Append(\"<span style='font-size: 11px;'> توما";
mostCurrent._str1.Append("<span style='font-size: 11px;'> تومان </span>");
RDebugUtils.currentLine=18153678;
 //BA.debugLineNum = 18153678;BA.debugLine="str1.Append(\"<br></details></div>\")";
mostCurrent._str1.Append("<br></details></div>");
RDebugUtils.currentLine=18153680;
 //BA.debugLineNum = 18153680;BA.debugLine="str1.Append(\"<footer style=' text-align: center;";
mostCurrent._str1.Append("<footer style=' text-align: center; '><h6> اپلیکیشن اضافه کاری من </h6></footer>");
RDebugUtils.currentLine=18153682;
 //BA.debugLineNum = 18153682;BA.debugLine="str1.Append(\"</body></html>\")";
mostCurrent._str1.Append("</body></html>");
RDebugUtils.currentLine=18153684;
 //BA.debugLineNum = 18153684;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=18153685;
 //BA.debugLineNum = 18153685;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=18153690;
 //BA.debugLineNum = 18153690;BA.debugLine="WebView2.LoadHtml(str1.ToString)";
mostCurrent._webview2.LoadHtml(mostCurrent._str1.ToString());
RDebugUtils.currentLine=18153691;
 //BA.debugLineNum = 18153691;BA.debugLine="End Sub";
return "";
}
public static String  _mohasebe() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mohasebe", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "mohasebe", null));}
int _nak_mal = 0;
RDebugUtils.currentLine=18219008;
 //BA.debugLineNum = 18219008;BA.debugLine="Sub mohasebe";
RDebugUtils.currentLine=18219012;
 //BA.debugLineNum = 18219012;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=18219015;
 //BA.debugLineNum = 18219015;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=18219022;
 //BA.debugLineNum = 18219022;BA.debugLine="If (roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=18219023;
 //BA.debugLineNum = 18219023;BA.debugLine="maskan_end=(maskan/30)*roze_kari";
_maskan_end = (int) ((_maskan/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=18219025;
 //BA.debugLineNum = 18219025;BA.debugLine="maskan_end=maskan";
_maskan_end = _maskan;
 };
RDebugUtils.currentLine=18219030;
 //BA.debugLineNum = 18219030;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=18219031;
 //BA.debugLineNum = 18219031;BA.debugLine="bon_end=(bon/30)*roze_kari";
_bon_end = (int) ((_bon/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=18219033;
 //BA.debugLineNum = 18219033;BA.debugLine="bon_end=bon";
_bon_end = _bon;
 };
RDebugUtils.currentLine=18219038;
 //BA.debugLineNum = 18219038;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=18219039;
 //BA.debugLineNum = 18219039;BA.debugLine="olad_end=(olad/30)*roze_kari";
_olad_end = (int) ((_olad/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=18219041;
 //BA.debugLineNum = 18219041;BA.debugLine="olad_end=olad";
_olad_end = _olad;
 };
RDebugUtils.currentLine=18219046;
 //BA.debugLineNum = 18219046;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=18219047;
 //BA.debugLineNum = 18219047;BA.debugLine="fani_end=(fani/30)*roze_kari";
_fani_end = (int) ((_fani/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=18219049;
 //BA.debugLineNum = 18219049;BA.debugLine="fani_end=fani";
_fani_end = _fani;
 };
RDebugUtils.currentLine=18219053;
 //BA.debugLineNum = 18219053;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=18219054;
 //BA.debugLineNum = 18219054;BA.debugLine="masoliat_end=(masoliat/30)*roze_kari";
_masoliat_end = (int) ((_masoliat/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=18219056;
 //BA.debugLineNum = 18219056;BA.debugLine="masoliat_end=masoliat";
_masoliat_end = _masoliat;
 };
RDebugUtils.currentLine=18219060;
 //BA.debugLineNum = 18219060;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=18219061;
 //BA.debugLineNum = 18219061;BA.debugLine="sarparasti_end=(sarparasti/30)*roze_kari";
_sarparasti_end = (int) ((_sarparasti/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=18219063;
 //BA.debugLineNum = 18219063;BA.debugLine="sarparasti_end=sarparasti";
_sarparasti_end = _sarparasti;
 };
RDebugUtils.currentLine=18219067;
 //BA.debugLineNum = 18219067;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=18219068;
 //BA.debugLineNum = 18219068;BA.debugLine="mazaya_end=(mazaya/30)*roze_kari";
_mazaya_end = (int) ((_mazaya/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=18219070;
 //BA.debugLineNum = 18219070;BA.debugLine="mazaya_end=mazaya";
_mazaya_end = _mazaya;
 };
RDebugUtils.currentLine=18219074;
 //BA.debugLineNum = 18219074;BA.debugLine="shift_end=((paye_end+sanavat_end)*shift)/100";
_shift_end = (int) (((_paye_end+_sanavat_end)*_shift)/(double)100);
RDebugUtils.currentLine=18219077;
 //BA.debugLineNum = 18219077;BA.debugLine="vahed_ezafekari=et_vahed_ezafekari.Tag";
_vahed_ezafekari = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari.getTag()));
RDebugUtils.currentLine=18219078;
 //BA.debugLineNum = 18219078;BA.debugLine="ezafekari_end=vahed_ezafekari*(et_time_h.Text+(et";
_ezafekari_end = (int) (_vahed_ezafekari*((double)(Double.parseDouble(mostCurrent._et_time_h.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m.getText()))/(double)60)));
RDebugUtils.currentLine=18219082;
 //BA.debugLineNum = 18219082;BA.debugLine="vahed_ezafekari_vij=et_vahed_ezafekari_vij.Tag";
_vahed_ezafekari_vij = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari_vij.getTag()));
RDebugUtils.currentLine=18219083;
 //BA.debugLineNum = 18219083;BA.debugLine="ezafekari_end_vij=vahed_ezafekari_vij*(et_time_h_";
_ezafekari_end_vij = (int) (_vahed_ezafekari_vij*((double)(Double.parseDouble(mostCurrent._et_time_h_vij.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m_vij.getText()))/(double)60)));
RDebugUtils.currentLine=18219089;
 //BA.debugLineNum = 18219089;BA.debugLine="hogog_nakhales=paye_end+ezafekari_end+ezafekari_e";
_hogog_nakhales = (int) (_paye_end+_ezafekari_end+_ezafekari_end_vij+_maskan_end+_bon_end+_olad_end+_fani_end+_masoliat_end+_sarparasti_end+_sanavat_end+_mazaya_end+_shift_end);
RDebugUtils.currentLine=18219092;
 //BA.debugLineNum = 18219092;BA.debugLine="bime_tamin_end=(hogog_nakhales-olad_end)*0.07";
_bime_tamin_end = (int) ((_hogog_nakhales-_olad_end)*0.07);
RDebugUtils.currentLine=18219094;
 //BA.debugLineNum = 18219094;BA.debugLine="Dim nak_mal As Int";
_nak_mal = 0;
RDebugUtils.currentLine=18219095;
 //BA.debugLineNum = 18219095;BA.debugLine="nak_mal=hogog_nakhales-((bime_tamin_end*2)/7)  ''";
_nak_mal = (int) (_hogog_nakhales-((_bime_tamin_end*2)/(double)7));
RDebugUtils.currentLine=18219099;
 //BA.debugLineNum = 18219099;BA.debugLine="maliat_end=mohasebe_maliat(nak_mal,sp_year.Select";
_maliat_end = _mohasebe_maliat(_nak_mal,(int)(Double.parseDouble(mostCurrent._sp_year.getSelectedItem())));
RDebugUtils.currentLine=18219103;
 //BA.debugLineNum = 18219103;BA.debugLine="jame_kosorat=bime_tamin_end+maliat_end+bime_takmi";
_jame_kosorat = (int) (_bime_tamin_end+_maliat_end+_bime_takmil+_ksorat);
RDebugUtils.currentLine=18219105;
 //BA.debugLineNum = 18219105;BA.debugLine="hogog_khales=hogog_nakhales-jame_kosorat";
_hogog_khales = (int) (_hogog_nakhales-_jame_kosorat);
RDebugUtils.currentLine=18219107;
 //BA.debugLineNum = 18219107;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_gozaresh_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_gozaresh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_gozaresh_click", null));}
RDebugUtils.currentLine=18481152;
 //BA.debugLineNum = 18481152;BA.debugLine="Private Sub lbl_save_gozaresh_Click";
RDebugUtils.currentLine=18481153;
 //BA.debugLineNum = 18481153;BA.debugLine="et_name_gozaresh.Text=sp_moon.SelectedItem&\" \"&sp";
mostCurrent._et_name_gozaresh.setText(BA.ObjectToCharSequence(mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._sp_year.getSelectedItem()));
RDebugUtils.currentLine=18481154;
 //BA.debugLineNum = 18481154;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=18481155;
 //BA.debugLineNum = 18481155;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_gozaresh_end_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_gozaresh_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_gozaresh_end_click", null));}
RDebugUtils.currentLine=18743296;
 //BA.debugLineNum = 18743296;BA.debugLine="Private Sub lbl_save_gozaresh_end_Click";
RDebugUtils.currentLine=18743297;
 //BA.debugLineNum = 18743297;BA.debugLine="save_gozaresh";
_save_gozaresh();
RDebugUtils.currentLine=18743298;
 //BA.debugLineNum = 18743298;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=18743299;
 //BA.debugLineNum = 18743299;BA.debugLine="End Sub";
return "";
}
public static String  _save_gozaresh() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "save_gozaresh", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "save_gozaresh", null));}
boolean _chek = false;
anywheresoftware.b4a.objects.collections.List _alist = null;
RDebugUtils.currentLine=18546688;
 //BA.debugLineNum = 18546688;BA.debugLine="Sub save_gozaresh";
RDebugUtils.currentLine=18546691;
 //BA.debugLineNum = 18546691;BA.debugLine="Dim chek As Boolean";
_chek = false;
RDebugUtils.currentLine=18546692;
 //BA.debugLineNum = 18546692;BA.debugLine="chek=myfunc.check_karid";
_chek = mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=18546693;
 //BA.debugLineNum = 18546693;BA.debugLine="Dim alist As List";
_alist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=18546694;
 //BA.debugLineNum = 18546694;BA.debugLine="alist.Initialize";
_alist.Initialize();
RDebugUtils.currentLine=18546696;
 //BA.debugLineNum = 18546696;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(Main.persianDa";
_alist = mostCurrent._myfunc._num_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())),BA.NumberToString(01));
RDebugUtils.currentLine=18546699;
 //BA.debugLineNum = 18546699;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=18546700;
 //BA.debugLineNum = 18546700;BA.debugLine="If(alist.Get(2)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (2))))<5)) { 
RDebugUtils.currentLine=18546701;
 //BA.debugLineNum = 18546701;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDa";
mostCurrent._dbcode._add_gozaresh /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),mostCurrent._et_name_gozaresh.getText(),mostCurrent._et_tozih_gozaresh.getText(),mostCurrent._str1.ToString(),BA.NumberToString(_hogog_nakhales),BA.NumberToString(_hogog_khales));
RDebugUtils.currentLine=18546702;
 //BA.debugLineNum = 18546702;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("گزارش ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=18546704;
 //BA.debugLineNum = 18546704;BA.debugLine="Main.buy_index=1";
mostCurrent._main._buy_index /*int*/  = (int) (1);
RDebugUtils.currentLine=18546705;
 //BA.debugLineNum = 18546705;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=18546706;
 //BA.debugLineNum = 18546706;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 }else {
RDebugUtils.currentLine=18546709;
 //BA.debugLineNum = 18546709;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDat";
mostCurrent._dbcode._add_gozaresh /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),mostCurrent._et_name_gozaresh.getText(),mostCurrent._et_tozih_gozaresh.getText(),mostCurrent._str1.ToString(),BA.NumberToString(_hogog_nakhales),BA.NumberToString(_hogog_khales));
RDebugUtils.currentLine=18546710;
 //BA.debugLineNum = 18546710;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("گزارش ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=18546715;
 //BA.debugLineNum = 18546715;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_share_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_share_click", null));}
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
RDebugUtils.currentLine=19136512;
 //BA.debugLineNum = 19136512;BA.debugLine="Private Sub lbl_share_Click";
RDebugUtils.currentLine=19136513;
 //BA.debugLineNum = 19136513;BA.debugLine="Dim FileName As String =Main.current_gozaresh_id&";
_filename = BA.NumberToString(mostCurrent._main._current_gozaresh_id /*int*/ )+".html";
RDebugUtils.currentLine=19136516;
 //BA.debugLineNum = 19136516;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
anywheresoftware.b4a.keywords.Common.File.WriteString(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename,mostCurrent._str1.ToString());
RDebugUtils.currentLine=19136518;
 //BA.debugLineNum = 19136518;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=19136519;
 //BA.debugLineNum = 19136519;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
RDebugUtils.currentLine=19136520;
 //BA.debugLineNum = 19136520;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
RDebugUtils.currentLine=19136521;
 //BA.debugLineNum = 19136521;BA.debugLine="email.Body = \" گزارش حقوق \"&str1.ToString&CRLF&\"ا";
_email.Body = " گزارش حقوق "+mostCurrent._str1.ToString()+anywheresoftware.b4a.keywords.Common.CRLF+"اپلیکیشن اضافه کاری من"+anywheresoftware.b4a.keywords.Common.CRLF+"دانلود از بازار";
RDebugUtils.currentLine=19136522;
 //BA.debugLineNum = 19136522;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (null,_filename));
RDebugUtils.currentLine=19136524;
 //BA.debugLineNum = 19136524;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
RDebugUtils.currentLine=19136525;
 //BA.debugLineNum = 19136525;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
RDebugUtils.currentLine=19136526;
 //BA.debugLineNum = 19136526;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
RDebugUtils.currentLine=19136527;
 //BA.debugLineNum = 19136527;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=18284544;
 //BA.debugLineNum = 18284544;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
RDebugUtils.currentLine=18284545;
 //BA.debugLineNum = 18284545;BA.debugLine="Dim all_maliat As Int=0";
_all_maliat = (int) (0);
RDebugUtils.currentLine=18284546;
 //BA.debugLineNum = 18284546;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
RDebugUtils.currentLine=18284547;
 //BA.debugLineNum = 18284547;BA.debugLine="Dim state2 As Int=0";
_state2 = (int) (0);
RDebugUtils.currentLine=18284548;
 //BA.debugLineNum = 18284548;BA.debugLine="Dim state3 As Int=0";
_state3 = (int) (0);
RDebugUtils.currentLine=18284549;
 //BA.debugLineNum = 18284549;BA.debugLine="Dim state4 As Int=0";
_state4 = (int) (0);
RDebugUtils.currentLine=18284550;
 //BA.debugLineNum = 18284550;BA.debugLine="Dim state5 As Int=0";
_state5 = (int) (0);
RDebugUtils.currentLine=18284551;
 //BA.debugLineNum = 18284551;BA.debugLine="Dim state6 As Int=0";
_state6 = (int) (0);
RDebugUtils.currentLine=18284553;
 //BA.debugLineNum = 18284553;BA.debugLine="If (year=1399)Then";
if ((_year==1399)) { 
RDebugUtils.currentLine=18284554;
 //BA.debugLineNum = 18284554;BA.debugLine="If(hogog>3000001 And hogog<7500001)Then	  ''----";
if ((_hogog>3000001 && _hogog<7500001)) { 
RDebugUtils.currentLine=18284555;
 //BA.debugLineNum = 18284555;BA.debugLine="state1=(hogog-3000000)*0.1";
_state1 = (int) ((_hogog-3000000)*0.1);
 };
RDebugUtils.currentLine=18284557;
 //BA.debugLineNum = 18284557;BA.debugLine="If(hogog>7500001 And hogog<10500001)Then	  ''---";
if ((_hogog>7500001 && _hogog<10500001)) { 
RDebugUtils.currentLine=18284558;
 //BA.debugLineNum = 18284558;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=18284559;
 //BA.debugLineNum = 18284559;BA.debugLine="state2=(hogog-7500000)*0.15";
_state2 = (int) ((_hogog-7500000)*0.15);
 };
RDebugUtils.currentLine=18284561;
 //BA.debugLineNum = 18284561;BA.debugLine="If(hogog>10500001 And hogog<15000001)Then	  ''--";
if ((_hogog>10500001 && _hogog<15000001)) { 
RDebugUtils.currentLine=18284562;
 //BA.debugLineNum = 18284562;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=18284563;
 //BA.debugLineNum = 18284563;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=18284564;
 //BA.debugLineNum = 18284564;BA.debugLine="state3=(hogog-10500000)*0.2";
_state3 = (int) ((_hogog-10500000)*0.2);
 };
RDebugUtils.currentLine=18284566;
 //BA.debugLineNum = 18284566;BA.debugLine="If(hogog>15000001)Then	  ''-----stat4";
if ((_hogog>15000001)) { 
RDebugUtils.currentLine=18284567;
 //BA.debugLineNum = 18284567;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=18284568;
 //BA.debugLineNum = 18284568;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=18284569;
 //BA.debugLineNum = 18284569;BA.debugLine="state3=(4500000)*0.2";
_state3 = (int) ((4500000)*0.2);
RDebugUtils.currentLine=18284570;
 //BA.debugLineNum = 18284570;BA.debugLine="state4=(hogog-15000001)*0.25";
_state4 = (int) ((_hogog-15000001)*0.25);
 };
 };
RDebugUtils.currentLine=18284574;
 //BA.debugLineNum = 18284574;BA.debugLine="If (year=1400)Then";
if ((_year==1400)) { 
RDebugUtils.currentLine=18284575;
 //BA.debugLineNum = 18284575;BA.debugLine="If(hogog>4000001 And hogog<8000001)Then	  ''----";
if ((_hogog>4000001 && _hogog<8000001)) { 
RDebugUtils.currentLine=18284576;
 //BA.debugLineNum = 18284576;BA.debugLine="state1=(hogog-4000000)*0.1";
_state1 = (int) ((_hogog-4000000)*0.1);
 };
RDebugUtils.currentLine=18284578;
 //BA.debugLineNum = 18284578;BA.debugLine="If(hogog>8000001 And hogog<12000001)Then	  ''---";
if ((_hogog>8000001 && _hogog<12000001)) { 
RDebugUtils.currentLine=18284579;
 //BA.debugLineNum = 18284579;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=18284580;
 //BA.debugLineNum = 18284580;BA.debugLine="state2=(hogog-8000000)*0.15";
_state2 = (int) ((_hogog-8000000)*0.15);
 };
RDebugUtils.currentLine=18284582;
 //BA.debugLineNum = 18284582;BA.debugLine="If(hogog>12000001 And hogog<18000001)Then	  ''--";
if ((_hogog>12000001 && _hogog<18000001)) { 
RDebugUtils.currentLine=18284583;
 //BA.debugLineNum = 18284583;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=18284584;
 //BA.debugLineNum = 18284584;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=18284585;
 //BA.debugLineNum = 18284585;BA.debugLine="state3=(hogog-12000000)*0.2";
_state3 = (int) ((_hogog-12000000)*0.2);
 };
RDebugUtils.currentLine=18284587;
 //BA.debugLineNum = 18284587;BA.debugLine="If(hogog>18000001 And hogog<24000001)Then	  ''--";
if ((_hogog>18000001 && _hogog<24000001)) { 
RDebugUtils.currentLine=18284588;
 //BA.debugLineNum = 18284588;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=18284589;
 //BA.debugLineNum = 18284589;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=18284590;
 //BA.debugLineNum = 18284590;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=18284591;
 //BA.debugLineNum = 18284591;BA.debugLine="state4=(hogog-18000000)*0.25";
_state4 = (int) ((_hogog-18000000)*0.25);
 };
RDebugUtils.currentLine=18284593;
 //BA.debugLineNum = 18284593;BA.debugLine="If(hogog>24000001 And hogog<32000001)Then	  ''--";
if ((_hogog>24000001 && _hogog<32000001)) { 
RDebugUtils.currentLine=18284594;
 //BA.debugLineNum = 18284594;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=18284595;
 //BA.debugLineNum = 18284595;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=18284596;
 //BA.debugLineNum = 18284596;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=18284597;
 //BA.debugLineNum = 18284597;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=18284598;
 //BA.debugLineNum = 18284598;BA.debugLine="state5=(hogog-24000000)*0.3";
_state5 = (int) ((_hogog-24000000)*0.3);
 };
RDebugUtils.currentLine=18284600;
 //BA.debugLineNum = 18284600;BA.debugLine="If(hogog>32000001)Then	  ''-----stat4";
if ((_hogog>32000001)) { 
RDebugUtils.currentLine=18284601;
 //BA.debugLineNum = 18284601;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=18284602;
 //BA.debugLineNum = 18284602;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=18284603;
 //BA.debugLineNum = 18284603;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=18284604;
 //BA.debugLineNum = 18284604;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=18284605;
 //BA.debugLineNum = 18284605;BA.debugLine="state5=(6000000)*0.3";
_state5 = (int) ((6000000)*0.3);
RDebugUtils.currentLine=18284606;
 //BA.debugLineNum = 18284606;BA.debugLine="state6=(hogog-32000000)*0.35";
_state6 = (int) ((_hogog-32000000)*0.35);
 };
 };
RDebugUtils.currentLine=18284610;
 //BA.debugLineNum = 18284610;BA.debugLine="If (year=1401)Then";
if ((_year==1401)) { 
RDebugUtils.currentLine=18284611;
 //BA.debugLineNum = 18284611;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
if ((_hogog>5600001 && _hogog<12500001)) { 
RDebugUtils.currentLine=18284612;
 //BA.debugLineNum = 18284612;BA.debugLine="state1=(hogog-5600000)*0.1";
_state1 = (int) ((_hogog-5600000)*0.1);
 };
RDebugUtils.currentLine=18284614;
 //BA.debugLineNum = 18284614;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
if ((_hogog>12500001 && _hogog<20830001)) { 
RDebugUtils.currentLine=18284615;
 //BA.debugLineNum = 18284615;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=18284616;
 //BA.debugLineNum = 18284616;BA.debugLine="state2=(hogog-12500000)*0.15";
_state2 = (int) ((_hogog-12500000)*0.15);
 };
RDebugUtils.currentLine=18284618;
 //BA.debugLineNum = 18284618;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
if ((_hogog>20830001 && _hogog<29160001)) { 
RDebugUtils.currentLine=18284619;
 //BA.debugLineNum = 18284619;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=18284620;
 //BA.debugLineNum = 18284620;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=18284621;
 //BA.debugLineNum = 18284621;BA.debugLine="state3=(hogog-20830000)*0.2";
_state3 = (int) ((_hogog-20830000)*0.2);
 };
RDebugUtils.currentLine=18284624;
 //BA.debugLineNum = 18284624;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
if ((_hogog>29160001)) { 
RDebugUtils.currentLine=18284625;
 //BA.debugLineNum = 18284625;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=18284626;
 //BA.debugLineNum = 18284626;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=18284627;
 //BA.debugLineNum = 18284627;BA.debugLine="state3=(8330000)*0.2";
_state3 = (int) ((8330000)*0.2);
RDebugUtils.currentLine=18284629;
 //BA.debugLineNum = 18284629;BA.debugLine="state4=(hogog-29160000)*0.3";
_state4 = (int) ((_hogog-29160000)*0.3);
 };
 };
RDebugUtils.currentLine=18284634;
 //BA.debugLineNum = 18284634;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
_all_maliat = (int) (_state1+_state2+_state3+_state4+_state5+_state6);
RDebugUtils.currentLine=18284635;
 //BA.debugLineNum = 18284635;BA.debugLine="Return all_maliat";
if (true) return _all_maliat;
RDebugUtils.currentLine=18284637;
 //BA.debugLineNum = 18284637;BA.debugLine="End Sub";
return 0;
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=18874368;
 //BA.debugLineNum = 18874368;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=18874369;
 //BA.debugLineNum = 18874369;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=18874370;
 //BA.debugLineNum = 18874370;BA.debugLine="End Sub";
return "";
}
public static String  _pan_mohasebat_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_mohasebat_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_mohasebat_click", null));}
RDebugUtils.currentLine=18677760;
 //BA.debugLineNum = 18677760;BA.debugLine="Private Sub pan_mohasebat_Click";
RDebugUtils.currentLine=18677762;
 //BA.debugLineNum = 18677762;BA.debugLine="End Sub";
return "";
}
public static String  _panel7_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel7_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel7_click", null));}
RDebugUtils.currentLine=18808832;
 //BA.debugLineNum = 18808832;BA.debugLine="Private Sub Panel7_Click";
RDebugUtils.currentLine=18808834;
 //BA.debugLineNum = 18808834;BA.debugLine="End Sub";
return "";
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_moon_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_moon_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=18350080;
 //BA.debugLineNum = 18350080;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=18350081;
 //BA.debugLineNum = 18350081;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=18350083;
 //BA.debugLineNum = 18350083;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=18415616;
 //BA.debugLineNum = 18415616;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=18415617;
 //BA.debugLineNum = 18415617;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=18415618;
 //BA.debugLineNum = 18415618;BA.debugLine="End Sub";
return "";
}
public static String  _time_page_load_tick() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time_page_load_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "time_page_load_tick", null));}
RDebugUtils.currentLine=17629184;
 //BA.debugLineNum = 17629184;BA.debugLine="Sub time_page_load_Tick";
RDebugUtils.currentLine=17629185;
 //BA.debugLineNum = 17629185;BA.debugLine="pan_load.Visible=False";
mostCurrent._pan_load.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=17629186;
 //BA.debugLineNum = 17629186;BA.debugLine="B4XLoadingIndicator1.Hide";
mostCurrent._b4xloadingindicator1._hide /*String*/ (null);
RDebugUtils.currentLine=17629187;
 //BA.debugLineNum = 17629187;BA.debugLine="Main.time_page_load.Enabled=False";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=17629188;
 //BA.debugLineNum = 17629188;BA.debugLine="End Sub";
return "";
}
}