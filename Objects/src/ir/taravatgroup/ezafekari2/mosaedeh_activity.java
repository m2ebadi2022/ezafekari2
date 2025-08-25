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

public class mosaedeh_activity extends Activity implements B4AActivity{
	public static mosaedeh_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.mosaedeh_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (mosaedeh_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.mosaedeh_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.mosaedeh_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (mosaedeh_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (mosaedeh_activity) Resume **");
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
		return mosaedeh_activity.class;
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
            BA.LogInfo("** Activity (mosaedeh_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (mosaedeh_activity) Pause event (activity is not paused). **");
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
            mosaedeh_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (mosaedeh_activity) Resume **");
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
public b4a.example3.customlistview _cust_lv_mosaedeh = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_edit1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_set_date = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_title_edit1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_onvan_edit1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_date_edit1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_mablagh_edit1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_tozih_edit1 = null;
public static int _index_current_pan = 0;
public static int _current_itemid_edit = 0;
public b4a.example3.customlistview _cust_lv_food = null;
public b4a.example3.customlistview _cust_lv_padash = null;
public b4a.example3.customlistview _cust_lv_sayer = null;
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
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
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
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
String _moon_num = "";
RDebugUtils.currentLine=27262976;
 //BA.debugLineNum = 27262976;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=27262978;
 //BA.debugLineNum = 27262978;BA.debugLine="Activity.LoadLayout(\"mosaedeh_layout\")";
mostCurrent._activity.LoadLayout("mosaedeh_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=27262980;
 //BA.debugLineNum = 27262980;BA.debugLine="sp_year.Add(\"1404\")";
mostCurrent._sp_year.Add("1404");
RDebugUtils.currentLine=27262981;
 //BA.debugLineNum = 27262981;BA.debugLine="sp_year.Add(\"1403\")";
mostCurrent._sp_year.Add("1403");
RDebugUtils.currentLine=27262982;
 //BA.debugLineNum = 27262982;BA.debugLine="sp_year.Add(\"1402\")";
mostCurrent._sp_year.Add("1402");
RDebugUtils.currentLine=27262983;
 //BA.debugLineNum = 27262983;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
RDebugUtils.currentLine=27262984;
 //BA.debugLineNum = 27262984;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
RDebugUtils.currentLine=27262985;
 //BA.debugLineNum = 27262985;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
RDebugUtils.currentLine=27262986;
 //BA.debugLineNum = 27262986;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
RDebugUtils.currentLine=27262988;
 //BA.debugLineNum = 27262988;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=27262990;
 //BA.debugLineNum = 27262990;BA.debugLine="sp_year.SelectedIndex=0";
mostCurrent._sp_year.setSelectedIndex((int) (0));
RDebugUtils.currentLine=27262991;
 //BA.debugLineNum = 27262991;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))-1));
RDebugUtils.currentLine=27262993;
 //BA.debugLineNum = 27262993;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(sp_moo";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=27262996;
 //BA.debugLineNum = 27262996;BA.debugLine="fill_list_mosaedeh(sp_year.SelectedItem,moon_num)";
_fill_list_mosaedeh(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=27262998;
 //BA.debugLineNum = 27262998;BA.debugLine="pan_hed_list2.Color=Main.color4";
mostCurrent._pan_hed_list2.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=27262999;
 //BA.debugLineNum = 27262999;BA.debugLine="lbl_title_edit1.Color=Main.color4";
mostCurrent._lbl_title_edit1.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=27263004;
 //BA.debugLineNum = 27263004;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
RDebugUtils.currentLine=27263005;
 //BA.debugLineNum = 27263005;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=27263008;
 //BA.debugLineNum = 27263008;BA.debugLine="sp_type_state.Add(\"اضافه شدن به دریافتی ها\")";
mostCurrent._sp_type_state.Add("اضافه شدن به دریافتی ها");
RDebugUtils.currentLine=27263009;
 //BA.debugLineNum = 27263009;BA.debugLine="sp_type_state.Add(\"کم شدن از دریافتی ها\")";
mostCurrent._sp_type_state.Add("کم شدن از دریافتی ها");
RDebugUtils.currentLine=27263012;
 //BA.debugLineNum = 27263012;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_mosaedeh(String _year,String _moon) throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_list_mosaedeh", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_list_mosaedeh", new Object[] {_year,_moon}));}
RDebugUtils.currentLine=27459584;
 //BA.debugLineNum = 27459584;BA.debugLine="Sub fill_list_mosaedeh(year As String , moon As St";
RDebugUtils.currentLine=27459587;
 //BA.debugLineNum = 27459587;BA.debugLine="cust_LV_mosaedeh.Clear";
mostCurrent._cust_lv_mosaedeh._clear();
RDebugUtils.currentLine=27459590;
 //BA.debugLineNum = 27459590;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=27459591;
 //BA.debugLineNum = 27459591;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mosaedeh WHERE date LIKE '%"+_year+"/"+_moon+"%' ORDER BY  date DESC;")));
RDebugUtils.currentLine=27459594;
 //BA.debugLineNum = 27459594;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=27459599;
 //BA.debugLineNum = 27459599;BA.debugLine="p = xui2.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui2.CreatePanel(processBA,"p");
RDebugUtils.currentLine=27459600;
 //BA.debugLineNum = 27459600;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=27459601;
 //BA.debugLineNum = 27459601;BA.debugLine="p.LoadLayout(\"item_list_list2\")";
mostCurrent._p.LoadLayout("item_list_list2",mostCurrent.activityBA);
RDebugUtils.currentLine=27459603;
 //BA.debugLineNum = 27459603;BA.debugLine="cust_LV_mosaedeh.Add(p,dbCode.res.GetString(\"id\"";
mostCurrent._cust_lv_mosaedeh._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=27459605;
 //BA.debugLineNum = 27459605;BA.debugLine="lbl_onvan.Text=dbCode.res.GetString(\"onvan\")";
mostCurrent._lbl_onvan.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan")));
RDebugUtils.currentLine=27459607;
 //BA.debugLineNum = 27459607;BA.debugLine="lbl_date.Text=dbCode.res.GetString(\"date\")";
mostCurrent._lbl_date.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date")));
RDebugUtils.currentLine=27459608;
 //BA.debugLineNum = 27459608;BA.debugLine="lbl_mablagh.Tag=dbCode.res.GetString(\"mablagh\")";
mostCurrent._lbl_mablagh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablagh")));
RDebugUtils.currentLine=27459609;
 //BA.debugLineNum = 27459609;BA.debugLine="lbl_mablagh.Text=myfunc.show_num_pool(lbl_mablag";
mostCurrent._lbl_mablagh.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_mablagh.getTag())))));
RDebugUtils.currentLine=27459611;
 //BA.debugLineNum = 27459611;BA.debugLine="lbl_tozih.Text=dbCode.res.GetString(\"tozihat\")";
mostCurrent._lbl_tozih.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=27459613;
 //BA.debugLineNum = 27459613;BA.debugLine="lbl_icon.Text=Chr(0xF274)  'def";
mostCurrent._lbl_icon.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf274))));
RDebugUtils.currentLine=27459614;
 //BA.debugLineNum = 27459614;BA.debugLine="lbl_icon.Color=0xFF00A3FF";
mostCurrent._lbl_icon.setColor(((int)0xff00a3ff));
RDebugUtils.currentLine=27459616;
 //BA.debugLineNum = 27459616;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=27459617;
 //BA.debugLineNum = 27459617;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=27459624;
 //BA.debugLineNum = 27459624;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=27459625;
 //BA.debugLineNum = 27459625;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=27459627;
 //BA.debugLineNum = 27459627;BA.debugLine="If(cust_LV_mosaedeh.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_mosaedeh._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=27459628;
 //BA.debugLineNum = 27459628;BA.debugLine="p = xui2.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui2.CreatePanel(processBA,"p");
RDebugUtils.currentLine=27459629;
 //BA.debugLineNum = 27459629;BA.debugLine="Select cust_LV_mosaedeh.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_mosaedeh._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=27459631;
 //BA.debugLineNum = 27459631;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((380-100)));
 break; }
case 1: {
RDebugUtils.currentLine=27459633;
 //BA.debugLineNum = 27459633;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=27459635;
 //BA.debugLineNum = 27459635;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=27459637;
 //BA.debugLineNum = 27459637;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=27459639;
 //BA.debugLineNum = 27459639;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=27459641;
 //BA.debugLineNum = 27459641;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=27459643;
 //BA.debugLineNum = 27459643;BA.debugLine="cust_LV_mosaedeh.Add(p,\"\")";
mostCurrent._cust_lv_mosaedeh._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=27459647;
 //BA.debugLineNum = 27459647;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=27590656;
 //BA.debugLineNum = 27590656;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=27590657;
 //BA.debugLineNum = 27590657;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=27590658;
 //BA.debugLineNum = 27590658;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=27590659;
 //BA.debugLineNum = 27590659;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=27590661;
 //BA.debugLineNum = 27590661;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=27590663;
 //BA.debugLineNum = 27590663;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=27525120;
 //BA.debugLineNum = 27525120;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=27525121;
 //BA.debugLineNum = 27525121;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=27525122;
 //BA.debugLineNum = 27525122;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
RDebugUtils.currentLine=27394048;
 //BA.debugLineNum = 27394048;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=27394050;
 //BA.debugLineNum = 27394050;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=27328512;
 //BA.debugLineNum = 27328512;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=27328514;
 //BA.debugLineNum = 27328514;BA.debugLine="End Sub";
return "";
}
public static String  _et_mablagh_edit1_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mablagh_edit1_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mablagh_edit1_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=28180480;
 //BA.debugLineNum = 28180480;BA.debugLine="Private Sub et_mablagh_edit1_TextChanged (Old As S";
RDebugUtils.currentLine=28180481;
 //BA.debugLineNum = 28180481;BA.debugLine="et_mablagh_edit1.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_mablagh_edit1.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=28180482;
 //BA.debugLineNum = 28180482;BA.debugLine="myfunc.change_formater(Old,New,et_mablagh_edit1)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_mablagh_edit1);
RDebugUtils.currentLine=28180483;
 //BA.debugLineNum = 28180483;BA.debugLine="End Sub";
return "";
}
public static String  _item_edit_box_mod(String _title,String _onvan,String _date,String _mablage,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "item_edit_box_mod", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "item_edit_box_mod", new Object[] {_title,_onvan,_date,_mablage,_tozih,_state}));}
RDebugUtils.currentLine=27787264;
 //BA.debugLineNum = 27787264;BA.debugLine="Sub item_edit_box_mod(title As String,onvan As Str";
RDebugUtils.currentLine=27787267;
 //BA.debugLineNum = 27787267;BA.debugLine="lbl_title_edit1.Text=title";
mostCurrent._lbl_title_edit1.setText(BA.ObjectToCharSequence(_title));
RDebugUtils.currentLine=27787268;
 //BA.debugLineNum = 27787268;BA.debugLine="et_onvan_edit1.Text=onvan";
mostCurrent._et_onvan_edit1.setText(BA.ObjectToCharSequence(_onvan));
RDebugUtils.currentLine=27787269;
 //BA.debugLineNum = 27787269;BA.debugLine="lbl_date_edit1.Text=myfunc.fa2en(date)";
mostCurrent._lbl_date_edit1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date)));
RDebugUtils.currentLine=27787270;
 //BA.debugLineNum = 27787270;BA.debugLine="et_mablagh_edit1.Tag=mablage";
mostCurrent._et_mablagh_edit1.setTag((Object)(_mablage));
RDebugUtils.currentLine=27787271;
 //BA.debugLineNum = 27787271;BA.debugLine="et_mablagh_edit1.Text=myfunc.show_num_pool(mablag";
mostCurrent._et_mablagh_edit1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_mablage)))));
RDebugUtils.currentLine=27787273;
 //BA.debugLineNum = 27787273;BA.debugLine="et_tozih_edit1.Text=tozih";
mostCurrent._et_tozih_edit1.setText(BA.ObjectToCharSequence(_tozih));
RDebugUtils.currentLine=27787275;
 //BA.debugLineNum = 27787275;BA.debugLine="If(state = 1) Then";
if ((_state==1)) { 
RDebugUtils.currentLine=27787276;
 //BA.debugLineNum = 27787276;BA.debugLine="sp_type_state.SelectedIndex=0";
mostCurrent._sp_type_state.setSelectedIndex((int) (0));
 }else {
RDebugUtils.currentLine=27787278;
 //BA.debugLineNum = 27787278;BA.debugLine="sp_type_state.SelectedIndex=1";
mostCurrent._sp_type_state.setSelectedIndex((int) (1));
 };
RDebugUtils.currentLine=27787281;
 //BA.debugLineNum = 27787281;BA.debugLine="pan_all_edit1.Visible=True";
mostCurrent._pan_all_edit1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=27787283;
 //BA.debugLineNum = 27787283;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_edit1.Text.S";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_edit1.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=27787284;
 //BA.debugLineNum = 27787284;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_edit1.Text.Su";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_edit1.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=27787285;
 //BA.debugLineNum = 27787285;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=27787286;
 //BA.debugLineNum = 27787286;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_edit1.Text.Su";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_edit1.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=27787291;
 //BA.debugLineNum = 27787291;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_add_mosaedeh_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_add_mosaedeh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_add_mosaedeh_click", null));}
RDebugUtils.currentLine=29032448;
 //BA.debugLineNum = 29032448;BA.debugLine="Private Sub lbl_add_mosaedeh_Click";
RDebugUtils.currentLine=29032450;
 //BA.debugLineNum = 29032450;BA.debugLine="addEdit_id=0";
_addedit_id = (int) (0);
RDebugUtils.currentLine=29032451;
 //BA.debugLineNum = 29032451;BA.debugLine="item_edit_box_mod(\"افزودن مساعده\",\"\",myfunc.fa2en";
_item_edit_box_mod("افزودن مساعده","",mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),"0","",(int) (0));
RDebugUtils.currentLine=29032452;
 //BA.debugLineNum = 29032452;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_edit1_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date_edit1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date_edit1_click", null));}
RDebugUtils.currentLine=28114944;
 //BA.debugLineNum = 28114944;BA.debugLine="Private Sub lbl_date_edit1_Click";
RDebugUtils.currentLine=28114945;
 //BA.debugLineNum = 28114945;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=28114946;
 //BA.debugLineNum = 28114946;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_from_list_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
RDebugUtils.currentLine=27721728;
 //BA.debugLineNum = 27721728;BA.debugLine="Private Sub lbl_edit_from_list_Click";
RDebugUtils.currentLine=27721729;
 //BA.debugLineNum = 27721729;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=27721730;
 //BA.debugLineNum = 27721730;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=27721732;
 //BA.debugLineNum = 27721732;BA.debugLine="addEdit_id=1";
_addedit_id = (int) (1);
RDebugUtils.currentLine=27721733;
 //BA.debugLineNum = 27721733;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=27721735;
 //BA.debugLineNum = 27721735;BA.debugLine="sp_type_state.Visible=False";
mostCurrent._sp_type_state.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=27721736;
 //BA.debugLineNum = 27721736;BA.debugLine="lbl_sp_type.Visible=False";
mostCurrent._lbl_sp_type.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=27721738;
 //BA.debugLineNum = 27721738;BA.debugLine="index_current_pan=3";
_index_current_pan = (int) (3);
RDebugUtils.currentLine=27721739;
 //BA.debugLineNum = 27721739;BA.debugLine="current_itemId_edit=b.Tag";
_current_itemid_edit = (int)(BA.ObjectToNumber(_b.getTag()));
RDebugUtils.currentLine=27721740;
 //BA.debugLineNum = 27721740;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_mosaedeh WHERE id="+BA.NumberToString(_current_itemid_edit))));
RDebugUtils.currentLine=27721741;
 //BA.debugLineNum = 27721741;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=27721743;
 //BA.debugLineNum = 27721743;BA.debugLine="item_edit_box_mod(\"ویرایش مساعده\",dbCode.res.Get";
_item_edit_box_mod("ویرایش مساعده",mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan"),mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date"),mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablagh"),mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat"),(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state"))));
RDebugUtils.currentLine=27721748;
 //BA.debugLineNum = 27721748;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_remove_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_remove_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
RDebugUtils.currentLine=27656192;
 //BA.debugLineNum = 27656192;BA.debugLine="Private Sub lbl_remove_from_list_Click";
RDebugUtils.currentLine=27656194;
 //BA.debugLineNum = 27656194;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=27656195;
 //BA.debugLineNum = 27656195;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=27656198;
 //BA.debugLineNum = 27656198;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=27656199;
 //BA.debugLineNum = 27656199;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=27656200;
 //BA.debugLineNum = 27656200;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=27656202;
 //BA.debugLineNum = 27656202;BA.debugLine="If (dbCode.delete_mosaedeh(b.Tag))Then";
if ((mostCurrent._dbcode._delete_mosaedeh /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=27656203;
 //BA.debugLineNum = 27656203;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=27656206;
 //BA.debugLineNum = 27656206;BA.debugLine="fill_list_mosaedeh(sp_year.SelectedItem,myfunc";
_fill_list_mosaedeh(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
RDebugUtils.currentLine=27656215;
 //BA.debugLineNum = 27656215;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_edit1_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_edit1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_edit1_click", null));}
RDebugUtils.currentLine=28049408;
 //BA.debugLineNum = 28049408;BA.debugLine="Private Sub lbl_save_edit1_Click";
RDebugUtils.currentLine=28049410;
 //BA.debugLineNum = 28049410;BA.debugLine="If(et_onvan_edit1.Text=\"\")Then";
if (((mostCurrent._et_onvan_edit1.getText()).equals(""))) { 
RDebugUtils.currentLine=28049411;
 //BA.debugLineNum = 28049411;BA.debugLine="ToastMessageShow(\"عنوان خالی است!\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("عنوان خالی است!"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=28049412;
 //BA.debugLineNum = 28049412;BA.debugLine="Else If(et_mablagh_edit1.Tag=\"\")Then";
if (((mostCurrent._et_mablagh_edit1.getTag()).equals((Object)("")))) { 
RDebugUtils.currentLine=28049413;
 //BA.debugLineNum = 28049413;BA.debugLine="ToastMessageShow(\"مبلغ خالی است!\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("مبلغ خالی است!"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=28049416;
 //BA.debugLineNum = 28049416;BA.debugLine="If(addEdit_id=0)Then";
if ((_addedit_id==0)) { 
RDebugUtils.currentLine=28049417;
 //BA.debugLineNum = 28049417;BA.debugLine="dbCode.add_mosaedeh(et_onvan_edit1.Text ,lbl_da";
mostCurrent._dbcode._add_mosaedeh /*boolean*/ (mostCurrent.activityBA,mostCurrent._et_onvan_edit1.getText(),mostCurrent._lbl_date_edit1.getText(),BA.ObjectToString(mostCurrent._et_mablagh_edit1.getTag()),mostCurrent._et_tozih_edit1.getText(),(int) (0));
 }else 
{RDebugUtils.currentLine=28049419;
 //BA.debugLineNum = 28049419;BA.debugLine="Else If(addEdit_id=1)Then";
if ((_addedit_id==1)) { 
RDebugUtils.currentLine=28049420;
 //BA.debugLineNum = 28049420;BA.debugLine="dbCode.edit_mosaedeh(current_itemId_edit,et_on";
mostCurrent._dbcode._edit_mosaedeh /*boolean*/ (mostCurrent.activityBA,_current_itemid_edit,mostCurrent._et_onvan_edit1.getText(),mostCurrent._lbl_date_edit1.getText(),BA.ObjectToString(mostCurrent._et_mablagh_edit1.getTag()),mostCurrent._et_tozih_edit1.getText(),(int) (0));
RDebugUtils.currentLine=28049421;
 //BA.debugLineNum = 28049421;BA.debugLine="ToastMessageShow(\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 }}
;
RDebugUtils.currentLine=28049427;
 //BA.debugLineNum = 28049427;BA.debugLine="fill_list_mosaedeh(sp_year.SelectedItem,myfunc.c";
_fill_list_mosaedeh(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=28049428;
 //BA.debugLineNum = 28049428;BA.debugLine="pan_all_edit1.Visible=False";
mostCurrent._pan_all_edit1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }}
;
RDebugUtils.currentLine=28049430;
 //BA.debugLineNum = 28049430;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_picker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_picker_click", null));}
RDebugUtils.currentLine=28246016;
 //BA.debugLineNum = 28246016;BA.debugLine="Private Sub lbl_save_picker_Click";
RDebugUtils.currentLine=28246017;
 //BA.debugLineNum = 28246017;BA.debugLine="lbl_date_edit1.Text=pik_year1.Text&\"/\"&myfunc.con";
mostCurrent._lbl_date_edit1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=28246018;
 //BA.debugLineNum = 28246018;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=28246019;
 //BA.debugLineNum = 28246019;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_edit1_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_edit1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_edit1_click", null));}
RDebugUtils.currentLine=27852800;
 //BA.debugLineNum = 27852800;BA.debugLine="Private Sub pan_all_edit1_Click";
RDebugUtils.currentLine=27852801;
 //BA.debugLineNum = 27852801;BA.debugLine="pan_all_edit1.Visible=False";
mostCurrent._pan_all_edit1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=27852802;
 //BA.debugLineNum = 27852802;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_set_date_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_set_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_set_date_click", null));}
RDebugUtils.currentLine=27983872;
 //BA.debugLineNum = 27983872;BA.debugLine="Private Sub pan_all_set_date_Click";
RDebugUtils.currentLine=27983873;
 //BA.debugLineNum = 27983873;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=27983874;
 //BA.debugLineNum = 27983874;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel4_click", null));}
RDebugUtils.currentLine=27918336;
 //BA.debugLineNum = 27918336;BA.debugLine="Private Sub Panel4_Click";
RDebugUtils.currentLine=27918338;
 //BA.debugLineNum = 27918338;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=28770304;
 //BA.debugLineNum = 28770304;BA.debugLine="Private Sub pik_day_bala1_Click";
RDebugUtils.currentLine=28770305;
 //BA.debugLineNum = 28770305;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=28770306;
 //BA.debugLineNum = 28770306;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=28770309;
 //BA.debugLineNum = 28770309;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=28770310;
 //BA.debugLineNum = 28770310;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=28770311;
 //BA.debugLineNum = 28770311;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=28770313;
 //BA.debugLineNum = 28770313;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=28770314;
 //BA.debugLineNum = 28770314;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=28770317;
 //BA.debugLineNum = 28770317;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=28770318;
 //BA.debugLineNum = 28770318;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=28770320;
 //BA.debugLineNum = 28770320;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=28770321;
 //BA.debugLineNum = 28770321;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
RDebugUtils.currentLine=28770323;
 //BA.debugLineNum = 28770323;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 };
RDebugUtils.currentLine=28770326;
 //BA.debugLineNum = 28770326;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=28835840;
 //BA.debugLineNum = 28835840;BA.debugLine="Private Sub pik_day_paeen1_Click";
RDebugUtils.currentLine=28835841;
 //BA.debugLineNum = 28835841;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=28835842;
 //BA.debugLineNum = 28835842;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=28835843;
 //BA.debugLineNum = 28835843;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=28835844;
 //BA.debugLineNum = 28835844;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=28835845;
 //BA.debugLineNum = 28835845;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=28835847;
 //BA.debugLineNum = 28835847;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=28835848;
 //BA.debugLineNum = 28835848;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=28835851;
 //BA.debugLineNum = 28835851;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=28835852;
 //BA.debugLineNum = 28835852;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=28835854;
 //BA.debugLineNum = 28835854;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=28835855;
 //BA.debugLineNum = 28835855;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
RDebugUtils.currentLine=28835857;
 //BA.debugLineNum = 28835857;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 };
RDebugUtils.currentLine=28835860;
 //BA.debugLineNum = 28835860;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=28508160;
 //BA.debugLineNum = 28508160;BA.debugLine="Private Sub pik_moon_bala1_Click";
RDebugUtils.currentLine=28508161;
 //BA.debugLineNum = 28508161;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=28508162;
 //BA.debugLineNum = 28508162;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
RDebugUtils.currentLine=28508164;
 //BA.debugLineNum = 28508164;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=28508165;
 //BA.debugLineNum = 28508165;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=28508167;
 //BA.debugLineNum = 28508167;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=28508168;
 //BA.debugLineNum = 28508168;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=28508170;
 //BA.debugLineNum = 28508170;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=28508172;
 //BA.debugLineNum = 28508172;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=28573696;
 //BA.debugLineNum = 28573696;BA.debugLine="Private Sub pik_moon_paeen1_Click";
RDebugUtils.currentLine=28573697;
 //BA.debugLineNum = 28573697;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=28573698;
 //BA.debugLineNum = 28573698;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
RDebugUtils.currentLine=28573700;
 //BA.debugLineNum = 28573700;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=28573701;
 //BA.debugLineNum = 28573701;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=28573703;
 //BA.debugLineNum = 28573703;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=28573704;
 //BA.debugLineNum = 28573704;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=28573706;
 //BA.debugLineNum = 28573706;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
RDebugUtils.currentLine=28573708;
 //BA.debugLineNum = 28573708;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_day1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_day1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=28442624;
 //BA.debugLineNum = 28442624;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
RDebugUtils.currentLine=28442625;
 //BA.debugLineNum = 28442625;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=28442626;
 //BA.debugLineNum = 28442626;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=28442627;
 //BA.debugLineNum = 28442627;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=28442630;
 //BA.debugLineNum = 28442630;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=28442632;
 //BA.debugLineNum = 28442632;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=28442633;
 //BA.debugLineNum = 28442633;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
RDebugUtils.currentLine=28442634;
 //BA.debugLineNum = 28442634;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=28442635;
 //BA.debugLineNum = 28442635;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=28442637;
 //BA.debugLineNum = 28442637;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=28442638;
 //BA.debugLineNum = 28442638;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
RDebugUtils.currentLine=28442639;
 //BA.debugLineNum = 28442639;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=28442640;
 //BA.debugLineNum = 28442640;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=28442643;
 //BA.debugLineNum = 28442643;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=28442644;
 //BA.debugLineNum = 28442644;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=28442645;
 //BA.debugLineNum = 28442645;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=28442647;
 //BA.debugLineNum = 28442647;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=28442648;
 //BA.debugLineNum = 28442648;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=28442651;
 //BA.debugLineNum = 28442651;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=28442652;
 //BA.debugLineNum = 28442652;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=28442654;
 //BA.debugLineNum = 28442654;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=28442655;
 //BA.debugLineNum = 28442655;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=28442658;
 //BA.debugLineNum = 28442658;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 };
RDebugUtils.currentLine=28442662;
 //BA.debugLineNum = 28442662;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_moon1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_moon1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=28311552;
 //BA.debugLineNum = 28311552;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
RDebugUtils.currentLine=28311553;
 //BA.debugLineNum = 28311553;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=28311554;
 //BA.debugLineNum = 28311554;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=28311555;
 //BA.debugLineNum = 28311555;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=28311558;
 //BA.debugLineNum = 28311558;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=28311560;
 //BA.debugLineNum = 28311560;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=28311561;
 //BA.debugLineNum = 28311561;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
RDebugUtils.currentLine=28311562;
 //BA.debugLineNum = 28311562;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=28311563;
 //BA.debugLineNum = 28311563;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=28311565;
 //BA.debugLineNum = 28311565;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=28311566;
 //BA.debugLineNum = 28311566;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
RDebugUtils.currentLine=28311567;
 //BA.debugLineNum = 28311567;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=28311568;
 //BA.debugLineNum = 28311568;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=28311571;
 //BA.debugLineNum = 28311571;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=28311572;
 //BA.debugLineNum = 28311572;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=28311574;
 //BA.debugLineNum = 28311574;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=28311575;
 //BA.debugLineNum = 28311575;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=28311577;
 //BA.debugLineNum = 28311577;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
RDebugUtils.currentLine=28311580;
 //BA.debugLineNum = 28311580;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_year1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_year1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=28377088;
 //BA.debugLineNum = 28377088;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
RDebugUtils.currentLine=28377089;
 //BA.debugLineNum = 28377089;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=28377090;
 //BA.debugLineNum = 28377090;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=28377091;
 //BA.debugLineNum = 28377091;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=28377094;
 //BA.debugLineNum = 28377094;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=28377096;
 //BA.debugLineNum = 28377096;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=28377097;
 //BA.debugLineNum = 28377097;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
RDebugUtils.currentLine=28377098;
 //BA.debugLineNum = 28377098;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=28377099;
 //BA.debugLineNum = 28377099;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=28377101;
 //BA.debugLineNum = 28377101;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=28377102;
 //BA.debugLineNum = 28377102;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
RDebugUtils.currentLine=28377103;
 //BA.debugLineNum = 28377103;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=28377104;
 //BA.debugLineNum = 28377104;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=28377107;
 //BA.debugLineNum = 28377107;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=28377108;
 //BA.debugLineNum = 28377108;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=28377110;
 //BA.debugLineNum = 28377110;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=28377111;
 //BA.debugLineNum = 28377111;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
RDebugUtils.currentLine=28377116;
 //BA.debugLineNum = 28377116;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=28639232;
 //BA.debugLineNum = 28639232;BA.debugLine="Private Sub pik_year_bala1_Click";
RDebugUtils.currentLine=28639233;
 //BA.debugLineNum = 28639233;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=28639234;
 //BA.debugLineNum = 28639234;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=28639236;
 //BA.debugLineNum = 28639236;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=28639237;
 //BA.debugLineNum = 28639237;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=28639239;
 //BA.debugLineNum = 28639239;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=28639240;
 //BA.debugLineNum = 28639240;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=28639243;
 //BA.debugLineNum = 28639243;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=28704768;
 //BA.debugLineNum = 28704768;BA.debugLine="Private Sub pik_year_paeen1_Click";
RDebugUtils.currentLine=28704769;
 //BA.debugLineNum = 28704769;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=28704770;
 //BA.debugLineNum = 28704770;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=28704772;
 //BA.debugLineNum = 28704772;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=28704773;
 //BA.debugLineNum = 28704773;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=28704775;
 //BA.debugLineNum = 28704775;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=28704776;
 //BA.debugLineNum = 28704776;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=28704779;
 //BA.debugLineNum = 28704779;BA.debugLine="End Sub";
return "";
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_moon_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_moon_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=28966912;
 //BA.debugLineNum = 28966912;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=28966914;
 //BA.debugLineNum = 28966914;BA.debugLine="fill_list_mosaedeh(sp_year.SelectedItem,myfunc.c";
_fill_list_mosaedeh(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=28966916;
 //BA.debugLineNum = 28966916;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="mosaedeh_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=28901376;
 //BA.debugLineNum = 28901376;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=28901378;
 //BA.debugLineNum = 28901378;BA.debugLine="fill_list_mosaedeh(sp_year.SelectedItem,myfunc.c";
_fill_list_mosaedeh(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=28901382;
 //BA.debugLineNum = 28901382;BA.debugLine="End Sub";
return "";
}
}