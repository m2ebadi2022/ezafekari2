package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class morakhasi_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,75);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 75;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 77;BA.debugLine="Activity.LoadLayout(\"morakhasi_layout\")";
Debug.ShouldStop(4096);
morakhasi_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("morakhasi_layout")),morakhasi_activity.mostCurrent.activityBA);
 BA.debugLineNum = 79;BA.debugLine="ScrollView1.Panel.LoadLayout(\"morakhasi_item2\")";
Debug.ShouldStop(16384);
morakhasi_activity.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("morakhasi_item2")),morakhasi_activity.mostCurrent.activityBA);
 BA.debugLineNum = 80;BA.debugLine="get_mande_db";
Debug.ShouldStop(32768);
_get_mande_db();
 BA.debugLineNum = 83;BA.debugLine="moon_dataPik.Initialize";
Debug.ShouldStop(262144);
morakhasi_activity.mostCurrent._moon_datapik.runVoidMethod ("Initialize");
 BA.debugLineNum = 84;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
Debug.ShouldStop(524288);
morakhasi_activity.mostCurrent._moon_datapik.runVoidMethod ("AddAll",(Object)(morakhasi_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 86;BA.debugLine="If(File.Exists(File.DirInternal,\"date1_morakhasi.";
Debug.ShouldStop(2097152);
if ((morakhasi_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(morakhasi_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("date1_morakhasi.txt")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 87;BA.debugLine="lbl_date1.Text=File.ReadString(File.DirInternal,";
Debug.ShouldStop(4194304);
morakhasi_activity.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(morakhasi_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(morakhasi_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("date1_morakhasi.txt")))));
 };
 BA.debugLineNum = 91;BA.debugLine="pan_hed_mandeMorakh.Color=Main.color4";
Debug.ShouldStop(67108864);
morakhasi_activity.mostCurrent._pan_hed_mandemorakh.runVoidMethod ("setColor",morakhasi_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 92;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(134217728);
morakhasi_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._activity));
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
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,178);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 178;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(131072);
 BA.debugLineNum = 179;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, morakhasi_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 180;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(524288);
_lbl_back_click();
 BA.debugLineNum = 181;BA.debugLine="Return True";
Debug.ShouldStop(1048576);
if (true) return morakhasi_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 183;BA.debugLine="Return False";
Debug.ShouldStop(4194304);
if (true) return morakhasi_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 185;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Pause (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,167);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 167;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(64);
 BA.debugLineNum = 169;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("Activity_Resume (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,163);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","activity_resume");}
 BA.debugLineNum = 163;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4);
 BA.debugLineNum = 165;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_morakhasiha_bydate(RemoteObject _date1,RemoteObject _date2,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("all_morakhasiha_byDate (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,253);
if (RapidSub.canDelegate("all_morakhasiha_bydate")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","all_morakhasiha_bydate", _date1, _date2, _state);}
RemoteObject _str = RemoteObject.createImmutable("");
RemoteObject _v_day = RemoteObject.createImmutable(0);
RemoteObject _v_hour = RemoteObject.createImmutable(0);
RemoteObject _v_min = RemoteObject.createImmutable(0);
RemoteObject _div1 = RemoteObject.createImmutable(0);
RemoteObject _div2 = RemoteObject.createImmutable(0);
RemoteObject _all_min = RemoteObject.createImmutable(0);
Debug.locals.put("date1", _date1);
Debug.locals.put("date2", _date2);
Debug.locals.put("state", _state);
 BA.debugLineNum = 253;BA.debugLine="Sub all_morakhasiha_byDate(date1 As String , date2";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 255;BA.debugLine="Dim str As String";
Debug.ShouldStop(1073741824);
_str = RemoteObject.createImmutable("");Debug.locals.put("str", _str);
 BA.debugLineNum = 259;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(4);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 260;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(8);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 261;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(16);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 262;BA.debugLine="Dim div1 As Int=0";
Debug.ShouldStop(32);
_div1 = BA.numberCast(int.class, 0);Debug.locals.put("div1", _div1);Debug.locals.put("div1", _div1);
 BA.debugLineNum = 263;BA.debugLine="Dim div2 As Int=0";
Debug.ShouldStop(64);
_div2 = BA.numberCast(int.class, 0);Debug.locals.put("div2", _div2);Debug.locals.put("div2", _div2);
 BA.debugLineNum = 264;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(128);
morakhasi_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA);
 BA.debugLineNum = 265;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(256);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from  BETWEEN '"),_date1,RemoteObject.createImmutable("' AND '"),_date2,RemoteObject.createImmutable("' AND state="),_state))));
 BA.debugLineNum = 266;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(512);
while (morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 268;BA.debugLine="v_day=v_day+dbCode.res.GetString(\"end_tim_d\")";
Debug.ShouldStop(2048);
_v_day = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_day,BA.numberCast(double.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))))}, "+",1, 0));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 269;BA.debugLine="v_hour=v_hour+dbCode.res.GetString(\"end_tim_h\")";
Debug.ShouldStop(4096);
_v_hour = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_hour,BA.numberCast(double.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))))}, "+",1, 0));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 270;BA.debugLine="v_min=v_min+dbCode.res.GetString(\"end_tim_m\")";
Debug.ShouldStop(8192);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 274;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(131072);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 275;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(262144);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 278;BA.debugLine="Dim all_min As Int";
Debug.ShouldStop(2097152);
_all_min = RemoteObject.createImmutable(0);Debug.locals.put("all_min", _all_min);
 BA.debugLineNum = 279;BA.debugLine="all_min=(v_day*Main.saat_kar_min)+(v_hour*60)+v_m";
Debug.ShouldStop(4194304);
_all_min = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_v_day,morakhasi_activity.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_v_hour,RemoteObject.createImmutable(60)}, "*",0, 1)),_v_min}, "++",2, 1);Debug.locals.put("all_min", _all_min);
 BA.debugLineNum = 280;BA.debugLine="v_hour=	myfunc.Min_to_saatMinRoz(all_min).Get(0)";
Debug.ShouldStop(8388608);
_v_hour = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_all_min)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 281;BA.debugLine="v_min=	myfunc.Min_to_saatMinRoz(all_min).Get(1)";
Debug.ShouldStop(16777216);
_v_min = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_all_min)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 282;BA.debugLine="v_day=	myfunc.Min_to_saatMinRoz(all_min).Get(2)";
Debug.ShouldStop(33554432);
_v_day = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_all_min)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 286;BA.debugLine="If(state=0)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",_state,BA.NumberToString(0)))) { 
 BA.debugLineNum = 287;BA.debugLine="morakhasi_estefade_esteh=all_min";
Debug.ShouldStop(1073741824);
morakhasi_activity._morakhasi_estefade_esteh = _all_min;
 };
 BA.debugLineNum = 291;BA.debugLine="str=modify_str_showTime(v_day,v_hour,v_min)";
Debug.ShouldStop(4);
_str = _modify_str_showtime(_v_day,_v_hour,_v_min);Debug.locals.put("str", _str);
 BA.debugLineNum = 292;BA.debugLine="Return str";
Debug.ShouldStop(8);
if (true) return _str;
 BA.debugLineNum = 294;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("get_mande_db (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,99);
if (RapidSub.canDelegate("get_mande_db")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","get_mande_db");}
 BA.debugLineNum = 99;BA.debugLine="Sub get_mande_db";
Debug.ShouldStop(4);
 BA.debugLineNum = 101;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(16);
morakhasi_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA);
 BA.debugLineNum = 102;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(32);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_setting"))));
 BA.debugLineNum = 104;BA.debugLine="dbCode.res.Position=20 ''--------day------";
Debug.ShouldStop(128);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 20));
 BA.debugLineNum = 105;BA.debugLine="mande_d=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(256);
morakhasi_activity._mande_d = BA.numberCast(int.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 107;BA.debugLine="dbCode.res.Position=21 ''--------hour------";
Debug.ShouldStop(1024);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 21));
 BA.debugLineNum = 108;BA.debugLine="mande_h=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(2048);
morakhasi_activity._mande_h = BA.numberCast(int.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 110;BA.debugLine="dbCode.res.Position=22 ''--------min------";
Debug.ShouldStop(8192);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 22));
 BA.debugLineNum = 111;BA.debugLine="mande_m=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(16384);
morakhasi_activity._mande_m = BA.numberCast(int.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 114;BA.debugLine="dbCode.res.Position=23";
Debug.ShouldStop(131072);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 23));
 BA.debugLineNum = 115;BA.debugLine="morkasiDarMah_d=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(262144);
morakhasi_activity._morkasidarmah_d = BA.numberCast(int.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 116;BA.debugLine="dbCode.res.Position=24";
Debug.ShouldStop(524288);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 24));
 BA.debugLineNum = 117;BA.debugLine="morkasiDarMah_h=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(1048576);
morakhasi_activity._morkasidarmah_h = BA.numberCast(int.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 118;BA.debugLine="dbCode.res.Position=25";
Debug.ShouldStop(2097152);
morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 25));
 BA.debugLineNum = 119;BA.debugLine="morkasiDarMah_m=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(4194304);
morakhasi_activity._morkasidarmah_m = BA.numberCast(int.class, morakhasi_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 127;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(1073741824);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 133;BA.debugLine="lbl_mande_show.Text=modify_str_showTime(mande_d,m";
Debug.ShouldStop(16);
morakhasi_activity.mostCurrent._lbl_mande_show.runMethod(true,"setText",BA.ObjectToCharSequence(_modify_str_showtime(morakhasi_activity._mande_d,morakhasi_activity._mande_h,morakhasi_activity._mande_m)));
 BA.debugLineNum = 134;BA.debugLine="lbl_estehgag_darMah.Text=modify_str_showTime(mork";
Debug.ShouldStop(32);
morakhasi_activity.mostCurrent._lbl_estehgag_darmah.runMethod(true,"setText",BA.ObjectToCharSequence(_modify_str_showtime(morakhasi_activity._morkasidarmah_d,morakhasi_activity._morkasidarmah_h,morakhasi_activity._morkasidarmah_m)));
 BA.debugLineNum = 136;BA.debugLine="lbl_date2.Text=myfunc.fa2en(Main.persianDate.Pers";
Debug.ShouldStop(128);
morakhasi_activity.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 138;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
 //BA.debugLineNum = 31;BA.debugLine="Dim morakhasi_estefade_esteh As Int=0  ''' min";
morakhasi_activity._morakhasi_estefade_esteh = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 33;BA.debugLine="Private lbl_mande_show As Label";
morakhasi_activity.mostCurrent._lbl_mande_show = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private et_mande_d As EditText";
morakhasi_activity.mostCurrent._et_mande_d = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private et_mande_h As EditText";
morakhasi_activity.mostCurrent._et_mande_h = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private et_mande_m As EditText";
morakhasi_activity.mostCurrent._et_mande_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private lbl_mande_ta_emroz As Label";
morakhasi_activity.mostCurrent._lbl_mande_ta_emroz = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private lbl_morakhasi_BiHogog As Label";
morakhasi_activity.mostCurrent._lbl_morakhasi_bihogog = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private lbl_morakhasi_baHogog As Label";
morakhasi_activity.mostCurrent._lbl_morakhasi_bahogog = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private lbl_morakhasi_estelaj As Label";
morakhasi_activity.mostCurrent._lbl_morakhasi_estelaj = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private lbl_morakhasi_estehgag As Label";
morakhasi_activity.mostCurrent._lbl_morakhasi_estehgag = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private lbl_estehgag_darMah As Label";
morakhasi_activity.mostCurrent._lbl_estehgag_darmah = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private lbl_box_edit As Label";
morakhasi_activity.mostCurrent._lbl_box_edit = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Dim index_box_edit As Int";
morakhasi_activity._index_box_edit = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 51;BA.debugLine="Private chk_manfi As CheckBox";
morakhasi_activity.mostCurrent._chk_manfi = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private pan_hed_mandeMorakh As Panel";
morakhasi_activity.mostCurrent._pan_hed_mandemorakh = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private lbl_help_mandeh As Label";
morakhasi_activity.mostCurrent._lbl_help_mandeh = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private lbl_date1 As Label";
morakhasi_activity.mostCurrent._lbl_date1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private lbl_date2 As Label";
morakhasi_activity.mostCurrent._lbl_date2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private lbl_rozha As Label";
morakhasi_activity.mostCurrent._lbl_rozha = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private pik_day1 As Label";
morakhasi_activity.mostCurrent._pik_day1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private pik_moon1 As Label";
morakhasi_activity.mostCurrent._pik_moon1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private pik_year1 As Label";
morakhasi_activity.mostCurrent._pik_year1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Private pik_day1 As Label";
morakhasi_activity.mostCurrent._pik_day1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Private pik_moon1 As Label";
morakhasi_activity.mostCurrent._pik_moon1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 64;BA.debugLine="Private pik_year1 As Label";
morakhasi_activity.mostCurrent._pik_year1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 66;BA.debugLine="Dim num_dataPik As Int=0  '' for time picker";
morakhasi_activity._num_datapik = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 68;BA.debugLine="Dim moon_dataPik As List  '' for date picker";
morakhasi_activity.mostCurrent._moon_datapik = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 69;BA.debugLine="Dim index_datePik As Int";
morakhasi_activity._index_datepik = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 70;BA.debugLine="Private pan_all_set_date As Panel";
morakhasi_activity.mostCurrent._pan_all_set_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 72;BA.debugLine="Private lbl_all_estehgag As Label";
morakhasi_activity.mostCurrent._lbl_all_estehgag = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,172);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","lbl_back_click");}
 BA.debugLineNum = 172;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 174;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8192);
morakhasi_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _lbl_date1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_date1_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,396);
if (RapidSub.canDelegate("lbl_date1_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","lbl_date1_click");}
 BA.debugLineNum = 396;BA.debugLine="Private Sub lbl_date1_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 397;BA.debugLine="pan_all_set_date.Visible=True";
Debug.ShouldStop(4096);
morakhasi_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 398;BA.debugLine="index_datePik=1";
Debug.ShouldStop(8192);
morakhasi_activity._index_datepik = BA.numberCast(int.class, 1);
 BA.debugLineNum = 400;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date1.Text.SubStr";
Debug.ShouldStop(32768);
morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._lbl_date1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4)))))));
 BA.debugLineNum = 401;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date1.Text.SubStri";
Debug.ShouldStop(65536);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._lbl_date1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7)))))));
 BA.debugLineNum = 402;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(131072);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(morakhasi_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 403;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date1.Text.SubStri";
Debug.ShouldStop(262144);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._lbl_date1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 10)))))));
 BA.debugLineNum = 404;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("lbl_date2_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,386);
if (RapidSub.canDelegate("lbl_date2_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","lbl_date2_click");}
 BA.debugLineNum = 386;BA.debugLine="Private Sub lbl_date2_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 387;BA.debugLine="pan_all_set_date.Visible=True";
Debug.ShouldStop(4);
morakhasi_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 388;BA.debugLine="index_datePik=2";
Debug.ShouldStop(8);
morakhasi_activity._index_datepik = BA.numberCast(int.class, 2);
 BA.debugLineNum = 390;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date2.Text.SubStr";
Debug.ShouldStop(32);
morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._lbl_date2.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4)))))));
 BA.debugLineNum = 391;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date2.Text.SubStri";
Debug.ShouldStop(64);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._lbl_date2.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7)))))));
 BA.debugLineNum = 392;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(128);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(morakhasi_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 393;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date2.Text.SubStri";
Debug.ShouldStop(256);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._lbl_date2.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 10)))))));
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
public static RemoteObject  _lbl_edit_estehgag_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_edit_estehgag_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,353);
if (RapidSub.canDelegate("lbl_edit_estehgag_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","lbl_edit_estehgag_click");}
 BA.debugLineNum = 353;BA.debugLine="Private Sub lbl_edit_estehgag_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 354;BA.debugLine="et_mande_d.Text=morkasiDarMah_d";
Debug.ShouldStop(2);
morakhasi_activity.mostCurrent._et_mande_d.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(morakhasi_activity._morkasidarmah_d));
 BA.debugLineNum = 355;BA.debugLine="et_mande_h.Text=morkasiDarMah_h";
Debug.ShouldStop(4);
morakhasi_activity.mostCurrent._et_mande_h.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(morakhasi_activity._morkasidarmah_h));
 BA.debugLineNum = 356;BA.debugLine="et_mande_m.Text=morkasiDarMah_m";
Debug.ShouldStop(8);
morakhasi_activity.mostCurrent._et_mande_m.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(morakhasi_activity._morkasidarmah_m));
 BA.debugLineNum = 358;BA.debugLine="index_box_edit=2";
Debug.ShouldStop(32);
morakhasi_activity._index_box_edit = BA.numberCast(int.class, 2);
 BA.debugLineNum = 359;BA.debugLine="lbl_box_edit.Text=\"تنظیم میزان مرخصی در ماه\"";
Debug.ShouldStop(64);
morakhasi_activity.mostCurrent._lbl_box_edit.runMethod(true,"setText",BA.ObjectToCharSequence("تنظیم میزان مرخصی در ماه"));
 BA.debugLineNum = 360;BA.debugLine="chk_manfi.Visible=False";
Debug.ShouldStop(128);
morakhasi_activity.mostCurrent._chk_manfi.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 361;BA.debugLine="lbl_help_mandeh.Visible=True";
Debug.ShouldStop(256);
morakhasi_activity.mostCurrent._lbl_help_mandeh.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 363;BA.debugLine="pan_all_morakhasi.Visible=True";
Debug.ShouldStop(1024);
morakhasi_activity.mostCurrent._pan_all_morakhasi.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"True"));
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
public static RemoteObject  _lbl_edit_mande_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_edit_mande_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,368);
if (RapidSub.canDelegate("lbl_edit_mande_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","lbl_edit_mande_click");}
 BA.debugLineNum = 368;BA.debugLine="Private Sub lbl_edit_mande_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 369;BA.debugLine="et_mande_d.Text=mande_d";
Debug.ShouldStop(65536);
morakhasi_activity.mostCurrent._et_mande_d.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(morakhasi_activity._mande_d));
 BA.debugLineNum = 370;BA.debugLine="et_mande_h.Text=mande_h";
Debug.ShouldStop(131072);
morakhasi_activity.mostCurrent._et_mande_h.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(morakhasi_activity._mande_h));
 BA.debugLineNum = 371;BA.debugLine="et_mande_m.Text=mande_m";
Debug.ShouldStop(262144);
morakhasi_activity.mostCurrent._et_mande_m.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(morakhasi_activity._mande_m));
 BA.debugLineNum = 373;BA.debugLine="index_box_edit=1";
Debug.ShouldStop(1048576);
morakhasi_activity._index_box_edit = BA.numberCast(int.class, 1);
 BA.debugLineNum = 374;BA.debugLine="lbl_box_edit.Text=\"تنظیم مانده مرخصی\"";
Debug.ShouldStop(2097152);
morakhasi_activity.mostCurrent._lbl_box_edit.runMethod(true,"setText",BA.ObjectToCharSequence("تنظیم مانده مرخصی"));
 BA.debugLineNum = 375;BA.debugLine="chk_manfi.Visible=False";
Debug.ShouldStop(4194304);
morakhasi_activity.mostCurrent._chk_manfi.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 376;BA.debugLine="lbl_help_mandeh.Visible=False";
Debug.ShouldStop(8388608);
morakhasi_activity.mostCurrent._lbl_help_mandeh.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 377;BA.debugLine="pan_all_morakhasi.Visible=True";
Debug.ShouldStop(16777216);
morakhasi_activity.mostCurrent._pan_all_morakhasi.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 378;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("lbl_help_mandeh_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,380);
if (RapidSub.canDelegate("lbl_help_mandeh_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","lbl_help_mandeh_click");}
 BA.debugLineNum = 380;BA.debugLine="Private Sub lbl_help_mandeh_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 381;BA.debugLine="If(index_box_edit=2)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",morakhasi_activity._index_box_edit,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 382;BA.debugLine="myfunc.help_man(\"راهنما\",\"در قانون کار مرخصی است";
Debug.ShouldStop(536870912);
morakhasi_activity.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("راهنما")),(Object)(RemoteObject.createImmutable("در قانون کار مرخصی استحقاقی در ماه 2 روز و 4 ساعت برای مشاغل عادی و 3 روز برای مشاغل سخت میباشد")));
 };
 BA.debugLineNum = 384;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("lbl_run_mohasebe_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,189);
if (RapidSub.canDelegate("lbl_run_mohasebe_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","lbl_run_mohasebe_click");}
RemoteObject _rozha = RemoteObject.createImmutable(0);
RemoteObject _zarib = RemoteObject.createImmutable(0);
RemoteObject _all_mor1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 189;BA.debugLine="Private Sub lbl_run_mohasebe_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 191;BA.debugLine="lbl_morakhasi_estehgag.Text=all_morakhasiha_byDat";
Debug.ShouldStop(1073741824);
morakhasi_activity.mostCurrent._lbl_morakhasi_estehgag.runMethod(true,"setText",BA.ObjectToCharSequence(_all_morakhasiha_bydate(morakhasi_activity.mostCurrent._lbl_date1.runMethod(true,"getText"),morakhasi_activity.mostCurrent._lbl_date2.runMethod(true,"getText"),BA.NumberToString(0))));
 BA.debugLineNum = 192;BA.debugLine="lbl_morakhasi_estelaj.Text=all_morakhasiha_byDate";
Debug.ShouldStop(-2147483648);
morakhasi_activity.mostCurrent._lbl_morakhasi_estelaj.runMethod(true,"setText",BA.ObjectToCharSequence(_all_morakhasiha_bydate(morakhasi_activity.mostCurrent._lbl_date1.runMethod(true,"getText"),morakhasi_activity.mostCurrent._lbl_date2.runMethod(true,"getText"),BA.NumberToString(1))));
 BA.debugLineNum = 193;BA.debugLine="lbl_morakhasi_baHogog.Text=all_morakhasiha_byDate";
Debug.ShouldStop(1);
morakhasi_activity.mostCurrent._lbl_morakhasi_bahogog.runMethod(true,"setText",BA.ObjectToCharSequence(_all_morakhasiha_bydate(morakhasi_activity.mostCurrent._lbl_date1.runMethod(true,"getText"),morakhasi_activity.mostCurrent._lbl_date2.runMethod(true,"getText"),BA.NumberToString(2))));
 BA.debugLineNum = 194;BA.debugLine="lbl_morakhasi_BiHogog.Text=all_morakhasiha_byDate";
Debug.ShouldStop(2);
morakhasi_activity.mostCurrent._lbl_morakhasi_bihogog.runMethod(true,"setText",BA.ObjectToCharSequence(_all_morakhasiha_bydate(morakhasi_activity.mostCurrent._lbl_date1.runMethod(true,"getText"),morakhasi_activity.mostCurrent._lbl_date2.runMethod(true,"getText"),BA.NumberToString(3))));
 BA.debugLineNum = 197;BA.debugLine="Dim rozha As Int";
Debug.ShouldStop(16);
_rozha = RemoteObject.createImmutable(0);Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 198;BA.debugLine="rozha=myfunc.time_mohasebe(lbl_date1.Text,lbl_dat";
Debug.ShouldStop(32);
_rozha = morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_time_mohasebe" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._lbl_date1.runMethod(true,"getText")),(Object)(morakhasi_activity.mostCurrent._lbl_date2.runMethod(true,"getText")));Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 199;BA.debugLine="lbl_rozha.Text=rozha";
Debug.ShouldStop(64);
morakhasi_activity.mostCurrent._lbl_rozha.runMethod(true,"setText",BA.ObjectToCharSequence(_rozha));
 BA.debugLineNum = 202;BA.debugLine="Dim zarib As Double=(((morkasiDarMah_d*(Main.saat";
Debug.ShouldStop(512);
_zarib = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {morakhasi_activity._morkasidarmah_d,(RemoteObject.solve(new RemoteObject[] {morakhasi_activity.mostCurrent._main._saat_kar_min /*RemoteObject*/ ,RemoteObject.createImmutable(60)}, "/",0, 0))}, "*",0, 0)),morakhasi_activity._morkasidarmah_h}, "+",1, 0)),RemoteObject.createImmutable(60)}, "*",0, 0)),RemoteObject.createImmutable(30.5)}, "/",0, 0);Debug.locals.put("zarib", _zarib);Debug.locals.put("zarib", _zarib);
 BA.debugLineNum = 205;BA.debugLine="Dim all_mor1 As Int= (Round(zarib*rozha))+1+(((ma";
Debug.ShouldStop(4096);
_all_mor1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(morakhasi_activity.mostCurrent.__c.runMethod(true,"Round",(Object)(RemoteObject.solve(new RemoteObject[] {_zarib,_rozha}, "*",0, 0)))),RemoteObject.createImmutable(1),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {morakhasi_activity._mande_d,(RemoteObject.solve(new RemoteObject[] {morakhasi_activity.mostCurrent._main._saat_kar_min /*RemoteObject*/ ,RemoteObject.createImmutable(60)}, "/",0, 0))}, "*",0, 0)),morakhasi_activity._mande_h}, "+",1, 0)),RemoteObject.createImmutable(60)}, "*",0, 0))}, "++",2, 0));Debug.locals.put("all_mor1", _all_mor1);Debug.locals.put("all_mor1", _all_mor1);
 BA.debugLineNum = 212;BA.debugLine="lbl_all_estehgag.Text= myfunc.Min_to_saatMinRoz(a";
Debug.ShouldStop(524288);
morakhasi_activity.mostCurrent._lbl_all_estehgag.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_all_mor1)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" روز و "),morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_all_mor1)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" ساعت و "),morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_all_mor1)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 214;BA.debugLine="lbl_mande_ta_emroz.Text=myfunc.Min_to_saatMinRoz(";
Debug.ShouldStop(2097152);
morakhasi_activity.mostCurrent._lbl_mande_ta_emroz.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {_all_mor1,(morakhasi_activity._morakhasi_estefade_esteh)}, "-",1, 1))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" روز و "),morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {_all_mor1,(morakhasi_activity._morakhasi_estefade_esteh)}, "-",1, 1))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" ساعت و  "),morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {_all_mor1,(morakhasi_activity._morakhasi_estefade_esteh)}, "-",1, 1))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 216;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("lbl_save_mande_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,306);
if (RapidSub.canDelegate("lbl_save_mande_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","lbl_save_mande_click");}
 BA.debugLineNum = 306;BA.debugLine="Private Sub lbl_save_mande_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 307;BA.debugLine="If(et_mande_d.Text=\"\")Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",morakhasi_activity.mostCurrent._et_mande_d.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 308;BA.debugLine="et_mande_d.Text=0";
Debug.ShouldStop(524288);
morakhasi_activity.mostCurrent._et_mande_d.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 310;BA.debugLine="If(et_mande_h.Text=\"\")Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",morakhasi_activity.mostCurrent._et_mande_h.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 311;BA.debugLine="et_mande_h.Text=0";
Debug.ShouldStop(4194304);
morakhasi_activity.mostCurrent._et_mande_h.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 313;BA.debugLine="If(et_mande_m.Text=\"\")Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",morakhasi_activity.mostCurrent._et_mande_m.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 314;BA.debugLine="et_mande_m.Text=0";
Debug.ShouldStop(33554432);
morakhasi_activity.mostCurrent._et_mande_m.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 322;BA.debugLine="If (et_mande_m.Text > 59)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, morakhasi_activity.mostCurrent._et_mande_m.runMethod(true,"getText")),BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 323;BA.debugLine="ToastMessageShow(\"دقیقه باید بین 0 تا 59 باشد\",F";
Debug.ShouldStop(4);
morakhasi_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("دقیقه باید بین 0 تا 59 باشد")),(Object)(morakhasi_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 324;BA.debugLine="Return";
Debug.ShouldStop(8);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 330;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(512);
morakhasi_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA);
 BA.debugLineNum = 332;BA.debugLine="If(index_box_edit=1)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",morakhasi_activity._index_box_edit,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 333;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
Debug.ShouldStop(4096);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tb_setting SET value ="),morakhasi_activity.mostCurrent._et_mande_d.runMethod(true,"getText"),RemoteObject.createImmutable(" WHERE name='morakhasi_mande_d'"))));
 BA.debugLineNum = 334;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
Debug.ShouldStop(8192);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tb_setting SET value ="),morakhasi_activity.mostCurrent._et_mande_h.runMethod(true,"getText"),RemoteObject.createImmutable(" WHERE name='morakhasi_mande_h'"))));
 BA.debugLineNum = 335;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
Debug.ShouldStop(16384);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tb_setting SET value ="),morakhasi_activity.mostCurrent._et_mande_m.runMethod(true,"getText"),RemoteObject.createImmutable(" WHERE name='morakhasi_mande_m'"))));
 }else 
{ BA.debugLineNum = 336;BA.debugLine="Else If (index_box_edit=2)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",morakhasi_activity._index_box_edit,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 337;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
Debug.ShouldStop(65536);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tb_setting SET value ="),morakhasi_activity.mostCurrent._et_mande_d.runMethod(true,"getText"),RemoteObject.createImmutable(" WHERE name='morakhasi_darMah_d'"))));
 BA.debugLineNum = 338;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
Debug.ShouldStop(131072);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tb_setting SET value ="),morakhasi_activity.mostCurrent._et_mande_h.runMethod(true,"getText"),RemoteObject.createImmutable(" WHERE name='morakhasi_darMah_h'"))));
 BA.debugLineNum = 339;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tb_setting SET v";
Debug.ShouldStop(262144);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tb_setting SET value ="),morakhasi_activity.mostCurrent._et_mande_m.runMethod(true,"getText"),RemoteObject.createImmutable(" WHERE name='morakhasi_darMah_m'"))));
 }}
;
 BA.debugLineNum = 346;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(33554432);
morakhasi_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 348;BA.debugLine="get_mande_db";
Debug.ShouldStop(134217728);
_get_mande_db();
 BA.debugLineNum = 350;BA.debugLine="pan_all_morakhasi_Click";
Debug.ShouldStop(536870912);
_pan_all_morakhasi_click();
 BA.debugLineNum = 351;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("lbl_save_picker_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,408);
if (RapidSub.canDelegate("lbl_save_picker_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","lbl_save_picker_click");}
 BA.debugLineNum = 408;BA.debugLine="Private Sub lbl_save_picker_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 409;BA.debugLine="If(index_datePik=1) Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",morakhasi_activity._index_datepik,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 410;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&myfunc.convert";
Debug.ShouldStop(33554432);
morakhasi_activity.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))),RemoteObject.createImmutable("/"),morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")))))));
 BA.debugLineNum = 411;BA.debugLine="File.WriteString(File.DirInternal,\"date1_morakha";
Debug.ShouldStop(67108864);
morakhasi_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(morakhasi_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("date1_morakhasi.txt")),(Object)(morakhasi_activity.mostCurrent._lbl_date1.runMethod(true,"getText")));
 }else 
{ BA.debugLineNum = 413;BA.debugLine="Else If(index_datePik=2) Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",morakhasi_activity._index_datepik,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 414;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&myfunc.convert";
Debug.ShouldStop(536870912);
morakhasi_activity.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))),RemoteObject.createImmutable("/"),morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")))))));
 }}
;
 BA.debugLineNum = 416;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(-2147483648);
morakhasi_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 417;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _min_to_str1(RemoteObject _min1) throws Exception{
try {
		Debug.PushSubsStack("min_to_str1 (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,219);
if (RapidSub.canDelegate("min_to_str1")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","min_to_str1", _min1);}
RemoteObject _str_result = RemoteObject.createImmutable("");
RemoteObject _str_state = RemoteObject.createImmutable("");
RemoteObject _m_day = RemoteObject.createImmutable(0);
RemoteObject _m_hour = RemoteObject.createImmutable(0);
RemoteObject _m_min = RemoteObject.createImmutable(0);
RemoteObject _div1 = RemoteObject.createImmutable(0);
RemoteObject _min_new = RemoteObject.createImmutable(0);
Debug.locals.put("min1", _min1);
 BA.debugLineNum = 219;BA.debugLine="Sub min_to_str1 (min1 As Int ) As String";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 220;BA.debugLine="Dim str_result As String";
Debug.ShouldStop(134217728);
_str_result = RemoteObject.createImmutable("");Debug.locals.put("str_result", _str_result);
 BA.debugLineNum = 221;BA.debugLine="Dim str_state As String=\"\"";
Debug.ShouldStop(268435456);
_str_state = BA.ObjectToString("");Debug.locals.put("str_state", _str_state);Debug.locals.put("str_state", _str_state);
 BA.debugLineNum = 225;BA.debugLine="Dim m_day As Int=0";
Debug.ShouldStop(1);
_m_day = BA.numberCast(int.class, 0);Debug.locals.put("m_day", _m_day);Debug.locals.put("m_day", _m_day);
 BA.debugLineNum = 226;BA.debugLine="Dim m_hour As Int=0";
Debug.ShouldStop(2);
_m_hour = BA.numberCast(int.class, 0);Debug.locals.put("m_hour", _m_hour);Debug.locals.put("m_hour", _m_hour);
 BA.debugLineNum = 227;BA.debugLine="Dim m_min As Int=min1";
Debug.ShouldStop(4);
_m_min = _min1;Debug.locals.put("m_min", _m_min);Debug.locals.put("m_min", _m_min);
 BA.debugLineNum = 229;BA.debugLine="Dim div1 As Int=0  '' hour";
Debug.ShouldStop(16);
_div1 = BA.numberCast(int.class, 0);Debug.locals.put("div1", _div1);Debug.locals.put("div1", _div1);
 BA.debugLineNum = 231;BA.debugLine="If(min1>0)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean(">",_min1,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 232;BA.debugLine="m_hour=	myfunc.Min_to_saatMinRoz(min1).Get(0)";
Debug.ShouldStop(128);
_m_hour = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_min1)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("m_hour", _m_hour);
 BA.debugLineNum = 233;BA.debugLine="m_min=myfunc.Min_to_saatMinRoz(min1).Get(1)";
Debug.ShouldStop(256);
_m_min = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_min1)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("m_min", _m_min);
 BA.debugLineNum = 234;BA.debugLine="m_day=myfunc.Min_to_saatMinRoz(min1).Get(2)";
Debug.ShouldStop(512);
_m_day = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_min1)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("m_day", _m_day);
 }else {
 BA.debugLineNum = 237;BA.debugLine="Dim min_new As Int = min1*(-1)";
Debug.ShouldStop(4096);
_min_new = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable((-(double) (0 + 1)))}, "*",0, 0));Debug.locals.put("min_new", _min_new);Debug.locals.put("min_new", _min_new);
 BA.debugLineNum = 239;BA.debugLine="m_hour=	myfunc.Min_to_saatMinRoz(min_new).Get(0)";
Debug.ShouldStop(16384);
_m_hour = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_min_new)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("m_hour", _m_hour);
 BA.debugLineNum = 240;BA.debugLine="m_min=myfunc.Min_to_saatMinRoz(min_new).Get(1)";
Debug.ShouldStop(32768);
_m_min = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_min_new)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("m_min", _m_min);
 BA.debugLineNum = 241;BA.debugLine="m_day=myfunc.Min_to_saatMinRoz(min_new).Get(2)";
Debug.ShouldStop(65536);
_m_day = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(_min_new)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("m_day", _m_day);
 BA.debugLineNum = 243;BA.debugLine="str_state=\"-منفی-\"&CRLF";
Debug.ShouldStop(262144);
_str_state = RemoteObject.concat(RemoteObject.createImmutable("-منفی-"),morakhasi_activity.mostCurrent.__c.getField(true,"CRLF"));Debug.locals.put("str_state", _str_state);
 };
 BA.debugLineNum = 247;BA.debugLine="str_result=str_state&modify_str_showTime(m_day,m_";
Debug.ShouldStop(4194304);
_str_result = RemoteObject.concat(_str_state,_modify_str_showtime(_m_day,_m_hour,_m_min));Debug.locals.put("str_result", _str_result);
 BA.debugLineNum = 249;BA.debugLine="Return str_result";
Debug.ShouldStop(16777216);
if (true) return _str_result;
 BA.debugLineNum = 251;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("modify_str_showTime (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,140);
if (RapidSub.canDelegate("modify_str_showtime")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","modify_str_showtime", _tim_d, _tim_h, _tim_m);}
RemoteObject _str_modify1 = RemoteObject.createImmutable("");
Debug.locals.put("tim_d", _tim_d);
Debug.locals.put("tim_h", _tim_h);
Debug.locals.put("tim_m", _tim_m);
 BA.debugLineNum = 140;BA.debugLine="Sub modify_str_showTime (tim_d As Int, tim_h As In";
Debug.ShouldStop(2048);
 BA.debugLineNum = 141;BA.debugLine="Dim str_modify1 As String=\"\"";
Debug.ShouldStop(4096);
_str_modify1 = BA.ObjectToString("");Debug.locals.put("str_modify1", _str_modify1);Debug.locals.put("str_modify1", _str_modify1);
 BA.debugLineNum = 142;BA.debugLine="If(tim_d<>0)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("!",_tim_d,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 143;BA.debugLine="str_modify1=tim_d&\" روز \"";
Debug.ShouldStop(16384);
_str_modify1 = RemoteObject.concat(_tim_d,RemoteObject.createImmutable(" روز "));Debug.locals.put("str_modify1", _str_modify1);
 };
 BA.debugLineNum = 145;BA.debugLine="If(tim_h<>0)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("!",_tim_h,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 146;BA.debugLine="str_modify1=str_modify1&tim_h&\" ساعت \"";
Debug.ShouldStop(131072);
_str_modify1 = RemoteObject.concat(_str_modify1,_tim_h,RemoteObject.createImmutable(" ساعت "));Debug.locals.put("str_modify1", _str_modify1);
 };
 BA.debugLineNum = 148;BA.debugLine="If(tim_m<>0)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("!",_tim_m,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 149;BA.debugLine="str_modify1=str_modify1&tim_m&\" دقیقه \"";
Debug.ShouldStop(1048576);
_str_modify1 = RemoteObject.concat(_str_modify1,_tim_m,RemoteObject.createImmutable(" دقیقه "));Debug.locals.put("str_modify1", _str_modify1);
 };
 BA.debugLineNum = 152;BA.debugLine="If(str_modify1=\"\")Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",_str_modify1,RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 153;BA.debugLine="str_modify1=\"-\"";
Debug.ShouldStop(16777216);
_str_modify1 = BA.ObjectToString("-");Debug.locals.put("str_modify1", _str_modify1);
 };
 BA.debugLineNum = 156;BA.debugLine="Return str_modify1";
Debug.ShouldStop(134217728);
if (true) return _str_modify1;
 BA.debugLineNum = 158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("pan_all_morakhasi_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,298);
if (RapidSub.canDelegate("pan_all_morakhasi_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","pan_all_morakhasi_click");}
 BA.debugLineNum = 298;BA.debugLine="Private Sub pan_all_morakhasi_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 299;BA.debugLine="pan_all_morakhasi.Visible=False";
Debug.ShouldStop(1024);
morakhasi_activity.mostCurrent._pan_all_morakhasi.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 300;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("pan_all_set_date_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,620);
if (RapidSub.canDelegate("pan_all_set_date_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","pan_all_set_date_click");}
 BA.debugLineNum = 620;BA.debugLine="Private Sub pan_all_set_date_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 621;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(4096);
morakhasi_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",morakhasi_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 622;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("Panel4_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,302);
if (RapidSub.canDelegate("panel4_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","panel4_click");}
 BA.debugLineNum = 302;BA.debugLine="Private Sub Panel4_Click";
Debug.ShouldStop(8192);
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
public static RemoteObject  _pik_day_bala1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_day_bala1_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,575);
if (RapidSub.canDelegate("pik_day_bala1_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","pik_day_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 575;BA.debugLine="Private Sub pik_day_bala1_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 576;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(-2147483648);
_int1 = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 577;BA.debugLine="pik_day1.Text=int1+1";
Debug.ShouldStop(1);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 580;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 581;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 582;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(32);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 584;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 585;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(256);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 588;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 589;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(4096);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 591;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 592;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(32768);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 595;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
Debug.ShouldStop(262144);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText"))))));
 BA.debugLineNum = 596;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("pik_day_paeen1_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,598);
if (RapidSub.canDelegate("pik_day_paeen1_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","pik_day_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 598;BA.debugLine="Private Sub pik_day_paeen1_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 599;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(4194304);
_int1 = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 600;BA.debugLine="pik_day1.Text=int1-1";
Debug.ShouldStop(8388608);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 601;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 602;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 603;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(67108864);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 605;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 606;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(536870912);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 609;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 610;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(2);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 612;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 613;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(16);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 616;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
Debug.ShouldStop(128);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText"))))));
 BA.debugLineNum = 617;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("pik_moon_bala1_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,521);
if (RapidSub.canDelegate("pik_moon_bala1_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","pik_moon_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 521;BA.debugLine="Private Sub pik_moon_bala1_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 522;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(512);
_int1 = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 523;BA.debugLine="pik_moon1.Tag=int1+1";
Debug.ShouldStop(1024);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 525;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 526;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(8192);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 528;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 529;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(65536);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 531;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(262144);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(morakhasi_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 533;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("pik_moon_paeen1_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,535);
if (RapidSub.canDelegate("pik_moon_paeen1_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","pik_moon_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 535;BA.debugLine="Private Sub pik_moon_paeen1_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 536;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(8388608);
_int1 = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 537;BA.debugLine="pik_moon1.Tag=int1-1";
Debug.ShouldStop(16777216);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 539;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 540;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(134217728);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 542;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 543;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(1073741824);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 545;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
Debug.ShouldStop(1);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(morakhasi_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 547;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("pik_pan_day1_Touch (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,481);
if (RapidSub.canDelegate("pik_pan_day1_touch")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","pik_pan_day1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 481;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
Debug.ShouldStop(1);
 BA.debugLineNum = 482;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 483;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(4);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 484;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(8);
morakhasi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 487;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 489;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {morakhasi_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 490;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
Debug.ShouldStop(512);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 491;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(1024);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 492;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(2048);
morakhasi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 494;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {morakhasi_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 495;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
Debug.ShouldStop(16384);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 496;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(32768);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 497;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(65536);
morakhasi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 500;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 501;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 502;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(2097152);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 504;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 505;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(16777216);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 508;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 509;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(268435456);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 511;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 512;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(-2147483648);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 515;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
Debug.ShouldStop(4);
morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, morakhasi_activity.mostCurrent._pik_day1.runMethod(true,"getText"))))));
 };
 BA.debugLineNum = 519;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("pik_pan_moon1_Touch (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,421);
if (RapidSub.canDelegate("pik_pan_moon1_touch")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","pik_pan_moon1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 421;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
Debug.ShouldStop(16);
 BA.debugLineNum = 422;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 423;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(64);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 424;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(128);
morakhasi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 427;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 429;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {morakhasi_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 430;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
Debug.ShouldStop(8192);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 431;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(16384);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 432;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(32768);
morakhasi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 434;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {morakhasi_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 435;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
Debug.ShouldStop(262144);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 436;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(524288);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 437;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(1048576);
morakhasi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 440;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 441;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(16777216);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 443;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 444;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(134217728);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 446;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(536870912);
morakhasi_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(morakhasi_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 };
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
public static RemoteObject  _pik_pan_year1_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("pik_pan_year1_Touch (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,451);
if (RapidSub.canDelegate("pik_pan_year1_touch")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","pik_pan_year1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 451;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
Debug.ShouldStop(4);
 BA.debugLineNum = 452;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 453;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(16);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 454;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(32);
morakhasi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 457;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 459;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {morakhasi_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 460;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
Debug.ShouldStop(2048);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 461;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(4096);
morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 462;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(8192);
morakhasi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 464;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {morakhasi_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 465;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
Debug.ShouldStop(65536);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 466;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(131072);
morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 467;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(262144);
morakhasi_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 470;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 471;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(4194304);
morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 473;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 474;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(33554432);
morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 };
 BA.debugLineNum = 479;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("pik_year_bala1_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,549);
if (RapidSub.canDelegate("pik_year_bala1_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","pik_year_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 549;BA.debugLine="Private Sub pik_year_bala1_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 550;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(32);
_int1 = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 551;BA.debugLine="pik_year1.Text=int1+1";
Debug.ShouldStop(64);
morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 553;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 554;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(512);
morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 556;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 557;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(4096);
morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 560;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("pik_year_paeen1_Click (morakhasi_activity) ","morakhasi_activity",18,morakhasi_activity.mostCurrent.activityBA,morakhasi_activity.mostCurrent,562);
if (RapidSub.canDelegate("pik_year_paeen1_click")) { return ir.taravatgroup.ezafekari2.morakhasi_activity.remoteMe.runUserSub(false, "morakhasi_activity","pik_year_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 562;BA.debugLine="Private Sub pik_year_paeen1_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 563;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(262144);
_int1 = BA.numberCast(int.class, morakhasi_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,morakhasi_activity.mostCurrent.activityBA,(Object)(morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 564;BA.debugLine="pik_year1.Text=int1-1";
Debug.ShouldStop(524288);
morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 566;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 567;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(4194304);
morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 569;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 570;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(33554432);
morakhasi_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 573;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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