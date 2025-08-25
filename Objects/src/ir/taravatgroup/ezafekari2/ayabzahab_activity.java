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

public class ayabzahab_activity extends Activity implements B4AActivity{
	public static ayabzahab_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.ayabzahab_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (ayabzahab_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.ayabzahab_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.ayabzahab_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (ayabzahab_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (ayabzahab_activity) Resume **");
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
		return ayabzahab_activity.class;
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
            BA.LogInfo("** Activity (ayabzahab_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (ayabzahab_activity) Pause event (activity is not paused). **");
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
            ayabzahab_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (ayabzahab_activity) Resume **");
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
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui2 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_list2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_day1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_moon1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _pik_year1 = null;
public static int _num_datapik = 0;
public anywheresoftware.b4a.objects.collections.List _moon_datapik = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_onvan = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_mablagh = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_edit_from_list = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_remove_from_list = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_tozih = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public b4a.example3.customlistview _cust_lv_ayabzahab = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_edit1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_set_date = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_title_edit1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_onvan_edit1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date_edit1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mablagh_edit1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_tozih_edit1 = null;
public static int _index_current_pan = 0;
public static int _current_itemid_edit = 0;
public anywheresoftware.b4a.objects.SpinnerWrapper _sp_moon = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _sp_year = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_icon = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _sp_type_state = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_sp_type = null;
public static int _addedit_id = 0;
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
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
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
String _moon_num = "";
RDebugUtils.currentLine=7405568;
 //BA.debugLineNum = 7405568;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=7405570;
 //BA.debugLineNum = 7405570;BA.debugLine="Activity.LoadLayout(\"ayabzahab_layout\")";
mostCurrent._activity.LoadLayout("ayabzahab_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=7405572;
 //BA.debugLineNum = 7405572;BA.debugLine="sp_year.Add(\"1404\")";
mostCurrent._sp_year.Add("1404");
RDebugUtils.currentLine=7405573;
 //BA.debugLineNum = 7405573;BA.debugLine="sp_year.Add(\"1403\")";
mostCurrent._sp_year.Add("1403");
RDebugUtils.currentLine=7405574;
 //BA.debugLineNum = 7405574;BA.debugLine="sp_year.Add(\"1402\")";
mostCurrent._sp_year.Add("1402");
RDebugUtils.currentLine=7405575;
 //BA.debugLineNum = 7405575;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
RDebugUtils.currentLine=7405576;
 //BA.debugLineNum = 7405576;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
RDebugUtils.currentLine=7405577;
 //BA.debugLineNum = 7405577;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
RDebugUtils.currentLine=7405578;
 //BA.debugLineNum = 7405578;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
RDebugUtils.currentLine=7405580;
 //BA.debugLineNum = 7405580;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=7405582;
 //BA.debugLineNum = 7405582;BA.debugLine="sp_year.SelectedIndex=0";
mostCurrent._sp_year.setSelectedIndex((int) (0));
RDebugUtils.currentLine=7405583;
 //BA.debugLineNum = 7405583;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))-1));
RDebugUtils.currentLine=7405585;
 //BA.debugLineNum = 7405585;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(sp_moo";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=7405588;
 //BA.debugLineNum = 7405588;BA.debugLine="fill_list_ayabzahab(sp_year.SelectedItem,moon_num";
_fill_list_ayabzahab(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=7405590;
 //BA.debugLineNum = 7405590;BA.debugLine="pan_hed_list2.Color=Main.color4";
mostCurrent._pan_hed_list2.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=7405591;
 //BA.debugLineNum = 7405591;BA.debugLine="lbl_title_edit1.Color=Main.color4";
mostCurrent._lbl_title_edit1.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=7405596;
 //BA.debugLineNum = 7405596;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
RDebugUtils.currentLine=7405597;
 //BA.debugLineNum = 7405597;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=7405600;
 //BA.debugLineNum = 7405600;BA.debugLine="sp_type_state.Add(\"اضافه شدن به دریافتی ها\")";
mostCurrent._sp_type_state.Add("اضافه شدن به دریافتی ها");
RDebugUtils.currentLine=7405601;
 //BA.debugLineNum = 7405601;BA.debugLine="sp_type_state.Add(\"کم شدن از دریافتی ها\")";
mostCurrent._sp_type_state.Add("کم شدن از دریافتی ها");
RDebugUtils.currentLine=7405604;
 //BA.debugLineNum = 7405604;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_ayabzahab(String _year,String _moon) throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_list_ayabzahab", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_list_ayabzahab", new Object[] {_year,_moon}));}
RDebugUtils.currentLine=7602176;
 //BA.debugLineNum = 7602176;BA.debugLine="Sub fill_list_ayabzahab(year As String , moon As S";
RDebugUtils.currentLine=7602179;
 //BA.debugLineNum = 7602179;BA.debugLine="cust_LV_ayabzahab.Clear";
mostCurrent._cust_lv_ayabzahab._clear();
RDebugUtils.currentLine=7602182;
 //BA.debugLineNum = 7602182;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=7602184;
 //BA.debugLineNum = 7602184;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ayabzahab WHERE date LIKE '%"+_year+"/"+_moon+"%' ORDER BY  date DESC;")));
RDebugUtils.currentLine=7602186;
 //BA.debugLineNum = 7602186;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=7602191;
 //BA.debugLineNum = 7602191;BA.debugLine="p = xui2.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui2.CreatePanel(processBA,"p");
RDebugUtils.currentLine=7602192;
 //BA.debugLineNum = 7602192;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=7602193;
 //BA.debugLineNum = 7602193;BA.debugLine="p.LoadLayout(\"item_list_list2\")";
mostCurrent._p.LoadLayout("item_list_list2",mostCurrent.activityBA);
RDebugUtils.currentLine=7602195;
 //BA.debugLineNum = 7602195;BA.debugLine="cust_LV_ayabzahab.Add(p,dbCode.res.GetString(\"id";
mostCurrent._cust_lv_ayabzahab._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=7602197;
 //BA.debugLineNum = 7602197;BA.debugLine="lbl_onvan.Text=dbCode.res.GetString(\"onvan\")";
mostCurrent._lbl_onvan.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan")));
RDebugUtils.currentLine=7602199;
 //BA.debugLineNum = 7602199;BA.debugLine="lbl_date.Text=dbCode.res.GetString(\"date\")";
mostCurrent._lbl_date.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date")));
RDebugUtils.currentLine=7602200;
 //BA.debugLineNum = 7602200;BA.debugLine="lbl_mablagh.Tag=dbCode.res.GetString(\"mablagh\")";
mostCurrent._lbl_mablagh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablagh")));
RDebugUtils.currentLine=7602201;
 //BA.debugLineNum = 7602201;BA.debugLine="lbl_mablagh.Text=myfunc.show_num_pool(lbl_mablag";
mostCurrent._lbl_mablagh.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_mablagh.getTag())))));
RDebugUtils.currentLine=7602205;
 //BA.debugLineNum = 7602205;BA.debugLine="If(dbCode.res.GetString(\"state\")) =1 Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state"))).equals(BA.NumberToString(1))) { 
RDebugUtils.currentLine=7602206;
 //BA.debugLineNum = 7602206;BA.debugLine="lbl_icon.Text=Chr(0xF271)  'plus";
mostCurrent._lbl_icon.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf271))));
RDebugUtils.currentLine=7602207;
 //BA.debugLineNum = 7602207;BA.debugLine="lbl_icon.Color=Colors.Green";
mostCurrent._lbl_icon.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 }else {
RDebugUtils.currentLine=7602209;
 //BA.debugLineNum = 7602209;BA.debugLine="lbl_icon.Text=Chr(0xF272)  'minus";
mostCurrent._lbl_icon.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf272))));
RDebugUtils.currentLine=7602210;
 //BA.debugLineNum = 7602210;BA.debugLine="lbl_icon.Color=Colors.Red";
mostCurrent._lbl_icon.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 };
RDebugUtils.currentLine=7602216;
 //BA.debugLineNum = 7602216;BA.debugLine="lbl_tozih.Text=dbCode.res.GetString(\"tozihat\")";
mostCurrent._lbl_tozih.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=7602220;
 //BA.debugLineNum = 7602220;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=7602221;
 //BA.debugLineNum = 7602221;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=7602228;
 //BA.debugLineNum = 7602228;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=7602229;
 //BA.debugLineNum = 7602229;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=7602231;
 //BA.debugLineNum = 7602231;BA.debugLine="If(cust_LV_ayabzahab.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_ayabzahab._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=7602232;
 //BA.debugLineNum = 7602232;BA.debugLine="p = xui2.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui2.CreatePanel(processBA,"p");
RDebugUtils.currentLine=7602233;
 //BA.debugLineNum = 7602233;BA.debugLine="Select cust_LV_ayabzahab.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_ayabzahab._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=7602235;
 //BA.debugLineNum = 7602235;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((380-100)));
 break; }
case 1: {
RDebugUtils.currentLine=7602237;
 //BA.debugLineNum = 7602237;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=7602239;
 //BA.debugLineNum = 7602239;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=7602241;
 //BA.debugLineNum = 7602241;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=7602243;
 //BA.debugLineNum = 7602243;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=7602245;
 //BA.debugLineNum = 7602245;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=7602247;
 //BA.debugLineNum = 7602247;BA.debugLine="cust_LV_ayabzahab.Add(p,\"\")";
mostCurrent._cust_lv_ayabzahab._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=7602251;
 //BA.debugLineNum = 7602251;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=7733249;
 //BA.debugLineNum = 7733249;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=7733250;
 //BA.debugLineNum = 7733250;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=7733251;
 //BA.debugLineNum = 7733251;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=7733253;
 //BA.debugLineNum = 7733253;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=7733255;
 //BA.debugLineNum = 7733255;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=7667712;
 //BA.debugLineNum = 7667712;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=7667713;
 //BA.debugLineNum = 7667713;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=7667714;
 //BA.debugLineNum = 7667714;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
RDebugUtils.currentLine=7536640;
 //BA.debugLineNum = 7536640;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=7536642;
 //BA.debugLineNum = 7536642;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=7471104;
 //BA.debugLineNum = 7471104;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=7471106;
 //BA.debugLineNum = 7471106;BA.debugLine="End Sub";
return "";
}
public static String  _et_mablagh_edit1_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mablagh_edit1_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mablagh_edit1_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Private Sub et_mablagh_edit1_TextChanged (Old As S";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="et_mablagh_edit1.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_mablagh_edit1.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="myfunc.change_formater(Old,New,et_mablagh_edit1)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_mablagh_edit1);
RDebugUtils.currentLine=8323075;
 //BA.debugLineNum = 8323075;BA.debugLine="End Sub";
return "";
}
public static String  _item_edit_box_mod(String _title,String _onvan,String _date,String _mablage,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "item_edit_box_mod", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "item_edit_box_mod", new Object[] {_title,_onvan,_date,_mablage,_tozih,_state}));}
RDebugUtils.currentLine=7929856;
 //BA.debugLineNum = 7929856;BA.debugLine="Sub item_edit_box_mod(title As String,onvan As Str";
RDebugUtils.currentLine=7929858;
 //BA.debugLineNum = 7929858;BA.debugLine="If(addEdit_id=1)Then";
if ((_addedit_id==1)) { 
RDebugUtils.currentLine=7929859;
 //BA.debugLineNum = 7929859;BA.debugLine="If(state=1)Then";
if ((_state==1)) { 
RDebugUtils.currentLine=7929860;
 //BA.debugLineNum = 7929860;BA.debugLine="sp_type_state.SelectedIndex=0";
mostCurrent._sp_type_state.setSelectedIndex((int) (0));
 }else {
RDebugUtils.currentLine=7929862;
 //BA.debugLineNum = 7929862;BA.debugLine="sp_type_state.SelectedIndex=1";
mostCurrent._sp_type_state.setSelectedIndex((int) (1));
 };
 }else {
RDebugUtils.currentLine=7929866;
 //BA.debugLineNum = 7929866;BA.debugLine="sp_type_state.SelectedIndex=0";
mostCurrent._sp_type_state.setSelectedIndex((int) (0));
 };
RDebugUtils.currentLine=7929869;
 //BA.debugLineNum = 7929869;BA.debugLine="lbl_title_edit1.Text=title";
mostCurrent._lbl_title_edit1.setText(BA.ObjectToCharSequence(_title));
RDebugUtils.currentLine=7929870;
 //BA.debugLineNum = 7929870;BA.debugLine="et_onvan_edit1.Text=onvan";
mostCurrent._et_onvan_edit1.setText(BA.ObjectToCharSequence(_onvan));
RDebugUtils.currentLine=7929871;
 //BA.debugLineNum = 7929871;BA.debugLine="lbl_date_edit1.Text=myfunc.fa2en(date)";
mostCurrent._lbl_date_edit1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date)));
RDebugUtils.currentLine=7929872;
 //BA.debugLineNum = 7929872;BA.debugLine="et_mablagh_edit1.Tag=mablage";
mostCurrent._et_mablagh_edit1.setTag((Object)(_mablage));
RDebugUtils.currentLine=7929873;
 //BA.debugLineNum = 7929873;BA.debugLine="et_mablagh_edit1.Text=myfunc.show_num_pool(mablag";
mostCurrent._et_mablagh_edit1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_mablage)))));
RDebugUtils.currentLine=7929875;
 //BA.debugLineNum = 7929875;BA.debugLine="et_tozih_edit1.Text=tozih";
mostCurrent._et_tozih_edit1.setText(BA.ObjectToCharSequence(_tozih));
RDebugUtils.currentLine=7929878;
 //BA.debugLineNum = 7929878;BA.debugLine="pan_all_edit1.Visible=True";
mostCurrent._pan_all_edit1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7929880;
 //BA.debugLineNum = 7929880;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_edit1.Text.S";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_edit1.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=7929881;
 //BA.debugLineNum = 7929881;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_edit1.Text.Su";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_edit1.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=7929882;
 //BA.debugLineNum = 7929882;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=7929883;
 //BA.debugLineNum = 7929883;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_edit1.Text.Su";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_edit1.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=7929888;
 //BA.debugLineNum = 7929888;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_add_ayabzahab_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_add_ayabzahab_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_add_ayabzahab_click", null));}
RDebugUtils.currentLine=9175040;
 //BA.debugLineNum = 9175040;BA.debugLine="Private Sub lbl_add_ayabzahab_Click";
RDebugUtils.currentLine=9175042;
 //BA.debugLineNum = 9175042;BA.debugLine="addEdit_id=0";
_addedit_id = (int) (0);
RDebugUtils.currentLine=9175045;
 //BA.debugLineNum = 9175045;BA.debugLine="item_edit_box_mod(\"ثبت ایاب ذهاب\",\"\",myfunc.fa2en";
_item_edit_box_mod("ثبت ایاب ذهاب","",mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),"0","",(int) (0));
RDebugUtils.currentLine=9175046;
 //BA.debugLineNum = 9175046;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_edit1_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date_edit1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date_edit1_click", null));}
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Private Sub lbl_date_edit1_Click";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=8257538;
 //BA.debugLineNum = 8257538;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_from_list_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Private Sub lbl_edit_from_list_Click";
RDebugUtils.currentLine=7864321;
 //BA.debugLineNum = 7864321;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7864322;
 //BA.debugLineNum = 7864322;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=7864324;
 //BA.debugLineNum = 7864324;BA.debugLine="addEdit_id=1";
_addedit_id = (int) (1);
RDebugUtils.currentLine=7864325;
 //BA.debugLineNum = 7864325;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=7864327;
 //BA.debugLineNum = 7864327;BA.debugLine="index_current_pan=3";
_index_current_pan = (int) (3);
RDebugUtils.currentLine=7864328;
 //BA.debugLineNum = 7864328;BA.debugLine="current_itemId_edit=b.Tag";
_current_itemid_edit = (int)(BA.ObjectToNumber(_b.getTag()));
RDebugUtils.currentLine=7864329;
 //BA.debugLineNum = 7864329;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_ayabzahab WHERE id="+BA.NumberToString(_current_itemid_edit))));
RDebugUtils.currentLine=7864330;
 //BA.debugLineNum = 7864330;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=7864332;
 //BA.debugLineNum = 7864332;BA.debugLine="item_edit_box_mod(\"ویرایش\",dbCode.res.GetString(\"";
_item_edit_box_mod("ویرایش",mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan"),mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date"),mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablagh"),mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat"),(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state"))));
RDebugUtils.currentLine=7864337;
 //BA.debugLineNum = 7864337;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_remove_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_remove_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Private Sub lbl_remove_from_list_Click";
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7798787;
 //BA.debugLineNum = 7798787;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=7798790;
 //BA.debugLineNum = 7798790;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=7798791;
 //BA.debugLineNum = 7798791;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=7798792;
 //BA.debugLineNum = 7798792;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=7798794;
 //BA.debugLineNum = 7798794;BA.debugLine="If (dbCode.delete_ayabZahab(b.Tag))Then";
if ((mostCurrent._dbcode._delete_ayabzahab /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=7798795;
 //BA.debugLineNum = 7798795;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7798798;
 //BA.debugLineNum = 7798798;BA.debugLine="fill_list_ayabzahab(sp_year.SelectedItem,myfunc";
_fill_list_ayabzahab(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
RDebugUtils.currentLine=7798807;
 //BA.debugLineNum = 7798807;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_edit1_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_edit1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_edit1_click", null));}
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Private Sub lbl_save_edit1_Click";
RDebugUtils.currentLine=8192002;
 //BA.debugLineNum = 8192002;BA.debugLine="If(et_onvan_edit1.Text=\"\")Then";
if (((mostCurrent._et_onvan_edit1.getText()).equals(""))) { 
RDebugUtils.currentLine=8192003;
 //BA.debugLineNum = 8192003;BA.debugLine="ToastMessageShow(\"عنوان خالی است!\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("عنوان خالی است!"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=8192004;
 //BA.debugLineNum = 8192004;BA.debugLine="Else If(et_mablagh_edit1.Tag=\"\")Then";
if (((mostCurrent._et_mablagh_edit1.getTag()).equals((Object)("")))) { 
RDebugUtils.currentLine=8192005;
 //BA.debugLineNum = 8192005;BA.debugLine="ToastMessageShow(\"مبلغ خالی است!\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("مبلغ خالی است!"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=8192008;
 //BA.debugLineNum = 8192008;BA.debugLine="If(addEdit_id=0)Then";
if ((_addedit_id==0)) { 
RDebugUtils.currentLine=8192010;
 //BA.debugLineNum = 8192010;BA.debugLine="If(sp_type_state.SelectedIndex=0)Then";
if ((mostCurrent._sp_type_state.getSelectedIndex()==0)) { 
RDebugUtils.currentLine=8192011;
 //BA.debugLineNum = 8192011;BA.debugLine="dbCode.add_aybZahab(et_onvan_edit1.Text,lbl_da";
mostCurrent._dbcode._add_aybzahab /*boolean*/ (mostCurrent.activityBA,mostCurrent._et_onvan_edit1.getText(),mostCurrent._lbl_date_edit1.getText(),BA.ObjectToString(mostCurrent._et_mablagh_edit1.getTag()),mostCurrent._et_tozih_edit1.getText(),(int) (1));
 }else {
RDebugUtils.currentLine=8192013;
 //BA.debugLineNum = 8192013;BA.debugLine="dbCode.add_aybZahab(et_onvan_edit1.Text,lbl_da";
mostCurrent._dbcode._add_aybzahab /*boolean*/ (mostCurrent.activityBA,mostCurrent._et_onvan_edit1.getText(),mostCurrent._lbl_date_edit1.getText(),BA.ObjectToString(mostCurrent._et_mablagh_edit1.getTag()),mostCurrent._et_tozih_edit1.getText(),(int) (2));
 };
RDebugUtils.currentLine=8192015;
 //BA.debugLineNum = 8192015;BA.debugLine="ToastMessageShow(\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=8192016;
 //BA.debugLineNum = 8192016;BA.debugLine="Else If(addEdit_id=1)Then";
if ((_addedit_id==1)) { 
RDebugUtils.currentLine=8192017;
 //BA.debugLineNum = 8192017;BA.debugLine="If(sp_type_state.SelectedIndex=0)Then";
if ((mostCurrent._sp_type_state.getSelectedIndex()==0)) { 
RDebugUtils.currentLine=8192018;
 //BA.debugLineNum = 8192018;BA.debugLine="dbCode.edit_ayabZahab(current_itemId_edit,et_o";
mostCurrent._dbcode._edit_ayabzahab /*boolean*/ (mostCurrent.activityBA,_current_itemid_edit,mostCurrent._et_onvan_edit1.getText(),mostCurrent._lbl_date_edit1.getText(),BA.ObjectToString(mostCurrent._et_mablagh_edit1.getTag()),mostCurrent._et_tozih_edit1.getText(),(int) (1));
 }else {
RDebugUtils.currentLine=8192020;
 //BA.debugLineNum = 8192020;BA.debugLine="dbCode.edit_ayabZahab(current_itemId_edit,et_o";
mostCurrent._dbcode._edit_ayabzahab /*boolean*/ (mostCurrent.activityBA,_current_itemid_edit,mostCurrent._et_onvan_edit1.getText(),mostCurrent._lbl_date_edit1.getText(),BA.ObjectToString(mostCurrent._et_mablagh_edit1.getTag()),mostCurrent._et_tozih_edit1.getText(),(int) (2));
 };
RDebugUtils.currentLine=8192023;
 //BA.debugLineNum = 8192023;BA.debugLine="ToastMessageShow(\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 }}
;
RDebugUtils.currentLine=8192029;
 //BA.debugLineNum = 8192029;BA.debugLine="fill_list_ayabzahab(sp_year.SelectedItem,myfunc.";
_fill_list_ayabzahab(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=8192030;
 //BA.debugLineNum = 8192030;BA.debugLine="pan_all_edit1.Visible=False";
mostCurrent._pan_all_edit1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }}
;
RDebugUtils.currentLine=8192032;
 //BA.debugLineNum = 8192032;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_picker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_picker_click", null));}
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Private Sub lbl_save_picker_Click";
RDebugUtils.currentLine=8388609;
 //BA.debugLineNum = 8388609;BA.debugLine="lbl_date_edit1.Text=pik_year1.Text&\"/\"&myfunc.con";
mostCurrent._lbl_date_edit1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=8388610;
 //BA.debugLineNum = 8388610;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=8388611;
 //BA.debugLineNum = 8388611;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_edit1_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_edit1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_edit1_click", null));}
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Private Sub pan_all_edit1_Click";
RDebugUtils.currentLine=7995393;
 //BA.debugLineNum = 7995393;BA.debugLine="pan_all_edit1.Visible=False";
mostCurrent._pan_all_edit1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_set_date_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_set_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_set_date_click", null));}
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Private Sub pan_all_set_date_Click";
RDebugUtils.currentLine=8126465;
 //BA.debugLineNum = 8126465;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=8126466;
 //BA.debugLineNum = 8126466;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel4_click", null));}
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Private Sub Panel4_Click";
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=8912896;
 //BA.debugLineNum = 8912896;BA.debugLine="Private Sub pik_day_bala1_Click";
RDebugUtils.currentLine=8912897;
 //BA.debugLineNum = 8912897;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=8912898;
 //BA.debugLineNum = 8912898;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=8912901;
 //BA.debugLineNum = 8912901;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=8912902;
 //BA.debugLineNum = 8912902;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=8912903;
 //BA.debugLineNum = 8912903;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=8912905;
 //BA.debugLineNum = 8912905;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=8912906;
 //BA.debugLineNum = 8912906;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=8912909;
 //BA.debugLineNum = 8912909;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=8912910;
 //BA.debugLineNum = 8912910;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=8912912;
 //BA.debugLineNum = 8912912;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=8912913;
 //BA.debugLineNum = 8912913;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=8912916;
 //BA.debugLineNum = 8912916;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=8912917;
 //BA.debugLineNum = 8912917;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=8978432;
 //BA.debugLineNum = 8978432;BA.debugLine="Private Sub pik_day_paeen1_Click";
RDebugUtils.currentLine=8978433;
 //BA.debugLineNum = 8978433;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=8978434;
 //BA.debugLineNum = 8978434;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=8978435;
 //BA.debugLineNum = 8978435;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=8978436;
 //BA.debugLineNum = 8978436;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=8978437;
 //BA.debugLineNum = 8978437;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=8978439;
 //BA.debugLineNum = 8978439;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=8978440;
 //BA.debugLineNum = 8978440;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=8978443;
 //BA.debugLineNum = 8978443;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=8978444;
 //BA.debugLineNum = 8978444;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=8978446;
 //BA.debugLineNum = 8978446;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=8978447;
 //BA.debugLineNum = 8978447;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=8978450;
 //BA.debugLineNum = 8978450;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=8978451;
 //BA.debugLineNum = 8978451;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=8650752;
 //BA.debugLineNum = 8650752;BA.debugLine="Private Sub pik_moon_bala1_Click";
RDebugUtils.currentLine=8650753;
 //BA.debugLineNum = 8650753;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=8650754;
 //BA.debugLineNum = 8650754;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
RDebugUtils.currentLine=8650756;
 //BA.debugLineNum = 8650756;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=8650757;
 //BA.debugLineNum = 8650757;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=8650759;
 //BA.debugLineNum = 8650759;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=8650760;
 //BA.debugLineNum = 8650760;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=8650762;
 //BA.debugLineNum = 8650762;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=8650764;
 //BA.debugLineNum = 8650764;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=8716288;
 //BA.debugLineNum = 8716288;BA.debugLine="Private Sub pik_moon_paeen1_Click";
RDebugUtils.currentLine=8716289;
 //BA.debugLineNum = 8716289;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=8716290;
 //BA.debugLineNum = 8716290;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
RDebugUtils.currentLine=8716292;
 //BA.debugLineNum = 8716292;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=8716293;
 //BA.debugLineNum = 8716293;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=8716295;
 //BA.debugLineNum = 8716295;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=8716296;
 //BA.debugLineNum = 8716296;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=8716298;
 //BA.debugLineNum = 8716298;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
RDebugUtils.currentLine=8716300;
 //BA.debugLineNum = 8716300;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_day1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_day1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=8585216;
 //BA.debugLineNum = 8585216;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
RDebugUtils.currentLine=8585217;
 //BA.debugLineNum = 8585217;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=8585218;
 //BA.debugLineNum = 8585218;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=8585219;
 //BA.debugLineNum = 8585219;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=8585222;
 //BA.debugLineNum = 8585222;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=8585224;
 //BA.debugLineNum = 8585224;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=8585225;
 //BA.debugLineNum = 8585225;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
RDebugUtils.currentLine=8585226;
 //BA.debugLineNum = 8585226;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=8585227;
 //BA.debugLineNum = 8585227;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=8585229;
 //BA.debugLineNum = 8585229;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=8585230;
 //BA.debugLineNum = 8585230;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
RDebugUtils.currentLine=8585231;
 //BA.debugLineNum = 8585231;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=8585232;
 //BA.debugLineNum = 8585232;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=8585235;
 //BA.debugLineNum = 8585235;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=8585236;
 //BA.debugLineNum = 8585236;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=8585237;
 //BA.debugLineNum = 8585237;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=8585239;
 //BA.debugLineNum = 8585239;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=8585240;
 //BA.debugLineNum = 8585240;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=8585243;
 //BA.debugLineNum = 8585243;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=8585244;
 //BA.debugLineNum = 8585244;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=8585246;
 //BA.debugLineNum = 8585246;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=8585247;
 //BA.debugLineNum = 8585247;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=8585250;
 //BA.debugLineNum = 8585250;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 };
RDebugUtils.currentLine=8585254;
 //BA.debugLineNum = 8585254;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_moon1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_moon1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
RDebugUtils.currentLine=8454145;
 //BA.debugLineNum = 8454145;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=8454146;
 //BA.debugLineNum = 8454146;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=8454147;
 //BA.debugLineNum = 8454147;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=8454150;
 //BA.debugLineNum = 8454150;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=8454152;
 //BA.debugLineNum = 8454152;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=8454153;
 //BA.debugLineNum = 8454153;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
RDebugUtils.currentLine=8454154;
 //BA.debugLineNum = 8454154;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=8454155;
 //BA.debugLineNum = 8454155;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=8454157;
 //BA.debugLineNum = 8454157;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=8454158;
 //BA.debugLineNum = 8454158;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
RDebugUtils.currentLine=8454159;
 //BA.debugLineNum = 8454159;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=8454160;
 //BA.debugLineNum = 8454160;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=8454163;
 //BA.debugLineNum = 8454163;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=8454164;
 //BA.debugLineNum = 8454164;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=8454166;
 //BA.debugLineNum = 8454166;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=8454167;
 //BA.debugLineNum = 8454167;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=8454169;
 //BA.debugLineNum = 8454169;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
RDebugUtils.currentLine=8454172;
 //BA.debugLineNum = 8454172;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_year1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_year1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=8519680;
 //BA.debugLineNum = 8519680;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
RDebugUtils.currentLine=8519681;
 //BA.debugLineNum = 8519681;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=8519682;
 //BA.debugLineNum = 8519682;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=8519683;
 //BA.debugLineNum = 8519683;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=8519686;
 //BA.debugLineNum = 8519686;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=8519688;
 //BA.debugLineNum = 8519688;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=8519689;
 //BA.debugLineNum = 8519689;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
RDebugUtils.currentLine=8519690;
 //BA.debugLineNum = 8519690;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=8519691;
 //BA.debugLineNum = 8519691;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=8519693;
 //BA.debugLineNum = 8519693;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=8519694;
 //BA.debugLineNum = 8519694;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
RDebugUtils.currentLine=8519695;
 //BA.debugLineNum = 8519695;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=8519696;
 //BA.debugLineNum = 8519696;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=8519699;
 //BA.debugLineNum = 8519699;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=8519700;
 //BA.debugLineNum = 8519700;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=8519702;
 //BA.debugLineNum = 8519702;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=8519703;
 //BA.debugLineNum = 8519703;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
RDebugUtils.currentLine=8519708;
 //BA.debugLineNum = 8519708;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=8781824;
 //BA.debugLineNum = 8781824;BA.debugLine="Private Sub pik_year_bala1_Click";
RDebugUtils.currentLine=8781825;
 //BA.debugLineNum = 8781825;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=8781826;
 //BA.debugLineNum = 8781826;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=8781828;
 //BA.debugLineNum = 8781828;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=8781829;
 //BA.debugLineNum = 8781829;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=8781831;
 //BA.debugLineNum = 8781831;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=8781832;
 //BA.debugLineNum = 8781832;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=8781835;
 //BA.debugLineNum = 8781835;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=8847360;
 //BA.debugLineNum = 8847360;BA.debugLine="Private Sub pik_year_paeen1_Click";
RDebugUtils.currentLine=8847361;
 //BA.debugLineNum = 8847361;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=8847362;
 //BA.debugLineNum = 8847362;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=8847364;
 //BA.debugLineNum = 8847364;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=8847365;
 //BA.debugLineNum = 8847365;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=8847367;
 //BA.debugLineNum = 8847367;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=8847368;
 //BA.debugLineNum = 8847368;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=8847371;
 //BA.debugLineNum = 8847371;BA.debugLine="End Sub";
return "";
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_moon_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_moon_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=9109504;
 //BA.debugLineNum = 9109504;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=9109506;
 //BA.debugLineNum = 9109506;BA.debugLine="fill_list_ayabzahab(sp_year.SelectedItem,myfunc.c";
_fill_list_ayabzahab(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=9109508;
 //BA.debugLineNum = 9109508;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="ayabzahab_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=9043968;
 //BA.debugLineNum = 9043968;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=9043970;
 //BA.debugLineNum = 9043970;BA.debugLine="fill_list_ayabzahab(sp_year.SelectedItem,myfunc.c";
_fill_list_ayabzahab(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=9043974;
 //BA.debugLineNum = 9043974;BA.debugLine="End Sub";
return "";
}
}