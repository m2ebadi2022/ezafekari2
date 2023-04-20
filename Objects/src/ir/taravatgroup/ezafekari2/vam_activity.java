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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.vam_activity");
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
        
        BA.LogInfo("** Activity (vam_activity) Create " + (isFirst ? "(first time)" : "") + " **");
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
public anywheresoftware.b4a.objects.PanelWrapper _pan_tools = null;
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
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
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=59768832;
 //BA.debugLineNum = 59768832;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=59768834;
 //BA.debugLineNum = 59768834;BA.debugLine="Activity.LoadLayout(\"vam_layout\")";
mostCurrent._activity.LoadLayout("vam_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=59768838;
 //BA.debugLineNum = 59768838;BA.debugLine="pan_hed_vam.Color=Main.color4";
mostCurrent._pan_hed_vam.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=59768839;
 //BA.debugLineNum = 59768839;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=59768843;
 //BA.debugLineNum = 59768843;BA.debugLine="fill_list_vam";
_fill_list_vam();
RDebugUtils.currentLine=59768846;
 //BA.debugLineNum = 59768846;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
RDebugUtils.currentLine=59768847;
 //BA.debugLineNum = 59768847;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=59768850;
 //BA.debugLineNum = 59768850;BA.debugLine="lbl_date.Text=Main.persianDate.PersianYear&\"/\"&my";
mostCurrent._lbl_date.setText(BA.ObjectToCharSequence(BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth())));
RDebugUtils.currentLine=59768853;
 //BA.debugLineNum = 59768853;BA.debugLine="wb_show_result.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._wb_show_result.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=59768854;
 //BA.debugLineNum = 59768854;BA.debugLine="wb_show_result.ZoomEnabled=False";
mostCurrent._wb_show_result.setZoomEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=59768856;
 //BA.debugLineNum = 59768856;BA.debugLine="End Sub";
return "";
}
public static void  _fill_list_vam() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fill_list_vam", false))
	 {Debug.delegate(mostCurrent.activityBA, "fill_list_vam", null); return;}
ResumableSub_fill_list_vam rsub = new ResumableSub_fill_list_vam(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_fill_list_vam extends BA.ResumableSub {
public ResumableSub_fill_list_vam(ir.taravatgroup.ezafekari2.vam_activity parent) {
this.parent = parent;
}
ir.taravatgroup.ezafekari2.vam_activity parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="vam_activity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=59965443;
 //BA.debugLineNum = 59965443;BA.debugLine="cust_LV_vam.Clear";
parent.mostCurrent._cust_lv_vam._clear();
RDebugUtils.currentLine=59965446;
 //BA.debugLineNum = 59965446;BA.debugLine="dbCode.connect_db";
parent.mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=59965447;
 //BA.debugLineNum = 59965447;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(parent.mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_vam ORDER BY  date DESC;")));
RDebugUtils.currentLine=59965450;
 //BA.debugLineNum = 59965450;BA.debugLine="Do While dbCode.res.NextRow";
if (true) break;

case 1:
//do while
this.state = 4;
while (parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .NextRow()) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
RDebugUtils.currentLine=59965455;
 //BA.debugLineNum = 59965455;BA.debugLine="p = xui2.CreatePanel(\"p\")";
parent.mostCurrent._p = parent.mostCurrent._xui2.CreatePanel(processBA,"p");
RDebugUtils.currentLine=59965456;
 //BA.debugLineNum = 59965456;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 98%x, 165dip)";
parent.mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (98),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (165)));
RDebugUtils.currentLine=59965457;
 //BA.debugLineNum = 59965457;BA.debugLine="p.LoadLayout(\"item_list_vam\")";
parent.mostCurrent._p.LoadLayout("item_list_vam",mostCurrent.activityBA);
RDebugUtils.currentLine=59965459;
 //BA.debugLineNum = 59965459;BA.debugLine="cust_LV_vam.Add(p,dbCode.res.GetString(\"id\"))";
parent.mostCurrent._cust_lv_vam._add(parent.mostCurrent._p,(Object)(parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=59965461;
 //BA.debugLineNum = 59965461;BA.debugLine="lbl_onvan2.Text=dbCode.res.GetString(\"onvan\")";
parent.mostCurrent._lbl_onvan2.setText(BA.ObjectToCharSequence(parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan")));
RDebugUtils.currentLine=59965465;
 //BA.debugLineNum = 59965465;BA.debugLine="lbl_mablagh2.Tag=dbCode.res.GetString(\"mablag\")";
parent.mostCurrent._lbl_mablagh2.setTag((Object)(parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablag")));
RDebugUtils.currentLine=59965466;
 //BA.debugLineNum = 59965466;BA.debugLine="lbl_mablagh2.Text=\" مبلغ وام :\" & myfunc.show_nu";
parent.mostCurrent._lbl_mablagh2.setText(BA.ObjectToCharSequence(" مبلغ وام :"+parent.mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(parent.mostCurrent._lbl_mablagh2.getTag())))));
RDebugUtils.currentLine=59965468;
 //BA.debugLineNum = 59965468;BA.debugLine="lbl_tozih2.Text=dbCode.res.GetString(\"tozihat\")";
parent.mostCurrent._lbl_tozih2.setText(BA.ObjectToCharSequence(parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=59965470;
 //BA.debugLineNum = 59965470;BA.debugLine="lbl_icon2.Text=Chr(0xF274)  'def";
parent.mostCurrent._lbl_icon2.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf274))));
RDebugUtils.currentLine=59965471;
 //BA.debugLineNum = 59965471;BA.debugLine="lbl_icon2.Color=0xFF00A3FF";
parent.mostCurrent._lbl_icon2.setColor(((int)0xff00a3ff));
RDebugUtils.currentLine=59965473;
 //BA.debugLineNum = 59965473;BA.debugLine="lbl_remove_from_list2.tag=dbCode.res.GetString(\"";
parent.mostCurrent._lbl_remove_from_list2.setTag((Object)(parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=59965474;
 //BA.debugLineNum = 59965474;BA.debugLine="lbl_info.tag=dbCode.res.GetString(\"id\")";
parent.mostCurrent._lbl_info.setTag((Object)(parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=59965476;
 //BA.debugLineNum = 59965476;BA.debugLine="lbl_go_agsatPage.Tag=dbCode.res.GetString(\"idvam";
parent.mostCurrent._lbl_go_agsatpage.setTag((Object)(parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("idvam")));
RDebugUtils.currentLine=59965480;
 //BA.debugLineNum = 59965480;BA.debugLine="pan_tools.SetLayoutAnimated(200,0,pan_tools.Top,";
parent.mostCurrent._pan_tools.SetLayoutAnimated((int) (200),(int) (0),parent.mostCurrent._pan_tools.getTop(),parent.mostCurrent._pan_tools.getWidth(),parent.mostCurrent._pan_tools.getHeight());
RDebugUtils.currentLine=59965482;
 //BA.debugLineNum = 59965482;BA.debugLine="Sleep(10)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "vam_activity", "fill_list_vam"),(int) (10));
this.state = 23;
return;
case 23:
//C
this.state = 1;
;
 if (true) break;

case 4:
//C
this.state = 5;
;
RDebugUtils.currentLine=59965484;
 //BA.debugLineNum = 59965484;BA.debugLine="dbCode.res.Close";
parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=59965485;
 //BA.debugLineNum = 59965485;BA.debugLine="dbCode.sql.Close";
parent.mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=59965487;
 //BA.debugLineNum = 59965487;BA.debugLine="If(cust_LV_vam.LastVisibleIndex<5)Then";
if (true) break;

case 5:
//if
this.state = 22;
if ((parent.mostCurrent._cust_lv_vam._getlastvisibleindex()<5)) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
RDebugUtils.currentLine=59965488;
 //BA.debugLineNum = 59965488;BA.debugLine="p = xui2.CreatePanel(\"p\")";
parent.mostCurrent._p = parent.mostCurrent._xui2.CreatePanel(processBA,"p");
RDebugUtils.currentLine=59965489;
 //BA.debugLineNum = 59965489;BA.debugLine="Select cust_LV_vam.LastVisibleIndex";
if (true) break;

case 8:
//select
this.state = 21;
switch (BA.switchObjectToInt(parent.mostCurrent._cust_lv_vam._getlastvisibleindex(),(int) (-1),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4))) {
case 0: {
this.state = 10;
if (true) break;
}
case 1: {
this.state = 12;
if (true) break;
}
case 2: {
this.state = 14;
if (true) break;
}
case 3: {
this.state = 16;
if (true) break;
}
case 4: {
this.state = 18;
if (true) break;
}
case 5: {
this.state = 20;
if (true) break;
}
}
if (true) break;

case 10:
//C
this.state = 21;
RDebugUtils.currentLine=59965491;
 //BA.debugLineNum = 59965491;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
parent.mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((380-100)));
 if (true) break;

case 12:
//C
this.state = 21;
RDebugUtils.currentLine=59965493;
 //BA.debugLineNum = 59965493;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
parent.mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 if (true) break;

case 14:
//C
this.state = 21;
RDebugUtils.currentLine=59965495;
 //BA.debugLineNum = 59965495;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
parent.mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 if (true) break;

case 16:
//C
this.state = 21;
RDebugUtils.currentLine=59965497;
 //BA.debugLineNum = 59965497;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
parent.mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 if (true) break;

case 18:
//C
this.state = 21;
RDebugUtils.currentLine=59965499;
 //BA.debugLineNum = 59965499;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
parent.mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 if (true) break;

case 20:
//C
this.state = 21;
RDebugUtils.currentLine=59965501;
 //BA.debugLineNum = 59965501;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
parent.mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 if (true) break;

case 21:
//C
this.state = 22;
;
RDebugUtils.currentLine=59965503;
 //BA.debugLineNum = 59965503;BA.debugLine="cust_LV_vam.Add(p,\"\")";
parent.mostCurrent._cust_lv_vam._add(parent.mostCurrent._p,(Object)(""));
 if (true) break;

case 22:
//C
this.state = -1;
;
RDebugUtils.currentLine=59965507;
 //BA.debugLineNum = 59965507;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=60096512;
 //BA.debugLineNum = 60096512;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=60096513;
 //BA.debugLineNum = 60096513;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=60096514;
 //BA.debugLineNum = 60096514;BA.debugLine="If(pan_all_set_date.Visible=True)Then";
if ((mostCurrent._pan_all_set_date.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=60096515;
 //BA.debugLineNum = 60096515;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=60096516;
 //BA.debugLineNum = 60096516;BA.debugLine="Else If (pan_all_add.Visible=True)Then";
if ((mostCurrent._pan_all_add.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=60096517;
 //BA.debugLineNum = 60096517;BA.debugLine="pan_all_add.Visible=False";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=60096519;
 //BA.debugLineNum = 60096519;BA.debugLine="Else If (pan_all_show_info.Visible=True)Then";
if ((mostCurrent._pan_all_show_info.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=60096520;
 //BA.debugLineNum = 60096520;BA.debugLine="pan_all_show_info.Visible=False";
mostCurrent._pan_all_show_info.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=60096522;
 //BA.debugLineNum = 60096522;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 }}}
;
RDebugUtils.currentLine=60096525;
 //BA.debugLineNum = 60096525;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=60096527;
 //BA.debugLineNum = 60096527;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=60096529;
 //BA.debugLineNum = 60096529;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=60030976;
 //BA.debugLineNum = 60030976;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=60030977;
 //BA.debugLineNum = 60030977;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=60030978;
 //BA.debugLineNum = 60030978;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="vam_activity";
RDebugUtils.currentLine=59899904;
 //BA.debugLineNum = 59899904;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=59899906;
 //BA.debugLineNum = 59899906;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=59834368;
 //BA.debugLineNum = 59834368;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=59834370;
 //BA.debugLineNum = 59834370;BA.debugLine="End Sub";
return "";
}
public static String  _et_mablagh_vam_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mablagh_vam_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mablagh_vam_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=60358656;
 //BA.debugLineNum = 60358656;BA.debugLine="Private Sub et_mablagh_vam_TextChanged (Old As Str";
RDebugUtils.currentLine=60358657;
 //BA.debugLineNum = 60358657;BA.debugLine="et_mablagh_vam.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_mablagh_vam.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=60358658;
 //BA.debugLineNum = 60358658;BA.debugLine="myfunc.change_formater(Old,New,et_mablagh_vam)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_mablagh_vam);
RDebugUtils.currentLine=60358659;
 //BA.debugLineNum = 60358659;BA.debugLine="mohasebe";
_mohasebe();
RDebugUtils.currentLine=60358660;
 //BA.debugLineNum = 60358660;BA.debugLine="End Sub";
return "";
}
public static String  _mohasebe() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mohasebe", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "mohasebe", null));}
double _eb1 = 0;
double _sorat = 0;
double _makhraj = 0;
double _gest = 0;
double _sod = 0;
RDebugUtils.currentLine=61145088;
 //BA.debugLineNum = 61145088;BA.debugLine="Sub mohasebe";
RDebugUtils.currentLine=61145089;
 //BA.debugLineNum = 61145089;BA.debugLine="If(et_mablagh_vam.Text=\"\" Or et_nerkh_vam.Text=\"\"";
if (((mostCurrent._et_mablagh_vam.getText()).equals("") || (mostCurrent._et_nerkh_vam.getText()).equals("") || (mostCurrent._et_tedad_gest.getText()).equals(""))) { 
 }else {
RDebugUtils.currentLine=61145093;
 //BA.debugLineNum = 61145093;BA.debugLine="Dim eb1 As Double=Power( (1+(et_nerkh_vam.Text/1";
_eb1 = anywheresoftware.b4a.keywords.Common.Power((1+((double)(Double.parseDouble(mostCurrent._et_nerkh_vam.getText()))/(double)1200)),(double)(Double.parseDouble(mostCurrent._et_tedad_gest.getText())));
RDebugUtils.currentLine=61145094;
 //BA.debugLineNum = 61145094;BA.debugLine="Dim sorat As Double=et_mablagh_vam.Tag*(et_nerkh";
_sorat = (double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag()))*((double)(Double.parseDouble(mostCurrent._et_nerkh_vam.getText()))/(double)1200)*_eb1;
RDebugUtils.currentLine=61145095;
 //BA.debugLineNum = 61145095;BA.debugLine="Dim makhraj As Double=eb1-1";
_makhraj = _eb1-1;
RDebugUtils.currentLine=61145097;
 //BA.debugLineNum = 61145097;BA.debugLine="Dim gest As Double=sorat/makhraj";
_gest = _sorat/(double)_makhraj;
RDebugUtils.currentLine=61145099;
 //BA.debugLineNum = 61145099;BA.debugLine="Dim sod As Double=(gest*et_tedad_gest.Text)-et_m";
_sod = (_gest*(double)(Double.parseDouble(mostCurrent._et_tedad_gest.getText())))-(double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag()));
RDebugUtils.currentLine=61145102;
 //BA.debugLineNum = 61145102;BA.debugLine="lbl_harGest.Tag=Round(gest)";
mostCurrent._lbl_hargest.setTag((Object)(anywheresoftware.b4a.keywords.Common.Round(_gest)));
RDebugUtils.currentLine=61145103;
 //BA.debugLineNum = 61145103;BA.debugLine="lbl_kol_bazPardakht.Tag=Round(et_mablagh_vam.Tag";
mostCurrent._lbl_kol_bazpardakht.setTag((Object)(anywheresoftware.b4a.keywords.Common.Round((double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag()))+_sod)));
RDebugUtils.currentLine=61145105;
 //BA.debugLineNum = 61145105;BA.debugLine="lbl_harGest.Text=myfunc.show_num_pool(Round(gest";
mostCurrent._lbl_hargest.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int) (anywheresoftware.b4a.keywords.Common.Round(_gest)))+" تومان "));
RDebugUtils.currentLine=61145106;
 //BA.debugLineNum = 61145106;BA.debugLine="lbl_kol_bazPardakht.Text=myfunc.show_num_pool(Ro";
mostCurrent._lbl_kol_bazpardakht.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int) (anywheresoftware.b4a.keywords.Common.Round((double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag()))+_sod)))+" تومان "));
 };
RDebugUtils.currentLine=61145111;
 //BA.debugLineNum = 61145111;BA.debugLine="End Sub";
return "";
}
public static String  _et_nerkh_vam_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_nerkh_vam_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_nerkh_vam_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=61210624;
 //BA.debugLineNum = 61210624;BA.debugLine="Private Sub et_nerkh_vam_TextChanged (Old As Strin";
RDebugUtils.currentLine=61210625;
 //BA.debugLineNum = 61210625;BA.debugLine="mohasebe";
_mohasebe();
RDebugUtils.currentLine=61210626;
 //BA.debugLineNum = 61210626;BA.debugLine="End Sub";
return "";
}
public static String  _et_tedad_gest_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_tedad_gest_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_tedad_gest_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=61276160;
 //BA.debugLineNum = 61276160;BA.debugLine="Private Sub et_tedad_gest_TextChanged (Old As Stri";
RDebugUtils.currentLine=61276161;
 //BA.debugLineNum = 61276161;BA.debugLine="mohasebe";
_mohasebe();
RDebugUtils.currentLine=61276162;
 //BA.debugLineNum = 61276162;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_add_vam_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_add_vam_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_add_vam_click", null));}
RDebugUtils.currentLine=60882944;
 //BA.debugLineNum = 60882944;BA.debugLine="Private Sub lbl_add_vam_Click";
RDebugUtils.currentLine=60882945;
 //BA.debugLineNum = 60882945;BA.debugLine="et_onvan.Text=\"\"";
mostCurrent._et_onvan.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=60882946;
 //BA.debugLineNum = 60882946;BA.debugLine="et_mablagh_vam.Text=\"\"";
mostCurrent._et_mablagh_vam.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=60882947;
 //BA.debugLineNum = 60882947;BA.debugLine="et_mablagh_vam.tag=\"\"";
mostCurrent._et_mablagh_vam.setTag((Object)(""));
RDebugUtils.currentLine=60882948;
 //BA.debugLineNum = 60882948;BA.debugLine="et_nerkh_vam.Text=\"\"";
mostCurrent._et_nerkh_vam.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=60882949;
 //BA.debugLineNum = 60882949;BA.debugLine="et_tedad_gest.Text=\"\"";
mostCurrent._et_tedad_gest.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=60882951;
 //BA.debugLineNum = 60882951;BA.debugLine="pan_all_add.Visible=True";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=60882953;
 //BA.debugLineNum = 60882953;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_agsat_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_agsat_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_agsat_click", null));}
RDebugUtils.currentLine=61538304;
 //BA.debugLineNum = 61538304;BA.debugLine="Private Sub lbl_agsat_Click";
RDebugUtils.currentLine=61538305;
 //BA.debugLineNum = 61538305;BA.debugLine="pan_all_show_info.Visible=False";
mostCurrent._pan_all_show_info.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=61538307;
 //BA.debugLineNum = 61538307;BA.debugLine="StartActivity(gestha_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._gestha_activity.getObject()));
RDebugUtils.currentLine=61538308;
 //BA.debugLineNum = 61538308;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_click", null));}
RDebugUtils.currentLine=61603840;
 //BA.debugLineNum = 61603840;BA.debugLine="Private Sub lbl_close_Click";
RDebugUtils.currentLine=61603841;
 //BA.debugLineNum = 61603841;BA.debugLine="pan_all_show_info.Visible=False";
mostCurrent._pan_all_show_info.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=61603842;
 //BA.debugLineNum = 61603842;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date_click", null));}
RDebugUtils.currentLine=61014016;
 //BA.debugLineNum = 61014016;BA.debugLine="Private Sub lbl_date_Click";
RDebugUtils.currentLine=61014017;
 //BA.debugLineNum = 61014017;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=61014020;
 //BA.debugLineNum = 61014020;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date.Text.SubStri";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=61014021;
 //BA.debugLineNum = 61014021;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date.Text.SubStrin";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=61014022;
 //BA.debugLineNum = 61014022;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=61014026;
 //BA.debugLineNum = 61014026;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_go_agsatpage_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_go_agsatpage_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_go_agsatpage_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
RDebugUtils.currentLine=61341696;
 //BA.debugLineNum = 61341696;BA.debugLine="Private Sub lbl_go_agsatPage_Click";
RDebugUtils.currentLine=61341697;
 //BA.debugLineNum = 61341697;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=61341698;
 //BA.debugLineNum = 61341698;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=61341699;
 //BA.debugLineNum = 61341699;BA.debugLine="Main.current_idvam=b.Tag";
mostCurrent._main._current_idvam /*String*/  = BA.ObjectToString(_b.getTag());
RDebugUtils.currentLine=61341700;
 //BA.debugLineNum = 61341700;BA.debugLine="StartActivity(gestha_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._gestha_activity.getObject()));
RDebugUtils.currentLine=61341702;
 //BA.debugLineNum = 61341702;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_info_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_info_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_info_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _str_show = null;
RDebugUtils.currentLine=61669376;
 //BA.debugLineNum = 61669376;BA.debugLine="Private Sub lbl_info_Click";
RDebugUtils.currentLine=61669378;
 //BA.debugLineNum = 61669378;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=61669379;
 //BA.debugLineNum = 61669379;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=61669381;
 //BA.debugLineNum = 61669381;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=61669382;
 //BA.debugLineNum = 61669382;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_vam WHERE id="+BA.ObjectToString(_b.getTag()))));
RDebugUtils.currentLine=61669383;
 //BA.debugLineNum = 61669383;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=61669384;
 //BA.debugLineNum = 61669384;BA.debugLine="Main.current_idvam= dbCode.res.GetString(\"idvam\")";
mostCurrent._main._current_idvam /*String*/  = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("idvam");
RDebugUtils.currentLine=61669387;
 //BA.debugLineNum = 61669387;BA.debugLine="pan_all_show_info.Visible=True";
mostCurrent._pan_all_show_info.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=61669391;
 //BA.debugLineNum = 61669391;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=61669392;
 //BA.debugLineNum = 61669392;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
RDebugUtils.currentLine=61669394;
 //BA.debugLineNum = 61669394;BA.debugLine="str_show.Append(\"<html dir='rtl'><meta charset='U";
_str_show.Append("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>");
RDebugUtils.currentLine=61669396;
 //BA.debugLineNum = 61669396;BA.debugLine="str_show.Append(\"<h5 align='center'>عنوان وام <br";
_str_show.Append("<h5 align='center'>عنوان وام <br>");
RDebugUtils.currentLine=61669397;
 //BA.debugLineNum = 61669397;BA.debugLine="str_show.Append(dbCode.res.GetString(\"onvan\"))";
_str_show.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan"));
RDebugUtils.currentLine=61669398;
 //BA.debugLineNum = 61669398;BA.debugLine="str_show.Append(\"</h5>\")";
_str_show.Append("</h5>");
RDebugUtils.currentLine=61669400;
 //BA.debugLineNum = 61669400;BA.debugLine="str_show.Append(\"<div style=' border: 2px solid g";
_str_show.Append("<div style=' border: 2px solid gray;  padding: 10px; border-radius: 20px;'>");
RDebugUtils.currentLine=61669401;
 //BA.debugLineNum = 61669401;BA.debugLine="str_show.Append(\" مبلغ وام : \"&myfunc.show_num_po";
_str_show.Append(" مبلغ وام : "+mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablag"))))).Append("<br>");
RDebugUtils.currentLine=61669402;
 //BA.debugLineNum = 61669402;BA.debugLine="str_show.Append(\"نرخ وام % : \"&(dbCode.res.GetStr";
_str_show.Append("نرخ وام % : "+(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("rate"))).Append("<br>");
RDebugUtils.currentLine=61669403;
 //BA.debugLineNum = 61669403;BA.debugLine="str_show.Append(\" تعداد اقساط : \"&(dbCode.res.Get";
_str_show.Append(" تعداد اقساط : "+(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("count"))).Append("<br>");
RDebugUtils.currentLine=61669404;
 //BA.debugLineNum = 61669404;BA.debugLine="str_show.Append(\" ماه شروع : \"&(dbCode.res.GetStr";
_str_show.Append(" ماه شروع : "+(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date"))).Append("<br>");
RDebugUtils.currentLine=61669405;
 //BA.debugLineNum = 61669405;BA.debugLine="str_show.Append(\" توضیحات : \"&(dbCode.res.GetStri";
_str_show.Append(" توضیحات : "+(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat"))).Append("<br>");
RDebugUtils.currentLine=61669406;
 //BA.debugLineNum = 61669406;BA.debugLine="str_show.Append(\"</div>\").Append(\"<br>\")";
_str_show.Append("</div>").Append("<br>");
RDebugUtils.currentLine=61669408;
 //BA.debugLineNum = 61669408;BA.debugLine="str_show.Append(\"<div style=' border: 3px solid g";
_str_show.Append("<div style=' border: 3px solid green;  padding: 10px; border-radius: 20px;'>");
RDebugUtils.currentLine=61669409;
 //BA.debugLineNum = 61669409;BA.debugLine="str_show.Append(\" کل مبلغ بازپرداخت  : \"&myfunc.s";
_str_show.Append(" کل مبلغ بازپرداخت  : "+mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("bazpardakht"))))).Append("<br>");
RDebugUtils.currentLine=61669410;
 //BA.debugLineNum = 61669410;BA.debugLine="str_show.Append(\" مبلغ هر قسط : <mark> \"&myfunc.s";
_str_show.Append(" مبلغ هر قسط : <mark> "+mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("harghest"))))+"</mark>");
RDebugUtils.currentLine=61669411;
 //BA.debugLineNum = 61669411;BA.debugLine="str_show.Append(\"</div>\")";
_str_show.Append("</div>");
RDebugUtils.currentLine=61669413;
 //BA.debugLineNum = 61669413;BA.debugLine="str_show.Append(\"</body></html>\")";
_str_show.Append("</body></html>");
RDebugUtils.currentLine=61669416;
 //BA.debugLineNum = 61669416;BA.debugLine="wb_show_result.LoadHtml(str_show.ToString)";
mostCurrent._wb_show_result.LoadHtml(_str_show.ToString());
RDebugUtils.currentLine=61669419;
 //BA.debugLineNum = 61669419;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list2_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_remove_from_list2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_remove_from_list2_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
String _get_idvam = "";
int _result = 0;
RDebugUtils.currentLine=60162048;
 //BA.debugLineNum = 60162048;BA.debugLine="Private Sub lbl_remove_from_list2_Click";
RDebugUtils.currentLine=60162050;
 //BA.debugLineNum = 60162050;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=60162051;
 //BA.debugLineNum = 60162051;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=60162053;
 //BA.debugLineNum = 60162053;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=60162054;
 //BA.debugLineNum = 60162054;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_vam WHERE id="+BA.ObjectToString(_b.getTag()))));
RDebugUtils.currentLine=60162055;
 //BA.debugLineNum = 60162055;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=60162056;
 //BA.debugLineNum = 60162056;BA.debugLine="Dim  get_idvam As String= dbCode.res.GetString(\"i";
_get_idvam = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("idvam");
RDebugUtils.currentLine=60162058;
 //BA.debugLineNum = 60162058;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=60162059;
 //BA.debugLineNum = 60162059;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=60162060;
 //BA.debugLineNum = 60162060;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=60162062;
 //BA.debugLineNum = 60162062;BA.debugLine="If (dbCode.delete_vam(b.Tag))Then";
if ((mostCurrent._dbcode._delete_vam /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=60162064;
 //BA.debugLineNum = 60162064;BA.debugLine="dbCode.delete_ghestha(get_idvam)";
mostCurrent._dbcode._delete_ghestha /*boolean*/ (mostCurrent.activityBA,_get_idvam);
RDebugUtils.currentLine=60162065;
 //BA.debugLineNum = 60162065;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=60162068;
 //BA.debugLineNum = 60162068;BA.debugLine="fill_list_vam";
_fill_list_vam();
 };
 };
RDebugUtils.currentLine=60162077;
 //BA.debugLineNum = 60162077;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_click", null));}
String _random_idvam = "";
String _shomare_gest = "";
String _date_gest = "";
int _date_year = 0;
int _date_moon = 0;
int _i = 0;
RDebugUtils.currentLine=61079552;
 //BA.debugLineNum = 61079552;BA.debugLine="Private Sub lbl_save_Click";
RDebugUtils.currentLine=61079553;
 //BA.debugLineNum = 61079553;BA.debugLine="If(et_onvan.Text=\"\")Then";
if (((mostCurrent._et_onvan.getText()).equals(""))) { 
RDebugUtils.currentLine=61079554;
 //BA.debugLineNum = 61079554;BA.debugLine="ToastMessageShow(\" عنوان وام را وارد کنید\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" عنوان وام را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=61079556;
 //BA.debugLineNum = 61079556;BA.debugLine="else If(et_mablagh_vam.Text=\"\" Or et_mablagh_vam.";
if (((mostCurrent._et_mablagh_vam.getText()).equals("") || (mostCurrent._et_mablagh_vam.getText()).equals(BA.NumberToString(0)))) { 
RDebugUtils.currentLine=61079557;
 //BA.debugLineNum = 61079557;BA.debugLine="ToastMessageShow(\"مبلغ وام را وارد کنید\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("مبلغ وام را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=61079559;
 //BA.debugLineNum = 61079559;BA.debugLine="else If(et_nerkh_vam.Text=\"\" Or et_nerkh_vam.Text";
if (((mostCurrent._et_nerkh_vam.getText()).equals("") || (mostCurrent._et_nerkh_vam.getText()).equals(BA.NumberToString(0)))) { 
RDebugUtils.currentLine=61079560;
 //BA.debugLineNum = 61079560;BA.debugLine="ToastMessageShow(\"نرخ وام را وارد کنید\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("نرخ وام را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=61079562;
 //BA.debugLineNum = 61079562;BA.debugLine="else If(et_tedad_gest.Text=\"\" Or et_tedad_gest.Te";
if (((mostCurrent._et_tedad_gest.getText()).equals("") || (mostCurrent._et_tedad_gest.getText()).equals(BA.NumberToString(0)))) { 
RDebugUtils.currentLine=61079563;
 //BA.debugLineNum = 61079563;BA.debugLine="ToastMessageShow(\"تعداد قسط ها را وارد کنید\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تعداد قسط ها را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=61079566;
 //BA.debugLineNum = 61079566;BA.debugLine="Dim random_idvam As String=myfunc.random_id(5)";
_random_idvam = mostCurrent._myfunc._random_id /*String*/ (mostCurrent.activityBA,(int) (5));
RDebugUtils.currentLine=61079568;
 //BA.debugLineNum = 61079568;BA.debugLine="dbCode.add_vam(random_idvam,et_onvan.Text,et_mab";
mostCurrent._dbcode._add_vam /*boolean*/ (mostCurrent.activityBA,_random_idvam,mostCurrent._et_onvan.getText(),BA.ObjectToString(mostCurrent._et_mablagh_vam.getTag()),mostCurrent._et_tedad_gest.getText(),mostCurrent._et_nerkh_vam.getText(),BA.NumberToString(1),mostCurrent._lbl_date.getText(),BA.ObjectToString(mostCurrent._lbl_kol_bazpardakht.getTag()),BA.ObjectToString(mostCurrent._lbl_hargest.getTag()),mostCurrent._et_tozih.getText(),(int) (0));
RDebugUtils.currentLine=61079569;
 //BA.debugLineNum = 61079569;BA.debugLine="Dim shomare_gest As String=\"\"";
_shomare_gest = "";
RDebugUtils.currentLine=61079570;
 //BA.debugLineNum = 61079570;BA.debugLine="Dim date_gest As String= lbl_date.Text";
_date_gest = mostCurrent._lbl_date.getText();
RDebugUtils.currentLine=61079571;
 //BA.debugLineNum = 61079571;BA.debugLine="Dim date_year As Int=lbl_date.Text.SubString2(0,";
_date_year = (int)(Double.parseDouble(mostCurrent._lbl_date.getText().substring((int) (0),(int) (4))));
RDebugUtils.currentLine=61079572;
 //BA.debugLineNum = 61079572;BA.debugLine="Dim date_moon As Int=lbl_date.Text.SubString2(5,";
_date_moon = (int)(Double.parseDouble(mostCurrent._lbl_date.getText().substring((int) (5),(int) (7))));
RDebugUtils.currentLine=61079574;
 //BA.debugLineNum = 61079574;BA.debugLine="For i=1 To et_tedad_gest.Text";
{
final int step16 = 1;
final int limit16 = (int)(Double.parseDouble(mostCurrent._et_tedad_gest.getText()));
_i = (int) (1) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
RDebugUtils.currentLine=61079577;
 //BA.debugLineNum = 61079577;BA.debugLine="shomare_gest = \"شماره قسط :\"& (i)";
_shomare_gest = "شماره قسط :"+BA.NumberToString((_i));
RDebugUtils.currentLine=61079578;
 //BA.debugLineNum = 61079578;BA.debugLine="dbCode.add_gest(random_idvam,date_gest,lbl_harG";
mostCurrent._dbcode._add_gest /*boolean*/ (mostCurrent.activityBA,_random_idvam,_date_gest,BA.ObjectToString(mostCurrent._lbl_hargest.getTag()),mostCurrent._et_onvan.getText(),(int) (0));
RDebugUtils.currentLine=61079581;
 //BA.debugLineNum = 61079581;BA.debugLine="date_moon=date_moon+1";
_date_moon = (int) (_date_moon+1);
RDebugUtils.currentLine=61079582;
 //BA.debugLineNum = 61079582;BA.debugLine="If(date_moon>12)Then";
if ((_date_moon>12)) { 
RDebugUtils.currentLine=61079583;
 //BA.debugLineNum = 61079583;BA.debugLine="date_moon=1";
_date_moon = (int) (1);
RDebugUtils.currentLine=61079584;
 //BA.debugLineNum = 61079584;BA.debugLine="date_year=date_year+1";
_date_year = (int) (_date_year+1);
 };
RDebugUtils.currentLine=61079587;
 //BA.debugLineNum = 61079587;BA.debugLine="date_gest=myfunc.convert_adad( date_year)&\"/\"&m";
_date_gest = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_date_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_date_moon);
 }
};
RDebugUtils.currentLine=61079591;
 //BA.debugLineNum = 61079591;BA.debugLine="fill_list_vam";
_fill_list_vam();
RDebugUtils.currentLine=61079592;
 //BA.debugLineNum = 61079592;BA.debugLine="pan_all_add.Visible=False";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }}}}
;
RDebugUtils.currentLine=61079596;
 //BA.debugLineNum = 61079596;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_picker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_picker_click", null));}
RDebugUtils.currentLine=60424192;
 //BA.debugLineNum = 60424192;BA.debugLine="Private Sub lbl_save_picker_Click";
RDebugUtils.currentLine=60424193;
 //BA.debugLineNum = 60424193;BA.debugLine="lbl_date.Text=pik_year1.Text&\"/\"&myfunc.convert_a";
mostCurrent._lbl_date.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))));
RDebugUtils.currentLine=60424194;
 //BA.debugLineNum = 60424194;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=60424195;
 //BA.debugLineNum = 60424195;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_add_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_add_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_add_click", null));}
RDebugUtils.currentLine=60948480;
 //BA.debugLineNum = 60948480;BA.debugLine="Private Sub pan_all_add_Click";
RDebugUtils.currentLine=60948481;
 //BA.debugLineNum = 60948481;BA.debugLine="pan_all_add.Visible=False";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=60948482;
 //BA.debugLineNum = 60948482;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_set_date_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_set_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_set_date_click", null));}
RDebugUtils.currentLine=60293120;
 //BA.debugLineNum = 60293120;BA.debugLine="Private Sub pan_all_set_date_Click";
RDebugUtils.currentLine=60293121;
 //BA.debugLineNum = 60293121;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=60293122;
 //BA.debugLineNum = 60293122;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_show_info_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_show_info_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_show_info_click", null));}
RDebugUtils.currentLine=61407232;
 //BA.debugLineNum = 61407232;BA.debugLine="Private Sub pan_all_show_info_Click";
RDebugUtils.currentLine=61407233;
 //BA.debugLineNum = 61407233;BA.debugLine="pan_all_show_info.Visible=False";
mostCurrent._pan_all_show_info.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=61407234;
 //BA.debugLineNum = 61407234;BA.debugLine="End Sub";
return "";
}
public static String  _panel2_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel2_click", null));}
RDebugUtils.currentLine=61472768;
 //BA.debugLineNum = 61472768;BA.debugLine="Private Sub Panel2_Click";
RDebugUtils.currentLine=61472770;
 //BA.debugLineNum = 61472770;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel4_click", null));}
RDebugUtils.currentLine=60227584;
 //BA.debugLineNum = 60227584;BA.debugLine="Private Sub Panel4_Click";
RDebugUtils.currentLine=60227586;
 //BA.debugLineNum = 60227586;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=60620800;
 //BA.debugLineNum = 60620800;BA.debugLine="Private Sub pik_moon_bala1_Click";
RDebugUtils.currentLine=60620801;
 //BA.debugLineNum = 60620801;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=60620802;
 //BA.debugLineNum = 60620802;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
RDebugUtils.currentLine=60620804;
 //BA.debugLineNum = 60620804;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=60620805;
 //BA.debugLineNum = 60620805;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=60620807;
 //BA.debugLineNum = 60620807;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=60620808;
 //BA.debugLineNum = 60620808;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=60620810;
 //BA.debugLineNum = 60620810;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=60620812;
 //BA.debugLineNum = 60620812;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=60686336;
 //BA.debugLineNum = 60686336;BA.debugLine="Private Sub pik_moon_paeen1_Click";
RDebugUtils.currentLine=60686337;
 //BA.debugLineNum = 60686337;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=60686338;
 //BA.debugLineNum = 60686338;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
RDebugUtils.currentLine=60686340;
 //BA.debugLineNum = 60686340;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=60686341;
 //BA.debugLineNum = 60686341;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=60686343;
 //BA.debugLineNum = 60686343;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=60686344;
 //BA.debugLineNum = 60686344;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=60686346;
 //BA.debugLineNum = 60686346;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
RDebugUtils.currentLine=60686348;
 //BA.debugLineNum = 60686348;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_moon1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_moon1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=60489728;
 //BA.debugLineNum = 60489728;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
RDebugUtils.currentLine=60489729;
 //BA.debugLineNum = 60489729;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=60489730;
 //BA.debugLineNum = 60489730;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=60489731;
 //BA.debugLineNum = 60489731;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=60489734;
 //BA.debugLineNum = 60489734;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=60489736;
 //BA.debugLineNum = 60489736;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=60489737;
 //BA.debugLineNum = 60489737;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
RDebugUtils.currentLine=60489738;
 //BA.debugLineNum = 60489738;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=60489739;
 //BA.debugLineNum = 60489739;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=60489741;
 //BA.debugLineNum = 60489741;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=60489742;
 //BA.debugLineNum = 60489742;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
RDebugUtils.currentLine=60489743;
 //BA.debugLineNum = 60489743;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=60489744;
 //BA.debugLineNum = 60489744;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=60489747;
 //BA.debugLineNum = 60489747;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=60489748;
 //BA.debugLineNum = 60489748;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=60489750;
 //BA.debugLineNum = 60489750;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=60489751;
 //BA.debugLineNum = 60489751;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=60489753;
 //BA.debugLineNum = 60489753;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
RDebugUtils.currentLine=60489756;
 //BA.debugLineNum = 60489756;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_year1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_year1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=60555264;
 //BA.debugLineNum = 60555264;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
RDebugUtils.currentLine=60555265;
 //BA.debugLineNum = 60555265;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=60555266;
 //BA.debugLineNum = 60555266;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=60555267;
 //BA.debugLineNum = 60555267;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=60555270;
 //BA.debugLineNum = 60555270;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=60555272;
 //BA.debugLineNum = 60555272;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=60555273;
 //BA.debugLineNum = 60555273;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
RDebugUtils.currentLine=60555274;
 //BA.debugLineNum = 60555274;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=60555275;
 //BA.debugLineNum = 60555275;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=60555277;
 //BA.debugLineNum = 60555277;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=60555278;
 //BA.debugLineNum = 60555278;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
RDebugUtils.currentLine=60555279;
 //BA.debugLineNum = 60555279;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=60555280;
 //BA.debugLineNum = 60555280;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=60555283;
 //BA.debugLineNum = 60555283;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=60555284;
 //BA.debugLineNum = 60555284;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=60555286;
 //BA.debugLineNum = 60555286;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=60555287;
 //BA.debugLineNum = 60555287;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
RDebugUtils.currentLine=60555292;
 //BA.debugLineNum = 60555292;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=60751872;
 //BA.debugLineNum = 60751872;BA.debugLine="Private Sub pik_year_bala1_Click";
RDebugUtils.currentLine=60751873;
 //BA.debugLineNum = 60751873;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=60751874;
 //BA.debugLineNum = 60751874;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=60751876;
 //BA.debugLineNum = 60751876;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=60751877;
 //BA.debugLineNum = 60751877;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=60751879;
 //BA.debugLineNum = 60751879;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=60751880;
 //BA.debugLineNum = 60751880;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=60751883;
 //BA.debugLineNum = 60751883;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=60817408;
 //BA.debugLineNum = 60817408;BA.debugLine="Private Sub pik_year_paeen1_Click";
RDebugUtils.currentLine=60817409;
 //BA.debugLineNum = 60817409;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=60817410;
 //BA.debugLineNum = 60817410;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=60817412;
 //BA.debugLineNum = 60817412;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=60817413;
 //BA.debugLineNum = 60817413;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=60817415;
 //BA.debugLineNum = 60817415;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=60817416;
 //BA.debugLineNum = 60817416;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=60817419;
 //BA.debugLineNum = 60817419;BA.debugLine="End Sub";
return "";
}
}