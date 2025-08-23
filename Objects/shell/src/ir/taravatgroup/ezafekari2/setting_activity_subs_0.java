package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class setting_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,66);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_create", _firsttime);}
RemoteObject _res_backup = RemoteObject.createImmutable(0);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 66;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 68;BA.debugLine="Activity.LoadLayout(\"setting_layout\")";
Debug.ShouldStop(8);
setting_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("setting_layout")),setting_activity.mostCurrent.activityBA);
 BA.debugLineNum = 69;BA.debugLine="sc_view_items.Panel.LoadLayout(\"setting_layout_it";
Debug.ShouldStop(16);
setting_activity.mostCurrent._sc_view_items.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("setting_layout_items")),setting_activity.mostCurrent.activityBA);
 BA.debugLineNum = 73;BA.debugLine="pan_hed_setting.Color=Main.color4";
Debug.ShouldStop(256);
setting_activity.mostCurrent._pan_hed_setting.runVoidMethod ("setColor",setting_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 74;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(512);
setting_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(setting_activity.mostCurrent._activity));
 BA.debugLineNum = 77;BA.debugLine="sp_font.Add(\"یکان\")";
Debug.ShouldStop(4096);
setting_activity.mostCurrent._sp_font.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("یکان")));
 BA.debugLineNum = 78;BA.debugLine="sp_font.Add(\"نازنین\")";
Debug.ShouldStop(8192);
setting_activity.mostCurrent._sp_font.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("نازنین")));
 BA.debugLineNum = 79;BA.debugLine="sp_font.Add(\"وزیر\")";
Debug.ShouldStop(16384);
setting_activity.mostCurrent._sp_font.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("وزیر")));
 BA.debugLineNum = 80;BA.debugLine="sp_font.Add(\"دست نویس\")";
Debug.ShouldStop(32768);
setting_activity.mostCurrent._sp_font.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("دست نویس")));
 BA.debugLineNum = 81;BA.debugLine="sp_font.Add(\"کودک\")";
Debug.ShouldStop(65536);
setting_activity.mostCurrent._sp_font.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("کودک")));
 BA.debugLineNum = 84;BA.debugLine="skb_f1.Value=Main.size_f1";
Debug.ShouldStop(524288);
setting_activity.mostCurrent._skb_f1.runMethod(true,"setValue",setting_activity.mostCurrent._main._size_f1 /*RemoteObject*/ );
 BA.debugLineNum = 85;BA.debugLine="skb_f2.Value=Main.size_f2";
Debug.ShouldStop(1048576);
setting_activity.mostCurrent._skb_f2.runMethod(true,"setValue",setting_activity.mostCurrent._main._size_f2 /*RemoteObject*/ );
 BA.debugLineNum = 86;BA.debugLine="skb_f3.Value=Main.size_f3";
Debug.ShouldStop(2097152);
setting_activity.mostCurrent._skb_f3.runMethod(true,"setValue",setting_activity.mostCurrent._main._size_f3 /*RemoteObject*/ );
 BA.debugLineNum = 88;BA.debugLine="lbl_skb_f1.Text=Main.size_f1";
Debug.ShouldStop(8388608);
setting_activity.mostCurrent._lbl_skb_f1.runMethod(true,"setText",BA.ObjectToCharSequence(setting_activity.mostCurrent._main._size_f1 /*RemoteObject*/ ));
 BA.debugLineNum = 89;BA.debugLine="lbl_skb_f2.Text=Main.size_f2";
Debug.ShouldStop(16777216);
setting_activity.mostCurrent._lbl_skb_f2.runMethod(true,"setText",BA.ObjectToCharSequence(setting_activity.mostCurrent._main._size_f2 /*RemoteObject*/ ));
 BA.debugLineNum = 90;BA.debugLine="lbl_skb_f3.Text=Main.size_f3";
Debug.ShouldStop(33554432);
setting_activity.mostCurrent._lbl_skb_f3.runMethod(true,"setText",BA.ObjectToCharSequence(setting_activity.mostCurrent._main._size_f3 /*RemoteObject*/ ));
 BA.debugLineNum = 92;BA.debugLine="sp_backup_online.Add(\"1هفته\")";
Debug.ShouldStop(134217728);
setting_activity.mostCurrent._sp_backup_online.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1هفته")));
 BA.debugLineNum = 93;BA.debugLine="sp_backup_online.Add(\"2هفته\")";
Debug.ShouldStop(268435456);
setting_activity.mostCurrent._sp_backup_online.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("2هفته")));
 BA.debugLineNum = 94;BA.debugLine="sp_backup_online.Add(\"1ماه\")";
Debug.ShouldStop(536870912);
setting_activity.mostCurrent._sp_backup_online.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1ماه")));
 BA.debugLineNum = 95;BA.debugLine="sp_backup_online.Add(\"غیرفعال\")";
Debug.ShouldStop(1073741824);
setting_activity.mostCurrent._sp_backup_online.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("غیرفعال")));
 BA.debugLineNum = 101;BA.debugLine="chek_db_togels";
Debug.ShouldStop(16);
_chek_db_togels();
 BA.debugLineNum = 103;BA.debugLine="chek_togel";
Debug.ShouldStop(64);
_chek_togel();
 BA.debugLineNum = 107;BA.debugLine="Dim res_backup As Int = dbCode.get_setting_byName";
Debug.ShouldStop(1024);
_res_backup = BA.numberCast(int.class, setting_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("backup_online"))));Debug.locals.put("res_backup", _res_backup);Debug.locals.put("res_backup", _res_backup);
 BA.debugLineNum = 108;BA.debugLine="Select res_backup";
Debug.ShouldStop(2048);
switch (BA.switchObjectToInt(_res_backup,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 110;BA.debugLine="sp_backup_online.SelectedIndex=0";
Debug.ShouldStop(8192);
setting_activity.mostCurrent._sp_backup_online.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 break; }
case 1: {
 BA.debugLineNum = 112;BA.debugLine="sp_backup_online.SelectedIndex=1";
Debug.ShouldStop(32768);
setting_activity.mostCurrent._sp_backup_online.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 1));
 break; }
case 2: {
 BA.debugLineNum = 114;BA.debugLine="sp_backup_online.SelectedIndex=2";
Debug.ShouldStop(131072);
setting_activity.mostCurrent._sp_backup_online.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 2));
 break; }
case 3: {
 BA.debugLineNum = 116;BA.debugLine="sp_backup_online.SelectedIndex=3";
Debug.ShouldStop(524288);
setting_activity.mostCurrent._sp_backup_online.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 3));
 break; }
}
;
 BA.debugLineNum = 123;BA.debugLine="sp_font.SelectedIndex=sp_font.IndexOf(Main.main_f";
Debug.ShouldStop(67108864);
setting_activity.mostCurrent._sp_font.runMethod(true,"setSelectedIndex",setting_activity.mostCurrent._sp_font.runMethod(true,"IndexOf",(Object)(setting_activity.mostCurrent._main._main_font /*RemoteObject*/ )));
 BA.debugLineNum = 125;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_KeyPress (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,187);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 187;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 188;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, setting_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 189;BA.debugLine="If(pan_all.Visible=True)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._pan_all.runMethod(true,"getVisible"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 190;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(536870912);
setting_activity.mostCurrent._pan_all.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 192;BA.debugLine="Else If (pan_all_help.Visible=True) Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._pan_all_help.runMethod(true,"getVisible"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 193;BA.debugLine="pan_all_help.Visible=False";
Debug.ShouldStop(1);
setting_activity.mostCurrent._pan_all_help.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 194;BA.debugLine="Else If (pan_all2.Visible=True)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._pan_all2.runMethod(true,"getVisible"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 195;BA.debugLine="pan_all2.Visible=False";
Debug.ShouldStop(4);
setting_activity.mostCurrent._pan_all2.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 196;BA.debugLine="Else If(pan_all_lock.Visible=True)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._pan_all_lock.runMethod(true,"getVisible"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 197;BA.debugLine="pan_all_lock.Visible=False";
Debug.ShouldStop(16);
setting_activity.mostCurrent._pan_all_lock.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 199;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(64);
_lbl_back_click();
 }}}}
;
 BA.debugLineNum = 202;BA.debugLine="Return True";
Debug.ShouldStop(512);
if (true) return setting_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 204;BA.debugLine="Return False";
Debug.ShouldStop(2048);
if (true) return setting_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 206;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("Activity_Pause (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,131);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 131;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 133;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_Resume (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,127);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","activity_resume");}
 BA.debugLineNum = 127;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chek_db_togels() throws Exception{
try {
		Debug.PushSubsStack("chek_db_togels (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,136);
if (RapidSub.canDelegate("chek_db_togels")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","chek_db_togels");}
 BA.debugLineNum = 136;BA.debugLine="Sub chek_db_togels";
Debug.ShouldStop(128);
 BA.debugLineNum = 137;BA.debugLine="If(dbCode.get_setting_byName(\"tog_maliat\")=1)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_maliat"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 138;BA.debugLine="tog_maliat.Checked=True";
Debug.ShouldStop(512);
setting_activity.mostCurrent._tog_maliat.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 140;BA.debugLine="tog_maliat.Checked=False";
Debug.ShouldStop(2048);
setting_activity.mostCurrent._tog_maliat.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 143;BA.debugLine="If(dbCode.get_setting_byName(\"tog_bime\")=1)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_bime"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 144;BA.debugLine="tog_bime.Checked=True";
Debug.ShouldStop(32768);
setting_activity.mostCurrent._tog_bime.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 146;BA.debugLine="tog_bime.Checked=False";
Debug.ShouldStop(131072);
setting_activity.mostCurrent._tog_bime.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 149;BA.debugLine="If(dbCode.get_setting_byName(\"tog_food\")=1)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_food"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 150;BA.debugLine="tog_food.Checked=True";
Debug.ShouldStop(2097152);
setting_activity.mostCurrent._tog_food.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 152;BA.debugLine="tog_food.Checked=False";
Debug.ShouldStop(8388608);
setting_activity.mostCurrent._tog_food.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 155;BA.debugLine="If(dbCode.get_setting_byName(\"tog_vam\")=1)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_vam"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 156;BA.debugLine="tog_vam.Checked=True";
Debug.ShouldStop(134217728);
setting_activity.mostCurrent._tog_vam.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 158;BA.debugLine="tog_vam.Checked=False";
Debug.ShouldStop(536870912);
setting_activity.mostCurrent._tog_vam.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 161;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_ayab"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 162;BA.debugLine="tog_ayab.Checked=True";
Debug.ShouldStop(2);
setting_activity.mostCurrent._tog_ayab.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 164;BA.debugLine="tog_ayab.Checked=False";
Debug.ShouldStop(8);
setting_activity.mostCurrent._tog_ayab.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 167;BA.debugLine="If(dbCode.get_setting_byName(\"tog_padash\")=1)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_padash"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 168;BA.debugLine="tog_padash.Checked=True";
Debug.ShouldStop(128);
setting_activity.mostCurrent._tog_padash.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 170;BA.debugLine="tog_padash.Checked=False";
Debug.ShouldStop(512);
setting_activity.mostCurrent._tog_padash.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 173;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_sayer"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 174;BA.debugLine="tog_sayer.Checked=True";
Debug.ShouldStop(8192);
setting_activity.mostCurrent._tog_sayer.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 176;BA.debugLine="tog_sayer.Checked=False";
Debug.ShouldStop(32768);
setting_activity.mostCurrent._tog_sayer.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 179;BA.debugLine="If(dbCode.get_setting_byName(\"tog_mosaede\")=1)The";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_mosaede"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 180;BA.debugLine="tog_mosaede.Checked=True";
Debug.ShouldStop(524288);
setting_activity.mostCurrent._tog_mosaede.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 182;BA.debugLine="tog_mosaede.Checked=False";
Debug.ShouldStop(2097152);
setting_activity.mostCurrent._tog_mosaede.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 };
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
public static RemoteObject  _chek_togel() throws Exception{
try {
		Debug.PushSubsStack("chek_togel (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,633);
if (RapidSub.canDelegate("chek_togel")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","chek_togel");}
RemoteObject _color_on = RemoteObject.createImmutable("");
RemoteObject _color_off = RemoteObject.createImmutable("");
 BA.debugLineNum = 633;BA.debugLine="Sub chek_togel";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 634;BA.debugLine="Dim color_on As String=0xFF059C00";
Debug.ShouldStop(33554432);
_color_on = BA.NumberToString(((int)0xff059c00));Debug.locals.put("color_on", _color_on);Debug.locals.put("color_on", _color_on);
 BA.debugLineNum = 635;BA.debugLine="Dim color_off As String=0xFFE70300";
Debug.ShouldStop(67108864);
_color_off = BA.NumberToString(((int)0xffe70300));Debug.locals.put("color_off", _color_off);Debug.locals.put("color_off", _color_off);
 BA.debugLineNum = 638;BA.debugLine="If(tog_maliat.Checked=True)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_maliat.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 639;BA.debugLine="tog_maliat.TextColor=color_on";
Debug.ShouldStop(1073741824);
setting_activity.mostCurrent._tog_maliat.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_on));
 }else {
 BA.debugLineNum = 641;BA.debugLine="tog_maliat.TextColor=color_off";
Debug.ShouldStop(1);
setting_activity.mostCurrent._tog_maliat.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_off));
 };
 BA.debugLineNum = 644;BA.debugLine="If(tog_bime.Checked=True)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_bime.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 645;BA.debugLine="tog_bime.TextColor=color_on";
Debug.ShouldStop(16);
setting_activity.mostCurrent._tog_bime.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_on));
 }else {
 BA.debugLineNum = 647;BA.debugLine="tog_bime.TextColor=color_off";
Debug.ShouldStop(64);
setting_activity.mostCurrent._tog_bime.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_off));
 };
 BA.debugLineNum = 650;BA.debugLine="If( tog_food.Checked=True)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_food.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 651;BA.debugLine="tog_food.TextColor=color_on";
Debug.ShouldStop(1024);
setting_activity.mostCurrent._tog_food.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_on));
 }else {
 BA.debugLineNum = 653;BA.debugLine="tog_food.TextColor=color_off";
Debug.ShouldStop(4096);
setting_activity.mostCurrent._tog_food.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_off));
 };
 BA.debugLineNum = 656;BA.debugLine="If(tog_vam.Checked=True)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_vam.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 657;BA.debugLine="tog_vam.TextColor=color_on";
Debug.ShouldStop(65536);
setting_activity.mostCurrent._tog_vam.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_on));
 }else {
 BA.debugLineNum = 659;BA.debugLine="tog_vam.TextColor=color_off";
Debug.ShouldStop(262144);
setting_activity.mostCurrent._tog_vam.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_off));
 };
 BA.debugLineNum = 662;BA.debugLine="If( tog_ayab.Checked=True)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_ayab.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 663;BA.debugLine="tog_ayab.TextColor=color_on";
Debug.ShouldStop(4194304);
setting_activity.mostCurrent._tog_ayab.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_on));
 }else {
 BA.debugLineNum = 665;BA.debugLine="tog_ayab.TextColor=color_off";
Debug.ShouldStop(16777216);
setting_activity.mostCurrent._tog_ayab.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_off));
 };
 BA.debugLineNum = 668;BA.debugLine="If(tog_padash.Checked=True)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_padash.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 669;BA.debugLine="tog_padash.TextColor=color_on";
Debug.ShouldStop(268435456);
setting_activity.mostCurrent._tog_padash.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_on));
 }else {
 BA.debugLineNum = 671;BA.debugLine="tog_padash.TextColor=color_off";
Debug.ShouldStop(1073741824);
setting_activity.mostCurrent._tog_padash.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_off));
 };
 BA.debugLineNum = 674;BA.debugLine="If(tog_sayer.Checked=True)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_sayer.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 675;BA.debugLine="tog_sayer.TextColor=color_on";
Debug.ShouldStop(4);
setting_activity.mostCurrent._tog_sayer.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_on));
 }else {
 BA.debugLineNum = 677;BA.debugLine="tog_sayer.TextColor=color_off";
Debug.ShouldStop(16);
setting_activity.mostCurrent._tog_sayer.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_off));
 };
 BA.debugLineNum = 680;BA.debugLine="If(tog_mosaede.Checked=True)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_mosaede.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 681;BA.debugLine="tog_mosaede.TextColor=color_on";
Debug.ShouldStop(256);
setting_activity.mostCurrent._tog_mosaede.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_on));
 }else {
 BA.debugLineNum = 683;BA.debugLine="tog_mosaede.TextColor=color_off";
Debug.ShouldStop(1024);
setting_activity.mostCurrent._tog_mosaede.runMethod(true,"setTextColor",BA.numberCast(int.class, _color_off));
 };
 BA.debugLineNum = 686;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("et_pass_lock_TextChanged (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,578);
if (RapidSub.canDelegate("et_pass_lock_textchanged")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","et_pass_lock_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 578;BA.debugLine="Private Sub et_pass_lock_TextChanged (Old As Strin";
Debug.ShouldStop(2);
 BA.debugLineNum = 579;BA.debugLine="If(New.Length>4)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",_new.runMethod(true,"length"),BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 580;BA.debugLine="ToastMessageShow(\"رمز فقط 4 رقم باشد\",False)";
Debug.ShouldStop(8);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("رمز فقط 4 رقم باشد")),(Object)(setting_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 581;BA.debugLine="et_pass_lock.Text=Old";
Debug.ShouldStop(16);
setting_activity.mostCurrent._et_pass_lock.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_old));
 };
 BA.debugLineNum = 583;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
 //BA.debugLineNum = 55;BA.debugLine="Private tog_maliat As ToggleButton";
setting_activity.mostCurrent._tog_maliat = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private tog_bime As ToggleButton";
setting_activity.mostCurrent._tog_bime = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private tog_food As ToggleButton";
setting_activity.mostCurrent._tog_food = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private tog_vam As ToggleButton";
setting_activity.mostCurrent._tog_vam = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private tog_ayab As ToggleButton";
setting_activity.mostCurrent._tog_ayab = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private tog_padash As ToggleButton";
setting_activity.mostCurrent._tog_padash = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private tog_sayer As ToggleButton";
setting_activity.mostCurrent._tog_sayer = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Private tog_mosaede As ToggleButton";
setting_activity.mostCurrent._tog_mosaede = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Private sp_backup_online As Spinner";
setting_activity.mostCurrent._sp_backup_online = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,208);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_back_click");}
 BA.debugLineNum = 208;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 210;BA.debugLine="Activity.Finish";
Debug.ShouldStop(131072);
setting_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 211;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(262144);
setting_activity.mostCurrent.__c.runVoidMethod ("StartActivity",setting_activity.processBA,(Object)((setting_activity.mostCurrent._main.getObject())));
 BA.debugLineNum = 212;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("lbl_backup_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,216);
if (RapidSub.canDelegate("lbl_backup_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_backup_click");}
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _email = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.Email");
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 216;BA.debugLine="Private Sub lbl_backup_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 218;BA.debugLine="Dim FileName As String = \"db.db\"";
Debug.ShouldStop(33554432);
_filename = BA.ObjectToString("db.db");Debug.locals.put("FileName", _filename);Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 221;BA.debugLine="File.Copy(File.DirInternal, FileName, Starter.Pro";
Debug.ShouldStop(268435456);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_filename),(Object)(setting_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(_filename));
 BA.debugLineNum = 223;BA.debugLine="Dim email As Email";
Debug.ShouldStop(1073741824);
_email = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.Email");Debug.locals.put("email", _email);
 BA.debugLineNum = 224;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
Debug.ShouldStop(-2147483648);
_email.getField(false,"To").runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("aaa@bbb.com"))));
 BA.debugLineNum = 225;BA.debugLine="email.Subject = \"subject\"";
Debug.ShouldStop(1);
_email.setField ("Subject",BA.ObjectToString("subject"));
 BA.debugLineNum = 226;BA.debugLine="email.Body = \"backup-\"&DateTime.Date(DateTime.Now";
Debug.ShouldStop(2);
_email.setField ("Body",RemoteObject.concat(RemoteObject.createImmutable("backup-"),setting_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(setting_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))));
 BA.debugLineNum = 227;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
Debug.ShouldStop(4);
_email.getField(false,"Attachments").runVoidMethod ("Add",(Object)(setting_activity.mostCurrent._starter._provider /*RemoteObject*/ .runClassMethod (ir.taravatgroup.ezafekari2.fileprovider.class, "_getfileuri" /*RemoteObject*/ ,(Object)(_filename))));
 BA.debugLineNum = 229;BA.debugLine="Dim in As Intent = email.GetIntent";
Debug.ShouldStop(16);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");
_in = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.IntentWrapper"), _email.runMethod(false,"GetIntent"));Debug.locals.put("in", _in);Debug.locals.put("in", _in);
 BA.debugLineNum = 232;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
Debug.ShouldStop(128);
_in.runMethod(true,"setFlags",BA.numberCast(int.class, 1));
 BA.debugLineNum = 233;BA.debugLine="StartActivity(in)";
Debug.ShouldStop(256);
setting_activity.mostCurrent.__c.runVoidMethod ("StartActivity",setting_activity.processBA,(Object)((_in.getObject())));
 BA.debugLineNum = 235;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("lbl_close_help_font_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,484);
if (RapidSub.canDelegate("lbl_close_help_font_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_close_help_font_click");}
 BA.debugLineNum = 484;BA.debugLine="Private Sub lbl_close_help_font_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 485;BA.debugLine="pan_all_help.Visible=False";
Debug.ShouldStop(16);
setting_activity.mostCurrent._pan_all_help.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 486;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("lbl_color_home_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,407);
if (RapidSub.canDelegate("lbl_color_home_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_color_home_click");}
 BA.debugLineNum = 407;BA.debugLine="Private Sub lbl_color_home_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 408;BA.debugLine="lbl_color1_Click";
Debug.ShouldStop(8388608);
_lbl_color1_click();
 BA.debugLineNum = 409;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("lbl_color1_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,262);
if (RapidSub.canDelegate("lbl_color1_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_color1_click");}
 BA.debugLineNum = 262;BA.debugLine="Private Sub lbl_color1_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 263;BA.debugLine="pan_all.Visible=True";
Debug.ShouldStop(64);
setting_activity.mostCurrent._pan_all.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 265;BA.debugLine="color_index=Main.color_index";
Debug.ShouldStop(256);
setting_activity._color_index = setting_activity.mostCurrent._main._color_index /*RemoteObject*/ ;
 BA.debugLineNum = 267;BA.debugLine="Select color_index";
Debug.ShouldStop(1024);
switch (BA.switchObjectToInt(setting_activity._color_index,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6))) {
case 0: {
 BA.debugLineNum = 269;BA.debugLine="pan_color1_Click";
Debug.ShouldStop(4096);
_pan_color1_click();
 break; }
case 1: {
 BA.debugLineNum = 271;BA.debugLine="pan_color2_Click";
Debug.ShouldStop(16384);
_pan_color2_click();
 break; }
case 2: {
 BA.debugLineNum = 273;BA.debugLine="pan_color3_Click";
Debug.ShouldStop(65536);
_pan_color3_click();
 break; }
case 3: {
 BA.debugLineNum = 275;BA.debugLine="pan_color4_Click";
Debug.ShouldStop(262144);
_pan_color4_click();
 break; }
case 4: {
 BA.debugLineNum = 277;BA.debugLine="pan_color5_Click";
Debug.ShouldStop(1048576);
_pan_color5_click();
 break; }
case 5: {
 BA.debugLineNum = 279;BA.debugLine="pan_color6_Click";
Debug.ShouldStop(4194304);
_pan_color6_click();
 break; }
}
;
 BA.debugLineNum = 286;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("lbl_font_pan_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,415);
if (RapidSub.canDelegate("lbl_font_pan_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_font_pan_click");}
 BA.debugLineNum = 415;BA.debugLine="Private Sub lbl_font_pan_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 416;BA.debugLine="pan_all2.Visible=True";
Debug.ShouldStop(-2147483648);
setting_activity.mostCurrent._pan_all2.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 422;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("lbl_help_font_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,440);
if (RapidSub.canDelegate("lbl_help_font_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_help_font_click");}
 BA.debugLineNum = 440;BA.debugLine="Private Sub lbl_help_font_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 445;BA.debugLine="pan_all_help.Visible=True";
Debug.ShouldStop(268435456);
setting_activity.mostCurrent._pan_all_help.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 446;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("lbl_lock_app_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,488);
if (RapidSub.canDelegate("lbl_lock_app_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_lock_app_click");}
RemoteObject _ls_lock0 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_lock3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 488;BA.debugLine="Private Sub lbl_lock_app_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 490;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=True)T";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock"))),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 491;BA.debugLine="Dim ls_lock0 As List";
Debug.ShouldStop(1024);
_ls_lock0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 492;BA.debugLine="ls_lock0.Initialize";
Debug.ShouldStop(2048);
_ls_lock0.runVoidMethod ("Initialize");
 BA.debugLineNum = 494;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_lock";
Debug.ShouldStop(8192);
_ls_lock0 = setting_activity.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock")));Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 496;BA.debugLine="If(ls_lock0.Get(0)=\"true\")Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),(RemoteObject.createImmutable("true"))))) { 
 BA.debugLineNum = 497;BA.debugLine="ToggleBtn_OffOn_lock.Checked=True";
Debug.ShouldStop(65536);
setting_activity.mostCurrent._togglebtn_offon_lock.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 498;BA.debugLine="et_pass_lock.Enabled=True";
Debug.ShouldStop(131072);
setting_activity.mostCurrent._et_pass_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 499;BA.debugLine="et_pass_lock.Text=ls_lock0.Get(2)";
Debug.ShouldStop(262144);
setting_activity.mostCurrent._et_pass_lock.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 500;BA.debugLine="et_hint_lock.Text=ls_lock0.Get(3)";
Debug.ShouldStop(524288);
setting_activity.mostCurrent._et_hint_lock.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))));
 }else {
 BA.debugLineNum = 502;BA.debugLine="ToggleBtn_OffOn_lock.Checked=False";
Debug.ShouldStop(2097152);
setting_activity.mostCurrent._togglebtn_offon_lock.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 503;BA.debugLine="ToggleBtn_finger.Enabled=False";
Debug.ShouldStop(4194304);
setting_activity.mostCurrent._togglebtn_finger.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 504;BA.debugLine="et_pass_lock.Enabled=False";
Debug.ShouldStop(8388608);
setting_activity.mostCurrent._et_pass_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 505;BA.debugLine="et_hint_lock.Enabled=False";
Debug.ShouldStop(16777216);
setting_activity.mostCurrent._et_hint_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 506;BA.debugLine="et_pass_lock.Text=\"\"";
Debug.ShouldStop(33554432);
setting_activity.mostCurrent._et_pass_lock.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 509;BA.debugLine="If(ls_lock0.Get(1)=\"true\")Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),(RemoteObject.createImmutable("true"))))) { 
 BA.debugLineNum = 510;BA.debugLine="ToggleBtn_finger.Checked=True";
Debug.ShouldStop(536870912);
setting_activity.mostCurrent._togglebtn_finger.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 512;BA.debugLine="ToggleBtn_finger.Checked=False";
Debug.ShouldStop(-2147483648);
setting_activity.mostCurrent._togglebtn_finger.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 514;BA.debugLine="et_hint_lock.Text=ls_lock0.Get(3)";
Debug.ShouldStop(2);
setting_activity.mostCurrent._et_hint_lock.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))));
 }else {
 BA.debugLineNum = 517;BA.debugLine="Dim ls_lock3 As List";
Debug.ShouldStop(16);
_ls_lock3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_lock3", _ls_lock3);
 BA.debugLineNum = 518;BA.debugLine="ls_lock3.Initialize";
Debug.ShouldStop(32);
_ls_lock3.runVoidMethod ("Initialize");
 BA.debugLineNum = 520;BA.debugLine="ls_lock3.Add(\"false\")";
Debug.ShouldStop(128);
_ls_lock3.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 521;BA.debugLine="ls_lock3.Add(\"false\")";
Debug.ShouldStop(256);
_ls_lock3.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 522;BA.debugLine="ls_lock3.Add(\"\")";
Debug.ShouldStop(512);
_ls_lock3.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 523;BA.debugLine="ls_lock3.Add(\"\")";
Debug.ShouldStop(1024);
_ls_lock3.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 526;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_loc";
Debug.ShouldStop(8192);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls_lock")),(Object)(_ls_lock3));
 BA.debugLineNum = 529;BA.debugLine="ToggleBtn_OffOn_lock.Checked=False";
Debug.ShouldStop(65536);
setting_activity.mostCurrent._togglebtn_offon_lock.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 530;BA.debugLine="ToggleBtn_finger.Enabled=False";
Debug.ShouldStop(131072);
setting_activity.mostCurrent._togglebtn_finger.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 531;BA.debugLine="ToggleBtn_finger.Checked=False";
Debug.ShouldStop(262144);
setting_activity.mostCurrent._togglebtn_finger.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 532;BA.debugLine="et_pass_lock.Enabled=False";
Debug.ShouldStop(524288);
setting_activity.mostCurrent._et_pass_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 533;BA.debugLine="et_hint_lock.Enabled=False";
Debug.ShouldStop(1048576);
setting_activity.mostCurrent._et_hint_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 540;BA.debugLine="pan_all_lock.Visible=True";
Debug.ShouldStop(134217728);
setting_activity.mostCurrent._pan_all_lock.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 541;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("lbl_rest_font_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,424);
if (RapidSub.canDelegate("lbl_rest_font_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_rest_font_click");}
 BA.debugLineNum = 424;BA.debugLine="Private Sub lbl_rest_font_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 425;BA.debugLine="sp_font.SelectedIndex=0";
Debug.ShouldStop(256);
setting_activity.mostCurrent._sp_font.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 BA.debugLineNum = 427;BA.debugLine="skb_f1.Value=17";
Debug.ShouldStop(1024);
setting_activity.mostCurrent._skb_f1.runMethod(true,"setValue",BA.numberCast(int.class, 17));
 BA.debugLineNum = 428;BA.debugLine="skb_f2.Value=15";
Debug.ShouldStop(2048);
setting_activity.mostCurrent._skb_f2.runMethod(true,"setValue",BA.numberCast(int.class, 15));
 BA.debugLineNum = 429;BA.debugLine="skb_f3.Value=13";
Debug.ShouldStop(4096);
setting_activity.mostCurrent._skb_f3.runMethod(true,"setValue",BA.numberCast(int.class, 13));
 BA.debugLineNum = 431;BA.debugLine="lbl_skb_f1.Text=17";
Debug.ShouldStop(16384);
setting_activity.mostCurrent._lbl_skb_f1.runMethod(true,"setText",BA.ObjectToCharSequence(17));
 BA.debugLineNum = 432;BA.debugLine="lbl_skb_f2.Text=15";
Debug.ShouldStop(32768);
setting_activity.mostCurrent._lbl_skb_f2.runMethod(true,"setText",BA.ObjectToCharSequence(15));
 BA.debugLineNum = 433;BA.debugLine="lbl_skb_f3.Text=13";
Debug.ShouldStop(65536);
setting_activity.mostCurrent._lbl_skb_f3.runMethod(true,"setText",BA.ObjectToCharSequence(13));
 BA.debugLineNum = 438;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("lbl_restore_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,237);
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
		Debug.PushSubsStack("lbl_restore_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,237);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 238;BA.debugLine="cc.Initialize(\"CC\")";
Debug.ShouldStop(8192);
parent._cc.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("CC")));
 BA.debugLineNum = 239;BA.debugLine="cc.Show(\"*/*\", \"انتخاب فایل دیتابیس\")";
Debug.ShouldStop(16384);
parent._cc.runVoidMethod ("Show",setting_activity.processBA,(Object)(BA.ObjectToString("*/*")),(Object)(RemoteObject.createImmutable("انتخاب فایل دیتابیس")));
 BA.debugLineNum = 240;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
Debug.ShouldStop(32768);
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
 BA.debugLineNum = 241;BA.debugLine="If Success Then";
Debug.ShouldStop(65536);
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
 BA.debugLineNum = 242;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.SharedFo";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_dir),(Object)(_filename),(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.createImmutable("db2.db")));
 BA.debugLineNum = 244;BA.debugLine="Log( Dir)";
Debug.ShouldStop(524288);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","647644679",_dir,0);
 BA.debugLineNum = 245;BA.debugLine="Log(FileName)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","647644680",_filename,0);
 BA.debugLineNum = 246;BA.debugLine="Log(File.Exists(Starter.Provider.SharedFolder,\"d";
Debug.ShouldStop(2097152);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","647644681",BA.ObjectToString(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.createImmutable("db2.db")))),0);
 BA.debugLineNum = 248;BA.debugLine="Dim result As Int";
Debug.ShouldStop(8388608);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 250;BA.debugLine="result = Msgbox2(\"دیتای قبلی حذف و دیتای جدید جا";
Debug.ShouldStop(33554432);
_result = parent.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("دیتای قبلی حذف و دیتای جدید جایگزین می شود.")),(Object)(BA.ObjectToCharSequence("توجه")),(Object)(BA.ObjectToString("باشه")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("نه")),(Object)((parent.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("attention.png"))).getObject())),setting_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 251;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(67108864);
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
 BA.debugLineNum = 252;BA.debugLine="File.Copy(Starter.Provider.SharedFolder,\"db2.db";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(BA.ObjectToString("db2.db")),(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("db.db")));
 BA.debugLineNum = 253;BA.debugLine="Activity.Finish";
Debug.ShouldStop(268435456);
parent.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 254;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",setting_activity.processBA,(Object)((parent.mostCurrent._main.getObject())));
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
 BA.debugLineNum = 260;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("lbl_save_color_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,381);
if (RapidSub.canDelegate("lbl_save_color_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_save_color_click");}
 BA.debugLineNum = 381;BA.debugLine="Private Sub lbl_save_color_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 382;BA.debugLine="Main.color1=color1";
Debug.ShouldStop(536870912);
setting_activity.mostCurrent._main._color1 /*RemoteObject*/  = setting_activity._color1;
 BA.debugLineNum = 383;BA.debugLine="Main.color2=color2";
Debug.ShouldStop(1073741824);
setting_activity.mostCurrent._main._color2 /*RemoteObject*/  = setting_activity._color2;
 BA.debugLineNum = 384;BA.debugLine="Main.color3=color3";
Debug.ShouldStop(-2147483648);
setting_activity.mostCurrent._main._color3 /*RemoteObject*/  = setting_activity._color3;
 BA.debugLineNum = 385;BA.debugLine="Main.color4=color4";
Debug.ShouldStop(1);
setting_activity.mostCurrent._main._color4 /*RemoteObject*/  = setting_activity._color4;
 BA.debugLineNum = 386;BA.debugLine="Main.color5=color5";
Debug.ShouldStop(2);
setting_activity.mostCurrent._main._color5 /*RemoteObject*/  = setting_activity._color5;
 BA.debugLineNum = 387;BA.debugLine="Main.color_index=color_index";
Debug.ShouldStop(4);
setting_activity.mostCurrent._main._color_index /*RemoteObject*/  = setting_activity._color_index;
 BA.debugLineNum = 389;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
Debug.ShouldStop(16);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("setcolor.txt")),(Object)(RemoteObject.concat(setting_activity.mostCurrent._main._color1 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color2 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color_index /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color3 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color4 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color5 /*RemoteObject*/ ,setting_activity.mostCurrent.__c.getField(true,"CRLF"),setting_activity.mostCurrent._main._main_font /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._size_f1 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._size_f2 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._size_f3 /*RemoteObject*/ )));
 BA.debugLineNum = 391;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(64);
setting_activity.mostCurrent._pan_all.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 392;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
Debug.ShouldStop(128);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تغییرات ذخیره شد")),(Object)(setting_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 396;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("lbl_save_font_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,448);
if (RapidSub.canDelegate("lbl_save_font_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_save_font_click");}
 BA.debugLineNum = 448;BA.debugLine="Private Sub lbl_save_font_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 452;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\",";
Debug.ShouldStop(8);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("setcolor.txt")),(Object)(RemoteObject.concat(setting_activity.mostCurrent._main._color1 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color2 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity._color_index,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color3 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color4 /*RemoteObject*/ ,RemoteObject.createImmutable(","),setting_activity.mostCurrent._main._color5 /*RemoteObject*/ ,setting_activity.mostCurrent.__c.getField(true,"CRLF"),setting_activity.mostCurrent._sp_font.runMethod(true,"getSelectedItem"),RemoteObject.createImmutable(","),setting_activity.mostCurrent._skb_f1.runMethod(true,"getValue"),RemoteObject.createImmutable(","),setting_activity.mostCurrent._skb_f2.runMethod(true,"getValue"),RemoteObject.createImmutable(","),setting_activity.mostCurrent._skb_f3.runMethod(true,"getValue"))));
 BA.debugLineNum = 456;BA.debugLine="pan_all2_Click";
Debug.ShouldStop(128);
_pan_all2_click();
 BA.debugLineNum = 457;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
Debug.ShouldStop(256);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تغییرات ذخیره شد")),(Object)(setting_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 461;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("lbl_save_lock_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,543);
if (RapidSub.canDelegate("lbl_save_lock_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","lbl_save_lock_click");}
RemoteObject _ls_lock = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 543;BA.debugLine="Private Sub lbl_save_lock_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 544;BA.debugLine="Dim ls_lock As List";
Debug.ShouldStop(-2147483648);
_ls_lock = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_lock", _ls_lock);
 BA.debugLineNum = 545;BA.debugLine="ls_lock.Initialize";
Debug.ShouldStop(1);
_ls_lock.runVoidMethod ("Initialize");
 BA.debugLineNum = 549;BA.debugLine="If (ToggleBtn_OffOn_lock.Checked=True)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._togglebtn_offon_lock.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 550;BA.debugLine="If(et_pass_lock.Text.Length <> 4)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("!",setting_activity.mostCurrent._et_pass_lock.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 551;BA.debugLine="ToastMessageShow(\"تعیین رمز\",False)";
Debug.ShouldStop(64);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تعیین رمز")),(Object)(setting_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 555;BA.debugLine="ls_lock.Add(\"true\")";
Debug.ShouldStop(1024);
_ls_lock.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("true"))));
 BA.debugLineNum = 556;BA.debugLine="ls_lock.Add(ToggleBtn_finger.Checked)";
Debug.ShouldStop(2048);
_ls_lock.runVoidMethod ("Add",(Object)((setting_activity.mostCurrent._togglebtn_finger.runMethod(true,"getChecked"))));
 BA.debugLineNum = 557;BA.debugLine="ls_lock.Add(et_pass_lock.Text)";
Debug.ShouldStop(4096);
_ls_lock.runVoidMethod ("Add",(Object)((setting_activity.mostCurrent._et_pass_lock.runMethod(true,"getText"))));
 BA.debugLineNum = 558;BA.debugLine="ls_lock.Add(et_hint_lock.Text)";
Debug.ShouldStop(8192);
_ls_lock.runVoidMethod ("Add",(Object)((setting_activity.mostCurrent._et_hint_lock.runMethod(true,"getText"))));
 BA.debugLineNum = 561;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_lo";
Debug.ShouldStop(65536);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls_lock")),(Object)(_ls_lock));
 BA.debugLineNum = 563;BA.debugLine="pan_all_lock_Click";
Debug.ShouldStop(262144);
_pan_all_lock_click();
 };
 }else {
 BA.debugLineNum = 567;BA.debugLine="ls_lock.Add(\"false\")";
Debug.ShouldStop(4194304);
_ls_lock.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 568;BA.debugLine="ls_lock.Add(ToggleBtn_finger.Checked)";
Debug.ShouldStop(8388608);
_ls_lock.runVoidMethod ("Add",(Object)((setting_activity.mostCurrent._togglebtn_finger.runMethod(true,"getChecked"))));
 BA.debugLineNum = 569;BA.debugLine="ls_lock.Add(\"\")";
Debug.ShouldStop(16777216);
_ls_lock.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 570;BA.debugLine="ls_lock.Add(\"\")";
Debug.ShouldStop(33554432);
_ls_lock.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 571;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls_loc";
Debug.ShouldStop(67108864);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls_lock")),(Object)(_ls_lock));
 BA.debugLineNum = 572;BA.debugLine="pan_all_lock_Click";
Debug.ShouldStop(134217728);
_pan_all_lock_click();
 };
 BA.debugLineNum = 576;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("pan_all_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,288);
if (RapidSub.canDelegate("pan_all_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_all_click");}
 BA.debugLineNum = 288;BA.debugLine="Private Sub pan_all_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 289;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(1);
setting_activity.mostCurrent._pan_all.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 291;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("pan_all_lock_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,606);
if (RapidSub.canDelegate("pan_all_lock_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_all_lock_click");}
 BA.debugLineNum = 606;BA.debugLine="Private Sub pan_all_lock_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 607;BA.debugLine="pan_all_lock.Visible=False";
Debug.ShouldStop(1073741824);
setting_activity.mostCurrent._pan_all_lock.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 608;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("pan_all2_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,475);
if (RapidSub.canDelegate("pan_all2_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_all2_click");}
 BA.debugLineNum = 475;BA.debugLine="Private Sub pan_all2_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 476;BA.debugLine="pan_all2.Visible=False";
Debug.ShouldStop(134217728);
setting_activity.mostCurrent._pan_all2.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 477;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("pan_color1_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,367);
if (RapidSub.canDelegate("pan_color1_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color1_click");}
 BA.debugLineNum = 367;BA.debugLine="Private Sub pan_color1_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 368;BA.debugLine="tik_all_dis";
Debug.ShouldStop(32768);
_tik_all_dis();
 BA.debugLineNum = 369;BA.debugLine="color1=0XFF69AC00";
Debug.ShouldStop(65536);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xff69ac00));
 BA.debugLineNum = 370;BA.debugLine="color2=0xFF00C7C7";
Debug.ShouldStop(131072);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xff00c7c7));
 BA.debugLineNum = 371;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(262144);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 372;BA.debugLine="color4=0XFF69AC00";
Debug.ShouldStop(524288);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xff69ac00));
 BA.debugLineNum = 373;BA.debugLine="color5=0xFF00C7C7";
Debug.ShouldStop(1048576);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xff00c7c7));
 BA.debugLineNum = 376;BA.debugLine="color_index=1";
Debug.ShouldStop(8388608);
setting_activity._color_index = BA.numberCast(int.class, 1);
 BA.debugLineNum = 377;BA.debugLine="tik1.Visible=True";
Debug.ShouldStop(16777216);
setting_activity.mostCurrent._tik1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 379;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("pan_color2_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,352);
if (RapidSub.canDelegate("pan_color2_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color2_click");}
 BA.debugLineNum = 352;BA.debugLine="Private Sub pan_color2_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 353;BA.debugLine="tik_all_dis";
Debug.ShouldStop(1);
_tik_all_dis();
 BA.debugLineNum = 354;BA.debugLine="color1 = 0xFF7F19EE";
Debug.ShouldStop(2);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xff7f19ee));
 BA.debugLineNum = 355;BA.debugLine="color2 = 0xFF567BFF";
Debug.ShouldStop(4);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xff567bff));
 BA.debugLineNum = 356;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(8);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 357;BA.debugLine="color4=0xFF567BFF";
Debug.ShouldStop(16);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xff567bff));
 BA.debugLineNum = 358;BA.debugLine="color5=0xFF567BFF";
Debug.ShouldStop(32);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xff567bff));
 BA.debugLineNum = 362;BA.debugLine="color_index=2";
Debug.ShouldStop(512);
setting_activity._color_index = BA.numberCast(int.class, 2);
 BA.debugLineNum = 363;BA.debugLine="tik2.Visible=True";
Debug.ShouldStop(1024);
setting_activity.mostCurrent._tik2.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 365;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("pan_color3_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,337);
if (RapidSub.canDelegate("pan_color3_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color3_click");}
 BA.debugLineNum = 337;BA.debugLine="Private Sub pan_color3_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 338;BA.debugLine="tik_all_dis";
Debug.ShouldStop(131072);
_tik_all_dis();
 BA.debugLineNum = 339;BA.debugLine="color1 = 0xFF2BC1F6";
Debug.ShouldStop(262144);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xff2bc1f6));
 BA.debugLineNum = 340;BA.debugLine="color2 = 0xFF1E45D1";
Debug.ShouldStop(524288);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xff1e45d1));
 BA.debugLineNum = 341;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(1048576);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 342;BA.debugLine="color4=0xFF2BC1F6";
Debug.ShouldStop(2097152);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xff2bc1f6));
 BA.debugLineNum = 343;BA.debugLine="color5=0xFF1E45D1";
Debug.ShouldStop(4194304);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xff1e45d1));
 BA.debugLineNum = 348;BA.debugLine="color_index=3";
Debug.ShouldStop(134217728);
setting_activity._color_index = BA.numberCast(int.class, 3);
 BA.debugLineNum = 349;BA.debugLine="tik3.Visible=True";
Debug.ShouldStop(268435456);
setting_activity.mostCurrent._tik3.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 350;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("pan_color4_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,322);
if (RapidSub.canDelegate("pan_color4_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color4_click");}
 BA.debugLineNum = 322;BA.debugLine="Private Sub pan_color4_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 323;BA.debugLine="tik_all_dis";
Debug.ShouldStop(4);
_tik_all_dis();
 BA.debugLineNum = 324;BA.debugLine="color1 = 0xFFDD00FF";
Debug.ShouldStop(8);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xffdd00ff));
 BA.debugLineNum = 325;BA.debugLine="color2 = 0xFF0090FF";
Debug.ShouldStop(16);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xff0090ff));
 BA.debugLineNum = 326;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(32);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 327;BA.debugLine="color4=0xFFDD00FF";
Debug.ShouldStop(64);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xffdd00ff));
 BA.debugLineNum = 328;BA.debugLine="color5=0xFF24EB9D";
Debug.ShouldStop(128);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xff24eb9d));
 BA.debugLineNum = 333;BA.debugLine="color_index=4";
Debug.ShouldStop(4096);
setting_activity._color_index = BA.numberCast(int.class, 4);
 BA.debugLineNum = 334;BA.debugLine="tik4.Visible=True";
Debug.ShouldStop(8192);
setting_activity.mostCurrent._tik4.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 335;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("pan_color5_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,308);
if (RapidSub.canDelegate("pan_color5_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color5_click");}
 BA.debugLineNum = 308;BA.debugLine="Private Sub pan_color5_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 309;BA.debugLine="tik_all_dis";
Debug.ShouldStop(1048576);
_tik_all_dis();
 BA.debugLineNum = 310;BA.debugLine="color1 = 0xFFCF5263";
Debug.ShouldStop(2097152);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xffcf5263));
 BA.debugLineNum = 311;BA.debugLine="color2 = 0xFFABC01A";
Debug.ShouldStop(4194304);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xffabc01a));
 BA.debugLineNum = 312;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(8388608);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 313;BA.debugLine="color4=0xFFCF5263";
Debug.ShouldStop(16777216);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xffcf5263));
 BA.debugLineNum = 314;BA.debugLine="color5=0xFFABC01A";
Debug.ShouldStop(33554432);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xffabc01a));
 BA.debugLineNum = 318;BA.debugLine="color_index=5";
Debug.ShouldStop(536870912);
setting_activity._color_index = BA.numberCast(int.class, 5);
 BA.debugLineNum = 319;BA.debugLine="tik5.Visible=True";
Debug.ShouldStop(1073741824);
setting_activity.mostCurrent._tik5.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 320;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("pan_color6_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,293);
if (RapidSub.canDelegate("pan_color6_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_color6_click");}
 BA.debugLineNum = 293;BA.debugLine="Private Sub pan_color6_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 294;BA.debugLine="tik_all_dis";
Debug.ShouldStop(32);
_tik_all_dis();
 BA.debugLineNum = 295;BA.debugLine="color1= 0xFF5289CF";
Debug.ShouldStop(64);
setting_activity._color1 = BA.numberCast(int.class, ((int)0xff5289cf));
 BA.debugLineNum = 296;BA.debugLine="color2= 0xFFABC01A";
Debug.ShouldStop(128);
setting_activity._color2 = BA.numberCast(int.class, ((int)0xffabc01a));
 BA.debugLineNum = 297;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(256);
setting_activity._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 298;BA.debugLine="color4=0xFF5289CF";
Debug.ShouldStop(512);
setting_activity._color4 = BA.numberCast(int.class, ((int)0xff5289cf));
 BA.debugLineNum = 299;BA.debugLine="color5=0xFFABC01A";
Debug.ShouldStop(1024);
setting_activity._color5 = BA.numberCast(int.class, ((int)0xffabc01a));
 BA.debugLineNum = 304;BA.debugLine="color_index=6";
Debug.ShouldStop(32768);
setting_activity._color_index = BA.numberCast(int.class, 6);
 BA.debugLineNum = 305;BA.debugLine="tik6.Visible=True";
Debug.ShouldStop(65536);
setting_activity.mostCurrent._tik6.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 306;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("pan_colors_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,411);
if (RapidSub.canDelegate("pan_colors_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_colors_click");}
 BA.debugLineNum = 411;BA.debugLine="Private Sub pan_colors_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 413;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("pan_font_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,479);
if (RapidSub.canDelegate("pan_font_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_font_click");}
 BA.debugLineNum = 479;BA.debugLine="Private Sub pan_font_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 481;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("pan_lock_Click (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,610);
if (RapidSub.canDelegate("pan_lock_click")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","pan_lock_click");}
 BA.debugLineNum = 610;BA.debugLine="Private Sub pan_lock_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 612;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("skb_f1_ValueChanged (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,471);
if (RapidSub.canDelegate("skb_f1_valuechanged")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","skb_f1_valuechanged", _value, _userchanged);}
Debug.locals.put("Value", _value);
Debug.locals.put("UserChanged", _userchanged);
 BA.debugLineNum = 471;BA.debugLine="Private Sub skb_f1_ValueChanged (Value As Int, Use";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 472;BA.debugLine="lbl_skb_f1.Text=Value";
Debug.ShouldStop(8388608);
setting_activity.mostCurrent._lbl_skb_f1.runMethod(true,"setText",BA.ObjectToCharSequence(_value));
 BA.debugLineNum = 473;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("skb_f2_ValueChanged (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,467);
if (RapidSub.canDelegate("skb_f2_valuechanged")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","skb_f2_valuechanged", _value, _userchanged);}
Debug.locals.put("Value", _value);
Debug.locals.put("UserChanged", _userchanged);
 BA.debugLineNum = 467;BA.debugLine="Private Sub skb_f2_ValueChanged (Value As Int, Use";
Debug.ShouldStop(262144);
 BA.debugLineNum = 468;BA.debugLine="lbl_skb_f2.Text=Value";
Debug.ShouldStop(524288);
setting_activity.mostCurrent._lbl_skb_f2.runMethod(true,"setText",BA.ObjectToCharSequence(_value));
 BA.debugLineNum = 469;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("skb_f3_ValueChanged (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,463);
if (RapidSub.canDelegate("skb_f3_valuechanged")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","skb_f3_valuechanged", _value, _userchanged);}
Debug.locals.put("Value", _value);
Debug.locals.put("UserChanged", _userchanged);
 BA.debugLineNum = 463;BA.debugLine="Private Sub skb_f3_ValueChanged (Value As Int, Use";
Debug.ShouldStop(16384);
 BA.debugLineNum = 464;BA.debugLine="lbl_skb_f3.Text=Value";
Debug.ShouldStop(32768);
setting_activity.mostCurrent._lbl_skb_f3.runMethod(true,"setText",BA.ObjectToCharSequence(_value));
 BA.debugLineNum = 465;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sp_backup_online_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("sp_backup_online_ItemClick (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,774);
if (RapidSub.canDelegate("sp_backup_online_itemclick")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","sp_backup_online_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 774;BA.debugLine="Private Sub sp_backup_online_ItemClick (Position A";
Debug.ShouldStop(32);
 BA.debugLineNum = 775;BA.debugLine="dbCode.update_setting_byname(\"backup_online\",Posi";
Debug.ShouldStop(64);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("backup_online")),(Object)(BA.NumberToString(_position)));
 BA.debugLineNum = 776;BA.debugLine="Main.backup_page_show=0";
Debug.ShouldStop(128);
setting_activity.mostCurrent._main._backup_page_show /*RemoteObject*/  = BA.numberCast(int.class, 0);
 BA.debugLineNum = 777;BA.debugLine="File.WriteString(File.DirInternal,\"chk_backup.txt";
Debug.ShouldStop(256);
setting_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(setting_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("chk_backup.txt")),(Object)(setting_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(setting_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(setting_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))))));
 BA.debugLineNum = 779;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("tik_all_dis (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,398);
if (RapidSub.canDelegate("tik_all_dis")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","tik_all_dis");}
 BA.debugLineNum = 398;BA.debugLine="Sub tik_all_dis";
Debug.ShouldStop(8192);
 BA.debugLineNum = 399;BA.debugLine="tik1.Visible=False";
Debug.ShouldStop(16384);
setting_activity.mostCurrent._tik1.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 400;BA.debugLine="tik2.Visible=False";
Debug.ShouldStop(32768);
setting_activity.mostCurrent._tik2.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 401;BA.debugLine="tik3.Visible=False";
Debug.ShouldStop(65536);
setting_activity.mostCurrent._tik3.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 402;BA.debugLine="tik4.Visible=False";
Debug.ShouldStop(131072);
setting_activity.mostCurrent._tik4.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 403;BA.debugLine="tik5.Visible=False";
Debug.ShouldStop(262144);
setting_activity.mostCurrent._tik5.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 404;BA.debugLine="tik6.Visible=False";
Debug.ShouldStop(524288);
setting_activity.mostCurrent._tik6.runMethod(true,"setVisible",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 405;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tog_ayab_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("tog_ayab_CheckedChange (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,708);
if (RapidSub.canDelegate("tog_ayab_checkedchange")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","tog_ayab_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 708;BA.debugLine="Private Sub tog_ayab_CheckedChange(Checked As Bool";
Debug.ShouldStop(8);
 BA.debugLineNum = 709;BA.debugLine="If(tog_ayab.Checked=True)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_ayab.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 710;BA.debugLine="dbCode.update_setting_byname(\"tog_ayab\",\"1\")";
Debug.ShouldStop(32);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_ayab")),(Object)(RemoteObject.createImmutable("1")));
 }else {
 BA.debugLineNum = 712;BA.debugLine="dbCode.update_setting_byname(\"tog_ayab\",\"0\")";
Debug.ShouldStop(128);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_ayab")),(Object)(RemoteObject.createImmutable("0")));
 };
 BA.debugLineNum = 715;BA.debugLine="chek_togel";
Debug.ShouldStop(1024);
_chek_togel();
 BA.debugLineNum = 716;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tog_bime_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("tog_bime_CheckedChange (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,740);
if (RapidSub.canDelegate("tog_bime_checkedchange")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","tog_bime_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 740;BA.debugLine="Private Sub tog_bime_CheckedChange(Checked As Bool";
Debug.ShouldStop(8);
 BA.debugLineNum = 742;BA.debugLine="If(tog_bime.Checked=True)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_bime.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 743;BA.debugLine="dbCode.update_setting_byname(\"tog_bime\",1)";
Debug.ShouldStop(64);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_bime")),(Object)(BA.NumberToString(1)));
 }else {
 BA.debugLineNum = 745;BA.debugLine="dbCode.update_setting_byname(\"tog_bime\",0)";
Debug.ShouldStop(256);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_bime")),(Object)(BA.NumberToString(0)));
 };
 BA.debugLineNum = 748;BA.debugLine="chek_togel";
Debug.ShouldStop(2048);
_chek_togel();
 BA.debugLineNum = 749;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tog_food_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("tog_food_CheckedChange (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,729);
if (RapidSub.canDelegate("tog_food_checkedchange")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","tog_food_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 729;BA.debugLine="Private Sub tog_food_CheckedChange(Checked As Bool";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 731;BA.debugLine="If(tog_food.Checked=True)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_food.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 732;BA.debugLine="dbCode.update_setting_byname(\"tog_food\",\"1\")";
Debug.ShouldStop(134217728);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_food")),(Object)(RemoteObject.createImmutable("1")));
 }else {
 BA.debugLineNum = 734;BA.debugLine="dbCode.update_setting_byname(\"tog_food\",\"0\")";
Debug.ShouldStop(536870912);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_food")),(Object)(RemoteObject.createImmutable("0")));
 };
 BA.debugLineNum = 737;BA.debugLine="chek_togel";
Debug.ShouldStop(1);
_chek_togel();
 BA.debugLineNum = 738;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tog_maliat_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("tog_maliat_CheckedChange (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,751);
if (RapidSub.canDelegate("tog_maliat_checkedchange")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","tog_maliat_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 751;BA.debugLine="Private Sub tog_maliat_CheckedChange(Checked As Bo";
Debug.ShouldStop(16384);
 BA.debugLineNum = 753;BA.debugLine="If(tog_maliat.Checked=True)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_maliat.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 754;BA.debugLine="dbCode.update_setting_byname(\"tog_maliat\",1)";
Debug.ShouldStop(131072);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_maliat")),(Object)(BA.NumberToString(1)));
 }else {
 BA.debugLineNum = 756;BA.debugLine="dbCode.update_setting_byname(\"tog_maliat\",0)";
Debug.ShouldStop(524288);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_maliat")),(Object)(BA.NumberToString(0)));
 };
 BA.debugLineNum = 759;BA.debugLine="chek_togel";
Debug.ShouldStop(4194304);
_chek_togel();
 BA.debugLineNum = 760;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tog_mosaede_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("tog_mosaede_CheckedChange (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,762);
if (RapidSub.canDelegate("tog_mosaede_checkedchange")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","tog_mosaede_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 762;BA.debugLine="Private Sub tog_mosaede_CheckedChange(Checked As B";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 764;BA.debugLine="If(tog_mosaede.Checked=True)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_mosaede.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 765;BA.debugLine="dbCode.update_setting_byname(\"tog_mosaede\",1)";
Debug.ShouldStop(268435456);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_mosaede")),(Object)(BA.NumberToString(1)));
 }else {
 BA.debugLineNum = 767;BA.debugLine="dbCode.update_setting_byname(\"tog_mosaede\",0)";
Debug.ShouldStop(1073741824);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_mosaede")),(Object)(BA.NumberToString(0)));
 };
 BA.debugLineNum = 770;BA.debugLine="chek_togel";
Debug.ShouldStop(2);
_chek_togel();
 BA.debugLineNum = 772;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tog_padash_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("tog_padash_CheckedChange (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,698);
if (RapidSub.canDelegate("tog_padash_checkedchange")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","tog_padash_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 698;BA.debugLine="Private Sub tog_padash_CheckedChange(Checked As Bo";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 699;BA.debugLine="If(tog_padash.Checked=True)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_padash.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 700;BA.debugLine="dbCode.update_setting_byname(\"tog_padash\",\"1\")";
Debug.ShouldStop(134217728);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_padash")),(Object)(RemoteObject.createImmutable("1")));
 }else {
 BA.debugLineNum = 702;BA.debugLine="dbCode.update_setting_byname(\"tog_padash\",\"0\")";
Debug.ShouldStop(536870912);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_padash")),(Object)(RemoteObject.createImmutable("0")));
 };
 BA.debugLineNum = 705;BA.debugLine="chek_togel";
Debug.ShouldStop(1);
_chek_togel();
 BA.debugLineNum = 706;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tog_sayer_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("tog_sayer_CheckedChange (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,688);
if (RapidSub.canDelegate("tog_sayer_checkedchange")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","tog_sayer_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 688;BA.debugLine="Private Sub tog_sayer_CheckedChange(Checked As Boo";
Debug.ShouldStop(32768);
 BA.debugLineNum = 689;BA.debugLine="If(tog_sayer.Checked=True)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_sayer.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 690;BA.debugLine="dbCode.update_setting_byname(\"tog_sayer\",\"1\")";
Debug.ShouldStop(131072);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_sayer")),(Object)(RemoteObject.createImmutable("1")));
 }else {
 BA.debugLineNum = 692;BA.debugLine="dbCode.update_setting_byname(\"tog_sayer\",\"0\")";
Debug.ShouldStop(524288);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_sayer")),(Object)(RemoteObject.createImmutable("0")));
 };
 BA.debugLineNum = 695;BA.debugLine="chek_togel";
Debug.ShouldStop(4194304);
_chek_togel();
 BA.debugLineNum = 696;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tog_vam_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("tog_vam_CheckedChange (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,718);
if (RapidSub.canDelegate("tog_vam_checkedchange")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","tog_vam_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 718;BA.debugLine="Private Sub tog_vam_CheckedChange(Checked As Boole";
Debug.ShouldStop(8192);
 BA.debugLineNum = 720;BA.debugLine="If(tog_vam.Checked=True)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._tog_vam.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 721;BA.debugLine="dbCode.update_setting_byname(\"tog_vam\",\"1\")";
Debug.ShouldStop(65536);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_vam")),(Object)(RemoteObject.createImmutable("1")));
 }else {
 BA.debugLineNum = 723;BA.debugLine="dbCode.update_setting_byname(\"tog_vam\",\"0\")";
Debug.ShouldStop(262144);
setting_activity.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,setting_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("tog_vam")),(Object)(RemoteObject.createImmutable("0")));
 };
 BA.debugLineNum = 726;BA.debugLine="chek_togel";
Debug.ShouldStop(2097152);
_chek_togel();
 BA.debugLineNum = 727;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("ToggleBtn_finger_CheckedChange (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,614);
if (RapidSub.canDelegate("togglebtn_finger_checkedchange")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","togglebtn_finger_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 614;BA.debugLine="Private Sub ToggleBtn_finger_CheckedChange(Checked";
Debug.ShouldStop(32);
 BA.debugLineNum = 615;BA.debugLine="Try";
Debug.ShouldStop(64);
try { BA.debugLineNum = 616;BA.debugLine="fingerprint1.Initialize (Me, \"auth\")";
Debug.ShouldStop(128);
setting_activity.mostCurrent._fingerprint1.runClassMethod (ir.taravatgroup.ezafekari2.fingerprintmanager.class, "_initialize" /*RemoteObject*/ ,setting_activity.processBA,(Object)(setting_activity.getObject()),(Object)(RemoteObject.createImmutable("auth")));
 BA.debugLineNum = 617;BA.debugLine="If fingerprint1.HardwareDetected = False Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",setting_activity.mostCurrent._fingerprint1.runClassMethod (ir.taravatgroup.ezafekari2.fingerprintmanager.class, "_gethardwaredetected" /*RemoteObject*/ ),setting_activity.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 618;BA.debugLine="ToastMessageShow(\"سنسور اثر انگشت موجود نیست\",";
Debug.ShouldStop(512);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("سنسور اثر انگشت موجود نیست")),(Object)(setting_activity.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 619;BA.debugLine="ToggleBtn_finger.Checked=False";
Debug.ShouldStop(1024);
setting_activity.mostCurrent._togglebtn_finger.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 620;BA.debugLine="Else if fingerprint1.HasEnrolledFingerprints = F";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",setting_activity.mostCurrent._fingerprint1.runClassMethod (ir.taravatgroup.ezafekari2.fingerprintmanager.class, "_gethasenrolledfingerprints" /*RemoteObject*/ ),setting_activity.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 621;BA.debugLine="ToastMessageShow(\"اثر انگشت تعریف نشده است\", Fa";
Debug.ShouldStop(4096);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اثر انگشت تعریف نشده است")),(Object)(setting_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 622;BA.debugLine="ToggleBtn_finger.Checked=False";
Debug.ShouldStop(8192);
setting_activity.mostCurrent._togglebtn_finger.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 }}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e11) {
			BA.rdebugUtils.runVoidMethod("setLastException",setting_activity.processBA, e11.toString()); BA.debugLineNum = 626;BA.debugLine="ToastMessageShow(\"سنسور اثر انگشت موجود نیست\", T";
Debug.ShouldStop(131072);
setting_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("سنسور اثر انگشت موجود نیست")),(Object)(setting_activity.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 627;BA.debugLine="ToggleBtn_finger.Checked=False";
Debug.ShouldStop(262144);
setting_activity.mostCurrent._togglebtn_finger.runMethodAndSync(true,"setChecked",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 628;BA.debugLine="Log(LastException)";
Debug.ShouldStop(524288);
setting_activity.mostCurrent.__c.runVoidMethod ("LogImpl","649545230",BA.ObjectToString(setting_activity.mostCurrent.__c.runMethod(false,"LastException",setting_activity.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 631;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("ToggleBtn_OffOn_lock_CheckedChange (setting_activity) ","setting_activity",25,setting_activity.mostCurrent.activityBA,setting_activity.mostCurrent,585);
if (RapidSub.canDelegate("togglebtn_offon_lock_checkedchange")) { return ir.taravatgroup.ezafekari2.setting_activity.remoteMe.runUserSub(false, "setting_activity","togglebtn_offon_lock_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 585;BA.debugLine="Private Sub ToggleBtn_OffOn_lock_CheckedChange(Che";
Debug.ShouldStop(256);
 BA.debugLineNum = 586;BA.debugLine="Try";
Debug.ShouldStop(512);
try { BA.debugLineNum = 587;BA.debugLine="If(ToggleBtn_OffOn_lock.Checked=False)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",setting_activity.mostCurrent._togglebtn_offon_lock.runMethod(true,"getChecked"),setting_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 588;BA.debugLine="et_pass_lock.Enabled=False";
Debug.ShouldStop(2048);
setting_activity.mostCurrent._et_pass_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 589;BA.debugLine="ToggleBtn_finger.Enabled=False";
Debug.ShouldStop(4096);
setting_activity.mostCurrent._togglebtn_finger.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 590;BA.debugLine="et_hint_lock.Enabled=False";
Debug.ShouldStop(8192);
setting_activity.mostCurrent._et_hint_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 592;BA.debugLine="et_pass_lock.Enabled=True";
Debug.ShouldStop(32768);
setting_activity.mostCurrent._et_pass_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 593;BA.debugLine="ToggleBtn_finger.Enabled=True";
Debug.ShouldStop(65536);
setting_activity.mostCurrent._togglebtn_finger.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 594;BA.debugLine="et_hint_lock.Enabled=True";
Debug.ShouldStop(131072);
setting_activity.mostCurrent._et_hint_lock.runMethod(true,"setEnabled",setting_activity.mostCurrent.__c.getField(true,"True"));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",setting_activity.processBA, e12.toString()); BA.debugLineNum = 598;BA.debugLine="Log(LastException)";
Debug.ShouldStop(2097152);
setting_activity.mostCurrent.__c.runVoidMethod ("LogImpl","649348621",BA.ObjectToString(setting_activity.mostCurrent.__c.runMethod(false,"LastException",setting_activity.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 604;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}