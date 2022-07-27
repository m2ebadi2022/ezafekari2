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

public class calc_activity extends Activity implements B4AActivity{
	public static calc_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.calc_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (calc_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.calc_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.calc_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (calc_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (calc_activity) Resume **");
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
		return calc_activity.class;
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
            BA.LogInfo("** Activity (calc_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (calc_activity) Pause event (activity is not paused). **");
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
            calc_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (calc_activity) Resume **");
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
public anywheresoftware.b4a.objects.LabelWrapper _totallb = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtndiv = null;
public anywheresoftware.b4a.objects.PanelWrapper _calcpnl = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtn0 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtn1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtn2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtn3 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtn4 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtn5 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtn6 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtn7 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtn8 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtn9 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtnac = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtndot = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtneq = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtnminus = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtnmul = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nrbtnplus = null;
public static String _nr1 = "";
public static String _nr2 = "";
public static String _total = "";
public static String _mathstr = "";
public static String _space = "";
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_calc = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="calc_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=18219008;
 //BA.debugLineNum = 18219008;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=18219010;
 //BA.debugLineNum = 18219010;BA.debugLine="Activity.LoadLayout(\"calc_layout\")";
mostCurrent._activity.LoadLayout("calc_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=18219011;
 //BA.debugLineNum = 18219011;BA.debugLine="totallb.Text = \"0\" & space";
mostCurrent._totallb.setText(BA.ObjectToCharSequence("0"+mostCurrent._space));
RDebugUtils.currentLine=18219015;
 //BA.debugLineNum = 18219015;BA.debugLine="pan_hed_calc.Color=Main.color4";
mostCurrent._pan_hed_calc.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=18219016;
 //BA.debugLineNum = 18219016;BA.debugLine="calcpnl.Color=Main.color5";
mostCurrent._calcpnl.setColor(mostCurrent._main._color5 /*int*/ );
RDebugUtils.currentLine=18219017;
 //BA.debugLineNum = 18219017;BA.debugLine="Activity.Color=Main.color5";
mostCurrent._activity.setColor(mostCurrent._main._color5 /*int*/ );
RDebugUtils.currentLine=18219019;
 //BA.debugLineNum = 18219019;BA.debugLine="font_setting";
_font_setting();
RDebugUtils.currentLine=18219021;
 //BA.debugLineNum = 18219021;BA.debugLine="End Sub";
return "";
}
public static String  _font_setting() throws Exception{
RDebugUtils.currentModule="calc_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "font_setting", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "font_setting", null));}
String _font_name = "";
anywheresoftware.b4a.objects.ConcreteViewWrapper _view1 = null;
anywheresoftware.b4a.objects.ButtonWrapper _lbl1 = null;
RDebugUtils.currentLine=18284544;
 //BA.debugLineNum = 18284544;BA.debugLine="Sub font_setting";
RDebugUtils.currentLine=18284545;
 //BA.debugLineNum = 18284545;BA.debugLine="Dim font_name As String";
_font_name = "";
RDebugUtils.currentLine=18284546;
 //BA.debugLineNum = 18284546;BA.debugLine="Select Main.main_font";
switch (BA.switchObjectToInt(mostCurrent._main._main_font /*String*/ ,"یکان","نازنین","وزیر","دست نویس","کودک")) {
case 0: {
RDebugUtils.currentLine=18284548;
 //BA.debugLineNum = 18284548;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
case 1: {
RDebugUtils.currentLine=18284550;
 //BA.debugLineNum = 18284550;BA.debugLine="font_name=\"bnazanin.ttf\"";
_font_name = "bnazanin.ttf";
 break; }
case 2: {
RDebugUtils.currentLine=18284552;
 //BA.debugLineNum = 18284552;BA.debugLine="font_name=\"vazir.ttf\"";
_font_name = "vazir.ttf";
 break; }
case 3: {
RDebugUtils.currentLine=18284554;
 //BA.debugLineNum = 18284554;BA.debugLine="font_name=\"adastnevis.ttf\"";
_font_name = "adastnevis.ttf";
 break; }
case 4: {
RDebugUtils.currentLine=18284556;
 //BA.debugLineNum = 18284556;BA.debugLine="font_name=\"bkoodkbd.ttf\"";
_font_name = "bkoodkbd.ttf";
 break; }
default: {
RDebugUtils.currentLine=18284558;
 //BA.debugLineNum = 18284558;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
}
;
RDebugUtils.currentLine=18284563;
 //BA.debugLineNum = 18284563;BA.debugLine="Label2.TextSize=Main.size_f1";
mostCurrent._label2.setTextSize((float) (mostCurrent._main._size_f1 /*int*/ ));
RDebugUtils.currentLine=18284564;
 //BA.debugLineNum = 18284564;BA.debugLine="Label2.Typeface = Typeface.LoadFromAssets(font_na";
mostCurrent._label2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(_font_name));
RDebugUtils.currentLine=18284565;
 //BA.debugLineNum = 18284565;BA.debugLine="totallb.TextSize=Main.size_f1";
mostCurrent._totallb.setTextSize((float) (mostCurrent._main._size_f1 /*int*/ ));
RDebugUtils.currentLine=18284566;
 //BA.debugLineNum = 18284566;BA.debugLine="totallb.Typeface = Typeface.LoadFromAssets(font_n";
mostCurrent._totallb.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(_font_name));
RDebugUtils.currentLine=18284569;
 //BA.debugLineNum = 18284569;BA.debugLine="For Each view1 As View In Activity.GetAllViewsRec";
_view1 = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group20 = mostCurrent._activity.GetAllViewsRecursive();
final int groupLen20 = group20.getSize()
;int index20 = 0;
;
for (; index20 < groupLen20;index20++){
_view1 = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(group20.Get(index20)));
RDebugUtils.currentLine=18284570;
 //BA.debugLineNum = 18284570;BA.debugLine="If view1 Is Button Then";
if (_view1.getObjectOrNull() instanceof android.widget.Button) { 
RDebugUtils.currentLine=18284572;
 //BA.debugLineNum = 18284572;BA.debugLine="Dim lbl1 As Button";
_lbl1 = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=18284573;
 //BA.debugLineNum = 18284573;BA.debugLine="lbl1 = view1";
_lbl1 = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(_view1.getObject()));
RDebugUtils.currentLine=18284575;
 //BA.debugLineNum = 18284575;BA.debugLine="lbl1.Typeface = Typeface.LoadFromAssets(font_n";
_lbl1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(_font_name));
RDebugUtils.currentLine=18284576;
 //BA.debugLineNum = 18284576;BA.debugLine="lbl1.TextSize=Main.size_f2";
_lbl1.setTextSize((float) (mostCurrent._main._size_f2 /*int*/ ));
 };
 }
};
RDebugUtils.currentLine=18284583;
 //BA.debugLineNum = 18284583;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="calc_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=18743296;
 //BA.debugLineNum = 18743296;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=18743297;
 //BA.debugLineNum = 18743297;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=18743298;
 //BA.debugLineNum = 18743298;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=18743299;
 //BA.debugLineNum = 18743299;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=18743301;
 //BA.debugLineNum = 18743301;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=18743303;
 //BA.debugLineNum = 18743303;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="calc_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=18677760;
 //BA.debugLineNum = 18677760;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=18677762;
 //BA.debugLineNum = 18677762;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=18677763;
 //BA.debugLineNum = 18677763;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="calc_activity";
RDebugUtils.currentLine=18415616;
 //BA.debugLineNum = 18415616;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=18415618;
 //BA.debugLineNum = 18415618;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="calc_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=18350080;
 //BA.debugLineNum = 18350080;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=18350082;
 //BA.debugLineNum = 18350082;BA.debugLine="End Sub";
return "";
}
public static String  _calcpnl_click() throws Exception{
RDebugUtils.currentModule="calc_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "calcpnl_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "calcpnl_click", null));}
RDebugUtils.currentLine=18481152;
 //BA.debugLineNum = 18481152;BA.debugLine="Sub calcpnl_Click";
RDebugUtils.currentLine=18481154;
 //BA.debugLineNum = 18481154;BA.debugLine="End Sub";
return "";
}
public static String  _docalc(String _math,String _newmath) throws Exception{
RDebugUtils.currentModule="calc_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "docalc", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "docalc", new Object[] {_math,_newmath}));}
RDebugUtils.currentLine=18612224;
 //BA.debugLineNum = 18612224;BA.debugLine="Sub docalc (math As String,newmath As String)";
RDebugUtils.currentLine=18612225;
 //BA.debugLineNum = 18612225;BA.debugLine="Try";
try {RDebugUtils.currentLine=18612227;
 //BA.debugLineNum = 18612227;BA.debugLine="If math = \"plus\" Then";
if ((_math).equals("plus")) { 
RDebugUtils.currentLine=18612228;
 //BA.debugLineNum = 18612228;BA.debugLine="total = nr1 + nr2";
mostCurrent._total = BA.NumberToString((double)(Double.parseDouble(mostCurrent._nr1))+(double)(Double.parseDouble(mostCurrent._nr2)));
 }else 
{RDebugUtils.currentLine=18612229;
 //BA.debugLineNum = 18612229;BA.debugLine="Else If math = \"minus\" Then";
if ((_math).equals("minus")) { 
RDebugUtils.currentLine=18612230;
 //BA.debugLineNum = 18612230;BA.debugLine="total = nr1 - nr2";
mostCurrent._total = BA.NumberToString((double)(Double.parseDouble(mostCurrent._nr1))-(double)(Double.parseDouble(mostCurrent._nr2)));
 }else 
{RDebugUtils.currentLine=18612231;
 //BA.debugLineNum = 18612231;BA.debugLine="Else If math = \"mul\" Then";
if ((_math).equals("mul")) { 
RDebugUtils.currentLine=18612232;
 //BA.debugLineNum = 18612232;BA.debugLine="total = nr1 * nr2";
mostCurrent._total = BA.NumberToString((double)(Double.parseDouble(mostCurrent._nr1))*(double)(Double.parseDouble(mostCurrent._nr2)));
 }else 
{RDebugUtils.currentLine=18612233;
 //BA.debugLineNum = 18612233;BA.debugLine="Else If math = \"div\" Then";
if ((_math).equals("div")) { 
RDebugUtils.currentLine=18612234;
 //BA.debugLineNum = 18612234;BA.debugLine="total = nr1 / nr2";
mostCurrent._total = BA.NumberToString((double)(Double.parseDouble(mostCurrent._nr1))/(double)(double)(Double.parseDouble(mostCurrent._nr2)));
 }else {
RDebugUtils.currentLine=18612236;
 //BA.debugLineNum = 18612236;BA.debugLine="Return 'exit sub";
if (true) return "";
 }}}}
;
RDebugUtils.currentLine=18612239;
 //BA.debugLineNum = 18612239;BA.debugLine="If newmath <> \"\" Then";
if ((_newmath).equals("") == false) { 
RDebugUtils.currentLine=18612240;
 //BA.debugLineNum = 18612240;BA.debugLine="mathstr = newmath";
mostCurrent._mathstr = _newmath;
RDebugUtils.currentLine=18612241;
 //BA.debugLineNum = 18612241;BA.debugLine="nr2 = \"\"";
mostCurrent._nr2 = "";
 }else {
RDebugUtils.currentLine=18612243;
 //BA.debugLineNum = 18612243;BA.debugLine="mathstr = \"\"";
mostCurrent._mathstr = "";
RDebugUtils.currentLine=18612244;
 //BA.debugLineNum = 18612244;BA.debugLine="nr2 = \"\"";
mostCurrent._nr2 = "";
 };
RDebugUtils.currentLine=18612247;
 //BA.debugLineNum = 18612247;BA.debugLine="nr1 = total 'will make it possible to continiue c";
mostCurrent._nr1 = mostCurrent._total;
RDebugUtils.currentLine=18612248;
 //BA.debugLineNum = 18612248;BA.debugLine="totallb.Text = total & space";
mostCurrent._totallb.setText(BA.ObjectToCharSequence(mostCurrent._total+mostCurrent._space));
 } 
       catch (Exception e23) {
			processBA.setLastException(e23);RDebugUtils.currentLine=18612251;
 //BA.debugLineNum = 18612251;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("718612251",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=18612255;
 //BA.debugLineNum = 18612255;BA.debugLine="End Sub";
return "";
}
public static String  _nrbtn_click() throws Exception{
RDebugUtils.currentModule="calc_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nrbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nrbtn_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _btntag = "";
RDebugUtils.currentLine=18546688;
 //BA.debugLineNum = 18546688;BA.debugLine="Sub nrbtn_Click";
RDebugUtils.currentLine=18546690;
 //BA.debugLineNum = 18546690;BA.debugLine="Dim btn As Button = Sender 'get the pressed butto";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=18546691;
 //BA.debugLineNum = 18546691;BA.debugLine="Dim btntag As String = btn.Tag 'get the selected";
_btntag = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=18546694;
 //BA.debugLineNum = 18546694;BA.debugLine="If IsNumber(btntag) Then 'if the pressed buttonta";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_btntag)) { 
RDebugUtils.currentLine=18546695;
 //BA.debugLineNum = 18546695;BA.debugLine="If mathstr <> \"\" Then";
if ((mostCurrent._mathstr).equals("") == false) { 
RDebugUtils.currentLine=18546696;
 //BA.debugLineNum = 18546696;BA.debugLine="If nr2.Length = 1 Then";
if (mostCurrent._nr2.length()==1) { 
RDebugUtils.currentLine=18546697;
 //BA.debugLineNum = 18546697;BA.debugLine="If nr2 = \"0\" And btntag = \"0\" Then 'avoid type";
if ((mostCurrent._nr2).equals("0") && (_btntag).equals("0")) { 
RDebugUtils.currentLine=18546698;
 //BA.debugLineNum = 18546698;BA.debugLine="nr2 = \"0\"";
mostCurrent._nr2 = "0";
 }else {
RDebugUtils.currentLine=18546700;
 //BA.debugLineNum = 18546700;BA.debugLine="If nr2 = \"0\" And btntag <> \"0\" Then nr2 = btn";
if ((mostCurrent._nr2).equals("0") && (_btntag).equals("0") == false) { 
mostCurrent._nr2 = _btntag;}
else {
mostCurrent._nr2 = mostCurrent._nr2+_btntag;};
 };
 }else {
RDebugUtils.currentLine=18546703;
 //BA.debugLineNum = 18546703;BA.debugLine="nr2 = nr2 & btntag";
mostCurrent._nr2 = mostCurrent._nr2+_btntag;
 };
RDebugUtils.currentLine=18546705;
 //BA.debugLineNum = 18546705;BA.debugLine="totallb.Text = nr2 & space";
mostCurrent._totallb.setText(BA.ObjectToCharSequence(mostCurrent._nr2+mostCurrent._space));
 }else {
RDebugUtils.currentLine=18546707;
 //BA.debugLineNum = 18546707;BA.debugLine="If nr1.Length = 1 Then";
if (mostCurrent._nr1.length()==1) { 
RDebugUtils.currentLine=18546708;
 //BA.debugLineNum = 18546708;BA.debugLine="If nr1 = \"0\" And btntag = \"0\" Then 'avoid type";
if ((mostCurrent._nr1).equals("0") && (_btntag).equals("0")) { 
RDebugUtils.currentLine=18546709;
 //BA.debugLineNum = 18546709;BA.debugLine="nr1 = \"0\"";
mostCurrent._nr1 = "0";
 }else {
RDebugUtils.currentLine=18546711;
 //BA.debugLineNum = 18546711;BA.debugLine="If nr1 = \"0\" And btntag <> \"0\" Then nr1 = btn";
if ((mostCurrent._nr1).equals("0") && (_btntag).equals("0") == false) { 
mostCurrent._nr1 = _btntag;}
else {
mostCurrent._nr1 = mostCurrent._nr1+_btntag;};
 };
 }else {
RDebugUtils.currentLine=18546714;
 //BA.debugLineNum = 18546714;BA.debugLine="nr1 = nr1 & btntag";
mostCurrent._nr1 = mostCurrent._nr1+_btntag;
 };
RDebugUtils.currentLine=18546716;
 //BA.debugLineNum = 18546716;BA.debugLine="totallb.Text = nr1 & space";
mostCurrent._totallb.setText(BA.ObjectToCharSequence(mostCurrent._nr1+mostCurrent._space));
 };
 }else {
RDebugUtils.currentLine=18546719;
 //BA.debugLineNum = 18546719;BA.debugLine="If nr1 = \"\" Then Return 'exit if nr is empty";
if ((mostCurrent._nr1).equals("")) { 
if (true) return "";};
RDebugUtils.currentLine=18546722;
 //BA.debugLineNum = 18546722;BA.debugLine="Select btntag";
switch (BA.switchObjectToInt(_btntag,"plus","minus","mul","div","eq","AC",".")) {
case 0: {
RDebugUtils.currentLine=18546724;
 //BA.debugLineNum = 18546724;BA.debugLine="If mathstr = \"\" Then mathstr = btntag Else doc";
if ((mostCurrent._mathstr).equals("")) { 
mostCurrent._mathstr = _btntag;}
else {
_docalc(mostCurrent._mathstr,_btntag);};
 break; }
case 1: {
RDebugUtils.currentLine=18546726;
 //BA.debugLineNum = 18546726;BA.debugLine="If mathstr = \"\" Then mathstr = btntag Else doc";
if ((mostCurrent._mathstr).equals("")) { 
mostCurrent._mathstr = _btntag;}
else {
_docalc(mostCurrent._mathstr,_btntag);};
 break; }
case 2: {
RDebugUtils.currentLine=18546728;
 //BA.debugLineNum = 18546728;BA.debugLine="If mathstr = \"\" Then mathstr = btntag Else doc";
if ((mostCurrent._mathstr).equals("")) { 
mostCurrent._mathstr = _btntag;}
else {
_docalc(mostCurrent._mathstr,_btntag);};
 break; }
case 3: {
RDebugUtils.currentLine=18546730;
 //BA.debugLineNum = 18546730;BA.debugLine="If mathstr = \"\" Then mathstr = btntag Else doc";
if ((mostCurrent._mathstr).equals("")) { 
mostCurrent._mathstr = _btntag;}
else {
_docalc(mostCurrent._mathstr,_btntag);};
 break; }
case 4: {
RDebugUtils.currentLine=18546732;
 //BA.debugLineNum = 18546732;BA.debugLine="docalc(mathstr,\"\") 'if button pressed is = the";
_docalc(mostCurrent._mathstr,"");
 break; }
case 5: {
RDebugUtils.currentLine=18546734;
 //BA.debugLineNum = 18546734;BA.debugLine="totallb.Text = \"0\" & space";
mostCurrent._totallb.setText(BA.ObjectToCharSequence("0"+mostCurrent._space));
RDebugUtils.currentLine=18546735;
 //BA.debugLineNum = 18546735;BA.debugLine="nr1 = \"\"";
mostCurrent._nr1 = "";
RDebugUtils.currentLine=18546736;
 //BA.debugLineNum = 18546736;BA.debugLine="nr2 = \"\"";
mostCurrent._nr2 = "";
RDebugUtils.currentLine=18546737;
 //BA.debugLineNum = 18546737;BA.debugLine="mathstr = \"\"";
mostCurrent._mathstr = "";
RDebugUtils.currentLine=18546738;
 //BA.debugLineNum = 18546738;BA.debugLine="total = \"\"";
mostCurrent._total = "";
 break; }
case 6: {
RDebugUtils.currentLine=18546740;
 //BA.debugLineNum = 18546740;BA.debugLine="If mathstr <> \"\" Then";
if ((mostCurrent._mathstr).equals("") == false) { 
RDebugUtils.currentLine=18546741;
 //BA.debugLineNum = 18546741;BA.debugLine="If Not(nr2.Contains(\".\")) Then nr2 = nr2 & \".";
if (anywheresoftware.b4a.keywords.Common.Not(mostCurrent._nr2.contains("."))) { 
mostCurrent._nr2 = mostCurrent._nr2+".";};
RDebugUtils.currentLine=18546742;
 //BA.debugLineNum = 18546742;BA.debugLine="totallb.Text = nr2 & space";
mostCurrent._totallb.setText(BA.ObjectToCharSequence(mostCurrent._nr2+mostCurrent._space));
 }else {
RDebugUtils.currentLine=18546744;
 //BA.debugLineNum = 18546744;BA.debugLine="If nr1 = \"\" And totallb.Text = \"0\" Then nr1 =";
if ((mostCurrent._nr1).equals("") && (mostCurrent._totallb.getText()).equals("0")) { 
mostCurrent._nr1 = "0";};
RDebugUtils.currentLine=18546745;
 //BA.debugLineNum = 18546745;BA.debugLine="If Not(nr1.Contains(\".\")) Then nr1 = nr1 & \".";
if (anywheresoftware.b4a.keywords.Common.Not(mostCurrent._nr1.contains("."))) { 
mostCurrent._nr1 = mostCurrent._nr1+".";};
RDebugUtils.currentLine=18546746;
 //BA.debugLineNum = 18546746;BA.debugLine="totallb.Text = nr1 & space";
mostCurrent._totallb.setText(BA.ObjectToCharSequence(mostCurrent._nr1+mostCurrent._space));
 };
 break; }
}
;
 };
RDebugUtils.currentLine=18546751;
 //BA.debugLineNum = 18546751;BA.debugLine="End Sub";
return "";
}
}