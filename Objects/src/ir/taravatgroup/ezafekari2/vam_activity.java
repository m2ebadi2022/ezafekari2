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
RDebugUtils.currentLine=64225280;
 //BA.debugLineNum = 64225280;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=64225282;
 //BA.debugLineNum = 64225282;BA.debugLine="Activity.LoadLayout(\"vam_layout\")";
mostCurrent._activity.LoadLayout("vam_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=64225286;
 //BA.debugLineNum = 64225286;BA.debugLine="pan_hed_vam.Color=Main.color4";
mostCurrent._pan_hed_vam.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=64225287;
 //BA.debugLineNum = 64225287;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=64225291;
 //BA.debugLineNum = 64225291;BA.debugLine="fill_list_vam";
_fill_list_vam();
RDebugUtils.currentLine=64225294;
 //BA.debugLineNum = 64225294;BA.debugLine="moon_dataPik.Initialize";
mostCurrent._moon_datapik.Initialize();
RDebugUtils.currentLine=64225295;
 //BA.debugLineNum = 64225295;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
mostCurrent._moon_datapik.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"}));
RDebugUtils.currentLine=64225298;
 //BA.debugLineNum = 64225298;BA.debugLine="lbl_date.Text=Main.persianDate.PersianYear&\"/\"&my";
mostCurrent._lbl_date.setText(BA.ObjectToCharSequence(BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianMonth())));
RDebugUtils.currentLine=64225301;
 //BA.debugLineNum = 64225301;BA.debugLine="wb_show_result.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._wb_show_result.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=64225302;
 //BA.debugLineNum = 64225302;BA.debugLine="wb_show_result.ZoomEnabled=False";
mostCurrent._wb_show_result.setZoomEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=64225304;
 //BA.debugLineNum = 64225304;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=64421891;
 //BA.debugLineNum = 64421891;BA.debugLine="cust_LV_vam.Clear";
parent.mostCurrent._cust_lv_vam._clear();
RDebugUtils.currentLine=64421894;
 //BA.debugLineNum = 64421894;BA.debugLine="dbCode.connect_db";
parent.mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=64421895;
 //BA.debugLineNum = 64421895;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(parent.mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_vam ORDER BY  date DESC;")));
RDebugUtils.currentLine=64421898;
 //BA.debugLineNum = 64421898;BA.debugLine="Do While dbCode.res.NextRow";
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
RDebugUtils.currentLine=64421903;
 //BA.debugLineNum = 64421903;BA.debugLine="p = xui2.CreatePanel(\"p\")";
parent.mostCurrent._p = parent.mostCurrent._xui2.CreatePanel(processBA,"p");
RDebugUtils.currentLine=64421904;
 //BA.debugLineNum = 64421904;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 98%x, 165dip)";
parent.mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (98),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (165)));
RDebugUtils.currentLine=64421905;
 //BA.debugLineNum = 64421905;BA.debugLine="p.LoadLayout(\"item_list_vam\")";
parent.mostCurrent._p.LoadLayout("item_list_vam",mostCurrent.activityBA);
RDebugUtils.currentLine=64421907;
 //BA.debugLineNum = 64421907;BA.debugLine="cust_LV_vam.Add(p,dbCode.res.GetString(\"id\"))";
parent.mostCurrent._cust_lv_vam._add(parent.mostCurrent._p,(Object)(parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=64421909;
 //BA.debugLineNum = 64421909;BA.debugLine="lbl_onvan2.Text=dbCode.res.GetString(\"onvan\")";
parent.mostCurrent._lbl_onvan2.setText(BA.ObjectToCharSequence(parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan")));
RDebugUtils.currentLine=64421913;
 //BA.debugLineNum = 64421913;BA.debugLine="lbl_mablagh2.Tag=dbCode.res.GetString(\"mablag\")";
parent.mostCurrent._lbl_mablagh2.setTag((Object)(parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablag")));
RDebugUtils.currentLine=64421914;
 //BA.debugLineNum = 64421914;BA.debugLine="lbl_mablagh2.Text=\" مبلغ وام :\" & myfunc.show_nu";
parent.mostCurrent._lbl_mablagh2.setText(BA.ObjectToCharSequence(" مبلغ وام :"+parent.mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(parent.mostCurrent._lbl_mablagh2.getTag())))));
RDebugUtils.currentLine=64421916;
 //BA.debugLineNum = 64421916;BA.debugLine="lbl_tozih2.Text=dbCode.res.GetString(\"tozihat\")";
parent.mostCurrent._lbl_tozih2.setText(BA.ObjectToCharSequence(parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat")));
RDebugUtils.currentLine=64421918;
 //BA.debugLineNum = 64421918;BA.debugLine="lbl_icon2.Text=Chr(0xF274)  'def";
parent.mostCurrent._lbl_icon2.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf274))));
RDebugUtils.currentLine=64421919;
 //BA.debugLineNum = 64421919;BA.debugLine="lbl_icon2.Color=0xFF00A3FF";
parent.mostCurrent._lbl_icon2.setColor(((int)0xff00a3ff));
RDebugUtils.currentLine=64421921;
 //BA.debugLineNum = 64421921;BA.debugLine="lbl_remove_from_list2.tag=dbCode.res.GetString(\"";
parent.mostCurrent._lbl_remove_from_list2.setTag((Object)(parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=64421922;
 //BA.debugLineNum = 64421922;BA.debugLine="lbl_info.tag=dbCode.res.GetString(\"id\")";
parent.mostCurrent._lbl_info.setTag((Object)(parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("id")));
RDebugUtils.currentLine=64421924;
 //BA.debugLineNum = 64421924;BA.debugLine="lbl_go_agsatPage.Tag=dbCode.res.GetString(\"idvam";
parent.mostCurrent._lbl_go_agsatpage.setTag((Object)(parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("idvam")));
RDebugUtils.currentLine=64421928;
 //BA.debugLineNum = 64421928;BA.debugLine="pan_tools.SetLayoutAnimated(200,0,pan_tools.Top,";
parent.mostCurrent._pan_tools.SetLayoutAnimated((int) (200),(int) (0),parent.mostCurrent._pan_tools.getTop(),parent.mostCurrent._pan_tools.getWidth(),parent.mostCurrent._pan_tools.getHeight());
RDebugUtils.currentLine=64421930;
 //BA.debugLineNum = 64421930;BA.debugLine="Sleep(10)";
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
RDebugUtils.currentLine=64421932;
 //BA.debugLineNum = 64421932;BA.debugLine="dbCode.res.Close";
parent.mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=64421933;
 //BA.debugLineNum = 64421933;BA.debugLine="dbCode.sql.Close";
parent.mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=64421935;
 //BA.debugLineNum = 64421935;BA.debugLine="If(cust_LV_vam.LastVisibleIndex<5)Then";
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
RDebugUtils.currentLine=64421936;
 //BA.debugLineNum = 64421936;BA.debugLine="p = xui2.CreatePanel(\"p\")";
parent.mostCurrent._p = parent.mostCurrent._xui2.CreatePanel(processBA,"p");
RDebugUtils.currentLine=64421937;
 //BA.debugLineNum = 64421937;BA.debugLine="Select cust_LV_vam.LastVisibleIndex";
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
RDebugUtils.currentLine=64421939;
 //BA.debugLineNum = 64421939;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
parent.mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),(int) ((380-100)));
 if (true) break;

case 12:
//C
this.state = 21;
RDebugUtils.currentLine=64421941;
 //BA.debugLineNum = 64421941;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
parent.mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
 if (true) break;

case 14:
//C
this.state = 21;
RDebugUtils.currentLine=64421943;
 //BA.debugLineNum = 64421943;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
parent.mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 if (true) break;

case 16:
//C
this.state = 21;
RDebugUtils.currentLine=64421945;
 //BA.debugLineNum = 64421945;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
parent.mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 if (true) break;

case 18:
//C
this.state = 21;
RDebugUtils.currentLine=64421947;
 //BA.debugLineNum = 64421947;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
parent.mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 if (true) break;

case 20:
//C
this.state = 21;
RDebugUtils.currentLine=64421949;
 //BA.debugLineNum = 64421949;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
parent.mostCurrent._p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 if (true) break;

case 21:
//C
this.state = 22;
;
RDebugUtils.currentLine=64421951;
 //BA.debugLineNum = 64421951;BA.debugLine="cust_LV_vam.Add(p,\"\")";
parent.mostCurrent._cust_lv_vam._add(parent.mostCurrent._p,(Object)(""));
 if (true) break;

case 22:
//C
this.state = -1;
;
RDebugUtils.currentLine=64421955;
 //BA.debugLineNum = 64421955;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=64552960;
 //BA.debugLineNum = 64552960;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=64552961;
 //BA.debugLineNum = 64552961;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=64552962;
 //BA.debugLineNum = 64552962;BA.debugLine="If(pan_all_set_date.Visible=True)Then";
if ((mostCurrent._pan_all_set_date.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=64552963;
 //BA.debugLineNum = 64552963;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=64552964;
 //BA.debugLineNum = 64552964;BA.debugLine="Else If (pan_all_add.Visible=True)Then";
if ((mostCurrent._pan_all_add.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=64552965;
 //BA.debugLineNum = 64552965;BA.debugLine="pan_all_add.Visible=False";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=64552967;
 //BA.debugLineNum = 64552967;BA.debugLine="Else If (pan_all_show_info.Visible=True)Then";
if ((mostCurrent._pan_all_show_info.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=64552968;
 //BA.debugLineNum = 64552968;BA.debugLine="pan_all_show_info.Visible=False";
mostCurrent._pan_all_show_info.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=64552970;
 //BA.debugLineNum = 64552970;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 }}}
;
RDebugUtils.currentLine=64552973;
 //BA.debugLineNum = 64552973;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=64552975;
 //BA.debugLineNum = 64552975;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=64552977;
 //BA.debugLineNum = 64552977;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=64487424;
 //BA.debugLineNum = 64487424;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=64487425;
 //BA.debugLineNum = 64487425;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=64487426;
 //BA.debugLineNum = 64487426;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="vam_activity";
RDebugUtils.currentLine=64356352;
 //BA.debugLineNum = 64356352;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=64356354;
 //BA.debugLineNum = 64356354;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=64290816;
 //BA.debugLineNum = 64290816;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=64290818;
 //BA.debugLineNum = 64290818;BA.debugLine="End Sub";
return "";
}
public static String  _et_mablagh_vam_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_mablagh_vam_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_mablagh_vam_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=64815104;
 //BA.debugLineNum = 64815104;BA.debugLine="Private Sub et_mablagh_vam_TextChanged (Old As Str";
RDebugUtils.currentLine=64815105;
 //BA.debugLineNum = 64815105;BA.debugLine="et_mablagh_vam.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_mablagh_vam.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=64815106;
 //BA.debugLineNum = 64815106;BA.debugLine="myfunc.change_formater(Old,New,et_mablagh_vam)";
mostCurrent._myfunc._change_formater /*String*/ (mostCurrent.activityBA,_old,_new,mostCurrent._et_mablagh_vam);
RDebugUtils.currentLine=64815107;
 //BA.debugLineNum = 64815107;BA.debugLine="mohasebe";
_mohasebe();
RDebugUtils.currentLine=64815108;
 //BA.debugLineNum = 64815108;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=65601536;
 //BA.debugLineNum = 65601536;BA.debugLine="Sub mohasebe";
RDebugUtils.currentLine=65601537;
 //BA.debugLineNum = 65601537;BA.debugLine="If(et_mablagh_vam.Text=\"\" Or et_nerkh_vam.Text=\"\"";
if (((mostCurrent._et_mablagh_vam.getText()).equals("") || (mostCurrent._et_nerkh_vam.getText()).equals("") || (mostCurrent._et_tedad_gest.getText()).equals(""))) { 
 }else 
{RDebugUtils.currentLine=65601539;
 //BA.debugLineNum = 65601539;BA.debugLine="Else If (et_mablagh_vam.Text<>\"\" And et_nerkh_vam";
if (((mostCurrent._et_mablagh_vam.getText()).equals("") == false && (mostCurrent._et_nerkh_vam.getText()).equals(BA.NumberToString(0)) && (mostCurrent._et_tedad_gest.getText()).equals("") == false)) { 
RDebugUtils.currentLine=65601543;
 //BA.debugLineNum = 65601543;BA.debugLine="lbl_harGest.Tag=Round(et_mablagh_vam.Tag/et_teda";
mostCurrent._lbl_hargest.setTag((Object)(anywheresoftware.b4a.keywords.Common.Round((double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag()))/(double)(double)(Double.parseDouble(mostCurrent._et_tedad_gest.getText())))));
RDebugUtils.currentLine=65601544;
 //BA.debugLineNum = 65601544;BA.debugLine="lbl_kol_bazPardakht.Tag=Round(et_mablagh_vam.Tag";
mostCurrent._lbl_kol_bazpardakht.setTag((Object)(anywheresoftware.b4a.keywords.Common.Round((double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag())))));
RDebugUtils.currentLine=65601546;
 //BA.debugLineNum = 65601546;BA.debugLine="lbl_harGest.Text=myfunc.show_num_pool(lbl_harGes";
mostCurrent._lbl_hargest.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_hargest.getTag())))+" تومان "));
RDebugUtils.currentLine=65601547;
 //BA.debugLineNum = 65601547;BA.debugLine="lbl_kol_bazPardakht.Text=myfunc.show_num_pool(lb";
mostCurrent._lbl_kol_bazpardakht.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_kol_bazpardakht.getTag())))+" تومان "));
 }else {
RDebugUtils.currentLine=65601555;
 //BA.debugLineNum = 65601555;BA.debugLine="Dim eb1 As Double=Power( (1+(et_nerkh_vam.Text/1";
_eb1 = anywheresoftware.b4a.keywords.Common.Power((1+((double)(Double.parseDouble(mostCurrent._et_nerkh_vam.getText()))/(double)1200)),(double)(Double.parseDouble(mostCurrent._et_tedad_gest.getText())));
RDebugUtils.currentLine=65601556;
 //BA.debugLineNum = 65601556;BA.debugLine="Dim sorat As Double=et_mablagh_vam.Tag*(et_nerkh";
_sorat = (double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag()))*((double)(Double.parseDouble(mostCurrent._et_nerkh_vam.getText()))/(double)1200)*_eb1;
RDebugUtils.currentLine=65601557;
 //BA.debugLineNum = 65601557;BA.debugLine="Dim makhraj As Double=eb1-1";
_makhraj = _eb1-1;
RDebugUtils.currentLine=65601559;
 //BA.debugLineNum = 65601559;BA.debugLine="Dim gest As Double=sorat/makhraj";
_gest = _sorat/(double)_makhraj;
RDebugUtils.currentLine=65601561;
 //BA.debugLineNum = 65601561;BA.debugLine="Dim sod As Double=(gest*et_tedad_gest.Text)-et_m";
_sod = (_gest*(double)(Double.parseDouble(mostCurrent._et_tedad_gest.getText())))-(double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag()));
RDebugUtils.currentLine=65601564;
 //BA.debugLineNum = 65601564;BA.debugLine="lbl_harGest.Tag=Round(gest)";
mostCurrent._lbl_hargest.setTag((Object)(anywheresoftware.b4a.keywords.Common.Round(_gest)));
RDebugUtils.currentLine=65601565;
 //BA.debugLineNum = 65601565;BA.debugLine="lbl_kol_bazPardakht.Tag=Round(et_mablagh_vam.Tag";
mostCurrent._lbl_kol_bazpardakht.setTag((Object)(anywheresoftware.b4a.keywords.Common.Round((double)(BA.ObjectToNumber(mostCurrent._et_mablagh_vam.getTag()))+_sod)));
RDebugUtils.currentLine=65601567;
 //BA.debugLineNum = 65601567;BA.debugLine="lbl_harGest.Text=myfunc.show_num_pool(lbl_harGes";
mostCurrent._lbl_hargest.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_hargest.getTag())))+" تومان "));
RDebugUtils.currentLine=65601568;
 //BA.debugLineNum = 65601568;BA.debugLine="lbl_kol_bazPardakht.Text=myfunc.show_num_pool(lb";
mostCurrent._lbl_kol_bazpardakht.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._lbl_kol_bazpardakht.getTag())))+" تومان "));
 }}
;
RDebugUtils.currentLine=65601575;
 //BA.debugLineNum = 65601575;BA.debugLine="End Sub";
return "";
}
public static String  _et_nerkh_vam_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_nerkh_vam_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_nerkh_vam_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=65667072;
 //BA.debugLineNum = 65667072;BA.debugLine="Private Sub et_nerkh_vam_TextChanged (Old As Strin";
RDebugUtils.currentLine=65667073;
 //BA.debugLineNum = 65667073;BA.debugLine="mohasebe";
_mohasebe();
RDebugUtils.currentLine=65667074;
 //BA.debugLineNum = 65667074;BA.debugLine="End Sub";
return "";
}
public static String  _et_tedad_gest_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_tedad_gest_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_tedad_gest_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=65732608;
 //BA.debugLineNum = 65732608;BA.debugLine="Private Sub et_tedad_gest_TextChanged (Old As Stri";
RDebugUtils.currentLine=65732609;
 //BA.debugLineNum = 65732609;BA.debugLine="mohasebe";
_mohasebe();
RDebugUtils.currentLine=65732610;
 //BA.debugLineNum = 65732610;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_add_vam_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_add_vam_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_add_vam_click", null));}
RDebugUtils.currentLine=65339392;
 //BA.debugLineNum = 65339392;BA.debugLine="Private Sub lbl_add_vam_Click";
RDebugUtils.currentLine=65339393;
 //BA.debugLineNum = 65339393;BA.debugLine="et_onvan.Text=\"\"";
mostCurrent._et_onvan.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=65339394;
 //BA.debugLineNum = 65339394;BA.debugLine="et_mablagh_vam.Text=\"\"";
mostCurrent._et_mablagh_vam.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=65339395;
 //BA.debugLineNum = 65339395;BA.debugLine="et_mablagh_vam.tag=\"\"";
mostCurrent._et_mablagh_vam.setTag((Object)(""));
RDebugUtils.currentLine=65339396;
 //BA.debugLineNum = 65339396;BA.debugLine="et_nerkh_vam.Text=\"\"";
mostCurrent._et_nerkh_vam.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=65339397;
 //BA.debugLineNum = 65339397;BA.debugLine="et_tedad_gest.Text=\"\"";
mostCurrent._et_tedad_gest.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=65339399;
 //BA.debugLineNum = 65339399;BA.debugLine="pan_all_add.Visible=True";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=65339401;
 //BA.debugLineNum = 65339401;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_agsat_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_agsat_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_agsat_click", null));}
RDebugUtils.currentLine=65994752;
 //BA.debugLineNum = 65994752;BA.debugLine="Private Sub lbl_agsat_Click";
RDebugUtils.currentLine=65994753;
 //BA.debugLineNum = 65994753;BA.debugLine="pan_all_show_info.Visible=False";
mostCurrent._pan_all_show_info.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=65994755;
 //BA.debugLineNum = 65994755;BA.debugLine="StartActivity(gestha_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._gestha_activity.getObject()));
RDebugUtils.currentLine=65994756;
 //BA.debugLineNum = 65994756;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_click", null));}
RDebugUtils.currentLine=66060288;
 //BA.debugLineNum = 66060288;BA.debugLine="Private Sub lbl_close_Click";
RDebugUtils.currentLine=66060289;
 //BA.debugLineNum = 66060289;BA.debugLine="pan_all_show_info.Visible=False";
mostCurrent._pan_all_show_info.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=66060290;
 //BA.debugLineNum = 66060290;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_date_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_date_click", null));}
RDebugUtils.currentLine=65470464;
 //BA.debugLineNum = 65470464;BA.debugLine="Private Sub lbl_date_Click";
RDebugUtils.currentLine=65470465;
 //BA.debugLineNum = 65470465;BA.debugLine="pan_all_set_date.Visible=True";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=65470468;
 //BA.debugLineNum = 65470468;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date.Text.SubStri";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date.getText().substring((int) (0),(int) (4)))));
RDebugUtils.currentLine=65470469;
 //BA.debugLineNum = 65470469;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date.Text.SubStrin";
mostCurrent._pik_moon1.setTag((Object)(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._lbl_date.getText().substring((int) (5),(int) (7)))));
RDebugUtils.currentLine=65470470;
 //BA.debugLineNum = 65470470;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=65470474;
 //BA.debugLineNum = 65470474;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_go_agsatpage_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_go_agsatpage_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_go_agsatpage_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
RDebugUtils.currentLine=65798144;
 //BA.debugLineNum = 65798144;BA.debugLine="Private Sub lbl_go_agsatPage_Click";
RDebugUtils.currentLine=65798145;
 //BA.debugLineNum = 65798145;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=65798146;
 //BA.debugLineNum = 65798146;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=65798147;
 //BA.debugLineNum = 65798147;BA.debugLine="Main.current_idvam=b.Tag";
mostCurrent._main._current_idvam /*String*/  = BA.ObjectToString(_b.getTag());
RDebugUtils.currentLine=65798148;
 //BA.debugLineNum = 65798148;BA.debugLine="StartActivity(gestha_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._gestha_activity.getObject()));
RDebugUtils.currentLine=65798150;
 //BA.debugLineNum = 65798150;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_info_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_info_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_info_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _str_show = null;
RDebugUtils.currentLine=66125824;
 //BA.debugLineNum = 66125824;BA.debugLine="Private Sub lbl_info_Click";
RDebugUtils.currentLine=66125826;
 //BA.debugLineNum = 66125826;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=66125827;
 //BA.debugLineNum = 66125827;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=66125829;
 //BA.debugLineNum = 66125829;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=66125830;
 //BA.debugLineNum = 66125830;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_vam WHERE id="+BA.ObjectToString(_b.getTag()))));
RDebugUtils.currentLine=66125831;
 //BA.debugLineNum = 66125831;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=66125832;
 //BA.debugLineNum = 66125832;BA.debugLine="Main.current_idvam= dbCode.res.GetString(\"idvam\")";
mostCurrent._main._current_idvam /*String*/  = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("idvam");
RDebugUtils.currentLine=66125835;
 //BA.debugLineNum = 66125835;BA.debugLine="pan_all_show_info.Visible=True";
mostCurrent._pan_all_show_info.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=66125839;
 //BA.debugLineNum = 66125839;BA.debugLine="Dim str_show As StringBuilder";
_str_show = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=66125840;
 //BA.debugLineNum = 66125840;BA.debugLine="str_show.Initialize";
_str_show.Initialize();
RDebugUtils.currentLine=66125842;
 //BA.debugLineNum = 66125842;BA.debugLine="str_show.Append(\"<html dir='rtl'><meta charset='U";
_str_show.Append("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>");
RDebugUtils.currentLine=66125844;
 //BA.debugLineNum = 66125844;BA.debugLine="str_show.Append(\"<h5 align='center'>عنوان وام <br";
_str_show.Append("<h5 align='center'>عنوان وام <br>");
RDebugUtils.currentLine=66125845;
 //BA.debugLineNum = 66125845;BA.debugLine="str_show.Append(dbCode.res.GetString(\"onvan\"))";
_str_show.Append(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("onvan"));
RDebugUtils.currentLine=66125846;
 //BA.debugLineNum = 66125846;BA.debugLine="str_show.Append(\"</h5>\")";
_str_show.Append("</h5>");
RDebugUtils.currentLine=66125848;
 //BA.debugLineNum = 66125848;BA.debugLine="str_show.Append(\"<div style=' border: 2px solid g";
_str_show.Append("<div style=' border: 2px solid gray;  padding: 10px; border-radius: 20px;'>");
RDebugUtils.currentLine=66125849;
 //BA.debugLineNum = 66125849;BA.debugLine="str_show.Append(\" مبلغ وام : \"&myfunc.show_num_po";
_str_show.Append(" مبلغ وام : "+mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("mablag"))))).Append("<br>");
RDebugUtils.currentLine=66125850;
 //BA.debugLineNum = 66125850;BA.debugLine="str_show.Append(\"نرخ وام % : \"&(dbCode.res.GetStr";
_str_show.Append("نرخ وام % : "+(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("rate"))).Append("<br>");
RDebugUtils.currentLine=66125851;
 //BA.debugLineNum = 66125851;BA.debugLine="str_show.Append(\" تعداد اقساط : \"&(dbCode.res.Get";
_str_show.Append(" تعداد اقساط : "+(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("count"))).Append("<br>");
RDebugUtils.currentLine=66125852;
 //BA.debugLineNum = 66125852;BA.debugLine="str_show.Append(\" ماه شروع : \"&(dbCode.res.GetStr";
_str_show.Append(" ماه شروع : "+(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("date"))).Append("<br>");
RDebugUtils.currentLine=66125853;
 //BA.debugLineNum = 66125853;BA.debugLine="str_show.Append(\" توضیحات : \"&(dbCode.res.GetStri";
_str_show.Append(" توضیحات : "+(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("tozihat"))).Append("<br>");
RDebugUtils.currentLine=66125854;
 //BA.debugLineNum = 66125854;BA.debugLine="str_show.Append(\"</div>\").Append(\"<br>\")";
_str_show.Append("</div>").Append("<br>");
RDebugUtils.currentLine=66125856;
 //BA.debugLineNum = 66125856;BA.debugLine="str_show.Append(\"<div style=' border: 3px solid g";
_str_show.Append("<div style=' border: 3px solid green;  padding: 10px; border-radius: 20px;'>");
RDebugUtils.currentLine=66125857;
 //BA.debugLineNum = 66125857;BA.debugLine="str_show.Append(\" کل مبلغ بازپرداخت  : \"&myfunc.s";
_str_show.Append(" کل مبلغ بازپرداخت  : "+mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("bazpardakht"))))).Append("<br>");
RDebugUtils.currentLine=66125858;
 //BA.debugLineNum = 66125858;BA.debugLine="str_show.Append(\" مبلغ هر قسط : <mark> \"&myfunc.s";
_str_show.Append(" مبلغ هر قسط : <mark> "+mostCurrent._myfunc._show_num_pool /*String*/ (mostCurrent.activityBA,(int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("harghest"))))+"</mark>");
RDebugUtils.currentLine=66125859;
 //BA.debugLineNum = 66125859;BA.debugLine="str_show.Append(\"</div>\")";
_str_show.Append("</div>");
RDebugUtils.currentLine=66125861;
 //BA.debugLineNum = 66125861;BA.debugLine="str_show.Append(\"</body></html>\")";
_str_show.Append("</body></html>");
RDebugUtils.currentLine=66125864;
 //BA.debugLineNum = 66125864;BA.debugLine="wb_show_result.LoadHtml(str_show.ToString)";
mostCurrent._wb_show_result.LoadHtml(_str_show.ToString());
RDebugUtils.currentLine=66125867;
 //BA.debugLineNum = 66125867;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_remove_from_list2_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_remove_from_list2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_remove_from_list2_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _b = null;
String _get_idvam = "";
int _result = 0;
RDebugUtils.currentLine=64618496;
 //BA.debugLineNum = 64618496;BA.debugLine="Private Sub lbl_remove_from_list2_Click";
RDebugUtils.currentLine=64618498;
 //BA.debugLineNum = 64618498;BA.debugLine="Dim b As Label";
_b = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=64618499;
 //BA.debugLineNum = 64618499;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=64618501;
 //BA.debugLineNum = 64618501;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=64618502;
 //BA.debugLineNum = 64618502;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_vam WHERE id="+BA.ObjectToString(_b.getTag()))));
RDebugUtils.currentLine=64618503;
 //BA.debugLineNum = 64618503;BA.debugLine="dbCode.res.Position=0";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=64618504;
 //BA.debugLineNum = 64618504;BA.debugLine="Dim  get_idvam As String= dbCode.res.GetString(\"i";
_get_idvam = mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("idvam");
RDebugUtils.currentLine=64618506;
 //BA.debugLineNum = 64618506;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=64618507;
 //BA.debugLineNum = 64618507;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا این مورد حذف شود؟"),BA.ObjectToCharSequence("حذف"),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=64618508;
 //BA.debugLineNum = 64618508;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=64618510;
 //BA.debugLineNum = 64618510;BA.debugLine="If (dbCode.delete_vam(b.Tag))Then";
if ((mostCurrent._dbcode._delete_vam /*boolean*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(_b.getTag()))))) { 
RDebugUtils.currentLine=64618512;
 //BA.debugLineNum = 64618512;BA.debugLine="dbCode.delete_ghestha(get_idvam)";
mostCurrent._dbcode._delete_ghestha /*boolean*/ (mostCurrent.activityBA,_get_idvam);
RDebugUtils.currentLine=64618513;
 //BA.debugLineNum = 64618513;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("حذف شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=64618516;
 //BA.debugLineNum = 64618516;BA.debugLine="fill_list_vam";
_fill_list_vam();
 };
 };
RDebugUtils.currentLine=64618525;
 //BA.debugLineNum = 64618525;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_restall_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_restall_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_restall_click", null));}
int _result = 0;
RDebugUtils.currentLine=66191360;
 //BA.debugLineNum = 66191360;BA.debugLine="Private Sub lbl_restAll_Click";
RDebugUtils.currentLine=66191361;
 //BA.debugLineNum = 66191361;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=66191362;
 //BA.debugLineNum = 66191362;BA.debugLine="result = Msgbox2(\"با این گزینه همه وام ها و قسط ه";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("با این گزینه همه وام ها و قسط ها حذف میشوند!"),BA.ObjectToCharSequence("بازنشانی"),"بازنشانی همه","","بستن",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=66191363;
 //BA.debugLineNum = 66191363;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=66191365;
 //BA.debugLineNum = 66191365;BA.debugLine="dbCode.delete_all_vam";
mostCurrent._dbcode._delete_all_vam /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=66191366;
 //BA.debugLineNum = 66191366;BA.debugLine="ToastMessageShow(\"انجام شد.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("انجام شد."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=66191367;
 //BA.debugLineNum = 66191367;BA.debugLine="fill_list_vam";
_fill_list_vam();
 };
RDebugUtils.currentLine=66191373;
 //BA.debugLineNum = 66191373;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=65536000;
 //BA.debugLineNum = 65536000;BA.debugLine="Private Sub lbl_save_Click";
RDebugUtils.currentLine=65536001;
 //BA.debugLineNum = 65536001;BA.debugLine="If(et_onvan.Text=\"\")Then";
if (((mostCurrent._et_onvan.getText()).equals(""))) { 
RDebugUtils.currentLine=65536002;
 //BA.debugLineNum = 65536002;BA.debugLine="ToastMessageShow(\" عنوان وام را وارد کنید\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(" عنوان وام را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=65536004;
 //BA.debugLineNum = 65536004;BA.debugLine="else If(et_mablagh_vam.Text=\"\" Or et_mablagh_vam.";
if (((mostCurrent._et_mablagh_vam.getText()).equals("") || (mostCurrent._et_mablagh_vam.getText()).equals(BA.NumberToString(0)))) { 
RDebugUtils.currentLine=65536005;
 //BA.debugLineNum = 65536005;BA.debugLine="ToastMessageShow(\"مبلغ وام را وارد کنید\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("مبلغ وام را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=65536007;
 //BA.debugLineNum = 65536007;BA.debugLine="else If(et_nerkh_vam.Text=\"\" )Then";
if (((mostCurrent._et_nerkh_vam.getText()).equals(""))) { 
RDebugUtils.currentLine=65536008;
 //BA.debugLineNum = 65536008;BA.debugLine="ToastMessageShow(\"نرخ وام را وارد کنید\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("نرخ وام را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=65536010;
 //BA.debugLineNum = 65536010;BA.debugLine="else If(et_tedad_gest.Text=\"\" Or et_tedad_gest.Te";
if (((mostCurrent._et_tedad_gest.getText()).equals("") || (mostCurrent._et_tedad_gest.getText()).equals(BA.NumberToString(0)))) { 
RDebugUtils.currentLine=65536011;
 //BA.debugLineNum = 65536011;BA.debugLine="ToastMessageShow(\"تعداد قسط ها را وارد کنید\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تعداد قسط ها را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=65536014;
 //BA.debugLineNum = 65536014;BA.debugLine="Dim random_idvam As String=myfunc.random_id(5)";
_random_idvam = mostCurrent._myfunc._random_id /*String*/ (mostCurrent.activityBA,(int) (5));
RDebugUtils.currentLine=65536016;
 //BA.debugLineNum = 65536016;BA.debugLine="dbCode.add_vam(random_idvam,et_onvan.Text,et_mab";
mostCurrent._dbcode._add_vam /*boolean*/ (mostCurrent.activityBA,_random_idvam,mostCurrent._et_onvan.getText(),BA.ObjectToString(mostCurrent._et_mablagh_vam.getTag()),mostCurrent._et_tedad_gest.getText(),mostCurrent._et_nerkh_vam.getText(),BA.NumberToString(1),mostCurrent._lbl_date.getText(),BA.ObjectToString(mostCurrent._lbl_kol_bazpardakht.getTag()),BA.ObjectToString(mostCurrent._lbl_hargest.getTag()),mostCurrent._et_tozih.getText(),(int) (0));
RDebugUtils.currentLine=65536017;
 //BA.debugLineNum = 65536017;BA.debugLine="Dim shomare_gest As String=\"\"";
_shomare_gest = "";
RDebugUtils.currentLine=65536018;
 //BA.debugLineNum = 65536018;BA.debugLine="Dim date_gest As String= lbl_date.Text";
_date_gest = mostCurrent._lbl_date.getText();
RDebugUtils.currentLine=65536019;
 //BA.debugLineNum = 65536019;BA.debugLine="Dim date_year As Int=lbl_date.Text.SubString2(0,";
_date_year = (int)(Double.parseDouble(mostCurrent._lbl_date.getText().substring((int) (0),(int) (4))));
RDebugUtils.currentLine=65536020;
 //BA.debugLineNum = 65536020;BA.debugLine="Dim date_moon As Int=lbl_date.Text.SubString2(5,";
_date_moon = (int)(Double.parseDouble(mostCurrent._lbl_date.getText().substring((int) (5),(int) (7))));
RDebugUtils.currentLine=65536022;
 //BA.debugLineNum = 65536022;BA.debugLine="For i=1 To et_tedad_gest.Text";
{
final int step16 = 1;
final int limit16 = (int)(Double.parseDouble(mostCurrent._et_tedad_gest.getText()));
_i = (int) (1) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
RDebugUtils.currentLine=65536025;
 //BA.debugLineNum = 65536025;BA.debugLine="shomare_gest = \"شماره قسط :\"& (i)";
_shomare_gest = "شماره قسط :"+BA.NumberToString((_i));
RDebugUtils.currentLine=65536026;
 //BA.debugLineNum = 65536026;BA.debugLine="dbCode.add_gest(random_idvam,date_gest,lbl_harG";
mostCurrent._dbcode._add_gest /*boolean*/ (mostCurrent.activityBA,_random_idvam,_date_gest,BA.ObjectToString(mostCurrent._lbl_hargest.getTag()),mostCurrent._et_onvan.getText(),(int) (0));
RDebugUtils.currentLine=65536029;
 //BA.debugLineNum = 65536029;BA.debugLine="date_moon=date_moon+1";
_date_moon = (int) (_date_moon+1);
RDebugUtils.currentLine=65536030;
 //BA.debugLineNum = 65536030;BA.debugLine="If(date_moon>12)Then";
if ((_date_moon>12)) { 
RDebugUtils.currentLine=65536031;
 //BA.debugLineNum = 65536031;BA.debugLine="date_moon=1";
_date_moon = (int) (1);
RDebugUtils.currentLine=65536032;
 //BA.debugLineNum = 65536032;BA.debugLine="date_year=date_year+1";
_date_year = (int) (_date_year+1);
 };
RDebugUtils.currentLine=65536035;
 //BA.debugLineNum = 65536035;BA.debugLine="date_gest=myfunc.convert_adad( date_year)&\"/\"&m";
_date_gest = mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_date_year)+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,_date_moon);
 }
};
RDebugUtils.currentLine=65536039;
 //BA.debugLineNum = 65536039;BA.debugLine="fill_list_vam";
_fill_list_vam();
RDebugUtils.currentLine=65536040;
 //BA.debugLineNum = 65536040;BA.debugLine="pan_all_add.Visible=False";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }}}}
;
RDebugUtils.currentLine=65536044;
 //BA.debugLineNum = 65536044;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_picker_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_picker_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_picker_click", null));}
RDebugUtils.currentLine=64880640;
 //BA.debugLineNum = 64880640;BA.debugLine="Private Sub lbl_save_picker_Click";
RDebugUtils.currentLine=64880641;
 //BA.debugLineNum = 64880641;BA.debugLine="lbl_date.Text=pik_year1.Text&\"/\"&myfunc.convert_a";
mostCurrent._lbl_date.setText(BA.ObjectToCharSequence(mostCurrent._pik_year1.getText()+"/"+mostCurrent._myfunc._convert_adad /*String*/ (mostCurrent.activityBA,(int)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag())))));
RDebugUtils.currentLine=64880642;
 //BA.debugLineNum = 64880642;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=64880643;
 //BA.debugLineNum = 64880643;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_add_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_add_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_add_click", null));}
RDebugUtils.currentLine=65404928;
 //BA.debugLineNum = 65404928;BA.debugLine="Private Sub pan_all_add_Click";
RDebugUtils.currentLine=65404929;
 //BA.debugLineNum = 65404929;BA.debugLine="pan_all_add.Visible=False";
mostCurrent._pan_all_add.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=65404930;
 //BA.debugLineNum = 65404930;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_set_date_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_set_date_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_set_date_click", null));}
RDebugUtils.currentLine=64749568;
 //BA.debugLineNum = 64749568;BA.debugLine="Private Sub pan_all_set_date_Click";
RDebugUtils.currentLine=64749569;
 //BA.debugLineNum = 64749569;BA.debugLine="pan_all_set_date.Visible=False";
mostCurrent._pan_all_set_date.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=64749570;
 //BA.debugLineNum = 64749570;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_show_info_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_show_info_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_show_info_click", null));}
RDebugUtils.currentLine=65863680;
 //BA.debugLineNum = 65863680;BA.debugLine="Private Sub pan_all_show_info_Click";
RDebugUtils.currentLine=65863681;
 //BA.debugLineNum = 65863681;BA.debugLine="pan_all_show_info.Visible=False";
mostCurrent._pan_all_show_info.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=65863682;
 //BA.debugLineNum = 65863682;BA.debugLine="End Sub";
return "";
}
public static String  _panel2_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel2_click", null));}
RDebugUtils.currentLine=65929216;
 //BA.debugLineNum = 65929216;BA.debugLine="Private Sub Panel2_Click";
RDebugUtils.currentLine=65929218;
 //BA.debugLineNum = 65929218;BA.debugLine="End Sub";
return "";
}
public static String  _panel4_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel4_click", null));}
RDebugUtils.currentLine=64684032;
 //BA.debugLineNum = 64684032;BA.debugLine="Private Sub Panel4_Click";
RDebugUtils.currentLine=64684034;
 //BA.debugLineNum = 64684034;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_bala1_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=65077248;
 //BA.debugLineNum = 65077248;BA.debugLine="Private Sub pik_moon_bala1_Click";
RDebugUtils.currentLine=65077249;
 //BA.debugLineNum = 65077249;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=65077250;
 //BA.debugLineNum = 65077250;BA.debugLine="pik_moon1.Tag=int1+1";
mostCurrent._pik_moon1.setTag((Object)(_int1+1));
RDebugUtils.currentLine=65077252;
 //BA.debugLineNum = 65077252;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=65077253;
 //BA.debugLineNum = 65077253;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=65077255;
 //BA.debugLineNum = 65077255;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=65077256;
 //BA.debugLineNum = 65077256;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=65077258;
 //BA.debugLineNum = 65077258;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
RDebugUtils.currentLine=65077260;
 //BA.debugLineNum = 65077260;BA.debugLine="End Sub";
return "";
}
public static String  _pik_moon_paeen1_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_moon_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_moon_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=65142784;
 //BA.debugLineNum = 65142784;BA.debugLine="Private Sub pik_moon_paeen1_Click";
RDebugUtils.currentLine=65142785;
 //BA.debugLineNum = 65142785;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))));
RDebugUtils.currentLine=65142786;
 //BA.debugLineNum = 65142786;BA.debugLine="pik_moon1.Tag=int1-1";
mostCurrent._pik_moon1.setTag((Object)(_int1-1));
RDebugUtils.currentLine=65142788;
 //BA.debugLineNum = 65142788;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=65142789;
 //BA.debugLineNum = 65142789;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=65142791;
 //BA.debugLineNum = 65142791;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=65142792;
 //BA.debugLineNum = 65142792;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=65142794;
 //BA.debugLineNum = 65142794;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1))));
RDebugUtils.currentLine=65142796;
 //BA.debugLineNum = 65142796;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_moon1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_moon1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_moon1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=64946176;
 //BA.debugLineNum = 64946176;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
RDebugUtils.currentLine=64946177;
 //BA.debugLineNum = 64946177;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=64946178;
 //BA.debugLineNum = 64946178;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=64946179;
 //BA.debugLineNum = 64946179;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=64946182;
 //BA.debugLineNum = 64946182;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=64946184;
 //BA.debugLineNum = 64946184;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=64946185;
 //BA.debugLineNum = 64946185;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))-1);
RDebugUtils.currentLine=64946186;
 //BA.debugLineNum = 64946186;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=64946187;
 //BA.debugLineNum = 64946187;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=64946189;
 //BA.debugLineNum = 64946189;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=64946190;
 //BA.debugLineNum = 64946190;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.ObjectToString(mostCurrent._pik_moon1.getTag()))))+1);
RDebugUtils.currentLine=64946191;
 //BA.debugLineNum = 64946191;BA.debugLine="pik_moon1.Tag=int1";
mostCurrent._pik_moon1.setTag((Object)(_int1));
RDebugUtils.currentLine=64946192;
 //BA.debugLineNum = 64946192;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=64946195;
 //BA.debugLineNum = 64946195;BA.debugLine="If(pik_moon1.Tag>12)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))>12)) { 
RDebugUtils.currentLine=64946196;
 //BA.debugLineNum = 64946196;BA.debugLine="pik_moon1.Tag=1";
mostCurrent._pik_moon1.setTag((Object)(1));
 };
RDebugUtils.currentLine=64946198;
 //BA.debugLineNum = 64946198;BA.debugLine="If(pik_moon1.Tag<1)Then";
if (((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))<1)) { 
RDebugUtils.currentLine=64946199;
 //BA.debugLineNum = 64946199;BA.debugLine="pik_moon1.Tag=12";
mostCurrent._pik_moon1.setTag((Object)(12));
 };
RDebugUtils.currentLine=64946201;
 //BA.debugLineNum = 64946201;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
mostCurrent._pik_moon1.setText(BA.ObjectToCharSequence(mostCurrent._moon_datapik.Get((int) ((double)(BA.ObjectToNumber(mostCurrent._pik_moon1.getTag()))-1))));
 };
RDebugUtils.currentLine=64946204;
 //BA.debugLineNum = 64946204;BA.debugLine="End Sub";
return "";
}
public static String  _pik_pan_year1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_pan_year1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_pan_year1_touch", new Object[] {_action,_x,_y}));}
int _int1 = 0;
RDebugUtils.currentLine=65011712;
 //BA.debugLineNum = 65011712;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
RDebugUtils.currentLine=65011713;
 //BA.debugLineNum = 65011713;BA.debugLine="If(Action=1)Then";
if ((_action==1)) { 
RDebugUtils.currentLine=65011714;
 //BA.debugLineNum = 65011714;BA.debugLine="Dim int1 As Int";
_int1 = 0;
RDebugUtils.currentLine=65011715;
 //BA.debugLineNum = 65011715;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=65011718;
 //BA.debugLineNum = 65011718;BA.debugLine="If(Action=2)Then";
if ((_action==2)) { 
RDebugUtils.currentLine=65011720;
 //BA.debugLineNum = 65011720;BA.debugLine="If(Y>num_dataPik+20)Then";
if ((_y>_num_datapik+20)) { 
RDebugUtils.currentLine=65011721;
 //BA.debugLineNum = 65011721;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))-1);
RDebugUtils.currentLine=65011722;
 //BA.debugLineNum = 65011722;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=65011723;
 //BA.debugLineNum = 65011723;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=65011725;
 //BA.debugLineNum = 65011725;BA.debugLine="If(Y<num_dataPik-20)Then";
if ((_y<_num_datapik-20)) { 
RDebugUtils.currentLine=65011726;
 //BA.debugLineNum = 65011726;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
_int1 = (int) ((double)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())))+1);
RDebugUtils.currentLine=65011727;
 //BA.debugLineNum = 65011727;BA.debugLine="pik_year1.Text=int1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1));
RDebugUtils.currentLine=65011728;
 //BA.debugLineNum = 65011728;BA.debugLine="num_dataPik=y";
_num_datapik = (int) (_y);
 };
RDebugUtils.currentLine=65011731;
 //BA.debugLineNum = 65011731;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=65011732;
 //BA.debugLineNum = 65011732;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=65011734;
 //BA.debugLineNum = 65011734;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=65011735;
 //BA.debugLineNum = 65011735;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
 };
RDebugUtils.currentLine=65011740;
 //BA.debugLineNum = 65011740;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_bala1_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_bala1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_bala1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=65208320;
 //BA.debugLineNum = 65208320;BA.debugLine="Private Sub pik_year_bala1_Click";
RDebugUtils.currentLine=65208321;
 //BA.debugLineNum = 65208321;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=65208322;
 //BA.debugLineNum = 65208322;BA.debugLine="pik_year1.Text=int1+1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1+1));
RDebugUtils.currentLine=65208324;
 //BA.debugLineNum = 65208324;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=65208325;
 //BA.debugLineNum = 65208325;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=65208327;
 //BA.debugLineNum = 65208327;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=65208328;
 //BA.debugLineNum = 65208328;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=65208331;
 //BA.debugLineNum = 65208331;BA.debugLine="End Sub";
return "";
}
public static String  _pik_year_paeen1_click() throws Exception{
RDebugUtils.currentModule="vam_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pik_year_paeen1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pik_year_paeen1_click", null));}
int _int1 = 0;
RDebugUtils.currentLine=65273856;
 //BA.debugLineNum = 65273856;BA.debugLine="Private Sub pik_year_paeen1_Click";
RDebugUtils.currentLine=65273857;
 //BA.debugLineNum = 65273857;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
_int1 = (int)(Double.parseDouble(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._pik_year1.getText())));
RDebugUtils.currentLine=65273858;
 //BA.debugLineNum = 65273858;BA.debugLine="pik_year1.Text=int1-1";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(_int1-1));
RDebugUtils.currentLine=65273860;
 //BA.debugLineNum = 65273860;BA.debugLine="If(pik_year1.Text>1410)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))>1410)) { 
RDebugUtils.currentLine=65273861;
 //BA.debugLineNum = 65273861;BA.debugLine="pik_year1.Text=1390";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1390));
 };
RDebugUtils.currentLine=65273863;
 //BA.debugLineNum = 65273863;BA.debugLine="If(pik_year1.Text<1390)Then";
if (((double)(Double.parseDouble(mostCurrent._pik_year1.getText()))<1390)) { 
RDebugUtils.currentLine=65273864;
 //BA.debugLineNum = 65273864;BA.debugLine="pik_year1.Text=1410";
mostCurrent._pik_year1.setText(BA.ObjectToCharSequence(1410));
 };
RDebugUtils.currentLine=65273867;
 //BA.debugLineNum = 65273867;BA.debugLine="End Sub";
return "";
}
}