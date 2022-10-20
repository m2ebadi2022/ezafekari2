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
public anywheresoftware.b4a.objects.LabelWrapper _pik_day1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_moon1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_year1 = null;
public static int _num_datapik = 0;
public anywheresoftware.b4a.objects.collections.List _moon_datapik = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onvan2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_mablagh2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_show2 = null;
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
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.list2_activity _list2_activity = null;
public ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
public ir.taravatgroup.ezafekari2.sayer_activity _sayer_activity = null;
public ir.taravatgroup.ezafekari2.ayabzahab_activity _ayabzahab_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.food_activity _food_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.mosaedeh_activity _mosaedeh_activity = null;
public ir.taravatgroup.ezafekari2.padash_activity _padash_activity = null;
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
 //BA.debugLineNum = 72;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 74;BA.debugLine="Activity.LoadLayout(\"vam_layout\")";
mostCurrent._activity.LoadLayout("vam_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 77;BA.debugLine="pan_hed_list2.Color=Main.color4";
mostCurrent._pan_hed_list2.setColor(mostCurrent._main._color4 /*int*/ );
 //BA.debugLineNum = 83;BA.debugLine="fill_list_vam";
_fill_list_vam();
 //BA.debugLineNum = 86;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
 //BA.debugLineNum = 87;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 175;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 176;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 177;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 //BA.debugLineNum = 178;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 180;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 94;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public static String  _et_mablagh_vam_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 306;BA.debugLine="Private Sub et_mablagh_vam_TextChanged (Old As Str";
 //BA.debugLineNum = 307;BA.debugLine="et_mablagh_vam.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_mablagh_vam.setTag((Object)(_new.replace(",","")));
 //BA.debugLineNum = 308;BA.debugLine="myfunc.change_formater(Old,New,et_mablagh_vam)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_mablagh_vam);
 //BA.debugLineNum = 309;BA.debugLine="mohasebe";
_mohasebe();
 //BA.debugLineNum = 310;BA.debugLine="End Sub";
return "";
}
public static String  _et_nerkh_vam_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 576;BA.debugLine="Private Sub et_nerkh_vam_TextChanged (Old As Strin";
 //BA.debugLineNum = 577;BA.debugLine="mohasebe";
_mohasebe();
 //BA.debugLineNum = 578;BA.debugLine="End Sub";
return "";
}
public static String  _et_tedad_gest_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 580;BA.debugLine="Private Sub et_tedad_gest_TextChanged (Old As Stri";
 //BA.debugLineNum = 581;BA.debugLine="mohasebe";
_mohasebe();
 //BA.debugLineNum = 582;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_vam() throws Exception{
 //BA.debugLineNum = 104;BA.debugLine="Sub fill_list_vam";
 //BA.debugLineNum = 107;BA.debugLine="cust_LV_vam.Clear";
mostCurrent._cust_lv_vam._clear();
 //BA.debugLineNum = 110;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 111;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_vam ORDER BY  date DESC;")));
 //BA.debugLineNum = 114;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
 //BA.debugLineNum = 119;BA.debugLine="p = xui2.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui2.CreatePanel(processBA,"p");
 //BA.debugLineNum = 120;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
 //BA.debugLineNum = 121;BA.debugLine="p.LoadLayout(\"item_list_vam\")";
mostCurrent._p.LoadLayout("item_list_vam",mostCurrent.activityBA);
 //BA.debugLineNum = 123;BA.debugLine="cust_LV_vam.Add(p,dbCode.res.GetString(\"id\"))";
mostCurrent._cust_lv_vam._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 125;BA.debugLine="lbl_onvan2.Text=dbCode.res.GetString(\"onvan\")";
mostCurrent._lbl_onvan2.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan")));
 //BA.debugLineNum = 128;BA.debugLine="lbl_mablagh2.Tag=dbCode.res.GetString(\"mablag\")";
mostCurrent._lbl_mablagh2.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablag")));
 //BA.debugLineNum = 129;BA.debugLine="lbl_mablagh2.Text=\" مبلغ وام :\" & myfunc.show_nu";
mostCurrent._lbl_mablagh2.setText(BA.ObjectToCharSequence(" مبلغ وام :"+mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_mablagh2.getTag())))));
 //BA.debugLineNum = 131;BA.debugLine="lbl_tozih2.Text=dbCode.res.GetString(\"tozihat\")";
mostCurrent._lbl_tozih2.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
 //BA.debugLineNum = 133;BA.debugLine="lbl_icon2.Text=Chr(0xF274)  'def";
mostCurrent._lbl_icon2.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf274))));
 //BA.debugLineNum = 134;BA.debugLine="lbl_icon2.Color=0xFF00A3FF";
mostCurrent._lbl_icon2.setColor(((int)0xff00a3ff));
 //BA.debugLineNum = 136;BA.debugLine="lbl_remove_from_list2.tag=dbCode.res.GetString(\"";
mostCurrent._lbl_remove_from_list2.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 //BA.debugLineNum = 137;BA.debugLine="lbl_show2.tag=dbCode.res.GetString(\"id\")";
mostCurrent._lbl_show2.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
 //BA.debugLineNum = 144;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 145;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 147;BA.debugLine="If(cust_LV_vam.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_vam._getlastvisibleindex()<5)) { 
 //BA.debugLineNum = 148;BA.debugLine="p = xui2.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui2.CreatePanel(processBA,"p");
 //BA.debugLineNum = 149;BA.debugLine="Select cust_LV_vam.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_vam._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
 //BA.debugLineNum = 151;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((380-100)));
 break; }
case 1: {
 //BA.debugLineNum = 153;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
 //BA.debugLineNum = 155;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
 //BA.debugLineNum = 157;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
 //BA.debugLineNum = 159;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
 //BA.debugLineNum = 161;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
 //BA.debugLineNum = 163;BA.debugLine="cust_LV_vam.Add(p,\"\")";
mostCurrent._cust_lv_vam._add(mostCurrent._p,(Object)(""));
 };
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 23;BA.debugLine="Private pik_day1 As Label";
mostCurrent._pik_day1 = new anywheresoftware.b4a.objects.LabelWrapper();
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
 //BA.debugLineNum = 33;BA.debugLine="Private lbl_show2 As Label";
mostCurrent._lbl_show2 = new anywheresoftware.b4a.objects.LabelWrapper();
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
 //BA.debugLineNum = 43;BA.debugLine="Private pan_all_set_date As Panel";
mostCurrent._pan_all_set_date = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private pan_all_add As Panel";
mostCurrent._pan_all_add = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private cust_LV_vam As CustomListView";
mostCurrent._cust_lv_vam = new b4a.example3.customlistview();
 //BA.debugLineNum = 62;BA.debugLine="Private et_onvan As EditText";
mostCurrent._et_onvan = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Private et_mablagh_vam As EditText";
mostCurrent._et_mablagh_vam = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 64;BA.debugLine="Private et_nerkh_vam As EditText";
mostCurrent._et_nerkh_vam = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 65;BA.debugLine="Private et_tedad_gest As EditText";
mostCurrent._et_tedad_gest = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 66;BA.debugLine="Private lbl_kol_bazPardakht As Label";
mostCurrent._lbl_kol_bazpardakht = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 67;BA.debugLine="Private lbl_harGest As Label";
mostCurrent._lbl_hargest = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 68;BA.debugLine="Private lbl_date As Label";
mostCurrent._lbl_date = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 69;BA.debugLine="Private et_tozih As EditText";
mostCurrent._et_tozih = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_add_vam_click() throws Exception{
 //BA.debugLineNum = 522;BA.debugLine="Private Sub lbl_add_vam_Click";
 //BA.debugLineNum = 526;BA.debugLine="pan_all_add.Visible=True";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 528;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 171;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 172;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 173;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_click() throws Exception{
 //BA.debugLineNum = 534;BA.debugLine="Private Sub lbl_date_Click";
 //BA.debugLineNum = 536;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list2_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
 //BA.debugLineNum = 184;BA.debugLine="Private Sub lbl_remove_from_list2_Click";
 //BA.debugLineNum = 186;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 187;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 190;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 191;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 192;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 194;BA.debugLine="If (dbCode.delete_vam(b.Tag))Then";
if ((mostCurrent._dbcode._delete_vam /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
 //BA.debugLineNum = 195;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 198;BA.debugLine="fill_list_vam";
_fill_list_vam();
 };
 };
 //BA.debugLineNum = 207;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_click() throws Exception{
 //BA.debugLineNum = 538;BA.debugLine="Private Sub lbl_save_Click";
 //BA.debugLineNum = 540;BA.debugLine="dbCode.add_vam(et_onvan.Text,et_mablagh_vam.Tag,e";
mostCurrent._dbcode._add_vam /*boolean*/ (mostCurrent.activityBA,mostCurrent._et_onvan.getText(),BA.ObjectToString(mostCurrent._et_mablagh_vam.getTag()),mostCurrent._et_tedad_gest.getText(),mostCurrent._et_nerkh_vam.getText(),BA.NumberToString(1),mostCurrent._lbl_date.getText(),mostCurrent._et_tozih.getText(),(int) (0));
 //BA.debugLineNum = 543;BA.debugLine="fill_list_vam";
_fill_list_vam();
 //BA.debugLineNum = 545;BA.debugLine="pan_all_add.Visible=False";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 546;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
 //BA.debugLineNum = 314;BA.debugLine="Private Sub lbl_save_picker_Click";
 //BA.debugLineNum = 315;BA.debugLine="lbl_date.Text=pik_year1.Text&\"/\"&myfunc.convert_a";
mostCurrent._lbl_date.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 //BA.debugLineNum = 316;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 317;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_show2_click() throws Exception{
 //BA.debugLineNum = 210;BA.debugLine="Private Sub lbl_show2_Click";
 //BA.debugLineNum = 230;BA.debugLine="End Sub";
return "";
}
public static String  _mohasebe() throws Exception{
double _eb1 = 0;
double _sorat = 0;
double _makhraj = 0;
double _gest = 0;
double _sod = 0;
 //BA.debugLineNum = 548;BA.debugLine="Sub mohasebe";
 //BA.debugLineNum = 549;BA.debugLine="If(et_mablagh_vam.Text=\"\")Then";
if (((mostCurrent._et_mablagh_vam.getText()).equals(""))) { 
 //BA.debugLineNum = 550;BA.debugLine="ToastMessageShow(\"مبلغ وام را وارد کنید\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("مبلغ وام را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else if(((mostCurrent._et_nerkh_vam.getText()).equals(""))) { 
 //BA.debugLineNum = 553;BA.debugLine="ToastMessageShow(\"نرخ را وارد کنید\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("نرخ را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else if(((mostCurrent._et_tedad_gest.getText()).equals(""))) { 
 //BA.debugLineNum = 556;BA.debugLine="ToastMessageShow(\"تعداد قسط ها را وارد کنید\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تعداد قسط ها را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 560;BA.debugLine="Dim eb1 As Double=Power( (1+(et_nerkh_vam.Text/1";
_eb1 = anywheresoftware.b4a.keywords.Common.Power((1+((double)(Double.parseDouble(mostCurrent._et_nerkh_vam.getText()))/(double)1200)),(double)(Double.parseDouble(mostCurrent._et_tedad_gest.getText())));
 //BA.debugLineNum = 561;BA.debugLine="Dim sorat As Double=et_mablagh_vam.Tag*(et_nerkh";
_sorat = (double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag()))*((double)(Double.parseDouble(mostCurrent._et_nerkh_vam.getText()))/(double)1200)*_eb1;
 //BA.debugLineNum = 562;BA.debugLine="Dim makhraj As Double=eb1-1";
_makhraj = _eb1-1;
 //BA.debugLineNum = 564;BA.debugLine="Dim gest As Double=sorat/makhraj";
_gest = _sorat/(double)_makhraj;
 //BA.debugLineNum = 566;BA.debugLine="Dim sod As Double=(gest*et_tedad_gest.Text)-et_m";
_sod = (_gest*(double)(Double.parseDouble(mostCurrent._et_tedad_gest.getText())))-(double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag()));
 //BA.debugLineNum = 568;BA.debugLine="lbl_harGest.Text=myfunc.show_num_pool(Round(gest";
mostCurrent._lbl_hargest.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int) (anywheresoftware.b4a.keywords.Common.Round(_gest)))+" تومان "));
 //BA.debugLineNum = 569;BA.debugLine="lbl_kol_bazPardakht.Text=myfunc.show_num_pool(Ro";
mostCurrent._lbl_kol_bazpardakht.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int) (anywheresoftware.b4a.keywords.Common.Round((double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag()))+_sod)))+" تومان "));
 };
 //BA.debugLineNum = 574;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_add_click() throws Exception{
 //BA.debugLineNum = 530;BA.debugLine="Private Sub pan_all_add_Click";
 //BA.debugLineNum = 531;BA.debugLine="pan_all_add.Visible=False";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 532;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_edit1_click() throws Exception{
 //BA.debugLineNum = 263;BA.debugLine="Private Sub pan_all_edit1_Click";
 //BA.debugLineNum = 265;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_set_date_click() throws Exception{
 //BA.debugLineNum = 271;BA.debugLine="Private Sub pan_all_set_date_Click";
 //BA.debugLineNum = 273;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
 //BA.debugLineNum = 267;BA.debugLine="Private Sub Panel4_Click";
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 475;BA.debugLine="Private Sub pik_day_bala1_Click";
 //BA.debugLineNum = 476;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 477;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 480;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 481;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 482;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 484;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 485;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 488;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 489;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 491;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 492;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 496;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 498;BA.debugLine="Private Sub pik_day_paeen1_Click";
 //BA.debugLineNum = 499;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
 //BA.debugLineNum = 500;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 501;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 502;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 503;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 505;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 506;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 509;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 510;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 512;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 513;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 //BA.debugLineNum = 517;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 421;BA.debugLine="Private Sub pik_moon_bala1_Click";
 //BA.debugLineNum = 422;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 423;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
 //BA.debugLineNum = 425;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 426;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 428;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 429;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 431;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 //BA.debugLineNum = 433;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 435;BA.debugLine="Private Sub pik_moon_paeen1_Click";
 //BA.debugLineNum = 436;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
 //BA.debugLineNum = 437;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
 //BA.debugLineNum = 439;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 440;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 442;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 443;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 445;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
 //BA.debugLineNum = 447;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 381;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
 //BA.debugLineNum = 382;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 383;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 384;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 387;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 389;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
 //BA.debugLineNum = 390;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
 //BA.debugLineNum = 391;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 392;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 394;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
 //BA.debugLineNum = 395;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
 //BA.debugLineNum = 396;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 397;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 400;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
 //BA.debugLineNum = 401;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
 //BA.debugLineNum = 402;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 404;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 405;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
 //BA.debugLineNum = 408;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
 //BA.debugLineNum = 409;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
 //BA.debugLineNum = 411;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
 //BA.debugLineNum = 412;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
 };
 //BA.debugLineNum = 419;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 321;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
 //BA.debugLineNum = 322;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 323;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 324;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 327;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 329;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
 //BA.debugLineNum = 330;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
 //BA.debugLineNum = 331;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 332;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 334;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
 //BA.debugLineNum = 335;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
 //BA.debugLineNum = 336;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
 //BA.debugLineNum = 337;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 340;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
 //BA.debugLineNum = 341;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
 //BA.debugLineNum = 343;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
 //BA.debugLineNum = 344;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
 //BA.debugLineNum = 346;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
 //BA.debugLineNum = 349;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 351;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
 //BA.debugLineNum = 352;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
 //BA.debugLineNum = 353;BA.debugLine="Dim int1 As Int";
_int1 = 0;
 //BA.debugLineNum = 354;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 357;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
 //BA.debugLineNum = 359;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
 //BA.debugLineNum = 360;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
 //BA.debugLineNum = 361;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 362;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 364;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
 //BA.debugLineNum = 365;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
 //BA.debugLineNum = 366;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
 //BA.debugLineNum = 367;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
 //BA.debugLineNum = 370;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 371;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 373;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 374;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
 //BA.debugLineNum = 379;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 449;BA.debugLine="Private Sub pik_year_bala1_Click";
 //BA.debugLineNum = 450;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 451;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
 //BA.debugLineNum = 453;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 454;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 456;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 457;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 460;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
int _int1 = 0;
 //BA.debugLineNum = 462;BA.debugLine="Private Sub pik_year_paeen1_Click";
 //BA.debugLineNum = 463;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
 //BA.debugLineNum = 464;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
 //BA.debugLineNum = 466;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
 //BA.debugLineNum = 467;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
 //BA.debugLineNum = 469;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
 //BA.debugLineNum = 470;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 //BA.debugLineNum = 473;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
