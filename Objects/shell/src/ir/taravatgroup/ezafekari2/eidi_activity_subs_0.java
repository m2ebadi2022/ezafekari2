package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class eidi_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (eidi_activity) ","eidi_activity",11,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,24);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 26;BA.debugLine="Activity.LoadLayout(\"eidi_layout\")";
Debug.ShouldStop(33554432);
eidi_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("eidi_layout")),eidi_activity.mostCurrent.activityBA);
 BA.debugLineNum = 29;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(268435456);
eidi_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA);
 BA.debugLineNum = 30;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(536870912);
eidi_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), eidi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_setting"))));
 BA.debugLineNum = 32;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
Debug.ShouldStop(-2147483648);
eidi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 33;BA.debugLine="et_payeh.Tag=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(1);
eidi_activity.mostCurrent._et_payeh.runMethod(false,"setTag",(eidi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 34;BA.debugLine="et_payeh.Text=show_num_pool(dbCode.res.GetString(";
Debug.ShouldStop(2);
eidi_activity.mostCurrent._et_payeh.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_show_num_pool(BA.numberCast(int.class, eidi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))))));
 BA.debugLineNum = 36;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(8);
eidi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 37;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(16);
eidi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 40;BA.debugLine="et_date1.Text=myfunc.fa2en(Main.persianDate.Persi";
Debug.ShouldStop(128);
eidi_activity.mostCurrent._et_date1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(RemoteObject.concat(eidi_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianYear"),RemoteObject.createImmutable("/01/01"))))));
 BA.debugLineNum = 41;BA.debugLine="et_date2.Text=myfunc.fa2en(Main.persianDate.Persi";
Debug.ShouldStop(256);
eidi_activity.mostCurrent._et_date2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 44;BA.debugLine="et_payeh.Color=Colors.White";
Debug.ShouldStop(2048);
eidi_activity.mostCurrent._et_payeh.runVoidMethod ("setColor",eidi_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 45;BA.debugLine="et_date1.Color=Colors.White";
Debug.ShouldStop(4096);
eidi_activity.mostCurrent._et_date1.runVoidMethod ("setColor",eidi_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 46;BA.debugLine="et_date2.Color=Colors.White";
Debug.ShouldStop(8192);
eidi_activity.mostCurrent._et_date2.runVoidMethod ("setColor",eidi_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 50;BA.debugLine="pan_hed_eydi.Color=Main.color4";
Debug.ShouldStop(131072);
eidi_activity.mostCurrent._pan_hed_eydi.runVoidMethod ("setColor",eidi_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 51;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(262144);
eidi_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._activity));
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
		Debug.PushSubsStack("Activity_KeyPress (eidi_activity) ","eidi_activity",11,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,69);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 69;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, eidi_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 71;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(64);
_lbl_back_click();
 BA.debugLineNum = 72;BA.debugLine="Return True";
Debug.ShouldStop(128);
if (true) return eidi_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 74;BA.debugLine="Return False";
Debug.ShouldStop(512);
if (true) return eidi_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Activity_Pause (eidi_activity) ","eidi_activity",11,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,59);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 59;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_Resume (eidi_activity) ","eidi_activity",11,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,55);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","activity_resume");}
 BA.debugLineNum = 55;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_mohasebe_eidi_click() throws Exception{
try {
		Debug.PushSubsStack("btn_mohasebe_eidi_Click (eidi_activity) ","eidi_activity",11,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,78);
if (RapidSub.canDelegate("btn_mohasebe_eidi_click")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","btn_mohasebe_eidi_click");}
RemoteObject _eidi_roz = RemoteObject.createImmutable(0);
RemoteObject _rozha = RemoteObject.createImmutable(0);
RemoteObject _eidi_nakhales = RemoteObject.createImmutable(0);
RemoteObject _eidi_khales = RemoteObject.createImmutable(0);
RemoteObject _eidi_maliat = RemoteObject.createImmutable(0);
 BA.debugLineNum = 78;BA.debugLine="Private Sub btn_mohasebe_eidi_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="Dim eidi_roz As Int";
Debug.ShouldStop(16384);
_eidi_roz = RemoteObject.createImmutable(0);Debug.locals.put("eidi_roz", _eidi_roz);
 BA.debugLineNum = 80;BA.debugLine="Dim rozha As Int";
Debug.ShouldStop(32768);
_rozha = RemoteObject.createImmutable(0);Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 81;BA.debugLine="Dim eidi_nakhales As Int";
Debug.ShouldStop(65536);
_eidi_nakhales = RemoteObject.createImmutable(0);Debug.locals.put("eidi_nakhales", _eidi_nakhales);
 BA.debugLineNum = 82;BA.debugLine="Dim eidi_khales As Int";
Debug.ShouldStop(131072);
_eidi_khales = RemoteObject.createImmutable(0);Debug.locals.put("eidi_khales", _eidi_khales);
 BA.debugLineNum = 83;BA.debugLine="Dim eidi_maliat As Int";
Debug.ShouldStop(262144);
_eidi_maliat = RemoteObject.createImmutable(0);Debug.locals.put("eidi_maliat", _eidi_maliat);
 BA.debugLineNum = 85;BA.debugLine="If(et_payeh.Text=\"\")Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",eidi_activity.mostCurrent._et_payeh.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 86;BA.debugLine="et_payeh.Text=0";
Debug.ShouldStop(2097152);
eidi_activity.mostCurrent._et_payeh.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 87;BA.debugLine="et_payeh.Tag=0";
Debug.ShouldStop(4194304);
eidi_activity.mostCurrent._et_payeh.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 };
 BA.debugLineNum = 91;BA.debugLine="eidi_roz=(et_payeh.Tag*2)/365";
Debug.ShouldStop(67108864);
_eidi_roz = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, eidi_activity.mostCurrent._et_payeh.runMethod(false,"getTag")),RemoteObject.createImmutable(2)}, "*",0, 0)),RemoteObject.createImmutable(365)}, "/",0, 0));Debug.locals.put("eidi_roz", _eidi_roz);
 BA.debugLineNum = 92;BA.debugLine="rozha=time_mohasebe(et_date1.Text,et_date2.Text)";
Debug.ShouldStop(134217728);
_rozha = _time_mohasebe(eidi_activity.mostCurrent._et_date1.runMethod(true,"getText"),eidi_activity.mostCurrent._et_date2.runMethod(true,"getText"));Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 94;BA.debugLine="eidi_nakhales=eidi_roz*rozha";
Debug.ShouldStop(536870912);
_eidi_nakhales = RemoteObject.solve(new RemoteObject[] {_eidi_roz,_rozha}, "*",0, 1);Debug.locals.put("eidi_nakhales", _eidi_nakhales);
 BA.debugLineNum = 95;BA.debugLine="If(rozha=365)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",_rozha,BA.numberCast(double.class, 365)))) { 
 BA.debugLineNum = 96;BA.debugLine="eidi_nakhales=et_payeh.Tag*2";
Debug.ShouldStop(-2147483648);
_eidi_nakhales = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, eidi_activity.mostCurrent._et_payeh.runMethod(false,"getTag")),RemoteObject.createImmutable(2)}, "*",0, 0));Debug.locals.put("eidi_nakhales", _eidi_nakhales);
 };
 BA.debugLineNum = 98;BA.debugLine="eidi_maliat=mohasebe_maliat(eidi_nakhales , myfun";
Debug.ShouldStop(2);
_eidi_maliat = _mohasebe_maliat(_eidi_nakhales,BA.numberCast(int.class, eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(eidi_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianYear"))))));Debug.locals.put("eidi_maliat", _eidi_maliat);
 BA.debugLineNum = 99;BA.debugLine="eidi_khales=eidi_nakhales-eidi_maliat";
Debug.ShouldStop(4);
_eidi_khales = RemoteObject.solve(new RemoteObject[] {_eidi_nakhales,_eidi_maliat}, "-",1, 1);Debug.locals.put("eidi_khales", _eidi_khales);
 BA.debugLineNum = 101;BA.debugLine="lbl_eidi.Text=\"تعداد روزها : \"&rozha&CRLF&\"ناخالص";
Debug.ShouldStop(16);
eidi_activity.mostCurrent._lbl_eidi.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("تعداد روزها : "),_rozha,eidi_activity.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("ناخالص :"),_show_num_pool(_eidi_nakhales),eidi_activity.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable(" مالیات : "),_show_num_pool(_eidi_maliat),eidi_activity.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("خالص عیدی دریافتی :"),_show_num_pool(_eidi_khales))));
 BA.debugLineNum = 103;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("change_formater (eidi_activity) ","eidi_activity",11,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,163);
if (RapidSub.canDelegate("change_formater")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","change_formater", _old, _new, _et_name);}
RemoteObject _d = RemoteObject.createImmutable(0);
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _n = RemoteObject.createImmutable("");
RemoteObject _o = RemoteObject.createImmutable("");
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
Debug.locals.put("et_name", _et_name);
 BA.debugLineNum = 163;BA.debugLine="Sub change_formater (Old As String, New As String,";
Debug.ShouldStop(4);
 BA.debugLineNum = 164;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
Debug.ShouldStop(8);
_d = RemoteObject.createImmutable(0);Debug.locals.put("D", _d);
 BA.debugLineNum = 165;BA.debugLine="Dim S,N,O As String";
Debug.ShouldStop(16);
_s = RemoteObject.createImmutable("");Debug.locals.put("S", _s);
_n = RemoteObject.createImmutable("");Debug.locals.put("N", _n);
_o = RemoteObject.createImmutable("");Debug.locals.put("O", _o);
 BA.debugLineNum = 166;BA.debugLine="n=New.Replace(\",\",\"\")";
Debug.ShouldStop(32);
_n = _new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("N", _n);
 BA.debugLineNum = 167;BA.debugLine="O=Old.Replace(\",\",\"\")";
Debug.ShouldStop(64);
_o = _old.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("O", _o);
 BA.debugLineNum = 168;BA.debugLine="If O<>N Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("!",_o,_n)) { 
 BA.debugLineNum = 169;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
Debug.ShouldStop(256);
_et_name.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_et_name.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 170;BA.debugLine="S=et_name.Text";
Debug.ShouldStop(512);
_s = _et_name.runMethod(true,"getText");Debug.locals.put("S", _s);
 BA.debugLineNum = 171;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",eidi_activity.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(_s)),eidi_activity.mostCurrent.__c.getField(true,"True")) && RemoteObject.solveBoolean("!",_s,BA.ObjectToString("0"))) { 
 BA.debugLineNum = 172;BA.debugLine="D=s";
Debug.ShouldStop(2048);
_d = BA.numberCast(double.class, _s);Debug.locals.put("D", _d);
 BA.debugLineNum = 173;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
Debug.ShouldStop(4096);
_et_name.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(eidi_activity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_d),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)))));
 };
 };
 BA.debugLineNum = 176;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
Debug.ShouldStop(32768);
_et_name.runMethod(true,"setSelectionStart",_et_name.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 177;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("et_payeh_TextChanged (eidi_activity) ","eidi_activity",11,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,178);
if (RapidSub.canDelegate("et_payeh_textchanged")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","et_payeh_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 178;BA.debugLine="Private Sub et_payeh_TextChanged (Old As String, N";
Debug.ShouldStop(131072);
 BA.debugLineNum = 179;BA.debugLine="et_payeh.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(262144);
eidi_activity.mostCurrent._et_payeh.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 180;BA.debugLine="change_formater(Old,New,et_payeh)";
Debug.ShouldStop(524288);
_change_formater(_old,_new,eidi_activity.mostCurrent._et_payeh);
 BA.debugLineNum = 181;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
eidi_activity.mostCurrent._et_payeh = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private lbl_eidi As Label";
eidi_activity.mostCurrent._lbl_eidi = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private et_date1 As EditText";
eidi_activity.mostCurrent._et_date1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private et_date2 As EditText";
eidi_activity.mostCurrent._et_date2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private pan_hed_eydi As Panel";
eidi_activity.mostCurrent._pan_hed_eydi = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (eidi_activity) ","eidi_activity",11,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,64);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","lbl_back_click");}
 BA.debugLineNum = 64;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 66;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2);
eidi_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 67;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mohasebe_maliat(RemoteObject _hogog,RemoteObject _year) throws Exception{
try {
		Debug.PushSubsStack("mohasebe_maliat (eidi_activity) ","eidi_activity",11,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,185);
if (RapidSub.canDelegate("mohasebe_maliat")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","mohasebe_maliat", _hogog, _year);}
RemoteObject _all_maliat = RemoteObject.createImmutable(0);
RemoteObject _state1 = RemoteObject.createImmutable(0);
RemoteObject _state2 = RemoteObject.createImmutable(0);
RemoteObject _state3 = RemoteObject.createImmutable(0);
RemoteObject _state4 = RemoteObject.createImmutable(0);
RemoteObject _state5 = RemoteObject.createImmutable(0);
RemoteObject _state6 = RemoteObject.createImmutable(0);
Debug.locals.put("hogog", _hogog);
Debug.locals.put("year", _year);
 BA.debugLineNum = 185;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 186;BA.debugLine="Dim all_maliat As Int=0";
Debug.ShouldStop(33554432);
_all_maliat = BA.numberCast(int.class, 0);Debug.locals.put("all_maliat", _all_maliat);Debug.locals.put("all_maliat", _all_maliat);
 BA.debugLineNum = 187;BA.debugLine="Dim state1 As Int=0";
Debug.ShouldStop(67108864);
_state1 = BA.numberCast(int.class, 0);Debug.locals.put("state1", _state1);Debug.locals.put("state1", _state1);
 BA.debugLineNum = 188;BA.debugLine="Dim state2 As Int=0";
Debug.ShouldStop(134217728);
_state2 = BA.numberCast(int.class, 0);Debug.locals.put("state2", _state2);Debug.locals.put("state2", _state2);
 BA.debugLineNum = 189;BA.debugLine="Dim state3 As Int=0";
Debug.ShouldStop(268435456);
_state3 = BA.numberCast(int.class, 0);Debug.locals.put("state3", _state3);Debug.locals.put("state3", _state3);
 BA.debugLineNum = 190;BA.debugLine="Dim state4 As Int=0";
Debug.ShouldStop(536870912);
_state4 = BA.numberCast(int.class, 0);Debug.locals.put("state4", _state4);Debug.locals.put("state4", _state4);
 BA.debugLineNum = 191;BA.debugLine="Dim state5 As Int=0";
Debug.ShouldStop(1073741824);
_state5 = BA.numberCast(int.class, 0);Debug.locals.put("state5", _state5);Debug.locals.put("state5", _state5);
 BA.debugLineNum = 192;BA.debugLine="Dim state6 As Int=0";
Debug.ShouldStop(-2147483648);
_state6 = BA.numberCast(int.class, 0);Debug.locals.put("state6", _state6);Debug.locals.put("state6", _state6);
 BA.debugLineNum = 194;BA.debugLine="If (year=1399)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1399)))) { 
 BA.debugLineNum = 195;BA.debugLine="If(hogog>3000001 And hogog<7500001)Then	  ''----";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 3000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 7500001)))) { 
 BA.debugLineNum = 196;BA.debugLine="state1=(hogog-3000000)*0.1";
Debug.ShouldStop(8);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(3000000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 198;BA.debugLine="If(hogog>7500001 And hogog<10500001)Then	  ''---";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 7500001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 10500001)))) { 
 BA.debugLineNum = 199;BA.debugLine="state1=(3000000)*0.1";
Debug.ShouldStop(64);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 200;BA.debugLine="state2=(hogog-7500000)*0.15";
Debug.ShouldStop(128);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(7500000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 202;BA.debugLine="If(hogog>10500001 And hogog<15000001)Then	  ''--";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 10500001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 15000001)))) { 
 BA.debugLineNum = 203;BA.debugLine="state1=(3000000)*0.1";
Debug.ShouldStop(1024);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 204;BA.debugLine="state2=(3000000)*0.15";
Debug.ShouldStop(2048);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 205;BA.debugLine="state3=(hogog-10500000)*0.2";
Debug.ShouldStop(4096);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(10500000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 207;BA.debugLine="If(hogog>15000001)Then	  ''-----stat4";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 15000001)))) { 
 BA.debugLineNum = 208;BA.debugLine="state1=(3000000)*0.1";
Debug.ShouldStop(32768);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 209;BA.debugLine="state2=(3000000)*0.15";
Debug.ShouldStop(65536);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 210;BA.debugLine="state3=(4500000)*0.2";
Debug.ShouldStop(131072);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4500000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 211;BA.debugLine="state4=(hogog-15000001)*0.25";
Debug.ShouldStop(262144);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(15000001)}, "-",1, 1)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 };
 BA.debugLineNum = 215;BA.debugLine="If (year=1400)Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1400)))) { 
 BA.debugLineNum = 216;BA.debugLine="If(hogog>4000001 And hogog<8000001)Then	  ''----";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 4000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 8000001)))) { 
 BA.debugLineNum = 217;BA.debugLine="state1=(hogog-4000000)*0.1";
Debug.ShouldStop(16777216);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(4000000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 219;BA.debugLine="If(hogog>8000001 And hogog<12000001)Then	  ''---";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 8000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 12000001)))) { 
 BA.debugLineNum = 220;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(134217728);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 221;BA.debugLine="state2=(hogog-8000000)*0.15";
Debug.ShouldStop(268435456);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(8000000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 223;BA.debugLine="If(hogog>12000001 And hogog<18000001)Then	  ''--";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 12000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 18000001)))) { 
 BA.debugLineNum = 224;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(-2147483648);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 225;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(1);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 226;BA.debugLine="state3=(hogog-12000000)*0.2";
Debug.ShouldStop(2);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(12000000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 228;BA.debugLine="If(hogog>18000001 And hogog<24000001)Then	  ''--";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 18000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 24000001)))) { 
 BA.debugLineNum = 229;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(16);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 230;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(32);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 231;BA.debugLine="state3=(4000000)*0.2";
Debug.ShouldStop(64);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 232;BA.debugLine="state4=(hogog-18000000)*0.25";
Debug.ShouldStop(128);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(18000000)}, "-",1, 1)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 BA.debugLineNum = 234;BA.debugLine="If(hogog>24000001 And hogog<32000001)Then	  ''--";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 24000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 32000001)))) { 
 BA.debugLineNum = 235;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(1024);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 236;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(2048);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 237;BA.debugLine="state3=(4000000)*0.2";
Debug.ShouldStop(4096);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 238;BA.debugLine="state4=(6000000)*0.25";
Debug.ShouldStop(8192);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6000000)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 BA.debugLineNum = 239;BA.debugLine="state5=(hogog-24000000)*0.3";
Debug.ShouldStop(16384);
_state5 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(24000000)}, "-",1, 1)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state5", _state5);
 };
 BA.debugLineNum = 241;BA.debugLine="If(hogog>32000001)Then	  ''-----stat4";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 32000001)))) { 
 BA.debugLineNum = 242;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(131072);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 243;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(262144);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 244;BA.debugLine="state3=(4000000)*0.2";
Debug.ShouldStop(524288);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 245;BA.debugLine="state4=(6000000)*0.25";
Debug.ShouldStop(1048576);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6000000)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 BA.debugLineNum = 246;BA.debugLine="state5=(6000000)*0.3";
Debug.ShouldStop(2097152);
_state5 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6000000)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state5", _state5);
 BA.debugLineNum = 247;BA.debugLine="state6=(hogog-32000000)*0.35";
Debug.ShouldStop(4194304);
_state6 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(32000000)}, "-",1, 1)),RemoteObject.createImmutable(0.35)}, "*",0, 0));Debug.locals.put("state6", _state6);
 };
 };
 BA.debugLineNum = 251;BA.debugLine="If (year=1401)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1401)))) { 
 BA.debugLineNum = 252;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 5600001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 12500001)))) { 
 BA.debugLineNum = 253;BA.debugLine="state1=(hogog-5600000)*0.1";
Debug.ShouldStop(268435456);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(5600000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 255;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 12500001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 20830001)))) { 
 BA.debugLineNum = 256;BA.debugLine="state1=(6900000)*0.1";
Debug.ShouldStop(-2147483648);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6900000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 257;BA.debugLine="state2=(hogog-12500000)*0.15";
Debug.ShouldStop(1);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(12500000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 259;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 20830001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 29160001)))) { 
 BA.debugLineNum = 260;BA.debugLine="state1=(6900000)*0.1";
Debug.ShouldStop(8);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6900000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 261;BA.debugLine="state2=(8330000)*0.15";
Debug.ShouldStop(16);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((8330000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 262;BA.debugLine="state3=(hogog-20830000)*0.2";
Debug.ShouldStop(32);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(20830000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 265;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 29160001)))) { 
 BA.debugLineNum = 266;BA.debugLine="state1=(6900000)*0.1";
Debug.ShouldStop(512);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6900000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 267;BA.debugLine="state2=(8330000)*0.15";
Debug.ShouldStop(1024);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((8330000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 268;BA.debugLine="state3=(8330000)*0.2";
Debug.ShouldStop(2048);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((8330000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 270;BA.debugLine="state4=(hogog-29160000)*0.3";
Debug.ShouldStop(8192);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(29160000)}, "-",1, 1)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 };
 BA.debugLineNum = 275;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
Debug.ShouldStop(262144);
_all_maliat = RemoteObject.solve(new RemoteObject[] {_state1,_state2,_state3,_state4,_state5,_state6}, "+++++",5, 1);Debug.locals.put("all_maliat", _all_maliat);
 BA.debugLineNum = 276;BA.debugLine="Return all_maliat";
Debug.ShouldStop(524288);
if (true) return _all_maliat;
 BA.debugLineNum = 278;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable(0);
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
		Debug.PushSubsStack("show_num_pool (eidi_activity) ","eidi_activity",11,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,160);
if (RapidSub.canDelegate("show_num_pool")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","show_num_pool", _num);}
Debug.locals.put("num", _num);
 BA.debugLineNum = 160;BA.debugLine="Sub show_num_pool (num As Int) As String";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 161;BA.debugLine="Return NumberFormat(num,0,2)";
Debug.ShouldStop(1);
if (true) return eidi_activity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _num)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2)));
 BA.debugLineNum = 162;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("time_mohasebe (eidi_activity) ","eidi_activity",11,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,105);
if (RapidSub.canDelegate("time_mohasebe")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","time_mohasebe", _date1, _date2);}
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
 BA.debugLineNum = 105;BA.debugLine="Sub time_mohasebe(date1 As String, date2 As String";
Debug.ShouldStop(256);
 BA.debugLineNum = 107;BA.debugLine="Try";
Debug.ShouldStop(1024);
try { BA.debugLineNum = 109;BA.debugLine="Dim strfun As StringFunctions";
Debug.ShouldStop(4096);
_strfun = RemoteObject.createNew ("adr.stringfunctions.stringfunctions");Debug.locals.put("strfun", _strfun);
 BA.debugLineNum = 110;BA.debugLine="strfun.Initialize";
Debug.ShouldStop(8192);
_strfun.runVoidMethod ("_initialize",eidi_activity.processBA);
 BA.debugLineNum = 111;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
Debug.ShouldStop(16384);
_list_date_per1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per1", _list_date_per1);
_list_date_per2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 112;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
Debug.ShouldStop(32768);
_list_date_miladi1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi1", _list_date_miladi1);
_list_date_miladi2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 113;BA.debugLine="Dim dat_mil_2 As String";
Debug.ShouldStop(65536);
_dat_mil_2 = RemoteObject.createImmutable("");Debug.locals.put("dat_mil_2", _dat_mil_2);
 BA.debugLineNum = 114;BA.debugLine="Dim dat_mil_1 As String";
Debug.ShouldStop(131072);
_dat_mil_1 = RemoteObject.createImmutable("");Debug.locals.put("dat_mil_1", _dat_mil_1);
 BA.debugLineNum = 116;BA.debugLine="list_date_per1.Initialize";
Debug.ShouldStop(524288);
_list_date_per1.runVoidMethod ("Initialize");
 BA.debugLineNum = 117;BA.debugLine="list_date_per2.Initialize";
Debug.ShouldStop(1048576);
_list_date_per2.runVoidMethod ("Initialize");
 BA.debugLineNum = 118;BA.debugLine="list_date_miladi1.Initialize";
Debug.ShouldStop(2097152);
_list_date_miladi1.runVoidMethod ("Initialize");
 BA.debugLineNum = 119;BA.debugLine="list_date_miladi1.Initialize";
Debug.ShouldStop(4194304);
_list_date_miladi1.runVoidMethod ("Initialize");
 BA.debugLineNum = 123;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
Debug.ShouldStop(67108864);
_list_date_per1 = _strfun.runMethod(false,"_vvvvvv5",(Object)(_date1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per1", _list_date_per1);
 BA.debugLineNum = 124;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
Debug.ShouldStop(134217728);
_list_date_per2 = _strfun.runMethod(false,"_vvvvvv5",(Object)(_date2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 128;BA.debugLine="dat_mil_2=Main.persianDate.PersianToGregorian(li";
Debug.ShouldStop(-2147483648);
_dat_mil_2 = eidi_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_2", _dat_mil_2);
 BA.debugLineNum = 129;BA.debugLine="dat_mil_1=Main.persianDate.PersianToGregorian(li";
Debug.ShouldStop(1);
_dat_mil_1 = eidi_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_1", _dat_mil_1);
 BA.debugLineNum = 132;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
Debug.ShouldStop(8);
_list_date_miladi1 = _strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi1", _list_date_miladi1);
 BA.debugLineNum = 133;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
Debug.ShouldStop(16);
_list_date_miladi2 = _strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 136;BA.debugLine="Dim date_end1 ,date_end2 As String";
Debug.ShouldStop(128);
_date_end1 = RemoteObject.createImmutable("");Debug.locals.put("date_end1", _date_end1);
_date_end2 = RemoteObject.createImmutable("");Debug.locals.put("date_end2", _date_end2);
 BA.debugLineNum = 139;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
Debug.ShouldStop(1024);
_date_end2 = RemoteObject.concat(_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end2", _date_end2);
 BA.debugLineNum = 140;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
Debug.ShouldStop(2048);
_date_end1 = RemoteObject.concat(_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end1", _date_end1);
 BA.debugLineNum = 145;BA.debugLine="Dim tim1_long As Long";
Debug.ShouldStop(65536);
_tim1_long = RemoteObject.createImmutable(0L);Debug.locals.put("tim1_long", _tim1_long);
 BA.debugLineNum = 146;BA.debugLine="Dim tim2_long As Long";
Debug.ShouldStop(131072);
_tim2_long = RemoteObject.createImmutable(0L);Debug.locals.put("tim2_long", _tim2_long);
 BA.debugLineNum = 147;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
Debug.ShouldStop(262144);
_tim1_long = eidi_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(_date_end1))),(Object)(RemoteObject.createImmutable("00:00:00")));Debug.locals.put("tim1_long", _tim1_long);
 BA.debugLineNum = 148;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
Debug.ShouldStop(524288);
_tim2_long = eidi_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(_date_end2))),(Object)(RemoteObject.createImmutable("00:00:00")));Debug.locals.put("tim2_long", _tim2_long);
 BA.debugLineNum = 149;BA.debugLine="Dim rozha As Int";
Debug.ShouldStop(1048576);
_rozha = RemoteObject.createImmutable(0);Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 150;BA.debugLine="rozha=Main.persianDate.CalculateDaysBetween(myfu";
Debug.ShouldStop(2097152);
_rozha = BA.numberCast(int.class, eidi_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"CalculateDaysBetween",(Object)(eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(_date_end1))),(Object)(eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(_date_end2)))));Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 152;BA.debugLine="Return rozha+1";
Debug.ShouldStop(8388608);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.solve(new RemoteObject[] {_rozha,RemoteObject.createImmutable(1)}, "+",1, 1);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e29) {
			BA.rdebugUtils.runVoidMethod("setLastException",eidi_activity.processBA, e29.toString()); BA.debugLineNum = 155;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(67108864);
eidi_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(eidi_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 157;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}