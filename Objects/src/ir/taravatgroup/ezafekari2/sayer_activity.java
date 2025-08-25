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

public class sayer_activity extends Activity implements B4AActivity{
	public static sayer_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.sayer_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (sayer_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.sayer_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.sayer_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (sayer_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (sayer_activity) Resume **");
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
		return sayer_activity.class;
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
            BA.LogInfo("** Activity (sayer_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (sayer_activity) Pause event (activity is not paused). **");
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
            sayer_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (sayer_activity) Resume **");
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
public b4a.example3.customlistview _cust_lv_sayer = null;
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
public ir.taravatgroup.ezafekari2.mosaedeh_activity _mosaedeh_activity = null;
public ir.taravatgroup.ezafekari2.padash_activity _padash_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
public ir.taravatgroup.ezafekari2.savabeg_activity _savabeg_activity = null;
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
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
String _moon_num = "";
RDebugUtils.currentLine=34537472;
 //BA.debugLineNum = 34537472;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=34537474;
 //BA.debugLineNum = 34537474;BA.debugLine="Activity.LoadLayout(\"sayer_layout\")";
mostCurrent._activity.LoadLayout("sayer_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=34537476;
 //BA.debugLineNum = 34537476;BA.debugLine="sp_year.Add(\"1404\")";
mostCurrent._sp_year.Add("1404");
RDebugUtils.currentLine=34537477;
 //BA.debugLineNum = 34537477;BA.debugLine="sp_year.Add(\"1403\")";
mostCurrent._sp_year.Add("1403");
RDebugUtils.currentLine=34537478;
 //BA.debugLineNum = 34537478;BA.debugLine="sp_year.Add(\"1402\")";
mostCurrent._sp_year.Add("1402");
RDebugUtils.currentLine=34537479;
 //BA.debugLineNum = 34537479;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
RDebugUtils.currentLine=34537480;
 //BA.debugLineNum = 34537480;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
RDebugUtils.currentLine=34537481;
 //BA.debugLineNum = 34537481;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
RDebugUtils.currentLine=34537482;
 //BA.debugLineNum = 34537482;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
RDebugUtils.currentLine=34537484;
 //BA.debugLineNum = 34537484;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=34537486;
 //BA.debugLineNum = 34537486;BA.debugLine="sp_year.SelectedIndex=0";
mostCurrent._sp_year.setSelectedIndex((int) (0));
RDebugUtils.currentLine=34537487;
 //BA.debugLineNum = 34537487;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))-1));
RDebugUtils.currentLine=34537489;
 //BA.debugLineNum = 34537489;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(sp_moo";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=34537492;
 //BA.debugLineNum = 34537492;BA.debugLine="fill_list_sayer(sp_year.SelectedItem,moon_num)";
_fill_list_sayer(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=34537494;
 //BA.debugLineNum = 34537494;BA.debugLine="pan_hed_list2.Color=Main.color4";
mostCurrent._pan_hed_list2.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=34537495;
 //BA.debugLineNum = 34537495;BA.debugLine="lbl_title_edit1.Color=Main.color4";
mostCurrent._lbl_title_edit1.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=34537500;
 //BA.debugLineNum = 34537500;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
RDebugUtils.currentLine=34537501;
 //BA.debugLineNum = 34537501;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=34537504;
 //BA.debugLineNum = 34537504;BA.debugLine="sp_type_state.Add(\"اضافه شدن به دریافتی ها\")";
mostCurrent._sp_type_state.Add("اضافه شدن به دریافتی ها");
RDebugUtils.currentLine=34537505;
 //BA.debugLineNum = 34537505;BA.debugLine="sp_type_state.Add(\"کم شدن از دریافتی ها\")";
mostCurrent._sp_type_state.Add("کم شدن از دریافتی ها");
RDebugUtils.currentLine=34537508;
 //BA.debugLineNum = 34537508;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_sayer(String _year,String _moon) throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_list_sayer", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_list_sayer", new Object[] {_year,_moon}));}
RDebugUtils.currentLine=34734080;
 //BA.debugLineNum = 34734080;BA.debugLine="Sub fill_list_sayer(year As String , moon As Strin";
RDebugUtils.currentLine=34734083;
 //BA.debugLineNum = 34734083;BA.debugLine="cust_LV_sayer.Clear";
mostCurrent._cust_lv_sayer._clear();
RDebugUtils.currentLine=34734086;
 //BA.debugLineNum = 34734086;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=34734088;
 //BA.debugLineNum = 34734088;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_sayer WHERE date LIKE '%"+_year+"/"+_moon+"%' ORDER BY  date DESC;")));
RDebugUtils.currentLine=34734090;
 //BA.debugLineNum = 34734090;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=34734095;
 //BA.debugLineNum = 34734095;BA.debugLine="p = xui2.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui2.CreatePanel(processBA,"p");
RDebugUtils.currentLine=34734096;
 //BA.debugLineNum = 34734096;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=34734097;
 //BA.debugLineNum = 34734097;BA.debugLine="p.LoadLayout(\"item_list_list2\")";
mostCurrent._p.LoadLayout("item_list_list2",mostCurrent.activityBA);
RDebugUtils.currentLine=34734099;
 //BA.debugLineNum = 34734099;BA.debugLine="cust_LV_sayer.Add(p,dbCode.res.GetString(\"id\"))";
mostCurrent._cust_lv_sayer._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=34734101;
 //BA.debugLineNum = 34734101;BA.debugLine="lbl_onvan.Text=dbCode.res.GetString(\"onvan\")";
mostCurrent._lbl_onvan.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan")));
RDebugUtils.currentLine=34734103;
 //BA.debugLineNum = 34734103;BA.debugLine="lbl_date.Text=dbCode.res.GetString(\"date\")";
mostCurrent._lbl_date.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date")));
RDebugUtils.currentLine=34734104;
 //BA.debugLineNum = 34734104;BA.debugLine="lbl_mablagh.Tag=dbCode.res.GetString(\"mablagh\")";
mostCurrent._lbl_mablagh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablagh")));
RDebugUtils.currentLine=34734105;
 //BA.debugLineNum = 34734105;BA.debugLine="lbl_mablagh.Text=myfunc.show_num_pool(lbl_mablag";
mostCurrent._lbl_mablagh.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_mablagh.getTag())))));
RDebugUtils.currentLine=34734109;
 //BA.debugLineNum = 34734109;BA.debugLine="If(dbCode.res.GetString(\"state\")) =1 Then";
if (((mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state"))).equals(BA.NumberToString(1))) { 
RDebugUtils.currentLine=34734110;
 //BA.debugLineNum = 34734110;BA.debugLine="lbl_icon.Text=Chr(0xF271)  'plus";
mostCurrent._lbl_icon.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf271))));
RDebugUtils.currentLine=34734111;
 //BA.debugLineNum = 34734111;BA.debugLine="lbl_icon.Color=Colors.Green";
mostCurrent._lbl_icon.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 }else {
RDebugUtils.currentLine=34734113;
 //BA.debugLineNum = 34734113;BA.debugLine="lbl_icon.Text=Chr(0xF272)  'minus";
mostCurrent._lbl_icon.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf272))));
RDebugUtils.currentLine=34734114;
 //BA.debugLineNum = 34734114;BA.debugLine="lbl_icon.Color=Colors.Red";
mostCurrent._lbl_icon.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 };
RDebugUtils.currentLine=34734120;
 //BA.debugLineNum = 34734120;BA.debugLine="lbl_tozih.Text=dbCode.res.GetString(\"tozihat\")";
mostCurrent._lbl_tozih.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=34734124;
 //BA.debugLineNum = 34734124;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=34734125;
 //BA.debugLineNum = 34734125;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=34734132;
 //BA.debugLineNum = 34734132;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=34734133;
 //BA.debugLineNum = 34734133;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=34734135;
 //BA.debugLineNum = 34734135;BA.debugLine="If(cust_LV_sayer.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_sayer._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=34734136;
 //BA.debugLineNum = 34734136;BA.debugLine="p = xui2.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui2.CreatePanel(processBA,"p");
RDebugUtils.currentLine=34734137;
 //BA.debugLineNum = 34734137;BA.debugLine="Select cust_LV_sayer.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_sayer._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=34734139;
 //BA.debugLineNum = 34734139;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((380-100)));
 break; }
case 1: {
RDebugUtils.currentLine=34734141;
 //BA.debugLineNum = 34734141;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=34734143;
 //BA.debugLineNum = 34734143;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=34734145;
 //BA.debugLineNum = 34734145;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=34734147;
 //BA.debugLineNum = 34734147;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=34734149;
 //BA.debugLineNum = 34734149;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=34734151;
 //BA.debugLineNum = 34734151;BA.debugLine="cust_LV_sayer.Add(p,\"\")";
mostCurrent._cust_lv_sayer._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=34734155;
 //BA.debugLineNum = 34734155;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=34930688;
 //BA.debugLineNum = 34930688;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=34930689;
 //BA.debugLineNum = 34930689;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=34930690;
 //BA.debugLineNum = 34930690;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=34930691;
 //BA.debugLineNum = 34930691;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=34930693;
 //BA.debugLineNum = 34930693;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=34930695;
 //BA.debugLineNum = 34930695;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=34865152;
 //BA.debugLineNum = 34865152;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=34865153;
 //BA.debugLineNum = 34865153;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=34865154;
 //BA.debugLineNum = 34865154;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="sayer_activity";
RDebugUtils.currentLine=34668544;
 //BA.debugLineNum = 34668544;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=34668546;
 //BA.debugLineNum = 34668546;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=34603008;
 //BA.debugLineNum = 34603008;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=34603010;
 //BA.debugLineNum = 34603010;BA.debugLine="End Sub";
return "";
}
public static String  _et_mablagh_edit1_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mablagh_edit1_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mablagh_edit1_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=35520512;
 //BA.debugLineNum = 35520512;BA.debugLine="Private Sub et_mablagh_edit1_TextChanged (Old As S";
RDebugUtils.currentLine=35520513;
 //BA.debugLineNum = 35520513;BA.debugLine="et_mablagh_edit1.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_mablagh_edit1.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=35520514;
 //BA.debugLineNum = 35520514;BA.debugLine="myfunc.change_formater(Old,New,et_mablagh_edit1)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_mablagh_edit1);
RDebugUtils.currentLine=35520515;
 //BA.debugLineNum = 35520515;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_sayer2(String _year,String _moon) throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_list_sayer2", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_list_sayer2", new Object[] {_year,_moon}));}
RDebugUtils.currentLine=34799616;
 //BA.debugLineNum = 34799616;BA.debugLine="Sub fill_list_sayer2(year As String , moon As Stri";
RDebugUtils.currentLine=34799619;
 //BA.debugLineNum = 34799619;BA.debugLine="cust_LV_sayer.Clear";
mostCurrent._cust_lv_sayer._clear();
RDebugUtils.currentLine=34799622;
 //BA.debugLineNum = 34799622;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=34799623;
 //BA.debugLineNum = 34799623;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_sayer WHERE date LIKE '%"+_year+"/"+_moon+"%' ORDER BY  date DESC;")));
RDebugUtils.currentLine=34799626;
 //BA.debugLineNum = 34799626;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=34799631;
 //BA.debugLineNum = 34799631;BA.debugLine="p = xui2.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui2.CreatePanel(processBA,"p");
RDebugUtils.currentLine=34799632;
 //BA.debugLineNum = 34799632;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=34799633;
 //BA.debugLineNum = 34799633;BA.debugLine="p.LoadLayout(\"item_list_list2\")";
mostCurrent._p.LoadLayout("item_list_list2",mostCurrent.activityBA);
RDebugUtils.currentLine=34799635;
 //BA.debugLineNum = 34799635;BA.debugLine="cust_LV_sayer.Add(p,dbCode.res.GetString(\"id\"))";
mostCurrent._cust_lv_sayer._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=34799637;
 //BA.debugLineNum = 34799637;BA.debugLine="lbl_onvan.Text=dbCode.res.GetString(\"onvan\")";
mostCurrent._lbl_onvan.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan")));
RDebugUtils.currentLine=34799639;
 //BA.debugLineNum = 34799639;BA.debugLine="lbl_date.Text=dbCode.res.GetString(\"date\")";
mostCurrent._lbl_date.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date")));
RDebugUtils.currentLine=34799640;
 //BA.debugLineNum = 34799640;BA.debugLine="lbl_mablagh.Tag=dbCode.res.GetString(\"mablagh\")";
mostCurrent._lbl_mablagh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablagh")));
RDebugUtils.currentLine=34799641;
 //BA.debugLineNum = 34799641;BA.debugLine="lbl_mablagh.Text=myfunc.show_num_pool(lbl_mablag";
mostCurrent._lbl_mablagh.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_mablagh.getTag())))));
RDebugUtils.currentLine=34799643;
 //BA.debugLineNum = 34799643;BA.debugLine="lbl_tozih.Text=dbCode.res.GetString(\"tozihat\")";
mostCurrent._lbl_tozih.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=34799645;
 //BA.debugLineNum = 34799645;BA.debugLine="lbl_icon.Text=Chr(0xF274)  'def";
mostCurrent._lbl_icon.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf274))));
RDebugUtils.currentLine=34799646;
 //BA.debugLineNum = 34799646;BA.debugLine="lbl_icon.Color=0xFF00A3FF";
mostCurrent._lbl_icon.setColor(((int)0xff00a3ff));
RDebugUtils.currentLine=34799648;
 //BA.debugLineNum = 34799648;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=34799649;
 //BA.debugLineNum = 34799649;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=34799656;
 //BA.debugLineNum = 34799656;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=34799657;
 //BA.debugLineNum = 34799657;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=34799659;
 //BA.debugLineNum = 34799659;BA.debugLine="If(cust_LV_sayer.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_sayer._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=34799660;
 //BA.debugLineNum = 34799660;BA.debugLine="p = xui2.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui2.CreatePanel(processBA,"p");
RDebugUtils.currentLine=34799661;
 //BA.debugLineNum = 34799661;BA.debugLine="Select cust_LV_sayer.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_sayer._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=34799663;
 //BA.debugLineNum = 34799663;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((380-100)));
 break; }
case 1: {
RDebugUtils.currentLine=34799665;
 //BA.debugLineNum = 34799665;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=34799667;
 //BA.debugLineNum = 34799667;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=34799669;
 //BA.debugLineNum = 34799669;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=34799671;
 //BA.debugLineNum = 34799671;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=34799673;
 //BA.debugLineNum = 34799673;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=34799675;
 //BA.debugLineNum = 34799675;BA.debugLine="cust_LV_sayer.Add(p,\"\")";
mostCurrent._cust_lv_sayer._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=34799679;
 //BA.debugLineNum = 34799679;BA.debugLine="End Sub";
return "";
}
public static String  _item_edit_box_mod(String _title,String _onvan,String _date,String _mablage,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "item_edit_box_mod", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "item_edit_box_mod", new Object[] {_title,_onvan,_date,_mablage,_tozih,_state}));}
RDebugUtils.currentLine=35127296;
 //BA.debugLineNum = 35127296;BA.debugLine="Sub item_edit_box_mod(title As String,onvan As Str";
RDebugUtils.currentLine=35127298;
 //BA.debugLineNum = 35127298;BA.debugLine="If(addEdit_id=1)Then";
if ((_addedit_id==1)) { 
RDebugUtils.currentLine=35127299;
 //BA.debugLineNum = 35127299;BA.debugLine="If(state=1)Then";
if ((_state==1)) { 
RDebugUtils.currentLine=35127300;
 //BA.debugLineNum = 35127300;BA.debugLine="sp_type_state.SelectedIndex=0";
mostCurrent._sp_type_state.setSelectedIndex((int) (0));
 }else {
RDebugUtils.currentLine=35127302;
 //BA.debugLineNum = 35127302;BA.debugLine="sp_type_state.SelectedIndex=1";
mostCurrent._sp_type_state.setSelectedIndex((int) (1));
 };
 }else {
RDebugUtils.currentLine=35127306;
 //BA.debugLineNum = 35127306;BA.debugLine="sp_type_state.SelectedIndex=0";
mostCurrent._sp_type_state.setSelectedIndex((int) (0));
 };
RDebugUtils.currentLine=35127309;
 //BA.debugLineNum = 35127309;BA.debugLine="lbl_title_edit1.Text=title";
mostCurrent._lbl_title_edit1.setText(BA.ObjectToCharSequence(_title));
RDebugUtils.currentLine=35127310;
 //BA.debugLineNum = 35127310;BA.debugLine="et_onvan_edit1.Text=onvan";
mostCurrent._et_onvan_edit1.setText(BA.ObjectToCharSequence(_onvan));
RDebugUtils.currentLine=35127311;
 //BA.debugLineNum = 35127311;BA.debugLine="lbl_date_edit1.Text=myfunc.fa2en(date)";
mostCurrent._lbl_date_edit1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date)));
RDebugUtils.currentLine=35127312;
 //BA.debugLineNum = 35127312;BA.debugLine="et_mablagh_edit1.Tag=mablage";
mostCurrent._et_mablagh_edit1.setTag((Object)(_mablage));
RDebugUtils.currentLine=35127313;
 //BA.debugLineNum = 35127313;BA.debugLine="et_mablagh_edit1.Text=myfunc.show_num_pool(mablag";
mostCurrent._et_mablagh_edit1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_mablage)))));
RDebugUtils.currentLine=35127315;
 //BA.debugLineNum = 35127315;BA.debugLine="et_tozih_edit1.Text=tozih";
mostCurrent._et_tozih_edit1.setText(BA.ObjectToCharSequence(_tozih));
RDebugUtils.currentLine=35127318;
 //BA.debugLineNum = 35127318;BA.debugLine="pan_all_edit1.Visible=True";
mostCurrent._pan_all_edit1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=35127320;
 //BA.debugLineNum = 35127320;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_edit1.Text.S";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_edit1.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=35127321;
 //BA.debugLineNum = 35127321;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_edit1.Text.Su";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_edit1.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=35127322;
 //BA.debugLineNum = 35127322;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=35127323;
 //BA.debugLineNum = 35127323;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_edit1.Text.Su";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_edit1.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=35127328;
 //BA.debugLineNum = 35127328;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_add_sayer_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_add_sayer_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_add_sayer_click", null));}
RDebugUtils.currentLine=36372480;
 //BA.debugLineNum = 36372480;BA.debugLine="Private Sub lbl_add_sayer_Click";
RDebugUtils.currentLine=36372482;
 //BA.debugLineNum = 36372482;BA.debugLine="addEdit_id=0";
_addedit_id = (int) (0);
RDebugUtils.currentLine=36372485;
 //BA.debugLineNum = 36372485;BA.debugLine="item_edit_box_mod(\"ثبت سایر\",\"\",myfunc.fa2en(Main";
_item_edit_box_mod("ثبت سایر","",mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),"0","",(int) (0));
RDebugUtils.currentLine=36372486;
 //BA.debugLineNum = 36372486;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_edit1_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date_edit1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date_edit1_click", null));}
RDebugUtils.currentLine=35454976;
 //BA.debugLineNum = 35454976;BA.debugLine="Private Sub lbl_date_edit1_Click";
RDebugUtils.currentLine=35454977;
 //BA.debugLineNum = 35454977;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=35454978;
 //BA.debugLineNum = 35454978;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_from_list_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
RDebugUtils.currentLine=35061760;
 //BA.debugLineNum = 35061760;BA.debugLine="Private Sub lbl_edit_from_list_Click";
RDebugUtils.currentLine=35061761;
 //BA.debugLineNum = 35061761;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=35061762;
 //BA.debugLineNum = 35061762;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=35061764;
 //BA.debugLineNum = 35061764;BA.debugLine="addEdit_id=1";
_addedit_id = (int) (1);
RDebugUtils.currentLine=35061765;
 //BA.debugLineNum = 35061765;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=35061767;
 //BA.debugLineNum = 35061767;BA.debugLine="index_current_pan=3";
_index_current_pan = (int) (3);
RDebugUtils.currentLine=35061768;
 //BA.debugLineNum = 35061768;BA.debugLine="current_itemId_edit=b.Tag";
_current_itemid_edit = (int)(BA.ObjectToNumber(_b.getTag()));
RDebugUtils.currentLine=35061769;
 //BA.debugLineNum = 35061769;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_sayer WHERE id="+BA.NumberToString(_current_itemid_edit))));
RDebugUtils.currentLine=35061770;
 //BA.debugLineNum = 35061770;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=35061772;
 //BA.debugLineNum = 35061772;BA.debugLine="item_edit_box_mod(\"ویرایش\",dbCode.res.GetString(\"";
_item_edit_box_mod("ویرایش",mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan"),mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date"),mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablagh"),mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat"),(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state"))));
RDebugUtils.currentLine=35061777;
 //BA.debugLineNum = 35061777;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_remove_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_remove_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
RDebugUtils.currentLine=34996224;
 //BA.debugLineNum = 34996224;BA.debugLine="Private Sub lbl_remove_from_list_Click";
RDebugUtils.currentLine=34996226;
 //BA.debugLineNum = 34996226;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=34996227;
 //BA.debugLineNum = 34996227;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=34996230;
 //BA.debugLineNum = 34996230;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=34996231;
 //BA.debugLineNum = 34996231;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=34996232;
 //BA.debugLineNum = 34996232;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=34996234;
 //BA.debugLineNum = 34996234;BA.debugLine="If (dbCode.delete_sayer(b.Tag))Then";
if ((mostCurrent._dbcode._delete_sayer /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=34996235;
 //BA.debugLineNum = 34996235;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34996238;
 //BA.debugLineNum = 34996238;BA.debugLine="fill_list_sayer(sp_year.SelectedItem,myfunc.con";
_fill_list_sayer(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
RDebugUtils.currentLine=34996247;
 //BA.debugLineNum = 34996247;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_edit1_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_edit1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_edit1_click", null));}
RDebugUtils.currentLine=35389440;
 //BA.debugLineNum = 35389440;BA.debugLine="Private Sub lbl_save_edit1_Click";
RDebugUtils.currentLine=35389442;
 //BA.debugLineNum = 35389442;BA.debugLine="If(et_onvan_edit1.Text=\"\")Then";
if (((mostCurrent._et_onvan_edit1.getText()).equals(""))) { 
RDebugUtils.currentLine=35389443;
 //BA.debugLineNum = 35389443;BA.debugLine="ToastMessageShow(\"عنوان خالی است!\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("عنوان خالی است!"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=35389444;
 //BA.debugLineNum = 35389444;BA.debugLine="Else If(et_mablagh_edit1.Tag=\"\")Then";
if (((mostCurrent._et_mablagh_edit1.getTag()).equals((Object)("")))) { 
RDebugUtils.currentLine=35389445;
 //BA.debugLineNum = 35389445;BA.debugLine="ToastMessageShow(\"مبلغ خالی است!\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("مبلغ خالی است!"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=35389448;
 //BA.debugLineNum = 35389448;BA.debugLine="If(addEdit_id=0)Then";
if ((_addedit_id==0)) { 
RDebugUtils.currentLine=35389450;
 //BA.debugLineNum = 35389450;BA.debugLine="If(sp_type_state.SelectedIndex=0)Then";
if ((mostCurrent._sp_type_state.getSelectedIndex()==0)) { 
RDebugUtils.currentLine=35389451;
 //BA.debugLineNum = 35389451;BA.debugLine="dbCode.add_sayer(et_onvan_edit1.Text,lbl_date_";
mostCurrent._dbcode._add_sayer /*boolean*/ (mostCurrent.activityBA,mostCurrent._et_onvan_edit1.getText(),mostCurrent._lbl_date_edit1.getText(),BA.ObjectToString(mostCurrent._et_mablagh_edit1.getTag()),mostCurrent._et_tozih_edit1.getText(),(int) (1));
 }else {
RDebugUtils.currentLine=35389453;
 //BA.debugLineNum = 35389453;BA.debugLine="dbCode.add_sayer(et_onvan_edit1.Text,lbl_date_";
mostCurrent._dbcode._add_sayer /*boolean*/ (mostCurrent.activityBA,mostCurrent._et_onvan_edit1.getText(),mostCurrent._lbl_date_edit1.getText(),BA.ObjectToString(mostCurrent._et_mablagh_edit1.getTag()),mostCurrent._et_tozih_edit1.getText(),(int) (2));
 };
RDebugUtils.currentLine=35389455;
 //BA.debugLineNum = 35389455;BA.debugLine="ToastMessageShow(\"اضافه شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اضافه شد"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=35389456;
 //BA.debugLineNum = 35389456;BA.debugLine="Else If(addEdit_id=1)Then";
if ((_addedit_id==1)) { 
RDebugUtils.currentLine=35389457;
 //BA.debugLineNum = 35389457;BA.debugLine="If(sp_type_state.SelectedIndex=0)Then";
if ((mostCurrent._sp_type_state.getSelectedIndex()==0)) { 
RDebugUtils.currentLine=35389458;
 //BA.debugLineNum = 35389458;BA.debugLine="dbCode.edit_sayer(current_itemId_edit,et_onvan";
mostCurrent._dbcode._edit_sayer /*boolean*/ (mostCurrent.activityBA,_current_itemid_edit,mostCurrent._et_onvan_edit1.getText(),mostCurrent._lbl_date_edit1.getText(),BA.ObjectToString(mostCurrent._et_mablagh_edit1.getTag()),mostCurrent._et_tozih_edit1.getText(),(int) (1));
 }else {
RDebugUtils.currentLine=35389460;
 //BA.debugLineNum = 35389460;BA.debugLine="dbCode.edit_sayer(current_itemId_edit,et_onvan";
mostCurrent._dbcode._edit_sayer /*boolean*/ (mostCurrent.activityBA,_current_itemid_edit,mostCurrent._et_onvan_edit1.getText(),mostCurrent._lbl_date_edit1.getText(),BA.ObjectToString(mostCurrent._et_mablagh_edit1.getTag()),mostCurrent._et_tozih_edit1.getText(),(int) (2));
 };
RDebugUtils.currentLine=35389463;
 //BA.debugLineNum = 35389463;BA.debugLine="ToastMessageShow(\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 }}
;
RDebugUtils.currentLine=35389469;
 //BA.debugLineNum = 35389469;BA.debugLine="fill_list_sayer(sp_year.SelectedItem,myfunc.conv";
_fill_list_sayer(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=35389470;
 //BA.debugLineNum = 35389470;BA.debugLine="pan_all_edit1.Visible=False";
mostCurrent._pan_all_edit1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }}
;
RDebugUtils.currentLine=35389472;
 //BA.debugLineNum = 35389472;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_picker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_picker_click", null));}
RDebugUtils.currentLine=35586048;
 //BA.debugLineNum = 35586048;BA.debugLine="Private Sub lbl_save_picker_Click";
RDebugUtils.currentLine=35586049;
 //BA.debugLineNum = 35586049;BA.debugLine="lbl_date_edit1.Text=pik_year1.Text&\"/\"&myfunc.con";
mostCurrent._lbl_date_edit1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=35586050;
 //BA.debugLineNum = 35586050;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35586051;
 //BA.debugLineNum = 35586051;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_edit1_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_edit1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_edit1_click", null));}
RDebugUtils.currentLine=35192832;
 //BA.debugLineNum = 35192832;BA.debugLine="Private Sub pan_all_edit1_Click";
RDebugUtils.currentLine=35192833;
 //BA.debugLineNum = 35192833;BA.debugLine="pan_all_edit1.Visible=False";
mostCurrent._pan_all_edit1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35192834;
 //BA.debugLineNum = 35192834;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_set_date_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_set_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_set_date_click", null));}
RDebugUtils.currentLine=35323904;
 //BA.debugLineNum = 35323904;BA.debugLine="Private Sub pan_all_set_date_Click";
RDebugUtils.currentLine=35323905;
 //BA.debugLineNum = 35323905;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35323906;
 //BA.debugLineNum = 35323906;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel4_click", null));}
RDebugUtils.currentLine=35258368;
 //BA.debugLineNum = 35258368;BA.debugLine="Private Sub Panel4_Click";
RDebugUtils.currentLine=35258370;
 //BA.debugLineNum = 35258370;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=36110336;
 //BA.debugLineNum = 36110336;BA.debugLine="Private Sub pik_day_bala1_Click";
RDebugUtils.currentLine=36110337;
 //BA.debugLineNum = 36110337;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=36110338;
 //BA.debugLineNum = 36110338;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=36110341;
 //BA.debugLineNum = 36110341;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=36110342;
 //BA.debugLineNum = 36110342;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=36110343;
 //BA.debugLineNum = 36110343;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=36110345;
 //BA.debugLineNum = 36110345;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=36110346;
 //BA.debugLineNum = 36110346;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=36110349;
 //BA.debugLineNum = 36110349;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=36110350;
 //BA.debugLineNum = 36110350;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=36110352;
 //BA.debugLineNum = 36110352;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=36110353;
 //BA.debugLineNum = 36110353;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=36110356;
 //BA.debugLineNum = 36110356;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=36110357;
 //BA.debugLineNum = 36110357;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=36175872;
 //BA.debugLineNum = 36175872;BA.debugLine="Private Sub pik_day_paeen1_Click";
RDebugUtils.currentLine=36175873;
 //BA.debugLineNum = 36175873;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=36175874;
 //BA.debugLineNum = 36175874;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=36175875;
 //BA.debugLineNum = 36175875;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=36175876;
 //BA.debugLineNum = 36175876;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=36175877;
 //BA.debugLineNum = 36175877;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=36175879;
 //BA.debugLineNum = 36175879;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=36175880;
 //BA.debugLineNum = 36175880;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=36175883;
 //BA.debugLineNum = 36175883;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=36175884;
 //BA.debugLineNum = 36175884;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=36175886;
 //BA.debugLineNum = 36175886;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=36175887;
 //BA.debugLineNum = 36175887;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=36175890;
 //BA.debugLineNum = 36175890;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=36175891;
 //BA.debugLineNum = 36175891;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=35848192;
 //BA.debugLineNum = 35848192;BA.debugLine="Private Sub pik_moon_bala1_Click";
RDebugUtils.currentLine=35848193;
 //BA.debugLineNum = 35848193;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=35848194;
 //BA.debugLineNum = 35848194;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
RDebugUtils.currentLine=35848196;
 //BA.debugLineNum = 35848196;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=35848197;
 //BA.debugLineNum = 35848197;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=35848199;
 //BA.debugLineNum = 35848199;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=35848200;
 //BA.debugLineNum = 35848200;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=35848202;
 //BA.debugLineNum = 35848202;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=35848204;
 //BA.debugLineNum = 35848204;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=35913728;
 //BA.debugLineNum = 35913728;BA.debugLine="Private Sub pik_moon_paeen1_Click";
RDebugUtils.currentLine=35913729;
 //BA.debugLineNum = 35913729;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=35913730;
 //BA.debugLineNum = 35913730;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
RDebugUtils.currentLine=35913732;
 //BA.debugLineNum = 35913732;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=35913733;
 //BA.debugLineNum = 35913733;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=35913735;
 //BA.debugLineNum = 35913735;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=35913736;
 //BA.debugLineNum = 35913736;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=35913738;
 //BA.debugLineNum = 35913738;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
RDebugUtils.currentLine=35913740;
 //BA.debugLineNum = 35913740;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_day1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_day1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=35782656;
 //BA.debugLineNum = 35782656;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
RDebugUtils.currentLine=35782657;
 //BA.debugLineNum = 35782657;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=35782658;
 //BA.debugLineNum = 35782658;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=35782659;
 //BA.debugLineNum = 35782659;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=35782662;
 //BA.debugLineNum = 35782662;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=35782664;
 //BA.debugLineNum = 35782664;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=35782665;
 //BA.debugLineNum = 35782665;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
RDebugUtils.currentLine=35782666;
 //BA.debugLineNum = 35782666;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=35782667;
 //BA.debugLineNum = 35782667;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=35782669;
 //BA.debugLineNum = 35782669;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=35782670;
 //BA.debugLineNum = 35782670;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
RDebugUtils.currentLine=35782671;
 //BA.debugLineNum = 35782671;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=35782672;
 //BA.debugLineNum = 35782672;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=35782675;
 //BA.debugLineNum = 35782675;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=35782676;
 //BA.debugLineNum = 35782676;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=35782677;
 //BA.debugLineNum = 35782677;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=35782679;
 //BA.debugLineNum = 35782679;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=35782680;
 //BA.debugLineNum = 35782680;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=35782683;
 //BA.debugLineNum = 35782683;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=35782684;
 //BA.debugLineNum = 35782684;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=35782686;
 //BA.debugLineNum = 35782686;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=35782687;
 //BA.debugLineNum = 35782687;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=35782690;
 //BA.debugLineNum = 35782690;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 };
RDebugUtils.currentLine=35782694;
 //BA.debugLineNum = 35782694;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_moon1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_moon1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=35651584;
 //BA.debugLineNum = 35651584;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
RDebugUtils.currentLine=35651585;
 //BA.debugLineNum = 35651585;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=35651586;
 //BA.debugLineNum = 35651586;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=35651587;
 //BA.debugLineNum = 35651587;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=35651590;
 //BA.debugLineNum = 35651590;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=35651592;
 //BA.debugLineNum = 35651592;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=35651593;
 //BA.debugLineNum = 35651593;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
RDebugUtils.currentLine=35651594;
 //BA.debugLineNum = 35651594;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=35651595;
 //BA.debugLineNum = 35651595;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=35651597;
 //BA.debugLineNum = 35651597;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=35651598;
 //BA.debugLineNum = 35651598;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
RDebugUtils.currentLine=35651599;
 //BA.debugLineNum = 35651599;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=35651600;
 //BA.debugLineNum = 35651600;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=35651603;
 //BA.debugLineNum = 35651603;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=35651604;
 //BA.debugLineNum = 35651604;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=35651606;
 //BA.debugLineNum = 35651606;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=35651607;
 //BA.debugLineNum = 35651607;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=35651609;
 //BA.debugLineNum = 35651609;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
RDebugUtils.currentLine=35651612;
 //BA.debugLineNum = 35651612;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_year1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_year1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=35717120;
 //BA.debugLineNum = 35717120;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
RDebugUtils.currentLine=35717121;
 //BA.debugLineNum = 35717121;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=35717122;
 //BA.debugLineNum = 35717122;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=35717123;
 //BA.debugLineNum = 35717123;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=35717126;
 //BA.debugLineNum = 35717126;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=35717128;
 //BA.debugLineNum = 35717128;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=35717129;
 //BA.debugLineNum = 35717129;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
RDebugUtils.currentLine=35717130;
 //BA.debugLineNum = 35717130;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=35717131;
 //BA.debugLineNum = 35717131;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=35717133;
 //BA.debugLineNum = 35717133;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=35717134;
 //BA.debugLineNum = 35717134;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
RDebugUtils.currentLine=35717135;
 //BA.debugLineNum = 35717135;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=35717136;
 //BA.debugLineNum = 35717136;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=35717139;
 //BA.debugLineNum = 35717139;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=35717140;
 //BA.debugLineNum = 35717140;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=35717142;
 //BA.debugLineNum = 35717142;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=35717143;
 //BA.debugLineNum = 35717143;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
RDebugUtils.currentLine=35717148;
 //BA.debugLineNum = 35717148;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=35979264;
 //BA.debugLineNum = 35979264;BA.debugLine="Private Sub pik_year_bala1_Click";
RDebugUtils.currentLine=35979265;
 //BA.debugLineNum = 35979265;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=35979266;
 //BA.debugLineNum = 35979266;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=35979268;
 //BA.debugLineNum = 35979268;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=35979269;
 //BA.debugLineNum = 35979269;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=35979271;
 //BA.debugLineNum = 35979271;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=35979272;
 //BA.debugLineNum = 35979272;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=35979275;
 //BA.debugLineNum = 35979275;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=36044800;
 //BA.debugLineNum = 36044800;BA.debugLine="Private Sub pik_year_paeen1_Click";
RDebugUtils.currentLine=36044801;
 //BA.debugLineNum = 36044801;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=36044802;
 //BA.debugLineNum = 36044802;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=36044804;
 //BA.debugLineNum = 36044804;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=36044805;
 //BA.debugLineNum = 36044805;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=36044807;
 //BA.debugLineNum = 36044807;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=36044808;
 //BA.debugLineNum = 36044808;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=36044811;
 //BA.debugLineNum = 36044811;BA.debugLine="End Sub";
return "";
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_moon_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_moon_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=36306944;
 //BA.debugLineNum = 36306944;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=36306946;
 //BA.debugLineNum = 36306946;BA.debugLine="fill_list_sayer(sp_year.SelectedItem,myfunc.conve";
_fill_list_sayer(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=36306948;
 //BA.debugLineNum = 36306948;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="sayer_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=36241408;
 //BA.debugLineNum = 36241408;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=36241410;
 //BA.debugLineNum = 36241410;BA.debugLine="fill_list_sayer(sp_year.SelectedItem,myfunc.conve";
_fill_list_sayer(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=36241414;
 //BA.debugLineNum = 36241414;BA.debugLine="End Sub";
return "";
}
}