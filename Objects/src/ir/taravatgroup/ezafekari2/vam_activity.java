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

public class vam_activity extends Activity implements B4AActivity{
	public static vam_activity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.vam_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (vam_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.vam_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.vam_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (vam_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (vam_activity) Resume **");
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
		return vam_activity.class;
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
            BA.LogInfo("** Activity (vam_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (vam_activity) Pause event (activity is not paused). **");
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
            vam_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (vam_activity) Resume **");
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
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui2 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_list2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_moon1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_year1 = null;
public static int _num_datapik = 0;
public anywheresoftware.b4a.objects.collections.List _moon_datapik = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onvan2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_mablagh2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_remove_from_list2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_tozih2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1_2 = null;
public b4a.example3.customlistview _cust_lv_vam = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_icon2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_set_date = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_add = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_onvan = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mablagh_vam = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_nerkh_vam = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_tedad_gest = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_kol_bazpardakht = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_hargest = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_tozih = null;
public anywheresoftware.b4a.objects.WebViewWrapper _wb_show_result = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_show_info = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_info = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_go_agsatpage = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_vam = null;
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
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.list2_activity _list2_activity = null;
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
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 65;BA.debugLine="Activity.LoadLayout(\"vam_layout\")";
mostCurrent._activity.LoadLayout("vam_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 69;BA.debugLine="pan_hed_vam.Color=Main.color4";
mostCurrent._pan_hed_vam.setColor(mostCurrent._main._color4 /*int*/ );
 //BA.debugLineNum = 70;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 74;BA.debugLine="fill_list_vam";
_fill_list_vam();
 //BA.debugLineNum = 77;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
 //BA.debugLineNum = 78;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
 //BA.debugLineNum = 81;BA.debugLine="lbl_date.Text=Main.persianDate.PersianYear&\"/\"&my";
mostCurrent._lbl_date.setText(BA.ObjectToCharSequence(BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth())));
 //BA.debugLineNum = 84;BA.debugLine="wb_show_result.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._wb_show_result.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 85;BA.debugLine="wb_show_result.ZoomEnabled=False";
mostCurrent._wb_show_result.setZoomEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 173;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 174;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 175;BA.debugLine="If(pan_all_set_date.Visible=True)Then";
if ((mostCurrent._pan_all_set_date.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 176;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_all_add.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 178;BA.debugLine="pan_all_add.Visible=False";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_all_show_info.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 181;BA.debugLine="pan_all_show_info.Visible=False";
mostCurrent._pan_all_show_info.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 183;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 //BA.debugLineNum = 186;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 188;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public static String  _et_mablagh_vam_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 237;BA.debugLine="Private Sub et_mablagh_vam_TextChanged (Old As Str";
 //BA.debugLineNum = 238;BA.debugLine="et_mablagh_vam.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_mablagh_vam.setTag((Object)(_new.replace(",","")));
 //BA.debugLineNum = 239;BA.debugLine="myfunc.change_formater(Old,New,et_mablagh_vam)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_mablagh_vam);
 //BA.debugLineNum = 240;BA.debugLine="mohasebe";
_mohasebe();
 //BA.debugLineNum = 241;BA.debugLine="End Sub";
return "";
}
public static String  _et_nerkh_vam_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 462;BA.debugLine="Private Sub et_nerkh_vam_TextChanged (Old As Strin";
 //BA.debugLineNum = 463;BA.debugLine="mohasebe";
_mohasebe();
 //BA.debugLineNum = 464;BA.debugLine="End Sub";
return "";
}
public static String  _et_tedad_gest_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 466;BA.debugLine="Private Sub et_tedad_gest_TextChanged (Old As Stri";
 //BA.debugLineNum = 467;BA.debugLine="mohasebe";
_mohasebe();
 //BA.debugLineNum = 468;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_vam() throws Exception{
 //BA.debugLineNum = 99;BA.debugLine="Sub fill_list_vam";
 //BA.debugLineNum = 102;BA.debugLine="cust_LV_vam.Clear";
mostCurrent._cust_lv_vam._clear();
 //BA.debugLineNum = 105;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 106;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_vam ORDER BY  date DESC;")));
 //BA.debugLineNum = 109;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 114;BA.debugLine="p = xui2.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui2.CreatePanel(processBA,"p");
 //BA.debugLineNum = 115;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 165dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (165)));
 //BA.debugLineNum = 116;BA.debugLine="p.LoadLayout(\"item_list_vam\")";
mostCurrent._p.LoadLayout("item_list_vam",mostCurrent.activityBA);
 //BA.debugLineNum = 118;BA.debugLine="cust_LV_vam.Add(p,dbCode.res.GetString(\"id\"))";
mostCurrent._cust_lv_vam._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 120;BA.debugLine="lbl_onvan2.Text=dbCode.res.GetString(\"onvan\")";
mostCurrent._lbl_onvan2.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan")));
 //BA.debugLineNum = 124;BA.debugLine="lbl_mablagh2.Tag=dbCode.res.GetString(\"mablag\")";
mostCurrent._lbl_mablagh2.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablag")));
 //BA.debugLineNum = 125;BA.debugLine="lbl_mablagh2.Text=\" مبلغ وام :\" & myfunc.show_nu";
mostCurrent._lbl_mablagh2.setText(BA.ObjectToCharSequence(" مبلغ وام :"+mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_mablagh2.getTag())))));
 //BA.debugLineNum = 127;BA.debugLine="lbl_tozih2.Text=dbCode.res.GetString(\"tozihat\")";
mostCurrent._lbl_tozih2.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 129;BA.debugLine="lbl_icon2.Text=Chr(0xF274)  'def";
mostCurrent._lbl_icon2.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf274))));
 //BA.debugLineNum = 130;BA.debugLine="lbl_icon2.Color=0xFF00A3FF";
mostCurrent._lbl_icon2.setColor(((int)0xff00a3ff));
 //BA.debugLineNum = 132;BA.debugLine="lbl_remove_from_list2.tag=dbCode.res.GetString(\"";
mostCurrent._lbl_remove_from_list2.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 133;BA.debugLine="lbl_info.tag=dbCode.res.GetString(\"id\")";
mostCurrent._lbl_info.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 135;BA.debugLine="lbl_go_agsatPage.Tag=dbCode.res.GetString(\"idvam";
mostCurrent._lbl_go_agsatpage.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("idvam")));
 }
;
 //BA.debugLineNum = 142;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 143;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 145;BA.debugLine="If(cust_LV_vam.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_vam._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 146;BA.debugLine="p = xui2.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui2.CreatePanel(processBA,"p");
 //BA.debugLineNum = 147;BA.debugLine="Select cust_LV_vam.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_vam._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 149;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((380-100)));
 break; }
case 1: {
 //BA.debugLineNum = 151;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 153;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 155;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 157;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 159;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 161;BA.debugLine="cust_LV_vam.Add(p,\"\")";
mostCurrent._cust_lv_vam._add(mostCurrent._p,(Object)(""));
 };
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim xui2 As XUI";
mostCurrent._xui2 = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 17;BA.debugLine="Dim p As B4XView";
mostCurrent._p = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private pan_hed_list2 As Panel";
mostCurrent._pan_hed_list2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private pik_moon1 As Label";
mostCurrent._pik_moon1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private pik_year1 As Label";
mostCurrent._pik_year1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Dim num_dataPik As Int=0  '' for time picker";
_num_datapik = (int) (0);
 //BA.debugLineNum = 28;BA.debugLine="Dim moon_dataPik As List  '' for date picker";
mostCurrent._moon_datapik = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 30;BA.debugLine="Private lbl_onvan2 As Label";
mostCurrent._lbl_onvan2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private lbl_date2 As Label";
mostCurrent._lbl_date2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private lbl_mablagh2 As Label";
mostCurrent._lbl_mablagh2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private lbl_remove_from_list2 As Label";
mostCurrent._lbl_remove_from_list2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private lbl_tozih2 As Label";
mostCurrent._lbl_tozih2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private Panel1_2 As Panel";
mostCurrent._panel1_2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private cust_LV_vam As CustomListView";
mostCurrent._cust_lv_vam = new b4a.example3.customlistview();
 //BA.debugLineNum = 38;BA.debugLine="Private lbl_icon2 As Label";
mostCurrent._lbl_icon2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private pan_all_set_date As Panel";
mostCurrent._pan_all_set_date = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private pan_all_add As Panel";
mostCurrent._pan_all_add = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private cust_LV_vam As CustomListView";
mostCurrent._cust_lv_vam = new b4a.example3.customlistview();
 //BA.debugLineNum = 46;BA.debugLine="Private et_onvan As EditText";
mostCurrent._et_onvan = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private et_mablagh_vam As EditText";
mostCurrent._et_mablagh_vam = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private et_nerkh_vam As EditText";
mostCurrent._et_nerkh_vam = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private et_tedad_gest As EditText";
mostCurrent._et_tedad_gest = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private lbl_kol_bazPardakht As Label";
mostCurrent._lbl_kol_bazpardakht = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private lbl_harGest As Label";
mostCurrent._lbl_hargest = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private lbl_date As Label";
mostCurrent._lbl_date = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private et_tozih As EditText";
mostCurrent._et_tozih = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private wb_show_result As WebView";
mostCurrent._wb_show_result = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Private pan_all_show_info As Panel";
mostCurrent._pan_all_show_info = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private lbl_info As Label";
mostCurrent._lbl_info = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private lbl_go_agsatPage As Label";
mostCurrent._lbl_go_agsatpage = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private pan_hed_vam As Panel";
mostCurrent._pan_hed_vam = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_add_vam_click() throws Exception{
 //BA.debugLineNum = 369;BA.debugLine="Private Sub lbl_add_vam_Click";
 //BA.debugLineNum = 371;BA.debugLine="pan_all_add.Visible=True";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 373;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_agsat_click() throws Exception{
 //BA.debugLineNum = 483;BA.debugLine="Private Sub lbl_agsat_Click";
 //BA.debugLineNum = 484;BA.debugLine="pan_all_show_info.Visible=False";
mostCurrent._pan_all_show_info.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 486;BA.debugLine="StartActivity(gestha_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._gestha_activity.getObject()));
 //BA.debugLineNum = 487;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 169;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 170;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 171;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_click() throws Exception{
 //BA.debugLineNum = 489;BA.debugLine="Private Sub lbl_close_Click";
 //BA.debugLineNum = 490;BA.debugLine="pan_all_show_info.Visible=False";
mostCurrent._pan_all_show_info.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 491;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_click() throws Exception{
 //BA.debugLineNum = 379;BA.debugLine="Private Sub lbl_date_Click";
 //BA.debugLineNum = 380;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 383;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date.Text.SubStri";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date.getText().substring((int) (0),(int) (4)))));
 //BA.debugLineNum = 384;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date.Text.SubStrin";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date.getText().substring((int) (5),(int) (7)))));
 //BA.debugLineNum = 385;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 389;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_go_agsatpage_click() throws Exception{
 //BA.debugLineNum = 470;BA.debugLine="Private Sub lbl_go_agsatPage_Click";
 //BA.debugLineNum = 471;BA.debugLine="Main.current_idvam=lbl_go_agsatPage.Tag";
mostCurrent._main._current_idvam /*String*/  = BA.ObjectToString(mostCurrent._lbl_go_agsatpage.getTag());
 //BA.debugLineNum = 472;BA.debugLine="StartActivity(gestha_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._gestha_activity.getObject()));
 //BA.debugLineNum = 473;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_info_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _b = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _str_show = null;
 //BA.debugLineNum = 494;BA.debugLine="Private Sub lbl_info_Click";
 //BA.debugLineNum = 496;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 497;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 499;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 500;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_vam WHERE id="+BA.ObjectToString(_b.getTag()))));
 //BA.debugLineNum = 501;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 502;BA.debugLine="Main.current_idvam= dbCode.res.GetString(\"idvam\")";
mostCurrent._main._current_idvam /*String*/  = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("idvam");
 //BA.debugLineNum = 505;BA.debugLine="pan_all_show_info.Visible=True";
mostCurrent._pan_all_show_info.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 509;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 510;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
 //BA.debugLineNum = 512;BA.debugLine="str_show.Append(\"<html dir='rtl'><meta charset='U";
_str_show.Append("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>");
 //BA.debugLineNum = 514;BA.debugLine="str_show.Append(\"<h5 align='center'>عنوان وام <br";
_str_show.Append("<h5 align='center'>عنوان وام <br>");
 //BA.debugLineNum = 515;BA.debugLine="str_show.Append(dbCode.res.GetString(\"onvan\"))";
_str_show.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan"));
 //BA.debugLineNum = 516;BA.debugLine="str_show.Append(\"</h5>\")";
_str_show.Append("</h5>");
 //BA.debugLineNum = 518;BA.debugLine="str_show.Append(\"<div style=' border: 2px solid g";
_str_show.Append("<div style=' border: 2px solid gray;  padding: 10px; border-radius: 20px;'>");
 //BA.debugLineNum = 519;BA.debugLine="str_show.Append(\" مبلغ وام : \"&myfunc.show_num_po";
_str_show.Append(" مبلغ وام : "+mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablag"))))).Append("<br>");
 //BA.debugLineNum = 520;BA.debugLine="str_show.Append(\"نرخ وام % : \"&(dbCode.res.GetStr";
_str_show.Append("نرخ وام % : "+(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("rate"))).Append("<br>");
 //BA.debugLineNum = 521;BA.debugLine="str_show.Append(\" تعداد اقساط : \"&(dbCode.res.Get";
_str_show.Append(" تعداد اقساط : "+(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("count"))).Append("<br>");
 //BA.debugLineNum = 522;BA.debugLine="str_show.Append(\" ماه شروع : \"&(dbCode.res.GetStr";
_str_show.Append(" ماه شروع : "+(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date"))).Append("<br>");
 //BA.debugLineNum = 523;BA.debugLine="str_show.Append(\" توضیحات : \"&(dbCode.res.GetStri";
_str_show.Append(" توضیحات : "+(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat"))).Append("<br>");
 //BA.debugLineNum = 524;BA.debugLine="str_show.Append(\"</div>\").Append(\"<br>\")";
_str_show.Append("</div>").Append("<br>");
 //BA.debugLineNum = 526;BA.debugLine="str_show.Append(\"<div style=' border: 3px solid g";
_str_show.Append("<div style=' border: 3px solid green;  padding: 10px; border-radius: 20px;'>");
 //BA.debugLineNum = 527;BA.debugLine="str_show.Append(\" کل مبلغ بازپرداخت  : \"&myfunc.s";
_str_show.Append(" کل مبلغ بازپرداخت  : "+mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("bazpardakht"))))).Append("<br>");
 //BA.debugLineNum = 528;BA.debugLine="str_show.Append(\" مبلغ هر قسط : <mark> \"&myfunc.s";
_str_show.Append(" مبلغ هر قسط : <mark> "+mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("harghest"))))+"</mark>");
 //BA.debugLineNum = 529;BA.debugLine="str_show.Append(\"</div>\")";
_str_show.Append("</div>");
 //BA.debugLineNum = 531;BA.debugLine="str_show.Append(\"</body></html>\")";
_str_show.Append("</body></html>");
 //BA.debugLineNum = 534;BA.debugLine="wb_show_result.LoadHtml(str_show.ToString)";
mostCurrent._wb_show_result.LoadHtml(_str_show.ToString());
 //BA.debugLineNum = 537;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list2_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _b = null;
String _get_idvam = "";
int _result = 0;
 //BA.debugLineNum = 192;BA.debugLine="Private Sub lbl_remove_from_list2_Click";
 //BA.debugLineNum = 194;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 195;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 197;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 198;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_vam WHERE id="+BA.ObjectToString(_b.getTag()))));
 //BA.debugLineNum = 199;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
 //BA.debugLineNum = 200;BA.debugLine="Dim  get_idvam As String= dbCode.res.GetString(\"i";
_get_idvam = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("idvam");
 //BA.debugLineNum = 202;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 203;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 204;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 206;BA.debugLine="If (dbCode.delete_vam(b.Tag))Then";
if ((mostCurrent._dbcode._delete_vam /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 208;BA.debugLine="dbCode.delete_ghestha(get_idvam)";
mostCurrent._dbcode._delete_ghestha /*boolean*/ (mostCurrent.activityBA,_get_idvam);
 //BA.debugLineNum = 209;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 212;BA.debugLine="fill_list_vam";
_fill_list_vam();
 };
 };
 //BA.debugLineNum = 221;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_click() throws Exception{
String _random_idvam = "";
String _shomare_gest = "";
String _date_gest = "";
int _date_year = 0;
int _date_moon = 0;
int _i = 0;
 //BA.debugLineNum = 391;BA.debugLine="Private Sub lbl_save_Click";
 //BA.debugLineNum = 392;BA.debugLine="If(et_onvan.Text=\"\")Then";
if (((mostCurrent._et_onvan.getText()).equals(""))) { 
 //BA.debugLineNum = 393;BA.debugLine="ToastMessageShow(\" عنوان وام را وارد کنید\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" عنوان وام را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else if(((mostCurrent._et_mablagh_vam.getText()).equals(""))) { 
 //BA.debugLineNum = 396;BA.debugLine="ToastMessageShow(\"مبلغ وام را وارد کنید\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("مبلغ وام را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else if(((mostCurrent._et_nerkh_vam.getText()).equals(""))) { 
 //BA.debugLineNum = 399;BA.debugLine="ToastMessageShow(\"نرخ وام را وارد کنید\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("نرخ وام را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else if(((mostCurrent._et_tedad_gest.getText()).equals(""))) { 
 //BA.debugLineNum = 402;BA.debugLine="ToastMessageShow(\"تعداد قسط ها را وارد کنید\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تعداد قسط ها را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 405;BA.debugLine="Dim random_idvam As String=myfunc.random_id(5)";
_random_idvam = mostCurrent._myfunc._random_id /*String*/ (mostCurrent.activityBA,(int) (5));
 //BA.debugLineNum = 407;BA.debugLine="dbCode.add_vam(random_idvam,et_onvan.Text,et_mab";
mostCurrent._dbcode._add_vam /*boolean*/ (mostCurrent.activityBA,_random_idvam,mostCurrent._et_onvan.getText(),BA.ObjectToString(mostCurrent._et_mablagh_vam.getTag()),mostCurrent._et_tedad_gest.getText(),mostCurrent._et_nerkh_vam.getText(),BA.NumberToString(1),mostCurrent._lbl_date.getText(),BA.ObjectToString(mostCurrent._lbl_kol_bazpardakht.getTag()),BA.ObjectToString(mostCurrent._lbl_hargest.getTag()),mostCurrent._et_tozih.getText(),(int) (0));
 //BA.debugLineNum = 408;BA.debugLine="Dim shomare_gest As String=\"\"";
_shomare_gest = "";
 //BA.debugLineNum = 409;BA.debugLine="Dim date_gest As String= lbl_date.Text";
_date_gest = mostCurrent._lbl_date.getText();
 //BA.debugLineNum = 410;BA.debugLine="Dim date_year As Int=lbl_date.Text.SubString2(0,";
_date_year = (int)(Double.parseDouble(mostCurrent._lbl_date.getText().substring((int) (0),(int) (4))));
 //BA.debugLineNum = 411;BA.debugLine="Dim date_moon As Int=lbl_date.Text.SubString2(5,";
_date_moon = (int)(Double.parseDouble(mostCurrent._lbl_date.getText().substring((int) (5),(int) (7))));
 //BA.debugLineNum = 413;BA.debugLine="For i=1 To et_tedad_gest.Text";
{
final int step16 = 1;
final int limit16 = (int)(Double.parseDouble(mostCurrent._et_tedad_gest.getText()));
_i = (int) (1) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
 //BA.debugLineNum = 416;BA.debugLine="shomare_gest = \"شماره قسط :\"& (i)";
_shomare_gest = "شماره قسط :"+BA.NumberToString((_i));
 //BA.debugLineNum = 417;BA.debugLine="dbCode.add_gest(random_idvam,date_gest,lbl_harG";
mostCurrent._dbcode._add_gest /*boolean*/ (mostCurrent.activityBA,_random_idvam,_date_gest,BA.ObjectToString(mostCurrent._lbl_hargest.getTag()),"",(int) (0));
 //BA.debugLineNum = 420;BA.debugLine="date_moon=date_moon+1";
_date_moon = (int) (_date_moon+1);
 //BA.debugLineNum = 421;BA.debugLine="If(date_moon>12)Then";
if ((_date_moon>12)) { 
 //BA.debugLineNum = 422;BA.debugLine="date_moon=1";
_date_moon = (int) (1);
 //BA.debugLineNum = 423;BA.debugLine="date_year=date_year+1";
_date_year = (int) (_date_year+1);
 };
 //BA.debugLineNum = 426;BA.debugLine="date_gest=myfunc.convert_adad( date_year)&\"/\"&m";
_date_gest = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_date_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_date_moon);
 }
};
 //BA.debugLineNum = 430;BA.debugLine="fill_list_vam";
_fill_list_vam();
 //BA.debugLineNum = 431;BA.debugLine="pan_all_add.Visible=False";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 435;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
 //BA.debugLineNum = 245;BA.debugLine="Private Sub lbl_save_picker_Click";
 //BA.debugLineNum = 246;BA.debugLine="lbl_date.Text=pik_year1.Text&\"/\"&myfunc.convert_a";
mostCurrent._lbl_date.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))));
 //BA.debugLineNum = 247;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return "";
}
public static String  _mohasebe() throws Exception{
double _eb1 = 0;
double _sorat = 0;
double _makhraj = 0;
double _gest = 0;
double _sod = 0;
 //BA.debugLineNum = 437;BA.debugLine="Sub mohasebe";
 //BA.debugLineNum = 438;BA.debugLine="If(et_mablagh_vam.Text=\"\" Or et_nerkh_vam.Text=\"\"";
if (((mostCurrent._et_mablagh_vam.getText()).equals("") || (mostCurrent._et_nerkh_vam.getText()).equals("") || (mostCurrent._et_tedad_gest.getText()).equals(""))) { 
 }else {
 //BA.debugLineNum = 442;BA.debugLine="Dim eb1 As Double=Power( (1+(et_nerkh_vam.Text/1";
_eb1 = anywheresoftware.b4a.keywords.Common.Power((1+((double)(Double.parseDouble(mostCurrent._et_nerkh_vam.getText()))/(double)1200)),(double)(Double.parseDouble(mostCurrent._et_tedad_gest.getText())));
 //BA.debugLineNum = 443;BA.debugLine="Dim sorat As Double=et_mablagh_vam.Tag*(et_nerkh";
_sorat = (double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag()))*((double)(Double.parseDouble(mostCurrent._et_nerkh_vam.getText()))/(double)1200)*_eb1;
 //BA.debugLineNum = 444;BA.debugLine="Dim makhraj As Double=eb1-1";
_makhraj = _eb1-1;
 //BA.debugLineNum = 446;BA.debugLine="Dim gest As Double=sorat/makhraj";
_gest = _sorat/(double)_makhraj;
 //BA.debugLineNum = 448;BA.debugLine="Dim sod As Double=(gest*et_tedad_gest.Text)-et_m";
_sod = (_gest*(double)(Double.parseDouble(mostCurrent._et_tedad_gest.getText())))-(double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag()));
 //BA.debugLineNum = 451;BA.debugLine="lbl_harGest.Tag=Round(gest)";
mostCurrent._lbl_hargest.setTag((Object)(anywheresoftware.b4a.keywords.Common.Round(_gest)));
 //BA.debugLineNum = 452;BA.debugLine="lbl_kol_bazPardakht.Tag=Round(et_mablagh_vam.Tag";
mostCurrent._lbl_kol_bazpardakht.setTag((Object)(anywheresoftware.b4a.keywords.Common.Round((double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag()))+_sod)));
 //BA.debugLineNum = 454;BA.debugLine="lbl_harGest.Text=myfunc.show_num_pool(Round(gest";
mostCurrent._lbl_hargest.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int) (anywheresoftware.b4a.keywords.Common.Round(_gest)))+" تومان "));
 //BA.debugLineNum = 455;BA.debugLine="lbl_kol_bazPardakht.Text=myfunc.show_num_pool(Ro";
mostCurrent._lbl_kol_bazpardakht.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int) (anywheresoftware.b4a.keywords.Common.Round((double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag()))+_sod)))+" تومان "));
 };
 //BA.debugLineNum = 460;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_add_click() throws Exception{
 //BA.debugLineNum = 375;BA.debugLine="Private Sub pan_all_add_Click";
 //BA.debugLineNum = 376;BA.debugLine="pan_all_add.Visible=False";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 377;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_set_date_click() throws Exception{
 //BA.debugLineNum = 230;BA.debugLine="Private Sub pan_all_set_date_Click";
 //BA.debugLineNum = 231;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_show_info_click() throws Exception{
 //BA.debugLineNum = 475;BA.debugLine="Private Sub pan_all_show_info_Click";
 //BA.debugLineNum = 476;BA.debugLine="pan_all_show_info.Visible=False";
mostCurrent._pan_all_show_info.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 477;BA.debugLine="End Sub";
return "";
}
public static String  _panel2_click() throws Exception{
 //BA.debugLineNum = 479;BA.debugLine="Private Sub Panel2_Click";
 //BA.debugLineNum = 481;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
 //BA.debugLineNum = 226;BA.debugLine="Private Sub Panel4_Click";
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 313;BA.debugLine="Private Sub pik_moon_bala1_Click";
 //BA.debugLineNum = 314;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 315;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
 //BA.debugLineNum = 317;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 318;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 320;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 321;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 323;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 325;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 327;BA.debugLine="Private Sub pik_moon_paeen1_Click";
 //BA.debugLineNum = 328;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 329;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
 //BA.debugLineNum = 331;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 332;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 334;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 335;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 337;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
 //BA.debugLineNum = 339;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 252;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
 //BA.debugLineNum = 253;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 254;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 255;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 258;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 260;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
 //BA.debugLineNum = 261;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
 //BA.debugLineNum = 262;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 263;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 265;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
 //BA.debugLineNum = 266;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
 //BA.debugLineNum = 267;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 268;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 271;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 272;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 274;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 275;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 277;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
 //BA.debugLineNum = 280;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 282;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
 //BA.debugLineNum = 283;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 284;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 285;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 288;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 290;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
 //BA.debugLineNum = 291;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
 //BA.debugLineNum = 292;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 293;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 295;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
 //BA.debugLineNum = 296;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
 //BA.debugLineNum = 297;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 298;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 301;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 302;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 304;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 305;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
 //BA.debugLineNum = 310;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 341;BA.debugLine="Private Sub pik_year_bala1_Click";
 //BA.debugLineNum = 342;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 343;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 345;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 346;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 348;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 349;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 352;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 354;BA.debugLine="Private Sub pik_year_paeen1_Click";
 //BA.debugLineNum = 355;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 356;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 358;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 359;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 361;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 362;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 365;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
