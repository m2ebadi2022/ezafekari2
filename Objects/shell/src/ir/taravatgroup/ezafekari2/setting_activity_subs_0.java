package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class setting_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,56);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 56;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 58;BA.debugLine="Activity.LoadLayout(\"setting_layout\")";
Debug.ShouldStop(33554432);
setting_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("setting_layout")),setting_activity.mostCurrent.activityBA);
 BA.debugLineNum = 59;BA.debugLine="sc_view_items.Panel.LoadLayout(\"setting_layout_it";
Debug.ShouldStop(67108864);
setting_activity.mostCurrent._sc_view_items.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("setting_layout_items")),setting_activity.mostCurrent.activityBA);
 BA.debugLineNum = 63;BA.debugLine="pan_hed_setting.Color=Main.color4";
Debug.ShouldStop(1073741824);
setting_activity.mostCurrent._pan_hed_setting.runVoidMethod ("setColor",setting_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 64;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(-2147483648);
setting_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(setting_activity.mostCurrent._activity));
 BA.debugLineNum = 67;BA.debugLine="sp_font.Add(\"یکان\")";
Debug.ShouldStop(4);
setting_activity.mostCurrent._sp_font.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("یکان")));
 BA.debugLineNum = 68;BA.debugLine="sp_font.Add(\"نازنین\")";
Debug.ShouldStop(8);
setting_activity.mostCurrent._sp_font.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("نازنین")));
 BA.debugLineNum = 69;BA.debugLine="sp_font.Add(\"وزیر\")";
Debug.ShouldStop(16);
setting_activity.mostCurrent._sp_font.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("وزیر")));
 BA.debugLineNum = 70;BA.debugLine="sp_font.Add(\"دست نویس\")";
Debug.ShouldStop(32);
setting_activity.mostCurrent._sp_font.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("دست نویس")));
 BA.debugLineNum = 71;BA.debugLine="sp_font.Add(\"کودک\")";
Debug.ShouldStop(64);
setting_activity.mostCurrent._sp_font.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("کودک")));
 BA.debugLineNum = 74;BA.debugLine="skb_f1.Value=Main.size_f1";
Debug.ShouldStop(512);
setting_activity.mostCurrent._skb_f1.runMethod(true,"setValue",setting_activity.mostCurrent._main._size_f1 /*RemoteObject*/ );
 BA.debugLineNum = 75;BA.debugLine="skb_f2.Value=Main.size_f2";
Debug.ShouldStop(1024);
setting_activity.mostCurrent._skb_f2.runMethod(true,"setValue",setting_activity.mostCurrent._main._size_f2 /*RemoteObject*/ );
 BA.debugLineNum = 76;BA.debugLine="skb_f3.Value=Main.size_f3";
Debug.ShouldStop(2048);
setting_activity.mostCurrent._skb_f3.runMethod(true,"setValue",setting_activity.mostCurrent._main._size_f3 /*RemoteObject*/ );
 BA.debugLineNum = 78;BA.debugLine="lbl_skb_f1.Text=Main.size_f1";
Debug.ShouldStop(8192);
setting_activity.mostCurrent._lbl_skb_f1.runMethod(true,"setText",BA.ObjectToCharSequence(setting_activity.mostCurrent._main._size_f1 /*RemoteObject*/ ));
 BA.debugLineNum = 79;BA.debugLine="lbl_skb_f2.Text=Main.size_f2";
Debug.ShouldStop(16384);
setting_activity.mostCurrent._lbl_skb_f2.runMethod(true,"setText",BA.ObjectToCharSequence(setting_activity.mostCurrent._main._size_f2 /*RemoteObject*/ ));
 BA.debugLineNum = 80;BA.debugLine="lbl_skb_f3.Text=Main.size_f3";
Debug.ShouldStop(32768);
setting_activity.mostCurrent._lbl_skb_f3.runMethod(true,"setText",BA.ObjectToCharSequence(setting_activity.mostCurrent._main._size_f3 /*RemoteObject*/ ));
 BA.debugLineNum = 84;BA.debugLine="sp_font.SelectedIndex=sp_font.IndexOf(Main.main_f";
Debug.ShouldStop(524288);
setting_activity.mostCurrent._sp_font.runMethod(true,"setSelectedIndex",setting_activity.mostCurrent._sp_font.runMethod(true,"IndexOf",(Object)(setting_activity.mostCurrent._main._main_font /*RemoteObject*/ )));
 BA.debugLineNum = 86;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,96);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 96;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, setting_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 98;BA.debugLine="If(pan_all.Visible=True)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._pan_all.runMethod(true,"getVisible"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 99;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(4);
setting_activity.mostCurrent._pan_all.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 101;BA.debugLine="Else If (pan_all_help.Visible=True) Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._pan_all_help.runMethod(true,"getVisible"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 102;BA.debugLine="pan_all_help.Visible=False";
Debug.ShouldStop(32);
setting_activity.mostCurrent._pan_all_help.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 103;BA.debugLine="Else If (pan_all2.Visible=True)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._pan_all2.runMethod(true,"getVisible"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 104;BA.debugLine="pan_all2.Visible=False";
Debug.ShouldStop(128);
setting_activity.mostCurrent._pan_all2.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 105;BA.debugLine="Else If(pan_all_lock.Visible=True)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._pan_all_lock.runMethod(true,"getVisible"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 106;BA.debugLine="pan_all_lock.Visible=False";
Debug.ShouldStop(512);
setting_activity.mostCurrent._pan_all_lock.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 108;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(2048);
_lbl_back_click();
 }}}}
;
 BA.debugLineNum = 111;BA.debugLine="Return True";
Debug.ShouldStop(16384);
if (true) return setting_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 113;BA.debugLine="Return False";
Debug.ShouldStop(65536);
if (true) return setting_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 115;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,92);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 92;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,88);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_resume");}
 BA.debugLineNum = 88;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_pass_lock_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_pass_lock_TextChanged (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,486);
if (RapidSub.canDelegate("et_pass_lock_textchanged")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","et_pass_lock_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 486;BA.debugLine="Private Sub et_pass_lock_TextChanged (Old As Strin";
Debug.ShouldStop(32);
 BA.debugLineNum = 487;BA.debugLine="If(New.Length>4)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean(">",_new.runMethod(true,"length"),BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 488;BA.debugLine="ToastMessageShow(\"رمز فقط 4 رقم باشد\",False)";
Debug.ShouldStop(128);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("رمز فقط 4 رقم باشد")),(Object)(setting_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 489;BA.debugLine="et_pass_lock.Text=Old";
Debug.ShouldStop(256);
setting_activity.mostCurrent._et_pass_lock.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_old));
 };
 BA.debugLineNum = 491;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private pan_colors As Panel";
setting_activity.mostCurrent._pan_colors = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private pan_all As Panel";
setting_activity.mostCurrent._pan_all = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private lbl_save_color As Label";
setting_activity.mostCurrent._lbl_save_color = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private tik1 As Label";
setting_activity.mostCurrent._tik1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private tik2 As Label";
setting_activity.mostCurrent._tik2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private tik3 As Label";
setting_activity.mostCurrent._tik3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private tik4 As Label";
setting_activity.mostCurrent._tik4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private tik5 As Label";
setting_activity.mostCurrent._tik5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private tik6 As Label";
setting_activity.mostCurrent._tik6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim color1 As Int";
setting_activity._color1 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 28;BA.debugLine="Dim color2 As Int";
setting_activity._color2 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 29;BA.debugLine="Dim color3 As Int";
setting_activity._color3 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 30;BA.debugLine="Dim color4 As Int";
setting_activity._color4 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 31;BA.debugLine="Dim color5 As Int";
setting_activity._color5 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 35;BA.debugLine="Dim color_index As Int";
setting_activity._color_index = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 36;BA.debugLine="Private pan_hed_setting As Panel";
setting_activity.mostCurrent._pan_hed_setting = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private sp_font As Spinner";
setting_activity.mostCurrent._sp_font = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private lbl_skb_f1 As Label";
setting_activity.mostCurrent._lbl_skb_f1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private lbl_skb_f2 As Label";
setting_activity.mostCurrent._lbl_skb_f2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private lbl_skb_f3 As Label";
setting_activity.mostCurrent._lbl_skb_f3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private skb_f1 As SeekBar";
setting_activity.mostCurrent._skb_f1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SeekBarWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private skb_f2 As SeekBar";
setting_activity.mostCurrent._skb_f2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SeekBarWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private skb_f3 As SeekBar";
setting_activity.mostCurrent._skb_f3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SeekBarWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private pan_all2 As Panel";
setting_activity.mostCurrent._pan_all2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private pan_all_help As Panel";
setting_activity.mostCurrent._pan_all_help = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private ToggleBtn_OffOn_lock As ToggleButton";
setting_activity.mostCurrent._togglebtn_offon_lock = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private ToggleBtn_finger As ToggleButton";
setting_activity.mostCurrent._togglebtn_finger = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private et_pass_lock As EditText";
setting_activity.mostCurrent._et_pass_lock = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private pan_all_lock As Panel";
setting_activity.mostCurrent._pan_all_lock = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Dim fingerprint1 As FingerprintManager";
setting_activity.mostCurrent._fingerprint1 = RemoteObject.createNew ("ir.taravatgroup.ezafekari2.fingerprintmanager");
 //BA.debugLineNum = 52;BA.debugLine="Private sc_view_items As ScrollView";
setting_activity.mostCurrent._sc_view_items = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private et_hint_lock As EditText";
setting_activity.mostCurrent._et_hint_lock = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,117);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_back_click");}
 BA.debugLineNum = 117;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 118;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(2097152);
setting_activity.mostCurrent.__c.runVoidMethod ("StartActivity",setting_activity.processBA,(Object)((setting_activity.mostCurrent._main.getObject())));
 BA.debugLineNum = 119;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4194304);
setting_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_backup_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_backup_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,124);
if (RapidSub.canDelegate("lbl_backup_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_backup_click");}
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _email = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.Email");
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 124;BA.debugLine="Private Sub lbl_backup_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 126;BA.debugLine="Dim FileName As String = \"db.db\"";
Debug.ShouldStop(536870912);
_filename = BA.ObjectToString("db.db");Debug.locals.put("FileName", _filename);Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 129;BA.debugLine="File.Copy(File.DirInternal, FileName, Starter.Pro";
Debug.ShouldStop(1);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_filename),(Object)(setting_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(_filename));
 BA.debugLineNum = 131;BA.debugLine="Dim email As Email";
Debug.ShouldStop(4);
_email = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.Email");Debug.locals.put("email", _email);
 BA.debugLineNum = 132;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
Debug.ShouldStop(8);
_email.getField(false,"To").runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("aaa@bbb.com"))));
 BA.debugLineNum = 133;BA.debugLine="email.Subject = \"subject\"";
Debug.ShouldStop(16);
_email.setField ("Subject",BA.ObjectToString("subject"));
 BA.debugLineNum = 134;BA.debugLine="email.Body = \"backup-\"&DateTime.Date(DateTime.Now";
Debug.ShouldStop(32);
_email.setField ("Body",RemoteObject.concat(RemoteObject.createImmutable("backup-"),setting_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(setting_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))));
 BA.debugLineNum = 135;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
Debug.ShouldStop(64);
_email.getField(false,"Attachments").runVoidMethod ("Add",(Object)(setting_activity.mostCurrent._starter._provider /*RemoteObject*/ .runClassMethod (ir.taravatgroup.ezafekari2.fileprovider.class, "_getfileuri" /*RemoteObject*/ ,(Object)(_filename))));
 BA.debugLineNum = 137;BA.debugLine="Dim in As Intent = email.GetIntent";
Debug.ShouldStop(256);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");
_in = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.IntentWrapper"), _email.runMethod(false,"GetIntent"));Debug.locals.put("in", _in);Debug.locals.put("in", _in);
 BA.debugLineNum = 140;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
Debug.ShouldStop(2048);
_in.runMethod(true,"setFlags",BA.numberCast(int.class, 1));
 BA.debugLineNum = 141;BA.debugLine="StartActivity(in)";
Debug.ShouldStop(4096);
setting_activity.mostCurrent.__c.runVoidMethod ("StartActivity",setting_activity.processBA,(Object)((_in.getObject())));
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_close_help_font_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_close_help_font_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,392);
if (RapidSub.canDelegate("lbl_close_help_font_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_close_help_font_click");}
 BA.debugLineNum = 392;BA.debugLine="Private Sub lbl_close_help_font_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 393;BA.debugLine="pan_all_help.Visible=False";
Debug.ShouldStop(256);
setting_activity.mostCurrent._pan_all_help.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 394;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_color_home_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_color_home_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,315);
if (RapidSub.canDelegate("lbl_color_home_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_color_home_click");}
 BA.debugLineNum = 315;BA.debugLine="Private Sub lbl_color_home_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 316;BA.debugLine="lbl_color1_Click";
Debug.ShouldStop(134217728);
_lbl_color1_click();
 BA.debugLineNum = 317;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_color1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_color1_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,170);
if (RapidSub.canDelegate("lbl_color1_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_color1_click");}
 BA.debugLineNum = 170;BA.debugLine="Private Sub lbl_color1_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 171;BA.debugLine="pan_all.Visible=True";
Debug.ShouldStop(1024);
setting_activity.mostCurrent._pan_all.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 173;BA.debugLine="color_index=Main.color_index";
Debug.ShouldStop(4096);
setting_activity._color_index = setting_activity.mostCurrent._main._color_index /*RemoteObject*/ ;
 BA.debugLineNum = 175;BA.debugLine="Select color_index";
Debug.ShouldStop(16384);
switch (BA.switchObjectToInt(setting_activity._color_index,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6))) {
case 0: {
 BA.debugLineNum = 177;BA.debugLine="pan_color1_Click";
Debug.ShouldStop(65536);
_pan_color1_click();
 break; }
case 1: {
 BA.debugLineNum = 179;BA.debugLine="pan_color2_Click";
Debug.ShouldStop(262144);
_pan_color2_click();
 break; }
case 2: {
 BA.debugLineNum = 181;BA.debugLine="pan_color3_Click";
Debug.ShouldStop(1048576);
_pan_color3_click();
 break; }
case 3: {
 BA.debugLineNum = 183;BA.debugLine="pan_color4_Click";
Debug.ShouldStop(4194304);
_pan_color4_click();
 break; }
case 4: {
 BA.debugLineNum = 185;BA.debugLine="pan_color5_Click";
Debug.ShouldStop(16777216);
_pan_color5_click();
 break; }
case 5: {
 BA.debugLineNum = 187;BA.debugLine="pan_color6_Click";
Debug.ShouldStop(67108864);
_pan_color6_click();
 break; }
}
;
 BA.debugLineNum = 194;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_font_pan_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_font_pan_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,323);
if (RapidSub.canDelegate("lbl_font_pan_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_font_pan_click");}
 BA.debugLineNum = 323;BA.debugLine="Private Sub lbl_font_pan_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 324;BA.debugLine="pan_all2.Visible=True";
Debug.ShouldStop(8);
setting_activity.mostCurrent._pan_all2.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 330;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_help_font_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help_font_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,348);
if (RapidSub.canDelegate("lbl_help_font_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_help_font_click");}
 BA.debugLineNum = 348;BA.debugLine="Private Sub lbl_help_font_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 353;BA.debugLine="pan_all_help.Visible=True";
Debug.ShouldStop(1);
setting_activity.mostCurrent._pan_all_help.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 354;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_lock_app_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_lock_app_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,396);
if (RapidSub.canDelegate("lbl_lock_app_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_lock_app_click");}
RemoteObject _ls_lock0 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_lock3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 396;BA.debugLine="Private Sub lbl_lock_app_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 398;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=True)T";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock"))),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 399;BA.debugLine="Dim ls_lock0 As List";
Debug.ShouldStop(16384);
_ls_lock0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 400;BA.debugLine="ls_lock0.Initialize";
Debug.ShouldStop(32768);
_ls_lock0.runVoidMethod ("Initialize");
 BA.debugLineNum = 402;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_lock";
Debug.ShouldStop(131072);
_ls_lock0 = setting_activity.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock")));Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 404;BA.debugLine="If(ls_lock0.Get(0)=\"true\")Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),(RemoteObject.createImmutable("true"))))) { 
 BA.debugLineNum = 405;BA.debugLine="ToggleBtn_OffOn_lock.Checked=True";
Debug.ShouldStop(1048576);
setting_activity.mostCurrent._togglebtn_offon_lock.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 406;BA.debugLine="et_pass_lock.Enabled=True";
Debug.ShouldStop(2097152);
setting_activity.mostCurrent._et_pass_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 407;BA.debugLine="et_pass_lock.Text=ls_lock0.Get(2)";
Debug.ShouldStop(4194304);
setting_activity.mostCurrent._et_pass_lock.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 408;BA.debugLine="et_hint_lock.Text=ls_lock0.Get(3)";
Debug.ShouldStop(8388608);
setting_activity.mostCurrent._et_hint_lock.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))));
 }else {
 BA.debugLineNum = 410;BA.debugLine="ToggleBtn_OffOn_lock.Checked=False";
Debug.ShouldStop(33554432);
setting_activity.mostCurrent._togglebtn_offon_lock.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 411;BA.debugLine="ToggleBtn_finger.Enabled=False";
Debug.ShouldStop(67108864);
setting_activity.mostCurrent._togglebtn_finger.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 412;BA.debugLine="et_pass_lock.Enabled=False";
Debug.ShouldStop(134217728);
setting_activity.mostCurrent._et_pass_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 413;BA.debugLine="et_hint_lock.Enabled=False";
Debug.ShouldStop(268435456);
setting_activity.mostCurrent._et_hint_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 414;BA.debugLine="et_pass_lock.Text=\"\"";
Debug.ShouldStop(536870912);
setting_activity.mostCurrent._et_pass_lock.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 417;BA.debugLine="If(ls_lock0.Get(1)=\"true\")Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),(RemoteObject.createImmutable("true"))))) { 
 BA.debugLineNum = 418;BA.debugLine="ToggleBtn_finger.Checked=True";
Debug.ShouldStop(2);
setting_activity.mostCurrent._togglebtn_finger.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 420;BA.debugLine="ToggleBtn_finger.Checked=False";
Debug.ShouldStop(8);
setting_activity.mostCurrent._togglebtn_finger.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 422;BA.debugLine="et_hint_lock.Text=ls_lock0.Get(3)";
Debug.ShouldStop(32);
setting_activity.mostCurrent._et_hint_lock.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))));
 }else {
 BA.debugLineNum = 425;BA.debugLine="Dim ls_lock3 As List";
Debug.ShouldStop(256);
_ls_lock3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_lock3", _ls_lock3);
 BA.debugLineNum = 426;BA.debugLine="ls_lock3.Initialize";
Debug.ShouldStop(512);
_ls_lock3.runVoidMethod ("Initialize");
 BA.debugLineNum = 428;BA.debugLine="ls_lock3.Add(\"false\")";
Debug.ShouldStop(2048);
_ls_lock3.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 429;BA.debugLine="ls_lock3.Add(\"false\")";
Debug.ShouldStop(4096);
_ls_lock3.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 430;BA.debugLine="ls_lock3.Add(\"\")";
Debug.ShouldStop(8192);
_ls_lock3.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 431;BA.debugLine="ls_lock3.Add(\"\")";
Debug.ShouldStop(16384);
_ls_lock3.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 434;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_loc";
Debug.ShouldStop(131072);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls_lock")),(Object)(_ls_lock3));
 BA.debugLineNum = 437;BA.debugLine="ToggleBtn_OffOn_lock.Checked=False";
Debug.ShouldStop(1048576);
setting_activity.mostCurrent._togglebtn_offon_lock.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 438;BA.debugLine="ToggleBtn_finger.Enabled=False";
Debug.ShouldStop(2097152);
setting_activity.mostCurrent._togglebtn_finger.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 439;BA.debugLine="ToggleBtn_finger.Checked=False";
Debug.ShouldStop(4194304);
setting_activity.mostCurrent._togglebtn_finger.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 440;BA.debugLine="et_pass_lock.Enabled=False";
Debug.ShouldStop(8388608);
setting_activity.mostCurrent._et_pass_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 441;BA.debugLine="et_hint_lock.Enabled=False";
Debug.ShouldStop(16777216);
setting_activity.mostCurrent._et_hint_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 448;BA.debugLine="pan_all_lock.Visible=True";
Debug.ShouldStop(-2147483648);
setting_activity.mostCurrent._pan_all_lock.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 449;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_rest_font_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_rest_font_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,332);
if (RapidSub.canDelegate("lbl_rest_font_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_rest_font_click");}
 BA.debugLineNum = 332;BA.debugLine="Private Sub lbl_rest_font_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 333;BA.debugLine="sp_font.SelectedIndex=0";
Debug.ShouldStop(4096);
setting_activity.mostCurrent._sp_font.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 BA.debugLineNum = 335;BA.debugLine="skb_f1.Value=17";
Debug.ShouldStop(16384);
setting_activity.mostCurrent._skb_f1.runMethod(true,"setValue",BA.numberCast(int.class, 17));
 BA.debugLineNum = 336;BA.debugLine="skb_f2.Value=15";
Debug.ShouldStop(32768);
setting_activity.mostCurrent._skb_f2.runMethod(true,"setValue",BA.numberCast(int.class, 15));
 BA.debugLineNum = 337;BA.debugLine="skb_f3.Value=13";
Debug.ShouldStop(65536);
setting_activity.mostCurrent._skb_f3.runMethod(true,"setValue",BA.numberCast(int.class, 13));
 BA.debugLineNum = 339;BA.debugLine="lbl_skb_f1.Text=17";
Debug.ShouldStop(262144);
setting_activity.mostCurrent._lbl_skb_f1.runMethod(true,"setText",BA.ObjectToCharSequence(17));
 BA.debugLineNum = 340;BA.debugLine="lbl_skb_f2.Text=15";
Debug.ShouldStop(524288);
setting_activity.mostCurrent._lbl_skb_f2.runMethod(true,"setText",BA.ObjectToCharSequence(15));
 BA.debugLineNum = 341;BA.debugLine="lbl_skb_f3.Text=13";
Debug.ShouldStop(1048576);
setting_activity.mostCurrent._lbl_skb_f3.runMethod(true,"setText",BA.ObjectToCharSequence(13));
 BA.debugLineNum = 346;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _lbl_restore_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_restore_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,145);
if (RapidSub.canDelegate("lbl_restore_click")) { ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_restore_click"); return;}
ResumableSub_lbl_restore_Click rsub = new ResumableSub_lbl_restore_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_lbl_restore_Click extends BA.ResumableSub {
public ResumableSub_lbl_restore_Click(ir.taravatgroup.ezafekari2.setting_activity parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ir.taravatgroup.ezafekari2.setting_activity parent;
RemoteObject _success = RemoteObject.createImmutable(false);
RemoteObject _dir = RemoteObject.createImmutable("");
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("lbl_restore_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,145);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 146;BA.debugLine="cc.Initialize(\"CC\")";
Debug.ShouldStop(131072);
parent._cc.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("CC")));
 BA.debugLineNum = 147;BA.debugLine="cc.Show(\"*/*\", \"انتخاب فایل دیتابیس\")";
Debug.ShouldStop(262144);
parent._cc.runVoidMethod ("Show",setting_activity.processBA,(Object)(BA.ObjectToString("*/*")),(Object)(RemoteObject.createImmutable("انتخاب فایل دیتابیس")));
 BA.debugLineNum = 148;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
Debug.ShouldStop(524288);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","cc_result", setting_activity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "setting_activity", "lbl_restore_click"), null);
this.state = 9;
return;
case 9:
//C
this.state = 1;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
_dir = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Dir", _dir);
_filename = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(2));Debug.locals.put("FileName", _filename);
;
 BA.debugLineNum = 149;BA.debugLine="If Success Then";
Debug.ShouldStop(1048576);
if (true) break;

case 1:
//if
this.state = 8;
if (_success.<Boolean>get().booleanValue()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 150;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.SharedFo";
Debug.ShouldStop(2097152);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_dir),(Object)(_filename),(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.createImmutable("db2.db")));
 BA.debugLineNum = 152;BA.debugLine="Log( Dir)";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","132243719",_dir,0);
 BA.debugLineNum = 153;BA.debugLine="Log(FileName)";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","132243720",_filename,0);
 BA.debugLineNum = 154;BA.debugLine="Log(File.Exists(Starter.Provider.SharedFolder,\"d";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","132243721",BA.ObjectToString(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.createImmutable("db2.db")))),0);
 BA.debugLineNum = 156;BA.debugLine="Dim result As Int";
Debug.ShouldStop(134217728);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 158;BA.debugLine="result = Msgbox2(\"دیتای قبلی حذف و دیتای جدید جا";
Debug.ShouldStop(536870912);
_result = parent.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("دیتای قبلی حذف و دیتای جدید جایگزین می شود.")),(Object)(BA.ObjectToCharSequence("توجه")),(Object)(BA.ObjectToString("باشه")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("نه")),(Object)((parent.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("attention.png"))).getObject())),setting_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 159;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(1073741824);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 160;BA.debugLine="File.Copy(Starter.Provider.SharedFolder,\"db2.db";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(BA.ObjectToString("db2.db")),(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("db.db")));
 BA.debugLineNum = 161;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",setting_activity.processBA,(Object)((parent.mostCurrent._main.getObject())));
 BA.debugLineNum = 162;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2);
parent.mostCurrent._activity.runVoidMethod ("Finish");
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
 BA.debugLineNum = 168;BA.debugLine="End Sub";
Debug.ShouldStop(128);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _cc_result(RemoteObject _success,RemoteObject _dir,RemoteObject _filename) throws Exception{
}
public static RemoteObject  _lbl_save_color_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_color_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,289);
if (RapidSub.canDelegate("lbl_save_color_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_save_color_click");}
 BA.debugLineNum = 289;BA.debugLine="Private Sub lbl_save_color_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 290;BA.debugLine="Main.color1=color1";
Debug.ShouldStop(2);
setting_activity.mostCurrent._main._color1 /*RemoteObject*/  = setting_activity._color1;
 BA.debugLineNum = 291;BA.debugLine="Main.color2=color2";
Debug.ShouldStop(4);
setting_activity.mostCurrent._main._color2 /*RemoteObject*/  = setting_activity._color2;
 BA.debugLineNum = 292;BA.debugLine="Main.color3=color3";
Debug.ShouldStop(8);
setting_activity.mostCurrent._main._color3 /*RemoteObject*/  = setting_activity._color3;
 BA.debugLineNum = 293;BA.debugLine="Main.color4=color4";
Debug.ShouldStop(16);
setting_activity.mostCurrent._main._color4 /*RemoteObject*/  = setting_activity._color4;
 BA.debugLineNum = 294;BA.debugLine="Main.color5=color5";
Debug.ShouldStop(32);
setting_activity.mostCurrent._main._color5 /*RemoteObject*/  = setting_activity._color5;
 BA.debugLineNum = 295;BA.debugLine="Main.color_index=color_index";
Debug.ShouldStop(64);
setting_activity.mostCurrent._main._color_index /*RemoteObject*/  = setting_activity._color_index;
 BA.debugLineNum = 297;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
Debug.ShouldStop(256);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("setcolor.txt")),(Object)(RemoteObject.concat(setting_activity.mostCurrent._main._color1 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color2 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color_index /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color3 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color4 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color5 /*RemoteObject*/ ,setting_activity.mostCurrent.__c.getField(true,"CRLF"),setting_activity.mostCurrent._main._main_font /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._size_f1 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._size_f2 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._size_f3 /*RemoteObject*/ )));
 BA.debugLineNum = 299;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(1024);
setting_activity.mostCurrent._pan_all.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 300;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
Debug.ShouldStop(2048);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تغییرات ذخیره شد")),(Object)(setting_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 304;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_font_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_font_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,356);
if (RapidSub.canDelegate("lbl_save_font_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_save_font_click");}
 BA.debugLineNum = 356;BA.debugLine="Private Sub lbl_save_font_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 360;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
Debug.ShouldStop(128);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("setcolor.txt")),(Object)(RemoteObject.concat(setting_activity.mostCurrent._main._color1 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color2 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity._color_index,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color3 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color4 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color5 /*RemoteObject*/ ,setting_activity.mostCurrent.__c.getField(true,"CRLF"),setting_activity.mostCurrent._sp_font.runMethod(true,"getSelectedItem"),RemoteObject.createImmutable(","),setting_activity.mostCurrent._skb_f1.runMethod(true,"getValue"),RemoteObject.createImmutable(","),setting_activity.mostCurrent._skb_f2.runMethod(true,"getValue"),RemoteObject.createImmutable(","),setting_activity.mostCurrent._skb_f3.runMethod(true,"getValue"))));
 BA.debugLineNum = 364;BA.debugLine="pan_all2_Click";
Debug.ShouldStop(2048);
_pan_all2_click();
 BA.debugLineNum = 365;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
Debug.ShouldStop(4096);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تغییرات ذخیره شد")),(Object)(setting_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 369;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_lock_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_lock_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,451);
if (RapidSub.canDelegate("lbl_save_lock_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_save_lock_click");}
RemoteObject _ls_lock = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 451;BA.debugLine="Private Sub lbl_save_lock_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 452;BA.debugLine="Dim ls_lock As List";
Debug.ShouldStop(8);
_ls_lock = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_lock", _ls_lock);
 BA.debugLineNum = 453;BA.debugLine="ls_lock.Initialize";
Debug.ShouldStop(16);
_ls_lock.runVoidMethod ("Initialize");
 BA.debugLineNum = 457;BA.debugLine="If (ToggleBtn_OffOn_lock.Checked=True)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._togglebtn_offon_lock.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 458;BA.debugLine="If(et_pass_lock.Text.Length <> 4)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("!",setting_activity.mostCurrent._et_pass_lock.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 459;BA.debugLine="ToastMessageShow(\"تعیین رمز\",False)";
Debug.ShouldStop(1024);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تعیین رمز")),(Object)(setting_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 463;BA.debugLine="ls_lock.Add(\"true\")";
Debug.ShouldStop(16384);
_ls_lock.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("true"))));
 BA.debugLineNum = 464;BA.debugLine="ls_lock.Add(ToggleBtn_finger.Checked)";
Debug.ShouldStop(32768);
_ls_lock.runVoidMethod ("Add",(Object)((setting_activity.mostCurrent._togglebtn_finger.runMethod(true,"getChecked"))));
 BA.debugLineNum = 465;BA.debugLine="ls_lock.Add(et_pass_lock.Text)";
Debug.ShouldStop(65536);
_ls_lock.runVoidMethod ("Add",(Object)((setting_activity.mostCurrent._et_pass_lock.runMethod(true,"getText"))));
 BA.debugLineNum = 466;BA.debugLine="ls_lock.Add(et_hint_lock.Text)";
Debug.ShouldStop(131072);
_ls_lock.runVoidMethod ("Add",(Object)((setting_activity.mostCurrent._et_hint_lock.runMethod(true,"getText"))));
 BA.debugLineNum = 469;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_lo";
Debug.ShouldStop(1048576);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls_lock")),(Object)(_ls_lock));
 BA.debugLineNum = 471;BA.debugLine="pan_all_lock_Click";
Debug.ShouldStop(4194304);
_pan_all_lock_click();
 };
 }else {
 BA.debugLineNum = 475;BA.debugLine="ls_lock.Add(\"false\")";
Debug.ShouldStop(67108864);
_ls_lock.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 476;BA.debugLine="ls_lock.Add(ToggleBtn_finger.Checked)";
Debug.ShouldStop(134217728);
_ls_lock.runVoidMethod ("Add",(Object)((setting_activity.mostCurrent._togglebtn_finger.runMethod(true,"getChecked"))));
 BA.debugLineNum = 477;BA.debugLine="ls_lock.Add(\"\")";
Debug.ShouldStop(268435456);
_ls_lock.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 478;BA.debugLine="ls_lock.Add(\"\")";
Debug.ShouldStop(536870912);
_ls_lock.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 479;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_loc";
Debug.ShouldStop(1073741824);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls_lock")),(Object)(_ls_lock));
 BA.debugLineNum = 480;BA.debugLine="pan_all_lock_Click";
Debug.ShouldStop(-2147483648);
_pan_all_lock_click();
 };
 BA.debugLineNum = 484;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,196);
if (RapidSub.canDelegate("pan_all_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_all_click");}
 BA.debugLineNum = 196;BA.debugLine="Private Sub pan_all_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 197;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(16);
setting_activity.mostCurrent._pan_all.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 199;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_lock_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_lock_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,514);
if (RapidSub.canDelegate("pan_all_lock_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_all_lock_click");}
 BA.debugLineNum = 514;BA.debugLine="Private Sub pan_all_lock_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 515;BA.debugLine="pan_all_lock.Visible=False";
Debug.ShouldStop(4);
setting_activity.mostCurrent._pan_all_lock.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 516;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all2_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all2_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,383);
if (RapidSub.canDelegate("pan_all2_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_all2_click");}
 BA.debugLineNum = 383;BA.debugLine="Private Sub pan_all2_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 384;BA.debugLine="pan_all2.Visible=False";
Debug.ShouldStop(-2147483648);
setting_activity.mostCurrent._pan_all2.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 385;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_color1_click() throws Exception{
try {
		Debug.PushSubsStack("pan_color1_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,275);
if (RapidSub.canDelegate("pan_color1_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color1_click");}
 BA.debugLineNum = 275;BA.debugLine="Private Sub pan_color1_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 276;BA.debugLine="tik_all_dis";
Debug.ShouldStop(524288);
_tik_all_dis();
 BA.debugLineNum = 277;BA.debugLine="color1=0XFF69AC00";
Debug.ShouldStop(1048576);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xff69ac00));
 BA.debugLineNum = 278;BA.debugLine="color2=0xFF00C7C7";
Debug.ShouldStop(2097152);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xff00c7c7));
 BA.debugLineNum = 279;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(4194304);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 280;BA.debugLine="color4=0XFF69AC00";
Debug.ShouldStop(8388608);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xff69ac00));
 BA.debugLineNum = 281;BA.debugLine="color5=0xFF00C7C7";
Debug.ShouldStop(16777216);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xff00c7c7));
 BA.debugLineNum = 284;BA.debugLine="color_index=1";
Debug.ShouldStop(134217728);
setting_activity._color_index = BA.numberCast(int.class, 1);
 BA.debugLineNum = 285;BA.debugLine="tik1.Visible=True";
Debug.ShouldStop(268435456);
setting_activity.mostCurrent._tik1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 287;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_color2_click() throws Exception{
try {
		Debug.PushSubsStack("pan_color2_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,260);
if (RapidSub.canDelegate("pan_color2_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color2_click");}
 BA.debugLineNum = 260;BA.debugLine="Private Sub pan_color2_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 261;BA.debugLine="tik_all_dis";
Debug.ShouldStop(16);
_tik_all_dis();
 BA.debugLineNum = 262;BA.debugLine="color1 = 0xFF7F19EE";
Debug.ShouldStop(32);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xff7f19ee));
 BA.debugLineNum = 263;BA.debugLine="color2 = 0xFF567BFF";
Debug.ShouldStop(64);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xff567bff));
 BA.debugLineNum = 264;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(128);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 265;BA.debugLine="color4=0xFF567BFF";
Debug.ShouldStop(256);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xff567bff));
 BA.debugLineNum = 266;BA.debugLine="color5=0xFF567BFF";
Debug.ShouldStop(512);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xff567bff));
 BA.debugLineNum = 270;BA.debugLine="color_index=2";
Debug.ShouldStop(8192);
setting_activity._color_index = BA.numberCast(int.class, 2);
 BA.debugLineNum = 271;BA.debugLine="tik2.Visible=True";
Debug.ShouldStop(16384);
setting_activity.mostCurrent._tik2.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 273;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_color3_click() throws Exception{
try {
		Debug.PushSubsStack("pan_color3_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,245);
if (RapidSub.canDelegate("pan_color3_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color3_click");}
 BA.debugLineNum = 245;BA.debugLine="Private Sub pan_color3_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 246;BA.debugLine="tik_all_dis";
Debug.ShouldStop(2097152);
_tik_all_dis();
 BA.debugLineNum = 247;BA.debugLine="color1 = 0xFF2BC1F6";
Debug.ShouldStop(4194304);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xff2bc1f6));
 BA.debugLineNum = 248;BA.debugLine="color2 = 0xFF1E45D1";
Debug.ShouldStop(8388608);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xff1e45d1));
 BA.debugLineNum = 249;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(16777216);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 250;BA.debugLine="color4=0xFF2BC1F6";
Debug.ShouldStop(33554432);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xff2bc1f6));
 BA.debugLineNum = 251;BA.debugLine="color5=0xFF1E45D1";
Debug.ShouldStop(67108864);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xff1e45d1));
 BA.debugLineNum = 256;BA.debugLine="color_index=3";
Debug.ShouldStop(-2147483648);
setting_activity._color_index = BA.numberCast(int.class, 3);
 BA.debugLineNum = 257;BA.debugLine="tik3.Visible=True";
Debug.ShouldStop(1);
setting_activity.mostCurrent._tik3.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 258;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_color4_click() throws Exception{
try {
		Debug.PushSubsStack("pan_color4_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,230);
if (RapidSub.canDelegate("pan_color4_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color4_click");}
 BA.debugLineNum = 230;BA.debugLine="Private Sub pan_color4_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 231;BA.debugLine="tik_all_dis";
Debug.ShouldStop(64);
_tik_all_dis();
 BA.debugLineNum = 232;BA.debugLine="color1 = 0xFFDD00FF";
Debug.ShouldStop(128);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xffdd00ff));
 BA.debugLineNum = 233;BA.debugLine="color2 = 0xFF0090FF";
Debug.ShouldStop(256);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xff0090ff));
 BA.debugLineNum = 234;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(512);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 235;BA.debugLine="color4=0xFFDD00FF";
Debug.ShouldStop(1024);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xffdd00ff));
 BA.debugLineNum = 236;BA.debugLine="color5=0xFF24EB9D";
Debug.ShouldStop(2048);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xff24eb9d));
 BA.debugLineNum = 241;BA.debugLine="color_index=4";
Debug.ShouldStop(65536);
setting_activity._color_index = BA.numberCast(int.class, 4);
 BA.debugLineNum = 242;BA.debugLine="tik4.Visible=True";
Debug.ShouldStop(131072);
setting_activity.mostCurrent._tik4.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 243;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_color5_click() throws Exception{
try {
		Debug.PushSubsStack("pan_color5_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,216);
if (RapidSub.canDelegate("pan_color5_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color5_click");}
 BA.debugLineNum = 216;BA.debugLine="Private Sub pan_color5_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 217;BA.debugLine="tik_all_dis";
Debug.ShouldStop(16777216);
_tik_all_dis();
 BA.debugLineNum = 218;BA.debugLine="color1 = 0xFFCF5263";
Debug.ShouldStop(33554432);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xffcf5263));
 BA.debugLineNum = 219;BA.debugLine="color2 = 0xFFABC01A";
Debug.ShouldStop(67108864);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xffabc01a));
 BA.debugLineNum = 220;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(134217728);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 221;BA.debugLine="color4=0xFFCF5263";
Debug.ShouldStop(268435456);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xffcf5263));
 BA.debugLineNum = 222;BA.debugLine="color5=0xFFABC01A";
Debug.ShouldStop(536870912);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xffabc01a));
 BA.debugLineNum = 226;BA.debugLine="color_index=5";
Debug.ShouldStop(2);
setting_activity._color_index = BA.numberCast(int.class, 5);
 BA.debugLineNum = 227;BA.debugLine="tik5.Visible=True";
Debug.ShouldStop(4);
setting_activity.mostCurrent._tik5.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 228;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_color6_click() throws Exception{
try {
		Debug.PushSubsStack("pan_color6_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,201);
if (RapidSub.canDelegate("pan_color6_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color6_click");}
 BA.debugLineNum = 201;BA.debugLine="Private Sub pan_color6_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 202;BA.debugLine="tik_all_dis";
Debug.ShouldStop(512);
_tik_all_dis();
 BA.debugLineNum = 203;BA.debugLine="color1= 0xFF5289CF";
Debug.ShouldStop(1024);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xff5289cf));
 BA.debugLineNum = 204;BA.debugLine="color2= 0xFFABC01A";
Debug.ShouldStop(2048);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xffabc01a));
 BA.debugLineNum = 205;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(4096);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 206;BA.debugLine="color4=0xFF5289CF";
Debug.ShouldStop(8192);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xff5289cf));
 BA.debugLineNum = 207;BA.debugLine="color5=0xFFABC01A";
Debug.ShouldStop(16384);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xffabc01a));
 BA.debugLineNum = 212;BA.debugLine="color_index=6";
Debug.ShouldStop(524288);
setting_activity._color_index = BA.numberCast(int.class, 6);
 BA.debugLineNum = 213;BA.debugLine="tik6.Visible=True";
Debug.ShouldStop(1048576);
setting_activity.mostCurrent._tik6.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 214;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_colors_click() throws Exception{
try {
		Debug.PushSubsStack("pan_colors_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,319);
if (RapidSub.canDelegate("pan_colors_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_colors_click");}
 BA.debugLineNum = 319;BA.debugLine="Private Sub pan_colors_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 321;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_font_click() throws Exception{
try {
		Debug.PushSubsStack("pan_font_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,387);
if (RapidSub.canDelegate("pan_font_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_font_click");}
 BA.debugLineNum = 387;BA.debugLine="Private Sub pan_font_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 389;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_lock_click() throws Exception{
try {
		Debug.PushSubsStack("pan_lock_Click (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,518);
if (RapidSub.canDelegate("pan_lock_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_lock_click");}
 BA.debugLineNum = 518;BA.debugLine="Private Sub pan_lock_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 520;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private cc As ContentChooser";
setting_activity._cc = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.ContentChooser");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _skb_f1_valuechanged(RemoteObject _value,RemoteObject _userchanged) throws Exception{
try {
		Debug.PushSubsStack("skb_f1_ValueChanged (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,379);
if (RapidSub.canDelegate("skb_f1_valuechanged")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","skb_f1_valuechanged", _value, _userchanged);}
Debug.locals.put("Value", _value);
Debug.locals.put("UserChanged", _userchanged);
 BA.debugLineNum = 379;BA.debugLine="Private Sub skb_f1_ValueChanged (Value As Int, Use";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 380;BA.debugLine="lbl_skb_f1.Text=Value";
Debug.ShouldStop(134217728);
setting_activity.mostCurrent._lbl_skb_f1.runMethod(true,"setText",BA.ObjectToCharSequence(_value));
 BA.debugLineNum = 381;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _skb_f2_valuechanged(RemoteObject _value,RemoteObject _userchanged) throws Exception{
try {
		Debug.PushSubsStack("skb_f2_ValueChanged (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,375);
if (RapidSub.canDelegate("skb_f2_valuechanged")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","skb_f2_valuechanged", _value, _userchanged);}
Debug.locals.put("Value", _value);
Debug.locals.put("UserChanged", _userchanged);
 BA.debugLineNum = 375;BA.debugLine="Private Sub skb_f2_ValueChanged (Value As Int, Use";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 376;BA.debugLine="lbl_skb_f2.Text=Value";
Debug.ShouldStop(8388608);
setting_activity.mostCurrent._lbl_skb_f2.runMethod(true,"setText",BA.ObjectToCharSequence(_value));
 BA.debugLineNum = 377;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _skb_f3_valuechanged(RemoteObject _value,RemoteObject _userchanged) throws Exception{
try {
		Debug.PushSubsStack("skb_f3_ValueChanged (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,371);
if (RapidSub.canDelegate("skb_f3_valuechanged")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","skb_f3_valuechanged", _value, _userchanged);}
Debug.locals.put("Value", _value);
Debug.locals.put("UserChanged", _userchanged);
 BA.debugLineNum = 371;BA.debugLine="Private Sub skb_f3_ValueChanged (Value As Int, Use";
Debug.ShouldStop(262144);
 BA.debugLineNum = 372;BA.debugLine="lbl_skb_f3.Text=Value";
Debug.ShouldStop(524288);
setting_activity.mostCurrent._lbl_skb_f3.runMethod(true,"setText",BA.ObjectToCharSequence(_value));
 BA.debugLineNum = 373;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tik_all_dis() throws Exception{
try {
		Debug.PushSubsStack("tik_all_dis (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,306);
if (RapidSub.canDelegate("tik_all_dis")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","tik_all_dis");}
 BA.debugLineNum = 306;BA.debugLine="Sub tik_all_dis";
Debug.ShouldStop(131072);
 BA.debugLineNum = 307;BA.debugLine="tik1.Visible=False";
Debug.ShouldStop(262144);
setting_activity.mostCurrent._tik1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 308;BA.debugLine="tik2.Visible=False";
Debug.ShouldStop(524288);
setting_activity.mostCurrent._tik2.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 309;BA.debugLine="tik3.Visible=False";
Debug.ShouldStop(1048576);
setting_activity.mostCurrent._tik3.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 310;BA.debugLine="tik4.Visible=False";
Debug.ShouldStop(2097152);
setting_activity.mostCurrent._tik4.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 311;BA.debugLine="tik5.Visible=False";
Debug.ShouldStop(4194304);
setting_activity.mostCurrent._tik5.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 312;BA.debugLine="tik6.Visible=False";
Debug.ShouldStop(8388608);
setting_activity.mostCurrent._tik6.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 313;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _togglebtn_finger_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("ToggleBtn_finger_CheckedChange (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,522);
if (RapidSub.canDelegate("togglebtn_finger_checkedchange")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","togglebtn_finger_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 522;BA.debugLine="Private Sub ToggleBtn_finger_CheckedChange(Checked";
Debug.ShouldStop(512);
 BA.debugLineNum = 523;BA.debugLine="Try";
Debug.ShouldStop(1024);
try { BA.debugLineNum = 524;BA.debugLine="fingerprint1.Initialize (Me, \"auth\")";
Debug.ShouldStop(2048);
setting_activity.mostCurrent._fingerprint1.runClassMethod (ir.taravatgroup.ezafekari2.fingerprintmanager.class, "_initialize" /*RemoteObject*/ ,setting_activity.processBA,(Object)(setting_activity.getObject()),(Object)(RemoteObject.createImmutable("auth")));
 BA.debugLineNum = 525;BA.debugLine="If fingerprint1.HardwareDetected = False Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",setting_activity.mostCurrent._fingerprint1.runClassMethod (ir.taravatgroup.ezafekari2.fingerprintmanager.class, "_gethardwaredetected" /*RemoteObject*/ ),setting_activity.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 526;BA.debugLine="ToastMessageShow(\"سنسور اثر انگشت موجود نیست\",";
Debug.ShouldStop(8192);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("سنسور اثر انگشت موجود نیست")),(Object)(setting_activity.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 527;BA.debugLine="ToggleBtn_finger.Checked=False";
Debug.ShouldStop(16384);
setting_activity.mostCurrent._togglebtn_finger.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 528;BA.debugLine="Else if fingerprint1.HasEnrolledFingerprints = F";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",setting_activity.mostCurrent._fingerprint1.runClassMethod (ir.taravatgroup.ezafekari2.fingerprintmanager.class, "_gethasenrolledfingerprints" /*RemoteObject*/ ),setting_activity.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 529;BA.debugLine="ToastMessageShow(\"اثر انگشت تعریف نشده است\", Fa";
Debug.ShouldStop(65536);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اثر انگشت تعریف نشده است")),(Object)(setting_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 530;BA.debugLine="ToggleBtn_finger.Checked=False";
Debug.ShouldStop(131072);
setting_activity.mostCurrent._togglebtn_finger.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 }}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e11) {
			BA.rdebugUtils.runVoidMethod("setLastException",setting_activity.processBA, e11.toString()); BA.debugLineNum = 534;BA.debugLine="ToastMessageShow(\"سنسور اثر انگشت موجود نیست\", T";
Debug.ShouldStop(2097152);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("سنسور اثر انگشت موجود نیست")),(Object)(setting_activity.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 535;BA.debugLine="ToggleBtn_finger.Checked=False";
Debug.ShouldStop(4194304);
setting_activity.mostCurrent._togglebtn_finger.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 536;BA.debugLine="Log(LastException)";
Debug.ShouldStop(8388608);
setting_activity.mostCurrent.__c.runVoidMethod ("LogImpl","134144270",BA.ObjectToString(setting_activity.mostCurrent.__c.runMethod(false,"LastException",setting_activity.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 539;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _togglebtn_offon_lock_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("ToggleBtn_OffOn_lock_CheckedChange (setting_activity) ","setting_activity",20,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,493);
if (RapidSub.canDelegate("togglebtn_offon_lock_checkedchange")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","togglebtn_offon_lock_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 493;BA.debugLine="Private Sub ToggleBtn_OffOn_lock_CheckedChange(Che";
Debug.ShouldStop(4096);
 BA.debugLineNum = 494;BA.debugLine="Try";
Debug.ShouldStop(8192);
try { BA.debugLineNum = 495;BA.debugLine="If(ToggleBtn_OffOn_lock.Checked=False)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._togglebtn_offon_lock.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 496;BA.debugLine="et_pass_lock.Enabled=False";
Debug.ShouldStop(32768);
setting_activity.mostCurrent._et_pass_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 497;BA.debugLine="ToggleBtn_finger.Enabled=False";
Debug.ShouldStop(65536);
setting_activity.mostCurrent._togglebtn_finger.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 498;BA.debugLine="et_hint_lock.Enabled=False";
Debug.ShouldStop(131072);
setting_activity.mostCurrent._et_hint_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 500;BA.debugLine="et_pass_lock.Enabled=True";
Debug.ShouldStop(524288);
setting_activity.mostCurrent._et_pass_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 501;BA.debugLine="ToggleBtn_finger.Enabled=True";
Debug.ShouldStop(1048576);
setting_activity.mostCurrent._togglebtn_finger.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 502;BA.debugLine="et_hint_lock.Enabled=True";
Debug.ShouldStop(2097152);
setting_activity.mostCurrent._et_hint_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"True"));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",setting_activity.processBA, e12.toString()); BA.debugLineNum = 506;BA.debugLine="Log(LastException)";
Debug.ShouldStop(33554432);
setting_activity.mostCurrent.__c.runVoidMethod ("LogImpl","133947661",BA.ObjectToString(setting_activity.mostCurrent.__c.runMethod(false,"LastException",setting_activity.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 512;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}