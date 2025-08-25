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
public anywheresoftware.b4a.objects.SpinnerWrapper _sp_backup_online = null;
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
int _res_backup = 0;
RDebugUtils.currentLine=49938432;
 //BA.debugLineNum = 49938432;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=49938434;
 //BA.debugLineNum = 49938434;BA.debugLine="Activity.LoadLayout(\"setting_layout\")";
mostCurrent._activity.LoadLayout("setting_layout",mostCurrent.activityBA);
RDebugUtils.currentLine=49938435;
 //BA.debugLineNum = 49938435;BA.debugLine="sc_view_items.Panel.LoadLayout(\"setting_layout_it";
mostCurrent._sc_view_items.getPanel().LoadLayout("setting_layout_items",mostCurrent.activityBA);
RDebugUtils.currentLine=49938439;
 //BA.debugLineNum = 49938439;BA.debugLine="pan_hed_setting.Color=Main.color4";
mostCurrent._pan_hed_setting.setColor(mostCurrent._main._color4 /*int*/ );
RDebugUtils.currentLine=49938440;
 //BA.debugLineNum = 49938440;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=49938443;
 //BA.debugLineNum = 49938443;BA.debugLine="sp_font.Add(\"یکان\")";
mostCurrent._sp_font.Add("یکان");
RDebugUtils.currentLine=49938444;
 //BA.debugLineNum = 49938444;BA.debugLine="sp_font.Add(\"نازنین\")";
mostCurrent._sp_font.Add("نازنین");
RDebugUtils.currentLine=49938445;
 //BA.debugLineNum = 49938445;BA.debugLine="sp_font.Add(\"وزیر\")";
mostCurrent._sp_font.Add("وزیر");
RDebugUtils.currentLine=49938446;
 //BA.debugLineNum = 49938446;BA.debugLine="sp_font.Add(\"دست نویس\")";
mostCurrent._sp_font.Add("دست نویس");
RDebugUtils.currentLine=49938447;
 //BA.debugLineNum = 49938447;BA.debugLine="sp_font.Add(\"کودک\")";
mostCurrent._sp_font.Add("کودک");
RDebugUtils.currentLine=49938450;
 //BA.debugLineNum = 49938450;BA.debugLine="skb_f1.Value=Main.size_f1";
mostCurrent._skb_f1.setValue(mostCurrent._main._size_f1 /*int*/ );
RDebugUtils.currentLine=49938451;
 //BA.debugLineNum = 49938451;BA.debugLine="skb_f2.Value=Main.size_f2";
mostCurrent._skb_f2.setValue(mostCurrent._main._size_f2 /*int*/ );
RDebugUtils.currentLine=49938452;
 //BA.debugLineNum = 49938452;BA.debugLine="skb_f3.Value=Main.size_f3";
mostCurrent._skb_f3.setValue(mostCurrent._main._size_f3 /*int*/ );
RDebugUtils.currentLine=49938454;
 //BA.debugLineNum = 49938454;BA.debugLine="lbl_skb_f1.Text=Main.size_f1";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f1 /*int*/ ));
RDebugUtils.currentLine=49938455;
 //BA.debugLineNum = 49938455;BA.debugLine="lbl_skb_f2.Text=Main.size_f2";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f2 /*int*/ ));
RDebugUtils.currentLine=49938456;
 //BA.debugLineNum = 49938456;BA.debugLine="lbl_skb_f3.Text=Main.size_f3";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f3 /*int*/ ));
RDebugUtils.currentLine=49938458;
 //BA.debugLineNum = 49938458;BA.debugLine="sp_backup_online.Add(\"1هفته\")";
mostCurrent._sp_backup_online.Add("1هفته");
RDebugUtils.currentLine=49938459;
 //BA.debugLineNum = 49938459;BA.debugLine="sp_backup_online.Add(\"2هفته\")";
mostCurrent._sp_backup_online.Add("2هفته");
RDebugUtils.currentLine=49938460;
 //BA.debugLineNum = 49938460;BA.debugLine="sp_backup_online.Add(\"1ماه\")";
mostCurrent._sp_backup_online.Add("1ماه");
RDebugUtils.currentLine=49938461;
 //BA.debugLineNum = 49938461;BA.debugLine="sp_backup_online.Add(\"غیرفعال\")";
mostCurrent._sp_backup_online.Add("غیرفعال");
RDebugUtils.currentLine=49938467;
 //BA.debugLineNum = 49938467;BA.debugLine="chek_db_togels";
_chek_db_togels();
RDebugUtils.currentLine=49938469;
 //BA.debugLineNum = 49938469;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=49938473;
 //BA.debugLineNum = 49938473;BA.debugLine="Dim res_backup As Int = dbCode.get_setting_byName";
_res_backup = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"backup_online")));
RDebugUtils.currentLine=49938474;
 //BA.debugLineNum = 49938474;BA.debugLine="Select res_backup";
switch (_res_backup) {
case 0: {
RDebugUtils.currentLine=49938476;
 //BA.debugLineNum = 49938476;BA.debugLine="sp_backup_online.SelectedIndex=0";
mostCurrent._sp_backup_online.setSelectedIndex((int) (0));
 break; }
case 1: {
RDebugUtils.currentLine=49938478;
 //BA.debugLineNum = 49938478;BA.debugLine="sp_backup_online.SelectedIndex=1";
mostCurrent._sp_backup_online.setSelectedIndex((int) (1));
 break; }
case 2: {
RDebugUtils.currentLine=49938480;
 //BA.debugLineNum = 49938480;BA.debugLine="sp_backup_online.SelectedIndex=2";
mostCurrent._sp_backup_online.setSelectedIndex((int) (2));
 break; }
case 3: {
RDebugUtils.currentLine=49938482;
 //BA.debugLineNum = 49938482;BA.debugLine="sp_backup_online.SelectedIndex=3";
mostCurrent._sp_backup_online.setSelectedIndex((int) (3));
 break; }
}
;
RDebugUtils.currentLine=49938489;
 //BA.debugLineNum = 49938489;BA.debugLine="sp_font.SelectedIndex=sp_font.IndexOf(Main.main_f";
mostCurrent._sp_font.setSelectedIndex(mostCurrent._sp_font.IndexOf(mostCurrent._main._main_font /*String*/ ));
RDebugUtils.currentLine=49938491;
 //BA.debugLineNum = 49938491;BA.debugLine="End Sub";
return "";
}
public static String  _chek_db_togels() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chek_db_togels", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chek_db_togels", null));}
RDebugUtils.currentLine=50135040;
 //BA.debugLineNum = 50135040;BA.debugLine="Sub chek_db_togels";
RDebugUtils.currentLine=50135041;
 //BA.debugLineNum = 50135041;BA.debugLine="If(dbCode.get_setting_byName(\"tog_maliat\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_maliat")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=50135042;
 //BA.debugLineNum = 50135042;BA.debugLine="tog_maliat.Checked=True";
mostCurrent._tog_maliat.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=50135044;
 //BA.debugLineNum = 50135044;BA.debugLine="tog_maliat.Checked=False";
mostCurrent._tog_maliat.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=50135047;
 //BA.debugLineNum = 50135047;BA.debugLine="If(dbCode.get_setting_byName(\"tog_bime\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_bime")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=50135048;
 //BA.debugLineNum = 50135048;BA.debugLine="tog_bime.Checked=True";
mostCurrent._tog_bime.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=50135050;
 //BA.debugLineNum = 50135050;BA.debugLine="tog_bime.Checked=False";
mostCurrent._tog_bime.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=50135053;
 //BA.debugLineNum = 50135053;BA.debugLine="If(dbCode.get_setting_byName(\"tog_food\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=50135054;
 //BA.debugLineNum = 50135054;BA.debugLine="tog_food.Checked=True";
mostCurrent._tog_food.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=50135056;
 //BA.debugLineNum = 50135056;BA.debugLine="tog_food.Checked=False";
mostCurrent._tog_food.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=50135059;
 //BA.debugLineNum = 50135059;BA.debugLine="If(dbCode.get_setting_byName(\"tog_vam\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_vam")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=50135060;
 //BA.debugLineNum = 50135060;BA.debugLine="tog_vam.Checked=True";
mostCurrent._tog_vam.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=50135062;
 //BA.debugLineNum = 50135062;BA.debugLine="tog_vam.Checked=False";
mostCurrent._tog_vam.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=50135065;
 //BA.debugLineNum = 50135065;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=50135066;
 //BA.debugLineNum = 50135066;BA.debugLine="tog_ayab.Checked=True";
mostCurrent._tog_ayab.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=50135068;
 //BA.debugLineNum = 50135068;BA.debugLine="tog_ayab.Checked=False";
mostCurrent._tog_ayab.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=50135071;
 //BA.debugLineNum = 50135071;BA.debugLine="If(dbCode.get_setting_byName(\"tog_padash\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_padash")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=50135072;
 //BA.debugLineNum = 50135072;BA.debugLine="tog_padash.Checked=True";
mostCurrent._tog_padash.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=50135074;
 //BA.debugLineNum = 50135074;BA.debugLine="tog_padash.Checked=False";
mostCurrent._tog_padash.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=50135077;
 //BA.debugLineNum = 50135077;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=50135078;
 //BA.debugLineNum = 50135078;BA.debugLine="tog_sayer.Checked=True";
mostCurrent._tog_sayer.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=50135080;
 //BA.debugLineNum = 50135080;BA.debugLine="tog_sayer.Checked=False";
mostCurrent._tog_sayer.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=50135083;
 //BA.debugLineNum = 50135083;BA.debugLine="If(dbCode.get_setting_byName(\"tog_mosaede\")=1)The";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_mosaede")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=50135084;
 //BA.debugLineNum = 50135084;BA.debugLine="tog_mosaede.Checked=True";
mostCurrent._tog_mosaede.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=50135086;
 //BA.debugLineNum = 50135086;BA.debugLine="tog_mosaede.Checked=False";
mostCurrent._tog_mosaede.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=50135089;
 //BA.debugLineNum = 50135089;BA.debugLine="End Sub";
return "";
}
public static String  _chek_togel() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chek_togel", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chek_togel", null));}
String _color_on = "";
String _color_off = "";
RDebugUtils.currentLine=52363264;
 //BA.debugLineNum = 52363264;BA.debugLine="Sub chek_togel";
RDebugUtils.currentLine=52363265;
 //BA.debugLineNum = 52363265;BA.debugLine="Dim color_on As String=0xFF059C00";
_color_on = BA.NumberToString(((int)0xff059c00));
RDebugUtils.currentLine=52363266;
 //BA.debugLineNum = 52363266;BA.debugLine="Dim color_off As String=0xFFE70300";
_color_off = BA.NumberToString(((int)0xffe70300));
RDebugUtils.currentLine=52363269;
 //BA.debugLineNum = 52363269;BA.debugLine="If(tog_maliat.Checked=True)Then";
if ((mostCurrent._tog_maliat.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52363270;
 //BA.debugLineNum = 52363270;BA.debugLine="tog_maliat.TextColor=color_on";
mostCurrent._tog_maliat.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=52363272;
 //BA.debugLineNum = 52363272;BA.debugLine="tog_maliat.TextColor=color_off";
mostCurrent._tog_maliat.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=52363275;
 //BA.debugLineNum = 52363275;BA.debugLine="If(tog_bime.Checked=True)Then";
if ((mostCurrent._tog_bime.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52363276;
 //BA.debugLineNum = 52363276;BA.debugLine="tog_bime.TextColor=color_on";
mostCurrent._tog_bime.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=52363278;
 //BA.debugLineNum = 52363278;BA.debugLine="tog_bime.TextColor=color_off";
mostCurrent._tog_bime.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=52363281;
 //BA.debugLineNum = 52363281;BA.debugLine="If( tog_food.Checked=True)Then";
if ((mostCurrent._tog_food.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52363282;
 //BA.debugLineNum = 52363282;BA.debugLine="tog_food.TextColor=color_on";
mostCurrent._tog_food.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=52363284;
 //BA.debugLineNum = 52363284;BA.debugLine="tog_food.TextColor=color_off";
mostCurrent._tog_food.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=52363287;
 //BA.debugLineNum = 52363287;BA.debugLine="If(tog_vam.Checked=True)Then";
if ((mostCurrent._tog_vam.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52363288;
 //BA.debugLineNum = 52363288;BA.debugLine="tog_vam.TextColor=color_on";
mostCurrent._tog_vam.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=52363290;
 //BA.debugLineNum = 52363290;BA.debugLine="tog_vam.TextColor=color_off";
mostCurrent._tog_vam.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=52363293;
 //BA.debugLineNum = 52363293;BA.debugLine="If( tog_ayab.Checked=True)Then";
if ((mostCurrent._tog_ayab.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52363294;
 //BA.debugLineNum = 52363294;BA.debugLine="tog_ayab.TextColor=color_on";
mostCurrent._tog_ayab.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=52363296;
 //BA.debugLineNum = 52363296;BA.debugLine="tog_ayab.TextColor=color_off";
mostCurrent._tog_ayab.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=52363299;
 //BA.debugLineNum = 52363299;BA.debugLine="If(tog_padash.Checked=True)Then";
if ((mostCurrent._tog_padash.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52363300;
 //BA.debugLineNum = 52363300;BA.debugLine="tog_padash.TextColor=color_on";
mostCurrent._tog_padash.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=52363302;
 //BA.debugLineNum = 52363302;BA.debugLine="tog_padash.TextColor=color_off";
mostCurrent._tog_padash.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=52363305;
 //BA.debugLineNum = 52363305;BA.debugLine="If(tog_sayer.Checked=True)Then";
if ((mostCurrent._tog_sayer.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52363306;
 //BA.debugLineNum = 52363306;BA.debugLine="tog_sayer.TextColor=color_on";
mostCurrent._tog_sayer.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=52363308;
 //BA.debugLineNum = 52363308;BA.debugLine="tog_sayer.TextColor=color_off";
mostCurrent._tog_sayer.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=52363311;
 //BA.debugLineNum = 52363311;BA.debugLine="If(tog_mosaede.Checked=True)Then";
if ((mostCurrent._tog_mosaede.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52363312;
 //BA.debugLineNum = 52363312;BA.debugLine="tog_mosaede.TextColor=color_on";
mostCurrent._tog_mosaede.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
RDebugUtils.currentLine=52363314;
 //BA.debugLineNum = 52363314;BA.debugLine="tog_mosaede.TextColor=color_off";
mostCurrent._tog_mosaede.setTextColor((int)(Double.parseDouble(_color_off)));
 };
RDebugUtils.currentLine=52363317;
 //BA.debugLineNum = 52363317;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=50200576;
 //BA.debugLineNum = 50200576;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=50200577;
 //BA.debugLineNum = 50200577;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=50200578;
 //BA.debugLineNum = 50200578;BA.debugLine="If(pan_all.Visible=True)Then";
if ((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=50200579;
 //BA.debugLineNum = 50200579;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=50200581;
 //BA.debugLineNum = 50200581;BA.debugLine="Else If (pan_all_help.Visible=True) Then";
if ((mostCurrent._pan_all_help.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=50200582;
 //BA.debugLineNum = 50200582;BA.debugLine="pan_all_help.Visible=False";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=50200583;
 //BA.debugLineNum = 50200583;BA.debugLine="Else If (pan_all2.Visible=True)Then";
if ((mostCurrent._pan_all2.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=50200584;
 //BA.debugLineNum = 50200584;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=50200585;
 //BA.debugLineNum = 50200585;BA.debugLine="Else If(pan_all_lock.Visible=True)Then";
if ((mostCurrent._pan_all_lock.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=50200586;
 //BA.debugLineNum = 50200586;BA.debugLine="pan_all_lock.Visible=False";
mostCurrent._pan_all_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=50200588;
 //BA.debugLineNum = 50200588;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 }}}}
;
RDebugUtils.currentLine=50200591;
 //BA.debugLineNum = 50200591;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=50200593;
 //BA.debugLineNum = 50200593;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=50200595;
 //BA.debugLineNum = 50200595;BA.debugLine="End Sub";
return false;
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=50266112;
 //BA.debugLineNum = 50266112;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=50266114;
 //BA.debugLineNum = 50266114;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=50266115;
 //BA.debugLineNum = 50266115;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=50266116;
 //BA.debugLineNum = 50266116;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="setting_activity";
RDebugUtils.currentLine=50069504;
 //BA.debugLineNum = 50069504;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=50069506;
 //BA.debugLineNum = 50069506;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=50003968;
 //BA.debugLineNum = 50003968;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=50003970;
 //BA.debugLineNum = 50003970;BA.debugLine="End Sub";
return "";
}
public static String  _et_pass_lock_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_pass_lock_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_pass_lock_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=52035584;
 //BA.debugLineNum = 52035584;BA.debugLine="Private Sub et_pass_lock_TextChanged (Old As Strin";
RDebugUtils.currentLine=52035585;
 //BA.debugLineNum = 52035585;BA.debugLine="If(New.Length>4)Then";
if ((_new.length()>4)) { 
RDebugUtils.currentLine=52035586;
 //BA.debugLineNum = 52035586;BA.debugLine="ToastMessageShow(\"رمز فقط 4 رقم باشد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("رمز فقط 4 رقم باشد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=52035587;
 //BA.debugLineNum = 52035587;BA.debugLine="et_pass_lock.Text=Old";
mostCurrent._et_pass_lock.setText(BA.ObjectToCharSequence(_old));
 };
RDebugUtils.currentLine=52035589;
 //BA.debugLineNum = 52035589;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_backup_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_backup_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_backup_click", null));}
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
RDebugUtils.currentLine=50331648;
 //BA.debugLineNum = 50331648;BA.debugLine="Private Sub lbl_backup_Click";
RDebugUtils.currentLine=50331650;
 //BA.debugLineNum = 50331650;BA.debugLine="Dim FileName As String = \"db.db\"";
_filename = "db.db";
RDebugUtils.currentLine=50331653;
 //BA.debugLineNum = 50331653;BA.debugLine="File.Copy(File.DirInternal, FileName, Starter.Pro";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename,mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename);
RDebugUtils.currentLine=50331655;
 //BA.debugLineNum = 50331655;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=50331656;
 //BA.debugLineNum = 50331656;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
RDebugUtils.currentLine=50331657;
 //BA.debugLineNum = 50331657;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
RDebugUtils.currentLine=50331658;
 //BA.debugLineNum = 50331658;BA.debugLine="email.Body = \"backup-\"&DateTime.Date(DateTime.Now";
_email.Body = "backup-"+anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=50331659;
 //BA.debugLineNum = 50331659;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (null,_filename));
RDebugUtils.currentLine=50331661;
 //BA.debugLineNum = 50331661;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
RDebugUtils.currentLine=50331664;
 //BA.debugLineNum = 50331664;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
RDebugUtils.currentLine=50331665;
 //BA.debugLineNum = 50331665;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
RDebugUtils.currentLine=50331667;
 //BA.debugLineNum = 50331667;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_help_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_close_help_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_close_help_font_click", null));}
RDebugUtils.currentLine=51838976;
 //BA.debugLineNum = 51838976;BA.debugLine="Private Sub lbl_close_help_font_Click";
RDebugUtils.currentLine=51838977;
 //BA.debugLineNum = 51838977;BA.debugLine="pan_all_help.Visible=False";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51838978;
 //BA.debugLineNum = 51838978;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_color_home_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_color_home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_color_home_click", null));}
RDebugUtils.currentLine=51118080;
 //BA.debugLineNum = 51118080;BA.debugLine="Private Sub lbl_color_home_Click";
RDebugUtils.currentLine=51118081;
 //BA.debugLineNum = 51118081;BA.debugLine="lbl_color1_Click";
_lbl_color1_click();
RDebugUtils.currentLine=51118082;
 //BA.debugLineNum = 51118082;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_color1_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_color1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_color1_click", null));}
RDebugUtils.currentLine=50462720;
 //BA.debugLineNum = 50462720;BA.debugLine="Private Sub lbl_color1_Click";
RDebugUtils.currentLine=50462721;
 //BA.debugLineNum = 50462721;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=50462723;
 //BA.debugLineNum = 50462723;BA.debugLine="color_index=Main.color_index";
_color_index = mostCurrent._main._color_index /*int*/ ;
RDebugUtils.currentLine=50462725;
 //BA.debugLineNum = 50462725;BA.debugLine="Select color_index";
switch (_color_index) {
case 1: {
RDebugUtils.currentLine=50462727;
 //BA.debugLineNum = 50462727;BA.debugLine="pan_color1_Click";
_pan_color1_click();
 break; }
case 2: {
RDebugUtils.currentLine=50462729;
 //BA.debugLineNum = 50462729;BA.debugLine="pan_color2_Click";
_pan_color2_click();
 break; }
case 3: {
RDebugUtils.currentLine=50462731;
 //BA.debugLineNum = 50462731;BA.debugLine="pan_color3_Click";
_pan_color3_click();
 break; }
case 4: {
RDebugUtils.currentLine=50462733;
 //BA.debugLineNum = 50462733;BA.debugLine="pan_color4_Click";
_pan_color4_click();
 break; }
case 5: {
RDebugUtils.currentLine=50462735;
 //BA.debugLineNum = 50462735;BA.debugLine="pan_color5_Click";
_pan_color5_click();
 break; }
case 6: {
RDebugUtils.currentLine=50462737;
 //BA.debugLineNum = 50462737;BA.debugLine="pan_color6_Click";
_pan_color6_click();
 break; }
}
;
RDebugUtils.currentLine=50462744;
 //BA.debugLineNum = 50462744;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color1_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color1_click", null));}
RDebugUtils.currentLine=50921472;
 //BA.debugLineNum = 50921472;BA.debugLine="Private Sub pan_color1_Click";
RDebugUtils.currentLine=50921473;
 //BA.debugLineNum = 50921473;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=50921474;
 //BA.debugLineNum = 50921474;BA.debugLine="color1=0XFF69AC00";
_color1 = ((int)0xff69ac00);
RDebugUtils.currentLine=50921475;
 //BA.debugLineNum = 50921475;BA.debugLine="color2=0xFF00C7C7";
_color2 = ((int)0xff00c7c7);
RDebugUtils.currentLine=50921476;
 //BA.debugLineNum = 50921476;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=50921477;
 //BA.debugLineNum = 50921477;BA.debugLine="color4=0XFF69AC00";
_color4 = ((int)0xff69ac00);
RDebugUtils.currentLine=50921478;
 //BA.debugLineNum = 50921478;BA.debugLine="color5=0xFF00C7C7";
_color5 = ((int)0xff00c7c7);
RDebugUtils.currentLine=50921481;
 //BA.debugLineNum = 50921481;BA.debugLine="color_index=1";
_color_index = (int) (1);
RDebugUtils.currentLine=50921482;
 //BA.debugLineNum = 50921482;BA.debugLine="tik1.Visible=True";
mostCurrent._tik1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=50921484;
 //BA.debugLineNum = 50921484;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color2_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color2_click", null));}
RDebugUtils.currentLine=50855936;
 //BA.debugLineNum = 50855936;BA.debugLine="Private Sub pan_color2_Click";
RDebugUtils.currentLine=50855937;
 //BA.debugLineNum = 50855937;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=50855938;
 //BA.debugLineNum = 50855938;BA.debugLine="color1 = 0xFF7F19EE";
_color1 = ((int)0xff7f19ee);
RDebugUtils.currentLine=50855939;
 //BA.debugLineNum = 50855939;BA.debugLine="color2 = 0xFF567BFF";
_color2 = ((int)0xff567bff);
RDebugUtils.currentLine=50855940;
 //BA.debugLineNum = 50855940;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=50855941;
 //BA.debugLineNum = 50855941;BA.debugLine="color4=0xFF567BFF";
_color4 = ((int)0xff567bff);
RDebugUtils.currentLine=50855942;
 //BA.debugLineNum = 50855942;BA.debugLine="color5=0xFF567BFF";
_color5 = ((int)0xff567bff);
RDebugUtils.currentLine=50855946;
 //BA.debugLineNum = 50855946;BA.debugLine="color_index=2";
_color_index = (int) (2);
RDebugUtils.currentLine=50855947;
 //BA.debugLineNum = 50855947;BA.debugLine="tik2.Visible=True";
mostCurrent._tik2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=50855949;
 //BA.debugLineNum = 50855949;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color3_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color3_click", null));}
RDebugUtils.currentLine=50790400;
 //BA.debugLineNum = 50790400;BA.debugLine="Private Sub pan_color3_Click";
RDebugUtils.currentLine=50790401;
 //BA.debugLineNum = 50790401;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=50790402;
 //BA.debugLineNum = 50790402;BA.debugLine="color1 = 0xFF2BC1F6";
_color1 = ((int)0xff2bc1f6);
RDebugUtils.currentLine=50790403;
 //BA.debugLineNum = 50790403;BA.debugLine="color2 = 0xFF1E45D1";
_color2 = ((int)0xff1e45d1);
RDebugUtils.currentLine=50790404;
 //BA.debugLineNum = 50790404;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=50790405;
 //BA.debugLineNum = 50790405;BA.debugLine="color4=0xFF2BC1F6";
_color4 = ((int)0xff2bc1f6);
RDebugUtils.currentLine=50790406;
 //BA.debugLineNum = 50790406;BA.debugLine="color5=0xFF1E45D1";
_color5 = ((int)0xff1e45d1);
RDebugUtils.currentLine=50790411;
 //BA.debugLineNum = 50790411;BA.debugLine="color_index=3";
_color_index = (int) (3);
RDebugUtils.currentLine=50790412;
 //BA.debugLineNum = 50790412;BA.debugLine="tik3.Visible=True";
mostCurrent._tik3.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=50790413;
 //BA.debugLineNum = 50790413;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color4_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color4_click", null));}
RDebugUtils.currentLine=50724864;
 //BA.debugLineNum = 50724864;BA.debugLine="Private Sub pan_color4_Click";
RDebugUtils.currentLine=50724865;
 //BA.debugLineNum = 50724865;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=50724866;
 //BA.debugLineNum = 50724866;BA.debugLine="color1 = 0xFFDD00FF";
_color1 = ((int)0xffdd00ff);
RDebugUtils.currentLine=50724867;
 //BA.debugLineNum = 50724867;BA.debugLine="color2 = 0xFF0090FF";
_color2 = ((int)0xff0090ff);
RDebugUtils.currentLine=50724868;
 //BA.debugLineNum = 50724868;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=50724869;
 //BA.debugLineNum = 50724869;BA.debugLine="color4=0xFFDD00FF";
_color4 = ((int)0xffdd00ff);
RDebugUtils.currentLine=50724870;
 //BA.debugLineNum = 50724870;BA.debugLine="color5=0xFF24EB9D";
_color5 = ((int)0xff24eb9d);
RDebugUtils.currentLine=50724875;
 //BA.debugLineNum = 50724875;BA.debugLine="color_index=4";
_color_index = (int) (4);
RDebugUtils.currentLine=50724876;
 //BA.debugLineNum = 50724876;BA.debugLine="tik4.Visible=True";
mostCurrent._tik4.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=50724877;
 //BA.debugLineNum = 50724877;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color5_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color5_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color5_click", null));}
RDebugUtils.currentLine=50659328;
 //BA.debugLineNum = 50659328;BA.debugLine="Private Sub pan_color5_Click";
RDebugUtils.currentLine=50659329;
 //BA.debugLineNum = 50659329;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=50659330;
 //BA.debugLineNum = 50659330;BA.debugLine="color1 = 0xFFCF5263";
_color1 = ((int)0xffcf5263);
RDebugUtils.currentLine=50659331;
 //BA.debugLineNum = 50659331;BA.debugLine="color2 = 0xFFABC01A";
_color2 = ((int)0xffabc01a);
RDebugUtils.currentLine=50659332;
 //BA.debugLineNum = 50659332;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=50659333;
 //BA.debugLineNum = 50659333;BA.debugLine="color4=0xFFCF5263";
_color4 = ((int)0xffcf5263);
RDebugUtils.currentLine=50659334;
 //BA.debugLineNum = 50659334;BA.debugLine="color5=0xFFABC01A";
_color5 = ((int)0xffabc01a);
RDebugUtils.currentLine=50659338;
 //BA.debugLineNum = 50659338;BA.debugLine="color_index=5";
_color_index = (int) (5);
RDebugUtils.currentLine=50659339;
 //BA.debugLineNum = 50659339;BA.debugLine="tik5.Visible=True";
mostCurrent._tik5.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=50659340;
 //BA.debugLineNum = 50659340;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color6_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_color6_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_color6_click", null));}
RDebugUtils.currentLine=50593792;
 //BA.debugLineNum = 50593792;BA.debugLine="Private Sub pan_color6_Click";
RDebugUtils.currentLine=50593793;
 //BA.debugLineNum = 50593793;BA.debugLine="tik_all_dis";
_tik_all_dis();
RDebugUtils.currentLine=50593794;
 //BA.debugLineNum = 50593794;BA.debugLine="color1= 0xFF5289CF";
_color1 = ((int)0xff5289cf);
RDebugUtils.currentLine=50593795;
 //BA.debugLineNum = 50593795;BA.debugLine="color2= 0xFFABC01A";
_color2 = ((int)0xffabc01a);
RDebugUtils.currentLine=50593796;
 //BA.debugLineNum = 50593796;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
RDebugUtils.currentLine=50593797;
 //BA.debugLineNum = 50593797;BA.debugLine="color4=0xFF5289CF";
_color4 = ((int)0xff5289cf);
RDebugUtils.currentLine=50593798;
 //BA.debugLineNum = 50593798;BA.debugLine="color5=0xFFABC01A";
_color5 = ((int)0xffabc01a);
RDebugUtils.currentLine=50593803;
 //BA.debugLineNum = 50593803;BA.debugLine="color_index=6";
_color_index = (int) (6);
RDebugUtils.currentLine=50593804;
 //BA.debugLineNum = 50593804;BA.debugLine="tik6.Visible=True";
mostCurrent._tik6.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=50593805;
 //BA.debugLineNum = 50593805;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_font_pan_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_font_pan_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_font_pan_click", null));}
RDebugUtils.currentLine=51249152;
 //BA.debugLineNum = 51249152;BA.debugLine="Private Sub lbl_font_pan_Click";
RDebugUtils.currentLine=51249153;
 //BA.debugLineNum = 51249153;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=51249159;
 //BA.debugLineNum = 51249159;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_help_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_help_font_click", null));}
RDebugUtils.currentLine=51380224;
 //BA.debugLineNum = 51380224;BA.debugLine="Private Sub lbl_help_font_Click";
RDebugUtils.currentLine=51380229;
 //BA.debugLineNum = 51380229;BA.debugLine="pan_all_help.Visible=True";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=51380230;
 //BA.debugLineNum = 51380230;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_lock_app_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_lock_app_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_lock_app_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_lock0 = null;
anywheresoftware.b4a.objects.collections.List _ls_lock3 = null;
RDebugUtils.currentLine=51904512;
 //BA.debugLineNum = 51904512;BA.debugLine="Private Sub lbl_lock_app_Click";
RDebugUtils.currentLine=51904514;
 //BA.debugLineNum = 51904514;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=True)T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=51904515;
 //BA.debugLineNum = 51904515;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=51904516;
 //BA.debugLineNum = 51904516;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
RDebugUtils.currentLine=51904518;
 //BA.debugLineNum = 51904518;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_lock";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
RDebugUtils.currentLine=51904520;
 //BA.debugLineNum = 51904520;BA.debugLine="If(ls_lock0.Get(0)=\"true\")Then";
if (((_ls_lock0.Get((int) (0))).equals((Object)("true")))) { 
RDebugUtils.currentLine=51904521;
 //BA.debugLineNum = 51904521;BA.debugLine="ToggleBtn_OffOn_lock.Checked=True";
mostCurrent._togglebtn_offon_lock.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=51904522;
 //BA.debugLineNum = 51904522;BA.debugLine="et_pass_lock.Enabled=True";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=51904523;
 //BA.debugLineNum = 51904523;BA.debugLine="et_pass_lock.Text=ls_lock0.Get(2)";
mostCurrent._et_pass_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (2))));
RDebugUtils.currentLine=51904524;
 //BA.debugLineNum = 51904524;BA.debugLine="et_hint_lock.Text=ls_lock0.Get(3)";
mostCurrent._et_hint_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (3))));
 }else {
RDebugUtils.currentLine=51904526;
 //BA.debugLineNum = 51904526;BA.debugLine="ToggleBtn_OffOn_lock.Checked=False";
mostCurrent._togglebtn_offon_lock.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51904527;
 //BA.debugLineNum = 51904527;BA.debugLine="ToggleBtn_finger.Enabled=False";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51904528;
 //BA.debugLineNum = 51904528;BA.debugLine="et_pass_lock.Enabled=False";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51904529;
 //BA.debugLineNum = 51904529;BA.debugLine="et_hint_lock.Enabled=False";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51904530;
 //BA.debugLineNum = 51904530;BA.debugLine="et_pass_lock.Text=\"\"";
mostCurrent._et_pass_lock.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=51904533;
 //BA.debugLineNum = 51904533;BA.debugLine="If(ls_lock0.Get(1)=\"true\")Then";
if (((_ls_lock0.Get((int) (1))).equals((Object)("true")))) { 
RDebugUtils.currentLine=51904534;
 //BA.debugLineNum = 51904534;BA.debugLine="ToggleBtn_finger.Checked=True";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=51904536;
 //BA.debugLineNum = 51904536;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=51904538;
 //BA.debugLineNum = 51904538;BA.debugLine="et_hint_lock.Text=ls_lock0.Get(3)";
mostCurrent._et_hint_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (3))));
 }else {
RDebugUtils.currentLine=51904541;
 //BA.debugLineNum = 51904541;BA.debugLine="Dim ls_lock3 As List";
_ls_lock3 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=51904542;
 //BA.debugLineNum = 51904542;BA.debugLine="ls_lock3.Initialize";
_ls_lock3.Initialize();
RDebugUtils.currentLine=51904544;
 //BA.debugLineNum = 51904544;BA.debugLine="ls_lock3.Add(\"false\")";
_ls_lock3.Add((Object)("false"));
RDebugUtils.currentLine=51904545;
 //BA.debugLineNum = 51904545;BA.debugLine="ls_lock3.Add(\"false\")";
_ls_lock3.Add((Object)("false"));
RDebugUtils.currentLine=51904546;
 //BA.debugLineNum = 51904546;BA.debugLine="ls_lock3.Add(\"\")";
_ls_lock3.Add((Object)(""));
RDebugUtils.currentLine=51904547;
 //BA.debugLineNum = 51904547;BA.debugLine="ls_lock3.Add(\"\")";
_ls_lock3.Add((Object)(""));
RDebugUtils.currentLine=51904550;
 //BA.debugLineNum = 51904550;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_loc";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock3);
RDebugUtils.currentLine=51904553;
 //BA.debugLineNum = 51904553;BA.debugLine="ToggleBtn_OffOn_lock.Checked=False";
mostCurrent._togglebtn_offon_lock.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51904554;
 //BA.debugLineNum = 51904554;BA.debugLine="ToggleBtn_finger.Enabled=False";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51904555;
 //BA.debugLineNum = 51904555;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51904556;
 //BA.debugLineNum = 51904556;BA.debugLine="et_pass_lock.Enabled=False";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51904557;
 //BA.debugLineNum = 51904557;BA.debugLine="et_hint_lock.Enabled=False";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=51904564;
 //BA.debugLineNum = 51904564;BA.debugLine="pan_all_lock.Visible=True";
mostCurrent._pan_all_lock.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=51904565;
 //BA.debugLineNum = 51904565;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_rest_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_rest_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_rest_font_click", null));}
RDebugUtils.currentLine=51314688;
 //BA.debugLineNum = 51314688;BA.debugLine="Private Sub lbl_rest_font_Click";
RDebugUtils.currentLine=51314689;
 //BA.debugLineNum = 51314689;BA.debugLine="sp_font.SelectedIndex=0";
mostCurrent._sp_font.setSelectedIndex((int) (0));
RDebugUtils.currentLine=51314691;
 //BA.debugLineNum = 51314691;BA.debugLine="skb_f1.Value=17";
mostCurrent._skb_f1.setValue((int) (17));
RDebugUtils.currentLine=51314692;
 //BA.debugLineNum = 51314692;BA.debugLine="skb_f2.Value=15";
mostCurrent._skb_f2.setValue((int) (15));
RDebugUtils.currentLine=51314693;
 //BA.debugLineNum = 51314693;BA.debugLine="skb_f3.Value=13";
mostCurrent._skb_f3.setValue((int) (13));
RDebugUtils.currentLine=51314695;
 //BA.debugLineNum = 51314695;BA.debugLine="lbl_skb_f1.Text=17";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(17));
RDebugUtils.currentLine=51314696;
 //BA.debugLineNum = 51314696;BA.debugLine="lbl_skb_f2.Text=15";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(15));
RDebugUtils.currentLine=51314697;
 //BA.debugLineNum = 51314697;BA.debugLine="lbl_skb_f3.Text=13";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(13));
RDebugUtils.currentLine=51314702;
 //BA.debugLineNum = 51314702;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=50397185;
 //BA.debugLineNum = 50397185;BA.debugLine="cc.Initialize(\"CC\")";
parent._cc.Initialize("CC");
RDebugUtils.currentLine=50397186;
 //BA.debugLineNum = 50397186;BA.debugLine="cc.Show(\"*/*\", \"انتخاب فایل دیتابیس\")";
parent._cc.Show(processBA,"*/*","انتخاب فایل دیتابیس");
RDebugUtils.currentLine=50397187;
 //BA.debugLineNum = 50397187;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
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
RDebugUtils.currentLine=50397188;
 //BA.debugLineNum = 50397188;BA.debugLine="If Success Then";
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
RDebugUtils.currentLine=50397189;
 //BA.debugLineNum = 50397189;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.SharedFo";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db");
RDebugUtils.currentLine=50397191;
 //BA.debugLineNum = 50397191;BA.debugLine="Log( Dir)";
anywheresoftware.b4a.keywords.Common.LogImpl("350397191",_dir,0);
RDebugUtils.currentLine=50397192;
 //BA.debugLineNum = 50397192;BA.debugLine="Log(FileName)";
anywheresoftware.b4a.keywords.Common.LogImpl("350397192",_filename,0);
RDebugUtils.currentLine=50397193;
 //BA.debugLineNum = 50397193;BA.debugLine="Log(File.Exists(Starter.Provider.SharedFolder,\"d";
anywheresoftware.b4a.keywords.Common.LogImpl("350397193",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.File.Exists(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db")),0);
RDebugUtils.currentLine=50397195;
 //BA.debugLineNum = 50397195;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=50397197;
 //BA.debugLineNum = 50397197;BA.debugLine="result = Msgbox2(\"دیتای قبلی حذف و دیتای جدید جا";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("دیتای قبلی حذف و دیتای جدید جایگزین می شود."),BA.ObjectToCharSequence("توجه"),"باشه","","نه",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
RDebugUtils.currentLine=50397198;
 //BA.debugLineNum = 50397198;BA.debugLine="If result = DialogResponse.Positive Then";
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
RDebugUtils.currentLine=50397199;
 //BA.debugLineNum = 50397199;BA.debugLine="File.Copy(Starter.Provider.SharedFolder,\"db2.db";
anywheresoftware.b4a.keywords.Common.File.Copy(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db");
RDebugUtils.currentLine=50397200;
 //BA.debugLineNum = 50397200;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
RDebugUtils.currentLine=50397201;
 //BA.debugLineNum = 50397201;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._main.getObject()));
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
RDebugUtils.currentLine=50397207;
 //BA.debugLineNum = 50397207;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _lbl_save_color_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_color_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_color_click", null));}
RDebugUtils.currentLine=50987008;
 //BA.debugLineNum = 50987008;BA.debugLine="Private Sub lbl_save_color_Click";
RDebugUtils.currentLine=50987009;
 //BA.debugLineNum = 50987009;BA.debugLine="Main.color1=color1";
mostCurrent._main._color1 /*int*/  = _color1;
RDebugUtils.currentLine=50987010;
 //BA.debugLineNum = 50987010;BA.debugLine="Main.color2=color2";
mostCurrent._main._color2 /*int*/  = _color2;
RDebugUtils.currentLine=50987011;
 //BA.debugLineNum = 50987011;BA.debugLine="Main.color3=color3";
mostCurrent._main._color3 /*int*/  = _color3;
RDebugUtils.currentLine=50987012;
 //BA.debugLineNum = 50987012;BA.debugLine="Main.color4=color4";
mostCurrent._main._color4 /*int*/  = _color4;
RDebugUtils.currentLine=50987013;
 //BA.debugLineNum = 50987013;BA.debugLine="Main.color5=color5";
mostCurrent._main._color5 /*int*/  = _color5;
RDebugUtils.currentLine=50987014;
 //BA.debugLineNum = 50987014;BA.debugLine="Main.color_index=color_index";
mostCurrent._main._color_index /*int*/  = _color_index;
RDebugUtils.currentLine=50987016;
 //BA.debugLineNum = 50987016;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(mostCurrent._main._color1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color2 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color_index /*int*/ )+","+BA.NumberToString(mostCurrent._main._color3 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color4 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color5 /*int*/ )+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._main._main_font /*String*/ +","+BA.NumberToString(mostCurrent._main._size_f1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._size_f2 /*int*/ )+","+BA.NumberToString(mostCurrent._main._size_f3 /*int*/ ));
RDebugUtils.currentLine=50987018;
 //BA.debugLineNum = 50987018;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=50987019;
 //BA.debugLineNum = 50987019;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=50987023;
 //BA.debugLineNum = 50987023;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_font_click", null));}
RDebugUtils.currentLine=51445760;
 //BA.debugLineNum = 51445760;BA.debugLine="Private Sub lbl_save_font_Click";
RDebugUtils.currentLine=51445764;
 //BA.debugLineNum = 51445764;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(mostCurrent._main._color1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color2 /*int*/ )+","+BA.NumberToString(_color_index)+","+BA.NumberToString(mostCurrent._main._color3 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color4 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color5 /*int*/ )+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._sp_font.getSelectedItem()+","+BA.NumberToString(mostCurrent._skb_f1.getValue())+","+BA.NumberToString(mostCurrent._skb_f2.getValue())+","+BA.NumberToString(mostCurrent._skb_f3.getValue()));
RDebugUtils.currentLine=51445768;
 //BA.debugLineNum = 51445768;BA.debugLine="pan_all2_Click";
_pan_all2_click();
RDebugUtils.currentLine=51445769;
 //BA.debugLineNum = 51445769;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51445773;
 //BA.debugLineNum = 51445773;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all2_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all2_click", null));}
RDebugUtils.currentLine=51707904;
 //BA.debugLineNum = 51707904;BA.debugLine="Private Sub pan_all2_Click";
RDebugUtils.currentLine=51707905;
 //BA.debugLineNum = 51707905;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51707906;
 //BA.debugLineNum = 51707906;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_lock_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_lock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_lock_click", null));}
anywheresoftware.b4a.objects.collections.List _ls_lock = null;
RDebugUtils.currentLine=51970048;
 //BA.debugLineNum = 51970048;BA.debugLine="Private Sub lbl_save_lock_Click";
RDebugUtils.currentLine=51970049;
 //BA.debugLineNum = 51970049;BA.debugLine="Dim ls_lock As List";
_ls_lock = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=51970050;
 //BA.debugLineNum = 51970050;BA.debugLine="ls_lock.Initialize";
_ls_lock.Initialize();
RDebugUtils.currentLine=51970054;
 //BA.debugLineNum = 51970054;BA.debugLine="If (ToggleBtn_OffOn_lock.Checked=True)Then";
if ((mostCurrent._togglebtn_offon_lock.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=51970055;
 //BA.debugLineNum = 51970055;BA.debugLine="If(et_pass_lock.Text.Length <> 4)Then";
if ((mostCurrent._et_pass_lock.getText().length()!=4)) { 
RDebugUtils.currentLine=51970056;
 //BA.debugLineNum = 51970056;BA.debugLine="ToastMessageShow(\"تعیین رمز\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تعیین رمز"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=51970060;
 //BA.debugLineNum = 51970060;BA.debugLine="ls_lock.Add(\"true\")";
_ls_lock.Add((Object)("true"));
RDebugUtils.currentLine=51970061;
 //BA.debugLineNum = 51970061;BA.debugLine="ls_lock.Add(ToggleBtn_finger.Checked)";
_ls_lock.Add((Object)(mostCurrent._togglebtn_finger.getChecked()));
RDebugUtils.currentLine=51970062;
 //BA.debugLineNum = 51970062;BA.debugLine="ls_lock.Add(et_pass_lock.Text)";
_ls_lock.Add((Object)(mostCurrent._et_pass_lock.getText()));
RDebugUtils.currentLine=51970063;
 //BA.debugLineNum = 51970063;BA.debugLine="ls_lock.Add(et_hint_lock.Text)";
_ls_lock.Add((Object)(mostCurrent._et_hint_lock.getText()));
RDebugUtils.currentLine=51970066;
 //BA.debugLineNum = 51970066;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_lo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock);
RDebugUtils.currentLine=51970068;
 //BA.debugLineNum = 51970068;BA.debugLine="pan_all_lock_Click";
_pan_all_lock_click();
 };
 }else {
RDebugUtils.currentLine=51970072;
 //BA.debugLineNum = 51970072;BA.debugLine="ls_lock.Add(\"false\")";
_ls_lock.Add((Object)("false"));
RDebugUtils.currentLine=51970073;
 //BA.debugLineNum = 51970073;BA.debugLine="ls_lock.Add(ToggleBtn_finger.Checked)";
_ls_lock.Add((Object)(mostCurrent._togglebtn_finger.getChecked()));
RDebugUtils.currentLine=51970074;
 //BA.debugLineNum = 51970074;BA.debugLine="ls_lock.Add(\"\")";
_ls_lock.Add((Object)(""));
RDebugUtils.currentLine=51970075;
 //BA.debugLineNum = 51970075;BA.debugLine="ls_lock.Add(\"\")";
_ls_lock.Add((Object)(""));
RDebugUtils.currentLine=51970076;
 //BA.debugLineNum = 51970076;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_loc";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock);
RDebugUtils.currentLine=51970077;
 //BA.debugLineNum = 51970077;BA.debugLine="pan_all_lock_Click";
_pan_all_lock_click();
 };
RDebugUtils.currentLine=51970081;
 //BA.debugLineNum = 51970081;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_lock_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_lock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_lock_click", null));}
RDebugUtils.currentLine=52166656;
 //BA.debugLineNum = 52166656;BA.debugLine="Private Sub pan_all_lock_Click";
RDebugUtils.currentLine=52166657;
 //BA.debugLineNum = 52166657;BA.debugLine="pan_all_lock.Visible=False";
mostCurrent._pan_all_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=52166658;
 //BA.debugLineNum = 52166658;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_click", null));}
RDebugUtils.currentLine=50528256;
 //BA.debugLineNum = 50528256;BA.debugLine="Private Sub pan_all_Click";
RDebugUtils.currentLine=50528257;
 //BA.debugLineNum = 50528257;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=50528259;
 //BA.debugLineNum = 50528259;BA.debugLine="End Sub";
return "";
}
public static String  _tik_all_dis() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tik_all_dis", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tik_all_dis", null));}
RDebugUtils.currentLine=51052544;
 //BA.debugLineNum = 51052544;BA.debugLine="Sub tik_all_dis";
RDebugUtils.currentLine=51052545;
 //BA.debugLineNum = 51052545;BA.debugLine="tik1.Visible=False";
mostCurrent._tik1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51052546;
 //BA.debugLineNum = 51052546;BA.debugLine="tik2.Visible=False";
mostCurrent._tik2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51052547;
 //BA.debugLineNum = 51052547;BA.debugLine="tik3.Visible=False";
mostCurrent._tik3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51052548;
 //BA.debugLineNum = 51052548;BA.debugLine="tik4.Visible=False";
mostCurrent._tik4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51052549;
 //BA.debugLineNum = 51052549;BA.debugLine="tik5.Visible=False";
mostCurrent._tik5.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51052550;
 //BA.debugLineNum = 51052550;BA.debugLine="tik6.Visible=False";
mostCurrent._tik6.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=51052551;
 //BA.debugLineNum = 51052551;BA.debugLine="End Sub";
return "";
}
public static String  _pan_colors_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_colors_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_colors_click", null));}
RDebugUtils.currentLine=51183616;
 //BA.debugLineNum = 51183616;BA.debugLine="Private Sub pan_colors_Click";
RDebugUtils.currentLine=51183618;
 //BA.debugLineNum = 51183618;BA.debugLine="End Sub";
return "";
}
public static String  _pan_font_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_font_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_font_click", null));}
RDebugUtils.currentLine=51773440;
 //BA.debugLineNum = 51773440;BA.debugLine="Private Sub pan_font_Click";
RDebugUtils.currentLine=51773442;
 //BA.debugLineNum = 51773442;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lock_click() throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_lock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_lock_click", null));}
RDebugUtils.currentLine=52232192;
 //BA.debugLineNum = 52232192;BA.debugLine="Private Sub pan_lock_Click";
RDebugUtils.currentLine=52232194;
 //BA.debugLineNum = 52232194;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f1_valuechanged(int _value,boolean _userchanged) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "skb_f1_valuechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "skb_f1_valuechanged", new Object[] {_value,_userchanged}));}
RDebugUtils.currentLine=51642368;
 //BA.debugLineNum = 51642368;BA.debugLine="Private Sub skb_f1_ValueChanged (Value As Int, Use";
RDebugUtils.currentLine=51642369;
 //BA.debugLineNum = 51642369;BA.debugLine="lbl_skb_f1.Text=Value";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=51642370;
 //BA.debugLineNum = 51642370;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f2_valuechanged(int _value,boolean _userchanged) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "skb_f2_valuechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "skb_f2_valuechanged", new Object[] {_value,_userchanged}));}
RDebugUtils.currentLine=51576832;
 //BA.debugLineNum = 51576832;BA.debugLine="Private Sub skb_f2_ValueChanged (Value As Int, Use";
RDebugUtils.currentLine=51576833;
 //BA.debugLineNum = 51576833;BA.debugLine="lbl_skb_f2.Text=Value";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=51576834;
 //BA.debugLineNum = 51576834;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f3_valuechanged(int _value,boolean _userchanged) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "skb_f3_valuechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "skb_f3_valuechanged", new Object[] {_value,_userchanged}));}
RDebugUtils.currentLine=51511296;
 //BA.debugLineNum = 51511296;BA.debugLine="Private Sub skb_f3_ValueChanged (Value As Int, Use";
RDebugUtils.currentLine=51511297;
 //BA.debugLineNum = 51511297;BA.debugLine="lbl_skb_f3.Text=Value";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=51511298;
 //BA.debugLineNum = 51511298;BA.debugLine="End Sub";
return "";
}
public static String  _sp_backup_online_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sp_backup_online_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sp_backup_online_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=52953088;
 //BA.debugLineNum = 52953088;BA.debugLine="Private Sub sp_backup_online_ItemClick (Position A";
RDebugUtils.currentLine=52953089;
 //BA.debugLineNum = 52953089;BA.debugLine="dbCode.update_setting_byname(\"backup_online\",Posi";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"backup_online",BA.NumberToString(_position));
RDebugUtils.currentLine=52953090;
 //BA.debugLineNum = 52953090;BA.debugLine="Main.backup_page_show=0";
mostCurrent._main._backup_page_show /*int*/  = (int) (0);
RDebugUtils.currentLine=52953091;
 //BA.debugLineNum = 52953091;BA.debugLine="File.WriteString(File.DirInternal,\"chk_backup.txt";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"chk_backup.txt",mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
RDebugUtils.currentLine=52953093;
 //BA.debugLineNum = 52953093;BA.debugLine="End Sub";
return "";
}
public static String  _tog_ayab_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_ayab_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_ayab_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=52559872;
 //BA.debugLineNum = 52559872;BA.debugLine="Private Sub tog_ayab_CheckedChange(Checked As Bool";
RDebugUtils.currentLine=52559873;
 //BA.debugLineNum = 52559873;BA.debugLine="If(tog_ayab.Checked=True)Then";
if ((mostCurrent._tog_ayab.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52559874;
 //BA.debugLineNum = 52559874;BA.debugLine="dbCode.update_setting_byname(\"tog_ayab\",\"1\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab","1");
 }else {
RDebugUtils.currentLine=52559876;
 //BA.debugLineNum = 52559876;BA.debugLine="dbCode.update_setting_byname(\"tog_ayab\",\"0\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab","0");
 };
RDebugUtils.currentLine=52559879;
 //BA.debugLineNum = 52559879;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=52559880;
 //BA.debugLineNum = 52559880;BA.debugLine="End Sub";
return "";
}
public static String  _tog_bime_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_bime_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_bime_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=52756480;
 //BA.debugLineNum = 52756480;BA.debugLine="Private Sub tog_bime_CheckedChange(Checked As Bool";
RDebugUtils.currentLine=52756482;
 //BA.debugLineNum = 52756482;BA.debugLine="If(tog_bime.Checked=True)Then";
if ((mostCurrent._tog_bime.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52756483;
 //BA.debugLineNum = 52756483;BA.debugLine="dbCode.update_setting_byname(\"tog_bime\",1)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_bime",BA.NumberToString(1));
 }else {
RDebugUtils.currentLine=52756485;
 //BA.debugLineNum = 52756485;BA.debugLine="dbCode.update_setting_byname(\"tog_bime\",0)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_bime",BA.NumberToString(0));
 };
RDebugUtils.currentLine=52756488;
 //BA.debugLineNum = 52756488;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=52756489;
 //BA.debugLineNum = 52756489;BA.debugLine="End Sub";
return "";
}
public static String  _tog_food_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_food_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_food_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=52690944;
 //BA.debugLineNum = 52690944;BA.debugLine="Private Sub tog_food_CheckedChange(Checked As Bool";
RDebugUtils.currentLine=52690946;
 //BA.debugLineNum = 52690946;BA.debugLine="If(tog_food.Checked=True)Then";
if ((mostCurrent._tog_food.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52690947;
 //BA.debugLineNum = 52690947;BA.debugLine="dbCode.update_setting_byname(\"tog_food\",\"1\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food","1");
 }else {
RDebugUtils.currentLine=52690949;
 //BA.debugLineNum = 52690949;BA.debugLine="dbCode.update_setting_byname(\"tog_food\",\"0\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food","0");
 };
RDebugUtils.currentLine=52690952;
 //BA.debugLineNum = 52690952;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=52690953;
 //BA.debugLineNum = 52690953;BA.debugLine="End Sub";
return "";
}
public static String  _tog_maliat_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_maliat_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_maliat_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=52822016;
 //BA.debugLineNum = 52822016;BA.debugLine="Private Sub tog_maliat_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=52822018;
 //BA.debugLineNum = 52822018;BA.debugLine="If(tog_maliat.Checked=True)Then";
if ((mostCurrent._tog_maliat.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52822019;
 //BA.debugLineNum = 52822019;BA.debugLine="dbCode.update_setting_byname(\"tog_maliat\",1)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_maliat",BA.NumberToString(1));
 }else {
RDebugUtils.currentLine=52822021;
 //BA.debugLineNum = 52822021;BA.debugLine="dbCode.update_setting_byname(\"tog_maliat\",0)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_maliat",BA.NumberToString(0));
 };
RDebugUtils.currentLine=52822024;
 //BA.debugLineNum = 52822024;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=52822025;
 //BA.debugLineNum = 52822025;BA.debugLine="End Sub";
return "";
}
public static String  _tog_mosaede_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_mosaede_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_mosaede_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=52887552;
 //BA.debugLineNum = 52887552;BA.debugLine="Private Sub tog_mosaede_CheckedChange(Checked As B";
RDebugUtils.currentLine=52887554;
 //BA.debugLineNum = 52887554;BA.debugLine="If(tog_mosaede.Checked=True)Then";
if ((mostCurrent._tog_mosaede.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52887555;
 //BA.debugLineNum = 52887555;BA.debugLine="dbCode.update_setting_byname(\"tog_mosaede\",1)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_mosaede",BA.NumberToString(1));
 }else {
RDebugUtils.currentLine=52887557;
 //BA.debugLineNum = 52887557;BA.debugLine="dbCode.update_setting_byname(\"tog_mosaede\",0)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_mosaede",BA.NumberToString(0));
 };
RDebugUtils.currentLine=52887560;
 //BA.debugLineNum = 52887560;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=52887562;
 //BA.debugLineNum = 52887562;BA.debugLine="End Sub";
return "";
}
public static String  _tog_padash_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_padash_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_padash_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=52494336;
 //BA.debugLineNum = 52494336;BA.debugLine="Private Sub tog_padash_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=52494337;
 //BA.debugLineNum = 52494337;BA.debugLine="If(tog_padash.Checked=True)Then";
if ((mostCurrent._tog_padash.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52494338;
 //BA.debugLineNum = 52494338;BA.debugLine="dbCode.update_setting_byname(\"tog_padash\",\"1\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_padash","1");
 }else {
RDebugUtils.currentLine=52494340;
 //BA.debugLineNum = 52494340;BA.debugLine="dbCode.update_setting_byname(\"tog_padash\",\"0\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_padash","0");
 };
RDebugUtils.currentLine=52494343;
 //BA.debugLineNum = 52494343;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=52494344;
 //BA.debugLineNum = 52494344;BA.debugLine="End Sub";
return "";
}
public static String  _tog_sayer_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_sayer_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_sayer_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=52428800;
 //BA.debugLineNum = 52428800;BA.debugLine="Private Sub tog_sayer_CheckedChange(Checked As Boo";
RDebugUtils.currentLine=52428801;
 //BA.debugLineNum = 52428801;BA.debugLine="If(tog_sayer.Checked=True)Then";
if ((mostCurrent._tog_sayer.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52428802;
 //BA.debugLineNum = 52428802;BA.debugLine="dbCode.update_setting_byname(\"tog_sayer\",\"1\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer","1");
 }else {
RDebugUtils.currentLine=52428804;
 //BA.debugLineNum = 52428804;BA.debugLine="dbCode.update_setting_byname(\"tog_sayer\",\"0\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer","0");
 };
RDebugUtils.currentLine=52428807;
 //BA.debugLineNum = 52428807;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=52428808;
 //BA.debugLineNum = 52428808;BA.debugLine="End Sub";
return "";
}
public static String  _tog_vam_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tog_vam_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tog_vam_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=52625408;
 //BA.debugLineNum = 52625408;BA.debugLine="Private Sub tog_vam_CheckedChange(Checked As Boole";
RDebugUtils.currentLine=52625410;
 //BA.debugLineNum = 52625410;BA.debugLine="If(tog_vam.Checked=True)Then";
if ((mostCurrent._tog_vam.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=52625411;
 //BA.debugLineNum = 52625411;BA.debugLine="dbCode.update_setting_byname(\"tog_vam\",\"1\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_vam","1");
 }else {
RDebugUtils.currentLine=52625413;
 //BA.debugLineNum = 52625413;BA.debugLine="dbCode.update_setting_byname(\"tog_vam\",\"0\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_vam","0");
 };
RDebugUtils.currentLine=52625416;
 //BA.debugLineNum = 52625416;BA.debugLine="chek_togel";
_chek_togel();
RDebugUtils.currentLine=52625417;
 //BA.debugLineNum = 52625417;BA.debugLine="End Sub";
return "";
}
public static String  _togglebtn_finger_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "togglebtn_finger_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "togglebtn_finger_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=52297728;
 //BA.debugLineNum = 52297728;BA.debugLine="Private Sub ToggleBtn_finger_CheckedChange(Checked";
RDebugUtils.currentLine=52297729;
 //BA.debugLineNum = 52297729;BA.debugLine="Try";
try {RDebugUtils.currentLine=52297730;
 //BA.debugLineNum = 52297730;BA.debugLine="fingerprint1.Initialize (Me, \"auth\")";
mostCurrent._fingerprint1._initialize /*String*/ (null,processBA,setting_activity.getObject(),"auth");
RDebugUtils.currentLine=52297731;
 //BA.debugLineNum = 52297731;BA.debugLine="If fingerprint1.HardwareDetected = False Then";
if (mostCurrent._fingerprint1._gethardwaredetected /*boolean*/ (null)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=52297732;
 //BA.debugLineNum = 52297732;BA.debugLine="ToastMessageShow(\"سنسور اثر انگشت موجود نیست\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("سنسور اثر انگشت موجود نیست"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=52297733;
 //BA.debugLineNum = 52297733;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=52297734;
 //BA.debugLineNum = 52297734;BA.debugLine="Else if fingerprint1.HasEnrolledFingerprints = F";
if (mostCurrent._fingerprint1._gethasenrolledfingerprints /*boolean*/ (null)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=52297735;
 //BA.debugLineNum = 52297735;BA.debugLine="ToastMessageShow(\"اثر انگشت تعریف نشده است\", Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اثر انگشت تعریف نشده است"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=52297736;
 //BA.debugLineNum = 52297736;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }}
;
 } 
       catch (Exception e11) {
			processBA.setLastException(e11);RDebugUtils.currentLine=52297740;
 //BA.debugLineNum = 52297740;BA.debugLine="ToastMessageShow(\"سنسور اثر انگشت موجود نیست\", T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("سنسور اثر انگشت موجود نیست"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=52297741;
 //BA.debugLineNum = 52297741;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=52297742;
 //BA.debugLineNum = 52297742;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("352297742",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=52297745;
 //BA.debugLineNum = 52297745;BA.debugLine="End Sub";
return "";
}
public static String  _togglebtn_offon_lock_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="setting_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "togglebtn_offon_lock_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "togglebtn_offon_lock_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=52101120;
 //BA.debugLineNum = 52101120;BA.debugLine="Private Sub ToggleBtn_OffOn_lock_CheckedChange(Che";
RDebugUtils.currentLine=52101121;
 //BA.debugLineNum = 52101121;BA.debugLine="Try";
try {RDebugUtils.currentLine=52101122;
 //BA.debugLineNum = 52101122;BA.debugLine="If(ToggleBtn_OffOn_lock.Checked=False)Then";
if ((mostCurrent._togglebtn_offon_lock.getChecked()==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=52101123;
 //BA.debugLineNum = 52101123;BA.debugLine="et_pass_lock.Enabled=False";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=52101124;
 //BA.debugLineNum = 52101124;BA.debugLine="ToggleBtn_finger.Enabled=False";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=52101125;
 //BA.debugLineNum = 52101125;BA.debugLine="et_hint_lock.Enabled=False";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=52101127;
 //BA.debugLineNum = 52101127;BA.debugLine="et_pass_lock.Enabled=True";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=52101128;
 //BA.debugLineNum = 52101128;BA.debugLine="ToggleBtn_finger.Enabled=True";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=52101129;
 //BA.debugLineNum = 52101129;BA.debugLine="et_hint_lock.Enabled=True";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e12) {
			processBA.setLastException(e12);RDebugUtils.currentLine=52101133;
 //BA.debugLineNum = 52101133;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("352101133",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=52101139;
 //BA.debugLineNum = 52101139;BA.debugLine="End Sub";
return "";
}
}