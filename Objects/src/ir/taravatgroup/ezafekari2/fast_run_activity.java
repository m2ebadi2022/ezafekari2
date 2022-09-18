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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.fast_run_activity");
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
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
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
 //BA.debugLineNum = 79;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 81;BA.debugLine="Activity.LoadLayout(\"fast_run_layout\")";
mostCurrent._activity.LoadLayout("fast_run_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 82;BA.debugLine="sc_view1.Panel.LoadLayout(\"item_fast_run\")";
mostCurrent._sc_view1.getPanel().LoadLayout("item_fast_run",mostCurrent.activityBA);
 //BA.debugLineNum = 84;BA.debugLine="If(Main.moon_num<7)Then";
if (((double)(Double.parseDouble(mostCurrent._main._moon_num /*String*/ ))<7)) { 
 //BA.debugLineNum = 85;BA.debugLine="et_rozeKari.Text=31";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(31));
 }else {
 //BA.debugLineNum = 87;BA.debugLine="et_rozeKari.Text=30";
mostCurrent._et_rozekari.setText(BA.ObjectToCharSequence(30));
 };
 //BA.debugLineNum = 91;BA.debugLine="get_data_hogogi";
_get_data_hogogi();
 //BA.debugLineNum = 96;BA.debugLine="et_paye.Tag=paye";
mostCurrent._et_paye.setTag((Object)(_paye));
 //BA.debugLineNum = 97;BA.debugLine="et_paye.Text=myfunc.show_num_pool(paye)";
mostCurrent._et_paye.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_paye)));
 //BA.debugLineNum = 99;BA.debugLine="et_sanavat.Tag=sanavat";
mostCurrent._et_sanavat.setTag((Object)(_sanavat));
 //BA.debugLineNum = 100;BA.debugLine="et_sanavat.Text=myfunc.show_num_pool(sanavat)";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_sanavat)));
 //BA.debugLineNum = 102;BA.debugLine="et_mazaya.Tag=mazaya_end";
mostCurrent._et_mazaya.setTag((Object)(_mazaya_end));
 //BA.debugLineNum = 103;BA.debugLine="et_mazaya.Text=myfunc.show_num_pool(mazaya_end)";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_mazaya_end)));
 //BA.debugLineNum = 105;BA.debugLine="et_kosorat.Tag=ksorat_end";
mostCurrent._et_kosorat.setTag((Object)(_ksorat_end));
 //BA.debugLineNum = 106;BA.debugLine="et_kosorat.Text=myfunc.show_num_pool(ksorat_end)";
mostCurrent._et_kosorat.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_ksorat_end)));
 //BA.debugLineNum = 108;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
 //BA.debugLineNum = 109;BA.debugLine="sp_olad.AddAll(Array As String(0,1,2,3,4,5,6,7,8,";
mostCurrent._sp_olad.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9),BA.NumberToString(10)}));
 //BA.debugLineNum = 112;BA.debugLine="imm.Initialize(LoadBitmap(File.DirAssets,\"textBox";
mostCurrent._imm.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"textBox.png").getObject()));
 //BA.debugLineNum = 113;BA.debugLine="imm.Gravity=Gravity.FILL";
mostCurrent._imm.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 114;BA.debugLine="imm2.Initialize(LoadBitmap(File.DirAssets,\"textBo";
mostCurrent._imm2.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"textBox2.png").getObject()));
 //BA.debugLineNum = 115;BA.debugLine="imm2.Gravity=Gravity.FILL";
mostCurrent._imm2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 118;BA.debugLine="box_control";
_box_control();
 //BA.debugLineNum = 120;BA.debugLine="pan_hed_fast_run.Color=Main.color4";
mostCurrent._pan_hed_fast_run.setColor(mostCurrent._main._color4 /*int*/ );
 //BA.debugLineNum = 121;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 122;BA.debugLine="wb_show_result.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._wb_show_result.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 123;BA.debugLine="wb_show_result.ZoomEnabled=False";
mostCurrent._wb_show_result.setZoomEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 144;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 145;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 147;BA.debugLine="If(pan_all.Visible=True)Then";
if ((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 148;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 150;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 //BA.debugLineNum = 153;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 155;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 132;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
public static boolean  _box_control() throws Exception{
boolean _chk = false;
 //BA.debugLineNum = 433;BA.debugLine="Sub box_control As Boolean";
 //BA.debugLineNum = 434;BA.debugLine="et_paye.Background=imm";
mostCurrent._et_paye.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm.getObject()));
 //BA.debugLineNum = 435;BA.debugLine="et_sanavat.Background=imm";
mostCurrent._et_sanavat.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm.getObject()));
 //BA.debugLineNum = 436;BA.debugLine="et_olad.Background=imm";
mostCurrent._et_olad.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm.getObject()));
 //BA.debugLineNum = 437;BA.debugLine="et_mazaya.Background=imm";
mostCurrent._et_mazaya.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm.getObject()));
 //BA.debugLineNum = 438;BA.debugLine="et_kosorat.Background=imm";
mostCurrent._et_kosorat.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm.getObject()));
 //BA.debugLineNum = 439;BA.debugLine="et_rozeKari.Background=imm";
mostCurrent._et_rozekari.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm.getObject()));
 //BA.debugLineNum = 442;BA.debugLine="Dim chk As Boolean=True";
_chk = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 444;BA.debugLine="If(et_paye.Text=\"\")Then";
if (((mostCurrent._et_paye.getText()).equals(""))) { 
 //BA.debugLineNum = 445;BA.debugLine="et_paye.Background=imm2";
mostCurrent._et_paye.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm2.getObject()));
 //BA.debugLineNum = 446;BA.debugLine="chk= False";
_chk = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 448;BA.debugLine="If (et_sanavat.Text=\"\")Then";
if (((mostCurrent._et_sanavat.getText()).equals(""))) { 
 //BA.debugLineNum = 449;BA.debugLine="et_sanavat.Text=0";
mostCurrent._et_sanavat.setText(BA.ObjectToCharSequence(0));
 //BA.debugLineNum = 450;BA.debugLine="et_sanavat.Tag=0";
mostCurrent._et_sanavat.setTag((Object)(0));
 };
 //BA.debugLineNum = 452;BA.debugLine="If (et_olad.Text=\"\")Then";
if (((mostCurrent._et_olad.getText()).equals(""))) { 
 //BA.debugLineNum = 453;BA.debugLine="et_olad.Tag=0";
mostCurrent._et_olad.setTag((Object)(0));
 //BA.debugLineNum = 454;BA.debugLine="et_olad.Text=0";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 456;BA.debugLine="If (et_mazaya.Text=\"\")Then";
if (((mostCurrent._et_mazaya.getText()).equals(""))) { 
 //BA.debugLineNum = 457;BA.debugLine="et_mazaya.Tag=0";
mostCurrent._et_mazaya.setTag((Object)(0));
 //BA.debugLineNum = 458;BA.debugLine="et_mazaya.Text=0";
mostCurrent._et_mazaya.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 460;BA.debugLine="If (et_kosorat.Text=\"\")Then";
if (((mostCurrent._et_kosorat.getText()).equals(""))) { 
 //BA.debugLineNum = 461;BA.debugLine="et_kosorat.Tag=0";
mostCurrent._et_kosorat.setTag((Object)(0));
 //BA.debugLineNum = 462;BA.debugLine="et_kosorat.Text=0";
mostCurrent._et_kosorat.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 464;BA.debugLine="If (et_rozeKari.Text=\"\" Or et_rozeKari.Text>31 Or";
if (((mostCurrent._et_rozekari.getText()).equals("") || (double)(Double.parseDouble(mostCurrent._et_rozekari.getText()))>31 || (double)(Double.parseDouble(mostCurrent._et_rozekari.getText()))<1)) { 
 //BA.debugLineNum = 465;BA.debugLine="et_rozeKari.Background=imm2";
mostCurrent._et_rozekari.setBackground((android.graphics.drawable.Drawable)(mostCurrent._imm2.getObject()));
 //BA.debugLineNum = 466;BA.debugLine="chk= False";
_chk = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 468;BA.debugLine="If(et_time_h.Text=\"\")Then";
if (((mostCurrent._et_time_h.getText()).equals(""))) { 
 //BA.debugLineNum = 469;BA.debugLine="et_time_h.Text=0";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 471;BA.debugLine="If(et_time_m.Text=\"\")Then";
if (((mostCurrent._et_time_m.getText()).equals(""))) { 
 //BA.debugLineNum = 472;BA.debugLine="et_time_m.Text=0";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 476;BA.debugLine="Return chk";
if (true) return _chk;
 //BA.debugLineNum = 477;BA.debugLine="End Sub";
return false;
}
public static String  _btn_run_click() throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _str_show = null;
 //BA.debugLineNum = 169;BA.debugLine="Private Sub btn_run_Click";
 //BA.debugLineNum = 171;BA.debugLine="If (box_control=True)Then";
if ((_box_control()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 173;BA.debugLine="mohasebe";
_mohasebe();
 //BA.debugLineNum = 175;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 176;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
 //BA.debugLineNum = 178;BA.debugLine="str_show.Append(\"<html dir='rtl'><meta charset='";
_str_show.Append("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>");
 //BA.debugLineNum = 180;BA.debugLine="str_show.Append(\"<h5 align='center'>واحد : تومان";
_str_show.Append("<h5 align='center'>واحد : تومان <br>");
 //BA.debugLineNum = 181;BA.debugLine="str_show.Append(\"تعداد روز کاری : \"&myfunc.en2fa";
_str_show.Append("تعداد روز کاری : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,mostCurrent._et_rozekari.getText())+"</h5>");
 //BA.debugLineNum = 183;BA.debugLine="str_show.Append(\"<div style=' border: 2px solid";
_str_show.Append("<div style=' border: 2px solid gray;  padding: 10px; border-radius: 20px;'>");
 //BA.debugLineNum = 184;BA.debugLine="str_show.Append(\" پایه حقوق : \"&myfunc.en2fa(sho";
_str_show.Append(" پایه حقوق : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_paye_end))).Append("<br>");
 //BA.debugLineNum = 185;BA.debugLine="str_show.Append(\" حق سنوات : \"&myfunc.en2fa(show";
_str_show.Append(" حق سنوات : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_sanavat_end))).Append("<br>");
 //BA.debugLineNum = 186;BA.debugLine="str_show.Append(\" حق اولاد : \"&myfunc.en2fa(show";
_str_show.Append(" حق اولاد : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_olad_end))).Append("<br>");
 //BA.debugLineNum = 187;BA.debugLine="str_show.Append(\" مزایا : \"&myfunc.en2fa(show_nu";
_str_show.Append(" مزایا : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_mazaya_end))).Append("<br>");
 //BA.debugLineNum = 188;BA.debugLine="str_show.Append(\" کسورات : \"&myfunc.en2fa(show_n";
_str_show.Append(" کسورات : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_ksorat_end))).Append("<br>");
 //BA.debugLineNum = 189;BA.debugLine="str_show.Append(\"</div>\").Append(\"<br>\")";
_str_show.Append("</div>").Append("<br>");
 //BA.debugLineNum = 191;BA.debugLine="str_show.Append(\"<div style=' border: 2px solid";
_str_show.Append("<div style=' border: 2px solid red;  padding: 10px; border-radius: 20px;'>");
 //BA.debugLineNum = 192;BA.debugLine="str_show.Append(\" بیمه تامین اجتماعی : \"&myfunc.";
_str_show.Append(" بیمه تامین اجتماعی : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_bime_tamin_end))).Append("<br>");
 //BA.debugLineNum = 193;BA.debugLine="str_show.Append(\" مالیات : \"&myfunc.en2fa(show_n";
_str_show.Append(" مالیات : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_maliat_end))).Append("<br>");
 //BA.debugLineNum = 194;BA.debugLine="str_show.Append(\" جمع کسورات : \"&myfunc.en2fa(sh";
_str_show.Append(" جمع کسورات : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_jame_kosorat))).Append("<br>");
 //BA.debugLineNum = 195;BA.debugLine="str_show.Append(\"</div>\").Append(\"<br>\")";
_str_show.Append("</div>").Append("<br>");
 //BA.debugLineNum = 197;BA.debugLine="str_show.Append(\"<div style=' border: 3px solid";
_str_show.Append("<div style=' border: 3px solid green;  padding: 10px; border-radius: 20px;'>");
 //BA.debugLineNum = 198;BA.debugLine="str_show.Append(\" ناخالص حقوق : \"&myfunc.en2fa(s";
_str_show.Append(" ناخالص حقوق : "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_nakhales))).Append("<br>");
 //BA.debugLineNum = 199;BA.debugLine="str_show.Append(\" خالص دریافتی : <mark> \"&myfunc";
_str_show.Append(" خالص دریافتی : <mark> "+mostCurrent._myfunc._en2fa /*String*/ (mostCurrent.activityBA,_show_num_pool(_hogog_khales))+"</mark>");
 //BA.debugLineNum = 200;BA.debugLine="str_show.Append(\"</div>\")";
_str_show.Append("</div>");
 //BA.debugLineNum = 202;BA.debugLine="str_show.Append(\"</body></html>\")";
_str_show.Append("</body></html>");
 //BA.debugLineNum = 205;BA.debugLine="wb_show_result.LoadHtml(str_show.ToString)";
mostCurrent._wb_show_result.LoadHtml(_str_show.ToString());
 //BA.debugLineNum = 209;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 211;BA.debugLine="ToastMessageShow(\"فیلد اشتباه\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("فیلد اشتباه"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return "";
}
public static String  _calc_vahed_ezafekari() throws Exception{
int _a1 = 0;
int _a2 = 0;
int _a3 = 0;
 //BA.debugLineNum = 484;BA.debugLine="Sub calc_vahed_ezafekari";
 //BA.debugLineNum = 485;BA.debugLine="Dim a1,a2,a3 As Int";
_a1 = 0;
_a2 = 0;
_a3 = 0;
 //BA.debugLineNum = 486;BA.debugLine="a1=et_paye.Tag";
_a1 = (int)(BA.ObjectToNumber(mostCurrent._et_paye.getTag()));
 //BA.debugLineNum = 487;BA.debugLine="a2=et_sanavat.Tag";
_a2 = (int)(BA.ObjectToNumber(mostCurrent._et_sanavat.getTag()));
 //BA.debugLineNum = 488;BA.debugLine="a3=et_rozeKari.Text";
_a3 = (int)(Double.parseDouble(mostCurrent._et_rozekari.getText()));
 //BA.debugLineNum = 490;BA.debugLine="paye_end=(a1/30)*a3";
_paye_end = (int) ((_a1/(double)30)*_a3);
 //BA.debugLineNum = 493;BA.debugLine="sanavat_end=(a2/30)*a3";
_sanavat_end = (int) ((_a2/(double)30)*_a3);
 //BA.debugLineNum = 496;BA.debugLine="vahed_ezafekari=((a1+a2)/220)*1.4";
_vahed_ezafekari = (int) (((_a1+_a2)/(double)220)*1.4);
 //BA.debugLineNum = 497;BA.debugLine="et_vahed_ezafekari.Text=myfunc.show_num_pool(vahe";
mostCurrent._et_vahed_ezafekari.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_vahed_ezafekari)));
 //BA.debugLineNum = 498;BA.debugLine="et_vahed_ezafekari.Tag=vahed_ezafekari";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_vahed_ezafekari));
 //BA.debugLineNum = 501;BA.debugLine="End Sub";
return "";
}
public static String  _et_kosorat_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 553;BA.debugLine="Private Sub et_kosorat_TextChanged (Old As String,";
 //BA.debugLineNum = 554;BA.debugLine="et_kosorat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_kosorat.setTag((Object)(_new.replace(",","")));
 //BA.debugLineNum = 555;BA.debugLine="myfunc.change_formater(Old,New,et_kosorat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_kosorat);
 //BA.debugLineNum = 556;BA.debugLine="End Sub";
return "";
}
public static String  _et_mazaya_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 548;BA.debugLine="Private Sub et_mazaya_TextChanged (Old As String,";
 //BA.debugLineNum = 549;BA.debugLine="et_mazaya.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_mazaya.setTag((Object)(_new.replace(",","")));
 //BA.debugLineNum = 550;BA.debugLine="myfunc.change_formater(Old,New,et_mazaya)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_mazaya);
 //BA.debugLineNum = 551;BA.debugLine="End Sub";
return "";
}
public static String  _et_olad_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 543;BA.debugLine="Private Sub et_olad_TextChanged (Old As String, Ne";
 //BA.debugLineNum = 544;BA.debugLine="et_olad.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_olad.setTag((Object)(_new.replace(",","")));
 //BA.debugLineNum = 545;BA.debugLine="myfunc.change_formater(Old,New,et_olad)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_olad);
 //BA.debugLineNum = 546;BA.debugLine="End Sub";
return "";
}
public static String  _et_paye_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 510;BA.debugLine="Private Sub et_paye_TextChanged (Old As String, Ne";
 //BA.debugLineNum = 511;BA.debugLine="If(New=\"\" Or New=Null)Then";
if (((_new).equals("") || _new== null)) { 
 //BA.debugLineNum = 512;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 515;BA.debugLine="et_paye.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_paye.setTag((Object)(_new.replace(",","")));
 //BA.debugLineNum = 516;BA.debugLine="myfunc.change_formater(Old,New,et_paye)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_paye);
 //BA.debugLineNum = 518;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
 //BA.debugLineNum = 519;BA.debugLine="box_control";
_box_control();
 //BA.debugLineNum = 520;BA.debugLine="End Sub";
return "";
}
public static String  _et_rozekari_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 534;BA.debugLine="Private Sub et_rozeKari_TextChanged (Old As String";
 //BA.debugLineNum = 535;BA.debugLine="If(New=\"\" Or New=Null)Then";
if (((_new).equals("") || _new== null)) { 
 //BA.debugLineNum = 536;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 539;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
 //BA.debugLineNum = 540;BA.debugLine="box_control";
_box_control();
 //BA.debugLineNum = 541;BA.debugLine="End Sub";
return "";
}
public static String  _et_sanavat_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 522;BA.debugLine="Private Sub et_sanavat_TextChanged (Old As String,";
 //BA.debugLineNum = 523;BA.debugLine="If(New=\"\" Or New=Null)Then";
if (((_new).equals("") || _new== null)) { 
 //BA.debugLineNum = 524;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 527;BA.debugLine="et_sanavat.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_sanavat.setTag((Object)(_new.replace(",","")));
 //BA.debugLineNum = 528;BA.debugLine="myfunc.change_formater(Old,New,et_sanavat)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_sanavat);
 //BA.debugLineNum = 530;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
 //BA.debugLineNum = 532;BA.debugLine="End Sub";
return "";
}
public static String  _et_vahed_ezafekari_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 558;BA.debugLine="Private Sub et_vahed_ezafekari_TextChanged (Old As";
 //BA.debugLineNum = 559;BA.debugLine="et_vahed_ezafekari.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_vahed_ezafekari.setTag((Object)(_new.replace(",","")));
 //BA.debugLineNum = 560;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_vahed_ezafekari);
 //BA.debugLineNum = 561;BA.debugLine="End Sub";
return "";
}
public static String  _get_data_hogogi() throws Exception{
int _tedad_olad = 0;
String _moon_num = "";
anywheresoftware.b4a.objects.collections.List _list_ezafekari1 = null;
 //BA.debugLineNum = 223;BA.debugLine="Sub get_data_hogogi";
 //BA.debugLineNum = 225;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 226;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
 //BA.debugLineNum = 228;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 229;BA.debugLine="paye=dbCode.res.GetString(\"value\")";
_paye = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 232;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (14));
 //BA.debugLineNum = 233;BA.debugLine="sanavat=dbCode.res.GetString(\"value\")";
_sanavat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 239;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (1));
 //BA.debugLineNum = 240;BA.debugLine="maskan=dbCode.res.GetString(\"value\")";
_maskan = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 242;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (3));
 //BA.debugLineNum = 243;BA.debugLine="olad=dbCode.res.GetString(\"value\")";
_olad = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 245;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (4));
 //BA.debugLineNum = 246;BA.debugLine="fani=dbCode.res.GetString(\"value\")";
_fani = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 248;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (5));
 //BA.debugLineNum = 249;BA.debugLine="masoliat=dbCode.res.GetString(\"value\")";
_masoliat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 251;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (2));
 //BA.debugLineNum = 252;BA.debugLine="bon=dbCode.res.GetString(\"value\")";
_bon = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 254;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (15));
 //BA.debugLineNum = 255;BA.debugLine="sarparasti=dbCode.res.GetString(\"value\")";
_sarparasti = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 257;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (16));
 //BA.debugLineNum = 258;BA.debugLine="mazaya=dbCode.res.GetString(\"value\")";
_mazaya = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 268;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (11));
 //BA.debugLineNum = 269;BA.debugLine="bime_takmil=dbCode.res.GetString(\"value\")";
_bime_takmil = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 274;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (19));
 //BA.debugLineNum = 275;BA.debugLine="ksorat=dbCode.res.GetString(\"value\")";
_ksorat = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 279;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 280;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 283;BA.debugLine="et_olad.Tag=olad";
mostCurrent._et_olad.setTag((Object)(_olad));
 //BA.debugLineNum = 284;BA.debugLine="et_olad.Text=myfunc.show_num_pool(olad)";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,_olad)));
 //BA.debugLineNum = 286;BA.debugLine="If(olad<>0)Then";
if ((_olad!=0)) { 
 //BA.debugLineNum = 287;BA.debugLine="Dim tedad_olad As Int=olad/417975";
_tedad_olad = (int) (_olad/(double)417975);
 //BA.debugLineNum = 288;BA.debugLine="sp_olad.SelectedIndex=tedad_olad";
mostCurrent._sp_olad.setSelectedIndex(_tedad_olad);
 };
 //BA.debugLineNum = 292;BA.debugLine="mazaya_end=maskan+fani+masoliat+sarparasti+bon+ma";
_mazaya_end = (int) (_maskan+_fani+_masoliat+_sarparasti+_bon+_mazaya);
 //BA.debugLineNum = 293;BA.debugLine="ksorat_end=bime_takmil+ksorat";
_ksorat_end = (int) (_bime_takmil+_ksorat);
 //BA.debugLineNum = 297;BA.debugLine="Dim moon_num As String";
_moon_num = "";
 //BA.debugLineNum = 299;BA.debugLine="Select Main.persianDate.PersianMonth";
switch (BA.switchObjectToInt(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth(),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6),(int) (7),(int) (8),(int) (9),(int) (10),(int) (11),(int) (12))) {
case 0: {
 //BA.debugLineNum = 302;BA.debugLine="moon_num=\"01\"";
_moon_num = "01";
 break; }
case 1: {
 //BA.debugLineNum = 304;BA.debugLine="moon_num=\"02\"";
_moon_num = "02";
 break; }
case 2: {
 //BA.debugLineNum = 306;BA.debugLine="moon_num=\"03\"";
_moon_num = "03";
 break; }
case 3: {
 //BA.debugLineNum = 308;BA.debugLine="moon_num=\"04\"";
_moon_num = "04";
 break; }
case 4: {
 //BA.debugLineNum = 310;BA.debugLine="moon_num=\"05\"";
_moon_num = "05";
 break; }
case 5: {
 //BA.debugLineNum = 312;BA.debugLine="moon_num=\"06\"";
_moon_num = "06";
 break; }
case 6: {
 //BA.debugLineNum = 314;BA.debugLine="moon_num=\"07\"";
_moon_num = "07";
 break; }
case 7: {
 //BA.debugLineNum = 316;BA.debugLine="moon_num=\"08\"";
_moon_num = "08";
 break; }
case 8: {
 //BA.debugLineNum = 318;BA.debugLine="moon_num=\"9\"";
_moon_num = "9";
 break; }
case 9: {
 //BA.debugLineNum = 320;BA.debugLine="moon_num=\"10\"";
_moon_num = "10";
 break; }
case 10: {
 //BA.debugLineNum = 322;BA.debugLine="moon_num=\"11\"";
_moon_num = "11";
 break; }
case 11: {
 //BA.debugLineNum = 324;BA.debugLine="moon_num=\"12\"";
_moon_num = "12";
 break; }
}
;
 //BA.debugLineNum = 327;BA.debugLine="Dim list_ezafekari1 As List";
_list_ezafekari1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 328;BA.debugLine="list_ezafekari1.Initialize";
_list_ezafekari1.Initialize();
 //BA.debugLineNum = 329;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_mah(Main.per";
_list_ezafekari1 = mostCurrent._dbcode._all_ezafekari_mah /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear()),_moon_num,(int) (2));
 //BA.debugLineNum = 330;BA.debugLine="et_time_h.Text=list_ezafekari1.Get(0)";
mostCurrent._et_time_h.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (0))));
 //BA.debugLineNum = 331;BA.debugLine="et_time_m.Text=list_ezafekari1.Get(1)";
mostCurrent._et_time_m.setText(BA.ObjectToCharSequence(_list_ezafekari1.Get((int) (1))));
 //BA.debugLineNum = 334;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private pan_all As Panel";
mostCurrent._pan_all = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private et_paye As EditText";
mostCurrent._et_paye = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private et_sanavat As EditText";
mostCurrent._et_sanavat = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private et_maskan As EditText";
mostCurrent._et_maskan = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private et_bon As EditText";
mostCurrent._et_bon = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private et_olad As EditText";
mostCurrent._et_olad = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private et_mazaya As EditText";
mostCurrent._et_mazaya = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private et_kosorat As EditText";
mostCurrent._et_kosorat = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Dim paye As Int";
_paye = 0;
 //BA.debugLineNum = 28;BA.debugLine="Dim sanavat As Int";
_sanavat = 0;
 //BA.debugLineNum = 29;BA.debugLine="Dim mazaya_end As Int";
_mazaya_end = 0;
 //BA.debugLineNum = 30;BA.debugLine="Dim ksorat_end As Int";
_ksorat_end = 0;
 //BA.debugLineNum = 33;BA.debugLine="Dim maskan As Int";
_maskan = 0;
 //BA.debugLineNum = 34;BA.debugLine="Dim olad As Int";
_olad = 0;
 //BA.debugLineNum = 35;BA.debugLine="Dim fani As Int";
_fani = 0;
 //BA.debugLineNum = 36;BA.debugLine="Dim masoliat As Int";
_masoliat = 0;
 //BA.debugLineNum = 37;BA.debugLine="Dim sarparasti As Int";
_sarparasti = 0;
 //BA.debugLineNum = 38;BA.debugLine="Dim mazaya As Int";
_mazaya = 0;
 //BA.debugLineNum = 39;BA.debugLine="Dim bon As Int";
_bon = 0;
 //BA.debugLineNum = 41;BA.debugLine="Dim bime_tamin As Int";
_bime_tamin = 0;
 //BA.debugLineNum = 42;BA.debugLine="Dim bime_takmil As Int";
_bime_takmil = 0;
 //BA.debugLineNum = 43;BA.debugLine="Dim ksorat As Int";
_ksorat = 0;
 //BA.debugLineNum = 45;BA.debugLine="Dim shift As Double";
_shift = 0;
 //BA.debugLineNum = 47;BA.debugLine="Dim shift_end As Int";
_shift_end = 0;
 //BA.debugLineNum = 48;BA.debugLine="Dim paye_end As Int";
_paye_end = 0;
 //BA.debugLineNum = 49;BA.debugLine="Dim sanavat_end As Int";
_sanavat_end = 0;
 //BA.debugLineNum = 50;BA.debugLine="Dim olad_end As Int";
_olad_end = 0;
 //BA.debugLineNum = 52;BA.debugLine="Dim vahed_ezafekari As Int";
_vahed_ezafekari = 0;
 //BA.debugLineNum = 53;BA.debugLine="Dim ezafekari_end As Int";
_ezafekari_end = 0;
 //BA.debugLineNum = 55;BA.debugLine="Dim maliat_end As Int";
_maliat_end = 0;
 //BA.debugLineNum = 57;BA.debugLine="Dim jame_kosorat As Int";
_jame_kosorat = 0;
 //BA.debugLineNum = 59;BA.debugLine="Private sc_view1 As ScrollView";
mostCurrent._sc_view1 = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private et_rozeKari As EditText";
mostCurrent._et_rozekari = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private et_vahed_ezafekari As EditText";
mostCurrent._et_vahed_ezafekari = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Private et_time_h As EditText";
mostCurrent._et_time_h = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Private et_time_m As EditText";
mostCurrent._et_time_m = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 65;BA.debugLine="Dim hogog_nakhales As Int";
_hogog_nakhales = 0;
 //BA.debugLineNum = 66;BA.debugLine="Dim hogog_khales As Int";
_hogog_khales = 0;
 //BA.debugLineNum = 67;BA.debugLine="Dim bime_tamin_end As Int";
_bime_tamin_end = 0;
 //BA.debugLineNum = 68;BA.debugLine="Dim maliat_end As Int";
_maliat_end = 0;
 //BA.debugLineNum = 70;BA.debugLine="Private sp_olad As Spinner";
mostCurrent._sp_olad = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 72;BA.debugLine="Private pan_hed_fast_run As Panel";
mostCurrent._pan_hed_fast_run = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 73;BA.debugLine="Dim imm As BitmapDrawable";
mostCurrent._imm = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 74;BA.debugLine="Dim imm2 As BitmapDrawable";
mostCurrent._imm2 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 76;BA.debugLine="Private wb_show_result As WebView";
mostCurrent._wb_show_result = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 136;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 138;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_click() throws Exception{
 //BA.debugLineNum = 165;BA.debugLine="Private Sub lbl_close_Click";
 //BA.debugLineNum = 166;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_1_click() throws Exception{
 //BA.debugLineNum = 573;BA.debugLine="Private Sub lbl_help_1_Click";
 //BA.debugLineNum = 574;BA.debugLine="myfunc.help_man(\"راهنما\",\"اطلاعات حقوق خود را برا";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","اطلاعات حقوق خود را برای 30 روز وارد کنید. توجه داشته باشید محاسبات بر اساس قانون کار سال 1401 می باشد. ");
 //BA.debugLineNum = 575;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_2_click() throws Exception{
 //BA.debugLineNum = 568;BA.debugLine="Private Sub lbl_help_2_Click";
 //BA.debugLineNum = 569;BA.debugLine="myfunc.help_man(\"راهنما\",\"همه مزایا شامل: حق مسکن";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","همه مزایا شامل: حق مسکن، بن کارگری، حق مسئولیت، حق فنی و ...");
 //BA.debugLineNum = 571;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_3_click() throws Exception{
 //BA.debugLineNum = 563;BA.debugLine="Private Sub lbl_help_3_Click";
 //BA.debugLineNum = 564;BA.debugLine="myfunc.help_man(\"راهنما\",\"همه کسورات به غیر از بی";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","همه کسورات به غیر از بیمه تامین اجتماعی و مالیات");
 //BA.debugLineNum = 566;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_refresh_vahed_click() throws Exception{
 //BA.debugLineNum = 479;BA.debugLine="Private Sub lbl_refresh_vahed_Click";
 //BA.debugLineNum = 480;BA.debugLine="calc_vahed_ezafekari";
_calc_vahed_ezafekari();
 //BA.debugLineNum = 481;BA.debugLine="End Sub";
return "";
}
public static String  _mohasebe() throws Exception{
int _nak_mal = 0;
 //BA.debugLineNum = 340;BA.debugLine="Sub mohasebe";
 //BA.debugLineNum = 350;BA.debugLine="vahed_ezafekari=et_vahed_ezafekari.Tag";
_vahed_ezafekari = (int)(BA.ObjectToNumber(mostCurrent._et_vahed_ezafekari.getTag()));
 //BA.debugLineNum = 351;BA.debugLine="ezafekari_end=vahed_ezafekari*(et_time_h.Text+(et";
_ezafekari_end = (int) (_vahed_ezafekari*((double)(Double.parseDouble(mostCurrent._et_time_h.getText()))+((double)(Double.parseDouble(mostCurrent._et_time_m.getText()))/(double)60)));
 //BA.debugLineNum = 354;BA.debugLine="paye_end=(et_paye.Tag/30)*et_rozeKari.Text";
_paye_end = (int) (((double)(BA.ObjectToNumber(mostCurrent._et_paye.getTag()))/(double)30)*(double)(Double.parseDouble(mostCurrent._et_rozekari.getText())));
 //BA.debugLineNum = 355;BA.debugLine="sanavat_end=(et_sanavat.Tag/30)*et_rozeKari.Text";
_sanavat_end = (int) (((double)(BA.ObjectToNumber(mostCurrent._et_sanavat.getTag()))/(double)30)*(double)(Double.parseDouble(mostCurrent._et_rozekari.getText())));
 //BA.debugLineNum = 357;BA.debugLine="If (et_rozeKari.Text<30)Then";
if (((double)(Double.parseDouble(mostCurrent._et_rozekari.getText()))<30)) { 
 //BA.debugLineNum = 359;BA.debugLine="olad_end=(et_olad.Tag/30)*et_rozeKari.Text";
_olad_end = (int) (((double)(BA.ObjectToNumber(mostCurrent._et_olad.getTag()))/(double)30)*(double)(Double.parseDouble(mostCurrent._et_rozekari.getText())));
 //BA.debugLineNum = 360;BA.debugLine="mazaya_end=(et_mazaya.Tag/30)*et_rozeKari.Text";
_mazaya_end = (int) (((double)(BA.ObjectToNumber(mostCurrent._et_mazaya.getTag()))/(double)30)*(double)(Double.parseDouble(mostCurrent._et_rozekari.getText())));
 }else {
 //BA.debugLineNum = 364;BA.debugLine="olad_end=et_olad.Tag";
_olad_end = (int)(BA.ObjectToNumber(mostCurrent._et_olad.getTag()));
 //BA.debugLineNum = 365;BA.debugLine="mazaya_end=et_mazaya.Tag";
_mazaya_end = (int)(BA.ObjectToNumber(mostCurrent._et_mazaya.getTag()));
 };
 //BA.debugLineNum = 373;BA.debugLine="hogog_nakhales=paye_end+ezafekari_end+sanavat_end";
_hogog_nakhales = (int) (_paye_end+_ezafekari_end+_sanavat_end+_mazaya_end+_olad_end);
 //BA.debugLineNum = 376;BA.debugLine="bime_tamin_end=(hogog_nakhales-olad_end)*0.07";
_bime_tamin_end = (int) ((_hogog_nakhales-_olad_end)*0.07);
 //BA.debugLineNum = 378;BA.debugLine="Dim nak_mal As Int";
_nak_mal = 0;
 //BA.debugLineNum = 379;BA.debugLine="nak_mal=hogog_nakhales-((bime_tamin_end*2)/7)  ''";
_nak_mal = (int) (_hogog_nakhales-((_bime_tamin_end*2)/(double)7));
 //BA.debugLineNum = 383;BA.debugLine="maliat_end=mohasebe_maliat(nak_mal,1401)";
_maliat_end = _mohasebe_maliat(_nak_mal,(int) (1401));
 //BA.debugLineNum = 386;BA.debugLine="jame_kosorat=bime_tamin_end+maliat_end+bime_takmi";
_jame_kosorat = (int) (_bime_tamin_end+_maliat_end+_bime_takmil+_ksorat);
 //BA.debugLineNum = 388;BA.debugLine="hogog_khales=hogog_nakhales-jame_kosorat";
_hogog_khales = (int) (_hogog_nakhales-_jame_kosorat);
 //BA.debugLineNum = 390;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 393;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
 //BA.debugLineNum = 394;BA.debugLine="Dim all_maliat As Int=0";
_all_maliat = (int) (0);
 //BA.debugLineNum = 395;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
 //BA.debugLineNum = 396;BA.debugLine="Dim state2 As Int=0";
_state2 = (int) (0);
 //BA.debugLineNum = 397;BA.debugLine="Dim state3 As Int=0";
_state3 = (int) (0);
 //BA.debugLineNum = 398;BA.debugLine="Dim state4 As Int=0";
_state4 = (int) (0);
 //BA.debugLineNum = 399;BA.debugLine="Dim state5 As Int=0";
_state5 = (int) (0);
 //BA.debugLineNum = 400;BA.debugLine="Dim state6 As Int=0";
_state6 = (int) (0);
 //BA.debugLineNum = 404;BA.debugLine="If (year=1401)Then";
if ((_year==1401)) { 
 //BA.debugLineNum = 405;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
if ((_hogog>5600001 && _hogog<12500001)) { 
 //BA.debugLineNum = 406;BA.debugLine="state1=(hogog-5600000)*0.1";
_state1 = (int) ((_hogog-5600000)*0.1);
 };
 //BA.debugLineNum = 408;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
if ((_hogog>12500001 && _hogog<20830001)) { 
 //BA.debugLineNum = 409;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
 //BA.debugLineNum = 410;BA.debugLine="state2=(hogog-12500000)*0.15";
_state2 = (int) ((_hogog-12500000)*0.15);
 };
 //BA.debugLineNum = 412;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
if ((_hogog>20830001 && _hogog<29160001)) { 
 //BA.debugLineNum = 413;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
 //BA.debugLineNum = 414;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
 //BA.debugLineNum = 415;BA.debugLine="state3=(hogog-20830000)*0.2";
_state3 = (int) ((_hogog-20830000)*0.2);
 };
 //BA.debugLineNum = 418;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
if ((_hogog>29160001)) { 
 //BA.debugLineNum = 419;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
 //BA.debugLineNum = 420;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
 //BA.debugLineNum = 421;BA.debugLine="state3=(8330000)*0.2";
_state3 = (int) ((8330000)*0.2);
 //BA.debugLineNum = 423;BA.debugLine="state4=(hogog-29160000)*0.3";
_state4 = (int) ((_hogog-29160000)*0.3);
 };
 };
 //BA.debugLineNum = 428;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
_all_maliat = (int) (_state1+_state2+_state3+_state4+_state5+_state6);
 //BA.debugLineNum = 429;BA.debugLine="Return all_maliat";
if (true) return _all_maliat;
 //BA.debugLineNum = 431;BA.debugLine="End Sub";
return 0;
}
public static String  _pan_all_click() throws Exception{
 //BA.debugLineNum = 218;BA.debugLine="Private Sub pan_all_Click";
 //BA.debugLineNum = 219;BA.debugLine="lbl_close_Click";
_lbl_close_click();
 //BA.debugLineNum = 220;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
 //BA.debugLineNum = 161;BA.debugLine="Private Sub Panel4_Click";
 //BA.debugLineNum = 163;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(int _num) throws Exception{
 //BA.debugLineNum = 335;BA.debugLine="Sub show_num_pool (num As Int) As String";
 //BA.debugLineNum = 336;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
 //BA.debugLineNum = 337;BA.debugLine="End Sub";
return "";
}
public static String  _sp_olad_itemclick(int _position,Object _value) throws Exception{
int _num = 0;
 //BA.debugLineNum = 504;BA.debugLine="Private Sub sp_olad_ItemClick (Position As Int, Va";
 //BA.debugLineNum = 505;BA.debugLine="Dim num As Int=Value";
_num = (int)(BA.ObjectToNumber(_value));
 //BA.debugLineNum = 506;BA.debugLine="et_olad.Tag=417975*num";
mostCurrent._et_olad.setTag((Object)(417975*_num));
 //BA.debugLineNum = 507;BA.debugLine="et_olad.Text=myfunc.show_num_pool(et_olad.Tag)";
mostCurrent._et_olad.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._et_olad.getTag())))));
 //BA.debugLineNum = 508;BA.debugLine="End Sub";
return "";
}
}
