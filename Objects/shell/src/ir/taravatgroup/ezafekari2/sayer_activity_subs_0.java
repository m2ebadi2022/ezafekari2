package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class sayer_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,57);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","activity_create", _firsttime);}
RemoteObject _moon_num = RemoteObject.createImmutable("");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 57;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 59;BA.debugLine="Activity.LoadLayout(\"sayer_layout\")";
Debug.ShouldStop(67108864);
sayer_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("sayer_layout")),sayer_activity.mostCurrent.activityBA);
 BA.debugLineNum = 61;BA.debugLine="sp_year.Add(\"1404\")";
Debug.ShouldStop(268435456);
sayer_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1404")));
 BA.debugLineNum = 62;BA.debugLine="sp_year.Add(\"1403\")";
Debug.ShouldStop(536870912);
sayer_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1403")));
 BA.debugLineNum = 63;BA.debugLine="sp_year.Add(\"1402\")";
Debug.ShouldStop(1073741824);
sayer_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1402")));
 BA.debugLineNum = 64;BA.debugLine="sp_year.Add(\"1401\")";
Debug.ShouldStop(-2147483648);
sayer_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1401")));
 BA.debugLineNum = 65;BA.debugLine="sp_year.Add(\"1400\")";
Debug.ShouldStop(1);
sayer_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1400")));
 BA.debugLineNum = 66;BA.debugLine="sp_year.Add(\"1399\")";
Debug.ShouldStop(2);
sayer_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1399")));
 BA.debugLineNum = 67;BA.debugLine="sp_year.Add(\"1398\")";
Debug.ShouldStop(4);
sayer_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1398")));
 BA.debugLineNum = 69;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
Debug.ShouldStop(16);
sayer_activity.mostCurrent._sp_moon.runVoidMethod ("AddAll",(Object)(sayer_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 71;BA.debugLine="sp_year.SelectedIndex=0";
Debug.ShouldStop(64);
sayer_activity.mostCurrent._sp_year.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 BA.debugLineNum = 72;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
Debug.ShouldStop(128);
sayer_activity.mostCurrent._sp_moon.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(sayer_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianMonth"))))),RemoteObject.createImmutable(1)}, "-",1, 0)));
 BA.debugLineNum = 74;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(sp_moo";
Debug.ShouldStop(512);
_moon_num = sayer_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {sayer_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("moon_num", _moon_num);Debug.locals.put("moon_num", _moon_num);
 BA.debugLineNum = 77;BA.debugLine="fill_list_sayer(sp_year.SelectedItem,moon_num)";
Debug.ShouldStop(4096);
_fill_list_sayer(sayer_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),_moon_num);
 BA.debugLineNum = 79;BA.debugLine="pan_hed_list2.Color=Main.color4";
Debug.ShouldStop(16384);
sayer_activity.mostCurrent._pan_hed_list2.runVoidMethod ("setColor",sayer_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 80;BA.debugLine="lbl_title_edit1.Color=Main.color4";
Debug.ShouldStop(32768);
sayer_activity.mostCurrent._lbl_title_edit1.runVoidMethod ("setColor",sayer_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 85;BA.debugLine="moon_dataPik.Initialize";
Debug.ShouldStop(1048576);
sayer_activity.mostCurrent._moon_datapik.runVoidMethod ("Initialize");
 BA.debugLineNum = 86;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
Debug.ShouldStop(2097152);
sayer_activity.mostCurrent._moon_datapik.runVoidMethod ("AddAll",(Object)(sayer_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 89;BA.debugLine="sp_type_state.Add(\"اضافه شدن به دریافتی ها\")";
Debug.ShouldStop(16777216);
sayer_activity.mostCurrent._sp_type_state.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("اضافه شدن به دریافتی ها")));
 BA.debugLineNum = 90;BA.debugLine="sp_type_state.Add(\"کم شدن از دریافتی ها\")";
Debug.ShouldStop(33554432);
sayer_activity.mostCurrent._sp_type_state.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("کم شدن از دریافتی ها")));
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
		Debug.PushSubsStack("Activity_KeyPress (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,254);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 254;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 255;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, sayer_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 256;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(-2147483648);
_lbl_back_click();
 BA.debugLineNum = 257;BA.debugLine="Return True";
Debug.ShouldStop(1);
if (true) return sayer_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 259;BA.debugLine="Return False";
Debug.ShouldStop(4);
if (true) return sayer_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 261;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_Pause (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,99);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,95);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","activity_resume");}
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
		Debug.PushSubsStack("et_mablagh_edit1_TextChanged (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,397);
if (RapidSub.canDelegate("et_mablagh_edit1_textchanged")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","et_mablagh_edit1_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 397;BA.debugLine="Private Sub et_mablagh_edit1_TextChanged (Old As S";
Debug.ShouldStop(4096);
 BA.debugLineNum = 398;BA.debugLine="et_mablagh_edit1.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(8192);
sayer_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 399;BA.debugLine="myfunc.change_formater(Old,New,et_mablagh_edit1)";
Debug.ShouldStop(16384);
sayer_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(sayer_activity.mostCurrent._et_mablagh_edit1));
 BA.debugLineNum = 400;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fill_list_sayer(RemoteObject _year,RemoteObject _moon) throws Exception{
try {
		Debug.PushSubsStack("fill_list_sayer (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,104);
if (RapidSub.canDelegate("fill_list_sayer")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","fill_list_sayer", _year, _moon);}
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 104;BA.debugLine="Sub fill_list_sayer(year As String , moon As Strin";
Debug.ShouldStop(128);
 BA.debugLineNum = 107;BA.debugLine="cust_LV_sayer.Clear";
Debug.ShouldStop(1024);
sayer_activity.mostCurrent._cust_lv_sayer.runVoidMethod ("_clear");
 BA.debugLineNum = 110;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(8192);
sayer_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA);
 BA.debugLineNum = 112;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(32768);
sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), sayer_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_sayer WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' ORDER BY  date DESC;")))));
 BA.debugLineNum = 114;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(131072);
while (sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 119;BA.debugLine="p = xui2.CreatePanel(\"p\")";
Debug.ShouldStop(4194304);
sayer_activity.mostCurrent._p = sayer_activity.mostCurrent._xui2.runMethod(false,"CreatePanel",sayer_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 120;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
Debug.ShouldStop(8388608);
sayer_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),sayer_activity.mostCurrent.activityBA)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 154)))));
 BA.debugLineNum = 121;BA.debugLine="p.LoadLayout(\"item_list_list2\")";
Debug.ShouldStop(16777216);
sayer_activity.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list_list2")),sayer_activity.mostCurrent.activityBA);
 BA.debugLineNum = 123;BA.debugLine="cust_LV_sayer.Add(p,dbCode.res.GetString(\"id\"))";
Debug.ShouldStop(67108864);
sayer_activity.mostCurrent._cust_lv_sayer.runVoidMethod ("_add",(Object)(sayer_activity.mostCurrent._p),(Object)((sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 125;BA.debugLine="lbl_onvan.Text=dbCode.res.GetString(\"onvan\")";
Debug.ShouldStop(268435456);
sayer_activity.mostCurrent._lbl_onvan.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("onvan")))));
 BA.debugLineNum = 127;BA.debugLine="lbl_date.Text=dbCode.res.GetString(\"date\")";
Debug.ShouldStop(1073741824);
sayer_activity.mostCurrent._lbl_date.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")))));
 BA.debugLineNum = 128;BA.debugLine="lbl_mablagh.Tag=dbCode.res.GetString(\"mablagh\")";
Debug.ShouldStop(-2147483648);
sayer_activity.mostCurrent._lbl_mablagh.runMethod(false,"setTag",(sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh")))));
 BA.debugLineNum = 129;BA.debugLine="lbl_mablagh.Text=myfunc.show_num_pool(lbl_mablag";
Debug.ShouldStop(1);
sayer_activity.mostCurrent._lbl_mablagh.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, sayer_activity.mostCurrent._lbl_mablagh.runMethod(false,"getTag"))))));
 BA.debugLineNum = 133;BA.debugLine="If(dbCode.res.GetString(\"state\")) =1 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",(sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state")))),BA.NumberToString(1))) { 
 BA.debugLineNum = 134;BA.debugLine="lbl_icon.Text=Chr(0xF271)  'plus";
Debug.ShouldStop(32);
sayer_activity.mostCurrent._lbl_icon.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf271))))));
 BA.debugLineNum = 135;BA.debugLine="lbl_icon.Color=Colors.Green";
Debug.ShouldStop(64);
sayer_activity.mostCurrent._lbl_icon.runVoidMethod ("setColor",sayer_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 }else {
 BA.debugLineNum = 137;BA.debugLine="lbl_icon.Text=Chr(0xF272)  'minus";
Debug.ShouldStop(256);
sayer_activity.mostCurrent._lbl_icon.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf272))))));
 BA.debugLineNum = 138;BA.debugLine="lbl_icon.Color=Colors.Red";
Debug.ShouldStop(512);
sayer_activity.mostCurrent._lbl_icon.runVoidMethod ("setColor",sayer_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 };
 BA.debugLineNum = 144;BA.debugLine="lbl_tozih.Text=dbCode.res.GetString(\"tozihat\")";
Debug.ShouldStop(32768);
sayer_activity.mostCurrent._lbl_tozih.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 148;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
Debug.ShouldStop(524288);
sayer_activity.mostCurrent._lbl_remove_from_list.runMethod(false,"setTag",(sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 149;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
Debug.ShouldStop(1048576);
sayer_activity.mostCurrent._lbl_edit_from_list.runMethod(false,"setTag",(sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 }
;
 BA.debugLineNum = 156;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(134217728);
sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 157;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(268435456);
sayer_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 159;BA.debugLine="If(cust_LV_sayer.LastVisibleIndex<5)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("<",sayer_activity.mostCurrent._cust_lv_sayer.runMethod(true,"_getlastvisibleindex"),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 160;BA.debugLine="p = xui2.CreatePanel(\"p\")";
Debug.ShouldStop(-2147483648);
sayer_activity.mostCurrent._p = sayer_activity.mostCurrent._xui2.runMethod(false,"CreatePanel",sayer_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 161;BA.debugLine="Select cust_LV_sayer.LastVisibleIndex";
Debug.ShouldStop(1);
switch (BA.switchObjectToInt(sayer_activity.mostCurrent._cust_lv_sayer.runMethod(true,"_getlastvisibleindex"),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 163;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
Debug.ShouldStop(4);
sayer_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),sayer_activity.mostCurrent.activityBA)),(Object)((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(380),RemoteObject.createImmutable(100)}, "-",1, 1))));
 break; }
case 1: {
 BA.debugLineNum = 165;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
Debug.ShouldStop(16);
sayer_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),sayer_activity.mostCurrent.activityBA)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400)))));
 break; }
case 2: {
 BA.debugLineNum = 167;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
Debug.ShouldStop(64);
sayer_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),sayer_activity.mostCurrent.activityBA)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 break; }
case 3: {
 BA.debugLineNum = 169;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
Debug.ShouldStop(256);
sayer_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),sayer_activity.mostCurrent.activityBA)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 break; }
case 4: {
 BA.debugLineNum = 171;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
Debug.ShouldStop(1024);
sayer_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),sayer_activity.mostCurrent.activityBA)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 break; }
case 5: {
 BA.debugLineNum = 173;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
Debug.ShouldStop(4096);
sayer_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),sayer_activity.mostCurrent.activityBA)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 break; }
}
;
 BA.debugLineNum = 175;BA.debugLine="cust_LV_sayer.Add(p,\"\")";
Debug.ShouldStop(16384);
sayer_activity.mostCurrent._cust_lv_sayer.runVoidMethod ("_add",(Object)(sayer_activity.mostCurrent._p),(Object)((RemoteObject.createImmutable(""))));
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
public static RemoteObject  _fill_list_sayer2(RemoteObject _year,RemoteObject _moon) throws Exception{
try {
		Debug.PushSubsStack("fill_list_sayer2 (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,183);
if (RapidSub.canDelegate("fill_list_sayer2")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","fill_list_sayer2", _year, _moon);}
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 183;BA.debugLine="Sub fill_list_sayer2(year As String , moon As Stri";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 186;BA.debugLine="cust_LV_sayer.Clear";
Debug.ShouldStop(33554432);
sayer_activity.mostCurrent._cust_lv_sayer.runVoidMethod ("_clear");
 BA.debugLineNum = 189;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(268435456);
sayer_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA);
 BA.debugLineNum = 190;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(536870912);
sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), sayer_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_sayer WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' ORDER BY  date DESC;")))));
 BA.debugLineNum = 193;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(1);
while (sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 198;BA.debugLine="p = xui2.CreatePanel(\"p\")";
Debug.ShouldStop(32);
sayer_activity.mostCurrent._p = sayer_activity.mostCurrent._xui2.runMethod(false,"CreatePanel",sayer_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 199;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
Debug.ShouldStop(64);
sayer_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),sayer_activity.mostCurrent.activityBA)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 154)))));
 BA.debugLineNum = 200;BA.debugLine="p.LoadLayout(\"item_list_list2\")";
Debug.ShouldStop(128);
sayer_activity.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list_list2")),sayer_activity.mostCurrent.activityBA);
 BA.debugLineNum = 202;BA.debugLine="cust_LV_sayer.Add(p,dbCode.res.GetString(\"id\"))";
Debug.ShouldStop(512);
sayer_activity.mostCurrent._cust_lv_sayer.runVoidMethod ("_add",(Object)(sayer_activity.mostCurrent._p),(Object)((sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 204;BA.debugLine="lbl_onvan.Text=dbCode.res.GetString(\"onvan\")";
Debug.ShouldStop(2048);
sayer_activity.mostCurrent._lbl_onvan.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("onvan")))));
 BA.debugLineNum = 206;BA.debugLine="lbl_date.Text=dbCode.res.GetString(\"date\")";
Debug.ShouldStop(8192);
sayer_activity.mostCurrent._lbl_date.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")))));
 BA.debugLineNum = 207;BA.debugLine="lbl_mablagh.Tag=dbCode.res.GetString(\"mablagh\")";
Debug.ShouldStop(16384);
sayer_activity.mostCurrent._lbl_mablagh.runMethod(false,"setTag",(sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh")))));
 BA.debugLineNum = 208;BA.debugLine="lbl_mablagh.Text=myfunc.show_num_pool(lbl_mablag";
Debug.ShouldStop(32768);
sayer_activity.mostCurrent._lbl_mablagh.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, sayer_activity.mostCurrent._lbl_mablagh.runMethod(false,"getTag"))))));
 BA.debugLineNum = 210;BA.debugLine="lbl_tozih.Text=dbCode.res.GetString(\"tozihat\")";
Debug.ShouldStop(131072);
sayer_activity.mostCurrent._lbl_tozih.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 212;BA.debugLine="lbl_icon.Text=Chr(0xF274)  'def";
Debug.ShouldStop(524288);
sayer_activity.mostCurrent._lbl_icon.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf274))))));
 BA.debugLineNum = 213;BA.debugLine="lbl_icon.Color=0xFF00A3FF";
Debug.ShouldStop(1048576);
sayer_activity.mostCurrent._lbl_icon.runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xff00a3ff)));
 BA.debugLineNum = 215;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
Debug.ShouldStop(4194304);
sayer_activity.mostCurrent._lbl_remove_from_list.runMethod(false,"setTag",(sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 216;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
Debug.ShouldStop(8388608);
sayer_activity.mostCurrent._lbl_edit_from_list.runMethod(false,"setTag",(sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 }
;
 BA.debugLineNum = 223;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(1073741824);
sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 224;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(-2147483648);
sayer_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 226;BA.debugLine="If(cust_LV_sayer.LastVisibleIndex<5)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("<",sayer_activity.mostCurrent._cust_lv_sayer.runMethod(true,"_getlastvisibleindex"),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 227;BA.debugLine="p = xui2.CreatePanel(\"p\")";
Debug.ShouldStop(4);
sayer_activity.mostCurrent._p = sayer_activity.mostCurrent._xui2.runMethod(false,"CreatePanel",sayer_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 228;BA.debugLine="Select cust_LV_sayer.LastVisibleIndex";
Debug.ShouldStop(8);
switch (BA.switchObjectToInt(sayer_activity.mostCurrent._cust_lv_sayer.runMethod(true,"_getlastvisibleindex"),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 230;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
Debug.ShouldStop(32);
sayer_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),sayer_activity.mostCurrent.activityBA)),(Object)((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(380),RemoteObject.createImmutable(100)}, "-",1, 1))));
 break; }
case 1: {
 BA.debugLineNum = 232;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
Debug.ShouldStop(128);
sayer_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),sayer_activity.mostCurrent.activityBA)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400)))));
 break; }
case 2: {
 BA.debugLineNum = 234;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
Debug.ShouldStop(512);
sayer_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),sayer_activity.mostCurrent.activityBA)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 break; }
case 3: {
 BA.debugLineNum = 236;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
Debug.ShouldStop(2048);
sayer_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),sayer_activity.mostCurrent.activityBA)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 break; }
case 4: {
 BA.debugLineNum = 238;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
Debug.ShouldStop(8192);
sayer_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),sayer_activity.mostCurrent.activityBA)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 break; }
case 5: {
 BA.debugLineNum = 240;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
Debug.ShouldStop(32768);
sayer_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),sayer_activity.mostCurrent.activityBA)),(Object)(sayer_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 break; }
}
;
 BA.debugLineNum = 242;BA.debugLine="cust_LV_sayer.Add(p,\"\")";
Debug.ShouldStop(131072);
sayer_activity.mostCurrent._cust_lv_sayer.runVoidMethod ("_add",(Object)(sayer_activity.mostCurrent._p),(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 246;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
sayer_activity.mostCurrent._xui2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 17;BA.debugLine="Dim p As B4XView";
sayer_activity.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private pan_hed_list2 As Panel";
sayer_activity.mostCurrent._pan_hed_list2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private pik_day1 As Label";
sayer_activity.mostCurrent._pik_day1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private pik_moon1 As Label";
sayer_activity.mostCurrent._pik_moon1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private pik_year1 As Label";
sayer_activity.mostCurrent._pik_year1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim num_dataPik As Int=0  '' for time picker";
sayer_activity._num_datapik = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 28;BA.debugLine="Dim moon_dataPik As List  '' for date picker";
sayer_activity.mostCurrent._moon_datapik = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 30;BA.debugLine="Private lbl_onvan As Label";
sayer_activity.mostCurrent._lbl_onvan = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private lbl_date As Label";
sayer_activity.mostCurrent._lbl_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private lbl_mablagh As Label";
sayer_activity.mostCurrent._lbl_mablagh = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private lbl_edit_from_list As Label";
sayer_activity.mostCurrent._lbl_edit_from_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private lbl_remove_from_list As Label";
sayer_activity.mostCurrent._lbl_remove_from_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private lbl_tozih As Label";
sayer_activity.mostCurrent._lbl_tozih = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private Panel1 As Panel";
sayer_activity.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private cust_LV_sayer As CustomListView";
sayer_activity.mostCurrent._cust_lv_sayer = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 38;BA.debugLine="Private pan_all_edit1 As Panel";
sayer_activity.mostCurrent._pan_all_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private pan_all_set_date As Panel";
sayer_activity.mostCurrent._pan_all_set_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private lbl_title_edit1 As Label";
sayer_activity.mostCurrent._lbl_title_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private et_onvan_edit1 As EditText";
sayer_activity.mostCurrent._et_onvan_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private lbl_date_edit1 As Label";
sayer_activity.mostCurrent._lbl_date_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private et_mablagh_edit1 As EditText";
sayer_activity.mostCurrent._et_mablagh_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private et_tozih_edit1 As EditText";
sayer_activity.mostCurrent._et_tozih_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Dim index_current_pan As Int";
sayer_activity._index_current_pan = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 46;BA.debugLine="Dim current_itemId_edit As Int";
sayer_activity._current_itemid_edit = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 48;BA.debugLine="Private sp_moon As Spinner";
sayer_activity.mostCurrent._sp_moon = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private sp_year As Spinner";
sayer_activity.mostCurrent._sp_year = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private lbl_icon As Label";
sayer_activity.mostCurrent._lbl_icon = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private sp_type_state As Spinner";
sayer_activity.mostCurrent._sp_type_state = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private lbl_sp_type As Label";
sayer_activity.mostCurrent._lbl_sp_type = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Dim addEdit_id As Int=0";
sayer_activity._addedit_id = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _item_edit_box_mod(RemoteObject _title,RemoteObject _onvan,RemoteObject _date,RemoteObject _mablage,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("item_edit_box_mod (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,308);
if (RapidSub.canDelegate("item_edit_box_mod")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","item_edit_box_mod", _title, _onvan, _date, _mablage, _tozih, _state);}
Debug.locals.put("title", _title);
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablage", _mablage);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 308;BA.debugLine="Sub item_edit_box_mod(title As String,onvan As Str";
Debug.ShouldStop(524288);
 BA.debugLineNum = 310;BA.debugLine="If(addEdit_id=1)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",sayer_activity._addedit_id,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 311;BA.debugLine="If(state=1)Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",_state,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 312;BA.debugLine="sp_type_state.SelectedIndex=0";
Debug.ShouldStop(8388608);
sayer_activity.mostCurrent._sp_type_state.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 }else {
 BA.debugLineNum = 314;BA.debugLine="sp_type_state.SelectedIndex=1";
Debug.ShouldStop(33554432);
sayer_activity.mostCurrent._sp_type_state.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 1));
 };
 }else {
 BA.debugLineNum = 318;BA.debugLine="sp_type_state.SelectedIndex=0";
Debug.ShouldStop(536870912);
sayer_activity.mostCurrent._sp_type_state.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 };
 BA.debugLineNum = 321;BA.debugLine="lbl_title_edit1.Text=title";
Debug.ShouldStop(1);
sayer_activity.mostCurrent._lbl_title_edit1.runMethod(true,"setText",BA.ObjectToCharSequence(_title));
 BA.debugLineNum = 322;BA.debugLine="et_onvan_edit1.Text=onvan";
Debug.ShouldStop(2);
sayer_activity.mostCurrent._et_onvan_edit1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_onvan));
 BA.debugLineNum = 323;BA.debugLine="lbl_date_edit1.Text=myfunc.fa2en(date)";
Debug.ShouldStop(4);
sayer_activity.mostCurrent._lbl_date_edit1.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(_date))));
 BA.debugLineNum = 324;BA.debugLine="et_mablagh_edit1.Tag=mablage";
Debug.ShouldStop(8);
sayer_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"setTag",(_mablage));
 BA.debugLineNum = 325;BA.debugLine="et_mablagh_edit1.Text=myfunc.show_num_pool(mablag";
Debug.ShouldStop(16);
sayer_activity.mostCurrent._et_mablagh_edit1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _mablage)))));
 BA.debugLineNum = 327;BA.debugLine="et_tozih_edit1.Text=tozih";
Debug.ShouldStop(64);
sayer_activity.mostCurrent._et_tozih_edit1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_tozih));
 BA.debugLineNum = 330;BA.debugLine="pan_all_edit1.Visible=True";
Debug.ShouldStop(512);
sayer_activity.mostCurrent._pan_all_edit1.runMethod(true,"setVisible",sayer_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 332;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_edit1.Text.S";
Debug.ShouldStop(2048);
sayer_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4)))))));
 BA.debugLineNum = 333;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_edit1.Text.Su";
Debug.ShouldStop(4096);
sayer_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7)))))));
 BA.debugLineNum = 334;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(8192);
sayer_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 335;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_edit1.Text.Su";
Debug.ShouldStop(16384);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 10)))))));
 BA.debugLineNum = 340;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_add_sayer_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_add_sayer_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,626);
if (RapidSub.canDelegate("lbl_add_sayer_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","lbl_add_sayer_click");}
 BA.debugLineNum = 626;BA.debugLine="Private Sub lbl_add_sayer_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 628;BA.debugLine="addEdit_id=0";
Debug.ShouldStop(524288);
sayer_activity._addedit_id = BA.numberCast(int.class, 0);
 BA.debugLineNum = 631;BA.debugLine="item_edit_box_mod(\"ثبت سایر\",\"\",myfunc.fa2en(Main";
Debug.ShouldStop(4194304);
_item_edit_box_mod(BA.ObjectToString("ثبت سایر"),BA.ObjectToString(""),sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianShortDate"))),BA.ObjectToString("0"),BA.ObjectToString(""),BA.numberCast(int.class, 0));
 BA.debugLineNum = 632;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("lbl_back_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,250);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","lbl_back_click");}
 BA.debugLineNum = 250;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 251;BA.debugLine="Activity.Finish";
Debug.ShouldStop(67108864);
sayer_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 252;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("lbl_date_edit1_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,391);
if (RapidSub.canDelegate("lbl_date_edit1_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","lbl_date_edit1_click");}
 BA.debugLineNum = 391;BA.debugLine="Private Sub lbl_date_edit1_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 392;BA.debugLine="pan_all_set_date.Visible=True";
Debug.ShouldStop(128);
sayer_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",sayer_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 393;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("lbl_edit_from_list_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,289);
if (RapidSub.canDelegate("lbl_edit_from_list_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","lbl_edit_from_list_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 289;BA.debugLine="Private Sub lbl_edit_from_list_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 290;BA.debugLine="Dim b As Label";
Debug.ShouldStop(2);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 291;BA.debugLine="b = Sender";
Debug.ShouldStop(4);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), sayer_activity.mostCurrent.__c.runMethod(false,"Sender",sayer_activity.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 293;BA.debugLine="addEdit_id=1";
Debug.ShouldStop(16);
sayer_activity._addedit_id = BA.numberCast(int.class, 1);
 BA.debugLineNum = 294;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(32);
sayer_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA);
 BA.debugLineNum = 296;BA.debugLine="index_current_pan=3";
Debug.ShouldStop(128);
sayer_activity._index_current_pan = BA.numberCast(int.class, 3);
 BA.debugLineNum = 297;BA.debugLine="current_itemId_edit=b.Tag";
Debug.ShouldStop(256);
sayer_activity._current_itemid_edit = BA.numberCast(int.class, _b.runMethod(false,"getTag"));
 BA.debugLineNum = 298;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(512);
sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), sayer_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_sayer WHERE id="),sayer_activity._current_itemid_edit))));
 BA.debugLineNum = 299;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(1024);
sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 301;BA.debugLine="item_edit_box_mod(\"ویرایش\",dbCode.res.GetString(\"";
Debug.ShouldStop(4096);
_item_edit_box_mod(BA.ObjectToString("ویرایش"),sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("onvan"))),sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date"))),sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))),sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat"))),BA.numberCast(int.class, sayer_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state")))));
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
public static RemoteObject  _lbl_remove_from_list_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_remove_from_list_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,263);
if (RapidSub.canDelegate("lbl_remove_from_list_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","lbl_remove_from_list_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 263;BA.debugLine="Private Sub lbl_remove_from_list_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 265;BA.debugLine="Dim b As Label";
Debug.ShouldStop(256);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 266;BA.debugLine="b = Sender";
Debug.ShouldStop(512);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), sayer_activity.mostCurrent.__c.runMethod(false,"Sender",sayer_activity.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 269;BA.debugLine="Dim result As Int";
Debug.ShouldStop(4096);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 270;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
Debug.ShouldStop(8192);
_result = sayer_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا این مورد حذف شود؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((sayer_activity.mostCurrent.__c.getField(false,"Null"))),sayer_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 271;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, sayer_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 273;BA.debugLine="If (dbCode.delete_sayer(b.Tag))Then";
Debug.ShouldStop(65536);
if ((sayer_activity.mostCurrent._dbcode.runMethod(true,"_delete_sayer" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 274;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
Debug.ShouldStop(131072);
sayer_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد.")),(Object)(sayer_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 277;BA.debugLine="fill_list_sayer(sp_year.SelectedItem,myfunc.con";
Debug.ShouldStop(1048576);
_fill_list_sayer(sayer_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),sayer_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {sayer_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 };
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
public static RemoteObject  _lbl_save_edit1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_edit1_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,357);
if (RapidSub.canDelegate("lbl_save_edit1_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","lbl_save_edit1_click");}
 BA.debugLineNum = 357;BA.debugLine="Private Sub lbl_save_edit1_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 359;BA.debugLine="If(et_onvan_edit1.Text=\"\")Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",sayer_activity.mostCurrent._et_onvan_edit1.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 360;BA.debugLine="ToastMessageShow(\"عنوان خالی است!\",False)";
Debug.ShouldStop(128);
sayer_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("عنوان خالی است!")),(Object)(sayer_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 361;BA.debugLine="Else If(et_mablagh_edit1.Tag=\"\")Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",sayer_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"getTag"),(RemoteObject.createImmutable(""))))) { 
 BA.debugLineNum = 362;BA.debugLine="ToastMessageShow(\"مبلغ خالی است!\",False)";
Debug.ShouldStop(512);
sayer_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("مبلغ خالی است!")),(Object)(sayer_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 365;BA.debugLine="If(addEdit_id=0)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",sayer_activity._addedit_id,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 367;BA.debugLine="If(sp_type_state.SelectedIndex=0)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",sayer_activity.mostCurrent._sp_type_state.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 368;BA.debugLine="dbCode.add_sayer(et_onvan_edit1.Text,lbl_date_";
Debug.ShouldStop(32768);
sayer_activity.mostCurrent._dbcode.runVoidMethod ("_add_sayer" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity.mostCurrent._et_onvan_edit1.runMethod(true,"getText")),(Object)(sayer_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText")),(Object)(BA.ObjectToString(sayer_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"getTag"))),(Object)(sayer_activity.mostCurrent._et_tozih_edit1.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 1)));
 }else {
 BA.debugLineNum = 370;BA.debugLine="dbCode.add_sayer(et_onvan_edit1.Text,lbl_date_";
Debug.ShouldStop(131072);
sayer_activity.mostCurrent._dbcode.runVoidMethod ("_add_sayer" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity.mostCurrent._et_onvan_edit1.runMethod(true,"getText")),(Object)(sayer_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText")),(Object)(BA.ObjectToString(sayer_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"getTag"))),(Object)(sayer_activity.mostCurrent._et_tozih_edit1.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 2)));
 };
 BA.debugLineNum = 372;BA.debugLine="ToastMessageShow(\"اضافه شد\",False)";
Debug.ShouldStop(524288);
sayer_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(sayer_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 373;BA.debugLine="Else If(addEdit_id=1)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",sayer_activity._addedit_id,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 374;BA.debugLine="If(sp_type_state.SelectedIndex=0)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",sayer_activity.mostCurrent._sp_type_state.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 375;BA.debugLine="dbCode.edit_sayer(current_itemId_edit,et_onvan";
Debug.ShouldStop(4194304);
sayer_activity.mostCurrent._dbcode.runVoidMethod ("_edit_sayer" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity._current_itemid_edit),(Object)(sayer_activity.mostCurrent._et_onvan_edit1.runMethod(true,"getText")),(Object)(sayer_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText")),(Object)(BA.ObjectToString(sayer_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"getTag"))),(Object)(sayer_activity.mostCurrent._et_tozih_edit1.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 1)));
 }else {
 BA.debugLineNum = 377;BA.debugLine="dbCode.edit_sayer(current_itemId_edit,et_onvan";
Debug.ShouldStop(16777216);
sayer_activity.mostCurrent._dbcode.runVoidMethod ("_edit_sayer" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity._current_itemid_edit),(Object)(sayer_activity.mostCurrent._et_onvan_edit1.runMethod(true,"getText")),(Object)(sayer_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText")),(Object)(BA.ObjectToString(sayer_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"getTag"))),(Object)(sayer_activity.mostCurrent._et_tozih_edit1.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 2)));
 };
 BA.debugLineNum = 380;BA.debugLine="ToastMessageShow(\"ویرایش شد\",False)";
Debug.ShouldStop(134217728);
sayer_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ویرایش شد")),(Object)(sayer_activity.mostCurrent.__c.getField(true,"False")));
 }}
;
 BA.debugLineNum = 386;BA.debugLine="fill_list_sayer(sp_year.SelectedItem,myfunc.conv";
Debug.ShouldStop(2);
_fill_list_sayer(sayer_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),sayer_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {sayer_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 BA.debugLineNum = 387;BA.debugLine="pan_all_edit1.Visible=False";
Debug.ShouldStop(4);
sayer_activity.mostCurrent._pan_all_edit1.runMethod(true,"setVisible",sayer_activity.mostCurrent.__c.getField(true,"False"));
 }}
;
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
public static RemoteObject  _lbl_save_picker_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_picker_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,404);
if (RapidSub.canDelegate("lbl_save_picker_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","lbl_save_picker_click");}
 BA.debugLineNum = 404;BA.debugLine="Private Sub lbl_save_picker_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 405;BA.debugLine="lbl_date_edit1.Text=pik_year1.Text&\"/\"&myfunc.con";
Debug.ShouldStop(1048576);
sayer_activity.mostCurrent._lbl_date_edit1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(sayer_activity.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),sayer_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))),RemoteObject.createImmutable("/"),sayer_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText")))))));
 BA.debugLineNum = 406;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(2097152);
sayer_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",sayer_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 407;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("pan_all_edit1_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,344);
if (RapidSub.canDelegate("pan_all_edit1_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","pan_all_edit1_click");}
 BA.debugLineNum = 344;BA.debugLine="Private Sub pan_all_edit1_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 345;BA.debugLine="pan_all_edit1.Visible=False";
Debug.ShouldStop(16777216);
sayer_activity.mostCurrent._pan_all_edit1.runMethod(true,"setVisible",sayer_activity.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _pan_all_set_date_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_set_date_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,352);
if (RapidSub.canDelegate("pan_all_set_date_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","pan_all_set_date_click");}
 BA.debugLineNum = 352;BA.debugLine="Private Sub pan_all_set_date_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 353;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(1);
sayer_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",sayer_activity.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _panel4_click() throws Exception{
try {
		Debug.PushSubsStack("Panel4_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,348);
if (RapidSub.canDelegate("panel4_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","panel4_click");}
 BA.debugLineNum = 348;BA.debugLine="Private Sub Panel4_Click";
Debug.ShouldStop(134217728);
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
public static RemoteObject  _pik_day_bala1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_day_bala1_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,565);
if (RapidSub.canDelegate("pik_day_bala1_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","pik_day_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 565;BA.debugLine="Private Sub pik_day_bala1_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 566;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(2097152);
_int1 = BA.numberCast(int.class, sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 567;BA.debugLine="pik_day1.Text=int1+1";
Debug.ShouldStop(4194304);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 570;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 571;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 572;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(134217728);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 574;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 575;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(1073741824);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 578;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 579;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(4);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 581;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 582;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(32);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 585;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
Debug.ShouldStop(256);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText"))))));
 BA.debugLineNum = 586;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("pik_day_paeen1_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,588);
if (RapidSub.canDelegate("pik_day_paeen1_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","pik_day_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 588;BA.debugLine="Private Sub pik_day_paeen1_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 589;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(4096);
_int1 = BA.numberCast(int.class, sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 590;BA.debugLine="pik_day1.Text=int1-1";
Debug.ShouldStop(8192);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 591;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 592;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 593;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(65536);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 595;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 596;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(524288);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 599;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 600;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(8388608);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 602;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 603;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(67108864);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 606;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
Debug.ShouldStop(536870912);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText"))))));
 BA.debugLineNum = 607;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("pik_moon_bala1_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,511);
if (RapidSub.canDelegate("pik_moon_bala1_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","pik_moon_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 511;BA.debugLine="Private Sub pik_moon_bala1_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 512;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(-2147483648);
_int1 = BA.numberCast(int.class, sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 513;BA.debugLine="pik_moon1.Tag=int1+1";
Debug.ShouldStop(1);
sayer_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 515;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 516;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(8);
sayer_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 518;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 519;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(64);
sayer_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 521;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(256);
sayer_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 523;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("pik_moon_paeen1_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,525);
if (RapidSub.canDelegate("pik_moon_paeen1_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","pik_moon_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 525;BA.debugLine="Private Sub pik_moon_paeen1_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 526;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(8192);
_int1 = BA.numberCast(int.class, sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 527;BA.debugLine="pik_moon1.Tag=int1-1";
Debug.ShouldStop(16384);
sayer_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 529;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 530;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(131072);
sayer_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 532;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 533;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(1048576);
sayer_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 535;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
Debug.ShouldStop(4194304);
sayer_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 537;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("pik_pan_day1_Touch (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,471);
if (RapidSub.canDelegate("pik_pan_day1_touch")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","pik_pan_day1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 471;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 472;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 473;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(16777216);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 474;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(33554432);
sayer_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 477;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 479;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {sayer_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 480;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
Debug.ShouldStop(-2147483648);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 481;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(1);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 482;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(2);
sayer_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 484;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {sayer_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 485;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
Debug.ShouldStop(16);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 486;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(32);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 487;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(64);
sayer_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 490;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 491;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 492;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(2048);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 494;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 495;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(16384);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 498;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 499;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(262144);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 501;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 502;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(2097152);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 505;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
Debug.ShouldStop(16777216);
sayer_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, sayer_activity.mostCurrent._pik_day1.runMethod(true,"getText"))))));
 };
 BA.debugLineNum = 509;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("pik_pan_moon1_Touch (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,411);
if (RapidSub.canDelegate("pik_pan_moon1_touch")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","pik_pan_moon1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 411;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 412;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 413;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(268435456);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 414;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(536870912);
sayer_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 417;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 419;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {sayer_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 420;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
Debug.ShouldStop(8);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 421;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(16);
sayer_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 422;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(32);
sayer_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 424;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {sayer_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 425;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
Debug.ShouldStop(256);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 426;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(512);
sayer_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 427;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(1024);
sayer_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 430;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 431;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(16384);
sayer_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 433;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 434;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(131072);
sayer_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 436;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(524288);
sayer_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(sayer_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, sayer_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
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
public static RemoteObject  _pik_pan_year1_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("pik_pan_year1_Touch (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,441);
if (RapidSub.canDelegate("pik_pan_year1_touch")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","pik_pan_year1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 441;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 442;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 443;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(67108864);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 444;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(134217728);
sayer_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 447;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 449;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {sayer_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 450;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
Debug.ShouldStop(2);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 451;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(4);
sayer_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 452;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(8);
sayer_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 454;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {sayer_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 455;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
Debug.ShouldStop(64);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 456;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(128);
sayer_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 457;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(256);
sayer_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 460;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 461;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(4096);
sayer_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 463;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 464;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(32768);
sayer_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 };
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
public static RemoteObject  _pik_year_bala1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_year_bala1_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,539);
if (RapidSub.canDelegate("pik_year_bala1_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","pik_year_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 539;BA.debugLine="Private Sub pik_year_bala1_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 540;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(134217728);
_int1 = BA.numberCast(int.class, sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 541;BA.debugLine="pik_year1.Text=int1+1";
Debug.ShouldStop(268435456);
sayer_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 543;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 544;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(-2147483648);
sayer_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 546;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 547;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(4);
sayer_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 550;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("pik_year_paeen1_Click (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,552);
if (RapidSub.canDelegate("pik_year_paeen1_click")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","pik_year_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 552;BA.debugLine="Private Sub pik_year_paeen1_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 553;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(256);
_int1 = BA.numberCast(int.class, sayer_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(sayer_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 554;BA.debugLine="pik_year1.Text=int1-1";
Debug.ShouldStop(512);
sayer_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 556;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 557;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(4096);
sayer_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 559;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, sayer_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 560;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(32768);
sayer_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 563;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("sp_moon_ItemClick (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,620);
if (RapidSub.canDelegate("sp_moon_itemclick")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","sp_moon_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 620;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
Debug.ShouldStop(2048);
 BA.debugLineNum = 622;BA.debugLine="fill_list_sayer(sp_year.SelectedItem,myfunc.conve";
Debug.ShouldStop(8192);
_fill_list_sayer(sayer_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),sayer_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {sayer_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 BA.debugLineNum = 624;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("sp_year_ItemClick (sayer_activity) ","sayer_activity",24,sayer_activity.mostCurrent.activityBA,sayer_activity.mostCurrent,612);
if (RapidSub.canDelegate("sp_year_itemclick")) { return ir.taravatgroup.ezafekari2.sayer_activity.remoteMe.runUserSub(false, "sayer_activity","sp_year_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 612;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
Debug.ShouldStop(8);
 BA.debugLineNum = 614;BA.debugLine="fill_list_sayer(sp_year.SelectedItem,myfunc.conve";
Debug.ShouldStop(32);
_fill_list_sayer(sayer_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),sayer_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,sayer_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {sayer_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 BA.debugLineNum = 618;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}