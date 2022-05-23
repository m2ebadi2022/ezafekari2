package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class dbcode_subs_0 {


public static RemoteObject  _add_ezafekari(RemoteObject _ba,RemoteObject _date1,RemoteObject _date2,RemoteObject _time1,RemoteObject _time2,RemoteObject _d,RemoteObject _h,RemoteObject _m,RemoteObject _tozih,RemoteObject _state0) throws Exception{
try {
		Debug.PushSubsStack("add_ezafekari (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,156);
if (RapidSub.canDelegate("add_ezafekari")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_ezafekari", _ba, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state0);}
;
Debug.locals.put("date1", _date1);
Debug.locals.put("date2", _date2);
Debug.locals.put("time1", _time1);
Debug.locals.put("time2", _time2);
Debug.locals.put("d", _d);
Debug.locals.put("h", _h);
Debug.locals.put("m", _m);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state0", _state0);
 BA.debugLineNum = 156;BA.debugLine="Sub add_ezafekari(date1 As String,date2 As String,";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 157;BA.debugLine="connect_db";
Debug.ShouldStop(268435456);
_connect_db(_ba);
 BA.debugLineNum = 158;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ezafekari (date";
Debug.ShouldStop(536870912);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_ezafekari (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {9},new Object[] {(_date1),(_date2),(_time1),(_time2),(_d),(_h),(_m),(_tozih),(_state0)})))));
 BA.debugLineNum = 159;BA.debugLine="sql.Close";
Debug.ShouldStop(1073741824);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 160;BA.debugLine="Return True";
Debug.ShouldStop(-2147483648);
Debug.CheckDeviceExceptions();if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 161;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_gozaresh(RemoteObject _ba,RemoteObject _date,RemoteObject _title,RemoteObject _tozih,RemoteObject _gozaresh,RemoteObject _nakhales_daryafti,RemoteObject _khales_daryafti) throws Exception{
try {
		Debug.PushSubsStack("add_gozaresh (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,209);
if (RapidSub.canDelegate("add_gozaresh")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_gozaresh", _ba, _date, _title, _tozih, _gozaresh, _nakhales_daryafti, _khales_daryafti);}
;
Debug.locals.put("date", _date);
Debug.locals.put("title", _title);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("gozaresh", _gozaresh);
Debug.locals.put("nakhales_daryafti", _nakhales_daryafti);
Debug.locals.put("khales_daryafti", _khales_daryafti);
 BA.debugLineNum = 209;BA.debugLine="Sub add_gozaresh(date As String,title As String,to";
Debug.ShouldStop(65536);
 BA.debugLineNum = 210;BA.debugLine="connect_db";
Debug.ShouldStop(131072);
_connect_db(_ba);
 BA.debugLineNum = 211;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gozareshat (dat";
Debug.ShouldStop(262144);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_gozareshat (date, title, tozih, gozaresh, nakhales_daryafti, khales_daryafti) VALUES (?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_date),(_title),(_tozih),(_gozaresh),(_nakhales_daryafti),(_khales_daryafti)})))));
 BA.debugLineNum = 212;BA.debugLine="sql.Close";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 213;BA.debugLine="Return True";
Debug.ShouldStop(1048576);
Debug.CheckDeviceExceptions();if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 214;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_morakhasi(RemoteObject _ba,RemoteObject _date1,RemoteObject _date2,RemoteObject _time1,RemoteObject _time2,RemoteObject _d,RemoteObject _h,RemoteObject _m,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("add_morakhasi (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,164);
if (RapidSub.canDelegate("add_morakhasi")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_morakhasi", _ba, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state);}
;
Debug.locals.put("date1", _date1);
Debug.locals.put("date2", _date2);
Debug.locals.put("time1", _time1);
Debug.locals.put("time2", _time2);
Debug.locals.put("d", _d);
Debug.locals.put("h", _h);
Debug.locals.put("m", _m);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 164;BA.debugLine="Sub add_morakhasi(date1 As String,date2 As String,";
Debug.ShouldStop(8);
 BA.debugLineNum = 165;BA.debugLine="connect_db";
Debug.ShouldStop(16);
_connect_db(_ba);
 BA.debugLineNum = 166;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_morakhasi (date";
Debug.ShouldStop(32);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_morakhasi (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {9},new Object[] {(_date1),(_date2),(_time1),(_time2),(_d),(_h),(_m),(_tozih),(_state)})))));
 BA.debugLineNum = 167;BA.debugLine="sql.Close";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 168;BA.debugLine="Return True";
Debug.ShouldStop(128);
Debug.CheckDeviceExceptions();if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 169;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_setting_hogog(RemoteObject _ba,RemoteObject _data) throws Exception{
try {
		Debug.PushSubsStack("add_setting_hogog (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,242);
if (RapidSub.canDelegate("add_setting_hogog")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_setting_hogog", _ba, _data);}
;
Debug.locals.put("data", _data);
 BA.debugLineNum = 242;BA.debugLine="Sub add_setting_hogog (data As List) As Boolean";
Debug.ShouldStop(131072);
 BA.debugLineNum = 243;BA.debugLine="connect_db";
Debug.ShouldStop(262144);
_connect_db(_ba);
 BA.debugLineNum = 244;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),(RemoteObject.createImmutable("paye"))})))));
 BA.debugLineNum = 245;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(1048576);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),(RemoteObject.createImmutable("hag_maskan"))})))));
 BA.debugLineNum = 246;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(2097152);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),(RemoteObject.createImmutable("hag_olad"))})))));
 BA.debugLineNum = 247;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))),(RemoteObject.createImmutable("hag_fani"))})))));
 BA.debugLineNum = 248;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(8388608);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4))),(RemoteObject.createImmutable("hag_masoliat"))})))));
 BA.debugLineNum = 249;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 5))),(RemoteObject.createImmutable("bon_karegari"))})))));
 BA.debugLineNum = 250;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(33554432);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 6))),(RemoteObject.createImmutable("darsad_bime"))})))));
 BA.debugLineNum = 251;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(67108864);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 7))),(RemoteObject.createImmutable("bime_takmili"))})))));
 BA.debugLineNum = 252;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(134217728);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 8))),(RemoteObject.createImmutable("darsad_maliat"))})))));
 BA.debugLineNum = 253;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(268435456);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 9))),(RemoteObject.createImmutable("hag_shift"))})))));
 BA.debugLineNum = 255;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(1073741824);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 10))),(RemoteObject.createImmutable("hag_sanavat"))})))));
 BA.debugLineNum = 256;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 11))),(RemoteObject.createImmutable("hag_sarparasti"))})))));
 BA.debugLineNum = 257;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 12))),(RemoteObject.createImmutable("mazaya"))})))));
 BA.debugLineNum = 258;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 14))),(RemoteObject.createImmutable("ksorat"))})))));
 BA.debugLineNum = 260;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(8);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 15))),(RemoteObject.createImmutable("saat_kar_darRoz"))})))));
 BA.debugLineNum = 265;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(256);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 13))),(RemoteObject.createImmutable("num_olad"))})))));
 BA.debugLineNum = 266;BA.debugLine="sql.Close";
Debug.ShouldStop(512);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 267;BA.debugLine="Return True";
Debug.ShouldStop(1024);
Debug.CheckDeviceExceptions();if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 268;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_setting_run(RemoteObject _ba,RemoteObject _data) throws Exception{
try {
		Debug.PushSubsStack("add_setting_run (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,280);
if (RapidSub.canDelegate("add_setting_run")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_setting_run", _ba, _data);}
;
Debug.locals.put("data", _data);
 BA.debugLineNum = 280;BA.debugLine="Sub add_setting_run (data As List) As Boolean";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 281;BA.debugLine="connect_db";
Debug.ShouldStop(16777216);
_connect_db(_ba);
 BA.debugLineNum = 282;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(33554432);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),(RemoteObject.createImmutable("sett_rial_toman"))})))));
 BA.debugLineNum = 283;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(67108864);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),(RemoteObject.createImmutable("roze_kari"))})))));
 BA.debugLineNum = 285;BA.debugLine="sql.Close";
Debug.ShouldStop(268435456);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 286;BA.debugLine="Return True";
Debug.ShouldStop(536870912);
Debug.CheckDeviceExceptions();if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 287;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_taradod(RemoteObject _ba,RemoteObject _date1,RemoteObject _date2,RemoteObject _time1,RemoteObject _time2,RemoteObject _d,RemoteObject _h,RemoteObject _m,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("add_taradod (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,171);
if (RapidSub.canDelegate("add_taradod")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_taradod", _ba, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state);}
;
Debug.locals.put("date1", _date1);
Debug.locals.put("date2", _date2);
Debug.locals.put("time1", _time1);
Debug.locals.put("time2", _time2);
Debug.locals.put("d", _d);
Debug.locals.put("h", _h);
Debug.locals.put("m", _m);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 171;BA.debugLine="Sub add_taradod (date1 As String,date2 As String,t";
Debug.ShouldStop(1024);
 BA.debugLineNum = 172;BA.debugLine="connect_db";
Debug.ShouldStop(2048);
_connect_db(_ba);
 BA.debugLineNum = 173;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_taradod (date_f";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_taradod (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat, state) VALUES (?,?,?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {9},new Object[] {(_date1),(_date2),(_time1),(_time2),(_d),(_h),(_m),(_tozih),(_state)})))));
 BA.debugLineNum = 174;BA.debugLine="sql.Close";
Debug.ShouldStop(8192);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 175;BA.debugLine="Return True";
Debug.ShouldStop(16384);
Debug.CheckDeviceExceptions();if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 176;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_ezafekari_mah(RemoteObject _ba,RemoteObject _year,RemoteObject _moon,RemoteObject _type1) throws Exception{
try {
		Debug.PushSubsStack("all_ezafekari_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,289);
if (RapidSub.canDelegate("all_ezafekari_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_ezafekari_mah", _ba, _year, _moon, _type1);}
RemoteObject _list_ez = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _v_day = RemoteObject.createImmutable(0);
RemoteObject _v_hour = RemoteObject.createImmutable(0);
RemoteObject _v_min = RemoteObject.createImmutable(0);
RemoteObject _div = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
Debug.locals.put("type1", _type1);
 BA.debugLineNum = 289;BA.debugLine="Sub all_ezafekari_mah(year As String, moon As Stri";
Debug.ShouldStop(1);
 BA.debugLineNum = 296;BA.debugLine="Dim list_ez As List";
Debug.ShouldStop(128);
_list_ez = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ez", _list_ez);
 BA.debugLineNum = 297;BA.debugLine="list_ez.Initialize";
Debug.ShouldStop(256);
_list_ez.runVoidMethod ("Initialize");
 BA.debugLineNum = 299;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(1024);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 300;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(2048);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 301;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(4096);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 302;BA.debugLine="Dim div As Int=0";
Debug.ShouldStop(8192);
_div = BA.numberCast(int.class, 0);Debug.locals.put("div", _div);Debug.locals.put("div", _div);
 BA.debugLineNum = 303;BA.debugLine="connect_db";
Debug.ShouldStop(16384);
_connect_db(_ba);
 BA.debugLineNum = 308;BA.debugLine="Select type1";
Debug.ShouldStop(524288);
switch (BA.switchObjectToInt(_type1,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 310;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
Debug.ShouldStop(2097152);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 break; }
case 1: {
 BA.debugLineNum = 312;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
Debug.ShouldStop(8388608);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' AND state=0;")))));
 break; }
case 2: {
 BA.debugLineNum = 314;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
Debug.ShouldStop(33554432);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' AND state=2;")))));
 break; }
}
;
 BA.debugLineNum = 318;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(536870912);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 320;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
Debug.ShouldStop(-2147483648);
_v_day = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_day,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))))}, "+",1, 0));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 321;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
Debug.ShouldStop(1);
_v_hour = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_hour,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))))}, "+",1, 0));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 322;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
Debug.ShouldStop(2);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 326;BA.debugLine="res.Close";
Debug.ShouldStop(32);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 327;BA.debugLine="sql.Close";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 330;BA.debugLine="If (v_min>59)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean(">",_v_min,BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 331;BA.debugLine="div=v_min/60";
Debug.ShouldStop(1024);
_div = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("div", _div);
 BA.debugLineNum = 332;BA.debugLine="v_min=v_min Mod 60";
Debug.ShouldStop(2048);
_v_min = RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("v_min", _v_min);
 };
 BA.debugLineNum = 337;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
Debug.ShouldStop(65536);
_v_hour = RemoteObject.solve(new RemoteObject[] {_v_hour,(RemoteObject.solve(new RemoteObject[] {_v_day,RemoteObject.createImmutable(24)}, "*",0, 1)),_div}, "++",2, 1);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 340;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
Debug.ShouldStop(524288);
_list_ez.runVoidMethod ("Add",(Object)((_v_hour)));
 BA.debugLineNum = 341;BA.debugLine="list_ez.Add(v_min)		'' index 1";
Debug.ShouldStop(1048576);
_list_ez.runVoidMethod ("Add",(Object)((_v_min)));
 BA.debugLineNum = 343;BA.debugLine="Return list_ez";
Debug.ShouldStop(4194304);
Debug.CheckDeviceExceptions();if (true) return _list_ez;
 BA.debugLineNum = 344;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_morakhasi_mah(RemoteObject _ba,RemoteObject _year,RemoteObject _moon) throws Exception{
try {
		Debug.PushSubsStack("all_morakhasi_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,350);
if (RapidSub.canDelegate("all_morakhasi_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_morakhasi_mah", _ba, _year, _moon);}
RemoteObject _saat_kar = RemoteObject.createImmutable(0);
RemoteObject _list_ez = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _v_day = RemoteObject.createImmutable(0);
RemoteObject _v_hour = RemoteObject.createImmutable(0);
RemoteObject _v_min = RemoteObject.createImmutable(0);
RemoteObject _div1 = RemoteObject.createImmutable(0);
RemoteObject _div2 = RemoteObject.createImmutable(0);
RemoteObject _dghige2 = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 350;BA.debugLine="Sub all_morakhasi_mah(year As String, moon As Stri";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 351;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
Debug.ShouldStop(1073741824);
_saat_kar = BA.numberCast(int.class, _get_setting_byname(_ba,RemoteObject.createImmutable("saat_kar_darRoz")));Debug.locals.put("saat_kar", _saat_kar);Debug.locals.put("saat_kar", _saat_kar);
 BA.debugLineNum = 353;BA.debugLine="Dim list_ez As List";
Debug.ShouldStop(1);
_list_ez = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ez", _list_ez);
 BA.debugLineNum = 354;BA.debugLine="list_ez.Initialize";
Debug.ShouldStop(2);
_list_ez.runVoidMethod ("Initialize");
 BA.debugLineNum = 356;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(8);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 357;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(16);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 358;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(32);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 359;BA.debugLine="Dim div1 As Int=0";
Debug.ShouldStop(64);
_div1 = BA.numberCast(int.class, 0);Debug.locals.put("div1", _div1);Debug.locals.put("div1", _div1);
 BA.debugLineNum = 360;BA.debugLine="Dim div2 As Int=0";
Debug.ShouldStop(128);
_div2 = BA.numberCast(int.class, 0);Debug.locals.put("div2", _div2);Debug.locals.put("div2", _div2);
 BA.debugLineNum = 361;BA.debugLine="connect_db";
Debug.ShouldStop(256);
_connect_db(_ba);
 BA.debugLineNum = 362;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
Debug.ShouldStop(512);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 363;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(1024);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 365;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
Debug.ShouldStop(4096);
_v_day = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_day,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))))}, "+",1, 0));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 366;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
Debug.ShouldStop(8192);
_v_hour = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_hour,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))))}, "+",1, 0));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 367;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
Debug.ShouldStop(16384);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 371;BA.debugLine="res.Close";
Debug.ShouldStop(262144);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 372;BA.debugLine="sql.Close";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 375;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
Debug.ShouldStop(4194304);
_dghige2 = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_v_day,dbcode.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_v_hour,RemoteObject.createImmutable(60)}, "*",0, 1)),_v_min}, "++",2, 1);Debug.locals.put("dghige2", _dghige2);Debug.locals.put("dghige2", _dghige2);
 BA.debugLineNum = 396;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(2048);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 397;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(4096);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 398;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(8192);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 400;BA.debugLine="Return list_ez";
Debug.ShouldStop(32768);
Debug.CheckDeviceExceptions();if (true) return _list_ez;
 BA.debugLineNum = 401;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_taradod_mah(RemoteObject _ba,RemoteObject _year,RemoteObject _moon) throws Exception{
try {
		Debug.PushSubsStack("all_taradod_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,404);
if (RapidSub.canDelegate("all_taradod_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_taradod_mah", _ba, _year, _moon);}
RemoteObject _list_ez = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _v_day = RemoteObject.createImmutable(0);
RemoteObject _v_hour = RemoteObject.createImmutable(0);
RemoteObject _v_min = RemoteObject.createImmutable(0);
RemoteObject _div = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 404;BA.debugLine="Sub all_taradod_mah(year As String, moon As String";
Debug.ShouldStop(524288);
 BA.debugLineNum = 405;BA.debugLine="Dim list_ez As List";
Debug.ShouldStop(1048576);
_list_ez = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ez", _list_ez);
 BA.debugLineNum = 406;BA.debugLine="list_ez.Initialize";
Debug.ShouldStop(2097152);
_list_ez.runVoidMethod ("Initialize");
 BA.debugLineNum = 408;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(8388608);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 409;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(16777216);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 410;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(33554432);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 411;BA.debugLine="Dim div As Int=0";
Debug.ShouldStop(67108864);
_div = BA.numberCast(int.class, 0);Debug.locals.put("div", _div);Debug.locals.put("div", _div);
 BA.debugLineNum = 412;BA.debugLine="connect_db";
Debug.ShouldStop(134217728);
_connect_db(_ba);
 BA.debugLineNum = 413;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHER";
Debug.ShouldStop(268435456);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_taradod WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 414;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(536870912);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 416;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
Debug.ShouldStop(-2147483648);
_v_day = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_day,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))))}, "+",1, 0));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 417;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
Debug.ShouldStop(1);
_v_hour = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_hour,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))))}, "+",1, 0));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 418;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
Debug.ShouldStop(2);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 422;BA.debugLine="res.Close";
Debug.ShouldStop(32);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 423;BA.debugLine="sql.Close";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 426;BA.debugLine="If (v_min>59)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean(">",_v_min,BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 427;BA.debugLine="div=v_min/60";
Debug.ShouldStop(1024);
_div = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("div", _div);
 BA.debugLineNum = 428;BA.debugLine="v_min=v_min Mod 60";
Debug.ShouldStop(2048);
_v_min = RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("v_min", _v_min);
 };
 BA.debugLineNum = 433;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
Debug.ShouldStop(65536);
_v_hour = RemoteObject.solve(new RemoteObject[] {_v_hour,(RemoteObject.solve(new RemoteObject[] {_v_day,RemoteObject.createImmutable(24)}, "*",0, 1)),_div}, "++",2, 1);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 436;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
Debug.ShouldStop(524288);
_list_ez.runVoidMethod ("Add",(Object)((_v_hour)));
 BA.debugLineNum = 437;BA.debugLine="list_ez.Add(v_min)		'' index 1";
Debug.ShouldStop(1048576);
_list_ez.runVoidMethod ("Add",(Object)((_v_min)));
 BA.debugLineNum = 439;BA.debugLine="Return list_ez";
Debug.ShouldStop(4194304);
Debug.CheckDeviceExceptions();if (true) return _list_ez;
 BA.debugLineNum = 440;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cheng_tagvim(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("cheng_tagvim (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,83);
if (RapidSub.canDelegate("cheng_tagvim")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","cheng_tagvim", _ba);}
;
 BA.debugLineNum = 83;BA.debugLine="Sub cheng_tagvim";
Debug.ShouldStop(262144);
 BA.debugLineNum = 84;BA.debugLine="connect_db";
Debug.ShouldStop(524288);
_connect_db(_ba);
 BA.debugLineNum = 86;BA.debugLine="Try";
Debug.ShouldStop(2097152);
try { BA.debugLineNum = 88;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
Debug.ShouldStop(8388608);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id=1141"))));
 BA.debugLineNum = 89;BA.debugLine="res.Position=0";
Debug.ShouldStop(16777216);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 92;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("tatil")))) { 
 }else {
 BA.debugLineNum = 96;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='شهادت استاد مرتضی مطهری، روزمعلم' WHERE id=1139 ")));
 BA.debugLineNum = 97;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat=' عید سعید فطر' WHERE id=1141 ")));
 };
 BA.debugLineNum = 99;BA.debugLine="res.Close";
Debug.ShouldStop(4);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 101;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
Debug.ShouldStop(16);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id=1163"))));
 BA.debugLineNum = 102;BA.debugLine="res.Position=0";
Debug.ShouldStop(32);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 104;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("tatil")))) { 
 BA.debugLineNum = 105;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(256);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1163 ")));
 BA.debugLineNum = 106;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(512);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام جعفر صادق علیه السلام' WHERE id=1164 ")));
 BA.debugLineNum = 108;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil' WHERE id=1216 ")));
 BA.debugLineNum = 109;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil' WHERE id=1285 ")));
 BA.debugLineNum = 110;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(8192);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil' WHERE id=1287 ")));
 };
 BA.debugLineNum = 114;BA.debugLine="res.Close";
Debug.ShouldStop(131072);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e22) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e22.toString()); BA.debugLineNum = 118;BA.debugLine="Log(\"error\")";
Debug.ShouldStop(2097152);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","37733283",RemoteObject.createImmutable("error"),0);
 };
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
public static RemoteObject  _connect_db(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("connect_db (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,14);
if (RapidSub.canDelegate("connect_db")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","connect_db", _ba);}
;
 BA.debugLineNum = 14;BA.debugLine="Sub connect_db";
Debug.ShouldStop(8192);
 BA.debugLineNum = 15;BA.debugLine="If File.Exists(File.DirInternal,\"db.db\") = False";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",dbcode.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(dbcode.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("db.db"))),dbcode.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 16;BA.debugLine="File.Copy(File.DirAssets,\"db.db\",File.DirInterna";
Debug.ShouldStop(32768);
dbcode.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(dbcode.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("db.db")),(Object)(dbcode.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("db.db")));
 };
 BA.debugLineNum = 18;BA.debugLine="sql.Initialize(File.DirInternal,\"db.db\",True)";
Debug.ShouldStop(131072);
dbcode._sql.runVoidMethod ("Initialize",(Object)(dbcode.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("db.db")),(Object)(dbcode.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 20;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _delete_ezafekari(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("delete_ezafekari (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,216);
if (RapidSub.canDelegate("delete_ezafekari")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_ezafekari", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 216;BA.debugLine="Sub delete_ezafekari(id As Int) As Boolean";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 217;BA.debugLine="connect_db";
Debug.ShouldStop(16777216);
_connect_db(_ba);
 BA.debugLineNum = 218;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ezafekari WHERE";
Debug.ShouldStop(33554432);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_ezafekari WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 219;BA.debugLine="sql.Close";
Debug.ShouldStop(67108864);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 220;BA.debugLine="Return True";
Debug.ShouldStop(134217728);
Debug.CheckDeviceExceptions();if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 221;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _delete_gozaresh(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("delete_gozaresh (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,234);
if (RapidSub.canDelegate("delete_gozaresh")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_gozaresh", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 234;BA.debugLine="Sub delete_gozaresh(id As Int) As Boolean";
Debug.ShouldStop(512);
 BA.debugLineNum = 235;BA.debugLine="connect_db";
Debug.ShouldStop(1024);
_connect_db(_ba);
 BA.debugLineNum = 236;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_gozareshat WHER";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_gozareshat WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 237;BA.debugLine="sql.Close";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 238;BA.debugLine="Return True";
Debug.ShouldStop(8192);
Debug.CheckDeviceExceptions();if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 239;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _delete_morakhasi(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("delete_morakhasi (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,222);
if (RapidSub.canDelegate("delete_morakhasi")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_morakhasi", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 222;BA.debugLine="Sub delete_morakhasi(id As Int) As Boolean";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 223;BA.debugLine="connect_db";
Debug.ShouldStop(1073741824);
_connect_db(_ba);
 BA.debugLineNum = 224;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_morakhasi WHERE";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_morakhasi WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 225;BA.debugLine="sql.Close";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 226;BA.debugLine="Return True";
Debug.ShouldStop(2);
Debug.CheckDeviceExceptions();if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 227;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _delete_taradod(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("delete_taradod (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,228);
if (RapidSub.canDelegate("delete_taradod")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_taradod", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 228;BA.debugLine="Sub delete_taradod(id As Int) As Boolean";
Debug.ShouldStop(8);
 BA.debugLineNum = 229;BA.debugLine="connect_db";
Debug.ShouldStop(16);
_connect_db(_ba);
 BA.debugLineNum = 230;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_taradod WHERE i";
Debug.ShouldStop(32);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_taradod WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 231;BA.debugLine="sql.Close";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 232;BA.debugLine="Return True";
Debug.ShouldStop(128);
Debug.CheckDeviceExceptions();if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 233;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edit_ezafekari(RemoteObject _ba,RemoteObject _id1,RemoteObject _date1,RemoteObject _date2,RemoteObject _time1,RemoteObject _time2,RemoteObject _d,RemoteObject _h,RemoteObject _m,RemoteObject _tozih,RemoteObject _state0) throws Exception{
try {
		Debug.PushSubsStack("edit_ezafekari (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,182);
if (RapidSub.canDelegate("edit_ezafekari")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_ezafekari", _ba, _id1, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state0);}
;
Debug.locals.put("id1", _id1);
Debug.locals.put("date1", _date1);
Debug.locals.put("date2", _date2);
Debug.locals.put("time1", _time1);
Debug.locals.put("time2", _time2);
Debug.locals.put("d", _d);
Debug.locals.put("h", _h);
Debug.locals.put("m", _m);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state0", _state0);
 BA.debugLineNum = 182;BA.debugLine="Sub edit_ezafekari(id1 As Int, date1 As String,dat";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 183;BA.debugLine="connect_db";
Debug.ShouldStop(4194304);
_connect_db(_ba);
 BA.debugLineNum = 184;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET date_f";
Debug.ShouldStop(8388608);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_ezafekari SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {10},new Object[] {(_date1),(_date2),(_time1),(_time2),(_d),(_h),(_m),(_tozih),(_state0),(_id1)})))));
 BA.debugLineNum = 185;BA.debugLine="sql.Close";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 186;BA.debugLine="Return True";
Debug.ShouldStop(33554432);
Debug.CheckDeviceExceptions();if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 187;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edit_morakhasi(RemoteObject _ba,RemoteObject _id1,RemoteObject _date1,RemoteObject _date2,RemoteObject _time1,RemoteObject _time2,RemoteObject _d,RemoteObject _h,RemoteObject _m,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("edit_morakhasi (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,190);
if (RapidSub.canDelegate("edit_morakhasi")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_morakhasi", _ba, _id1, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state);}
;
Debug.locals.put("id1", _id1);
Debug.locals.put("date1", _date1);
Debug.locals.put("date2", _date2);
Debug.locals.put("time1", _time1);
Debug.locals.put("time2", _time2);
Debug.locals.put("d", _d);
Debug.locals.put("h", _h);
Debug.locals.put("m", _m);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 190;BA.debugLine="Sub edit_morakhasi(id1 As Int,date1 As String,date";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 191;BA.debugLine="connect_db";
Debug.ShouldStop(1073741824);
_connect_db(_ba);
 BA.debugLineNum = 192;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET date_f";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_morakhasi SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {10},new Object[] {(_date1),(_date2),(_time1),(_time2),(_d),(_h),(_m),(_tozih),(_state),(_id1)})))));
 BA.debugLineNum = 193;BA.debugLine="sql.Close";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 194;BA.debugLine="Return True";
Debug.ShouldStop(2);
Debug.CheckDeviceExceptions();if (true) return dbcode.mostCurrent.__c.getField(true,"True");
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
public static RemoteObject  _edit_taradod(RemoteObject _ba,RemoteObject _id1,RemoteObject _date1,RemoteObject _date2,RemoteObject _time1,RemoteObject _time2,RemoteObject _d,RemoteObject _h,RemoteObject _m,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("edit_taradod (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,197);
if (RapidSub.canDelegate("edit_taradod")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_taradod", _ba, _id1, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state);}
;
Debug.locals.put("id1", _id1);
Debug.locals.put("date1", _date1);
Debug.locals.put("date2", _date2);
Debug.locals.put("time1", _time1);
Debug.locals.put("time2", _time2);
Debug.locals.put("d", _d);
Debug.locals.put("h", _h);
Debug.locals.put("m", _m);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 197;BA.debugLine="Sub edit_taradod (id1 As Int,date1 As String,date2";
Debug.ShouldStop(16);
 BA.debugLineNum = 198;BA.debugLine="connect_db";
Debug.ShouldStop(32);
_connect_db(_ba);
 BA.debugLineNum = 199;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET date_fro";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_taradod SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =? ,state=?  WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {10},new Object[] {(_date1),(_date2),(_time1),(_time2),(_d),(_h),(_m),(_tozih),(_state),(_id1)})))));
 BA.debugLineNum = 200;BA.debugLine="sql.Close";
Debug.ShouldStop(128);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 201;BA.debugLine="Return True";
Debug.ShouldStop(256);
Debug.CheckDeviceExceptions();if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 202;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_day_id(RemoteObject _ba,RemoteObject _year,RemoteObject _moon,RemoteObject _day) throws Exception{
try {
		Debug.PushSubsStack("get_day_id (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,533);
if (RapidSub.canDelegate("get_day_id")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","get_day_id", _ba, _year, _moon, _day);}
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
Debug.locals.put("day", _day);
 BA.debugLineNum = 533;BA.debugLine="Sub get_day_id (year As Int, moon As Int , day As";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 534;BA.debugLine="Try";
Debug.ShouldStop(2097152);
try { BA.debugLineNum = 536;BA.debugLine="connect_db";
Debug.ShouldStop(8388608);
_connect_db(_ba);
 BA.debugLineNum = 537;BA.debugLine="res =  sql.ExecQuery(\"SELECT * FROM 'my_calander";
Debug.ShouldStop(16777216);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE year="),_year,RemoteObject.createImmutable(" AND moon="),_moon,RemoteObject.createImmutable(" AND day_c="),_day))));
 BA.debugLineNum = 540;BA.debugLine="If(res.RowCount>0)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 541;BA.debugLine="res.Position = 0";
Debug.ShouldStop(268435456);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 542;BA.debugLine="Return res.GetInt(\"id\")";
Debug.ShouldStop(536870912);
Debug.CheckDeviceExceptions();if (true) return dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id")));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e9.toString()); BA.debugLineNum = 548;BA.debugLine="Log(LastException)";
Debug.ShouldStop(8);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","39306127",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 551;BA.debugLine="Return -1";
Debug.ShouldStop(64);
Debug.CheckDeviceExceptions();if (true) return BA.numberCast(int.class, -(double) (0 + 1));
 BA.debugLineNum = 553;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_setting_byname(RemoteObject _ba,RemoteObject _name1) throws Exception{
try {
		Debug.PushSubsStack("get_setting_byName (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,270);
if (RapidSub.canDelegate("get_setting_byname")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","get_setting_byname", _ba, _name1);}
;
Debug.locals.put("name1", _name1);
 BA.debugLineNum = 270;BA.debugLine="Sub get_setting_byName (name1 As String) As String";
Debug.ShouldStop(8192);
 BA.debugLineNum = 271;BA.debugLine="connect_db";
Debug.ShouldStop(16384);
_connect_db(_ba);
 BA.debugLineNum = 272;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
Debug.ShouldStop(32768);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_setting WHERE name='"),_name1,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 273;BA.debugLine="res.Position=0 ''--------saat  kari dar roz -----";
Debug.ShouldStop(65536);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 277;BA.debugLine="Return res.GetString(\"value\")";
Debug.ShouldStop(1048576);
Debug.CheckDeviceExceptions();if (true) return dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")));
 BA.debugLineNum = 278;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _init_notfound(RemoteObject _ba,RemoteObject _rowname,RemoteObject _val) throws Exception{
try {
		Debug.PushSubsStack("init_notfound (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,146);
if (RapidSub.canDelegate("init_notfound")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","init_notfound", _ba, _rowname, _val);}
;
Debug.locals.put("rowname", _rowname);
Debug.locals.put("val", _val);
 BA.debugLineNum = 146;BA.debugLine="Sub init_notfound (rowname As String , val As Stri";
Debug.ShouldStop(131072);
 BA.debugLineNum = 147;BA.debugLine="connect_db";
Debug.ShouldStop(262144);
_connect_db(_ba);
 BA.debugLineNum = 148;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
Debug.ShouldStop(524288);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_setting WHERE name='"),_rowname,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 150;BA.debugLine="If(res.RowCount=0)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 151;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_setting (name,";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_setting (name, value) VALUES ( ?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_rowname),(_val)})))));
 };
 BA.debugLineNum = 153;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _insert_calander_exl(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("insert_calander_exl (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,124);
if (RapidSub.canDelegate("insert_calander_exl")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","insert_calander_exl", _ba);}
int _row = 0;
;
 BA.debugLineNum = 124;BA.debugLine="Sub insert_calander_exl";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 125;BA.debugLine="ProgressDialogShow(\"دریافت اطلاعات...\")";
Debug.ShouldStop(268435456);
dbcode.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",_ba,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("دریافت اطلاعات..."))));
 BA.debugLineNum = 126;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 127;BA.debugLine="Workbook1.Initialize(File.DirAssets,\"my_calander";
Debug.ShouldStop(1073741824);
dbcode._workbook1.runVoidMethod ("Initialize",(Object)(dbcode.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("my_calander.xls")));
 BA.debugLineNum = 128;BA.debugLine="Sheet1 = Workbook1.GetSheet(0)";
Debug.ShouldStop(-2147483648);
dbcode._sheet1 = dbcode._workbook1.runMethod(false,"GetSheet",(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 130;BA.debugLine="For row = 1 To Sheet1.RowsCount - 1";
Debug.ShouldStop(2);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {dbcode._sheet1.runMethod(true,"getRowsCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_row = 1 ;
for (;(step5 > 0 && _row <= limit5) || (step5 < 0 && _row >= limit5) ;_row = ((int)(0 + _row + step5))  ) {
Debug.locals.put("row", _row);
 BA.debugLineNum = 132;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO 'my_calander' ('";
Debug.ShouldStop(8);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO 'my_calander' ('id', 'year', 'key', 'moon', 'day_c', 'day_h', 'monasebat', 'state', 'shift', 'note') VALUES (?, ?, ?, ?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {10},new Object[] {(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 4)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 6)),(Object)(BA.numberCast(int.class, _row)))),(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 7)),(Object)(BA.numberCast(int.class, _row)))),RemoteObject.createImmutable(("")),(RemoteObject.createImmutable(""))})))));
 }
}Debug.locals.put("row", _row);
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e9.toString()); BA.debugLineNum = 135;BA.debugLine="ToastMessageShow(\"error date loading\",True)";
Debug.ShouldStop(64);
dbcode.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("error date loading")),(Object)(dbcode.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 140;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(2048);
dbcode.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _install_db_tbl_mycalander(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("install_db_tbl_myCalander (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,36);
if (RapidSub.canDelegate("install_db_tbl_mycalander")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","install_db_tbl_mycalander", _ba);}
;
 BA.debugLineNum = 36;BA.debugLine="Sub install_db_tbl_myCalander";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="connect_db";
Debug.ShouldStop(16);
_connect_db(_ba);
 BA.debugLineNum = 38;BA.debugLine="Try";
Debug.ShouldStop(32);
try { BA.debugLineNum = 39;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'my_calander";
Debug.ShouldStop(64);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT id FROM 'my_calander' WHERE id=1"))));
 BA.debugLineNum = 40;BA.debugLine="Log( \"tbl my_calander exist\")";
Debug.ShouldStop(128);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","37602180",RemoteObject.createImmutable("tbl my_calander exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e6.toString()); BA.debugLineNum = 42;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'my_calander' ('i";
Debug.ShouldStop(512);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'my_calander' ('id' INTEGER,'year'	INTEGER,'key' INTEGER,'moon' INTEGER,'day_c' INTEGER,'day_h' INTEGER,'monasebat' TEXT,'state'	TEXT,'shift' TEXT,'note' TEXT)")));
 BA.debugLineNum = 44;BA.debugLine="insert_calander_exl";
Debug.ShouldStop(2048);
_insert_calander_exl(_ba);
 BA.debugLineNum = 45;BA.debugLine="Log ( \"tbl myCalander created\")";
Debug.ShouldStop(4096);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","37602185",RemoteObject.createImmutable("tbl myCalander created"),0);
 };
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _install_db_tbl_onvanha(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("install_db_tbl_onvanha (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,50);
if (RapidSub.canDelegate("install_db_tbl_onvanha")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","install_db_tbl_onvanha", _ba);}
;
 BA.debugLineNum = 50;BA.debugLine="Sub install_db_tbl_onvanha";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="connect_db";
Debug.ShouldStop(262144);
_connect_db(_ba);
 BA.debugLineNum = 52;BA.debugLine="Try";
Debug.ShouldStop(524288);
try { BA.debugLineNum = 53;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'tbl_onvanha";
Debug.ShouldStop(1048576);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT id FROM 'tbl_onvanha' WHERE id=1"))));
 BA.debugLineNum = 54;BA.debugLine="Log( \"tbl tbl_onvanha exist\")";
Debug.ShouldStop(2097152);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","37667716",RemoteObject.createImmutable("tbl tbl_onvanha exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e6.toString()); BA.debugLineNum = 56;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tbl_onvanha' ('i";
Debug.ShouldStop(8388608);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tbl_onvanha' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'name' TEXT,'def_name' TEXT,'custom_name' TEXT);")));
 BA.debugLineNum = 59;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(67108864);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('1', 'paye', 'پایه حقوق', 'پایه حقوق');")));
 BA.debugLineNum = 60;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(134217728);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('2', 'sanavat', 'حق سنوات','حق سنوات');")));
 BA.debugLineNum = 61;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(268435456);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('3', 'maskan', 'حق مسکن','حق مسکن');")));
 BA.debugLineNum = 62;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(536870912);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('4', 'bon', 'بن کارگری','بن کارگری');")));
 BA.debugLineNum = 63;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(1073741824);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('5', 'olad',  'حق اولاد','حق اولاد');")));
 BA.debugLineNum = 64;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('6', 'fani',  'حق فنی','حق فنی');")));
 BA.debugLineNum = 65;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('7', 'masoliat',  'حق مسئولیت','حق مسئولیت');")));
 BA.debugLineNum = 66;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('8', 'sarparasti', 'حق سرپرستی','حق سرپرستی');")));
 BA.debugLineNum = 67;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(4);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('9', 'shift',  'درصد حق شیفت(%)','درصد حق شیفت(%)');")));
 BA.debugLineNum = 68;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(8);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('10', 'takmili',  'بیمه تکمیلی','بیمه تکمیلی');")));
 BA.debugLineNum = 69;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(16);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('11', 'mazaya',  'سایر مزایا','سایر مزایا');")));
 BA.debugLineNum = 70;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(32);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('12', 'kosorat',  'سایر کسورات','سایر کسورات');")));
 BA.debugLineNum = 71;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('13', 'saatKar',  'ساعت کاری در روز','ساعت کاری در روز');")));
 BA.debugLineNum = 75;BA.debugLine="Log ( \"tbl tbl_onvanha created\")";
Debug.ShouldStop(1024);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","37667737",RemoteObject.createImmutable("tbl tbl_onvanha created"),0);
 };
 BA.debugLineNum = 77;BA.debugLine="sql.Close";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _install_db_tbl_taradod(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("install_db_tbl_taradod (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,21);
if (RapidSub.canDelegate("install_db_tbl_taradod")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","install_db_tbl_taradod", _ba);}
;
 BA.debugLineNum = 21;BA.debugLine="Sub install_db_tbl_taradod";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 22;BA.debugLine="connect_db";
Debug.ShouldStop(2097152);
_connect_db(_ba);
 BA.debugLineNum = 24;BA.debugLine="Try";
Debug.ShouldStop(8388608);
try { BA.debugLineNum = 25;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod\")";
Debug.ShouldStop(16777216);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_taradod"))));
 BA.debugLineNum = 26;BA.debugLine="Log( \"tbl taradod exist\")";
Debug.ShouldStop(33554432);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","37536645",RemoteObject.createImmutable("tbl taradod exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e6.toString()); BA.debugLineNum = 29;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_taradod' ( 'i";
Debug.ShouldStop(268435456);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_taradod' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 31;BA.debugLine="Log ( \"tbl taradod created\")";
Debug.ShouldStop(1073741824);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","37536650",RemoteObject.createImmutable("tbl taradod created"),0);
 };
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _isexist_ezafekari_by_date(RemoteObject _ba,RemoteObject _date) throws Exception{
try {
		Debug.PushSubsStack("isexist_ezafekari_by_date (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,447);
if (RapidSub.canDelegate("isexist_ezafekari_by_date")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","isexist_ezafekari_by_date", _ba, _date);}
RemoteObject _chk1 = RemoteObject.createImmutable(false);
;
Debug.locals.put("date", _date);
 BA.debugLineNum = 447;BA.debugLine="Sub isexist_ezafekari_by_date(date As String) As B";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 448;BA.debugLine="Try";
Debug.ShouldStop(-2147483648);
try { BA.debugLineNum = 449;BA.debugLine="Dim chk1 As Boolean=False";
Debug.ShouldStop(1);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);Debug.locals.put("chk1", _chk1);
 BA.debugLineNum = 450;BA.debugLine="connect_db";
Debug.ShouldStop(2);
_connect_db(_ba);
 BA.debugLineNum = 451;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari W";
Debug.ShouldStop(4);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"),_date,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 452;BA.debugLine="If (res.RowCount>0)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 453;BA.debugLine="chk1= True";
Debug.ShouldStop(16);
_chk1 = dbcode.mostCurrent.__c.getField(true,"True");Debug.locals.put("chk1", _chk1);
 }else {
 BA.debugLineNum = 455;BA.debugLine="chk1= False";
Debug.ShouldStop(64);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);
 };
 BA.debugLineNum = 457;BA.debugLine="res.Close";
Debug.ShouldStop(256);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e12.toString()); BA.debugLineNum = 459;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1024);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","39043980",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 462;BA.debugLine="Return chk1";
Debug.ShouldStop(8192);
Debug.CheckDeviceExceptions();if (true) return _chk1;
 BA.debugLineNum = 465;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _isexist_morakhasi_by_date(RemoteObject _ba,RemoteObject _date) throws Exception{
try {
		Debug.PushSubsStack("isexist_morakhasi_by_date (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,467);
if (RapidSub.canDelegate("isexist_morakhasi_by_date")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","isexist_morakhasi_by_date", _ba, _date);}
RemoteObject _chk1 = RemoteObject.createImmutable(false);
;
Debug.locals.put("date", _date);
 BA.debugLineNum = 467;BA.debugLine="Sub isexist_morakhasi_by_date(date As String) As B";
Debug.ShouldStop(262144);
 BA.debugLineNum = 468;BA.debugLine="Try";
Debug.ShouldStop(524288);
try { BA.debugLineNum = 469;BA.debugLine="Dim chk1 As Boolean=False";
Debug.ShouldStop(1048576);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);Debug.locals.put("chk1", _chk1);
 BA.debugLineNum = 470;BA.debugLine="connect_db";
Debug.ShouldStop(2097152);
_connect_db(_ba);
 BA.debugLineNum = 471;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi W";
Debug.ShouldStop(4194304);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"),_date,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 472;BA.debugLine="If (res.RowCount>0)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 473;BA.debugLine="chk1= True";
Debug.ShouldStop(16777216);
_chk1 = dbcode.mostCurrent.__c.getField(true,"True");Debug.locals.put("chk1", _chk1);
 }else {
 BA.debugLineNum = 475;BA.debugLine="chk1= False";
Debug.ShouldStop(67108864);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);
 };
 BA.debugLineNum = 477;BA.debugLine="res.Close";
Debug.ShouldStop(268435456);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e12.toString()); BA.debugLineNum = 479;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1073741824);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","39109516",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 482;BA.debugLine="Return chk1";
Debug.ShouldStop(2);
Debug.CheckDeviceExceptions();if (true) return _chk1;
 BA.debugLineNum = 483;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _isexist_taradod_by_date(RemoteObject _ba,RemoteObject _date) throws Exception{
try {
		Debug.PushSubsStack("isexist_taradod_by_date (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,485);
if (RapidSub.canDelegate("isexist_taradod_by_date")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","isexist_taradod_by_date", _ba, _date);}
RemoteObject _chk1 = RemoteObject.createImmutable(false);
;
Debug.locals.put("date", _date);
 BA.debugLineNum = 485;BA.debugLine="Sub isexist_taradod_by_date(date As String) As Boo";
Debug.ShouldStop(16);
 BA.debugLineNum = 486;BA.debugLine="Try";
Debug.ShouldStop(32);
try { BA.debugLineNum = 487;BA.debugLine="Dim chk1 As Boolean=False";
Debug.ShouldStop(64);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);Debug.locals.put("chk1", _chk1);
 BA.debugLineNum = 488;BA.debugLine="connect_db";
Debug.ShouldStop(128);
_connect_db(_ba);
 BA.debugLineNum = 489;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHE";
Debug.ShouldStop(256);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_taradod WHERE date_from LIKE '"),_date,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 490;BA.debugLine="If (res.RowCount>0)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 491;BA.debugLine="chk1= True";
Debug.ShouldStop(1024);
_chk1 = dbcode.mostCurrent.__c.getField(true,"True");Debug.locals.put("chk1", _chk1);
 }else {
 BA.debugLineNum = 493;BA.debugLine="chk1= False";
Debug.ShouldStop(4096);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);
 };
 BA.debugLineNum = 495;BA.debugLine="res.Close";
Debug.ShouldStop(16384);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e12.toString()); BA.debugLineNum = 497;BA.debugLine="Log(LastException)";
Debug.ShouldStop(65536);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","39175052",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 499;BA.debugLine="Return chk1";
Debug.ShouldStop(262144);
Debug.CheckDeviceExceptions();if (true) return _chk1;
 BA.debugLineNum = 502;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _istatil_by_date(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("istatil_by_date (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,507);
if (RapidSub.canDelegate("istatil_by_date")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","istatil_by_date", _ba, _id);}
RemoteObject _chk1 = RemoteObject.createImmutable(false);
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 507;BA.debugLine="Sub istatil_by_date(id As Int) As Boolean";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 509;BA.debugLine="Try";
Debug.ShouldStop(268435456);
try { BA.debugLineNum = 510;BA.debugLine="Dim chk1 As Boolean=False";
Debug.ShouldStop(536870912);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);Debug.locals.put("chk1", _chk1);
 BA.debugLineNum = 511;BA.debugLine="connect_db";
Debug.ShouldStop(1073741824);
_connect_db(_ba);
 BA.debugLineNum = 512;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM 'my_calander'";
Debug.ShouldStop(-2147483648);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id="),_id))));
 BA.debugLineNum = 513;BA.debugLine="If(res.RowCount>0)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 514;BA.debugLine="res.Position=0";
Debug.ShouldStop(2);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 515;BA.debugLine="If (res.GetString(\"state\")=\"tatil\")Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("tatil")))) { 
 BA.debugLineNum = 516;BA.debugLine="chk1= True";
Debug.ShouldStop(8);
_chk1 = dbcode.mostCurrent.__c.getField(true,"True");Debug.locals.put("chk1", _chk1);
 };
 };
 BA.debugLineNum = 520;BA.debugLine="res.Close";
Debug.ShouldStop(128);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e13) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e13.toString()); BA.debugLineNum = 522;BA.debugLine="Log(LastException)";
Debug.ShouldStop(512);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","39240591",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 525;BA.debugLine="Return chk1";
Debug.ShouldStop(4096);
Debug.CheckDeviceExceptions();if (true) return _chk1;
 BA.debugLineNum = 527;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Dim sql As SQL";
dbcode._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 7;BA.debugLine="Dim res As ResultSet";
dbcode._res = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
 //BA.debugLineNum = 9;BA.debugLine="Private Workbook1 As ReadableWorkbook";
dbcode._workbook1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.WorkbookWrapper");
 //BA.debugLineNum = 10;BA.debugLine="Private Sheet1 As ReadableSheet";
dbcode._sheet1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.WorkbookWrapper.SheetWrapper");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _read_onvan_db(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("read_onvan_db (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,557);
if (RapidSub.canDelegate("read_onvan_db")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","read_onvan_db", _ba);}
RemoteObject _onvanha = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
;
 BA.debugLineNum = 557;BA.debugLine="Sub read_onvan_db As List";
Debug.ShouldStop(4096);
 BA.debugLineNum = 558;BA.debugLine="Dim onvanHa As List";
Debug.ShouldStop(8192);
_onvanha = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("onvanHa", _onvanha);
 BA.debugLineNum = 559;BA.debugLine="onvanHa.Initialize";
Debug.ShouldStop(16384);
_onvanha.runVoidMethod ("Initialize");
 BA.debugLineNum = 561;BA.debugLine="connect_db";
Debug.ShouldStop(65536);
_connect_db(_ba);
 BA.debugLineNum = 562;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha\")";
Debug.ShouldStop(131072);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tbl_onvanha"))));
 BA.debugLineNum = 564;BA.debugLine="For i=0 To res.RowCount-1";
Debug.ShouldStop(524288);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {dbcode._res.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 565;BA.debugLine="res.Position=i";
Debug.ShouldStop(1048576);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 566;BA.debugLine="onvanHa.Add(res.GetString(\"custom_name\"))";
Debug.ShouldStop(2097152);
_onvanha.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("custom_name"))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 568;BA.debugLine="res.Close";
Debug.ShouldStop(8388608);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 569;BA.debugLine="sql.Close";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 571;BA.debugLine="Return onvanHa";
Debug.ShouldStop(67108864);
Debug.CheckDeviceExceptions();if (true) return _onvanha;
 BA.debugLineNum = 572;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}