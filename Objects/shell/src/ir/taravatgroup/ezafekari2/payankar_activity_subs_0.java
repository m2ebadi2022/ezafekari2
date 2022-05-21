package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class payankar_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (payankar_activity) ","payankar_activity",14,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,25);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 27;BA.debugLine="Activity.LoadLayout(\"payankar_layout\")";
Debug.ShouldStop(67108864);
payankar_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("payankar_layout")),payankar_activity.mostCurrent.activityBA);
 BA.debugLineNum = 29;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(268435456);
payankar_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA);
 BA.debugLineNum = 30;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(536870912);
payankar_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), payankar_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_setting"))));
 BA.debugLineNum = 32;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
Debug.ShouldStop(-2147483648);
payankar_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 33;BA.debugLine="et_payeh.Tag=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(1);
payankar_activity.mostCurrent._et_payeh.runMethod(false,"setTag",(payankar_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 34;BA.debugLine="et_payeh.Text=show_num_pool(dbCode.res.GetString(";
Debug.ShouldStop(2);
payankar_activity.mostCurrent._et_payeh.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_show_num_pool(BA.numberCast(int.class, payankar_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))))));
 BA.debugLineNum = 36;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(8);
payankar_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 37;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(16);
payankar_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 40;BA.debugLine="et_date1.Text=myfunc.fa2en(Main.persianDate.Persi";
Debug.ShouldStop(128);
payankar_activity.mostCurrent._et_date1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(RemoteObject.concat(payankar_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianYear"),RemoteObject.createImmutable("/01/01"))))));
 BA.debugLineNum = 41;BA.debugLine="et_date2.Text=myfunc.fa2en(Main.persianDate.Persi";
Debug.ShouldStop(256);
payankar_activity.mostCurrent._et_date2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 43;BA.debugLine="et_payeh.Color=Colors.White";
Debug.ShouldStop(1024);
payankar_activity.mostCurrent._et_payeh.runVoidMethod ("setColor",payankar_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 44;BA.debugLine="et_date1.Color=Colors.White";
Debug.ShouldStop(2048);
payankar_activity.mostCurrent._et_date1.runVoidMethod ("setColor",payankar_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 46;BA.debugLine="et_date2.Color=Colors.White";
Debug.ShouldStop(8192);
payankar_activity.mostCurrent._et_date2.runVoidMethod ("setColor",payankar_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 50;BA.debugLine="pan_hed_payankar.Color=Main.color4";
Debug.ShouldStop(131072);
payankar_activity.mostCurrent._pan_hed_payankar.runVoidMethod ("setColor",payankar_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 51;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(262144);
payankar_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._activity));
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_KeyPress (payankar_activity) ","payankar_activity",14,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,67);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 67;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, payankar_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 69;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(16);
_lbl_back_click();
 BA.debugLineNum = 70;BA.debugLine="Return True";
Debug.ShouldStop(32);
if (true) return payankar_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 72;BA.debugLine="Return False";
Debug.ShouldStop(128);
if (true) return payankar_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 74;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Pause (payankar_activity) ","payankar_activity",14,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,58);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 58;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("Activity_Resume (payankar_activity) ","payankar_activity",14,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,54);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","activity_resume");}
 BA.debugLineNum = 54;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_mohasebe_payankar_click() throws Exception{
try {
		Debug.PushSubsStack("btn_mohasebe_payankar_Click (payankar_activity) ","payankar_activity",14,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,77);
if (RapidSub.canDelegate("btn_mohasebe_payankar_click")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","btn_mohasebe_payankar_click");}
RemoteObject _payankar_roz = RemoteObject.createImmutable(0);
RemoteObject _rozha = RemoteObject.createImmutable(0);
RemoteObject _payankar = RemoteObject.createImmutable(0);
 BA.debugLineNum = 77;BA.debugLine="Private Sub btn_mohasebe_payankar_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="Dim payankar_roz As Int";
Debug.ShouldStop(8192);
_payankar_roz = RemoteObject.createImmutable(0);Debug.locals.put("payankar_roz", _payankar_roz);
 BA.debugLineNum = 79;BA.debugLine="Dim rozha As Int";
Debug.ShouldStop(16384);
_rozha = RemoteObject.createImmutable(0);Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 80;BA.debugLine="Dim payankar As Int";
Debug.ShouldStop(32768);
_payankar = RemoteObject.createImmutable(0);Debug.locals.put("payankar", _payankar);
 BA.debugLineNum = 82;BA.debugLine="If(et_payeh.Text=\"\")Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",payankar_activity.mostCurrent._et_payeh.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 83;BA.debugLine="et_payeh.Text=0";
Debug.ShouldStop(262144);
payankar_activity.mostCurrent._et_payeh.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 84;BA.debugLine="et_payeh.Tag=0";
Debug.ShouldStop(524288);
payankar_activity.mostCurrent._et_payeh.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 };
 BA.debugLineNum = 88;BA.debugLine="payankar_roz=et_payeh.Tag/365";
Debug.ShouldStop(8388608);
_payankar_roz = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, payankar_activity.mostCurrent._et_payeh.runMethod(false,"getTag")),RemoteObject.createImmutable(365)}, "/",0, 0));Debug.locals.put("payankar_roz", _payankar_roz);
 BA.debugLineNum = 89;BA.debugLine="rozha=time_mohasebe(et_date1.Text,et_date2.Text)";
Debug.ShouldStop(16777216);
_rozha = _time_mohasebe(payankar_activity.mostCurrent._et_date1.runMethod(true,"getText"),payankar_activity.mostCurrent._et_date2.runMethod(true,"getText"));Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 91;BA.debugLine="payankar=payankar_roz*rozha";
Debug.ShouldStop(67108864);
_payankar = RemoteObject.solve(new RemoteObject[] {_payankar_roz,_rozha}, "*",0, 1);Debug.locals.put("payankar", _payankar);
 BA.debugLineNum = 92;BA.debugLine="If(rozha=365)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",_rozha,BA.numberCast(double.class, 365)))) { 
 BA.debugLineNum = 93;BA.debugLine="payankar=et_payeh.Tag";
Debug.ShouldStop(268435456);
_payankar = BA.numberCast(int.class, payankar_activity.mostCurrent._et_payeh.runMethod(false,"getTag"));Debug.locals.put("payankar", _payankar);
 };
 BA.debugLineNum = 98;BA.debugLine="lbl_payankar.Text=\"تعداد روزها : \"&rozha&CRLF&\"پا";
Debug.ShouldStop(2);
payankar_activity.mostCurrent._lbl_payankar.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("تعداد روزها : "),_rozha,payankar_activity.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("پایان کار دریافتی :"),_show_num_pool(_payankar))));
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _change_formater(RemoteObject _old,RemoteObject _new,RemoteObject _et_name) throws Exception{
try {
		Debug.PushSubsStack("change_formater (payankar_activity) ","payankar_activity",14,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,161);
if (RapidSub.canDelegate("change_formater")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","change_formater", _old, _new, _et_name);}
RemoteObject _d = RemoteObject.createImmutable(0);
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _n = RemoteObject.createImmutable("");
RemoteObject _o = RemoteObject.createImmutable("");
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
Debug.locals.put("et_name", _et_name);
 BA.debugLineNum = 161;BA.debugLine="Sub change_formater (Old As String, New As String,";
Debug.ShouldStop(1);
 BA.debugLineNum = 162;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
Debug.ShouldStop(2);
_d = RemoteObject.createImmutable(0);Debug.locals.put("D", _d);
 BA.debugLineNum = 163;BA.debugLine="Dim S,N,O As String";
Debug.ShouldStop(4);
_s = RemoteObject.createImmutable("");Debug.locals.put("S", _s);
_n = RemoteObject.createImmutable("");Debug.locals.put("N", _n);
_o = RemoteObject.createImmutable("");Debug.locals.put("O", _o);
 BA.debugLineNum = 164;BA.debugLine="n=New.Replace(\",\",\"\")";
Debug.ShouldStop(8);
_n = _new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("N", _n);
 BA.debugLineNum = 165;BA.debugLine="O=Old.Replace(\",\",\"\")";
Debug.ShouldStop(16);
_o = _old.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("O", _o);
 BA.debugLineNum = 166;BA.debugLine="If O<>N Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("!",_o,_n)) { 
 BA.debugLineNum = 167;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
Debug.ShouldStop(64);
_et_name.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_et_name.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 168;BA.debugLine="S=et_name.Text";
Debug.ShouldStop(128);
_s = _et_name.runMethod(true,"getText");Debug.locals.put("S", _s);
 BA.debugLineNum = 169;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",payankar_activity.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(_s)),payankar_activity.mostCurrent.__c.getField(true,"True")) && RemoteObject.solveBoolean("!",_s,BA.ObjectToString("0"))) { 
 BA.debugLineNum = 170;BA.debugLine="D=s";
Debug.ShouldStop(512);
_d = BA.numberCast(double.class, _s);Debug.locals.put("D", _d);
 BA.debugLineNum = 171;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
Debug.ShouldStop(1024);
_et_name.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(payankar_activity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_d),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)))));
 };
 };
 BA.debugLineNum = 174;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
Debug.ShouldStop(8192);
_et_name.runMethod(true,"setSelectionStart",_et_name.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 175;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_payeh_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_payeh_TextChanged (payankar_activity) ","payankar_activity",14,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,176);
if (RapidSub.canDelegate("et_payeh_textchanged")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","et_payeh_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 176;BA.debugLine="Private Sub et_payeh_TextChanged (Old As String, N";
Debug.ShouldStop(32768);
 BA.debugLineNum = 177;BA.debugLine="et_payeh.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(65536);
payankar_activity.mostCurrent._et_payeh.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 178;BA.debugLine="change_formater(Old,New,et_payeh)";
Debug.ShouldStop(131072);
_change_formater(_old,_new,payankar_activity.mostCurrent._et_payeh);
 BA.debugLineNum = 179;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
 //BA.debugLineNum = 16;BA.debugLine="Private et_payeh As EditText";
payankar_activity.mostCurrent._et_payeh = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private lbl_payankar As Label";
payankar_activity.mostCurrent._lbl_payankar = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private et_date1 As EditText";
payankar_activity.mostCurrent._et_date1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private et_date2 As EditText";
payankar_activity.mostCurrent._et_date2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private pan_hed_payankar As Panel";
payankar_activity.mostCurrent._pan_hed_payankar = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (payankar_activity) ","payankar_activity",14,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,62);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","lbl_back_click");}
 BA.debugLineNum = 62;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 64;BA.debugLine="Activity.Finish";
Debug.ShouldStop(-2147483648);
payankar_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _show_num_pool(RemoteObject _num) throws Exception{
try {
		Debug.PushSubsStack("show_num_pool (payankar_activity) ","payankar_activity",14,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,158);
if (RapidSub.canDelegate("show_num_pool")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","show_num_pool", _num);}
Debug.locals.put("num", _num);
 BA.debugLineNum = 158;BA.debugLine="Sub show_num_pool (num As Int) As String";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 159;BA.debugLine="Return NumberFormat(num,0,2)";
Debug.ShouldStop(1073741824);
if (true) return payankar_activity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _num)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2)));
 BA.debugLineNum = 160;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _time_mohasebe(RemoteObject _date1,RemoteObject _date2) throws Exception{
try {
		Debug.PushSubsStack("time_mohasebe (payankar_activity) ","payankar_activity",14,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,102);
if (RapidSub.canDelegate("time_mohasebe")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","time_mohasebe", _date1, _date2);}
RemoteObject _strfun = RemoteObject.declareNull("adr.stringfunctions.stringfunctions");
RemoteObject _list_date_per1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_date_per2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_date_miladi1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_date_miladi2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _dat_mil_2 = RemoteObject.createImmutable("");
RemoteObject _dat_mil_1 = RemoteObject.createImmutable("");
RemoteObject _date_end1 = RemoteObject.createImmutable("");
RemoteObject _date_end2 = RemoteObject.createImmutable("");
RemoteObject _tim1_long = RemoteObject.createImmutable(0L);
RemoteObject _tim2_long = RemoteObject.createImmutable(0L);
RemoteObject _rozha = RemoteObject.createImmutable(0);
Debug.locals.put("date1", _date1);
Debug.locals.put("date2", _date2);
 BA.debugLineNum = 102;BA.debugLine="Sub time_mohasebe(date1 As String, date2 As String";
Debug.ShouldStop(32);
 BA.debugLineNum = 104;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 106;BA.debugLine="Dim strfun As StringFunctions";
Debug.ShouldStop(512);
_strfun = RemoteObject.createNew ("adr.stringfunctions.stringfunctions");Debug.locals.put("strfun", _strfun);
 BA.debugLineNum = 107;BA.debugLine="strfun.Initialize";
Debug.ShouldStop(1024);
_strfun.runVoidMethod ("_initialize",payankar_activity.processBA);
 BA.debugLineNum = 108;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
Debug.ShouldStop(2048);
_list_date_per1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per1", _list_date_per1);
_list_date_per2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 109;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
Debug.ShouldStop(4096);
_list_date_miladi1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi1", _list_date_miladi1);
_list_date_miladi2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 110;BA.debugLine="Dim dat_mil_2 As String";
Debug.ShouldStop(8192);
_dat_mil_2 = RemoteObject.createImmutable("");Debug.locals.put("dat_mil_2", _dat_mil_2);
 BA.debugLineNum = 111;BA.debugLine="Dim dat_mil_1 As String";
Debug.ShouldStop(16384);
_dat_mil_1 = RemoteObject.createImmutable("");Debug.locals.put("dat_mil_1", _dat_mil_1);
 BA.debugLineNum = 113;BA.debugLine="list_date_per1.Initialize";
Debug.ShouldStop(65536);
_list_date_per1.runVoidMethod ("Initialize");
 BA.debugLineNum = 114;BA.debugLine="list_date_per2.Initialize";
Debug.ShouldStop(131072);
_list_date_per2.runVoidMethod ("Initialize");
 BA.debugLineNum = 115;BA.debugLine="list_date_miladi1.Initialize";
Debug.ShouldStop(262144);
_list_date_miladi1.runVoidMethod ("Initialize");
 BA.debugLineNum = 116;BA.debugLine="list_date_miladi1.Initialize";
Debug.ShouldStop(524288);
_list_date_miladi1.runVoidMethod ("Initialize");
 BA.debugLineNum = 120;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
Debug.ShouldStop(8388608);
_list_date_per1 = _strfun.runMethod(false,"_vvvvvv5",(Object)(_date1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per1", _list_date_per1);
 BA.debugLineNum = 121;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
Debug.ShouldStop(16777216);
_list_date_per2 = _strfun.runMethod(false,"_vvvvvv5",(Object)(_date2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 125;BA.debugLine="dat_mil_2=Main.persianDate.PersianToGregorian(li";
Debug.ShouldStop(268435456);
_dat_mil_2 = payankar_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_2", _dat_mil_2);
 BA.debugLineNum = 126;BA.debugLine="dat_mil_1=Main.persianDate.PersianToGregorian(li";
Debug.ShouldStop(536870912);
_dat_mil_1 = payankar_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_1", _dat_mil_1);
 BA.debugLineNum = 129;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
Debug.ShouldStop(1);
_list_date_miladi1 = _strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi1", _list_date_miladi1);
 BA.debugLineNum = 130;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
Debug.ShouldStop(2);
_list_date_miladi2 = _strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 133;BA.debugLine="Dim date_end1 ,date_end2 As String";
Debug.ShouldStop(16);
_date_end1 = RemoteObject.createImmutable("");Debug.locals.put("date_end1", _date_end1);
_date_end2 = RemoteObject.createImmutable("");Debug.locals.put("date_end2", _date_end2);
 BA.debugLineNum = 136;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
Debug.ShouldStop(128);
_date_end2 = RemoteObject.concat(_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end2", _date_end2);
 BA.debugLineNum = 137;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
Debug.ShouldStop(256);
_date_end1 = RemoteObject.concat(_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end1", _date_end1);
 BA.debugLineNum = 142;BA.debugLine="Dim tim1_long As Long";
Debug.ShouldStop(8192);
_tim1_long = RemoteObject.createImmutable(0L);Debug.locals.put("tim1_long", _tim1_long);
 BA.debugLineNum = 143;BA.debugLine="Dim tim2_long As Long";
Debug.ShouldStop(16384);
_tim2_long = RemoteObject.createImmutable(0L);Debug.locals.put("tim2_long", _tim2_long);
 BA.debugLineNum = 144;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
Debug.ShouldStop(32768);
_tim1_long = payankar_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(_date_end1))),(Object)(RemoteObject.createImmutable("00:00:00")));Debug.locals.put("tim1_long", _tim1_long);
 BA.debugLineNum = 145;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
Debug.ShouldStop(65536);
_tim2_long = payankar_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(_date_end2))),(Object)(RemoteObject.createImmutable("00:00:00")));Debug.locals.put("tim2_long", _tim2_long);
 BA.debugLineNum = 146;BA.debugLine="Dim rozha As Int";
Debug.ShouldStop(131072);
_rozha = RemoteObject.createImmutable(0);Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 147;BA.debugLine="rozha=Main.persianDate.CalculateDaysBetween(myfu";
Debug.ShouldStop(262144);
_rozha = BA.numberCast(int.class, payankar_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"CalculateDaysBetween",(Object)(payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(_date_end1))),(Object)(payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(_date_end2)))));Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 150;BA.debugLine="Return rozha+1";
Debug.ShouldStop(2097152);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.solve(new RemoteObject[] {_rozha,RemoteObject.createImmutable(1)}, "+",1, 1);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e29) {
			BA.rdebugUtils.runVoidMethod("setLastException",payankar_activity.processBA, e29.toString()); BA.debugLineNum = 153;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(16777216);
payankar_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(payankar_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 155;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}