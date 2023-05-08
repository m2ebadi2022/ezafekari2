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

public class morakhasi_activity extends Activity implements B4AActivity{
	public static morakhasi_activity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.morakhasi_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (morakhasi_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.morakhasi_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.morakhasi_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (morakhasi_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (morakhasi_activity) Resume **");
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
		return morakhasi_activity.class;
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
            BA.LogInfo("** Activity (morakhasi_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (morakhasi_activity) Pause event (activity is not paused). **");
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
            morakhasi_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (morakhasi_activity) Resume **");
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
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_morakhasi = null;
public static int _mande_d = 0;
public static int _mande_h = 0;
public static int _mande_m = 0;
public static int _morkasidarmah_d = 0;
public static int _morkasidarmah_h = 0;
public static int _morkasidarmah_m = 0;
public static int _morakhasi_estefade_esteh = 0;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_mande_show = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mande_d = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mande_h = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mande_m = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_mande_ta_emroz = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_morakhasi_bihogog = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_morakhasi_bahogog = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_morakhasi_estelaj = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_morakhasi_estehgag = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_estehgag_darmah = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_box_edit = null;
public static int _index_box_edit = 0;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk_manfi = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_mandemorakh = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_help_mandeh = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_rozha = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_day1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_moon1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_year1 = null;
public static int _num_datapik = 0;
public anywheresoftware.b4a.objects.collections.List _moon_datapik = null;
public static int _index_datepik = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_set_date = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_all_estehgag = null;
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
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
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

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 75;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 77;BA.debugLine="Activity.LoadLayout(\"morakhasi_layout\")";
mostCurrent._activity.LoadLayout("morakhasi_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 79;BA.debugLine="ScrollView1.Panel.LoadLayout(\"morakhasi_item2\")";
mostCurrent._scrollview1.getPanel().LoadLayout("morakhasi_item2",mostCurrent.activityBA);
 //BA.debugLineNum = 80;BA.debugLine="get_mande_db";
_get_mande_db();
 //BA.debugLineNum = 83;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
 //BA.debugLineNum = 84;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
 //BA.debugLineNum = 89;BA.debugLine="pan_hed_mandeMorakh.Color=Main.color4";
mostCurrent._pan_hed_mandemorakh.setColor(mostCurrent._main._color4 /*int*/ );
 //BA.debugLineNum = 90;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 176;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 177;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 178;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 //BA.debugLineNum = 179;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 181;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 165;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 161;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 163;BA.debugLine="End Sub";
return "";
}
public static String  _all_morakhasiha_bydate(String _date1,String _date2,String _state) throws Exception{
String _str = "";
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div1 = 0;
int _div2 = 0;
int _all_min = 0;
 //BA.debugLineNum = 251;BA.debugLine="Sub all_morakhasiha_byDate(date1 As String , date2";
 //BA.debugLineNum = 253;BA.debugLine="Dim str As String";
_str = "";
 //BA.debugLineNum = 257;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 258;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 259;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 260;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
 //BA.debugLineNum = 261;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
 //BA.debugLineNum = 262;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 263;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from  BETWEEN '"+_date1+"' AND '"+_date2+"' AND state="+_state)));
 //BA.debugLineNum = 264;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 266;BA.debugLine="v_day=v_day+dbCode.res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_d"))));
 //BA.debugLineNum = 267;BA.debugLine="v_hour=v_hour+dbCode.res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_h"))));
 //BA.debugLineNum = 268;BA.debugLine="v_min=v_min+dbCode.res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 272;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 273;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 276;BA.debugLine="Dim all_min As Int";
_all_min = 0;
 //BA.debugLineNum = 277;BA.debugLine="all_min=(v_day*Main.saat_kar_min)+(v_hour*60)+v_m";
_all_min = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
 //BA.debugLineNum = 278;BA.debugLine="v_hour=	myfunc.Min_to_saatMinRoz(all_min).Get(0)";
_v_hour = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_all_min).Get((int) (0))));
 //BA.debugLineNum = 279;BA.debugLine="v_min=	myfunc.Min_to_saatMinRoz(all_min).Get(1)";
_v_min = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_all_min).Get((int) (1))));
 //BA.debugLineNum = 280;BA.debugLine="v_day=	myfunc.Min_to_saatMinRoz(all_min).Get(2)";
_v_day = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_all_min).Get((int) (2))));
 //BA.debugLineNum = 284;BA.debugLine="If(state=0)Then";
if (((_state).equals(BA.NumberToString(0)))) { 
 //BA.debugLineNum = 285;BA.debugLine="morakhasi_estefade_esteh=all_min";
_morakhasi_estefade_esteh = _all_min;
 };
 //BA.debugLineNum = 289;BA.debugLine="str=modify_str_showTime(v_day,v_hour,v_min)";
_str = _modify_str_showtime(_v_day,_v_hour,_v_min);
 //BA.debugLineNum = 290;BA.debugLine="Return str";
if (true) return _str;
 //BA.debugLineNum = 292;BA.debugLine="End Sub";
return "";
}
public static String  _get_mande_db() throws Exception{
 //BA.debugLineNum = 97;BA.debugLine="Sub get_mande_db";
 //BA.debugLineNum = 99;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 100;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
 //BA.debugLineNum = 102;BA.debugLine="dbCode.res.Position=20 ''--------day------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (20));
 //BA.debugLineNum = 103;BA.debugLine="mande_d=dbCode.res.GetString(\"value\")";
_mande_d = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 105;BA.debugLine="dbCode.res.Position=21 ''--------hour------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (21));
 //BA.debugLineNum = 106;BA.debugLine="mande_h=dbCode.res.GetString(\"value\")";
_mande_h = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 108;BA.debugLine="dbCode.res.Position=22 ''--------min------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (22));
 //BA.debugLineNum = 109;BA.debugLine="mande_m=dbCode.res.GetString(\"value\")";
_mande_m = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 112;BA.debugLine="dbCode.res.Position=23";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (23));
 //BA.debugLineNum = 113;BA.debugLine="morkasiDarMah_d=dbCode.res.GetString(\"value\")";
_morkasidarmah_d = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 114;BA.debugLine="dbCode.res.Position=24";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (24));
 //BA.debugLineNum = 115;BA.debugLine="morkasiDarMah_h=dbCode.res.GetString(\"value\")";
_morkasidarmah_h = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 116;BA.debugLine="dbCode.res.Position=25";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (25));
 //BA.debugLineNum = 117;BA.debugLine="morkasiDarMah_m=dbCode.res.GetString(\"value\")";
_morkasidarmah_m = (int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
 //BA.debugLineNum = 125;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 131;BA.debugLine="lbl_mande_show.Text=modify_str_showTime(mande_d,m";
mostCurrent._lbl_mande_show.setText(BA.ObjectToCharSequence(_modify_str_showtime(_mande_d,_mande_h,_mande_m)));
 //BA.debugLineNum = 132;BA.debugLine="lbl_estehgag_darMah.Text=modify_str_showTime(mork";
mostCurrent._lbl_estehgag_darmah.setText(BA.ObjectToCharSequence(_modify_str_showtime(_morkasidarmah_d,_morkasidarmah_h,_morkasidarmah_m)));
 //BA.debugLineNum = 134;BA.debugLine="lbl_date2.Text=myfunc.fa2en(Main.persianDate.Pers";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate())));
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private ScrollView1 As ScrollView";
mostCurrent._scrollview1 = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private pan_all_morakhasi As Panel";
mostCurrent._pan_all_morakhasi = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Dim mande_d As Int";
_mande_d = 0;
 //BA.debugLineNum = 22;BA.debugLine="Dim mande_h As Int";
_mande_h = 0;
 //BA.debugLineNum = 23;BA.debugLine="Dim mande_m As Int";
_mande_m = 0;
 //BA.debugLineNum = 25;BA.debugLine="Dim morkasiDarMah_d As Int";
_morkasidarmah_d = 0;
 //BA.debugLineNum = 26;BA.debugLine="Dim morkasiDarMah_h As Int";
_morkasidarmah_h = 0;
 //BA.debugLineNum = 27;BA.debugLine="Dim morkasiDarMah_m As Int";
_morkasidarmah_m = 0;
 //BA.debugLineNum = 31;BA.debugLine="Dim morakhasi_estefade_esteh As Int=0  ''' min";
_morakhasi_estefade_esteh = (int) (0);
 //BA.debugLineNum = 33;BA.debugLine="Private lbl_mande_show As Label";
mostCurrent._lbl_mande_show = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private et_mande_d As EditText";
mostCurrent._et_mande_d = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private et_mande_h As EditText";
mostCurrent._et_mande_h = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private et_mande_m As EditText";
mostCurrent._et_mande_m = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private lbl_mande_ta_emroz As Label";
mostCurrent._lbl_mande_ta_emroz = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private lbl_morakhasi_BiHogog As Label";
mostCurrent._lbl_morakhasi_bihogog = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private lbl_morakhasi_baHogog As Label";
mostCurrent._lbl_morakhasi_bahogog = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private lbl_morakhasi_estelaj As Label";
mostCurrent._lbl_morakhasi_estelaj = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private lbl_morakhasi_estehgag As Label";
mostCurrent._lbl_morakhasi_estehgag = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private lbl_estehgag_darMah As Label";
mostCurrent._lbl_estehgag_darmah = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private lbl_box_edit As Label";
mostCurrent._lbl_box_edit = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Dim index_box_edit As Int";
_index_box_edit = 0;
 //BA.debugLineNum = 51;BA.debugLine="Private chk_manfi As CheckBox";
mostCurrent._chk_manfi = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private pan_hed_mandeMorakh As Panel";
mostCurrent._pan_hed_mandemorakh = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private lbl_help_mandeh As Label";
mostCurrent._lbl_help_mandeh = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private lbl_date1 As Label";
mostCurrent._lbl_date1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Private lbl_date2 As Label";
mostCurrent._lbl_date2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private lbl_rozha As Label";
mostCurrent._lbl_rozha = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private pik_day1 As Label";
mostCurrent._pik_day1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Private pik_moon1 As Label";
mostCurrent._pik_moon1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private pik_year1 As Label";
mostCurrent._pik_year1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Private pik_day1 As Label";
mostCurrent._pik_day1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Private pik_moon1 As Label";
mostCurrent._pik_moon1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 64;BA.debugLine="Private pik_year1 As Label";
mostCurrent._pik_year1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 66;BA.debugLine="Dim num_dataPik As Int=0  '' for time picker";
_num_datapik = (int) (0);
 //BA.debugLineNum = 68;BA.debugLine="Dim moon_dataPik As List  '' for date picker";
mostCurrent._moon_datapik = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 69;BA.debugLine="Dim index_datePik As Int";
_index_datepik = 0;
 //BA.debugLineNum = 70;BA.debugLine="Private pan_all_set_date As Panel";
mostCurrent._pan_all_set_date = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 72;BA.debugLine="Private lbl_all_estehgag As Label";
mostCurrent._lbl_all_estehgag = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 170;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 172;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 173;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date1_click() throws Exception{
 //BA.debugLineNum = 394;BA.debugLine="Private Sub lbl_date1_Click";
 //BA.debugLineNum = 395;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 396;BA.debugLine="index_datePik=1";
_index_datepik = (int) (1);
 //BA.debugLineNum = 398;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date1.Text.SubStr";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date1.getText().substring((int) (0),(int) (4)))));
 //BA.debugLineNum = 399;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date1.Text.SubStri";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date1.getText().substring((int) (5),(int) (7)))));
 //BA.debugLineNum = 400;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 401;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date1.Text.SubStri";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date1.getText().substring((int) (8),(int) (10)))));
 //BA.debugLineNum = 402;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date2_click() throws Exception{
 //BA.debugLineNum = 384;BA.debugLine="Private Sub lbl_date2_Click";
 //BA.debugLineNum = 385;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 386;BA.debugLine="index_datePik=2";
_index_datepik = (int) (2);
 //BA.debugLineNum = 388;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date2.Text.SubStr";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date2.getText().substring((int) (0),(int) (4)))));
 //BA.debugLineNum = 389;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date2.Text.SubStri";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date2.getText().substring((int) (5),(int) (7)))));
 //BA.debugLineNum = 390;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 391;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date2.Text.SubStri";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date2.getText().substring((int) (8),(int) (10)))));
 //BA.debugLineNum = 392;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_estehgag_click() throws Exception{
 //BA.debugLineNum = 351;BA.debugLine="Private Sub lbl_edit_estehgag_Click";
 //BA.debugLineNum = 352;BA.debugLine="et_mande_d.Text=morkasiDarMah_d";
mostCurrent._et_mande_d.setText(BA.ObjectToCharSequence(_morkasidarmah_d));
 //BA.debugLineNum = 353;BA.debugLine="et_mande_h.Text=morkasiDarMah_h";
mostCurrent._et_mande_h.setText(BA.ObjectToCharSequence(_morkasidarmah_h));
 //BA.debugLineNum = 354;BA.debugLine="et_mande_m.Text=morkasiDarMah_m";
mostCurrent._et_mande_m.setText(BA.ObjectToCharSequence(_morkasidarmah_m));
 //BA.debugLineNum = 356;BA.debugLine="index_box_edit=2";
_index_box_edit = (int) (2);
 //BA.debugLineNum = 357;BA.debugLine="lbl_box_edit.Text=\"تنظیم میزان مرخصی در ماه\"";
mostCurrent._lbl_box_edit.setText(BA.ObjectToCharSequence("تنظیم میزان مرخصی در ماه"));
 //BA.debugLineNum = 358;BA.debugLine="chk_manfi.Visible=False";
mostCurrent._chk_manfi.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 359;BA.debugLine="lbl_help_mandeh.Visible=True";
mostCurrent._lbl_help_mandeh.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 361;BA.debugLine="pan_all_morakhasi.Visible=True";
mostCurrent._pan_all_morakhasi.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 363;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_mande_click() throws Exception{
 //BA.debugLineNum = 366;BA.debugLine="Private Sub lbl_edit_mande_Click";
 //BA.debugLineNum = 367;BA.debugLine="et_mande_d.Text=mande_d";
mostCurrent._et_mande_d.setText(BA.ObjectToCharSequence(_mande_d));
 //BA.debugLineNum = 368;BA.debugLine="et_mande_h.Text=mande_h";
mostCurrent._et_mande_h.setText(BA.ObjectToCharSequence(_mande_h));
 //BA.debugLineNum = 369;BA.debugLine="et_mande_m.Text=mande_m";
mostCurrent._et_mande_m.setText(BA.ObjectToCharSequence(_mande_m));
 //BA.debugLineNum = 371;BA.debugLine="index_box_edit=1";
_index_box_edit = (int) (1);
 //BA.debugLineNum = 372;BA.debugLine="lbl_box_edit.Text=\"تنظیم مانده مرخصی\"";
mostCurrent._lbl_box_edit.setText(BA.ObjectToCharSequence("تنظیم مانده مرخصی"));
 //BA.debugLineNum = 373;BA.debugLine="chk_manfi.Visible=False";
mostCurrent._chk_manfi.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 374;BA.debugLine="lbl_help_mandeh.Visible=False";
mostCurrent._lbl_help_mandeh.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 375;BA.debugLine="pan_all_morakhasi.Visible=True";
mostCurrent._pan_all_morakhasi.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 376;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_mandeh_click() throws Exception{
 //BA.debugLineNum = 378;BA.debugLine="Private Sub lbl_help_mandeh_Click";
 //BA.debugLineNum = 379;BA.debugLine="If(index_box_edit=2)Then";
if ((_index_box_edit==2)) { 
 //BA.debugLineNum = 380;BA.debugLine="myfunc.help_man(\"راهنما\",\"در قانون کار مرخصی است";
mostCurrent._myfunc._help_man /*String*/ (mostCurrent.activityBA,"راهنما","در قانون کار مرخصی استحقاقی در ماه 2 روز و 4 ساعت برای مشاغل عادی و 3 روز برای مشاغل سخت میباشد");
 };
 //BA.debugLineNum = 382;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run_mohasebe_click() throws Exception{
int _rozha = 0;
double _zarib = 0;
int _all_mor1 = 0;
 //BA.debugLineNum = 187;BA.debugLine="Private Sub lbl_run_mohasebe_Click";
 //BA.debugLineNum = 189;BA.debugLine="lbl_morakhasi_estehgag.Text=all_morakhasiha_byDat";
mostCurrent._lbl_morakhasi_estehgag.setText(BA.ObjectToCharSequence(_all_morakhasiha_bydate(mostCurrent._lbl_date1.getText(),mostCurrent._lbl_date2.getText(),BA.NumberToString(0))));
 //BA.debugLineNum = 190;BA.debugLine="lbl_morakhasi_estelaj.Text=all_morakhasiha_byDate";
mostCurrent._lbl_morakhasi_estelaj.setText(BA.ObjectToCharSequence(_all_morakhasiha_bydate(mostCurrent._lbl_date1.getText(),mostCurrent._lbl_date2.getText(),BA.NumberToString(1))));
 //BA.debugLineNum = 191;BA.debugLine="lbl_morakhasi_baHogog.Text=all_morakhasiha_byDate";
mostCurrent._lbl_morakhasi_bahogog.setText(BA.ObjectToCharSequence(_all_morakhasiha_bydate(mostCurrent._lbl_date1.getText(),mostCurrent._lbl_date2.getText(),BA.NumberToString(2))));
 //BA.debugLineNum = 192;BA.debugLine="lbl_morakhasi_BiHogog.Text=all_morakhasiha_byDate";
mostCurrent._lbl_morakhasi_bihogog.setText(BA.ObjectToCharSequence(_all_morakhasiha_bydate(mostCurrent._lbl_date1.getText(),mostCurrent._lbl_date2.getText(),BA.NumberToString(3))));
 //BA.debugLineNum = 195;BA.debugLine="Dim rozha As Int";
_rozha = 0;
 //BA.debugLineNum = 196;BA.debugLine="rozha=myfunc.time_mohasebe(lbl_date1.Text,lbl_dat";
_rozha = mostCurrent._myfunc._time_mohasebe /*int*/ (mostCurrent.activityBA,mostCurrent._lbl_date1.getText(),mostCurrent._lbl_date2.getText());
 //BA.debugLineNum = 197;BA.debugLine="lbl_rozha.Text=rozha";
mostCurrent._lbl_rozha.setText(BA.ObjectToCharSequence(_rozha));
 //BA.debugLineNum = 200;BA.debugLine="Dim zarib As Double=(((morkasiDarMah_d*(Main.saat";
_zarib = (((_morkasidarmah_d*(mostCurrent._main._saat_kar_min /*int*/ /(double)60))+_morkasidarmah_h)*60)/(double)30.5;
 //BA.debugLineNum = 203;BA.debugLine="Dim all_mor1 As Int= (Round(zarib*rozha))+1+(((ma";
_all_mor1 = (int) ((anywheresoftware.b4a.keywords.Common.Round(_zarib*_rozha))+1+(((_mande_d*(mostCurrent._main._saat_kar_min /*int*/ /(double)60))+_mande_h)*60));
 //BA.debugLineNum = 210;BA.debugLine="lbl_all_estehgag.Text= myfunc.Min_to_saatMinRoz(a";
mostCurrent._lbl_all_estehgag.setText(BA.ObjectToCharSequence(BA.ObjectToString(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_all_mor1).Get((int) (2)))+" روز و "+BA.ObjectToString(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_all_mor1).Get((int) (0)))+" ساعت و "+BA.ObjectToString(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_all_mor1).Get((int) (2)))+" دقیقه "));
 //BA.debugLineNum = 212;BA.debugLine="lbl_mande_ta_emroz.Text=myfunc.Min_to_saatMinRoz(";
mostCurrent._lbl_mande_ta_emroz.setText(BA.ObjectToCharSequence(BA.ObjectToString(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_all_mor1-(_morakhasi_estefade_esteh))).Get((int) (2)))+" روز و "+BA.ObjectToString(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_all_mor1-(_morakhasi_estefade_esteh))).Get((int) (0)))+" ساعت و  "+BA.ObjectToString(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,(int) (_all_mor1-(_morakhasi_estefade_esteh))).Get((int) (2)))+" دقیقه "));
 //BA.debugLineNum = 214;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_mande_click() throws Exception{
 //BA.debugLineNum = 304;BA.debugLine="Private Sub lbl_save_mande_Click";
 //BA.debugLineNum = 305;BA.debugLine="If(et_mande_d.Text=\"\")Then";
if (((mostCurrent._et_mande_d.getText()).equals(""))) { 
 //BA.debugLineNum = 306;BA.debugLine="et_mande_d.Text=0";
mostCurrent._et_mande_d.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 308;BA.debugLine="If(et_mande_h.Text=\"\")Then";
if (((mostCurrent._et_mande_h.getText()).equals(""))) { 
 //BA.debugLineNum = 309;BA.debugLine="et_mande_h.Text=0";
mostCurrent._et_mande_h.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 311;BA.debugLine="If(et_mande_m.Text=\"\")Then";
if (((mostCurrent._et_mande_m.getText()).equals(""))) { 
 //BA.debugLineNum = 312;BA.debugLine="et_mande_m.Text=0";
mostCurrent._et_mande_m.setText(BA.ObjectToCharSequence(0));
 };
 //BA.debugLineNum = 320;BA.debugLine="If (et_mande_m.Text > 59)Then";
if (((double)(Double.parseDouble(mostCurrent._et_mande_m.getText()))>59)) { 
 //BA.debugLineNum = 321;BA.debugLine="ToastMessageShow(\"دقیقه باید بین 0 تا 59 باشد\",F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("دقیقه باید بین 0 تا 59 باشد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 322;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 328;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 330;BA.debugLine="If(index_box_edit=1)Then";
if ((_index_box_edit==1)) { 
 //BA.debugLineNum = 331;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_d.getText()+" WHERE name='morakhasi_mande_d'");
 //BA.debugLineNum = 332;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_h.getText()+" WHERE name='morakhasi_mande_h'");
 //BA.debugLineNum = 333;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_m.getText()+" WHERE name='morakhasi_mande_m'");
 }else if((_index_box_edit==2)) { 
 //BA.debugLineNum = 335;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_d.getText()+" WHERE name='morakhasi_darMah_d'");
 //BA.debugLineNum = 336;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_h.getText()+" WHERE name='morakhasi_darMah_h'");
 //BA.debugLineNum = 337;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("UPDATE tb_setting SET value ="+mostCurrent._et_mande_m.getText()+" WHERE name='morakhasi_darMah_m'");
 };
 //BA.debugLineNum = 344;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 346;BA.debugLine="get_mande_db";
_get_mande_db();
 //BA.debugLineNum = 348;BA.debugLine="pan_all_morakhasi_Click";
_pan_all_morakhasi_click();
 //BA.debugLineNum = 349;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
 //BA.debugLineNum = 406;BA.debugLine="Private Sub lbl_save_picker_Click";
 //BA.debugLineNum = 407;BA.debugLine="If(index_datePik=1) Then";
if ((_index_datepik==1)) { 
 //BA.debugLineNum = 408;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&myfunc.convert";
mostCurrent._lbl_date1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 }else if((_index_datepik==2)) { 
 //BA.debugLineNum = 411;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&myfunc.convert";
mostCurrent._lbl_date2.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 };
 //BA.debugLineNum = 413;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 414;BA.debugLine="End Sub";
return "";
}
public static String  _min_to_str1(int _min1) throws Exception{
String _str_result = "";
String _str_state = "";
int _m_day = 0;
int _m_hour = 0;
int _m_min = 0;
int _div1 = 0;
int _min_new = 0;
 //BA.debugLineNum = 217;BA.debugLine="Sub min_to_str1 (min1 As Int ) As String";
 //BA.debugLineNum = 218;BA.debugLine="Dim str_result As String";
_str_result = "";
 //BA.debugLineNum = 219;BA.debugLine="Dim str_state As String=\"\"";
_str_state = "";
 //BA.debugLineNum = 223;BA.debugLine="Dim m_day As Int=0";
_m_day = (int) (0);
 //BA.debugLineNum = 224;BA.debugLine="Dim m_hour As Int=0";
_m_hour = (int) (0);
 //BA.debugLineNum = 225;BA.debugLine="Dim m_min As Int=min1";
_m_min = _min1;
 //BA.debugLineNum = 227;BA.debugLine="Dim div1 As Int=0  '' hour";
_div1 = (int) (0);
 //BA.debugLineNum = 229;BA.debugLine="If(min1>0)Then";
if ((_min1>0)) { 
 //BA.debugLineNum = 230;BA.debugLine="m_hour=	myfunc.Min_to_saatMinRoz(min1).Get(0)";
_m_hour = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min1).Get((int) (0))));
 //BA.debugLineNum = 231;BA.debugLine="m_min=myfunc.Min_to_saatMinRoz(min1).Get(1)";
_m_min = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min1).Get((int) (1))));
 //BA.debugLineNum = 232;BA.debugLine="m_day=myfunc.Min_to_saatMinRoz(min1).Get(2)";
_m_day = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min1).Get((int) (2))));
 }else {
 //BA.debugLineNum = 235;BA.debugLine="Dim min_new As Int = min1*(-1)";
_min_new = (int) (_min1*(-1));
 //BA.debugLineNum = 237;BA.debugLine="m_hour=	myfunc.Min_to_saatMinRoz(min_new).Get(0)";
_m_hour = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min_new).Get((int) (0))));
 //BA.debugLineNum = 238;BA.debugLine="m_min=myfunc.Min_to_saatMinRoz(min_new).Get(1)";
_m_min = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min_new).Get((int) (1))));
 //BA.debugLineNum = 239;BA.debugLine="m_day=myfunc.Min_to_saatMinRoz(min_new).Get(2)";
_m_day = (int)(BA.ObjectToNumber(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (mostCurrent.activityBA,_min_new).Get((int) (2))));
 //BA.debugLineNum = 241;BA.debugLine="str_state=\"-منفی-\"&CRLF";
_str_state = "-منفی-"+anywheresoftware.b4a.keywords.Common.CRLF;
 };
 //BA.debugLineNum = 245;BA.debugLine="str_result=str_state&modify_str_showTime(m_day,m_";
_str_result = _str_state+_modify_str_showtime(_m_day,_m_hour,_m_min);
 //BA.debugLineNum = 247;BA.debugLine="Return str_result";
if (true) return _str_result;
 //BA.debugLineNum = 249;BA.debugLine="End Sub";
return "";
}
public static String  _modify_str_showtime(int _tim_d,int _tim_h,int _tim_m) throws Exception{
String _str_modify1 = "";
 //BA.debugLineNum = 138;BA.debugLine="Sub modify_str_showTime (tim_d As Int, tim_h As In";
 //BA.debugLineNum = 139;BA.debugLine="Dim str_modify1 As String=\"\"";
_str_modify1 = "";
 //BA.debugLineNum = 140;BA.debugLine="If(tim_d<>0)Then";
if ((_tim_d!=0)) { 
 //BA.debugLineNum = 141;BA.debugLine="str_modify1=tim_d&\" روز \"";
_str_modify1 = BA.NumberToString(_tim_d)+" روز ";
 };
 //BA.debugLineNum = 143;BA.debugLine="If(tim_h<>0)Then";
if ((_tim_h!=0)) { 
 //BA.debugLineNum = 144;BA.debugLine="str_modify1=str_modify1&tim_h&\" ساعت \"";
_str_modify1 = _str_modify1+BA.NumberToString(_tim_h)+" ساعت ";
 };
 //BA.debugLineNum = 146;BA.debugLine="If(tim_m<>0)Then";
if ((_tim_m!=0)) { 
 //BA.debugLineNum = 147;BA.debugLine="str_modify1=str_modify1&tim_m&\" دقیقه \"";
_str_modify1 = _str_modify1+BA.NumberToString(_tim_m)+" دقیقه ";
 };
 //BA.debugLineNum = 150;BA.debugLine="If(str_modify1=\"\")Then";
if (((_str_modify1).equals(""))) { 
 //BA.debugLineNum = 151;BA.debugLine="str_modify1=\"-\"";
_str_modify1 = "-";
 };
 //BA.debugLineNum = 154;BA.debugLine="Return str_modify1";
if (true) return _str_modify1;
 //BA.debugLineNum = 156;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_morakhasi_click() throws Exception{
 //BA.debugLineNum = 296;BA.debugLine="Private Sub pan_all_morakhasi_Click";
 //BA.debugLineNum = 297;BA.debugLine="pan_all_morakhasi.Visible=False";
mostCurrent._pan_all_morakhasi.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 298;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_set_date_click() throws Exception{
 //BA.debugLineNum = 617;BA.debugLine="Private Sub pan_all_set_date_Click";
 //BA.debugLineNum = 618;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 619;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
 //BA.debugLineNum = 300;BA.debugLine="Private Sub Panel4_Click";
 //BA.debugLineNum = 302;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 572;BA.debugLine="Private Sub pik_day_bala1_Click";
 //BA.debugLineNum = 573;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 574;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 577;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 578;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 579;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 581;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 582;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 585;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 586;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 588;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 589;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 593;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 595;BA.debugLine="Private Sub pik_day_paeen1_Click";
 //BA.debugLineNum = 596;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 597;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 598;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 599;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 600;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 602;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 603;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 606;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 607;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 609;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 610;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 614;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 518;BA.debugLine="Private Sub pik_moon_bala1_Click";
 //BA.debugLineNum = 519;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 520;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
 //BA.debugLineNum = 522;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 523;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 525;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 526;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 528;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 530;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 532;BA.debugLine="Private Sub pik_moon_paeen1_Click";
 //BA.debugLineNum = 533;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 534;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
 //BA.debugLineNum = 536;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 537;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 539;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 540;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 542;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
 //BA.debugLineNum = 544;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 478;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
 //BA.debugLineNum = 479;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 480;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 481;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 484;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 486;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
 //BA.debugLineNum = 487;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
 //BA.debugLineNum = 488;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 489;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 491;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
 //BA.debugLineNum = 492;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
 //BA.debugLineNum = 493;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 494;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 497;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 498;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 499;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 501;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 502;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 505;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 506;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 508;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 509;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 };
 //BA.debugLineNum = 516;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 418;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
 //BA.debugLineNum = 419;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 420;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 421;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 424;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 426;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
 //BA.debugLineNum = 427;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
 //BA.debugLineNum = 428;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 429;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 431;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
 //BA.debugLineNum = 432;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
 //BA.debugLineNum = 433;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 434;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 437;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 438;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 440;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 441;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 443;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
 //BA.debugLineNum = 446;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 448;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
 //BA.debugLineNum = 449;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 450;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 451;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 454;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 456;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
 //BA.debugLineNum = 457;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
 //BA.debugLineNum = 458;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 459;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 461;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
 //BA.debugLineNum = 462;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
 //BA.debugLineNum = 463;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 464;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 467;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 468;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 470;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 471;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
 //BA.debugLineNum = 476;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 546;BA.debugLine="Private Sub pik_year_bala1_Click";
 //BA.debugLineNum = 547;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 548;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 550;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 551;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 553;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 554;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 557;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 559;BA.debugLine="Private Sub pik_year_paeen1_Click";
 //BA.debugLineNum = 560;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 561;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 563;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 564;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 566;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 567;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 570;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
