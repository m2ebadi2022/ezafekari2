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

public class eidi_activity extends Activity implements B4AActivity{
	public static eidi_activity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.eidi_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (eidi_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.eidi_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.eidi_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (eidi_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (eidi_activity) Resume **");
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
		return eidi_activity.class;
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
            BA.LogInfo("** Activity (eidi_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (eidi_activity) Pause event (activity is not paused). **");
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
            eidi_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (eidi_activity) Resume **");
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
public anywheresoftware.b4a.objects.EditTextWrapper _et_payeh = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_eidi = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_eydi = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_day1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_moon1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_year1 = null;
public static int _num_datapik = 0;
public anywheresoftware.b4a.objects.collections.List _moon_datapik = null;
public static int _index_datepik = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_set_date = null;
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
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
 //BA.debugLineNum = 34;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 36;BA.debugLine="Activity.LoadLayout(\"eidi_layout\")";
mostCurrent._activity.LoadLayout("eidi_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 39;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 40;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
 //BA.debugLineNum = 42;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 43;BA.debugLine="et_payeh.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_payeh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 44;BA.debugLine="et_payeh.Text=show_num_pool(dbCode.res.GetString(";
mostCurrent._et_payeh.setText(BA.ObjectToCharSequence(_show_num_pool((int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
 //BA.debugLineNum = 46;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 47;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 50;BA.debugLine="lbl_date1.Text=myfunc.fa2en(Main.persianDate.Pers";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())+"/01/01")));
 //BA.debugLineNum = 51;BA.debugLine="lbl_date2.Text=myfunc.fa2en(Main.persianDate.Pers";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate())));
 //BA.debugLineNum = 59;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
 //BA.debugLineNum = 60;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
 //BA.debugLineNum = 67;BA.debugLine="et_payeh.Color=Colors.White";
mostCurrent._et_payeh.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 68;BA.debugLine="lbl_date1.Color=Colors.White";
mostCurrent._lbl_date1.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 69;BA.debugLine="lbl_date2.Color=Colors.White";
mostCurrent._lbl_date2.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 73;BA.debugLine="pan_hed_eydi.Color=Main.color4";
mostCurrent._pan_hed_eydi.setColor(mostCurrent._main._color4 /*int*/ );
 //BA.debugLineNum = 74;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 92;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 93;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 94;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 //BA.debugLineNum = 95;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 97;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public static String  _btn_mohasebe_eidi_click() throws Exception{
int _eidi_roz = 0;
int _rozha = 0;
int _eidi_nakhales = 0;
int _eidi_khales = 0;
int _eidi_maliat = 0;
 //BA.debugLineNum = 101;BA.debugLine="Private Sub btn_mohasebe_eidi_Click";
 //BA.debugLineNum = 102;BA.debugLine="Dim eidi_roz As Int";
_eidi_roz = 0;
 //BA.debugLineNum = 103;BA.debugLine="Dim rozha As Int";
_rozha = 0;
 //BA.debugLineNum = 104;BA.debugLine="Dim eidi_nakhales As Int";
_eidi_nakhales = 0;
 //BA.debugLineNum = 105;BA.debugLine="Dim eidi_khales As Int";
_eidi_khales = 0;
 //BA.debugLineNum = 106;BA.debugLine="Dim eidi_maliat As Int";
_eidi_maliat = 0;
 //BA.debugLineNum = 108;BA.debugLine="If(et_payeh.Text=\"\")Then";
if (((mostCurrent._et_payeh.getText()).equals(""))) { 
 //BA.debugLineNum = 109;BA.debugLine="et_payeh.Text=0";
mostCurrent._et_payeh.setText(BA.ObjectToCharSequence(0));
 //BA.debugLineNum = 110;BA.debugLine="et_payeh.Tag=0";
mostCurrent._et_payeh.setTag((Object)(0));
 };
 //BA.debugLineNum = 114;BA.debugLine="eidi_roz=(et_payeh.Tag*2)/365";
_eidi_roz = (int) (((double)(BA.ObjectToNumber(mostCurrent._et_payeh.getTag()))*2)/(double)365);
 //BA.debugLineNum = 115;BA.debugLine="rozha=time_mohasebe(lbl_date1.Text,lbl_date2.Text";
_rozha = _time_mohasebe(mostCurrent._lbl_date1.getText(),mostCurrent._lbl_date2.getText());
 //BA.debugLineNum = 117;BA.debugLine="eidi_nakhales=eidi_roz*rozha";
_eidi_nakhales = (int) (_eidi_roz*_rozha);
 //BA.debugLineNum = 118;BA.debugLine="If(rozha=365)Then";
if ((_rozha==365)) { 
 //BA.debugLineNum = 119;BA.debugLine="eidi_nakhales=et_payeh.Tag*2";
_eidi_nakhales = (int) ((double)(BA.ObjectToNumber(mostCurrent._et_payeh.getTag()))*2);
 };
 //BA.debugLineNum = 121;BA.debugLine="eidi_maliat=mohasebe_maliat(eidi_nakhales , myfun";
_eidi_maliat = _mohasebe_maliat(_eidi_nakhales,(int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())))));
 //BA.debugLineNum = 122;BA.debugLine="eidi_khales=eidi_nakhales-eidi_maliat";
_eidi_khales = (int) (_eidi_nakhales-_eidi_maliat);
 //BA.debugLineNum = 124;BA.debugLine="lbl_eidi.Text=\"تعداد روزها : \"&rozha&CRLF&\"ناخالص";
mostCurrent._lbl_eidi.setText(BA.ObjectToCharSequence("تعداد روزها : "+BA.NumberToString(_rozha)+anywheresoftware.b4a.keywords.Common.CRLF+"ناخالص :"+_show_num_pool(_eidi_nakhales)+anywheresoftware.b4a.keywords.Common.CRLF+" مالیات : "+_show_num_pool(_eidi_maliat)+anywheresoftware.b4a.keywords.Common.CRLF+"خالص عیدی دریافتی :"+_show_num_pool(_eidi_khales)));
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public static String  _change_formater(String _old,String _new,anywheresoftware.b4a.objects.EditTextWrapper _et_name) throws Exception{
double _d = 0;
String _s = "";
String _n = "";
String _o = "";
 //BA.debugLineNum = 186;BA.debugLine="Sub change_formater (Old As String, New As String,";
 //BA.debugLineNum = 187;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
_d = 0;
 //BA.debugLineNum = 188;BA.debugLine="Dim S,N,O As String";
_s = "";
_n = "";
_o = "";
 //BA.debugLineNum = 189;BA.debugLine="n=New.Replace(\",\",\"\")";
_n = _new.replace(",","");
 //BA.debugLineNum = 190;BA.debugLine="O=Old.Replace(\",\",\"\")";
_o = _old.replace(",","");
 //BA.debugLineNum = 191;BA.debugLine="If O<>N Then";
if ((_o).equals(_n) == false) { 
 //BA.debugLineNum = 192;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
_et_name.setText(BA.ObjectToCharSequence(_et_name.getText().replace(",","")));
 //BA.debugLineNum = 193;BA.debugLine="S=et_name.Text";
_s = _et_name.getText();
 //BA.debugLineNum = 194;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_s)==anywheresoftware.b4a.keywords.Common.True && (_s).equals("0") == false) { 
 //BA.debugLineNum = 195;BA.debugLine="D=s";
_d = (double)(Double.parseDouble(_s));
 //BA.debugLineNum = 196;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
_et_name.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_d,(int) (0),(int) (0))));
 };
 };
 //BA.debugLineNum = 199;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
_et_name.setSelectionStart(_et_name.getText().length());
 //BA.debugLineNum = 200;BA.debugLine="End Sub";
return "";
}
public static String  _et_payeh_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 201;BA.debugLine="Private Sub et_payeh_TextChanged (Old As String, N";
 //BA.debugLineNum = 202;BA.debugLine="et_payeh.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_payeh.setTag((Object)(_new.replace(",","")));
 //BA.debugLineNum = 203;BA.debugLine="change_formater(Old,New,et_payeh)";
_change_formater(_old,_new,mostCurrent._et_payeh);
 //BA.debugLineNum = 204;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private et_payeh As EditText";
mostCurrent._et_payeh = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private lbl_eidi As Label";
mostCurrent._lbl_eidi = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private pan_hed_eydi As Panel";
mostCurrent._pan_hed_eydi = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private lbl_date2 As Label";
mostCurrent._lbl_date2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_date1 As Label";
mostCurrent._lbl_date1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private pik_day1 As Label";
mostCurrent._pik_day1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private pik_moon1 As Label";
mostCurrent._pik_moon1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private pik_year1 As Label";
mostCurrent._pik_year1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Dim num_dataPik As Int=0  '' for time picker";
_num_datapik = (int) (0);
 //BA.debugLineNum = 29;BA.debugLine="Dim moon_dataPik As List  '' for date picker";
mostCurrent._moon_datapik = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 30;BA.debugLine="Dim index_datePik As Int";
_index_datepik = 0;
 //BA.debugLineNum = 31;BA.debugLine="Private pan_all_set_date As Panel";
mostCurrent._pan_all_set_date = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 89;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date1_click() throws Exception{
 //BA.debugLineNum = 304;BA.debugLine="Private Sub lbl_date1_Click";
 //BA.debugLineNum = 305;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 306;BA.debugLine="index_datePik=1";
_index_datepik = (int) (1);
 //BA.debugLineNum = 308;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date1.Text.SubStr";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date1.getText().substring((int) (0),(int) (4)))));
 //BA.debugLineNum = 309;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date1.Text.SubStri";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date1.getText().substring((int) (6),(int) (7)))));
 //BA.debugLineNum = 310;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 311;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date1.Text.SubStri";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date1.getText().substring((int) (8),(int) (10)))));
 //BA.debugLineNum = 312;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date2_click() throws Exception{
 //BA.debugLineNum = 314;BA.debugLine="Private Sub lbl_date2_Click";
 //BA.debugLineNum = 315;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 316;BA.debugLine="index_datePik=2";
_index_datepik = (int) (2);
 //BA.debugLineNum = 318;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date2.Text.SubStr";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date2.getText().substring((int) (0),(int) (4)))));
 //BA.debugLineNum = 319;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date2.Text.SubStri";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date2.getText().substring((int) (6),(int) (7)))));
 //BA.debugLineNum = 320;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 321;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date2.Text.SubStri";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date2.getText().substring((int) (8),(int) (10)))));
 //BA.debugLineNum = 322;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
 //BA.debugLineNum = 324;BA.debugLine="Private Sub lbl_save_picker_Click";
 //BA.debugLineNum = 325;BA.debugLine="If(index_datePik=1) Then";
if ((_index_datepik==1)) { 
 //BA.debugLineNum = 326;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&myfunc.convert";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 }else if((_index_datepik==2)) { 
 //BA.debugLineNum = 329;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&myfunc.convert";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 };
 //BA.debugLineNum = 331;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 332;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 208;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
 //BA.debugLineNum = 209;BA.debugLine="Dim all_maliat As Int=0";
_all_maliat = (int) (0);
 //BA.debugLineNum = 210;BA.debugLine="Dim state1 As Int=0";
_state1 = (int) (0);
 //BA.debugLineNum = 211;BA.debugLine="Dim state2 As Int=0";
_state2 = (int) (0);
 //BA.debugLineNum = 212;BA.debugLine="Dim state3 As Int=0";
_state3 = (int) (0);
 //BA.debugLineNum = 213;BA.debugLine="Dim state4 As Int=0";
_state4 = (int) (0);
 //BA.debugLineNum = 214;BA.debugLine="Dim state5 As Int=0";
_state5 = (int) (0);
 //BA.debugLineNum = 215;BA.debugLine="Dim state6 As Int=0";
_state6 = (int) (0);
 //BA.debugLineNum = 217;BA.debugLine="If (year=1399)Then";
if ((_year==1399)) { 
 //BA.debugLineNum = 218;BA.debugLine="If(hogog>3000001 And hogog<7500001)Then	  ''----";
if ((_hogog>3000001 && _hogog<7500001)) { 
 //BA.debugLineNum = 219;BA.debugLine="state1=(hogog-3000000)*0.1";
_state1 = (int) ((_hogog-3000000)*0.1);
 };
 //BA.debugLineNum = 221;BA.debugLine="If(hogog>7500001 And hogog<10500001)Then	  ''---";
if ((_hogog>7500001 && _hogog<10500001)) { 
 //BA.debugLineNum = 222;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
 //BA.debugLineNum = 223;BA.debugLine="state2=(hogog-7500000)*0.15";
_state2 = (int) ((_hogog-7500000)*0.15);
 };
 //BA.debugLineNum = 225;BA.debugLine="If(hogog>10500001 And hogog<15000001)Then	  ''--";
if ((_hogog>10500001 && _hogog<15000001)) { 
 //BA.debugLineNum = 226;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
 //BA.debugLineNum = 227;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
 //BA.debugLineNum = 228;BA.debugLine="state3=(hogog-10500000)*0.2";
_state3 = (int) ((_hogog-10500000)*0.2);
 };
 //BA.debugLineNum = 230;BA.debugLine="If(hogog>15000001)Then	  ''-----stat4";
if ((_hogog>15000001)) { 
 //BA.debugLineNum = 231;BA.debugLine="state1=(3000000)*0.1";
_state1 = (int) ((3000000)*0.1);
 //BA.debugLineNum = 232;BA.debugLine="state2=(3000000)*0.15";
_state2 = (int) ((3000000)*0.15);
 //BA.debugLineNum = 233;BA.debugLine="state3=(4500000)*0.2";
_state3 = (int) ((4500000)*0.2);
 //BA.debugLineNum = 234;BA.debugLine="state4=(hogog-15000001)*0.25";
_state4 = (int) ((_hogog-15000001)*0.25);
 };
 };
 //BA.debugLineNum = 238;BA.debugLine="If (year=1400)Then";
if ((_year==1400)) { 
 //BA.debugLineNum = 239;BA.debugLine="If(hogog>4000001 And hogog<8000001)Then	  ''----";
if ((_hogog>4000001 && _hogog<8000001)) { 
 //BA.debugLineNum = 240;BA.debugLine="state1=(hogog-4000000)*0.1";
_state1 = (int) ((_hogog-4000000)*0.1);
 };
 //BA.debugLineNum = 242;BA.debugLine="If(hogog>8000001 And hogog<12000001)Then	  ''---";
if ((_hogog>8000001 && _hogog<12000001)) { 
 //BA.debugLineNum = 243;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
 //BA.debugLineNum = 244;BA.debugLine="state2=(hogog-8000000)*0.15";
_state2 = (int) ((_hogog-8000000)*0.15);
 };
 //BA.debugLineNum = 246;BA.debugLine="If(hogog>12000001 And hogog<18000001)Then	  ''--";
if ((_hogog>12000001 && _hogog<18000001)) { 
 //BA.debugLineNum = 247;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
 //BA.debugLineNum = 248;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
 //BA.debugLineNum = 249;BA.debugLine="state3=(hogog-12000000)*0.2";
_state3 = (int) ((_hogog-12000000)*0.2);
 };
 //BA.debugLineNum = 251;BA.debugLine="If(hogog>18000001 And hogog<24000001)Then	  ''--";
if ((_hogog>18000001 && _hogog<24000001)) { 
 //BA.debugLineNum = 252;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
 //BA.debugLineNum = 253;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
 //BA.debugLineNum = 254;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
 //BA.debugLineNum = 255;BA.debugLine="state4=(hogog-18000000)*0.25";
_state4 = (int) ((_hogog-18000000)*0.25);
 };
 //BA.debugLineNum = 257;BA.debugLine="If(hogog>24000001 And hogog<32000001)Then	  ''--";
if ((_hogog>24000001 && _hogog<32000001)) { 
 //BA.debugLineNum = 258;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
 //BA.debugLineNum = 259;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
 //BA.debugLineNum = 260;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
 //BA.debugLineNum = 261;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
 //BA.debugLineNum = 262;BA.debugLine="state5=(hogog-24000000)*0.3";
_state5 = (int) ((_hogog-24000000)*0.3);
 };
 //BA.debugLineNum = 264;BA.debugLine="If(hogog>32000001)Then	  ''-----stat4";
if ((_hogog>32000001)) { 
 //BA.debugLineNum = 265;BA.debugLine="state1=(4000000)*0.1";
_state1 = (int) ((4000000)*0.1);
 //BA.debugLineNum = 266;BA.debugLine="state2=(4000000)*0.15";
_state2 = (int) ((4000000)*0.15);
 //BA.debugLineNum = 267;BA.debugLine="state3=(4000000)*0.2";
_state3 = (int) ((4000000)*0.2);
 //BA.debugLineNum = 268;BA.debugLine="state4=(6000000)*0.25";
_state4 = (int) ((6000000)*0.25);
 //BA.debugLineNum = 269;BA.debugLine="state5=(6000000)*0.3";
_state5 = (int) ((6000000)*0.3);
 //BA.debugLineNum = 270;BA.debugLine="state6=(hogog-32000000)*0.35";
_state6 = (int) ((_hogog-32000000)*0.35);
 };
 };
 //BA.debugLineNum = 274;BA.debugLine="If (year=1401)Then";
if ((_year==1401)) { 
 //BA.debugLineNum = 275;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
if ((_hogog>5600001 && _hogog<12500001)) { 
 //BA.debugLineNum = 276;BA.debugLine="state1=(hogog-5600000)*0.1";
_state1 = (int) ((_hogog-5600000)*0.1);
 };
 //BA.debugLineNum = 278;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
if ((_hogog>12500001 && _hogog<20830001)) { 
 //BA.debugLineNum = 279;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
 //BA.debugLineNum = 280;BA.debugLine="state2=(hogog-12500000)*0.15";
_state2 = (int) ((_hogog-12500000)*0.15);
 };
 //BA.debugLineNum = 282;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
if ((_hogog>20830001 && _hogog<29160001)) { 
 //BA.debugLineNum = 283;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
 //BA.debugLineNum = 284;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
 //BA.debugLineNum = 285;BA.debugLine="state3=(hogog-20830000)*0.2";
_state3 = (int) ((_hogog-20830000)*0.2);
 };
 //BA.debugLineNum = 288;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
if ((_hogog>29160001)) { 
 //BA.debugLineNum = 289;BA.debugLine="state1=(6900000)*0.1";
_state1 = (int) ((6900000)*0.1);
 //BA.debugLineNum = 290;BA.debugLine="state2=(8330000)*0.15";
_state2 = (int) ((8330000)*0.15);
 //BA.debugLineNum = 291;BA.debugLine="state3=(8330000)*0.2";
_state3 = (int) ((8330000)*0.2);
 //BA.debugLineNum = 293;BA.debugLine="state4=(hogog-29160000)*0.3";
_state4 = (int) ((_hogog-29160000)*0.3);
 };
 };
 //BA.debugLineNum = 298;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
_all_maliat = (int) (_state1+_state2+_state3+_state4+_state5+_state6);
 //BA.debugLineNum = 299;BA.debugLine="Return all_maliat";
if (true) return _all_maliat;
 //BA.debugLineNum = 301;BA.debugLine="End Sub";
return 0;
}
public static String  _pan_all_set_date_click() throws Exception{
 //BA.debugLineNum = 535;BA.debugLine="Private Sub pan_all_set_date_Click";
 //BA.debugLineNum = 536;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 537;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 490;BA.debugLine="Private Sub pik_day_bala1_Click";
 //BA.debugLineNum = 491;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 492;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 495;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 496;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 497;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 499;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 500;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 503;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 504;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 506;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 507;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 511;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 513;BA.debugLine="Private Sub pik_day_paeen1_Click";
 //BA.debugLineNum = 514;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 515;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 516;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 517;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 518;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 520;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 521;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 524;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 525;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 527;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 528;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 532;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 436;BA.debugLine="Private Sub pik_moon_bala1_Click";
 //BA.debugLineNum = 437;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 438;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
 //BA.debugLineNum = 440;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 441;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 443;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 444;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 446;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 448;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 450;BA.debugLine="Private Sub pik_moon_paeen1_Click";
 //BA.debugLineNum = 451;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 452;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
 //BA.debugLineNum = 454;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 455;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 457;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 458;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 460;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
 //BA.debugLineNum = 462;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 396;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
 //BA.debugLineNum = 397;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 398;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 399;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 402;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 404;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
 //BA.debugLineNum = 405;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
 //BA.debugLineNum = 406;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 407;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 409;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
 //BA.debugLineNum = 410;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
 //BA.debugLineNum = 411;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 412;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 415;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 416;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 417;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 419;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 420;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 423;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 424;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 426;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 427;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 };
 //BA.debugLineNum = 434;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 336;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
 //BA.debugLineNum = 337;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 338;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 339;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 342;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 344;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
 //BA.debugLineNum = 345;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
 //BA.debugLineNum = 346;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 347;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 349;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
 //BA.debugLineNum = 350;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
 //BA.debugLineNum = 351;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 352;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 355;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 356;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 358;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 359;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 361;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
 //BA.debugLineNum = 364;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 366;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
 //BA.debugLineNum = 367;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 368;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 369;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 372;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 374;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
 //BA.debugLineNum = 375;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
 //BA.debugLineNum = 376;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 377;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 379;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
 //BA.debugLineNum = 380;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
 //BA.debugLineNum = 381;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 382;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 385;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 386;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 388;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 389;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
 //BA.debugLineNum = 394;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 464;BA.debugLine="Private Sub pik_year_bala1_Click";
 //BA.debugLineNum = 465;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 466;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 468;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 469;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 471;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 472;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 475;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 477;BA.debugLine="Private Sub pik_year_paeen1_Click";
 //BA.debugLineNum = 478;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 479;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 481;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 482;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 484;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 485;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 488;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(int _num) throws Exception{
 //BA.debugLineNum = 183;BA.debugLine="Sub show_num_pool (num As Int) As String";
 //BA.debugLineNum = 184;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
return "";
}
public static int  _time_mohasebe(String _date1,String _date2) throws Exception{
adr.stringfunctions.stringfunctions _strfun = null;
anywheresoftware.b4a.objects.collections.List _list_date_per1 = null;
anywheresoftware.b4a.objects.collections.List _list_date_per2 = null;
anywheresoftware.b4a.objects.collections.List _list_date_miladi1 = null;
anywheresoftware.b4a.objects.collections.List _list_date_miladi2 = null;
String _dat_mil_2 = "";
String _dat_mil_1 = "";
String _date_end1 = "";
String _date_end2 = "";
long _tim1_long = 0L;
long _tim2_long = 0L;
int _rozha = 0;
 //BA.debugLineNum = 128;BA.debugLine="Sub time_mohasebe(date1 As String, date2 As String";
 //BA.debugLineNum = 130;BA.debugLine="Try";
try { //BA.debugLineNum = 132;BA.debugLine="Dim strfun As StringFunctions";
_strfun = new adr.stringfunctions.stringfunctions();
 //BA.debugLineNum = 133;BA.debugLine="strfun.Initialize";
_strfun._initialize(processBA);
 //BA.debugLineNum = 134;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 135;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 136;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
 //BA.debugLineNum = 137;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
 //BA.debugLineNum = 139;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
 //BA.debugLineNum = 140;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
 //BA.debugLineNum = 141;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 142;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 146;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = _strfun._vvvvvv5(_date1,"/");
 //BA.debugLineNum = 147;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = _strfun._vvvvvv5(_date2,"/");
 //BA.debugLineNum = 151;BA.debugLine="dat_mil_2=Main.persianDate.PersianToGregorian(li";
_dat_mil_2 = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
 //BA.debugLineNum = 152;BA.debugLine="dat_mil_1=Main.persianDate.PersianToGregorian(li";
_dat_mil_1 = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
 //BA.debugLineNum = 155;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = _strfun._vvvvvv5(_dat_mil_1,"/");
 //BA.debugLineNum = 156;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = _strfun._vvvvvv5(_dat_mil_2,"/");
 //BA.debugLineNum = 159;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
 //BA.debugLineNum = 162;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
 //BA.debugLineNum = 163;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
 //BA.debugLineNum = 168;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
 //BA.debugLineNum = 169;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
 //BA.debugLineNum = 170;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),"00:00:00");
 //BA.debugLineNum = 171;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),"00:00:00");
 //BA.debugLineNum = 172;BA.debugLine="Dim rozha As Int";
_rozha = 0;
 //BA.debugLineNum = 173;BA.debugLine="rozha=Main.persianDate.CalculateDaysBetween(myfu";
_rozha = (int) (mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .CalculateDaysBetween(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2)));
 //BA.debugLineNum = 175;BA.debugLine="Return rozha+1";
if (true) return (int) (_rozha+1);
 } 
       catch (Exception e29) {
			processBA.setLastException(e29); //BA.debugLineNum = 178;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
return 0;
}
}
