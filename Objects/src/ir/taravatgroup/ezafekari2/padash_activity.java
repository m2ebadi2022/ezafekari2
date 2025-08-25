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

public class padash_activity extends Activity implements B4AActivity{
	public static padash_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.padash_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (padash_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.padash_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.padash_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (padash_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (padash_activity) Resume **");
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
		return padash_activity.class;
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
            BA.LogInfo("** Activity (padash_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (padash_activity) Pause event (activity is not paused). **");
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
            padash_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (padash_activity) Resume **");
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
public b4a.example3.customlistview _cust_lv_padash = null;
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
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
String _moon_num = "";
RDebugUtils.currentLine=29229056;
 //BA.debugLineNum = 29229056;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=29229058;
 //BA.debugLineNum = 29229058;BA.debugLine="Activity.LoadLayout(\"padash_layout\")";
mostCurrent._activity.LoadLayout("padash_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=29229060;
 //BA.debugLineNum = 29229060;BA.debugLine="sp_year.Add(\"1404\")";
mostCurrent._sp_year.Add("1404");
RDebugUtils.currentLine=29229061;
 //BA.debugLineNum = 29229061;BA.debugLine="sp_year.Add(\"1403\")";
mostCurrent._sp_year.Add("1403");
RDebugUtils.currentLine=29229062;
 //BA.debugLineNum = 29229062;BA.debugLine="sp_year.Add(\"1402\")";
mostCurrent._sp_year.Add("1402");
RDebugUtils.currentLine=29229063;
 //BA.debugLineNum = 29229063;BA.debugLine="sp_year.Add(\"1401\")";
mostCurrent._sp_year.Add("1401");
RDebugUtils.currentLine=29229064;
 //BA.debugLineNum = 29229064;BA.debugLine="sp_year.Add(\"1400\")";
mostCurrent._sp_year.Add("1400");
RDebugUtils.currentLine=29229065;
 //BA.debugLineNum = 29229065;BA.debugLine="sp_year.Add(\"1399\")";
mostCurrent._sp_year.Add("1399");
RDebugUtils.currentLine=29229066;
 //BA.debugLineNum = 29229066;BA.debugLine="sp_year.Add(\"1398\")";
mostCurrent._sp_year.Add("1398");
RDebugUtils.currentLine=29229068;
 //BA.debugLineNum = 29229068;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
mostCurrent._sp_moon.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=29229070;
 //BA.debugLineNum = 29229070;BA.debugLine="sp_year.SelectedIndex=0";
mostCurrent._sp_year.setSelectedIndex((int) (0));
RDebugUtils.currentLine=29229071;
 //BA.debugLineNum = 29229071;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
mostCurrent._sp_moon.setSelectedIndex((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth()))))-1));
RDebugUtils.currentLine=29229073;
 //BA.debugLineNum = 29229073;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(sp_moo";
_moon_num = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1));
RDebugUtils.currentLine=29229076;
 //BA.debugLineNum = 29229076;BA.debugLine="fill_list_padash(sp_year.SelectedItem,moon_num)";
_fill_list_padash(mostCurrent._sp_year.getSelectedItem(),_moon_num);
RDebugUtils.currentLine=29229078;
 //BA.debugLineNum = 29229078;BA.debugLine="pan_hed_list2.Color=Main.color4";
mostCurrent._pan_hed_list2.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=29229079;
 //BA.debugLineNum = 29229079;BA.debugLine="lbl_title_edit1.Color=Main.color4";
mostCurrent._lbl_title_edit1.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=29229084;
 //BA.debugLineNum = 29229084;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
RDebugUtils.currentLine=29229085;
 //BA.debugLineNum = 29229085;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=29229088;
 //BA.debugLineNum = 29229088;BA.debugLine="sp_type_state.Add(\"اضافه شدن به دریافتی ها\")";
mostCurrent._sp_type_state.Add("اضافه شدن به دریافتی ها");
RDebugUtils.currentLine=29229089;
 //BA.debugLineNum = 29229089;BA.debugLine="sp_type_state.Add(\"کم شدن از دریافتی ها\")";
mostCurrent._sp_type_state.Add("کم شدن از دریافتی ها");
RDebugUtils.currentLine=29229092;
 //BA.debugLineNum = 29229092;BA.debugLine="End Sub";
return "";
}
public static String  _fill_list_padash(String _year,String _moon) throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_list_padash", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fill_list_padash", new Object[] {_year,_moon}));}
RDebugUtils.currentLine=29425664;
 //BA.debugLineNum = 29425664;BA.debugLine="Sub fill_list_padash(year As String , moon As Stri";
RDebugUtils.currentLine=29425667;
 //BA.debugLineNum = 29425667;BA.debugLine="cust_LV_padash.Clear";
mostCurrent._cust_lv_padash._clear();
RDebugUtils.currentLine=29425670;
 //BA.debugLineNum = 29425670;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=29425671;
 //BA.debugLineNum = 29425671;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_padash WHERE date LIKE '%"+_year+"/"+_moon+"%' ORDER BY  date DESC;")));
RDebugUtils.currentLine=29425674;
 //BA.debugLineNum = 29425674;BA.debugLine="Do While dbCode.res.NextRow";
while (mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
RDebugUtils.currentLine=29425679;
 //BA.debugLineNum = 29425679;BA.debugLine="p = xui2.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui2.CreatePanel(processBA,"p");
RDebugUtils.currentLine=29425680;
 //BA.debugLineNum = 29425680;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (154)));
RDebugUtils.currentLine=29425681;
 //BA.debugLineNum = 29425681;BA.debugLine="p.LoadLayout(\"item_list_list2\")";
mostCurrent._p.LoadLayout("item_list_list2",mostCurrent.activityBA);
RDebugUtils.currentLine=29425683;
 //BA.debugLineNum = 29425683;BA.debugLine="cust_LV_padash.Add(p,dbCode.res.GetString(\"id\"))";
mostCurrent._cust_lv_padash._add(mostCurrent._p,(Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=29425685;
 //BA.debugLineNum = 29425685;BA.debugLine="lbl_onvan.Text=dbCode.res.GetString(\"onvan\")";
mostCurrent._lbl_onvan.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan")));
RDebugUtils.currentLine=29425687;
 //BA.debugLineNum = 29425687;BA.debugLine="lbl_date.Text=dbCode.res.GetString(\"date\")";
mostCurrent._lbl_date.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date")));
RDebugUtils.currentLine=29425688;
 //BA.debugLineNum = 29425688;BA.debugLine="lbl_mablagh.Tag=dbCode.res.GetString(\"mablagh\")";
mostCurrent._lbl_mablagh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablagh")));
RDebugUtils.currentLine=29425689;
 //BA.debugLineNum = 29425689;BA.debugLine="lbl_mablagh.Text=myfunc.show_num_pool(lbl_mablag";
mostCurrent._lbl_mablagh.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_mablagh.getTag())))));
RDebugUtils.currentLine=29425691;
 //BA.debugLineNum = 29425691;BA.debugLine="lbl_tozih.Text=dbCode.res.GetString(\"tozihat\")";
mostCurrent._lbl_tozih.setText(BA.ObjectToCharSequence(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=29425693;
 //BA.debugLineNum = 29425693;BA.debugLine="lbl_icon.Text=Chr(0xF274)  'def";
mostCurrent._lbl_icon.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf274))));
RDebugUtils.currentLine=29425694;
 //BA.debugLineNum = 29425694;BA.debugLine="lbl_icon.Color=0xFF00A3FF";
mostCurrent._lbl_icon.setColor(((int)0xff00a3ff));
RDebugUtils.currentLine=29425696;
 //BA.debugLineNum = 29425696;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
mostCurrent._lbl_remove_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=29425697;
 //BA.debugLineNum = 29425697;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
mostCurrent._lbl_edit_from_list.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
 }
;
RDebugUtils.currentLine=29425704;
 //BA.debugLineNum = 29425704;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=29425705;
 //BA.debugLineNum = 29425705;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=29425707;
 //BA.debugLineNum = 29425707;BA.debugLine="If(cust_LV_padash.LastVisibleIndex<5)Then";
if ((mostCurrent._cust_lv_padash._getlastvisibleindex()<5)) { 
RDebugUtils.currentLine=29425708;
 //BA.debugLineNum = 29425708;BA.debugLine="p = xui2.CreatePanel(\"p\")";
mostCurrent._p = mostCurrent._xui2.CreatePanel(processBA,"p");
RDebugUtils.currentLine=29425709;
 //BA.debugLineNum = 29425709;BA.debugLine="Select cust_LV_padash.LastVisibleIndex";
switch (BA.switchObjectToInt(mostCurrent._cust_lv_padash._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
RDebugUtils.currentLine=29425711;
 //BA.debugLineNum = 29425711;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((380-100)));
 break; }
case 1: {
RDebugUtils.currentLine=29425713;
 //BA.debugLineNum = 29425713;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 break; }
case 2: {
RDebugUtils.currentLine=29425715;
 //BA.debugLineNum = 29425715;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 break; }
case 3: {
RDebugUtils.currentLine=29425717;
 //BA.debugLineNum = 29425717;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 break; }
case 4: {
RDebugUtils.currentLine=29425719;
 //BA.debugLineNum = 29425719;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 break; }
case 5: {
RDebugUtils.currentLine=29425721;
 //BA.debugLineNum = 29425721;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 break; }
}
;
RDebugUtils.currentLine=29425723;
 //BA.debugLineNum = 29425723;BA.debugLine="cust_LV_padash.Add(p,\"\")";
mostCurrent._cust_lv_padash._add(mostCurrent._p,(Object)(""));
 };
RDebugUtils.currentLine=29425727;
 //BA.debugLineNum = 29425727;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=29556736;
 //BA.debugLineNum = 29556736;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=29556737;
 //BA.debugLineNum = 29556737;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=29556738;
 //BA.debugLineNum = 29556738;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=29556739;
 //BA.debugLineNum = 29556739;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=29556741;
 //BA.debugLineNum = 29556741;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=29556743;
 //BA.debugLineNum = 29556743;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=29491200;
 //BA.debugLineNum = 29491200;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=29491201;
 //BA.debugLineNum = 29491201;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=29491202;
 //BA.debugLineNum = 29491202;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="padash_activity";
RDebugUtils.currentLine=29360128;
 //BA.debugLineNum = 29360128;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=29360130;
 //BA.debugLineNum = 29360130;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=29294592;
 //BA.debugLineNum = 29294592;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=29294594;
 //BA.debugLineNum = 29294594;BA.debugLine="End Sub";
return "";
}
public static String  _et_mablagh_edit1_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mablagh_edit1_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mablagh_edit1_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=30146560;
 //BA.debugLineNum = 30146560;BA.debugLine="Private Sub et_mablagh_edit1_TextChanged (Old As S";
RDebugUtils.currentLine=30146561;
 //BA.debugLineNum = 30146561;BA.debugLine="et_mablagh_edit1.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_mablagh_edit1.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=30146562;
 //BA.debugLineNum = 30146562;BA.debugLine="myfunc.change_formater(Old,New,et_mablagh_edit1)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_mablagh_edit1);
RDebugUtils.currentLine=30146563;
 //BA.debugLineNum = 30146563;BA.debugLine="End Sub";
return "";
}
public static String  _item_edit_box_mod(String _title,String _onvan,String _date,String _mablage,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "item_edit_box_mod", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "item_edit_box_mod", new Object[] {_title,_onvan,_date,_mablage,_tozih,_state}));}
RDebugUtils.currentLine=29753344;
 //BA.debugLineNum = 29753344;BA.debugLine="Sub item_edit_box_mod(title As String,onvan As Str";
RDebugUtils.currentLine=29753347;
 //BA.debugLineNum = 29753347;BA.debugLine="lbl_title_edit1.Text=title";
mostCurrent._lbl_title_edit1.setText(BA.ObjectToCharSequence(_title));
RDebugUtils.currentLine=29753348;
 //BA.debugLineNum = 29753348;BA.debugLine="et_onvan_edit1.Text=onvan";
mostCurrent._et_onvan_edit1.setText(BA.ObjectToCharSequence(_onvan));
RDebugUtils.currentLine=29753349;
 //BA.debugLineNum = 29753349;BA.debugLine="lbl_date_edit1.Text=myfunc.fa2en(date)";
mostCurrent._lbl_date_edit1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date)));
RDebugUtils.currentLine=29753350;
 //BA.debugLineNum = 29753350;BA.debugLine="et_mablagh_edit1.Tag=mablage";
mostCurrent._et_mablagh_edit1.setTag((Object)(_mablage));
RDebugUtils.currentLine=29753351;
 //BA.debugLineNum = 29753351;BA.debugLine="et_mablagh_edit1.Text=myfunc.show_num_pool(mablag";
mostCurrent._et_mablagh_edit1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(_mablage)))));
RDebugUtils.currentLine=29753353;
 //BA.debugLineNum = 29753353;BA.debugLine="et_tozih_edit1.Text=tozih";
mostCurrent._et_tozih_edit1.setText(BA.ObjectToCharSequence(_tozih));
RDebugUtils.currentLine=29753355;
 //BA.debugLineNum = 29753355;BA.debugLine="If(state = 1) Then";
if ((_state==1)) { 
RDebugUtils.currentLine=29753356;
 //BA.debugLineNum = 29753356;BA.debugLine="sp_type_state.SelectedIndex=0";
mostCurrent._sp_type_state.setSelectedIndex((int) (0));
 }else {
RDebugUtils.currentLine=29753358;
 //BA.debugLineNum = 29753358;BA.debugLine="sp_type_state.SelectedIndex=1";
mostCurrent._sp_type_state.setSelectedIndex((int) (1));
 };
RDebugUtils.currentLine=29753361;
 //BA.debugLineNum = 29753361;BA.debugLine="pan_all_edit1.Visible=True";
mostCurrent._pan_all_edit1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=29753363;
 //BA.debugLineNum = 29753363;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_edit1.Text.S";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_edit1.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=29753364;
 //BA.debugLineNum = 29753364;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_edit1.Text.Su";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_edit1.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=29753365;
 //BA.debugLineNum = 29753365;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=29753366;
 //BA.debugLineNum = 29753366;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_edit1.Text.Su";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date_edit1.getText().substring((int) (8),(int) (10)))));
RDebugUtils.currentLine=29753371;
 //BA.debugLineNum = 29753371;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_add_padash_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_add_padash_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_add_padash_click", null));}
RDebugUtils.currentLine=30998528;
 //BA.debugLineNum = 30998528;BA.debugLine="Private Sub lbl_add_padash_Click";
RDebugUtils.currentLine=30998530;
 //BA.debugLineNum = 30998530;BA.debugLine="addEdit_id=0";
_addedit_id = (int) (0);
RDebugUtils.currentLine=30998531;
 //BA.debugLineNum = 30998531;BA.debugLine="item_edit_box_mod(\"ثبت پاداش\",\"\",myfunc.fa2en(Mai";
_item_edit_box_mod("ثبت پاداش","",mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate()),"0","",(int) (0));
RDebugUtils.currentLine=30998532;
 //BA.debugLineNum = 30998532;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_edit1_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date_edit1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date_edit1_click", null));}
RDebugUtils.currentLine=30081024;
 //BA.debugLineNum = 30081024;BA.debugLine="Private Sub lbl_date_edit1_Click";
RDebugUtils.currentLine=30081025;
 //BA.debugLineNum = 30081025;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=30081026;
 //BA.debugLineNum = 30081026;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_from_list_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
RDebugUtils.currentLine=29687808;
 //BA.debugLineNum = 29687808;BA.debugLine="Private Sub lbl_edit_from_list_Click";
RDebugUtils.currentLine=29687809;
 //BA.debugLineNum = 29687809;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=29687810;
 //BA.debugLineNum = 29687810;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=29687812;
 //BA.debugLineNum = 29687812;BA.debugLine="addEdit_id=1";
_addedit_id = (int) (1);
RDebugUtils.currentLine=29687813;
 //BA.debugLineNum = 29687813;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=29687815;
 //BA.debugLineNum = 29687815;BA.debugLine="sp_type_state.Visible=False";
mostCurrent._sp_type_state.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=29687816;
 //BA.debugLineNum = 29687816;BA.debugLine="lbl_sp_type.Visible=False";
mostCurrent._lbl_sp_type.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=29687818;
 //BA.debugLineNum = 29687818;BA.debugLine="index_current_pan=3";
_index_current_pan = (int) (3);
RDebugUtils.currentLine=29687819;
 //BA.debugLineNum = 29687819;BA.debugLine="current_itemId_edit=b.Tag";
_current_itemid_edit = (int)(BA.ObjectToNumber(_b.getTag()));
RDebugUtils.currentLine=29687820;
 //BA.debugLineNum = 29687820;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_padash WHERE id="+BA.NumberToString(_current_itemid_edit))));
RDebugUtils.currentLine=29687821;
 //BA.debugLineNum = 29687821;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=29687823;
 //BA.debugLineNum = 29687823;BA.debugLine="item_edit_box_mod(\"ویرایش\",dbCode.res.GetString(\"";
_item_edit_box_mod("ویرایش",mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan"),mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date"),mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablagh"),mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat"),(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("state"))));
RDebugUtils.currentLine=29687828;
 //BA.debugLineNum = 29687828;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_remove_from_list_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_remove_from_list_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
int _result = 0;
RDebugUtils.currentLine=29622272;
 //BA.debugLineNum = 29622272;BA.debugLine="Private Sub lbl_remove_from_list_Click";
RDebugUtils.currentLine=29622274;
 //BA.debugLineNum = 29622274;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=29622275;
 //BA.debugLineNum = 29622275;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=29622278;
 //BA.debugLineNum = 29622278;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=29622279;
 //BA.debugLineNum = 29622279;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=29622280;
 //BA.debugLineNum = 29622280;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=29622282;
 //BA.debugLineNum = 29622282;BA.debugLine="If (dbCode.delete_padash(b.Tag))Then";
if ((mostCurrent._dbcode._delete_padash /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=29622283;
 //BA.debugLineNum = 29622283;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=29622286;
 //BA.debugLineNum = 29622286;BA.debugLine="fill_list_padash(sp_year.SelectedItem,myfunc.co";
_fill_list_padash(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
 };
 };
RDebugUtils.currentLine=29622295;
 //BA.debugLineNum = 29622295;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_edit1_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_edit1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_edit1_click", null));}
RDebugUtils.currentLine=30015488;
 //BA.debugLineNum = 30015488;BA.debugLine="Private Sub lbl_save_edit1_Click";
RDebugUtils.currentLine=30015490;
 //BA.debugLineNum = 30015490;BA.debugLine="If(et_onvan_edit1.Text=\"\")Then";
if (((mostCurrent._et_onvan_edit1.getText()).equals(""))) { 
RDebugUtils.currentLine=30015491;
 //BA.debugLineNum = 30015491;BA.debugLine="ToastMessageShow(\"عنوان خالی است!\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("عنوان خالی است!"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=30015492;
 //BA.debugLineNum = 30015492;BA.debugLine="Else If(et_mablagh_edit1.Tag=\"\")Then";
if (((mostCurrent._et_mablagh_edit1.getTag()).equals((Object)("")))) { 
RDebugUtils.currentLine=30015493;
 //BA.debugLineNum = 30015493;BA.debugLine="ToastMessageShow(\"مبلغ خالی است!\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("مبلغ خالی است!"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=30015496;
 //BA.debugLineNum = 30015496;BA.debugLine="If(addEdit_id=0)Then";
if ((_addedit_id==0)) { 
RDebugUtils.currentLine=30015497;
 //BA.debugLineNum = 30015497;BA.debugLine="dbCode.add_padash(et_onvan_edit1.Text ,lbl_date";
mostCurrent._dbcode._add_padash /*boolean*/ (mostCurrent.activityBA,mostCurrent._et_onvan_edit1.getText(),mostCurrent._lbl_date_edit1.getText(),BA.ObjectToString(mostCurrent._et_mablagh_edit1.getTag()),mostCurrent._et_tozih_edit1.getText(),(int) (0));
 }else 
{RDebugUtils.currentLine=30015499;
 //BA.debugLineNum = 30015499;BA.debugLine="Else If(addEdit_id=1)Then";
if ((_addedit_id==1)) { 
RDebugUtils.currentLine=30015500;
 //BA.debugLineNum = 30015500;BA.debugLine="dbCode.edit_padash(current_itemId_edit,et_onvan";
mostCurrent._dbcode._edit_padash /*boolean*/ (mostCurrent.activityBA,_current_itemid_edit,mostCurrent._et_onvan_edit1.getText(),mostCurrent._lbl_date_edit1.getText(),BA.ObjectToString(mostCurrent._et_mablagh_edit1.getTag()),mostCurrent._et_tozih_edit1.getText(),(int) (0));
RDebugUtils.currentLine=30015501;
 //BA.debugLineNum = 30015501;BA.debugLine="ToastMessageShow(\"ویرایش شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ویرایش شد"),anywheresoftware.b4a.keywords.Common.False);
 }}
;
RDebugUtils.currentLine=30015507;
 //BA.debugLineNum = 30015507;BA.debugLine="fill_list_padash(sp_year.SelectedItem,myfunc.con";
_fill_list_padash(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=30015508;
 //BA.debugLineNum = 30015508;BA.debugLine="pan_all_edit1.Visible=False";
mostCurrent._pan_all_edit1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }}
;
RDebugUtils.currentLine=30015510;
 //BA.debugLineNum = 30015510;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_picker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_picker_click", null));}
RDebugUtils.currentLine=30212096;
 //BA.debugLineNum = 30212096;BA.debugLine="Private Sub lbl_save_picker_Click";
RDebugUtils.currentLine=30212097;
 //BA.debugLineNum = 30212097;BA.debugLine="lbl_date_edit1.Text=pik_year1.Text&\"/\"&myfunc.con";
mostCurrent._lbl_date_edit1.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=30212098;
 //BA.debugLineNum = 30212098;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=30212099;
 //BA.debugLineNum = 30212099;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_edit1_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_edit1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_edit1_click", null));}
RDebugUtils.currentLine=29818880;
 //BA.debugLineNum = 29818880;BA.debugLine="Private Sub pan_all_edit1_Click";
RDebugUtils.currentLine=29818881;
 //BA.debugLineNum = 29818881;BA.debugLine="pan_all_edit1.Visible=False";
mostCurrent._pan_all_edit1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=29818882;
 //BA.debugLineNum = 29818882;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_set_date_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_set_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_set_date_click", null));}
RDebugUtils.currentLine=29949952;
 //BA.debugLineNum = 29949952;BA.debugLine="Private Sub pan_all_set_date_Click";
RDebugUtils.currentLine=29949953;
 //BA.debugLineNum = 29949953;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=29949954;
 //BA.debugLineNum = 29949954;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel4_click", null));}
RDebugUtils.currentLine=29884416;
 //BA.debugLineNum = 29884416;BA.debugLine="Private Sub Panel4_Click";
RDebugUtils.currentLine=29884418;
 //BA.debugLineNum = 29884418;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_bala1_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=30736384;
 //BA.debugLineNum = 30736384;BA.debugLine="Private Sub pik_day_bala1_Click";
RDebugUtils.currentLine=30736385;
 //BA.debugLineNum = 30736385;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=30736386;
 //BA.debugLineNum = 30736386;BA.debugLine="pik_day1.Text=int1+1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=30736389;
 //BA.debugLineNum = 30736389;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=30736390;
 //BA.debugLineNum = 30736390;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=30736391;
 //BA.debugLineNum = 30736391;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=30736393;
 //BA.debugLineNum = 30736393;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=30736394;
 //BA.debugLineNum = 30736394;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=30736397;
 //BA.debugLineNum = 30736397;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=30736398;
 //BA.debugLineNum = 30736398;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=30736400;
 //BA.debugLineNum = 30736400;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=30736401;
 //BA.debugLineNum = 30736401;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=30736404;
 //BA.debugLineNum = 30736404;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=30736405;
 //BA.debugLineNum = 30736405;BA.debugLine="End Sub";
return "";
}
public static String  _pik_day_paeen1_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_day_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_day_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=30801920;
 //BA.debugLineNum = 30801920;BA.debugLine="Private Sub pik_day_paeen1_Click";
RDebugUtils.currentLine=30801921;
 //BA.debugLineNum = 30801921;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())));
RDebugUtils.currentLine=30801922;
 //BA.debugLineNum = 30801922;BA.debugLine="pik_day1.Text=int1-1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=30801923;
 //BA.debugLineNum = 30801923;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=30801924;
 //BA.debugLineNum = 30801924;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=30801925;
 //BA.debugLineNum = 30801925;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=30801927;
 //BA.debugLineNum = 30801927;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=30801928;
 //BA.debugLineNum = 30801928;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=30801931;
 //BA.debugLineNum = 30801931;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=30801932;
 //BA.debugLineNum = 30801932;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=30801934;
 //BA.debugLineNum = 30801934;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=30801935;
 //BA.debugLineNum = 30801935;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=30801938;
 //BA.debugLineNum = 30801938;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
RDebugUtils.currentLine=30801939;
 //BA.debugLineNum = 30801939;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=30474240;
 //BA.debugLineNum = 30474240;BA.debugLine="Private Sub pik_moon_bala1_Click";
RDebugUtils.currentLine=30474241;
 //BA.debugLineNum = 30474241;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=30474242;
 //BA.debugLineNum = 30474242;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
RDebugUtils.currentLine=30474244;
 //BA.debugLineNum = 30474244;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=30474245;
 //BA.debugLineNum = 30474245;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=30474247;
 //BA.debugLineNum = 30474247;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=30474248;
 //BA.debugLineNum = 30474248;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=30474250;
 //BA.debugLineNum = 30474250;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=30474252;
 //BA.debugLineNum = 30474252;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=30539776;
 //BA.debugLineNum = 30539776;BA.debugLine="Private Sub pik_moon_paeen1_Click";
RDebugUtils.currentLine=30539777;
 //BA.debugLineNum = 30539777;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=30539778;
 //BA.debugLineNum = 30539778;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
RDebugUtils.currentLine=30539780;
 //BA.debugLineNum = 30539780;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=30539781;
 //BA.debugLineNum = 30539781;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=30539783;
 //BA.debugLineNum = 30539783;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=30539784;
 //BA.debugLineNum = 30539784;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=30539786;
 //BA.debugLineNum = 30539786;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
RDebugUtils.currentLine=30539788;
 //BA.debugLineNum = 30539788;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_day1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_day1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_day1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=30408704;
 //BA.debugLineNum = 30408704;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
RDebugUtils.currentLine=30408705;
 //BA.debugLineNum = 30408705;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=30408706;
 //BA.debugLineNum = 30408706;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=30408707;
 //BA.debugLineNum = 30408707;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=30408710;
 //BA.debugLineNum = 30408710;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=30408712;
 //BA.debugLineNum = 30408712;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=30408713;
 //BA.debugLineNum = 30408713;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))-1);
RDebugUtils.currentLine=30408714;
 //BA.debugLineNum = 30408714;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=30408715;
 //BA.debugLineNum = 30408715;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=30408717;
 //BA.debugLineNum = 30408717;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=30408718;
 //BA.debugLineNum = 30408718;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_day1.getText())))+1);
RDebugUtils.currentLine=30408719;
 //BA.debugLineNum = 30408719;BA.debugLine="pik_day1.Text=int1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=30408720;
 //BA.debugLineNum = 30408720;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=30408723;
 //BA.debugLineNum = 30408723;BA.debugLine="If(pik_moon1.Tag<7)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<7)) { 
RDebugUtils.currentLine=30408724;
 //BA.debugLineNum = 30408724;BA.debugLine="If(pik_day1.Text>31)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>31)) { 
RDebugUtils.currentLine=30408725;
 //BA.debugLineNum = 30408725;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=30408727;
 //BA.debugLineNum = 30408727;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=30408728;
 //BA.debugLineNum = 30408728;BA.debugLine="pik_day1.Text=31";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(31));
 };
 }else {
RDebugUtils.currentLine=30408731;
 //BA.debugLineNum = 30408731;BA.debugLine="If(pik_day1.Text>30)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))>30)) { 
RDebugUtils.currentLine=30408732;
 //BA.debugLineNum = 30408732;BA.debugLine="pik_day1.Text=1";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(1));
 };
RDebugUtils.currentLine=30408734;
 //BA.debugLineNum = 30408734;BA.debugLine="If(pik_day1.Text<1)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_day1.getText()))<1)) { 
RDebugUtils.currentLine=30408735;
 //BA.debugLineNum = 30408735;BA.debugLine="pik_day1.Text=30";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(30));
 };
 };
RDebugUtils.currentLine=30408738;
 //BA.debugLineNum = 30408738;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
mostCurrent._pik_day1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._pik_day1.getText())))));
 };
RDebugUtils.currentLine=30408742;
 //BA.debugLineNum = 30408742;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_moon1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_moon1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=30277632;
 //BA.debugLineNum = 30277632;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
RDebugUtils.currentLine=30277633;
 //BA.debugLineNum = 30277633;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=30277634;
 //BA.debugLineNum = 30277634;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=30277635;
 //BA.debugLineNum = 30277635;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=30277638;
 //BA.debugLineNum = 30277638;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=30277640;
 //BA.debugLineNum = 30277640;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=30277641;
 //BA.debugLineNum = 30277641;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
RDebugUtils.currentLine=30277642;
 //BA.debugLineNum = 30277642;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=30277643;
 //BA.debugLineNum = 30277643;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=30277645;
 //BA.debugLineNum = 30277645;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=30277646;
 //BA.debugLineNum = 30277646;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
RDebugUtils.currentLine=30277647;
 //BA.debugLineNum = 30277647;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=30277648;
 //BA.debugLineNum = 30277648;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=30277651;
 //BA.debugLineNum = 30277651;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=30277652;
 //BA.debugLineNum = 30277652;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=30277654;
 //BA.debugLineNum = 30277654;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=30277655;
 //BA.debugLineNum = 30277655;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=30277657;
 //BA.debugLineNum = 30277657;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
RDebugUtils.currentLine=30277660;
 //BA.debugLineNum = 30277660;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_year1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_year1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=30343168;
 //BA.debugLineNum = 30343168;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
RDebugUtils.currentLine=30343169;
 //BA.debugLineNum = 30343169;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=30343170;
 //BA.debugLineNum = 30343170;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=30343171;
 //BA.debugLineNum = 30343171;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=30343174;
 //BA.debugLineNum = 30343174;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=30343176;
 //BA.debugLineNum = 30343176;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=30343177;
 //BA.debugLineNum = 30343177;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
RDebugUtils.currentLine=30343178;
 //BA.debugLineNum = 30343178;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=30343179;
 //BA.debugLineNum = 30343179;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=30343181;
 //BA.debugLineNum = 30343181;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=30343182;
 //BA.debugLineNum = 30343182;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
RDebugUtils.currentLine=30343183;
 //BA.debugLineNum = 30343183;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=30343184;
 //BA.debugLineNum = 30343184;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=30343187;
 //BA.debugLineNum = 30343187;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=30343188;
 //BA.debugLineNum = 30343188;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=30343190;
 //BA.debugLineNum = 30343190;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=30343191;
 //BA.debugLineNum = 30343191;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
RDebugUtils.currentLine=30343196;
 //BA.debugLineNum = 30343196;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=30605312;
 //BA.debugLineNum = 30605312;BA.debugLine="Private Sub pik_year_bala1_Click";
RDebugUtils.currentLine=30605313;
 //BA.debugLineNum = 30605313;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=30605314;
 //BA.debugLineNum = 30605314;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=30605316;
 //BA.debugLineNum = 30605316;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=30605317;
 //BA.debugLineNum = 30605317;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=30605319;
 //BA.debugLineNum = 30605319;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=30605320;
 //BA.debugLineNum = 30605320;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=30605323;
 //BA.debugLineNum = 30605323;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=30670848;
 //BA.debugLineNum = 30670848;BA.debugLine="Private Sub pik_year_paeen1_Click";
RDebugUtils.currentLine=30670849;
 //BA.debugLineNum = 30670849;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=30670850;
 //BA.debugLineNum = 30670850;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=30670852;
 //BA.debugLineNum = 30670852;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=30670853;
 //BA.debugLineNum = 30670853;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=30670855;
 //BA.debugLineNum = 30670855;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=30670856;
 //BA.debugLineNum = 30670856;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=30670859;
 //BA.debugLineNum = 30670859;BA.debugLine="End Sub";
return "";
}
public static String  _sp_moon_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_moon_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_moon_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=30932992;
 //BA.debugLineNum = 30932992;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=30932994;
 //BA.debugLineNum = 30932994;BA.debugLine="fill_list_padash(sp_year.SelectedItem,myfunc.conv";
_fill_list_padash(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=30932996;
 //BA.debugLineNum = 30932996;BA.debugLine="End Sub";
return "";
}
public static String  _sp_year_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="padash_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_year_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_year_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=30867456;
 //BA.debugLineNum = 30867456;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=30867458;
 //BA.debugLineNum = 30867458;BA.debugLine="fill_list_padash(sp_year.SelectedItem,myfunc.conv";
_fill_list_padash(mostCurrent._sp_year.getSelectedItem(),mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int) (mostCurrent._sp_moon.getSelectedIndex()+1)));
RDebugUtils.currentLine=30867462;
 //BA.debugLineNum = 30867462;BA.debugLine="End Sub";
return "";
}
}