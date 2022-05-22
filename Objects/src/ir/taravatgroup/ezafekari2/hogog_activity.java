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
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.drawable.BitmapDrawable _imm = null;
RDebugUtils.currentLine=16777216;
 //BA.debugLineNum = 16777216;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=16777218;
 //BA.debugLineNum = 16777218;BA.debugLine="Activity.LoadLayout(\"hogog_layout\")";
mostCurrent._activity.LoadLayout("hogog_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=16777219;
 //BA.debugLineNum = 16777219;BA.debugLine="scv_hogog.Panel.LoadLayout(\"item_hogog\")";
mostCurrent._scv_hogog.getPanel().LoadLayout("item_hogog",mostCurrent.activityBA);
RDebugUtils.currentLine=16777221;
 //BA.debugLineNum = 16777221;BA.debugLine="get_data_hogogi";
_get_data_hogogi();
RDebugUtils.currentLine=16777223;
 //BA.debugLineNum = 16777223;BA.debugLine="Main.time_page_load.Initialize(\"time_page_load\",1";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .Initialize(processBA,"time_page_load",(long) (1500));
RDebugUtils.currentLine=16777224;
 //BA.debugLineNum = 16777224;BA.debugLine="Main.time_page_load.Enabled=True";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=16777225;
 //BA.debugLineNum = 16777225;BA.debugLine="B4XLoadingIndicator1.Show";
mostCurrent._b4xloadingindicator1._show /*String*/ (null);
RDebugUtils.currentLine=16777227;
 //BA.debugLineNum = 16777227;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
RDebugUtils.currentLine=16777228;
 //BA.debugLineNum = 16777228;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
RDebugUtils.currentLine=16777229;
 //BA.debugLineNum = 16777229;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
RDebugUtils.currentLine=16777230;
 //BA.debugLineNum = 16777230;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
RDebugUtils.currentLine=16777232;
 //BA.debugLineNum = 16777232;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=16777234;
 //BA.debugLineNum = 16777234;BA.debugLine="Dim imm As BitmapDrawable";
_imm = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=16777235;
 //BA.debugLineNum = 16777235;BA.debugLine="imm.Initialize(LoadBitmap(File.DirAssets,\"textBox";
_imm.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"textBox.png").getObject()));
RDebugUtils.currentLine=16777236;
 //BA.debugLineNum = 16777236;BA.debugLine="imm.Gravity=Gravity.FILL";
_imm.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=16777237;
 //BA.debugLineNum = 16777237;BA.debugLine="sp_year.Background=imm";
mostCurrent._sp_year.setBackground((android.graphics.drawable.Drawable)(_imm.getObject()));
RDebugUtils.currentLine=16777238;
 //BA.debugLineNum = 16777238;BA.debugLine="sp_moon.Background=imm";
mostCurrent._sp_moon.setBackground((android.graphics.drawable.Drawable)(_imm.getObject()));
RDebugUtils.currentLine=16777241;
 //BA.debugLineNum = 16777241;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))-1));
RDebugUtils.currentLine=16777242;
 //BA.debugLineNum = 16777242;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=16777246;
 //BA.debugLineNum = 16777246;BA.debugLine="pan_hed_hogog.Color=Main.color4";
mostCurrent._pan_hed_hogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=16777247;
 //BA.debugLineNum = 16777247;BA.debugLine="pan_main_hed_hogog.Color=Main.color4";
mostCurrent._pan_main_hed_hogog.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=16777248;
 //BA.debugLineNum = 16777248;BA.debugLine="pan_hed_gozaresh.Color=Main.color4";
mostCurrent._pan_hed_gozaresh.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=16777249;
 //BA.debugLineNum = 16777249;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=16777252;
 //BA.debugLineNum = 16777252;BA.debugLine="WebView1.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview1.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=16777253;
 //BA.debugLineNum = 16777253;BA.debugLine="WebView2.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._webview2.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=16777256;
 //BA.debugLineNum = 16777256;BA.debugLine="ls_onvanHa.Initialize";
mostCurrent._ls_onvanha.Initialize();
RDebugUtils.currentLine=16777257;
 //BA.debugLineNum = 16777257;BA.debugLine="ls_onvanHa=dbCode.read_onvan_db";
mostCurrent._ls_onvanha = mostCurrent._dbcode._read_onvan_db /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=16777260;
 //BA.debugLineNum = 16777260;BA.debugLine="str_web1.Initialize";
mostCurrent._str_web1.Initialize();
RDebugUtils.currentLine=16777261;
 //BA.debugLineNum = 16777261;BA.debugLine="str_web1.Append(\"<html dir='rtl'><meta charset='U";
mostCurrent._str_web1.Append("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>");
RDebugUtils.currentLine=16777262;
 //BA.debugLineNum = 16777262;BA.debugLine="str_web1.Append(\"<h4 align='center' >اطلاعات حقوق";
mostCurrent._str_web1.Append("<h4 align='center' >اطلاعات حقوق برای ۳۰ روز</h4>");
RDebugUtils.currentLine=16777263;
 //BA.debugLineNum = 16777263;BA.debugLine="str_web1.Append(\"<h6 align='center'>واحد : تومان<";
mostCurrent._str_web1.Append("<h6 align='center'>واحد : تومان</h6>");
RDebugUtils.currentLine=16777264;
 //BA.debugLineNum = 16777264;BA.debugLine="str_web1.Append(\"<table style='width:100%'><tr>\")";
mostCurrent._str_web1.Append("<table style='width:100%'><tr>");
RDebugUtils.currentLine=16777265;
 //BA.debugLineNum = 16777265;BA.debugLine="str_web1.Append(\"<td>\"&\"\"&ls_onvanHa.Get(0)&\" : \"";
mostCurrent._str_web1.Append("<td>"+""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (0)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool((int)(Double.parseDouble(mostCurrent._paye))))+"<br>");
RDebugUtils.currentLine=16777266;
 //BA.debugLineNum = 16777266;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(2)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (2)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maskan))+"<br>");
RDebugUtils.currentLine=16777267;
 //BA.debugLineNum = 16777267;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(3)&\" : \"&myfun";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (3)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bon))+"<br>");
RDebugUtils.currentLine=16777268;
 //BA.debugLineNum = 16777268;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(4)&\"  : \"&myfun";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (4)))+"  : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad))+"<br>");
RDebugUtils.currentLine=16777269;
 //BA.debugLineNum = 16777269;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(5)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (5)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_fani))+"<br>");
RDebugUtils.currentLine=16777270;
 //BA.debugLineNum = 16777270;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(6)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (6)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_masoliat))+"<br>");
RDebugUtils.currentLine=16777271;
 //BA.debugLineNum = 16777271;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(7)&\"  : \"&myfu";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (7)))+"  : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sarparasti))+"<br></td>");
RDebugUtils.currentLine=16777275;
 //BA.debugLineNum = 16777275;BA.debugLine="str_web1.Append(\"<td>\"&\" \"&ls_onvanHa.Get(1)&\" :";
mostCurrent._str_web1.Append("<td>"+" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (1)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat))+"<br>");
RDebugUtils.currentLine=16777276;
 //BA.debugLineNum = 16777276;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(8)&\" : \"&myfun";
mostCurrent._str_web1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (8)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_shift))+"<br>");
RDebugUtils.currentLine=16777277;
 //BA.debugLineNum = 16777277;BA.debugLine="str_web1.Append(\"بیمه تامین اجتماعی : %\"&myfunc.e";
mostCurrent._str_web1.Append("بیمه تامین اجتماعی : %"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_bime_tamin))+"<br>");
RDebugUtils.currentLine=16777278;
 //BA.debugLineNum = 16777278;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(9)&\" : \"&myfunc";
mostCurrent._str_web1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (9)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_takmil))+"<br>");
RDebugUtils.currentLine=16777279;
 //BA.debugLineNum = 16777279;BA.debugLine="str_web1.Append(\" مالیات : مطابق قانون کار<br>\")";
mostCurrent._str_web1.Append(" مالیات : مطابق قانون کار<br>");
RDebugUtils.currentLine=16777280;
 //BA.debugLineNum = 16777280;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(10)&\" : \"&myf";
mostCurrent._str_web1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (10)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya))+"<br>");
RDebugUtils.currentLine=16777281;
 //BA.debugLineNum = 16777281;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(11)&\" : \"&myf";
mostCurrent._str_web1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (11)))+" : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat))+"</td>");
RDebugUtils.currentLine=16777282;
 //BA.debugLineNum = 16777282;BA.debugLine="str_web1.Append(\"</tr></table>\")";
mostCurrent._str_web1.Append("</tr></table>");
RDebugUtils.currentLine=16777283;
 //BA.debugLineNum = 16777283;BA.debugLine="str_web1.Append(\"</body></html>\")";
mostCurrent._str_web1.Append("</body></html>");
RDebugUtils.currentLine=16777285;
 //BA.debugLineNum = 16777285;BA.debugLine="WebView1.LoadHtml(str_web1)";
mostCurrent._webview1.LoadHtml(BA.ObjectToString(mostCurrent._str_web1));
RDebugUtils.currentLine=16777289;
 //BA.debugLineNum = 16777289;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=16777290;
 //BA.debugLineNum = 16777290;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
RDebugUtils.currentLine=16777291;
 //BA.debugLineNum = 16777291;BA.debugLine="End Sub";
return "";
}
public static String  _get_data_hogogi() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_data_hogogi", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_data_hogogi", null));}
RDebugUtils.currentLine=17563648;
 //BA.debugLineNum = 17563648;BA.debugLine="Sub get_data_hogogi";
RDebugUtils.currentLine=17563650;
 //BA.debugLineNum = 17563650;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=17563651;
 //BA.debugLineNum = 17563651;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=17563653;
 //BA.debugLineNum = 17563653;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=17563654;
 //BA.debugLineNum = 17563654;BA.debugLine="paye=dbCode.res.GetString(\"value\")";
mostCurrent._paye = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value");
RDebugUtils.currentLine=17563656;
 //BA.debugLineNum = 17563656;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (1));
RDebugUtils.currentLine=17563657;
 //BA.debugLineNum = 17563657;BA.debugLine="maskan=dbCode.res.GetString(\"value\")";
_maskan = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=17563659;
 //BA.debugLineNum = 17563659;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (3));
RDebugUtils.currentLine=17563660;
 //BA.debugLineNum = 17563660;BA.debugLine="olad=dbCode.res.GetString(\"value\")";
_olad = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=17563662;
 //BA.debugLineNum = 17563662;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (4));
RDebugUtils.currentLine=17563663;
 //BA.debugLineNum = 17563663;BA.debugLine="fani=dbCode.res.GetString(\"value\")";
_fani = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=17563665;
 //BA.debugLineNum = 17563665;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (5));
RDebugUtils.currentLine=17563666;
 //BA.debugLineNum = 17563666;BA.debugLine="masoliat=dbCode.res.GetString(\"value\")";
_masoliat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=17563668;
 //BA.debugLineNum = 17563668;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (2));
RDebugUtils.currentLine=17563669;
 //BA.debugLineNum = 17563669;BA.debugLine="bon=dbCode.res.GetString(\"value\")";
_bon = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=17563671;
 //BA.debugLineNum = 17563671;BA.debugLine="dbCode.res.Position=6 ''--------bime_tamin------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (6));
RDebugUtils.currentLine=17563672;
 //BA.debugLineNum = 17563672;BA.debugLine="bime_tamin=dbCode.res.GetString(\"value\")";
_bime_tamin = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=17563674;
 //BA.debugLineNum = 17563674;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (11));
RDebugUtils.currentLine=17563675;
 //BA.debugLineNum = 17563675;BA.debugLine="bime_takmil=dbCode.res.GetString(\"value\")";
_bime_takmil = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=17563683;
 //BA.debugLineNum = 17563683;BA.debugLine="dbCode.res.Position=13 ''--------hag shift------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (13));
RDebugUtils.currentLine=17563684;
 //BA.debugLineNum = 17563684;BA.debugLine="shift=dbCode.res.GetString(\"value\")";
_shift = (double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=17563686;
 //BA.debugLineNum = 17563686;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (14));
RDebugUtils.currentLine=17563687;
 //BA.debugLineNum = 17563687;BA.debugLine="sanavat=dbCode.res.GetString(\"value\")";
_sanavat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=17563689;
 //BA.debugLineNum = 17563689;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (15));
RDebugUtils.currentLine=17563690;
 //BA.debugLineNum = 17563690;BA.debugLine="sarparasti=dbCode.res.GetString(\"value\")";
_sarparasti = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=17563692;
 //BA.debugLineNum = 17563692;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (16));
RDebugUtils.currentLine=17563693;
 //BA.debugLineNum = 17563693;BA.debugLine="mazaya=dbCode.res.GetString(\"value\")";
_mazaya = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=17563695;
 //BA.debugLineNum = 17563695;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (19));
RDebugUtils.currentLine=17563696;
 //BA.debugLineNum = 17563696;BA.debugLine="ksorat=dbCode.res.GetString(\"value\")";
_ksorat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=17563706;
 //BA.debugLineNum = 17563706;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=17563707;
 //BA.debugLineNum = 17563707;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=17563711;
 //BA.debugLineNum = 17563711;BA.debugLine="End Sub";
return "";
}
public static String  _et_time_indb() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_time_indb", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_time_indb", null));}
anywheresoftware.b4a.objects.collections.List _list_ezafekari1 = null;
anywheresoftware.b4a.objects.collections.List _list_ezafekari2 = null;
RDebugUtils.currentLine=17235968;
 //BA.debugLineNum = 17235968;BA.debugLine="Sub et_time_inDB";
RDebugUtils.currentLine=17235971;
 //BA.debugLineNum = 17235971;BA.debugLine="Select sp_moon.SelectedIndex";
switch (BA.switchObjectToInt(mostCurrent._sp_moon.getSelectedIndex(),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11))) {
case 0: {
RDebugUtils.currentLine=17235973;
 //BA.debugLineNum = 17235973;BA.debugLine="moon_num=\"01\"";
mostCurrent._moon_num = "01";
 break; }
case 1: {
RDebugUtils.currentLine=17235975;
 //BA.debugLineNum = 17235975;BA.debugLine="moon_num=\"02\"";
mostCurrent._moon_num = "02";
 break; }
case 2: {
RDebugUtils.currentLine=17235977;
 //BA.debugLineNum = 17235977;BA.debugLine="moon_num=\"03\"";
mostCurrent._moon_num = "03";
 break; }
case 3: {
RDebugUtils.currentLine=17235979;
 //BA.debugLineNum = 17235979;BA.debugLine="moon_num=\"04\"";
mostCurrent._moon_num = "04";
 break; }
case 4: {
RDebugUtils.currentLine=17235981;
 //BA.debugLineNum = 17235981;BA.debugLine="moon_num=\"05\"";
mostCurrent._moon_num = "05";
 break; }
case 5: {
RDebugUtils.currentLine=17235983;
 //BA.debugLineNum = 17235983;BA.debugLine="moon_num=\"06\"";
mostCurrent._moon_num = "06";
 break; }
case 6: {
RDebugUtils.currentLine=17235985;
 //BA.debugLineNum = 17235985;BA.debugLine="moon_num=\"07\"";
mostCurrent._moon_num = "07";
 break; }
case 7: {
RDebugUtils.currentLine=17235987;
 //BA.debugLineNum = 17235987;BA.debugLine="moon_num=\"08\"";
mostCurrent._moon_num = "08";
 break; }
case 8: {
RDebugUtils.currentLine=17235989;
 //BA.debugLineNum = 17235989;BA.debugLine="moon_num=\"09\"";
mostCurrent._moon_num = "09";
 break; }
case 9: {
RDebugUtils.currentLine=17235991;
 //BA.debugLineNum = 17235991;BA.debugLine="moon_num=\"10\"";
mostCurrent._moon_num = "10";
 break; }
case 10: {
RDebugUtils.currentLine=17235993;
 //BA.debugLineNum = 17235993;BA.debugLine="moon_num=\"11\"";
mostCurrent._moon_num = "11";
 break; }
case 11: {
RDebugUtils.currentLine=17235995;
 //BA.debugLineNum = 17235995;BA.debugLine="moon_num=\"12\"";
mostCurrent._moon_num = "12";
 break; }
}
;
RDebugUtils.currentLine=17236000;
 //BA.debugLineNum = 17236000;BA.debugLine="Dim list_ezafekari1 As List";
_list_ezafekari1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17236001;
 //BA.debugLineNum = 17236001;BA.debugLine="list_ezafekari1.Initialize";
_list_ezafekari1.Initialize();
RDebugUtils.currentLine=17236002;
 //BA.debugLineNum = 17236002;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_mah(sp_year.";
_list_ezafekari1 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num,(int) (2));
RDebugUtils.currentLine=17236003;
 //BA.debugLineNum = 17236003;BA.debugLine="et_time_h.Text=list_ezafekari1.Get(0)";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (0))));
RDebugUtils.currentLine=17236004;
 //BA.debugLineNum = 17236004;BA.debugLine="et_time_m.Text=list_ezafekari1.Get(1)";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (1))));
RDebugUtils.currentLine=17236007;
 //BA.debugLineNum = 17236007;BA.debugLine="Dim list_ezafekari2 As List";
_list_ezafekari2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17236008;
 //BA.debugLineNum = 17236008;BA.debugLine="list_ezafekari2.Initialize";
_list_ezafekari2.Initialize();
RDebugUtils.currentLine=17236009;
 //BA.debugLineNum = 17236009;BA.debugLine="list_ezafekari2=dbCode.all_ezafekari_mah(sp_year.";
_list_ezafekari2 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num,(int) (3));
RDebugUtils.currentLine=17236010;
 //BA.debugLineNum = 17236010;BA.debugLine="et_time_h_vij.Text=list_ezafekari2.Get(0)";
mostCurrent._et_time_h_vij.setText(BA.ObjectToCharSequence(_list_ezafekari2.Get((int) (0))));
RDebugUtils.currentLine=17236011;
 //BA.debugLineNum = 17236011;BA.debugLine="et_time_m_vij.Text=list_ezafekari2.Get(1)";
mostCurrent._et_time_m_vij.setText(BA.ObjectToCharSequence(_list_ezafekari2.Get((int) (1))));
RDebugUtils.currentLine=17236015;
 //BA.debugLineNum = 17236015;BA.debugLine="If(moon_num<7)Then";
if (((double)(Double.parseDouble(mostCurrent._moon_num))<7)) { 
RDebugUtils.currentLine=17236016;
 //BA.debugLineNum = 17236016;BA.debugLine="roze_kari=31";
_roze_kari = (int) (31);
 }else {
RDebugUtils.currentLine=17236018;
 //BA.debugLineNum = 17236018;BA.debugLine="roze_kari=30";
_roze_kari = (int) (30);
 };
RDebugUtils.currentLine=17236020;
 //BA.debugLineNum = 17236020;BA.debugLine="et_rozekari.Text=roze_kari";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(_roze_kari));
RDebugUtils.currentLine=17236021;
 //BA.debugLineNum = 17236021;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(int _num) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_num_pool", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_num_pool", new Object[] {_num}));}
RDebugUtils.currentLine=17170432;
 //BA.debugLineNum = 17170432;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=17170433;
 //BA.debugLineNum = 17170433;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
RDebugUtils.currentLine=17170434;
 //BA.debugLineNum = 17170434;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "calc_vahed_ezafekari", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "calc_vahed_ezafekari", null));}
RDebugUtils.currentLine=16842752;
 //BA.debugLineNum = 16842752;BA.debugLine="Sub calc_vahed_ezafekari";
RDebugUtils.currentLine=16842754;
 //BA.debugLineNum = 16842754;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=16842757;
 //BA.debugLineNum = 16842757;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=16842760;
 //BA.debugLineNum = 16842760;BA.debugLine="vahed_ezafekari=((paye+sanavat)/220)*1.4";
_vahed_ezafekari = (int) ((((double)(Double.parseDouble(mostCurrent._paye))+_sanavat)/(double)220)*1.4);
RDebugUtils.currentLine=16842763;
 //BA.debugLineNum = 16842763;BA.debugLine="et_vahed_ezafekari.Tag=vahed_ezafekari";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_vahed_ezafekari));
RDebugUtils.currentLine=16842764;
 //BA.debugLineNum = 16842764;BA.debugLine="et_vahed_ezafekari.Text=myfunc.show_num_pool(vahe";
mostCurrent._et_vahed_ezafekari.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari)));
RDebugUtils.currentLine=16842767;
 //BA.debugLineNum = 16842767;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari_vij() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "calc_vahed_ezafekari_vij", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "calc_vahed_ezafekari_vij", null));}
RDebugUtils.currentLine=16908288;
 //BA.debugLineNum = 16908288;BA.debugLine="Sub calc_vahed_ezafekari_vij";
RDebugUtils.currentLine=16908290;
 //BA.debugLineNum = 16908290;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=16908293;
 //BA.debugLineNum = 16908293;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=16908296;
 //BA.debugLineNum = 16908296;BA.debugLine="vahed_ezafekari_vij=((paye+sanavat)/220)*1.8";
_vahed_ezafekari_vij = (int) ((((double)(Double.parseDouble(mostCurrent._paye))+_sanavat)/(double)220)*1.8);
RDebugUtils.currentLine=16908299;
 //BA.debugLineNum = 16908299;BA.debugLine="et_vahed_ezafekari_vij.Tag=vahed_ezafekari_vij";
mostCurrent._et_vahed_ezafekari_vij.setTag((Object)(_vahed_ezafekari_vij));
RDebugUtils.currentLine=16908300;
 //BA.debugLineNum = 16908300;BA.debugLine="et_vahed_ezafekari_vij.Text=myfunc.show_num_pool(";
mostCurrent._et_vahed_ezafekari_vij.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari_vij)));
RDebugUtils.currentLine=16908302;
 //BA.debugLineNum = 16908302;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=17498112;
 //BA.debugLineNum = 17498112;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=17498113;
 //BA.debugLineNum = 17498113;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=17498114;
 //BA.debugLineNum = 17498114;BA.debugLine="If(pan_mohasebat.Visible=True)Then";
if ((mostCurrent._pan_mohasebat.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=17498115;
 //BA.debugLineNum = 17498115;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
mostCurrent._pan_mohasebat.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=17498117;
 //BA.debugLineNum = 17498117;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
RDebugUtils.currentLine=17498120;
 //BA.debugLineNum = 17498120;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=17498122;
 //BA.debugLineNum = 17498122;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=17498124;
 //BA.debugLineNum = 17498124;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=17432576;
 //BA.debugLineNum = 17432576;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=17432577;
 //BA.debugLineNum = 17432577;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=17432578;
 //BA.debugLineNum = 17432578;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=17432579;
 //BA.debugLineNum = 17432579;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="hogog_activity";
RDebugUtils.currentLine=17367040;
 //BA.debugLineNum = 17367040;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=17367042;
 //BA.debugLineNum = 17367042;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=17301504;
 //BA.debugLineNum = 17301504;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=17301506;
 //BA.debugLineNum = 17301506;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_vahed_ezafekari_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_vahed_ezafekari_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=16973824;
 //BA.debugLineNum = 16973824;BA.debugLine="Private Sub et_vahed_ezafekari_TextChanged (Old As";
RDebugUtils.currentLine=16973825;
 //BA.debugLineNum = 16973825;BA.debugLine="et_vahed_ezafekari.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=16973826;
 //BA.debugLineNum = 16973826;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari);
RDebugUtils.currentLine=16973827;
 //BA.debugLineNum = 16973827;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_vij_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_vahed_ezafekari_vij_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_vahed_ezafekari_vij_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=17039360;
 //BA.debugLineNum = 17039360;BA.debugLine="Private Sub et_vahed_ezafekari_vij_TextChanged (Ol";
RDebugUtils.currentLine=17039361;
 //BA.debugLineNum = 17039361;BA.debugLine="et_vahed_ezafekari_vij.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari_vij.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=17039362;
 //BA.debugLineNum = 17039362;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari_vij);
RDebugUtils.currentLine=17039363;
 //BA.debugLineNum = 17039363;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_backto_hogog_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_backto_hogog_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_backto_hogog_click", null));}
RDebugUtils.currentLine=18087936;
 //BA.debugLineNum = 18087936;BA.debugLine="Private Sub lbl_backTo_hogog_Click";
RDebugUtils.currentLine=18087938;
 //BA.debugLineNum = 18087938;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
mostCurrent._pan_mohasebat.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=18087939;
 //BA.debugLineNum = 18087939;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_tatil_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_tatil_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_tatil_click", null));}
RDebugUtils.currentLine=18546688;
 //BA.debugLineNum = 18546688;BA.debugLine="Private Sub lbl_help_tatil_Click";
RDebugUtils.currentLine=18546690;
 //BA.debugLineNum = 18546690;BA.debugLine="myfunc.help_man(\"روزهای جمعه که برای آن روز دیگری";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"روزهای جمعه که برای آن روز دیگری را تعطیل نکنند، اضافه کاری فوق العاده محسوب و با ضریب 1.8 محاسبه می شود.");
RDebugUtils.currentLine=18546691;
 //BA.debugLineNum = 18546691;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_print_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_print_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_print_click", null));}
RDebugUtils.currentLine=18677760;
 //BA.debugLineNum = 18677760;BA.debugLine="Private Sub lbl_print_Click";
RDebugUtils.currentLine=18677762;
 //BA.debugLineNum = 18677762;BA.debugLine="printer.Initialize(\"\")";
mostCurrent._printer.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=18677765;
 //BA.debugLineNum = 18677765;BA.debugLine="printer.PrintWebView(\"job\",WebView2)";
mostCurrent._printer.PrintWebView("job",(android.webkit.WebView)(mostCurrent._webview2.getObject()));
RDebugUtils.currentLine=18677766;
 //BA.debugLineNum = 18677766;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_refresh_vahed_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_refresh_vahed_click", null));}
RDebugUtils.currentLine=18415616;
 //BA.debugLineNum = 18415616;BA.debugLine="Private Sub lbl_refresh_vahed_Click";
RDebugUtils.currentLine=18415617;
 //BA.debugLineNum = 18415617;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=18415618;
 //BA.debugLineNum = 18415618;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_vij_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_refresh_vahed_vij_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_refresh_vahed_vij_click", null));}
RDebugUtils.currentLine=18481152;
 //BA.debugLineNum = 18481152;BA.debugLine="Private Sub lbl_refresh_vahed_vij_Click";
RDebugUtils.currentLine=18481153;
 //BA.debugLineNum = 18481153;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
RDebugUtils.currentLine=18481154;
 //BA.debugLineNum = 18481154;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run_mohasebe_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_run_mohasebe_click", null));}
anywheresoftware.b4a.objects.collections.List _list_morakhasi = null;
RDebugUtils.currentLine=17629184;
 //BA.debugLineNum = 17629184;BA.debugLine="Private Sub lbl_run_mohasebe_Click";
RDebugUtils.currentLine=17629185;
 //BA.debugLineNum = 17629185;BA.debugLine="If(et_rozekari.Text=\"\")Then";
if (((mostCurrent._et_rozekari.getText()).equals(""))) { 
RDebugUtils.currentLine=17629186;
 //BA.debugLineNum = 17629186;BA.debugLine="et_rozekari.Text=0";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=17629189;
 //BA.debugLineNum = 17629189;BA.debugLine="roze_kari=et_rozekari.Text";
_roze_kari = (int)(Double.parseDouble(mostCurrent._et_rozekari.getText()));
RDebugUtils.currentLine=17629191;
 //BA.debugLineNum = 17629191;BA.debugLine="If(et_time_h.Text=\"\")Then";
if (((mostCurrent._et_time_h.getText()).equals(""))) { 
RDebugUtils.currentLine=17629192;
 //BA.debugLineNum = 17629192;BA.debugLine="et_time_h.Text=0";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=17629194;
 //BA.debugLineNum = 17629194;BA.debugLine="If(et_time_m.Text=\"\")Then";
if (((mostCurrent._et_time_m.getText()).equals(""))) { 
RDebugUtils.currentLine=17629195;
 //BA.debugLineNum = 17629195;BA.debugLine="et_time_m.Text=0";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=17629198;
 //BA.debugLineNum = 17629198;BA.debugLine="If(et_time_h_vij.Text=\"\")Then";
if (((mostCurrent._et_time_h_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=17629199;
 //BA.debugLineNum = 17629199;BA.debugLine="et_time_h_vij.Text=0";
mostCurrent._et_time_h_vij.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=17629201;
 //BA.debugLineNum = 17629201;BA.debugLine="If(et_time_m_vij.Text=\"\")Then";
if (((mostCurrent._et_time_m_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=17629202;
 //BA.debugLineNum = 17629202;BA.debugLine="et_time_m_vij.Text=0";
mostCurrent._et_time_m_vij.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=17629207;
 //BA.debugLineNum = 17629207;BA.debugLine="If(et_vahed_ezafekari.Text=\"\")Then";
if (((mostCurrent._et_vahed_ezafekari.getText()).equals(""))) { 
RDebugUtils.currentLine=17629208;
 //BA.debugLineNum = 17629208;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
 };
RDebugUtils.currentLine=17629210;
 //BA.debugLineNum = 17629210;BA.debugLine="If(et_vahed_ezafekari_vij.Text=\"\")Then";
if (((mostCurrent._et_vahed_ezafekari_vij.getText()).equals(""))) { 
RDebugUtils.currentLine=17629211;
 //BA.debugLineNum = 17629211;BA.debugLine="calc_vahed_ezafekari_vij";
_calc_vahed_ezafekari_vij();
 };
RDebugUtils.currentLine=17629215;
 //BA.debugLineNum = 17629215;BA.debugLine="If (roze_kari > 31 Or roze_kari < 0)Then";
if ((_roze_kari>31 || _roze_kari<0)) { 
RDebugUtils.currentLine=17629216;
 //BA.debugLineNum = 17629216;BA.debugLine="ToastMessageShow(\" تعداد روز کاری نادرست است\",Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" تعداد روز کاری نادرست است"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=17629218;
 //BA.debugLineNum = 17629218;BA.debugLine="pan_mohasebat.Visible=True";
mostCurrent._pan_mohasebat.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=17629219;
 //BA.debugLineNum = 17629219;BA.debugLine="pan_mohasebat.SetLayoutAnimated(100,0,0,100%x,10";
mostCurrent._pan_mohasebat.SetLayoutAnimated((int) (100),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=17629220;
 //BA.debugLineNum = 17629220;BA.debugLine="mohasebe";
_mohasebe();
 };
RDebugUtils.currentLine=17629227;
 //BA.debugLineNum = 17629227;BA.debugLine="str1.Initialize";
mostCurrent._str1.Initialize();
RDebugUtils.currentLine=17629229;
 //BA.debugLineNum = 17629229;BA.debugLine="str1.Append(\"<!DOCTYPE html><html dir='rtl' lang=";
mostCurrent._str1.Append("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>");
RDebugUtils.currentLine=17629230;
 //BA.debugLineNum = 17629230;BA.debugLine="str1.Append(\"<style>table , td {border: 1px solid";
mostCurrent._str1.Append("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	summary {	font-weight: bold;	margin: -.5em -.5em 0;	padding: .5em;} details[open] {	padding: .5em;	}	details[open] summary {border-bottom: 1px solid #aaa;margin-bottom: .5em;}</style>");
RDebugUtils.currentLine=17629234;
 //BA.debugLineNum = 17629234;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=17629235;
 //BA.debugLineNum = 17629235;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+mostCurrent._sp_year.getSelectedItem()+"/"+mostCurrent._moon_num+"%';")));
RDebugUtils.currentLine=17629237;
 //BA.debugLineNum = 17629237;BA.debugLine="str1.Append(\"<h3>\").Append(\"گزارش \"& sp_moon.Sele";
mostCurrent._str1.Append("<h3>").Append("گزارش "+mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem())).Append("</h3>");
RDebugUtils.currentLine=17629240;
 //BA.debugLineNum = 17629240;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f5";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5;'><details>");
RDebugUtils.currentLine=17629242;
 //BA.debugLineNum = 17629242;BA.debugLine="str1.Append(\"<summary><b> اضافه کاری های این ماه<";
mostCurrent._str1.Append("<summary><b> اضافه کاری های این ماه</b></summary>");
RDebugUtils.currentLine=17629243;
 //BA.debugLineNum = 17629243;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr style";
mostCurrent._str1.Append("<table style='width:100%;'><tr style='text-align: center;'>");
RDebugUtils.currentLine=17629244;
 //BA.debugLineNum = 17629244;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ</";
mostCurrent._str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td><br></tr>");
RDebugUtils.currentLine=17629246;
 //BA.debugLineNum = 17629246;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=17629247;
 //BA.debugLineNum = 17629247;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
mostCurrent._str1.Append("<tr style='text-align: center;'>");
RDebugUtils.currentLine=17629248;
 //BA.debugLineNum = 17629248;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
RDebugUtils.currentLine=17629249;
 //BA.debugLineNum = 17629249;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
RDebugUtils.currentLine=17629250;
 //BA.debugLineNum = 17629250;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
RDebugUtils.currentLine=17629252;
 //BA.debugLineNum = 17629252;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=17629253;
 //BA.debugLineNum = 17629253;BA.debugLine="str1.Append(myfunc.en2fa((dbCode.res.GetString(\"";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(((double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")))+((double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")))*24)))));
RDebugUtils.currentLine=17629254;
 //BA.debugLineNum = 17629254;BA.debugLine="str1.Append(\":\")";
mostCurrent._str1.Append(":");
RDebugUtils.currentLine=17629255;
 //BA.debugLineNum = 17629255;BA.debugLine="str1.Append(myfunc.en2fa(dbCode.res.GetString(\"e";
mostCurrent._str1.Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))).Append("</td>");
RDebugUtils.currentLine=17629257;
 //BA.debugLineNum = 17629257;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
 }
;
RDebugUtils.currentLine=17629260;
 //BA.debugLineNum = 17629260;BA.debugLine="str1.Append(\"</table>\")";
mostCurrent._str1.Append("</table>");
RDebugUtils.currentLine=17629261;
 //BA.debugLineNum = 17629261;BA.debugLine="str1.Append(\"مجموع ساعت اضافه کاری :<span style='";
mostCurrent._str1.Append("مجموع ساعت اضافه کاری :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h.getText())+" ساعت و"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m.getText())+"دقیقه </span><br></details></div><br> ");
RDebugUtils.currentLine=17629267;
 //BA.debugLineNum = 17629267;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+mostCurrent._sp_year.getSelectedItem()+"/"+mostCurrent._moon_num+"%';")));
RDebugUtils.currentLine=17629269;
 //BA.debugLineNum = 17629269;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f5";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5 ;'><details>");
RDebugUtils.currentLine=17629270;
 //BA.debugLineNum = 17629270;BA.debugLine="str1.Append(\"<summary><b> مرخصی های این ماه</b></";
mostCurrent._str1.Append("<summary><b> مرخصی های این ماه</b></summary>");
RDebugUtils.currentLine=17629271;
 //BA.debugLineNum = 17629271;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr style";
mostCurrent._str1.Append("<table style='width:100%;'><tr style='text-align: center;'>");
RDebugUtils.currentLine=17629272;
 //BA.debugLineNum = 17629272;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ</";
mostCurrent._str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b>زمان/روز</b></td><td><b> زمان/ساعت</b></td><br></tr>");
RDebugUtils.currentLine=17629274;
 //BA.debugLineNum = 17629274;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=17629275;
 //BA.debugLineNum = 17629275;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
mostCurrent._str1.Append("<tr style='text-align: center;'>");
RDebugUtils.currentLine=17629276;
 //BA.debugLineNum = 17629276;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode.";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getPosition())+1))).Append("</td>");
RDebugUtils.currentLine=17629277;
 //BA.debugLineNum = 17629277;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date_to"))).Append("</td>");
RDebugUtils.currentLine=17629278;
 //BA.debugLineNum = 17629278;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
mostCurrent._str1.Append("<td>").Append(mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_from"))+" - "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("time_to"))).Append("</td>");
RDebugUtils.currentLine=17629279;
 //BA.debugLineNum = 17629279;BA.debugLine="str1.Append(\"<td>\").Append((myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append((mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d")))).Append("</td>");
RDebugUtils.currentLine=17629280;
 //BA.debugLineNum = 17629280;BA.debugLine="str1.Append(\"<td>\").Append((myfunc.en2fa(dbCode.";
mostCurrent._str1.Append("<td>").Append((mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h")))+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))).Append("</td>");
RDebugUtils.currentLine=17629282;
 //BA.debugLineNum = 17629282;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
 }
;
RDebugUtils.currentLine=17629287;
 //BA.debugLineNum = 17629287;BA.debugLine="str1.Append(\"</table>\")";
mostCurrent._str1.Append("</table>");
RDebugUtils.currentLine=17629289;
 //BA.debugLineNum = 17629289;BA.debugLine="Dim list_morakhasi As List";
_list_morakhasi = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17629290;
 //BA.debugLineNum = 17629290;BA.debugLine="list_morakhasi.Initialize";
_list_morakhasi.Initialize();
RDebugUtils.currentLine=17629292;
 //BA.debugLineNum = 17629292;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(sp_year.S";
_list_morakhasi = mostCurrent._dbcode._all_morakhasi_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._sp_year.getSelectedItem(),mostCurrent._moon_num);
RDebugUtils.currentLine=17629294;
 //BA.debugLineNum = 17629294;BA.debugLine="str1.Append(\"مجموع مرخصی ها :<span style='color:#";
mostCurrent._str1.Append("مجموع مرخصی ها :<span style='color:#5E35B1;'><b> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (0))))+" روز و "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (1))))+" ساعت و "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.ObjectToString(_list_morakhasi.Get((int) (2))))+" دقیقه ");
RDebugUtils.currentLine=17629296;
 //BA.debugLineNum = 17629296;BA.debugLine="str1.Append(\"</b></span><br></details></div><br>\"";
mostCurrent._str1.Append("</b></span><br></details></div><br>");
RDebugUtils.currentLine=17629302;
 //BA.debugLineNum = 17629302;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f5";
mostCurrent._str1.Append("<div style=' background-color: #f5f5f5 ;' ><details open>");
RDebugUtils.currentLine=17629303;
 //BA.debugLineNum = 17629303;BA.debugLine="str1.Append(\"<summary><b>محاسبه حقوق</b></summary";
mostCurrent._str1.Append("<summary><b>محاسبه حقوق</b></summary>");
RDebugUtils.currentLine=17629305;
 //BA.debugLineNum = 17629305;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr>\")";
mostCurrent._str1.Append("<table style='width:100%;'><tr>");
RDebugUtils.currentLine=17629306;
 //BA.debugLineNum = 17629306;BA.debugLine="str1.Append(\"<td><div style='text-align: center;c";
mostCurrent._str1.Append("<td><div style='text-align: center;color:#661400;'><b> مزایا</b></div></td>");
RDebugUtils.currentLine=17629307;
 //BA.debugLineNum = 17629307;BA.debugLine="str1.Append(\"<td><div style='text-align: center;c";
mostCurrent._str1.Append("<td><div style='text-align: center;color:#661400;'><b>کسورات</b></div></td> </tr>");
RDebugUtils.currentLine=17629308;
 //BA.debugLineNum = 17629308;BA.debugLine="str1.Append(\"<tr style='vertical-align: text-top;";
mostCurrent._str1.Append("<tr style='vertical-align: text-top;'><td>");
RDebugUtils.currentLine=17629309;
 //BA.debugLineNum = 17629309;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(0)&\" برای \"&myfunc.";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (0)))+" برای "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_roze_kari))+" روز کاری : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_paye_end))+"</span><br>");
RDebugUtils.currentLine=17629310;
 //BA.debugLineNum = 17629310;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(2)&\" : <span style=";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (2)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maskan_end))+"</span><br>");
RDebugUtils.currentLine=17629311;
 //BA.debugLineNum = 17629311;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(3)&\" : <span style";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (3)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bon_end))+"</span><br>");
RDebugUtils.currentLine=17629312;
 //BA.debugLineNum = 17629312;BA.debugLine="If(olad_end<>0)Then";
if ((_olad_end!=0)) { 
RDebugUtils.currentLine=17629313;
 //BA.debugLineNum = 17629313;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(4)&\"  :<span style";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (4)))+"  :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad_end))+"</span><br>");
 };
RDebugUtils.currentLine=17629315;
 //BA.debugLineNum = 17629315;BA.debugLine="If(sanavat_end<>0)Then";
if ((_sanavat_end!=0)) { 
RDebugUtils.currentLine=17629316;
 //BA.debugLineNum = 17629316;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(1)&\"  : <span styl";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (1)))+"  : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat_end))+"</span><br>");
 };
RDebugUtils.currentLine=17629318;
 //BA.debugLineNum = 17629318;BA.debugLine="If(fani_end<>0)Then";
if ((_fani_end!=0)) { 
RDebugUtils.currentLine=17629319;
 //BA.debugLineNum = 17629319;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(5)&\" : <span style";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (5)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_fani_end))+"</span><br>");
 };
RDebugUtils.currentLine=17629321;
 //BA.debugLineNum = 17629321;BA.debugLine="If(masoliat_end<>0)Then";
if ((_masoliat_end!=0)) { 
RDebugUtils.currentLine=17629322;
 //BA.debugLineNum = 17629322;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(6)&\" : <span style";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (6)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_masoliat_end))+"</span><br>");
 };
RDebugUtils.currentLine=17629324;
 //BA.debugLineNum = 17629324;BA.debugLine="If(sarparasti_end<>0)Then";
if ((_sarparasti_end!=0)) { 
RDebugUtils.currentLine=17629325;
 //BA.debugLineNum = 17629325;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(7)&\" : <span styl";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (7)))+" : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sarparasti_end))+"</span><br>");
 };
RDebugUtils.currentLine=17629327;
 //BA.debugLineNum = 17629327;BA.debugLine="If(shift_end<>0)Then";
if ((_shift_end!=0)) { 
RDebugUtils.currentLine=17629328;
 //BA.debugLineNum = 17629328;BA.debugLine="str1.Append(\" حق شیفت \"&myfunc.en2fa(shift)&\" در";
mostCurrent._str1.Append(" حق شیفت "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,BA.NumberToString(_shift))+" درصد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_shift_end))+"</span><br>");
 };
RDebugUtils.currentLine=17629330;
 //BA.debugLineNum = 17629330;BA.debugLine="If(mazaya_end<>0)Then";
if ((_mazaya_end!=0)) { 
RDebugUtils.currentLine=17629331;
 //BA.debugLineNum = 17629331;BA.debugLine="str1.Append(\"  \"&ls_onvanHa.Get(10)&\" : <span st";
mostCurrent._str1.Append("  "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (10)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya_end))+"</span><br>");
 };
RDebugUtils.currentLine=17629337;
 //BA.debugLineNum = 17629337;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=17629338;
 //BA.debugLineNum = 17629338;BA.debugLine="str1.Append(\"اضافه کاری عادی\").Append(\"<br>\")";
mostCurrent._str1.Append("اضافه کاری عادی").Append("<br>");
RDebugUtils.currentLine=17629340;
 //BA.debugLineNum = 17629340;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B1";
mostCurrent._str1.Append(" ساعات : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h.getText())+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m.getText())+"</span><br>");
RDebugUtils.currentLine=17629342;
 //BA.debugLineNum = 17629342;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5E";
mostCurrent._str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_vahed_ezafekari))+"</span><br>");
RDebugUtils.currentLine=17629348;
 //BA.debugLineNum = 17629348;BA.debugLine="If(ezafekari_end_vij<>0)Then";
if ((_ezafekari_end_vij!=0)) { 
RDebugUtils.currentLine=17629349;
 //BA.debugLineNum = 17629349;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=17629351;
 //BA.debugLineNum = 17629351;BA.debugLine="str1.Append(\"اضافه کاری <span style='color:#ff4d0";
mostCurrent._str1.Append("اضافه کاری <span style='color:#ff4d00;'>"+"فوق العاده"+"</span>").Append("<br>");
RDebugUtils.currentLine=17629353;
 //BA.debugLineNum = 17629353;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B1;";
mostCurrent._str1.Append(" ساعات : <span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_h_vij.getText())+":"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_time_m_vij.getText())+"</span><br>");
RDebugUtils.currentLine=17629356;
 //BA.debugLineNum = 17629356;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5E3";
mostCurrent._str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_vahed_ezafekari_vij))+"</span><br>");
 };
RDebugUtils.currentLine=17629360;
 //BA.debugLineNum = 17629360;BA.debugLine="str1.Append(\"<hr>\")";
mostCurrent._str1.Append("<hr>");
RDebugUtils.currentLine=17629361;
 //BA.debugLineNum = 17629361;BA.debugLine="str1.Append(\"مجموع اضافه کاری : <span style='colo";
mostCurrent._str1.Append("مجموع اضافه کاری : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool((int) (_ezafekari_end+_ezafekari_end_vij)))+"</span><br></td>");
RDebugUtils.currentLine=17629364;
 //BA.debugLineNum = 17629364;BA.debugLine="str1.Append(\"<td>\")";
mostCurrent._str1.Append("<td>");
RDebugUtils.currentLine=17629365;
 //BA.debugLineNum = 17629365;BA.debugLine="str1.Append(\"بیمه تامین اجتماعی \"&myfunc.en2fa(sh";
mostCurrent._str1.Append("بیمه تامین اجتماعی "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_tamin))+" درصد : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_tamin_end))+"</span><br>");
RDebugUtils.currentLine=17629367;
 //BA.debugLineNum = 17629367;BA.debugLine="If(bime_takmil<>0)Then";
if ((_bime_takmil!=0)) { 
RDebugUtils.currentLine=17629368;
 //BA.debugLineNum = 17629368;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(9)&\" :<span style=";
mostCurrent._str1.Append(""+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (9)))+" :<span style='color:#5E35B1;'> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_takmil))+"</span><br>");
 };
RDebugUtils.currentLine=17629371;
 //BA.debugLineNum = 17629371;BA.debugLine="If(maliat_end<>0)Then";
if ((_maliat_end!=0)) { 
RDebugUtils.currentLine=17629372;
 //BA.debugLineNum = 17629372;BA.debugLine="str1.Append(\" مالیات : <span style='color:#5E35B";
mostCurrent._str1.Append(" مالیات : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maliat_end))+"</span><br>");
 };
RDebugUtils.currentLine=17629374;
 //BA.debugLineNum = 17629374;BA.debugLine="If(ksorat<>0)Then";
if ((_ksorat!=0)) { 
RDebugUtils.currentLine=17629375;
 //BA.debugLineNum = 17629375;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(11)&\" : <span sty";
mostCurrent._str1.Append(" "+BA.ObjectToString(mostCurrent._ls_onvanha.Get((int) (11)))+" : <span style='color:#5E35B1;'>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat))+"</span></td>");
 };
RDebugUtils.currentLine=17629378;
 //BA.debugLineNum = 17629378;BA.debugLine="str1.Append(\"</tr>\")";
mostCurrent._str1.Append("</tr>");
RDebugUtils.currentLine=17629380;
 //BA.debugLineNum = 17629380;BA.debugLine="str1.Append(\"<tr><td>\")";
mostCurrent._str1.Append("<tr><td>");
RDebugUtils.currentLine=17629381;
 //BA.debugLineNum = 17629381;BA.debugLine="str1.Append(\"جمع مزایا :  <span style='color:#5E3";
mostCurrent._str1.Append("جمع مزایا :  <span style='color:#5E35B1;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_nakhales))+"</b></span>");
RDebugUtils.currentLine=17629382;
 //BA.debugLineNum = 17629382;BA.debugLine="str1.Append(\"</td><td>\")";
mostCurrent._str1.Append("</td><td>");
RDebugUtils.currentLine=17629384;
 //BA.debugLineNum = 17629384;BA.debugLine="str1.Append(\"جمع کسورات :  <span style='color:#5E";
mostCurrent._str1.Append("جمع کسورات :  <span style='color:#5E35B1;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_jame_kosorat))+"</b></span>");
RDebugUtils.currentLine=17629385;
 //BA.debugLineNum = 17629385;BA.debugLine="str1.Append(\"</td></tr></table><br>\")";
mostCurrent._str1.Append("</td></tr></table><br>");
RDebugUtils.currentLine=17629387;
 //BA.debugLineNum = 17629387;BA.debugLine="str1.Append(\" دریافتی خالص :  <span style='color:";
mostCurrent._str1.Append(" دریافتی خالص :  <span style='color:#388E3C;'><b>"+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_khales))+" </b></span></b>");
RDebugUtils.currentLine=17629388;
 //BA.debugLineNum = 17629388;BA.debugLine="str1.Append(\"<span style='font-size: 11px;'> توما";
mostCurrent._str1.Append("<span style='font-size: 11px;'> تومان </span>");
RDebugUtils.currentLine=17629390;
 //BA.debugLineNum = 17629390;BA.debugLine="str1.Append(\"<br></details></div>\")";
mostCurrent._str1.Append("<br></details></div>");
RDebugUtils.currentLine=17629392;
 //BA.debugLineNum = 17629392;BA.debugLine="str1.Append(\"<footer style=' text-align: center;";
mostCurrent._str1.Append("<footer style=' text-align: center; '><h6> اپلیکیشن اضافه کاری من </h6></footer>");
RDebugUtils.currentLine=17629394;
 //BA.debugLineNum = 17629394;BA.debugLine="str1.Append(\"</body></html>\")";
mostCurrent._str1.Append("</body></html>");
RDebugUtils.currentLine=17629396;
 //BA.debugLineNum = 17629396;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=17629397;
 //BA.debugLineNum = 17629397;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=17629402;
 //BA.debugLineNum = 17629402;BA.debugLine="WebView2.LoadHtml(str1.ToString)";
mostCurrent._webview2.LoadHtml(mostCurrent._str1.ToString());
RDebugUtils.currentLine=17629403;
 //BA.debugLineNum = 17629403;BA.debugLine="End Sub";
return "";
}
public static String  _mohasebe() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mohasebe", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "mohasebe", null));}
int _nak_mal = 0;
RDebugUtils.currentLine=17694720;
 //BA.debugLineNum = 17694720;BA.debugLine="Sub mohasebe";
RDebugUtils.currentLine=17694724;
 //BA.debugLineNum = 17694724;BA.debugLine="paye_end=(paye/30)*roze_kari";
_paye_end = (int) (((double)(Double.parseDouble(mostCurrent._paye))/(double)30)*_roze_kari);
RDebugUtils.currentLine=17694727;
 //BA.debugLineNum = 17694727;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
_sanavat_end = (int) ((_sanavat/(double)30)*_roze_kari);
RDebugUtils.currentLine=17694734;
 //BA.debugLineNum = 17694734;BA.debugLine="If (roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=17694735;
 //BA.debugLineNum = 17694735;BA.debugLine="maskan_end=(maskan/30)*roze_kari";
_maskan_end = (int) ((_maskan/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=17694737;
 //BA.debugLineNum = 17694737;BA.debugLine="maskan_end=maskan";
_maskan_end = _maskan;
 };
RDebugUtils.currentLine=17694742;
 //BA.debugLineNum = 17694742;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=17694743;
 //BA.debugLineNum = 17694743;BA.debugLine="bon_end=(bon/30)*roze_kari";
_bon_end = (int) ((_bon/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=17694745;
 //BA.debugLineNum = 17694745;BA.debugLine="bon_end=bon";
_bon_end = _bon;
 };
RDebugUtils.currentLine=17694750;
 //BA.debugLineNum = 17694750;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=17694751;
 //BA.debugLineNum = 17694751;BA.debugLine="olad_end=(olad/30)*roze_kari";
_olad_end = (int) ((_olad/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=17694753;
 //BA.debugLineNum = 17694753;BA.debugLine="olad_end=olad";
_olad_end = _olad;
 };
RDebugUtils.currentLine=17694758;
 //BA.debugLineNum = 17694758;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=17694759;
 //BA.debugLineNum = 17694759;BA.debugLine="fani_end=(fani/30)*roze_kari";
_fani_end = (int) ((_fani/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=17694761;
 //BA.debugLineNum = 17694761;BA.debugLine="fani_end=fani";
_fani_end = _fani;
 };
RDebugUtils.currentLine=17694765;
 //BA.debugLineNum = 17694765;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=17694766;
 //BA.debugLineNum = 17694766;BA.debugLine="masoliat_end=(masoliat/30)*roze_kari";
_masoliat_end = (int) ((_masoliat/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=17694768;
 //BA.debugLineNum = 17694768;BA.debugLine="masoliat_end=masoliat";
_masoliat_end = _masoliat;
 };
RDebugUtils.currentLine=17694772;
 //BA.debugLineNum = 17694772;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=17694773;
 //BA.debugLineNum = 17694773;BA.debugLine="sarparasti_end=(sarparasti/30)*roze_kari";
_sarparasti_end = (int) ((_sarparasti/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=17694775;
 //BA.debugLineNum = 17694775;BA.debugLine="sarparasti_end=sarparasti";
_sarparasti_end = _sarparasti;
 };
RDebugUtils.currentLine=17694779;
 //BA.debugLineNum = 17694779;BA.debugLine="If(roze_kari<30)Then";
if ((_roze_kari<30)) { 
RDebugUtils.currentLine=17694780;
 //BA.debugLineNum = 17694780;BA.debugLine="mazaya_end=(mazaya/30)*roze_kari";
_mazaya_end = (int) ((_mazaya/(double)30)*_roze_kari);
 }else {
RDebugUtils.currentLine=17694782;
 //BA.debugLineNum = 17694782;BA.debugLine="mazaya_end=mazaya";
_mazaya_end = _mazaya;
 };
RDebugUtils.currentLine=17694786;
 //BA.debugLineNum = 17694786;BA.debugLine="shift_end=((paye_end+sanavat_end)*shift)/100";
_shift_end = (int) (((_paye_end+_sanavat_end)*_shift)/(double)100);
RDebugUtils.currentLine=17694789;
 //BA.debugLineNum = 17694789;BA.debugLine="vahed_ezafekari=et_vahed_ezafekari.Tag";
_vahed_ezafekari = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari.getTag()));
RDebugUtils.currentLine=17694790;
 //BA.debugLineNum = 17694790;BA.debugLine="ezafekari_end=vahed_ezafekari*(et_time_h.Text+(et";
_ezafekari_end = (int) (_vahed_ezafekari*((double)(Double.parseDouble(mostCurrent._et_time_h.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m.getText()))/(double)60)));
RDebugUtils.currentLine=17694794;
 //BA.debugLineNum = 17694794;BA.debugLine="vahed_ezafekari_vij=et_vahed_ezafekari_vij.Tag";
_vahed_ezafekari_vij = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari_vij.getTag()));
RDebugUtils.currentLine=17694795;
 //BA.debugLineNum = 17694795;BA.debugLine="ezafekari_end_vij=vahed_ezafekari_vij*(et_time_h_";
_ezafekari_end_vij = (int) (_vahed_ezafekari_vij*((double)(Double.parseDouble(mostCurrent._et_time_h_vij.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m_vij.getText()))/(double)60)));
RDebugUtils.currentLine=17694801;
 //BA.debugLineNum = 17694801;BA.debugLine="hogog_nakhales=paye_end+ezafekari_end+ezafekari_e";
_hogog_nakhales = (int) (_paye_end+_ezafekari_end+_ezafekari_end_vij+_maskan_end+_bon_end+_olad_end+_fani_end+_masoliat_end+_sarparasti_end+_sanavat_end+_mazaya_end+_shift_end);
RDebugUtils.currentLine=17694804;
 //BA.debugLineNum = 17694804;BA.debugLine="bime_tamin_end=(hogog_nakhales-olad_end)*0.07";
_bime_tamin_end = (int) ((_hogog_nakhales-_olad_end)*0.07);
RDebugUtils.currentLine=17694806;
 //BA.debugLineNum = 17694806;BA.debugLine="Dim nak_mal As Int";
_nak_mal = 0;
RDebugUtils.currentLine=17694807;
 //BA.debugLineNum = 17694807;BA.debugLine="nak_mal=hogog_nakhales-((bime_tamin_end*2)/7)  ''";
_nak_mal = (int) (_hogog_nakhales-((_bime_tamin_end*2)/(double)7));
RDebugUtils.currentLine=17694811;
 //BA.debugLineNum = 17694811;BA.debugLine="maliat_end=mohasebe_maliat(nak_mal,sp_year.Select";
_maliat_end = _mohasebe_maliat(_nak_mal,(int)(Double.parseDouble(mostCurrent._sp_year.getSelectedItem())));
RDebugUtils.currentLine=17694815;
 //BA.debugLineNum = 17694815;BA.debugLine="jame_kosorat=bime_tamin_end+maliat_end+bime_takmi";
_jame_kosorat = (int) (_bime_tamin_end+_maliat_end+_bime_takmil+_ksorat);
RDebugUtils.currentLine=17694817;
 //BA.debugLineNum = 17694817;BA.debugLine="hogog_khales=hogog_nakhales-jame_kosorat";
_hogog_khales = (int) (_hogog_nakhales-_jame_kosorat);
RDebugUtils.currentLine=17694819;
 //BA.debugLineNum = 17694819;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_gozaresh_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_gozaresh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_gozaresh_click", null));}
RDebugUtils.currentLine=17956864;
 //BA.debugLineNum = 17956864;BA.debugLine="Private Sub lbl_save_gozaresh_Click";
RDebugUtils.currentLine=17956865;
 //BA.debugLineNum = 17956865;BA.debugLine="et_name_gozaresh.Text=sp_moon.SelectedItem&\" \"&sp";
mostCurrent._et_name_gozaresh.setText(BA.ObjectToCharSequence(mostCurrent._sp_moon.getSelectedItem()+" "+mostCurrent._sp_year.getSelectedItem()));
RDebugUtils.currentLine=17956866;
 //BA.debugLineNum = 17956866;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=17956867;
 //BA.debugLineNum = 17956867;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_gozaresh_end_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_gozaresh_end_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_gozaresh_end_click", null));}
RDebugUtils.currentLine=18219008;
 //BA.debugLineNum = 18219008;BA.debugLine="Private Sub lbl_save_gozaresh_end_Click";
RDebugUtils.currentLine=18219009;
 //BA.debugLineNum = 18219009;BA.debugLine="save_gozaresh";
_save_gozaresh();
RDebugUtils.currentLine=18219010;
 //BA.debugLineNum = 18219010;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=18219011;
 //BA.debugLineNum = 18219011;BA.debugLine="End Sub";
return "";
}
public static String  _save_gozaresh() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "save_gozaresh", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "save_gozaresh", null));}
boolean _chek = false;
anywheresoftware.b4a.objects.collections.List _alist = null;
RDebugUtils.currentLine=18022400;
 //BA.debugLineNum = 18022400;BA.debugLine="Sub save_gozaresh";
RDebugUtils.currentLine=18022403;
 //BA.debugLineNum = 18022403;BA.debugLine="Dim chek As Boolean";
_chek = false;
RDebugUtils.currentLine=18022404;
 //BA.debugLineNum = 18022404;BA.debugLine="chek=myfunc.check_karid";
_chek = mostCurrent._myfunc._check_karid /*boolean*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=18022405;
 //BA.debugLineNum = 18022405;BA.debugLine="Dim alist As List";
_alist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=18022406;
 //BA.debugLineNum = 18022406;BA.debugLine="alist.Initialize";
_alist.Initialize();
RDebugUtils.currentLine=18022408;
 //BA.debugLineNum = 18022408;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(Main.persianDa";
_alist = mostCurrent._myfunc._num_list /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())),BA.NumberToString(01));
RDebugUtils.currentLine=18022411;
 //BA.debugLineNum = 18022411;BA.debugLine="If(chek=False)Then";
if ((_chek==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=18022412;
 //BA.debugLineNum = 18022412;BA.debugLine="If(alist.Get(2)<5)Then";
if (((double)(BA.ObjectToNumber(_alist.Get((int) (2))))<5)) { 
RDebugUtils.currentLine=18022413;
 //BA.debugLineNum = 18022413;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDa";
mostCurrent._dbcode._add_gozaresh /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),mostCurrent._et_name_gozaresh.getText(),mostCurrent._et_tozih_gozaresh.getText(),mostCurrent._str1.ToString(),BA.NumberToString(_hogog_nakhales),BA.NumberToString(_hogog_khales));
RDebugUtils.currentLine=18022414;
 //BA.debugLineNum = 18022414;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("گزارش ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=18022416;
 //BA.debugLineNum = 18022416;BA.debugLine="Main.buy_index=1";
mostCurrent._main._buy_index /*int*/  = (int) (1);
RDebugUtils.currentLine=18022417;
 //BA.debugLineNum = 18022417;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=18022418;
 //BA.debugLineNum = 18022418;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 }else {
RDebugUtils.currentLine=18022421;
 //BA.debugLineNum = 18022421;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDat";
mostCurrent._dbcode._add_gozaresh /*boolean*/ (mostCurrent.activityBA,mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),mostCurrent._et_name_gozaresh.getText(),mostCurrent._et_tozih_gozaresh.getText(),mostCurrent._str1.ToString(),BA.NumberToString(_hogog_nakhales),BA.NumberToString(_hogog_khales));
RDebugUtils.currentLine=18022422;
 //BA.debugLineNum = 18022422;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("گزارش ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=18022427;
 //BA.debugLineNum = 18022427;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_share_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_share_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_share_click", null));}
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
RDebugUtils.currentLine=18612224;
 //BA.debugLineNum = 18612224;BA.debugLine="Private Sub lbl_share_Click";
RDebugUtils.currentLine=18612225;
 //BA.debugLineNum = 18612225;BA.debugLine="Dim FileName As String =Main.current_gozaresh_id&";
_filename = BA.NumberToString(mostCurrent._main._current_gozaresh_id /*int*/ )+".html";
RDebugUtils.currentLine=18612228;
 //BA.debugLineNum = 18612228;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
anywheresoftware.b4a.keywords.Common.File.WriteString(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename,mostCurrent._str1.ToString());
RDebugUtils.currentLine=18612230;
 //BA.debugLineNum = 18612230;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=18612231;
 //BA.debugLineNum = 18612231;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
RDebugUtils.currentLine=18612232;
 //BA.debugLineNum = 18612232;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
RDebugUtils.currentLine=18612233;
 //BA.debugLineNum = 18612233;BA.debugLine="email.Body = \" گزارش حقوق \"&str1.ToString&CRLF&\"ا";
_email.Body = " گزارش حقوق "+mostCurrent._str1.ToString()+anywheresoftware.b4a.keywords.Common.CRLF+"اپلیکیشن اضافه کاری من"+anywheresoftware.b4a.keywords.Common.CRLF+"دانلود از بازار";
RDebugUtils.currentLine=18612234;
 //BA.debugLineNum = 18612234;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (null,_filename));
RDebugUtils.currentLine=18612236;
 //BA.debugLineNum = 18612236;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
RDebugUtils.currentLine=18612237;
 //BA.debugLineNum = 18612237;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
RDebugUtils.currentLine=18612238;
 //BA.debugLineNum = 18612238;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
RDebugUtils.currentLine=18612239;
 //BA.debugLineNum = 18612239;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=17760256;
 //BA.debugLineNum = 17760256;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
RDebugUtils.currentLine=17760257;
 //BA.debugLineNum = 17760257;BA.debugLine="Dim all_maliat As Int=0";
_all_maliat = (int) (0);
RDebugUtils.currentLine=17760258;
 //BA.debugLineNum = 17760258;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
RDebugUtils.currentLine=17760259;
 //BA.debugLineNum = 17760259;BA.debugLine="Dim state2 As Int=0";
_state2 = (int) (0);
RDebugUtils.currentLine=17760260;
 //BA.debugLineNum = 17760260;BA.debugLine="Dim state3 As Int=0";
_state3 = (int) (0);
RDebugUtils.currentLine=17760261;
 //BA.debugLineNum = 17760261;BA.debugLine="Dim state4 As Int=0";
_state4 = (int) (0);
RDebugUtils.currentLine=17760262;
 //BA.debugLineNum = 17760262;BA.debugLine="Dim state5 As Int=0";
_state5 = (int) (0);
RDebugUtils.currentLine=17760263;
 //BA.debugLineNum = 17760263;BA.debugLine="Dim state6 As Int=0";
_state6 = (int) (0);
RDebugUtils.currentLine=17760265;
 //BA.debugLineNum = 17760265;BA.debugLine="If (year=1399)Then";
if ((_year==1399)) { 
RDebugUtils.currentLine=17760266;
 //BA.debugLineNum = 17760266;BA.debugLine="If(hogog>3000001 And hogog<7500001)Then	  ''----";
if ((_hogog>3000001 && _hogog<7500001)) { 
RDebugUtils.currentLine=17760267;
 //BA.debugLineNum = 17760267;BA.debugLine="state1=(hogog-3000000)*0.1";
_state1 = (int) ((_hogog-3000000)*0.1);
 };
RDebugUtils.currentLine=17760269;
 //BA.debugLineNum = 17760269;BA.debugLine="If(hogog>7500001 And hogog<10500001)Then	  ''---";
if ((_hogog>7500001 && _hogog<10500001)) { 
RDebugUtils.currentLine=17760270;
 //BA.debugLineNum = 17760270;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=17760271;
 //BA.debugLineNum = 17760271;BA.debugLine="state2=(hogog-7500000)*0.15";
_state2 = (int) ((_hogog-7500000)*0.15);
 };
RDebugUtils.currentLine=17760273;
 //BA.debugLineNum = 17760273;BA.debugLine="If(hogog>10500001 And hogog<15000001)Then	  ''--";
if ((_hogog>10500001 && _hogog<15000001)) { 
RDebugUtils.currentLine=17760274;
 //BA.debugLineNum = 17760274;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=17760275;
 //BA.debugLineNum = 17760275;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=17760276;
 //BA.debugLineNum = 17760276;BA.debugLine="state3=(hogog-10500000)*0.2";
_state3 = (int) ((_hogog-10500000)*0.2);
 };
RDebugUtils.currentLine=17760278;
 //BA.debugLineNum = 17760278;BA.debugLine="If(hogog>15000001)Then	  ''-----stat4";
if ((_hogog>15000001)) { 
RDebugUtils.currentLine=17760279;
 //BA.debugLineNum = 17760279;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
RDebugUtils.currentLine=17760280;
 //BA.debugLineNum = 17760280;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
RDebugUtils.currentLine=17760281;
 //BA.debugLineNum = 17760281;BA.debugLine="state3=(4500000)*0.2";
_state3 = (int) ((4500000)*0.2);
RDebugUtils.currentLine=17760282;
 //BA.debugLineNum = 17760282;BA.debugLine="state4=(hogog-15000001)*0.25";
_state4 = (int) ((_hogog-15000001)*0.25);
 };
 };
RDebugUtils.currentLine=17760286;
 //BA.debugLineNum = 17760286;BA.debugLine="If (year=1400)Then";
if ((_year==1400)) { 
RDebugUtils.currentLine=17760287;
 //BA.debugLineNum = 17760287;BA.debugLine="If(hogog>4000001 And hogog<8000001)Then	  ''----";
if ((_hogog>4000001 && _hogog<8000001)) { 
RDebugUtils.currentLine=17760288;
 //BA.debugLineNum = 17760288;BA.debugLine="state1=(hogog-4000000)*0.1";
_state1 = (int) ((_hogog-4000000)*0.1);
 };
RDebugUtils.currentLine=17760290;
 //BA.debugLineNum = 17760290;BA.debugLine="If(hogog>8000001 And hogog<12000001)Then	  ''---";
if ((_hogog>8000001 && _hogog<12000001)) { 
RDebugUtils.currentLine=17760291;
 //BA.debugLineNum = 17760291;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=17760292;
 //BA.debugLineNum = 17760292;BA.debugLine="state2=(hogog-8000000)*0.15";
_state2 = (int) ((_hogog-8000000)*0.15);
 };
RDebugUtils.currentLine=17760294;
 //BA.debugLineNum = 17760294;BA.debugLine="If(hogog>12000001 And hogog<18000001)Then	  ''--";
if ((_hogog>12000001 && _hogog<18000001)) { 
RDebugUtils.currentLine=17760295;
 //BA.debugLineNum = 17760295;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=17760296;
 //BA.debugLineNum = 17760296;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=17760297;
 //BA.debugLineNum = 17760297;BA.debugLine="state3=(hogog-12000000)*0.2";
_state3 = (int) ((_hogog-12000000)*0.2);
 };
RDebugUtils.currentLine=17760299;
 //BA.debugLineNum = 17760299;BA.debugLine="If(hogog>18000001 And hogog<24000001)Then	  ''--";
if ((_hogog>18000001 && _hogog<24000001)) { 
RDebugUtils.currentLine=17760300;
 //BA.debugLineNum = 17760300;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=17760301;
 //BA.debugLineNum = 17760301;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=17760302;
 //BA.debugLineNum = 17760302;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=17760303;
 //BA.debugLineNum = 17760303;BA.debugLine="state4=(hogog-18000000)*0.25";
_state4 = (int) ((_hogog-18000000)*0.25);
 };
RDebugUtils.currentLine=17760305;
 //BA.debugLineNum = 17760305;BA.debugLine="If(hogog>24000001 And hogog<32000001)Then	  ''--";
if ((_hogog>24000001 && _hogog<32000001)) { 
RDebugUtils.currentLine=17760306;
 //BA.debugLineNum = 17760306;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=17760307;
 //BA.debugLineNum = 17760307;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=17760308;
 //BA.debugLineNum = 17760308;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=17760309;
 //BA.debugLineNum = 17760309;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=17760310;
 //BA.debugLineNum = 17760310;BA.debugLine="state5=(hogog-24000000)*0.3";
_state5 = (int) ((_hogog-24000000)*0.3);
 };
RDebugUtils.currentLine=17760312;
 //BA.debugLineNum = 17760312;BA.debugLine="If(hogog>32000001)Then	  ''-----stat4";
if ((_hogog>32000001)) { 
RDebugUtils.currentLine=17760313;
 //BA.debugLineNum = 17760313;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
RDebugUtils.currentLine=17760314;
 //BA.debugLineNum = 17760314;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
RDebugUtils.currentLine=17760315;
 //BA.debugLineNum = 17760315;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
RDebugUtils.currentLine=17760316;
 //BA.debugLineNum = 17760316;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
RDebugUtils.currentLine=17760317;
 //BA.debugLineNum = 17760317;BA.debugLine="state5=(6000000)*0.3";
_state5 = (int) ((6000000)*0.3);
RDebugUtils.currentLine=17760318;
 //BA.debugLineNum = 17760318;BA.debugLine="state6=(hogog-32000000)*0.35";
_state6 = (int) ((_hogog-32000000)*0.35);
 };
 };
RDebugUtils.currentLine=17760322;
 //BA.debugLineNum = 17760322;BA.debugLine="If (year=1401)Then";
if ((_year==1401)) { 
RDebugUtils.currentLine=17760323;
 //BA.debugLineNum = 17760323;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
if ((_hogog>5600001 && _hogog<12500001)) { 
RDebugUtils.currentLine=17760324;
 //BA.debugLineNum = 17760324;BA.debugLine="state1=(hogog-5600000)*0.1";
_state1 = (int) ((_hogog-5600000)*0.1);
 };
RDebugUtils.currentLine=17760326;
 //BA.debugLineNum = 17760326;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
if ((_hogog>12500001 && _hogog<20830001)) { 
RDebugUtils.currentLine=17760327;
 //BA.debugLineNum = 17760327;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=17760328;
 //BA.debugLineNum = 17760328;BA.debugLine="state2=(hogog-12500000)*0.15";
_state2 = (int) ((_hogog-12500000)*0.15);
 };
RDebugUtils.currentLine=17760330;
 //BA.debugLineNum = 17760330;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
if ((_hogog>20830001 && _hogog<29160001)) { 
RDebugUtils.currentLine=17760331;
 //BA.debugLineNum = 17760331;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=17760332;
 //BA.debugLineNum = 17760332;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=17760333;
 //BA.debugLineNum = 17760333;BA.debugLine="state3=(hogog-20830000)*0.2";
_state3 = (int) ((_hogog-20830000)*0.2);
 };
RDebugUtils.currentLine=17760336;
 //BA.debugLineNum = 17760336;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
if ((_hogog>29160001)) { 
RDebugUtils.currentLine=17760337;
 //BA.debugLineNum = 17760337;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=17760338;
 //BA.debugLineNum = 17760338;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=17760339;
 //BA.debugLineNum = 17760339;BA.debugLine="state3=(8330000)*0.2";
_state3 = (int) ((8330000)*0.2);
RDebugUtils.currentLine=17760341;
 //BA.debugLineNum = 17760341;BA.debugLine="state4=(hogog-29160000)*0.3";
_state4 = (int) ((_hogog-29160000)*0.3);
 };
 };
RDebugUtils.currentLine=17760346;
 //BA.debugLineNum = 17760346;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
_all_maliat = (int) (_state1+_state2+_state3+_state4+_state5+_state6);
RDebugUtils.currentLine=17760347;
 //BA.debugLineNum = 17760347;BA.debugLine="Return all_maliat";
if (true) return _all_maliat;
RDebugUtils.currentLine=17760349;
 //BA.debugLineNum = 17760349;BA.debugLine="End Sub";
return 0;
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=18350080;
 //BA.debugLineNum = 18350080;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=18350081;
 //BA.debugLineNum = 18350081;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=18350082;
 //BA.debugLineNum = 18350082;BA.debugLine="End Sub";
return "";
}
public static String  _pan_mohasebat_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_mohasebat_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_mohasebat_click", null));}
RDebugUtils.currentLine=18153472;
 //BA.debugLineNum = 18153472;BA.debugLine="Private Sub pan_mohasebat_Click";
RDebugUtils.currentLine=18153474;
 //BA.debugLineNum = 18153474;BA.debugLine="End Sub";
return "";
}
public static String  _panel7_click() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel7_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel7_click", null));}
RDebugUtils.currentLine=18284544;
 //BA.debugLineNum = 18284544;BA.debugLine="Private Sub Panel7_Click";
RDebugUtils.currentLine=18284546;
 //BA.debugLineNum = 18284546;BA.debugLine="End Sub";
return "";
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_moon_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_moon_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=17825792;
 //BA.debugLineNum = 17825792;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=17825793;
 //BA.debugLineNum = 17825793;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=17825795;
 //BA.debugLineNum = 17825795;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=17891328;
 //BA.debugLineNum = 17891328;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=17891329;
 //BA.debugLineNum = 17891329;BA.debugLine="et_time_inDB";
_et_time_indb();
RDebugUtils.currentLine=17891330;
 //BA.debugLineNum = 17891330;BA.debugLine="End Sub";
return "";
}
public static String  _time_page_load_tick() throws Exception{
RDebugUtils.currentModule="hogog_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time_page_load_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "time_page_load_tick", null));}
RDebugUtils.currentLine=17104896;
 //BA.debugLineNum = 17104896;BA.debugLine="Sub time_page_load_Tick";
RDebugUtils.currentLine=17104897;
 //BA.debugLineNum = 17104897;BA.debugLine="pan_load.Visible=False";
mostCurrent._pan_load.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=17104898;
 //BA.debugLineNum = 17104898;BA.debugLine="B4XLoadingIndicator1.Hide";
mostCurrent._b4xloadingindicator1._hide /*String*/ (null);
RDebugUtils.currentLine=17104899;
 //BA.debugLineNum = 17104899;BA.debugLine="Main.time_page_load.Enabled=False";
mostCurrent._main._time_page_load /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=17104900;
 //BA.debugLineNum = 17104900;BA.debugLine="End Sub";
return "";
}
}