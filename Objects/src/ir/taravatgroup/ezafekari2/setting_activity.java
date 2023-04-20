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

public class setting_activity extends Activity implements B4AActivity{
	public static setting_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.setting_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (setting_activity).");
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
		activityBA = new BA(this, layout, processBA, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.setting_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.setting_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (setting_activity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (setting_activity) Resume **");
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
		return setting_activity.class;
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
            BA.LogInfo("** Activity (setting_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (setting_activity) Pause event (activity is not paused). **");
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
            setting_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (setting_activity) Resume **");
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
public static anywheresoftware.b4a.phone.Phone.ContentChooser _cc = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_colors = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_save_color = null;
public anywheresoftware.b4a.objects.LabelWrapper _tik1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _tik2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _tik3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _tik4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _tik5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _tik6 = null;
public static int _color1 = 0;
public static int _color2 = 0;
public static int _color3 = 0;
public static int _color4 = 0;
public static int _color5 = 0;
public static int _color_index = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pan_hed_setting = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _sp_font = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_skb_f1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_skb_f2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_skb_f3 = null;
public anywheresoftware.b4a.objects.SeekBarWrapper _skb_f1 = null;
public anywheresoftware.b4a.objects.SeekBarWrapper _skb_f2 = null;
public anywheresoftware.b4a.objects.SeekBarWrapper _skb_f3 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_help = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _togglebtn_offon_lock = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _togglebtn_finger = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_pass_lock = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_lock = null;
public ir.taravatgroup.ezafekari2.fingerprintmanager _fingerprint1 = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _sc_view_items = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_hint_lock = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _tog_maliat = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _tog_bime = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _tog_food = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _tog_vam = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _tog_ayab = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _tog_padash = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _tog_sayer = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _tog_mosaede = null;
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
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=34406400;
 //BA.debugLineNum = 34406400;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=34406402;
 //BA.debugLineNum = 34406402;BA.debugLine="Activity.LoadLayout(\"setting_layout\")";
mostCurrent._activity.LoadLayout("setting_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=34406403;
 //BA.debugLineNum = 34406403;BA.debugLine="sc_view_items.Panel.LoadLayout(\"setting_layout_it";
mostCurrent._sc_view_items.getPanel().LoadLayout("setting_layout_items",mostCurrent.activityBA);
RDebugUtils.currentLine=34406407;
 //BA.debugLineNum = 34406407;BA.debugLine="pan_hed_setting.Color=Main.color4";
mostCurrent._pan_hed_setting.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=34406408;
 //BA.debugLineNum = 34406408;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=34406411;
 //BA.debugLineNum = 34406411;BA.debugLine="sp_font.Add(\"یکان\")";
mostCurrent._sp_font.Add("یکان");
RDebugUtils.currentLine=34406412;
 //BA.debugLineNum = 34406412;BA.debugLine="sp_font.Add(\"نازنین\")";
mostCurrent._sp_font.Add("نازنین");
RDebugUtils.currentLine=34406413;
 //BA.debugLineNum = 34406413;BA.debugLine="sp_font.Add(\"وزیر\")";
mostCurrent._sp_font.Add("وزیر");
RDebugUtils.currentLine=34406414;
 //BA.debugLineNum = 34406414;BA.debugLine="sp_font.Add(\"دست نویس\")";
mostCurrent._sp_font.Add("دست نویس");
RDebugUtils.currentLine=34406415;
 //BA.debugLineNum = 34406415;BA.debugLine="sp_font.Add(\"کودک\")";
mostCurrent._sp_font.Add("کودک");
RDebugUtils.currentLine=34406418;
 //BA.debugLineNum = 34406418;BA.debugLine="skb_f1.Value=Main.size_f1";
mostCurrent._skb_f1.setValue(mostCurrent._main._size_f1 /*int*/ );
RDebugUtils.currentLine=34406419;
 //BA.debugLineNum = 34406419;BA.debugLine="skb_f2.Value=Main.size_f2";
mostCurrent._skb_f2.setValue(mostCurrent._main._size_f2 /*int*/ );
RDebugUtils.currentLine=34406420;
 //BA.debugLineNum = 34406420;BA.debugLine="skb_f3.Value=Main.size_f3";
mostCurrent._skb_f3.setValue(mostCurrent._main._size_f3 /*int*/ );
RDebugUtils.currentLine=34406422;
 //BA.debugLineNum = 34406422;BA.debugLine="lbl_skb_f1.Text=Main.size_f1";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f1 /*int*/ ));
RDebugUtils.currentLine=34406423;
 //BA.debugLineNum = 34406423;BA.debugLine="lbl_skb_f2.Text=Main.size_f2";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f2 /*int*/ ));
RDebugUtils.currentLine=34406424;
 //BA.debugLineNum = 34406424;BA.debugLine="lbl_skb_f3.Text=Main.size_f3";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f3 /*int*/ ));
RDebugUtils.currentLine=34406428;
 //BA.debugLineNum = 34406428;BA.debugLine="chek_db_togels";
_chek_db_togels();
RDebugUtils.currentLine=34406430;
 //BA.debugLineNum = 34406430;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=34406432;
 //BA.debugLineNum = 34406432;BA.debugLine="sp_font.SelectedIndex=sp_font.IndexOf(Main.main_f";
mostCurrent._sp_font.setSelectedIndex(mostCurrent._sp_font.IndexOf(mostCurrent._main._main_font /*String*/ ));
RDebugUtils.currentLine=34406434;
 //BA.debugLineNum = 34406434;BA.debugLine="End Sub";
return "";
}
public static String  _chek_db_togels() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chek_db_togels", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chek_db_togels", null));}
RDebugUtils.currentLine=34603008;
 //BA.debugLineNum = 34603008;BA.debugLine="Sub chek_db_togels";
RDebugUtils.currentLine=34603009;
 //BA.debugLineNum = 34603009;BA.debugLine="If(dbCode.get_setting_byName(\"tog_maliat\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_maliat")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=34603010;
 //BA.debugLineNum = 34603010;BA.debugLine="tog_maliat.Checked=True";
mostCurrent._tog_maliat.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=34603012;
 //BA.debugLineNum = 34603012;BA.debugLine="tog_maliat.Checked=False";
mostCurrent._tog_maliat.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=34603015;
 //BA.debugLineNum = 34603015;BA.debugLine="If(dbCode.get_setting_byName(\"tog_bime\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_bime")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=34603016;
 //BA.debugLineNum = 34603016;BA.debugLine="tog_bime.Checked=True";
mostCurrent._tog_bime.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=34603018;
 //BA.debugLineNum = 34603018;BA.debugLine="tog_bime.Checked=False";
mostCurrent._tog_bime.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=34603021;
 //BA.debugLineNum = 34603021;BA.debugLine="If(dbCode.get_setting_byName(\"tog_food\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=34603022;
 //BA.debugLineNum = 34603022;BA.debugLine="tog_food.Checked=True";
mostCurrent._tog_food.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=34603024;
 //BA.debugLineNum = 34603024;BA.debugLine="tog_food.Checked=False";
mostCurrent._tog_food.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=34603027;
 //BA.debugLineNum = 34603027;BA.debugLine="If(dbCode.get_setting_byName(\"tog_vam\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_vam")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=34603028;
 //BA.debugLineNum = 34603028;BA.debugLine="tog_vam.Checked=True";
mostCurrent._tog_vam.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=34603030;
 //BA.debugLineNum = 34603030;BA.debugLine="tog_vam.Checked=False";
mostCurrent._tog_vam.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=34603033;
 //BA.debugLineNum = 34603033;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=34603034;
 //BA.debugLineNum = 34603034;BA.debugLine="tog_ayab.Checked=True";
mostCurrent._tog_ayab.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=34603036;
 //BA.debugLineNum = 34603036;BA.debugLine="tog_ayab.Checked=False";
mostCurrent._tog_ayab.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=34603039;
 //BA.debugLineNum = 34603039;BA.debugLine="If(dbCode.get_setting_byName(\"tog_padash\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_padash")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=34603040;
 //BA.debugLineNum = 34603040;BA.debugLine="tog_padash.Checked=True";
mostCurrent._tog_padash.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=34603042;
 //BA.debugLineNum = 34603042;BA.debugLine="tog_padash.Checked=False";
mostCurrent._tog_padash.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=34603045;
 //BA.debugLineNum = 34603045;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=34603046;
 //BA.debugLineNum = 34603046;BA.debugLine="tog_sayer.Checked=True";
mostCurrent._tog_sayer.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=34603048;
 //BA.debugLineNum = 34603048;BA.debugLine="tog_sayer.Checked=False";
mostCurrent._tog_sayer.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=34603051;
 //BA.debugLineNum = 34603051;BA.debugLine="If(dbCode.get_setting_byName(\"tog_mosaede\")=1)The";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_mosaede")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=34603052;
 //BA.debugLineNum = 34603052;BA.debugLine="tog_mosaede.Checked=True";
mostCurrent._tog_mosaede.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=34603054;
 //BA.debugLineNum = 34603054;BA.debugLine="tog_mosaede.Checked=False";
mostCurrent._tog_mosaede.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=34603057;
 //BA.debugLineNum = 34603057;BA.debugLine="End Sub";
return "";
}
public static String  _chek_togel() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chek_togel", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chek_togel", null));}
String _color_on = "";
String _color_off = "";
RDebugUtils.currentLine=36831232;
 //BA.debugLineNum = 36831232;BA.debugLine="Sub chek_togel";
RDebugUtils.currentLine=36831233;
 //BA.debugLineNum = 36831233;BA.debugLine="Dim color_on As String=0xFF059C00";
_color_on = BA.NumberToString(((int)0xff059c00));
RDebugUtils.currentLine=36831234;
 //BA.debugLineNum = 36831234;BA.debugLine="Dim color_off As String=0xFFE70300";
_color_off = BA.NumberToString(((int)0xffe70300));
RDebugUtils.currentLine=36831237;
 //BA.debugLineNum = 36831237;BA.debugLine="If(tog_maliat.Checked=True)Then";
if ((mostCurrent._tog_maliat.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=36831238;
 //BA.debugLineNum = 36831238;BA.debugLine="tog_maliat.TextColor=color_on";
mostCurrent._tog_maliat.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=36831240;
 //BA.debugLineNum = 36831240;BA.debugLine="tog_maliat.TextColor=color_off";
mostCurrent._tog_maliat.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=36831243;
 //BA.debugLineNum = 36831243;BA.debugLine="If(tog_bime.Checked=True)Then";
if ((mostCurrent._tog_bime.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=36831244;
 //BA.debugLineNum = 36831244;BA.debugLine="tog_bime.TextColor=color_on";
mostCurrent._tog_bime.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=36831246;
 //BA.debugLineNum = 36831246;BA.debugLine="tog_bime.TextColor=color_off";
mostCurrent._tog_bime.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=36831249;
 //BA.debugLineNum = 36831249;BA.debugLine="If( tog_food.Checked=True)Then";
if ((mostCurrent._tog_food.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=36831250;
 //BA.debugLineNum = 36831250;BA.debugLine="tog_food.TextColor=color_on";
mostCurrent._tog_food.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=36831252;
 //BA.debugLineNum = 36831252;BA.debugLine="tog_food.TextColor=color_off";
mostCurrent._tog_food.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=36831255;
 //BA.debugLineNum = 36831255;BA.debugLine="If(tog_vam.Checked=True)Then";
if ((mostCurrent._tog_vam.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=36831256;
 //BA.debugLineNum = 36831256;BA.debugLine="tog_vam.TextColor=color_on";
mostCurrent._tog_vam.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=36831258;
 //BA.debugLineNum = 36831258;BA.debugLine="tog_vam.TextColor=color_off";
mostCurrent._tog_vam.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=36831261;
 //BA.debugLineNum = 36831261;BA.debugLine="If( tog_ayab.Checked=True)Then";
if ((mostCurrent._tog_ayab.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=36831262;
 //BA.debugLineNum = 36831262;BA.debugLine="tog_ayab.TextColor=color_on";
mostCurrent._tog_ayab.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=36831264;
 //BA.debugLineNum = 36831264;BA.debugLine="tog_ayab.TextColor=color_off";
mostCurrent._tog_ayab.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=36831267;
 //BA.debugLineNum = 36831267;BA.debugLine="If(tog_padash.Checked=True)Then";
if ((mostCurrent._tog_padash.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=36831268;
 //BA.debugLineNum = 36831268;BA.debugLine="tog_padash.TextColor=color_on";
mostCurrent._tog_padash.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=36831270;
 //BA.debugLineNum = 36831270;BA.debugLine="tog_padash.TextColor=color_off";
mostCurrent._tog_padash.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=36831273;
 //BA.debugLineNum = 36831273;BA.debugLine="If(tog_sayer.Checked=True)Then";
if ((mostCurrent._tog_sayer.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=36831274;
 //BA.debugLineNum = 36831274;BA.debugLine="tog_sayer.TextColor=color_on";
mostCurrent._tog_sayer.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=36831276;
 //BA.debugLineNum = 36831276;BA.debugLine="tog_sayer.TextColor=color_off";
mostCurrent._tog_sayer.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=36831279;
 //BA.debugLineNum = 36831279;BA.debugLine="If(tog_mosaede.Checked=True)Then";
if ((mostCurrent._tog_mosaede.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=36831280;
 //BA.debugLineNum = 36831280;BA.debugLine="tog_mosaede.TextColor=color_on";
mostCurrent._tog_mosaede.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=36831282;
 //BA.debugLineNum = 36831282;BA.debugLine="tog_mosaede.TextColor=color_off";
mostCurrent._tog_mosaede.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=36831285;
 //BA.debugLineNum = 36831285;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=34668544;
 //BA.debugLineNum = 34668544;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=34668545;
 //BA.debugLineNum = 34668545;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=34668546;
 //BA.debugLineNum = 34668546;BA.debugLine="If(pan_all.Visible=True)Then";
if ((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=34668547;
 //BA.debugLineNum = 34668547;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=34668549;
 //BA.debugLineNum = 34668549;BA.debugLine="Else If (pan_all_help.Visible=True) Then";
if ((mostCurrent._pan_all_help.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=34668550;
 //BA.debugLineNum = 34668550;BA.debugLine="pan_all_help.Visible=False";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=34668551;
 //BA.debugLineNum = 34668551;BA.debugLine="Else If (pan_all2.Visible=True)Then";
if ((mostCurrent._pan_all2.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=34668552;
 //BA.debugLineNum = 34668552;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=34668553;
 //BA.debugLineNum = 34668553;BA.debugLine="Else If(pan_all_lock.Visible=True)Then";
if ((mostCurrent._pan_all_lock.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=34668554;
 //BA.debugLineNum = 34668554;BA.debugLine="pan_all_lock.Visible=False";
mostCurrent._pan_all_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=34668556;
 //BA.debugLineNum = 34668556;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 }}}}
;
RDebugUtils.currentLine=34668559;
 //BA.debugLineNum = 34668559;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=34668561;
 //BA.debugLineNum = 34668561;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=34668563;
 //BA.debugLineNum = 34668563;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=34734080;
 //BA.debugLineNum = 34734080;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=34734081;
 //BA.debugLineNum = 34734081;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=34734082;
 //BA.debugLineNum = 34734082;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=34734083;
 //BA.debugLineNum = 34734083;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="setting_activity";
RDebugUtils.currentLine=34537472;
 //BA.debugLineNum = 34537472;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=34537474;
 //BA.debugLineNum = 34537474;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=34471936;
 //BA.debugLineNum = 34471936;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=34471938;
 //BA.debugLineNum = 34471938;BA.debugLine="End Sub";
return "";
}
public static String  _et_pass_lock_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_pass_lock_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_pass_lock_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=36503552;
 //BA.debugLineNum = 36503552;BA.debugLine="Private Sub et_pass_lock_TextChanged (Old As Strin";
RDebugUtils.currentLine=36503553;
 //BA.debugLineNum = 36503553;BA.debugLine="If(New.Length>4)Then";
if ((_new.length()>4)) { 
RDebugUtils.currentLine=36503554;
 //BA.debugLineNum = 36503554;BA.debugLine="ToastMessageShow(\"رمز فقط 4 رقم باشد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("رمز فقط 4 رقم باشد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36503555;
 //BA.debugLineNum = 36503555;BA.debugLine="et_pass_lock.Text=Old";
mostCurrent._et_pass_lock.setText(BA.ObjectToCharSequence(_old));
 };
RDebugUtils.currentLine=36503557;
 //BA.debugLineNum = 36503557;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_backup_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_backup_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_backup_click", null));}
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
RDebugUtils.currentLine=34799616;
 //BA.debugLineNum = 34799616;BA.debugLine="Private Sub lbl_backup_Click";
RDebugUtils.currentLine=34799618;
 //BA.debugLineNum = 34799618;BA.debugLine="Dim FileName As String = \"db.db\"";
_filename = "db.db";
RDebugUtils.currentLine=34799621;
 //BA.debugLineNum = 34799621;BA.debugLine="File.Copy(File.DirInternal, FileName, Starter.Pro";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename,mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename);
RDebugUtils.currentLine=34799623;
 //BA.debugLineNum = 34799623;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=34799624;
 //BA.debugLineNum = 34799624;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
RDebugUtils.currentLine=34799625;
 //BA.debugLineNum = 34799625;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
RDebugUtils.currentLine=34799626;
 //BA.debugLineNum = 34799626;BA.debugLine="email.Body = \"backup-\"&DateTime.Date(DateTime.Now";
_email.Body = "backup-"+anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=34799627;
 //BA.debugLineNum = 34799627;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (null,_filename));
RDebugUtils.currentLine=34799629;
 //BA.debugLineNum = 34799629;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
RDebugUtils.currentLine=34799632;
 //BA.debugLineNum = 34799632;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
RDebugUtils.currentLine=34799633;
 //BA.debugLineNum = 34799633;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
RDebugUtils.currentLine=34799635;
 //BA.debugLineNum = 34799635;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_help_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_help_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_help_font_click", null));}
RDebugUtils.currentLine=36306944;
 //BA.debugLineNum = 36306944;BA.debugLine="Private Sub lbl_close_help_font_Click";
RDebugUtils.currentLine=36306945;
 //BA.debugLineNum = 36306945;BA.debugLine="pan_all_help.Visible=False";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36306946;
 //BA.debugLineNum = 36306946;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_color_home_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_color_home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_color_home_click", null));}
RDebugUtils.currentLine=35586048;
 //BA.debugLineNum = 35586048;BA.debugLine="Private Sub lbl_color_home_Click";
RDebugUtils.currentLine=35586049;
 //BA.debugLineNum = 35586049;BA.debugLine="lbl_color1_Click";
_lbl_color1_click();
RDebugUtils.currentLine=35586050;
 //BA.debugLineNum = 35586050;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_color1_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_color1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_color1_click", null));}
RDebugUtils.currentLine=34930688;
 //BA.debugLineNum = 34930688;BA.debugLine="Private Sub lbl_color1_Click";
RDebugUtils.currentLine=34930689;
 //BA.debugLineNum = 34930689;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=34930691;
 //BA.debugLineNum = 34930691;BA.debugLine="color_index=Main.color_index";
_color_index = mostCurrent._main._color_index /*int*/ ;
RDebugUtils.currentLine=34930693;
 //BA.debugLineNum = 34930693;BA.debugLine="Select color_index";
switch (_color_index) {
case 1: {
RDebugUtils.currentLine=34930695;
 //BA.debugLineNum = 34930695;BA.debugLine="pan_color1_Click";
_pan_color1_click();
 break; }
case 2: {
RDebugUtils.currentLine=34930697;
 //BA.debugLineNum = 34930697;BA.debugLine="pan_color2_Click";
_pan_color2_click();
 break; }
case 3: {
RDebugUtils.currentLine=34930699;
 //BA.debugLineNum = 34930699;BA.debugLine="pan_color3_Click";
_pan_color3_click();
 break; }
case 4: {
RDebugUtils.currentLine=34930701;
 //BA.debugLineNum = 34930701;BA.debugLine="pan_color4_Click";
_pan_color4_click();
 break; }
case 5: {
RDebugUtils.currentLine=34930703;
 //BA.debugLineNum = 34930703;BA.debugLine="pan_color5_Click";
_pan_color5_click();
 break; }
case 6: {
RDebugUtils.currentLine=34930705;
 //BA.debugLineNum = 34930705;BA.debugLine="pan_color6_Click";
_pan_color6_click();
 break; }
}
;
RDebugUtils.currentLine=34930712;
 //BA.debugLineNum = 34930712;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color1_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color1_click", null));}
RDebugUtils.currentLine=35389440;
 //BA.debugLineNum = 35389440;BA.debugLine="Private Sub pan_color1_Click";
RDebugUtils.currentLine=35389441;
 //BA.debugLineNum = 35389441;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=35389442;
 //BA.debugLineNum = 35389442;BA.debugLine="color1=0XFF69AC00";
_color1 = ((int)0xff69ac00);
RDebugUtils.currentLine=35389443;
 //BA.debugLineNum = 35389443;BA.debugLine="color2=0xFF00C7C7";
_color2 = ((int)0xff00c7c7);
RDebugUtils.currentLine=35389444;
 //BA.debugLineNum = 35389444;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=35389445;
 //BA.debugLineNum = 35389445;BA.debugLine="color4=0XFF69AC00";
_color4 = ((int)0xff69ac00);
RDebugUtils.currentLine=35389446;
 //BA.debugLineNum = 35389446;BA.debugLine="color5=0xFF00C7C7";
_color5 = ((int)0xff00c7c7);
RDebugUtils.currentLine=35389449;
 //BA.debugLineNum = 35389449;BA.debugLine="color_index=1";
_color_index = (int) (1);
RDebugUtils.currentLine=35389450;
 //BA.debugLineNum = 35389450;BA.debugLine="tik1.Visible=True";
mostCurrent._tik1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=35389452;
 //BA.debugLineNum = 35389452;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color2_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color2_click", null));}
RDebugUtils.currentLine=35323904;
 //BA.debugLineNum = 35323904;BA.debugLine="Private Sub pan_color2_Click";
RDebugUtils.currentLine=35323905;
 //BA.debugLineNum = 35323905;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=35323906;
 //BA.debugLineNum = 35323906;BA.debugLine="color1 = 0xFF7F19EE";
_color1 = ((int)0xff7f19ee);
RDebugUtils.currentLine=35323907;
 //BA.debugLineNum = 35323907;BA.debugLine="color2 = 0xFF567BFF";
_color2 = ((int)0xff567bff);
RDebugUtils.currentLine=35323908;
 //BA.debugLineNum = 35323908;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=35323909;
 //BA.debugLineNum = 35323909;BA.debugLine="color4=0xFF567BFF";
_color4 = ((int)0xff567bff);
RDebugUtils.currentLine=35323910;
 //BA.debugLineNum = 35323910;BA.debugLine="color5=0xFF567BFF";
_color5 = ((int)0xff567bff);
RDebugUtils.currentLine=35323914;
 //BA.debugLineNum = 35323914;BA.debugLine="color_index=2";
_color_index = (int) (2);
RDebugUtils.currentLine=35323915;
 //BA.debugLineNum = 35323915;BA.debugLine="tik2.Visible=True";
mostCurrent._tik2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=35323917;
 //BA.debugLineNum = 35323917;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color3_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color3_click", null));}
RDebugUtils.currentLine=35258368;
 //BA.debugLineNum = 35258368;BA.debugLine="Private Sub pan_color3_Click";
RDebugUtils.currentLine=35258369;
 //BA.debugLineNum = 35258369;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=35258370;
 //BA.debugLineNum = 35258370;BA.debugLine="color1 = 0xFF2BC1F6";
_color1 = ((int)0xff2bc1f6);
RDebugUtils.currentLine=35258371;
 //BA.debugLineNum = 35258371;BA.debugLine="color2 = 0xFF1E45D1";
_color2 = ((int)0xff1e45d1);
RDebugUtils.currentLine=35258372;
 //BA.debugLineNum = 35258372;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=35258373;
 //BA.debugLineNum = 35258373;BA.debugLine="color4=0xFF2BC1F6";
_color4 = ((int)0xff2bc1f6);
RDebugUtils.currentLine=35258374;
 //BA.debugLineNum = 35258374;BA.debugLine="color5=0xFF1E45D1";
_color5 = ((int)0xff1e45d1);
RDebugUtils.currentLine=35258379;
 //BA.debugLineNum = 35258379;BA.debugLine="color_index=3";
_color_index = (int) (3);
RDebugUtils.currentLine=35258380;
 //BA.debugLineNum = 35258380;BA.debugLine="tik3.Visible=True";
mostCurrent._tik3.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=35258381;
 //BA.debugLineNum = 35258381;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color4_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color4_click", null));}
RDebugUtils.currentLine=35192832;
 //BA.debugLineNum = 35192832;BA.debugLine="Private Sub pan_color4_Click";
RDebugUtils.currentLine=35192833;
 //BA.debugLineNum = 35192833;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=35192834;
 //BA.debugLineNum = 35192834;BA.debugLine="color1 = 0xFFDD00FF";
_color1 = ((int)0xffdd00ff);
RDebugUtils.currentLine=35192835;
 //BA.debugLineNum = 35192835;BA.debugLine="color2 = 0xFF0090FF";
_color2 = ((int)0xff0090ff);
RDebugUtils.currentLine=35192836;
 //BA.debugLineNum = 35192836;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=35192837;
 //BA.debugLineNum = 35192837;BA.debugLine="color4=0xFFDD00FF";
_color4 = ((int)0xffdd00ff);
RDebugUtils.currentLine=35192838;
 //BA.debugLineNum = 35192838;BA.debugLine="color5=0xFF24EB9D";
_color5 = ((int)0xff24eb9d);
RDebugUtils.currentLine=35192843;
 //BA.debugLineNum = 35192843;BA.debugLine="color_index=4";
_color_index = (int) (4);
RDebugUtils.currentLine=35192844;
 //BA.debugLineNum = 35192844;BA.debugLine="tik4.Visible=True";
mostCurrent._tik4.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=35192845;
 //BA.debugLineNum = 35192845;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color5_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color5_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color5_click", null));}
RDebugUtils.currentLine=35127296;
 //BA.debugLineNum = 35127296;BA.debugLine="Private Sub pan_color5_Click";
RDebugUtils.currentLine=35127297;
 //BA.debugLineNum = 35127297;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=35127298;
 //BA.debugLineNum = 35127298;BA.debugLine="color1 = 0xFFCF5263";
_color1 = ((int)0xffcf5263);
RDebugUtils.currentLine=35127299;
 //BA.debugLineNum = 35127299;BA.debugLine="color2 = 0xFFABC01A";
_color2 = ((int)0xffabc01a);
RDebugUtils.currentLine=35127300;
 //BA.debugLineNum = 35127300;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=35127301;
 //BA.debugLineNum = 35127301;BA.debugLine="color4=0xFFCF5263";
_color4 = ((int)0xffcf5263);
RDebugUtils.currentLine=35127302;
 //BA.debugLineNum = 35127302;BA.debugLine="color5=0xFFABC01A";
_color5 = ((int)0xffabc01a);
RDebugUtils.currentLine=35127306;
 //BA.debugLineNum = 35127306;BA.debugLine="color_index=5";
_color_index = (int) (5);
RDebugUtils.currentLine=35127307;
 //BA.debugLineNum = 35127307;BA.debugLine="tik5.Visible=True";
mostCurrent._tik5.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=35127308;
 //BA.debugLineNum = 35127308;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color6_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color6_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color6_click", null));}
RDebugUtils.currentLine=35061760;
 //BA.debugLineNum = 35061760;BA.debugLine="Private Sub pan_color6_Click";
RDebugUtils.currentLine=35061761;
 //BA.debugLineNum = 35061761;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=35061762;
 //BA.debugLineNum = 35061762;BA.debugLine="color1= 0xFF5289CF";
_color1 = ((int)0xff5289cf);
RDebugUtils.currentLine=35061763;
 //BA.debugLineNum = 35061763;BA.debugLine="color2= 0xFFABC01A";
_color2 = ((int)0xffabc01a);
RDebugUtils.currentLine=35061764;
 //BA.debugLineNum = 35061764;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=35061765;
 //BA.debugLineNum = 35061765;BA.debugLine="color4=0xFF5289CF";
_color4 = ((int)0xff5289cf);
RDebugUtils.currentLine=35061766;
 //BA.debugLineNum = 35061766;BA.debugLine="color5=0xFFABC01A";
_color5 = ((int)0xffabc01a);
RDebugUtils.currentLine=35061771;
 //BA.debugLineNum = 35061771;BA.debugLine="color_index=6";
_color_index = (int) (6);
RDebugUtils.currentLine=35061772;
 //BA.debugLineNum = 35061772;BA.debugLine="tik6.Visible=True";
mostCurrent._tik6.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=35061773;
 //BA.debugLineNum = 35061773;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_font_pan_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_font_pan_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_font_pan_click", null));}
RDebugUtils.currentLine=35717120;
 //BA.debugLineNum = 35717120;BA.debugLine="Private Sub lbl_font_pan_Click";
RDebugUtils.currentLine=35717121;
 //BA.debugLineNum = 35717121;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=35717127;
 //BA.debugLineNum = 35717127;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_font_click", null));}
RDebugUtils.currentLine=35848192;
 //BA.debugLineNum = 35848192;BA.debugLine="Private Sub lbl_help_font_Click";
RDebugUtils.currentLine=35848197;
 //BA.debugLineNum = 35848197;BA.debugLine="pan_all_help.Visible=True";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=35848198;
 //BA.debugLineNum = 35848198;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_lock_app_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_lock_app_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_lock_app_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_lock0 = null;
anywheresoftware.b4a.objects.collections.List _ls_lock3 = null;
RDebugUtils.currentLine=36372480;
 //BA.debugLineNum = 36372480;BA.debugLine="Private Sub lbl_lock_app_Click";
RDebugUtils.currentLine=36372482;
 //BA.debugLineNum = 36372482;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=True)T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=36372483;
 //BA.debugLineNum = 36372483;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=36372484;
 //BA.debugLineNum = 36372484;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
RDebugUtils.currentLine=36372486;
 //BA.debugLineNum = 36372486;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_lock";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
RDebugUtils.currentLine=36372488;
 //BA.debugLineNum = 36372488;BA.debugLine="If(ls_lock0.Get(0)=\"true\")Then";
if (((_ls_lock0.Get((int) (0))).equals((Object)("true")))) { 
RDebugUtils.currentLine=36372489;
 //BA.debugLineNum = 36372489;BA.debugLine="ToggleBtn_OffOn_lock.Checked=True";
mostCurrent._togglebtn_offon_lock.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=36372490;
 //BA.debugLineNum = 36372490;BA.debugLine="et_pass_lock.Enabled=True";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=36372491;
 //BA.debugLineNum = 36372491;BA.debugLine="et_pass_lock.Text=ls_lock0.Get(2)";
mostCurrent._et_pass_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (2))));
RDebugUtils.currentLine=36372492;
 //BA.debugLineNum = 36372492;BA.debugLine="et_hint_lock.Text=ls_lock0.Get(3)";
mostCurrent._et_hint_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (3))));
 }else {
RDebugUtils.currentLine=36372494;
 //BA.debugLineNum = 36372494;BA.debugLine="ToggleBtn_OffOn_lock.Checked=False";
mostCurrent._togglebtn_offon_lock.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36372495;
 //BA.debugLineNum = 36372495;BA.debugLine="ToggleBtn_finger.Enabled=False";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36372496;
 //BA.debugLineNum = 36372496;BA.debugLine="et_pass_lock.Enabled=False";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36372497;
 //BA.debugLineNum = 36372497;BA.debugLine="et_hint_lock.Enabled=False";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36372498;
 //BA.debugLineNum = 36372498;BA.debugLine="et_pass_lock.Text=\"\"";
mostCurrent._et_pass_lock.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=36372501;
 //BA.debugLineNum = 36372501;BA.debugLine="If(ls_lock0.Get(1)=\"true\")Then";
if (((_ls_lock0.Get((int) (1))).equals((Object)("true")))) { 
RDebugUtils.currentLine=36372502;
 //BA.debugLineNum = 36372502;BA.debugLine="ToggleBtn_finger.Checked=True";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=36372504;
 //BA.debugLineNum = 36372504;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=36372506;
 //BA.debugLineNum = 36372506;BA.debugLine="et_hint_lock.Text=ls_lock0.Get(3)";
mostCurrent._et_hint_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (3))));
 }else {
RDebugUtils.currentLine=36372509;
 //BA.debugLineNum = 36372509;BA.debugLine="Dim ls_lock3 As List";
_ls_lock3 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=36372510;
 //BA.debugLineNum = 36372510;BA.debugLine="ls_lock3.Initialize";
_ls_lock3.Initialize();
RDebugUtils.currentLine=36372512;
 //BA.debugLineNum = 36372512;BA.debugLine="ls_lock3.Add(\"false\")";
_ls_lock3.Add((Object)("false"));
RDebugUtils.currentLine=36372513;
 //BA.debugLineNum = 36372513;BA.debugLine="ls_lock3.Add(\"false\")";
_ls_lock3.Add((Object)("false"));
RDebugUtils.currentLine=36372514;
 //BA.debugLineNum = 36372514;BA.debugLine="ls_lock3.Add(\"\")";
_ls_lock3.Add((Object)(""));
RDebugUtils.currentLine=36372515;
 //BA.debugLineNum = 36372515;BA.debugLine="ls_lock3.Add(\"\")";
_ls_lock3.Add((Object)(""));
RDebugUtils.currentLine=36372518;
 //BA.debugLineNum = 36372518;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_loc";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock3);
RDebugUtils.currentLine=36372521;
 //BA.debugLineNum = 36372521;BA.debugLine="ToggleBtn_OffOn_lock.Checked=False";
mostCurrent._togglebtn_offon_lock.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36372522;
 //BA.debugLineNum = 36372522;BA.debugLine="ToggleBtn_finger.Enabled=False";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36372523;
 //BA.debugLineNum = 36372523;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36372524;
 //BA.debugLineNum = 36372524;BA.debugLine="et_pass_lock.Enabled=False";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36372525;
 //BA.debugLineNum = 36372525;BA.debugLine="et_hint_lock.Enabled=False";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=36372532;
 //BA.debugLineNum = 36372532;BA.debugLine="pan_all_lock.Visible=True";
mostCurrent._pan_all_lock.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=36372533;
 //BA.debugLineNum = 36372533;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_rest_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_rest_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_rest_font_click", null));}
RDebugUtils.currentLine=35782656;
 //BA.debugLineNum = 35782656;BA.debugLine="Private Sub lbl_rest_font_Click";
RDebugUtils.currentLine=35782657;
 //BA.debugLineNum = 35782657;BA.debugLine="sp_font.SelectedIndex=0";
mostCurrent._sp_font.setSelectedIndex((int) (0));
RDebugUtils.currentLine=35782659;
 //BA.debugLineNum = 35782659;BA.debugLine="skb_f1.Value=17";
mostCurrent._skb_f1.setValue((int) (17));
RDebugUtils.currentLine=35782660;
 //BA.debugLineNum = 35782660;BA.debugLine="skb_f2.Value=15";
mostCurrent._skb_f2.setValue((int) (15));
RDebugUtils.currentLine=35782661;
 //BA.debugLineNum = 35782661;BA.debugLine="skb_f3.Value=13";
mostCurrent._skb_f3.setValue((int) (13));
RDebugUtils.currentLine=35782663;
 //BA.debugLineNum = 35782663;BA.debugLine="lbl_skb_f1.Text=17";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(17));
RDebugUtils.currentLine=35782664;
 //BA.debugLineNum = 35782664;BA.debugLine="lbl_skb_f2.Text=15";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(15));
RDebugUtils.currentLine=35782665;
 //BA.debugLineNum = 35782665;BA.debugLine="lbl_skb_f3.Text=13";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(13));
RDebugUtils.currentLine=35782670;
 //BA.debugLineNum = 35782670;BA.debugLine="End Sub";
return "";
}
public static void  _lbl_restore_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_restore_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "lbl_restore_click", null); return;}
ResumableSub_lbl_restore_Click rsub = new ResumableSub_lbl_restore_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_lbl_restore_Click extends BA.ResumableSub {
public ResumableSub_lbl_restore_Click(ir.taravatgroup.ezafekari2.setting_activity parent) {
this.parent = parent;
}
ir.taravatgroup.ezafekari2.setting_activity parent;
boolean _success = false;
String _dir = "";
String _filename = "";
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="setting_activity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=34865153;
 //BA.debugLineNum = 34865153;BA.debugLine="cc.Initialize(\"CC\")";
parent._cc.Initialize("CC");
RDebugUtils.currentLine=34865154;
 //BA.debugLineNum = 34865154;BA.debugLine="cc.Show(\"*/*\", \"انتخاب فایل دیتابیس\")";
parent._cc.Show(processBA,"*/*","انتخاب فایل دیتابیس");
RDebugUtils.currentLine=34865155;
 //BA.debugLineNum = 34865155;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
anywheresoftware.b4a.keywords.Common.WaitFor("cc_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "setting_activity", "lbl_restore_click"), null);
this.state = 9;
return;
case 9:
//C
this.state = 1;
_success = (Boolean) result[0];
_dir = (String) result[1];
_filename = (String) result[2];
;
RDebugUtils.currentLine=34865156;
 //BA.debugLineNum = 34865156;BA.debugLine="If Success Then";
if (true) break;

case 1:
//if
this.state = 8;
if (_success) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=34865157;
 //BA.debugLineNum = 34865157;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.SharedFo";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db");
RDebugUtils.currentLine=34865159;
 //BA.debugLineNum = 34865159;BA.debugLine="Log( Dir)";
anywheresoftware.b4a.keywords.Common.LogImpl("234865159",_dir,0);
RDebugUtils.currentLine=34865160;
 //BA.debugLineNum = 34865160;BA.debugLine="Log(FileName)";
anywheresoftware.b4a.keywords.Common.LogImpl("234865160",_filename,0);
RDebugUtils.currentLine=34865161;
 //BA.debugLineNum = 34865161;BA.debugLine="Log(File.Exists(Starter.Provider.SharedFolder,\"d";
anywheresoftware.b4a.keywords.Common.LogImpl("234865161",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.File.Exists(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db")),0);
RDebugUtils.currentLine=34865163;
 //BA.debugLineNum = 34865163;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=34865165;
 //BA.debugLineNum = 34865165;BA.debugLine="result = Msgbox2(\"دیتای قبلی حذف و دیتای جدید جا";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("دیتای قبلی حذف و دیتای جدید جایگزین می شود."),BA.ObjectToCharSequence("توجه"),"باشه","","نه",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=34865166;
 //BA.debugLineNum = 34865166;BA.debugLine="If result = DialogResponse.Positive Then";
if (true) break;

case 4:
//if
this.state = 7;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=34865167;
 //BA.debugLineNum = 34865167;BA.debugLine="File.Copy(Starter.Provider.SharedFolder,\"db2.db";
anywheresoftware.b4a.keywords.Common.File.Copy(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db");
RDebugUtils.currentLine=34865168;
 //BA.debugLineNum = 34865168;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=34865169;
 //BA.debugLineNum = 34865169;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 if (true) break;

case 7:
//C
this.state = 8;
;
 if (true) break;

case 8:
//C
this.state = -1;
;
RDebugUtils.currentLine=34865175;
 //BA.debugLineNum = 34865175;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _lbl_save_color_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_color_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_color_click", null));}
RDebugUtils.currentLine=35454976;
 //BA.debugLineNum = 35454976;BA.debugLine="Private Sub lbl_save_color_Click";
RDebugUtils.currentLine=35454977;
 //BA.debugLineNum = 35454977;BA.debugLine="Main.color1=color1";
mostCurrent._main._color1 /*int*/  = _color1;
RDebugUtils.currentLine=35454978;
 //BA.debugLineNum = 35454978;BA.debugLine="Main.color2=color2";
mostCurrent._main._color2 /*int*/  = _color2;
RDebugUtils.currentLine=35454979;
 //BA.debugLineNum = 35454979;BA.debugLine="Main.color3=color3";
mostCurrent._main._color3 /*int*/  = _color3;
RDebugUtils.currentLine=35454980;
 //BA.debugLineNum = 35454980;BA.debugLine="Main.color4=color4";
mostCurrent._main._color4 /*int*/  = _color4;
RDebugUtils.currentLine=35454981;
 //BA.debugLineNum = 35454981;BA.debugLine="Main.color5=color5";
mostCurrent._main._color5 /*int*/  = _color5;
RDebugUtils.currentLine=35454982;
 //BA.debugLineNum = 35454982;BA.debugLine="Main.color_index=color_index";
mostCurrent._main._color_index /*int*/  = _color_index;
RDebugUtils.currentLine=35454984;
 //BA.debugLineNum = 35454984;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(mostCurrent._main._color1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color2 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color_index /*int*/ )+","+BA.NumberToString(mostCurrent._main._color3 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color4 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color5 /*int*/ )+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._main._main_font /*String*/ +","+BA.NumberToString(mostCurrent._main._size_f1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._size_f2 /*int*/ )+","+BA.NumberToString(mostCurrent._main._size_f3 /*int*/ ));
RDebugUtils.currentLine=35454986;
 //BA.debugLineNum = 35454986;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35454987;
 //BA.debugLineNum = 35454987;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35454991;
 //BA.debugLineNum = 35454991;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_font_click", null));}
RDebugUtils.currentLine=35913728;
 //BA.debugLineNum = 35913728;BA.debugLine="Private Sub lbl_save_font_Click";
RDebugUtils.currentLine=35913732;
 //BA.debugLineNum = 35913732;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(mostCurrent._main._color1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color2 /*int*/ )+","+BA.NumberToString(_color_index)+","+BA.NumberToString(mostCurrent._main._color3 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color4 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color5 /*int*/ )+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._sp_font.getSelectedItem()+","+BA.NumberToString(mostCurrent._skb_f1.getValue())+","+BA.NumberToString(mostCurrent._skb_f2.getValue())+","+BA.NumberToString(mostCurrent._skb_f3.getValue()));
RDebugUtils.currentLine=35913736;
 //BA.debugLineNum = 35913736;BA.debugLine="pan_all2_Click";
_pan_all2_click();
RDebugUtils.currentLine=35913737;
 //BA.debugLineNum = 35913737;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35913741;
 //BA.debugLineNum = 35913741;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all2_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all2_click", null));}
RDebugUtils.currentLine=36175872;
 //BA.debugLineNum = 36175872;BA.debugLine="Private Sub pan_all2_Click";
RDebugUtils.currentLine=36175873;
 //BA.debugLineNum = 36175873;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36175874;
 //BA.debugLineNum = 36175874;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_lock_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_lock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_lock_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_lock = null;
RDebugUtils.currentLine=36438016;
 //BA.debugLineNum = 36438016;BA.debugLine="Private Sub lbl_save_lock_Click";
RDebugUtils.currentLine=36438017;
 //BA.debugLineNum = 36438017;BA.debugLine="Dim ls_lock As List";
_ls_lock = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=36438018;
 //BA.debugLineNum = 36438018;BA.debugLine="ls_lock.Initialize";
_ls_lock.Initialize();
RDebugUtils.currentLine=36438022;
 //BA.debugLineNum = 36438022;BA.debugLine="If (ToggleBtn_OffOn_lock.Checked=True)Then";
if ((mostCurrent._togglebtn_offon_lock.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=36438023;
 //BA.debugLineNum = 36438023;BA.debugLine="If(et_pass_lock.Text.Length <> 4)Then";
if ((mostCurrent._et_pass_lock.getText().length()!=4)) { 
RDebugUtils.currentLine=36438024;
 //BA.debugLineNum = 36438024;BA.debugLine="ToastMessageShow(\"تعیین رمز\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تعیین رمز"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=36438028;
 //BA.debugLineNum = 36438028;BA.debugLine="ls_lock.Add(\"true\")";
_ls_lock.Add((Object)("true"));
RDebugUtils.currentLine=36438029;
 //BA.debugLineNum = 36438029;BA.debugLine="ls_lock.Add(ToggleBtn_finger.Checked)";
_ls_lock.Add((Object)(mostCurrent._togglebtn_finger.getChecked()));
RDebugUtils.currentLine=36438030;
 //BA.debugLineNum = 36438030;BA.debugLine="ls_lock.Add(et_pass_lock.Text)";
_ls_lock.Add((Object)(mostCurrent._et_pass_lock.getText()));
RDebugUtils.currentLine=36438031;
 //BA.debugLineNum = 36438031;BA.debugLine="ls_lock.Add(et_hint_lock.Text)";
_ls_lock.Add((Object)(mostCurrent._et_hint_lock.getText()));
RDebugUtils.currentLine=36438034;
 //BA.debugLineNum = 36438034;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_lo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock);
RDebugUtils.currentLine=36438036;
 //BA.debugLineNum = 36438036;BA.debugLine="pan_all_lock_Click";
_pan_all_lock_click();
 };
 }else {
RDebugUtils.currentLine=36438040;
 //BA.debugLineNum = 36438040;BA.debugLine="ls_lock.Add(\"false\")";
_ls_lock.Add((Object)("false"));
RDebugUtils.currentLine=36438041;
 //BA.debugLineNum = 36438041;BA.debugLine="ls_lock.Add(ToggleBtn_finger.Checked)";
_ls_lock.Add((Object)(mostCurrent._togglebtn_finger.getChecked()));
RDebugUtils.currentLine=36438042;
 //BA.debugLineNum = 36438042;BA.debugLine="ls_lock.Add(\"\")";
_ls_lock.Add((Object)(""));
RDebugUtils.currentLine=36438043;
 //BA.debugLineNum = 36438043;BA.debugLine="ls_lock.Add(\"\")";
_ls_lock.Add((Object)(""));
RDebugUtils.currentLine=36438044;
 //BA.debugLineNum = 36438044;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_loc";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock);
RDebugUtils.currentLine=36438045;
 //BA.debugLineNum = 36438045;BA.debugLine="pan_all_lock_Click";
_pan_all_lock_click();
 };
RDebugUtils.currentLine=36438049;
 //BA.debugLineNum = 36438049;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_lock_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_lock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_lock_click", null));}
RDebugUtils.currentLine=36634624;
 //BA.debugLineNum = 36634624;BA.debugLine="Private Sub pan_all_lock_Click";
RDebugUtils.currentLine=36634625;
 //BA.debugLineNum = 36634625;BA.debugLine="pan_all_lock.Visible=False";
mostCurrent._pan_all_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36634626;
 //BA.debugLineNum = 36634626;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=34996224;
 //BA.debugLineNum = 34996224;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=34996225;
 //BA.debugLineNum = 34996225;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=34996227;
 //BA.debugLineNum = 34996227;BA.debugLine="End Sub";
return "";
}
public static String  _tik_all_dis() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tik_all_dis", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tik_all_dis", null));}
RDebugUtils.currentLine=35520512;
 //BA.debugLineNum = 35520512;BA.debugLine="Sub tik_all_dis";
RDebugUtils.currentLine=35520513;
 //BA.debugLineNum = 35520513;BA.debugLine="tik1.Visible=False";
mostCurrent._tik1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35520514;
 //BA.debugLineNum = 35520514;BA.debugLine="tik2.Visible=False";
mostCurrent._tik2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35520515;
 //BA.debugLineNum = 35520515;BA.debugLine="tik3.Visible=False";
mostCurrent._tik3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35520516;
 //BA.debugLineNum = 35520516;BA.debugLine="tik4.Visible=False";
mostCurrent._tik4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35520517;
 //BA.debugLineNum = 35520517;BA.debugLine="tik5.Visible=False";
mostCurrent._tik5.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35520518;
 //BA.debugLineNum = 35520518;BA.debugLine="tik6.Visible=False";
mostCurrent._tik6.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35520519;
 //BA.debugLineNum = 35520519;BA.debugLine="End Sub";
return "";
}
public static String  _pan_colors_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_colors_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_colors_click", null));}
RDebugUtils.currentLine=35651584;
 //BA.debugLineNum = 35651584;BA.debugLine="Private Sub pan_colors_Click";
RDebugUtils.currentLine=35651586;
 //BA.debugLineNum = 35651586;BA.debugLine="End Sub";
return "";
}
public static String  _pan_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_font_click", null));}
RDebugUtils.currentLine=36241408;
 //BA.debugLineNum = 36241408;BA.debugLine="Private Sub pan_font_Click";
RDebugUtils.currentLine=36241410;
 //BA.debugLineNum = 36241410;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lock_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_lock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_lock_click", null));}
RDebugUtils.currentLine=36700160;
 //BA.debugLineNum = 36700160;BA.debugLine="Private Sub pan_lock_Click";
RDebugUtils.currentLine=36700162;
 //BA.debugLineNum = 36700162;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f1_valuechanged(int _value,boolean _userchanged) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "skb_f1_valuechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "skb_f1_valuechanged", new Object[] {_value,_userchanged}));}
RDebugUtils.currentLine=36110336;
 //BA.debugLineNum = 36110336;BA.debugLine="Private Sub skb_f1_ValueChanged (Value As Int, Use";
RDebugUtils.currentLine=36110337;
 //BA.debugLineNum = 36110337;BA.debugLine="lbl_skb_f1.Text=Value";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=36110338;
 //BA.debugLineNum = 36110338;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f2_valuechanged(int _value,boolean _userchanged) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "skb_f2_valuechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "skb_f2_valuechanged", new Object[] {_value,_userchanged}));}
RDebugUtils.currentLine=36044800;
 //BA.debugLineNum = 36044800;BA.debugLine="Private Sub skb_f2_ValueChanged (Value As Int, Use";
RDebugUtils.currentLine=36044801;
 //BA.debugLineNum = 36044801;BA.debugLine="lbl_skb_f2.Text=Value";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=36044802;
 //BA.debugLineNum = 36044802;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f3_valuechanged(int _value,boolean _userchanged) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "skb_f3_valuechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "skb_f3_valuechanged", new Object[] {_value,_userchanged}));}
RDebugUtils.currentLine=35979264;
 //BA.debugLineNum = 35979264;BA.debugLine="Private Sub skb_f3_ValueChanged (Value As Int, Use";
RDebugUtils.currentLine=35979265;
 //BA.debugLineNum = 35979265;BA.debugLine="lbl_skb_f3.Text=Value";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=35979266;
 //BA.debugLineNum = 35979266;BA.debugLine="End Sub";
return "";
}
public static String  _tog_ayab_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_ayab_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_ayab_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=37027840;
 //BA.debugLineNum = 37027840;BA.debugLine="Private Sub tog_ayab_CheckedChange(Checked As Bool";
RDebugUtils.currentLine=37027841;
 //BA.debugLineNum = 37027841;BA.debugLine="If(tog_ayab.Checked=True)Then";
if ((mostCurrent._tog_ayab.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=37027842;
 //BA.debugLineNum = 37027842;BA.debugLine="dbCode.update_setting_byname(\"tog_ayab\",\"1\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab","1");
 }else {
RDebugUtils.currentLine=37027844;
 //BA.debugLineNum = 37027844;BA.debugLine="dbCode.update_setting_byname(\"tog_ayab\",\"0\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab","0");
 };
RDebugUtils.currentLine=37027847;
 //BA.debugLineNum = 37027847;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=37027848;
 //BA.debugLineNum = 37027848;BA.debugLine="End Sub";
return "";
}
public static String  _tog_bime_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_bime_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_bime_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=37224448;
 //BA.debugLineNum = 37224448;BA.debugLine="Private Sub tog_bime_CheckedChange(Checked As Bool";
RDebugUtils.currentLine=37224450;
 //BA.debugLineNum = 37224450;BA.debugLine="If(tog_bime.Checked=True)Then";
if ((mostCurrent._tog_bime.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=37224451;
 //BA.debugLineNum = 37224451;BA.debugLine="dbCode.update_setting_byname(\"tog_bime\",1)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_bime",BA.NumberToString(1));
 }else {
RDebugUtils.currentLine=37224453;
 //BA.debugLineNum = 37224453;BA.debugLine="dbCode.update_setting_byname(\"tog_bime\",0)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_bime",BA.NumberToString(0));
 };
RDebugUtils.currentLine=37224456;
 //BA.debugLineNum = 37224456;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=37224457;
 //BA.debugLineNum = 37224457;BA.debugLine="End Sub";
return "";
}
public static String  _tog_food_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_food_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_food_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=37158912;
 //BA.debugLineNum = 37158912;BA.debugLine="Private Sub tog_food_CheckedChange(Checked As Bool";
RDebugUtils.currentLine=37158914;
 //BA.debugLineNum = 37158914;BA.debugLine="If(tog_food.Checked=True)Then";
if ((mostCurrent._tog_food.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=37158915;
 //BA.debugLineNum = 37158915;BA.debugLine="dbCode.update_setting_byname(\"tog_food\",\"1\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food","1");
 }else {
RDebugUtils.currentLine=37158917;
 //BA.debugLineNum = 37158917;BA.debugLine="dbCode.update_setting_byname(\"tog_food\",\"0\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food","0");
 };
RDebugUtils.currentLine=37158920;
 //BA.debugLineNum = 37158920;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=37158921;
 //BA.debugLineNum = 37158921;BA.debugLine="End Sub";
return "";
}
public static String  _tog_maliat_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_maliat_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_maliat_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=37289984;
 //BA.debugLineNum = 37289984;BA.debugLine="Private Sub tog_maliat_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=37289986;
 //BA.debugLineNum = 37289986;BA.debugLine="If(tog_maliat.Checked=True)Then";
if ((mostCurrent._tog_maliat.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=37289987;
 //BA.debugLineNum = 37289987;BA.debugLine="dbCode.update_setting_byname(\"tog_maliat\",1)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_maliat",BA.NumberToString(1));
 }else {
RDebugUtils.currentLine=37289989;
 //BA.debugLineNum = 37289989;BA.debugLine="dbCode.update_setting_byname(\"tog_maliat\",0)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_maliat",BA.NumberToString(0));
 };
RDebugUtils.currentLine=37289992;
 //BA.debugLineNum = 37289992;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=37289993;
 //BA.debugLineNum = 37289993;BA.debugLine="End Sub";
return "";
}
public static String  _tog_mosaede_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_mosaede_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_mosaede_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=37355520;
 //BA.debugLineNum = 37355520;BA.debugLine="Private Sub tog_mosaede_CheckedChange(Checked As B";
RDebugUtils.currentLine=37355522;
 //BA.debugLineNum = 37355522;BA.debugLine="If(tog_mosaede.Checked=True)Then";
if ((mostCurrent._tog_mosaede.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=37355523;
 //BA.debugLineNum = 37355523;BA.debugLine="dbCode.update_setting_byname(\"tog_mosaede\",1)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_mosaede",BA.NumberToString(1));
 }else {
RDebugUtils.currentLine=37355525;
 //BA.debugLineNum = 37355525;BA.debugLine="dbCode.update_setting_byname(\"tog_mosaede\",0)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_mosaede",BA.NumberToString(0));
 };
RDebugUtils.currentLine=37355528;
 //BA.debugLineNum = 37355528;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=37355530;
 //BA.debugLineNum = 37355530;BA.debugLine="End Sub";
return "";
}
public static String  _tog_padash_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_padash_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_padash_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=36962304;
 //BA.debugLineNum = 36962304;BA.debugLine="Private Sub tog_padash_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=36962305;
 //BA.debugLineNum = 36962305;BA.debugLine="If(tog_padash.Checked=True)Then";
if ((mostCurrent._tog_padash.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=36962306;
 //BA.debugLineNum = 36962306;BA.debugLine="dbCode.update_setting_byname(\"tog_padash\",\"1\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_padash","1");
 }else {
RDebugUtils.currentLine=36962308;
 //BA.debugLineNum = 36962308;BA.debugLine="dbCode.update_setting_byname(\"tog_padash\",\"0\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_padash","0");
 };
RDebugUtils.currentLine=36962311;
 //BA.debugLineNum = 36962311;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=36962312;
 //BA.debugLineNum = 36962312;BA.debugLine="End Sub";
return "";
}
public static String  _tog_sayer_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_sayer_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_sayer_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=36896768;
 //BA.debugLineNum = 36896768;BA.debugLine="Private Sub tog_sayer_CheckedChange(Checked As Boo";
RDebugUtils.currentLine=36896769;
 //BA.debugLineNum = 36896769;BA.debugLine="If(tog_sayer.Checked=True)Then";
if ((mostCurrent._tog_sayer.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=36896770;
 //BA.debugLineNum = 36896770;BA.debugLine="dbCode.update_setting_byname(\"tog_sayer\",\"1\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer","1");
 }else {
RDebugUtils.currentLine=36896772;
 //BA.debugLineNum = 36896772;BA.debugLine="dbCode.update_setting_byname(\"tog_sayer\",\"0\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer","0");
 };
RDebugUtils.currentLine=36896775;
 //BA.debugLineNum = 36896775;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=36896776;
 //BA.debugLineNum = 36896776;BA.debugLine="End Sub";
return "";
}
public static String  _tog_vam_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_vam_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_vam_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=37093376;
 //BA.debugLineNum = 37093376;BA.debugLine="Private Sub tog_vam_CheckedChange(Checked As Boole";
RDebugUtils.currentLine=37093378;
 //BA.debugLineNum = 37093378;BA.debugLine="If(tog_vam.Checked=True)Then";
if ((mostCurrent._tog_vam.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=37093379;
 //BA.debugLineNum = 37093379;BA.debugLine="dbCode.update_setting_byname(\"tog_vam\",\"1\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_vam","1");
 }else {
RDebugUtils.currentLine=37093381;
 //BA.debugLineNum = 37093381;BA.debugLine="dbCode.update_setting_byname(\"tog_vam\",\"0\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_vam","0");
 };
RDebugUtils.currentLine=37093384;
 //BA.debugLineNum = 37093384;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=37093385;
 //BA.debugLineNum = 37093385;BA.debugLine="End Sub";
return "";
}
public static String  _togglebtn_finger_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "togglebtn_finger_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "togglebtn_finger_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=36765696;
 //BA.debugLineNum = 36765696;BA.debugLine="Private Sub ToggleBtn_finger_CheckedChange(Checked";
RDebugUtils.currentLine=36765697;
 //BA.debugLineNum = 36765697;BA.debugLine="Try";
try {RDebugUtils.currentLine=36765698;
 //BA.debugLineNum = 36765698;BA.debugLine="fingerprint1.Initialize (Me, \"auth\")";
mostCurrent._fingerprint1._initialize /*String*/ (null,processBA,setting_activity.getObject(),"auth");
RDebugUtils.currentLine=36765699;
 //BA.debugLineNum = 36765699;BA.debugLine="If fingerprint1.HardwareDetected = False Then";
if (mostCurrent._fingerprint1._gethardwaredetected /*boolean*/ (null)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=36765700;
 //BA.debugLineNum = 36765700;BA.debugLine="ToastMessageShow(\"سنسور اثر انگشت موجود نیست\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("سنسور اثر انگشت موجود نیست"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=36765701;
 //BA.debugLineNum = 36765701;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=36765702;
 //BA.debugLineNum = 36765702;BA.debugLine="Else if fingerprint1.HasEnrolledFingerprints = F";
if (mostCurrent._fingerprint1._gethasenrolledfingerprints /*boolean*/ (null)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=36765703;
 //BA.debugLineNum = 36765703;BA.debugLine="ToastMessageShow(\"اثر انگشت تعریف نشده است\", Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اثر انگشت تعریف نشده است"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36765704;
 //BA.debugLineNum = 36765704;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }}
;
 } 
       catch (Exception e11) {
			processBA.setLastException(e11);RDebugUtils.currentLine=36765708;
 //BA.debugLineNum = 36765708;BA.debugLine="ToastMessageShow(\"سنسور اثر انگشت موجود نیست\", T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("سنسور اثر انگشت موجود نیست"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=36765709;
 //BA.debugLineNum = 36765709;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36765710;
 //BA.debugLineNum = 36765710;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("236765710",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=36765713;
 //BA.debugLineNum = 36765713;BA.debugLine="End Sub";
return "";
}
public static String  _togglebtn_offon_lock_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "togglebtn_offon_lock_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "togglebtn_offon_lock_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=36569088;
 //BA.debugLineNum = 36569088;BA.debugLine="Private Sub ToggleBtn_OffOn_lock_CheckedChange(Che";
RDebugUtils.currentLine=36569089;
 //BA.debugLineNum = 36569089;BA.debugLine="Try";
try {RDebugUtils.currentLine=36569090;
 //BA.debugLineNum = 36569090;BA.debugLine="If(ToggleBtn_OffOn_lock.Checked=False)Then";
if ((mostCurrent._togglebtn_offon_lock.getChecked()==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=36569091;
 //BA.debugLineNum = 36569091;BA.debugLine="et_pass_lock.Enabled=False";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36569092;
 //BA.debugLineNum = 36569092;BA.debugLine="ToggleBtn_finger.Enabled=False";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=36569093;
 //BA.debugLineNum = 36569093;BA.debugLine="et_hint_lock.Enabled=False";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=36569095;
 //BA.debugLineNum = 36569095;BA.debugLine="et_pass_lock.Enabled=True";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=36569096;
 //BA.debugLineNum = 36569096;BA.debugLine="ToggleBtn_finger.Enabled=True";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=36569097;
 //BA.debugLineNum = 36569097;BA.debugLine="et_hint_lock.Enabled=True";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e12) {
			processBA.setLastException(e12);RDebugUtils.currentLine=36569101;
 //BA.debugLineNum = 36569101;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("236569101",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=36569107;
 //BA.debugLineNum = 36569107;BA.debugLine="End Sub";
return "";
}
}