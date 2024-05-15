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
			processBA = new BA(this.getApplicationContext(), null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.setting_activity");
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
public ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
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
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
int _res_backup = 0;
 //BA.debugLineNum = 66;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 68;BA.debugLine="Activity.LoadLayout(\"setting_layout\")";
mostCurrent._activity.LoadLayout("setting_layout",mostCurrent.activityBA);
 //BA.debugLineNum = 69;BA.debugLine="sc_view_items.Panel.LoadLayout(\"setting_layout_it";
mostCurrent._sc_view_items.getPanel().LoadLayout("setting_layout_items",mostCurrent.activityBA);
 //BA.debugLineNum = 73;BA.debugLine="pan_hed_setting.Color=Main.color4";
mostCurrent._pan_hed_setting.setColor(mostCurrent._main._color4 /*int*/ );
 //BA.debugLineNum = 74;BA.debugLine="myfunc.set_font(Activity)";
mostCurrent._myfunc._set_font /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 77;BA.debugLine="sp_font.Add(\"یکان\")";
mostCurrent._sp_font.Add("یکان");
 //BA.debugLineNum = 78;BA.debugLine="sp_font.Add(\"نازنین\")";
mostCurrent._sp_font.Add("نازنین");
 //BA.debugLineNum = 79;BA.debugLine="sp_font.Add(\"وزیر\")";
mostCurrent._sp_font.Add("وزیر");
 //BA.debugLineNum = 80;BA.debugLine="sp_font.Add(\"دست نویس\")";
mostCurrent._sp_font.Add("دست نویس");
 //BA.debugLineNum = 81;BA.debugLine="sp_font.Add(\"کودک\")";
mostCurrent._sp_font.Add("کودک");
 //BA.debugLineNum = 84;BA.debugLine="skb_f1.Value=Main.size_f1";
mostCurrent._skb_f1.setValue(mostCurrent._main._size_f1 /*int*/ );
 //BA.debugLineNum = 85;BA.debugLine="skb_f2.Value=Main.size_f2";
mostCurrent._skb_f2.setValue(mostCurrent._main._size_f2 /*int*/ );
 //BA.debugLineNum = 86;BA.debugLine="skb_f3.Value=Main.size_f3";
mostCurrent._skb_f3.setValue(mostCurrent._main._size_f3 /*int*/ );
 //BA.debugLineNum = 88;BA.debugLine="lbl_skb_f1.Text=Main.size_f1";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f1 /*int*/ ));
 //BA.debugLineNum = 89;BA.debugLine="lbl_skb_f2.Text=Main.size_f2";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f2 /*int*/ ));
 //BA.debugLineNum = 90;BA.debugLine="lbl_skb_f3.Text=Main.size_f3";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(mostCurrent._main._size_f3 /*int*/ ));
 //BA.debugLineNum = 92;BA.debugLine="sp_backup_online.Add(\"1هفته\")";
mostCurrent._sp_backup_online.Add("1هفته");
 //BA.debugLineNum = 93;BA.debugLine="sp_backup_online.Add(\"2هفته\")";
mostCurrent._sp_backup_online.Add("2هفته");
 //BA.debugLineNum = 94;BA.debugLine="sp_backup_online.Add(\"1ماه\")";
mostCurrent._sp_backup_online.Add("1ماه");
 //BA.debugLineNum = 95;BA.debugLine="sp_backup_online.Add(\"غیرفعال\")";
mostCurrent._sp_backup_online.Add("غیرفعال");
 //BA.debugLineNum = 101;BA.debugLine="chek_db_togels";
_chek_db_togels();
 //BA.debugLineNum = 103;BA.debugLine="chek_togel";
_chek_togel();
 //BA.debugLineNum = 107;BA.debugLine="Dim res_backup As Int = dbCode.get_setting_byName";
_res_backup = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"backup_online")));
 //BA.debugLineNum = 108;BA.debugLine="Select res_backup";
switch (_res_backup) {
case 0: {
 //BA.debugLineNum = 110;BA.debugLine="sp_backup_online.SelectedIndex=0";
mostCurrent._sp_backup_online.setSelectedIndex((int) (0));
 break; }
case 1: {
 //BA.debugLineNum = 112;BA.debugLine="sp_backup_online.SelectedIndex=1";
mostCurrent._sp_backup_online.setSelectedIndex((int) (1));
 break; }
case 2: {
 //BA.debugLineNum = 114;BA.debugLine="sp_backup_online.SelectedIndex=2";
mostCurrent._sp_backup_online.setSelectedIndex((int) (2));
 break; }
case 3: {
 //BA.debugLineNum = 116;BA.debugLine="sp_backup_online.SelectedIndex=3";
mostCurrent._sp_backup_online.setSelectedIndex((int) (3));
 break; }
}
;
 //BA.debugLineNum = 123;BA.debugLine="sp_font.SelectedIndex=sp_font.IndexOf(Main.main_f";
mostCurrent._sp_font.setSelectedIndex(mostCurrent._sp_font.IndexOf(mostCurrent._main._main_font /*String*/ ));
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 187;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 188;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 189;BA.debugLine="If(pan_all.Visible=True)Then";
if ((mostCurrent._pan_all.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 190;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_all_help.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 193;BA.debugLine="pan_all_help.Visible=False";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_all2.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 195;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._pan_all_lock.getVisible()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 197;BA.debugLine="pan_all_lock.Visible=False";
mostCurrent._pan_all_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 199;BA.debugLine="lbl_back_Click";
_lbl_back_click();
 };
 //BA.debugLineNum = 202;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 204;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 206;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 131;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 127;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
public static String  _chek_db_togels() throws Exception{
 //BA.debugLineNum = 136;BA.debugLine="Sub chek_db_togels";
 //BA.debugLineNum = 137;BA.debugLine="If(dbCode.get_setting_byName(\"tog_maliat\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_maliat")).equals(BA.NumberToString(1)))) { 
 //BA.debugLineNum = 138;BA.debugLine="tog_maliat.Checked=True";
mostCurrent._tog_maliat.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 140;BA.debugLine="tog_maliat.Checked=False";
mostCurrent._tog_maliat.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 143;BA.debugLine="If(dbCode.get_setting_byName(\"tog_bime\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_bime")).equals(BA.NumberToString(1)))) { 
 //BA.debugLineNum = 144;BA.debugLine="tog_bime.Checked=True";
mostCurrent._tog_bime.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 146;BA.debugLine="tog_bime.Checked=False";
mostCurrent._tog_bime.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 149;BA.debugLine="If(dbCode.get_setting_byName(\"tog_food\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food")).equals(BA.NumberToString(1)))) { 
 //BA.debugLineNum = 150;BA.debugLine="tog_food.Checked=True";
mostCurrent._tog_food.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 152;BA.debugLine="tog_food.Checked=False";
mostCurrent._tog_food.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 155;BA.debugLine="If(dbCode.get_setting_byName(\"tog_vam\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_vam")).equals(BA.NumberToString(1)))) { 
 //BA.debugLineNum = 156;BA.debugLine="tog_vam.Checked=True";
mostCurrent._tog_vam.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 158;BA.debugLine="tog_vam.Checked=False";
mostCurrent._tog_vam.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 161;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab")).equals(BA.NumberToString(1)))) { 
 //BA.debugLineNum = 162;BA.debugLine="tog_ayab.Checked=True";
mostCurrent._tog_ayab.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 164;BA.debugLine="tog_ayab.Checked=False";
mostCurrent._tog_ayab.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 167;BA.debugLine="If(dbCode.get_setting_byName(\"tog_padash\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_padash")).equals(BA.NumberToString(1)))) { 
 //BA.debugLineNum = 168;BA.debugLine="tog_padash.Checked=True";
mostCurrent._tog_padash.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 170;BA.debugLine="tog_padash.Checked=False";
mostCurrent._tog_padash.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 173;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)Then";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer")).equals(BA.NumberToString(1)))) { 
 //BA.debugLineNum = 174;BA.debugLine="tog_sayer.Checked=True";
mostCurrent._tog_sayer.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 176;BA.debugLine="tog_sayer.Checked=False";
mostCurrent._tog_sayer.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 179;BA.debugLine="If(dbCode.get_setting_byName(\"tog_mosaede\")=1)The";
if (((mostCurrent._dbcode._get_setting_byname /*String*/ (mostCurrent.activityBA,"tog_mosaede")).equals(BA.NumberToString(1)))) { 
 //BA.debugLineNum = 180;BA.debugLine="tog_mosaede.Checked=True";
mostCurrent._tog_mosaede.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 182;BA.debugLine="tog_mosaede.Checked=False";
mostCurrent._tog_mosaede.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
return "";
}
public static String  _chek_togel() throws Exception{
String _color_on = "";
String _color_off = "";
 //BA.debugLineNum = 633;BA.debugLine="Sub chek_togel";
 //BA.debugLineNum = 634;BA.debugLine="Dim color_on As String=0xFF059C00";
_color_on = BA.NumberToString(((int)0xff059c00));
 //BA.debugLineNum = 635;BA.debugLine="Dim color_off As String=0xFFE70300";
_color_off = BA.NumberToString(((int)0xffe70300));
 //BA.debugLineNum = 638;BA.debugLine="If(tog_maliat.Checked=True)Then";
if ((mostCurrent._tog_maliat.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 639;BA.debugLine="tog_maliat.TextColor=color_on";
mostCurrent._tog_maliat.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
 //BA.debugLineNum = 641;BA.debugLine="tog_maliat.TextColor=color_off";
mostCurrent._tog_maliat.setTextColor((int)(Double.parseDouble(_color_off)));
 };
 //BA.debugLineNum = 644;BA.debugLine="If(tog_bime.Checked=True)Then";
if ((mostCurrent._tog_bime.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 645;BA.debugLine="tog_bime.TextColor=color_on";
mostCurrent._tog_bime.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
 //BA.debugLineNum = 647;BA.debugLine="tog_bime.TextColor=color_off";
mostCurrent._tog_bime.setTextColor((int)(Double.parseDouble(_color_off)));
 };
 //BA.debugLineNum = 650;BA.debugLine="If( tog_food.Checked=True)Then";
if ((mostCurrent._tog_food.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 651;BA.debugLine="tog_food.TextColor=color_on";
mostCurrent._tog_food.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
 //BA.debugLineNum = 653;BA.debugLine="tog_food.TextColor=color_off";
mostCurrent._tog_food.setTextColor((int)(Double.parseDouble(_color_off)));
 };
 //BA.debugLineNum = 656;BA.debugLine="If(tog_vam.Checked=True)Then";
if ((mostCurrent._tog_vam.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 657;BA.debugLine="tog_vam.TextColor=color_on";
mostCurrent._tog_vam.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
 //BA.debugLineNum = 659;BA.debugLine="tog_vam.TextColor=color_off";
mostCurrent._tog_vam.setTextColor((int)(Double.parseDouble(_color_off)));
 };
 //BA.debugLineNum = 662;BA.debugLine="If( tog_ayab.Checked=True)Then";
if ((mostCurrent._tog_ayab.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 663;BA.debugLine="tog_ayab.TextColor=color_on";
mostCurrent._tog_ayab.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
 //BA.debugLineNum = 665;BA.debugLine="tog_ayab.TextColor=color_off";
mostCurrent._tog_ayab.setTextColor((int)(Double.parseDouble(_color_off)));
 };
 //BA.debugLineNum = 668;BA.debugLine="If(tog_padash.Checked=True)Then";
if ((mostCurrent._tog_padash.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 669;BA.debugLine="tog_padash.TextColor=color_on";
mostCurrent._tog_padash.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
 //BA.debugLineNum = 671;BA.debugLine="tog_padash.TextColor=color_off";
mostCurrent._tog_padash.setTextColor((int)(Double.parseDouble(_color_off)));
 };
 //BA.debugLineNum = 674;BA.debugLine="If(tog_sayer.Checked=True)Then";
if ((mostCurrent._tog_sayer.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 675;BA.debugLine="tog_sayer.TextColor=color_on";
mostCurrent._tog_sayer.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
 //BA.debugLineNum = 677;BA.debugLine="tog_sayer.TextColor=color_off";
mostCurrent._tog_sayer.setTextColor((int)(Double.parseDouble(_color_off)));
 };
 //BA.debugLineNum = 680;BA.debugLine="If(tog_mosaede.Checked=True)Then";
if ((mostCurrent._tog_mosaede.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 681;BA.debugLine="tog_mosaede.TextColor=color_on";
mostCurrent._tog_mosaede.setTextColor((int)(Double.parseDouble(_color_on)));
 }else {
 //BA.debugLineNum = 683;BA.debugLine="tog_mosaede.TextColor=color_off";
mostCurrent._tog_mosaede.setTextColor((int)(Double.parseDouble(_color_off)));
 };
 //BA.debugLineNum = 686;BA.debugLine="End Sub";
return "";
}
public static String  _et_pass_lock_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 578;BA.debugLine="Private Sub et_pass_lock_TextChanged (Old As Strin";
 //BA.debugLineNum = 579;BA.debugLine="If(New.Length>4)Then";
if ((_new.length()>4)) { 
 //BA.debugLineNum = 580;BA.debugLine="ToastMessageShow(\"رمز فقط 4 رقم باشد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("رمز فقط 4 رقم باشد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 581;BA.debugLine="et_pass_lock.Text=Old";
mostCurrent._et_pass_lock.setText(BA.ObjectToCharSequence(_old));
 };
 //BA.debugLineNum = 583;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private pan_colors As Panel";
mostCurrent._pan_colors = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private pan_all As Panel";
mostCurrent._pan_all = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private lbl_save_color As Label";
mostCurrent._lbl_save_color = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private tik1 As Label";
mostCurrent._tik1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private tik2 As Label";
mostCurrent._tik2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private tik3 As Label";
mostCurrent._tik3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private tik4 As Label";
mostCurrent._tik4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private tik5 As Label";
mostCurrent._tik5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private tik6 As Label";
mostCurrent._tik6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Dim color1 As Int";
_color1 = 0;
 //BA.debugLineNum = 28;BA.debugLine="Dim color2 As Int";
_color2 = 0;
 //BA.debugLineNum = 29;BA.debugLine="Dim color3 As Int";
_color3 = 0;
 //BA.debugLineNum = 30;BA.debugLine="Dim color4 As Int";
_color4 = 0;
 //BA.debugLineNum = 31;BA.debugLine="Dim color5 As Int";
_color5 = 0;
 //BA.debugLineNum = 35;BA.debugLine="Dim color_index As Int";
_color_index = 0;
 //BA.debugLineNum = 36;BA.debugLine="Private pan_hed_setting As Panel";
mostCurrent._pan_hed_setting = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private sp_font As Spinner";
mostCurrent._sp_font = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private lbl_skb_f1 As Label";
mostCurrent._lbl_skb_f1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private lbl_skb_f2 As Label";
mostCurrent._lbl_skb_f2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private lbl_skb_f3 As Label";
mostCurrent._lbl_skb_f3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private skb_f1 As SeekBar";
mostCurrent._skb_f1 = new anywheresoftware.b4a.objects.SeekBarWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private skb_f2 As SeekBar";
mostCurrent._skb_f2 = new anywheresoftware.b4a.objects.SeekBarWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private skb_f3 As SeekBar";
mostCurrent._skb_f3 = new anywheresoftware.b4a.objects.SeekBarWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private pan_all2 As Panel";
mostCurrent._pan_all2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private pan_all_help As Panel";
mostCurrent._pan_all_help = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private ToggleBtn_OffOn_lock As ToggleButton";
mostCurrent._togglebtn_offon_lock = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private ToggleBtn_finger As ToggleButton";
mostCurrent._togglebtn_finger = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private et_pass_lock As EditText";
mostCurrent._et_pass_lock = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private pan_all_lock As Panel";
mostCurrent._pan_all_lock = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Dim fingerprint1 As FingerprintManager";
mostCurrent._fingerprint1 = new ir.taravatgroup.ezafekari2.fingerprintmanager();
 //BA.debugLineNum = 52;BA.debugLine="Private sc_view_items As ScrollView";
mostCurrent._sc_view_items = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private et_hint_lock As EditText";
mostCurrent._et_hint_lock = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Private tog_maliat As ToggleButton";
mostCurrent._tog_maliat = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private tog_bime As ToggleButton";
mostCurrent._tog_bime = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private tog_food As ToggleButton";
mostCurrent._tog_food = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private tog_vam As ToggleButton";
mostCurrent._tog_vam = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Private tog_ayab As ToggleButton";
mostCurrent._tog_ayab = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private tog_padash As ToggleButton";
mostCurrent._tog_padash = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private tog_sayer As ToggleButton";
mostCurrent._tog_sayer = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Private tog_mosaede As ToggleButton";
mostCurrent._tog_mosaede = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Private sp_backup_online As Spinner";
mostCurrent._sp_backup_online = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
 //BA.debugLineNum = 208;BA.debugLine="Private Sub lbl_back_Click";
 //BA.debugLineNum = 210;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 211;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_backup_click() throws Exception{
String _filename = "";
anywheresoftware.b4a.phone.Phone.Email _email = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
 //BA.debugLineNum = 216;BA.debugLine="Private Sub lbl_backup_Click";
 //BA.debugLineNum = 218;BA.debugLine="Dim FileName As String = \"db.db\"";
_filename = "db.db";
 //BA.debugLineNum = 221;BA.debugLine="File.Copy(File.DirInternal, FileName, Starter.Pro";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename,mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,_filename);
 //BA.debugLineNum = 223;BA.debugLine="Dim email As Email";
_email = new anywheresoftware.b4a.phone.Phone.Email();
 //BA.debugLineNum = 224;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
_email.To.Add((Object)("aaa@bbb.com"));
 //BA.debugLineNum = 225;BA.debugLine="email.Subject = \"subject\"";
_email.Subject = "subject";
 //BA.debugLineNum = 226;BA.debugLine="email.Body = \"backup-\"&DateTime.Date(DateTime.Now";
_email.Body = "backup-"+anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 //BA.debugLineNum = 227;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
_email.Attachments.Add(mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._getfileuri /*Object*/ (_filename));
 //BA.debugLineNum = 229;BA.debugLine="Dim in As Intent = email.GetIntent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_email.GetIntent()));
 //BA.debugLineNum = 232;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
_in.setFlags((int) (1));
 //BA.debugLineNum = 233;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_close_help_font_click() throws Exception{
 //BA.debugLineNum = 484;BA.debugLine="Private Sub lbl_close_help_font_Click";
 //BA.debugLineNum = 485;BA.debugLine="pan_all_help.Visible=False";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 486;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_color_home_click() throws Exception{
 //BA.debugLineNum = 407;BA.debugLine="Private Sub lbl_color_home_Click";
 //BA.debugLineNum = 408;BA.debugLine="lbl_color1_Click";
_lbl_color1_click();
 //BA.debugLineNum = 409;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_color1_click() throws Exception{
 //BA.debugLineNum = 262;BA.debugLine="Private Sub lbl_color1_Click";
 //BA.debugLineNum = 263;BA.debugLine="pan_all.Visible=True";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 265;BA.debugLine="color_index=Main.color_index";
_color_index = mostCurrent._main._color_index /*int*/ ;
 //BA.debugLineNum = 267;BA.debugLine="Select color_index";
switch (_color_index) {
case 1: {
 //BA.debugLineNum = 269;BA.debugLine="pan_color1_Click";
_pan_color1_click();
 break; }
case 2: {
 //BA.debugLineNum = 271;BA.debugLine="pan_color2_Click";
_pan_color2_click();
 break; }
case 3: {
 //BA.debugLineNum = 273;BA.debugLine="pan_color3_Click";
_pan_color3_click();
 break; }
case 4: {
 //BA.debugLineNum = 275;BA.debugLine="pan_color4_Click";
_pan_color4_click();
 break; }
case 5: {
 //BA.debugLineNum = 277;BA.debugLine="pan_color5_Click";
_pan_color5_click();
 break; }
case 6: {
 //BA.debugLineNum = 279;BA.debugLine="pan_color6_Click";
_pan_color6_click();
 break; }
}
;
 //BA.debugLineNum = 286;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_font_pan_click() throws Exception{
 //BA.debugLineNum = 415;BA.debugLine="Private Sub lbl_font_pan_Click";
 //BA.debugLineNum = 416;BA.debugLine="pan_all2.Visible=True";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 422;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_help_font_click() throws Exception{
 //BA.debugLineNum = 440;BA.debugLine="Private Sub lbl_help_font_Click";
 //BA.debugLineNum = 445;BA.debugLine="pan_all_help.Visible=True";
mostCurrent._pan_all_help.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 446;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_lock_app_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_lock0 = null;
anywheresoftware.b4a.objects.collections.List _ls_lock3 = null;
 //BA.debugLineNum = 488;BA.debugLine="Private Sub lbl_lock_app_Click";
 //BA.debugLineNum = 490;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=True)T";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 491;BA.debugLine="Dim ls_lock0 As List";
_ls_lock0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 492;BA.debugLine="ls_lock0.Initialize";
_ls_lock0.Initialize();
 //BA.debugLineNum = 494;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_lock";
_ls_lock0 = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock");
 //BA.debugLineNum = 496;BA.debugLine="If(ls_lock0.Get(0)=\"true\")Then";
if (((_ls_lock0.Get((int) (0))).equals((Object)("true")))) { 
 //BA.debugLineNum = 497;BA.debugLine="ToggleBtn_OffOn_lock.Checked=True";
mostCurrent._togglebtn_offon_lock.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 498;BA.debugLine="et_pass_lock.Enabled=True";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 499;BA.debugLine="et_pass_lock.Text=ls_lock0.Get(2)";
mostCurrent._et_pass_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (2))));
 //BA.debugLineNum = 500;BA.debugLine="et_hint_lock.Text=ls_lock0.Get(3)";
mostCurrent._et_hint_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (3))));
 }else {
 //BA.debugLineNum = 502;BA.debugLine="ToggleBtn_OffOn_lock.Checked=False";
mostCurrent._togglebtn_offon_lock.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 503;BA.debugLine="ToggleBtn_finger.Enabled=False";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 504;BA.debugLine="et_pass_lock.Enabled=False";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 505;BA.debugLine="et_hint_lock.Enabled=False";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 506;BA.debugLine="et_pass_lock.Text=\"\"";
mostCurrent._et_pass_lock.setText(BA.ObjectToCharSequence(""));
 };
 //BA.debugLineNum = 509;BA.debugLine="If(ls_lock0.Get(1)=\"true\")Then";
if (((_ls_lock0.Get((int) (1))).equals((Object)("true")))) { 
 //BA.debugLineNum = 510;BA.debugLine="ToggleBtn_finger.Checked=True";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 512;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 514;BA.debugLine="et_hint_lock.Text=ls_lock0.Get(3)";
mostCurrent._et_hint_lock.setText(BA.ObjectToCharSequence(_ls_lock0.Get((int) (3))));
 }else {
 //BA.debugLineNum = 517;BA.debugLine="Dim ls_lock3 As List";
_ls_lock3 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 518;BA.debugLine="ls_lock3.Initialize";
_ls_lock3.Initialize();
 //BA.debugLineNum = 520;BA.debugLine="ls_lock3.Add(\"false\")";
_ls_lock3.Add((Object)("false"));
 //BA.debugLineNum = 521;BA.debugLine="ls_lock3.Add(\"false\")";
_ls_lock3.Add((Object)("false"));
 //BA.debugLineNum = 522;BA.debugLine="ls_lock3.Add(\"\")";
_ls_lock3.Add((Object)(""));
 //BA.debugLineNum = 523;BA.debugLine="ls_lock3.Add(\"\")";
_ls_lock3.Add((Object)(""));
 //BA.debugLineNum = 526;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_loc";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock3);
 //BA.debugLineNum = 529;BA.debugLine="ToggleBtn_OffOn_lock.Checked=False";
mostCurrent._togglebtn_offon_lock.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 530;BA.debugLine="ToggleBtn_finger.Enabled=False";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 531;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 532;BA.debugLine="et_pass_lock.Enabled=False";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 533;BA.debugLine="et_hint_lock.Enabled=False";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 540;BA.debugLine="pan_all_lock.Visible=True";
mostCurrent._pan_all_lock.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 541;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_rest_font_click() throws Exception{
 //BA.debugLineNum = 424;BA.debugLine="Private Sub lbl_rest_font_Click";
 //BA.debugLineNum = 425;BA.debugLine="sp_font.SelectedIndex=0";
mostCurrent._sp_font.setSelectedIndex((int) (0));
 //BA.debugLineNum = 427;BA.debugLine="skb_f1.Value=17";
mostCurrent._skb_f1.setValue((int) (17));
 //BA.debugLineNum = 428;BA.debugLine="skb_f2.Value=15";
mostCurrent._skb_f2.setValue((int) (15));
 //BA.debugLineNum = 429;BA.debugLine="skb_f3.Value=13";
mostCurrent._skb_f3.setValue((int) (13));
 //BA.debugLineNum = 431;BA.debugLine="lbl_skb_f1.Text=17";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(17));
 //BA.debugLineNum = 432;BA.debugLine="lbl_skb_f2.Text=15";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(15));
 //BA.debugLineNum = 433;BA.debugLine="lbl_skb_f3.Text=13";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(13));
 //BA.debugLineNum = 438;BA.debugLine="End Sub";
return "";
}
public static void  _lbl_restore_click() throws Exception{
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

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 238;BA.debugLine="cc.Initialize(\"CC\")";
parent._cc.Initialize("CC");
 //BA.debugLineNum = 239;BA.debugLine="cc.Show(\"*/*\", \"انتخاب فایل دیتابیس\")";
parent._cc.Show(processBA,"*/*","انتخاب فایل دیتابیس");
 //BA.debugLineNum = 240;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
anywheresoftware.b4a.keywords.Common.WaitFor("cc_result", processBA, this, null);
this.state = 9;
return;
case 9:
//C
this.state = 1;
_success = (Boolean) result[0];
_dir = (String) result[1];
_filename = (String) result[2];
;
 //BA.debugLineNum = 241;BA.debugLine="If Success Then";
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
 //BA.debugLineNum = 242;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.SharedFo";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db");
 //BA.debugLineNum = 244;BA.debugLine="Log( Dir)";
anywheresoftware.b4a.keywords.Common.LogImpl("749217543",_dir,0);
 //BA.debugLineNum = 245;BA.debugLine="Log(FileName)";
anywheresoftware.b4a.keywords.Common.LogImpl("749217544",_filename,0);
 //BA.debugLineNum = 246;BA.debugLine="Log(File.Exists(Starter.Provider.SharedFolder,\"d";
anywheresoftware.b4a.keywords.Common.LogImpl("749217545",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.File.Exists(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db")),0);
 //BA.debugLineNum = 248;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 250;BA.debugLine="result = Msgbox2(\"دیتای قبلی حذف و دیتای جدید جا";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("دیتای قبلی حذف و دیتای جدید جایگزین می شود."),BA.ObjectToCharSequence("توجه"),"باشه","","نه",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"attention.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 251;BA.debugLine="If result = DialogResponse.Positive Then";
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
 //BA.debugLineNum = 252;BA.debugLine="File.Copy(Starter.Provider.SharedFolder,\"db2.db";
anywheresoftware.b4a.keywords.Common.File.Copy(parent.mostCurrent._starter._provider /*ir.taravatgroup.ezafekari2.fileprovider*/ ._sharedfolder /*String*/ ,"db2.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db");
 //BA.debugLineNum = 253;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 //BA.debugLineNum = 254;BA.debugLine="StartActivity(Main)";
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
 //BA.debugLineNum = 260;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _cc_result(boolean _success,String _dir,String _filename) throws Exception{
}
public static String  _lbl_save_color_click() throws Exception{
 //BA.debugLineNum = 381;BA.debugLine="Private Sub lbl_save_color_Click";
 //BA.debugLineNum = 382;BA.debugLine="Main.color1=color1";
mostCurrent._main._color1 /*int*/  = _color1;
 //BA.debugLineNum = 383;BA.debugLine="Main.color2=color2";
mostCurrent._main._color2 /*int*/  = _color2;
 //BA.debugLineNum = 384;BA.debugLine="Main.color3=color3";
mostCurrent._main._color3 /*int*/  = _color3;
 //BA.debugLineNum = 385;BA.debugLine="Main.color4=color4";
mostCurrent._main._color4 /*int*/  = _color4;
 //BA.debugLineNum = 386;BA.debugLine="Main.color5=color5";
mostCurrent._main._color5 /*int*/  = _color5;
 //BA.debugLineNum = 387;BA.debugLine="Main.color_index=color_index";
mostCurrent._main._color_index /*int*/  = _color_index;
 //BA.debugLineNum = 389;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(mostCurrent._main._color1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color2 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color_index /*int*/ )+","+BA.NumberToString(mostCurrent._main._color3 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color4 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color5 /*int*/ )+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._main._main_font /*String*/ +","+BA.NumberToString(mostCurrent._main._size_f1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._size_f2 /*int*/ )+","+BA.NumberToString(mostCurrent._main._size_f3 /*int*/ ));
 //BA.debugLineNum = 391;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 392;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 396;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_font_click() throws Exception{
 //BA.debugLineNum = 448;BA.debugLine="Private Sub lbl_save_font_Click";
 //BA.debugLineNum = 452;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"setcolor.txt",BA.NumberToString(mostCurrent._main._color1 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color2 /*int*/ )+","+BA.NumberToString(_color_index)+","+BA.NumberToString(mostCurrent._main._color3 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color4 /*int*/ )+","+BA.NumberToString(mostCurrent._main._color5 /*int*/ )+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._sp_font.getSelectedItem()+","+BA.NumberToString(mostCurrent._skb_f1.getValue())+","+BA.NumberToString(mostCurrent._skb_f2.getValue())+","+BA.NumberToString(mostCurrent._skb_f3.getValue()));
 //BA.debugLineNum = 456;BA.debugLine="pan_all2_Click";
_pan_all2_click();
 //BA.debugLineNum = 457;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 461;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_lock_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_lock = null;
 //BA.debugLineNum = 543;BA.debugLine="Private Sub lbl_save_lock_Click";
 //BA.debugLineNum = 544;BA.debugLine="Dim ls_lock As List";
_ls_lock = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 545;BA.debugLine="ls_lock.Initialize";
_ls_lock.Initialize();
 //BA.debugLineNum = 549;BA.debugLine="If (ToggleBtn_OffOn_lock.Checked=True)Then";
if ((mostCurrent._togglebtn_offon_lock.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 550;BA.debugLine="If(et_pass_lock.Text.Length <> 4)Then";
if ((mostCurrent._et_pass_lock.getText().length()!=4)) { 
 //BA.debugLineNum = 551;BA.debugLine="ToastMessageShow(\"تعیین رمز\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تعیین رمز"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 555;BA.debugLine="ls_lock.Add(\"true\")";
_ls_lock.Add((Object)("true"));
 //BA.debugLineNum = 556;BA.debugLine="ls_lock.Add(ToggleBtn_finger.Checked)";
_ls_lock.Add((Object)(mostCurrent._togglebtn_finger.getChecked()));
 //BA.debugLineNum = 557;BA.debugLine="ls_lock.Add(et_pass_lock.Text)";
_ls_lock.Add((Object)(mostCurrent._et_pass_lock.getText()));
 //BA.debugLineNum = 558;BA.debugLine="ls_lock.Add(et_hint_lock.Text)";
_ls_lock.Add((Object)(mostCurrent._et_hint_lock.getText()));
 //BA.debugLineNum = 561;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_lo";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock);
 //BA.debugLineNum = 563;BA.debugLine="pan_all_lock_Click";
_pan_all_lock_click();
 };
 }else {
 //BA.debugLineNum = 567;BA.debugLine="ls_lock.Add(\"false\")";
_ls_lock.Add((Object)("false"));
 //BA.debugLineNum = 568;BA.debugLine="ls_lock.Add(ToggleBtn_finger.Checked)";
_ls_lock.Add((Object)(mostCurrent._togglebtn_finger.getChecked()));
 //BA.debugLineNum = 569;BA.debugLine="ls_lock.Add(\"\")";
_ls_lock.Add((Object)(""));
 //BA.debugLineNum = 570;BA.debugLine="ls_lock.Add(\"\")";
_ls_lock.Add((Object)(""));
 //BA.debugLineNum = 571;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_loc";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"ls_lock",_ls_lock);
 //BA.debugLineNum = 572;BA.debugLine="pan_all_lock_Click";
_pan_all_lock_click();
 };
 //BA.debugLineNum = 576;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_click() throws Exception{
 //BA.debugLineNum = 288;BA.debugLine="Private Sub pan_all_Click";
 //BA.debugLineNum = 289;BA.debugLine="pan_all.Visible=False";
mostCurrent._pan_all.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 291;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_lock_click() throws Exception{
 //BA.debugLineNum = 606;BA.debugLine="Private Sub pan_all_lock_Click";
 //BA.debugLineNum = 607;BA.debugLine="pan_all_lock.Visible=False";
mostCurrent._pan_all_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 608;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all2_click() throws Exception{
 //BA.debugLineNum = 475;BA.debugLine="Private Sub pan_all2_Click";
 //BA.debugLineNum = 476;BA.debugLine="pan_all2.Visible=False";
mostCurrent._pan_all2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 477;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color1_click() throws Exception{
 //BA.debugLineNum = 367;BA.debugLine="Private Sub pan_color1_Click";
 //BA.debugLineNum = 368;BA.debugLine="tik_all_dis";
_tik_all_dis();
 //BA.debugLineNum = 369;BA.debugLine="color1=0XFF69AC00";
_color1 = ((int)0xff69ac00);
 //BA.debugLineNum = 370;BA.debugLine="color2=0xFF00C7C7";
_color2 = ((int)0xff00c7c7);
 //BA.debugLineNum = 371;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 372;BA.debugLine="color4=0XFF69AC00";
_color4 = ((int)0xff69ac00);
 //BA.debugLineNum = 373;BA.debugLine="color5=0xFF00C7C7";
_color5 = ((int)0xff00c7c7);
 //BA.debugLineNum = 376;BA.debugLine="color_index=1";
_color_index = (int) (1);
 //BA.debugLineNum = 377;BA.debugLine="tik1.Visible=True";
mostCurrent._tik1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 379;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color2_click() throws Exception{
 //BA.debugLineNum = 352;BA.debugLine="Private Sub pan_color2_Click";
 //BA.debugLineNum = 353;BA.debugLine="tik_all_dis";
_tik_all_dis();
 //BA.debugLineNum = 354;BA.debugLine="color1 = 0xFF7F19EE";
_color1 = ((int)0xff7f19ee);
 //BA.debugLineNum = 355;BA.debugLine="color2 = 0xFF567BFF";
_color2 = ((int)0xff567bff);
 //BA.debugLineNum = 356;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 357;BA.debugLine="color4=0xFF567BFF";
_color4 = ((int)0xff567bff);
 //BA.debugLineNum = 358;BA.debugLine="color5=0xFF567BFF";
_color5 = ((int)0xff567bff);
 //BA.debugLineNum = 362;BA.debugLine="color_index=2";
_color_index = (int) (2);
 //BA.debugLineNum = 363;BA.debugLine="tik2.Visible=True";
mostCurrent._tik2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 365;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color3_click() throws Exception{
 //BA.debugLineNum = 337;BA.debugLine="Private Sub pan_color3_Click";
 //BA.debugLineNum = 338;BA.debugLine="tik_all_dis";
_tik_all_dis();
 //BA.debugLineNum = 339;BA.debugLine="color1 = 0xFF2BC1F6";
_color1 = ((int)0xff2bc1f6);
 //BA.debugLineNum = 340;BA.debugLine="color2 = 0xFF1E45D1";
_color2 = ((int)0xff1e45d1);
 //BA.debugLineNum = 341;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 342;BA.debugLine="color4=0xFF2BC1F6";
_color4 = ((int)0xff2bc1f6);
 //BA.debugLineNum = 343;BA.debugLine="color5=0xFF1E45D1";
_color5 = ((int)0xff1e45d1);
 //BA.debugLineNum = 348;BA.debugLine="color_index=3";
_color_index = (int) (3);
 //BA.debugLineNum = 349;BA.debugLine="tik3.Visible=True";
mostCurrent._tik3.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 350;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color4_click() throws Exception{
 //BA.debugLineNum = 322;BA.debugLine="Private Sub pan_color4_Click";
 //BA.debugLineNum = 323;BA.debugLine="tik_all_dis";
_tik_all_dis();
 //BA.debugLineNum = 324;BA.debugLine="color1 = 0xFFDD00FF";
_color1 = ((int)0xffdd00ff);
 //BA.debugLineNum = 325;BA.debugLine="color2 = 0xFF0090FF";
_color2 = ((int)0xff0090ff);
 //BA.debugLineNum = 326;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 327;BA.debugLine="color4=0xFFDD00FF";
_color4 = ((int)0xffdd00ff);
 //BA.debugLineNum = 328;BA.debugLine="color5=0xFF24EB9D";
_color5 = ((int)0xff24eb9d);
 //BA.debugLineNum = 333;BA.debugLine="color_index=4";
_color_index = (int) (4);
 //BA.debugLineNum = 334;BA.debugLine="tik4.Visible=True";
mostCurrent._tik4.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 335;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color5_click() throws Exception{
 //BA.debugLineNum = 308;BA.debugLine="Private Sub pan_color5_Click";
 //BA.debugLineNum = 309;BA.debugLine="tik_all_dis";
_tik_all_dis();
 //BA.debugLineNum = 310;BA.debugLine="color1 = 0xFFCF5263";
_color1 = ((int)0xffcf5263);
 //BA.debugLineNum = 311;BA.debugLine="color2 = 0xFFABC01A";
_color2 = ((int)0xffabc01a);
 //BA.debugLineNum = 312;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 313;BA.debugLine="color4=0xFFCF5263";
_color4 = ((int)0xffcf5263);
 //BA.debugLineNum = 314;BA.debugLine="color5=0xFFABC01A";
_color5 = ((int)0xffabc01a);
 //BA.debugLineNum = 318;BA.debugLine="color_index=5";
_color_index = (int) (5);
 //BA.debugLineNum = 319;BA.debugLine="tik5.Visible=True";
mostCurrent._tik5.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 320;BA.debugLine="End Sub";
return "";
}
public static String  _pan_color6_click() throws Exception{
 //BA.debugLineNum = 293;BA.debugLine="Private Sub pan_color6_Click";
 //BA.debugLineNum = 294;BA.debugLine="tik_all_dis";
_tik_all_dis();
 //BA.debugLineNum = 295;BA.debugLine="color1= 0xFF5289CF";
_color1 = ((int)0xff5289cf);
 //BA.debugLineNum = 296;BA.debugLine="color2= 0xFFABC01A";
_color2 = ((int)0xffabc01a);
 //BA.debugLineNum = 297;BA.debugLine="color3=0XFFFFFFFF";
_color3 = ((int)0xffffffff);
 //BA.debugLineNum = 298;BA.debugLine="color4=0xFF5289CF";
_color4 = ((int)0xff5289cf);
 //BA.debugLineNum = 299;BA.debugLine="color5=0xFFABC01A";
_color5 = ((int)0xffabc01a);
 //BA.debugLineNum = 304;BA.debugLine="color_index=6";
_color_index = (int) (6);
 //BA.debugLineNum = 305;BA.debugLine="tik6.Visible=True";
mostCurrent._tik6.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 306;BA.debugLine="End Sub";
return "";
}
public static String  _pan_colors_click() throws Exception{
 //BA.debugLineNum = 411;BA.debugLine="Private Sub pan_colors_Click";
 //BA.debugLineNum = 413;BA.debugLine="End Sub";
return "";
}
public static String  _pan_font_click() throws Exception{
 //BA.debugLineNum = 479;BA.debugLine="Private Sub pan_font_Click";
 //BA.debugLineNum = 481;BA.debugLine="End Sub";
return "";
}
public static String  _pan_lock_click() throws Exception{
 //BA.debugLineNum = 610;BA.debugLine="Private Sub pan_lock_Click";
 //BA.debugLineNum = 612;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private cc As ContentChooser";
_cc = new anywheresoftware.b4a.phone.Phone.ContentChooser();
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f1_valuechanged(int _value,boolean _userchanged) throws Exception{
 //BA.debugLineNum = 471;BA.debugLine="Private Sub skb_f1_ValueChanged (Value As Int, Use";
 //BA.debugLineNum = 472;BA.debugLine="lbl_skb_f1.Text=Value";
mostCurrent._lbl_skb_f1.setText(BA.ObjectToCharSequence(_value));
 //BA.debugLineNum = 473;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f2_valuechanged(int _value,boolean _userchanged) throws Exception{
 //BA.debugLineNum = 467;BA.debugLine="Private Sub skb_f2_ValueChanged (Value As Int, Use";
 //BA.debugLineNum = 468;BA.debugLine="lbl_skb_f2.Text=Value";
mostCurrent._lbl_skb_f2.setText(BA.ObjectToCharSequence(_value));
 //BA.debugLineNum = 469;BA.debugLine="End Sub";
return "";
}
public static String  _skb_f3_valuechanged(int _value,boolean _userchanged) throws Exception{
 //BA.debugLineNum = 463;BA.debugLine="Private Sub skb_f3_ValueChanged (Value As Int, Use";
 //BA.debugLineNum = 464;BA.debugLine="lbl_skb_f3.Text=Value";
mostCurrent._lbl_skb_f3.setText(BA.ObjectToCharSequence(_value));
 //BA.debugLineNum = 465;BA.debugLine="End Sub";
return "";
}
public static String  _sp_backup_online_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 774;BA.debugLine="Private Sub sp_backup_online_ItemClick (Position A";
 //BA.debugLineNum = 775;BA.debugLine="dbCode.update_setting_byname(\"backup_online\",Posi";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"backup_online",BA.NumberToString(_position));
 //BA.debugLineNum = 776;BA.debugLine="Main.backup_page_show=0";
mostCurrent._main._backup_page_show /*int*/  = (int) (0);
 //BA.debugLineNum = 777;BA.debugLine="File.WriteString(File.DirInternal,\"chk_backup.txt";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"chk_backup.txt",mostCurrent._myfunc._fa2en /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 //BA.debugLineNum = 779;BA.debugLine="End Sub";
return "";
}
public static String  _tik_all_dis() throws Exception{
 //BA.debugLineNum = 398;BA.debugLine="Sub tik_all_dis";
 //BA.debugLineNum = 399;BA.debugLine="tik1.Visible=False";
mostCurrent._tik1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 400;BA.debugLine="tik2.Visible=False";
mostCurrent._tik2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 401;BA.debugLine="tik3.Visible=False";
mostCurrent._tik3.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 402;BA.debugLine="tik4.Visible=False";
mostCurrent._tik4.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 403;BA.debugLine="tik5.Visible=False";
mostCurrent._tik5.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 404;BA.debugLine="tik6.Visible=False";
mostCurrent._tik6.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 405;BA.debugLine="End Sub";
return "";
}
public static String  _tog_ayab_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 708;BA.debugLine="Private Sub tog_ayab_CheckedChange(Checked As Bool";
 //BA.debugLineNum = 709;BA.debugLine="If(tog_ayab.Checked=True)Then";
if ((mostCurrent._tog_ayab.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 710;BA.debugLine="dbCode.update_setting_byname(\"tog_ayab\",\"1\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab","1");
 }else {
 //BA.debugLineNum = 712;BA.debugLine="dbCode.update_setting_byname(\"tog_ayab\",\"0\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_ayab","0");
 };
 //BA.debugLineNum = 715;BA.debugLine="chek_togel";
_chek_togel();
 //BA.debugLineNum = 716;BA.debugLine="End Sub";
return "";
}
public static String  _tog_bime_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 740;BA.debugLine="Private Sub tog_bime_CheckedChange(Checked As Bool";
 //BA.debugLineNum = 742;BA.debugLine="If(tog_bime.Checked=True)Then";
if ((mostCurrent._tog_bime.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 743;BA.debugLine="dbCode.update_setting_byname(\"tog_bime\",1)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_bime",BA.NumberToString(1));
 }else {
 //BA.debugLineNum = 745;BA.debugLine="dbCode.update_setting_byname(\"tog_bime\",0)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_bime",BA.NumberToString(0));
 };
 //BA.debugLineNum = 748;BA.debugLine="chek_togel";
_chek_togel();
 //BA.debugLineNum = 749;BA.debugLine="End Sub";
return "";
}
public static String  _tog_food_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 729;BA.debugLine="Private Sub tog_food_CheckedChange(Checked As Bool";
 //BA.debugLineNum = 731;BA.debugLine="If(tog_food.Checked=True)Then";
if ((mostCurrent._tog_food.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 732;BA.debugLine="dbCode.update_setting_byname(\"tog_food\",\"1\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food","1");
 }else {
 //BA.debugLineNum = 734;BA.debugLine="dbCode.update_setting_byname(\"tog_food\",\"0\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_food","0");
 };
 //BA.debugLineNum = 737;BA.debugLine="chek_togel";
_chek_togel();
 //BA.debugLineNum = 738;BA.debugLine="End Sub";
return "";
}
public static String  _tog_maliat_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 751;BA.debugLine="Private Sub tog_maliat_CheckedChange(Checked As Bo";
 //BA.debugLineNum = 753;BA.debugLine="If(tog_maliat.Checked=True)Then";
if ((mostCurrent._tog_maliat.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 754;BA.debugLine="dbCode.update_setting_byname(\"tog_maliat\",1)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_maliat",BA.NumberToString(1));
 }else {
 //BA.debugLineNum = 756;BA.debugLine="dbCode.update_setting_byname(\"tog_maliat\",0)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_maliat",BA.NumberToString(0));
 };
 //BA.debugLineNum = 759;BA.debugLine="chek_togel";
_chek_togel();
 //BA.debugLineNum = 760;BA.debugLine="End Sub";
return "";
}
public static String  _tog_mosaede_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 762;BA.debugLine="Private Sub tog_mosaede_CheckedChange(Checked As B";
 //BA.debugLineNum = 764;BA.debugLine="If(tog_mosaede.Checked=True)Then";
if ((mostCurrent._tog_mosaede.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 765;BA.debugLine="dbCode.update_setting_byname(\"tog_mosaede\",1)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_mosaede",BA.NumberToString(1));
 }else {
 //BA.debugLineNum = 767;BA.debugLine="dbCode.update_setting_byname(\"tog_mosaede\",0)";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_mosaede",BA.NumberToString(0));
 };
 //BA.debugLineNum = 770;BA.debugLine="chek_togel";
_chek_togel();
 //BA.debugLineNum = 772;BA.debugLine="End Sub";
return "";
}
public static String  _tog_padash_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 698;BA.debugLine="Private Sub tog_padash_CheckedChange(Checked As Bo";
 //BA.debugLineNum = 699;BA.debugLine="If(tog_padash.Checked=True)Then";
if ((mostCurrent._tog_padash.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 700;BA.debugLine="dbCode.update_setting_byname(\"tog_padash\",\"1\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_padash","1");
 }else {
 //BA.debugLineNum = 702;BA.debugLine="dbCode.update_setting_byname(\"tog_padash\",\"0\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_padash","0");
 };
 //BA.debugLineNum = 705;BA.debugLine="chek_togel";
_chek_togel();
 //BA.debugLineNum = 706;BA.debugLine="End Sub";
return "";
}
public static String  _tog_sayer_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 688;BA.debugLine="Private Sub tog_sayer_CheckedChange(Checked As Boo";
 //BA.debugLineNum = 689;BA.debugLine="If(tog_sayer.Checked=True)Then";
if ((mostCurrent._tog_sayer.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 690;BA.debugLine="dbCode.update_setting_byname(\"tog_sayer\",\"1\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer","1");
 }else {
 //BA.debugLineNum = 692;BA.debugLine="dbCode.update_setting_byname(\"tog_sayer\",\"0\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_sayer","0");
 };
 //BA.debugLineNum = 695;BA.debugLine="chek_togel";
_chek_togel();
 //BA.debugLineNum = 696;BA.debugLine="End Sub";
return "";
}
public static String  _tog_vam_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 718;BA.debugLine="Private Sub tog_vam_CheckedChange(Checked As Boole";
 //BA.debugLineNum = 720;BA.debugLine="If(tog_vam.Checked=True)Then";
if ((mostCurrent._tog_vam.getChecked()==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 721;BA.debugLine="dbCode.update_setting_byname(\"tog_vam\",\"1\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_vam","1");
 }else {
 //BA.debugLineNum = 723;BA.debugLine="dbCode.update_setting_byname(\"tog_vam\",\"0\")";
mostCurrent._dbcode._update_setting_byname /*String*/ (mostCurrent.activityBA,"tog_vam","0");
 };
 //BA.debugLineNum = 726;BA.debugLine="chek_togel";
_chek_togel();
 //BA.debugLineNum = 727;BA.debugLine="End Sub";
return "";
}
public static String  _togglebtn_finger_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 614;BA.debugLine="Private Sub ToggleBtn_finger_CheckedChange(Checked";
 //BA.debugLineNum = 615;BA.debugLine="Try";
try { //BA.debugLineNum = 616;BA.debugLine="fingerprint1.Initialize (Me, \"auth\")";
mostCurrent._fingerprint1._initialize /*String*/ (processBA,setting_activity.getObject(),"auth");
 //BA.debugLineNum = 617;BA.debugLine="If fingerprint1.HardwareDetected = False Then";
if (mostCurrent._fingerprint1._gethardwaredetected /*boolean*/ ()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 618;BA.debugLine="ToastMessageShow(\"سنسور اثر انگشت موجود نیست\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("سنسور اثر انگشت موجود نیست"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 619;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 }else if(mostCurrent._fingerprint1._gethasenrolledfingerprints /*boolean*/ ()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 621;BA.debugLine="ToastMessageShow(\"اثر انگشت تعریف نشده است\", Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("اثر انگشت تعریف نشده است"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 622;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 } 
       catch (Exception e11) {
			processBA.setLastException(e11); //BA.debugLineNum = 626;BA.debugLine="ToastMessageShow(\"سنسور اثر انگشت موجود نیست\", T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("سنسور اثر انگشت موجود نیست"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 627;BA.debugLine="ToggleBtn_finger.Checked=False";
mostCurrent._togglebtn_finger.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 628;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("751118094",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 631;BA.debugLine="End Sub";
return "";
}
public static String  _togglebtn_offon_lock_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 585;BA.debugLine="Private Sub ToggleBtn_OffOn_lock_CheckedChange(Che";
 //BA.debugLineNum = 586;BA.debugLine="Try";
try { //BA.debugLineNum = 587;BA.debugLine="If(ToggleBtn_OffOn_lock.Checked=False)Then";
if ((mostCurrent._togglebtn_offon_lock.getChecked()==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 588;BA.debugLine="et_pass_lock.Enabled=False";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 589;BA.debugLine="ToggleBtn_finger.Enabled=False";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 590;BA.debugLine="et_hint_lock.Enabled=False";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 592;BA.debugLine="et_pass_lock.Enabled=True";
mostCurrent._et_pass_lock.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 593;BA.debugLine="ToggleBtn_finger.Enabled=True";
mostCurrent._togglebtn_finger.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 594;BA.debugLine="et_hint_lock.Enabled=True";
mostCurrent._et_hint_lock.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e12) {
			processBA.setLastException(e12); //BA.debugLineNum = 598;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("750921485",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 604;BA.debugLine="End Sub";
return "";
}
}
