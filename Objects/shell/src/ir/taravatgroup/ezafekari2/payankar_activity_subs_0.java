package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class payankar_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,38);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 38;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 40;BA.debugLine="Activity.LoadLayout(\"payankar_layout\")";
Debug.ShouldStop(128);
payankar_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("payankar_layout")),payankar_activity.mostCurrent.activityBA);
 BA.debugLineNum = 42;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(512);
payankar_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA);
 BA.debugLineNum = 43;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(1024);
payankar_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), payankar_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_setting"))));
 BA.debugLineNum = 45;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
Debug.ShouldStop(4096);
payankar_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 46;BA.debugLine="et_payeh.Tag=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(8192);
payankar_activity.mostCurrent._et_payeh.runMethod(false,"setTag",(payankar_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 47;BA.debugLine="et_payeh.Text=show_num_pool(dbCode.res.GetString(";
Debug.ShouldStop(16384);
payankar_activity.mostCurrent._et_payeh.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_show_num_pool(BA.numberCast(int.class, payankar_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))))));
 BA.debugLineNum = 49;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(65536);
payankar_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 50;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(131072);
payankar_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 53;BA.debugLine="lbl_date1.Text=myfunc.fa2en(Main.persianDate.Pers";
Debug.ShouldStop(1048576);
payankar_activity.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(RemoteObject.concat(payankar_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianYear"),RemoteObject.createImmutable("/01/01"))))));
 BA.debugLineNum = 54;BA.debugLine="lbl_date2.Text=myfunc.fa2en(Main.persianDate.Pers";
Debug.ShouldStop(2097152);
payankar_activity.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 56;BA.debugLine="et_payeh.Color=Colors.White";
Debug.ShouldStop(8388608);
payankar_activity.mostCurrent._et_payeh.runVoidMethod ("setColor",payankar_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 60;BA.debugLine="moon_dataPik.Initialize";
Debug.ShouldStop(134217728);
payankar_activity.mostCurrent._moon_datapik.runVoidMethod ("Initialize");
 BA.debugLineNum = 61;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
Debug.ShouldStop(268435456);
payankar_activity.mostCurrent._moon_datapik.runVoidMethod ("AddAll",(Object)(payankar_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 67;BA.debugLine="pan_hed_payankar.Color=Main.color4";
Debug.ShouldStop(4);
payankar_activity.mostCurrent._pan_hed_payankar.runVoidMethod ("setColor",payankar_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 68;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(8);
payankar_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._activity));
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_KeyPress (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,84);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 84;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, payankar_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 86;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(2097152);
_lbl_back_click();
 BA.debugLineNum = 87;BA.debugLine="Return True";
Debug.ShouldStop(4194304);
if (true) return payankar_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 89;BA.debugLine="Return False";
Debug.ShouldStop(16777216);
if (true) return payankar_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 91;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("Activity_Pause (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,75);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 75;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Activity_Resume (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,71);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","activity_resume");}
 BA.debugLineNum = 71;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(64);
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("btn_mohasebe_payankar_Click (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,94);
if (RapidSub.canDelegate("btn_mohasebe_payankar_click")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","btn_mohasebe_payankar_click");}
RemoteObject _payankar_roz = RemoteObject.createImmutable(0);
RemoteObject _rozha = RemoteObject.createImmutable(0);
RemoteObject _payankar = RemoteObject.createImmutable(0);
 BA.debugLineNum = 94;BA.debugLine="Private Sub btn_mohasebe_payankar_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 95;BA.debugLine="Dim payankar_roz As Int";
Debug.ShouldStop(1073741824);
_payankar_roz = RemoteObject.createImmutable(0);Debug.locals.put("payankar_roz", _payankar_roz);
 BA.debugLineNum = 96;BA.debugLine="Dim rozha As Int";
Debug.ShouldStop(-2147483648);
_rozha = RemoteObject.createImmutable(0);Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 97;BA.debugLine="Dim payankar As Int";
Debug.ShouldStop(1);
_payankar = RemoteObject.createImmutable(0);Debug.locals.put("payankar", _payankar);
 BA.debugLineNum = 99;BA.debugLine="If(et_payeh.Text=\"\")Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",payankar_activity.mostCurrent._et_payeh.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 100;BA.debugLine="et_payeh.Text=0";
Debug.ShouldStop(8);
payankar_activity.mostCurrent._et_payeh.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 101;BA.debugLine="et_payeh.Tag=0";
Debug.ShouldStop(16);
payankar_activity.mostCurrent._et_payeh.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 };
 BA.debugLineNum = 105;BA.debugLine="payankar_roz=et_payeh.Tag/365";
Debug.ShouldStop(256);
_payankar_roz = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, payankar_activity.mostCurrent._et_payeh.runMethod(false,"getTag")),RemoteObject.createImmutable(365)}, "/",0, 0));Debug.locals.put("payankar_roz", _payankar_roz);
 BA.debugLineNum = 106;BA.debugLine="rozha=myfunc.time_mohasebe(lbl_date1.Text,lbl_dat";
Debug.ShouldStop(512);
_rozha = payankar_activity.mostCurrent._myfunc.runMethod(true,"_time_mohasebe" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._lbl_date1.runMethod(true,"getText")),(Object)(payankar_activity.mostCurrent._lbl_date2.runMethod(true,"getText")));Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 108;BA.debugLine="payankar=payankar_roz*rozha";
Debug.ShouldStop(2048);
_payankar = RemoteObject.solve(new RemoteObject[] {_payankar_roz,_rozha}, "*",0, 1);Debug.locals.put("payankar", _payankar);
 BA.debugLineNum = 109;BA.debugLine="If(rozha=365)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",_rozha,BA.numberCast(double.class, 365)))) { 
 BA.debugLineNum = 110;BA.debugLine="payankar=et_payeh.Tag";
Debug.ShouldStop(8192);
_payankar = BA.numberCast(int.class, payankar_activity.mostCurrent._et_payeh.runMethod(false,"getTag"));Debug.locals.put("payankar", _payankar);
 };
 BA.debugLineNum = 115;BA.debugLine="lbl_payankar.Text=\"تعداد روزها : \"&rozha&CRLF&\"پا";
Debug.ShouldStop(262144);
payankar_activity.mostCurrent._lbl_payankar.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("تعداد روزها : "),_rozha,payankar_activity.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("پایان کار دریافتی :"),_show_num_pool(_payankar))));
 BA.debugLineNum = 117;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("change_formater (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,123);
if (RapidSub.canDelegate("change_formater")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","change_formater", _old, _new, _et_name);}
RemoteObject _d = RemoteObject.createImmutable(0);
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _n = RemoteObject.createImmutable("");
RemoteObject _o = RemoteObject.createImmutable("");
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
Debug.locals.put("et_name", _et_name);
 BA.debugLineNum = 123;BA.debugLine="Sub change_formater (Old As String, New As String,";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 124;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
Debug.ShouldStop(134217728);
_d = RemoteObject.createImmutable(0);Debug.locals.put("D", _d);
 BA.debugLineNum = 125;BA.debugLine="Dim S,N,O As String";
Debug.ShouldStop(268435456);
_s = RemoteObject.createImmutable("");Debug.locals.put("S", _s);
_n = RemoteObject.createImmutable("");Debug.locals.put("N", _n);
_o = RemoteObject.createImmutable("");Debug.locals.put("O", _o);
 BA.debugLineNum = 126;BA.debugLine="n=New.Replace(\",\",\"\")";
Debug.ShouldStop(536870912);
_n = _new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("N", _n);
 BA.debugLineNum = 127;BA.debugLine="O=Old.Replace(\",\",\"\")";
Debug.ShouldStop(1073741824);
_o = _old.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("O", _o);
 BA.debugLineNum = 128;BA.debugLine="If O<>N Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("!",_o,_n)) { 
 BA.debugLineNum = 129;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
Debug.ShouldStop(1);
_et_name.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_et_name.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 130;BA.debugLine="S=et_name.Text";
Debug.ShouldStop(2);
_s = _et_name.runMethod(true,"getText");Debug.locals.put("S", _s);
 BA.debugLineNum = 131;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",payankar_activity.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(_s)),payankar_activity.mostCurrent.__c.getField(true,"True")) && RemoteObject.solveBoolean("!",_s,BA.ObjectToString("0"))) { 
 BA.debugLineNum = 132;BA.debugLine="D=s";
Debug.ShouldStop(8);
_d = BA.numberCast(double.class, _s);Debug.locals.put("D", _d);
 BA.debugLineNum = 133;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
Debug.ShouldStop(16);
_et_name.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(payankar_activity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_d),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)))));
 };
 };
 BA.debugLineNum = 136;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
Debug.ShouldStop(128);
_et_name.runMethod(true,"setSelectionStart",_et_name.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("et_payeh_TextChanged (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,138);
if (RapidSub.canDelegate("et_payeh_textchanged")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","et_payeh_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 138;BA.debugLine="Private Sub et_payeh_TextChanged (Old As String, N";
Debug.ShouldStop(512);
 BA.debugLineNum = 139;BA.debugLine="et_payeh.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(1024);
payankar_activity.mostCurrent._et_payeh.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 140;BA.debugLine="change_formater(Old,New,et_payeh)";
Debug.ShouldStop(2048);
_change_formater(_old,_new,payankar_activity.mostCurrent._et_payeh);
 BA.debugLineNum = 141;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
 //BA.debugLineNum = 20;BA.debugLine="Private pan_hed_payankar As Panel";
payankar_activity.mostCurrent._pan_hed_payankar = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private pan_all_set_date As Panel";
payankar_activity.mostCurrent._pan_all_set_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private pik_day1 As Label";
payankar_activity.mostCurrent._pik_day1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private pik_moon1 As Label";
payankar_activity.mostCurrent._pik_moon1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private pik_year1 As Label";
payankar_activity.mostCurrent._pik_year1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private lbl_date1 As Label";
payankar_activity.mostCurrent._lbl_date1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private lbl_date2 As Label";
payankar_activity.mostCurrent._lbl_date2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim num_dataPik As Int=0  '' for time picker";
payankar_activity._num_datapik = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 33;BA.debugLine="Dim moon_dataPik As List  '' for date picker";
payankar_activity.mostCurrent._moon_datapik = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 34;BA.debugLine="Dim index_datePik As Int";
payankar_activity._index_datepik = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,79);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","lbl_back_click");}
 BA.debugLineNum = 79;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 81;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
payankar_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _lbl_date1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_date1_Click (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,146);
if (RapidSub.canDelegate("lbl_date1_click")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","lbl_date1_click");}
 BA.debugLineNum = 146;BA.debugLine="Private Sub lbl_date1_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 147;BA.debugLine="pan_all_set_date.Visible=True";
Debug.ShouldStop(262144);
payankar_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",payankar_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 148;BA.debugLine="index_datePik=1";
Debug.ShouldStop(524288);
payankar_activity._index_datepik = BA.numberCast(int.class, 1);
 BA.debugLineNum = 150;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date1.Text.SubStr";
Debug.ShouldStop(2097152);
payankar_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._lbl_date1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4)))))));
 BA.debugLineNum = 151;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date1.Text.SubStri";
Debug.ShouldStop(4194304);
payankar_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._lbl_date1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7)))))));
 BA.debugLineNum = 152;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(8388608);
payankar_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(payankar_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 153;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date1.Text.SubStri";
Debug.ShouldStop(16777216);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._lbl_date1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 10)))))));
 BA.debugLineNum = 154;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("lbl_date2_Click (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,156);
if (RapidSub.canDelegate("lbl_date2_click")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","lbl_date2_click");}
 BA.debugLineNum = 156;BA.debugLine="Private Sub lbl_date2_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 157;BA.debugLine="pan_all_set_date.Visible=True";
Debug.ShouldStop(268435456);
payankar_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",payankar_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 158;BA.debugLine="index_datePik=2";
Debug.ShouldStop(536870912);
payankar_activity._index_datepik = BA.numberCast(int.class, 2);
 BA.debugLineNum = 160;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date2.Text.SubStr";
Debug.ShouldStop(-2147483648);
payankar_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._lbl_date2.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4)))))));
 BA.debugLineNum = 161;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date2.Text.SubStri";
Debug.ShouldStop(1);
payankar_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._lbl_date2.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7)))))));
 BA.debugLineNum = 162;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(2);
payankar_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(payankar_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 163;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date2.Text.SubStri";
Debug.ShouldStop(4);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._lbl_date2.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 10)))))));
 BA.debugLineNum = 164;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("lbl_save_picker_Click (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,166);
if (RapidSub.canDelegate("lbl_save_picker_click")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","lbl_save_picker_click");}
 BA.debugLineNum = 166;BA.debugLine="Private Sub lbl_save_picker_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 167;BA.debugLine="If(index_datePik=1) Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",payankar_activity._index_datepik,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 168;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&myfunc.convert";
Debug.ShouldStop(128);
payankar_activity.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(payankar_activity.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),payankar_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))),RemoteObject.createImmutable("/"),payankar_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")))))));
 }else 
{ BA.debugLineNum = 170;BA.debugLine="Else If(index_datePik=2) Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",payankar_activity._index_datepik,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 171;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&myfunc.convert";
Debug.ShouldStop(1024);
payankar_activity.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(payankar_activity.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),payankar_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))),RemoteObject.createImmutable("/"),payankar_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")))))));
 }}
;
 BA.debugLineNum = 173;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(4096);
payankar_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",payankar_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 174;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_set_date_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_set_date_Click (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,377);
if (RapidSub.canDelegate("pan_all_set_date_click")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","pan_all_set_date_click");}
 BA.debugLineNum = 377;BA.debugLine="Private Sub pan_all_set_date_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 378;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(33554432);
payankar_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",payankar_activity.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _pik_day_bala1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_day_bala1_Click (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,332);
if (RapidSub.canDelegate("pik_day_bala1_click")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","pik_day_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 332;BA.debugLine="Private Sub pik_day_bala1_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 333;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(4096);
_int1 = BA.numberCast(int.class, payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 334;BA.debugLine="pik_day1.Text=int1+1";
Debug.ShouldStop(8192);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 337;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 338;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 339;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(262144);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 341;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 342;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(2097152);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 345;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 346;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(33554432);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 348;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 349;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(268435456);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 353;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("pik_day_paeen1_Click (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,355);
if (RapidSub.canDelegate("pik_day_paeen1_click")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","pik_day_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 355;BA.debugLine="Private Sub pik_day_paeen1_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 356;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(8);
_int1 = BA.numberCast(int.class, payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 357;BA.debugLine="pik_day1.Text=int1-1";
Debug.ShouldStop(16);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 358;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 359;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 360;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(128);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 362;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 363;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(1024);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 366;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 367;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(16384);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 369;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 370;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(131072);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 374;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("pik_moon_bala1_Click (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,278);
if (RapidSub.canDelegate("pik_moon_bala1_click")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","pik_moon_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 278;BA.debugLine="Private Sub pik_moon_bala1_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 279;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(4194304);
_int1 = BA.numberCast(int.class, payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 280;BA.debugLine="pik_moon1.Tag=int1+1";
Debug.ShouldStop(8388608);
payankar_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 282;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 283;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(67108864);
payankar_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 285;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 286;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(536870912);
payankar_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 288;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(-2147483648);
payankar_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(payankar_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 290;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("pik_moon_paeen1_Click (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,292);
if (RapidSub.canDelegate("pik_moon_paeen1_click")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","pik_moon_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 292;BA.debugLine="Private Sub pik_moon_paeen1_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 293;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(16);
_int1 = BA.numberCast(int.class, payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 294;BA.debugLine="pik_moon1.Tag=int1-1";
Debug.ShouldStop(32);
payankar_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 296;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 297;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(256);
payankar_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 299;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 300;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(2048);
payankar_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 302;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
Debug.ShouldStop(8192);
payankar_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(payankar_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0))))));
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
public static RemoteObject  _pik_pan_day1_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("pik_pan_day1_Touch (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,238);
if (RapidSub.canDelegate("pik_pan_day1_touch")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","pik_pan_day1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 238;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
Debug.ShouldStop(8192);
 BA.debugLineNum = 239;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 240;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(32768);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 241;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(65536);
payankar_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 244;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 246;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {payankar_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 247;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
Debug.ShouldStop(4194304);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 248;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(8388608);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 249;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(16777216);
payankar_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 251;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {payankar_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 252;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
Debug.ShouldStop(134217728);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 253;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(268435456);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 254;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(536870912);
payankar_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 257;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 258;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 259;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(4);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 261;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 262;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(32);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 265;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 266;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(512);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 268;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 269;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(4096);
payankar_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 };
 BA.debugLineNum = 276;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("pik_pan_moon1_Touch (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,178);
if (RapidSub.canDelegate("pik_pan_moon1_touch")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","pik_pan_moon1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 178;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
Debug.ShouldStop(131072);
 BA.debugLineNum = 179;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 180;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(524288);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 181;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(1048576);
payankar_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 184;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 186;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {payankar_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 187;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
Debug.ShouldStop(67108864);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 188;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(134217728);
payankar_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 189;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(268435456);
payankar_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 191;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {payankar_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 192;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
Debug.ShouldStop(-2147483648);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 193;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(1);
payankar_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 194;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(2);
payankar_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 197;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 198;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(32);
payankar_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 200;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 201;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(256);
payankar_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 203;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(1024);
payankar_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(payankar_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, payankar_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 };
 BA.debugLineNum = 206;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("pik_pan_year1_Touch (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,208);
if (RapidSub.canDelegate("pik_pan_year1_touch")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","pik_pan_year1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 208;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
Debug.ShouldStop(32768);
 BA.debugLineNum = 209;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 210;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(131072);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 211;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(262144);
payankar_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 214;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 216;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {payankar_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 217;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
Debug.ShouldStop(16777216);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 218;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(33554432);
payankar_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 219;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(67108864);
payankar_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 221;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {payankar_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 222;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
Debug.ShouldStop(536870912);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 223;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(1073741824);
payankar_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 224;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(-2147483648);
payankar_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 227;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 228;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(8);
payankar_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 230;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 231;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(64);
payankar_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 };
 BA.debugLineNum = 236;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("pik_year_bala1_Click (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,306);
if (RapidSub.canDelegate("pik_year_bala1_click")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","pik_year_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 306;BA.debugLine="Private Sub pik_year_bala1_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 307;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(262144);
_int1 = BA.numberCast(int.class, payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 308;BA.debugLine="pik_year1.Text=int1+1";
Debug.ShouldStop(524288);
payankar_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 310;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 311;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(4194304);
payankar_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 313;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 314;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(33554432);
payankar_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
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
public static RemoteObject  _pik_year_paeen1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_year_paeen1_Click (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,319);
if (RapidSub.canDelegate("pik_year_paeen1_click")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","pik_year_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 319;BA.debugLine="Private Sub pik_year_paeen1_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 320;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(-2147483648);
_int1 = BA.numberCast(int.class, payankar_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,payankar_activity.mostCurrent.activityBA,(Object)(payankar_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 321;BA.debugLine="pik_year1.Text=int1-1";
Debug.ShouldStop(1);
payankar_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 323;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 324;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(8);
payankar_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 326;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, payankar_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 327;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(64);
payankar_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _show_num_pool(RemoteObject _num) throws Exception{
try {
		Debug.PushSubsStack("show_num_pool (payankar_activity) ","payankar_activity",21,payankar_activity.mostCurrent.activityBA,payankar_activity.mostCurrent,120);
if (RapidSub.canDelegate("show_num_pool")) { return ir.taravatgroup.ezafekari2.payankar_activity.remoteMe.runUserSub(false, "payankar_activity","show_num_pool", _num);}
Debug.locals.put("num", _num);
 BA.debugLineNum = 120;BA.debugLine="Sub show_num_pool (num As Int) As String";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 121;BA.debugLine="Return NumberFormat(num,0,2)";
Debug.ShouldStop(16777216);
if (true) return payankar_activity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _num)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2)));
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}