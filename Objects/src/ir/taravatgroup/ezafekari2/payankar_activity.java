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

public class payankar_activity extends Activity implements B4AActivity{
	public static payankar_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.payankar_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (payankar_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.payankar_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.payankar_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (payankar_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (payankar_activity) Resume **");
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
		return payankar_activity.class;
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
            BA.LogInfo("** Activity (payankar_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (payankar_activity) Pause event (activity is not paused). **");
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
            payankar_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (payankar_activity) Resume **");
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
public anywheresoftware.b4a.objects.EditTextWrapper _et_payeh = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_payankar = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_date1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_date2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_payankar = null;
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=21233664;
 //BA.debugLineNum = 21233664;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=21233666;
 //BA.debugLineNum = 21233666;BA.debugLine="Activity.LoadLayout(\"payankar_layout\")";
mostCurrent._activity.LoadLayout("payankar_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=21233668;
 //BA.debugLineNum = 21233668;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=21233669;
 //BA.debugLineNum = 21233669;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_setting")));
RDebugUtils.currentLine=21233671;
 //BA.debugLineNum = 21233671;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .setPosition((int) (0));
RDebugUtils.currentLine=21233672;
 //BA.debugLineNum = 21233672;BA.debugLine="et_payeh.Tag=dbCode.res.GetString(\"value\")";
mostCurrent._et_payeh.setTag((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value")));
RDebugUtils.currentLine=21233673;
 //BA.debugLineNum = 21233673;BA.debugLine="et_payeh.Text=show_num_pool(dbCode.res.GetString(";
mostCurrent._et_payeh.setText(BA.ObjectToCharSequence(_show_num_pool((int)(Double.parseDouble(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .GetString("value"))))));
RDebugUtils.currentLine=21233675;
 //BA.debugLineNum = 21233675;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=21233676;
 //BA.debugLineNum = 21233676;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=21233679;
 //BA.debugLineNum = 21233679;BA.debugLine="et_date1.Text=myfunc.fa2en(Main.persianDate.Persi";
mostCurrent._et_date1.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,BA.NumberToString(mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianYear())+"/01/01")));
RDebugUtils.currentLine=21233680;
 //BA.debugLineNum = 21233680;BA.debugLine="et_date2.Text=myfunc.fa2en(Main.persianDate.Persi";
mostCurrent._et_date2.setText(BA.ObjectToCharSequence(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .getPersianShortDate())));
RDebugUtils.currentLine=21233682;
 //BA.debugLineNum = 21233682;BA.debugLine="et_payeh.Color=Colors.White";
mostCurrent._et_payeh.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=21233683;
 //BA.debugLineNum = 21233683;BA.debugLine="et_date1.Color=Colors.White";
mostCurrent._et_date1.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=21233685;
 //BA.debugLineNum = 21233685;BA.debugLine="et_date2.Color=Colors.White";
mostCurrent._et_date2.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=21233689;
 //BA.debugLineNum = 21233689;BA.debugLine="pan_hed_payankar.Color=Main.color4";
mostCurrent._pan_hed_payankar.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=21233690;
 //BA.debugLineNum = 21233690;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=21233691;
 //BA.debugLineNum = 21233691;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(int _num) throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "show_num_pool", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "show_num_pool", new Object[] {_num}));}
RDebugUtils.currentLine=21692416;
 //BA.debugLineNum = 21692416;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=21692417;
 //BA.debugLineNum = 21692417;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
RDebugUtils.currentLine=21692418;
 //BA.debugLineNum = 21692418;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=21495808;
 //BA.debugLineNum = 21495808;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=21495809;
 //BA.debugLineNum = 21495809;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=21495810;
 //BA.debugLineNum = 21495810;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=21495811;
 //BA.debugLineNum = 21495811;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=21495813;
 //BA.debugLineNum = 21495813;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=21495815;
 //BA.debugLineNum = 21495815;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=21430272;
 //BA.debugLineNum = 21430272;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=21430274;
 //BA.debugLineNum = 21430274;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=21430275;
 //BA.debugLineNum = 21430275;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="payankar_activity";
RDebugUtils.currentLine=21364736;
 //BA.debugLineNum = 21364736;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=21364738;
 //BA.debugLineNum = 21364738;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=21299200;
 //BA.debugLineNum = 21299200;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=21299202;
 //BA.debugLineNum = 21299202;BA.debugLine="End Sub";
return "";
}
public static String  _btn_mohasebe_payankar_click() throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_mohasebe_payankar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_mohasebe_payankar_click", null));}
int _payankar_roz = 0;
int _rozha = 0;
int _payankar = 0;
RDebugUtils.currentLine=21561344;
 //BA.debugLineNum = 21561344;BA.debugLine="Private Sub btn_mohasebe_payankar_Click";
RDebugUtils.currentLine=21561345;
 //BA.debugLineNum = 21561345;BA.debugLine="Dim payankar_roz As Int";
_payankar_roz = 0;
RDebugUtils.currentLine=21561346;
 //BA.debugLineNum = 21561346;BA.debugLine="Dim rozha As Int";
_rozha = 0;
RDebugUtils.currentLine=21561347;
 //BA.debugLineNum = 21561347;BA.debugLine="Dim payankar As Int";
_payankar = 0;
RDebugUtils.currentLine=21561349;
 //BA.debugLineNum = 21561349;BA.debugLine="If(et_payeh.Text=\"\")Then";
if (((mostCurrent._et_payeh.getText()).equals(""))) { 
RDebugUtils.currentLine=21561350;
 //BA.debugLineNum = 21561350;BA.debugLine="et_payeh.Text=0";
mostCurrent._et_payeh.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=21561351;
 //BA.debugLineNum = 21561351;BA.debugLine="et_payeh.Tag=0";
mostCurrent._et_payeh.setTag((Object)(0));
 };
RDebugUtils.currentLine=21561355;
 //BA.debugLineNum = 21561355;BA.debugLine="payankar_roz=et_payeh.Tag/365";
_payankar_roz = (int) ((double)(BA.ObjectToNumber(mostCurrent._et_payeh.getTag()))/(double)365);
RDebugUtils.currentLine=21561356;
 //BA.debugLineNum = 21561356;BA.debugLine="rozha=time_mohasebe(et_date1.Text,et_date2.Text)";
_rozha = _time_mohasebe(mostCurrent._et_date1.getText(),mostCurrent._et_date2.getText());
RDebugUtils.currentLine=21561358;
 //BA.debugLineNum = 21561358;BA.debugLine="payankar=payankar_roz*rozha";
_payankar = (int) (_payankar_roz*_rozha);
RDebugUtils.currentLine=21561359;
 //BA.debugLineNum = 21561359;BA.debugLine="If(rozha=365)Then";
if ((_rozha==365)) { 
RDebugUtils.currentLine=21561360;
 //BA.debugLineNum = 21561360;BA.debugLine="payankar=et_payeh.Tag";
_payankar = (int)(BA.ObjectToNumber(mostCurrent._et_payeh.getTag()));
 };
RDebugUtils.currentLine=21561365;
 //BA.debugLineNum = 21561365;BA.debugLine="lbl_payankar.Text=\"تعداد روزها : \"&rozha&CRLF&\"پا";
mostCurrent._lbl_payankar.setText(BA.ObjectToCharSequence("تعداد روزها : "+BA.NumberToString(_rozha)+anywheresoftware.b4a.keywords.Common.CRLF+"پایان کار دریافتی :"+_show_num_pool(_payankar)));
RDebugUtils.currentLine=21561367;
 //BA.debugLineNum = 21561367;BA.debugLine="End Sub";
return "";
}
public static int  _time_mohasebe(String _date1,String _date2) throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time_mohasebe", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "time_mohasebe", new Object[] {_date1,_date2}));}
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
RDebugUtils.currentLine=21626880;
 //BA.debugLineNum = 21626880;BA.debugLine="Sub time_mohasebe(date1 As String, date2 As String";
RDebugUtils.currentLine=21626882;
 //BA.debugLineNum = 21626882;BA.debugLine="Try";
try {RDebugUtils.currentLine=21626884;
 //BA.debugLineNum = 21626884;BA.debugLine="Dim strfun As StringFunctions";
_strfun = new adr.stringfunctions.stringfunctions();
RDebugUtils.currentLine=21626885;
 //BA.debugLineNum = 21626885;BA.debugLine="strfun.Initialize";
_strfun._initialize(processBA);
RDebugUtils.currentLine=21626886;
 //BA.debugLineNum = 21626886;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=21626887;
 //BA.debugLineNum = 21626887;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=21626888;
 //BA.debugLineNum = 21626888;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
RDebugUtils.currentLine=21626889;
 //BA.debugLineNum = 21626889;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
RDebugUtils.currentLine=21626891;
 //BA.debugLineNum = 21626891;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=21626892;
 //BA.debugLineNum = 21626892;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=21626893;
 //BA.debugLineNum = 21626893;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=21626894;
 //BA.debugLineNum = 21626894;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=21626898;
 //BA.debugLineNum = 21626898;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = _strfun._vvvvvv5(_date1,"/");
RDebugUtils.currentLine=21626899;
 //BA.debugLineNum = 21626899;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = _strfun._vvvvvv5(_date2,"/");
RDebugUtils.currentLine=21626903;
 //BA.debugLineNum = 21626903;BA.debugLine="dat_mil_2=Main.persianDate.PersianToGregorian(li";
_dat_mil_2 = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=21626904;
 //BA.debugLineNum = 21626904;BA.debugLine="dat_mil_1=Main.persianDate.PersianToGregorian(li";
_dat_mil_1 = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=21626907;
 //BA.debugLineNum = 21626907;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = _strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=21626908;
 //BA.debugLineNum = 21626908;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = _strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=21626911;
 //BA.debugLineNum = 21626911;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
RDebugUtils.currentLine=21626914;
 //BA.debugLineNum = 21626914;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=21626915;
 //BA.debugLineNum = 21626915;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=21626920;
 //BA.debugLineNum = 21626920;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
RDebugUtils.currentLine=21626921;
 //BA.debugLineNum = 21626921;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
RDebugUtils.currentLine=21626922;
 //BA.debugLineNum = 21626922;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),"00:00:00");
RDebugUtils.currentLine=21626923;
 //BA.debugLineNum = 21626923;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2),"00:00:00");
RDebugUtils.currentLine=21626924;
 //BA.debugLineNum = 21626924;BA.debugLine="Dim rozha As Int";
_rozha = 0;
RDebugUtils.currentLine=21626925;
 //BA.debugLineNum = 21626925;BA.debugLine="rozha=Main.persianDate.CalculateDaysBetween(myfu";
_rozha = (int) (mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .CalculateDaysBetween(mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end1),mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,_date_end2)));
RDebugUtils.currentLine=21626928;
 //BA.debugLineNum = 21626928;BA.debugLine="Return rozha+1";
if (true) return (int) (_rozha+1);
 } 
       catch (Exception e29) {
			processBA.setLastException(e29);RDebugUtils.currentLine=21626931;
 //BA.debugLineNum = 21626931;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=21626933;
 //BA.debugLineNum = 21626933;BA.debugLine="End Sub";
return 0;
}
public static String  _change_formater(String _old,String _new,anywheresoftware.b4a.objects.EditTextWrapper _et_name) throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "change_formater", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "change_formater", new Object[] {_old,_new,_et_name}));}
double _d = 0;
String _s = "";
String _n = "";
String _o = "";
RDebugUtils.currentLine=21757952;
 //BA.debugLineNum = 21757952;BA.debugLine="Sub change_formater (Old As String, New As String,";
RDebugUtils.currentLine=21757953;
 //BA.debugLineNum = 21757953;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
_d = 0;
RDebugUtils.currentLine=21757954;
 //BA.debugLineNum = 21757954;BA.debugLine="Dim S,N,O As String";
_s = "";
_n = "";
_o = "";
RDebugUtils.currentLine=21757955;
 //BA.debugLineNum = 21757955;BA.debugLine="n=New.Replace(\",\",\"\")";
_n = _new.replace(",","");
RDebugUtils.currentLine=21757956;
 //BA.debugLineNum = 21757956;BA.debugLine="O=Old.Replace(\",\",\"\")";
_o = _old.replace(",","");
RDebugUtils.currentLine=21757957;
 //BA.debugLineNum = 21757957;BA.debugLine="If O<>N Then";
if ((_o).equals(_n) == false) { 
RDebugUtils.currentLine=21757958;
 //BA.debugLineNum = 21757958;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
_et_name.setText(BA.ObjectToCharSequence(_et_name.getText().replace(",","")));
RDebugUtils.currentLine=21757959;
 //BA.debugLineNum = 21757959;BA.debugLine="S=et_name.Text";
_s = _et_name.getText();
RDebugUtils.currentLine=21757960;
 //BA.debugLineNum = 21757960;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_s)==anywheresoftware.b4a.keywords.Common.True && (_s).equals("0") == false) { 
RDebugUtils.currentLine=21757961;
 //BA.debugLineNum = 21757961;BA.debugLine="D=s";
_d = (double)(Double.parseDouble(_s));
RDebugUtils.currentLine=21757962;
 //BA.debugLineNum = 21757962;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
_et_name.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_d,(int) (0),(int) (0))));
 };
 };
RDebugUtils.currentLine=21757965;
 //BA.debugLineNum = 21757965;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
_et_name.setSelectionStart(_et_name.getText().length());
RDebugUtils.currentLine=21757966;
 //BA.debugLineNum = 21757966;BA.debugLine="End Sub";
return "";
}
public static String  _et_payeh_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="payankar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_payeh_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_payeh_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=21823488;
 //BA.debugLineNum = 21823488;BA.debugLine="Private Sub et_payeh_TextChanged (Old As String, N";
RDebugUtils.currentLine=21823489;
 //BA.debugLineNum = 21823489;BA.debugLine="et_payeh.Tag=New.Replace(\",\",\"\")";
mostCurrent._et_payeh.setTag((Object)(_new.replace(",","")));
RDebugUtils.currentLine=21823490;
 //BA.debugLineNum = 21823490;BA.debugLine="change_formater(Old,New,et_payeh)";
_change_formater(_old,_new,mostCurrent._et_payeh);
RDebugUtils.currentLine=21823491;
 //BA.debugLineNum = 21823491;BA.debugLine="End Sub";
return "";
}
}