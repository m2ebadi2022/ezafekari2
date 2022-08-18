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

public class fast_run_activity extends Activity implements B4AActivity{
	public static fast_run_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.fast_run_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (fast_run_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.fast_run_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.fast_run_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (fast_run_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (fast_run_activity) Resume **");
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
		return fast_run_activity.class;
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
            BA.LogInfo("** Activity (fast_run_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (fast_run_activity) Pause event (activity is not paused). **");
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
            fast_run_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (fast_run_activity) Resume **");
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
public anywheresoftware.b4a.objects.PanelWrapper _pan_all = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_paye = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_sanavat = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_maskan = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_bon = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_olad = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mazaya = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_kosorat = null;
public static int _paye = 0;
public static int _sanavat = 0;
public static int _mazaya_end = 0;
public static int _ksorat_end = 0;
public static int _maskan = 0;
public static int _olad = 0;
public static int _fani = 0;
public static int _masoliat = 0;
public static int _sarparasti = 0;
public static int _mazaya = 0;
public static int _bon = 0;
public static int _bime_tamin = 0;
public static int _bime_takmil = 0;
public static int _ksorat = 0;
public static double _shift = 0;
public static int _shift_end = 0;
public static int _paye_end = 0;
public static int _sanavat_end = 0;
public static int _olad_end = 0;
public static int _vahed_ezafekari = 0;
public static int _ezafekari_end = 0;
public static int _maliat_end = 0;
public static int _jame_kosorat = 0;
public anywheresoftware.b4a.objects.ScrollViewWrapper _sc_view1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_rozekari = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_vahed_ezafekari = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_time_h = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_time_m = null;
public static int _hogog_nakhales = 0;
public static int _hogog_khales = 0;
public static int _bime_tamin_end = 0;
public anywheresoftware.b4a.objects.SpinnerWrapper _sp_olad = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_fast_run = null;
public anywheresoftware.b4a.objects.drawable.BitmapDrawable _imm = null;
public anywheresoftware.b4a.objects.drawable.BitmapDrawable _imm2 = null;
public anywheresoftware.b4a.objects.WebViewWrapper _wb_show_result = null;
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
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=24379392;
 //BA.debugLineNum = 24379392;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=24379394;
 //BA.debugLineNum = 24379394;BA.debugLine="Activity.LoadLayout(\"fast_run_layout\")";
mostCurrent._activity.LoadLayout("fast_run_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=24379395;
 //BA.debugLineNum = 24379395;BA.debugLine="sc_view1.Panel.LoadLayout(\"item_fast_run\")";
mostCurrent._sc_view1.getPanel().LoadLayout("item_fast_run",mostCurrent.activityBA);
RDebugUtils.currentLine=24379397;
 //BA.debugLineNum = 24379397;BA.debugLine="If(Main.moon_num<7)Then";
if (((double)(Double.parseDouble(mostCurrent._main._moon_num /*String*/ ))<7)) { 
RDebugUtils.currentLine=24379398;
 //BA.debugLineNum = 24379398;BA.debugLine="et_rozeKari.Text=31";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(31));
 }else {
RDebugUtils.currentLine=24379400;
 //BA.debugLineNum = 24379400;BA.debugLine="et_rozeKari.Text=30";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(30));
 };
RDebugUtils.currentLine=24379404;
 //BA.debugLineNum = 24379404;BA.debugLine="get_data_hogogi";
_get_data_hogogi();
RDebugUtils.currentLine=24379409;
 //BA.debugLineNum = 24379409;BA.debugLine="et_paye.Tag=paye";
mostCurrent._et_paye.setTag((Object)(_paye));
RDebugUtils.currentLine=24379410;
 //BA.debugLineNum = 24379410;BA.debugLine="et_paye.Text=myfunc.show_num_pool(paye)";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_paye)));
RDebugUtils.currentLine=24379412;
 //BA.debugLineNum = 24379412;BA.debugLine="et_sanavat.Tag=sanavat";
mostCurrent._et_sanavat.setTag((Object)(_sanavat));
RDebugUtils.currentLine=24379413;
 //BA.debugLineNum = 24379413;BA.debugLine="et_sanavat.Text=myfunc.show_num_pool(sanavat)";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_sanavat)));
RDebugUtils.currentLine=24379415;
 //BA.debugLineNum = 24379415;BA.debugLine="et_mazaya.Tag=mazaya_end";
mostCurrent._et_mazaya.setTag((Object)(_mazaya_end));
RDebugUtils.currentLine=24379416;
 //BA.debugLineNum = 24379416;BA.debugLine="et_mazaya.Text=myfunc.show_num_pool(mazaya_end)";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_mazaya_end)));
RDebugUtils.currentLine=24379418;
 //BA.debugLineNum = 24379418;BA.debugLine="et_kosorat.Tag=ksorat_end";
mostCurrent._et_kosorat.setTag((Object)(_ksorat_end));
RDebugUtils.currentLine=24379419;
 //BA.debugLineNum = 24379419;BA.debugLine="et_kosorat.Text=myfunc.show_num_pool(ksorat_end)";
mostCurrent._et_kosorat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_ksorat_end)));
RDebugUtils.currentLine=24379421;
 //BA.debugLineNum = 24379421;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=24379422;
 //BA.debugLineNum = 24379422;BA.debugLine="sp_olad.AddAll(Array As String(0,1,2,3,4,5,6,7,8,";
mostCurrent._sp_olad.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9),BA.NumberToString(10)}));
RDebugUtils.currentLine=24379425;
 //BA.debugLineNum = 24379425;BA.debugLine="imm.Initialize(LoadBitmap(File.DirAssets,\"textBox";
mostCurrent._imm.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"textBox.png").getObject()));
RDebugUtils.currentLine=24379426;
 //BA.debugLineNum = 24379426;BA.debugLine="imm.Gravity=Gravity.FILL";
mostCurrent._imm.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=24379427;
 //BA.debugLineNum = 24379427;BA.debugLine="imm2.Initialize(LoadBitmap(File.DirAssets,\"textBo";
mostCurrent._imm2.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"textBox2.png").getObject()));
RDebugUtils.currentLine=24379428;
 //BA.debugLineNum = 24379428;BA.debugLine="imm2.Gravity=Gravity.FILL";
mostCurrent._imm2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=24379431;
 //BA.debugLineNum = 24379431;BA.debugLine="box_control";
_box_control();
RDebugUtils.currentLine=24379433;
 //BA.debugLineNum = 24379433;BA.debugLine="pan_hed_fast_run.Color=Main.color4";
mostCurrent._pan_hed_fast_run.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=24379434;
 //BA.debugLineNum = 24379434;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=24379435;
 //BA.debugLineNum = 24379435;BA.debugLine="wb_show_result.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._wb_show_result.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=24379436;
 //BA.debugLineNum = 24379436;BA.debugLine="wb_show_result.ZoomEnabled=False";
mostCurrent._wb_show_result.setZoomEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24379437;
 //BA.debugLineNum = 24379437;BA.debugLine="End Sub";
return "";
}
public static String  _get_data_hogogi() throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_data_hogogi", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "get_data_hogogi", null));}
int _tedad_olad = 0;
String _moon_num = "";
anywheresoftware.b4a.objects.collections.List _list_ezafekari1 = null;
RDebugUtils.currentLine=24969216;
 //BA.debugLineNum = 24969216;BA.debugLine="Sub get_data_hogogi";
RDebugUtils.currentLine=24969218;
 //BA.debugLineNum = 24969218;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=24969219;
 //BA.debugLineNum = 24969219;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=24969221;
 //BA.debugLineNum = 24969221;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=24969222;
 //BA.debugLineNum = 24969222;BA.debugLine="paye=dbCode.res.GetString(\"value\")";
_paye = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24969225;
 //BA.debugLineNum = 24969225;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (14));
RDebugUtils.currentLine=24969226;
 //BA.debugLineNum = 24969226;BA.debugLine="sanavat=dbCode.res.GetString(\"value\")";
_sanavat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24969232;
 //BA.debugLineNum = 24969232;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (1));
RDebugUtils.currentLine=24969233;
 //BA.debugLineNum = 24969233;BA.debugLine="maskan=dbCode.res.GetString(\"value\")";
_maskan = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24969235;
 //BA.debugLineNum = 24969235;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (3));
RDebugUtils.currentLine=24969236;
 //BA.debugLineNum = 24969236;BA.debugLine="olad=dbCode.res.GetString(\"value\")";
_olad = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24969238;
 //BA.debugLineNum = 24969238;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (4));
RDebugUtils.currentLine=24969239;
 //BA.debugLineNum = 24969239;BA.debugLine="fani=dbCode.res.GetString(\"value\")";
_fani = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24969241;
 //BA.debugLineNum = 24969241;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (5));
RDebugUtils.currentLine=24969242;
 //BA.debugLineNum = 24969242;BA.debugLine="masoliat=dbCode.res.GetString(\"value\")";
_masoliat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24969244;
 //BA.debugLineNum = 24969244;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (2));
RDebugUtils.currentLine=24969245;
 //BA.debugLineNum = 24969245;BA.debugLine="bon=dbCode.res.GetString(\"value\")";
_bon = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24969247;
 //BA.debugLineNum = 24969247;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (15));
RDebugUtils.currentLine=24969248;
 //BA.debugLineNum = 24969248;BA.debugLine="sarparasti=dbCode.res.GetString(\"value\")";
_sarparasti = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24969250;
 //BA.debugLineNum = 24969250;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (16));
RDebugUtils.currentLine=24969251;
 //BA.debugLineNum = 24969251;BA.debugLine="mazaya=dbCode.res.GetString(\"value\")";
_mazaya = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24969261;
 //BA.debugLineNum = 24969261;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (11));
RDebugUtils.currentLine=24969262;
 //BA.debugLineNum = 24969262;BA.debugLine="bime_takmil=dbCode.res.GetString(\"value\")";
_bime_takmil = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24969267;
 //BA.debugLineNum = 24969267;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (19));
RDebugUtils.currentLine=24969268;
 //BA.debugLineNum = 24969268;BA.debugLine="ksorat=dbCode.res.GetString(\"value\")";
_ksorat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=24969272;
 //BA.debugLineNum = 24969272;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=24969273;
 //BA.debugLineNum = 24969273;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=24969276;
 //BA.debugLineNum = 24969276;BA.debugLine="et_olad.Tag=olad";
mostCurrent._et_olad.setTag((Object)(_olad));
RDebugUtils.currentLine=24969277;
 //BA.debugLineNum = 24969277;BA.debugLine="et_olad.Text=myfunc.show_num_pool(olad)";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_olad)));
RDebugUtils.currentLine=24969279;
 //BA.debugLineNum = 24969279;BA.debugLine="If(olad<>0)Then";
if ((_olad!=0)) { 
RDebugUtils.currentLine=24969280;
 //BA.debugLineNum = 24969280;BA.debugLine="Dim tedad_olad As Int=olad/417975";
_tedad_olad = (int) (_olad/(double)417975);
RDebugUtils.currentLine=24969281;
 //BA.debugLineNum = 24969281;BA.debugLine="sp_olad.SelectedIndex=tedad_olad";
mostCurrent._sp_olad.setSelectedIndex(_tedad_olad);
 };
RDebugUtils.currentLine=24969285;
 //BA.debugLineNum = 24969285;BA.debugLine="mazaya_end=maskan+fani+masoliat+sarparasti+bon+ma";
_mazaya_end = (int) (_maskan+_fani+_masoliat+_sarparasti+_bon+_mazaya);
RDebugUtils.currentLine=24969286;
 //BA.debugLineNum = 24969286;BA.debugLine="ksorat_end=bime_takmil+ksorat";
_ksorat_end = (int) (_bime_takmil+_ksorat);
RDebugUtils.currentLine=24969290;
 //BA.debugLineNum = 24969290;BA.debugLine="Dim moon_num As String";
_moon_num = "";
RDebugUtils.currentLine=24969292;
 //BA.debugLineNum = 24969292;BA.debugLine="Select Main.persianDate.PersianMonth";
switch (BA.switchObjectToInt(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth(),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11),(int) (12))) {
case 0: {
RDebugUtils.currentLine=24969295;
 //BA.debugLineNum = 24969295;BA.debugLine="moon_num=\"01\"";
_moon_num = "01";
 break; }
case 1: {
RDebugUtils.currentLine=24969297;
 //BA.debugLineNum = 24969297;BA.debugLine="moon_num=\"02\"";
_moon_num = "02";
 break; }
case 2: {
RDebugUtils.currentLine=24969299;
 //BA.debugLineNum = 24969299;BA.debugLine="moon_num=\"03\"";
_moon_num = "03";
 break; }
case 3: {
RDebugUtils.currentLine=24969301;
 //BA.debugLineNum = 24969301;BA.debugLine="moon_num=\"04\"";
_moon_num = "04";
 break; }
case 4: {
RDebugUtils.currentLine=24969303;
 //BA.debugLineNum = 24969303;BA.debugLine="moon_num=\"05\"";
_moon_num = "05";
 break; }
case 5: {
RDebugUtils.currentLine=24969305;
 //BA.debugLineNum = 24969305;BA.debugLine="moon_num=\"06\"";
_moon_num = "06";
 break; }
case 6: {
RDebugUtils.currentLine=24969307;
 //BA.debugLineNum = 24969307;BA.debugLine="moon_num=\"07\"";
_moon_num = "07";
 break; }
case 7: {
RDebugUtils.currentLine=24969309;
 //BA.debugLineNum = 24969309;BA.debugLine="moon_num=\"08\"";
_moon_num = "08";
 break; }
case 8: {
RDebugUtils.currentLine=24969311;
 //BA.debugLineNum = 24969311;BA.debugLine="moon_num=\"9\"";
_moon_num = "9";
 break; }
case 9: {
RDebugUtils.currentLine=24969313;
 //BA.debugLineNum = 24969313;BA.debugLine="moon_num=\"10\"";
_moon_num = "10";
 break; }
case 10: {
RDebugUtils.currentLine=24969315;
 //BA.debugLineNum = 24969315;BA.debugLine="moon_num=\"11\"";
_moon_num = "11";
 break; }
case 11: {
RDebugUtils.currentLine=24969317;
 //BA.debugLineNum = 24969317;BA.debugLine="moon_num=\"12\"";
_moon_num = "12";
 break; }
}
;
RDebugUtils.currentLine=24969320;
 //BA.debugLineNum = 24969320;BA.debugLine="Dim list_ezafekari1 As List";
_list_ezafekari1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=24969321;
 //BA.debugLineNum = 24969321;BA.debugLine="list_ezafekari1.Initialize";
_list_ezafekari1.Initialize();
RDebugUtils.currentLine=24969322;
 //BA.debugLineNum = 24969322;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_mah(Main.per";
_list_ezafekari1 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear()),_moon_num,(int) (2));
RDebugUtils.currentLine=24969323;
 //BA.debugLineNum = 24969323;BA.debugLine="et_time_h.Text=list_ezafekari1.Get(0)";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (0))));
RDebugUtils.currentLine=24969324;
 //BA.debugLineNum = 24969324;BA.debugLine="et_time_m.Text=list_ezafekari1.Get(1)";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (1))));
RDebugUtils.currentLine=24969327;
 //BA.debugLineNum = 24969327;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari() throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "calc_vahed_ezafekari", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "calc_vahed_ezafekari", null));}
int _a1 = 0;
int _a2 = 0;
int _a3 = 0;
RDebugUtils.currentLine=25362432;
 //BA.debugLineNum = 25362432;BA.debugLine="Sub calc_vahed_ezafekari";
RDebugUtils.currentLine=25362433;
 //BA.debugLineNum = 25362433;BA.debugLine="Dim a1,a2,a3 As Int";
_a1 = 0;
_a2 = 0;
_a3 = 0;
RDebugUtils.currentLine=25362434;
 //BA.debugLineNum = 25362434;BA.debugLine="a1=et_paye.Tag";
_a1 = (int)(BA.ObjectToNumber(mostCurrent._et_paye.getTag()));
RDebugUtils.currentLine=25362435;
 //BA.debugLineNum = 25362435;BA.debugLine="a2=et_sanavat.Tag";
_a2 = (int)(BA.ObjectToNumber(mostCurrent._et_sanavat.getTag()));
RDebugUtils.currentLine=25362436;
 //BA.debugLineNum = 25362436;BA.debugLine="a3=et_rozeKari.Text";
_a3 = (int)(Double.parseDouble(mostCurrent._et_rozekari.getText()));
RDebugUtils.currentLine=25362438;
 //BA.debugLineNum = 25362438;BA.debugLine="paye_end=(a1/30)*a3";
_paye_end = (int) ((_a1/(double)30)*_a3);
RDebugUtils.currentLine=25362441;
 //BA.debugLineNum = 25362441;BA.debugLine="sanavat_end=(a2/30)*a3";
_sanavat_end = (int) ((_a2/(double)30)*_a3);
RDebugUtils.currentLine=25362444;
 //BA.debugLineNum = 25362444;BA.debugLine="vahed_ezafekari=((a1+a2)/220)*1.4";
_vahed_ezafekari = (int) (((_a1+_a2)/(double)220)*1.4);
RDebugUtils.currentLine=25362445;
 //BA.debugLineNum = 25362445;BA.debugLine="et_vahed_ezafekari.Text=myfunc.show_num_pool(vahe";
mostCurrent._et_vahed_ezafekari.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari)));
RDebugUtils.currentLine=25362446;
 //BA.debugLineNum = 25362446;BA.debugLine="et_vahed_ezafekari.Tag=vahed_ezafekari";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_vahed_ezafekari));
RDebugUtils.currentLine=25362449;
 //BA.debugLineNum = 25362449;BA.debugLine="End Sub";
return "";
}
public static boolean  _box_control() throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "box_control", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "box_control", null));}
boolean _chk = false;
RDebugUtils.currentLine=25231360;
 //BA.debugLineNum = 25231360;BA.debugLine="Sub box_control As Boolean";
RDebugUtils.currentLine=25231361;
 //BA.debugLineNum = 25231361;BA.debugLine="et_paye.Background=imm";
mostCurrent._et_paye.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm.getObject()));
RDebugUtils.currentLine=25231362;
 //BA.debugLineNum = 25231362;BA.debugLine="et_sanavat.Background=imm";
mostCurrent._et_sanavat.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm.getObject()));
RDebugUtils.currentLine=25231363;
 //BA.debugLineNum = 25231363;BA.debugLine="et_olad.Background=imm";
mostCurrent._et_olad.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm.getObject()));
RDebugUtils.currentLine=25231364;
 //BA.debugLineNum = 25231364;BA.debugLine="et_mazaya.Background=imm";
mostCurrent._et_mazaya.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm.getObject()));
RDebugUtils.currentLine=25231365;
 //BA.debugLineNum = 25231365;BA.debugLine="et_kosorat.Background=imm";
mostCurrent._et_kosorat.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm.getObject()));
RDebugUtils.currentLine=25231366;
 //BA.debugLineNum = 25231366;BA.debugLine="et_rozeKari.Background=imm";
mostCurrent._et_rozekari.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm.getObject()));
RDebugUtils.currentLine=25231369;
 //BA.debugLineNum = 25231369;BA.debugLine="Dim chk As Boolean=True";
_chk = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=25231371;
 //BA.debugLineNum = 25231371;BA.debugLine="If(et_paye.Text=\"\")Then";
if (((mostCurrent._et_paye.getText()).equals(""))) { 
RDebugUtils.currentLine=25231372;
 //BA.debugLineNum = 25231372;BA.debugLine="et_paye.Background=imm2";
mostCurrent._et_paye.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm2.getObject()));
RDebugUtils.currentLine=25231373;
 //BA.debugLineNum = 25231373;BA.debugLine="chk= False";
_chk = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=25231375;
 //BA.debugLineNum = 25231375;BA.debugLine="If (et_sanavat.Text=\"\")Then";
if (((mostCurrent._et_sanavat.getText()).equals(""))) { 
RDebugUtils.currentLine=25231376;
 //BA.debugLineNum = 25231376;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=25231377;
 //BA.debugLineNum = 25231377;BA.debugLine="et_sanavat.Tag=0";
mostCurrent._et_sanavat.setTag((Object)(0));
 };
RDebugUtils.currentLine=25231379;
 //BA.debugLineNum = 25231379;BA.debugLine="If (et_olad.Text=\"\")Then";
if (((mostCurrent._et_olad.getText()).equals(""))) { 
RDebugUtils.currentLine=25231380;
 //BA.debugLineNum = 25231380;BA.debugLine="et_olad.Tag=0";
mostCurrent._et_olad.setTag((Object)(0));
RDebugUtils.currentLine=25231381;
 //BA.debugLineNum = 25231381;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=25231383;
 //BA.debugLineNum = 25231383;BA.debugLine="If (et_mazaya.Text=\"\")Then";
if (((mostCurrent._et_mazaya.getText()).equals(""))) { 
RDebugUtils.currentLine=25231384;
 //BA.debugLineNum = 25231384;BA.debugLine="et_mazaya.Tag=0";
mostCurrent._et_mazaya.setTag((Object)(0));
RDebugUtils.currentLine=25231385;
 //BA.debugLineNum = 25231385;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=25231387;
 //BA.debugLineNum = 25231387;BA.debugLine="If (et_kosorat.Text=\"\")Then";
if (((mostCurrent._et_kosorat.getText()).equals(""))) { 
RDebugUtils.currentLine=25231388;
 //BA.debugLineNum = 25231388;BA.debugLine="et_kosorat.Tag=0";
mostCurrent._et_kosorat.setTag((Object)(0));
RDebugUtils.currentLine=25231389;
 //BA.debugLineNum = 25231389;BA.debugLine="et_kosorat.Text=0";
mostCurrent._et_kosorat.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=25231391;
 //BA.debugLineNum = 25231391;BA.debugLine="If (et_rozeKari.Text=\"\" Or et_rozeKari.Text>31 Or";
if (((mostCurrent._et_rozekari.getText()).equals("") || (double)(Double.parseDouble(mostCurrent._et_rozekari.getText()))>31 || (double)(Double.parseDouble(mostCurrent._et_rozekari.getText()))<1)) { 
RDebugUtils.currentLine=25231392;
 //BA.debugLineNum = 25231392;BA.debugLine="et_rozeKari.Background=imm2";
mostCurrent._et_rozekari.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm2.getObject()));
RDebugUtils.currentLine=25231393;
 //BA.debugLineNum = 25231393;BA.debugLine="chk= False";
_chk = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=25231395;
 //BA.debugLineNum = 25231395;BA.debugLine="If(et_time_h.Text=\"\")Then";
if (((mostCurrent._et_time_h.getText()).equals(""))) { 
RDebugUtils.currentLine=25231396;
 //BA.debugLineNum = 25231396;BA.debugLine="et_time_h.Text=0";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=25231398;
 //BA.debugLineNum = 25231398;BA.debugLine="If(et_time_m.Text=\"\")Then";
if (((mostCurrent._et_time_m.getText()).equals(""))) { 
RDebugUtils.currentLine=25231399;
 //BA.debugLineNum = 25231399;BA.debugLine="et_time_m.Text=0";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(0));
 };
RDebugUtils.currentLine=25231403;
 //BA.debugLineNum = 25231403;BA.debugLine="Return chk";
if (true) return _chk;
RDebugUtils.currentLine=25231404;
 //BA.debugLineNum = 25231404;BA.debugLine="End Sub";
return false;
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=24641536;
 //BA.debugLineNum = 24641536;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=24641537;
 //BA.debugLineNum = 24641537;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=24641539;
 //BA.debugLineNum = 24641539;BA.debugLine="If(pan_all.Visible=True)Then";
if ((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=24641540;
 //BA.debugLineNum = 24641540;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=24641542;
 //BA.debugLineNum = 24641542;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
RDebugUtils.currentLine=24641545;
 //BA.debugLineNum = 24641545;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=24641547;
 //BA.debugLineNum = 24641547;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=24641549;
 //BA.debugLineNum = 24641549;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=24576000;
 //BA.debugLineNum = 24576000;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=24576002;
 //BA.debugLineNum = 24576002;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=24576003;
 //BA.debugLineNum = 24576003;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="fast_run_activity";
RDebugUtils.currentLine=24510464;
 //BA.debugLineNum = 24510464;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=24510466;
 //BA.debugLineNum = 24510466;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=24444928;
 //BA.debugLineNum = 24444928;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=24444930;
 //BA.debugLineNum = 24444930;BA.debugLine="End Sub";
return "";
}
public static String  _btn_run_click() throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_run_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_run_click", null));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _str_show = null;
RDebugUtils.currentLine=24838144;
 //BA.debugLineNum = 24838144;BA.debugLine="Private Sub btn_run_Click";
RDebugUtils.currentLine=24838146;
 //BA.debugLineNum = 24838146;BA.debugLine="If (box_control=True)Then";
if ((_box_control()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=24838148;
 //BA.debugLineNum = 24838148;BA.debugLine="mohasebe";
_mohasebe();
RDebugUtils.currentLine=24838150;
 //BA.debugLineNum = 24838150;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=24838151;
 //BA.debugLineNum = 24838151;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
RDebugUtils.currentLine=24838153;
 //BA.debugLineNum = 24838153;BA.debugLine="str_show.Append(\"<html dir='rtl'><meta charset='";
_str_show.Append("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>");
RDebugUtils.currentLine=24838155;
 //BA.debugLineNum = 24838155;BA.debugLine="str_show.Append(\"<h5 align='center'>واحد : تومان";
_str_show.Append("<h5 align='center'>واحد : تومان <br>");
RDebugUtils.currentLine=24838156;
 //BA.debugLineNum = 24838156;BA.debugLine="str_show.Append(\"تعداد روز کاری : \"&myfunc.en2fa";
_str_show.Append("تعداد روز کاری : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_rozekari.getText())+"</h5>");
RDebugUtils.currentLine=24838158;
 //BA.debugLineNum = 24838158;BA.debugLine="str_show.Append(\"<div style=' border: 2px solid";
_str_show.Append("<div style=' border: 2px solid gray;  padding: 10px; border-radius: 20px;'>");
RDebugUtils.currentLine=24838159;
 //BA.debugLineNum = 24838159;BA.debugLine="str_show.Append(\" پایه حقوق : \"&myfunc.en2fa(sho";
_str_show.Append(" پایه حقوق : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_paye_end))).Append("<br>");
RDebugUtils.currentLine=24838160;
 //BA.debugLineNum = 24838160;BA.debugLine="str_show.Append(\" حق سنوات : \"&myfunc.en2fa(show";
_str_show.Append(" حق سنوات : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat_end))).Append("<br>");
RDebugUtils.currentLine=24838161;
 //BA.debugLineNum = 24838161;BA.debugLine="str_show.Append(\" حق اولاد : \"&myfunc.en2fa(show";
_str_show.Append(" حق اولاد : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad_end))).Append("<br>");
RDebugUtils.currentLine=24838162;
 //BA.debugLineNum = 24838162;BA.debugLine="str_show.Append(\" مزایا : \"&myfunc.en2fa(show_nu";
_str_show.Append(" مزایا : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya_end))).Append("<br>");
RDebugUtils.currentLine=24838163;
 //BA.debugLineNum = 24838163;BA.debugLine="str_show.Append(\" کسورات : \"&myfunc.en2fa(show_n";
_str_show.Append(" کسورات : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat_end))).Append("<br>");
RDebugUtils.currentLine=24838164;
 //BA.debugLineNum = 24838164;BA.debugLine="str_show.Append(\"</div>\").Append(\"<br>\")";
_str_show.Append("</div>").Append("<br>");
RDebugUtils.currentLine=24838166;
 //BA.debugLineNum = 24838166;BA.debugLine="str_show.Append(\"<div style=' border: 2px solid";
_str_show.Append("<div style=' border: 2px solid red;  padding: 10px; border-radius: 20px;'>");
RDebugUtils.currentLine=24838167;
 //BA.debugLineNum = 24838167;BA.debugLine="str_show.Append(\" بیمه تامین اجتماعی : \"&myfunc.";
_str_show.Append(" بیمه تامین اجتماعی : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_tamin_end))).Append("<br>");
RDebugUtils.currentLine=24838168;
 //BA.debugLineNum = 24838168;BA.debugLine="str_show.Append(\" مالیات : \"&myfunc.en2fa(show_n";
_str_show.Append(" مالیات : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maliat_end))).Append("<br>");
RDebugUtils.currentLine=24838169;
 //BA.debugLineNum = 24838169;BA.debugLine="str_show.Append(\" جمع کسورات : \"&myfunc.en2fa(sh";
_str_show.Append(" جمع کسورات : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_jame_kosorat))).Append("<br>");
RDebugUtils.currentLine=24838170;
 //BA.debugLineNum = 24838170;BA.debugLine="str_show.Append(\"</div>\").Append(\"<br>\")";
_str_show.Append("</div>").Append("<br>");
RDebugUtils.currentLine=24838172;
 //BA.debugLineNum = 24838172;BA.debugLine="str_show.Append(\"<div style=' border: 3px solid";
_str_show.Append("<div style=' border: 3px solid green;  padding: 10px; border-radius: 20px;'>");
RDebugUtils.currentLine=24838173;
 //BA.debugLineNum = 24838173;BA.debugLine="str_show.Append(\" ناخالص حقوق : \"&myfunc.en2fa(s";
_str_show.Append(" ناخالص حقوق : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_nakhales))).Append("<br>");
RDebugUtils.currentLine=24838174;
 //BA.debugLineNum = 24838174;BA.debugLine="str_show.Append(\" خالص دریافتی : <mark> \"&myfunc";
_str_show.Append(" خالص دریافتی : <mark> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_khales))+"</mark>");
RDebugUtils.currentLine=24838175;
 //BA.debugLineNum = 24838175;BA.debugLine="str_show.Append(\"</div>\")";
_str_show.Append("</div>");
RDebugUtils.currentLine=24838177;
 //BA.debugLineNum = 24838177;BA.debugLine="str_show.Append(\"</body></html>\")";
_str_show.Append("</body></html>");
RDebugUtils.currentLine=24838180;
 //BA.debugLineNum = 24838180;BA.debugLine="wb_show_result.LoadHtml(str_show.ToString)";
mostCurrent._wb_show_result.LoadHtml(_str_show.ToString());
RDebugUtils.currentLine=24838184;
 //BA.debugLineNum = 24838184;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=24838186;
 //BA.debugLineNum = 24838186;BA.debugLine="ToastMessageShow(\"فیلد اشتباه\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("فیلد اشتباه"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=24838191;
 //BA.debugLineNum = 24838191;BA.debugLine="End Sub";
return "";
}
public static String  _mohasebe() throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mohasebe", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "mohasebe", null));}
int _nak_mal = 0;
RDebugUtils.currentLine=25100288;
 //BA.debugLineNum = 25100288;BA.debugLine="Sub mohasebe";
RDebugUtils.currentLine=25100298;
 //BA.debugLineNum = 25100298;BA.debugLine="vahed_ezafekari=et_vahed_ezafekari.Tag";
_vahed_ezafekari = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari.getTag()));
RDebugUtils.currentLine=25100299;
 //BA.debugLineNum = 25100299;BA.debugLine="ezafekari_end=vahed_ezafekari*(et_time_h.Text+(et";
_ezafekari_end = (int) (_vahed_ezafekari*((double)(Double.parseDouble(mostCurrent._et_time_h.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m.getText()))/(double)60)));
RDebugUtils.currentLine=25100302;
 //BA.debugLineNum = 25100302;BA.debugLine="paye_end=(et_paye.Tag/30)*et_rozeKari.Text";
_paye_end = (int) (((double)(BA.ObjectToNumber(mostCurrent._et_paye.getTag()))/(double)30)*(double)(Double.parseDouble(mostCurrent._et_rozekari.getText())));
RDebugUtils.currentLine=25100303;
 //BA.debugLineNum = 25100303;BA.debugLine="sanavat_end=(et_sanavat.Tag/30)*et_rozeKari.Text";
_sanavat_end = (int) (((double)(BA.ObjectToNumber(mostCurrent._et_sanavat.getTag()))/(double)30)*(double)(Double.parseDouble(mostCurrent._et_rozekari.getText())));
RDebugUtils.currentLine=25100305;
 //BA.debugLineNum = 25100305;BA.debugLine="If (et_rozeKari.Text<30)Then";
if (((double)(Double.parseDouble(mostCurrent._et_rozekari.getText()))<30)) { 
RDebugUtils.currentLine=25100307;
 //BA.debugLineNum = 25100307;BA.debugLine="olad_end=(et_olad.Tag/30)*et_rozeKari.Text";
_olad_end = (int) (((double)(BA.ObjectToNumber(mostCurrent._et_olad.getTag()))/(double)30)*(double)(Double.parseDouble(mostCurrent._et_rozekari.getText())));
RDebugUtils.currentLine=25100308;
 //BA.debugLineNum = 25100308;BA.debugLine="mazaya_end=(et_mazaya.Tag/30)*et_rozeKari.Text";
_mazaya_end = (int) (((double)(BA.ObjectToNumber(mostCurrent._et_mazaya.getTag()))/(double)30)*(double)(Double.parseDouble(mostCurrent._et_rozekari.getText())));
 }else {
RDebugUtils.currentLine=25100312;
 //BA.debugLineNum = 25100312;BA.debugLine="olad_end=et_olad.Tag";
_olad_end = (int)(BA.ObjectToNumber(mostCurrent._et_olad.getTag()));
RDebugUtils.currentLine=25100313;
 //BA.debugLineNum = 25100313;BA.debugLine="mazaya_end=et_mazaya.Tag";
_mazaya_end = (int)(BA.ObjectToNumber(mostCurrent._et_mazaya.getTag()));
 };
RDebugUtils.currentLine=25100321;
 //BA.debugLineNum = 25100321;BA.debugLine="hogog_nakhales=paye_end+ezafekari_end+sanavat_end";
_hogog_nakhales = (int) (_paye_end+_ezafekari_end+_sanavat_end+_mazaya_end+_olad_end);
RDebugUtils.currentLine=25100324;
 //BA.debugLineNum = 25100324;BA.debugLine="bime_tamin_end=(hogog_nakhales-olad_end)*0.07";
_bime_tamin_end = (int) ((_hogog_nakhales-_olad_end)*0.07);
RDebugUtils.currentLine=25100326;
 //BA.debugLineNum = 25100326;BA.debugLine="Dim nak_mal As Int";
_nak_mal = 0;
RDebugUtils.currentLine=25100327;
 //BA.debugLineNum = 25100327;BA.debugLine="nak_mal=hogog_nakhales-((bime_tamin_end*2)/7)  ''";
_nak_mal = (int) (_hogog_nakhales-((_bime_tamin_end*2)/(double)7));
RDebugUtils.currentLine=25100331;
 //BA.debugLineNum = 25100331;BA.debugLine="maliat_end=mohasebe_maliat(nak_mal,1401)";
_maliat_end = _mohasebe_maliat(_nak_mal,(int) (1401));
RDebugUtils.currentLine=25100334;
 //BA.debugLineNum = 25100334;BA.debugLine="jame_kosorat=bime_tamin_end+maliat_end+bime_takmi";
_jame_kosorat = (int) (_bime_tamin_end+_maliat_end+_bime_takmil+_ksorat);
RDebugUtils.currentLine=25100336;
 //BA.debugLineNum = 25100336;BA.debugLine="hogog_khales=hogog_nakhales-jame_kosorat";
_hogog_khales = (int) (_hogog_nakhales-_jame_kosorat);
RDebugUtils.currentLine=25100338;
 //BA.debugLineNum = 25100338;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(int _num) throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_num_pool", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_num_pool", new Object[] {_num}));}
RDebugUtils.currentLine=25034752;
 //BA.debugLineNum = 25034752;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=25034753;
 //BA.debugLineNum = 25034753;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
RDebugUtils.currentLine=25034754;
 //BA.debugLineNum = 25034754;BA.debugLine="End Sub";
return "";
}
public static String  _et_kosorat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_kosorat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_kosorat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=25821184;
 //BA.debugLineNum = 25821184;BA.debugLine="Private Sub et_kosorat_TextChanged (Old As String,";
RDebugUtils.currentLine=25821185;
 //BA.debugLineNum = 25821185;BA.debugLine="et_kosorat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_kosorat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=25821186;
 //BA.debugLineNum = 25821186;BA.debugLine="myfunc.change_formater(Old,New,et_kosorat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_kosorat);
RDebugUtils.currentLine=25821187;
 //BA.debugLineNum = 25821187;BA.debugLine="End Sub";
return "";
}
public static String  _et_mazaya_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mazaya_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mazaya_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=25755648;
 //BA.debugLineNum = 25755648;BA.debugLine="Private Sub et_mazaya_TextChanged (Old As String,";
RDebugUtils.currentLine=25755649;
 //BA.debugLineNum = 25755649;BA.debugLine="et_mazaya.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_mazaya.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=25755650;
 //BA.debugLineNum = 25755650;BA.debugLine="myfunc.change_formater(Old,New,et_mazaya)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_mazaya);
RDebugUtils.currentLine=25755651;
 //BA.debugLineNum = 25755651;BA.debugLine="End Sub";
return "";
}
public static String  _et_olad_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_olad_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_olad_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=25690112;
 //BA.debugLineNum = 25690112;BA.debugLine="Private Sub et_olad_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=25690113;
 //BA.debugLineNum = 25690113;BA.debugLine="et_olad.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_olad.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=25690114;
 //BA.debugLineNum = 25690114;BA.debugLine="myfunc.change_formater(Old,New,et_olad)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_olad);
RDebugUtils.currentLine=25690115;
 //BA.debugLineNum = 25690115;BA.debugLine="End Sub";
return "";
}
public static String  _et_paye_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_paye_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_paye_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=25493504;
 //BA.debugLineNum = 25493504;BA.debugLine="Private Sub et_paye_TextChanged (Old As String, Ne";
RDebugUtils.currentLine=25493505;
 //BA.debugLineNum = 25493505;BA.debugLine="If(New=\"\" Or New=Null)Then";
if (((_new).equals("") || _new== null)) { 
RDebugUtils.currentLine=25493506;
 //BA.debugLineNum = 25493506;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=25493509;
 //BA.debugLineNum = 25493509;BA.debugLine="et_paye.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_paye.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=25493510;
 //BA.debugLineNum = 25493510;BA.debugLine="myfunc.change_formater(Old,New,et_paye)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_paye);
RDebugUtils.currentLine=25493512;
 //BA.debugLineNum = 25493512;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=25493513;
 //BA.debugLineNum = 25493513;BA.debugLine="box_control";
_box_control();
RDebugUtils.currentLine=25493514;
 //BA.debugLineNum = 25493514;BA.debugLine="End Sub";
return "";
}
public static String  _et_rozekari_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_rozekari_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_rozekari_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=25624576;
 //BA.debugLineNum = 25624576;BA.debugLine="Private Sub et_rozeKari_TextChanged (Old As String";
RDebugUtils.currentLine=25624577;
 //BA.debugLineNum = 25624577;BA.debugLine="If(New=\"\" Or New=Null)Then";
if (((_new).equals("") || _new== null)) { 
RDebugUtils.currentLine=25624578;
 //BA.debugLineNum = 25624578;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=25624581;
 //BA.debugLineNum = 25624581;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=25624582;
 //BA.debugLineNum = 25624582;BA.debugLine="box_control";
_box_control();
RDebugUtils.currentLine=25624583;
 //BA.debugLineNum = 25624583;BA.debugLine="End Sub";
return "";
}
public static String  _et_sanavat_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_sanavat_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_sanavat_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=25559040;
 //BA.debugLineNum = 25559040;BA.debugLine="Private Sub et_sanavat_TextChanged (Old As String,";
RDebugUtils.currentLine=25559041;
 //BA.debugLineNum = 25559041;BA.debugLine="If(New=\"\" Or New=Null)Then";
if (((_new).equals("") || _new== null)) { 
RDebugUtils.currentLine=25559042;
 //BA.debugLineNum = 25559042;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=25559045;
 //BA.debugLineNum = 25559045;BA.debugLine="et_sanavat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_sanavat.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=25559046;
 //BA.debugLineNum = 25559046;BA.debugLine="myfunc.change_formater(Old,New,et_sanavat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_sanavat);
RDebugUtils.currentLine=25559048;
 //BA.debugLineNum = 25559048;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=25559050;
 //BA.debugLineNum = 25559050;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_vahed_ezafekari_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_vahed_ezafekari_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=25886720;
 //BA.debugLineNum = 25886720;BA.debugLine="Private Sub et_vahed_ezafekari_TextChanged (Old As";
RDebugUtils.currentLine=25886721;
 //BA.debugLineNum = 25886721;BA.debugLine="et_vahed_ezafekari.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=25886722;
 //BA.debugLineNum = 25886722;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari);
RDebugUtils.currentLine=25886723;
 //BA.debugLineNum = 25886723;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_click() throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_click", null));}
RDebugUtils.currentLine=24772608;
 //BA.debugLineNum = 24772608;BA.debugLine="Private Sub lbl_close_Click";
RDebugUtils.currentLine=24772609;
 //BA.debugLineNum = 24772609;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24772610;
 //BA.debugLineNum = 24772610;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_1_click() throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_1_click", null));}
RDebugUtils.currentLine=26083328;
 //BA.debugLineNum = 26083328;BA.debugLine="Private Sub lbl_help_1_Click";
RDebugUtils.currentLine=26083329;
 //BA.debugLineNum = 26083329;BA.debugLine="myfunc.help_man(\"راهنما\",\"اطلاعات حقوق خود را برا";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","اطلاعات حقوق خود را برای 30 روز وارد کنید. توجه داشته باشید محاسبات بر اساس قانون کار سال 1401 می باشد. ");
RDebugUtils.currentLine=26083330;
 //BA.debugLineNum = 26083330;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_2_click() throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_2_click", null));}
RDebugUtils.currentLine=26017792;
 //BA.debugLineNum = 26017792;BA.debugLine="Private Sub lbl_help_2_Click";
RDebugUtils.currentLine=26017793;
 //BA.debugLineNum = 26017793;BA.debugLine="myfunc.help_man(\"راهنما\",\"همه مزایا شامل: حق مسکن";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","همه مزایا شامل: حق مسکن، بن کارگری، حق مسئولیت، حق فنی و ...");
RDebugUtils.currentLine=26017795;
 //BA.debugLineNum = 26017795;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_3_click() throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_3_click", null));}
RDebugUtils.currentLine=25952256;
 //BA.debugLineNum = 25952256;BA.debugLine="Private Sub lbl_help_3_Click";
RDebugUtils.currentLine=25952257;
 //BA.debugLineNum = 25952257;BA.debugLine="myfunc.help_man(\"راهنما\",\"همه کسورات به غیر از بی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","همه کسورات به غیر از بیمه تامین اجتماعی و مالیات");
RDebugUtils.currentLine=25952259;
 //BA.debugLineNum = 25952259;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_click() throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_refresh_vahed_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_refresh_vahed_click", null));}
RDebugUtils.currentLine=25296896;
 //BA.debugLineNum = 25296896;BA.debugLine="Private Sub lbl_refresh_vahed_Click";
RDebugUtils.currentLine=25296897;
 //BA.debugLineNum = 25296897;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
RDebugUtils.currentLine=25296898;
 //BA.debugLineNum = 25296898;BA.debugLine="End Sub";
return "";
}
public static int  _mohasebe_maliat(int _hogog,int _year) throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mohasebe_maliat", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "mohasebe_maliat", new Object[] {_hogog,_year}));}
int _all_maliat = 0;
int _state1 = 0;
int _state2 = 0;
int _state3 = 0;
int _state4 = 0;
int _state5 = 0;
int _state6 = 0;
RDebugUtils.currentLine=25165824;
 //BA.debugLineNum = 25165824;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
RDebugUtils.currentLine=25165825;
 //BA.debugLineNum = 25165825;BA.debugLine="Dim all_maliat As Int=0";
_all_maliat = (int) (0);
RDebugUtils.currentLine=25165826;
 //BA.debugLineNum = 25165826;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
RDebugUtils.currentLine=25165827;
 //BA.debugLineNum = 25165827;BA.debugLine="Dim state2 As Int=0";
_state2 = (int) (0);
RDebugUtils.currentLine=25165828;
 //BA.debugLineNum = 25165828;BA.debugLine="Dim state3 As Int=0";
_state3 = (int) (0);
RDebugUtils.currentLine=25165829;
 //BA.debugLineNum = 25165829;BA.debugLine="Dim state4 As Int=0";
_state4 = (int) (0);
RDebugUtils.currentLine=25165830;
 //BA.debugLineNum = 25165830;BA.debugLine="Dim state5 As Int=0";
_state5 = (int) (0);
RDebugUtils.currentLine=25165831;
 //BA.debugLineNum = 25165831;BA.debugLine="Dim state6 As Int=0";
_state6 = (int) (0);
RDebugUtils.currentLine=25165835;
 //BA.debugLineNum = 25165835;BA.debugLine="If (year=1401)Then";
if ((_year==1401)) { 
RDebugUtils.currentLine=25165836;
 //BA.debugLineNum = 25165836;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
if ((_hogog>5600001 && _hogog<12500001)) { 
RDebugUtils.currentLine=25165837;
 //BA.debugLineNum = 25165837;BA.debugLine="state1=(hogog-5600000)*0.1";
_state1 = (int) ((_hogog-5600000)*0.1);
 };
RDebugUtils.currentLine=25165839;
 //BA.debugLineNum = 25165839;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
if ((_hogog>12500001 && _hogog<20830001)) { 
RDebugUtils.currentLine=25165840;
 //BA.debugLineNum = 25165840;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=25165841;
 //BA.debugLineNum = 25165841;BA.debugLine="state2=(hogog-12500000)*0.15";
_state2 = (int) ((_hogog-12500000)*0.15);
 };
RDebugUtils.currentLine=25165843;
 //BA.debugLineNum = 25165843;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
if ((_hogog>20830001 && _hogog<29160001)) { 
RDebugUtils.currentLine=25165844;
 //BA.debugLineNum = 25165844;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=25165845;
 //BA.debugLineNum = 25165845;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=25165846;
 //BA.debugLineNum = 25165846;BA.debugLine="state3=(hogog-20830000)*0.2";
_state3 = (int) ((_hogog-20830000)*0.2);
 };
RDebugUtils.currentLine=25165849;
 //BA.debugLineNum = 25165849;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
if ((_hogog>29160001)) { 
RDebugUtils.currentLine=25165850;
 //BA.debugLineNum = 25165850;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
RDebugUtils.currentLine=25165851;
 //BA.debugLineNum = 25165851;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
RDebugUtils.currentLine=25165852;
 //BA.debugLineNum = 25165852;BA.debugLine="state3=(8330000)*0.2";
_state3 = (int) ((8330000)*0.2);
RDebugUtils.currentLine=25165854;
 //BA.debugLineNum = 25165854;BA.debugLine="state4=(hogog-29160000)*0.3";
_state4 = (int) ((_hogog-29160000)*0.3);
 };
 };
RDebugUtils.currentLine=25165859;
 //BA.debugLineNum = 25165859;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
_all_maliat = (int) (_state1+_state2+_state3+_state4+_state5+_state6);
RDebugUtils.currentLine=25165860;
 //BA.debugLineNum = 25165860;BA.debugLine="Return all_maliat";
if (true) return _all_maliat;
RDebugUtils.currentLine=25165862;
 //BA.debugLineNum = 25165862;BA.debugLine="End Sub";
return 0;
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=24903680;
 //BA.debugLineNum = 24903680;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=24903681;
 //BA.debugLineNum = 24903681;BA.debugLine="lbl_close_Click";
_lbl_close_click();
RDebugUtils.currentLine=24903682;
 //BA.debugLineNum = 24903682;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel4_click", null));}
RDebugUtils.currentLine=24707072;
 //BA.debugLineNum = 24707072;BA.debugLine="Private Sub Panel4_Click";
RDebugUtils.currentLine=24707074;
 //BA.debugLineNum = 24707074;BA.debugLine="End Sub";
return "";
}
public static String  _sp_olad_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="fast_run_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_olad_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_olad_itemclick", new Object[] {_position,_value}));}
int _num = 0;
RDebugUtils.currentLine=25427968;
 //BA.debugLineNum = 25427968;BA.debugLine="Private Sub sp_olad_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=25427969;
 //BA.debugLineNum = 25427969;BA.debugLine="Dim num As Int=Value";
_num = (int)(BA.ObjectToNumber(_value));
RDebugUtils.currentLine=25427970;
 //BA.debugLineNum = 25427970;BA.debugLine="et_olad.Tag=417975*num";
mostCurrent._et_olad.setTag((Object)(417975*_num));
RDebugUtils.currentLine=25427971;
 //BA.debugLineNum = 25427971;BA.debugLine="et_olad.Text=myfunc.show_num_pool(et_olad.Tag)";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._et_olad.getTag())))));
RDebugUtils.currentLine=25427972;
 //BA.debugLineNum = 25427972;BA.debugLine="End Sub";
return "";
}
}