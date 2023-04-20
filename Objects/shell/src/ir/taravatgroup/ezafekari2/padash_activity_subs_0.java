package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class padash_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,57);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","activity_create", _firsttime);}
RemoteObject _moon_num = RemoteObject.createImmutable("");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 57;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 59;BA.debugLine="Activity.LoadLayout(\"padash_layout\")";
Debug.ShouldStop(67108864);
padash_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("padash_layout")),padash_activity.mostCurrent.activityBA);
 BA.debugLineNum = 61;BA.debugLine="sp_year.Add(\"1402\")";
Debug.ShouldStop(268435456);
padash_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1402")));
 BA.debugLineNum = 62;BA.debugLine="sp_year.Add(\"1401\")";
Debug.ShouldStop(536870912);
padash_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1401")));
 BA.debugLineNum = 63;BA.debugLine="sp_year.Add(\"1400\")";
Debug.ShouldStop(1073741824);
padash_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1400")));
 BA.debugLineNum = 64;BA.debugLine="sp_year.Add(\"1399\")";
Debug.ShouldStop(-2147483648);
padash_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1399")));
 BA.debugLineNum = 65;BA.debugLine="sp_year.Add(\"1398\")";
Debug.ShouldStop(1);
padash_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1398")));
 BA.debugLineNum = 67;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
Debug.ShouldStop(4);
padash_activity.mostCurrent._sp_moon.runVoidMethod ("AddAll",(Object)(padash_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 69;BA.debugLine="sp_year.SelectedIndex=0";
Debug.ShouldStop(16);
padash_activity.mostCurrent._sp_year.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 BA.debugLineNum = 70;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
Debug.ShouldStop(32);
padash_activity.mostCurrent._sp_moon.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(padash_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianMonth"))))),RemoteObject.createImmutable(1)}, "-",1, 0)));
 BA.debugLineNum = 72;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(sp_moo";
Debug.ShouldStop(128);
_moon_num = padash_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {padash_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("moon_num", _moon_num);Debug.locals.put("moon_num", _moon_num);
 BA.debugLineNum = 75;BA.debugLine="fill_list_padash(sp_year.SelectedItem,moon_num)";
Debug.ShouldStop(1024);
_fill_list_padash(padash_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),_moon_num);
 BA.debugLineNum = 77;BA.debugLine="pan_hed_list2.Color=Main.color4";
Debug.ShouldStop(4096);
padash_activity.mostCurrent._pan_hed_list2.runVoidMethod ("setColor",padash_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 78;BA.debugLine="lbl_title_edit1.Color=Main.color4";
Debug.ShouldStop(8192);
padash_activity.mostCurrent._lbl_title_edit1.runVoidMethod ("setColor",padash_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 83;BA.debugLine="moon_dataPik.Initialize";
Debug.ShouldStop(262144);
padash_activity.mostCurrent._moon_datapik.runVoidMethod ("Initialize");
 BA.debugLineNum = 84;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
Debug.ShouldStop(524288);
padash_activity.mostCurrent._moon_datapik.runVoidMethod ("AddAll",(Object)(padash_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 87;BA.debugLine="sp_type_state.Add(\"اضافه شدن به دریافتی ها\")";
Debug.ShouldStop(4194304);
padash_activity.mostCurrent._sp_type_state.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("اضافه شدن به دریافتی ها")));
 BA.debugLineNum = 88;BA.debugLine="sp_type_state.Add(\"کم شدن از دریافتی ها\")";
Debug.ShouldStop(8388608);
padash_activity.mostCurrent._sp_type_state.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("کم شدن از دریافتی ها")));
 BA.debugLineNum = 91;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("Activity_KeyPress (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,174);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 174;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(8192);
 BA.debugLineNum = 175;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, padash_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 176;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(32768);
_lbl_back_click();
 BA.debugLineNum = 177;BA.debugLine="Return True";
Debug.ShouldStop(65536);
if (true) return padash_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 179;BA.debugLine="Return False";
Debug.ShouldStop(262144);
if (true) return padash_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 181;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("Activity_Pause (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,97);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 97;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Activity_Resume (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,93);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","activity_resume");}
 BA.debugLineNum = 93;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("et_mablagh_edit1_TextChanged (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,305);
if (RapidSub.canDelegate("et_mablagh_edit1_textchanged")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","et_mablagh_edit1_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 305;BA.debugLine="Private Sub et_mablagh_edit1_TextChanged (Old As S";
Debug.ShouldStop(65536);
 BA.debugLineNum = 306;BA.debugLine="et_mablagh_edit1.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(131072);
padash_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 307;BA.debugLine="myfunc.change_formater(Old,New,et_mablagh_edit1)";
Debug.ShouldStop(262144);
padash_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(padash_activity.mostCurrent._et_mablagh_edit1));
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
public static RemoteObject  _fill_list_padash(RemoteObject _year,RemoteObject _moon) throws Exception{
try {
		Debug.PushSubsStack("fill_list_padash (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,103);
if (RapidSub.canDelegate("fill_list_padash")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","fill_list_padash", _year, _moon);}
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 103;BA.debugLine="Sub fill_list_padash(year As String , moon As Stri";
Debug.ShouldStop(64);
 BA.debugLineNum = 106;BA.debugLine="cust_LV_padash.Clear";
Debug.ShouldStop(512);
padash_activity.mostCurrent._cust_lv_padash.runVoidMethod ("_clear");
 BA.debugLineNum = 109;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(4096);
padash_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA);
 BA.debugLineNum = 110;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(8192);
padash_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), padash_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_padash WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' ORDER BY  date DESC;")))));
 BA.debugLineNum = 113;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(65536);
while (padash_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 118;BA.debugLine="p = xui2.CreatePanel(\"p\")";
Debug.ShouldStop(2097152);
padash_activity.mostCurrent._p = padash_activity.mostCurrent._xui2.runMethod(false,"CreatePanel",padash_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 119;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
Debug.ShouldStop(4194304);
padash_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(padash_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),padash_activity.mostCurrent.activityBA)),(Object)(padash_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 154)))));
 BA.debugLineNum = 120;BA.debugLine="p.LoadLayout(\"item_list_list2\")";
Debug.ShouldStop(8388608);
padash_activity.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list_list2")),padash_activity.mostCurrent.activityBA);
 BA.debugLineNum = 122;BA.debugLine="cust_LV_padash.Add(p,dbCode.res.GetString(\"id\"))";
Debug.ShouldStop(33554432);
padash_activity.mostCurrent._cust_lv_padash.runVoidMethod ("_add",(Object)(padash_activity.mostCurrent._p),(Object)((padash_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 124;BA.debugLine="lbl_onvan.Text=dbCode.res.GetString(\"onvan\")";
Debug.ShouldStop(134217728);
padash_activity.mostCurrent._lbl_onvan.runMethod(true,"setText",BA.ObjectToCharSequence(padash_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("onvan")))));
 BA.debugLineNum = 126;BA.debugLine="lbl_date.Text=dbCode.res.GetString(\"date\")";
Debug.ShouldStop(536870912);
padash_activity.mostCurrent._lbl_date.runMethod(true,"setText",BA.ObjectToCharSequence(padash_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")))));
 BA.debugLineNum = 127;BA.debugLine="lbl_mablagh.Tag=dbCode.res.GetString(\"mablagh\")";
Debug.ShouldStop(1073741824);
padash_activity.mostCurrent._lbl_mablagh.runMethod(false,"setTag",(padash_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh")))));
 BA.debugLineNum = 128;BA.debugLine="lbl_mablagh.Text=myfunc.show_num_pool(lbl_mablag";
Debug.ShouldStop(-2147483648);
padash_activity.mostCurrent._lbl_mablagh.runMethod(true,"setText",BA.ObjectToCharSequence(padash_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, padash_activity.mostCurrent._lbl_mablagh.runMethod(false,"getTag"))))));
 BA.debugLineNum = 130;BA.debugLine="lbl_tozih.Text=dbCode.res.GetString(\"tozihat\")";
Debug.ShouldStop(2);
padash_activity.mostCurrent._lbl_tozih.runMethod(true,"setText",BA.ObjectToCharSequence(padash_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 132;BA.debugLine="lbl_icon.Text=Chr(0xF274)  'def";
Debug.ShouldStop(8);
padash_activity.mostCurrent._lbl_icon.runMethod(true,"setText",BA.ObjectToCharSequence(padash_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf274))))));
 BA.debugLineNum = 133;BA.debugLine="lbl_icon.Color=0xFF00A3FF";
Debug.ShouldStop(16);
padash_activity.mostCurrent._lbl_icon.runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xff00a3ff)));
 BA.debugLineNum = 135;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
Debug.ShouldStop(64);
padash_activity.mostCurrent._lbl_remove_from_list.runMethod(false,"setTag",(padash_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 136;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
Debug.ShouldStop(128);
padash_activity.mostCurrent._lbl_edit_from_list.runMethod(false,"setTag",(padash_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 }
;
 BA.debugLineNum = 143;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(16384);
padash_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 144;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(32768);
padash_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 146;BA.debugLine="If(cust_LV_padash.LastVisibleIndex<5)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("<",padash_activity.mostCurrent._cust_lv_padash.runMethod(true,"_getlastvisibleindex"),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 147;BA.debugLine="p = xui2.CreatePanel(\"p\")";
Debug.ShouldStop(262144);
padash_activity.mostCurrent._p = padash_activity.mostCurrent._xui2.runMethod(false,"CreatePanel",padash_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 148;BA.debugLine="Select cust_LV_padash.LastVisibleIndex";
Debug.ShouldStop(524288);
switch (BA.switchObjectToInt(padash_activity.mostCurrent._cust_lv_padash.runMethod(true,"_getlastvisibleindex"),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 150;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
Debug.ShouldStop(2097152);
padash_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(padash_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),padash_activity.mostCurrent.activityBA)),(Object)((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(380),RemoteObject.createImmutable(100)}, "-",1, 1))));
 break; }
case 1: {
 BA.debugLineNum = 152;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
Debug.ShouldStop(8388608);
padash_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(padash_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),padash_activity.mostCurrent.activityBA)),(Object)(padash_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400)))));
 break; }
case 2: {
 BA.debugLineNum = 154;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
Debug.ShouldStop(33554432);
padash_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(padash_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),padash_activity.mostCurrent.activityBA)),(Object)(padash_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 break; }
case 3: {
 BA.debugLineNum = 156;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
Debug.ShouldStop(134217728);
padash_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(padash_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),padash_activity.mostCurrent.activityBA)),(Object)(padash_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 break; }
case 4: {
 BA.debugLineNum = 158;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
Debug.ShouldStop(536870912);
padash_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(padash_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),padash_activity.mostCurrent.activityBA)),(Object)(padash_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 break; }
case 5: {
 BA.debugLineNum = 160;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
Debug.ShouldStop(-2147483648);
padash_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(padash_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),padash_activity.mostCurrent.activityBA)),(Object)(padash_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 break; }
}
;
 BA.debugLineNum = 162;BA.debugLine="cust_LV_padash.Add(p,\"\")";
Debug.ShouldStop(2);
padash_activity.mostCurrent._cust_lv_padash.runVoidMethod ("_add",(Object)(padash_activity.mostCurrent._p),(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 166;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
padash_activity.mostCurrent._xui2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 17;BA.debugLine="Dim p As B4XView";
padash_activity.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private pan_hed_list2 As Panel";
padash_activity.mostCurrent._pan_hed_list2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private pik_day1 As Label";
padash_activity.mostCurrent._pik_day1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private pik_moon1 As Label";
padash_activity.mostCurrent._pik_moon1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private pik_year1 As Label";
padash_activity.mostCurrent._pik_year1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim num_dataPik As Int=0  '' for time picker";
padash_activity._num_datapik = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 28;BA.debugLine="Dim moon_dataPik As List  '' for date picker";
padash_activity.mostCurrent._moon_datapik = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 30;BA.debugLine="Private lbl_onvan As Label";
padash_activity.mostCurrent._lbl_onvan = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private lbl_date As Label";
padash_activity.mostCurrent._lbl_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private lbl_mablagh As Label";
padash_activity.mostCurrent._lbl_mablagh = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private lbl_edit_from_list As Label";
padash_activity.mostCurrent._lbl_edit_from_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private lbl_remove_from_list As Label";
padash_activity.mostCurrent._lbl_remove_from_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private lbl_tozih As Label";
padash_activity.mostCurrent._lbl_tozih = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private Panel1 As Panel";
padash_activity.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private cust_LV_padash As CustomListView";
padash_activity.mostCurrent._cust_lv_padash = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 38;BA.debugLine="Private pan_all_edit1 As Panel";
padash_activity.mostCurrent._pan_all_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private pan_all_set_date As Panel";
padash_activity.mostCurrent._pan_all_set_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private lbl_title_edit1 As Label";
padash_activity.mostCurrent._lbl_title_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private et_onvan_edit1 As EditText";
padash_activity.mostCurrent._et_onvan_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private lbl_date_edit1 As Label";
padash_activity.mostCurrent._lbl_date_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private et_mablagh_edit1 As EditText";
padash_activity.mostCurrent._et_mablagh_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private et_tozih_edit1 As EditText";
padash_activity.mostCurrent._et_tozih_edit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Dim index_current_pan As Int";
padash_activity._index_current_pan = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 46;BA.debugLine="Dim current_itemId_edit As Int";
padash_activity._current_itemid_edit = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 48;BA.debugLine="Private sp_moon As Spinner";
padash_activity.mostCurrent._sp_moon = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private sp_year As Spinner";
padash_activity.mostCurrent._sp_year = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private lbl_icon As Label";
padash_activity.mostCurrent._lbl_icon = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private sp_type_state As Spinner";
padash_activity.mostCurrent._sp_type_state = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private lbl_sp_type As Label";
padash_activity.mostCurrent._lbl_sp_type = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Dim addEdit_id As Int=0";
padash_activity._addedit_id = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _item_edit_box_mod(RemoteObject _title,RemoteObject _onvan,RemoteObject _date,RemoteObject _mablage,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("item_edit_box_mod (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,231);
if (RapidSub.canDelegate("item_edit_box_mod")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","item_edit_box_mod", _title, _onvan, _date, _mablage, _tozih, _state);}
Debug.locals.put("title", _title);
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablage", _mablage);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 231;BA.debugLine="Sub item_edit_box_mod(title As String,onvan As Str";
Debug.ShouldStop(64);
 BA.debugLineNum = 234;BA.debugLine="lbl_title_edit1.Text=title";
Debug.ShouldStop(512);
padash_activity.mostCurrent._lbl_title_edit1.runMethod(true,"setText",BA.ObjectToCharSequence(_title));
 BA.debugLineNum = 235;BA.debugLine="et_onvan_edit1.Text=onvan";
Debug.ShouldStop(1024);
padash_activity.mostCurrent._et_onvan_edit1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_onvan));
 BA.debugLineNum = 236;BA.debugLine="lbl_date_edit1.Text=myfunc.fa2en(date)";
Debug.ShouldStop(2048);
padash_activity.mostCurrent._lbl_date_edit1.runMethod(true,"setText",BA.ObjectToCharSequence(padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(_date))));
 BA.debugLineNum = 237;BA.debugLine="et_mablagh_edit1.Tag=mablage";
Debug.ShouldStop(4096);
padash_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"setTag",(_mablage));
 BA.debugLineNum = 238;BA.debugLine="et_mablagh_edit1.Text=myfunc.show_num_pool(mablag";
Debug.ShouldStop(8192);
padash_activity.mostCurrent._et_mablagh_edit1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(padash_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _mablage)))));
 BA.debugLineNum = 240;BA.debugLine="et_tozih_edit1.Text=tozih";
Debug.ShouldStop(32768);
padash_activity.mostCurrent._et_tozih_edit1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_tozih));
 BA.debugLineNum = 242;BA.debugLine="If(state = 1) Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",_state,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 243;BA.debugLine="sp_type_state.SelectedIndex=0";
Debug.ShouldStop(262144);
padash_activity.mostCurrent._sp_type_state.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 }else {
 BA.debugLineNum = 245;BA.debugLine="sp_type_state.SelectedIndex=1";
Debug.ShouldStop(1048576);
padash_activity.mostCurrent._sp_type_state.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 1));
 };
 BA.debugLineNum = 248;BA.debugLine="pan_all_edit1.Visible=True";
Debug.ShouldStop(8388608);
padash_activity.mostCurrent._pan_all_edit1.runMethod(true,"setVisible",padash_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 250;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_edit1.Text.S";
Debug.ShouldStop(33554432);
padash_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(padash_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4)))))));
 BA.debugLineNum = 251;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_edit1.Text.Su";
Debug.ShouldStop(67108864);
padash_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(padash_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7)))))));
 BA.debugLineNum = 252;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(134217728);
padash_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(padash_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 253;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_edit1.Text.Su";
Debug.ShouldStop(268435456);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(padash_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 10)))))));
 BA.debugLineNum = 258;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_add_padash_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_add_padash_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,534);
if (RapidSub.canDelegate("lbl_add_padash_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","lbl_add_padash_click");}
 BA.debugLineNum = 534;BA.debugLine="Private Sub lbl_add_padash_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 536;BA.debugLine="addEdit_id=0";
Debug.ShouldStop(8388608);
padash_activity._addedit_id = BA.numberCast(int.class, 0);
 BA.debugLineNum = 537;BA.debugLine="item_edit_box_mod(\"ثبت پاداش\",\"\",myfunc.fa2en(Mai";
Debug.ShouldStop(16777216);
_item_edit_box_mod(BA.ObjectToString("ثبت پاداش"),BA.ObjectToString(""),padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(padash_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianShortDate"))),BA.ObjectToString("0"),BA.ObjectToString(""),BA.numberCast(int.class, 0));
 BA.debugLineNum = 538;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("lbl_back_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,170);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","lbl_back_click");}
 BA.debugLineNum = 170;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 171;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1024);
padash_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 172;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("lbl_date_edit1_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,299);
if (RapidSub.canDelegate("lbl_date_edit1_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","lbl_date_edit1_click");}
 BA.debugLineNum = 299;BA.debugLine="Private Sub lbl_date_edit1_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 300;BA.debugLine="pan_all_set_date.Visible=True";
Debug.ShouldStop(2048);
padash_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",padash_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 301;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("lbl_edit_from_list_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,209);
if (RapidSub.canDelegate("lbl_edit_from_list_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","lbl_edit_from_list_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 209;BA.debugLine="Private Sub lbl_edit_from_list_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 210;BA.debugLine="Dim b As Label";
Debug.ShouldStop(131072);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 211;BA.debugLine="b = Sender";
Debug.ShouldStop(262144);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), padash_activity.mostCurrent.__c.runMethod(false,"Sender",padash_activity.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 213;BA.debugLine="addEdit_id=1";
Debug.ShouldStop(1048576);
padash_activity._addedit_id = BA.numberCast(int.class, 1);
 BA.debugLineNum = 214;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(2097152);
padash_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA);
 BA.debugLineNum = 216;BA.debugLine="sp_type_state.Visible=False";
Debug.ShouldStop(8388608);
padash_activity.mostCurrent._sp_type_state.runMethod(true,"setVisible",padash_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 217;BA.debugLine="lbl_sp_type.Visible=False";
Debug.ShouldStop(16777216);
padash_activity.mostCurrent._lbl_sp_type.runMethod(true,"setVisible",padash_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 219;BA.debugLine="index_current_pan=3";
Debug.ShouldStop(67108864);
padash_activity._index_current_pan = BA.numberCast(int.class, 3);
 BA.debugLineNum = 220;BA.debugLine="current_itemId_edit=b.Tag";
Debug.ShouldStop(134217728);
padash_activity._current_itemid_edit = BA.numberCast(int.class, _b.runMethod(false,"getTag"));
 BA.debugLineNum = 221;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(268435456);
padash_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), padash_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_padash WHERE id="),padash_activity._current_itemid_edit))));
 BA.debugLineNum = 222;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(536870912);
padash_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 224;BA.debugLine="item_edit_box_mod(\"ویرایش\",dbCode.res.GetString(\"";
Debug.ShouldStop(-2147483648);
_item_edit_box_mod(BA.ObjectToString("ویرایش"),padash_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("onvan"))),padash_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date"))),padash_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))),padash_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat"))),BA.numberCast(int.class, padash_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state")))));
 BA.debugLineNum = 229;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("lbl_remove_from_list_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,183);
if (RapidSub.canDelegate("lbl_remove_from_list_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","lbl_remove_from_list_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 183;BA.debugLine="Private Sub lbl_remove_from_list_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 185;BA.debugLine="Dim b As Label";
Debug.ShouldStop(16777216);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 186;BA.debugLine="b = Sender";
Debug.ShouldStop(33554432);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), padash_activity.mostCurrent.__c.runMethod(false,"Sender",padash_activity.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 189;BA.debugLine="Dim result As Int";
Debug.ShouldStop(268435456);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 190;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
Debug.ShouldStop(536870912);
_result = padash_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا این مورد حذف شود؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((padash_activity.mostCurrent.__c.getField(false,"Null"))),padash_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 191;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, padash_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 193;BA.debugLine="If (dbCode.delete_padash(b.Tag))Then";
Debug.ShouldStop(1);
if ((padash_activity.mostCurrent._dbcode.runMethod(true,"_delete_padash" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 194;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
Debug.ShouldStop(2);
padash_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد.")),(Object)(padash_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 197;BA.debugLine="fill_list_padash(sp_year.SelectedItem,myfunc.co";
Debug.ShouldStop(16);
_fill_list_padash(padash_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),padash_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {padash_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
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
public static RemoteObject  _lbl_save_edit1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_edit1_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,275);
if (RapidSub.canDelegate("lbl_save_edit1_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","lbl_save_edit1_click");}
 BA.debugLineNum = 275;BA.debugLine="Private Sub lbl_save_edit1_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 277;BA.debugLine="If(et_onvan_edit1.Text=\"\")Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",padash_activity.mostCurrent._et_onvan_edit1.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 278;BA.debugLine="ToastMessageShow(\"عنوان خالی است!\",False)";
Debug.ShouldStop(2097152);
padash_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("عنوان خالی است!")),(Object)(padash_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 279;BA.debugLine="Else If(et_mablagh_edit1.Tag=\"\")Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",padash_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"getTag"),(RemoteObject.createImmutable(""))))) { 
 BA.debugLineNum = 280;BA.debugLine="ToastMessageShow(\"مبلغ خالی است!\",False)";
Debug.ShouldStop(8388608);
padash_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("مبلغ خالی است!")),(Object)(padash_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 283;BA.debugLine="If(addEdit_id=0)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",padash_activity._addedit_id,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 284;BA.debugLine="dbCode.add_padash(et_onvan_edit1.Text ,lbl_date";
Debug.ShouldStop(134217728);
padash_activity.mostCurrent._dbcode.runVoidMethod ("_add_padash" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(padash_activity.mostCurrent._et_onvan_edit1.runMethod(true,"getText")),(Object)(padash_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText")),(Object)(BA.ObjectToString(padash_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"getTag"))),(Object)(padash_activity.mostCurrent._et_tozih_edit1.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)));
 }else 
{ BA.debugLineNum = 286;BA.debugLine="Else If(addEdit_id=1)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",padash_activity._addedit_id,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 287;BA.debugLine="dbCode.edit_padash(current_itemId_edit,et_onvan";
Debug.ShouldStop(1073741824);
padash_activity.mostCurrent._dbcode.runVoidMethod ("_edit_padash" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(padash_activity._current_itemid_edit),(Object)(padash_activity.mostCurrent._et_onvan_edit1.runMethod(true,"getText")),(Object)(padash_activity.mostCurrent._lbl_date_edit1.runMethod(true,"getText")),(Object)(BA.ObjectToString(padash_activity.mostCurrent._et_mablagh_edit1.runMethod(false,"getTag"))),(Object)(padash_activity.mostCurrent._et_tozih_edit1.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 288;BA.debugLine="ToastMessageShow(\"ویرایش شد\",False)";
Debug.ShouldStop(-2147483648);
padash_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ویرایش شد")),(Object)(padash_activity.mostCurrent.__c.getField(true,"False")));
 }}
;
 BA.debugLineNum = 294;BA.debugLine="fill_list_padash(sp_year.SelectedItem,myfunc.con";
Debug.ShouldStop(32);
_fill_list_padash(padash_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),padash_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {padash_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 BA.debugLineNum = 295;BA.debugLine="pan_all_edit1.Visible=False";
Debug.ShouldStop(64);
padash_activity.mostCurrent._pan_all_edit1.runMethod(true,"setVisible",padash_activity.mostCurrent.__c.getField(true,"False"));
 }}
;
 BA.debugLineNum = 297;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("lbl_save_picker_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,312);
if (RapidSub.canDelegate("lbl_save_picker_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","lbl_save_picker_click");}
 BA.debugLineNum = 312;BA.debugLine="Private Sub lbl_save_picker_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 313;BA.debugLine="lbl_date_edit1.Text=pik_year1.Text&\"/\"&myfunc.con";
Debug.ShouldStop(16777216);
padash_activity.mostCurrent._lbl_date_edit1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(padash_activity.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),padash_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))),RemoteObject.createImmutable("/"),padash_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, padash_activity.mostCurrent._pik_day1.runMethod(true,"getText")))))));
 BA.debugLineNum = 314;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(33554432);
padash_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",padash_activity.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _pan_all_edit1_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_edit1_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,262);
if (RapidSub.canDelegate("pan_all_edit1_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","pan_all_edit1_click");}
 BA.debugLineNum = 262;BA.debugLine="Private Sub pan_all_edit1_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 263;BA.debugLine="pan_all_edit1.Visible=False";
Debug.ShouldStop(64);
padash_activity.mostCurrent._pan_all_edit1.runMethod(true,"setVisible",padash_activity.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _pan_all_set_date_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_set_date_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,270);
if (RapidSub.canDelegate("pan_all_set_date_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","pan_all_set_date_click");}
 BA.debugLineNum = 270;BA.debugLine="Private Sub pan_all_set_date_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 271;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(16384);
padash_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",padash_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 272;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("Panel4_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,266);
if (RapidSub.canDelegate("panel4_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","panel4_click");}
 BA.debugLineNum = 266;BA.debugLine="Private Sub Panel4_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 268;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("pik_day_bala1_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,473);
if (RapidSub.canDelegate("pik_day_bala1_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","pik_day_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 473;BA.debugLine="Private Sub pik_day_bala1_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 474;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(33554432);
_int1 = BA.numberCast(int.class, padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(padash_activity.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 475;BA.debugLine="pik_day1.Text=int1+1";
Debug.ShouldStop(67108864);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 478;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 479;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, padash_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 480;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(-2147483648);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 482;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, padash_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 483;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(4);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 486;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, padash_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 487;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(64);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 489;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, padash_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 490;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(512);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 494;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("pik_day_paeen1_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,496);
if (RapidSub.canDelegate("pik_day_paeen1_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","pik_day_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 496;BA.debugLine="Private Sub pik_day_paeen1_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 497;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(65536);
_int1 = BA.numberCast(int.class, padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(padash_activity.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 498;BA.debugLine="pik_day1.Text=int1-1";
Debug.ShouldStop(131072);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 499;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 500;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, padash_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 501;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(1048576);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 503;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, padash_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 504;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(8388608);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 507;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, padash_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 508;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(134217728);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 510;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, padash_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 511;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(1073741824);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 515;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("pik_moon_bala1_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,419);
if (RapidSub.canDelegate("pik_moon_bala1_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","pik_moon_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 419;BA.debugLine="Private Sub pik_moon_bala1_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 420;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(8);
_int1 = BA.numberCast(int.class, padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 421;BA.debugLine="pik_moon1.Tag=int1+1";
Debug.ShouldStop(16);
padash_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 423;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 424;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(128);
padash_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 426;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 427;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(1024);
padash_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 429;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(4096);
padash_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(padash_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 431;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("pik_moon_paeen1_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,433);
if (RapidSub.canDelegate("pik_moon_paeen1_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","pik_moon_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 433;BA.debugLine="Private Sub pik_moon_paeen1_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 434;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(131072);
_int1 = BA.numberCast(int.class, padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 435;BA.debugLine="pik_moon1.Tag=int1-1";
Debug.ShouldStop(262144);
padash_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 437;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 438;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(2097152);
padash_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 440;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 441;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(16777216);
padash_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 443;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
Debug.ShouldStop(67108864);
padash_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(padash_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 445;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("pik_pan_day1_Touch (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,379);
if (RapidSub.canDelegate("pik_pan_day1_touch")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","pik_pan_day1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 379;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 380;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 381;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(268435456);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 382;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(536870912);
padash_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 385;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 387;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {padash_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 388;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
Debug.ShouldStop(8);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(padash_activity.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 389;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(16);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 390;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(32);
padash_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 392;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {padash_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 393;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
Debug.ShouldStop(256);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(padash_activity.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 394;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(512);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 395;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(1024);
padash_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 398;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 399;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, padash_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 400;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(32768);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 402;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, padash_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 403;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(262144);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 406;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, padash_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 407;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(4194304);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 409;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, padash_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 410;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(33554432);
padash_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 };
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
public static RemoteObject  _pik_pan_moon1_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("pik_pan_moon1_Touch (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,319);
if (RapidSub.canDelegate("pik_pan_moon1_touch")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","pik_pan_moon1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 319;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 320;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 321;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(1);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 322;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(2);
padash_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 325;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 327;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {padash_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 328;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
Debug.ShouldStop(128);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 329;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(256);
padash_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 330;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(512);
padash_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 332;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {padash_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 333;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
Debug.ShouldStop(4096);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 334;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(8192);
padash_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 335;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(16384);
padash_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 338;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 339;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(262144);
padash_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 341;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 342;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(2097152);
padash_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 344;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(8388608);
padash_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(padash_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, padash_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 };
 BA.debugLineNum = 347;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("pik_pan_year1_Touch (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,349);
if (RapidSub.canDelegate("pik_pan_year1_touch")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","pik_pan_year1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 349;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 350;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 351;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(1073741824);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 352;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(-2147483648);
padash_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 355;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 357;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {padash_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 358;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
Debug.ShouldStop(32);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(padash_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 359;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(64);
padash_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 360;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(128);
padash_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 362;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {padash_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 363;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
Debug.ShouldStop(1024);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(padash_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 364;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(2048);
padash_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 365;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(4096);
padash_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 368;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, padash_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 369;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(65536);
padash_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 371;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, padash_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 372;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(524288);
padash_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 };
 BA.debugLineNum = 377;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("pik_year_bala1_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,447);
if (RapidSub.canDelegate("pik_year_bala1_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","pik_year_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 447;BA.debugLine="Private Sub pik_year_bala1_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 448;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(-2147483648);
_int1 = BA.numberCast(int.class, padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(padash_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 449;BA.debugLine="pik_year1.Text=int1+1";
Debug.ShouldStop(1);
padash_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 451;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, padash_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 452;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(8);
padash_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 454;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, padash_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 455;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(64);
padash_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 458;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("pik_year_paeen1_Click (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,460);
if (RapidSub.canDelegate("pik_year_paeen1_click")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","pik_year_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 460;BA.debugLine="Private Sub pik_year_paeen1_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 461;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(4096);
_int1 = BA.numberCast(int.class, padash_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(padash_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 462;BA.debugLine="pik_year1.Text=int1-1";
Debug.ShouldStop(8192);
padash_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 464;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, padash_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 465;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(65536);
padash_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 467;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, padash_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 468;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(524288);
padash_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sp_moon_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("sp_moon_ItemClick (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,528);
if (RapidSub.canDelegate("sp_moon_itemclick")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","sp_moon_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 528;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
Debug.ShouldStop(32768);
 BA.debugLineNum = 530;BA.debugLine="fill_list_padash(sp_year.SelectedItem,myfunc.conv";
Debug.ShouldStop(131072);
_fill_list_padash(padash_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),padash_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {padash_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 BA.debugLineNum = 532;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("sp_year_ItemClick (padash_activity) ","padash_activity",20,padash_activity.mostCurrent.activityBA,padash_activity.mostCurrent,520);
if (RapidSub.canDelegate("sp_year_itemclick")) { return ir.taravatgroup.ezafekari2.padash_activity.remoteMe.runUserSub(false, "padash_activity","sp_year_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 520;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
Debug.ShouldStop(128);
 BA.debugLineNum = 522;BA.debugLine="fill_list_padash(sp_year.SelectedItem,myfunc.conv";
Debug.ShouldStop(512);
_fill_list_padash(padash_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),padash_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,padash_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {padash_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 BA.debugLineNum = 526;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}