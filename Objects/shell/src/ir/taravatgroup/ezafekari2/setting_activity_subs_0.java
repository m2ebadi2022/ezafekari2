package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class setting_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,48);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 48;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 50;BA.debugLine="Activity.LoadLayout(\"setting_layout\")";
Debug.ShouldStop(131072);
setting_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("setting_layout")),setting_activity.mostCurrent.activityBA);
 BA.debugLineNum = 55;BA.debugLine="pan_hed_setting.Color=Main.color4";
Debug.ShouldStop(4194304);
setting_activity.mostCurrent._pan_hed_setting.runVoidMethod ("setColor",setting_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 56;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(8388608);
setting_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(setting_activity.mostCurrent._activity));
 BA.debugLineNum = 59;BA.debugLine="sp_font.Add(\"یکان\")";
Debug.ShouldStop(67108864);
setting_activity.mostCurrent._sp_font.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("یکان")));
 BA.debugLineNum = 60;BA.debugLine="sp_font.Add(\"نازنین\")";
Debug.ShouldStop(134217728);
setting_activity.mostCurrent._sp_font.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("نازنین")));
 BA.debugLineNum = 61;BA.debugLine="sp_font.Add(\"وزیر\")";
Debug.ShouldStop(268435456);
setting_activity.mostCurrent._sp_font.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("وزیر")));
 BA.debugLineNum = 62;BA.debugLine="sp_font.Add(\"دست نویس\")";
Debug.ShouldStop(536870912);
setting_activity.mostCurrent._sp_font.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("دست نویس")));
 BA.debugLineNum = 63;BA.debugLine="sp_font.Add(\"کودک\")";
Debug.ShouldStop(1073741824);
setting_activity.mostCurrent._sp_font.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("کودک")));
 BA.debugLineNum = 66;BA.debugLine="skb_f1.Value=Main.size_f1";
Debug.ShouldStop(2);
setting_activity.mostCurrent._skb_f1.runMethod(true,"setValue",setting_activity.mostCurrent._main._size_f1 /*RemoteObject*/ );
 BA.debugLineNum = 67;BA.debugLine="skb_f2.Value=Main.size_f2";
Debug.ShouldStop(4);
setting_activity.mostCurrent._skb_f2.runMethod(true,"setValue",setting_activity.mostCurrent._main._size_f2 /*RemoteObject*/ );
 BA.debugLineNum = 68;BA.debugLine="skb_f3.Value=Main.size_f3";
Debug.ShouldStop(8);
setting_activity.mostCurrent._skb_f3.runMethod(true,"setValue",setting_activity.mostCurrent._main._size_f3 /*RemoteObject*/ );
 BA.debugLineNum = 70;BA.debugLine="lbl_skb_f1.Text=Main.size_f1";
Debug.ShouldStop(32);
setting_activity.mostCurrent._lbl_skb_f1.runMethod(true,"setText",BA.ObjectToCharSequence(setting_activity.mostCurrent._main._size_f1 /*RemoteObject*/ ));
 BA.debugLineNum = 71;BA.debugLine="lbl_skb_f2.Text=Main.size_f2";
Debug.ShouldStop(64);
setting_activity.mostCurrent._lbl_skb_f2.runMethod(true,"setText",BA.ObjectToCharSequence(setting_activity.mostCurrent._main._size_f2 /*RemoteObject*/ ));
 BA.debugLineNum = 72;BA.debugLine="lbl_skb_f3.Text=Main.size_f3";
Debug.ShouldStop(128);
setting_activity.mostCurrent._lbl_skb_f3.runMethod(true,"setText",BA.ObjectToCharSequence(setting_activity.mostCurrent._main._size_f3 /*RemoteObject*/ ));
 BA.debugLineNum = 76;BA.debugLine="sp_font.SelectedIndex=sp_font.IndexOf(Main.main_f";
Debug.ShouldStop(2048);
setting_activity.mostCurrent._sp_font.runMethod(true,"setSelectedIndex",setting_activity.mostCurrent._sp_font.runMethod(true,"IndexOf",(Object)(setting_activity.mostCurrent._main._main_font /*RemoteObject*/ )));
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("Activity_KeyPress (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,88);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 88;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 89;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, setting_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 90;BA.debugLine="If(pan_all.Visible=True)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._pan_all.runMethod(true,"getVisible"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 91;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(67108864);
setting_activity.mostCurrent._pan_all.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 93;BA.debugLine="Else If (pan_all_help.Visible=True) Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._pan_all_help.runMethod(true,"getVisible"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 94;BA.debugLine="pan_all_help.Visible=False";
Debug.ShouldStop(536870912);
setting_activity.mostCurrent._pan_all_help.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 95;BA.debugLine="Else If (pan_all2.Visible=True)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._pan_all2.runMethod(true,"getVisible"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 96;BA.debugLine="pan_all2.Visible=False";
Debug.ShouldStop(-2147483648);
setting_activity.mostCurrent._pan_all2.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 99;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(4);
_lbl_back_click();
 }}}
;
 BA.debugLineNum = 102;BA.debugLine="Return True";
Debug.ShouldStop(32);
if (true) return setting_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 104;BA.debugLine="Return False";
Debug.ShouldStop(128);
if (true) return setting_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 106;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("Activity_Pause (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,84);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 84;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(524288);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,80);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_resume");}
 BA.debugLineNum = 80;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(32768);
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,108);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_back_click");}
 BA.debugLineNum = 108;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 109;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(4096);
setting_activity.mostCurrent.__c.runVoidMethod ("StartActivity",setting_activity.processBA,(Object)((setting_activity.mostCurrent._main.getObject())));
 BA.debugLineNum = 110;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8192);
setting_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 111;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("lbl_backup_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,115);
if (RapidSub.canDelegate("lbl_backup_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_backup_click");}
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _email = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.Email");
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 115;BA.debugLine="Private Sub lbl_backup_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 117;BA.debugLine="Dim FileName As String = \"db.db\"";
Debug.ShouldStop(1048576);
_filename = BA.ObjectToString("db.db");Debug.locals.put("FileName", _filename);Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 120;BA.debugLine="File.Copy(File.DirInternal, FileName, Starter.Pro";
Debug.ShouldStop(8388608);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_filename),(Object)(setting_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(_filename));
 BA.debugLineNum = 122;BA.debugLine="Dim email As Email";
Debug.ShouldStop(33554432);
_email = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.Email");Debug.locals.put("email", _email);
 BA.debugLineNum = 123;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
Debug.ShouldStop(67108864);
_email.getField(false,"To").runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("aaa@bbb.com"))));
 BA.debugLineNum = 124;BA.debugLine="email.Subject = \"subject\"";
Debug.ShouldStop(134217728);
_email.setField ("Subject",BA.ObjectToString("subject"));
 BA.debugLineNum = 125;BA.debugLine="email.Body = \"backup-\"&DateTime.Date(DateTime.Now";
Debug.ShouldStop(268435456);
_email.setField ("Body",RemoteObject.concat(RemoteObject.createImmutable("backup-"),setting_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(setting_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))));
 BA.debugLineNum = 126;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
Debug.ShouldStop(536870912);
_email.getField(false,"Attachments").runVoidMethod ("Add",(Object)(setting_activity.mostCurrent._starter._provider /*RemoteObject*/ .runClassMethod (ir.taravatgroup.ezafekari2.fileprovider.class, "_getfileuri" /*RemoteObject*/ ,(Object)(_filename))));
 BA.debugLineNum = 128;BA.debugLine="Dim in As Intent = email.GetIntent";
Debug.ShouldStop(-2147483648);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");
_in = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.IntentWrapper"), _email.runMethod(false,"GetIntent"));Debug.locals.put("in", _in);Debug.locals.put("in", _in);
 BA.debugLineNum = 131;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
Debug.ShouldStop(4);
_in.runMethod(true,"setFlags",BA.numberCast(int.class, 1));
 BA.debugLineNum = 132;BA.debugLine="StartActivity(in)";
Debug.ShouldStop(8);
setting_activity.mostCurrent.__c.runVoidMethod ("StartActivity",setting_activity.processBA,(Object)((_in.getObject())));
 BA.debugLineNum = 134;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("lbl_close_help_font_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,383);
if (RapidSub.canDelegate("lbl_close_help_font_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_close_help_font_click");}
 BA.debugLineNum = 383;BA.debugLine="Private Sub lbl_close_help_font_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 384;BA.debugLine="pan_all_help.Visible=False";
Debug.ShouldStop(-2147483648);
setting_activity.mostCurrent._pan_all_help.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _lbl_color_home_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_color_home_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,306);
if (RapidSub.canDelegate("lbl_color_home_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_color_home_click");}
 BA.debugLineNum = 306;BA.debugLine="Private Sub lbl_color_home_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 307;BA.debugLine="lbl_color1_Click";
Debug.ShouldStop(262144);
_lbl_color1_click();
 BA.debugLineNum = 308;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("lbl_color1_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,161);
if (RapidSub.canDelegate("lbl_color1_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_color1_click");}
 BA.debugLineNum = 161;BA.debugLine="Private Sub lbl_color1_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 162;BA.debugLine="pan_all.Visible=True";
Debug.ShouldStop(2);
setting_activity.mostCurrent._pan_all.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 164;BA.debugLine="color_index=Main.color_index";
Debug.ShouldStop(8);
setting_activity._color_index = setting_activity.mostCurrent._main._color_index /*RemoteObject*/ ;
 BA.debugLineNum = 166;BA.debugLine="Select color_index";
Debug.ShouldStop(32);
switch (BA.switchObjectToInt(setting_activity._color_index,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6))) {
case 0: {
 BA.debugLineNum = 168;BA.debugLine="pan_color1_Click";
Debug.ShouldStop(128);
_pan_color1_click();
 break; }
case 1: {
 BA.debugLineNum = 170;BA.debugLine="pan_color2_Click";
Debug.ShouldStop(512);
_pan_color2_click();
 break; }
case 2: {
 BA.debugLineNum = 172;BA.debugLine="pan_color3_Click";
Debug.ShouldStop(2048);
_pan_color3_click();
 break; }
case 3: {
 BA.debugLineNum = 174;BA.debugLine="pan_color4_Click";
Debug.ShouldStop(8192);
_pan_color4_click();
 break; }
case 4: {
 BA.debugLineNum = 176;BA.debugLine="pan_color5_Click";
Debug.ShouldStop(32768);
_pan_color5_click();
 break; }
case 5: {
 BA.debugLineNum = 178;BA.debugLine="pan_color6_Click";
Debug.ShouldStop(131072);
_pan_color6_click();
 break; }
}
;
 BA.debugLineNum = 185;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("lbl_font_pan_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,314);
if (RapidSub.canDelegate("lbl_font_pan_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_font_pan_click");}
 BA.debugLineNum = 314;BA.debugLine="Private Sub lbl_font_pan_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 315;BA.debugLine="pan_all2.Visible=True";
Debug.ShouldStop(67108864);
setting_activity.mostCurrent._pan_all2.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
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
public static RemoteObject  _lbl_help_font_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help_font_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,339);
if (RapidSub.canDelegate("lbl_help_font_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_help_font_click");}
 BA.debugLineNum = 339;BA.debugLine="Private Sub lbl_help_font_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 344;BA.debugLine="pan_all_help.Visible=True";
Debug.ShouldStop(8388608);
setting_activity.mostCurrent._pan_all_help.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 345;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("lbl_rest_font_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,323);
if (RapidSub.canDelegate("lbl_rest_font_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_rest_font_click");}
 BA.debugLineNum = 323;BA.debugLine="Private Sub lbl_rest_font_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 324;BA.debugLine="sp_font.SelectedIndex=0";
Debug.ShouldStop(8);
setting_activity.mostCurrent._sp_font.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 BA.debugLineNum = 326;BA.debugLine="skb_f1.Value=17";
Debug.ShouldStop(32);
setting_activity.mostCurrent._skb_f1.runMethod(true,"setValue",BA.numberCast(int.class, 17));
 BA.debugLineNum = 327;BA.debugLine="skb_f2.Value=15";
Debug.ShouldStop(64);
setting_activity.mostCurrent._skb_f2.runMethod(true,"setValue",BA.numberCast(int.class, 15));
 BA.debugLineNum = 328;BA.debugLine="skb_f3.Value=13";
Debug.ShouldStop(128);
setting_activity.mostCurrent._skb_f3.runMethod(true,"setValue",BA.numberCast(int.class, 13));
 BA.debugLineNum = 330;BA.debugLine="lbl_skb_f1.Text=17";
Debug.ShouldStop(512);
setting_activity.mostCurrent._lbl_skb_f1.runMethod(true,"setText",BA.ObjectToCharSequence(17));
 BA.debugLineNum = 331;BA.debugLine="lbl_skb_f2.Text=15";
Debug.ShouldStop(1024);
setting_activity.mostCurrent._lbl_skb_f2.runMethod(true,"setText",BA.ObjectToCharSequence(15));
 BA.debugLineNum = 332;BA.debugLine="lbl_skb_f3.Text=13";
Debug.ShouldStop(2048);
setting_activity.mostCurrent._lbl_skb_f3.runMethod(true,"setText",BA.ObjectToCharSequence(13));
 BA.debugLineNum = 337;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("lbl_restore_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,136);
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
		Debug.PushSubsStack("lbl_restore_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,136);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 137;BA.debugLine="cc.Initialize(\"CC\")";
Debug.ShouldStop(256);
parent._cc.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("CC")));
 BA.debugLineNum = 138;BA.debugLine="cc.Show(\"*/*\", \"انتخاب فایل دیتابیس\")";
Debug.ShouldStop(512);
parent._cc.runVoidMethod ("Show",setting_activity.processBA,(Object)(BA.ObjectToString("*/*")),(Object)(RemoteObject.createImmutable("انتخاب فایل دیتابیس")));
 BA.debugLineNum = 139;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
Debug.ShouldStop(1024);
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
 BA.debugLineNum = 140;BA.debugLine="If Success Then";
Debug.ShouldStop(2048);
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
 BA.debugLineNum = 141;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.SharedFo";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_dir),(Object)(_filename),(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.createImmutable("db2.db")));
 BA.debugLineNum = 143;BA.debugLine="Log( Dir)";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","121561351",_dir,0);
 BA.debugLineNum = 144;BA.debugLine="Log(FileName)";
Debug.ShouldStop(32768);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","121561352",_filename,0);
 BA.debugLineNum = 145;BA.debugLine="Log(File.Exists(Starter.Provider.SharedFolder,\"d";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","121561353",BA.ObjectToString(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.createImmutable("db2.db")))),0);
 BA.debugLineNum = 147;BA.debugLine="Dim result As Int";
Debug.ShouldStop(262144);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 149;BA.debugLine="result = Msgbox2(\"دیتای قبلی حذف و دیتای جدید جا";
Debug.ShouldStop(1048576);
_result = parent.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("دیتای قبلی حذف و دیتای جدید جایگزین می شود.")),(Object)(BA.ObjectToCharSequence("توجه")),(Object)(BA.ObjectToString("باشه")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("نه")),(Object)((parent.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("attention.png"))).getObject())),setting_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 150;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(2097152);
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
 BA.debugLineNum = 151;BA.debugLine="File.Copy(Starter.Provider.SharedFolder,\"db2.db";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(BA.ObjectToString("db2.db")),(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("db.db")));
 BA.debugLineNum = 152;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",setting_activity.processBA,(Object)((parent.mostCurrent._main.getObject())));
 BA.debugLineNum = 153;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16777216);
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
 BA.debugLineNum = 159;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("lbl_save_color_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,280);
if (RapidSub.canDelegate("lbl_save_color_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_save_color_click");}
 BA.debugLineNum = 280;BA.debugLine="Private Sub lbl_save_color_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 281;BA.debugLine="Main.color1=color1";
Debug.ShouldStop(16777216);
setting_activity.mostCurrent._main._color1 /*RemoteObject*/  = setting_activity._color1;
 BA.debugLineNum = 282;BA.debugLine="Main.color2=color2";
Debug.ShouldStop(33554432);
setting_activity.mostCurrent._main._color2 /*RemoteObject*/  = setting_activity._color2;
 BA.debugLineNum = 283;BA.debugLine="Main.color3=color3";
Debug.ShouldStop(67108864);
setting_activity.mostCurrent._main._color3 /*RemoteObject*/  = setting_activity._color3;
 BA.debugLineNum = 284;BA.debugLine="Main.color4=color4";
Debug.ShouldStop(134217728);
setting_activity.mostCurrent._main._color4 /*RemoteObject*/  = setting_activity._color4;
 BA.debugLineNum = 285;BA.debugLine="Main.color5=color5";
Debug.ShouldStop(268435456);
setting_activity.mostCurrent._main._color5 /*RemoteObject*/  = setting_activity._color5;
 BA.debugLineNum = 286;BA.debugLine="Main.color_index=color_index";
Debug.ShouldStop(536870912);
setting_activity.mostCurrent._main._color_index /*RemoteObject*/  = setting_activity._color_index;
 BA.debugLineNum = 288;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
Debug.ShouldStop(-2147483648);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("setcolor.txt")),(Object)(RemoteObject.concat(setting_activity.mostCurrent._main._color1 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color2 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color_index /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color3 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color4 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color5 /*RemoteObject*/ ,setting_activity.mostCurrent.__c.getField(true,"CRLF"),setting_activity.mostCurrent._main._main_font /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._size_f1 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._size_f2 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._size_f3 /*RemoteObject*/ )));
 BA.debugLineNum = 290;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(2);
setting_activity.mostCurrent._pan_all.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 291;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
Debug.ShouldStop(4);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تغییرات ذخیره شد")),(Object)(setting_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 295;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("lbl_save_font_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,347);
if (RapidSub.canDelegate("lbl_save_font_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_save_font_click");}
 BA.debugLineNum = 347;BA.debugLine="Private Sub lbl_save_font_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 351;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
Debug.ShouldStop(1073741824);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("setcolor.txt")),(Object)(RemoteObject.concat(setting_activity.mostCurrent._main._color1 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color2 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity._color_index,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color3 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color4 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color5 /*RemoteObject*/ ,setting_activity.mostCurrent.__c.getField(true,"CRLF"),setting_activity.mostCurrent._sp_font.runMethod(true,"getSelectedItem"),RemoteObject.createImmutable(","),setting_activity.mostCurrent._skb_f1.runMethod(true,"getValue"),RemoteObject.createImmutable(","),setting_activity.mostCurrent._skb_f2.runMethod(true,"getValue"),RemoteObject.createImmutable(","),setting_activity.mostCurrent._skb_f3.runMethod(true,"getValue"))));
 BA.debugLineNum = 355;BA.debugLine="pan_all2_Click";
Debug.ShouldStop(4);
_pan_all2_click();
 BA.debugLineNum = 356;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
Debug.ShouldStop(8);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تغییرات ذخیره شد")),(Object)(setting_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 360;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("pan_all_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,187);
if (RapidSub.canDelegate("pan_all_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_all_click");}
 BA.debugLineNum = 187;BA.debugLine="Private Sub pan_all_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 188;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(134217728);
setting_activity.mostCurrent._pan_all.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 190;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("pan_all2_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,374);
if (RapidSub.canDelegate("pan_all2_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_all2_click");}
 BA.debugLineNum = 374;BA.debugLine="Private Sub pan_all2_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 375;BA.debugLine="pan_all2.Visible=False";
Debug.ShouldStop(4194304);
setting_activity.mostCurrent._pan_all2.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 376;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("pan_color1_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,266);
if (RapidSub.canDelegate("pan_color1_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color1_click");}
 BA.debugLineNum = 266;BA.debugLine="Private Sub pan_color1_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 267;BA.debugLine="tik_all_dis";
Debug.ShouldStop(1024);
_tik_all_dis();
 BA.debugLineNum = 268;BA.debugLine="color1=0XFF69AC00";
Debug.ShouldStop(2048);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xff69ac00));
 BA.debugLineNum = 269;BA.debugLine="color2=0xFF00C7C7";
Debug.ShouldStop(4096);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xff00c7c7));
 BA.debugLineNum = 270;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(8192);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 271;BA.debugLine="color4=0XFF69AC00";
Debug.ShouldStop(16384);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xff69ac00));
 BA.debugLineNum = 272;BA.debugLine="color5=0xFF00C7C7";
Debug.ShouldStop(32768);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xff00c7c7));
 BA.debugLineNum = 275;BA.debugLine="color_index=1";
Debug.ShouldStop(262144);
setting_activity._color_index = BA.numberCast(int.class, 1);
 BA.debugLineNum = 276;BA.debugLine="tik1.Visible=True";
Debug.ShouldStop(524288);
setting_activity.mostCurrent._tik1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 278;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("pan_color2_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,251);
if (RapidSub.canDelegate("pan_color2_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color2_click");}
 BA.debugLineNum = 251;BA.debugLine="Private Sub pan_color2_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 252;BA.debugLine="tik_all_dis";
Debug.ShouldStop(134217728);
_tik_all_dis();
 BA.debugLineNum = 253;BA.debugLine="color1 = 0xFF7F19EE";
Debug.ShouldStop(268435456);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xff7f19ee));
 BA.debugLineNum = 254;BA.debugLine="color2 = 0xFF567BFF";
Debug.ShouldStop(536870912);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xff567bff));
 BA.debugLineNum = 255;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(1073741824);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 256;BA.debugLine="color4=0xFF567BFF";
Debug.ShouldStop(-2147483648);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xff567bff));
 BA.debugLineNum = 257;BA.debugLine="color5=0xFF567BFF";
Debug.ShouldStop(1);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xff567bff));
 BA.debugLineNum = 261;BA.debugLine="color_index=2";
Debug.ShouldStop(16);
setting_activity._color_index = BA.numberCast(int.class, 2);
 BA.debugLineNum = 262;BA.debugLine="tik2.Visible=True";
Debug.ShouldStop(32);
setting_activity.mostCurrent._tik2.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 264;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("pan_color3_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,236);
if (RapidSub.canDelegate("pan_color3_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color3_click");}
 BA.debugLineNum = 236;BA.debugLine="Private Sub pan_color3_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 237;BA.debugLine="tik_all_dis";
Debug.ShouldStop(4096);
_tik_all_dis();
 BA.debugLineNum = 238;BA.debugLine="color1 = 0xFF2BC1F6";
Debug.ShouldStop(8192);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xff2bc1f6));
 BA.debugLineNum = 239;BA.debugLine="color2 = 0xFF1E45D1";
Debug.ShouldStop(16384);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xff1e45d1));
 BA.debugLineNum = 240;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(32768);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 241;BA.debugLine="color4=0xFF2BC1F6";
Debug.ShouldStop(65536);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xff2bc1f6));
 BA.debugLineNum = 242;BA.debugLine="color5=0xFF1E45D1";
Debug.ShouldStop(131072);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xff1e45d1));
 BA.debugLineNum = 247;BA.debugLine="color_index=3";
Debug.ShouldStop(4194304);
setting_activity._color_index = BA.numberCast(int.class, 3);
 BA.debugLineNum = 248;BA.debugLine="tik3.Visible=True";
Debug.ShouldStop(8388608);
setting_activity.mostCurrent._tik3.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 249;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("pan_color4_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,221);
if (RapidSub.canDelegate("pan_color4_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color4_click");}
 BA.debugLineNum = 221;BA.debugLine="Private Sub pan_color4_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 222;BA.debugLine="tik_all_dis";
Debug.ShouldStop(536870912);
_tik_all_dis();
 BA.debugLineNum = 223;BA.debugLine="color1 = 0xFFDD00FF";
Debug.ShouldStop(1073741824);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xffdd00ff));
 BA.debugLineNum = 224;BA.debugLine="color2 = 0xFF0090FF";
Debug.ShouldStop(-2147483648);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xff0090ff));
 BA.debugLineNum = 225;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(1);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 226;BA.debugLine="color4=0xFFDD00FF";
Debug.ShouldStop(2);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xffdd00ff));
 BA.debugLineNum = 227;BA.debugLine="color5=0xFF24EB9D";
Debug.ShouldStop(4);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xff24eb9d));
 BA.debugLineNum = 232;BA.debugLine="color_index=4";
Debug.ShouldStop(128);
setting_activity._color_index = BA.numberCast(int.class, 4);
 BA.debugLineNum = 233;BA.debugLine="tik4.Visible=True";
Debug.ShouldStop(256);
setting_activity.mostCurrent._tik4.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 234;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("pan_color5_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,207);
if (RapidSub.canDelegate("pan_color5_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color5_click");}
 BA.debugLineNum = 207;BA.debugLine="Private Sub pan_color5_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 208;BA.debugLine="tik_all_dis";
Debug.ShouldStop(32768);
_tik_all_dis();
 BA.debugLineNum = 209;BA.debugLine="color1 = 0xFFCF5263";
Debug.ShouldStop(65536);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xffcf5263));
 BA.debugLineNum = 210;BA.debugLine="color2 = 0xFFABC01A";
Debug.ShouldStop(131072);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xffabc01a));
 BA.debugLineNum = 211;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(262144);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 212;BA.debugLine="color4=0xFFCF5263";
Debug.ShouldStop(524288);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xffcf5263));
 BA.debugLineNum = 213;BA.debugLine="color5=0xFFABC01A";
Debug.ShouldStop(1048576);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xffabc01a));
 BA.debugLineNum = 217;BA.debugLine="color_index=5";
Debug.ShouldStop(16777216);
setting_activity._color_index = BA.numberCast(int.class, 5);
 BA.debugLineNum = 218;BA.debugLine="tik5.Visible=True";
Debug.ShouldStop(33554432);
setting_activity.mostCurrent._tik5.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 219;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("pan_color6_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,192);
if (RapidSub.canDelegate("pan_color6_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color6_click");}
 BA.debugLineNum = 192;BA.debugLine="Private Sub pan_color6_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 193;BA.debugLine="tik_all_dis";
Debug.ShouldStop(1);
_tik_all_dis();
 BA.debugLineNum = 194;BA.debugLine="color1= 0xFF5289CF";
Debug.ShouldStop(2);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xff5289cf));
 BA.debugLineNum = 195;BA.debugLine="color2= 0xFFABC01A";
Debug.ShouldStop(4);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xffabc01a));
 BA.debugLineNum = 196;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(8);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 197;BA.debugLine="color4=0xFF5289CF";
Debug.ShouldStop(16);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xff5289cf));
 BA.debugLineNum = 198;BA.debugLine="color5=0xFFABC01A";
Debug.ShouldStop(32);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xffabc01a));
 BA.debugLineNum = 203;BA.debugLine="color_index=6";
Debug.ShouldStop(1024);
setting_activity._color_index = BA.numberCast(int.class, 6);
 BA.debugLineNum = 204;BA.debugLine="tik6.Visible=True";
Debug.ShouldStop(2048);
setting_activity.mostCurrent._tik6.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 205;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("pan_colors_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,310);
if (RapidSub.canDelegate("pan_colors_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_colors_click");}
 BA.debugLineNum = 310;BA.debugLine="Private Sub pan_colors_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 312;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("pan_font_Click (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,378);
if (RapidSub.canDelegate("pan_font_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_font_click");}
 BA.debugLineNum = 378;BA.debugLine="Private Sub pan_font_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 380;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("skb_f1_ValueChanged (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,370);
if (RapidSub.canDelegate("skb_f1_valuechanged")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","skb_f1_valuechanged", _value, _userchanged);}
Debug.locals.put("Value", _value);
Debug.locals.put("UserChanged", _userchanged);
 BA.debugLineNum = 370;BA.debugLine="Private Sub skb_f1_ValueChanged (Value As Int, Use";
Debug.ShouldStop(131072);
 BA.debugLineNum = 371;BA.debugLine="lbl_skb_f1.Text=Value";
Debug.ShouldStop(262144);
setting_activity.mostCurrent._lbl_skb_f1.runMethod(true,"setText",BA.ObjectToCharSequence(_value));
 BA.debugLineNum = 372;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("skb_f2_ValueChanged (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,366);
if (RapidSub.canDelegate("skb_f2_valuechanged")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","skb_f2_valuechanged", _value, _userchanged);}
Debug.locals.put("Value", _value);
Debug.locals.put("UserChanged", _userchanged);
 BA.debugLineNum = 366;BA.debugLine="Private Sub skb_f2_ValueChanged (Value As Int, Use";
Debug.ShouldStop(8192);
 BA.debugLineNum = 367;BA.debugLine="lbl_skb_f2.Text=Value";
Debug.ShouldStop(16384);
setting_activity.mostCurrent._lbl_skb_f2.runMethod(true,"setText",BA.ObjectToCharSequence(_value));
 BA.debugLineNum = 368;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("skb_f3_ValueChanged (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,362);
if (RapidSub.canDelegate("skb_f3_valuechanged")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","skb_f3_valuechanged", _value, _userchanged);}
Debug.locals.put("Value", _value);
Debug.locals.put("UserChanged", _userchanged);
 BA.debugLineNum = 362;BA.debugLine="Private Sub skb_f3_ValueChanged (Value As Int, Use";
Debug.ShouldStop(512);
 BA.debugLineNum = 363;BA.debugLine="lbl_skb_f3.Text=Value";
Debug.ShouldStop(1024);
setting_activity.mostCurrent._lbl_skb_f3.runMethod(true,"setText",BA.ObjectToCharSequence(_value));
 BA.debugLineNum = 364;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("tik_all_dis (setting_activity) ","setting_activity",14,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,297);
if (RapidSub.canDelegate("tik_all_dis")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","tik_all_dis");}
 BA.debugLineNum = 297;BA.debugLine="Sub tik_all_dis";
Debug.ShouldStop(256);
 BA.debugLineNum = 298;BA.debugLine="tik1.Visible=False";
Debug.ShouldStop(512);
setting_activity.mostCurrent._tik1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 299;BA.debugLine="tik2.Visible=False";
Debug.ShouldStop(1024);
setting_activity.mostCurrent._tik2.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 300;BA.debugLine="tik3.Visible=False";
Debug.ShouldStop(2048);
setting_activity.mostCurrent._tik3.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 301;BA.debugLine="tik4.Visible=False";
Debug.ShouldStop(4096);
setting_activity.mostCurrent._tik4.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 302;BA.debugLine="tik5.Visible=False";
Debug.ShouldStop(8192);
setting_activity.mostCurrent._tik5.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 303;BA.debugLine="tik6.Visible=False";
Debug.ShouldStop(16384);
setting_activity.mostCurrent._tik6.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
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
}