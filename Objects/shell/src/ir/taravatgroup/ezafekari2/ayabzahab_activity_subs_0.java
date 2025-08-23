package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class ayabzahab_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,57);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","activity_create", _firsttime);}
RemoteObject _moon_num = RemoteObject.createImmutable("");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 57;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 59;BA.debugLine="Activity.LoadLayout(\"ayabzahab_layout\")";
Debug.ShouldStop(67108864);
ayabzahab_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("ayabzahab_layout")),ayabzahab_activity.mostCurrent.activityBA);
 BA.debugLineNum = 61;BA.debugLine="sp_year.Add(\"1404\")";
Debug.ShouldStop(268435456);
ayabzahab_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1404")));
 BA.debugLineNum = 62;BA.debugLine="sp_year.Add(\"1403\")";
Debug.ShouldStop(536870912);
ayabzahab_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1403")));
 BA.debugLineNum = 63;BA.debugLine="sp_year.Add(\"1402\")";
Debug.ShouldStop(1073741824);
ayabzahab_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1402")));
 BA.debugLineNum = 64;BA.debugLine="sp_year.Add(\"1401\")";
Debug.ShouldStop(-2147483648);
ayabzahab_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1401")));
 BA.debugLineNum = 65;BA.debugLine="sp_year.Add(\"1400\")";
Debug.ShouldStop(1);
ayabzahab_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1400")));
 BA.debugLineNum = 66;BA.debugLine="sp_year.Add(\"1399\")";
Debug.ShouldStop(2);
ayabzahab_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1399")));
 BA.debugLineNum = 67;BA.debugLine="sp_year.Add(\"1398\")";
Debug.ShouldStop(4);
ayabzahab_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1398")));
 BA.debugLineNum = 69;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
Debug.ShouldStop(16);
ayabzahab_activity.mostCurrent._sp_moon.runVoidMethod ("AddAll",(Object)(ayabzahab_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 71;BA.debugLine="sp_year.SelectedIndex=0";
Debug.ShouldStop(64);
ayabzahab_activity.mostCurrent._sp_year.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 BA.debugLineNum = 72;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
Debug.ShouldStop(128);
ayabzahab_activity.mostCurrent._sp_moon.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(ayabzahab_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianMonth"))))),RemoteObject.createImmutable(1)}, "-",1, 0)));
 BA.debugLineNum = 74;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(sp_moo";
Debug.ShouldStop(512);
_moon_num = ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {ayabzahab_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("moon_num", _moon_num);Debug.locals.put("moon_num", _moon_num);
 BA.debugLineNum = 77;BA.debugLine="fill_list_ayabzahab(sp_year.SelectedItem,moon_num";
Debug.ShouldStop(4096);
_fill_list_ayabzahab(ayabzahab_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),_moon_num);
 BA.debugLineNum = 79;BA.debugLine="pan_hed_list2.Color=Main.color4";
Debug.ShouldStop(16384);
ayabzahab_activity.mostCurrent._pan_hed_list2.runVoidMethod ("setColor",ayabzahab_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 80;BA.debugLine="lbl_title_edit1.Color=Main.color4";
Debug.ShouldStop(32768);
ayabzahab_activity.mostCurrent._lbl_title_edit1.runVoidMethod ("setColor",ayabzahab_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 85;BA.debugLine="moon_dataPik.Initialize";
Debug.ShouldStop(1048576);
ayabzahab_activity.mostCurrent._moon_datapik.runVoidMethod ("Initialize");
 BA.debugLineNum = 86;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
Debug.ShouldStop(2097152);
ayabzahab_activity.mostCurrent._moon_datapik.runVoidMethod ("AddAll",(Object)(ayabzahab_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 89;BA.debugLine="sp_type_state.Add(\"اضافه شدن به دریافتی ها\")";
Debug.ShouldStop(16777216);
ayabzahab_activity.mostCurrent._sp_type_state.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("اضافه شدن به دریافتی ها")));
 BA.debugLineNum = 90;BA.debugLine="sp_type_state.Add(\"کم شدن از دریافتی ها\")";
Debug.ShouldStop(33554432);
ayabzahab_activity.mostCurrent._sp_type_state.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("کم شدن از دریافتی ها")));
 BA.debugLineNum = 93;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_KeyPress (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,188);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 188;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 189;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, ayabzahab_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 190;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(536870912);
_lbl_back_click();
 BA.debugLineNum = 191;BA.debugLine="Return True";
Debug.ShouldStop(1073741824);
if (true) return ayabzahab_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 193;BA.debugLine="Return False";
Debug.ShouldStop(1);
if (true) return ayabzahab_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 195;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Pause (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,99);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 99;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 101;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Resume (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,95);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","activity_resume");}
 BA.debugLineNum = 95;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_mablagh_edit1_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mablagh_edit1_TextChanged (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,331);
if (RapidSub.canDelegate("et_mablagh_edit1_textchanged")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","et_mablagh_edit1_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 331;BA.debugLine="Private Sub et_mablagh_edit1_TextChanged (Old As S";
Debug.ShouldStop(1024);
 BA.debugLineNum = 332;BA.debugLine="et_mablagh_edit1.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(2048);
ayabzahab_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 333;BA.debugLine="myfunc.change_formater(Old,New,et_mablagh_edit1)";
Debug.ShouldStop(4096);
ayabzahab_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(ayabzahab_activity.mostCurrent._et_mablagh_edit1));
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
public static RemoteObject  _fill_list_ayabzahab(RemoteObject _year,RemoteObject _moon) throws Exception{
try {
		Debug.PushSubsStack("fill_list_ayabzahab (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,104);
if (RapidSub.canDelegate("fill_list_ayabzahab")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","fill_list_ayabzahab", _year, _moon);}
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 104;BA.debugLine="Sub fill_list_ayabzahab(year As String , moon As S";
Debug.ShouldStop(128);
 BA.debugLineNum = 107;BA.debugLine="cust_LV_ayabzahab.Clear";
Debug.ShouldStop(1024);
ayabzahab_activity.mostCurrent._cust_lv_ayabzahab.runVoidMethod ("_clear");
 BA.debugLineNum = 110;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(8192);
ayabzahab_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA);
 BA.debugLineNum = 112;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(32768);
ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), ayabzahab_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ayabzahab WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' ORDER BY  date DESC;")))));
 BA.debugLineNum = 114;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(131072);
while (ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 119;BA.debugLine="p = xui2.CreatePanel(\"p\")";
Debug.ShouldStop(4194304);
ayabzahab_activity.mostCurrent._p = ayabzahab_activity.mostCurrent._xui2.runMethod(false,"CreatePanel",ayabzahab_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 120;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
Debug.ShouldStop(8388608);
ayabzahab_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(ayabzahab_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),ayabzahab_activity.mostCurrent.activityBA)),(Object)(ayabzahab_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 154)))));
 BA.debugLineNum = 121;BA.debugLine="p.LoadLayout(\"item_list_list2\")";
Debug.ShouldStop(16777216);
ayabzahab_activity.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list_list2")),ayabzahab_activity.mostCurrent.activityBA);
 BA.debugLineNum = 123;BA.debugLine="cust_LV_ayabzahab.Add(p,dbCode.res.GetString(\"id";
Debug.ShouldStop(67108864);
ayabzahab_activity.mostCurrent._cust_lv_ayabzahab.runVoidMethod ("_add",(Object)(ayabzahab_activity.mostCurrent._p),(Object)((ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 125;BA.debugLine="lbl_onvan.Text=dbCode.res.GetString(\"onvan\")";
Debug.ShouldStop(268435456);
ayabzahab_activity.mostCurrent._lbl_onvan.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("onvan")))));
 BA.debugLineNum = 127;BA.debugLine="lbl_date.Text=dbCode.res.GetString(\"date\")";
Debug.ShouldStop(1073741824);
ayabzahab_activity.mostCurrent._lbl_date.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")))));
 BA.debugLineNum = 128;BA.debugLine="lbl_mablagh.Tag=dbCode.res.GetString(\"mablagh\")";
Debug.ShouldStop(-2147483648);
ayabzahab_activity.mostCurrent._lbl_mablagh.runMethod(false,"setTag",(ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh")))));
 BA.debugLineNum = 129;BA.debugLine="lbl_mablagh.Text=myfunc.show_num_pool(lbl_mablag";
Debug.ShouldStop(1);
ayabzahab_activity.mostCurrent._lbl_mablagh.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, ayabzahab_activity.mostCurrent._lbl_mablagh.runMethod(false,"getTag"))))));
 BA.debugLineNum = 133;BA.debugLine="If(dbCode.res.GetString(\"state\")) =1 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",(ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state")))),BA.NumberToString(1))) { 
 BA.debugLineNum = 134;BA.debugLine="lbl_icon.Text=Chr(0xF271)  'plus";
Debug.ShouldStop(32);
ayabzahab_activity.mostCurrent._lbl_icon.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf271))))));
 BA.debugLineNum = 135;BA.debugLine="lbl_icon.Color=Colors.Green";
Debug.ShouldStop(64);
ayabzahab_activity.mostCurrent._lbl_icon.runVoidMethod ("setColor",ayabzahab_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 }else {
 BA.debugLineNum = 137;BA.debugLine="lbl_icon.Text=Chr(0xF272)  'minus";
Debug.ShouldStop(256);
ayabzahab_activity.mostCurrent._lbl_icon.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf272))))));
 BA.debugLineNum = 138;BA.debugLine="lbl_icon.Color=Colors.Red";
Debug.ShouldStop(512);
ayabzahab_activity.mostCurrent._lbl_icon.runVoidMethod ("setColor",ayabzahab_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 };
 BA.debugLineNum = 144;BA.debugLine="lbl_tozih.Text=dbCode.res.GetString(\"tozihat\")";
Debug.ShouldStop(32768);
ayabzahab_activity.mostCurrent._lbl_tozih.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 148;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
Debug.ShouldStop(524288);
ayabzahab_activity.mostCurrent._lbl_remove_from_list.runMethod(false,"setTag",(ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 149;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
Debug.ShouldStop(1048576);
ayabzahab_activity.mostCurrent._lbl_edit_from_list.runMethod(false,"setTag",(ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 }
;
 BA.debugLineNum = 156;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(134217728);
ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 157;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(268435456);
ayabzahab_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 159;BA.debugLine="If(cust_LV_ayabzahab.LastVisibleIndex<5)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("<",ayabzahab_activity.mostCurrent._cust_lv_ayabzahab.runMethod(true,"_getlastvisibleindex"),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 160;BA.debugLine="p = xui2.CreatePanel(\"p\")";
Debug.ShouldStop(-2147483648);
ayabzahab_activity.mostCurrent._p = ayabzahab_activity.mostCurrent._xui2.runMethod(false,"CreatePanel",ayabzahab_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 161;BA.debugLine="Select cust_LV_ayabzahab.LastVisibleIndex";
Debug.ShouldStop(1);
switch (BA.switchObjectToInt(ayabzahab_activity.mostCurrent._cust_lv_ayabzahab.runMethod(true,"_getlastvisibleindex"),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 163;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
Debug.ShouldStop(4);
ayabzahab_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(ayabzahab_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),ayabzahab_activity.mostCurrent.activityBA)),(Object)((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(380),RemoteObject.createImmutable(100)}, "-",1, 1))));
 break; }
case 1: {
 BA.debugLineNum = 165;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
Debug.ShouldStop(16);
ayabzahab_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(ayabzahab_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),ayabzahab_activity.mostCurrent.activityBA)),(Object)(ayabzahab_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400)))));
 break; }
case 2: {
 BA.debugLineNum = 167;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
Debug.ShouldStop(64);
ayabzahab_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(ayabzahab_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),ayabzahab_activity.mostCurrent.activityBA)),(Object)(ayabzahab_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 break; }
case 3: {
 BA.debugLineNum = 169;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
Debug.ShouldStop(256);
ayabzahab_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(ayabzahab_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),ayabzahab_activity.mostCurrent.activityBA)),(Object)(ayabzahab_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 break; }
case 4: {
 BA.debugLineNum = 171;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
Debug.ShouldStop(1024);
ayabzahab_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(ayabzahab_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),ayabzahab_activity.mostCurrent.activityBA)),(Object)(ayabzahab_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 break; }
case 5: {
 BA.debugLineNum = 173;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
Debug.ShouldStop(4096);
ayabzahab_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(ayabzahab_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),ayabzahab_activity.mostCurrent.activityBA)),(Object)(ayabzahab_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 break; }
}
;
 BA.debugLineNum = 175;BA.debugLine="cust_LV_ayabzahab.Add(p,\"\")";
Debug.ShouldStop(16384);
ayabzahab_activity.mostCurrent._cust_lv_ayabzahab.runVoidMethod ("_add",(Object)(ayabzahab_activity.mostCurrent._p),(Object)((RemoteObject.createImmutable(""))));
 };
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
 //BA.debugLineNum = 16;BA.debugLine="Dim xui2 As XUI";
ayabzahab_activity.mostCurrent._xui2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 17;BA.debugLine="Dim p As B4XView";
ayabzahab_activity.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private pan_hed_list2 As Panel";
ayabzahab_activity.mostCurrent._pan_hed_list2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private pik_day1 As Label";
ayabzahab_activity.mostCurrent._pik_day1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private pik_moon1 As Label";
ayabzahab_activity.mostCurrent._pik_moon1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private pik_year1 As Label";
ayabzahab_activity.mostCurrent._pik_year1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim num_dataPik As Int=0  '' for time picker";
ayabzahab_activity._num_datapik = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 28;BA.debugLine="Dim moon_dataPik As List  '' for date picker";
ayabzahab_activity.mostCurrent._moon_datapik = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 30;BA.debugLine="Private lbl_onvan As Label";
ayabzahab_activity.mostCurrent._lbl_onvan = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private lbl_date As Label";
ayabzahab_activity.mostCurrent._lbl_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private lbl_mablagh As Label";
ayabzahab_activity.mostCurrent._lbl_mablagh = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private lbl_edit_from_list As Label";
ayabzahab_activity.mostCurrent._lbl_edit_from_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private lbl_remove_from_list As Label";
ayabzahab_activity.mostCurrent._lbl_remove_from_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private lbl_tozih As Label";
ayabzahab_activity.mostCurrent._lbl_tozih = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private Panel1 As Panel";
ayabzahab_activity.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private cust_LV_ayabzahab As CustomListView";
ayabzahab_activity.mostCurrent._cust_lv_ayabzahab = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 38;BA.debugLine="Private pan_all_edit1 As Panel";
ayabzahab_activity.mostCurrent._pan_all_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private pan_all_set_date As Panel";
ayabzahab_activity.mostCurrent._pan_all_set_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private lbl_title_edit1 As Label";
ayabzahab_activity.mostCurrent._lbl_title_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private et_onvan_edit1 As EditText";
ayabzahab_activity.mostCurrent._et_onvan_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private lbl_date_edit1 As Label";
ayabzahab_activity.mostCurrent._lbl_date_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private et_mablagh_edit1 As EditText";
ayabzahab_activity.mostCurrent._et_mablagh_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private et_tozih_edit1 As EditText";
ayabzahab_activity.mostCurrent._et_tozih_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Dim index_current_pan As Int";
ayabzahab_activity._index_current_pan = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 46;BA.debugLine="Dim current_itemId_edit As Int";
ayabzahab_activity._current_itemid_edit = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 48;BA.debugLine="Private sp_moon As Spinner";
ayabzahab_activity.mostCurrent._sp_moon = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private sp_year As Spinner";
ayabzahab_activity.mostCurrent._sp_year = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private lbl_icon As Label";
ayabzahab_activity.mostCurrent._lbl_icon = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private sp_type_state As Spinner";
ayabzahab_activity.mostCurrent._sp_type_state = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private lbl_sp_type As Label";
ayabzahab_activity.mostCurrent._lbl_sp_type = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Dim addEdit_id As Int=0";
ayabzahab_activity._addedit_id = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _item_edit_box_mod(RemoteObject _title,RemoteObject _onvan,RemoteObject _date,RemoteObject _mablage,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("item_edit_box_mod (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,242);
if (RapidSub.canDelegate("item_edit_box_mod")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","item_edit_box_mod", _title, _onvan, _date, _mablage, _tozih, _state);}
Debug.locals.put("title", _title);
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablage", _mablage);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 242;BA.debugLine="Sub item_edit_box_mod(title As String,onvan As Str";
Debug.ShouldStop(131072);
 BA.debugLineNum = 244;BA.debugLine="If(addEdit_id=1)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",ayabzahab_activity._addedit_id,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 245;BA.debugLine="If(state=1)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",_state,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 246;BA.debugLine="sp_type_state.SelectedIndex=0";
Debug.ShouldStop(2097152);
ayabzahab_activity.mostCurrent._sp_type_state.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 }else {
 BA.debugLineNum = 248;BA.debugLine="sp_type_state.SelectedIndex=1";
Debug.ShouldStop(8388608);
ayabzahab_activity.mostCurrent._sp_type_state.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 1));
 };
 }else {
 BA.debugLineNum = 252;BA.debugLine="sp_type_state.SelectedIndex=0";
Debug.ShouldStop(134217728);
ayabzahab_activity.mostCurrent._sp_type_state.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 };
 BA.debugLineNum = 255;BA.debugLine="lbl_title_edit1.Text=title";
Debug.ShouldStop(1073741824);
ayabzahab_activity.mostCurrent._lbl_title_edit1.runMethod(true,"setText",BA.ObjectToCharSequence(_title));
 BA.debugLineNum = 256;BA.debugLine="et_onvan_edit1.Text=onvan";
Debug.ShouldStop(-2147483648);
ayabzahab_activity.mostCurrent._et_onvan_edit1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_onvan));
 BA.debugLineNum = 257;BA.debugLine="lbl_date_edit1.Text=myfunc.fa2en(date)";
Debug.ShouldStop(1);
ayabzahab_activity.mostCurrent._lbl_date_edit1.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(_date))));
 BA.debugLineNum = 258;BA.debugLine="et_mablagh_edit1.Tag=mablage";
Debug.ShouldStop(2);
ayabzahab_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"setTag",(_mablage));
 BA.debugLineNum = 259;BA.debugLine="et_mablagh_edit1.Text=myfunc.show_num_pool(mablag";
Debug.ShouldStop(4);
ayabzahab_activity.mostCurrent._et_mablagh_edit1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _mablage)))));
 BA.debugLineNum = 261;BA.debugLine="et_tozih_edit1.Text=tozih";
Debug.ShouldStop(16);
ayabzahab_activity.mostCurrent._et_tozih_edit1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_tozih));
 BA.debugLineNum = 264;BA.debugLine="pan_all_edit1.Visible=True";
Debug.ShouldStop(128);
ayabzahab_activity.mostCurrent._pan_all_edit1.runMethod(true,"setVisible",ayabzahab_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 266;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_edit1.Text.S";
Debug.ShouldStop(512);
ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4)))))));
 BA.debugLineNum = 267;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_edit1.Text.Su";
Debug.ShouldStop(1024);
ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7)))))));
 BA.debugLineNum = 268;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(2048);
ayabzahab_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 269;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_edit1.Text.Su";
Debug.ShouldStop(4096);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 10)))))));
 BA.debugLineNum = 274;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_add_ayabzahab_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_add_ayabzahab_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,560);
if (RapidSub.canDelegate("lbl_add_ayabzahab_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","lbl_add_ayabzahab_click");}
 BA.debugLineNum = 560;BA.debugLine="Private Sub lbl_add_ayabzahab_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 562;BA.debugLine="addEdit_id=0";
Debug.ShouldStop(131072);
ayabzahab_activity._addedit_id = BA.numberCast(int.class, 0);
 BA.debugLineNum = 565;BA.debugLine="item_edit_box_mod(\"ثبت ایاب ذهاب\",\"\",myfunc.fa2en";
Debug.ShouldStop(1048576);
_item_edit_box_mod(BA.ObjectToString("ثبت ایاب ذهاب"),BA.ObjectToString(""),ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianShortDate"))),BA.ObjectToString("0"),BA.ObjectToString(""),BA.numberCast(int.class, 0));
 BA.debugLineNum = 566;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,184);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","lbl_back_click");}
 BA.debugLineNum = 184;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 185;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16777216);
ayabzahab_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 186;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_date_edit1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_date_edit1_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,325);
if (RapidSub.canDelegate("lbl_date_edit1_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","lbl_date_edit1_click");}
 BA.debugLineNum = 325;BA.debugLine="Private Sub lbl_date_edit1_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 326;BA.debugLine="pan_all_set_date.Visible=True";
Debug.ShouldStop(32);
ayabzahab_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",ayabzahab_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 327;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_edit_from_list_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_edit_from_list_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,223);
if (RapidSub.canDelegate("lbl_edit_from_list_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","lbl_edit_from_list_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 223;BA.debugLine="Private Sub lbl_edit_from_list_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 224;BA.debugLine="Dim b As Label";
Debug.ShouldStop(-2147483648);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 225;BA.debugLine="b = Sender";
Debug.ShouldStop(1);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), ayabzahab_activity.mostCurrent.__c.runMethod(false,"Sender",ayabzahab_activity.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 227;BA.debugLine="addEdit_id=1";
Debug.ShouldStop(4);
ayabzahab_activity._addedit_id = BA.numberCast(int.class, 1);
 BA.debugLineNum = 228;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(8);
ayabzahab_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA);
 BA.debugLineNum = 230;BA.debugLine="index_current_pan=3";
Debug.ShouldStop(32);
ayabzahab_activity._index_current_pan = BA.numberCast(int.class, 3);
 BA.debugLineNum = 231;BA.debugLine="current_itemId_edit=b.Tag";
Debug.ShouldStop(64);
ayabzahab_activity._current_itemid_edit = BA.numberCast(int.class, _b.runMethod(false,"getTag"));
 BA.debugLineNum = 232;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(128);
ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), ayabzahab_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ayabzahab WHERE id="),ayabzahab_activity._current_itemid_edit))));
 BA.debugLineNum = 233;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(256);
ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 235;BA.debugLine="item_edit_box_mod(\"ویرایش\",dbCode.res.GetString(\"";
Debug.ShouldStop(1024);
_item_edit_box_mod(BA.ObjectToString("ویرایش"),ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("onvan"))),ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date"))),ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))),ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat"))),BA.numberCast(int.class, ayabzahab_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state")))));
 BA.debugLineNum = 240;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_remove_from_list_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_remove_from_list_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,197);
if (RapidSub.canDelegate("lbl_remove_from_list_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","lbl_remove_from_list_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 197;BA.debugLine="Private Sub lbl_remove_from_list_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 199;BA.debugLine="Dim b As Label";
Debug.ShouldStop(64);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 200;BA.debugLine="b = Sender";
Debug.ShouldStop(128);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), ayabzahab_activity.mostCurrent.__c.runMethod(false,"Sender",ayabzahab_activity.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 203;BA.debugLine="Dim result As Int";
Debug.ShouldStop(1024);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 204;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
Debug.ShouldStop(2048);
_result = ayabzahab_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا این مورد حذف شود؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((ayabzahab_activity.mostCurrent.__c.getField(false,"Null"))),ayabzahab_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 205;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, ayabzahab_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 207;BA.debugLine="If (dbCode.delete_ayabZahab(b.Tag))Then";
Debug.ShouldStop(16384);
if ((ayabzahab_activity.mostCurrent._dbcode.runMethod(true,"_delete_ayabzahab" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 208;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
Debug.ShouldStop(32768);
ayabzahab_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد.")),(Object)(ayabzahab_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 211;BA.debugLine="fill_list_ayabzahab(sp_year.SelectedItem,myfunc";
Debug.ShouldStop(262144);
_fill_list_ayabzahab(ayabzahab_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {ayabzahab_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 };
 BA.debugLineNum = 220;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_edit1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_edit1_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,291);
if (RapidSub.canDelegate("lbl_save_edit1_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","lbl_save_edit1_click");}
 BA.debugLineNum = 291;BA.debugLine="Private Sub lbl_save_edit1_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 293;BA.debugLine="If(et_onvan_edit1.Text=\"\")Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",ayabzahab_activity.mostCurrent._et_onvan_edit1.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 294;BA.debugLine="ToastMessageShow(\"عنوان خالی است!\",False)";
Debug.ShouldStop(32);
ayabzahab_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("عنوان خالی است!")),(Object)(ayabzahab_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 295;BA.debugLine="Else If(et_mablagh_edit1.Tag=\"\")Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",ayabzahab_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"getTag"),(RemoteObject.createImmutable(""))))) { 
 BA.debugLineNum = 296;BA.debugLine="ToastMessageShow(\"مبلغ خالی است!\",False)";
Debug.ShouldStop(128);
ayabzahab_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("مبلغ خالی است!")),(Object)(ayabzahab_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 299;BA.debugLine="If(addEdit_id=0)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",ayabzahab_activity._addedit_id,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 301;BA.debugLine="If(sp_type_state.SelectedIndex=0)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",ayabzahab_activity.mostCurrent._sp_type_state.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 302;BA.debugLine="dbCode.add_aybZahab(et_onvan_edit1.Text,lbl_da";
Debug.ShouldStop(8192);
ayabzahab_activity.mostCurrent._dbcode.runVoidMethod ("_add_aybzahab" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity.mostCurrent._et_onvan_edit1.runMethod(true,"getText")),(Object)(ayabzahab_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText")),(Object)(BA.ObjectToString(ayabzahab_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"getTag"))),(Object)(ayabzahab_activity.mostCurrent._et_tozih_edit1.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 1)));
 }else {
 BA.debugLineNum = 304;BA.debugLine="dbCode.add_aybZahab(et_onvan_edit1.Text,lbl_da";
Debug.ShouldStop(32768);
ayabzahab_activity.mostCurrent._dbcode.runVoidMethod ("_add_aybzahab" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity.mostCurrent._et_onvan_edit1.runMethod(true,"getText")),(Object)(ayabzahab_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText")),(Object)(BA.ObjectToString(ayabzahab_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"getTag"))),(Object)(ayabzahab_activity.mostCurrent._et_tozih_edit1.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 2)));
 };
 BA.debugLineNum = 306;BA.debugLine="ToastMessageShow(\"اضافه شد\",False)";
Debug.ShouldStop(131072);
ayabzahab_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(ayabzahab_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 307;BA.debugLine="Else If(addEdit_id=1)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",ayabzahab_activity._addedit_id,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 308;BA.debugLine="If(sp_type_state.SelectedIndex=0)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",ayabzahab_activity.mostCurrent._sp_type_state.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 309;BA.debugLine="dbCode.edit_ayabZahab(current_itemId_edit,et_o";
Debug.ShouldStop(1048576);
ayabzahab_activity.mostCurrent._dbcode.runVoidMethod ("_edit_ayabzahab" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity._current_itemid_edit),(Object)(ayabzahab_activity.mostCurrent._et_onvan_edit1.runMethod(true,"getText")),(Object)(ayabzahab_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText")),(Object)(BA.ObjectToString(ayabzahab_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"getTag"))),(Object)(ayabzahab_activity.mostCurrent._et_tozih_edit1.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 1)));
 }else {
 BA.debugLineNum = 311;BA.debugLine="dbCode.edit_ayabZahab(current_itemId_edit,et_o";
Debug.ShouldStop(4194304);
ayabzahab_activity.mostCurrent._dbcode.runVoidMethod ("_edit_ayabzahab" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity._current_itemid_edit),(Object)(ayabzahab_activity.mostCurrent._et_onvan_edit1.runMethod(true,"getText")),(Object)(ayabzahab_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText")),(Object)(BA.ObjectToString(ayabzahab_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"getTag"))),(Object)(ayabzahab_activity.mostCurrent._et_tozih_edit1.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 2)));
 };
 BA.debugLineNum = 314;BA.debugLine="ToastMessageShow(\"ویرایش شد\",False)";
Debug.ShouldStop(33554432);
ayabzahab_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ویرایش شد")),(Object)(ayabzahab_activity.mostCurrent.__c.getField(true,"False")));
 }}
;
 BA.debugLineNum = 320;BA.debugLine="fill_list_ayabzahab(sp_year.SelectedItem,myfunc.";
Debug.ShouldStop(-2147483648);
_fill_list_ayabzahab(ayabzahab_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {ayabzahab_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 BA.debugLineNum = 321;BA.debugLine="pan_all_edit1.Visible=False";
Debug.ShouldStop(1);
ayabzahab_activity.mostCurrent._pan_all_edit1.runMethod(true,"setVisible",ayabzahab_activity.mostCurrent.__c.getField(true,"False"));
 }}
;
 BA.debugLineNum = 323;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("lbl_save_picker_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,338);
if (RapidSub.canDelegate("lbl_save_picker_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","lbl_save_picker_click");}
 BA.debugLineNum = 338;BA.debugLine="Private Sub lbl_save_picker_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 339;BA.debugLine="lbl_date_edit1.Text=pik_year1.Text&\"/\"&myfunc.con";
Debug.ShouldStop(262144);
ayabzahab_activity.mostCurrent._lbl_date_edit1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))),RemoteObject.createImmutable("/"),ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText")))))));
 BA.debugLineNum = 340;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(524288);
ayabzahab_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",ayabzahab_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 341;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_edit1_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_edit1_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,278);
if (RapidSub.canDelegate("pan_all_edit1_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","pan_all_edit1_click");}
 BA.debugLineNum = 278;BA.debugLine="Private Sub pan_all_edit1_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 279;BA.debugLine="pan_all_edit1.Visible=False";
Debug.ShouldStop(4194304);
ayabzahab_activity.mostCurrent._pan_all_edit1.runMethod(true,"setVisible",ayabzahab_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 280;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("pan_all_set_date_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,286);
if (RapidSub.canDelegate("pan_all_set_date_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","pan_all_set_date_click");}
 BA.debugLineNum = 286;BA.debugLine="Private Sub pan_all_set_date_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 287;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(1073741824);
ayabzahab_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",ayabzahab_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 288;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Panel4_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,282);
if (RapidSub.canDelegate("panel4_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","panel4_click");}
 BA.debugLineNum = 282;BA.debugLine="Private Sub Panel4_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 284;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("pik_day_bala1_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,499);
if (RapidSub.canDelegate("pik_day_bala1_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","pik_day_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 499;BA.debugLine="Private Sub pik_day_bala1_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 500;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(524288);
_int1 = BA.numberCast(int.class, ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 501;BA.debugLine="pik_day1.Text=int1+1";
Debug.ShouldStop(1048576);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 504;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 505;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 506;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(33554432);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 508;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 509;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(268435456);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 512;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 513;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(1);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 515;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 516;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(8);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 519;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
Debug.ShouldStop(64);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText"))))));
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
public static RemoteObject  _pik_day_paeen1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_day_paeen1_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,522);
if (RapidSub.canDelegate("pik_day_paeen1_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","pik_day_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 522;BA.debugLine="Private Sub pik_day_paeen1_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 523;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(1024);
_int1 = BA.numberCast(int.class, ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 524;BA.debugLine="pik_day1.Text=int1-1";
Debug.ShouldStop(2048);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 525;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 526;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 527;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(16384);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 529;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 530;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(131072);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 533;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 534;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(2097152);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 536;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 537;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(16777216);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 540;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
Debug.ShouldStop(134217728);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText"))))));
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
public static RemoteObject  _pik_moon_bala1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_moon_bala1_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,445);
if (RapidSub.canDelegate("pik_moon_bala1_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","pik_moon_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 445;BA.debugLine="Private Sub pik_moon_bala1_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 446;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(536870912);
_int1 = BA.numberCast(int.class, ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 447;BA.debugLine="pik_moon1.Tag=int1+1";
Debug.ShouldStop(1073741824);
ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 449;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 450;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(2);
ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 452;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 453;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(16);
ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 455;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(64);
ayabzahab_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 457;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("pik_moon_paeen1_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,459);
if (RapidSub.canDelegate("pik_moon_paeen1_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","pik_moon_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 459;BA.debugLine="Private Sub pik_moon_paeen1_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 460;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(2048);
_int1 = BA.numberCast(int.class, ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 461;BA.debugLine="pik_moon1.Tag=int1-1";
Debug.ShouldStop(4096);
ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 463;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 464;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(32768);
ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 466;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 467;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(262144);
ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 469;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
Debug.ShouldStop(1048576);
ayabzahab_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 471;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("pik_pan_day1_Touch (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,405);
if (RapidSub.canDelegate("pik_pan_day1_touch")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","pik_pan_day1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 405;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 406;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 407;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(4194304);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 408;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(8388608);
ayabzahab_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 411;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 413;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {ayabzahab_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 414;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
Debug.ShouldStop(536870912);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 415;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(1073741824);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 416;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(-2147483648);
ayabzahab_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 418;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {ayabzahab_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 419;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
Debug.ShouldStop(4);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 420;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(8);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 421;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(16);
ayabzahab_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 424;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 425;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 426;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(512);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 428;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 429;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(4096);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 432;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 433;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(65536);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 435;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 436;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(524288);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 439;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
Debug.ShouldStop(4194304);
ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, ayabzahab_activity.mostCurrent._pik_day1.runMethod(true,"getText"))))));
 };
 BA.debugLineNum = 443;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("pik_pan_moon1_Touch (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,345);
if (RapidSub.canDelegate("pik_pan_moon1_touch")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","pik_pan_moon1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 345;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 346;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 347;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(67108864);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 348;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(134217728);
ayabzahab_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 351;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 353;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {ayabzahab_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 354;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
Debug.ShouldStop(2);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 355;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(4);
ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 356;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(8);
ayabzahab_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 358;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {ayabzahab_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 359;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
Debug.ShouldStop(64);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 360;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(128);
ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 361;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(256);
ayabzahab_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 364;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 365;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(4096);
ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 367;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 368;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(32768);
ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 370;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(131072);
ayabzahab_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(ayabzahab_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 };
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
public static RemoteObject  _pik_pan_year1_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("pik_pan_year1_Touch (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,375);
if (RapidSub.canDelegate("pik_pan_year1_touch")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","pik_pan_year1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 375;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 376;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 377;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(16777216);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 378;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(33554432);
ayabzahab_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 381;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 383;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {ayabzahab_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 384;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
Debug.ShouldStop(-2147483648);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 385;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(1);
ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 386;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(2);
ayabzahab_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 388;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {ayabzahab_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 389;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
Debug.ShouldStop(16);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 390;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(32);
ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 391;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(64);
ayabzahab_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 394;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 395;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(1024);
ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 397;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 398;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(8192);
ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 };
 BA.debugLineNum = 403;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("pik_year_bala1_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,473);
if (RapidSub.canDelegate("pik_year_bala1_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","pik_year_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 473;BA.debugLine="Private Sub pik_year_bala1_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 474;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(33554432);
_int1 = BA.numberCast(int.class, ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 475;BA.debugLine="pik_year1.Text=int1+1";
Debug.ShouldStop(67108864);
ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 477;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 478;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(536870912);
ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 480;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 481;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(1);
ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
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
public static RemoteObject  _pik_year_paeen1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_year_paeen1_Click (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,486);
if (RapidSub.canDelegate("pik_year_paeen1_click")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","pik_year_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 486;BA.debugLine="Private Sub pik_year_paeen1_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 487;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(64);
_int1 = BA.numberCast(int.class, ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 488;BA.debugLine="pik_year1.Text=int1-1";
Debug.ShouldStop(128);
ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 490;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 491;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(1024);
ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 493;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 494;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(8192);
ayabzahab_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 497;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
public static RemoteObject  _sp_moon_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("sp_moon_ItemClick (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,554);
if (RapidSub.canDelegate("sp_moon_itemclick")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","sp_moon_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 554;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
Debug.ShouldStop(512);
 BA.debugLineNum = 556;BA.debugLine="fill_list_ayabzahab(sp_year.SelectedItem,myfunc.c";
Debug.ShouldStop(2048);
_fill_list_ayabzahab(ayabzahab_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {ayabzahab_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 BA.debugLineNum = 558;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sp_year_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("sp_year_ItemClick (ayabzahab_activity) ","ayabzahab_activity",3,ayabzahab_activity.mostCurrent.activityBA,ayabzahab_activity.mostCurrent,546);
if (RapidSub.canDelegate("sp_year_itemclick")) { return ir.taravatgroup.ezafekari2.ayabzahab_activity.remoteMe.runUserSub(false, "ayabzahab_activity","sp_year_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 546;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
Debug.ShouldStop(2);
 BA.debugLineNum = 548;BA.debugLine="fill_list_ayabzahab(sp_year.SelectedItem,myfunc.c";
Debug.ShouldStop(8);
_fill_list_ayabzahab(ayabzahab_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),ayabzahab_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,ayabzahab_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {ayabzahab_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 BA.debugLineNum = 552;BA.debugLine="End Sub";
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