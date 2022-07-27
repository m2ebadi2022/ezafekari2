package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class morakhasi_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,58);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 58;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 60;BA.debugLine="Activity.LoadLayout(\"morakhasi_layout\")";
Debug.ShouldStop(134217728);
morakhasi_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("morakhasi_layout")),morakhasi_activity.mostCurrent.activityBA);
 BA.debugLineNum = 62;BA.debugLine="ScrollView1.Panel.LoadLayout(\"morakhasi_item\")";
Debug.ShouldStop(536870912);
morakhasi_activity.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("morakhasi_item")),morakhasi_activity.mostCurrent.activityBA);
 BA.debugLineNum = 63;BA.debugLine="get_mande_db";
Debug.ShouldStop(1073741824);
_get_mande_db();
 BA.debugLineNum = 65;BA.debugLine="lbl_mah.Text=Main.persianDate.PersianMonthName";
Debug.ShouldStop(1);
morakhasi_activity.mostCurrent._lbl_mah.runMethod(true,"setText",BA.ObjectToCharSequence(morakhasi_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianMonthName")));
 BA.debugLineNum = 68;BA.debugLine="pan_hed_mandeMorakh.Color=Main.color4";
Debug.ShouldStop(8);
morakhasi_activity.mostCurrent._pan_hed_mandemorakh.runVoidMethod ("setColor",morakhasi_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 69;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(16);
morakhasi_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._activity));
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("Activity_KeyPress (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,153);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 153;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 154;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, morakhasi_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 155;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(67108864);
_lbl_back_click();
 BA.debugLineNum = 156;BA.debugLine="Return True";
Debug.ShouldStop(134217728);
if (true) return morakhasi_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 158;BA.debugLine="Return False";
Debug.ShouldStop(536870912);
if (true) return morakhasi_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 160;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Pause (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,142);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 142;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 144;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("Activity_Resume (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,138);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","activity_resume");}
 BA.debugLineNum = 138;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(512);
 BA.debugLineNum = 140;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_morakhasiha_mah(RemoteObject _year,RemoteObject _moon,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("all_morakhasiha_mah (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,271);
if (RapidSub.canDelegate("all_morakhasiha_mah")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","all_morakhasiha_mah", _year, _moon, _state);}
RemoteObject _str = RemoteObject.createImmutable("");
RemoteObject _v_day = RemoteObject.createImmutable(0);
RemoteObject _v_hour = RemoteObject.createImmutable(0);
RemoteObject _v_min = RemoteObject.createImmutable(0);
RemoteObject _div1 = RemoteObject.createImmutable(0);
RemoteObject _div2 = RemoteObject.createImmutable(0);
RemoteObject _all_min = RemoteObject.createImmutable(0);
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
Debug.locals.put("state", _state);
 BA.debugLineNum = 271;BA.debugLine="Sub all_morakhasiha_mah(year As String, moon As St";
Debug.ShouldStop(16384);
 BA.debugLineNum = 272;BA.debugLine="Dim str As String";
Debug.ShouldStop(32768);
_str = RemoteObject.createImmutable("");Debug.locals.put("str", _str);
 BA.debugLineNum = 275;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(262144);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 276;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(524288);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 277;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(1048576);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 278;BA.debugLine="Dim div1 As Int=0";
Debug.ShouldStop(2097152);
_div1 = BA.numberCast(int.class, 0);Debug.locals.put("div1", _div1);Debug.locals.put("div1", _div1);
 BA.debugLineNum = 279;BA.debugLine="Dim div2 As Int=0";
Debug.ShouldStop(4194304);
_div2 = BA.numberCast(int.class, 0);Debug.locals.put("div2", _div2);Debug.locals.put("div2", _div2);
 BA.debugLineNum = 280;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(8388608);
morakhasi_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA);
 BA.debugLineNum = 281;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(16777216);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' AND state="),_state))));
 BA.debugLineNum = 282;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(33554432);
while (morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 284;BA.debugLine="v_day=v_day+dbCode.res.GetString(\"end_tim_d\")";
Debug.ShouldStop(134217728);
_v_day = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_day,BA.numberCast(double.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))))}, "+",1, 0));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 285;BA.debugLine="v_hour=v_hour+dbCode.res.GetString(\"end_tim_h\")";
Debug.ShouldStop(268435456);
_v_hour = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_hour,BA.numberCast(double.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))))}, "+",1, 0));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 286;BA.debugLine="v_min=v_min+dbCode.res.GetString(\"end_tim_m\")";
Debug.ShouldStop(536870912);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 290;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(2);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 291;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(4);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 294;BA.debugLine="Dim all_min As Int";
Debug.ShouldStop(32);
_all_min = RemoteObject.createImmutable(0);Debug.locals.put("all_min", _all_min);
 BA.debugLineNum = 295;BA.debugLine="all_min=(v_day*Main.saat_kar_min)+(v_hour*60)+v_m";
Debug.ShouldStop(64);
_all_min = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_v_day,morakhasi_activity.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_v_hour,RemoteObject.createImmutable(60)}, "*",0, 1)),_v_min}, "++",2, 1);Debug.locals.put("all_min", _all_min);
 BA.debugLineNum = 296;BA.debugLine="v_hour=	myfunc.Min_to_saatMinRoz(all_min).Get(0)";
Debug.ShouldStop(128);
_v_hour = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_all_min)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 297;BA.debugLine="v_min=	myfunc.Min_to_saatMinRoz(all_min).Get(1)";
Debug.ShouldStop(256);
_v_min = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_all_min)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 298;BA.debugLine="v_day=	myfunc.Min_to_saatMinRoz(all_min).Get(2)";
Debug.ShouldStop(512);
_v_day = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_all_min)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 318;BA.debugLine="If(state=0)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",_state,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 319;BA.debugLine="morakhasi_estefade_esteh=all_min";
Debug.ShouldStop(1073741824);
morakhasi_activity._morakhasi_estefade_esteh = _all_min;
 };
 BA.debugLineNum = 323;BA.debugLine="str=modify_str_showTime(v_day,v_hour,v_min)";
Debug.ShouldStop(4);
_str = _modify_str_showtime(_v_day,_v_hour,_v_min);Debug.locals.put("str", _str);
 BA.debugLineNum = 324;BA.debugLine="Return str";
Debug.ShouldStop(8);
if (true) return _str;
 BA.debugLineNum = 325;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_mande_db() throws Exception{
try {
		Debug.PushSubsStack("get_mande_db (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,76);
if (RapidSub.canDelegate("get_mande_db")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","get_mande_db");}
 BA.debugLineNum = 76;BA.debugLine="Sub get_mande_db";
Debug.ShouldStop(2048);
 BA.debugLineNum = 78;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(8192);
morakhasi_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA);
 BA.debugLineNum = 79;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(16384);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_setting"))));
 BA.debugLineNum = 81;BA.debugLine="dbCode.res.Position=20 ''--------day------";
Debug.ShouldStop(65536);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 20));
 BA.debugLineNum = 82;BA.debugLine="mande_d=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(131072);
morakhasi_activity._mande_d = BA.numberCast(int.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 84;BA.debugLine="dbCode.res.Position=21 ''--------hour------";
Debug.ShouldStop(524288);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 21));
 BA.debugLineNum = 85;BA.debugLine="mande_h=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(1048576);
morakhasi_activity._mande_h = BA.numberCast(int.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 87;BA.debugLine="dbCode.res.Position=22 ''--------min------";
Debug.ShouldStop(4194304);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 22));
 BA.debugLineNum = 88;BA.debugLine="mande_m=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(8388608);
morakhasi_activity._mande_m = BA.numberCast(int.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 91;BA.debugLine="dbCode.res.Position=23";
Debug.ShouldStop(67108864);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 23));
 BA.debugLineNum = 92;BA.debugLine="morkasiDarMah_d=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(134217728);
morakhasi_activity._morkasidarmah_d = BA.numberCast(int.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 93;BA.debugLine="dbCode.res.Position=24";
Debug.ShouldStop(268435456);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 24));
 BA.debugLineNum = 94;BA.debugLine="morkasiDarMah_h=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(536870912);
morakhasi_activity._morkasidarmah_h = BA.numberCast(int.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 95;BA.debugLine="dbCode.res.Position=25";
Debug.ShouldStop(1073741824);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 25));
 BA.debugLineNum = 96;BA.debugLine="morkasiDarMah_m=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(-2147483648);
morakhasi_activity._morkasidarmah_m = BA.numberCast(int.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 104;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(128);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 110;BA.debugLine="lbl_mande_show.Text=modify_str_showTime(mande_d,m";
Debug.ShouldStop(8192);
morakhasi_activity.mostCurrent._lbl_mande_show.runMethod(true,"setText",BA.ObjectToCharSequence(_modify_str_showtime(morakhasi_activity._mande_d,morakhasi_activity._mande_h,morakhasi_activity._mande_m)));
 BA.debugLineNum = 111;BA.debugLine="lbl_estehgag_darMah.Text=modify_str_showTime(mork";
Debug.ShouldStop(16384);
morakhasi_activity.mostCurrent._lbl_estehgag_darmah.runMethod(true,"setText",BA.ObjectToCharSequence(_modify_str_showtime(morakhasi_activity._morkasidarmah_d,morakhasi_activity._morkasidarmah_h,morakhasi_activity._morkasidarmah_m)));
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
 //BA.debugLineNum = 17;BA.debugLine="Private ScrollView1 As ScrollView";
morakhasi_activity.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private pan_all_morakhasi As Panel";
morakhasi_activity.mostCurrent._pan_all_morakhasi = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim mande_d As Int";
morakhasi_activity._mande_d = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 22;BA.debugLine="Dim mande_h As Int";
morakhasi_activity._mande_h = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 23;BA.debugLine="Dim mande_m As Int";
morakhasi_activity._mande_m = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 25;BA.debugLine="Dim morkasiDarMah_d As Int";
morakhasi_activity._morkasidarmah_d = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 26;BA.debugLine="Dim morkasiDarMah_h As Int";
morakhasi_activity._morkasidarmah_h = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 27;BA.debugLine="Dim morkasiDarMah_m As Int";
morakhasi_activity._morkasidarmah_m = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 32;BA.debugLine="Dim morakhasi_estefade_esteh As Int=0  ''' min";
morakhasi_activity._morakhasi_estefade_esteh = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 34;BA.debugLine="Private lbl_mande_show As Label";
morakhasi_activity.mostCurrent._lbl_mande_show = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private et_mande_d As EditText";
morakhasi_activity.mostCurrent._et_mande_d = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private et_mande_h As EditText";
morakhasi_activity.mostCurrent._et_mande_h = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private et_mande_m As EditText";
morakhasi_activity.mostCurrent._et_mande_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private lbl_mande_ta_emroz As Label";
morakhasi_activity.mostCurrent._lbl_mande_ta_emroz = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private lbl_morakhasi_BiHogog As Label";
morakhasi_activity.mostCurrent._lbl_morakhasi_bihogog = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private lbl_morakhasi_baHogog As Label";
morakhasi_activity.mostCurrent._lbl_morakhasi_bahogog = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private lbl_morakhasi_estelaj As Label";
morakhasi_activity.mostCurrent._lbl_morakhasi_estelaj = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private lbl_morakhasi_estehgag As Label";
morakhasi_activity.mostCurrent._lbl_morakhasi_estehgag = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private lbl_mande_ta_inEndMah As Label";
morakhasi_activity.mostCurrent._lbl_mande_ta_inendmah = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private lbl_mah As Label";
morakhasi_activity.mostCurrent._lbl_mah = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private lbl_estehgag_darMah As Label";
morakhasi_activity.mostCurrent._lbl_estehgag_darmah = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private lbl_box_edit As Label";
morakhasi_activity.mostCurrent._lbl_box_edit = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Dim index_box_edit As Int";
morakhasi_activity._index_box_edit = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 53;BA.debugLine="Private chk_manfi As CheckBox";
morakhasi_activity.mostCurrent._chk_manfi = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private pan_hed_mandeMorakh As Panel";
morakhasi_activity.mostCurrent._pan_hed_mandemorakh = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private lbl_help_mandeh As Label";
morakhasi_activity.mostCurrent._lbl_help_mandeh = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,147);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","lbl_back_click");}
 BA.debugLineNum = 147;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 149;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1048576);
morakhasi_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 150;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_edit_estehgag_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_edit_estehgag_Click (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,383);
if (RapidSub.canDelegate("lbl_edit_estehgag_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","lbl_edit_estehgag_click");}
 BA.debugLineNum = 383;BA.debugLine="Private Sub lbl_edit_estehgag_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 384;BA.debugLine="et_mande_d.Text=morkasiDarMah_d";
Debug.ShouldStop(-2147483648);
morakhasi_activity.mostCurrent._et_mande_d.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(morakhasi_activity._morkasidarmah_d));
 BA.debugLineNum = 385;BA.debugLine="et_mande_h.Text=morkasiDarMah_h";
Debug.ShouldStop(1);
morakhasi_activity.mostCurrent._et_mande_h.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(morakhasi_activity._morkasidarmah_h));
 BA.debugLineNum = 386;BA.debugLine="et_mande_m.Text=morkasiDarMah_m";
Debug.ShouldStop(2);
morakhasi_activity.mostCurrent._et_mande_m.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(morakhasi_activity._morkasidarmah_m));
 BA.debugLineNum = 388;BA.debugLine="index_box_edit=2";
Debug.ShouldStop(8);
morakhasi_activity._index_box_edit = BA.numberCast(int.class, 2);
 BA.debugLineNum = 389;BA.debugLine="lbl_box_edit.Text=\"تنظیم میزان مرخصی در ماه\"";
Debug.ShouldStop(16);
morakhasi_activity.mostCurrent._lbl_box_edit.runMethod(true,"setText",BA.ObjectToCharSequence("تنظیم میزان مرخصی در ماه"));
 BA.debugLineNum = 390;BA.debugLine="chk_manfi.Visible=False";
Debug.ShouldStop(32);
morakhasi_activity.mostCurrent._chk_manfi.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 391;BA.debugLine="lbl_help_mandeh.Visible=True";
Debug.ShouldStop(64);
morakhasi_activity.mostCurrent._lbl_help_mandeh.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 393;BA.debugLine="pan_all_morakhasi.Visible=True";
Debug.ShouldStop(256);
morakhasi_activity.mostCurrent._pan_all_morakhasi.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 395;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_edit_mande_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_edit_mande_Click (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,398);
if (RapidSub.canDelegate("lbl_edit_mande_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","lbl_edit_mande_click");}
 BA.debugLineNum = 398;BA.debugLine="Private Sub lbl_edit_mande_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 399;BA.debugLine="et_mande_d.Text=mande_d";
Debug.ShouldStop(16384);
morakhasi_activity.mostCurrent._et_mande_d.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(morakhasi_activity._mande_d));
 BA.debugLineNum = 400;BA.debugLine="et_mande_h.Text=mande_h";
Debug.ShouldStop(32768);
morakhasi_activity.mostCurrent._et_mande_h.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(morakhasi_activity._mande_h));
 BA.debugLineNum = 401;BA.debugLine="et_mande_m.Text=mande_m";
Debug.ShouldStop(65536);
morakhasi_activity.mostCurrent._et_mande_m.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(morakhasi_activity._mande_m));
 BA.debugLineNum = 403;BA.debugLine="index_box_edit=1";
Debug.ShouldStop(262144);
morakhasi_activity._index_box_edit = BA.numberCast(int.class, 1);
 BA.debugLineNum = 404;BA.debugLine="lbl_box_edit.Text=\"تنظیم مانده مرخصی\"";
Debug.ShouldStop(524288);
morakhasi_activity.mostCurrent._lbl_box_edit.runMethod(true,"setText",BA.ObjectToCharSequence("تنظیم مانده مرخصی"));
 BA.debugLineNum = 405;BA.debugLine="chk_manfi.Visible=False";
Debug.ShouldStop(1048576);
morakhasi_activity.mostCurrent._chk_manfi.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 406;BA.debugLine="lbl_help_mandeh.Visible=False";
Debug.ShouldStop(2097152);
morakhasi_activity.mostCurrent._lbl_help_mandeh.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 407;BA.debugLine="pan_all_morakhasi.Visible=True";
Debug.ShouldStop(4194304);
morakhasi_activity.mostCurrent._pan_all_morakhasi.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 408;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_help_mandeh_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help_mandeh_Click (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,410);
if (RapidSub.canDelegate("lbl_help_mandeh_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","lbl_help_mandeh_click");}
 BA.debugLineNum = 410;BA.debugLine="Private Sub lbl_help_mandeh_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 411;BA.debugLine="If(index_box_edit=2)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",morakhasi_activity._index_box_edit,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 412;BA.debugLine="myfunc.help_man(\"راهنما\",\"در قانون کار مرخصی است";
Debug.ShouldStop(134217728);
morakhasi_activity.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("راهنما")),(Object)(RemoteObject.createImmutable("در قانون کار مرخصی استحقاقی در ماه 2 روز و 4 ساعت برای مشاغل عادی و 3 روز برای مشاغل سخت میباشد")));
 };
 BA.debugLineNum = 414;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_run_mohasebe_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_run_mohasebe_Click (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,164);
if (RapidSub.canDelegate("lbl_run_mohasebe_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","lbl_run_mohasebe_click");}
RemoteObject _mor_dar_roz = RemoteObject.createImmutable(0);
RemoteObject _mande_ta_emroz = RemoteObject.createImmutable(0);
RemoteObject _mande_ta_endmah = RemoteObject.createImmutable(0);
 BA.debugLineNum = 164;BA.debugLine="Private Sub lbl_run_mohasebe_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 165;BA.debugLine="Dim mor_dar_roz As Double=0  '' ============= min";
Debug.ShouldStop(16);
_mor_dar_roz = BA.numberCast(double.class, 0);Debug.locals.put("mor_dar_roz", _mor_dar_roz);Debug.locals.put("mor_dar_roz", _mor_dar_roz);
 BA.debugLineNum = 166;BA.debugLine="mor_dar_roz=((morkasiDarMah_d*Main.saat_kar_min)+";
Debug.ShouldStop(32);
_mor_dar_roz = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {morakhasi_activity._morkasidarmah_d,morakhasi_activity.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {morakhasi_activity._morkasidarmah_h,RemoteObject.createImmutable(60)}, "*",0, 1)),morakhasi_activity._morkasidarmah_m}, "++",2, 1)),RemoteObject.createImmutable(30)}, "/",0, 0);Debug.locals.put("mor_dar_roz", _mor_dar_roz);
 BA.debugLineNum = 169;BA.debugLine="lbl_morakhasi_estehgag.Text=all_morakhasiha_mah(M";
Debug.ShouldStop(256);
morakhasi_activity.mostCurrent._lbl_morakhasi_estehgag.runMethod(true,"setText",BA.ObjectToCharSequence(_all_morakhasiha_mah(morakhasi_activity.mostCurrent._main._year_num /*RemoteObject*/ ,morakhasi_activity.mostCurrent._main._moon_num /*RemoteObject*/ ,BA.numberCast(int.class, 0))));
 BA.debugLineNum = 170;BA.debugLine="lbl_morakhasi_estelaj.Text=all_morakhasiha_mah(Ma";
Debug.ShouldStop(512);
morakhasi_activity.mostCurrent._lbl_morakhasi_estelaj.runMethod(true,"setText",BA.ObjectToCharSequence(_all_morakhasiha_mah(morakhasi_activity.mostCurrent._main._year_num /*RemoteObject*/ ,morakhasi_activity.mostCurrent._main._moon_num /*RemoteObject*/ ,BA.numberCast(int.class, 1))));
 BA.debugLineNum = 171;BA.debugLine="lbl_morakhasi_baHogog.Text=all_morakhasiha_mah(Ma";
Debug.ShouldStop(1024);
morakhasi_activity.mostCurrent._lbl_morakhasi_bahogog.runMethod(true,"setText",BA.ObjectToCharSequence(_all_morakhasiha_mah(morakhasi_activity.mostCurrent._main._year_num /*RemoteObject*/ ,morakhasi_activity.mostCurrent._main._moon_num /*RemoteObject*/ ,BA.numberCast(int.class, 2))));
 BA.debugLineNum = 172;BA.debugLine="lbl_morakhasi_BiHogog.Text=all_morakhasiha_mah(Ma";
Debug.ShouldStop(2048);
morakhasi_activity.mostCurrent._lbl_morakhasi_bihogog.runMethod(true,"setText",BA.ObjectToCharSequence(_all_morakhasiha_mah(morakhasi_activity.mostCurrent._main._year_num /*RemoteObject*/ ,morakhasi_activity.mostCurrent._main._moon_num /*RemoteObject*/ ,BA.numberCast(int.class, 3))));
 BA.debugLineNum = 178;BA.debugLine="Dim mande_ta_emroz As Int   ''---------- min";
Debug.ShouldStop(131072);
_mande_ta_emroz = RemoteObject.createImmutable(0);Debug.locals.put("mande_ta_emroz", _mande_ta_emroz);
 BA.debugLineNum = 179;BA.debugLine="Dim mande_ta_endMah As Int   ''---------- min";
Debug.ShouldStop(262144);
_mande_ta_endmah = RemoteObject.createImmutable(0);Debug.locals.put("mande_ta_endMah", _mande_ta_endmah);
 BA.debugLineNum = 181;BA.debugLine="mande_ta_endMah=((mande_d*Main.saat_kar_min)+(man";
Debug.ShouldStop(1048576);
_mande_ta_endmah = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {morakhasi_activity._mande_d,morakhasi_activity.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {morakhasi_activity._mande_h,RemoteObject.createImmutable(60)}, "*",0, 1)),morakhasi_activity._mande_m}, "++",2, 1)),(RemoteObject.solve(new RemoteObject[] {_mor_dar_roz,RemoteObject.createImmutable(30)}, "*",0, 0)),morakhasi_activity._morakhasi_estefade_esteh}, "+-",2, 0));Debug.locals.put("mande_ta_endMah", _mande_ta_endmah);
 BA.debugLineNum = 182;BA.debugLine="mande_ta_emroz=((mande_d*Main.saat_kar_min)+(mand";
Debug.ShouldStop(2097152);
_mande_ta_emroz = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {morakhasi_activity._mande_d,morakhasi_activity.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {morakhasi_activity._mande_h,RemoteObject.createImmutable(60)}, "*",0, 1)),morakhasi_activity._mande_m}, "++",2, 1)),(RemoteObject.solve(new RemoteObject[] {_mor_dar_roz,morakhasi_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianDay")}, "*",0, 0)),morakhasi_activity._morakhasi_estefade_esteh}, "+-",2, 0));Debug.locals.put("mande_ta_emroz", _mande_ta_emroz);
 BA.debugLineNum = 185;BA.debugLine="Log(morakhasi_estefade_esteh)";
Debug.ShouldStop(16777216);
morakhasi_activity.mostCurrent.__c.runVoidMethod ("LogImpl","727131925",BA.NumberToString(morakhasi_activity._morakhasi_estefade_esteh),0);
 BA.debugLineNum = 190;BA.debugLine="lbl_mande_ta_inEndMah.Text=min_to_str(mande_ta_en";
Debug.ShouldStop(536870912);
morakhasi_activity.mostCurrent._lbl_mande_ta_inendmah.runMethod(true,"setText",BA.ObjectToCharSequence(_min_to_str(_mande_ta_endmah)));
 BA.debugLineNum = 192;BA.debugLine="lbl_mande_ta_emroz.Text=min_to_str(mande_ta_emroz";
Debug.ShouldStop(-2147483648);
morakhasi_activity.mostCurrent._lbl_mande_ta_emroz.runMethod(true,"setText",BA.ObjectToCharSequence(_min_to_str(_mande_ta_emroz)));
 BA.debugLineNum = 198;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_mande_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_mande_Click (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,336);
if (RapidSub.canDelegate("lbl_save_mande_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","lbl_save_mande_click");}
 BA.debugLineNum = 336;BA.debugLine="Private Sub lbl_save_mande_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 337;BA.debugLine="If(et_mande_d.Text=\"\")Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",morakhasi_activity.mostCurrent._et_mande_d.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 338;BA.debugLine="et_mande_d.Text=0";
Debug.ShouldStop(131072);
morakhasi_activity.mostCurrent._et_mande_d.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 340;BA.debugLine="If(et_mande_h.Text=\"\")Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",morakhasi_activity.mostCurrent._et_mande_h.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 341;BA.debugLine="et_mande_h.Text=0";
Debug.ShouldStop(1048576);
morakhasi_activity.mostCurrent._et_mande_h.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 343;BA.debugLine="If(et_mande_m.Text=\"\")Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",morakhasi_activity.mostCurrent._et_mande_m.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 344;BA.debugLine="et_mande_m.Text=0";
Debug.ShouldStop(8388608);
morakhasi_activity.mostCurrent._et_mande_m.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 352;BA.debugLine="If (et_mande_m.Text > 59)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, morakhasi_activity.mostCurrent._et_mande_m.runMethod(true,"getText")),BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 353;BA.debugLine="ToastMessageShow(\"دقیقه باید بین 0 تا 59 باشد\",F";
Debug.ShouldStop(1);
morakhasi_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("دقیقه باید بین 0 تا 59 باشد")),(Object)(morakhasi_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 354;BA.debugLine="Return";
Debug.ShouldStop(2);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 360;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(128);
morakhasi_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA);
 BA.debugLineNum = 362;BA.debugLine="If(index_box_edit=1)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",morakhasi_activity._index_box_edit,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 363;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
Debug.ShouldStop(1024);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tb_setting SET value ="),morakhasi_activity.mostCurrent._et_mande_d.runMethod(true,"getText"),RemoteObject.createImmutable(" WHERE name='morakhasi_mande_d'"))));
 BA.debugLineNum = 364;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
Debug.ShouldStop(2048);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tb_setting SET value ="),morakhasi_activity.mostCurrent._et_mande_h.runMethod(true,"getText"),RemoteObject.createImmutable(" WHERE name='morakhasi_mande_h'"))));
 BA.debugLineNum = 365;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
Debug.ShouldStop(4096);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tb_setting SET value ="),morakhasi_activity.mostCurrent._et_mande_m.runMethod(true,"getText"),RemoteObject.createImmutable(" WHERE name='morakhasi_mande_m'"))));
 }else 
{ BA.debugLineNum = 366;BA.debugLine="Else If (index_box_edit=2)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",morakhasi_activity._index_box_edit,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 367;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
Debug.ShouldStop(16384);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tb_setting SET value ="),morakhasi_activity.mostCurrent._et_mande_d.runMethod(true,"getText"),RemoteObject.createImmutable(" WHERE name='morakhasi_darMah_d'"))));
 BA.debugLineNum = 368;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
Debug.ShouldStop(32768);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tb_setting SET value ="),morakhasi_activity.mostCurrent._et_mande_h.runMethod(true,"getText"),RemoteObject.createImmutable(" WHERE name='morakhasi_darMah_h'"))));
 BA.debugLineNum = 369;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
Debug.ShouldStop(65536);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tb_setting SET value ="),morakhasi_activity.mostCurrent._et_mande_m.runMethod(true,"getText"),RemoteObject.createImmutable(" WHERE name='morakhasi_darMah_m'"))));
 }}
;
 BA.debugLineNum = 376;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(8388608);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 378;BA.debugLine="get_mande_db";
Debug.ShouldStop(33554432);
_get_mande_db();
 BA.debugLineNum = 380;BA.debugLine="pan_all_morakhasi_Click";
Debug.ShouldStop(134217728);
_pan_all_morakhasi_click();
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
public static RemoteObject  _min_to_str(RemoteObject _min1) throws Exception{
try {
		Debug.PushSubsStack("min_to_str (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,200);
if (RapidSub.canDelegate("min_to_str")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","min_to_str", _min1);}
RemoteObject _str_result = RemoteObject.createImmutable("");
RemoteObject _str_state = RemoteObject.createImmutable("");
RemoteObject _m_day = RemoteObject.createImmutable(0);
RemoteObject _m_hour = RemoteObject.createImmutable(0);
RemoteObject _m_min = RemoteObject.createImmutable(0);
RemoteObject _div1 = RemoteObject.createImmutable(0);
RemoteObject _min_new = RemoteObject.createImmutable(0);
Debug.locals.put("min1", _min1);
 BA.debugLineNum = 200;BA.debugLine="Sub min_to_str (min1 As Int ) As String";
Debug.ShouldStop(128);
 BA.debugLineNum = 201;BA.debugLine="Dim str_result As String";
Debug.ShouldStop(256);
_str_result = RemoteObject.createImmutable("");Debug.locals.put("str_result", _str_result);
 BA.debugLineNum = 202;BA.debugLine="Dim str_state As String=\"\"";
Debug.ShouldStop(512);
_str_state = BA.ObjectToString("");Debug.locals.put("str_state", _str_state);Debug.locals.put("str_state", _str_state);
 BA.debugLineNum = 206;BA.debugLine="Dim m_day As Int=0";
Debug.ShouldStop(8192);
_m_day = BA.numberCast(int.class, 0);Debug.locals.put("m_day", _m_day);Debug.locals.put("m_day", _m_day);
 BA.debugLineNum = 207;BA.debugLine="Dim m_hour As Int=0";
Debug.ShouldStop(16384);
_m_hour = BA.numberCast(int.class, 0);Debug.locals.put("m_hour", _m_hour);Debug.locals.put("m_hour", _m_hour);
 BA.debugLineNum = 208;BA.debugLine="Dim m_min As Int=min1";
Debug.ShouldStop(32768);
_m_min = _min1;Debug.locals.put("m_min", _m_min);Debug.locals.put("m_min", _m_min);
 BA.debugLineNum = 210;BA.debugLine="Dim div1 As Int=0  '' hour";
Debug.ShouldStop(131072);
_div1 = BA.numberCast(int.class, 0);Debug.locals.put("div1", _div1);Debug.locals.put("div1", _div1);
 BA.debugLineNum = 212;BA.debugLine="If(min1>0)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean(">",_min1,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 213;BA.debugLine="m_hour=	myfunc.Min_to_saatMinRoz(min1).Get(0)";
Debug.ShouldStop(1048576);
_m_hour = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_min1)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("m_hour", _m_hour);
 BA.debugLineNum = 214;BA.debugLine="m_min=myfunc.Min_to_saatMinRoz(min1).Get(1)";
Debug.ShouldStop(2097152);
_m_min = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_min1)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("m_min", _m_min);
 BA.debugLineNum = 215;BA.debugLine="m_day=myfunc.Min_to_saatMinRoz(min1).Get(2)";
Debug.ShouldStop(4194304);
_m_day = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_min1)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("m_day", _m_day);
 }else {
 BA.debugLineNum = 218;BA.debugLine="Dim min_new As Int = min1*(-1)";
Debug.ShouldStop(33554432);
_min_new = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable((-(double) (0 + 1)))}, "*",0, 0));Debug.locals.put("min_new", _min_new);Debug.locals.put("min_new", _min_new);
 BA.debugLineNum = 220;BA.debugLine="m_hour=	myfunc.Min_to_saatMinRoz(min_new).Get(0)";
Debug.ShouldStop(134217728);
_m_hour = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_min_new)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("m_hour", _m_hour);
 BA.debugLineNum = 221;BA.debugLine="m_min=myfunc.Min_to_saatMinRoz(min_new).Get(1)";
Debug.ShouldStop(268435456);
_m_min = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_min_new)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("m_min", _m_min);
 BA.debugLineNum = 222;BA.debugLine="m_day=myfunc.Min_to_saatMinRoz(min_new).Get(2)";
Debug.ShouldStop(536870912);
_m_day = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_min_new)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("m_day", _m_day);
 BA.debugLineNum = 224;BA.debugLine="str_state=\"-منفی-\"&CRLF";
Debug.ShouldStop(-2147483648);
_str_state = RemoteObject.concat(RemoteObject.createImmutable("-منفی-"),morakhasi_activity.mostCurrent.__c.getField(true,"CRLF"));Debug.locals.put("str_state", _str_state);
 };
 BA.debugLineNum = 265;BA.debugLine="str_result=str_state&modify_str_showTime(m_day,m_";
Debug.ShouldStop(256);
_str_result = RemoteObject.concat(_str_state,_modify_str_showtime(_m_day,_m_hour,_m_min));Debug.locals.put("str_result", _str_result);
 BA.debugLineNum = 267;BA.debugLine="Return str_result";
Debug.ShouldStop(1024);
if (true) return _str_result;
 BA.debugLineNum = 269;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _modify_str_showtime(RemoteObject _tim_d,RemoteObject _tim_h,RemoteObject _tim_m) throws Exception{
try {
		Debug.PushSubsStack("modify_str_showTime (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,115);
if (RapidSub.canDelegate("modify_str_showtime")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","modify_str_showtime", _tim_d, _tim_h, _tim_m);}
RemoteObject _str_modify1 = RemoteObject.createImmutable("");
Debug.locals.put("tim_d", _tim_d);
Debug.locals.put("tim_h", _tim_h);
Debug.locals.put("tim_m", _tim_m);
 BA.debugLineNum = 115;BA.debugLine="Sub modify_str_showTime (tim_d As Int, tim_h As In";
Debug.ShouldStop(262144);
 BA.debugLineNum = 116;BA.debugLine="Dim str_modify1 As String=\"\"";
Debug.ShouldStop(524288);
_str_modify1 = BA.ObjectToString("");Debug.locals.put("str_modify1", _str_modify1);Debug.locals.put("str_modify1", _str_modify1);
 BA.debugLineNum = 117;BA.debugLine="If(tim_d<>0)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("!",_tim_d,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 118;BA.debugLine="str_modify1=tim_d&\" روز \"";
Debug.ShouldStop(2097152);
_str_modify1 = RemoteObject.concat(_tim_d,RemoteObject.createImmutable(" روز "));Debug.locals.put("str_modify1", _str_modify1);
 };
 BA.debugLineNum = 120;BA.debugLine="If(tim_h<>0)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("!",_tim_h,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 121;BA.debugLine="str_modify1=str_modify1&tim_h&\" ساعت \"";
Debug.ShouldStop(16777216);
_str_modify1 = RemoteObject.concat(_str_modify1,_tim_h,RemoteObject.createImmutable(" ساعت "));Debug.locals.put("str_modify1", _str_modify1);
 };
 BA.debugLineNum = 123;BA.debugLine="If(tim_m<>0)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("!",_tim_m,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 124;BA.debugLine="str_modify1=str_modify1&tim_m&\" دقیقه \"";
Debug.ShouldStop(134217728);
_str_modify1 = RemoteObject.concat(_str_modify1,_tim_m,RemoteObject.createImmutable(" دقیقه "));Debug.locals.put("str_modify1", _str_modify1);
 };
 BA.debugLineNum = 127;BA.debugLine="If(str_modify1=\"\")Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",_str_modify1,RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 128;BA.debugLine="str_modify1=\"-\"";
Debug.ShouldStop(-2147483648);
_str_modify1 = BA.ObjectToString("-");Debug.locals.put("str_modify1", _str_modify1);
 };
 BA.debugLineNum = 131;BA.debugLine="Return str_modify1";
Debug.ShouldStop(4);
if (true) return _str_modify1;
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
public static RemoteObject  _pan_all_morakhasi_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_morakhasi_Click (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,328);
if (RapidSub.canDelegate("pan_all_morakhasi_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","pan_all_morakhasi_click");}
 BA.debugLineNum = 328;BA.debugLine="Private Sub pan_all_morakhasi_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 329;BA.debugLine="pan_all_morakhasi.Visible=False";
Debug.ShouldStop(256);
morakhasi_activity.mostCurrent._pan_all_morakhasi.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _panel4_click() throws Exception{
try {
		Debug.PushSubsStack("Panel4_Click (morakhasi_activity) ","morakhasi_activity",17,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,332);
if (RapidSub.canDelegate("panel4_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","panel4_click");}
 BA.debugLineNum = 332;BA.debugLine="Private Sub Panel4_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 334;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
}