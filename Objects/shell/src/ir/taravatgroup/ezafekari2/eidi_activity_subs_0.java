package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class eidi_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,34);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 36;BA.debugLine="Activity.LoadLayout(\"eidi_layout\")";
Debug.ShouldStop(8);
eidi_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("eidi_layout")),eidi_activity.mostCurrent.activityBA);
 BA.debugLineNum = 39;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(64);
eidi_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA);
 BA.debugLineNum = 40;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(128);
eidi_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), eidi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_setting"))));
 BA.debugLineNum = 42;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
Debug.ShouldStop(512);
eidi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 43;BA.debugLine="et_payeh.Tag=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(1024);
eidi_activity.mostCurrent._et_payeh.runMethod(false,"setTag",(eidi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 44;BA.debugLine="et_payeh.Text=show_num_pool(dbCode.res.GetString(";
Debug.ShouldStop(2048);
eidi_activity.mostCurrent._et_payeh.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_show_num_pool(BA.numberCast(int.class, eidi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))))));
 BA.debugLineNum = 46;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(8192);
eidi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 47;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(16384);
eidi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 50;BA.debugLine="lbl_date1.Text=myfunc.fa2en(Main.persianDate.Pers";
Debug.ShouldStop(131072);
eidi_activity.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(RemoteObject.concat(eidi_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianYear"),RemoteObject.createImmutable("/01/01"))))));
 BA.debugLineNum = 51;BA.debugLine="lbl_date2.Text=myfunc.fa2en(Main.persianDate.Pers";
Debug.ShouldStop(262144);
eidi_activity.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 59;BA.debugLine="moon_dataPik.Initialize";
Debug.ShouldStop(67108864);
eidi_activity.mostCurrent._moon_datapik.runVoidMethod ("Initialize");
 BA.debugLineNum = 60;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
Debug.ShouldStop(134217728);
eidi_activity.mostCurrent._moon_datapik.runVoidMethod ("AddAll",(Object)(eidi_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 67;BA.debugLine="et_payeh.Color=Colors.White";
Debug.ShouldStop(4);
eidi_activity.mostCurrent._et_payeh.runVoidMethod ("setColor",eidi_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 68;BA.debugLine="lbl_date1.Color=Colors.White";
Debug.ShouldStop(8);
eidi_activity.mostCurrent._lbl_date1.runVoidMethod ("setColor",eidi_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 69;BA.debugLine="lbl_date2.Color=Colors.White";
Debug.ShouldStop(16);
eidi_activity.mostCurrent._lbl_date2.runVoidMethod ("setColor",eidi_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 73;BA.debugLine="pan_hed_eydi.Color=Main.color4";
Debug.ShouldStop(256);
eidi_activity.mostCurrent._pan_hed_eydi.runVoidMethod ("setColor",eidi_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 74;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(512);
eidi_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._activity));
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("Activity_KeyPress (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,92);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 92;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, eidi_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 94;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(536870912);
_lbl_back_click();
 BA.debugLineNum = 95;BA.debugLine="Return True";
Debug.ShouldStop(1073741824);
if (true) return eidi_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 97;BA.debugLine="Return False";
Debug.ShouldStop(1);
if (true) return eidi_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Activity_Pause (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,82);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 82;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_Resume (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,78);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","activity_resume");}
 BA.debugLineNum = 78;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8192);
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("btn_mohasebe_eidi_Click (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,101);
if (RapidSub.canDelegate("btn_mohasebe_eidi_click")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","btn_mohasebe_eidi_click");}
RemoteObject _eidi_roz = RemoteObject.createImmutable(0);
RemoteObject _rozha = RemoteObject.createImmutable(0);
RemoteObject _eidi_nakhales = RemoteObject.createImmutable(0);
RemoteObject _eidi_khales = RemoteObject.createImmutable(0);
RemoteObject _eidi_maliat = RemoteObject.createImmutable(0);
 BA.debugLineNum = 101;BA.debugLine="Private Sub btn_mohasebe_eidi_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 102;BA.debugLine="Dim eidi_roz As Int";
Debug.ShouldStop(32);
_eidi_roz = RemoteObject.createImmutable(0);Debug.locals.put("eidi_roz", _eidi_roz);
 BA.debugLineNum = 103;BA.debugLine="Dim rozha As Int";
Debug.ShouldStop(64);
_rozha = RemoteObject.createImmutable(0);Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 104;BA.debugLine="Dim eidi_nakhales As Int";
Debug.ShouldStop(128);
_eidi_nakhales = RemoteObject.createImmutable(0);Debug.locals.put("eidi_nakhales", _eidi_nakhales);
 BA.debugLineNum = 105;BA.debugLine="Dim eidi_khales As Int";
Debug.ShouldStop(256);
_eidi_khales = RemoteObject.createImmutable(0);Debug.locals.put("eidi_khales", _eidi_khales);
 BA.debugLineNum = 106;BA.debugLine="Dim eidi_maliat As Int";
Debug.ShouldStop(512);
_eidi_maliat = RemoteObject.createImmutable(0);Debug.locals.put("eidi_maliat", _eidi_maliat);
 BA.debugLineNum = 108;BA.debugLine="If(et_payeh.Text=\"\")Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",eidi_activity.mostCurrent._et_payeh.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 109;BA.debugLine="et_payeh.Text=0";
Debug.ShouldStop(4096);
eidi_activity.mostCurrent._et_payeh.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 110;BA.debugLine="et_payeh.Tag=0";
Debug.ShouldStop(8192);
eidi_activity.mostCurrent._et_payeh.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 };
 BA.debugLineNum = 114;BA.debugLine="eidi_roz=(et_payeh.Tag*2)/365";
Debug.ShouldStop(131072);
_eidi_roz = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, eidi_activity.mostCurrent._et_payeh.runMethod(false,"getTag")),RemoteObject.createImmutable(2)}, "*",0, 0)),RemoteObject.createImmutable(365)}, "/",0, 0));Debug.locals.put("eidi_roz", _eidi_roz);
 BA.debugLineNum = 115;BA.debugLine="rozha=myfunc.time_mohasebe(lbl_date1.Text,lbl_dat";
Debug.ShouldStop(262144);
_rozha = eidi_activity.mostCurrent._myfunc.runMethod(true,"_time_mohasebe" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._lbl_date1.runMethod(true,"getText")),(Object)(eidi_activity.mostCurrent._lbl_date2.runMethod(true,"getText")));Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 117;BA.debugLine="eidi_nakhales=eidi_roz*rozha";
Debug.ShouldStop(1048576);
_eidi_nakhales = RemoteObject.solve(new RemoteObject[] {_eidi_roz,_rozha}, "*",0, 1);Debug.locals.put("eidi_nakhales", _eidi_nakhales);
 BA.debugLineNum = 118;BA.debugLine="If(rozha=365)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",_rozha,BA.numberCast(double.class, 365)))) { 
 BA.debugLineNum = 119;BA.debugLine="eidi_nakhales=et_payeh.Tag*2";
Debug.ShouldStop(4194304);
_eidi_nakhales = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, eidi_activity.mostCurrent._et_payeh.runMethod(false,"getTag")),RemoteObject.createImmutable(2)}, "*",0, 0));Debug.locals.put("eidi_nakhales", _eidi_nakhales);
 };
 BA.debugLineNum = 122;BA.debugLine="If(eidi_nakhales>(3*5308284) )Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean(">",_eidi_nakhales,BA.numberCast(double.class, (RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(3),RemoteObject.createImmutable(5308284)}, "*",0, 1)))))) { 
 BA.debugLineNum = 123;BA.debugLine="eidi_nakhales= (3*5308284)";
Debug.ShouldStop(67108864);
_eidi_nakhales = (RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(3),RemoteObject.createImmutable(5308284)}, "*",0, 1));Debug.locals.put("eidi_nakhales", _eidi_nakhales);
 };
 BA.debugLineNum = 126;BA.debugLine="eidi_maliat=mohasebe_maliat(eidi_nakhales , myfun";
Debug.ShouldStop(536870912);
_eidi_maliat = _mohasebe_maliat(_eidi_nakhales,BA.numberCast(int.class, eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(eidi_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianYear"))))));Debug.locals.put("eidi_maliat", _eidi_maliat);
 BA.debugLineNum = 127;BA.debugLine="eidi_khales=eidi_nakhales-eidi_maliat";
Debug.ShouldStop(1073741824);
_eidi_khales = RemoteObject.solve(new RemoteObject[] {_eidi_nakhales,_eidi_maliat}, "-",1, 1);Debug.locals.put("eidi_khales", _eidi_khales);
 BA.debugLineNum = 129;BA.debugLine="lbl_eidi.Text=\"تعداد روزها : \"&rozha&CRLF&\"ناخالص";
Debug.ShouldStop(1);
eidi_activity.mostCurrent._lbl_eidi.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("تعداد روزها : "),_rozha,eidi_activity.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("ناخالص :"),_show_num_pool(_eidi_nakhales),eidi_activity.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable(" مالیات : "),_show_num_pool(_eidi_maliat),eidi_activity.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("خالص عیدی دریافتی :"),_show_num_pool(_eidi_khales))));
 BA.debugLineNum = 131;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("change_formater (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,137);
if (RapidSub.canDelegate("change_formater")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","change_formater", _old, _new, _et_name);}
RemoteObject _d = RemoteObject.createImmutable(0);
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _n = RemoteObject.createImmutable("");
RemoteObject _o = RemoteObject.createImmutable("");
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
Debug.locals.put("et_name", _et_name);
 BA.debugLineNum = 137;BA.debugLine="Sub change_formater (Old As String, New As String,";
Debug.ShouldStop(256);
 BA.debugLineNum = 138;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
Debug.ShouldStop(512);
_d = RemoteObject.createImmutable(0);Debug.locals.put("D", _d);
 BA.debugLineNum = 139;BA.debugLine="Dim S,N,O As String";
Debug.ShouldStop(1024);
_s = RemoteObject.createImmutable("");Debug.locals.put("S", _s);
_n = RemoteObject.createImmutable("");Debug.locals.put("N", _n);
_o = RemoteObject.createImmutable("");Debug.locals.put("O", _o);
 BA.debugLineNum = 140;BA.debugLine="n=New.Replace(\",\",\"\")";
Debug.ShouldStop(2048);
_n = _new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("N", _n);
 BA.debugLineNum = 141;BA.debugLine="O=Old.Replace(\",\",\"\")";
Debug.ShouldStop(4096);
_o = _old.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("O", _o);
 BA.debugLineNum = 142;BA.debugLine="If O<>N Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("!",_o,_n)) { 
 BA.debugLineNum = 143;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
Debug.ShouldStop(16384);
_et_name.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_et_name.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 144;BA.debugLine="S=et_name.Text";
Debug.ShouldStop(32768);
_s = _et_name.runMethod(true,"getText");Debug.locals.put("S", _s);
 BA.debugLineNum = 145;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",eidi_activity.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(_s)),eidi_activity.mostCurrent.__c.getField(true,"True")) && RemoteObject.solveBoolean("!",_s,BA.ObjectToString("0"))) { 
 BA.debugLineNum = 146;BA.debugLine="D=s";
Debug.ShouldStop(131072);
_d = BA.numberCast(double.class, _s);Debug.locals.put("D", _d);
 BA.debugLineNum = 147;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
Debug.ShouldStop(262144);
_et_name.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(eidi_activity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_d),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)))));
 };
 };
 BA.debugLineNum = 150;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
Debug.ShouldStop(2097152);
_et_name.runMethod(true,"setSelectionStart",_et_name.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("et_payeh_TextChanged (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,152);
if (RapidSub.canDelegate("et_payeh_textchanged")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","et_payeh_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 152;BA.debugLine="Private Sub et_payeh_TextChanged (Old As String, N";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 153;BA.debugLine="et_payeh.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(16777216);
eidi_activity.mostCurrent._et_payeh.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 154;BA.debugLine="change_formater(Old,New,et_payeh)";
Debug.ShouldStop(33554432);
_change_formater(_old,_new,eidi_activity.mostCurrent._et_payeh);
 BA.debugLineNum = 155;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
 //BA.debugLineNum = 20;BA.debugLine="Private pan_hed_eydi As Panel";
eidi_activity.mostCurrent._pan_hed_eydi = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private lbl_date2 As Label";
eidi_activity.mostCurrent._lbl_date2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_date1 As Label";
eidi_activity.mostCurrent._lbl_date1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private pik_day1 As Label";
eidi_activity.mostCurrent._pik_day1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private pik_moon1 As Label";
eidi_activity.mostCurrent._pik_moon1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private pik_year1 As Label";
eidi_activity.mostCurrent._pik_year1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim num_dataPik As Int=0  '' for time picker";
eidi_activity._num_datapik = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 29;BA.debugLine="Dim moon_dataPik As List  '' for date picker";
eidi_activity.mostCurrent._moon_datapik = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 30;BA.debugLine="Dim index_datePik As Int";
eidi_activity._index_datepik = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 31;BA.debugLine="Private pan_all_set_date As Panel";
eidi_activity.mostCurrent._pan_all_set_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,87);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","lbl_back_click");}
 BA.debugLineNum = 87;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 89;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16777216);
eidi_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _lbl_date1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_date1_Click (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,255);
if (RapidSub.canDelegate("lbl_date1_click")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","lbl_date1_click");}
 BA.debugLineNum = 255;BA.debugLine="Private Sub lbl_date1_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 256;BA.debugLine="pan_all_set_date.Visible=True";
Debug.ShouldStop(-2147483648);
eidi_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",eidi_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 257;BA.debugLine="index_datePik=1";
Debug.ShouldStop(1);
eidi_activity._index_datepik = BA.numberCast(int.class, 1);
 BA.debugLineNum = 259;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date1.Text.SubStr";
Debug.ShouldStop(4);
eidi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._lbl_date1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4)))))));
 BA.debugLineNum = 260;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date1.Text.SubStri";
Debug.ShouldStop(8);
eidi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._lbl_date1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7)))))));
 BA.debugLineNum = 261;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(16);
eidi_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(eidi_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 262;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date1.Text.SubStri";
Debug.ShouldStop(32);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._lbl_date1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 10)))))));
 BA.debugLineNum = 263;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_date2_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_date2_Click (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,265);
if (RapidSub.canDelegate("lbl_date2_click")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","lbl_date2_click");}
 BA.debugLineNum = 265;BA.debugLine="Private Sub lbl_date2_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 266;BA.debugLine="pan_all_set_date.Visible=True";
Debug.ShouldStop(512);
eidi_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",eidi_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 267;BA.debugLine="index_datePik=2";
Debug.ShouldStop(1024);
eidi_activity._index_datepik = BA.numberCast(int.class, 2);
 BA.debugLineNum = 269;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date2.Text.SubStr";
Debug.ShouldStop(4096);
eidi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._lbl_date2.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4)))))));
 BA.debugLineNum = 270;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date2.Text.SubStri";
Debug.ShouldStop(8192);
eidi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._lbl_date2.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7)))))));
 BA.debugLineNum = 271;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(16384);
eidi_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(eidi_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 272;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date2.Text.SubStri";
Debug.ShouldStop(32768);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._lbl_date2.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 10)))))));
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
public static RemoteObject  _lbl_save_picker_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_picker_Click (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,275);
if (RapidSub.canDelegate("lbl_save_picker_click")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","lbl_save_picker_click");}
 BA.debugLineNum = 275;BA.debugLine="Private Sub lbl_save_picker_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 276;BA.debugLine="If(index_datePik=1) Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",eidi_activity._index_datepik,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 277;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&myfunc.convert";
Debug.ShouldStop(1048576);
eidi_activity.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(eidi_activity.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),eidi_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))),RemoteObject.createImmutable("/"),eidi_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")))))));
 }else 
{ BA.debugLineNum = 279;BA.debugLine="Else If(index_datePik=2) Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",eidi_activity._index_datepik,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 280;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&myfunc.convert";
Debug.ShouldStop(8388608);
eidi_activity.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(eidi_activity.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),eidi_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))),RemoteObject.createImmutable("/"),eidi_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")))))));
 }}
;
 BA.debugLineNum = 282;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(33554432);
eidi_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",eidi_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 283;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("mohasebe_maliat (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,159);
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
 BA.debugLineNum = 159;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 160;BA.debugLine="Dim all_maliat As Int=0";
Debug.ShouldStop(-2147483648);
_all_maliat = BA.numberCast(int.class, 0);Debug.locals.put("all_maliat", _all_maliat);Debug.locals.put("all_maliat", _all_maliat);
 BA.debugLineNum = 161;BA.debugLine="Dim state1 As Int=0";
Debug.ShouldStop(1);
_state1 = BA.numberCast(int.class, 0);Debug.locals.put("state1", _state1);Debug.locals.put("state1", _state1);
 BA.debugLineNum = 162;BA.debugLine="Dim state2 As Int=0";
Debug.ShouldStop(2);
_state2 = BA.numberCast(int.class, 0);Debug.locals.put("state2", _state2);Debug.locals.put("state2", _state2);
 BA.debugLineNum = 163;BA.debugLine="Dim state3 As Int=0";
Debug.ShouldStop(4);
_state3 = BA.numberCast(int.class, 0);Debug.locals.put("state3", _state3);Debug.locals.put("state3", _state3);
 BA.debugLineNum = 164;BA.debugLine="Dim state4 As Int=0";
Debug.ShouldStop(8);
_state4 = BA.numberCast(int.class, 0);Debug.locals.put("state4", _state4);Debug.locals.put("state4", _state4);
 BA.debugLineNum = 165;BA.debugLine="Dim state5 As Int=0";
Debug.ShouldStop(16);
_state5 = BA.numberCast(int.class, 0);Debug.locals.put("state5", _state5);Debug.locals.put("state5", _state5);
 BA.debugLineNum = 166;BA.debugLine="Dim state6 As Int=0";
Debug.ShouldStop(32);
_state6 = BA.numberCast(int.class, 0);Debug.locals.put("state6", _state6);Debug.locals.put("state6", _state6);
 BA.debugLineNum = 168;BA.debugLine="If (year=1399)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1399)))) { 
 BA.debugLineNum = 169;BA.debugLine="If(hogog>3000001 And hogog<7500001)Then	  ''----";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 3000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 7500001)))) { 
 BA.debugLineNum = 170;BA.debugLine="state1=(hogog-3000000)*0.1";
Debug.ShouldStop(512);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(3000000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 172;BA.debugLine="If(hogog>7500001 And hogog<10500001)Then	  ''---";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 7500001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 10500001)))) { 
 BA.debugLineNum = 173;BA.debugLine="state1=(3000000)*0.1";
Debug.ShouldStop(4096);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 174;BA.debugLine="state2=(hogog-7500000)*0.15";
Debug.ShouldStop(8192);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(7500000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 176;BA.debugLine="If(hogog>10500001 And hogog<15000001)Then	  ''--";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 10500001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 15000001)))) { 
 BA.debugLineNum = 177;BA.debugLine="state1=(3000000)*0.1";
Debug.ShouldStop(65536);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 178;BA.debugLine="state2=(3000000)*0.15";
Debug.ShouldStop(131072);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 179;BA.debugLine="state3=(hogog-10500000)*0.2";
Debug.ShouldStop(262144);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(10500000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 181;BA.debugLine="If(hogog>15000001)Then	  ''-----stat4";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 15000001)))) { 
 BA.debugLineNum = 182;BA.debugLine="state1=(3000000)*0.1";
Debug.ShouldStop(2097152);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 183;BA.debugLine="state2=(3000000)*0.15";
Debug.ShouldStop(4194304);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 184;BA.debugLine="state3=(4500000)*0.2";
Debug.ShouldStop(8388608);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4500000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 185;BA.debugLine="state4=(hogog-15000001)*0.25";
Debug.ShouldStop(16777216);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(15000001)}, "-",1, 1)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 };
 BA.debugLineNum = 189;BA.debugLine="If (year=1400)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1400)))) { 
 BA.debugLineNum = 190;BA.debugLine="If(hogog>4000001 And hogog<8000001)Then	  ''----";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 4000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 8000001)))) { 
 BA.debugLineNum = 191;BA.debugLine="state1=(hogog-4000000)*0.1";
Debug.ShouldStop(1073741824);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(4000000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 193;BA.debugLine="If(hogog>8000001 And hogog<12000001)Then	  ''---";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 8000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 12000001)))) { 
 BA.debugLineNum = 194;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(2);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 195;BA.debugLine="state2=(hogog-8000000)*0.15";
Debug.ShouldStop(4);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(8000000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 197;BA.debugLine="If(hogog>12000001 And hogog<18000001)Then	  ''--";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 12000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 18000001)))) { 
 BA.debugLineNum = 198;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(32);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 199;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(64);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 200;BA.debugLine="state3=(hogog-12000000)*0.2";
Debug.ShouldStop(128);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(12000000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 202;BA.debugLine="If(hogog>18000001 And hogog<24000001)Then	  ''--";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 18000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 24000001)))) { 
 BA.debugLineNum = 203;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(1024);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 204;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(2048);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 205;BA.debugLine="state3=(4000000)*0.2";
Debug.ShouldStop(4096);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 206;BA.debugLine="state4=(hogog-18000000)*0.25";
Debug.ShouldStop(8192);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(18000000)}, "-",1, 1)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 BA.debugLineNum = 208;BA.debugLine="If(hogog>24000001 And hogog<32000001)Then	  ''--";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 24000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 32000001)))) { 
 BA.debugLineNum = 209;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(65536);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 210;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(131072);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 211;BA.debugLine="state3=(4000000)*0.2";
Debug.ShouldStop(262144);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 212;BA.debugLine="state4=(6000000)*0.25";
Debug.ShouldStop(524288);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6000000)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 BA.debugLineNum = 213;BA.debugLine="state5=(hogog-24000000)*0.3";
Debug.ShouldStop(1048576);
_state5 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(24000000)}, "-",1, 1)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state5", _state5);
 };
 BA.debugLineNum = 215;BA.debugLine="If(hogog>32000001)Then	  ''-----stat4";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 32000001)))) { 
 BA.debugLineNum = 216;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(8388608);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 217;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(16777216);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 218;BA.debugLine="state3=(4000000)*0.2";
Debug.ShouldStop(33554432);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 219;BA.debugLine="state4=(6000000)*0.25";
Debug.ShouldStop(67108864);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6000000)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 BA.debugLineNum = 220;BA.debugLine="state5=(6000000)*0.3";
Debug.ShouldStop(134217728);
_state5 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6000000)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state5", _state5);
 BA.debugLineNum = 221;BA.debugLine="state6=(hogog-32000000)*0.35";
Debug.ShouldStop(268435456);
_state6 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(32000000)}, "-",1, 1)),RemoteObject.createImmutable(0.35)}, "*",0, 0));Debug.locals.put("state6", _state6);
 };
 };
 BA.debugLineNum = 225;BA.debugLine="If (year=1401)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1401)))) { 
 BA.debugLineNum = 226;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 5600001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 12500001)))) { 
 BA.debugLineNum = 227;BA.debugLine="state1=(hogog-5600000)*0.1";
Debug.ShouldStop(4);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(5600000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 229;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 12500001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 20830001)))) { 
 BA.debugLineNum = 230;BA.debugLine="state1=(6900000)*0.1";
Debug.ShouldStop(32);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6900000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 231;BA.debugLine="state2=(hogog-12500000)*0.15";
Debug.ShouldStop(64);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(12500000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 233;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 20830001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 29160001)))) { 
 BA.debugLineNum = 234;BA.debugLine="state1=(6900000)*0.1";
Debug.ShouldStop(512);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6900000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 235;BA.debugLine="state2=(8330000)*0.15";
Debug.ShouldStop(1024);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((8330000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 236;BA.debugLine="state3=(hogog-20830000)*0.2";
Debug.ShouldStop(2048);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(20830000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 239;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 29160001)))) { 
 BA.debugLineNum = 240;BA.debugLine="state1=(6900000)*0.1";
Debug.ShouldStop(32768);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6900000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 241;BA.debugLine="state2=(8330000)*0.15";
Debug.ShouldStop(65536);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((8330000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 242;BA.debugLine="state3=(8330000)*0.2";
Debug.ShouldStop(131072);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((8330000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 244;BA.debugLine="state4=(hogog-29160000)*0.3";
Debug.ShouldStop(524288);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(29160000)}, "-",1, 1)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 };
 BA.debugLineNum = 249;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
Debug.ShouldStop(16777216);
_all_maliat = RemoteObject.solve(new RemoteObject[] {_state1,_state2,_state3,_state4,_state5,_state6}, "+++++",5, 1);Debug.locals.put("all_maliat", _all_maliat);
 BA.debugLineNum = 250;BA.debugLine="Return all_maliat";
Debug.ShouldStop(33554432);
if (true) return _all_maliat;
 BA.debugLineNum = 252;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_set_date_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_set_date_Click (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,486);
if (RapidSub.canDelegate("pan_all_set_date_click")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","pan_all_set_date_click");}
 BA.debugLineNum = 486;BA.debugLine="Private Sub pan_all_set_date_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 487;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(64);
eidi_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",eidi_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 488;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_day_bala1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_day_bala1_Click (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,441);
if (RapidSub.canDelegate("pik_day_bala1_click")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","pik_day_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 441;BA.debugLine="Private Sub pik_day_bala1_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 442;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(33554432);
_int1 = BA.numberCast(int.class, eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 443;BA.debugLine="pik_day1.Text=int1+1";
Debug.ShouldStop(67108864);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 446;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 447;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 448;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(-2147483648);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 450;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 451;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(4);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 454;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 455;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(64);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 457;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 458;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(512);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 462;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_day_paeen1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_day_paeen1_Click (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,464);
if (RapidSub.canDelegate("pik_day_paeen1_click")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","pik_day_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 464;BA.debugLine="Private Sub pik_day_paeen1_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 465;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(65536);
_int1 = BA.numberCast(int.class, eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 466;BA.debugLine="pik_day1.Text=int1-1";
Debug.ShouldStop(131072);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 467;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 468;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 469;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(1048576);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 471;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 472;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(8388608);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 475;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 476;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(134217728);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 478;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 479;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(1073741824);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 483;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_moon_bala1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_moon_bala1_Click (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,387);
if (RapidSub.canDelegate("pik_moon_bala1_click")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","pik_moon_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 387;BA.debugLine="Private Sub pik_moon_bala1_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 388;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(8);
_int1 = BA.numberCast(int.class, eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 389;BA.debugLine="pik_moon1.Tag=int1+1";
Debug.ShouldStop(16);
eidi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 391;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 392;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(128);
eidi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 394;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 395;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(1024);
eidi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 397;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(4096);
eidi_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(eidi_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 399;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_moon_paeen1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_moon_paeen1_Click (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,401);
if (RapidSub.canDelegate("pik_moon_paeen1_click")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","pik_moon_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 401;BA.debugLine="Private Sub pik_moon_paeen1_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 402;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(131072);
_int1 = BA.numberCast(int.class, eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 403;BA.debugLine="pik_moon1.Tag=int1-1";
Debug.ShouldStop(262144);
eidi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 405;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 406;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(2097152);
eidi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 408;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 409;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(16777216);
eidi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 411;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
Debug.ShouldStop(67108864);
eidi_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(eidi_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0))))));
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
public static RemoteObject  _pik_pan_day1_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("pik_pan_day1_Touch (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,347);
if (RapidSub.canDelegate("pik_pan_day1_touch")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","pik_pan_day1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 347;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 348;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 349;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(268435456);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 350;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(536870912);
eidi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 353;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 355;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {eidi_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 356;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
Debug.ShouldStop(8);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 357;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(16);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 358;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(32);
eidi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 360;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {eidi_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 361;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
Debug.ShouldStop(256);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 362;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(512);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 363;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(1024);
eidi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 366;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 367;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 368;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(32768);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 370;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 371;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(262144);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 374;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 375;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(4194304);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 377;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 378;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(33554432);
eidi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 };
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
public static RemoteObject  _pik_pan_moon1_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("pik_pan_moon1_Touch (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,287);
if (RapidSub.canDelegate("pik_pan_moon1_touch")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","pik_pan_moon1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 287;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 288;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 289;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(1);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 290;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(2);
eidi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 293;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 295;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {eidi_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 296;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
Debug.ShouldStop(128);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 297;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(256);
eidi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 298;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(512);
eidi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 300;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {eidi_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 301;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
Debug.ShouldStop(4096);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 302;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(8192);
eidi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 303;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(16384);
eidi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 306;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 307;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(262144);
eidi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 309;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 310;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(2097152);
eidi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 312;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(8388608);
eidi_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(eidi_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, eidi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 };
 BA.debugLineNum = 315;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_pan_year1_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("pik_pan_year1_Touch (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,317);
if (RapidSub.canDelegate("pik_pan_year1_touch")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","pik_pan_year1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 317;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 318;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 319;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(1073741824);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 320;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(-2147483648);
eidi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 323;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 325;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {eidi_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 326;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
Debug.ShouldStop(32);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 327;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(64);
eidi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 328;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(128);
eidi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 330;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {eidi_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 331;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
Debug.ShouldStop(1024);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 332;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(2048);
eidi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 333;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(4096);
eidi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 336;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 337;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(65536);
eidi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 339;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 340;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(524288);
eidi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 };
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
public static RemoteObject  _pik_year_bala1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_year_bala1_Click (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,415);
if (RapidSub.canDelegate("pik_year_bala1_click")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","pik_year_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 415;BA.debugLine="Private Sub pik_year_bala1_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 416;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(-2147483648);
_int1 = BA.numberCast(int.class, eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 417;BA.debugLine="pik_year1.Text=int1+1";
Debug.ShouldStop(1);
eidi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 419;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 420;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(8);
eidi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 422;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 423;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(64);
eidi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 426;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_year_paeen1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_year_paeen1_Click (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,428);
if (RapidSub.canDelegate("pik_year_paeen1_click")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","pik_year_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 428;BA.debugLine="Private Sub pik_year_paeen1_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 429;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(4096);
_int1 = BA.numberCast(int.class, eidi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,eidi_activity.mostCurrent.activityBA,(Object)(eidi_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 430;BA.debugLine="pik_year1.Text=int1-1";
Debug.ShouldStop(8192);
eidi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 432;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 433;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(65536);
eidi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 435;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, eidi_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 436;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(524288);
eidi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 439;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("show_num_pool (eidi_activity) ","eidi_activity",10,eidi_activity.mostCurrent.activityBA,eidi_activity.mostCurrent,134);
if (RapidSub.canDelegate("show_num_pool")) { return ir.taravatgroup.ezafekari2.eidi_activity.remoteMe.runUserSub(false, "eidi_activity","show_num_pool", _num);}
Debug.locals.put("num", _num);
 BA.debugLineNum = 134;BA.debugLine="Sub show_num_pool (num As Int) As String";
Debug.ShouldStop(32);
 BA.debugLineNum = 135;BA.debugLine="Return NumberFormat(num,0,2)";
Debug.ShouldStop(64);
if (true) return eidi_activity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _num)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2)));
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}