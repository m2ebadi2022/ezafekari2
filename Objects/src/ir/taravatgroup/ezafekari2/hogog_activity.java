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
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.drawable.BitmapDrawable _imm = null;
RDebugUtils.currentLine=27197440;
 //BA.debugLineNum = 27197440;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=27197442;
 //BA.debugLineNum = 27197442;BA.debugLine="Activity.LoadLayout(\"hogog_layout\")";
mostCurrent._activity.LoadLayout("hogog_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=27197443;
 //BA.debugLineNum = 27197443;BA.debugLine="scv_hogog.Panel.LoadLayout(\"item_hogog\")";
mostCurrent._scv_hogog.getPanel().LoadLayout("item_hogog",mostCurrent.activityBA);
RDebugUtils.currentLine=27197445;
 //BA.debugLineNum = 27197445;BA.debugLine="get_data_hogogi";
_get_data_hogogi();
RDebugUtils.currentLine=27197447;
 //BA.debugLineNum = 27197447;BA.debugLine="Main.time_page_load.Initialize(\"time_page_load\",1";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .Initialize(processBA,"time_page_load",(long) (1500));
RDebugUtils.currentLine=27197448;
 //BA.debugLineNum = 27197448;BA.debugLine="Main.time_page_load.Enabled=True";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=27197449;
 //BA.debugLineNum = 27197449;BA.debugLine="B4XLoadingIndicator1.Show";
mostCurrent._b4xloadingindicator1._show /*String*/ (null);
RDebugUtils.currentLine=27197451;
 //BA.debugLineNum = 27197451;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
RDebugUtils.currentLine=27197452;
 //BA.debugLineNum = 27197452;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
RDebugUtils.currentLine=27197453;
 //BA.debugLineNum = 27197453;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
RDebugUtils.currentLine=27197454;
 //BA.debugLineNum = 27197454;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
RDebugUtils.currentLine=27197456;
 //BA.debugLineNum = 27197456;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=27197458;
 //BA.debugLineNum = 27197458;BA.debugLine="Dim imm As BitmapDrawable";
_imm = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=27197459;
 //BA.debugLineNum = 27197459;BA.debugLine="imm.Initialize(LoadBitmap(File.DirAssets,\"textBox";
_imm.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"textBox.png").getObject()));
RDebugUtils.currentLine=27197460;
 //BA.debugLineNum = 27197460;BA.debugLine="imm.Gravity=Gravity.FILL";
_imm.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=27197461;
 //BA.debugLineNum = 27197461;BA.debugLine="sp_year.Background=imm";
mostCurrent._sp_year.setBackground((android.graphics.drawable.Drawable)(_imm.getObject()));
RDebugUtils.currentLine=27197462;
 //BA.debugLineNum = 27197462;BA.debugLine="sp_moon.Background=imm";
mostCurrent._sp_moon.setBackground((android.graphics.drawable.Drawable)(_imm.getObject()));
RDebugUtils.currentLine=27197465;
 //BA.debugLineNum = 27197465;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))-1));
RDebugUtils.currentLine=27197466;
 //BA.debugLineNum = 27197466;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=27197470;
 //BA.debugLineNum = 27197470;BA.debugLine="pan_hed_hogog.Color=Main.color4";
mostCurrent._pan_hed_hogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=27197471;
 //BA.debugLineNum = 27197471;BA.debugLine="pan_main_hed_hogog.Color=Main.color4";
mostCurrent._pan_main_hed_hogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=27197472;
 //BA.debugLineNum = 27197472;BA.debugLine="pan_hed_gozaresh.Color=Main.color4";
mostCurrent._pan_hed_gozaresh.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=27197473;
 //BA.debugLineNum = 27197473;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=27197476;
 //BA.debugLineNum = 27197476;BA.debugLine="WebView1.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview1.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=27197477;
 //BA.debugLineNum = 27197477;BA.debugLine="WebView2.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview2.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=27197480;
 //BA.debugLineNum = 27197480;BA.debugLine="ls_onvanHa.Initialize";
mostCurrent._ls_onvanha.Initialize();
RDebugUtils.currentLine=27197481;
 //BA.debugLineNum = 27197481;BA.debugLine="ls_onvanHa=dbCode.read_onvan_db";
mostCurrent._ls_onvanha = mostCurrent._dbcode._read_onvan_db /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=27197484;
 //BA.debugLineNum = 27197484;BA.debugLine="str_web1.Initialize";
mostCurrent._str_web1.Initialize();
RDebugUtils.currentLine=27197485;
 //BA.debugLineNum = 27197485;BA.debugLine="str_web1.Append(\"<html dir='rtl'><meta charset='U";
mostCurrent._str_web1.Append("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>");
RDebugUtils.currentLine=27197486;
 //BA.debugLineNum = 27197486;BA.debugLine="str_web1.Append(\"<h4 align='center' >اطلاعات حقوق";
mostCurrent._str_web1.Append("<h4 align='center' >اطلاعات حقوق برای ۳۰ روز</h4>");
RDebugUtils.currentLine=27197487;
 //BA.debugLineNum = 27197487;BA.debugLine="str_web1.Append(\"<h6 align='center'>واحد : تومان<";
mostCurrent._str_web1.Append("<h6 align='center'>واحد : تومان</h6>");
RDebugUtils.currentLine=27197488;
 //BA.debugLineNum = 27197488;BA.debugLine="str_web1.Append(\"<table style='width:100%'><tr>\")";
mostCurrent._str_web1.Append("<table style='width:100%'><tr>");
RDebugUtils.currentLine=27197489;
 //BA.debugLineNum = 27197489;BA.debugLine="str_web1.Append(\"<td>\"&\"\"&ls_onvanHa.Get(0)&\" : \"";
mostCurrent._str_web1.Append("<td>"+""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (0)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool((int)(Double.parseDouble(mostCurrent._paye))))+"<br>");
RDebugUtils.currentLine=27197490;
 //BA.debugLineNum = 27197490;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(2)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (2)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maskan))+"<br>");
RDebugUtils.currentLine=27197491;
 //BA.debugLineNum = 27197491;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(3)&\" : \"&myfun";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (3)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bon))+"<br>");
RDebugUtils.currentLine=27197492;
 //BA.debugLineNum = 27197492;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(4)&\"  : \"&myfun";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (4)))+"  : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad))+"<br>");
RDebugUtils.currentLine=27197493;
 //BA.debugLineNum = 27197493;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(5)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (5)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_fani))+"<br>");
RDebugUtils.currentLine=27197494;
 //BA.debugLineNum = 27197494;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(6)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (6)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_masoliat))+"<br>");
RDebugUtils.currentLine=27197495;
 //BA.debugLineNum = 27197495;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(7)&\"  : \"&myfu";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (7)))+"  : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sarparasti))+"<br></td>");
RDebugUtils.currentLine=27197499;
 //BA.debugLineNum = 27197499;BA.debugLine="str_web1.Append(\"<td>\"&\" \"&ls_onvanHa.Get(1)&\" :";
mostCurrent._str_web1.Append("<td>"+" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (1)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat))+"<br>");
RDebugUtils.currentLine=27197500;
 //BA.debugLineNum = 27197500;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(8)&\" : \"&myfun";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (8)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_shift))+"<br>");
RDebugUtils.currentLine=27197501;
 //BA.debugLineNum = 27197501;BA.debugLine="str_web1.Append(\"بیمه تامین اجتماعی : %\"&myfunc.e";
mostCurrent._str_web1.Append("بیمه تامین اجتماعی : %"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_bime_tamin))+"<br>");
RDebugUtils.currentLine=27197502;
 //BA.debugLineNum = 27197502;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(9)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (9)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_takmil))+"<br>");
RDebugUtils.currentLine=27197503;
 //BA.debugLineNum = 27197503;BA.debugLine="str_web1.Append(\" مالیات : مطابق قانون کار<br>\")";
mostCurrent._str_web1.Append(" مالیات : مطابق قانون کار<br>");
RDebugUtils.currentLine=27197504;
 //BA.debugLineNum = 27197504;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(10)&\" : \"&myf";
mostCurrent._str_web1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (10)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya))+"<br>");
RDebugUtils.currentLine=27197505;
 //BA.debugLineNum = 27197505;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(11)&\" : \"&myf";
mostCurrent._str_web1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (11)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat))+"</td>");
RDebugUtils.currentLine=27197506;
 //BA.debugLineNum = 27197506;BA.debugLine="str_web1.Append(\"</tr></table>\")";
mostCurrent._str_web1.Append("</tr></table>");
RDebugUtils.currentLine=27197507;
 //BA.debugLineNum = 27197507;BA.debugLine="str_web1.Append(\"</body></html>\")";
mostCurrent._str_web1.Append("</body></html>");
RDebugUtils.currentLine=27197509;
 //BA.debugLineNum = 27197509;BA.debugLine="WebView1.LoadHtml(str_web1)";
mostCurrent._webview1.LoadHtml(BA.ObjectToString(mostCurrent._str_web1));
RDebugUtils.currentLine=27197513;
 //BA.debugLineNum = 27197513;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=27197514;
 //BA.debugLineNum = 27197514;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
RDebugUtils.currentLine=27197515;
 //BA.debugLineNum = 27197515;BA.debugLine="End Sub";
return "";
}
public static String  _get_data_hogogi() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_data_hogogi", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_data_hogogi", null));}
RDebugUtils.currentLine=27983872;
 //BA.debugLineNum = 27983872;BA.debugLine="Sub get_data_hogogi";
RDebugUtils.currentLine=27983874;
 //BA.debugLineNum = 27983874;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=27983875;
 //BA.debugLineNum = 27983875;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=27983877;
 //BA.debugLineNum = 27983877;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=27983878;
 //BA.debugLineNum = 27983878;BA.debugLine="paye=dbCode.res.GetString(\"value\")";
mostCurrent._paye = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value");
RDebugUtils.currentLine=27983880;
 //BA.debugLineNum = 27983880;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (1));
RDebugUtils.currentLine=27983881;
 //BA.debugLineNum = 27983881;BA.debugLine="maskan=dbCode.res.GetString(\"value\")";
_maskan = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=27983883;
 //BA.debugLineNum = 27983883;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (3));
RDebugUtils.currentLine=27983884;
 //BA.debugLineNum = 27983884;BA.debugLine="olad=dbCode.res.GetString(\"value\")";
_olad = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=27983886;
 //BA.debugLineNum = 27983886;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (4));
RDebugUtils.currentLine=27983887;
 //BA.debugLineNum = 27983887;BA.debugLine="fani=dbCode.res.GetString(\"value\")";
_fani = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=27983889;
 //BA.debugLineNum = 27983889;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (5));
RDebugUtils.currentLine=27983890;
 //BA.debugLineNum = 27983890;BA.debugLine="masoliat=dbCode.res.GetString(\"value\")";
_masoliat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=27983892;
 //BA.debugLineNum = 27983892;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (2));
RDebugUtils.currentLine=27983893;
 //BA.debugLineNum = 27983893;BA.debugLine="bon=dbCode.res.GetString(\"value\")";
_bon = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=27983895;
 //BA.debugLineNum = 27983895;BA.debugLine="dbCode.res.Position=6 ''--------bime_tamin------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (6));
RDebugUtils.currentLine=27983896;
 //BA.debugLineNum = 27983896;BA.debugLine="bime_tamin=dbCode.res.GetString(\"value\")";
_bime_tamin = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=27983898;
 //BA.debugLineNum = 27983898;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (11));
RDebugUtils.currentLine=27983899;
 //BA.debugLineNum = 27983899;BA.debugLine="bime_takmil=dbCode.res.GetString(\"value\")";
_bime_takmil = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=27983907;
 //BA.debugLineNum = 27983907;BA.debugLine="dbCode.res.Position=13 ''--------hag shift------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (13));
RDebugUtils.currentLine=27983908;
 //BA.debugLineNum = 27983908;BA.debugLine="shift=dbCode.res.GetString(\"value\")";
_shift = (double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=27983910;
 //BA.debugLineNum = 27983910;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (14));
RDebugUtils.currentLine=27983911;
 //BA.debugLineNum = 27983911;BA.debugLine="sanavat=dbCode.res.GetString(\"value\")";
_sanavat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=27983913;
 //BA.debugLineNum = 27983913;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (15));
RDebugUtils.currentLine=27983914;
 //BA.debugLineNum = 27983914;BA.debugLine="sarparasti=dbCode.res.GetString(\"value\")";
_sarparasti = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=27983916;
 //BA.debugLineNum = 27983916;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (16));
RDebugUtils.currentLine=27983917;
 //BA.debugLineNum = 27983917;BA.debugLine="mazaya=dbCode.res.GetString(\"value\")";
_mazaya = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=27983919;
 //BA.debugLineNum = 27983919;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (19));
RDebugUtils.currentLine=27983920;
 //BA.debugLineNum = 27983920;BA.debugLine="ksorat=dbCode.res.GetString(\"value\")";
_ksorat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=27983930;
 //BA.debugLineNum = 27983930;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=27983931;
 //BA.debugLineNum = 27983931;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=27983935;
 //BA.debugLineNum = 27983935;BA.debugLine="End Sub";
return "";
}
public static String  _et_time_indb() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_time_indb", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_time_indb", null));}
anywheresoftware.b4a.objects.collections.List _list_ezafekari1 = null;
anywheresoftware.b4a.objects.collections.List _list_ezafekari2 = null;
RDebugUtils.currentLine=27656192;
 //BA.debugLineNum = 27656192;BA.debugLine="Sub et_time_inDB";
RDebugUtils.currentLine=27656195;
 //BA.debugLineNum = 27656195;BA.debugLine="Select sp_moon.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_moon.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11))) {
case 0: {
RDebugUtils.currentLine=27656197;
 //BA.debugLineNum = 27656197;BA.debugLine="moon_num=\"01\"";
mostCurrent._moon_num = "01";
 break; }
case 1: {
RDebugUtils.currentLine=27656199;
 //BA.debugLineNum = 27656199;BA.debugLine="moon_num=\"02\"";
mostCurrent._moon_num = "02";
 break; }
case 2: {
RDebugUtils.currentLine=27656201;
 //BA.debugLineNum = 27656201;BA.debugLine="moon_num=\"03\"";
mostCurrent._moon_num = "03";
 break; }
case 3: {
RDebugUtils.currentLine=27656203;
 //BA.debugLineNum = 27656203;BA.debugLine="moon_num=\"04\"";
mostCurrent._moon_num = "04";
 break; }
case 4: {
RDebugUtils.currentLine=27656205;
 //BA.debugLineNum = 27656205;BA.debugLine="moon_num=\"05\"";
mostCurrent._moon_num = "05";
 break; }
case 5: {
RDebugUtils.currentLine=27656207;
 //BA.debugLineNum = 27656207;BA.debugLine="moon_num=\"06\"";
mostCurrent._moon_num = "06";
 break; }
case 6: {
RDebugUtils.currentLine=27656209;
 //BA.debugLineNum = 27656209;BA.debugLine="moon_num=\"07\"";
mostCurrent._moon_num = "07";
 break; }
case 7: {
RDebugUtils.currentLine=27656211;
 //BA.debugLineNum = 27656211;BA.debugLine="moon_num=\"08\"";
mostCurrent._moon_num = "08";
 break; }
case 8: {
RDebugUtils.currentLine=27656213;
 //BA.debugLineNum = 27656213;BA.debugLine="moon_num=\"09\"";
mostCurrent._moon_num = "09";
 break; }
case 9: {
RDebugUtils.currentLine=27656215;
 //BA.debugLineNum = 27656215;BA.debugLine="moon_num=\"10\"";
mostCurrent._moon_num = "10";
 break; }
case 10: {
RDebugUtils.currentLine=27656217;
 //BA.debugLineNum = 27656217;BA.debugLine="moon_num=\"11\"";
mostCurrent._moon_num = "11";
 break; }
case 11: {
RDebugUtils.currentLine=27656219;
 //BA.debugLineNum = 27656219;BA.debugLine="moon_num=\"12\"";
mostCurrent._moon_num = "12";
 break; }
}
;
RDebugUtils.currentLine=27656224;
 //BA.debugLineNum = 27656224;BA.debugLine="Dim list_ezafekari1 As List";
_list_ezafekari1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=27656225;
 //BA.debugLineNum = 27656225;BA.debugLine="list_ezafekari1.Initialize";
_list_ezafekari1.Initialize();
RDebugUtils.currentLine=27656226;
 //BA.debugLineNum = 27656226;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_mah(sp_year.";
_list_ezafekari1 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num,(int) (2));
RDebugUtils.currentLine=27656227;
 //BA.debugLineNum = 27656227;BA.debugLine="et_time_h.Text=list_ezafekari1.Get(0)";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (0))));
RDebugUtils.currentLine=27656228;
 //BA.debugLineNum = 27656228;BA.debugLine="et_time_m.Text=list_ezafekari1.Get(1)";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (1))));
RDebugUtils.currentLine=27656231;
 //BA.debugLineNum = 27656231;BA.debugLine="Dim list_ezafekari2 As List";
_list_ezafekari2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=27656232;
 //BA.debugLineNum = 27656232;BA.debugLine="list_ezafekari2.Initialize";
_list_ezafekari2.Initialize();
RDebugUtils.currentLine=27656233;
 //BA.debugLineNum = 27656233;BA.debugLine="list_ezafekari2=dbCode.all_ezafekari_mah(sp_year.";
_list_ezafekari2 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num,(int) (3));
RDebugUtils.currentLine=27656234;
 //BA.debugLineNum = 27656234;BA.debugLine="et_time_h_vij.Text=list_ezafekari2.Get(0)";
mostCurrent._et_time_h_vij.setText(BA.ObjectToCharSequence(_list_ezafekari2.Get((int) (0))));
RDebugUtils.currentLine=27656235;
 //BA.debugLineNum = 27656235;BA.debugLine="et_time_m_vij.Text=list_ezafekari2.Get(1)";
mostCurrent._et_time_m_vij.setText(BA.ObjectToCharSequence(_list_ezafekari2.Get((int) (1))));
RDebugUtils.currentLine=27656239;
 //BA.debugLineNum = 27656239;BA.debugLine="If(moon_num<7)Then";
if (((double)(Double.parseDouble(mostCurrent._moon_num))<7)) { 
RDebugUtils.currentLine=27656240;
 //BA.debugLineNum = 27656240;BA.debugLine="roze_kari=31";
_roze_kari = (int) (31);
 }else {
RDebugUtils.currentLine=27656242;
 //BA.debugLineNum = 27656242;BA.debugLine="roze_kari=30";
_roze_kari = (int) (30);
 };
RDebugUtils.currentLine=27656244;
 //BA.debugLineNum = 27656244;BA.debugLine="et_rozekari.Text=roze_kari";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(_roze_kari));
RDebugUtils.currentLine=27656245;
 //BA.debugLineNum = 27656245;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(int _num) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_num_pool", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_num_pool", new Object[] {_num}));}
RDebugUtils.currentLine=27590656;
 //BA.debugLineNum = 27590656;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=27590657;
 //BA.debugLineNum = 27590657;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
RDebugUtils.currentLine=27590658;
 //BA.debugLineNum = 27590658;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "calc_vahed_ezafekari", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "calc_vahed_ezafekari", null));}
RDebugUtils.currentLine=27262976;
 //BA.debugLineNum = 27262976;BA.debugLine="Sub calc_vahed_ezafekari";
RDebugUtils.currentLine=27262978;
 //BA.debugLineNum = 27262978;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=27262981;
 //BA.debugLineNum = 27262981;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=27262984;
 //BA.debugLineNum = 27262984;BA.debugLine="vahed_ezafekari=((paye+sanavat)/220)*1.4";
_vahed_ezafekari = (int) ((((double)(Double.parseDouble(mostCurrent._paye))+_sanavat)/(double)220)*1.4);
RDebugUtils.currentLine=27262987;
 //BA.debugLineNum = 27262987;BA.debugLine="et_vahed_ezafekari.Tag=vahed_ezafekari";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_vahed_ezafekari));
RDebugUtils.currentLine=27262988;
 //BA.debugLineNum = 27262988;BA.debugLine="et_vahed_ezafekari.Text=myfunc.show_num_pool(vahe";
mostCurrent._et_vahed_ezafekari.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari)));
RDebugUtils.currentLine=27262991;
 //BA.debugLineNum = 27262991;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari_vij() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "calc_vahed_ezafekari_vij", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "calc_vahed_ezafekari_vij", null));}
RDebugUtils.currentLine=27328512;
 //BA.debugLineNum = 27328512;BA.debugLine="Sub calc_vahed_ezafekari_vij";
RDebugUtils.currentLine=27328514;
 //BA.debugLineNum = 27328514;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=27328517;
 //BA.debugLineNum = 27328517;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=27328520;
 //BA.debugLineNum = 27328520;BA.debugLine="vahed_ezafekari_vij=((paye+sanavat)/220)*1.8";
_vahed_ezafekari_vij = (int) ((((double)(Double.parseDouble(mostCurrent._paye))+_sanavat)/(double)220)*1.8);
RDebugUtils.currentLine=27328523;
 //BA.debugLineNum = 27328523;BA.debugLine="et_vahed_ezafekari_vij.Tag=vahed_ezafekari_vij";
mostCurrent._et_vahed_ezafekari_vij.setTag((Object)(_vahed_ezafekari_vij));
RDebugUtils.currentLine=27328524;
 //BA.debugLineNum = 27328524;BA.debugLine="et_vahed_ezafekari_vij.Text=myfunc.show_num_pool(";
mostCurrent._et_vahed_ezafekari_vij.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari_vij)));
RDebugUtils.currentLine=27328526;
 //BA.debugLineNum = 27328526;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=27918336;
 //BA.debugLineNum = 27918336;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=27918337;
 //BA.debugLineNum = 27918337;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=27918338;
 //BA.debugLineNum = 27918338;BA.debugLine="If(pan_mohasebat.Visible=True)Then";
if ((mostCurrent._pan_mohasebat.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=27918339;
 //BA.debugLineNum = 27918339;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
mostCurrent._pan_mohasebat.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=27918341;
 //BA.debugLineNum = 27918341;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
RDebugUtils.currentLine=27918344;
 //BA.debugLineNum = 27918344;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=27918346;
 //BA.debugLineNum = 27918346;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=27918348;
 //BA.debugLineNum = 27918348;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=27852800;
 //BA.debugLineNum = 27852800;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=27852801;
 //BA.debugLineNum = 27852801;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=27852802;
 //BA.debugLineNum = 27852802;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=27852803;
 //BA.debugLineNum = 27852803;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="hogog_activity";
RDebugUtils.currentLine=27787264;
 //BA.debugLineNum = 27787264;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=27787266;
 //BA.debugLineNum = 27787266;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=27721728;
 //BA.debugLineNum = 27721728;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=27721730;
 //BA.debugLineNum = 27721730;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_vahed_ezafekari_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_vahed_ezafekari_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=27394048;
 //BA.debugLineNum = 27394048;BA.debugLine="Private Sub et_vahed_ezafekari_TextChanged (Old As";
RDebugUtils.currentLine=27394049;
 //BA.debugLineNum = 27394049;BA.debugLine="et_vahed_ezafekari.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=27394050;
 //BA.debugLineNum = 27394050;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari);
RDebugUtils.currentLine=27394051;
 //BA.debugLineNum = 27394051;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_vij_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_vahed_ezafekari_vij_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_vahed_ezafekari_vij_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=27459584;
 //BA.debugLineNum = 27459584;BA.debugLine="Private Sub et_vahed_ezafekari_vij_TextChanged (Ol";
RDebugUtils.currentLine=27459585;
 //BA.debugLineNum = 27459585;BA.debugLine="et_vahed_ezafekari_vij.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari_vij.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=27459586;
 //BA.debugLineNum = 27459586;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari_vij);
RDebugUtils.currentLine=27459587;
 //BA.debugLineNum = 27459587;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_backto_hogog_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_backto_hogog_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_backto_hogog_click", null));}
RDebugUtils.currentLine=28508160;
 //BA.debugLineNum = 28508160;BA.debugLine="Private Sub lbl_backTo_hogog_Click";
RDebugUtils.currentLine=28508162;
 //BA.debugLineNum = 28508162;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
mostCurrent._pan_mohasebat.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=28508163;
 //BA.debugLineNum = 28508163;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_tatil_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_tatil_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_tatil_click", null));}
RDebugUtils.currentLine=28966912;
 //BA.debugLineNum = 28966912;BA.debugLine="Private Sub lbl_help_tatil_Click";
RDebugUtils.currentLine=28966914;
 //BA.debugLineNum = 28966914;BA.debugLine="myfunc.help_man(\"راهنما\",\"روزهای جمعه که برای آن";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","روزهای جمعه که برای آن روز دیگری را تعطیل نکنند، اضافه کاری فوق العاده محسوب و با ضریب 1.8 محاسبه می شود.");
RDebugUtils.currentLine=28966915;
 //BA.debugLineNum = 28966915;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_print_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_print_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_print_click", null));}
RDebugUtils.currentLine=29097984;
 //BA.debugLineNum = 29097984;BA.debugLine="Private Sub lbl_print_Click";
RDebugUtils.currentLine=29097986;
 //BA.debugLineNum = 29097986;BA.debugLine="printer.Initialize(\"\")";
mostCurrent._printer.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=29097989;
 //BA.debugLineNum = 29097989;BA.debugLine="printer.PrintWebView(\"job\",WebView2)";
mostCurrent._printer.PrintWebView("job",(android.webkit.WebView)(mostCurrent._webview2.getObject()));
RDebugUtils.currentLine=29097990;
 //BA.debugLineNum = 29097990;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_refresh_vahed_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_refresh_vahed_click", null));}
RDebugUtils.currentLine=28835840;
 //BA.debugLineNum = 28835840;BA.debugLine="Private Sub lbl_refresh_vahed_Click";
RDebugUtils.currentLine=28835841;
 //BA.debugLineNum = 28835841;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=28835842;
 //BA.debugLineNum = 28835842;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_vij_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_refresh_vahed_vij_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_refresh_vahed_vij_click", null));}
RDebugUtils.currentLine=28901376;
 //BA.debugLineNum = 28901376;BA.debugLine="Private Sub lbl_refresh_vahed_vij_Click";
RDebugUtils.currentLine=28901377;
 //BA.debugLineNum = 28901377;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
RDebugUtils.currentLine=28901378;
 //BA.debugLineNum = 28901378;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run_mohasebe_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", null));}
anywheresoftware.b4a.objects.collections.List _list_morakhasi = null;
RDebugUtils.currentLine=28049408;
 //BA.debugLineNum = 28049408;BA.debugLine="Private Sub lbl_run_mohasebe_Click";
RDebugUtils.currentLine=28049409;
 //BA.debugLineNum = 28049409;BA.debugLine="If(et_rozekari.Text=\"\")Then";
if (((mostCurrent._et_rozekari.getText()).equals(""))) { 
RDebugUtils.currentLine=28049410;
 //BA.debugLineNum = 28049410;BA.debugLine="et_rozekari.Text=0";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=28049413;
 //BA.debugLineNum = 28049413;BA.debugLine="roze_kari=et_rozekari.Text";
_roze_kari = (int)(Double.parseDouble(mostCurrent._et_rozekari.getText()));
RDebugUtils.currentLine=28049415;
 //BA.debugLineNum = 28049415;BA.debugLine="If(et_time_h.Text=\"\")Then";
if (((mostCurrent._et_time_h.getText()).equals(""))) { 
RDebugUtils.currentLine=28049416;
 //BA.debugLineNum = 28049416;BA.debugLine="et_time_h.Text=0";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=28049418;
 //BA.debugLineNum = 28049418;BA.debugLine="If(et_time_m.Text=\"\")Then";
if (((mostCurrent._et_time_m.getText()).equals(""))) { 
RDebugUtils.currentLine=28049419;
 //BA.debugLineNum = 28049419;BA.debugLine="et_time_m.Text=0";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=28049422;
 //BA.debugLineNum = 28049422;BA.debugLine="If(et_time_h_vij.Text=\"\")Then";
if (((mostCurrent._et_time_h_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=28049423;
 //BA.debugLineNum = 28049423;BA.debugLine="et_time_h_vij.Text=0";
mostCurrent._et_time_h_vij.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=28049425;
 //BA.debugLineNum = 28049425;BA.debugLine="If(et_time_m_vij.Text=\"\")Then";
if (((mostCurrent._et_time_m_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=28049426;
 //BA.debugLineNum = 28049426;BA.debugLine="et_time_m_vij.Text=0";
mostCurrent._et_time_m_vij.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=28049431;
 //BA.debugLineNum = 28049431;BA.debugLine="If(et_vahed_ezafekari.Text=\"\")Then";
if (((mostCurrent._et_vahed_ezafekari.getText()).equals(""))) { 
RDebugUtils.currentLine=28049432;
 //BA.debugLineNum = 28049432;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
 };
RDebugUtils.currentLine=28049434;
 //BA.debugLineNum = 28049434;BA.debugLine="If(et_vahed_ezafekari_vij.Text=\"\")Then";
if (((mostCurrent._et_vahed_ezafekari_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=28049435;
 //BA.debugLineNum = 28049435;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
 };
RDebugUtils.currentLine=28049439;
 //BA.debugLineNum = 28049439;BA.debugLine="If (roze_kari > 31 Or roze_kari < 0)Then";
if ((_roze_kari>31 || _roze_kari<0)) { 
RDebugUtils.currentLine=28049440;
 //BA.debugLineNum = 28049440;BA.debugLine="ToastMessageShow(\" تعداد روز کاری نادرست است\",Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" تعداد روز کاری نادرست است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=28049442;
 //BA.debugLineNum = 28049442;BA.debugLine="pan_mohasebat.Visible=True";
mostCurrent._pan_mohasebat.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=28049443;
 //BA.debugLineNum = 28049443;BA.debugLine="pan_mohasebat.SetLayoutAnimated(100,0,0,100%x,10";
mostCurrent._pan_mohasebat.SetLayoutAnimated((int) (100),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=28049444;
 //BA.debugLineNum = 28049444;BA.debugLine="mohasebe";
_mohasebe();
 };
RDebugUtils.currentLine=28049451;
 //BA.debugLineNum = 28049451;BA.debugLine="str1.Initialize";
mostCurrent._str1.Initialize();
RDebugUtils.currentLine=28049453;
 //BA.debugLineNum = 28049453;BA.debugLine="str1.Append(\"<!DOCTYPE html><html dir='rtl' lang=";
mostCurrent._str1.Append("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>");
RDebugUtils.currentLine=28049454;
 //BA.debugLineNum = 28049454;BA.debugLine="str1.Append(\"<style>table , td {border: 1px solid";
mostCurrent._str1.Append("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	summary {	font-weight: bold;	margin: -.5em -.5em 0;	padding: .5em;} details[open] {	padding: .5em;	}	details[open] summary {border-bottom: 1px solid #aaa;margin-bottom: .5em;}</style>");
RDebugUtils.currentLine=28049458;
 //BA.debugLineNum = 28049458;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=28049459;
 //BA.debugLineNum = 28049459;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+mostCurrent._sp_year.getSelectedItem()+"/"+mostCurrent._moon_num+"%';")));
RDebugUtils.currentLine=28049465;
 //BA.debugLineNum = 28049465;BA.debugLine="str1.Append(\"<h3>\").Append(\"گزارش \"& sp_moon.Sele";
mostCurrent._str1.Append("<h3>").Append("گزارش "+mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())).Append("</h3>");
RDebugUtils.currentLine=28049466;
 //BA.debugLineNum = 28049466;BA.debugLine="str1.Append(\"نام کاربر :\").Append(\"<span> \"&Main.";
mostCurrent._str1.Append("نام کاربر :").Append("<span> "+mostCurrent._main._user_namefamili /*String*/ +"</span>").Append("<br>");
RDebugUtils.currentLine=28049468;
 //BA.debugLineNum = 28049468;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f5";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5;'><details>");
RDebugUtils.currentLine=28049470;
 //BA.debugLineNum = 28049470;BA.debugLine="str1.Append(\"<summary><b> اضافه کاری های این ماه<";
mostCurrent._str1.Append("<summary><b> اضافه کاری های این ماه</b></summary>");
RDebugUtils.currentLine=28049471;
 //BA.debugLineNum = 28049471;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr style";
mostCurrent._str1.Append("<table style='width:100%;'><tr style='text-align: center;'>");
RDebugUtils.currentLine=28049472;
 //BA.debugLineNum = 28049472;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ</";
mostCurrent._str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td><br></tr>");
RDebugUtils.currentLine=28049474;
 //BA.debugLineNum = 28049474;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=28049475;
 //BA.debugLineNum = 28049475;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
mostCurrent._str1.Append("<tr style='text-align: center;'>");
RDebugUtils.currentLine=28049476;
 //BA.debugLineNum = 28049476;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
RDebugUtils.currentLine=28049477;
 //BA.debugLineNum = 28049477;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
RDebugUtils.currentLine=28049478;
 //BA.debugLineNum = 28049478;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
RDebugUtils.currentLine=28049480;
 //BA.debugLineNum = 28049480;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=28049481;
 //BA.debugLineNum = 28049481;BA.debugLine="str1.Append(myfunc.en2fa((dbCode.res.GetString(\"";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(((double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")))+((double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")))*24)))));
RDebugUtils.currentLine=28049482;
 //BA.debugLineNum = 28049482;BA.debugLine="str1.Append(\":\")";
mostCurrent._str1.Append(":");
RDebugUtils.currentLine=28049483;
 //BA.debugLineNum = 28049483;BA.debugLine="str1.Append(myfunc.en2fa(dbCode.res.GetString(\"e";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))).Append("</td>");
RDebugUtils.currentLine=28049485;
 //BA.debugLineNum = 28049485;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
 }
;
RDebugUtils.currentLine=28049488;
 //BA.debugLineNum = 28049488;BA.debugLine="str1.Append(\"</table>\")";
mostCurrent._str1.Append("</table>");
RDebugUtils.currentLine=28049489;
 //BA.debugLineNum = 28049489;BA.debugLine="str1.Append(\"مجموع ساعت اضافه کاری :<span style='";
mostCurrent._str1.Append("مجموع ساعت اضافه کاری :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h.getText())+" ساعت و"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m.getText())+"دقیقه </span><br></details></div><br> ");
RDebugUtils.currentLine=28049495;
 //BA.debugLineNum = 28049495;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+mostCurrent._sp_year.getSelectedItem()+"/"+mostCurrent._moon_num+"%';")));
RDebugUtils.currentLine=28049497;
 //BA.debugLineNum = 28049497;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f5";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5 ;'><details>");
RDebugUtils.currentLine=28049498;
 //BA.debugLineNum = 28049498;BA.debugLine="str1.Append(\"<summary><b> مرخصی های این ماه</b></";
mostCurrent._str1.Append("<summary><b> مرخصی های این ماه</b></summary>");
RDebugUtils.currentLine=28049499;
 //BA.debugLineNum = 28049499;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr style";
mostCurrent._str1.Append("<table style='width:100%;'><tr style='text-align: center;'>");
RDebugUtils.currentLine=28049500;
 //BA.debugLineNum = 28049500;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ</";
mostCurrent._str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b>زمان/روز</b></td><td><b> زمان/ساعت</b></td><br></tr>");
RDebugUtils.currentLine=28049502;
 //BA.debugLineNum = 28049502;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=28049503;
 //BA.debugLineNum = 28049503;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
mostCurrent._str1.Append("<tr style='text-align: center;'>");
RDebugUtils.currentLine=28049504;
 //BA.debugLineNum = 28049504;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
RDebugUtils.currentLine=28049505;
 //BA.debugLineNum = 28049505;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
RDebugUtils.currentLine=28049506;
 //BA.debugLineNum = 28049506;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
RDebugUtils.currentLine=28049507;
 //BA.debugLineNum = 28049507;BA.debugLine="str1.Append(\"<td>\").Append((myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append((mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")))).Append("</td>");
RDebugUtils.currentLine=28049508;
 //BA.debugLineNum = 28049508;BA.debugLine="str1.Append(\"<td>\").Append((myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append((mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")))+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))).Append("</td>");
RDebugUtils.currentLine=28049510;
 //BA.debugLineNum = 28049510;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
 }
;
RDebugUtils.currentLine=28049515;
 //BA.debugLineNum = 28049515;BA.debugLine="str1.Append(\"</table>\")";
mostCurrent._str1.Append("</table>");
RDebugUtils.currentLine=28049517;
 //BA.debugLineNum = 28049517;BA.debugLine="Dim list_morakhasi As List";
_list_morakhasi = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=28049518;
 //BA.debugLineNum = 28049518;BA.debugLine="list_morakhasi.Initialize";
_list_morakhasi.Initialize();
RDebugUtils.currentLine=28049520;
 //BA.debugLineNum = 28049520;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(sp_year.S";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num);
RDebugUtils.currentLine=28049522;
 //BA.debugLineNum = 28049522;BA.debugLine="str1.Append(\"مجموع مرخصی ها :<span style='color:#";
mostCurrent._str1.Append("مجموع مرخصی ها :<span style='color:#5E35B1;'><b> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (0))))+" روز و "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (1))))+" ساعت و "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (2))))+" دقیقه ");
RDebugUtils.currentLine=28049524;
 //BA.debugLineNum = 28049524;BA.debugLine="str1.Append(\"</b></span><br></details></div><br>\"";
mostCurrent._str1.Append("</b></span><br></details></div><br>");
RDebugUtils.currentLine=28049530;
 //BA.debugLineNum = 28049530;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f5";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5 ;' ><details open>");
RDebugUtils.currentLine=28049531;
 //BA.debugLineNum = 28049531;BA.debugLine="str1.Append(\"<summary><b>محاسبه حقوق</b></summary";
mostCurrent._str1.Append("<summary><b>محاسبه حقوق</b></summary>");
RDebugUtils.currentLine=28049533;
 //BA.debugLineNum = 28049533;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr>\")";
mostCurrent._str1.Append("<table style='width:100%;'><tr>");
RDebugUtils.currentLine=28049534;
 //BA.debugLineNum = 28049534;BA.debugLine="str1.Append(\"<td><div style='text-align: center;c";
mostCurrent._str1.Append("<td><div style='text-align: center;color:#661400;'><b> مزایا</b></div></td>");
RDebugUtils.currentLine=28049535;
 //BA.debugLineNum = 28049535;BA.debugLine="str1.Append(\"<td><div style='text-align: center;c";
mostCurrent._str1.Append("<td><div style='text-align: center;color:#661400;'><b>کسورات</b></div></td> </tr>");
RDebugUtils.currentLine=28049536;
 //BA.debugLineNum = 28049536;BA.debugLine="str1.Append(\"<tr style='vertical-align: text-top;";
mostCurrent._str1.Append("<tr style='vertical-align: text-top;'><td>");
RDebugUtils.currentLine=28049537;
 //BA.debugLineNum = 28049537;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(0)&\" برای \"&myfunc.";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (0)))+" برای "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_roze_kari))+" روز کاری : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_paye_end))+"</span><br>");
RDebugUtils.currentLine=28049538;
 //BA.debugLineNum = 28049538;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(2)&\" : <span style=";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (2)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maskan_end))+"</span><br>");
RDebugUtils.currentLine=28049539;
 //BA.debugLineNum = 28049539;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(3)&\" : <span style";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (3)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bon_end))+"</span><br>");
RDebugUtils.currentLine=28049540;
 //BA.debugLineNum = 28049540;BA.debugLine="If(olad_end<>0)Then";
if ((_olad_end!=0)) { 
RDebugUtils.currentLine=28049541;
 //BA.debugLineNum = 28049541;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(4)&\"  :<span style";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (4)))+"  :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad_end))+"</span><br>");
 };
RDebugUtils.currentLine=28049543;
 //BA.debugLineNum = 28049543;BA.debugLine="If(sanavat_end<>0)Then";
if ((_sanavat_end!=0)) { 
RDebugUtils.currentLine=28049544;
 //BA.debugLineNum = 28049544;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(1)&\"  : <span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (1)))+"  : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat_end))+"</span><br>");
 };
RDebugUtils.currentLine=28049546;
 //BA.debugLineNum = 28049546;BA.debugLine="If(fani_end<>0)Then";
if ((_fani_end!=0)) { 
RDebugUtils.currentLine=28049547;
 //BA.debugLineNum = 28049547;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(5)&\" : <span style";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (5)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_fani_end))+"</span><br>");
 };
RDebugUtils.currentLine=28049549;
 //BA.debugLineNum = 28049549;BA.debugLine="If(masoliat_end<>0)Then";
if ((_masoliat_end!=0)) { 
RDebugUtils.currentLine=28049550;
 //BA.debugLineNum = 28049550;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(6)&\" : <span style";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (6)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_masoliat_end))+"</span><br>");
 };
RDebugUtils.currentLine=28049552;
 //BA.debugLineNum = 28049552;BA.debugLine="If(sarparasti_end<>0)Then";
if ((_sarparasti_end!=0)) { 
RDebugUtils.currentLine=28049553;
 //BA.debugLineNum = 28049553;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(7)&\" : <span styl";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (7)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sarparasti_end))+"</span><br>");
 };
RDebugUtils.currentLine=28049555;
 //BA.debugLineNum = 28049555;BA.debugLine="If(shift_end<>0)Then";
if ((_shift_end!=0)) { 
RDebugUtils.currentLine=28049556;
 //BA.debugLineNum = 28049556;BA.debugLine="str1.Append(\" حق شیفت \"&myfunc.en2fa(shift)&\" در";
mostCurrent._str1.Append(" حق شیفت "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_shift))+" درصد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_shift_end))+"</span><br>");
 };
RDebugUtils.currentLine=28049558;
 //BA.debugLineNum = 28049558;BA.debugLine="If(mazaya_end<>0)Then";
if ((_mazaya_end!=0)) { 
RDebugUtils.currentLine=28049559;
 //BA.debugLineNum = 28049559;BA.debugLine="str1.Append(\"  \"&ls_onvanHa.Get(10)&\" : <span st";
mostCurrent._str1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (10)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya_end))+"</span><br>");
 };
RDebugUtils.currentLine=28049565;
 //BA.debugLineNum = 28049565;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=28049566;
 //BA.debugLineNum = 28049566;BA.debugLine="str1.Append(\"اضافه کاری عادی\").Append(\"<br>\")";
mostCurrent._str1.Append("اضافه کاری عادی").Append("<br>");
RDebugUtils.currentLine=28049568;
 //BA.debugLineNum = 28049568;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B1";
mostCurrent._str1.Append(" ساعات : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h.getText())+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m.getText())+"</span><br>");
RDebugUtils.currentLine=28049570;
 //BA.debugLineNum = 28049570;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5E";
mostCurrent._str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_vahed_ezafekari))+"</span><br>");
RDebugUtils.currentLine=28049576;
 //BA.debugLineNum = 28049576;BA.debugLine="If(ezafekari_end_vij<>0)Then";
if ((_ezafekari_end_vij!=0)) { 
RDebugUtils.currentLine=28049577;
 //BA.debugLineNum = 28049577;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=28049579;
 //BA.debugLineNum = 28049579;BA.debugLine="str1.Append(\"اضافه کاری <span style='color:#ff4d0";
mostCurrent._str1.Append("اضافه کاری <span style='color:#ff4d00;'>"+"فوق العاده"+"</span>").Append("<br>");
RDebugUtils.currentLine=28049581;
 //BA.debugLineNum = 28049581;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B1;";
mostCurrent._str1.Append(" ساعات : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h_vij.getText())+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m_vij.getText())+"</span><br>");
RDebugUtils.currentLine=28049584;
 //BA.debugLineNum = 28049584;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5E3";
mostCurrent._str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_vahed_ezafekari_vij))+"</span><br>");
 };
RDebugUtils.currentLine=28049588;
 //BA.debugLineNum = 28049588;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=28049589;
 //BA.debugLineNum = 28049589;BA.debugLine="str1.Append(\"مجموع اضافه کاری : <span style='colo";
mostCurrent._str1.Append("مجموع اضافه کاری : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool((int) (_ezafekari_end+_ezafekari_end_vij)))+"</span><br></td>");
RDebugUtils.currentLine=28049592;
 //BA.debugLineNum = 28049592;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=28049593;
 //BA.debugLineNum = 28049593;BA.debugLine="str1.Append(\"بیمه تامین اجتماعی \"&myfunc.en2fa(sh";
mostCurrent._str1.Append("بیمه تامین اجتماعی "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_tamin))+" درصد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_tamin_end))+"</span><br>");
RDebugUtils.currentLine=28049595;
 //BA.debugLineNum = 28049595;BA.debugLine="If(bime_takmil<>0)Then";
if ((_bime_takmil!=0)) { 
RDebugUtils.currentLine=28049596;
 //BA.debugLineNum = 28049596;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(9)&\" :<span style=";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (9)))+" :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_takmil))+"</span><br>");
 };
RDebugUtils.currentLine=28049599;
 //BA.debugLineNum = 28049599;BA.debugLine="If(maliat_end<>0)Then";
if ((_maliat_end!=0)) { 
RDebugUtils.currentLine=28049600;
 //BA.debugLineNum = 28049600;BA.debugLine="str1.Append(\" مالیات : <span style='color:#5E35B";
mostCurrent._str1.Append(" مالیات : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maliat_end))+"</span><br>");
 };
RDebugUtils.currentLine=28049602;
 //BA.debugLineNum = 28049602;BA.debugLine="If(ksorat<>0)Then";
if ((_ksorat!=0)) { 
RDebugUtils.currentLine=28049603;
 //BA.debugLineNum = 28049603;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(11)&\" : <span sty";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (11)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat))+"</span></td>");
 };
RDebugUtils.currentLine=28049606;
 //BA.debugLineNum = 28049606;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
RDebugUtils.currentLine=28049608;
 //BA.debugLineNum = 28049608;BA.debugLine="str1.Append(\"<tr><td>\")";
mostCurrent._str1.Append("<tr><td>");
RDebugUtils.currentLine=28049609;
 //BA.debugLineNum = 28049609;BA.debugLine="str1.Append(\"جمع مزایا :  <span style='color:#5E3";
mostCurrent._str1.Append("جمع مزایا :  <span style='color:#5E35B1;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_nakhales))+"</b></span>");
RDebugUtils.currentLine=28049610;
 //BA.debugLineNum = 28049610;BA.debugLine="str1.Append(\"</td><td>\")";
mostCurrent._str1.Append("</td><td>");
RDebugUtils.currentLine=28049612;
 //BA.debugLineNum = 28049612;BA.debugLine="str1.Append(\"جمع کسورات :  <span style='color:#5E";
mostCurrent._str1.Append("جمع کسورات :  <span style='color:#5E35B1;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_jame_kosorat))+"</b></span>");
RDebugUtils.currentLine=28049613;
 //BA.debugLineNum = 28049613;BA.debugLine="str1.Append(\"</td></tr></table><br>\")";
mostCurrent._str1.Append("</td></tr></table><br>");
RDebugUtils.currentLine=28049615;
 //BA.debugLineNum = 28049615;BA.debugLine="str1.Append(\" دریافتی خالص :  <span style='color:";
mostCurrent._str1.Append(" دریافتی خالص :  <span style='color:#388E3C;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_khales))+" </b></span></b>");
RDebugUtils.currentLine=28049616;
 //BA.debugLineNum = 28049616;BA.debugLine="str1.Append(\"<span style='font-size: 11px;'> توما";
mostCurrent._str1.Append("<span style='font-size: 11px;'> تومان </span>");
RDebugUtils.currentLine=28049618;
 //BA.debugLineNum = 28049618;BA.debugLine="str1.Append(\"<br></details></div>\")";
mostCurrent._str1.Append("<br></details></div>");
RDebugUtils.currentLine=28049620;
 //BA.debugLineNum = 28049620;BA.debugLine="str1.Append(\"<footer style=' text-align: center;";
mostCurrent._str1.Append("<footer style=' text-align: center; '><h6> اپلیکیشن اضافه کاری من </h6></footer>");
RDebugUtils.currentLine=28049622;
 //BA.debugLineNum = 28049622;BA.debugLine="str1.Append(\"</body></html>\")";
mostCurrent._str1.Append("</body></html>");
RDebugUtils.currentLine=28049624;
 //BA.debugLineNum = 28049624;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=28049625;
 //BA.debugLineNum = 28049625;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=28049630;
 //BA.debugLineNum = 28049630;BA.debugLine="WebView2.LoadHtml(str1.ToString)";
mostCurrent._webview2.LoadHtml(mostCurrent._str1.ToString());
RDebugUtils.currentLine=28049631;
 //BA.debugLineNum = 28049631;BA.debugLine="End Sub";
return "";
}
public static String  _mohasebe() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mohasebe", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "mohasebe", null));}
int _nak_mal = 0;
RDebugUtils.currentLine=28114944;
 //BA.debugLineNum = 28114944;BA.debugLine="Sub mohasebe";
RDebugUtils.currentLine=28114948;
 //BA.debugLineNum = 28114948;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=28114951;
 //BA.debugLineNum = 28114951;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=28114958;
 //BA.debugLineNum = 28114958;BA.debugLine="If (roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=28114959;
 //BA.debugLineNum = 28114959;BA.debugLine="maskan_end=(maskan/30)*roze_kari";
_maskan_end = (int) ((_maskan/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=28114961;
 //BA.debugLineNum = 28114961;BA.debugLine="maskan_end=maskan";
_maskan_end = _maskan;
 };
RDebugUtils.currentLine=28114966;
 //BA.debugLineNum = 28114966;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=28114967;
 //BA.debugLineNum = 28114967;BA.debugLine="bon_end=(bon/30)*roze_kari";
_bon_end = (int) ((_bon/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=28114969;
 //BA.debugLineNum = 28114969;BA.debugLine="bon_end=bon";
_bon_end = _bon;
 };
RDebugUtils.currentLine=28114974;
 //BA.debugLineNum = 28114974;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=28114975;
 //BA.debugLineNum = 28114975;BA.debugLine="olad_end=(olad/30)*roze_kari";
_olad_end = (int) ((_olad/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=28114977;
 //BA.debugLineNum = 28114977;BA.debugLine="olad_end=olad";
_olad_end = _olad;
 };
RDebugUtils.currentLine=28114982;
 //BA.debugLineNum = 28114982;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=28114983;
 //BA.debugLineNum = 28114983;BA.debugLine="fani_end=(fani/30)*roze_kari";
_fani_end = (int) ((_fani/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=28114985;
 //BA.debugLineNum = 28114985;BA.debugLine="fani_end=fani";
_fani_end = _fani;
 };
RDebugUtils.currentLine=28114989;
 //BA.debugLineNum = 28114989;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=28114990;
 //BA.debugLineNum = 28114990;BA.debugLine="masoliat_end=(masoliat/30)*roze_kari";
_masoliat_end = (int) ((_masoliat/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=28114992;
 //BA.debugLineNum = 28114992;BA.debugLine="masoliat_end=masoliat";
_masoliat_end = _masoliat;
 };
RDebugUtils.currentLine=28114996;
 //BA.debugLineNum = 28114996;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=28114997;
 //BA.debugLineNum = 28114997;BA.debugLine="sarparasti_end=(sarparasti/30)*roze_kari";
_sarparasti_end = (int) ((_sarparasti/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=28114999;
 //BA.debugLineNum = 28114999;BA.debugLine="sarparasti_end=sarparasti";
_sarparasti_end = _sarparasti;
 };
RDebugUtils.currentLine=28115003;
 //BA.debugLineNum = 28115003;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=28115004;
 //BA.debugLineNum = 28115004;BA.debugLine="mazaya_end=(mazaya/30)*roze_kari";
_mazaya_end = (int) ((_mazaya/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=28115006;
 //BA.debugLineNum = 28115006;BA.debugLine="mazaya_end=mazaya";
_mazaya_end = _mazaya;
 };
RDebugUtils.currentLine=28115010;
 //BA.debugLineNum = 28115010;BA.debugLine="shift_end=((paye_end+sanavat_end)*shift)/100";
_shift_end = (int) (((_paye_end+_sanavat_end)*_shift)/(double)100);
RDebugUtils.currentLine=28115013;
 //BA.debugLineNum = 28115013;BA.debugLine="vahed_ezafekari=et_vahed_ezafekari.Tag";
_vahed_ezafekari = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari.getTag()));
RDebugUtils.currentLine=28115014;
 //BA.debugLineNum = 28115014;BA.debugLine="ezafekari_end=vahed_ezafekari*(et_time_h.Text+(et";
_ezafekari_end = (int) (_vahed_ezafekari*((double)(Double.parseDouble(mostCurrent._et_time_h.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m.getText()))/(double)60)));
RDebugUtils.currentLine=28115018;
 //BA.debugLineNum = 28115018;BA.debugLine="vahed_ezafekari_vij=et_vahed_ezafekari_vij.Tag";
_vahed_ezafekari_vij = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari_vij.getTag()));
RDebugUtils.currentLine=28115019;
 //BA.debugLineNum = 28115019;BA.debugLine="ezafekari_end_vij=vahed_ezafekari_vij*(et_time_h_";
_ezafekari_end_vij = (int) (_vahed_ezafekari_vij*((double)(Double.parseDouble(mostCurrent._et_time_h_vij.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m_vij.getText()))/(double)60)));
RDebugUtils.currentLine=28115025;
 //BA.debugLineNum = 28115025;BA.debugLine="hogog_nakhales=paye_end+ezafekari_end+ezafekari_e";
_hogog_nakhales = (int) (_paye_end+_ezafekari_end+_ezafekari_end_vij+_maskan_end+_bon_end+_olad_end+_fani_end+_masoliat_end+_sarparasti_end+_sanavat_end+_mazaya_end+_shift_end);
RDebugUtils.currentLine=28115028;
 //BA.debugLineNum = 28115028;BA.debugLine="bime_tamin_end=(hogog_nakhales-olad_end)*0.07";
_bime_tamin_end = (int) ((_hogog_nakhales-_olad_end)*0.07);
RDebugUtils.currentLine=28115030;
 //BA.debugLineNum = 28115030;BA.debugLine="Dim nak_mal As Int";
_nak_mal = 0;
RDebugUtils.currentLine=28115031;
 //BA.debugLineNum = 28115031;BA.debugLine="nak_mal=hogog_nakhales-((bime_tamin_end*2)/7)  ''";
_nak_mal = (int) (_hogog_nakhales-((_bime_tamin_end*2)/(double)7));
RDebugUtils.currentLine=28115035;
 //BA.debugLineNum = 28115035;BA.debugLine="maliat_end=mohasebe_maliat(nak_mal,sp_year.Select";
_maliat_end = _mohasebe_maliat(_nak_mal,(int)(Double.parseDouble(mostCurrent._sp_year.getSelectedItem())));
RDebugUtils.currentLine=28115039;
 //BA.debugLineNum = 28115039;BA.debugLine="jame_kosorat=bime_tamin_end+maliat_end+bime_takmi";
_jame_kosorat = (int) (_bime_tamin_end+_maliat_end+_bime_takmil+_ksorat);
RDebugUtils.currentLine=28115041;
 //BA.debugLineNum = 28115041;BA.debugLine="hogog_khales=hogog_nakhales-jame_kosorat";
_hogog_khales = (int) (_hogog_nakhales-_jame_kosorat);
RDebugUtils.currentLine=28115043;
 //BA.debugLineNum = 28115043;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_gozaresh_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_gozaresh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_gozaresh_click", null));}
RDebugUtils.currentLine=28377088;
 //BA.debugLineNum = 28377088;BA.debugLine="Private Sub lbl_save_gozaresh_Click";
RDebugUtils.currentLine=28377089;
 //BA.debugLineNum = 28377089;BA.debugLine="et_name_gozaresh.Text=sp_moon.SelectedItem&\" \"&sp";
mostCurrent._et_name_gozaresh.setText(BA.ObjectToCharSequence(mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._sp_year.getSelectedItem()));
RDebugUtils.currentLine=28377090;
 //BA.debugLineNum = 28377090;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=28377091;
 //BA.debugLineNum = 28377091;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_gozaresh_end_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_gozaresh_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_gozaresh_end_click", null));}
RDebugUtils.currentLine=28639232;
 //BA.debugLineNum = 28639232;BA.debugLine="Private Sub lbl_save_gozaresh_end_Click";
RDebugUtils.currentLine=28639233;
 //BA.debugLineNum = 28639233;BA.debugLine="save_gozaresh";
_save_gozaresh();
RDebugUtils.currentLine=28639234;
 //BA.debugLineNum = 28639234;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=28639235;
 //BA.debugLineNum = 28639235;BA.debugLine="End Sub";
return "";
}
public static String  _save_gozaresh() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "save_gozaresh", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "save_gozaresh", null));}
boolean _chek = false;
anywheresoftware.b4a.objects.collections.List _alist = null;
RDebugUtils.currentLine=28442624;
 //BA.debugLineNum = 28442624;BA.debugLine="Sub save_gozaresh";
RDebugUtils.currentLine=28442627;
 //BA.debugLineNum = 28442627;BA.debugLine="Dim chek As Boolean";
_chek = false;
RDebugUtils.currentLine=28442628;
 //BA.debugLineNum = 28442628;BA.debugLine="chek=myfunc.check_karid";
_chek = mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=28442629;
 //BA.debugLineNum = 28442629;BA.debugLine="Dim alist As List";
_alist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=28442630;
 //BA.debugLineNum = 28442630;BA.debugLine="alist.Initialize";
_alist.Initialize();
RDebugUtils.currentLine=28442632;
 //BA.debugLineNum = 28442632;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(Main.persianDa";
_alist = mostCurrent._myfunc._num_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())),BA.NumberToString(01));
RDebugUtils.currentLine=28442635;
 //BA.debugLineNum = 28442635;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=28442636;
 //BA.debugLineNum = 28442636;BA.debugLine="If(alist.Get(2)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (2))))<5)) { 
RDebugUtils.currentLine=28442637;
 //BA.debugLineNum = 28442637;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDa";
mostCurrent._dbcode._add_gozaresh /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),mostCurrent._et_name_gozaresh.getText(),mostCurrent._et_tozih_gozaresh.getText(),mostCurrent._str1.ToString(),BA.NumberToString(_hogog_nakhales),BA.NumberToString(_hogog_khales));
RDebugUtils.currentLine=28442638;
 //BA.debugLineNum = 28442638;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("گزارش ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=28442640;
 //BA.debugLineNum = 28442640;BA.debugLine="Main.buy_index=1";
mostCurrent._main._buy_index /*int*/  = (int) (1);
RDebugUtils.currentLine=28442641;
 //BA.debugLineNum = 28442641;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=28442642;
 //BA.debugLineNum = 28442642;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 }else {
RDebugUtils.currentLine=28442645;
 //BA.debugLineNum = 28442645;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDat";
mostCurrent._dbcode._add_gozaresh /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),mostCurrent._et_name_gozaresh.getText(),mostCurrent._et_tozih_gozaresh.getText(),mostCurrent._str1.ToString(),BA.NumberToString(_hogog_nakhales),BA.NumberToString(_hogog_khales));
RDebugUtils.currentLine=28442646;
 //BA.debugLineNum = 28442646;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("گزارش ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=28442651;
 //BA.debugLineNum = 28442651;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_share_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_share_click", null));}
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
RDebugUtils.currentLine=29032448;
 //BA.debugLineNum = 29032448;BA.debugLine="Private Sub lbl_share_Click";
RDebugUtils.currentLine=29032449;
 //BA.debugLineNum = 29032449;BA.debugLine="Dim FileName As String =Main.current_gozaresh_id&";
_filename = BA.NumberToString(mostCurrent._main._current_gozaresh_id /*int*/ )+".html";
RDebugUtils.currentLine=29032452;
 //BA.debugLineNum = 29032452;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
anywheresoftware.b4a.keywords.Common.File.WriteString(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename,mostCurrent._str1.ToString());
RDebugUtils.currentLine=29032454;
 //BA.debugLineNum = 29032454;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=29032455;
 //BA.debugLineNum = 29032455;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
RDebugUtils.currentLine=29032456;
 //BA.debugLineNum = 29032456;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
RDebugUtils.currentLine=29032457;
 //BA.debugLineNum = 29032457;BA.debugLine="email.Body = \" گزارش حقوق \"&str1.ToString&CRLF&\"ا";
_email.Body = " گزارش حقوق "+mostCurrent._str1.ToString()+anywheresoftware.b4a.keywords.Common.CRLF+"اپلیکیشن اضافه کاری من"+anywheresoftware.b4a.keywords.Common.CRLF+"دانلود از بازار";
RDebugUtils.currentLine=29032458;
 //BA.debugLineNum = 29032458;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (null,_filename));
RDebugUtils.currentLine=29032460;
 //BA.debugLineNum = 29032460;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
RDebugUtils.currentLine=29032461;
 //BA.debugLineNum = 29032461;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
RDebugUtils.currentLine=29032462;
 //BA.debugLineNum = 29032462;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
RDebugUtils.currentLine=29032463;
 //BA.debugLineNum = 29032463;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=28180480;
 //BA.debugLineNum = 28180480;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
RDebugUtils.currentLine=28180481;
 //BA.debugLineNum = 28180481;BA.debugLine="Dim all_maliat As Int=0";
_all_maliat = (int) (0);
RDebugUtils.currentLine=28180482;
 //BA.debugLineNum = 28180482;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
RDebugUtils.currentLine=28180483;
 //BA.debugLineNum = 28180483;BA.debugLine="Dim state2 As Int=0";
_state2 = (int) (0);
RDebugUtils.currentLine=28180484;
 //BA.debugLineNum = 28180484;BA.debugLine="Dim state3 As Int=0";
_state3 = (int) (0);
RDebugUtils.currentLine=28180485;
 //BA.debugLineNum = 28180485;BA.debugLine="Dim state4 As Int=0";
_state4 = (int) (0);
RDebugUtils.currentLine=28180486;
 //BA.debugLineNum = 28180486;BA.debugLine="Dim state5 As Int=0";
_state5 = (int) (0);
RDebugUtils.currentLine=28180487;
 //BA.debugLineNum = 28180487;BA.debugLine="Dim state6 As Int=0";
_state6 = (int) (0);
RDebugUtils.currentLine=28180489;
 //BA.debugLineNum = 28180489;BA.debugLine="If (year=1399)Then";
if ((_year==1399)) { 
RDebugUtils.currentLine=28180490;
 //BA.debugLineNum = 28180490;BA.debugLine="If(hogog>3000001 And hogog<7500001)Then	  ''----";
if ((_hogog>3000001 && _hogog<7500001)) { 
RDebugUtils.currentLine=28180491;
 //BA.debugLineNum = 28180491;BA.debugLine="state1=(hogog-3000000)*0.1";
_state1 = (int) ((_hogog-3000000)*0.1);
 };
RDebugUtils.currentLine=28180493;
 //BA.debugLineNum = 28180493;BA.debugLine="If(hogog>7500001 And hogog<10500001)Then	  ''---";
if ((_hogog>7500001 && _hogog<10500001)) { 
RDebugUtils.currentLine=28180494;
 //BA.debugLineNum = 28180494;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=28180495;
 //BA.debugLineNum = 28180495;BA.debugLine="state2=(hogog-7500000)*0.15";
_state2 = (int) ((_hogog-7500000)*0.15);
 };
RDebugUtils.currentLine=28180497;
 //BA.debugLineNum = 28180497;BA.debugLine="If(hogog>10500001 And hogog<15000001)Then	  ''--";
if ((_hogog>10500001 && _hogog<15000001)) { 
RDebugUtils.currentLine=28180498;
 //BA.debugLineNum = 28180498;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=28180499;
 //BA.debugLineNum = 28180499;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=28180500;
 //BA.debugLineNum = 28180500;BA.debugLine="state3=(hogog-10500000)*0.2";
_state3 = (int) ((_hogog-10500000)*0.2);
 };
RDebugUtils.currentLine=28180502;
 //BA.debugLineNum = 28180502;BA.debugLine="If(hogog>15000001)Then	  ''-----stat4";
if ((_hogog>15000001)) { 
RDebugUtils.currentLine=28180503;
 //BA.debugLineNum = 28180503;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=28180504;
 //BA.debugLineNum = 28180504;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=28180505;
 //BA.debugLineNum = 28180505;BA.debugLine="state3=(4500000)*0.2";
_state3 = (int) ((4500000)*0.2);
RDebugUtils.currentLine=28180506;
 //BA.debugLineNum = 28180506;BA.debugLine="state4=(hogog-15000001)*0.25";
_state4 = (int) ((_hogog-15000001)*0.25);
 };
 };
RDebugUtils.currentLine=28180510;
 //BA.debugLineNum = 28180510;BA.debugLine="If (year=1400)Then";
if ((_year==1400)) { 
RDebugUtils.currentLine=28180511;
 //BA.debugLineNum = 28180511;BA.debugLine="If(hogog>4000001 And hogog<8000001)Then	  ''----";
if ((_hogog>4000001 && _hogog<8000001)) { 
RDebugUtils.currentLine=28180512;
 //BA.debugLineNum = 28180512;BA.debugLine="state1=(hogog-4000000)*0.1";
_state1 = (int) ((_hogog-4000000)*0.1);
 };
RDebugUtils.currentLine=28180514;
 //BA.debugLineNum = 28180514;BA.debugLine="If(hogog>8000001 And hogog<12000001)Then	  ''---";
if ((_hogog>8000001 && _hogog<12000001)) { 
RDebugUtils.currentLine=28180515;
 //BA.debugLineNum = 28180515;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=28180516;
 //BA.debugLineNum = 28180516;BA.debugLine="state2=(hogog-8000000)*0.15";
_state2 = (int) ((_hogog-8000000)*0.15);
 };
RDebugUtils.currentLine=28180518;
 //BA.debugLineNum = 28180518;BA.debugLine="If(hogog>12000001 And hogog<18000001)Then	  ''--";
if ((_hogog>12000001 && _hogog<18000001)) { 
RDebugUtils.currentLine=28180519;
 //BA.debugLineNum = 28180519;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=28180520;
 //BA.debugLineNum = 28180520;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=28180521;
 //BA.debugLineNum = 28180521;BA.debugLine="state3=(hogog-12000000)*0.2";
_state3 = (int) ((_hogog-12000000)*0.2);
 };
RDebugUtils.currentLine=28180523;
 //BA.debugLineNum = 28180523;BA.debugLine="If(hogog>18000001 And hogog<24000001)Then	  ''--";
if ((_hogog>18000001 && _hogog<24000001)) { 
RDebugUtils.currentLine=28180524;
 //BA.debugLineNum = 28180524;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=28180525;
 //BA.debugLineNum = 28180525;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=28180526;
 //BA.debugLineNum = 28180526;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=28180527;
 //BA.debugLineNum = 28180527;BA.debugLine="state4=(hogog-18000000)*0.25";
_state4 = (int) ((_hogog-18000000)*0.25);
 };
RDebugUtils.currentLine=28180529;
 //BA.debugLineNum = 28180529;BA.debugLine="If(hogog>24000001 And hogog<32000001)Then	  ''--";
if ((_hogog>24000001 && _hogog<32000001)) { 
RDebugUtils.currentLine=28180530;
 //BA.debugLineNum = 28180530;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=28180531;
 //BA.debugLineNum = 28180531;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=28180532;
 //BA.debugLineNum = 28180532;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=28180533;
 //BA.debugLineNum = 28180533;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=28180534;
 //BA.debugLineNum = 28180534;BA.debugLine="state5=(hogog-24000000)*0.3";
_state5 = (int) ((_hogog-24000000)*0.3);
 };
RDebugUtils.currentLine=28180536;
 //BA.debugLineNum = 28180536;BA.debugLine="If(hogog>32000001)Then	  ''-----stat4";
if ((_hogog>32000001)) { 
RDebugUtils.currentLine=28180537;
 //BA.debugLineNum = 28180537;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=28180538;
 //BA.debugLineNum = 28180538;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=28180539;
 //BA.debugLineNum = 28180539;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=28180540;
 //BA.debugLineNum = 28180540;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=28180541;
 //BA.debugLineNum = 28180541;BA.debugLine="state5=(6000000)*0.3";
_state5 = (int) ((6000000)*0.3);
RDebugUtils.currentLine=28180542;
 //BA.debugLineNum = 28180542;BA.debugLine="state6=(hogog-32000000)*0.35";
_state6 = (int) ((_hogog-32000000)*0.35);
 };
 };
RDebugUtils.currentLine=28180546;
 //BA.debugLineNum = 28180546;BA.debugLine="If (year=1401)Then";
if ((_year==1401)) { 
RDebugUtils.currentLine=28180547;
 //BA.debugLineNum = 28180547;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
if ((_hogog>5600001 && _hogog<12500001)) { 
RDebugUtils.currentLine=28180548;
 //BA.debugLineNum = 28180548;BA.debugLine="state1=(hogog-5600000)*0.1";
_state1 = (int) ((_hogog-5600000)*0.1);
 };
RDebugUtils.currentLine=28180550;
 //BA.debugLineNum = 28180550;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
if ((_hogog>12500001 && _hogog<20830001)) { 
RDebugUtils.currentLine=28180551;
 //BA.debugLineNum = 28180551;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=28180552;
 //BA.debugLineNum = 28180552;BA.debugLine="state2=(hogog-12500000)*0.15";
_state2 = (int) ((_hogog-12500000)*0.15);
 };
RDebugUtils.currentLine=28180554;
 //BA.debugLineNum = 28180554;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
if ((_hogog>20830001 && _hogog<29160001)) { 
RDebugUtils.currentLine=28180555;
 //BA.debugLineNum = 28180555;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=28180556;
 //BA.debugLineNum = 28180556;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=28180557;
 //BA.debugLineNum = 28180557;BA.debugLine="state3=(hogog-20830000)*0.2";
_state3 = (int) ((_hogog-20830000)*0.2);
 };
RDebugUtils.currentLine=28180560;
 //BA.debugLineNum = 28180560;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
if ((_hogog>29160001)) { 
RDebugUtils.currentLine=28180561;
 //BA.debugLineNum = 28180561;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=28180562;
 //BA.debugLineNum = 28180562;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=28180563;
 //BA.debugLineNum = 28180563;BA.debugLine="state3=(8330000)*0.2";
_state3 = (int) ((8330000)*0.2);
RDebugUtils.currentLine=28180565;
 //BA.debugLineNum = 28180565;BA.debugLine="state4=(hogog-29160000)*0.3";
_state4 = (int) ((_hogog-29160000)*0.3);
 };
 };
RDebugUtils.currentLine=28180570;
 //BA.debugLineNum = 28180570;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
_all_maliat = (int) (_state1+_state2+_state3+_state4+_state5+_state6);
RDebugUtils.currentLine=28180571;
 //BA.debugLineNum = 28180571;BA.debugLine="Return all_maliat";
if (true) return _all_maliat;
RDebugUtils.currentLine=28180573;
 //BA.debugLineNum = 28180573;BA.debugLine="End Sub";
return 0;
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=28770304;
 //BA.debugLineNum = 28770304;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=28770305;
 //BA.debugLineNum = 28770305;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=28770306;
 //BA.debugLineNum = 28770306;BA.debugLine="End Sub";
return "";
}
public static String  _pan_mohasebat_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_mohasebat_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_mohasebat_click", null));}
RDebugUtils.currentLine=28573696;
 //BA.debugLineNum = 28573696;BA.debugLine="Private Sub pan_mohasebat_Click";
RDebugUtils.currentLine=28573698;
 //BA.debugLineNum = 28573698;BA.debugLine="End Sub";
return "";
}
public static String  _panel7_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel7_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel7_click", null));}
RDebugUtils.currentLine=28704768;
 //BA.debugLineNum = 28704768;BA.debugLine="Private Sub Panel7_Click";
RDebugUtils.currentLine=28704770;
 //BA.debugLineNum = 28704770;BA.debugLine="End Sub";
return "";
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_moon_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_moon_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=28246016;
 //BA.debugLineNum = 28246016;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=28246017;
 //BA.debugLineNum = 28246017;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=28246019;
 //BA.debugLineNum = 28246019;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=28311552;
 //BA.debugLineNum = 28311552;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=28311553;
 //BA.debugLineNum = 28311553;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=28311554;
 //BA.debugLineNum = 28311554;BA.debugLine="End Sub";
return "";
}
public static String  _time_page_load_tick() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time_page_load_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "time_page_load_tick", null));}
RDebugUtils.currentLine=27525120;
 //BA.debugLineNum = 27525120;BA.debugLine="Sub time_page_load_Tick";
RDebugUtils.currentLine=27525121;
 //BA.debugLineNum = 27525121;BA.debugLine="pan_load.Visible=False";
mostCurrent._pan_load.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=27525122;
 //BA.debugLineNum = 27525122;BA.debugLine="B4XLoadingIndicator1.Hide";
mostCurrent._b4xloadingindicator1._hide /*String*/ (null);
RDebugUtils.currentLine=27525123;
 //BA.debugLineNum = 27525123;BA.debugLine="Main.time_page_load.Enabled=False";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=27525124;
 //BA.debugLineNum = 27525124;BA.debugLine="End Sub";
return "";
}
}